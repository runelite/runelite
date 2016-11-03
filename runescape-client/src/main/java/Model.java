import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dj")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("ap")
   static int[] field1857 = new int[4700];
   @ObfuscatedName("q")
   static byte[] field1858 = new byte[1];
   @ObfuscatedName("ay")
   static boolean[] field1859 = new boolean[4700];
   @ObfuscatedName("c")
   static byte[] field1860 = new byte[1];
   @ObfuscatedName("v")
   int field1861 = 0;
   @ObfuscatedName("j")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("ag")
   static boolean[] field1863 = new boolean[4700];
   @ObfuscatedName("y")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("u")
   int field1865 = 0;
   @ObfuscatedName("h")
   @Export("indices1")
   int[] indices1;
   @ObfuscatedName("bk")
   public static int field1867 = 0;
   @ObfuscatedName("b")
   @Export("indices3")
   int[] indices3;
   @ObfuscatedName("o")
   int[][] field1869;
   @ObfuscatedName("e")
   int[] field1870;
   @ObfuscatedName("g")
   int[] field1871;
   @ObfuscatedName("s")
   byte[] field1872;
   @ObfuscatedName("w")
   byte[] field1873;
   @ObfuscatedName("av")
   int field1874;
   @ObfuscatedName("r")
   short[] field1875;
   @ObfuscatedName("a")
   byte field1876 = 0;
   @ObfuscatedName("n")
   int field1877 = 0;
   @ObfuscatedName("l")
   @Export("indices2")
   int[] indices2;
   @ObfuscatedName("x")
   int[] field1879;
   @ObfuscatedName("d")
   int[] field1880;
   @ObfuscatedName("t")
   int[][] field1881;
   @ObfuscatedName("ah")
   static int[] field1883 = new int[10];
   @ObfuscatedName("al")
   int field1884;
   @ObfuscatedName("ao")
   static int[] field1885 = new int[4700];
   @ObfuscatedName("ad")
   int field1886;
   @ObfuscatedName("at")
   int field1887;
   @ObfuscatedName("z")
   int[] field1888;
   @ObfuscatedName("p")
   int[] field1890;
   @ObfuscatedName("ae")
   static int[] field1891 = new int[2000];
   @ObfuscatedName("aa")
   static int[] field1892 = new int[4700];
   @ObfuscatedName("ak")
   static int[] field1893 = new int[4700];
   @ObfuscatedName("ar")
   static int[] field1894 = new int[4700];
   @ObfuscatedName("ax")
   static int[] field1895 = new int[4700];
   @ObfuscatedName("m")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("bu")
   static int[] field1898;
   @ObfuscatedName("ai")
   static int[] field1899 = new int[1600];
   @ObfuscatedName("af")
   static int[][] field1900 = new int[1600][512];
   @ObfuscatedName("an")
   static int[] field1901 = new int[12];
   @ObfuscatedName("au")
   static int[][] field1902 = new int[12][2000];
   @ObfuscatedName("ac")
   static int[] field1903 = new int[2000];
   @ObfuscatedName("bz")
   public static int field1904 = 0;
   @ObfuscatedName("az")
   static int[] field1905 = new int[12];
   @ObfuscatedName("f")
   static Model field1906 = new Model();
   @ObfuscatedName("as")
   static int[] field1907 = new int[10];
   @ObfuscatedName("ab")
   static int[] field1908 = new int[10];
   @ObfuscatedName("bn")
   static int field1909;
   @ObfuscatedName("bl")
   static int field1910;
   @ObfuscatedName("aq")
   public boolean field1911 = false;
   @ObfuscatedName("bg")
   public static boolean field1912 = false;
   @ObfuscatedName("i")
   byte[] field1913;
   @ObfuscatedName("bq")
   static int field1914;
   @ObfuscatedName("bm")
   public static int field1915 = 0;
   @ObfuscatedName("bi")
   public static int[] field1916 = new int[1000];
   @ObfuscatedName("bt")
   static int[] field1917;
   @ObfuscatedName("bc")
   static int[] field1919;
   @ObfuscatedName("bw")
   static int[] field1920;
   @ObfuscatedName("k")
   static Model field1921 = new Model();
   @ObfuscatedName("aj")
   int field1922;

   static {
      field1917 = class94.field1650;
      field1898 = class94.field1651;
      field1919 = class94.colorPalette;
      field1920 = class94.field1649;
   }

   @ObfuscatedName("c")
   public Model method2364(boolean var1) {
      if(!var1 && field1860.length < this.field1865) {
         field1860 = new byte[this.field1865 + 100];
      }

      return this.method2365(var1, field1906, field1860);
   }

   @ObfuscatedName("v")
   Model method2365(boolean var1, Model var2, byte[] var3) {
      var2.field1861 = this.field1861;
      var2.field1865 = this.field1865;
      var2.field1877 = this.field1877;
      if(var2.verticesX == null || var2.verticesX.length < this.field1861) {
         var2.verticesX = new int[this.field1861 + 100];
         var2.verticesY = new int[this.field1861 + 100];
         var2.verticesZ = new int[this.field1861 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1861; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if(var1) {
         var2.field1873 = this.field1873;
      } else {
         var2.field1873 = var3;
         if(this.field1873 == null) {
            for(var4 = 0; var4 < this.field1865; ++var4) {
               var2.field1873[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1865; ++var4) {
               var2.field1873[var4] = this.field1873[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1871 = this.field1871;
      var2.field1870 = this.field1870;
      var2.field1890 = this.field1890;
      var2.field1872 = this.field1872;
      var2.field1913 = this.field1913;
      var2.field1875 = this.field1875;
      var2.field1876 = this.field1876;
      var2.field1888 = this.field1888;
      var2.field1879 = this.field1879;
      var2.field1880 = this.field1880;
      var2.field1881 = this.field1881;
      var2.field1869 = this.field1869;
      var2.field1911 = this.field1911;
      var2.field1884 = 0;
      return var2;
   }

   @ObfuscatedName("j")
   public void method2366() {
      if(this.field1884 != 1) {
         this.field1884 = 1;
         super.modelHeight = 0;
         this.field1874 = 0;
         this.field1886 = 0;

         for(int var1 = 0; var1 < this.field1861; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1874) {
               this.field1874 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1886) {
               this.field1886 = var5;
            }
         }

         this.field1886 = (int)(Math.sqrt((double)this.field1886) + 0.99D);
         this.field1922 = (int)(Math.sqrt((double)(this.field1886 * this.field1886 + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1887 = this.field1922 + (int)(Math.sqrt((double)(this.field1886 * this.field1886 + this.field1874 * this.field1874)) + 0.99D);
      }
   }

   @ObfuscatedName("k")
   public Model method2369(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2366();
      int var7 = var2 - this.field1886;
      int var8 = var2 + this.field1886;
      int var9 = var4 - this.field1886;
      int var10 = var4 + this.field1886;
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
               var11.field1861 = this.field1861;
               var11.field1865 = this.field1865;
               var11.field1877 = this.field1877;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1871 = this.field1871;
               var11.field1870 = this.field1870;
               var11.field1890 = this.field1890;
               var11.field1872 = this.field1872;
               var11.field1873 = this.field1873;
               var11.field1913 = this.field1913;
               var11.field1875 = this.field1875;
               var11.field1876 = this.field1876;
               var11.field1888 = this.field1888;
               var11.field1879 = this.field1879;
               var11.field1880 = this.field1880;
               var11.field1881 = this.field1881;
               var11.field1869 = this.field1869;
               var11.field1911 = this.field1911;
               var11.verticesY = new int[var11.field1861];
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
               for(var12 = 0; var12 < var11.field1861; ++var12) {
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
               for(var12 = 0; var12 < var11.field1861; ++var12) {
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

            var11.field1884 = 0;
            return var11;
         }
      } else {
         return this;
      }
   }

   public Model(Model[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1861 = 0;
      this.field1865 = 0;
      this.field1877 = 0;
      this.field1876 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1861 += var8.field1861;
            this.field1865 += var8.field1865;
            this.field1877 += var8.field1877;
            if(var8.field1872 != null) {
               var3 = true;
            } else {
               if(this.field1876 == -1) {
                  this.field1876 = var8.field1876;
               }

               if(this.field1876 != var8.field1876) {
                  var3 = true;
               }
            }

            var4 |= var8.field1873 != null;
            var5 |= var8.field1875 != null;
            var6 |= var8.field1913 != null;
         }
      }

      this.verticesX = new int[this.field1861];
      this.verticesY = new int[this.field1861];
      this.verticesZ = new int[this.field1861];
      this.indices1 = new int[this.field1865];
      this.indices2 = new int[this.field1865];
      this.indices3 = new int[this.field1865];
      this.field1871 = new int[this.field1865];
      this.field1870 = new int[this.field1865];
      this.field1890 = new int[this.field1865];
      if(var3) {
         this.field1872 = new byte[this.field1865];
      }

      if(var4) {
         this.field1873 = new byte[this.field1865];
      }

      if(var5) {
         this.field1875 = new short[this.field1865];
      }

      if(var6) {
         this.field1913 = new byte[this.field1865];
      }

      if(this.field1877 > 0) {
         this.field1888 = new int[this.field1877];
         this.field1879 = new int[this.field1877];
         this.field1880 = new int[this.field1877];
      }

      this.field1861 = 0;
      this.field1865 = 0;
      this.field1877 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1865; ++var9) {
               this.indices1[this.field1865] = var8.indices1[var9] + this.field1861;
               this.indices2[this.field1865] = var8.indices2[var9] + this.field1861;
               this.indices3[this.field1865] = var8.indices3[var9] + this.field1861;
               this.field1871[this.field1865] = var8.field1871[var9];
               this.field1870[this.field1865] = var8.field1870[var9];
               this.field1890[this.field1865] = var8.field1890[var9];
               if(var3) {
                  if(var8.field1872 != null) {
                     this.field1872[this.field1865] = var8.field1872[var9];
                  } else {
                     this.field1872[this.field1865] = var8.field1876;
                  }
               }

               if(var4 && var8.field1873 != null) {
                  this.field1873[this.field1865] = var8.field1873[var9];
               }

               if(var5) {
                  if(var8.field1875 != null) {
                     this.field1875[this.field1865] = var8.field1875[var9];
                  } else {
                     this.field1875[this.field1865] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1913 != null && var8.field1913[var9] != -1) {
                     this.field1913[this.field1865] = (byte)(var8.field1913[var9] + this.field1877);
                  } else {
                     this.field1913[this.field1865] = -1;
                  }
               }

               ++this.field1865;
            }

            for(var9 = 0; var9 < var8.field1877; ++var9) {
               this.field1888[this.field1877] = var8.field1888[var9] + this.field1861;
               this.field1879[this.field1877] = var8.field1879[var9] + this.field1861;
               this.field1880[this.field1877] = var8.field1880[var9] + this.field1861;
               ++this.field1877;
            }

            for(var9 = 0; var9 < var8.field1861; ++var9) {
               this.verticesX[this.field1861] = var8.verticesX[var9];
               this.verticesY[this.field1861] = var8.verticesY[var9];
               this.verticesZ[this.field1861] = var8.verticesZ[var9];
               ++this.field1861;
            }
         }
      }

   }

   @ObfuscatedName("b")
   public void method2371() {
      for(int var1 = 0; var1 < this.field1861; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.field1884 = 0;
   }

   @ObfuscatedName("g")
   public void method2372() {
      for(int var1 = 0; var1 < this.field1861; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.field1884 = 0;
   }

   @ObfuscatedName("e")
   public void method2373() {
      for(int var1 = 0; var1 < this.field1861; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.field1884 = 0;
   }

   @ObfuscatedName("p")
   public void method2374(int var1) {
      int var2 = field1917[var1];
      int var3 = field1898[var1];

      for(int var4 = 0; var4 < this.field1861; ++var4) {
         int var5 = this.verticesY[var4] * var3 - this.verticesZ[var4] * var2 >> 16;
         this.verticesZ[var4] = this.verticesY[var4] * var2 + this.verticesZ[var4] * var3 >> 16;
         this.verticesY[var4] = var5;
      }

      this.field1884 = 0;
   }

   @ObfuscatedName("a")
   public void method2375(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1861; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.field1884 = 0;
   }

   @ObfuscatedName("n")
   public void method2376(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1861; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = this.verticesY[var4] * var2 / 128;
         this.verticesZ[var4] = this.verticesZ[var4] * var3 / 128;
      }

      this.field1884 = 0;
   }

   @ObfuscatedName("z")
   public final void method2377(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1899[0] = -1;
      if(this.field1884 != 2 && this.field1884 != 1) {
         this.method2386();
      }

      int var8 = class94.field1640;
      int var9 = class94.field1638;
      int var10000 = field1917[var1];
      var10000 = field1898[var1];
      int var12 = field1917[var2];
      int var13 = field1898[var2];
      int var14 = field1917[var3];
      int var15 = field1898[var3];
      int var16 = field1917[var4];
      int var17 = field1898[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1861; ++var19) {
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
         field1894[var19] = var22 - var18;
         field1892[var19] = var8 + var20 * class94.field1636 / var22;
         field1893[var19] = var9 + var23 * class94.field1636 / var22;
         if(this.field1877 > 0) {
            field1895[var19] = var20;
            field1857[var19] = var23;
            field1885[var19] = var22;
         }
      }

      try {
         this.method2380(false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("x")
   public final void method2378(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1899[0] = -1;
      if(this.field1884 != 2 && this.field1884 != 1) {
         this.method2386();
      }

      int var9 = class94.field1640;
      int var10 = class94.field1638;
      int var10000 = field1917[var1];
      var10000 = field1898[var1];
      int var13 = field1917[var2];
      int var14 = field1898[var2];
      int var15 = field1917[var3];
      int var16 = field1898[var3];
      int var17 = field1917[var4];
      int var18 = field1898[var4];
      int var19 = var6 * var17 + var7 * var18 >> 16;

      for(int var20 = 0; var20 < this.field1861; ++var20) {
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
         field1894[var20] = var23 - var19;
         field1892[var20] = var9 + var21 * class94.field1636 / var8;
         field1893[var20] = var10 + var24 * class94.field1636 / var8;
         if(this.field1877 > 0) {
            field1895[var20] = var21;
            field1857[var20] = var24;
            field1885[var20] = var23;
         }
      }

      try {
         this.method2380(false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("d")
   final void method2380(boolean var1, boolean var2, int var3) {
      if(this.field1887 < 1600) {
         int var4;
         for(var4 = 0; var4 < this.field1887; ++var4) {
            field1899[var4] = 0;
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
         for(var4 = 0; var4 < this.field1865; ++var4) {
            if(this.field1890[var4] != -2) {
               var5 = this.indices1[var4];
               var6 = this.indices2[var4];
               var7 = this.indices3[var4];
               var8 = field1892[var5];
               var9 = field1892[var6];
               var10 = field1892[var7];
               int var11;
               if(var1 && (var8 == -5000 || var9 == -5000 || var10 == -5000)) {
                  var11 = field1895[var5];
                  var12 = field1895[var6];
                  var13 = field1895[var7];
                  int var14 = field1857[var5];
                  var15 = field1857[var6];
                  int var16 = field1857[var7];
                  int var17 = field1885[var5];
                  int var18 = field1885[var6];
                  int var19 = field1885[var7];
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
                     field1863[var4] = true;
                     int var23 = (field1894[var5] + field1894[var6] + field1894[var7]) / 3 + this.field1922;
                     field1900[var23][field1899[var23]++] = var4;
                  }
               } else {
                  if(var2 && this.method2416(field1867, field1904, field1893[var5], field1893[var6], field1893[var7], var8, var9, var10)) {
                     field1916[field1915++] = var3;
                     var2 = false;
                  }

                  if((var8 - var9) * (field1893[var7] - field1893[var6]) - (field1893[var5] - field1893[var6]) * (var10 - var9) > 0) {
                     field1863[var4] = false;
                     if(var8 >= 0 && var9 >= 0 && var10 >= 0 && var8 <= class94.rasterClipX && var9 <= class94.rasterClipX && var10 <= class94.rasterClipX) {
                        field1859[var4] = false;
                     } else {
                        field1859[var4] = true;
                     }

                     var11 = (field1894[var5] + field1894[var6] + field1894[var7]) / 3 + this.field1922;
                     field1900[var11][field1899[var11]++] = var4;
                  }
               }
            }
         }

         int[] var24;
         if(this.field1872 == null) {
            for(var4 = this.field1887 - 1; var4 >= 0; --var4) {
               var5 = field1899[var4];
               if(var5 > 0) {
                  var24 = field1900[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     this.method2381(var24[var7]);
                  }
               }
            }

         } else {
            for(var4 = 0; var4 < 12; ++var4) {
               field1901[var4] = 0;
               field1905[var4] = 0;
            }

            for(var4 = this.field1887 - 1; var4 >= 0; --var4) {
               var5 = field1899[var4];
               if(var5 > 0) {
                  var24 = field1900[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     var8 = var24[var7];
                     byte var28 = this.field1872[var8];
                     var10 = field1901[var28]++;
                     field1902[var28][var10] = var8;
                     if(var28 < 10) {
                        field1905[var28] += var4;
                     } else if(var28 == 10) {
                        field1903[var10] = var4;
                     } else {
                        field1891[var10] = var4;
                     }
                  }
               }
            }

            var4 = 0;
            if(field1901[1] > 0 || field1901[2] > 0) {
               var4 = (field1905[1] + field1905[2]) / (field1901[1] + field1901[2]);
            }

            var5 = 0;
            if(field1901[3] > 0 || field1901[4] > 0) {
               var5 = (field1905[3] + field1905[4]) / (field1901[3] + field1901[4]);
            }

            var6 = 0;
            if(field1901[6] > 0 || field1901[8] > 0) {
               var6 = (field1905[6] + field1905[8]) / (field1901[6] + field1901[8]);
            }

            var8 = 0;
            var9 = field1901[10];
            int[] var26 = field1902[10];
            int[] var25 = field1903;
            if(var8 == var9) {
               var8 = 0;
               var9 = field1901[11];
               var26 = field1902[11];
               var25 = field1891;
            }

            if(var8 < var9) {
               var7 = var25[var8];
            } else {
               var7 = -1000;
            }

            for(var12 = 0; var12 < 10; ++var12) {
               while(var12 == 0 && var7 > var4) {
                  this.method2381(var26[var8++]);
                  if(var8 == var9 && var26 != field1902[11]) {
                     var8 = 0;
                     var9 = field1901[11];
                     var26 = field1902[11];
                     var25 = field1891;
                  }

                  if(var8 < var9) {
                     var7 = var25[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 3 && var7 > var5) {
                  this.method2381(var26[var8++]);
                  if(var8 == var9 && var26 != field1902[11]) {
                     var8 = 0;
                     var9 = field1901[11];
                     var26 = field1902[11];
                     var25 = field1891;
                  }

                  if(var8 < var9) {
                     var7 = var25[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 5 && var7 > var6) {
                  this.method2381(var26[var8++]);
                  if(var8 == var9 && var26 != field1902[11]) {
                     var8 = 0;
                     var9 = field1901[11];
                     var26 = field1902[11];
                     var25 = field1891;
                  }

                  if(var8 < var9) {
                     var7 = var25[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               var13 = field1901[var12];
               int[] var27 = field1902[var12];

               for(var15 = 0; var15 < var13; ++var15) {
                  this.method2381(var27[var15]);
               }
            }

            while(var7 != -1000) {
               this.method2381(var26[var8++]);
               if(var8 == var9 && var26 != field1902[11]) {
                  var8 = 0;
                  var26 = field1902[11];
                  var9 = field1901[11];
                  var25 = field1891;
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

   @ObfuscatedName("t")
   final void method2381(int var1) {
      if(field1863[var1]) {
         this.method2415(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         class94.rasterClipEnable = field1859[var1];
         if(this.field1873 == null) {
            class94.rasterAlpha = 0;
         } else {
            class94.rasterAlpha = this.field1873[var1] & 255;
         }

         if(this.field1875 != null && this.field1875[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1913 != null && this.field1913[var1] != -1) {
               int var8 = this.field1913[var1] & 255;
               var5 = this.field1888[var8];
               var6 = this.field1879[var8];
               var7 = this.field1880[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1890[var1] == -1) {
               class94.rasterTextureAffine(field1893[var2], field1893[var3], field1893[var4], field1892[var2], field1892[var3], field1892[var4], this.field1871[var1], this.field1871[var1], this.field1871[var1], field1895[var5], field1895[var6], field1895[var7], field1857[var5], field1857[var6], field1857[var7], field1885[var5], field1885[var6], field1885[var7], this.field1875[var1]);
            } else {
               class94.rasterTextureAffine(field1893[var2], field1893[var3], field1893[var4], field1892[var2], field1892[var3], field1892[var4], this.field1871[var1], this.field1870[var1], this.field1890[var1], field1895[var5], field1895[var6], field1895[var7], field1857[var5], field1857[var6], field1857[var7], field1885[var5], field1885[var6], field1885[var7], this.field1875[var1]);
            }
         } else if(this.field1890[var1] == -1) {
            class94.rasterFlat(field1893[var2], field1893[var3], field1893[var4], field1892[var2], field1892[var3], field1892[var4], field1919[this.field1871[var1]]);
         } else {
            class94.rasterGouraud(field1893[var2], field1893[var3], field1893[var4], field1892[var2], field1892[var3], field1892[var4], this.field1871[var1], this.field1870[var1], this.field1890[var1]);
         }

      }
   }

   @ObfuscatedName("m")
   void method2386() {
      if(this.field1884 != 2) {
         this.field1884 = 2;
         this.field1886 = 0;

         for(int var1 = 0; var1 < this.field1861; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1886) {
               this.field1886 = var5;
            }
         }

         this.field1886 = (int)(Math.sqrt((double)this.field1886) + 0.99D);
         this.field1922 = this.field1886;
         this.field1887 = this.field1886 + this.field1886;
      }
   }

   Model() {
   }

   @ObfuscatedName("ac")
   void vmethod2392(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1899[0] = -1;
      if(this.field1884 != 1) {
         this.method2366();
      }

      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1886 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1886) * class94.field1636;
         if(var15 / var13 < class94.field1634) {
            int var16 = (var14 + this.field1886) * class94.field1636;
            if(var16 / var13 > class94.field1641) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1886 * var2 >> 16;
               int var19 = (var17 + var18) * class94.field1636;
               if(var19 / var13 > class94.field1643) {
                  int var20 = var18 + (super.modelHeight * var3 >> 16);
                  int var21 = (var17 - var20) * class94.field1636;
                  if(var21 / var13 < class94.field1627) {
                     int var22 = var12 + (super.modelHeight * var2 >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1877 > 0;
                     boolean var26 = false;
                     int var27;
                     int var28;
                     int var29;
                     if(var9 > 0 && field1912) {
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

                        var28 = field1867 - class94.field1640;
                        var29 = field1904 - class94.field1638;
                        if(var28 > var15 && var28 < var16 && var29 > var21 && var29 < var19) {
                           if(this.field1911) {
                              field1916[field1915++] = var9;
                           } else {
                              var26 = true;
                           }
                        }
                     }

                     var27 = class94.field1640;
                     var28 = class94.field1638;
                     var29 = 0;
                     int var30 = 0;
                     if(var1 != 0) {
                        var29 = field1917[var1];
                        var30 = field1898[var1];
                     }

                     for(int var31 = 0; var31 < this.field1861; ++var31) {
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
                        field1894[var31] = var34 - var11;
                        if(var34 >= 50) {
                           field1892[var31] = var27 + var32 * class94.field1636 / var34;
                           field1893[var31] = var28 + var35 * class94.field1636 / var34;
                        } else {
                           field1892[var31] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1895[var31] = var32;
                           field1857[var31] = var35;
                           field1885[var31] = var34;
                        }
                     }

                     try {
                        this.method2380(var23, var26, var9);
                     } catch (Exception var37) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("q")
   public Model method2402(boolean var1) {
      if(!var1 && field1858.length < this.field1865) {
         field1858 = new byte[this.field1865 + 100];
      }

      return this.method2365(var1, field1921, field1858);
   }

   @ObfuscatedName("o")
   final void method2415(int var1) {
      int var2 = class94.field1640;
      int var3 = class94.field1638;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1885[var5];
      int var9 = field1885[var6];
      int var10 = field1885[var7];
      if(this.field1873 == null) {
         class94.rasterAlpha = 0;
      } else {
         class94.rasterAlpha = this.field1873[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1883[var4] = field1892[var5];
         field1907[var4] = field1893[var5];
         field1908[var4++] = this.field1871[var1];
      } else {
         var11 = field1895[var5];
         var12 = field1857[var5];
         var13 = this.field1871[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1920[var10 - var8];
            field1883[var4] = var2 + (var11 + ((field1895[var7] - var11) * var14 >> 16)) * class94.field1636 / 50;
            field1907[var4] = var3 + (var12 + ((field1857[var7] - var12) * var14 >> 16)) * class94.field1636 / 50;
            field1908[var4++] = var13 + ((this.field1890[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1920[var9 - var8];
            field1883[var4] = var2 + (var11 + ((field1895[var6] - var11) * var14 >> 16)) * class94.field1636 / 50;
            field1907[var4] = var3 + (var12 + ((field1857[var6] - var12) * var14 >> 16)) * class94.field1636 / 50;
            field1908[var4++] = var13 + ((this.field1870[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1883[var4] = field1892[var6];
         field1907[var4] = field1893[var6];
         field1908[var4++] = this.field1870[var1];
      } else {
         var11 = field1895[var6];
         var12 = field1857[var6];
         var13 = this.field1870[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1920[var8 - var9];
            field1883[var4] = var2 + (var11 + ((field1895[var5] - var11) * var14 >> 16)) * class94.field1636 / 50;
            field1907[var4] = var3 + (var12 + ((field1857[var5] - var12) * var14 >> 16)) * class94.field1636 / 50;
            field1908[var4++] = var13 + ((this.field1871[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1920[var10 - var9];
            field1883[var4] = var2 + (var11 + ((field1895[var7] - var11) * var14 >> 16)) * class94.field1636 / 50;
            field1907[var4] = var3 + (var12 + ((field1857[var7] - var12) * var14 >> 16)) * class94.field1636 / 50;
            field1908[var4++] = var13 + ((this.field1890[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1883[var4] = field1892[var7];
         field1907[var4] = field1893[var7];
         field1908[var4++] = this.field1890[var1];
      } else {
         var11 = field1895[var7];
         var12 = field1857[var7];
         var13 = this.field1890[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1920[var9 - var10];
            field1883[var4] = var2 + (var11 + ((field1895[var6] - var11) * var14 >> 16)) * class94.field1636 / 50;
            field1907[var4] = var3 + (var12 + ((field1857[var6] - var12) * var14 >> 16)) * class94.field1636 / 50;
            field1908[var4++] = var13 + ((this.field1870[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1920[var8 - var10];
            field1883[var4] = var2 + (var11 + ((field1895[var5] - var11) * var14 >> 16)) * class94.field1636 / 50;
            field1907[var4] = var3 + (var12 + ((field1857[var5] - var12) * var14 >> 16)) * class94.field1636 / 50;
            field1908[var4++] = var13 + ((this.field1871[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1883[0];
      var12 = field1883[1];
      var13 = field1883[2];
      var14 = field1907[0];
      int var15 = field1907[1];
      int var16 = field1907[2];
      class94.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class94.rasterClipX || var12 > class94.rasterClipX || var13 > class94.rasterClipX) {
            class94.rasterClipEnable = true;
         }

         if(this.field1875 != null && this.field1875[var1] != -1) {
            if(this.field1913 != null && this.field1913[var1] != -1) {
               var20 = this.field1913[var1] & 255;
               var17 = this.field1888[var20];
               var18 = this.field1879[var20];
               var19 = this.field1880[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1890[var1] == -1) {
               class94.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1871[var1], this.field1871[var1], this.field1871[var1], field1895[var17], field1895[var18], field1895[var19], field1857[var17], field1857[var18], field1857[var19], field1885[var17], field1885[var18], field1885[var19], this.field1875[var1]);
            } else {
               class94.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1908[0], field1908[1], field1908[2], field1895[var17], field1895[var18], field1895[var19], field1857[var17], field1857[var18], field1857[var19], field1885[var17], field1885[var18], field1885[var19], this.field1875[var1]);
            }
         } else if(this.field1890[var1] == -1) {
            class94.rasterFlat(var14, var15, var16, var11, var12, var13, field1919[this.field1871[var1]]);
         } else {
            class94.rasterGouraud(var14, var15, var16, var11, var12, var13, field1908[0], field1908[1], field1908[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class94.rasterClipX || var12 > class94.rasterClipX || var13 > class94.rasterClipX || field1883[3] < 0 || field1883[3] > class94.rasterClipX) {
            class94.rasterClipEnable = true;
         }

         if(this.field1875 != null && this.field1875[var1] != -1) {
            if(this.field1913 != null && this.field1913[var1] != -1) {
               var20 = this.field1913[var1] & 255;
               var17 = this.field1888[var20];
               var18 = this.field1879[var20];
               var19 = this.field1880[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1875[var1];
            if(this.field1890[var1] == -1) {
               class94.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1871[var1], this.field1871[var1], this.field1871[var1], field1895[var17], field1895[var18], field1895[var19], field1857[var17], field1857[var18], field1857[var19], field1885[var17], field1885[var18], field1885[var19], var21);
               class94.rasterTextureAffine(var14, var16, field1907[3], var11, var13, field1883[3], this.field1871[var1], this.field1871[var1], this.field1871[var1], field1895[var17], field1895[var18], field1895[var19], field1857[var17], field1857[var18], field1857[var19], field1885[var17], field1885[var18], field1885[var19], var21);
            } else {
               class94.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1908[0], field1908[1], field1908[2], field1895[var17], field1895[var18], field1895[var19], field1857[var17], field1857[var18], field1857[var19], field1885[var17], field1885[var18], field1885[var19], var21);
               class94.rasterTextureAffine(var14, var16, field1907[3], var11, var13, field1883[3], field1908[0], field1908[2], field1908[3], field1895[var17], field1895[var18], field1895[var19], field1857[var17], field1857[var18], field1857[var19], field1885[var17], field1885[var18], field1885[var19], var21);
            }
         } else if(this.field1890[var1] == -1) {
            var17 = field1919[this.field1871[var1]];
            class94.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            class94.rasterFlat(var14, var16, field1907[3], var11, var13, field1883[3], var17);
         } else {
            class94.rasterGouraud(var14, var15, var16, var11, var12, var13, field1908[0], field1908[1], field1908[2]);
            class94.rasterGouraud(var14, var16, field1907[3], var11, var13, field1883[3], field1908[0], field1908[2], field1908[3]);
         }
      }

   }

   @ObfuscatedName("aq")
   final boolean method2416(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      return var2 < var3 && var2 < var4 && var2 < var5?false:(var2 > var3 && var2 > var4 && var2 > var5?false:(var1 < var6 && var1 < var7 && var1 < var8?false:var1 <= var6 || var1 <= var7 || var1 <= var8));
   }

   @ObfuscatedName("y")
   public int method2419() {
      this.method2366();
      return this.field1886;
   }

   @ObfuscatedName("l")
   void method2420(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1909 = 0;
         field1910 = 0;
         field1914 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var9 = var2[var8];
            if(var9 < this.field1881.length) {
               int[] var10 = this.field1881[var9];

               for(var11 = 0; var11 < var10.length; ++var11) {
                  var12 = var10[var11];
                  field1909 += this.verticesX[var12];
                  field1910 += this.verticesY[var12];
                  field1914 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1909 = field1909 / var7 + var3;
            field1910 = field1910 / var7 + var4;
            field1914 = field1914 / var7 + var5;
         } else {
            field1909 = var3;
            field1910 = var4;
            field1914 = var5;
         }

      } else {
         int[] var18;
         int var19;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1881.length) {
                  var18 = this.field1881[var8];

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
               if(var8 < this.field1881.length) {
                  var18 = this.field1881[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= field1909;
                     this.verticesY[var11] -= field1910;
                     this.verticesZ[var11] -= field1914;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1917[var14];
                        var16 = field1898[var14];
                        var17 = this.verticesY[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesY[var11] = this.verticesY[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1917[var12];
                        var16 = field1898[var12];
                        var17 = this.verticesY[var11] * var16 - this.verticesZ[var11] * var15 >> 16;
                        this.verticesZ[var11] = this.verticesY[var11] * var15 + this.verticesZ[var11] * var16 >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1917[var13];
                        var16 = field1898[var13];
                        var17 = this.verticesZ[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesZ[var11] = this.verticesZ[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += field1909;
                     this.verticesY[var11] += field1910;
                     this.verticesZ[var11] += field1914;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1881.length) {
                  var18 = this.field1881[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= field1909;
                     this.verticesY[var11] -= field1910;
                     this.verticesZ[var11] -= field1914;
                     this.verticesX[var11] = this.verticesX[var11] * var3 / 128;
                     this.verticesY[var11] = this.verticesY[var11] * var4 / 128;
                     this.verticesZ[var11] = this.verticesZ[var11] * var5 / 128;
                     this.verticesX[var11] += field1909;
                     this.verticesY[var11] += field1910;
                     this.verticesZ[var11] += field1914;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1869 != null && this.field1873 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1869.length) {
                     var18 = this.field1869[var8];

                     for(var19 = 0; var19 < var18.length; ++var19) {
                        var11 = var18[var19];
                        var12 = (this.field1873[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1873[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("u")
   public void method2428(Frames var1, int var2) {
      if(this.field1881 != null) {
         if(var2 != -1) {
            Frame var3 = var1.field1831[var2];
            FrameMap var4 = var3.field1601;
            field1909 = 0;
            field1910 = 0;
            field1914 = 0;

            for(int var5 = 0; var5 < var3.field1600; ++var5) {
               int var6 = var3.field1603[var5];
               this.method2420(var4.field1825[var6], var4.field1826[var6], var3.field1604[var5], var3.field1599[var5], var3.field1606[var5]);
            }

            this.field1884 = 0;
         }
      }
   }

   @ObfuscatedName("h")
   public void method2433(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.field1831[var2];
            Frame var7 = var3.field1831[var4];
            FrameMap var8 = var6.field1601;
            field1909 = 0;
            field1910 = 0;
            field1914 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1600; ++var11) {
               for(var12 = var6.field1603[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field1825[var12] == 0) {
                  this.method2420(var8.field1825[var12], var8.field1826[var12], var6.field1604[var11], var6.field1599[var11], var6.field1606[var11]);
               }
            }

            field1909 = 0;
            field1910 = 0;
            field1914 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1600; ++var11) {
               for(var12 = var7.field1603[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field1825[var12] == 0) {
                  this.method2420(var8.field1825[var12], var8.field1826[var12], var7.field1604[var11], var7.field1599[var11], var7.field1606[var11]);
               }
            }

            this.field1884 = 0;
         } else {
            this.method2428(var1, var2);
         }
      }
   }
}
