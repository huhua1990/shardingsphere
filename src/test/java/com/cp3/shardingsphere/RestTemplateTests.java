package com.cp3.shardingsphere;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Configuration
public class RestTemplateTests {

    /**
     * OkHttp3
     *
     * TestRestTemplate
     *
     * MockMvc
     *
     *
    */

    @Value("${server.port}")
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Before
    public void setUp() throws Exception {
        String url = String.format("http://localhost:%d/sharding/", 18090);
        System.out.println(String.format("port is : [%d]", port));
        this.base = new URL(url);
    }

    @Test
    public void createOrder() {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("goodName", "XIAO MI");
        map.add("buyer", "cp3");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        ResponseEntity<String> responseEntity = testRestTemplate.postForEntity(
                this.base.toString()+"/order/create",map,String.class);
        String r = responseEntity.getBody();


//        OrderDTO orderDTO = new OrderDTO();
//        orderDTO.setGoodName("XIAO MI");
//        orderDTO.setBuyer("cp3");
//
//        R r = testRestTemplate.postForObject("/order/create", orderDTO, R.class);
//        System.out.println(r.toString());
    }

    @Test
    public void qurey(){
//        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
//        map.add("buyer", "cp3");
        Map<String, String> map = new HashMap<>();
        map.put("buyer", "cp3");
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/order/query?buyer={buyer}", String.class, map);
        String r = responseEntity.getBody();
//        R r1 = testRestTemplate.getForObject("/order/query?buyer={buyer}", R.class, map);
//        System.out.println(r1.toString());

    }

}

