package com.kgc.service.impl;

import com.kgc.mapper.GoodsMapper;
import com.kgc.pojo.Goods;
import com.kgc.pojo.GoodsExample;
import com.kgc.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("goodsService")
public class GoodsServiceimpl implements GoodsService {
    @Resource
    GoodsMapper goodsMapper;
    @Override
    public List<Goods> selectBygoodsdistrict(Integer goodsDistrict) {
        GoodsExample example=new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();
        if (goodsDistrict==0){
            return goodsMapper.selectByExample(null);
        }
        if(goodsDistrict!=0){
            criteria.andGoodsdistrictEqualTo(goodsDistrict);
        }
        return goodsMapper.selectByExample(example);
    }

    @Override
    public Goods selectById(int id) {
        return goodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public void upd(Goods goods) {
        goodsMapper.updateByPrimaryKeySelective(goods);
    }
}
