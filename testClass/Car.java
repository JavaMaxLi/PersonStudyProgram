package com.tasoft.syb.test;

/**
 * 单例模式（懒汉模式）
 */
class Singleton{
    public static 	Singleton singleton;
    private Singleton(){

    }
    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}

/**
 * 单例饿汉模式
 */
class SingletonOne{
    public static SingletonOne singletonOne = new SingletonOne();
    private SingletonOne(){

    }
    public static SingletonOne getInstance() {
        return singletonOne;
    }
}


public interface Car {
    public abstract void run();
    public abstract void stop();
}

class BenC implements Car{

    @Override
    public void run() {
        System.out.println("奔驰车正在开。。。");
    }

    @Override
    public void stop() {
        System.out.println("奔驰车停止了。。。");
    }
}

class BaoM implements Car{

    @Override
    public void run() {
        System.out.println("宝马车正在开。。。");
    }

    @Override
    public void stop() {
        System.out.println("宝马车停止了。。。");
    }
}

class CarFactory {
    public static Car getCar(String type) {
        Car car = null;
        if ("bc".equals(type)) {
            car = new BenC();
        } else if ("bm".equals(type)){
            car = new BaoM();
        }
        return car;
    }
}

class Test{
    public static void main(String[] args) {
        Car car = CarFactory.getCar("bc");
        car.run();
        car.stop();
    }
}


//---------------------------抽象工厂-----------------------------
//1.
interface CarColor{
    void productCarColors();
}

class Red implements CarColor{

    @Override
    public void productCarColors() {
        System.out.print("红色");
    }
}

class White implements CarColor{

    @Override
    public void productCarColors() {
        System.out.print("白色");
    }
}

class Black implements CarColor{

    @Override
    public void productCarColors() {
        System.out.print("黑色");
    }
}

//2.
interface CarMake{
    void brand();
}

class BENZ implements CarMake{

    @Override
    public void brand() {
        System.out.println("奔驰");
    }
}

class BMW implements CarMake{

    @Override
    public void brand() {
        System.out.println("宝马");
    }
}

class Audi implements CarMake{

    @Override
    public void brand() {
        System.out.println("奥迪");
    }
}

//3.创建一个抽象工厂获取CarColor和CarMake
abstract class AbstractFactory{
    abstract CarColor getCarColor(String type);
    abstract CarMake getCarMake(String type);
   /* abstract CarColor getCarColor();
    abstract CarMake getCarMake();*/
}

//4.
class CarColorFactory extends AbstractFactory{

  /*  CarColor getCarColor() {
        return new Red();
    }

    CarMake getCarMake() {
        return new BENZ();
    }*/

    @Override
    CarColor getCarColor(String type) {
        if ("Red".equals(type)) {
            return new Red();
        } else if ("White".equals(type)) {
            return new White();
        } else {
            return new Black();
        }
    }

    @Override
    CarMake getCarMake(String type) {
        if ("BENZ".equals(type)) {
            return new BENZ();
        } else if ("BMW".equals(type)) {
            return new BMW();
        } else {
            return new Audi();
        }
    }
}

class RedUtil extends AbstractFactory{

    @Override
    CarColor getCarColor(String type) {
        return new White();
    }

    @Override
    CarMake getCarMake(String type) {
        return new Audi();
    }
}

class AbstractFactoryTest{
    public static void main(String[] args) {
        AbstractFactory redAbstractFactory = new RedUtil();
        CarColor carColor = redAbstractFactory.getCarColor("");
        carColor.productCarColors();
        CarMake carMake = redAbstractFactory.getCarMake("");
        carMake.brand();

        AbstractFactory abstractFactory = new CarColorFactory();
        CarColor carColor1 = abstractFactory.getCarColor("Black");
        CarMake carMake1 = abstractFactory.getCarMake("BMW");
        carColor1.productCarColors();
        carMake1.brand();

    }
}

//-----------------------------装饰者模式-----------------------------
//1.创建一个接口：
interface Phone{
    void takePhoto();
}

//2.创建实现接口的实体类
class TakePhoto implements Phone{
    @Override
    public void takePhoto() {
        System.out.println("拍照");
    }
}

//3.创建实现了接口的抽象装饰类
abstract class PhoneDecorator implements Phone{
    Phone phone;
    public PhoneDecorator(Phone phone) {
        this.phone = phone;
    }

}

//4.创建扩展了类的实体装饰类
class Music extends PhoneDecorator{
    public Music(Phone phone) {
        super(phone);
    }

    @Override
    public void takePhoto() {
        System.out.println("听歌");
        phone.takePhoto();
    }
}

class Read extends PhoneDecorator{

    public Read(Phone phone) {
        super(phone);
    }

    @Override
    public void takePhoto() {
        System.out.println("看小说");
        phone.takePhoto();
    }
}

class DecoratorPatternDemo {
    public static void main(String[] args) {
        Phone phone = new Read(new Music(new TakePhoto()));
        phone.takePhoto();
    }
}