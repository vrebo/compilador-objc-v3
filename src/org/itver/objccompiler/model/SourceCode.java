package org.itver.objccompiler.model;

import java.io.File;

/**
 *
 * @author Victor Daniel Rebolloso Degante
 */
public class SourceCode {

    private final File codeFile;
    private boolean modified;

    public SourceCode(File codeFile) {
        this.codeFile = codeFile;
    }

    public boolean isModified() {
        return modified;
    }

    public void setModified(boolean m) {
        this.modified = m;
    }

    public File getCodeFile() {
        return codeFile;
    }

}
