import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
public class class151 extends RuntimeException {
   @ObfuscatedName("z")
   public static String field2264;
   @ObfuscatedName("p")
   String field2265;
   @ObfuscatedName("s")
   static Applet field2266;
   @ObfuscatedName("g")
   Throwable field2268;

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "215156283"
   )
   static final void method3122(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class174.method3393(var0)) {
         Ignore.field119 = null;
         Friend.gameDraw(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(Ignore.field119 != null) {
            Friend.gameDraw(Ignore.field119, -1412584499, var1, var2, var3, var4, class165.field2696, class9.field142, var7);
            Ignore.field119 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field379[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field379[var8] = true;
            }
         }

      }
   }
}
