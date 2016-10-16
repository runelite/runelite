import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = -1851662003
   )
   @Export("modelHeight")
   public int modelHeight = 1000;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1819626921"
   )
   public static int method1905(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }

   @ObfuscatedName("ab")
   void vmethod2289(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(null != var10) {
         this.modelHeight = var10.modelHeight;
         var10.vmethod2289(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "-26"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIILclass110;LCollisionData;I)Z",
      garbageValue = "-243294061"
   )
   public static final boolean method1912(int var0, int var1, int var2, class110 var3, CollisionData var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class109.field1905[var7][var8] = 99;
      class109.field1906[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class109.field1912[var11] = var0;
      int var20 = var11 + 1;
      class109.field1915[var11] = var1;
      int[][] var13 = var4.flags;

      while(true) {
         label348:
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
                     label325:
                     do {
                        if(var20 == var12) {
                           class109.field1907 = var5;
                           class109.field1908 = var6;
                           return false;
                        }

                        var5 = class109.field1912[var12];
                        var6 = class109.field1915[var12];
                        var12 = 1 + var12 & 4095;
                        var18 = var5 - var9;
                        var19 = var6 - var10;
                        var14 = var5 - var4.x;
                        var15 = var6 - var4.y;
                        if(var3.vmethod2357(var2, var5, var6, var4)) {
                           class109.field1907 = var5;
                           class109.field1908 = var6;
                           return true;
                        }

                        var16 = 1 + class109.field1906[var18][var19];
                        if(var18 > 0 && class109.field1905[var18 - 1][var19] == 0 && (var13[var14 - 1][var15] & 19136782) == 0 && (var13[var14 - 1][var15 + var2 - 1] & 19136824) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class109.field1912[var20] = var5 - 1;
                                 class109.field1915[var20] = var6;
                                 var20 = 1 + var20 & 4095;
                                 class109.field1905[var18 - 1][var19] = 2;
                                 class109.field1906[var18 - 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var15 + var17] & 19136830) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && class109.field1905[var18 + 1][var19] == 0 && (var13[var14 + var2][var15] & 19136899) == 0 && (var13[var14 + var2][var2 + var15 - 1] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class109.field1912[var20] = var5 + 1;
                                 class109.field1915[var20] = var6;
                                 var20 = 1 + var20 & 4095;
                                 class109.field1905[1 + var18][var19] = 8;
                                 class109.field1906[1 + var18][var19] = var16;
                                 break;
                              }

                              if((var13[var2 + var14][var15 + var17] & 19136995) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 > 0 && class109.field1905[var18][var19 - 1] == 0 && (var13[var14][var15 - 1] & 19136782) == 0 && (var13[var14 + var2 - 1][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class109.field1912[var20] = var5;
                                 class109.field1915[var20] = var6 - 1;
                                 var20 = 1 + var20 & 4095;
                                 class109.field1905[var18][var19 - 1] = 1;
                                 class109.field1906[var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 < 128 - var2 && class109.field1905[var18][var19 + 1] == 0 && (var13[var14][var15 + var2] & 19136824) == 0 && (var13[var2 + var14 - 1][var15 + var2] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class109.field1912[var20] = var5;
                                 class109.field1915[var20] = var6 + 1;
                                 var20 = var20 + 1 & 4095;
                                 class109.field1905[var18][var19 + 1] = 4;
                                 class109.field1906[var18][1 + var19] = var16;
                                 break;
                              }

                              if((var13[var17 + var14][var2 + var15] & 19137016) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 > 0 && class109.field1905[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class109.field1912[var20] = var5 - 1;
                                 class109.field1915[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class109.field1905[var18 - 1][var19 - 1] = 3;
                                 class109.field1906[var18 - 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var15 - 1 + var17] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && var19 > 0 && class109.field1905[1 + var18][var19 - 1] == 0 && (var13[var14 + var2][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class109.field1912[var20] = var5 + 1;
                                 class109.field1915[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class109.field1905[1 + var18][var19 - 1] = 9;
                                 class109.field1906[1 + var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var15 - 1 + var17] & 19136995) != 0 || (var13[var14 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 < 128 - var2 && class109.field1905[var18 - 1][1 + var19] == 0 && (var13[var14 - 1][var2 + var15] & 19136824) == 0) {
                           for(var17 = 1; var17 < var2; ++var17) {
                              if((var13[var14 - 1][var15 + var17] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var2 + var15] & 19137016) != 0) {
                                 continue label325;
                              }
                           }

                           class109.field1912[var20] = var5 - 1;
                           class109.field1915[var20] = 1 + var6;
                           var20 = var20 + 1 & 4095;
                           class109.field1905[var18 - 1][1 + var19] = 6;
                           class109.field1906[var18 - 1][var19 + 1] = var16;
                        }
                     } while(var18 >= 128 - var2);
                  } while(var19 >= 128 - var2);
               } while(class109.field1905[var18 + 1][var19 + 1] != 0);
            } while((var13[var14 + var2][var2 + var15] & 19136992) != 0);

            for(var17 = 1; var17 < var2; ++var17) {
               if((var13[var14 + var17][var15 + var2] & 19137016) != 0 || (var13[var14 + var2][var15 + var17] & 19136995) != 0) {
                  continue label348;
               }
            }

            class109.field1912[var20] = var5 + 1;
            class109.field1915[var20] = var6 + 1;
            var20 = var20 + 1 & 4095;
            class109.field1905[var18 + 1][1 + var19] = 12;
            class109.field1906[var18 + 1][1 + var19] = var16;
         }
      }
   }
}
