# **试炼**
> 更新说明，此项目已经从1.0结构，重新构建，意在学习DDD，能够凭借自己的理解来进行演练，
  已经对于框架的学习之余进行实践使用。
 
## 2021.11.14 
### V1.0
> 1.0版本是刚买完服务器后用来测试服务器中安装的中间件的demo，原本想在这个基础上进行使用和练习，
  再和朋友讨论的过程中发现，大公司很多部门已经开始对DDD的探索，所以从原来的项目分层进行了改
  善，属于自己的简介，以供日后的学习。


> 原有的项目结构如下: 
* 1.trial-controller:作为web调用的入口；
* 2.trial-service:作为业务实现的主要逻辑层；
* 3.trial-mapper:作为数据库层面的CRUD；
* 3.trial-pojo: 存放全局使用的pojo
* 3.trial-utils:供全局提供工具使用，统一进行管理
> 该项目结构为简单的依次依赖关系
 
##  2021.11.14 
### V1.5

> 项目层级结构全局更换

* **User Interface层**
>  对外以各种协议提供服务，该层需要明确定义支持的服务协议、契约等。
   trial-controller => trial-user_interface-controller
   
* **application层** 
>  应用服务层，组合domain层的领域对象和基础设施层的公共组件，根据业务需要包装
   出多变的服务，以适应多变的业务服务需求。这其中没有详细的实现逻辑只有简单的逻辑描述
   trial-service => trial-application-service
   
* **domain层** 
>  业务领域层，是我们最应当关心的一层，也是最多变的一层，需要保证这一层是高内聚的。
   确保所有的业务逻辑都留在这一层，而不会遗漏到其他层
>  1. 新增trial-domain-service 业务的真正处理着，每个里面只做自己领域内的事情，所有
   的聚合与聚合之间通过聚合根来进行上下文的信息传递，工厂返回的则是具有唯一标识的
   实体或者值对象。
>  2. 新增trial-domain-factory 将仓库中的对象构建成领域中传递需要的对象
>  3. 新增trial-domain-repository 仓库仓库。我们将仓库的接口定义归类在
   domain层，因为他和domain entity联系紧密。仓库用户和基础实施的持久化层交
   互，完成领域对应的增删改查操作。仓库的实际实现根据不同的存储介质而不同，可
   以是redis、oracle、mongodb等。
   4. 新增trial-domain-event消息事件，当发生消息通知使用event
   5. 调用其他服务时候的防腐层的层级结构并未给出，引用时在进行构建即刻
* **infrastructure层**     
>  基础设施层提供公共功能组件
   1. trial-mapper:作为数据库层面的CRUD，供给于仓库；
   对domain层repository接口的实现，对应每种存储介质有其特定实现，如oracle的mapper，
   mongodb的dao等等。repository impl会调用mybatis、mongo client、redis client完成实际的存储层操作。
   2. trial-pojo: 存放模型，聚合的聚合根是聚合上下文的交互对象也是实体对象中的特殊值，实体和值对象是聚合根持有值，
   具有唯一性的值对象，一般是持久化的，而值对象不具备唯一性质可能组装，
   3. trial-utils:供全局提供工具使用，统一进行管理

> 这个上面的解释很详尽，可以看看，https://blog.csdn.net/qq_16681169/article/details/81437661

### 三级标题  
#### 四级标题  
##### 五级标题  
###### 六级标题 
