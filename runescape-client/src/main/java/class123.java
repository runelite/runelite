import java.awt.Component;
import java.awt.FontMetrics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
public final class class123 {
   @ObfuscatedName("d")
   int[] field2030 = new int[256];
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1331999077
   )
   int field2031;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -134903273
   )
   int field2032;
   @ObfuscatedName("u")
   int[] field2034 = new int[256];
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 865683629
   )
   int field2035;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -663563353
   )
   int field2037;
   @ObfuscatedName("bf")
   protected static FontMetrics field2039;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-348723493"
   )
   public static void method2760() {
      class137 var0 = class137.field2119;
      class137 var1 = class137.field2119;
      synchronized(class137.field2119) {
         ++class137.field2144;
         class137.field2141 = class137.field2143;
         class137.field2140 = 0;
         int var2;
         if(class137.field2136 < 0) {
            for(var2 = 0; var2 < 112; ++var2) {
               class137.field2120[var2] = false;
            }

            class137.field2136 = class137.field2118;
         } else {
            while(class137.field2118 != class137.field2136) {
               var2 = class137.field2134[class137.field2118];
               class137.field2118 = 1 + class137.field2118 & 127;
               if(var2 < 0) {
                  class137.field2120[~var2] = false;
               } else {
                  if(!class137.field2120[var2] && class137.field2140 < class137.field2139.length - 1) {
                     class137.field2139[++class137.field2140 - 1] = var2;
                  }

                  class137.field2120[var2] = true;
               }
            }
         }

         class137.field2143 = class137.field2142;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-2099"
   )
   final void method2761() {
      this.field2031 += ++this.field2037;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.field2034[var1];
         if((var1 & 2) == 0) {
            if(0 == (var1 & 1)) {
               this.field2035 ^= this.field2035 << 13;
            } else {
               this.field2035 ^= this.field2035 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2035 ^= this.field2035 << 2;
         } else {
            this.field2035 ^= this.field2035 >>> 16;
         }

         this.field2035 += this.field2034[var1 + 128 & 255];
         int var3;
         this.field2034[var1] = var3 = this.field2034[(var2 & 1020) >> 2] + this.field2035 + this.field2031;
         this.field2030[var1] = this.field2031 = this.field2034[(var3 >> 8 & 1020) >> 2] + var2;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-102"
   )
   final void method2762() {
      int var1 = -1640531527;
      int var2 = -1640531527;
      int var3 = -1640531527;
      int var4 = -1640531527;
      int var5 = -1640531527;
      int var6 = -1640531527;
      int var7 = -1640531527;
      int var8 = -1640531527;

      int var9;
      for(var9 = 0; var9 < 4; ++var9) {
         var8 ^= var7 << 11;
         var5 += var8;
         var7 += var6;
         var7 ^= var6 >>> 2;
         var4 += var7;
         var6 += var5;
         var6 ^= var5 << 8;
         var3 += var6;
         var5 += var4;
         var5 ^= var4 >>> 16;
         var2 += var5;
         var4 += var3;
         var4 ^= var3 << 10;
         var1 += var4;
         var3 += var2;
         var3 ^= var2 >>> 4;
         var8 += var3;
         var2 += var1;
         var2 ^= var1 << 8;
         var7 += var2;
         var1 += var8;
         var1 ^= var8 >>> 9;
         var6 += var1;
         var8 += var7;
      }

      for(var9 = 0; var9 < 256; var9 += 8) {
         var8 += this.field2030[var9];
         var7 += this.field2030[1 + var9];
         var6 += this.field2030[var9 + 2];
         var5 += this.field2030[3 + var9];
         var4 += this.field2030[var9 + 4];
         var3 += this.field2030[var9 + 5];
         var2 += this.field2030[var9 + 6];
         var1 += this.field2030[var9 + 7];
         var8 ^= var7 << 11;
         var5 += var8;
         var7 += var6;
         var7 ^= var6 >>> 2;
         var4 += var7;
         var6 += var5;
         var6 ^= var5 << 8;
         var3 += var6;
         var5 += var4;
         var5 ^= var4 >>> 16;
         var2 += var5;
         var4 += var3;
         var4 ^= var3 << 10;
         var1 += var4;
         var3 += var2;
         var3 ^= var2 >>> 4;
         var8 += var3;
         var2 += var1;
         var2 ^= var1 << 8;
         var7 += var2;
         var1 += var8;
         var1 ^= var8 >>> 9;
         var6 += var1;
         var8 += var7;
         this.field2034[var9] = var8;
         this.field2034[1 + var9] = var7;
         this.field2034[var9 + 2] = var6;
         this.field2034[var9 + 3] = var5;
         this.field2034[4 + var9] = var4;
         this.field2034[var9 + 5] = var3;
         this.field2034[var9 + 6] = var2;
         this.field2034[7 + var9] = var1;
      }

      for(var9 = 0; var9 < 256; var9 += 8) {
         var8 += this.field2034[var9];
         var7 += this.field2034[1 + var9];
         var6 += this.field2034[2 + var9];
         var5 += this.field2034[3 + var9];
         var4 += this.field2034[var9 + 4];
         var3 += this.field2034[5 + var9];
         var2 += this.field2034[6 + var9];
         var1 += this.field2034[var9 + 7];
         var8 ^= var7 << 11;
         var5 += var8;
         var7 += var6;
         var7 ^= var6 >>> 2;
         var4 += var7;
         var6 += var5;
         var6 ^= var5 << 8;
         var3 += var6;
         var5 += var4;
         var5 ^= var4 >>> 16;
         var2 += var5;
         var4 += var3;
         var4 ^= var3 << 10;
         var1 += var4;
         var3 += var2;
         var3 ^= var2 >>> 4;
         var8 += var3;
         var2 += var1;
         var2 ^= var1 << 8;
         var7 += var2;
         var1 += var8;
         var1 ^= var8 >>> 9;
         var6 += var1;
         var8 += var7;
         this.field2034[var9] = var8;
         this.field2034[1 + var9] = var7;
         this.field2034[var9 + 2] = var6;
         this.field2034[var9 + 3] = var5;
         this.field2034[var9 + 4] = var4;
         this.field2034[5 + var9] = var3;
         this.field2034[var9 + 6] = var2;
         this.field2034[var9 + 7] = var1;
      }

      this.method2761();
      this.field2032 = 256;
   }

   class123(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field2030[var2] = var1[var2];
      }

      this.method2762();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1755936369"
   )
   final int method2764() {
      if(0 == --this.field2032 + 1) {
         this.method2761();
         this.field2032 = 255;
      }

      return this.field2030[this.field2032];
   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "1514173650"
   )
   static final void method2770(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(class188.method3731(var0)) {
         class156.method3147(class217.field3171[var0], -1, var1, var2, var3, var4, var5, var6);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;Lclass167;Lclass167;ZII)V",
      garbageValue = "1"
   )
   static void method2776(Component var0, class167 var1, class167 var2, boolean var3, int var4) {
      if(!class31.field736) {
         class31.field732 = var4;
         class79.method1771();
         byte[] var5 = var1.method3255("title.jpg", "");
         class20.field569 = new class78(var5, var0);
         class121.field2016 = class20.field569.method1664();
         if((client.field279 & 536870912) != 0) {
            class31.field718 = class137.method2910(var2, "logo_deadman_mode", "");
         } else {
            class31.field718 = class137.method2910(var2, "logo", "");
         }

         class209.field3128 = class137.method2910(var2, "titlebox", "");
         class31.field717 = class137.method2910(var2, "titlebutton", "");
         class28.field681 = class13.method170(var2, "runes", "");
         class151.field2263 = class13.method170(var2, "title_mute", "");
         class27.field678 = class137.method2910(var2, "options_radio_buttons,0", "");
         class30.field708 = class137.method2910(var2, "options_radio_buttons,2", "");
         class1.field26 = new int[256];

         int var6;
         for(var6 = 0; var6 < 64; ++var6) {
            class1.field26[var6] = var6 * 262144;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class1.field26[64 + var6] = 16711680 + var6 * 1024;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class1.field26[128 + var6] = 16776960 + 4 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class1.field26[192 + var6] = 16777215;
         }

         class11.field169 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class11.field169[var6] = var6 * 1024;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class11.field169[var6 + 64] = '\uff00' + 4 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class11.field169[128 + var6] = var6 * 262144 + '\uffff';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class11.field169[var6 + 192] = 16777215;
         }

         class31.field741 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class31.field741[var6] = var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class31.field741[var6 + 64] = 262144 * var6 + 255;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class31.field741[var6 + 128] = var6 * 1024 + 16711935;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class31.field741[var6 + 192] = 16777215;
         }

         class31.field722 = new int[256];
         class27.field670 = new int['耀'];
         class178.field2932 = new int['耀'];
         class110.method2416((class80)null);
         class27.field665 = new int['耀'];
         class43.field1018 = new int['耀'];
         class31.field737 = "";
         class31.field740 = "";
         class87.field1540 = 0;
         class44.field1035 = "";
         class31.field739 = true;
         class31.field744 = false;
         if(!class76.field1388.field143) {
            class161.method3166(2, class102.field1776, "scape main", "", 255, false);
         } else {
            class9.method130(2);
         }

         class115.method2439(false);
         class31.field736 = true;
         class31.field748 = (class15.field214 - client.field492) / 2;
         class31.field720 = 202 + class31.field748;
         class20.field569.method1674(class31.field748, 0);
         class121.field2016.method1674(class31.field748 + 382, 0);
         class31.field718.method1841(class31.field748 + 382 - class31.field718.field1427 / 2, 18);
      }

   }
}
