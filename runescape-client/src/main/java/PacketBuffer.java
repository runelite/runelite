import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
@Implements("PacketBuffer")
public final class PacketBuffer extends Buffer {
   @ObfuscatedName("t")
   static final int[] field2435;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -344750035
   )
   @Export("bitPosition")
   int bitPosition;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   @Export("cipher")
   ISAACCipher cipher;

   static {
      field2435 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   }

   public PacketBuffer(int var1) {
      super(var1);
   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-270386179"
   )
   @Export("readOpcode")
   public int readOpcode() {
      return super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2037710807"
   )
   @Export("putOpcode")
   public void putOpcode(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.cipher.nextInt());
   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-527761085"
   )
   @Export("bitAccess")
   public void bitAccess() {
      this.bitPosition = super.offset * 8;
   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-41"
   )
   @Export("byteAccess")
   public void byteAccess() {
      super.offset = (this.bitPosition + 7) / 8;
   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "393245239"
   )
   @Export("getBits")
   public int getBits(int var1) {
      int var2 = this.bitPosition >> 3;
      int var3 = 8 - (this.bitPosition & 7);
      int var4 = 0;

      for(this.bitPosition += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2435[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2435[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2435[var1];
      }

      return var4;
   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1409314416"
   )
   @Export("bitsAvail")
   public int bitsAvail(int var1) {
      return var1 * 8 - this.bitPosition;
   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-710278718"
   )
   @Export("seed")
   public void seed(int[] var1) {
      this.cipher = new ISAACCipher(var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfg;J)V"
   )
   static void method3505(Buffer var0, long var1) {
      var1 /= 10L;
      if(var1 < 0L) {
         var1 = 0L;
      } else if(var1 > 65535L) {
         var1 = 65535L;
      }

      var0.putShort((int)var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Lhj;",
      garbageValue = "694871142"
   )
   public static Widget method3528(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & 65535;
      if(class177.widgets[var1] == null || class177.widgets[var1][var2] == null) {
         boolean var3 = class93.loadWidget(var1);
         if(!var3) {
            return null;
         }
      }

      return class177.widgets[var1][var2];
   }
}
