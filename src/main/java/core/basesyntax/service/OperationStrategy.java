package core.basesyntax.service;

import core.basesyntax.model.OperationType;

public interface OperationStrategy {
    OperationHandler get(OperationType type);
}
