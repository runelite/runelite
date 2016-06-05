import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public class class171 {
   @ObfuscatedName("b")
   static class119 field2741 = new class119(8);
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = -1676135289406859583L
   )
   static long field2742;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 484629843
   )
   static int field2743 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1802757311
   )
   static int field2744 = 0;
   @ObfuscatedName("r")
   static class196 field2745 = new class196(32);
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 150703943
   )
   static int field2746 = 0;
   @ObfuscatedName("s")
   static class203 field2747 = new class203();
   @ObfuscatedName("d")
   static class196 field2748 = new class196(4096);
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -445934403
   )
   static int field2749 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1631161453
   )
   static int field2750 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1408339535
   )
   static int field2751 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -593441721
   )
   public static int field2752 = 0;
   @ObfuscatedName("h")
   static class196 field2753 = new class196(4096);
   @ObfuscatedName("y")
   static class196 field2754 = new class196(4096);
   @ObfuscatedName("c")
   static CRC32 field2755 = new CRC32();
   @ObfuscatedName("q")
   static class168[] field2756 = new class168[256];
   @ObfuscatedName("x")
   static byte field2757 = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1216327561
   )
   public static int field2758 = 0;
   @ObfuscatedName("o")
   static class172 field2759;

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-78"
   )
   static final void method3361(int var0, int var1, int var2, int var3) {
      if(client.field379 == 0 && !client.field437) {
         class2.method33("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      int var4 = -1;
      int var5 = -1;

      int var6;
      int var7;
      for(var6 = 0; var6 < class105.field1863; ++var6) {
         var7 = class105.field1864[var6];
         int var8 = var7 & 127;
         int var9 = var7 >> 7 & 127;
         int var10 = var7 >> 29 & 3;
         int var11 = var7 >> 14 & 32767;
         if(var7 != var5) {
            var5 = var7;
            if(var10 == 2 && class214.field3161.method1994(class32.field754, var8, var9, var7) >= 0) {
               class40 var12 = class49.method980(var11);
               if(var12.field955 != null) {
                  var12 = var12.method798();
               }

               if(null == var12) {
                  continue;
               }

               if(client.field379 == 1) {
                  class2.method33("Use", client.field463 + " " + "->" + " " + class155.method3132('\uffff') + var12.field963, 1, var7, var8, var9);
               } else if(client.field437) {
                  if((class3.field69 & 4) == 4) {
                     class2.method33(client.field432, client.field441 + " " + "->" + " " + class155.method3132('\uffff') + var12.field963, 2, var7, var8, var9);
                  }
               } else {
                  String[] var13 = var12.field941;
                  if(client.field453) {
                     var13 = class125.method2765(var13);
                  }

                  if(null != var13) {
                     for(int var19 = 4; var19 >= 0; --var19) {
                        if(var13[var19] != null) {
                           short var15 = 0;
                           if(var19 == 0) {
                              var15 = 3;
                           }

                           if(var19 == 1) {
                              var15 = 4;
                           }

                           if(var19 == 2) {
                              var15 = 5;
                           }

                           if(var19 == 3) {
                              var15 = 6;
                           }

                           if(var19 == 4) {
                              var15 = 1001;
                           }

                           class2.method33(var13[var19], class155.method3132('\uffff') + var12.field963, var15, var7, var8, var9);
                        }
                     }
                  }

                  class2.method33("Examine", class155.method3132('\uffff') + var12.field963, 1002, var12.field921 << 14, var8, var9);
               }
            }

            class34 var14;
            class2 var16;
            int var20;
            int[] var27;
            int var29;
            if(var10 == 1) {
               class34 var23 = client.field320[var11];
               if(var23 == null) {
                  continue;
               }

               if(var23.field772.field881 == 1 && (var23.field809 & 127) == 64 && (var23.field804 & 127) == 64) {
                  for(var20 = 0; var20 < client.field293; ++var20) {
                     var14 = client.field320[client.field322[var20]];
                     if(var14 != null && var23 != var14 && var14.field772.field881 == 1 && var14.field809 == var23.field809 && var23.field804 == var14.field804) {
                        class38.method742(var14.field772, client.field322[var20], var8, var9);
                     }
                  }

                  var20 = class32.field741;
                  var27 = class32.field742;

                  for(var29 = 0; var29 < var20; ++var29) {
                     var16 = client.field405[var27[var29]];
                     if(var16 != null && var23.field809 == var16.field809 && var23.field804 == var16.field804) {
                        class119.method2669(var16, var27[var29], var8, var9);
                     }
                  }
               }

               class38.method742(var23.field772, var11, var8, var9);
            }

            if(var10 == 0) {
               class2 var24 = client.field405[var11];
               if(null == var24) {
                  continue;
               }

               if((var24.field809 & 127) == 64 && (var24.field804 & 127) == 64) {
                  for(var20 = 0; var20 < client.field293; ++var20) {
                     var14 = client.field320[client.field322[var20]];
                     if(var14 != null && var14.field772.field881 == 1 && var24.field809 == var14.field809 && var14.field804 == var24.field804) {
                        class38.method742(var14.field772, client.field322[var20], var8, var9);
                     }
                  }

                  var20 = class32.field741;
                  var27 = class32.field742;

                  for(var29 = 0; var29 < var20; ++var29) {
                     var16 = client.field405[var27[var29]];
                     if(null != var16 && var16 != var24 && var16.field809 == var24.field809 && var24.field804 == var16.field804) {
                        class119.method2669(var16, var27[var29], var8, var9);
                     }
                  }
               }

               if(var11 != client.field484) {
                  class119.method2669(var24, var11, var8, var9);
               } else {
                  var4 = var7;
               }
            }

            if(var10 == 3) {
               class199 var25 = client.field415[class32.field754][var8][var9];
               if(var25 != null) {
                  for(class28 var26 = (class28)var25.method3777(); var26 != null; var26 = (class28)var25.method3780()) {
                     class51 var28 = class123.method2743(var26.field677);
                     if(client.field379 == 1) {
                        class2.method33("Use", client.field463 + " " + "->" + " " + class155.method3132(16748608) + var28.field1120, 16, var26.field677, var8, var9);
                     } else if(client.field437) {
                        if((class3.field69 & 1) == 1) {
                           class2.method33(client.field432, client.field441 + " " + "->" + " " + class155.method3132(16748608) + var28.field1120, 17, var26.field677, var8, var9);
                        }
                     } else {
                        String[] var18 = var28.field1155;
                        if(client.field453) {
                           var18 = class125.method2765(var18);
                        }

                        for(int var21 = 4; var21 >= 0; --var21) {
                           if(null != var18 && var18[var21] != null) {
                              byte var17 = 0;
                              if(var21 == 0) {
                                 var17 = 18;
                              }

                              if(var21 == 1) {
                                 var17 = 19;
                              }

                              if(var21 == 2) {
                                 var17 = 20;
                              }

                              if(var21 == 3) {
                                 var17 = 21;
                              }

                              if(var21 == 4) {
                                 var17 = 22;
                              }

                              class2.method33(var18[var21], class155.method3132(16748608) + var28.field1120, var17, var26.field677, var8, var9);
                           } else if(var21 == 2) {
                              class2.method33("Take", class155.method3132(16748608) + var28.field1120, 20, var26.field677, var8, var9);
                           }
                        }

                        class2.method33("Examine", class155.method3132(16748608) + var28.field1120, 1004, var26.field677, var8, var9);
                     }
                  }
               }
            }
         }
      }

      if(var4 != -1) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         class2 var22 = client.field405[client.field484];
         class119.method2669(var22, client.field484, var6, var7);
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "46"
   )
   public static boolean method3362(int var0) {
      return (var0 >> 28 & 1) != 0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass0;B)V",
      garbageValue = "-115"
   )
   static void method3363(class0 var0) {
      class28.method637(var0, 200000);
   }
}
