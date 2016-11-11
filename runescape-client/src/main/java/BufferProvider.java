import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("e")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("nn")
   @ObfuscatedGetter(
      intValue = 553397843
   )
   static int field1445;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 522660103
   )
   @Export("height")
   int height;
   @ObfuscatedName("u")
   @Export("image")
   public Image image;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1228666013
   )
   @Export("width")
   public int width;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)V",
      garbageValue = "99"
   )
   abstract void init(int var1, int var2, Component var3);

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIB)V",
      garbageValue = "-117"
   )
   public abstract void draw(Graphics var1, int var2, int var3);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "-949670356"
   )
   public abstract void drawSub(Graphics var1, int var2, int var3, int var4, int var5);

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-180252496"
   )
   static final void method1732(boolean var0) {
      ItemComposition.method1168(Client.widgetRoot, class62.field1267, class77.field1428, var0);
   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(LWidget;IIB)V",
      garbageValue = "119"
   )
   static final void method1733(Widget var0, int var1, int var2) {
      if(var0.field2805 == 1) {
         class132.addMenuEntry(var0.tooltip, "", 24, 0, 0, var0.id);
      }

      String var14;
      if(var0.field2805 == 2 && !Client.field455) {
         var14 = class134.method2868(var0);
         if(var14 != null) {
            class132.addMenuEntry(var14, class137.method2909('\uff00') + var0.field2918, 25, 0, -1, var0.id);
         }
      }

      if(var0.field2805 == 3) {
         class132.addMenuEntry("Close", "", 26, 0, 0, var0.id);
      }

      if(var0.field2805 == 4) {
         class132.addMenuEntry(var0.tooltip, "", 28, 0, 0, var0.id);
      }

      if(var0.field2805 == 5) {
         class132.addMenuEntry(var0.tooltip, "", 29, 0, 0, var0.id);
      }

      if(var0.field2805 == 6 && null == Client.field464) {
         class132.addMenuEntry(var0.tooltip, "", 30, 0, -1, var0.id);
      }

      int var3;
      int var6;
      int var7;
      int var15;
      if(var0.type == 2) {
         var3 = 0;

         for(var15 = 0; var15 < var0.height; ++var15) {
            for(int var5 = 0; var5 < var0.width; ++var5) {
               var6 = (32 + var0.field2868) * var5;
               var7 = var15 * (32 + var0.field2869);
               if(var3 < 20) {
                  var6 += var0.field2836[var3];
                  var7 += var0.field2871[var3];
               }

               if(var1 >= var6 && var2 >= var7 && var1 < 32 + var6 && var2 < var7 + 32) {
                  Client.field454 = var3;
                  WidgetNode.field69 = var0;
                  if(var0.itemIds[var3] > 0) {
                     ItemComposition var8 = class92.getItemDefinition(var0.itemIds[var3] - 1);
                     if(Client.field453 == 1 && class11.method148(Projectile.method96(var0))) {
                        if(var0.id != RSCanvas.field2197 || class24.field641 != var3) {
                           class132.addMenuEntry("Use", Client.field312 + " " + "->" + " " + class137.method2909(16748608) + var8.name, 31, var8.id, var3, var0.id);
                        }
                     } else if(Client.field455 && class11.method148(Projectile.method96(var0))) {
                        if((class18.field285 & 16) == 16) {
                           class132.addMenuEntry(Client.field458, Client.field459 + " " + "->" + " " + class137.method2909(16748608) + var8.name, 32, var8.id, var3, var0.id);
                        }
                     } else {
                        String[] var9 = var8.inventoryActions;
                        if(Client.field471) {
                           var9 = Friend.method193(var9);
                        }

                        if(class11.method148(Projectile.method96(var0))) {
                           for(int var10 = 4; var10 >= 3; --var10) {
                              if(null != var9 && var9[var10] != null) {
                                 byte var11;
                                 if(var10 == 3) {
                                    var11 = 36;
                                 } else {
                                    var11 = 37;
                                 }

                                 class132.addMenuEntry(var9[var10], class137.method2909(16748608) + var8.name, var11, var8.id, var3, var0.id);
                              } else if(var10 == 4) {
                                 class132.addMenuEntry("Drop", class137.method2909(16748608) + var8.name, 37, var8.id, var3, var0.id);
                              }
                           }
                        }

                        int var21 = Projectile.method96(var0);
                        boolean var20 = (var21 >> 31 & 1) != 0;
                        if(var20) {
                           class132.addMenuEntry("Use", class137.method2909(16748608) + var8.name, 38, var8.id, var3, var0.id);
                        }

                        Object var10000 = null;
                        int var12;
                        byte var13;
                        if(class11.method148(Projectile.method96(var0)) && null != var9) {
                           for(var12 = 2; var12 >= 0; --var12) {
                              if(null != var9[var12]) {
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

                                 class132.addMenuEntry(var9[var12], class137.method2909(16748608) + var8.name, var13, var8.id, var3, var0.id);
                              }
                           }
                        }

                        var9 = var0.field2920;
                        if(Client.field471) {
                           var9 = Friend.method193(var9);
                        }

                        if(null != var9) {
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

                                 class132.addMenuEntry(var9[var12], class137.method2909(16748608) + var8.name, var13, var8.id, var3, var0.id);
                              }
                           }
                        }

                        class132.addMenuEntry("Examine", class137.method2909(16748608) + var8.name, 1005, var8.id, var3, var0.id);
                     }
                  }
               }

               ++var3;
            }
         }
      }

      if(var0.field2862) {
         if(Client.field455) {
            if(class85.method1918(Projectile.method96(var0)) && (class18.field285 & 32) == 32) {
               class132.addMenuEntry(Client.field458, Client.field459 + " " + "->" + " " + var0.name, 58, 0, var0.index, var0.id);
            }
         } else {
            for(var3 = 9; var3 >= 5; --var3) {
               var6 = Projectile.method96(var0);
               boolean var18 = (var6 >> 1 + var3 & 1) != 0;
               String var4;
               if(!var18 && null == var0.field2902) {
                  var4 = null;
               } else if(var0.actions != null && var0.actions.length > var3 && null != var0.actions[var3] && var0.actions[var3].trim().length() != 0) {
                  var4 = var0.actions[var3];
               } else {
                  var4 = null;
               }

               if(null != var4) {
                  class132.addMenuEntry(var4, var0.name, 1007, var3 + 1, var0.index, var0.id);
               }
            }

            var14 = class134.method2868(var0);
            if(var14 != null) {
               class132.addMenuEntry(var14, var0.name, 25, 0, var0.index, var0.id);
            }

            for(var15 = 4; var15 >= 0; --var15) {
               var7 = Projectile.method96(var0);
               boolean var19 = (var7 >> var15 + 1 & 1) != 0;
               String var16;
               if(!var19 && var0.field2902 == null) {
                  var16 = null;
               } else if(var0.actions != null && var0.actions.length > var15 && null != var0.actions[var15] && var0.actions[var15].trim().length() != 0) {
                  var16 = var0.actions[var15];
               } else {
                  var16 = null;
               }

               if(var16 != null) {
                  class132.addMenuEntry(var16, var0.name, 57, var15 + 1, var0.index, var0.id);
               }
            }

            if(World.method592(Projectile.method96(var0))) {
               class132.addMenuEntry("Continue", "", 30, 0, var0.index, var0.id);
            }
         }
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public final void method1734() {
      class82.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "69"
   )
   public static void method1735() {
      Object var0 = class173.field2753;
      synchronized(class173.field2753) {
         if(class173.field2755 != 0) {
            class173.field2755 = 1;

            try {
               class173.field2753.wait();
            } catch (InterruptedException var3) {
               ;
            }
         }

      }
   }
}
