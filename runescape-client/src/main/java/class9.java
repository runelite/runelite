import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
public abstract class class9 extends Node {
   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      signature = "[Lkp;"
   )
   static SpritePixels[] field249;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1383927671"
   )
   abstract void vmethod47();

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1659541879"
   )
   public static void method39() {
      Widget.field2643.reset();
      Widget.field2644.reset();
      Widget.field2645.reset();
      Widget.field2646.reset();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "1133000510"
   )
   static boolean method43(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class56.field686.startsWith("win")) {
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
            Object var3 = class52.method815(class56.field678, var2, new Object[]{(new URL(class56.field678.getCodeBase(), var0)).toString()});
            return var3 != null;
         } catch (Throwable var6) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class56.field678.getAppletContext().showDocument(new URL(class56.field678.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var7) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class52.method814(class56.field678, "loggedout");
         } catch (Throwable var9) {
            ;
         }

         try {
            class56.field678.getAppletContext().showDocument(new URL(class56.field678.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var8) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "(Ljf;IIII)V",
      garbageValue = "1020031902"
   )
   static void method44(Sequence var0, int var1, int var2, int var3) {
      if(Client.field1166 < 50 && Client.field1148 != 0) {
         if(var0.field3602 != null && var1 < var0.field3602.length) {
            int var4 = var0.field3602[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field1167[Client.field1166] = var5;
               Client.field1168[Client.field1166] = var6;
               Client.field1169[Client.field1166] = 0;
               Client.audioEffects[Client.field1166] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field1170[Client.field1166] = var7 + (var9 << 8) + (var8 << 16);
               ++Client.field1166;
            }
         }
      }
   }
}
