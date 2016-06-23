import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
@Implements("Ignore")
public class class7 {
   @ObfuscatedName("o")
   public static class59 field133;
   @ObfuscatedName("f")
   @Export("name")
   String field134;
   @ObfuscatedName("m")
   public static int[] field135;
   @ObfuscatedName("po")
   public static class136 field136;
   @ObfuscatedName("u")
   @Export("previousName")
   String field137;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2071483783"
   )
   static final int method109(int var0, int var1) {
      int var2 = class94.method2228(var0 - 1, var1 - 1) + class94.method2228(1 + var0, var1 - 1) + class94.method2228(var0 - 1, 1 + var1) + class94.method2228(1 + var0, var1 + 1);
      int var3 = class94.method2228(var0 - 1, var1) + class94.method2228(var0 + 1, var1) + class94.method2228(var0, var1 - 1) + class94.method2228(var0, var1 + 1);
      int var4 = class94.method2228(var0, var1);
      return var2 / 16 + var3 / 8 + var4 / 4;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Lclass2;III)V",
      garbageValue = "-111442308"
   )
   static void method110(class2 var0, int var1, int var2) {
      if(var1 == var0.field822 && var1 != -1) {
         int var3 = class34.method768(var1).field1015;
         if(var3 == 1) {
            var0.field853 = 0;
            var0.field854 = 0;
            var0.field855 = var2;
            var0.field856 = 0;
         }

         if(var3 == 2) {
            var0.field856 = 0;
         }
      } else if(var1 == -1 || var0.field822 == -1 || class34.method768(var1).field1009 >= class34.method768(var0.field822).field1009) {
         var0.field822 = var1;
         var0.field853 = 0;
         var0.field854 = 0;
         var0.field855 = var2;
         var0.field856 = 0;
         var0.field879 = var0.field874;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass167;I)V",
      garbageValue = "-762192595"
   )
   public static void method111(class167 var0) {
      class49.field1106 = var0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass122;S)V",
      garbageValue = "-62"
   )
   static final void method112(class122 var0) {
      var0.method2775();
      int var1 = client.field411;
      class2 var2 = class15.field225 = client.field302[var1] = new class2();
      var2.field37 = var1;
      int var3 = var0.method2776(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.field875[0] = var5 - class172.field2734;
      var2.field837 = (var2.field875[0] << 7) + (var2.method16() << 6);
      var2.field876[0] = var6 - class20.field576;
      var2.field880 = (var2.field876[0] << 7) + (var2.method16() << 6);
      var2.field35 = var4 * 1840261741;
      class14.field212 = var4;
      if(class32.field756[var1] != null) {
         var2.method15(class32.field756[var1]);
      }

      class32.field753 = 0;
      class32.field761[++class32.field753 - 1] = var1;
      class32.field755[var1] = 0;
      class32.field760 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var1 != var7) {
            int var8 = var0.method2776(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 255;
            int var11 = var8 & 255;
            class32.field762[var7] = var11 + (var10 << 14) + (var9 << 28);
            class32.field763[var7] = 0;
            class32.field764[var7] = -1;
            class32.field769[++class32.field760 - 1] = var7;
            class32.field755[var7] = 0;
         }
      }

      var0.method2791();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "242788676"
   )
   public static void method113() {
      class211.field3128 = new class202();
   }
}
