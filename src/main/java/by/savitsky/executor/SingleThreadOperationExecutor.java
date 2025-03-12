package by.savitsky.executor;

import by.savitsky.dto.operations.ProductionChain;
import org.springframework.stereotype.Component;

@Component
public class SingleThreadOperationExecutor implements IOperationExecutor {

    @Override
    public <T extends IResultContainer> T executeChain(ProductionChain chain, Class<T> rcClass) {
       return null;
    }

}
