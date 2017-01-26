import java.applet.Applet;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dg")
public class class114 {
   @ObfuscatedName("m")
   public static class144 field1791;
   @ObfuscatedName("g")
   static String field1792 = null;
   @ObfuscatedName("p")
   static Applet field1793 = null;

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2102352312"
   )
   static void method2204() {
      int var0 = GameEngine.field1779;
      int var1 = GameEngine.field1780;
      int var2 = class40.field813 - class26.field577 - var0;
      int var3 = class8.field75 - class187.field2776 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = class88.field1536.method2114();
            int var5 = 0;
            int var6 = 0;
            if(class15.field163 == var4) {
               Insets var7 = class15.field163.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, class8.field75);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, class40.field813, var1);
            }

            if(var2 > 0) {
               var9.fillRect(var5 + class40.field813 - var2, var6, var2, class8.field75);
            }

            if(var3 > 0) {
               var9.fillRect(var5, class8.field75 + var6 - var3, class40.field813, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }

   class114() throws Throwable {
      throw new Error();
   }
}
