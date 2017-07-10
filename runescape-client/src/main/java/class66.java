import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
public class class66 {
   @ObfuscatedName("w")
   static final class66 field828;
   @ObfuscatedName("t")
   static final class66 field829;
   @ObfuscatedName("i")
   static final class66 field830;
   @ObfuscatedName("pc")
   @ObfuscatedGetter(
      intValue = 70177287
   )
   static int field832;
   @ObfuscatedName("rr")
   static class13 field833;
   @ObfuscatedName("a")
   static final class66 field834;

   static {
      field830 = new class66();
      field828 = new class66();
      field834 = new class66();
      field829 = new class66();
   }

   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2000867641"
   )
   static final void method1120() {
      int var0 = Client.field1208 * 128 + 64;
      int var1 = class207.field2591 * 128 + 64;
      int var2 = WorldMapData.method343(var0, var1, WallObject.plane) - class95.field1515;
      if(class155.cameraX < var0) {
         class155.cameraX += (var0 - class155.cameraX) * class31.field457 / 1000 + class34.field500;
         if(class155.cameraX > var0) {
            class155.cameraX = var0;
         }
      }

      if(class155.cameraX > var0) {
         class155.cameraX -= (class155.cameraX - var0) * class31.field457 / 1000 + class34.field500;
         if(class155.cameraX < var0) {
            class155.cameraX = var0;
         }
      }

      if(class60.cameraZ < var2) {
         class60.cameraZ += (var2 - class60.cameraZ) * class31.field457 / 1000 + class34.field500;
         if(class60.cameraZ > var2) {
            class60.cameraZ = var2;
         }
      }

      if(class60.cameraZ > var2) {
         class60.cameraZ -= (class60.cameraZ - var2) * class31.field457 / 1000 + class34.field500;
         if(class60.cameraZ < var2) {
            class60.cameraZ = var2;
         }
      }

      if(class157.cameraY < var1) {
         class157.cameraY += class31.field457 * (var1 - class157.cameraY) / 1000 + class34.field500;
         if(class157.cameraY > var1) {
            class157.cameraY = var1;
         }
      }

      if(class157.cameraY > var1) {
         class157.cameraY -= (class157.cameraY - var1) * class31.field457 / 1000 + class34.field500;
         if(class157.cameraY < var1) {
            class157.cameraY = var1;
         }
      }

      var0 = field832 * 128 + 64;
      var1 = ISAACCipher.field2438 * 128 + 64;
      var2 = WorldMapData.method343(var0, var1, WallObject.plane) - IndexFile.field2289;
      int var3 = var0 - class155.cameraX;
      int var4 = var2 - class60.cameraZ;
      int var5 = var1 - class157.cameraY;
      int var6 = (int)Math.sqrt((double)(var5 * var5 + var3 * var3));
      int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
      int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
      if(var7 < 128) {
         var7 = 128;
      }

      if(var7 > 383) {
         var7 = 383;
      }

      if(Player.cameraPitch < var7) {
         Player.cameraPitch += class151.field2223 * (var7 - Player.cameraPitch) / 1000 + class174.field2414;
         if(Player.cameraPitch > var7) {
            Player.cameraPitch = var7;
         }
      }

      if(Player.cameraPitch > var7) {
         Player.cameraPitch -= class151.field2223 * (Player.cameraPitch - var7) / 1000 + class174.field2414;
         if(Player.cameraPitch < var7) {
            Player.cameraPitch = var7;
         }
      }

      int var9 = var8 - class22.cameraYaw;
      if(var9 > 1024) {
         var9 -= 2048;
      }

      if(var9 < -1024) {
         var9 += 2048;
      }

      if(var9 > 0) {
         class22.cameraYaw += var9 * class151.field2223 / 1000 + class174.field2414;
         class22.cameraYaw &= 2047;
      }

      if(var9 < 0) {
         class22.cameraYaw -= class174.field2414 + class151.field2223 * -var9 / 1000;
         class22.cameraYaw &= 2047;
      }

      int var10 = var8 - class22.cameraYaw;
      if(var10 > 1024) {
         var10 -= 2048;
      }

      if(var10 < -1024) {
         var10 += 2048;
      }

      if(var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
         class22.cameraYaw = var8;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1620899399"
   )
   public static boolean method1121(int var0) {
      if(class152.validInterfaces[var0]) {
         return true;
      } else if(!Widget.field2646.method4117(var0)) {
         return false;
      } else {
         int var1 = Widget.field2646.method4133(var0);
         if(var1 == 0) {
            class152.validInterfaces[var0] = true;
            return true;
         } else {
            if(class46.widgets[var0] == null) {
               class46.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(class46.widgets[var0][var2] == null) {
                  byte[] var3 = Widget.field2646.getConfigData(var0, var2);
                  if(var3 != null) {
                     class46.widgets[var0][var2] = new Widget();
                     class46.widgets[var0][var2].id = (var0 << 16) + var2;
                     if(var3[0] == -1) {
                        class46.widgets[var0][var2].method3983(new Buffer(var3));
                     } else {
                        class46.widgets[var0][var2].method3982(new Buffer(var3));
                     }
                  }
               }
            }

            class152.validInterfaces[var0] = true;
            return true;
         }
      }
   }
}
