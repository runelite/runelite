import java.awt.Component;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
public abstract class class134 {
   @ObfuscatedName("v")
   static class215 field2117;
   @ObfuscatedName("g")
   public static class170 field2118;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "25"
   )
   public abstract void vmethod3156(Component var1);

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "3"
   )
   public abstract int vmethod3159();

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1169137639"
   )
   public abstract void vmethod3155(Component var1);

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Lclass39;II)V",
      garbageValue = "-147083232"
   )
   static final void method2900(class39 var0, int var1) {
      class44 var2;
      int var11;
      if(var0.field852 > client.field282) {
         class51.method1094(var0);
      } else if(var0.field877 >= client.field282) {
         class19.method228(var0);
      } else {
         var0.field859 = var0.field847;
         if(var0.field875 == 0) {
            var0.field888 = 0;
         } else {
            label454: {
               if(var0.field884 != -1 && var0.field865 == 0) {
                  var2 = class28.method646(var0.field884);
                  if(var0.field851 > 0 && var2.field1019 == 0) {
                     ++var0.field888;
                     break label454;
                  }

                  if(var0.field851 <= 0 && var2.field1020 == 0) {
                     ++var0.field888;
                     break label454;
                  }
               }

               var11 = var0.field864;
               int var12 = var0.field831;
               int var4 = var0.field858 * 64 + var0.field885[var0.field875 - 1] * 128;
               int var5 = var0.field858 * 64 + var0.field886[var0.field875 - 1] * 128;
               if(var11 < var4) {
                  if(var12 < var5) {
                     var0.field881 = 1280;
                  } else if(var12 > var5) {
                     var0.field881 = 1792;
                  } else {
                     var0.field881 = 1536;
                  }
               } else if(var11 > var4) {
                  if(var12 < var5) {
                     var0.field881 = 768;
                  } else if(var12 > var5) {
                     var0.field881 = 256;
                  } else {
                     var0.field881 = 512;
                  }
               } else if(var12 < var5) {
                  var0.field881 = 1024;
               } else if(var12 > var5) {
                  var0.field881 = 0;
               }

               byte var6 = var0.field887[var0.field875 - 1];
               if(var4 - var11 <= 256 && var4 - var11 >= -256 && var5 - var12 <= 256 && var5 - var12 >= -256) {
                  int var7 = var0.field881 - var0.field832 & 2047;
                  if(var7 > 1024) {
                     var7 -= 2048;
                  }

                  int var8 = var0.field878;
                  if(var7 >= -256 && var7 <= 256) {
                     var8 = var0.field839;
                  } else if(var7 >= 256 && var7 < 768) {
                     var8 = var0.field841;
                  } else if(var7 >= -768 && var7 <= -256) {
                     var8 = var0.field840;
                  }

                  if(var8 == -1) {
                     var8 = var0.field839;
                  }

                  var0.field859 = var8;
                  int var9 = 4;
                  boolean var10 = true;
                  if(var0 instanceof class36) {
                     var10 = ((class36)var0).field802.field938;
                  }

                  if(var10) {
                     if(var0.field881 != var0.field832 && var0.field856 == -1 && var0.field883 != 0) {
                        var9 = 2;
                     }

                     if(var0.field875 > 2) {
                        var9 = 6;
                     }

                     if(var0.field875 > 3) {
                        var9 = 8;
                     }

                     if(var0.field888 > 0 && var0.field875 > 1) {
                        var9 = 8;
                        --var0.field888;
                     }
                  } else {
                     if(var0.field875 > 1) {
                        var9 = 6;
                     }

                     if(var0.field875 > 2) {
                        var9 = 8;
                     }

                     if(var0.field888 > 0 && var0.field875 > 1) {
                        var9 = 8;
                        --var0.field888;
                     }
                  }

                  if(var6 == 2) {
                     var9 <<= 1;
                  }

                  if(var9 >= 8 && var0.field839 == var0.field859 && var0.field842 != -1) {
                     var0.field859 = var0.field842;
                  }

                  if(var4 != var11 || var5 != var12) {
                     if(var11 < var4) {
                        var0.field864 += var9;
                        if(var0.field864 > var4) {
                           var0.field864 = var4;
                        }
                     } else if(var11 > var4) {
                        var0.field864 -= var9;
                        if(var0.field864 < var4) {
                           var0.field864 = var4;
                        }
                     }

                     if(var12 < var5) {
                        var0.field831 += var9;
                        if(var0.field831 > var5) {
                           var0.field831 = var5;
                        }
                     } else if(var12 > var5) {
                        var0.field831 -= var9;
                        if(var0.field831 < var5) {
                           var0.field831 = var5;
                        }
                     }
                  }

                  if(var0.field864 == var4 && var5 == var0.field831) {
                     --var0.field875;
                     if(var0.field851 > 0) {
                        --var0.field851;
                     }
                  }
               } else {
                  var0.field864 = var4;
                  var0.field831 = var5;
                  --var0.field875;
                  if(var0.field851 > 0) {
                     --var0.field851;
                  }
               }
            }
         }
      }

      if(var0.field864 < 128 || var0.field831 < 128 || var0.field864 >= 13184 || var0.field831 >= 13184) {
         var0.field884 = -1;
         var0.field834 = -1;
         var0.field852 = 0;
         var0.field877 = 0;
         var0.field864 = var0.field858 * 64 + var0.field885[0] * 128;
         var0.field831 = var0.field886[0] * 128 + var0.field858 * 64;
         var0.method770();
      }

      if(var0 == class114.field2010 && (var0.field864 < 1536 || var0.field831 < 1536 || var0.field864 >= 11776 || var0.field831 >= 11776)) {
         var0.field884 = -1;
         var0.field834 = -1;
         var0.field852 = 0;
         var0.field877 = 0;
         var0.field864 = var0.field858 * 64 + var0.field885[0] * 128;
         var0.field831 = 128 * var0.field886[0] + var0.field858 * 64;
         var0.method770();
      }

      class8.method109(var0);
      var0.field891 = false;
      if(var0.field859 != -1) {
         var2 = class28.method646(var0.field859);
         if(null != var2 && null != var2.field1009) {
            ++var0.field861;
            if(var0.field860 < var2.field1009.length && var0.field861 > var2.field1011[var0.field860]) {
               var0.field861 = 1;
               ++var0.field860;
               class16.method180(var2, var0.field860, var0.field864, var0.field831);
            }

            if(var0.field860 >= var2.field1009.length) {
               var0.field861 = 0;
               var0.field860 = 0;
               class16.method180(var2, var0.field860, var0.field864, var0.field831);
            }
         } else {
            var0.field859 = -1;
         }
      }

      if(var0.field834 != -1 && client.field282 >= var0.field870) {
         if(var0.field868 < 0) {
            var0.field868 = 0;
         }

         var11 = class175.method3442(var0.field834).field1028;
         if(var11 != -1) {
            class44 var3 = class28.method646(var11);
            if(null != var3 && null != var3.field1009) {
               ++var0.field869;
               if(var0.field868 < var3.field1009.length && var0.field869 > var3.field1011[var0.field868]) {
                  var0.field869 = 1;
                  ++var0.field868;
                  class16.method180(var3, var0.field868, var0.field864, var0.field831);
               }

               if(var0.field868 >= var3.field1009.length && (var0.field868 < 0 || var0.field868 >= var3.field1009.length)) {
                  var0.field834 = -1;
               }
            } else {
               var0.field834 = -1;
            }
         } else {
            var0.field834 = -1;
         }
      }

      if(var0.field884 != -1 && var0.field865 <= 1) {
         var2 = class28.method646(var0.field884);
         if(var2.field1019 == 1 && var0.field851 > 0 && var0.field852 <= client.field282 && var0.field877 < client.field282) {
            var0.field865 = 1;
            return;
         }
      }

      if(var0.field884 != -1 && var0.field865 == 0) {
         var2 = class28.method646(var0.field884);
         if(null != var2 && null != var2.field1009) {
            ++var0.field862;
            if(var0.field863 < var2.field1009.length && var0.field862 > var2.field1011[var0.field863]) {
               var0.field862 = 1;
               ++var0.field863;
               class16.method180(var2, var0.field863, var0.field864, var0.field831);
            }

            if(var0.field863 >= var2.field1009.length) {
               var0.field863 -= var2.field1013;
               ++var0.field866;
               if(var0.field866 >= var2.field1007) {
                  var0.field884 = -1;
               } else if(var0.field863 >= 0 && var0.field863 < var2.field1009.length) {
                  class16.method180(var2, var0.field863, var0.field864, var0.field831);
               } else {
                  var0.field884 = -1;
               }
            }

            var0.field891 = var2.field1015;
         } else {
            var0.field884 = -1;
         }
      }

      if(var0.field865 > 0) {
         --var0.field865;
      }

   }
}
