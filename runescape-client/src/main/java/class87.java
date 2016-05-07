import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
public final class class87 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1897064509
   )
   int field1529;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1082393053
   )
   int field1530;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 189065895
   )
   int field1532;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1804355887
   )
   int field1534 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 787026995
   )
   public int field1535 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 182973933
   )
   int field1536;
   @ObfuscatedName("c")
   static class18 field1537;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1840842935
   )
   int field1539;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1272460673
   )
   static int field1540;
   @ObfuscatedName("u")
   public class85 field1542;
   @ObfuscatedName("o")
   public class85 field1543;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1748662716"
   )
   public static void method2061() {
      try {
         class149.field2243.method4127();

         for(int var0 = 0; var0 < class47.field1071; ++var0) {
            class20.field570[var0].method4127();
         }

         class149.field2244.method4127();
         class149.field2242.method4127();
      } catch (Exception var1) {
         ;
      }

   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(Lclass173;B)V",
      garbageValue = "13"
   )
   static void method2063(class173 var0) {
      class173 var1 = var0.field2784 == -1?null:class29.method645(var0.field2784);
      int var2;
      int var3;
      if(null == var1) {
         var2 = class15.field214;
         var3 = class15.field215;
      } else {
         var2 = var1.field2886;
         var3 = var1.field2781;
      }

      class99.method2180(var0, var2, var3, false);
      class72.method1553(var0, var2, var3);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)[Lclass78;",
      garbageValue = "1910916077"
   )
   static class78[] method2064() {
      class78[] var0 = new class78[class76.field1395];

      for(int var1 = 0; var1 < class76.field1395; ++var1) {
         class78 var2 = var0[var1] = new class78();
         var2.field1416 = class226.field3214;
         var2.field1412 = class76.field1386;
         var2.field1410 = class76.field1387[var1];
         var2.field1406 = class76.field1390[var1];
         var2.field1407 = class76.field1389[var1];
         var2.field1408 = class9.field159[var1];
         int var3 = var2.field1408 * var2.field1407;
         byte[] var4 = class21.field575[var1];
         var2.field1414 = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.field1414[var5] = class76.field1396[var4[var5] & 255];
         }
      }

      class27.method633();
      return var0;
   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "375252283"
   )
   static final void method2065(int var0, int var1) {
      if(class188.method3731(var0)) {
         class5.method88(class217.field3171[var0], var1);
      }
   }
}
