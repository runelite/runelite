import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
public class class112 {
   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Lclass39;II)V",
      garbageValue = "-1381706243"
   )
   static final void method2534(class39 var0, int var1) {
      class44 var2;
      int var3;
      int var4;
      int var12;
      if(var0.field891 > client.field305) {
         class17.method208(var0);
      } else if(var0.field878 >= client.field305) {
         class36.method777(var0);
      } else {
         var0.field860 = var0.field838;
         if(var0.field849 == 0) {
            var0.field889 = 0;
         } else {
            label586: {
               if(var0.field863 != -1 && var0.field864 == 0) {
                  var2 = class22.method585(var0.field863);
                  if(var0.field839 > 0 && var2.field1027 == 0) {
                     ++var0.field889;
                     break label586;
                  }

                  if(var0.field839 <= 0 && var2.field1028 == 0) {
                     ++var0.field889;
                     break label586;
                  }
               }

               var12 = var0.field875;
               var3 = var0.field832;
               var4 = var0.field886[var0.field849 - 1] * 128 + var0.field877 * 64;
               int var5 = 128 * var0.field887[var0.field849 - 1] + var0.field877 * 64;
               if(var12 < var4) {
                  if(var3 < var5) {
                     var0.field882 = 1280;
                  } else if(var3 > var5) {
                     var0.field882 = 1792;
                  } else {
                     var0.field882 = 1536;
                  }
               } else if(var12 > var4) {
                  if(var3 < var5) {
                     var0.field882 = 768;
                  } else if(var3 > var5) {
                     var0.field882 = 256;
                  } else {
                     var0.field882 = 512;
                  }
               } else if(var3 < var5) {
                  var0.field882 = 1024;
               } else if(var3 > var5) {
                  var0.field882 = 0;
               }

               byte var6 = var0.field888[var0.field849 - 1];
               if(var4 - var12 <= 256 && var4 - var12 >= -256 && var5 - var3 <= 256 && var5 - var3 >= -256) {
                  int var7 = var0.field882 - var0.field857 & 2047;
                  if(var7 > 1024) {
                     var7 -= 2048;
                  }

                  int var8 = var0.field840;
                  if(var7 >= -256 && var7 <= 256) {
                     var8 = var0.field879;
                  } else if(var7 >= 256 && var7 < 768) {
                     var8 = var0.field831;
                  } else if(var7 >= -768 && var7 <= -256) {
                     var8 = var0.field841;
                  }

                  if(var8 == -1) {
                     var8 = var0.field879;
                  }

                  var0.field860 = var8;
                  int var9 = 4;
                  boolean var10 = true;
                  if(var0 instanceof class36) {
                     var10 = ((class36)var0).field803.field941;
                  }

                  if(var10) {
                     if(var0.field882 != var0.field857 && var0.field844 == -1 && var0.field846 != 0) {
                        var9 = 2;
                     }

                     if(var0.field849 > 2) {
                        var9 = 6;
                     }

                     if(var0.field849 > 3) {
                        var9 = 8;
                     }

                     if(var0.field889 > 0 && var0.field849 > 1) {
                        var9 = 8;
                        --var0.field889;
                     }
                  } else {
                     if(var0.field849 > 1) {
                        var9 = 6;
                     }

                     if(var0.field849 > 2) {
                        var9 = 8;
                     }

                     if(var0.field889 > 0 && var0.field849 > 1) {
                        var9 = 8;
                        --var0.field889;
                     }
                  }

                  if(var6 == 2) {
                     var9 <<= 1;
                  }

                  if(var9 >= 8 && var0.field860 == var0.field879 && var0.field843 != -1) {
                     var0.field860 = var0.field843;
                  }

                  if(var4 != var12 || var5 != var3) {
                     if(var12 < var4) {
                        var0.field875 += var9;
                        if(var0.field875 > var4) {
                           var0.field875 = var4;
                        }
                     } else if(var12 > var4) {
                        var0.field875 -= var9;
                        if(var0.field875 < var4) {
                           var0.field875 = var4;
                        }
                     }

                     if(var3 < var5) {
                        var0.field832 += var9;
                        if(var0.field832 > var5) {
                           var0.field832 = var5;
                        }
                     } else if(var3 > var5) {
                        var0.field832 -= var9;
                        if(var0.field832 < var5) {
                           var0.field832 = var5;
                        }
                     }
                  }

                  if(var4 == var0.field875 && var0.field832 == var5) {
                     --var0.field849;
                     if(var0.field839 > 0) {
                        --var0.field839;
                     }
                  }
               } else {
                  var0.field875 = var4;
                  var0.field832 = var5;
                  --var0.field849;
                  if(var0.field839 > 0) {
                     --var0.field839;
                  }
               }
            }
         }
      }

      if(var0.field875 < 128 || var0.field832 < 128 || var0.field875 >= 13184 || var0.field832 >= 13184) {
         var0.field863 = -1;
         var0.field868 = -1;
         var0.field891 = 0;
         var0.field878 = 0;
         var0.field875 = var0.field877 * 64 + 128 * var0.field886[0];
         var0.field832 = 128 * var0.field887[0] + var0.field877 * 64;
         var0.method793();
      }

      if(class3.field65 == var0 && (var0.field875 < 1536 || var0.field832 < 1536 || var0.field875 >= 11776 || var0.field832 >= 11776)) {
         var0.field863 = -1;
         var0.field868 = -1;
         var0.field891 = 0;
         var0.field878 = 0;
         var0.field875 = var0.field877 * 64 + 128 * var0.field886[0];
         var0.field832 = var0.field877 * 64 + var0.field887[0] * 128;
         var0.method793();
      }

      if(var0.field846 != 0) {
         if(var0.field844 != -1) {
            Object var13 = null;
            if(var0.field844 < '耀') {
               var13 = client.field332[var0.field844];
            } else if(var0.field844 >= '耀') {
               var13 = client.field302[var0.field844 - '耀'];
            }

            if(var13 != null) {
               var3 = var0.field875 - ((class39)var13).field875;
               var4 = var0.field832 - ((class39)var13).field832;
               if(var3 != 0 || var4 != 0) {
                  var0.field882 = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
               }
            } else if(var0.field865) {
               var0.field844 = -1;
               var0.field865 = false;
            }
         }

         if(var0.field859 != -1 && (var0.field849 == 0 || var0.field889 > 0)) {
            var0.field882 = var0.field859;
            var0.field859 = -1;
         }

         var12 = var0.field882 - var0.field857 & 2047;
         if(var12 == 0 && var0.field865) {
            var0.field844 = -1;
            var0.field865 = false;
         }

         if(var12 != 0) {
            ++var0.field883;
            boolean var14;
            if(var12 > 1024) {
               var0.field857 -= var0.field846;
               var14 = true;
               if(var12 < var0.field846 || var12 > 2048 - var0.field846) {
                  var0.field857 = var0.field882;
                  var14 = false;
               }

               if(var0.field860 == var0.field838 && (var0.field883 > 25 || var14)) {
                  if(var0.field866 != -1) {
                     var0.field860 = var0.field866;
                  } else {
                     var0.field860 = var0.field879;
                  }
               }
            } else {
               var0.field857 += var0.field846;
               var14 = true;
               if(var12 < var0.field846 || var12 > 2048 - var0.field846) {
                  var0.field857 = var0.field882;
                  var14 = false;
               }

               if(var0.field860 == var0.field838 && (var0.field883 > 25 || var14)) {
                  if(var0.field853 != -1) {
                     var0.field860 = var0.field853;
                  } else {
                     var0.field860 = var0.field879;
                  }
               }
            }

            var0.field857 &= 2047;
         } else {
            var0.field883 = 0;
         }
      }

      var0.field834 = false;
      if(var0.field860 != -1) {
         var2 = class22.method585(var0.field860);
         if(var2 != null && var2.field1030 != null) {
            ++var0.field862;
            if(var0.field861 < var2.field1030.length && var0.field862 > var2.field1018[var0.field861]) {
               var0.field862 = 1;
               ++var0.field861;
               method2537(var2, var0.field861, var0.field875, var0.field832);
            }

            if(var0.field861 >= var2.field1030.length) {
               var0.field862 = 0;
               var0.field861 = 0;
               method2537(var2, var0.field861, var0.field875, var0.field832);
            }
         } else {
            var0.field860 = -1;
         }
      }

      if(var0.field868 != -1 && client.field305 >= var0.field871) {
         if(var0.field890 < 0) {
            var0.field890 = 0;
         }

         var12 = class110.method2488(var0.field868).field1042;
         if(var12 != -1) {
            class44 var11 = class22.method585(var12);
            if(var11 != null && null != var11.field1030) {
               ++var0.field858;
               if(var0.field890 < var11.field1030.length && var0.field858 > var11.field1018[var0.field890]) {
                  var0.field858 = 1;
                  ++var0.field890;
                  method2537(var11, var0.field890, var0.field875, var0.field832);
               }

               if(var0.field890 >= var11.field1030.length && (var0.field890 < 0 || var0.field890 >= var11.field1030.length)) {
                  var0.field868 = -1;
               }
            } else {
               var0.field868 = -1;
            }
         } else {
            var0.field868 = -1;
         }
      }

      if(var0.field863 != -1 && var0.field864 <= 1) {
         var2 = class22.method585(var0.field863);
         if(var2.field1027 == 1 && var0.field839 > 0 && var0.field891 <= client.field305 && var0.field878 < client.field305) {
            var0.field864 = 1;
            return;
         }
      }

      if(var0.field863 != -1 && var0.field864 == 0) {
         var2 = class22.method585(var0.field863);
         if(null != var2 && null != var2.field1030) {
            ++var0.field848;
            if(var0.field836 < var2.field1030.length && var0.field848 > var2.field1018[var0.field836]) {
               var0.field848 = 1;
               ++var0.field836;
               method2537(var2, var0.field836, var0.field875, var0.field832);
            }

            if(var0.field836 >= var2.field1030.length) {
               var0.field836 -= var2.field1020;
               ++var0.field867;
               if(var0.field867 >= var2.field1011) {
                  var0.field863 = -1;
               } else if(var0.field836 >= 0 && var0.field836 < var2.field1030.length) {
                  method2537(var2, var0.field836, var0.field875, var0.field832);
               } else {
                  var0.field863 = -1;
               }
            }

            var0.field834 = var2.field1032;
         } else {
            var0.field863 = -1;
         }
      }

      if(var0.field864 > 0) {
         --var0.field864;
      }

   }

   static {
      new HashMap();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass44;IIIB)V",
      garbageValue = "1"
   )
   static void method2537(class44 var0, int var1, int var2, int var3) {
      if(client.field536 < 50 && client.field535 != 0) {
         if(var0.field1016 != null && var1 < var0.field1016.length) {
            int var4 = var0.field1016[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               client.field319[client.field536] = var5;
               client.field538[client.field536] = var6;
               client.field539[client.field536] = 0;
               client.field541[client.field536] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               client.field528[client.field536] = var7 + (var8 << 16) + (var9 << 8);
               ++client.field536;
            }
         }
      }
   }
}
