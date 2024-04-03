package com.liantai.controller;

import com.liantai.domain.ResponseInfo;
import com.liantai.domain.TodoEntity;
import com.liantai.domain.request.CompleteTodoRequest;
import com.liantai.domain.request.CreateTodoRequest;
import com.liantai.domain.request.DeleteTodoRequest;
import com.liantai.domain.request.EditTodoRequest;
import com.liantai.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luHan
 * @create 2024/4/3 14:43
 * @since 1.0.0
 */
@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @RequestMapping("/create")
    public ResponseInfo createTodo(@RequestBody CreateTodoRequest request) {
        TodoEntity todoEntity = todoService.createTodo(request);
        return ResponseInfo.success(todoEntity);
    }


    @RequestMapping("/delete")
    public ResponseInfo deleteTodo(@RequestBody DeleteTodoRequest request) {
        todoService.deleteTodo(request);
        return ResponseInfo.success();
    }

    @RequestMapping("/complete")
    public ResponseInfo completeTodo(@RequestBody CompleteTodoRequest request) {
        todoService.completeTodo(request);
        return ResponseInfo.success();
    }

    @RequestMapping("/edit")
    public ResponseInfo editTodo(@RequestBody EditTodoRequest request) {
        todoService.editTodo(request);
        return ResponseInfo.success();
    }
}
