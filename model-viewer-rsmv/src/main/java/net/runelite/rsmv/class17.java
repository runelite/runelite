package net.runelite.rsmv;


public final class class17 {
   private byte[] field87;
   public int field88;

   public class17(byte[] var1) {
      this.field87 = var1;
      this.field88 = 0;
   }

   public final int method27() {
      return this.field87[this.field88++] & 255;
   }

   public final byte method28() {
      return this.field87[this.field88++];
   }

   public final int method29() {
      this.field88 += 2;
      return ((this.field87[this.field88 - 2] & 255) << 8) + (this.field87[this.field88 - 1] & 255);
   }

   public final int method30() {
      this.field88 += 3;
      return ((this.field87[this.field88 - 3] & 255) << 16) + ((this.field87[this.field88 - 2] & 255) << 8) + (this.field87[this.field88 - 1] & 255);
   }

   public final int method31() {
      this.field88 += 2;
      return ((this.field87[this.field88 - 2] & 255) << 8) + (this.field87[this.field88 - 1] & 255);
   }

   public final int method32() {
      return (this.field87[this.field88] & 255) < 128?this.method27() - 64:this.method29() - '쀀';
   }

   static {
      int[] var10000 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   }
}
