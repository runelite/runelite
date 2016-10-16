import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
public class class158 {
   @ObfuscatedName("z")
   public static final boolean[] field2338 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
   @ObfuscatedName("t")
   public static int[] field2339 = new int[99];

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-523817867"
   )
   static final void method3156(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class79.method1656(var0, var1, class59.plane) - var2;
         var0 -= class13.cameraX;
         var3 -= Ignore.cameraZ;
         var1 -= class154.cameraY;
         int var4 = class94.field1631[class125.cameraPitch];
         int var5 = class94.field1621[class125.cameraPitch];
         int var6 = class94.field1631[class166.cameraYaw];
         int var7 = class94.field1621[class166.cameraYaw];
         int var8 = var6 * var1 + var7 * var0 >> 16;
         var1 = var1 * var7 - var6 * var0 >> 16;
         var0 = var8;
         var8 = var5 * var3 - var1 * var4 >> 16;
         var1 = var5 * var1 + var3 * var4 >> 16;
         if(var1 >= 50) {
            Client.field375 = Client.camera2 / 2 + Client.scale * var0 / var1;
            Client.field376 = Client.camera3 / 2 + Client.scale * var8 / var1;
         } else {
            Client.field375 = -1;
            Client.field376 = -1;
         }

      } else {
         Client.field375 = -1;
         Client.field376 = -1;
      }
   }

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2339[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1520640986"
   )
   public static String method3157(int var0) {
      return (var0 >> 24 & 255) + "." + (var0 >> 16 & 255) + "." + (var0 >> 8 & 255) + "." + (var0 & 255);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "95"
   )
   static int method3158() {
      return Client.isResized?2:1;
   }
}
