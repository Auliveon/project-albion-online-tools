package by.savitsky.provider;

import by.savitsky.dto.operations.AddOperation;
import by.savitsky.dto.operations.CraftOperation;

import java.util.Map;

public interface IOperationProvider {

    AddOperation createAddOperation(String id, long count, int stage, long cost, double buyOrderTaxPercent);

    CraftOperation createCraftOperation(long count, int stage, Map<String, Long> recipeMap,
            double returnOfResourcesPercent, long craftCost, String resultItemId, long resultItemCost);

}
