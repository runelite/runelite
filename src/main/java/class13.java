import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
public class class13 implements Runnable {
   @ObfuscatedName("r")
   Object field188 = new Object();
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 833109551
   )
   int field189 = 0;
   @ObfuscatedName("dq")
   static int[] field190;
   @ObfuscatedName("a")
   boolean field191 = true;
   @ObfuscatedName("hz")
   @ObfuscatedGetter(
      intValue = 136299961
   )
   static int field192;
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = -1396045617
   )
   @Export("cameraYaw")
   static int field193;
   @ObfuscatedName("y")
   int[] field195 = new int[500];
   @ObfuscatedName("s")
   int[] field197 = new int[500];
   @ObfuscatedName("je")
   @ObfuscatedGetter(
      intValue = -1503549371
   )
   static int field200;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -496602793
   )
   public static int field201;

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(Lclass172;IIB)V",
      garbageValue = "4"
   )
   static final void method180(class172 var0, int var1, int var2) {
      if(1 == var0.field2746) {
         class212.method3983(var0.field2858, "", 24, 0, 0, var0.field2800 * -1);
      }

      String var3;
      if(2 == var0.field2746 && !client.field448) {
         var3 = class6.method114(var0);
         if(var3 != null) {
            class212.method3983(var3, class51.method1090('\uff00') + var0.field2857, 25, 0, -1, var0.field2800 * -1);
         }
      }

      if(3 == var0.field2746) {
         class212.method3983("Close", "", 26, 0, 0, var0.field2800 * -1);
      }

      if(4 == var0.field2746) {
         class212.method3983(var0.field2858, "", 28, 0, 0, var0.field2800 * -1);
      }

      if(5 == var0.field2746) {
         class212.method3983(var0.field2858, "", 29, 0, 0, var0.field2800 * -1);
      }

      if(6 == var0.field2746 && null == client.field431) {
         class212.method3983(var0.field2858, "", 30, 0, -1, var0.field2800 * -1);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      int var12;
      if(2 == var0.field2764) {
         var12 = 0;

         for(var4 = 0; var4 < var0.field2759; ++var4) {
            for(var5 = 0; var5 < var0.field2752; ++var5) {
               var6 = var5 * (var0.field2807 + 32);
               var7 = var4 * (var0.field2805 + 32);
               if(var12 < 20) {
                  var6 += var0.field2809[var12];
                  var7 += var0.field2810[var12];
               }

               if(var1 >= var6 && var2 >= var7 && var1 < 32 + var6 && var2 < var7 + 32) {
                  client.field549 = var12;
                  class14.field204 = var0;
                  if(var0.field2859[var12] > 0) {
                     class51 var8 = class75.method1648(var0.field2859[var12] - 1);
                     if(1 == client.field446 && class36.method742(class101.method2294(var0))) {
                        if(class88.field1536 != var0.field2800 * -1 || class152.field2264 != var12) {
                           class212.method3983("Use", client.field447 + " " + "->" + " " + class51.method1090(16748608) + var8.field1115, 31, var8.field1110, var12, var0.field2800 * -1);
                        }
                     } else if(client.field448 && class36.method742(class101.method2294(var0))) {
                        if(16 == (class15.field218 & 16)) {
                           class212.method3983(client.field451, client.field452 + " " + "->" + " " + class51.method1090(16748608) + var8.field1115, 32, var8.field1110, var12, var0.field2800 * -1);
                        }
                     } else {
                        String[] var9 = var8.field1135;
                        if(client.field464) {
                           var9 = client.method553(var9);
                        }

                        int var10;
                        byte var11;
                        if(class36.method742(class101.method2294(var0))) {
                           for(var10 = 4; var10 >= 3; --var10) {
                              if(var9 != null && var9[var10] != null) {
                                 if(3 == var10) {
                                    var11 = 36;
                                 } else {
                                    var11 = 37;
                                 }

                                 class212.method3983(var9[var10], class51.method1090(16748608) + var8.field1115, var11, var8.field1110, var12, var0.field2800 * -1);
                              } else if(var10 == 4) {
                                 class212.method3983("Drop", class51.method1090(16748608) + var8.field1115, 37, var8.field1110, var12, var0.field2800 * -1);
                              }
                           }
                        }

                        if(class6.method108(class101.method2294(var0))) {
                           class212.method3983("Use", class51.method1090(16748608) + var8.field1115, 38, var8.field1110, var12, var0.field2800 * -1);
                        }

                        if(class36.method742(class101.method2294(var0)) && var9 != null) {
                           for(var10 = 2; var10 >= 0; --var10) {
                              if(var9[var10] != null) {
                                 var11 = 0;
                                 if(0 == var10) {
                                    var11 = 33;
                                 }

                                 if(var10 == 1) {
                                    var11 = 34;
                                 }

                                 if(var10 == 2) {
                                    var11 = 35;
                                 }

                                 class212.method3983(var9[var10], class51.method1090(16748608) + var8.field1115, var11, var8.field1110, var12, var0.field2800 * -1);
                              }
                           }
                        }

                        var9 = var0.field2845;
                        if(client.field464) {
                           var9 = client.method553(var9);
                        }

                        if(null != var9) {
                           for(var10 = 4; var10 >= 0; --var10) {
                              if(null != var9[var10]) {
                                 var11 = 0;
                                 if(var10 == 0) {
                                    var11 = 39;
                                 }

                                 if(1 == var10) {
                                    var11 = 40;
                                 }

                                 if(2 == var10) {
                                    var11 = 41;
                                 }

                                 if(3 == var10) {
                                    var11 = 42;
                                 }

                                 if(4 == var10) {
                                    var11 = 43;
                                 }

                                 class212.method3983(var9[var10], class51.method1090(16748608) + var8.field1115, var11, var8.field1110, var12, var0.field2800 * -1);
                              }
                           }
                        }

                        class212.method3983("Examine", class51.method1090(16748608) + var8.field1115, 1005, var8.field1110, var12, var0.field2800 * -1);
                     }
                  }
               }

               ++var12;
            }
         }
      }

      if(var0.field2742) {
         if(client.field448) {
            if(class153.method3164(class101.method2294(var0)) && 32 == (class15.field218 & 32)) {
               class212.method3983(client.field451, client.field452 + " " + "->" + " " + var0.field2814, 58, 0, var0.field2744, var0.field2800 * -1);
            }
         } else {
            for(var12 = 9; var12 >= 5; --var12) {
               var6 = class101.method2294(var0);
               boolean var14 = 0 != (var6 >> var12 + 1 & 1);
               String var13;
               if(!var14 && null == var0.field2841) {
                  var13 = null;
               } else if(null != var0.field2815 && var0.field2815.length > var12 && var0.field2815[var12] != null && var0.field2815[var12].trim().length() != 0) {
                  var13 = var0.field2815[var12];
               } else {
                  var13 = null;
               }

               if(var13 != null) {
                  class212.method3983(var13, var0.field2814, 1007, 1 + var12, var0.field2744, var0.field2800 * -1);
               }
            }

            var3 = class6.method114(var0);
            if(var3 != null) {
               class212.method3983(var3, var0.field2814, 25, 0, var0.field2744, var0.field2800 * -1);
            }

            for(var4 = 4; var4 >= 0; --var4) {
               var7 = class101.method2294(var0);
               boolean var17 = 0 != (var7 >> 1 + var4 & 1);
               String var15;
               if(!var17 && null == var0.field2841) {
                  var15 = null;
               } else if(var0.field2815 != null && var0.field2815.length > var4 && var0.field2815[var4] != null && var0.field2815[var4].trim().length() != 0) {
                  var15 = var0.field2815[var4];
               } else {
                  var15 = null;
               }

               if(var15 != null) {
                  class212.method3983(var15, var0.field2814, 57, var4 + 1, var0.field2744, var0.field2800 * -1);
               }
            }

            var5 = class101.method2294(var0);
            boolean var16 = 0 != (var5 & 1);
            if(var16) {
               class212.method3983("Continue", "", 30, 0, var0.field2744, var0.field2800 * -1);
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass118;IIIIIII)V",
      garbageValue = "28539677"
   )
   static final void method181(class118 var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class5.field90[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.method2579();
            if(0 == var7) {
               if(0 == var1) {
                  class5.field86[0][var2][var3] = -class94.method2191(var4 + 932731 + var2, var3 + 556238 + var5) * 8;
               } else {
                  class5.field86[var1][var2][var3] = class5.field86[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var8 = var0.method2579();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(0 == var1) {
                  class5.field86[0][var2][var3] = -var8 * 8;
               } else {
                  class5.field86[var1][var2][var3] = class5.field86[var1 - 1][var2][var3] - 8 * var8;
               }
               break;
            }

            if(var7 <= 49) {
               class5.field75[var1][var2][var3] = var0.method2707();
               class5.field76[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class5.field73[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class5.field90[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class5.field74[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.method2579();
            if(0 == var7) {
               break;
            }

            if(var7 == 1) {
               var0.method2579();
               break;
            }

            if(var7 <= 49) {
               var0.method2579();
            }
         }
      }

   }

   @ObfuscatedName("a")
   public static void method182(class166 var0) {
      class48.field1069 = var0;
   }

   public void run() {
      for(; this.field191; class103.method2301(50L)) {
         Object var1 = this.field188;
         synchronized(this.field188) {
            if(this.field189 < 500) {
               this.field197[this.field189] = class139.field2140;
               this.field195[this.field189] = class139.field2135;
               ++this.field189;
            }
         }
      }

   }

   @ObfuscatedName("r")
   public static class172 method183(int var0, int var1) {
      class172 var2 = class92.method2180(var0);
      return -1 == var1?var2:(null != var2 && null != var2.field2865 && var1 < var2.field2865.length?var2.field2865[var1]:null);
   }
}
