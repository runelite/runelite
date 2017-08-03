import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 392553165
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1916836089
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1500410127
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -375700539
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -627534129
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 183841345
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -231427583
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -748478637
   )
   @Export("x")
   int x;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1420270517
   )
   @Export("y")
   int y;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -606817767
   )
   @Export("height")
   int height;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lep;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -696259291
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 743726579
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -160514185
   )
   @Export("drawPriority")
   int drawPriority;

   GameObject() {
      this.hash = 0;
      this.flags = 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIILfu;Lfl;I)Z",
      garbageValue = "501786969"
   )
   public static final boolean method2922(int var0, int var1, int var2, class163 var3, CollisionData var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class162.field2272[var7][var8] = 99;
      class162.field2273[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class162.field2271[var11] = var0;
      int var20 = var11 + 1;
      class162.field2282[var11] = var1;
      int[][] var13 = var4.flags;

      while(true) {
         label307:
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
                     label284:
                     do {
                        if(var20 == var12) {
                           class162.field2277 = var5;
                           class98.field1497 = var6;
                           return false;
                        }

                        var5 = class162.field2271[var12];
                        var6 = class162.field2282[var12];
                        var12 = var12 + 1 & 4095;
                        var18 = var5 - var9;
                        var19 = var6 - var10;
                        var14 = var5 - var4.x;
                        var15 = var6 - var4.y;
                        if(var3.vmethod3102(var2, var5, var6, var4)) {
                           class162.field2277 = var5;
                           class98.field1497 = var6;
                           return true;
                        }

                        var16 = class162.field2273[var18][var19] + 1;
                        if(var18 > 0 && class162.field2272[var18 - 1][var19] == 0 && (var13[var14 - 1][var15] & 19136782) == 0 && (var13[var14 - 1][var15 + var2 - 1] & 19136824) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class162.field2271[var20] = var5 - 1;
                                 class162.field2282[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2272[var18 - 1][var19] = 2;
                                 class162.field2273[var18 - 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var15 + var17] & 19136830) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && class162.field2272[var18 + 1][var19] == 0 && (var13[var14 + var2][var15] & 19136899) == 0 && 0 == (var13[var14 + var2][var15 + var2 - 1] & 19136992)) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class162.field2271[var20] = var5 + 1;
                                 class162.field2282[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2272[var18 + 1][var19] = 8;
                                 class162.field2273[var18 + 1][var19] = var16;
                                 break;
                              }

                              if(0 != (var13[var14 + var2][var17 + var15] & 19136995)) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 > 0 && class162.field2272[var18][var19 - 1] == 0 && (var13[var14][var15 - 1] & 19136782) == 0 && (var13[var14 + var2 - 1][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class162.field2271[var20] = var5;
                                 class162.field2282[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2272[var18][var19 - 1] = 1;
                                 class162.field2273[var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 < 128 - var2 && 0 == class162.field2272[var18][var19 + 1] && (var13[var14][var15 + var2] & 19136824) == 0 && 0 == (var13[var14 + var2 - 1][var15 + var2] & 19136992)) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class162.field2271[var20] = var5;
                                 class162.field2282[var20] = var6 + 1;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2272[var18][var19 + 1] = 4;
                                 class162.field2273[var18][var19 + 1] = var16;
                                 break;
                              }

                              if(0 != (var13[var14 + var17][var15 + var2] & 19137016)) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 > 0 && class162.field2272[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class162.field2271[var20] = var5 - 1;
                                 class162.field2282[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2272[var18 - 1][var19 - 1] = 3;
                                 class162.field2273[var18 - 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var15 - 1 + var17] & 19136830) != 0 || (var13[var14 - 1 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && var19 > 0 && class162.field2272[var18 + 1][var19 - 1] == 0 && (var13[var14 + var2][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class162.field2271[var20] = var5 + 1;
                                 class162.field2282[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2272[var18 + 1][var19 - 1] = 9;
                                 class162.field2273[var18 + 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var15 - 1 + var17] & 19136995) != 0 || (var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 < 128 - var2 && 0 == class162.field2272[var18 - 1][var19 + 1] && 0 == (var13[var14 - 1][var15 + var2] & 19136824)) {
                           for(var17 = 1; var17 < var2; ++var17) {
                              if((var13[var14 - 1][var17 + var15] & 19136830) != 0 || (var13[var14 - 1 + var17][var15 + var2] & 19137016) != 0) {
                                 continue label284;
                              }
                           }

                           class162.field2271[var20] = var5 - 1;
                           class162.field2282[var20] = var6 + 1;
                           var20 = var20 + 1 & 4095;
                           class162.field2272[var18 - 1][var19 + 1] = 6;
                           class162.field2273[var18 - 1][var19 + 1] = var16;
                        }
                     } while(var18 >= 128 - var2);
                  } while(var19 >= 128 - var2);
               } while(class162.field2272[var18 + 1][var19 + 1] != 0);
            } while((var13[var14 + var2][var15 + var2] & 19136992) != 0);

            for(var17 = 1; var17 < var2; ++var17) {
               if((var13[var17 + var14][var15 + var2] & 19137016) != 0 || 0 != (var13[var14 + var2][var15 + var17] & 19136995)) {
                  continue label307;
               }
            }

            class162.field2271[var20] = var5 + 1;
            class162.field2282[var20] = var6 + 1;
            var20 = var20 + 1 & 4095;
            class162.field2272[var18 + 1][var19 + 1] = 12;
            class162.field2273[var18 + 1][var19 + 1] = var16;
         }
      }
   }
}
