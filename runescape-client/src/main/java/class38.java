import java.awt.Component;
import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public class class38 {
   @ObfuscatedName("w")
   String field790;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1525926321
   )
   int field791;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 759545513
   )
   int field792;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1575068895
   )
   int field793;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -165967033
   )
   int field796;

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(LWidget;IIZI)V",
      garbageValue = "1871464636"
   )
   static void method760(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2056 == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.field2056 == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.field2056 == 2) {
         var0.width = var0.originalWidth * var1 >> 14;
      }

      if(var0.field2151 == 0) {
         var0.height = var0.field2061;
      } else if(var0.field2151 == 1) {
         var0.height = var2 - var0.field2061;
      } else if(var0.field2151 == 2) {
         var0.height = var2 * var0.field2061 >> 14;
      }

      if(var0.field2056 == 4) {
         var0.width = var0.field2066 * var0.height / var0.field2067;
      }

      if(var0.field2151 == 4) {
         var0.height = var0.width * var0.field2067 / var0.field2066;
      }

      if(Client.field486 && var0.type == 0) {
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
         Client.field467 = var0;
      }

      if(var3 && null != var0.field2158 && (var0.width != var4 || var5 != var0.height)) {
         class18 var6 = new class18();
         var6.field190 = var0;
         var6.field198 = var0.field2158;
         Client.field476.method2380(var6);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;Lclass182;Lclass182;ZII)V",
      garbageValue = "-1067553955"
   )
   static void method761(Component var0, class182 var1, class182 var2, boolean var3, int var4) {
      if(class41.field845) {
         if(var4 == 4) {
            class41.loginIndex = 4;
         }

      } else {
         class41.loginIndex = var4;
         Rasterizer2D.method3977();
         byte[] var5 = var1.method3341("title.jpg", "");
         class156.field2209 = new SpritePixels(var5, var0);
         class148.field2032 = class156.field2209.method4102();
         if((Client.flags & 536870912) != 0) {
            class1.field11 = class167.method3205(var2, "logo_deadman_mode", "");
         } else {
            class1.field11 = class167.method3205(var2, "logo", "");
         }

         class41.field821 = class167.method3205(var2, "titlebox", "");
         class41.field820 = class167.method3205(var2, "titlebutton", "");
         class41.field823 = FrameMap.method1705(var2, "runes", "");
         class41.field824 = FrameMap.method1705(var2, "title_mute", "");
         class60.field1079 = class167.method3205(var2, "options_radio_buttons,0", "");
         class179.field2677 = class167.method3205(var2, "options_radio_buttons,2", "");
         class5.field47 = new int[256];

         int var6;
         for(var6 = 0; var6 < 64; ++var6) {
            class5.field47[var6] = var6 * 262144;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class5.field47[var6 + 64] = 1024 * var6 + 16711680;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class5.field47[128 + var6] = var6 * 4 + 16776960;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class5.field47[var6 + 192] = 16777215;
         }

         class205.field3071 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class205.field3071[var6] = 1024 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class205.field3071[64 + var6] = '\uff00' + var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class205.field3071[128 + var6] = 262144 * var6 + '\uffff';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class205.field3071[192 + var6] = 16777215;
         }

         class41.field829 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class41.field829[var6] = 4 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class41.field829[var6 + 64] = var6 * 262144 + 255;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class41.field829[128 + var6] = 1024 * var6 + 16711935;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class41.field829[var6 + 192] = 16777215;
         }

         class41.field828 = new int[256];
         class60.field1083 = new int['耀'];
         class116.field1818 = new int['耀'];
         class101.method1939((ModIcon)null);
         class41.field847 = new int['耀'];
         class41.field833 = new int['耀'];
         if(var3) {
            class41.username = "";
            class41.field844 = "";
         }

         class2.field27 = 0;
         ChatLineBuffer.authCode = "";
         class41.field848 = true;
         class41.worldSelectShown = false;
         if(!class85.field1456.field683) {
            class72.method1415(2, ChatMessages.field923, "scape main", "", 255, false);
         } else {
            class103.method1966(2);
         }

         Renderable.method1875(false);
         class41.field845 = true;
         class41.field846 = (XItemContainer.field123 - Client.field537) / 2;
         class41.loginWindowX = class41.field846 + 202;
         class156.field2209.method4139(class41.field846, 0);
         class148.field2032.method4139(382 + class41.field846, 0);
         class1.field11.method4064(382 + class41.field846 - class1.field11.originalWidth / 2, 18);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass166;II)V",
      garbageValue = "1266934519"
   )
   static final void method762(class166 var0, int var1) {
      int var2 = var0.offset;
      class45.field908 = 0;
      int var3 = 0;
      var0.method3175();

      int var4;
      int var5;
      int var6;
      for(var4 = 0; var4 < class45.field901; ++var4) {
         var5 = class45.field902[var4];
         if((class45.field898[var5] & 1) == 0) {
            if(var3 > 0) {
               --var3;
               class45.field898[var5] = (byte)(class45.field898[var5] | 2);
            } else {
               var6 = var0.method3176(1);
               if(var6 == 0) {
                  var3 = DecorativeObject.method1908(var0);
                  class45.field898[var5] = (byte)(class45.field898[var5] | 2);
               } else {
                  TextureProvider.method1466(var0, var5);
               }
            }
         }
      }

      var0.method3177();
      if(var3 != 0) {
         throw new RuntimeException();
      } else {
         var0.method3175();

         for(var4 = 0; var4 < class45.field901; ++var4) {
            var5 = class45.field902[var4];
            if((class45.field898[var5] & 1) != 0) {
               if(var3 > 0) {
                  --var3;
                  class45.field898[var5] = (byte)(class45.field898[var5] | 2);
               } else {
                  var6 = var0.method3176(1);
                  if(var6 == 0) {
                     var3 = DecorativeObject.method1908(var0);
                     class45.field898[var5] = (byte)(class45.field898[var5] | 2);
                  } else {
                     TextureProvider.method1466(var0, var5);
                  }
               }
            }
         }

         var0.method3177();
         if(var3 != 0) {
            throw new RuntimeException();
         } else {
            var0.method3175();

            for(var4 = 0; var4 < class45.field903; ++var4) {
               var5 = class45.field905[var4];
               if((class45.field898[var5] & 1) != 0) {
                  if(var3 > 0) {
                     --var3;
                     class45.field898[var5] = (byte)(class45.field898[var5] | 2);
                  } else {
                     var6 = var0.method3176(1);
                     if(var6 == 0) {
                        var3 = DecorativeObject.method1908(var0);
                        class45.field898[var5] = (byte)(class45.field898[var5] | 2);
                     } else if(ChatMessages.method850(var0, var5)) {
                        class45.field898[var5] = (byte)(class45.field898[var5] | 2);
                     }
                  }
               }
            }

            var0.method3177();
            if(var3 != 0) {
               throw new RuntimeException();
            } else {
               var0.method3175();

               for(var4 = 0; var4 < class45.field903; ++var4) {
                  var5 = class45.field905[var4];
                  if((class45.field898[var5] & 1) == 0) {
                     if(var3 > 0) {
                        --var3;
                        class45.field898[var5] = (byte)(class45.field898[var5] | 2);
                     } else {
                        var6 = var0.method3176(1);
                        if(var6 == 0) {
                           var3 = DecorativeObject.method1908(var0);
                           class45.field898[var5] = (byte)(class45.field898[var5] | 2);
                        } else if(ChatMessages.method850(var0, var5)) {
                           class45.field898[var5] = (byte)(class45.field898[var5] | 2);
                        }
                     }
                  }
               }

               var0.method3177();
               if(var3 != 0) {
                  throw new RuntimeException();
               } else {
                  class45.field901 = 0;
                  class45.field903 = 0;

                  Player var7;
                  for(var4 = 1; var4 < 2048; ++var4) {
                     class45.field898[var4] = (byte)(class45.field898[var4] >> 1);
                     var7 = Client.cachedPlayers[var4];
                     if(var7 != null) {
                        class45.field902[++class45.field901 - 1] = var4;
                     } else {
                        class45.field905[++class45.field903 - 1] = var4;
                     }
                  }

                  for(var3 = 0; var3 < class45.field908; ++var3) {
                     var4 = class45.field909[var3];
                     var7 = Client.cachedPlayers[var4];
                     var6 = var0.readUnsignedByte();
                     if((var6 & 16) != 0) {
                        var6 += var0.readUnsignedByte() << 8;
                     }

                     class3.method31(var0, var4, var7, var6);
                  }

                  if(var0.offset - var2 != var1) {
                     throw new RuntimeException(var0.offset - var2 + " " + var1);
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LGameEngine;B)V",
      garbageValue = "0"
   )
   static void method763(GameEngine var0) {
      int var1;
      int var2;
      int var3;
      int var19;
      if(class41.worldSelectShown) {
         if(class115.field1804 == 1 || !class115.field1809 && class115.field1804 == 4) {
            var1 = class41.field846 + 280;
            if(class115.field1800 >= var1 && class115.field1800 <= 14 + var1 && class115.field1807 >= 4 && class115.field1807 <= 18) {
               class210.method3946(0, 0);
            } else if(class115.field1800 >= 15 + var1 && class115.field1800 <= 80 + var1 && class115.field1807 >= 4 && class115.field1807 <= 18) {
               class210.method3946(0, 1);
            } else {
               var2 = 390 + class41.field846;
               if(class115.field1800 >= var2 && class115.field1800 <= 14 + var2 && class115.field1807 >= 4 && class115.field1807 <= 18) {
                  class210.method3946(1, 0);
               } else if(class115.field1800 >= var2 + 15 && class115.field1800 <= 80 + var2 && class115.field1807 >= 4 && class115.field1807 <= 18) {
                  class210.method3946(1, 1);
               } else {
                  var3 = class41.field846 + 500;
                  if(class115.field1800 >= var3 && class115.field1800 <= var3 + 14 && class115.field1807 >= 4 && class115.field1807 <= 18) {
                     class210.method3946(2, 0);
                  } else if(class115.field1800 >= 15 + var3 && class115.field1800 <= var3 + 80 && class115.field1807 >= 4 && class115.field1807 <= 18) {
                     class210.method3946(2, 1);
                  } else {
                     var19 = 610 + class41.field846;
                     if(class115.field1800 >= var19 && class115.field1800 <= 14 + var19 && class115.field1807 >= 4 && class115.field1807 <= 18) {
                        class210.method3946(3, 0);
                     } else if(class115.field1800 >= var19 + 15 && class115.field1800 <= var19 + 80 && class115.field1807 >= 4 && class115.field1807 <= 18) {
                        class210.method3946(3, 1);
                     } else if(class115.field1800 >= class41.field846 + 708 && class115.field1807 >= 4 && class115.field1800 <= 50 + class41.field846 + 708 && class115.field1807 <= 20) {
                        class41.worldSelectShown = false;
                        class156.field2209.method4139(class41.field846, 0);
                        class148.field2032.method4139(382 + class41.field846, 0);
                        class1.field11.method4064(382 + class41.field846 - class1.field11.originalWidth / 2, 18);
                     } else if(class41.field853 != -1) {
                        World var5 = WidgetNode.worldList[class41.field853];
                        class47.method891(var5);
                        class41.worldSelectShown = false;
                        class156.field2209.method4139(class41.field846, 0);
                        class148.field2032.method4139(382 + class41.field846, 0);
                        class1.field11.method4064(382 + class41.field846 - class1.field11.originalWidth / 2, 18);
                     }
                  }
               }
            }
         }

      } else {
         if((class115.field1804 == 1 || !class115.field1809 && class115.field1804 == 4) && class115.field1800 >= 765 + class41.field846 - 50 && class115.field1807 >= 453) {
            class85.field1456.field683 = !class85.field1456.field683;
            class3.method39();
            if(!class85.field1456.field683) {
               class184 var9 = ChatMessages.field923;
               var2 = var9.method3284("scape main");
               var3 = var9.method3285(var2, "");
               class159.method2909(var9, var2, var3, 255, false);
            } else {
               class85.method1702();
            }
         }

         if(Client.gameState != 5) {
            ++class41.field836;
            if(Client.gameState == 10 || Client.gameState == 11) {
               if(Client.field285 == 0) {
                  if(class115.field1804 == 1 || !class115.field1809 && class115.field1804 == 4) {
                     var1 = 5 + class41.field846;
                     short var16 = 463;
                     byte var17 = 100;
                     byte var4 = 35;
                     if(class115.field1800 >= var1 && class115.field1800 <= var17 + var1 && class115.field1807 >= var16 && class115.field1807 <= var4 + var16) {
                        class163.method3158();
                        return;
                     }
                  }

                  if(null != World.worldServersDownload) {
                     class163.method3158();
                  }
               }

               var1 = class115.field1804;
               var2 = class115.field1800;
               var3 = class115.field1807;
               if(!class115.field1809 && var1 == 4) {
                  var1 = 1;
               }

               short var6;
               int var10;
               if(class41.loginIndex == 0) {
                  boolean var18 = false;

                  while(class205.method3821()) {
                     if(class44.field893 == 84) {
                        var18 = true;
                     }
                  }

                  var10 = 180 + class41.loginWindowX - 80;
                  var6 = 291;
                  if(var1 == 1 && var2 >= var10 - 75 && var2 <= 75 + var10 && var3 >= var6 - 20 && var3 <= 20 + var6) {
                     label907: {
                        String var7 = class6.method96("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws";
                        if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                           try {
                              Desktop.getDesktop().browse(new URI(var7));
                              break label907;
                           } catch (Exception var15) {
                              ;
                           }
                        }

                        if(class114.field1785.startsWith("win")) {
                           class11.method169(var7, 0, "openjs");
                        } else if(class114.field1785.startsWith("mac")) {
                           class11.method169(var7, 1, "openjs");
                        } else {
                           class11.method169(var7, 2, "openjs");
                        }
                     }
                  }

                  var10 = 180 + class41.loginWindowX + 80;
                  if(var1 == 1 && var2 >= var10 - 75 && var2 <= var10 + 75 && var3 >= var6 - 20 && var3 <= 20 + var6 || var18) {
                     if((Client.flags & 33554432) != 0) {
                        class41.field819 = "";
                        class41.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class41.loginMessage2 = "Your normal account will not be affected.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 1;
                        class41.loginIndex2 = 0;
                     } else if((Client.flags & 4) != 0) {
                        if((Client.flags & 1024) != 0) {
                           class41.loginMessage1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class41.loginMessage2 = "Players can attack each other almost everywhere";
                           class41.loginMessage3 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class41.loginMessage1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class41.loginMessage2 = "Players can attack each other";
                           class41.loginMessage3 = "almost everywhere.";
                        }

                        class41.field819 = "Warning!";
                        class41.loginIndex = 1;
                        class41.loginIndex2 = 0;
                     } else if((Client.flags & 1024) != 0) {
                        class41.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class41.loginMessage2 = "The Protect Item prayer will";
                        class41.loginMessage3 = "not work on this world.";
                        class41.field819 = "Warning!";
                        class41.loginIndex = 1;
                        class41.loginIndex2 = 0;
                     } else {
                        class41.loginMessage1 = "";
                        class41.loginMessage2 = "Enter your username/email & password.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 2;
                        class41.loginIndex2 = 0;
                     }
                  }
               } else {
                  short var22;
                  if(class41.loginIndex != 1) {
                     short var20;
                     if(class41.loginIndex == 2) {
                        var20 = 231;
                        var19 = var20 + 30;
                        if(var1 == 1 && var3 >= var19 - 15 && var3 < var19) {
                           class41.loginIndex2 = 0;
                        }

                        var19 += 15;
                        if(var1 == 1 && var3 >= var19 - 15 && var3 < var19) {
                           class41.loginIndex2 = 1;
                        }

                        var19 += 15;
                        var20 = 361;
                        if(var1 == 1 && var3 >= var20 - 15 && var3 < var20) {
                           PlayerComposition.method2762("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class41.loginIndex = 5;
                           return;
                        }

                        var10 = 180 + class41.loginWindowX - 80;
                        var6 = 321;
                        if(var1 == 1 && var2 >= var10 - 75 && var2 <= var10 + 75 && var3 >= var6 - 20 && var3 <= 20 + var6) {
                           class41.username = class41.username.trim();
                           if(class41.username.length() == 0) {
                              PlayerComposition.method2762("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(class41.field844.length() == 0) {
                              PlayerComposition.method2762("", "Please enter your password.", "");
                              return;
                           }

                           PlayerComposition.method2762("", "Connecting to server...", "");
                           class41.field854 = class85.field1456.field688.containsKey(Integer.valueOf(Tile.method1561(class41.username)))?class97.field1628:class97.field1624;
                           class11.setGameState(20);
                           return;
                        }

                        var10 = 80 + 180 + class41.loginWindowX;
                        if(var1 == 1 && var2 >= var10 - 75 && var2 <= 75 + var10 && var3 >= var6 - 20 && var3 <= var6 + 20) {
                           class41.loginIndex = 0;
                           class41.username = "";
                           class41.field844 = "";
                           class2.field27 = 0;
                           ChatLineBuffer.authCode = "";
                           class41.field848 = true;
                        }

                        while(true) {
                           while(class205.method3821()) {
                              boolean var11 = false;

                              for(int var12 = 0; var12 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var12) {
                                 if(XClanMember.field273 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var12)) {
                                    var11 = true;
                                    break;
                                 }
                              }

                              if(class44.field893 == 13) {
                                 class41.loginIndex = 0;
                                 class41.username = "";
                                 class41.field844 = "";
                                 class2.field27 = 0;
                                 ChatLineBuffer.authCode = "";
                                 class41.field848 = true;
                              } else if(class41.loginIndex2 == 0) {
                                 if(class44.field893 == 85 && class41.username.length() > 0) {
                                    class41.username = class41.username.substring(0, class41.username.length() - 1);
                                 }

                                 if(class44.field893 == 84 || class44.field893 == 80) {
                                    class41.loginIndex2 = 1;
                                 }

                                 if(var11 && class41.username.length() < 320) {
                                    class41.username = class41.username + XClanMember.field273;
                                 }
                              } else if(class41.loginIndex2 == 1) {
                                 if(class44.field893 == 85 && class41.field844.length() > 0) {
                                    class41.field844 = class41.field844.substring(0, class41.field844.length() - 1);
                                 }

                                 if(class44.field893 == 84 || class44.field893 == 80) {
                                    class41.loginIndex2 = 0;
                                 }

                                 if(class44.field893 == 84) {
                                    class41.username = class41.username.trim();
                                    if(class41.username.length() == 0) {
                                       PlayerComposition.method2762("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(class41.field844.length() == 0) {
                                       PlayerComposition.method2762("", "Please enter your password.", "");
                                       return;
                                    }

                                    PlayerComposition.method2762("", "Connecting to server...", "");
                                    class41.field854 = class85.field1456.field688.containsKey(Integer.valueOf(Tile.method1561(class41.username)))?class97.field1628:class97.field1624;
                                    class11.setGameState(20);
                                    return;
                                 }

                                 if(var11 && class41.field844.length() < 20) {
                                    class41.field844 = class41.field844 + XClanMember.field273;
                                 }
                              }
                           }

                           return;
                        }
                     } else if(class41.loginIndex == 3) {
                        var19 = class41.loginWindowX + 180;
                        var22 = 276;
                        if(var1 == 1 && var2 >= var19 - 75 && var2 <= var19 + 75 && var3 >= var22 - 20 && var3 <= var22 + 20) {
                           class41.loginMessage1 = "";
                           class41.loginMessage2 = "Enter your username/email & password.";
                           class41.loginMessage3 = "";
                           class41.loginIndex = 2;
                           class41.loginIndex2 = 0;
                        }

                        var19 = 180 + class41.loginWindowX;
                        var22 = 326;
                        if(var1 == 1 && var2 >= var19 - 75 && var2 <= var19 + 75 && var3 >= var22 - 20 && var3 <= var22 + 20) {
                           PlayerComposition.method2762("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class41.loginIndex = 5;
                           return;
                        }
                     } else {
                        boolean var21;
                        int var23;
                        if(class41.loginIndex == 4) {
                           var19 = class41.loginWindowX + 180 - 80;
                           var22 = 321;
                           if(var1 == 1 && var2 >= var19 - 75 && var2 <= var19 + 75 && var3 >= var22 - 20 && var3 <= 20 + var22) {
                              ChatLineBuffer.authCode.trim();
                              if(ChatLineBuffer.authCode.length() != 6) {
                                 PlayerComposition.method2762("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              class2.field27 = Integer.parseInt(ChatLineBuffer.authCode);
                              ChatLineBuffer.authCode = "";
                              class41.field854 = class41.field848?class97.field1623:class97.field1625;
                              PlayerComposition.method2762("", "Connecting to server...", "");
                              class11.setGameState(20);
                              return;
                           }

                           if(var1 == 1 && var2 >= 180 + class41.loginWindowX - 9 && var2 <= 130 + 180 + class41.loginWindowX && var3 >= 263 && var3 <= 296) {
                              class41.field848 = !class41.field848;
                           }

                           if(var1 == 1 && var2 >= class41.loginWindowX + 180 - 34 && var2 <= 180 + class41.loginWindowX + 34 && var3 >= 351 && var3 <= 363) {
                              label922: {
                                 String var13 = class6.method96("secure", true) + "m=totp-authenticator/disableTOTPRequest";
                                 if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                                    try {
                                       Desktop.getDesktop().browse(new URI(var13));
                                       break label922;
                                    } catch (Exception var14) {
                                       ;
                                    }
                                 }

                                 if(class114.field1785.startsWith("win")) {
                                    class11.method169(var13, 0, "openjs");
                                 } else if(class114.field1785.startsWith("mac")) {
                                    class11.method169(var13, 1, "openjs");
                                 } else {
                                    class11.method169(var13, 2, "openjs");
                                 }
                              }
                           }

                           var19 = 180 + class41.loginWindowX + 80;
                           if(var1 == 1 && var2 >= var19 - 75 && var2 <= 75 + var19 && var3 >= var22 - 20 && var3 <= var22 + 20) {
                              class41.loginIndex = 0;
                              class41.username = "";
                              class41.field844 = "";
                              class2.field27 = 0;
                              ChatLineBuffer.authCode = "";
                           }

                           while(class205.method3821()) {
                              var21 = false;

                              for(var23 = 0; var23 < "1234567890".length(); ++var23) {
                                 if(XClanMember.field273 == "1234567890".charAt(var23)) {
                                    var21 = true;
                                    break;
                                 }
                              }

                              if(class44.field893 == 13) {
                                 class41.loginIndex = 0;
                                 class41.username = "";
                                 class41.field844 = "";
                                 class2.field27 = 0;
                                 ChatLineBuffer.authCode = "";
                              } else {
                                 if(class44.field893 == 85 && ChatLineBuffer.authCode.length() > 0) {
                                    ChatLineBuffer.authCode = ChatLineBuffer.authCode.substring(0, ChatLineBuffer.authCode.length() - 1);
                                 }

                                 if(class44.field893 == 84) {
                                    ChatLineBuffer.authCode.trim();
                                    if(ChatLineBuffer.authCode.length() != 6) {
                                       PlayerComposition.method2762("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    class2.field27 = Integer.parseInt(ChatLineBuffer.authCode);
                                    ChatLineBuffer.authCode = "";
                                    class41.field854 = class41.field848?class97.field1623:class97.field1625;
                                    PlayerComposition.method2762("", "Connecting to server...", "");
                                    class11.setGameState(20);
                                    return;
                                 }

                                 if(var21 && ChatLineBuffer.authCode.length() < 6) {
                                    ChatLineBuffer.authCode = ChatLineBuffer.authCode + XClanMember.field273;
                                 }
                              }
                           }
                        } else if(class41.loginIndex == 5) {
                           var19 = 180 + class41.loginWindowX - 80;
                           var22 = 321;
                           if(var1 == 1 && var2 >= var19 - 75 && var2 <= var19 + 75 && var3 >= var22 - 20 && var3 <= 20 + var22) {
                              class118.method2271();
                              return;
                           }

                           var19 = 80 + 180 + class41.loginWindowX;
                           if(var1 == 1 && var2 >= var19 - 75 && var2 <= 75 + var19 && var3 >= var22 - 20 && var3 <= var22 + 20) {
                              class41.loginMessage1 = "";
                              class41.loginMessage2 = "Enter your username/email & password.";
                              class41.loginMessage3 = "";
                              class41.loginIndex = 2;
                              class41.loginIndex2 = 0;
                              class41.field844 = "";
                           }

                           while(class205.method3821()) {
                              var21 = false;

                              for(var23 = 0; var23 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var23) {
                                 if(XClanMember.field273 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var23)) {
                                    var21 = true;
                                    break;
                                 }
                              }

                              if(class44.field893 == 13) {
                                 class41.loginMessage1 = "";
                                 class41.loginMessage2 = "Enter your username/email & password.";
                                 class41.loginMessage3 = "";
                                 class41.loginIndex = 2;
                                 class41.loginIndex2 = 0;
                                 class41.field844 = "";
                              } else {
                                 if(class44.field893 == 85 && class41.username.length() > 0) {
                                    class41.username = class41.username.substring(0, class41.username.length() - 1);
                                 }

                                 if(class44.field893 == 84) {
                                    class118.method2271();
                                    return;
                                 }

                                 if(var21 && class41.username.length() < 320) {
                                    class41.username = class41.username + XClanMember.field273;
                                 }
                              }
                           }
                        } else if(class41.loginIndex == 6) {
                           while(true) {
                              do {
                                 if(!class205.method3821()) {
                                    var20 = 321;
                                    if(var1 == 1 && var3 >= var20 - 20 && var3 <= var20 + 20) {
                                       class41.loginMessage1 = "";
                                       class41.loginMessage2 = "Enter your username/email & password.";
                                       class41.loginMessage3 = "";
                                       class41.loginIndex = 2;
                                       class41.loginIndex2 = 0;
                                       class41.field844 = "";
                                    }

                                    return;
                                 }
                              } while(class44.field893 != 84 && class44.field893 != 13);

                              class41.loginMessage1 = "";
                              class41.loginMessage2 = "Enter your username/email & password.";
                              class41.loginMessage3 = "";
                              class41.loginIndex = 2;
                              class41.loginIndex2 = 0;
                              class41.field844 = "";
                           }
                        }
                     }
                  } else {
                     while(class205.method3821()) {
                        if(class44.field893 == 84) {
                           class41.loginMessage1 = "";
                           class41.loginMessage2 = "Enter your username/email & password.";
                           class41.loginMessage3 = "";
                           class41.loginIndex = 2;
                           class41.loginIndex2 = 0;
                        } else if(class44.field893 == 13) {
                           class41.loginIndex = 0;
                        }
                     }

                     var19 = class41.loginWindowX + 180 - 80;
                     var22 = 321;
                     if(var1 == 1 && var2 >= var19 - 75 && var2 <= 75 + var19 && var3 >= var22 - 20 && var3 <= var22 + 20) {
                        class41.loginMessage1 = "";
                        class41.loginMessage2 = "Enter your username/email & password.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 2;
                        class41.loginIndex2 = 0;
                     }

                     var19 = 80 + class41.loginWindowX + 180;
                     if(var1 == 1 && var2 >= var19 - 75 && var2 <= var19 + 75 && var3 >= var22 - 20 && var3 <= 20 + var22) {
                        class41.loginIndex = 0;
                     }
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "14"
   )
   static final void method764() {
      int var2;
      int var3;
      Item var30;
      int var35;
      int var36;
      if(Client.packetOpcode == 82) {
         var35 = Client.field323.method2963();
         var36 = Client.field323.method3092();
         var2 = (var36 >> 4 & 7) + class18.field199;
         var3 = Friend.field153 + (var36 & 7);
         if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
            Deque var29 = Client.groundItemDeque[class48.plane][var2][var3];
            if(var29 != null) {
               for(var30 = (Item)var29.method2403(); var30 != null; var30 = (Item)var29.method2398()) {
                  if(var30.id == (var35 & 32767)) {
                     var30.unlink();
                     break;
                  }
               }

               if(var29.method2403() == null) {
                  Client.groundItemDeque[class48.plane][var2][var3] = null;
               }

               class11.groundItemSpawned(var2, var3);
            }
         }

      } else {
         int var4;
         int var37;
         if(Client.packetOpcode == 115) {
            var35 = Client.field323.readUnsignedByte();
            var36 = (var35 >> 4 & 7) + class18.field199;
            var2 = (var35 & 7) + Friend.field153;
            var3 = Client.field323.readUnsignedShort();
            var4 = Client.field323.readUnsignedShort();
            var37 = Client.field323.readUnsignedShort();
            if(var36 >= 0 && var2 >= 0 && var36 < 104 && var2 < 104) {
               Deque var42 = Client.groundItemDeque[class48.plane][var36][var2];
               if(null != var42) {
                  for(Item var32 = (Item)var42.method2403(); null != var32; var32 = (Item)var42.method2398()) {
                     if(var32.id == (var3 & 32767) && var32.quantity == var4) {
                        var32.quantity = var37;
                        break;
                     }
                  }

                  class11.groundItemSpawned(var36, var2);
               }
            }

         } else {
            int var38;
            if(Client.packetOpcode == 141) {
               var35 = Client.field323.method3092();
               var36 = (var35 >> 4 & 7) + class18.field199;
               var2 = Friend.field153 + (var35 & 7);
               var3 = Client.field323.method3092();
               var4 = var3 >> 2;
               var37 = var3 & 3;
               var38 = Client.field540[var4];
               if(var36 >= 0 && var2 >= 0 && var36 < 104 && var2 < 104) {
                  class3.method40(class48.plane, var36, var2, var38, -1, var4, var37, 0, -1);
               }

            } else if(Client.packetOpcode == 160) {
               var35 = Client.field323.readUnsignedByte();
               var36 = class18.field199 + (var35 >> 4 & 7);
               var2 = Friend.field153 + (var35 & 7);
               var3 = Client.field323.readUnsignedShort();
               var4 = Client.field323.readUnsignedByte();
               var37 = Client.field323.readUnsignedShort();
               if(var36 >= 0 && var2 >= 0 && var36 < 104 && var2 < 104) {
                  var36 = var36 * 128 + 64;
                  var2 = 128 * var2 + 64;
                  class33 var31 = new class33(var3, class48.plane, var36, var2, Renderable.method1883(var36, var2, class48.plane) - var4, var37, Client.gameCycle);
                  Client.field411.method2380(var31);
               }

            } else if(Client.packetOpcode == 165) {
               var35 = Client.field323.method2963();
               var36 = Client.field323.method2962();
               var2 = Client.field323.method3092();
               var3 = (var2 >> 4 & 7) + class18.field199;
               var4 = (var2 & 7) + Friend.field153;
               if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
                  var30 = new Item();
                  var30.id = var36;
                  var30.quantity = var35;
                  if(Client.groundItemDeque[class48.plane][var3][var4] == null) {
                     Client.groundItemDeque[class48.plane][var3][var4] = new Deque();
                  }

                  Client.groundItemDeque[class48.plane][var3][var4].method2380(var30);
                  class11.groundItemSpawned(var3, var4);
               }

            } else {
               int var7;
               int var9;
               int var10;
               int var11;
               int var12;
               int var33;
               if(Client.packetOpcode == 77) {
                  var35 = Client.field323.readUnsignedByte();
                  var36 = class18.field199 + (var35 >> 4 & 7);
                  var2 = Friend.field153 + (var35 & 7);
                  var3 = var36 + Client.field323.readByte();
                  var4 = var2 + Client.field323.readByte();
                  var37 = Client.field323.readShort();
                  var38 = Client.field323.readUnsignedShort();
                  var7 = Client.field323.readUnsignedByte() * 4;
                  var33 = Client.field323.readUnsignedByte() * 4;
                  var9 = Client.field323.readUnsignedShort();
                  var10 = Client.field323.readUnsignedShort();
                  var11 = Client.field323.readUnsignedByte();
                  var12 = Client.field323.readUnsignedByte();
                  if(var36 >= 0 && var2 >= 0 && var36 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var38 != '\uffff') {
                     var36 = var36 * 128 + 64;
                     var2 = var2 * 128 + 64;
                     var3 = var3 * 128 + 64;
                     var4 = 128 * var4 + 64;
                     Projectile var34 = new Projectile(var38, class48.plane, var36, var2, Renderable.method1883(var36, var2, class48.plane) - var7, Client.gameCycle + var9, Client.gameCycle + var10, var11, var12, var37, var33);
                     var34.method809(var3, var4, Renderable.method1883(var3, var4, class48.plane) - var33, var9 + Client.gameCycle);
                     Client.projectiles.method2380(var34);
                  }

               } else if(Client.packetOpcode == 136) {
                  var35 = Client.field323.method2953();
                  var36 = var35 >> 2;
                  var2 = var35 & 3;
                  var3 = Client.field540[var36];
                  var4 = Client.field323.method3037();
                  var37 = Client.field323.method2953();
                  var38 = (var37 >> 4 & 7) + class18.field199;
                  var7 = Friend.field153 + (var37 & 7);
                  if(var38 >= 0 && var7 >= 0 && var38 < 104 && var7 < 104) {
                     class3.method40(class48.plane, var38, var7, var3, var4, var36, var2, 0, -1);
                  }

               } else if(Client.packetOpcode == 234) {
                  var35 = Client.field323.method3092();
                  var36 = var35 >> 2;
                  var2 = var35 & 3;
                  var3 = Client.field540[var36];
                  var4 = Client.field323.method2963();
                  var37 = Client.field323.method2954();
                  var38 = (var37 >> 4 & 7) + class18.field199;
                  var7 = Friend.field153 + (var37 & 7);
                  if(var38 >= 0 && var7 >= 0 && var38 < 103 && var7 < 103) {
                     if(var3 == 0) {
                        WallObject var8 = class65.region.method1729(class48.plane, var38, var7);
                        if(null != var8) {
                           var9 = var8.hash >> 14 & 32767;
                           if(var36 == 2) {
                              var8.renderable1 = new class49(var9, 2, 4 + var2, class48.plane, var38, var7, var4, false, var8.renderable1);
                              var8.renderable2 = new class49(var9, 2, var2 + 1 & 3, class48.plane, var38, var7, var4, false, var8.renderable2);
                           } else {
                              var8.renderable1 = new class49(var9, var36, var2, class48.plane, var38, var7, var4, false, var8.renderable1);
                           }
                        }
                     }

                     if(var3 == 1) {
                        DecorativeObject var39 = class65.region.method1730(class48.plane, var38, var7);
                        if(null != var39) {
                           var9 = var39.hash >> 14 & 32767;
                           if(var36 != 4 && var36 != 5) {
                              if(var36 == 6) {
                                 var39.renderable1 = new class49(var9, 4, var2 + 4, class48.plane, var38, var7, var4, false, var39.renderable1);
                              } else if(var36 == 7) {
                                 var39.renderable1 = new class49(var9, 4, (var2 + 2 & 3) + 4, class48.plane, var38, var7, var4, false, var39.renderable1);
                              } else if(var36 == 8) {
                                 var39.renderable1 = new class49(var9, 4, 4 + var2, class48.plane, var38, var7, var4, false, var39.renderable1);
                                 var39.renderable2 = new class49(var9, 4, 4 + (2 + var2 & 3), class48.plane, var38, var7, var4, false, var39.renderable2);
                              }
                           } else {
                              var39.renderable1 = new class49(var9, 4, var2, class48.plane, var38, var7, var4, false, var39.renderable1);
                           }
                        }
                     }

                     if(var3 == 2) {
                        GameObject var40 = class65.region.method1731(class48.plane, var38, var7);
                        if(var36 == 11) {
                           var36 = 10;
                        }

                        if(var40 != null) {
                           var40.renderable = new class49(var40.hash >> 14 & 32767, var36, var2, class48.plane, var38, var7, var4, false, var40.renderable);
                        }
                     }

                     if(var3 == 3) {
                        GroundObject var41 = class65.region.method1732(class48.plane, var38, var7);
                        if(var41 != null) {
                           var41.renderable = new class49(var41.hash >> 14 & 32767, 22, var2, class48.plane, var38, var7, var4, false, var41.renderable);
                        }
                     }
                  }

               } else {
                  if(Client.packetOpcode == 194) {
                     byte var0 = Client.field323.method2958();
                     byte var1 = Client.field323.method2956();
                     var2 = Client.field323.readUnsignedShort();
                     var3 = Client.field323.readUnsignedShort();
                     var4 = Client.field323.method2963();
                     byte var5 = Client.field323.method2956();
                     byte var6 = Client.field323.method2957();
                     var7 = Client.field323.method2953();
                     var33 = var7 >> 2;
                     var9 = var7 & 3;
                     var10 = Client.field540[var33];
                     var11 = Client.field323.method3037();
                     var12 = Client.field323.method2954();
                     int var13 = (var12 >> 4 & 7) + class18.field199;
                     int var14 = (var12 & 7) + Friend.field153;
                     Player var15;
                     if(Client.localInteractingIndex == var3) {
                        var15 = VertexNormal.localPlayer;
                     } else {
                        var15 = Client.cachedPlayers[var3];
                     }

                     if(null != var15) {
                        ObjectComposition var16 = class156.getObjectDefinition(var2);
                        int var17;
                        int var18;
                        if(var9 != 1 && var9 != 3) {
                           var17 = var16.sizeX;
                           var18 = var16.sizeY;
                        } else {
                           var17 = var16.sizeY;
                           var18 = var16.sizeX;
                        }

                        int var19 = (var17 >> 1) + var13;
                        int var20 = var13 + (1 + var17 >> 1);
                        int var21 = var14 + (var18 >> 1);
                        int var22 = (var18 + 1 >> 1) + var14;
                        int[][] var23 = class11.tileHeights[class48.plane];
                        int var24 = var23[var19][var21] + var23[var20][var21] + var23[var19][var22] + var23[var20][var22] >> 2;
                        int var25 = (var17 << 6) + (var13 << 7);
                        int var26 = (var14 << 7) + (var18 << 6);
                        Model var27 = var16.method3604(var33, var9, var23, var25, var24, var26);
                        if(var27 != null) {
                           class3.method40(class48.plane, var13, var14, var10, -1, 0, 0, 1 + var4, 1 + var11);
                           var15.totalLevel = var4 + Client.gameCycle;
                           var15.field251 = var11 + Client.gameCycle;
                           var15.model = var27;
                           var15.field252 = var13 * 128 + 64 * var17;
                           var15.field258 = var18 * 64 + var14 * 128;
                           var15.field255 = var24;
                           byte var28;
                           if(var6 > var5) {
                              var28 = var6;
                              var6 = var5;
                              var5 = var28;
                           }

                           if(var0 > var1) {
                              var28 = var0;
                              var0 = var1;
                              var1 = var28;
                           }

                           var15.field264 = var6 + var13;
                           var15.field250 = var5 + var13;
                           var15.field254 = var0 + var14;
                           var15.field259 = var1 + var14;
                        }
                     }
                  }

                  if(Client.packetOpcode == 197) {
                     var35 = Client.field323.readUnsignedByte();
                     var36 = class18.field199 + (var35 >> 4 & 7);
                     var2 = Friend.field153 + (var35 & 7);
                     var3 = Client.field323.readUnsignedShort();
                     var4 = Client.field323.readUnsignedByte();
                     var37 = var4 >> 4 & 15;
                     var38 = var4 & 7;
                     var7 = Client.field323.readUnsignedByte();
                     if(var36 >= 0 && var2 >= 0 && var36 < 104 && var2 < 104) {
                        var33 = var37 + 1;
                        if(VertexNormal.localPlayer.pathX[0] >= var36 - var33 && VertexNormal.localPlayer.pathX[0] <= var33 + var36 && VertexNormal.localPlayer.pathY[0] >= var2 - var33 && VertexNormal.localPlayer.pathY[0] <= var33 + var2 && Client.field512 != 0 && var38 > 0 && Client.field461 < 50) {
                           Client.field473[Client.field461] = var3;
                           Client.field522[Client.field461] = var38;
                           Client.field533[Client.field461] = var7;
                           Client.field400[Client.field461] = null;
                           Client.field524[Client.field461] = var37 + (var2 << 8) + (var36 << 16);
                           ++Client.field461;
                        }
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(CI)B",
      garbageValue = "-295338620"
   )
   public static byte method765(char var0) {
      byte var1;
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         var1 = (byte)var0;
      } else if(var0 == 8364) {
         var1 = -128;
      } else if(var0 == 8218) {
         var1 = -126;
      } else if(var0 == 402) {
         var1 = -125;
      } else if(var0 == 8222) {
         var1 = -124;
      } else if(var0 == 8230) {
         var1 = -123;
      } else if(var0 == 8224) {
         var1 = -122;
      } else if(var0 == 8225) {
         var1 = -121;
      } else if(var0 == 710) {
         var1 = -120;
      } else if(var0 == 8240) {
         var1 = -119;
      } else if(var0 == 352) {
         var1 = -118;
      } else if(var0 == 8249) {
         var1 = -117;
      } else if(var0 == 338) {
         var1 = -116;
      } else if(var0 == 381) {
         var1 = -114;
      } else if(var0 == 8216) {
         var1 = -111;
      } else if(var0 == 8217) {
         var1 = -110;
      } else if(var0 == 8220) {
         var1 = -109;
      } else if(var0 == 8221) {
         var1 = -108;
      } else if(var0 == 8226) {
         var1 = -107;
      } else if(var0 == 8211) {
         var1 = -106;
      } else if(var0 == 8212) {
         var1 = -105;
      } else if(var0 == 732) {
         var1 = -104;
      } else if(var0 == 8482) {
         var1 = -103;
      } else if(var0 == 353) {
         var1 = -102;
      } else if(var0 == 8250) {
         var1 = -101;
      } else if(var0 == 339) {
         var1 = -100;
      } else if(var0 == 382) {
         var1 = -98;
      } else if(var0 == 376) {
         var1 = -97;
      } else {
         var1 = 63;
      }

      return var1;
   }
}
