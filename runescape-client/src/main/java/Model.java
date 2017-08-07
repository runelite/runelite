import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("at")
   static boolean[] field1952;
   @ObfuscatedName("an")
   static int[] field1941;
   @ObfuscatedName("bz")
   static int[] field1931;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lew;"
   )
   static Model field1912;
   @ObfuscatedName("y")
   static byte[] field1970;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lew;"
   )
   static Model field1947;
   @ObfuscatedName("bp")
   static int field1930;
   @ObfuscatedName("n")
   static byte[] field1913;
   @ObfuscatedName("br")
   static int[] field1977;
   @ObfuscatedName("bi")
   static int field1971;
   @ObfuscatedName("ad")
   static boolean[] field1951;
   @ObfuscatedName("by")
   static int field1972;
   @ObfuscatedName("ap")
   static int[] field1958;
   @ObfuscatedName("aj")
   static int[] field1922;
   @ObfuscatedName("ba")
   static int[] field1967;
   @ObfuscatedName("as")
   @Export("yViewportBuffer")
   static int[] yViewportBuffer;
   @ObfuscatedName("bq")
   static int[] field1919;
   @ObfuscatedName("af")
   static int[] field1953;
   @ObfuscatedName("ab")
   static int[] field1979;
   @ObfuscatedName("ar")
   static int[][] field1961;
   @ObfuscatedName("bg")
   static int[] field1968;
   @ObfuscatedName("am")
   static int[] field1954;
   @ObfuscatedName("bj")
   static int[] field1966;
   @ObfuscatedName("bd")
   @Export("xViewportBuffer")
   static int[] xViewportBuffer;
   @ObfuscatedName("aq")
   static int[] field1955;
   @ObfuscatedName("bm")
   static int[] field1978;
   @ObfuscatedName("aa")
   static int[][] field1934;
   @ObfuscatedName("bn")
   static int[] field1964;
   @ObfuscatedName("bo")
   static int[] field1915;
   @ObfuscatedName("bc")
   public static boolean field1976;
   @ObfuscatedName("ao")
   int field1963;
   @ObfuscatedName("aw")
   public int field1939;
   @ObfuscatedName("ay")
   int field1914;
   @ObfuscatedName("j")
   int[][] field1936;
   @ObfuscatedName("w")
   int field1916;
   @ObfuscatedName("ae")
   public int field1944;
   @ObfuscatedName("u")
   @Export("indices1")
   int[] indices1;
   @ObfuscatedName("ah")
   @Export("XYZMag")
   int XYZMag;
   @ObfuscatedName("k")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("z")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("r")
   int field1920;
   @ObfuscatedName("d")
   @Export("indices2")
   int[] indices2;
   @ObfuscatedName("o")
   @Export("indices3")
   int[] indices3;
   @ObfuscatedName("v")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("q")
   int[][] field1937;
   @ObfuscatedName("p")
   byte field1932;
   @ObfuscatedName("au")
   int field1933;
   @ObfuscatedName("f")
   int field1960;
   @ObfuscatedName("m")
   byte[] field1928;
   @ObfuscatedName("ax")
   public int field1945;
   @ObfuscatedName("l")
   int[] field1924;
   @ObfuscatedName("c")
   byte[] field1927;
   @ObfuscatedName("s")
   int[] field1926;
   @ObfuscatedName("av")
   public int field1948;
   @ObfuscatedName("ag")
   public boolean field1938;
   @ObfuscatedName("h")
   int[] field1973;
   @ObfuscatedName("t")
   short[] field1950;
   @ObfuscatedName("az")
   public int field1946;
   @ObfuscatedName("al")
   int field1943;
   @ObfuscatedName("ac")
   public int field1942;
   @ObfuscatedName("a")
   byte[] field1929;
   @ObfuscatedName("b")
   int[] field1925;
   @ObfuscatedName("x")
   int[] field1980;
   @ObfuscatedName("i")
   int[] field1935;

   static {
      field1947 = new Model();
      field1913 = new byte[1];
      field1912 = new Model();
      field1970 = new byte[1];
      field1951 = new boolean[4700];
      field1952 = new boolean[4700];
      field1953 = new int[4700];
      field1954 = new int[4700];
      field1955 = new int[4700];
      yViewportBuffer = new int[4700];
      field1979 = new int[4700];
      field1958 = new int[4700];
      field1941 = new int[1600];
      field1961 = new int[1600][512];
      field1922 = new int[12];
      field1934 = new int[12][2000];
      field1964 = new int[2000];
      field1915 = new int[2000];
      field1919 = new int[12];
      field1967 = new int[10];
      field1968 = new int[10];
      xViewportBuffer = new int[10];
      field1976 = true;
      field1931 = Graphics3D.SINE;
      field1977 = Graphics3D.COSINE;
      field1978 = Graphics3D.colorPalette;
      field1966 = Graphics3D.field2005;
   }

   Model() {
      this.field1916 = 0;
      this.field1920 = 0;
      this.field1932 = 0;
      this.field1960 = 0;
      this.field1938 = false;
      this.field1939 = -1;
      this.field1948 = -1;
      this.field1942 = -1;
   }

   @ObfuscatedSignature(
      signature = "([Lew;I)V"
   )
   public Model(Model[] var1, int var2) {
      this.field1916 = 0;
      this.field1920 = 0;
      this.field1932 = 0;
      this.field1960 = 0;
      this.field1938 = false;
      this.field1939 = -1;
      this.field1948 = -1;
      this.field1942 = -1;
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1916 = 0;
      this.field1920 = 0;
      this.field1960 = 0;
      this.field1932 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1916 += var8.field1916;
            this.field1920 += var8.field1920;
            this.field1960 += var8.field1960;
            if(var8.field1927 != null) {
               var3 = true;
            } else {
               if(this.field1932 == -1) {
                  this.field1932 = var8.field1932;
               }

               if(this.field1932 != var8.field1932) {
                  var3 = true;
               }
            }

            var4 |= var8.field1928 != null;
            var5 |= var8.field1950 != null;
            var6 |= var8.field1929 != null;
         }
      }

      this.verticesX = new int[this.field1916];
      this.verticesY = new int[this.field1916];
      this.verticesZ = new int[this.field1916];
      this.indices1 = new int[this.field1920];
      this.indices2 = new int[this.field1920];
      this.indices3 = new int[this.field1920];
      this.field1924 = new int[this.field1920];
      this.field1973 = new int[this.field1920];
      this.field1926 = new int[this.field1920];
      if(var3) {
         this.field1927 = new byte[this.field1920];
      }

      if(var4) {
         this.field1928 = new byte[this.field1920];
      }

      if(var5) {
         this.field1950 = new short[this.field1920];
      }

      if(var6) {
         this.field1929 = new byte[this.field1920];
      }

      if(this.field1960 > 0) {
         this.field1925 = new int[this.field1960];
         this.field1980 = new int[this.field1960];
         this.field1935 = new int[this.field1960];
      }

      this.field1916 = 0;
      this.field1920 = 0;
      this.field1960 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1920; ++var9) {
               this.indices1[this.field1920] = this.field1916 + var8.indices1[var9];
               this.indices2[this.field1920] = this.field1916 + var8.indices2[var9];
               this.indices3[this.field1920] = this.field1916 + var8.indices3[var9];
               this.field1924[this.field1920] = var8.field1924[var9];
               this.field1973[this.field1920] = var8.field1973[var9];
               this.field1926[this.field1920] = var8.field1926[var9];
               if(var3) {
                  if(var8.field1927 != null) {
                     this.field1927[this.field1920] = var8.field1927[var9];
                  } else {
                     this.field1927[this.field1920] = var8.field1932;
                  }
               }

               if(var4 && var8.field1928 != null) {
                  this.field1928[this.field1920] = var8.field1928[var9];
               }

               if(var5) {
                  if(var8.field1950 != null) {
                     this.field1950[this.field1920] = var8.field1950[var9];
                  } else {
                     this.field1950[this.field1920] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1929 != null && var8.field1929[var9] != -1) {
                     this.field1929[this.field1920] = (byte)(this.field1960 + var8.field1929[var9]);
                  } else {
                     this.field1929[this.field1920] = -1;
                  }
               }

               ++this.field1920;
            }

            for(var9 = 0; var9 < var8.field1960; ++var9) {
               this.field1925[this.field1960] = this.field1916 + var8.field1925[var9];
               this.field1980[this.field1960] = this.field1916 + var8.field1980[var9];
               this.field1935[this.field1960] = this.field1916 + var8.field1935[var9];
               ++this.field1960;
            }

            for(var9 = 0; var9 < var8.field1916; ++var9) {
               this.verticesX[this.field1916] = var8.verticesX[var9];
               this.verticesY[this.field1916] = var8.verticesY[var9];
               this.verticesZ[this.field1916] = var8.verticesZ[var9];
               ++this.field1916;
            }
         }
      }

   }

   @ObfuscatedName("v")
   public void method2519() {
      if(this.field1914 != 1) {
         this.field1914 = 1;
         super.modelHeight = 0;
         this.field1933 = 0;
         this.XYZMag = 0;

         for(int var1 = 0; var1 < this.field1916; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1933) {
               this.field1933 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.XYZMag) {
               this.XYZMag = var5;
            }
         }

         this.XYZMag = (int)(Math.sqrt((double)this.XYZMag) + 0.99D);
         this.field1943 = (int)(Math.sqrt((double)(this.XYZMag * this.XYZMag + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1963 = this.field1943 + (int)(Math.sqrt((double)(this.XYZMag * this.XYZMag + this.field1933 * this.field1933)) + 0.99D);
      }
   }

   @ObfuscatedName("ao")
   final void method2517(int var1) {
      int var2 = Graphics3D.centerX;
      int var3 = Graphics3D.centerY;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1958[var5];
      int var9 = field1958[var6];
      int var10 = field1958[var7];
      if(this.field1928 == null) {
         Graphics3D.rasterAlpha = 0;
      } else {
         Graphics3D.rasterAlpha = this.field1928[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1967[var4] = field1953[var5];
         field1968[var4] = field1954[var5];
         xViewportBuffer[var4++] = this.field1924[var1];
      } else {
         var11 = yViewportBuffer[var5];
         var12 = field1979[var5];
         var13 = this.field1924[var1];
         if(var10 >= 50) {
            var14 = field1966[var10 - var8] * (50 - var8);
            field1967[var4] = var2 + Graphics3D.field2011 * (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) / 50;
            field1968[var4] = var3 + Graphics3D.field2011 * (var12 + ((field1979[var7] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1926[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = field1966[var9 - var8] * (50 - var8);
            field1967[var4] = var2 + (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) * Graphics3D.field2011 / 50;
            field1968[var4] = var3 + Graphics3D.field2011 * (var12 + ((field1979[var6] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1973[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1967[var4] = field1953[var6];
         field1968[var4] = field1954[var6];
         xViewportBuffer[var4++] = this.field1973[var1];
      } else {
         var11 = yViewportBuffer[var6];
         var12 = field1979[var6];
         var13 = this.field1973[var1];
         if(var8 >= 50) {
            var14 = field1966[var8 - var9] * (50 - var9);
            field1967[var4] = var2 + (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) * Graphics3D.field2011 / 50;
            field1968[var4] = var3 + Graphics3D.field2011 * (var12 + ((field1979[var5] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1924[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = field1966[var10 - var9] * (50 - var9);
            field1967[var4] = var2 + (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) * Graphics3D.field2011 / 50;
            field1968[var4] = var3 + (var12 + ((field1979[var7] - var12) * var14 >> 16)) * Graphics3D.field2011 / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1926[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1967[var4] = field1953[var7];
         field1968[var4] = field1954[var7];
         xViewportBuffer[var4++] = this.field1926[var1];
      } else {
         var11 = yViewportBuffer[var7];
         var12 = field1979[var7];
         var13 = this.field1926[var1];
         if(var9 >= 50) {
            var14 = field1966[var9 - var10] * (50 - var10);
            field1967[var4] = var2 + (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) * Graphics3D.field2011 / 50;
            field1968[var4] = var3 + (var12 + ((field1979[var6] - var12) * var14 >> 16)) * Graphics3D.field2011 / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1973[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = field1966[var8 - var10] * (50 - var10);
            field1967[var4] = var2 + (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) * Graphics3D.field2011 / 50;
            field1968[var4] = var3 + Graphics3D.field2011 * (var12 + ((field1979[var5] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1924[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1967[0];
      var12 = field1967[1];
      var13 = field1967[2];
      var14 = field1968[0];
      int var15 = field1968[1];
      int var16 = field1968[2];
      Graphics3D.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX) {
            Graphics3D.rasterClipEnable = true;
         }

         if(this.field1950 != null && this.field1950[var1] != -1) {
            if(this.field1929 != null && this.field1929[var1] != -1) {
               var20 = this.field1929[var1] & 255;
               var17 = this.field1925[var20];
               var18 = this.field1980[var20];
               var19 = this.field1935[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1926[var1] == -1) {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1924[var1], this.field1924[var1], this.field1924[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1979[var17], field1979[var18], field1979[var19], field1958[var17], field1958[var18], field1958[var19], this.field1950[var1]);
            } else {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1979[var17], field1979[var18], field1979[var19], field1958[var17], field1958[var18], field1958[var19], this.field1950[var1]);
            }
         } else if(this.field1926[var1] == -1) {
            Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, field1978[this.field1924[var1]]);
         } else {
            Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX || field1967[3] < 0 || field1967[3] > Graphics3D.rasterClipX) {
            Graphics3D.rasterClipEnable = true;
         }

         if(this.field1950 != null && this.field1950[var1] != -1) {
            if(this.field1929 != null && this.field1929[var1] != -1) {
               var20 = this.field1929[var1] & 255;
               var17 = this.field1925[var20];
               var18 = this.field1980[var20];
               var19 = this.field1935[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1950[var1];
            if(this.field1926[var1] == -1) {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1924[var1], this.field1924[var1], this.field1924[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1979[var17], field1979[var18], field1979[var19], field1958[var17], field1958[var18], field1958[var19], var21);
               Graphics3D.rasterTextureAffine(var14, var16, field1968[3], var11, var13, field1967[3], this.field1924[var1], this.field1924[var1], this.field1924[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1979[var17], field1979[var18], field1979[var19], field1958[var17], field1958[var18], field1958[var19], var21);
            } else {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1979[var17], field1979[var18], field1979[var19], field1958[var17], field1958[var18], field1958[var19], var21);
               Graphics3D.rasterTextureAffine(var14, var16, field1968[3], var11, var13, field1967[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1979[var17], field1979[var18], field1979[var19], field1958[var17], field1958[var18], field1958[var19], var21);
            }
         } else if(this.field1926[var1] == -1) {
            var17 = field1978[this.field1924[var1]];
            Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            Graphics3D.rasterFlat(var14, var16, field1968[3], var11, var13, field1967[3], var17);
         } else {
            Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
            Graphics3D.rasterGouraud(var14, var16, field1968[3], var11, var13, field1967[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3]);
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lea;I)V"
   )
   public void method2523(Frames var1, int var2) {
      if(this.field1936 != null) {
         if(var2 != -1) {
            Frame var3 = var1.skeletons[var2];
            FrameMap var4 = var3.skin;
            field1930 = 0;
            field1971 = 0;
            field1972 = 0;

            for(int var5 = 0; var5 < var3.field1880; ++var5) {
               int var6 = var3.field1879[var5];
               this.method2566(var4.types[var6], var4.list[var6], var3.translator_x[var5], var3.translator_y[var5], var3.translator_z[var5]);
            }

            this.method2584();
         }
      }
   }

   @ObfuscatedName("u")
   void method2584() {
      this.field1914 = 0;
      this.field1939 = -1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ZLew;[B)Lew;"
   )
   Model method2537(boolean var1, Model var2, byte[] var3) {
      var2.field1916 = this.field1916;
      var2.field1920 = this.field1920;
      var2.field1960 = this.field1960;
      if(var2.verticesX == null || var2.verticesX.length < this.field1916) {
         var2.verticesX = new int[this.field1916 + 100];
         var2.verticesY = new int[this.field1916 + 100];
         var2.verticesZ = new int[this.field1916 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1916; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if(var1) {
         var2.field1928 = this.field1928;
      } else {
         var2.field1928 = var3;
         if(this.field1928 == null) {
            for(var4 = 0; var4 < this.field1920; ++var4) {
               var2.field1928[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1920; ++var4) {
               var2.field1928[var4] = this.field1928[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1924 = this.field1924;
      var2.field1973 = this.field1973;
      var2.field1926 = this.field1926;
      var2.field1927 = this.field1927;
      var2.field1929 = this.field1929;
      var2.field1950 = this.field1950;
      var2.field1932 = this.field1932;
      var2.field1925 = this.field1925;
      var2.field1980 = this.field1980;
      var2.field1935 = this.field1935;
      var2.field1936 = this.field1936;
      var2.field1937 = this.field1937;
      var2.field1938 = this.field1938;
      var2.method2584();
      return var2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Z)Lew;"
   )
   public Model method2608(boolean var1) {
      if(!var1 && field1913.length < this.field1920) {
         field1913 = new byte[this.field1920 + 100];
      }

      return this.method2537(var1, field1947, field1913);
   }

   @ObfuscatedName("k")
   void method2606(int var1) {
      if(this.field1939 == -1) {
         int var2 = 0;
         int var3 = 0;
         int var4 = 0;
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         int var8 = field1977[var1];
         int var9 = field1931[var1];

         for(int var10 = 0; var10 < this.field1916; ++var10) {
            int var11 = Graphics3D.method2645(this.verticesX[var10], this.verticesZ[var10], var8, var9);
            int var12 = this.verticesY[var10];
            int var13 = Graphics3D.method2646(this.verticesX[var10], this.verticesZ[var10], var8, var9);
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

         this.field1944 = (var5 + var2) / 2;
         this.field1945 = (var6 + var3) / 2;
         this.field1946 = (var7 + var4) / 2;
         this.field1939 = (var5 - var2 + 1) / 2;
         this.field1948 = (var6 - var3 + 1) / 2;
         this.field1942 = (var7 - var4 + 1) / 2;
         if(this.field1939 < 32) {
            this.field1939 = 32;
         }

         if(this.field1942 < 32) {
            this.field1942 = 32;
         }

         if(this.field1938) {
            this.field1939 += 8;
            this.field1942 += 8;
         }

      }
   }

   @ObfuscatedName("z")
   void method2601() {
      if(this.field1914 != 2) {
         this.field1914 = 2;
         this.XYZMag = 0;

         for(int var1 = 0; var1 < this.field1916; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.XYZMag) {
               this.XYZMag = var5;
            }
         }

         this.XYZMag = (int)(Math.sqrt((double)this.XYZMag) + 0.99D);
         this.field1943 = this.XYZMag;
         this.field1963 = this.XYZMag + this.XYZMag;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Z)Lew;"
   )
   public Model method2554(boolean var1) {
      if(!var1 && field1970.length < this.field1920) {
         field1970 = new byte[this.field1920 + 100];
      }

      return this.method2537(var1, field1912, field1970);
   }

   @ObfuscatedName("f")
   public void method2529(int var1) {
      int var2 = field1931[var1];
      int var3 = field1977[var1];

      for(int var4 = 0; var4 < this.field1916; ++var4) {
         int var5 = var3 * this.verticesY[var4] - var2 * this.verticesZ[var4] >> 16;
         this.verticesZ[var4] = var2 * this.verticesY[var4] + var3 * this.verticesZ[var4] >> 16;
         this.verticesY[var4] = var5;
      }

      this.method2584();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([[IIIIZI)Lew;"
   )
   public Model method2545(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2519();
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
               var11.field1916 = this.field1916;
               var11.field1920 = this.field1920;
               var11.field1960 = this.field1960;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1924 = this.field1924;
               var11.field1973 = this.field1973;
               var11.field1926 = this.field1926;
               var11.field1927 = this.field1927;
               var11.field1928 = this.field1928;
               var11.field1929 = this.field1929;
               var11.field1950 = this.field1950;
               var11.field1932 = this.field1932;
               var11.field1925 = this.field1925;
               var11.field1980 = this.field1980;
               var11.field1935 = this.field1935;
               var11.field1936 = this.field1936;
               var11.field1937 = this.field1937;
               var11.field1938 = this.field1938;
               var11.verticesY = new int[var11.field1916];
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
               for(var12 = 0; var12 < var11.field1916; ++var12) {
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
               for(var12 = 0; var12 < var11.field1916; ++var12) {
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

            var11.method2584();
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("p")
   public void method2528() {
      for(int var1 = 0; var1 < this.field1916; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.method2584();
   }

   @ObfuscatedName("cg")
   @Export("draw")
   void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1941[0] = -1;
      if(this.field1914 != 1) {
         this.method2519();
      }

      this.method2606(var1);
      int var10 = var5 * var8 - var4 * var6 >> 16;
      int var11 = var2 * var7 + var3 * var10 >> 16;
      int var12 = var3 * this.XYZMag >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var5 * var6 >> 16;
         int var15 = (var14 - this.XYZMag) * Graphics3D.field2011;
         if(var15 / var13 < Graphics3D.field2017) {
            int var16 = (var14 + this.XYZMag) * Graphics3D.field2011;
            if(var16 / var13 > Graphics3D.field2016) {
               int var17 = var3 * var7 - var10 * var2 >> 16;
               int var18 = var2 * this.XYZMag >> 16;
               int var19 = (var17 + var18) * Graphics3D.field2011;
               if(var19 / var13 > Graphics3D.field2018) {
                  int var20 = var18 + (var3 * super.modelHeight >> 16);
                  int var21 = (var17 - var20) * Graphics3D.field2011;
                  if(var21 / var13 < Graphics3D.field2025) {
                     int var22 = var12 + (var2 * super.modelHeight >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1960 > 0;
                     int var26 = class135.field1983;
                     int var28 = class84.method1661();
                     boolean var29 = class44.method615();
                     if(class7.field231 && var9 > 0) {
                        KitDefinition.method4386(this, var6, var7, var8);
                     }

                     int var31;
                     int var32;
                     int var33;
                     int var34;
                     int var35;
                     int var36;
                     int var37;
                     int var38;
                     int var39;
                     if(class7.field235 && var9 > 0) {
                        int var30 = var11 - var12;
                        if(var30 <= 50) {
                           var30 = 50;
                        }

                        if(var14 > 0) {
                           var31 = var15 / var13;
                           var32 = var16 / var30;
                        } else {
                           var32 = var16 / var13;
                           var31 = var15 / var30;
                        }

                        if(var17 > 0) {
                           var33 = var21 / var13;
                           var34 = var19 / var30;
                        } else {
                           var34 = var19 / var13;
                           var33 = var21 / var30;
                        }

                        var35 = -8355840;
                        var36 = var26 - Graphics3D.centerX;
                        var37 = var28 - Graphics3D.centerY;
                        if(var36 > var31 && var36 < var32 && var37 > var33 && var37 < var34) {
                           var35 = -256;
                        }

                        var38 = var31 + Graphics3D.centerX;
                        var39 = var33 + Graphics3D.centerY;
                        int var40 = var32 + Graphics3D.centerX;
                        int var41 = var34 + Graphics3D.centerY;
                        class7.field229.method3580(new class8(var38, var39, var40, var41, var35));
                     }

                     boolean var44 = false;
                     if(var9 > 0 && var29) {
                        boolean var45 = false;
                        if(field1976) {
                           var45 = class92.method1746(this, var6, var7, var8);
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

                           var33 = var26 - Graphics3D.centerX;
                           var34 = var28 - Graphics3D.centerY;
                           if(var33 > var15 && var33 < var16 && var34 > var21 && var34 < var19) {
                              var45 = true;
                           }
                        }

                        if(var45) {
                           if(this.field1938) {
                              class135.field1989[++class135.field1988 - 1] = var9;
                           } else {
                              var44 = true;
                           }
                        }
                     }

                     var31 = Graphics3D.centerX;
                     var32 = Graphics3D.centerY;
                     var33 = 0;
                     var34 = 0;
                     if(var1 != 0) {
                        var33 = field1931[var1];
                        var34 = field1977[var1];
                     }

                     for(var35 = 0; var35 < this.field1916; ++var35) {
                        var36 = this.verticesX[var35];
                        var37 = this.verticesY[var35];
                        var38 = this.verticesZ[var35];
                        if(var1 != 0) {
                           var39 = var38 * var33 + var36 * var34 >> 16;
                           var38 = var38 * var34 - var36 * var33 >> 16;
                           var36 = var39;
                        }

                        var36 += var6;
                        var37 += var7;
                        var38 += var8;
                        var39 = var38 * var4 + var5 * var36 >> 16;
                        var38 = var5 * var38 - var36 * var4 >> 16;
                        var36 = var39;
                        var39 = var3 * var37 - var38 * var2 >> 16;
                        var38 = var37 * var2 + var3 * var38 >> 16;
                        field1955[var35] = var38 - var11;
                        if(var38 >= 50) {
                           field1953[var35] = var36 * Graphics3D.field2011 / var38 + var31;
                           field1954[var35] = var32 + var39 * Graphics3D.field2011 / var38;
                        } else {
                           field1953[var35] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           yViewportBuffer[var35] = var36;
                           field1979[var35] = var39;
                           field1958[var35] = var38;
                        }
                     }

                     try {
                        this.method2582(var23, var44, this.field1938, var9);
                     } catch (Exception var43) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("t")
   public void method2514() {
      for(int var1 = 0; var1 < this.field1916; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.method2584();
   }

   @ObfuscatedName("q")
   public void method2531(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1916; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = var2 * this.verticesY[var4] / 128;
         this.verticesZ[var4] = var3 * this.verticesZ[var4] / 128;
      }

      this.method2584();
   }

   @ObfuscatedName("a")
   public void method2556() {
      for(int var1 = 0; var1 < this.field1916; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.method2584();
   }

   @ObfuscatedName("ah")
   final void method2559(int var1) {
      if(field1952[var1]) {
         this.method2517(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         Graphics3D.rasterClipEnable = field1951[var1];
         if(this.field1928 == null) {
            Graphics3D.rasterAlpha = 0;
         } else {
            Graphics3D.rasterAlpha = this.field1928[var1] & 255;
         }

         if(this.field1950 != null && this.field1950[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1929 != null && this.field1929[var1] != -1) {
               int var8 = this.field1929[var1] & 255;
               var5 = this.field1925[var8];
               var6 = this.field1980[var8];
               var7 = this.field1935[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1926[var1] == -1) {
               Graphics3D.rasterTextureAffine(field1954[var2], field1954[var3], field1954[var4], field1953[var2], field1953[var3], field1953[var4], this.field1924[var1], this.field1924[var1], this.field1924[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1979[var5], field1979[var6], field1979[var7], field1958[var5], field1958[var6], field1958[var7], this.field1950[var1]);
            } else {
               Graphics3D.rasterTextureAffine(field1954[var2], field1954[var3], field1954[var4], field1953[var2], field1953[var3], field1953[var4], this.field1924[var1], this.field1973[var1], this.field1926[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1979[var5], field1979[var6], field1979[var7], field1958[var5], field1958[var6], field1958[var7], this.field1950[var1]);
            }
         } else if(this.field1926[var1] == -1) {
            Graphics3D.rasterFlat(field1954[var2], field1954[var3], field1954[var4], field1953[var2], field1953[var3], field1953[var4], field1978[this.field1924[var1]]);
         } else {
            Graphics3D.rasterGouraud(field1954[var2], field1954[var3], field1954[var4], field1953[var2], field1953[var3], field1953[var4], this.field1924[var1], this.field1973[var1], this.field1926[var1]);
         }

      }
   }

   @ObfuscatedName("m")
   void method2566(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1930 = 0;
         field1971 = 0;
         field1972 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var9 = var2[var8];
            if(var9 < this.field1936.length) {
               int[] var10 = this.field1936[var9];

               for(var11 = 0; var11 < var10.length; ++var11) {
                  var12 = var10[var11];
                  field1930 += this.verticesX[var12];
                  field1971 += this.verticesY[var12];
                  field1972 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1930 = var3 + field1930 / var7;
            field1971 = var4 + field1971 / var7;
            field1972 = var5 + field1972 / var7;
         } else {
            field1930 = var3;
            field1971 = var4;
            field1972 = var5;
         }

      } else {
         int[] var18;
         int var19;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1936.length) {
                  var18 = this.field1936[var8];

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
               if(var8 < this.field1936.length) {
                  var18 = this.field1936[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= field1930;
                     this.verticesY[var11] -= field1971;
                     this.verticesZ[var11] -= field1972;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1931[var14];
                        var16 = field1977[var14];
                        var17 = var15 * this.verticesY[var11] + var16 * this.verticesX[var11] >> 16;
                        this.verticesY[var11] = var16 * this.verticesY[var11] - var15 * this.verticesX[var11] >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1931[var12];
                        var16 = field1977[var12];
                        var17 = var16 * this.verticesY[var11] - var15 * this.verticesZ[var11] >> 16;
                        this.verticesZ[var11] = var15 * this.verticesY[var11] + var16 * this.verticesZ[var11] >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1931[var13];
                        var16 = field1977[var13];
                        var17 = var15 * this.verticesZ[var11] + var16 * this.verticesX[var11] >> 16;
                        this.verticesZ[var11] = var16 * this.verticesZ[var11] - var15 * this.verticesX[var11] >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += field1930;
                     this.verticesY[var11] += field1971;
                     this.verticesZ[var11] += field1972;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1936.length) {
                  var18 = this.field1936[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= field1930;
                     this.verticesY[var11] -= field1971;
                     this.verticesZ[var11] -= field1972;
                     this.verticesX[var11] = var3 * this.verticesX[var11] / 128;
                     this.verticesY[var11] = var4 * this.verticesY[var11] / 128;
                     this.verticesZ[var11] = var5 * this.verticesZ[var11] / 128;
                     this.verticesX[var11] += field1930;
                     this.verticesY[var11] += field1971;
                     this.verticesZ[var11] += field1972;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1937 != null && this.field1928 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1937.length) {
                     var18 = this.field1937[var8];

                     for(var19 = 0; var19 < var18.length; ++var19) {
                        var11 = var18[var19];
                        var12 = (this.field1928[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1928[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lea;ILea;I[I)V"
   )
   public void method2524(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.skeletons[var2];
            Frame var7 = var3.skeletons[var4];
            FrameMap var8 = var6.skin;
            field1930 = 0;
            field1971 = 0;
            field1972 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1880; ++var11) {
               for(var12 = var6.field1879[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.types[var12] == 0) {
                  this.method2566(var8.types[var12], var8.list[var12], var6.translator_x[var11], var6.translator_y[var11], var6.translator_z[var11]);
               }
            }

            field1930 = 0;
            field1971 = 0;
            field1972 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1880; ++var11) {
               for(var12 = var7.field1879[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.types[var12] == 0) {
                  this.method2566(var8.types[var12], var8.list[var12], var7.translator_x[var11], var7.translator_y[var11], var7.translator_z[var11]);
               }
            }

            this.method2584();
         } else {
            this.method2523(var1, var2);
         }
      }
   }

   @ObfuscatedName("au")
   final void method2582(boolean var1, boolean var2, boolean var3, int var4) {
      if(this.field1963 < 1600) {
         int var5;
         for(var5 = 0; var5 < this.field1963; ++var5) {
            field1941[var5] = 0;
         }

         var5 = var3?20:5;
         int var7;
         int var9;
         int var10;
         int var11;
         int var12;
         int var13;
         int var27;
         if(class7.field227 && var2) {
            Model var6 = this;

            for(var7 = 0; var7 < var6.field1920; ++var7) {
               if(var6.field1926[var7] != -2) {
                  var27 = var6.indices1[var7];
                  var9 = var6.indices2[var7];
                  var10 = var6.indices3[var7];
                  var11 = field1953[var27];
                  var12 = field1953[var9];
                  var13 = field1953[var10];
                  Timer.method3024(field1954[var27], field1954[var9], field1954[var10], var11, var12, var13, var5);
               }
            }
         }

         int var14;
         int var15;
         int var17;
         int var26;
         for(var26 = 0; var26 < this.field1920; ++var26) {
            if(this.field1926[var26] != -2) {
               var7 = this.indices1[var26];
               var27 = this.indices2[var26];
               var9 = this.indices3[var26];
               var10 = field1953[var7];
               var11 = field1953[var27];
               var12 = field1953[var9];
               if(!var1 || var10 != -5000 && var11 != -5000 && var12 != -5000) {
                  if(var2 && GroundObject.method2498(field1954[var7], field1954[var27], field1954[var9], var10, var11, var12, var5)) {
                     class135.field1989[++class135.field1988 - 1] = var4;
                     var2 = false;
                  }

                  if((var10 - var11) * (field1954[var9] - field1954[var27]) - (var12 - var11) * (field1954[var7] - field1954[var27]) > 0) {
                     field1952[var26] = false;
                     if(var10 >= 0 && var11 >= 0 && var12 >= 0 && var10 <= Graphics3D.rasterClipX && var11 <= Graphics3D.rasterClipX && var12 <= Graphics3D.rasterClipX) {
                        field1951[var26] = false;
                     } else {
                        field1951[var26] = true;
                     }

                     var13 = (field1955[var7] + field1955[var27] + field1955[var9]) / 3 + this.field1943;
                     field1961[var13][field1941[var13]++] = var26;
                  }
               } else {
                  var13 = yViewportBuffer[var7];
                  var14 = yViewportBuffer[var27];
                  var15 = yViewportBuffer[var9];
                  int var16 = field1979[var7];
                  var17 = field1979[var27];
                  int var18 = field1979[var9];
                  int var19 = field1958[var7];
                  int var20 = field1958[var27];
                  int var21 = field1958[var9];
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
                     field1952[var26] = true;
                     int var25 = (field1955[var7] + field1955[var27] + field1955[var9]) / 3 + this.field1943;
                     field1961[var25][field1941[var25]++] = var26;
                  }
               }
            }
         }

         int[] var8;
         if(this.field1927 == null) {
            for(var26 = this.field1963 - 1; var26 >= 0; --var26) {
               var7 = field1941[var26];
               if(var7 > 0) {
                  var8 = field1961[var26];

                  for(var9 = 0; var9 < var7; ++var9) {
                     this.method2559(var8[var9]);
                  }
               }
            }

         } else {
            for(var26 = 0; var26 < 12; ++var26) {
               field1922[var26] = 0;
               field1919[var26] = 0;
            }

            for(var26 = this.field1963 - 1; var26 >= 0; --var26) {
               var7 = field1941[var26];
               if(var7 > 0) {
                  var8 = field1961[var26];

                  for(var9 = 0; var9 < var7; ++var9) {
                     var10 = var8[var9];
                     byte var31 = this.field1927[var10];
                     var12 = field1922[var31]++;
                     field1934[var31][var12] = var10;
                     if(var31 < 10) {
                        field1919[var31] += var26;
                     } else if(var31 == 10) {
                        field1964[var12] = var26;
                     } else {
                        field1915[var12] = var26;
                     }
                  }
               }
            }

            var26 = 0;
            if(field1922[1] > 0 || field1922[2] > 0) {
               var26 = (field1919[1] + field1919[2]) / (field1922[1] + field1922[2]);
            }

            var7 = 0;
            if(field1922[3] > 0 || field1922[4] > 0) {
               var7 = (field1919[3] + field1919[4]) / (field1922[3] + field1922[4]);
            }

            var27 = 0;
            if(field1922[6] > 0 || field1922[8] > 0) {
               var27 = (field1919[8] + field1919[6]) / (field1922[8] + field1922[6]);
            }

            var10 = 0;
            var11 = field1922[10];
            int[] var28 = field1934[10];
            int[] var29 = field1964;
            if(var10 == var11) {
               var10 = 0;
               var11 = field1922[11];
               var28 = field1934[11];
               var29 = field1915;
            }

            if(var10 < var11) {
               var9 = var29[var10];
            } else {
               var9 = -1000;
            }

            for(var14 = 0; var14 < 10; ++var14) {
               while(var14 == 0 && var9 > var26) {
                  this.method2559(var28[var10++]);
                  if(var10 == var11 && var28 != field1934[11]) {
                     var10 = 0;
                     var11 = field1922[11];
                     var28 = field1934[11];
                     var29 = field1915;
                  }

                  if(var10 < var11) {
                     var9 = var29[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 3 && var9 > var7) {
                  this.method2559(var28[var10++]);
                  if(var10 == var11 && var28 != field1934[11]) {
                     var10 = 0;
                     var11 = field1922[11];
                     var28 = field1934[11];
                     var29 = field1915;
                  }

                  if(var10 < var11) {
                     var9 = var29[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 5 && var9 > var27) {
                  this.method2559(var28[var10++]);
                  if(var10 == var11 && var28 != field1934[11]) {
                     var10 = 0;
                     var11 = field1922[11];
                     var28 = field1934[11];
                     var29 = field1915;
                  }

                  if(var10 < var11) {
                     var9 = var29[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               var15 = field1922[var14];
               int[] var30 = field1934[var14];

               for(var17 = 0; var17 < var15; ++var17) {
                  this.method2559(var30[var17]);
               }
            }

            while(var9 != -1000) {
               this.method2559(var28[var10++]);
               if(var10 == var11 && var28 != field1934[11]) {
                  var10 = 0;
                  var28 = field1934[11];
                  var11 = field1922[11];
                  var29 = field1915;
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

   @ObfuscatedName("x")
   public void method2526(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1916; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.method2584();
   }

   @ObfuscatedName("ag")
   public final void method2532(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1941[0] = -1;
      if(this.field1914 != 2 && this.field1914 != 1) {
         this.method2601();
      }

      int var8 = Graphics3D.centerX;
      int var9 = Graphics3D.centerY;
      int var10 = field1931[var1];
      int var11 = field1977[var1];
      int var12 = field1931[var2];
      int var13 = field1977[var2];
      int var14 = field1931[var3];
      int var15 = field1977[var3];
      int var16 = field1931[var4];
      int var17 = field1977[var4];
      int var18 = var16 * var6 + var17 * var7 >> 16;

      for(int var19 = 0; var19 < this.field1916; ++var19) {
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
         field1955[var19] = var22 - var18;
         field1953[var19] = var8 + var20 * Graphics3D.field2011 / var22;
         field1954[var19] = var23 * Graphics3D.field2011 / var22 + var9;
         if(this.field1960 > 0) {
            yViewportBuffer[var19] = var20;
            field1979[var19] = var23;
            field1958[var19] = var22;
         }
      }

      try {
         this.method2582(false, false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("ay")
   public final void method2533(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1941[0] = -1;
      if(this.field1914 != 2 && this.field1914 != 1) {
         this.method2601();
      }

      int var9 = Graphics3D.centerX;
      int var10 = Graphics3D.centerY;
      int var11 = field1931[var1];
      int var12 = field1977[var1];
      int var13 = field1931[var2];
      int var14 = field1977[var2];
      int var15 = field1931[var3];
      int var16 = field1977[var3];
      int var17 = field1931[var4];
      int var18 = field1977[var4];
      int var19 = var17 * var6 + var18 * var7 >> 16;

      for(int var20 = 0; var20 < this.field1916; ++var20) {
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
         field1955[var20] = var23 - var19;
         field1953[var20] = var9 + var21 * Graphics3D.field2011 / var8;
         field1954[var20] = var10 + var24 * Graphics3D.field2011 / var8;
         if(this.field1960 > 0) {
            yViewportBuffer[var20] = var21;
            field1979[var20] = var24;
            field1958[var20] = var23;
         }
      }

      try {
         this.method2582(false, false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("r")
   public int method2521() {
      this.method2519();
      return this.XYZMag;
   }
}
