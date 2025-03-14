package by.savitsky.dto.operations;

import by.savitsky.dto.items.ResultInfo;

import java.util.*;
import java.util.stream.Collectors;

public class ProductionChain {

    private String uid;

    private String name;

    private List<IOperation> operations;

    public ProductionChain() {
        this.uid = UUID.randomUUID().toString();
    }

    public List<ResultInfo> execute() {
        final Map<Integer, List<IOperation>> operationsMap = operations.stream()
                .collect(Collectors.groupingBy(IOperation::getStage, TreeMap::new, Collectors.toList()));
        final List<ResultInfo> resultInfos = new ArrayList<>();
        for (Map.Entry<Integer, List<IOperation>> entry : operationsMap.entrySet()) {
            for (IOperation operation : entry.getValue()) {
                resultInfos.add(operation.execute(resultInfos));
            }
        }
        return resultInfos;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IOperation> getOperations() {
        return operations;
    }

    public void setOperations(List<IOperation> operations) {
        this.operations = operations;
    }

}
