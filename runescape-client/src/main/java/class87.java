import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("WallObject")
public final class class87 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 895161609
   )
   @Export("x")
   int field1532;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1719090315
   )
   @Export("y")
   int field1533;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 165494509
   )
   int field1534;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1091945181
   )
   int field1535;
   @ObfuscatedName("d")
   @Export("renderable1")
   public class85 field1536;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1188699187
   )
   @Export("floor")
   int field1538;
   @ObfuscatedName("n")
   @Export("renderable2")
   public class85 field1539;
   @ObfuscatedName("eq")
   static class78[] field1541;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2032151161
   )
   int field1543 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1564049411
   )
   @Export("hash")
   public int field1544 = 0;

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(IIIIIIIS)V",
      garbageValue = "7327"
   )
   static final void method2137(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(client.field296 && var0 != class14.field212) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class129.field2056.method2001(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class129.field2056.method1990(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class129.field2056.method2111(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class129.field2056.method1979(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class129.field2056.method2094(var0, var2, var3, var7);
            int var13 = var7 >> 14 & 32767;
            int var14 = var11 & 31;
            int var15 = var11 >> 6 & 3;
            class40 var12;
            if(var1 == 0) {
               class129.field2056.method1992(var0, var2, var3);
               var12 = class150.method3166(var13);
               if(var12.field953 != 0) {
                  client.field350[var0].method2448(var2, var3, var14, var15, var12.field954);
               }
            }

            if(var1 == 1) {
               class129.field2056.method1993(var0, var2, var3);
            }

            if(var1 == 2) {
               class129.field2056.method1994(var0, var2, var3);
               var12 = class150.method3166(var13);
               if(var2 + var12.field945 > 103 || var3 + var12.field945 > 103 || var2 + var12.field937 > 103 || var12.field937 + var3 > 103) {
                  return;
               }

               if(var12.field953 != 0) {
                  client.field350[var0].method2457(var2, var3, var12.field945, var12.field937, var15, var12.field954);
               }
            }

            if(var1 == 3) {
               class129.field2056.method1978(var0, var2, var3);
               var12 = class150.method3166(var13);
               if(var12.field953 == 1) {
                  client.field350[var0].method2441(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class5.field82[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            class47.method1036(var0, var11, var2, var3, var4, var5, var6, class129.field2056, client.field350[var0]);
         }
      }

   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(Lclass39;IIII)V",
      garbageValue = "516728451"
   )
   static final void method2138(class39 var0, int var1, int var2, int var3) {
      if(client.field429 < 400) {
         if(var0.field910 != null) {
            var0 = var0.method813();
         }

         if(var0 != null) {
            if(var0.field926) {
               if(!var0.field928 || client.field332 == var1) {
                  String var4 = var0.field905;
                  if(var0.field930 != 0) {
                     var4 = var4 + class13.method171(var0.field930, class15.field225.field40) + " " + " (" + "level-" + var0.field930 + ")";
                  }

                  if(client.field353 == 1) {
                     class154.method3182("Use", client.field441 + " " + "->" + " " + class164.method3251(16776960) + var4, 7, var1, var2, var3);
                  } else if(client.field442) {
                     if((class84.field1465 & 2) == 2) {
                        class154.method3182(client.field445, client.field446 + " " + "->" + " " + class164.method3251(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     String[] var5 = var0.field894;
                     if(client.field458) {
                        var5 = class18.method207(var5);
                     }

                     int var6;
                     if(null != var5) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(null != var5[var6] && !var5[var6].equalsIgnoreCase("Attack")) {
                              byte var7 = 0;
                              if(var6 == 0) {
                                 var7 = 9;
                              }

                              if(var6 == 1) {
                                 var7 = 10;
                              }

                              if(var6 == 2) {
                                 var7 = 11;
                              }

                              if(var6 == 3) {
                                 var7 = 12;
                              }

                              if(var6 == 4) {
                                 var7 = 13;
                              }

                              class154.method3182(var5[var6], class164.method3251(16776960) + var4, var7, var1, var2, var3);
                           }
                        }
                     }

                     if(null != var5) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(null != var5[var6] && var5[var6].equalsIgnoreCase("Attack")) {
                              short var9 = 0;
                              if(client.field319 != class20.field575) {
                                 if(client.field319 == class20.field574 || client.field319 == class20.field573 && var0.field930 > class15.field225.field40) {
                                    var9 = 2000;
                                 }

                                 int var8 = 0;
                                 if(var6 == 0) {
                                    var8 = var9 + 9;
                                 }

                                 if(var6 == 1) {
                                    var8 = var9 + 10;
                                 }

                                 if(var6 == 2) {
                                    var8 = var9 + 11;
                                 }

                                 if(var6 == 3) {
                                    var8 = 12 + var9;
                                 }

                                 if(var6 == 4) {
                                    var8 = var9 + 13;
                                 }

                                 class154.method3182(var5[var6], class164.method3251(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     class154.method3182("Examine", class164.method3251(16776960) + var4, 1003, var1, var2, var3);
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-182882235"
   )
   static void method2139(int var0, int var1, int var2) {
      if(client.field492 != 0 && var1 != 0 && client.field554 < 50) {
         client.field531[client.field554] = var0;
         client.field532[client.field554] = var1;
         client.field533[client.field554] = var2;
         client.field392[client.field554] = null;
         client.field521[client.field554] = 0;
         ++client.field554;
      }

   }
}
