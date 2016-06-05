package com.controller;

import com.entities.Article;
import com.entities.dao.ArticleDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.sql.Date;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {
    @Autowired
    private ArticleDao _articleDao;

    @RequestMapping(value = "/add")
    @ResponseBody
    public String create(double price, int stock, double shoppingPrice, String name, String description) {
        try {
            Article article = new Article(price, stock, shoppingPrice, name, description);
            _articleDao.save(article);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Article succesfully added!";
    }

}
