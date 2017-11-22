package service.impl;

import exception.CustomException;
import mapping.ItemsCustomMapper;
import mapping.ItemsMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pojo.Items;
import pojo.ItemsCustom;
import pojo.ItemsQueryVo;
import service.ItemsService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 11:59 2017/11/17
 * @Modified By:
 */
@Service("itemsService")
public class ItemsServiceImpl implements ItemsService {

    //注入mapper
    @Resource(name="itemsCustomMapper")
    private ItemsCustomMapper itemsCustomMapper;
    @Resource(name="itemsMapper")
    private ItemsMapper itemsMapper;

    //商品的查询列表
    @Override
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception{
        return itemsCustomMapper.findItemsList(itemsQueryVo);
    }

    //根据商品id查询商品信息
    @Override
    public ItemsCustom findItemsById(int id) throws Exception{
        Items items = itemsMapper.selectByPrimaryKey(id);

        //如果查询的商品信息为空，抛出异常自定义的异常
        if(items == null){
            throw new CustomException("修改商品信息不存在");
        }
        //在这里以后随着需求的变化，需要查询商品的其他相关信息，返回到controller
        //所以这个时候用到扩展类更好，如下
        ItemsCustom itemsCustom = new ItemsCustom();
        //将items的属性拷贝到itemsCustom中
        BeanUtils.copyProperties(items,itemsCustom);

        return itemsCustom;
    }

    @Override
    public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception{
        //在service中一定要写业务代码

        //对于关键业务数据的非空检验
        if(id==null){
            //抛出异常，提示调用接口的用户，id不能为空
        }
        itemsMapper.updateByPrimaryKeySelective(itemsCustom);
    }

    @Override
    public void deleteItemsByPrimaryKeyArr(Integer[] id) throws Exception {
        //对于关键业务数据的非空检验
        if(id==null){
            //抛出异常，提示调用接口的用户，id不能为空
        }
        itemsMapper.deleteByPrimaryKeyArr(id);
    }
}
