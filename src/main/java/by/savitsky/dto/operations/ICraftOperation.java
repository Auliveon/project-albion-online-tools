package by.savitsky.dto.operations;

import by.savitsky.dto.items.Recipe;

public interface ICraftOperation extends IOperation {

    Recipe getRecipe();

    void setRecipe(Recipe recipe);

    double getReturnOfResourcesPercent();

    void setReturnOfResourcesPercent(double returnOfResourcesPercent);

}
