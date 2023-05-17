create table rule_tree_node
(
    id        bigint auto_increment,
    treeId    bigint       null,
    nodeType  int          null,
    nodeValue varchar(512) null,
    ruleKey   varchar(64)  null,
    ruleDesc  varchar(512) null,
    constraint rule_tree_node_pk
        primary key (id)
);


create table rule_tree
(
    id             bigint auto_increment,
    treeName       varchar(256) null,
    treeDesc       varchar(512) null,
    treeRootNodeId bigint       null,
    createTime     datetime     null,
    updateTime     datetime     null,
    constraint rule_tree_pk
        primary key (id)
);

create table rule_tree_node_line
(
    id             bigint auto_increment,
    treeId         bigint      null,
    nodeIdFrom     bigint      null,
    nodeIdTo       bigint      null,
    ruleLimitType  int         null,
    ruleLimitValue varchar(64) null,
    constraint rule_tree_node_line_pk
        primary key (id)
);


INSERT INTO study.rule_tree (id, treeName, treeDesc, treeRootNodeId, createTime, updateTime) VALUES (10001, '购物分类规则树', '用于分类不同类型用户可购物范围', 1, '2023-05-17 13:45:16', '2023-05-17 13:45:21');
INSERT INTO study.rule_tree_node (id, treeId, nodeType, nodeValue, ruleKey, ruleDesc) VALUES (1, 10001, 1, null, 'userGender', '用户性别[男/女]');
INSERT INTO study.rule_tree_node (id, treeId, nodeType, nodeValue, ruleKey, ruleDesc) VALUES (11, 10001, 1, null, 'userAge', '用户年龄');
INSERT INTO study.rule_tree_node (id, treeId, nodeType, nodeValue, ruleKey, ruleDesc) VALUES (12, 10001, 1, null, 'userAge', '用户年龄');
INSERT INTO study.rule_tree_node (id, treeId, nodeType, nodeValue, ruleKey, ruleDesc) VALUES (111, 10001, 2, '果实A', null, null);
INSERT INTO study.rule_tree_node (id, treeId, nodeType, nodeValue, ruleKey, ruleDesc) VALUES (112, 10001, 2, '果实B', null, null);
INSERT INTO study.rule_tree_node (id, treeId, nodeType, nodeValue, ruleKey, ruleDesc) VALUES (121, 10001, 2, '果实C', null, null);
INSERT INTO study.rule_tree_node (id, treeId, nodeType, nodeValue, ruleKey, ruleDesc) VALUES (122, 10001, 2, '果实D', null, null);
INSERT INTO study.rule_tree_node_line (id, treeId, nodeIdFrom, nodeIdTo, ruleLimitType, ruleLimitValue) VALUES (1, 10001, 1, 11, 1, 'man');
INSERT INTO study.rule_tree_node_line (id, treeId, nodeIdFrom, nodeIdTo, ruleLimitType, ruleLimitValue) VALUES (2, 10001, 1, 12, 1, 'woman');
INSERT INTO study.rule_tree_node_line (id, treeId, nodeIdFrom, nodeIdTo, ruleLimitType, ruleLimitValue) VALUES (3, 10001, 11, 111, 3, '25');
INSERT INTO study.rule_tree_node_line (id, treeId, nodeIdFrom, nodeIdTo, ruleLimitType, ruleLimitValue) VALUES (4, 10001, 11, 112, 4, '25');
INSERT INTO study.rule_tree_node_line (id, treeId, nodeIdFrom, nodeIdTo, ruleLimitType, ruleLimitValue) VALUES (5, 10001, 12, 121, 3, '25');
INSERT INTO study.rule_tree_node_line (id, treeId, nodeIdFrom, nodeIdTo, ruleLimitType, ruleLimitValue) VALUES (6, 10001, 12, 122, 4, '25');
