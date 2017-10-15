import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
public class class175 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = -6066013746895445967L
   )
   static long field2421;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = -3268629985841754077L
   )
   static long field2419;

   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1559135788"
   )
   static final void method3469(int var0, int var1, int var2, int var3) {
      ++Client.field1016;
      if(AbstractByteBuffer.localPlayer.x >> 7 == Client.destinationX && AbstractByteBuffer.localPlayer.y >> 7 == Client.destinationY) {
         Client.destinationX = 0;
      }

      class7.method35(AbstractByteBuffer.localPlayer, false);
      if(Client.field1061 >= 0 && Client.cachedPlayers[Client.field1061] != null) {
         class7.method35(Client.cachedPlayers[Client.field1061], false);
      }

      GameObject.method2968(true);
      int var4 = class94.field1485;
      int[] var5 = class94.field1480;

      int var6;
      for(var6 = 0; var6 < var4; ++var6) {
         if(var5[var6] != Client.field1061 && var5[var6] != Client.localInteractingIndex) {
            class7.method35(Client.cachedPlayers[var5[var6]], true);
         }
      }

      GameObject.method2968(false);
      class72.method1164();
      class17.method127();
      class41.method587(var0, var1, var2, var3, true);
      var0 = Client.field931;
      var1 = Client.field956;
      var2 = Client.viewportHeight;
      var3 = Client.viewportWidth;
      Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
      Graphics3D.method2680();
      int var14;
      if(!Client.field1160) {
         var4 = Client.field921;
         if(Client.field1124 / 256 > var4) {
            var4 = Client.field1124 / 256;
         }

         if(Client.field1161[4] && Client.field1056[4] + 128 > var4) {
            var4 = Client.field1056[4] + 128;
         }

         var14 = Client.mapAngle & 2047;
         class15.method97(Occluder.field2140, CacheFile.getTileHeight(AbstractByteBuffer.localPlayer.x, AbstractByteBuffer.localPlayer.y, class5.plane) - Client.field1002, class40.field569, var4, var14, 600 + var4 * 3);
      }

      if(!Client.field1160) {
         var4 = CombatInfo1.method1607();
      } else {
         if(class23.preferences.hideRoofs) {
            var14 = class5.plane;
         } else {
            var6 = CacheFile.getTileHeight(class211.cameraX, ChatLineBuffer.cameraY, class5.plane);
            if(var6 - ScriptState.cameraZ < 800 && (class61.tileSettings[class5.plane][class211.cameraX >> 7][ChatLineBuffer.cameraY >> 7] & 4) != 0) {
               var14 = class5.plane;
            } else {
               var14 = 3;
            }
         }

         var4 = var14;
      }

      var14 = class211.cameraX;
      var6 = ScriptState.cameraZ;
      int var7 = ChatLineBuffer.cameraY;
      int var8 = class9.cameraPitch;
      int var9 = class174.cameraYaw;

      int var10;
      int var11;
      for(var10 = 0; var10 < 5; ++var10) {
         if(Client.field1161[var10]) {
            var11 = (int)(Math.random() * (double)(1 + Client.field1162[var10] * 2) - (double)Client.field1162[var10] + Math.sin((double)Client.field1164[var10] / 100.0D * (double)Client.field1165[var10]) * (double)Client.field1056[var10]);
            if(var10 == 0) {
               class211.cameraX += var11;
            }

            if(var10 == 1) {
               ScriptState.cameraZ += var11;
            }

            if(var10 == 2) {
               ChatLineBuffer.cameraY += var11;
            }

            if(var10 == 3) {
               class174.cameraYaw = var11 + class174.cameraYaw & 2047;
            }

            if(var10 == 4) {
               class9.cameraPitch += var11;
               if(class9.cameraPitch < 128) {
                  class9.cameraPitch = 128;
               }

               if(class9.cameraPitch > 383) {
                  class9.cameraPitch = 383;
               }
            }
         }
      }

      var10 = MouseInput.field745;
      var11 = MouseInput.field746;
      if(MouseInput.field741 != 0) {
         var10 = MouseInput.field752;
         var11 = MouseInput.field753;
      }

      int var12;
      if(var10 >= var0 && var10 < var0 + var2 && var11 >= var1 && var11 < var3 + var1) {
         var12 = var10 - var0;
         int var13 = var11 - var1;
         class132.field1985 = var12;
         class132.field1984 = var13;
         class132.field1982 = true;
         class132.field1989 = 0;
         class132.field1983 = false;
      } else {
         class132.field1982 = false;
         class132.field1989 = 0;
      }

      class28.method234();
      Rasterizer2D.method5129(var0, var1, var2, var3, 0);
      class28.method234();
      var12 = Graphics3D.field2009;
      Graphics3D.field2009 = Client.scale;
      class8.region.draw(class211.cameraX, ScriptState.cameraZ, ChatLineBuffer.cameraY, class9.cameraPitch, class174.cameraYaw, var4);

      while(true) {
         class9 var15 = (class9)class7.field247.method3663();
         if(var15 == null) {
            Graphics3D.field2009 = var12;
            class28.method234();
            class8.region.clearEntities();
            ScriptVarType.method25(var0, var1, var2, var3);
            class20.method146(var0, var1);
            ((TextureProvider)Graphics3D.textureLoader).method2488(Client.field1122);
            class33.method336(var0, var1, var2, var3);
            class211.cameraX = var14;
            ScriptState.cameraZ = var6;
            ChatLineBuffer.cameraY = var7;
            class9.cameraPitch = var8;
            class174.cameraYaw = var9;
            if(Client.field1123 && Signlink.method3041(true, false) == 0) {
               Client.field1123 = false;
            }

            if(Client.field1123) {
               Rasterizer2D.method5129(var0, var1, var2, var3, 0);
               class14.drawStatusBox("Loading - please wait.", false);
            }

            return;
         }

         var15.vmethod57();
      }
   }
}
