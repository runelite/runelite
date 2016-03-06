import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cj")
public final class class93 {
   @ObfuscatedName("h")
   public class84 field1604;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -954826965
   )
   int field1605;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -729243043
   )
   int field1606;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1086133027
   )
   int field1607;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1076148873
   )
   int field1608;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1253091099
   )
   int field1609;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1366947501
   )
   int field1610;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 389092317
   )
   int field1611 = 0;
   @ObfuscatedName("n")
   public class84 field1612;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -329058449
   )
   public int field1613 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 416393405
   )
   int field1615;

   @ObfuscatedName("f")
   public static void method2137() {
      class43.field1008.method3720();
      class43.field1006.method3720();
   }

   @ObfuscatedName("j")
   static class80[] method2138(class166 var0, int var1, int var2) {
      if(!class11.method148(var0, var1, var2)) {
         return null;
      } else {
         class80[] var4 = new class80[class76.field1395];

         for(int var5 = 0; var5 < class76.field1395; ++var5) {
            class80 var6 = var4[var5] = new class80();
            var6.field1435 = class76.field1390;
            var6.field1436 = class76.field1391;
            var6.field1433 = class76.field1392[var5];
            var6.field1430 = class106.field1884[var5];
            var6.field1431 = class215.field3153[var5];
            var6.field1434 = class147.field2230[var5];
            var6.field1432 = class126.field2048;
            var6.field1429 = class41.field977[var5];
         }

         class76.field1392 = null;
         class106.field1884 = null;
         class215.field3153 = null;
         class147.field2230 = null;
         class126.field2048 = null;
         class41.field977 = (byte[][])null;
         return var4;
      }
   }

   @ObfuscatedName("j")
   public static int method2139(int var0, int var1, int var2) {
      var2 &= 3;
      return 0 == var2?var1:(var2 == 1?7 - var0:(var2 == 2?7 - var1:var0));
   }
}
