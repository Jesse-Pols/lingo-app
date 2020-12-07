package com.hu.lingoapp.game.domain.dao.converters;

import com.hu.lingoapp.game.data.dtos.WordDto;
import com.hu.lingoapp.game.domain.models.Word;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WordConverter {
    public Word convertEntityToModel(WordDto entity) {
        Word model = new Word();
        model.setId(entity.getId());
        model.setLanguage(entity.getLanguage());
        model.setText(entity.getText());

        return model;
    }

    public List<Word> convertEntitiesToModels(List<WordDto> entities) {
        List<Word> models = new ArrayList<>();
        for (WordDto entity : entities) {
            Word model = this.convertEntityToModel(entity);
            models.add(model);
        }
        return models;
    }

    public WordDto convertModelToEntity(Word model) {
        WordDto entity = new WordDto();
        entity.setId(model.getId());
        entity.setLanguage(model.getLanguage());
        entity.setText(model.getText());

        return entity;
    }

    public List<WordDto> convertModelsToEntities(List<Word> models) {
        List<WordDto> entities = new ArrayList<>();
        for (Word model : models) {
            WordDto entity = this.convertModelToEntity(model);
            entities.add(entity);
        }
        return entities;
    }
}
