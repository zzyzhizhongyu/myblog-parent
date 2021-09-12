package com.zzy.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.zzy.dao.mapper.TagMapper;
import com.zzy.dao.pojo.Tag;
import com.zzy.service.TagService;
import com.zzy.vo.Result;
import com.zzy.vo.TagVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    public TagVo copy(Tag tag){
        TagVo tagVo = new TagVo();
        BeanUtils.copyProperties(tag,tagVo);
        return tagVo;
    }
    public List<TagVo> copyList(List<Tag> tagList){
        List<TagVo> tagVoList = new ArrayList<>();
        for (Tag tag : tagList) {
            tagVoList.add(copy(tag));
        }
        return tagVoList;
    }

    @Override
    public List<TagVo> findTagsArticleId(Long articleId) {
        List<Tag> tags = tagMapper.findTagsArticleId(articleId);
        return copyList(tags);
    }

    @Override
    public Result hots(int limit) {
        List<Long> tagIds= tagMapper.findHotsTagIds(limit);
       if(CollectionUtils.isEmpty(tagIds)) {
           return Result.success(Collections.emptyList());
       }
       List<Tag> tagList=tagMapper.findTagsByTagIds(tagIds);
       return Result.success(tagList);
    }

}
