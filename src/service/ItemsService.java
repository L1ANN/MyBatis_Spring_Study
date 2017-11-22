package service;

import pojo.ItemsCustom;
import pojo.ItemsQueryVo;

import java.util.List;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 11:58 2017/11/17
 * @Modified By:
 */
public interface ItemsService {

    //商品的查询列表
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;

    //根据商品id查询商品信息
    public ItemsCustom findItemsById(int id) throws Exception;

    //更新商品信息
    public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception;

    //批量删除商品
    public void deleteItemsByPrimaryKeyArr(Integer[] id) throws Exception;
}
