import java.awt.Component;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
public abstract class class112 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "745657044"
   )
   public abstract int vmethod2042();

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "768002626"
   )
   public abstract void vmethod2043(Component var1);

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-743125591"
   )
   static final void method2044(Widget var0, int var1, int var2) {
      if(var0.field2188 == 1) {
         GroundObject.addMenuEntry(var0.tooltip, "", 24, 0, 0, var0.id);
      }

      String var3;
      if(var0.field2188 == 2 && !Client.field435) {
         var3 = class32.method690(var0);
         if(null != var3) {
            GroundObject.addMenuEntry(var3, class32.method691('\uff00') + var0.field2301, 25, 0, -1, var0.id);
         }
      }

      if(var0.field2188 == 3) {
         GroundObject.addMenuEntry("Close", "", 26, 0, 0, var0.id);
      }

      if(var0.field2188 == 4) {
         GroundObject.addMenuEntry(var0.tooltip, "", 28, 0, 0, var0.id);
      }

      if(var0.field2188 == 5) {
         GroundObject.addMenuEntry(var0.tooltip, "", 29, 0, 0, var0.id);
      }

      if(var0.field2188 == 6 && Client.field537 == null) {
         GroundObject.addMenuEntry(var0.tooltip, "", 30, 0, -1, var0.id);
      }

      int var4;
      int var5;
      if(var0.type == 2) {
         var5 = 0;

         for(var4 = 0; var4 < var0.height; ++var4) {
            for(int var6 = 0; var6 < var0.width; ++var6) {
               int var7 = (32 + var0.field2251) * var6;
               int var8 = var4 * (var0.field2252 + 32);
               if(var5 < 20) {
                  var7 += var0.field2253[var5];
                  var8 += var0.field2254[var5];
               }

               if(var1 >= var7 && var2 >= var8 && var1 < 32 + var7 && var2 < 32 + var8) {
                  Client.field399 = var5;
                  class13.field144 = var0;
                  if(var0.itemIds[var5] > 0) {
                     ItemComposition var9 = class88.getItemDefinition(var0.itemIds[var5] - 1);
                     if(Client.field447 == 1 && class47.method864(GameObject.method1872(var0))) {
                        if(var0.id != ObjectComposition.field2930 || var5 != class15.field169) {
                           GroundObject.addMenuEntry("Use", Client.field468 + " " + "->" + " " + class32.method691(16748608) + var9.name, 31, var9.id, var5, var0.id);
                        }
                     } else if(Client.field435 && class47.method864(GameObject.method1872(var0))) {
                        if((class214.field3158 & 16) == 16) {
                           GroundObject.addMenuEntry(Client.field438, Client.field282 + " " + "->" + " " + class32.method691(16748608) + var9.name, 32, var9.id, var5, var0.id);
                        }
                     } else {
                        String[] var10 = var9.inventoryActions;
                        if(Client.field300) {
                           var10 = class8.method112(var10);
                        }

                        int var11;
                        byte var12;
                        if(class47.method864(GameObject.method1872(var0))) {
                           for(var11 = 4; var11 >= 3; --var11) {
                              if(null != var10 && var10[var11] != null) {
                                 if(var11 == 3) {
                                    var12 = 36;
                                 } else {
                                    var12 = 37;
                                 }

                                 GroundObject.addMenuEntry(var10[var11], class32.method691(16748608) + var9.name, var12, var9.id, var5, var0.id);
                              } else if(var11 == 4) {
                                 GroundObject.addMenuEntry("Drop", class32.method691(16748608) + var9.name, 37, var9.id, var5, var0.id);
                              }
                           }
                        }

                        if(Player.method238(GameObject.method1872(var0))) {
                           GroundObject.addMenuEntry("Use", class32.method691(16748608) + var9.name, 38, var9.id, var5, var0.id);
                        }

                        if(class47.method864(GameObject.method1872(var0)) && null != var10) {
                           for(var11 = 2; var11 >= 0; --var11) {
                              if(null != var10[var11]) {
                                 var12 = 0;
                                 if(var11 == 0) {
                                    var12 = 33;
                                 }

                                 if(var11 == 1) {
                                    var12 = 34;
                                 }

                                 if(var11 == 2) {
                                    var12 = 35;
                                 }

                                 GroundObject.addMenuEntry(var10[var11], class32.method691(16748608) + var9.name, var12, var9.id, var5, var0.id);
                              }
                           }
                        }

                        var10 = var0.field2256;
                        if(Client.field300) {
                           var10 = class8.method112(var10);
                        }

                        if(var10 != null) {
                           for(var11 = 4; var11 >= 0; --var11) {
                              if(null != var10[var11]) {
                                 var12 = 0;
                                 if(var11 == 0) {
                                    var12 = 39;
                                 }

                                 if(var11 == 1) {
                                    var12 = 40;
                                 }

                                 if(var11 == 2) {
                                    var12 = 41;
                                 }

                                 if(var11 == 3) {
                                    var12 = 42;
                                 }

                                 if(var11 == 4) {
                                    var12 = 43;
                                 }

                                 GroundObject.addMenuEntry(var10[var11], class32.method691(16748608) + var9.name, var12, var9.id, var5, var0.id);
                              }
                           }
                        }

                        GroundObject.addMenuEntry("Examine", class32.method691(16748608) + var9.name, 1005, var9.id, var5, var0.id);
                     }
                  }
               }

               ++var5;
            }
         }
      }

      if(var0.field2184) {
         if(Client.field435) {
            if(class167.method3158(GameObject.method1872(var0)) && (class214.field3158 & 32) == 32) {
               GroundObject.addMenuEntry(Client.field438, Client.field282 + " " + "->" + " " + var0.name, 58, 0, var0.index, var0.id);
            }
         } else {
            String var13;
            for(var5 = 9; var5 >= 5; --var5) {
               if(!Friend.method177(GameObject.method1872(var0), var5) && null == var0.field2285) {
                  var13 = null;
               } else if(var0.actions != null && var0.actions.length > var5 && var0.actions[var5] != null && var0.actions[var5].trim().length() != 0) {
                  var13 = var0.actions[var5];
               } else {
                  var13 = null;
               }

               if(null != var13) {
                  GroundObject.addMenuEntry(var13, var0.name, 1007, 1 + var5, var0.index, var0.id);
               }
            }

            var3 = class32.method690(var0);
            if(null != var3) {
               GroundObject.addMenuEntry(var3, var0.name, 25, 0, var0.index, var0.id);
            }

            for(var4 = 4; var4 >= 0; --var4) {
               if(!Friend.method177(GameObject.method1872(var0), var4) && var0.field2285 == null) {
                  var13 = null;
               } else if(null != var0.actions && var0.actions.length > var4 && null != var0.actions[var4] && var0.actions[var4].trim().length() != 0) {
                  var13 = var0.actions[var4];
               } else {
                  var13 = null;
               }

               if(null != var13) {
                  GroundObject.addMenuEntry(var13, var0.name, 57, var4 + 1, var0.index, var0.id);
               }
            }

            if(class47.method863(GameObject.method1872(var0))) {
               GroundObject.addMenuEntry("Continue", "", 30, 0, var0.index, var0.id);
            }
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-965510323"
   )
   static final int method2052(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;S)V",
      garbageValue = "235"
   )
   public abstract void vmethod2053(Component var1);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)LOverlay;",
      garbageValue = "-960765247"
   )
   public static Overlay method2054(int var0) {
      Overlay var1 = (Overlay)Overlay.field3023.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = Overlay.field3029.method3272(4, var0);
         var1 = new Overlay();
         if(var2 != null) {
            var1.method3729(new Buffer(var2), var0);
         }

         var1.method3728();
         Overlay.field3023.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-1"
   )
   static final int method2055(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = ItemLayer.method1413(var3, var5);
      int var8 = ItemLayer.method1413(var3 + 1, var5);
      int var9 = ItemLayer.method1413(var3, 1 + var5);
      int var10 = ItemLayer.method1413(1 + var3, var5 + 1);
      int var11 = class2.method19(var7, var8, var4, var2);
      int var12 = class2.method19(var9, var10, var4, var2);
      return class2.method19(var11, var12, var6, var2);
   }
}
