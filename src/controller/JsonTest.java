package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.ItemsCustom;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 11:43 2017/11/21
 * @Modified By:
 */
@Controller
public class JsonTest {
    //请求json响应json，请求商品信息（该信息为json格式，在页面中通过ajax向写入用户请求的json信息,需要加入的@RequestBody注解）
    //商品信息用json格式输出商品信息（请求的url实际返回的是itemsCustom对象，但由于使用了@ResponseBody就将pojo对象转换成json格式的数据
    @RequestMapping("/requestJson")
    public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom) throws Exception{
        return itemsCustom;
    }

    //请求key/value（在页面中通过ajax写入用户向请求的可以key/value信息，不需要加@RequestBody注解）
    //响应json（由于action返回的是itemsCustom对象，所以需要加入@ResponseBody注解将pojo对象转换成json格式响应给用户
    @RequestMapping("/responseJson")
    public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom) throws Exception{
        return itemsCustom;
    }
}
