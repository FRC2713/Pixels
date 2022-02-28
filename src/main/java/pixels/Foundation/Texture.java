package pixels.Foundation;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class Texture {
    public static IntBuffer rawdata = IntBuffer.allocate(Texture.x * Texture.y);
    public static final int x = 1366;
    public static final int y = 768;

    public static void reset() {
       rawdata = IntBuffer.allocate(Texture.x * Texture.y);
    }

   public static void set_pixel(int index, int red, int green, int blue) {
       ByteBuffer buffer = ByteBuffer.allocate(4);
       buffer.put(3,(byte)red);
       buffer.put(2,(byte)green);
       buffer.put(1,(byte)blue);
       buffer.put(0,(byte)255);
       rawdata.put(index,buffer.getInt());
    }

    public static void set_pixel(int x, int y, int red, int green, int blue) {
      int index =  x + ( y * Texture.x );
      set_pixel(index,red,green,blue);
    }

    public static void get_pixel(int index, int[] red, int[] green, int[] blue) {
       ByteBuffer buffer = ByteBuffer.allocate(4);
       buffer.putInt(rawdata.get(index));
       red[0] = buffer.get(0);
       blue[0] = buffer.get(1);
       green[0] = buffer.get(2);
    }

    public static void get_pixel(int x, int y, int[] red, int[] green, int[] blue) {
        int index =  x + ( y * Texture.x );
        get_pixel(index,red,green,blue);
    }
}
