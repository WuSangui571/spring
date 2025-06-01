# GoF之代理模式

## 1. 对代理模式的理解、

**生活场景1**：牛村的牛二看上了隔壁村小花，牛二不好意思直接找小花，于是牛二找来了媒婆王妈妈。这里面就有一个非常典型的代理模式。牛二不能和小花直接对接，只能找一个中间人。其中王妈妈是代理类，牛二是目标类。王妈妈代替牛二和小花先见个面。（现实生活中的婚介所）【在程序中，对象A和对象B无法直接交互时。】
**生活场景2**：你刚到北京，要租房子，可以自己找，也可以找链家帮你找。其中链家是代理类，你是目标类。你们两个都有共同的行为：找房子。不过链家除了满足你找房子，另外会收取一些费用的。(现实生活中的房产中介)【在程序中，功能需要增强时。】
**西游记场景**：八戒和高小姐的故事。八戒要强抢民女高翠兰。悟空得知此事之后怎么做的？悟空幻化成高小姐的模样。代替高小姐与八戒会面。其中八戒是客户端程序。悟空是代理类。高小姐是目标类。那天夜里，在八戒眼里，眼前的就是高小姐，对于八戒来说，他是不知道眼前的高小姐是悟空幻化的，在他内心里这就是高小姐。所以悟空代替高小姐和八戒亲了嘴儿。这是非常典型的代理模式实现的保护机制。**代理模式中有一个非常重要的特点：对于客户端程序来说，使用代理对象时就像在使用目标对象一样。【在程序中，目标需要被保护时】**
**业务场景**：系统中有A、B、C三个模块，使用这些模块的前提是需要用户登录，也就是说在A模块中要编写判断登录的代码，B模块中也要编写，C模块中还要编写，这些判断登录的代码反复出现，显然代码没有得到复用，可以为A、B、C三个模块提供一个代理，在代理当中写一次登录判断即可。代理的逻辑是：请求来了之后，判断用户是否登录了，如果已经登录了，则执行对应的目标，如果没有登录则跳转到登录页面。【在程序中，目标不但受到保护，并且代码也得到了复用。】



代理模式是GoF23种设计模式之一。属于结构型设计模式。

代理模式的作用是：为其他对象提供一种代理以控制对这个对象的访问。在某些情况下，一个客户不想或者不能直接引用一个对象，此时可以通过一个称之为“代理”的第三者来实现间接引用。代理对象可以在客户端和目标对象之间起到中介的作用，并且可以通过代理对象去掉客户不应该看到的内容和服务或者添加客户需要的额外的服务。通过引入一个新的对象来实现对真实对象的操作或者将新的对象作为真实对象的一个替身，这种实现机制即为代理模式，通过引入代理模式对象来间接访问一个对象，这就是代理模式的模式动机。

代理模式中的角色：

+ 代理类（代理主题）
+ 目标类（真实主题）
+ 代理类和目标类的公共接口（抽象主题）：客户端在使用代理类时就像在使用目标类，不被客户端所察觉，所以代理类和目标类要有共同的行为，也就是实现共同的接口。

代理模式在代码实现上，包括两种形式

+ 静态代理
+ 动态代理

## 2. 静态代理

直接看代码

```java
package com.sangui.mall.service;
/**
 * @Author: sangui
 * @CreateTime: 2025-05-31
 * @Description:
 * @Version: 1.0
 */
public interface OrderService {
    /**
     * 生成订单
     */
    void generate();

    /**
     * 修改订单信息
     */
    void modify();

    /**
     * 查看订单明细
     */
    void detail();
}
```

```java
package com.sangui.mall.service.impl;
import com.sangui.mall.service.OrderService;
/**
 * @Author: sangui
 * @CreateTime: 2025-05-31
 * @Description:
 * @Version: 1.0
 */
public class OrderServiceImpl implements OrderService {
    /**
     * 假设项目上线一年后，项目经理提出，要计算每个业务的具体耗时时间的新业务
     * 于是乎，就有了解决方法一：在每个业务方法里编写三行代码，计算这个业务的耗时。
     * 这种方式当然可以得出每个业务的耗时时间，
     * 缺点一：但是，这明显违背 OCP 开发原则，即在扩展新功能时，改变原代码
     * 缺点二：每个业务方法种都写了相同的代码，代码没得到复用
     * 以下注释内容是解决方法一的代码：
     */
//    @Override
//    public void generate() {
//        long begin = System.currentTimeMillis();
//        // 假设这是业务代码，模拟实际项目生成订单耗时
//        try {
//            Thread.sleep(1234);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("订单已生成！！");
//        long end = System.currentTimeMillis();
//        System.out.println("生成订单耗时：" + (end - begin) + "ms");
//    }
//    @Override
//    public void modify() {
//        long begin = System.currentTimeMillis();
//        //假设这是业务代码，模拟实际项目修改订单耗时
//        try {
//            Thread.sleep(456);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("订单已修改！！");
//        long end = System.currentTimeMillis();
//        System.out.println("修改订单耗时：" + (end - begin) + "ms");
//    }
//    @Override
//    public void detail() {
//        long begin = System.currentTimeMillis();
//        //假设这是业务代码，模拟实际项目查询订单耗时
//        try {
//            Thread.sleep(111);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("订单请查看！！.........展开");
//        long end = System.currentTimeMillis();
//        System.out.println("查看订单明细耗时：" + (end - begin) + "ms");
//    }
    /**
     * 解决方法二：编写一个业务类的子类，让子类继承业务类，对每个业务方法进行重写
     * 详细代码见同包下的 OrderServiceImplSub.java ，这就是 OrderServiceImpl 的子类
     */
    @Override
    public void generate() {
        // 假设这是业务代码，模拟实际项目生成订单耗时
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("订单已生成！！");
    }
    @Override
    public void modify() {
        //假设这是业务代码，模拟实际项目修改订单耗时
        try {
            Thread.sleep(456);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("订单已修改！！");
    }
    @Override
    public void detail() {
        //假设这是业务代码，模拟实际项目查询订单耗时
        try {
            Thread.sleep(111);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("订单请查看！！.........展开");
    }
}
```

```java
package com.sangui.mall.service.impl;
/**
 * @Author: sangui
 * @CreateTime: 2025-05-31
 * @Description:
 * @Version: 1.0
 */
public class OrderServiceImplSub extends OrderServiceImpl{
    /**
     * 这个解决方法解决了违反 OCP 原则的问题，即为了扩展新功能，不在源程序中进行修改
     * 但是，这种解决方法也有缺点，
     * 缺点一：耦合度很高，继承关系是一种耦合关系很高的关系，不建议使用
     * 缺点二：还是没解决代码复用的问题，即用一段代码重复写
     * 还有没有更好的解决方法？
     * 解决方案三，就是采用代理模式
     */
    @Override
    public void detail() {
        long begin = System.currentTimeMillis();
        super.detail();
        long end = System.currentTimeMillis();
        System.out.println("查看订单明细耗时：" + (end - begin) + "ms");
    }
    @Override
    public void modify() {
        long begin = System.currentTimeMillis();
        super.modify();
        long end = System.currentTimeMillis();
        System.out.println("修改订单耗时：" + (end - begin) + "ms");
    }
    @Override
    public void generate() {
        long begin = System.currentTimeMillis();
        super.generate();
        long end = System.currentTimeMillis();
        System.out.println("生成订单耗时：" + (end - begin) + "ms");
    }
}
```

```java
package com.sangui.mall.service.impl;
import com.sangui.mall.service.OrderService;
/**
 * @Author: sangui
 * @CreateTime: 2025-05-31
 * @Description: 代理对象
 * @Version: 1.0
 */
public class OrderServiceProxy implements OrderService {
    /**
     * 解决方法三：生成代理类
     * OrderServiceProxy 里的方法就是代理方法
     * OrderServiceImpl 里的方法就是目标方法
     * OrderService 就是公共的接口
     * 解决方法三解决了 OCP 问题，使用实现而不是继承关系，降低了耦合度
     * 目前使用的是静态代理，静态代理的缺点就是：
     * 一个目标类就得生成一个代理类，实际开发中若有一百个目标类，就得写一百个代理类，会导致类爆炸，不好维护
     * 于是会有了解决方法四，使用动态代理
     * （动态代理也是代理模式，只不过添加了字节码生成技术，可以在内存中动态的生成一个对应的class字节码，这个字节码就是我们的代理类）
     */
    // 将目标对象作为代理对象的一个属性，这种关系叫做关联关系，比继承关系的耦合度低
    // 注意这里要写 OrderService （公共接口），不能是 OrderServiceImpl ，因为公共接口耦合度低
    private OrderService target;
    // 构造方法
    public OrderServiceProxy(OrderService target) {
        this.target = target;
    }
    public OrderServiceProxy() {
    }
    @Override
    public void generate() {
        long begin = System.currentTimeMillis();
        target.generate();
        long end = System.currentTimeMillis();
        System.out.println("生成订单耗时：" + (end - begin) + "ms");
    }
    @Override
    public void modify() {
        long begin = System.currentTimeMillis();
        target.modify();
        long end = System.currentTimeMillis();
        System.out.println("生成订单耗时：" + (end - begin) + "ms");
    }
    @Override
    public void detail() {
        long begin = System.currentTimeMillis();
        target.detail();
        long end = System.currentTimeMillis();
        System.out.println("生成订单耗时：" + (end - begin) + "ms");
    }
}
```

```java
package com.sangui.mall.client;
import com.sangui.mall.service.OrderService;
import com.sangui.mall.service.impl.OrderServiceImpl;
import com.sangui.mall.service.impl.OrderServiceImplSub;
import com.sangui.mall.service.impl.OrderServiceProxy;
import java.lang.reflect.Proxy;
/**
 * @Author: sangui
 * @CreateTime: 2025-05-31
 * @Description:
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
//        OrderService orderService = new OrderServiceImpl();
//        //OrderService orderService = new OrderServiceImplSub();
//        orderService.generate();
//        orderService.detail();
//        orderService.modify();
        // 创建目标对象
        OrderService target = new OrderServiceImpl();
        // 创建代理对象
        OrderService proxy = new OrderServiceProxy(target);
        // 调用代理对象的代理方法
        proxy.generate();
        proxy.detail();
        proxy.modify();
    }
}
```

## 3. 动态代理

在程序的运行阶段，在内存中动态生成代理类，被称为动态代理，目的是为了减少代理类的数量。解决代码复用的问题（静态代理中没有解决）。

在内存当中动态生成类的技术常见的包括：

+ JDK 动态代理技术：只代理接口。
+ CGLIB 动态代理技术，CGLIB（Code Generation Library）是一个开源项目。是一个强大的、高性能、高质量的Code生成类库，它可以在运行期扩展Java类与实现Java接口。它既可以代理接口，又可以代理类，底层是通过继承的方式实现的。性能比JDK动态代理要好，（底层有一个小而快的字节码处理框架ASM）
+ javassisit 动态代理技术：javassisit 是一个开源的分析、编辑和创建字节码的类库。是由东京工业大学的数学和计算机科学系的 Shigeru Chiba （千叶 滋）所创建的。它加入了开放源代码 JBoss 应用服务器项目，通过使用 javassisit 对字节码操作为 JBoss 实现了动态的 “AOP” 框架。

### 3.1 JDK动态代理

继续使用静态代理中的例子，一个 接口 和一个 实现类 。

```java
package com.sangui.mall.service;
/**
 * @Author: sangui
 * @CreateTime: 2025-05-31
 * @Description:
 * @Version: 1.0
 */
public interface OrderService {
    /**
     * 测试有返回值的情况
     * @return 字符串
     */
    String getName();
    /**
     * 生成订单
     */
    void generate();
    /**
     * 修改订单信息
     */
    void modify();
    /**
     * 查看订单明细
     */
    void detail();
}
```

```java
package com.sangui.mall.service.impl;
import com.sangui.mall.service.OrderService;
/**
 * @Author: sangui
 * @CreateTime: 2025-05-31
 * @Description:
 * @Version: 1.0
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public String getName() {
        System.out.println("getName method execute！！");
        return "zhangsan";
    }
    @Override
    public void generate() {
        // 假设这是业务代码，模拟实际项目生成订单耗时
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("订单已生成！！");
    }
    @Override
    public void modify() {
        //假设这是业务代码，模拟实际项目修改订单耗时
        try {
            Thread.sleep(456);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("订单已修改！！");
    }
    @Override
    public void detail() {
        //假设这是业务代码，模拟实际项目查询订单耗时
        try {
            Thread.sleep(111);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("订单请查看！！.........展开");
    }
}
```

```java
package com.sangui.mall.service;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * @Author: sangui
 * @CreateTime: 2025-06-01
 * @Description: 专门负责计时的调用处理器对象
 * @Version: 1.0
 */
public class TimerInvocationHandler implements InvocationHandler {
    OrderService target;
    public TimerInvocationHandler() {
    }
    public TimerInvocationHandler(OrderService target) {
        this.target = target;
    }
    /**
     * 1.为什么强行要求必须实现 InvocationHandler 接口？
     *      因为一个类的 实现接口必须要实现接口中的方法
     *      一下这个方法必须是 invoke()，因为JDK是在底层调用 invoke（）方法的程序已经提前写好了
     *      注意：invoke方法不是我们程序员负责调用的，
     * 2.invoke方法什么时候被调用？
     *      当代理对象调用代理方法的时候，就会被调用
     * 3.invoke方法里的三个参数
     *      第一个参数：proxy
     *          是代理对象，这个参数使用较少
     *      第二个参数：method
     *          是目标对象的目标对象，要执行的方法就是它
     *      第三个参数：args
     *          是目标方法上的参数，即实参
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //System.out.println(proxy);
        long begin = System.currentTimeMillis();
        Object returnValue = method.invoke(target, args);
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - begin) + "ms");
        return returnValue;
    }
}
```

在动态代理中，就不需要手写 代理类 了，在动态代理中，XXXXProxy类 是可以动态生成的。这个类不需要写，只需要直接运行客户端程序即可。

```java
package com.sangui.mall.client;
import com.sangui.mall.service.OrderService;
import com.sangui.mall.service.TimerInvocationHandler;
import com.sangui.mall.service.impl.OrderServiceImpl;
import java.lang.reflect.Proxy;
/**
 * @Author: sangui
 * @CreateTime: 2025-06-01
 * @Description:
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        // 创建目标对象
        OrderService target = new OrderServiceImpl();
        // 创建代理对象
        /**
         * 这是新建代理对象代码，
         * 本质上，这个方法做了两件事：在内存中动态生成了代理类的字节码class，和new对象了
         * 关于这个方法的三个参数，含义，怎么用。
         * 1.ClassLoader loader
         *      类加载器，在内存中生成的字节码也是class文件，要执行也得加载到内存中，加载类就需要类加载器，所以这里要指定类加载器
         *      目标类的类加载器 必须和代理类的加载器一致
         * 2.Class<?>[] interfaces
         *      代理类和目标类要实现同一个接口，或同一些接口
         * 3.InvocationHandler h
         *      调用处理器，这是个接口
         *      在调用处理器中编写的就是：增强代码
         *      因为具体要什么代码，JDK代理技术它是不知道的
         *      既然是接口，那一定要写实现类
         *          为什么？------你可能会有疑问，为什么还会动手写接口的实现类，这不会类爆炸吗？不会，
         *          因为这种调用处理器写一次就好
         * 注意：代理对象和目标对象实现的接口一样，所以可以向下转型
         */
        OrderService proxy = (OrderService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                                                                   target.getClass().getInterfaces(),
                                                                   new TimerInvocationHandler(target));
        // 调用代理对象的代理方法
        proxy.detail();
        proxy.modify();
        proxy.generate();
        String s = proxy.getName();
        System.out.println(s);
    }
}
```

我们可以提供一个工具类：ProxyUtil，封装一个方法：

```
package com.sangui.mall.utils;
import com.sangui.mall.service.TimerInvocationHandler;
import java.lang.reflect.Proxy;
/**
 * @Author: sangui
 * @CreateTime: 2025-06-01
 * @Description:
 * 对
 * OrderService proxy = (OrderService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
 *                                                                    target.getClass().getInterfaces(),
 *                                                                    new TimerInvocationHandler(target));
 * 这一段代码进行的封装
 * @Version: 1.0
 */
public class ProxyUtil {
    private ProxyUtil() {
    }
    public static Object newProxyInstance(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new TimerInvocationHandler(target));
    }
}
```

这样客户端代码就不需要写那么繁琐了：

```java
//        OrderService proxy = (OrderService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
//                                                                   target.getClass().getInterfaces(),
//                                                                   new TimerInvocationHandler(target))
OrderService proxy = (OrderService)ProxyUtil.newProxyInstance(target);
```

### 3.2 CGLIB动态代理

CGLIB既可以代理接口，又可以代理类。底层采用继承的方式实现。所以被代理的目标类不能使用final修饰

使用CGLIB，需要引入他的依赖

```
<dependency>
    <groupId>cglib</groupId>
    <artifactId>cglib</artifactId>
    <version>3.3.0</version>
</dependency>
```

```java
package com.sangui.mall.service;
/**
 * @Author: sangui
 * @CreateTime: 2025-06-01
 * @Description:
 * @Version: 1.0
 */
public class UserService {
    public boolean login(String username, String password){
        System.out.println("正在验证身份中......");
        if ("admin".equals(username) && "123".equals(password)){
            return true;
        }
        return false;
    }
    public void logout(){
        System.out.println("退出系统中......");
    }
}
```

```java
package com.sangui.mall.service;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;
/**
 * @Author: sangui
 * @CreateTime: 2025-06-01
 * @Description:
 * @Version: 1.0
 */
public class TimerMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        long begin = System.currentTimeMillis();
        Object returnValue = methodProxy.invokeSuper(o, objects);
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - begin) + "ms");
        return returnValue;
    }
}
```

```java
package com.sangui.mall.client;
import com.sangui.mall.service.TimerMethodInterceptor;
import com.sangui.mall.service.UserService;
import net.sf.cglib.proxy.Enhancer;
/**
 * @Author: sangui
 * @CreateTime: 2025-06-01
 * @Description: 客户端程序
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        // 创建字节码增强器对象
        Enhancer enhancer = new Enhancer();

        // 告诉CGLIB父类是谁，即目标类是谁。
        enhancer.setSuperclass(UserService.class);

        // 设置回调（等同于JDK动态代理当中的调用处理器，InvocationHandler）
        enhancer.setCallback(new TimerMethodInterceptor());

        // 创建代理对象（Step1:在内存中生成子类，即代理类的字节码文件，Step2:创建代理对象）
        UserService agent = (UserService) enhancer.create();

        agent.login("admin", "123");
        agent.login("admin","123456");
        agent.logout();
    }
}
```

对于高版本的JDK，如果使用CGLIB，需要在启动项中添加两个启动参数：

- --add-opens java.base/java.lang=ALL-UNNAMED
- --add-opens java.base/sun.net.util=ALL-UNNAMED
