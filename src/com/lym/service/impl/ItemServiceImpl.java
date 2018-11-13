package com.lym.service.impl;

import com.lym.mapper.ItemsMapper;
import com.lym.pojo.Items;
import com.lym.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<Items> queryItemList() {
        List<Items> items = itemsMapper.selectByExample(null);
        return items;
    }

    @Override
    public Items selectItemsById(Integer id) {
        Items items = itemsMapper.selectByPrimaryKey(id);
        return items;
    }

    @Override
    public void updateItemById(Items item) {
        item.setCreatetime(new Date());
        itemsMapper.updateByPrimaryKey(item);
    }
}
