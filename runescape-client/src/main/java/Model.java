import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("az")
   static boolean[] field1952;
   @ObfuscatedName("ay")
   static int[] field1965;
   @ObfuscatedName("bw")
   static int[] field1981;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lej;"
   )
   static Model field1919;
   @ObfuscatedName("r")
   static byte[] field1920;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lej;"
   )
   static Model field1953;
   @ObfuscatedName("bb")
   static int field1984;
   @ObfuscatedName("j")
   static byte[] field1956;
   @ObfuscatedName("bg")
   static int[] field1932;
   @ObfuscatedName("bn")
   static int field1976;
   @ObfuscatedName("ad")
   static boolean[] field1971;
   @ObfuscatedName("bs")
   static int field1977;
   @ObfuscatedName("ah")
   static int[] field1963;
   @ObfuscatedName("ac")
   static int[] field1967;
   @ObfuscatedName("bd")
   static int[] field1986;
   @ObfuscatedName("at")
   @Export("yViewportBuffer")
   static int[] yViewportBuffer;
   @ObfuscatedName("ba")
   static int[] field1921;
   @ObfuscatedName("as")
   static int[] field1982;
   @ObfuscatedName("al")
   static int[] field1962;
   @ObfuscatedName("ao")
   static int[][] field1966;
   @ObfuscatedName("bl")
   static int[] field1973;
   @ObfuscatedName("av")
   static int[] field1959;
   @ObfuscatedName("bz")
   static int[] field1918;
   @ObfuscatedName("bc")
   @Export("xViewportBuffer")
   static int[] xViewportBuffer;
   @ObfuscatedName("ab")
   static int[] field1960;
   @ObfuscatedName("bt")
   static int[] field1923;
   @ObfuscatedName("af")
   static int[][] field1968;
   @ObfuscatedName("bp")
   static int[] field1969;
   @ObfuscatedName("bi")
   static int[] field1970;
   @ObfuscatedName("bh")
   public static boolean field1978;
   @ObfuscatedName("ap")
   int field1943;
   @ObfuscatedName("aa")
   public int field1947;
   @ObfuscatedName("ae")
   int field1944;
   @ObfuscatedName("q")
   int[][] field1957;
   @ObfuscatedName("v")
   int field1941;
   @ObfuscatedName("am")
   public int field1949;
   @ObfuscatedName("p")
   @Export("indices1")
   int[] indices1;
   @ObfuscatedName("ak")
   @Export("XYZMag")
   int XYZMag;
   @ObfuscatedName("w")
   int field1972;
   @ObfuscatedName("e")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("s")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("m")
   @Export("indices2")
   int[] indices2;
   @ObfuscatedName("u")
   @Export("indices3")
   int[] indices3;
   @ObfuscatedName("l")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("y")
   int[][] field1942;
   @ObfuscatedName("h")
   byte field1983;
   @ObfuscatedName("au")
   int field1958;
   @ObfuscatedName("z")
   int field1937;
   @ObfuscatedName("o")
   byte[] field1933;
   @ObfuscatedName("aw")
   public int field1950;
   @ObfuscatedName("g")
   int[] field1961;
   @ObfuscatedName("c")
   byte[] field1925;
   @ObfuscatedName("t")
   int[] field1931;
   @ObfuscatedName("ag")
   public int field1974;
   @ObfuscatedName("ai")
   public boolean field1975;
   @ObfuscatedName("k")
   int[] field1930;
   @ObfuscatedName("f")
   short[] field1935;
   @ObfuscatedName("aq")
   public int field1951;
   @ObfuscatedName("ar")
   int field1948;
   @ObfuscatedName("aj")
   public int field1954;
   @ObfuscatedName("x")
   byte[] field1934;
   @ObfuscatedName("i")
   int[] field1938;
   @ObfuscatedName("d")
   int[] field1939;
   @ObfuscatedName("b")
   int[] field1940;

   static {
      field1953 = new Model();
      field1956 = new byte[1];
      field1919 = new Model();
      field1920 = new byte[1];
      field1971 = new boolean[4700];
      field1952 = new boolean[4700];
      field1982 = new int[4700];
      field1959 = new int[4700];
      field1960 = new int[4700];
      yViewportBuffer = new int[4700];
      field1962 = new int[4700];
      field1963 = new int[4700];
      field1965 = new int[1600];
      field1966 = new int[1600][512];
      field1967 = new int[12];
      field1968 = new int[12][2000];
      field1969 = new int[2000];
      field1970 = new int[2000];
      field1921 = new int[12];
      field1986 = new int[10];
      field1973 = new int[10];
      xViewportBuffer = new int[10];
      field1978 = true;
      field1981 = Graphics3D.SINE;
      field1932 = Graphics3D.COSINE;
      field1923 = Graphics3D.colorPalette;
      field1918 = Graphics3D.field2032;
   }

   Model() {
      this.field1941 = 0;
      this.field1972 = 0;
      this.field1983 = 0;
      this.field1937 = 0;
      this.field1975 = false;
      this.field1947 = -1;
      this.field1974 = -1;
      this.field1954 = -1;
   }

   @ObfuscatedSignature(
      signature = "([Lej;I)V"
   )
   public Model(Model[] var1, int var2) {
      this.field1941 = 0;
      this.field1972 = 0;
      this.field1983 = 0;
      this.field1937 = 0;
      this.field1975 = false;
      this.field1947 = -1;
      this.field1974 = -1;
      this.field1954 = -1;
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1941 = 0;
      this.field1972 = 0;
      this.field1937 = 0;
      this.field1983 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1941 += var8.field1941;
            this.field1972 += var8.field1972;
            this.field1937 += var8.field1937;
            if(var8.field1925 != null) {
               var3 = true;
            } else {
               if(this.field1983 == -1) {
                  this.field1983 = var8.field1983;
               }

               if(this.field1983 != var8.field1983) {
                  var3 = true;
               }
            }

            var4 |= var8.field1933 != null;
            var5 |= var8.field1935 != null;
            var6 |= var8.field1934 != null;
         }
      }

      this.verticesX = new int[this.field1941];
      this.verticesY = new int[this.field1941];
      this.verticesZ = new int[this.field1941];
      this.indices1 = new int[this.field1972];
      this.indices2 = new int[this.field1972];
      this.indices3 = new int[this.field1972];
      this.field1961 = new int[this.field1972];
      this.field1930 = new int[this.field1972];
      this.field1931 = new int[this.field1972];
      if(var3) {
         this.field1925 = new byte[this.field1972];
      }

      if(var4) {
         this.field1933 = new byte[this.field1972];
      }

      if(var5) {
         this.field1935 = new short[this.field1972];
      }

      if(var6) {
         this.field1934 = new byte[this.field1972];
      }

      if(this.field1937 > 0) {
         this.field1938 = new int[this.field1937];
         this.field1939 = new int[this.field1937];
         this.field1940 = new int[this.field1937];
      }

      this.field1941 = 0;
      this.field1972 = 0;
      this.field1937 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1972; ++var9) {
               this.indices1[this.field1972] = this.field1941 + var8.indices1[var9];
               this.indices2[this.field1972] = this.field1941 + var8.indices2[var9];
               this.indices3[this.field1972] = this.field1941 + var8.indices3[var9];
               this.field1961[this.field1972] = var8.field1961[var9];
               this.field1930[this.field1972] = var8.field1930[var9];
               this.field1931[this.field1972] = var8.field1931[var9];
               if(var3) {
                  if(var8.field1925 != null) {
                     this.field1925[this.field1972] = var8.field1925[var9];
                  } else {
                     this.field1925[this.field1972] = var8.field1983;
                  }
               }

               if(var4 && var8.field1933 != null) {
                  this.field1933[this.field1972] = var8.field1933[var9];
               }

               if(var5) {
                  if(var8.field1935 != null) {
                     this.field1935[this.field1972] = var8.field1935[var9];
                  } else {
                     this.field1935[this.field1972] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1934 != null && var8.field1934[var9] != -1) {
                     this.field1934[this.field1972] = (byte)(this.field1937 + var8.field1934[var9]);
                  } else {
                     this.field1934[this.field1972] = -1;
                  }
               }

               ++this.field1972;
            }

            for(var9 = 0; var9 < var8.field1937; ++var9) {
               this.field1938[this.field1937] = this.field1941 + var8.field1938[var9];
               this.field1939[this.field1937] = this.field1941 + var8.field1939[var9];
               this.field1940[this.field1937] = this.field1941 + var8.field1940[var9];
               ++this.field1937;
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

   @ObfuscatedName("l")
   public void method2542() {
      if(this.field1944 != 1) {
         this.field1944 = 1;
         super.modelHeight = 0;
         this.field1958 = 0;
         this.XYZMag = 0;

         for(int var1 = 0; var1 < this.field1941; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1958) {
               this.field1958 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.XYZMag) {
               this.XYZMag = var5;
            }
         }

         this.XYZMag = (int)(Math.sqrt((double)this.XYZMag) + 0.99D);
         this.field1948 = (int)(Math.sqrt((double)(this.XYZMag * this.XYZMag + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1943 = this.field1948 + (int)(Math.sqrt((double)(this.XYZMag * this.XYZMag + this.field1958 * this.field1958)) + 0.99D);
      }
   }

   @ObfuscatedName("ak")
   final void method2517(int var1) {
      int var2 = Graphics3D.centerX;
      int var3 = Graphics3D.centerY;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1963[var5];
      int var9 = field1963[var6];
      int var10 = field1963[var7];
      if(this.field1933 == null) {
         Graphics3D.rasterAlpha = 0;
      } else {
         Graphics3D.rasterAlpha = this.field1933[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1986[var4] = field1982[var5];
         field1973[var4] = field1959[var5];
         xViewportBuffer[var4++] = this.field1961[var1];
      } else {
         var11 = yViewportBuffer[var5];
         var12 = field1962[var5];
         var13 = this.field1961[var1];
         if(var10 >= 50) {
            var14 = field1918[var10 - var8] * (50 - var8);
            field1986[var4] = var2 + Graphics3D.field2026 * (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) / 50;
            field1973[var4] = var3 + Graphics3D.field2026 * (var12 + ((field1962[var7] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1931[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = field1918[var9 - var8] * (50 - var8);
            field1986[var4] = var2 + Graphics3D.field2026 * (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) / 50;
            field1973[var4] = var3 + Graphics3D.field2026 * (var12 + ((field1962[var6] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1930[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1986[var4] = field1982[var6];
         field1973[var4] = field1959[var6];
         xViewportBuffer[var4++] = this.field1930[var1];
      } else {
         var11 = yViewportBuffer[var6];
         var12 = field1962[var6];
         var13 = this.field1930[var1];
         if(var8 >= 50) {
            var14 = field1918[var8 - var9] * (50 - var9);
            field1986[var4] = var2 + Graphics3D.field2026 * (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) / 50;
            field1973[var4] = var3 + Graphics3D.field2026 * (var12 + ((field1962[var5] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1961[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = field1918[var10 - var9] * (50 - var9);
            field1986[var4] = var2 + Graphics3D.field2026 * (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) / 50;
            field1973[var4] = var3 + Graphics3D.field2026 * (var12 + ((field1962[var7] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1931[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1986[var4] = field1982[var7];
         field1973[var4] = field1959[var7];
         xViewportBuffer[var4++] = this.field1931[var1];
      } else {
         var11 = yViewportBuffer[var7];
         var12 = field1962[var7];
         var13 = this.field1931[var1];
         if(var9 >= 50) {
            var14 = field1918[var9 - var10] * (50 - var10);
            field1986[var4] = var2 + Graphics3D.field2026 * (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) / 50;
            field1973[var4] = var3 + Graphics3D.field2026 * (var12 + ((field1962[var6] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1930[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = field1918[var8 - var10] * (50 - var10);
            field1986[var4] = var2 + Graphics3D.field2026 * (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) / 50;
            field1973[var4] = var3 + Graphics3D.field2026 * (var12 + ((field1962[var5] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1961[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1986[0];
      var12 = field1986[1];
      var13 = field1986[2];
      var14 = field1973[0];
      int var15 = field1973[1];
      int var16 = field1973[2];
      Graphics3D.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX) {
            Graphics3D.rasterClipEnable = true;
         }

         if(this.field1935 != null && this.field1935[var1] != -1) {
            if(this.field1934 != null && this.field1934[var1] != -1) {
               var20 = this.field1934[var1] & 255;
               var17 = this.field1938[var20];
               var18 = this.field1939[var20];
               var19 = this.field1940[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1931[var1] == -1) {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1961[var1], this.field1961[var1], this.field1961[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1962[var17], field1962[var18], field1962[var19], field1963[var17], field1963[var18], field1963[var19], this.field1935[var1]);
            } else {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1962[var17], field1962[var18], field1962[var19], field1963[var17], field1963[var18], field1963[var19], this.field1935[var1]);
            }
         } else if(this.field1931[var1] == -1) {
            Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, field1923[this.field1961[var1]]);
         } else {
            Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX || field1986[3] < 0 || field1986[3] > Graphics3D.rasterClipX) {
            Graphics3D.rasterClipEnable = true;
         }

         if(this.field1935 != null && this.field1935[var1] != -1) {
            if(this.field1934 != null && this.field1934[var1] != -1) {
               var20 = this.field1934[var1] & 255;
               var17 = this.field1938[var20];
               var18 = this.field1939[var20];
               var19 = this.field1940[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1935[var1];
            if(this.field1931[var1] == -1) {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1961[var1], this.field1961[var1], this.field1961[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1962[var17], field1962[var18], field1962[var19], field1963[var17], field1963[var18], field1963[var19], var21);
               Graphics3D.rasterTextureAffine(var14, var16, field1973[3], var11, var13, field1986[3], this.field1961[var1], this.field1961[var1], this.field1961[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1962[var17], field1962[var18], field1962[var19], field1963[var17], field1963[var18], field1963[var19], var21);
            } else {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1962[var17], field1962[var18], field1962[var19], field1963[var17], field1963[var18], field1963[var19], var21);
               Graphics3D.rasterTextureAffine(var14, var16, field1973[3], var11, var13, field1986[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1962[var17], field1962[var18], field1962[var19], field1963[var17], field1963[var18], field1963[var19], var21);
            }
         } else if(this.field1931[var1] == -1) {
            var17 = field1923[this.field1961[var1]];
            Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            Graphics3D.rasterFlat(var14, var16, field1973[3], var11, var13, field1986[3], var17);
         } else {
            Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
            Graphics3D.rasterGouraud(var14, var16, field1973[3], var11, var13, field1986[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3]);
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Let;I)V"
   )
   public void method2519(Frames var1, int var2) {
      if(this.field1957 != null) {
         if(var2 != -1) {
            Frame var3 = var1.skeletons[var2];
            FrameMap var4 = var3.skin;
            field1984 = 0;
            field1976 = 0;
            field1977 = 0;

            for(int var5 = 0; var5 < var3.field1884; ++var5) {
               int var6 = var3.field1886[var5];
               this.method2505(var4.types[var6], var4.list[var6], var3.translator_x[var5], var3.translator_y[var5], var3.translator_z[var5]);
            }

            this.method2559();
         }
      }
   }

   @ObfuscatedName("p")
   void method2559() {
      this.field1944 = 0;
      this.field1947 = -1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ZLej;[B)Lej;"
   )
   Model method2493(boolean var1, Model var2, byte[] var3) {
      var2.field1941 = this.field1941;
      var2.field1972 = this.field1972;
      var2.field1937 = this.field1937;
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
         var2.field1933 = this.field1933;
      } else {
         var2.field1933 = var3;
         if(this.field1933 == null) {
            for(var4 = 0; var4 < this.field1972; ++var4) {
               var2.field1933[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1972; ++var4) {
               var2.field1933[var4] = this.field1933[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1961 = this.field1961;
      var2.field1930 = this.field1930;
      var2.field1931 = this.field1931;
      var2.field1925 = this.field1925;
      var2.field1934 = this.field1934;
      var2.field1935 = this.field1935;
      var2.field1983 = this.field1983;
      var2.field1938 = this.field1938;
      var2.field1939 = this.field1939;
      var2.field1940 = this.field1940;
      var2.field1957 = this.field1957;
      var2.field1942 = this.field1942;
      var2.field1975 = this.field1975;
      var2.method2559();
      return var2;
   }

   @ObfuscatedName("e")
   void method2498(int var1) {
      if(this.field1947 == -1) {
         int var2 = 0;
         int var3 = 0;
         int var4 = 0;
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         int var8 = field1932[var1];
         int var9 = field1981[var1];

         for(int var10 = 0; var10 < this.field1941; ++var10) {
            int var11 = Graphics3D.method2655(this.verticesX[var10], this.verticesZ[var10], var8, var9);
            int var12 = this.verticesY[var10];
            int var13 = Graphics3D.method2612(this.verticesX[var10], this.verticesZ[var10], var8, var9);
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

         this.field1949 = (var5 + var2) / 2;
         this.field1950 = (var6 + var3) / 2;
         this.field1951 = (var7 + var4) / 2;
         this.field1947 = (var5 - var2 + 1) / 2;
         this.field1974 = (var6 - var3 + 1) / 2;
         this.field1954 = (var7 - var4 + 1) / 2;
         if(this.field1947 < 32) {
            this.field1947 = 32;
         }

         if(this.field1954 < 32) {
            this.field1954 = 32;
         }

         if(this.field1975) {
            this.field1947 += 8;
            this.field1954 += 8;
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Z)Lej;"
   )
   public Model method2495(boolean var1) {
      if(!var1 && field1956.length < this.field1972) {
         field1956 = new byte[this.field1972 + 100];
      }

      return this.method2493(var1, field1953, field1956);
   }

   @ObfuscatedName("s")
   void method2500() {
      if(this.field1944 != 2) {
         this.field1944 = 2;
         this.XYZMag = 0;

         for(int var1 = 0; var1 < this.field1941; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var3 * var3 + var2 * var2 + var4 * var4;
            if(var5 > this.XYZMag) {
               this.XYZMag = var5;
            }
         }

         this.XYZMag = (int)(Math.sqrt((double)this.XYZMag) + 0.99D);
         this.field1948 = this.XYZMag;
         this.field1943 = this.XYZMag + this.XYZMag;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Z)Lej;"
   )
   public Model method2496(boolean var1) {
      if(!var1 && field1920.length < this.field1972) {
         field1920 = new byte[this.field1972 + 100];
      }

      return this.method2493(var1, field1919, field1920);
   }

   @ObfuscatedName("h")
   public void method2509(int var1) {
      int var2 = field1981[var1];
      int var3 = field1932[var1];

      for(int var4 = 0; var4 < this.field1941; ++var4) {
         int var5 = var3 * this.verticesY[var4] - var2 * this.verticesZ[var4] >> 16;
         this.verticesZ[var4] = var2 * this.verticesY[var4] + var3 * this.verticesZ[var4] >> 16;
         this.verticesY[var4] = var5;
      }

      this.method2559();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([[IIIIZI)Lej;"
   )
   public Model method2525(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2542();
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
               var11.field1941 = this.field1941;
               var11.field1972 = this.field1972;
               var11.field1937 = this.field1937;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1961 = this.field1961;
               var11.field1930 = this.field1930;
               var11.field1931 = this.field1931;
               var11.field1925 = this.field1925;
               var11.field1933 = this.field1933;
               var11.field1934 = this.field1934;
               var11.field1935 = this.field1935;
               var11.field1983 = this.field1983;
               var11.field1938 = this.field1938;
               var11.field1939 = this.field1939;
               var11.field1940 = this.field1940;
               var11.field1957 = this.field1957;
               var11.field1942 = this.field1942;
               var11.field1975 = this.field1975;
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
                  var13 = var2 + this.verticesX[var12];
                  var14 = var4 + this.verticesZ[var12];
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var15 * var1[var17 + 1][var18] + var1[var17][var18] * (128 - var15) >> 7;
                  var20 = var1[var17 + 1][var18 + 1] * var15 + var1[var17][var18 + 1] * (128 - var15) >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.verticesY[var12] = var21 + this.verticesY[var12] - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1941; ++var12) {
                  var13 = (-this.verticesY[var12] << 16) / super.modelHeight;
                  if(var13 < var6) {
                     var14 = var2 + this.verticesX[var12];
                     var15 = var4 + this.verticesZ[var12];
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18 + 1][var19] * var16 + var1[var18][var19] * (128 - var16) >> 7;
                     var21 = var1[var18 + 1][var19 + 1] * var16 + var1[var18][var19 + 1] * (128 - var16) >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.verticesY[var12] = (var6 - var13) * (var22 - var3) / var6 + this.verticesY[var12];
                  }
               }
            }

            var11.method2559();
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("x")
   public void method2521() {
      for(int var1 = 0; var1 < this.field1941; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.method2559();
   }

   @ObfuscatedName("cf")
   @Export("draw")
   void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1965[0] = -1;
      if(this.field1944 != 1) {
         this.method2542();
      }

      this.method2498(var1);
      int var10 = var5 * var8 - var4 * var6 >> 16;
      int var11 = var2 * var7 + var3 * var10 >> 16;
      int var12 = var3 * this.XYZMag >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var5 * var6 >> 16;
         int var15 = (var14 - this.XYZMag) * Graphics3D.field2026;
         if(var15 / var13 < Graphics3D.field2025) {
            int var16 = (var14 + this.XYZMag) * Graphics3D.field2026;
            if(var16 / var13 > Graphics3D.field2024) {
               int var17 = var3 * var7 - var10 * var2 >> 16;
               int var18 = var2 * this.XYZMag >> 16;
               int var19 = (var17 + var18) * Graphics3D.field2026;
               if(var19 / var13 > Graphics3D.field2021) {
                  int var20 = (super.modelHeight * var3 >> 16) + var18;
                  int var21 = (var17 - var20) * Graphics3D.field2026;
                  if(var21 / var13 < Graphics3D.field2027) {
                     int var22 = var12 + (var2 * super.modelHeight >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1937 > 0;
                     int var26 = class269.method4796();
                     int var27 = class134.field1996;
                     boolean var29 = class43.method630();
                     if(class7.field232 && var9 > 0) {
                        if(class3.method9(this, var6, var7, var8)) {
                           class227.method4064(this, var6, var7, var8, -65281);
                        } else if(class11.field270 == class7.field229) {
                           class227.method4064(this, var6, var7, var8, -16776961);
                        }
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
                     if(class7.field227 && var9 > 0) {
                        int var42 = var11 - var12;
                        if(var42 <= 50) {
                           var42 = 50;
                        }

                        if(var14 > 0) {
                           var31 = var15 / var13;
                           var32 = var16 / var42;
                        } else {
                           var32 = var16 / var13;
                           var31 = var15 / var42;
                        }

                        if(var17 > 0) {
                           var33 = var21 / var13;
                           var34 = var19 / var42;
                        } else {
                           var34 = var19 / var13;
                           var33 = var21 / var42;
                        }

                        var35 = -8355840;
                        var36 = var26 - Graphics3D.centerX;
                        var37 = var27 - Graphics3D.centerY;
                        if(var36 > var31 && var36 < var32 && var37 > var33 && var37 < var34) {
                           var35 = -256;
                        }

                        var38 = var31 + Graphics3D.centerX;
                        var39 = var33 + Graphics3D.centerY;
                        int var40 = var32 + Graphics3D.centerX;
                        int var41 = var34 + Graphics3D.centerY;
                        class7.field226.method3563(new class8(var38, var39, var40, var41, var35));
                     }

                     boolean var46 = false;
                     if(var9 > 0 && var29) {
                        boolean var45 = false;
                        if(field1978) {
                           var45 = class3.method9(this, var6, var7, var8);
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
                           var34 = var27 - Graphics3D.centerY;
                           if(var33 > var15 && var33 < var16 && var34 > var21 && var34 < var19) {
                              var45 = true;
                           }
                        }

                        if(var45) {
                           if(this.field1975) {
                              CombatInfoListHolder.method1662(var9);
                           } else {
                              var46 = true;
                           }
                        }
                     }

                     var31 = Graphics3D.centerX;
                     var32 = Graphics3D.centerY;
                     var33 = 0;
                     var34 = 0;
                     if(var1 != 0) {
                        var33 = field1981[var1];
                        var34 = field1932[var1];
                     }

                     for(var35 = 0; var35 < this.field1941; ++var35) {
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
                        field1960[var35] = var38 - var11;
                        if(var38 >= 50) {
                           field1982[var35] = var36 * Graphics3D.field2026 / var38 + var31;
                           field1959[var35] = var39 * Graphics3D.field2026 / var38 + var32;
                        } else {
                           field1982[var35] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           yViewportBuffer[var35] = var36;
                           field1962[var35] = var39;
                           field1963[var35] = var38;
                        }
                     }

                     try {
                        this.method2503(var23, var46, this.field1975, var9);
                     } catch (Exception var44) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("o")
   public void method2515() {
      for(int var1 = 0; var1 < this.field1941; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.method2559();
   }

   @ObfuscatedName("i")
   public void method2524(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1941; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = var2 * this.verticesY[var4] / 128;
         this.verticesZ[var4] = var3 * this.verticesZ[var4] / 128;
      }

      this.method2559();
   }

   @ObfuscatedName("c")
   public void method2506() {
      for(int var1 = 0; var1 < this.field1941; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.method2559();
   }

   @ObfuscatedName("au")
   final void method2516(int var1) {
      if(field1952[var1]) {
         this.method2517(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         Graphics3D.rasterClipEnable = field1971[var1];
         if(this.field1933 == null) {
            Graphics3D.rasterAlpha = 0;
         } else {
            Graphics3D.rasterAlpha = this.field1933[var1] & 255;
         }

         if(this.field1935 != null && this.field1935[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1934 != null && this.field1934[var1] != -1) {
               int var8 = this.field1934[var1] & 255;
               var5 = this.field1938[var8];
               var6 = this.field1939[var8];
               var7 = this.field1940[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1931[var1] == -1) {
               Graphics3D.rasterTextureAffine(field1959[var2], field1959[var3], field1959[var4], field1982[var2], field1982[var3], field1982[var4], this.field1961[var1], this.field1961[var1], this.field1961[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1962[var5], field1962[var6], field1962[var7], field1963[var5], field1963[var6], field1963[var7], this.field1935[var1]);
            } else {
               Graphics3D.rasterTextureAffine(field1959[var2], field1959[var3], field1959[var4], field1982[var2], field1982[var3], field1982[var4], this.field1961[var1], this.field1930[var1], this.field1931[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1962[var5], field1962[var6], field1962[var7], field1963[var5], field1963[var6], field1963[var7], this.field1935[var1]);
            }
         } else if(this.field1931[var1] == -1) {
            Graphics3D.rasterFlat(field1959[var2], field1959[var3], field1959[var4], field1982[var2], field1982[var3], field1982[var4], field1923[this.field1961[var1]]);
         } else {
            Graphics3D.rasterGouraud(field1959[var2], field1959[var3], field1959[var4], field1982[var2], field1982[var3], field1982[var4], this.field1961[var1], this.field1930[var1], this.field1931[var1]);
         }

      }
   }

   @ObfuscatedName("g")
   void method2505(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1984 = 0;
         field1976 = 0;
         field1977 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var9 = var2[var8];
            if(var9 < this.field1957.length) {
               int[] var10 = this.field1957[var9];

               for(var11 = 0; var11 < var10.length; ++var11) {
                  var12 = var10[var11];
                  field1984 += this.verticesX[var12];
                  field1976 += this.verticesY[var12];
                  field1977 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1984 = var3 + field1984 / var7;
            field1976 = var4 + field1976 / var7;
            field1977 = var5 + field1977 / var7;
         } else {
            field1984 = var3;
            field1976 = var4;
            field1977 = var5;
         }

      } else {
         int[] var18;
         int var19;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1957.length) {
                  var18 = this.field1957[var8];

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
               if(var8 < this.field1957.length) {
                  var18 = this.field1957[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= field1984;
                     this.verticesY[var11] -= field1976;
                     this.verticesZ[var11] -= field1977;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1981[var14];
                        var16 = field1932[var14];
                        var17 = var15 * this.verticesY[var11] + var16 * this.verticesX[var11] >> 16;
                        this.verticesY[var11] = var16 * this.verticesY[var11] - var15 * this.verticesX[var11] >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1981[var12];
                        var16 = field1932[var12];
                        var17 = var16 * this.verticesY[var11] - var15 * this.verticesZ[var11] >> 16;
                        this.verticesZ[var11] = var15 * this.verticesY[var11] + var16 * this.verticesZ[var11] >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1981[var13];
                        var16 = field1932[var13];
                        var17 = var15 * this.verticesZ[var11] + var16 * this.verticesX[var11] >> 16;
                        this.verticesZ[var11] = var16 * this.verticesZ[var11] - var15 * this.verticesX[var11] >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += field1984;
                     this.verticesY[var11] += field1976;
                     this.verticesZ[var11] += field1977;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1957.length) {
                  var18 = this.field1957[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= field1984;
                     this.verticesY[var11] -= field1976;
                     this.verticesZ[var11] -= field1977;
                     this.verticesX[var11] = var3 * this.verticesX[var11] / 128;
                     this.verticesY[var11] = var4 * this.verticesY[var11] / 128;
                     this.verticesZ[var11] = var5 * this.verticesZ[var11] / 128;
                     this.verticesX[var11] += field1984;
                     this.verticesY[var11] += field1976;
                     this.verticesZ[var11] += field1977;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1942 != null && this.field1933 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1942.length) {
                     var18 = this.field1942[var8];

                     for(var19 = 0; var19 < var18.length; ++var19) {
                        var11 = var18[var19];
                        var12 = (this.field1933[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1933[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Let;ILet;I[I)V"
   )
   public void method2504(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.skeletons[var2];
            Frame var7 = var3.skeletons[var4];
            FrameMap var8 = var6.skin;
            field1984 = 0;
            field1976 = 0;
            field1977 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1884; ++var11) {
               for(var12 = var6.field1886[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.types[var12] == 0) {
                  this.method2505(var8.types[var12], var8.list[var12], var6.translator_x[var11], var6.translator_y[var11], var6.translator_z[var11]);
               }
            }

            field1984 = 0;
            field1976 = 0;
            field1977 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1884; ++var11) {
               for(var12 = var7.field1886[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.types[var12] == 0) {
                  this.method2505(var8.types[var12], var8.list[var12], var7.translator_x[var11], var7.translator_y[var11], var7.translator_z[var11]);
               }
            }

            this.method2559();
         } else {
            this.method2519(var1, var2);
         }
      }
   }

   @ObfuscatedName("ae")
   final void method2503(boolean var1, boolean var2, boolean var3, int var4) {
      if(this.field1943 < 1600) {
         int var5;
         for(var5 = 0; var5 < this.field1943; ++var5) {
            field1965[var5] = 0;
         }

         var5 = var3?20:5;
         int var7;
         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         int var13;
         if(class7.field228 && var2) {
            Model var6 = this;

            for(var7 = 0; var7 < var6.field1972; ++var7) {
               if(var6.field1931[var7] != -2) {
                  var8 = var6.indices1[var7];
                  var9 = var6.indices2[var7];
                  var10 = var6.indices3[var7];
                  var11 = field1982[var8];
                  var12 = field1982[var9];
                  var13 = field1982[var10];
                  class44.method640(field1959[var8], field1959[var9], field1959[var10], var11, var12, var13, var5);
               }
            }
         }

         int var14;
         int var15;
         int var17;
         int var26;
         for(var26 = 0; var26 < this.field1972; ++var26) {
            if(this.field1931[var26] != -2) {
               var7 = this.indices1[var26];
               var8 = this.indices2[var26];
               var9 = this.indices3[var26];
               var10 = field1982[var7];
               var11 = field1982[var8];
               var12 = field1982[var9];
               int var16;
               if(!var1 || var10 != -5000 && var11 != -5000 && var12 != -5000) {
                  if(var2) {
                     var14 = field1959[var7];
                     var15 = field1959[var8];
                     var16 = field1959[var9];
                     var17 = var5 + class134.field1996;
                     boolean var32;
                     if(var17 < var14 && var17 < var15 && var17 < var16) {
                        var32 = false;
                     } else {
                        var17 = class134.field1996 - var5;
                        if(var17 > var14 && var17 > var15 && var17 > var16) {
                           var32 = false;
                        } else {
                           var17 = var5 + class134.field1991;
                           if(var17 < var10 && var17 < var11 && var17 < var12) {
                              var32 = false;
                           } else {
                              var17 = class134.field1991 - var5;
                              if(var17 > var10 && var17 > var11 && var17 > var12) {
                                 var32 = false;
                              } else {
                                 var32 = true;
                              }
                           }
                        }
                     }

                     if(var32) {
                        CombatInfoListHolder.method1662(var4);
                        var2 = false;
                     }
                  }

                  if((var10 - var11) * (field1959[var9] - field1959[var8]) - (var12 - var11) * (field1959[var7] - field1959[var8]) > 0) {
                     field1952[var26] = false;
                     if(var10 >= 0 && var11 >= 0 && var12 >= 0 && var10 <= Graphics3D.rasterClipX && var11 <= Graphics3D.rasterClipX && var12 <= Graphics3D.rasterClipX) {
                        field1971[var26] = false;
                     } else {
                        field1971[var26] = true;
                     }

                     var13 = (field1960[var9] + field1960[var7] + field1960[var8]) / 3 + this.field1948;
                     field1966[var13][field1965[var13]++] = var26;
                  }
               } else {
                  var13 = yViewportBuffer[var7];
                  var14 = yViewportBuffer[var8];
                  var15 = yViewportBuffer[var9];
                  var16 = field1962[var7];
                  var17 = field1962[var8];
                  int var18 = field1962[var9];
                  int var19 = field1963[var7];
                  int var20 = field1963[var8];
                  int var21 = field1963[var9];
                  var13 -= var14;
                  var15 -= var14;
                  var16 -= var17;
                  var18 -= var17;
                  var19 -= var20;
                  var21 -= var20;
                  int var22 = var16 * var21 - var19 * var18;
                  int var23 = var19 * var15 - var13 * var21;
                  int var24 = var13 * var18 - var16 * var15;
                  if(var20 * var24 + var14 * var22 + var17 * var23 > 0) {
                     field1952[var26] = true;
                     int var25 = (field1960[var9] + field1960[var7] + field1960[var8]) / 3 + this.field1948;
                     field1966[var25][field1965[var25]++] = var26;
                  }
               }
            }
         }

         int[] var27;
         if(this.field1925 == null) {
            for(var26 = this.field1943 - 1; var26 >= 0; --var26) {
               var7 = field1965[var26];
               if(var7 > 0) {
                  var27 = field1966[var26];

                  for(var9 = 0; var9 < var7; ++var9) {
                     this.method2516(var27[var9]);
                  }
               }
            }

         } else {
            for(var26 = 0; var26 < 12; ++var26) {
               field1967[var26] = 0;
               field1921[var26] = 0;
            }

            for(var26 = this.field1943 - 1; var26 >= 0; --var26) {
               var7 = field1965[var26];
               if(var7 > 0) {
                  var27 = field1966[var26];

                  for(var9 = 0; var9 < var7; ++var9) {
                     var10 = var27[var9];
                     byte var31 = this.field1925[var10];
                     var12 = field1967[var31]++;
                     field1968[var31][var12] = var10;
                     if(var31 < 10) {
                        field1921[var31] += var26;
                     } else if(var31 == 10) {
                        field1969[var12] = var26;
                     } else {
                        field1970[var12] = var26;
                     }
                  }
               }
            }

            var26 = 0;
            if(field1967[1] > 0 || field1967[2] > 0) {
               var26 = (field1921[1] + field1921[2]) / (field1967[1] + field1967[2]);
            }

            var7 = 0;
            if(field1967[3] > 0 || field1967[4] > 0) {
               var7 = (field1921[3] + field1921[4]) / (field1967[3] + field1967[4]);
            }

            var8 = 0;
            if(field1967[6] > 0 || field1967[8] > 0) {
               var8 = (field1921[8] + field1921[6]) / (field1967[8] + field1967[6]);
            }

            var10 = 0;
            var11 = field1967[10];
            int[] var28 = field1968[10];
            int[] var29 = field1969;
            if(var10 == var11) {
               var10 = 0;
               var11 = field1967[11];
               var28 = field1968[11];
               var29 = field1970;
            }

            if(var10 < var11) {
               var9 = var29[var10];
            } else {
               var9 = -1000;
            }

            for(var14 = 0; var14 < 10; ++var14) {
               while(var14 == 0 && var9 > var26) {
                  this.method2516(var28[var10++]);
                  if(var10 == var11 && var28 != field1968[11]) {
                     var10 = 0;
                     var11 = field1967[11];
                     var28 = field1968[11];
                     var29 = field1970;
                  }

                  if(var10 < var11) {
                     var9 = var29[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 3 && var9 > var7) {
                  this.method2516(var28[var10++]);
                  if(var10 == var11 && var28 != field1968[11]) {
                     var10 = 0;
                     var11 = field1967[11];
                     var28 = field1968[11];
                     var29 = field1970;
                  }

                  if(var10 < var11) {
                     var9 = var29[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 5 && var9 > var8) {
                  this.method2516(var28[var10++]);
                  if(var10 == var11 && var28 != field1968[11]) {
                     var10 = 0;
                     var11 = field1967[11];
                     var28 = field1968[11];
                     var29 = field1970;
                  }

                  if(var10 < var11) {
                     var9 = var29[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               var15 = field1967[var14];
               int[] var30 = field1968[var14];

               for(var17 = 0; var17 < var15; ++var17) {
                  this.method2516(var30[var17]);
               }
            }

            while(var9 != -1000) {
               this.method2516(var28[var10++]);
               if(var10 == var11 && var28 != field1968[11]) {
                  var10 = 0;
                  var28 = field1968[11];
                  var11 = field1967[11];
                  var29 = field1970;
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

   @ObfuscatedName("z")
   public void method2575(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1941; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.method2559();
   }

   @ObfuscatedName("d")
   public final void method2512(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1965[0] = -1;
      if(this.field1944 != 2 && this.field1944 != 1) {
         this.method2500();
      }

      int var8 = Graphics3D.centerX;
      int var9 = Graphics3D.centerY;
      int var10 = field1981[var1];
      int var11 = field1932[var1];
      int var12 = field1981[var2];
      int var13 = field1932[var2];
      int var14 = field1981[var3];
      int var15 = field1932[var3];
      int var16 = field1981[var4];
      int var17 = field1932[var4];
      int var18 = var16 * var6 + var17 * var7 >> 16;

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
         field1960[var19] = var22 - var18;
         field1982[var19] = var20 * Graphics3D.field2026 / var22 + var8;
         field1959[var19] = var23 * Graphics3D.field2026 / var22 + var9;
         if(this.field1937 > 0) {
            yViewportBuffer[var19] = var20;
            field1962[var19] = var23;
            field1963[var19] = var22;
         }
      }

      try {
         this.method2503(false, false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("ai")
   public final void method2513(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1965[0] = -1;
      if(this.field1944 != 2 && this.field1944 != 1) {
         this.method2500();
      }

      int var9 = Graphics3D.centerX;
      int var10 = Graphics3D.centerY;
      int var11 = field1981[var1];
      int var12 = field1932[var1];
      int var13 = field1981[var2];
      int var14 = field1932[var2];
      int var15 = field1981[var3];
      int var16 = field1932[var3];
      int var17 = field1981[var4];
      int var18 = field1932[var4];
      int var19 = var17 * var6 + var18 * var7 >> 16;

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
         field1960[var20] = var23 - var19;
         field1982[var20] = var9 + var21 * Graphics3D.field2026 / var8;
         field1959[var20] = var10 + var24 * Graphics3D.field2026 / var8;
         if(this.field1937 > 0) {
            yViewportBuffer[var20] = var21;
            field1962[var20] = var24;
            field1963[var20] = var23;
         }
      }

      try {
         this.method2503(false, false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("w")
   public int method2522() {
      this.method2542();
      return this.XYZMag;
   }
}
