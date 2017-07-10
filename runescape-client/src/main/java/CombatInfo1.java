import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 63353667
   )
   int field1298;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 183726871
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1755114161
   )
   @Export("health")
   int health;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -232134091
   )
   int field1301;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIILclass163;LCollisionData;I)Z",
      garbageValue = "-547836346"
   )
   static final boolean method1559(int var0, int var1, int var2, class163 var3, CollisionData var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class162.field2315[var7][var8] = 99;
      class162.field2316[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class162.field2318[var11] = var0;
      int var20 = var11 + 1;
      class162.field2319[var11] = var1;
      int[][] var13 = var4.flags;

      while(true) {
         label305:
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
                     label282:
                     do {
                        if(var20 == var12) {
                           class267.field3678 = var5;
                           class162.field2313 = var6;
                           return false;
                        }

                        var5 = class162.field2318[var12];
                        var6 = class162.field2319[var12];
                        var12 = var12 + 1 & 4095;
                        var18 = var5 - var9;
                        var19 = var6 - var10;
                        var14 = var5 - var4.x;
                        var15 = var6 - var4.y;
                        if(var3.vmethod3051(var2, var5, var6, var4)) {
                           class267.field3678 = var5;
                           class162.field2313 = var6;
                           return true;
                        }

                        var16 = class162.field2316[var18][var19] + 1;
                        if(var18 > 0 && class162.field2315[var18 - 1][var19] == 0 && (var13[var14 - 1][var15] & 19136782) == 0 && (var13[var14 - 1][var15 + var2 - 1] & 19136824) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class162.field2318[var20] = var5 - 1;
                                 class162.field2319[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2315[var18 - 1][var19] = 2;
                                 class162.field2316[var18 - 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + var15] & 19136830) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && class162.field2315[1 + var18][var19] == 0 && (var13[var2 + var14][var15] & 19136899) == 0 && (var13[var14 + var2][var2 + var15 - 1] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class162.field2318[var20] = var5 + 1;
                                 class162.field2319[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2315[var18 + 1][var19] = 8;
                                 class162.field2316[var18 + 1][var19] = var16;
                                 break;
                              }

                              if((var13[var2 + var14][var17 + var15] & 19136995) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 > 0 && class162.field2315[var18][var19 - 1] == 0 && (var13[var14][var15 - 1] & 19136782) == 0 && (var13[var2 + var14 - 1][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class162.field2318[var20] = var5;
                                 class162.field2319[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2315[var18][var19 - 1] = 1;
                                 class162.field2316[var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 < 128 - var2 && class162.field2315[var18][var19 + 1] == 0 && (var13[var14][var15 + var2] & 19136824) == 0 && (var13[var2 + var14 - 1][var15 + var2] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class162.field2318[var20] = var5;
                                 class162.field2319[var20] = var6 + 1;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2315[var18][var19 + 1] = 4;
                                 class162.field2316[var18][var19 + 1] = var16;
                                 break;
                              }

                              if((var13[var17 + var14][var15 + var2] & 19137016) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 > 0 && class162.field2315[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class162.field2318[var20] = var5 - 1;
                                 class162.field2319[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2315[var18 - 1][var19 - 1] = 3;
                                 class162.field2316[var18 - 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + (var15 - 1)] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && var19 > 0 && class162.field2315[var18 + 1][var19 - 1] == 0 && (var13[var2 + var14][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class162.field2318[var20] = var5 + 1;
                                 class162.field2319[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2315[var18 + 1][var19 - 1] = 9;
                                 class162.field2316[var18 + 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var2 + var14][var15 - 1 + var17] & 19136995) != 0 || (var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 < 128 - var2 && class162.field2315[var18 - 1][var19 + 1] == 0 && (var13[var14 - 1][var15 + var2] & 19136824) == 0) {
                           for(var17 = 1; var17 < var2; ++var17) {
                              if((var13[var14 - 1][var15 + var17] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 + var2] & 19137016) != 0) {
                                 continue label282;
                              }
                           }

                           class162.field2318[var20] = var5 - 1;
                           class162.field2319[var20] = var6 + 1;
                           var20 = var20 + 1 & 4095;
                           class162.field2315[var18 - 1][var19 + 1] = 6;
                           class162.field2316[var18 - 1][var19 + 1] = var16;
                        }
                     } while(var18 >= 128 - var2);
                  } while(var19 >= 128 - var2);
               } while(class162.field2315[var18 + 1][var19 + 1] != 0);
            } while((var13[var2 + var14][var15 + var2] & 19136992) != 0);

            for(var17 = 1; var17 < var2; ++var17) {
               if((var13[var17 + var14][var15 + var2] & 19137016) != 0 || (var13[var2 + var14][var17 + var15] & 19136995) != 0) {
                  continue label305;
               }
            }

            class162.field2318[var20] = var5 + 1;
            class162.field2319[var20] = var6 + 1;
            var20 = var20 + 1 & 4095;
            class162.field2315[var18 + 1][var19 + 1] = 12;
            class162.field2316[var18 + 1][var19 + 1] = var16;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1508349394"
   )
   void method1560(int var1, int var2, int var3, int var4) {
      this.field1298 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1301 = var4;
   }

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.field1298 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1301 = var4;
   }
}
