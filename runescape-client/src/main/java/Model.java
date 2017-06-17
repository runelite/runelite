import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("es")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("z")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("m")
   static byte[] field1924;
   @ObfuscatedName("bc")
   public static boolean field1925;
   @ObfuscatedName("d")
   int[] field1926;
   @ObfuscatedName("w")
   int field1927;
   @ObfuscatedName("ac")
   public int field1928;
   @ObfuscatedName("j")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("f")
   public int field1930;
   @ObfuscatedName("ag")
   public static int[] field1931;
   @ObfuscatedName("c")
   @Export("indices1")
   public int[] indices1;
   @ObfuscatedName("o")
   @Export("indices2")
   public int[] indices2;
   @ObfuscatedName("q")
   @Export("indices3")
   public int[] indices3;
   @ObfuscatedName("n")
   int[] field1935;
   @ObfuscatedName("a")
   int[] field1936;
   @ObfuscatedName("aq")
   public static int[] field1937;
   @ObfuscatedName("v")
   byte[] field1938;
   @ObfuscatedName("s")
   byte[] field1939;
   @ObfuscatedName("bf")
   static int[] field1940;
   @ObfuscatedName("r")
   short[] field1941;
   @ObfuscatedName("an")
   static int[] field1942;
   @ObfuscatedName("at")
   static int[][] field1943;
   @ObfuscatedName("bo")
   static int[] field1944;
   @ObfuscatedName("x")
   int[] field1945;
   @ObfuscatedName("b")
   int[] field1946;
   @ObfuscatedName("y")
   int[][] field1947;
   @ObfuscatedName("bv")
   static int[] field1948;
   @ObfuscatedName("av")
   public boolean field1949;
   @ObfuscatedName("ax")
   int field1950;
   @ObfuscatedName("af")
   int field1951;
   @ObfuscatedName("ae")
   int field1952;
   @ObfuscatedName("ap")
   int field1953;
   @ObfuscatedName("ak")
   int field1954;
   @ObfuscatedName("al")
   public int field1955;
   @ObfuscatedName("ab")
   public int field1956;
   @ObfuscatedName("am")
   public int field1957;
   @ObfuscatedName("ar")
   public int field1958;
   @ObfuscatedName("ao")
   public int field1959;
   @ObfuscatedName("h")
   int field1960;
   @ObfuscatedName("ay")
   static boolean[] field1962;
   @ObfuscatedName("aj")
   static boolean[] field1963;
   @ObfuscatedName("g")
   public int[] field1964;
   @ObfuscatedName("t")
   static byte[] field1965;
   @ObfuscatedName("as")
   static int[] field1966;
   @ObfuscatedName("bd")
   static int[] field1967;
   @ObfuscatedName("az")
   static int[] field1968;
   @ObfuscatedName("ai")
   static int[] field1969;
   @ObfuscatedName("au")
   static int[] field1971;
   @ObfuscatedName("ah")
   static int[][] field1972;
   @ObfuscatedName("ad")
   static int[] field1973;
   @ObfuscatedName("k")
   byte[] field1974;
   @ObfuscatedName("bg")
   static int[] field1975;
   @ObfuscatedName("u")
   int[][] field1976;
   @ObfuscatedName("l")
   byte field1977;
   @ObfuscatedName("ba")
   static int[] field1978;
   @ObfuscatedName("bz")
   static int[] field1979;
   @ObfuscatedName("i")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("bp")
   static int field1981;
   @ObfuscatedName("bn")
   static int field1982;
   @ObfuscatedName("br")
   static int field1983;
   @ObfuscatedName("p")
   static Model field1984;
   @ObfuscatedName("bq")
   static int[] field1987;
   @ObfuscatedName("e")
   static Model field1988;
   @ObfuscatedName("bi")
   static int[] field1989;
   @ObfuscatedName("bm")
   static int[] field1990;

   public Model(Model[] var1, int var2) {
      this.field1927 = 0;
      this.field1930 = 0;
      this.field1977 = 0;
      this.field1960 = 0;
      this.field1949 = false;
      this.field1958 = -1;
      this.field1959 = -1;
      this.field1928 = -1;
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1927 = 0;
      this.field1930 = 0;
      this.field1960 = 0;
      this.field1977 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1927 += var8.field1927;
            this.field1930 += var8.field1930;
            this.field1960 += var8.field1960;
            if(var8.field1938 != null) {
               var3 = true;
            } else {
               if(this.field1977 == -1) {
                  this.field1977 = var8.field1977;
               }

               if(this.field1977 != var8.field1977) {
                  var3 = true;
               }
            }

            var4 |= var8.field1939 != null;
            var5 |= var8.field1941 != null;
            var6 |= var8.field1974 != null;
         }
      }

      this.verticesX = new int[this.field1927];
      this.verticesY = new int[this.field1927];
      this.verticesZ = new int[this.field1927];
      this.indices1 = new int[this.field1930];
      this.indices2 = new int[this.field1930];
      this.indices3 = new int[this.field1930];
      this.field1935 = new int[this.field1930];
      this.field1936 = new int[this.field1930];
      this.field1964 = new int[this.field1930];
      if(var3) {
         this.field1938 = new byte[this.field1930];
      }

      if(var4) {
         this.field1939 = new byte[this.field1930];
      }

      if(var5) {
         this.field1941 = new short[this.field1930];
      }

      if(var6) {
         this.field1974 = new byte[this.field1930];
      }

      if(this.field1960 > 0) {
         this.field1926 = new int[this.field1960];
         this.field1945 = new int[this.field1960];
         this.field1946 = new int[this.field1960];
      }

      this.field1927 = 0;
      this.field1930 = 0;
      this.field1960 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1930; ++var9) {
               this.indices1[this.field1930] = var8.indices1[var9] + this.field1927;
               this.indices2[this.field1930] = var8.indices2[var9] + this.field1927;
               this.indices3[this.field1930] = var8.indices3[var9] + this.field1927;
               this.field1935[this.field1930] = var8.field1935[var9];
               this.field1936[this.field1930] = var8.field1936[var9];
               this.field1964[this.field1930] = var8.field1964[var9];
               if(var3) {
                  if(var8.field1938 != null) {
                     this.field1938[this.field1930] = var8.field1938[var9];
                  } else {
                     this.field1938[this.field1930] = var8.field1977;
                  }
               }

               if(var4 && var8.field1939 != null) {
                  this.field1939[this.field1930] = var8.field1939[var9];
               }

               if(var5) {
                  if(var8.field1941 != null) {
                     this.field1941[this.field1930] = var8.field1941[var9];
                  } else {
                     this.field1941[this.field1930] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1974 != null && var8.field1974[var9] != -1) {
                     this.field1974[this.field1930] = (byte)(var8.field1974[var9] + this.field1960);
                  } else {
                     this.field1974[this.field1930] = -1;
                  }
               }

               ++this.field1930;
            }

            for(var9 = 0; var9 < var8.field1960; ++var9) {
               this.field1926[this.field1960] = var8.field1926[var9] + this.field1927;
               this.field1945[this.field1960] = var8.field1945[var9] + this.field1927;
               this.field1946[this.field1960] = var8.field1946[var9] + this.field1927;
               ++this.field1960;
            }

            for(var9 = 0; var9 < var8.field1927; ++var9) {
               this.verticesX[this.field1927] = var8.verticesX[var9];
               this.verticesY[this.field1927] = var8.verticesY[var9];
               this.verticesZ[this.field1927] = var8.verticesZ[var9];
               ++this.field1927;
            }
         }
      }

   }

   @ObfuscatedName("p")
   public Model method2392(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2397();
      int var7 = var2 - this.field1952;
      int var8 = var2 + this.field1952;
      int var9 = var4 - this.field1952;
      int var10 = var4 + this.field1952;
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
               var11.field1927 = this.field1927;
               var11.field1930 = this.field1930;
               var11.field1960 = this.field1960;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1935 = this.field1935;
               var11.field1936 = this.field1936;
               var11.field1964 = this.field1964;
               var11.field1938 = this.field1938;
               var11.field1939 = this.field1939;
               var11.field1974 = this.field1974;
               var11.field1941 = this.field1941;
               var11.field1977 = this.field1977;
               var11.field1926 = this.field1926;
               var11.field1945 = this.field1945;
               var11.field1946 = this.field1946;
               var11.field1947 = this.field1947;
               var11.field1976 = this.field1976;
               var11.field1949 = this.field1949;
               var11.verticesY = new int[var11.field1927];
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
               for(var12 = 0; var12 < var11.field1927; ++var12) {
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
               for(var12 = 0; var12 < var11.field1927; ++var12) {
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

            var11.method2400();
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("m")
   public Model method2393(boolean var1) {
      if(!var1 && field1924.length < this.field1930) {
         field1924 = new byte[this.field1930 + 100];
      }

      return this.method2395(var1, field1984, field1924);
   }

   @ObfuscatedName("t")
   public Model method2394(boolean var1) {
      if(!var1 && field1965.length < this.field1930) {
         field1965 = new byte[this.field1930 + 100];
      }

      return this.method2395(var1, field1988, field1965);
   }

   @ObfuscatedName("w")
   Model method2395(boolean var1, Model var2, byte[] var3) {
      var2.field1927 = this.field1927;
      var2.field1930 = this.field1930;
      var2.field1960 = this.field1960;
      if(var2.verticesX == null || var2.verticesX.length < this.field1927) {
         var2.verticesX = new int[this.field1927 + 100];
         var2.verticesY = new int[this.field1927 + 100];
         var2.verticesZ = new int[this.field1927 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1927; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if(var1) {
         var2.field1939 = this.field1939;
      } else {
         var2.field1939 = var3;
         if(this.field1939 == null) {
            for(var4 = 0; var4 < this.field1930; ++var4) {
               var2.field1939[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1930; ++var4) {
               var2.field1939[var4] = this.field1939[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1935 = this.field1935;
      var2.field1936 = this.field1936;
      var2.field1964 = this.field1964;
      var2.field1938 = this.field1938;
      var2.field1974 = this.field1974;
      var2.field1941 = this.field1941;
      var2.field1977 = this.field1977;
      var2.field1926 = this.field1926;
      var2.field1945 = this.field1945;
      var2.field1946 = this.field1946;
      var2.field1947 = this.field1947;
      var2.field1976 = this.field1976;
      var2.field1949 = this.field1949;
      var2.method2400();
      return var2;
   }

   @ObfuscatedName("z")
   void method2396(int var1) {
      if(this.field1958 == -1) {
         int var2 = 0;
         int var3 = 0;
         int var4 = 0;
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         int var8 = field1967[var1];
         int var9 = field1987[var1];

         for(int var10 = 0; var10 < this.field1927; ++var10) {
            int var11 = class136.method2510(this.verticesX[var10], this.verticesZ[var10], var8, var9);
            int var12 = this.verticesY[var10];
            int var13 = class136.method2511(this.verticesX[var10], this.verticesZ[var10], var8, var9);
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

         this.field1955 = (var5 + var2) / 2;
         this.field1956 = (var6 + var3) / 2;
         this.field1957 = (var7 + var4) / 2;
         this.field1958 = (var5 - var2 + 1) / 2;
         this.field1959 = (var6 - var3 + 1) / 2;
         this.field1928 = (var7 - var4 + 1) / 2;
         if(this.field1958 < 32) {
            this.field1958 = 32;
         }

         if(this.field1928 < 32) {
            this.field1928 = 32;
         }

         if(this.field1949) {
            this.field1958 += 8;
            this.field1928 += 8;
         }
      }

   }

   @ObfuscatedName("j")
   public void method2397() {
      if(this.field1950 != 1) {
         this.field1950 = 1;
         super.modelHeight = 0;
         this.field1951 = 0;
         this.field1952 = 0;

         for(int var1 = 0; var1 < this.field1927; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1951) {
               this.field1951 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1952) {
               this.field1952 = var5;
            }
         }

         this.field1952 = (int)(Math.sqrt((double)this.field1952) + 0.99D);
         this.field1954 = (int)(Math.sqrt((double)(this.field1952 * this.field1952 + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1953 = this.field1954 + (int)(Math.sqrt((double)(this.field1952 * this.field1952 + this.field1951 * this.field1951)) + 0.99D);
      }

   }

   @ObfuscatedName("c")
   void method2398() {
      if(this.field1950 != 2) {
         this.field1950 = 2;
         this.field1952 = 0;

         for(int var1 = 0; var1 < this.field1927; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1952) {
               this.field1952 = var5;
            }
         }

         this.field1952 = (int)(Math.sqrt((double)this.field1952) + 0.99D);
         this.field1954 = this.field1952;
         this.field1953 = this.field1952 + this.field1952;
      }

   }

   @ObfuscatedName("o")
   public int method2399() {
      this.method2397();
      return this.field1952;
   }

   @ObfuscatedName("q")
   void method2400() {
      this.field1950 = 0;
      this.field1958 = -1;
   }

   @ObfuscatedName("n")
   public void method2401(Frames var1, int var2) {
      if(this.field1947 != null && var2 != -1) {
         Frame var3 = var1.field2151[var2];
         FrameMap var4 = var3.field1890;
         field1981 = 0;
         field1982 = 0;
         field1983 = 0;

         for(int var5 = 0; var5 < var3.field1891; ++var5) {
            int var6 = var3.field1894[var5];
            this.method2403(var4.field2050[var6], var4.field2052[var6], var3.translator_x[var5], var3.translator_y[var5], var3.translator_z[var5]);
         }

         this.method2400();
      }

   }

   @ObfuscatedName("s")
   void method2403(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var1 == 0) {
         var7 = 0;
         field1981 = 0;
         field1982 = 0;
         field1983 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var11 = var2[var8];
            if(var11 < this.field1947.length) {
               int[] var12 = this.field1947[var11];

               for(var9 = 0; var9 < var12.length; ++var9) {
                  var10 = var12[var9];
                  field1981 += this.verticesX[var10];
                  field1982 += this.verticesY[var10];
                  field1983 += this.verticesZ[var10];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1981 = field1981 / var7 + var3;
            field1982 = field1982 / var7 + var4;
            field1983 = field1983 / var7 + var5;
         } else {
            field1981 = var3;
            field1982 = var4;
            field1983 = var5;
         }
      } else {
         int[] var18;
         int var19;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1947.length) {
                  var18 = this.field1947[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var9 = var18[var19];
                     this.verticesX[var9] += var3;
                     this.verticesY[var9] += var4;
                     this.verticesZ[var9] += var5;
                  }
               }
            }
         } else if(var1 == 2) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1947.length) {
                  var18 = this.field1947[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var9 = var18[var19];
                     this.verticesX[var9] -= field1981;
                     this.verticesY[var9] -= field1982;
                     this.verticesZ[var9] -= field1983;
                     var10 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1987[var14];
                        var16 = field1967[var14];
                        var17 = this.verticesY[var9] * var15 + this.verticesX[var9] * var16 >> 16;
                        this.verticesY[var9] = this.verticesY[var9] * var16 - this.verticesX[var9] * var15 >> 16;
                        this.verticesX[var9] = var17;
                     }

                     if(var10 != 0) {
                        var15 = field1987[var10];
                        var16 = field1967[var10];
                        var17 = this.verticesY[var9] * var16 - this.verticesZ[var9] * var15 >> 16;
                        this.verticesZ[var9] = this.verticesY[var9] * var15 + this.verticesZ[var9] * var16 >> 16;
                        this.verticesY[var9] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1987[var13];
                        var16 = field1967[var13];
                        var17 = this.verticesZ[var9] * var15 + this.verticesX[var9] * var16 >> 16;
                        this.verticesZ[var9] = this.verticesZ[var9] * var16 - this.verticesX[var9] * var15 >> 16;
                        this.verticesX[var9] = var17;
                     }

                     this.verticesX[var9] += field1981;
                     this.verticesY[var9] += field1982;
                     this.verticesZ[var9] += field1983;
                  }
               }
            }
         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1947.length) {
                  var18 = this.field1947[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var9 = var18[var19];
                     this.verticesX[var9] -= field1981;
                     this.verticesY[var9] -= field1982;
                     this.verticesZ[var9] -= field1983;
                     this.verticesX[var9] = this.verticesX[var9] * var3 / 128;
                     this.verticesY[var9] = this.verticesY[var9] * var4 / 128;
                     this.verticesZ[var9] = this.verticesZ[var9] * var5 / 128;
                     this.verticesX[var9] += field1981;
                     this.verticesY[var9] += field1982;
                     this.verticesZ[var9] += field1983;
                  }
               }
            }
         } else if(var1 == 5 && this.field1976 != null && this.field1939 != null) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1976.length) {
                  var18 = this.field1976[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var9 = var18[var19];
                     var10 = (this.field1939[var9] & 255) + var3 * 8;
                     if(var10 < 0) {
                        var10 = 0;
                     } else if(var10 > 255) {
                        var10 = 255;
                     }

                     this.field1939[var9] = (byte)var10;
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("r")
   public void method2405() {
      for(int var1 = 0; var1 < this.field1927; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.method2400();
   }

   @ObfuscatedName("v")
   public void method2406(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.field2151[var2];
            Frame var7 = var3.field2151[var4];
            FrameMap var8 = var6.field1890;
            field1981 = 0;
            field1982 = 0;
            field1983 = 0;
            byte var9 = 0;
            int var10 = var9 + 1;
            int var11 = var5[var9];

            int var12;
            int var13;
            for(var12 = 0; var12 < var6.field1891; ++var12) {
               for(var13 = var6.field1894[var12]; var13 > var11; var11 = var5[var10++]) {
                  ;
               }

               if(var13 != var11 || var8.field2050[var13] == 0) {
                  this.method2403(var8.field2050[var13], var8.field2052[var13], var6.translator_x[var12], var6.translator_y[var12], var6.translator_z[var12]);
               }
            }

            field1981 = 0;
            field1982 = 0;
            field1983 = 0;
            var9 = 0;
            var10 = var9 + 1;
            var11 = var5[var9];

            for(var12 = 0; var12 < var7.field1891; ++var12) {
               for(var13 = var7.field1894[var12]; var13 > var11; var11 = var5[var10++]) {
                  ;
               }

               if(var13 == var11 || var8.field2050[var13] == 0) {
                  this.method2403(var8.field2050[var13], var8.field2052[var13], var7.translator_x[var12], var7.translator_y[var12], var7.translator_z[var12]);
               }
            }

            this.method2400();
         } else {
            this.method2401(var1, var2);
         }
      }

   }

   @ObfuscatedName("d")
   public void method2407(int var1) {
      int var2 = field1987[var1];
      int var3 = field1967[var1];

      for(int var4 = 0; var4 < this.field1927; ++var4) {
         int var5 = this.verticesY[var4] * var3 - this.verticesZ[var4] * var2 >> 16;
         this.verticesZ[var4] = this.verticesY[var4] * var2 + this.verticesZ[var4] * var3 >> 16;
         this.verticesY[var4] = var5;
      }

      this.method2400();
   }

   @ObfuscatedName("x")
   public void method2408(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1927; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.method2400();
   }

   @ObfuscatedName("b")
   public void method2409(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1927; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = this.verticesY[var4] * var2 / 128;
         this.verticesZ[var4] = this.verticesZ[var4] * var3 / 128;
      }

      this.method2400();
   }

   @ObfuscatedName("u")
   public final void method2411(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1971[0] = -1;
      if(this.field1950 != 2 && this.field1950 != 1) {
         this.method2398();
      }

      int var9 = class136.field2025;
      int var10 = class136.field2026;
      int var10000 = field1987[var1];
      var10000 = field1967[var1];
      int var12 = field1987[var2];
      int var13 = field1967[var2];
      int var14 = field1987[var3];
      int var15 = field1967[var3];
      int var16 = field1987[var4];
      int var17 = field1967[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1927; ++var19) {
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
         field1966[var19] = var22 - var18;
         field1931[var19] = var9 + var20 * class136.field2024 / var8;
         field1937[var19] = var10 + var23 * class136.field2024 / var8;
         if(this.field1960 > 0) {
            field1942[var19] = var20;
            field1968[var19] = var23;
            field1969[var19] = var22;
         }
      }

      try {
         this.method2413(false, false, false, 0);
      } catch (Exception var24) {
         ;
      }

   }

   @ObfuscatedName("bj")
   void vmethod2753(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1971[0] = -1;
      if(this.field1950 != 1) {
         this.method2397();
      }

      this.method2396(var1);
      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1952 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1952) * class136.field2024;
         if(var15 / var13 < class136.field2030) {
            int var16 = (var14 + this.field1952) * class136.field2024;
            if(var16 / var13 > class136.field2029) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1952 * var2 >> 16;
               int var19 = (var17 + var18) * class136.field2024;
               if(var19 / var13 > class136.field2027) {
                  int var20 = var18 + (super.modelHeight * var3 >> 16);
                  int var21 = (var17 - var20) * class136.field2024;
                  if(var21 / var13 < class136.field2032) {
                     int var22 = var12 + (super.modelHeight * var2 >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1960 > 0;
                     int var26 = class134.field1994;
                     int var27 = class134.field1995;
                     boolean var28 = ObjectComposition.method4411();
                     if(class7.field238 && var9 > 0) {
                        if(class234.method3991(this, var6, var7, var8)) {
                           class7.field237.method3441(new class10(this, var6, var7, var8, -65281));
                        } else if(class7.field233 == class11.field270) {
                           class7.field237.method3441(new class10(this, var6, var7, var8, -16776961));
                        }
                     }

                     int var29;
                     int var30;
                     int var31;
                     int var32;
                     int var33;
                     int var34;
                     int var35;
                     if(class7.field234 && var9 > 0) {
                        int var36 = var11 - var12;
                        if(var36 <= 50) {
                           var36 = 50;
                        }

                        if(var14 > 0) {
                           var29 = var15 / var13;
                           var30 = var16 / var36;
                        } else {
                           var30 = var16 / var13;
                           var29 = var15 / var36;
                        }

                        if(var17 > 0) {
                           var31 = var21 / var13;
                           var32 = var19 / var36;
                        } else {
                           var32 = var19 / var13;
                           var31 = var21 / var36;
                        }

                        var33 = -8355840;
                        var34 = var26 - class136.field2025;
                        var35 = var27 - class136.field2026;
                        if(var34 > var29 && var34 < var30 && var35 > var31 && var35 < var32) {
                           var33 = -256;
                        }

                        class266.method4731(var29 + class136.field2025, var31 + class136.field2026, var30 + class136.field2025, var32 + class136.field2026, var33);
                     }

                     boolean var40 = false;
                     if(var9 > 0 && var28) {
                        boolean var37 = false;
                        if(field1925) {
                           var37 = class234.method3991(this, var6, var7, var8);
                        } else {
                           var30 = var11 - var12;
                           if(var30 <= 50) {
                              var30 = 50;
                           }

                           if(var14 > 0) {
                              var15 /= var13;
                              var16 /= var30;
                           } else {
                              var16 /= var13;
                              var15 /= var30;
                           }

                           if(var17 > 0) {
                              var21 /= var13;
                              var19 /= var30;
                           } else {
                              var19 /= var13;
                              var21 /= var30;
                           }

                           var31 = var26 - class136.field2025;
                           var32 = var27 - class136.field2026;
                           if(var31 > var15 && var31 < var16 && var32 > var21 && var32 < var19) {
                              var37 = true;
                           }
                        }

                        if(var37) {
                           if(this.field1949) {
                              FileOnDisk.method2278(var9);
                           } else {
                              var40 = true;
                           }
                        }
                     }

                     var29 = class136.field2025;
                     var30 = class136.field2026;
                     var31 = 0;
                     var32 = 0;
                     if(var1 != 0) {
                        var31 = field1987[var1];
                        var32 = field1967[var1];
                     }

                     for(var33 = 0; var33 < this.field1927; ++var33) {
                        var34 = this.verticesX[var33];
                        var35 = this.verticesY[var33];
                        int var41 = this.verticesZ[var33];
                        int var38;
                        if(var1 != 0) {
                           var38 = var41 * var31 + var34 * var32 >> 16;
                           var41 = var41 * var32 - var34 * var31 >> 16;
                           var34 = var38;
                        }

                        var34 += var6;
                        var35 += var7;
                        var41 += var8;
                        var38 = var41 * var4 + var34 * var5 >> 16;
                        var41 = var41 * var5 - var34 * var4 >> 16;
                        var34 = var38;
                        var38 = var35 * var3 - var41 * var2 >> 16;
                        var41 = var35 * var2 + var41 * var3 >> 16;
                        field1966[var33] = var41 - var11;
                        if(var41 >= 50) {
                           field1931[var33] = var29 + var34 * class136.field2024 / var41;
                           field1937[var33] = var30 + var38 * class136.field2024 / var41;
                        } else {
                           field1931[var33] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1942[var33] = var34;
                           field1968[var33] = var38;
                           field1969[var33] = var41;
                        }
                     }

                     try {
                        this.method2413(var23, var40, this.field1949, var9);
                     } catch (Exception var39) {
                        ;
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("av")
   final void method2413(boolean var1, boolean var2, boolean var3, int var4) {
      if(this.field1953 < 1600) {
         int var5;
         for(var5 = 0; var5 < this.field1953; ++var5) {
            field1971[var5] = 0;
         }

         var5 = var3?20:5;
         if(class7.field235 && var2) {
            class51.method731(this, var5);
         }

         int var6;
         int var7;
         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         int var13;
         int var14;
         int var15;
         for(var6 = 0; var6 < this.field1930; ++var6) {
            if(this.field1964[var6] != -2) {
               var7 = this.indices1[var6];
               var8 = this.indices2[var6];
               var9 = this.indices3[var6];
               var10 = field1931[var7];
               var11 = field1931[var8];
               var12 = field1931[var9];
               int var16;
               if(var1 && (var10 == -5000 || var11 == -5000 || var12 == -5000)) {
                  var16 = field1942[var7];
                  var13 = field1942[var8];
                  var14 = field1942[var9];
                  int var17 = field1968[var7];
                  var15 = field1968[var8];
                  int var18 = field1968[var9];
                  int var19 = field1969[var7];
                  int var20 = field1969[var8];
                  int var21 = field1969[var9];
                  var16 -= var13;
                  var14 -= var13;
                  var17 -= var15;
                  var18 -= var15;
                  var19 -= var20;
                  var21 -= var20;
                  int var22 = var17 * var21 - var19 * var18;
                  int var23 = var19 * var14 - var16 * var21;
                  int var24 = var16 * var18 - var17 * var14;
                  if(var13 * var22 + var15 * var23 + var20 * var24 > 0) {
                     field1963[var6] = true;
                     int var25 = (field1966[var7] + field1966[var8] + field1966[var9]) / 3 + this.field1954;
                     field1972[var25][field1971[var25]++] = var6;
                  }
               } else {
                  if(var2 && PendingSpawn.method1434(field1937[var7], field1937[var8], field1937[var9], var10, var11, var12, var5)) {
                     FileOnDisk.method2278(var4);
                     var2 = false;
                  }

                  if((var10 - var11) * (field1937[var9] - field1937[var8]) - (field1937[var7] - field1937[var8]) * (var12 - var11) > 0) {
                     field1963[var6] = false;
                     if(var10 >= 0 && var11 >= 0 && var12 >= 0 && var10 <= class136.rasterClipX && var11 <= class136.rasterClipX && var12 <= class136.rasterClipX) {
                        field1962[var6] = false;
                     } else {
                        field1962[var6] = true;
                     }

                     var16 = (field1966[var7] + field1966[var8] + field1966[var9]) / 3 + this.field1954;
                     field1972[var16][field1971[var16]++] = var6;
                  }
               }
            }
         }

         int[] var26;
         if(this.field1938 == null) {
            for(var6 = this.field1953 - 1; var6 >= 0; --var6) {
               var7 = field1971[var6];
               if(var7 > 0) {
                  var26 = field1972[var6];

                  for(var9 = 0; var9 < var7; ++var9) {
                     this.method2414(var26[var9]);
                  }
               }
            }
         } else {
            for(var6 = 0; var6 < 12; ++var6) {
               field1973[var6] = 0;
               field1989[var6] = 0;
            }

            for(var6 = this.field1953 - 1; var6 >= 0; --var6) {
               var7 = field1971[var6];
               if(var7 > 0) {
                  var26 = field1972[var6];

                  for(var9 = 0; var9 < var7; ++var9) {
                     var10 = var26[var9];
                     byte var27 = this.field1938[var10];
                     var12 = field1973[var27]++;
                     field1943[var27][var12] = var10;
                     if(var27 < 10) {
                        field1989[var27] += var6;
                     } else if(var27 == 10) {
                        field1975[var12] = var6;
                     } else {
                        field1940[var12] = var6;
                     }
                  }
               }
            }

            var6 = 0;
            if(field1973[1] > 0 || field1973[2] > 0) {
               var6 = (field1989[1] + field1989[2]) / (field1973[1] + field1973[2]);
            }

            var7 = 0;
            if(field1973[3] > 0 || field1973[4] > 0) {
               var7 = (field1989[3] + field1989[4]) / (field1973[3] + field1973[4]);
            }

            var8 = 0;
            if(field1973[6] > 0 || field1973[8] > 0) {
               var8 = (field1989[6] + field1989[8]) / (field1973[6] + field1973[8]);
            }

            var10 = 0;
            var11 = field1973[10];
            int[] var28 = field1943[10];
            int[] var29 = field1975;
            if(var10 == var11) {
               var10 = 0;
               var11 = field1973[11];
               var28 = field1943[11];
               var29 = field1940;
            }

            if(var10 < var11) {
               var9 = var29[var10];
            } else {
               var9 = -1000;
            }

            for(var13 = 0; var13 < 10; ++var13) {
               while(var13 == 0 && var9 > var6) {
                  this.method2414(var28[var10++]);
                  if(var10 == var11 && var28 != field1943[11]) {
                     var10 = 0;
                     var11 = field1973[11];
                     var28 = field1943[11];
                     var29 = field1940;
                  }

                  if(var10 < var11) {
                     var9 = var29[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var13 == 3 && var9 > var7) {
                  this.method2414(var28[var10++]);
                  if(var10 == var11 && var28 != field1943[11]) {
                     var10 = 0;
                     var11 = field1973[11];
                     var28 = field1943[11];
                     var29 = field1940;
                  }

                  if(var10 < var11) {
                     var9 = var29[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var13 == 5 && var9 > var8) {
                  this.method2414(var28[var10++]);
                  if(var10 == var11 && var28 != field1943[11]) {
                     var10 = 0;
                     var11 = field1973[11];
                     var28 = field1943[11];
                     var29 = field1940;
                  }

                  if(var10 < var11) {
                     var9 = var29[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               var14 = field1973[var13];
               int[] var30 = field1943[var13];

               for(var15 = 0; var15 < var14; ++var15) {
                  this.method2414(var30[var15]);
               }
            }

            while(var9 != -1000) {
               this.method2414(var28[var10++]);
               if(var10 == var11 && var28 != field1943[11]) {
                  var10 = 0;
                  var28 = field1943[11];
                  var11 = field1973[11];
                  var29 = field1940;
               }

               if(var10 < var11) {
                  var9 = var29[var10];
               } else {
                  var9 = -1000;
               }
            }
         }
      }

   }

   @ObfuscatedName("ax")
   final void method2414(int var1) {
      if(field1963[var1]) {
         this.method2456(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         class136.rasterClipEnable = field1962[var1];
         if(this.field1939 == null) {
            class136.rasterAlpha = 0;
         } else {
            class136.rasterAlpha = this.field1939[var1] & 255;
         }

         if(this.field1941 != null && this.field1941[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1974 != null && this.field1974[var1] != -1) {
               int var8 = this.field1974[var1] & 255;
               var5 = this.field1926[var8];
               var6 = this.field1945[var8];
               var7 = this.field1946[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1964[var1] == -1) {
               class136.rasterTextureAffine(field1937[var2], field1937[var3], field1937[var4], field1931[var2], field1931[var3], field1931[var4], this.field1935[var1], this.field1935[var1], this.field1935[var1], field1942[var5], field1942[var6], field1942[var7], field1968[var5], field1968[var6], field1968[var7], field1969[var5], field1969[var6], field1969[var7], this.field1941[var1]);
            } else {
               class136.rasterTextureAffine(field1937[var2], field1937[var3], field1937[var4], field1931[var2], field1931[var3], field1931[var4], this.field1935[var1], this.field1936[var1], this.field1964[var1], field1942[var5], field1942[var6], field1942[var7], field1968[var5], field1968[var6], field1968[var7], field1969[var5], field1969[var6], field1969[var7], this.field1941[var1]);
            }
         } else if(this.field1964[var1] == -1) {
            class136.rasterFlat(field1937[var2], field1937[var3], field1937[var4], field1931[var2], field1931[var3], field1931[var4], field1944[this.field1935[var1]]);
         } else {
            class136.rasterGouraud(field1937[var2], field1937[var3], field1937[var4], field1931[var2], field1931[var3], field1931[var4], this.field1935[var1], this.field1936[var1], this.field1964[var1]);
         }
      }

   }

   @ObfuscatedName("k")
   public void method2427() {
      for(int var1 = 0; var1 < this.field1927; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.method2400();
   }

   @ObfuscatedName("l")
   public void method2438() {
      for(int var1 = 0; var1 < this.field1927; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.method2400();
   }

   @ObfuscatedName("y")
   public final void method2440(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1971[0] = -1;
      if(this.field1950 != 2 && this.field1950 != 1) {
         this.method2398();
      }

      int var8 = class136.field2025;
      int var9 = class136.field2026;
      int var10000 = field1987[var1];
      var10000 = field1967[var1];
      int var11 = field1987[var2];
      int var12 = field1967[var2];
      int var13 = field1987[var3];
      int var14 = field1967[var3];
      int var15 = field1987[var4];
      int var16 = field1967[var4];
      int var17 = var6 * var15 + var7 * var16 >> 16;

      for(int var18 = 0; var18 < this.field1927; ++var18) {
         int var19 = this.verticesX[var18];
         int var20 = this.verticesY[var18];
         int var21 = this.verticesZ[var18];
         int var22;
         if(var3 != 0) {
            var22 = var20 * var13 + var19 * var14 >> 16;
            var20 = var20 * var14 - var19 * var13 >> 16;
            var19 = var22;
         }

         if(var2 != 0) {
            var22 = var21 * var11 + var19 * var12 >> 16;
            var21 = var21 * var12 - var19 * var11 >> 16;
            var19 = var22;
         }

         var19 += var5;
         var20 += var6;
         var21 += var7;
         var22 = var20 * var16 - var21 * var15 >> 16;
         var21 = var20 * var15 + var21 * var16 >> 16;
         field1966[var18] = var21 - var17;
         field1931[var18] = var8 + var19 * class136.field2024 / var21;
         field1937[var18] = var9 + var22 * class136.field2024 / var21;
         if(this.field1960 > 0) {
            field1942[var18] = var19;
            field1968[var18] = var22;
            field1969[var18] = var21;
         }
      }

      try {
         this.method2413(false, false, false, 0);
      } catch (Exception var23) {
         ;
      }

   }

   Model() {
      this.field1927 = 0;
      this.field1930 = 0;
      this.field1977 = 0;
      this.field1960 = 0;
      this.field1949 = false;
      this.field1958 = -1;
      this.field1959 = -1;
      this.field1928 = -1;
   }

   @ObfuscatedName("af")
   final void method2456(int var1) {
      int var2 = class136.field2025;
      int var3 = class136.field2026;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1969[var5];
      int var9 = field1969[var6];
      int var10 = field1969[var7];
      if(this.field1939 == null) {
         class136.rasterAlpha = 0;
      } else {
         class136.rasterAlpha = this.field1939[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1948[var4] = field1931[var5];
         field1979[var4] = field1937[var5];
         field1978[var4++] = this.field1935[var1];
      } else {
         var11 = field1942[var5];
         var12 = field1968[var5];
         var13 = this.field1935[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1990[var10 - var8];
            field1948[var4] = var2 + (var11 + ((field1942[var7] - var11) * var14 >> 16)) * class136.field2024 / 50;
            field1979[var4] = var3 + (var12 + ((field1968[var7] - var12) * var14 >> 16)) * class136.field2024 / 50;
            field1978[var4++] = var13 + ((this.field1964[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1990[var9 - var8];
            field1948[var4] = var2 + (var11 + ((field1942[var6] - var11) * var14 >> 16)) * class136.field2024 / 50;
            field1979[var4] = var3 + (var12 + ((field1968[var6] - var12) * var14 >> 16)) * class136.field2024 / 50;
            field1978[var4++] = var13 + ((this.field1936[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1948[var4] = field1931[var6];
         field1979[var4] = field1937[var6];
         field1978[var4++] = this.field1936[var1];
      } else {
         var11 = field1942[var6];
         var12 = field1968[var6];
         var13 = this.field1936[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1990[var8 - var9];
            field1948[var4] = var2 + (var11 + ((field1942[var5] - var11) * var14 >> 16)) * class136.field2024 / 50;
            field1979[var4] = var3 + (var12 + ((field1968[var5] - var12) * var14 >> 16)) * class136.field2024 / 50;
            field1978[var4++] = var13 + ((this.field1935[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1990[var10 - var9];
            field1948[var4] = var2 + (var11 + ((field1942[var7] - var11) * var14 >> 16)) * class136.field2024 / 50;
            field1979[var4] = var3 + (var12 + ((field1968[var7] - var12) * var14 >> 16)) * class136.field2024 / 50;
            field1978[var4++] = var13 + ((this.field1964[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1948[var4] = field1931[var7];
         field1979[var4] = field1937[var7];
         field1978[var4++] = this.field1964[var1];
      } else {
         var11 = field1942[var7];
         var12 = field1968[var7];
         var13 = this.field1964[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1990[var9 - var10];
            field1948[var4] = var2 + (var11 + ((field1942[var6] - var11) * var14 >> 16)) * class136.field2024 / 50;
            field1979[var4] = var3 + (var12 + ((field1968[var6] - var12) * var14 >> 16)) * class136.field2024 / 50;
            field1978[var4++] = var13 + ((this.field1936[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1990[var8 - var10];
            field1948[var4] = var2 + (var11 + ((field1942[var5] - var11) * var14 >> 16)) * class136.field2024 / 50;
            field1979[var4] = var3 + (var12 + ((field1968[var5] - var12) * var14 >> 16)) * class136.field2024 / 50;
            field1978[var4++] = var13 + ((this.field1935[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1948[0];
      var12 = field1948[1];
      var13 = field1948[2];
      var14 = field1979[0];
      int var15 = field1979[1];
      int var16 = field1979[2];
      class136.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class136.rasterClipX || var12 > class136.rasterClipX || var13 > class136.rasterClipX) {
            class136.rasterClipEnable = true;
         }

         if(this.field1941 != null && this.field1941[var1] != -1) {
            if(this.field1974 != null && this.field1974[var1] != -1) {
               var20 = this.field1974[var1] & 255;
               var17 = this.field1926[var20];
               var18 = this.field1945[var20];
               var19 = this.field1946[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1964[var1] == -1) {
               class136.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1935[var1], this.field1935[var1], this.field1935[var1], field1942[var17], field1942[var18], field1942[var19], field1968[var17], field1968[var18], field1968[var19], field1969[var17], field1969[var18], field1969[var19], this.field1941[var1]);
            } else {
               class136.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1978[0], field1978[1], field1978[2], field1942[var17], field1942[var18], field1942[var19], field1968[var17], field1968[var18], field1968[var19], field1969[var17], field1969[var18], field1969[var19], this.field1941[var1]);
            }
         } else if(this.field1964[var1] == -1) {
            class136.rasterFlat(var14, var15, var16, var11, var12, var13, field1944[this.field1935[var1]]);
         } else {
            class136.rasterGouraud(var14, var15, var16, var11, var12, var13, field1978[0], field1978[1], field1978[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class136.rasterClipX || var12 > class136.rasterClipX || var13 > class136.rasterClipX || field1948[3] < 0 || field1948[3] > class136.rasterClipX) {
            class136.rasterClipEnable = true;
         }

         if(this.field1941 != null && this.field1941[var1] != -1) {
            if(this.field1974 != null && this.field1974[var1] != -1) {
               var20 = this.field1974[var1] & 255;
               var17 = this.field1926[var20];
               var18 = this.field1945[var20];
               var19 = this.field1946[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1941[var1];
            if(this.field1964[var1] == -1) {
               class136.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1935[var1], this.field1935[var1], this.field1935[var1], field1942[var17], field1942[var18], field1942[var19], field1968[var17], field1968[var18], field1968[var19], field1969[var17], field1969[var18], field1969[var19], var21);
               class136.rasterTextureAffine(var14, var16, field1979[3], var11, var13, field1948[3], this.field1935[var1], this.field1935[var1], this.field1935[var1], field1942[var17], field1942[var18], field1942[var19], field1968[var17], field1968[var18], field1968[var19], field1969[var17], field1969[var18], field1969[var19], var21);
            } else {
               class136.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1978[0], field1978[1], field1978[2], field1942[var17], field1942[var18], field1942[var19], field1968[var17], field1968[var18], field1968[var19], field1969[var17], field1969[var18], field1969[var19], var21);
               class136.rasterTextureAffine(var14, var16, field1979[3], var11, var13, field1948[3], field1978[0], field1978[2], field1978[3], field1942[var17], field1942[var18], field1942[var19], field1968[var17], field1968[var18], field1968[var19], field1969[var17], field1969[var18], field1969[var19], var21);
            }
         } else if(this.field1964[var1] == -1) {
            var17 = field1944[this.field1935[var1]];
            class136.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            class136.rasterFlat(var14, var16, field1979[3], var11, var13, field1948[3], var17);
         } else {
            class136.rasterGouraud(var14, var15, var16, var11, var12, var13, field1978[0], field1978[1], field1978[2]);
            class136.rasterGouraud(var14, var16, field1979[3], var11, var13, field1948[3], field1978[0], field1978[2], field1978[3]);
         }
      }

   }

   static {
      field1984 = new Model();
      field1924 = new byte[1];
      field1988 = new Model();
      field1965 = new byte[1];
      field1962 = new boolean[4700];
      field1963 = new boolean[4700];
      field1931 = new int[4700];
      field1937 = new int[4700];
      field1966 = new int[4700];
      field1942 = new int[4700];
      field1968 = new int[4700];
      field1969 = new int[4700];
      field1971 = new int[1600];
      field1972 = new int[1600][512];
      field1973 = new int[12];
      field1943 = new int[12][2000];
      field1975 = new int[2000];
      field1940 = new int[2000];
      field1989 = new int[12];
      field1948 = new int[10];
      field1979 = new int[10];
      field1978 = new int[10];
      field1925 = true;
      field1987 = class136.SINE;
      field1967 = class136.COSINE;
      field1944 = class136.colorPalette;
      field1990 = class136.field2037;
   }
}
