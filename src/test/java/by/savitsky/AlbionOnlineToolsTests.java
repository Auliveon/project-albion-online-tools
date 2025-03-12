package by.savitsky;

import by.savitsky.config.GlobalTestConfig;
import by.savitsky.executor.IOperationExecutor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.internal.configuration.GlobalConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = GlobalTestConfig.class)
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AlbionOnlineToolsTests {

    @Autowired
    private IOperationExecutor executor;

    @Test
    public void singleThreadOperationExecutorTest() {
        executor.executeChain(null, null);
    }

}
