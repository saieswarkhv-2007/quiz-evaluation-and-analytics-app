import java.io.File;


public class InputFile {

    private File file;

    public InputFile(String fileName) {
        file = new File(fileName);
    }

    public boolean exists() {
        return file.exists();
    }
}