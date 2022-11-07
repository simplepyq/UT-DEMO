package cn.niko.ut.demo.openapi.controller;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import cn.niko.ut.demo.openapi.controller.pojo.MvcDemoRequest;
import cn.niko.ut.demo.openapi.controller.pojo.MvcDemoResponse;
import cn.niko.ut.demo.service.CategoryService;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author yongqi.pan
 * @since 2022/11/7 15:51
 */
@RunWith(SpringRunner.class)
@WebMvcTest(DemoController.class)
public class DemoControllerTest {

    @Resource
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    @Test
    public void test() throws Exception {
        String uri = "/ut/mvc/demo";

        MvcDemoRequest request = new MvcDemoRequest();
        request.setName("name");

        RequestBuilder builder = MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JSON.toJSONString(request));
        Mockito.when(categoryService.getCategoryByName("name")).thenReturn("历史");
        mockMvc.perform(builder).andExpect(status().is2xxSuccessful()).andExpect(result -> {
            assertEquals("历史", JSON.parseObject(result.getResponse().getContentAsString(), MvcDemoResponse.class).getCategory());
        });
    }
}