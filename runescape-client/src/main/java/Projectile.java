import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("s")
   double field97;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -799664701
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -389605053
   )
   int field99;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1841446427
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -286862287
   )
   @Export("z1")
   int z1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2110622193
   )
   int field102;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 734229399
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 615316815
   )
   int field104;
   @ObfuscatedName("w")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("x")
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1334779523
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("b")
   @Export("isMoving")
   boolean isMoving = false;
   @ObfuscatedName("g")
   @Export("x")
   double x;
   @ObfuscatedName("e")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("p")
   @Export("z")
   double z;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 632855587
   )
   @Export("start")
   int start;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1103591321
   )
   @Export("id")
   int id;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 641217149
   )
   int field114 = 0;
   @ObfuscatedName("r")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("a")
   @Export("az")
   double az;
   @ObfuscatedName("dh")
   @ObfuscatedGetter(
      intValue = -231418489
   )
   static int field117;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 919666511
   )
   int field118;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1390232255
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 63244135
   )
   int field120;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1862351299
   )
   int field121 = 0;
   @ObfuscatedName("i")
   @Export("velocityY")
   double velocityY;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1249972767"
   )
   final void method85(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var5 * var5 + var7 * var7);
         this.x = (double)this.start * var5 / var9 + (double)this.x1;
         this.velocityZ = var7 * (double)this.start / var9 + (double)this.y1;
         this.z = (double)this.z1;
      }

      var5 = (double)(1 + this.field104 - var4);
      this.field97 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.scalar * this.scalar + this.field97 * this.field97);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan(0.02454369D * (double)this.field120);
      }

      this.az = ((double)var3 - this.z - var5 * this.velocityX) * 2.0D / (var5 * var5);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(LActor;B)V",
      garbageValue = "8"
   )
   static final void method86(Actor var0) {
      var0.field828 = false;
      Sequence var1;
      if(var0.poseAnimation != -1) {
         var1 = NPC.getAnimation(var0.poseAnimation);
         if(null != var1 && null != var1.field1006) {
            ++var0.field853;
            if(var0.poseFrame < var1.field1006.length && var0.field853 > var1.field1008[var0.poseFrame]) {
               var0.field853 = 1;
               ++var0.poseFrame;
               class161.method3194(var1, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var1.field1006.length) {
               var0.field853 = 0;
               var0.poseFrame = 0;
               class161.method3194(var1, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.field865) {
         if(var0.field827 < 0) {
            var0.field827 = 0;
         }

         int var3 = class156.method3182(var0.graphic).field1035;
         if(var3 != -1) {
            Sequence var2 = NPC.getAnimation(var3);
            if(null != var2 && var2.field1006 != null) {
               ++var0.field864;
               if(var0.field827 < var2.field1006.length && var0.field864 > var2.field1008[var0.field827]) {
                  var0.field864 = 1;
                  ++var0.field827;
                  class161.method3194(var2, var0.field827, var0.x, var0.y);
               }

               if(var0.field827 >= var2.field1006.length && (var0.field827 < 0 || var0.field827 >= var2.field1006.length)) {
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
         var1 = NPC.getAnimation(var0.animation);
         if(var1.precedenceAnimating == 1 && var0.field863 > 0 && var0.field871 <= Client.gameCycle && var0.field855 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var1 = NPC.getAnimation(var0.animation);
         if(var1 != null && null != var1.field1006) {
            ++var0.field839;
            if(var0.actionFrame < var1.field1006.length && var0.field839 > var1.field1008[var0.actionFrame]) {
               var0.field839 = 1;
               ++var0.actionFrame;
               class161.method3194(var1, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var1.field1006.length) {
               var0.actionFrame -= var1.field1010;
               ++var0.field861;
               if(var0.field861 >= var1.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var1.field1006.length) {
                  class161.method3194(var1, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field828 = var1.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1714992488"
   )
   protected final Model getModel() {
      class45 var1 = class156.method3182(this.id);
      Model var2 = var1.method938(this.field114);
      if(var2 == null) {
         return null;
      } else {
         var2.method2374(this.field118);
         return var2;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "56"
   )
   final void method88(int var1) {
      this.isMoving = true;
      this.x += this.field97 * (double)var1;
      this.velocityZ += (double)var1 * this.scalar;
      this.z += this.velocityX * (double)var1 + (double)var1 * (double)var1 * 0.5D * this.az;
      this.velocityX += this.az * (double)var1;
      this.field99 = (int)(Math.atan2(this.field97, this.scalar) * 325.949D) + 1024 & 2047;
      this.field118 = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(null != this.animationSequence) {
         this.field121 += var1;

         while(true) {
            do {
               do {
                  if(this.field121 <= this.animationSequence.field1008[this.field114]) {
                     return;
                  }

                  this.field121 -= this.animationSequence.field1008[this.field114];
                  ++this.field114;
               } while(this.field114 < this.animationSequence.field1006.length);

               this.field114 -= this.animationSequence.field1010;
            } while(this.field114 >= 0 && this.field114 < this.animationSequence.field1006.length);

            this.field114 = 0;
         }
      }
   }

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.id = var1;
      this.floor = var2;
      this.x1 = var3;
      this.y1 = var4;
      this.z1 = var5;
      this.startTime = var6;
      this.field104 = var7;
      this.field120 = var8;
      this.start = var9;
      this.interacting = var10;
      this.field102 = var11;
      this.isMoving = false;
      int var12 = class156.method3182(this.id).field1035;
      if(var12 != -1) {
         this.animationSequence = NPC.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(Lclass16;I)V",
      garbageValue = "1456061764"
   )
   static final void method92(class16 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field231 == 0) {
         var1 = Frames.region.method1986(var0.field226, var0.field228, var0.field225);
      }

      if(var0.field231 == 1) {
         var1 = Frames.region.method1987(var0.field226, var0.field228, var0.field225);
      }

      if(var0.field231 == 2) {
         var1 = Frames.region.method2108(var0.field226, var0.field228, var0.field225);
      }

      if(var0.field231 == 3) {
         var1 = Frames.region.method2102(var0.field226, var0.field228, var0.field225);
      }

      if(var1 != 0) {
         int var5 = Frames.region.method1990(var0.field226, var0.field228, var0.field225, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field227 = var2;
      var0.field229 = var3;
      var0.field236 = var4;
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "([LWidget;LWidget;ZI)V",
      garbageValue = "-545885895"
   )
   static void method93(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class132.method2874(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         class132.method2874(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.method3828((long)var1.id);
      if(null != var5) {
         ObjectComposition.method874(var5.id, var3, var4, var2);
      }

      if(var1.contentType == 1337) {
         ;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)LObjectComposition;",
      garbageValue = "-1677914646"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.field937.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.field935.method3305(6, var0);
         var1 = new ObjectComposition();
         var1.field975 = var0;
         if(null != var2) {
            var1.method836(new Buffer(var2));
         }

         var1.method855();
         if(var1.field974) {
            var1.field952 = 0;
            var1.field953 = false;
         }

         ObjectComposition.field937.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LGameEngine;S)V",
      garbageValue = "4061"
   )
   static void method96(GameEngine var0) {
      if(class33.worldSelectShown) {
         Friend.method177(var0);
      } else {
         if((class143.field2206 == 1 || !class124.field2066 && class143.field2206 == 4) && class143.field2207 >= class33.field729 + 765 - 50 && class143.field2196 >= 453) {
            class130.field2102.field140 = !class130.field2102.field140;
            class216.method3980();
            if(!class130.field2102.field140) {
               class9.method116(Client.field423, "scape main", "", 255, false);
            } else {
               class186.field3008.method3735();
               class186.field3007 = 1;
               class133.field2114 = null;
            }
         }

         if(Client.gameState != 5) {
            ++class33.field755;
            if(Client.gameState == 10 || Client.gameState == 11) {
               int var1;
               if(Client.field283 == 0) {
                  if(class143.field2206 == 1 || !class124.field2066 && class143.field2206 == 4) {
                     var1 = class33.field729 + 5;
                     short var2 = 463;
                     byte var3 = 100;
                     byte var4 = 35;
                     if(class143.field2207 >= var1 && class143.field2207 <= var1 + var3 && class143.field2196 >= var2 && class143.field2196 <= var4 + var2) {
                        if(class5.loadWorlds()) {
                           class33.worldSelectShown = true;
                        }

                        return;
                     }
                  }

                  if(class93.worldServersDownload != null && class5.loadWorlds()) {
                     class33.worldSelectShown = true;
                  }
               }

               var1 = class143.field2206;
               int var13 = class143.field2207;
               int var14 = class143.field2196;
               if(!class124.field2066 && var1 == 4) {
                  var1 = 1;
               }

               short var5;
               String var6;
               int var15;
               if(class33.loginIndex == 0) {
                  var15 = 180 + class33.loginWindowX - 80;
                  var5 = 291;
                  if(var1 == 1 && var13 >= var15 - 75 && var13 <= var15 + 75 && var14 >= var5 - 20 && var14 <= 20 + var5) {
                     label763: {
                        var6 = class10.method118("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws";
                        if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                           try {
                              Desktop.getDesktop().browse(new URI(var6));
                              break label763;
                           } catch (Exception var11) {
                              ;
                           }
                        }

                        if(class141.field2182.startsWith("win")) {
                           class154.method3163(var6, 0, "openjs");
                        } else if(class141.field2182.startsWith("mac")) {
                           class154.method3163(var6, 1, "openjs");
                        } else {
                           class154.method3163(var6, 2, "openjs");
                        }
                     }
                  }

                  var15 = 180 + class33.loginWindowX + 80;
                  if(var1 == 1 && var13 >= var15 - 75 && var13 <= 75 + var15 && var14 >= var5 - 20 && var14 <= 20 + var5) {
                     if((Client.flags & 33554432) != 0) {
                        class33.field736 = "";
                        class33.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class33.loginMessage2 = "Your normal account will not be affected.";
                        class33.loginMessage3 = "";
                        class33.loginIndex = 1;
                        class33.loginIndex2 = 0;
                     } else if((Client.flags & 4) != 0) {
                        if((Client.flags & 1024) != 0) {
                           class33.loginMessage1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class33.loginMessage2 = "Players can attack each other almost everywhere";
                           class33.loginMessage3 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class33.loginMessage1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class33.loginMessage2 = "Players can attack each other";
                           class33.loginMessage3 = "almost everywhere.";
                        }

                        class33.field736 = "Warning!";
                        class33.loginIndex = 1;
                        class33.loginIndex2 = 0;
                     } else if((Client.flags & 1024) != 0) {
                        class33.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class33.loginMessage2 = "The Protect Item prayer will";
                        class33.loginMessage3 = "not work on this world.";
                        class33.field736 = "Warning!";
                        class33.loginIndex = 1;
                        class33.loginIndex2 = 0;
                     } else {
                        class33.loginMessage1 = "";
                        class33.loginMessage2 = "Enter your username/email & password.";
                        class33.loginMessage3 = "";
                        class33.loginIndex = 2;
                        class33.loginIndex2 = 0;
                     }
                  }
               } else if(class33.loginIndex != 1) {
                  short var16;
                  if(class33.loginIndex == 2) {
                     var16 = 231;
                     var15 = var16 + 30;
                     if(var1 == 1 && var14 >= var15 - 15 && var14 < var15) {
                        class33.loginIndex2 = 0;
                     }

                     var15 += 15;
                     if(var1 == 1 && var14 >= var15 - 15 && var14 < var15) {
                        class33.loginIndex2 = 1;
                     }

                     var15 += 15;
                     var16 = 361;
                     if(var1 == 1 && var14 >= var16 - 15 && var14 < var16) {
                        class51.method1075("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class33.loginIndex = 5;
                        return;
                     }

                     int var17 = class33.loginWindowX + 180 - 80;
                     short var9 = 321;
                     if(var1 == 1 && var13 >= var17 - 75 && var13 <= var17 + 75 && var14 >= var9 - 20 && var14 <= 20 + var9) {
                        class33.username = class33.username.trim();
                        if(class33.username.length() == 0) {
                           class51.method1075("", "Please enter your username/email address.", "");
                           return;
                        }

                        if(class33.field754.length() == 0) {
                           class51.method1075("", "Please enter your password.", "");
                           return;
                        }

                        class51.method1075("", "Connecting to server...", "");
                        class33.field758 = class130.field2102.field139.containsKey(Integer.valueOf(class118.method2512(class33.username)))?class162.field2646:class162.field2642;
                        class127.setGameState(20);
                        return;
                     }

                     var17 = 180 + class33.loginWindowX + 80;
                     if(var1 == 1 && var13 >= var17 - 75 && var13 <= var17 + 75 && var14 >= var9 - 20 && var14 <= var9 + 20) {
                        class33.loginIndex = 0;
                        class33.username = "";
                        class33.field754 = "";
                        class33.field756 = 0;
                        class23.authCode = "";
                        class33.field757 = true;
                     }

                     while(true) {
                        while(class0.method2()) {
                           boolean var10 = false;

                           for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                              if(ItemLayer.field1744 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                 var10 = true;
                                 break;
                              }
                           }

                           if(class13.field197 == 13) {
                              class33.loginIndex = 0;
                              class33.username = "";
                              class33.field754 = "";
                              class33.field756 = 0;
                              class23.authCode = "";
                              class33.field757 = true;
                           } else if(class33.loginIndex2 == 0) {
                              if(class13.field197 == 85 && class33.username.length() > 0) {
                                 class33.username = class33.username.substring(0, class33.username.length() - 1);
                              }

                              if(class13.field197 == 84 || class13.field197 == 80) {
                                 class33.loginIndex2 = 1;
                              }

                              if(var10 && class33.username.length() < 320) {
                                 class33.username = class33.username + ItemLayer.field1744;
                              }
                           } else if(class33.loginIndex2 == 1) {
                              if(class13.field197 == 85 && class33.field754.length() > 0) {
                                 class33.field754 = class33.field754.substring(0, class33.field754.length() - 1);
                              }

                              if(class13.field197 == 84 || class13.field197 == 80) {
                                 class33.loginIndex2 = 0;
                              }

                              if(class13.field197 == 84) {
                                 class33.username = class33.username.trim();
                                 if(class33.username.length() == 0) {
                                    class51.method1075("", "Please enter your username/email address.", "");
                                    return;
                                 }

                                 if(class33.field754.length() == 0) {
                                    class51.method1075("", "Please enter your password.", "");
                                    return;
                                 }

                                 class51.method1075("", "Connecting to server...", "");
                                 class33.field758 = class130.field2102.field139.containsKey(Integer.valueOf(class118.method2512(class33.username)))?class162.field2646:class162.field2642;
                                 class127.setGameState(20);
                                 return;
                              }

                              if(var10 && class33.field754.length() < 20) {
                                 class33.field754 = class33.field754 + ItemLayer.field1744;
                              }
                           }
                        }

                        return;
                     }
                  } else if(class33.loginIndex == 3) {
                     var15 = class33.loginWindowX + 180;
                     var5 = 276;
                     if(var1 == 1 && var13 >= var15 - 75 && var13 <= 75 + var15 && var14 >= var5 - 20 && var14 <= 20 + var5) {
                        class33.loginMessage1 = "";
                        class33.loginMessage2 = "Enter your username/email & password.";
                        class33.loginMessage3 = "";
                        class33.loginIndex = 2;
                        class33.loginIndex2 = 0;
                     }

                     var15 = 180 + class33.loginWindowX;
                     var5 = 326;
                     if(var1 == 1 && var13 >= var15 - 75 && var13 <= var15 + 75 && var14 >= var5 - 20 && var14 <= var5 + 20) {
                        class51.method1075("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class33.loginIndex = 5;
                        return;
                     }
                  } else {
                     boolean var18;
                     int var19;
                     if(class33.loginIndex == 4) {
                        var15 = class33.loginWindowX + 180 - 80;
                        var5 = 321;
                        if(var1 == 1 && var13 >= var15 - 75 && var13 <= var15 + 75 && var14 >= var5 - 20 && var14 <= var5 + 20) {
                           class23.authCode.trim();
                           if(class23.authCode.length() != 6) {
                              class51.method1075("", "Please enter a 6-digin PIN.", "");
                              return;
                           }

                           class33.field756 = Integer.parseInt(class23.authCode);
                           class23.authCode = "";
                           class33.field758 = class33.field757?class162.field2641:class162.field2644;
                           class51.method1075("", "Connecting to server...", "");
                           class127.setGameState(20);
                           return;
                        }

                        if(var1 == 1 && var13 >= 180 + class33.loginWindowX - 9 && var13 <= 130 + class33.loginWindowX + 180 && var14 >= 263 && var14 <= 296) {
                           class33.field757 = !class33.field757;
                        }

                        if(var1 == 1 && var13 >= class33.loginWindowX + 180 - 34 && var13 <= 180 + class33.loginWindowX + 34 && var14 >= 351 && var14 <= 363) {
                           label778: {
                              var6 = class10.method118("secure", true) + "m=totp-authenticator/disableTOTPRequest";
                              if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                                 try {
                                    Desktop.getDesktop().browse(new URI(var6));
                                    break label778;
                                 } catch (Exception var12) {
                                    ;
                                 }
                              }

                              if(class141.field2182.startsWith("win")) {
                                 class154.method3163(var6, 0, "openjs");
                              } else if(class141.field2182.startsWith("mac")) {
                                 class154.method3163(var6, 1, "openjs");
                              } else {
                                 class154.method3163(var6, 2, "openjs");
                              }
                           }
                        }

                        var15 = 80 + 180 + class33.loginWindowX;
                        if(var1 == 1 && var13 >= var15 - 75 && var13 <= var15 + 75 && var14 >= var5 - 20 && var14 <= 20 + var5) {
                           class33.loginIndex = 0;
                           class33.username = "";
                           class33.field754 = "";
                           class33.field756 = 0;
                           class23.authCode = "";
                        }

                        while(class0.method2()) {
                           var18 = false;

                           for(var19 = 0; var19 < "1234567890".length(); ++var19) {
                              if(ItemLayer.field1744 == "1234567890".charAt(var19)) {
                                 var18 = true;
                                 break;
                              }
                           }

                           if(class13.field197 == 13) {
                              class33.loginIndex = 0;
                              class33.username = "";
                              class33.field754 = "";
                              class33.field756 = 0;
                              class23.authCode = "";
                           } else {
                              if(class13.field197 == 85 && class23.authCode.length() > 0) {
                                 class23.authCode = class23.authCode.substring(0, class23.authCode.length() - 1);
                              }

                              if(class13.field197 == 84) {
                                 class23.authCode.trim();
                                 if(class23.authCode.length() != 6) {
                                    class51.method1075("", "Please enter a 6-digin PIN.", "");
                                    return;
                                 }

                                 class33.field756 = Integer.parseInt(class23.authCode);
                                 class23.authCode = "";
                                 class33.field758 = class33.field757?class162.field2641:class162.field2644;
                                 class51.method1075("", "Connecting to server...", "");
                                 class127.setGameState(20);
                                 return;
                              }

                              if(var18 && class23.authCode.length() < 6) {
                                 class23.authCode = class23.authCode + ItemLayer.field1744;
                              }
                           }
                        }
                     } else if(class33.loginIndex == 5) {
                        var15 = class33.loginWindowX + 180 - 80;
                        var5 = 321;
                        if(var1 == 1 && var13 >= var15 - 75 && var13 <= var15 + 75 && var14 >= var5 - 20 && var14 <= 20 + var5) {
                           class11.method134();
                           return;
                        }

                        var15 = 80 + 180 + class33.loginWindowX;
                        if(var1 == 1 && var13 >= var15 - 75 && var13 <= 75 + var15 && var14 >= var5 - 20 && var14 <= 20 + var5) {
                           class33.loginMessage1 = "";
                           class33.loginMessage2 = "Enter your username/email & password.";
                           class33.loginMessage3 = "";
                           class33.loginIndex = 2;
                           class33.loginIndex2 = 0;
                           class33.field754 = "";
                        }

                        while(class0.method2()) {
                           var18 = false;

                           for(var19 = 0; var19 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var19) {
                              if(ItemLayer.field1744 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var19)) {
                                 var18 = true;
                                 break;
                              }
                           }

                           if(class13.field197 == 13) {
                              class33.loginMessage1 = "";
                              class33.loginMessage2 = "Enter your username/email & password.";
                              class33.loginMessage3 = "";
                              class33.loginIndex = 2;
                              class33.loginIndex2 = 0;
                              class33.field754 = "";
                           } else {
                              if(class13.field197 == 85 && class33.username.length() > 0) {
                                 class33.username = class33.username.substring(0, class33.username.length() - 1);
                              }

                              if(class13.field197 == 84) {
                                 class11.method134();
                                 return;
                              }

                              if(var18 && class33.username.length() < 320) {
                                 class33.username = class33.username + ItemLayer.field1744;
                              }
                           }
                        }
                     } else if(class33.loginIndex == 6) {
                        while(true) {
                           do {
                              if(!class0.method2()) {
                                 var16 = 321;
                                 if(var1 == 1 && var14 >= var16 - 20 && var14 <= var16 + 20) {
                                    class33.loginMessage1 = "";
                                    class33.loginMessage2 = "Enter your username/email & password.";
                                    class33.loginMessage3 = "";
                                    class33.loginIndex = 2;
                                    class33.loginIndex2 = 0;
                                    class33.field754 = "";
                                 }

                                 return;
                              }
                           } while(class13.field197 != 84 && class13.field197 != 13);

                           class33.loginMessage1 = "";
                           class33.loginMessage2 = "Enter your username/email & password.";
                           class33.loginMessage3 = "";
                           class33.loginIndex = 2;
                           class33.loginIndex2 = 0;
                           class33.field754 = "";
                        }
                     }
                  }
               } else {
                  while(class0.method2()) {
                     if(class13.field197 == 84) {
                        class33.loginMessage1 = "";
                        class33.loginMessage2 = "Enter your username/email & password.";
                        class33.loginMessage3 = "";
                        class33.loginIndex = 2;
                        class33.loginIndex2 = 0;
                     } else if(class13.field197 == 13) {
                        class33.loginIndex = 0;
                     }
                  }

                  var15 = 180 + class33.loginWindowX - 80;
                  var5 = 321;
                  if(var1 == 1 && var13 >= var15 - 75 && var13 <= var15 + 75 && var14 >= var5 - 20 && var14 <= var5 + 20) {
                     class33.loginMessage1 = "";
                     class33.loginMessage2 = "Enter your username/email & password.";
                     class33.loginMessage3 = "";
                     class33.loginIndex = 2;
                     class33.loginIndex2 = 0;
                  }

                  var15 = class33.loginWindowX + 180 + 80;
                  if(var1 == 1 && var13 >= var15 - 75 && var13 <= 75 + var15 && var14 >= var5 - 20 && var14 <= 20 + var5) {
                     class33.loginIndex = 0;
                  }
               }

            }
         }
      }
   }
}
