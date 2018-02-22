import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public class class131 {
   @ObfuscatedName("ny")
   @ObfuscatedSignature(
      signature = "Llm;"
   )
   @Export("minimapSprite")
   static SpritePixels minimapSprite;
   @ObfuscatedName("op")
   @ObfuscatedGetter(
      intValue = 947061735
   )
   static int field1879;
   @ObfuscatedName("b")
   @Export("Viewport_containsMouse")
   public static boolean Viewport_containsMouse;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 604973281
   )
   @Export("Viewport_mouseX")
   static int Viewport_mouseX;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1055649187
   )
   @Export("Viewport_mouseY")
   static int Viewport_mouseY;
   @ObfuscatedName("p")
   @Export("Viewport_false0")
   static boolean Viewport_false0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1338450831
   )
   static int field1875;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 614568147
   )
   static int field1872;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1480494613
   )
   @Export("Viewport_entityCountAtMouse")
   public static int Viewport_entityCountAtMouse;
   @ObfuscatedName("s")
   @Export("Viewport_entityIdsAtMouse")
   public static int[] Viewport_entityIdsAtMouse;

   static {
      Viewport_containsMouse = false;
      Viewport_mouseX = 0;
      Viewport_mouseY = 0;
      Viewport_false0 = false;
      Viewport_entityCountAtMouse = 0;
      Viewport_entityIdsAtMouse = new int[1000];
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-533735734"
   )
   @Export("ilog")
   public static int ilog(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "(Lbq;II)V",
      garbageValue = "1493862748"
   )
   static final void method2799(Actor var0, int var1) {
      int var2;
      Sequence var11;
      if(var0.field1140 > Client.gameCycle) {
         class54.method810(var0);
      } else {
         int var3;
         int var4;
         int var5;
         int var7;
         if(var0.field1141 >= Client.gameCycle) {
            if(var0.field1141 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.field1133 + 1 > Occluder.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
               var2 = var0.field1141 - var0.field1140;
               var3 = Client.gameCycle - var0.field1140;
               var4 = var0.field1136 * 128 + var0.field1098 * 64;
               var5 = var0.field1108 * 128 + var0.field1098 * 64;
               int var6 = var0.field1137 * 128 + var0.field1098 * 64;
               var7 = var0.field1119 * 128 + var0.field1098 * 64;
               var0.x = (var3 * var6 + var4 * (var2 - var3)) / var2;
               var0.y = (var7 * var3 + var5 * (var2 - var3)) / var2;
            }

            var0.field1128 = 0;
            var0.orientation = var0.field1142;
            var0.angle = var0.orientation;
         } else {
            var0.poseAnimation = var0.idlePoseAnimation;
            if(var0.queueSize == 0) {
               var0.field1128 = 0;
            } else {
               label454: {
                  if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
                     var11 = Occluder.getAnimation(var0.animation);
                     if(var0.field1153 > 0 && var11.precedenceAnimating == 0) {
                        ++var0.field1128;
                        break label454;
                     }

                     if(var0.field1153 <= 0 && var11.priority == 0) {
                        ++var0.field1128;
                        break label454;
                     }
                  }

                  var2 = var0.x;
                  var3 = var0.y;
                  var4 = var0.pathX[var0.queueSize - 1] * 128 + var0.field1098 * 64;
                  var5 = var0.pathY[var0.queueSize - 1] * 128 + var0.field1098 * 64;
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

                     int var8 = var0.field1099;
                     if(var7 >= -256 && var7 <= 256) {
                        var8 = var0.field1102;
                     } else if(var7 >= 256 && var7 < 768) {
                        var8 = var0.field1105;
                     } else if(var7 >= -768 && var7 <= -256) {
                        var8 = var0.field1130;
                     }

                     if(var8 == -1) {
                        var8 = var0.field1102;
                     }

                     var0.poseAnimation = var8;
                     int var9 = 4;
                     boolean var10 = true;
                     if(var0 instanceof NPC) {
                        var10 = ((NPC)var0).composition.isClickable;
                     }

                     if(var10) {
                        if(var0.orientation != var0.angle && var0.interacting == -1 && var0.field1147 != 0) {
                           var9 = 2;
                        }

                        if(var0.queueSize > 2) {
                           var9 = 6;
                        }

                        if(var0.queueSize > 3) {
                           var9 = 8;
                        }

                        if(var0.field1128 > 0 && var0.queueSize > 1) {
                           var9 = 8;
                           --var0.field1128;
                        }
                     } else {
                        if(var0.queueSize > 1) {
                           var9 = 6;
                        }

                        if(var0.queueSize > 2) {
                           var9 = 8;
                        }

                        if(var0.field1128 > 0 && var0.queueSize > 1) {
                           var9 = 8;
                           --var0.field1128;
                        }
                     }

                     if(var13 == 2) {
                        var9 <<= 1;
                     }

                     if(var9 >= 8 && var0.poseAnimation == var0.field1102 && var0.field1106 != -1) {
                        var0.poseAnimation = var0.field1106;
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
                        if(var0.field1153 > 0) {
                           --var0.field1153;
                        }
                     }
                  } else {
                     var0.x = var4;
                     var0.y = var5;
                     --var0.queueSize;
                     if(var0.field1153 > 0) {
                        --var0.field1153;
                     }
                  }
               }
            }
         }
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1140 = 0;
         var0.field1141 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1098 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1098 * 64;
         var0.method1619();
      }

      if(OwnWorldComparator.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1140 = 0;
         var0.field1141 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1098 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1098 * 64;
         var0.method1619();
      }

      TextureProvider.method2584(var0);
      var0.field1097 = false;
      if(var0.poseAnimation != -1) {
         var11 = Occluder.getAnimation(var0.poseAnimation);
         if(var11 != null && var11.frameIDs != null) {
            ++var0.field1125;
            if(var0.poseFrame < var11.frameIDs.length && var0.field1125 > var11.frameLenghts[var0.poseFrame]) {
               var0.field1125 = 1;
               ++var0.poseFrame;
               class242.queueAnimationSound(var11, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var11.frameIDs.length) {
               var0.field1125 = 0;
               var0.poseFrame = 0;
               class242.queueAnimationSound(var11, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.graphicsDelay) {
         if(var0.field1104 < 0) {
            var0.field1104 = 0;
         }

         var2 = IndexFile.getSpotAnimType(var0.graphic).field3425;
         if(var2 != -1) {
            Sequence var12 = Occluder.getAnimation(var2);
            if(var12 != null && var12.frameIDs != null) {
               ++var0.field1144;
               if(var0.field1104 < var12.frameIDs.length && var0.field1144 > var12.frameLenghts[var0.field1104]) {
                  var0.field1144 = 1;
                  ++var0.field1104;
                  class242.queueAnimationSound(var12, var0.field1104, var0.x, var0.y);
               }

               if(var0.field1104 >= var12.frameIDs.length && (var0.field1104 < 0 || var0.field1104 >= var12.frameIDs.length)) {
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
         var11 = Occluder.getAnimation(var0.animation);
         if(var11.precedenceAnimating == 1 && var0.field1153 > 0 && var0.field1140 <= Client.gameCycle && var0.field1141 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var11 = Occluder.getAnimation(var0.animation);
         if(var11 != null && var11.frameIDs != null) {
            ++var0.field1133;
            if(var0.actionFrame < var11.frameIDs.length && var0.field1133 > var11.frameLenghts[var0.actionFrame]) {
               var0.field1133 = 1;
               ++var0.actionFrame;
               class242.queueAnimationSound(var11, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var11.frameIDs.length) {
               var0.actionFrame -= var11.frameStep;
               ++var0.field1094;
               if(var0.field1094 >= var11.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var11.frameIDs.length) {
                  class242.queueAnimationSound(var11, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field1097 = var11.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }
}
