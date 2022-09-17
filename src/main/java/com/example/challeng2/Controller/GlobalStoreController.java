package com.example.challeng2.Controller;

import com.example.challeng2.Models.Categories;
import com.example.challeng2.Models.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class GlobalStoreController {
    List<Item> items = new ArrayList<>();
    List<Categories> categories = Arrays.asList(
            new Categories("Furniture"),
            new Categories("Office Supplies"),
            new Categories("Technology")
    );

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        Item item;
        if (getItemIndex(id) == -1000) {
            item = new Item();
        } else {
            item = items.get(getItemIndex(id));
        }
        model.addAttribute("categories", categories);
        model.addAttribute("item", item);
        return "form";
    }

    @PostMapping(value = "/handlesubmit")
    public String UpsertItem(Item item) {
        var index = getItemIndex(item.getId());
        if (index == -1000) {
            items.add(item);
        } else {
            items.set(index, item);
        }
        return "redirect:/inventory";
    }

    @GetMapping(value = "/inventory")
    public String getInvetory(Model model) {
        model.addAttribute("items", items);
        return "inventory";
    }


    private Integer getItemIndex(String id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1000;
    }
}
