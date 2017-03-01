import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class45 {
   @ObfuscatedName("fw")
   @ObfuscatedGetter(
      intValue = -1195691319
   )
   @Export("cameraZ")
   static int cameraZ;
   @ObfuscatedName("g")
   static byte[] field909 = new byte[2048];
   @ObfuscatedName("k")
   static int[] field910 = new int[2048];
   @ObfuscatedName("y")
   static Buffer[] field911 = new Buffer[2048];
   @ObfuscatedName("i")
   static int[] field912 = new int[2048];
   @ObfuscatedName("j")
   static int[] field913 = new int[2048];
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1868171979
   )
   static int field914 = 0;
   @ObfuscatedName("a")
   static int[] field915 = new int[2048];
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1976336277
   )
   static int field916 = 0;
   @ObfuscatedName("s")
   static int[] field917 = new int[2048];
   @ObfuscatedName("q")
   static Buffer field918 = new Buffer(new byte[5000]);
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2057701813
   )
   static int field919 = 0;
   @ObfuscatedName("o")
   static int[] field920 = new int[2048];
   @ObfuscatedName("ie")
   static Widget field924;
   @ObfuscatedName("v")
   static byte[] field928 = new byte[2048];

   @ObfuscatedName("ds")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass164;S)V",
      garbageValue = "25570"
   )
   static final void method908(int var0, int var1, int var2, int var3, SpritePixels var4, class164 var5) {
      int var6 = var2 * var2 + var3 * var3;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapAngle + Client.mapScale & 2047;
         int var8 = class84.field1460[var7];
         int var9 = class84.field1446[var7];
         var8 = 256 * var8 / (Client.mapScaleDelta + 256);
         var9 = 256 * var9 / (256 + Client.mapScaleDelta);
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var3 * var9 - var2 * var8 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class38.field797.method4240(4 + var0 + 94 + var14 - 10, 83 + var1 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class57.method1177(var0, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Lclass15;B)V",
      garbageValue = "17"
   )
   static final void method913(class15 var0) {
      if(WidgetNode.localPlayer.x >> 7 == Client.flagX && Client.flagY == WidgetNode.localPlayer.y >> 7) {
         Client.flagX = 0;
      }

      int var1 = field916;
      int[] var2 = field913;
      int var3 = var1;
      if(class15.field160 == var0 || var0 == class15.field153) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         Player var5;
         int var6;
         if(var0 == class15.field160) {
            var5 = WidgetNode.localPlayer;
            var6 = WidgetNode.localPlayer.field250 << 14;
         } else if(class15.field153 == var0) {
            var5 = Client.cachedPlayers[Client.field418];
            var6 = Client.field418 << 14;
         } else {
            var5 = Client.cachedPlayers[var2[var4]];
            var6 = var2[var4] << 14;
            if(class15.field154 == var0 && Client.field418 == var2[var4]) {
               continue;
            }
         }

         if(var5 != null && var5.vmethod794() && !var5.field260) {
            var5.field258 = false;
            if((Client.field290 && var1 > 50 || var1 > 200) && class15.field160 != var0 && var5.idlePoseAnimation == var5.poseAnimation) {
               var5.field258 = true;
            }

            int var7 = var5.x >> 7;
            int var8 = var5.y >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(var5.model != null && Client.gameCycle >= var5.totalLevel && Client.gameCycle < var5.field249) {
                  var5.field258 = false;
                  var5.field247 = class25.method615(var5.x, var5.y, CollisionData.plane);
                  Friend.region.method1802(CollisionData.plane, var5.x, var5.y, var5.field247, 60, var5, var5.angle, var6, var5.field251, var5.field255, var5.field256, var5.field262);
               } else {
                  if((var5.x & 127) == 64 && (var5.y & 127) == 64) {
                     if(Client.field453[var7][var8] == Client.field502) {
                        continue;
                     }

                     Client.field453[var7][var8] = Client.field502;
                  }

                  var5.field247 = class25.method615(var5.x, var5.y, CollisionData.plane);
                  Friend.region.method1878(CollisionData.plane, var5.x, var5.y, var5.field247, 60, var5, var5.angle, var6, var5.field655);
               }
            }
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-854878775"
   )
   public static void method914(int var0) {
      if(var0 != -1) {
         if(Widget.validInterfaces[var0]) {
            Widget.field2197.method3359(var0);
            if(class231.widgets[var0] != null) {
               boolean var1 = true;

               for(int var2 = 0; var2 < class231.widgets[var0].length; ++var2) {
                  if(null != class231.widgets[var0][var2]) {
                     if(class231.widgets[var0][var2].type != 2) {
                        class231.widgets[var0][var2] = null;
                     } else {
                        var1 = false;
                     }
                  }
               }

               if(var1) {
                  class231.widgets[var0] = null;
               }

               Widget.validInterfaces[var0] = false;
            }
         }
      }
   }

   class45() throws Throwable {
      throw new Error();
   }
}
