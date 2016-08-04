import java.applet.Applet;
import java.awt.Component;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("eg")
public class class141 {
   @ObfuscatedName("at")
   static class149 field2187;
   @ObfuscatedName("g")
   public static String field2193 = null;
   @ObfuscatedName("l")
   public static Applet field2195 = null;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;Lclass170;Lclass170;ZII)V",
      garbageValue = "42994764"
   )
   static void method3074(Component var0, class170 var1, class170 var2, boolean var3, int var4) {
      if(class33.field754) {
         if(var4 == 4) {
            class33.field761 = 4;
         }

      } else {
         class33.field761 = var4;
         class82.method1885();
         byte[] var5 = var1.method3412("title.jpg", "");
         class33.field745 = new class81(var5, var0);
         class33.field746 = class33.field745.method1794();
         if((client.field561 & 536870912) != 0) {
            class106.field1847 = class137.method3010(var2, "logo_deadman_mode", "");
         } else {
            class106.field1847 = class137.method3010(var2, "logo", "");
         }

         class33.field760 = class137.method3010(var2, "titlebox", "");
         class33.field763 = class137.method3010(var2, "titlebutton", "");
         class33.field744 = class36.method773(var2, "runes", "");
         class33.field747 = class36.method773(var2, "title_mute", "");
         class47.field1075 = class137.method3010(var2, "options_radio_buttons,0", "");
         class22.field596 = class137.method3010(var2, "options_radio_buttons,2", "");
         class153.field2310 = new int[256];

         int var6;
         for(var6 = 0; var6 < 64; ++var6) {
            class153.field2310[var6] = var6 * 262144;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class153.field2310[var6 + 64] = 1024 * var6 + 16711680;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class153.field2310[var6 + 128] = 16776960 + 4 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class153.field2310[var6 + 192] = 16777215;
         }

         class18.field269 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class18.field269[var6] = var6 * 1024;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class18.field269[var6 + 64] = var6 * 4 + '\uff00';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class18.field269[var6 + 128] = 262144 * var6 + '\uffff';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class18.field269[var6 + 192] = 16777215;
         }

         class33.field750 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class33.field750[var6] = 4 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class33.field750[64 + var6] = var6 * 262144 + 255;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class33.field750[128 + var6] = var6 * 1024 + 16711935;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class33.field750[var6 + 192] = 16777215;
         }

         class138.field2141 = new int[256];
         class26.field649 = new int['耀'];
         class144.field2226 = new int['耀'];
         class47.method998((class83)null);
         class29.field699 = new int['耀'];
         class182.field2970 = new int['耀'];
         if(var3) {
            class33.field764 = "";
            class33.field765 = "";
         }

         class174.field2788 = 0;
         class33.field767 = "";
         class33.field768 = true;
         class33.field772 = false;
         if(!class136.field2123.field148) {
            class171 var9 = class188.field3051;
            int var7 = var9.method3410("scape main");
            int var8 = var9.method3459(var7, "");
            class167.method3374(2, var9, var7, var8, 255, false);
         } else {
            class34.method755(2);
         }

         class161.method3314(false);
         class33.field754 = true;
         class33.field741 = (class189.field3056 - client.field508) / 2;
         class33.field777 = 202 + class33.field741;
         class33.field745.method1851(class33.field741, 0);
         class33.field746.method1851(382 + class33.field741, 0);
         class106.field1847.method1954(class33.field741 + 382 - class106.field1847.field1498 / 2, 18);
      }
   }

   @ObfuscatedName("ds")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-1"
   )
   static void method3076(String var0) {
      class48.field1097 = var0;

      try {
         String var1 = client.field477.getParameter(class193.field3110.field3123);
         String var2 = client.field477.getParameter(class193.field3121.field3123);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            var3 = var3 + "; Expires=" + class38.method791(class56.method1249() + 94608000000L) + "; Max-Age=" + 94608000L;
         }

         client var4 = client.field477;
         String var5 = "document.cookie=\"" + var3 + "\"";
         JSObject.getWindow(var4).eval(var5);
      } catch (Throwable var6) {
         ;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "2114705390"
   )
   static long method3077() {
      try {
         URL var0 = new URL(class138.method3023("services", false) + "m=accountappeal/login.ws");
         URLConnection var1 = var0.openConnection();
         var1.setRequestProperty("connection", "close");
         var1.setDoInput(true);
         var1.setDoOutput(true);
         var1.setConnectTimeout(5000);
         OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
         var2.write("data1=req");
         var2.flush();
         InputStream var3 = var1.getInputStream();
         class122 var4 = new class122(new byte[1000]);

         do {
            int var5 = var3.read(var4.field2051, var4.field2050, 1000 - var4.field2050);
            if(var5 == -1) {
               var4.field2050 = 0;
               long var8 = var4.method2649();
               return var8;
            }

            var4.field2050 += var5;
         } while(var4.field2050 < 1000);

         return 0L;
      } catch (Exception var7) {
         return 0L;
      }
   }
}
