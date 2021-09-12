package com.zzy.service;

import com.zzy.dao.pojo.Article;
import com.zzy.vo.Result;
import com.zzy.vo.TagVo;

import java.util.List;

public interface TagService {
    List<TagVo> findTagsArticleId(Long articleId);

    Result hots(int limit);

}
