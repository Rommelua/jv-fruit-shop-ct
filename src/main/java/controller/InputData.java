package controller;

import java.util.List;

/*
 * Implementation of this Interface allows input data from a source
 */
public interface InputData {
    public List<String> getData(String path);
}
