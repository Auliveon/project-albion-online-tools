package by.savitsky.provider;

import by.savitsky.dto.operations.AddOperation;
import by.savitsky.dto.operations.CraftOperation;

import java.util.Map;

public interface IOperationProvider {

    AddOperation createAddOperation(String id, int count, int stage, int cost, double buyOrderTaxPercent);

    CraftOperation createCraftOperation(int count, int stage, Map<String, Integer> recipeMap,
            double returnOfResourcesPercent, int craftCost, String resultItemId, int resultItemCost);

}
