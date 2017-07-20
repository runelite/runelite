import java.applet.Applet;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("eu")
public enum class149 implements RSEnum {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Leu;"
   )
   field2157(3, 0),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Leu;"
   )
   field2158(1, 1),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Leu;"
   )
   field2161(0, 2),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Leu;"
   )
   field2160(2, 3);

   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1850388851
   )
   public final int field2159;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1695682079
   )
   final int field2162;

   class149(int var3, int var4) {
      this.field2159 = var3;
      this.field2162 = var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1443879177"
   )
   public int rsOrdinal() {
      return this.field2162;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "-291542696"
   )
   static boolean method2837(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class56.field675.startsWith("win")) {
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
            Applet var7 = class56.field674;
            Object[] var5 = new Object[]{(new URL(class56.field674.getCodeBase(), var0)).toString()};
            Object var13 = JSObject.getWindow(var7).call(var2, var5);
            return var13 != null;
         } catch (Throwable var9) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class56.field674.getAppletContext().showDocument(new URL(class56.field674.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var10) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            Applet var3 = class56.field674;
            JSObject.getWindow(var3).call("loggedout", (Object[])null);
         } catch (Throwable var12) {
            ;
         }

         try {
            class56.field674.getAppletContext().showDocument(new URL(class56.field674.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var11) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
}
