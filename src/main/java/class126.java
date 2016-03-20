import java.applet.Applet;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("df")
public class class126 {
   @ObfuscatedName("nx")
   @ObfuscatedGetter(
      intValue = 1598234469
   )
   static int field2037;
   @ObfuscatedName("f")
   static class80 field2038;

   @ObfuscatedName("a")
   public static int method2820(int var0) {
      class47 var1 = class49.method1029(var0);
      int var2 = var1.field1063;
      int var3 = var1.field1065;
      int var4 = var1.field1066;
      int var5 = class175.field2893[var4 - var3];
      return class175.field2890[var2] >> var3 & var5;
   }

   @ObfuscatedName("z")
   static final int method2826(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IZI)Ljava/lang/String;",
      garbageValue = "1"
   )
   public static String method2827(int var0, boolean var1) {
      return var0 < 0?Integer.toString(var0):class97.method2215(var0, 10, var1);
   }

   @ObfuscatedName("r")
   public static boolean method2828() {
      class209 var0 = (class209)class210.field3125.method3893();
      return var0 != null;
   }

   @ObfuscatedName("s")
   static boolean method2829(String var0, int var1, String var2) {
      if(0 == var1) {
         try {
            if(!class137.field2123.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var12 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var13 = 0; var13 < var0.length(); ++var13) {
                  if(var12.indexOf(var0.charAt(var13)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var7) {
            return false;
         }
      } else if(1 == var1) {
         try {
            Applet var4 = class137.field2126;
            Object[] var5 = new Object[]{(new URL(class137.field2126.getCodeBase(), var0)).toString()};
            Object var3 = JSObject.getWindow(var4).call(var2, var5);
            return null != var3;
         } catch (Throwable var8) {
            return false;
         }
      } else if(2 == var1) {
         try {
            class137.field2126.getAppletContext().showDocument(new URL(class137.field2126.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var9) {
            return false;
         }
      } else if(3 == var1) {
         try {
            class131.method2854(class137.field2126, "loggedout");
         } catch (Throwable var11) {
            ;
         }

         try {
            class137.field2126.getAppletContext().showDocument(new URL(class137.field2126.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var10) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
}
