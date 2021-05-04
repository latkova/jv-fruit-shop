package core.basesyntax.service;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.impl.FruitRecordParserImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface OperationHandler {
    int apply(FruitRecordDto fruitRecordDto);
}
