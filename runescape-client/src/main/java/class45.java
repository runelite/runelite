import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public class class45 extends WorldMapData {
   @ObfuscatedName("qf")
   static short[] field578;
   @ObfuscatedName("eb")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   @Export("urlRequester")
   static UrlRequester urlRequester;
   @ObfuscatedName("kn")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   static Widget field579;
   @ObfuscatedName("t")
   HashSet field574;
   @ObfuscatedName("i")
   HashSet field575;
   @ObfuscatedName("u")
   List field576;

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(Lgy;Lgy;Lgy;IZI)V",
      garbageValue = "1806423251"
   )
   void method632(Buffer var1, Buffer var2, Buffer var3, int var4, boolean var5) {
      this.loadMapData(var1, var4);
      int var6 = var3.readUnsignedShort();
      this.field574 = new HashSet(var6);

      int var7;
      for(var7 = 0; var7 < var6; ++var7) {
         class22 var8 = new class22();

         try {
            var8.method164(var2, var3);
         } catch (IllegalStateException var13) {
            continue;
         }

         this.field574.add(var8);
      }

      var7 = var3.readUnsignedShort();
      this.field575 = new HashSet(var7);

      for(int var11 = 0; var11 < var7; ++var11) {
         class46 var9 = new class46();

         try {
            var9.method641(var2, var3);
         } catch (IllegalStateException var12) {
            continue;
         }

         this.field575.add(var9);
      }

      this.method631(var2, var5);
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(Lgy;ZS)V",
      garbageValue = "4114"
   )
   void method631(Buffer var1, boolean var2) {
      this.field576 = new LinkedList();
      int var3 = var1.readUnsignedShort();

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var1.method3617();
         Coordinates var6 = new Coordinates(var1.readInt());
         boolean var7 = var1.readUnsignedByte() == 1;
         if(var2 || !var7) {
            this.field576.add(new class25(var5, var6));
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljk;IIS)Lly;",
      garbageValue = "-3964"
   )
   public static SpritePixels method640(IndexDataBase var0, int var1, int var2) {
      return !AbstractByteBuffer.method3843(var0, var1, var2)?null:class46.method666();
   }

   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "(Lbk;I)V",
      garbageValue = "2048935719"
   )
   static final void method639(Actor var0) {
      var0.field1141 = false;
      Sequence var1;
      if(var0.poseAnimation != -1) {
         var1 = class270.getAnimation(var0.poseAnimation);
         if(var1 != null && var1.frameIDs != null) {
            ++var0.field1170;
            if(var0.poseFrame < var1.frameIDs.length && var0.field1170 > var1.frameLenghts[var0.poseFrame]) {
               var0.field1170 = 1;
               ++var0.poseFrame;
               class41.queueAnimationSound(var1, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var1.frameIDs.length) {
               var0.field1170 = 0;
               var0.poseFrame = 0;
               class41.queueAnimationSound(var1, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.graphicsDelay) {
         if(var0.field1177 < 0) {
            var0.field1177 = 0;
         }

         int var3 = class55.getSpotAnimType(var0.graphic).field3484;
         if(var3 != -1) {
            Sequence var2 = class270.getAnimation(var3);
            if(var2 != null && var2.frameIDs != null) {
               ++var0.field1178;
               if(var0.field1177 < var2.frameIDs.length && var0.field1178 > var2.frameLenghts[var0.field1177]) {
                  var0.field1178 = 1;
                  ++var0.field1177;
                  class41.queueAnimationSound(var2, var0.field1177, var0.x, var0.y);
               }

               if(var0.field1177 >= var2.frameIDs.length && (var0.field1177 < 0 || var0.field1177 >= var2.frameIDs.length)) {
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
         var1 = class270.getAnimation(var0.animation);
         if(var1.precedenceAnimating == 1 && var0.field1198 > 0 && var0.field1188 <= Client.gameCycle && var0.field1186 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var1 = class270.getAnimation(var0.animation);
         if(var1 != null && var1.frameIDs != null) {
            ++var0.field1173;
            if(var0.actionFrame < var1.frameIDs.length && var0.field1173 > var1.frameLenghts[var0.actionFrame]) {
               var0.field1173 = 1;
               ++var0.actionFrame;
               class41.queueAnimationSound(var1, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var1.frameIDs.length) {
               var0.actionFrame -= var1.frameStep;
               ++var0.field1175;
               if(var0.field1175 >= var1.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var1.frameIDs.length) {
                  class41.queueAnimationSound(var1, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field1141 = var1.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "(III)Ljava/lang/String;",
      garbageValue = "-1858350594"
   )
   static final String method634(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?IndexFile.getColTags(16711680):(var2 < -6?IndexFile.getColTags(16723968):(var2 < -3?IndexFile.getColTags(16740352):(var2 < 0?IndexFile.getColTags(16756736):(var2 > 9?IndexFile.getColTags(65280):(var2 > 6?IndexFile.getColTags(4259584):(var2 > 3?IndexFile.getColTags(8453888):(var2 > 0?IndexFile.getColTags(12648192):IndexFile.getColTags(16776960))))))));
   }
}
