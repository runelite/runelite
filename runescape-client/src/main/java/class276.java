import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jy")
public class class276 {
   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "2"
   )
   static final void method4980(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class85.loadWidget(var0)) {
         GameSocket.field2246 = null;
         FontName.gameDraw(GZipDecompressor.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(GameSocket.field2246 != null) {
            FontName.gameDraw(GameSocket.field2246, -1412584499, var1, var2, var3, var4, class36.field496, class308.field3880, var7);
            GameSocket.field2246 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field1055[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field1055[var8] = true;
            }
         }

      }
   }
}
