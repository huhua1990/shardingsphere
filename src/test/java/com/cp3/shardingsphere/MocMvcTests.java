package com.cp3.shardingsphere;

import cn.hutool.json.JSONUtil;
import com.cp3.shardingsphere.entity.OrderDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MocMvcTests {

    /**
     * OkHttp3
     *
     * TestRestTemplate
     *
     * MockMvc
     *
     *
    */

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createOrder() throws Exception{
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setGoodName("HUA WEI");
        orderDTO.setBuyer("cp3");
        String request = JSONUtil.toJsonStr(orderDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/order/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request)).andDo(print());
    }

    @Test
    public void get() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/order/query")
                .contentType(MediaType.APPLICATION_JSON)
                .param("buyer","cp3")).andDo(print());
    }

}

