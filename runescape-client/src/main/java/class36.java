import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class36 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lav;"
   )
   static final class36 field521;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lav;"
   )
   static final class36 field516;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 39136011
   )
   static int field523;
   @ObfuscatedName("fp")
   static byte[][] field519;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 794415859
   )
   final int field515;

   static {
      field521 = new class36(0);
      field516 = new class36(1);
   }

   class36(int var1) {
      this.field515 = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILct;ZB)I",
      garbageValue = "50"
   )
   static int method482(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class81.intStack[--class278.intStackSize];
         var4 = ItemLayer.method2454(var3);
      } else {
         var4 = var2?class251.field3392:class164.field2314;
      }

      if(var0 == 1000) {
         class278.intStackSize -= 4;
         var4.originalX = class81.intStack[class278.intStackSize];
         var4.originalY = class81.intStack[class278.intStackSize + 1];
         var4.field2647 = class81.intStack[class278.intStackSize + 2];
         var4.field2732 = class81.intStack[class278.intStackSize + 3];
         class45.method647(var4);
         class7.clientInstance.method1161(var4);
         if(var3 != -1 && var4.type == 0) {
            GZipDecompressor.method3159(class215.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         class278.intStackSize -= 4;
         var4.originalWidth = class81.intStack[class278.intStackSize];
         var4.field2654 = class81.intStack[class278.intStackSize + 1];
         var4.field2649 = class81.intStack[class278.intStackSize + 2];
         var4.buttonType = class81.intStack[class278.intStackSize + 3];
         class45.method647(var4);
         class7.clientInstance.method1161(var4);
         if(var3 != -1 && var4.type == 0) {
            GZipDecompressor.method3159(class215.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class81.intStack[--class278.intStackSize] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            class45.method647(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.field2659 = class81.intStack[--class278.intStackSize] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.field2698 = class81.intStack[--class278.intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "18"
   )
   static void method481(String var0, String var1, String var2) {
      class90.loginMessage1 = var0;
      class90.loginMessage2 = var1;
      class90.loginMessage3 = var2;
   }

   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      signature = "(Lby;IB)V",
      garbageValue = "5"
   )
   static final void method479(Actor var0, int var1) {
      int var2;
      int var3;
      int var4;
      Sequence var11;
      if(var0.field1240 > Client.gameCycle) {
         var2 = var0.field1240 - Client.gameCycle;
         var3 = var0.field1251 * 128 + var0.field1221 * 64;
         var4 = var0.field1211 * 128 + var0.field1221 * 64;
         var0.x += (var3 - var0.x) / var2;
         var0.y += (var4 - var0.y) / var2;
         var0.field1267 = 0;
         var0.orientation = var0.field1257;
      } else {
         int var5;
         int var7;
         if(var0.field1256 >= Client.gameCycle) {
            if(var0.field1256 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.field1243 + 1 > NPCComposition.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
               var2 = var0.field1256 - var0.field1240;
               var3 = Client.gameCycle - var0.field1240;
               var4 = var0.field1251 * 128 + var0.field1221 * 64;
               var5 = var0.field1211 * 128 + var0.field1221 * 64;
               int var6 = var0.field1252 * 128 + var0.field1221 * 64;
               var7 = var0.field1254 * 128 + var0.field1221 * 64;
               var0.x = (var6 * var3 + var4 * (var2 - var3)) / var2;
               var0.y = (var3 * var7 + var5 * (var2 - var3)) / var2;
            }

            var0.field1267 = 0;
            var0.orientation = var0.field1257;
            var0.angle = var0.orientation;
         } else {
            var0.poseAnimation = var0.idlePoseAnimation;
            if(var0.queueSize == 0) {
               var0.field1267 = 0;
            } else {
               label579: {
                  if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
                     var11 = NPCComposition.getAnimation(var0.animation);
                     if(var0.field1213 > 0 && var11.precedenceAnimating == 0) {
                        ++var0.field1267;
                        break label579;
                     }

                     if(var0.field1213 <= 0 && var11.priority == 0) {
                        ++var0.field1267;
                        break label579;
                     }
                  }

                  var2 = var0.x;
                  var3 = var0.y;
                  var4 = var0.pathX[var0.queueSize - 1] * 128 + var0.field1221 * 64;
                  var5 = var0.pathY[var0.queueSize - 1] * 128 + var0.field1221 * 64;
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

                  byte var14 = var0.field1258[var0.queueSize - 1];
                  if(var4 - var2 <= 256 && var4 - var2 >= -256 && var5 - var3 <= 256 && var5 - var3 >= -256) {
                     var7 = var0.orientation - var0.angle & 2047;
                     if(var7 > 1024) {
                        var7 -= 2048;
                     }

                     int var8 = var0.field1218;
                     if(var7 >= -256 && var7 <= 256) {
                        var8 = var0.field1217;
                     } else if(var7 >= 256 && var7 < 768) {
                        var8 = var0.field1220;
                     } else if(var7 >= -768 && var7 <= -256) {
                        var8 = var0.field1219;
                     }

                     if(var8 == -1) {
                        var8 = var0.field1217;
                     }

                     var0.poseAnimation = var8;
                     int var9 = 4;
                     boolean var10 = true;
                     if(var0 instanceof NPC) {
                        var10 = ((NPC)var0).composition.isClickable;
                     }

                     if(var10) {
                        if(var0.angle != var0.orientation && var0.interacting == -1 && var0.field1262 != 0) {
                           var9 = 2;
                        }

                        if(var0.queueSize > 2) {
                           var9 = 6;
                        }

                        if(var0.queueSize > 3) {
                           var9 = 8;
                        }

                        if(var0.field1267 > 0 && var0.queueSize > 1) {
                           var9 = 8;
                           --var0.field1267;
                        }
                     } else {
                        if(var0.queueSize > 1) {
                           var9 = 6;
                        }

                        if(var0.queueSize > 2) {
                           var9 = 8;
                        }

                        if(var0.field1267 > 0 && var0.queueSize > 1) {
                           var9 = 8;
                           --var0.field1267;
                        }
                     }

                     if(var14 == 2) {
                        var9 <<= 1;
                     }

                     if(var9 >= 8 && var0.poseAnimation == var0.field1217 && var0.field1216 != -1) {
                        var0.poseAnimation = var0.field1216;
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
                        if(var0.field1213 > 0) {
                           --var0.field1213;
                        }
                     }
                  } else {
                     var0.x = var4;
                     var0.y = var5;
                     --var0.queueSize;
                     if(var0.field1213 > 0) {
                        --var0.field1213;
                     }
                  }
               }
            }
         }
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1240 = 0;
         var0.field1256 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1221 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1221 * 64;
         var0.method1525();
      }

      if(class66.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1240 = 0;
         var0.field1256 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1221 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1221 * 64;
         var0.method1525();
      }

      if(var0.field1262 != 0) {
         if(var0.interacting != -1) {
            Object var15 = null;
            if(var0.interacting < 32768) {
               var15 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= 32768) {
               var15 = Client.cachedPlayers[var0.interacting - 32768];
            }

            if(var15 != null) {
               var3 = var0.x - ((Actor)var15).x;
               var4 = var0.y - ((Actor)var15).y;
               if(var3 != 0 || var4 != 0) {
                  var0.orientation = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
               }
            } else if(var0.field1236) {
               var0.interacting = -1;
               var0.field1236 = false;
            }
         }

         if(var0.field1249 != -1 && (var0.queueSize == 0 || var0.field1267 > 0)) {
            var0.orientation = var0.field1249;
            var0.field1249 = -1;
         }

         var2 = var0.orientation - var0.angle & 2047;
         if(var2 == 0 && var0.field1236) {
            var0.interacting = -1;
            var0.field1236 = false;
         }

         if(var2 != 0) {
            ++var0.field1261;
            boolean var13;
            if(var2 > 1024) {
               var0.angle -= var0.field1262;
               var13 = true;
               if(var2 < var0.field1262 || var2 > 2048 - var0.field1262) {
                  var0.angle = var0.orientation;
                  var13 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field1261 > 25 || var13)) {
                  if(var0.field1253 != -1) {
                     var0.poseAnimation = var0.field1253;
                  } else {
                     var0.poseAnimation = var0.field1217;
                  }
               }
            } else {
               var0.angle += var0.field1262;
               var13 = true;
               if(var2 < var0.field1262 || var2 > 2048 - var0.field1262) {
                  var0.angle = var0.orientation;
                  var13 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field1261 > 25 || var13)) {
                  if(var0.field1227 != -1) {
                     var0.poseAnimation = var0.field1227;
                  } else {
                     var0.poseAnimation = var0.field1217;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field1261 = 0;
         }
      }

      var0.field1212 = false;
      if(var0.poseAnimation != -1) {
         var11 = NPCComposition.getAnimation(var0.poseAnimation);
         if(var11 != null && var11.frameIDs != null) {
            ++var0.field1234;
            if(var0.poseFrame < var11.frameIDs.length && var0.field1234 > var11.frameLenghts[var0.poseFrame]) {
               var0.field1234 = 1;
               ++var0.poseFrame;
               class40.method539(var11, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var11.frameIDs.length) {
               var0.field1234 = 0;
               var0.poseFrame = 0;
               class40.method539(var11, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.graphicsDelay) {
         if(var0.field1215 < 0) {
            var0.field1215 = 0;
         }

         var2 = class244.getSpotAnimType(var0.graphic).field3325;
         if(var2 != -1) {
            Sequence var12 = NPCComposition.getAnimation(var2);
            if(var12 != null && var12.frameIDs != null) {
               ++var0.field1248;
               if(var0.field1215 < var12.frameIDs.length && var0.field1248 > var12.frameLenghts[var0.field1215]) {
                  var0.field1248 = 1;
                  ++var0.field1215;
                  class40.method539(var12, var0.field1215, var0.x, var0.y);
               }

               if(var0.field1215 >= var12.frameIDs.length && (var0.field1215 < 0 || var0.field1215 >= var12.frameIDs.length)) {
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
         var11 = NPCComposition.getAnimation(var0.animation);
         if(var11.precedenceAnimating == 1 && var0.field1213 > 0 && var0.field1240 <= Client.gameCycle && var0.field1256 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var11 = NPCComposition.getAnimation(var0.animation);
         if(var11 != null && var11.frameIDs != null) {
            ++var0.field1243;
            if(var0.actionFrame < var11.frameIDs.length && var0.field1243 > var11.frameLenghts[var0.actionFrame]) {
               var0.field1243 = 1;
               ++var0.actionFrame;
               class40.method539(var11, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var11.frameIDs.length) {
               var0.actionFrame -= var11.frameStep;
               ++var0.field1245;
               if(var0.field1245 >= var11.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var11.frameIDs.length) {
                  class40.method539(var11, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field1212 = var11.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-965603903"
   )
   static final void method480(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field1117; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field1119[var4] = true;
         }
      }

   }
}
