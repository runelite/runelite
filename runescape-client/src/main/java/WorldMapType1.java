import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
@Implements("WorldMapType1")
public class WorldMapType1 implements WorldMapSectionBase {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1595252743
   )
   int field419;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1154799005
   )
   int field427;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 371814645
   )
   int field423;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -480997815
   )
   int field420;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1474279479
   )
   int field426;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1805629475
   )
   int field421;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -797114193
   )
   int field425;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1429930119
   )
   int field431;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1673490843
   )
   int field422;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -270549149
   )
   int field424;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-2141582860"
   )
   public boolean vmethod722(int var1, int var2) {
      return var1 >> 6 >= this.field419 && var1 >> 6 <= this.field423 && var2 >> 6 >= this.field426 && var2 >> 6 <= this.field425;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-1671303044"
   )
   public boolean vmethod721(int var1, int var2, int var3) {
      return var1 >= this.field427 && var1 < this.field427 + this.field420?var2 >> 6 >= this.field421 && var2 >> 6 <= this.field431 && var3 >> 6 >= this.field422 && var3 >> 6 <= this.field424:false;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lam;I)V",
      garbageValue = "-1824757307"
   )
   public void vmethod720(WorldMapData var1) {
      if(var1.field447 > this.field419) {
         var1.field447 = this.field419;
      }

      if(var1.field448 < this.field423) {
         var1.field448 = this.field423;
      }

      if(var1.field441 > this.field426) {
         var1.field441 = this.field426;
      }

      if(var1.field450 < this.field425) {
         var1.field450 = this.field425;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)Lhd;",
      garbageValue = "665140774"
   )
   public Coordinates vmethod743(int var1, int var2) {
      if(!this.vmethod722(var1, var2)) {
         return null;
      } else {
         int var3 = this.field421 * 64 - this.field419 * 64 + var1;
         int var4 = this.field422 * 64 - this.field426 * 64 + var2;
         return new Coordinates(this.field427, var3, var4);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIB)[I",
      garbageValue = "13"
   )
   public int[] vmethod731(int var1, int var2, int var3) {
      if(!this.vmethod721(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field419 * 64 - this.field421 * 64 + var2, var3 + (this.field426 * 64 - this.field422 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lfe;I)V",
      garbageValue = "-1909314997"
   )
   public void vmethod746(Buffer var1) {
      this.field427 = var1.readUnsignedByte();
      this.field420 = var1.readUnsignedByte();
      this.field421 = var1.readUnsignedShort();
      this.field422 = var1.readUnsignedShort();
      this.field431 = var1.readUnsignedShort();
      this.field424 = var1.readUnsignedShort();
      this.field419 = var1.readUnsignedShort();
      this.field426 = var1.readUnsignedShort();
      this.field423 = var1.readUnsignedShort();
      this.field425 = var1.readUnsignedShort();
      this.method247();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1795392731"
   )
   void method247() {
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lif;Ljava/lang/String;Ljava/lang/String;I)[Ljt;",
      garbageValue = "1073091837"
   )
   public static SpritePixels[] method274(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      SpritePixels[] var5;
      if(!IndexData.method4200(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = KitDefinition.method4339();
      }

      return var5;
   }

   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      signature = "(Lca;II)V",
      garbageValue = "-2068043986"
   )
   static final void method272(Actor var0, int var1) {
      int var2;
      int var3;
      int var4;
      if(var0.field1260 > Client.gameCycle) {
         var2 = var0.field1260 - Client.gameCycle;
         var3 = var0.field1256 * 128 + var0.field1218 * 64;
         var4 = var0.field1258 * 128 + var0.field1218 * 64;
         var0.x += (var3 - var0.x) / var2;
         var0.y += (var4 - var0.y) / var2;
         var0.field1272 = 0;
         var0.orientation = var0.field1262;
      } else if(var0.field1261 >= Client.gameCycle) {
         class261.method4647(var0);
      } else {
         WallObject.method2865(var0);
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1260 = 0;
         var0.field1261 = 0;
         var0.x = 128 * var0.pathX[0] + var0.field1218 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1218 * 64;
         var0.method1487();
      }

      if(Script.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1260 = 0;
         var0.field1261 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1218 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1218 * 64;
         var0.method1487();
      }

      if(var0.field1267 != 0) {
         if(var0.interacting != -1) {
            Object var5 = null;
            if(var0.interacting < '耀') {
               var5 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= '耀') {
               var5 = Client.cachedPlayers[var0.interacting - '耀'];
            }

            if(var5 != null) {
               var3 = var0.x - ((Actor)var5).x;
               var4 = var0.y - ((Actor)var5).y;
               if(var3 != 0 || var4 != 0) {
                  var0.orientation = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
               }
            } else if(var0.field1271) {
               var0.interacting = -1;
               var0.field1271 = false;
            }
         }

         if(var0.field1242 != -1 && (var0.queueSize == 0 || var0.field1272 > 0)) {
            var0.orientation = var0.field1242;
            var0.field1242 = -1;
         }

         var2 = var0.orientation - var0.angle & 2047;
         if(var2 == 0 && var0.field1271) {
            var0.interacting = -1;
            var0.field1271 = false;
         }

         if(var2 != 0) {
            ++var0.field1266;
            boolean var7;
            if(var2 > 1024) {
               var0.angle -= var0.field1267;
               var7 = true;
               if(var2 < var0.field1267 || var2 > 2048 - var0.field1267) {
                  var0.angle = var0.orientation;
                  var7 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field1266 > 25 || var7)) {
                  if(var0.field1220 != -1) {
                     var0.poseAnimation = var0.field1220;
                  } else {
                     var0.poseAnimation = var0.field1251;
                  }
               }
            } else {
               var0.angle += var0.field1267;
               var7 = true;
               if(var2 < var0.field1267 || var2 > 2048 - var0.field1267) {
                  var0.angle = var0.orientation;
                  var7 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field1266 > 25 || var7)) {
                  if(var0.field1244 != -1) {
                     var0.poseAnimation = var0.field1244;
                  } else {
                     var0.poseAnimation = var0.field1251;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field1266 = 0;
         }
      }

      var0.field1217 = false;
      Sequence var8;
      if(var0.poseAnimation != -1) {
         var8 = class112.getAnimation(var0.poseAnimation);
         if(var8 != null && var8.frameIDs != null) {
            ++var0.field1245;
            if(var0.poseFrame < var8.frameIDs.length && var0.field1245 > var8.frameLenghts[var0.poseFrame]) {
               var0.field1245 = 1;
               ++var0.poseFrame;
               class11.method58(var8, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var8.frameIDs.length) {
               var0.field1245 = 0;
               var0.poseFrame = 0;
               class11.method58(var8, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.graphicsDelay) {
         if(var0.field1250 < 0) {
            var0.field1250 = 0;
         }

         var2 = InvType.getSpotAnimType(var0.graphic).field3329;
         if(var2 != -1) {
            Sequence var6 = class112.getAnimation(var2);
            if(var6 != null && var6.frameIDs != null) {
               ++var0.field1253;
               if(var0.field1250 < var6.frameIDs.length && var0.field1253 > var6.frameLenghts[var0.field1250]) {
                  var0.field1253 = 1;
                  ++var0.field1250;
                  class11.method58(var6, var0.field1250, var0.x, var0.y);
               }

               if(var0.field1250 >= var6.frameIDs.length && (var0.field1250 < 0 || var0.field1250 >= var6.frameIDs.length)) {
                  var0.graphic = -1;
               }
            } else {
               var0.graphic = -1;
            }
         } else {
            var0.graphic = -1;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable <= 1) {
         var8 = class112.getAnimation(var0.animation);
         if(var8.precedenceAnimating == 1 && var0.field1273 > 0 && var0.field1260 <= Client.gameCycle && var0.field1261 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var8 = class112.getAnimation(var0.animation);
         if(var8 != null && var8.frameIDs != null) {
            ++var0.field1248;
            if(var0.actionFrame < var8.frameIDs.length && var0.field1248 > var8.frameLenghts[var0.actionFrame]) {
               var0.field1248 = 1;
               ++var0.actionFrame;
               class11.method58(var8, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var8.frameIDs.length) {
               var0.actionFrame -= var8.frameStep;
               ++var0.field1259;
               if(var0.field1259 >= var8.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var8.frameIDs.length) {
                  class11.method58(var8, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field1217 = var8.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)Lcx;",
      garbageValue = "51"
   )
   static World method273() {
      World.field1289 = 0;
      World var0;
      if(World.field1289 < World.worldCount) {
         var0 = World.worldList[++World.field1289 - 1];
      } else {
         var0 = null;
      }

      return var0;
   }
}
