import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
@Implements("ItemLayer")
public final class class99 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1035052949
   )
   @Export("height")
   int field1674;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 12272799
   )
   @Export("x")
   int field1675;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2049468995
   )
   @Export("y")
   int field1676;
   @ObfuscatedName("c")
   @Export("bottom")
   class85 field1677;
   @ObfuscatedName("y")
   @Export("middle")
   class85 field1678;
   @ObfuscatedName("qh")
   @ObfuscatedGetter(
      intValue = -1593667041
   )
   static int field1680;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -441331567
   )
   @Export("flags")
   int field1681;
   @ObfuscatedName("av")
   static class168 field1682;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2017172171
   )
   @Export("hash")
   int field1683;
   @ObfuscatedName("eu")
   static class80[] field1684;
   @ObfuscatedName("k")
   @Export("top")
   class85 field1686;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)[Lclass130;",
      garbageValue = "-1512747091"
   )
   public static class130[] method2285() {
      return new class130[]{class130.field2060, class130.field2058, class130.field2064};
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1387117388"
   )
   public static boolean method2286() {
      long var0 = class127.method2941();
      int var2 = (int)(var0 - class171.field2730);
      class171.field2730 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class171.field2715 += var2;
      if(0 == class171.field2724 && 0 == class171.field2719 && 0 == class171.field2739 && 0 == class171.field2727) {
         return true;
      } else if(class171.field2717 == null) {
         return false;
      } else {
         try {
            if(class171.field2715 > 30000) {
               throw new IOException();
            } else {
               class172 var3;
               class119 var4;
               while(class171.field2719 < 20 && class171.field2727 > 0) {
                  var3 = (class172)class171.field2738.method3871();
                  var4 = new class119(4);
                  var4.method2603(1);
                  var4.method2675((int)var3.field3125);
                  class171.field2717.method3100(var4.field1993, 0, 4);
                  class171.field2718.method3875(var3, var3.field3125);
                  --class171.field2727;
                  ++class171.field2719;
               }

               while(class171.field2724 < 20 && class171.field2739 > 0) {
                  var3 = (class172)class171.field2720.method3966();
                  var4 = new class119(4);
                  var4.method2603(0);
                  var4.method2675((int)var3.field3125);
                  class171.field2717.method3100(var4.field1993, 0, 4);
                  var3.method3979();
                  class171.field2713.method3875(var3, var3.field3125);
                  --class171.field2739;
                  ++class171.field2724;
               }

               for(int var18 = 0; var18 < 100; ++var18) {
                  int var19 = class171.field2717.method3098();
                  if(var19 < 0) {
                     throw new IOException();
                  }

                  if(var19 == 0) {
                     break;
                  }

                  class171.field2715 = 0;
                  byte var5 = 0;
                  if(class124.field2032 == null) {
                     var5 = 8;
                  } else if(0 == class171.field2728) {
                     var5 = 1;
                  }

                  int var6;
                  int var7;
                  int var8;
                  int var10;
                  if(var5 > 0) {
                     var6 = var5 - class171.field2726.field1992;
                     if(var6 > var19) {
                        var6 = var19;
                     }

                     class171.field2717.method3099(class171.field2726.field1993, class171.field2726.field1992, var6);
                     if(0 != class171.field2731) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class171.field2726.field1993[var7 + class171.field2726.field1992] ^= class171.field2731;
                        }
                     }

                     class171.field2726.field1992 += var6;
                     if(class171.field2726.field1992 < var5) {
                        break;
                     }

                     if(class124.field2032 == null) {
                        class171.field2726.field1992 = 0;
                        var7 = class171.field2726.method2613();
                        var8 = class171.field2726.method2615();
                        int var9 = class171.field2726.method2613();
                        var10 = class171.field2726.method2618();
                        long var11 = (long)((var7 << 16) + var8);
                        class172 var13 = (class172)class171.field2718.method3868(var11);
                        class171.field2725 = true;
                        if(var13 == null) {
                           var13 = (class172)class171.field2713.method3868(var11);
                           class171.field2725 = false;
                        }

                        if(null == var13) {
                           throw new IOException();
                        }

                        int var14 = var9 == 0?5:9;
                        class124.field2032 = var13;
                        class171.field2716 = new class119(var14 + var10 + class124.field2032.field2740);
                        class171.field2716.method2603(var9);
                        class171.field2716.method2786(var10);
                        class171.field2728 = 8;
                        class171.field2726.field1992 = 0;
                     } else if(class171.field2728 == 0) {
                        if(class171.field2726.field1993[0] == -1) {
                           class171.field2728 = 1;
                           class171.field2726.field1992 = 0;
                        } else {
                           class124.field2032 = null;
                        }
                     }
                  } else {
                     var6 = class171.field2716.field1993.length - class124.field2032.field2740;
                     var7 = 512 - class171.field2728;
                     if(var7 > var6 - class171.field2716.field1992) {
                        var7 = var6 - class171.field2716.field1992;
                     }

                     if(var7 > var19) {
                        var7 = var19;
                     }

                     class171.field2717.method3099(class171.field2716.field1993, class171.field2716.field1992, var7);
                     if(class171.field2731 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           class171.field2716.field1993[class171.field2716.field1992 + var8] ^= class171.field2731;
                        }
                     }

                     class171.field2716.field1992 += var7;
                     class171.field2728 += var7;
                     if(var6 == class171.field2716.field1992) {
                        if(class124.field2032.field3125 == 16711935L) {
                           class10.field171 = class171.field2716;

                           for(var8 = 0; var8 < 256; ++var8) {
                              class168 var20 = class171.field2722[var8];
                              if(var20 != null) {
                                 class10.field171.field1992 = 5 + 8 * var8;
                                 var10 = class10.field171.method2618();
                                 int var21 = class10.field171.method2618();
                                 var20.method3445(var10, var21);
                              }
                           }
                        } else {
                           class171.field2729.reset();
                           class171.field2729.update(class171.field2716.field1993, 0, var6);
                           var8 = (int)class171.field2729.getValue();
                           if(class124.field2032.field2741 != var8) {
                              try {
                                 class171.field2717.method3095();
                              } catch (Exception var16) {
                                 ;
                              }

                              ++class171.field2734;
                              class171.field2717 = null;
                              class171.field2731 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class171.field2734 = 0;
                           class171.field2733 = 0;
                           class124.field2032.field2745.method3443((int)(class124.field2032.field3125 & 65535L), class171.field2716.field1993, (class124.field2032.field3125 & 16711680L) == 16711680L, class171.field2725);
                        }

                        class124.field2032.method3998();
                        if(class171.field2725) {
                           --class171.field2719;
                        } else {
                           --class171.field2724;
                        }

                        class171.field2728 = 0;
                        class124.field2032 = null;
                        class171.field2716 = null;
                     } else {
                        if(class171.field2728 != 512) {
                           break;
                        }

                        class171.field2728 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var17) {
            try {
               class171.field2717.method3095();
            } catch (Exception var15) {
               ;
            }

            ++class171.field2733;
            class171.field2717 = null;
            return false;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "65535"
   )
   public static int method2287(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "119"
   )
   static final void method2288() {
      for(class6 var0 = (class6)client.field449.method3926(); var0 != null; var0 = (class6)client.field449.method3902()) {
         if(var0.field129 == class42.field1002 && client.field306 <= var0.field132) {
            if(client.field306 >= var0.field109) {
               if(var0.field103 > 0) {
                  class34 var1 = client.field546[var0.field103 - 1];
                  if(var1 != null && var1.field844 >= 0 && var1.field844 < 13312 && var1.field819 >= 0 && var1.field819 < 13312) {
                     var0.method134(var1.field844, var1.field819, class34.method816(var1.field844, var1.field819, var0.field129) - var0.field117, client.field306);
                  }
               }

               if(var0.field103 < 0) {
                  int var2 = -var0.field103 - 1;
                  class2 var3;
                  if(var2 == client.field457) {
                     var3 = class5.field93;
                  } else {
                     var3 = client.field550[var2];
                  }

                  if(var3 != null && var3.field844 >= 0 && var3.field844 < 13312 && var3.field819 >= 0 && var3.field819 < 13312) {
                     var0.method134(var3.field844, var3.field819, class34.method816(var3.field844, var3.field819, var0.field129) - var0.field117, client.field306);
                  }
               }

               var0.method129(client.field427);
               class30.field717.method2019(class42.field1002, (int)var0.field104, (int)var0.field116, (int)var0.field115, 60, var0, var0.field123, -1, false);
            }
         } else {
            var0.method3998();
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "4"
   )
   static final int method2289(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class77.method1784(var3, var5);
      int var8 = class77.method1784(1 + var3, var5);
      int var9 = class77.method1784(var3, var5 + 1);
      int var10 = class77.method1784(1 + var3, var5 + 1);
      int var12 = 65536 - class91.field1594[var4 * 1024 / var2] >> 1;
      int var11 = (var8 * var12 >> 16) + (var7 * (65536 - var12) >> 16);
      int var14 = 65536 - class91.field1594[1024 * var4 / var2] >> 1;
      int var13 = (var10 * var14 >> 16) + (var9 * (65536 - var14) >> 16);
      int var16 = 65536 - class91.field1594[1024 * var6 / var2] >> 1;
      int var15 = (var13 * var16 >> 16) + ((65536 - var16) * var11 >> 16);
      return var15;
   }
}
