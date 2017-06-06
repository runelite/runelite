import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
@Implements("PacketBuffer")
public final class PacketBuffer extends Buffer {
   @ObfuscatedName("f")
   @Export("cipher")
   ISAACCipher cipher;
   @ObfuscatedName("n")
   static final int[] field2434;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -711224203
   )
   int field2435;

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "([IB)V",
      garbageValue = "84"
   )
   @Export("seed")
   public void seed(int[] var1) {
      this.cipher = new ISAACCipher(var1);
   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1898816692"
   )
   @Export("putOpcode")
   public void putOpcode(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.cipher.nextInt());
   }

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-504435578"
   )
   @Export("readOpcode")
   public int readOpcode() {
      return super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1300835781"
   )
   public void method3389() {
      this.field2435 = super.offset * 8;
   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-88"
   )
   public void method3391() {
      super.offset = (this.field2435 + 7) / 8;
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "431725434"
   )
   public int method3392(int var1) {
      return var1 * 8 - this.field2435;
   }

   static {
      field2434 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public PacketBuffer(int var1) {
      super(var1);
   }

   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "914161824"
   )
   public int method3397(int var1) {
      int var2 = this.field2435 >> 3;
      int var3 = 8 - (this.field2435 & 7);
      int var4 = 0;

      for(this.field2435 += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2434[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2434[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2434[var1];
      }

      return var4;
   }
}
