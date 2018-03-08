import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
@Implements("MapCacheArchiveNames")
public class MapCacheArchiveNames {
   @ObfuscatedName("pp")
   @ObfuscatedSignature(
      signature = "Ldt;"
   )
   static Resampler field523;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lat;"
   )
   @Export("DETAILS")
   public static final MapCacheArchiveNames DETAILS;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lat;"
   )
   @Export("COMPOSITE_MAP")
   public static final MapCacheArchiveNames COMPOSITE_MAP;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lat;"
   )
   @Export("COMPOSITE_TEXTURE")
   public static final MapCacheArchiveNames COMPOSITE_TEXTURE;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lat;"
   )
   @Export("AREA")
   public static final MapCacheArchiveNames AREA;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lat;"
   )
   @Export("LABELS")
   public static final MapCacheArchiveNames LABELS;
   @ObfuscatedName("b")
   @Export("name")
   public final String name;

   static {
      DETAILS = new MapCacheArchiveNames("details");
      COMPOSITE_MAP = new MapCacheArchiveNames("compositemap");
      COMPOSITE_TEXTURE = new MapCacheArchiveNames("compositetexture");
      AREA = new MapCacheArchiveNames("area");
      LABELS = new MapCacheArchiveNames("labels");
   }

   MapCacheArchiveNames(String var1) {
      this.name = var1;
   }

   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "(Lbw;II)V",
      garbageValue = "-1989447678"
   )
   static final void method592(Actor var0, int var1) {
      int var2;
      Sequence var11;
      if(var0.field1183 > Client.gameCycle) {
         BoundingBox3DDrawMode.method61(var0);
      } else {
         int var3;
         int var4;
         int var5;
         int var7;
         if(var0.field1184 >= Client.gameCycle) {
            if(var0.field1184 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.field1140 + 1 > class158.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
               var2 = var0.field1184 - var0.field1183;
               var3 = Client.gameCycle - var0.field1183;
               var4 = var0.field1159 * 128 + var0.field1139 * 64;
               var5 = var0.field1181 * 128 + var0.field1139 * 64;
               int var6 = var0.field1146 * 128 + var0.field1139 * 64;
               var7 = var0.field1182 * 128 + var0.field1139 * 64;
               var0.x = (var3 * var6 + var4 * (var2 - var3)) / var2;
               var0.y = (var7 * var3 + var5 * (var2 - var3)) / var2;
            }

            var0.field1195 = 0;
            var0.orientation = var0.field1185;
            var0.angle = var0.orientation;
         } else {
            var0.poseAnimation = var0.idlePoseAnimation;
            if(var0.queueSize == 0) {
               var0.field1195 = 0;
            } else {
               label465: {
                  if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
                     var11 = class158.getAnimation(var0.animation);
                     if(var0.field1196 > 0 && var11.precedenceAnimating == 0) {
                        ++var0.field1195;
                        break label465;
                     }

                     if(var0.field1196 <= 0 && var11.priority == 0) {
                        ++var0.field1195;
                        break label465;
                     }
                  }

                  var2 = var0.x;
                  var3 = var0.y;
                  var4 = var0.pathX[var0.queueSize - 1] * 128 + var0.field1139 * 64;
                  var5 = var0.pathY[var0.queueSize - 1] * 128 + var0.field1139 * 64;
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

                     int var8 = var0.field1158;
                     if(var7 >= -256 && var7 <= 256) {
                        var8 = var0.field1145;
                     } else if(var7 >= 256 && var7 < 768) {
                        var8 = var0.field1148;
                     } else if(var7 >= -768 && var7 <= -256) {
                        var8 = var0.field1147;
                     }

                     if(var8 == -1) {
                        var8 = var0.field1145;
                     }

                     var0.poseAnimation = var8;
                     int var9 = 4;
                     boolean var10 = true;
                     if(var0 instanceof NPC) {
                        var10 = ((NPC)var0).composition.isClickable;
                     }

                     if(var10) {
                        if(var0.angle != var0.orientation && var0.interacting == -1 && var0.field1190 != 0) {
                           var9 = 2;
                        }

                        if(var0.queueSize > 2) {
                           var9 = 6;
                        }

                        if(var0.queueSize > 3) {
                           var9 = 8;
                        }

                        if(var0.field1195 > 0 && var0.queueSize > 1) {
                           var9 = 8;
                           --var0.field1195;
                        }
                     } else {
                        if(var0.queueSize > 1) {
                           var9 = 6;
                        }

                        if(var0.queueSize > 2) {
                           var9 = 8;
                        }

                        if(var0.field1195 > 0 && var0.queueSize > 1) {
                           var9 = 8;
                           --var0.field1195;
                        }
                     }

                     if(var13 == 2) {
                        var9 <<= 1;
                     }

                     if(var9 >= 8 && var0.field1145 == var0.poseAnimation && var0.field1194 != -1) {
                        var0.poseAnimation = var0.field1194;
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
                        if(var0.field1196 > 0) {
                           --var0.field1196;
                        }
                     }
                  } else {
                     var0.x = var4;
                     var0.y = var5;
                     --var0.queueSize;
                     if(var0.field1196 > 0) {
                        --var0.field1196;
                     }
                  }
               }
            }
         }
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1183 = 0;
         var0.field1184 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1139 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1139 * 64;
         var0.method1651();
      }

      if(WorldMapData.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1183 = 0;
         var0.field1184 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1139 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1139 * 64;
         var0.method1651();
      }

      method593(var0);
      var0.field1165 = false;
      if(var0.poseAnimation != -1) {
         var11 = class158.getAnimation(var0.poseAnimation);
         if(var11 != null && var11.frameIDs != null) {
            ++var0.field1168;
            if(var0.poseFrame < var11.frameIDs.length && var0.field1168 > var11.frameLenghts[var0.poseFrame]) {
               var0.field1168 = 1;
               ++var0.poseFrame;
               class150.queueAnimationSound(var11, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var11.frameIDs.length) {
               var0.field1168 = 0;
               var0.poseFrame = 0;
               class150.queueAnimationSound(var11, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.graphicsDelay) {
         if(var0.field1175 < 0) {
            var0.field1175 = 0;
         }

         var2 = MapLabel.getSpotAnimType(var0.graphic).field3494;
         if(var2 != -1) {
            Sequence var12 = class158.getAnimation(var2);
            if(var12 != null && var12.frameIDs != null) {
               ++var0.field1176;
               if(var0.field1175 < var12.frameIDs.length && var0.field1176 > var12.frameLenghts[var0.field1175]) {
                  var0.field1176 = 1;
                  ++var0.field1175;
                  class150.queueAnimationSound(var12, var0.field1175, var0.x, var0.y);
               }

               if(var0.field1175 >= var12.frameIDs.length && (var0.field1175 < 0 || var0.field1175 >= var12.frameIDs.length)) {
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
         var11 = class158.getAnimation(var0.animation);
         if(var11.precedenceAnimating == 1 && var0.field1196 > 0 && var0.field1183 <= Client.gameCycle && var0.field1184 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var11 = class158.getAnimation(var0.animation);
         if(var11 != null && var11.frameIDs != null) {
            ++var0.field1140;
            if(var0.actionFrame < var11.frameIDs.length && var0.field1140 > var11.frameLenghts[var0.actionFrame]) {
               var0.field1140 = 1;
               ++var0.actionFrame;
               class150.queueAnimationSound(var11, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var11.frameIDs.length) {
               var0.actionFrame -= var11.frameStep;
               ++var0.field1186;
               if(var0.field1186 >= var11.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var11.frameIDs.length) {
                  class150.queueAnimationSound(var11, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field1165 = var11.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "(Lbw;I)V",
      garbageValue = "1147244796"
   )
   static final void method593(Actor var0) {
      if(var0.field1190 != 0) {
         if(var0.interacting != -1) {
            Object var1 = null;
            if(var0.interacting < 32768) {
               var1 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= 32768) {
               var1 = Client.cachedPlayers[var0.interacting - 32768];
            }

            if(var1 != null) {
               int var2 = var0.x - ((Actor)var1).x;
               int var3 = var0.y - ((Actor)var1).y;
               if(var2 != 0 || var3 != 0) {
                  var0.orientation = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
               }
            } else if(var0.field1188) {
               var0.interacting = -1;
               var0.field1188 = false;
            }
         }

         if(var0.field1142 != -1 && (var0.queueSize == 0 || var0.field1195 > 0)) {
            var0.orientation = var0.field1142;
            var0.field1142 = -1;
         }

         int var4 = var0.orientation - var0.angle & 2047;
         if(var4 == 0 && var0.field1188) {
            var0.interacting = -1;
            var0.field1188 = false;
         }

         if(var4 != 0) {
            ++var0.field1150;
            boolean var6;
            if(var4 > 1024) {
               var0.angle -= var0.field1190;
               var6 = true;
               if(var4 < var0.field1190 || var4 > 2048 - var0.field1190) {
                  var0.angle = var0.orientation;
                  var6 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field1150 > 25 || var6)) {
                  if(var0.field1143 != -1) {
                     var0.poseAnimation = var0.field1143;
                  } else {
                     var0.poseAnimation = var0.field1145;
                  }
               }
            } else {
               var0.angle += var0.field1190;
               var6 = true;
               if(var4 < var0.field1190 || var4 > 2048 - var0.field1190) {
                  var0.angle = var0.orientation;
                  var6 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field1150 > 25 || var6)) {
                  if(var0.field1164 != -1) {
                     var0.poseAnimation = var0.field1164;
                  } else {
                     var0.poseAnimation = var0.field1145;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field1150 = 0;
         }

      }
   }

   @ObfuscatedName("kf")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1469324374"
   )
   static void method594(int var0) {
      Client.field923 = var0;
   }
}
