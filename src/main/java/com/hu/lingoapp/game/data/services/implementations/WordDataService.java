package com.hu.lingoapp.game.data.services.implementations;

import com.hu.lingoapp.game.data.dtos.WordDto;
import com.hu.lingoapp.game.data.repositories.WordRepository;
import com.hu.lingoapp.game.data.services.WordData;
import com.hu.lingoapp.game.domain.models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

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

    @Override
    public long countValidWords() {
        return repository.countValidWords();
    }

    @Override
    public List<WordDto> getValidWords() {
        return repository.getValidWords();
    }

    @Override
    public List<WordDto> getValidWordsOf5Letters() {
        return repository.getValidWordsOf5Letters();
    }

    @Override
    public List<WordDto> getValidWordsOf6Letters() {
        return repository.getValidWordsOf6Letters();
    }

    @Override
    public List<WordDto> getValidWordsOf7Letters() {
        return repository.getValidWordsOf7Letters();
    }
}
