# GoF之工厂模式

+ 设计模式是指一种可以被重复利用的解决方案。

+ GoF（Gang of Four）。四人组

+ 《Design Patterns: Elements of Reusable Object-Oriented Software》（即《设计模式》一书），1995年由 Erich Gamma、Richard Helm、Ralph Johnson 和 John Vlissides 合著。这几位作者常被称为"四人组（Gang of Four）"。
+ 该书描述了23种设计模式，我们平常所说的设计模式就是指这23种设计模式。
+ 不过除了GoF23种设计模式之外，还有其他的设计模式，比如：JavaEE的设计模式，（DAO模式，MVC模式等）
+ GoF设计模式可以分为三大类
  + 创建型（5个）：解决对象创建问题
    + 单例模式
    + 工厂方法模式
    + 抽象工厂模式
    + 建造者模式
    + 原型模式
  + 结构型（7个）：一些类或对象组合一起的经典结构
    + 代理模式
    + 装饰模式
    + 适配器模式
    + 组合模式
    + 享元模式
    + 外观模式
    + 桥接模式
  + 行为型（11个）：解决类或对象之间的交互问题
    + 策略模式
    + 模板方法模式
    + 责任链模式
    + 观察者模式
    + 迭代子模式
    + 命令模式
    + 备忘录模式
    + 状态模式
    + 访问者模式
    + 中介者模式
    + 解释器模式
  + 工厂模式是解决对象创建问题的，所以工厂模式属于创建型设计模式。这里为什么学习工厂模式呢？这是因为Spring框架底层使用了大量的工厂模式

## 1.工厂模式的三种形态

工厂模式通常有三种形态：

+ 第一种： 简单工厂模式（Simple Factory）：不属于23种设计模式之一。简单工厂模式又叫做：静态工厂方法模式。简单工厂模式是工厂方法模式的一种特殊实现
+ 第二种：工厂方法模式（Factory Method）：是23种设计模式之一

+ 第三种：抽象工厂模式（Abstract Factory）：是23种设计模式之一

## 2.简单工厂模式

1. 简单工厂模式是工厂模式的一种特殊实现，又被称为：静态工厂方法模式

2. 简单工厂模式是为了解决什么问题？

   简单工厂模式达到了什么呢？职责分离，客户端不需要关心产品的生产细节，客户端只负责消费
   工厂类只负责生产，一个负责生产，一个负责消费，生产者和消费者分离了，这就是简单工厂模式的作用

3. 简单工厂中的角色有三个

   + 抽象产品角色

   + 具体产品角色

   + 工厂类角色

4. 简单工厂模式的缺点

   缺点一：假设现在需要扩展一个新的产品，WeaponFactory工厂类的代码是需要修改的，显然违背了OCP开闭原则

   缺点二：工厂类的责任比较重大，不能出现任何问题，因为这个工厂负责所以产品的生产，称为全能类，或者称为上帝类

   这个工厂类一旦出现问题，整个系统必然全部瘫痪（不要把所有鸡蛋放到一个篮子里面）

简单工厂模式的代码如下

抽象产品角色：

```
package com.sangui.simple.factory;
/**
 * @Author: sangui
 * @CreateTime: 2025-05-28
 * @Description: 抽象产品角色：武器
 * @Version: 1.0
 */
public abstract class Weapon {
    /**
     * 所以的武器都可以攻击
     */
    public abstract void attack();
}
```

具体产品角色：

```
package com.sangui.simple.factory;
/**
 * @Author: sangui
 * @CreateTime: 2025-05-28
 * @Description: 具体产品角色：匕首
 * @Version: 1.0
 */
public class Dagger extends Weapon{
    @Override
    public void attack() {
        System.out.println("匕首正在攻击！！");
    }
}
```

```
package com.sangui.simple.factory;
/**
 * @Author: sangui
 * @CreateTime: 2025-05-28
 * @Description: 具体产品角色：战斗机
 * @Version: 1.0
 */
public class Fighter extends Weapon{
    @Override
    public void attack() {
        System.out.println("战斗机抛下小男孩！！");
    }
}
```

```
package com.sangui.simple.factory;
/**
 * @Author: sangui
 * @CreateTime: 2025-05-28
 * @Description: 具体产品角色：坦克
 * @Version: 1.0
 */
public class Tank extends Weapon{
    @Override
    public void attack() {
        System.out.println("坦克正在开炮！！");
    }
}
```

工厂类角色：

```
package com.sangui.simple.factory;
/**
 * @Author: sangui
 * @CreateTime: 2025-05-28
 * @Description: 工厂类角色：武器工厂
 * @Version: 1.0
 */
public class WeaponFactory {
    /**
     * 静态方法，要获取什么产品，就看你传什么参数，传 TANK 获取坦克，传 DAGGER 获取匕首，传 FIGHTER 获取战斗机
     * @param weaponType
     * @return
     */
    public static Weapon get(String weaponType){
        if ("TANK".equals(weaponType)) {
            return new Tank();
        }
        if ("DAGGER".equals(weaponType)){
            return new Dagger();
        }
        if ("FIGHTER".equals(weaponType)){
            return new Fighter();
        }
        return null;
    }
}
```

测试程序（客户端程序）：

```
package com.sangui.simple.factory;
/**
 * @Author: sangui
 * @CreateTime: 2025-05-28
 * @Description: 这是客户端程序
 * 对客户来说，坦克的生产细节，我不需要更新，我只需要向工厂索要即可
 * 简单工厂模式达到了什么呢？职责分离，客户端不需要关心产品的生产细节，客户端只负责消费
 * 工厂类只负责生产，一个负责生产，一个负责消费，生产者和消费者分离了，这就是简单工厂模式的作用
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        // 需要坦克
        Weapon tank = WeaponFactory.get("TANK");
        tank.attack();
        // 需要匕首
        Weapon dagger = WeaponFactory.get("DAGGER");
        dagger.attack();
        // 需要战斗机
        Weapon fighter = WeaponFactory.get("FIGHTER");
        fighter.attack();
    }
}
```

执行结果：

```
坦克正在开炮！！
匕首正在攻击！！
战斗机抛下小男孩！！
```

Spring中的BeanFactory就使用了简单工厂模式。

## 3. 工厂方法模式

Factory Method Pattern

工厂方法模式既保留了简单工厂模式的优点，同时又解决了简单工厂的缺点。

+ 怎么解决？

  + 就是一个工厂对应生产一个产品

  + 这样工厂就不是全能类了，不是上帝类了，另外也可以符合OCP开闭原则。

+ 工厂方法模式的角色包括：

  + 抽象产品角色
    + Weapon

  + 具体产品角色
    + Dagger
    + Gun

  + 抽象工厂角色
    + WeapnFactory

  + 具体工厂角色
    + DaggerFactory
    + GunFactory

+ 工厂方法模式的优点：

  当你扩展一个产品的时候，符合OCP原则，因为只需要添加两个类，一个类是具体产品类，一个是具体产品工厂类。都是添加类，没有修改之前的代码 ，所以符合OCP原则

+ 工厂方法模式的缺点：

  每次增加一个产品的时候，都需要增加一个具体类和对象实现工厂，使得系统中的类的个数成倍增加，在一定程度上增加了系统的复杂度，同时也增加了系统具体类的依赖，这并不是什么好事

+ 我的程序

  ```
  package com.sangui.factory.method;
  /**
   * @Author: sangui
   * @CreateTime: 2025-05-29
   * @Description: 具体产品角色：Dagger
   * @Version: 1.0
   */
  public class Dagger extends Weapon{
      @Override
      public void attack() {
          System.out.println("匕首开始攻击了！！");
      }
  }
  ```

  ```
  package com.sangui.factory.method;
  /**
   * @Author: sangui
   * @CreateTime: 2025-05-29
   * @Description: 具体工厂角色：GunFactory
   * @Version: 1.0
   */
  public class DaggerFactory extends WeaponFactory {
      @Override
      public Weapon get() {
          return new Dagger();
      }
  }
  ```

  ```
  package com.sangui.factory.method;
  /**
   * @Author: sangui
   * @CreateTime: 2025-05-29
   * @Description: 具体产品角色：Gun
   * @Version: 1.0
   */
  public class Gun extends Weapon{
      @Override
      public void attack() {
          System.out.println("枪开始射击了！！");
      }
  }
  ```

  ```
  package com.sangui.factory.method;
  /**
   * @Author: sangui
   * @CreateTime: 2025-05-29
   * @Description: 具体工厂角色： GunFactory
   * @Version: 1.0
   */
  public class GunFactory extends WeaponFactory{
      @Override
      public Weapon get() {
          return new Gun();
      }
  }
  ```

  ```
  package com.sangui.factory.method;
  /**
   * @Author: sangui
   * @CreateTime: 2025-05-29
   * @Description: 抽象产品角色
   * @Version: 1.0
   */
  abstract public class Weapon {
      public abstract void attack();
  }
  package com.sangui.simple.factory;
  /**
   * @Author: sangui
   * @CreateTime: 2025-05-28
   * @Description: 工厂类角色：武器工厂
   * @Version: 1.0
   */
  public class WeaponFactory {
      /**
       * 静态方法，要获取什么产品，就看你传什么参数，传 TANK 获取坦克，传 DAGGER 获取匕首，传 FIGHTER 获取战斗机
       * @param weaponType
       * @return
       */
      public static Weapon get(String weaponType){
          if ("TANK".equals(weaponType)) {
              return new Tank();
          }
          if ("DAGGER".equals(weaponType)){
              return new Dagger();
          }
          if ("FIGHTER".equals(weaponType)){
              return new Fighter();
          }
  
          return null;
      }
  }
  ```

  ```
  package com.sangui.factory.method;
  /**
   * @Author: sangui
   * @CreateTime: 2025-05-29
   * @Description: 抽象工厂角色
   * @Version: 1.0
   */
  abstract public class WeaponFactory {
      /**
       * 这个方法不是静态的。是实例方法
       * @return 返回武器
       */
      abstract public Weapon get();
  }
  ```

  ```
  package com.sangui.factory.method;
  /**
   * @Author: sangui
   * @CreateTime: 2025-05-29
   * @Description: 客户端程序
   * @Version: 1.0
   */
  public class Client {
      public static void main(String[] args) {
          WeaponFactory weaponFactory1 = new DaggerFactory();
          WeaponFactory weaponFactory2 = new GunFactory();
          Weapon weapon1 = weaponFactory1.get();
          Weapon weapon2 = weaponFactory2.get();
          weapon1.attack();
          weapon2.attack();
      }
  }
  ```

## 4. 抽象工厂模式（了解）

spring中并没有用到这个抽象工厂模式，但他解决了工厂方法模式的缺点，这里只做了解

+ 抽象工厂模式的优点：
  + 当一个产品族中的多个对象被设计成一起工作时，它能保证客户端始终只使用同一个产品族中的对象
+ 抽象工厂模式的缺点：
  + 产品族扩展非常困难，要增加一个系统的某一个产品，既要在AbstractFactory里加代码，又要在具体的里面加代码

