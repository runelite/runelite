package net.runelite.rs.client;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ew")
public class class147 extends RuntimeException {
   @ObfuscatedName("fu")
   @ObfuscatedGetter(
      intValue = 1006578465
   )
   @Export("cameraY")
   static int field2228;
   @ObfuscatedName("o")
   static int[] field2230;
   @ObfuscatedName("f")
   Throwable field2231;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 534616485
   )
   static int field2232;
   @ObfuscatedName("i")
   String field2234;
   @ObfuscatedName("l")
   public static String field2235;

   @ObfuscatedName("h")
   static final void method3082(class121 var0, int var1, class2 var2, int var3) {
      byte var4 = -1;
      int var5;
      if((var3 & 128) != 0) {
         var5 = var0.method2453();
         byte[] var6 = new byte[var5];
         class118 var7 = new class118(var6);
         var0.method2534(var6, 0, var5);
         class32.field745[var1] = var7;
         var2.method11(var7);
      }

      int var16;
      if(0 != (var3 & 64)) {
         var5 = var0.method2455();
         if('\uffff' == var5) {
            var5 = -1;
         }

         var16 = var0.method2453();
         class14.method164(var2, var5, var16);
      }

      if(0 != (var3 & 8)) {
         var2.field835 = var0.method2455();
         if('\uffff' == var2.field835) {
            var2.field835 = -1;
         }
      }

      if(0 != (var3 & 2)) {
         var2.field823 = var0.method2461();
         if(var2.field823.charAt(0) == 126) {
            var2.field823 = var2.field823.substring(1);
            class16.method186(2, var2.field48, var2.field823);
         } else if(class148.field2249 == var2) {
            class16.method186(2, var2.field48, var2.field823);
         }

         var2.field842 = false;
         var2.field859 = 0;
         var2.field828 = 0;
         var2.field826 = 150;
      }

      if((var3 & 32) != 0) {
         var5 = var0.method2455();
         var16 = var0.method2453();
         var2.method754(var5, var16, client.field394);
         var2.field849 = client.field394 + 300;
         var2.field812 = var0.method2453();
         var2.field834 = var0.method2453();
      }

      if(0 != (var3 & 4)) {
         var2.field853 = var0.method2455();
         if(0 == var2.field824) {
            var2.field860 = var2.field853;
            var2.field853 = -1;
         }
      }

      if((var3 & 16) != 0) {
         var5 = var0.method2455();
         class151 var17 = (class151)class150.method3104(class175.method3414(), var0.method2453());
         boolean var18 = var0.method2453() == 1;
         int var8 = var0.method2453();
         int var9 = var0.field1998;
         if(null != var2.field48 && null != var2.field34) {
            boolean var10 = false;
            if(var17.field2278 && class18.method194(var2.field48)) {
               var10 = true;
            }

            if(!var10 && client.field471 == 0 && !var2.field54) {
               class32.field758.field1998 = 0;
               var0.method2534(class32.field758.field1995, 0, var8);
               class32.field758.field1998 = 0;
               String var11 = class222.method3966(class190.method3705(class215.method3889(class32.field758)));
               var2.field823 = var11.trim();
               var2.field859 = var5 >> 8;
               var2.field828 = var5 & 255;
               var2.field826 = 150;
               var2.field842 = var18;
               var2.field825 = class148.field2249 != var2 && var17.field2278 && "" != client.field508 && var11.toLowerCase().indexOf(client.field508) == -1;
               int var12;
               if(var17.field2277) {
                  var12 = var18?91:1;
               } else {
                  var12 = var18?90:2;
               }

               if(var17.field2276 != -1) {
                  int var15 = var17.field2276;
                  String var14 = "<img=" + var15 + ">";
                  class16.method186(var12, var14 + var2.field48, var11);
               } else {
                  class16.method186(var12, var2.field48, var11);
               }
            }
         }

         var0.field1998 = var9 + var8;
      }

      if(0 != (var3 & 8192)) {
         var2.field846 = var0.method2455();
         var5 = var0.method2458();
         var2.field850 = var5 >> 16;
         var2.field833 = (var5 & '\uffff') + client.field394;
         var2.field847 = 0;
         var2.field841 = 0;
         if(var2.field833 > client.field394) {
            var2.field847 = -1;
         }

         if('\uffff' == var2.field846) {
            var2.field846 = -1;
         }
      }

      if(0 != (var3 & 256)) {
         var2.field851 = var0.method2454();
         var2.field832 = var0.method2454();
         var2.field810 = var0.method2454();
         var2.field854 = var0.method2454();
         var2.field855 = var0.method2455() + client.field394;
         var2.field856 = var0.method2455() + client.field394;
         var2.field865 = var0.method2455();
         if(var2.field49) {
            var2.field851 += var2.field57;
            var2.field832 += var2.field35;
            var2.field810 += var2.field57;
            var2.field854 += var2.field35;
            var2.field824 = 0;
         } else {
            var2.field851 += var2.field864[0];
            var2.field832 += var2.field817[0];
            var2.field810 += var2.field864[0];
            var2.field854 += var2.field817[0];
            var2.field824 = 1;
         }

         var2.field868 = 0;
      }

      if((var3 & 512) != 0) {
         var5 = var0.method2455();
         var16 = var0.method2453();
         var2.method754(var5, var16, client.field394);
         var2.field849 = client.field394 + 300;
         var2.field812 = var0.method2453();
         var2.field834 = var0.method2453();
      }

      if((var3 & 1024) != 0) {
         class32.field747[var1] = var0.method2454();
      }

      if(0 != (var3 & 4096)) {
         var4 = var0.method2454();
      }

      if(0 != (var3 & 2048)) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.field38[var5] = var0.method2461();
         }
      }

      if(var2.field49) {
         if(var4 == 127) {
            var2.method12(var2.field57, var2.field35);
         } else {
            byte var19;
            if(var4 != -1) {
               var19 = var4;
            } else {
               var19 = class32.field747[var1];
            }

            var2.method26(var2.field57, var2.field35, var19);
         }
      }

   }

   @ObfuscatedName("j")
   public static class152[] method3084() {
      return new class152[]{class152.field2282, class152.field2280, class152.field2281, class152.field2285};
   }

   @ObfuscatedName("m")
   public static boolean method3085(char var0) {
      return var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }
}
