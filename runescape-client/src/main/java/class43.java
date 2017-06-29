import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public class class43 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -548015435
   )
   int field590;
   @ObfuscatedName("a")
   int[][] field592;
   @ObfuscatedName("t")
   int[][] field593;
   @ObfuscatedName("s")
   int[][] field594;
   @ObfuscatedName("r")
   int[][] field595;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1565232781
   )
   static int field596;
   @ObfuscatedName("ra")
   @ObfuscatedGetter(
      longValue = -6992119907625609995L
   )
   static long field599;
   @ObfuscatedName("rj")
   @Export("renderOverview")
   static RenderOverview renderOverview;
   @ObfuscatedName("gs")
   static SpritePixels[] field601;
   @ObfuscatedName("at")
   public static BufferProvider field602;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -13037399
   )
   int field603;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIILFloorUnderlayDefinition;B)V",
      garbageValue = "-22"
   )
   void method635(int var1, int var2, int var3, FloorUnderlayDefinition var4) {
      if(var4 != null) {
         if(var3 + var1 >= 0 && var3 + var2 >= 0) {
            if(var1 - var3 <= this.field590 && var2 - var3 <= this.field603) {
               int var5 = Math.max(0, var1 - var3);
               int var6 = Math.min(this.field590, var3 + var1);
               int var7 = Math.max(0, var2 - var3);
               int var8 = Math.min(this.field603, var3 + var2);

               for(int var9 = var5; var9 < var6; ++var9) {
                  for(int var10 = var7; var10 < var8; ++var10) {
                     this.field592[var9][var10] += var4.field3351 * 256 / var4.field3354;
                     this.field593[var9][var10] += var4.field3348;
                     this.field594[var9][var10] += var4.field3353;
                     ++this.field595[var9][var10];
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1229235449"
   )
   int method636(int var1, int var2) {
      if(var1 >= 0 && var2 >= 0 && var1 < this.field590 && var2 < this.field603) {
         if(this.field594[var1][var2] == 0) {
            return 0;
         } else {
            int var3 = this.field592[var1][var2] / this.field595[var1][var2];
            int var4 = this.field593[var1][var2] / this.field595[var1][var2];
            int var5 = this.field594[var1][var2] / this.field595[var1][var2];
            return Projectile.method1768((double)var3 / 256.0D, (double)var4 / 256.0D, (double)var5 / 256.0D);
         }
      } else {
         return 0;
      }
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "64"
   )
   class43(int var1, int var2) {
      this.field590 = var1;
      this.field603 = var2;
      this.field592 = new int[var1][var2];
      this.field593 = new int[var1][var2];
      this.field594 = new int[var1][var2];
      this.field595 = new int[var1][var2];
   }

   @ObfuscatedName("go")
   @ObfuscatedSignature(
      signature = "(Lclass66;I)V",
      garbageValue = "1316503945"
   )
   static final void method642(class66 var0) {
      if(XItemContainer.localPlayer.x >> 7 == Client.destinationX && XItemContainer.localPlayer.y >> 7 == Client.destinationY) {
         Client.destinationX = 0;
      }

      int var1 = class96.field1521;
      int[] var2 = class96.field1531;
      int var3 = var1;
      if(class66.field830 == var0 || class66.field828 == var0) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         Player var5;
         int var6;
         if(class66.field830 == var0) {
            var5 = XItemContainer.localPlayer;
            var6 = XItemContainer.localPlayer.field914 << 14;
         } else if(class66.field828 == var0) {
            var5 = Client.cachedPlayers[Client.field1056];
            var6 = Client.field1056 << 14;
         } else {
            var5 = Client.cachedPlayers[var2[var4]];
            var6 = var2[var4] << 14;
            if(class66.field829 == var0 && var2[var4] == Client.field1056) {
               continue;
            }
         }

         if(var5 != null && var5.vmethod1695() && !var5.hidden) {
            var5.field908 = false;
            if((Client.field930 && var1 > 50 || var1 > 200) && class66.field830 != var0 && var5.idlePoseAnimation == var5.poseAnimation) {
               var5.field908 = true;
            }

            int var7 = var5.x >> 7;
            int var8 = var5.y >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(var5.model != null && Client.gameCycle >= var5.field898 && Client.gameCycle < var5.field905) {
                  var5.field908 = false;
                  var5.field897 = WorldMapData.method343(var5.x, var5.y, WallObject.plane);
                  class2.region.method2678(WallObject.plane, var5.x, var5.y, var5.field897, 60, var5, var5.angle, var6, var5.field891, var5.field899, var5.field906, var5.field907);
               } else {
                  if((var5.x & 127) == 64 && (var5.y & 127) == 64) {
                     if(Client.field1058[var7][var8] == Client.field957) {
                        continue;
                     }

                     Client.field1058[var7][var8] = Client.field957;
                  }

                  var5.field897 = WorldMapData.method343(var5.x, var5.y, WallObject.plane);
                  class2.region.method2677(WallObject.plane, var5.x, var5.y, var5.field897, 60, var5, var5.angle, var6, var5.field1267);
               }
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)Z",
      garbageValue = "6"
   )
   static final boolean method643(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = class134.field2008 + var6;
      if(var7 < var0 && var7 < var1 && var7 < var2) {
         return false;
      } else {
         var7 = class134.field2008 - var6;
         if(var7 > var0 && var7 > var1 && var7 > var2) {
            return false;
         } else {
            var7 = class134.field2014 + var6;
            if(var7 < var3 && var7 < var4 && var7 < var5) {
               return false;
            } else {
               var7 = class134.field2014 - var6;
               return var7 <= var3 || var7 <= var4 || var7 <= var5;
            }
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "4"
   )
   static void method644() {
      Object var0 = class236.field3244;
      synchronized(class236.field3244) {
         if(class236.field3243 == 0) {
            class236.field3245 = new Thread(new class236());
            class236.field3245.setDaemon(true);
            class236.field3245.start();
            class236.field3245.setPriority(5);
         }

         class236.field3243 = 600;
      }
   }
}
