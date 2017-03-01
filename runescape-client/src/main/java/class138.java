import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
public class class138 {
   @ObfuscatedName("g")
   static class182 field1916;
   @ObfuscatedName("n")
   static class182 field1917;
   @ObfuscatedName("x")
   static class182 field1918;
   @ObfuscatedName("v")
   public static class139 field1919;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1833789945
   )
   public static int field1921 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1997795791
   )
   static int field1922;
   @ObfuscatedName("s")
   static boolean field1923;
   @ObfuscatedName("p")
   public static class182 field1924;

   class138() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "2105994084"
   )
   static final void method2573(Actor var0, int var1) {
      Sequence var2;
      int var11;
      if(var0.field644 > Client.gameCycle) {
         class18.method201(var0);
      } else {
         int var3;
         int var4;
         int var5;
         int var7;
         if(var0.field650 >= Client.gameCycle) {
            if(Client.gameCycle == var0.field650 || var0.animation == -1 || var0.actionAnimationDisable != 0 || 1 + var0.field629 > TextureProvider.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
               var11 = var0.field650 - var0.field644;
               var3 = Client.gameCycle - var0.field644;
               var4 = var0.field645 * 128 + var0.field607 * 64;
               var5 = var0.field647 * 128 + var0.field607 * 64;
               int var6 = var0.field646 * 128 + var0.field607 * 64;
               var7 = var0.field606 * 128 + var0.field607 * 64;
               var0.x = (var4 * (var11 - var3) + var6 * var3) / var11;
               var0.y = (var7 * var3 + var5 * (var11 - var3)) / var11;
            }

            var0.field661 = 0;
            var0.field654 = var0.field626;
            var0.angle = var0.field654;
         } else {
            var0.poseAnimation = var0.idlePoseAnimation;
            if(var0.field657 == 0) {
               var0.field661 = 0;
            } else {
               label480: {
                  if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
                     var2 = TextureProvider.getAnimation(var0.animation);
                     if(var0.field662 > 0 && var2.precedenceAnimating == 0) {
                        ++var0.field661;
                        break label480;
                     }

                     if(var0.field662 <= 0 && var2.priority == 0) {
                        ++var0.field661;
                        break label480;
                     }
                  }

                  var11 = var0.x;
                  var3 = var0.y;
                  var4 = var0.field607 * 64 + 128 * var0.pathX[var0.field657 - 1];
                  var5 = var0.pathY[var0.field657 - 1] * 128 + var0.field607 * 64;
                  if(var11 < var4) {
                     if(var3 < var5) {
                        var0.field654 = 1280;
                     } else if(var3 > var5) {
                        var0.field654 = 1792;
                     } else {
                        var0.field654 = 1536;
                     }
                  } else if(var11 > var4) {
                     if(var3 < var5) {
                        var0.field654 = 768;
                     } else if(var3 > var5) {
                        var0.field654 = 256;
                     } else {
                        var0.field654 = 512;
                     }
                  } else if(var3 < var5) {
                     var0.field654 = 1024;
                  } else if(var3 > var5) {
                     var0.field654 = 0;
                  }

                  byte var13 = var0.field609[var0.field657 - 1];
                  if(var4 - var11 <= 256 && var4 - var11 >= -256 && var5 - var3 <= 256 && var5 - var3 >= -256) {
                     var7 = var0.field654 - var0.angle & 2047;
                     if(var7 > 1024) {
                        var7 -= 2048;
                     }

                     int var8 = var0.field612;
                     if(var7 >= -256 && var7 <= 256) {
                        var8 = var0.field632;
                     } else if(var7 >= 256 && var7 < 768) {
                        var8 = var0.field614;
                     } else if(var7 >= -768 && var7 <= -256) {
                        var8 = var0.field603;
                     }

                     if(var8 == -1) {
                        var8 = var0.field632;
                     }

                     var0.poseAnimation = var8;
                     int var9 = 4;
                     boolean var10 = true;
                     if(var0 instanceof NPC) {
                        var10 = ((NPC)var0).composition.isClickable;
                     }

                     if(var10) {
                        if(var0.angle != var0.field654 && var0.interacting == -1 && var0.field656 != 0) {
                           var9 = 2;
                        }

                        if(var0.field657 > 2) {
                           var9 = 6;
                        }

                        if(var0.field657 > 3) {
                           var9 = 8;
                        }

                        if(var0.field661 > 0 && var0.field657 > 1) {
                           var9 = 8;
                           --var0.field661;
                        }
                     } else {
                        if(var0.field657 > 1) {
                           var9 = 6;
                        }

                        if(var0.field657 > 2) {
                           var9 = 8;
                        }

                        if(var0.field661 > 0 && var0.field657 > 1) {
                           var9 = 8;
                           --var0.field661;
                        }
                     }

                     if(var13 == 2) {
                        var9 <<= 1;
                     }

                     if(var9 >= 8 && var0.field632 == var0.poseAnimation && var0.field615 != -1) {
                        var0.poseAnimation = var0.field615;
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

                     if(var4 == var0.x && var5 == var0.y) {
                        --var0.field657;
                        if(var0.field662 > 0) {
                           --var0.field662;
                        }
                     }
                  } else {
                     var0.x = var4;
                     var0.y = var5;
                     --var0.field657;
                     if(var0.field662 > 0) {
                        --var0.field662;
                     }
                  }
               }
            }
         }
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field644 = 0;
         var0.field650 = 0;
         var0.x = 128 * var0.pathX[0] + var0.field607 * 64;
         var0.y = var0.field607 * 64 + 128 * var0.pathY[0];
         var0.method639();
      }

      if(WidgetNode.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field644 = 0;
         var0.field650 = 0;
         var0.x = 128 * var0.pathX[0] + var0.field607 * 64;
         var0.y = var0.field607 * 64 + var0.pathY[0] * 128;
         var0.method639();
      }

      class150.method2857(var0);
      var0.field655 = false;
      if(var0.poseAnimation != -1) {
         var2 = TextureProvider.getAnimation(var0.poseAnimation);
         if(var2 != null && var2.frameIDs != null) {
            ++var0.field634;
            if(var0.poseFrame < var2.frameIDs.length && var0.field634 > var2.frameLenghts[var0.poseFrame]) {
               var0.field634 = 1;
               ++var0.poseFrame;
               Projectile.method865(var2, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var2.frameIDs.length) {
               var0.field634 = 0;
               var0.poseFrame = 0;
               Projectile.method865(var2, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.field643) {
         if(var0.field648 < 0) {
            var0.field648 = 0;
         }

         var11 = class157.method3129(var0.graphic).field2797;
         if(var11 != -1) {
            Sequence var12 = TextureProvider.getAnimation(var11);
            if(null != var12 && null != var12.frameIDs) {
               ++var0.field642;
               if(var0.field648 < var12.frameIDs.length && var0.field642 > var12.frameLenghts[var0.field648]) {
                  var0.field642 = 1;
                  ++var0.field648;
                  Projectile.method865(var12, var0.field648, var0.x, var0.y);
               }

               if(var0.field648 >= var12.frameIDs.length && (var0.field648 < 0 || var0.field648 >= var12.frameIDs.length)) {
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
         var2 = TextureProvider.getAnimation(var0.animation);
         if(var2.precedenceAnimating == 1 && var0.field662 > 0 && var0.field644 <= Client.gameCycle && var0.field650 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var2 = TextureProvider.getAnimation(var0.animation);
         if(null != var2 && null != var2.frameIDs) {
            ++var0.field629;
            if(var0.actionFrame < var2.frameIDs.length && var0.field629 > var2.frameLenghts[var0.actionFrame]) {
               var0.field629 = 1;
               ++var0.actionFrame;
               Projectile.method865(var2, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var2.frameIDs.length) {
               var0.actionFrame -= var2.frameStep;
               ++var0.field639;
               if(var0.field639 >= var2.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var2.frameIDs.length) {
                  Projectile.method865(var2, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field655 = var2.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }
}
