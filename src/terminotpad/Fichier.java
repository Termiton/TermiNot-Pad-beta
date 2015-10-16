/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terminotpad;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author bgc
 */
public class Fichier {

    private String file;
    private String content;

    
    // GETTERS AND SETTERS
    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // CONTRUCTEURS
    public Fichier(String file, String content) {
        this.file = file;
        this.content = content;
    }

    public Fichier() {
    }

    public void fileWrite() {

        File filer = new File(file);
        try {
            if (!filer.exists()) {
                filer.createNewFile();
            }
            FileWriter writer = new FileWriter(filer);
            writer.write(content);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Erreur: impossible de créer le fichier '"
                    + filer + "'");
        }
    }
    
    public String getExtend() {
        String regex = "[.][a-zA-Z0-9]{3}$";
        String extend = file.split(regex)[1];
        return extend;
    }
    
    @Override
    public String toString() {
        this.file = file.replace("\\", "/");
        return file;
    }
    
}
