import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public class class25 {
   @ObfuscatedName("ba")
   @Export("sessionToken")
   static String sessionToken;
   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "[Ljx;"
   )
   static IndexedSprite[] field383;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1661922999
   )
   int field381;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   Coordinates field378;

   @ObfuscatedSignature(
      signature = "(ILhs;)V"
   )
   class25(int var1, Coordinates var2) {
      this.field381 = var1;
      this.field378 = var2;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(CII)Ljava/lang/String;",
      garbageValue = "2124075832"
   )
   static String method209(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILhp;B)I",
      garbageValue = "-3"
   )
   public static int method206(int var0, class220 var1) {
      return (var0 << 8) + var1.field2806;
   }

   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      signature = "(Lbk;B)V",
      garbageValue = "-103"
   )
   static final void method210(PendingSpawn var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.type == 0) {
         var1 = ScriptState.region.method2896(var0.level, var0.x, var0.y);
      }

      if(var0.type == 1) {
         var1 = ScriptState.region.method2739(var0.level, var0.x, var0.y);
      }

      if(var0.type == 2) {
         var1 = ScriptState.region.method2875(var0.level, var0.x, var0.y);
      }

      if(var0.type == 3) {
         var1 = ScriptState.region.method2762(var0.level, var0.x, var0.y);
      }

      if(var1 != 0) {
         int var5 = ScriptState.region.method2741(var0.level, var0.x, var0.y, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field1227 = var2;
      var0.field1212 = var3;
      var0.field1221 = var4;
   }

   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "(Lbg;S)V",
      garbageValue = "29985"
   )
   static final void method207(Actor var0) {
      var0.field1284 = false;
      Sequence var1;
      if(var0.poseAnimation != -1) {
         var1 = class216.getAnimation(var0.poseAnimation);
         if(var1 != null && var1.frameIDs != null) {
            ++var0.field1273;
            if(var0.poseFrame < var1.frameIDs.length && var0.field1273 > var1.frameLenghts[var0.poseFrame]) {
               var0.field1273 = 1;
               ++var0.poseFrame;
               SceneTilePaint.method2705(var1, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var1.frameIDs.length) {
               var0.field1273 = 0;
               var0.poseFrame = 0;
               SceneTilePaint.method2705(var1, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.graphicsDelay) {
         if(var0.field1267 < 0) {
            var0.field1267 = 0;
         }

         int var3 = class15.getSpotAnimType(var0.graphic).field3332;
         if(var3 != -1) {
            Sequence var2 = class216.getAnimation(var3);
            if(var2 != null && var2.frameIDs != null) {
               ++var0.field1240;
               if(var0.field1267 < var2.frameIDs.length && var0.field1240 > var2.frameLenghts[var0.field1267]) {
                  var0.field1240 = 1;
                  ++var0.field1267;
                  SceneTilePaint.method2705(var2, var0.field1267, var0.x, var0.y);
               }

               if(var0.field1267 >= var2.frameIDs.length && (var0.field1267 < 0 || var0.field1267 >= var2.frameIDs.length)) {
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
         var1 = class216.getAnimation(var0.animation);
         if(var1.precedenceAnimating == 1 && var0.field1249 > 0 && var0.field1275 <= Client.gameCycle && var0.field1276 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var1 = class216.getAnimation(var0.animation);
         if(var1 != null && var1.frameIDs != null) {
            ++var0.field1263;
            if(var0.actionFrame < var1.frameIDs.length && var0.field1263 > var1.frameLenghts[var0.actionFrame]) {
               var0.field1263 = 1;
               ++var0.actionFrame;
               SceneTilePaint.method2705(var1, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var1.frameIDs.length) {
               var0.actionFrame -= var1.frameStep;
               ++var0.field1265;
               if(var0.field1265 >= var1.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var1.frameIDs.length) {
                  SceneTilePaint.method2705(var1, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field1284 = var1.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("jz")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "112"
   )
   static final void method208(String var0) {
      if(var0 != null) {
         if((Client.friendCount < 200 || Client.field1053 == 1) && Client.friendCount < 400) {
            String var1 = Frames.method2925(var0, class8.field243);
            if(var1 != null) {
               int var2;
               String var4;
               String var5;
               for(var2 = 0; var2 < Client.friendCount; ++var2) {
                  Friend var3 = Client.friends[var2];
                  var4 = Frames.method2925(var3.name, class8.field243);
                  if(var4 != null && var4.equals(var1)) {
                     Client.sendGameMessage(30, "", var0 + " is already on your friend list");
                     return;
                  }

                  if(var3.previousName != null) {
                     var5 = Frames.method2925(var3.previousName, class8.field243);
                     if(var5 != null && var5.equals(var1)) {
                        Client.sendGameMessage(30, "", var0 + " is already on your friend list");
                        return;
                     }
                  }
               }

               for(var2 = 0; var2 < Client.ignoreCount; ++var2) {
                  Ignore var6 = Client.ignores[var2];
                  var4 = Frames.method2925(var6.name, class8.field243);
                  if(var4 != null && var4.equals(var1)) {
                     Client.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                     return;
                  }

                  if(var6.previousName != null) {
                     var5 = Frames.method2925(var6.previousName, class8.field243);
                     if(var5 != null && var5.equals(var1)) {
                        Client.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                        return;
                     }
                  }
               }

               if(Frames.method2925(Player.localPlayer.name, class8.field243).equals(var1)) {
                  Client.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
               } else {
                  Client.secretPacketBuffer1.putOpcode(254);
                  Client.secretPacketBuffer1.putByte(ClanMember.getLength(var0));
                  Client.secretPacketBuffer1.putString(var0);
               }
            }
         } else {
            Client.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
         }
      }
   }
}
