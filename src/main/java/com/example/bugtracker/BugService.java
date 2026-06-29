package com.example.bugtracker;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BugService {

    private final BugRepository bugRepository;


    public BugService(BugRepository bugRepository) {
        this.bugRepository = bugRepository;
    }

    // 1. Get all bugs
    public List<Bug> getAllBugs() {
        return bugRepository.findAll();
    }


    public Bug createBug(Bug bug) {

        if (bug.getStatus() == null || bug.getStatus().isEmpty()) {
            bug.setStatus("OPEN");
        }
        return bugRepository.save(bug);
    }


    public Bug getBugById(Long id) {
        return bugRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bug not found with id: " + id));

    }
    public Bug updateBug(Long id,Bug updatedBugDetail){
        Bug exsistingBug = bugRepository.findById(id).orElseThrow(()-> new RuntimeException(("sry bug not fouind"+id)));

        exsistingBug.setTitle(updatedBugDetail.getTitle());
        exsistingBug.setDescription(updatedBugDetail.getDescription());
         exsistingBug.setPriority(updatedBugDetail.getPriority());
         exsistingBug.setStatus(updatedBugDetail.getStatus());

         return bugRepository.save(exsistingBug);
    }
    void deleteBug(Long id){
        Bug exsistingBug = bugRepository.findById(id).orElseThrow(()-> new RuntimeException(("sry bug not fouind"+id)));
        bugRepository.delete(exsistingBug);
    }
}