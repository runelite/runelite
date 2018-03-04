import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jh")
public enum class266 implements Enumerated {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   field3433(2, 0),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   field3434(1, 1),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   field3439(0, 2);

   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1053747249
   )
   static int field3435;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1814702347
   )
   public final int field3436;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 845569293
   )
   final int field3437;

   class266(int var3, int var4) {
      this.field3436 = var3;
      this.field3437 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "846888120"
   )
   public int rsOrdinal() {
      return this.field3437;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;B)Z",
      garbageValue = "-14"
   )
   static boolean method4851(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class57.field668.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var10 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var10.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var5) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Object var3 = class53.method787(class57.field667, var2, new Object[]{(new URL(class57.field667.getCodeBase(), var0)).toString()});
            return var3 != null;
         } catch (Throwable var6) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class57.field667.getAppletContext().showDocument(new URL(class57.field667.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var7) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class53.method786(class57.field667, "loggedout");
         } catch (Throwable var9) {
            ;
         }

         try {
            class57.field667.getAppletContext().showDocument(new URL(class57.field667.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var8) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-23"
   )
   static boolean method4849() {
      return (Client.field988 & 4) != 0;
   }
}
