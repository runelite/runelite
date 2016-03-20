import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fb")
public class class163 {
   @ObfuscatedName("s")
   static final char[] field2641 = new char[]{'[', ']', '#'};
   @ObfuscatedName("f")
   static final char[] field2642 = new char[]{' ', ' ', '_', '-', 'à', 'á', 'â', 'ä', 'ã', 'À', 'Á', 'Â', 'Ä', 'Ã', 'è', 'é', 'ê', 'ë', 'È', 'É', 'Ê', 'Ë', 'í', 'î', 'ï', 'Í', 'Î', 'Ï', 'ò', 'ó', 'ô', 'ö', 'õ', 'Ò', 'Ó', 'Ô', 'Ö', 'Õ', 'ù', 'ú', 'û', 'ü', 'Ù', 'Ú', 'Û', 'Ü', 'ç', 'Ç', 'ÿ', 'Ÿ', 'ñ', 'Ñ', 'ß'};

   @ObfuscatedName("n")
   public static final class78 method3234(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(2 == var4 && 1 != var1) {
         var4 = 1;
      }

      long var6 = ((long)var4 << 40) + (long)var0 + ((long)var1 << 16) + ((long)var2 << 38) + ((long)var3 << 42);
      class78 var8;
      if(!var5) {
         var8 = (class78)class51.field1155.method3792(var6);
         if(null != var8) {
            return var8;
         }
      }

      class51 var9 = class75.method1648(var0);
      if(var1 > 1 && var9.field1144 != null) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.field1153[var11] && 0 != var9.field1153[var11]) {
               var10 = var9.field1144[var11];
            }
         }

         if(var10 != -1) {
            var9 = class75.method1648(var10);
         }
      }

      class104 var19 = var9.method1048(1);
      if(var19 == null) {
         return null;
      } else {
         class78 var20 = null;
         if(var9.field1120 != -1) {
            var20 = method3234(var9.field1145, 10, 1, 0, 0, true);
            if(null == var20) {
               return null;
            }
         } else if(-1 != var9.field1131) {
            var20 = method3234(var9.field1154, var1, var2, var3, 0, false);
            if(var20 == null) {
               return null;
            }
         }

         int[] var12 = class79.field1410;
         int var13 = class79.field1412;
         int var14 = class79.field1411;
         int[] var15 = new int[4];
         class79.method1826(var15);
         var8 = new class78(36, 32);
         class79.method1822(var8.field1397, 36, 32);
         class79.method1870();
         class90.method2153();
         class90.method2106(16, 16);
         class90.field1557 = false;
         int var16 = var9.field1127;
         if(var5) {
            var16 = (int)((double)var16 * 1.5D);
         } else if(2 == var2) {
            var16 = (int)(1.04D * (double)var16);
         }

         int var17 = var16 * class90.field1572[var9.field1141] >> 16;
         int var18 = class90.field1578[var9.field1141] * var16 >> 16;
         var19.method2305();
         var19.method2322(0, var9.field1122, var9.field1149, var9.field1141, var9.field1124, var17 + var19.field1448 / 2 + var9.field1125, var9.field1125 + var18);
         if(var9.field1131 != -1) {
            var20.method1805(0, 0);
         }

         if(var2 >= 1) {
            var8.method1736(1);
         }

         if(var2 >= 2) {
            var8.method1736(16777215);
         }

         if(var3 != 0) {
            var8.method1737(var3);
         }

         class79.method1822(var8.field1397, 36, 32);
         if(-1 != var9.field1120) {
            var20.method1805(0, 0);
         }

         if(var4 == 1 || 2 == var4 && 1 == var9.field1126) {
            class75.field1374.method4057(class37.method763(var1), 0, 9, 16776960, 1);
         }

         if(!var5) {
            class51.field1155.method3794(var8, var6);
         }

         class79.method1822(var12, var13, var14);
         class79.method1877(var15);
         class90.method2153();
         class90.field1557 = true;
         return var8;
      }
   }
}
