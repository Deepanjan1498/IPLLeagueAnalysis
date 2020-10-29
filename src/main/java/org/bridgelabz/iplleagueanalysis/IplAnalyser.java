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

import com.google.gson.Gson;



public class IplAnalyser {
	List<IplBatsman> iplCsvList = new ArrayList<>();
	List<IplBowler> iplCsvBowlerList = new ArrayList<>();
	public int loadCricketIPL2019BatsmanData(String csvFilePath) throws IplAnalyserException 
	{
		 try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
	            ICSVBuilder csvbuilder = CSVBuilderFactory.createCSVBuilder();
	            iplCsvList= csvbuilder.getCSVFileList(reader, IplBatsman.class);
	            return iplCsvList.size();

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
	        if (iplCsvList == null || iplCsvList.size() == 0) {
	            throw new IplAnalyserException("No Census Data", IplAnalyserException.ExceptionType.DATA_NOT_FOUND);
	        }
	        Comparator<IplBatsman> iplFieldComparator = SortingField.getComparatorField(field);
	        iplCsvList.sort(iplFieldComparator);
	        iplCsvList.forEach(System.out::println);
	        return new Gson().toJson(iplCsvList);
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
	
}
