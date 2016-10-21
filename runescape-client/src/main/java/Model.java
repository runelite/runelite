import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dg")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("bv")
   public static boolean field1859 = false;
   @ObfuscatedName("n")
   static Model field1861 = new Model();
   @ObfuscatedName("t")
   static byte[] field1862 = new byte[1];
   @ObfuscatedName("v")
   int field1863 = 0;
   @ObfuscatedName("bw")
   static int[] field1864;
   @ObfuscatedName("m")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("k")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("c")
   int field1867 = 0;
   @ObfuscatedName("w")
   @Export("indices1")
   int[] indices1;
   @ObfuscatedName("h")
   @Export("indices3")
   int[] indices3;
   @ObfuscatedName("i")
   int[] field1871;
   @ObfuscatedName("u")
   int[] field1872;
   @ObfuscatedName("x")
   int[] field1873;
   @ObfuscatedName("at")
   static int[] field1874 = new int[4700];
   @ObfuscatedName("o")
   byte[] field1875;
   @ObfuscatedName("j")
   byte[] field1876;
   @ObfuscatedName("as")
   static int[] field1877 = new int[4700];
   @ObfuscatedName("r")
   byte field1878 = 0;
   @ObfuscatedName("a")
   int field1879 = 0;
   @ObfuscatedName("z")
   int[] field1880;
   @ObfuscatedName("p")
   int[] field1881;
   @ObfuscatedName("y")
   int[] field1882;
   @ObfuscatedName("s")
   int[][] field1883;
   @ObfuscatedName("g")
   int[][] field1884;
   @ObfuscatedName("f")
   static Model field1885 = new Model();
   @ObfuscatedName("ay")
   int field1886;
   @ObfuscatedName("ah")
   int field1887;
   @ObfuscatedName("ax")
   int field1888;
   @ObfuscatedName("ar")
   int field1889;
   @ObfuscatedName("ae")
   int field1890;
   @ObfuscatedName("d")
   byte[] field1891;
   @ObfuscatedName("bo")
   public static int[] field1892 = new int[1000];
   @ObfuscatedName("am")
   static boolean[] field1893 = new boolean[4700];
   @ObfuscatedName("q")
   short[] field1894;
   @ObfuscatedName("b")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("aa")
   static int[] field1896 = new int[4700];
   @ObfuscatedName("aw")
   static boolean[] field1897 = new boolean[4700];
   @ObfuscatedName("ao")
   static int[] field1898 = new int[4700];
   @ObfuscatedName("ai")
   static int[] field1899 = new int[4700];
   @ObfuscatedName("ak")
   static int[] field1901 = new int[1600];
   @ObfuscatedName("aq")
   static int[] field1902 = new int[4700];
   @ObfuscatedName("az")
   static int[] field1903 = new int[12];
   @ObfuscatedName("au")
   static int[][] field1904 = new int[12][2000];
   @ObfuscatedName("av")
   static int[] field1905 = new int[12];
   @ObfuscatedName("al")
   static int[] field1906 = new int[2000];
   @ObfuscatedName("ba")
   public static int field1908 = 0;
   @ObfuscatedName("ag")
   static int[][] field1909 = new int[1600][512];
   @ObfuscatedName("ab")
   static int[] field1910 = new int[10];
   @ObfuscatedName("bc")
   static int field1911;
   @ObfuscatedName("bk")
   static int field1912;
   @ObfuscatedName("bs")
   static int field1913;
   @ObfuscatedName("ad")
   static int[] field1914 = new int[10];
   @ObfuscatedName("aj")
   public boolean field1915 = false;
   @ObfuscatedName("e")
   static byte[] field1916 = new byte[1];
   @ObfuscatedName("bn")
   public static int field1917 = 0;
   @ObfuscatedName("af")
   static int[] field1918 = new int[2000];
   @ObfuscatedName("bt")
   static int[] field1919;
   @ObfuscatedName("bb")
   public static int field1920 = 0;
   @ObfuscatedName("bi")
   static int[] field1921;
   @ObfuscatedName("bh")
   static int[] field1922;
   @ObfuscatedName("l")
   @Export("indices2")
   int[] indices2;
   @ObfuscatedName("an")
   static int[] field1924 = new int[10];

   @ObfuscatedName("t")
   public Model method2317(boolean var1) {
      if(!var1 && field1862.length < this.field1867) {
         field1862 = new byte[this.field1867 + 100];
      }

      return this.method2321(var1, field1861, field1862);
   }

   public Model(Model[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1863 = 0;
      this.field1867 = 0;
      this.field1879 = 0;
      this.field1878 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1863 += var8.field1863;
            this.field1867 += var8.field1867;
            this.field1879 += var8.field1879;
            if(var8.field1891 != null) {
               var3 = true;
            } else {
               if(this.field1878 == -1) {
                  this.field1878 = var8.field1878;
               }

               if(this.field1878 != var8.field1878) {
                  var3 = true;
               }
            }

            var4 |= var8.field1875 != null;
            var5 |= var8.field1894 != null;
            var6 |= var8.field1876 != null;
         }
      }

      this.verticesX = new int[this.field1863];
      this.verticesY = new int[this.field1863];
      this.verticesZ = new int[this.field1863];
      this.indices1 = new int[this.field1867];
      this.indices2 = new int[this.field1867];
      this.indices3 = new int[this.field1867];
      this.field1871 = new int[this.field1867];
      this.field1872 = new int[this.field1867];
      this.field1873 = new int[this.field1867];
      if(var3) {
         this.field1891 = new byte[this.field1867];
      }

      if(var4) {
         this.field1875 = new byte[this.field1867];
      }

      if(var5) {
         this.field1894 = new short[this.field1867];
      }

      if(var6) {
         this.field1876 = new byte[this.field1867];
      }

      if(this.field1879 > 0) {
         this.field1880 = new int[this.field1879];
         this.field1881 = new int[this.field1879];
         this.field1882 = new int[this.field1879];
      }

      this.field1863 = 0;
      this.field1867 = 0;
      this.field1879 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1867; ++var9) {
               this.indices1[this.field1867] = var8.indices1[var9] + this.field1863;
               this.indices2[this.field1867] = var8.indices2[var9] + this.field1863;
               this.indices3[this.field1867] = var8.indices3[var9] + this.field1863;
               this.field1871[this.field1867] = var8.field1871[var9];
               this.field1872[this.field1867] = var8.field1872[var9];
               this.field1873[this.field1867] = var8.field1873[var9];
               if(var3) {
                  if(var8.field1891 != null) {
                     this.field1891[this.field1867] = var8.field1891[var9];
                  } else {
                     this.field1891[this.field1867] = var8.field1878;
                  }
               }

               if(var4 && var8.field1875 != null) {
                  this.field1875[this.field1867] = var8.field1875[var9];
               }

               if(var5) {
                  if(var8.field1894 != null) {
                     this.field1894[this.field1867] = var8.field1894[var9];
                  } else {
                     this.field1894[this.field1867] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1876 != null && var8.field1876[var9] != -1) {
                     this.field1876[this.field1867] = (byte)(var8.field1876[var9] + this.field1879);
                  } else {
                     this.field1876[this.field1867] = -1;
                  }
               }

               ++this.field1867;
            }

            for(var9 = 0; var9 < var8.field1879; ++var9) {
               this.field1880[this.field1879] = var8.field1880[var9] + this.field1863;
               this.field1881[this.field1879] = var8.field1881[var9] + this.field1863;
               this.field1882[this.field1879] = var8.field1882[var9] + this.field1863;
               ++this.field1879;
            }

            for(var9 = 0; var9 < var8.field1863; ++var9) {
               this.verticesX[this.field1863] = var8.verticesX[var9];
               this.verticesY[this.field1863] = var8.verticesY[var9];
               this.verticesZ[this.field1863] = var8.verticesZ[var9];
               ++this.field1863;
            }
         }
      }

   }

   @ObfuscatedName("f")
   public Model method2318(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2377();
      int var7 = var2 - this.field1888;
      int var8 = var2 + this.field1888;
      int var9 = var4 - this.field1888;
      int var10 = var4 + this.field1888;
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
               var11.field1863 = this.field1863;
               var11.field1867 = this.field1867;
               var11.field1879 = this.field1879;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1871 = this.field1871;
               var11.field1872 = this.field1872;
               var11.field1873 = this.field1873;
               var11.field1891 = this.field1891;
               var11.field1875 = this.field1875;
               var11.field1876 = this.field1876;
               var11.field1894 = this.field1894;
               var11.field1878 = this.field1878;
               var11.field1880 = this.field1880;
               var11.field1881 = this.field1881;
               var11.field1882 = this.field1882;
               var11.field1883 = this.field1883;
               var11.field1884 = this.field1884;
               var11.field1915 = this.field1915;
               var11.verticesY = new int[var11.field1863];
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
               for(var12 = 0; var12 < var11.field1863; ++var12) {
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
               for(var12 = 0; var12 < var11.field1863; ++var12) {
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

            var11.field1886 = 0;
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("a")
   public final void method2320(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1901[0] = -1;
      if(this.field1886 != 2 && this.field1886 != 1) {
         this.method2323();
      }

      int var9 = class94.field1632;
      int var10 = class94.field1633;
      int var10000 = field1919[var1];
      var10000 = field1864[var1];
      int var13 = field1919[var2];
      int var14 = field1864[var2];
      int var15 = field1919[var3];
      int var16 = field1864[var3];
      int var17 = field1919[var4];
      int var18 = field1864[var4];
      int var19 = var6 * var17 + var7 * var18 >> 16;

      for(int var20 = 0; var20 < this.field1863; ++var20) {
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
         field1896[var20] = var23 - var19;
         field1902[var20] = var9 + var21 * class94.field1631 / var8;
         field1874[var20] = var10 + var24 * class94.field1631 / var8;
         if(this.field1879 > 0) {
            field1877[var20] = var21;
            field1898[var20] = var24;
            field1899[var20] = var23;
         }
      }

      try {
         this.method2327(false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("v")
   Model method2321(boolean var1, Model var2, byte[] var3) {
      var2.field1863 = this.field1863;
      var2.field1867 = this.field1867;
      var2.field1879 = this.field1879;
      if(var2.verticesX == null || var2.verticesX.length < this.field1863) {
         var2.verticesX = new int[this.field1863 + 100];
         var2.verticesY = new int[this.field1863 + 100];
         var2.verticesZ = new int[this.field1863 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1863; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if(var1) {
         var2.field1875 = this.field1875;
      } else {
         var2.field1875 = var3;
         if(this.field1875 == null) {
            for(var4 = 0; var4 < this.field1867; ++var4) {
               var2.field1875[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1867; ++var4) {
               var2.field1875[var4] = this.field1875[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1871 = this.field1871;
      var2.field1872 = this.field1872;
      var2.field1873 = this.field1873;
      var2.field1891 = this.field1891;
      var2.field1876 = this.field1876;
      var2.field1894 = this.field1894;
      var2.field1878 = this.field1878;
      var2.field1880 = this.field1880;
      var2.field1881 = this.field1881;
      var2.field1882 = this.field1882;
      var2.field1883 = this.field1883;
      var2.field1884 = this.field1884;
      var2.field1915 = this.field1915;
      var2.field1886 = 0;
      return var2;
   }

   @ObfuscatedName("m")
   void method2323() {
      if(this.field1886 != 2) {
         this.field1886 = 2;
         this.field1888 = 0;

         for(int var1 = 0; var1 < this.field1863; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1888) {
               this.field1888 = var5;
            }
         }

         this.field1888 = (int)(Math.sqrt((double)this.field1888) + 0.99D);
         this.field1890 = this.field1888;
         this.field1889 = this.field1888 + this.field1888;
      }
   }

   @ObfuscatedName("k")
   public int method2324() {
      this.method2377();
      return this.field1888;
   }

   @ObfuscatedName("c")
   public void method2325(Frames var1, int var2) {
      if(this.field1883 != null) {
         if(var2 != -1) {
            Frame var3 = var1.field1834[var2];
            FrameMap var4 = var3.field1599;
            field1911 = 0;
            field1912 = 0;
            field1913 = 0;

            for(int var5 = 0; var5 < var3.field1600; ++var5) {
               int var6 = var3.field1603[var5];
               this.method2359(var4.field1823[var6], var4.field1829[var6], var3.field1602[var5], var3.field1601[var5], var3.field1604[var5]);
            }

            this.field1886 = 0;
         }
      }
   }

   @ObfuscatedName("w")
   public void method2326(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.field1834[var2];
            Frame var7 = var3.field1834[var4];
            FrameMap var8 = var6.field1599;
            field1911 = 0;
            field1912 = 0;
            field1913 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1600; ++var11) {
               for(var12 = var6.field1603[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field1823[var12] == 0) {
                  this.method2359(var8.field1823[var12], var8.field1829[var12], var6.field1602[var11], var6.field1601[var11], var6.field1604[var11]);
               }
            }

            field1911 = 0;
            field1912 = 0;
            field1913 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1600; ++var11) {
               for(var12 = var7.field1603[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field1823[var12] == 0) {
                  this.method2359(var8.field1823[var12], var8.field1829[var12], var7.field1602[var11], var7.field1601[var11], var7.field1604[var11]);
               }
            }

            this.field1886 = 0;
         } else {
            this.method2325(var1, var2);
         }
      }
   }

   @ObfuscatedName("z")
   final void method2327(boolean var1, boolean var2, int var3) {
      if(this.field1889 < 1600) {
         int var4;
         for(var4 = 0; var4 < this.field1889; ++var4) {
            field1901[var4] = 0;
         }

         int var5;
         int var6;
         int var7;
         int var8;
         int var9;
         int var10;
         int var12;
         int var13;
         int var15;
         for(var4 = 0; var4 < this.field1867; ++var4) {
            if(this.field1873[var4] != -2) {
               var5 = this.indices1[var4];
               var6 = this.indices2[var4];
               var7 = this.indices3[var4];
               var8 = field1902[var5];
               var9 = field1902[var6];
               var10 = field1902[var7];
               int var11;
               if(var1 && (var8 == -5000 || var9 == -5000 || var10 == -5000)) {
                  var11 = field1877[var5];
                  var12 = field1877[var6];
                  var13 = field1877[var7];
                  int var14 = field1898[var5];
                  var15 = field1898[var6];
                  int var16 = field1898[var7];
                  int var17 = field1899[var5];
                  int var18 = field1899[var6];
                  int var19 = field1899[var7];
                  var11 -= var12;
                  var13 -= var12;
                  var14 -= var15;
                  var16 -= var15;
                  var17 -= var18;
                  var19 -= var18;
                  int var20 = var14 * var19 - var17 * var16;
                  int var21 = var17 * var13 - var11 * var19;
                  int var22 = var11 * var16 - var14 * var13;
                  if(var12 * var20 + var15 * var21 + var18 * var22 > 0) {
                     field1893[var4] = true;
                     int var23 = (field1896[var5] + field1896[var6] + field1896[var7]) / 3 + this.field1890;
                     field1909[var23][field1901[var23]++] = var4;
                  }
               } else {
                  if(var2 && this.method2354(field1908, field1920, field1874[var5], field1874[var6], field1874[var7], var8, var9, var10)) {
                     field1892[field1917++] = var3;
                     var2 = false;
                  }

                  if((var8 - var9) * (field1874[var7] - field1874[var6]) - (field1874[var5] - field1874[var6]) * (var10 - var9) > 0) {
                     field1893[var4] = false;
                     if(var8 >= 0 && var9 >= 0 && var10 >= 0 && var8 <= class94.rasterClipX && var9 <= class94.rasterClipX && var10 <= class94.rasterClipX) {
                        field1897[var4] = false;
                     } else {
                        field1897[var4] = true;
                     }

                     var11 = (field1896[var5] + field1896[var6] + field1896[var7]) / 3 + this.field1890;
                     field1909[var11][field1901[var11]++] = var4;
                  }
               }
            }
         }

         int[] var26;
         if(this.field1891 == null) {
            for(var4 = this.field1889 - 1; var4 >= 0; --var4) {
               var5 = field1901[var4];
               if(var5 > 0) {
                  var26 = field1909[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     this.method2338(var26[var7]);
                  }
               }
            }

         } else {
            for(var4 = 0; var4 < 12; ++var4) {
               field1903[var4] = 0;
               field1905[var4] = 0;
            }

            for(var4 = this.field1889 - 1; var4 >= 0; --var4) {
               var5 = field1901[var4];
               if(var5 > 0) {
                  var26 = field1909[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     var8 = var26[var7];
                     byte var28 = this.field1891[var8];
                     var10 = field1903[var28]++;
                     field1904[var28][var10] = var8;
                     if(var28 < 10) {
                        field1905[var28] += var4;
                     } else if(var28 == 10) {
                        field1918[var10] = var4;
                     } else {
                        field1906[var10] = var4;
                     }
                  }
               }
            }

            var4 = 0;
            if(field1903[1] > 0 || field1903[2] > 0) {
               var4 = (field1905[1] + field1905[2]) / (field1903[1] + field1903[2]);
            }

            var5 = 0;
            if(field1903[3] > 0 || field1903[4] > 0) {
               var5 = (field1905[3] + field1905[4]) / (field1903[3] + field1903[4]);
            }

            var6 = 0;
            if(field1903[6] > 0 || field1903[8] > 0) {
               var6 = (field1905[6] + field1905[8]) / (field1903[6] + field1903[8]);
            }

            var8 = 0;
            var9 = field1903[10];
            int[] var24 = field1904[10];
            int[] var25 = field1918;
            if(var8 == var9) {
               var8 = 0;
               var9 = field1903[11];
               var24 = field1904[11];
               var25 = field1906;
            }

            if(var8 < var9) {
               var7 = var25[var8];
            } else {
               var7 = -1000;
            }

            for(var12 = 0; var12 < 10; ++var12) {
               while(var12 == 0 && var7 > var4) {
                  this.method2338(var24[var8++]);
                  if(var8 == var9 && var24 != field1904[11]) {
                     var8 = 0;
                     var9 = field1903[11];
                     var24 = field1904[11];
                     var25 = field1906;
                  }

                  if(var8 < var9) {
                     var7 = var25[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 3 && var7 > var5) {
                  this.method2338(var24[var8++]);
                  if(var8 == var9 && var24 != field1904[11]) {
                     var8 = 0;
                     var9 = field1903[11];
                     var24 = field1904[11];
                     var25 = field1906;
                  }

                  if(var8 < var9) {
                     var7 = var25[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 5 && var7 > var6) {
                  this.method2338(var24[var8++]);
                  if(var8 == var9 && var24 != field1904[11]) {
                     var8 = 0;
                     var9 = field1903[11];
                     var24 = field1904[11];
                     var25 = field1906;
                  }

                  if(var8 < var9) {
                     var7 = var25[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               var13 = field1903[var12];
               int[] var27 = field1904[var12];

               for(var15 = 0; var15 < var13; ++var15) {
                  this.method2338(var27[var15]);
               }
            }

            while(var7 != -1000) {
               this.method2338(var24[var8++]);
               if(var8 == var9 && var24 != field1904[11]) {
                  var8 = 0;
                  var24 = field1904[11];
                  var9 = field1903[11];
                  var25 = field1906;
               }

               if(var8 < var9) {
                  var7 = var25[var8];
               } else {
                  var7 = -1000;
               }
            }

         }
      }
   }

   @ObfuscatedName("u")
   public void method2328() {
      for(int var1 = 0; var1 < this.field1863; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.field1886 = 0;
   }

   @ObfuscatedName("d")
   public void method2330() {
      for(int var1 = 0; var1 < this.field1863; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.field1886 = 0;
   }

   @ObfuscatedName("x")
   public void method2331() {
      for(int var1 = 0; var1 < this.field1863; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.field1886 = 0;
   }

   @ObfuscatedName("q")
   public void method2333(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1863; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = this.verticesY[var4] * var2 / 128;
         this.verticesZ[var4] = this.verticesZ[var4] * var3 / 128;
      }

      this.field1886 = 0;
   }

   @ObfuscatedName("r")
   public final void method2334(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1901[0] = -1;
      if(this.field1886 != 2 && this.field1886 != 1) {
         this.method2323();
      }

      int var8 = class94.field1632;
      int var9 = class94.field1633;
      int var10000 = field1919[var1];
      var10000 = field1864[var1];
      int var12 = field1919[var2];
      int var13 = field1864[var2];
      int var14 = field1919[var3];
      int var15 = field1864[var3];
      int var16 = field1919[var4];
      int var17 = field1864[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1863; ++var19) {
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
         field1896[var19] = var22 - var18;
         field1902[var19] = var8 + var20 * class94.field1631 / var22;
         field1874[var19] = var9 + var23 * class94.field1631 / var22;
         if(this.field1879 > 0) {
            field1877[var19] = var20;
            field1898[var19] = var23;
            field1899[var19] = var22;
         }
      }

      try {
         this.method2327(false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("o")
   public void method2336(int var1) {
      int var2 = field1919[var1];
      int var3 = field1864[var1];

      for(int var4 = 0; var4 < this.field1863; ++var4) {
         int var5 = this.verticesY[var4] * var3 - this.verticesZ[var4] * var2 >> 16;
         this.verticesZ[var4] = this.verticesY[var4] * var2 + this.verticesZ[var4] * var3 >> 16;
         this.verticesY[var4] = var5;
      }

      this.field1886 = 0;
   }

   @ObfuscatedName("j")
   public void method2337(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1863; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.field1886 = 0;
   }

   @ObfuscatedName("p")
   final void method2338(int var1) {
      if(field1893[var1]) {
         this.method2339(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         class94.rasterClipEnable = field1897[var1];
         if(this.field1875 == null) {
            class94.rasterAlpha = 0;
         } else {
            class94.rasterAlpha = this.field1875[var1] & 255;
         }

         if(this.field1894 != null && this.field1894[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1876 != null && this.field1876[var1] != -1) {
               int var8 = this.field1876[var1] & 255;
               var5 = this.field1880[var8];
               var6 = this.field1881[var8];
               var7 = this.field1882[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1873[var1] == -1) {
               class94.rasterTextureAffine(field1874[var2], field1874[var3], field1874[var4], field1902[var2], field1902[var3], field1902[var4], this.field1871[var1], this.field1871[var1], this.field1871[var1], field1877[var5], field1877[var6], field1877[var7], field1898[var5], field1898[var6], field1898[var7], field1899[var5], field1899[var6], field1899[var7], this.field1894[var1]);
            } else {
               class94.rasterTextureAffine(field1874[var2], field1874[var3], field1874[var4], field1902[var2], field1902[var3], field1902[var4], this.field1871[var1], this.field1872[var1], this.field1873[var1], field1877[var5], field1877[var6], field1877[var7], field1898[var5], field1898[var6], field1898[var7], field1899[var5], field1899[var6], field1899[var7], this.field1894[var1]);
            }
         } else if(this.field1873[var1] == -1) {
            class94.rasterFlat(field1874[var2], field1874[var3], field1874[var4], field1902[var2], field1902[var3], field1902[var4], field1921[this.field1871[var1]]);
         } else {
            class94.rasterGouraud(field1874[var2], field1874[var3], field1874[var4], field1902[var2], field1902[var3], field1902[var4], this.field1871[var1], this.field1872[var1], this.field1873[var1]);
         }

      }
   }

   @ObfuscatedName("y")
   final void method2339(int var1) {
      int var2 = class94.field1632;
      int var3 = class94.field1633;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1899[var5];
      int var9 = field1899[var6];
      int var10 = field1899[var7];
      if(this.field1875 == null) {
         class94.rasterAlpha = 0;
      } else {
         class94.rasterAlpha = this.field1875[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1914[var4] = field1902[var5];
         field1924[var4] = field1874[var5];
         field1910[var4++] = this.field1871[var1];
      } else {
         var11 = field1877[var5];
         var12 = field1898[var5];
         var13 = this.field1871[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1922[var10 - var8];
            field1914[var4] = var2 + (var11 + ((field1877[var7] - var11) * var14 >> 16)) * class94.field1631 / 50;
            field1924[var4] = var3 + (var12 + ((field1898[var7] - var12) * var14 >> 16)) * class94.field1631 / 50;
            field1910[var4++] = var13 + ((this.field1873[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1922[var9 - var8];
            field1914[var4] = var2 + (var11 + ((field1877[var6] - var11) * var14 >> 16)) * class94.field1631 / 50;
            field1924[var4] = var3 + (var12 + ((field1898[var6] - var12) * var14 >> 16)) * class94.field1631 / 50;
            field1910[var4++] = var13 + ((this.field1872[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1914[var4] = field1902[var6];
         field1924[var4] = field1874[var6];
         field1910[var4++] = this.field1872[var1];
      } else {
         var11 = field1877[var6];
         var12 = field1898[var6];
         var13 = this.field1872[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1922[var8 - var9];
            field1914[var4] = var2 + (var11 + ((field1877[var5] - var11) * var14 >> 16)) * class94.field1631 / 50;
            field1924[var4] = var3 + (var12 + ((field1898[var5] - var12) * var14 >> 16)) * class94.field1631 / 50;
            field1910[var4++] = var13 + ((this.field1871[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1922[var10 - var9];
            field1914[var4] = var2 + (var11 + ((field1877[var7] - var11) * var14 >> 16)) * class94.field1631 / 50;
            field1924[var4] = var3 + (var12 + ((field1898[var7] - var12) * var14 >> 16)) * class94.field1631 / 50;
            field1910[var4++] = var13 + ((this.field1873[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1914[var4] = field1902[var7];
         field1924[var4] = field1874[var7];
         field1910[var4++] = this.field1873[var1];
      } else {
         var11 = field1877[var7];
         var12 = field1898[var7];
         var13 = this.field1873[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1922[var9 - var10];
            field1914[var4] = var2 + (var11 + ((field1877[var6] - var11) * var14 >> 16)) * class94.field1631 / 50;
            field1924[var4] = var3 + (var12 + ((field1898[var6] - var12) * var14 >> 16)) * class94.field1631 / 50;
            field1910[var4++] = var13 + ((this.field1872[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1922[var8 - var10];
            field1914[var4] = var2 + (var11 + ((field1877[var5] - var11) * var14 >> 16)) * class94.field1631 / 50;
            field1924[var4] = var3 + (var12 + ((field1898[var5] - var12) * var14 >> 16)) * class94.field1631 / 50;
            field1910[var4++] = var13 + ((this.field1871[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1914[0];
      var12 = field1914[1];
      var13 = field1914[2];
      var14 = field1924[0];
      int var15 = field1924[1];
      int var16 = field1924[2];
      class94.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class94.rasterClipX || var12 > class94.rasterClipX || var13 > class94.rasterClipX) {
            class94.rasterClipEnable = true;
         }

         if(this.field1894 != null && this.field1894[var1] != -1) {
            if(this.field1876 != null && this.field1876[var1] != -1) {
               var20 = this.field1876[var1] & 255;
               var17 = this.field1880[var20];
               var18 = this.field1881[var20];
               var19 = this.field1882[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1873[var1] == -1) {
               class94.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1871[var1], this.field1871[var1], this.field1871[var1], field1877[var17], field1877[var18], field1877[var19], field1898[var17], field1898[var18], field1898[var19], field1899[var17], field1899[var18], field1899[var19], this.field1894[var1]);
            } else {
               class94.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1910[0], field1910[1], field1910[2], field1877[var17], field1877[var18], field1877[var19], field1898[var17], field1898[var18], field1898[var19], field1899[var17], field1899[var18], field1899[var19], this.field1894[var1]);
            }
         } else if(this.field1873[var1] == -1) {
            class94.rasterFlat(var14, var15, var16, var11, var12, var13, field1921[this.field1871[var1]]);
         } else {
            class94.rasterGouraud(var14, var15, var16, var11, var12, var13, field1910[0], field1910[1], field1910[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class94.rasterClipX || var12 > class94.rasterClipX || var13 > class94.rasterClipX || field1914[3] < 0 || field1914[3] > class94.rasterClipX) {
            class94.rasterClipEnable = true;
         }

         if(this.field1894 != null && this.field1894[var1] != -1) {
            if(this.field1876 != null && this.field1876[var1] != -1) {
               var20 = this.field1876[var1] & 255;
               var17 = this.field1880[var20];
               var18 = this.field1881[var20];
               var19 = this.field1882[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1894[var1];
            if(this.field1873[var1] == -1) {
               class94.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1871[var1], this.field1871[var1], this.field1871[var1], field1877[var17], field1877[var18], field1877[var19], field1898[var17], field1898[var18], field1898[var19], field1899[var17], field1899[var18], field1899[var19], var21);
               class94.rasterTextureAffine(var14, var16, field1924[3], var11, var13, field1914[3], this.field1871[var1], this.field1871[var1], this.field1871[var1], field1877[var17], field1877[var18], field1877[var19], field1898[var17], field1898[var18], field1898[var19], field1899[var17], field1899[var18], field1899[var19], var21);
            } else {
               class94.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1910[0], field1910[1], field1910[2], field1877[var17], field1877[var18], field1877[var19], field1898[var17], field1898[var18], field1898[var19], field1899[var17], field1899[var18], field1899[var19], var21);
               class94.rasterTextureAffine(var14, var16, field1924[3], var11, var13, field1914[3], field1910[0], field1910[2], field1910[3], field1877[var17], field1877[var18], field1877[var19], field1898[var17], field1898[var18], field1898[var19], field1899[var17], field1899[var18], field1899[var19], var21);
            }
         } else if(this.field1873[var1] == -1) {
            var17 = field1921[this.field1871[var1]];
            class94.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            class94.rasterFlat(var14, var16, field1924[3], var11, var13, field1914[3], var17);
         } else {
            class94.rasterGouraud(var14, var15, var16, var11, var12, var13, field1910[0], field1910[1], field1910[2]);
            class94.rasterGouraud(var14, var16, field1924[3], var11, var13, field1914[3], field1910[0], field1910[2], field1910[3]);
         }
      }

   }

   static {
      field1919 = class94.field1635;
      field1864 = class94.field1646;
      field1921 = class94.colorPalette;
      field1922 = class94.field1644;
   }

   @ObfuscatedName("e")
   public Model method2353(boolean var1) {
      if(!var1 && field1916.length < this.field1867) {
         field1916 = new byte[this.field1867 + 100];
      }

      return this.method2321(var1, field1885, field1916);
   }

   @ObfuscatedName("s")
   final boolean method2354(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      return var2 < var3 && var2 < var4 && var2 < var5?false:(var2 > var3 && var2 > var4 && var2 > var5?false:(var1 < var6 && var1 < var7 && var1 < var8?false:var1 <= var6 || var1 <= var7 || var1 <= var8));
   }

   Model() {
   }

   @ObfuscatedName("i")
   void method2359(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1911 = 0;
         field1912 = 0;
         field1913 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var9 = var2[var8];
            if(var9 < this.field1883.length) {
               int[] var10 = this.field1883[var9];

               for(var11 = 0; var11 < var10.length; ++var11) {
                  var12 = var10[var11];
                  field1911 += this.verticesX[var12];
                  field1912 += this.verticesY[var12];
                  field1913 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1911 = field1911 / var7 + var3;
            field1912 = field1912 / var7 + var4;
            field1913 = field1913 / var7 + var5;
         } else {
            field1911 = var3;
            field1912 = var4;
            field1913 = var5;
         }

      } else {
         int[] var18;
         int var19;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1883.length) {
                  var18 = this.field1883[var8];

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
               if(var8 < this.field1883.length) {
                  var18 = this.field1883[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= field1911;
                     this.verticesY[var11] -= field1912;
                     this.verticesZ[var11] -= field1913;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1919[var14];
                        var16 = field1864[var14];
                        var17 = this.verticesY[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesY[var11] = this.verticesY[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1919[var12];
                        var16 = field1864[var12];
                        var17 = this.verticesY[var11] * var16 - this.verticesZ[var11] * var15 >> 16;
                        this.verticesZ[var11] = this.verticesY[var11] * var15 + this.verticesZ[var11] * var16 >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1919[var13];
                        var16 = field1864[var13];
                        var17 = this.verticesZ[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesZ[var11] = this.verticesZ[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += field1911;
                     this.verticesY[var11] += field1912;
                     this.verticesZ[var11] += field1913;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1883.length) {
                  var18 = this.field1883[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= field1911;
                     this.verticesY[var11] -= field1912;
                     this.verticesZ[var11] -= field1913;
                     this.verticesX[var11] = this.verticesX[var11] * var3 / 128;
                     this.verticesY[var11] = this.verticesY[var11] * var4 / 128;
                     this.verticesZ[var11] = this.verticesZ[var11] * var5 / 128;
                     this.verticesX[var11] += field1911;
                     this.verticesY[var11] += field1912;
                     this.verticesZ[var11] += field1913;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1884 != null && this.field1875 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1884.length) {
                     var18 = this.field1884[var8];

                     for(var19 = 0; var19 < var18.length; ++var19) {
                        var11 = var18[var19];
                        var12 = (this.field1875[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1875[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("as")
   void vmethod2373(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1901[0] = -1;
      if(this.field1886 != 1) {
         this.method2377();
      }

      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1888 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1888) * class94.field1631;
         if(var15 / var13 < class94.field1637) {
            int var16 = (var14 + this.field1888) * class94.field1631;
            if(var16 / var13 > class94.field1636) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1888 * var2 >> 16;
               int var19 = (var17 + var18) * class94.field1631;
               if(var19 / var13 > class94.field1638) {
                  int var20 = var18 + (super.modelHeight * var3 >> 16);
                  int var21 = (var17 - var20) * class94.field1631;
                  if(var21 / var13 < class94.field1627) {
                     int var22 = var12 + (super.modelHeight * var2 >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1879 > 0;
                     boolean var26 = false;
                     int var27;
                     int var28;
                     int var29;
                     if(var9 > 0 && field1859) {
                        var27 = var11 - var12;
                        if(var27 <= 50) {
                           var27 = 50;
                        }

                        if(var14 > 0) {
                           var15 /= var13;
                           var16 /= var27;
                        } else {
                           var16 /= var13;
                           var15 /= var27;
                        }

                        if(var17 > 0) {
                           var21 /= var13;
                           var19 /= var27;
                        } else {
                           var19 /= var13;
                           var21 /= var27;
                        }

                        var28 = field1908 - class94.field1632;
                        var29 = field1920 - class94.field1633;
                        if(var28 > var15 && var28 < var16 && var29 > var21 && var29 < var19) {
                           if(this.field1915) {
                              field1892[field1917++] = var9;
                           } else {
                              var26 = true;
                           }
                        }
                     }

                     var27 = class94.field1632;
                     var28 = class94.field1633;
                     var29 = 0;
                     int var30 = 0;
                     if(var1 != 0) {
                        var29 = field1919[var1];
                        var30 = field1864[var1];
                     }

                     for(int var31 = 0; var31 < this.field1863; ++var31) {
                        int var32 = this.verticesX[var31];
                        int var33 = this.verticesY[var31];
                        int var34 = this.verticesZ[var31];
                        int var35;
                        if(var1 != 0) {
                           var35 = var34 * var29 + var32 * var30 >> 16;
                           var34 = var34 * var30 - var32 * var29 >> 16;
                           var32 = var35;
                        }

                        var32 += var6;
                        var33 += var7;
                        var34 += var8;
                        var35 = var34 * var4 + var32 * var5 >> 16;
                        var34 = var34 * var5 - var32 * var4 >> 16;
                        var32 = var35;
                        var35 = var33 * var3 - var34 * var2 >> 16;
                        var34 = var33 * var2 + var34 * var3 >> 16;
                        field1896[var31] = var34 - var11;
                        if(var34 >= 50) {
                           field1902[var31] = var27 + var32 * class94.field1631 / var34;
                           field1874[var31] = var28 + var35 * class94.field1631 / var34;
                        } else {
                           field1902[var31] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1877[var31] = var32;
                           field1898[var31] = var35;
                           field1899[var31] = var34;
                        }
                     }

                     try {
                        this.method2327(var23, var26, var9);
                     } catch (Exception var37) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("b")
   public void method2377() {
      if(this.field1886 != 1) {
         this.field1886 = 1;
         super.modelHeight = 0;
         this.field1887 = 0;
         this.field1888 = 0;

         for(int var1 = 0; var1 < this.field1863; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1887) {
               this.field1887 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1888) {
               this.field1888 = var5;
            }
         }

         this.field1888 = (int)(Math.sqrt((double)this.field1888) + 0.99D);
         this.field1890 = (int)(Math.sqrt((double)(this.field1888 * this.field1888 + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1889 = this.field1890 + (int)(Math.sqrt((double)(this.field1888 * this.field1888 + this.field1887 * this.field1887)) + 0.99D);
      }
   }
}
