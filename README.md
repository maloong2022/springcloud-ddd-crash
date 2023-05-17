### 需求

本案例通过一个商品下单规则的场景来进行演示DDD；

1. 假设产品需求业务运行人员可以对不同的商品配置一些规则，这些规则可以满足不同用户类型可以下单不同商品。
2. 另外一些行为规则是会随着业务发展而增加或者变动的，所以不能写死｛写死太吓人了｝。
3. 数据库的PO类不应该被外部服务调用，这也是必须的。如果你开发过很多系统，那么可能已经吃过亏并意识到这个问题。
4. 按照DDD思想我们尝试需要设计一个规则引擎的服务，通过给外部提供非常简单的接口（application）来获取最终结果。
5. 通过这样的案例可以很容易的感受到目前的四层架构确实在实现DDD思想上有很多的帮助。

### 系统架构图

微服务不是泥球小单体，而是具备更加清晰职责边界的完整一体的业务功能服务。领域驱动设计的思想通过Domain的功能域设计，可以把核心功能与支撑功能很好的区分开。而在MVC的设计模式尝尝是把所有的；数据服务、定义的属性类、提供的功能都在一条线上，这样是非常快速的开发方式但在做微服务部署时候确很麻烦。

按照不同的业务场景可能设计出软件在数据库使用上会有单库单表或者分库分表，如果是一个体量足够需要分库分表设计的系统，在扩容时候它是否能满足你的需求包括；

1. 核心计算不涉及库扩容，但是系统功能都在一起怎么办，已扩容都扩容了很浪费
2. 所有的扩容都涉及到数据库连接数增加，但并不是每个行为都直达到所有库表
3. 持续发展的业务会带来数据激增，将来怎么进行扩展，重新洗数据并不是很好的选择
4. 那么实际开发大泥球架构时，不只是会遇到上面的问题，还可能会遇到工期很赶加个人也不提升效率，反复交接代码扶不过三代等等，因此我们将服务拆分为独立单体具备此核心域完整功能的系统是非常必要的。

如图，是微服务数据库使用的一种思想，我们希望路由层从最开始就被执行，用户分群动态扩展

![](https://s2.loli.net/2023/05/17/OSr2V3QjpYmXPaq.png)

本案例通过使用SpringCloud将我们的服务架构扩展为通过路由调用的微服务

1. 首先通过Eureka作为服务注册与发现中心
2. 然后使用Feign模式作为调用API接口
3. 最后依赖于zuul设置路由转发功能

### 主要服务架构图

![DDD系统架构图](https://s2.loli.net/2023/05/16/Oa7XiZbstAzugM2.png)

### 业务设计

通过领域驱动设计的思想，从领域知识中提取和划分为一个一个的子领域（核心子域，通用子域，支撑子域），并在子领域上建立模型。那么在技术实现上就需要去支撑这种建模，以使我们的代码模块独立、免污染、易于扩展。

在上面我们提到需要开发一个可扩展使用的规则树，那么如果只是单纯的一次性需求，最快的方式是if语句就搞定了。但是为了使这个领域服务具备良好的使用和扩展性，我们需要做些拆分，那么如下；

1. 你是否想过系统在过滤过则的时候其实就像执行一棵二叉树一样非左即右侧，每一条线上都有着执行条件，通过判断来达到最终的结果。
2. 按照树形结构我们将定义出来四个类；树、节点、果实、指向线(From-To)，用于描述我们的规则行为。
3. 再此基础上需要实现一个逻辑定义与规则树执行引擎，通过统一的引擎服务来执行我们每次配置好的规则树。

![领域开发设计服务](https://s2.loli.net/2023/05/17/7AVym2IDOgwCSsz.png)
