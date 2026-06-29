package com.example.bugtracker;
import java.util.*;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bugs")
public class BugController {
    private final BugService bugService;

    public BugController(BugService bugService){
        this.bugService=bugService;
    }
    @GetMapping
    public List<Bug> getAllBugs() {
        return bugService.getAllBugs();
    }
    @GetMapping("/{id}")
    public Bug getBugById(@PathVariable Long id) {
        return bugService.getBugById(id);
    }
    @PostMapping
    public Bug createBug( @Valid @RequestBody Bug bug) {
        return bugService.createBug(bug);
    }
    @PutMapping("/{id}")
    public  Bug updateBug(@PathVariable Long id,@Valid @RequestBody Bug updateBugDetails){
        return bugService.updateBug(id,updateBugDetails);
    }
}
