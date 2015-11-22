package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("al")
public class class38 extends class206 {
   @ObfuscatedName("m")
   String field859;
   @ObfuscatedName("f")
   short field860;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 591564733
   )
   int field863 = (int)(class92.method2177() / 1000L);

   @ObfuscatedName("by")
   static final void method804(int var0, int var1, int var2, int var3) {
      if(client.field398 == 0 && !client.field546) {
         class25.method674("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      int var4 = -1;
      int var5 = -1;

      int var6;
      int var7;
      for(var6 = 0; var6 < class104.field1833; ++var6) {
         var7 = class104.field1834[var6];
         int var8 = var7 & 127;
         int var9 = var7 >> 7 & 127;
         int var10 = var7 >> 29 & 3;
         int var11 = var7 >> 14 & 32767;
         if(var5 != var7) {
            var5 = var7;
            if(2 == var10 && class24.field610.method1962(class8.field134, var8, var9, var7) >= 0) {
               class40 var12 = class33.method755(var11);
               if(var12.field945 != null) {
                  var12 = var12.method847();
               }

               if(null == var12) {
                  continue;
               }

               if(1 == client.field398) {
                  class25.method674("Use", client.field428 + " " + "->" + " " + class74.method1617('\uffff') + var12.field914, 1, var7, var8, var9);
               } else if(client.field546) {
                  if((class138.field2124 & 4) == 4) {
                     class25.method674(client.field432, client.field433 + " " + "->" + " " + class74.method1617('\uffff') + var12.field914, 2, var7, var8, var9);
                  }
               } else {
                  String[] var13 = var12.field931;
                  if(client.field374) {
                     var13 = class143.method3145(var13);
                  }

                  if(null != var13) {
                     for(int var14 = 4; var14 >= 0; --var14) {
                        if(var13[var14] != null) {
                           short var15 = 0;
                           if(0 == var14) {
                              var15 = 3;
                           }

                           if(var14 == 1) {
                              var15 = 4;
                           }

                           if(2 == var14) {
                              var15 = 5;
                           }

                           if(var14 == 3) {
                              var15 = 6;
                           }

                           if(var14 == 4) {
                              var15 = 1001;
                           }

                           class25.method674(var13[var14], class74.method1617('\uffff') + var12.field914, var15, var7, var8, var9);
                        }
                     }
                  }

                  class25.method674("Examine", class74.method1617('\uffff') + var12.field914, 1002, var12.field935 << 14, var8, var9);
               }
            }

            class2 var16;
            int var22;
            class34 var23;
            int[] var24;
            int var28;
            if(var10 == 1) {
               class34 var19 = client.field313[var11];
               if(var19 == null) {
                  continue;
               }

               if(var19.field761.field871 == 1 && 64 == (var19.field846 & 127) && 64 == (var19.field834 & 127)) {
                  for(var22 = 0; var22 < client.field314; ++var22) {
                     var23 = client.field313[client.field315[var22]];
                     if(var23 != null && var19 != var23 && var23.field761.field871 == 1 && var23.field846 == var19.field846 && var19.field834 == var23.field834) {
                        class115.method2474(var23.field761, client.field315[var22], var8, var9);
                     }
                  }

                  var22 = class32.field733;
                  var24 = class32.field730;

                  for(var28 = 0; var28 < var22; ++var28) {
                     var16 = client.field397[var24[var28]];
                     if(null != var16 && var16.field846 == var19.field846 && var19.field834 == var16.field834) {
                        class98.method2216(var16, var24[var28], var8, var9);
                     }
                  }
               }

               class115.method2474(var19.field761, var11, var8, var9);
            }

            if(0 == var10) {
               class2 var20 = client.field397[var11];
               if(null == var20) {
                  continue;
               }

               if((var20.field846 & 127) == 64 && 64 == (var20.field834 & 127)) {
                  for(var22 = 0; var22 < client.field314; ++var22) {
                     var23 = client.field313[client.field315[var22]];
                     if(var23 != null && 1 == var23.field761.field871 && var23.field846 == var20.field846 && var23.field834 == var20.field834) {
                        class115.method2474(var23.field761, client.field315[var22], var8, var9);
                     }
                  }

                  var22 = class32.field733;
                  var24 = class32.field730;

                  for(var28 = 0; var28 < var22; ++var28) {
                     var16 = client.field397[var24[var28]];
                     if(var16 != null && var20 != var16 && var16.field846 == var20.field846 && var16.field834 == var20.field834) {
                        class98.method2216(var16, var24[var28], var8, var9);
                     }
                  }
               }

               if(client.field406 != var11) {
                  class98.method2216(var20, var11, var8, var9);
               } else {
                  var4 = var7;
               }
            }

            if(3 == var10) {
               class198 var21 = client.field407[class8.field134][var8][var9];
               if(null != var21) {
                  for(class28 var25 = (class28)var21.method3884(); var25 != null; var25 = (class28)var21.method3874()) {
                     class51 var26 = class10.method158(var25.field660);
                     if(1 == client.field398) {
                        class25.method674("Use", client.field428 + " " + "->" + " " + class74.method1617(16748608) + var26.field1099, 16, var25.field660, var8, var9);
                     } else if(client.field546) {
                        if(1 == (class138.field2124 & 1)) {
                           class25.method674(client.field432, client.field433 + " " + "->" + " " + class74.method1617(16748608) + var26.field1099, 17, var25.field660, var8, var9);
                        }
                     } else {
                        String[] var29 = var26.field1108;
                        if(client.field374) {
                           var29 = class143.method3145(var29);
                        }

                        for(int var27 = 4; var27 >= 0; --var27) {
                           if(null != var29 && var29[var27] != null) {
                              byte var17 = 0;
                              if(0 == var27) {
                                 var17 = 18;
                              }

                              if(var27 == 1) {
                                 var17 = 19;
                              }

                              if(2 == var27) {
                                 var17 = 20;
                              }

                              if(var27 == 3) {
                                 var17 = 21;
                              }

                              if(var27 == 4) {
                                 var17 = 22;
                              }

                              class25.method674(var29[var27], class74.method1617(16748608) + var26.field1099, var17, var25.field660, var8, var9);
                           } else if(2 == var27) {
                              class25.method674("Take", class74.method1617(16748608) + var26.field1099, 20, var25.field660, var8, var9);
                           }
                        }

                        class25.method674("Examine", class74.method1617(16748608) + var26.field1099, 1004, var25.field660, var8, var9);
                     }
                  }
               }
            }
         }
      }

      if(-1 != var4) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         class2 var18 = client.field397[client.field406];
         class98.method2216(var18, client.field406, var6, var7);
      }

   }

   class38(String var1, int var2) {
      this.field859 = var1;
      this.field860 = (short)var2;
   }

   @ObfuscatedName("d")
   static void method805(int var0, int var1, int var2) {
      if(client.field514 != 0 && var1 != 0 && client.field516 < 50) {
         client.field462[client.field516] = var0;
         client.field518[client.field516] = var1;
         client.field519[client.field516] = var2;
         client.field521[client.field516] = null;
         client.field467[client.field516] = 0;
         ++client.field516;
      }

   }

   @ObfuscatedName("at")
   static final void method806(boolean var0) {
      for(int var1 = 0; var1 < client.field314; ++var1) {
         class34 var2 = client.field313[client.field315[var1]];
         int var3 = (client.field315[var1] << 14) + 536870912;
         if(var2 != null && var2.vmethod791() && var0 == var2.field761.field890 && var2.field761.method827()) {
            int var4 = var2.field846 >> 7;
            int var5 = var2.field834 >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(1 == var2.field802 && 64 == (var2.field846 & 127) && 64 == (var2.field834 & 127)) {
                  if(client.field381 == client.field305[var4][var5]) {
                     continue;
                  }

                  client.field305[var4][var5] = client.field381;
               }

               if(!var2.field761.field881) {
                  var3 -= Integer.MIN_VALUE;
               }

               class24.field610.method1943(class8.field134, var2.field846, var2.field834, class34.method774(var2.field802 * 64 - 64 + var2.field846, var2.field834 + (var2.field802 * 64 - 64), class8.field134), 60 + (var2.field802 * 64 - 64), var2, var2.field800, var3, var2.field801);
            }
         }
      }

   }
}
