/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author dani
 */
public class UserDirExample {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        File newFile = new File("example.txt");
        newFile.createNewFile();
    }
}
