package com.dragon.talon.structure.bridge;

/**
 * 桥接模式 这个一个在设计之初立定的一种设计模式
 * 桥接模式将继承关系转化成关联关系，封装了变化，完成了解耦，减少了系统中类的数量，也减少了代码量。
 *      在一个抽象类中，将一个operation进行在一次的抽象画
 * 桥梁模式的优点
 *   ● 抽象和实现分离
 *      这也是桥梁模式的主要特点，它完全是为了解决继承的缺点而提出的设计模式。在该模式下，实现可以不受抽象的约束，不用再绑定在一个固定的抽象层次上。
 *   ● 优秀的扩充能力
 *      看看我们的例子，想增加实现？没问题！想增加抽象，也没有问题！只要对外暴露的接口层允许这样的变化，我们已经把变化的可能性减到最小。
 *   ● 实现细节对客户透明
 *      客户不用关心细节的实现，它已经由抽象层通过聚合关系完成了封装。
 * 桥梁模式的使用场景
     ● 不希望或不适用使用继承的场景
         例如继承层次过渡、无法更细化设计颗粒等场景，需要考虑使用桥梁模式。
     ● 接口或抽象类不稳定的场景
        明知道接口不稳定还想通过实现或继承来实现业务需求，那是得不偿失的，也是比较失败的做法。
     ● 重用性要求较高的场景
        设计的颗粒度越细，则被重用的可能性就越大，而采用继承则受父类的限制，不可能出现太细的颗粒度。
 桥梁模式的注意事项
     桥梁模式是非常简单的，使用该模式时主要考虑如何拆分抽象和实现，并不是一涉及继承就要考虑使用该模式，那还要继承干什么呢？桥梁模式的意图还是对变化的封装，尽量把可能变化的因素封装到最细、最小的逻辑单元中，避免风险扩散。因此读者在进行系统设计时，发现类的继承有N层时，可以考虑使用桥梁模式。
 
 *      下面描述车的手动挡和自动挡的生产 与模型模式相似
 * @author dragonboy 
 */
public abstract class Bridge {
    
    private OperationType type;

    public Bridge(OperationType type) {
        this.type = type;
    }

    public OperationType getType() {
        return type;
    }

    /**
     * 车的创建
     */
    abstract void create();

    public static void main(String[] args) {
        Bridge bzBridge = new BenzCar(new ManualGear());
        Bridge BmwBridge = new BmwCar(new Auto());
        bzBridge.create();
        BmwBridge.create();
    }
    
}
