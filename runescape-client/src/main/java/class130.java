import java.awt.Component;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
public class class130 {
   @ObfuscatedName("i")
   public static final class130 field2068 = new class130(1);
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1832619539
   )
   public final int field2069;
   @ObfuscatedName("g")
   static final class130 field2070 = new class130(2);
   @ObfuscatedName("t")
   static final class130 field2075 = new class130(0);

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1820039168"
   )
   static final void method2793() {
      int var0 = 64 + class95.field1636 * 128;
      int var1 = 64 + class28.field672 * 128;
      int var2 = class14.method147(var0, var1, class32.field754) - class96.field1644;
      if(class9.field155 < var0) {
         class9.field155 += class152.field2300 + (var0 - class9.field155) * class9.field151 / 1000;
         if(class9.field155 > var0) {
            class9.field155 = var0;
         }
      }

      if(class9.field155 > var0) {
         class9.field155 -= class9.field151 * (class9.field155 - var0) / 1000 + class152.field2300;
         if(class9.field155 < var0) {
            class9.field155 = var0;
         }
      }

      if(class13.field205 < var2) {
         class13.field205 += class9.field151 * (var2 - class13.field205) / 1000 + class152.field2300;
         if(class13.field205 > var2) {
            class13.field205 = var2;
         }
      }

      if(class13.field205 > var2) {
         class13.field205 -= (class13.field205 - var2) * class9.field151 / 1000 + class152.field2300;
         if(class13.field205 < var2) {
            class13.field205 = var2;
         }
      }

      if(class4.field81 < var1) {
         class4.field81 += class152.field2300 + class9.field151 * (var1 - class4.field81) / 1000;
         if(class4.field81 > var1) {
            class4.field81 = var1;
         }
      }

      if(class4.field81 > var1) {
         class4.field81 -= class152.field2300 + class9.field151 * (class4.field81 - var1) / 1000;
         if(class4.field81 < var1) {
            class4.field81 = var1;
         }
      }

      var0 = 64 + class48.field1096 * 128;
      var1 = 64 + class84.field1464 * 128;
      var2 = class14.method147(var0, var1, class32.field754) - class9.field156;
      int var3 = var0 - class9.field155;
      int var4 = var2 - class13.field205;
      int var5 = var1 - class4.field81;
      int var6 = (int)Math.sqrt((double)(var3 * var3 + var5 * var5));
      int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
      int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
      if(var7 < 128) {
         var7 = 128;
      }

      if(var7 > 383) {
         var7 = 383;
      }

      if(class138.field2164 < var7) {
         class138.field2164 += class144.field2230 + class134.field2095 * (var7 - class138.field2164) / 1000;
         if(class138.field2164 > var7) {
            class138.field2164 = var7;
         }
      }

      if(class138.field2164 > var7) {
         class138.field2164 -= class144.field2230 + (class138.field2164 - var7) * class134.field2095 / 1000;
         if(class138.field2164 < var7) {
            class138.field2164 = var7;
         }
      }

      int var9 = var8 - class19.field269;
      if(var9 > 1024) {
         var9 -= 2048;
      }

      if(var9 < -1024) {
         var9 += 2048;
      }

      if(var9 > 0) {
         class19.field269 += class144.field2230 + class134.field2095 * var9 / 1000;
         class19.field269 &= 2047;
      }

      if(var9 < 0) {
         class19.field269 -= class144.field2230 + class134.field2095 * -var9 / 1000;
         class19.field269 &= 2047;
      }

      int var10 = var8 - class19.field269;
      if(var10 > 1024) {
         var10 -= 2048;
      }

      if(var10 < -1024) {
         var10 += 2048;
      }

      if(var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
         class19.field269 = var8;
      }

   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class130(int var1) {
      this.field2069 = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;Lclass167;Lclass167;ZIS)V",
      garbageValue = "1"
   )
   static void method2794(Component var0, class167 var1, class167 var2, boolean var3, int var4) {
      if(!class31.field716) {
         class31.field717 = var4;
         class79.method1757();
         byte[] var5 = var1.method3279("title.jpg", "");
         class49.field1100 = new class78(var5, var0);
         class31.field705 = class49.field1100.method1663();
         if((client.field283 & 536870912) != 0) {
            class135.field2101 = class32.method691(var2, "logo_deadman_mode", "");
         } else {
            class135.field2101 = class32.method691(var2, "logo", "");
         }

         class131.field2081 = class32.method691(var2, "titlebox", "");
         class31.field704 = class32.method691(var2, "titlebutton", "");
         class109.field1916 = class214.method3893(var2, "runes", "");
         class31.field711 = class214.method3893(var2, "title_mute", "");
         class4.field71 = class32.method691(var2, "options_radio_buttons,0", "");
         class84.field1465 = class32.method691(var2, "options_radio_buttons,2", "");
         class119.field2005 = new int[256];

         int var6;
         for(var6 = 0; var6 < 64; ++var6) {
            class119.field2005[var6] = 262144 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class119.field2005[var6 + 64] = 1024 * var6 + 16711680;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class119.field2005[128 + var6] = 4 * var6 + 16776960;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class119.field2005[192 + var6] = 16777215;
         }

         class95.field1634 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class95.field1634[var6] = var6 * 1024;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class95.field1634[var6 + 64] = '\uff00' + var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class95.field1634[var6 + 128] = '\uffff' + 262144 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class95.field1634[var6 + 192] = 16777215;
         }

         class19.field271 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class19.field271[var6] = var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class19.field271[var6 + 64] = 262144 * var6 + 255;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class19.field271[128 + var6] = 1024 * var6 + 16711935;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class19.field271[var6 + 192] = 16777215;
         }

         class46.field1064 = new int[256];
         class162.field2678 = new int['耀'];
         class30.field700 = new int['耀'];
         class143.method2959((class80)null);
         class32.field752 = new int['耀'];
         class7.field136 = new int['耀'];
         class31.field722 = "";
         class31.field723 = "";
         class1.field33 = 0;
         class96.field1643 = "";
         class31.field725 = true;
         class31.field702 = false;
         if(!class116.field1988.field145) {
            class168 var9 = class103.field1783;
            int var7 = var9.method3236("scape main");
            int var8 = var9.method3237(var7, "");
            class157.method3140(2, var9, var7, var8, 255, false);
         } else {
            class20.method549(2);
         }

         if(null != class43.field1023) {
            try {
               class119 var13 = new class119(4);
               var13.method2453(3);
               var13.method2455(0);
               class43.field1023.method2964(var13.field2001, 0, 4);
            } catch (IOException var12) {
               try {
                  class43.field1023.method2960();
               } catch (Exception var11) {
                  ;
               }

               ++class171.field2752;
               class43.field1023 = null;
            }
         }

         class31.field716 = true;
         class31.field703 = (class10.field162 - client.field565) / 2;
         class31.field721 = class31.field703 + 202;
         class49.field1100.method1727(class31.field703, 0);
         class31.field705.method1727(382 + class31.field703, 0);
         class135.field2101.method1822(382 + class31.field703 - class135.field2101.field1424 / 2, 18);
      }
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-1814402362"
   )
   static final void method2796(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 2048 - var3 & 2047;
      int var7 = 2048 - var4 & 2047;
      int var8 = 0;
      int var9 = 0;
      int var10 = var5;
      int var11;
      int var12;
      int var13;
      if(var6 != 0) {
         var11 = class91.field1602[var6];
         var12 = class91.field1603[var6];
         var13 = var9 * var12 - var11 * var5 >> 16;
         var10 = var11 * var9 + var5 * var12 >> 16;
         var9 = var13;
      }

      if(var7 != 0) {
         var11 = class91.field1602[var7];
         var12 = class91.field1603[var7];
         var13 = var12 * var8 + var10 * var11 >> 16;
         var10 = var10 * var12 - var8 * var11 >> 16;
         var8 = var13;
      }

      class9.field155 = var0 - var8;
      class13.field205 = var1 - var9;
      class4.field81 = var2 - var10;
      class138.field2164 = var3;
      class19.field269 = var4;
   }
}
