import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
public final class class132 {
   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-1921865828"
   )
   static final void method2840(Widget var0, int var1, int var2) {
      if(var0.field2840 == 1) {
         Player.addMenuEntry(var0.tooltip, "", 24, 0, 0, var0.id);
      }

      String var3;
      if(var0.field2840 == 2 && !Client.field434) {
         if(class175.method3438(class93.method2130(var0)) == 0) {
            var3 = null;
         } else if(var0.field2897 != null && var0.field2897.trim().length() != 0) {
            var3 = var0.field2897;
         } else {
            var3 = null;
         }

         if(null != var3) {
            Player.addMenuEntry(var3, class92.method2126('\uff00') + var0.field2904, 25, 0, -1, var0.id);
         }
      }

      if(var0.field2840 == 3) {
         Player.addMenuEntry("Close", "", 26, 0, 0, var0.id);
      }

      if(var0.field2840 == 4) {
         Player.addMenuEntry(var0.tooltip, "", 28, 0, 0, var0.id);
      }

      if(var0.field2840 == 5) {
         Player.addMenuEntry(var0.tooltip, "", 29, 0, 0, var0.id);
      }

      if(var0.field2840 == 6 && Client.field443 == null) {
         Player.addMenuEntry(var0.tooltip, "", 30, 0, -1, var0.id);
      }

      int var5;
      int var6;
      int var12;
      int var13;
      if(var0.type == 2) {
         var12 = 0;

         for(var13 = 0; var13 < var0.height; ++var13) {
            for(var5 = 0; var5 < var0.width; ++var5) {
               var6 = (32 + var0.field2825) * var5;
               int var7 = var13 * (32 + var0.field2922);
               if(var12 < 20) {
                  var6 += var0.field2856[var12];
                  var7 += var0.field2857[var12];
               }

               if(var1 >= var6 && var2 >= var7 && var1 < var6 + 32 && var2 < 32 + var7) {
                  Client.field398 = var12;
                  NPC.field787 = var0;
                  if(var0.itemIds[var12] > 0) {
                     ItemComposition var8 = class45.getItemDefinition(var0.itemIds[var12] - 1);
                     if(Client.field432 == 1 && Client.method557(class93.method2130(var0))) {
                        if(class62.field1263 != var0.id || var12 != class52.field1128) {
                           Player.addMenuEntry("Use", Client.field433 + " " + "->" + " " + class92.method2126(16748608) + var8.name, 31, var8.id, var12, var0.id);
                        }
                     } else if(Client.field434 && Client.method557(class93.method2130(var0))) {
                        if((class221.field3210 & 16) == 16) {
                           Player.addMenuEntry(Client.field492, Client.field438 + " " + "->" + " " + class92.method2126(16748608) + var8.name, 32, var8.id, var12, var0.id);
                        }
                     } else {
                        String[] var9 = var8.inventoryActions;
                        if(Client.field450) {
                           var9 = class8.method111(var9);
                        }

                        int var10;
                        byte var11;
                        if(Client.method557(class93.method2130(var0))) {
                           for(var10 = 4; var10 >= 3; --var10) {
                              if(null != var9 && var9[var10] != null) {
                                 if(var10 == 3) {
                                    var11 = 36;
                                 } else {
                                    var11 = 37;
                                 }

                                 Player.addMenuEntry(var9[var10], class92.method2126(16748608) + var8.name, var11, var8.id, var12, var0.id);
                              } else if(var10 == 4) {
                                 Player.addMenuEntry("Drop", class92.method2126(16748608) + var8.name, 37, var8.id, var12, var0.id);
                              }
                           }
                        }

                        if(class14.method163(class93.method2130(var0))) {
                           Player.addMenuEntry("Use", class92.method2126(16748608) + var8.name, 38, var8.id, var12, var0.id);
                        }

                        if(Client.method557(class93.method2130(var0)) && null != var9) {
                           for(var10 = 2; var10 >= 0; --var10) {
                              if(null != var9[var10]) {
                                 var11 = 0;
                                 if(var10 == 0) {
                                    var11 = 33;
                                 }

                                 if(var10 == 1) {
                                    var11 = 34;
                                 }

                                 if(var10 == 2) {
                                    var11 = 35;
                                 }

                                 Player.addMenuEntry(var9[var10], class92.method2126(16748608) + var8.name, var11, var8.id, var12, var0.id);
                              }
                           }
                        }

                        var9 = var0.field2859;
                        if(Client.field450) {
                           var9 = class8.method111(var9);
                        }

                        if(var9 != null) {
                           for(var10 = 4; var10 >= 0; --var10) {
                              if(var9[var10] != null) {
                                 var11 = 0;
                                 if(var10 == 0) {
                                    var11 = 39;
                                 }

                                 if(var10 == 1) {
                                    var11 = 40;
                                 }

                                 if(var10 == 2) {
                                    var11 = 41;
                                 }

                                 if(var10 == 3) {
                                    var11 = 42;
                                 }

                                 if(var10 == 4) {
                                    var11 = 43;
                                 }

                                 Player.addMenuEntry(var9[var10], class92.method2126(16748608) + var8.name, var11, var8.id, var12, var0.id);
                              }
                           }
                        }

                        Player.addMenuEntry("Examine", class92.method2126(16748608) + var8.name, 1005, var8.id, var12, var0.id);
                     }
                  }
               }

               ++var12;
            }
         }
      }

      if(var0.field2787) {
         if(Client.field434) {
            var13 = class93.method2130(var0);
            boolean var20 = (var13 >> 21 & 1) != 0;
            if(var20 && (class221.field3210 & 32) == 32) {
               Player.addMenuEntry(Client.field492, Client.field438 + " " + "->" + " " + var0.name, 58, 0, var0.index, var0.id);
            }
         } else {
            for(var12 = 9; var12 >= 5; --var12) {
               var6 = class93.method2130(var0);
               boolean var18 = (var6 >> var12 + 1 & 1) != 0;
               String var4;
               if(!var18 && null == var0.field2888) {
                  var4 = null;
               } else if(var0.actions != null && var0.actions.length > var12 && null != var0.actions[var12] && var0.actions[var12].trim().length() != 0) {
                  var4 = var0.actions[var12];
               } else {
                  var4 = null;
               }

               if(null != var4) {
                  Player.addMenuEntry(var4, var0.name, 1007, var12 + 1, var0.index, var0.id);
               }
            }

            if(class175.method3438(class93.method2130(var0)) == 0) {
               var3 = null;
            } else if(null != var0.field2897 && var0.field2897.trim().length() != 0) {
               var3 = var0.field2897;
            } else {
               var3 = null;
            }

            if(var3 != null) {
               Player.addMenuEntry(var3, var0.name, 25, 0, var0.index, var0.id);
            }

            for(var5 = 4; var5 >= 0; --var5) {
               int var16 = class93.method2130(var0);
               boolean var19 = (var16 >> var5 + 1 & 1) != 0;
               String var14;
               if(!var19 && var0.field2888 == null) {
                  var14 = null;
               } else if(var0.actions != null && var0.actions.length > var5 && var0.actions[var5] != null && var0.actions[var5].trim().length() != 0) {
                  var14 = var0.actions[var5];
               } else {
                  var14 = null;
               }

               if(var14 != null) {
                  Player.addMenuEntry(var14, var0.name, 57, var5 + 1, var0.index, var0.id);
               }
            }

            if(class11.method136(class93.method2130(var0))) {
               Player.addMenuEntry("Continue", "", 30, 0, var0.index, var0.id);
            }
         }
      }

   }
}
