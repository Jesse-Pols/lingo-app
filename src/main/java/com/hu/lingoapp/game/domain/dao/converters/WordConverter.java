package com.hu.lingoapp.game.domain.dao.converters;

import com.hu.lingoapp.game.data.dtos.WordDto;
import com.hu.lingoapp.game.domain.models.Word;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WordConverter {
    public Word convertEntityToModel(WordDto entity) {
        if (entity == null) return null;
        Word model = new Word();
        model.setId(entity.getId());
        model.setText(entity.getText());
        model.setBundle(entity.getBundle());
        return model;
    }

    public List<Word> convertEntitiesToModels(List<WordDto> entities) {
        if (entities == null) return null;
        List<Word> models = new ArrayList<>();
        for (WordDto entity : entities) {
            Word model = this.convertEntityToModel(entity);
            models.add(model);
        }
        return models;
    }

    public WordDto convertModelToEntity(Word model) {
        if (model == null) return null;
        WordDto entity = new WordDto();
        entity.setId(model.getId());
        entity.setText(model.getText());
        entity.setBundle(model.getBundle());

        return entity;
    }

    public List<WordDto> convertModelsToEntities(List<Word> models) {
        if (models == null) return null;
        List<WordDto> entities = new ArrayList<>();
        for (Word model : models) {
            WordDto entity = this.convertModelToEntity(model);
            entities.add(entity);
        }
        return entities;
    }
}
