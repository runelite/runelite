import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
@Implements("PacketBuffer")
public final class PacketBuffer extends Buffer {
   @ObfuscatedName("g")
   static final int[] field2428;
   @ObfuscatedName("pu")
   @ObfuscatedGetter(
      intValue = -242255437
   )
   static int field2429;
   @ObfuscatedName("h")
   @Export("cipher")
   ISAACCipher cipher;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1779032597
   )
   int field2431;

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1412841167"
   )
   public int method3395(int var1) {
      return var1 * 8 - this.field2431;
   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "841387118"
   )
   @Export("seed")
   public void seed(int[] var1) {
      this.cipher = new ISAACCipher(var1);
   }

   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1473864713"
   )
   @Export("readOpcode")
   public int readOpcode() {
      return super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-876025525"
   )
   public void method3399() {
      this.field2431 = super.offset * 8;
   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "-4277"
   )
   public int method3400(int var1) {
      int var2 = this.field2431 >> 3;
      int var3 = 8 - (this.field2431 & 7);
      int var4 = 0;

      for(this.field2431 += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2428[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2428[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2428[var1];
      }

      return var4;
   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "55"
   )
   public void method3401() {
      super.offset = (this.field2431 + 7) / 8;
   }

   static {
      field2428 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public PacketBuffer(int var1) {
      super(var1);
   }

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "21"
   )
   @Export("putOpcode")
   public void putOpcode(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.cipher.nextInt());
   }
}
