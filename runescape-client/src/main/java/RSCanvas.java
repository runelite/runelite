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

@ObfuscatedName("dq")
@Implements("RSCanvas")
@Replace("net.runelite.inject.RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("p")
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZLjava/lang/String;ZB)V",
      garbageValue = "-98"
   )
   static void method2079(String var0, boolean var1, String var2, boolean var3) {
      if(var1) {
         if(!var3 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
               ;
            }
         }

         if(class114.field1792.startsWith("win") && !var3) {
            TextureProvider.method1451(var0, 0);
            return;
         }

         if(class114.field1792.startsWith("mac")) {
            Ignore.method191(var0, 1, var2);
            return;
         }

         TextureProvider.method1451(var0, 2);
      } else {
         TextureProvider.method1451(var0, 3);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "188615624"
   )
   public static boolean method2080(int var0) {
      return (var0 >> 31 & 1) != 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1565990949"
   )
   public static void method2081() {
      ObjectComposition.field2928.reset();
      ObjectComposition.field2913.reset();
      ObjectComposition.field2930.reset();
      ObjectComposition.field2894.reset();
   }
}
