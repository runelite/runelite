import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
public class class112 {
   @ObfuscatedName("cr")
   static class227 field1962;
   @ObfuscatedName("kc")
   static class134 field1965;

   static {
      new HashMap();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass0;I)V",
      garbageValue = "-1156849610"
   )
   static void method2452(class0 var0) {
      class26.method613(var0, 200000);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIILclass110;LCollisionData;I)Z",
      garbageValue = "-1425401583"
   )
   public static final boolean method2453(int var0, int var1, int var2, class110 var3, CollisionData var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class109.field1927[var7][var8] = 99;
      class109.field1925[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class109.field1932[var11] = var0;
      int var20 = var11 + 1;
      class109.field1933[var11] = var1;
      int[][] var13 = var4.flags;

      while(true) {
         label349:
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
                     label326:
                     do {
                        if(var12 == var20) {
                           FileOnDisk.field3264 = var5;
                           class109.field1929 = var6;
                           return false;
                        }

                        var5 = class109.field1932[var12];
                        var6 = class109.field1933[var12];
                        var12 = 1 + var12 & 4095;
                        var18 = var5 - var9;
                        var19 = var6 - var10;
                        var14 = var5 - var4.x;
                        var15 = var6 - var4.y;
                        if(var3.vmethod2401(var2, var5, var6, var4)) {
                           FileOnDisk.field3264 = var5;
                           class109.field1929 = var6;
                           return true;
                        }

                        var16 = class109.field1925[var18][var19] + 1;
                        if(var18 > 0 && class109.field1927[var18 - 1][var19] == 0 && (var13[var14 - 1][var15] & 19136782) == 0 && (var13[var14 - 1][var15 + var2 - 1] & 19136824) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class109.field1932[var20] = var5 - 1;
                                 class109.field1933[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class109.field1927[var18 - 1][var19] = 2;
                                 class109.field1925[var18 - 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var15 + var17] & 19136830) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && class109.field1927[var18 + 1][var19] == 0 && (var13[var14 + var2][var15] & 19136899) == 0 && (var13[var2 + var14][var2 + var15 - 1] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class109.field1932[var20] = 1 + var5;
                                 class109.field1933[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class109.field1927[var18 + 1][var19] = 8;
                                 class109.field1925[1 + var18][var19] = var16;
                                 break;
                              }

                              if((var13[var2 + var14][var15 + var17] & 19136995) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 > 0 && class109.field1927[var18][var19 - 1] == 0 && (var13[var14][var15 - 1] & 19136782) == 0 && (var13[var2 + var14 - 1][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class109.field1932[var20] = var5;
                                 class109.field1933[var20] = var6 - 1;
                                 var20 = 1 + var20 & 4095;
                                 class109.field1927[var18][var19 - 1] = 1;
                                 class109.field1925[var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 < 128 - var2 && class109.field1927[var18][1 + var19] == 0 && (var13[var14][var2 + var15] & 19136824) == 0 && (var13[var14 + var2 - 1][var2 + var15] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class109.field1932[var20] = var5;
                                 class109.field1933[var20] = 1 + var6;
                                 var20 = var20 + 1 & 4095;
                                 class109.field1927[var18][var19 + 1] = 4;
                                 class109.field1925[var18][1 + var19] = var16;
                                 break;
                              }

                              if((var13[var17 + var14][var15 + var2] & 19137016) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 > 0 && class109.field1927[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class109.field1932[var20] = var5 - 1;
                                 class109.field1933[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class109.field1927[var18 - 1][var19 - 1] = 3;
                                 class109.field1925[var18 - 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var15 - 1 + var17] & 19136830) != 0 || (var13[var14 - 1 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && var19 > 0 && class109.field1927[1 + var18][var19 - 1] == 0 && (var13[var14 + var2][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class109.field1932[var20] = 1 + var5;
                                 class109.field1933[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class109.field1927[var18 + 1][var19 - 1] = 9;
                                 class109.field1925[1 + var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var15 - 1 + var17] & 19136995) != 0 || (var13[var14 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 < 128 - var2 && class109.field1927[var18 - 1][var19 + 1] == 0 && (var13[var14 - 1][var2 + var15] & 19136824) == 0) {
                           for(var17 = 1; var17 < var2; ++var17) {
                              if((var13[var14 - 1][var17 + var15] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 + var2] & 19137016) != 0) {
                                 continue label326;
                              }
                           }

                           class109.field1932[var20] = var5 - 1;
                           class109.field1933[var20] = 1 + var6;
                           var20 = 1 + var20 & 4095;
                           class109.field1927[var18 - 1][1 + var19] = 6;
                           class109.field1925[var18 - 1][1 + var19] = var16;
                        }
                     } while(var18 >= 128 - var2);
                  } while(var19 >= 128 - var2);
               } while(class109.field1927[1 + var18][var19 + 1] != 0);
            } while((var13[var14 + var2][var15 + var2] & 19136992) != 0);

            for(var17 = 1; var17 < var2; ++var17) {
               if((var13[var14 + var17][var15 + var2] & 19137016) != 0 || (var13[var14 + var2][var15 + var17] & 19136995) != 0) {
                  continue label349;
               }
            }

            class109.field1932[var20] = 1 + var5;
            class109.field1933[var20] = var6 + 1;
            var20 = var20 + 1 & 4095;
            class109.field1927[var18 + 1][var19 + 1] = 12;
            class109.field1925[1 + var18][1 + var19] = var16;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-74"
   )
   public static int method2454(int var0) {
      class50 var1 = class28.method652(var0);
      int var2 = var1.field1092;
      int var3 = var1.field1094;
      int var4 = var1.field1093;
      int var5 = class179.field2938[var4 - var3];
      return class179.widgetSettings[var2] >> var3 & var5;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-766016437"
   )
   public static void method2455() {
      class50.field1097.reset();
   }
}
