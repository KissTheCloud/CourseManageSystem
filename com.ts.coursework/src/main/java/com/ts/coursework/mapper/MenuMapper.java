package com.ts.coursework.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.ts.coursework.entity.Menu;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<Menu> getAllMenus();
}
