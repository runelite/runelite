import java.applet.Applet;
import java.io.File;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("cr")
public class class92 {
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -788588935
   )
   static int field1415;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1451660505
   )
   static int field1416;
   @ObfuscatedName("u")
   static ModIcon field1417;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 779546423
   )
   static int field1418;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -578651247
   )
   static int field1419;
   @ObfuscatedName("a")
   static ModIcon field1420;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1988337167
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("d")
   static int[] field1423;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -880909845
   )
   static int field1424;
   @ObfuscatedName("q")
   static ModIcon field1425;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 855155367
   )
   static int field1426;
   @ObfuscatedName("i")
   static boolean field1427;
   @ObfuscatedName("av")
   static String field1428;
   @ObfuscatedName("v")
   static SpritePixels field1429;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 438323633
   )
   static int field1430;
   @ObfuscatedName("ax")
   static String field1431;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 999823653
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("ae")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("ar")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("ao")
   static class149 field1436;
   @ObfuscatedName("at")
   @Export(
      value = "username",
      setter = true
   )
   static String username;
   @ObfuscatedName("ai")
   @Export("password")
   static String password;
   @ObfuscatedName("ag")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("as")
   static boolean field1440;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 493469167
   )
   @Export("loginIndex2")
   static int loginIndex2;
   @ObfuscatedName("an")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 829090433
   )
   static int field1445;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -2011124489
   )
   static int field1446;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;B)V",
      garbageValue = "16"
   )
   static void method1778(File var0) {
      class157.field2234 = var0;
      if(!class157.field2234.exists()) {
         throw new RuntimeException("");
      } else {
         class157.field2236 = true;
      }
   }

   static {
      field1416 = 0;
      loginWindowX = field1416 + 202;
      field1423 = new int[256];
      field1424 = 0;
      field1419 = 0;
      field1426 = 0;
      field1418 = 0;
      field1445 = 0;
      field1415 = 0;
      field1430 = 10;
      field1431 = "";
      loginIndex = 0;
      field1428 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      password = "";
      field1436 = class149.field2179;
      field1440 = true;
      loginIndex2 = 0;
      worldSelectShown = false;
      field1446 = -1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "1455036628"
   )
   static boolean method1779(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class56.field673.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var14 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var14.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var8) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Applet var7 = class56.field678;
            Object[] var5 = new Object[]{(new URL(class56.field678.getCodeBase(), var0)).toString()};
            Object var13 = JSObject.getWindow(var7).call(var2, var5);
            return var13 != null;
         } catch (Throwable var9) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class56.field678.getAppletContext().showDocument(new URL(class56.field678.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var10) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            Applet var3 = class56.field678;
            JSObject.getWindow(var3).call("loggedout", (Object[])null);
         } catch (Throwable var12) {
            ;
         }

         try {
            class56.field678.getAppletContext().showDocument(new URL(class56.field678.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var11) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1216381213"
   )
   static final void method1780() {
      Client.field1014 = 0;
      int var0 = class166.baseX + (XGrandExchangeOffer.localPlayer.x >> 7);
      int var1 = class146.baseY + (XGrandExchangeOffer.localPlayer.y >> 7);
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         Client.field1014 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         Client.field1014 = 1;
      }

      if(Client.field1014 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         Client.field1014 = 0;
      }

   }
}
