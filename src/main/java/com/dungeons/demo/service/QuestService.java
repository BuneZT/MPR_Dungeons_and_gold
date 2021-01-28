package com.dungeons.demo.service;

import com.dungeons.demo.model.Quest;
import com.dungeons.demo.repository.QuestRepository;
import org.springframework.stereotype.Service;

@Service
public class QuestService {
    private QuestRepository questRepository;


    public QuestService(QuestRepository questRepository) {
        this.questRepository = questRepository;

    }

    public Quest save(Quest quest) {
        return questRepository.save(quest);

    }

    public Quest update(Quest quest) {
        if (questRepository.findById(quest.getId()).isEmpty()) {
            throw new RuntimeException();
        } else {
            return questRepository.save(quest);
        }

    }

    public void deleteById(Long id) {
        questRepository.deleteById(id);
    }
}
