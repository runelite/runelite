import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fz")
public final class class162 {
   @ObfuscatedName("dc")
   static byte[][] field2656;

   @ObfuscatedName("aw")
   static final void method3179(class37 var0) {
      int var1;
      class42 var10;
      if(var0.field855 > client.field394) {
         class105.method2334(var0);
      } else {
         int var2;
         int var3;
         int var4;
         int var6;
         if(var0.field856 >= client.field394) {
            if(client.field394 == var0.field856 || -1 == var0.field820 || 0 != var0.field844 || 1 + var0.field837 > class36.method741(var0.field820).field988[var0.field827]) {
               var1 = var0.field856 - var0.field855;
               var2 = client.field394 - var0.field855;
               var3 = var0.field851 * 128 + var0.field814 * 64;
               var4 = var0.field814 * 64 + var0.field832 * 128;
               int var5 = var0.field814 * 64 + var0.field810 * 128;
               var6 = var0.field814 * 64 + var0.field854 * 128;
               var0.field839 = (var2 * var5 + (var1 - var2) * var3) / var1;
               var0.field848 = (var6 * var2 + var4 * (var1 - var2)) / var1;
            }

            var0.field867 = 0;
            var0.field860 = var0.field865;
            var0.field852 = var0.field860;
         } else {
            var0.field838 = var0.field815;
            if(0 == var0.field824) {
               var0.field867 = 0;
            } else {
               label474: {
                  if(var0.field820 != -1 && var0.field844 == 0) {
                     var10 = class36.method741(var0.field820);
                     if(var0.field868 > 0 && 0 == var10.field999) {
                        ++var0.field867;
                        break label474;
                     }

                     if(var0.field868 <= 0 && 0 == var10.field998) {
                        ++var0.field867;
                        break label474;
                     }
                  }

                  var1 = var0.field839;
                  var2 = var0.field848;
                  var3 = var0.field864[var0.field824 - 1] * 128 + var0.field814 * 64;
                  var4 = var0.field814 * 64 + 128 * var0.field817[var0.field824 - 1];
                  if(var1 < var3) {
                     if(var2 < var4) {
                        var0.field860 = 1280;
                     } else if(var2 > var4) {
                        var0.field860 = 1792;
                     } else {
                        var0.field860 = 1536;
                     }
                  } else if(var1 > var3) {
                     if(var2 < var4) {
                        var0.field860 = 768;
                     } else if(var2 > var4) {
                        var0.field860 = 256;
                     } else {
                        var0.field860 = 512;
                     }
                  } else if(var2 < var4) {
                     var0.field860 = 1024;
                  } else if(var2 > var4) {
                     var0.field860 = 0;
                  }

                  byte var12 = var0.field866[var0.field824 - 1];
                  if(var3 - var1 <= 256 && var3 - var1 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
                     var6 = var0.field860 - var0.field852 & 2047;
                     if(var6 > 1024) {
                        var6 -= 2048;
                     }

                     int var7 = var0.field819;
                     if(var6 >= -256 && var6 <= 256) {
                        var7 = var0.field818;
                     } else if(var6 >= 256 && var6 < 768) {
                        var7 = var0.field821;
                     } else if(var6 >= -768 && var6 <= -256) {
                        var7 = var0.field811;
                     }

                     if(-1 == var7) {
                        var7 = var0.field818;
                     }

                     var0.field838 = var7;
                     int var8 = 4;
                     boolean var9 = true;
                     if(var0 instanceof class34) {
                        var9 = ((class34)var0).field779.field891;
                     }

                     if(var9) {
                        if(var0.field852 != var0.field860 && var0.field835 == -1 && 0 != var0.field862) {
                           var8 = 2;
                        }

                        if(var0.field824 > 2) {
                           var8 = 6;
                        }

                        if(var0.field824 > 3) {
                           var8 = 8;
                        }

                        if(var0.field867 > 0 && var0.field824 > 1) {
                           var8 = 8;
                           --var0.field867;
                        }
                     } else {
                        if(var0.field824 > 1) {
                           var8 = 6;
                        }

                        if(var0.field824 > 2) {
                           var8 = 8;
                        }

                        if(var0.field867 > 0 && var0.field824 > 1) {
                           var8 = 8;
                           --var0.field867;
                        }
                     }

                     if(2 == var12) {
                        var8 <<= 1;
                     }

                     if(var8 >= 8 && var0.field838 == var0.field818 && -1 != var0.field822) {
                        var0.field838 = var0.field822;
                     }

                     if(var1 != var3 || var4 != var2) {
                        if(var1 < var3) {
                           var0.field839 += var8;
                           if(var0.field839 > var3) {
                              var0.field839 = var3;
                           }
                        } else if(var1 > var3) {
                           var0.field839 -= var8;
                           if(var0.field839 < var3) {
                              var0.field839 = var3;
                           }
                        }

                        if(var2 < var4) {
                           var0.field848 += var8;
                           if(var0.field848 > var4) {
                              var0.field848 = var4;
                           }
                        } else if(var2 > var4) {
                           var0.field848 -= var8;
                           if(var0.field848 < var4) {
                              var0.field848 = var4;
                           }
                        }
                     }

                     if(var3 == var0.field839 && var4 == var0.field848) {
                        --var0.field824;
                        if(var0.field868 > 0) {
                           --var0.field868;
                        }
                     }
                  } else {
                     var0.field839 = var3;
                     var0.field848 = var4;
                     --var0.field824;
                     if(var0.field868 > 0) {
                        --var0.field868;
                     }
                  }
               }
            }
         }
      }

      if(var0.field839 < 128 || var0.field848 < 128 || var0.field839 >= 13184 || var0.field848 >= 13184) {
         var0.field820 = -1;
         var0.field846 = -1;
         var0.field855 = 0;
         var0.field856 = 0;
         var0.field839 = 128 * var0.field864[0] + var0.field814 * 64;
         var0.field848 = var0.field814 * 64 + 128 * var0.field817[0];
         var0.method751();
      }

      if(class148.field2249 == var0 && (var0.field839 < 1536 || var0.field848 < 1536 || var0.field839 >= 11776 || var0.field848 >= 11776)) {
         var0.field820 = -1;
         var0.field846 = -1;
         var0.field855 = 0;
         var0.field856 = 0;
         var0.field839 = var0.field814 * 64 + var0.field864[0] * 128;
         var0.field848 = var0.field817[0] * 128 + var0.field814 * 64;
         var0.method751();
      }

      class9.method115(var0);
      var0.field813 = false;
      if(var0.field838 != -1) {
         var10 = class36.method741(var0.field838);
         if(var10 != null && null != var10.field986) {
            ++var0.field840;
            if(var0.field829 < var10.field986.length && var0.field840 > var10.field988[var0.field829]) {
               var0.field840 = 1;
               ++var0.field829;
               class41.method859(var10, var0.field829, var0.field839, var0.field848);
            }

            if(var0.field829 >= var10.field986.length) {
               var0.field840 = 0;
               var0.field829 = 0;
               class41.method859(var10, var0.field829, var0.field839, var0.field848);
            }
         } else {
            var0.field838 = -1;
         }
      }

      if(-1 != var0.field846 && client.field394 >= var0.field833) {
         if(var0.field847 < 0) {
            var0.field847 = 0;
         }

         var1 = class26.method635(var0.field846).field1012;
         if(var1 != -1) {
            class42 var11 = class36.method741(var1);
            if(var11 != null && null != var11.field986) {
               ++var0.field841;
               if(var0.field847 < var11.field986.length && var0.field841 > var11.field988[var0.field847]) {
                  var0.field841 = 1;
                  ++var0.field847;
                  class41.method859(var11, var0.field847, var0.field839, var0.field848);
               }

               if(var0.field847 >= var11.field986.length && (var0.field847 < 0 || var0.field847 >= var11.field986.length)) {
                  var0.field846 = -1;
               }
            } else {
               var0.field846 = -1;
            }
         } else {
            var0.field846 = -1;
         }
      }

      if(-1 != var0.field820 && var0.field844 <= 1) {
         var10 = class36.method741(var0.field820);
         if(1 == var10.field999 && var0.field868 > 0 && var0.field855 <= client.field394 && var0.field856 < client.field394) {
            var0.field844 = 1;
            return;
         }
      }

      if(var0.field820 != -1 && var0.field844 == 0) {
         var10 = class36.method741(var0.field820);
         if(null != var10 && var10.field986 != null) {
            ++var0.field837;
            if(var0.field827 < var10.field986.length && var0.field837 > var10.field988[var0.field827]) {
               var0.field837 = 1;
               ++var0.field827;
               class41.method859(var10, var0.field827, var0.field839, var0.field848);
            }

            if(var0.field827 >= var10.field986.length) {
               var0.field827 -= var10.field983 * -1;
               ++var0.field845;
               if(var0.field845 >= var10.field996) {
                  var0.field820 = -1;
               } else if(var0.field827 >= 0 && var0.field827 < var10.field986.length) {
                  class41.method859(var10, var0.field827, var0.field839, var0.field848);
               } else {
                  var0.field820 = -1;
               }
            }

            var0.field813 = var10.field992;
         } else {
            var0.field820 = -1;
         }
      }

      if(var0.field844 > 0) {
         --var0.field844;
      }

   }
}
