import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ek")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("bp")
   static int[] field1931;
   @ObfuscatedName("at")
   public int field1932;
   @ObfuscatedName("au")
   public int field1933;
   @ObfuscatedName("bz")
   static int[] field1934;
   @ObfuscatedName("m")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("c")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("p")
   static byte[] field1938;
   @ObfuscatedName("h")
   public int field1939;
   @ObfuscatedName("d")
   int[][] field1940;
   @ObfuscatedName("e")
   @Export("indices2")
   public int[] indices2;
   @ObfuscatedName("o")
   @Export("indices3")
   public int[] indices3;
   @ObfuscatedName("x")
   int[] field1943;
   @ObfuscatedName("bs")
   public static boolean field1944;
   @ObfuscatedName("bc")
   static int[] field1945;
   @ObfuscatedName("r")
   byte[] field1946;
   @ObfuscatedName("y")
   public int[] field1947;
   @ObfuscatedName("s")
   byte[] field1948;
   @ObfuscatedName("v")
   short[] field1949;
   @ObfuscatedName("t")
   byte field1950;
   @ObfuscatedName("w")
   int field1951;
   @ObfuscatedName("l")
   int[] field1952;
   @ObfuscatedName("ah")
   public int field1953;
   @ObfuscatedName("k")
   int[] field1954;
   @ObfuscatedName("f")
   int field1955;
   @ObfuscatedName("u")
   int[][] field1956;
   @ObfuscatedName("ae")
   public boolean field1957;
   @ObfuscatedName("ao")
   int field1958;
   @ObfuscatedName("ad")
   int field1959;
   @ObfuscatedName("aa")
   int field1960;
   @ObfuscatedName("aw")
   int field1961;
   @ObfuscatedName("n")
   static Model field1963;
   @ObfuscatedName("ag")
   static int[] field1964;
   @ObfuscatedName("bd")
   static int[] field1965;
   @ObfuscatedName("ak")
   public int field1966;
   @ObfuscatedName("as")
   public int field1967;
   @ObfuscatedName("ap")
   static int[][] field1968;
   @ObfuscatedName("am")
   static boolean[] field1970;
   @ObfuscatedName("ac")
   static boolean[] field1971;
   @ObfuscatedName("ax")
   public static int[] field1972;
   @ObfuscatedName("av")
   public static int[] field1973;
   @ObfuscatedName("aq")
   static int[] field1974;
   @ObfuscatedName("af")
   static int[] field1975;
   @ObfuscatedName("a")
   int[] field1976;
   @ObfuscatedName("q")
   int[] field1977;
   @ObfuscatedName("j")
   static byte[] field1978;
   @ObfuscatedName("ay")
   static int[] field1979;
   @ObfuscatedName("ai")
   static int[] field1981;
   @ObfuscatedName("az")
   static int[][] field1982;
   @ObfuscatedName("bv")
   static int[] field1983;
   @ObfuscatedName("be")
   static int[] field1984;
   @ObfuscatedName("b")
   byte[] field1985;
   @ObfuscatedName("bj")
   static int[] field1986;
   @ObfuscatedName("bx")
   static int[] field1987;
   @ObfuscatedName("bf")
   static int[] field1988;
   @ObfuscatedName("bn")
   static int field1989;
   @ObfuscatedName("bh")
   static int field1990;
   @ObfuscatedName("bm")
   static int field1991;
   @ObfuscatedName("al")
   public int field1992;
   @ObfuscatedName("ar")
   static int[] field1993;
   @ObfuscatedName("z")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("an")
   int field1995;
   @ObfuscatedName("bt")
   static int[] field1996;
   @ObfuscatedName("i")
   static Model field1997;
   @ObfuscatedName("g")
   @Export("indices1")
   public int[] indices1;

   public Model(Model[] var1, int var2) {
      this.field1955 = 0;
      this.field1939 = 0;
      this.field1950 = 0;
      this.field1951 = 0;
      this.field1957 = false;
      this.field1966 = -1;
      this.field1967 = -1;
      this.field1953 = -1;
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1955 = 0;
      this.field1939 = 0;
      this.field1951 = 0;
      this.field1950 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1955 += var8.field1955;
            this.field1939 += var8.field1939;
            this.field1951 += var8.field1951;
            if(var8.field1946 != null) {
               var3 = true;
            } else {
               if(this.field1950 == -1) {
                  this.field1950 = var8.field1950;
               }

               if(this.field1950 != var8.field1950) {
                  var3 = true;
               }
            }

            var4 |= var8.field1985 != null;
            var5 |= var8.field1949 != null;
            var6 |= var8.field1948 != null;
         }
      }

      this.verticesX = new int[this.field1955];
      this.verticesY = new int[this.field1955];
      this.verticesZ = new int[this.field1955];
      this.indices1 = new int[this.field1939];
      this.indices2 = new int[this.field1939];
      this.indices3 = new int[this.field1939];
      this.field1943 = new int[this.field1939];
      this.field1976 = new int[this.field1939];
      this.field1947 = new int[this.field1939];
      if(var3) {
         this.field1946 = new byte[this.field1939];
      }

      if(var4) {
         this.field1985 = new byte[this.field1939];
      }

      if(var5) {
         this.field1949 = new short[this.field1939];
      }

      if(var6) {
         this.field1948 = new byte[this.field1939];
      }

      if(this.field1951 > 0) {
         this.field1952 = new int[this.field1951];
         this.field1977 = new int[this.field1951];
         this.field1954 = new int[this.field1951];
      }

      this.field1955 = 0;
      this.field1939 = 0;
      this.field1951 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1939; ++var9) {
               this.indices1[this.field1939] = var8.indices1[var9] + this.field1955;
               this.indices2[this.field1939] = var8.indices2[var9] + this.field1955;
               this.indices3[this.field1939] = var8.indices3[var9] + this.field1955;
               this.field1943[this.field1939] = var8.field1943[var9];
               this.field1976[this.field1939] = var8.field1976[var9];
               this.field1947[this.field1939] = var8.field1947[var9];
               if(var3) {
                  if(var8.field1946 != null) {
                     this.field1946[this.field1939] = var8.field1946[var9];
                  } else {
                     this.field1946[this.field1939] = var8.field1950;
                  }
               }

               if(var4 && var8.field1985 != null) {
                  this.field1985[this.field1939] = var8.field1985[var9];
               }

               if(var5) {
                  if(var8.field1949 != null) {
                     this.field1949[this.field1939] = var8.field1949[var9];
                  } else {
                     this.field1949[this.field1939] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1948 != null && var8.field1948[var9] != -1) {
                     this.field1948[this.field1939] = (byte)(var8.field1948[var9] + this.field1951);
                  } else {
                     this.field1948[this.field1939] = -1;
                  }
               }

               ++this.field1939;
            }

            for(var9 = 0; var9 < var8.field1951; ++var9) {
               this.field1952[this.field1951] = var8.field1952[var9] + this.field1955;
               this.field1977[this.field1951] = var8.field1977[var9] + this.field1955;
               this.field1954[this.field1951] = var8.field1954[var9] + this.field1955;
               ++this.field1951;
            }

            for(var9 = 0; var9 < var8.field1955; ++var9) {
               this.verticesX[this.field1955] = var8.verticesX[var9];
               this.verticesY[this.field1955] = var8.verticesY[var9];
               this.verticesZ[this.field1955] = var8.verticesZ[var9];
               ++this.field1955;
            }
         }
      }

   }

   @ObfuscatedName("p")
   public Model method2511(boolean var1) {
      if(!var1 && field1938.length < this.field1939) {
         field1938 = new byte[this.field1939 + 100];
      }

      return this.method2532(var1, field1963, field1938);
   }

   @ObfuscatedName("j")
   public Model method2512(boolean var1) {
      if(!var1 && field1978.length < this.field1939) {
         field1978 = new byte[this.field1939 + 100];
      }

      return this.method2532(var1, field1997, field1978);
   }

   @ObfuscatedName("m")
   void method2514(int var1) {
      if(this.field1966 == -1) {
         int var2 = 0;
         int var3 = 0;
         int var4 = 0;
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         int var8 = field1996[var1];
         int var9 = field1931[var1];

         for(int var10 = 0; var10 < this.field1955; ++var10) {
            int var11 = class136.method2611(this.verticesX[var10], this.verticesZ[var10], var8, var9);
            int var12 = this.verticesY[var10];
            int var13 = class136.method2651(this.verticesX[var10], this.verticesZ[var10], var8, var9);
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

         this.field1992 = (var5 + var2) / 2;
         this.field1932 = (var6 + var3) / 2;
         this.field1933 = (var7 + var4) / 2;
         this.field1966 = (var5 - var2 + 1) / 2;
         this.field1967 = (var6 - var3 + 1) / 2;
         this.field1953 = (var7 - var4 + 1) / 2;
         if(this.field1966 < 32) {
            this.field1966 = 32;
         }

         if(this.field1953 < 32) {
            this.field1953 = 32;
         }

         if(this.field1957) {
            this.field1966 += 8;
            this.field1953 += 8;
         }

      }
   }

   @ObfuscatedName("c")
   public void method2515() {
      if(this.field1958 != 1) {
         this.field1958 = 1;
         super.modelHeight = 0;
         this.field1959 = 0;
         this.field1960 = 0;

         for(int var1 = 0; var1 < this.field1955; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1959) {
               this.field1959 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1960) {
               this.field1960 = var5;
            }
         }

         this.field1960 = (int)(Math.sqrt((double)this.field1960) + 0.99D);
         this.field1995 = (int)(Math.sqrt((double)(this.field1960 * this.field1960 + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1961 = this.field1995 + (int)(Math.sqrt((double)(this.field1960 * this.field1960 + this.field1959 * this.field1959)) + 0.99D);
      }
   }

   @ObfuscatedName("z")
   void method2516() {
      if(this.field1958 != 2) {
         this.field1958 = 2;
         this.field1960 = 0;

         for(int var1 = 0; var1 < this.field1955; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1960) {
               this.field1960 = var5;
            }
         }

         this.field1960 = (int)(Math.sqrt((double)this.field1960) + 0.99D);
         this.field1995 = this.field1960;
         this.field1961 = this.field1960 + this.field1960;
      }
   }

   @ObfuscatedName("h")
   public int method2517() {
      this.method2515();
      return this.field1960;
   }

   @ObfuscatedName("g")
   void method2518() {
      this.field1958 = 0;
      this.field1966 = -1;
   }

   @ObfuscatedName("v")
   public void method2519(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1955; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.method2518();
   }

   @ObfuscatedName("o")
   public void method2520(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.field2148[var2];
            Frame var7 = var3.field2148[var4];
            FrameMap var8 = var6.field1900;
            field1989 = 0;
            field1990 = 0;
            field1991 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1901; ++var11) {
               for(var12 = var6.field1902[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field2055[var12] == 0) {
                  this.method2521(var8.field2055[var12], var8.field2057[var12], var6.translator_x[var11], var6.translator_y[var11], var6.translator_z[var11]);
               }
            }

            field1989 = 0;
            field1990 = 0;
            field1991 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1901; ++var11) {
               for(var12 = var7.field1902[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field2055[var12] == 0) {
                  this.method2521(var8.field2055[var12], var8.field2057[var12], var7.translator_x[var11], var7.translator_y[var11], var7.translator_z[var11]);
               }
            }

            this.method2518();
         } else {
            this.method2536(var1, var2);
         }
      }
   }

   @ObfuscatedName("x")
   void method2521(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1989 = 0;
         field1990 = 0;
         field1991 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var9 = var2[var8];
            if(var9 < this.field1940.length) {
               int[] var10 = this.field1940[var9];

               for(var11 = 0; var11 < var10.length; ++var11) {
                  var12 = var10[var11];
                  field1989 += this.verticesX[var12];
                  field1990 += this.verticesY[var12];
                  field1991 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1989 = field1989 / var7 + var3;
            field1990 = field1990 / var7 + var4;
            field1991 = field1991 / var7 + var5;
         } else {
            field1989 = var3;
            field1990 = var4;
            field1991 = var5;
         }

      } else {
         int var18;
         int[] var19;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1940.length) {
                  var19 = this.field1940[var8];

                  for(var18 = 0; var18 < var19.length; ++var18) {
                     var11 = var19[var18];
                     this.verticesX[var11] += var3;
                     this.verticesY[var11] += var4;
                     this.verticesZ[var11] += var5;
                  }
               }
            }

         } else if(var1 == 2) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1940.length) {
                  var19 = this.field1940[var8];

                  for(var18 = 0; var18 < var19.length; ++var18) {
                     var11 = var19[var18];
                     this.verticesX[var11] -= field1989;
                     this.verticesY[var11] -= field1990;
                     this.verticesZ[var11] -= field1991;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1931[var14];
                        var16 = field1996[var14];
                        var17 = this.verticesY[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesY[var11] = this.verticesY[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1931[var12];
                        var16 = field1996[var12];
                        var17 = this.verticesY[var11] * var16 - this.verticesZ[var11] * var15 >> 16;
                        this.verticesZ[var11] = this.verticesY[var11] * var15 + this.verticesZ[var11] * var16 >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1931[var13];
                        var16 = field1996[var13];
                        var17 = this.verticesZ[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesZ[var11] = this.verticesZ[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += field1989;
                     this.verticesY[var11] += field1990;
                     this.verticesZ[var11] += field1991;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1940.length) {
                  var19 = this.field1940[var8];

                  for(var18 = 0; var18 < var19.length; ++var18) {
                     var11 = var19[var18];
                     this.verticesX[var11] -= field1989;
                     this.verticesY[var11] -= field1990;
                     this.verticesZ[var11] -= field1991;
                     this.verticesX[var11] = this.verticesX[var11] * var3 / 128;
                     this.verticesY[var11] = this.verticesY[var11] * var4 / 128;
                     this.verticesZ[var11] = this.verticesZ[var11] * var5 / 128;
                     this.verticesX[var11] += field1989;
                     this.verticesY[var11] += field1990;
                     this.verticesZ[var11] += field1991;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1956 != null && this.field1985 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1956.length) {
                     var19 = this.field1956[var8];

                     for(var18 = 0; var18 < var19.length; ++var18) {
                        var11 = var19[var18];
                        var12 = (this.field1985[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1985[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("y")
   public void method2522() {
      for(int var1 = 0; var1 < this.field1955; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.method2518();
   }

   @ObfuscatedName("r")
   public void method2523() {
      for(int var1 = 0; var1 < this.field1955; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.method2518();
   }

   @ObfuscatedName("b")
   public void method2524() {
      for(int var1 = 0; var1 < this.field1955; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.method2518();
   }

   @ObfuscatedName("s")
   public void method2525(int var1) {
      int var2 = field1931[var1];
      int var3 = field1996[var1];

      for(int var4 = 0; var4 < this.field1955; ++var4) {
         int var5 = this.verticesY[var4] * var3 - this.verticesZ[var4] * var2 >> 16;
         this.verticesZ[var4] = this.verticesY[var4] * var2 + this.verticesZ[var4] * var3 >> 16;
         this.verticesY[var4] = var5;
      }

      this.method2518();
   }

   @ObfuscatedName("t")
   public void method2527(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1955; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = this.verticesY[var4] * var2 / 128;
         this.verticesZ[var4] = this.verticesZ[var4] * var3 / 128;
      }

      this.method2518();
   }

   @ObfuscatedName("w")
   public final void method2528(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1979[0] = -1;
      if(this.field1958 != 2 && this.field1958 != 1) {
         this.method2516();
      }

      int var8 = class136.field2029;
      int var9 = class136.field2030;
      int var10000 = field1931[var1];
      var10000 = field1996[var1];
      int var12 = field1931[var2];
      int var13 = field1996[var2];
      int var14 = field1931[var3];
      int var15 = field1996[var3];
      int var16 = field1931[var4];
      int var17 = field1996[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1955; ++var19) {
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
         field1974[var19] = var22 - var18;
         field1972[var19] = var8 + var20 * class136.field2028 / var22;
         field1973[var19] = var9 + var23 * class136.field2028 / var22;
         if(this.field1951 > 0) {
            field1975[var19] = var20;
            field1964[var19] = var23;
            field1993[var19] = var22;
         }
      }

      try {
         this.method2531(false, false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("u")
   public final void method2529(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1979[0] = -1;
      if(this.field1958 != 2 && this.field1958 != 1) {
         this.method2516();
      }

      int var9 = class136.field2029;
      int var10 = class136.field2030;
      int var10000 = field1931[var1];
      var10000 = field1996[var1];
      int var13 = field1931[var2];
      int var14 = field1996[var2];
      int var15 = field1931[var3];
      int var16 = field1996[var3];
      int var17 = field1931[var4];
      int var18 = field1996[var4];
      int var19 = var6 * var17 + var7 * var18 >> 16;

      for(int var20 = 0; var20 < this.field1955; ++var20) {
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
         field1974[var20] = var23 - var19;
         field1972[var20] = var9 + var21 * class136.field2028 / var8;
         field1973[var20] = var10 + var24 * class136.field2028 / var8;
         if(this.field1951 > 0) {
            field1975[var20] = var21;
            field1964[var20] = var24;
            field1993[var20] = var23;
         }
      }

      try {
         this.method2531(false, false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("aa")
   final void method2531(boolean var1, boolean var2, boolean var3, int var4) {
      if(this.field1961 < 1600) {
         int var5;
         for(var5 = 0; var5 < this.field1961; ++var5) {
            field1979[var5] = 0;
         }

         var5 = var3?20:5;
         if(class7.field235 && var2) {
            class211.method3951(this, var5);
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
         for(var6 = 0; var6 < this.field1939; ++var6) {
            if(this.field1947[var6] != -2) {
               var7 = this.indices1[var6];
               var8 = this.indices2[var6];
               var9 = this.indices3[var6];
               var10 = field1972[var7];
               var11 = field1972[var8];
               var12 = field1972[var9];
               int var13;
               int var16;
               if(!var1 || var10 != -5000 && var11 != -5000 && var12 != -5000) {
                  if(var2) {
                     var14 = field1973[var7];
                     var15 = field1973[var8];
                     var16 = field1973[var9];
                     var17 = var5 + class134.field2003;
                     boolean var31;
                     if(var17 < var14 && var17 < var15 && var17 < var16) {
                        var31 = false;
                     } else {
                        var17 = class134.field2003 - var5;
                        if(var17 > var14 && var17 > var15 && var17 > var16) {
                           var31 = false;
                        } else {
                           var17 = class134.field2001 + var5;
                           if(var17 < var10 && var17 < var11 && var17 < var12) {
                              var31 = false;
                           } else {
                              var17 = class134.field2001 - var5;
                              if(var17 > var10 && var17 > var11 && var17 > var12) {
                                 var31 = false;
                              } else {
                                 var31 = true;
                              }
                           }
                        }
                     }

                     if(var31) {
                        class134.field2002[++class134.field2009 - 1] = var4;
                        var2 = false;
                     }
                  }

                  if((var10 - var11) * (field1973[var9] - field1973[var8]) - (field1973[var7] - field1973[var8]) * (var12 - var11) > 0) {
                     field1971[var6] = false;
                     if(var10 >= 0 && var11 >= 0 && var12 >= 0 && var10 <= class136.rasterClipX && var11 <= class136.rasterClipX && var12 <= class136.rasterClipX) {
                        field1970[var6] = false;
                     } else {
                        field1970[var6] = true;
                     }

                     var13 = (field1974[var7] + field1974[var8] + field1974[var9]) / 3 + this.field1995;
                     field1968[var13][field1979[var13]++] = var6;
                  }
               } else {
                  var13 = field1975[var7];
                  var14 = field1975[var8];
                  var15 = field1975[var9];
                  var16 = field1964[var7];
                  var17 = field1964[var8];
                  int var18 = field1964[var9];
                  int var19 = field1993[var7];
                  int var20 = field1993[var8];
                  int var21 = field1993[var9];
                  var13 -= var14;
                  var15 -= var14;
                  var16 -= var17;
                  var18 -= var17;
                  var19 -= var20;
                  var21 -= var20;
                  int var22 = var16 * var21 - var19 * var18;
                  int var23 = var19 * var15 - var13 * var21;
                  int var24 = var13 * var18 - var16 * var15;
                  if(var14 * var22 + var17 * var23 + var20 * var24 > 0) {
                     field1971[var6] = true;
                     int var25 = (field1974[var7] + field1974[var8] + field1974[var9]) / 3 + this.field1995;
                     field1968[var25][field1979[var25]++] = var6;
                  }
               }
            }
         }

         int[] var27;
         if(this.field1946 == null) {
            for(var6 = this.field1961 - 1; var6 >= 0; --var6) {
               var7 = field1979[var6];
               if(var7 > 0) {
                  var27 = field1968[var6];

                  for(var9 = 0; var9 < var7; ++var9) {
                     this.method2567(var27[var9]);
                  }
               }
            }

         } else {
            for(var6 = 0; var6 < 12; ++var6) {
               field1981[var6] = 0;
               field1945[var6] = 0;
            }

            for(var6 = this.field1961 - 1; var6 >= 0; --var6) {
               var7 = field1979[var6];
               if(var7 > 0) {
                  var27 = field1968[var6];

                  for(var9 = 0; var9 < var7; ++var9) {
                     var10 = var27[var9];
                     byte var30 = this.field1946[var10];
                     var12 = field1981[var30]++;
                     field1982[var30][var12] = var10;
                     if(var30 < 10) {
                        field1945[var30] += var6;
                     } else if(var30 == 10) {
                        field1983[var12] = var6;
                     } else {
                        field1965[var12] = var6;
                     }
                  }
               }
            }

            var6 = 0;
            if(field1981[1] > 0 || field1981[2] > 0) {
               var6 = (field1945[1] + field1945[2]) / (field1981[1] + field1981[2]);
            }

            var7 = 0;
            if(field1981[3] > 0 || field1981[4] > 0) {
               var7 = (field1945[3] + field1945[4]) / (field1981[3] + field1981[4]);
            }

            var8 = 0;
            if(field1981[6] > 0 || field1981[8] > 0) {
               var8 = (field1945[6] + field1945[8]) / (field1981[6] + field1981[8]);
            }

            var10 = 0;
            var11 = field1981[10];
            int[] var28 = field1982[10];
            int[] var26 = field1983;
            if(var10 == var11) {
               var10 = 0;
               var11 = field1981[11];
               var28 = field1982[11];
               var26 = field1965;
            }

            if(var10 < var11) {
               var9 = var26[var10];
            } else {
               var9 = -1000;
            }

            for(var14 = 0; var14 < 10; ++var14) {
               while(var14 == 0 && var9 > var6) {
                  this.method2567(var28[var10++]);
                  if(var10 == var11 && var28 != field1982[11]) {
                     var10 = 0;
                     var11 = field1981[11];
                     var28 = field1982[11];
                     var26 = field1965;
                  }

                  if(var10 < var11) {
                     var9 = var26[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 3 && var9 > var7) {
                  this.method2567(var28[var10++]);
                  if(var10 == var11 && var28 != field1982[11]) {
                     var10 = 0;
                     var11 = field1981[11];
                     var28 = field1982[11];
                     var26 = field1965;
                  }

                  if(var10 < var11) {
                     var9 = var26[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 5 && var9 > var8) {
                  this.method2567(var28[var10++]);
                  if(var10 == var11 && var28 != field1982[11]) {
                     var10 = 0;
                     var11 = field1981[11];
                     var28 = field1982[11];
                     var26 = field1965;
                  }

                  if(var10 < var11) {
                     var9 = var26[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               var15 = field1981[var14];
               int[] var29 = field1982[var14];

               for(var17 = 0; var17 < var15; ++var17) {
                  this.method2567(var29[var17]);
               }
            }

            while(var9 != -1000) {
               this.method2567(var28[var10++]);
               if(var10 == var11 && var28 != field1982[11]) {
                  var10 = 0;
                  var28 = field1982[11];
                  var11 = field1981[11];
                  var26 = field1965;
               }

               if(var10 < var11) {
                  var9 = var26[var10];
               } else {
                  var9 = -1000;
               }
            }

         }
      }
   }

   @ObfuscatedName("f")
   Model method2532(boolean var1, Model var2, byte[] var3) {
      var2.field1955 = this.field1955;
      var2.field1939 = this.field1939;
      var2.field1951 = this.field1951;
      if(var2.verticesX == null || var2.verticesX.length < this.field1955) {
         var2.verticesX = new int[this.field1955 + 100];
         var2.verticesY = new int[this.field1955 + 100];
         var2.verticesZ = new int[this.field1955 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1955; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if(var1) {
         var2.field1985 = this.field1985;
      } else {
         var2.field1985 = var3;
         if(this.field1985 == null) {
            for(var4 = 0; var4 < this.field1939; ++var4) {
               var2.field1985[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1939; ++var4) {
               var2.field1985[var4] = this.field1985[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1943 = this.field1943;
      var2.field1976 = this.field1976;
      var2.field1947 = this.field1947;
      var2.field1946 = this.field1946;
      var2.field1948 = this.field1948;
      var2.field1949 = this.field1949;
      var2.field1950 = this.field1950;
      var2.field1952 = this.field1952;
      var2.field1977 = this.field1977;
      var2.field1954 = this.field1954;
      var2.field1940 = this.field1940;
      var2.field1956 = this.field1956;
      var2.field1957 = this.field1957;
      var2.method2518();
      return var2;
   }

   @ObfuscatedName("cd")
   void vmethod2870(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1979[0] = -1;
      if(this.field1958 != 1) {
         this.method2515();
      }

      this.method2514(var1);
      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1960 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1960) * class136.field2028;
         if(var15 / var13 < class136.field2026) {
            int var16 = (var14 + this.field1960) * class136.field2028;
            if(var16 / var13 > class136.field2033) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1960 * var2 >> 16;
               int var19 = (var17 + var18) * class136.field2028;
               if(var19 / var13 > class136.field2035) {
                  int var20 = var18 + (super.modelHeight * var3 >> 16);
                  int var21 = (var17 - var20) * class136.field2028;
                  if(var21 / var13 < class136.field2038) {
                     int var22 = var12 + (super.modelHeight * var2 >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1951 > 0;
                     int var26 = class18.method157();
                     int var27 = class134.field2003;
                     boolean var29 = class168.method3121();
                     if(class7.field231 && var9 > 0) {
                        if(Frames.method2882(this, var6, var7, var8)) {
                           WidgetNode.method1067(this, var6, var7, var8, -65281);
                        } else if(class7.field234 == class11.field266) {
                           WidgetNode.method1067(this, var6, var7, var8, -16776961);
                        }
                     }

                     int var31;
                     int var32;
                     int var33;
                     int var34;
                     int var35;
                     int var36;
                     int var37;
                     if(class7.field232 && var9 > 0) {
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
                        var36 = var26 - class136.field2029;
                        var37 = var27 - class136.field2030;
                        if(var36 > var31 && var36 < var32 && var37 > var33 && var37 < var34) {
                           var35 = -256;
                        }

                        class28.method251(var31 + class136.field2029, var33 + class136.field2030, var32 + class136.field2029, var34 + class136.field2030, var35);
                     }

                     boolean var44 = false;
                     if(var9 > 0 && var29) {
                        boolean var43 = false;
                        if(field1944) {
                           var43 = Frames.method2882(this, var6, var7, var8);
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

                           var33 = var26 - class136.field2029;
                           var34 = var27 - class136.field2030;
                           if(var33 > var15 && var33 < var16 && var34 > var21 && var34 < var19) {
                              var43 = true;
                           }
                        }

                        if(var43) {
                           if(this.field1957) {
                              class134.field2002[++class134.field2009 - 1] = var9;
                           } else {
                              var44 = true;
                           }
                        }
                     }

                     var31 = class136.field2029;
                     var32 = class136.field2030;
                     var33 = 0;
                     var34 = 0;
                     if(var1 != 0) {
                        var33 = field1931[var1];
                        var34 = field1996[var1];
                     }

                     for(var35 = 0; var35 < this.field1955; ++var35) {
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
                        field1974[var35] = var38 - var11;
                        if(var38 >= 50) {
                           field1972[var35] = var31 + var36 * class136.field2028 / var38;
                           field1973[var35] = var32 + var39 * class136.field2028 / var38;
                        } else {
                           field1972[var35] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1975[var35] = var36;
                           field1964[var35] = var39;
                           field1993[var35] = var38;
                        }
                     }

                     try {
                        this.method2531(var23, var44, this.field1957, var9);
                     } catch (Exception var42) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   static {
      field1963 = new Model();
      field1938 = new byte[1];
      field1997 = new Model();
      field1978 = new byte[1];
      field1970 = new boolean[4700];
      field1971 = new boolean[4700];
      field1972 = new int[4700];
      field1973 = new int[4700];
      field1974 = new int[4700];
      field1975 = new int[4700];
      field1964 = new int[4700];
      field1993 = new int[4700];
      field1979 = new int[1600];
      field1968 = new int[1600][512];
      field1981 = new int[12];
      field1982 = new int[12][2000];
      field1983 = new int[2000];
      field1965 = new int[2000];
      field1945 = new int[12];
      field1986 = new int[10];
      field1987 = new int[10];
      field1988 = new int[10];
      field1944 = true;
      field1931 = class136.SINE;
      field1996 = class136.COSINE;
      field1984 = class136.colorPalette;
      field1934 = class136.field2041;
   }

   @ObfuscatedName("e")
   public void method2536(Frames var1, int var2) {
      if(this.field1940 != null) {
         if(var2 != -1) {
            Frame var3 = var1.field2148[var2];
            FrameMap var4 = var3.field1900;
            field1989 = 0;
            field1990 = 0;
            field1991 = 0;

            for(int var5 = 0; var5 < var3.field1901; ++var5) {
               int var6 = var3.field1902[var5];
               this.method2521(var4.field2055[var6], var4.field2057[var6], var3.translator_x[var5], var3.translator_y[var5], var3.translator_z[var5]);
            }

            this.method2518();
         }
      }
   }

   @ObfuscatedName("n")
   public Model method2545(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2515();
      int var7 = var2 - this.field1960;
      int var8 = var2 + this.field1960;
      int var9 = var4 - this.field1960;
      int var10 = var4 + this.field1960;
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
               var11.field1955 = this.field1955;
               var11.field1939 = this.field1939;
               var11.field1951 = this.field1951;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1943 = this.field1943;
               var11.field1976 = this.field1976;
               var11.field1947 = this.field1947;
               var11.field1946 = this.field1946;
               var11.field1985 = this.field1985;
               var11.field1948 = this.field1948;
               var11.field1949 = this.field1949;
               var11.field1950 = this.field1950;
               var11.field1952 = this.field1952;
               var11.field1977 = this.field1977;
               var11.field1954 = this.field1954;
               var11.field1940 = this.field1940;
               var11.field1956 = this.field1956;
               var11.field1957 = this.field1957;
               var11.verticesY = new int[var11.field1955];
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
               for(var12 = 0; var12 < var11.field1955; ++var12) {
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
               for(var12 = 0; var12 < var11.field1955; ++var12) {
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

            var11.method2518();
            return var11;
         }
      } else {
         return this;
      }
   }

   Model() {
      this.field1955 = 0;
      this.field1939 = 0;
      this.field1950 = 0;
      this.field1951 = 0;
      this.field1957 = false;
      this.field1966 = -1;
      this.field1967 = -1;
      this.field1953 = -1;
   }

   @ObfuscatedName("an")
   final void method2559(int var1) {
      int var2 = class136.field2029;
      int var3 = class136.field2030;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1993[var5];
      int var9 = field1993[var6];
      int var10 = field1993[var7];
      if(this.field1985 == null) {
         class136.rasterAlpha = 0;
      } else {
         class136.rasterAlpha = this.field1985[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1986[var4] = field1972[var5];
         field1987[var4] = field1973[var5];
         field1988[var4++] = this.field1943[var1];
      } else {
         var11 = field1975[var5];
         var12 = field1964[var5];
         var13 = this.field1943[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1934[var10 - var8];
            field1986[var4] = var2 + (var11 + ((field1975[var7] - var11) * var14 >> 16)) * class136.field2028 / 50;
            field1987[var4] = var3 + (var12 + ((field1964[var7] - var12) * var14 >> 16)) * class136.field2028 / 50;
            field1988[var4++] = var13 + ((this.field1947[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1934[var9 - var8];
            field1986[var4] = var2 + (var11 + ((field1975[var6] - var11) * var14 >> 16)) * class136.field2028 / 50;
            field1987[var4] = var3 + (var12 + ((field1964[var6] - var12) * var14 >> 16)) * class136.field2028 / 50;
            field1988[var4++] = var13 + ((this.field1976[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1986[var4] = field1972[var6];
         field1987[var4] = field1973[var6];
         field1988[var4++] = this.field1976[var1];
      } else {
         var11 = field1975[var6];
         var12 = field1964[var6];
         var13 = this.field1976[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1934[var8 - var9];
            field1986[var4] = var2 + (var11 + ((field1975[var5] - var11) * var14 >> 16)) * class136.field2028 / 50;
            field1987[var4] = var3 + (var12 + ((field1964[var5] - var12) * var14 >> 16)) * class136.field2028 / 50;
            field1988[var4++] = var13 + ((this.field1943[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1934[var10 - var9];
            field1986[var4] = var2 + (var11 + ((field1975[var7] - var11) * var14 >> 16)) * class136.field2028 / 50;
            field1987[var4] = var3 + (var12 + ((field1964[var7] - var12) * var14 >> 16)) * class136.field2028 / 50;
            field1988[var4++] = var13 + ((this.field1947[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1986[var4] = field1972[var7];
         field1987[var4] = field1973[var7];
         field1988[var4++] = this.field1947[var1];
      } else {
         var11 = field1975[var7];
         var12 = field1964[var7];
         var13 = this.field1947[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1934[var9 - var10];
            field1986[var4] = var2 + (var11 + ((field1975[var6] - var11) * var14 >> 16)) * class136.field2028 / 50;
            field1987[var4] = var3 + (var12 + ((field1964[var6] - var12) * var14 >> 16)) * class136.field2028 / 50;
            field1988[var4++] = var13 + ((this.field1976[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1934[var8 - var10];
            field1986[var4] = var2 + (var11 + ((field1975[var5] - var11) * var14 >> 16)) * class136.field2028 / 50;
            field1987[var4] = var3 + (var12 + ((field1964[var5] - var12) * var14 >> 16)) * class136.field2028 / 50;
            field1988[var4++] = var13 + ((this.field1943[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1986[0];
      var12 = field1986[1];
      var13 = field1986[2];
      var14 = field1987[0];
      int var15 = field1987[1];
      int var16 = field1987[2];
      class136.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class136.rasterClipX || var12 > class136.rasterClipX || var13 > class136.rasterClipX) {
            class136.rasterClipEnable = true;
         }

         if(this.field1949 != null && this.field1949[var1] != -1) {
            if(this.field1948 != null && this.field1948[var1] != -1) {
               var20 = this.field1948[var1] & 255;
               var17 = this.field1952[var20];
               var18 = this.field1977[var20];
               var19 = this.field1954[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1947[var1] == -1) {
               class136.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1943[var1], this.field1943[var1], this.field1943[var1], field1975[var17], field1975[var18], field1975[var19], field1964[var17], field1964[var18], field1964[var19], field1993[var17], field1993[var18], field1993[var19], this.field1949[var1]);
            } else {
               class136.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1988[0], field1988[1], field1988[2], field1975[var17], field1975[var18], field1975[var19], field1964[var17], field1964[var18], field1964[var19], field1993[var17], field1993[var18], field1993[var19], this.field1949[var1]);
            }
         } else if(this.field1947[var1] == -1) {
            class136.rasterFlat(var14, var15, var16, var11, var12, var13, field1984[this.field1943[var1]]);
         } else {
            class136.rasterGouraud(var14, var15, var16, var11, var12, var13, field1988[0], field1988[1], field1988[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class136.rasterClipX || var12 > class136.rasterClipX || var13 > class136.rasterClipX || field1986[3] < 0 || field1986[3] > class136.rasterClipX) {
            class136.rasterClipEnable = true;
         }

         if(this.field1949 != null && this.field1949[var1] != -1) {
            if(this.field1948 != null && this.field1948[var1] != -1) {
               var20 = this.field1948[var1] & 255;
               var17 = this.field1952[var20];
               var18 = this.field1977[var20];
               var19 = this.field1954[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1949[var1];
            if(this.field1947[var1] == -1) {
               class136.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1943[var1], this.field1943[var1], this.field1943[var1], field1975[var17], field1975[var18], field1975[var19], field1964[var17], field1964[var18], field1964[var19], field1993[var17], field1993[var18], field1993[var19], var21);
               class136.rasterTextureAffine(var14, var16, field1987[3], var11, var13, field1986[3], this.field1943[var1], this.field1943[var1], this.field1943[var1], field1975[var17], field1975[var18], field1975[var19], field1964[var17], field1964[var18], field1964[var19], field1993[var17], field1993[var18], field1993[var19], var21);
            } else {
               class136.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1988[0], field1988[1], field1988[2], field1975[var17], field1975[var18], field1975[var19], field1964[var17], field1964[var18], field1964[var19], field1993[var17], field1993[var18], field1993[var19], var21);
               class136.rasterTextureAffine(var14, var16, field1987[3], var11, var13, field1986[3], field1988[0], field1988[2], field1988[3], field1975[var17], field1975[var18], field1975[var19], field1964[var17], field1964[var18], field1964[var19], field1993[var17], field1993[var18], field1993[var19], var21);
            }
         } else if(this.field1947[var1] == -1) {
            var17 = field1984[this.field1943[var1]];
            class136.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            class136.rasterFlat(var14, var16, field1987[3], var11, var13, field1986[3], var17);
         } else {
            class136.rasterGouraud(var14, var15, var16, var11, var12, var13, field1988[0], field1988[1], field1988[2]);
            class136.rasterGouraud(var14, var16, field1987[3], var11, var13, field1986[3], field1988[0], field1988[2], field1988[3]);
         }
      }

   }

   @ObfuscatedName("aw")
   final void method2567(int var1) {
      if(field1971[var1]) {
         this.method2559(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         class136.rasterClipEnable = field1970[var1];
         if(this.field1985 == null) {
            class136.rasterAlpha = 0;
         } else {
            class136.rasterAlpha = this.field1985[var1] & 255;
         }

         if(this.field1949 != null && this.field1949[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1948 != null && this.field1948[var1] != -1) {
               int var8 = this.field1948[var1] & 255;
               var5 = this.field1952[var8];
               var6 = this.field1977[var8];
               var7 = this.field1954[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1947[var1] == -1) {
               class136.rasterTextureAffine(field1973[var2], field1973[var3], field1973[var4], field1972[var2], field1972[var3], field1972[var4], this.field1943[var1], this.field1943[var1], this.field1943[var1], field1975[var5], field1975[var6], field1975[var7], field1964[var5], field1964[var6], field1964[var7], field1993[var5], field1993[var6], field1993[var7], this.field1949[var1]);
            } else {
               class136.rasterTextureAffine(field1973[var2], field1973[var3], field1973[var4], field1972[var2], field1972[var3], field1972[var4], this.field1943[var1], this.field1976[var1], this.field1947[var1], field1975[var5], field1975[var6], field1975[var7], field1964[var5], field1964[var6], field1964[var7], field1993[var5], field1993[var6], field1993[var7], this.field1949[var1]);
            }
         } else if(this.field1947[var1] == -1) {
            class136.rasterFlat(field1973[var2], field1973[var3], field1973[var4], field1972[var2], field1972[var3], field1972[var4], field1984[this.field1943[var1]]);
         } else {
            class136.rasterGouraud(field1973[var2], field1973[var3], field1973[var4], field1972[var2], field1972[var3], field1972[var4], this.field1943[var1], this.field1976[var1], this.field1947[var1]);
         }

      }
   }
}
