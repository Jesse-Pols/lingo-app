package com.hu.lingoapp.game.domain.dao.services;

import com.hu.lingoapp.game.data.dtos.WordDto;
import com.hu.lingoapp.game.data.services.WordData;
import com.hu.lingoapp.game.domain.dao.WordDao;
import com.hu.lingoapp.game.domain.dao.converters.WordConverter;
import com.hu.lingoapp.game.domain.models.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordDaoService implements WordDao {

    @Autowired
    private WordData data;

    @Autowired
    private WordConverter converter;

    @Override
    public Word save(Word word) {
        WordDto wordDto = converter.convertModelToEntity(word);
        WordDto returningWord = data.save(wordDto);
        return converter.convertEntityToModel(returningWord);
    }

}
