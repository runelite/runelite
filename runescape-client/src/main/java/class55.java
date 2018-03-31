import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
public class class55 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   @Export("underlay_ref")
   public static IndexDataBase underlay_ref;
   @ObfuscatedName("o")
   @Export("scriptLocalInts")
   static int[] scriptLocalInts;
   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("indexCache3")
   static IndexData indexCache3;

   static {
      ImageIO.setUseCache(false);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "23"
   )
   static void method829() {
      Object var0 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_lock) {
         if(IndexStoreActionHandler.field3389 == 0) {
            IndexStoreActionHandler.IndexStoreActionHandler_thread = new Thread(new IndexStoreActionHandler());
            IndexStoreActionHandler.IndexStoreActionHandler_thread.setDaemon(true);
            IndexStoreActionHandler.IndexStoreActionHandler_thread.start();
            IndexStoreActionHandler.IndexStoreActionHandler_thread.setPriority(5);
         }

         IndexStoreActionHandler.field3389 = 600;
      }
   }

   @ObfuscatedName("gs")
   @ObfuscatedSignature(
      signature = "(Lbg;I)V",
      garbageValue = "-613266263"
   )
   static final void method828(Actor var0) {
      var0.field1181 = false;
      Sequence var1;
      if(var0.poseAnimation != -1) {
         var1 = ISAACCipher.getAnimation(var0.poseAnimation);
         if(var1 != null && var1.frameIDs != null) {
            ++var0.poseFrameCycle;
            if(var0.poseFrame < var1.frameIDs.length && var0.poseFrameCycle > var1.frameLengths[var0.poseFrame]) {
               var0.poseFrameCycle = 1;
               ++var0.poseFrame;
               class38.queueAnimationSound(var1, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var1.frameIDs.length) {
               var0.poseFrameCycle = 0;
               var0.poseFrame = 0;
               class38.queueAnimationSound(var1, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.graphicsDelay) {
         if(var0.spotAnimFrame < 0) {
            var0.spotAnimFrame = 0;
         }

         int var3 = class249.getSpotAnimType(var0.graphic).field3494;
         if(var3 != -1) {
            Sequence var2 = ISAACCipher.getAnimation(var3);
            if(var2 != null && var2.frameIDs != null) {
               ++var0.spotAnimFrameCycle;
               if(var0.spotAnimFrame < var2.frameIDs.length && var0.spotAnimFrameCycle > var2.frameLengths[var0.spotAnimFrame]) {
                  var0.spotAnimFrameCycle = 1;
                  ++var0.spotAnimFrame;
                  class38.queueAnimationSound(var2, var0.spotAnimFrame, var0.x, var0.y);
               }

               if(var0.spotAnimFrame >= var2.frameIDs.length && (var0.spotAnimFrame < 0 || var0.spotAnimFrame >= var2.frameIDs.length)) {
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
         var1 = ISAACCipher.getAnimation(var0.animation);
         if(var1.precedenceAnimating == 1 && var0.field1194 > 0 && var0.field1196 <= Client.gameCycle && var0.field1197 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var1 = ISAACCipher.getAnimation(var0.animation);
         if(var1 != null && var1.frameIDs != null) {
            ++var0.actionFrameCycle;
            if(var0.actionFrame < var1.frameIDs.length && var0.actionFrameCycle > var1.frameLengths[var0.actionFrame]) {
               var0.actionFrameCycle = 1;
               ++var0.actionFrame;
               class38.queueAnimationSound(var1, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var1.frameIDs.length) {
               var0.actionFrame -= var1.frameStep;
               ++var0.field1186;
               if(var0.field1186 >= var1.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var1.frameIDs.length) {
                  class38.queueAnimationSound(var1, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field1181 = var1.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1326421108"
   )
   static final void method827() {
      Client.myPlayerIndex = 0;
      int var0 = (WorldComparator.localPlayer.x >> 7) + PacketNode.baseX;
      int var1 = (WorldComparator.localPlayer.y >> 7) + BaseVarType.baseY;
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         Client.myPlayerIndex = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         Client.myPlayerIndex = 1;
      }

      if(Client.myPlayerIndex == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         Client.myPlayerIndex = 0;
      }

   }
}
