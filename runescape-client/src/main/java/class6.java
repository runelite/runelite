import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
final class class6 implements Comparator {
   @ObfuscatedName("k")
   public static short[][] field62;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      longValue = -1160907230520844091L
   )
   static long field63;
   @ObfuscatedName("dt")
   static int[] field65;
   @ObfuscatedName("v")
   static int[] field67;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;B)I",
      garbageValue = "-1"
   )
   int method81(class2 var1, class2 var2) {
      return var1.method23().compareTo(var2.method23());
   }

   public int compare(Object var1, Object var2) {
      return this.method81((class2)var1, (class2)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "0"
   )
   static final int method89(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class5.method75(var3, var5);
      int var8 = class5.method75(var3 + 1, var5);
      int var9 = class5.method75(var3, 1 + var5);
      int var10 = class5.method75(1 + var3, var5 + 1);
      int var11 = class148.method2794(var7, var8, var4, var2);
      int var12 = class148.method2794(var9, var10, var4, var2);
      return class148.method2794(var11, var12, var6, var2);
   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "311507391"
   )
   static final void method91(Widget var0, int var1, int var2) {
      if(var0.field2237 == 1) {
         class22.addMenuEntry(var0.tooltip, "", 24, 0, 0, var0.id);
      }

      int var4;
      int var5;
      String var21;
      if(var0.field2237 == 2 && !Client.field468) {
         var5 = class174.method3271(var0);
         var4 = var5 >> 11 & 63;
         if(var4 == 0) {
            var21 = null;
         } else if(null != var0.field2265 && var0.field2265.trim().length() != 0) {
            var21 = var0.field2265;
         } else {
            var21 = null;
         }

         if(var21 != null) {
            class22.addMenuEntry(var21, class116.method2288('\uff00') + var0.field2282, 25, 0, -1, var0.id);
         }
      }

      if(var0.field2237 == 3) {
         class22.addMenuEntry("Close", "", 26, 0, 0, var0.id);
      }

      if(var0.field2237 == 4) {
         class22.addMenuEntry(var0.tooltip, "", 28, 0, 0, var0.id);
      }

      if(var0.field2237 == 5) {
         class22.addMenuEntry(var0.tooltip, "", 29, 0, 0, var0.id);
      }

      if(var0.field2237 == 6 && null == Client.field477) {
         class22.addMenuEntry(var0.tooltip, "", 30, 0, -1, var0.id);
      }

      int var3;
      if(var0.type == 2) {
         var3 = 0;

         for(var4 = 0; var4 < var0.height; ++var4) {
            for(var5 = 0; var5 < var0.width; ++var5) {
               int var6 = (var0.field2189 + 32) * var5;
               int var7 = (var0.field2239 + 32) * var4;
               if(var3 < 20) {
                  var6 += var0.field2302[var3];
                  var7 += var0.field2255[var3];
               }

               if(var1 >= var6 && var2 >= var7 && var1 < var6 + 32 && var2 < 32 + var7) {
                  Client.field408 = var3;
                  class3.field38 = var0;
                  if(var0.itemIds[var3] > 0) {
                     label405: {
                        ItemComposition var8 = class154.getItemDefinition(var0.itemIds[var3] - 1);
                        int var10;
                        boolean var22;
                        if(Client.field466 == 1) {
                           var10 = class174.method3271(var0);
                           var22 = (var10 >> 30 & 1) != 0;
                           if(var22) {
                              if(var0.id != class49.field967 || class107.field1744 != var3) {
                                 class22.addMenuEntry("Use", Client.field496 + " " + "->" + " " + class116.method2288(16748608) + var8.name, 31, var8.id, var3, var0.id);
                              }
                              break label405;
                           }
                        }

                        if(Client.field468) {
                           var10 = class174.method3271(var0);
                           var22 = (var10 >> 30 & 1) != 0;
                           if(var22) {
                              if((class7.field73 & 16) == 16) {
                                 class22.addMenuEntry(Client.field489, Client.field472 + " " + "->" + " " + class116.method2288(16748608) + var8.name, 32, var8.id, var3, var0.id);
                              }
                              break label405;
                           }
                        }

                        String[] var9 = var8.inventoryActions;
                        if(Client.field484) {
                           var9 = Item.method875(var9);
                        }

                        var10 = var8.method3694();
                        int var12 = class174.method3271(var0);
                        boolean var11 = (var12 >> 30 & 1) != 0;
                        if(var11) {
                           for(int var13 = 4; var13 >= 3; --var13) {
                              boolean var14 = var10 == var13;
                              if(null != var9 && null != var9[var13]) {
                                 byte var15;
                                 if(var13 == 3) {
                                    var15 = 36;
                                 } else {
                                    var15 = 37;
                                 }

                                 class5.method80(var9[var13], class116.method2288(16748608) + var8.name, var15, var8.id, var3, var0.id, var14);
                              } else if(var13 == 4) {
                                 class5.method80("Drop", class116.method2288(16748608) + var8.name, 37, var8.id, var3, var0.id, var14);
                              }
                           }
                        }

                        int var25 = class174.method3271(var0);
                        boolean var24 = (var25 >> 31 & 1) != 0;
                        if(var24) {
                           class22.addMenuEntry("Use", class116.method2288(16748608) + var8.name, 38, var8.id, var3, var0.id);
                        }

                        int var16 = class174.method3271(var0);
                        boolean var26 = (var16 >> 30 & 1) != 0;
                        int var17;
                        if(var26 && null != var9) {
                           for(var17 = 2; var17 >= 0; --var17) {
                              boolean var18 = var17 == var10;
                              if(null != var9[var17]) {
                                 byte var19 = 0;
                                 if(var17 == 0) {
                                    var19 = 33;
                                 }

                                 if(var17 == 1) {
                                    var19 = 34;
                                 }

                                 if(var17 == 2) {
                                    var19 = 35;
                                 }

                                 class5.method80(var9[var17], class116.method2288(16748608) + var8.name, var19, var8.id, var3, var0.id, var18);
                              }
                           }
                        }

                        var9 = var0.field2257;
                        if(Client.field484) {
                           var9 = Item.method875(var9);
                        }

                        if(var9 != null) {
                           for(var17 = 4; var17 >= 0; --var17) {
                              if(var9[var17] != null) {
                                 byte var27 = 0;
                                 if(var17 == 0) {
                                    var27 = 39;
                                 }

                                 if(var17 == 1) {
                                    var27 = 40;
                                 }

                                 if(var17 == 2) {
                                    var27 = 41;
                                 }

                                 if(var17 == 3) {
                                    var27 = 42;
                                 }

                                 if(var17 == 4) {
                                    var27 = 43;
                                 }

                                 class22.addMenuEntry(var9[var17], class116.method2288(16748608) + var8.name, var27, var8.id, var3, var0.id);
                              }
                           }
                        }

                        class22.addMenuEntry("Examine", class116.method2288(16748608) + var8.name, 1005, var8.id, var3, var0.id);
                     }
                  }
               }

               ++var3;
            }
         }
      }

      if(var0.hasScript) {
         if(Client.field468) {
            if(class0.method13(class174.method3271(var0)) && (class7.field73 & 32) == 32) {
               class22.addMenuEntry(Client.field489, Client.field472 + " " + "->" + " " + var0.name, 58, 0, var0.index, var0.id);
            }
         } else {
            for(var3 = 9; var3 >= 5; --var3) {
               String var20 = Frames.method1962(var0, var3);
               if(var20 != null) {
                  class22.addMenuEntry(var20, var0.name, 1007, var3 + 1, var0.index, var0.id);
               }
            }

            var5 = class174.method3271(var0);
            var4 = var5 >> 11 & 63;
            if(var4 == 0) {
               var21 = null;
            } else if(null != var0.field2265 && var0.field2265.trim().length() != 0) {
               var21 = var0.field2265;
            } else {
               var21 = null;
            }

            if(var21 != null) {
               class22.addMenuEntry(var21, var0.name, 25, 0, var0.index, var0.id);
            }

            for(var5 = 4; var5 >= 0; --var5) {
               String var23 = Frames.method1962(var0, var5);
               if(var23 != null) {
                  class22.addMenuEntry(var23, var0.name, 57, var5 + 1, var0.index, var0.id);
               }
            }

            if(class36.method803(class174.method3271(var0))) {
               class22.addMenuEntry("Continue", "", 30, 0, var0.index, var0.id);
            }
         }
      }

   }

   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "-952195949"
   )
   static final void method92(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1 && (!var3.hasScript || !class13.method195(var3))) {
            if(var3.type == 0) {
               if(!var3.hasScript && class13.method195(var3) && var3 != class1.field16) {
                  continue;
               }

               method92(var0, var3.id);
               if(var3.children != null) {
                  method92(var3.children, var3.id);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method2405((long)var3.id);
               if(var4 != null) {
                  class38.method811(var4.id);
               }
            }

            if(var3.type == 6) {
               int var5;
               if(var3.field2233 != -1 || var3.field2234 != -1) {
                  boolean var7 = class18.method214(var3);
                  if(var7) {
                     var5 = var3.field2234;
                  } else {
                     var5 = var3.field2233;
                  }

                  if(var5 != -1) {
                     Sequence var6 = class168.getAnimation(var5);

                     for(var3.field2213 += Client.field328; var3.field2213 > var6.frameLenghts[var3.field2308]; class2.method36(var3)) {
                        var3.field2213 -= var6.frameLenghts[var3.field2308];
                        ++var3.field2308;
                        if(var3.field2308 >= var6.frameIDs.length) {
                           var3.field2308 -= var6.frameStep;
                           if(var3.field2308 < 0 || var3.field2308 >= var6.frameIDs.length) {
                              var3.field2308 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2242 != 0 && !var3.hasScript) {
                  int var8 = var3.field2242 >> 16;
                  var5 = var3.field2242 << 16 >> 16;
                  var8 *= Client.field328;
                  var5 *= Client.field328;
                  var3.rotationX = var3.rotationX + var8 & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  class2.method36(var3);
               }
            }
         }
      }

   }
}
