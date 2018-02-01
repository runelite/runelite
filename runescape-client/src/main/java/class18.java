import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
final class class18 implements Comparator {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "[Lkh;"
   )
   @Export("titlemuteSprite")
   static IndexedSprite[] titlemuteSprite;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   public static IndexDataBase field301;
   @ObfuscatedName("ac")
   protected static boolean field305;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ln;Ln;B)I",
      garbageValue = "-10"
   )
   int method152(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.method92().compareTo(var2.method92());
   }

   public int compare(Object var1, Object var2) {
      return this.method152((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZLjava/lang/String;ZI)V",
      garbageValue = "888633041"
   )
   public static void method153(String var0, boolean var1, String var2, boolean var3) {
      if(var1) {
         if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
               ;
            }
         }

         if(class56.field617.startsWith("win")) {
            Bounds.method5379(var0, 0, "openjs");
            return;
         }

         if(class56.field617.startsWith("mac")) {
            Bounds.method5379(var0, 1, var2);
            return;
         }

         Bounds.method5379(var0, 2, "openjs");
      } else {
         Bounds.method5379(var0, 3, "openjs");
      }

   }
}
