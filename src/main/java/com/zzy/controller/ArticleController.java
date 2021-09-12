package com.zzy.controller;

import com.zzy.service.ArticleService;
import com.zzy.vo.Result;
import com.zzy.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//json数据进行交互
@RestController
@RequestMapping("articles")
public class ArticleController {

    /**
     * 首页 文章列表
     */
    @Autowired
    private ArticleService articleService;


    @PostMapping
    public Result listArticle(@RequestBody PageParams pageParams) {

        return  articleService.listArticle(pageParams);
    }
}
