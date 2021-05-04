package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.OperationType;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.*;
import core.basesyntax.service.impl.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/java/resources/fruitsFrom.csv";
    private static final String OUTPUT_FILE = "src/main/java/resources/report.csv";

    public static void main(String[] args) {
        Map<OperationType, OperationHandler> map = new HashMap<>();
        //map.put(OperationType.BALANCE, new AddOperationHandler());
        map.put(OperationType.SUPPLY, new AddOperationHandler());
        map.put(OperationType.RETURN, new AddOperationHandler());
        map.put(OperationType.PURCHASE, new SubtractOperationHandler());

       // OperationStrategy strategy = new OperationStrategyImpl(map);

        FileReaderService fileReader = new FileReaderImpl();
        FruitRecordParser fruitRecordParser = new FruitRecordParserImpl();
        List<FruitRecordDto> dtos = fruitRecordParser.parse(fileReader.readFromFile(INPUT_FILE));
        for (FruitRecordDto dto : dtos) {
            map.get(dto.getOperationType()).apply(dto);
        }
        ReportService reportMaker = new ReportServiceCsv();
        FileWriterService fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(reportMaker.createReport(Storage.fruits), OUTPUT_FILE);
    }
}
