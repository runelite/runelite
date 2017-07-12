import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("et")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("at")
   static boolean[] field1971;
   @ObfuscatedName("ag")
   static int[] field1957;
   @ObfuscatedName("bj")
   static int[] field1999;
   @ObfuscatedName("a")
   static Model field1997;
   @ObfuscatedName("t")
   static byte[] field1934;
   @ObfuscatedName("i")
   static Model field1964;
   @ObfuscatedName("bp")
   static int field1972;
   @ObfuscatedName("w")
   static byte[] field1955;
   @ObfuscatedName("bx")
   static int[] field1996;
   @ObfuscatedName("br")
   static int field1990;
   @ObfuscatedName("ac")
   static boolean[] field1970;
   @ObfuscatedName("bg")
   static int field1991;
   @ObfuscatedName("ad")
   static int[] field1977;
   @ObfuscatedName("af")
   static int[] field1981;
   @ObfuscatedName("bv")
   static int[] field1986;
   @ObfuscatedName("az")
   @Export("yViewportBuffer")
   static int[] yViewportBuffer;
   @ObfuscatedName("be")
   static int[] field1985;
   @ObfuscatedName("al")
   static int[] field1978;
   @ObfuscatedName("av")
   static int[] field1963;
   @ObfuscatedName("ap")
   static int[][] field1980;
   @ObfuscatedName("bt")
   static int[] field1987;
   @ObfuscatedName("aa")
   static int[] field1973;
   @ObfuscatedName("bh")
   static int[] field1998;
   @ObfuscatedName("bl")
   @Export("xViewportBuffer")
   static int[] xViewportBuffer;
   @ObfuscatedName("am")
   static int[] field1974;
   @ObfuscatedName("bz")
   static int[] field1933;
   @ObfuscatedName("aj")
   static int[][] field1982;
   @ObfuscatedName("bb")
   static int[] field1983;
   @ObfuscatedName("bc")
   static int[] field1984;
   @ObfuscatedName("bo")
   public static boolean field1992;
   @ObfuscatedName("an")
   int field1960;
   @ObfuscatedName("as")
   public int field1966;
   @ObfuscatedName("ab")
   int field1958;
   @ObfuscatedName("g")
   int[][] field1995;
   @ObfuscatedName("s")
   int field1961;
   @ObfuscatedName("ar")
   public int field1969;
   @ObfuscatedName("k")
   @Export("indices1")
   int[] indices1;
   @ObfuscatedName("ai")
   @Export("XYZMag")
   int XYZMag;
   @ObfuscatedName("j")
   int field1939;
   @ObfuscatedName("r")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("y")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("e")
   @Export("indices2")
   int[] indices2;
   @ObfuscatedName("o")
   @Export("indices3")
   int[] indices3;
   @ObfuscatedName("v")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("x")
   int[][] field1956;
   @ObfuscatedName("u")
   byte field1994;
   @ObfuscatedName("aw")
   int field1959;
   @ObfuscatedName("p")
   int field1951;
   @ObfuscatedName("b")
   byte[] field1947;
   @ObfuscatedName("ay")
   public int field1989;
   @ObfuscatedName("z")
   int[] field1943;
   @ObfuscatedName("m")
   byte[] field1946;
   @ObfuscatedName("c")
   int[] field1945;
   @ObfuscatedName("ak")
   public int field1967;
   @ObfuscatedName("ah")
   public boolean field1950;
   @ObfuscatedName("l")
   int[] field1965;
   @ObfuscatedName("n")
   short[] field1949;
   @ObfuscatedName("ao")
   public int field1932;
   @ObfuscatedName("au")
   int field1962;
   @ObfuscatedName("aq")
   public int field1968;
   @ObfuscatedName("f")
   byte[] field1944;
   @ObfuscatedName("q")
   int[] field1952;
   @ObfuscatedName("d")
   int[] field1953;
   @ObfuscatedName("h")
   int[] field1931;

   static {
      field1964 = new Model();
      field1955 = new byte[1];
      field1997 = new Model();
      field1934 = new byte[1];
      field1970 = new boolean[4700];
      field1971 = new boolean[4700];
      field1963 = new int[4700];
      field1973 = new int[4700];
      field1974 = new int[4700];
      yViewportBuffer = new int[4700];
      field1978 = new int[4700];
      field1977 = new int[4700];
      field1957 = new int[1600];
      field1980 = new int[1600][512];
      field1981 = new int[12];
      field1982 = new int[12][2000];
      field1983 = new int[2000];
      field1984 = new int[2000];
      field1985 = new int[12];
      field1986 = new int[10];
      field1987 = new int[10];
      xViewportBuffer = new int[10];
      field1992 = true;
      field1999 = Graphics3D.SINE;
      field1996 = Graphics3D.COSINE;
      field1933 = Graphics3D.colorPalette;
      field1998 = Graphics3D.field2030;
   }

   Model() {
      this.field1961 = 0;
      this.field1939 = 0;
      this.field1994 = 0;
      this.field1951 = 0;
      this.field1950 = false;
      this.field1966 = -1;
      this.field1967 = -1;
      this.field1968 = -1;
   }

   public Model(Model[] var1, int var2) {
      this.field1961 = 0;
      this.field1939 = 0;
      this.field1994 = 0;
      this.field1951 = 0;
      this.field1950 = false;
      this.field1966 = -1;
      this.field1967 = -1;
      this.field1968 = -1;
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1961 = 0;
      this.field1939 = 0;
      this.field1951 = 0;
      this.field1994 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1961 += var8.field1961;
            this.field1939 += var8.field1939;
            this.field1951 += var8.field1951;
            if(var8.field1946 != null) {
               var3 = true;
            } else {
               if(this.field1994 == -1) {
                  this.field1994 = var8.field1994;
               }

               if(this.field1994 != var8.field1994) {
                  var3 = true;
               }
            }

            var4 |= var8.field1947 != null;
            var5 |= var8.field1949 != null;
            var6 |= var8.field1944 != null;
         }
      }

      this.verticesX = new int[this.field1961];
      this.verticesY = new int[this.field1961];
      this.verticesZ = new int[this.field1961];
      this.indices1 = new int[this.field1939];
      this.indices2 = new int[this.field1939];
      this.indices3 = new int[this.field1939];
      this.field1943 = new int[this.field1939];
      this.field1965 = new int[this.field1939];
      this.field1945 = new int[this.field1939];
      if(var3) {
         this.field1946 = new byte[this.field1939];
      }

      if(var4) {
         this.field1947 = new byte[this.field1939];
      }

      if(var5) {
         this.field1949 = new short[this.field1939];
      }

      if(var6) {
         this.field1944 = new byte[this.field1939];
      }

      if(this.field1951 > 0) {
         this.field1952 = new int[this.field1951];
         this.field1953 = new int[this.field1951];
         this.field1931 = new int[this.field1951];
      }

      this.field1961 = 0;
      this.field1939 = 0;
      this.field1951 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1939; ++var9) {
               this.indices1[this.field1939] = this.field1961 + var8.indices1[var9];
               this.indices2[this.field1939] = this.field1961 + var8.indices2[var9];
               this.indices3[this.field1939] = this.field1961 + var8.indices3[var9];
               this.field1943[this.field1939] = var8.field1943[var9];
               this.field1965[this.field1939] = var8.field1965[var9];
               this.field1945[this.field1939] = var8.field1945[var9];
               if(var3) {
                  if(var8.field1946 != null) {
                     this.field1946[this.field1939] = var8.field1946[var9];
                  } else {
                     this.field1946[this.field1939] = var8.field1994;
                  }
               }

               if(var4 && var8.field1947 != null) {
                  this.field1947[this.field1939] = var8.field1947[var9];
               }

               if(var5) {
                  if(var8.field1949 != null) {
                     this.field1949[this.field1939] = var8.field1949[var9];
                  } else {
                     this.field1949[this.field1939] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1944 != null && var8.field1944[var9] != -1) {
                     this.field1944[this.field1939] = (byte)(this.field1951 + var8.field1944[var9]);
                  } else {
                     this.field1944[this.field1939] = -1;
                  }
               }

               ++this.field1939;
            }

            for(var9 = 0; var9 < var8.field1951; ++var9) {
               this.field1952[this.field1951] = this.field1961 + var8.field1952[var9];
               this.field1953[this.field1951] = this.field1961 + var8.field1953[var9];
               this.field1931[this.field1951] = this.field1961 + var8.field1931[var9];
               ++this.field1951;
            }

            for(var9 = 0; var9 < var8.field1961; ++var9) {
               this.verticesX[this.field1961] = var8.verticesX[var9];
               this.verticesY[this.field1961] = var8.verticesY[var9];
               this.verticesZ[this.field1961] = var8.verticesZ[var9];
               ++this.field1961;
            }
         }
      }

   }

   @ObfuscatedName("v")
   public void method2493() {
      if(this.field1958 != 1) {
         this.field1958 = 1;
         super.modelHeight = 0;
         this.field1959 = 0;
         this.XYZMag = 0;

         for(int var1 = 0; var1 < this.field1961; ++var1) {
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
            if(var5 > this.XYZMag) {
               this.XYZMag = var5;
            }
         }

         this.XYZMag = (int)(Math.sqrt((double)this.XYZMag) + 0.99D);
         this.field1962 = (int)(Math.sqrt((double)(this.XYZMag * this.XYZMag + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1960 = this.field1962 + (int)(Math.sqrt((double)(this.XYZMag * this.XYZMag + this.field1959 * this.field1959)) + 0.99D);
      }
   }

   @ObfuscatedName("ai")
   final void method2511(int var1) {
      int var2 = Graphics3D.centerX;
      int var3 = Graphics3D.centerY;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1977[var5];
      int var9 = field1977[var6];
      int var10 = field1977[var7];
      if(this.field1947 == null) {
         Graphics3D.rasterAlpha = 0;
      } else {
         Graphics3D.rasterAlpha = this.field1947[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1986[var4] = field1963[var5];
         field1987[var4] = field1973[var5];
         xViewportBuffer[var4++] = this.field1943[var1];
      } else {
         var11 = yViewportBuffer[var5];
         var12 = field1978[var5];
         var13 = this.field1943[var1];
         if(var10 >= 50) {
            var14 = field1998[var10 - var8] * (50 - var8);
            field1986[var4] = var2 + Graphics3D.field2031 * (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) / 50;
            field1987[var4] = var3 + Graphics3D.field2031 * (var12 + ((field1978[var7] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1945[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = field1998[var9 - var8] * (50 - var8);
            field1986[var4] = var2 + Graphics3D.field2031 * (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) / 50;
            field1987[var4] = var3 + Graphics3D.field2031 * (var12 + ((field1978[var6] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1965[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1986[var4] = field1963[var6];
         field1987[var4] = field1973[var6];
         xViewportBuffer[var4++] = this.field1965[var1];
      } else {
         var11 = yViewportBuffer[var6];
         var12 = field1978[var6];
         var13 = this.field1965[var1];
         if(var8 >= 50) {
            var14 = field1998[var8 - var9] * (50 - var9);
            field1986[var4] = var2 + Graphics3D.field2031 * (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) / 50;
            field1987[var4] = var3 + Graphics3D.field2031 * (var12 + ((field1978[var5] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1943[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = field1998[var10 - var9] * (50 - var9);
            field1986[var4] = var2 + Graphics3D.field2031 * (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) / 50;
            field1987[var4] = var3 + Graphics3D.field2031 * (var12 + ((field1978[var7] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1945[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1986[var4] = field1963[var7];
         field1987[var4] = field1973[var7];
         xViewportBuffer[var4++] = this.field1945[var1];
      } else {
         var11 = yViewportBuffer[var7];
         var12 = field1978[var7];
         var13 = this.field1945[var1];
         if(var9 >= 50) {
            var14 = field1998[var9 - var10] * (50 - var10);
            field1986[var4] = var2 + Graphics3D.field2031 * (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) / 50;
            field1987[var4] = var3 + Graphics3D.field2031 * (var12 + ((field1978[var6] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1965[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = field1998[var8 - var10] * (50 - var10);
            field1986[var4] = var2 + Graphics3D.field2031 * (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) / 50;
            field1987[var4] = var3 + Graphics3D.field2031 * (var12 + ((field1978[var5] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1943[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1986[0];
      var12 = field1986[1];
      var13 = field1986[2];
      var14 = field1987[0];
      int var15 = field1987[1];
      int var16 = field1987[2];
      Graphics3D.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX) {
            Graphics3D.rasterClipEnable = true;
         }

         if(this.field1949 != null && this.field1949[var1] != -1) {
            if(this.field1944 != null && this.field1944[var1] != -1) {
               var20 = this.field1944[var1] & 255;
               var17 = this.field1952[var20];
               var18 = this.field1953[var20];
               var19 = this.field1931[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1945[var1] == -1) {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1943[var1], this.field1943[var1], this.field1943[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1978[var17], field1978[var18], field1978[var19], field1977[var17], field1977[var18], field1977[var19], this.field1949[var1]);
            } else {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1978[var17], field1978[var18], field1978[var19], field1977[var17], field1977[var18], field1977[var19], this.field1949[var1]);
            }
         } else if(this.field1945[var1] == -1) {
            Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, field1933[this.field1943[var1]]);
         } else {
            Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX || field1986[3] < 0 || field1986[3] > Graphics3D.rasterClipX) {
            Graphics3D.rasterClipEnable = true;
         }

         if(this.field1949 != null && this.field1949[var1] != -1) {
            if(this.field1944 != null && this.field1944[var1] != -1) {
               var20 = this.field1944[var1] & 255;
               var17 = this.field1952[var20];
               var18 = this.field1953[var20];
               var19 = this.field1931[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1949[var1];
            if(this.field1945[var1] == -1) {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1943[var1], this.field1943[var1], this.field1943[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1978[var17], field1978[var18], field1978[var19], field1977[var17], field1977[var18], field1977[var19], var21);
               Graphics3D.rasterTextureAffine(var14, var16, field1987[3], var11, var13, field1986[3], this.field1943[var1], this.field1943[var1], this.field1943[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1978[var17], field1978[var18], field1978[var19], field1977[var17], field1977[var18], field1977[var19], var21);
            } else {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1978[var17], field1978[var18], field1978[var19], field1977[var17], field1977[var18], field1977[var19], var21);
               Graphics3D.rasterTextureAffine(var14, var16, field1987[3], var11, var13, field1986[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1978[var17], field1978[var18], field1978[var19], field1977[var17], field1977[var18], field1977[var19], var21);
            }
         } else if(this.field1945[var1] == -1) {
            var17 = field1933[this.field1943[var1]];
            Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            Graphics3D.rasterFlat(var14, var16, field1987[3], var11, var13, field1986[3], var17);
         } else {
            Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
            Graphics3D.rasterGouraud(var14, var16, field1987[3], var11, var13, field1986[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3]);
         }
      }

   }

   @ObfuscatedName("e")
   public void method2497(Frames var1, int var2) {
      if(this.field1995 != null) {
         if(var2 != -1) {
            Frame var3 = var1.skeletons[var2];
            FrameMap var4 = var3.skin;
            field1972 = 0;
            field1990 = 0;
            field1991 = 0;

            for(int var5 = 0; var5 < var3.field1899; ++var5) {
               int var6 = var3.field1900[var5];
               this.method2525(var4.types[var6], var4.list[var6], var3.translator_x[var5], var3.translator_y[var5], var3.translator_z[var5]);
            }

            this.method2496();
         }
      }
   }

   @ObfuscatedName("k")
   void method2496() {
      this.field1958 = 0;
      this.field1966 = -1;
   }

   @ObfuscatedName("s")
   Model method2491(boolean var1, Model var2, byte[] var3) {
      var2.field1961 = this.field1961;
      var2.field1939 = this.field1939;
      var2.field1951 = this.field1951;
      if(var2.verticesX == null || var2.verticesX.length < this.field1961) {
         var2.verticesX = new int[this.field1961 + 100];
         var2.verticesY = new int[this.field1961 + 100];
         var2.verticesZ = new int[this.field1961 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1961; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if(var1) {
         var2.field1947 = this.field1947;
      } else {
         var2.field1947 = var3;
         if(this.field1947 == null) {
            for(var4 = 0; var4 < this.field1939; ++var4) {
               var2.field1947[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1939; ++var4) {
               var2.field1947[var4] = this.field1947[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1943 = this.field1943;
      var2.field1965 = this.field1965;
      var2.field1945 = this.field1945;
      var2.field1946 = this.field1946;
      var2.field1944 = this.field1944;
      var2.field1949 = this.field1949;
      var2.field1994 = this.field1994;
      var2.field1952 = this.field1952;
      var2.field1953 = this.field1953;
      var2.field1931 = this.field1931;
      var2.field1995 = this.field1995;
      var2.field1956 = this.field1956;
      var2.field1950 = this.field1950;
      var2.method2496();
      return var2;
   }

   @ObfuscatedName("w")
   public Model method2530(boolean var1) {
      if(!var1 && field1955.length < this.field1939) {
         field1955 = new byte[this.field1939 + 100];
      }

      return this.method2491(var1, field1964, field1955);
   }

   @ObfuscatedName("r")
   void method2492(int var1) {
      if(this.field1966 == -1) {
         int var2 = 0;
         int var3 = 0;
         int var4 = 0;
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         int var8 = field1996[var1];
         int var9 = field1999[var1];

         for(int var10 = 0; var10 < this.field1961; ++var10) {
            int var11 = Graphics3D.method2600(this.verticesX[var10], this.verticesZ[var10], var8, var9);
            int var12 = this.verticesY[var10];
            int var13 = Graphics3D.method2644(this.verticesX[var10], this.verticesZ[var10], var8, var9);
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
         this.field1989 = (var6 + var3) / 2;
         this.field1932 = (var7 + var4) / 2;
         this.field1966 = (var5 - var2 + 1) / 2;
         this.field1967 = (var6 - var3 + 1) / 2;
         this.field1968 = (var7 - var4 + 1) / 2;
         if(this.field1966 < 32) {
            this.field1966 = 32;
         }

         if(this.field1968 < 32) {
            this.field1968 = 32;
         }

         if(this.field1950) {
            this.field1966 += 8;
            this.field1968 += 8;
         }

      }
   }

   @ObfuscatedName("y")
   void method2494() {
      if(this.field1958 != 2) {
         this.field1958 = 2;
         this.XYZMag = 0;

         for(int var1 = 0; var1 < this.field1961; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var3 * var3 + var2 * var2 + var4 * var4;
            if(var5 > this.XYZMag) {
               this.XYZMag = var5;
            }
         }

         this.XYZMag = (int)(Math.sqrt((double)this.XYZMag) + 0.99D);
         this.field1962 = this.XYZMag;
         this.field1960 = this.XYZMag + this.XYZMag;
      }
   }

   @ObfuscatedName("t")
   public Model method2500(boolean var1) {
      if(!var1 && field1934.length < this.field1939) {
         field1934 = new byte[this.field1939 + 100];
      }

      return this.method2491(var1, field1997, field1934);
   }

   @ObfuscatedName("f")
   public void method2503(int var1) {
      int var2 = field1999[var1];
      int var3 = field1996[var1];

      for(int var4 = 0; var4 < this.field1961; ++var4) {
         int var5 = var3 * this.verticesY[var4] - var2 * this.verticesZ[var4] >> 16;
         this.verticesZ[var4] = var2 * this.verticesY[var4] + var3 * this.verticesZ[var4] >> 16;
         this.verticesY[var4] = var5;
      }

      this.method2496();
   }

   @ObfuscatedName("i")
   public Model method2539(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2493();
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
               var11.field1961 = this.field1961;
               var11.field1939 = this.field1939;
               var11.field1951 = this.field1951;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1943 = this.field1943;
               var11.field1965 = this.field1965;
               var11.field1945 = this.field1945;
               var11.field1946 = this.field1946;
               var11.field1947 = this.field1947;
               var11.field1944 = this.field1944;
               var11.field1949 = this.field1949;
               var11.field1994 = this.field1994;
               var11.field1952 = this.field1952;
               var11.field1953 = this.field1953;
               var11.field1931 = this.field1931;
               var11.field1995 = this.field1995;
               var11.field1956 = this.field1956;
               var11.field1950 = this.field1950;
               var11.verticesY = new int[var11.field1961];
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
               for(var12 = 0; var12 < var11.field1961; ++var12) {
                  var13 = var2 + this.verticesX[var12];
                  var14 = var4 + this.verticesZ[var12];
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var15 * var1[var17 + 1][var18] + var1[var17][var18] * (128 - var15) >> 7;
                  var20 = var15 * var1[var17 + 1][var18 + 1] + var1[var17][var18 + 1] * (128 - var15) >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.verticesY[var12] = var21 + this.verticesY[var12] - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1961; ++var12) {
                  var13 = (-this.verticesY[var12] << 16) / super.modelHeight;
                  if(var13 < var6) {
                     var14 = var2 + this.verticesX[var12];
                     var15 = var4 + this.verticesZ[var12];
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18 + 1][var19] * var16 + var1[var18][var19] * (128 - var16) >> 7;
                     var21 = var16 * var1[var18 + 1][var19 + 1] + var1[var18][var19 + 1] * (128 - var16) >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.verticesY[var12] = (var22 - var3) * (var6 - var13) / var6 + this.verticesY[var12];
                  }
               }
            }

            var11.method2496();
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("b")
   public void method2502() {
      for(int var1 = 0; var1 < this.field1961; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.method2496();
   }

   @ObfuscatedName("by")
   @Export("draw")
   void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1957[0] = -1;
      if(this.field1958 != 1) {
         this.method2493();
      }

      this.method2492(var1);
      int var10 = var5 * var8 - var4 * var6 >> 16;
      int var11 = var2 * var7 + var3 * var10 >> 16;
      int var12 = var3 * this.XYZMag >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var5 * var6 >> 16;
         int var15 = (var14 - this.XYZMag) * Graphics3D.field2031;
         if(var15 / var13 < Graphics3D.field2046) {
            int var16 = (var14 + this.XYZMag) * Graphics3D.field2031;
            if(var16 / var13 > Graphics3D.field2036) {
               int var17 = var3 * var7 - var10 * var2 >> 16;
               int var18 = var2 * this.XYZMag >> 16;
               int var19 = (var17 + var18) * Graphics3D.field2031;
               if(var19 / var13 > Graphics3D.field2038) {
                  int var20 = (super.modelHeight * var3 >> 16) + var18;
                  int var21 = (var17 - var20) * Graphics3D.field2031;
                  if(var21 / var13 < Graphics3D.field2039) {
                     int var22 = var12 + (var2 * super.modelHeight >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1951 > 0;
                     int var26 = class134.field2014;
                     int var28 = class134.field2008;
                     boolean var30 = class134.field2003;
                     if(class7.field236 && var9 > 0) {
                        WidgetNode.method1124(this, var6, var7, var8);
                     }

                     int var33;
                     int var34;
                     int var35;
                     int var36;
                     int var37;
                     int var38;
                     int var39;
                     int var40;
                     int var41;
                     if(class7.field238 && var9 > 0) {
                        int var32 = var11 - var12;
                        if(var32 <= 50) {
                           var32 = 50;
                        }

                        if(var14 > 0) {
                           var33 = var15 / var13;
                           var34 = var16 / var32;
                        } else {
                           var34 = var16 / var13;
                           var33 = var15 / var32;
                        }

                        if(var17 > 0) {
                           var35 = var21 / var13;
                           var36 = var19 / var32;
                        } else {
                           var36 = var19 / var13;
                           var35 = var21 / var32;
                        }

                        var37 = -8355840;
                        var38 = var26 - Graphics3D.centerX;
                        var39 = var28 - Graphics3D.centerY;
                        if(var38 > var33 && var38 < var34 && var39 > var35 && var39 < var36) {
                           var37 = -256;
                        }

                        var40 = var33 + Graphics3D.centerX;
                        var41 = var35 + Graphics3D.centerY;
                        int var42 = var34 + Graphics3D.centerX;
                        int var43 = var36 + Graphics3D.centerY;
                        class7.field234.method3543(new class8(var40, var41, var42, var43, var37));
                     }

                     boolean var46 = false;
                     if(var9 > 0 && var30) {
                        boolean var47 = false;
                        if(field1992) {
                           var47 = WidgetNode.method1125(this, var6, var7, var8);
                        } else {
                           var34 = var11 - var12;
                           if(var34 <= 50) {
                              var34 = 50;
                           }

                           if(var14 > 0) {
                              var15 /= var13;
                              var16 /= var34;
                           } else {
                              var16 /= var13;
                              var15 /= var34;
                           }

                           if(var17 > 0) {
                              var21 /= var13;
                              var19 /= var34;
                           } else {
                              var19 /= var13;
                              var21 /= var34;
                           }

                           var35 = var26 - Graphics3D.centerX;
                           var36 = var28 - Graphics3D.centerY;
                           if(var35 > var15 && var35 < var16 && var36 > var21 && var36 < var19) {
                              var47 = true;
                           }
                        }

                        if(var47) {
                           if(this.field1950) {
                              class182.method3430(var9);
                           } else {
                              var46 = true;
                           }
                        }
                     }

                     var33 = Graphics3D.centerX;
                     var34 = Graphics3D.centerY;
                     var35 = 0;
                     var36 = 0;
                     if(var1 != 0) {
                        var35 = field1999[var1];
                        var36 = field1996[var1];
                     }

                     for(var37 = 0; var37 < this.field1961; ++var37) {
                        var38 = this.verticesX[var37];
                        var39 = this.verticesY[var37];
                        var40 = this.verticesZ[var37];
                        if(var1 != 0) {
                           var41 = var40 * var35 + var38 * var36 >> 16;
                           var40 = var40 * var36 - var38 * var35 >> 16;
                           var38 = var41;
                        }

                        var38 += var6;
                        var39 += var7;
                        var40 += var8;
                        var41 = var40 * var4 + var5 * var38 >> 16;
                        var40 = var5 * var40 - var38 * var4 >> 16;
                        var38 = var41;
                        var41 = var3 * var39 - var40 * var2 >> 16;
                        var40 = var39 * var2 + var3 * var40 >> 16;
                        field1974[var37] = var40 - var11;
                        if(var40 >= 50) {
                           field1963[var37] = var38 * Graphics3D.field2031 / var40 + var33;
                           field1973[var37] = var41 * Graphics3D.field2031 / var40 + var34;
                        } else {
                           field1963[var37] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           yViewportBuffer[var37] = var38;
                           field1978[var37] = var41;
                           field1977[var37] = var40;
                        }
                     }

                     try {
                        this.method2509(var23, var46, this.field1950, var9);
                     } catch (Exception var45) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("c")
   public void method2495() {
      for(int var1 = 0; var1 < this.field1961; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.method2496();
   }

   @ObfuscatedName("u")
   public void method2566(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1961; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = var2 * this.verticesY[var4] / 128;
         this.verticesZ[var4] = var3 * this.verticesZ[var4] / 128;
      }

      this.method2496();
   }

   @ObfuscatedName("l")
   public void method2487() {
      for(int var1 = 0; var1 < this.field1961; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.method2496();
   }

   @ObfuscatedName("x")
   final void method2510(int var1) {
      if(field1971[var1]) {
         this.method2511(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         Graphics3D.rasterClipEnable = field1970[var1];
         if(this.field1947 == null) {
            Graphics3D.rasterAlpha = 0;
         } else {
            Graphics3D.rasterAlpha = this.field1947[var1] & 255;
         }

         if(this.field1949 != null && this.field1949[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1944 != null && this.field1944[var1] != -1) {
               int var8 = this.field1944[var1] & 255;
               var5 = this.field1952[var8];
               var6 = this.field1953[var8];
               var7 = this.field1931[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1945[var1] == -1) {
               Graphics3D.rasterTextureAffine(field1973[var2], field1973[var3], field1973[var4], field1963[var2], field1963[var3], field1963[var4], this.field1943[var1], this.field1943[var1], this.field1943[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1978[var5], field1978[var6], field1978[var7], field1977[var5], field1977[var6], field1977[var7], this.field1949[var1]);
            } else {
               Graphics3D.rasterTextureAffine(field1973[var2], field1973[var3], field1973[var4], field1963[var2], field1963[var3], field1963[var4], this.field1943[var1], this.field1965[var1], this.field1945[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1978[var5], field1978[var6], field1978[var7], field1977[var5], field1977[var6], field1977[var7], this.field1949[var1]);
            }
         } else if(this.field1945[var1] == -1) {
            Graphics3D.rasterFlat(field1973[var2], field1973[var3], field1973[var4], field1963[var2], field1963[var3], field1963[var4], field1933[this.field1943[var1]]);
         } else {
            Graphics3D.rasterGouraud(field1973[var2], field1973[var3], field1973[var4], field1963[var2], field1963[var3], field1963[var4], this.field1943[var1], this.field1965[var1], this.field1945[var1]);
         }

      }
   }

   @ObfuscatedName("z")
   void method2525(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1972 = 0;
         field1990 = 0;
         field1991 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var9 = var2[var8];
            if(var9 < this.field1995.length) {
               int[] var10 = this.field1995[var9];

               for(var11 = 0; var11 < var10.length; ++var11) {
                  var12 = var10[var11];
                  field1972 += this.verticesX[var12];
                  field1990 += this.verticesY[var12];
                  field1991 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1972 = var3 + field1972 / var7;
            field1990 = var4 + field1990 / var7;
            field1991 = var5 + field1991 / var7;
         } else {
            field1972 = var3;
            field1990 = var4;
            field1991 = var5;
         }

      } else {
         int[] var18;
         int var19;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1995.length) {
                  var18 = this.field1995[var8];

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
               if(var8 < this.field1995.length) {
                  var18 = this.field1995[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= field1972;
                     this.verticesY[var11] -= field1990;
                     this.verticesZ[var11] -= field1991;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1999[var14];
                        var16 = field1996[var14];
                        var17 = var15 * this.verticesY[var11] + var16 * this.verticesX[var11] >> 16;
                        this.verticesY[var11] = var16 * this.verticesY[var11] - var15 * this.verticesX[var11] >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1999[var12];
                        var16 = field1996[var12];
                        var17 = var16 * this.verticesY[var11] - var15 * this.verticesZ[var11] >> 16;
                        this.verticesZ[var11] = var15 * this.verticesY[var11] + var16 * this.verticesZ[var11] >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1999[var13];
                        var16 = field1996[var13];
                        var17 = var15 * this.verticesZ[var11] + var16 * this.verticesX[var11] >> 16;
                        this.verticesZ[var11] = var16 * this.verticesZ[var11] - var15 * this.verticesX[var11] >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += field1972;
                     this.verticesY[var11] += field1990;
                     this.verticesZ[var11] += field1991;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1995.length) {
                  var18 = this.field1995[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= field1972;
                     this.verticesY[var11] -= field1990;
                     this.verticesZ[var11] -= field1991;
                     this.verticesX[var11] = var3 * this.verticesX[var11] / 128;
                     this.verticesY[var11] = var4 * this.verticesY[var11] / 128;
                     this.verticesZ[var11] = var5 * this.verticesZ[var11] / 128;
                     this.verticesX[var11] += field1972;
                     this.verticesY[var11] += field1990;
                     this.verticesZ[var11] += field1991;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1956 != null && this.field1947 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1956.length) {
                     var18 = this.field1956[var8];

                     for(var19 = 0; var19 < var18.length; ++var19) {
                        var11 = var18[var19];
                        var12 = (this.field1947[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1947[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("o")
   public void method2498(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.skeletons[var2];
            Frame var7 = var3.skeletons[var4];
            FrameMap var8 = var6.skin;
            field1972 = 0;
            field1990 = 0;
            field1991 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1899; ++var11) {
               for(var12 = var6.field1900[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.types[var12] == 0) {
                  this.method2525(var8.types[var12], var8.list[var12], var6.translator_x[var11], var6.translator_y[var11], var6.translator_z[var11]);
               }
            }

            field1972 = 0;
            field1990 = 0;
            field1991 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1899; ++var11) {
               for(var12 = var7.field1900[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.types[var12] == 0) {
                  this.method2525(var8.types[var12], var8.list[var12], var7.translator_x[var11], var7.translator_y[var11], var7.translator_z[var11]);
               }
            }

            this.method2496();
         } else {
            this.method2497(var1, var2);
         }
      }
   }

   @ObfuscatedName("d")
   final void method2509(boolean var1, boolean var2, boolean var3, int var4) {
      if(this.field1960 < 1600) {
         int var5;
         for(var5 = 0; var5 < this.field1960; ++var5) {
            field1957[var5] = 0;
         }

         var5 = var3?20:5;
         int var7;
         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         int var13;
         if(class7.field232 && var2) {
            Model var6 = this;

            for(var7 = 0; var7 < var6.field1939; ++var7) {
               if(var6.field1945[var7] != -2) {
                  var8 = var6.indices1[var7];
                  var9 = var6.indices2[var7];
                  var10 = var6.indices3[var7];
                  var11 = field1963[var8];
                  var12 = field1963[var9];
                  var13 = field1963[var10];
                  class25.method165(field1973[var8], field1973[var9], field1973[var10], var11, var12, var13, var5);
               }
            }
         }

         int var14;
         int var15;
         int var17;
         int var26;
         for(var26 = 0; var26 < this.field1939; ++var26) {
            if(this.field1945[var26] != -2) {
               var7 = this.indices1[var26];
               var8 = this.indices2[var26];
               var9 = this.indices3[var26];
               var10 = field1963[var7];
               var11 = field1963[var8];
               var12 = field1963[var9];
               if(!var1 || var10 != -5000 && var11 != -5000 && var12 != -5000) {
                  if(var2 && class43.method643(field1973[var7], field1973[var8], field1973[var9], var10, var11, var12, var5)) {
                     class182.method3430(var4);
                     var2 = false;
                  }

                  if((var10 - var11) * (field1973[var9] - field1973[var8]) - (var12 - var11) * (field1973[var7] - field1973[var8]) > 0) {
                     field1971[var26] = false;
                     if(var10 >= 0 && var11 >= 0 && var12 >= 0 && var10 <= Graphics3D.rasterClipX && var11 <= Graphics3D.rasterClipX && var12 <= Graphics3D.rasterClipX) {
                        field1970[var26] = false;
                     } else {
                        field1970[var26] = true;
                     }

                     var13 = (field1974[var9] + field1974[var7] + field1974[var8]) / 3 + this.field1962;
                     field1980[var13][field1957[var13]++] = var26;
                  }
               } else {
                  var13 = yViewportBuffer[var7];
                  var14 = yViewportBuffer[var8];
                  var15 = yViewportBuffer[var9];
                  int var16 = field1978[var7];
                  var17 = field1978[var8];
                  int var18 = field1978[var9];
                  int var19 = field1977[var7];
                  int var20 = field1977[var8];
                  int var21 = field1977[var9];
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
                     field1971[var26] = true;
                     int var25 = (field1974[var9] + field1974[var7] + field1974[var8]) / 3 + this.field1962;
                     field1980[var25][field1957[var25]++] = var26;
                  }
               }
            }
         }

         int[] var27;
         if(this.field1946 == null) {
            for(var26 = this.field1960 - 1; var26 >= 0; --var26) {
               var7 = field1957[var26];
               if(var7 > 0) {
                  var27 = field1980[var26];

                  for(var9 = 0; var9 < var7; ++var9) {
                     this.method2510(var27[var9]);
                  }
               }
            }

         } else {
            for(var26 = 0; var26 < 12; ++var26) {
               field1981[var26] = 0;
               field1985[var26] = 0;
            }

            for(var26 = this.field1960 - 1; var26 >= 0; --var26) {
               var7 = field1957[var26];
               if(var7 > 0) {
                  var27 = field1980[var26];

                  for(var9 = 0; var9 < var7; ++var9) {
                     var10 = var27[var9];
                     byte var31 = this.field1946[var10];
                     var12 = field1981[var31]++;
                     field1982[var31][var12] = var10;
                     if(var31 < 10) {
                        field1985[var31] += var26;
                     } else if(var31 == 10) {
                        field1983[var12] = var26;
                     } else {
                        field1984[var12] = var26;
                     }
                  }
               }
            }

            var26 = 0;
            if(field1981[1] > 0 || field1981[2] > 0) {
               var26 = (field1985[1] + field1985[2]) / (field1981[1] + field1981[2]);
            }

            var7 = 0;
            if(field1981[3] > 0 || field1981[4] > 0) {
               var7 = (field1985[3] + field1985[4]) / (field1981[3] + field1981[4]);
            }

            var8 = 0;
            if(field1981[6] > 0 || field1981[8] > 0) {
               var8 = (field1985[8] + field1985[6]) / (field1981[8] + field1981[6]);
            }

            var10 = 0;
            var11 = field1981[10];
            int[] var28 = field1982[10];
            int[] var29 = field1983;
            if(var10 == var11) {
               var10 = 0;
               var11 = field1981[11];
               var28 = field1982[11];
               var29 = field1984;
            }

            if(var10 < var11) {
               var9 = var29[var10];
            } else {
               var9 = -1000;
            }

            for(var14 = 0; var14 < 10; ++var14) {
               while(var14 == 0 && var9 > var26) {
                  this.method2510(var28[var10++]);
                  if(var10 == var11 && var28 != field1982[11]) {
                     var10 = 0;
                     var11 = field1981[11];
                     var28 = field1982[11];
                     var29 = field1984;
                  }

                  if(var10 < var11) {
                     var9 = var29[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 3 && var9 > var7) {
                  this.method2510(var28[var10++]);
                  if(var10 == var11 && var28 != field1982[11]) {
                     var10 = 0;
                     var11 = field1981[11];
                     var28 = field1982[11];
                     var29 = field1984;
                  }

                  if(var10 < var11) {
                     var9 = var29[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 5 && var9 > var8) {
                  this.method2510(var28[var10++]);
                  if(var10 == var11 && var28 != field1982[11]) {
                     var10 = 0;
                     var11 = field1981[11];
                     var28 = field1982[11];
                     var29 = field1984;
                  }

                  if(var10 < var11) {
                     var9 = var29[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               var15 = field1981[var14];
               int[] var30 = field1982[var14];

               for(var17 = 0; var17 < var15; ++var17) {
                  this.method2510(var30[var17]);
               }
            }

            while(var9 != -1000) {
               this.method2510(var28[var10++]);
               if(var10 == var11 && var28 != field1982[11]) {
                  var10 = 0;
                  var28 = field1982[11];
                  var11 = field1981[11];
                  var29 = field1984;
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

   @ObfuscatedName("n")
   public void method2504(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1961; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.method2496();
   }

   @ObfuscatedName("p")
   public final void method2506(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1957[0] = -1;
      if(this.field1958 != 2 && this.field1958 != 1) {
         this.method2494();
      }

      int var8 = Graphics3D.centerX;
      int var9 = Graphics3D.centerY;
      int var10000 = field1999[var1];
      var10000 = field1996[var1];
      int var12 = field1999[var2];
      int var13 = field1996[var2];
      int var14 = field1999[var3];
      int var15 = field1996[var3];
      int var16 = field1999[var4];
      int var17 = field1996[var4];
      int var18 = var16 * var6 + var17 * var7 >> 16;

      for(int var19 = 0; var19 < this.field1961; ++var19) {
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
         field1963[var19] = var20 * Graphics3D.field2031 / var22 + var8;
         field1973[var19] = var23 * Graphics3D.field2031 / var22 + var9;
         if(this.field1951 > 0) {
            yViewportBuffer[var19] = var20;
            field1978[var19] = var23;
            field1977[var19] = var22;
         }
      }

      try {
         this.method2509(false, false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("q")
   public final void method2507(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1957[0] = -1;
      if(this.field1958 != 2 && this.field1958 != 1) {
         this.method2494();
      }

      int var9 = Graphics3D.centerX;
      int var10 = Graphics3D.centerY;
      int var10000 = field1999[var1];
      var10000 = field1996[var1];
      int var13 = field1999[var2];
      int var14 = field1996[var2];
      int var15 = field1999[var3];
      int var16 = field1996[var3];
      int var17 = field1999[var4];
      int var18 = field1996[var4];
      int var19 = var17 * var6 + var18 * var7 >> 16;

      for(int var20 = 0; var20 < this.field1961; ++var20) {
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
         field1963[var20] = var9 + var21 * Graphics3D.field2031 / var8;
         field1973[var20] = var10 + var24 * Graphics3D.field2031 / var8;
         if(this.field1951 > 0) {
            yViewportBuffer[var20] = var21;
            field1978[var20] = var24;
            field1977[var20] = var23;
         }
      }

      try {
         this.method2509(false, false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("j")
   public int method2553() {
      this.method2493();
      return this.XYZMag;
   }
}
