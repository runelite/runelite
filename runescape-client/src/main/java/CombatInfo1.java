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
      int var13 = var11 + 1;
      class162.field2319[var11] = var1;
      int[][] var14 = var4.flags;

      label204:
      while(var13 != var12) {
         var5 = class162.field2318[var12];
         var6 = class162.field2319[var12];
         var12 = var12 + 1 & 4095;
         int var19 = var5 - var9;
         int var20 = var6 - var10;
         int var15 = var5 - var4.x;
         int var16 = var6 - var4.y;
         if(var3.vmethod3051(var2, var5, var6, var4)) {
            class267.field3678 = var5;
            class162.field2313 = var6;
            return true;
         }

         int var17 = class162.field2316[var19][var20] + 1;
         int var18;
         if(var19 > 0 && class162.field2315[var19 - 1][var20] == 0 && (var14[var15 - 1][var16] & 19136782) == 0 && (var14[var15 - 1][var16 + var2 - 1] & 19136824) == 0) {
            var18 = 1;

            while(true) {
               if(var18 >= var2 - 1) {
                  class162.field2318[var13] = var5 - 1;
                  class162.field2319[var13] = var6;
                  var13 = var13 + 1 & 4095;
                  class162.field2315[var19 - 1][var20] = 2;
                  class162.field2316[var19 - 1][var20] = var17;
                  break;
               }

               if((var14[var15 - 1][var18 + var16] & 19136830) != 0) {
                  break;
               }

               ++var18;
            }
         }

         if(var19 < 128 - var2 && class162.field2315[1 + var19][var20] == 0 && (var14[var2 + var15][var16] & 19136899) == 0 && (var14[var15 + var2][var2 + var16 - 1] & 19136992) == 0) {
            var18 = 1;

            while(true) {
               if(var18 >= var2 - 1) {
                  class162.field2318[var13] = var5 + 1;
                  class162.field2319[var13] = var6;
                  var13 = var13 + 1 & 4095;
                  class162.field2315[var19 + 1][var20] = 8;
                  class162.field2316[var19 + 1][var20] = var17;
                  break;
               }

               if((var14[var2 + var15][var18 + var16] & 19136995) != 0) {
                  break;
               }

               ++var18;
            }
         }

         if(var20 > 0 && class162.field2315[var19][var20 - 1] == 0 && (var14[var15][var16 - 1] & 19136782) == 0 && (var14[var2 + var15 - 1][var16 - 1] & 19136899) == 0) {
            var18 = 1;

            while(true) {
               if(var18 >= var2 - 1) {
                  class162.field2318[var13] = var5;
                  class162.field2319[var13] = var6 - 1;
                  var13 = var13 + 1 & 4095;
                  class162.field2315[var19][var20 - 1] = 1;
                  class162.field2316[var19][var20 - 1] = var17;
                  break;
               }

               if((var14[var18 + var15][var16 - 1] & 19136911) != 0) {
                  break;
               }

               ++var18;
            }
         }

         if(var20 < 128 - var2 && class162.field2315[var19][var20 + 1] == 0 && (var14[var15][var16 + var2] & 19136824) == 0 && (var14[var2 + var15 - 1][var16 + var2] & 19136992) == 0) {
            var18 = 1;

            while(true) {
               if(var18 >= var2 - 1) {
                  class162.field2318[var13] = var5;
                  class162.field2319[var13] = var6 + 1;
                  var13 = var13 + 1 & 4095;
                  class162.field2315[var19][var20 + 1] = 4;
                  class162.field2316[var19][var20 + 1] = var17;
                  break;
               }

               if((var14[var18 + var15][var16 + var2] & 19137016) != 0) {
                  break;
               }

               ++var18;
            }
         }

         if(var19 > 0 && var20 > 0 && class162.field2315[var19 - 1][var20 - 1] == 0 && (var14[var15 - 1][var16 - 1] & 19136782) == 0) {
            var18 = 1;

            while(true) {
               if(var18 >= var2) {
                  class162.field2318[var13] = var5 - 1;
                  class162.field2319[var13] = var6 - 1;
                  var13 = var13 + 1 & 4095;
                  class162.field2315[var19 - 1][var20 - 1] = 3;
                  class162.field2316[var19 - 1][var20 - 1] = var17;
                  break;
               }

               if((var14[var15 - 1][var18 + (var16 - 1)] & 19136830) != 0 || (var14[var18 + (var15 - 1)][var16 - 1] & 19136911) != 0) {
                  break;
               }

               ++var18;
            }
         }

         if(var19 < 128 - var2 && var20 > 0 && class162.field2315[var19 + 1][var20 - 1] == 0 && (var14[var2 + var15][var16 - 1] & 19136899) == 0) {
            var18 = 1;

            while(true) {
               if(var18 >= var2) {
                  class162.field2318[var13] = var5 + 1;
                  class162.field2319[var13] = var6 - 1;
                  var13 = var13 + 1 & 4095;
                  class162.field2315[var19 + 1][var20 - 1] = 9;
                  class162.field2316[var19 + 1][var20 - 1] = var17;
                  break;
               }

               if((var14[var2 + var15][var16 - 1 + var18] & 19136995) != 0 || (var14[var18 + var15][var16 - 1] & 19136911) != 0) {
                  break;
               }

               ++var18;
            }
         }

         if(var19 > 0 && var20 < 128 - var2 && class162.field2315[var19 - 1][var20 + 1] == 0 && (var14[var15 - 1][var16 + var2] & 19136824) == 0) {
            var18 = 1;

            while(true) {
               if(var18 >= var2) {
                  class162.field2318[var13] = var5 - 1;
                  class162.field2319[var13] = var6 + 1;
                  var13 = var13 + 1 & 4095;
                  class162.field2315[var19 - 1][var20 + 1] = 6;
                  class162.field2316[var19 - 1][var20 + 1] = var17;
                  break;
               }

               if((var14[var15 - 1][var16 + var18] & 19136830) != 0 || (var14[var18 + (var15 - 1)][var16 + var2] & 19137016) != 0) {
                  break;
               }

               ++var18;
            }
         }

         if(var19 < 128 - var2 && var20 < 128 - var2 && class162.field2315[var19 + 1][var20 + 1] == 0 && (var14[var2 + var15][var16 + var2] & 19136992) == 0) {
            for(var18 = 1; var18 < var2; ++var18) {
               if((var14[var18 + var15][var16 + var2] & 19137016) != 0 || (var14[var2 + var15][var18 + var16] & 19136995) != 0) {
                  continue label204;
               }
            }

            class162.field2318[var13] = var5 + 1;
            class162.field2319[var13] = var6 + 1;
            var13 = var13 + 1 & 4095;
            class162.field2315[var19 + 1][var20 + 1] = 12;
            class162.field2316[var19 + 1][var20 + 1] = var17;
         }
      }

      class267.field3678 = var5;
      class162.field2313 = var6;
      return false;
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
