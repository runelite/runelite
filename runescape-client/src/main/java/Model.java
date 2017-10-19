import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("aj")
   static boolean[] field1919;
   @ObfuscatedName("ai")
   static int[] field1958;
   @ObfuscatedName("bc")
   static int[] field1974;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Leh;"
   )
   static Model field1912;
   @ObfuscatedName("o")
   static byte[] field1971;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Leh;"
   )
   static Model field1923;
   @ObfuscatedName("bv")
   static int field1960;
   @ObfuscatedName("s")
   static byte[] field1911;
   @ObfuscatedName("bd")
   static int[] field1975;
   @ObfuscatedName("bi")
   static int field1969;
   @ObfuscatedName("bz")
   static int field1970;
   @ObfuscatedName("ar")
   static int[] field1968;
   @ObfuscatedName("ab")
   static boolean[] field1950;
   @ObfuscatedName("an")
   static int[] field1942;
   @ObfuscatedName("bf")
   static int[] field1931;
   @ObfuscatedName("ac")
   static int[] field1951;
   @ObfuscatedName("au")
   static int[][] field1959;
   @ObfuscatedName("ad")
   static int[] field1952;
   @ObfuscatedName("bw")
   static int[] field1965;
   @ObfuscatedName("ah")
   @Export("yViewportBuffer")
   static int[] yViewportBuffer;
   @ObfuscatedName("am")
   static int[] field1914;
   @ObfuscatedName("ak")
   static int[] field1917;
   @ObfuscatedName("bs")
   static int[] field1966;
   @ObfuscatedName("bq")
   static int[] field1976;
   @ObfuscatedName("bp")
   @Export("xViewportBuffer")
   static int[] xViewportBuffer;
   @ObfuscatedName("as")
   static int[][] field1961;
   @ObfuscatedName("br")
   static int[] field1910;
   @ObfuscatedName("bj")
   static int[] field1930;
   @ObfuscatedName("bo")
   static int[] field1962;
   @ObfuscatedName("bn")
   static boolean field1953;
   @ObfuscatedName("aw")
   int field1940;
   @ObfuscatedName("ax")
   public int field1964;
   @ObfuscatedName("af")
   int field1937;
   @ObfuscatedName("l")
   int[][] field1934;
   @ObfuscatedName("g")
   int field1977;
   @ObfuscatedName("at")
   public int field1967;
   @ObfuscatedName("x")
   @Export("indices1")
   int[] indices1;
   @ObfuscatedName("ay")
   @Export("XYZMag")
   int XYZMag;
   @ObfuscatedName("d")
   int field1963;
   @ObfuscatedName("v")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("e")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("z")
   @Export("indices2")
   int[] indices2;
   @ObfuscatedName("f")
   int[][] field1935;
   @ObfuscatedName("y")
   byte field1929;
   @ObfuscatedName("n")
   @Export("indices3")
   int[] indices3;
   @ObfuscatedName("aa")
   int field1938;
   @ObfuscatedName("k")
   int field1924;
   @ObfuscatedName("p")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("h")
   byte[] field1926;
   @ObfuscatedName("ao")
   public int field1943;
   @ObfuscatedName("u")
   int[] field1918;
   @ObfuscatedName("i")
   byte[] field1925;
   @ObfuscatedName("a")
   int[] field1933;
   @ObfuscatedName("av")
   public int field1946;
   @ObfuscatedName("ap")
   public boolean field1936;
   @ObfuscatedName("t")
   int[] field1913;
   @ObfuscatedName("aq")
   public int field1944;
   @ObfuscatedName("az")
   int field1941;
   @ObfuscatedName("al")
   public int field1947;
   @ObfuscatedName("j")
   short[] field1928;
   @ObfuscatedName("b")
   byte[] field1927;
   @ObfuscatedName("c")
   int[] field1949;
   @ObfuscatedName("r")
   int[] field1932;
   @ObfuscatedName("m")
   int[] field1922;

   static {
      field1923 = new Model();
      field1911 = new byte[1];
      field1912 = new Model();
      field1971 = new byte[1];
      field1950 = new boolean[4700];
      field1919 = new boolean[4700];
      field1951 = new int[4700];
      field1952 = new int[4700];
      field1914 = new int[4700];
      yViewportBuffer = new int[4700];
      field1917 = new int[4700];
      field1968 = new int[4700];
      field1958 = new int[1600];
      field1959 = new int[1600][512];
      field1942 = new int[12];
      field1961 = new int[12][2000];
      field1910 = new int[2000];
      field1930 = new int[2000];
      field1931 = new int[12];
      field1965 = new int[10];
      field1966 = new int[10];
      xViewportBuffer = new int[10];
      field1953 = true;
      field1974 = Graphics3D.SINE;
      field1975 = Graphics3D.COSINE;
      field1962 = Graphics3D.colorPalette;
      field1976 = Graphics3D.field2022;
   }

   Model() {
      this.field1977 = 0;
      this.field1963 = 0;
      this.field1929 = 0;
      this.field1924 = 0;
      this.field1936 = false;
      this.field1964 = -1;
      this.field1946 = -1;
      this.field1947 = -1;
   }

   @ObfuscatedSignature(
      signature = "([Leh;I)V"
   )
   public Model(Model[] var1, int var2) {
      this.field1977 = 0;
      this.field1963 = 0;
      this.field1929 = 0;
      this.field1924 = 0;
      this.field1936 = false;
      this.field1964 = -1;
      this.field1946 = -1;
      this.field1947 = -1;
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1977 = 0;
      this.field1963 = 0;
      this.field1924 = 0;
      this.field1929 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1977 += var8.field1977;
            this.field1963 += var8.field1963;
            this.field1924 += var8.field1924;
            if(var8.field1925 != null) {
               var3 = true;
            } else {
               if(this.field1929 == -1) {
                  this.field1929 = var8.field1929;
               }

               if(this.field1929 != var8.field1929) {
                  var3 = true;
               }
            }

            var4 |= var8.field1926 != null;
            var5 |= var8.field1928 != null;
            var6 |= var8.field1927 != null;
         }
      }

      this.verticesX = new int[this.field1977];
      this.verticesY = new int[this.field1977];
      this.verticesZ = new int[this.field1977];
      this.indices1 = new int[this.field1963];
      this.indices2 = new int[this.field1963];
      this.indices3 = new int[this.field1963];
      this.field1918 = new int[this.field1963];
      this.field1913 = new int[this.field1963];
      this.field1933 = new int[this.field1963];
      if(var3) {
         this.field1925 = new byte[this.field1963];
      }

      if(var4) {
         this.field1926 = new byte[this.field1963];
      }

      if(var5) {
         this.field1928 = new short[this.field1963];
      }

      if(var6) {
         this.field1927 = new byte[this.field1963];
      }

      if(this.field1924 > 0) {
         this.field1949 = new int[this.field1924];
         this.field1932 = new int[this.field1924];
         this.field1922 = new int[this.field1924];
      }

      this.field1977 = 0;
      this.field1963 = 0;
      this.field1924 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1963; ++var9) {
               this.indices1[this.field1963] = this.field1977 + var8.indices1[var9];
               this.indices2[this.field1963] = this.field1977 + var8.indices2[var9];
               this.indices3[this.field1963] = this.field1977 + var8.indices3[var9];
               this.field1918[this.field1963] = var8.field1918[var9];
               this.field1913[this.field1963] = var8.field1913[var9];
               this.field1933[this.field1963] = var8.field1933[var9];
               if(var3) {
                  if(var8.field1925 != null) {
                     this.field1925[this.field1963] = var8.field1925[var9];
                  } else {
                     this.field1925[this.field1963] = var8.field1929;
                  }
               }

               if(var4 && var8.field1926 != null) {
                  this.field1926[this.field1963] = var8.field1926[var9];
               }

               if(var5) {
                  if(var8.field1928 != null) {
                     this.field1928[this.field1963] = var8.field1928[var9];
                  } else {
                     this.field1928[this.field1963] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1927 != null && var8.field1927[var9] != -1) {
                     this.field1927[this.field1963] = (byte)(this.field1924 + var8.field1927[var9]);
                  } else {
                     this.field1927[this.field1963] = -1;
                  }
               }

               ++this.field1963;
            }

            for(var9 = 0; var9 < var8.field1924; ++var9) {
               this.field1949[this.field1924] = this.field1977 + var8.field1949[var9];
               this.field1932[this.field1924] = this.field1977 + var8.field1932[var9];
               this.field1922[this.field1924] = this.field1977 + var8.field1922[var9];
               ++this.field1924;
            }

            for(var9 = 0; var9 < var8.field1977; ++var9) {
               this.verticesX[this.field1977] = var8.verticesX[var9];
               this.verticesY[this.field1977] = var8.verticesY[var9];
               this.verticesZ[this.field1977] = var8.verticesZ[var9];
               ++this.field1977;
            }
         }
      }

   }

   @ObfuscatedName("p")
   public void method2558() {
      if(this.field1937 != 1) {
         this.field1937 = 1;
         super.modelHeight = 0;
         this.field1938 = 0;
         this.XYZMag = 0;

         for(int var1 = 0; var1 < this.field1977; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1938) {
               this.field1938 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.XYZMag) {
               this.XYZMag = var5;
            }
         }

         this.XYZMag = (int)(Math.sqrt((double)this.XYZMag) + 0.99D);
         this.field1941 = (int)(Math.sqrt((double)(this.XYZMag * this.XYZMag + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1940 = this.field1941 + (int)(Math.sqrt((double)(this.XYZMag * this.XYZMag + this.field1938 * this.field1938)) + 0.99D);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Leo;I)V"
   )
   public void method2625(Frames var1, int var2) {
      if(this.field1934 != null) {
         if(var2 != -1) {
            Frame var3 = var1.skeletons[var2];
            FrameMap var4 = var3.skin;
            field1960 = 0;
            field1969 = 0;
            field1970 = 0;

            for(int var5 = 0; var5 < var3.field1880; ++var5) {
               int var6 = var3.field1881[var5];
               this.method2555(var4.types[var6], var4.list[var6], var3.translator_x[var5], var3.translator_y[var5], var3.translator_z[var5]);
            }

            this.method2561();
         }
      }
   }

   @ObfuscatedName("x")
   void method2561() {
      this.field1937 = 0;
      this.field1964 = -1;
   }

   @ObfuscatedName("az")
   final void method2604(int var1) {
      int var2 = Graphics3D.centerX;
      int var3 = Graphics3D.centerY;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1968[var5];
      int var9 = field1968[var6];
      int var10 = field1968[var7];
      if(this.field1926 == null) {
         Graphics3D.rasterAlpha = 0;
      } else {
         Graphics3D.rasterAlpha = this.field1926[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1965[var4] = field1951[var5];
         field1966[var4] = field1952[var5];
         xViewportBuffer[var4++] = this.field1918[var1];
      } else {
         var11 = yViewportBuffer[var5];
         var12 = field1917[var5];
         var13 = this.field1918[var1];
         if(var10 >= 50) {
            var14 = field1976[var10 - var8] * (50 - var8);
            field1965[var4] = var2 + Graphics3D.field2009 * (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) / 50;
            field1966[var4] = var3 + Graphics3D.field2009 * (var12 + ((field1917[var7] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1933[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = field1976[var9 - var8] * (50 - var8);
            field1965[var4] = var2 + Graphics3D.field2009 * (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) / 50;
            field1966[var4] = var3 + Graphics3D.field2009 * (var12 + ((field1917[var6] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1913[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1965[var4] = field1951[var6];
         field1966[var4] = field1952[var6];
         xViewportBuffer[var4++] = this.field1913[var1];
      } else {
         var11 = yViewportBuffer[var6];
         var12 = field1917[var6];
         var13 = this.field1913[var1];
         if(var8 >= 50) {
            var14 = field1976[var8 - var9] * (50 - var9);
            field1965[var4] = var2 + Graphics3D.field2009 * (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) / 50;
            field1966[var4] = var3 + Graphics3D.field2009 * (var12 + ((field1917[var5] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1918[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = field1976[var10 - var9] * (50 - var9);
            field1965[var4] = var2 + Graphics3D.field2009 * (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) / 50;
            field1966[var4] = var3 + Graphics3D.field2009 * (var12 + ((field1917[var7] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1933[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1965[var4] = field1951[var7];
         field1966[var4] = field1952[var7];
         xViewportBuffer[var4++] = this.field1933[var1];
      } else {
         var11 = yViewportBuffer[var7];
         var12 = field1917[var7];
         var13 = this.field1933[var1];
         if(var9 >= 50) {
            var14 = field1976[var9 - var10] * (50 - var10);
            field1965[var4] = var2 + Graphics3D.field2009 * (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) / 50;
            field1966[var4] = var3 + Graphics3D.field2009 * (var12 + ((field1917[var6] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1913[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = field1976[var8 - var10] * (50 - var10);
            field1965[var4] = var2 + Graphics3D.field2009 * (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) / 50;
            field1966[var4] = var3 + Graphics3D.field2009 * (var12 + ((field1917[var5] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1918[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1965[0];
      var12 = field1965[1];
      var13 = field1965[2];
      var14 = field1966[0];
      int var15 = field1966[1];
      int var16 = field1966[2];
      Graphics3D.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX) {
            Graphics3D.rasterClipEnable = true;
         }

         if(this.field1928 != null && this.field1928[var1] != -1) {
            if(this.field1927 != null && this.field1927[var1] != -1) {
               var20 = this.field1927[var1] & 255;
               var17 = this.field1949[var20];
               var18 = this.field1932[var20];
               var19 = this.field1922[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1933[var1] == -1) {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1918[var1], this.field1918[var1], this.field1918[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1917[var17], field1917[var18], field1917[var19], field1968[var17], field1968[var18], field1968[var19], this.field1928[var1]);
            } else {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1917[var17], field1917[var18], field1917[var19], field1968[var17], field1968[var18], field1968[var19], this.field1928[var1]);
            }
         } else if(this.field1933[var1] == -1) {
            Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, field1962[this.field1918[var1]]);
         } else {
            Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX || field1965[3] < 0 || field1965[3] > Graphics3D.rasterClipX) {
            Graphics3D.rasterClipEnable = true;
         }

         if(this.field1928 != null && this.field1928[var1] != -1) {
            if(this.field1927 != null && this.field1927[var1] != -1) {
               var20 = this.field1927[var1] & 255;
               var17 = this.field1949[var20];
               var18 = this.field1932[var20];
               var19 = this.field1922[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1928[var1];
            if(this.field1933[var1] == -1) {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1918[var1], this.field1918[var1], this.field1918[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1917[var17], field1917[var18], field1917[var19], field1968[var17], field1968[var18], field1968[var19], var21);
               Graphics3D.rasterTextureAffine(var14, var16, field1966[3], var11, var13, field1965[3], this.field1918[var1], this.field1918[var1], this.field1918[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1917[var17], field1917[var18], field1917[var19], field1968[var17], field1968[var18], field1968[var19], var21);
            } else {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1917[var17], field1917[var18], field1917[var19], field1968[var17], field1968[var18], field1968[var19], var21);
               Graphics3D.rasterTextureAffine(var14, var16, field1966[3], var11, var13, field1965[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1917[var17], field1917[var18], field1917[var19], field1968[var17], field1968[var18], field1968[var19], var21);
            }
         } else if(this.field1933[var1] == -1) {
            var17 = field1962[this.field1918[var1]];
            Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            Graphics3D.rasterFlat(var14, var16, field1966[3], var11, var13, field1965[3], var17);
         } else {
            Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
            Graphics3D.rasterGouraud(var14, var16, field1966[3], var11, var13, field1965[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3]);
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ZLeh;[B)Leh;"
   )
   Model method2556(boolean var1, Model var2, byte[] var3) {
      var2.field1977 = this.field1977;
      var2.field1963 = this.field1963;
      var2.field1924 = this.field1924;
      if(var2.verticesX == null || var2.verticesX.length < this.field1977) {
         var2.verticesX = new int[this.field1977 + 100];
         var2.verticesY = new int[this.field1977 + 100];
         var2.verticesZ = new int[this.field1977 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1977; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if(var1) {
         var2.field1926 = this.field1926;
      } else {
         var2.field1926 = var3;
         if(this.field1926 == null) {
            for(var4 = 0; var4 < this.field1963; ++var4) {
               var2.field1926[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1963; ++var4) {
               var2.field1926[var4] = this.field1926[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1918 = this.field1918;
      var2.field1913 = this.field1913;
      var2.field1933 = this.field1933;
      var2.field1925 = this.field1925;
      var2.field1927 = this.field1927;
      var2.field1928 = this.field1928;
      var2.field1929 = this.field1929;
      var2.field1949 = this.field1949;
      var2.field1932 = this.field1932;
      var2.field1922 = this.field1922;
      var2.field1934 = this.field1934;
      var2.field1935 = this.field1935;
      var2.field1936 = this.field1936;
      var2.method2561();
      return var2;
   }

   @ObfuscatedName("v")
   void method2557(int var1) {
      if(this.field1964 == -1) {
         int var2 = 0;
         int var3 = 0;
         int var4 = 0;
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         int var8 = field1975[var1];
         int var9 = field1974[var1];

         for(int var10 = 0; var10 < this.field1977; ++var10) {
            int var11 = Graphics3D.method2659(this.verticesX[var10], this.verticesZ[var10], var8, var9);
            int var12 = this.verticesY[var10];
            int var13 = Graphics3D.method2674(this.verticesX[var10], this.verticesZ[var10], var8, var9);
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

         this.field1967 = (var5 + var2) / 2;
         this.field1943 = (var6 + var3) / 2;
         this.field1944 = (var7 + var4) / 2;
         this.field1964 = (var5 - var2 + 1) / 2;
         this.field1946 = (var6 - var3 + 1) / 2;
         this.field1947 = (var7 - var4 + 1) / 2;
         if(this.field1964 < 32) {
            this.field1964 = 32;
         }

         if(this.field1947 < 32) {
            this.field1947 = 32;
         }

         if(this.field1936) {
            this.field1964 += 8;
            this.field1947 += 8;
         }

      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Z)Leh;"
   )
   public Model method2628(boolean var1) {
      if(!var1 && field1911.length < this.field1963) {
         field1911 = new byte[this.field1963 + 100];
      }

      return this.method2556(var1, field1923, field1911);
   }

   @ObfuscatedName("e")
   void method2559() {
      if(this.field1937 != 2) {
         this.field1937 = 2;
         this.XYZMag = 0;

         for(int var1 = 0; var1 < this.field1977; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.XYZMag) {
               this.XYZMag = var5;
            }
         }

         this.XYZMag = (int)(Math.sqrt((double)this.XYZMag) + 0.99D);
         this.field1941 = this.XYZMag;
         this.field1940 = this.XYZMag + this.XYZMag;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Z)Leh;"
   )
   public Model method2629(boolean var1) {
      if(!var1 && field1971.length < this.field1963) {
         field1971 = new byte[this.field1963 + 100];
      }

      return this.method2556(var1, field1912, field1971);
   }

   @ObfuscatedName("l")
   public void method2582(int var1) {
      int var2 = field1974[var1];
      int var3 = field1975[var1];

      for(int var4 = 0; var4 < this.field1977; ++var4) {
         int var5 = var3 * this.verticesY[var4] - var2 * this.verticesZ[var4] >> 16;
         this.verticesZ[var4] = var2 * this.verticesY[var4] + var3 * this.verticesZ[var4] >> 16;
         this.verticesY[var4] = var5;
      }

      this.method2561();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([[IIIIZI)Leh;"
   )
   public Model method2579(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2558();
      int var7 = var2 - this.XYZMag;
      int var8 = var2 + this.XYZMag;
      int var9 = var4 - this.XYZMag;
      int var10 = var4 + this.XYZMag;
      if(var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
         var7 >>= 7;
         var8 = var8 + 127 >> 7;
         var9 >>= 7;
         var10 = var10 + 127 >> 7;
         if(var3 == var1[var7][var9] && var3 == var1[var8][var9] && var3 == var1[var7][var10] && var3 == var1[var8][var10]) {
            return this;
         } else {
            Model var11;
            if(var5) {
               var11 = new Model();
               var11.field1977 = this.field1977;
               var11.field1963 = this.field1963;
               var11.field1924 = this.field1924;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1918 = this.field1918;
               var11.field1913 = this.field1913;
               var11.field1933 = this.field1933;
               var11.field1925 = this.field1925;
               var11.field1926 = this.field1926;
               var11.field1927 = this.field1927;
               var11.field1928 = this.field1928;
               var11.field1929 = this.field1929;
               var11.field1949 = this.field1949;
               var11.field1932 = this.field1932;
               var11.field1922 = this.field1922;
               var11.field1934 = this.field1934;
               var11.field1935 = this.field1935;
               var11.field1936 = this.field1936;
               var11.verticesY = new int[var11.field1977];
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
               for(var12 = 0; var12 < var11.field1977; ++var12) {
                  var13 = var2 + this.verticesX[var12];
                  var14 = var4 + this.verticesZ[var12];
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var15 * var1[var17 + 1][var18 + 1] >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.verticesY[var12] = var21 + this.verticesY[var12] - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1977; ++var12) {
                  var13 = (-this.verticesY[var12] << 16) / super.modelHeight;
                  if(var13 < var6) {
                     var14 = var2 + this.verticesX[var12];
                     var15 = var4 + this.verticesZ[var12];
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var16 * var1[var18 + 1][var19 + 1] >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.verticesY[var12] = (var6 - var13) * (var22 - var3) / var6 + this.verticesY[var12];
                  }
               }
            }

            var11.method2561();
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("cd")
   @Export("draw")
   void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1958[0] = -1;
      if(this.field1937 != 1) {
         this.method2558();
      }

      this.method2557(var1);
      int var10 = var5 * var8 - var4 * var6 >> 16;
      int var11 = var2 * var7 + var3 * var10 >> 16;
      int var12 = var3 * this.XYZMag >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var5 * var6 >> 16;
         int var15 = (var14 - this.XYZMag) * Graphics3D.field2009;
         if(var15 / var13 < Graphics3D.field2015) {
            int var16 = (var14 + this.XYZMag) * Graphics3D.field2009;
            if(var16 / var13 > Graphics3D.field2014) {
               int var17 = var3 * var7 - var10 * var2 >> 16;
               int var18 = var2 * this.XYZMag >> 16;
               int var19 = (var17 + var18) * Graphics3D.field2009;
               if(var19 / var13 > Graphics3D.field2011) {
                  int var20 = (var3 * super.modelHeight >> 16) + var18;
                  int var21 = (var17 - var20) * Graphics3D.field2009;
                  if(var21 / var13 < Graphics3D.field2017) {
                     int var22 = var12 + (var2 * super.modelHeight >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1924 > 0;
                     int var26 = class132.field1993;
                     int var28 = class132.field1986;
                     boolean var30 = CombatInfoListHolder.method1681();
                     if(class7.field245 && var9 > 0) {
                        CombatInfo2.method4464(this, var6, var7, var8);
                     }

                     int var32;
                     int var33;
                     int var34;
                     int var35;
                     int var36;
                     int var37;
                     int var38;
                     int var39;
                     int var40;
                     if(class7.field238 && var9 > 0) {
                        int var31 = var11 - var12;
                        if(var31 <= 50) {
                           var31 = 50;
                        }

                        if(var14 > 0) {
                           var32 = var15 / var13;
                           var33 = var16 / var31;
                        } else {
                           var33 = var16 / var13;
                           var32 = var15 / var31;
                        }

                        if(var17 > 0) {
                           var34 = var21 / var13;
                           var35 = var19 / var31;
                        } else {
                           var35 = var19 / var13;
                           var34 = var21 / var31;
                        }

                        var36 = -8355840;
                        var37 = var26 - Graphics3D.centerX;
                        var38 = var28 - Graphics3D.centerY;
                        if(var37 > var32 && var37 < var33 && var38 > var34 && var38 < var35) {
                           var36 = -256;
                        }

                        var39 = var32 + Graphics3D.centerX;
                        var40 = var34 + Graphics3D.centerY;
                        int var41 = var33 + Graphics3D.centerX;
                        int var42 = var35 + Graphics3D.centerY;
                        class7.field241.method3651(new class8(var39, var40, var41, var42, var36));
                     }

                     boolean var45 = false;
                     if(var9 > 0 && var30) {
                        boolean var46 = false;
                        if(field1953) {
                           var46 = class244.method4400(this, var6, var7, var8);
                        } else {
                           var33 = var11 - var12;
                           if(var33 <= 50) {
                              var33 = 50;
                           }

                           if(var14 > 0) {
                              var15 /= var13;
                              var16 /= var33;
                           } else {
                              var16 /= var13;
                              var15 /= var33;
                           }

                           if(var17 > 0) {
                              var21 /= var13;
                              var19 /= var33;
                           } else {
                              var19 /= var13;
                              var21 /= var33;
                           }

                           var34 = var26 - Graphics3D.centerX;
                           var35 = var28 - Graphics3D.centerY;
                           if(var34 > var15 && var34 < var16 && var35 > var21 && var35 < var19) {
                              var46 = true;
                           }
                        }

                        if(var46) {
                           if(this.field1936) {
                              class132.field1989[++class132.field1981 - 1] = var9;
                           } else {
                              var45 = true;
                           }
                        }
                     }

                     var32 = Graphics3D.centerX;
                     var33 = Graphics3D.centerY;
                     var34 = 0;
                     var35 = 0;
                     if(var1 != 0) {
                        var34 = field1974[var1];
                        var35 = field1975[var1];
                     }

                     for(var36 = 0; var36 < this.field1977; ++var36) {
                        var37 = this.verticesX[var36];
                        var38 = this.verticesY[var36];
                        var39 = this.verticesZ[var36];
                        if(var1 != 0) {
                           var40 = var39 * var34 + var37 * var35 >> 16;
                           var39 = var39 * var35 - var37 * var34 >> 16;
                           var37 = var40;
                        }

                        var37 += var6;
                        var38 += var7;
                        var39 += var8;
                        var40 = var39 * var4 + var5 * var37 >> 16;
                        var39 = var5 * var39 - var37 * var4 >> 16;
                        var37 = var40;
                        var40 = var3 * var38 - var39 * var2 >> 16;
                        var39 = var38 * var2 + var3 * var39 >> 16;
                        field1914[var36] = var39 - var11;
                        if(var39 >= 50) {
                           field1951[var36] = var37 * Graphics3D.field2009 / var39 + var32;
                           field1952[var36] = var40 * Graphics3D.field2009 / var39 + var33;
                        } else {
                           field1951[var36] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           yViewportBuffer[var36] = var37;
                           field1917[var36] = var40;
                           field1968[var36] = var39;
                        }
                     }

                     try {
                        this.method2574(var23, var45, this.field1936, var9);
                     } catch (Exception var44) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("m")
   public void method2567() {
      for(int var1 = 0; var1 < this.field1977; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.method2561();
   }

   @ObfuscatedName("ap")
   public void method2624(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1977; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = var2 * this.verticesY[var4] / 128;
         this.verticesZ[var4] = var3 * this.verticesZ[var4] / 128;
      }

      this.method2561();
   }

   @ObfuscatedName("r")
   public void method2566() {
      for(int var1 = 0; var1 < this.field1977; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.method2561();
   }

   @ObfuscatedName("c")
   public void method2565() {
      for(int var1 = 0; var1 < this.field1977; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.method2561();
   }

   @ObfuscatedName("aw")
   final void method2575(int var1) {
      if(field1919[var1]) {
         this.method2604(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         Graphics3D.rasterClipEnable = field1950[var1];
         if(this.field1926 == null) {
            Graphics3D.rasterAlpha = 0;
         } else {
            Graphics3D.rasterAlpha = this.field1926[var1] & 255;
         }

         if(this.field1928 != null && this.field1928[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1927 != null && this.field1927[var1] != -1) {
               int var8 = this.field1927[var1] & 255;
               var5 = this.field1949[var8];
               var6 = this.field1932[var8];
               var7 = this.field1922[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1933[var1] == -1) {
               Graphics3D.rasterTextureAffine(field1952[var2], field1952[var3], field1952[var4], field1951[var2], field1951[var3], field1951[var4], this.field1918[var1], this.field1918[var1], this.field1918[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1917[var5], field1917[var6], field1917[var7], field1968[var5], field1968[var6], field1968[var7], this.field1928[var1]);
            } else {
               Graphics3D.rasterTextureAffine(field1952[var2], field1952[var3], field1952[var4], field1951[var2], field1951[var3], field1951[var4], this.field1918[var1], this.field1913[var1], this.field1933[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1917[var5], field1917[var6], field1917[var7], field1968[var5], field1968[var6], field1968[var7], this.field1928[var1]);
            }
         } else if(this.field1933[var1] == -1) {
            Graphics3D.rasterFlat(field1952[var2], field1952[var3], field1952[var4], field1951[var2], field1951[var3], field1951[var4], field1962[this.field1918[var1]]);
         } else {
            Graphics3D.rasterGouraud(field1952[var2], field1952[var3], field1952[var4], field1951[var2], field1951[var3], field1951[var4], this.field1918[var1], this.field1913[var1], this.field1933[var1]);
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Leo;ILeo;I[I)V"
   )
   public void method2563(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.skeletons[var2];
            Frame var7 = var3.skeletons[var4];
            FrameMap var8 = var6.skin;
            field1960 = 0;
            field1969 = 0;
            field1970 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1880; ++var11) {
               for(var12 = var6.field1881[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.types[var12] == 0) {
                  this.method2555(var8.types[var12], var8.list[var12], var6.translator_x[var11], var6.translator_y[var11], var6.translator_z[var11]);
               }
            }

            field1960 = 0;
            field1969 = 0;
            field1970 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1880; ++var11) {
               for(var12 = var7.field1881[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.types[var12] == 0) {
                  this.method2555(var8.types[var12], var8.list[var12], var7.translator_x[var11], var7.translator_y[var11], var7.translator_z[var11]);
               }
            }

            this.method2561();
         } else {
            this.method2625(var1, var2);
         }
      }
   }

   @ObfuscatedName("y")
   void method2555(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1960 = 0;
         field1969 = 0;
         field1970 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var9 = var2[var8];
            if(var9 < this.field1934.length) {
               int[] var10 = this.field1934[var9];

               for(var11 = 0; var11 < var10.length; ++var11) {
                  var12 = var10[var11];
                  field1960 += this.verticesX[var12];
                  field1969 += this.verticesY[var12];
                  field1970 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1960 = var3 + field1960 / var7;
            field1969 = var4 + field1969 / var7;
            field1970 = var5 + field1970 / var7;
         } else {
            field1960 = var3;
            field1969 = var4;
            field1970 = var5;
         }

      } else {
         int[] var18;
         int var19;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1934.length) {
                  var18 = this.field1934[var8];

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
               if(var8 < this.field1934.length) {
                  var18 = this.field1934[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= field1960;
                     this.verticesY[var11] -= field1969;
                     this.verticesZ[var11] -= field1970;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1974[var14];
                        var16 = field1975[var14];
                        var17 = var15 * this.verticesY[var11] + var16 * this.verticesX[var11] >> 16;
                        this.verticesY[var11] = var16 * this.verticesY[var11] - var15 * this.verticesX[var11] >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1974[var12];
                        var16 = field1975[var12];
                        var17 = var16 * this.verticesY[var11] - var15 * this.verticesZ[var11] >> 16;
                        this.verticesZ[var11] = var15 * this.verticesY[var11] + var16 * this.verticesZ[var11] >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1974[var13];
                        var16 = field1975[var13];
                        var17 = var15 * this.verticesZ[var11] + var16 * this.verticesX[var11] >> 16;
                        this.verticesZ[var11] = var16 * this.verticesZ[var11] - var15 * this.verticesX[var11] >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += field1960;
                     this.verticesY[var11] += field1969;
                     this.verticesZ[var11] += field1970;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1934.length) {
                  var18 = this.field1934[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= field1960;
                     this.verticesY[var11] -= field1969;
                     this.verticesZ[var11] -= field1970;
                     this.verticesX[var11] = var3 * this.verticesX[var11] / 128;
                     this.verticesY[var11] = var4 * this.verticesY[var11] / 128;
                     this.verticesZ[var11] = var5 * this.verticesZ[var11] / 128;
                     this.verticesX[var11] += field1960;
                     this.verticesY[var11] += field1969;
                     this.verticesZ[var11] += field1970;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1935 != null && this.field1926 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1935.length) {
                     var18 = this.field1935[var8];

                     for(var19 = 0; var19 < var18.length; ++var19) {
                        var11 = var18[var19];
                        var12 = (this.field1926[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1926[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("ay")
   final void method2574(boolean var1, boolean var2, boolean var3, int var4) {
      if(this.field1940 < 1600) {
         int var5;
         for(var5 = 0; var5 < this.field1940; ++var5) {
            field1958[var5] = 0;
         }

         var5 = var3?20:5;
         int var7;
         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         int var13;
         if(class7.field247 && var2) {
            Model var6 = this;

            for(var7 = 0; var7 < var6.field1963; ++var7) {
               if(var6.field1933[var7] != -2) {
                  var8 = var6.indices1[var7];
                  var9 = var6.indices2[var7];
                  var10 = var6.indices3[var7];
                  var11 = field1951[var8];
                  var12 = field1951[var9];
                  var13 = field1951[var10];
                  class56.method814(field1952[var8], field1952[var9], field1952[var10], var11, var12, var13, var5);
               }
            }
         }

         int var14;
         int var15;
         int var17;
         int var26;
         for(var26 = 0; var26 < this.field1963; ++var26) {
            if(this.field1933[var26] != -2) {
               var7 = this.indices1[var26];
               var8 = this.indices2[var26];
               var9 = this.indices3[var26];
               var10 = field1951[var7];
               var11 = field1951[var8];
               var12 = field1951[var9];
               int var16;
               if(!var1 || var10 != -5000 && var11 != -5000 && var12 != -5000) {
                  if(var2) {
                     var14 = field1952[var7];
                     var15 = field1952[var8];
                     var16 = field1952[var9];
                     var17 = var5 + class132.field1986;
                     boolean var32;
                     if(var17 < var14 && var17 < var15 && var17 < var16) {
                        var32 = false;
                     } else {
                        var17 = class132.field1986 - var5;
                        if(var17 > var14 && var17 > var15 && var17 > var16) {
                           var32 = false;
                        } else {
                           var17 = var5 + class132.field1993;
                           if(var17 < var10 && var17 < var11 && var17 < var12) {
                              var32 = false;
                           } else {
                              var17 = class132.field1993 - var5;
                              if(var17 > var10 && var17 > var11 && var17 > var12) {
                                 var32 = false;
                              } else {
                                 var32 = true;
                              }
                           }
                        }
                     }

                     if(var32) {
                        class132.field1989[++class132.field1981 - 1] = var4;
                        var2 = false;
                     }
                  }

                  if((var10 - var11) * (field1952[var9] - field1952[var8]) - (var12 - var11) * (field1952[var7] - field1952[var8]) > 0) {
                     field1919[var26] = false;
                     if(var10 >= 0 && var11 >= 0 && var12 >= 0 && var10 <= Graphics3D.rasterClipX && var11 <= Graphics3D.rasterClipX && var12 <= Graphics3D.rasterClipX) {
                        field1950[var26] = false;
                     } else {
                        field1950[var26] = true;
                     }

                     var13 = (field1914[var7] + field1914[var8] + field1914[var9]) / 3 + this.field1941;
                     field1959[var13][field1958[var13]++] = var26;
                  }
               } else {
                  var13 = yViewportBuffer[var7];
                  var14 = yViewportBuffer[var8];
                  var15 = yViewportBuffer[var9];
                  var16 = field1917[var7];
                  var17 = field1917[var8];
                  int var18 = field1917[var9];
                  int var19 = field1968[var7];
                  int var20 = field1968[var8];
                  int var21 = field1968[var9];
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
                     field1919[var26] = true;
                     int var25 = (field1914[var7] + field1914[var8] + field1914[var9]) / 3 + this.field1941;
                     field1959[var25][field1958[var25]++] = var26;
                  }
               }
            }
         }

         int[] var27;
         if(this.field1925 == null) {
            for(var26 = this.field1940 - 1; var26 >= 0; --var26) {
               var7 = field1958[var26];
               if(var7 > 0) {
                  var27 = field1959[var26];

                  for(var9 = 0; var9 < var7; ++var9) {
                     this.method2575(var27[var9]);
                  }
               }
            }

         } else {
            for(var26 = 0; var26 < 12; ++var26) {
               field1942[var26] = 0;
               field1931[var26] = 0;
            }

            for(var26 = this.field1940 - 1; var26 >= 0; --var26) {
               var7 = field1958[var26];
               if(var7 > 0) {
                  var27 = field1959[var26];

                  for(var9 = 0; var9 < var7; ++var9) {
                     var10 = var27[var9];
                     byte var31 = this.field1925[var10];
                     var12 = field1942[var31]++;
                     field1961[var31][var12] = var10;
                     if(var31 < 10) {
                        field1931[var31] += var26;
                     } else if(var31 == 10) {
                        field1910[var12] = var26;
                     } else {
                        field1930[var12] = var26;
                     }
                  }
               }
            }

            var26 = 0;
            if(field1942[1] > 0 || field1942[2] > 0) {
               var26 = (field1931[1] + field1931[2]) / (field1942[1] + field1942[2]);
            }

            var7 = 0;
            if(field1942[3] > 0 || field1942[4] > 0) {
               var7 = (field1931[3] + field1931[4]) / (field1942[3] + field1942[4]);
            }

            var8 = 0;
            if(field1942[6] > 0 || field1942[8] > 0) {
               var8 = (field1931[8] + field1931[6]) / (field1942[8] + field1942[6]);
            }

            var10 = 0;
            var11 = field1942[10];
            int[] var28 = field1961[10];
            int[] var29 = field1910;
            if(var10 == var11) {
               var10 = 0;
               var11 = field1942[11];
               var28 = field1961[11];
               var29 = field1930;
            }

            if(var10 < var11) {
               var9 = var29[var10];
            } else {
               var9 = -1000;
            }

            for(var14 = 0; var14 < 10; ++var14) {
               while(var14 == 0 && var9 > var26) {
                  this.method2575(var28[var10++]);
                  if(var10 == var11 && var28 != field1961[11]) {
                     var10 = 0;
                     var11 = field1942[11];
                     var28 = field1961[11];
                     var29 = field1930;
                  }

                  if(var10 < var11) {
                     var9 = var29[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 3 && var9 > var7) {
                  this.method2575(var28[var10++]);
                  if(var10 == var11 && var28 != field1961[11]) {
                     var10 = 0;
                     var11 = field1942[11];
                     var28 = field1961[11];
                     var29 = field1930;
                  }

                  if(var10 < var11) {
                     var9 = var29[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 5 && var9 > var8) {
                  this.method2575(var28[var10++]);
                  if(var10 == var11 && var28 != field1961[11]) {
                     var10 = 0;
                     var11 = field1942[11];
                     var28 = field1961[11];
                     var29 = field1930;
                  }

                  if(var10 < var11) {
                     var9 = var29[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               var15 = field1942[var14];
               int[] var30 = field1961[var14];

               for(var17 = 0; var17 < var15; ++var17) {
                  this.method2575(var30[var17]);
               }
            }

            while(var9 != -1000) {
               this.method2575(var28[var10++]);
               if(var10 == var11 && var28 != field1961[11]) {
                  var10 = 0;
                  var28 = field1961[11];
                  var11 = field1942[11];
                  var29 = field1930;
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

   @ObfuscatedName("f")
   public void method2569(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1977; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.method2561();
   }

   @ObfuscatedName("af")
   public final void method2571(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1958[0] = -1;
      if(this.field1937 != 2 && this.field1937 != 1) {
         this.method2559();
      }

      int var8 = Graphics3D.centerX;
      int var9 = Graphics3D.centerY;
      int var10 = field1974[var1];
      int var11 = field1975[var1];
      int var12 = field1974[var2];
      int var13 = field1975[var2];
      int var14 = field1974[var3];
      int var15 = field1975[var3];
      int var16 = field1974[var4];
      int var17 = field1975[var4];
      int var18 = var16 * var6 + var17 * var7 >> 16;

      for(int var19 = 0; var19 < this.field1977; ++var19) {
         int var20 = this.verticesX[var19];
         int var21 = this.verticesY[var19];
         int var22 = this.verticesZ[var19];
         int var23;
         if(var3 != 0) {
            var23 = var21 * var14 + var20 * var15 >> 16;
            var21 = var21 * var15 - var20 * var14 >> 16;
            var20 = var23;
         }

         if(var1 != 0) {
            var23 = var21 * var11 - var22 * var10 >> 16;
            var22 = var21 * var10 + var22 * var11 >> 16;
            var21 = var23;
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
         field1914[var19] = var22 - var18;
         field1951[var19] = var20 * Graphics3D.field2009 / var22 + var8;
         field1952[var19] = var23 * Graphics3D.field2009 / var22 + var9;
         if(this.field1924 > 0) {
            yViewportBuffer[var19] = var20;
            field1917[var19] = var23;
            field1968[var19] = var22;
         }
      }

      try {
         this.method2574(false, false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("aa")
   public final void method2576(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1958[0] = -1;
      if(this.field1937 != 2 && this.field1937 != 1) {
         this.method2559();
      }

      int var9 = Graphics3D.centerX;
      int var10 = Graphics3D.centerY;
      int var11 = field1974[var1];
      int var12 = field1975[var1];
      int var13 = field1974[var2];
      int var14 = field1975[var2];
      int var15 = field1974[var3];
      int var16 = field1975[var3];
      int var17 = field1974[var4];
      int var18 = field1975[var4];
      int var19 = var17 * var6 + var18 * var7 >> 16;

      for(int var20 = 0; var20 < this.field1977; ++var20) {
         int var21 = this.verticesX[var20];
         int var22 = this.verticesY[var20];
         int var23 = this.verticesZ[var20];
         int var24;
         if(var3 != 0) {
            var24 = var22 * var15 + var21 * var16 >> 16;
            var22 = var22 * var16 - var21 * var15 >> 16;
            var21 = var24;
         }

         if(var1 != 0) {
            var24 = var22 * var12 - var23 * var11 >> 16;
            var23 = var22 * var11 + var23 * var12 >> 16;
            var22 = var24;
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
         field1914[var20] = var23 - var19;
         field1951[var20] = var9 + var21 * Graphics3D.field2009 / var8;
         field1952[var20] = var10 + var24 * Graphics3D.field2009 / var8;
         if(this.field1924 > 0) {
            yViewportBuffer[var20] = var21;
            field1917[var20] = var24;
            field1968[var20] = var23;
         }
      }

      try {
         this.method2574(false, false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("d")
   public int method2595() {
      this.method2558();
      return this.XYZMag;
   }
}
