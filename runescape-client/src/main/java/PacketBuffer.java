import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
@Implements("PacketBuffer")
public final class PacketBuffer extends Buffer {
   @ObfuscatedName("n")
   static final int[] field2515;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   @Export("cipher")
   ISAACCipher cipher;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -919263569
   )
   @Export("bitPosition")
   int bitPosition;

   static {
      field2515 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   }

   public PacketBuffer(int var1) {
      super(var1);
   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-2041928383"
   )
   @Export("seed")
   public void seed(int[] var1) {
      this.cipher = new ISAACCipher(var1);
   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "(Lgi;I)V",
      garbageValue = "-2088542282"
   )
   public void method3451(ISAACCipher var1) {
      this.cipher = var1;
   }

   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "768332919"
   )
   @Export("putOpcode")
   public void putOpcode(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.cipher.nextInt());
   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1313147344"
   )
   @Export("readOpcode")
   public int readOpcode() {
      return super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-67"
   )
   public boolean method3479() {
      int var1 = super.payload[super.offset] - this.cipher.method3496() & 255;
      return var1 >= 128;
   }

   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1179576533"
   )
   public int method3455() {
      int var1 = super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
      return var1 < 128?var1:(var1 - 128 << 8) + (super.payload[++super.offset - 1] - this.cipher.nextInt() & 255);
   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1820683272"
   )
   @Export("bitAccess")
   public void bitAccess() {
      this.bitPosition = super.offset * 8;
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1678771030"
   )
   @Export("getBits")
   public int getBits(int var1) {
      int var2 = this.bitPosition >> 3;
      int var3 = 8 - (this.bitPosition & 7);
      int var4 = 0;

      for(this.bitPosition += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2515[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2515[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2515[var1];
      }

      return var4;
   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2009519596"
   )
   @Export("byteAccess")
   public void byteAccess() {
      super.offset = (this.bitPosition + 7) / 8;
   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-63"
   )
   @Export("bitsAvail")
   public int bitsAvail(int var1) {
      return var1 * 8 - this.bitPosition;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "605785756"
   )
   public static void method3484() {
      Area.areaSpriteCache.reset();
   }
}
