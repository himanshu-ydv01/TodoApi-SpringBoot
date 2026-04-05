package org.example.todoapispring;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    private static List<Todo> todolist;

    public TodoController() {
        todolist = new ArrayList<>();
        todolist.add(new Todo(1,false,"todo 1",1));
        todolist.add(new Todo(2,false,"todo 2",2));

    }

    @GetMapping("/todos")
    public static List<Todo> getTodos() {
        return todolist;
    }

    @PostMapping("/todos")
    public static List<Todo> CreateTodos(@RequestBody Todo newtodo){
        todolist.add(newtodo);
        return todolist;
    }
}
