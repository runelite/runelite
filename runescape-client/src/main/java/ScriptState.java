import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
@Implements("ScriptState")
public class ScriptState {
   @ObfuscatedName("qw")
   @ObfuscatedSignature(
      signature = "Lkw;"
   )
   @Export("renderOverview")
   static RenderOverview renderOverview;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lcx;"
   )
   @Export("invokedFromScript")
   Script invokedFromScript;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -238592489
   )
   @Export("invokedFromPc")
   int invokedFromPc;
   @ObfuscatedName("r")
   @Export("savedLocalInts")
   int[] savedLocalInts;
   @ObfuscatedName("g")
   @Export("savedLocalStrings")
   String[] savedLocalStrings;

   ScriptState() {
      this.invokedFromPc = -1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(S)[Ljq;",
      garbageValue = "-2716"
   )
   static class285[] method1001() {
      return new class285[]{class285.field3784, class285.field3783, class285.field3782};
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "606070818"
   )
   public static boolean method1000(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class56.field629.startsWith("win")) {
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
            Object var3 = class52.method730(class56.field630, var2, new Object[]{(new URL(class56.field630.getCodeBase(), var0)).toString()});
            return var3 != null;
         } catch (Throwable var6) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class56.field630.getAppletContext().showDocument(new URL(class56.field630.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var7) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class52.method726(class56.field630, "loggedout");
         } catch (Throwable var9) {
            ;
         }

         try {
            class56.field630.getAppletContext().showDocument(new URL(class56.field630.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var8) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1518554558"
   )
   static void method998() {
      if(MouseInput.loadWorlds()) {
         class91.worldSelectShown = true;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IZII)V",
      garbageValue = "16711680"
   )
   public static final void method999(int var0, boolean var1, int var2) {
      if(var0 >= 8000 && var0 <= 48000) {
         AbstractSoundSystem.sampleRate = var0;
         AbstractSoundSystem.highMemory = var1;
         AbstractSoundSystem.priority = var2;
      } else {
         throw new IllegalArgumentException();
      }
   }
}
