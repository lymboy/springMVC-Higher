package com.lym.service;

import com.lym.pojo.Items;

import java.util.List;

public interface ItemService {

    /**
     * 查询商品列表
     * @return
     */
    List<Items> queryItemList();

    /**
     * 通过id查找菜单
     * @param id
     * @return
     */
    Items selectItemsById(Integer id);

    /**
     * 通过 id 更新商品
     * @param item
     */
    void updateItemById(Items item);
}
