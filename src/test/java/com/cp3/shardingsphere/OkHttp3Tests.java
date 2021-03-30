package com.cp3.shardingsphere;

import cn.hutool.json.JSONUtil;
import com.cp3.shardingsphere.entity.OrderDTO;
import okhttp3.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Configuration
public class OkHttp3Tests {

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
    private TestRestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
        String url = String.format("http://localhost:%d/sharding/", 18090);
        System.out.println(String.format("port is : [%d]", port));
        this.base = new URL(url);
    }

    @Test
    public void createOrder() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setGoodName("ZTE");
        orderDTO.setBuyer("cp3");
        String json = JSONUtil.toJsonStr(orderDTO);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(this.base.toString()+ "/order/create")
                .method("POST", body)
                .addHeader("Content-Type","application/json")
                .build();
        Response response = client.newCall(request).execute();
        String r = response.body().string();
    }

    @Test
    public void query() throws Exception {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(this.base.toString()+"/order/query?buyer=cp3")
                .addHeader("Content-Type","application/json")
                .build();
        Response response = client.newCall(request).execute();
        String r = response.body().string();
    }

}

