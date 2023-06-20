package CompAndDecomp;

import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.GZIPInputStream;
public class decompressor {
    public static void method(File file)throws IOException{
        String directory = file.getParent();
        FileInputStream fis = new FileInputStream(file);
        GZIPInputStream gzip = new GZIPInputStream(fis);
        FileOutputStream fos = new FileOutputStream(directory+"/DecompressedFile");

        byte[] buffer = new byte[1024];
        int len;
        while((len =fis.read(buffer))!=-1){
            fos.write(buffer, 0, len);
        }
        gzip.close();
        fos.close();
        fis.close();
    }
    public static void main(String[] args)throws IOException{
        File path = new File("D:\\AllTheProjects\\DecompressedOrOriginalFile");
        method(path);
    }
}
