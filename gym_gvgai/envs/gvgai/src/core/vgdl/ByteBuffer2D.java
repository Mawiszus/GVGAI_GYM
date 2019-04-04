package core.vgdl;

public class ByteBuffer2D {
    private byte[] bytes;
    private int width;
    private int height;

    public ByteBuffer2D(int width, int height) {
        this.width = width;
        this.height = height;
        this.bytes = new byte[width * height];
    }

    public void fill(int x, int y, int width, int height, byte val) {
        int left = Math.max(x, 0);
        int top = Math.max(y, 0);
        int right = Math.min(x + width, this.width);
        int bottom = Math.min(y + height, this.height);

        for (int i = top; i < bottom; ++i) {
            int rowIndex = i * this.width;
            for (int j = left; j < right; ++j) {
                bytes[rowIndex + j] = val;
            }
        }
    }

    public byte[] getBytes() {
        return bytes;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
