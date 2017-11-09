import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
public class class139 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZI)V",
      garbageValue = "946468354"
   )
   public static void method2967(String var0, boolean var1, boolean var2) {
      if(var1) {
         if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var4) {
               ;
            }
         }

         if(class56.field642.startsWith("win")) {
            class34.method491(var0, 0);
         } else if(class56.field642.startsWith("mac")) {
            World.method1670(var0, 1, "openjs");
         } else {
            class34.method491(var0, 2);
         }
      } else {
         class34.method491(var0, 3);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lik;Lik;I)V",
      garbageValue = "-1007059879"
   )
   public static void method2965(IndexDataBase var0, IndexDataBase var1) {
      CombatInfo2.field3420 = var0;
      CombatInfo2.field3421 = var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-90"
   )
   static int method2966(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      return class149.currentRequest != null && class149.currentRequest.hash == var2?DecorativeObject.field2078.offset * 99 / (DecorativeObject.field2078.payload.length - class149.currentRequest.padding) + 1:0;
   }
}
