import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
public class class217 {
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)I",
      garbageValue = "-2135111574"
   )
   static int method4119(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  throw new NumberFormatException();
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var10 + var5 * var1;
            if(var5 != var9 / var1) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-1731325811"
   )
   static final void method4120(Widget var0, int var1, int var2) {
      if(var0.field2645 == 1) {
         class176.addMenuEntry(var0.tooltip, "", 24, 0, 0, var0.id);
      }

      int var4;
      int var5;
      String var16;
      if(var0.field2645 == 2 && !Client.field1045) {
         var5 = class43.method626(var0);
         var4 = var5 >> 11 & 63;
         if(var4 == 0) {
            var16 = null;
         } else if(var0.field2721 != null && var0.field2721.trim().length() != 0) {
            var16 = var0.field2721;
         } else {
            var16 = null;
         }

         if(var16 != null) {
            class176.addMenuEntry(var16, class82.method1610('\uff00') + var0.field2750, 25, 0, -1, var0.id);
         }
      }

      if(var0.field2645 == 3) {
         class176.addMenuEntry("Close", "", 26, 0, 0, var0.id);
      }

      if(var0.field2645 == 4) {
         class176.addMenuEntry(var0.tooltip, "", 28, 0, 0, var0.id);
      }

      if(var0.field2645 == 5) {
         class176.addMenuEntry(var0.tooltip, "", 29, 0, 0, var0.id);
      }

      if(var0.field2645 == 6 && Client.field1054 == null) {
         class176.addMenuEntry(var0.tooltip, "", 30, 0, -1, var0.id);
      }

      int var3;
      int var6;
      if(var0.type == 2) {
         var3 = 0;

         for(var4 = 0; var4 < var0.height; ++var4) {
            for(var5 = 0; var5 < var0.width; ++var5) {
               var6 = (var0.paddingX + 32) * var5;
               int var7 = (var0.paddingY + 32) * var4;
               if(var3 < 20) {
                  var6 += var0.field2710[var3];
                  var7 += var0.field2711[var3];
               }

               if(var1 >= var6 && var2 >= var7 && var1 < var6 + 32 && var2 < var7 + 32) {
                  Client.field1006 = var3;
                  class61.field747 = var0;
                  if(var0.itemIds[var3] > 0) {
                     ItemComposition var8 = class51.getItemDefinition(var0.itemIds[var3] - 1);
                     if(Client.field1043 == 1 && class6.method16(class43.method626(var0))) {
                        if(var0.id != class214.field2622 || WorldMapType0.field612 != var3) {
                           class176.addMenuEntry("Use", Client.field1142 + " " + "->" + " " + class82.method1610(16748608) + var8.name, 31, var8.id, var3, var0.id);
                        }
                     } else if(Client.field1045 && class6.method16(class43.method626(var0))) {
                        if((class24.field364 & 16) == 16) {
                           class176.addMenuEntry(Client.field1048, Client.field1049 + " " + "->" + " " + class82.method1610(16748608) + var8.name, 32, var8.id, var3, var0.id);
                        }
                     } else {
                        String[] var9 = var8.inventoryActions;
                        if(Client.field994) {
                           var9 = class9.method37(var9);
                        }

                        int var10 = var8.method4679();
                        if(class6.method16(class43.method626(var0))) {
                           for(int var11 = 4; var11 >= 3; --var11) {
                              boolean var12 = var11 == var10;
                              if(var9 != null && var9[var11] != null) {
                                 byte var13;
                                 if(var11 == 3) {
                                    var13 = 36;
                                 } else {
                                    var13 = 37;
                                 }

                                 class31.method269(var9[var11], class82.method1610(16748608) + var8.name, var13, var8.id, var3, var0.id, var12);
                              } else if(var11 == 4) {
                                 class31.method269("Drop", class82.method1610(16748608) + var8.name, 37, var8.id, var3, var0.id, var12);
                              }
                           }
                        }

                        int var25 = class43.method626(var0);
                        boolean var24 = (var25 >> 31 & 1) != 0;
                        if(var24) {
                           class176.addMenuEntry("Use", class82.method1610(16748608) + var8.name, 38, var8.id, var3, var0.id);
                        }

                        Object var10000 = null;
                        int var26;
                        if(class6.method16(class43.method626(var0)) && var9 != null) {
                           for(var26 = 2; var26 >= 0; --var26) {
                              boolean var14 = var26 == var10;
                              if(var9[var26] != null) {
                                 byte var15 = 0;
                                 if(var26 == 0) {
                                    var15 = 33;
                                 }

                                 if(var26 == 1) {
                                    var15 = 34;
                                 }

                                 if(var26 == 2) {
                                    var15 = 35;
                                 }

                                 class31.method269(var9[var26], class82.method1610(16748608) + var8.name, var15, var8.id, var3, var0.id, var14);
                              }
                           }
                        }

                        var9 = var0.field2657;
                        if(Client.field994) {
                           var9 = class9.method37(var9);
                        }

                        if(var9 != null) {
                           for(var26 = 4; var26 >= 0; --var26) {
                              if(var9[var26] != null) {
                                 byte var27 = 0;
                                 if(var26 == 0) {
                                    var27 = 39;
                                 }

                                 if(var26 == 1) {
                                    var27 = 40;
                                 }

                                 if(var26 == 2) {
                                    var27 = 41;
                                 }

                                 if(var26 == 3) {
                                    var27 = 42;
                                 }

                                 if(var26 == 4) {
                                    var27 = 43;
                                 }

                                 class176.addMenuEntry(var9[var26], class82.method1610(16748608) + var8.name, var27, var8.id, var3, var0.id);
                              }
                           }
                        }

                        class176.addMenuEntry("Examine", class82.method1610(16748608) + var8.name, 1005, var8.id, var3, var0.id);
                     }
                  }
               }

               ++var3;
            }
         }
      }

      if(var0.hasScript) {
         if(Client.field1045) {
            if(XGrandExchangeOffer.method113(class43.method626(var0)) && (class24.field364 & 32) == 32) {
               class176.addMenuEntry(Client.field1048, Client.field1049 + " " + "->" + " " + var0.name, 58, 0, var0.index, var0.id);
            }
         } else {
            for(var3 = 9; var3 >= 5; --var3) {
               var6 = class43.method626(var0);
               boolean var22 = (var6 >> var3 + 1 & 1) != 0;
               String var17;
               if(!var22 && var0.field2634 == null) {
                  var17 = null;
               } else if(var0.actions != null && var0.actions.length > var3 && var0.actions[var3] != null && var0.actions[var3].trim().length() != 0) {
                  var17 = var0.actions[var3];
               } else {
                  var17 = null;
               }

               if(var17 != null) {
                  class176.addMenuEntry(var17, var0.name, 1007, var3 + 1, var0.index, var0.id);
               }
            }

            var5 = class43.method626(var0);
            var4 = var5 >> 11 & 63;
            if(var4 == 0) {
               var16 = null;
            } else if(var0.field2721 != null && var0.field2721.trim().length() != 0) {
               var16 = var0.field2721;
            } else {
               var16 = null;
            }

            if(var16 != null) {
               class176.addMenuEntry(var16, var0.name, 25, 0, var0.index, var0.id);
            }

            for(var5 = 4; var5 >= 0; --var5) {
               int var18 = class43.method626(var0);
               boolean var23 = (var18 >> var5 + 1 & 1) != 0;
               String var21;
               if(!var23 && var0.field2634 == null) {
                  var21 = null;
               } else if(var0.actions != null && var0.actions.length > var5 && var0.actions[var5] != null && var0.actions[var5].trim().length() != 0) {
                  var21 = var0.actions[var5];
               } else {
                  var21 = null;
               }

               if(var21 != null) {
                  class176.addMenuEntry(var21, var0.name, 57, var5 + 1, var0.index, var0.id);
               }
            }

            if(class152.method2965(class43.method626(var0))) {
               class176.addMenuEntry("Continue", "", 30, 0, var0.index, var0.id);
            }
         }
      }

   }
}
