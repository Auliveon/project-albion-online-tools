package by.savitsky.dto.operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ProductionChain {

    private String id;

    private String name;

    private List<IOperation> operations;

    public void execute() {
        final Map<Integer, List<IOperation>> operationsMap = operations.stream()
                .collect(Collectors.groupingBy(IOperation::getStage, TreeMap::new, Collectors.toList()));
        final List<ResultInfo> resultInfos = new ArrayList<>();
        for (Map.Entry<Integer, List<IOperation>> entry : operationsMap.entrySet()) {
            for (IOperation operation : entry.getValue()) {
                resultInfos.add(operation.execute(resultInfos));
            }
        }

    }

}
