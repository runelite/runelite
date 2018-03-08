import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
@Implements("PacketBuffer")
public final class PacketBuffer extends Buffer {
   @ObfuscatedName("g")
   static final int[] field2585;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   @Export("cipher")
   ISAACCipher cipher;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 645828677
   )
   @Export("bitPosition")
   int bitPosition;

   static {
      field2585 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   }

   public PacketBuffer(int var1) {
      super(var1);
   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "([IB)V",
      garbageValue = "75"
   )
   @Export("seed")
   public void seed(int[] var1) {
      this.cipher = new ISAACCipher(var1);
   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "(Lgv;I)V",
      garbageValue = "-1423266539"
   )
   @Export("setIsaacCipher")
   public void setIsaacCipher(ISAACCipher var1) {
      this.cipher = var1;
   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "65"
   )
   @Export("putOpcode")
   public void putOpcode(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.cipher.nextInt());
   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "965185411"
   )
   @Export("readOpcode")
   public int readOpcode() {
      return super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "76"
   )
   public boolean method3805() {
      int var1 = super.payload[super.offset] - this.cipher.method3842() & 255;
      return var1 >= 128;
   }

   @ObfuscatedName("jk")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-47"
   )
   public int method3826() {
      int var1 = super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
      return var1 < 128?var1:(var1 - 128 << 8) + (super.payload[++super.offset - 1] - this.cipher.nextInt() & 255);
   }

   @ObfuscatedName("jc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-688708865"
   )
   @Export("bitAccess")
   public void bitAccess() {
      this.bitPosition = super.offset * 8;
   }

   @ObfuscatedName("jt")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "16777215"
   )
   @Export("getBits")
   public int getBits(int var1) {
      int var2 = this.bitPosition >> 3;
      int var3 = 8 - (this.bitPosition & 7);
      int var4 = 0;

      for(this.bitPosition += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2585[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2585[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2585[var1];
      }

      return var4;
   }

   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1546505438"
   )
   @Export("byteAccess")
   public void byteAccess() {
      super.offset = (this.bitPosition + 7) / 8;
   }

   @ObfuscatedName("jg")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "42"
   )
   @Export("bitsAvail")
   public int bitsAvail(int var1) {
      return var1 * 8 - this.bitPosition;
   }
}
