import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
public final class class122 extends class119 {
   @ObfuscatedName("qv")
   @ObfuscatedGetter(
      intValue = 1030096795
   )
   static int field1989;
   @ObfuscatedName("l")
   static final int[] field1990 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   @ObfuscatedName("fz")
   @ObfuscatedGetter(
      intValue = -1208822403
   )
   @Export("cameraX")
   static int field1991;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -947760493
   )
   int field1995;
   @ObfuscatedName("n")
   class123 field1996;

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-79"
   )
   public void method2733() {
      super.field1971 = (this.field1995 + 7) / 8;
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "1442266671"
   )
   public void method2734(int[] var1) {
      this.field1996 = new class123(var1);
   }

   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "98"
   )
   public void method2735(int var1) {
      super.field1973[++super.field1971 - 1] = (byte)(var1 + this.field1996.method2755());
   }

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-500430819"
   )
   public void method2736() {
      this.field1995 = super.field1971 * 8;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public class122(int var1) {
      super(var1);
   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "3"
   )
   public int method2737(int var1) {
      int var2 = this.field1995 >> 3;
      int var3 = 8 - (this.field1995 & 7);
      int var4 = 0;

      for(this.field1995 += var1; var1 > var3; var3 = 8) {
         var4 += (super.field1973[var2++] & field1990[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.field1973[var2] & field1990[var3];
      } else {
         var4 += super.field1973[var2] >> var3 - var1 & field1990[var1];
      }

      return var4;
   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1487476723"
   )
   public int method2739(int var1) {
      return 8 * var1 - this.field1995;
   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-440447579"
   )
   public int method2741() {
      return super.field1973[++super.field1971 - 1] - this.field1996.method2755() & 255;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "1741915561"
   )
   static final void method2750(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 2048 - var3 & 2047;
      int var7 = 2048 - var4 & 2047;
      int var8 = 0;
      int var9 = 0;
      int var10 = var5;
      int var11;
      int var12;
      int var13;
      if(0 != var6) {
         var11 = class91.field1571[var6];
         var12 = class91.field1572[var6];
         var13 = var12 * var9 - var11 * var5 >> 16;
         var10 = var9 * var11 + var5 * var12 >> 16;
         var9 = var13;
      }

      if(0 != var7) {
         var11 = class91.field1571[var7];
         var12 = class91.field1572[var7];
         var13 = var8 * var12 + var10 * var11 >> 16;
         var10 = var12 * var10 - var8 * var11 >> 16;
         var8 = var13;
      }

      field1991 = var0 - var8;
      class115.field1952 = var1 - var9;
      class24.field603 = var2 - var10;
      class154.field2276 = var3;
      class17.field243 = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "151437761"
   )
   static final int method2751(int var0, int var1) {
      int var2 = var1 * 57 + var0;
      var2 ^= var2 << 13;
      int var3 = 1376312589 + (789221 + var2 * var2 * 15731) * var2 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }
}
