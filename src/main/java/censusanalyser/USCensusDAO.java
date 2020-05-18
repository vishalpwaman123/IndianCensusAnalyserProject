
package censusanalyser;

public class USCensusDAO {
    public String state;
    public String stateId;
    public int population;
    public double housingUnits;
    public double totalArea;
    public double waterArea;
    public double landArea;
    public double populationDensity;
    public double housingDensity;


    public USCensusDAO(USCensusCSV censusCSV) {
        state = censusCSV.state;
        stateId = censusCSV.stateId;
        housingUnits = censusCSV.housingUnits;
        population = censusCSV.population;
        totalArea = censusCSV.totalArea;
        waterArea = censusCSV.waterArea;
        landArea = censusCSV.landArea;
        populationDensity = censusCSV.populationDensity;
        housingDensity = censusCSV.housingDensity;

    }
}