import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -211848113
   )
   @Export("x")
   int x;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1920855319
   )
   public static int field2020;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2077438991
   )
   @Export("z")
   int z;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -549588303
   )
   @Export("magnitude")
   int magnitude;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1872529687
   )
   @Export("y")
   int y;

   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }

   VertexNormal() {
   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "338750002"
   )
   static final void method2587(Widget var0, int var1, int var2) {
      if(var0.field2654 == 1) {
         class3.addMenuEntry(var0.tooltip, "", 24, 0, 0, var0.id);
      }

      String var3;
      int var5;
      int var19;
      if(var0.field2654 == 2 && !Client.field1085) {
         var5 = class210.method3903(var0);
         var19 = var5 >> 11 & 63;
         if(var19 == 0) {
            var3 = null;
         } else if(var0.field2730 != null && var0.field2730.trim().length() != 0) {
            var3 = var0.field2730;
         } else {
            var3 = null;
         }

         if(var3 != null) {
            class3.addMenuEntry(var3, WorldMapData.method337('\uff00') + var0.field2767, 25, 0, -1, var0.id);
         }
      }

      if(var0.field2654 == 3) {
         class3.addMenuEntry("Close", "", 26, 0, 0, var0.id);
      }

      if(var0.field2654 == 4) {
         class3.addMenuEntry(var0.tooltip, "", 28, 0, 0, var0.id);
      }

      if(var0.field2654 == 5) {
         class3.addMenuEntry(var0.tooltip, "", 29, 0, 0, var0.id);
      }

      if(var0.field2654 == 6 && Client.field963 == null) {
         class3.addMenuEntry(var0.tooltip, "", 30, 0, -1, var0.id);
      }

      int var18;
      if(var0.type == 2) {
         var18 = 0;

         for(var19 = 0; var19 < var0.height; ++var19) {
            for(var5 = 0; var5 < var0.width; ++var5) {
               int var6 = var5 * (var0.paddingX + 32);
               int var7 = (var0.paddingY + 32) * var19;
               if(var18 < 20) {
                  var6 += var0.field2719[var18];
                  var7 += var0.field2720[var18];
               }

               if(var1 >= var6 && var2 >= var7 && var1 < var6 + 32 && var2 < var7 + 32) {
                  Client.field940 = var18;
                  Ignore.field866 = var0;
                  if(var0.itemIds[var18] > 0) {
                     ItemComposition var8 = Buffer.getItemDefinition(var0.itemIds[var18] - 1);
                     if(Client.field1083 == 1 && GameObject.method2898(class210.method3903(var0))) {
                        if(var0.id != GameObject.field2212 || var18 != IndexFile.field2303) {
                           class3.addMenuEntry("Use", Client.field1084 + " " + "->" + " " + WorldMapData.method337(16748608) + var8.name, 31, var8.id, var18, var0.id);
                        }
                     } else {
                        label418: {
                           int var10;
                           if(Client.field1085) {
                              var10 = class210.method3903(var0);
                              boolean var9 = (var10 >> 30 & 1) != 0;
                              if(var9) {
                                 if((class64.field808 & 16) == 16) {
                                    class3.addMenuEntry(Client.field1088, Client.field1089 + " " + "->" + " " + WorldMapData.method337(16748608) + var8.name, 32, var8.id, var18, var0.id);
                                 }
                                 break label418;
                              }
                           }

                           String[] var20 = var8.inventoryActions;
                           if(Client.field1101) {
                              var20 = Actor.method1518(var20);
                           }

                           var10 = var8.method4616();
                           int var12 = class210.method3903(var0);
                           boolean var11 = (var12 >> 30 & 1) != 0;
                           if(var11) {
                              for(int var13 = 4; var13 >= 3; --var13) {
                                 boolean var14 = var13 == var10;
                                 if(var20 != null && var20[var13] != null) {
                                    byte var15;
                                    if(var13 == 3) {
                                       var15 = 36;
                                    } else {
                                       var15 = 37;
                                    }

                                    class203.method3666(var20[var13], WorldMapData.method337(16748608) + var8.name, var15, var8.id, var18, var0.id, var14);
                                 } else if(var13 == 4) {
                                    class203.method3666("Drop", WorldMapData.method337(16748608) + var8.name, 37, var8.id, var18, var0.id, var14);
                                 }
                              }
                           }

                           Object var10000 = null;
                           if(class84.method1670(class210.method3903(var0))) {
                              class3.addMenuEntry("Use", WorldMapData.method337(16748608) + var8.name, 38, var8.id, var18, var0.id);
                           }

                           int var23 = class210.method3903(var0);
                           boolean var22 = (var23 >> 30 & 1) != 0;
                           int var24;
                           if(var22 && var20 != null) {
                              for(var24 = 2; var24 >= 0; --var24) {
                                 boolean var16 = var10 == var24;
                                 if(var20[var24] != null) {
                                    byte var17 = 0;
                                    if(var24 == 0) {
                                       var17 = 33;
                                    }

                                    if(var24 == 1) {
                                       var17 = 34;
                                    }

                                    if(var24 == 2) {
                                       var17 = 35;
                                    }

                                    class203.method3666(var20[var24], WorldMapData.method337(16748608) + var8.name, var17, var8.id, var18, var0.id, var16);
                                 }
                              }
                           }

                           var20 = var0.field2778;
                           if(Client.field1101) {
                              var20 = Actor.method1518(var20);
                           }

                           if(var20 != null) {
                              for(var24 = 4; var24 >= 0; --var24) {
                                 if(var20[var24] != null) {
                                    byte var25 = 0;
                                    if(var24 == 0) {
                                       var25 = 39;
                                    }

                                    if(var24 == 1) {
                                       var25 = 40;
                                    }

                                    if(var24 == 2) {
                                       var25 = 41;
                                    }

                                    if(var24 == 3) {
                                       var25 = 42;
                                    }

                                    if(var24 == 4) {
                                       var25 = 43;
                                    }

                                    class3.addMenuEntry(var20[var24], WorldMapData.method337(16748608) + var8.name, var25, var8.id, var18, var0.id);
                                 }
                              }
                           }

                           class3.addMenuEntry("Examine", WorldMapData.method337(16748608) + var8.name, 1005, var8.id, var18, var0.id);
                        }
                     }
                  }
               }

               ++var18;
            }
         }
      }

      if(var0.hasScript) {
         if(Client.field1085) {
            if(class34.method362(class210.method3903(var0)) && (class64.field808 & 32) == 32) {
               class3.addMenuEntry(Client.field1088, Client.field1089 + " " + "->" + " " + var0.name, 58, 0, var0.index, var0.id);
            }
         } else {
            for(var18 = 9; var18 >= 5; --var18) {
               String var4 = TextureProvider.method2385(var0, var18);
               if(var4 != null) {
                  class3.addMenuEntry(var4, var0.name, 1007, var18 + 1, var0.index, var0.id);
               }
            }

            var5 = class210.method3903(var0);
            var19 = var5 >> 11 & 63;
            if(var19 == 0) {
               var3 = null;
            } else if(var0.field2730 != null && var0.field2730.trim().length() != 0) {
               var3 = var0.field2730;
            } else {
               var3 = null;
            }

            if(var3 != null) {
               class3.addMenuEntry(var3, var0.name, 25, 0, var0.index, var0.id);
            }

            for(var5 = 4; var5 >= 0; --var5) {
               String var21 = TextureProvider.method2385(var0, var5);
               if(var21 != null) {
                  class3.addMenuEntry(var21, var0.name, 57, var5 + 1, var0.index, var0.id);
               }
            }

            if(class249.method4417(class210.method3903(var0))) {
               class3.addMenuEntry("Continue", "", 30, 0, var0.index, var0.id);
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-66"
   )
   public static void method2588() {
      Widget.field2663.reset();
      Widget.field2646.reset();
      Widget.field2647.reset();
      Widget.field2666.reset();
   }
}
