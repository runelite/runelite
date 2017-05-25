import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
@Implements("PacketBuffer")
public final class PacketBuffer extends Buffer {
   @ObfuscatedName("l")
   @Export("cipher")
   ISAACCipher cipher;
   @ObfuscatedName("a")
   static final int[] field2412;
   @ObfuscatedName("bm")
   static class71 field2414;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 423565655
   )
   int field2415;

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "897343454"
   )
   @Export("putOpcode")
   public void putOpcode(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.cipher.nextInt());
   }

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-83"
   )
   @Export("readOpcode")
   public int readOpcode() {
      return super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1150326007"
   )
   public void method3466() {
      super.offset = (this.field2415 + 7) / 8;
   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "-19128"
   )
   public int method3468(int var1) {
      return var1 * 8 - this.field2415;
   }

   static {
      field2412 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "559425695"
   )
   public void method3469() {
      this.field2415 = super.offset * 8;
   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-35174162"
   )
   public int method3470(int var1) {
      int var2 = this.field2415 >> 3;
      int var3 = 8 - (this.field2415 & 7);
      int var4 = 0;

      for(this.field2415 += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2412[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2412[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2412[var1];
      }

      return var4;
   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-755406857"
   )
   @Export("seed")
   public void seed(int[] var1) {
      this.cipher = new ISAACCipher(var1);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public PacketBuffer(int var1) {
      super(var1);
   }
}
