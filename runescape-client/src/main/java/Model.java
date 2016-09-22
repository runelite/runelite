import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dp")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("bn")
   public static boolean field1882 = false;
   @ObfuscatedName("d")
   static byte[] field1883 = new byte[1];
   @ObfuscatedName("r")
   static byte[] field1884 = new byte[1];
   @ObfuscatedName("at")
   static int[] field1885 = new int[4700];
   @ObfuscatedName("au")
   static int[] field1886 = new int[2000];
   @ObfuscatedName("j")
   int[] field1887;
   @ObfuscatedName("n")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("i")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("g")
   int field1890 = 0;
   @ObfuscatedName("t")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("k")
   @Export("indices2")
   int[] indices2;
   @ObfuscatedName("x")
   @Export("indices3")
   int[] indices3;
   @ObfuscatedName("p")
   byte[] field1894;
   @ObfuscatedName("z")
   int field1895 = 0;
   @ObfuscatedName("q")
   int[] field1896;
   @ObfuscatedName("w")
   byte[] field1897;
   @ObfuscatedName("b")
   byte[] field1898;
   @ObfuscatedName("ax")
   static int[] field1899 = new int[4700];
   @ObfuscatedName("o")
   short[] field1900;
   @ObfuscatedName("y")
   byte field1901 = 0;
   @ObfuscatedName("s")
   int field1902 = 0;
   @ObfuscatedName("aw")
   static int[] field1903 = new int[4700];
   @ObfuscatedName("bg")
   static int field1904;
   @ObfuscatedName("u")
   int[] field1905;
   @ObfuscatedName("c")
   int[][] field1906;
   @ObfuscatedName("a")
   static Model field1907 = new Model();
   @ObfuscatedName("ac")
   public boolean field1908 = false;
   @ObfuscatedName("as")
   int field1909;
   @ObfuscatedName("bp")
   public static int[] field1910 = new int[1000];
   @ObfuscatedName("am")
   int field1911;
   @ObfuscatedName("ap")
   int field1912;
   @ObfuscatedName("aa")
   int field1913;
   @ObfuscatedName("av")
   static boolean[] field1915 = new boolean[4700];
   @ObfuscatedName("ao")
   static boolean[] field1916 = new boolean[4700];
   @ObfuscatedName("aq")
   static int[] field1917 = new int[4700];
   @ObfuscatedName("m")
   @Export("indices1")
   int[] indices1;
   @ObfuscatedName("f")
   int[][] field1919;
   @ObfuscatedName("ah")
   static int[] field1920 = new int[1600];
   @ObfuscatedName("ab")
   static int[] field1921 = new int[4700];
   @ObfuscatedName("af")
   int field1922;
   @ObfuscatedName("h")
   int[] field1923;
   @ObfuscatedName("l")
   int[] field1924;
   @ObfuscatedName("ak")
   static int[][] field1925 = new int[1600][512];
   @ObfuscatedName("ai")
   static int[] field1926 = new int[12];
   @ObfuscatedName("az")
   static int[][] field1927 = new int[12][2000];
   @ObfuscatedName("an")
   static int[] field1928 = new int[10];
   @ObfuscatedName("ay")
   static int[] field1929 = new int[2000];
   @ObfuscatedName("ag")
   static int[] field1930 = new int[12];
   @ObfuscatedName("ae")
   static int[] field1931 = new int[10];
   @ObfuscatedName("bf")
   static int field1932;
   @ObfuscatedName("e")
   int[] field1934;
   @ObfuscatedName("aj")
   static int[] field1935 = new int[10];
   @ObfuscatedName("bl")
   static int field1936;
   @ObfuscatedName("al")
   static int[] field1937 = new int[4700];
   @ObfuscatedName("bs")
   public static int field1938 = 0;
   @ObfuscatedName("bc")
   public static int field1939 = 0;
   @ObfuscatedName("bq")
   public static int field1940 = 0;
   @ObfuscatedName("v")
   static Model field1941 = new Model();
   @ObfuscatedName("bo")
   static int[] field1942;
   @ObfuscatedName("bd")
   static int[] field1943;
   @ObfuscatedName("bj")
   static int[] field1944;
   @ObfuscatedName("bh")
   static int[] field1945;

   @ObfuscatedName("y")
   public final void method2319(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1920[0] = -1;
      if(this.field1909 != 2 && this.field1909 != 1) {
         this.method2326();
      }

      int var8 = class94.field1668;
      int var9 = class94.field1674;
      int var10000 = field1942[var1];
      var10000 = field1943[var1];
      int var12 = field1942[var2];
      int var13 = field1943[var2];
      int var14 = field1942[var3];
      int var15 = field1943[var3];
      int var16 = field1942[var4];
      int var17 = field1943[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1895; ++var19) {
         int var20 = this.verticesX[var19];
         int var21 = this.verticesY[var19];
         int var22 = this.verticesZ[var19];
         int var23;
         if(var3 != 0) {
            var23 = var21 * var14 + var20 * var15 >> 16;
            var21 = var21 * var15 - var20 * var14 >> 16;
            var20 = var23;
         }

         if(var2 != 0) {
            var23 = var22 * var12 + var20 * var13 >> 16;
            var22 = var22 * var13 - var20 * var12 >> 16;
            var20 = var23;
         }

         var20 += var5;
         var21 += var6;
         var22 += var7;
         var23 = var21 * var17 - var22 * var16 >> 16;
         var22 = var21 * var16 + var22 * var17 >> 16;
         field1885[var19] = var22 - var18;
         field1917[var19] = var8 + var20 * class94.field1661 / var22;
         field1899[var19] = var9 + var23 * class94.field1661 / var22;
         if(this.field1902 > 0) {
            field1903[var19] = var20;
            field1921[var19] = var23;
            field1937[var19] = var22;
         }
      }

      try {
         this.method2366(false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("a")
   public Model method2321(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2347();
      int var7 = var2 - this.field1911;
      int var8 = var2 + this.field1911;
      int var9 = var4 - this.field1911;
      int var10 = var4 + this.field1911;
      if(var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
         var7 >>= 7;
         var8 = var8 + 127 >> 7;
         var9 >>= 7;
         var10 = var10 + 127 >> 7;
         if(var1[var7][var9] == var3 && var1[var8][var9] == var3 && var1[var7][var10] == var3 && var1[var8][var10] == var3) {
            return this;
         } else {
            Model var11;
            if(var5) {
               var11 = new Model();
               var11.field1895 = this.field1895;
               var11.field1890 = this.field1890;
               var11.field1902 = this.field1902;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1905 = this.field1905;
               var11.field1887 = this.field1887;
               var11.field1896 = this.field1896;
               var11.field1897 = this.field1897;
               var11.field1898 = this.field1898;
               var11.field1894 = this.field1894;
               var11.field1900 = this.field1900;
               var11.field1901 = this.field1901;
               var11.field1934 = this.field1934;
               var11.field1923 = this.field1923;
               var11.field1924 = this.field1924;
               var11.field1906 = this.field1906;
               var11.field1919 = this.field1919;
               var11.field1908 = this.field1908;
               var11.verticesY = new int[var11.field1895];
            } else {
               var11 = this;
            }

            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            int var20;
            int var21;
            if(var6 == 0) {
               for(var12 = 0; var12 < var11.field1895; ++var12) {
                  var13 = this.verticesX[var12] + var2;
                  var14 = this.verticesZ[var12] + var4;
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var1[var17 + 1][var18 + 1] * var15 >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.verticesY[var12] = this.verticesY[var12] + var21 - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1895; ++var12) {
                  var13 = (-this.verticesY[var12] << 16) / super.modelHeight;
                  if(var13 < var6) {
                     var14 = this.verticesX[var12] + var2;
                     var15 = this.verticesZ[var12] + var4;
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var1[var18 + 1][var19 + 1] * var16 >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.verticesY[var12] = this.verticesY[var12] + (var22 - var3) * (var6 - var13) / var6;
                  }
               }
            }

            var11.field1909 = 0;
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("z")
   Model method2324(boolean var1, Model var2, byte[] var3) {
      var2.field1895 = this.field1895;
      var2.field1890 = this.field1890;
      var2.field1902 = this.field1902;
      if(var2.verticesX == null || var2.verticesX.length < this.field1895) {
         var2.verticesX = new int[this.field1895 + 100];
         var2.verticesY = new int[this.field1895 + 100];
         var2.verticesZ = new int[this.field1895 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1895; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if(var1) {
         var2.field1898 = this.field1898;
      } else {
         var2.field1898 = var3;
         if(this.field1898 == null) {
            for(var4 = 0; var4 < this.field1890; ++var4) {
               var2.field1898[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1890; ++var4) {
               var2.field1898[var4] = this.field1898[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1905 = this.field1905;
      var2.field1887 = this.field1887;
      var2.field1896 = this.field1896;
      var2.field1897 = this.field1897;
      var2.field1894 = this.field1894;
      var2.field1900 = this.field1900;
      var2.field1901 = this.field1901;
      var2.field1934 = this.field1934;
      var2.field1923 = this.field1923;
      var2.field1924 = this.field1924;
      var2.field1906 = this.field1906;
      var2.field1919 = this.field1919;
      var2.field1908 = this.field1908;
      var2.field1909 = 0;
      return var2;
   }

   @ObfuscatedName("g")
   public void method2325(Frames var1, int var2) {
      if(this.field1906 != null) {
         if(var2 != -1) {
            Frame var3 = var1.field1858[var2];
            FrameMap var4 = var3.field1627;
            field1904 = 0;
            field1932 = 0;
            field1936 = 0;

            for(int var5 = 0; var5 < var3.field1628; ++var5) {
               int var6 = var3.field1629[var5];
               this.method2356(var4.field1847[var6], var4.field1846[var6], var3.field1623[var5], var3.field1624[var5], var3.field1630[var5]);
            }

            this.field1909 = 0;
         }
      }
   }

   @ObfuscatedName("n")
   void method2326() {
      if(this.field1909 != 2) {
         this.field1909 = 2;
         this.field1911 = 0;

         for(int var1 = 0; var1 < this.field1895; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1911) {
               this.field1911 = var5;
            }
         }

         this.field1911 = (int)(Math.sqrt((double)this.field1911) + 0.99D);
         this.field1913 = this.field1911;
         this.field1912 = this.field1911 + this.field1911;
      }
   }

   @ObfuscatedName("i")
   public int method2327() {
      this.method2347();
      return this.field1911;
   }

   Model() {
   }

   @ObfuscatedName("m")
   public void method2328(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.field1858[var2];
            Frame var7 = var3.field1858[var4];
            FrameMap var8 = var6.field1627;
            field1904 = 0;
            field1932 = 0;
            field1936 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1628; ++var11) {
               for(var12 = var6.field1629[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field1847[var12] == 0) {
                  this.method2356(var8.field1847[var12], var8.field1846[var12], var6.field1623[var11], var6.field1624[var11], var6.field1630[var11]);
               }
            }

            field1904 = 0;
            field1932 = 0;
            field1936 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1628; ++var11) {
               for(var12 = var7.field1629[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field1847[var12] == 0) {
                  this.method2356(var8.field1847[var12], var8.field1846[var12], var7.field1623[var11], var7.field1624[var11], var7.field1630[var11]);
               }
            }

            this.field1909 = 0;
         } else {
            this.method2325(var1, var2);
         }
      }
   }

   @ObfuscatedName("x")
   public void method2330() {
      for(int var1 = 0; var1 < this.field1895; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.field1909 = 0;
   }

   @ObfuscatedName("q")
   public void method2331() {
      for(int var1 = 0; var1 < this.field1895; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.field1909 = 0;
   }

   @ObfuscatedName("w")
   public void method2332() {
      for(int var1 = 0; var1 < this.field1895; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.field1909 = 0;
   }

   @ObfuscatedName("b")
   public void method2333(int var1) {
      int var2 = field1942[var1];
      int var3 = field1943[var1];

      for(int var4 = 0; var4 < this.field1895; ++var4) {
         int var5 = this.verticesY[var4] * var3 - this.verticesZ[var4] * var2 >> 16;
         this.verticesZ[var4] = this.verticesY[var4] * var2 + this.verticesZ[var4] * var3 >> 16;
         this.verticesY[var4] = var5;
      }

      this.field1909 = 0;
   }

   @ObfuscatedName("p")
   public void method2334(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1895; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.field1909 = 0;
   }

   @ObfuscatedName("o")
   public void method2335(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1895; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = this.verticesY[var4] * var2 / 128;
         this.verticesZ[var4] = this.verticesZ[var4] * var3 / 128;
      }

      this.field1909 = 0;
   }

   @ObfuscatedName("s")
   public final void method2337(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1920[0] = -1;
      if(this.field1909 != 2 && this.field1909 != 1) {
         this.method2326();
      }

      int var9 = class94.field1668;
      int var10 = class94.field1674;
      int var10000 = field1942[var1];
      var10000 = field1943[var1];
      int var13 = field1942[var2];
      int var14 = field1943[var2];
      int var15 = field1942[var3];
      int var16 = field1943[var3];
      int var17 = field1942[var4];
      int var18 = field1943[var4];
      int var19 = var6 * var17 + var7 * var18 >> 16;

      for(int var20 = 0; var20 < this.field1895; ++var20) {
         int var21 = this.verticesX[var20];
         int var22 = this.verticesY[var20];
         int var23 = this.verticesZ[var20];
         int var24;
         if(var3 != 0) {
            var24 = var22 * var15 + var21 * var16 >> 16;
            var22 = var22 * var16 - var21 * var15 >> 16;
            var21 = var24;
         }

         if(var2 != 0) {
            var24 = var23 * var13 + var21 * var14 >> 16;
            var23 = var23 * var14 - var21 * var13 >> 16;
            var21 = var24;
         }

         var21 += var5;
         var22 += var6;
         var23 += var7;
         var24 = var22 * var18 - var23 * var17 >> 16;
         var23 = var22 * var17 + var23 * var18 >> 16;
         field1885[var20] = var23 - var19;
         field1917[var20] = var9 + var21 * class94.field1661 / var8;
         field1899[var20] = var10 + var24 * class94.field1661 / var8;
         if(this.field1902 > 0) {
            field1903[var20] = var21;
            field1921[var20] = var24;
            field1937[var20] = var23;
         }
      }

      try {
         this.method2366(false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("at")
   void vmethod2338(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1920[0] = -1;
      if(this.field1909 != 1) {
         this.method2347();
      }

      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1911 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1911) * class94.field1661;
         if(var15 / var13 < class94.field1652) {
            int var16 = (var14 + this.field1911) * class94.field1661;
            if(var16 / var13 > class94.field1659) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1911 * var2 >> 16;
               int var19 = (var17 + var18) * class94.field1661;
               if(var19 / var13 > class94.field1667) {
                  int var20 = var18 + (super.modelHeight * var3 >> 16);
                  int var21 = (var17 - var20) * class94.field1661;
                  if(var21 / var13 < class94.field1669) {
                     int var22 = var12 + (super.modelHeight * var2 >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1902 > 0;
                     boolean var26 = false;
                     int var27;
                     int var28;
                     int var29;
                     if(var9 > 0 && field1882) {
                        var27 = var11 - var12;
                        if(var27 <= 50) {
                           var27 = 50;
                        }

                        if(var14 > 0) {
                           var15 /= var13;
                           var16 /= var27;
                        } else {
                           var16 /= var13;
                           var15 /= var27;
                        }

                        if(var17 > 0) {
                           var21 /= var13;
                           var19 /= var27;
                        } else {
                           var19 /= var13;
                           var21 /= var27;
                        }

                        var28 = field1938 - class94.field1668;
                        var29 = field1939 - class94.field1674;
                        if(var28 > var15 && var28 < var16 && var29 > var21 && var29 < var19) {
                           if(this.field1908) {
                              field1910[field1940++] = var9;
                           } else {
                              var26 = true;
                           }
                        }
                     }

                     var27 = class94.field1668;
                     var28 = class94.field1674;
                     var29 = 0;
                     int var30 = 0;
                     if(var1 != 0) {
                        var29 = field1942[var1];
                        var30 = field1943[var1];
                     }

                     for(int var31 = 0; var31 < this.field1895; ++var31) {
                        int var32 = this.verticesX[var31];
                        int var33 = this.verticesY[var31];
                        int var34 = this.verticesZ[var31];
                        int var35;
                        if(var1 != 0) {
                           var35 = var34 * var29 + var32 * var30 >> 16;
                           var34 = var34 * var30 - var32 * var29 >> 16;
                           var32 = var35;
                        }

                        var32 += var6;
                        var33 += var7;
                        var34 += var8;
                        var35 = var34 * var4 + var32 * var5 >> 16;
                        var34 = var34 * var5 - var32 * var4 >> 16;
                        var32 = var35;
                        var35 = var33 * var3 - var34 * var2 >> 16;
                        var34 = var33 * var2 + var34 * var3 >> 16;
                        field1885[var31] = var34 - var11;
                        if(var34 >= 50) {
                           field1917[var31] = var27 + var32 * class94.field1661 / var34;
                           field1899[var31] = var28 + var35 * class94.field1661 / var34;
                        } else {
                           field1917[var31] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1903[var31] = var32;
                           field1921[var31] = var35;
                           field1937[var31] = var34;
                        }
                     }

                     try {
                        this.method2366(var23, var26, var9);
                     } catch (Exception var37) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("h")
   final void method2340(int var1) {
      if(field1916[var1]) {
         this.method2341(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         class94.rasterClipEnable = field1915[var1];
         if(this.field1898 == null) {
            class94.rasterAlpha = 0;
         } else {
            class94.rasterAlpha = this.field1898[var1] & 255;
         }

         if(this.field1900 != null && this.field1900[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1894 != null && this.field1894[var1] != -1) {
               int var8 = this.field1894[var1] & 255;
               var5 = this.field1934[var8];
               var6 = this.field1923[var8];
               var7 = this.field1924[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1896[var1] == -1) {
               class94.rasterTextureAffine(field1899[var2], field1899[var3], field1899[var4], field1917[var2], field1917[var3], field1917[var4], this.field1905[var1], this.field1905[var1], this.field1905[var1], field1903[var5], field1903[var6], field1903[var7], field1921[var5], field1921[var6], field1921[var7], field1937[var5], field1937[var6], field1937[var7], this.field1900[var1]);
            } else {
               class94.rasterTextureAffine(field1899[var2], field1899[var3], field1899[var4], field1917[var2], field1917[var3], field1917[var4], this.field1905[var1], this.field1887[var1], this.field1896[var1], field1903[var5], field1903[var6], field1903[var7], field1921[var5], field1921[var6], field1921[var7], field1937[var5], field1937[var6], field1937[var7], this.field1900[var1]);
            }
         } else if(this.field1896[var1] == -1) {
            class94.rasterFlat(field1899[var2], field1899[var3], field1899[var4], field1917[var2], field1917[var3], field1917[var4], field1944[this.field1905[var1]]);
         } else {
            class94.rasterGouraud(field1899[var2], field1899[var3], field1899[var4], field1917[var2], field1917[var3], field1917[var4], this.field1905[var1], this.field1887[var1], this.field1896[var1]);
         }

      }
   }

   @ObfuscatedName("l")
   final void method2341(int var1) {
      int var2 = class94.field1668;
      int var3 = class94.field1674;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1937[var5];
      int var9 = field1937[var6];
      int var10 = field1937[var7];
      if(this.field1898 == null) {
         class94.rasterAlpha = 0;
      } else {
         class94.rasterAlpha = this.field1898[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1931[var4] = field1917[var5];
         field1928[var4] = field1899[var5];
         field1935[var4++] = this.field1905[var1];
      } else {
         var11 = field1903[var5];
         var12 = field1921[var5];
         var13 = this.field1905[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1945[var10 - var8];
            field1931[var4] = var2 + (var11 + ((field1903[var7] - var11) * var14 >> 16)) * class94.field1661 / 50;
            field1928[var4] = var3 + (var12 + ((field1921[var7] - var12) * var14 >> 16)) * class94.field1661 / 50;
            field1935[var4++] = var13 + ((this.field1896[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1945[var9 - var8];
            field1931[var4] = var2 + (var11 + ((field1903[var6] - var11) * var14 >> 16)) * class94.field1661 / 50;
            field1928[var4] = var3 + (var12 + ((field1921[var6] - var12) * var14 >> 16)) * class94.field1661 / 50;
            field1935[var4++] = var13 + ((this.field1887[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1931[var4] = field1917[var6];
         field1928[var4] = field1899[var6];
         field1935[var4++] = this.field1887[var1];
      } else {
         var11 = field1903[var6];
         var12 = field1921[var6];
         var13 = this.field1887[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1945[var8 - var9];
            field1931[var4] = var2 + (var11 + ((field1903[var5] - var11) * var14 >> 16)) * class94.field1661 / 50;
            field1928[var4] = var3 + (var12 + ((field1921[var5] - var12) * var14 >> 16)) * class94.field1661 / 50;
            field1935[var4++] = var13 + ((this.field1905[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1945[var10 - var9];
            field1931[var4] = var2 + (var11 + ((field1903[var7] - var11) * var14 >> 16)) * class94.field1661 / 50;
            field1928[var4] = var3 + (var12 + ((field1921[var7] - var12) * var14 >> 16)) * class94.field1661 / 50;
            field1935[var4++] = var13 + ((this.field1896[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1931[var4] = field1917[var7];
         field1928[var4] = field1899[var7];
         field1935[var4++] = this.field1896[var1];
      } else {
         var11 = field1903[var7];
         var12 = field1921[var7];
         var13 = this.field1896[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1945[var9 - var10];
            field1931[var4] = var2 + (var11 + ((field1903[var6] - var11) * var14 >> 16)) * class94.field1661 / 50;
            field1928[var4] = var3 + (var12 + ((field1921[var6] - var12) * var14 >> 16)) * class94.field1661 / 50;
            field1935[var4++] = var13 + ((this.field1887[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1945[var8 - var10];
            field1931[var4] = var2 + (var11 + ((field1903[var5] - var11) * var14 >> 16)) * class94.field1661 / 50;
            field1928[var4] = var3 + (var12 + ((field1921[var5] - var12) * var14 >> 16)) * class94.field1661 / 50;
            field1935[var4++] = var13 + ((this.field1905[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1931[0];
      var12 = field1931[1];
      var13 = field1931[2];
      var14 = field1928[0];
      int var15 = field1928[1];
      int var16 = field1928[2];
      class94.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class94.rasterClipX || var12 > class94.rasterClipX || var13 > class94.rasterClipX) {
            class94.rasterClipEnable = true;
         }

         if(this.field1900 != null && this.field1900[var1] != -1) {
            if(this.field1894 != null && this.field1894[var1] != -1) {
               var20 = this.field1894[var1] & 255;
               var17 = this.field1934[var20];
               var18 = this.field1923[var20];
               var19 = this.field1924[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1896[var1] == -1) {
               class94.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1905[var1], this.field1905[var1], this.field1905[var1], field1903[var17], field1903[var18], field1903[var19], field1921[var17], field1921[var18], field1921[var19], field1937[var17], field1937[var18], field1937[var19], this.field1900[var1]);
            } else {
               class94.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1935[0], field1935[1], field1935[2], field1903[var17], field1903[var18], field1903[var19], field1921[var17], field1921[var18], field1921[var19], field1937[var17], field1937[var18], field1937[var19], this.field1900[var1]);
            }
         } else if(this.field1896[var1] == -1) {
            class94.rasterFlat(var14, var15, var16, var11, var12, var13, field1944[this.field1905[var1]]);
         } else {
            class94.rasterGouraud(var14, var15, var16, var11, var12, var13, field1935[0], field1935[1], field1935[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class94.rasterClipX || var12 > class94.rasterClipX || var13 > class94.rasterClipX || field1931[3] < 0 || field1931[3] > class94.rasterClipX) {
            class94.rasterClipEnable = true;
         }

         if(this.field1900 != null && this.field1900[var1] != -1) {
            if(this.field1894 != null && this.field1894[var1] != -1) {
               var20 = this.field1894[var1] & 255;
               var17 = this.field1934[var20];
               var18 = this.field1923[var20];
               var19 = this.field1924[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1900[var1];
            if(this.field1896[var1] == -1) {
               class94.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1905[var1], this.field1905[var1], this.field1905[var1], field1903[var17], field1903[var18], field1903[var19], field1921[var17], field1921[var18], field1921[var19], field1937[var17], field1937[var18], field1937[var19], var21);
               class94.rasterTextureAffine(var14, var16, field1928[3], var11, var13, field1931[3], this.field1905[var1], this.field1905[var1], this.field1905[var1], field1903[var17], field1903[var18], field1903[var19], field1921[var17], field1921[var18], field1921[var19], field1937[var17], field1937[var18], field1937[var19], var21);
            } else {
               class94.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1935[0], field1935[1], field1935[2], field1903[var17], field1903[var18], field1903[var19], field1921[var17], field1921[var18], field1921[var19], field1937[var17], field1937[var18], field1937[var19], var21);
               class94.rasterTextureAffine(var14, var16, field1928[3], var11, var13, field1931[3], field1935[0], field1935[2], field1935[3], field1903[var17], field1903[var18], field1903[var19], field1921[var17], field1921[var18], field1921[var19], field1937[var17], field1937[var18], field1937[var19], var21);
            }
         } else if(this.field1896[var1] == -1) {
            var17 = field1944[this.field1905[var1]];
            class94.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            class94.rasterFlat(var14, var16, field1928[3], var11, var13, field1931[3], var17);
         } else {
            class94.rasterGouraud(var14, var15, var16, var11, var12, var13, field1935[0], field1935[1], field1935[2]);
            class94.rasterGouraud(var14, var16, field1928[3], var11, var13, field1931[3], field1935[0], field1935[2], field1935[3]);
         }
      }

   }

   static {
      field1942 = class94.field1670;
      field1943 = class94.field1676;
      field1944 = class94.colorPalette;
      field1945 = class94.field1666;
   }

   @ObfuscatedName("t")
   public void method2347() {
      if(this.field1909 != 1) {
         this.field1909 = 1;
         super.modelHeight = 0;
         this.field1922 = 0;
         this.field1911 = 0;

         for(int var1 = 0; var1 < this.field1895; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1922) {
               this.field1922 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1911) {
               this.field1911 = var5;
            }
         }

         this.field1911 = (int)(Math.sqrt((double)this.field1911) + 0.99D);
         this.field1913 = (int)(Math.sqrt((double)(this.field1911 * this.field1911 + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1912 = this.field1913 + (int)(Math.sqrt((double)(this.field1911 * this.field1911 + this.field1922 * this.field1922)) + 0.99D);
      }
   }

   @ObfuscatedName("r")
   public Model method2353(boolean var1) {
      if(!var1 && field1884.length < this.field1890) {
         field1884 = new byte[this.field1890 + 100];
      }

      return this.method2324(var1, field1941, field1884);
   }

   @ObfuscatedName("k")
   void method2356(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1904 = 0;
         field1932 = 0;
         field1936 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var9 = var2[var8];
            if(var9 < this.field1906.length) {
               int[] var18 = this.field1906[var9];

               for(var11 = 0; var11 < var18.length; ++var11) {
                  var12 = var18[var11];
                  field1904 += this.verticesX[var12];
                  field1932 += this.verticesY[var12];
                  field1936 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1904 = field1904 / var7 + var3;
            field1932 = field1932 / var7 + var4;
            field1936 = field1936 / var7 + var5;
         } else {
            field1904 = var3;
            field1932 = var4;
            field1936 = var5;
         }

      } else {
         int var10;
         int[] var19;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1906.length) {
                  var19 = this.field1906[var8];

                  for(var10 = 0; var10 < var19.length; ++var10) {
                     var11 = var19[var10];
                     this.verticesX[var11] += var3;
                     this.verticesY[var11] += var4;
                     this.verticesZ[var11] += var5;
                  }
               }
            }

         } else if(var1 == 2) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1906.length) {
                  var19 = this.field1906[var8];

                  for(var10 = 0; var10 < var19.length; ++var10) {
                     var11 = var19[var10];
                     this.verticesX[var11] -= field1904;
                     this.verticesY[var11] -= field1932;
                     this.verticesZ[var11] -= field1936;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1942[var14];
                        var16 = field1943[var14];
                        var17 = this.verticesY[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesY[var11] = this.verticesY[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1942[var12];
                        var16 = field1943[var12];
                        var17 = this.verticesY[var11] * var16 - this.verticesZ[var11] * var15 >> 16;
                        this.verticesZ[var11] = this.verticesY[var11] * var15 + this.verticesZ[var11] * var16 >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1942[var13];
                        var16 = field1943[var13];
                        var17 = this.verticesZ[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesZ[var11] = this.verticesZ[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += field1904;
                     this.verticesY[var11] += field1932;
                     this.verticesZ[var11] += field1936;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1906.length) {
                  var19 = this.field1906[var8];

                  for(var10 = 0; var10 < var19.length; ++var10) {
                     var11 = var19[var10];
                     this.verticesX[var11] -= field1904;
                     this.verticesY[var11] -= field1932;
                     this.verticesZ[var11] -= field1936;
                     this.verticesX[var11] = this.verticesX[var11] * var3 / 128;
                     this.verticesY[var11] = this.verticesY[var11] * var4 / 128;
                     this.verticesZ[var11] = this.verticesZ[var11] * var5 / 128;
                     this.verticesX[var11] += field1904;
                     this.verticesY[var11] += field1932;
                     this.verticesZ[var11] += field1936;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1919 != null && this.field1898 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1919.length) {
                     var19 = this.field1919[var8];

                     for(var10 = 0; var10 < var19.length; ++var10) {
                        var11 = var19[var10];
                        var12 = (this.field1898[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1898[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("d")
   public Model method2358(boolean var1) {
      if(!var1 && field1883.length < this.field1890) {
         field1883 = new byte[this.field1890 + 100];
      }

      return this.method2324(var1, field1907, field1883);
   }

   @ObfuscatedName("e")
   final void method2366(boolean var1, boolean var2, int var3) {
      if(this.field1912 < 1600) {
         int var4;
         for(var4 = 0; var4 < this.field1912; ++var4) {
            field1920[var4] = 0;
         }

         int var5;
         int var6;
         int var7;
         int var8;
         int var9;
         int var12;
         int var13;
         int var15;
         int var24;
         for(var4 = 0; var4 < this.field1890; ++var4) {
            if(this.field1896[var4] != -2) {
               var5 = this.indices1[var4];
               var6 = this.indices2[var4];
               var7 = this.indices3[var4];
               var8 = field1917[var5];
               var9 = field1917[var6];
               var24 = field1917[var7];
               int var26;
               if(var1 && (var8 == -5000 || var9 == -5000 || var24 == -5000)) {
                  var26 = field1903[var5];
                  var12 = field1903[var6];
                  var13 = field1903[var7];
                  int var25 = field1921[var5];
                  var15 = field1921[var6];
                  int var16 = field1921[var7];
                  int var17 = field1937[var5];
                  int var18 = field1937[var6];
                  int var19 = field1937[var7];
                  var26 -= var12;
                  var13 -= var12;
                  var25 -= var15;
                  var16 -= var15;
                  var17 -= var18;
                  var19 -= var18;
                  int var20 = var25 * var19 - var17 * var16;
                  int var21 = var17 * var13 - var26 * var19;
                  int var22 = var26 * var16 - var25 * var13;
                  if(var12 * var20 + var15 * var21 + var18 * var22 > 0) {
                     field1916[var4] = true;
                     int var23 = (field1885[var5] + field1885[var6] + field1885[var7]) / 3 + this.field1913;
                     field1925[var23][field1920[var23]++] = var4;
                  }
               } else {
                  if(var2 && this.method2386(field1938, field1939, field1899[var5], field1899[var6], field1899[var7], var8, var9, var24)) {
                     field1910[field1940++] = var3;
                     var2 = false;
                  }

                  if((var8 - var9) * (field1899[var7] - field1899[var6]) - (field1899[var5] - field1899[var6]) * (var24 - var9) > 0) {
                     field1916[var4] = false;
                     if(var8 >= 0 && var9 >= 0 && var24 >= 0 && var8 <= class94.rasterClipX && var9 <= class94.rasterClipX && var24 <= class94.rasterClipX) {
                        field1915[var4] = false;
                     } else {
                        field1915[var4] = true;
                     }

                     var26 = (field1885[var5] + field1885[var6] + field1885[var7]) / 3 + this.field1913;
                     field1925[var26][field1920[var26]++] = var4;
                  }
               }
            }
         }

         int[] var27;
         if(this.field1897 == null) {
            for(var4 = this.field1912 - 1; var4 >= 0; --var4) {
               var5 = field1920[var4];
               if(var5 > 0) {
                  var27 = field1925[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     this.method2340(var27[var7]);
                  }
               }
            }

         } else {
            for(var4 = 0; var4 < 12; ++var4) {
               field1926[var4] = 0;
               field1930[var4] = 0;
            }

            for(var4 = this.field1912 - 1; var4 >= 0; --var4) {
               var5 = field1920[var4];
               if(var5 > 0) {
                  var27 = field1925[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     var8 = var27[var7];
                     byte var28 = this.field1897[var8];
                     var24 = field1926[var28]++;
                     field1927[var28][var24] = var8;
                     if(var28 < 10) {
                        field1930[var28] += var4;
                     } else if(var28 == 10) {
                        field1886[var24] = var4;
                     } else {
                        field1929[var24] = var4;
                     }
                  }
               }
            }

            var4 = 0;
            if(field1926[1] > 0 || field1926[2] > 0) {
               var4 = (field1930[1] + field1930[2]) / (field1926[1] + field1926[2]);
            }

            var5 = 0;
            if(field1926[3] > 0 || field1926[4] > 0) {
               var5 = (field1930[3] + field1930[4]) / (field1926[3] + field1926[4]);
            }

            var6 = 0;
            if(field1926[6] > 0 || field1926[8] > 0) {
               var6 = (field1930[6] + field1930[8]) / (field1926[6] + field1926[8]);
            }

            var8 = 0;
            var9 = field1926[10];
            int[] var10 = field1927[10];
            int[] var11 = field1886;
            if(var8 == var9) {
               var8 = 0;
               var9 = field1926[11];
               var10 = field1927[11];
               var11 = field1929;
            }

            if(var8 < var9) {
               var7 = var11[var8];
            } else {
               var7 = -1000;
            }

            for(var12 = 0; var12 < 10; ++var12) {
               while(var12 == 0 && var7 > var4) {
                  this.method2340(var10[var8++]);
                  if(var8 == var9 && var10 != field1927[11]) {
                     var8 = 0;
                     var9 = field1926[11];
                     var10 = field1927[11];
                     var11 = field1929;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 3 && var7 > var5) {
                  this.method2340(var10[var8++]);
                  if(var8 == var9 && var10 != field1927[11]) {
                     var8 = 0;
                     var9 = field1926[11];
                     var10 = field1927[11];
                     var11 = field1929;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 5 && var7 > var6) {
                  this.method2340(var10[var8++]);
                  if(var8 == var9 && var10 != field1927[11]) {
                     var8 = 0;
                     var9 = field1926[11];
                     var10 = field1927[11];
                     var11 = field1929;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               var13 = field1926[var12];
               int[] var14 = field1927[var12];

               for(var15 = 0; var15 < var13; ++var15) {
                  this.method2340(var14[var15]);
               }
            }

            while(var7 != -1000) {
               this.method2340(var10[var8++]);
               if(var8 == var9 && var10 != field1927[11]) {
                  var8 = 0;
                  var10 = field1927[11];
                  var9 = field1926[11];
                  var11 = field1929;
               }

               if(var8 < var9) {
                  var7 = var11[var8];
               } else {
                  var7 = -1000;
               }
            }

         }
      }
   }

   public Model(Model[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1895 = 0;
      this.field1890 = 0;
      this.field1902 = 0;
      this.field1901 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1895 += var8.field1895;
            this.field1890 += var8.field1890;
            this.field1902 += var8.field1902;
            if(var8.field1897 != null) {
               var3 = true;
            } else {
               if(this.field1901 == -1) {
                  this.field1901 = var8.field1901;
               }

               if(this.field1901 != var8.field1901) {
                  var3 = true;
               }
            }

            var4 |= var8.field1898 != null;
            var5 |= var8.field1900 != null;
            var6 |= var8.field1894 != null;
         }
      }

      this.verticesX = new int[this.field1895];
      this.verticesY = new int[this.field1895];
      this.verticesZ = new int[this.field1895];
      this.indices1 = new int[this.field1890];
      this.indices2 = new int[this.field1890];
      this.indices3 = new int[this.field1890];
      this.field1905 = new int[this.field1890];
      this.field1887 = new int[this.field1890];
      this.field1896 = new int[this.field1890];
      if(var3) {
         this.field1897 = new byte[this.field1890];
      }

      if(var4) {
         this.field1898 = new byte[this.field1890];
      }

      if(var5) {
         this.field1900 = new short[this.field1890];
      }

      if(var6) {
         this.field1894 = new byte[this.field1890];
      }

      if(this.field1902 > 0) {
         this.field1934 = new int[this.field1902];
         this.field1923 = new int[this.field1902];
         this.field1924 = new int[this.field1902];
      }

      this.field1895 = 0;
      this.field1890 = 0;
      this.field1902 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1890; ++var9) {
               this.indices1[this.field1890] = var8.indices1[var9] + this.field1895;
               this.indices2[this.field1890] = var8.indices2[var9] + this.field1895;
               this.indices3[this.field1890] = var8.indices3[var9] + this.field1895;
               this.field1905[this.field1890] = var8.field1905[var9];
               this.field1887[this.field1890] = var8.field1887[var9];
               this.field1896[this.field1890] = var8.field1896[var9];
               if(var3) {
                  if(var8.field1897 != null) {
                     this.field1897[this.field1890] = var8.field1897[var9];
                  } else {
                     this.field1897[this.field1890] = var8.field1901;
                  }
               }

               if(var4 && var8.field1898 != null) {
                  this.field1898[this.field1890] = var8.field1898[var9];
               }

               if(var5) {
                  if(var8.field1900 != null) {
                     this.field1900[this.field1890] = var8.field1900[var9];
                  } else {
                     this.field1900[this.field1890] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1894 != null && var8.field1894[var9] != -1) {
                     this.field1894[this.field1890] = (byte)(var8.field1894[var9] + this.field1902);
                  } else {
                     this.field1894[this.field1890] = -1;
                  }
               }

               ++this.field1890;
            }

            for(var9 = 0; var9 < var8.field1902; ++var9) {
               this.field1934[this.field1902] = var8.field1934[var9] + this.field1895;
               this.field1923[this.field1902] = var8.field1923[var9] + this.field1895;
               this.field1924[this.field1902] = var8.field1924[var9] + this.field1895;
               ++this.field1902;
            }

            for(var9 = 0; var9 < var8.field1895; ++var9) {
               this.verticesX[this.field1895] = var8.verticesX[var9];
               this.verticesY[this.field1895] = var8.verticesY[var9];
               this.verticesZ[this.field1895] = var8.verticesZ[var9];
               ++this.field1895;
            }
         }
      }

   }

   @ObfuscatedName("c")
   final boolean method2386(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      return var2 < var3 && var2 < var4 && var2 < var5?false:(var2 > var3 && var2 > var4 && var2 > var5?false:(var1 < var6 && var1 < var7 && var1 < var8?false:var1 <= var6 || var1 <= var7 || var1 <= var8));
   }
}
