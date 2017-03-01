import java.applet.Applet;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
public class class114 {
   @ObfuscatedName("n")
   public static String field1786 = null;
   @ObfuscatedName("x")
   public static Applet field1787 = null;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2061263707
   )
   static int field1790;
   @ObfuscatedName("pp")
   public static class103 field1793;

   class114() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1931444316"
   )
   static void method2299(int var0) {
      if(var0 != -1) {
         if(Projectile.method874(var0)) {
            Widget[] var1 = class231.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2287 != null) {
                  class18 var4 = new class18();
                  var4.field188 = var3;
                  var4.field196 = var3.field2287;
                  class203.method3853(var4, 2000000);
               }
            }

         }
      }
   }
}
