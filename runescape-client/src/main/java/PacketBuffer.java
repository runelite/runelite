import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gv")
@Implements("PacketBuffer")
public final class PacketBuffer extends Buffer {
   @ObfuscatedName("r")
   static final int[] field2519;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   @Export("cipher")
   ISAACCipher cipher;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 193796453
   )
   @Export("bitPosition")
   int bitPosition;

   static {
      field2519 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   }

   public PacketBuffer(int var1) {
      super(var1);
   }

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "([IB)V",
      garbageValue = "32"
   )
   @Export("seed")
   public void seed(int[] var1) {
      this.cipher = new ISAACCipher(var1);
   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "(Lgh;I)V",
      garbageValue = "-1000490003"
   )
   @Export("setIsaacCipher")
   public void setIsaacCipher(ISAACCipher var1) {
      this.cipher = var1;
   }

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "102"
   )
   @Export("putOpcode")
   public void putOpcode(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.cipher.nextInt());
   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1841759300"
   )
   @Export("readOpcode")
   public int readOpcode() {
      return super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
   }

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "766734636"
   )
   public boolean method3563() {
      int var1 = super.payload[super.offset] - this.cipher.method3599() & 255;
      return var1 >= 128;
   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int method3564() {
      int var1 = super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
      return var1 < 128?var1:(var1 - 128 << 8) + (super.payload[++super.offset - 1] - this.cipher.nextInt() & 255);
   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1560070494"
   )
   @Export("bitAccess")
   public void bitAccess() {
      this.bitPosition = super.offset * 8;
   }

   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1000352492"
   )
   @Export("getBits")
   public int getBits(int var1) {
      int var2 = this.bitPosition >> 3;
      int var3 = 8 - (this.bitPosition & 7);
      int var4 = 0;

      for(this.bitPosition += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2519[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2519[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2519[var1];
      }

      return var4;
   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1147088892"
   )
   @Export("byteAccess")
   public void byteAccess() {
      super.offset = (this.bitPosition + 7) / 8;
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "0"
   )
   @Export("bitsAvail")
   public int bitsAvail(int var1) {
      return var1 * 8 - this.bitPosition;
   }
}
