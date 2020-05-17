package censusanalyser;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {

    CensusAnalyser censusAnalyser = new CensusAnalyser();

    private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String INDIAN_STATE_CSV_FILE_PATH = "./src/test/resources/IndiaStateCode.csv";
    private static final String INDIAN_STATE_CSV_FILE_PATH_WRONG_EXTENSION_TYPE = "./src/test/resources/IndiaStateCode.png";
    private static final String INDIAN_CENSUS_CSV_WRONG_DELIMITER = "./src/test/resources/IndiaStateCensusDataWrongDelimiter.csv";
    private static final String CENSUS_CSV_WRONG_HEADER_CSV_FILE="./src/test/resources/indiaStateCensusWrongHeader.csv";
    private static final String STATES_CSV_WRONG_DELIMITER = "./src/test/resources/indiaStatesWrongDelimeter.csv";
    private static final String STATES_CSV_WRONG_HEADER_CSV_FILE="./src/test/resources/indiaStatesDataWrongHeader.csv";






    @Test
    public void givenIndianStateCsv_WhenCorrect_butTypeIncorrectShouldThrowCustomException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        } catch (CSVBuildException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void givenIndianStateCsv_WhenWrongDelimiter_shouldThrowCustomException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadIndiaCensusData(STATES_CSV_WRONG_DELIMITER);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        } catch (CSVBuildException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIndianStateCsv_WithWrongHeader_ShouldThrowException() throws CensusAnalyserException {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(STATES_CSV_WRONG_HEADER_CSV_FILE);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        } catch (CSVBuildException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndiaCensusData_WithWrongHeader_ShouldThrowException() throws CensusAnalyserException {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(CENSUS_CSV_WRONG_HEADER_CSV_FILE);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        } catch (CSVBuildException e) {
            e.printStackTrace();
        }
    }

        @Test
    public void givenIndiaCensusData_WhenWrongDelimiter_shouldThrowCustomException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_CSV_WRONG_DELIMITER);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        } catch (CSVBuildException e) {
            e.printStackTrace();
        }
    }




    @Test
    public void givenIndiaCensusData_WhenCorrect_butTypeIncorrectShouldThrowCustomException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(INDIAN_STATE_CSV_FILE_PATH_WRONG_EXTENSION_TYPE);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        } catch (CSVBuildException e) {
            e.printStackTrace();
        }
    }




    @Test
    public void givenIndianCensusCSVFileReturnsCorrectRecords() {
        try {
            //CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29, numOfRecords);
        } catch (CensusAnalyserException | CSVBuildException e) {
        }
    }

    @Test
    public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
        try {
            //CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        } catch (CSVBuildException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndianStateCode_CSVFile_ReturnsCorrectRecords() throws CensusAnalyserException {
        try {
            //CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaStateCode(INDIAN_STATE_CSV_FILE_PATH);
            Assert.assertEquals(37, numOfRecords);
        } catch (CensusAnalyserException e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        } catch (CSVBuildException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void givenIndiaCensusData_SortedOnState_ShouldReturnSortedResult() {
        try {
            //CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            String sortedCensusData = censusAnalyser.getStateWiseSortedCensusData();
            IndiaCensusCSV[] censusCSV = new Gson().fromJson(sortedCensusData, IndiaCensusCSV[].class);
            Assert.assertEquals("Andhra Pradesh", censusCSV[0].state);
        } catch (CensusAnalyserException ignored) { }
        catch (CSVBuildException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void givenIndianStateCodeCsv_whenSortedOnStateCode_shouldReturnShortedResult() {
        try {
            //CensusAnalyser censusAnalyser=new CensusAnalyser();
            censusAnalyser.loadIndiaCensusData(INDIAN_STATE_CSV_FILE_PATH);
            String sortedStateCsvData = censusAnalyser.getStateCodeWiseSortedIndianStateCodeData();
            IndianStateCodeCsv[] stateCSV = new Gson().fromJson(sortedStateCsvData, IndianStateCodeCsv[].class);
            Assert.assertEquals("AA",stateCSV[0].StateCode);
        } catch (CensusAnalyserException ignored) { }
        catch (CSVBuildException e) {
            e.printStackTrace();
        }
    }

}



