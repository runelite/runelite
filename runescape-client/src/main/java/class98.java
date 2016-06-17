import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("GameObject")
public final class class98 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1661822251
   )
   int field1628;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1590899505
   )
   @Export("height")
   int field1629;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -161842359
   )
   @Export("orientation")
   int field1630;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1821821647
   )
   @Export("y")
   int field1631;
   @ObfuscatedName("x")
   @Export("renderable")
   public class85 field1632;
   @ObfuscatedName("an")
   static int[] field1633;
   @ObfuscatedName("o")
   static String field1634;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1778125649
   )
   @Export("offsetX")
   int field1635;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1987653739
   )
   @Export("relativeY")
   int field1636;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -923433525
   )
   @Export("offsetY")
   int field1637;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 249722121
   )
   int field1639;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1183398191
   )
   @Export("hash")
   public int field1640 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2082390521
   )
   @Export("flags")
   int field1641 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -601582089
   )
   @Export("relativeX")
   int field1642;
   @ObfuscatedName("de")
   static int[] field1643;
   @ObfuscatedName("py")
   static class134 field1644;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1278298759
   )
   @Export("plane")
   int field1645;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 627038807
   )
   @Export("x")
   int field1650;

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(Lclass37;II)V",
      garbageValue = "-1893498541"
   )
   static final void method2199(class37 var0, int var1) {
      int var2;
      class42 var11;
      if(var0.field843 > client.field296) {
         class1.method10(var0);
      } else {
         int var3;
         int var4;
         int var5;
         int var7;
         if(var0.field845 >= client.field296) {
            if(var0.field845 == client.field296 || var0.field801 == -1 || var0.field827 != 0 || var0.field823 + 1 > class17.method178(var0.field801).field983[var0.field822]) {
               var2 = var0.field845 - var0.field843;
               var3 = client.field296 - var0.field843;
               var4 = var0.field837 * 128 + var0.field832 * 64;
               var5 = var0.field833 * 128 + var0.field832 * 64;
               int var6 = var0.field824 * 128 + var0.field832 * 64;
               var7 = var0.field799 * 128 + var0.field832 * 64;
               var0.field813 = (var3 * var6 + (var2 - var3) * var4) / var2;
               var0.field791 = (var5 * (var2 - var3) + var7 * var3) / var2;
            }

            var0.field847 = 0;
            var0.field840 = var0.field826;
            var0.field792 = var0.field840;
         } else {
            var0.field818 = var0.field795;
            if(var0.field808 == 0) {
               var0.field847 = 0;
            } else {
               label477: {
                  if(var0.field801 != -1 && var0.field827 == 0) {
                     var11 = class17.method178(var0.field801);
                     if(var0.field836 > 0 && var11.field977 == 0) {
                        ++var0.field847;
                        break label477;
                     }

                     if(var0.field836 <= 0 && var11.field978 == 0) {
                        ++var0.field847;
                        break label477;
                     }
                  }

                  var2 = var0.field813;
                  var3 = var0.field791;
                  var4 = 128 * var0.field844[var0.field808 - 1] + var0.field832 * 64;
                  var5 = var0.field831[var0.field808 - 1] * 128 + var0.field832 * 64;
                  if(var2 < var4) {
                     if(var3 < var5) {
                        var0.field840 = 1280;
                     } else if(var3 > var5) {
                        var0.field840 = 1792;
                     } else {
                        var0.field840 = 1536;
                     }
                  } else if(var2 > var4) {
                     if(var3 < var5) {
                        var0.field840 = 768;
                     } else if(var3 > var5) {
                        var0.field840 = 256;
                     } else {
                        var0.field840 = 512;
                     }
                  } else if(var3 < var5) {
                     var0.field840 = 1024;
                  } else if(var3 > var5) {
                     var0.field840 = 0;
                  }

                  byte var13 = var0.field846[var0.field808 - 1];
                  if(var4 - var2 <= 256 && var4 - var2 >= -256 && var5 - var3 <= 256 && var5 - var3 >= -256) {
                     var7 = var0.field840 - var0.field792 & 2047;
                     if(var7 > 1024) {
                        var7 -= 2048;
                     }

                     int var8 = var0.field821;
                     if(var7 >= -256 && var7 <= 256) {
                        var8 = var0.field798;
                     } else if(var7 >= 256 && var7 < 768) {
                        var8 = var0.field848;
                     } else if(var7 >= -768 && var7 <= -256) {
                        var8 = var0.field800;
                     }

                     if(var8 == -1) {
                        var8 = var0.field798;
                     }

                     var0.field818 = var8;
                     int var9 = 4;
                     boolean var10 = true;
                     if(var0 instanceof class34) {
                        var10 = ((class34)var0).field762.field888;
                     }

                     if(var10) {
                        if(var0.field840 != var0.field792 && var0.field815 == -1 && var0.field842 != 0) {
                           var9 = 2;
                        }

                        if(var0.field808 > 2) {
                           var9 = 6;
                        }

                        if(var0.field808 > 3) {
                           var9 = 8;
                        }

                        if(var0.field847 > 0 && var0.field808 > 1) {
                           var9 = 8;
                           --var0.field847;
                        }
                     } else {
                        if(var0.field808 > 1) {
                           var9 = 6;
                        }

                        if(var0.field808 > 2) {
                           var9 = 8;
                        }

                        if(var0.field847 > 0 && var0.field808 > 1) {
                           var9 = 8;
                           --var0.field847;
                        }
                     }

                     if(var13 == 2) {
                        var9 <<= 1;
                     }

                     if(var9 >= 8 && var0.field798 == var0.field818 && var0.field802 != -1) {
                        var0.field818 = var0.field802;
                     }

                     if(var2 != var4 || var3 != var5) {
                        if(var2 < var4) {
                           var0.field813 += var9;
                           if(var0.field813 > var4) {
                              var0.field813 = var4;
                           }
                        } else if(var2 > var4) {
                           var0.field813 -= var9;
                           if(var0.field813 < var4) {
                              var0.field813 = var4;
                           }
                        }

                        if(var3 < var5) {
                           var0.field791 += var9;
                           if(var0.field791 > var5) {
                              var0.field791 = var5;
                           }
                        } else if(var3 > var5) {
                           var0.field791 -= var9;
                           if(var0.field791 < var5) {
                              var0.field791 = var5;
                           }
                        }
                     }

                     if(var0.field813 == var4 && var5 == var0.field791) {
                        --var0.field808;
                        if(var0.field836 > 0) {
                           --var0.field836;
                        }
                     }
                  } else {
                     var0.field813 = var4;
                     var0.field791 = var5;
                     --var0.field808;
                     if(var0.field836 > 0) {
                        --var0.field836;
                     }
                  }
               }
            }
         }
      }

      if(var0.field813 < 128 || var0.field791 < 128 || var0.field813 >= 13184 || var0.field791 >= 13184) {
         var0.field801 = -1;
         var0.field835 = -1;
         var0.field843 = 0;
         var0.field845 = 0;
         var0.field813 = var0.field832 * 64 + 128 * var0.field844[0];
         var0.field791 = var0.field832 * 64 + var0.field831[0] * 128;
         var0.method752();
      }

      if(var0 == class153.field2262 && (var0.field813 < 1536 || var0.field791 < 1536 || var0.field813 >= 11776 || var0.field791 >= 11776)) {
         var0.field801 = -1;
         var0.field835 = -1;
         var0.field843 = 0;
         var0.field845 = 0;
         var0.field813 = var0.field832 * 64 + 128 * var0.field844[0];
         var0.field791 = var0.field832 * 64 + 128 * var0.field831[0];
         var0.method752();
      }

      class6.method88(var0);
      var0.field793 = false;
      if(var0.field818 != -1) {
         var11 = class17.method178(var0.field818);
         if(var11 != null && var11.field965 != null) {
            ++var0.field820;
            if(var0.field819 < var11.field965.length && var0.field820 > var11.field983[var0.field819]) {
               var0.field820 = 1;
               ++var0.field819;
               class122.method2808(var11, var0.field819, var0.field813, var0.field791);
            }

            if(var0.field819 >= var11.field965.length) {
               var0.field820 = 0;
               var0.field819 = 0;
               class122.method2808(var11, var0.field819, var0.field813, var0.field791);
            }
         } else {
            var0.field818 = -1;
         }
      }

      if(var0.field835 != -1 && client.field296 >= var0.field829) {
         if(var0.field811 < 0) {
            var0.field811 = 0;
         }

         var2 = class32.method708(var0.field835).field990;
         if(var2 != -1) {
            class42 var12 = class17.method178(var2);
            if(var12 != null && var12.field965 != null) {
               ++var0.field828;
               if(var0.field811 < var12.field965.length && var0.field828 > var12.field983[var0.field811]) {
                  var0.field828 = 1;
                  ++var0.field811;
                  class122.method2808(var12, var0.field811, var0.field813, var0.field791);
               }

               if(var0.field811 >= var12.field965.length && (var0.field811 < 0 || var0.field811 >= var12.field965.length)) {
                  var0.field835 = -1;
               }
            } else {
               var0.field835 = -1;
            }
         } else {
            var0.field835 = -1;
         }
      }

      if(var0.field801 != -1 && var0.field827 <= 1) {
         var11 = class17.method178(var0.field801);
         if(var11.field977 == 1 && var0.field836 > 0 && var0.field843 <= client.field296 && var0.field845 < client.field296) {
            var0.field827 = 1;
            return;
         }
      }

      if(var0.field801 != -1 && var0.field827 == 0) {
         var11 = class17.method178(var0.field801);
         if(null != var11 && null != var11.field965) {
            ++var0.field823;
            if(var0.field822 < var11.field965.length && var0.field823 > var11.field983[var0.field822]) {
               var0.field823 = 1;
               ++var0.field822;
               class122.method2808(var11, var0.field822, var0.field813, var0.field791);
            }

            if(var0.field822 >= var11.field965.length) {
               var0.field822 -= var11.field966;
               ++var0.field825;
               if(var0.field825 >= var11.field976) {
                  var0.field801 = -1;
               } else if(var0.field822 >= 0 && var0.field822 < var11.field965.length) {
                  class122.method2808(var11, var0.field822, var0.field813, var0.field791);
               } else {
                  var0.field801 = -1;
               }
            }

            var0.field793 = var11.field964;
         } else {
            var0.field801 = -1;
         }
      }

      if(var0.field827 > 0) {
         --var0.field827;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ZS)V",
      garbageValue = "14645"
   )
   public static void method2200(boolean var0) {
      if(class171.field2719 != null) {
         try {
            class119 var1 = new class119(4);
            var1.method2650(var0?2:3);
            var1.method2501(0);
            class171.field2719.method3020(var1.field1982, 0, 4);
         } catch (IOException var4) {
            try {
               class171.field2719.method3025();
            } catch (Exception var3) {
               ;
            }

            ++class171.field2710;
            class171.field2719 = null;
         }

      }
   }
}
