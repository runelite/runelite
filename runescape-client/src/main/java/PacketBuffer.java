import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
@Implements("PacketBuffer")
public final class PacketBuffer extends Buffer {
   @ObfuscatedName("c")
   static final int[] field2435;
   @ObfuscatedName("f")
   @Export("cipher")
   ISAACCipher cipher;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -907180905
   )
   int field2437;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1518954568"
   )
   static int method3287(int var0) {
      MessageNode var1 = (MessageNode)class98.field1517.method3389((long)var0);
      return var1 == null?-1:(var1.next == class98.field1523.field2501?-1:((MessageNode)var1.next).id);
   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "1920989810"
   )
   @Export("seed")
   public void seed(int[] var1) {
      this.cipher = new ISAACCipher(var1);
   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   @Export("putOpcode")
   public void putOpcode(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.cipher.nextInt());
   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-386434289"
   )
   public int method3290(int var1) {
      int var2 = this.field2437 >> 3;
      int var3 = 8 - (this.field2437 & 7);
      int var4 = 0;

      for(this.field2437 += var1; var1 > var3; var3 = 8) {
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

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-895913502"
   )
   public void method3291() {
      this.field2437 = super.offset * 8;
   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "481163509"
   )
   public void method3292() {
      super.offset = (this.field2437 + 7) / 8;
   }

   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "7"
   )
   public int method3294(int var1) {
      return var1 * 8 - this.field2437;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public PacketBuffer(int var1) {
      super(var1);
   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   @Export("readOpcode")
   public int readOpcode() {
      return super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
   }

   static {
      field2435 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   }
}
