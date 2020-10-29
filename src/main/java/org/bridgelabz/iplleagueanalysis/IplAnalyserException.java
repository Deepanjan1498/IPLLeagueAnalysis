package org.bridgelabz.iplleagueanalysis;

public class IplAnalyserException extends Exception {
	enum ExceptionType 
	{
		DATA_NOT_FOUND,FILE_ISSUE;
	}
	
ExceptionType type;

public IplAnalyserException(String message, String name) {
    super(message);
    this.type = ExceptionType.valueOf(name);
    }

public IplAnalyserException(String message, ExceptionType type) {
    super(message);
    this.type = type;
    }
public IplAnalyserException(String message, ExceptionType type, Throwable cause) {
    super(message,cause);
    this.type = type;
    }
}