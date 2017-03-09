import java.applet.Applet;
import java.awt.Image;
import java.net.URL;
import java.util.Date;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("ez")
public class class150 {
   @ObfuscatedName("rt")
   protected static Image field2042;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1300054569"
   )
   static final void method2798(int var0, int var1, int var2) {
      int var3;
      for(var3 = 0; var3 < 8; ++var3) {
         for(int var4 = 0; var4 < 8; ++var4) {
            class10.tileHeights[var0][var3 + var1][var4 + var2] = 0;
         }
      }

      if(var1 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class10.tileHeights[var0][var1][var2 + var3] = class10.tileHeights[var0][var1 - 1][var2 + var3];
         }
      }

      if(var2 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class10.tileHeights[var0][var1 + var3][var2] = class10.tileHeights[var0][var1 + var3][var2 - 1];
         }
      }

      if(var1 > 0 && class10.tileHeights[var0][var1 - 1][var2] != 0) {
         class10.tileHeights[var0][var1][var2] = class10.tileHeights[var0][var1 - 1][var2];
      } else if(var2 > 0 && class10.tileHeights[var0][var1][var2 - 1] != 0) {
         class10.tileHeights[var0][var1][var2] = class10.tileHeights[var0][var1][var2 - 1];
      } else if(var1 > 0 && var2 > 0 && class10.tileHeights[var0][var1 - 1][var2 - 1] != 0) {
         class10.tileHeights[var0][var1][var2] = class10.tileHeights[var0][var1 - 1][var2 - 1];
      }

   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(LWidget;IIZI)V",
      garbageValue = "1691142674"
   )
   static void method2799(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2185 == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.field2185 == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.field2185 == 2) {
         var0.width = var0.originalWidth * var1 >> 14;
      }

      if(var0.field2207 == 0) {
         var0.height = var0.field2198;
      } else if(var0.field2207 == 1) {
         var0.height = var2 - var0.field2198;
      } else if(var0.field2207 == 2) {
         var0.height = var2 * var0.field2198 >> 14;
      }

      if(var0.field2185 == 4) {
         var0.width = var0.height * var0.field2203 / var0.field2263;
      }

      if(var0.field2207 == 4) {
         var0.height = var0.width * var0.field2263 / var0.field2203;
      }

      if(Client.field562 && var0.type == 0) {
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
         Client.field551 = var0;
      }

      if(var3 && null != var0.field2295 && (var4 != var0.width || var5 != var0.height)) {
         class18 var6 = new class18();
         var6.field223 = var0;
         var6.field232 = var0.field2295;
         Client.field512.method2458(var6);
      }

   }

   @ObfuscatedName("x")
   public static String method2800(long var0) {
      class162.field2136.setTime(new Date(var0));
      int var2 = class162.field2136.get(7);
      int var3 = class162.field2136.get(5);
      int var4 = class162.field2136.get(2);
      int var5 = class162.field2136.get(1);
      int var6 = class162.field2136.get(11);
      int var7 = class162.field2136.get(12);
      int var8 = class162.field2136.get(13);
      return class162.field2135[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class162.field2134[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "1155146421"
   )
   static int method2801(int var0, Script var1, boolean var2) {
      if(var0 == 3600) {
         if(Client.field375 == 0) {
            class32.field756[++class32.field752 - 1] = -2;
         } else if(Client.field375 == 1) {
            class32.field756[++class32.field752 - 1] = -1;
         } else {
            class32.field756[++class32.field752 - 1] = Client.friendCount;
         }

         return 1;
      } else {
         int var3;
         if(var0 == 3601) {
            var3 = class32.field756[--class32.field752];
            if(Client.field375 == 2 && var3 < Client.friendCount) {
               class32.scriptStringStack[++class9.scriptStringStackSize - 1] = Client.friends[var3].name;
               class32.scriptStringStack[++class9.scriptStringStackSize - 1] = Client.friends[var3].previousName;
            } else {
               class32.scriptStringStack[++class9.scriptStringStackSize - 1] = "";
               class32.scriptStringStack[++class9.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 3602) {
            var3 = class32.field756[--class32.field752];
            if(Client.field375 == 2 && var3 < Client.friendCount) {
               class32.field756[++class32.field752 - 1] = Client.friends[var3].world;
            } else {
               class32.field756[++class32.field752 - 1] = 0;
            }

            return 1;
         } else if(var0 == 3603) {
            var3 = class32.field756[--class32.field752];
            if(Client.field375 == 2 && var3 < Client.friendCount) {
               class32.field756[++class32.field752 - 1] = Client.friends[var3].rank;
            } else {
               class32.field756[++class32.field752 - 1] = 0;
            }

            return 1;
         } else {
            String var11;
            if(var0 == 3604) {
               var11 = class32.scriptStringStack[--class9.scriptStringStackSize];
               int var12 = class32.field756[--class32.field752];
               Client.field309.method3076(22);
               Client.field309.method2843(class164.method3157(var11) + 1);
               Client.field309.method2857(var12);
               Client.field309.method2822(var11);
               return 1;
            } else {
               int var5;
               Ignore var6;
               String var8;
               String var15;
               Friend var16;
               String var17;
               if(var0 == 3605) {
                  var11 = class32.scriptStringStack[--class9.scriptStringStackSize];
                  if(null != var11) {
                     if((Client.friendCount < 200 || Client.field529 == 1) && Client.friendCount < 400) {
                        var15 = GroundObject.method1598(var11, class165.field2155);
                        if(null != var15) {
                           var5 = 0;

                           while(true) {
                              if(var5 >= Client.friendCount) {
                                 for(var5 = 0; var5 < Client.ignoreCount; ++var5) {
                                    var6 = Client.ignores[var5];
                                    var17 = GroundObject.method1598(var6.name, class165.field2155);
                                    if(var17 != null && var17.equals(var15)) {
                                       class30.sendGameMessage(30, "", "Please remove " + var11 + " from your ignore list first");
                                       return 1;
                                    }

                                    if(null != var6.previousName) {
                                       var8 = GroundObject.method1598(var6.previousName, class165.field2155);
                                       if(null != var8 && var8.equals(var15)) {
                                          class30.sendGameMessage(30, "", "Please remove " + var11 + " from your ignore list first");
                                          return 1;
                                       }
                                    }
                                 }

                                 if(GroundObject.method1598(class22.localPlayer.name, class165.field2155).equals(var15)) {
                                    class30.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
                                 } else {
                                    Client.field309.method3076(36);
                                    Client.field309.method2843(class164.method3157(var11));
                                    Client.field309.method2822(var11);
                                 }
                                 break;
                              }

                              var16 = Client.friends[var5];
                              var17 = GroundObject.method1598(var16.name, class165.field2155);
                              if(null != var17 && var17.equals(var15)) {
                                 class30.sendGameMessage(30, "", var11 + " is already on your friend list");
                                 break;
                              }

                              if(var16.previousName != null) {
                                 var8 = GroundObject.method1598(var16.previousName, class165.field2155);
                                 if(var8 != null && var8.equals(var15)) {
                                    class30.sendGameMessage(30, "", var11 + " is already on your friend list");
                                    break;
                                 }
                              }

                              ++var5;
                           }
                        }
                     } else {
                        class30.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
                     }
                  }

                  return 1;
               } else if(var0 == 3606) {
                  var11 = class32.scriptStringStack[--class9.scriptStringStackSize];
                  if(null != var11) {
                     var15 = GroundObject.method1598(var11, class165.field2155);
                     if(null != var15) {
                        for(var5 = 0; var5 < Client.friendCount; ++var5) {
                           var16 = Client.friends[var5];
                           var17 = var16.name;
                           var8 = GroundObject.method1598(var17, class165.field2155);
                           boolean var9;
                           if(null != var11 && var17 != null) {
                              if(!var11.startsWith("#") && !var17.startsWith("#")) {
                                 var9 = var15.equals(var8);
                              } else {
                                 var9 = var11.equals(var17);
                              }
                           } else {
                              var9 = false;
                           }

                           if(var9) {
                              --Client.friendCount;

                              for(int var10 = var5; var10 < Client.friendCount; ++var10) {
                                 Client.friends[var10] = Client.friends[var10 + 1];
                              }

                              Client.field506 = Client.field498;
                              Client.field309.method3076(196);
                              Client.field309.method2843(class164.method3157(var11));
                              Client.field309.method2822(var11);
                              break;
                           }
                        }
                     }
                  }

                  return 1;
               } else if(var0 == 3607) {
                  var11 = class32.scriptStringStack[--class9.scriptStringStackSize];
                  if(var11 != null) {
                     if((Client.ignoreCount < 100 || Client.field529 == 1) && Client.ignoreCount < 400) {
                        var15 = GroundObject.method1598(var11, class165.field2155);
                        if(null != var15) {
                           var5 = 0;

                           while(true) {
                              if(var5 >= Client.ignoreCount) {
                                 for(var5 = 0; var5 < Client.friendCount; ++var5) {
                                    var16 = Client.friends[var5];
                                    var17 = GroundObject.method1598(var16.name, class165.field2155);
                                    if(var17 != null && var17.equals(var15)) {
                                       class30.sendGameMessage(31, "", "Please remove " + var11 + " from your friend list first");
                                       return 1;
                                    }

                                    if(null != var16.previousName) {
                                       var8 = GroundObject.method1598(var16.previousName, class165.field2155);
                                       if(null != var8 && var8.equals(var15)) {
                                          class30.sendGameMessage(31, "", "Please remove " + var11 + " from your friend list first");
                                          return 1;
                                       }
                                    }
                                 }

                                 if(GroundObject.method1598(class22.localPlayer.name, class165.field2155).equals(var15)) {
                                    class30.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
                                 } else {
                                    Client.field309.method3076(190);
                                    Client.field309.method2843(class164.method3157(var11));
                                    Client.field309.method2822(var11);
                                 }
                                 break;
                              }

                              var6 = Client.ignores[var5];
                              var17 = GroundObject.method1598(var6.name, class165.field2155);
                              if(var17 != null && var17.equals(var15)) {
                                 class30.sendGameMessage(31, "", var11 + " is already on your ignore list");
                                 break;
                              }

                              if(var6.previousName != null) {
                                 var8 = GroundObject.method1598(var6.previousName, class165.field2155);
                                 if(var8 != null && var8.equals(var15)) {
                                    class30.sendGameMessage(31, "", var11 + " is already on your ignore list");
                                    break;
                                 }
                              }

                              ++var5;
                           }
                        }
                     } else {
                        class30.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
                     }
                  }

                  return 1;
               } else if(var0 == 3608) {
                  var11 = class32.scriptStringStack[--class9.scriptStringStackSize];
                  class184.method3425(var11);
                  return 1;
               } else if(var0 == 3609) {
                  var11 = class32.scriptStringStack[--class9.scriptStringStackSize];
                  class177[] var4 = new class177[]{class177.field2655, class177.field2659, class177.field2653, class177.field2652, class177.field2657, class177.field2654};
                  class177[] var13 = var4;

                  for(int var14 = 0; var14 < var13.length; ++var14) {
                     class177 var7 = var13[var14];
                     if(var7.field2658 != -1 && var11.startsWith(class112.method2140(var7.field2658))) {
                        var11 = var11.substring(6 + Integer.toString(var7.field2658).length());
                        break;
                     }
                  }

                  class32.field756[++class32.field752 - 1] = MessageNode.method228(var11, false)?1:0;
                  return 1;
               } else if(var0 == 3611) {
                  if(Client.field540 != null) {
                     class32.scriptStringStack[++class9.scriptStringStackSize - 1] = FaceNormal.method1953(Client.field540);
                  } else {
                     class32.scriptStringStack[++class9.scriptStringStackSize - 1] = "";
                  }

                  return 1;
               } else if(var0 == 3612) {
                  if(null != Client.field540) {
                     class32.field756[++class32.field752 - 1] = class9.clanChatCount;
                  } else {
                     class32.field756[++class32.field752 - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3613) {
                  var3 = class32.field756[--class32.field752];
                  if(Client.field540 != null && var3 < class9.clanChatCount) {
                     class32.scriptStringStack[++class9.scriptStringStackSize - 1] = class137.clanMembers[var3].username;
                  } else {
                     class32.scriptStringStack[++class9.scriptStringStackSize - 1] = "";
                  }

                  return 1;
               } else if(var0 == 3614) {
                  var3 = class32.field756[--class32.field752];
                  if(Client.field540 != null && var3 < class9.clanChatCount) {
                     class32.field756[++class32.field752 - 1] = class137.clanMembers[var3].world;
                  } else {
                     class32.field756[++class32.field752 - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3615) {
                  var3 = class32.field756[--class32.field752];
                  if(null != Client.field540 && var3 < class9.clanChatCount) {
                     class32.field756[++class32.field752 - 1] = class137.clanMembers[var3].rank;
                  } else {
                     class32.field756[++class32.field752 - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3616) {
                  class32.field756[++class32.field752 - 1] = class107.field1746;
                  return 1;
               } else if(var0 == 3617) {
                  var11 = class32.scriptStringStack[--class9.scriptStringStackSize];
                  class18.method212(var11);
                  return 1;
               } else if(var0 == 3618) {
                  class32.field756[++class32.field752 - 1] = class9.field103;
                  return 1;
               } else if(var0 == 3619) {
                  var11 = class32.scriptStringStack[--class9.scriptStringStackSize];
                  CombatInfo1.method625(var11);
                  return 1;
               } else if(var0 == 3620) {
                  Client.field309.method3076(164);
                  Client.field309.method2843(0);
                  return 1;
               } else if(var0 == 3621) {
                  if(Client.field375 == 0) {
                     class32.field756[++class32.field752 - 1] = -1;
                  } else {
                     class32.field756[++class32.field752 - 1] = Client.ignoreCount;
                  }

                  return 1;
               } else if(var0 == 3622) {
                  var3 = class32.field756[--class32.field752];
                  if(Client.field375 != 0 && var3 < Client.ignoreCount) {
                     class32.scriptStringStack[++class9.scriptStringStackSize - 1] = Client.ignores[var3].name;
                     class32.scriptStringStack[++class9.scriptStringStackSize - 1] = Client.ignores[var3].previousName;
                  } else {
                     class32.scriptStringStack[++class9.scriptStringStackSize - 1] = "";
                     class32.scriptStringStack[++class9.scriptStringStackSize - 1] = "";
                  }

                  return 1;
               } else if(var0 == 3623) {
                  var11 = class32.scriptStringStack[--class9.scriptStringStackSize];
                  if(var11.startsWith(class112.method2140(0)) || var11.startsWith(class112.method2140(1))) {
                     var11 = var11.substring(7);
                  }

                  class32.field756[++class32.field752 - 1] = GameEngine.method2242(var11)?1:0;
                  return 1;
               } else if(var0 != 3624) {
                  if(var0 == 3625) {
                     if(Client.clanChatOwner != null) {
                        class32.scriptStringStack[++class9.scriptStringStackSize - 1] = FaceNormal.method1953(Client.clanChatOwner);
                     } else {
                        class32.scriptStringStack[++class9.scriptStringStackSize - 1] = "";
                     }

                     return 1;
                  } else {
                     return 2;
                  }
               } else {
                  var3 = class32.field756[--class32.field752];
                  if(class137.clanMembers != null && var3 < class9.clanChatCount && class137.clanMembers[var3].username.equalsIgnoreCase(class22.localPlayer.name)) {
                     class32.field756[++class32.field752 - 1] = 1;
                  } else {
                     class32.field756[++class32.field752 - 1] = 0;
                  }

                  return 1;
               }
            }
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;S)Z",
      garbageValue = "23890"
   )
   static boolean method2802(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class114.field1794.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var14 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var14.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var8) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Applet var7 = class114.field1798;
            Object[] var5 = new Object[]{(new URL(class114.field1798.getCodeBase(), var0)).toString()};
            Object var13 = JSObject.getWindow(var7).call(var2, var5);
            return null != var13;
         } catch (Throwable var9) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class114.field1798.getAppletContext().showDocument(new URL(class114.field1798.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var10) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            Applet var3 = class114.field1798;
            JSObject.getWindow(var3).call("loggedout", (Object[])null);
         } catch (Throwable var12) {
            ;
         }

         try {
            class114.field1798.getAppletContext().showDocument(new URL(class114.field1798.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var11) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   class150() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass182;III)[LSpritePixels;",
      garbageValue = "1682330447"
   )
   static SpritePixels[] method2804(class182 var0, int var1, int var2) {
      if(!class65.method1246(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels[] var4 = new SpritePixels[class225.field3235];

         for(int var5 = 0; var5 < class225.field3235; ++var5) {
            SpritePixels var6 = var4[var5] = new SpritePixels();
            var6.maxWidth = class203.field3083;
            var6.maxHeight = class225.field3232;
            var6.offsetX = XItemContainer.field147[var5];
            var6.offsetY = class203.field3085[var5];
            var6.width = class225.field3233[var5];
            var6.height = class225.field3231[var5];
            int var7 = var6.width * var6.height;
            byte[] var8 = RSCanvas.field1766[var5];
            var6.image = new int[var7];

            for(int var9 = 0; var9 < var7; ++var9) {
               var6.image[var9] = class225.field3237[var8[var9] & 255];
            }
         }

         XItemContainer.field147 = null;
         class203.field3085 = null;
         class225.field3233 = null;
         class225.field3231 = null;
         class225.field3237 = null;
         RSCanvas.field1766 = null;
         return var4;
      }
   }
}
