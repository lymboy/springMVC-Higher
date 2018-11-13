package com.lym.controller;

import com.lym.exeception.MessageException;
import com.lym.pojo.Items;
import com.lym.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * 显示商品列表
     * @return
     */
    @RequestMapping("/itemList.do")
    public ModelAndView queryItemList() {

        List<Items> items = itemService.queryItemList();

//        if (null == null) {
//            throw new MessageException("商品信息不能为空");
//        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemList", items);
        modelAndView.setViewName("itemList");
        return modelAndView;
    }

    @RequestMapping("/itemEdit.do")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Items items = itemService.selectItemsById(Integer.parseInt(id));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("item", items);
        modelAndView.setViewName("editItem");
        return  modelAndView;
    }

    @RequestMapping("/updateItem.do")
    public ModelAndView updateItem(Items items) {
        System.out.println("*********"+items.getDetail());
        itemService.updateItemById(items);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("item", items);
        modelAndView.setViewName("success");
        return  modelAndView;
    }

    @RequestMapping("/deletes.do")
    public ModelAndView deletes(Integer[] ids) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        return  modelAndView;
    }
}
