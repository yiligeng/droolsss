package com.example.droolsss.test;

import com.example.entity.Customer;
import com.example.entity.Order;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @Project ：droolsss
 * @File ：TestDrools.java
 * @Author ：gyl
 * @Date ：2023/7/5 4:30 PM
 */

public class TestDrools {
    @Test
    public void test1(){
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kieSession = kContainer.newKieSession();
//        ClassTag<KieBase> classTagTest = scala.reflect.ClassTag$.MODULE$.apply(KieBase.class);
//        Broadcast<KieBase> broadcastRules = context.broadcast(kContainer.getKieBase(), classTagTest);
//        finalJoined.foreach(row -> droolprocess(broadcastRules.value(),row));


        //构造订单对象，设置原始价格，由规则引擎根据优惠规则计算优惠后的价格
        Order order = new Order();
        order.setOriginalPrice(150D);


        //将数据提供给规则引擎，规则引擎会根据提供的数据进行规则匹配
        kieSession.insert(order);

        //激活规则引擎，如果规则匹配成功则执行规则
        kieSession.fireAllRules();
        //关闭会话
        kieSession.dispose();

        System.out.println("优惠前原始价格：" + order.getOriginalPrice() +
                "，优惠后价格：" + order.getRealPrice());
    }


    @Test
    public void test2(){
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kieSession = kContainer.newKieSession();
//        ClassTag<KieBase> classTagTest = scala.reflect.ClassTag$.MODULE$.apply(KieBase.class);
//        Broadcast<KieBase> broadcastRules = context.broadcast(kContainer.getKieBase(), classTagTest);
//        finalJoined.foreach(row -> droolprocess(broadcastRules.value(),row));


        //构造订单对象，设置原始价格，由规则引擎根据优惠规则计算优惠后的价格
        Order order = new Order();
        order.setOriginalPrice(150D);
        Customer customer = new Customer();
        customer.setAge(21);
        customer.setGender("男");

        //将数据提供给规则引擎，规则引擎会根据提供的数据进行规则匹配
        kieSession.insert(order);
        kieSession.insert(customer);

        //激活规则引擎，如果规则匹配成功则执行规则
        kieSession.fireAllRules();
        //关闭会话
        kieSession.dispose();

        System.out.println("优惠前原始价格：" + order.getOriginalPrice() +
                "，优惠后价格：" + order.getRealPrice());
    }

}
