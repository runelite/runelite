import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("aq")
   static boolean[] field1932;
   @ObfuscatedName("aw")
   static int[] field1940;
   @ObfuscatedName("bw")
   static int[] field1956;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lev;"
   )
   static Model field1894;
   @ObfuscatedName("y")
   static byte[] field1895;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lev;"
   )
   static Model field1955;
   @ObfuscatedName("bh")
   static int field1950;
   @ObfuscatedName("q")
   static byte[] field1893;
   @ObfuscatedName("br")
   static int[] field1957;
   @ObfuscatedName("bx")
   static int field1951;
   @ObfuscatedName("az")
   static boolean[] field1931;
   @ObfuscatedName("bn")
   static int field1917;
   @ObfuscatedName("as")
   static int[] field1901;
   @ObfuscatedName("bq")
   static int[] field1947;
   @ObfuscatedName("aa")
   @Export("yViewportBuffer")
   static int[] yViewportBuffer;
   @ObfuscatedName("ay")
   public static int[] field1933;
   @ObfuscatedName("ak")
   static int[] field1942;
   @ObfuscatedName("ab")
   static int[] field1905;
   @ObfuscatedName("bs")
   static int[] field1948;
   @ObfuscatedName("an")
   public static int[] field1949;
   @ObfuscatedName("bp")
   static int[] field1959;
   @ObfuscatedName("bu")
   static int[] field1946;
   @ObfuscatedName("al")
   static int[][] field1941;
   @ObfuscatedName("bv")
   @Export("xViewportBuffer")
   static int[] xViewportBuffer;
   @ObfuscatedName("af")
   static int[] field1936;
   @ObfuscatedName("bt")
   static int[] field1958;
   @ObfuscatedName("aj")
   static int[][] field1937;
   @ObfuscatedName("bz")
   static int[] field1904;
   @ObfuscatedName("bi")
   static int[] field1945;
   @ObfuscatedName("bl")
   public static boolean field1938;
   @ObfuscatedName("ag")
   int field1918;
   @ObfuscatedName("ad")
   public int field1906;
   @ObfuscatedName("ac")
   int field1919;
   @ObfuscatedName("z")
   int[][] field1916;
   @ObfuscatedName("e")
   int field1896;
   @ObfuscatedName("ae")
   public int field1925;
   @ObfuscatedName("r")
   @Export("indices1")
   public int[] indices1;
   @ObfuscatedName("at")
   @Export("XYZMag")
   int XYZMag;
   @ObfuscatedName("f")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("t")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("i")
   public int field1900;
   @ObfuscatedName("g")
   @Export("indices2")
   public int[] indices2;
   @ObfuscatedName("s")
   @Export("indices3")
   public int[] indices3;
   @ObfuscatedName("v")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("j")
   int[][] field1909;
   @ObfuscatedName("c")
   byte field1911;
   @ObfuscatedName("ax")
   int field1920;
   @ObfuscatedName("l")
   int field1930;
   @ObfuscatedName("w")
   byte[] field1908;
   @ObfuscatedName("ai")
   public int field1953;
   @ObfuscatedName("o")
   int[] field1934;
   @ObfuscatedName("u")
   public int[] field1922;
   @ObfuscatedName("ah")
   public int field1928;
   @ObfuscatedName("am")
   public boolean field1902;
   @ObfuscatedName("p")
   int[] field1943;
   @ObfuscatedName("b")
   byte[] field1907;
   @ObfuscatedName("n")
   short[] field1910;
   @ObfuscatedName("au")
   public int field1926;
   @ObfuscatedName("ar")
   int field1923;
   @ObfuscatedName("ao")
   public int field1929;
   @ObfuscatedName("k")
   byte[] field1924;
   @ObfuscatedName("m")
   int[] field1913;
   @ObfuscatedName("a")
   int[] field1914;
   @ObfuscatedName("h")
   int[] field1915;

   static {
      field1955 = new Model();
      field1893 = new byte[1];
      field1894 = new Model();
      field1895 = new byte[1];
      field1931 = new boolean[4700];
      field1932 = new boolean[4700];
      field1933 = new int[4700];
      field1949 = new int[4700];
      field1936 = new int[4700];
      yViewportBuffer = new int[4700];
      field1942 = new int[4700];
      field1901 = new int[4700];
      field1940 = new int[1600];
      field1941 = new int[1600][512];
      field1905 = new int[12];
      field1937 = new int[12][2000];
      field1904 = new int[2000];
      field1945 = new int[2000];
      field1946 = new int[12];
      field1947 = new int[10];
      field1948 = new int[10];
      xViewportBuffer = new int[10];
      field1938 = true;
      field1956 = Graphics3D.SINE;
      field1957 = Graphics3D.COSINE;
      field1958 = Graphics3D.colorPalette;
      field1959 = Graphics3D.field2003;
   }

   Model() {
      this.field1896 = 0;
      this.field1900 = 0;
      this.field1911 = 0;
      this.field1930 = 0;
      this.field1902 = false;
      this.field1906 = -1;
      this.field1928 = -1;
      this.field1929 = -1;
   }

   @ObfuscatedSignature(
      signature = "([Lev;I)V"
   )
   public Model(Model[] var1, int var2) {
      this.field1896 = 0;
      this.field1900 = 0;
      this.field1911 = 0;
      this.field1930 = 0;
      this.field1902 = false;
      this.field1906 = -1;
      this.field1928 = -1;
      this.field1929 = -1;
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1896 = 0;
      this.field1900 = 0;
      this.field1930 = 0;
      this.field1911 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1896 += var8.field1896;
            this.field1900 += var8.field1900;
            this.field1930 += var8.field1930;
            if(var8.field1907 != null) {
               var3 = true;
            } else {
               if(this.field1911 == -1) {
                  this.field1911 = var8.field1911;
               }

               if(this.field1911 != var8.field1911) {
                  var3 = true;
               }
            }

            var4 |= var8.field1908 != null;
            var5 |= var8.field1910 != null;
            var6 |= var8.field1924 != null;
         }
      }

      this.verticesX = new int[this.field1896];
      this.verticesY = new int[this.field1896];
      this.verticesZ = new int[this.field1896];
      this.indices1 = new int[this.field1900];
      this.indices2 = new int[this.field1900];
      this.indices3 = new int[this.field1900];
      this.field1934 = new int[this.field1900];
      this.field1943 = new int[this.field1900];
      this.field1922 = new int[this.field1900];
      if(var3) {
         this.field1907 = new byte[this.field1900];
      }

      if(var4) {
         this.field1908 = new byte[this.field1900];
      }

      if(var5) {
         this.field1910 = new short[this.field1900];
      }

      if(var6) {
         this.field1924 = new byte[this.field1900];
      }

      if(this.field1930 > 0) {
         this.field1913 = new int[this.field1930];
         this.field1914 = new int[this.field1930];
         this.field1915 = new int[this.field1930];
      }

      this.field1896 = 0;
      this.field1900 = 0;
      this.field1930 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1900; ++var9) {
               this.indices1[this.field1900] = this.field1896 + var8.indices1[var9];
               this.indices2[this.field1900] = this.field1896 + var8.indices2[var9];
               this.indices3[this.field1900] = this.field1896 + var8.indices3[var9];
               this.field1934[this.field1900] = var8.field1934[var9];
               this.field1943[this.field1900] = var8.field1943[var9];
               this.field1922[this.field1900] = var8.field1922[var9];
               if(var3) {
                  if(var8.field1907 != null) {
                     this.field1907[this.field1900] = var8.field1907[var9];
                  } else {
                     this.field1907[this.field1900] = var8.field1911;
                  }
               }

               if(var4 && var8.field1908 != null) {
                  this.field1908[this.field1900] = var8.field1908[var9];
               }

               if(var5) {
                  if(var8.field1910 != null) {
                     this.field1910[this.field1900] = var8.field1910[var9];
                  } else {
                     this.field1910[this.field1900] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1924 != null && var8.field1924[var9] != -1) {
                     this.field1924[this.field1900] = (byte)(this.field1930 + var8.field1924[var9]);
                  } else {
                     this.field1924[this.field1900] = -1;
                  }
               }

               ++this.field1900;
            }

            for(var9 = 0; var9 < var8.field1930; ++var9) {
               this.field1913[this.field1930] = this.field1896 + var8.field1913[var9];
               this.field1914[this.field1930] = this.field1896 + var8.field1914[var9];
               this.field1915[this.field1930] = this.field1896 + var8.field1915[var9];
               ++this.field1930;
            }

            for(var9 = 0; var9 < var8.field1896; ++var9) {
               this.verticesX[this.field1896] = var8.verticesX[var9];
               this.verticesY[this.field1896] = var8.verticesY[var9];
               this.verticesZ[this.field1896] = var8.verticesZ[var9];
               ++this.field1896;
            }
         }
      }

   }

   @ObfuscatedName("v")
   public void method2509() {
      if(this.field1919 != 1) {
         this.field1919 = 1;
         super.modelHeight = 0;
         this.field1920 = 0;
         this.XYZMag = 0;

         for(int var1 = 0; var1 < this.field1896; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1920) {
               this.field1920 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.XYZMag) {
               this.XYZMag = var5;
            }
         }

         this.XYZMag = (int)(Math.sqrt((double)this.XYZMag) + 0.99D);
         this.field1923 = (int)(Math.sqrt((double)(this.XYZMag * this.XYZMag + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1918 = this.field1923 + (int)(Math.sqrt((double)(this.XYZMag * this.XYZMag + this.field1920 * this.field1920)) + 0.99D);
      }
   }

   @ObfuscatedName("ax")
   final void method2563(int var1) {
      int var2 = Graphics3D.centerX;
      int var3 = Graphics3D.centerY;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1901[var5];
      int var9 = field1901[var6];
      int var10 = field1901[var7];
      if(this.field1908 == null) {
         Graphics3D.rasterAlpha = 0;
      } else {
         Graphics3D.rasterAlpha = this.field1908[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1947[var4] = field1933[var5];
         field1948[var4] = field1949[var5];
         xViewportBuffer[var4++] = this.field1934[var1];
      } else {
         var11 = yViewportBuffer[var5];
         var12 = field1942[var5];
         var13 = this.field1934[var1];
         if(var10 >= 50) {
            var14 = field1959[var10 - var8] * (50 - var8);
            field1947[var4] = var2 + Graphics3D.field1998 * (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) / 50;
            field1948[var4] = var3 + (var12 + ((field1942[var7] - var12) * var14 >> 16)) * Graphics3D.field1998 / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1922[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = field1959[var9 - var8] * (50 - var8);
            field1947[var4] = var2 + (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) * Graphics3D.field1998 / 50;
            field1948[var4] = var3 + (var12 + ((field1942[var6] - var12) * var14 >> 16)) * Graphics3D.field1998 / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1943[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1947[var4] = field1933[var6];
         field1948[var4] = field1949[var6];
         xViewportBuffer[var4++] = this.field1943[var1];
      } else {
         var11 = yViewportBuffer[var6];
         var12 = field1942[var6];
         var13 = this.field1943[var1];
         if(var8 >= 50) {
            var14 = field1959[var8 - var9] * (50 - var9);
            field1947[var4] = var2 + (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) * Graphics3D.field1998 / 50;
            field1948[var4] = var3 + (var12 + ((field1942[var5] - var12) * var14 >> 16)) * Graphics3D.field1998 / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1934[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = field1959[var10 - var9] * (50 - var9);
            field1947[var4] = var2 + Graphics3D.field1998 * (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) / 50;
            field1948[var4] = var3 + (var12 + ((field1942[var7] - var12) * var14 >> 16)) * Graphics3D.field1998 / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1922[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1947[var4] = field1933[var7];
         field1948[var4] = field1949[var7];
         xViewportBuffer[var4++] = this.field1922[var1];
      } else {
         var11 = yViewportBuffer[var7];
         var12 = field1942[var7];
         var13 = this.field1922[var1];
         if(var9 >= 50) {
            var14 = field1959[var9 - var10] * (50 - var10);
            field1947[var4] = var2 + Graphics3D.field1998 * (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) / 50;
            field1948[var4] = var3 + Graphics3D.field1998 * (var12 + ((field1942[var6] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1943[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = field1959[var8 - var10] * (50 - var10);
            field1947[var4] = var2 + Graphics3D.field1998 * (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) / 50;
            field1948[var4] = var3 + (var12 + ((field1942[var5] - var12) * var14 >> 16)) * Graphics3D.field1998 / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1934[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1947[0];
      var12 = field1947[1];
      var13 = field1947[2];
      var14 = field1948[0];
      int var15 = field1948[1];
      int var16 = field1948[2];
      Graphics3D.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX) {
            Graphics3D.rasterClipEnable = true;
         }

         if(this.field1910 != null && this.field1910[var1] != -1) {
            if(this.field1924 != null && this.field1924[var1] != -1) {
               var20 = this.field1924[var1] & 255;
               var17 = this.field1913[var20];
               var18 = this.field1914[var20];
               var19 = this.field1915[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1922[var1] == -1) {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1934[var1], this.field1934[var1], this.field1934[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1942[var17], field1942[var18], field1942[var19], field1901[var17], field1901[var18], field1901[var19], this.field1910[var1]);
            } else {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1942[var17], field1942[var18], field1942[var19], field1901[var17], field1901[var18], field1901[var19], this.field1910[var1]);
            }
         } else if(this.field1922[var1] == -1) {
            Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, field1958[this.field1934[var1]]);
         } else {
            Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX || field1947[3] < 0 || field1947[3] > Graphics3D.rasterClipX) {
            Graphics3D.rasterClipEnable = true;
         }

         if(this.field1910 != null && this.field1910[var1] != -1) {
            if(this.field1924 != null && this.field1924[var1] != -1) {
               var20 = this.field1924[var1] & 255;
               var17 = this.field1913[var20];
               var18 = this.field1914[var20];
               var19 = this.field1915[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1910[var1];
            if(this.field1922[var1] == -1) {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1934[var1], this.field1934[var1], this.field1934[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1942[var17], field1942[var18], field1942[var19], field1901[var17], field1901[var18], field1901[var19], var21);
               Graphics3D.rasterTextureAffine(var14, var16, field1948[3], var11, var13, field1947[3], this.field1934[var1], this.field1934[var1], this.field1934[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1942[var17], field1942[var18], field1942[var19], field1901[var17], field1901[var18], field1901[var19], var21);
            } else {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1942[var17], field1942[var18], field1942[var19], field1901[var17], field1901[var18], field1901[var19], var21);
               Graphics3D.rasterTextureAffine(var14, var16, field1948[3], var11, var13, field1947[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1942[var17], field1942[var18], field1942[var19], field1901[var17], field1901[var18], field1901[var19], var21);
            }
         } else if(this.field1922[var1] == -1) {
            var17 = field1958[this.field1934[var1]];
            Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            Graphics3D.rasterFlat(var14, var16, field1948[3], var11, var13, field1947[3], var17);
         } else {
            Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
            Graphics3D.rasterGouraud(var14, var16, field1948[3], var11, var13, field1947[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3]);
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Len;I)V"
   )
   public void method2518(Frames var1, int var2) {
      if(this.field1916 != null) {
         if(var2 != -1) {
            Frame var3 = var1.skeletons[var2];
            FrameMap var4 = var3.skin;
            field1950 = 0;
            field1951 = 0;
            field1917 = 0;

            for(int var5 = 0; var5 < var3.field1866; ++var5) {
               int var6 = var3.field1862[var5];
               this.method2519(var4.types[var6], var4.list[var6], var3.translator_x[var5], var3.translator_y[var5], var3.translator_z[var5]);
            }

            this.method2550();
         }
      }
   }

   @ObfuscatedName("r")
   void method2550() {
      this.field1919 = 0;
      this.field1906 = -1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ZLev;[B)Lev;"
   )
   Model method2536(boolean var1, Model var2, byte[] var3) {
      var2.field1896 = this.field1896;
      var2.field1900 = this.field1900;
      var2.field1930 = this.field1930;
      if(var2.verticesX == null || var2.verticesX.length < this.field1896) {
         var2.verticesX = new int[this.field1896 + 100];
         var2.verticesY = new int[this.field1896 + 100];
         var2.verticesZ = new int[this.field1896 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1896; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if(var1) {
         var2.field1908 = this.field1908;
      } else {
         var2.field1908 = var3;
         if(this.field1908 == null) {
            for(var4 = 0; var4 < this.field1900; ++var4) {
               var2.field1908[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1900; ++var4) {
               var2.field1908[var4] = this.field1908[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1934 = this.field1934;
      var2.field1943 = this.field1943;
      var2.field1922 = this.field1922;
      var2.field1907 = this.field1907;
      var2.field1924 = this.field1924;
      var2.field1910 = this.field1910;
      var2.field1911 = this.field1911;
      var2.field1913 = this.field1913;
      var2.field1914 = this.field1914;
      var2.field1915 = this.field1915;
      var2.field1916 = this.field1916;
      var2.field1909 = this.field1909;
      var2.field1902 = this.field1902;
      var2.method2550();
      return var2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Z)Lev;"
   )
   public Model method2505(boolean var1) {
      if(!var1 && field1893.length < this.field1900) {
         field1893 = new byte[this.field1900 + 100];
      }

      return this.method2536(var1, field1955, field1893);
   }

   @ObfuscatedName("f")
   void method2508(int var1) {
      if(this.field1906 == -1) {
         int var2 = 0;
         int var3 = 0;
         int var4 = 0;
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         int var8 = field1957[var1];
         int var9 = field1956[var1];

         for(int var10 = 0; var10 < this.field1896; ++var10) {
            int var11 = Graphics3D.method2623(this.verticesX[var10], this.verticesZ[var10], var8, var9);
            int var12 = this.verticesY[var10];
            int var13 = Graphics3D.method2618(this.verticesX[var10], this.verticesZ[var10], var8, var9);
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

         this.field1925 = (var5 + var2) / 2;
         this.field1953 = (var6 + var3) / 2;
         this.field1926 = (var7 + var4) / 2;
         this.field1906 = (var5 - var2 + 1) / 2;
         this.field1928 = (var6 - var3 + 1) / 2;
         this.field1929 = (var7 - var4 + 1) / 2;
         if(this.field1906 < 32) {
            this.field1906 = 32;
         }

         if(this.field1929 < 32) {
            this.field1929 = 32;
         }

         if(this.field1902) {
            this.field1906 += 8;
            this.field1929 += 8;
         }

      }
   }

   @ObfuscatedName("t")
   void method2537() {
      if(this.field1919 != 2) {
         this.field1919 = 2;
         this.XYZMag = 0;

         for(int var1 = 0; var1 < this.field1896; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.XYZMag) {
               this.XYZMag = var5;
            }
         }

         this.XYZMag = (int)(Math.sqrt((double)this.XYZMag) + 0.99D);
         this.field1923 = this.XYZMag;
         this.field1918 = this.XYZMag + this.XYZMag;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Z)Lev;"
   )
   public Model method2527(boolean var1) {
      if(!var1 && field1895.length < this.field1900) {
         field1895 = new byte[this.field1900 + 100];
      }

      return this.method2536(var1, field1894, field1895);
   }

   @ObfuscatedName("k")
   public void method2531(int var1) {
      int var2 = field1956[var1];
      int var3 = field1957[var1];

      for(int var4 = 0; var4 < this.field1896; ++var4) {
         int var5 = var3 * this.verticesY[var4] - var2 * this.verticesZ[var4] >> 16;
         this.verticesZ[var4] = var2 * this.verticesY[var4] + var3 * this.verticesZ[var4] >> 16;
         this.verticesY[var4] = var5;
      }

      this.method2550();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([[IIIIZI)Lev;"
   )
   public Model method2504(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2509();
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
               var11.field1896 = this.field1896;
               var11.field1900 = this.field1900;
               var11.field1930 = this.field1930;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1934 = this.field1934;
               var11.field1943 = this.field1943;
               var11.field1922 = this.field1922;
               var11.field1907 = this.field1907;
               var11.field1908 = this.field1908;
               var11.field1924 = this.field1924;
               var11.field1910 = this.field1910;
               var11.field1911 = this.field1911;
               var11.field1913 = this.field1913;
               var11.field1914 = this.field1914;
               var11.field1915 = this.field1915;
               var11.field1916 = this.field1916;
               var11.field1909 = this.field1909;
               var11.field1902 = this.field1902;
               var11.verticesY = new int[var11.field1896];
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
               for(var12 = 0; var12 < var11.field1896; ++var12) {
                  var13 = var2 + this.verticesX[var12];
                  var14 = var4 + this.verticesZ[var12];
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17 + 1][var18 + 1] * var15 + var1[var17][var18 + 1] * (128 - var15) >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.verticesY[var12] = var21 + this.verticesY[var12] - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1896; ++var12) {
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

            var11.method2550();
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("w")
   public void method2541() {
      for(int var1 = 0; var1 < this.field1896; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.method2550();
   }

   @ObfuscatedName("cu")
   @Export("draw")
   void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1940[0] = -1;
      if(this.field1919 != 1) {
         this.method2509();
      }

      this.method2508(var1);
      int var10 = var5 * var8 - var4 * var6 >> 16;
      int var11 = var2 * var7 + var3 * var10 >> 16;
      int var12 = var3 * this.XYZMag >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var5 * var6 >> 16;
         int var15 = (var14 - this.XYZMag) * Graphics3D.field1998;
         if(var15 / var13 < Graphics3D.field1987) {
            int var16 = (var14 + this.XYZMag) * Graphics3D.field1998;
            if(var16 / var13 > Graphics3D.field1995) {
               int var17 = var3 * var7 - var10 * var2 >> 16;
               int var18 = var2 * this.XYZMag >> 16;
               int var19 = (var17 + var18) * Graphics3D.field1998;
               if(var19 / var13 > Graphics3D.field1997) {
                  int var20 = (var3 * super.modelHeight >> 16) + var18;
                  int var21 = (var17 - var20) * Graphics3D.field1998;
                  if(var21 / var13 < Graphics3D.field1988) {
                     int var22 = var12 + (var2 * super.modelHeight >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1930 > 0;
                     int var26 = class134.field1967;
                     int var28 = class22.method161();
                     boolean var29 = class134.field1973;
                     if(class7.field228 && var9 > 0) {
                        class96.method1799(this, var6, var7, var8);
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
                     if(class7.field225 && var9 > 0) {
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
                        class7.field224.method3577(new class8(var39, var40, var41, var42, var36));
                     }

                     boolean var45 = false;
                     if(var9 > 0 && var29) {
                        boolean var46 = false;
                        if(field1938) {
                           var46 = ScriptState.method1057(this, var6, var7, var8);
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
                           if(this.field1902) {
                              class134.field1971[++class134.field1970 - 1] = var9;
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
                        var34 = field1956[var1];
                        var35 = field1957[var1];
                     }

                     for(var36 = 0; var36 < this.field1896; ++var36) {
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
                        field1936[var36] = var39 - var11;
                        if(var39 >= 50) {
                           field1933[var36] = var37 * Graphics3D.field1998 / var39 + var32;
                           field1949[var36] = var33 + var40 * Graphics3D.field1998 / var39;
                        } else {
                           field1933[var36] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           yViewportBuffer[var36] = var37;
                           field1942[var36] = var40;
                           field1901[var36] = var39;
                        }
                     }

                     try {
                        this.method2525(var23, var45, this.field1902, var9);
                     } catch (Exception var44) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("b")
   public void method2580() {
      for(int var1 = 0; var1 < this.field1896; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.method2550();
   }

   @ObfuscatedName("h")
   public void method2521(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1896; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = var2 * this.verticesY[var4] / 128;
         this.verticesZ[var4] = var3 * this.verticesZ[var4] / 128;
      }

      this.method2550();
   }

   @ObfuscatedName("u")
   public void method2516() {
      for(int var1 = 0; var1 < this.field1896; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.method2550();
   }

   @ObfuscatedName("p")
   void method2519(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1950 = 0;
         field1951 = 0;
         field1917 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var9 = var2[var8];
            if(var9 < this.field1916.length) {
               int[] var10 = this.field1916[var9];

               for(var11 = 0; var11 < var10.length; ++var11) {
                  var12 = var10[var11];
                  field1950 += this.verticesX[var12];
                  field1951 += this.verticesY[var12];
                  field1917 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1950 = var3 + field1950 / var7;
            field1951 = var4 + field1951 / var7;
            field1917 = var5 + field1917 / var7;
         } else {
            field1950 = var3;
            field1951 = var4;
            field1917 = var5;
         }

      } else {
         int[] var18;
         int var19;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1916.length) {
                  var18 = this.field1916[var8];

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
               if(var8 < this.field1916.length) {
                  var18 = this.field1916[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= field1950;
                     this.verticesY[var11] -= field1951;
                     this.verticesZ[var11] -= field1917;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1956[var14];
                        var16 = field1957[var14];
                        var17 = var15 * this.verticesY[var11] + var16 * this.verticesX[var11] >> 16;
                        this.verticesY[var11] = var16 * this.verticesY[var11] - var15 * this.verticesX[var11] >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1956[var12];
                        var16 = field1957[var12];
                        var17 = var16 * this.verticesY[var11] - var15 * this.verticesZ[var11] >> 16;
                        this.verticesZ[var11] = var15 * this.verticesY[var11] + var16 * this.verticesZ[var11] >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1956[var13];
                        var16 = field1957[var13];
                        var17 = var15 * this.verticesZ[var11] + var16 * this.verticesX[var11] >> 16;
                        this.verticesZ[var11] = var16 * this.verticesZ[var11] - var15 * this.verticesX[var11] >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += field1950;
                     this.verticesY[var11] += field1951;
                     this.verticesZ[var11] += field1917;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1916.length) {
                  var18 = this.field1916[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= field1950;
                     this.verticesY[var11] -= field1951;
                     this.verticesZ[var11] -= field1917;
                     this.verticesX[var11] = var3 * this.verticesX[var11] / 128;
                     this.verticesY[var11] = var4 * this.verticesY[var11] / 128;
                     this.verticesZ[var11] = var5 * this.verticesZ[var11] / 128;
                     this.verticesX[var11] += field1950;
                     this.verticesY[var11] += field1951;
                     this.verticesZ[var11] += field1917;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1909 != null && this.field1908 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1909.length) {
                     var18 = this.field1909[var8];

                     for(var19 = 0; var19 < var18.length; ++var19) {
                        var11 = var18[var19];
                        var12 = (this.field1908[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1908[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Len;ILen;I[I)V"
   )
   public void method2514(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.skeletons[var2];
            Frame var7 = var3.skeletons[var4];
            FrameMap var8 = var6.skin;
            field1950 = 0;
            field1951 = 0;
            field1917 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1866; ++var11) {
               for(var12 = var6.field1862[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.types[var12] == 0) {
                  this.method2519(var8.types[var12], var8.list[var12], var6.translator_x[var11], var6.translator_y[var11], var6.translator_z[var11]);
               }
            }

            field1950 = 0;
            field1951 = 0;
            field1917 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1866; ++var11) {
               for(var12 = var7.field1862[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.types[var12] == 0) {
                  this.method2519(var8.types[var12], var8.list[var12], var7.translator_x[var11], var7.translator_y[var11], var7.translator_z[var11]);
               }
            }

            this.method2550();
         } else {
            this.method2518(var1, var2);
         }
      }
   }

   @ObfuscatedName("am")
   final void method2525(boolean var1, boolean var2, boolean var3, int var4) {
      if(this.field1918 < 1600) {
         int var5;
         for(var5 = 0; var5 < this.field1918; ++var5) {
            field1940[var5] = 0;
         }

         var5 = var3?20:5;
         if(class7.field230 && var2) {
            class169.method3165(this, var5);
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
         for(var6 = 0; var6 < this.field1900; ++var6) {
            if(this.field1922[var6] != -2) {
               var7 = this.indices1[var6];
               var26 = this.indices2[var6];
               var9 = this.indices3[var6];
               var10 = field1933[var7];
               var11 = field1933[var26];
               var12 = field1933[var9];
               int var13;
               if(!var1 || var10 != -5000 && var11 != -5000 && var12 != -5000) {
                  if(var2 && class29.method237(field1949[var7], field1949[var26], field1949[var9], var10, var11, var12, var5)) {
                     class134.field1971[++class134.field1970 - 1] = var4;
                     var2 = false;
                  }

                  if((var10 - var11) * (field1949[var9] - field1949[var26]) - (var12 - var11) * (field1949[var7] - field1949[var26]) > 0) {
                     field1932[var6] = false;
                     if(var10 >= 0 && var11 >= 0 && var12 >= 0 && var10 <= Graphics3D.rasterClipX && var11 <= Graphics3D.rasterClipX && var12 <= Graphics3D.rasterClipX) {
                        field1931[var6] = false;
                     } else {
                        field1931[var6] = true;
                     }

                     var13 = (field1936[var7] + field1936[var26] + field1936[var9]) / 3 + this.field1923;
                     field1941[var13][field1940[var13]++] = var6;
                  }
               } else {
                  var13 = yViewportBuffer[var7];
                  var14 = yViewportBuffer[var26];
                  var15 = yViewportBuffer[var9];
                  int var16 = field1942[var7];
                  var17 = field1942[var26];
                  int var18 = field1942[var9];
                  int var19 = field1901[var7];
                  int var20 = field1901[var26];
                  int var21 = field1901[var9];
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
                     field1932[var6] = true;
                     int var25 = (field1936[var7] + field1936[var26] + field1936[var9]) / 3 + this.field1923;
                     field1941[var25][field1940[var25]++] = var6;
                  }
               }
            }
         }

         int[] var8;
         if(this.field1907 == null) {
            for(var6 = this.field1918 - 1; var6 >= 0; --var6) {
               var7 = field1940[var6];
               if(var7 > 0) {
                  var8 = field1941[var6];

                  for(var9 = 0; var9 < var7; ++var9) {
                     this.method2526(var8[var9]);
                  }
               }
            }

         } else {
            for(var6 = 0; var6 < 12; ++var6) {
               field1905[var6] = 0;
               field1946[var6] = 0;
            }

            for(var6 = this.field1918 - 1; var6 >= 0; --var6) {
               var7 = field1940[var6];
               if(var7 > 0) {
                  var8 = field1941[var6];

                  for(var9 = 0; var9 < var7; ++var9) {
                     var10 = var8[var9];
                     byte var30 = this.field1907[var10];
                     var12 = field1905[var30]++;
                     field1937[var30][var12] = var10;
                     if(var30 < 10) {
                        field1946[var30] += var6;
                     } else if(var30 == 10) {
                        field1904[var12] = var6;
                     } else {
                        field1945[var12] = var6;
                     }
                  }
               }
            }

            var6 = 0;
            if(field1905[1] > 0 || field1905[2] > 0) {
               var6 = (field1946[1] + field1946[2]) / (field1905[1] + field1905[2]);
            }

            var7 = 0;
            if(field1905[3] > 0 || field1905[4] > 0) {
               var7 = (field1946[3] + field1946[4]) / (field1905[3] + field1905[4]);
            }

            var26 = 0;
            if(field1905[6] > 0 || field1905[8] > 0) {
               var26 = (field1946[8] + field1946[6]) / (field1905[8] + field1905[6]);
            }

            var10 = 0;
            var11 = field1905[10];
            int[] var27 = field1937[10];
            int[] var28 = field1904;
            if(var10 == var11) {
               var10 = 0;
               var11 = field1905[11];
               var27 = field1937[11];
               var28 = field1945;
            }

            if(var10 < var11) {
               var9 = var28[var10];
            } else {
               var9 = -1000;
            }

            for(var14 = 0; var14 < 10; ++var14) {
               while(var14 == 0 && var9 > var6) {
                  this.method2526(var27[var10++]);
                  if(var10 == var11 && var27 != field1937[11]) {
                     var10 = 0;
                     var11 = field1905[11];
                     var27 = field1937[11];
                     var28 = field1945;
                  }

                  if(var10 < var11) {
                     var9 = var28[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 3 && var9 > var7) {
                  this.method2526(var27[var10++]);
                  if(var10 == var11 && var27 != field1937[11]) {
                     var10 = 0;
                     var11 = field1905[11];
                     var27 = field1937[11];
                     var28 = field1945;
                  }

                  if(var10 < var11) {
                     var9 = var28[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 5 && var9 > var26) {
                  this.method2526(var27[var10++]);
                  if(var10 == var11 && var27 != field1937[11]) {
                     var10 = 0;
                     var11 = field1905[11];
                     var27 = field1937[11];
                     var28 = field1945;
                  }

                  if(var10 < var11) {
                     var9 = var28[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               var15 = field1905[var14];
               int[] var29 = field1937[var14];

               for(var17 = 0; var17 < var15; ++var17) {
                  this.method2526(var29[var17]);
               }
            }

            while(var9 != -1000) {
               this.method2526(var27[var10++]);
               if(var10 == var11 && var27 != field1937[11]) {
                  var10 = 0;
                  var27 = field1937[11];
                  var11 = field1905[11];
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

   @ObfuscatedName("ac")
   final void method2526(int var1) {
      if(field1932[var1]) {
         this.method2563(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         Graphics3D.rasterClipEnable = field1931[var1];
         if(this.field1908 == null) {
            Graphics3D.rasterAlpha = 0;
         } else {
            Graphics3D.rasterAlpha = this.field1908[var1] & 255;
         }

         if(this.field1910 != null && this.field1910[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1924 != null && this.field1924[var1] != -1) {
               int var8 = this.field1924[var1] & 255;
               var5 = this.field1913[var8];
               var6 = this.field1914[var8];
               var7 = this.field1915[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1922[var1] == -1) {
               Graphics3D.rasterTextureAffine(field1949[var2], field1949[var3], field1949[var4], field1933[var2], field1933[var3], field1933[var4], this.field1934[var1], this.field1934[var1], this.field1934[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1942[var5], field1942[var6], field1942[var7], field1901[var5], field1901[var6], field1901[var7], this.field1910[var1]);
            } else {
               Graphics3D.rasterTextureAffine(field1949[var2], field1949[var3], field1949[var4], field1933[var2], field1933[var3], field1933[var4], this.field1934[var1], this.field1943[var1], this.field1922[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1942[var5], field1942[var6], field1942[var7], field1901[var5], field1901[var6], field1901[var7], this.field1910[var1]);
            }
         } else if(this.field1922[var1] == -1) {
            Graphics3D.rasterFlat(field1949[var2], field1949[var3], field1949[var4], field1933[var2], field1933[var3], field1933[var4], field1958[this.field1934[var1]]);
         } else {
            Graphics3D.rasterGouraud(field1949[var2], field1949[var3], field1949[var4], field1933[var2], field1933[var3], field1933[var4], this.field1934[var1], this.field1943[var1], this.field1922[var1]);
         }

      }
   }

   @ObfuscatedName("c")
   public void method2520(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1896; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.method2550();
   }

   @ObfuscatedName("z")
   public final void method2522(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1940[0] = -1;
      if(this.field1919 != 2 && this.field1919 != 1) {
         this.method2537();
      }

      int var8 = Graphics3D.centerX;
      int var9 = Graphics3D.centerY;
      int var10 = field1956[var1];
      int var11 = field1957[var1];
      int var12 = field1956[var2];
      int var13 = field1957[var2];
      int var14 = field1956[var3];
      int var15 = field1957[var3];
      int var16 = field1956[var4];
      int var17 = field1957[var4];
      int var18 = var16 * var6 + var17 * var7 >> 16;

      for(int var19 = 0; var19 < this.field1896; ++var19) {
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
         field1936[var19] = var22 - var18;
         field1933[var19] = var20 * Graphics3D.field1998 / var22 + var8;
         field1949[var19] = var23 * Graphics3D.field1998 / var22 + var9;
         if(this.field1930 > 0) {
            yViewportBuffer[var19] = var20;
            field1942[var19] = var23;
            field1901[var19] = var22;
         }
      }

      try {
         this.method2525(false, false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("j")
   public final void method2523(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1940[0] = -1;
      if(this.field1919 != 2 && this.field1919 != 1) {
         this.method2537();
      }

      int var9 = Graphics3D.centerX;
      int var10 = Graphics3D.centerY;
      int var11 = field1956[var1];
      int var12 = field1957[var1];
      int var13 = field1956[var2];
      int var14 = field1957[var2];
      int var15 = field1956[var3];
      int var16 = field1957[var3];
      int var17 = field1956[var4];
      int var18 = field1957[var4];
      int var19 = var17 * var6 + var18 * var7 >> 16;

      for(int var20 = 0; var20 < this.field1896; ++var20) {
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
         field1936[var20] = var23 - var19;
         field1933[var20] = var9 + var21 * Graphics3D.field1998 / var8;
         field1949[var20] = var10 + var24 * Graphics3D.field1998 / var8;
         if(this.field1930 > 0) {
            yViewportBuffer[var20] = var21;
            field1942[var20] = var24;
            field1901[var20] = var23;
         }
      }

      try {
         this.method2525(false, false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("i")
   public int method2511() {
      this.method2509();
      return this.XYZMag;
   }
}
