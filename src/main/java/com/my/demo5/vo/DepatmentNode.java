package com.my.demo5.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DepatmentNode {

    @JsonProperty("value")
    private Integer departmentId;
    @JsonProperty("label")
    private String name;
    @JsonProperty("children")
    private List<DepatmentNode> subDepartmentNodes;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public List<DepatmentNode> getSubDepartmentNodes() {
        return subDepartmentNodes;
    }

    public void setSubDepartmentNodes(List<DepatmentNode> subDepartmentNodes) {
        this.subDepartmentNodes = subDepartmentNodes;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
