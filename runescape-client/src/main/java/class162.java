import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
public final class class162 {
   @ObfuscatedName("j")
   public static final char[] field2642 = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass37;II)V",
      garbageValue = "2118525306"
   )
   static final void method3159(class37 var0, int var1) {
      int var2;
      int var3;
      int var4;
      class42 var11;
      if(var0.field839 > client.field285) {
         var2 = var0.field839 - client.field285;
         var3 = var0.field795 * 64 + var0.field835 * 128;
         var4 = var0.field795 * 64 + var0.field837 * 128;
         var0.field816 += (var3 - var0.field816) / var2;
         var0.field840 += (var4 - var0.field840) / var2;
         var0.field823 = 0;
         var0.field844 = var0.field841;
      } else if(var0.field801 >= client.field285) {
         class41.method842(var0);
      } else {
         var0.field854 = var0.field799;
         if(var0.field820 == 0) {
            var0.field823 = 0;
         } else {
            label459: {
               if(-1 != var0.field825 && 0 == var0.field849) {
                  var11 = class161.method3153(var0.field825);
                  if(var0.field852 > 0 && 0 == var11.field983) {
                     ++var0.field823;
                     break label459;
                  }

                  if(var0.field852 <= 0 && 0 == var11.field976) {
                     ++var0.field823;
                     break label459;
                  }
               }

               var2 = var0.field816;
               var3 = var0.field840;
               var4 = var0.field795 * 64 + 128 * var0.field848[var0.field820 - 1];
               int var5 = var0.field795 * 64 + var0.field822[var0.field820 - 1] * 128;
               if(var2 < var4) {
                  if(var3 < var5) {
                     var0.field844 = 1280;
                  } else if(var3 > var5) {
                     var0.field844 = 1792;
                  } else {
                     var0.field844 = 1536;
                  }
               } else if(var2 > var4) {
                  if(var3 < var5) {
                     var0.field844 = 768;
                  } else if(var3 > var5) {
                     var0.field844 = 256;
                  } else {
                     var0.field844 = 512;
                  }
               } else if(var3 < var5) {
                  var0.field844 = 1024;
               } else if(var3 > var5) {
                  var0.field844 = 0;
               }

               byte var6 = var0.field850[var0.field820 - 1];
               if(var4 - var2 <= 256 && var4 - var2 >= -256 && var5 - var3 <= 256 && var5 - var3 >= -256) {
                  int var7 = var0.field844 - var0.field796 & 2047;
                  if(var7 > 1024) {
                     var7 -= 2048;
                  }

                  int var8 = var0.field803;
                  if(var7 >= -256 && var7 <= 256) {
                     var8 = var0.field802;
                  } else if(var7 >= 256 && var7 < 768) {
                     var8 = var0.field847;
                  } else if(var7 >= -768 && var7 <= -256) {
                     var8 = var0.field851;
                  }

                  if(var8 == -1) {
                     var8 = var0.field802;
                  }

                  var0.field854 = var8;
                  int var9 = 4;
                  boolean var10 = true;
                  if(var0 instanceof class34) {
                     var10 = ((class34)var0).field761.field896;
                  }

                  if(var10) {
                     if(var0.field796 != var0.field844 && -1 == var0.field819 && var0.field808 != 0) {
                        var9 = 2;
                     }

                     if(var0.field820 > 2) {
                        var9 = 6;
                     }

                     if(var0.field820 > 3) {
                        var9 = 8;
                     }

                     if(var0.field823 > 0 && var0.field820 > 1) {
                        var9 = 8;
                        --var0.field823;
                     }
                  } else {
                     if(var0.field820 > 1) {
                        var9 = 6;
                     }

                     if(var0.field820 > 2) {
                        var9 = 8;
                     }

                     if(var0.field823 > 0 && var0.field820 > 1) {
                        var9 = 8;
                        --var0.field823;
                     }
                  }

                  if(var6 == 2) {
                     var9 <<= 1;
                  }

                  if(var9 >= 8 && var0.field854 == var0.field802 && -1 != var0.field806) {
                     var0.field854 = var0.field806;
                  }

                  if(var4 != var2 || var3 != var5) {
                     if(var2 < var4) {
                        var0.field816 += var9;
                        if(var0.field816 > var4) {
                           var0.field816 = var4;
                        }
                     } else if(var2 > var4) {
                        var0.field816 -= var9;
                        if(var0.field816 < var4) {
                           var0.field816 = var4;
                        }
                     }

                     if(var3 < var5) {
                        var0.field840 += var9;
                        if(var0.field840 > var5) {
                           var0.field840 = var5;
                        }
                     } else if(var3 > var5) {
                        var0.field840 -= var9;
                        if(var0.field840 < var5) {
                           var0.field840 = var5;
                        }
                     }
                  }

                  if(var4 == var0.field816 && var0.field840 == var5) {
                     --var0.field820;
                     if(var0.field852 > 0) {
                        --var0.field852;
                     }
                  }
               } else {
                  var0.field816 = var4;
                  var0.field840 = var5;
                  --var0.field820;
                  if(var0.field852 > 0) {
                     --var0.field852;
                  }
               }
            }
         }
      }

      if(var0.field816 < 128 || var0.field840 < 128 || var0.field816 >= 13184 || var0.field840 >= 13184) {
         var0.field825 = -1;
         var0.field856 = -1;
         var0.field839 = 0;
         var0.field801 = 0;
         var0.field816 = var0.field848[0] * 128 + var0.field795 * 64;
         var0.field840 = var0.field822[0] * 128 + var0.field795 * 64;
         var0.method741();
      }

      if(var0 == class47.field1053 && (var0.field816 < 1536 || var0.field840 < 1536 || var0.field816 >= 11776 || var0.field840 >= 11776)) {
         var0.field825 = -1;
         var0.field856 = -1;
         var0.field839 = 0;
         var0.field801 = 0;
         var0.field816 = 128 * var0.field848[0] + var0.field795 * 64;
         var0.field840 = 128 * var0.field822[0] + var0.field795 * 64;
         var0.method741();
      }

      class51.method1044(var0);
      var0.field843 = false;
      if(var0.field854 != -1) {
         var11 = class161.method3153(var0.field854);
         if(null != var11 && var11.field972 != null) {
            ++var0.field824;
            if(var0.field798 < var11.field972.length && var0.field824 > var11.field974[var0.field798]) {
               var0.field824 = 1;
               ++var0.field798;
               class87.method2080(var11, var0.field798, var0.field816, var0.field840);
            }

            if(var0.field798 >= var11.field972.length) {
               var0.field824 = 0;
               var0.field798 = 0;
               class87.method2080(var11, var0.field798, var0.field816, var0.field840);
            }
         } else {
            var0.field854 = -1;
         }
      }

      if(-1 != var0.field856 && client.field285 >= var0.field833) {
         if(var0.field831 < 0) {
            var0.field831 = 0;
         }

         var2 = class19.method239(var0.field856).field993;
         if(var2 != -1) {
            class42 var12 = class161.method3153(var2);
            if(var12 != null && var12.field972 != null) {
               ++var0.field832;
               if(var0.field831 < var12.field972.length && var0.field832 > var12.field974[var0.field831]) {
                  var0.field832 = 1;
                  ++var0.field831;
                  class87.method2080(var12, var0.field831, var0.field816, var0.field840);
               }

               if(var0.field831 >= var12.field972.length && (var0.field831 < 0 || var0.field831 >= var12.field972.length)) {
                  var0.field856 = -1;
               }
            } else {
               var0.field856 = -1;
            }
         } else {
            var0.field856 = -1;
         }
      }

      if(-1 != var0.field825 && var0.field849 <= 1) {
         var11 = class161.method3153(var0.field825);
         if(var11.field983 == 1 && var0.field852 > 0 && var0.field839 <= client.field285 && var0.field801 < client.field285) {
            var0.field849 = 1;
            return;
         }
      }

      if(-1 != var0.field825 && var0.field849 == 0) {
         var11 = class161.method3153(var0.field825);
         if(null != var11 && null != var11.field972) {
            ++var0.field827;
            if(var0.field826 < var11.field972.length && var0.field827 > var11.field974[var0.field826]) {
               var0.field827 = 1;
               ++var0.field826;
               class87.method2080(var11, var0.field826, var0.field816, var0.field840);
            }

            if(var0.field826 >= var11.field972.length) {
               var0.field826 -= var11.field967;
               ++var0.field829;
               if(var0.field829 >= var11.field982) {
                  var0.field825 = -1;
               } else if(var0.field826 >= 0 && var0.field826 < var11.field972.length) {
                  class87.method2080(var11, var0.field826, var0.field816, var0.field840);
               } else {
                  var0.field825 = -1;
               }
            }

            var0.field843 = var11.field978;
         } else {
            var0.field825 = -1;
         }
      }

      if(var0.field849 > 0) {
         --var0.field849;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-17"
   )
   static void method3163() {
      Object var0 = class170.field2704;
      synchronized(class170.field2704) {
         if(class170.field2705 == 0) {
            class142.field2153.method2851(new class170(), 5);
         }

         class170.field2705 = 600;
      }
   }
}
