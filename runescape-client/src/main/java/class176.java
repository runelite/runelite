import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
public final class class176 {
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = 1283671155
   )
   static int field2661;

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-18"
   )
   static final void method3278(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class2.method19(var0, var1, WallObject.plane) - var2;
         var0 -= VertexNormal.cameraX;
         var3 -= class36.cameraZ;
         var1 -= class37.cameraY;
         int var4 = class84.field1468[Actor.cameraPitch];
         int var5 = class84.field1462[Actor.cameraPitch];
         int var6 = class84.field1468[class26.cameraYaw];
         int var7 = class84.field1462[class26.cameraYaw];
         int var8 = var7 * var0 + var1 * var6 >> 16;
         var1 = var7 * var1 - var6 * var0 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var1 * var4 >> 16;
         var1 = var5 * var1 + var3 * var4 >> 16;
         if(var1 >= 50) {
            Client.field410 = Client.scale * var0 / var1 + Client.camera2 / 2;
            Client.field411 = Client.scale * var8 / var1 + Client.camera3 / 2;
         } else {
            Client.field410 = -1;
            Client.field411 = -1;
         }

      } else {
         Client.field410 = -1;
         Client.field411 = -1;
      }
   }

   class176() throws Throwable {
      throw new Error();
   }
}
