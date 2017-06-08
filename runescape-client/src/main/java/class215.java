import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hi")
public class class215 {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIILclass163;LCollisionData;I)Z",
      garbageValue = "1554184398"
   )
   public static final boolean method4008(int var0, int var1, int var2, class163 var3, CollisionData var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class162.field2311[var7][var8] = 99;
      class162.field2318[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class162.field2314[var11] = var0;
      int var20 = var11 + 1;
      class162.field2312[var11] = var1;
      int[][] var13 = var4.flags;

      while(true) {
         label357:
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
                     label334:
                     do {
                        if(var12 == var20) {
                           class162.field2310 = var5;
                           class2.field17 = var6;
                           return false;
                        }

                        var5 = class162.field2314[var12];
                        var6 = class162.field2312[var12];
                        var12 = var12 + 1 & 4095;
                        var18 = var5 - var9;
                        var19 = var6 - var10;
                        var14 = var5 - var4.x;
                        var15 = var6 - var4.y;
                        if(var3.vmethod3055(var2, var5, var6, var4)) {
                           class162.field2310 = var5;
                           class2.field17 = var6;
                           return true;
                        }

                        var16 = class162.field2318[var18][var19] + 1;
                        if(var18 > 0 && class162.field2311[var18 - 1][var19] == 0 && (var13[var14 - 1][var15] & 19136782) == 0 && (var13[var14 - 1][var15 + var2 - 1] & 19136824) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class162.field2314[var20] = var5 - 1;
                                 class162.field2312[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2311[var18 - 1][var19] = 2;
                                 class162.field2318[var18 - 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + var15] & 19136830) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && class162.field2311[var18 + 1][var19] == 0 && (var13[var14 + var2][var15] & 19136899) == 0 && (var13[var14 + var2][var15 + var2 - 1] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class162.field2314[var20] = var5 + 1;
                                 class162.field2312[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2311[var18 + 1][var19] = 8;
                                 class162.field2318[var18 + 1][var19] = var16;
                                 break;
                              }

                              if((var13[var2 + var14][var17 + var15] & 19136995) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 > 0 && class162.field2311[var18][var19 - 1] == 0 && (var13[var14][var15 - 1] & 19136782) == 0 && (var13[var14 + var2 - 1][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class162.field2314[var20] = var5;
                                 class162.field2312[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2311[var18][var19 - 1] = 1;
                                 class162.field2318[var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 < 128 - var2 && class162.field2311[var18][var19 + 1] == 0 && (var13[var14][var2 + var15] & 19136824) == 0 && (var13[var2 + var14 - 1][var2 + var15] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class162.field2314[var20] = var5;
                                 class162.field2312[var20] = var6 + 1;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2311[var18][var19 + 1] = 4;
                                 class162.field2318[var18][var19 + 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var17][var2 + var15] & 19137016) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 > 0 && class162.field2311[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class162.field2314[var20] = var5 - 1;
                                 class162.field2312[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2311[var18 - 1][var19 - 1] = 3;
                                 class162.field2318[var18 - 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + (var15 - 1)] & 19136830) != 0 || (var13[var14 - 1 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && var19 > 0 && class162.field2311[var18 + 1][var19 - 1] == 0 && (var13[var2 + var14][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class162.field2314[var20] = var5 + 1;
                                 class162.field2312[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2311[var18 + 1][var19 - 1] = 9;
                                 class162.field2318[var18 + 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var2 + var14][var17 + (var15 - 1)] & 19136995) != 0 || (var13[var14 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 < 128 - var2 && class162.field2311[var18 - 1][var19 + 1] == 0 && (var13[var14 - 1][var15 + var2] & 19136824) == 0) {
                           for(var17 = 1; var17 < var2; ++var17) {
                              if((var13[var14 - 1][var15 + var17] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 + var2] & 19137016) != 0) {
                                 continue label334;
                              }
                           }

                           class162.field2314[var20] = var5 - 1;
                           class162.field2312[var20] = var6 + 1;
                           var20 = var20 + 1 & 4095;
                           class162.field2311[var18 - 1][var19 + 1] = 6;
                           class162.field2318[var18 - 1][var19 + 1] = var16;
                        }
                     } while(var18 >= 128 - var2);
                  } while(var19 >= 128 - var2);
               } while(class162.field2311[var18 + 1][var19 + 1] != 0);
            } while((var13[var14 + var2][var15 + var2] & 19136992) != 0);

            for(var17 = 1; var17 < var2; ++var17) {
               if((var13[var17 + var14][var15 + var2] & 19137016) != 0 || (var13[var14 + var2][var17 + var15] & 19136995) != 0) {
                  continue label357;
               }
            }

            class162.field2314[var20] = var5 + 1;
            class162.field2312[var20] = var6 + 1;
            var20 = var20 + 1 & 4095;
            class162.field2311[var18 + 1][var19 + 1] = 12;
            class162.field2318[var18 + 1][var19 + 1] = var16;
         }
      }
   }
}
