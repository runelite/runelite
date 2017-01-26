import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
public class class107 {
   @ObfuscatedName("g")
   static File field1726;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = -596569179
   )
   static int field1729;
   @ObfuscatedName("p")
   static boolean field1731 = false;
   @ObfuscatedName("x")
   static Hashtable field1732 = new Hashtable(16);
   @ObfuscatedName("pk")
   static class30 field1733;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IZZZI)Lclass184;",
      garbageValue = "1650991230"
   )
   static class184 method2035(int var0, boolean var1, boolean var2, boolean var3) {
      class116 var4 = null;
      if(null != class104.field1688) {
         var4 = new class116(var0, class104.field1688, Friend.field151[var0], 1000000);
      }

      return new class184(var4, class2.field26, var0, var1, var2, var3);
   }

   class107() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1901393764"
   )
   static final void method2036(int var0, int var1, int var2, int var3) {
      if(Client.field429 == 0 && !Client.field432) {
         class72.addMenuEntry("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      int var4 = -1;
      int var5 = -1;

      int var6;
      int var7;
      for(var6 = 0; var6 < Model.field1412; ++var6) {
         var7 = Model.field1391[var6];
         int var8 = var7 & 127;
         int var9 = var7 >> 7 & 127;
         int var10 = var7 >> 29 & 3;
         int var11 = var7 >> 14 & 32767;
         if(var7 != var5) {
            var5 = var7;
            if(var10 == 2 && Renderable.region.method1729(WallObject.plane, var8, var9, var7) >= 0) {
               ObjectComposition var12 = class217.getObjectDefinition(var11);
               if(var12.impostorIds != null) {
                  var12 = var12.getImpostor();
               }

               if(null == var12) {
                  continue;
               }

               if(Client.field429 == 1) {
                  class72.addMenuEntry("Use", Client.field431 + " " + "->" + " " + Client.method568('\uffff') + var12.name, 1, var7, var8, var9);
               } else if(Client.field432) {
                  if((class3.field29 & 4) == 4) {
                     class72.addMenuEntry(Client.field406, Client.field436 + " " + "->" + " " + Client.method568('\uffff') + var12.name, 2, var7, var8, var9);
                  }
               } else {
                  String[] var13 = var12.actions;
                  if(Client.field502) {
                     var13 = class159.method3042(var13);
                  }

                  if(var13 != null) {
                     for(int var19 = 4; var19 >= 0; --var19) {
                        if(var13[var19] != null) {
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

                           class72.addMenuEntry(var13[var19], Client.method568('\uffff') + var12.name, var15, var7, var8, var9);
                        }
                     }
                  }

                  class72.addMenuEntry("Examine", Client.method568('\uffff') + var12.name, 1002, var12.field2896 << 14, var8, var9);
               }
            }

            NPC var14;
            Player var16;
            int var18;
            int[] var27;
            int var29;
            if(var10 == 1) {
               NPC var23 = Client.cachedNPCs[var11];
               if(var23 == null) {
                  continue;
               }

               if(var23.composition.field2999 == 1 && (var23.x & 127) == 64 && (var23.y & 127) == 64) {
                  for(var18 = 0; var18 < Client.field316; ++var18) {
                     var14 = Client.cachedNPCs[Client.field419[var18]];
                     if(null != var14 && var14 != var23 && var14.composition.field2999 == 1 && var23.x == var14.x && var23.y == var14.y) {
                        class13.method174(var14.composition, Client.field419[var18], var8, var9);
                     }
                  }

                  var18 = class45.field898;
                  var27 = class45.field895;

                  for(var29 = 0; var29 < var18; ++var29) {
                     var16 = Client.cachedPlayers[var27[var29]];
                     if(null != var16 && var16.x == var23.x && var23.y == var16.y) {
                        Actor.method579(var16, var27[var29], var8, var9);
                     }
                  }
               }

               class13.method174(var23.composition, var11, var8, var9);
            }

            if(var10 == 0) {
               Player var24 = Client.cachedPlayers[var11];
               if(var24 == null) {
                  continue;
               }

               if((var24.x & 127) == 64 && (var24.y & 127) == 64) {
                  for(var18 = 0; var18 < Client.field316; ++var18) {
                     var14 = Client.cachedNPCs[Client.field419[var18]];
                     if(var14 != null && var14.composition.field2999 == 1 && var24.x == var14.x && var14.y == var24.y) {
                        class13.method174(var14.composition, Client.field419[var18], var8, var9);
                     }
                  }

                  var18 = class45.field898;
                  var27 = class45.field895;

                  for(var29 = 0; var29 < var18; ++var29) {
                     var16 = Client.cachedPlayers[var27[var29]];
                     if(null != var16 && var16 != var24 && var24.x == var16.x && var16.y == var24.y) {
                        Actor.method579(var16, var27[var29], var8, var9);
                     }
                  }
               }

               if(var11 != Client.field336) {
                  Actor.method579(var24, var11, var8, var9);
               } else {
                  var4 = var7;
               }
            }

            if(var10 == 3) {
               Deque var25 = Client.groundItemDeque[WallObject.plane][var8][var9];
               if(var25 != null) {
                  for(Item var26 = (Item)var25.method2413(); null != var26; var26 = (Item)var25.method2415()) {
                     ItemComposition var28 = class36.getItemDefinition(var26.id);
                     if(Client.field429 == 1) {
                        class72.addMenuEntry("Use", Client.field431 + " " + "->" + " " + Client.method568(16748608) + var28.name, 16, var26.id, var8, var9);
                     } else if(Client.field432) {
                        if((class3.field29 & 1) == 1) {
                           class72.addMenuEntry(Client.field406, Client.field436 + " " + "->" + " " + Client.method568(16748608) + var28.name, 17, var26.id, var8, var9);
                        }
                     } else {
                        String[] var20 = var28.groundActions;
                        if(Client.field502) {
                           var20 = class159.method3042(var20);
                        }

                        for(int var22 = 4; var22 >= 0; --var22) {
                           if(null != var20 && var20[var22] != null) {
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

                              class72.addMenuEntry(var20[var22], Client.method568(16748608) + var28.name, var17, var26.id, var8, var9);
                           } else if(var22 == 2) {
                              class72.addMenuEntry("Take", Client.method568(16748608) + var28.name, 20, var26.id, var8, var9);
                           }
                        }

                        class72.addMenuEntry("Examine", Client.method568(16748608) + var28.name, 1004, var26.id, var8, var9);
                     }
                  }
               }
            }
         }
      }

      if(var4 != -1) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         Player var21 = Client.cachedPlayers[Client.field336];
         Actor.method579(var21, Client.field336, var6, var7);
      }

   }

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)V",
      garbageValue = "-1612989014"
   )
   static final void method2037(String var0, int var1) {
      Client.field394.method3037(121);
      Client.field394.method2799(class37.method737(var0) + 1);
      Client.field394.method2805(var0);
      Client.field394.method2955(var1);
   }
}
