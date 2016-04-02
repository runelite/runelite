import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public class class177 {
   @ObfuscatedName("im")
   static class30 field2910;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZLjava/lang/String;ZI)V",
      garbageValue = "1671421258"
   )
   static void method3442(String var0, boolean var1, String var2, boolean var3) {
      if(var1) {
         if(!var3 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
               ;
            }
         }

         if(class138.field2122.startsWith("win") && !var3) {
            class42.method898(var0, 0);
            return;
         }

         if(class138.field2122.startsWith("mac")) {
            class94.method2185(var0, 1, var2);
            return;
         }

         class42.method898(var0, 2);
      } else {
         class42.method898(var0, 3);
      }

   }
}
