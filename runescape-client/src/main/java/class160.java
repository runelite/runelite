import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class class160 implements class159 {
   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   static Widget field2147;

   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-754995969"
   )
   @Export("worldToScreen")
   static final void worldToScreen(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class35.getTileHeight(var0, var1, class36.plane) - var2;
         var0 -= Resampler.cameraX;
         var3 -= class49.cameraZ;
         var1 -= class31.cameraY;
         int var4 = Graphics3D.SINE[GameCanvas.cameraPitch];
         int var5 = Graphics3D.COSINE[GameCanvas.cameraPitch];
         int var6 = Graphics3D.SINE[IndexDataBase.cameraYaw];
         int var7 = Graphics3D.COSINE[IndexDataBase.cameraYaw];
         int var8 = var6 * var1 + var0 * var7 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var4 * var1 >> 16;
         var1 = var5 * var1 + var4 * var3 >> 16;
         if(var1 >= 50) {
            Client.screenX = var0 * Client.scale / var1 + Client.viewportWidth / 2;
            Client.screenY = Client.viewportHeight / 2 + var8 * Client.scale / var1;
         } else {
            Client.screenX = -1;
            Client.screenY = -1;
         }

      } else {
         Client.screenX = -1;
         Client.screenY = -1;
      }
   }
}
