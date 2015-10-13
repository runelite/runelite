package net.runelite.cache.fs.io;

public abstract class Stream {
   protected int offset;
   protected int length;
   protected byte[] buffer;
   protected int bitPosition;

   public int getLength() {
      return this.length;
   }

   public byte[] getBuffer() {
      return this.buffer;
   }

   public int getOffset() {
      return this.offset;
   }

   public void decodeXTEA(int[] keys) {
      this.decodeXTEA(keys, 5, this.length);
   }

   public void decodeXTEA(int[] keys, int start, int end) {
      int l = this.offset;
      this.offset = start;
      int i1 = (end - start) / 8;

      for(int j1 = 0; j1 < i1; ++j1) {
         int k1 = this.readInt();
         int l1 = this.readInt();
         int sum = -957401312;
         int delta = -1640531527;

         for(int k2 = 32; k2-- > 0; k1 -= (l1 >>> 5 ^ l1 << 4) + l1 ^ keys[sum & 3] + sum) {
            l1 -= keys[(sum & 7300) >>> 11] + sum ^ (k1 >>> 5 ^ k1 << 4) + k1;
            sum -= delta;
         }

         this.offset -= 8;
         this.writeInt(k1);
         this.writeInt(l1);
      }

      this.offset = l;
   }

   private final int readInt() {
      this.offset += 4;
      return ((255 & this.buffer[-3 + this.offset]) << 16) + ((255 & this.buffer[-4 + this.offset]) << 24) + ((this.buffer[-2 + this.offset] & 255) << 8) + (this.buffer[-1 + this.offset] & 255);
   }

   public void writeInt(int value) {
      this.buffer[this.offset++] = (byte)(value >> 24);
      this.buffer[this.offset++] = (byte)(value >> 16);
      this.buffer[this.offset++] = (byte)(value >> 8);
      this.buffer[this.offset++] = (byte)value;
   }

   public final void getBytes(byte[] data, int off, int len) {
      for(int k = off; k < len + off; ++k) {
         data[k] = this.buffer[this.offset++];
      }

   }
}
