import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
public class class112 {
   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "-1381706243"
   )
   static final void method2534(Actor var0, int var1) {
      Sequence var2;
      int var3;
      int var4;
      int var5;
      if(var0.field891 > Client.gameCycle) {
         Friend.method208(var0);
      } else if(var0.field878 >= Client.gameCycle) {
         NPC.method777(var0);
      } else {
         var0.poseAnimation = var0.idlePoseAnimation;
         if(var0.field849 == 0) {
            var0.field889 = 0;
         } else {
            label413: {
               if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
                  var2 = class22.getAnimation(var0.animation);
                  if(var0.field839 > 0 && var2.precedenceAnimating == 0) {
                     ++var0.field889;
                     break label413;
                  }

                  if(var0.field839 <= 0 && var2.field1028 == 0) {
                     ++var0.field889;
                     break label413;
                  }
               }

               var5 = var0.x;
               var3 = var0.y;
               var4 = var0.pathX[var0.field849 - 1] * 128 + var0.field877 * 64;
               int var6 = 128 * var0.pathY[var0.field849 - 1] + var0.field877 * 64;
               if(var5 < var4) {
                  if(var3 < var6) {
                     var0.field882 = 1280;
                  } else if(var3 > var6) {
                     var0.field882 = 1792;
                  } else {
                     var0.field882 = 1536;
                  }
               } else if(var5 > var4) {
                  if(var3 < var6) {
                     var0.field882 = 768;
                  } else if(var3 > var6) {
                     var0.field882 = 256;
                  } else {
                     var0.field882 = 512;
                  }
               } else if(var3 < var6) {
                  var0.field882 = 1024;
               } else if(var3 > var6) {
                  var0.field882 = 0;
               }

               byte var7 = var0.field888[var0.field849 - 1];
               if(var4 - var5 <= 256 && var4 - var5 >= -256 && var6 - var3 <= 256 && var6 - var3 >= -256) {
                  int var8 = var0.field882 - var0.angle & 2047;
                  if(var8 > 1024) {
                     var8 -= 2048;
                  }

                  int var9 = var0.field840;
                  if(var8 >= -256 && var8 <= 256) {
                     var9 = var0.field879;
                  } else if(var8 >= 256 && var8 < 768) {
                     var9 = var0.field831;
                  } else if(var8 >= -768 && var8 <= -256) {
                     var9 = var0.field841;
                  }

                  if(var9 == -1) {
                     var9 = var0.field879;
                  }

                  var0.poseAnimation = var9;
                  int var10 = 4;
                  boolean var11 = true;
                  if(var0 instanceof NPC) {
                     var11 = ((NPC)var0).composition.isClickable;
                  }

                  if(var11) {
                     if(var0.field882 != var0.angle && var0.interacting == -1 && var0.field846 != 0) {
                        var10 = 2;
                     }

                     if(var0.field849 > 2) {
                        var10 = 6;
                     }

                     if(var0.field849 > 3) {
                        var10 = 8;
                     }

                     if(var0.field889 > 0 && var0.field849 > 1) {
                        var10 = 8;
                        --var0.field889;
                     }
                  } else {
                     if(var0.field849 > 1) {
                        var10 = 6;
                     }

                     if(var0.field849 > 2) {
                        var10 = 8;
                     }

                     if(var0.field889 > 0 && var0.field849 > 1) {
                        var10 = 8;
                        --var0.field889;
                     }
                  }

                  if(var7 == 2) {
                     var10 <<= 1;
                  }

                  if(var10 >= 8 && var0.poseAnimation == var0.field879 && var0.field843 != -1) {
                     var0.poseAnimation = var0.field843;
                  }

                  if(var4 != var5 || var6 != var3) {
                     if(var5 < var4) {
                        var0.x += var10;
                        if(var0.x > var4) {
                           var0.x = var4;
                        }
                     } else if(var5 > var4) {
                        var0.x -= var10;
                        if(var0.x < var4) {
                           var0.x = var4;
                        }
                     }

                     if(var3 < var6) {
                        var0.y += var10;
                        if(var0.y > var6) {
                           var0.y = var6;
                        }
                     } else if(var3 > var6) {
                        var0.y -= var10;
                        if(var0.y < var6) {
                           var0.y = var6;
                        }
                     }
                  }

                  if(var4 == var0.x && var0.y == var6) {
                     --var0.field849;
                     if(var0.field839 > 0) {
                        --var0.field839;
                     }
                  }
               } else {
                  var0.x = var4;
                  var0.y = var6;
                  --var0.field849;
                  if(var0.field839 > 0) {
                     --var0.field839;
                  }
               }
            }
         }
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field891 = 0;
         var0.field878 = 0;
         var0.x = var0.field877 * 64 + 128 * var0.pathX[0];
         var0.y = 128 * var0.pathY[0] + var0.field877 * 64;
         var0.method793();
      }

      if(WidgetNode.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field891 = 0;
         var0.field878 = 0;
         var0.x = var0.field877 * 64 + 128 * var0.pathX[0];
         var0.y = var0.field877 * 64 + var0.pathY[0] * 128;
         var0.method793();
      }

      if(var0.field846 != 0) {
         if(var0.interacting != -1) {
            Object var12 = null;
            if(var0.interacting < '耀') {
               var12 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= '耀') {
               var12 = Client.cachedPlayers[var0.interacting - '耀'];
            }

            if(var12 != null) {
               var3 = var0.x - ((Actor)var12).x;
               var4 = var0.y - ((Actor)var12).y;
               if(var3 != 0 || var4 != 0) {
                  var0.field882 = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
               }
            } else if(var0.field865) {
               var0.interacting = -1;
               var0.field865 = false;
            }
         }

         if(var0.field859 != -1 && (var0.field849 == 0 || var0.field889 > 0)) {
            var0.field882 = var0.field859;
            var0.field859 = -1;
         }

         var5 = var0.field882 - var0.angle & 2047;
         if(var5 == 0 && var0.field865) {
            var0.interacting = -1;
            var0.field865 = false;
         }

         if(var5 != 0) {
            ++var0.field883;
            boolean var13;
            if(var5 > 1024) {
               var0.angle -= var0.field846;
               var13 = true;
               if(var5 < var0.field846 || var5 > 2048 - var0.field846) {
                  var0.angle = var0.field882;
                  var13 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field883 > 25 || var13)) {
                  if(var0.field866 != -1) {
                     var0.poseAnimation = var0.field866;
                  } else {
                     var0.poseAnimation = var0.field879;
                  }
               }
            } else {
               var0.angle += var0.field846;
               var13 = true;
               if(var5 < var0.field846 || var5 > 2048 - var0.field846) {
                  var0.angle = var0.field882;
                  var13 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field883 > 25 || var13)) {
                  if(var0.field853 != -1) {
                     var0.poseAnimation = var0.field853;
                  } else {
                     var0.poseAnimation = var0.field879;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field883 = 0;
         }
      }

      var0.field834 = false;
      if(var0.poseAnimation != -1) {
         var2 = class22.getAnimation(var0.poseAnimation);
         if(var2 != null && var2.field1030 != null) {
            ++var0.field862;
            if(var0.poseFrame < var2.field1030.length && var0.field862 > var2.field1018[var0.poseFrame]) {
               var0.field862 = 1;
               ++var0.poseFrame;
               method2537(var2, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var2.field1030.length) {
               var0.field862 = 0;
               var0.poseFrame = 0;
               method2537(var2, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.field871) {
         if(var0.field890 < 0) {
            var0.field890 = 0;
         }

         var5 = class110.method2488(var0.graphic).field1042;
         if(var5 != -1) {
            Sequence var14 = class22.getAnimation(var5);
            if(var14 != null && null != var14.field1030) {
               ++var0.field858;
               if(var0.field890 < var14.field1030.length && var0.field858 > var14.field1018[var0.field890]) {
                  var0.field858 = 1;
                  ++var0.field890;
                  method2537(var14, var0.field890, var0.x, var0.y);
               }

               if(var0.field890 >= var14.field1030.length && (var0.field890 < 0 || var0.field890 >= var14.field1030.length)) {
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
         var2 = class22.getAnimation(var0.animation);
         if(var2.precedenceAnimating == 1 && var0.field839 > 0 && var0.field891 <= Client.gameCycle && var0.field878 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var2 = class22.getAnimation(var0.animation);
         if(null != var2 && null != var2.field1030) {
            ++var0.field848;
            if(var0.actionFrame < var2.field1030.length && var0.field848 > var2.field1018[var0.actionFrame]) {
               var0.field848 = 1;
               ++var0.actionFrame;
               method2537(var2, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var2.field1030.length) {
               var0.actionFrame -= var2.field1020;
               ++var0.field867;
               if(var0.field867 >= var2.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var2.field1030.length) {
                  method2537(var2, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field834 = var2.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LSequence;IIIB)V",
      garbageValue = "1"
   )
   static void method2537(Sequence var0, int var1, int var2, int var3) {
      if(Client.field536 < 50 && Client.field535 != 0 && var0.field1016 != null && var1 < var0.field1016.length) {
         int var4 = var0.field1016[var1];
         if(var4 != 0) {
            int var5 = var4 >> 8;
            int var6 = var4 >> 4 & 7;
            int var7 = var4 & 15;
            Client.field319[Client.field536] = var5;
            Client.field538[Client.field536] = var6;
            Client.field539[Client.field536] = 0;
            Client.field541[Client.field536] = null;
            int var8 = (var2 - 64) / 128;
            int var9 = (var3 - 64) / 128;
            Client.field528[Client.field536] = var7 + (var8 << 16) + (var9 << 8);
            ++Client.field536;
         }
      }

   }

   static {
      new HashMap();
   }
}
