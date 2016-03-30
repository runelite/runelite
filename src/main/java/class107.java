import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("da")
public abstract class class107 {
   @ObfuscatedName("aw")
   static class143 field1886;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1475125683
   )
   public int field1887;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 165281467
   )
   public int field1888;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 272784255
   )
   public int field1889;
   @ObfuscatedName("bs")
   static String field1891;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2078327987
   )
   public int field1892;

   @ObfuscatedName("l")
   public static final class78 method2388(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var3 << 42) + ((long)var4 << 40) + (long)var0 + ((long)var1 << 16) + ((long)var2 << 38);
      class78 var8;
      if(!var5) {
         var8 = (class78)class51.field1119.method3771(var6);
         if(var8 != null) {
            return var8;
         }
      }

      class51 var9 = class50.method1055(var0);
      if(var1 > 1 && var9.field1134 != null) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.field1126[var11] && 0 != var9.field1126[var11]) {
               var10 = var9.field1134[var11];
            }
         }

         if(var10 != -1) {
            var9 = class50.method1055(var10);
         }
      }

      class105 var19 = var9.method1084(1);
      if(null == var19) {
         return null;
      } else {
         class78 var20 = null;
         if(-1 != var9.field1153) {
            var20 = method2388(var9.field1150, 10, 1, 0, 0, true);
            if(null == var20) {
               return null;
            }
         } else if(-1 != var9.field1152) {
            var20 = method2388(var9.field1161, var1, var2, var3, 0, false);
            if(null == var20) {
               return null;
            }
         }

         int[] var12 = class79.field1416;
         int var13 = class79.field1414;
         int var14 = class79.field1415;
         int[] var15 = new int[4];
         class79.method1775(var15);
         var8 = new class78(36, 32);
         class79.method1771(var8.field1406, 36, 32);
         class79.method1777();
         class91.method2082();
         class91.method2104(16, 16);
         class91.field1574 = false;
         int var16 = var9.field1158;
         if(var5) {
            var16 = (int)((double)var16 * 1.5D);
         } else if(var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = var16 * class91.field1573[var9.field1140] >> 16;
         int var18 = var16 * class91.field1595[var9.field1140] >> 16;
         var19.method2323();
         var19.method2349(0, var9.field1129, var9.field1130, var9.field1140, var9.field1131, var9.field1132 + var19.field1467 / 2 + var17, var18 + var9.field1132);
         if(var9.field1152 != -1) {
            var20.method1699(0, 0);
         }

         if(var2 >= 1) {
            var8.method1695(1);
         }

         if(var2 >= 2) {
            var8.method1695(16777215);
         }

         if(var3 != 0) {
            var8.method1747(var3);
         }

         class79.method1771(var8.field1406, 36, 32);
         if(-1 != var9.field1153) {
            var20.method1699(0, 0);
         }

         if(1 == var4 || 2 == var4 && 1 == var9.field1133) {
            class96.field1642.method4037(class93.method2159(var1), 0, 9, 16776960, 1);
         }

         if(!var5) {
            class51.field1119.method3773(var8, var6);
         }

         class79.method1771(var12, var13, var14);
         class79.method1776(var15);
         class91.method2082();
         class91.field1574 = true;
         return var8;
      }
   }

   @ObfuscatedName("w")
   public abstract boolean vmethod2389(int var1, int var2);
}
