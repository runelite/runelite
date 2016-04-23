import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
@Implements("Friend")
public class class17 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1859023779
   )
   @Export("world")
   int field237;
   @ObfuscatedName("h")
   @Export("previousName")
   String field238;
   @ObfuscatedName("j")
   @Export("name")
   String field239;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 27128449
   )
   int field240;
   @ObfuscatedName("x")
   boolean field241;
   @ObfuscatedName("e")
   boolean field242;
   @ObfuscatedName("fw")
   @ObfuscatedGetter(
      intValue = 2061911231
   )
   @Export("cameraYaw")
   static int field243;
   @ObfuscatedName("nd")
   static class56 field244;
   @ObfuscatedName("l")
   static class18 field245;

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "2"
   )
   static final int method187() {
      if(class4.field75.field145) {
         return class28.field655;
      } else {
         int var0 = 3;
         if(class154.field2276 < 310) {
            int var1 = class122.field1991 >> 7;
            int var2 = class24.field603 >> 7;
            int var3 = class47.field1053.field816 >> 7;
            int var4 = class47.field1053.field840 >> 7;
            if(var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
               return class28.field655;
            }

            if((class5.field84[class28.field655][var1][var2] & 4) != 0) {
               var0 = class28.field655;
            }

            int var5;
            if(var3 > var1) {
               var5 = var3 - var1;
            } else {
               var5 = var1 - var3;
            }

            int var6;
            if(var4 > var2) {
               var6 = var4 - var2;
            } else {
               var6 = var2 - var4;
            }

            int var7;
            int var8;
            if(var5 > var6) {
               var7 = var6 * 65536 / var5;
               var8 = '耀';

               while(var3 != var1) {
                  if(var1 < var3) {
                     ++var1;
                  } else if(var1 > var3) {
                     --var1;
                  }

                  if(0 != (class5.field84[class28.field655][var1][var2] & 4)) {
                     var0 = class28.field655;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var2 < var4) {
                        ++var2;
                     } else if(var2 > var4) {
                        --var2;
                     }

                     if(0 != (class5.field84[class28.field655][var1][var2] & 4)) {
                        var0 = class28.field655;
                     }
                  }
               }
            } else {
               var7 = var5 * 65536 / var6;
               var8 = '耀';

               while(var2 != var4) {
                  if(var2 < var4) {
                     ++var2;
                  } else if(var2 > var4) {
                     --var2;
                  }

                  if(0 != (class5.field84[class28.field655][var1][var2] & 4)) {
                     var0 = class28.field655;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var1 < var3) {
                        ++var1;
                     } else if(var1 > var3) {
                        --var1;
                     }

                     if(0 != (class5.field84[class28.field655][var1][var2] & 4)) {
                        var0 = class28.field655;
                     }
                  }
               }
            }
         }

         if(class47.field1053.field816 >= 0 && class47.field1053.field840 >= 0 && class47.field1053.field816 < 13312 && class47.field1053.field840 < 13312) {
            if((class5.field84[class28.field655][class47.field1053.field816 >> 7][class47.field1053.field840 >> 7] & 4) != 0) {
               var0 = class28.field655;
            }

            return var0;
         } else {
            return class28.field655;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)V",
      garbageValue = "1520602216"
   )
   static void method188(class122 var0, int var1) {
      boolean var2 = var0.method2737(1) == 1;
      if(var2) {
         class32.field745[++class32.field733 - 1] = var1;
      }

      int var3 = var0.method2737(2);
      class2 var4 = client.field396[var1];
      if(0 == var3) {
         if(var2) {
            var4.field59 = false;
         } else if(client.field397 == var1) {
            throw new RuntimeException();
         } else {
            class32.field741[var1] = (var4.field57 << 28) + (var4.field848[0] + class187.field3014 >> 6 << 14) + (var4.field822[0] + class0.field12 >> 6);
            if(var4.field821 != -1) {
               class32.field742[var1] = var4.field821;
            } else {
               class32.field742[var1] = var4.field844;
            }

            class32.field743[var1] = var4.field819;
            client.field396[var1] = null;
            if(var0.method2737(1) != 0) {
               class84.method1892(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method2737(3);
            var6 = var4.field848[0];
            var7 = var4.field822[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(1 == var5) {
               --var7;
            } else if(2 == var5) {
               ++var6;
               --var7;
            } else if(3 == var5) {
               --var6;
            } else if(4 == var5) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(var1 == client.field397 && (var4.field816 < 1536 || var4.field840 < 1536 || var4.field816 >= 11776 || var4.field840 >= 11776)) {
               var4.method13(var6, var7);
               var4.field59 = false;
            } else if(var2) {
               var4.field59 = true;
               var4.field60 = var6;
               var4.field51 = var7;
            } else {
               var4.field59 = false;
               var4.method26(var6, var7, class32.field735[var1]);
            }

         } else if(2 == var3) {
            var5 = var0.method2737(4);
            var6 = var4.field848[0];
            var7 = var4.field822[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(1 == var5) {
               --var6;
               var7 -= 2;
            } else if(2 == var5) {
               var7 -= 2;
            } else if(3 == var5) {
               ++var6;
               var7 -= 2;
            } else if(4 == var5) {
               var6 += 2;
               var7 -= 2;
            } else if(5 == var5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(8 == var5) {
               var6 += 2;
            } else if(9 == var5) {
               var6 -= 2;
               ++var7;
            } else if(10 == var5) {
               var6 += 2;
               ++var7;
            } else if(11 == var5) {
               var6 -= 2;
               var7 += 2;
            } else if(12 == var5) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(14 == var5) {
               ++var6;
               var7 += 2;
            } else if(15 == var5) {
               var6 += 2;
               var7 += 2;
            }

            if(var1 == client.field397 && (var4.field816 < 1536 || var4.field840 < 1536 || var4.field816 >= 11776 || var4.field840 >= 11776)) {
               var4.method13(var6, var7);
               var4.field59 = false;
            } else if(var2) {
               var4.field59 = true;
               var4.field60 = var6;
               var4.field51 = var7;
            } else {
               var4.field59 = false;
               var4.method26(var6, var7, class32.field735[var1]);
            }

         } else {
            var5 = var0.method2737(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method2737(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var4.field848[0] + var8;
               var11 = var9 + var4.field822[0];
               if(client.field397 == var1 && (var4.field816 < 1536 || var4.field840 < 1536 || var4.field816 >= 11776 || var4.field840 >= 11776)) {
                  var4.method13(var10, var11);
                  var4.field59 = false;
               } else if(var2) {
                  var4.field59 = true;
                  var4.field60 = var10;
                  var4.field51 = var11;
               } else {
                  var4.field59 = false;
                  var4.method26(var10, var11, class32.field735[var1]);
               }

               var4.field57 = (byte)(var7 + var4.field57 & 3);
               if(client.field397 == var1) {
                  class28.field655 = var4.field57;
               }

            } else {
               var6 = var0.method2737(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + class187.field3014 + var4.field848[0] & 16383) - class187.field3014;
               var11 = (var9 + var4.field822[0] + class0.field12 & 16383) - class0.field12;
               if(var1 != client.field397 || var4.field816 >= 1536 && var4.field840 >= 1536 && var4.field816 < 11776 && var4.field840 < 11776) {
                  if(var2) {
                     var4.field59 = true;
                     var4.field60 = var10;
                     var4.field51 = var11;
                  } else {
                     var4.field59 = false;
                     var4.method26(var10, var11, class32.field735[var1]);
                  }
               } else {
                  var4.method13(var10, var11);
                  var4.field59 = false;
               }

               var4.field57 = (byte)(var7 + var4.field57 & 3);
               if(client.field397 == var1) {
                  class28.field655 = var4.field57;
               }

            }
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1292199460"
   )
   static final void method189() {
      for(int var0 = 0; var0 < client.field314; ++var0) {
         int var1 = client.field459[var0];
         class34 var2 = client.field517[var1];
         if(null != var2) {
            class162.method3159(var2, var2.field761.field868);
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "337748267"
   )
   static int method190(int var0, int var1) {
      class15 var2 = (class15)class15.field210.method3742((long)var0);
      if(var2 == null) {
         return 0;
      } else if(var1 == -1) {
         return 0;
      } else {
         int var3 = 0;

         for(int var4 = 0; var4 < var2.field212.length; ++var4) {
            if(var2.field211[var4] == var1) {
               var3 += var2.field212[var4];
            }
         }

         return var3;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "105"
   )
   public static void method191(class119 var0, int var1) {
      class210 var2 = new class210();
      var2.field3130 = var0.method2500();
      var2.field3138 = var0.method2505();
      var2.field3131 = new int[var2.field3130];
      var2.field3132 = new int[var2.field3130];
      var2.field3129 = new Field[var2.field3130];
      var2.field3134 = new int[var2.field3130];
      var2.field3135 = new Method[var2.field3130];
      var2.field3136 = new byte[var2.field3130][][];

      for(int var3 = 0; var3 < var2.field3130; ++var3) {
         try {
            int var4 = var0.method2500();
            String var5;
            String var6;
            int var7;
            if(0 != var4 && var4 != 1 && 2 != var4) {
               if(var4 == 3 || var4 == 4) {
                  var5 = var0.method2508();
                  var6 = var0.method2508();
                  var7 = var0.method2500();
                  String[] var8 = new String[var7];

                  for(int var9 = 0; var9 < var7; ++var9) {
                     var8[var9] = var0.method2508();
                  }

                  String var25 = var0.method2508();
                  byte[][] var10 = new byte[var7][];
                  int var12;
                  if(3 == var4) {
                     for(int var11 = 0; var11 < var7; ++var11) {
                        var12 = var0.method2505();
                        var10[var11] = new byte[var12];
                        var0.method2511(var10[var11], 0, var12);
                     }
                  }

                  var2.field3131[var3] = var4;
                  Class[] var26 = new Class[var7];

                  for(var12 = 0; var12 < var7; ++var12) {
                     var26[var12] = class154.method3126(var8[var12]);
                  }

                  Class var27 = class154.method3126(var25);
                  if(class154.method3126(var5).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var13 = class154.method3126(var5).getDeclaredMethods();
                  Method[] var14 = var13;

                  for(int var15 = 0; var15 < var14.length; ++var15) {
                     Method var16 = var14[var15];
                     if(var16.getName().equals(var6)) {
                        Class[] var17 = var16.getParameterTypes();
                        if(var17.length == var26.length) {
                           boolean var18 = true;

                           for(int var19 = 0; var19 < var26.length; ++var19) {
                              if(var26[var19] != var17[var19]) {
                                 var18 = false;
                                 break;
                              }
                           }

                           if(var18 && var27 == var16.getReturnType()) {
                              var2.field3135[var3] = var16;
                           }
                        }
                     }
                  }

                  var2.field3136[var3] = var10;
               }
            } else {
               var5 = var0.method2508();
               var6 = var0.method2508();
               var7 = 0;
               if(1 == var4) {
                  var7 = var0.method2505();
               }

               var2.field3131[var3] = var4;
               var2.field3134[var3] = var7;
               if(class154.method3126(var5).getClassLoader() == null) {
                  throw new SecurityException();
               }

               var2.field3129[var3] = class154.method3126(var5).getDeclaredField(var6);
            }
         } catch (ClassNotFoundException var20) {
            var2.field3132[var3] = -1;
         } catch (SecurityException var21) {
            var2.field3132[var3] = -2;
         } catch (NullPointerException var22) {
            var2.field3132[var3] = -3;
         } catch (Exception var23) {
            var2.field3132[var3] = -4;
         } catch (Throwable var24) {
            var2.field3132[var3] = -5;
         }
      }

      class211.field3140.method3825(var2);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass167;B)V",
      garbageValue = "2"
   )
   public static void method192(class167 var0) {
      class48.field1067 = var0;
   }
}
