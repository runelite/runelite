import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
@Implements("PacketBuffer")
public final class PacketBuffer extends Buffer {
   @ObfuscatedName("v")
   static final int[] field1986 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   @ObfuscatedName("l")
   @Export("cipher")
   ISAACCipher cipher;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2013996081
   )
   @Export("bitOffset")
   int bitOffset;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1831704343
   )
   public static int field1989;

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "1067751026"
   )
   @Export("seed")
   public void seed(int[] var1) {
      this.cipher = new ISAACCipher(var1);
   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-35"
   )
   @Export("putOpcode")
   public void putOpcode(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.cipher.nextInt());
   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-13"
   )
   public void method2644() {
      this.bitOffset = super.offset * 8;
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1624787528"
   )
   @Export("readBits")
   public int readBits(int var1) {
      int var2 = this.bitOffset >> 3;
      int var3 = 8 - (this.bitOffset & 7);
      int var4 = 0;

      for(this.bitOffset += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field1986[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var1 == var3) {
         var4 += super.payload[var2] & field1986[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field1986[var1];
      }

      return var4;
   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1034283079"
   )
   @Export("readOpcode")
   public int readOpcode() {
      return super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "85"
   )
   public void method2647() {
      super.offset = (this.bitOffset + 7) / 8;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public PacketBuffer(int var1) {
      super(var1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)LWorld;",
      garbageValue = "-23"
   )
   static World method2649() {
      return World.field674 < World.field669?World.worldList[++World.field674 - 1]:null;
   }

   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1590490380"
   )
   public int method2657(int var1) {
      return var1 * 8 - this.bitOffset;
   }
}
