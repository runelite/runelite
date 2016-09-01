import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
public class class179 {
   @ObfuscatedName("x")
   public static int[] field2957 = new int[32];
   @ObfuscatedName("r")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("j")
   @Export("widgetSettings")
   public static int[] widgetSettings;

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2957[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1879871389"
   )
   static final void method3480(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = KitDefinition.method936(var0, var1, FrameMap.plane) - var2;
         var0 -= Ignore.cameraX;
         var3 -= class119.cameraZ;
         var1 -= WallObject.cameraY;
         int var4 = class94.field1639[class53.cameraPitch];
         int var5 = class94.field1640[class53.cameraPitch];
         int var6 = class94.field1639[Client.cameraYaw];
         int var7 = class94.field1640[Client.cameraYaw];
         int var8 = var6 * var1 + var0 * var7 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var5 * var3 - var1 * var4 >> 16;
         var1 = var4 * var3 + var5 * var1 >> 16;
         if(var1 >= 50) {
            Client.field387 = Client.scale * var0 / var1 + Client.camera2 / 2;
            Client.field388 = var8 * Client.scale / var1 + Client.camera3 / 2;
         } else {
            Client.field387 = -1;
            Client.field388 = -1;
         }

      } else {
         Client.field387 = -1;
         Client.field388 = -1;
      }
   }
}
