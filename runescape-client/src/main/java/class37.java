import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public class class37 {
   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "2134239371"
   )
   static final void method808(int var0, int var1, int var2, int var3) {
      if(Client.field416 == 0 && !Client.field444) {
         class6.addMenuEntry("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      int var4 = -1;
      int var5 = -1;

      int var6;
      int var7;
      for(var6 = 0; var6 < Model.field1423; ++var6) {
         var7 = Model.field1420[var6];
         int var8 = var7 & 127;
         int var9 = var7 >> 7 & 127;
         int var10 = var7 >> 29 & 3;
         int var11 = var7 >> 14 & 32767;
         if(var7 != var5) {
            var5 = var7;
            if(var10 == 2 && Friend.region.method1924(CollisionData.plane, var8, var9, var7) >= 0) {
               ObjectComposition var12 = ChatMessages.getObjectDefinition(var11);
               if(var12.impostorIds != null) {
                  var12 = var12.getImpostor();
               }

               if(null == var12) {
                  continue;
               }

               if(Client.field416 == 1) {
                  class6.addMenuEntry("Use", Client.field443 + " " + "->" + " " + method813('\uffff') + var12.name, 1, var7, var8, var9);
               } else if(Client.field444) {
                  if((CombatInfoListHolder.field759 & 4) == 4) {
                     class6.addMenuEntry(Client.field353, Client.field448 + " " + "->" + " " + method813('\uffff') + var12.name, 2, var7, var8, var9);
                  }
               } else {
                  String[] var13 = var12.actions;
                  if(Client.field460) {
                     var13 = class145.method2800(var13);
                  }

                  if(null != var13) {
                     for(int var21 = 4; var21 >= 0; --var21) {
                        if(null != var13[var21]) {
                           short var15 = 0;
                           if(var21 == 0) {
                              var15 = 3;
                           }

                           if(var21 == 1) {
                              var15 = 4;
                           }

                           if(var21 == 2) {
                              var15 = 5;
                           }

                           if(var21 == 3) {
                              var15 = 6;
                           }

                           if(var21 == 4) {
                              var15 = 1001;
                           }

                           class6.addMenuEntry(var13[var21], method813('\uffff') + var12.name, var15, var7, var8, var9);
                        }
                     }
                  }

                  class6.addMenuEntry("Examine", method813('\uffff') + var12.name, 1002, var12.field2921 << 14, var8, var9);
               }
            }

            NPC var14;
            Player var19;
            int var20;
            int[] var27;
            int var29;
            if(var10 == 1) {
               NPC var23 = Client.cachedNPCs[var11];
               if(var23 == null) {
                  continue;
               }

               if(var23.composition.field3040 == 1 && (var23.x & 127) == 64 && (var23.y & 127) == 64) {
                  for(var20 = 0; var20 < Client.field328; ++var20) {
                     var14 = Client.cachedNPCs[Client.field285[var20]];
                     if(var14 != null && var14 != var23 && var14.composition.field3040 == 1 && var14.x == var23.x && var23.y == var14.y) {
                        Ignore.method205(var14.composition, Client.field285[var20], var8, var9);
                     }
                  }

                  var20 = class45.field916;
                  var27 = class45.field913;

                  for(var29 = 0; var29 < var20; ++var29) {
                     var19 = Client.cachedPlayers[var27[var29]];
                     if(null != var19 && var19.x == var23.x && var23.y == var19.y) {
                        FaceNormal.method1987(var19, var27[var29], var8, var9);
                     }
                  }
               }

               Ignore.method205(var23.composition, var11, var8, var9);
            }

            if(var10 == 0) {
               Player var24 = Client.cachedPlayers[var11];
               if(var24 == null) {
                  continue;
               }

               if((var24.x & 127) == 64 && (var24.y & 127) == 64) {
                  for(var20 = 0; var20 < Client.field328; ++var20) {
                     var14 = Client.cachedNPCs[Client.field285[var20]];
                     if(var14 != null && var14.composition.field3040 == 1 && var14.x == var24.x && var24.y == var14.y) {
                        Ignore.method205(var14.composition, Client.field285[var20], var8, var9);
                     }
                  }

                  var20 = class45.field916;
                  var27 = class45.field913;

                  for(var29 = 0; var29 < var20; ++var29) {
                     var19 = Client.cachedPlayers[var27[var29]];
                     if(null != var19 && var19 != var24 && var24.x == var19.x && var24.y == var19.y) {
                        FaceNormal.method1987(var19, var27[var29], var8, var9);
                     }
                  }
               }

               if(Client.field418 != var11) {
                  FaceNormal.method1987(var24, var11, var8, var9);
               } else {
                  var4 = var7;
               }
            }

            if(var10 == 3) {
               Deque var25 = Client.groundItemDeque[CollisionData.plane][var8][var9];
               if(null != var25) {
                  for(Item var26 = (Item)var25.method2493(); var26 != null; var26 = (Item)var25.method2490()) {
                     ItemComposition var28 = ChatLineBuffer.getItemDefinition(var26.id);
                     if(Client.field416 == 1) {
                        class6.addMenuEntry("Use", Client.field443 + " " + "->" + " " + method813(16748608) + var28.name, 16, var26.id, var8, var9);
                     } else if(Client.field444) {
                        if((CombatInfoListHolder.field759 & 1) == 1) {
                           class6.addMenuEntry(Client.field353, Client.field448 + " " + "->" + " " + method813(16748608) + var28.name, 17, var26.id, var8, var9);
                        }
                     } else {
                        String[] var18 = var28.groundActions;
                        if(Client.field460) {
                           var18 = class145.method2800(var18);
                        }

                        for(int var16 = 4; var16 >= 0; --var16) {
                           if(null != var18 && null != var18[var16]) {
                              byte var17 = 0;
                              if(var16 == 0) {
                                 var17 = 18;
                              }

                              if(var16 == 1) {
                                 var17 = 19;
                              }

                              if(var16 == 2) {
                                 var17 = 20;
                              }

                              if(var16 == 3) {
                                 var17 = 21;
                              }

                              if(var16 == 4) {
                                 var17 = 22;
                              }

                              class6.addMenuEntry(var18[var16], method813(16748608) + var28.name, var17, var26.id, var8, var9);
                           } else if(var16 == 2) {
                              class6.addMenuEntry("Take", method813(16748608) + var28.name, 20, var26.id, var8, var9);
                           }
                        }

                        class6.addMenuEntry("Examine", method813(16748608) + var28.name, 1004, var26.id, var8, var9);
                     }
                  }
               }
            }
         }
      }

      if(var4 != -1) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         Player var22 = Client.cachedPlayers[Client.field418];
         FaceNormal.method1987(var22, Client.field418, var6, var7);
      }

   }

   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-2008244356"
   )
   static final void method809(String var0, boolean var1) {
      if(null != var0) {
         if((Client.ignoreCount < 100 || Client.field411 == 1) && Client.ignoreCount < 400) {
            String var2 = class60.method1229(var0, class149.field2037);
            if(var2 != null) {
               int var3;
               String var5;
               String var6;
               for(var3 = 0; var3 < Client.ignoreCount; ++var3) {
                  Ignore var4 = Client.ignores[var3];
                  var5 = class60.method1229(var4.name, class149.field2037);
                  if(var5 != null && var5.equals(var2)) {
                     class88.sendGameMessage(31, "", var0 + " is already on your ignore list");
                     return;
                  }

                  if(null != var4.previousName) {
                     var6 = class60.method1229(var4.previousName, class149.field2037);
                     if(null != var6 && var6.equals(var2)) {
                        class88.sendGameMessage(31, "", var0 + " is already on your ignore list");
                        return;
                     }
                  }
               }

               for(var3 = 0; var3 < Client.friendCount; ++var3) {
                  Friend var7 = Client.friends[var3];
                  var5 = class60.method1229(var7.name, class149.field2037);
                  if(var5 != null && var5.equals(var2)) {
                     class88.sendGameMessage(31, "", "Please remove " + var0 + " from your friend list first");
                     return;
                  }

                  if(var7.previousName != null) {
                     var6 = class60.method1229(var7.previousName, class149.field2037);
                     if(var6 != null && var6.equals(var2)) {
                        class88.sendGameMessage(31, "", "Please remove " + var0 + " from your friend list first");
                        return;
                     }
                  }
               }

               if(class60.method1229(WidgetNode.localPlayer.name, class149.field2037).equals(var2)) {
                  class88.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
               } else {
                  Client.field332.method3144(111);
                  Client.field332.method2873(class165.method3233(var0));
                  Client.field332.method2915(var0);
               }
            }
         } else {
            class88.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1733558042"
   )
   static String method813(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "1886515251"
   )
   @Export("menuAction")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      Widget var8;
      int var9;
      int var17;
      if(var2 == 57 || var2 == 1007) {
         var8 = class33.method774(var1, var0);
         if(var8 != null) {
            var9 = var8.item;
            Widget var10 = class33.method774(var1, var0);
            if(null != var10) {
               if(var10.field2306 != null) {
                  class18 var11 = new class18();
                  var11.field188 = var10;
                  var11.field191 = var3;
                  var11.field195 = var5;
                  var11.field196 = var10.field2306;
                  class40.method828(var11);
               }

               boolean var16 = true;
               if(var10.contentType > 0) {
                  var16 = DecorativeObject.method2018(var10);
               }

               if(var16) {
                  int var13 = MessageNode.method220(var10);
                  var17 = var3 - 1;
                  boolean var12 = (var13 >> 1 + var17 & 1) != 0;
                  if(var12) {
                     if(var3 == 1) {
                        Client.field332.method3144(215);
                        Client.field332.method2874(var1);
                        Client.field332.method2872(var0);
                        Client.field332.method2872(var9);
                     }

                     if(var3 == 2) {
                        Client.field332.method3144(191);
                        Client.field332.method2874(var1);
                        Client.field332.method2872(var0);
                        Client.field332.method2872(var9);
                     }

                     if(var3 == 3) {
                        Client.field332.method3144(245);
                        Client.field332.method2874(var1);
                        Client.field332.method2872(var0);
                        Client.field332.method2872(var9);
                     }

                     if(var3 == 4) {
                        Client.field332.method3144(184);
                        Client.field332.method2874(var1);
                        Client.field332.method2872(var0);
                        Client.field332.method2872(var9);
                     }

                     if(var3 == 5) {
                        Client.field332.method3144(162);
                        Client.field332.method2874(var1);
                        Client.field332.method2872(var0);
                        Client.field332.method2872(var9);
                     }

                     if(var3 == 6) {
                        Client.field332.method3144(236);
                        Client.field332.method2874(var1);
                        Client.field332.method2872(var0);
                        Client.field332.method2872(var9);
                     }

                     if(var3 == 7) {
                        Client.field332.method3144(153);
                        Client.field332.method2874(var1);
                        Client.field332.method2872(var0);
                        Client.field332.method2872(var9);
                     }

                     if(var3 == 8) {
                        Client.field332.method3144(160);
                        Client.field332.method2874(var1);
                        Client.field332.method2872(var0);
                        Client.field332.method2872(var9);
                     }

                     if(var3 == 9) {
                        Client.field332.method3144(75);
                        Client.field332.method2874(var1);
                        Client.field332.method2872(var0);
                        Client.field332.method2872(var9);
                     }

                     if(var3 == 10) {
                        Client.field332.method3144(231);
                        Client.field332.method2874(var1);
                        Client.field332.method2872(var0);
                        Client.field332.method2872(var9);
                     }
                  }
               }
            }
         }
      }

      Player var21;
      if(var2 == 51) {
         var21 = Client.cachedPlayers[var3];
         if(null != var21) {
            Client.field489 = var6;
            Client.field490 = var7;
            Client.field399 = 2;
            Client.field426 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field332.method3144(19);
            Client.field332.method2873(class105.field1718[82]?1:0);
            Client.field332.method2940(var3);
         }
      }

      NPC var22;
      if(var2 == 10) {
         var22 = Client.cachedNPCs[var3];
         if(var22 != null) {
            Client.field489 = var6;
            Client.field490 = var7;
            Client.field399 = 2;
            Client.field426 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field332.method3144(128);
            Client.field332.method2910(var3);
            Client.field332.method2911(class105.field1718[82]?1:0);
         }
      }

      if(var2 == 50) {
         var21 = Client.cachedPlayers[var3];
         if(null != var21) {
            Client.field489 = var6;
            Client.field490 = var7;
            Client.field399 = 2;
            Client.field426 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field332.method3144(108);
            Client.field332.method2911(class105.field1718[82]?1:0);
            Client.field332.method2872(var3);
         }
      }

      if(var2 == 1002) {
         Client.field489 = var6;
         Client.field490 = var7;
         Client.field399 = 2;
         Client.field426 = 0;
         Client.field332.method3144(9);
         Client.field332.method2940(var3 >> 14 & 32767);
      }

      if(var2 == 48) {
         var21 = Client.cachedPlayers[var3];
         if(null != var21) {
            Client.field489 = var6;
            Client.field490 = var7;
            Client.field399 = 2;
            Client.field426 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field332.method3144(71);
            Client.field332.method2911(class105.field1718[82]?1:0);
            Client.field332.method2921(var3);
         }
      }

      if(var2 == 2) {
         Client.field489 = var6;
         Client.field490 = var7;
         Client.field399 = 2;
         Client.field426 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field332.method3144(110);
         Client.field332.method2872(SecondaryBufferProvider.baseY + var1);
         Client.field332.method2872(var0 + Player.baseX);
         Client.field332.method2911(class105.field1718[82]?1:0);
         Client.field332.method2910(Client.field529);
         Client.field332.method2872(var3 >> 14 & 32767);
         Client.field332.method2899(Player.field269);
      }

      if(var2 == 1) {
         Client.field489 = var6;
         Client.field490 = var7;
         Client.field399 = 2;
         Client.field426 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field332.method3144(172);
         Client.field332.method2874(class33.field750);
         Client.field332.method2921(SecondaryBufferProvider.baseY + var1);
         Client.field332.method2940(class16.field168);
         Client.field332.method2940(var3 >> 14 & 32767);
         Client.field332.method2873(class105.field1718[82]?1:0);
         Client.field332.method2940(var0 + Player.baseX);
         Client.field332.method2872(class6.field41);
      }

      if(var2 == 43) {
         Client.field332.method3144(28);
         Client.field332.method2940(var0);
         Client.field332.method2930(var1);
         Client.field332.method2921(var3);
         Client.field400 = 0;
         class186.field2773 = ChatLineBuffer.method993(var1);
         Client.field401 = var0;
      }

      if(var2 == 42) {
         Client.field332.method3144(90);
         Client.field332.method2930(var1);
         Client.field332.method2872(var0);
         Client.field332.method2940(var3);
         Client.field400 = 0;
         class186.field2773 = ChatLineBuffer.method993(var1);
         Client.field401 = var0;
      }

      if(var2 == 45) {
         var21 = Client.cachedPlayers[var3];
         if(var21 != null) {
            Client.field489 = var6;
            Client.field490 = var7;
            Client.field399 = 2;
            Client.field426 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field332.method3144(203);
            Client.field332.method2872(var3);
            Client.field332.method2911(class105.field1718[82]?1:0);
         }
      }

      if(var2 == 11) {
         var22 = Client.cachedNPCs[var3];
         if(null != var22) {
            Client.field489 = var6;
            Client.field490 = var7;
            Client.field399 = 2;
            Client.field426 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field332.method3144(57);
            Client.field332.method2940(var3);
            Client.field332.method3091(class105.field1718[82]?1:0);
         }
      }

      if(var2 == 13) {
         var22 = Client.cachedNPCs[var3];
         if(var22 != null) {
            Client.field489 = var6;
            Client.field490 = var7;
            Client.field399 = 2;
            Client.field426 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field332.method3144(219);
            Client.field332.method3091(class105.field1718[82]?1:0);
            Client.field332.method2921(var3);
         }
      }

      if(var2 == 20) {
         Client.field489 = var6;
         Client.field490 = var7;
         Client.field399 = 2;
         Client.field426 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field332.method3144(246);
         Client.field332.method2872(var1 + SecondaryBufferProvider.baseY);
         Client.field332.method2921(var3);
         Client.field332.method2911(class105.field1718[82]?1:0);
         Client.field332.method2910(Player.baseX + var0);
      }

      if(var2 == 44) {
         var21 = Client.cachedPlayers[var3];
         if(var21 != null) {
            Client.field489 = var6;
            Client.field490 = var7;
            Client.field399 = 2;
            Client.field426 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field332.method3144(100);
            Client.field332.method2910(var3);
            Client.field332.method2873(class105.field1718[82]?1:0);
         }
      }

      if(var2 == 15) {
         var21 = Client.cachedPlayers[var3];
         if(null != var21) {
            Client.field489 = var6;
            Client.field490 = var7;
            Client.field399 = 2;
            Client.field426 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field332.method3144(149);
            Client.field332.method2940(Client.field529);
            Client.field332.method2873(class105.field1718[82]?1:0);
            Client.field332.method2872(var3);
            Client.field332.method2930(Player.field269);
         }
      }

      if(var2 == 46) {
         var21 = Client.cachedPlayers[var3];
         if(null != var21) {
            Client.field489 = var6;
            Client.field490 = var7;
            Client.field399 = 2;
            Client.field426 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field332.method3144(120);
            Client.field332.method2940(var3);
            Client.field332.method3091(class105.field1718[82]?1:0);
         }
      }

      if(var2 == 34) {
         Client.field332.method3144(145);
         Client.field332.method2910(var3);
         Client.field332.method2872(var0);
         Client.field332.method2929(var1);
         Client.field400 = 0;
         class186.field2773 = ChatLineBuffer.method993(var1);
         Client.field401 = var0;
      }

      if(var2 == 30 && null == Client.field543) {
         class107.method2127(var1, var0);
         Client.field543 = class33.method774(var1, var0);
         ChatLineBuffer.method996(Client.field543);
      }

      if(var2 == 4) {
         Client.field489 = var6;
         Client.field490 = var7;
         Client.field399 = 2;
         Client.field426 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field332.method3144(82);
         Client.field332.method2911(class105.field1718[82]?1:0);
         Client.field332.method2921(var3 >> 14 & 32767);
         Client.field332.method2910(var0 + Player.baseX);
         Client.field332.method2872(SecondaryBufferProvider.baseY + var1);
      }

      if(var2 == 8) {
         var22 = Client.cachedNPCs[var3];
         if(null != var22) {
            Client.field489 = var6;
            Client.field490 = var7;
            Client.field399 = 2;
            Client.field426 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field332.method3144(251);
            Client.field332.method2910(Client.field529);
            Client.field332.method2910(var3);
            Client.field332.method2930(Player.field269);
            Client.field332.method2911(class105.field1718[82]?1:0);
         }
      }

      if(var2 == 37) {
         Client.field332.method3144(68);
         Client.field332.method2940(var0);
         Client.field332.method2899(var1);
         Client.field332.method2910(var3);
         Client.field400 = 0;
         class186.field2773 = ChatLineBuffer.method993(var1);
         Client.field401 = var0;
      }

      if(var2 == 47) {
         var21 = Client.cachedPlayers[var3];
         if(null != var21) {
            Client.field489 = var6;
            Client.field490 = var7;
            Client.field399 = 2;
            Client.field426 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field332.method3144(202);
            Client.field332.method2921(var3);
            Client.field332.method2911(class105.field1718[82]?1:0);
         }
      }

      if(var2 == 22) {
         Client.field489 = var6;
         Client.field490 = var7;
         Client.field399 = 2;
         Client.field426 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field332.method3144(209);
         Client.field332.method3091(class105.field1718[82]?1:0);
         Client.field332.method2921(var0 + Player.baseX);
         Client.field332.method2940(var3);
         Client.field332.method2921(SecondaryBufferProvider.baseY + var1);
      }

      if(var2 == 31) {
         Client.field332.method3144(62);
         Client.field332.method2921(var3);
         Client.field332.method2929(var1);
         Client.field332.method2910(class16.field168);
         Client.field332.method2921(var0);
         Client.field332.method2874(class33.field750);
         Client.field332.method2940(class6.field41);
         Client.field400 = 0;
         class186.field2773 = ChatLineBuffer.method993(var1);
         Client.field401 = var0;
      }

      if(var2 == 6) {
         Client.field489 = var6;
         Client.field490 = var7;
         Client.field399 = 2;
         Client.field426 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field332.method3144(116);
         Client.field332.method2910(SecondaryBufferProvider.baseY + var1);
         Client.field332.method3091(class105.field1718[82]?1:0);
         Client.field332.method2910(var3 >> 14 & 32767);
         Client.field332.method2921(var0 + Player.baseX);
      }

      if(var2 == 16) {
         Client.field489 = var6;
         Client.field490 = var7;
         Client.field399 = 2;
         Client.field426 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field332.method3144(99);
         Client.field332.method2929(class33.field750);
         Client.field332.method2921(class6.field41);
         Client.field332.method2940(Player.baseX + var0);
         Client.field332.method2873(class105.field1718[82]?1:0);
         Client.field332.method2940(class16.field168);
         Client.field332.method2872(SecondaryBufferProvider.baseY + var1);
         Client.field332.method2921(var3);
      }

      if(var2 == 18) {
         Client.field489 = var6;
         Client.field490 = var7;
         Client.field399 = 2;
         Client.field426 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field332.method3144(72);
         Client.field332.method3091(class105.field1718[82]?1:0);
         Client.field332.method2921(SecondaryBufferProvider.baseY + var1);
         Client.field332.method2910(Player.baseX + var0);
         Client.field332.method2940(var3);
      }

      if(var2 == 1001) {
         Client.field489 = var6;
         Client.field490 = var7;
         Client.field399 = 2;
         Client.field426 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field332.method3144(4);
         Client.field332.method2921(Player.baseX + var0);
         Client.field332.method2873(class105.field1718[82]?1:0);
         Client.field332.method2872(var3 >> 14 & 32767);
         Client.field332.method2910(SecondaryBufferProvider.baseY + var1);
      }

      if(var2 == 1005) {
         var8 = ChatLineBuffer.method993(var1);
         if(null != var8 && var8.itemQuantities[var0] >= 100000) {
            class88.sendGameMessage(27, "", var8.itemQuantities[var0] + " x " + ChatLineBuffer.getItemDefinition(var3).name);
         } else {
            Client.field332.method3144(233);
            Client.field332.method2940(var3);
         }

         Client.field400 = 0;
         class186.field2773 = ChatLineBuffer.method993(var1);
         Client.field401 = var0;
      }

      if(var2 == 1004) {
         Client.field489 = var6;
         Client.field490 = var7;
         Client.field399 = 2;
         Client.field426 = 0;
         Client.field332.method3144(233);
         Client.field332.method2940(var3);
      }

      if(var2 == 7) {
         var22 = Client.cachedNPCs[var3];
         if(var22 != null) {
            Client.field489 = var6;
            Client.field490 = var7;
            Client.field399 = 2;
            Client.field426 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field332.method3144(222);
            Client.field332.method2930(class33.field750);
            Client.field332.method2911(class105.field1718[82]?1:0);
            Client.field332.method2910(class6.field41);
            Client.field332.method2872(class16.field168);
            Client.field332.method2940(var3);
         }
      }

      if(var2 == 39) {
         Client.field332.method3144(118);
         Client.field332.method2930(var1);
         Client.field332.method2872(var3);
         Client.field332.method2940(var0);
         Client.field400 = 0;
         class186.field2773 = ChatLineBuffer.method993(var1);
         Client.field401 = var0;
      }

      if(var2 == 41) {
         Client.field332.method3144(101);
         Client.field332.method2940(var0);
         Client.field332.method2899(var1);
         Client.field332.method2921(var3);
         Client.field400 = 0;
         class186.field2773 = ChatLineBuffer.method993(var1);
         Client.field401 = var0;
      }

      if(var2 == 36) {
         Client.field332.method3144(147);
         Client.field332.method2874(var1);
         Client.field332.method2872(var3);
         Client.field332.method2910(var0);
         Client.field400 = 0;
         class186.field2773 = ChatLineBuffer.method993(var1);
         Client.field401 = var0;
      }

      if(var2 == 17) {
         Client.field489 = var6;
         Client.field490 = var7;
         Client.field399 = 2;
         Client.field426 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field332.method3144(134);
         Client.field332.method2930(Player.field269);
         Client.field332.method2872(SecondaryBufferProvider.baseY + var1);
         Client.field332.method2921(var3);
         Client.field332.method2910(Client.field529);
         Client.field332.method2921(var0 + Player.baseX);
         Client.field332.method3083(class105.field1718[82]?1:0);
      }

      if(var2 == 32) {
         Client.field332.method3144(150);
         Client.field332.method2874(Player.field269);
         Client.field332.method2874(var1);
         Client.field332.method2921(Client.field529);
         Client.field332.method2910(var3);
         Client.field332.method2872(var0);
         Client.field400 = 0;
         class186.field2773 = ChatLineBuffer.method993(var1);
         Client.field401 = var0;
      }

      if(var2 == 14) {
         var21 = Client.cachedPlayers[var3];
         if(null != var21) {
            Client.field489 = var6;
            Client.field490 = var7;
            Client.field399 = 2;
            Client.field426 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field332.method3144(142);
            Client.field332.method2910(class6.field41);
            Client.field332.method2940(var3);
            Client.field332.method2930(class33.field750);
            Client.field332.method2872(class16.field168);
            Client.field332.method3083(class105.field1718[82]?1:0);
         }
      }

      if(var2 == 33) {
         Client.field332.method3144(67);
         Client.field332.method2921(var3);
         Client.field332.method2940(var0);
         Client.field332.method2874(var1);
         Client.field400 = 0;
         class186.field2773 = ChatLineBuffer.method993(var1);
         Client.field401 = var0;
      }

      if(var2 == 23) {
         if(Client.isMenuOpen) {
            Friend.region.method1812();
         } else {
            Friend.region.method1826(CollisionData.plane, var0, var1, true);
         }
      }

      if(var2 == 1003) {
         Client.field489 = var6;
         Client.field490 = var7;
         Client.field399 = 2;
         Client.field426 = 0;
         var22 = Client.cachedNPCs[var3];
         if(var22 != null) {
            NPCComposition var20 = var22.composition;
            if(var20.configs != null) {
               var20 = var20.method3779();
            }

            if(null != var20) {
               Client.field332.method3144(81);
               Client.field332.method2910(var20.id);
            }
         }
      }

      if(var2 == 3) {
         Client.field489 = var6;
         Client.field490 = var7;
         Client.field399 = 2;
         Client.field426 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field332.method3144(201);
         Client.field332.method2940(SecondaryBufferProvider.baseY + var1);
         Client.field332.method2921(Player.baseX + var0);
         Client.field332.method2872(var3 >> 14 & 32767);
         Client.field332.method3083(class105.field1718[82]?1:0);
      }

      if(var2 == 24) {
         var8 = ChatLineBuffer.method993(var1);
         boolean var23 = true;
         if(var8.contentType > 0) {
            var23 = DecorativeObject.method2018(var8);
         }

         if(var23) {
            Client.field332.method3144(131);
            Client.field332.method2874(var1);
         }
      }

      if(var2 == 12) {
         var22 = Client.cachedNPCs[var3];
         if(null != var22) {
            Client.field489 = var6;
            Client.field490 = var7;
            Client.field399 = 2;
            Client.field426 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field332.method3144(55);
            Client.field332.method2910(var3);
            Client.field332.method2873(class105.field1718[82]?1:0);
         }
      }

      if(var2 == 21) {
         Client.field489 = var6;
         Client.field490 = var7;
         Client.field399 = 2;
         Client.field426 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field332.method3144(170);
         Client.field332.method2940(var1 + SecondaryBufferProvider.baseY);
         Client.field332.method2910(var3);
         Client.field332.method2940(var0 + Player.baseX);
         Client.field332.method2873(class105.field1718[82]?1:0);
      }

      if(var2 == 49) {
         var21 = Client.cachedPlayers[var3];
         if(var21 != null) {
            Client.field489 = var6;
            Client.field490 = var7;
            Client.field399 = 2;
            Client.field426 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field332.method3144(124);
            Client.field332.method2872(var3);
            Client.field332.method3083(class105.field1718[82]?1:0);
         }
      }

      if(var2 == 38) {
         Frames.method1996();
         var8 = ChatLineBuffer.method993(var1);
         Client.field416 = 1;
         class6.field41 = var0;
         class33.field750 = var1;
         class16.field168 = var3;
         ChatLineBuffer.method996(var8);
         Client.field443 = method813(16748608) + ChatLineBuffer.getItemDefinition(var3).name + method813(16777215);
         if(Client.field443 == null) {
            Client.field443 = "null";
         }

      } else {
         if(var2 == 26) {
            Client.field332.method3144(200);

            for(WidgetNode var25 = (WidgetNode)Client.componentTable.method2440(); null != var25; var25 = (WidgetNode)Client.componentTable.method2441()) {
               if(var25.field176 == 0 || var25.field176 == 3) {
                  class18.method203(var25, true);
               }
            }

            if(Client.field543 != null) {
               ChatLineBuffer.method996(Client.field543);
               Client.field543 = null;
            }
         }

         if(var2 != 25) {
            if(var2 == 28) {
               Client.field332.method3144(131);
               Client.field332.method2874(var1);
               var8 = ChatLineBuffer.method993(var1);
               if(null != var8.dynamicValues && var8.dynamicValues[0][0] == 5) {
                  var9 = var8.dynamicValues[0][1];
                  class165.widgetSettings[var9] = 1 - class165.widgetSettings[var9];
                  class139.method2577(var9);
               }
            }

            if(var2 == 35) {
               Client.field332.method3144(32);
               Client.field332.method2921(var3);
               Client.field332.method2940(var0);
               Client.field332.method2930(var1);
               Client.field400 = 0;
               class186.field2773 = ChatLineBuffer.method993(var1);
               Client.field401 = var0;
            }

            if(var2 == 58) {
               var8 = class33.method774(var1, var0);
               if(var8 != null) {
                  Client.field332.method3144(78);
                  Client.field332.method2910(var8.item);
                  Client.field332.method2899(var1);
                  Client.field332.method2910(Client.field529);
                  Client.field332.method2940(var0);
                  Client.field332.method2872(Client.field446);
                  Client.field332.method2929(Player.field269);
               }
            }

            if(var2 == 5) {
               Client.field489 = var6;
               Client.field490 = var7;
               Client.field399 = 2;
               Client.field426 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field332.method3144(107);
               Client.field332.method3091(class105.field1718[82]?1:0);
               Client.field332.method2940(var3 >> 14 & 32767);
               Client.field332.method2872(Player.baseX + var0);
               Client.field332.method2921(SecondaryBufferProvider.baseY + var1);
            }

            if(var2 == 19) {
               Client.field489 = var6;
               Client.field490 = var7;
               Client.field399 = 2;
               Client.field426 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field332.method3144(112);
               Client.field332.method2873(class105.field1718[82]?1:0);
               Client.field332.method2921(var1 + SecondaryBufferProvider.baseY);
               Client.field332.method2921(var3);
               Client.field332.method2940(Player.baseX + var0);
            }

            if(var2 == 29) {
               Client.field332.method3144(131);
               Client.field332.method2874(var1);
               var8 = ChatLineBuffer.method993(var1);
               if(var8.dynamicValues != null && var8.dynamicValues[0][0] == 5) {
                  var9 = var8.dynamicValues[0][1];
                  if(class165.widgetSettings[var9] != var8.field2262[0]) {
                     class165.widgetSettings[var9] = var8.field2262[0];
                     class139.method2577(var9);
                  }
               }
            }

            if(var2 == 9) {
               var22 = Client.cachedNPCs[var3];
               if(var22 != null) {
                  Client.field489 = var6;
                  Client.field490 = var7;
                  Client.field399 = 2;
                  Client.field426 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field332.method3144(114);
                  Client.field332.method2911(class105.field1718[82]?1:0);
                  Client.field332.method2872(var3);
               }
            }

            if(var2 == 40) {
               Client.field332.method3144(252);
               Client.field332.method2940(var3);
               Client.field332.method2910(var0);
               Client.field332.method2929(var1);
               Client.field400 = 0;
               class186.field2773 = ChatLineBuffer.method993(var1);
               Client.field401 = var0;
            }

            if(Client.field416 != 0) {
               Client.field416 = 0;
               ChatLineBuffer.method996(ChatLineBuffer.method993(class33.field750));
            }

            if(Client.field444) {
               Frames.method1996();
            }

            if(null != class186.field2773 && Client.field400 == 0) {
               ChatLineBuffer.method996(class186.field2773);
            }

         } else {
            var8 = class33.method774(var1, var0);
            if(var8 != null) {
               Frames.method1996();
               int var19 = MessageNode.method220(var8);
               var9 = var19 >> 11 & 63;
               int var24 = var8.item;
               Widget var18 = class33.method774(var1, var0);
               if(var18 != null && null != var18.field2252) {
                  class18 var14 = new class18();
                  var14.field188 = var18;
                  var14.field196 = var18.field2252;
                  class40.method828(var14);
               }

               Client.field446 = var24;
               Client.field444 = true;
               Player.field269 = var1;
               Client.field529 = var0;
               CombatInfoListHolder.field759 = var9;
               ChatLineBuffer.method996(var18);
               Client.field416 = 0;
               int var15 = MessageNode.method220(var8);
               var17 = var15 >> 11 & 63;
               String var26;
               if(var17 == 0) {
                  var26 = null;
               } else if(null != var8.field2251 && var8.field2251.trim().length() != 0) {
                  var26 = var8.field2251;
               } else {
                  var26 = null;
               }

               Client.field353 = var26;
               if(Client.field353 == null) {
                  Client.field353 = "Null";
               }

               if(var8.hasScript) {
                  Client.field448 = var8.name + method813(16777215);
               } else {
                  Client.field448 = method813('\uff00') + var8.field2258 + method813(16777215);
               }
            }

         }
      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIB)V",
      garbageValue = "126"
   )
   static void method816(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = TextureProvider.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field629 = 0;
            var0.actionAnimationDisable = var2;
            var0.field639 = 0;
         }

         if(var3 == 2) {
            var0.field639 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || TextureProvider.getAnimation(var1).forcedPriority >= TextureProvider.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field629 = 0;
         var0.actionAnimationDisable = var2;
         var0.field639 = 0;
         var0.field662 = var0.field657;
      }

   }

   class37() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-2002274696"
   )
   static final void method817(String var0) {
      if(null != var0) {
         String var1 = class60.method1229(var0, class149.field2037);
         if(var1 != null) {
            for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
               Ignore var3 = Client.ignores[var2];
               String var4 = var3.name;
               String var5 = class60.method1229(var4, class149.field2037);
               boolean var6;
               if(null != var0 && var4 != null) {
                  if(!var0.startsWith("#") && !var4.startsWith("#")) {
                     var6 = var1.equals(var5);
                  } else {
                     var6 = var0.equals(var4);
                  }
               } else {
                  var6 = false;
               }

               if(var6) {
                  --Client.ignoreCount;

                  for(int var7 = var2; var7 < Client.ignoreCount; ++var7) {
                     Client.ignores[var7] = Client.ignores[var7 + 1];
                  }

                  Client.field482 = Client.field505;
                  Client.field332.method3144(143);
                  Client.field332.method2873(class165.method3233(var0));
                  Client.field332.method2915(var0);
                  break;
               }
            }

         }
      }
   }
}
