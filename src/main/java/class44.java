import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class44 extends class203 {
   @ObfuscatedName("m")
   short[] field1025;
   @ObfuscatedName("r")
   static class166 field1026;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -865916409
   )
   public static int field1027;
   @ObfuscatedName("s")
   public static class192 field1028 = new class192(64);
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1930096553
   )
   public int field1029 = -1;
   @ObfuscatedName("e")
   int[] field1030;
   @ObfuscatedName("a")
   static class166 field1031;
   @ObfuscatedName("l")
   int[] field1032 = new int[]{-1, -1, -1, -1, -1};
   @ObfuscatedName("g")
   short[] field1033;
   @ObfuscatedName("n")
   short[] field1034;
   @ObfuscatedName("j")
   short[] field1035;
   @ObfuscatedName("h")
   public boolean field1036 = false;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = -1707774671
   )
   @Export("cameraX")
   static int field1037;

   @ObfuscatedName("f")
   static final boolean method928(int var0, int var1, int var2, class106 var3, class107 var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class105.field1854[var7][var8] = 99;
      class105.field1856[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class105.field1852[var11] = var0;
      int var20 = var11 + 1;
      class105.field1860[var11] = var1;
      int[][] var13 = var4.field1888;

      while(true) {
         label348:
         while(true) {
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            do {
               do {
                  do {
                     label325:
                     do {
                        if(var20 == var12) {
                           class105.field1857 = var5;
                           class105.field1855 = var6;
                           return false;
                        }

                        var5 = class105.field1852[var12];
                        var6 = class105.field1860[var12];
                        var12 = 1 + var12 & 4095;
                        var18 = var5 - var9;
                        var19 = var6 - var10;
                        var14 = var5 - var4.field1884;
                        var15 = var6 - var4.field1885;
                        if(var3.vmethod2388(var5, var6)) {
                           class105.field1857 = var5;
                           class105.field1855 = var6;
                           return true;
                        }

                        var16 = 1 + class105.field1856[var18][var19];
                        if(var18 > 0 && 0 == class105.field1854[var18 - 1][var19] && (var13[var14 - 1][var15] & 19136782) == 0 && (var13[var14 - 1][var15 + var2 - 1] & 19136824) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class105.field1852[var20] = var5 - 1;
                                 class105.field1860[var20] = var6;
                                 var20 = 1 + var20 & 4095;
                                 class105.field1854[var18 - 1][var19] = 2;
                                 class105.field1856[var18 - 1][var19] = var16;
                                 break;
                              }

                              if(0 != (var13[var14 - 1][var15 + var17] & 19136830)) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && 0 == class105.field1854[var18 + 1][var19] && (var13[var14 + var2][var15] & 19136899) == 0 && 0 == (var13[var2 + var14][var15 + var2 - 1] & 19136992)) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class105.field1852[var20] = var5 + 1;
                                 class105.field1860[var20] = var6;
                                 var20 = 1 + var20 & 4095;
                                 class105.field1854[var18 + 1][var19] = 8;
                                 class105.field1856[1 + var18][var19] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var15 + var17] & 19136995) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 > 0 && class105.field1854[var18][var19 - 1] == 0 && 0 == (var13[var14][var15 - 1] & 19136782) && 0 == (var13[var14 + var2 - 1][var15 - 1] & 19136899)) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class105.field1852[var20] = var5;
                                 class105.field1860[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class105.field1854[var18][var19 - 1] = 1;
                                 class105.field1856[var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 < 128 - var2 && class105.field1854[var18][var19 + 1] == 0 && 0 == (var13[var14][var15 + var2] & 19136824) && (var13[var14 + var2 - 1][var2 + var15] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class105.field1852[var20] = var5;
                                 class105.field1860[var20] = 1 + var6;
                                 var20 = var20 + 1 & 4095;
                                 class105.field1854[var18][var19 + 1] = 4;
                                 class105.field1856[var18][1 + var19] = var16;
                                 break;
                              }

                              if(0 != (var13[var14 + var17][var2 + var15] & 19137016)) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 > 0 && class105.field1854[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class105.field1852[var20] = var5 - 1;
                                 class105.field1860[var20] = var6 - 1;
                                 var20 = 1 + var20 & 4095;
                                 class105.field1854[var18 - 1][var19 - 1] = 3;
                                 class105.field1856[var18 - 1][var19 - 1] = var16;
                                 break;
                              }

                              if(0 != (var13[var14 - 1][var15 - 1 + var17] & 19136830) || (var13[var14 - 1 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && var19 > 0 && class105.field1854[var18 + 1][var19 - 1] == 0 && (var13[var2 + var14][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class105.field1852[var20] = 1 + var5;
                                 class105.field1860[var20] = var6 - 1;
                                 var20 = 1 + var20 & 4095;
                                 class105.field1854[1 + var18][var19 - 1] = 9;
                                 class105.field1856[var18 + 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var2 + var14][var15 - 1 + var17] & 19136995) != 0 || 0 != (var13[var17 + var14][var15 - 1] & 19136911)) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 < 128 - var2 && 0 == class105.field1854[var18 - 1][var19 + 1] && 0 == (var13[var14 - 1][var2 + var15] & 19136824)) {
                           for(var17 = 1; var17 < var2; ++var17) {
                              if(0 != (var13[var14 - 1][var15 + var17] & 19136830) || (var13[var17 + (var14 - 1)][var2 + var15] & 19137016) != 0) {
                                 continue label325;
                              }
                           }

                           class105.field1852[var20] = var5 - 1;
                           class105.field1860[var20] = 1 + var6;
                           var20 = var20 + 1 & 4095;
                           class105.field1854[var18 - 1][var19 + 1] = 6;
                           class105.field1856[var18 - 1][1 + var19] = var16;
                        }
                     } while(var18 >= 128 - var2);
                  } while(var19 >= 128 - var2);
               } while(0 != class105.field1854[var18 + 1][var19 + 1]);
            } while((var13[var2 + var14][var2 + var15] & 19136992) != 0);

            for(var17 = 1; var17 < var2; ++var17) {
               if((var13[var14 + var17][var15 + var2] & 19137016) != 0 || 0 != (var13[var2 + var14][var17 + var15] & 19136995)) {
                  continue label348;
               }
            }

            class105.field1852[var20] = var5 + 1;
            class105.field1860[var20] = var6 + 1;
            var20 = 1 + var20 & 4095;
            class105.field1854[1 + var18][var19 + 1] = 12;
            class105.field1856[1 + var18][var19 + 1] = var16;
         }
      }
   }

   @ObfuscatedName("f")
   void method929(class118 var1) {
      while(true) {
         int var2 = var1.method2579();
         if(var2 == 0) {
            return;
         }

         this.method935(var1, var2);
      }
   }

   @ObfuscatedName("y")
   public boolean method930() {
      if(this.field1030 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field1030.length; ++var2) {
            if(!field1026.method3265(this.field1030[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("g")
   public boolean method932() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(-1 != this.field1032[var2] && !field1026.method3265(this.field1032[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass118;IB)V",
      garbageValue = "-38"
   )
   void method935(class118 var1, int var2) {
      if(1 == var2) {
         this.field1029 = var1.method2579();
      } else {
         int var3;
         int var4;
         if(2 == var2) {
            var3 = var1.method2579();
            this.field1030 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1030[var4] = var1.method2514();
            }
         } else if(var2 == 3) {
            this.field1036 = true;
         } else if(var2 == 40) {
            var3 = var1.method2579();
            this.field1033 = new short[var3];
            this.field1025 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1033[var4] = (short)var1.method2514();
               this.field1025[var4] = (short)var1.method2514();
            }
         } else if(41 == var2) {
            var3 = var1.method2579();
            this.field1035 = new short[var3];
            this.field1034 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1035[var4] = (short)var1.method2514();
               this.field1034[var4] = (short)var1.method2514();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.field1032[var2 - 60] = var1.method2514();
         }
      }

   }

   @ObfuscatedName("e")
   public class99 method941() {
      if(null == this.field1030) {
         return null;
      } else {
         class99[] var1 = new class99[this.field1030.length];

         for(int var2 = 0; var2 < this.field1030.length; ++var2) {
            var1[var2] = class99.method2219(field1026, this.field1030[var2], 0);
         }

         class99 var4;
         if(1 == var1.length) {
            var4 = var1[0];
         } else {
            var4 = new class99(var1, var1.length);
         }

         int var3;
         if(this.field1033 != null) {
            for(var3 = 0; var3 < this.field1033.length; ++var3) {
               var4.method2254(this.field1033[var3], this.field1025[var3]);
            }
         }

         if(null != this.field1035) {
            for(var3 = 0; var3 < this.field1035.length; ++var3) {
               var4.method2274(this.field1035[var3], this.field1034[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("m")
   public class99 method955() {
      class99[] var1 = new class99[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(this.field1032[var3] != -1) {
            var1[var2++] = class99.method2219(field1026, this.field1032[var3], 0);
         }
      }

      class99 var5 = new class99(var1, var2);
      int var4;
      if(this.field1033 != null) {
         for(var4 = 0; var4 < this.field1033.length; ++var4) {
            var5.method2254(this.field1033[var4], this.field1025[var4]);
         }
      }

      if(this.field1035 != null) {
         for(var4 = 0; var4 < this.field1035.length; ++var4) {
            var5.method2274(this.field1035[var4], this.field1034[var4]);
         }
      }

      return var5;
   }
}
