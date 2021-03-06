package censusanalyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class OpenCSVBuilder <E> implements ICSVBuilder{

        public Map<E,E> getCSVFileMap(Reader reader, Class csvClass) throws CSVBuildException {
            return (Map<E, E>) this.getCSVBean(reader,csvClass).parse();
        }

    public Iterator<E> getCSVFileIterator(Reader reader, Class csvClass) throws CSVBuildException {
        return this.getCSVBean(reader,csvClass).iterator();
    }

    @Override
    public List<E> getCSVFileList(Reader reader, Class csvClass) throws CSVBuildException {
            return this.getCSVBean(reader,csvClass).parse();
           }

    private CsvToBean<E> getCSVBean(Reader reader, Class csvClass) throws CSVBuildException {
        try {
            CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(csvClass);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            return csvToBeanBuilder.build();
            } catch (IllegalStateException e) {
            throw new CSVBuildException(e.getMessage(),CSVBuildException.ExceptionType.UNABLE_TO_PARSE);
        }
    }
}
