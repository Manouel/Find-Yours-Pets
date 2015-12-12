package company.pepisha.find_yours_pets.tools;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;

public class FileTools {

    public static Bitmap fileToBitmap(File file) {
        return BitmapFactory.decodeFile(file.getAbsolutePath());
    }

    public static Bitmap fileToScaledBitmap(File file, int width, int height) {
        Bitmap img = FileTools.fileToBitmap(file);
        if (img != null) {
            return Bitmap.createScaledBitmap(img, width, height, false);
        }

        return img;
    }

    public static String getFileExtension(File file) {
        String filename = file.getName();
        int dot = filename.lastIndexOf('.');
        return filename.substring(dot + 1);
    }
}