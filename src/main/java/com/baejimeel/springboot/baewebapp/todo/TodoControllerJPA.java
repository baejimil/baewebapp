package com.baejimeel.springboot.baewebapp.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@Controller
@SessionAttributes("name")
public class TodoControllerJPA {

    public TodoControllerJPA(TodoRepository todoRepository) {
        super();
        this.todoRepository = todoRepository;
    }

    private TodoRepository todoRepository;

    @GetMapping("list-todos")
    public String listAllTodos(ModelMap model){
        String username = getLoggedInUsername(model);
        List<Todo> todos = todoRepository.findByUsername(username);
        model.addAttribute("todos",todos);
        return "listTodos";
    }


    @GetMapping("add-todo")
    public String showNewTodoPage(ModelMap model){
        String username = getLoggedInUsername(model);
        Todo todo = new Todo(0, username, "default value",
                LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }

    @PostMapping("add-todo")
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if (result.hasErrors()){
            return "todo";
        }
        String username = getLoggedInUsername(model);
        todo.setUsername(username);
        todoRepository.save(todo);
//        todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone() );
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodos(@RequestParam int id){
        //DELETE todo
        todoRepository.deleteById(id);
        return "redirect:list-todos";
    }

    @GetMapping("update-todo")
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model){
        Todo todo = todoRepository.findById(id).get();
        model.addAttribute("todo", todo);
        return "todo";
    }

    @PostMapping("update-todo")
    public String updateTodos(ModelMap model, @Valid Todo todo, BindingResult result){
        if (result.hasErrors()){
            return "todo";
        }

        String username = getLoggedInUsername(model);
        todo.setUsername(username);
        todoRepository.save(todo);
        return "redirect:list-todos";
    }

    private static String getLoggedInUsername(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
