import java.awt.Component;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
public class class155 {
   @ObfuscatedName("jv")
   static class173[] field2289;
   @ObfuscatedName("d")
   public static int[] field2290 = new int[99];
   @ObfuscatedName("w")
   public static final boolean[] field2291 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};

   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "(Lclass173;B)Z",
      garbageValue = "-45"
   )
   static final boolean method3261(class173 var0) {
      int var1 = var0.field2762;
      if(205 == var1) {
         client.field401 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            client.field567.method3584(var2, 1 == var3);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            client.field567.method3561(var2, 1 == var3);
         }

         if(var1 == 324) {
            client.field567.method3569(false);
         }

         if(325 == var1) {
            client.field567.method3569(true);
         }

         if(var1 == 326) {
            client.field338.method2873(35);
            client.field567.method3563(client.field338);
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-84"
   )
   static final String method3262(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class139.method3046('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class139.method3046(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class139.method3046(16776960) + var1 + "</col>");
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;Lclass167;Lclass167;ZII)V",
      garbageValue = "1"
   )
   static void method3263(Component var0, class167 var1, class167 var2, boolean var3, int var4) {
      if(!class31.field736) {
         class31.field726 = var4;
         class79.method1893();
         byte[] var5 = var1.method3391("title.jpg", "");
         class31.field727 = new class78(var5, var0);
         class31.field728 = class31.field727.method1786();
         if((client.field431 & 536870912) != 0) {
            class30.field715 = class6.method133(var2, "logo_deadman_mode", "");
         } else {
            class30.field715 = class6.method133(var2, "logo", "");
         }

         class31.field747 = class6.method133(var2, "titlebox", "");
         class31.field725 = class6.method133(var2, "titlebutton", "");
         class31.field741 = class84.method1995(var2, "runes", "");
         class31.field729 = class84.method1995(var2, "title_mute", "");
         class14.field221 = class6.method133(var2, "options_radio_buttons,0", "");
         class115.field1971 = class6.method133(var2, "options_radio_buttons,2", "");
         class43.field1019 = new int[256];

         int var6;
         for(var6 = 0; var6 < 64; ++var6) {
            class43.field1019[var6] = 262144 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class43.field1019[64 + var6] = 1024 * var6 + 16711680;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class43.field1019[128 + var6] = 16776960 + var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class43.field1019[192 + var6] = 16777215;
         }

         class29.field699 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class29.field699[var6] = 1024 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class29.field699[64 + var6] = var6 * 4 + '\uff00';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class29.field699[var6 + 128] = 262144 * var6 + '\uffff';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class29.field699[var6 + 192] = 16777215;
         }

         class31.field732 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class31.field732[var6] = 4 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class31.field732[64 + var6] = var6 * 262144 + 255;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class31.field732[128 + var6] = var6 * 1024 + 16711935;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class31.field732[var6 + 192] = 16777215;
         }

         class34.field786 = new int[256];
         class110.field1947 = new int['耀'];
         class52.field1168 = new int['耀'];
         class31.method773((class80)null);
         class26.field676 = new int['耀'];
         class15.field233 = new int['耀'];
         class31.field749 = "";
         class31.field740 = "";
         class154.field2287 = 0;
         class25.field653 = "";
         class31.field735 = true;
         class31.field748 = false;
         if(!class134.field2078.field154) {
            class20.method642(2, class38.field884, "scape main", "", 255, false);
         } else {
            class170.method3462(2);
         }

         class38.method854(false);
         class31.field736 = true;
         class31.field723 = (class37.field876 - client.field438) / 2;
         class31.field730 = 202 + class31.field723;
         class31.field727.method1796(class31.field723, 0);
         class31.field728.method1796(class31.field723 + 382, 0);
         class30.field715.method1962(382 + class31.field723 - class30.field715.field1419 / 2, 18);
      }
   }

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = 1 + var1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2290[var1] = var0 / 4;
      }

   }
}
