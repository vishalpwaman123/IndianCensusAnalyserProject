package censusanalyser;

public class CSVBuildException extends Exception {


    enum ExceptionType {
        CENSUS_FILE_PROBLEM,UNABLE_TO_PARSE, NO_CENSUS_DATA;
    }

    ExceptionType type;

    public CSVBuildException(String message, ExceptionType type) {
        super(message);
        this.type=type;
    }

    public CSVBuildException(String message, String name) {
            super(message);
            this.type=ExceptionType.valueOf(name);
    }


}
