import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ew")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("ay")
   public boolean field1908;
   @ObfuscatedName("h")
   static byte[] field1909;
   @ObfuscatedName("ap")
   static int[] field1910;
   @ObfuscatedName("q")
   static byte[] field1911;
   @ObfuscatedName("g")
   int field1912;
   @ObfuscatedName("v")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("i")
   static Model field1914;
   @ObfuscatedName("k")
   @Export("indices2")
   int[] indices2;
   @ObfuscatedName("l")
   int field1916;
   @ObfuscatedName("a")
   @Export("indices1")
   int[] indices1;
   @ObfuscatedName("d")
   byte[] field1918;
   @ObfuscatedName("aj")
   public int field1919;
   @ObfuscatedName("b")
   int[] field1920;
   @ObfuscatedName("x")
   int[] field1921;
   @ObfuscatedName("r")
   @Export("indices3")
   int[] indices3;
   @ObfuscatedName("j")
   byte[] field1923;
   @ObfuscatedName("m")
   byte[] field1924;
   @ObfuscatedName("bh")
   static int field1925;
   @ObfuscatedName("e")
   short[] field1926;
   @ObfuscatedName("s")
   byte field1927;
   @ObfuscatedName("n")
   int field1928;
   @ObfuscatedName("f")
   int[] field1929;
   @ObfuscatedName("w")
   int[] field1930;
   @ObfuscatedName("bo")
   static int[] field1931;
   @ObfuscatedName("c")
   int[][] field1932;
   @ObfuscatedName("z")
   int[][] field1933;
   @ObfuscatedName("bf")
   static int[] field1934;
   @ObfuscatedName("ah")
   int field1935;
   @ObfuscatedName("az")
   int field1936;
   @ObfuscatedName("ac")
   int field1937;
   @ObfuscatedName("aq")
   int field1938;
   @ObfuscatedName("af")
   int field1939;
   @ObfuscatedName("y")
   int[] field1940;
   @ObfuscatedName("ax")
   public int field1941;
   @ObfuscatedName("ad")
   public int field1942;
   @ObfuscatedName("as")
   static int[] field1944;
   @ObfuscatedName("ar")
   public int field1945;
   @ObfuscatedName("t")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("at")
   static boolean[] field1947;
   @ObfuscatedName("ai")
   static boolean[] field1948;
   @ObfuscatedName("ao")
   static int[] field1949;
   @ObfuscatedName("am")
   static int[] field1950;
   @ObfuscatedName("p")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("al")
   static int[] field1952;
   @ObfuscatedName("aw")
   static int[] field1953;
   @ObfuscatedName("aa")
   static int[] field1954;
   @ObfuscatedName("ae")
   public int field1956;
   @ObfuscatedName("an")
   static int[][] field1957;
   @ObfuscatedName("au")
   static int[] field1958;
   @ObfuscatedName("ab")
   static int[][] field1959;
   @ObfuscatedName("bz")
   static int[] field1960;
   @ObfuscatedName("bd")
   static int[] field1961;
   @ObfuscatedName("bp")
   static int[] field1962;
   @ObfuscatedName("av")
   public int field1963;
   @ObfuscatedName("bb")
   static int[] field1964;
   @ObfuscatedName("bw")
   static int[] field1965;
   @ObfuscatedName("o")
   int[] field1966;
   @ObfuscatedName("bl")
   static int field1967;
   @ObfuscatedName("bi")
   static int field1968;
   @ObfuscatedName("bq")
   public static boolean field1969;
   @ObfuscatedName("bt")
   static int[] field1973;
   @ObfuscatedName("bm")
   static int[] field1974;
   @ObfuscatedName("bv")
   static int[] field1975;
   @ObfuscatedName("u")
   static Model field1976;

   @ObfuscatedName("z")
   public void method2533(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1912; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = this.verticesY[var4] * var2 / 128;
         this.verticesZ[var4] = this.verticesZ[var4] * var3 / 128;
      }

      this.method2571();
   }

   @ObfuscatedName("i")
   public Model method2534(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2575();
      int var7 = var2 - this.field1937;
      int var8 = var2 + this.field1937;
      int var9 = var4 - this.field1937;
      int var10 = var4 + this.field1937;
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
               var11.field1912 = this.field1912;
               var11.field1916 = this.field1916;
               var11.field1928 = this.field1928;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1920 = this.field1920;
               var11.field1921 = this.field1921;
               var11.field1966 = this.field1966;
               var11.field1923 = this.field1923;
               var11.field1924 = this.field1924;
               var11.field1918 = this.field1918;
               var11.field1926 = this.field1926;
               var11.field1927 = this.field1927;
               var11.field1940 = this.field1940;
               var11.field1930 = this.field1930;
               var11.field1929 = this.field1929;
               var11.field1932 = this.field1932;
               var11.field1933 = this.field1933;
               var11.field1908 = this.field1908;
               var11.verticesY = new int[var11.field1912];
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
               for(var12 = 0; var12 < var11.field1912; ++var12) {
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
               for(var12 = 0; var12 < var11.field1912; ++var12) {
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

            var11.method2571();
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("h")
   public Model method2535(boolean var1) {
      if(!var1 && field1909.length < this.field1916) {
         field1909 = new byte[this.field1916 + 100];
      }

      return this.method2537(var1, field1914, field1909);
   }

   @ObfuscatedName("g")
   Model method2537(boolean var1, Model var2, byte[] var3) {
      var2.field1912 = this.field1912;
      var2.field1916 = this.field1916;
      var2.field1928 = this.field1928;
      if(var2.verticesX == null || var2.verticesX.length < this.field1912) {
         var2.verticesX = new int[this.field1912 + 100];
         var2.verticesY = new int[this.field1912 + 100];
         var2.verticesZ = new int[this.field1912 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1912; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if(var1) {
         var2.field1924 = this.field1924;
      } else {
         var2.field1924 = var3;
         if(this.field1924 == null) {
            for(var4 = 0; var4 < this.field1916; ++var4) {
               var2.field1924[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1916; ++var4) {
               var2.field1924[var4] = this.field1924[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1920 = this.field1920;
      var2.field1921 = this.field1921;
      var2.field1966 = this.field1966;
      var2.field1923 = this.field1923;
      var2.field1918 = this.field1918;
      var2.field1926 = this.field1926;
      var2.field1927 = this.field1927;
      var2.field1940 = this.field1940;
      var2.field1930 = this.field1930;
      var2.field1929 = this.field1929;
      var2.field1932 = this.field1932;
      var2.field1933 = this.field1933;
      var2.field1908 = this.field1908;
      var2.method2571();
      return var2;
   }

   @ObfuscatedName("v")
   void method2538(int var1) {
      if(this.field1963 == -1) {
         int var2 = 0;
         int var3 = 0;
         int var4 = 0;
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         int var8 = field1975[var1];
         int var9 = field1973[var1];

         for(int var10 = 0; var10 < this.field1912; ++var10) {
            int var11 = class136.method2640(this.verticesX[var10], this.verticesZ[var10], var8, var9);
            int var12 = this.verticesY[var10];
            int var13 = class136.method2691(this.verticesX[var10], this.verticesZ[var10], var8, var9);
            if(var11 < var2) {
               var2 = var11;
            }

            if(var11 > var5) {
               var5 = var11;
            }

            if(var12 < var3) {
               var3 = var12;
            }

            if(var12 > var6) {
               var6 = var12;
            }

            if(var13 < var4) {
               var4 = var13;
            }

            if(var13 > var7) {
               var7 = var13;
            }
         }

         this.field1919 = (var5 + var2) / 2;
         this.field1941 = (var6 + var3) / 2;
         this.field1942 = (var7 + var4) / 2;
         this.field1963 = (var5 - var2 + 1) / 2;
         this.field1956 = (var6 - var3 + 1) / 2;
         this.field1945 = (var7 - var4 + 1) / 2;
      }
   }

   @ObfuscatedName("p")
   void method2540() {
      if(this.field1935 != 2) {
         this.field1935 = 2;
         this.field1937 = 0;

         for(int var1 = 0; var1 < this.field1912; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1937) {
               this.field1937 = var5;
            }
         }

         this.field1937 = (int)(Math.sqrt((double)this.field1937) + 0.99D);
         this.field1939 = this.field1937;
         this.field1938 = this.field1937 + this.field1937;
      }
   }

   @ObfuscatedName("l")
   public int method2541() {
      this.method2575();
      return this.field1937;
   }

   @ObfuscatedName("k")
   public void method2543(Frames var1, int var2) {
      if(this.field1932 != null) {
         if(var2 != -1) {
            Frame var3 = var1.field2124[var2];
            FrameMap var4 = var3.field1878;
            field1925 = 0;
            field1967 = 0;
            field1968 = 0;

            for(int var5 = 0; var5 < var3.field1879; ++var5) {
               int var6 = var3.field1880[var5];
               this.method2545(var4.field2035[var6], var4.field2033[var6], var3.translator_x[var5], var3.translator_y[var5], var3.translator_z[var5]);
            }

            this.method2571();
         }
      }
   }

   @ObfuscatedName("b")
   public void method2544(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.field2124[var2];
            Frame var7 = var3.field2124[var4];
            FrameMap var8 = var6.field1878;
            field1925 = 0;
            field1967 = 0;
            field1968 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1879; ++var11) {
               for(var12 = var6.field1880[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field2035[var12] == 0) {
                  this.method2545(var8.field2035[var12], var8.field2033[var12], var6.translator_x[var11], var6.translator_y[var11], var6.translator_z[var11]);
               }
            }

            field1925 = 0;
            field1967 = 0;
            field1968 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1879; ++var11) {
               for(var12 = var7.field1880[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field2035[var12] == 0) {
                  this.method2545(var8.field2035[var12], var8.field2033[var12], var7.translator_x[var11], var7.translator_y[var11], var7.translator_z[var11]);
               }
            }

            this.method2571();
         } else {
            this.method2543(var1, var2);
         }
      }
   }

   @ObfuscatedName("s")
   void method2545(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1925 = 0;
         field1967 = 0;
         field1968 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var18 = var2[var8];
            if(var18 < this.field1932.length) {
               int[] var10 = this.field1932[var18];

               for(var11 = 0; var11 < var10.length; ++var11) {
                  var12 = var10[var11];
                  field1925 += this.verticesX[var12];
                  field1967 += this.verticesY[var12];
                  field1968 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1925 = field1925 / var7 + var3;
            field1967 = field1967 / var7 + var4;
            field1968 = field1968 / var7 + var5;
         } else {
            field1925 = var3;
            field1967 = var4;
            field1968 = var5;
         }

      } else {
         int[] var9;
         int var19;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1932.length) {
                  var9 = this.field1932[var8];

                  for(var19 = 0; var19 < var9.length; ++var19) {
                     var11 = var9[var19];
                     this.verticesX[var11] += var3;
                     this.verticesY[var11] += var4;
                     this.verticesZ[var11] += var5;
                  }
               }
            }

         } else if(var1 == 2) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1932.length) {
                  var9 = this.field1932[var8];

                  for(var19 = 0; var19 < var9.length; ++var19) {
                     var11 = var9[var19];
                     this.verticesX[var11] -= field1925;
                     this.verticesY[var11] -= field1967;
                     this.verticesZ[var11] -= field1968;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1973[var14];
                        var16 = field1975[var14];
                        var17 = this.verticesY[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesY[var11] = this.verticesY[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1973[var12];
                        var16 = field1975[var12];
                        var17 = this.verticesY[var11] * var16 - this.verticesZ[var11] * var15 >> 16;
                        this.verticesZ[var11] = this.verticesY[var11] * var15 + this.verticesZ[var11] * var16 >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1973[var13];
                        var16 = field1975[var13];
                        var17 = this.verticesZ[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesZ[var11] = this.verticesZ[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += field1925;
                     this.verticesY[var11] += field1967;
                     this.verticesZ[var11] += field1968;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1932.length) {
                  var9 = this.field1932[var8];

                  for(var19 = 0; var19 < var9.length; ++var19) {
                     var11 = var9[var19];
                     this.verticesX[var11] -= field1925;
                     this.verticesY[var11] -= field1967;
                     this.verticesZ[var11] -= field1968;
                     this.verticesX[var11] = this.verticesX[var11] * var3 / 128;
                     this.verticesY[var11] = this.verticesY[var11] * var4 / 128;
                     this.verticesZ[var11] = this.verticesZ[var11] * var5 / 128;
                     this.verticesX[var11] += field1925;
                     this.verticesY[var11] += field1967;
                     this.verticesZ[var11] += field1968;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1933 != null && this.field1924 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1933.length) {
                     var9 = this.field1933[var8];

                     for(var19 = 0; var19 < var9.length; ++var19) {
                        var11 = var9[var19];
                        var12 = (this.field1924[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1924[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("n")
   public void method2546() {
      for(int var1 = 0; var1 < this.field1912; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.method2571();
   }

   @ObfuscatedName("y")
   public void method2547() {
      for(int var1 = 0; var1 < this.field1912; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.method2571();
   }

   @ObfuscatedName("f")
   public void method2549(int var1) {
      int var2 = field1973[var1];
      int var3 = field1975[var1];

      for(int var4 = 0; var4 < this.field1912; ++var4) {
         int var5 = this.verticesY[var4] * var3 - this.verticesZ[var4] * var2 >> 16;
         this.verticesZ[var4] = this.verticesY[var4] * var2 + this.verticesZ[var4] * var3 >> 16;
         this.verticesY[var4] = var5;
      }

      this.method2571();
   }

   @ObfuscatedName("ay")
   public final void method2552(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1954[0] = -1;
      if(this.field1935 != 2 && this.field1935 != 1) {
         this.method2540();
      }

      int var8 = class136.field2007;
      int var9 = class136.field2008;
      int var10000 = field1973[var1];
      var10000 = field1975[var1];
      int var12 = field1973[var2];
      int var13 = field1975[var2];
      int var14 = field1973[var3];
      int var15 = field1975[var3];
      int var16 = field1973[var4];
      int var17 = field1975[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1912; ++var19) {
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
         field1910[var19] = var22 - var18;
         field1949[var19] = var8 + var20 * class136.field1998 / var22;
         field1950[var19] = var9 + var23 * class136.field1998 / var22;
         if(this.field1928 > 0) {
            field1944[var19] = var20;
            field1953[var19] = var23;
            field1952[var19] = var22;
         }
      }

      try {
         this.method2555(false, false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("ah")
   public final void method2553(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1954[0] = -1;
      if(this.field1935 != 2 && this.field1935 != 1) {
         this.method2540();
      }

      int var9 = class136.field2007;
      int var10 = class136.field2008;
      int var10000 = field1973[var1];
      var10000 = field1975[var1];
      int var13 = field1973[var2];
      int var14 = field1975[var2];
      int var15 = field1973[var3];
      int var16 = field1975[var3];
      int var17 = field1973[var4];
      int var18 = field1975[var4];
      int var19 = var6 * var17 + var7 * var18 >> 16;

      for(int var20 = 0; var20 < this.field1912; ++var20) {
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
         field1910[var20] = var23 - var19;
         field1949[var20] = var9 + var21 * class136.field1998 / var8;
         field1950[var20] = var10 + var24 * class136.field1998 / var8;
         if(this.field1928 > 0) {
            field1944[var20] = var21;
            field1953[var20] = var24;
            field1952[var20] = var23;
         }
      }

      try {
         this.method2555(false, false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("ck")
   void vmethod2903(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1954[0] = -1;
      if(this.field1935 != 1) {
         this.method2575();
      }

      this.method2538(var1);
      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1937 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1937) * class136.field1998;
         if(var15 / var13 < class136.field2012) {
            int var16 = (var14 + this.field1937) * class136.field1998;
            if(var16 / var13 > class136.field2011) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1937 * var2 >> 16;
               int var19 = (var17 + var18) * class136.field1998;
               if(var19 / var13 > class136.field2013) {
                  int var20 = var18 + (super.modelHeight * var3 >> 16);
                  int var21 = (var17 - var20) * class136.field1998;
                  if(var21 / var13 < class136.field2004) {
                     int var22 = var12 + (super.modelHeight * var2 >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1928 > 0;
                     int var26 = FileOnDisk.method2407();
                     int var27 = class67.method1103();
                     boolean var28 = class134.field1980;
                     if(class7.field236 && var9 > 0) {
                        if(class36.method496(this, var6, var7, var8)) {
                           class223.method4145(this, var6, var7, var8, -65281);
                        } else if(class11.field263 == class7.field231) {
                           class223.method4145(this, var6, var7, var8, -16776961);
                        }
                     }

                     int var31;
                     int var32;
                     int var33;
                     int var34;
                     int var35;
                     int var36;
                     int var37;
                     if(class7.field228 && var9 > 0) {
                        int var40 = var11 - var12;
                        if(var40 <= 50) {
                           var40 = 50;
                        }

                        if(var14 > 0) {
                           var31 = var15 / var13;
                           var32 = var16 / var40;
                        } else {
                           var32 = var16 / var13;
                           var31 = var15 / var40;
                        }

                        if(var17 > 0) {
                           var33 = var21 / var13;
                           var34 = var19 / var40;
                        } else {
                           var34 = var19 / var13;
                           var33 = var21 / var40;
                        }

                        var35 = -8355840;
                        var36 = var26 - class136.field2007;
                        var37 = var27 - class136.field2008;
                        if(var36 > var31 && var36 < var32 && var37 > var33 && var37 < var34) {
                           var35 = -256;
                        }

                        Renderable.method2907(var31 + class136.field2007, var33 + class136.field2008, var32 + class136.field2007, var34 + class136.field2008, var35);
                     }

                     boolean var44 = false;
                     if(var9 > 0 && var28) {
                        boolean var43 = false;
                        if(field1969) {
                           var43 = class36.method496(this, var6, var7, var8);
                        } else {
                           var32 = var11 - var12;
                           if(var32 <= 50) {
                              var32 = 50;
                           }

                           if(var14 > 0) {
                              var15 /= var13;
                              var16 /= var32;
                           } else {
                              var16 /= var13;
                              var15 /= var32;
                           }

                           if(var17 > 0) {
                              var21 /= var13;
                              var19 /= var32;
                           } else {
                              var19 /= var13;
                              var21 /= var32;
                           }

                           var33 = var26 - class136.field2007;
                           var34 = var27 - class136.field2008;
                           if(var33 > var15 && var33 < var16 && var34 > var21 && var34 < var19) {
                              var43 = true;
                           }
                        }

                        if(var43) {
                           if(this.field1908) {
                              class82.method1620(var9);
                           } else {
                              var44 = true;
                           }
                        }
                     }

                     var31 = class136.field2007;
                     var32 = class136.field2008;
                     var33 = 0;
                     var34 = 0;
                     if(var1 != 0) {
                        var33 = field1973[var1];
                        var34 = field1975[var1];
                     }

                     for(var35 = 0; var35 < this.field1912; ++var35) {
                        var36 = this.verticesX[var35];
                        var37 = this.verticesY[var35];
                        int var38 = this.verticesZ[var35];
                        int var39;
                        if(var1 != 0) {
                           var39 = var38 * var33 + var36 * var34 >> 16;
                           var38 = var38 * var34 - var36 * var33 >> 16;
                           var36 = var39;
                        }

                        var36 += var6;
                        var37 += var7;
                        var38 += var8;
                        var39 = var38 * var4 + var36 * var5 >> 16;
                        var38 = var38 * var5 - var36 * var4 >> 16;
                        var36 = var39;
                        var39 = var37 * var3 - var38 * var2 >> 16;
                        var38 = var37 * var2 + var38 * var3 >> 16;
                        field1910[var35] = var38 - var11;
                        if(var38 >= 50) {
                           field1949[var35] = var31 + var36 * class136.field1998 / var38;
                           field1950[var35] = var32 + var39 * class136.field1998 / var38;
                        } else {
                           field1949[var35] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1944[var35] = var36;
                           field1953[var35] = var39;
                           field1952[var35] = var38;
                        }
                     }

                     try {
                        this.method2555(var23, var44, this.field1908, var9);
                     } catch (Exception var42) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("az")
   final void method2555(boolean var1, boolean var2, boolean var3, int var4) {
      if(this.field1938 < 1600) {
         int var5;
         for(var5 = 0; var5 < this.field1938; ++var5) {
            field1954[var5] = 0;
         }

         var5 = var3?20:5;
         int var7;
         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         int var14;
         int var15;
         int var16;
         int var17;
         int var18;
         int var19;
         int var20;
         int var27;
         if(class7.field230 && var2) {
            Model var6 = this;

            for(var7 = 0; var7 < var6.field1916; ++var7) {
               if(var6.field1966[var7] != -2) {
                  var8 = var6.indices1[var7];
                  var9 = var6.indices2[var7];
                  var10 = var6.indices3[var7];
                  var11 = field1949[var8];
                  var12 = field1949[var9];
                  var27 = field1949[var10];
                  var14 = field1950[var8];
                  var15 = field1950[var9];
                  var16 = field1950[var10];
                  var17 = Math.min(var11, Math.min(var12, var27)) - var5;
                  var18 = Math.max(var11, Math.max(var12, var27)) + var5;
                  var19 = Math.min(var14, Math.min(var15, var16)) - var5;
                  var20 = Math.max(var14, Math.max(var15, var16)) + var5;
                  Renderable.method2907(var17, var19, var18, var20, -49088);
               }
            }
         }

         int var26;
         for(var26 = 0; var26 < this.field1916; ++var26) {
            if(this.field1966[var26] != -2) {
               var7 = this.indices1[var26];
               var8 = this.indices2[var26];
               var9 = this.indices3[var26];
               var10 = field1949[var7];
               var11 = field1949[var8];
               var12 = field1949[var9];
               if(!var1 || var10 != -5000 && var11 != -5000 && var12 != -5000) {
                  if(var2) {
                     var14 = field1950[var7];
                     var15 = field1950[var8];
                     var16 = field1950[var9];
                     var17 = var5 + class134.field1988;
                     boolean var32;
                     if(var17 < var14 && var17 < var15 && var17 < var16) {
                        var32 = false;
                     } else {
                        var17 = class134.field1988 - var5;
                        if(var17 > var14 && var17 > var15 && var17 > var16) {
                           var32 = false;
                        } else {
                           var17 = var5 + class134.field1979;
                           if(var17 < var10 && var17 < var11 && var17 < var12) {
                              var32 = false;
                           } else {
                              var17 = class134.field1979 - var5;
                              if(var17 > var10 && var17 > var11 && var17 > var12) {
                                 var32 = false;
                              } else {
                                 var32 = true;
                              }
                           }
                        }
                     }

                     if(var32) {
                        class82.method1620(var4);
                        var2 = false;
                     }
                  }

                  if((var10 - var11) * (field1950[var9] - field1950[var8]) - (field1950[var7] - field1950[var8]) * (var12 - var11) > 0) {
                     field1948[var26] = false;
                     if(var10 >= 0 && var11 >= 0 && var12 >= 0 && var10 <= class136.rasterClipX && var11 <= class136.rasterClipX && var12 <= class136.rasterClipX) {
                        field1947[var26] = false;
                     } else {
                        field1947[var26] = true;
                     }

                     var27 = (field1910[var7] + field1910[var8] + field1910[var9]) / 3 + this.field1939;
                     field1957[var27][field1954[var27]++] = var26;
                  }
               } else {
                  var27 = field1944[var7];
                  var14 = field1944[var8];
                  var15 = field1944[var9];
                  var16 = field1953[var7];
                  var17 = field1953[var8];
                  var18 = field1953[var9];
                  var19 = field1952[var7];
                  var20 = field1952[var8];
                  int var21 = field1952[var9];
                  var27 -= var14;
                  var15 -= var14;
                  var16 -= var17;
                  var18 -= var17;
                  var19 -= var20;
                  var21 -= var20;
                  int var22 = var16 * var21 - var19 * var18;
                  int var23 = var19 * var15 - var27 * var21;
                  int var24 = var27 * var18 - var16 * var15;
                  if(var14 * var22 + var17 * var23 + var20 * var24 > 0) {
                     field1948[var26] = true;
                     int var25 = (field1910[var7] + field1910[var8] + field1910[var9]) / 3 + this.field1939;
                     field1957[var25][field1954[var25]++] = var26;
                  }
               }
            }
         }

         int[] var30;
         if(this.field1923 == null) {
            for(var26 = this.field1938 - 1; var26 >= 0; --var26) {
               var7 = field1954[var26];
               if(var7 > 0) {
                  var30 = field1957[var26];

                  for(var9 = 0; var9 < var7; ++var9) {
                     this.method2599(var30[var9]);
                  }
               }
            }

         } else {
            for(var26 = 0; var26 < 12; ++var26) {
               field1958[var26] = 0;
               field1962[var26] = 0;
            }

            for(var26 = this.field1938 - 1; var26 >= 0; --var26) {
               var7 = field1954[var26];
               if(var7 > 0) {
                  var30 = field1957[var26];

                  for(var9 = 0; var9 < var7; ++var9) {
                     var10 = var30[var9];
                     byte var31 = this.field1923[var10];
                     var12 = field1958[var31]++;
                     field1959[var31][var12] = var10;
                     if(var31 < 10) {
                        field1962[var31] += var26;
                     } else if(var31 == 10) {
                        field1960[var12] = var26;
                     } else {
                        field1961[var12] = var26;
                     }
                  }
               }
            }

            var26 = 0;
            if(field1958[1] > 0 || field1958[2] > 0) {
               var26 = (field1962[1] + field1962[2]) / (field1958[1] + field1958[2]);
            }

            var7 = 0;
            if(field1958[3] > 0 || field1958[4] > 0) {
               var7 = (field1962[3] + field1962[4]) / (field1958[3] + field1958[4]);
            }

            var8 = 0;
            if(field1958[6] > 0 || field1958[8] > 0) {
               var8 = (field1962[6] + field1962[8]) / (field1958[6] + field1958[8]);
            }

            var10 = 0;
            var11 = field1958[10];
            int[] var28 = field1959[10];
            int[] var13 = field1960;
            if(var10 == var11) {
               var10 = 0;
               var11 = field1958[11];
               var28 = field1959[11];
               var13 = field1961;
            }

            if(var10 < var11) {
               var9 = var13[var10];
            } else {
               var9 = -1000;
            }

            for(var14 = 0; var14 < 10; ++var14) {
               while(var14 == 0 && var9 > var26) {
                  this.method2599(var28[var10++]);
                  if(var10 == var11 && var28 != field1959[11]) {
                     var10 = 0;
                     var11 = field1958[11];
                     var28 = field1959[11];
                     var13 = field1961;
                  }

                  if(var10 < var11) {
                     var9 = var13[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 3 && var9 > var7) {
                  this.method2599(var28[var10++]);
                  if(var10 == var11 && var28 != field1959[11]) {
                     var10 = 0;
                     var11 = field1958[11];
                     var28 = field1959[11];
                     var13 = field1961;
                  }

                  if(var10 < var11) {
                     var9 = var13[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 5 && var9 > var8) {
                  this.method2599(var28[var10++]);
                  if(var10 == var11 && var28 != field1959[11]) {
                     var10 = 0;
                     var11 = field1958[11];
                     var28 = field1959[11];
                     var13 = field1961;
                  }

                  if(var10 < var11) {
                     var9 = var13[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               var15 = field1958[var14];
               int[] var29 = field1959[var14];

               for(var17 = 0; var17 < var15; ++var17) {
                  this.method2599(var29[var17]);
               }
            }

            while(var9 != -1000) {
               this.method2599(var28[var10++]);
               if(var10 == var11 && var28 != field1959[11]) {
                  var10 = 0;
                  var28 = field1959[11];
                  var11 = field1958[11];
                  var13 = field1961;
               }

               if(var10 < var11) {
                  var9 = var13[var10];
               } else {
                  var9 = -1000;
               }
            }

         }
      }
   }

   static {
      field1914 = new Model();
      field1909 = new byte[1];
      field1976 = new Model();
      field1911 = new byte[1];
      field1947 = new boolean[4700];
      field1948 = new boolean[4700];
      field1949 = new int[4700];
      field1950 = new int[4700];
      field1910 = new int[4700];
      field1944 = new int[4700];
      field1953 = new int[4700];
      field1952 = new int[4700];
      field1954 = new int[1600];
      field1957 = new int[1600][512];
      field1958 = new int[12];
      field1959 = new int[12][2000];
      field1960 = new int[2000];
      field1961 = new int[2000];
      field1962 = new int[12];
      field1934 = new int[10];
      field1964 = new int[10];
      field1965 = new int[10];
      field1969 = true;
      field1973 = class136.SINE;
      field1975 = class136.COSINE;
      field1974 = class136.colorPalette;
      field1931 = class136.field2002;
   }

   @ObfuscatedName("q")
   public Model method2558(boolean var1) {
      if(!var1 && field1911.length < this.field1916) {
         field1911 = new byte[this.field1916 + 100];
      }

      return this.method2537(var1, field1976, field1911);
   }

   Model() {
      this.field1912 = 0;
      this.field1916 = 0;
      this.field1927 = 0;
      this.field1928 = 0;
      this.field1908 = false;
      this.field1963 = -1;
      this.field1956 = -1;
      this.field1945 = -1;
   }

   @ObfuscatedName("aq")
   final void method2564(int var1) {
      int var2 = class136.field2007;
      int var3 = class136.field2008;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1952[var5];
      int var9 = field1952[var6];
      int var10 = field1952[var7];
      if(this.field1924 == null) {
         class136.rasterAlpha = 0;
      } else {
         class136.rasterAlpha = this.field1924[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1934[var4] = field1949[var5];
         field1964[var4] = field1950[var5];
         field1965[var4++] = this.field1920[var1];
      } else {
         var11 = field1944[var5];
         var12 = field1953[var5];
         var13 = this.field1920[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1931[var10 - var8];
            field1934[var4] = var2 + (var11 + ((field1944[var7] - var11) * var14 >> 16)) * class136.field1998 / 50;
            field1964[var4] = var3 + (var12 + ((field1953[var7] - var12) * var14 >> 16)) * class136.field1998 / 50;
            field1965[var4++] = var13 + ((this.field1966[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1931[var9 - var8];
            field1934[var4] = var2 + (var11 + ((field1944[var6] - var11) * var14 >> 16)) * class136.field1998 / 50;
            field1964[var4] = var3 + (var12 + ((field1953[var6] - var12) * var14 >> 16)) * class136.field1998 / 50;
            field1965[var4++] = var13 + ((this.field1921[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1934[var4] = field1949[var6];
         field1964[var4] = field1950[var6];
         field1965[var4++] = this.field1921[var1];
      } else {
         var11 = field1944[var6];
         var12 = field1953[var6];
         var13 = this.field1921[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1931[var8 - var9];
            field1934[var4] = var2 + (var11 + ((field1944[var5] - var11) * var14 >> 16)) * class136.field1998 / 50;
            field1964[var4] = var3 + (var12 + ((field1953[var5] - var12) * var14 >> 16)) * class136.field1998 / 50;
            field1965[var4++] = var13 + ((this.field1920[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1931[var10 - var9];
            field1934[var4] = var2 + (var11 + ((field1944[var7] - var11) * var14 >> 16)) * class136.field1998 / 50;
            field1964[var4] = var3 + (var12 + ((field1953[var7] - var12) * var14 >> 16)) * class136.field1998 / 50;
            field1965[var4++] = var13 + ((this.field1966[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1934[var4] = field1949[var7];
         field1964[var4] = field1950[var7];
         field1965[var4++] = this.field1966[var1];
      } else {
         var11 = field1944[var7];
         var12 = field1953[var7];
         var13 = this.field1966[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1931[var9 - var10];
            field1934[var4] = var2 + (var11 + ((field1944[var6] - var11) * var14 >> 16)) * class136.field1998 / 50;
            field1964[var4] = var3 + (var12 + ((field1953[var6] - var12) * var14 >> 16)) * class136.field1998 / 50;
            field1965[var4++] = var13 + ((this.field1921[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1931[var8 - var10];
            field1934[var4] = var2 + (var11 + ((field1944[var5] - var11) * var14 >> 16)) * class136.field1998 / 50;
            field1964[var4] = var3 + (var12 + ((field1953[var5] - var12) * var14 >> 16)) * class136.field1998 / 50;
            field1965[var4++] = var13 + ((this.field1920[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1934[0];
      var12 = field1934[1];
      var13 = field1934[2];
      var14 = field1964[0];
      int var15 = field1964[1];
      int var16 = field1964[2];
      class136.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class136.rasterClipX || var12 > class136.rasterClipX || var13 > class136.rasterClipX) {
            class136.rasterClipEnable = true;
         }

         if(this.field1926 != null && this.field1926[var1] != -1) {
            if(this.field1918 != null && this.field1918[var1] != -1) {
               var20 = this.field1918[var1] & 255;
               var17 = this.field1940[var20];
               var18 = this.field1930[var20];
               var19 = this.field1929[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1966[var1] == -1) {
               class136.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1920[var1], this.field1920[var1], this.field1920[var1], field1944[var17], field1944[var18], field1944[var19], field1953[var17], field1953[var18], field1953[var19], field1952[var17], field1952[var18], field1952[var19], this.field1926[var1]);
            } else {
               class136.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1965[0], field1965[1], field1965[2], field1944[var17], field1944[var18], field1944[var19], field1953[var17], field1953[var18], field1953[var19], field1952[var17], field1952[var18], field1952[var19], this.field1926[var1]);
            }
         } else if(this.field1966[var1] == -1) {
            class136.rasterFlat(var14, var15, var16, var11, var12, var13, field1974[this.field1920[var1]]);
         } else {
            class136.rasterGouraud(var14, var15, var16, var11, var12, var13, field1965[0], field1965[1], field1965[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class136.rasterClipX || var12 > class136.rasterClipX || var13 > class136.rasterClipX || field1934[3] < 0 || field1934[3] > class136.rasterClipX) {
            class136.rasterClipEnable = true;
         }

         if(this.field1926 != null && this.field1926[var1] != -1) {
            if(this.field1918 != null && this.field1918[var1] != -1) {
               var20 = this.field1918[var1] & 255;
               var17 = this.field1940[var20];
               var18 = this.field1930[var20];
               var19 = this.field1929[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1926[var1];
            if(this.field1966[var1] == -1) {
               class136.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1920[var1], this.field1920[var1], this.field1920[var1], field1944[var17], field1944[var18], field1944[var19], field1953[var17], field1953[var18], field1953[var19], field1952[var17], field1952[var18], field1952[var19], var21);
               class136.rasterTextureAffine(var14, var16, field1964[3], var11, var13, field1934[3], this.field1920[var1], this.field1920[var1], this.field1920[var1], field1944[var17], field1944[var18], field1944[var19], field1953[var17], field1953[var18], field1953[var19], field1952[var17], field1952[var18], field1952[var19], var21);
            } else {
               class136.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1965[0], field1965[1], field1965[2], field1944[var17], field1944[var18], field1944[var19], field1953[var17], field1953[var18], field1953[var19], field1952[var17], field1952[var18], field1952[var19], var21);
               class136.rasterTextureAffine(var14, var16, field1964[3], var11, var13, field1934[3], field1965[0], field1965[2], field1965[3], field1944[var17], field1944[var18], field1944[var19], field1953[var17], field1953[var18], field1953[var19], field1952[var17], field1952[var18], field1952[var19], var21);
            }
         } else if(this.field1966[var1] == -1) {
            var17 = field1974[this.field1920[var1]];
            class136.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            class136.rasterFlat(var14, var16, field1964[3], var11, var13, field1934[3], var17);
         } else {
            class136.rasterGouraud(var14, var15, var16, var11, var12, var13, field1965[0], field1965[1], field1965[2]);
            class136.rasterGouraud(var14, var16, field1964[3], var11, var13, field1934[3], field1965[0], field1965[2], field1965[3]);
         }
      }

   }

   @ObfuscatedName("c")
   public void method2565(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1912; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.method2571();
   }

   @ObfuscatedName("a")
   void method2571() {
      this.field1935 = 0;
      this.field1963 = -1;
   }

   public Model(Model[] var1, int var2) {
      this.field1912 = 0;
      this.field1916 = 0;
      this.field1927 = 0;
      this.field1928 = 0;
      this.field1908 = false;
      this.field1963 = -1;
      this.field1956 = -1;
      this.field1945 = -1;
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1912 = 0;
      this.field1916 = 0;
      this.field1928 = 0;
      this.field1927 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1912 += var8.field1912;
            this.field1916 += var8.field1916;
            this.field1928 += var8.field1928;
            if(var8.field1923 != null) {
               var3 = true;
            } else {
               if(this.field1927 == -1) {
                  this.field1927 = var8.field1927;
               }

               if(this.field1927 != var8.field1927) {
                  var3 = true;
               }
            }

            var4 |= var8.field1924 != null;
            var5 |= var8.field1926 != null;
            var6 |= var8.field1918 != null;
         }
      }

      this.verticesX = new int[this.field1912];
      this.verticesY = new int[this.field1912];
      this.verticesZ = new int[this.field1912];
      this.indices1 = new int[this.field1916];
      this.indices2 = new int[this.field1916];
      this.indices3 = new int[this.field1916];
      this.field1920 = new int[this.field1916];
      this.field1921 = new int[this.field1916];
      this.field1966 = new int[this.field1916];
      if(var3) {
         this.field1923 = new byte[this.field1916];
      }

      if(var4) {
         this.field1924 = new byte[this.field1916];
      }

      if(var5) {
         this.field1926 = new short[this.field1916];
      }

      if(var6) {
         this.field1918 = new byte[this.field1916];
      }

      if(this.field1928 > 0) {
         this.field1940 = new int[this.field1928];
         this.field1930 = new int[this.field1928];
         this.field1929 = new int[this.field1928];
      }

      this.field1912 = 0;
      this.field1916 = 0;
      this.field1928 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1916; ++var9) {
               this.indices1[this.field1916] = var8.indices1[var9] + this.field1912;
               this.indices2[this.field1916] = var8.indices2[var9] + this.field1912;
               this.indices3[this.field1916] = var8.indices3[var9] + this.field1912;
               this.field1920[this.field1916] = var8.field1920[var9];
               this.field1921[this.field1916] = var8.field1921[var9];
               this.field1966[this.field1916] = var8.field1966[var9];
               if(var3) {
                  if(var8.field1923 != null) {
                     this.field1923[this.field1916] = var8.field1923[var9];
                  } else {
                     this.field1923[this.field1916] = var8.field1927;
                  }
               }

               if(var4 && var8.field1924 != null) {
                  this.field1924[this.field1916] = var8.field1924[var9];
               }

               if(var5) {
                  if(var8.field1926 != null) {
                     this.field1926[this.field1916] = var8.field1926[var9];
                  } else {
                     this.field1926[this.field1916] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1918 != null && var8.field1918[var9] != -1) {
                     this.field1918[this.field1916] = (byte)(var8.field1918[var9] + this.field1928);
                  } else {
                     this.field1918[this.field1916] = -1;
                  }
               }

               ++this.field1916;
            }

            for(var9 = 0; var9 < var8.field1928; ++var9) {
               this.field1940[this.field1928] = var8.field1940[var9] + this.field1912;
               this.field1930[this.field1928] = var8.field1930[var9] + this.field1912;
               this.field1929[this.field1928] = var8.field1929[var9] + this.field1912;
               ++this.field1928;
            }

            for(var9 = 0; var9 < var8.field1912; ++var9) {
               this.verticesX[this.field1912] = var8.verticesX[var9];
               this.verticesY[this.field1912] = var8.verticesY[var9];
               this.verticesZ[this.field1912] = var8.verticesZ[var9];
               ++this.field1912;
            }
         }
      }

   }

   @ObfuscatedName("t")
   public void method2575() {
      if(this.field1935 != 1) {
         this.field1935 = 1;
         super.modelHeight = 0;
         this.field1936 = 0;
         this.field1937 = 0;

         for(int var1 = 0; var1 < this.field1912; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1936) {
               this.field1936 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1937) {
               this.field1937 = var5;
            }
         }

         this.field1937 = (int)(Math.sqrt((double)this.field1937) + 0.99D);
         this.field1939 = (int)(Math.sqrt((double)(this.field1937 * this.field1937 + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1938 = this.field1939 + (int)(Math.sqrt((double)(this.field1937 * this.field1937 + this.field1936 * this.field1936)) + 0.99D);
      }
   }

   @ObfuscatedName("w")
   public void method2585() {
      for(int var1 = 0; var1 < this.field1912; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.method2571();
   }

   @ObfuscatedName("ac")
   final void method2599(int var1) {
      if(field1948[var1]) {
         this.method2564(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         class136.rasterClipEnable = field1947[var1];
         if(this.field1924 == null) {
            class136.rasterAlpha = 0;
         } else {
            class136.rasterAlpha = this.field1924[var1] & 255;
         }

         if(this.field1926 != null && this.field1926[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1918 != null && this.field1918[var1] != -1) {
               int var8 = this.field1918[var1] & 255;
               var5 = this.field1940[var8];
               var6 = this.field1930[var8];
               var7 = this.field1929[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1966[var1] == -1) {
               class136.rasterTextureAffine(field1950[var2], field1950[var3], field1950[var4], field1949[var2], field1949[var3], field1949[var4], this.field1920[var1], this.field1920[var1], this.field1920[var1], field1944[var5], field1944[var6], field1944[var7], field1953[var5], field1953[var6], field1953[var7], field1952[var5], field1952[var6], field1952[var7], this.field1926[var1]);
            } else {
               class136.rasterTextureAffine(field1950[var2], field1950[var3], field1950[var4], field1949[var2], field1949[var3], field1949[var4], this.field1920[var1], this.field1921[var1], this.field1966[var1], field1944[var5], field1944[var6], field1944[var7], field1953[var5], field1953[var6], field1953[var7], field1952[var5], field1952[var6], field1952[var7], this.field1926[var1]);
            }
         } else if(this.field1966[var1] == -1) {
            class136.rasterFlat(field1950[var2], field1950[var3], field1950[var4], field1949[var2], field1949[var3], field1949[var4], field1974[this.field1920[var1]]);
         } else {
            class136.rasterGouraud(field1950[var2], field1950[var3], field1950[var4], field1949[var2], field1949[var3], field1949[var4], this.field1920[var1], this.field1921[var1], this.field1966[var1]);
         }

      }
   }
}
