import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class33 extends WorldMapData {
   @ObfuscatedName("s")
   HashSet field292;
   @ObfuscatedName("p")
   HashSet field293;
   @ObfuscatedName("g")
   List field291;

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(Lgy;Lgy;Lgy;IZI)V",
      garbageValue = "-2045505294"
   )
   void method603(Buffer var1, Buffer var2, Buffer var3, int var4, boolean var5) {
      this.loadMapData(var1, var4);
      int var6 = var3.readUnsignedShort();
      this.field292 = new HashSet(var6);

      int var7;
      for(var7 = 0; var7 < var6; ++var7) {
         class10 var8 = new class10();

         try {
            var8.method104(var2, var3);
         } catch (IllegalStateException var13) {
            continue;
         }

         this.field292.add(var8);
      }

      var7 = var3.readUnsignedShort();
      this.field293 = new HashSet(var7);

      for(int var11 = 0; var11 < var7; ++var11) {
         class34 var9 = new class34();

         try {
            var9.method611(var2, var3);
         } catch (IllegalStateException var12) {
            continue;
         }

         this.field293.add(var9);
      }

      this.method604(var2, var5);
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(Lgy;ZI)V",
      garbageValue = "1936398162"
   )
   void method604(Buffer var1, boolean var2) {
      this.field291 = new LinkedList();
      int var3 = var1.readUnsignedShort();

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var1.method3585();
         Coordinates var6 = new Coordinates(var1.readInt());
         boolean var7 = var1.readUnsignedByte() == 1;
         if(var2 || !var7) {
            this.field291.add(new class13(var5, var6));
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1331195192"
   )
   static void method608(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      FileRequest var4 = (FileRequest)class250.NetCache_pendingWrites.get(var2);
      if(var4 != null) {
         class250.NetCache_pendingWritesQueue.setHead(var4);
      }
   }

   @ObfuscatedName("gi")
   @ObfuscatedSignature(
      signature = "(Lbs;I)V",
      garbageValue = "1744977178"
   )
   static final void method605(Actor var0) {
      var0.field884 = false;
      Sequence var1;
      if(var0.poseAnimation != -1) {
         var1 = class137.getAnimation(var0.poseAnimation);
         if(var1 != null && var1.frameIDs != null) {
            ++var0.poseFrameCycle;
            if(var0.poseFrame < var1.frameIDs.length && var0.poseFrameCycle > var1.frameLengths[var0.poseFrame]) {
               var0.poseFrameCycle = 1;
               ++var0.poseFrame;
               class173.queueAnimationSound(var1, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var1.frameIDs.length) {
               var0.poseFrameCycle = 0;
               var0.poseFrame = 0;
               class173.queueAnimationSound(var1, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.graphicsDelay) {
         if(var0.spotAnimFrame < 0) {
            var0.spotAnimFrame = 0;
         }

         int var3 = ScriptState.getSpotAnimType(var0.graphic).field3292;
         if(var3 != -1) {
            Sequence var2 = class137.getAnimation(var3);
            if(var2 != null && var2.frameIDs != null) {
               ++var0.spotAnimFrameCycle;
               if(var0.spotAnimFrame < var2.frameIDs.length && var0.spotAnimFrameCycle > var2.frameLengths[var0.spotAnimFrame]) {
                  var0.spotAnimFrameCycle = 1;
                  ++var0.spotAnimFrame;
                  class173.queueAnimationSound(var2, var0.spotAnimFrame, var0.x, var0.y);
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
         var1 = class137.getAnimation(var0.animation);
         if(var1.precedenceAnimating == 1 && var0.field942 > 0 && var0.field896 <= Client.gameCycle && var0.field901 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var1 = class137.getAnimation(var0.animation);
         if(var1 != null && var1.frameIDs != null) {
            ++var0.actionFrameCycle;
            if(var0.actionFrame < var1.frameIDs.length && var0.actionFrameCycle > var1.frameLengths[var0.actionFrame]) {
               var0.actionFrameCycle = 1;
               ++var0.actionFrame;
               class173.queueAnimationSound(var1, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var1.frameIDs.length) {
               var0.actionFrame -= var1.frameStep;
               ++var0.field919;
               if(var0.field919 >= var1.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var1.frameIDs.length) {
                  class173.queueAnimationSound(var1, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field884 = var1.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }
}
