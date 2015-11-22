package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("m")
public class class1 {
   @ObfuscatedName("gs")
   static class172 field26;
   @ObfuscatedName("v")
   public static String field29;

   @ObfuscatedName("h")
   static final void method11(class121 var0, int var1, class2 var2, int var3) {
      byte var4 = -1;
      int var5;
      if(0 != (var3 & 1)) {
         var5 = var0.method2536();
         byte[] var6 = new byte[var5];
         class118 var7 = new class118(var6);
         var0.method2546(var6, 0, var5);
         class32.field732[var1] = var7;
         var2.method14(var7);
      }

      int var14;
      if(0 != (var3 & 8)) {
         var5 = var0.method2538();
         if(var5 == '\uffff') {
            var5 = -1;
         }

         var14 = var0.method2536();
         class172.method3500(var2, var5, var14);
      }

      if(0 != (var3 & 2)) {
         var2.field823 = var0.method2538();
         if(var2.field823 == '\uffff') {
            var2.field823 = -1;
         }
      }

      if(0 != (var3 & 64)) {
         var2.field852 = var0.method2544();
         if(var2.field852.charAt(0) == 126) {
            var2.field852 = var2.field852.substring(1);
            class50.method1063(2, var2.field34, var2.field852);
         } else if(var2 == class0.field12) {
            class50.method1063(2, var2.field34, var2.field852);
         }

         var2.field812 = false;
         var2.field815 = 0;
         var2.field798 = 0;
         var2.field814 = 150;
      }

      if(0 != (var3 & 128)) {
         var5 = var0.method2538();
         var14 = var0.method2536();
         var2.method792(var5, var14, client.field286);
         var2.field820 = client.field286 + 300;
         var2.field833 = var0.method2536();
         var2.field853 = var0.method2536();
      }

      if(0 != (var3 & 4)) {
         var2.field825 = var0.method2538();
         if(var2.field851 == 0) {
            var2.field848 = var2.field825;
            var2.field825 = -1;
         }
      }

      if(0 != (var3 & 16)) {
         var5 = var0.method2538();
         class151[] var15 = new class151[]{class151.field2253, class151.field2249, class151.field2252, class151.field2250, class151.field2251};
         class151 var16 = (class151)class23.method634(var15, var0.method2536());
         boolean var8 = var0.method2536() == 1;
         int var9 = var0.method2536();
         int var10 = var0.field1981;
         if(null != var2.field34 && var2.field31 != null) {
            boolean var11 = false;
            if(var16.field2257 && class40.method881(var2.field34)) {
               var11 = true;
            }

            if(!var11 && client.field396 == 0 && !var2.field35) {
               class32.field739.field1981 = 0;
               var0.method2546(class32.field739.field1980, 0, var9);
               class32.field739.field1981 = 0;
               String var12 = class222.method4107(class126.method2858(class150.method3183(class32.field739)));
               var2.field852 = var12.trim();
               var2.field815 = var5 >> 8;
               var2.field798 = var5 & 255;
               var2.field814 = 150;
               var2.field812 = var8;
               var2.field813 = class0.field12 != var2 && var16.field2257 && client.field494 != "" && var12.toLowerCase().indexOf(client.field494) == -1;
               int var13;
               if(var16.field2256) {
                  var13 = var8?91:1;
               } else {
                  var13 = var8?90:2;
               }

               if(var16.field2255 != -1) {
                  class50.method1063(var13, class19.method265(var16.field2255) + var2.field34, var12);
               } else {
                  class50.method1063(var13, var2.field34, var12);
               }
            }
         }

         var0.field1981 = var10 + var9;
      }

      if(0 != (var3 & 4096)) {
         var2.field805 = var0.method2538();
         var5 = var0.method2541();
         var2.field838 = var5 >> 16;
         var2.field837 = (var5 & '\uffff') + client.field286;
         var2.field835 = 0;
         var2.field808 = 0;
         if(var2.field837 > client.field286) {
            var2.field835 = -1;
         }

         if(var2.field805 == '\uffff') {
            var2.field805 = -1;
         }
      }

      if((var3 & 8192) != 0) {
         var2.field839 = var0.method2537();
         var2.field842 = var0.method2537();
         var2.field840 = var0.method2537();
         var2.field821 = var0.method2537();
         var2.field843 = var0.method2538() + client.field286;
         var2.field844 = var0.method2538() + client.field286;
         var2.field845 = var0.method2538();
         if(var2.field54) {
            var2.field839 += var2.field55;
            var2.field842 += var2.field51;
            var2.field840 += var2.field55;
            var2.field821 += var2.field51;
            var2.field851 = 0;
         } else {
            var2.field839 += var2.field809[0];
            var2.field842 += var2.field816[0];
            var2.field840 += var2.field809[0];
            var2.field821 += var2.field816[0];
            var2.field851 = 1;
         }

         var2.field856 = 0;
      }

      if((var3 & 2048) != 0) {
         var5 = var0.method2538();
         var14 = var0.method2536();
         var2.method792(var5, var14, client.field286);
         var2.field820 = client.field286 + 300;
         var2.field833 = var0.method2536();
         var2.field853 = var0.method2536();
      }

      if(0 != (var3 & 512)) {
         class32.field731[var1] = var0.method2537();
      }

      if(0 != (var3 & 1024)) {
         var4 = var0.method2537();
      }

      if(0 != (var3 & 256)) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.field32[var5] = var0.method2544();
         }
      }

      if(var2.field54) {
         if(var4 == 127) {
            var2.method26(var2.field55, var2.field51);
         } else {
            byte var17;
            if(-1 != var4) {
               var17 = var4;
            } else {
               var17 = class32.field731[var1];
            }

            var2.method32(var2.field55, var2.field51, var17);
         }
      }

   }

   @ObfuscatedName("f")
   static final void method12(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var1 + var3; ++var4) {
         for(int var5 = var0; var5 <= var2 + var0; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class150.field2239[0][var5][var4] = 127;
               if(var5 == var0 && var5 > 0) {
                  class5.field79[0][var5][var4] = class5.field79[0][var5 - 1][var4];
               }

               if(var0 + var2 == var5 && var5 < 103) {
                  class5.field79[0][var5][var4] = class5.field79[0][1 + var5][var4];
               }

               if(var1 == var4 && var4 > 0) {
                  class5.field79[0][var5][var4] = class5.field79[0][var5][var4 - 1];
               }

               if(var4 == var3 + var1 && var4 < 103) {
                  class5.field79[0][var5][var4] = class5.field79[0][var5][1 + var4];
               }
            }
         }
      }

   }
}
