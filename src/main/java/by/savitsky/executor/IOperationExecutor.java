package by.savitsky.executor;

import by.savitsky.dto.operations.ProductionChain;

public interface IOperationExecutor {

    <T extends IResultContainer> T executeChain(ProductionChain chain, Class<T> rcClass);

}
