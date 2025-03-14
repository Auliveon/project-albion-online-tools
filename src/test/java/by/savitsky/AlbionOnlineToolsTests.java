package by.savitsky;

import by.savitsky.config.GlobalTestConfig;
import by.savitsky.dto.operations.AddOperation;
import by.savitsky.dto.operations.CraftOperation;
import by.savitsky.dto.operations.IOperation;
import by.savitsky.dto.operations.ProductionChain;
import by.savitsky.dto.result.AlbionOnlineResultContainer;
import by.savitsky.dto.result.IResultContainer;
import by.savitsky.executor.IProductionChainExecutor;
import by.savitsky.provider.IOperationProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ContextConfiguration(classes = GlobalTestConfig.class)
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AlbionOnlineToolsTests {

    @Autowired
    private IProductionChainExecutor executor;

    @Autowired
    private IOperationProvider operationProvider;

    @Test
    public void singleThreadOperationExecutorTest() {
        final ProductionChain chain = new ProductionChain();
        final List<IOperation> operations = new ArrayList<>();
        final AddOperation addOperation = operationProvider.createAddOperation("item1", 1000, 0, 100, 0);
        final CraftOperation craftOperation = operationProvider.createCraftOperation(1000, 1, Map.of("item1", 3L), 50,
                100, "result1", 400);
        operations.add(addOperation);
        operations.add(craftOperation);
        chain.setOperations(operations);
        final IResultContainer resultContainer = executor.executeChain(chain, AlbionOnlineResultContainer.class);
        Assertions.assertEquals(0, resultContainer.getProfit());
    }

}
