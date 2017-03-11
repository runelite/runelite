package net.runelite.rsmv;


public final class Buffer {
   private byte[] field87;
   public int offset;

   public Buffer(byte[] var1) {
      this.field87 = var1;
      this.offset = 0;
   }

   public final int readUnsignedByte() {
      return this.field87[this.offset++] & 255;
   }

   public final byte readByte() {
      return this.field87[this.offset++];
   }

   public final int readUnsignedShort() {
      this.offset += 2;
      return ((this.field87[this.offset - 2] & 255) << 8) + (this.field87[this.offset - 1] & 255);
   }

   public final int readMid() {
      this.offset += 3;
      return ((this.field87[this.offset - 3] & 255) << 16) + ((this.field87[this.offset - 2] & 255) << 8) + (this.field87[this.offset - 1] & 255);
   }

   public final int readShortv2() {
      this.offset += 2;
      return ((this.field87[this.offset - 2] & 255) << 8) + (this.field87[this.offset - 1] & 255);
   }

   public final int readShortSmart() {
      return (this.field87[this.offset] & 255) < 128?this.readUnsignedByte() - 64:this.readUnsignedShort() - '쀀';
   }

   static {
      int[] var10000 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   }
}
