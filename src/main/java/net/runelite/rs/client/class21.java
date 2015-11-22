package net.runelite.rs.client;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("x")
final class class21 implements Comparator {
   @ObfuscatedName("l")
   static File field572;
   // $FF: synthetic field
   final boolean val$preferOwnWorld;

   class21(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   @ObfuscatedName("f")
   public static void method598(class118 var0) {
      class209 var1 = new class209();
      var1.field3113 = var0.method2536();
      var1.field3108 = var0.method2541();
      var1.field3109 = new int[var1.field3113];
      var1.field3111 = new int[var1.field3113];
      var1.field3110 = new Field[var1.field3113];
      var1.field3112 = new int[var1.field3113];
      var1.field3107 = new Method[var1.field3113];
      var1.field3114 = new byte[var1.field3113][][];

      for(int var2 = 0; var2 < var1.field3113; ++var2) {
         try {
            int var3 = var0.method2536();
            String var4;
            String var5;
            int var6;
            if(var3 != 0 && 1 != var3 && 2 != var3) {
               if(var3 == 3 || var3 == 4) {
                  var4 = var0.method2544();
                  var5 = var0.method2544();
                  var6 = var0.method2536();
                  String[] var7 = new String[var6];

                  for(int var8 = 0; var8 < var6; ++var8) {
                     var7[var8] = var0.method2544();
                  }

                  String var24 = var0.method2544();
                  byte[][] var9 = new byte[var6][];
                  int var11;
                  if(3 == var3) {
                     for(int var10 = 0; var10 < var6; ++var10) {
                        var11 = var0.method2541();
                        var9[var10] = new byte[var11];
                        var0.method2546(var9[var10], 0, var11);
                     }
                  }

                  var1.field3109[var2] = var3;
                  Class[] var25 = new Class[var6];

                  for(var11 = 0; var11 < var6; ++var11) {
                     var25[var11] = class32.method742(var7[var11]);
                  }

                  Class var26 = class32.method742(var24);
                  if(class32.method742(var4).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var12 = class32.method742(var4).getDeclaredMethods();
                  Method[] var13 = var12;

                  for(int var14 = 0; var14 < var13.length; ++var14) {
                     Method var15 = var13[var14];
                     if(var15.getName().equals(var5)) {
                        Class[] var16 = var15.getParameterTypes();
                        if(var25.length == var16.length) {
                           boolean var17 = true;

                           for(int var18 = 0; var18 < var25.length; ++var18) {
                              if(var16[var18] != var25[var18]) {
                                 var17 = false;
                                 break;
                              }
                           }

                           if(var17 && var26 == var15.getReturnType()) {
                              var1.field3107[var2] = var15;
                           }
                        }
                     }
                  }

                  var1.field3114[var2] = var9;
               }
            } else {
               var4 = var0.method2544();
               var5 = var0.method2544();
               var6 = 0;
               if(var3 == 1) {
                  var6 = var0.method2541();
               }

               var1.field3109[var2] = var3;
               var1.field3112[var2] = var6;
               if(class32.method742(var4).getClassLoader() == null) {
                  throw new SecurityException();
               }

               var1.field3110[var2] = class32.method742(var4).getDeclaredField(var5);
            }
         } catch (ClassNotFoundException var19) {
            var1.field3111[var2] = -1;
         } catch (SecurityException var20) {
            var1.field3111[var2] = -2;
         } catch (NullPointerException var21) {
            var1.field3111[var2] = -3;
         } catch (Exception var22) {
            var1.field3111[var2] = -4;
         } catch (Throwable var23) {
            var1.field3111[var2] = -5;
         }
      }

      class210.field3116.method3921(var1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("j")
   int method606(class213 var1, class213 var2) {
      if(var1.field3134 == var2.field3134) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(var1.field3134 == client.field421) {
               return -1;
            }

            if(client.field421 == var2.field3134) {
               return 1;
            }
         }

         return var1.field3134 < var2.field3134?-1:1;
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method606((class213)var1, (class213)var2);
   }

   @ObfuscatedName("f")
   public static int method608(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("b")
   static final void method609(class37 var0) {
      int var1;
      int var2;
      int var3;
      class42 var10;
      if(var0.field843 > client.field286) {
         var1 = var0.field843 - client.field286;
         var2 = var0.field802 * 64 + var0.field839 * 128;
         var3 = var0.field802 * 64 + var0.field842 * 128;
         var0.field846 += (var2 - var0.field846) / var1;
         var0.field834 += (var3 - var0.field834) / var1;
         var0.field831 = 0;
         var0.field848 = var0.field845;
      } else {
         int var4;
         int var6;
         if(var0.field844 >= client.field286) {
            if(var0.field844 == client.field286 || -1 == var0.field829 || 0 != var0.field832 || 1 + var0.field841 > client.method584(var0.field829).field975[var0.field830]) {
               var1 = var0.field844 - var0.field843;
               var2 = client.field286 - var0.field843;
               var3 = var0.field802 * 64 + var0.field839 * 128;
               var4 = var0.field842 * 128 + var0.field802 * 64;
               int var5 = var0.field802 * 64 + var0.field840 * 128;
               var6 = var0.field821 * 128 + var0.field802 * 64;
               var0.field846 = (var2 * var5 + var3 * (var1 - var2)) / var1;
               var0.field834 = (var6 * var2 + var4 * (var1 - var2)) / var1;
            }

            var0.field831 = 0;
            var0.field848 = var0.field845;
            var0.field800 = var0.field848;
         } else {
            var0.field826 = var0.field803;
            if(var0.field851 == 0) {
               var0.field831 = 0;
            } else {
               label472: {
                  if(var0.field829 != -1 && 0 == var0.field832) {
                     var10 = client.method584(var0.field829);
                     if(var0.field856 > 0 && 0 == var10.field980) {
                        ++var0.field831;
                        break label472;
                     }

                     if(var0.field856 <= 0 && 0 == var10.field985) {
                        ++var0.field831;
                        break label472;
                     }
                  }

                  var1 = var0.field846;
                  var2 = var0.field834;
                  var3 = var0.field802 * 64 + var0.field809[var0.field851 - 1] * 128;
                  var4 = 128 * var0.field816[var0.field851 - 1] + var0.field802 * 64;
                  if(var1 < var3) {
                     if(var2 < var4) {
                        var0.field848 = 1280;
                     } else if(var2 > var4) {
                        var0.field848 = 1792;
                     } else {
                        var0.field848 = 1536;
                     }
                  } else if(var1 > var3) {
                     if(var2 < var4) {
                        var0.field848 = 768;
                     } else if(var2 > var4) {
                        var0.field848 = 256;
                     } else {
                        var0.field848 = 512;
                     }
                  } else if(var2 < var4) {
                     var0.field848 = 1024;
                  } else if(var2 > var4) {
                     var0.field848 = 0;
                  }

                  byte var12 = var0.field855[var0.field851 - 1];
                  if(var3 - var1 <= 256 && var3 - var1 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
                     var6 = var0.field848 - var0.field800 & 2047;
                     if(var6 > 1024) {
                        var6 -= 2048;
                     }

                     int var7 = var0.field807;
                     if(var6 >= -256 && var6 <= 256) {
                        var7 = var0.field806;
                     } else if(var6 >= 256 && var6 < 768) {
                        var7 = var0.field818;
                     } else if(var6 >= -768 && var6 <= -256) {
                        var7 = var0.field822;
                     }

                     if(-1 == var7) {
                        var7 = var0.field806;
                     }

                     var0.field826 = var7;
                     int var8 = 4;
                     boolean var9 = true;
                     if(var0 instanceof class34) {
                        var9 = ((class34)var0).field761.field899;
                     }

                     if(var9) {
                        if(var0.field800 != var0.field848 && -1 == var0.field823 && var0.field850 != 0) {
                           var8 = 2;
                        }

                        if(var0.field851 > 2) {
                           var8 = 6;
                        }

                        if(var0.field851 > 3) {
                           var8 = 8;
                        }

                        if(var0.field831 > 0 && var0.field851 > 1) {
                           var8 = 8;
                           --var0.field831;
                        }
                     } else {
                        if(var0.field851 > 1) {
                           var8 = 6;
                        }

                        if(var0.field851 > 2) {
                           var8 = 8;
                        }

                        if(var0.field831 > 0 && var0.field851 > 1) {
                           var8 = 8;
                           --var0.field831;
                        }
                     }

                     if(var12 == 2) {
                        var8 <<= 1;
                     }

                     if(var8 >= 8 && var0.field826 == var0.field806 && -1 != var0.field810) {
                        var0.field826 = var0.field810;
                     }

                     if(var3 != var1 || var4 != var2) {
                        if(var1 < var3) {
                           var0.field846 += var8;
                           if(var0.field846 > var3) {
                              var0.field846 = var3;
                           }
                        } else if(var1 > var3) {
                           var0.field846 -= var8;
                           if(var0.field846 < var3) {
                              var0.field846 = var3;
                           }
                        }

                        if(var2 < var4) {
                           var0.field834 += var8;
                           if(var0.field834 > var4) {
                              var0.field834 = var4;
                           }
                        } else if(var2 > var4) {
                           var0.field834 -= var8;
                           if(var0.field834 < var4) {
                              var0.field834 = var4;
                           }
                        }
                     }

                     if(var0.field846 == var3 && var4 == var0.field834) {
                        --var0.field851;
                        if(var0.field856 > 0) {
                           --var0.field856;
                        }
                     }
                  } else {
                     var0.field846 = var3;
                     var0.field834 = var4;
                     --var0.field851;
                     if(var0.field856 > 0) {
                        --var0.field856;
                     }
                  }
               }
            }
         }
      }

      if(var0.field846 < 128 || var0.field834 < 128 || var0.field846 >= 13184 || var0.field834 >= 13184) {
         var0.field829 = -1;
         var0.field805 = -1;
         var0.field843 = 0;
         var0.field844 = 0;
         var0.field846 = var0.field809[0] * 128 + var0.field802 * 64;
         var0.field834 = var0.field802 * 64 + var0.field816[0] * 128;
         var0.method790();
      }

      if(var0 == class0.field12 && (var0.field846 < 1536 || var0.field834 < 1536 || var0.field846 >= 11776 || var0.field834 >= 11776)) {
         var0.field829 = -1;
         var0.field805 = -1;
         var0.field843 = 0;
         var0.field844 = 0;
         var0.field846 = var0.field802 * 64 + var0.field809[0] * 128;
         var0.field834 = 128 * var0.field816[0] + var0.field802 * 64;
         var0.method790();
      }

      class3.method43(var0);
      var0.field801 = false;
      if(-1 != var0.field826) {
         var10 = client.method584(var0.field826);
         if(var10 != null && null != var10.field973) {
            ++var0.field828;
            if(var0.field827 < var10.field973.length && var0.field828 > var10.field975[var0.field827]) {
               var0.field828 = 1;
               ++var0.field827;
               class209.method3978(var10, var0.field827, var0.field846, var0.field834);
            }

            if(var0.field827 >= var10.field973.length) {
               var0.field828 = 0;
               var0.field827 = 0;
               class209.method3978(var10, var0.field827, var0.field846, var0.field834);
            }
         } else {
            var0.field826 = -1;
         }
      }

      if(var0.field805 != -1 && client.field286 >= var0.field837) {
         if(var0.field835 < 0) {
            var0.field835 = 0;
         }

         var1 = class10.method156(var0.field805).field1005;
         if(var1 != -1) {
            class42 var11 = client.method584(var1);
            if(null != var11 && null != var11.field973) {
               ++var0.field808;
               if(var0.field835 < var11.field973.length && var0.field808 > var11.field975[var0.field835]) {
                  var0.field808 = 1;
                  ++var0.field835;
                  class209.method3978(var11, var0.field835, var0.field846, var0.field834);
               }

               if(var0.field835 >= var11.field973.length && (var0.field835 < 0 || var0.field835 >= var11.field973.length)) {
                  var0.field805 = -1;
               }
            } else {
               var0.field805 = -1;
            }
         } else {
            var0.field805 = -1;
         }
      }

      if(var0.field829 != -1 && var0.field832 <= 1) {
         var10 = client.method584(var0.field829);
         if(1 == var10.field980 && var0.field856 > 0 && var0.field843 <= client.field286 && var0.field844 < client.field286) {
            var0.field832 = 1;
            return;
         }
      }

      if(-1 != var0.field829 && var0.field832 == 0) {
         var10 = client.method584(var0.field829);
         if(null != var10 && var10.field973 != null) {
            ++var0.field841;
            if(var0.field830 < var10.field973.length && var0.field841 > var10.field975[var0.field830]) {
               var0.field841 = 1;
               ++var0.field830;
               class209.method3978(var10, var0.field830, var0.field846, var0.field834);
            }

            if(var0.field830 >= var10.field973.length) {
               var0.field830 -= var10.field977 * -1;
               ++var0.field854;
               if(var0.field854 >= var10.field983) {
                  var0.field829 = -1;
               } else if(var0.field830 >= 0 && var0.field830 < var10.field973.length) {
                  class209.method3978(var10, var0.field830, var0.field846, var0.field834);
               } else {
                  var0.field829 = -1;
               }
            }

            var0.field801 = var10.field979;
         } else {
            var0.field829 = -1;
         }
      }

      if(var0.field832 > 0) {
         --var0.field832;
      }

   }

   @ObfuscatedName("j")
   public static long method610(CharSequence var0) {
      long var1 = 0L;
      int var3 = var0.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 *= 37L;
         char var5 = var0.charAt(var4);
         if(var5 >= 65 && var5 <= 90) {
            var1 += (long)(var5 + 1 - 65);
         } else if(var5 >= 97 && var5 <= 122) {
            var1 += (long)(var5 + 1 - 97);
         } else if(var5 >= 48 && var5 <= 57) {
            var1 += (long)(var5 + 27 - 48);
         }

         if(var1 >= 177917621779460413L) {
            break;
         }
      }

      while(var1 % 37L == 0L && var1 != 0L) {
         var1 /= 37L;
      }

      return var1;
   }

   @ObfuscatedName("l")
   public static byte[] method611(CharSequence var0) {
      int var1 = var0.length();
      byte[] var2 = new byte[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 <= 0 || var4 >= 128) && (var4 < 160 || var4 > 255)) {
            if(8364 == var4) {
               var2[var3] = -128;
            } else if(var4 == 8218) {
               var2[var3] = -126;
            } else if(var4 == 402) {
               var2[var3] = -125;
            } else if(8222 == var4) {
               var2[var3] = -124;
            } else if(var4 == 8230) {
               var2[var3] = -123;
            } else if(var4 == 8224) {
               var2[var3] = -122;
            } else if(8225 == var4) {
               var2[var3] = -121;
            } else if(710 == var4) {
               var2[var3] = -120;
            } else if(var4 == 8240) {
               var2[var3] = -119;
            } else if(352 == var4) {
               var2[var3] = -118;
            } else if(var4 == 8249) {
               var2[var3] = -117;
            } else if(var4 == 338) {
               var2[var3] = -116;
            } else if(var4 == 381) {
               var2[var3] = -114;
            } else if(8216 == var4) {
               var2[var3] = -111;
            } else if(var4 == 8217) {
               var2[var3] = -110;
            } else if(var4 == 8220) {
               var2[var3] = -109;
            } else if(var4 == 8221) {
               var2[var3] = -108;
            } else if(var4 == 8226) {
               var2[var3] = -107;
            } else if(var4 == 8211) {
               var2[var3] = -106;
            } else if(var4 == 8212) {
               var2[var3] = -105;
            } else if(var4 == 732) {
               var2[var3] = -104;
            } else if(var4 == 8482) {
               var2[var3] = -103;
            } else if(var4 == 353) {
               var2[var3] = -102;
            } else if(8250 == var4) {
               var2[var3] = -101;
            } else if(339 == var4) {
               var2[var3] = -100;
            } else if(382 == var4) {
               var2[var3] = -98;
            } else if(376 == var4) {
               var2[var3] = -97;
            } else {
               var2[var3] = 63;
            }
         } else {
            var2[var3] = (byte)var4;
         }
      }

      return var2;
   }

   @ObfuscatedName("bm")
   static final void method612(class16 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field223 == 0) {
         var1 = class24.field610.method1958(var0.field226, var0.field224, var0.field225);
      }

      if(var0.field223 == 1) {
         var1 = class24.field610.method1959(var0.field226, var0.field224, var0.field225);
      }

      if(2 == var0.field223) {
         var1 = class24.field610.method2046(var0.field226, var0.field224, var0.field225);
      }

      if(var0.field223 == 3) {
         var1 = class24.field610.method2082(var0.field226, var0.field224, var0.field225);
      }

      if(var1 != 0) {
         int var5 = class24.field610.method1962(var0.field226, var0.field224, var0.field225, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field232 = var2;
      var0.field228 = var3;
      var0.field227 = var4;
   }
}
