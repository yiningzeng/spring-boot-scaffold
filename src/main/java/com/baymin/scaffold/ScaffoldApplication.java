package com.baymin.scaffold;

import com.baymin.scaffold.entity.XmlFlow;
import com.baymin.scaffold.ret.R;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.MultipartConfigElement;

/**
 * jpa属性详解
 * https://www.w3cschool.cn/java/jpa-column-unique-nullable.html
 * 原型 https://pro.modao.cc/app/42d72de617fab9ec148474a4bb696ad029806028#screen=sE1496AC6781533113614692
 */
@Controller
@RestController
@RequestMapping
@SpringBootApplication
@Configuration
@EnableAdminServer
@Slf4j
@EnableCaching
@EnableScheduling
public class ScaffoldApplication {

    @Value("${server.port}")
    private String port;

    public static void main(String[] args) {

        SpringApplication.run(ScaffoldApplication.class, args);
    }

    @PostMapping(value = "/api/xml", consumes = { MediaType.APPLICATION_XML_VALUE }, produces = MediaType.APPLICATION_XML_VALUE)
    public Object post(@RequestBody XmlFlow xmlFlow) throws Exception {
        log.info("==============end==============={}",xmlFlow.toString());
        return R.success();
    }

    @ResponseBody
    @RequestMapping(value = "/test/json", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getByJSON(@RequestBody JSONObject jsonParam) {
        // 直接将json信息打印出来
//        System.out.println(jsonParam.toJSONString());
        log.info(jsonParam.toJSONString());
        log.info("==============end===============");
        return "res";
    }


    /**
     * 文件上传配置
     *
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //  单个数据大小
        factory.setMaxFileSize("10MB"); // KB,MB
        /// 总上传数据大小
        factory.setMaxRequestSize("20MB");
        return factory.createMultipartConfig();
    }

}
