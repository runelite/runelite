import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public class class26 {
   @ObfuscatedName("be")
   static class168 field628;
   @ObfuscatedName("ft")
   @ObfuscatedGetter(
      intValue = 26691675
   )
   static int field634;
   @ObfuscatedName("bt")
   static class80[] field642;
   @ObfuscatedName("ad")
   static class168 field646;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BS)Lclass224;",
      garbageValue = "21631"
   )
   static class224 method627(byte[] var0) {
      if(null == var0) {
         return null;
      } else {
         class224 var1 = new class224(var0, class76.field1366, class76.field1367, class52.field1145, class76.field1371, class227.field3220, client.field557);
         class157.method3133();
         return var1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIIIZB)Lclass78;",
      garbageValue = "-34"
   )
   public static final class78 method628(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(-1 == var1) {
         var4 = 0;
      } else if(var4 == 2 && 1 != var1) {
         var4 = 1;
      }

      long var6 = ((long)var3 << 42) + ((long)var4 << 40) + ((long)var2 << 38) + ((long)var1 << 16) + (long)var0;
      class78 var8;
      if(!var5) {
         var8 = (class78)class51.field1092.method3704(var6);
         if(var8 != null) {
            return var8;
         }
      }

      class51 var9 = class89.method2081(var0);
      if(var1 > 1 && var9.field1123 != null) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.field1124[var11] && 0 != var9.field1124[var11]) {
               var10 = var9.field1123[var11];
            }
         }

         if(-1 != var10) {
            var9 = class89.method2081(var10);
         }
      }

      class105 var19 = var9.method1058(1);
      if(null == var19) {
         return null;
      } else {
         class78 var20 = null;
         if(-1 != var9.field1139) {
            var20 = method628(var9.field1125, 10, 1, 0, 0, true);
            if(var20 == null) {
               return null;
            }
         } else if(var9.field1116 != -1) {
            var20 = method628(var9.field1134, var1, var2, var3, 0, false);
            if(null == var20) {
               return null;
            }
         } else if(var9.field1137 != -1) {
            var20 = method628(var9.field1113, var1, 0, 0, 0, false);
            if(var20 == null) {
               return null;
            }
         }

         int[] var12 = class79.field1398;
         int var13 = class79.field1397;
         int var14 = class79.field1396;
         int[] var15 = new int[4];
         class79.method1779(var15);
         var8 = new class78(36, 32);
         class79.method1774(var8.field1392, 36, 32);
         class79.method1781();
         class91.method2087();
         class91.method2101(16, 16);
         class91.field1551 = false;
         if(var9.field1137 != -1) {
            var20.method1700(0, 0);
         }

         int var16 = var9.field1100;
         if(var5) {
            var16 = (int)(1.5D * (double)var16);
         } else if(var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = var16 * class91.field1571[var9.field1101] >> 16;
         int var18 = var16 * class91.field1572[var9.field1101] >> 16;
         var19.method2335();
         var19.method2299(0, var9.field1084, var9.field1103, var9.field1101, var9.field1104, var9.field1096 + var19.field1443 / 2 + var17, var18 + var9.field1096);
         if(var9.field1116 != -1) {
            var20.method1700(0, 0);
         }

         if(var2 >= 1) {
            var8.method1742(1);
         }

         if(var2 >= 2) {
            var8.method1742(16777215);
         }

         if(0 != var3) {
            var8.method1763(var3);
         }

         class79.method1774(var8.field1392, 36, 32);
         if(-1 != var9.field1139) {
            var20.method1700(0, 0);
         }

         if(var4 == 1 || 2 == var4 && 1 == var9.field1106) {
            class209.field3128.method4006(class99.method2195(var1), 0, 9, 16776960, 1);
         }

         if(!var5) {
            class51.field1092.method3706(var8, var6);
         }

         class79.method1774(var12, var13, var14);
         class79.method1810(var15);
         class91.method2087();
         class91.field1551 = true;
         return var8;
      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Lclass66;I)V",
      garbageValue = "1647603721"
   )
   static final void method629(class66 var0) {
      var0.field1246 = false;
      if(var0.field1249 != null) {
         var0.field1249.field1245 = 0;
      }

      for(class66 var1 = var0.vmethod3673(); null != var1; var1 = var0.vmethod3674()) {
         method629(var1);
      }

   }
}
