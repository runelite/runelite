import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ed")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("aw")
   public int field1937;
   @ObfuscatedName("c")
   static byte[] field1938;
   @ObfuscatedName("e")
   static Model field1939;
   @ObfuscatedName("bl")
   static int field1940;
   @ObfuscatedName("b")
   int field1941;
   @ObfuscatedName("y")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("ao")
   static int[] field1943;
   @ObfuscatedName("u")
   int[][] field1944;
   @ObfuscatedName("f")
   public int field1945;
   @ObfuscatedName("n")
   @Export("indices1")
   public int[] indices1;
   @ObfuscatedName("a")
   @Export("indices2")
   public int[] indices2;
   @ObfuscatedName("o")
   @Export("indices3")
   public int[] indices3;
   @ObfuscatedName("z")
   int[] field1949;
   @ObfuscatedName("bi")
   static int[] field1950;
   @ObfuscatedName("j")
   public int[] field1951;
   @ObfuscatedName("k")
   byte[] field1952;
   @ObfuscatedName("ak")
   static int[][] field1953;
   @ObfuscatedName("m")
   byte[] field1954;
   @ObfuscatedName("d")
   short[] field1955;
   @ObfuscatedName("s")
   byte field1956;
   @ObfuscatedName("g")
   int field1957;
   @ObfuscatedName("w")
   int[] field1958;
   @ObfuscatedName("p")
   int[] field1959;
   @ObfuscatedName("ay")
   static int[] field1960;
   @ObfuscatedName("i")
   static Model field1961;
   @ObfuscatedName("t")
   int[][] field1962;
   @ObfuscatedName("l")
   int[] field1963;
   @ObfuscatedName("v")
   static byte[] field1964;
   @ObfuscatedName("by")
   static int[] field1965;
   @ObfuscatedName("af")
   int field1966;
   @ObfuscatedName("at")
   int field1967;
   @ObfuscatedName("ai")
   public int field1969;
   @ObfuscatedName("ac")
   static int[] field1970;
   @ObfuscatedName("au")
   static int[] field1971;
   @ObfuscatedName("ab")
   public int field1972;
   @ObfuscatedName("aa")
   public int field1973;
   @ObfuscatedName("q")
   int[] field1974;
   @ObfuscatedName("av")
   static boolean[] field1975;
   @ObfuscatedName("as")
   static boolean[] field1976;
   @ObfuscatedName("h")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("ag")
   public static int[] field1978;
   @ObfuscatedName("az")
   public static int[] field1979;
   @ObfuscatedName("al")
   public int field1980;
   @ObfuscatedName("ap")
   public int field1981;
   @ObfuscatedName("ah")
   int field1982;
   @ObfuscatedName("aj")
   static int[] field1983;
   @ObfuscatedName("ax")
   static int[] field1985;
   @ObfuscatedName("bo")
   static int[] field1986;
   @ObfuscatedName("ad")
   public boolean field1987;
   @ObfuscatedName("am")
   static int[][] field1988;
   @ObfuscatedName("be")
   static int[] field1989;
   @ObfuscatedName("bs")
   static int[] field1990;
   @ObfuscatedName("bu")
   static int[] field1991;
   @ObfuscatedName("bj")
   static int[] field1993;
   @ObfuscatedName("bh")
   static int[] field1994;
   @ObfuscatedName("bf")
   static int field1995;
   @ObfuscatedName("bg")
   static int field1996;
   @ObfuscatedName("x")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("bz")
   public static boolean field1998;
   @ObfuscatedName("ar")
   int field2001;
   @ObfuscatedName("r")
   byte[] field2002;
   @ObfuscatedName("bb")
   static int[] field2003;
   @ObfuscatedName("ba")
   static int[] field2004;
   @ObfuscatedName("an")
   int field2006;

   Model() {
      this.field1941 = 0;
      this.field1945 = 0;
      this.field1956 = 0;
      this.field1957 = 0;
      this.field1987 = false;
      this.field1972 = -1;
      this.field1973 = -1;
      this.field1981 = -1;
   }

   @ObfuscatedName("u")
   public void method2490() {
      for(int var1 = 0; var1 < this.field1941; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.method2500();
   }

   @ObfuscatedName("o")
   public void method2493(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.field2163[var2];
            Frame var7 = var3.field2163[var4];
            FrameMap var8 = var6.field1907;
            field1995 = 0;
            field1996 = 0;
            field1940 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1906; ++var11) {
               for(var12 = var6.field1909[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field2069[var12] == 0) {
                  this.method2501(var8.field2069[var12], var8.field2070[var12], var6.translator_x[var11], var6.translator_y[var11], var6.translator_z[var11]);
               }
            }

            field1995 = 0;
            field1996 = 0;
            field1940 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1906; ++var11) {
               for(var12 = var7.field1909[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field2069[var12] == 0) {
                  this.method2501(var8.field2069[var12], var8.field2070[var12], var7.translator_x[var11], var7.translator_y[var11], var7.translator_z[var11]);
               }
            }

            this.method2500();
         } else {
            this.method2499(var1, var2);
         }
      }
   }

   @ObfuscatedName("b")
   Model method2494(boolean var1, Model var2, byte[] var3) {
      var2.field1941 = this.field1941;
      var2.field1945 = this.field1945;
      var2.field1957 = this.field1957;
      if(var2.verticesX == null || var2.verticesX.length < this.field1941) {
         var2.verticesX = new int[this.field1941 + 100];
         var2.verticesY = new int[this.field1941 + 100];
         var2.verticesZ = new int[this.field1941 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1941; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if(var1) {
         var2.field2002 = this.field2002;
      } else {
         var2.field2002 = var3;
         if(this.field2002 == null) {
            for(var4 = 0; var4 < this.field1945; ++var4) {
               var2.field2002[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1945; ++var4) {
               var2.field2002[var4] = this.field2002[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1949 = this.field1949;
      var2.field1974 = this.field1974;
      var2.field1951 = this.field1951;
      var2.field1952 = this.field1952;
      var2.field1954 = this.field1954;
      var2.field1955 = this.field1955;
      var2.field1956 = this.field1956;
      var2.field1958 = this.field1958;
      var2.field1959 = this.field1959;
      var2.field1963 = this.field1963;
      var2.field1944 = this.field1944;
      var2.field1962 = this.field1962;
      var2.field1987 = this.field1987;
      var2.method2500();
      return var2;
   }

   @ObfuscatedName("y")
   void method2495(int var1) {
      if(this.field1972 == -1) {
         int var2 = 0;
         int var3 = 0;
         int var4 = 0;
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         int var8 = field1965[var1];
         int var9 = field1950[var1];

         for(int var10 = 0; var10 < this.field1941; ++var10) {
            int var11 = class136.method2608(this.verticesX[var10], this.verticesZ[var10], var8, var9);
            int var12 = this.verticesY[var10];
            int var13 = class136.method2609(this.verticesX[var10], this.verticesZ[var10], var8, var9);
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

         this.field1969 = (var5 + var2) / 2;
         this.field1937 = (var6 + var3) / 2;
         this.field1980 = (var7 + var4) / 2;
         this.field1972 = (var5 - var2 + 1) / 2;
         this.field1973 = (var6 - var3 + 1) / 2;
         this.field1981 = (var7 - var4 + 1) / 2;
         if(this.field1972 < 32) {
            this.field1972 = 32;
         }

         if(this.field1981 < 32) {
            this.field1981 = 32;
         }

         if(this.field1987) {
            this.field1972 += 16;
            this.field1981 += 16;
         }

      }
   }

   @ObfuscatedName("h")
   public void method2496() {
      if(this.field2001 != 1) {
         this.field2001 = 1;
         super.modelHeight = 0;
         this.field2006 = 0;
         this.field1966 = 0;

         for(int var1 = 0; var1 < this.field1941; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field2006) {
               this.field2006 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1966) {
               this.field1966 = var5;
            }
         }

         this.field1966 = (int)(Math.sqrt((double)this.field1966) + 0.99D);
         this.field1982 = (int)(Math.sqrt((double)(this.field1966 * this.field1966 + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1967 = this.field1982 + (int)(Math.sqrt((double)(this.field1966 * this.field1966 + this.field2006 * this.field2006)) + 0.99D);
      }
   }

   @ObfuscatedName("x")
   void method2497() {
      if(this.field2001 != 2) {
         this.field2001 = 2;
         this.field1966 = 0;

         for(int var1 = 0; var1 < this.field1941; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1966) {
               this.field1966 = var5;
            }
         }

         this.field1966 = (int)(Math.sqrt((double)this.field1966) + 0.99D);
         this.field1982 = this.field1966;
         this.field1967 = this.field1966 + this.field1966;
      }
   }

   @ObfuscatedName("f")
   public int method2498() {
      this.method2496();
      return this.field1966;
   }

   public Model(Model[] var1, int var2) {
      this.field1941 = 0;
      this.field1945 = 0;
      this.field1956 = 0;
      this.field1957 = 0;
      this.field1987 = false;
      this.field1972 = -1;
      this.field1973 = -1;
      this.field1981 = -1;
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1941 = 0;
      this.field1945 = 0;
      this.field1957 = 0;
      this.field1956 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1941 += var8.field1941;
            this.field1945 += var8.field1945;
            this.field1957 += var8.field1957;
            if(var8.field1952 != null) {
               var3 = true;
            } else {
               if(this.field1956 == -1) {
                  this.field1956 = var8.field1956;
               }

               if(this.field1956 != var8.field1956) {
                  var3 = true;
               }
            }

            var4 |= var8.field2002 != null;
            var5 |= var8.field1955 != null;
            var6 |= var8.field1954 != null;
         }
      }

      this.verticesX = new int[this.field1941];
      this.verticesY = new int[this.field1941];
      this.verticesZ = new int[this.field1941];
      this.indices1 = new int[this.field1945];
      this.indices2 = new int[this.field1945];
      this.indices3 = new int[this.field1945];
      this.field1949 = new int[this.field1945];
      this.field1974 = new int[this.field1945];
      this.field1951 = new int[this.field1945];
      if(var3) {
         this.field1952 = new byte[this.field1945];
      }

      if(var4) {
         this.field2002 = new byte[this.field1945];
      }

      if(var5) {
         this.field1955 = new short[this.field1945];
      }

      if(var6) {
         this.field1954 = new byte[this.field1945];
      }

      if(this.field1957 > 0) {
         this.field1958 = new int[this.field1957];
         this.field1959 = new int[this.field1957];
         this.field1963 = new int[this.field1957];
      }

      this.field1941 = 0;
      this.field1945 = 0;
      this.field1957 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1945; ++var9) {
               this.indices1[this.field1945] = var8.indices1[var9] + this.field1941;
               this.indices2[this.field1945] = var8.indices2[var9] + this.field1941;
               this.indices3[this.field1945] = var8.indices3[var9] + this.field1941;
               this.field1949[this.field1945] = var8.field1949[var9];
               this.field1974[this.field1945] = var8.field1974[var9];
               this.field1951[this.field1945] = var8.field1951[var9];
               if(var3) {
                  if(var8.field1952 != null) {
                     this.field1952[this.field1945] = var8.field1952[var9];
                  } else {
                     this.field1952[this.field1945] = var8.field1956;
                  }
               }

               if(var4 && var8.field2002 != null) {
                  this.field2002[this.field1945] = var8.field2002[var9];
               }

               if(var5) {
                  if(var8.field1955 != null) {
                     this.field1955[this.field1945] = var8.field1955[var9];
                  } else {
                     this.field1955[this.field1945] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1954 != null && var8.field1954[var9] != -1) {
                     this.field1954[this.field1945] = (byte)(var8.field1954[var9] + this.field1957);
                  } else {
                     this.field1954[this.field1945] = -1;
                  }
               }

               ++this.field1945;
            }

            for(var9 = 0; var9 < var8.field1957; ++var9) {
               this.field1958[this.field1957] = var8.field1958[var9] + this.field1941;
               this.field1959[this.field1957] = var8.field1959[var9] + this.field1941;
               this.field1963[this.field1957] = var8.field1963[var9] + this.field1941;
               ++this.field1957;
            }

            for(var9 = 0; var9 < var8.field1941; ++var9) {
               this.verticesX[this.field1941] = var8.verticesX[var9];
               this.verticesY[this.field1941] = var8.verticesY[var9];
               this.verticesZ[this.field1941] = var8.verticesZ[var9];
               ++this.field1941;
            }
         }
      }

   }

   @ObfuscatedName("a")
   public void method2499(Frames var1, int var2) {
      if(this.field1944 != null) {
         if(var2 != -1) {
            Frame var3 = var1.field2163[var2];
            FrameMap var4 = var3.field1907;
            field1995 = 0;
            field1996 = 0;
            field1940 = 0;

            for(int var5 = 0; var5 < var3.field1906; ++var5) {
               int var6 = var3.field1909[var5];
               this.method2501(var4.field2069[var6], var4.field2070[var6], var3.translator_x[var5], var3.translator_y[var5], var3.translator_z[var5]);
            }

            this.method2500();
         }
      }
   }

   @ObfuscatedName("n")
   void method2500() {
      this.field2001 = 0;
      this.field1972 = -1;
   }

   @ObfuscatedName("z")
   void method2501(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1995 = 0;
         field1996 = 0;
         field1940 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var9 = var2[var8];
            if(var9 < this.field1944.length) {
               int[] var10 = this.field1944[var9];

               for(var11 = 0; var11 < var10.length; ++var11) {
                  var12 = var10[var11];
                  field1995 += this.verticesX[var12];
                  field1996 += this.verticesY[var12];
                  field1940 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1995 = field1995 / var7 + var3;
            field1996 = field1996 / var7 + var4;
            field1940 = field1940 / var7 + var5;
         } else {
            field1995 = var3;
            field1996 = var4;
            field1940 = var5;
         }

      } else {
         int[] var18;
         int var19;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1944.length) {
                  var18 = this.field1944[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] += var3;
                     this.verticesY[var11] += var4;
                     this.verticesZ[var11] += var5;
                  }
               }
            }

         } else if(var1 == 2) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1944.length) {
                  var18 = this.field1944[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= field1995;
                     this.verticesY[var11] -= field1996;
                     this.verticesZ[var11] -= field1940;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1950[var14];
                        var16 = field1965[var14];
                        var17 = this.verticesY[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesY[var11] = this.verticesY[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1950[var12];
                        var16 = field1965[var12];
                        var17 = this.verticesY[var11] * var16 - this.verticesZ[var11] * var15 >> 16;
                        this.verticesZ[var11] = this.verticesY[var11] * var15 + this.verticesZ[var11] * var16 >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1950[var13];
                        var16 = field1965[var13];
                        var17 = this.verticesZ[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesZ[var11] = this.verticesZ[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += field1995;
                     this.verticesY[var11] += field1996;
                     this.verticesZ[var11] += field1940;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1944.length) {
                  var18 = this.field1944[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= field1995;
                     this.verticesY[var11] -= field1996;
                     this.verticesZ[var11] -= field1940;
                     this.verticesX[var11] = this.verticesX[var11] * var3 / 128;
                     this.verticesY[var11] = this.verticesY[var11] * var4 / 128;
                     this.verticesZ[var11] = this.verticesZ[var11] * var5 / 128;
                     this.verticesX[var11] += field1995;
                     this.verticesY[var11] += field1996;
                     this.verticesZ[var11] += field1940;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1962 != null && this.field2002 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1962.length) {
                     var18 = this.field1962[var8];

                     for(var19 = 0; var19 < var18.length; ++var19) {
                        var11 = var18[var19];
                        var12 = (this.field2002[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field2002[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("j")
   public void method2502() {
      for(int var1 = 0; var1 < this.field1941; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.method2500();
   }

   @ObfuscatedName("at")
   final void method2503(boolean var1, boolean var2, boolean var3, int var4) {
      if(this.field1967 < 1600) {
         int var5;
         for(var5 = 0; var5 < this.field1967; ++var5) {
            field1960[var5] = 0;
         }

         var5 = var3?20:5;
         if(class7.field237 && var2) {
            class77.method1511(this, var5);
         }

         int var6;
         int var7;
         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         int var14;
         int var15;
         int var17;
         for(var6 = 0; var6 < this.field1945; ++var6) {
            if(this.field1951[var6] != -2) {
               var7 = this.indices1[var6];
               var8 = this.indices2[var6];
               var9 = this.indices3[var6];
               var10 = field1978[var7];
               var11 = field1978[var8];
               var12 = field1978[var9];
               int var13;
               if(var1 && (var10 == -5000 || var11 == -5000 || var12 == -5000)) {
                  var13 = field1985[var7];
                  var14 = field1985[var8];
                  var15 = field1985[var9];
                  int var26 = field1971[var7];
                  var17 = field1971[var8];
                  int var18 = field1971[var9];
                  int var19 = field1983[var7];
                  int var20 = field1983[var8];
                  int var21 = field1983[var9];
                  var13 -= var14;
                  var15 -= var14;
                  var26 -= var17;
                  var18 -= var17;
                  var19 -= var20;
                  var21 -= var20;
                  int var22 = var26 * var21 - var19 * var18;
                  int var23 = var19 * var15 - var13 * var21;
                  int var24 = var13 * var18 - var26 * var15;
                  if(var14 * var22 + var17 * var23 + var20 * var24 > 0) {
                     field1975[var6] = true;
                     int var25 = (field1970[var7] + field1970[var8] + field1970[var9]) / 3 + this.field1982;
                     field1953[var25][field1960[var25]++] = var6;
                  }
               } else {
                  if(var2 && GameObject.method2899(field1979[var7], field1979[var8], field1979[var9], var10, var11, var12, var5)) {
                     class134.field2014[++class134.field2013 - 1] = var4;
                     var2 = false;
                  }

                  if((var10 - var11) * (field1979[var9] - field1979[var8]) - (field1979[var7] - field1979[var8]) * (var12 - var11) > 0) {
                     field1975[var6] = false;
                     if(var10 >= 0 && var11 >= 0 && var12 >= 0 && var10 <= class136.rasterClipX && var11 <= class136.rasterClipX && var12 <= class136.rasterClipX) {
                        field1976[var6] = false;
                     } else {
                        field1976[var6] = true;
                     }

                     var13 = (field1970[var7] + field1970[var8] + field1970[var9]) / 3 + this.field1982;
                     field1953[var13][field1960[var13]++] = var6;
                  }
               }
            }
         }

         int[] var27;
         if(this.field1952 == null) {
            for(var6 = this.field1967 - 1; var6 >= 0; --var6) {
               var7 = field1960[var6];
               if(var7 > 0) {
                  var27 = field1953[var6];

                  for(var9 = 0; var9 < var7; ++var9) {
                     this.method2512(var27[var9]);
                  }
               }
            }

         } else {
            for(var6 = 0; var6 < 12; ++var6) {
               field1943[var6] = 0;
               field1991[var6] = 0;
            }

            for(var6 = this.field1967 - 1; var6 >= 0; --var6) {
               var7 = field1960[var6];
               if(var7 > 0) {
                  var27 = field1953[var6];

                  for(var9 = 0; var9 < var7; ++var9) {
                     var10 = var27[var9];
                     byte var30 = this.field1952[var10];
                     var12 = field1943[var30]++;
                     field1988[var30][var12] = var10;
                     if(var30 < 10) {
                        field1991[var30] += var6;
                     } else if(var30 == 10) {
                        field1989[var12] = var6;
                     } else {
                        field1990[var12] = var6;
                     }
                  }
               }
            }

            var6 = 0;
            if(field1943[1] > 0 || field1943[2] > 0) {
               var6 = (field1991[1] + field1991[2]) / (field1943[1] + field1943[2]);
            }

            var7 = 0;
            if(field1943[3] > 0 || field1943[4] > 0) {
               var7 = (field1991[3] + field1991[4]) / (field1943[3] + field1943[4]);
            }

            var8 = 0;
            if(field1943[6] > 0 || field1943[8] > 0) {
               var8 = (field1991[6] + field1991[8]) / (field1943[6] + field1943[8]);
            }

            var10 = 0;
            var11 = field1943[10];
            int[] var28 = field1988[10];
            int[] var29 = field1989;
            if(var10 == var11) {
               var10 = 0;
               var11 = field1943[11];
               var28 = field1988[11];
               var29 = field1990;
            }

            if(var10 < var11) {
               var9 = var29[var10];
            } else {
               var9 = -1000;
            }

            for(var14 = 0; var14 < 10; ++var14) {
               while(var14 == 0 && var9 > var6) {
                  this.method2512(var28[var10++]);
                  if(var10 == var11 && var28 != field1988[11]) {
                     var10 = 0;
                     var11 = field1943[11];
                     var28 = field1988[11];
                     var29 = field1990;
                  }

                  if(var10 < var11) {
                     var9 = var29[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 3 && var9 > var7) {
                  this.method2512(var28[var10++]);
                  if(var10 == var11 && var28 != field1988[11]) {
                     var10 = 0;
                     var11 = field1943[11];
                     var28 = field1988[11];
                     var29 = field1990;
                  }

                  if(var10 < var11) {
                     var9 = var29[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 5 && var9 > var8) {
                  this.method2512(var28[var10++]);
                  if(var10 == var11 && var28 != field1988[11]) {
                     var10 = 0;
                     var11 = field1943[11];
                     var28 = field1988[11];
                     var29 = field1990;
                  }

                  if(var10 < var11) {
                     var9 = var29[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               var15 = field1943[var14];
               int[] var16 = field1988[var14];

               for(var17 = 0; var17 < var15; ++var17) {
                  this.method2512(var16[var17]);
               }
            }

            while(var9 != -1000) {
               this.method2512(var28[var10++]);
               if(var10 == var11 && var28 != field1988[11]) {
                  var10 = 0;
                  var28 = field1988[11];
                  var11 = field1943[11];
                  var29 = field1990;
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

   @ObfuscatedName("l")
   public void method2505() {
      for(int var1 = 0; var1 < this.field1941; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.method2500();
   }

   @ObfuscatedName("ar")
   public void method2507(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1941; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = this.verticesY[var4] * var2 / 128;
         this.verticesZ[var4] = this.verticesZ[var4] * var3 / 128;
      }

      this.method2500();
   }

   @ObfuscatedName("an")
   public final void method2508(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1960[0] = -1;
      if(this.field2001 != 2 && this.field2001 != 1) {
         this.method2497();
      }

      int var8 = class136.field2032;
      int var9 = class136.field2046;
      int var10000 = field1950[var1];
      var10000 = field1965[var1];
      int var12 = field1950[var2];
      int var13 = field1965[var2];
      int var14 = field1950[var3];
      int var15 = field1965[var3];
      int var16 = field1950[var4];
      int var17 = field1965[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1941; ++var19) {
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
         field1970[var19] = var22 - var18;
         field1978[var19] = var8 + var20 * class136.field2038 / var22;
         field1979[var19] = var9 + var23 * class136.field2038 / var22;
         if(this.field1957 > 0) {
            field1985[var19] = var20;
            field1971[var19] = var23;
            field1983[var19] = var22;
         }
      }

      try {
         this.method2503(false, false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("af")
   public final void method2509(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1960[0] = -1;
      if(this.field2001 != 2 && this.field2001 != 1) {
         this.method2497();
      }

      int var9 = class136.field2032;
      int var10 = class136.field2046;
      int var10000 = field1950[var1];
      var10000 = field1965[var1];
      int var13 = field1950[var2];
      int var14 = field1965[var2];
      int var15 = field1950[var3];
      int var16 = field1965[var3];
      int var17 = field1950[var4];
      int var18 = field1965[var4];
      int var19 = var6 * var17 + var7 * var18 >> 16;

      for(int var20 = 0; var20 < this.field1941; ++var20) {
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
         field1970[var20] = var23 - var19;
         field1978[var20] = var9 + var21 * class136.field2038 / var8;
         field1979[var20] = var10 + var24 * class136.field2038 / var8;
         if(this.field1957 > 0) {
            field1985[var20] = var21;
            field1971[var20] = var24;
            field1983[var20] = var23;
         }
      }

      try {
         this.method2503(false, false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("ci")
   void vmethod2855(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1960[0] = -1;
      if(this.field2001 != 1) {
         this.method2496();
      }

      this.method2495(var1);
      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1966 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1966) * class136.field2038;
         if(var15 / var13 < class136.field2044) {
            int var16 = (var14 + this.field1966) * class136.field2038;
            if(var16 / var13 > class136.field2043) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1966 * var2 >> 16;
               int var19 = (var17 + var18) * class136.field2038;
               if(var19 / var13 > class136.field2048) {
                  int var20 = var18 + (super.modelHeight * var3 >> 16);
                  int var21 = (var17 - var20) * class136.field2038;
                  if(var21 / var13 < class136.field2039) {
                     int var22 = var12 + (super.modelHeight * var2 >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1957 > 0;
                     int var26 = class226.method4081();
                     int var27 = Frames.method2873();
                     boolean var28 = GameEngine.method880();
                     if(class7.field236 && var9 > 0) {
                        class61.method1049(this, var6, var7, var8);
                     }

                     int var30;
                     int var31;
                     int var32;
                     int var33;
                     int var34;
                     int var35;
                     int var36;
                     if(class7.field235 && var9 > 0) {
                        int var29 = var11 - var12;
                        if(var29 <= 50) {
                           var29 = 50;
                        }

                        if(var14 > 0) {
                           var30 = var15 / var13;
                           var31 = var16 / var29;
                        } else {
                           var31 = var16 / var13;
                           var30 = var15 / var29;
                        }

                        if(var17 > 0) {
                           var32 = var21 / var13;
                           var33 = var19 / var29;
                        } else {
                           var33 = var19 / var13;
                           var32 = var21 / var29;
                        }

                        var34 = -8355840;
                        var35 = var26 - class136.field2032;
                        var36 = var27 - class136.field2046;
                        if(var35 > var30 && var35 < var31 && var36 > var32 && var36 < var33) {
                           var34 = -256;
                        }

                        class59.method966(var30 + class136.field2032, var32 + class136.field2046, var31 + class136.field2032, var33 + class136.field2046, var34);
                     }

                     boolean var41 = false;
                     if(var9 > 0 && var28) {
                        boolean var42 = false;
                        if(field1998) {
                           var42 = class228.method4085(this, var6, var7, var8);
                        } else {
                           var31 = var11 - var12;
                           if(var31 <= 50) {
                              var31 = 50;
                           }

                           if(var14 > 0) {
                              var15 /= var13;
                              var16 /= var31;
                           } else {
                              var16 /= var13;
                              var15 /= var31;
                           }

                           if(var17 > 0) {
                              var21 /= var13;
                              var19 /= var31;
                           } else {
                              var19 /= var13;
                              var21 /= var31;
                           }

                           var32 = var26 - class136.field2032;
                           var33 = var27 - class136.field2046;
                           if(var32 > var15 && var32 < var16 && var33 > var21 && var33 < var19) {
                              var42 = true;
                           }
                        }

                        if(var42) {
                           if(this.field1987) {
                              class134.field2014[++class134.field2013 - 1] = var9;
                           } else {
                              var41 = true;
                           }
                        }
                     }

                     var30 = class136.field2032;
                     var31 = class136.field2046;
                     var32 = 0;
                     var33 = 0;
                     if(var1 != 0) {
                        var32 = field1950[var1];
                        var33 = field1965[var1];
                     }

                     for(var34 = 0; var34 < this.field1941; ++var34) {
                        var35 = this.verticesX[var34];
                        var36 = this.verticesY[var34];
                        int var37 = this.verticesZ[var34];
                        int var38;
                        if(var1 != 0) {
                           var38 = var37 * var32 + var35 * var33 >> 16;
                           var37 = var37 * var33 - var35 * var32 >> 16;
                           var35 = var38;
                        }

                        var35 += var6;
                        var36 += var7;
                        var37 += var8;
                        var38 = var37 * var4 + var35 * var5 >> 16;
                        var37 = var37 * var5 - var35 * var4 >> 16;
                        var35 = var38;
                        var38 = var36 * var3 - var37 * var2 >> 16;
                        var37 = var36 * var2 + var37 * var3 >> 16;
                        field1970[var34] = var37 - var11;
                        if(var37 >= 50) {
                           field1978[var34] = var30 + var35 * class136.field2038 / var37;
                           field1979[var34] = var31 + var38 * class136.field2038 / var37;
                        } else {
                           field1978[var34] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1985[var34] = var35;
                           field1971[var34] = var38;
                           field1983[var34] = var37;
                        }
                     }

                     try {
                        this.method2503(var23, var41, this.field1987, var9);
                     } catch (Exception var40) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("ah")
   final void method2512(int var1) {
      if(field1975[var1]) {
         this.method2530(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         class136.rasterClipEnable = field1976[var1];
         if(this.field2002 == null) {
            class136.rasterAlpha = 0;
         } else {
            class136.rasterAlpha = this.field2002[var1] & 255;
         }

         if(this.field1955 != null && this.field1955[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1954 != null && this.field1954[var1] != -1) {
               int var8 = this.field1954[var1] & 255;
               var5 = this.field1958[var8];
               var6 = this.field1959[var8];
               var7 = this.field1963[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1951[var1] == -1) {
               class136.rasterTextureAffine(field1979[var2], field1979[var3], field1979[var4], field1978[var2], field1978[var3], field1978[var4], this.field1949[var1], this.field1949[var1], this.field1949[var1], field1985[var5], field1985[var6], field1985[var7], field1971[var5], field1971[var6], field1971[var7], field1983[var5], field1983[var6], field1983[var7], this.field1955[var1]);
            } else {
               class136.rasterTextureAffine(field1979[var2], field1979[var3], field1979[var4], field1978[var2], field1978[var3], field1978[var4], this.field1949[var1], this.field1974[var1], this.field1951[var1], field1985[var5], field1985[var6], field1985[var7], field1971[var5], field1971[var6], field1971[var7], field1983[var5], field1983[var6], field1983[var7], this.field1955[var1]);
            }
         } else if(this.field1951[var1] == -1) {
            class136.rasterFlat(field1979[var2], field1979[var3], field1979[var4], field1978[var2], field1978[var3], field1978[var4], field2003[this.field1949[var1]]);
         } else {
            class136.rasterGouraud(field1979[var2], field1979[var3], field1979[var4], field1978[var2], field1978[var3], field1978[var4], this.field1949[var1], this.field1974[var1], this.field1951[var1]);
         }

      }
   }

   @ObfuscatedName("ad")
   public void method2513(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1941; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.method2500();
   }

   static {
      field1961 = new Model();
      field1938 = new byte[1];
      field1939 = new Model();
      field1964 = new byte[1];
      field1976 = new boolean[4700];
      field1975 = new boolean[4700];
      field1978 = new int[4700];
      field1979 = new int[4700];
      field1970 = new int[4700];
      field1985 = new int[4700];
      field1971 = new int[4700];
      field1983 = new int[4700];
      field1960 = new int[1600];
      field1953 = new int[1600][512];
      field1943 = new int[12];
      field1988 = new int[12][2000];
      field1989 = new int[2000];
      field1990 = new int[2000];
      field1991 = new int[12];
      field1986 = new int[10];
      field1993 = new int[10];
      field1994 = new int[10];
      field1998 = true;
      field1950 = class136.SINE;
      field1965 = class136.COSINE;
      field2003 = class136.colorPalette;
      field2004 = class136.field2050;
   }

   @ObfuscatedName("v")
   public Model method2515(boolean var1) {
      if(!var1 && field1964.length < this.field1945) {
         field1964 = new byte[this.field1945 + 100];
      }

      return this.method2494(var1, field1939, field1964);
   }

   @ObfuscatedName("t")
   public void method2517(int var1) {
      int var2 = field1950[var1];
      int var3 = field1965[var1];

      for(int var4 = 0; var4 < this.field1941; ++var4) {
         int var5 = this.verticesY[var4] * var3 - this.verticesZ[var4] * var2 >> 16;
         this.verticesZ[var4] = this.verticesY[var4] * var2 + this.verticesZ[var4] * var3 >> 16;
         this.verticesY[var4] = var5;
      }

      this.method2500();
   }

   @ObfuscatedName("ai")
   final void method2530(int var1) {
      int var2 = class136.field2032;
      int var3 = class136.field2046;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1983[var5];
      int var9 = field1983[var6];
      int var10 = field1983[var7];
      if(this.field2002 == null) {
         class136.rasterAlpha = 0;
      } else {
         class136.rasterAlpha = this.field2002[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1986[var4] = field1978[var5];
         field1993[var4] = field1979[var5];
         field1994[var4++] = this.field1949[var1];
      } else {
         var11 = field1985[var5];
         var12 = field1971[var5];
         var13 = this.field1949[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field2004[var10 - var8];
            field1986[var4] = var2 + (var11 + ((field1985[var7] - var11) * var14 >> 16)) * class136.field2038 / 50;
            field1993[var4] = var3 + (var12 + ((field1971[var7] - var12) * var14 >> 16)) * class136.field2038 / 50;
            field1994[var4++] = var13 + ((this.field1951[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field2004[var9 - var8];
            field1986[var4] = var2 + (var11 + ((field1985[var6] - var11) * var14 >> 16)) * class136.field2038 / 50;
            field1993[var4] = var3 + (var12 + ((field1971[var6] - var12) * var14 >> 16)) * class136.field2038 / 50;
            field1994[var4++] = var13 + ((this.field1974[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1986[var4] = field1978[var6];
         field1993[var4] = field1979[var6];
         field1994[var4++] = this.field1974[var1];
      } else {
         var11 = field1985[var6];
         var12 = field1971[var6];
         var13 = this.field1974[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field2004[var8 - var9];
            field1986[var4] = var2 + (var11 + ((field1985[var5] - var11) * var14 >> 16)) * class136.field2038 / 50;
            field1993[var4] = var3 + (var12 + ((field1971[var5] - var12) * var14 >> 16)) * class136.field2038 / 50;
            field1994[var4++] = var13 + ((this.field1949[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field2004[var10 - var9];
            field1986[var4] = var2 + (var11 + ((field1985[var7] - var11) * var14 >> 16)) * class136.field2038 / 50;
            field1993[var4] = var3 + (var12 + ((field1971[var7] - var12) * var14 >> 16)) * class136.field2038 / 50;
            field1994[var4++] = var13 + ((this.field1951[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1986[var4] = field1978[var7];
         field1993[var4] = field1979[var7];
         field1994[var4++] = this.field1951[var1];
      } else {
         var11 = field1985[var7];
         var12 = field1971[var7];
         var13 = this.field1951[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field2004[var9 - var10];
            field1986[var4] = var2 + (var11 + ((field1985[var6] - var11) * var14 >> 16)) * class136.field2038 / 50;
            field1993[var4] = var3 + (var12 + ((field1971[var6] - var12) * var14 >> 16)) * class136.field2038 / 50;
            field1994[var4++] = var13 + ((this.field1974[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field2004[var8 - var10];
            field1986[var4] = var2 + (var11 + ((field1985[var5] - var11) * var14 >> 16)) * class136.field2038 / 50;
            field1993[var4] = var3 + (var12 + ((field1971[var5] - var12) * var14 >> 16)) * class136.field2038 / 50;
            field1994[var4++] = var13 + ((this.field1949[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1986[0];
      var12 = field1986[1];
      var13 = field1986[2];
      var14 = field1993[0];
      int var15 = field1993[1];
      int var16 = field1993[2];
      class136.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class136.rasterClipX || var12 > class136.rasterClipX || var13 > class136.rasterClipX) {
            class136.rasterClipEnable = true;
         }

         if(this.field1955 != null && this.field1955[var1] != -1) {
            if(this.field1954 != null && this.field1954[var1] != -1) {
               var20 = this.field1954[var1] & 255;
               var17 = this.field1958[var20];
               var18 = this.field1959[var20];
               var19 = this.field1963[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1951[var1] == -1) {
               class136.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1949[var1], this.field1949[var1], this.field1949[var1], field1985[var17], field1985[var18], field1985[var19], field1971[var17], field1971[var18], field1971[var19], field1983[var17], field1983[var18], field1983[var19], this.field1955[var1]);
            } else {
               class136.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1994[0], field1994[1], field1994[2], field1985[var17], field1985[var18], field1985[var19], field1971[var17], field1971[var18], field1971[var19], field1983[var17], field1983[var18], field1983[var19], this.field1955[var1]);
            }
         } else if(this.field1951[var1] == -1) {
            class136.rasterFlat(var14, var15, var16, var11, var12, var13, field2003[this.field1949[var1]]);
         } else {
            class136.rasterGouraud(var14, var15, var16, var11, var12, var13, field1994[0], field1994[1], field1994[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class136.rasterClipX || var12 > class136.rasterClipX || var13 > class136.rasterClipX || field1986[3] < 0 || field1986[3] > class136.rasterClipX) {
            class136.rasterClipEnable = true;
         }

         if(this.field1955 != null && this.field1955[var1] != -1) {
            if(this.field1954 != null && this.field1954[var1] != -1) {
               var20 = this.field1954[var1] & 255;
               var17 = this.field1958[var20];
               var18 = this.field1959[var20];
               var19 = this.field1963[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1955[var1];
            if(this.field1951[var1] == -1) {
               class136.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1949[var1], this.field1949[var1], this.field1949[var1], field1985[var17], field1985[var18], field1985[var19], field1971[var17], field1971[var18], field1971[var19], field1983[var17], field1983[var18], field1983[var19], var21);
               class136.rasterTextureAffine(var14, var16, field1993[3], var11, var13, field1986[3], this.field1949[var1], this.field1949[var1], this.field1949[var1], field1985[var17], field1985[var18], field1985[var19], field1971[var17], field1971[var18], field1971[var19], field1983[var17], field1983[var18], field1983[var19], var21);
            } else {
               class136.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1994[0], field1994[1], field1994[2], field1985[var17], field1985[var18], field1985[var19], field1971[var17], field1971[var18], field1971[var19], field1983[var17], field1983[var18], field1983[var19], var21);
               class136.rasterTextureAffine(var14, var16, field1993[3], var11, var13, field1986[3], field1994[0], field1994[2], field1994[3], field1985[var17], field1985[var18], field1985[var19], field1971[var17], field1971[var18], field1971[var19], field1983[var17], field1983[var18], field1983[var19], var21);
            }
         } else if(this.field1951[var1] == -1) {
            var17 = field2003[this.field1949[var1]];
            class136.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            class136.rasterFlat(var14, var16, field1993[3], var11, var13, field1986[3], var17);
         } else {
            class136.rasterGouraud(var14, var15, var16, var11, var12, var13, field1994[0], field1994[1], field1994[2]);
            class136.rasterGouraud(var14, var16, field1993[3], var11, var13, field1986[3], field1994[0], field1994[2], field1994[3]);
         }
      }

   }

   @ObfuscatedName("c")
   public Model method2541(boolean var1) {
      if(!var1 && field1938.length < this.field1945) {
         field1938 = new byte[this.field1945 + 100];
      }

      return this.method2494(var1, field1961, field1938);
   }

   @ObfuscatedName("i")
   public Model method2551(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2496();
      int var7 = var2 - this.field1966;
      int var8 = var2 + this.field1966;
      int var9 = var4 - this.field1966;
      int var10 = var4 + this.field1966;
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
               var11.field1941 = this.field1941;
               var11.field1945 = this.field1945;
               var11.field1957 = this.field1957;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1949 = this.field1949;
               var11.field1974 = this.field1974;
               var11.field1951 = this.field1951;
               var11.field1952 = this.field1952;
               var11.field2002 = this.field2002;
               var11.field1954 = this.field1954;
               var11.field1955 = this.field1955;
               var11.field1956 = this.field1956;
               var11.field1958 = this.field1958;
               var11.field1959 = this.field1959;
               var11.field1963 = this.field1963;
               var11.field1944 = this.field1944;
               var11.field1962 = this.field1962;
               var11.field1987 = this.field1987;
               var11.verticesY = new int[var11.field1941];
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
               for(var12 = 0; var12 < var11.field1941; ++var12) {
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
               for(var12 = 0; var12 < var11.field1941; ++var12) {
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

            var11.method2500();
            return var11;
         }
      } else {
         return this;
      }
   }
}
