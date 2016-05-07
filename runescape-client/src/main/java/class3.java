import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
@Implements("WidgetNode")
public class class3 extends class208 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -126626049
   )
   int field62;
   @ObfuscatedName("np")
   static class56 field63;
   @ObfuscatedName("bx")
   static class168 field65;
   @ObfuscatedName("pl")
   @ObfuscatedGetter(
      longValue = -5522803314307596465L
   )
   static long field66;
   @ObfuscatedName("kx")
   static class131 field67;
   @ObfuscatedName("p")
   boolean field68 = false;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -343924459
   )
   @Export("id")
   int field69;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIIIZS)Lclass78;",
      garbageValue = "21362"
   )
   public static final class78 method33(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(-1 == var1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var1 << 16) + (long)var0 + ((long)var2 << 38) + ((long)var4 << 40) + ((long)var3 << 42);
      class78 var8;
      if(!var5) {
         var8 = (class78)class51.field1113.method3743(var6);
         if(null != var8) {
            return var8;
         }
      }

      class51 var9 = class9.method128(var0);
      if(var1 > 1 && null != var9.field1144) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.field1145[var11] && var9.field1145[var11] != 0) {
               var10 = var9.field1144[var11];
            }
         }

         if(-1 != var10) {
            var9 = class9.method128(var10);
         }
      }

      class105 var21 = var9.method1000(1);
      if(var21 == null) {
         return null;
      } else {
         class78 var22 = null;
         if(var9.field1147 != -1) {
            var22 = method33(var9.field1146, 10, 1, 0, 0, true);
            if(var22 == null) {
               return null;
            }
         } else if(var9.field1156 != -1) {
            var22 = method33(var9.field1155, var1, var2, var3, 0, false);
            if(var22 == null) {
               return null;
            }
         } else if(var9.field1109 != -1) {
            var22 = method33(var9.field1157, var1, 0, 0, 0, false);
            if(null == var22) {
               return null;
            }
         }

         int[] var12 = class79.field1420;
         int var13 = class79.field1419;
         int var14 = class79.field1422;
         int[] var15 = new int[4];
         class79.method1769(var15);
         var8 = new class78(36, 32);
         class79.method1800(var8.field1414, 36, 32);
         class79.method1771();
         class91.method2070();
         class91.method2073(16, 16);
         class91.field1588 = false;
         if(var9.field1109 != -1) {
            var22.method1676(0, 0);
         }

         int var16 = var9.field1121;
         if(var5) {
            var16 = (int)((double)var16 * 1.5D);
         } else if(2 == var2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = class91.field1596[var9.field1122] * var16 >> 16;
         int var18 = var16 * class91.field1597[var9.field1122] >> 16;
         var21.method2287();
         var21.method2299(0, var9.field1123, var9.field1126, var9.field1122, var9.field1125, var17 + var21.field1465 / 2 + var9.field1138, var18 + var9.field1138);
         if(var9.field1156 != -1) {
            var22.method1676(0, 0);
         }

         if(var2 >= 1) {
            var8.method1672(1);
         }

         if(var2 >= 2) {
            var8.method1672(16777215);
         }

         if(0 != var3) {
            var8.method1673(var3);
         }

         class79.method1800(var8.field1414, 36, 32);
         if(var9.field1147 != -1) {
            var22.method1676(0, 0);
         }

         if(var4 == 1 || 2 == var4 && var9.field1127 == 1) {
            class224 var19 = class90.field1567;
            String var20;
            if(var1 < 100000) {
               var20 = "<col=ffff00>" + var1 + "</col>";
            } else if(var1 < 10000000) {
               var20 = "<col=ffffff>" + var1 / 1000 + "K" + "</col>";
            } else {
               var20 = "<col=00ff80>" + var1 / 1000000 + "M" + "</col>";
            }

            var19.method4002(var20, 0, 9, 16776960, 1);
         }

         if(!var5) {
            class51.field1113.method3745(var8, var6);
         }

         class79.method1800(var12, var13, var14);
         class79.method1782(var15);
         class91.method2070();
         class91.field1588 = true;
         return var8;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)[Lclass20;",
      garbageValue = "-36"
   )
   static class20[] method34() {
      return new class20[]{class20.field572, class20.field565, class20.field567, class20.field571};
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "103"
   )
   static int method35() {
      return 9;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass122;ILclass2;IS)V",
      garbageValue = "-8716"
   )
   static final void method36(class122 var0, int var1, class2 var2, int var3) {
      byte var4 = -1;
      int var5;
      if((var3 & 2) != 0) {
         var5 = var0.method2492();
         byte[] var6 = new byte[var5];
         class119 var7 = new class119(var6);
         var0.method2503(var6, 0, var5);
         class32.field768[var1] = var7;
         var2.method11(var7);
      }

      int var13;
      if(0 != (var3 & 16)) {
         var5 = var0.method2584();
         if(var5 == '\uffff') {
            var5 = -1;
         }

         var13 = var0.method2492();
         class17.method204(var2, var5, var13);
      }

      if(0 != (var3 & 64)) {
         var2.field837 = var0.method2584();
         if('\uffff' == var2.field837) {
            var2.field837 = -1;
         }
      }

      if(0 != (var3 & 8)) {
         var2.field819 = var0.method2500();
         if(var2.field819.charAt(0) == 126) {
            var2.field819 = var2.field819.substring(1);
            class125.method2783(2, var2.field59, var2.field819);
         } else if(class106.field1881 == var2) {
            class125.method2783(2, var2.field59, var2.field819);
         }

         var2.field827 = false;
         var2.field829 = 0;
         var2.field830 = 0;
         var2.field828 = 150;
      }

      if((var3 & 128) != 0) {
         var5 = var0.method2584();
         var13 = var0.method2492();
         var2.method729(var5, var13, client.field335);
         var2.field867 = 300 + client.field335;
         var2.field846 = var0.method2492();
         var2.field835 = var0.method2492();
      }

      if((var3 & 32) != 0) {
         var2.field824 = var0.method2584();
         if(var2.field841 == 0) {
            var2.field862 = var2.field824;
            var2.field824 = -1;
         }
      }

      if(0 != (var3 & 4)) {
         var5 = var0.method2584();
         class152 var14 = (class152)class75.method1616(class115.method2441(), var0.method2492());
         boolean var15 = var0.method2492() == 1;
         int var8 = var0.method2492();
         int var9 = var0.field2005;
         if(var2.field59 != null && null != var2.field34) {
            boolean var10 = false;
            if(var14.field2271 && class16.method196(var2.field59)) {
               var10 = true;
            }

            if(!var10 && 0 == client.field358 && !var2.field58) {
               class32.field758.field2005 = 0;
               var0.method2503(class32.field758.field2007, 0, var8);
               class32.field758.field2005 = 0;
               String var11 = class223.method4001(class34.method711(class152.method3131(class32.field758)));
               var2.field819 = var11.trim();
               var2.field829 = var5 >> 8;
               var2.field830 = var5 & 255;
               var2.field828 = 150;
               var2.field827 = var15;
               var2.field865 = var2 != class106.field1881 && var14.field2271 && "" != client.field393 && var11.toLowerCase().indexOf(client.field393) == -1;
               int var12;
               if(var14.field2280) {
                  var12 = var15?91:1;
               } else {
                  var12 = var15?90:2;
               }

               if(var14.field2283 != -1) {
                  class125.method2783(var12, class156.method3146(var14.field2283) + var2.field59, var11);
               } else {
                  class125.method2783(var12, var2.field59, var11);
               }
            }
         }

         var0.field2005 = var8 + var9;
      }

      if(0 != (var3 & 1024)) {
         var2.field848 = var0.method2584();
         var5 = var0.method2497();
         var2.field859 = var5 >> 16;
         var2.field825 = (var5 & '\uffff') + client.field335;
         var2.field849 = 0;
         var2.field822 = 0;
         if(var2.field825 > client.field335) {
            var2.field849 = -1;
         }

         if('\uffff' == var2.field848) {
            var2.field848 = -1;
         }
      }

      if(0 != (var3 & 2048)) {
         var2.field853 = var0.method2493();
         var2.field818 = var0.method2493();
         var2.field854 = var0.method2493();
         var2.field856 = var0.method2493();
         var2.field857 = var0.method2584() + client.field335;
         var2.field812 = var0.method2584() + client.field335;
         var2.field836 = var0.method2584();
         if(var2.field36) {
            var2.field853 += var2.field37;
            var2.field818 += var2.field57;
            var2.field854 += var2.field37;
            var2.field856 += var2.field57;
            var2.field841 = 0;
         } else {
            var2.field853 += var2.field866[0];
            var2.field818 += var2.field863[0];
            var2.field854 += var2.field866[0];
            var2.field856 += var2.field863[0];
            var2.field841 = 1;
         }

         var2.field870 = 0;
      }

      if(0 != (var3 & 256)) {
         var5 = var0.method2584();
         var13 = var0.method2492();
         var2.method729(var5, var13, client.field335);
         var2.field867 = 300 + client.field335;
         var2.field846 = var0.method2492();
         var2.field835 = var0.method2492();
      }

      if((var3 & 4096) != 0) {
         class32.field753[var1] = var0.method2493();
      }

      if(0 != (var3 & 8192)) {
         var4 = var0.method2493();
      }

      if(0 != (var3 & 512)) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.field50[var5] = var0.method2500();
         }
      }

      if(var2.field36) {
         if(127 == var4) {
            var2.method15(var2.field37, var2.field57);
         } else {
            byte var16;
            if(-1 != var4) {
               var16 = var4;
            } else {
               var16 = class32.field753[var1];
            }

            var2.method31(var2.field37, var2.field57, var16);
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2027975748"
   )
   public static void method37() {
      class43.field1019.method3750();
      class43.field1005.method3750();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Lclass52;",
      garbageValue = "-2039651124"
   )
   public static class52 method38(int var0) {
      class52 var1 = (class52)class52.field1162.method3743((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class52.field1167.method3239(16, var0);
         var1 = new class52();
         if(var2 != null) {
            var1.method1051(new class119(var2));
         }

         class52.field1162.method3745(var1, (long)var0);
         return var1;
      }
   }
}
