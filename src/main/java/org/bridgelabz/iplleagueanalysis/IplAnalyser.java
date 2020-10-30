package org.bridgelabz.iplleagueanalysis;

import CSVBuilder.CSVBuilderException;
import CSVBuilder.CSVBuilderFactory;
import CSVBuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;


public class IplAnalyser {
	List<IplBatsman> iplBatsmanList= new ArrayList<>();
	List<IplBowler> iplCsvBowlerList = new ArrayList<>();
	List<IplAllRounder>iplAllRounderList = new ArrayList<>();
	public int loadCricketIPL2019BatsmanData(String csvFilePath) throws IplAnalyserException 
	{
		 try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
	            ICSVBuilder csvbuilder = CSVBuilderFactory.createCSVBuilder();
	            iplBatsmanList= csvbuilder.getCSVFileList(reader, IplBatsman.class);
	            return iplBatsmanList.size();

	        }
		 	catch (IOException e) {
	            throw new IplAnalyserException(e.getMessage(),IplAnalyserException.ExceptionType.DATA_NOT_FOUND);
	        } 
		 	catch (RuntimeException e) {
	            throw new IplAnalyserException(e.getMessage(), IplAnalyserException.ExceptionType.FILE_ISSUE);
	        } 
		 	catch (CSVBuilderException e) {
	            e.printStackTrace();
	        }
	        return 0;
    }
	public String getSortedIPLBattingRecords(SortingField.Field field) throws IplAnalyserException 
	 {
	        if (iplBatsmanList== null || iplBatsmanList.size() == 0) {
	            throw new IplAnalyserException("No Census Data", IplAnalyserException.ExceptionType.DATA_NOT_FOUND);
	        }
	        Comparator<IplBatsman> iplFieldComparator = SortingField.getComparatorField(field);
	        iplBatsmanList.sort(iplFieldComparator);
	        iplBatsmanList.forEach(System.out::println);
	        return new Gson().toJson(iplBatsmanList);
	    }
	public int loadCricketIPL2019BowlerData(String csvBowlerFilePath) throws IplAnalyserException 
	{
		 try (Reader reader = Files.newBufferedReader(Paths.get(csvBowlerFilePath));) {
	            ICSVBuilder csvbuilder = CSVBuilderFactory.createCSVBuilder();
	            iplCsvBowlerList= csvbuilder.getCSVFileList(reader, IplBowler.class);
	            return iplCsvBowlerList.size();

	        }
		 	catch (IOException e) {
	            throw new IplAnalyserException(e.getMessage(),IplAnalyserException.ExceptionType.DATA_NOT_FOUND);
	        } 
		 	catch (RuntimeException e) {
	            throw new IplAnalyserException(e.getMessage(), IplAnalyserException.ExceptionType.FILE_ISSUE);
	        } 
		 	catch (CSVBuilderException e) {
	            e.printStackTrace();
	        }
	        return 0;
    }
	public String getSortedIPLBowlingRecords(SortingField.Field field) throws IplAnalyserException 
	 {
	        if (iplCsvBowlerList == null || iplCsvBowlerList.size() == 0) {
	            throw new IplAnalyserException("No Census Data", IplAnalyserException.ExceptionType.DATA_NOT_FOUND);
	        }
	        Comparator<IplBowler> iplFieldComparator = SortingField.getBowlingComparatorField(field);
	        iplCsvBowlerList.sort(iplFieldComparator);
	        iplCsvBowlerList.forEach(System.out::println);
	        return new Gson().toJson(iplCsvBowlerList);
	    }
	public String getSortedIPL2019AllRounderRecords(SortingField.Field field) throws IplAnalyserException
	{
		for(int bat = 0; bat < iplBatsmanList.size(); bat++) 
		{
			for(int bowl = 0; bowl < iplCsvBowlerList.size(); bowl++)
			{
				if(iplBatsmanList.get(bat).player.matches((iplCsvBowlerList).get(bowl).player)) 
				{
					IplAllRounder allRounderCricketersData = new IplAllRounder(iplBatsmanList.get(bat).player, iplBatsmanList.get(bat).runs,iplBatsmanList.get(bat).average, iplCsvBowlerList.get(bowl).average,iplCsvBowlerList.get(bowl).wickets);
					System.out.println(allRounderCricketersData);
					iplAllRounderList.add(allRounderCricketersData);
				}
			}
		}
		Comparator<IplAllRounder> iplFieldComparator = SortingField.getAllRounderComparatorField(field);
        iplAllRounderList.sort(iplFieldComparator);
        iplAllRounderList.forEach((System.out::println));
        return new Gson().toJson(iplAllRounderList);
	}
	public String getSortedZeroFiftyAndHundredsAndBestAverageRecords(SortingField.Field field) throws IplAnalyserException 
	 {	
		List<IplBatsman> zero100and50AndBestAverageList= iplBatsmanList.stream()
				.filter(batsman -> (batsman.fiftys==0)&& (batsman.hundreds==0))
				.collect(Collectors.toList());
			 Comparator<IplBatsman> iplFieldComparator = SortingField.getComparatorField(field);
	         zero100and50AndBestAverageList.sort(iplFieldComparator);
	         return new Gson().toJson(zero100and50AndBestAverageList);
	}
	
}
