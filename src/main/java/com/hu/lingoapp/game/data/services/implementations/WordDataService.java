package com.hu.lingoapp.game.data.services.implementations;

import com.hu.lingoapp.game.data.dtos.WordDto;
import com.hu.lingoapp.game.data.repositories.WordRepository;
import com.hu.lingoapp.game.data.services.WordData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WordDataService implements WordData {
    @Autowired
    private WordRepository repository;

    @Override
    public WordDto save(WordDto word) { return repository.save(word); }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public Optional<WordDto> findById(long id) {
        return repository.findById(id);
    }
}
