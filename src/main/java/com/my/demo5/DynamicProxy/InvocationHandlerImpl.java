package com.my.demo5.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InvocationHandlerImpl implements InvocationHandler {

    private Object subject;//需要被代理的真实对象，也是真正执行业务逻辑的类

    public InvocationHandlerImpl(Object subject) {//通过这个构造方法传入被代理对象
        this.subject = subject;
    }

    /**
     * 该方法负责集中处理动态代理类上的所有方法调用，调用处理器会根据这三个参数进行预处理或分派委托类实现
     * @param proxy //最终生成的代理类实例
     * @param method //被调用的方法对象
     * @param args //调用上面method时传入的参数
     * @return //method对应的方法返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("可以再调用实际方法前做一些事情");
        System.out.println("当前调用的方法是"+method.getName());
        //当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行
        result = method.invoke(subject, args);//需要制定被代理对象和传入参数
        System.out.println(method.getName()+"方法的返回值是："+result);
        System.out.println("可以在调用实际方法后做一些事情");
        System.out.println("----------------");
        return result;//返回method方法执行后的返回值

    }



}
