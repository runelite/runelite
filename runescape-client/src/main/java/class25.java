import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
public class class25 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = -8394620482907176967L
   )
   public static long field351;
   @ObfuscatedName("s")
   static byte[][][] field352;
   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   static Widget field349;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1660631651
   )
   int field347;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   Coordinates field346;

   @ObfuscatedSignature(
      signature = "(ILhn;)V"
   )
   class25(int var1, Coordinates var2) {
      this.field347 = var1;
      this.field346 = var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "0"
   )
   static final void method189(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = Math.min(var3, Math.min(var4, var5)) - var6;
      int var8 = Math.max(var3, Math.max(var4, var5)) + var6;
      int var9 = Math.min(var0, Math.min(var1, var2)) - var6;
      int var10 = Math.max(var0, Math.max(var1, var2)) + var6;
      class7.boundingBoxes.addFirst(new BoundingBox2D(var7, var9, var8, var10, -49088));
   }

   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      signature = "(Lbx;IB)V",
      garbageValue = "4"
   )
   static final void method190(Actor var0, int var1) {
      int var2;
      Sequence var11;
      if(var0.field1143 > Client.gameCycle) {
         ContextMenuRow.method1848(var0);
      } else {
         int var3;
         int var4;
         int var5;
         int var7;
         if(var0.field1107 >= Client.gameCycle) {
            if(var0.field1107 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.field1123 + 1 > CacheFile.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
               var2 = var0.field1107 - var0.field1143;
               var3 = Client.gameCycle - var0.field1143;
               var4 = var0.field1120 * 128 + var0.field1127 * 64;
               var5 = var0.field1141 * 128 + var0.field1127 * 64;
               int var6 = var0.field1140 * 128 + var0.field1127 * 64;
               var7 = var0.field1142 * 128 + var0.field1127 * 64;
               var0.x = (var3 * var6 + var4 * (var2 - var3)) / var2;
               var0.y = (var7 * var3 + var5 * (var2 - var3)) / var2;
            }

            var0.field1136 = 0;
            var0.orientation = var0.field1145;
            var0.angle = var0.orientation;
         } else {
            var0.poseAnimation = var0.idlePoseAnimation;
            if(var0.queueSize == 0) {
               var0.field1136 = 0;
            } else {
               label461: {
                  if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
                     var11 = CacheFile.getAnimation(var0.animation);
                     if(var0.field1156 > 0 && var11.precedenceAnimating == 0) {
                        ++var0.field1136;
                        break label461;
                     }

                     if(var0.field1156 <= 0 && var11.priority == 0) {
                        ++var0.field1136;
                        break label461;
                     }
                  }

                  var2 = var0.x;
                  var3 = var0.y;
                  var4 = var0.pathX[var0.queueSize - 1] * 128 + var0.field1127 * 64;
                  var5 = var0.pathY[var0.queueSize - 1] * 128 + var0.field1127 * 64;
                  if(var2 < var4) {
                     if(var3 < var5) {
                        var0.orientation = 1280;
                     } else if(var3 > var5) {
                        var0.orientation = 1792;
                     } else {
                        var0.orientation = 1536;
                     }
                  } else if(var2 > var4) {
                     if(var3 < var5) {
                        var0.orientation = 768;
                     } else if(var3 > var5) {
                        var0.orientation = 256;
                     } else {
                        var0.orientation = 512;
                     }
                  } else if(var3 < var5) {
                     var0.orientation = 1024;
                  } else if(var3 > var5) {
                     var0.orientation = 0;
                  }

                  byte var13 = var0.pathTraversed[var0.queueSize - 1];
                  if(var4 - var2 <= 256 && var4 - var2 >= -256 && var5 - var3 <= 256 && var5 - var3 >= -256) {
                     var7 = var0.orientation - var0.angle & 2047;
                     if(var7 > 1024) {
                        var7 -= 2048;
                     }

                     int var8 = var0.field1144;
                     if(var7 >= -256 && var7 <= 256) {
                        var8 = var0.field1105;
                     } else if(var7 >= 256 && var7 < 768) {
                        var8 = var0.field1108;
                     } else if(var7 >= -768 && var7 <= -256) {
                        var8 = var0.field1104;
                     }

                     if(var8 == -1) {
                        var8 = var0.field1105;
                     }

                     var0.poseAnimation = var8;
                     int var9 = 4;
                     boolean var10 = true;
                     if(var0 instanceof NPC) {
                        var10 = ((NPC)var0).composition.isClickable;
                     }

                     if(var10) {
                        if(var0.orientation != var0.angle && var0.interacting == -1 && var0.field1150 != 0) {
                           var9 = 2;
                        }

                        if(var0.queueSize > 2) {
                           var9 = 6;
                        }

                        if(var0.queueSize > 3) {
                           var9 = 8;
                        }

                        if(var0.field1136 > 0 && var0.queueSize > 1) {
                           var9 = 8;
                           --var0.field1136;
                        }
                     } else {
                        if(var0.queueSize > 1) {
                           var9 = 6;
                        }

                        if(var0.queueSize > 2) {
                           var9 = 8;
                        }

                        if(var0.field1136 > 0 && var0.queueSize > 1) {
                           var9 = 8;
                           --var0.field1136;
                        }
                     }

                     if(var13 == 2) {
                        var9 <<= 1;
                     }

                     if(var9 >= 8 && var0.poseAnimation == var0.field1105 && var0.field1109 != -1) {
                        var0.poseAnimation = var0.field1109;
                     }

                     if(var2 != var4 || var5 != var3) {
                        if(var2 < var4) {
                           var0.x += var9;
                           if(var0.x > var4) {
                              var0.x = var4;
                           }
                        } else if(var2 > var4) {
                           var0.x -= var9;
                           if(var0.x < var4) {
                              var0.x = var4;
                           }
                        }

                        if(var3 < var5) {
                           var0.y += var9;
                           if(var0.y > var5) {
                              var0.y = var5;
                           }
                        } else if(var3 > var5) {
                           var0.y -= var9;
                           if(var0.y < var5) {
                              var0.y = var5;
                           }
                        }
                     }

                     if(var4 == var0.x && var5 == var0.y) {
                        --var0.queueSize;
                        if(var0.field1156 > 0) {
                           --var0.field1156;
                        }
                     }
                  } else {
                     var0.x = var4;
                     var0.y = var5;
                     --var0.queueSize;
                     if(var0.field1156 > 0) {
                        --var0.field1156;
                     }
                  }
               }
            }
         }
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1143 = 0;
         var0.field1107 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1127 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1127 * 64;
         var0.method1580();
      }

      if(class36.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1143 = 0;
         var0.field1107 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1127 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1127 * 64;
         var0.method1580();
      }

      class46.method695(var0);
      var0.field1132 = false;
      if(var0.poseAnimation != -1) {
         var11 = CacheFile.getAnimation(var0.poseAnimation);
         if(var11 != null && var11.frameIDs != null) {
            ++var0.field1155;
            if(var0.poseFrame < var11.frameIDs.length && var0.field1155 > var11.frameLenghts[var0.poseFrame]) {
               var0.field1155 = 1;
               ++var0.poseFrame;
               WorldMapData.queueAnimationSound(var11, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var11.frameIDs.length) {
               var0.field1155 = 0;
               var0.poseFrame = 0;
               WorldMapData.queueAnimationSound(var11, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.graphicsDelay) {
         if(var0.field1135 < 0) {
            var0.field1135 = 0;
         }

         var2 = GrandExchangeEvents.getSpotAnimType(var0.graphic).field3395;
         if(var2 != -1) {
            Sequence var12 = CacheFile.getAnimation(var2);
            if(var12 != null && var12.frameIDs != null) {
               ++var0.field1131;
               if(var0.field1135 < var12.frameIDs.length && var0.field1131 > var12.frameLenghts[var0.field1135]) {
                  var0.field1131 = 1;
                  ++var0.field1135;
                  WorldMapData.queueAnimationSound(var12, var0.field1135, var0.x, var0.y);
               }

               if(var0.field1135 >= var12.frameIDs.length && (var0.field1135 < 0 || var0.field1135 >= var12.frameIDs.length)) {
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
         var11 = CacheFile.getAnimation(var0.animation);
         if(var11.precedenceAnimating == 1 && var0.field1156 > 0 && var0.field1143 <= Client.gameCycle && var0.field1107 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var11 = CacheFile.getAnimation(var0.animation);
         if(var11 != null && var11.frameIDs != null) {
            ++var0.field1123;
            if(var0.actionFrame < var11.frameIDs.length && var0.field1123 > var11.frameLenghts[var0.actionFrame]) {
               var0.field1123 = 1;
               ++var0.actionFrame;
               WorldMapData.queueAnimationSound(var11, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var11.frameIDs.length) {
               var0.actionFrame -= var11.frameStep;
               ++var0.field1133;
               if(var0.field1133 >= var11.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var11.frameIDs.length) {
                  WorldMapData.queueAnimationSound(var11, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field1132 = var11.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }
}
