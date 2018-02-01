import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
@Implements("PacketBuffer")
public final class PacketBuffer extends Buffer {
   @ObfuscatedName("h")
   static final int[] field2510;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   @Export("cipher")
   ISAACCipher cipher;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1300910385
   )
   @Export("bitPosition")
   int bitPosition;

   static {
      field2510 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   }

   public PacketBuffer(int var1) {
      super(var1);
   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "([IB)V",
      garbageValue = "120"
   )
   @Export("seed")
   public void seed(int[] var1) {
      this.cipher = new ISAACCipher(var1);
   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(Lgo;I)V",
      garbageValue = "-874762839"
   )
   @Export("setIsaacCipher")
   public void setIsaacCipher(ISAACCipher var1) {
      this.cipher = var1;
   }

   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2103455556"
   )
   @Export("putOpcode")
   public void putOpcode(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.cipher.nextInt());
   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "103"
   )
   @Export("readOpcode")
   public int readOpcode() {
      return super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
   }

   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-836668354"
   )
   public boolean method3657() {
      int var1 = super.payload[super.offset] - this.cipher.method3684() & 255;
      return var1 >= 128;
   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "8"
   )
   public int method3672() {
      int var1 = super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
      return var1 < 128?var1:(var1 - 128 << 8) + (super.payload[++super.offset - 1] - this.cipher.nextInt() & 255);
   }

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-43"
   )
   @Export("bitAccess")
   public void bitAccess() {
      this.bitPosition = super.offset * 8;
   }

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-102"
   )
   @Export("getBits")
   public int getBits(int var1) {
      int var2 = this.bitPosition >> 3;
      int var3 = 8 - (this.bitPosition & 7);
      int var4 = 0;

      for(this.bitPosition += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2510[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2510[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2510[var1];
      }

      return var4;
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "535736991"
   )
   @Export("byteAccess")
   public void byteAccess() {
      super.offset = (this.bitPosition + 7) / 8;
   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-655868701"
   )
   @Export("bitsAvail")
   public int bitsAvail(int var1) {
      return var1 * 8 - this.bitPosition;
   }
}
