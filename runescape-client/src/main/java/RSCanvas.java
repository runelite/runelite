import java.awt.Canvas;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.mapping.Replace;

@ObfuscatedName("df")
@Implements("RSCanvas")
@Replace("net.runelite.inject.RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("du")
   static int[] field1759;
   @ObfuscatedName("s")
   Component field1762;

   public final void update(Graphics var1) {
      this.field1762.update(var1);
   }

   RSCanvas(Component var1) {
      this.field1762 = var1;
   }

   public final void paint(Graphics var1) {
      this.field1762.paint(var1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZLjava/lang/String;ZI)V",
      garbageValue = "142767826"
   )
   static void method2034(String var0, boolean var1, String var2, boolean var3) {
      if(var1) {
         if(!var3 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
               ;
            }
         }

         if(class114.field1791.startsWith("win") && !var3) {
            class140.method2551(var0, 0, "openjs");
            return;
         }

         if(class114.field1791.startsWith("mac")) {
            class140.method2551(var0, 1, var2);
            return;
         }

         class140.method2551(var0, 2, "openjs");
      } else {
         class140.method2551(var0, 3, "openjs");
      }

   }
}
