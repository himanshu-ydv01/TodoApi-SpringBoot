package org.example.todoapispring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;    // this is called composition in OOP

    private static List<Todo> todolist;

    public TodoController() {
        //this.todoService = new FakeTodoService();

        todolist = new ArrayList<>();
        todolist.add(new Todo(1,false,"todo 1",1));
        todolist.add(new Todo(2,false,"todo 2",2));


    }

    /*
    @GetMapping("/todos")
    public static List<Todo> getTodos() {
        return todolist;
    }

    @PostMapping("/todos")
    public static List<Todo> CreateTodos(@RequestBody Todo newtodo){
        todolist.add(newtodo);
        return todolist;
    }
     */

    @GetMapping
    public ResponseEntity <List<Todo>> getTodos(@RequestParam(required = false)Boolean isComplete) {
        System.out.println("getTodos isComplete " + isComplete + " " + this.todoService.doSomething());
        return ResponseEntity.ok(todolist);
    }

    @PostMapping
    public ResponseEntity<Todo> CreateTodos(@RequestBody Todo newtodo){
        todolist.add(newtodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newtodo);
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<Todo>  getTodoById(@PathVariable long todoId){
        for(Todo todo: todolist){
            if(todo.getId() == todoId){
                return ResponseEntity.ok(todo);
            }
        }
        return ResponseEntity.notFound().build();
    }
}
