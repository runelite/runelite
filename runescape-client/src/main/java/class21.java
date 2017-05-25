import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
public class class21 {
   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "-63342104"
   )
   static final void method149(Actor var0, int var1) {
      Sequence var2;
      int var3;
      int var4;
      int var11;
      if(var0.field1244 > Client.gameCycle) {
         var11 = var0.field1244 - Client.gameCycle;
         var3 = var0.field1198 * 128 + var0.field1202 * 64;
         var4 = var0.field1202 * 64 + var0.field1242 * 128;
         var0.x += (var3 - var0.x) / var11;
         var0.y += (var4 - var0.y) / var11;
         var0.field1257 = 0;
         var0.field1247 = var0.field1201;
      } else if(var0.field1224 >= Client.gameCycle) {
         ScriptState.method1080(var0);
      } else {
         var0.poseAnimation = var0.idlePoseAnimation;
         if(var0.field1252 == 0) {
            var0.field1257 = 0;
         } else {
            label591: {
               if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
                  var2 = class165.getAnimation(var0.animation);
                  if(var0.field1236 > 0 && var2.precedenceAnimating == 0) {
                     ++var0.field1257;
                     break label591;
                  }

                  if(var0.field1236 <= 0 && var2.priority == 0) {
                     ++var0.field1257;
                     break label591;
                  }
               }

               var11 = var0.x;
               var3 = var0.y;
               var4 = var0.field1202 * 64 + var0.pathX[var0.field1252 - 1] * 128;
               int var5 = var0.pathY[var0.field1252 - 1] * 128 + var0.field1202 * 64;
               if(var11 < var4) {
                  if(var3 < var5) {
                     var0.field1247 = 1280;
                  } else if(var3 > var5) {
                     var0.field1247 = 1792;
                  } else {
                     var0.field1247 = 1536;
                  }
               } else if(var11 > var4) {
                  if(var3 < var5) {
                     var0.field1247 = 768;
                  } else if(var3 > var5) {
                     var0.field1247 = 256;
                  } else {
                     var0.field1247 = 512;
                  }
               } else if(var3 < var5) {
                  var0.field1247 = 1024;
               } else if(var3 > var5) {
                  var0.field1247 = 0;
               }

               byte var6 = var0.field1255[var0.field1252 - 1];
               if(var4 - var11 <= 256 && var4 - var11 >= -256 && var5 - var3 <= 256 && var5 - var3 >= -256) {
                  int var7 = var0.field1247 - var0.angle & 2047;
                  if(var7 > 1024) {
                     var7 -= 2048;
                  }

                  int var8 = var0.field1251;
                  if(var7 >= -256 && var7 <= 256) {
                     var8 = var0.field1227;
                  } else if(var7 >= 256 && var7 < 768) {
                     var8 = var0.field1226;
                  } else if(var7 >= -768 && var7 <= -256) {
                     var8 = var0.field1208;
                  }

                  if(var8 == -1) {
                     var8 = var0.field1227;
                  }

                  var0.poseAnimation = var8;
                  int var9 = 4;
                  boolean var10 = true;
                  if(var0 instanceof NPC) {
                     var10 = ((NPC)var0).composition.isClickable;
                  }

                  if(var10) {
                     if(var0.field1247 != var0.angle && var0.interacting == -1 && var0.field1209 != 0) {
                        var9 = 2;
                     }

                     if(var0.field1252 > 2) {
                        var9 = 6;
                     }

                     if(var0.field1252 > 3) {
                        var9 = 8;
                     }

                     if(var0.field1257 > 0 && var0.field1252 > 1) {
                        var9 = 8;
                        --var0.field1257;
                     }
                  } else {
                     if(var0.field1252 > 1) {
                        var9 = 6;
                     }

                     if(var0.field1252 > 2) {
                        var9 = 8;
                     }

                     if(var0.field1257 > 0 && var0.field1252 > 1) {
                        var9 = 8;
                        --var0.field1257;
                     }
                  }

                  if(var6 == 2) {
                     var9 <<= 1;
                  }

                  if(var9 >= 8 && var0.poseAnimation == var0.field1227 && var0.field1210 != -1) {
                     var0.poseAnimation = var0.field1210;
                  }

                  if(var4 != var11 || var5 != var3) {
                     if(var11 < var4) {
                        var0.x += var9;
                        if(var0.x > var4) {
                           var0.x = var4;
                        }
                     } else if(var11 > var4) {
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

                  if(var0.x == var4 && var0.y == var5) {
                     --var0.field1252;
                     if(var0.field1236 > 0) {
                        --var0.field1236;
                     }
                  }
               } else {
                  var0.x = var4;
                  var0.y = var5;
                  --var0.field1252;
                  if(var0.field1236 > 0) {
                     --var0.field1236;
                  }
               }
            }
         }
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1244 = 0;
         var0.field1224 = 0;
         var0.x = var0.field1202 * 64 + var0.pathX[0] * 128;
         var0.y = var0.field1202 * 64 + var0.pathY[0] * 128;
         var0.method1544();
      }

      if(var0 == XGrandExchangeOffer.localPlayer && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1244 = 0;
         var0.field1224 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1202 * 64;
         var0.y = var0.field1202 * 64 + var0.pathY[0] * 128;
         var0.method1544();
      }

      if(var0.field1209 != 0) {
         if(var0.interacting != -1) {
            Object var13 = null;
            if(var0.interacting < '耀') {
               var13 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= '耀') {
               var13 = Client.cachedPlayers[var0.interacting - '耀'];
            }

            if(var13 != null) {
               var3 = var0.x - ((Actor)var13).x;
               var4 = var0.y - ((Actor)var13).y;
               if(var3 != 0 || var4 != 0) {
                  var0.field1247 = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
               }
            } else if(var0.field1249) {
               var0.interacting = -1;
               var0.field1249 = false;
            }
         }

         if(var0.field1230 != -1 && (var0.field1252 == 0 || var0.field1257 > 0)) {
            var0.field1247 = var0.field1230;
            var0.field1230 = -1;
         }

         var11 = var0.field1247 - var0.angle & 2047;
         if(var11 == 0 && var0.field1249) {
            var0.interacting = -1;
            var0.field1249 = false;
         }

         if(var11 != 0) {
            ++var0.field1250;
            boolean var14;
            if(var11 > 1024) {
               var0.angle -= var0.field1209;
               var14 = true;
               if(var11 < var0.field1209 || var11 > 2048 - var0.field1209) {
                  var0.angle = var0.field1247;
                  var14 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field1250 > 25 || var14)) {
                  if(var0.field1204 != -1) {
                     var0.poseAnimation = var0.field1204;
                  } else {
                     var0.poseAnimation = var0.field1227;
                  }
               }
            } else {
               var0.angle += var0.field1209;
               var14 = true;
               if(var11 < var0.field1209 || var11 > 2048 - var0.field1209) {
                  var0.angle = var0.field1247;
                  var14 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field1250 > 25 || var14)) {
                  if(var0.field1205 != -1) {
                     var0.poseAnimation = var0.field1205;
                  } else {
                     var0.poseAnimation = var0.field1227;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field1250 = 0;
         }
      }

      var0.field1207 = false;
      if(var0.poseAnimation != -1) {
         var2 = class165.getAnimation(var0.poseAnimation);
         if(var2 != null && var2.frameIDs != null) {
            ++var0.field1229;
            if(var0.poseFrame < var2.frameIDs.length && var0.field1229 > var2.frameLenghts[var0.poseFrame]) {
               var0.field1229 = 1;
               ++var0.poseFrame;
               RSCanvas.method785(var2, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var2.frameIDs.length) {
               var0.field1229 = 0;
               var0.poseFrame = 0;
               RSCanvas.method785(var2, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.field1206) {
         if(var0.field1228 < 0) {
            var0.field1228 = 0;
         }

         var11 = class203.method3752(var0.graphic).field3319;
         if(var11 != -1) {
            Sequence var12 = class165.getAnimation(var11);
            if(var12 != null && var12.frameIDs != null) {
               ++var0.field1237;
               if(var0.field1228 < var12.frameIDs.length && var0.field1237 > var12.frameLenghts[var0.field1228]) {
                  var0.field1237 = 1;
                  ++var0.field1228;
                  RSCanvas.method785(var12, var0.field1228, var0.x, var0.y);
               }

               if(var0.field1228 >= var12.frameIDs.length && (var0.field1228 < 0 || var0.field1228 >= var12.frameIDs.length)) {
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
         var2 = class165.getAnimation(var0.animation);
         if(var2.precedenceAnimating == 1 && var0.field1236 > 0 && var0.field1244 <= Client.gameCycle && var0.field1224 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var2 = class165.getAnimation(var0.animation);
         if(var2 != null && var2.frameIDs != null) {
            ++var0.field1220;
            if(var0.actionFrame < var2.frameIDs.length && var0.field1220 > var2.frameLenghts[var0.actionFrame]) {
               var0.field1220 = 1;
               ++var0.actionFrame;
               RSCanvas.method785(var2, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var2.frameIDs.length) {
               var0.actionFrame -= var2.frameStep;
               ++var0.field1234;
               if(var0.field1234 >= var2.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var2.frameIDs.length) {
                  RSCanvas.method785(var2, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field1207 = var2.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1621229649"
   )
   static final int method150(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-230244476"
   )
   public static final boolean method151(String var0, String var1, String var2, String var3) {
      return var0 != null && var2 != null?(!var0.startsWith("#") && !var2.startsWith("#")?var1.equals(var3):var0.equals(var2)):false;
   }
}
