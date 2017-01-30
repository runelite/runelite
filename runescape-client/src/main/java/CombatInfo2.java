import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -330629911
   )
   @Export("healthScale")
   public int healthScale = 30;
   @ObfuscatedName("q")
   static NodeCache field2827 = new NodeCache(64);
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2013940889
   )
   int field2828 = -1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -711662749
   )
   public int field2831;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -520702403
   )
   public int field2832 = 255;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1996445371
   )
   public int field2833 = -1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1981707689
   )
   public int field2834 = 1;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1286524241
   )
   public int field2835 = 70;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1789356883
   )
   int field2836 = -1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2077063477
   )
   public int field2837 = 255;
   @ObfuscatedName("x")
   static NodeCache field2838 = new NodeCache(64);
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1881845451
   )
   public int field2839 = 0;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-156909738"
   )
   public SpritePixels method3511() {
      if(this.field2836 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field2827.get((long)this.field2836);
         if(null != var1) {
            return var1;
         } else {
            var1 = class186.method3417(class217.field3170, this.field2836, 0);
            if(null != var1) {
               field2827.put(var1, (long)this.field2836);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-34"
   )
   void method3512(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3513(var1, var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1227466375"
   )
   void method3513(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field2832 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field2837 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field2833 = 0;
      } else if(var2 == 5) {
         this.field2835 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field2836 = var1.method2843();
      } else if(var2 == 8) {
         this.field2828 = var1.method2843();
      } else if(var2 == 11) {
         this.field2833 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field2839 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "44"
   )
   public SpritePixels method3515() {
      if(this.field2828 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field2827.get((long)this.field2828);
         if(null != var1) {
            return var1;
         } else {
            var1 = class186.method3417(class217.field3170, this.field2828, 0);
            if(null != var1) {
               field2827.put(var1, (long)this.field2828);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BIIIIIII[LCollisionData;B)V",
      garbageValue = "40"
   )
   static final void method3522(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, CollisionData[] var8) {
      int var10;
      for(int var9 = 0; var9 < 8; ++var9) {
         for(var10 = 0; var10 < 8; ++var10) {
            if(var2 + var9 > 0 && var9 + var2 < 103 && var10 + var3 > 0 && var3 + var10 < 103) {
               var8[var1].flags[var9 + var2][var3 + var10] &= -16777217;
            }
         }
      }

      Buffer var13 = new Buffer(var0);

      for(var10 = 0; var10 < 4; ++var10) {
         for(int var11 = 0; var11 < 64; ++var11) {
            for(int var12 = 0; var12 < 64; ++var12) {
               if(var4 == var10 && var11 >= var5 && var11 < var5 + 8 && var12 >= var6 && var12 < var6 + 8) {
                  WidgetNode.method188(var13, var1, var2 + GameEngine.method2195(var11 & 7, var12 & 7, var7), var3 + ChatMessages.method825(var11 & 7, var12 & 7, var7), 0, 0, var7);
               } else {
                  WidgetNode.method188(var13, 0, -1, -1, 0, 0, 0);
               }
            }
         }
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Lclass15;B)V",
      garbageValue = "-125"
   )
   static final void method3526(class15 var0) {
      if(class16.localPlayer.x >> 7 == Client.flagX && class16.localPlayer.y >> 7 == Client.flagY) {
         Client.flagX = 0;
      }

      int var1 = class45.field898;
      int[] var2 = class45.field895;
      int var3 = var1;
      if(class15.field153 == var0 || var0 == class15.field157) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         Player var5;
         int var6;
         if(var0 == class15.field153) {
            var5 = class16.localPlayer;
            var6 = class16.localPlayer.field260 << 14;
         } else if(class15.field157 == var0) {
            var5 = Client.cachedPlayers[Client.field336];
            var6 = Client.field336 << 14;
         } else {
            var5 = Client.cachedPlayers[var2[var4]];
            var6 = var2[var4] << 14;
            if(var0 == class15.field156 && var2[var4] == Client.field336) {
               continue;
            }
         }

         if(null != var5 && var5.vmethod702() && !var5.field266) {
            var5.field256 = false;
            if((Client.field283 && var1 > 50 || var1 > 200) && var0 != class15.field153 && var5.poseAnimation == var5.idlePoseAnimation) {
               var5.field256 = true;
            }

            int var7 = var5.x >> 7;
            int var8 = var5.y >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(null != var5.model && Client.gameCycle >= var5.totalLevel && Client.gameCycle < var5.field247) {
                  var5.field256 = false;
                  var5.field238 = class65.method1153(var5.x, var5.y, WallObject.plane);
                  Renderable.region.method1711(WallObject.plane, var5.x, var5.y, var5.field238, 60, var5, var5.angle, var6, var5.field252, var5.field258, var5.field264, var5.field255);
               } else {
                  if((var5.x & 127) == 64 && (var5.y & 127) == 64) {
                     if(Client.field287[var7][var8] == Client.field524) {
                        continue;
                     }

                     Client.field287[var7][var8] = Client.field524;
                  }

                  var5.field238 = class65.method1153(var5.x, var5.y, WallObject.plane);
                  Renderable.region.method1710(WallObject.plane, var5.x, var5.y, var5.field238, 60, var5, var5.angle, var6, var5.field637);
               }
            }
         }
      }

   }
}
