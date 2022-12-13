package com.example.teacker;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class controller {
    ArrayList<task> tasks = new ArrayList<>();
    @GetMapping("/tasks")
    public ArrayList<task>getTasks(){
        return tasks;
    }



@PostMapping("/creat")
    public ApiResponse creatTask(@RequestBody task task){

        tasks.add(task);
        return new ApiResponse("Task created");

    }
    @PutMapping("/update/{index}")
    public ApiResponse taskUpdate(@PathVariable int index,@RequestBody task task){

        tasks.set(index, task);
        return new ApiResponse("task updated");
    }
    @DeleteMapping("/{index}")
    public ApiResponse delateTask(@PathVariable int index){
        tasks.remove(index);
        return new ApiResponse("user delated");
    }
    @PutMapping("/status/{index}")
    public ApiResponse changeStatus(@PathVariable int index,@RequestBody task task){

        tasks.set(index, task);
        return new ApiResponse("status change");
    }
    @GetMapping("/search/{title}")
    public ApiResponse searchTask(@PathVariable String title){

        for(int i=0;i<=tasks.size();i++) {
            if (title.equals(tasks.get(i).getTitle())) return new ApiResponse("task found");
        }
        return new ApiResponse("task not found");

    }


}
