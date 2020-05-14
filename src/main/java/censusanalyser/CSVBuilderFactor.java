package censusanalyser;

public class CSVBuilderFactor {
    public static ICSVBuilder createCSVBuilder() {
        return new OpenCSVBuilder();
    }
}
