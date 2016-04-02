import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
public final class class110 {
   @ObfuscatedName("ay")
   int[][] field1893 = new int[6][258];
   @ObfuscatedName("ag")
   int[][] field1894 = new int[6][258];
   @ObfuscatedName("ar")
   byte[] field1895 = new byte[18002];
   @ObfuscatedName("s")
   final int field1896 = 6;
   @ObfuscatedName("p")
   final int field1897 = 50;
   @ObfuscatedName("h")
   final int field1898 = 18002;
   @ObfuscatedName("g")
   byte[] field1899;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1219094951
   )
   int field1900 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -388280755
   )
   int field1901;
   @ObfuscatedName("k")
   byte[] field1902;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -589175129
   )
   int field1903;
   @ObfuscatedName("f")
   final int field1904 = 258;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -865820891
   )
   int field1905;
   @ObfuscatedName("i")
   byte field1906;
   @ObfuscatedName("w")
   final int field1907 = 16;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 708726069
   )
   int field1908;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1968787421
   )
   int field1909;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 10385795
   )
   int field1910;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 435990843
   )
   int field1911;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2046407253
   )
   int field1912;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 835617231
   )
   int field1913;
   @ObfuscatedName("u")
   int[] field1914 = new int[256];
   @ObfuscatedName("d")
   int[] field1916 = new int[257];
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1168064629
   )
   int field1917;
   @ObfuscatedName("aq")
   boolean[] field1918 = new boolean[256];
   @ObfuscatedName("ap")
   boolean[] field1919 = new boolean[16];
   @ObfuscatedName("ai")
   byte[] field1920 = new byte[256];
   @ObfuscatedName("ae")
   byte[] field1921 = new byte[4096];
   @ObfuscatedName("az")
   int[] field1922 = new int[16];
   @ObfuscatedName("ah")
   byte[] field1923 = new byte[18002];
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2002589907
   )
   int field1924;
   @ObfuscatedName("ab")
   byte[][] field1925 = new byte[6][258];
   @ObfuscatedName("aj")
   int[][] field1926 = new int[6][258];
   @ObfuscatedName("e")
   final int field1927 = 4096;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1241859183
   )
   int field1928;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2042322087
   )
   int field1930 = 0;
   @ObfuscatedName("ny")
   @ObfuscatedGetter(
      intValue = -850144929
   )
   static int field1931;
   @ObfuscatedName("av")
   int[] field1933 = new int[6];
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 87467287
   )
   int field1935;

   @ObfuscatedName("w")
   static void method2445(Component var0, class167 var1, class167 var2, boolean var3, int var4) {
      if(class163.field2650) {
         if(var4 == 4) {
            class31.field702 = 4;
         }

      } else {
         class31.field702 = var4;
         class79.method1807();
         byte[] var5 = var1.method3305("title.jpg", "");
         class31.field720 = new class78(var5, var0);
         class13.field199 = class31.field720.method1700();
         if(0 != (client.field280 & 536870912)) {
            class31.field704 = class16.method178(var2, "logo_deadman_mode", "");
         } else {
            class31.field704 = class16.method178(var2, "logo", "");
         }

         class31.field694 = class16.method178(var2, "titlebox", "");
         class189.field3044 = class16.method178(var2, "titlebutton", "");
         class31.field695 = class133.method2848(var2, "runes", "");
         class18.field260 = class133.method2848(var2, "title_mute", "");
         class31.field705 = class16.method178(var2, "options_radio_buttons,0", "");
         class34.field757 = class16.method178(var2, "options_radio_buttons,2", "");
         class27.field655 = new int[256];

         int var6;
         for(var6 = 0; var6 < 64; ++var6) {
            class27.field655[var6] = 262144 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class27.field655[64 + var6] = var6 * 1024 + 16711680;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class27.field655[var6 + 128] = var6 * 4 + 16776960;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class27.field655[192 + var6] = 16777215;
         }

         class14.field212 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class14.field212[var6] = var6 * 1024;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class14.field212[64 + var6] = var6 * 4 + '\uff00';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class14.field212[var6 + 128] = '\uffff' + 262144 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class14.field212[192 + var6] = 16777215;
         }

         class143.field2187 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class143.field2187[var6] = var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class143.field2187[64 + var6] = var6 * 262144 + 255;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class143.field2187[var6 + 128] = 16711935 + 1024 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class143.field2187[192 + var6] = 16777215;
         }

         class48.field1061 = new int[256];
         class27.field656 = new int['耀'];
         class115.field1957 = new int['耀'];
         class43.method917((class80)null);
         class77.field1369 = new int['耀'];
         class47.field1047 = new int['耀'];
         if(var3) {
            class31.field703 = "";
            class31.field715 = "";
         }

         class5.field99 = 0;
         class9.field153 = "";
         class31.field717 = true;
         class31.field721 = false;
         if(!class39.field865.field145) {
            class167.method3321(2, class24.field611, "scape main", "", 255, false);
         } else {
            class4.method44(2);
         }

         class22.method585(false);
         class163.field2650 = true;
         class31.field696 = (class35.field762 - client.field493) / 2;
         class31.field699 = 202 + class31.field696;
         class31.field720.method1741(class31.field696, 0);
         class13.field199.method1741(382 + class31.field696, 0);
         class31.field704.method1880(class31.field696 + 382 - class31.field704.field1390 / 2, 18);
      }
   }

   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "(Lclass3;ZB)V",
      garbageValue = "19"
   )
   static final void method2446(class3 var0, boolean var1) {
      int var2 = var0.field69;
      int var3 = (int)var0.field3115;
      var0.method3913();
      int var5;
      if(var1 && -1 != var2 && class173.field2745[var2]) {
         class173.field2746.method3267(var2);
         if(class173.field2837[var2] != null) {
            boolean var4 = true;

            for(var5 = 0; var5 < class173.field2837[var2].length; ++var5) {
               if(class173.field2837[var2][var5] != null) {
                  if(class173.field2837[var2][var5].field2757 != 2) {
                     class173.field2837[var2][var5] = null;
                  } else {
                     var4 = false;
                  }
               }
            }

            if(var4) {
               class173.field2837[var2] = null;
            }

            class173.field2745[var2] = false;
         }
      }

      class87.method2093(var2);
      class173 var7 = class148.method3129(var3);
      if(var7 != null) {
         class9.method133(var7);
      }

      for(var5 = 0; var5 < client.field420; ++var5) {
         if(class3.method41(client.field301[var5])) {
            if(var5 < client.field420 - 1) {
               for(int var6 = var5; var6 < client.field420 - 1; ++var6) {
                  client.field425[var6] = client.field425[var6 + 1];
                  client.field426[var6] = client.field426[1 + var6];
                  client.field301[var6] = client.field301[1 + var6];
                  client.field391[var6] = client.field391[var6 + 1];
                  client.field494[var6] = client.field494[var6 + 1];
                  client.field422[var6] = client.field422[var6 + 1];
               }
            }

            --client.field420;
         }
      }

      if(client.field438 != -1) {
         class9.method134(client.field438, 1);
      }

   }
}
