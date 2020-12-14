package com.hu.lingoapp.game.domain.reader;

import java.util.List;

public interface Reader {
    List<String> readWordsFromTxtFile(String fileName);
}
