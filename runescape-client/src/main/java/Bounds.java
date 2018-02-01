import java.applet.Applet;
import java.net.URL;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("kw")
@Implements("Bounds")
public class Bounds {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 499600971
   )
   public int field3833;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -661740851
   )
   public int field3834;

   Bounds(int var1, int var2, int var3, int var4) {
      this.method5373(var1, var2);
      this.method5374(var3, var4);
   }

   public Bounds(int var1, int var2) {
      this(0, 0, var1, var2);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2040893373"
   )
   void method5373(int var1, int var2) {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1963562083"
   )
   void method5374(int var1, int var2) {
      this.field3833 = var1;
      this.field3834 = var2;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;B)Z",
      garbageValue = "123"
   )
   static boolean method5379(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class56.field617.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var13 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var13.indexOf(var0.charAt(var4)) == -1) {
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
            Applet var7 = class56.field620;
            Object[] var5 = new Object[]{(new URL(class56.field620.getCodeBase(), var0)).toString()};
            Object var3 = JSObject.getWindow(var7).call(var2, var5);
            return var3 != null;
         } catch (Throwable var9) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class56.field620.getAppletContext().showDocument(new URL(class56.field620.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var10) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class52.method764(class56.field620, "loggedout");
         } catch (Throwable var12) {
            ;
         }

         try {
            class56.field620.getAppletContext().showDocument(new URL(class56.field620.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var11) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
}
