package cn.pet.lin.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lwt on 2016/5/24.
 */
public class Provider {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:dubbo/dubbo-provider.xml"});
        context.start();

        System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟
    }

}