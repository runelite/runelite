import java.awt.Component;
import java.io.File;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class41 extends class204 {
   @ObfuscatedName("u")
   public static class193 field987 = new class193(64);
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 430097485
   )
   int field988 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -562650573
   )
   public int field989;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -242223357
   )
   public int field991;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -232885777
   )
   public int field992;
   @ObfuscatedName("f")
   public static class167 field993;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1792397087
   )
   public int field994;
   @ObfuscatedName("qd")
   @ObfuscatedGetter(
      intValue = -967700407
   )
   protected static int field995;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2067215861"
   )
   public void method878() {
      this.method897(this.field988);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "-350132048"
   )
   public void method879(class119 var1, int var2) {
      while(true) {
         int var3 = var1.method2554();
         if(var3 == 0) {
            return;
         }

         this.method889(var1, var3, var2);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;Lclass167;Lclass167;ZII)V",
      garbageValue = "256251415"
   )
   static void method886(Component var0, class167 var1, class167 var2, boolean var3, int var4) {
      if(class31.field732) {
         if(var4 == 4) {
            class31.field724 = 4;
         }

      } else {
         class31.field724 = var4;
         class79.method1852();
         byte[] var5 = var1.method3302("title.jpg", "");
         class31.field717 = new class78(var5, var0);
         class172.field2738 = class31.field717.method1751();
         if((client.field291 & 536870912) != 0) {
            class159.field2605 = class150.method3164(var2, "logo_deadman_mode", "");
         } else {
            class159.field2605 = class150.method3164(var2, "logo", "");
         }

         class31.field713 = class150.method3164(var2, "titlebox", "");
         class31.field716 = class150.method3164(var2, "titlebutton", "");
         class28.field684 = client.method595(var2, "runes", "");
         class176.field2906 = client.method595(var2, "title_mute", "");
         class31.field718 = class150.method3164(var2, "options_radio_buttons,0", "");
         class31.field719 = class150.method3164(var2, "options_radio_buttons,2", "");
         class151.field2253 = new int[256];

         int var9;
         for(var9 = 0; var9 < 64; ++var9) {
            class151.field2253[var9] = var9 * 262144;
         }

         for(var9 = 0; var9 < 64; ++var9) {
            class151.field2253[var9 + 64] = var9 * 1024 + 16711680;
         }

         for(var9 = 0; var9 < 64; ++var9) {
            class151.field2253[var9 + 128] = 4 * var9 + 16776960;
         }

         for(var9 = 0; var9 < 64; ++var9) {
            class151.field2253[var9 + 192] = 16777215;
         }

         class25.field644 = new int[256];

         for(var9 = 0; var9 < 64; ++var9) {
            class25.field644[var9] = 1024 * var9;
         }

         for(var9 = 0; var9 < 64; ++var9) {
            class25.field644[64 + var9] = var9 * 4 + '\uff00';
         }

         for(var9 = 0; var9 < 64; ++var9) {
            class25.field644[var9 + 128] = '\uffff' + var9 * 262144;
         }

         for(var9 = 0; var9 < 64; ++var9) {
            class25.field644[var9 + 192] = 16777215;
         }

         class10.field174 = new int[256];

         for(var9 = 0; var9 < 64; ++var9) {
            class10.field174[var9] = var9 * 4;
         }

         for(var9 = 0; var9 < 64; ++var9) {
            class10.field174[var9 + 64] = 255 + var9 * 262144;
         }

         for(var9 = 0; var9 < 64; ++var9) {
            class10.field174[128 + var9] = var9 * 1024 + 16711935;
         }

         for(var9 = 0; var9 < 64; ++var9) {
            class10.field174[var9 + 192] = 16777215;
         }

         class84.field1463 = new int[256];
         class114.field1974 = new int['耀'];
         class130.field2064 = new int['耀'];
         class25.method666((class80)null);
         class18.field270 = new int['耀'];
         class25.field642 = new int['耀'];
         if(var3) {
            class31.field729 = "";
            class31.field736 = "";
         }

         class107.field1880 = 0;
         class104.field1797 = "";
         class31.field738 = true;
         class31.field722 = false;
         if(!class20.field580.field141) {
            class168 var6 = class17.field261;
            int var7 = var6.method3300("scape main");
            int var8 = var6.method3301(var7, "");
            class183.field2953 = 1;
            class20.field582 = var6;
            class21.field589 = var7;
            class213.field3145 = var8;
            class183.field2956 = 255;
            class20.field583 = false;
            class183.field2957 = 2;
         } else {
            class1.method6(2);
         }

         class163.method3250(false);
         class31.field732 = true;
         class31.field725 = (class30.field708 - client.field502) / 2;
         class31.field731 = 202 + class31.field725;
         class31.field717.method1761(class31.field725, 0);
         class172.field2738.method1761(382 + class31.field725, 0);
         class159.field2605.method1916(382 + class31.field725 - class159.field2605.field1428 / 2, 18);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass119;IIB)V",
      garbageValue = "37"
   )
   void method889(class119 var1, int var2, int var3) {
      if(var2 == 1) {
         this.field988 = var1.method2558();
      }

   }

   @ObfuscatedName("u")
   public static String method894(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); 0L != var0; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class162.field2646[(int)(var6 - var0 * 37L)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "302161210"
   )
   public static boolean method895(char var0) {
      return var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZB)Lclass227;",
      garbageValue = "108"
   )
   public static class227 method896(String var0, String var1, boolean var2) {
      File var3 = new File(class27.field674, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            class227 var10 = new class227(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class98.field1674 == 33) {
         var4 = "_rc";
      } else if(class98.field1674 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class149.field2239, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      class227 var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new class227(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new class227(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-74"
   )
   void method897(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var8 + var10) / 2.0D;
      if(var8 != var10) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var8 + var10);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var10 == var6) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.field991 = (int)(256.0D * var14);
      this.field994 = (int)(256.0D * var16);
      if(this.field991 < 0) {
         this.field991 = 0;
      } else if(this.field991 > 255) {
         this.field991 = 255;
      }

      if(this.field994 < 0) {
         this.field994 = 0;
      } else if(this.field994 > 255) {
         this.field994 = 255;
      }

      if(var16 > 0.5D) {
         this.field992 = (int)(var14 * (1.0D - var16) * 512.0D);
      } else {
         this.field992 = (int)(512.0D * var16 * var14);
      }

      if(this.field992 < 1) {
         this.field992 = 1;
      }

      this.field989 = (int)(var12 * (double)this.field992);
   }
}
