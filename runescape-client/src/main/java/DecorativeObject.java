import java.awt.datatransfer.Clipboard;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 787447363
   )
   @Export("x")
   int x;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -815349913
   )
   int field1592;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -807049701
   )
   int field1593;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1333444161
   )
   int field1594;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1233359617
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -485670729
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("g")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 387360113
   )
   @Export("y")
   int y;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1179248533
   )
   int field1599 = 0;
   @ObfuscatedName("pu")
   static Clipboard field1600;
   @ObfuscatedName("p")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -2103311197
   )
   int field1602;
   @ObfuscatedName("gv")
   static Widget field1603;

   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "1786633892"
   )
   static final void method1950(Widget var0, int var1, int var2) {
      if(var0.field2072 == 1) {
         class166.addMenuEntry(var0.tooltip, "", 24, 0, 0, var0.id);
      }

      String var14;
      if(var0.field2072 == 2 && !Client.field440) {
         if(class63.method1151(class185.method3463(var0)) == 0) {
            var14 = null;
         } else if(var0.field2148 != null && var0.field2148.trim().length() != 0) {
            var14 = var0.field2148;
         } else {
            var14 = null;
         }

         if(var14 != null) {
            class166.addMenuEntry(var14, class13.method182('\uff00') + var0.field2133, 25, 0, -1, var0.id);
         }
      }

      if(var0.field2072 == 3) {
         class166.addMenuEntry("Close", "", 26, 0, 0, var0.id);
      }

      if(var0.field2072 == 4) {
         class166.addMenuEntry(var0.tooltip, "", 28, 0, 0, var0.id);
      }

      if(var0.field2072 == 5) {
         class166.addMenuEntry(var0.tooltip, "", 29, 0, 0, var0.id);
      }

      if(var0.field2072 == 6 && Client.field449 == null) {
         class166.addMenuEntry(var0.tooltip, "", 30, 0, -1, var0.id);
      }

      int var3;
      int var5;
      int var6;
      if(var0.type == 2) {
         var3 = 0;

         for(int var15 = 0; var15 < var0.height; ++var15) {
            for(var5 = 0; var5 < var0.width; ++var5) {
               var6 = var5 * (32 + var0.field2135);
               int var7 = (var0.field2136 + 32) * var15;
               if(var3 < 20) {
                  var6 += var0.field2137[var3];
                  var7 += var0.field2129[var3];
               }

               if(var1 >= var6 && var2 >= var7 && var1 < var6 + 32 && var2 < var7 + 32) {
                  Client.field404 = var3;
                  field1603 = var0;
                  if(var0.itemIds[var3] > 0) {
                     ItemComposition var8 = class18.getItemDefinition(var0.itemIds[var3] - 1);
                     if(Client.field438 == 1 && RSCanvas.method2124(class185.method3463(var0))) {
                        if(class156.field2238 != var0.id || class85.field1448 != var3) {
                           class166.addMenuEntry("Use", Client.field371 + " " + "->" + " " + class13.method182(16748608) + var8.name, 31, var8.id, var3, var0.id);
                        }
                     } else if(Client.field440 && RSCanvas.method2124(class185.method3463(var0))) {
                        if((class138.field1920 & 16) == 16) {
                           class166.addMenuEntry(Client.field297, Client.field444 + " " + "->" + " " + class13.method182(16748608) + var8.name, 32, var8.id, var3, var0.id);
                        }
                     } else {
                        String[] var9 = var8.inventoryActions;
                        if(Client.field346) {
                           var9 = class204.method3858(var9);
                        }

                        if(RSCanvas.method2124(class185.method3463(var0))) {
                           for(int var10 = 4; var10 >= 3; --var10) {
                              if(var9 != null && var9[var10] != null) {
                                 byte var11;
                                 if(var10 == 3) {
                                    var11 = 36;
                                 } else {
                                    var11 = 37;
                                 }

                                 class166.addMenuEntry(var9[var10], class13.method182(16748608) + var8.name, var11, var8.id, var3, var0.id);
                              } else if(var10 == 4) {
                                 class166.addMenuEntry("Drop", class13.method182(16748608) + var8.name, 37, var8.id, var3, var0.id);
                              }
                           }
                        }

                        int var19 = class185.method3463(var0);
                        boolean var18 = (var19 >> 31 & 1) != 0;
                        if(var18) {
                           class166.addMenuEntry("Use", class13.method182(16748608) + var8.name, 38, var8.id, var3, var0.id);
                        }

                        Object var10000 = null;
                        int var12;
                        byte var13;
                        if(RSCanvas.method2124(class185.method3463(var0)) && null != var9) {
                           for(var12 = 2; var12 >= 0; --var12) {
                              if(var9[var12] != null) {
                                 var13 = 0;
                                 if(var12 == 0) {
                                    var13 = 33;
                                 }

                                 if(var12 == 1) {
                                    var13 = 34;
                                 }

                                 if(var12 == 2) {
                                    var13 = 35;
                                 }

                                 class166.addMenuEntry(var9[var12], class13.method182(16748608) + var8.name, var13, var8.id, var3, var0.id);
                              }
                           }
                        }

                        var9 = var0.field2080;
                        if(Client.field346) {
                           var9 = class204.method3858(var9);
                        }

                        if(var9 != null) {
                           for(var12 = 4; var12 >= 0; --var12) {
                              if(null != var9[var12]) {
                                 var13 = 0;
                                 if(var12 == 0) {
                                    var13 = 39;
                                 }

                                 if(var12 == 1) {
                                    var13 = 40;
                                 }

                                 if(var12 == 2) {
                                    var13 = 41;
                                 }

                                 if(var12 == 3) {
                                    var13 = 42;
                                 }

                                 if(var12 == 4) {
                                    var13 = 43;
                                 }

                                 class166.addMenuEntry(var9[var12], class13.method182(16748608) + var8.name, var13, var8.id, var3, var0.id);
                              }
                           }
                        }

                        class166.addMenuEntry("Examine", class13.method182(16748608) + var8.name, 1005, var8.id, var3, var0.id);
                     }
                  }
               }

               ++var3;
            }
         }
      }

      if(var0.field2068) {
         if(Client.field440) {
            if(class148.method2828(class185.method3463(var0)) && (class138.field1920 & 32) == 32) {
               class166.addMenuEntry(Client.field297, Client.field444 + " " + "->" + " " + var0.name, 58, 0, var0.index, var0.id);
            }
         } else {
            for(var3 = 9; var3 >= 5; --var3) {
               String var4 = class15.method190(var0, var3);
               if(var4 != null) {
                  class166.addMenuEntry(var4, var0.name, 1007, var3 + 1, var0.index, var0.id);
               }
            }

            if(class63.method1151(class185.method3463(var0)) == 0) {
               var14 = null;
            } else if(null != var0.field2148 && var0.field2148.trim().length() != 0) {
               var14 = var0.field2148;
            } else {
               var14 = null;
            }

            if(var14 != null) {
               class166.addMenuEntry(var14, var0.name, 25, 0, var0.index, var0.id);
            }

            for(var5 = 4; var5 >= 0; --var5) {
               String var16 = class15.method190(var0, var5);
               if(null != var16) {
                  class166.addMenuEntry(var16, var0.name, 57, var5 + 1, var0.index, var0.id);
               }
            }

            var6 = class185.method3463(var0);
            boolean var17 = (var6 & 1) != 0;
            if(var17) {
               class166.addMenuEntry("Continue", "", 30, 0, var0.index, var0.id);
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-4"
   )
   static void method1951() {
      class45.field897 = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class45.field900[var0] = null;
         class45.field901[var0] = 1;
      }

   }
}
