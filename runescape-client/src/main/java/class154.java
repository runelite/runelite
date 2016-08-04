import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public class class154 {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Lclass54;",
      garbageValue = "1275304400"
   )
   public static class54 method3286(int var0) {
      class54 var1 = (class54)class54.field1171.method3905((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class54.field1169.method3411(5, var0);
         var1 = new class54();
         if(null != var2) {
            var1.method1152(new class122(var2));
         }

         class54.field1171.method3907(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass125;II)V",
      garbageValue = "-1449603013"
   )
   static void method3287(class125 var0, int var1) {
      boolean var2 = var0.method2907(1) == 1;
      if(var2) {
         class34.field779[++class34.field785 - 1] = var1;
      }

      int var3 = var0.method2907(2);
      class2 var4 = client.field302[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field45 = false;
         } else if(var1 == client.field417) {
            throw new RuntimeException();
         } else {
            class34.field790[var1] = (class0.field11 + var4.field886[0] >> 6 << 14) + (var4.field52 << 28) + (var4.field887[0] + class21.field592 >> 6);
            if(var4.field859 != -1) {
               class34.field788[var1] = var4.field859;
            } else {
               class34.field788[var1] = var4.field882;
            }

            class34.field780[var1] = var4.field844;
            client.field302[var1] = null;
            if(var0.method2907(1) != 0) {
               class50.method1076(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method2907(3);
            var6 = var4.field886[0];
            var7 = var4.field887[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
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

            if(var1 == client.field417 && (var4.field875 < 1536 || var4.field832 < 1536 || var4.field875 >= 11776 || var4.field832 >= 11776)) {
               var4.method19(var6, var7);
               var4.field45 = false;
            } else if(var2) {
               var4.field45 = true;
               var4.field49 = var6;
               var4.field56 = var7;
            } else {
               var4.field45 = false;
               var4.method18(var6, var7, class34.field781[var1]);
            }

         } else if(var3 == 2) {
            var5 = var0.method2907(4);
            var6 = var4.field886[0];
            var7 = var4.field887[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(var1 == client.field417 && (var4.field875 < 1536 || var4.field832 < 1536 || var4.field875 >= 11776 || var4.field832 >= 11776)) {
               var4.method19(var6, var7);
               var4.field45 = false;
            } else if(var2) {
               var4.field45 = true;
               var4.field49 = var6;
               var4.field56 = var7;
            } else {
               var4.field45 = false;
               var4.method18(var6, var7, class34.field781[var1]);
            }

         } else {
            var5 = var0.method2907(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method2907(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var4.field886[0] + var8;
               var11 = var4.field887[0] + var9;
               if(client.field417 != var1 || var4.field875 >= 1536 && var4.field832 >= 1536 && var4.field875 < 11776 && var4.field832 < 11776) {
                  if(var2) {
                     var4.field45 = true;
                     var4.field49 = var10;
                     var4.field56 = var11;
                  } else {
                     var4.field45 = false;
                     var4.method18(var10, var11, class34.field781[var1]);
                  }
               } else {
                  var4.method19(var10, var11);
                  var4.field45 = false;
               }

               var4.field52 = (byte)(var4.field52 + var7 & 3);
               if(client.field417 == var1) {
                  class99.field1701 = var4.field52;
               }

            } else {
               var6 = var0.method2907(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var4.field886[0] + class0.field11 + var8 & 16383) - class0.field11;
               var11 = (var9 + class21.field592 + var4.field887[0] & 16383) - class21.field592;
               if(client.field417 == var1 && (var4.field875 < 1536 || var4.field832 < 1536 || var4.field875 >= 11776 || var4.field832 >= 11776)) {
                  var4.method19(var10, var11);
                  var4.field45 = false;
               } else if(var2) {
                  var4.field45 = true;
                  var4.field49 = var10;
                  var4.field56 = var11;
               } else {
                  var4.field45 = false;
                  var4.method18(var10, var11, class34.field781[var1]);
               }

               var4.field52 = (byte)(var4.field52 + var7 & 3);
               if(var1 == client.field417) {
                  class99.field1701 = var4.field52;
               }

            }
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "892868645"
   )
   public static boolean method3288() {
      long var0 = class56.method1249();
      int var2 = (int)(var0 - class174.field2770);
      class174.field2770 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class174.field2769 += var2;
      if(class174.field2779 == 0 && class174.field2774 == 0 && class174.field2768 == 0 && class174.field2781 == 0) {
         return true;
      } else if(null == class174.field2790) {
         return false;
      } else {
         try {
            if(class174.field2769 > 30000) {
               throw new IOException();
            } else {
               class175 var3;
               class122 var4;
               while(class174.field2774 < 20 && class174.field2781 > 0) {
                  var3 = (class175)class174.field2771.method3939();
                  var4 = new class122(4);
                  var4.method2783(1);
                  var4.method2849((int)var3.field3175);
                  class174.field2790.method3135(var4.field2051, 0, 4);
                  class174.field2777.method3940(var3, var3.field3175);
                  --class174.field2781;
                  ++class174.field2774;
               }

               while(class174.field2779 < 20 && class174.field2768 > 0) {
                  var3 = (class175)class174.field2772.method4029();
                  var4 = new class122(4);
                  var4.method2783(0);
                  var4.method2849((int)var3.field3175);
                  class174.field2790.method3135(var4.field2051, 0, 4);
                  var3.method4045();
                  class174.field2778.method3940(var3, var3.field3175);
                  --class174.field2768;
                  ++class174.field2779;
               }

               for(int var15 = 0; var15 < 100; ++var15) {
                  int var16 = class174.field2790.method3141();
                  if(var16 < 0) {
                     throw new IOException();
                  }

                  if(var16 == 0) {
                     break;
                  }

                  class174.field2769 = 0;
                  byte var5 = 0;
                  if(null == class174.field2780) {
                     var5 = 8;
                  } else if(class174.field2782 == 0) {
                     var5 = 1;
                  }

                  int var6;
                  int var7;
                  int var8;
                  int var10;
                  if(var5 > 0) {
                     var6 = var5 - class174.field2775.field2050;
                     if(var6 > var16) {
                        var6 = var16;
                     }

                     class174.field2790.method3132(class174.field2775.field2051, class174.field2775.field2050, var6);
                     if(class174.field2773 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class174.field2775.field2051[var7 + class174.field2775.field2050] ^= class174.field2773;
                        }
                     }

                     class174.field2775.field2050 += var6;
                     if(class174.field2775.field2050 < var5) {
                        break;
                     }

                     if(class174.field2780 == null) {
                        class174.field2775.field2050 = 0;
                        var7 = class174.field2775.method2633();
                        var8 = class174.field2775.method2635();
                        int var9 = class174.field2775.method2633();
                        var10 = class174.field2775.method2620();
                        long var11 = (long)((var7 << 16) + var8);
                        class175 var13 = (class175)class174.field2777.method3936(var11);
                        class32.field738 = true;
                        if(null == var13) {
                           var13 = (class175)class174.field2778.method3936(var11);
                           class32.field738 = false;
                        }

                        if(null == var13) {
                           throw new IOException();
                        }

                        int var14 = var9 == 0?5:9;
                        class174.field2780 = var13;
                        class159.field2368 = new class122(var10 + var14 + class174.field2780.field2793);
                        class159.field2368.method2783(var9);
                        class159.field2368.method2728(var10);
                        class174.field2782 = 8;
                        class174.field2775.field2050 = 0;
                     } else if(class174.field2782 == 0) {
                        if(class174.field2775.field2051[0] == -1) {
                           class174.field2782 = 1;
                           class174.field2775.field2050 = 0;
                        } else {
                           class174.field2780 = null;
                        }
                     }
                  } else {
                     var6 = class159.field2368.field2051.length - class174.field2780.field2793;
                     var7 = 512 - class174.field2782;
                     if(var7 > var6 - class159.field2368.field2050) {
                        var7 = var6 - class159.field2368.field2050;
                     }

                     if(var7 > var16) {
                        var7 = var16;
                     }

                     class174.field2790.method3132(class159.field2368.field2051, class159.field2368.field2050, var7);
                     if(class174.field2773 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           class159.field2368.field2051[class159.field2368.field2050 + var8] ^= class174.field2773;
                        }
                     }

                     class159.field2368.field2050 += var7;
                     class174.field2782 += var7;
                     if(var6 == class159.field2368.field2050) {
                        if(class174.field2780.field3175 == 16711935L) {
                           class156.field2338 = class159.field2368;

                           for(var8 = 0; var8 < 256; ++var8) {
                              class171 var17 = class174.field2786[var8];
                              if(null != var17) {
                                 class156.field2338.field2050 = var8 * 8 + 5;
                                 var10 = class156.field2338.method2620();
                                 int var21 = class156.field2338.method2620();
                                 var17.method3487(var10, var21);
                              }
                           }
                        } else {
                           class174.field2783.reset();
                           class174.field2783.update(class159.field2368.field2051, 0, var6);
                           var8 = (int)class174.field2783.getValue();
                           if(var8 != class174.field2780.field2792) {
                              try {
                                 class174.field2790.method3131();
                              } catch (Exception var19) {
                                 ;
                              }

                              ++class174.field2785;
                              class174.field2790 = null;
                              class174.field2773 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class174.field2785 = 0;
                           class174.field2787 = 0;
                           class174.field2780.field2795.method3488((int)(class174.field2780.field3175 & 65535L), class159.field2368.field2051, 16711680L == (class174.field2780.field3175 & 16711680L), class32.field738);
                        }

                        class174.field2780.method4067();
                        if(class32.field738) {
                           --class174.field2774;
                        } else {
                           --class174.field2779;
                        }

                        class174.field2782 = 0;
                        class174.field2780 = null;
                        class159.field2368 = null;
                     } else {
                        if(class174.field2782 != 512) {
                           break;
                        }

                        class174.field2782 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var20) {
            try {
               class174.field2790.method3131();
            } catch (Exception var18) {
               ;
            }

            ++class174.field2787;
            class174.field2790 = null;
            return false;
         }
      }
   }
}
