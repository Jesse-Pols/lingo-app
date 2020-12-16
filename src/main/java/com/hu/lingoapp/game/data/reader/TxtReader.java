package com.hu.lingoapp.game.data.reader;

import java.io.FileNotFoundException;
import java.util.List;

public interface TxtReader {
    List<String> read(String fileName, boolean minimized) throws FileNotFoundException;
}
