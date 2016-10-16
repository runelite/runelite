import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("z")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("fj")
   @ObfuscatedGetter(
      intValue = 1698302853
   )
   @Export("cameraZ")
   static int cameraZ;
   @ObfuscatedName("jc")
   static Widget[] field119;
   @ObfuscatedName("s")
   @Export("name")
   String name;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-35"
   )
   static final void method103() {
      int var0 = 64 + class22.field575 * 128;
      int var1 = 64 + class54.field1138 * 128;
      int var2 = class79.method1656(var0, var1, class59.plane) - class9.field148;
      if(class13.cameraX < var0) {
         class13.cameraX += class0.field12 + (var0 - class13.cameraX) * class1.field23 / 1000;
         if(class13.cameraX > var0) {
            class13.cameraX = var0;
         }
      }

      if(class13.cameraX > var0) {
         class13.cameraX -= (class13.cameraX - var0) * class1.field23 / 1000 + class0.field12;
         if(class13.cameraX < var0) {
            class13.cameraX = var0;
         }
      }

      if(cameraZ < var2) {
         cameraZ += class1.field23 * (var2 - cameraZ) / 1000 + class0.field12;
         if(cameraZ > var2) {
            cameraZ = var2;
         }
      }

      if(cameraZ > var2) {
         cameraZ -= class1.field23 * (cameraZ - var2) / 1000 + class0.field12;
         if(cameraZ < var2) {
            cameraZ = var2;
         }
      }

      if(class154.cameraY < var1) {
         class154.cameraY += (var1 - class154.cameraY) * class1.field23 / 1000 + class0.field12;
         if(class154.cameraY > var1) {
            class154.cameraY = var1;
         }
      }

      if(class154.cameraY > var1) {
         class154.cameraY -= (class154.cameraY - var1) * class1.field23 / 1000 + class0.field12;
         if(class154.cameraY < var1) {
            class154.cameraY = var1;
         }
      }

      var0 = class51.field1099 * 128 + 64;
      var1 = 64 + class8.field127 * 128;
      var2 = class79.method1656(var0, var1, class59.plane) - class4.field63;
      int var3 = var0 - class13.cameraX;
      int var4 = var2 - cameraZ;
      int var5 = var1 - class154.cameraY;
      int var6 = (int)Math.sqrt((double)(var3 * var3 + var5 * var5));
      int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
      int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
      if(var7 < 128) {
         var7 = 128;
      }

      if(var7 > 383) {
         var7 = 383;
      }

      if(class125.cameraPitch < var7) {
         class125.cameraPitch += class112.field1939 * (var7 - class125.cameraPitch) / 1000 + class191.field3082;
         if(class125.cameraPitch > var7) {
            class125.cameraPitch = var7;
         }
      }

      if(class125.cameraPitch > var7) {
         class125.cameraPitch -= class191.field3082 + class112.field1939 * (class125.cameraPitch - var7) / 1000;
         if(class125.cameraPitch < var7) {
            class125.cameraPitch = var7;
         }
      }

      int var9 = var8 - class166.cameraYaw;
      if(var9 > 1024) {
         var9 -= 2048;
      }

      if(var9 < -1024) {
         var9 += 2048;
      }

      if(var9 > 0) {
         class166.cameraYaw += class112.field1939 * var9 / 1000 + class191.field3082;
         class166.cameraYaw &= 2047;
      }

      if(var9 < 0) {
         class166.cameraYaw -= -var9 * class112.field1939 / 1000 + class191.field3082;
         class166.cameraYaw &= 2047;
      }

      int var10 = var8 - class166.cameraYaw;
      if(var10 > 1024) {
         var10 -= 2048;
      }

      if(var10 < -1024) {
         var10 += 2048;
      }

      if(var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
         class166.cameraYaw = var8;
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1362561095"
   )
   static final void method104(boolean var0) {
      for(int var1 = 0; var1 < Client.field309; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.field307[var1]];
         int var3 = (Client.field307[var1] << 14) + 536870912;
         if(null != var2 && var2.vmethod767() && var0 == var2.composition.isVisible && var2.composition.method801()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field805 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field373[var4][var5] == Client.field374) {
                     continue;
                  }

                  Client.field373[var4][var5] = Client.field374;
               }

               if(!var2.composition.field900) {
                  var3 -= Integer.MIN_VALUE;
               }

               class114.region.method1926(class59.plane, var2.x, var2.y, class79.method1656(var2.x + (var2.field805 * 64 - 64), var2.y + (var2.field805 * 64 - 64), class59.plane), var2.field805 * 64 - 64 + 60, var2, var2.angle, var3, var2.field860);
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass125;B)V",
      garbageValue = "22"
   )
   static final void method105(class125 var0) {
      var0.method2750();
      int var1 = Client.localInteractingIndex;
      Player var2 = TextureProvider.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field48 = var1;
      int var3 = var0.method2762(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class23.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.method9() << 6);
      var2.pathY[0] = var6 - class8.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.method9() << 6);
      var2.field47 = var4 * -1044776581;
      class59.plane = var4;
      if(class34.field742[var1] != null) {
         var2.method7(class34.field742[var1]);
      }

      class34.field743 = 0;
      class34.field739[++class34.field743 - 1] = var1;
      class34.field740[var1] = 0;
      class34.field745 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var1 != var7) {
            int var8 = var0.method2762(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 255;
            int var11 = var8 & 255;
            class34.field747[var7] = (var10 << 14) + (var9 << 28) + var11;
            class34.field748[var7] = 0;
            class34.field755[var7] = -1;
            class34.field754[++class34.field745 - 1] = var7;
            class34.field740[var7] = 0;
         }
      }

      var0.method2751();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "-1950"
   )
   static final int method106(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
