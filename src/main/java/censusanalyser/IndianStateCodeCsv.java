package censusanalyser;

import com.opencsv.bean.CsvBindByName;

public class IndianStateCodeCsv {

    @CsvBindByName(column = "State Name", required = true)
    public String state;

    @CsvBindByName(column = "StateCode", required = true)
    public String StateCode;

    @CsvBindByName(column = "TIN", required = true)
    public int tin;



    @Override
    public String toString() {
        return "IndianStateCodeCsv{" +
                "state='" + state + '\'' +
                ", stateCode='" + StateCode + '\'' +
                ", tin='" + tin + '\'' +
                '}';
    }
}
