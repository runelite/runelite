import java.applet.Applet;
import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("av")
public class class40 {
   @ObfuscatedName("e")
   public static final class40 field539;
   @ObfuscatedName("i")
   public static final class40 field540;
   @ObfuscatedName("b")
   public static final class40 field541;
   @ObfuscatedName("y")
   public final String field542;
   @ObfuscatedName("rv")
   static short[] field543;
   @ObfuscatedName("v")
   public static final class40 field544;
   @ObfuscatedName("c")
   public static final class40 field545;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "-318463255"
   )
   public static boolean method534(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class56.field690.startsWith("win")) {
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
            Applet var7 = class56.field694;
            Object[] var5 = new Object[]{(new URL(class56.field694.getCodeBase(), var0)).toString()};
            Object var3 = JSObject.getWindow(var7).call(var2, var5);
            return var3 != null;
         } catch (Throwable var9) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class56.field694.getAppletContext().showDocument(new URL(class56.field694.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var10) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class52.method763(class56.field694, "loggedout");
         } catch (Throwable var12) {
            ;
         }

         try {
            class56.field694.getAppletContext().showDocument(new URL(class56.field694.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var11) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   static {
      field540 = new class40("details");
      field545 = new class40("compositemap");
      field539 = new class40("compositetexture");
      field544 = new class40("area");
      field541 = new class40("labels");
   }

   class40(String var1) {
      this.field542 = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIII)I",
      garbageValue = "-1917443302"
   )
   static final int method535(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - class136.COSINE[var2 * 1024 / var3] >> 1;
      return (var4 * var1 >> 16) + (var0 * (65536 - var4) >> 16);
   }
}
