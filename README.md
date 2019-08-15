# springboot-mybatis-generator
简单来说，需要利用 mybatis 的一些特点来解决问题，比如：可以有多个 xml 文件，model 可以继承。利用这个特点，我们通过 MBG 的 plugin 来改造 MGB 生成的文件。最终的产物是三个 java 类（两个 Model 类，1个 Mapper 类），两个 xml 文件

## 生成的xml 文件与 java 代码结构
### 用 user 表来做示例
* 生成两个 java 类：User 与 BaseUser，User 继承 BaseUser，BaseUser 继承 BaseModel。BaseModel由本工具提供一个基础类，包含几个基础字段。BaseUser 不可以修改，BaseUser 类是原始的 MBG 工具生成的代码，这是通过 plugin 的机制修改的类名，后续本工具再生成代码的时候，会自动覆盖这个文件。User 可以修改，可以添加自己的属性与方法，后续工具再生成不会重新生成这个文件

* xml 文件：两个 xml 文件名相同，只是会放在不同的 package 下，一个是 MBG 自动生成的文件，每次覆盖。一个是留给程序员修改的文件，不再覆盖。

**注意：暂时没考虑联合主键的的情况**

## 引用jar包
[mybatis-generator-ext](https://github.com/ywdlucking/mybatis-generator-ext)