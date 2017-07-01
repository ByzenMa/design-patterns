package com.nlp.basic.designPattern.singleton;

/**
 * 该示例演示如何进行一个线程安全的单例模式。
 * 可以在：https://dzone.com/articles/singleton-design-pattern-%E2%80%93 中进行详细的了解。
 * 主要在于双检测机制在保证线程安全的基础之上，同时保证效率
 * 
 * @author mabaizhang
 * @date 2017年6月29日
 */
public class SingletonExample {
	// 单一实例
	private volatile static SingletonExample singletonInstance;

	// 私有初始化方法
	private SingletonExample() {
	}

	// 采用double checked locking 方式保证线程安全和资源消耗最小
	public static SingletonExample getSingletonInstance() {
		if (null == singletonInstance) {// 第一次检测
			synchronized (SingletonExample.class) {// 第二次检测
				if (null == singletonInstance) {
					singletonInstance = new SingletonExample();
					System.out.println("Create a new Singleton Example");
				}
			}
		}
		return singletonInstance;
	}

	public void printSingleton() {
		System.out.println("Inside print Singleton");
	}

	/**
	 * 主方法用于测试
	 * 
	 * @author mabaizhang
	 * @date 2017年6月29日
	 */
	public static void main(String[] args) {
		SingletonExample.getSingletonInstance().printSingleton();
		SingletonExample.getSingletonInstance().printSingleton();
		SingletonExample.getSingletonInstance().printSingleton();
		SingletonExample.getSingletonInstance().printSingleton();
	}

}
