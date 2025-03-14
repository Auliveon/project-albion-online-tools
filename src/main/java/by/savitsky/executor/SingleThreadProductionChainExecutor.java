package by.savitsky.executor;

import by.savitsky.dto.items.ResultInfo;
import by.savitsky.dto.operations.ProductionChain;
import by.savitsky.dto.result.IResultContainer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.util.List;

@Component
public class SingleThreadProductionChainExecutor implements IProductionChainExecutor {

    @Override
    public <T extends IResultContainer> T executeChain(ProductionChain chain, Class<T> rcClass) {
        try {
            final Constructor<T> constructor = rcClass.getDeclaredConstructor(List.class);
            constructor.setAccessible(true);
            final List<ResultInfo> resultInfos = chain.execute();
            return constructor.newInstance(resultInfos);
        } catch (Exception e) {

        }
        return null;
    }

}
