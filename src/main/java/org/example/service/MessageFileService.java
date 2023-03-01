package org.example.service;

import java.io.*;

public class MessageFileService implements FileService {
    @Override
    public void writeToFile(Object db) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("message.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(db);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    @Override
    public Object readFile() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("message.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return objectInputStream.readObject();
    }
}
