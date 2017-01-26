import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("me")
   static SpritePixels field174;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 945128417
   )
   int field175;
   @ObfuscatedName("x")
   boolean field176 = false;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 666074067
   )
   @Export("id")
   int id;

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "-1303740561"
   )
   static final void method187(Actor var0) {
      var0.field637 = false;
      Sequence var1;
      if(var0.poseAnimation != -1) {
         var1 = class146.getAnimation(var0.poseAnimation);
         if(var1 != null && null != var1.frameIDs) {
            ++var0.field623;
            if(var0.poseFrame < var1.frameIDs.length && var0.field623 > var1.frameLenghts[var0.poseFrame]) {
               var0.field623 = 1;
               ++var0.poseFrame;
               class94.method1912(var1, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var1.frameIDs.length) {
               var0.field623 = 0;
               var0.poseFrame = 0;
               class94.method1912(var1, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.field618) {
         if(var0.field630 < 0) {
            var0.field630 = 0;
         }

         int var3 = TextureProvider.method1452(var0.graphic).field2792;
         if(var3 != -1) {
            Sequence var2 = class146.getAnimation(var3);
            if(null != var2 && null != var2.frameIDs) {
               ++var0.field631;
               if(var0.field630 < var2.frameIDs.length && var0.field631 > var2.frameLenghts[var0.field630]) {
                  var0.field631 = 1;
                  ++var0.field630;
                  class94.method1912(var2, var0.field630, var0.x, var0.y);
               }

               if(var0.field630 >= var2.frameIDs.length && (var0.field630 < 0 || var0.field630 >= var2.frameIDs.length)) {
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
         var1 = class146.getAnimation(var0.animation);
         if(var1.precedenceAnimating == 1 && var0.field651 > 0 && var0.field652 <= Client.gameCycle && var0.field639 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var1 = class146.getAnimation(var0.animation);
         if(var1 != null && var1.frameIDs != null) {
            ++var0.field626;
            if(var0.actionFrame < var1.frameIDs.length && var0.field626 > var1.frameLenghts[var0.actionFrame]) {
               var0.field626 = 1;
               ++var0.actionFrame;
               class94.method1912(var1, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var1.frameIDs.length) {
               var0.actionFrame -= var1.frameStep;
               ++var0.field648;
               if(var0.field648 >= var1.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var1.frameIDs.length) {
                  class94.method1912(var1, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field637 = var1.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIIIIII)V",
      garbageValue = "1082651769"
   )
   static final void method188(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class10.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  class10.tileHeights[0][var2][var3] = -CombatInfoListHolder.method694(var4 + var2 + 932731, var5 + var3 + 556238) * 8;
               } else {
                  class10.tileHeights[var1][var2][var3] = class10.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var8 = var0.readUnsignedByte();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(var1 == 0) {
                  class10.tileHeights[0][var2][var3] = 8 * -var8;
               } else {
                  class10.tileHeights[var1][var2][var3] = class10.tileHeights[var1 - 1][var2][var3] - var8 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class10.overlayIds[var1][var2][var3] = var0.readByte();
               class40.overlayPaths[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class60.overlayRotations[var1][var2][var3] = (byte)(var6 + (var7 - 2) & 3);
            } else if(var7 <= 81) {
               class10.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class10.underlayIds[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.readUnsignedByte();
               break;
            }

            if(var7 <= 49) {
               var0.readUnsignedByte();
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "-651328385"
   )
   public static char method189(char var0) {
      return (char)(var0 == 198?'E':(var0 == 230?'e':(var0 == 223?'s':(var0 == 338?'E':(var0 == 339?'e':'\u0000')))));
   }
}
