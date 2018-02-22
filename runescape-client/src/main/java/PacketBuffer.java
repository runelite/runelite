import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
@Implements("PacketBuffer")
public final class PacketBuffer extends Buffer {
   @ObfuscatedName("c")
   static final int[] field2570;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   @Export("cipher")
   ISAACCipher cipher;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1449444059
   )
   @Export("bitPosition")
   int bitPosition;

   static {
      field2570 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   }

   public PacketBuffer(int var1) {
      super(var1);
   }

   @ObfuscatedName("ji")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "1032937835"
   )
   @Export("seed")
   public void seed(int[] var1) {
      this.cipher = new ISAACCipher(var1);
   }

   @ObfuscatedName("jl")
   @ObfuscatedSignature(
      signature = "(Lgo;B)V",
      garbageValue = "29"
   )
   @Export("setIsaacCipher")
   public void setIsaacCipher(ISAACCipher var1) {
      this.cipher = var1;
   }

   @ObfuscatedName("jk")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "124026298"
   )
   @Export("putOpcode")
   public void putOpcode(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.cipher.nextInt());
   }

   @ObfuscatedName("jp")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1599988992"
   )
   @Export("readOpcode")
   public int readOpcode() {
      return super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
   }

   @ObfuscatedName("je")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1738770867"
   )
   public boolean method3863() {
      int var1 = super.payload[super.offset] - this.cipher.method3871() & 255;
      return var1 >= 128;
   }

   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-598996000"
   )
   public int method3836() {
      int var1 = super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
      return var1 < 128?var1:(var1 - 128 << 8) + (super.payload[++super.offset - 1] - this.cipher.nextInt() & 255);
   }

   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   @Export("bitAccess")
   public void bitAccess() {
      this.bitPosition = super.offset * 8;
   }

   @ObfuscatedName("jm")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "2060042366"
   )
   @Export("getBits")
   public int getBits(int var1) {
      int var2 = this.bitPosition >> 3;
      int var3 = 8 - (this.bitPosition & 7);
      int var4 = 0;

      for(this.bitPosition += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2570[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2570[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2570[var1];
      }

      return var4;
   }

   @ObfuscatedName("jr")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "151212777"
   )
   @Export("byteAccess")
   public void byteAccess() {
      super.offset = (this.bitPosition + 7) / 8;
   }

   @ObfuscatedName("jy")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2079033798"
   )
   @Export("bitsAvail")
   public int bitsAvail(int var1) {
      return var1 * 8 - this.bitPosition;
   }
}
