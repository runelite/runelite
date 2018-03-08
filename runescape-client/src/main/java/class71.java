import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
public class class71 extends class178 {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIILfa;I)Z",
      garbageValue = "-2078182693"
   )
   protected boolean vmethod3427(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field2254 && var3 == super.field2255;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lek;IIII)Z",
      garbageValue = "881095157"
   )
   @Export("boundingBox3DContainsMouse")
   public static final boolean boundingBox3DContainsMouse(Model var0, int var1, int var2, int var3) {
      boolean var4 = class132.Viewport_containsMouse;
      if(!var4) {
         return false;
      } else {
         class90.method1942();
         int var5 = var0.centerX + var1;
         int var6 = var2 + var0.centerY;
         int var7 = var3 + var0.centerZ;
         int var8 = var0.extremeX;
         int var9 = var0.extremeY;
         int var10 = var0.extremeZ;
         int var11 = class5.field30 - var5;
         int var12 = class132.field1897 - var6;
         int var13 = class61.field698 - var7;
         return Math.abs(var11) > var8 + class326.field3956?false:(Math.abs(var12) > var9 + class132.field1893?false:(Math.abs(var13) > var10 + class132.field1899?false:(Math.abs(var13 * VarPlayerType.field3451 - var12 * class228.field2669) > var9 * class132.field1899 + var10 * class132.field1893?false:(Math.abs(var11 * class228.field2669 - var13 * NPC.field1282) > var10 * class326.field3956 + var8 * class132.field1899?false:Math.abs(var12 * NPC.field1282 - var11 * VarPlayerType.field3451) <= var9 * class326.field3956 + var8 * class132.field1893))));
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIILfv;Lfa;I)Z",
      garbageValue = "-298337236"
   )
   static final boolean method1198(int var0, int var1, int var2, class178 var3, CollisionData var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class177.field2249[var7][var8] = 99;
      class177.field2250[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class177.field2251[var11] = var0;
      int var20 = var11 + 1;
      class177.field2253[var11] = var1;
      int[][] var13 = var4.flags;

      while(true) {
         label313:
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
                     label290:
                     do {
                        if(var20 == var12) {
                           UnitPriceComparator.field297 = var5;
                           TotalQuantityComparator.field282 = var6;
                           return false;
                        }

                        var5 = class177.field2251[var12];
                        var6 = class177.field2253[var12];
                        var12 = var12 + 1 & 4095;
                        var18 = var5 - var9;
                        var19 = var6 - var10;
                        var14 = var5 - var4.x;
                        var15 = var6 - var4.y;
                        if(var3.vmethod3427(var2, var5, var6, var4)) {
                           UnitPriceComparator.field297 = var5;
                           TotalQuantityComparator.field282 = var6;
                           return true;
                        }

                        var16 = class177.field2250[var18][var19] + 1;
                        if(var18 > 0 && class177.field2249[var18 - 1][var19] == 0 && (var13[var14 - 1][var15] & 19136782) == 0 && (var13[var14 - 1][var15 + var2 - 1] & 19136824) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class177.field2251[var20] = var5 - 1;
                                 class177.field2253[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class177.field2249[var18 - 1][var19] = 2;
                                 class177.field2250[var18 - 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + var15] & 19136830) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && class177.field2249[var18 + 1][var19] == 0 && (var13[var14 + var2][var15] & 19136899) == 0 && (var13[var14 + var2][var15 + var2 - 1] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class177.field2251[var20] = var5 + 1;
                                 class177.field2253[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class177.field2249[var18 + 1][var19] = 8;
                                 class177.field2250[var18 + 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var15 + var17] & 19136995) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 > 0 && class177.field2249[var18][var19 - 1] == 0 && (var13[var14][var15 - 1] & 19136782) == 0 && (var13[var14 + var2 - 1][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class177.field2251[var20] = var5;
                                 class177.field2253[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class177.field2249[var18][var19 - 1] = 1;
                                 class177.field2250[var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 < 128 - var2 && class177.field2249[var18][var19 + 1] == 0 && (var13[var14][var15 + var2] & 19136824) == 0 && (var13[var14 + var2 - 1][var15 + var2] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class177.field2251[var20] = var5;
                                 class177.field2253[var20] = var6 + 1;
                                 var20 = var20 + 1 & 4095;
                                 class177.field2249[var18][var19 + 1] = 4;
                                 class177.field2250[var18][var19 + 1] = var16;
                                 break;
                              }

                              if((var13[var17 + var14][var15 + var2] & 19137016) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 > 0 && class177.field2249[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class177.field2251[var20] = var5 - 1;
                                 class177.field2253[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class177.field2249[var18 - 1][var19 - 1] = 3;
                                 class177.field2250[var18 - 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + (var15 - 1)] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && var19 > 0 && class177.field2249[var18 + 1][var19 - 1] == 0 && (var13[var14 + var2][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class177.field2251[var20] = var5 + 1;
                                 class177.field2253[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class177.field2249[var18 + 1][var19 - 1] = 9;
                                 class177.field2250[var18 + 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var17 + (var15 - 1)] & 19136995) != 0 || (var13[var14 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 < 128 - var2 && class177.field2249[var18 - 1][var19 + 1] == 0 && (var13[var14 - 1][var15 + var2] & 19136824) == 0) {
                           for(var17 = 1; var17 < var2; ++var17) {
                              if((var13[var14 - 1][var15 + var17] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 + var2] & 19137016) != 0) {
                                 continue label290;
                              }
                           }

                           class177.field2251[var20] = var5 - 1;
                           class177.field2253[var20] = var6 + 1;
                           var20 = var20 + 1 & 4095;
                           class177.field2249[var18 - 1][var19 + 1] = 6;
                           class177.field2250[var18 - 1][var19 + 1] = var16;
                        }
                     } while(var18 >= 128 - var2);
                  } while(var19 >= 128 - var2);
               } while(class177.field2249[var18 + 1][var19 + 1] != 0);
            } while((var13[var14 + var2][var15 + var2] & 19136992) != 0);

            for(var17 = 1; var17 < var2; ++var17) {
               if((var13[var14 + var17][var15 + var2] & 19137016) != 0 || (var13[var14 + var2][var17 + var15] & 19136995) != 0) {
                  continue label313;
               }
            }

            class177.field2251[var20] = var5 + 1;
            class177.field2253[var20] = var6 + 1;
            var20 = var20 + 1 & 4095;
            class177.field2249[var18 + 1][var19 + 1] = 12;
            class177.field2250[var18 + 1][var19 + 1] = var16;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1352493722"
   )
   public static void method1195() {
      class279.field3555.reset();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-393992792"
   )
   static int method1199(int var0) {
      MessageNode var1 = (MessageNode)class95.messages.get((long)var0);
      return var1 == null?-1:(var1.next == class95.field1421.sentinel?-1:((MessageNode)var1.next).id);
   }
}
