package org.example.service;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileService {
  public void writeToFile(Object db) throws IOException;
  public Object readFile() throws IOException, ClassNotFoundException;
}
