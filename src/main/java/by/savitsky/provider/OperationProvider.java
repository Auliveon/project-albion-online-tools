package by.savitsky.provider;

import by.savitsky.dto.items.AddItem;
import by.savitsky.dto.operations.AddOperation;
import by.savitsky.dto.operations.CraftOperation;
import by.savitsky.util.CommonUtil;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component
public class OperationProvider implements IOperationProvider {

    @Override
    public AddOperation createAddOperation(String id, long count, int stage, long cost, double buyOrderTaxPercent) {
        final AddOperation result = new AddOperation();
        result.setItems(Collections.singletonList(new AddItem(id, count, cost, buyOrderTaxPercent)));
        result.setStage(stage);
        return result;
    }

    @Override
    public CraftOperation createCraftOperation(long count, int stage, Map<String, Long> recipeMap,
            double returnOfResourcesPercent, long craftCost, String resultItemId, long resultItemCost) {
        final CraftOperation result = new CraftOperation();
        result.setCount(count);
        result.setStage(stage);
        result.setRecipe(CommonUtil.generateRecipe(recipeMap, craftCost, resultItemId, resultItemCost));
        result.setReturnOfResourcesPercent(returnOfResourcesPercent);
        return result;
    }

}
