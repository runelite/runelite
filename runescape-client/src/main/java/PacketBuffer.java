import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
@Implements("PacketBuffer")
public final class PacketBuffer extends Buffer {
   @ObfuscatedName("x")
   static final int[] field2416;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "[Ldv;"
   )
   public static CacheFile[] field2417;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lft;"
   )
   @Export("cipher")
   ISAACCipher cipher;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 63638249
   )
   @Export("bitPosition")
   int bitPosition;

   static {
      field2416 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   }

   public PacketBuffer(int var1) {
      super(var1);
   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "1121402426"
   )
   @Export("seed")
   public void seed(int[] var1) {
      this.cipher = new ISAACCipher(var1);
   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1954331928"
   )
   @Export("putOpcode")
   public void putOpcode(int var1) {
      if(Client.RUNELITE_PACKET) {
         this.runeliteFinishPacket();
      }

      super.payload[++super.offset - 1] = (byte)(var1 + this.cipher.nextInt());
      if(Client.RUNELITE_PACKET) {
         this.runeliteInitPacket();
      }

   }

   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1670331873"
   )
   @Export("readOpcode")
   public int readOpcode() {
      return super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
   }

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "30"
   )
   @Export("bitAccess")
   public void bitAccess() {
      this.bitPosition = super.offset * 8;
   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-961905834"
   )
   @Export("getBits")
   public int getBits(int var1) {
      int var2 = this.bitPosition >> 3;
      int var3 = 8 - (this.bitPosition & 7);
      int var4 = 0;

      for(this.bitPosition += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2416[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2416[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2416[var1];
      }

      return var4;
   }

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "505910819"
   )
   @Export("byteAccess")
   public void byteAccess() {
      super.offset = (this.bitPosition + 7) / 8;
   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-668683206"
   )
   @Export("bitsAvail")
   public int bitsAvail(int var1) {
      return var1 * 8 - this.bitPosition;
   }
}
