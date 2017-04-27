import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
public class class88 {
   @ObfuscatedName("qq")
   @Export("bufferProvider")
   public static BufferProvider bufferProvider;

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "90"
   )
   static final void method1893(int var0, int var1, int var2, int var3) {
      if(Client.field351 == 0 && !Client.field440) {
         class59.addMenuEntry("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      int var4 = -1;
      int var5 = -1;

      int var6;
      int var7;
      for(var6 = 0; var6 < Model.field1402; ++var6) {
         var7 = Model.field1403[var6];
         int var8 = var7 & 127;
         int var9 = var7 >> 7 & 127;
         int var10 = var7 >> 29 & 3;
         int var11 = var7 >> 14 & 32767;
         if(var5 != var7) {
            var5 = var7;
            if(var10 == 2 && class172.region.method1751(Client.plane, var8, var9, var7) >= 0) {
               ObjectComposition var12 = class26.getObjectDefinition(var11);
               if(var12.impostorIds != null) {
                  var12 = var12.getImpostor();
               }

               if(var12 == null) {
                  continue;
               }

               if(Client.field351 == 1) {
                  class59.addMenuEntry("Use", Client.field439 + " " + "->" + " " + class213.method4037('\uffff') + var12.name, 1, var7, var8, var9);
               } else if(Client.field440) {
                  if((class159.field2071 & 4) == 4) {
                     class59.addMenuEntry(Client.field438, Client.field392 + " " + "->" + " " + class213.method4037('\uffff') + var12.name, 2, var7, var8, var9);
                  }
               } else {
                  String[] var18 = var12.actions;
                  if(Client.field456) {
                     var18 = CollisionData.method2275(var18);
                  }

                  if(var18 != null) {
                     for(int var19 = 4; var19 >= 0; --var19) {
                        if(var18[var19] != null) {
                           short var15 = 0;
                           if(var19 == 0) {
                              var15 = 3;
                           }

                           if(var19 == 1) {
                              var15 = 4;
                           }

                           if(var19 == 2) {
                              var15 = 5;
                           }

                           if(var19 == 3) {
                              var15 = 6;
                           }

                           if(var19 == 4) {
                              var15 = 1001;
                           }

                           class59.addMenuEntry(var18[var19], class213.method4037('\uffff') + var12.name, var15, var7, var8, var9);
                        }
                     }
                  }

                  class59.addMenuEntry("Examine", class213.method4037('\uffff') + var12.name, 1002, var12.field2941 << 14, var8, var9);
               }
            }

            int var13;
            NPC var14;
            Player var16;
            int[] var26;
            int var28;
            if(var10 == 1) {
               NPC var23 = Client.cachedNPCs[var11];
               if(var23 == null) {
                  continue;
               }

               if(var23.composition.field3042 == 1 && (var23.x & 127) == 64 && (var23.y & 127) == 64) {
                  for(var13 = 0; var13 < Client.field321; ++var13) {
                     var14 = Client.cachedNPCs[Client.field350[var13]];
                     if(var14 != null && var14 != var23 && var14.composition.field3042 == 1 && var23.x == var14.x && var23.y == var14.y) {
                        class121.method2309(var14.composition, Client.field350[var13], var8, var9);
                     }
                  }

                  var13 = class45.field891;
                  var26 = class45.field894;

                  for(var28 = 0; var28 < var13; ++var28) {
                     var16 = Client.cachedPlayers[var26[var28]];
                     if(var16 != null && var16.x == var23.x && var23.y == var16.y) {
                        WidgetNode.method196(var16, var26[var28], var8, var9);
                     }
                  }
               }

               class121.method2309(var23.composition, var11, var8, var9);
            }

            if(var10 == 0) {
               Player var24 = Client.cachedPlayers[var11];
               if(var24 == null) {
                  continue;
               }

               if((var24.x & 127) == 64 && (var24.y & 127) == 64) {
                  for(var13 = 0; var13 < Client.field321; ++var13) {
                     var14 = Client.cachedNPCs[Client.field350[var13]];
                     if(var14 != null && var14.composition.field3042 == 1 && var24.x == var14.x && var24.y == var14.y) {
                        class121.method2309(var14.composition, Client.field350[var13], var8, var9);
                     }
                  }

                  var13 = class45.field891;
                  var26 = class45.field894;

                  for(var28 = 0; var28 < var13; ++var28) {
                     var16 = Client.cachedPlayers[var26[var28]];
                     if(var16 != null && var16 != var24 && var16.x == var24.x && var24.y == var16.y) {
                        WidgetNode.method196(var16, var26[var28], var8, var9);
                     }
                  }
               }

               if(var11 != Client.field472) {
                  WidgetNode.method196(var24, var11, var8, var9);
               } else {
                  var4 = var7;
               }
            }

            if(var10 == 3) {
               Deque var25 = Client.groundItemDeque[Client.plane][var8][var9];
               if(var25 != null) {
                  for(Item var29 = (Item)var25.method2829(); var29 != null; var29 = (Item)var25.method2831()) {
                     ItemComposition var27 = class47.getItemDefinition(var29.id);
                     if(Client.field351 == 1) {
                        class59.addMenuEntry("Use", Client.field439 + " " + "->" + " " + class213.method4037(16748608) + var27.name, 16, var29.id, var8, var9);
                     } else if(Client.field440) {
                        if((class159.field2071 & 1) == 1) {
                           class59.addMenuEntry(Client.field438, Client.field392 + " " + "->" + " " + class213.method4037(16748608) + var27.name, 17, var29.id, var8, var9);
                        }
                     } else {
                        String[] var20 = var27.groundActions;
                        if(Client.field456) {
                           var20 = CollisionData.method2275(var20);
                        }

                        for(int var22 = 4; var22 >= 0; --var22) {
                           if(var20 != null && var20[var22] != null) {
                              byte var17 = 0;
                              if(var22 == 0) {
                                 var17 = 18;
                              }

                              if(var22 == 1) {
                                 var17 = 19;
                              }

                              if(var22 == 2) {
                                 var17 = 20;
                              }

                              if(var22 == 3) {
                                 var17 = 21;
                              }

                              if(var22 == 4) {
                                 var17 = 22;
                              }

                              class59.addMenuEntry(var20[var22], class213.method4037(16748608) + var27.name, var17, var29.id, var8, var9);
                           } else if(var22 == 2) {
                              class59.addMenuEntry("Take", class213.method4037(16748608) + var27.name, 20, var29.id, var8, var9);
                           }
                        }

                        class59.addMenuEntry("Examine", class213.method4037(16748608) + var27.name, 1004, var29.id, var8, var9);
                     }
                  }
               }
            }
         }
      }

      if(var4 != -1) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         Player var21 = Client.cachedPlayers[Client.field472];
         WidgetNode.method196(var21, Client.field472, var6, var7);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "0"
   )
   public static void method1894(int var0, int var1) {
      Varbit var2 = class161.method3027(var0);
      int var3 = var2.configId;
      int var4 = var2.leastSignificantBit;
      int var5 = var2.mostSignificantBit;
      int var6 = class167.field2175[var5 - var4];
      if(var1 < 0 || var1 > var6) {
         var1 = 0;
      }

      var6 <<= var4;
      class167.widgetSettings[var3] = class167.widgetSettings[var3] & ~var6 | var1 << var4 & var6;
   }
}
