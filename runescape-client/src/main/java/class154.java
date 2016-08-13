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
      class54 var1 = (class54)class54.field1171.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class54.field1169.method3411(5, var0);
         var1 = new class54();
         if(null != var2) {
            var1.method1152(new Buffer(var2));
         }

         class54.field1171.put(var1, (long)var0);
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
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field45 = false;
         } else {
            if(var1 == Client.localInteractingIndex) {
               throw new RuntimeException();
            }

            class34.field790[var1] = (class0.baseX + var4.pathX[0] >> 6 << 14) + (var4.field52 << 28) + (var4.pathY[0] + class21.baseY >> 6);
            if(var4.field859 != -1) {
               class34.field788[var1] = var4.field859;
            } else {
               class34.field788[var1] = var4.field882;
            }

            class34.field780[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
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
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
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

            if(var1 != Client.localInteractingIndex || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if(var2) {
                  var4.field45 = true;
                  var4.field49 = var6;
                  var4.field56 = var7;
               } else {
                  var4.field45 = false;
                  var4.method18(var6, var7, class34.field781[var1]);
               }
            } else {
               var4.method19(var6, var7);
               var4.field45 = false;
            }
         } else if(var3 == 2) {
            var5 = var0.method2907(4);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
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

            if(var1 != Client.localInteractingIndex || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if(var2) {
                  var4.field45 = true;
                  var4.field49 = var6;
                  var4.field56 = var7;
               } else {
                  var4.field45 = false;
                  var4.method18(var6, var7, class34.field781[var1]);
               }
            } else {
               var4.method19(var6, var7);
               var4.field45 = false;
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

               var10 = var4.pathX[0] + var8;
               var11 = var4.pathY[0] + var9;
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
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
               if(Client.localInteractingIndex == var1) {
                  VertexNormal.plane = var4.field52;
               }
            } else {
               var6 = var0.method2907(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var4.pathX[0] + class0.baseX + var8 & 16383) - class0.baseX;
               var11 = (var9 + class21.baseY + var4.pathY[0] & 16383) - class21.baseY;
               if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
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
               if(var1 == Client.localInteractingIndex) {
                  VertexNormal.plane = var4.field52;
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
               Buffer var4;
               while(class174.field2774 < 20 && class174.field2781 > 0) {
                  var3 = (class175)class174.field2771.method3939();
                  var4 = new Buffer(4);
                  var4.method2783(1);
                  var4.method2849((int)var3.hash);
                  class174.field2790.method3135(var4.payload, 0, 4);
                  class174.field2777.method3940(var3, var3.hash);
                  --class174.field2781;
                  ++class174.field2774;
               }

               while(class174.field2779 < 20 && class174.field2768 > 0) {
                  var3 = (class175)class174.field2772.method4029();
                  var4 = new Buffer(4);
                  var4.method2783(0);
                  var4.method2849((int)var3.hash);
                  class174.field2790.method3135(var4.payload, 0, 4);
                  var3.method4045();
                  class174.field2778.method3940(var3, var3.hash);
                  --class174.field2768;
                  ++class174.field2779;
               }

               for(int var5 = 0; var5 < 100; ++var5) {
                  int var6 = class174.field2790.method3141();
                  if(var6 < 0) {
                     throw new IOException();
                  }

                  if(var6 == 0) {
                     break;
                  }

                  class174.field2769 = 0;
                  byte var7 = 0;
                  if(null == class174.field2780) {
                     var7 = 8;
                  } else if(class174.field2782 == 0) {
                     var7 = 1;
                  }

                  int var8;
                  int var9;
                  int var10;
                  int var11;
                  if(var7 > 0) {
                     var8 = var7 - class174.field2775.offset;
                     if(var8 > var6) {
                        var8 = var6;
                     }

                     class174.field2790.method3132(class174.field2775.payload, class174.field2775.offset, var8);
                     if(class174.field2773 != 0) {
                        for(var9 = 0; var9 < var8; ++var9) {
                           class174.field2775.payload[var9 + class174.field2775.offset] ^= class174.field2773;
                        }
                     }

                     class174.field2775.offset += var8;
                     if(class174.field2775.offset < var7) {
                        break;
                     }

                     if(class174.field2780 == null) {
                        class174.field2775.offset = 0;
                        var9 = class174.field2775.method2633();
                        var10 = class174.field2775.method2635();
                        int var12 = class174.field2775.method2633();
                        var11 = class174.field2775.method2620();
                        long var13 = (long)((var9 << 16) + var10);
                        class175 var15 = (class175)class174.field2777.method3936(var13);
                        class32.field738 = true;
                        if(null == var15) {
                           var15 = (class175)class174.field2778.method3936(var13);
                           class32.field738 = false;
                        }

                        if(null == var15) {
                           throw new IOException();
                        }

                        int var16 = var12 == 0?5:9;
                        class174.field2780 = var15;
                        class159.field2368 = new Buffer(var11 + var16 + class174.field2780.field2793);
                        class159.field2368.method2783(var12);
                        class159.field2368.method2728(var11);
                        class174.field2782 = 8;
                        class174.field2775.offset = 0;
                     } else if(class174.field2782 == 0) {
                        if(class174.field2775.payload[0] == -1) {
                           class174.field2782 = 1;
                           class174.field2775.offset = 0;
                        } else {
                           class174.field2780 = null;
                        }
                     }
                  } else {
                     var8 = class159.field2368.payload.length - class174.field2780.field2793;
                     var9 = 512 - class174.field2782;
                     if(var9 > var8 - class159.field2368.offset) {
                        var9 = var8 - class159.field2368.offset;
                     }

                     if(var9 > var6) {
                        var9 = var6;
                     }

                     class174.field2790.method3132(class159.field2368.payload, class159.field2368.offset, var9);
                     if(class174.field2773 != 0) {
                        for(var10 = 0; var10 < var9; ++var10) {
                           class159.field2368.payload[class159.field2368.offset + var10] ^= class174.field2773;
                        }
                     }

                     class159.field2368.offset += var9;
                     class174.field2782 += var9;
                     if(var8 == class159.field2368.offset) {
                        if(class174.field2780.hash == 16711935L) {
                           class156.field2338 = class159.field2368;

                           for(var10 = 0; var10 < 256; ++var10) {
                              class171 var20 = class174.field2786[var10];
                              if(null != var20) {
                                 class156.field2338.offset = var10 * 8 + 5;
                                 var11 = class156.field2338.method2620();
                                 int var21 = class156.field2338.method2620();
                                 var20.method3487(var11, var21);
                              }
                           }
                        } else {
                           class174.field2783.reset();
                           class174.field2783.update(class159.field2368.payload, 0, var8);
                           var10 = (int)class174.field2783.getValue();
                           if(var10 != class174.field2780.field2792) {
                              try {
                                 class174.field2790.method3131();
                              } catch (Exception var18) {
                                 ;
                              }

                              ++class174.field2785;
                              class174.field2790 = null;
                              class174.field2773 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class174.field2785 = 0;
                           class174.field2787 = 0;
                           class174.field2780.field2795.method3488((int)(class174.field2780.hash & 65535L), class159.field2368.payload, 16711680L == (class174.field2780.hash & 16711680L), class32.field738);
                        }

                        class174.field2780.unlink();
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
         } catch (IOException var19) {
            try {
               class174.field2790.method3131();
            } catch (Exception var17) {
               ;
            }

            ++class174.field2787;
            class174.field2790 = null;
            return false;
         }
      }
   }
}
