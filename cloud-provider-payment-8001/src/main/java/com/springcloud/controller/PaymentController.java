package com.springcloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.springcloud.entity.CommonResult;
import com.springcloud.entity.Payment;
import com.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果：" + result);
        if (result > 0) {
            return new CommonResult<Integer>(200, "插入数据库成功", result);
        } else {
            return new CommonResult<Integer>(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult<Payment>(200, "查询成功", payment);
        } else {
            return new CommonResult<Payment>(444, "没有对应记录,查询ID: " + id, null);
        }
    }

    @GetMapping(value="/payment/discovery")
    public Object discovery(){
        //根据微服务名称获取 注册到eureka上的这个服务名对应的所有实例信息
        List<InstanceInfo> instances = discoveryClient.getInstancesById("CLOUD-PAYMENT-SERVICE");
        for(InstanceInfo info : instances){
            //获取实例对应的ip 和 端口号
            System.out.println(info.getIPAddr() + ":" + info.getPort());
            System.out.println(info.getHomePageUrl());
        }

        return discoveryClient;
    }
}
