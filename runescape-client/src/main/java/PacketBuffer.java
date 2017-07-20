import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
@Implements("PacketBuffer")
public final class PacketBuffer extends Buffer {
   @ObfuscatedName("k")
   static final int[] field2386;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 934684471
   )
   @Export("bitPosition")
   int bitPosition;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lft;"
   )
   @Export("cipher")
   ISAACCipher cipher;

   static {
      field2386 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   }

   public PacketBuffer(int var1) {
      super(var1);
   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1972386731"
   )
   @Export("readOpcode")
   public int readOpcode() {
      return super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-2"
   )
   @Export("putOpcode")
   public void putOpcode(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.cipher.nextInt());
   }

   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1555597925"
   )
   @Export("bitAccess")
   public void bitAccess() {
      this.bitPosition = super.offset * 8;
   }

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "898218901"
   )
   @Export("getBits")
   public int getBits(int var1) {
      int var2 = this.bitPosition >> 3;
      int var3 = 8 - (this.bitPosition & 7);
      int var4 = 0;

      for(this.bitPosition += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2386[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2386[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2386[var1];
      }

      return var4;
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1572582148"
   )
   @Export("bitsAvail")
   public int bitsAvail(int var1) {
      return var1 * 8 - this.bitPosition;
   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1841450942"
   )
   @Export("byteAccess")
   public void byteAccess() {
      super.offset = (this.bitPosition + 7) / 8;
   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "([IB)V",
      garbageValue = "-92"
   )
   @Export("seed")
   public void seed(int[] var1) {
      this.cipher = new ISAACCipher(var1);
   }
}
