import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
public final class class125 extends Buffer {
   @ObfuscatedName("c")
   class126 field2069;
   @ObfuscatedName("w")
   static final int[] field2070 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 612845723
   )
   int field2071;
   @ObfuscatedName("js")
   @ObfuscatedGetter(
      intValue = -1999392173
   )
   static int field2077;

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-1651508905"
   )
   public void method2767(int[] var1) {
      this.field2069 = new class126(var1);
   }

   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-660813855"
   )
   public void method2768(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.field2069.method2792());
   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "292587657"
   )
   public void method2770() {
      this.field2071 = super.offset * 8;
   }

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "50"
   )
   public int method2771(int var1) {
      int var2 = this.field2071 >> 3;
      int var3 = 8 - (this.field2071 & 7);
      int var4 = 0;

      for(this.field2071 += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2070[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2070[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2070[var1];
      }

      return var4;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public class125(int var1) {
      super(var1);
   }

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1157081137"
   )
   public void method2778() {
      super.offset = (this.field2071 + 7) / 8;
   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-68"
   )
   public int method2782() {
      return super.payload[++super.offset - 1] - this.field2069.method2792() & 255;
   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "60"
   )
   public int method2787(int var1) {
      return 8 * var1 - this.field2071;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass170;II)LModIcon;",
      garbageValue = "-887014879"
   )
   public static ModIcon method2790(class170 var0, int var1) {
      return !class13.method156(var0, var1)?null:FrameMap.method2312();
   }
}
