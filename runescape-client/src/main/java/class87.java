import java.applet.Applet;
import java.net.URL;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("cl")
@Implements("FaceNormal")
public class class87 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1552609547
   )
   int field1528;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2033689201
   )
   int field1529;
   @ObfuscatedName("o")
   static String[] field1530;
   @ObfuscatedName("by")
   static class171 field1531;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1286208019
   )
   int field1534;

   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "1635828661"
   )
   static final String[] method1983(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && null != var0[var2]) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }

   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "(Lclass176;I)V",
      garbageValue = "-2145107809"
   )
   static final void method1984(class176 var0) {
      int var1 = var0.field2799;
      if(var1 == 324) {
         if(client.field544 == -1) {
            client.field544 = var0.field2849;
            client.field489 = var0.field2866;
         }

         if(client.field516.field2974) {
            var0.field2849 = client.field544;
         } else {
            var0.field2849 = client.field489;
         }

      } else if(var1 == 325) {
         if(client.field544 == -1) {
            client.field544 = var0.field2849;
            client.field489 = var0.field2866;
         }

         if(client.field516.field2974) {
            var0.field2849 = client.field489;
         } else {
            var0.field2849 = client.field544;
         }

      } else if(var1 == 327) {
         var0.field2853 = 150;
         var0.field2847 = (int)(Math.sin((double)client.field282 / 40.0D) * 256.0D) & 2047;
         var0.field2786 = 5;
         var0.field2839 = 0;
      } else if(var1 == 328) {
         var0.field2853 = 150;
         var0.field2847 = (int)(Math.sin((double)client.field282 / 40.0D) * 256.0D) & 2047;
         var0.field2786 = 5;
         var0.field2839 = 1;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "1271947252"
   )
   static boolean method1985(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class141.field2194.startsWith("win")) {
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
            Applet var7 = class141.field2197;
            Object[] var5 = new Object[]{(new URL(class141.field2197.getCodeBase(), var0)).toString()};
            Object var13 = JSObject.getWindow(var7).call(var2, var5);
            return null != var13;
         } catch (Throwable var9) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class141.field2197.getAppletContext().showDocument(new URL(class141.field2197.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var10) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            Applet var3 = class141.field2197;
            JSObject.getWindow(var3).call("loggedout", (Object[])null);
         } catch (Throwable var12) {
            ;
         }

         try {
            class141.field2197.getAppletContext().showDocument(new URL(class141.field2197.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var11) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Lclass133;",
      garbageValue = "1501364833"
   )
   public static class133 method1986(int var0) {
      class133[] var1 = class118.method2511();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         class133 var3 = var1[var2];
         if(var0 == var3.field2112) {
            return var3;
         }
      }

      return null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "4"
   )
   public static boolean method1987(int var0) {
      return (var0 >> 21 & 1) != 0;
   }
}
