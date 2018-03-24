import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
@Implements("RunException")
public class RunException extends RuntimeException {
   @ObfuscatedName("q")
   public static Applet field2154;
   @ObfuscatedName("l")
   String field2153;
   @ObfuscatedName("b")
   @Export("parent")
   Throwable parent;

   RunException(Throwable var1, String var2) {
      this.field2153 = var2;
      this.parent = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-976632152"
   )
   static synchronized byte[] method3218(int var0) {
      return class195.method3764(var0, false);
   }

   @ObfuscatedName("jp")
   @ObfuscatedSignature(
      signature = "(Lig;B)Lig;",
      garbageValue = "1"
   )
   static Widget method3217(Widget var0) {
      int var1 = GrandExchangeOffer.method124(GrandExchangeEvent.getWidgetConfig(var0));
      if(var1 == 0) {
         return null;
      } else {
         for(int var2 = 0; var2 < var1; ++var2) {
            var0 = GZipDecompressor.getWidget(var0.parentId);
            if(var0 == null) {
               return null;
            }
         }

         return var0;
      }
   }
}
