import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public class class37 {
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = -1078779363
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("o")
   static ModIcon field813;

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-302187053"
   )
   static final void method817(Widget var0, int var1, int var2) {
      if(var0.field2212 == 1) {
         class115.addMenuEntry(var0.tooltip, "", 24, 0, 0, var0.id);
      }

      String var3;
      if(var0.field2212 == 2 && !Client.field511) {
         var3 = Friend.method177(var0);
         if(null != var3) {
            class115.addMenuEntry(var3, class18.method199('\uff00') + var0.field2308, 25, 0, -1, var0.id);
         }
      }

      if(var0.field2212 == 3) {
         class115.addMenuEntry("Close", "", 26, 0, 0, var0.id);
      }

      if(var0.field2212 == 4) {
         class115.addMenuEntry(var0.tooltip, "", 28, 0, 0, var0.id);
      }

      if(var0.field2212 == 5) {
         class115.addMenuEntry(var0.tooltip, "", 29, 0, 0, var0.id);
      }

      if(var0.field2212 == 6 && null == Client.field469) {
         class115.addMenuEntry(var0.tooltip, "", 30, 0, -1, var0.id);
      }

      int var4;
      int var5;
      int var18;
      if(var0.type == 2) {
         var18 = 0;

         for(var4 = 0; var4 < var0.height; ++var4) {
            for(var5 = 0; var5 < var0.width; ++var5) {
               int var6 = (32 + var0.field2339) * var5;
               int var7 = var4 * (var0.field2272 + 32);
               if(var18 < 20) {
                  var6 += var0.field2273[var18];
                  var7 += var0.field2258[var18];
               }

               if(var1 >= var6 && var2 >= var7 && var1 < 32 + var6 && var2 < 32 + var7) {
                  Client.field501 = var18;
                  class110.field1758 = var0;
                  if(var0.itemIds[var18] > 0) {
                     label382: {
                        ItemComposition var8 = class103.getItemDefinition(var0.itemIds[var18] - 1);
                        boolean var9;
                        int var10;
                        if(Client.field458 == 1) {
                           var10 = class196.method3614(var0);
                           var9 = (var10 >> 30 & 1) != 0;
                           if(var9) {
                              if(var0.id != class99.field1645 || class33.field770 != var18) {
                                 class115.addMenuEntry("Use", Client.field459 + " " + "->" + " " + class18.method199(16748608) + var8.name, 31, var8.id, var18, var0.id);
                              }
                              break label382;
                           }
                        }

                        if(Client.field511) {
                           var10 = class196.method3614(var0);
                           var9 = (var10 >> 30 & 1) != 0;
                           if(var9) {
                              if((class31.field739 & 16) == 16) {
                                 class115.addMenuEntry(Client.field463, Client.field380 + " " + "->" + " " + class18.method199(16748608) + var8.name, 32, var8.id, var18, var0.id);
                              }
                              break label382;
                           }
                        }

                        String[] var19 = var8.inventoryActions;
                        if(Client.field476) {
                           var19 = class119.method2343(var19);
                        }

                        var10 = var8.method3675();
                        int var12 = class196.method3614(var0);
                        boolean var11 = (var12 >> 30 & 1) != 0;
                        if(var11) {
                           for(int var13 = 4; var13 >= 3; --var13) {
                              boolean var14 = var13 == var10;
                              if(null != var19 && var19[var13] != null) {
                                 byte var15;
                                 if(var13 == 3) {
                                    var15 = 36;
                                 } else {
                                    var15 = 37;
                                 }

                                 GroundObject.method1595(var19[var13], class18.method199(16748608) + var8.name, var15, var8.id, var18, var0.id, var14);
                              } else if(var13 == 4) {
                                 GroundObject.method1595("Drop", class18.method199(16748608) + var8.name, 37, var8.id, var18, var0.id, var14);
                              }
                           }
                        }

                        Object var10000 = null;
                        if(XItemContainer.method166(class196.method3614(var0))) {
                           class115.addMenuEntry("Use", class18.method199(16748608) + var8.name, 38, var8.id, var18, var0.id);
                        }

                        int var24 = class196.method3614(var0);
                        boolean var23 = (var24 >> 30 & 1) != 0;
                        int var25;
                        if(var23 && null != var19) {
                           for(var25 = 2; var25 >= 0; --var25) {
                              boolean var16 = var25 == var10;
                              if(null != var19[var25]) {
                                 byte var17 = 0;
                                 if(var25 == 0) {
                                    var17 = 33;
                                 }

                                 if(var25 == 1) {
                                    var17 = 34;
                                 }

                                 if(var25 == 2) {
                                    var17 = 35;
                                 }

                                 GroundObject.method1595(var19[var25], class18.method199(16748608) + var8.name, var17, var8.id, var18, var0.id, var16);
                              }
                           }
                        }

                        var19 = var0.field2276;
                        if(Client.field476) {
                           var19 = class119.method2343(var19);
                        }

                        if(var19 != null) {
                           for(var25 = 4; var25 >= 0; --var25) {
                              if(var19[var25] != null) {
                                 byte var26 = 0;
                                 if(var25 == 0) {
                                    var26 = 39;
                                 }

                                 if(var25 == 1) {
                                    var26 = 40;
                                 }

                                 if(var25 == 2) {
                                    var26 = 41;
                                 }

                                 if(var25 == 3) {
                                    var26 = 42;
                                 }

                                 if(var25 == 4) {
                                    var26 = 43;
                                 }

                                 class115.addMenuEntry(var19[var25], class18.method199(16748608) + var8.name, var26, var8.id, var18, var0.id);
                              }
                           }
                        }

                        class115.addMenuEntry("Examine", class18.method199(16748608) + var8.name, 1005, var8.id, var18, var0.id);
                     }
                  }
               }

               ++var18;
            }
         }
      }

      if(var0.hasScript) {
         if(Client.field511) {
            var4 = class196.method3614(var0);
            boolean var27 = (var4 >> 21 & 1) != 0;
            if(var27 && (class31.field739 & 32) == 32) {
               class115.addMenuEntry(Client.field463, Client.field380 + " " + "->" + " " + var0.name, 58, 0, var0.index, var0.id);
            }
         } else {
            for(var18 = 9; var18 >= 5; --var18) {
               String var21 = CombatInfo1.method640(var0, var18);
               if(null != var21) {
                  class115.addMenuEntry(var21, var0.name, 1007, 1 + var18, var0.index, var0.id);
               }
            }

            var3 = Friend.method177(var0);
            if(var3 != null) {
               class115.addMenuEntry(var3, var0.name, 25, 0, var0.index, var0.id);
            }

            for(var4 = 4; var4 >= 0; --var4) {
               String var20 = CombatInfo1.method640(var0, var4);
               if(null != var20) {
                  class115.addMenuEntry(var20, var0.name, 57, 1 + var4, var0.index, var0.id);
               }
            }

            var5 = class196.method3614(var0);
            boolean var22 = (var5 & 1) != 0;
            if(var22) {
               class115.addMenuEntry("Continue", "", 30, 0, var0.index, var0.id);
            }
         }
      }

   }

   class37() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "17967613"
   )
   static final void method821(int var0, int var1, int var2, int var3) {
      if(Client.field458 == 0 && !Client.field511) {
         class115.addMenuEntry("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      int var4 = -1;
      int var5 = -1;

      int var6;
      int var7;
      for(var6 = 0; var6 < Model.field1422; ++var6) {
         var7 = Model.field1382[var6];
         int var8 = var7 & 127;
         int var9 = var7 >> 7 & 127;
         int var10 = var7 >> 29 & 3;
         int var11 = var7 >> 14 & 32767;
         if(var7 != var5) {
            var5 = var7;
            if(var10 == 2 && class48.region.method1777(WallObject.plane, var8, var9, var7) >= 0) {
               ObjectComposition var12 = class187.getObjectDefinition(var11);
               if(null != var12.impostorIds) {
                  var12 = var12.getImpostor();
               }

               if(null == var12) {
                  continue;
               }

               if(Client.field458 == 1) {
                  class115.addMenuEntry("Use", Client.field459 + " " + "->" + " " + class18.method199('\uffff') + var12.name, 1, var7, var8, var9);
               } else if(Client.field511) {
                  if((class31.field739 & 4) == 4) {
                     class115.addMenuEntry(Client.field463, Client.field380 + " " + "->" + " " + class18.method199('\uffff') + var12.name, 2, var7, var8, var9);
                  }
               } else {
                  String[] var13 = var12.actions;
                  if(Client.field476) {
                     var13 = class119.method2343(var13);
                  }

                  if(null != var13) {
                     for(int var14 = 4; var14 >= 0; --var14) {
                        if(null != var13[var14]) {
                           short var15 = 0;
                           if(var14 == 0) {
                              var15 = 3;
                           }

                           if(var14 == 1) {
                              var15 = 4;
                           }

                           if(var14 == 2) {
                              var15 = 5;
                           }

                           if(var14 == 3) {
                              var15 = 6;
                           }

                           if(var14 == 4) {
                              var15 = 1001;
                           }

                           class115.addMenuEntry(var13[var14], class18.method199('\uffff') + var12.name, var15, var7, var8, var9);
                        }
                     }
                  }

                  class115.addMenuEntry("Examine", class18.method199('\uffff') + var12.name, 1002, var12.field2900 << 14, var8, var9);
               }
            }

            Player var16;
            NPC var18;
            int var21;
            int var27;
            int[] var28;
            if(var10 == 1) {
               NPC var23 = Client.cachedNPCs[var11];
               if(var23 == null) {
                  continue;
               }

               if(var23.composition.field3010 == 1 && (var23.x & 127) == 64 && (var23.y & 127) == 64) {
                  for(var21 = 0; var21 < Client.field340; ++var21) {
                     var18 = Client.cachedNPCs[Client.field345[var21]];
                     if(null != var18 && var23 != var18 && var18.composition.field3010 == 1 && var18.x == var23.x && var23.y == var18.y) {
                        class8.method101(var18.composition, Client.field345[var21], var8, var9);
                     }
                  }

                  var21 = class45.field921;
                  var28 = class45.field931;

                  for(var27 = 0; var27 < var21; ++var27) {
                     var16 = Client.cachedPlayers[var28[var27]];
                     if(null != var16 && var23.x == var16.x && var23.y == var16.y) {
                        FaceNormal.method1956(var16, var28[var27], var8, var9);
                     }
                  }
               }

               class8.method101(var23.composition, var11, var8, var9);
            }

            if(var10 == 0) {
               Player var24 = Client.cachedPlayers[var11];
               if(var24 == null) {
                  continue;
               }

               if((var24.x & 127) == 64 && (var24.y & 127) == 64) {
                  for(var21 = 0; var21 < Client.field340; ++var21) {
                     var18 = Client.cachedNPCs[Client.field345[var21]];
                     if(var18 != null && var18.composition.field3010 == 1 && var18.x == var24.x && var18.y == var24.y) {
                        class8.method101(var18.composition, Client.field345[var21], var8, var9);
                     }
                  }

                  var21 = class45.field921;
                  var28 = class45.field931;

                  for(var27 = 0; var27 < var21; ++var27) {
                     var16 = Client.cachedPlayers[var28[var27]];
                     if(var16 != null && var24 != var16 && var16.x == var24.x && var16.y == var24.y) {
                        FaceNormal.method1956(var16, var28[var27], var8, var9);
                     }
                  }
               }

               if(var11 != Client.field434) {
                  FaceNormal.method1956(var24, var11, var8, var9);
               } else {
                  var4 = var7;
               }
            }

            if(var10 == 3) {
               Deque var25 = Client.groundItemDeque[WallObject.plane][var8][var9];
               if(null != var25) {
                  for(Item var26 = (Item)var25.method2471(); var26 != null; var26 = (Item)var25.method2461()) {
                     ItemComposition var29 = class103.getItemDefinition(var26.id);
                     if(Client.field458 == 1) {
                        class115.addMenuEntry("Use", Client.field459 + " " + "->" + " " + class18.method199(16748608) + var29.name, 16, var26.id, var8, var9);
                     } else if(Client.field511) {
                        if((class31.field739 & 1) == 1) {
                           class115.addMenuEntry(Client.field463, Client.field380 + " " + "->" + " " + class18.method199(16748608) + var29.name, 17, var26.id, var8, var9);
                        }
                     } else {
                        String[] var19 = var29.groundActions;
                        if(Client.field476) {
                           var19 = class119.method2343(var19);
                        }

                        for(int var20 = 4; var20 >= 0; --var20) {
                           if(null != var19 && var19[var20] != null) {
                              byte var17 = 0;
                              if(var20 == 0) {
                                 var17 = 18;
                              }

                              if(var20 == 1) {
                                 var17 = 19;
                              }

                              if(var20 == 2) {
                                 var17 = 20;
                              }

                              if(var20 == 3) {
                                 var17 = 21;
                              }

                              if(var20 == 4) {
                                 var17 = 22;
                              }

                              class115.addMenuEntry(var19[var20], class18.method199(16748608) + var29.name, var17, var26.id, var8, var9);
                           } else if(var20 == 2) {
                              class115.addMenuEntry("Take", class18.method199(16748608) + var29.name, 20, var26.id, var8, var9);
                           }
                        }

                        class115.addMenuEntry("Examine", class18.method199(16748608) + var29.name, 1004, var26.id, var8, var9);
                     }
                  }
               }
            }
         }
      }

      if(var4 != -1) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         Player var22 = Client.cachedPlayers[Client.field434];
         FaceNormal.method1956(var22, Client.field434, var6, var7);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "1301901249"
   )
   public static void method822(String var0, Throwable var1) {
      var1.printStackTrace();
   }
}
