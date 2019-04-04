package core.vgdl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class PGM {
    public static void writeFile(String path, ByteBuffer2D buffer, int numClasses) {
        try (FileOutputStream s = new FileOutputStream(path)) {

            Charset ASCII = StandardCharsets.US_ASCII;

            s.write("P5\n".getBytes(ASCII));
            s.write(String.format(Locale.ROOT, "# Classes %d\n", numClasses).getBytes(ASCII));
            s.write(String.format(Locale.ROOT, "%d %d\n", buffer.getWidth(), buffer.getHeight()).getBytes(ASCII));
            s.write(buffer.getBytes());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
