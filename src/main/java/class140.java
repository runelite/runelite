import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
public class class140 extends class132 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 253549775
   )
   int field2154 = 256;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1187846587
   )
   int field2155 = 1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = 1507877113084682873L
   )
   long field2156 = class18.method214();
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -432162291
   )
   int field2157 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -29179859
   )
   int field2158;
   @ObfuscatedName("qs")
   @ObfuscatedGetter(
      intValue = -597526429
   )
   protected static int field2160;
   @ObfuscatedName("p")
   public static String field2161;
   @ObfuscatedName("a")
   long[] field2162 = new long[10];

   @ObfuscatedName("r")
   void vmethod3128() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2162[var1] = 0L;
      }

   }

   @ObfuscatedName("f")
   int vmethod3122(int var1, int var2) {
      int var3 = this.field2154;
      int var4 = this.field2155;
      this.field2154 = 300;
      this.field2155 = 1;
      this.field2156 = class18.method214();
      if(this.field2162[this.field2158] == 0L) {
         this.field2154 = var3;
         this.field2155 = var4;
      } else if(this.field2156 > this.field2162[this.field2158]) {
         this.field2154 = (int)((long)(2560 * var1) / (this.field2156 - this.field2162[this.field2158]));
      }

      if(this.field2154 < 25) {
         this.field2154 = 25;
      }

      if(this.field2154 > 256) {
         this.field2154 = 256;
         this.field2155 = (int)((long)var1 - (this.field2156 - this.field2162[this.field2158]) / 10L);
      }

      if(this.field2155 > var1) {
         this.field2155 = var1;
      }

      this.field2162[this.field2158] = this.field2156;
      this.field2158 = (this.field2158 + 1) % 10;
      int var5;
      if(this.field2155 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field2162[var5]) {
               this.field2162[var5] += (long)this.field2155;
            }
         }
      }

      if(this.field2155 < var2) {
         this.field2155 = var2;
      }

      class103.method2301((long)this.field2155);

      for(var5 = 0; this.field2157 < 256; this.field2157 += this.field2154) {
         ++var5;
      }

      this.field2157 &= 255;
      return var5;
   }

   @ObfuscatedName("a")
   public static void method2987(class166 var0) {
      class49.field1091 = var0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;Lclass166;Lclass166;ZII)V",
      garbageValue = "-1367678815"
   )
   static void method2988(Component var0, class166 var1, class166 var2, boolean var3, int var4) {
      if(class31.field745) {
         if(4 == var4) {
            class31.field733 = 4;
         }

      } else {
         class31.field733 = var4;
         class79.method1870();
         byte[] var5 = var1.method3280("title.jpg", "");
         class31.field717 = new class78(var5, var0);
         class31.field718 = class31.field717.method1728();
         if((client.field506 & 536870912) != 0) {
            class10.field159 = class48.method1017(var2, "logo_deadman_mode", "");
         } else {
            class10.field159 = class48.method1017(var2, "logo", "");
         }

         class126.field2038 = class48.method1017(var2, "titlebox", "");
         class208.field3112 = class48.method1017(var2, "titlebutton", "");
         class212.field3138 = class30.method664(var2, "runes", "");
         class52.field1160 = class30.method664(var2, "title_mute", "");
         class77.field1393 = class48.method1017(var2, "options_radio_buttons,0", "");
         class31.field719 = class48.method1017(var2, "options_radio_buttons,2", "");
         class17.field256 = new int[256];

         int var6;
         for(var6 = 0; var6 < 64; ++var6) {
            class17.field256[var6] = 262144 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class17.field256[var6 + 64] = var6 * 1024 + 16711680;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class17.field256[var6 + 128] = 16776960 + var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class17.field256[192 + var6] = 16777215;
         }

         class31.field724 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class31.field724[var6] = var6 * 1024;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class31.field724[var6 + 64] = 4 * var6 + '\uff00';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class31.field724[var6 + 128] = 262144 * var6 + '\uffff';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class31.field724[192 + var6] = 16777215;
         }

         class12.field172 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class12.field172[var6] = 4 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class12.field172[var6 + 64] = var6 * 262144 + 255;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class12.field172[128 + var6] = 16711935 + 1024 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class12.field172[var6 + 192] = 16777215;
         }

         class31.field723 = new int[256];
         class21.field590 = new int['耀'];
         class149.field2229 = new int['耀'];
         class185.method3766((class80)null);
         class76.field1384 = new int['耀'];
         class33.field775 = new int['耀'];
         if(var3) {
            class31.field742 = "";
            class31.field726 = "";
         }

         class177.field2899 = 0;
         class27.field669 = "";
         class31.field731 = true;
         class31.field741 = false;
         if(!class89.field1548.field132) {
            class22.method576(2, class129.field2054, "scape main", "", 255, false);
         } else {
            class154.method3173(2);
         }

         class1.method16(false);
         class31.field745 = true;
         class31.field716 = (class6.field107 - client.field417 * 765) / 2;
         class31.field721 = 202 + class31.field716;
         class31.field717.method1743(class31.field716, 0);
         class31.field718.method1743(382 + class31.field716, 0);
         class10.field159.method1883(class31.field716 + 382 - class10.field159.field1418 / 2, 18);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass143;I)V",
      garbageValue = "1896862044"
   )
   static void method2990() {
      if(class139.field2145 == 1 || !class214.field3149 && 4 == class139.field2145) {
         int var0 = class31.field716 + 280;
         if(class139.field2146 >= var0 && class139.field2146 <= 14 + var0 && class139.field2147 >= 4 && class139.field2147 <= 18) {
            class15.method190(0, 0);
            return;
         }

         if(class139.field2146 >= 15 + var0 && class139.field2146 <= var0 + 80 && class139.field2147 >= 4 && class139.field2147 <= 18) {
            class15.method190(0, 1);
            return;
         }

         int var1 = 390 + class31.field716;
         if(class139.field2146 >= var1 && class139.field2146 <= 14 + var1 && class139.field2147 >= 4 && class139.field2147 <= 18) {
            class15.method190(1, 0);
            return;
         }

         if(class139.field2146 >= 15 + var1 && class139.field2146 <= 80 + var1 && class139.field2147 >= 4 && class139.field2147 <= 18) {
            class15.method190(1, 1);
            return;
         }

         int var2 = 500 + class31.field716;
         if(class139.field2146 >= var2 && class139.field2146 <= var2 + 14 && class139.field2147 >= 4 && class139.field2147 <= 18) {
            class15.method190(2, 0);
            return;
         }

         if(class139.field2146 >= var2 + 15 && class139.field2146 <= var2 + 80 && class139.field2147 >= 4 && class139.field2147 <= 18) {
            class15.method190(2, 1);
            return;
         }

         int var3 = class31.field716 + 610;
         if(class139.field2146 >= var3 && class139.field2146 <= var3 + 14 && class139.field2147 >= 4 && class139.field2147 <= 18) {
            class15.method190(3, 0);
            return;
         }

         if(class139.field2146 >= var3 + 15 && class139.field2146 <= 80 + var3 && class139.field2147 >= 4 && class139.field2147 <= 18) {
            class15.method190(3, 1);
            return;
         }

         if(class139.field2146 >= 708 + class31.field716 && class139.field2147 >= 4 && class139.field2146 <= 50 + class31.field716 + 708 && class139.field2147 <= 20) {
            class31.field741 = false;
            class31.field717.method1743(class31.field716, 0);
            class31.field718.method1743(382 + class31.field716, 0);
            class10.field159.method1883(class31.field716 + 382 - class10.field159.field1418 / 2, 18);
            return;
         }

         if(-1 != class31.field747) {
            class25 var4 = class25.field633[class31.field747];
            class18.method211(var4);
            class31.field741 = false;
            class31.field717.method1743(class31.field716, 0);
            class31.field718.method1743(class31.field716 + 382, 0);
            class10.field159.method1883(class31.field716 + 382 - class10.field159.field1418 / 2, 18);
            return;
         }
      }

   }

   class140() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2162[var1] = this.field2156;
      }

   }
}
