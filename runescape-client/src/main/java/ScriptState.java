import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
@Implements("ScriptState")
public class ScriptState {
   @ObfuscatedName("t")
   String[] field110;
   @ObfuscatedName("i")
   int[] field112;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1840953173
   )
   int field113 = -1;
   @ObfuscatedName("ei")
   static SpritePixels[] field115;
   @ObfuscatedName("b")
   Script field118;

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-1219912189"
   )
   static final void method164(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.field404 && class156.plane != var0) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = Varbit.region.method1825(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = Varbit.region.method1851(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = Varbit.region.method1784(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = Varbit.region.method1785(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = Varbit.region.method1786(var0, var2, var3, var7);
            int var13 = var7 >> 14 & 32767;
            int var14 = var11 & 31;
            int var15 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               Varbit.region.method1922(var0, var2, var3);
               var12 = class196.getObjectDefinition(var13);
               if(var12.field2914 != 0) {
                  Client.collisionMaps[var0].method2327(var2, var3, var14, var15, var12.field2915);
               }
            }

            if(var1 == 1) {
               Varbit.region.method1774(var0, var2, var3);
            }

            if(var1 == 2) {
               Varbit.region.method1842(var0, var2, var3);
               var12 = class196.getObjectDefinition(var13);
               if(var12.sizeX + var2 > 103 || var12.sizeX + var3 > 103 || var12.sizeY + var2 > 103 || var3 + var12.sizeY > 103) {
                  return;
               }

               if(var12.field2914 != 0) {
                  Client.collisionMaps[var0].method2332(var2, var3, var12.sizeX, var12.sizeY, var15, var12.field2915);
               }
            }

            if(var1 == 3) {
               Varbit.region.method1776(var0, var2, var3);
               var12 = class196.getObjectDefinition(var13);
               if(var12.field2914 == 1) {
                  Client.collisionMaps[var0].method2325(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class10.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            class103.method2016(var0, var11, var2, var3, var4, var5, var6, Varbit.region, Client.collisionMaps[var0]);
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "371566406"
   )
   public static int method165() {
      return class105.keyboardIdleTicks;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Lclass15;I)V",
      garbageValue = "2115337623"
   )
   static final void method166(class15 var0) {
      if(Client.flagX == class9.localPlayer.x >> 7 && class9.localPlayer.y >> 7 == Client.flagY) {
         Client.flagX = 0;
      }

      int var1 = class45.field907;
      int[] var2 = class45.field900;
      int var3 = var1;
      if(var0 == class15.field161 || class15.field155 == var0) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         Player var5;
         int var6;
         if(var0 == class15.field161) {
            var5 = class9.localPlayer;
            var6 = class9.localPlayer.field261 << 14;
         } else if(var0 == class15.field155) {
            var5 = Client.cachedPlayers[Client.field414];
            var6 = Client.field414 << 14;
         } else {
            var5 = Client.cachedPlayers[var2[var4]];
            var6 = var2[var4] << 14;
            if(var0 == class15.field160 && var2[var4] == Client.field414) {
               continue;
            }
         }

         if(null != var5 && var5.vmethod795() && !var5.field259) {
            var5.field257 = false;
            if((Client.field404 && var1 > 50 || var1 > 200) && var0 != class15.field161 && var5.poseAnimation == var5.idlePoseAnimation) {
               var5.field257 = true;
            }

            int var7 = var5.x >> 7;
            int var8 = var5.y >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(null != var5.model && Client.gameCycle >= var5.totalLevel && Client.gameCycle < var5.field239) {
                  var5.field257 = false;
                  var5.field262 = class65.method1224(var5.x, var5.y, class156.plane);
                  Varbit.region.method1847(class156.plane, var5.x, var5.y, var5.field262, 60, var5, var5.angle, var6, var5.field253, var5.field254, var5.field255, var5.field250);
               } else {
                  if((var5.x & 127) == 64 && (var5.y & 127) == 64) {
                     if(Client.field543 == Client.field334[var7][var8]) {
                        continue;
                     }

                     Client.field334[var7][var8] = Client.field543;
                  }

                  var5.field262 = class65.method1224(var5.x, var5.y, class156.plane);
                  Varbit.region.method1838(class156.plane, var5.x, var5.y, var5.field262, 60, var5, var5.angle, var6, var5.field632);
               }
            }
         }
      }

   }
}
