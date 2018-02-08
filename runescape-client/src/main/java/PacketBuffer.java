import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gt")
@Implements("PacketBuffer")
public final class PacketBuffer extends Buffer {
   @ObfuscatedName("k")
   static final int[] field2535;
   @ObfuscatedName("ap")
   protected static GarbageCollectorMXBean field2539;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   @Export("cipher")
   ISAACCipher cipher;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -138490091
   )
   @Export("bitPosition")
   int bitPosition;

   static {
      field2535 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   }

   public PacketBuffer(int var1) {
      super(var1);
   }

   @ObfuscatedName("jo")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "1436008354"
   )
   @Export("seed")
   public void seed(int[] var1) {
      this.cipher = new ISAACCipher(var1);
   }

   @ObfuscatedName("jv")
   @ObfuscatedSignature(
      signature = "(Lgo;B)V",
      garbageValue = "-49"
   )
   @Export("setIsaacCipher")
   public void setIsaacCipher(ISAACCipher var1) {
      this.cipher = var1;
   }

   @ObfuscatedName("jm")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2129272305"
   )
   @Export("putOpcode")
   public void putOpcode(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.cipher.nextInt());
   }

   @ObfuscatedName("je")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1351690575"
   )
   @Export("readOpcode")
   public int readOpcode() {
      return super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
   }

   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-247525612"
   )
   public boolean method3813() {
      int var1 = super.payload[super.offset] - this.cipher.method3849() & 255;
      return var1 >= 128;
   }

   @ObfuscatedName("jq")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "101"
   )
   public int method3838() {
      int var1 = super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
      return var1 < 128?var1:(var1 - 128 << 8) + (super.payload[++super.offset - 1] - this.cipher.nextInt() & 255);
   }

   @ObfuscatedName("jr")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1808032446"
   )
   @Export("bitAccess")
   public void bitAccess() {
      this.bitPosition = super.offset * 8;
   }

   @ObfuscatedName("jj")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1705188430"
   )
   @Export("getBits")
   public int getBits(int var1) {
      int var2 = this.bitPosition >> 3;
      int var3 = 8 - (this.bitPosition & 7);
      int var4 = 0;

      for(this.bitPosition += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2535[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2535[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2535[var1];
      }

      return var4;
   }

   @ObfuscatedName("jb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "867757969"
   )
   @Export("byteAccess")
   public void byteAccess() {
      super.offset = (this.bitPosition + 7) / 8;
   }

   @ObfuscatedName("jz")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1419276165"
   )
   @Export("bitsAvail")
   public int bitsAvail(int var1) {
      return var1 * 8 - this.bitPosition;
   }
}
