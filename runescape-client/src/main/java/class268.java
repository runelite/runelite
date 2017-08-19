import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jn")
public class class268 {
   @ObfuscatedName("f")
   static final char[] field3655;
   @ObfuscatedName("p")
   static final char[] field3654;

   static {
      field3655 = new char[]{' ', ' ', '_', '-', 'à', 'á', 'â', 'ä', 'ã', 'À', 'Á', 'Â', 'Ä', 'Ã', 'è', 'é', 'ê', 'ë', 'È', 'É', 'Ê', 'Ë', 'í', 'î', 'ï', 'Í', 'Î', 'Ï', 'ò', 'ó', 'ô', 'ö', 'õ', 'Ò', 'Ó', 'Ô', 'Ö', 'Õ', 'ù', 'ú', 'û', 'ü', 'Ù', 'Ú', 'Û', 'Ü', 'ç', 'Ç', 'ÿ', 'Ÿ', 'ñ', 'Ñ', 'ß'};
      field3654 = new char[]{'[', ']', '#'};
   }

   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      signature = "(Lcr;IB)V",
      garbageValue = "100"
   )
   static final void method4890(Actor var0, int var1) {
      int var2;
      int var3;
      int var4;
      Sequence var11;
      if(var0.field1264 > Client.gameCycle) {
         var2 = var0.field1264 - Client.gameCycle;
         var3 = var0.field1219 * 64 + var0.field1260 * 128;
         var4 = var0.field1262 * 128 + var0.field1219 * 64;
         var0.x += (var3 - var0.x) / var2;
         var0.y += (var4 - var0.y) / var2;
         var0.field1276 = 0;
         var0.orientation = var0.field1266;
      } else if(var0.field1265 >= Client.gameCycle) {
         class10.method46(var0);
      } else {
         var0.poseAnimation = var0.idlePoseAnimation;
         if(var0.queueSize == 0) {
            var0.field1276 = 0;
         } else {
            label415: {
               if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
                  var11 = PendingSpawn.getAnimation(var0.animation);
                  if(var0.field1277 > 0 && var11.precedenceAnimating == 0) {
                     ++var0.field1276;
                     break label415;
                  }

                  if(var0.field1277 <= 0 && var11.priority == 0) {
                     ++var0.field1276;
                     break label415;
                  }
               }

               var2 = var0.x;
               var3 = var0.y;
               var4 = var0.pathX[var0.queueSize - 1] * 128 + var0.field1219 * 64;
               int var5 = var0.pathY[var0.queueSize - 1] * 128 + var0.field1219 * 64;
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

               byte var6 = var0.field1251[var0.queueSize - 1];
               if(var4 - var2 <= 256 && var4 - var2 >= -256 && var5 - var3 <= 256 && var5 - var3 >= -256) {
                  int var7 = var0.orientation - var0.angle & 2047;
                  if(var7 > 1024) {
                     var7 -= 2048;
                  }

                  int var8 = var0.field1218;
                  if(var7 >= -256 && var7 <= 256) {
                     var8 = var0.field1226;
                  } else if(var7 >= 256 && var7 < 768) {
                     var8 = var0.field1229;
                  } else if(var7 >= -768 && var7 <= -256) {
                     var8 = var0.field1228;
                  }

                  if(var8 == -1) {
                     var8 = var0.field1226;
                  }

                  var0.poseAnimation = var8;
                  int var9 = 4;
                  boolean var10 = true;
                  if(var0 instanceof NPC) {
                     var10 = ((NPC)var0).composition.isClickable;
                  }

                  if(var10) {
                     if(var0.angle != var0.orientation && var0.interacting == -1 && var0.field1230 != 0) {
                        var9 = 2;
                     }

                     if(var0.queueSize > 2) {
                        var9 = 6;
                     }

                     if(var0.queueSize > 3) {
                        var9 = 8;
                     }

                     if(var0.field1276 > 0 && var0.queueSize > 1) {
                        var9 = 8;
                        --var0.field1276;
                     }
                  } else {
                     if(var0.queueSize > 1) {
                        var9 = 6;
                     }

                     if(var0.queueSize > 2) {
                        var9 = 8;
                     }

                     if(var0.field1276 > 0 && var0.queueSize > 1) {
                        var9 = 8;
                        --var0.field1276;
                     }
                  }

                  if(var6 == 2) {
                     var9 <<= 1;
                  }

                  if(var9 >= 8 && var0.field1226 == var0.poseAnimation && var0.field1222 != -1) {
                     var0.poseAnimation = var0.field1222;
                  }

                  if(var2 != var4 || var3 != var5) {
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
                     if(var0.field1277 > 0) {
                        --var0.field1277;
                     }
                  }
               } else {
                  var0.x = var4;
                  var0.y = var5;
                  --var0.queueSize;
                  if(var0.field1277 > 0) {
                     --var0.field1277;
                  }
               }
            }
         }
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1264 = 0;
         var0.field1265 = 0;
         var0.x = var0.field1219 * 64 + var0.pathX[0] * 128;
         var0.y = var0.pathY[0] * 128 + var0.field1219 * 64;
         var0.method1525();
      }

      if(GrandExchangeOffer.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1264 = 0;
         var0.field1265 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1219 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1219 * 64;
         var0.method1525();
      }

      class47.method737(var0);
      var0.field1221 = false;
      if(var0.poseAnimation != -1) {
         var11 = PendingSpawn.getAnimation(var0.poseAnimation);
         if(var11 != null && var11.frameIDs != null) {
            ++var0.field1249;
            if(var0.poseFrame < var11.frameIDs.length && var0.field1249 > var11.frameLenghts[var0.poseFrame]) {
               var0.field1249 = 1;
               ++var0.poseFrame;
               class9.method44(var11, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var11.frameIDs.length) {
               var0.field1249 = 0;
               var0.poseFrame = 0;
               class9.method44(var11, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.graphicsDelay) {
         if(var0.field1256 < 0) {
            var0.field1256 = 0;
         }

         var2 = class36.getSpotAnimType(var0.graphic).field3316;
         if(var2 != -1) {
            Sequence var12 = PendingSpawn.getAnimation(var2);
            if(var12 != null && var12.frameIDs != null) {
               ++var0.field1257;
               if(var0.field1256 < var12.frameIDs.length && var0.field1257 > var12.frameLenghts[var0.field1256]) {
                  var0.field1257 = 1;
                  ++var0.field1256;
                  class9.method44(var12, var0.field1256, var0.x, var0.y);
               }

               if(var0.field1256 >= var12.frameIDs.length && (var0.field1256 < 0 || var0.field1256 >= var12.frameIDs.length)) {
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
         var11 = PendingSpawn.getAnimation(var0.animation);
         if(var11.precedenceAnimating == 1 && var0.field1277 > 0 && var0.field1264 <= Client.gameCycle && var0.field1265 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var11 = PendingSpawn.getAnimation(var0.animation);
         if(var11 != null && var11.frameIDs != null) {
            ++var0.field1267;
            if(var0.actionFrame < var11.frameIDs.length && var0.field1267 > var11.frameLenghts[var0.actionFrame]) {
               var0.field1267 = 1;
               ++var0.actionFrame;
               class9.method44(var11, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var11.frameIDs.length) {
               var0.actionFrame -= var11.frameStep;
               ++var0.field1254;
               if(var0.field1254 >= var11.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var11.frameIDs.length) {
                  class9.method44(var11, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field1221 = var11.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }
}
