package org.ghosttrio.config;

import org.ghosttrio.BadWordFileManager;
import org.ghosttrio.BadWordFilter;
import org.ghosttrio.impl.BadWordFileManagerImpl;
import org.ghosttrio.impl.BadWordFilterImpl;
import org.ghosttrio.util.BadWord;

public class BadWordFilterFactory {

    public static BadWordFilter badWordFilter() {
        return new BadWordFilterImpl();
    }

    public static BadWordFileManager badWordFileManager() {
        return new BadWordFileManagerImpl();
    }

    public static BadWord badWord() {
        return new BadWord();
    }
}
