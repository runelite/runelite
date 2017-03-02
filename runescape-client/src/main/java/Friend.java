import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1710291783
   )
   @Export("rank")
   int rank;
   @ObfuscatedName("b")
   @Export("name")
   String name;
   @ObfuscatedName("k")
   boolean field144;
   @ObfuscatedName("l")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("h")
   boolean field147;
   @ObfuscatedName("fw")
   @ObfuscatedGetter(
      intValue = 99797827
   )
   @Export("cameraYaw")
   static int cameraYaw;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -123454479
   )
   @Export("world")
   int world;
   @ObfuscatedName("f")
   public static short[][] field151;

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(LNPCComposition;IIIB)V",
      garbageValue = "31"
   )
   static final void method184(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.configs != null) {
            var0 = var0.method3807();
         }

         if(null != var0) {
            if(var0.field3039) {
               if(!var0.field3041 || var1 == Client.field453) {
                  String var4 = var0.name;
                  if(var0.combatLevel != 0) {
                     var4 = var4 + class18.method205(var0.combatLevel, class9.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(var0.field3041 && Client.field431) {
                     class164.addMenuEntry("Examine", class187.method3515(16776960) + var4, 1003, var1, var2, var3);
                  }

                  if(Client.field438 == 1) {
                     class164.addMenuEntry("Use", Client.field439 + " " + "->" + " " + class187.method3515(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.field549) {
                     if((class137.field1908 & 2) == 2) {
                        class164.addMenuEntry(Client.field328, Client.field350 + " " + "->" + " " + class187.method3515(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     int var5 = var0.field3041 && Client.field431?2000:0;
                     String[] var6 = var0.actions;
                     if(Client.field456) {
                        var6 = class155.method3078(var6);
                     }

                     int var7;
                     int var8;
                     if(var6 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(null != var6[var7] && !var6[var7].equalsIgnoreCase("Attack")) {
                              var8 = 0;
                              if(var7 == 0) {
                                 var8 = var5 + 9;
                              }

                              if(var7 == 1) {
                                 var8 = var5 + 10;
                              }

                              if(var7 == 2) {
                                 var8 = 11 + var5;
                              }

                              if(var7 == 3) {
                                 var8 = 12 + var5;
                              }

                              if(var7 == 4) {
                                 var8 = 13 + var5;
                              }

                              class164.addMenuEntry(var6[var7], class187.method3515(16776960) + var4, var8, var1, var2, var3);
                           }
                        }
                     }

                     if(var6 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var6[var7] != null && var6[var7].equalsIgnoreCase("Attack")) {
                              short var9 = 0;
                              if(Client.field416 != class40.field808) {
                                 if(Client.field416 == class40.field810 || class40.field807 == Client.field416 && var0.combatLevel > class9.localPlayer.combatLevel) {
                                    var9 = 2000;
                                 }

                                 var8 = 0;
                                 if(var7 == 0) {
                                    var8 = 9 + var9;
                                 }

                                 if(var7 == 1) {
                                    var8 = 10 + var9;
                                 }

                                 if(var7 == 2) {
                                    var8 = 11 + var9;
                                 }

                                 if(var7 == 3) {
                                    var8 = 12 + var9;
                                 }

                                 if(var7 == 4) {
                                    var8 = 13 + var9;
                                 }

                                 class164.addMenuEntry(var6[var7], class187.method3515(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     if(!var0.field3041 || !Client.field431) {
                        class164.addMenuEntry("Examine", class187.method3515(16776960) + var4, 1003, var1, var2, var3);
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LWorld;I)V",
      garbageValue = "1291781585"
   )
   static void method185(World var0) {
      if(var0.method664() != Client.isMembers) {
         Client.isMembers = var0.method664();
         class162.method3173(var0.method664());
      }

      class105.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      VertexNormal.field1406 = Client.field295 == 0?'ꩊ':var0.id + '鱀';
      class44.field890 = Client.field295 == 0?443:var0.id + '썐';
      class31.field713 = VertexNormal.field1406;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static final void method186() {
      class108.method2096();
      NPC.method778();
      class16.method198();
      class114.method2269();
      NPCComposition.field3006.reset();
      NPCComposition.npcModelCache.reset();
      XItemContainer.method176();
      class184.method3455();
      Spotanim.field2809.reset();
      Spotanim.field2791.reset();
      Varbit.field2850.reset();
      class187.field2769.reset();
      class196.field2873.reset();
      class196.spriteCache.reset();
      class196.field2878.reset();
      CombatInfo2.field2832.reset();
      CombatInfo2.field2834.reset();
      class137.method2534();
      class206.method3919();
      ((TextureProvider)class84.field1415).method1495();
      Script.field934.reset();
      class22.field238.method3361();
      ChatMessages.field911.method3361();
      Client.field314.method3361();
      class1.field13.method3361();
      class26.field588.method3361();
      XItemContainer.field122.method3361();
      XClanMember.field266.method3361();
      class114.field1790.method3361();
      class40.field814.method3361();
      WallObject.field1545.method3361();
      class114.field1789.method3361();
      class143.field2004.method3361();
   }

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "128342783"
   )
   static void method187() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method2423(); var0 != null; var0 = (WidgetNode)Client.componentTable.method2424()) {
         int var1 = var0.id;
         if(class159.method3142(var1)) {
            boolean var2 = true;
            Widget[] var3 = Widget.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = class140.method2681(var4);
               if(null != var5) {
                  Frames.method1960(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "624899158"
   )
   static final void method188() {
      Buffer.method2913(false);
      Client.field340 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < class105.field1711.length; ++var1) {
         if(class104.field1687[var1] != -1 && class105.field1711[var1] == null) {
            class105.field1711[var1] = class26.field588.getConfigData(class104.field1687[var1], 0);
            if(class105.field1711[var1] == null) {
               var0 = false;
               ++Client.field340;
            }
         }

         if(class6.field52[var1] != -1 && null == GameEngine.field1779[var1]) {
            GameEngine.field1779[var1] = class26.field588.getConfigData(class6.field52[var1], 0, XItemContainer.xteaKeys[var1]);
            if(GameEngine.field1779[var1] == null) {
               var0 = false;
               ++Client.field340;
            }
         }
      }

      if(!var0) {
         Client.field344 = 1;
      } else {
         Client.field532 = 0;
         var0 = true;

         int var3;
         int var4;
         for(var1 = 0; var1 < class105.field1711.length; ++var1) {
            byte[] var23 = GameEngine.field1779[var1];
            if(var23 != null) {
               var3 = (class3.mapRegions[var1] >> 8) * 64 - MessageNode.baseX;
               var4 = 64 * (class3.mapRegions[var1] & 255) - class2.baseY;
               if(Client.isDynamicRegion) {
                  var3 = 10;
                  var4 = 10;
               }

               var0 &= class112.method2161(var23, var3, var4);
            }
         }

         if(!var0) {
            Client.field344 = 2;
         } else {
            if(Client.field344 != 0) {
               XGrandExchangeOffer.method65("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            class22.method224();
            method186();
            class22.method224();
            Varbit.region.method1756();
            class22.method224();
            System.gc();

            for(var1 = 0; var1 < 4; ++var1) {
               Client.collisionMaps[var1].method2316();
            }

            int var2;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var2 = 0; var2 < 104; ++var2) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     class10.tileSettings[var1][var2][var3] = 0;
                  }
               }
            }

            class22.method224();
            Frames.method1961();
            var1 = class105.field1711.length;
            class105.method2075();
            Buffer.method2913(true);
            int var5;
            int var7;
            int var9;
            int var10;
            int var11;
            int var12;
            int var26;
            if(!Client.isDynamicRegion) {
               byte[] var25;
               for(var2 = 0; var2 < var1; ++var2) {
                  var3 = 64 * (class3.mapRegions[var2] >> 8) - MessageNode.baseX;
                  var4 = (class3.mapRegions[var2] & 255) * 64 - class2.baseY;
                  var25 = class105.field1711[var2];
                  if(var25 != null) {
                     class22.method224();
                     var26 = Renderable.field1528 * 8 - 48;
                     var7 = class156.field2107 * 8 - 48;
                     CollisionData[] var8 = Client.collisionMaps;

                     for(var9 = 0; var9 < 4; ++var9) {
                        for(var10 = 0; var10 < 64; ++var10) {
                           for(var11 = 0; var11 < 64; ++var11) {
                              if(var3 + var10 > 0 && var10 + var3 < 103 && var4 + var11 > 0 && var4 + var11 < 103) {
                                 var8[var9].flags[var10 + var3][var11 + var4] &= -16777217;
                              }
                           }
                        }
                     }

                     Buffer var27 = new Buffer(var25);

                     for(var10 = 0; var10 < 4; ++var10) {
                        for(var11 = 0; var11 < 64; ++var11) {
                           for(var12 = 0; var12 < 64; ++var12) {
                              class9.method117(var27, var10, var11 + var3, var12 + var4, var26, var7, 0);
                           }
                        }
                     }
                  }
               }

               for(var2 = 0; var2 < var1; ++var2) {
                  var3 = 64 * (class3.mapRegions[var2] >> 8) - MessageNode.baseX;
                  var4 = 64 * (class3.mapRegions[var2] & 255) - class2.baseY;
                  var25 = class105.field1711[var2];
                  if(null == var25 && class156.field2107 < 800) {
                     class22.method224();
                     FaceNormal.method1951(var3, var4, 64, 64);
                  }
               }

               Buffer.method2913(true);

               for(var2 = 0; var2 < var1; ++var2) {
                  byte[] var24 = GameEngine.field1779[var2];
                  if(var24 != null) {
                     var4 = (class3.mapRegions[var2] >> 8) * 64 - MessageNode.baseX;
                     var5 = 64 * (class3.mapRegions[var2] & 255) - class2.baseY;
                     class22.method224();
                     Region var6 = Varbit.region;
                     CollisionData[] var29 = Client.collisionMaps;
                     Buffer var31 = new Buffer(var24);
                     var9 = -1;

                     while(true) {
                        var10 = var31.method2991();
                        if(var10 == 0) {
                           break;
                        }

                        var9 += var10;
                        var11 = 0;

                        while(true) {
                           var12 = var31.method2991();
                           if(var12 == 0) {
                              break;
                           }

                           var11 += var12 - 1;
                           int var13 = var11 & 63;
                           int var14 = var11 >> 6 & 63;
                           int var15 = var11 >> 12;
                           int var16 = var31.readUnsignedByte();
                           int var17 = var16 >> 2;
                           int var18 = var16 & 3;
                           int var19 = var4 + var14;
                           int var20 = var5 + var13;
                           if(var19 > 0 && var20 > 0 && var19 < 103 && var20 < 103) {
                              int var21 = var15;
                              if((class10.tileSettings[1][var19][var20] & 2) == 2) {
                                 var21 = var15 - 1;
                              }

                              CollisionData var22 = null;
                              if(var21 >= 0) {
                                 var22 = var29[var21];
                              }

                              ItemLayer.method1517(var15, var19, var20, var9, var18, var17, var6, var22);
                           }
                        }
                     }
                  }
               }
            }

            int var28;
            if(Client.isDynamicRegion) {
               for(var2 = 0; var2 < 4; ++var2) {
                  class22.method224();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var30 = false;
                        var26 = Client.field347[var2][var3][var4];
                        if(var26 != -1) {
                           var7 = var26 >> 24 & 3;
                           var28 = var26 >> 1 & 3;
                           var9 = var26 >> 14 & 1023;
                           var10 = var26 >> 3 & 2047;
                           var11 = (var9 / 8 << 8) + var10 / 8;

                           for(var12 = 0; var12 < class3.mapRegions.length; ++var12) {
                              if(var11 == class3.mapRegions[var12] && null != class105.field1711[var12]) {
                                 ItemLayer.method1518(class105.field1711[var12], var2, var3 * 8, 8 * var4, var7, (var9 & 7) * 8, 8 * (var10 & 7), var28, Client.collisionMaps);
                                 var30 = true;
                                 break;
                              }
                           }
                        }

                        if(!var30) {
                           var7 = var2;
                           var28 = var3 * 8;
                           var9 = var4 * 8;

                           for(var10 = 0; var10 < 8; ++var10) {
                              for(var11 = 0; var11 < 8; ++var11) {
                                 class10.tileHeights[var7][var28 + var10][var11 + var9] = 0;
                              }
                           }

                           if(var28 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class10.tileHeights[var7][var28][var9 + var10] = class10.tileHeights[var7][var28 - 1][var10 + var9];
                              }
                           }

                           if(var9 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class10.tileHeights[var7][var28 + var10][var9] = class10.tileHeights[var7][var28 + var10][var9 - 1];
                              }
                           }

                           if(var28 > 0 && class10.tileHeights[var7][var28 - 1][var9] != 0) {
                              class10.tileHeights[var7][var28][var9] = class10.tileHeights[var7][var28 - 1][var9];
                           } else if(var9 > 0 && class10.tileHeights[var7][var28][var9 - 1] != 0) {
                              class10.tileHeights[var7][var28][var9] = class10.tileHeights[var7][var28][var9 - 1];
                           } else if(var28 > 0 && var9 > 0 && class10.tileHeights[var7][var28 - 1][var9 - 1] != 0) {
                              class10.tileHeights[var7][var28][var9] = class10.tileHeights[var7][var28 - 1][var9 - 1];
                           }
                        }
                     }
                  }
               }

               for(var2 = 0; var2 < 13; ++var2) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = Client.field347[0][var2][var3];
                     if(var4 == -1) {
                        FaceNormal.method1951(var2 * 8, 8 * var3, 8, 8);
                     }
                  }
               }

               Buffer.method2913(true);

               for(var2 = 0; var2 < 4; ++var2) {
                  class22.method224();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        var5 = Client.field347[var2][var3][var4];
                        if(var5 != -1) {
                           var26 = var5 >> 24 & 3;
                           var7 = var5 >> 1 & 3;
                           var28 = var5 >> 14 & 1023;
                           var9 = var5 >> 3 & 2047;
                           var10 = (var28 / 8 << 8) + var9 / 8;

                           for(var11 = 0; var11 < class3.mapRegions.length; ++var11) {
                              if(var10 == class3.mapRegions[var11] && null != GameEngine.field1779[var11]) {
                                 class101.method2012(GameEngine.field1779[var11], var2, 8 * var3, 8 * var4, var26, 8 * (var28 & 7), (var9 & 7) * 8, var7, Varbit.region, Client.collisionMaps);
                                 break;
                              }
                           }
                        }
                     }
                  }
               }
            }

            Buffer.method2913(true);
            method186();
            class22.method224();
            class181.method3345(Varbit.region, Client.collisionMaps);
            Buffer.method2913(true);
            var2 = class10.field109;
            if(var2 > class156.plane) {
               var2 = class156.plane;
            }

            if(var2 < class156.plane - 1) {
               var2 = class156.plane - 1;
            }

            if(Client.field404) {
               Varbit.region.method1757(class10.field109);
            } else {
               Varbit.region.method1757(0);
            }

            for(var3 = 0; var3 < 104; ++var3) {
               for(var4 = 0; var4 < 104; ++var4) {
                  Script.groundItemSpawned(var3, var4);
               }
            }

            class22.method224();

            for(class25 var32 = (class25)Client.field467.method2472(); null != var32; var32 = (class25)Client.field467.method2479()) {
               if(var32.field581 == -1) {
                  var32.field582 = 0;
                  class162.method3169(var32);
               } else {
                  var32.unlink();
               }
            }

            ObjectComposition.field2900.reset();
            if(Item.field881 != null) {
               Client.field327.method3124(167);
               Client.field327.method2844(1057001181);
            }

            if(!Client.isDynamicRegion) {
               var3 = (Renderable.field1528 - 6) / 8;
               var4 = (Renderable.field1528 + 6) / 8;
               var5 = (class156.field2107 - 6) / 8;
               var26 = (class156.field2107 + 6) / 8;

               for(var7 = var3 - 1; var7 <= var4 + 1; ++var7) {
                  for(var28 = var5 - 1; var28 <= 1 + var26; ++var28) {
                     if(var7 < var3 || var7 > var4 || var28 < var5 || var28 > var26) {
                        class26.field588.method3368("m" + var7 + "_" + var28);
                        class26.field588.method3368("l" + var7 + "_" + var28);
                     }
                  }
               }
            }

            GameObject.setGameState(30);
            class22.method224();
            class155.method3080();
            Client.field327.method3124(202);
            class49.method970();
         }
      }
   }
}
