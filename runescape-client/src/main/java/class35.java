import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class35 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lad;"
   )
   static final class35 field472;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lad;"
   )
   static final class35 field469;
   @ObfuscatedName("kw")
   @ObfuscatedGetter(
      intValue = 373714133
   )
   @Export("selectedItemIndex")
   static int selectedItemIndex;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = 373936747
   )
   static int field474;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1645019887
   )
   final int field470;

   static {
      field472 = new class35(0);
      field469 = new class35(1);
   }

   class35(int var1) {
      this.field470 = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-76"
   )
   public static void method499() {
      CombatInfo2.field3346.reset();
      CombatInfo2.spriteCache.reset();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lim;Lim;B)V",
      garbageValue = "1"
   )
   public static void method498(IndexDataBase var0, IndexDataBase var1) {
      KitDefinition.identKit_ref = var0;
      KitDefinition.field3335 = var1;
      KitDefinition.field3331 = KitDefinition.identKit_ref.fileCount(3);
   }

   @ObfuscatedName("ja")
   @ObfuscatedSignature(
      signature = "(IIIILji;Lhr;I)V",
      garbageValue = "-167086847"
   )
   @Export("drawDot")
   static final void drawDot(int var0, int var1, int var2, int var3, SpritePixels var4, class210 var5) {
      if(var4 != null) {
         int var6 = Client.mapAngle & 2047;
         int var7 = var2 * var2 + var3 * var3;
         if(var7 <= 6400) {
            int var8 = Graphics3D.SINE[var6];
            int var9 = Graphics3D.COSINE[var6];
            int var10 = var9 * var2 + var3 * var8 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method5079(var10 + var5.field2580 / 2 - var4.maxWidth / 2, var5.field2581 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2580, var5.field2581, var5.field2578, var5.field2579);
            } else {
               var4.method5069(var0 + var10 + var5.field2580 / 2 - var4.maxWidth / 2, var5.field2581 / 2 + var1 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lfw;IIIIIIB)V",
      garbageValue = "58"
   )
   @Export("loadTerrain")
   static final void loadTerrain(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class62.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  class62.tileHeights[0][var2][var3] = -class182.method3479(var2 + var4 + 932731, var3 + var5 + 556238) * 8;
               } else {
                  class62.tileHeights[var1][var2][var3] = class62.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var8 = var0.readUnsignedByte();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(var1 == 0) {
                  class62.tileHeights[0][var2][var3] = -var8 * 8;
               } else {
                  class62.tileHeights[var1][var2][var3] = class62.tileHeights[var1 - 1][var2][var3] - var8 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class62.overlayIds[var1][var2][var3] = var0.readByte();
               FileSystem.overlayPaths[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class62.overlayRotations[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class62.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class62.underlayIds[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.readUnsignedByte();
               break;
            }

            if(var7 <= 49) {
               var0.readUnsignedByte();
            }
         }
      }

   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "(Lhn;III)V",
      garbageValue = "-1959098581"
   )
   static final void method497(Widget var0, int var1, int var2) {
      if(var0.field2632 == 1) {
         class164.addMenuEntry(var0.tooltip, "", 24, 0, 0, var0.id);
      }

      String var3;
      if(var0.field2632 == 2 && !Client.spellSelected) {
         var3 = KeyFocusListener.method760(var0);
         if(var3 != null) {
            class164.addMenuEntry(var3, CacheFile.getColTags('\uff00') + var0.field2621, 25, 0, -1, var0.id);
         }
      }

      if(var0.field2632 == 3) {
         class164.addMenuEntry("Close", "", 26, 0, 0, var0.id);
      }

      if(var0.field2632 == 4) {
         class164.addMenuEntry(var0.tooltip, "", 28, 0, 0, var0.id);
      }

      if(var0.field2632 == 5) {
         class164.addMenuEntry(var0.tooltip, "", 29, 0, 0, var0.id);
      }

      if(var0.field2632 == 6 && Client.field895 == null) {
         class164.addMenuEntry(var0.tooltip, "", 30, 0, -1, var0.id);
      }

      int var4;
      int var5;
      int var17;
      if(var0.type == 2) {
         var17 = 0;

         for(var4 = 0; var4 < var0.height; ++var4) {
            for(var5 = 0; var5 < var0.width; ++var5) {
               int var6 = (var0.paddingX + 32) * var5;
               int var7 = (var0.paddingY + 32) * var4;
               if(var17 < 20) {
                  var6 += var0.xSprites[var17];
                  var7 += var0.field2698[var17];
               }

               if(var1 >= var6 && var2 >= var7 && var1 < var6 + 32 && var2 < var7 + 32) {
                  Client.field999 = var17;
                  class47.field564 = var0;
                  if(var0.itemIds[var17] > 0) {
                     label320: {
                        ItemComposition var8 = Friend.getItemDefinition(var0.itemIds[var17] - 1);
                        boolean var9;
                        int var10;
                        if(Client.itemSelectionState == 1) {
                           var10 = class169.getWidgetConfig(var0);
                           var9 = (var10 >> 30 & 1) != 0;
                           if(var9) {
                              if(var0.id != class44.field548 || var17 != selectedItemIndex) {
                                 class164.addMenuEntry("Use", Client.field1037 + " " + "->" + " " + CacheFile.getColTags(16748608) + var8.name, 31, var8.id, var17, var0.id);
                              }
                              break label320;
                           }
                        }

                        if(Client.spellSelected) {
                           var10 = class169.getWidgetConfig(var0);
                           var9 = (var10 >> 30 & 1) != 0;
                           if(var9) {
                              if((class96.field1481 & 16) == 16) {
                                 class164.addMenuEntry(Client.field972, Client.field1042 + " " + "->" + " " + CacheFile.getColTags(16748608) + var8.name, 32, var8.id, var17, var0.id);
                              }
                              break label320;
                           }
                        }

                        String[] var18 = var8.inventoryActions;
                        if(Client.field969) {
                           var18 = FileOnDisk.method1920(var18);
                        }

                        var10 = -1;
                        if(Client.field1031 && KeyFocusListener.field604[81]) {
                           var10 = var8.method4595();
                        }

                        int var12 = class169.getWidgetConfig(var0);
                        boolean var11 = (var12 >> 30 & 1) != 0;
                        if(var11) {
                           for(int var13 = 4; var13 >= 3; --var13) {
                              if(var10 != var13) {
                                 class223.method4086(var0, var8, var17, var13, false);
                              }
                           }
                        }

                        Object var10000 = null;
                        if(class149.method2928(class169.getWidgetConfig(var0))) {
                           class164.addMenuEntry("Use", CacheFile.getColTags(16748608) + var8.name, 38, var8.id, var17, var0.id);
                        }

                        int var14 = class169.getWidgetConfig(var0);
                        boolean var22 = (var14 >> 30 & 1) != 0;
                        int var15;
                        if(var22) {
                           for(var15 = 2; var15 >= 0; --var15) {
                              if(var10 != var15) {
                                 class223.method4086(var0, var8, var17, var15, false);
                              }
                           }

                           if(var10 >= 0) {
                              class223.method4086(var0, var8, var17, var10, true);
                           }
                        }

                        var18 = var0.configActions;
                        if(Client.field969) {
                           var18 = FileOnDisk.method1920(var18);
                        }

                        if(var18 != null) {
                           for(var15 = 4; var15 >= 0; --var15) {
                              if(var18[var15] != null) {
                                 byte var16 = 0;
                                 if(var15 == 0) {
                                    var16 = 39;
                                 }

                                 if(var15 == 1) {
                                    var16 = 40;
                                 }

                                 if(var15 == 2) {
                                    var16 = 41;
                                 }

                                 if(var15 == 3) {
                                    var16 = 42;
                                 }

                                 if(var15 == 4) {
                                    var16 = 43;
                                 }

                                 class164.addMenuEntry(var18[var15], CacheFile.getColTags(16748608) + var8.name, var16, var8.id, var17, var0.id);
                              }
                           }
                        }

                        class164.addMenuEntry("Examine", CacheFile.getColTags(16748608) + var8.name, 1005, var8.id, var17, var0.id);
                     }
                  }
               }

               ++var17;
            }
         }
      }

      if(var0.hasScript) {
         if(Client.spellSelected) {
            if(class36.method500(class169.getWidgetConfig(var0)) && (class96.field1481 & 32) == 32) {
               class164.addMenuEntry(Client.field972, Client.field1042 + " " + "->" + " " + var0.name, 58, 0, var0.index, var0.id);
            }
         } else {
            for(var17 = 9; var17 >= 5; --var17) {
               String var19 = class220.method4075(var0, var17);
               if(var19 != null) {
                  class164.addMenuEntry(var19, var0.name, 1007, var17 + 1, var0.index, var0.id);
               }
            }

            var3 = KeyFocusListener.method760(var0);
            if(var3 != null) {
               class164.addMenuEntry(var3, var0.name, 25, 0, var0.index, var0.id);
            }

            for(var4 = 4; var4 >= 0; --var4) {
               String var20 = class220.method4075(var0, var4);
               if(var20 != null) {
                  class164.addMenuEntry(var20, var0.name, 57, var4 + 1, var0.index, var0.id);
               }
            }

            var5 = class169.getWidgetConfig(var0);
            boolean var21 = (var5 & 1) != 0;
            if(var21) {
               class164.addMenuEntry("Continue", "", 30, 0, var0.index, var0.id);
            }
         }
      }

   }
}
