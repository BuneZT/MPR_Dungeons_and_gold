package com.dungeons.demo.controller;

import com.dungeons.demo.model.Quest;
import com.dungeons.demo.service.QuestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quest")
public class QuestController {

    private QuestService questService;

    public QuestController(QuestService questService) {
        this.questService = questService;

    }

    @GetMapping("/list")
    public ResponseEntity<List<Quest>> findAll() {
        return ResponseEntity.ok(questService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quest> findById(@PathVariable Long id) {

        Optional<Quest> optionalQuest = questService.findById((id));


        if (optionalQuest.isPresent()) {
            return ResponseEntity.ok(optionalQuest.get());

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Quest> save(@RequestBody Quest quest) {
        return ResponseEntity.ok(questService.save(quest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        questService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Quest> update(@RequestBody Quest quest) {
        return ResponseEntity.ok(questService.update(quest));

    }


}