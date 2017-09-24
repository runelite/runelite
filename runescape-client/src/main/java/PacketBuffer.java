import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
@Implements("PacketBuffer")
public final class PacketBuffer extends Buffer {
   @ObfuscatedName("s")
   static final int[] field2426;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -91482705
   )
   @Export("bitPosition")
   int bitPosition;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lfj;"
   )
   @Export("cipher")
   ISAACCipher cipher;

   static {
      field2426 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   }

   public PacketBuffer(int var1) {
      super(var1);
   }

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1858347838"
   )
   @Export("readOpcode")
   public int readOpcode() {
      return super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
   }

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2137932094"
   )
   @Export("putOpcode")
   public void putOpcode(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.cipher.nextInt());
   }

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "564355527"
   )
   @Export("bitAccess")
   public void bitAccess() {
      this.bitPosition = super.offset * 8;
   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "110451787"
   )
   @Export("byteAccess")
   public void byteAccess() {
      super.offset = (this.bitPosition + 7) / 8;
   }

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "389781157"
   )
   @Export("getBits")
   public int getBits(int var1) {
      int var2 = this.bitPosition >> 3;
      int var3 = 8 - (this.bitPosition & 7);
      int var4 = 0;

      for(this.bitPosition += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2426[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2426[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2426[var1];
      }

      return var4;
   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-35"
   )
   @Export("bitsAvail")
   public int bitsAvail(int var1) {
      return var1 * 8 - this.bitPosition;
   }

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "1273227493"
   )
   @Export("seed")
   public void seed(int[] var1) {
      this.cipher = new ISAACCipher(var1);
   }
}
