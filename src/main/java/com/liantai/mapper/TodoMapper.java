package com.liantai.mapper;

import com.liantai.domain.TodoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author luHan
 * @create 2024/4/3 13:32
 * @since 1.0.0
 */
@Mapper
public interface TodoMapper {

    /**
     * 添加todo信息
     *
     * @param todoEntity
     */
    void insert(TodoEntity todoEntity);

    /**
     * 删除指定todo
     *
     * @param todoIdList
     */
    void delete(@Param("todoIdList") List<Long> todoIdList);

    /**
     * 完成指定todo
     *
     * @param todoIdList
     */
    void complete(@Param("todoIdList") List<Long> todoIdList);

    /**
     * 修改指定todo内容
     *
     * @param todoId
     * @param todo
     */
    void editTodo(@Param("todoId") Long todoId, @Param("todo") String todo);
}
