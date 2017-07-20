import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("ac")
   static boolean[] field1918;
   @ObfuscatedName("au")
   static int[] field1926;
   @ObfuscatedName("ba")
   static int[] field1942;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Leo;"
   )
   static Model field1933;
   @ObfuscatedName("u")
   static byte[] field1904;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Leo;"
   )
   static Model field1935;
   @ObfuscatedName("bo")
   static int field1914;
   @ObfuscatedName("o")
   static byte[] field1941;
   @ObfuscatedName("bs")
   static int[] field1910;
   @ObfuscatedName("bi")
   static int field1919;
   @ObfuscatedName("ad")
   static boolean[] field1932;
   @ObfuscatedName("bn")
   static int field1938;
   @ObfuscatedName("aq")
   static int[] field1924;
   @ObfuscatedName("bh")
   static int[] field1915;
   @ObfuscatedName("ai")
   @Export("yViewportBuffer")
   static int[] yViewportBuffer;
   @ObfuscatedName("ae")
   public static int[] field1931;
   @ObfuscatedName("aa")
   static int[] field1923;
   @ObfuscatedName("ay")
   static int[] field1928;
   @ObfuscatedName("bg")
   static int[] field1888;
   @ObfuscatedName("ah")
   public static int[] field1920;
   @ObfuscatedName("bw")
   static int[] field1945;
   @ObfuscatedName("bu")
   static int[] field1878;
   @ObfuscatedName("az")
   static int[][] field1927;
   @ObfuscatedName("bl")
   @Export("xViewportBuffer")
   static int[] xViewportBuffer;
   @ObfuscatedName("ax")
   static int[] field1916;
   @ObfuscatedName("bc")
   static int[] field1934;
   @ObfuscatedName("ao")
   static int[][] field1929;
   @ObfuscatedName("bz")
   static int[] field1930;
   @ObfuscatedName("bd")
   static int[] field1940;
   @ObfuscatedName("bk")
   public static boolean field1939;
   @ObfuscatedName("av")
   int field1908;
   @ObfuscatedName("ar")
   public int field1913;
   @ObfuscatedName("aj")
   int field1905;
   @ObfuscatedName("b")
   int[][] field1902;
   @ObfuscatedName("g")
   int field1882;
   @ObfuscatedName("ab")
   public int field1896;
   @ObfuscatedName("k")
   @Export("indices1")
   public int[] indices1;
   @ObfuscatedName("ag")
   @Export("XYZMag")
   int XYZMag;
   @ObfuscatedName("m")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("x")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("p")
   public int field1886;
   @ObfuscatedName("r")
   @Export("indices2")
   public int[] indices2;
   @ObfuscatedName("w")
   @Export("indices3")
   public int[] indices3;
   @ObfuscatedName("s")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("d")
   int[][] field1903;
   @ObfuscatedName("q")
   byte field1897;
   @ObfuscatedName("am")
   int field1906;
   @ObfuscatedName("f")
   int field1898;
   @ObfuscatedName("e")
   byte[] field1894;
   @ObfuscatedName("af")
   public int field1911;
   @ObfuscatedName("v")
   int[] field1890;
   @ObfuscatedName("t")
   public int[] field1892;
   @ObfuscatedName("an")
   public int field1917;
   @ObfuscatedName("ap")
   public boolean field1879;
   @ObfuscatedName("h")
   int[] field1891;
   @ObfuscatedName("l")
   short[] field1921;
   @ObfuscatedName("a")
   byte[] field1893;
   @ObfuscatedName("ak")
   public int field1912;
   @ObfuscatedName("al")
   int field1909;
   @ObfuscatedName("at")
   public int field1901;
   @ObfuscatedName("y")
   byte[] field1895;
   @ObfuscatedName("j")
   int[] field1899;
   @ObfuscatedName("n")
   int[] field1900;
   @ObfuscatedName("z")
   int[] field1944;

   static {
      field1935 = new Model();
      field1941 = new byte[1];
      field1933 = new Model();
      field1904 = new byte[1];
      field1932 = new boolean[4700];
      field1918 = new boolean[4700];
      field1931 = new int[4700];
      field1920 = new int[4700];
      field1916 = new int[4700];
      yViewportBuffer = new int[4700];
      field1923 = new int[4700];
      field1924 = new int[4700];
      field1926 = new int[1600];
      field1927 = new int[1600][512];
      field1928 = new int[12];
      field1929 = new int[12][2000];
      field1930 = new int[2000];
      field1940 = new int[2000];
      field1878 = new int[12];
      field1915 = new int[10];
      field1888 = new int[10];
      xViewportBuffer = new int[10];
      field1939 = true;
      field1942 = Graphics3D.SINE;
      field1910 = Graphics3D.COSINE;
      field1934 = Graphics3D.colorPalette;
      field1945 = Graphics3D.field1996;
   }

   Model() {
      this.field1882 = 0;
      this.field1886 = 0;
      this.field1897 = 0;
      this.field1898 = 0;
      this.field1879 = false;
      this.field1913 = -1;
      this.field1917 = -1;
      this.field1901 = -1;
   }

   @ObfuscatedSignature(
      signature = "([Leo;I)V"
   )
   public Model(Model[] var1, int var2) {
      this.field1882 = 0;
      this.field1886 = 0;
      this.field1897 = 0;
      this.field1898 = 0;
      this.field1879 = false;
      this.field1913 = -1;
      this.field1917 = -1;
      this.field1901 = -1;
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1882 = 0;
      this.field1886 = 0;
      this.field1898 = 0;
      this.field1897 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1882 += var8.field1882;
            this.field1886 += var8.field1886;
            this.field1898 += var8.field1898;
            if(var8.field1893 != null) {
               var3 = true;
            } else {
               if(this.field1897 == -1) {
                  this.field1897 = var8.field1897;
               }

               if(this.field1897 != var8.field1897) {
                  var3 = true;
               }
            }

            var4 |= var8.field1894 != null;
            var5 |= var8.field1921 != null;
            var6 |= var8.field1895 != null;
         }
      }

      this.verticesX = new int[this.field1882];
      this.verticesY = new int[this.field1882];
      this.verticesZ = new int[this.field1882];
      this.indices1 = new int[this.field1886];
      this.indices2 = new int[this.field1886];
      this.indices3 = new int[this.field1886];
      this.field1890 = new int[this.field1886];
      this.field1891 = new int[this.field1886];
      this.field1892 = new int[this.field1886];
      if(var3) {
         this.field1893 = new byte[this.field1886];
      }

      if(var4) {
         this.field1894 = new byte[this.field1886];
      }

      if(var5) {
         this.field1921 = new short[this.field1886];
      }

      if(var6) {
         this.field1895 = new byte[this.field1886];
      }

      if(this.field1898 > 0) {
         this.field1899 = new int[this.field1898];
         this.field1900 = new int[this.field1898];
         this.field1944 = new int[this.field1898];
      }

      this.field1882 = 0;
      this.field1886 = 0;
      this.field1898 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1886; ++var9) {
               this.indices1[this.field1886] = this.field1882 + var8.indices1[var9];
               this.indices2[this.field1886] = this.field1882 + var8.indices2[var9];
               this.indices3[this.field1886] = this.field1882 + var8.indices3[var9];
               this.field1890[this.field1886] = var8.field1890[var9];
               this.field1891[this.field1886] = var8.field1891[var9];
               this.field1892[this.field1886] = var8.field1892[var9];
               if(var3) {
                  if(var8.field1893 != null) {
                     this.field1893[this.field1886] = var8.field1893[var9];
                  } else {
                     this.field1893[this.field1886] = var8.field1897;
                  }
               }

               if(var4 && var8.field1894 != null) {
                  this.field1894[this.field1886] = var8.field1894[var9];
               }

               if(var5) {
                  if(var8.field1921 != null) {
                     this.field1921[this.field1886] = var8.field1921[var9];
                  } else {
                     this.field1921[this.field1886] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1895 != null && var8.field1895[var9] != -1) {
                     this.field1895[this.field1886] = (byte)(this.field1898 + var8.field1895[var9]);
                  } else {
                     this.field1895[this.field1886] = -1;
                  }
               }

               ++this.field1886;
            }

            for(var9 = 0; var9 < var8.field1898; ++var9) {
               this.field1899[this.field1898] = this.field1882 + var8.field1899[var9];
               this.field1900[this.field1898] = this.field1882 + var8.field1900[var9];
               this.field1944[this.field1898] = this.field1882 + var8.field1944[var9];
               ++this.field1898;
            }

            for(var9 = 0; var9 < var8.field1882; ++var9) {
               this.verticesX[this.field1882] = var8.verticesX[var9];
               this.verticesY[this.field1882] = var8.verticesY[var9];
               this.verticesZ[this.field1882] = var8.verticesZ[var9];
               ++this.field1882;
            }
         }
      }

   }

   @ObfuscatedName("s")
   public void method2433() {
      if(this.field1905 != 1) {
         this.field1905 = 1;
         super.modelHeight = 0;
         this.field1906 = 0;
         this.XYZMag = 0;

         for(int var1 = 0; var1 < this.field1882; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1906) {
               this.field1906 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.XYZMag) {
               this.XYZMag = var5;
            }
         }

         this.XYZMag = (int)(Math.sqrt((double)this.XYZMag) + 0.99D);
         this.field1909 = (int)(Math.sqrt((double)(this.XYZMag * this.XYZMag + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1908 = this.field1909 + (int)(Math.sqrt((double)(this.XYZMag * this.XYZMag + this.field1906 * this.field1906)) + 0.99D);
      }
   }

   @ObfuscatedName("ag")
   final void method2449(int var1) {
      int var2 = Graphics3D.centerX;
      int var3 = Graphics3D.centerY;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1924[var5];
      int var9 = field1924[var6];
      int var10 = field1924[var7];
      if(this.field1894 == null) {
         Graphics3D.rasterAlpha = 0;
      } else {
         Graphics3D.rasterAlpha = this.field1894[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1915[var4] = field1931[var5];
         field1888[var4] = field1920[var5];
         xViewportBuffer[var4++] = this.field1890[var1];
      } else {
         var11 = yViewportBuffer[var5];
         var12 = field1923[var5];
         var13 = this.field1890[var1];
         if(var10 >= 50) {
            var14 = field1945[var10 - var8] * (50 - var8);
            field1915[var4] = var2 + Graphics3D.field1983 * (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) / 50;
            field1888[var4] = var3 + Graphics3D.field1983 * (var12 + ((field1923[var7] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1892[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = field1945[var9 - var8] * (50 - var8);
            field1915[var4] = var2 + Graphics3D.field1983 * (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) / 50;
            field1888[var4] = var3 + Graphics3D.field1983 * (var12 + ((field1923[var6] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1891[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1915[var4] = field1931[var6];
         field1888[var4] = field1920[var6];
         xViewportBuffer[var4++] = this.field1891[var1];
      } else {
         var11 = yViewportBuffer[var6];
         var12 = field1923[var6];
         var13 = this.field1891[var1];
         if(var8 >= 50) {
            var14 = field1945[var8 - var9] * (50 - var9);
            field1915[var4] = var2 + Graphics3D.field1983 * (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) / 50;
            field1888[var4] = var3 + Graphics3D.field1983 * (var12 + ((field1923[var5] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1890[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = field1945[var10 - var9] * (50 - var9);
            field1915[var4] = var2 + Graphics3D.field1983 * (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) / 50;
            field1888[var4] = var3 + Graphics3D.field1983 * (var12 + ((field1923[var7] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1892[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1915[var4] = field1931[var7];
         field1888[var4] = field1920[var7];
         xViewportBuffer[var4++] = this.field1892[var1];
      } else {
         var11 = yViewportBuffer[var7];
         var12 = field1923[var7];
         var13 = this.field1892[var1];
         if(var9 >= 50) {
            var14 = field1945[var9 - var10] * (50 - var10);
            field1915[var4] = var2 + Graphics3D.field1983 * (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) / 50;
            field1888[var4] = var3 + Graphics3D.field1983 * (var12 + ((field1923[var6] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1891[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = field1945[var8 - var10] * (50 - var10);
            field1915[var4] = var2 + Graphics3D.field1983 * (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) / 50;
            field1888[var4] = var3 + Graphics3D.field1983 * (var12 + ((field1923[var5] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1890[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1915[0];
      var12 = field1915[1];
      var13 = field1915[2];
      var14 = field1888[0];
      int var15 = field1888[1];
      int var16 = field1888[2];
      Graphics3D.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX) {
            Graphics3D.rasterClipEnable = true;
         }

         if(this.field1921 != null && this.field1921[var1] != -1) {
            if(this.field1895 != null && this.field1895[var1] != -1) {
               var20 = this.field1895[var1] & 255;
               var17 = this.field1899[var20];
               var18 = this.field1900[var20];
               var19 = this.field1944[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1892[var1] == -1) {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1890[var1], this.field1890[var1], this.field1890[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1923[var17], field1923[var18], field1923[var19], field1924[var17], field1924[var18], field1924[var19], this.field1921[var1]);
            } else {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1923[var17], field1923[var18], field1923[var19], field1924[var17], field1924[var18], field1924[var19], this.field1921[var1]);
            }
         } else if(this.field1892[var1] == -1) {
            Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, field1934[this.field1890[var1]]);
         } else {
            Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX || field1915[3] < 0 || field1915[3] > Graphics3D.rasterClipX) {
            Graphics3D.rasterClipEnable = true;
         }

         if(this.field1921 != null && this.field1921[var1] != -1) {
            if(this.field1895 != null && this.field1895[var1] != -1) {
               var20 = this.field1895[var1] & 255;
               var17 = this.field1899[var20];
               var18 = this.field1900[var20];
               var19 = this.field1944[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1921[var1];
            if(this.field1892[var1] == -1) {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1890[var1], this.field1890[var1], this.field1890[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1923[var17], field1923[var18], field1923[var19], field1924[var17], field1924[var18], field1924[var19], var21);
               Graphics3D.rasterTextureAffine(var14, var16, field1888[3], var11, var13, field1915[3], this.field1890[var1], this.field1890[var1], this.field1890[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1923[var17], field1923[var18], field1923[var19], field1924[var17], field1924[var18], field1924[var19], var21);
            } else {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1923[var17], field1923[var18], field1923[var19], field1924[var17], field1924[var18], field1924[var19], var21);
               Graphics3D.rasterTextureAffine(var14, var16, field1888[3], var11, var13, field1915[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1923[var17], field1923[var18], field1923[var19], field1924[var17], field1924[var18], field1924[var19], var21);
            }
         } else if(this.field1892[var1] == -1) {
            var17 = field1934[this.field1890[var1]];
            Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            Graphics3D.rasterFlat(var14, var16, field1888[3], var11, var13, field1915[3], var17);
         } else {
            Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
            Graphics3D.rasterGouraud(var14, var16, field1888[3], var11, var13, field1915[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3]);
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lea;I)V"
   )
   public void method2437(Frames var1, int var2) {
      if(this.field1902 != null) {
         if(var2 != -1) {
            Frame var3 = var1.skeletons[var2];
            FrameMap var4 = var3.skin;
            field1914 = 0;
            field1919 = 0;
            field1938 = 0;

            for(int var5 = 0; var5 < var3.field1847; ++var5) {
               int var6 = var3.field1842[var5];
               this.method2438(var4.types[var6], var4.list[var6], var3.translator_x[var5], var3.translator_y[var5], var3.translator_z[var5]);
            }

            this.method2436();
         }
      }
   }

   @ObfuscatedName("k")
   void method2436() {
      this.field1905 = 0;
      this.field1913 = -1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ZLeo;[B)Leo;"
   )
   Model method2428(boolean var1, Model var2, byte[] var3) {
      var2.field1882 = this.field1882;
      var2.field1886 = this.field1886;
      var2.field1898 = this.field1898;
      if(var2.verticesX == null || var2.verticesX.length < this.field1882) {
         var2.verticesX = new int[this.field1882 + 100];
         var2.verticesY = new int[this.field1882 + 100];
         var2.verticesZ = new int[this.field1882 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1882; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if(var1) {
         var2.field1894 = this.field1894;
      } else {
         var2.field1894 = var3;
         if(this.field1894 == null) {
            for(var4 = 0; var4 < this.field1886; ++var4) {
               var2.field1894[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1886; ++var4) {
               var2.field1894[var4] = this.field1894[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1890 = this.field1890;
      var2.field1891 = this.field1891;
      var2.field1892 = this.field1892;
      var2.field1893 = this.field1893;
      var2.field1895 = this.field1895;
      var2.field1921 = this.field1921;
      var2.field1897 = this.field1897;
      var2.field1899 = this.field1899;
      var2.field1900 = this.field1900;
      var2.field1944 = this.field1944;
      var2.field1902 = this.field1902;
      var2.field1903 = this.field1903;
      var2.field1879 = this.field1879;
      var2.method2436();
      return var2;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Z)Leo;"
   )
   public Model method2429(boolean var1) {
      if(!var1 && field1941.length < this.field1886) {
         field1941 = new byte[this.field1886 + 100];
      }

      return this.method2428(var1, field1935, field1941);
   }

   @ObfuscatedName("m")
   void method2432(int var1) {
      if(this.field1913 == -1) {
         int var2 = 0;
         int var3 = 0;
         int var4 = 0;
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         int var8 = field1910[var1];
         int var9 = field1942[var1];

         for(int var10 = 0; var10 < this.field1882; ++var10) {
            int var11 = Graphics3D.method2571(this.verticesX[var10], this.verticesZ[var10], var8, var9);
            int var12 = this.verticesY[var10];
            int var13 = Graphics3D.method2542(this.verticesX[var10], this.verticesZ[var10], var8, var9);
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

         this.field1896 = (var5 + var2) / 2;
         this.field1911 = (var6 + var3) / 2;
         this.field1912 = (var7 + var4) / 2;
         this.field1913 = (var5 - var2 + 1) / 2;
         this.field1917 = (var6 - var3 + 1) / 2;
         this.field1901 = (var7 - var4 + 1) / 2;
         if(this.field1913 < 32) {
            this.field1913 = 32;
         }

         if(this.field1901 < 32) {
            this.field1901 = 32;
         }

         if(this.field1879) {
            this.field1913 += 8;
            this.field1901 += 8;
         }

      }
   }

   @ObfuscatedName("x")
   void method2434() {
      if(this.field1905 != 2) {
         this.field1905 = 2;
         this.XYZMag = 0;

         for(int var1 = 0; var1 < this.field1882; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var3 * var3 + var2 * var2 + var4 * var4;
            if(var5 > this.XYZMag) {
               this.XYZMag = var5;
            }
         }

         this.XYZMag = (int)(Math.sqrt((double)this.XYZMag) + 0.99D);
         this.field1909 = this.XYZMag;
         this.field1908 = this.XYZMag + this.XYZMag;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Z)Leo;"
   )
   public Model method2430(boolean var1) {
      if(!var1 && field1904.length < this.field1886) {
         field1904 = new byte[this.field1886 + 100];
      }

      return this.method2428(var1, field1933, field1904);
   }

   @ObfuscatedName("f")
   public void method2465(int var1) {
      int var2 = field1942[var1];
      int var3 = field1910[var1];

      for(int var4 = 0; var4 < this.field1882; ++var4) {
         int var5 = var3 * this.verticesY[var4] - var2 * this.verticesZ[var4] >> 16;
         this.verticesZ[var4] = var2 * this.verticesY[var4] + var3 * this.verticesZ[var4] >> 16;
         this.verticesY[var4] = var5;
      }

      this.method2436();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([[IIIIZI)Leo;"
   )
   public Model method2477(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2433();
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
               var11.field1882 = this.field1882;
               var11.field1886 = this.field1886;
               var11.field1898 = this.field1898;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1890 = this.field1890;
               var11.field1891 = this.field1891;
               var11.field1892 = this.field1892;
               var11.field1893 = this.field1893;
               var11.field1894 = this.field1894;
               var11.field1895 = this.field1895;
               var11.field1921 = this.field1921;
               var11.field1897 = this.field1897;
               var11.field1899 = this.field1899;
               var11.field1900 = this.field1900;
               var11.field1944 = this.field1944;
               var11.field1902 = this.field1902;
               var11.field1903 = this.field1903;
               var11.field1879 = this.field1879;
               var11.verticesY = new int[var11.field1882];
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
               for(var12 = 0; var12 < var11.field1882; ++var12) {
                  var13 = var2 + this.verticesX[var12];
                  var14 = var4 + this.verticesZ[var12];
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17 + 1][var18] * var15 + var1[var17][var18] * (128 - var15) >> 7;
                  var20 = var1[var17 + 1][var18 + 1] * var15 + var1[var17][var18 + 1] * (128 - var15) >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.verticesY[var12] = var21 + this.verticesY[var12] - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1882; ++var12) {
                  var13 = (-this.verticesY[var12] << 16) / super.modelHeight;
                  if(var13 < var6) {
                     var14 = var2 + this.verticesX[var12];
                     var15 = var4 + this.verticesZ[var12];
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var16 * var1[var18 + 1][var19] + var1[var18][var19] * (128 - var16) >> 7;
                     var21 = var16 * var1[var18 + 1][var19 + 1] + var1[var18][var19 + 1] * (128 - var16) >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.verticesY[var12] = (var22 - var3) * (var6 - var13) / var6 + this.verticesY[var12];
                  }
               }
            }

            var11.method2436();
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("q")
   public void method2472() {
      for(int var1 = 0; var1 < this.field1882; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.method2436();
   }

   @ObfuscatedName("cb")
   @Export("draw")
   void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1926[0] = -1;
      if(this.field1905 != 1) {
         this.method2433();
      }

      this.method2432(var1);
      int var10 = var5 * var8 - var4 * var6 >> 16;
      int var11 = var2 * var7 + var3 * var10 >> 16;
      int var12 = var3 * this.XYZMag >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var5 * var6 >> 16;
         int var15 = (var14 - this.XYZMag) * Graphics3D.field1983;
         if(var15 / var13 < Graphics3D.field1995) {
            int var16 = (var14 + this.XYZMag) * Graphics3D.field1983;
            if(var16 / var13 > Graphics3D.field1984) {
               int var17 = var3 * var7 - var10 * var2 >> 16;
               int var18 = var2 * this.XYZMag >> 16;
               int var19 = (var17 + var18) * Graphics3D.field1983;
               if(var19 / var13 > Graphics3D.field1990) {
                  int var20 = (var3 * super.modelHeight >> 16) + var18;
                  int var21 = (var17 - var20) * Graphics3D.field1983;
                  if(var21 / var13 < Graphics3D.field1991) {
                     int var22 = var12 + (var2 * super.modelHeight >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1898 > 0;
                     int var26 = class29.method243();
                     int var27 = WorldMapType3.method200();
                     boolean var28 = class261.method4610();
                     if(class7.field225 && var9 > 0) {
                        class87.method1653(this, var6, var7, var8);
                     }

                     int var30;
                     int var31;
                     int var32;
                     int var33;
                     int var34;
                     int var35;
                     int var36;
                     if(class7.field220 && var9 > 0) {
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
                        var35 = var26 - Graphics3D.centerX;
                        var36 = var27 - Graphics3D.centerY;
                        if(var35 > var30 && var35 < var31 && var36 > var32 && var36 < var33) {
                           var34 = -256;
                        }

                        class17.method115(var30 + Graphics3D.centerX, var32 + Graphics3D.centerY, var31 + Graphics3D.centerX, var33 + Graphics3D.centerY, var34);
                     }

                     boolean var41 = false;
                     if(var9 > 0 && var28) {
                        boolean var42 = false;
                        if(field1939) {
                           var42 = class112.method2029(this, var6, var7, var8);
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
                           if(this.field1879) {
                              PendingSpawn.method1462(var9);
                           } else {
                              var41 = true;
                           }
                        }
                     }

                     var30 = Graphics3D.centerX;
                     var31 = Graphics3D.centerY;
                     var32 = 0;
                     var33 = 0;
                     if(var1 != 0) {
                        var32 = field1942[var1];
                        var33 = field1910[var1];
                     }

                     for(var34 = 0; var34 < this.field1882; ++var34) {
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
                        field1916[var34] = var37 - var11;
                        if(var37 >= 50) {
                           field1931[var34] = var35 * Graphics3D.field1983 / var37 + var30;
                           field1920[var34] = var38 * Graphics3D.field1983 / var37 + var31;
                        } else {
                           field1931[var34] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           yViewportBuffer[var34] = var35;
                           field1923[var34] = var38;
                           field1924[var34] = var37;
                        }
                     }

                     try {
                        this.method2445(var23, var41, this.field1879, var9);
                     } catch (Exception var40) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("l")
   public void method2440() {
      for(int var1 = 0; var1 < this.field1882; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.method2436();
   }

   @ObfuscatedName("n")
   public void method2487(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1882; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = var2 * this.verticesY[var4] / 128;
         this.verticesZ[var4] = var3 * this.verticesZ[var4] / 128;
      }

      this.method2436();
   }

   @ObfuscatedName("t")
   public void method2439() {
      for(int var1 = 0; var1 < this.field1882; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.method2436();
   }

   @ObfuscatedName("h")
   void method2438(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1914 = 0;
         field1919 = 0;
         field1938 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var9 = var2[var8];
            if(var9 < this.field1902.length) {
               int[] var10 = this.field1902[var9];

               for(var11 = 0; var11 < var10.length; ++var11) {
                  var12 = var10[var11];
                  field1914 += this.verticesX[var12];
                  field1919 += this.verticesY[var12];
                  field1938 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1914 = var3 + field1914 / var7;
            field1919 = var4 + field1919 / var7;
            field1938 = var5 + field1938 / var7;
         } else {
            field1914 = var3;
            field1919 = var4;
            field1938 = var5;
         }

      } else {
         int[] var18;
         int var19;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1902.length) {
                  var18 = this.field1902[var8];

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
               if(var8 < this.field1902.length) {
                  var18 = this.field1902[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= field1914;
                     this.verticesY[var11] -= field1919;
                     this.verticesZ[var11] -= field1938;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1942[var14];
                        var16 = field1910[var14];
                        var17 = var15 * this.verticesY[var11] + var16 * this.verticesX[var11] >> 16;
                        this.verticesY[var11] = var16 * this.verticesY[var11] - var15 * this.verticesX[var11] >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1942[var12];
                        var16 = field1910[var12];
                        var17 = var16 * this.verticesY[var11] - var15 * this.verticesZ[var11] >> 16;
                        this.verticesZ[var11] = var15 * this.verticesY[var11] + var16 * this.verticesZ[var11] >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1942[var13];
                        var16 = field1910[var13];
                        var17 = var15 * this.verticesZ[var11] + var16 * this.verticesX[var11] >> 16;
                        this.verticesZ[var11] = var16 * this.verticesZ[var11] - var15 * this.verticesX[var11] >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += field1914;
                     this.verticesY[var11] += field1919;
                     this.verticesZ[var11] += field1938;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1902.length) {
                  var18 = this.field1902[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= field1914;
                     this.verticesY[var11] -= field1919;
                     this.verticesZ[var11] -= field1938;
                     this.verticesX[var11] = var3 * this.verticesX[var11] / 128;
                     this.verticesY[var11] = var4 * this.verticesY[var11] / 128;
                     this.verticesZ[var11] = var5 * this.verticesZ[var11] / 128;
                     this.verticesX[var11] += field1914;
                     this.verticesY[var11] += field1919;
                     this.verticesZ[var11] += field1938;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1903 != null && this.field1894 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1903.length) {
                     var18 = this.field1903[var8];

                     for(var19 = 0; var19 < var18.length; ++var19) {
                        var11 = var18[var19];
                        var12 = (this.field1894[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1894[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lea;ILea;I[I)V"
   )
   public void method2485(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.skeletons[var2];
            Frame var7 = var3.skeletons[var4];
            FrameMap var8 = var6.skin;
            field1914 = 0;
            field1919 = 0;
            field1938 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1847; ++var11) {
               for(var12 = var6.field1842[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.types[var12] == 0) {
                  this.method2438(var8.types[var12], var8.list[var12], var6.translator_x[var11], var6.translator_y[var11], var6.translator_z[var11]);
               }
            }

            field1914 = 0;
            field1919 = 0;
            field1938 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1847; ++var11) {
               for(var12 = var7.field1842[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.types[var12] == 0) {
                  this.method2438(var8.types[var12], var8.list[var12], var7.translator_x[var11], var7.translator_y[var11], var7.translator_z[var11]);
               }
            }

            this.method2436();
         } else {
            this.method2437(var1, var2);
         }
      }
   }

   @ObfuscatedName("aj")
   final void method2445(boolean var1, boolean var2, boolean var3, int var4) {
      if(this.field1908 < 1600) {
         int var5;
         for(var5 = 0; var5 < this.field1908; ++var5) {
            field1926[var5] = 0;
         }

         var5 = var3?20:5;
         if(class7.field221 && var2) {
            class47.method671(this, var5);
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
         for(var6 = 0; var6 < this.field1886; ++var6) {
            if(this.field1892[var6] != -2) {
               var7 = this.indices1[var6];
               var26 = this.indices2[var6];
               var9 = this.indices3[var6];
               var10 = field1931[var7];
               var11 = field1931[var26];
               var12 = field1931[var9];
               int var13;
               if(!var1 || var10 != -5000 && var11 != -5000 && var12 != -5000) {
                  if(var2 && class89.method1657(field1920[var7], field1920[var26], field1920[var9], var10, var11, var12, var5)) {
                     PendingSpawn.method1462(var4);
                     var2 = false;
                  }

                  if((var10 - var11) * (field1920[var9] - field1920[var26]) - (var12 - var11) * (field1920[var7] - field1920[var26]) > 0) {
                     field1918[var6] = false;
                     if(var10 >= 0 && var11 >= 0 && var12 >= 0 && var10 <= Graphics3D.rasterClipX && var11 <= Graphics3D.rasterClipX && var12 <= Graphics3D.rasterClipX) {
                        field1932[var6] = false;
                     } else {
                        field1932[var6] = true;
                     }

                     var13 = (field1916[var9] + field1916[var7] + field1916[var26]) / 3 + this.field1909;
                     field1927[var13][field1926[var13]++] = var6;
                  }
               } else {
                  var13 = yViewportBuffer[var7];
                  var14 = yViewportBuffer[var26];
                  var15 = yViewportBuffer[var9];
                  int var16 = field1923[var7];
                  var17 = field1923[var26];
                  int var18 = field1923[var9];
                  int var19 = field1924[var7];
                  int var20 = field1924[var26];
                  int var21 = field1924[var9];
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
                     field1918[var6] = true;
                     int var25 = (field1916[var9] + field1916[var7] + field1916[var26]) / 3 + this.field1909;
                     field1927[var25][field1926[var25]++] = var6;
                  }
               }
            }
         }

         int[] var8;
         if(this.field1893 == null) {
            for(var6 = this.field1908 - 1; var6 >= 0; --var6) {
               var7 = field1926[var6];
               if(var7 > 0) {
                  var8 = field1927[var6];

                  for(var9 = 0; var9 < var7; ++var9) {
                     this.method2448(var8[var9]);
                  }
               }
            }

         } else {
            for(var6 = 0; var6 < 12; ++var6) {
               field1928[var6] = 0;
               field1878[var6] = 0;
            }

            for(var6 = this.field1908 - 1; var6 >= 0; --var6) {
               var7 = field1926[var6];
               if(var7 > 0) {
                  var8 = field1927[var6];

                  for(var9 = 0; var9 < var7; ++var9) {
                     var10 = var8[var9];
                     byte var30 = this.field1893[var10];
                     var12 = field1928[var30]++;
                     field1929[var30][var12] = var10;
                     if(var30 < 10) {
                        field1878[var30] += var6;
                     } else if(var30 == 10) {
                        field1930[var12] = var6;
                     } else {
                        field1940[var12] = var6;
                     }
                  }
               }
            }

            var6 = 0;
            if(field1928[1] > 0 || field1928[2] > 0) {
               var6 = (field1878[1] + field1878[2]) / (field1928[1] + field1928[2]);
            }

            var7 = 0;
            if(field1928[3] > 0 || field1928[4] > 0) {
               var7 = (field1878[3] + field1878[4]) / (field1928[3] + field1928[4]);
            }

            var26 = 0;
            if(field1928[6] > 0 || field1928[8] > 0) {
               var26 = (field1878[8] + field1878[6]) / (field1928[8] + field1928[6]);
            }

            var10 = 0;
            var11 = field1928[10];
            int[] var27 = field1929[10];
            int[] var28 = field1930;
            if(var10 == var11) {
               var10 = 0;
               var11 = field1928[11];
               var27 = field1929[11];
               var28 = field1940;
            }

            if(var10 < var11) {
               var9 = var28[var10];
            } else {
               var9 = -1000;
            }

            for(var14 = 0; var14 < 10; ++var14) {
               while(var14 == 0 && var9 > var6) {
                  this.method2448(var27[var10++]);
                  if(var10 == var11 && var27 != field1929[11]) {
                     var10 = 0;
                     var11 = field1928[11];
                     var27 = field1929[11];
                     var28 = field1940;
                  }

                  if(var10 < var11) {
                     var9 = var28[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 3 && var9 > var7) {
                  this.method2448(var27[var10++]);
                  if(var10 == var11 && var27 != field1929[11]) {
                     var10 = 0;
                     var11 = field1928[11];
                     var27 = field1929[11];
                     var28 = field1940;
                  }

                  if(var10 < var11) {
                     var9 = var28[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 5 && var9 > var26) {
                  this.method2448(var27[var10++]);
                  if(var10 == var11 && var27 != field1929[11]) {
                     var10 = 0;
                     var11 = field1928[11];
                     var27 = field1929[11];
                     var28 = field1940;
                  }

                  if(var10 < var11) {
                     var9 = var28[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               var15 = field1928[var14];
               int[] var29 = field1929[var14];

               for(var17 = 0; var17 < var15; ++var17) {
                  this.method2448(var29[var17]);
               }
            }

            while(var9 != -1000) {
               this.method2448(var27[var10++]);
               if(var10 == var11 && var27 != field1929[11]) {
                  var10 = 0;
                  var27 = field1929[11];
                  var11 = field1928[11];
                  var28 = field1940;
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

   @ObfuscatedName("am")
   final void method2448(int var1) {
      if(field1918[var1]) {
         this.method2449(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         Graphics3D.rasterClipEnable = field1932[var1];
         if(this.field1894 == null) {
            Graphics3D.rasterAlpha = 0;
         } else {
            Graphics3D.rasterAlpha = this.field1894[var1] & 255;
         }

         if(this.field1921 != null && this.field1921[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1895 != null && this.field1895[var1] != -1) {
               int var8 = this.field1895[var1] & 255;
               var5 = this.field1899[var8];
               var6 = this.field1900[var8];
               var7 = this.field1944[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1892[var1] == -1) {
               Graphics3D.rasterTextureAffine(field1920[var2], field1920[var3], field1920[var4], field1931[var2], field1931[var3], field1931[var4], this.field1890[var1], this.field1890[var1], this.field1890[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1923[var5], field1923[var6], field1923[var7], field1924[var5], field1924[var6], field1924[var7], this.field1921[var1]);
            } else {
               Graphics3D.rasterTextureAffine(field1920[var2], field1920[var3], field1920[var4], field1931[var2], field1931[var3], field1931[var4], this.field1890[var1], this.field1891[var1], this.field1892[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1923[var5], field1923[var6], field1923[var7], field1924[var5], field1924[var6], field1924[var7], this.field1921[var1]);
            }
         } else if(this.field1892[var1] == -1) {
            Graphics3D.rasterFlat(field1920[var2], field1920[var3], field1920[var4], field1931[var2], field1931[var3], field1931[var4], field1934[this.field1890[var1]]);
         } else {
            Graphics3D.rasterGouraud(field1920[var2], field1920[var3], field1920[var4], field1931[var2], field1931[var3], field1931[var4], this.field1890[var1], this.field1891[var1], this.field1892[var1]);
         }

      }
   }

   @ObfuscatedName("j")
   public void method2479(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1882; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.method2436();
   }

   @ObfuscatedName("z")
   public final void method2476(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1926[0] = -1;
      if(this.field1905 != 2 && this.field1905 != 1) {
         this.method2434();
      }

      int var8 = Graphics3D.centerX;
      int var9 = Graphics3D.centerY;
      int var10 = field1942[var1];
      int var11 = field1910[var1];
      int var12 = field1942[var2];
      int var13 = field1910[var2];
      int var14 = field1942[var3];
      int var15 = field1910[var3];
      int var16 = field1942[var4];
      int var17 = field1910[var4];
      int var18 = var16 * var6 + var17 * var7 >> 16;

      for(int var19 = 0; var19 < this.field1882; ++var19) {
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
         field1916[var19] = var22 - var18;
         field1931[var19] = var20 * Graphics3D.field1983 / var22 + var8;
         field1920[var19] = var23 * Graphics3D.field1983 / var22 + var9;
         if(this.field1898 > 0) {
            yViewportBuffer[var19] = var20;
            field1923[var19] = var23;
            field1924[var19] = var22;
         }
      }

      try {
         this.method2445(false, false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("ap")
   public final void method2446(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1926[0] = -1;
      if(this.field1905 != 2 && this.field1905 != 1) {
         this.method2434();
      }

      int var9 = Graphics3D.centerX;
      int var10 = Graphics3D.centerY;
      int var11 = field1942[var1];
      int var12 = field1910[var1];
      int var13 = field1942[var2];
      int var14 = field1910[var2];
      int var15 = field1942[var3];
      int var16 = field1910[var3];
      int var17 = field1942[var4];
      int var18 = field1910[var4];
      int var19 = var17 * var6 + var18 * var7 >> 16;

      for(int var20 = 0; var20 < this.field1882; ++var20) {
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
         field1916[var20] = var23 - var19;
         field1931[var20] = var9 + var21 * Graphics3D.field1983 / var8;
         field1920[var20] = var10 + var24 * Graphics3D.field1983 / var8;
         if(this.field1898 > 0) {
            yViewportBuffer[var20] = var21;
            field1923[var20] = var24;
            field1924[var20] = var23;
         }
      }

      try {
         this.method2445(false, false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("p")
   public int method2470() {
      this.method2433();
      return this.XYZMag;
   }
}
