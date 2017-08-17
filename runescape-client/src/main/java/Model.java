import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("al")
   static boolean[] field1966;
   @ObfuscatedName("ai")
   static int[] field1974;
   @ObfuscatedName("bb")
   static int[] field1945;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Leo;"
   )
   static Model field1967;
   @ObfuscatedName("p")
   static byte[] field1929;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Leo;"
   )
   static Model field1951;
   @ObfuscatedName("bh")
   static int field1978;
   @ObfuscatedName("h")
   static byte[] field1955;
   @ObfuscatedName("bd")
   static int[] field1991;
   @ObfuscatedName("bw")
   static int field1985;
   @ObfuscatedName("az")
   static boolean[] field1926;
   @ObfuscatedName("bj")
   static int field1961;
   @ObfuscatedName("aw")
   static int[] field1984;
   @ObfuscatedName("bn")
   static int[] field1981;
   @ObfuscatedName("ad")
   @Export("yViewportBuffer")
   static int[] yViewportBuffer;
   @ObfuscatedName("aa")
   static int[] field1971;
   @ObfuscatedName("am")
   public static int[] field1952;
   @ObfuscatedName("ac")
   static int[] field1976;
   @ObfuscatedName("by")
   static int[] field1982;
   @ObfuscatedName("ah")
   public static int[] field1968;
   @ObfuscatedName("be")
   static int[] field1993;
   @ObfuscatedName("ba")
   static int[] field1980;
   @ObfuscatedName("ak")
   static int[][] field1975;
   @ObfuscatedName("bc")
   @Export("xViewportBuffer")
   static int[] xViewportBuffer;
   @ObfuscatedName("ap")
   static int[] field1964;
   @ObfuscatedName("bq")
   static int[] field1992;
   @ObfuscatedName("ay")
   static int[][] field1958;
   @ObfuscatedName("bk")
   static int[] field1928;
   @ObfuscatedName("bi")
   static int[] field1957;
   @ObfuscatedName("bp")
   static boolean field1938;
   @ObfuscatedName("ag")
   int field1956;
   @ObfuscatedName("at")
   public int field1942;
   @ObfuscatedName("ao")
   int field1953;
   @ObfuscatedName("n")
   int[][] field1963;
   @ObfuscatedName("x")
   int field1930;
   @ObfuscatedName("ab")
   public int field1969;
   @ObfuscatedName("b")
   @Export("indices1")
   public int[] indices1;
   @ObfuscatedName("ar")
   @Export("XYZMag")
   int XYZMag;
   @ObfuscatedName("w")
   public int field1934;
   @ObfuscatedName("g")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("l")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("o")
   @Export("indices2")
   public int[] indices2;
   @ObfuscatedName("m")
   @Export("indices3")
   public int[] indices3;
   @ObfuscatedName("c")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("d")
   int[][] field1960;
   @ObfuscatedName("y")
   byte field1977;
   @ObfuscatedName("an")
   int field1986;
   @ObfuscatedName("z")
   int field1949;
   @ObfuscatedName("a")
   byte[] field1972;
   @ObfuscatedName("aj")
   public int field1959;
   @ObfuscatedName("i")
   int[] field1946;
   @ObfuscatedName("r")
   public int[] field1940;
   @ObfuscatedName("as")
   public int field1962;
   @ObfuscatedName("ax")
   public boolean field1990;
   @ObfuscatedName("s")
   int[] field1939;
   @ObfuscatedName("e")
   byte[] field1941;
   @ObfuscatedName("t")
   short[] field1944;
   @ObfuscatedName("ae")
   public int field1987;
   @ObfuscatedName("av")
   int field1954;
   @ObfuscatedName("af")
   public int field1983;
   @ObfuscatedName("v")
   byte[] field1943;
   @ObfuscatedName("u")
   int[] field1947;
   @ObfuscatedName("k")
   int[] field1948;
   @ObfuscatedName("q")
   int[] field1927;

   static {
      field1951 = new Model();
      field1955 = new byte[1];
      field1967 = new Model();
      field1929 = new byte[1];
      field1926 = new boolean[4700];
      field1966 = new boolean[4700];
      field1952 = new int[4700];
      field1968 = new int[4700];
      field1964 = new int[4700];
      yViewportBuffer = new int[4700];
      field1971 = new int[4700];
      field1984 = new int[4700];
      field1974 = new int[1600];
      field1975 = new int[1600][512];
      field1976 = new int[12];
      field1958 = new int[12][2000];
      field1928 = new int[2000];
      field1957 = new int[2000];
      field1980 = new int[12];
      field1981 = new int[10];
      field1982 = new int[10];
      xViewportBuffer = new int[10];
      field1938 = true;
      field1945 = Graphics3D.SINE;
      field1991 = Graphics3D.COSINE;
      field1992 = Graphics3D.colorPalette;
      field1993 = Graphics3D.field2039;
   }

   Model() {
      this.field1930 = 0;
      this.field1934 = 0;
      this.field1977 = 0;
      this.field1949 = 0;
      this.field1990 = false;
      this.field1942 = -1;
      this.field1962 = -1;
      this.field1983 = -1;
   }

   @ObfuscatedSignature(
      signature = "([Leo;I)V"
   )
   public Model(Model[] var1, int var2) {
      this.field1930 = 0;
      this.field1934 = 0;
      this.field1977 = 0;
      this.field1949 = 0;
      this.field1990 = false;
      this.field1942 = -1;
      this.field1962 = -1;
      this.field1983 = -1;
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1930 = 0;
      this.field1934 = 0;
      this.field1949 = 0;
      this.field1977 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1930 += var8.field1930;
            this.field1934 += var8.field1934;
            this.field1949 += var8.field1949;
            if(var8.field1941 != null) {
               var3 = true;
            } else {
               if(this.field1977 == -1) {
                  this.field1977 = var8.field1977;
               }

               if(this.field1977 != var8.field1977) {
                  var3 = true;
               }
            }

            var4 |= var8.field1972 != null;
            var5 |= var8.field1944 != null;
            var6 |= var8.field1943 != null;
         }
      }

      this.verticesX = new int[this.field1930];
      this.verticesY = new int[this.field1930];
      this.verticesZ = new int[this.field1930];
      this.indices1 = new int[this.field1934];
      this.indices2 = new int[this.field1934];
      this.indices3 = new int[this.field1934];
      this.field1946 = new int[this.field1934];
      this.field1939 = new int[this.field1934];
      this.field1940 = new int[this.field1934];
      if(var3) {
         this.field1941 = new byte[this.field1934];
      }

      if(var4) {
         this.field1972 = new byte[this.field1934];
      }

      if(var5) {
         this.field1944 = new short[this.field1934];
      }

      if(var6) {
         this.field1943 = new byte[this.field1934];
      }

      if(this.field1949 > 0) {
         this.field1947 = new int[this.field1949];
         this.field1948 = new int[this.field1949];
         this.field1927 = new int[this.field1949];
      }

      this.field1930 = 0;
      this.field1934 = 0;
      this.field1949 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1934; ++var9) {
               this.indices1[this.field1934] = this.field1930 + var8.indices1[var9];
               this.indices2[this.field1934] = this.field1930 + var8.indices2[var9];
               this.indices3[this.field1934] = this.field1930 + var8.indices3[var9];
               this.field1946[this.field1934] = var8.field1946[var9];
               this.field1939[this.field1934] = var8.field1939[var9];
               this.field1940[this.field1934] = var8.field1940[var9];
               if(var3) {
                  if(var8.field1941 != null) {
                     this.field1941[this.field1934] = var8.field1941[var9];
                  } else {
                     this.field1941[this.field1934] = var8.field1977;
                  }
               }

               if(var4 && var8.field1972 != null) {
                  this.field1972[this.field1934] = var8.field1972[var9];
               }

               if(var5) {
                  if(var8.field1944 != null) {
                     this.field1944[this.field1934] = var8.field1944[var9];
                  } else {
                     this.field1944[this.field1934] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1943 != null && var8.field1943[var9] != -1) {
                     this.field1943[this.field1934] = (byte)(this.field1949 + var8.field1943[var9]);
                  } else {
                     this.field1943[this.field1934] = -1;
                  }
               }

               ++this.field1934;
            }

            for(var9 = 0; var9 < var8.field1949; ++var9) {
               this.field1947[this.field1949] = this.field1930 + var8.field1947[var9];
               this.field1948[this.field1949] = this.field1930 + var8.field1948[var9];
               this.field1927[this.field1949] = this.field1930 + var8.field1927[var9];
               ++this.field1949;
            }

            for(var9 = 0; var9 < var8.field1930; ++var9) {
               this.verticesX[this.field1930] = var8.verticesX[var9];
               this.verticesY[this.field1930] = var8.verticesY[var9];
               this.verticesZ[this.field1930] = var8.verticesZ[var9];
               ++this.field1930;
            }
         }
      }

   }

   @ObfuscatedName("c")
   public void method2528() {
      if(this.field1953 != 1) {
         this.field1953 = 1;
         super.modelHeight = 0;
         this.field1986 = 0;
         this.XYZMag = 0;

         for(int var1 = 0; var1 < this.field1930; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1986) {
               this.field1986 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.XYZMag) {
               this.XYZMag = var5;
            }
         }

         this.XYZMag = (int)(Math.sqrt((double)this.XYZMag) + 0.99D);
         this.field1954 = (int)(Math.sqrt((double)(this.XYZMag * this.XYZMag + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1956 = this.field1954 + (int)(Math.sqrt((double)(this.XYZMag * this.XYZMag + this.field1986 * this.field1986)) + 0.99D);
      }
   }

   @ObfuscatedName("ag")
   final void method2545(int var1) {
      int var2 = Graphics3D.centerX;
      int var3 = Graphics3D.centerY;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1984[var5];
      int var9 = field1984[var6];
      int var10 = field1984[var7];
      if(this.field1972 == null) {
         Graphics3D.rasterAlpha = 0;
      } else {
         Graphics3D.rasterAlpha = this.field1972[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1981[var4] = field1952[var5];
         field1982[var4] = field1968[var5];
         xViewportBuffer[var4++] = this.field1946[var1];
      } else {
         var11 = yViewportBuffer[var5];
         var12 = field1971[var5];
         var13 = this.field1946[var1];
         if(var10 >= 50) {
            var14 = field1993[var10 - var8] * (50 - var8);
            field1981[var4] = var2 + (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) * Graphics3D.field2026 / 50;
            field1982[var4] = var3 + (var12 + ((field1971[var7] - var12) * var14 >> 16)) * Graphics3D.field2026 / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1940[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = field1993[var9 - var8] * (50 - var8);
            field1981[var4] = var2 + Graphics3D.field2026 * (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) / 50;
            field1982[var4] = var3 + Graphics3D.field2026 * (var12 + ((field1971[var6] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1939[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1981[var4] = field1952[var6];
         field1982[var4] = field1968[var6];
         xViewportBuffer[var4++] = this.field1939[var1];
      } else {
         var11 = yViewportBuffer[var6];
         var12 = field1971[var6];
         var13 = this.field1939[var1];
         if(var8 >= 50) {
            var14 = field1993[var8 - var9] * (50 - var9);
            field1981[var4] = var2 + (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) * Graphics3D.field2026 / 50;
            field1982[var4] = var3 + (var12 + ((field1971[var5] - var12) * var14 >> 16)) * Graphics3D.field2026 / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1946[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = field1993[var10 - var9] * (50 - var9);
            field1981[var4] = var2 + (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) * Graphics3D.field2026 / 50;
            field1982[var4] = var3 + (var12 + ((field1971[var7] - var12) * var14 >> 16)) * Graphics3D.field2026 / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1940[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1981[var4] = field1952[var7];
         field1982[var4] = field1968[var7];
         xViewportBuffer[var4++] = this.field1940[var1];
      } else {
         var11 = yViewportBuffer[var7];
         var12 = field1971[var7];
         var13 = this.field1940[var1];
         if(var9 >= 50) {
            var14 = field1993[var9 - var10] * (50 - var10);
            field1981[var4] = var2 + Graphics3D.field2026 * (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) / 50;
            field1982[var4] = var3 + (var12 + ((field1971[var6] - var12) * var14 >> 16)) * Graphics3D.field2026 / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1939[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = field1993[var8 - var10] * (50 - var10);
            field1981[var4] = var2 + (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) * Graphics3D.field2026 / 50;
            field1982[var4] = var3 + Graphics3D.field2026 * (var12 + ((field1971[var5] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1946[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1981[0];
      var12 = field1981[1];
      var13 = field1981[2];
      var14 = field1982[0];
      int var15 = field1982[1];
      int var16 = field1982[2];
      Graphics3D.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX) {
            Graphics3D.rasterClipEnable = true;
         }

         if(this.field1944 != null && this.field1944[var1] != -1) {
            if(this.field1943 != null && this.field1943[var1] != -1) {
               var20 = this.field1943[var1] & 255;
               var17 = this.field1947[var20];
               var18 = this.field1948[var20];
               var19 = this.field1927[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1940[var1] == -1) {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1946[var1], this.field1946[var1], this.field1946[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1971[var17], field1971[var18], field1971[var19], field1984[var17], field1984[var18], field1984[var19], this.field1944[var1]);
            } else {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1971[var17], field1971[var18], field1971[var19], field1984[var17], field1984[var18], field1984[var19], this.field1944[var1]);
            }
         } else if(this.field1940[var1] == -1) {
            Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, field1992[this.field1946[var1]]);
         } else {
            Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX || field1981[3] < 0 || field1981[3] > Graphics3D.rasterClipX) {
            Graphics3D.rasterClipEnable = true;
         }

         if(this.field1944 != null && this.field1944[var1] != -1) {
            if(this.field1943 != null && this.field1943[var1] != -1) {
               var20 = this.field1943[var1] & 255;
               var17 = this.field1947[var20];
               var18 = this.field1948[var20];
               var19 = this.field1927[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1944[var1];
            if(this.field1940[var1] == -1) {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1946[var1], this.field1946[var1], this.field1946[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1971[var17], field1971[var18], field1971[var19], field1984[var17], field1984[var18], field1984[var19], var21);
               Graphics3D.rasterTextureAffine(var14, var16, field1982[3], var11, var13, field1981[3], this.field1946[var1], this.field1946[var1], this.field1946[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1971[var17], field1971[var18], field1971[var19], field1984[var17], field1984[var18], field1984[var19], var21);
            } else {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1971[var17], field1971[var18], field1971[var19], field1984[var17], field1984[var18], field1984[var19], var21);
               Graphics3D.rasterTextureAffine(var14, var16, field1982[3], var11, var13, field1981[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1971[var17], field1971[var18], field1971[var19], field1984[var17], field1984[var18], field1984[var19], var21);
            }
         } else if(this.field1940[var1] == -1) {
            var17 = field1992[this.field1946[var1]];
            Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            Graphics3D.rasterFlat(var14, var16, field1982[3], var11, var13, field1981[3], var17);
         } else {
            Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
            Graphics3D.rasterGouraud(var14, var16, field1982[3], var11, var13, field1981[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3]);
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lef;I)V"
   )
   public void method2531(Frames var1, int var2) {
      if(this.field1963 != null) {
         if(var2 != -1) {
            Frame var3 = var1.skeletons[var2];
            FrameMap var4 = var3.skin;
            field1978 = 0;
            field1985 = 0;
            field1961 = 0;

            for(int var5 = 0; var5 < var3.field1894; ++var5) {
               int var6 = var3.field1896[var5];
               this.method2580(var4.types[var6], var4.list[var6], var3.translator_x[var5], var3.translator_y[var5], var3.translator_z[var5]);
            }

            this.method2546();
         }
      }
   }

   @ObfuscatedName("b")
   void method2546() {
      this.field1953 = 0;
      this.field1942 = -1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ZLeo;[B)Leo;"
   )
   Model method2562(boolean var1, Model var2, byte[] var3) {
      var2.field1930 = this.field1930;
      var2.field1934 = this.field1934;
      var2.field1949 = this.field1949;
      if(var2.verticesX == null || var2.verticesX.length < this.field1930) {
         var2.verticesX = new int[this.field1930 + 100];
         var2.verticesY = new int[this.field1930 + 100];
         var2.verticesZ = new int[this.field1930 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1930; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if(var1) {
         var2.field1972 = this.field1972;
      } else {
         var2.field1972 = var3;
         if(this.field1972 == null) {
            for(var4 = 0; var4 < this.field1934; ++var4) {
               var2.field1972[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1934; ++var4) {
               var2.field1972[var4] = this.field1972[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1946 = this.field1946;
      var2.field1939 = this.field1939;
      var2.field1940 = this.field1940;
      var2.field1941 = this.field1941;
      var2.field1943 = this.field1943;
      var2.field1944 = this.field1944;
      var2.field1977 = this.field1977;
      var2.field1947 = this.field1947;
      var2.field1948 = this.field1948;
      var2.field1927 = this.field1927;
      var2.field1963 = this.field1963;
      var2.field1960 = this.field1960;
      var2.field1990 = this.field1990;
      var2.method2546();
      return var2;
   }

   @ObfuscatedName("g")
   void method2540(int var1) {
      if(this.field1942 == -1) {
         int var2 = 0;
         int var3 = 0;
         int var4 = 0;
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         int var8 = field1991[var1];
         int var9 = field1945[var1];

         for(int var10 = 0; var10 < this.field1930; ++var10) {
            int var11 = Graphics3D.method2626(this.verticesX[var10], this.verticesZ[var10], var8, var9);
            int var12 = this.verticesY[var10];
            int var13 = Graphics3D.method2633(this.verticesX[var10], this.verticesZ[var10], var8, var9);
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
         this.field1959 = (var6 + var3) / 2;
         this.field1987 = (var7 + var4) / 2;
         this.field1942 = (var5 - var2 + 1) / 2;
         this.field1962 = (var6 - var3 + 1) / 2;
         this.field1983 = (var7 - var4 + 1) / 2;
         if(this.field1942 < 32) {
            this.field1942 = 32;
         }

         if(this.field1983 < 32) {
            this.field1983 = 32;
         }

         if(this.field1990) {
            this.field1942 += 8;
            this.field1983 += 8;
         }

      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Z)Leo;"
   )
   public Model method2525(boolean var1) {
      if(!var1 && field1955.length < this.field1934) {
         field1955 = new byte[this.field1934 + 100];
      }

      return this.method2562(var1, field1951, field1955);
   }

   @ObfuscatedName("l")
   void method2529() {
      if(this.field1953 != 2) {
         this.field1953 = 2;
         this.XYZMag = 0;

         for(int var1 = 0; var1 < this.field1930; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.XYZMag) {
               this.XYZMag = var5;
            }
         }

         this.XYZMag = (int)(Math.sqrt((double)this.XYZMag) + 0.99D);
         this.field1954 = this.XYZMag;
         this.field1956 = this.XYZMag + this.XYZMag;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Z)Leo;"
   )
   public Model method2526(boolean var1) {
      if(!var1 && field1929.length < this.field1934) {
         field1929 = new byte[this.field1934 + 100];
      }

      return this.method2562(var1, field1967, field1929);
   }

   @ObfuscatedName("u")
   public void method2537(int var1) {
      int var2 = field1945[var1];
      int var3 = field1991[var1];

      for(int var4 = 0; var4 < this.field1930; ++var4) {
         int var5 = var3 * this.verticesY[var4] - var2 * this.verticesZ[var4] >> 16;
         this.verticesZ[var4] = var2 * this.verticesY[var4] + var3 * this.verticesZ[var4] >> 16;
         this.verticesY[var4] = var5;
      }

      this.method2546();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([[IIIIZI)Leo;"
   )
   public Model method2524(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2528();
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
               var11.field1930 = this.field1930;
               var11.field1934 = this.field1934;
               var11.field1949 = this.field1949;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1946 = this.field1946;
               var11.field1939 = this.field1939;
               var11.field1940 = this.field1940;
               var11.field1941 = this.field1941;
               var11.field1972 = this.field1972;
               var11.field1943 = this.field1943;
               var11.field1944 = this.field1944;
               var11.field1977 = this.field1977;
               var11.field1947 = this.field1947;
               var11.field1948 = this.field1948;
               var11.field1927 = this.field1927;
               var11.field1963 = this.field1963;
               var11.field1960 = this.field1960;
               var11.field1990 = this.field1990;
               var11.verticesY = new int[var11.field1930];
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
               for(var12 = 0; var12 < var11.field1930; ++var12) {
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
               for(var12 = 0; var12 < var11.field1930; ++var12) {
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
                     var11.verticesY[var12] = (var6 - var13) * (var22 - var3) / var6 + this.verticesY[var12];
                  }
               }
            }

            var11.method2546();
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("y")
   public void method2536() {
      for(int var1 = 0; var1 < this.field1930; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.method2546();
   }

   @ObfuscatedName("ci")
   @Export("draw")
   void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1974[0] = -1;
      if(this.field1953 != 1) {
         this.method2528();
      }

      this.method2540(var1);
      int var10 = var5 * var8 - var4 * var6 >> 16;
      int var11 = var2 * var7 + var3 * var10 >> 16;
      int var12 = var3 * this.XYZMag >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var5 * var6 >> 16;
         int var15 = (var14 - this.XYZMag) * Graphics3D.field2026;
         if(var15 / var13 < Graphics3D.field2032) {
            int var16 = (var14 + this.XYZMag) * Graphics3D.field2026;
            if(var16 / var13 > Graphics3D.field2025) {
               int var17 = var3 * var7 - var10 * var2 >> 16;
               int var18 = var2 * this.XYZMag >> 16;
               int var19 = (var17 + var18) * Graphics3D.field2026;
               if(var19 / var13 > Graphics3D.field2033) {
                  int var20 = var18 + (var3 * super.modelHeight >> 16);
                  int var21 = (var17 - var20) * Graphics3D.field2026;
                  if(var21 / var13 < Graphics3D.field2034) {
                     int var22 = var12 + (var2 * super.modelHeight >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1949 > 0;
                     int var26 = class135.field1996;
                     int var28 = class135.field1998;
                     boolean var30 = TextureProvider.method2426();
                     if(class7.field227 && var9 > 0) {
                        if(class67.method1147(this, var6, var7, var8)) {
                           class208.method3886(this, var6, var7, var8, -65281);
                        } else if(class7.field230 == class11.field263) {
                           class208.method3886(this, var6, var7, var8, -16776961);
                        }
                     }

                     int var32;
                     int var33;
                     int var34;
                     int var35;
                     int var36;
                     int var37;
                     int var38;
                     if(class7.field228 && var9 > 0) {
                        int var41 = var11 - var12;
                        if(var41 <= 50) {
                           var41 = 50;
                        }

                        if(var14 > 0) {
                           var32 = var15 / var13;
                           var33 = var16 / var41;
                        } else {
                           var33 = var16 / var13;
                           var32 = var15 / var41;
                        }

                        if(var17 > 0) {
                           var34 = var21 / var13;
                           var35 = var19 / var41;
                        } else {
                           var35 = var19 / var13;
                           var34 = var21 / var41;
                        }

                        var36 = -8355840;
                        var37 = var26 - Graphics3D.centerX;
                        var38 = var28 - Graphics3D.centerY;
                        if(var37 > var32 && var37 < var33 && var38 > var34 && var38 < var35) {
                           var36 = -256;
                        }

                        class1.method0(var32 + Graphics3D.centerX, var34 + Graphics3D.centerY, var33 + Graphics3D.centerX, var35 + Graphics3D.centerY, var36);
                     }

                     boolean var45 = false;
                     if(var9 > 0 && var30) {
                        boolean var44 = false;
                        if(field1938) {
                           var44 = class67.method1147(this, var6, var7, var8);
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
                              var44 = true;
                           }
                        }

                        if(var44) {
                           if(this.field1990) {
                              class27.method226(var9);
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
                        var34 = field1945[var1];
                        var35 = field1991[var1];
                     }

                     for(var36 = 0; var36 < this.field1930; ++var36) {
                        var37 = this.verticesX[var36];
                        var38 = this.verticesY[var36];
                        int var39 = this.verticesZ[var36];
                        int var40;
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
                        field1964[var36] = var39 - var11;
                        if(var39 >= 50) {
                           field1952[var36] = var32 + var37 * Graphics3D.field2026 / var39;
                           field1968[var36] = var40 * Graphics3D.field2026 / var39 + var33;
                        } else {
                           field1952[var36] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           yViewportBuffer[var36] = var37;
                           field1971[var36] = var40;
                           field1984[var36] = var39;
                        }
                     }

                     try {
                        this.method2534(var23, var45, this.field1990, var9);
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
   public void method2559() {
      for(int var1 = 0; var1 < this.field1930; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.method2546();
   }

   @ObfuscatedName("d")
   public void method2539(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1930; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = var2 * this.verticesY[var4] / 128;
         this.verticesZ[var4] = var3 * this.verticesZ[var4] / 128;
      }

      this.method2546();
   }

   @ObfuscatedName("v")
   public void method2535() {
      for(int var1 = 0; var1 < this.field1930; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.method2546();
   }

   @ObfuscatedName("a")
   void method2580(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1978 = 0;
         field1985 = 0;
         field1961 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var9 = var2[var8];
            if(var9 < this.field1963.length) {
               int[] var10 = this.field1963[var9];

               for(var11 = 0; var11 < var10.length; ++var11) {
                  var12 = var10[var11];
                  field1978 += this.verticesX[var12];
                  field1985 += this.verticesY[var12];
                  field1961 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1978 = var3 + field1978 / var7;
            field1985 = var4 + field1985 / var7;
            field1961 = var5 + field1961 / var7;
         } else {
            field1978 = var3;
            field1985 = var4;
            field1961 = var5;
         }

      } else {
         int[] var18;
         int var19;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1963.length) {
                  var18 = this.field1963[var8];

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
               if(var8 < this.field1963.length) {
                  var18 = this.field1963[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= field1978;
                     this.verticesY[var11] -= field1985;
                     this.verticesZ[var11] -= field1961;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1945[var14];
                        var16 = field1991[var14];
                        var17 = var15 * this.verticesY[var11] + var16 * this.verticesX[var11] >> 16;
                        this.verticesY[var11] = var16 * this.verticesY[var11] - var15 * this.verticesX[var11] >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1945[var12];
                        var16 = field1991[var12];
                        var17 = var16 * this.verticesY[var11] - var15 * this.verticesZ[var11] >> 16;
                        this.verticesZ[var11] = var15 * this.verticesY[var11] + var16 * this.verticesZ[var11] >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1945[var13];
                        var16 = field1991[var13];
                        var17 = var15 * this.verticesZ[var11] + var16 * this.verticesX[var11] >> 16;
                        this.verticesZ[var11] = var16 * this.verticesZ[var11] - var15 * this.verticesX[var11] >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += field1978;
                     this.verticesY[var11] += field1985;
                     this.verticesZ[var11] += field1961;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1963.length) {
                  var18 = this.field1963[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= field1978;
                     this.verticesY[var11] -= field1985;
                     this.verticesZ[var11] -= field1961;
                     this.verticesX[var11] = var3 * this.verticesX[var11] / 128;
                     this.verticesY[var11] = var4 * this.verticesY[var11] / 128;
                     this.verticesZ[var11] = var5 * this.verticesZ[var11] / 128;
                     this.verticesX[var11] += field1978;
                     this.verticesY[var11] += field1985;
                     this.verticesZ[var11] += field1961;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1960 != null && this.field1972 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1960.length) {
                     var18 = this.field1960[var8];

                     for(var19 = 0; var19 < var18.length; ++var19) {
                        var11 = var18[var19];
                        var12 = (this.field1972[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1972[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lef;ILef;I[I)V"
   )
   public void method2552(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.skeletons[var2];
            Frame var7 = var3.skeletons[var4];
            FrameMap var8 = var6.skin;
            field1978 = 0;
            field1985 = 0;
            field1961 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1894; ++var11) {
               for(var12 = var6.field1896[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.types[var12] == 0) {
                  this.method2580(var8.types[var12], var8.list[var12], var6.translator_x[var11], var6.translator_y[var11], var6.translator_z[var11]);
               }
            }

            field1978 = 0;
            field1985 = 0;
            field1961 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1894; ++var11) {
               for(var12 = var7.field1896[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.types[var12] == 0) {
                  this.method2580(var8.types[var12], var8.list[var12], var7.translator_x[var11], var7.translator_y[var11], var7.translator_z[var11]);
               }
            }

            this.method2546();
         } else {
            this.method2531(var1, var2);
         }
      }
   }

   @ObfuscatedName("an")
   final void method2534(boolean var1, boolean var2, boolean var3, int var4) {
      if(this.field1956 < 1600) {
         int var5;
         for(var5 = 0; var5 < this.field1956; ++var5) {
            field1974[var5] = 0;
         }

         var5 = var3?20:5;
         if(class7.field229 && var2) {
            XGrandExchangeOffer.method117(this, var5);
         }

         int var6;
         int var7;
         int var9;
         int var10;
         int var11;
         int var12;
         int var14;
         int var15;
         int var17;
         int var26;
         for(var6 = 0; var6 < this.field1934; ++var6) {
            if(this.field1940[var6] != -2) {
               var7 = this.indices1[var6];
               var26 = this.indices2[var6];
               var9 = this.indices3[var6];
               var10 = field1952[var7];
               var11 = field1952[var26];
               var12 = field1952[var9];
               int var13;
               if(!var1 || var10 != -5000 && var11 != -5000 && var12 != -5000) {
                  if(var2 && ItemLayer.method2428(field1968[var7], field1968[var26], field1968[var9], var10, var11, var12, var5)) {
                     class27.method226(var4);
                     var2 = false;
                  }

                  if((var10 - var11) * (field1968[var9] - field1968[var26]) - (var12 - var11) * (field1968[var7] - field1968[var26]) > 0) {
                     field1966[var6] = false;
                     if(var10 >= 0 && var11 >= 0 && var12 >= 0 && var10 <= Graphics3D.rasterClipX && var11 <= Graphics3D.rasterClipX && var12 <= Graphics3D.rasterClipX) {
                        field1926[var6] = false;
                     } else {
                        field1926[var6] = true;
                     }

                     var13 = (field1964[var7] + field1964[var26] + field1964[var9]) / 3 + this.field1954;
                     field1975[var13][field1974[var13]++] = var6;
                  }
               } else {
                  var13 = yViewportBuffer[var7];
                  var14 = yViewportBuffer[var26];
                  var15 = yViewportBuffer[var9];
                  int var16 = field1971[var7];
                  var17 = field1971[var26];
                  int var18 = field1971[var9];
                  int var19 = field1984[var7];
                  int var20 = field1984[var26];
                  int var21 = field1984[var9];
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
                     field1966[var6] = true;
                     int var25 = (field1964[var7] + field1964[var26] + field1964[var9]) / 3 + this.field1954;
                     field1975[var25][field1974[var25]++] = var6;
                  }
               }
            }
         }

         int[] var8;
         if(this.field1941 == null) {
            for(var6 = this.field1956 - 1; var6 >= 0; --var6) {
               var7 = field1974[var6];
               if(var7 > 0) {
                  var8 = field1975[var6];

                  for(var9 = 0; var9 < var7; ++var9) {
                     this.method2572(var8[var9]);
                  }
               }
            }

         } else {
            for(var6 = 0; var6 < 12; ++var6) {
               field1976[var6] = 0;
               field1980[var6] = 0;
            }

            for(var6 = this.field1956 - 1; var6 >= 0; --var6) {
               var7 = field1974[var6];
               if(var7 > 0) {
                  var8 = field1975[var6];

                  for(var9 = 0; var9 < var7; ++var9) {
                     var10 = var8[var9];
                     byte var30 = this.field1941[var10];
                     var12 = field1976[var30]++;
                     field1958[var30][var12] = var10;
                     if(var30 < 10) {
                        field1980[var30] += var6;
                     } else if(var30 == 10) {
                        field1928[var12] = var6;
                     } else {
                        field1957[var12] = var6;
                     }
                  }
               }
            }

            var6 = 0;
            if(field1976[1] > 0 || field1976[2] > 0) {
               var6 = (field1980[1] + field1980[2]) / (field1976[1] + field1976[2]);
            }

            var7 = 0;
            if(field1976[3] > 0 || field1976[4] > 0) {
               var7 = (field1980[3] + field1980[4]) / (field1976[3] + field1976[4]);
            }

            var26 = 0;
            if(field1976[6] > 0 || field1976[8] > 0) {
               var26 = (field1980[8] + field1980[6]) / (field1976[8] + field1976[6]);
            }

            var10 = 0;
            var11 = field1976[10];
            int[] var27 = field1958[10];
            int[] var28 = field1928;
            if(var10 == var11) {
               var10 = 0;
               var11 = field1976[11];
               var27 = field1958[11];
               var28 = field1957;
            }

            if(var10 < var11) {
               var9 = var28[var10];
            } else {
               var9 = -1000;
            }

            for(var14 = 0; var14 < 10; ++var14) {
               while(var14 == 0 && var9 > var6) {
                  this.method2572(var27[var10++]);
                  if(var10 == var11 && var27 != field1958[11]) {
                     var10 = 0;
                     var11 = field1976[11];
                     var27 = field1958[11];
                     var28 = field1957;
                  }

                  if(var10 < var11) {
                     var9 = var28[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 3 && var9 > var7) {
                  this.method2572(var27[var10++]);
                  if(var10 == var11 && var27 != field1958[11]) {
                     var10 = 0;
                     var11 = field1976[11];
                     var27 = field1958[11];
                     var28 = field1957;
                  }

                  if(var10 < var11) {
                     var9 = var28[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 5 && var9 > var26) {
                  this.method2572(var27[var10++]);
                  if(var10 == var11 && var27 != field1958[11]) {
                     var10 = 0;
                     var11 = field1976[11];
                     var27 = field1958[11];
                     var28 = field1957;
                  }

                  if(var10 < var11) {
                     var9 = var28[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               var15 = field1976[var14];
               int[] var29 = field1958[var14];

               for(var17 = 0; var17 < var15; ++var17) {
                  this.method2572(var29[var17]);
               }
            }

            while(var9 != -1000) {
               this.method2572(var27[var10++]);
               if(var10 == var11 && var27 != field1958[11]) {
                  var10 = 0;
                  var27 = field1958[11];
                  var11 = field1976[11];
                  var28 = field1957;
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

   @ObfuscatedName("ar")
   final void method2572(int var1) {
      if(field1966[var1]) {
         this.method2545(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         Graphics3D.rasterClipEnable = field1926[var1];
         if(this.field1972 == null) {
            Graphics3D.rasterAlpha = 0;
         } else {
            Graphics3D.rasterAlpha = this.field1972[var1] & 255;
         }

         if(this.field1944 != null && this.field1944[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1943 != null && this.field1943[var1] != -1) {
               int var8 = this.field1943[var1] & 255;
               var5 = this.field1947[var8];
               var6 = this.field1948[var8];
               var7 = this.field1927[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1940[var1] == -1) {
               Graphics3D.rasterTextureAffine(field1968[var2], field1968[var3], field1968[var4], field1952[var2], field1952[var3], field1952[var4], this.field1946[var1], this.field1946[var1], this.field1946[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1971[var5], field1971[var6], field1971[var7], field1984[var5], field1984[var6], field1984[var7], this.field1944[var1]);
            } else {
               Graphics3D.rasterTextureAffine(field1968[var2], field1968[var3], field1968[var4], field1952[var2], field1952[var3], field1952[var4], this.field1946[var1], this.field1939[var1], this.field1940[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1971[var5], field1971[var6], field1971[var7], field1984[var5], field1984[var6], field1984[var7], this.field1944[var1]);
            }
         } else if(this.field1940[var1] == -1) {
            Graphics3D.rasterFlat(field1968[var2], field1968[var3], field1968[var4], field1952[var2], field1952[var3], field1952[var4], field1992[this.field1946[var1]]);
         } else {
            Graphics3D.rasterGouraud(field1968[var2], field1968[var3], field1968[var4], field1952[var2], field1952[var3], field1952[var4], this.field1946[var1], this.field1939[var1], this.field1940[var1]);
         }

      }
   }

   @ObfuscatedName("n")
   public void method2538(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1930; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.method2546();
   }

   @ObfuscatedName("ax")
   public final void method2563(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1974[0] = -1;
      if(this.field1953 != 2 && this.field1953 != 1) {
         this.method2529();
      }

      int var8 = Graphics3D.centerX;
      int var9 = Graphics3D.centerY;
      int var10 = field1945[var1];
      int var11 = field1991[var1];
      int var12 = field1945[var2];
      int var13 = field1991[var2];
      int var14 = field1945[var3];
      int var15 = field1991[var3];
      int var16 = field1945[var4];
      int var17 = field1991[var4];
      int var18 = var16 * var6 + var17 * var7 >> 16;

      for(int var19 = 0; var19 < this.field1930; ++var19) {
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
         field1964[var19] = var22 - var18;
         field1952[var19] = var8 + var20 * Graphics3D.field2026 / var22;
         field1968[var19] = var23 * Graphics3D.field2026 / var22 + var9;
         if(this.field1949 > 0) {
            yViewportBuffer[var19] = var20;
            field1971[var19] = var23;
            field1984[var19] = var22;
         }
      }

      try {
         this.method2534(false, false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("ao")
   public final void method2541(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1974[0] = -1;
      if(this.field1953 != 2 && this.field1953 != 1) {
         this.method2529();
      }

      int var9 = Graphics3D.centerX;
      int var10 = Graphics3D.centerY;
      int var11 = field1945[var1];
      int var12 = field1991[var1];
      int var13 = field1945[var2];
      int var14 = field1991[var2];
      int var15 = field1945[var3];
      int var16 = field1991[var3];
      int var17 = field1945[var4];
      int var18 = field1991[var4];
      int var19 = var17 * var6 + var18 * var7 >> 16;

      for(int var20 = 0; var20 < this.field1930; ++var20) {
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
         field1964[var20] = var23 - var19;
         field1952[var20] = var9 + var21 * Graphics3D.field2026 / var8;
         field1968[var20] = var10 + var24 * Graphics3D.field2026 / var8;
         if(this.field1949 > 0) {
            yViewportBuffer[var20] = var21;
            field1971[var20] = var24;
            field1984[var20] = var23;
         }
      }

      try {
         this.method2534(false, false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("w")
   public int method2530() {
      this.method2528();
      return this.XYZMag;
   }
}
