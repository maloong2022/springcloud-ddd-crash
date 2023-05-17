package xyz.zerotone.demo.domain.tree.model.vo;

import lombok.Data;

@Data
public class TreeInfo {
    private Long treeId;         //规则树ID
    private String treeName;     //规则树名称
    private String treeDesc;     //规则树描述
    private Integer nodeCount;   //节点数
    private Integer lineCount;   //连线数
}
