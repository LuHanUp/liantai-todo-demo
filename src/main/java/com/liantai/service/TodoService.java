package com.liantai.service;

import com.liantai.domain.TodoEntity;
import com.liantai.domain.request.CompleteTodoRequest;
import com.liantai.domain.request.CreateTodoRequest;
import com.liantai.domain.request.DeleteTodoRequest;
import com.liantai.domain.request.EditTodoRequest;
import com.liantai.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author luHan
 * @create 2024/4/3 14:47
 * @since 1.0.0
 */
@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoMapper todoMapper;

    /**
     * 创建一个todo
     *
     * @param request
     * @return
     */
    public TodoEntity createTodo(CreateTodoRequest request) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setTodo(request.getTodo());
        todoEntity.setCompleted(false);
        todoMapper.insert(todoEntity);
        return todoEntity;
    }

    public void deleteTodo(DeleteTodoRequest request) {
        todoMapper.delete(request.getTodoIdList());
    }

    public void completeTodo(CompleteTodoRequest request) {
        todoMapper.complete(request.getTodoIdList());
    }

    public void editTodo(EditTodoRequest request) {
        todoMapper.editTodo(request.getTodoId(),request.getTodo());
    }
}
