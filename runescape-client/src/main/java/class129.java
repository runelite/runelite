import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
public class class129 {
   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "1244551902"
   )
   static String method2826(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.field343 == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.field343 == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.field343 == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.field343 == 5) {
         var0 = var0 + "-wti";
      } else if(Client.field343 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(null != XItemContainer.field219) {
         var3 = "/p=" + XItemContainer.field219;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.field287 + "/a=" + class75.field1401 + var3 + "/";
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "-186479154"
   )
   static final void method2835(Actor var0, int var1) {
      int var2;
      int var3;
      int var4;
      if(var0.field866 > Client.gameCycle) {
         var2 = var0.field866 - Client.gameCycle;
         var3 = var0.field842 * 64 + var0.field858 * 128;
         var4 = var0.field842 * 64 + var0.field840 * 128;
         var0.x += (var3 - var0.x) / var2;
         var0.y += (var4 - var0.y) / var2;
         var0.field872 = 0;
         var0.field873 = var0.field864;
      } else {
         int var5;
         int var7;
         if(var0.field841 >= Client.gameCycle) {
            if(var0.field841 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.field850 + 1 > class62.getAnimation(var0.animation).field994[var0.actionFrame]) {
               var2 = var0.field841 - var0.field866;
               var3 = Client.gameCycle - var0.field866;
               var4 = var0.field858 * 128 + var0.field842 * 64;
               var5 = var0.field842 * 64 + var0.field840 * 128;
               int var6 = var0.field842 * 64 + var0.field859 * 128;
               var7 = var0.field861 * 128 + var0.field842 * 64;
               var0.x = (var4 * (var2 - var3) + var6 * var3) / var2;
               var0.y = (var5 * (var2 - var3) + var3 * var7) / var2;
            }

            var0.field872 = 0;
            var0.field873 = var0.field864;
            var0.angle = var0.field873;
         } else {
            var0.poseAnimation = var0.idlePoseAnimation;
            if(var0.field867 == 0) {
               var0.field872 = 0;
            } else {
               label321: {
                  if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
                     Sequence var11 = class62.getAnimation(var0.animation);
                     if(var0.field875 > 0 && var11.precedenceAnimating == 0) {
                        ++var0.field872;
                        break label321;
                     }

                     if(var0.field875 <= 0 && var11.field997 == 0) {
                        ++var0.field872;
                        break label321;
                     }
                  }

                  var2 = var0.x;
                  var3 = var0.y;
                  var4 = 128 * var0.pathX[var0.field867 - 1] + var0.field842 * 64;
                  var5 = var0.field842 * 64 + 128 * var0.pathY[var0.field867 - 1];
                  if(var2 < var4) {
                     if(var3 < var5) {
                        var0.field873 = 1280;
                     } else if(var3 > var5) {
                        var0.field873 = 1792;
                     } else {
                        var0.field873 = 1536;
                     }
                  } else if(var2 > var4) {
                     if(var3 < var5) {
                        var0.field873 = 768;
                     } else if(var3 > var5) {
                        var0.field873 = 256;
                     } else {
                        var0.field873 = 512;
                     }
                  } else if(var3 < var5) {
                     var0.field873 = 1024;
                  } else if(var3 > var5) {
                     var0.field873 = 0;
                  }

                  byte var12 = var0.field857[var0.field867 - 1];
                  if(var4 - var2 <= 256 && var4 - var2 >= -256 && var5 - var3 <= 256 && var5 - var3 >= -256) {
                     var7 = var0.field873 - var0.angle & 2047;
                     if(var7 > 1024) {
                        var7 -= 2048;
                     }

                     int var8 = var0.field825;
                     if(var7 >= -256 && var7 <= 256) {
                        var8 = var0.field824;
                     } else if(var7 >= 256 && var7 < 768) {
                        var8 = var0.field827;
                     } else if(var7 >= -768 && var7 <= -256) {
                        var8 = var0.field826;
                     }

                     if(var8 == -1) {
                        var8 = var0.field824;
                     }

                     var0.poseAnimation = var8;
                     int var9 = 4;
                     boolean var10 = true;
                     if(var0 instanceof NPC) {
                        var10 = ((NPC)var0).composition.isClickable;
                     }

                     if(var10) {
                        if(var0.field873 != var0.angle && var0.interacting == -1 && var0.field869 != 0) {
                           var9 = 2;
                        }

                        if(var0.field867 > 2) {
                           var9 = 6;
                        }

                        if(var0.field867 > 3) {
                           var9 = 8;
                        }

                        if(var0.field872 > 0 && var0.field867 > 1) {
                           var9 = 8;
                           --var0.field872;
                        }
                     } else {
                        if(var0.field867 > 1) {
                           var9 = 6;
                        }

                        if(var0.field867 > 2) {
                           var9 = 8;
                        }

                        if(var0.field872 > 0 && var0.field867 > 1) {
                           var9 = 8;
                           --var0.field872;
                        }
                     }

                     if(var12 == 2) {
                        var9 <<= 1;
                     }

                     if(var9 >= 8 && var0.field824 == var0.poseAnimation && var0.field828 != -1) {
                        var0.poseAnimation = var0.field828;
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

                     if(var4 == var0.x && var0.y == var5) {
                        --var0.field867;
                        if(var0.field875 > 0) {
                           --var0.field875;
                        }
                     }
                  } else {
                     var0.x = var4;
                     var0.y = var5;
                     --var0.field867;
                     if(var0.field875 > 0) {
                        --var0.field875;
                     }
                  }
               }
            }
         }
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field866 = 0;
         var0.field841 = 0;
         var0.x = var0.field842 * 64 + 128 * var0.pathX[0];
         var0.y = var0.pathY[0] * 128 + var0.field842 * 64;
         var0.method766();
      }

      if(class34.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field866 = 0;
         var0.field841 = 0;
         var0.x = var0.field842 * 64 + 128 * var0.pathX[0];
         var0.y = var0.pathY[0] * 128 + var0.field842 * 64;
         var0.method766();
      }

      class10.method125(var0);
      class34.method735(var0);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(CS)Z",
      garbageValue = "128"
   )
   static final boolean method2836(char var0) {
      if(Character.isISOControl(var0)) {
         return false;
      } else {
         boolean var1 = var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
         if(var1) {
            return true;
         } else {
            char[] var2 = class167.field2691;

            int var3;
            char var4;
            for(var3 = 0; var3 < var2.length; ++var3) {
               var4 = var2[var3];
               if(var0 == var4) {
                  return true;
               }
            }

            var2 = class167.field2695;

            for(var3 = 0; var3 < var2.length; ++var3) {
               var4 = var2[var3];
               if(var0 == var4) {
                  return true;
               }
            }

            return false;
         }
      }
   }
}
