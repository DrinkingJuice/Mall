package com.example.mallproduct.service.impl;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.utils.PageUtils;
import com.example.common.utils.Query;

import com.example.mallproduct.dao.CategoryDao;
import com.example.mallproduct.entity.CategoryEntity;
import com.example.mallproduct.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        //查出所有分类,以树形结构展示
        List<CategoryEntity> entities = baseMapper.selectList(null);
        //组装成所有分类的树形结构
        //1.找出父id为0的分类，也就是一级分类
        List<CategoryEntity> level1Menu = entities.stream()
                .filter(categoryEntity -> categoryEntity.getParentCid() == 0)
                .map(menu -> {
                    menu.setChildren(getChildren(menu, entities));
                    return menu;
                }) //递归找子菜单
                .sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort()))) //排序
                .toList();
        return level1Menu;
    }

    private List<CategoryEntity> getChildren(CategoryEntity categoryEntity, List<CategoryEntity> list)
    {
        List<CategoryEntity> children = list.stream().filter((categoryEntity1) -> {
            return categoryEntity1.getParentCid() == categoryEntity.getCatId(); //找到当前节点的子节点
        })
                .map(categoryEntity1 -> {
            categoryEntity1.setChildren(getChildren(categoryEntity1, list));
            return categoryEntity1; //找子菜单
                })
                .sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort()))).toList();
        return children;
    }
}