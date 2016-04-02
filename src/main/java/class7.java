import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
@Implements("Ignore")
public class class7 {
   @ObfuscatedName("w")
   @Export("previousName")
   String field135;
   @ObfuscatedName("ii")
   static class173 field138;
   @ObfuscatedName("jc")
   @ObfuscatedGetter(
      intValue = -402706641
   )
   static int field139;
   @ObfuscatedName("e")
   @Export("name")
   String field141;

   @ObfuscatedName("m")
   public static final class78 method105(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(-1 == var1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var4 << 40) + ((long)var2 << 38) + ((long)var1 << 16) + (long)var0 + ((long)var3 << 42);
      class78 var8;
      if(!var5) {
         var8 = (class78)class51.field1129.method3754(var6);
         if(null != var8) {
            return var8;
         }
      }

      class51 var9 = class33.method711(var0);
      if(var1 > 1 && null != var9.field1119) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.field1120[var11] && var9.field1120[var11] != 0) {
               var10 = var9.field1119[var11];
            }
         }

         if(var10 != -1) {
            var9 = class33.method711(var10);
         }
      }

      class105 var21 = var9.method1021(1);
      if(var21 == null) {
         return null;
      } else {
         class78 var22 = null;
         if(-1 != var9.field1122) {
            var22 = method105(var9.field1121, 10, 1, 0, 0, true);
            if(var22 == null) {
               return null;
            }
         } else if(-1 != var9.field1131) {
            var22 = method105(var9.field1128, var1, var2, var3, 0, false);
            if(var22 == null) {
               return null;
            }
         }

         int[] var12 = class79.field1383;
         int var13 = class79.field1387;
         int var14 = class79.field1384;
         int[] var15 = new int[4];
         class79.method1805(var15);
         var8 = new class78(36, 32);
         class79.method1821(var8.field1379, 36, 32);
         class79.method1807();
         class91.method2104();
         class91.method2107(16, 16);
         class91.field1548 = false;
         int var16 = var9.field1096;
         if(var5) {
            var16 = (int)(1.5D * (double)var16);
         } else if(var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = class91.field1568[var9.field1097] * var16 >> 16;
         int var18 = class91.field1554[var9.field1097] * var16 >> 16;
         var21.method2341();
         var21.method2380(0, var9.field1098, var9.field1084, var9.field1097, var9.field1106, var21.field1438 / 2 + var17 + var9.field1133, var18 + var9.field1133);
         if(var9.field1131 != -1) {
            var22.method1709(0, 0);
         }

         if(var2 >= 1) {
            var8.method1742(1);
         }

         if(var2 >= 2) {
            var8.method1742(16777215);
         }

         if(var3 != 0) {
            var8.method1735(var3);
         }

         class79.method1821(var8.field1379, 36, 32);
         if(-1 != var9.field1122) {
            var22.method1709(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.field1102 == 1) {
            class224 var19 = class222.field3181;
            String var20;
            if(var1 < 100000) {
               var20 = "<col=ffff00>" + var1 + "</col>";
            } else if(var1 < 10000000) {
               var20 = "<col=ffffff>" + var1 / 1000 + "K" + "</col>";
            } else {
               var20 = "<col=00ff80>" + var1 / 1000000 + "M" + "</col>";
            }

            var19.method4019(var20, 0, 9, 16776960, 1);
         }

         if(!var5) {
            class51.field1129.method3756(var8, var6);
         }

         class79.method1821(var12, var13, var14);
         class79.method1806(var15);
         class91.method2104();
         class91.field1548 = true;
         return var8;
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "4"
   )
   static final void method106() {
      int[] var0 = class32.field732;

      int var1;
      for(var1 = 0; var1 < class32.field731; ++var1) {
         class2 var2 = client.field387[var0[var1]];
         if(null != var2 && var2.field837 > 0) {
            --var2.field837;
            if(var2.field837 == 0) {
               var2.field801 = null;
            }
         }
      }

      for(var1 = 0; var1 < client.field317; ++var1) {
         int var4 = client.field318[var1];
         class34 var3 = client.field316[var4];
         if(var3 != null && var3.field837 > 0) {
            --var3.field837;
            if(0 == var3.field837) {
               var3.field801 = null;
            }
         }
      }

   }
}
