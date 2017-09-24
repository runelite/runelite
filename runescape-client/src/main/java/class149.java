import java.applet.Applet;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("en")
public class class149 {
   @ObfuscatedName("fc")
   @ObfuscatedGetter(
      intValue = -1840123871
   )
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("a")
   volatile byte[] field2200;
   @ObfuscatedName("j")
   volatile boolean field2199;
   @ObfuscatedName("i")
   final URL field2202;

   class149(URL var1) {
      this.field2202 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1646611474"
   )
   public boolean method2963() {
      return this.field2199;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-2013606950"
   )
   public byte[] method2959() {
      return this.field2200;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;B)Z",
      garbageValue = "4"
   )
   static boolean method2969(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class56.field692.startsWith("win")) {
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
            Applet var7 = class56.field697;
            Object[] var5 = new Object[]{(new URL(class56.field697.getCodeBase(), var0)).toString()};
            Object var3 = JSObject.getWindow(var7).call(var2, var5);
            return var3 != null;
         } catch (Throwable var9) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class56.field697.getAppletContext().showDocument(new URL(class56.field697.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var10) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class52.method819(class56.field697, "loggedout");
         } catch (Throwable var12) {
            ;
         }

         try {
            class56.field697.getAppletContext().showDocument(new URL(class56.field697.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var11) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
}
