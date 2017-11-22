package mapping;

import pojo.ItemsCustom;
import pojo.ItemsQueryVo;

import java.util.List;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 11:47 2017/11/17
 * @Modified By:
 */
public interface ItemsCustomMapper {
    //商品查询列表
    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}
