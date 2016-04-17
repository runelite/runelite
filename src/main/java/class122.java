import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
public final class class122 extends class119 {
   @ObfuscatedName("ex")
   static class78[] field2014;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -171667053
   )
   int field2015;
   @ObfuscatedName("m")
   static final int[] field2016 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   @ObfuscatedName("q")
   class123 field2017;

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "13"
   )
   public int method2863(int var1) {
      int var2 = this.field2015 >> 3;
      int var3 = 8 - (this.field2015 & 7);
      int var4 = 0;

      for(this.field2015 += var1; var1 > var3; var3 = 8) {
         var4 += (super.field1993[var2++] & field2016[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.field1993[var2] & field2016[var3];
      } else {
         var4 += super.field1993[var2] >> var3 - var1 & field2016[var1];
      }

      return var4;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public class122(int var1) {
      super(var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "68"
   )
   public static boolean method2864(char var0) {
      return var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "567557558"
   )
   public int method2865() {
      return super.field1993[++super.field1992 - 1] - this.field2017.method2893() & 255;
   }

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1141555519"
   )
   public void method2866() {
      this.field2015 = super.field1992 * 8;
   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "446723743"
   )
   public void method2868() {
      super.field1992 = (7 + this.field2015) / 8;
   }

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "74"
   )
   public void method2873(int var1) {
      super.field1993[++super.field1992 - 1] = (byte)(var1 + this.field2017.method2893());
   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-1441739267"
   )
   public void method2878(int[] var1) {
      this.field2017 = new class123(var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)[Lclass78;",
      garbageValue = "-1"
   )
   static class78[] method2891() {
      class78[] var0 = new class78[class76.field1384];

      for(int var1 = 0; var1 < class76.field1384; ++var1) {
         class78 var2 = var0[var1] = new class78();
         var2.field1405 = class76.field1385;
         var2.field1407 = class103.field1773;
         var2.field1403 = class76.field1389[var1];
         var2.field1404 = class76.field1387[var1];
         var2.field1401 = class126.field2042[var1];
         var2.field1402 = class77.field1397[var1];
         int var3 = var2.field1401 * var2.field1402;
         byte[] var4 = class76.field1388[var1];
         var2.field1411 = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.field1411[var5] = class8.field153[var4[var5] & 255];
         }
      }

      class15.method203();
      return var0;
   }

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1833178300"
   )
   public int method2892(int var1) {
      return 8 * var1 - this.field2015;
   }
}
