import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
public final class class128 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1699705957
   )
   int field1913;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1401420029
   )
   int field1914;
   @ObfuscatedName("n")
   final int field1915;
   @ObfuscatedName("q")
   final int field1916;
   @ObfuscatedName("t")
   final int field1917;
   @ObfuscatedName("p")
   final int field1918;
   @ObfuscatedName("v")
   byte[] field1919;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -531075811
   )
   int field1920;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2003734653
   )
   int field1921;
   @ObfuscatedName("c")
   final int field1922;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 785139229
   )
   int field1923;
   @ObfuscatedName("ay")
   int[][] field1924;
   @ObfuscatedName("av")
   int[] field1925;
   @ObfuscatedName("s")
   byte field1926;
   @ObfuscatedName("aq")
   int[][] field1927;
   @ObfuscatedName("ak")
   byte[] field1928;
   @ObfuscatedName("ae")
   int[][] field1929;
   @ObfuscatedName("u")
   byte[] field1930;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1411473743
   )
   int field1931;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1329752917
   )
   int field1932;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1025699273
   )
   int field1933;
   @ObfuscatedName("b")
   int[] field1934;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -264950253
   )
   int field1935;
   @ObfuscatedName("o")
   int[] field1936;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1344810201
   )
   int field1937;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -581720111
   )
   int field1938;
   @ObfuscatedName("am")
   boolean[] field1939;
   @ObfuscatedName("ax")
   boolean[] field1940;
   @ObfuscatedName("ac")
   byte[] field1941;
   @ObfuscatedName("az")
   byte[] field1942;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1219872247
   )
   int field1943;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 137246519
   )
   int field1944;
   @ObfuscatedName("aa")
   byte[] field1945;
   @ObfuscatedName("aj")
   byte[][] field1946;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 2036138579
   )
   int field1947;
   @ObfuscatedName("d")
   final int field1948;
   @ObfuscatedName("ao")
   int[] field1949;
   @ObfuscatedName("m")
   static int[] field1950;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -126247067
   )
   int field1951;
   @ObfuscatedName("ev")
   static ModIcon[] field1952;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)LWidget;",
      garbageValue = "83"
   )
   public static Widget method2364(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(class133.widgets[var1] == null || class133.widgets[var1][var2] == null) {
         boolean var3 = class112.method2112(var1);
         if(!var3) {
            return null;
         }
      }

      return class133.widgets[var1][var2];
   }

   class128() {
      this.field1948 = 4096;
      this.field1922 = 16;
      this.field1915 = 258;
      this.field1916 = 6;
      this.field1917 = 50;
      this.field1918 = 18002;
      this.field1937 = 0;
      this.field1923 = 0;
      this.field1934 = new int[256];
      this.field1936 = new int[257];
      this.field1939 = new boolean[256];
      this.field1940 = new boolean[16];
      this.field1941 = new byte[256];
      this.field1942 = new byte[4096];
      this.field1949 = new int[16];
      this.field1928 = new byte[18002];
      this.field1945 = new byte[18002];
      this.field1946 = new byte[6][258];
      this.field1924 = new int[6][258];
      this.field1929 = new int[6][258];
      this.field1927 = new int[6][258];
      this.field1925 = new int[6];
   }

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "642326787"
   )
   static final void method2365(Widget var0, int var1, int var2) {
      if(var0.field2210 == 1) {
         class59.addMenuEntry(var0.tooltip, "", 24, 0, 0, var0.id);
      }

      String var3;
      if(var0.field2210 == 2 && !Client.field440) {
         if(CombatInfo2.method3540(class103.method1988(var0)) == 0) {
            var3 = null;
         } else if(var0.field2286 != null && var0.field2286.trim().length() != 0) {
            var3 = var0.field2286;
         } else {
            var3 = null;
         }

         if(var3 != null) {
            class59.addMenuEntry(var3, class213.method4037('\uff00') + var0.field2213, 25, 0, -1, var0.id);
         }
      }

      if(var0.field2210 == 3) {
         class59.addMenuEntry("Close", "", 26, 0, 0, var0.id);
      }

      if(var0.field2210 == 4) {
         class59.addMenuEntry(var0.tooltip, "", 28, 0, 0, var0.id);
      }

      if(var0.field2210 == 5) {
         class59.addMenuEntry(var0.tooltip, "", 29, 0, 0, var0.id);
      }

      if(var0.field2210 == 6 && Client.field449 == null) {
         class59.addMenuEntry(var0.tooltip, "", 30, 0, -1, var0.id);
      }

      int var5;
      int var6;
      int var15;
      if(var0.type == 2) {
         var15 = 0;

         for(int var14 = 0; var14 < var0.height; ++var14) {
            for(var5 = 0; var5 < var0.width; ++var5) {
               var6 = (var0.field2273 + 32) * var5;
               int var7 = var14 * (var0.field2274 + 32);
               if(var15 < 20) {
                  var6 += var0.field2223[var15];
                  var7 += var0.field2276[var15];
               }

               if(var1 >= var6 && var2 >= var7 && var1 < var6 + 32 && var2 < var7 + 32) {
                  Client.field399 = var15;
                  class9.field83 = var0;
                  if(var0.itemIds[var15] > 0) {
                     ItemComposition var8 = class47.getItemDefinition(var0.itemIds[var15] - 1);
                     if(Client.field351 == 1 && XItemContainer.method172(class103.method1988(var0))) {
                        if(class72.field1171 != var0.id || var15 != Player.field264) {
                           class59.addMenuEntry("Use", Client.field439 + " " + "->" + " " + class213.method4037(16748608) + var8.name, 31, var8.id, var15, var0.id);
                        }
                     } else if(Client.field440 && XItemContainer.method172(class103.method1988(var0))) {
                        if((class159.field2071 & 16) == 16) {
                           class59.addMenuEntry(Client.field438, Client.field392 + " " + "->" + " " + class213.method4037(16748608) + var8.name, 32, var8.id, var15, var0.id);
                        }
                     } else {
                        String[] var9 = var8.inventoryActions;
                        if(Client.field456) {
                           var9 = CollisionData.method2275(var9);
                        }

                        int var10 = var8.method3776();
                        int var11;
                        boolean var12;
                        byte var13;
                        if(XItemContainer.method172(class103.method1988(var0))) {
                           for(var11 = 4; var11 >= 3; --var11) {
                              var12 = var11 == var10;
                              if(var9 != null && var9[var11] != null) {
                                 if(var11 == 3) {
                                    var13 = 36;
                                 } else {
                                    var13 = 37;
                                 }

                                 class36.method752(var9[var11], class213.method4037(16748608) + var8.name, var13, var8.id, var15, var0.id, var12);
                              } else if(var11 == 4) {
                                 class36.method752("Drop", class213.method4037(16748608) + var8.name, 37, var8.id, var15, var0.id, var12);
                              }
                           }
                        }

                        if(Preferences.method650(class103.method1988(var0))) {
                           class59.addMenuEntry("Use", class213.method4037(16748608) + var8.name, 38, var8.id, var15, var0.id);
                        }

                        if(XItemContainer.method172(class103.method1988(var0)) && var9 != null) {
                           for(var11 = 2; var11 >= 0; --var11) {
                              var12 = var11 == var10;
                              if(var9[var11] != null) {
                                 var13 = 0;
                                 if(var11 == 0) {
                                    var13 = 33;
                                 }

                                 if(var11 == 1) {
                                    var13 = 34;
                                 }

                                 if(var11 == 2) {
                                    var13 = 35;
                                 }

                                 class36.method752(var9[var11], class213.method4037(16748608) + var8.name, var13, var8.id, var15, var0.id, var12);
                              }
                           }
                        }

                        var9 = var0.field2278;
                        if(Client.field456) {
                           var9 = CollisionData.method2275(var9);
                        }

                        if(var9 != null) {
                           for(var11 = 4; var11 >= 0; --var11) {
                              if(var9[var11] != null) {
                                 byte var18 = 0;
                                 if(var11 == 0) {
                                    var18 = 39;
                                 }

                                 if(var11 == 1) {
                                    var18 = 40;
                                 }

                                 if(var11 == 2) {
                                    var18 = 41;
                                 }

                                 if(var11 == 3) {
                                    var18 = 42;
                                 }

                                 if(var11 == 4) {
                                    var18 = 43;
                                 }

                                 class59.addMenuEntry(var9[var11], class213.method4037(16748608) + var8.name, var18, var8.id, var15, var0.id);
                              }
                           }
                        }

                        class59.addMenuEntry("Examine", class213.method4037(16748608) + var8.name, 1005, var8.id, var15, var0.id);
                     }
                  }
               }

               ++var15;
            }
         }
      }

      if(var0.hasScript) {
         if(Client.field440) {
            if(class94.method1927(class103.method1988(var0)) && (class159.field2071 & 32) == 32) {
               class59.addMenuEntry(Client.field438, Client.field392 + " " + "->" + " " + var0.name, 58, 0, var0.index, var0.id);
            }
         } else {
            for(var15 = 9; var15 >= 5; --var15) {
               String var4 = class183.method3290(var0, var15);
               if(var4 != null) {
                  class59.addMenuEntry(var4, var0.name, 1007, var15 + 1, var0.index, var0.id);
               }
            }

            if(CombatInfo2.method3540(class103.method1988(var0)) == 0) {
               var3 = null;
            } else if(var0.field2286 != null && var0.field2286.trim().length() != 0) {
               var3 = var0.field2286;
            } else {
               var3 = null;
            }

            if(var3 != null) {
               class59.addMenuEntry(var3, var0.name, 25, 0, var0.index, var0.id);
            }

            for(var5 = 4; var5 >= 0; --var5) {
               String var16 = class183.method3290(var0, var5);
               if(var16 != null) {
                  class59.addMenuEntry(var16, var0.name, 57, var5 + 1, var0.index, var0.id);
               }
            }

            var6 = class103.method1988(var0);
            boolean var17 = (var6 & 1) != 0;
            if(var17) {
               class59.addMenuEntry("Continue", "", 30, 0, var0.index, var0.id);
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZLjava/lang/String;ZB)V",
      garbageValue = "101"
   )
   public static void method2366(String var0, boolean var1, String var2, boolean var3) {
      if(var1) {
         if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
               ;
            }
         }

         if(class114.field1788.startsWith("win")) {
            class118.method2291(var0, 0, "openjs");
            return;
         }

         if(class114.field1788.startsWith("mac")) {
            class118.method2291(var0, 1, var2);
            return;
         }

         class118.method2291(var0, 2, "openjs");
      } else {
         class118.method2291(var0, 3, "openjs");
      }

   }
}
