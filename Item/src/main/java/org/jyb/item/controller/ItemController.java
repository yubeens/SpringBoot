package org.jyb.item.controller;

import groovy.util.logging.Log4j;
import org.jyb.item.dto.ItemDTO;
import org.jyb.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/item")
@Log4j
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/list")
    public void list(Model model) {
        List<ItemDTO> itemList = itemService.readAllItem();
        model.addAttribute("itemList", itemList);
    }
}
