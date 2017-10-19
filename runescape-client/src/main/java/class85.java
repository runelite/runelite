import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
public class class85 {
   @ObfuscatedName("g")
   static final BigInteger field1368;
   @ObfuscatedName("v")
   static final BigInteger field1372;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1217050147
   )
   static int field1371;

   static {
      field1368 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
      field1372 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIILfc;Lfw;I)Z",
      garbageValue = "2073459269"
   )
   static final boolean method1712(int var0, int var1, int var2, class163 var3, CollisionData var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class162.field2302[var7][var8] = 99;
      class162.field2295[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class162.field2298[var11] = var0;
      int var20 = var11 + 1;
      class162.field2299[var11] = var1;
      int[][] var13 = var4.flags;

      while(true) {
         label310:
         while(true) {
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            do {
               do {
                  do {
                     label287:
                     do {
                        if(var20 == var12) {
                           class162.field2296 = var5;
                           class162.field2292 = var6;
                           return false;
                        }

                        var5 = class162.field2298[var12];
                        var6 = class162.field2299[var12];
                        var12 = var12 + 1 & 4095;
                        var18 = var5 - var9;
                        var19 = var6 - var10;
                        var14 = var5 - var4.x;
                        var15 = var6 - var4.y;
                        if(var3.vmethod3126(var2, var5, var6, var4)) {
                           class162.field2296 = var5;
                           class162.field2292 = var6;
                           return true;
                        }

                        var16 = class162.field2295[var18][var19] + 1;
                        if(var18 > 0 && class162.field2302[var18 - 1][var19] == 0 && (var13[var14 - 1][var15] & 19136782) == 0 && (var13[var14 - 1][var15 + var2 - 1] & 19136824) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class162.field2298[var20] = var5 - 1;
                                 class162.field2299[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2302[var18 - 1][var19] = 2;
                                 class162.field2295[var18 - 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var15 + var17] & 19136830) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && class162.field2302[var18 + 1][var19] == 0 && (var13[var14 + var2][var15] & 19136899) == 0 && (var13[var14 + var2][var15 + var2 - 1] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class162.field2298[var20] = var5 + 1;
                                 class162.field2299[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2302[var18 + 1][var19] = 8;
                                 class162.field2295[var18 + 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var15 + var17] & 19136995) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 > 0 && class162.field2302[var18][var19 - 1] == 0 && (var13[var14][var15 - 1] & 19136782) == 0 && (var13[var14 + var2 - 1][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class162.field2298[var20] = var5;
                                 class162.field2299[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2302[var18][var19 - 1] = 1;
                                 class162.field2295[var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 < 128 - var2 && class162.field2302[var18][var19 + 1] == 0 && (var13[var14][var15 + var2] & 19136824) == 0 && (var13[var14 + var2 - 1][var15 + var2] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class162.field2298[var20] = var5;
                                 class162.field2299[var20] = var6 + 1;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2302[var18][var19 + 1] = 4;
                                 class162.field2295[var18][var19 + 1] = var16;
                                 break;
                              }

                              if((var13[var17 + var14][var15 + var2] & 19137016) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 > 0 && class162.field2302[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class162.field2298[var20] = var5 - 1;
                                 class162.field2299[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2302[var18 - 1][var19 - 1] = 3;
                                 class162.field2295[var18 - 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + (var15 - 1)] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && var19 > 0 && class162.field2302[var18 + 1][var19 - 1] == 0 && (var13[var14 + var2][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class162.field2298[var20] = var5 + 1;
                                 class162.field2299[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2302[var18 + 1][var19 - 1] = 9;
                                 class162.field2295[var18 + 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var17 + (var15 - 1)] & 19136995) != 0 || (var13[var14 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 < 128 - var2 && class162.field2302[var18 - 1][var19 + 1] == 0 && (var13[var14 - 1][var15 + var2] & 19136824) == 0) {
                           for(var17 = 1; var17 < var2; ++var17) {
                              if((var13[var14 - 1][var15 + var17] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 + var2] & 19137016) != 0) {
                                 continue label287;
                              }
                           }

                           class162.field2298[var20] = var5 - 1;
                           class162.field2299[var20] = var6 + 1;
                           var20 = var20 + 1 & 4095;
                           class162.field2302[var18 - 1][var19 + 1] = 6;
                           class162.field2295[var18 - 1][var19 + 1] = var16;
                        }
                     } while(var18 >= 128 - var2);
                  } while(var19 >= 128 - var2);
               } while(class162.field2302[var18 + 1][var19 + 1] != 0);
            } while((var13[var14 + var2][var15 + var2] & 19136992) != 0);

            for(var17 = 1; var17 < var2; ++var17) {
               if((var13[var17 + var14][var15 + var2] & 19137016) != 0 || (var13[var14 + var2][var17 + var15] & 19136995) != 0) {
                  continue label310;
               }
            }

            class162.field2298[var20] = var5 + 1;
            class162.field2299[var20] = var6 + 1;
            var20 = var20 + 1 & 4095;
            class162.field2302[var18 + 1][var19 + 1] = 12;
            class162.field2295[var18 + 1][var19 + 1] = var16;
         }
      }
   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "(Lhj;III)V",
      garbageValue = "-486621468"
   )
   static final void method1713(Widget var0, int var1, int var2) {
      if(Client.field1158 == null && !Client.isMenuOpen) {
         if(var0 != null) {
            Widget var5 = var0;
            int var6 = MilliTimer.method2964(class25.getWidgetConfig(var0));
            Widget var4;
            int var7;
            if(var6 == 0) {
               var4 = null;
            } else {
               var7 = 0;

               while(true) {
                  if(var7 >= var6) {
                     var4 = var5;
                     break;
                  }

                  var5 = ItemLayer.method2454(var5.parentId);
                  if(var5 == null) {
                     var4 = null;
                     break;
                  }

                  ++var7;
               }
            }

            Widget var8 = var4;
            if(var4 == null) {
               var8 = var0.dragParent;
            }

            if(var8 != null) {
               Client.field1158 = var0;
               var5 = var0;
               var6 = MilliTimer.method2964(class25.getWidgetConfig(var0));
               if(var6 == 0) {
                  var4 = null;
               } else {
                  var7 = 0;

                  while(true) {
                     if(var7 >= var6) {
                        var4 = var5;
                        break;
                     }

                     var5 = ItemLayer.method2454(var5.parentId);
                     if(var5 == null) {
                        var4 = null;
                        break;
                     }

                     ++var7;
                  }
               }

               var8 = var4;
               if(var4 == null) {
                  var8 = var0.dragParent;
               }

               Client.field960 = var8;
               Client.field1089 = var1;
               Client.field1168 = var2;
               class39.field554 = 0;
               Client.field1090 = false;
               int var9 = Client.menuOptionCount - 1;
               if(var9 != -1) {
                  class8.method40(var9);
               }

               return;
            }
         }

      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lfz;II)V",
      garbageValue = "-1486850703"
   )
   public static void method1708(Buffer var0, int var1) {
      if(class155.field2240 != null) {
         try {
            class155.field2240.seek(0L);
            class155.field2240.write(var0.payload, var1, 24);
         } catch (Exception var3) {
            ;
         }
      }

   }
}
