package ReadFile;

import model.Picture;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) {
        try {
            readfile("C:\\Users\\goodman\\Pictures\\Saved Pictures");
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        System.out.println("ok");
    }


    public static boolean readfile(String filepath) throws FileNotFoundException, IOException {
        try {

            List<Picture> pictureList = new ArrayList();
            File file = new File(filepath);
            if (!file.isDirectory()) {
                //System.out.println(file.getName());
               // System.out.println("path=" + file.getPath());
               // System.out.println("absolutepath=" + file.getAbsolutePath());
               // System.out.println("name=" + file.getName());

     /*           Picture picture = new Picture();
                picture.setName(file.getName());
                picture.setPath(file.getPath());
                pictureList.add(picture);*/

            } else if (file.isDirectory()) {
                System.out.println(file.getName());
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File readfile = new File(filepath + "\\" + filelist[i]);
                    if (!readfile.isDirectory()) {
                        //System.out.println("path=" + readfile.getPath());
                        //System.out.println("absolutepath=" + readfile.getAbsolutePath());
                        //System.out.println("name=" + readfile.getName());
                            Picture picture = new Picture();
                            picture.setName(readfile.getName());
                            picture.setPath(readfile.getPath());
                            pictureList.add(picture);

                        if (pictureList.size()>2){
                            for (int x = 0; x < pictureList.size() ; x++) {
                                System.out.println(pictureList.get(x).getName());

                            }
                            System.out.println("xxxxxxx");
                            pictureList = new ArrayList<>();
                        }


                    } else if (readfile.isDirectory()) {
                        readfile(filepath + "\\" + filelist[i]);
                    }
                }


            }



        } catch (FileNotFoundException e) {
            System.out.println("readfile()   Exception:" + e.getMessage());
        }
        return true;
    }
}
