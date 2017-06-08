import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
public class class73 extends class163 {
   @ObfuscatedName("gg")
   static ModIcon[] field864;
   @ObfuscatedName("gr")
   static SpritePixels[] field867;
   @ObfuscatedName("pp")
   @ObfuscatedGetter(
      intValue = 2117996925
   )
   static int field868;

   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "-1810971112"
   )
   static final void method1089(Actor var0, int var1) {
      int var2;
      int var3;
      int var4;
      Sequence var12;
      if(var0.field1272 > Client.gameCycle) {
         var2 = var0.field1272 - Client.gameCycle;
         var3 = var0.field1268 * 128 + var0.field1230 * 64;
         var4 = var0.field1286 * 128 + var0.field1230 * 64;
         var0.x += (var3 - var0.x) / var2;
         var0.y += (var4 - var0.y) / var2;
         var0.field1258 = 0;
         var0.field1252 = var0.field1274;
      } else {
         int var5;
         int var7;
         if(var0.field1273 >= Client.gameCycle) {
            if(Client.gameCycle == var0.field1273 || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.field1260 + 1 > class169.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
               var2 = var0.field1273 - var0.field1272;
               var3 = Client.gameCycle - var0.field1272;
               var4 = var0.field1268 * 128 + var0.field1230 * 64;
               var5 = var0.field1286 * 128 + var0.field1230 * 64;
               int var6 = var0.field1269 * 128 + var0.field1230 * 64;
               var7 = var0.field1271 * 128 + var0.field1230 * 64;
               var0.x = (var6 * var3 + (var2 - var3) * var4) / var2;
               var0.y = (var7 * var3 + var5 * (var2 - var3)) / var2;
            }

            var0.field1258 = 0;
            var0.field1252 = var0.field1274;
            var0.angle = var0.field1252;
         } else {
            var0.poseAnimation = var0.idlePoseAnimation;
            if(var0.field1280 == 0) {
               var0.field1258 = 0;
            } else {
               label608: {
                  if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
                     var12 = class169.getAnimation(var0.animation);
                     if(var0.field1285 > 0 && var12.precedenceAnimating == 0) {
                        ++var0.field1258;
                        break label608;
                     }

                     if(var0.field1285 <= 0 && var12.priority == 0) {
                        ++var0.field1258;
                        break label608;
                     }
                  }

                  var2 = var0.x;
                  var3 = var0.y;
                  var4 = var0.pathX[var0.field1280 - 1] * 128 + var0.field1230 * 64;
                  var5 = var0.field1230 * 64 + var0.pathY[var0.field1280 - 1] * 128;
                  if(var2 < var4) {
                     if(var3 < var5) {
                        var0.field1252 = 1280;
                     } else if(var3 > var5) {
                        var0.field1252 = 1792;
                     } else {
                        var0.field1252 = 1536;
                     }
                  } else if(var2 > var4) {
                     if(var3 < var5) {
                        var0.field1252 = 768;
                     } else if(var3 > var5) {
                        var0.field1252 = 256;
                     } else {
                        var0.field1252 = 512;
                     }
                  } else if(var3 < var5) {
                     var0.field1252 = 1024;
                  } else if(var3 > var5) {
                     var0.field1252 = 0;
                  }

                  byte var14 = var0.field1283[var0.field1280 - 1];
                  if(var4 - var2 <= 256 && var4 - var2 >= -256 && var5 - var3 <= 256 && var5 - var3 >= -256) {
                     var7 = var0.field1252 - var0.angle & 2047;
                     if(var7 > 1024) {
                        var7 -= 2048;
                     }

                     int var8 = var0.field1235;
                     if(var7 >= -256 && var7 <= 256) {
                        var8 = var0.field1234;
                     } else if(var7 >= 256 && var7 < 768) {
                        var8 = var0.field1237;
                     } else if(var7 >= -768 && var7 <= -256) {
                        var8 = var0.field1265;
                     }

                     if(var8 == -1) {
                        var8 = var0.field1234;
                     }

                     var0.poseAnimation = var8;
                     int var9 = 4;
                     boolean var10 = true;
                     if(var0 instanceof NPC) {
                        var10 = ((NPC)var0).composition.isClickable;
                     }

                     if(var10) {
                        if(var0.angle != var0.field1252 && var0.interacting == -1 && var0.field1242 != 0) {
                           var9 = 2;
                        }

                        if(var0.field1280 > 2) {
                           var9 = 6;
                        }

                        if(var0.field1280 > 3) {
                           var9 = 8;
                        }

                        if(var0.field1258 > 0 && var0.field1280 > 1) {
                           var9 = 8;
                           --var0.field1258;
                        }
                     } else {
                        if(var0.field1280 > 1) {
                           var9 = 6;
                        }

                        if(var0.field1280 > 2) {
                           var9 = 8;
                        }

                        if(var0.field1258 > 0 && var0.field1280 > 1) {
                           var9 = 8;
                           --var0.field1258;
                        }
                     }

                     if(var14 == 2) {
                        var9 <<= 1;
                     }

                     if(var9 >= 8 && var0.poseAnimation == var0.field1234 && var0.field1238 != -1) {
                        var0.poseAnimation = var0.field1238;
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
                        --var0.field1280;
                        if(var0.field1285 > 0) {
                           --var0.field1285;
                        }
                     }
                  } else {
                     var0.x = var4;
                     var0.y = var5;
                     --var0.field1280;
                     if(var0.field1285 > 0) {
                        --var0.field1285;
                     }
                  }
               }
            }
         }
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1272 = 0;
         var0.field1273 = 0;
         var0.x = var0.field1230 * 64 + var0.pathX[0] * 128;
         var0.y = var0.field1230 * 64 + var0.pathY[0] * 128;
         var0.method1492();
      }

      if(class168.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1272 = 0;
         var0.field1273 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1230 * 64;
         var0.y = var0.field1230 * 64 + var0.pathY[0] * 128;
         var0.method1492();
      }

      if(var0.field1242 != 0) {
         if(var0.interacting != -1) {
            Object var15 = null;
            if(var0.interacting < '耀') {
               var15 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= '耀') {
               var15 = Client.cachedPlayers[var0.interacting - '耀'];
            }

            if(var15 != null) {
               var3 = var0.x - ((Actor)var15).x;
               var4 = var0.y - ((Actor)var15).y;
               if(var3 != 0 || var4 != 0) {
                  var0.field1252 = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
               }
            } else if(var0.field1253) {
               var0.interacting = -1;
               var0.field1253 = false;
            }
         }

         if(var0.field1254 != -1 && (var0.field1280 == 0 || var0.field1258 > 0)) {
            var0.field1252 = var0.field1254;
            var0.field1254 = -1;
         }

         var2 = var0.field1252 - var0.angle & 2047;
         if(var2 == 0 && var0.field1253) {
            var0.interacting = -1;
            var0.field1253 = false;
         }

         if(var2 != 0) {
            ++var0.field1278;
            boolean var13;
            if(var2 > 1024) {
               var0.angle -= var0.field1242;
               var13 = true;
               if(var2 < var0.field1242 || var2 > 2048 - var0.field1242) {
                  var0.angle = var0.field1252;
                  var13 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field1278 > 25 || var13)) {
                  if(var0.field1232 != -1) {
                     var0.poseAnimation = var0.field1232;
                  } else {
                     var0.poseAnimation = var0.field1234;
                  }
               }
            } else {
               var0.angle += var0.field1242;
               var13 = true;
               if(var2 < var0.field1242 || var2 > 2048 - var0.field1242) {
                  var0.angle = var0.field1252;
                  var13 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field1278 > 25 || var13)) {
                  if(var0.field1248 != -1) {
                     var0.poseAnimation = var0.field1248;
                  } else {
                     var0.poseAnimation = var0.field1234;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field1278 = 0;
         }
      }

      var0.field1229 = false;
      if(var0.poseAnimation != -1) {
         var12 = class169.getAnimation(var0.poseAnimation);
         if(var12 != null && var12.frameIDs != null) {
            ++var0.field1257;
            if(var0.poseFrame < var12.frameIDs.length && var0.field1257 > var12.frameLenghts[var0.poseFrame]) {
               var0.field1257 = 1;
               ++var0.poseFrame;
               class5.method16(var12, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var12.frameIDs.length) {
               var0.field1257 = 0;
               var0.poseFrame = 0;
               class5.method16(var12, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.field1256) {
         if(var0.field1264 < 0) {
            var0.field1264 = 0;
         }

         var2 = class100.method1840(var0.graphic).field3340;
         if(var2 != -1) {
            Sequence var11 = class169.getAnimation(var2);
            if(var11 != null && var11.frameIDs != null) {
               ++var0.field1249;
               if(var0.field1264 < var11.frameIDs.length && var0.field1249 > var11.frameLenghts[var0.field1264]) {
                  var0.field1249 = 1;
                  ++var0.field1264;
                  class5.method16(var11, var0.field1264, var0.x, var0.y);
               }

               if(var0.field1264 >= var11.frameIDs.length && (var0.field1264 < 0 || var0.field1264 >= var11.frameIDs.length)) {
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
         var12 = class169.getAnimation(var0.animation);
         if(var12.precedenceAnimating == 1 && var0.field1285 > 0 && var0.field1272 <= Client.gameCycle && var0.field1273 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var12 = class169.getAnimation(var0.animation);
         if(var12 != null && var12.frameIDs != null) {
            ++var0.field1260;
            if(var0.actionFrame < var12.frameIDs.length && var0.field1260 > var12.frameLenghts[var0.actionFrame]) {
               var0.field1260 = 1;
               ++var0.actionFrame;
               class5.method16(var12, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var12.frameIDs.length) {
               var0.actionFrame -= var12.frameStep;
               ++var0.field1228;
               if(var0.field1228 >= var12.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var12.frameIDs.length) {
                  class5.method16(var12, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field1229 = var12.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;B)Z",
      garbageValue = "0"
   )
   public boolean vmethod3055(int var1, int var2, int var3, CollisionData var4) {
      return super.field2319 == var2 && var3 == super.field2320;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1916081530"
   )
   static final int method1091(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1375732500"
   )
   public static boolean method1095(int var0) {
      if(FileOnDisk.validInterfaces[var0]) {
         return true;
      } else if(!Widget.field2736.method4128(var0)) {
         return false;
      } else {
         int var1 = Widget.field2736.method4174(var0);
         if(var1 == 0) {
            FileOnDisk.validInterfaces[var0] = true;
            return true;
         } else {
            if(Widget.widgets[var0] == null) {
               Widget.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(Widget.widgets[var0][var2] == null) {
                  byte[] var3 = Widget.field2736.getConfigData(var0, var2);
                  if(var3 != null) {
                     Widget.widgets[var0][var2] = new Widget();
                     Widget.widgets[var0][var2].id = (var0 << 16) + var2;
                     if(var3[0] == -1) {
                        Widget.widgets[var0][var2].method4011(new Buffer(var3));
                     } else {
                        Widget.widgets[var0][var2].method4010(new Buffer(var3));
                     }
                  }
               }
            }

            FileOnDisk.validInterfaces[var0] = true;
            return true;
         }
      }
   }
}
