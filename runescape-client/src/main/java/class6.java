import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
final class class6 implements Comparator {
   @ObfuscatedName("hi")
   @ObfuscatedGetter(
      intValue = 1622416535
   )
   @Export("menuX")
   static int menuX;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "-1798003051"
   )
   int method71(class2 var1, class2 var2) {
      return var1.method20().compareTo(var2.method20());
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-968232475"
   )
   static final void method73() {
      if(class149.field2036 != null) {
         class149.field2036.method2118();
         class149.field2036 = null;
      }

      class182.method3325();
      Script.region.method1748();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].method2306();
      }

      System.gc();
      class118.method2335(2);
      Client.field421 = -1;
      Client.field545 = false;
      class114.method2262();
      class8.setGameState(10);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "346659993"
   )
   static final void method80() {
      GameObject.method1981();
      if(class0.field7 == null) {
         if(Client.field523 == null) {
            int var1;
            int var3;
            int var4;
            int var9;
            int var13;
            label284: {
               int var0 = class115.field1804;
               int var2;
               int var7;
               if(Client.isMenuOpen) {
                  if(var0 != 1 && (class15.field173 || var0 != 4)) {
                     var1 = class115.field1792;
                     var2 = class115.field1799;
                     if(var1 < menuX - 10 || var1 > 10 + menuX + class107.menuWidth || var2 < class10.menuY - 10 || var2 > 10 + class10.menuY + Player.menuHeight) {
                        Client.isMenuOpen = false;
                        class63.method1215(menuX, class10.menuY, class107.menuWidth, Player.menuHeight);
                     }
                  }

                  if(var0 == 1 || !class15.field173 && var0 == 4) {
                     var1 = menuX;
                     var2 = class10.menuY;
                     var3 = class107.menuWidth;
                     var4 = class115.field1796;
                     int var11 = class115.field1806;
                     int var12 = -1;

                     for(var7 = 0; var7 < Client.menuOptionCount; ++var7) {
                        var13 = var2 + 31 + (Client.menuOptionCount - 1 - var7) * 15;
                        if(var4 > var1 && var4 < var3 + var1 && var11 > var13 - 13 && var11 < 3 + var13) {
                           var12 = var7;
                        }
                     }

                     if(var12 != -1) {
                        class172.method3274(var12);
                     }

                     Client.isMenuOpen = false;
                     class63.method1215(menuX, class10.menuY, class107.menuWidth, Player.menuHeight);
                  }
               } else {
                  var1 = Buffer.method2893();
                  if((var0 == 1 || !class15.field173 && var0 == 4) && var1 >= 0) {
                     var2 = Client.menuTypes[var1];
                     if(var2 == 39 || var2 == 40 || var2 == 41 || var2 == 42 || var2 == 43 || var2 == 33 || var2 == 34 || var2 == 35 || var2 == 36 || var2 == 37 || var2 == 38 || var2 == 1005) {
                        var3 = Client.menuActionParams0[var1];
                        var4 = Client.menuActionParams1[var1];
                        Widget var5 = class179.method3296(var4);
                        var7 = class196.method3614(var5);
                        boolean var6 = (var7 >> 28 & 1) != 0;
                        if(var6) {
                           break label284;
                        }

                        var9 = class196.method3614(var5);
                        boolean var8 = (var9 >> 29 & 1) != 0;
                        if(var8) {
                           break label284;
                        }
                     }
                  }

                  if((var0 == 1 || !class15.field173 && var0 == 4) && (Client.field442 == 1 && Client.menuOptionCount > 2 && !WidgetNode.method192() || class149.method2801(var1))) {
                     var0 = 2;
                  }

                  if((var0 == 1 || !class15.field173 && var0 == 4) && Client.menuOptionCount > 0) {
                     class172.method3274(var1);
                  }

                  if(var0 == 2 && Client.menuOptionCount > 0) {
                     WidgetNode.method190(class115.field1796, class115.field1806);
                  }
               }

               return;
            }

            if(class0.field7 != null && !Client.field467) {
               var13 = Buffer.method2893();
               if(Client.field442 != 1 && !class149.method2801(var13) && Client.menuOptionCount > 0) {
                  var9 = Client.field359;
                  int var10 = Client.field399;
                  ObjectComposition.method3659(class9.field90, var9, var10);
                  class9.field90 = null;
               }
            }

            Client.field467 = false;
            Client.field423 = 0;
            if(class0.field7 != null) {
               class174.method3276(class0.field7);
            }

            class0.field7 = class179.method3296(var4);
            Client.field402 = var3;
            Client.field359 = class115.field1796;
            Client.field399 = class115.field1806;
            if(var1 >= 0) {
               class152.method2813(var1);
            }

            class174.method3276(class0.field7);
         }
      }
   }

   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "([LWidget;IB)V",
      garbageValue = "62"
   )
   static final void method81(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var1 == var3.parentId && (!var3.hasScript || !VertexNormal.method1683(var3))) {
            int var5;
            if(var3.type == 0) {
               if(!var3.hasScript && VertexNormal.method1683(var3) && class114.field1787 != var3) {
                  continue;
               }

               method81(var0, var3.id);
               if(null != var3.children) {
                  method81(var3.children, var3.id);
               }

               WidgetNode var7 = (WidgetNode)Client.componentTable.method2399((long)var3.id);
               if(var7 != null) {
                  var5 = var7.id;
                  if(class30.method696(var5)) {
                     method81(Widget.widgets[var5], -1);
                  }
               }
            }

            if(var3.type == 6) {
               if(var3.field2230 != -1 || var3.field2253 != -1) {
                  boolean var4 = class178.method3289(var3);
                  if(var4) {
                     var5 = var3.field2253;
                  } else {
                     var5 = var3.field2230;
                  }

                  if(var5 != -1) {
                     Sequence var6 = class195.getAnimation(var5);

                     for(var3.field2328 += Client.field498; var3.field2328 > var6.frameLenghts[var3.field2327]; class174.method3276(var3)) {
                        var3.field2328 -= var6.frameLenghts[var3.field2327];
                        ++var3.field2327;
                        if(var3.field2327 >= var6.frameIDs.length) {
                           var3.field2327 -= var6.frameStep;
                           if(var3.field2327 < 0 || var3.field2327 >= var6.frameIDs.length) {
                              var3.field2327 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2294 != 0 && !var3.hasScript) {
                  int var8 = var3.field2294 >> 16;
                  var5 = var3.field2294 << 16 >> 16;
                  var8 *= Client.field498;
                  var5 *= Client.field498;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  class174.method3276(var3);
               }
            }
         }
      }

   }

   public int compare(Object var1, Object var2) {
      return this.method71((class2)var1, (class2)var2);
   }
}
