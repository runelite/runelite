import java.awt.Component;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class26 {
   @ObfuscatedName("b")
   public static String field659;
   @ObfuscatedName("ev")
   static class78[] field663;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "28"
   )
   public static String method633(int var0) {
      return (var0 >> 24 & 255) + "." + (var0 >> 16 & 255) + "." + (var0 >> 8 & 255) + "." + (var0 & 255);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1841163205"
   )
   public static boolean method634(int var0) {
      return (var0 >> 31 & 1) != 0;
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1312804641"
   )
   static void method635() {
      for(int var0 = 0; var0 < client.field429; ++var0) {
         int var2 = client.field432[var0];
         boolean var1 = var2 == 57 || var2 == 58 || var2 == 1007 || var2 == 25 || var2 == 30;
         if(var1) {
            if(var0 < client.field429 - 1) {
               for(int var3 = var0; var3 < client.field429 - 1; ++var3) {
                  client.field434[var3] = client.field434[1 + var3];
                  client.field396[var3] = client.field396[1 + var3];
                  client.field432[var3] = client.field432[1 + var3];
                  client.field433[var3] = client.field433[var3 + 1];
                  client.field419[var3] = client.field419[1 + var3];
                  client.field431[var3] = client.field431[1 + var3];
               }
            }

            --client.field429;
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;Lclass167;Lclass167;ZII)V",
      garbageValue = "-2050757607"
   )
   static void method636(Component var0, class167 var1, class167 var2, boolean var3, int var4) {
      if(class31.field701) {
         if(var4 == 4) {
            class31.field715 = 4;
         }

      } else {
         class31.field715 = var4;
         class79.method1850();
         byte[] var5 = var1.method3294("title.jpg", "");
         class31.field699 = new class78(var5, var0);
         class31.field730 = class31.field699.method1700();
         if((client.field477 & 536870912) != 0) {
            class31.field696 = class153.method3168(var2, "logo_deadman_mode", "");
         } else {
            class31.field696 = class153.method3168(var2, "logo", "");
         }

         class31.field708 = class153.method3168(var2, "titlebox", "");
         class31.field714 = class153.method3168(var2, "titlebutton", "");
         class31.field720 = class20.method554(var2, "runes", "");
         class90.field1539 = class20.method554(var2, "title_mute", "");
         class38.field855 = class153.method3168(var2, "options_radio_buttons,0", "");
         class209.field3117 = class153.method3168(var2, "options_radio_buttons,2", "");
         class11.field165 = new int[256];

         int var6;
         for(var6 = 0; var6 < 64; ++var6) {
            class11.field165[var6] = 262144 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class11.field165[64 + var6] = 1024 * var6 + 16711680;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class11.field165[var6 + 128] = var6 * 4 + 16776960;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class11.field165[192 + var6] = 16777215;
         }

         class31.field706 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class31.field706[var6] = var6 * 1024;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class31.field706[var6 + 64] = var6 * 4 + '\uff00';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class31.field706[128 + var6] = '\uffff' + 262144 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class31.field706[var6 + 192] = 16777215;
         }

         class164.field2650 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class164.field2650[var6] = 4 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class164.field2650[var6 + 64] = var6 * 262144 + 255;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class164.field2650[var6 + 128] = 16711935 + var6 * 1024;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class164.field2650[var6 + 192] = 16777215;
         }

         class12.field184 = new int[256];
         class28.field673 = new int['耀'];
         class82.field1406 = new int['耀'];
         class150.method3153((class80)null);
         class36.field788 = new int['耀'];
         class98.field1633 = new int['耀'];
         if(var3) {
            class31.field726 = "";
            class31.field716 = "";
         }

         class38.field854 = 0;
         class170.field2705 = "";
         class31.field723 = true;
         class31.field727 = false;
         if(!class162.field2637.field128) {
            class168 var9 = client.field358;
            int var7 = var9.method3281("scape main");
            int var8 = var9.method3282(var7, "");
            class12.method155(2, var9, var7, var8, 255, false);
         } else {
            class183.field2953 = 1;
            class50.field1075 = null;
            class177.field2903 = -1;
            class183.field2951 = -1;
            class181.field2929 = 0;
            class183.field2956 = false;
            class183.field2955 = 2;
         }

         class98.method2200(false);
         class31.field701 = true;
         class31.field695 = (class45.field1026 - client.field502) / 2;
         class31.field711 = 202 + class31.field695;
         class31.field699.method1771(class31.field695, 0);
         class31.field730.method1771(class31.field695 + 382, 0);
         class31.field696.method1873(382 + class31.field695 - class31.field696.field1390 / 2, 18);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IILclass107;Lclass108;I)Z",
      garbageValue = "569085601"
   )
   public static final boolean method637(int var0, int var1, class107 var2, class108 var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class106.field1853[var6][var7] = 99;
      class106.field1851[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class106.field1856[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class106.field1857[var10001] = var1;
      int[][] var12 = var3.field1884;

      while(var18 != var11) {
         var4 = class106.field1856[var11];
         var5 = class106.field1857[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.field1880;
         int var14 = var5 - var3.field1873;
         if(var2.vmethod2385(2, var4, var5, var3)) {
            class15.field219 = var4;
            class45.field1023 = var5;
            return true;
         }

         int var15 = class106.field1851[var16][var17] + 1;
         if(var16 > 0 && class106.field1853[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136782) == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0) {
            class106.field1856[var18] = var4 - 1;
            class106.field1857[var18] = var5;
            var18 = 1 + var18 & 4095;
            class106.field1853[var16 - 1][var17] = 2;
            class106.field1851[var16 - 1][var17] = var15;
         }

         if(var16 < 126 && class106.field1853[1 + var16][var17] == 0 && (var12[var13 + 2][var14] & 19136899) == 0 && (var12[var13 + 2][1 + var14] & 19136992) == 0) {
            class106.field1856[var18] = 1 + var4;
            class106.field1857[var18] = var5;
            var18 = var18 + 1 & 4095;
            class106.field1853[1 + var16][var17] = 8;
            class106.field1851[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class106.field1853[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136782) == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0) {
            class106.field1856[var18] = var4;
            class106.field1857[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class106.field1853[var16][var17 - 1] = 1;
            class106.field1851[var16][var17 - 1] = var15;
         }

         if(var17 < 126 && class106.field1853[var16][var17 + 1] == 0 && (var12[var13][2 + var14] & 19136824) == 0 && (var12[var13 + 1][var14 + 2] & 19136992) == 0) {
            class106.field1856[var18] = var4;
            class106.field1857[var18] = 1 + var5;
            var18 = var18 + 1 & 4095;
            class106.field1853[var16][var17 + 1] = 4;
            class106.field1851[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class106.field1853[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14] & 19136830) == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13][var14 - 1] & 19136911) == 0) {
            class106.field1856[var18] = var4 - 1;
            class106.field1857[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class106.field1853[var16 - 1][var17 - 1] = 3;
            class106.field1851[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 126 && var17 > 0 && class106.field1853[1 + var16][var17 - 1] == 0 && (var12[1 + var13][var14 - 1] & 19136911) == 0 && (var12[2 + var13][var14 - 1] & 19136899) == 0 && (var12[2 + var13][var14] & 19136995) == 0) {
            class106.field1856[var18] = 1 + var4;
            class106.field1857[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class106.field1853[1 + var16][var17 - 1] = 9;
            class106.field1851[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 126 && class106.field1853[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][1 + var14] & 19136830) == 0 && (var12[var13 - 1][2 + var14] & 19136824) == 0 && (var12[var13][var14 + 2] & 19137016) == 0) {
            class106.field1856[var18] = var4 - 1;
            class106.field1857[var18] = var5 + 1;
            var18 = 1 + var18 & 4095;
            class106.field1853[var16 - 1][1 + var17] = 6;
            class106.field1851[var16 - 1][1 + var17] = var15;
         }

         if(var16 < 126 && var17 < 126 && class106.field1853[1 + var16][var17 + 1] == 0 && (var12[var13 + 1][var14 + 2] & 19137016) == 0 && (var12[var13 + 2][var14 + 2] & 19136992) == 0 && (var12[var13 + 2][var14 + 1] & 19136995) == 0) {
            class106.field1856[var18] = var4 + 1;
            class106.field1857[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class106.field1853[1 + var16][1 + var17] = 12;
            class106.field1851[1 + var16][var17 + 1] = var15;
         }
      }

      class15.field219 = var4;
      class45.field1023 = var5;
      return false;
   }
}
