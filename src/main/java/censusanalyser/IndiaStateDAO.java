package censusanalyser;

import censusanalyser.IndianStateCodeCsv;

public class IndiaStateDAO {
    public String stateName;
    public String stateCode;
    public int tin;

    public IndiaStateDAO(IndianStateCodeCsv indiaStateCodeCSV) {
        stateName=indiaStateCodeCSV.state;
        stateCode=indiaStateCodeCSV.StateCode;
        tin=indiaStateCodeCSV.tin;

    }

}