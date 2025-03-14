package by.savitsky.executor;

import by.savitsky.dto.result.IResultContainer;
import by.savitsky.dto.operations.ProductionChain;

public interface IProductionChainExecutor {

    <T extends IResultContainer> T executeChain(ProductionChain chain, Class<T> rcClass);

}
