package com.zzy.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzy.dao.pojo.Tag;

import java.util.List;

public interface TagMapper extends BaseMapper<Tag> {
    List<Tag> findTagsArticleId(Long articleId);

    List<Long> findHotsTagIds(int limit);

    List<Tag> findTagsByTagIds(List<Long> tagIds);
}