import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
@Implements("VertexNormal")
public class class99 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 915771811
   )
   int field1700;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1815298021
   )
   int field1701;
   @ObfuscatedName("y")
   public static class231[] field1702;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -787241413
   )
   int field1703;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1460589671
   )
   int field1704;

   class99(class99 var1) {
      this.field1704 = var1.field1704;
      this.field1701 = var1.field1701;
      this.field1700 = var1.field1700;
      this.field1703 = var1.field1703;
   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(Lclass176;III)V",
      garbageValue = "-234511222"
   )
   static final void method2277(class176 var0, int var1, int var2) {
      if(var0.field2798 == 1) {
         class98.method2276(var0.field2912, "", 24, 0, 0, var0.field2795);
      }

      String var14;
      if(var0.field2798 == 2 && !client.field444) {
         var14 = class170.method3381(var0);
         if(var14 != null) {
            class98.method2276(var14, class51.method1096('\uff00') + var0.field2792, 25, 0, -1, var0.field2795);
         }
      }

      if(var0.field2798 == 3) {
         class98.method2276("Close", "", 26, 0, 0, var0.field2795);
      }

      if(var0.field2798 == 4) {
         class98.method2276(var0.field2912, "", 28, 0, 0, var0.field2795);
      }

      if(var0.field2798 == 5) {
         class98.method2276(var0.field2912, "", 29, 0, 0, var0.field2795);
      }

      if(var0.field2798 == 6 && null == client.field402) {
         class98.method2276(var0.field2912, "", 30, 0, -1, var0.field2795);
      }

      int var3;
      int var4;
      int var5;
      Object var10000;
      if(var0.field2929 == 2) {
         var3 = 0;

         for(var4 = 0; var4 < var0.field2877; ++var4) {
            for(var5 = 0; var5 < var0.field2926; ++var5) {
               int var6 = (var0.field2875 + 32) * var5;
               int var7 = (var0.field2862 + 32) * var4;
               if(var3 < 20) {
                  var6 += var0.field2810[var3];
                  var7 += var0.field2857[var3];
               }

               if(var1 >= var6 && var2 >= var7 && var1 < 32 + var6 && var2 < 32 + var7) {
                  client.field389 = var3;
                  class36.field801 = var0;
                  if(var0.field2869[var3] > 0) {
                     class55 var8 = class4.method42(var0.field2869[var3] - 1);
                     if(client.field531 == 1 && class25.method597(class12.method151(var0))) {
                        if(class162.field2664 != var0.field2795 || class24.field620 != var3) {
                           class98.method2276("Use", client.field424 + " " + "->" + " " + class51.method1096(16748608) + var8.field1183, 31, var8.field1181, var3, var0.field2795);
                        }
                     } else if(client.field444 && class25.method597(class12.method151(var0))) {
                        if((class116.field2016 & 16) == 16) {
                           class98.method2276(client.field428, client.field438 + " " + "->" + " " + class51.method1096(16748608) + var8.field1183, 32, var8.field1181, var3, var0.field2795);
                        }
                     } else {
                        String[] var9 = var8.field1198;
                        if(client.field441) {
                           var9 = class87.method1983(var9);
                        }

                        if(class25.method597(class12.method151(var0))) {
                           for(int var10 = 4; var10 >= 3; --var10) {
                              if(null != var9 && null != var9[var10]) {
                                 byte var11;
                                 if(var10 == 3) {
                                    var11 = 36;
                                 } else {
                                    var11 = 37;
                                 }

                                 class98.method2276(var9[var10], class51.method1096(16748608) + var8.field1183, var11, var8.field1181, var3, var0.field2795);
                              } else if(var10 == 4) {
                                 class98.method2276("Drop", class51.method1096(16748608) + var8.field1183, 37, var8.field1181, var3, var0.field2795);
                              }
                           }
                        }

                        int var19 = class12.method151(var0);
                        boolean var18 = (var19 >> 31 & 1) != 0;
                        if(var18) {
                           class98.method2276("Use", class51.method1096(16748608) + var8.field1183, 38, var8.field1181, var3, var0.field2795);
                        }

                        var10000 = null;
                        int var12;
                        byte var13;
                        if(class25.method597(class12.method151(var0)) && null != var9) {
                           for(var12 = 2; var12 >= 0; --var12) {
                              if(null != var9[var12]) {
                                 var13 = 0;
                                 if(var12 == 0) {
                                    var13 = 33;
                                 }

                                 if(var12 == 1) {
                                    var13 = 34;
                                 }

                                 if(var12 == 2) {
                                    var13 = 35;
                                 }

                                 class98.method2276(var9[var12], class51.method1096(16748608) + var8.field1183, var13, var8.field1181, var3, var0.field2795);
                              }
                           }
                        }

                        var9 = var0.field2911;
                        if(client.field441) {
                           var9 = class87.method1983(var9);
                        }

                        if(var9 != null) {
                           for(var12 = 4; var12 >= 0; --var12) {
                              if(var9[var12] != null) {
                                 var13 = 0;
                                 if(var12 == 0) {
                                    var13 = 39;
                                 }

                                 if(var12 == 1) {
                                    var13 = 40;
                                 }

                                 if(var12 == 2) {
                                    var13 = 41;
                                 }

                                 if(var12 == 3) {
                                    var13 = 42;
                                 }

                                 if(var12 == 4) {
                                    var13 = 43;
                                 }

                                 class98.method2276(var9[var12], class51.method1096(16748608) + var8.field1183, var13, var8.field1181, var3, var0.field2795);
                              }
                           }
                        }

                        class98.method2276("Examine", class51.method1096(16748608) + var8.field1183, 1005, var8.field1181, var3, var0.field2795);
                     }
                  }
               }

               ++var3;
            }
         }
      }

      if(var0.field2794) {
         if(client.field444) {
            if(class87.method1987(class12.method151(var0)) && (class116.field2016 & 32) == 32) {
               class98.method2276(client.field428, client.field438 + " " + "->" + " " + var0.field2868, 58, 0, var0.field2796, var0.field2795);
            }
         } else {
            for(var3 = 9; var3 >= 5; --var3) {
               String var15;
               if(!class151.method3170(class12.method151(var0), var3) && null == var0.field2895) {
                  var15 = null;
               } else if(null != var0.field2812 && var0.field2812.length > var3 && var0.field2812[var3] != null && var0.field2812[var3].trim().length() != 0) {
                  var15 = var0.field2812[var3];
               } else {
                  var15 = null;
               }

               var10000 = null;
            }

            var14 = class170.method3381(var0);
            if(var14 != null) {
               class98.method2276(var14, var0.field2868, 25, 0, var0.field2796, var0.field2795);
            }

            for(var4 = 4; var4 >= 0; --var4) {
               String var16 = class10.method127(var0, var4);
               if(var16 != null) {
                  class98.method2276(var16, var0.field2868, 57, var4 + 1, var0.field2796, var0.field2795);
               }
            }

            var5 = class12.method151(var0);
            boolean var17 = (var5 & 1) != 0;
            if(var17) {
               class98.method2276("Continue", "", 30, 0, var0.field2796, var0.field2795);
            }
         }
      }

   }

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-821620035"
   )
   static void method2278(int var0, int var1) {
      class56.method1198(class221.field3214, var0, var1);
      class221.field3214 = null;
   }

   class99() {
   }
}
