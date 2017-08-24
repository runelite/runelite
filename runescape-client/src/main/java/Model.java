import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("av")
   static boolean[] field1971;
   @ObfuscatedName("ap")
   static int[] field1979;
   @ObfuscatedName("bi")
   static int[] field1995;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lem;"
   )
   static Model field1933;
   @ObfuscatedName("r")
   static byte[] field1934;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lem;"
   )
   static Model field1999;
   @ObfuscatedName("bx")
   static int field1956;
   @ObfuscatedName("j")
   static byte[] field1977;
   @ObfuscatedName("bf")
   static int[] field1937;
   @ObfuscatedName("br")
   static int field1990;
   @ObfuscatedName("ay")
   static boolean[] field1973;
   @ObfuscatedName("by")
   static int field1991;
   @ObfuscatedName("ak")
   static int[] field1959;
   @ObfuscatedName("bc")
   static int[] field1986;
   @ObfuscatedName("an")
   @Export("yViewportBuffer")
   static int[] yViewportBuffer;
   @ObfuscatedName("ao")
   public static int[] field1983;
   @ObfuscatedName("af")
   static int[] field1976;
   @ObfuscatedName("ai")
   static int[] field1981;
   @ObfuscatedName("bv")
   static int[] field1987;
   @ObfuscatedName("aw")
   public static int[] field1970;
   @ObfuscatedName("be")
   static int[] field1969;
   @ObfuscatedName("bs")
   static int[] field1989;
   @ObfuscatedName("ae")
   static int[][] field1980;
   @ObfuscatedName("bw")
   @Export("xViewportBuffer")
   static int[] xViewportBuffer;
   @ObfuscatedName("ah")
   static int[] field1996;
   @ObfuscatedName("bn")
   static int[] field1997;
   @ObfuscatedName("au")
   static int[][] field1964;
   @ObfuscatedName("bp")
   static int[] field1947;
   @ObfuscatedName("bd")
   static int[] field1945;
   @ObfuscatedName("bz")
   static boolean field1992;
   @ObfuscatedName("ad")
   int field1961;
   @ObfuscatedName("az")
   public int field1975;
   @ObfuscatedName("ax")
   int field1958;
   @ObfuscatedName("g")
   int[][] field1955;
   @ObfuscatedName("o")
   int field1935;
   @ObfuscatedName("am")
   public int field1963;
   @ObfuscatedName("s")
   @Export("indices1")
   public int[] indices1;
   @ObfuscatedName("ag")
   @Export("XYZMag")
   int XYZMag;
   @ObfuscatedName("n")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("b")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("k")
   public int field1939;
   @ObfuscatedName("d")
   @Export("indices2")
   public int[] indices2;
   @ObfuscatedName("l")
   @Export("indices3")
   public int[] indices3;
   @ObfuscatedName("q")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("w")
   int[][] field1960;
   @ObfuscatedName("p")
   byte field1998;
   @ObfuscatedName("al")
   int field1967;
   @ObfuscatedName("m")
   int field1951;
   @ObfuscatedName("z")
   byte[] field1984;
   @ObfuscatedName("aq")
   public int field1932;
   @ObfuscatedName("t")
   int[] field1943;
   @ObfuscatedName("v")
   public int[] field2000;
   @ObfuscatedName("ac")
   public int field1982;
   @ObfuscatedName("ar")
   public boolean field1957;
   @ObfuscatedName("y")
   int[] field1944;
   @ObfuscatedName("c")
   byte[] field1946;
   @ObfuscatedName("e")
   short[] field1949;
   @ObfuscatedName("at")
   public int field1965;
   @ObfuscatedName("ab")
   int field1962;
   @ObfuscatedName("aa")
   public int field1968;
   @ObfuscatedName("u")
   byte[] field1948;
   @ObfuscatedName("x")
   int[] field1931;
   @ObfuscatedName("h")
   int[] field1953;
   @ObfuscatedName("f")
   int[] field1954;

   static {
      field1999 = new Model();
      field1977 = new byte[1];
      field1933 = new Model();
      field1934 = new byte[1];
      field1973 = new boolean[4700];
      field1971 = new boolean[4700];
      field1983 = new int[4700];
      field1970 = new int[4700];
      field1996 = new int[4700];
      yViewportBuffer = new int[4700];
      field1976 = new int[4700];
      field1959 = new int[4700];
      field1979 = new int[1600];
      field1980 = new int[1600][512];
      field1981 = new int[12];
      field1964 = new int[12][2000];
      field1947 = new int[2000];
      field1945 = new int[2000];
      field1989 = new int[12];
      field1986 = new int[10];
      field1987 = new int[10];
      xViewportBuffer = new int[10];
      field1992 = true;
      field1995 = Graphics3D.SINE;
      field1937 = Graphics3D.COSINE;
      field1997 = Graphics3D.colorPalette;
      field1969 = Graphics3D.field2043;
   }

   Model() {
      this.field1935 = 0;
      this.field1939 = 0;
      this.field1998 = 0;
      this.field1951 = 0;
      this.field1957 = false;
      this.field1975 = -1;
      this.field1982 = -1;
      this.field1968 = -1;
   }

   @ObfuscatedSignature(
      signature = "([Lem;I)V"
   )
   public Model(Model[] var1, int var2) {
      this.field1935 = 0;
      this.field1939 = 0;
      this.field1998 = 0;
      this.field1951 = 0;
      this.field1957 = false;
      this.field1975 = -1;
      this.field1982 = -1;
      this.field1968 = -1;
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1935 = 0;
      this.field1939 = 0;
      this.field1951 = 0;
      this.field1998 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1935 += var8.field1935;
            this.field1939 += var8.field1939;
            this.field1951 += var8.field1951;
            if(var8.field1946 != null) {
               var3 = true;
            } else {
               if(this.field1998 == -1) {
                  this.field1998 = var8.field1998;
               }

               if(this.field1998 != var8.field1998) {
                  var3 = true;
               }
            }

            var4 |= var8.field1984 != null;
            var5 |= var8.field1949 != null;
            var6 |= var8.field1948 != null;
         }
      }

      this.verticesX = new int[this.field1935];
      this.verticesY = new int[this.field1935];
      this.verticesZ = new int[this.field1935];
      this.indices1 = new int[this.field1939];
      this.indices2 = new int[this.field1939];
      this.indices3 = new int[this.field1939];
      this.field1943 = new int[this.field1939];
      this.field1944 = new int[this.field1939];
      this.field2000 = new int[this.field1939];
      if(var3) {
         this.field1946 = new byte[this.field1939];
      }

      if(var4) {
         this.field1984 = new byte[this.field1939];
      }

      if(var5) {
         this.field1949 = new short[this.field1939];
      }

      if(var6) {
         this.field1948 = new byte[this.field1939];
      }

      if(this.field1951 > 0) {
         this.field1931 = new int[this.field1951];
         this.field1953 = new int[this.field1951];
         this.field1954 = new int[this.field1951];
      }

      this.field1935 = 0;
      this.field1939 = 0;
      this.field1951 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1939; ++var9) {
               this.indices1[this.field1939] = this.field1935 + var8.indices1[var9];
               this.indices2[this.field1939] = this.field1935 + var8.indices2[var9];
               this.indices3[this.field1939] = this.field1935 + var8.indices3[var9];
               this.field1943[this.field1939] = var8.field1943[var9];
               this.field1944[this.field1939] = var8.field1944[var9];
               this.field2000[this.field1939] = var8.field2000[var9];
               if(var3) {
                  if(var8.field1946 != null) {
                     this.field1946[this.field1939] = var8.field1946[var9];
                  } else {
                     this.field1946[this.field1939] = var8.field1998;
                  }
               }

               if(var4 && var8.field1984 != null) {
                  this.field1984[this.field1939] = var8.field1984[var9];
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
                     this.field1948[this.field1939] = (byte)(this.field1951 + var8.field1948[var9]);
                  } else {
                     this.field1948[this.field1939] = -1;
                  }
               }

               ++this.field1939;
            }

            for(var9 = 0; var9 < var8.field1951; ++var9) {
               this.field1931[this.field1951] = this.field1935 + var8.field1931[var9];
               this.field1953[this.field1951] = this.field1935 + var8.field1953[var9];
               this.field1954[this.field1951] = this.field1935 + var8.field1954[var9];
               ++this.field1951;
            }

            for(var9 = 0; var9 < var8.field1935; ++var9) {
               this.verticesX[this.field1935] = var8.verticesX[var9];
               this.verticesY[this.field1935] = var8.verticesY[var9];
               this.verticesZ[this.field1935] = var8.verticesZ[var9];
               ++this.field1935;
            }
         }
      }

   }

   @ObfuscatedName("q")
   public void method2515() {
      if(this.field1958 != 1) {
         this.field1958 = 1;
         super.modelHeight = 0;
         this.field1967 = 0;
         this.XYZMag = 0;

         for(int var1 = 0; var1 < this.field1935; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1967) {
               this.field1967 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.XYZMag) {
               this.XYZMag = var5;
            }
         }

         this.XYZMag = (int)(Math.sqrt((double)this.XYZMag) + 0.99D);
         this.field1962 = (int)(Math.sqrt((double)(this.XYZMag * this.XYZMag + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1961 = this.field1962 + (int)(Math.sqrt((double)(this.XYZMag * this.XYZMag + this.field1967 * this.field1967)) + 0.99D);
      }
   }

   @ObfuscatedName("ad")
   final void method2533(int var1) {
      int var2 = Graphics3D.centerX;
      int var3 = Graphics3D.centerY;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1959[var5];
      int var9 = field1959[var6];
      int var10 = field1959[var7];
      if(this.field1984 == null) {
         Graphics3D.rasterAlpha = 0;
      } else {
         Graphics3D.rasterAlpha = this.field1984[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1986[var4] = field1983[var5];
         field1987[var4] = field1970[var5];
         xViewportBuffer[var4++] = this.field1943[var1];
      } else {
         var11 = yViewportBuffer[var5];
         var12 = field1976[var5];
         var13 = this.field1943[var1];
         if(var10 >= 50) {
            var14 = field1969[var10 - var8] * (50 - var8);
            field1986[var4] = var2 + (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) * Graphics3D.field2030 / 50;
            field1987[var4] = var3 + (var12 + ((field1976[var7] - var12) * var14 >> 16)) * Graphics3D.field2030 / 50;
            xViewportBuffer[var4++] = var13 + ((this.field2000[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = field1969[var9 - var8] * (50 - var8);
            field1986[var4] = var2 + (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) * Graphics3D.field2030 / 50;
            field1987[var4] = var3 + (var12 + ((field1976[var6] - var12) * var14 >> 16)) * Graphics3D.field2030 / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1944[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1986[var4] = field1983[var6];
         field1987[var4] = field1970[var6];
         xViewportBuffer[var4++] = this.field1944[var1];
      } else {
         var11 = yViewportBuffer[var6];
         var12 = field1976[var6];
         var13 = this.field1944[var1];
         if(var8 >= 50) {
            var14 = field1969[var8 - var9] * (50 - var9);
            field1986[var4] = var2 + Graphics3D.field2030 * (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) / 50;
            field1987[var4] = var3 + (var12 + ((field1976[var5] - var12) * var14 >> 16)) * Graphics3D.field2030 / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1943[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = field1969[var10 - var9] * (50 - var9);
            field1986[var4] = var2 + (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) * Graphics3D.field2030 / 50;
            field1987[var4] = var3 + Graphics3D.field2030 * (var12 + ((field1976[var7] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field2000[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1986[var4] = field1983[var7];
         field1987[var4] = field1970[var7];
         xViewportBuffer[var4++] = this.field2000[var1];
      } else {
         var11 = yViewportBuffer[var7];
         var12 = field1976[var7];
         var13 = this.field2000[var1];
         if(var9 >= 50) {
            var14 = field1969[var9 - var10] * (50 - var10);
            field1986[var4] = var2 + (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) * Graphics3D.field2030 / 50;
            field1987[var4] = var3 + (var12 + ((field1976[var6] - var12) * var14 >> 16)) * Graphics3D.field2030 / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1944[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = field1969[var8 - var10] * (50 - var10);
            field1986[var4] = var2 + Graphics3D.field2030 * (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) / 50;
            field1987[var4] = var3 + Graphics3D.field2030 * (var12 + ((field1976[var5] - var12) * var14 >> 16)) / 50;
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
            if(this.field1948 != null && this.field1948[var1] != -1) {
               var20 = this.field1948[var1] & 255;
               var17 = this.field1931[var20];
               var18 = this.field1953[var20];
               var19 = this.field1954[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field2000[var1] == -1) {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1943[var1], this.field1943[var1], this.field1943[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1976[var17], field1976[var18], field1976[var19], field1959[var17], field1959[var18], field1959[var19], this.field1949[var1]);
            } else {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1976[var17], field1976[var18], field1976[var19], field1959[var17], field1959[var18], field1959[var19], this.field1949[var1]);
            }
         } else if(this.field2000[var1] == -1) {
            Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, field1997[this.field1943[var1]]);
         } else {
            Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX || field1986[3] < 0 || field1986[3] > Graphics3D.rasterClipX) {
            Graphics3D.rasterClipEnable = true;
         }

         if(this.field1949 != null && this.field1949[var1] != -1) {
            if(this.field1948 != null && this.field1948[var1] != -1) {
               var20 = this.field1948[var1] & 255;
               var17 = this.field1931[var20];
               var18 = this.field1953[var20];
               var19 = this.field1954[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1949[var1];
            if(this.field2000[var1] == -1) {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1943[var1], this.field1943[var1], this.field1943[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1976[var17], field1976[var18], field1976[var19], field1959[var17], field1959[var18], field1959[var19], var21);
               Graphics3D.rasterTextureAffine(var14, var16, field1987[3], var11, var13, field1986[3], this.field1943[var1], this.field1943[var1], this.field1943[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1976[var17], field1976[var18], field1976[var19], field1959[var17], field1959[var18], field1959[var19], var21);
            } else {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1976[var17], field1976[var18], field1976[var19], field1959[var17], field1959[var18], field1959[var19], var21);
               Graphics3D.rasterTextureAffine(var14, var16, field1987[3], var11, var13, field1986[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1976[var17], field1976[var18], field1976[var19], field1959[var17], field1959[var18], field1959[var19], var21);
            }
         } else if(this.field2000[var1] == -1) {
            var17 = field1997[this.field1943[var1]];
            Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            Graphics3D.rasterFlat(var14, var16, field1987[3], var11, var13, field1986[3], var17);
         } else {
            Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
            Graphics3D.rasterGouraud(var14, var16, field1987[3], var11, var13, field1986[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3]);
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Leg;I)V"
   )
   public void method2519(Frames var1, int var2) {
      if(this.field1955 != null) {
         if(var2 != -1) {
            Frame var3 = var1.skeletons[var2];
            FrameMap var4 = var3.skin;
            field1956 = 0;
            field1990 = 0;
            field1991 = 0;

            for(int var5 = 0; var5 < var3.field1907; ++var5) {
               int var6 = var3.field1903[var5];
               this.method2521(var4.types[var6], var4.list[var6], var3.translator_x[var5], var3.translator_y[var5], var3.translator_z[var5]);
            }

            this.method2588();
         }
      }
   }

   @ObfuscatedName("d")
   void method2588() {
      this.field1958 = 0;
      this.field1975 = -1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ZLem;[B)Lem;"
   )
   Model method2513(boolean var1, Model var2, byte[] var3) {
      var2.field1935 = this.field1935;
      var2.field1939 = this.field1939;
      var2.field1951 = this.field1951;
      if(var2.verticesX == null || var2.verticesX.length < this.field1935) {
         var2.verticesX = new int[this.field1935 + 100];
         var2.verticesY = new int[this.field1935 + 100];
         var2.verticesZ = new int[this.field1935 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1935; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if(var1) {
         var2.field1984 = this.field1984;
      } else {
         var2.field1984 = var3;
         if(this.field1984 == null) {
            for(var4 = 0; var4 < this.field1939; ++var4) {
               var2.field1984[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1939; ++var4) {
               var2.field1984[var4] = this.field1984[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1943 = this.field1943;
      var2.field1944 = this.field1944;
      var2.field2000 = this.field2000;
      var2.field1946 = this.field1946;
      var2.field1948 = this.field1948;
      var2.field1949 = this.field1949;
      var2.field1998 = this.field1998;
      var2.field1931 = this.field1931;
      var2.field1953 = this.field1953;
      var2.field1954 = this.field1954;
      var2.field1955 = this.field1955;
      var2.field1960 = this.field1960;
      var2.field1957 = this.field1957;
      var2.method2588();
      return var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Z)Lem;"
   )
   public Model method2511(boolean var1) {
      if(!var1 && field1977.length < this.field1939) {
         field1977 = new byte[this.field1939 + 100];
      }

      return this.method2513(var1, field1999, field1977);
   }

   @ObfuscatedName("n")
   void method2516(int var1) {
      if(this.field1975 == -1) {
         int var2 = 0;
         int var3 = 0;
         int var4 = 0;
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         int var8 = field1937[var1];
         int var9 = field1995[var1];

         for(int var10 = 0; var10 < this.field1935; ++var10) {
            int var11 = Graphics3D.method2634(this.verticesX[var10], this.verticesZ[var10], var8, var9);
            int var12 = this.verticesY[var10];
            int var13 = Graphics3D.method2635(this.verticesX[var10], this.verticesZ[var10], var8, var9);
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

         this.field1963 = (var5 + var2) / 2;
         this.field1932 = (var6 + var3) / 2;
         this.field1965 = (var7 + var4) / 2;
         this.field1975 = (var5 - var2 + 1) / 2;
         this.field1982 = (var6 - var3 + 1) / 2;
         this.field1968 = (var7 - var4 + 1) / 2;
         if(this.field1975 < 32) {
            this.field1975 = 32;
         }

         if(this.field1968 < 32) {
            this.field1968 = 32;
         }

         if(this.field1957) {
            this.field1975 += 8;
            this.field1968 += 8;
         }

      }
   }

   @ObfuscatedName("b")
   void method2579() {
      if(this.field1958 != 2) {
         this.field1958 = 2;
         this.XYZMag = 0;

         for(int var1 = 0; var1 < this.field1935; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.XYZMag) {
               this.XYZMag = var5;
            }
         }

         this.XYZMag = (int)(Math.sqrt((double)this.XYZMag) + 0.99D);
         this.field1962 = this.XYZMag;
         this.field1961 = this.XYZMag + this.XYZMag;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Z)Lem;"
   )
   public Model method2530(boolean var1) {
      if(!var1 && field1934.length < this.field1939) {
         field1934 = new byte[this.field1939 + 100];
      }

      return this.method2513(var1, field1933, field1934);
   }

   @ObfuscatedName("x")
   public void method2525(int var1) {
      int var2 = field1995[var1];
      int var3 = field1937[var1];

      for(int var4 = 0; var4 < this.field1935; ++var4) {
         int var5 = var3 * this.verticesY[var4] - var2 * this.verticesZ[var4] >> 16;
         this.verticesZ[var4] = var2 * this.verticesY[var4] + var3 * this.verticesZ[var4] >> 16;
         this.verticesY[var4] = var5;
      }

      this.method2588();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([[IIIIZI)Lem;"
   )
   public Model method2510(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2515();
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
               var11.field1935 = this.field1935;
               var11.field1939 = this.field1939;
               var11.field1951 = this.field1951;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1943 = this.field1943;
               var11.field1944 = this.field1944;
               var11.field2000 = this.field2000;
               var11.field1946 = this.field1946;
               var11.field1984 = this.field1984;
               var11.field1948 = this.field1948;
               var11.field1949 = this.field1949;
               var11.field1998 = this.field1998;
               var11.field1931 = this.field1931;
               var11.field1953 = this.field1953;
               var11.field1954 = this.field1954;
               var11.field1955 = this.field1955;
               var11.field1960 = this.field1960;
               var11.field1957 = this.field1957;
               var11.verticesY = new int[var11.field1935];
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
               for(var12 = 0; var12 < var11.field1935; ++var12) {
                  var13 = var2 + this.verticesX[var12];
                  var14 = var4 + this.verticesZ[var12];
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var1[var17 + 1][var18 + 1] * var15 >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.verticesY[var12] = var21 + this.verticesY[var12] - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1935; ++var12) {
                  var13 = (-this.verticesY[var12] << 16) / super.modelHeight;
                  if(var13 < var6) {
                     var14 = var2 + this.verticesX[var12];
                     var15 = var4 + this.verticesZ[var12];
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var1[var18 + 1][var19 + 1] * var16 >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.verticesY[var12] = this.verticesY[var12] + (var6 - var13) * (var22 - var3) / var6;
                  }
               }
            }

            var11.method2588();
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("m")
   public void method2587() {
      for(int var1 = 0; var1 < this.field1935; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.method2588();
   }

   @ObfuscatedName("cx")
   @Export("draw")
   void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1979[0] = -1;
      if(this.field1958 != 1) {
         this.method2515();
      }

      this.method2516(var1);
      int var10 = var5 * var8 - var4 * var6 >> 16;
      int var11 = var2 * var7 + var3 * var10 >> 16;
      int var12 = var3 * this.XYZMag >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var5 * var6 >> 16;
         int var15 = (var14 - this.XYZMag) * Graphics3D.field2030;
         if(var15 / var13 < Graphics3D.field2045) {
            int var16 = (var14 + this.XYZMag) * Graphics3D.field2030;
            if(var16 / var13 > Graphics3D.field2035) {
               int var17 = var3 * var7 - var10 * var2 >> 16;
               int var18 = var2 * this.XYZMag >> 16;
               int var19 = (var17 + var18) * Graphics3D.field2030;
               if(var19 / var13 > Graphics3D.field2037) {
                  int var20 = (var3 * super.modelHeight >> 16) + var18;
                  int var21 = (var17 - var20) * Graphics3D.field2030;
                  if(var21 / var13 < Graphics3D.field2027) {
                     int var22 = var12 + (var2 * super.modelHeight >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1951 > 0;
                     int var26 = FileOnDisk.method2376();
                     int var27 = Area.method4296();
                     boolean var28 = class14.method92();
                     if(class7.field232 && var9 > 0) {
                        if(class11.method63(this, var6, var7, var8)) {
                           CombatInfo1.method1541(this, var6, var7, var8, -65281);
                        } else if(class7.field229 == class11.field273) {
                           CombatInfo1.method1541(this, var6, var7, var8, -16776961);
                        }
                     }

                     int var30;
                     int var31;
                     int var32;
                     int var33;
                     int var34;
                     int var35;
                     int var36;
                     if(class7.field228 && var9 > 0) {
                        int var39 = var11 - var12;
                        if(var39 <= 50) {
                           var39 = 50;
                        }

                        if(var14 > 0) {
                           var30 = var15 / var13;
                           var31 = var16 / var39;
                        } else {
                           var31 = var16 / var13;
                           var30 = var15 / var39;
                        }

                        if(var17 > 0) {
                           var32 = var21 / var13;
                           var33 = var19 / var39;
                        } else {
                           var33 = var19 / var13;
                           var32 = var21 / var39;
                        }

                        var34 = -8355840;
                        var35 = var26 - Graphics3D.centerX;
                        var36 = var27 - Graphics3D.centerY;
                        if(var35 > var30 && var35 < var31 && var36 > var32 && var36 < var33) {
                           var34 = -256;
                        }

                        Area.method4292(var30 + Graphics3D.centerX, var32 + Graphics3D.centerY, var31 + Graphics3D.centerX, var33 + Graphics3D.centerY, var34);
                     }

                     boolean var43 = false;
                     if(var9 > 0 && var28) {
                        boolean var42 = false;
                        if(field1992) {
                           var42 = class11.method63(this, var6, var7, var8);
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

                           var32 = var26 - Graphics3D.centerX;
                           var33 = var27 - Graphics3D.centerY;
                           if(var32 > var15 && var32 < var16 && var33 > var21 && var33 < var19) {
                              var42 = true;
                           }
                        }

                        if(var42) {
                           if(this.field1957) {
                              class133.field2003[++class133.field2009 - 1] = var9;
                           } else {
                              var43 = true;
                           }
                        }
                     }

                     var30 = Graphics3D.centerX;
                     var31 = Graphics3D.centerY;
                     var32 = 0;
                     var33 = 0;
                     if(var1 != 0) {
                        var32 = field1995[var1];
                        var33 = field1937[var1];
                     }

                     for(var34 = 0; var34 < this.field1935; ++var34) {
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
                        var38 = var37 * var4 + var5 * var35 >> 16;
                        var37 = var5 * var37 - var35 * var4 >> 16;
                        var35 = var38;
                        var38 = var3 * var36 - var37 * var2 >> 16;
                        var37 = var36 * var2 + var3 * var37 >> 16;
                        field1996[var34] = var37 - var11;
                        if(var37 >= 50) {
                           field1983[var34] = var35 * Graphics3D.field2030 / var37 + var30;
                           field1970[var34] = var31 + var38 * Graphics3D.field2030 / var37;
                        } else {
                           field1983[var34] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           yViewportBuffer[var34] = var35;
                           field1976[var34] = var38;
                           field1959[var34] = var37;
                        }
                     }

                     try {
                        this.method2556(var23, var43, this.field1957, var9);
                     } catch (Exception var41) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("p")
   public void method2523() {
      for(int var1 = 0; var1 < this.field1935; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.method2588();
   }

   @ObfuscatedName("w")
   public void method2550(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1935; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = var2 * this.verticesY[var4] / 128;
         this.verticesZ[var4] = var3 * this.verticesZ[var4] / 128;
      }

      this.method2588();
   }

   @ObfuscatedName("e")
   public void method2509() {
      for(int var1 = 0; var1 < this.field1935; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.method2588();
   }

   @ObfuscatedName("u")
   void method2521(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1956 = 0;
         field1990 = 0;
         field1991 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var9 = var2[var8];
            if(var9 < this.field1955.length) {
               int[] var10 = this.field1955[var9];

               for(var11 = 0; var11 < var10.length; ++var11) {
                  var12 = var10[var11];
                  field1956 += this.verticesX[var12];
                  field1990 += this.verticesY[var12];
                  field1991 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1956 = var3 + field1956 / var7;
            field1990 = var4 + field1990 / var7;
            field1991 = var5 + field1991 / var7;
         } else {
            field1956 = var3;
            field1990 = var4;
            field1991 = var5;
         }

      } else {
         int[] var18;
         int var19;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1955.length) {
                  var18 = this.field1955[var8];

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
               if(var8 < this.field1955.length) {
                  var18 = this.field1955[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= field1956;
                     this.verticesY[var11] -= field1990;
                     this.verticesZ[var11] -= field1991;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1995[var14];
                        var16 = field1937[var14];
                        var17 = var15 * this.verticesY[var11] + var16 * this.verticesX[var11] >> 16;
                        this.verticesY[var11] = var16 * this.verticesY[var11] - var15 * this.verticesX[var11] >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1995[var12];
                        var16 = field1937[var12];
                        var17 = var16 * this.verticesY[var11] - var15 * this.verticesZ[var11] >> 16;
                        this.verticesZ[var11] = var15 * this.verticesY[var11] + var16 * this.verticesZ[var11] >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1995[var13];
                        var16 = field1937[var13];
                        var17 = var15 * this.verticesZ[var11] + var16 * this.verticesX[var11] >> 16;
                        this.verticesZ[var11] = var16 * this.verticesZ[var11] - var15 * this.verticesX[var11] >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += field1956;
                     this.verticesY[var11] += field1990;
                     this.verticesZ[var11] += field1991;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1955.length) {
                  var18 = this.field1955[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= field1956;
                     this.verticesY[var11] -= field1990;
                     this.verticesZ[var11] -= field1991;
                     this.verticesX[var11] = var3 * this.verticesX[var11] / 128;
                     this.verticesY[var11] = var4 * this.verticesY[var11] / 128;
                     this.verticesZ[var11] = var5 * this.verticesZ[var11] / 128;
                     this.verticesX[var11] += field1956;
                     this.verticesY[var11] += field1990;
                     this.verticesZ[var11] += field1991;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1960 != null && this.field1984 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1960.length) {
                     var18 = this.field1960[var8];

                     for(var19 = 0; var19 < var18.length; ++var19) {
                        var11 = var18[var19];
                        var12 = (this.field1984[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1984[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Leg;ILeg;I[I)V"
   )
   public void method2520(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.skeletons[var2];
            Frame var7 = var3.skeletons[var4];
            FrameMap var8 = var6.skin;
            field1956 = 0;
            field1990 = 0;
            field1991 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1907; ++var11) {
               for(var12 = var6.field1903[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.types[var12] == 0) {
                  this.method2521(var8.types[var12], var8.list[var12], var6.translator_x[var11], var6.translator_y[var11], var6.translator_z[var11]);
               }
            }

            field1956 = 0;
            field1990 = 0;
            field1991 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1907; ++var11) {
               for(var12 = var7.field1903[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.types[var12] == 0) {
                  this.method2521(var8.types[var12], var8.list[var12], var7.translator_x[var11], var7.translator_y[var11], var7.translator_z[var11]);
               }
            }

            this.method2588();
         } else {
            this.method2519(var1, var2);
         }
      }
   }

   @ObfuscatedName("al")
   final void method2556(boolean var1, boolean var2, boolean var3, int var4) {
      if(this.field1961 < 1600) {
         int var5;
         for(var5 = 0; var5 < this.field1961; ++var5) {
            field1979[var5] = 0;
         }

         var5 = var3?20:5;
         if(class7.field236 && var2) {
            Huffman.method3168(this, var5);
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
            if(this.field2000[var6] != -2) {
               var7 = this.indices1[var6];
               var8 = this.indices2[var6];
               var9 = this.indices3[var6];
               var10 = field1983[var7];
               var11 = field1983[var8];
               var12 = field1983[var9];
               int var13;
               if(!var1 || var10 != -5000 && var11 != -5000 && var12 != -5000) {
                  if(var2 && class56.method866(field1970[var7], field1970[var8], field1970[var9], var10, var11, var12, var5)) {
                     class133.field2003[++class133.field2009 - 1] = var4;
                     var2 = false;
                  }

                  if((var10 - var11) * (field1970[var9] - field1970[var8]) - (var12 - var11) * (field1970[var7] - field1970[var8]) > 0) {
                     field1971[var6] = false;
                     if(var10 >= 0 && var11 >= 0 && var12 >= 0 && var10 <= Graphics3D.rasterClipX && var11 <= Graphics3D.rasterClipX && var12 <= Graphics3D.rasterClipX) {
                        field1973[var6] = false;
                     } else {
                        field1973[var6] = true;
                     }

                     var13 = (field1996[var7] + field1996[var8] + field1996[var9]) / 3 + this.field1962;
                     field1980[var13][field1979[var13]++] = var6;
                  }
               } else {
                  var13 = yViewportBuffer[var7];
                  var14 = yViewportBuffer[var8];
                  var15 = yViewportBuffer[var9];
                  int var16 = field1976[var7];
                  var17 = field1976[var8];
                  int var18 = field1976[var9];
                  int var19 = field1959[var7];
                  int var20 = field1959[var8];
                  int var21 = field1959[var9];
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
                     int var25 = (field1996[var7] + field1996[var8] + field1996[var9]) / 3 + this.field1962;
                     field1980[var25][field1979[var25]++] = var6;
                  }
               }
            }
         }

         int[] var26;
         if(this.field1946 == null) {
            for(var6 = this.field1961 - 1; var6 >= 0; --var6) {
               var7 = field1979[var6];
               if(var7 > 0) {
                  var26 = field1980[var6];

                  for(var9 = 0; var9 < var7; ++var9) {
                     this.method2532(var26[var9]);
                  }
               }
            }

         } else {
            for(var6 = 0; var6 < 12; ++var6) {
               field1981[var6] = 0;
               field1989[var6] = 0;
            }

            for(var6 = this.field1961 - 1; var6 >= 0; --var6) {
               var7 = field1979[var6];
               if(var7 > 0) {
                  var26 = field1980[var6];

                  for(var9 = 0; var9 < var7; ++var9) {
                     var10 = var26[var9];
                     byte var30 = this.field1946[var10];
                     var12 = field1981[var30]++;
                     field1964[var30][var12] = var10;
                     if(var30 < 10) {
                        field1989[var30] += var6;
                     } else if(var30 == 10) {
                        field1947[var12] = var6;
                     } else {
                        field1945[var12] = var6;
                     }
                  }
               }
            }

            var6 = 0;
            if(field1981[1] > 0 || field1981[2] > 0) {
               var6 = (field1989[1] + field1989[2]) / (field1981[1] + field1981[2]);
            }

            var7 = 0;
            if(field1981[3] > 0 || field1981[4] > 0) {
               var7 = (field1989[3] + field1989[4]) / (field1981[3] + field1981[4]);
            }

            var8 = 0;
            if(field1981[6] > 0 || field1981[8] > 0) {
               var8 = (field1989[8] + field1989[6]) / (field1981[8] + field1981[6]);
            }

            var10 = 0;
            var11 = field1981[10];
            int[] var27 = field1964[10];
            int[] var28 = field1947;
            if(var10 == var11) {
               var10 = 0;
               var11 = field1981[11];
               var27 = field1964[11];
               var28 = field1945;
            }

            if(var10 < var11) {
               var9 = var28[var10];
            } else {
               var9 = -1000;
            }

            for(var14 = 0; var14 < 10; ++var14) {
               while(var14 == 0 && var9 > var6) {
                  this.method2532(var27[var10++]);
                  if(var10 == var11 && var27 != field1964[11]) {
                     var10 = 0;
                     var11 = field1981[11];
                     var27 = field1964[11];
                     var28 = field1945;
                  }

                  if(var10 < var11) {
                     var9 = var28[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 3 && var9 > var7) {
                  this.method2532(var27[var10++]);
                  if(var10 == var11 && var27 != field1964[11]) {
                     var10 = 0;
                     var11 = field1981[11];
                     var27 = field1964[11];
                     var28 = field1945;
                  }

                  if(var10 < var11) {
                     var9 = var28[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 5 && var9 > var8) {
                  this.method2532(var27[var10++]);
                  if(var10 == var11 && var27 != field1964[11]) {
                     var10 = 0;
                     var11 = field1981[11];
                     var27 = field1964[11];
                     var28 = field1945;
                  }

                  if(var10 < var11) {
                     var9 = var28[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               var15 = field1981[var14];
               int[] var29 = field1964[var14];

               for(var17 = 0; var17 < var15; ++var17) {
                  this.method2532(var29[var17]);
               }
            }

            while(var9 != -1000) {
               this.method2532(var27[var10++]);
               if(var10 == var11 && var27 != field1964[11]) {
                  var10 = 0;
                  var27 = field1964[11];
                  var11 = field1981[11];
                  var28 = field1945;
               }

               if(var10 < var11) {
                  var9 = var28[var10];
               } else {
                  var9 = -1000;
               }
            }

         }
      }
   }

   @ObfuscatedName("ag")
   final void method2532(int var1) {
      if(field1971[var1]) {
         this.method2533(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         Graphics3D.rasterClipEnable = field1973[var1];
         if(this.field1984 == null) {
            Graphics3D.rasterAlpha = 0;
         } else {
            Graphics3D.rasterAlpha = this.field1984[var1] & 255;
         }

         if(this.field1949 != null && this.field1949[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1948 != null && this.field1948[var1] != -1) {
               int var8 = this.field1948[var1] & 255;
               var5 = this.field1931[var8];
               var6 = this.field1953[var8];
               var7 = this.field1954[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field2000[var1] == -1) {
               Graphics3D.rasterTextureAffine(field1970[var2], field1970[var3], field1970[var4], field1983[var2], field1983[var3], field1983[var4], this.field1943[var1], this.field1943[var1], this.field1943[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1976[var5], field1976[var6], field1976[var7], field1959[var5], field1959[var6], field1959[var7], this.field1949[var1]);
            } else {
               Graphics3D.rasterTextureAffine(field1970[var2], field1970[var3], field1970[var4], field1983[var2], field1983[var3], field1983[var4], this.field1943[var1], this.field1944[var1], this.field2000[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1976[var5], field1976[var6], field1976[var7], field1959[var5], field1959[var6], field1959[var7], this.field1949[var1]);
            }
         } else if(this.field2000[var1] == -1) {
            Graphics3D.rasterFlat(field1970[var2], field1970[var3], field1970[var4], field1983[var2], field1983[var3], field1983[var4], field1997[this.field1943[var1]]);
         } else {
            Graphics3D.rasterGouraud(field1970[var2], field1970[var3], field1970[var4], field1983[var2], field1983[var3], field1983[var4], this.field1943[var1], this.field1944[var1], this.field2000[var1]);
         }

      }
   }

   @ObfuscatedName("g")
   public void method2526(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1935; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.method2588();
   }

   @ObfuscatedName("ar")
   public final void method2528(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1979[0] = -1;
      if(this.field1958 != 2 && this.field1958 != 1) {
         this.method2579();
      }

      int var8 = Graphics3D.centerX;
      int var9 = Graphics3D.centerY;
      int var10 = field1995[var1];
      int var11 = field1937[var1];
      int var12 = field1995[var2];
      int var13 = field1937[var2];
      int var14 = field1995[var3];
      int var15 = field1937[var3];
      int var16 = field1995[var4];
      int var17 = field1937[var4];
      int var18 = var16 * var6 + var17 * var7 >> 16;

      for(int var19 = 0; var19 < this.field1935; ++var19) {
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
         field1996[var19] = var22 - var18;
         field1983[var19] = var20 * Graphics3D.field2030 / var22 + var8;
         field1970[var19] = var9 + var23 * Graphics3D.field2030 / var22;
         if(this.field1951 > 0) {
            yViewportBuffer[var19] = var20;
            field1976[var19] = var23;
            field1959[var19] = var22;
         }
      }

      try {
         this.method2556(false, false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("ax")
   public final void method2589(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1979[0] = -1;
      if(this.field1958 != 2 && this.field1958 != 1) {
         this.method2579();
      }

      int var9 = Graphics3D.centerX;
      int var10 = Graphics3D.centerY;
      int var11 = field1995[var1];
      int var12 = field1937[var1];
      int var13 = field1995[var2];
      int var14 = field1937[var2];
      int var15 = field1995[var3];
      int var16 = field1937[var3];
      int var17 = field1995[var4];
      int var18 = field1937[var4];
      int var19 = var17 * var6 + var18 * var7 >> 16;

      for(int var20 = 0; var20 < this.field1935; ++var20) {
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
         field1996[var20] = var23 - var19;
         field1983[var20] = var9 + var21 * Graphics3D.field2030 / var8;
         field1970[var20] = var10 + var24 * Graphics3D.field2030 / var8;
         if(this.field1951 > 0) {
            yViewportBuffer[var20] = var21;
            field1976[var20] = var24;
            field1959[var20] = var23;
         }
      }

      try {
         this.method2556(false, false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("k")
   public int method2562() {
      this.method2515();
      return this.XYZMag;
   }
}
