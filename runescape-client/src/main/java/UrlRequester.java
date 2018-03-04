import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Queue;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
@Implements("UrlRequester")
public class UrlRequester implements Runnable {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1928777713
   )
   @Export("scriptStringStackSize")
   static int scriptStringStackSize;
   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "[Llv;"
   )
   @Export("mapscene")
   static IndexedSprite[] mapscene;
   @ObfuscatedName("kq")
   @ObfuscatedSignature(
      signature = "Lcc;"
   )
   @Export("topContextMenuRow")
   static ContextMenuRow topContextMenuRow;
   @ObfuscatedName("d")
   @Export("thread")
   final Thread thread;
   @ObfuscatedName("z")
   @Export("isClosed")
   volatile boolean isClosed;
   @ObfuscatedName("n")
   @Export("requests")
   Queue requests;

   public UrlRequester() {
      this.requests = new LinkedList();
      this.thread = new Thread(this);
      this.thread.setPriority(1);
      this.thread.start();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Lez;",
      garbageValue = "-2068504149"
   )
   @Export("request")
   public UrlRequest request(URL var1) {
      UrlRequest var2 = new UrlRequest(var1);
      synchronized(this) {
         this.requests.add(var2);
         this.notify();
         return var2;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "101"
   )
   @Export("close")
   public void close() {
      this.isClosed = true;

      try {
         synchronized(this) {
            this.notify();
         }

         this.thread.join();
      } catch (InterruptedException var4) {
         ;
      }

   }

   public void run() {
      while(!this.isClosed) {
         try {
            UrlRequest var1;
            synchronized(this) {
               var1 = (UrlRequest)this.requests.poll();
               if(var1 == null) {
                  try {
                     this.wait();
                  } catch (InterruptedException var13) {
                     ;
                  }
                  continue;
               }
            }

            DataInputStream var2 = null;
            URLConnection var3 = null;

            try {
               var3 = var1.url.openConnection();
               var3.setConnectTimeout(5000);
               var3.setReadTimeout(5000);
               var3.setUseCaches(false);
               var3.setRequestProperty("Connection", "close");
               int var7 = var3.getContentLength();
               if(var7 >= 0) {
                  byte[] var5 = new byte[var7];
                  var2 = new DataInputStream(var3.getInputStream());
                  var2.readFully(var5);
                  var1.response0 = var5;
               }

               var1.isDone0 = true;
            } catch (IOException var14) {
               var1.isDone0 = true;
            } finally {
               if(var2 != null) {
                  var2.close();
               }

               if(var3 != null && var3 instanceof HttpURLConnection) {
                  ((HttpURLConnection)var3).disconnect();
               }

            }
         } catch (Exception var17) {
            ItemLayer.method2658((String)null, var17);
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1149371675"
   )
   static int method3167(int var0, int var1) {
      Overlay var2 = class57.getOverlayDefinition(var0);
      if(var2 == null) {
         return var1;
      } else if(var2.otherRgbColor >= 0) {
         return var2.otherRgbColor | -16777216;
      } else {
         int var3;
         if(var2.texture >= 0) {
            var3 = class1.method1(Graphics3D.textureLoader.getAverageTextureRGB(var2.texture), 96);
            return Graphics3D.colorPalette[var3] | -16777216;
         } else if(var2.color == 16711935) {
            return var1;
         } else {
            var3 = class33.method366(var2.hue, var2.saturation, var2.lightness);
            int var4 = class1.method1(var3, 96);
            return Graphics3D.colorPalette[var4] | -16777216;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "34"
   )
   public static int method3174(int var0, int var1) {
      int var2;
      for(var2 = 1; var1 > 1; var1 >>= 1) {
         if((var1 & 1) != 0) {
            var2 = var0 * var2;
         }

         var0 *= var0;
      }

      if(var1 == 1) {
         return var0 * var2;
      } else {
         return var2;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1927326047"
   )
   static final void method3177(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class62.field740[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5 - 1][var4];
               }

               if(var5 == var0 + var2 && var5 < 103) {
                  class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5 + 1][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5][var4 - 1];
               }

               if(var4 == var3 + var1 && var4 < 103) {
                  class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lbt;I)V",
      garbageValue = "-1073514697"
   )
   static void method3168(GameEngine var0) {
      int var4;
      if(class90.worldSelectShown) {
         if(MouseInput.mouseLastButton == 1 || !Enum.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) {
            int var1 = class90.field1336 + 280;
            if(MouseInput.mouseLastPressedX >= var1 && MouseInput.mouseLastPressedX <= var1 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
               GroundObject.method2738(0, 0);
            } else if(MouseInput.mouseLastPressedX >= var1 + 15 && MouseInput.mouseLastPressedX <= var1 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
               GroundObject.method2738(0, 1);
            } else {
               int var2 = class90.field1336 + 390;
               if(MouseInput.mouseLastPressedX >= var2 && MouseInput.mouseLastPressedX <= var2 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                  GroundObject.method2738(1, 0);
               } else if(MouseInput.mouseLastPressedX >= var2 + 15 && MouseInput.mouseLastPressedX <= var2 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                  GroundObject.method2738(1, 1);
               } else {
                  int var16 = class90.field1336 + 500;
                  if(MouseInput.mouseLastPressedX >= var16 && MouseInput.mouseLastPressedX <= var16 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                     GroundObject.method2738(2, 0);
                  } else if(MouseInput.mouseLastPressedX >= var16 + 15 && MouseInput.mouseLastPressedX <= var16 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                     GroundObject.method2738(2, 1);
                  } else {
                     var4 = class90.field1336 + 610;
                     if(MouseInput.mouseLastPressedX >= var4 && MouseInput.mouseLastPressedX <= var4 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                        GroundObject.method2738(3, 0);
                     } else if(MouseInput.mouseLastPressedX >= var4 + 15 && MouseInput.mouseLastPressedX <= var4 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                        GroundObject.method2738(3, 1);
                     } else if(MouseInput.mouseLastPressedX >= class90.field1336 + 708 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedX <= class90.field1336 + 708 + 50 && MouseInput.mouseLastPressedY <= 20) {
                        class90.worldSelectShown = false;
                        class90.field1338.method6003(class90.field1336, 0);
                        class90.field1340.method6003(class90.field1336 + 382, 0);
                        class90.logoSprite.method5899(class90.field1336 + 382 - class90.logoSprite.originalWidth / 2, 18);
                     } else if(class90.field1368 != -1) {
                        World var5 = World.worldList[class90.field1368];
                        TotalQuantityComparator.method99(var5);
                        class90.worldSelectShown = false;
                        class90.field1338.method6003(class90.field1336, 0);
                        class90.field1340.method6003(class90.field1336 + 382, 0);
                        class90.logoSprite.method5899(class90.field1336 + 382 - class90.logoSprite.originalWidth / 2, 18);
                     }
                  }
               }
            }
         }

      } else {
         if((MouseInput.mouseLastButton == 1 || !Enum.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) && MouseInput.mouseLastPressedX >= class90.field1336 + 765 - 50 && MouseInput.mouseLastPressedY >= 453) {
            class55.preferences.muted = !class55.preferences.muted;
            MessageNode.method1130();
            if(!class55.preferences.muted) {
               class185.method3498(class154.indexTrack1, "scape main", "", 255, false);
            } else {
               class197.method3836();
            }
         }

         if(Client.gameState != 5) {
            if(-1L == class90.field1369) {
               class90.field1369 = PendingSpawn.currentTimeMs() + 1000L;
            }

            long var12 = PendingSpawn.currentTimeMs();
            boolean var3;
            if(Client.field1117 != null && Client.field1118 < Client.field1117.size()) {
               while(true) {
                  if(Client.field1118 >= Client.field1117.size()) {
                     var3 = true;
                     break;
                  }

                  class64 var15 = (class64)Client.field1117.get(Client.field1118);
                  if(!var15.method1063()) {
                     var3 = false;
                     break;
                  }

                  ++Client.field1118;
               }
            } else {
               var3 = true;
            }

            if(var3 && -1L == class90.field1370) {
               class90.field1370 = var12;
               if(class90.field1370 > class90.field1369) {
                  class90.field1369 = class90.field1370;
               }
            }

            ++class90.field1359;
            if(Client.gameState == 10 || Client.gameState == 11) {
               if(Client.languageId == 0) {
                  if(MouseInput.mouseLastButton == 1 || !Enum.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) {
                     var4 = class90.field1336 + 5;
                     short var14 = 463;
                     byte var6 = 100;
                     byte var7 = 35;
                     if(MouseInput.mouseLastPressedX >= var4 && MouseInput.mouseLastPressedX <= var4 + var6 && MouseInput.mouseLastPressedY >= var14 && MouseInput.mouseLastPressedY <= var7 + var14) {
                        class37.method503();
                        return;
                     }
                  }

                  if(World.listFetcher != null) {
                     class37.method503();
                  }
               }

               var4 = MouseInput.mouseLastButton;
               int var24 = MouseInput.mouseLastPressedX;
               int var17 = MouseInput.mouseLastPressedY;
               if(var4 == 0) {
                  var24 = MouseInput.mouseLastX;
                  var17 = MouseInput.mouseLastY;
               }

               if(!Enum.middleMouseMovesCamera && var4 == 4) {
                  var4 = 1;
               }

               int var8;
               short var9;
               if(class90.loginIndex == 0) {
                  boolean var18 = false;

                  while(class25.method190()) {
                     if(AbstractSoundSystem.field1569 == 84) {
                        var18 = true;
                     }
                  }

                  var8 = NPC.field1290 - 80;
                  var9 = 291;
                  if(var4 == 1 && var24 >= var8 - 75 && var24 <= var8 + 75 && var17 >= var9 - 20 && var17 <= var9 + 20) {
                     TotalQuantityComparator.method98(class281.method5109("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var8 = NPC.field1290 + 80;
                  if(var4 == 1 && var24 >= var8 - 75 && var24 <= var8 + 75 && var17 >= var9 - 20 && var17 <= var9 + 20 || var18) {
                     if((Client.flags & 33554432) != 0) {
                        class90.Login_response0 = "";
                        class90.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class90.loginMessage2 = "Your normal account will not be affected.";
                        class90.loginMessage3 = "";
                        class90.loginIndex = 1;
                        FontName.method5595();
                     } else if((Client.flags & 4) != 0) {
                        if((Client.flags & 1024) != 0) {
                           class90.loginMessage1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class90.loginMessage2 = "Players can attack each other almost everywhere";
                           class90.loginMessage3 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class90.loginMessage1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class90.loginMessage2 = "Players can attack each other";
                           class90.loginMessage3 = "almost everywhere.";
                        }

                        class90.Login_response0 = "Warning!";
                        class90.loginIndex = 1;
                        FontName.method5595();
                     } else if((Client.flags & 1024) != 0) {
                        class90.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class90.loginMessage2 = "The Protect Item prayer will";
                        class90.loginMessage3 = "not work on this world.";
                        class90.Login_response0 = "Warning!";
                        class90.loginIndex = 1;
                        FontName.method5595();
                     } else {
                        class20.method153(false);
                     }
                  }
               } else {
                  int var19;
                  short var21;
                  if(class90.loginIndex != 1) {
                     short var20;
                     if(class90.loginIndex == 2) {
                        var20 = 201;
                        var19 = var20 + 52;
                        if(var4 == 1 && var17 >= var19 - 12 && var17 < var19 + 2) {
                           class90.field1364 = 0;
                        }

                        var19 += 15;
                        if(var4 == 1 && var17 >= var19 - 12 && var17 < var19 + 2) {
                           class90.field1364 = 1;
                        }

                        var19 += 15;
                        var20 = 361;
                        if(var4 == 1 && var17 >= var20 - 15 && var17 < var20) {
                           KeyFocusListener.method770("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class90.loginIndex = 5;
                           return;
                        }

                        var8 = NPC.field1290 - 80;
                        var9 = 321;
                        if(var4 == 1 && var24 >= var8 - 75 && var24 <= var8 + 75 && var17 >= var9 - 20 && var17 <= var9 + 20) {
                           class90.username = class90.username.trim();
                           if(class90.username.length() == 0) {
                              KeyFocusListener.method770("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(class90.password.length() == 0) {
                              KeyFocusListener.method770("", "Please enter your password.", "");
                              return;
                           }

                           KeyFocusListener.method770("", "Connecting to server...", "");
                           BaseVarType.method14(false);
                           Enum.setGameState(20);
                           return;
                        }

                        var8 = class90.loginWindowX + 180 + 80;
                        if(var4 == 1 && var24 >= var8 - 75 && var24 <= var8 + 75 && var17 >= var9 - 20 && var17 <= var9 + 20) {
                           class90.loginIndex = 0;
                           class90.username = "";
                           class90.password = "";
                           class2.field14 = 0;
                           Sequence.field3752 = "";
                           class90.field1363 = true;
                        }

                        var8 = NPC.field1290 + -117;
                        var9 = 277;
                        class90.field1335 = var24 >= var8 && var24 < var8 + class149.field2111 && var17 >= var9 && var17 < var9 + class37.field512;
                        if(var4 == 1 && class90.field1335) {
                           class90.Login_isUsernameRemembered = !class90.Login_isUsernameRemembered;
                           if(!class90.Login_isUsernameRemembered && class55.preferences.rememberedUsername != null) {
                              class55.preferences.rememberedUsername = null;
                              MessageNode.method1130();
                           }
                        }

                        var8 = NPC.field1290 + 24;
                        var9 = 277;
                        class90.field1362 = var24 >= var8 && var24 < var8 + class149.field2111 && var17 >= var9 && var17 < var9 + class37.field512;
                        if(var4 == 1 && class90.field1362) {
                           class55.preferences.hideUsername = !class55.preferences.hideUsername;
                           if(!class55.preferences.hideUsername) {
                              class90.username = "";
                              class55.preferences.rememberedUsername = null;
                              FontName.method5595();
                           }

                           MessageNode.method1130();
                        }

                        while(true) {
                           while(class25.method190()) {
                              boolean var10 = false;

                              for(int var11 = 0; var11 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var11) {
                                 if(class22.field351 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var11)) {
                                    var10 = true;
                                    break;
                                 }
                              }

                              if(AbstractSoundSystem.field1569 == 13) {
                                 class90.loginIndex = 0;
                                 class90.username = "";
                                 class90.password = "";
                                 class2.field14 = 0;
                                 Sequence.field3752 = "";
                                 class90.field1363 = true;
                              } else if(class90.field1364 == 0) {
                                 if(AbstractSoundSystem.field1569 == 85 && class90.username.length() > 0) {
                                    class90.username = class90.username.substring(0, class90.username.length() - 1);
                                 }

                                 if(AbstractSoundSystem.field1569 == 84 || AbstractSoundSystem.field1569 == 80) {
                                    class90.field1364 = 1;
                                 }

                                 if(var10 && class90.username.length() < 320) {
                                    class90.username = class90.username + class22.field351;
                                 }
                              } else if(class90.field1364 == 1) {
                                 if(AbstractSoundSystem.field1569 == 85 && class90.password.length() > 0) {
                                    class90.password = class90.password.substring(0, class90.password.length() - 1);
                                 }

                                 if(AbstractSoundSystem.field1569 == 84 || AbstractSoundSystem.field1569 == 80) {
                                    class90.field1364 = 0;
                                 }

                                 if(AbstractSoundSystem.field1569 == 84) {
                                    class90.username = class90.username.trim();
                                    if(class90.username.length() == 0) {
                                       KeyFocusListener.method770("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(class90.password.length() == 0) {
                                       KeyFocusListener.method770("", "Please enter your password.", "");
                                       return;
                                    }

                                    KeyFocusListener.method770("", "Connecting to server...", "");
                                    BaseVarType.method14(false);
                                    Enum.setGameState(20);
                                    return;
                                 }

                                 if(var10 && class90.password.length() < 20) {
                                    class90.password = class90.password + class22.field351;
                                 }
                              }
                           }

                           return;
                        }
                     } else if(class90.loginIndex == 3) {
                        var19 = class90.loginWindowX + 180;
                        var21 = 276;
                        if(var4 == 1 && var24 >= var19 - 75 && var24 <= var19 + 75 && var17 >= var21 - 20 && var17 <= var21 + 20) {
                           class20.method153(false);
                        }

                        var19 = class90.loginWindowX + 180;
                        var21 = 326;
                        if(var4 == 1 && var24 >= var19 - 75 && var24 <= var19 + 75 && var17 >= var21 - 20 && var17 <= var21 + 20) {
                           KeyFocusListener.method770("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class90.loginIndex = 5;
                           return;
                        }
                     } else {
                        boolean var22;
                        int var23;
                        if(class90.loginIndex == 4) {
                           var19 = class90.loginWindowX + 180 - 80;
                           var21 = 321;
                           if(var4 == 1 && var24 >= var19 - 75 && var24 <= var19 + 75 && var17 >= var21 - 20 && var17 <= var21 + 20) {
                              Sequence.field3752.trim();
                              if(Sequence.field3752.length() != 6) {
                                 KeyFocusListener.method770("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              class2.field14 = Integer.parseInt(Sequence.field3752);
                              Sequence.field3752 = "";
                              BaseVarType.method14(true);
                              KeyFocusListener.method770("", "Connecting to server...", "");
                              Enum.setGameState(20);
                              return;
                           }

                           if(var4 == 1 && var24 >= class90.loginWindowX + 180 - 9 && var24 <= class90.loginWindowX + 180 + 130 && var17 >= 263 && var17 <= 296) {
                              class90.field1363 = !class90.field1363;
                           }

                           if(var4 == 1 && var24 >= class90.loginWindowX + 180 - 34 && var24 <= class90.loginWindowX + 34 + 180 && var17 >= 351 && var17 <= 363) {
                              TotalQuantityComparator.method98(class281.method5109("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                           }

                           var19 = class90.loginWindowX + 180 + 80;
                           if(var4 == 1 && var24 >= var19 - 75 && var24 <= var19 + 75 && var17 >= var21 - 20 && var17 <= var21 + 20) {
                              class90.loginIndex = 0;
                              class90.username = "";
                              class90.password = "";
                              class2.field14 = 0;
                              Sequence.field3752 = "";
                           }

                           while(class25.method190()) {
                              var22 = false;

                              for(var23 = 0; var23 < "1234567890".length(); ++var23) {
                                 if(class22.field351 == "1234567890".charAt(var23)) {
                                    var22 = true;
                                    break;
                                 }
                              }

                              if(AbstractSoundSystem.field1569 == 13) {
                                 class90.loginIndex = 0;
                                 class90.username = "";
                                 class90.password = "";
                                 class2.field14 = 0;
                                 Sequence.field3752 = "";
                              } else {
                                 if(AbstractSoundSystem.field1569 == 85 && Sequence.field3752.length() > 0) {
                                    Sequence.field3752 = Sequence.field3752.substring(0, Sequence.field3752.length() - 1);
                                 }

                                 if(AbstractSoundSystem.field1569 == 84) {
                                    Sequence.field3752.trim();
                                    if(Sequence.field3752.length() != 6) {
                                       KeyFocusListener.method770("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    class2.field14 = Integer.parseInt(Sequence.field3752);
                                    Sequence.field3752 = "";
                                    BaseVarType.method14(true);
                                    KeyFocusListener.method770("", "Connecting to server...", "");
                                    Enum.setGameState(20);
                                    return;
                                 }

                                 if(var22 && Sequence.field3752.length() < 6) {
                                    Sequence.field3752 = Sequence.field3752 + class22.field351;
                                 }
                              }
                           }
                        } else if(class90.loginIndex == 5) {
                           var19 = class90.loginWindowX + 180 - 80;
                           var21 = 321;
                           if(var4 == 1 && var24 >= var19 - 75 && var24 <= var19 + 75 && var17 >= var21 - 20 && var17 <= var21 + 20) {
                              KitDefinition.method4991();
                              return;
                           }

                           var19 = class90.loginWindowX + 180 + 80;
                           if(var4 == 1 && var24 >= var19 - 75 && var24 <= var19 + 75 && var17 >= var21 - 20 && var17 <= var21 + 20) {
                              class20.method153(true);
                           }

                           while(class25.method190()) {
                              var22 = false;

                              for(var23 = 0; var23 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var23) {
                                 if(class22.field351 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var23)) {
                                    var22 = true;
                                    break;
                                 }
                              }

                              if(AbstractSoundSystem.field1569 == 13) {
                                 class20.method153(true);
                              } else {
                                 if(AbstractSoundSystem.field1569 == 85 && class90.username.length() > 0) {
                                    class90.username = class90.username.substring(0, class90.username.length() - 1);
                                 }

                                 if(AbstractSoundSystem.field1569 == 84) {
                                    KitDefinition.method4991();
                                    return;
                                 }

                                 if(var22 && class90.username.length() < 320) {
                                    class90.username = class90.username + class22.field351;
                                 }
                              }
                           }
                        } else if(class90.loginIndex == 6) {
                           while(true) {
                              do {
                                 if(!class25.method190()) {
                                    var20 = 321;
                                    if(var4 == 1 && var17 >= var20 - 20 && var17 <= var20 + 20) {
                                       class20.method153(true);
                                    }

                                    return;
                                 }
                              } while(AbstractSoundSystem.field1569 != 84 && AbstractSoundSystem.field1569 != 13);

                              class20.method153(true);
                           }
                        }
                     }
                  } else {
                     while(class25.method190()) {
                        if(AbstractSoundSystem.field1569 == 84) {
                           class20.method153(false);
                        } else if(AbstractSoundSystem.field1569 == 13) {
                           class90.loginIndex = 0;
                        }
                     }

                     var19 = NPC.field1290 - 80;
                     var21 = 321;
                     if(var4 == 1 && var24 >= var19 - 75 && var24 <= var19 + 75 && var17 >= var21 - 20 && var17 <= var21 + 20) {
                        class20.method153(false);
                     }

                     var19 = NPC.field1290 + 80;
                     if(var4 == 1 && var24 >= var19 - 75 && var24 <= var19 + 75 && var17 >= var21 - 20 && var17 <= var21 + 20) {
                        class90.loginIndex = 0;
                     }
                  }
               }

            }
         }
      }
   }
}
