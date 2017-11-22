package controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pojo.ItemsCustom;
import service.ItemsService;
import valid.ValidGroup1;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 12:23 2017/11/17
 * @Modified By:
 */
@Controller
//定义url的根路径，访问时根路径+方法名的url
@RequestMapping("/items")
public class ItemsController {

    @Resource(name = "itemsService")
    private ItemsService itemsService;

    @RequestMapping("/queryItems.action")
    public ModelAndView queryItems() throws Exception {
        //调用service来查询商品列表
        List<ItemsCustom> itemsList = itemsService.findItemsList(null);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList", itemsList);
        modelAndView.setViewName("itemsList");

        return modelAndView;
    }

//    @RequestMapping(value="/editItems.action",method= RequestMethod.GET)
//    public ModelAndView editItems(HttpServletRequest request) throws Exception{
//        ModelAndView modelAndView= new ModelAndView();
//
//        //调用service查询商品的信息
//        String id = request.getParameter("id");
//        int itemsId = -1;
//        if(id!=null&&id!=""){
//            itemsId = Integer.parseInt(id);
//        }
//        ItemsCustom itemsCustom = itemsService.findItemsById(itemsId);
//
//        modelAndView.addObject("id",id);
//        modelAndView.addObject("itemsCustom",itemsCustom);
//        modelAndView.setViewName("editItem");
//
//        return modelAndView;
//    }

//    @RequestMapping(value="/editItems",method=RequestMethod.GET)
//    public String editItems(Model model,HttpServletRequest request) throws Exception{
//        //调用service查询商品的信息
//        String id = request.getParameter("id");
//        int itemsId = -1;
//        if(id!=null&&id!=""){
//            itemsId = Integer.parseInt(id);
//        }
//        ItemsCustom itemsCustom = itemsService.findItemsById(itemsId);
//
//        model.addAttribute("id",id);
//        model.addAttribute("itemsCustom",itemsCustom);
//
//        return "editItem";
//
//    }

    @RequestMapping(value = "/editItems", method = RequestMethod.GET)
    public void editItems(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="item_id",required = false,defaultValue="1")Integer id) throws Exception {
        //调用service查询商品的信息
        ItemsCustom itemsCustom = itemsService.findItemsById(id);

        request.setAttribute("id",id);
        request.setAttribute("itemsCustom",itemsCustom);

        request.getRequestDispatcher("/WEB-INF/jsp/editItem.jsp").forward(request,response);

    }

    //修改商品页面提交
    @RequestMapping("/editItemsSubmit")
    public String editItemsSubmit(Model model, Integer id, @Validated(value={ValidGroup1.class}) @ModelAttribute(value="itemsCustom")ItemsCustom itemsCustom, BindingResult bindingResult, MultipartFile pictureFile) throws Exception{
        //输出校验错误信息
        //如果参数绑定时出错
        if(bindingResult.hasErrors()){
            //获取错误
            List<ObjectError> errors = bindingResult.getAllErrors();
            model.addAttribute("errors",errors);

            for(ObjectError error:errors){
                //输出错误信息
                System.out.println(error.getDefaultMessage());
            }
            //如果校验错误，仍然回到商品修改页面
            return "editItem";
        }
        //进行图片上传
        if(pictureFile!=null&&pictureFile.getOriginalFilename()!=null&&pictureFile.getOriginalFilename().length()>0){
            //获取图片的保存路径和图片的新名字
            String filePath="C:\\Git\\pictures\\";
            String originalFilename = pictureFile.getOriginalFilename();
            String newFileName = UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));

            //新文件
            File file = new File(filePath+newFileName);
            //将内存中的文件写入磁盘
            pictureFile.transferTo(file);
            //图片上传成功,将图片名字保存到数据库中
            itemsCustom.setPic(newFileName);
        }
        itemsService.updateItems(id,itemsCustom);

        //请求转发
        //return "forward:queryItems.action";

        //重定向
        return "redirect:queryItems.action";

//        return "editItem";
    }

//    //自定义属性编辑器
//    @InitBinder
//    public void initBinder(WebDataBinder binder) throws Exception{
//        //Date.class必须是与controller方法形参pojo属性一致的date类型，这里是java.util.Date
//        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),true));
//    }

    //单独将商品类型的方法提取出来，将方法返回值填充到request域，在页面显示
    @ModelAttribute("itemsType")
    public Map<String,String> getItemsType() throws Exception{
        HashMap<String,String> itemsType = new HashMap<>();
        itemsType.put("001","data type");
        itemsType.put("002","clothes");
        return itemsType;
    }

    //批量删除商品
    @RequestMapping("/deleteItems")
    public String deleteItems(Integer[] deleteId) throws Exception{
        itemsService.deleteItemsByPrimaryKeyArr(deleteId);
        return "redirect:queryItems.action";
    }

    //根据商品id查看商品信息rest接口
    //@requestMapping中指定restful方式的url中的参数，参数需要用{}包起来
    //@PathVariable将url中的参数和形参进行绑定
    @RequestMapping("/viewItems/{id}")
    public @ResponseBody ItemsCustom viewItems(@PathVariable("id")Integer id) throws Exception{
        //调用service查询商品的信息
        ItemsCustom itemsCustom = itemsService.findItemsById(id);
        return itemsCustom;
    }

}


