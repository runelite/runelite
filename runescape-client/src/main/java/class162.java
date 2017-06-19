import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public class class162 {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -19415391
   )
   static int field2310;
   @ObfuscatedName("t")
   static int[][] field2311;
   @ObfuscatedName("e")
   static int[][] field2314;
   @ObfuscatedName("i")
   static int[] field2315;
   @ObfuscatedName("f")
   static int[] field2316;

   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-1433074674"
   )
   static final void method2943(Widget var0, int var1, int var2) {
      if(var0.field2769 == 1) {
         class44.addMenuEntry(var0.tooltip, "", 24, 0, 0, var0.id);
      }

      String var3;
      if(var0.field2769 == 2 && !Client.field1061) {
         if(WorldMapType1.method263(class15.method92(var0)) == 0) {
            var3 = null;
         } else if(var0.selectedAction != null && var0.selectedAction.trim().length() != 0) {
            var3 = var0.selectedAction;
         } else {
            var3 = null;
         }

         if(var3 != null) {
            class44.addMenuEntry(var3, class15.method105('\uff00') + var0.field2741, 25, 0, -1, var0.id);
         }
      }

      if(var0.field2769 == 3) {
         class44.addMenuEntry("Close", "", 26, 0, 0, var0.id);
      }

      if(var0.field2769 == 4) {
         class44.addMenuEntry(var0.tooltip, "", 28, 0, 0, var0.id);
      }

      if(var0.field2769 == 5) {
         class44.addMenuEntry(var0.tooltip, "", 29, 0, 0, var0.id);
      }

      if(var0.field2769 == 6 && Client.field1070 == null) {
         class44.addMenuEntry(var0.tooltip, "", 30, 0, -1, var0.id);
      }

      int var4;
      int var5;
      int var6;
      if(var0.type == 2) {
         var6 = 0;

         for(int var7 = 0; var7 < var0.height; ++var7) {
            for(var4 = 0; var4 < var0.width; ++var4) {
               var5 = (var0.paddingX + 32) * var4;
               int var8 = (var0.paddingY + 32) * var7;
               if(var6 < 20) {
                  var5 += var0.field2722[var6];
                  var8 += var0.field2723[var6];
               }

               if(var1 >= var5 && var2 >= var8 && var1 < var5 + 32 && var2 < var8 + 32) {
                  Client.field1022 = var6;
                  Projectile.field1475 = var0;
                  if(var0.itemIds[var6] > 0) {
                     ItemComposition var9 = class224.getItemDefinition(var0.itemIds[var6] - 1);
                     if(Client.itemSelectionState == 1 && WorldMapType2.method497(class15.method92(var0))) {
                        if(var0.id != class33.field480 || class91.selectedItemIndex != var6) {
                           class44.addMenuEntry("Use", Client.selectedItemName + " -> " + class15.method105(16748608) + var9.name, 31, var9.id, var6, var0.id);
                        }
                     } else if(Client.field1061 && WorldMapType2.method497(class15.method92(var0))) {
                        if((class232.spellTargetFlags & 16) == 16) {
                           class44.addMenuEntry(Client.field1064, Client.field1065 + " -> " + class15.method105(16748608) + var9.name, 32, var9.id, var6, var0.id);
                        }
                     } else {
                        String[] var10 = var9.inventoryActions;
                        if(Client.field1077) {
                           var10 = class2.method7(var10);
                        }

                        int var11 = var9.method4479();
                        int var12;
                        boolean var13;
                        byte var14;
                        if(WorldMapType2.method497(class15.method92(var0))) {
                           for(var12 = 4; var12 >= 3; --var12) {
                              var13 = var11 == var12;
                              if(var10 != null && var10[var12] != null) {
                                 if(var12 == 3) {
                                    var14 = 36;
                                 } else {
                                    var14 = 37;
                                 }

                                 class87.method1599(var10[var12], class15.method105(16748608) + var9.name, var14, var9.id, var6, var0.id, var13);
                              } else if(var12 == 4) {
                                 class87.method1599("Drop", class15.method105(16748608) + var9.name, 37, var9.id, var6, var0.id, var13);
                              }
                           }
                        }

                        if(class19.method160(class15.method92(var0))) {
                           class44.addMenuEntry("Use", class15.method105(16748608) + var9.name, 38, var9.id, var6, var0.id);
                        }

                        if(WorldMapType2.method497(class15.method92(var0)) && var10 != null) {
                           for(var12 = 2; var12 >= 0; --var12) {
                              var13 = var11 == var12;
                              if(var10[var12] != null) {
                                 var14 = 0;
                                 if(var12 == 0) {
                                    var14 = 33;
                                 }

                                 if(var12 == 1) {
                                    var14 = 34;
                                 }

                                 if(var12 == 2) {
                                    var14 = 35;
                                 }

                                 class87.method1599(var10[var12], class15.method105(16748608) + var9.name, var14, var9.id, var6, var0.id, var13);
                              }
                           }
                        }

                        var10 = var0.field2725;
                        if(Client.field1077) {
                           var10 = class2.method7(var10);
                        }

                        if(var10 != null) {
                           for(var12 = 4; var12 >= 0; --var12) {
                              if(var10[var12] != null) {
                                 byte var15 = 0;
                                 if(var12 == 0) {
                                    var15 = 39;
                                 }

                                 if(var12 == 1) {
                                    var15 = 40;
                                 }

                                 if(var12 == 2) {
                                    var15 = 41;
                                 }

                                 if(var12 == 3) {
                                    var15 = 42;
                                 }

                                 if(var12 == 4) {
                                    var15 = 43;
                                 }

                                 class44.addMenuEntry(var10[var12], class15.method105(16748608) + var9.name, var15, var9.id, var6, var0.id);
                              }
                           }
                        }

                        class44.addMenuEntry("Examine", class15.method105(16748608) + var9.name, 1005, var9.id, var6, var0.id);
                     }
                  }
               }

               ++var6;
            }
         }
      }

      if(var0.hasScript) {
         if(Client.field1061) {
            if(class215.method3878(class15.method92(var0)) && (class232.spellTargetFlags & 32) == 32) {
               class44.addMenuEntry(Client.field1064, Client.field1065 + " -> " + var0.name, 58, 0, var0.index, var0.id);
            }
         } else {
            boolean var16;
            String var17;
            for(var6 = 9; var6 >= 5; --var6) {
               var5 = class15.method92(var0);
               var16 = (var5 >> var6 + 1 & 1) != 0;
               if(!var16 && var0.field2657 == null) {
                  var17 = null;
               } else if(var0.actions != null && var0.actions.length > var6 && var0.actions[var6] != null && var0.actions[var6].trim().length() != 0) {
                  var17 = var0.actions[var6];
               } else {
                  var17 = null;
               }

               if(var17 != null) {
                  class44.addMenuEntry(var17, var0.name, 1007, var6 + 1, var0.index, var0.id);
               }
            }

            if(WorldMapType1.method263(class15.method92(var0)) == 0) {
               var3 = null;
            } else if(var0.selectedAction != null && var0.selectedAction.trim().length() != 0) {
               var3 = var0.selectedAction;
            } else {
               var3 = null;
            }

            if(var3 != null) {
               class44.addMenuEntry(var3, var0.name, 25, 0, var0.index, var0.id);
            }

            for(var4 = 4; var4 >= 0; --var4) {
               var17 = class8.method40(var0, var4);
               if(var17 != null) {
                  class44.addMenuEntry(var17, var0.name, 57, var4 + 1, var0.index, var0.id);
               }
            }

            var5 = class15.method92(var0);
            var16 = (var5 & 1) != 0;
            if(var16) {
               class44.addMenuEntry("Continue", "", 30, 0, var0.index, var0.id);
            }
         }
      }

   }

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)Z",
      garbageValue = "-80"
   )
   static boolean method2946(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = class109.method1965(var0, class33.field482);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(class109.method1965(Client.friends[var3].name, class33.field482)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class109.method1965(class20.localPlayer.name, class33.field482))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)Ljava/lang/String;",
      garbageValue = "1044747361"
   )
   public static String method2947(Buffer var0, int var1) {
      try {
         int var2 = var0.method3046();
         if(var2 > var1) {
            var2 = var1;
         }

         byte[] var3 = new byte[var2];
         var0.offset += class265.field3660.method2962(var0.payload, var0.offset, var3, 0, var2);
         String var4 = class22.method181(var3, 0, var2);
         return var4;
      } catch (Exception var5) {
         return "Cabbage";
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "829676645"
   )
   public static int method2948(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0 - (var3 - 1):7 - var1 - (var4 - 1)));
   }

   static {
      field2314 = new int[128][128];
      field2311 = new int[128][128];
      field2315 = new int[4096];
      field2316 = new int[4096];
   }
}
