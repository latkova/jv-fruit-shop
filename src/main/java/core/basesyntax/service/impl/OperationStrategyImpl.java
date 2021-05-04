package core.basesyntax.service.impl;

import core.basesyntax.model.OperationType;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.OperationStrategy;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<OperationType, OperationHandler> handlerMap;

    public OperationStrategyImpl(Map<OperationType, OperationHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public OperationHandler get(OperationType type) {
        return handlerMap.get(type);
    }
}
