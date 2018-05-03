import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
@Implements("BoundingBox3D")
public final class BoundingBox3D extends BoundingBox {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Llh;"
   )
   static IndexedSprite field262;
   @ObfuscatedName("kv")
   @ObfuscatedGetter(
      intValue = 321002613
   )
   static int field261;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -958184897
   )
   @Export("int1")
   final int int1;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1097299581
   )
   @Export("int2")
   final int int2;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 160343437
   )
   @Export("int3")
   final int int3;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -109241221
   )
   @Export("int4")
   final int int4;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -587351037
   )
   @Export("int5")
   final int int5;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1033071523
   )
   @Export("int6")
   final int int6;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1154132085
   )
   @Export("color")
   final int color;

   @ObfuscatedSignature(
      signature = "(Lee;IIII)V"
   )
   public BoundingBox3D(Model var1, int var2, int var3, int var4, int var5) {
      this.int1 = var2 + var1.centerX - var1.extremeX;
      this.int2 = var3 + var1.centerY - var1.extremeY;
      this.int3 = var4 + var1.centerZ - var1.extremeZ;
      this.int4 = var2 + var1.centerX + var1.extremeX;
      this.int5 = var3 + var1.centerY + var1.extremeY;
      this.int6 = var4 + var1.centerZ + var1.extremeZ;
      this.color = var5;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2120397174"
   )
   final void vmethod51() {
      for(int var4 = 0; var4 < 8; ++var4) {
         int var1 = (var4 & 1) == 0?this.int1:this.int4;
         int var2 = (var4 & 2) == 0?this.int2:this.int5;
         int var3 = (var4 & 4) == 0?this.int3:this.int6;
         if((var4 & 1) == 0) {
            class160.method3261(var1, var2, var3, this.int4, var2, var3, this.color);
         }

         if((var4 & 2) == 0) {
            class160.method3261(var1, var2, var3, var1, this.int5, var3, this.color);
         }

         if((var4 & 4) == 0) {
            class160.method3261(var1, var2, var3, var1, var2, this.int6, this.color);
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I[BLfr;I)V",
      garbageValue = "1273028227"
   )
   static void method52(int var0, byte[] var1, IndexFile var2) {
      FileSystem var3 = new FileSystem();
      var3.type = 0;
      var3.hash = (long)var0;
      var3.field3358 = var1;
      var3.index = var2;
      Deque var4 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
         IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.addFront(var3);
      }

      GameCanvas.method835();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-91"
   )
   static int method56(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      return var2 == null?0:(var1 >= 0 && var1 < var2.stackSizes.length?var2.stackSizes[var1]:0);
   }

   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      signature = "(Lbm;IB)V",
      garbageValue = "0"
   )
   static final void method55(Actor var0, int var1) {
      int var2;
      if(var0.field1186 > Client.gameCycle) {
         var2 = var0.field1186 - Client.gameCycle;
         int var3 = var0.field1182 * 128 + var0.field1143 * 64;
         int var4 = var0.field1184 * 128 + var0.field1143 * 64;
         var0.x += (var3 - var0.x) / var2;
         var0.y += (var4 - var0.y) / var2;
         var0.field1192 = 0;
         var0.orientation = var0.field1188;
      } else if(var0.field1139 >= Client.gameCycle) {
         Widget.method4583(var0);
      } else {
         class154.method3229(var0);
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1186 = 0;
         var0.field1139 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1143 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1143 * 64;
         var0.method1707();
      }

      if(class265.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1186 = 0;
         var0.field1139 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1143 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1143 * 64;
         var0.method1707();
      }

      Varcs.method2075(var0);
      var0.field1142 = false;
      Sequence var5;
      if(var0.poseAnimation != -1) {
         var5 = NPC.getAnimation(var0.poseAnimation);
         if(var5 != null && var5.frameIDs != null) {
            ++var0.poseFrameCycle;
            if(var0.poseFrame < var5.frameIDs.length && var0.poseFrameCycle > var5.frameLengths[var0.poseFrame]) {
               var0.poseFrameCycle = 1;
               ++var0.poseFrame;
               Player.queueAnimationSound(var5, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var5.frameIDs.length) {
               var0.poseFrameCycle = 0;
               var0.poseFrame = 0;
               Player.queueAnimationSound(var5, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.graphicsDelay) {
         if(var0.spotAnimFrame < 0) {
            var0.spotAnimFrame = 0;
         }

         var2 = WidgetNode.getSpotAnimType(var0.graphic).field3495;
         if(var2 != -1) {
            Sequence var6 = NPC.getAnimation(var2);
            if(var6 != null && var6.frameIDs != null) {
               ++var0.spotAnimFrameCycle;
               if(var0.spotAnimFrame < var6.frameIDs.length && var0.spotAnimFrameCycle > var6.frameLengths[var0.spotAnimFrame]) {
                  var0.spotAnimFrameCycle = 1;
                  ++var0.spotAnimFrame;
                  Player.queueAnimationSound(var6, var0.spotAnimFrame, var0.x, var0.y);
               }

               if(var0.spotAnimFrame >= var6.frameIDs.length && (var0.spotAnimFrame < 0 || var0.spotAnimFrame >= var6.frameIDs.length)) {
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
         var5 = NPC.getAnimation(var0.animation);
         if(var5.precedenceAnimating == 1 && var0.field1178 > 0 && var0.field1186 <= Client.gameCycle && var0.field1139 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var5 = NPC.getAnimation(var0.animation);
         if(var5 != null && var5.frameIDs != null) {
            ++var0.actionFrameCycle;
            if(var0.actionFrame < var5.frameIDs.length && var0.actionFrameCycle > var5.frameLengths[var0.actionFrame]) {
               var0.actionFrameCycle = 1;
               ++var0.actionFrame;
               Player.queueAnimationSound(var5, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var5.frameIDs.length) {
               var0.actionFrame -= var5.frameStep;
               ++var0.field1176;
               if(var0.field1176 >= var5.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var5.frameIDs.length) {
                  Player.queueAnimationSound(var5, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field1142 = var5.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }
}
