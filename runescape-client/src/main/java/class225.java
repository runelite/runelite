import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
public class class225 {
   @ObfuscatedName("i")
   public static class116 field3236;

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "-1730848861"
   )
   static final void method4056(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class14.method172(var0)) {
         class128.field2088 = null;
         class13.gameDraw(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class128.field2088 != null) {
            class13.gameDraw(class128.field2088, -1412584499, var1, var2, var3, var4, class228.field3263, class157.field2335, var7);
            class128.field2088 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field494[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field494[var8] = true;
            }
         }

      }
   }
}
