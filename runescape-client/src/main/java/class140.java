import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("en")
public class class140 extends Node {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 56175239
   )
   int field1952;
   @ObfuscatedName("h")
   class55 field1953;
   @ObfuscatedName("p")
   class137 field1954;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -977290951
   )
   int field1955;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 2108007775
   )
   int field1957;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 650270121
   )
   int field1958;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1351847453
   )
   int field1959;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 767309557
   )
   int field1960;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -989895941
   )
   int field1961;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -355240223
   )
   int field1962;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -354565603
   )
   int field1963;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1594368721
   )
   int field1964;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -751185601
   )
   int field1965;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1753425195
   )
   int field1966;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1502835433
   )
   int field1967;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2037306091
   )
   int field1968;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1303709595
   )
   int field1969;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1168545875
   )
   int field1970;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 133302153
   )
   int field1971;
   @ObfuscatedName("d")
   class142 field1973;
   @ObfuscatedName("y")
   class66 field1975;

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(LWidget;IIZB)V",
      garbageValue = "-60"
   )
   static void method2662(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2215 == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.field2215 == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.field2215 == 2) {
         var0.width = var1 * var0.originalWidth >> 14;
      }

      if(var0.field2312 == 0) {
         var0.height = var0.field2297;
      } else if(var0.field2312 == 1) {
         var0.height = var2 - var0.field2297;
      } else if(var0.field2312 == 2) {
         var0.height = var2 * var0.field2297 >> 14;
      }

      if(var0.field2215 == 4) {
         var0.width = var0.height * var0.field2222 / var0.field2223;
      }

      if(var0.field2312 == 4) {
         var0.height = var0.field2223 * var0.width / var0.field2222;
      }

      if(Client.field505 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field477 = var0;
      }

      if(var3 && null != var0.field2211 && (var4 != var0.width || var5 != var0.height)) {
         class18 var6 = new class18();
         var6.field198 = var0;
         var6.field209 = var0.field2211;
         Client.field435.method2453(var6);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method2663() {
      this.field1973 = null;
      this.field1953 = null;
      this.field1954 = null;
      this.field1975 = null;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "21"
   )
   static void method2665() {
      for(class31 var0 = (class31)class31.field733.method2458(); var0 != null; var0 = (class31)class31.field733.method2472()) {
         if(var0.field735 != null) {
            var0.method707();
         }
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "-1904086989"
   )
   static final void method2666(Actor var0, int var1) {
      int var2;
      int var3;
      int var4;
      Sequence var11;
      if(var0.field669 > Client.gameCycle) {
         var2 = var0.field669 - Client.gameCycle;
         var3 = var0.field657 * 64 + var0.field665 * 128;
         var4 = var0.field667 * 128 + var0.field657 * 64;
         var0.x += (var3 - var0.x) / var2;
         var0.y += (var4 - var0.y) / var2;
         var0.field681 = 0;
         var0.field674 = var0.field671;
      } else {
         int var5;
         int var7;
         if(var0.field670 >= Client.gameCycle) {
            if(Client.gameCycle == var0.field670 || var0.animation == -1 || var0.actionAnimationDisable != 0 || 1 + var0.field642 > class195.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
               var2 = var0.field670 - var0.field669;
               var3 = Client.gameCycle - var0.field669;
               var4 = var0.field665 * 128 + var0.field657 * 64;
               var5 = var0.field667 * 128 + var0.field657 * 64;
               int var6 = var0.field657 * 64 + var0.field666 * 128;
               var7 = var0.field668 * 128 + var0.field657 * 64;
               var0.x = (var3 * var6 + var4 * (var2 - var3)) / var2;
               var0.y = ((var2 - var3) * var5 + var7 * var3) / var2;
            }

            var0.field681 = 0;
            var0.field674 = var0.field671;
            var0.angle = var0.field674;
         } else {
            var0.poseAnimation = var0.idlePoseAnimation;
            if(var0.field673 == 0) {
               var0.field681 = 0;
            } else {
               label609: {
                  if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
                     var11 = class195.getAnimation(var0.animation);
                     if(var0.field682 > 0 && var11.precedenceAnimating == 0) {
                        ++var0.field681;
                        break label609;
                     }

                     if(var0.field682 <= 0 && var11.priority == 0) {
                        ++var0.field681;
                        break label609;
                     }
                  }

                  var2 = var0.x;
                  var3 = var0.y;
                  var4 = 128 * var0.pathX[var0.field673 - 1] + var0.field657 * 64;
                  var5 = var0.field657 * 64 + var0.pathY[var0.field673 - 1] * 128;
                  if(var2 < var4) {
                     if(var3 < var5) {
                        var0.field674 = 1280;
                     } else if(var3 > var5) {
                        var0.field674 = 1792;
                     } else {
                        var0.field674 = 1536;
                     }
                  } else if(var2 > var4) {
                     if(var3 < var5) {
                        var0.field674 = 768;
                     } else if(var3 > var5) {
                        var0.field674 = 256;
                     } else {
                        var0.field674 = 512;
                     }
                  } else if(var3 < var5) {
                     var0.field674 = 1024;
                  } else if(var3 > var5) {
                     var0.field674 = 0;
                  }

                  byte var14 = var0.field680[var0.field673 - 1];
                  if(var4 - var2 <= 256 && var4 - var2 >= -256 && var5 - var3 <= 256 && var5 - var3 >= -256) {
                     var7 = var0.field674 - var0.angle & 2047;
                     if(var7 > 1024) {
                        var7 -= 2048;
                     }

                     int var8 = var0.field652;
                     if(var7 >= -256 && var7 <= 256) {
                        var8 = var0.field631;
                     } else if(var7 >= 256 && var7 < 768) {
                        var8 = var0.field634;
                     } else if(var7 >= -768 && var7 <= -256) {
                        var8 = var0.field633;
                     }

                     if(var8 == -1) {
                        var8 = var0.field631;
                     }

                     var0.poseAnimation = var8;
                     int var9 = 4;
                     boolean var10 = true;
                     if(var0 instanceof NPC) {
                        var10 = ((NPC)var0).composition.isClickable;
                     }

                     if(var10) {
                        if(var0.field674 != var0.angle && var0.interacting == -1 && var0.field654 != 0) {
                           var9 = 2;
                        }

                        if(var0.field673 > 2) {
                           var9 = 6;
                        }

                        if(var0.field673 > 3) {
                           var9 = 8;
                        }

                        if(var0.field681 > 0 && var0.field673 > 1) {
                           var9 = 8;
                           --var0.field681;
                        }
                     } else {
                        if(var0.field673 > 1) {
                           var9 = 6;
                        }

                        if(var0.field673 > 2) {
                           var9 = 8;
                        }

                        if(var0.field681 > 0 && var0.field673 > 1) {
                           var9 = 8;
                           --var0.field681;
                        }
                     }

                     if(var14 == 2) {
                        var9 <<= 1;
                     }

                     if(var9 >= 8 && var0.field631 == var0.poseAnimation && var0.field679 != -1) {
                        var0.poseAnimation = var0.field679;
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
                        --var0.field673;
                        if(var0.field682 > 0) {
                           --var0.field682;
                        }
                     }
                  } else {
                     var0.x = var4;
                     var0.y = var5;
                     --var0.field673;
                     if(var0.field682 > 0) {
                        --var0.field682;
                     }
                  }
               }
            }
         }
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field669 = 0;
         var0.field670 = 0;
         var0.x = 128 * var0.pathX[0] + var0.field657 * 64;
         var0.y = 128 * var0.pathY[0] + var0.field657 * 64;
         var0.method624();
      }

      if(class36.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field669 = 0;
         var0.field670 = 0;
         var0.x = 128 * var0.pathX[0] + var0.field657 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field657 * 64;
         var0.method624();
      }

      if(var0.field654 != 0) {
         if(var0.interacting != -1) {
            Object var15 = null;
            if(var0.interacting < '耀') {
               var15 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= '耀') {
               var15 = Client.cachedPlayers[var0.interacting - '耀'];
            }

            if(null != var15) {
               var3 = var0.x - ((Actor)var15).x;
               var4 = var0.y - ((Actor)var15).y;
               if(var3 != 0 || var4 != 0) {
                  var0.field674 = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
               }
            } else if(var0.field650) {
               var0.interacting = -1;
               var0.field650 = false;
            }
         }

         if(var0.field651 != -1 && (var0.field673 == 0 || var0.field681 > 0)) {
            var0.field674 = var0.field651;
            var0.field651 = -1;
         }

         var2 = var0.field674 - var0.angle & 2047;
         if(var2 == 0 && var0.field650) {
            var0.interacting = -1;
            var0.field650 = false;
         }

         if(var2 != 0) {
            ++var0.field675;
            boolean var13;
            if(var2 > 1024) {
               var0.angle -= var0.field654;
               var13 = true;
               if(var2 < var0.field654 || var2 > 2048 - var0.field654) {
                  var0.angle = var0.field674;
                  var13 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field675 > 25 || var13)) {
                  if(var0.field676 != -1) {
                     var0.poseAnimation = var0.field676;
                  } else {
                     var0.poseAnimation = var0.field631;
                  }
               }
            } else {
               var0.angle += var0.field654;
               var13 = true;
               if(var2 < var0.field654 || var2 > 2048 - var0.field654) {
                  var0.angle = var0.field674;
                  var13 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field675 > 25 || var13)) {
                  if(var0.field630 != -1) {
                     var0.poseAnimation = var0.field630;
                  } else {
                     var0.poseAnimation = var0.field631;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field675 = 0;
         }
      }

      var0.field627 = false;
      if(var0.poseAnimation != -1) {
         var11 = class195.getAnimation(var0.poseAnimation);
         if(null != var11 && var11.frameIDs != null) {
            ++var0.field635;
            if(var0.poseFrame < var11.frameIDs.length && var0.field635 > var11.frameLenghts[var0.poseFrame]) {
               var0.field635 = 1;
               ++var0.poseFrame;
               WidgetNode.method197(var11, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var11.frameIDs.length) {
               var0.field635 = 0;
               var0.poseFrame = 0;
               WidgetNode.method197(var11, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.field639) {
         if(var0.field661 < 0) {
            var0.field661 = 0;
         }

         var2 = Renderable.method1953(var0.graphic).field2807;
         if(var2 != -1) {
            Sequence var12 = class195.getAnimation(var2);
            if(null != var12 && var12.frameIDs != null) {
               ++var0.field662;
               if(var0.field661 < var12.frameIDs.length && var0.field662 > var12.frameLenghts[var0.field661]) {
                  var0.field662 = 1;
                  ++var0.field661;
                  WidgetNode.method197(var12, var0.field661, var0.x, var0.y);
               }

               if(var0.field661 >= var12.frameIDs.length && (var0.field661 < 0 || var0.field661 >= var12.frameIDs.length)) {
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
         var11 = class195.getAnimation(var0.animation);
         if(var11.precedenceAnimating == 1 && var0.field682 > 0 && var0.field669 <= Client.gameCycle && var0.field670 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var11 = class195.getAnimation(var0.animation);
         if(null != var11 && null != var11.frameIDs) {
            ++var0.field642;
            if(var0.actionFrame < var11.frameIDs.length && var0.field642 > var11.frameLenghts[var0.actionFrame]) {
               var0.field642 = 1;
               ++var0.actionFrame;
               WidgetNode.method197(var11, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var11.frameIDs.length) {
               var0.actionFrame -= var11.frameStep;
               ++var0.field677;
               if(var0.field677 >= var11.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var11.frameIDs.length) {
                  WidgetNode.method197(var11, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field627 = var11.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/Class;",
      garbageValue = "-57"
   )
   public static Class method2667(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }
}
