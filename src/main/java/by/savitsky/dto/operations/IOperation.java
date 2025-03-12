package by.savitsky.dto.operations;

import java.util.List;

public interface IOperation {

   ResultInfo execute(List<ResultInfo> previousResultInfos);

    int getStage();

}
