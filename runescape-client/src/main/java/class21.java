import java.applet.Applet;
import java.net.URL;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("y")
final class class21 implements Comparator {
   @ObfuscatedName("p")
   public static class167 field574;
   @ObfuscatedName("k")
   public static byte[][] field575;
   final boolean val$preferOwnWorld;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = 1921402259
   )
   @Export("plane")
   static int field581;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1081071174"
   )
   public static boolean method557() {
      try {
         if(class183.field2973 == 2) {
            if(null == class9.field162) {
               class9.field162 = class180.method3504(class183.field2974, class221.field3184, class151.field2268);
               if(null == class9.field162) {
                  return false;
               }
            }

            if(null == class183.field2975) {
               class183.field2975 = new class59(class90.field1571, class183.field2978);
            }

            if(class183.field2972.method3580(class9.field162, class183.field2980, class183.field2975, 22050)) {
               class183.field2972.method3630();
               class183.field2972.method3578(class183.field2971);
               class183.field2972.method3583(class9.field162, class183.field2977);
               class183.field2973 = 0;
               class9.field162 = null;
               class183.field2975 = null;
               class183.field2974 = null;
               return true;
            }
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class183.field2972.method3584();
         class183.field2973 = 0;
         class9.field162 = null;
         class183.field2975 = null;
         class183.field2974 = null;
      }

      return false;
   }

   public int compare(Object var1, Object var2) {
      return this.method559((class214)var1, (class214)var2);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass212;I)I",
      garbageValue = "1868727028"
   )
   static final int method558(class212 var0) {
      if(null == var0) {
         return 12;
      } else {
         switch(var0.field3153) {
         case 3:
            return 20;
         default:
            return 12;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;I)I",
      garbageValue = "564435332"
   )
   int method559(class214 var1, class214 var2) {
      if(var2.field3161 == var1.field3161) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(var1.field3161 == client.field551) {
               return -1;
            }

            if(var2.field3161 == client.field551) {
               return 1;
            }
         }

         return var1.field3161 < var2.field3161?-1:1;
      }
   }

   class21(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "409354090"
   )
   static boolean method566(String var0, int var1, String var2) {
      if(0 == var1) {
         try {
            if(!class138.field2147.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var11 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var12 = 0; var12 < var0.length(); ++var12) {
                  if(var11.indexOf(var0.charAt(var12)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var6) {
            return false;
         }
      } else {
         Applet var3;
         if(1 == var1) {
            try {
               var3 = class138.field2148;
               Object[] var4 = new Object[]{(new URL(class138.field2148.getCodeBase(), var0)).toString()};
               Object var5 = JSObject.getWindow(var3).call(var2, var4);
               return null != var5;
            } catch (Throwable var7) {
               return false;
            }
         } else if(var1 == 2) {
            try {
               class138.field2148.getAppletContext().showDocument(new URL(class138.field2148.getCodeBase(), var0), "_blank");
               return true;
            } catch (Exception var8) {
               return false;
            }
         } else if(3 == var1) {
            try {
               var3 = class138.field2148;
               JSObject.getWindow(var3).call("loggedout", (Object[])null);
            } catch (Throwable var10) {
               ;
            }

            try {
               class138.field2148.getAppletContext().showDocument(new URL(class138.field2148.getCodeBase(), var0), "_top");
               return true;
            } catch (Exception var9) {
               return false;
            }
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "-1455993549"
   )
   public static String method567(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(0 != var6) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class165.field2669[var6 - 128];
               if(0 == var7) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }
}
