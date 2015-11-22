package net.runelite.rs.client;

import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cd")
public final class class92 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1635610643
   )
   public int field1574;
   @ObfuscatedName("dq")
   static int[] field1575;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 340868069
   )
   int field1576;
   @ObfuscatedName("u")
   public class84 field1577;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -464761327
   )
   int field1578;
   @ObfuscatedName("ab")
   static class167 field1579;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 586573423
   )
   int field1580;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1059022341
   )
   int field1581;

   @ObfuscatedName("ah")
   static final void method2176(class37 var0, int var1, int var2, int var3) {
      if(var0 != null && var0.vmethod791()) {
         if(var0 instanceof class34) {
            class39 var4 = ((class34)var0).field761;
            if(null != var4.field895) {
               var4 = var4.method813();
            }

            if(var4 == null) {
               return;
            }
         }

         int var8 = class32.field733;
         int[] var5 = class32.field730;
         int var6;
         if(var1 < var8) {
            var6 = 30;
            class2 var7 = (class2)var0;
            if(var7.field35) {
               return;
            }

            if(-1 != var7.field46 || -1 != var7.field33) {
               class77.method1716(var0, 15 + var0.field811);
               if(client.field382 * -1 > -1) {
                  if(-1 != var7.field46) {
                     class76.field1372[var7.field46].method1730(client.field382 * -1 + var2 - 12, var3 + client.field395 * -1 - var6);
                     var6 += 25;
                  }

                  if(var7.field33 != -1) {
                     class149.field2236[var7.field33].method1730(var2 + client.field382 * -1 - 12, var3 + client.field395 * -1 - var6);
                     var6 += 25;
                  }
               }
            }

            if(var1 >= 0 && 10 == client.field429 && client.field282 == var5[var1]) {
               class77.method1716(var0, 15 + var0.field811);
               if(client.field382 * -1 > -1) {
                  client.field342[1].method1730(client.field382 * -1 + var2 - 12, var3 + client.field395 * -1 - var6);
               }
            }
         } else {
            class39 var10 = ((class34)var0).field761;
            if(var10.field895 != null) {
               var10 = var10.method813();
            }

            if(var10.field893 >= 0 && var10.field893 < class149.field2236.length) {
               class77.method1716(var0, 15 + var0.field811);
               if(client.field382 * -1 > -1) {
                  class149.field2236[var10.field893].method1730(client.field382 * -1 + var2 - 12, client.field395 * -1 + var3 - 30);
               }
            }

            if(1 == client.field429 && client.field311 == client.field315[var1 - var8] && client.field286 % 20 < 10) {
               class77.method1716(var0, var0.field811 + 15);
               if(client.field382 * -1 > -1) {
                  client.field342[0].method1730(var2 + client.field382 * -1 - 12, client.field395 * -1 + var3 - 28);
               }
            }
         }

         if(var0.field852 != null && (var1 >= var8 || !var0.field813 && (client.field492 == 4 || !var0.field812 && (0 == client.field492 || 3 == client.field492 || client.field492 == 1 && class8.method138(((class2)var0).field34, false))))) {
            class77.method1716(var0, var0.field811);
            if(client.field382 * -1 > -1 && client.field385 < client.field371) {
               client.field375[client.field385] = class143.field2174.method4161(var0.field852) / 2;
               client.field301[client.field385] = class143.field2174.field3182;
               client.field372[client.field385] = client.field382 * -1;
               client.field373[client.field385] = client.field395 * -1;
               client.field554[client.field385] = var0.field815;
               client.field377[client.field385] = var0.field798;
               client.field352[client.field385] = var0.field814;
               client.field394[client.field385] = var0.field852;
               ++client.field385;
            }
         }

         if(var0.field820 > client.field286) {
            class77.method1716(var0, 15 + var0.field811);
            if(client.field382 * -1 > -1) {
               if(var1 < var8) {
                  var6 = 30;
               } else {
                  class39 var9 = ((class34)var0).field761;
                  var6 = var9.field901;
               }

               int var11 = var6 * var0.field833 / var0.field853;
               if(var11 > var6) {
                  var11 = var6;
               } else if(var11 == 0 && var0.field833 > 0) {
                  var11 = 1;
               }

               class79.method1820(var2 + client.field382 * -1 - var6 / 2, var3 + client.field395 * -1 - 3, var11, 5, '\uff00');
               class79.method1820(client.field382 * -1 + var2 - var6 / 2 + var11, var3 + client.field395 * -1 - 3, var6 - var11, 5, 16711680);
            }
         }

         for(var6 = 0; var6 < 4; ++var6) {
            if(var0.field819[var6] > client.field286) {
               class77.method1716(var0, var0.field811 / 2);
               if(client.field382 * -1 > -1) {
                  if(var6 == 1) {
                     client.field395 -= -20;
                  }

                  if(2 == var6) {
                     client.field382 -= -15;
                     client.field395 -= -10;
                  }

                  if(var6 == 3) {
                     client.field382 += -15;
                     client.field395 -= -10;
                  }

                  class13.field193[var0.field847[var6]].method1730(var2 + client.field382 * -1 - 12, var3 + client.field395 * -1 - 12);
                  class88.field1532.method4077(Integer.toString(var0.field817[var6]), client.field382 * -1 + var2 - 1, 3 + client.field395 * -1 + var3, 16777215, 0);
               }
            }
         }

      }
   }

   @ObfuscatedName("j")
   public static synchronized long method2177() {
      long var0 = System.currentTimeMillis();
      if(var0 < class114.field1961) {
         class114.field1958 += class114.field1961 - var0;
      }

      class114.field1961 = var0;
      return var0 + class114.field1958;
   }

   @ObfuscatedName("m")
   public static void method2178() {
      class139 var0 = class139.field2141;
      synchronized(class139.field2141) {
         class139.field2133 = class139.field2145;
         class139.field2134 = class139.field2128;
         class139.field2135 = class139.field2132;
         class139.field2140 = class139.field2136;
         class139.field2130 = class139.field2138;
         class139.field2142 = class139.field2131;
         class139.field2143 = class139.field2139;
         class139.field2136 = 0;
      }
   }

   @ObfuscatedName("j")
   static void method2179() {
      class5.field74 = 99;
      class5.field85 = new byte[4][104][104];
      class164.field2645 = new byte[4][104][104];
      class5.field76 = new byte[4][104][104];
      class133.field2058 = new byte[4][104][104];
      class29.field677 = new int[4][105][105];
      class150.field2239 = new byte[4][105][105];
      class5.field77 = new int[105][105];
      class5.field75 = new int[104];
      class34.field764 = new int[104];
      class157.field2573 = new int[104];
      class219.field3156 = new int[104];
      class5.field73 = new int[104];
   }

   @ObfuscatedName("j")
   public static boolean method2180() {
      long var0 = method2177();
      int var2 = (int)(var0 - class170.field2697);
      class170.field2697 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class170.field2696 += var2;
      if(0 == class170.field2706 && class170.field2701 == 0 && 0 == class170.field2700 && 0 == class170.field2699) {
         return true;
      } else if(class170.field2715 == null) {
         return false;
      } else {
         try {
            if(class170.field2696 > 30000) {
               throw new IOException();
            } else {
               class171 var3;
               class118 var4;
               while(class170.field2701 < 20 && class170.field2699 > 0) {
                  var3 = (class171)class170.field2698.method3835();
                  var4 = new class118(4);
                  var4.method2521(1);
                  var4.method2523((int)var3.field3104);
                  class170.field2715.method3042(var4.field1980, 0, 4);
                  class170.field2703.method3839(var3, var3.field3104);
                  --class170.field2699;
                  ++class170.field2701;
               }

               while(class170.field2706 < 20 && class170.field2700 > 0) {
                  var3 = (class171)class170.field2707.method3928();
                  var4 = new class118(4);
                  var4.method2521(0);
                  var4.method2523((int)var3.field3104);
                  class170.field2715.method3042(var4.field1980, 0, 4);
                  var3.method3945();
                  class170.field2705.method3839(var3, var3.field3104);
                  --class170.field2700;
                  ++class170.field2706;
               }

               for(int var18 = 0; var18 < 100; ++var18) {
                  int var19 = class170.field2715.method3024();
                  if(var19 < 0) {
                     throw new IOException();
                  }

                  if(0 == var19) {
                     break;
                  }

                  class170.field2696 = 0;
                  byte var5 = 0;
                  if(class47.field1054 == null) {
                     var5 = 8;
                  } else if(class170.field2714 == 0) {
                     var5 = 1;
                  }

                  int var6;
                  int var7;
                  int var8;
                  int var10;
                  if(var5 > 0) {
                     var6 = var5 - class170.field2709.field1981;
                     if(var6 > var19) {
                        var6 = var19;
                     }

                     class170.field2715.method3028(class170.field2709.field1980, class170.field2709.field1981, var6);
                     if(class170.field2713 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class170.field2709.field1980[var7 + class170.field2709.field1981] ^= class170.field2713;
                        }
                     }

                     class170.field2709.field1981 += var6;
                     if(class170.field2709.field1981 < var5) {
                        break;
                     }

                     if(null == class47.field1054) {
                        class170.field2709.field1981 = 0;
                        var7 = class170.field2709.method2536();
                        var8 = class170.field2709.method2538();
                        int var9 = class170.field2709.method2536();
                        var10 = class170.field2709.method2541();
                        long var11 = (long)(var8 + (var7 << 16));
                        class171 var13 = (class171)class170.field2703.method3836(var11);
                        class112.field1947 = true;
                        if(null == var13) {
                           var13 = (class171)class170.field2705.method3836(var11);
                           class112.field1947 = false;
                        }

                        if(var13 == null) {
                           throw new IOException();
                        }

                        int var14 = var9 == 0?5:9;
                        class47.field1054 = var13;
                        class170.field2708 = new class118(class47.field1054.field2721 + var14 + var10);
                        class170.field2708.method2521(var9);
                        class170.field2708.method2524(var10);
                        class170.field2714 = 8;
                        class170.field2709.field1981 = 0;
                     } else if(0 == class170.field2714) {
                        if(-1 == class170.field2709.field1980[0]) {
                           class170.field2714 = 1;
                           class170.field2709.field1981 = 0;
                        } else {
                           class47.field1054 = null;
                        }
                     }
                  } else {
                     var6 = class170.field2708.field1980.length - class47.field1054.field2721;
                     var7 = 512 - class170.field2714;
                     if(var7 > var6 - class170.field2708.field1981) {
                        var7 = var6 - class170.field2708.field1981;
                     }

                     if(var7 > var19) {
                        var7 = var19;
                     }

                     class170.field2715.method3028(class170.field2708.field1980, class170.field2708.field1981, var7);
                     if(0 != class170.field2713) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           class170.field2708.field1980[var8 + class170.field2708.field1981] ^= class170.field2713;
                        }
                     }

                     class170.field2708.field1981 += var7;
                     class170.field2714 += var7;
                     if(var6 == class170.field2708.field1981) {
                        if(16711935L == class47.field1054.field3104) {
                           class170.field2711 = class170.field2708;

                           for(var8 = 0; var8 < 256; ++var8) {
                              class167 var20 = class170.field2712[var8];
                              if(var20 != null) {
                                 class170.field2711.field1981 = var8 * 8 + 5;
                                 var10 = class170.field2711.method2541();
                                 int var21 = class170.field2711.method2541();
                                 var20.method3404(var10, var21);
                              }
                           }
                        } else {
                           class170.field2710.reset();
                           class170.field2710.update(class170.field2708.field1980, 0, var6);
                           var8 = (int)class170.field2710.getValue();
                           if(var8 != class47.field1054.field2718) {
                              try {
                                 class170.field2715.method3022();
                              } catch (Exception var16) {
                                 ;
                              }

                              ++class170.field2695;
                              class170.field2715 = null;
                              class170.field2713 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class170.field2695 = 0;
                           class170.field2704 = 0;
                           class47.field1054.field2719.method3405((int)(class47.field1054.field3104 & 65535L), class170.field2708.field1980, (class47.field1054.field3104 & 16711680L) == 16711680L, class112.field1947);
                        }

                        class47.field1054.method3965();
                        if(class112.field1947) {
                           --class170.field2701;
                        } else {
                           --class170.field2706;
                        }

                        class170.field2714 = 0;
                        class47.field1054 = null;
                        class170.field2708 = null;
                     } else {
                        if(class170.field2714 != 512) {
                           break;
                        }

                        class170.field2714 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var17) {
            try {
               class170.field2715.method3022();
            } catch (Exception var15) {
               ;
            }

            ++class170.field2704;
            class170.field2715 = null;
            return false;
         }
      }
   }
}
