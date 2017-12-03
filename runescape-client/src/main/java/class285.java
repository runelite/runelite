import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ji")
public class class285 {
   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "79"
   )
   @Export("worldToScreen")
   static final void worldToScreen(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = WorldMapType2.getTileHeight(var0, var1, BoundingBox2D.plane) - var2;
         var0 -= MouseInput.cameraX;
         var3 -= GrandExchangeEvent.cameraZ;
         var1 -= GZipDecompressor.cameraY;
         int var4 = Graphics3D.SINE[class160.cameraPitch];
         int var5 = Graphics3D.COSINE[class160.cameraPitch];
         int var6 = Graphics3D.SINE[class240.cameraYaw];
         int var7 = Graphics3D.COSINE[class240.cameraYaw];
         int var8 = var0 * var7 + var6 * var1 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var4 * var1 >> 16;
         var1 = var3 * var4 + var5 * var1 >> 16;
         if(var1 >= 50) {
            Client.screenY = var0 * Client.scale / var1 + Client.viewportHeight / 2;
            Client.screenX = var8 * Client.scale / var1 + Client.viewportWidth / 2;
         } else {
            Client.screenY = -1;
            Client.screenX = -1;
         }

      } else {
         Client.screenY = -1;
         Client.screenX = -1;
      }
   }
}
