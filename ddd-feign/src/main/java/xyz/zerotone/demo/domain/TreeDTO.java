package xyz.zerotone.demo.domain;

public class TreeDTO {
    private Long treeId;

    public TreeDTO(Long treeId) {
        this.treeId = treeId;
    }

    public Long getTreeId() {
        return treeId;
    }

    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }
}
