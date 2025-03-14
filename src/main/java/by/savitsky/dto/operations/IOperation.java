package by.savitsky.dto.operations;

import by.savitsky.dto.items.ResultInfo;

import java.util.List;

public interface IOperation {

    String getUid();

   ResultInfo execute(List<ResultInfo> previousResultInfos);

    int getStage();

    void setStage(int stage);

}
