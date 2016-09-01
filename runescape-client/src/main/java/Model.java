import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dj")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("t")
   int[] field1855;
   @ObfuscatedName("aw")
   static int[][] field1856 = new int[1600][512];
   @ObfuscatedName("j")
   static Model field1857 = new Model();
   @ObfuscatedName("z")
   static byte[] field1858 = new byte[1];
   @ObfuscatedName("i")
   int field1859 = 0;
   @ObfuscatedName("b")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("l")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("m")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("p")
   int field1863 = 0;
   @ObfuscatedName("f")
   @Export("indices1")
   int[] indices1;
   @ObfuscatedName("d")
   @Export("indices2")
   int[] indices2;
   @ObfuscatedName("ah")
   public boolean field1866 = false;
   @ObfuscatedName("ac")
   static int[] field1867 = new int[1600];
   @ObfuscatedName("bh")
   static int field1868;
   @ObfuscatedName("g")
   int[] field1869;
   @ObfuscatedName("s")
   byte[] field1870;
   @ObfuscatedName("x")
   static Model field1871 = new Model();
   @ObfuscatedName("u")
   byte[] field1872;
   @ObfuscatedName("ad")
   static int[] field1873 = new int[4700];
   @ObfuscatedName("e")
   byte field1874 = 0;
   @ObfuscatedName("ai")
   static int[] field1875 = new int[10];
   @ObfuscatedName("n")
   int[] field1876;
   @ObfuscatedName("c")
   int field1877 = 0;
   @ObfuscatedName("bf")
   static int field1878;
   @ObfuscatedName("w")
   int[][] field1879;
   @ObfuscatedName("q")
   int[] field1880;
   @ObfuscatedName("an")
   int field1881;
   @ObfuscatedName("h")
   byte[] field1882;
   @ObfuscatedName("ag")
   int field1883;
   @ObfuscatedName("v")
   @Export("indices3")
   int[] indices3;
   @ObfuscatedName("aq")
   int field1885;
   @ObfuscatedName("ax")
   int field1886;
   @ObfuscatedName("al")
   static int[] field1888 = new int[10];
   @ObfuscatedName("ao")
   static boolean[] field1889 = new boolean[4700];
   @ObfuscatedName("af")
   static int[] field1890 = new int[4700];
   @ObfuscatedName("bx")
   static int field1891;
   @ObfuscatedName("ap")
   static boolean[] field1892 = new boolean[4700];
   @ObfuscatedName("at")
   static int[] field1893 = new int[4700];
   @ObfuscatedName("ay")
   static int[] field1894 = new int[4700];
   @ObfuscatedName("bk")
   static int[] field1895;
   @ObfuscatedName("k")
   int[] field1897;
   @ObfuscatedName("bg")
   public static int field1898 = 0;
   @ObfuscatedName("ak")
   static int[] field1899 = new int[12];
   @ObfuscatedName("ar")
   static int[][] field1900 = new int[12][2000];
   @ObfuscatedName("aa")
   static int[] field1901 = new int[2000];
   @ObfuscatedName("y")
   int[] field1902;
   @ObfuscatedName("aj")
   static int[] field1903 = new int[12];
   @ObfuscatedName("bu")
   public static int field1904 = 0;
   @ObfuscatedName("ab")
   static int[] field1905 = new int[4700];
   @ObfuscatedName("ae")
   static int[] field1906 = new int[10];
   @ObfuscatedName("au")
   static int[] field1907 = new int[4700];
   @ObfuscatedName("r")
   static byte[] field1908 = new byte[1];
   @ObfuscatedName("av")
   static int[] field1909 = new int[2000];
   @ObfuscatedName("bw")
   public static boolean field1910 = false;
   @ObfuscatedName("o")
   int[][] field1911;
   @ObfuscatedName("as")
   int field1912;
   @ObfuscatedName("bq")
   public static int field1913 = 0;
   @ObfuscatedName("bb")
   public static int[] field1914 = new int[1000];
   @ObfuscatedName("bz")
   static int[] field1915;
   @ObfuscatedName("a")
   short[] field1916;
   @ObfuscatedName("bl")
   static int[] field1917;
   @ObfuscatedName("be")
   static int[] field1918;

   @ObfuscatedName("z")
   public Model method2358(boolean var1) {
      if(!var1 && field1858.length < this.field1863) {
         field1858 = new byte[this.field1863 + 100];
      }

      return this.method2362(var1, field1857, field1858);
   }

   public Model(Model[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1859 = 0;
      this.field1863 = 0;
      this.field1877 = 0;
      this.field1874 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1859 += var8.field1859;
            this.field1863 += var8.field1863;
            this.field1877 += var8.field1877;
            if(var8.field1870 != null) {
               var3 = true;
            } else {
               if(this.field1874 == -1) {
                  this.field1874 = var8.field1874;
               }

               if(this.field1874 != var8.field1874) {
                  var3 = true;
               }
            }

            var4 |= var8.field1882 != null;
            var5 |= var8.field1916 != null;
            var6 |= var8.field1872 != null;
         }
      }

      this.verticesX = new int[this.field1859];
      this.verticesY = new int[this.field1859];
      this.verticesZ = new int[this.field1859];
      this.indices1 = new int[this.field1863];
      this.indices2 = new int[this.field1863];
      this.indices3 = new int[this.field1863];
      this.field1880 = new int[this.field1863];
      this.field1855 = new int[this.field1863];
      this.field1869 = new int[this.field1863];
      if(var3) {
         this.field1870 = new byte[this.field1863];
      }

      if(var4) {
         this.field1882 = new byte[this.field1863];
      }

      if(var5) {
         this.field1916 = new short[this.field1863];
      }

      if(var6) {
         this.field1872 = new byte[this.field1863];
      }

      if(this.field1877 > 0) {
         this.field1876 = new int[this.field1877];
         this.field1902 = new int[this.field1877];
         this.field1897 = new int[this.field1877];
      }

      this.field1859 = 0;
      this.field1863 = 0;
      this.field1877 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1863; ++var9) {
               this.indices1[this.field1863] = var8.indices1[var9] + this.field1859;
               this.indices2[this.field1863] = var8.indices2[var9] + this.field1859;
               this.indices3[this.field1863] = var8.indices3[var9] + this.field1859;
               this.field1880[this.field1863] = var8.field1880[var9];
               this.field1855[this.field1863] = var8.field1855[var9];
               this.field1869[this.field1863] = var8.field1869[var9];
               if(var3) {
                  if(var8.field1870 != null) {
                     this.field1870[this.field1863] = var8.field1870[var9];
                  } else {
                     this.field1870[this.field1863] = var8.field1874;
                  }
               }

               if(var4 && var8.field1882 != null) {
                  this.field1882[this.field1863] = var8.field1882[var9];
               }

               if(var5) {
                  if(var8.field1916 != null) {
                     this.field1916[this.field1863] = var8.field1916[var9];
                  } else {
                     this.field1916[this.field1863] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1872 != null && var8.field1872[var9] != -1) {
                     this.field1872[this.field1863] = (byte)(var8.field1872[var9] + this.field1877);
                  } else {
                     this.field1872[this.field1863] = -1;
                  }
               }

               ++this.field1863;
            }

            for(var9 = 0; var9 < var8.field1877; ++var9) {
               this.field1876[this.field1877] = var8.field1876[var9] + this.field1859;
               this.field1902[this.field1877] = var8.field1902[var9] + this.field1859;
               this.field1897[this.field1877] = var8.field1897[var9] + this.field1859;
               ++this.field1877;
            }

            for(var9 = 0; var9 < var8.field1859; ++var9) {
               this.verticesX[this.field1859] = var8.verticesX[var9];
               this.verticesY[this.field1859] = var8.verticesY[var9];
               this.verticesZ[this.field1859] = var8.verticesZ[var9];
               ++this.field1859;
            }
         }
      }

   }

   @ObfuscatedName("x")
   public Model method2359(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2391();
      int var7 = var2 - this.field1912;
      int var8 = var2 + this.field1912;
      int var9 = var4 - this.field1912;
      int var10 = var4 + this.field1912;
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
               var11.field1859 = this.field1859;
               var11.field1863 = this.field1863;
               var11.field1877 = this.field1877;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1880 = this.field1880;
               var11.field1855 = this.field1855;
               var11.field1869 = this.field1869;
               var11.field1870 = this.field1870;
               var11.field1882 = this.field1882;
               var11.field1872 = this.field1872;
               var11.field1916 = this.field1916;
               var11.field1874 = this.field1874;
               var11.field1876 = this.field1876;
               var11.field1902 = this.field1902;
               var11.field1897 = this.field1897;
               var11.field1879 = this.field1879;
               var11.field1911 = this.field1911;
               var11.field1866 = this.field1866;
               var11.verticesY = new int[var11.field1859];
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
               for(var12 = 0; var12 < var11.field1859; ++var12) {
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
               for(var12 = 0; var12 < var11.field1859; ++var12) {
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

            var11.field1881 = 0;
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("r")
   public Model method2360(boolean var1) {
      if(!var1 && field1908.length < this.field1863) {
         field1908 = new byte[this.field1863 + 100];
      }

      return this.method2362(var1, field1871, field1908);
   }

   @ObfuscatedName("i")
   Model method2362(boolean var1, Model var2, byte[] var3) {
      var2.field1859 = this.field1859;
      var2.field1863 = this.field1863;
      var2.field1877 = this.field1877;
      if(var2.verticesX == null || var2.verticesX.length < this.field1859) {
         var2.verticesX = new int[this.field1859 + 100];
         var2.verticesY = new int[this.field1859 + 100];
         var2.verticesZ = new int[this.field1859 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1859; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if(var1) {
         var2.field1882 = this.field1882;
      } else {
         var2.field1882 = var3;
         if(this.field1882 == null) {
            for(var4 = 0; var4 < this.field1863; ++var4) {
               var2.field1882[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1863; ++var4) {
               var2.field1882[var4] = this.field1882[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1880 = this.field1880;
      var2.field1855 = this.field1855;
      var2.field1869 = this.field1869;
      var2.field1870 = this.field1870;
      var2.field1872 = this.field1872;
      var2.field1916 = this.field1916;
      var2.field1874 = this.field1874;
      var2.field1876 = this.field1876;
      var2.field1902 = this.field1902;
      var2.field1897 = this.field1897;
      var2.field1879 = this.field1879;
      var2.field1911 = this.field1911;
      var2.field1866 = this.field1866;
      var2.field1881 = 0;
      return var2;
   }

   @ObfuscatedName("l")
   void method2364() {
      if(this.field1881 != 2) {
         this.field1881 = 2;
         this.field1912 = 0;

         for(int var1 = 0; var1 < this.field1859; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1912) {
               this.field1912 = var5;
            }
         }

         this.field1912 = (int)(Math.sqrt((double)this.field1912) + 0.99D);
         this.field1886 = this.field1912;
         this.field1885 = this.field1912 + this.field1912;
      }
   }

   @ObfuscatedName("m")
   public int method2365() {
      this.method2391();
      return this.field1912;
   }

   @ObfuscatedName("c")
   public final void method2366(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1867[0] = -1;
      if(this.field1881 != 2 && this.field1881 != 1) {
         this.method2364();
      }

      int var8 = class94.field1617;
      int var9 = class94.field1627;
      int var10000 = field1915[var1];
      var10000 = field1895[var1];
      int var12 = field1915[var2];
      int var13 = field1895[var2];
      int var14 = field1915[var3];
      int var15 = field1895[var3];
      int var16 = field1915[var4];
      int var17 = field1895[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1859; ++var19) {
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
         field1905[var19] = var22 - var18;
         field1890[var19] = var8 + var20 * class94.field1626 / var22;
         field1907[var19] = var9 + var23 * class94.field1626 / var22;
         if(this.field1877 > 0) {
            field1893[var19] = var20;
            field1894[var19] = var23;
            field1873[var19] = var22;
         }
      }

      try {
         this.method2378(false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("f")
   public void method2367(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.field1832[var2];
            Frame var7 = var3.field1832[var4];
            FrameMap var8 = var6.field1586;
            field1878 = 0;
            field1891 = 0;
            field1868 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1596; ++var11) {
               for(var12 = var6.field1592[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field1821[var12] == 0) {
                  this.method2368(var8.field1821[var12], var8.field1819[var12], var6.field1593[var11], var6.field1588[var11], var6.field1595[var11]);
               }
            }

            field1878 = 0;
            field1891 = 0;
            field1868 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1596; ++var11) {
               for(var12 = var7.field1592[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field1821[var12] == 0) {
                  this.method2368(var8.field1821[var12], var8.field1819[var12], var7.field1593[var11], var7.field1588[var11], var7.field1595[var11]);
               }
            }

            this.field1881 = 0;
         } else {
            this.method2375(var1, var2);
         }
      }
   }

   @ObfuscatedName("d")
   void method2368(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1878 = 0;
         field1891 = 0;
         field1868 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var9 = var2[var8];
            if(var9 < this.field1879.length) {
               int[] var18 = this.field1879[var9];

               for(var11 = 0; var11 < var18.length; ++var11) {
                  var12 = var18[var11];
                  field1878 += this.verticesX[var12];
                  field1891 += this.verticesY[var12];
                  field1868 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1878 = field1878 / var7 + var3;
            field1891 = field1891 / var7 + var4;
            field1868 = field1868 / var7 + var5;
         } else {
            field1878 = var3;
            field1891 = var4;
            field1868 = var5;
         }

      } else {
         int var10;
         int[] var19;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1879.length) {
                  var19 = this.field1879[var8];

                  for(var10 = 0; var10 < var19.length; ++var10) {
                     var11 = var19[var10];
                     this.verticesX[var11] += var3;
                     this.verticesY[var11] += var4;
                     this.verticesZ[var11] += var5;
                  }
               }
            }

         } else if(var1 == 2) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1879.length) {
                  var19 = this.field1879[var8];

                  for(var10 = 0; var10 < var19.length; ++var10) {
                     var11 = var19[var10];
                     this.verticesX[var11] -= field1878;
                     this.verticesY[var11] -= field1891;
                     this.verticesZ[var11] -= field1868;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1915[var14];
                        var16 = field1895[var14];
                        var17 = this.verticesY[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesY[var11] = this.verticesY[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1915[var12];
                        var16 = field1895[var12];
                        var17 = this.verticesY[var11] * var16 - this.verticesZ[var11] * var15 >> 16;
                        this.verticesZ[var11] = this.verticesY[var11] * var15 + this.verticesZ[var11] * var16 >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1915[var13];
                        var16 = field1895[var13];
                        var17 = this.verticesZ[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesZ[var11] = this.verticesZ[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += field1878;
                     this.verticesY[var11] += field1891;
                     this.verticesZ[var11] += field1868;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1879.length) {
                  var19 = this.field1879[var8];

                  for(var10 = 0; var10 < var19.length; ++var10) {
                     var11 = var19[var10];
                     this.verticesX[var11] -= field1878;
                     this.verticesY[var11] -= field1891;
                     this.verticesZ[var11] -= field1868;
                     this.verticesX[var11] = this.verticesX[var11] * var3 / 128;
                     this.verticesY[var11] = this.verticesY[var11] * var4 / 128;
                     this.verticesZ[var11] = this.verticesZ[var11] * var5 / 128;
                     this.verticesX[var11] += field1878;
                     this.verticesY[var11] += field1891;
                     this.verticesZ[var11] += field1868;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1911 != null && this.field1882 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1911.length) {
                     var19 = this.field1911[var8];

                     for(var10 = 0; var10 < var19.length; ++var10) {
                        var11 = var19[var10];
                        var12 = (this.field1882[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1882[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("h")
   public void method2371() {
      for(int var1 = 0; var1 < this.field1859; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.field1881 = 0;
   }

   @ObfuscatedName("u")
   public void method2372(int var1) {
      int var2 = field1915[var1];
      int var3 = field1895[var1];

      for(int var4 = 0; var4 < this.field1859; ++var4) {
         int var5 = this.verticesY[var4] * var3 - this.verticesZ[var4] * var2 >> 16;
         this.verticesZ[var4] = this.verticesY[var4] * var2 + this.verticesZ[var4] * var3 >> 16;
         this.verticesY[var4] = var5;
      }

      this.field1881 = 0;
   }

   @ObfuscatedName("e")
   public void method2374(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1859; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = this.verticesY[var4] * var2 / 128;
         this.verticesZ[var4] = this.verticesZ[var4] * var3 / 128;
      }

      this.field1881 = 0;
   }

   @ObfuscatedName("p")
   public void method2375(Frames var1, int var2) {
      if(this.field1879 != null) {
         if(var2 != -1) {
            Frame var3 = var1.field1832[var2];
            FrameMap var4 = var3.field1586;
            field1878 = 0;
            field1891 = 0;
            field1868 = 0;

            for(int var5 = 0; var5 < var3.field1596; ++var5) {
               int var6 = var3.field1592[var5];
               this.method2368(var4.field1821[var6], var4.field1819[var6], var3.field1593[var5], var3.field1588[var5], var3.field1595[var5]);
            }

            this.field1881 = 0;
         }
      }
   }

   @ObfuscatedName("n")
   public final void method2376(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1867[0] = -1;
      if(this.field1881 != 2 && this.field1881 != 1) {
         this.method2364();
      }

      int var9 = class94.field1617;
      int var10 = class94.field1627;
      int var10000 = field1915[var1];
      var10000 = field1895[var1];
      int var13 = field1915[var2];
      int var14 = field1895[var2];
      int var15 = field1915[var3];
      int var16 = field1895[var3];
      int var17 = field1915[var4];
      int var18 = field1895[var4];
      int var19 = var6 * var17 + var7 * var18 >> 16;

      for(int var20 = 0; var20 < this.field1859; ++var20) {
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
         field1905[var20] = var23 - var19;
         field1890[var20] = var9 + var21 * class94.field1626 / var8;
         field1907[var20] = var10 + var24 * class94.field1626 / var8;
         if(this.field1877 > 0) {
            field1893[var20] = var21;
            field1894[var20] = var24;
            field1873[var20] = var23;
         }
      }

      try {
         this.method2378(false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("y")
   final void method2378(boolean var1, boolean var2, int var3) {
      if(this.field1885 < 1600) {
         int var4;
         for(var4 = 0; var4 < this.field1885; ++var4) {
            field1867[var4] = 0;
         }

         int var5;
         int var6;
         int var7;
         int var8;
         int var9;
         int var12;
         int var13;
         int var15;
         int var24;
         for(var4 = 0; var4 < this.field1863; ++var4) {
            if(this.field1869[var4] != -2) {
               var5 = this.indices1[var4];
               var6 = this.indices2[var4];
               var7 = this.indices3[var4];
               var8 = field1890[var5];
               var9 = field1890[var6];
               var24 = field1890[var7];
               int var11;
               if(var1 && (var8 == -5000 || var9 == -5000 || var24 == -5000)) {
                  var11 = field1893[var5];
                  var12 = field1893[var6];
                  var13 = field1893[var7];
                  int var25 = field1894[var5];
                  var15 = field1894[var6];
                  int var16 = field1894[var7];
                  int var17 = field1873[var5];
                  int var18 = field1873[var6];
                  int var19 = field1873[var7];
                  var11 -= var12;
                  var13 -= var12;
                  var25 -= var15;
                  var16 -= var15;
                  var17 -= var18;
                  var19 -= var18;
                  int var20 = var25 * var19 - var17 * var16;
                  int var21 = var17 * var13 - var11 * var19;
                  int var22 = var11 * var16 - var25 * var13;
                  if(var12 * var20 + var15 * var21 + var18 * var22 > 0) {
                     field1889[var4] = true;
                     int var23 = (field1905[var5] + field1905[var6] + field1905[var7]) / 3 + this.field1886;
                     field1856[var23][field1867[var23]++] = var4;
                  }
               } else {
                  if(var2 && this.method2381(field1898, field1904, field1907[var5], field1907[var6], field1907[var7], var8, var9, var24)) {
                     field1914[field1913++] = var3;
                     var2 = false;
                  }

                  if((var8 - var9) * (field1907[var7] - field1907[var6]) - (field1907[var5] - field1907[var6]) * (var24 - var9) > 0) {
                     field1889[var4] = false;
                     if(var8 >= 0 && var9 >= 0 && var24 >= 0 && var8 <= class94.rasterClipX && var9 <= class94.rasterClipX && var24 <= class94.rasterClipX) {
                        field1892[var4] = false;
                     } else {
                        field1892[var4] = true;
                     }

                     var11 = (field1905[var5] + field1905[var6] + field1905[var7]) / 3 + this.field1886;
                     field1856[var11][field1867[var11]++] = var4;
                  }
               }
            }
         }

         int[] var26;
         if(this.field1870 == null) {
            for(var4 = this.field1885 - 1; var4 >= 0; --var4) {
               var5 = field1867[var4];
               if(var5 > 0) {
                  var26 = field1856[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     this.method2379(var26[var7]);
                  }
               }
            }

         } else {
            for(var4 = 0; var4 < 12; ++var4) {
               field1899[var4] = 0;
               field1903[var4] = 0;
            }

            for(var4 = this.field1885 - 1; var4 >= 0; --var4) {
               var5 = field1867[var4];
               if(var5 > 0) {
                  var26 = field1856[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     var8 = var26[var7];
                     byte var28 = this.field1870[var8];
                     var24 = field1899[var28]++;
                     field1900[var28][var24] = var8;
                     if(var28 < 10) {
                        field1903[var28] += var4;
                     } else if(var28 == 10) {
                        field1901[var24] = var4;
                     } else {
                        field1909[var24] = var4;
                     }
                  }
               }
            }

            var4 = 0;
            if(field1899[1] > 0 || field1899[2] > 0) {
               var4 = (field1903[1] + field1903[2]) / (field1899[1] + field1899[2]);
            }

            var5 = 0;
            if(field1899[3] > 0 || field1899[4] > 0) {
               var5 = (field1903[3] + field1903[4]) / (field1899[3] + field1899[4]);
            }

            var6 = 0;
            if(field1899[6] > 0 || field1899[8] > 0) {
               var6 = (field1903[6] + field1903[8]) / (field1899[6] + field1899[8]);
            }

            var8 = 0;
            var9 = field1899[10];
            int[] var10 = field1900[10];
            int[] var27 = field1901;
            if(var8 == var9) {
               var8 = 0;
               var9 = field1899[11];
               var10 = field1900[11];
               var27 = field1909;
            }

            if(var8 < var9) {
               var7 = var27[var8];
            } else {
               var7 = -1000;
            }

            for(var12 = 0; var12 < 10; ++var12) {
               while(var12 == 0 && var7 > var4) {
                  this.method2379(var10[var8++]);
                  if(var8 == var9 && var10 != field1900[11]) {
                     var8 = 0;
                     var9 = field1899[11];
                     var10 = field1900[11];
                     var27 = field1909;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 3 && var7 > var5) {
                  this.method2379(var10[var8++]);
                  if(var8 == var9 && var10 != field1900[11]) {
                     var8 = 0;
                     var9 = field1899[11];
                     var10 = field1900[11];
                     var27 = field1909;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 5 && var7 > var6) {
                  this.method2379(var10[var8++]);
                  if(var8 == var9 && var10 != field1900[11]) {
                     var8 = 0;
                     var9 = field1899[11];
                     var10 = field1900[11];
                     var27 = field1909;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               var13 = field1899[var12];
               int[] var14 = field1900[var12];

               for(var15 = 0; var15 < var13; ++var15) {
                  this.method2379(var14[var15]);
               }
            }

            while(var7 != -1000) {
               this.method2379(var10[var8++]);
               if(var8 == var9 && var10 != field1900[11]) {
                  var8 = 0;
                  var10 = field1900[11];
                  var9 = field1899[11];
                  var27 = field1909;
               }

               if(var8 < var9) {
                  var7 = var27[var8];
               } else {
                  var7 = -1000;
               }
            }

         }
      }
   }

   @ObfuscatedName("k")
   final void method2379(int var1) {
      if(field1889[var1]) {
         this.method2380(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         class94.rasterClipEnable = field1892[var1];
         if(this.field1882 == null) {
            class94.rasterAlpha = 0;
         } else {
            class94.rasterAlpha = this.field1882[var1] & 255;
         }

         if(this.field1916 != null && this.field1916[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1872 != null && this.field1872[var1] != -1) {
               int var8 = this.field1872[var1] & 255;
               var5 = this.field1876[var8];
               var6 = this.field1902[var8];
               var7 = this.field1897[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1869[var1] == -1) {
               class94.rasterTextureAffine(field1907[var2], field1907[var3], field1907[var4], field1890[var2], field1890[var3], field1890[var4], this.field1880[var1], this.field1880[var1], this.field1880[var1], field1893[var5], field1893[var6], field1893[var7], field1894[var5], field1894[var6], field1894[var7], field1873[var5], field1873[var6], field1873[var7], this.field1916[var1]);
            } else {
               class94.rasterTextureAffine(field1907[var2], field1907[var3], field1907[var4], field1890[var2], field1890[var3], field1890[var4], this.field1880[var1], this.field1855[var1], this.field1869[var1], field1893[var5], field1893[var6], field1893[var7], field1894[var5], field1894[var6], field1894[var7], field1873[var5], field1873[var6], field1873[var7], this.field1916[var1]);
            }
         } else if(this.field1869[var1] == -1) {
            class94.rasterFlat(field1907[var2], field1907[var3], field1907[var4], field1890[var2], field1890[var3], field1890[var4], field1917[this.field1880[var1]]);
         } else {
            class94.rasterGouraud(field1907[var2], field1907[var3], field1907[var4], field1890[var2], field1890[var3], field1890[var4], this.field1880[var1], this.field1855[var1], this.field1869[var1]);
         }

      }
   }

   @ObfuscatedName("w")
   final void method2380(int var1) {
      int var2 = class94.field1617;
      int var3 = class94.field1627;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1873[var5];
      int var9 = field1873[var6];
      int var10 = field1873[var7];
      if(this.field1882 == null) {
         class94.rasterAlpha = 0;
      } else {
         class94.rasterAlpha = this.field1882[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1888[var4] = field1890[var5];
         field1875[var4] = field1907[var5];
         field1906[var4++] = this.field1880[var1];
      } else {
         var11 = field1893[var5];
         var12 = field1894[var5];
         var13 = this.field1880[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1918[var10 - var8];
            field1888[var4] = var2 + (var11 + ((field1893[var7] - var11) * var14 >> 16)) * class94.field1626 / 50;
            field1875[var4] = var3 + (var12 + ((field1894[var7] - var12) * var14 >> 16)) * class94.field1626 / 50;
            field1906[var4++] = var13 + ((this.field1869[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1918[var9 - var8];
            field1888[var4] = var2 + (var11 + ((field1893[var6] - var11) * var14 >> 16)) * class94.field1626 / 50;
            field1875[var4] = var3 + (var12 + ((field1894[var6] - var12) * var14 >> 16)) * class94.field1626 / 50;
            field1906[var4++] = var13 + ((this.field1855[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1888[var4] = field1890[var6];
         field1875[var4] = field1907[var6];
         field1906[var4++] = this.field1855[var1];
      } else {
         var11 = field1893[var6];
         var12 = field1894[var6];
         var13 = this.field1855[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1918[var8 - var9];
            field1888[var4] = var2 + (var11 + ((field1893[var5] - var11) * var14 >> 16)) * class94.field1626 / 50;
            field1875[var4] = var3 + (var12 + ((field1894[var5] - var12) * var14 >> 16)) * class94.field1626 / 50;
            field1906[var4++] = var13 + ((this.field1880[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1918[var10 - var9];
            field1888[var4] = var2 + (var11 + ((field1893[var7] - var11) * var14 >> 16)) * class94.field1626 / 50;
            field1875[var4] = var3 + (var12 + ((field1894[var7] - var12) * var14 >> 16)) * class94.field1626 / 50;
            field1906[var4++] = var13 + ((this.field1869[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1888[var4] = field1890[var7];
         field1875[var4] = field1907[var7];
         field1906[var4++] = this.field1869[var1];
      } else {
         var11 = field1893[var7];
         var12 = field1894[var7];
         var13 = this.field1869[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1918[var9 - var10];
            field1888[var4] = var2 + (var11 + ((field1893[var6] - var11) * var14 >> 16)) * class94.field1626 / 50;
            field1875[var4] = var3 + (var12 + ((field1894[var6] - var12) * var14 >> 16)) * class94.field1626 / 50;
            field1906[var4++] = var13 + ((this.field1855[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1918[var8 - var10];
            field1888[var4] = var2 + (var11 + ((field1893[var5] - var11) * var14 >> 16)) * class94.field1626 / 50;
            field1875[var4] = var3 + (var12 + ((field1894[var5] - var12) * var14 >> 16)) * class94.field1626 / 50;
            field1906[var4++] = var13 + ((this.field1880[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1888[0];
      var12 = field1888[1];
      var13 = field1888[2];
      var14 = field1875[0];
      int var15 = field1875[1];
      int var16 = field1875[2];
      class94.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class94.rasterClipX || var12 > class94.rasterClipX || var13 > class94.rasterClipX) {
            class94.rasterClipEnable = true;
         }

         if(this.field1916 != null && this.field1916[var1] != -1) {
            if(this.field1872 != null && this.field1872[var1] != -1) {
               var20 = this.field1872[var1] & 255;
               var17 = this.field1876[var20];
               var18 = this.field1902[var20];
               var19 = this.field1897[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1869[var1] == -1) {
               class94.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1880[var1], this.field1880[var1], this.field1880[var1], field1893[var17], field1893[var18], field1893[var19], field1894[var17], field1894[var18], field1894[var19], field1873[var17], field1873[var18], field1873[var19], this.field1916[var1]);
            } else {
               class94.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1906[0], field1906[1], field1906[2], field1893[var17], field1893[var18], field1893[var19], field1894[var17], field1894[var18], field1894[var19], field1873[var17], field1873[var18], field1873[var19], this.field1916[var1]);
            }
         } else if(this.field1869[var1] == -1) {
            class94.rasterFlat(var14, var15, var16, var11, var12, var13, field1917[this.field1880[var1]]);
         } else {
            class94.rasterGouraud(var14, var15, var16, var11, var12, var13, field1906[0], field1906[1], field1906[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class94.rasterClipX || var12 > class94.rasterClipX || var13 > class94.rasterClipX || field1888[3] < 0 || field1888[3] > class94.rasterClipX) {
            class94.rasterClipEnable = true;
         }

         if(this.field1916 != null && this.field1916[var1] != -1) {
            if(this.field1872 != null && this.field1872[var1] != -1) {
               var20 = this.field1872[var1] & 255;
               var17 = this.field1876[var20];
               var18 = this.field1902[var20];
               var19 = this.field1897[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1916[var1];
            if(this.field1869[var1] == -1) {
               class94.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1880[var1], this.field1880[var1], this.field1880[var1], field1893[var17], field1893[var18], field1893[var19], field1894[var17], field1894[var18], field1894[var19], field1873[var17], field1873[var18], field1873[var19], var21);
               class94.rasterTextureAffine(var14, var16, field1875[3], var11, var13, field1888[3], this.field1880[var1], this.field1880[var1], this.field1880[var1], field1893[var17], field1893[var18], field1893[var19], field1894[var17], field1894[var18], field1894[var19], field1873[var17], field1873[var18], field1873[var19], var21);
            } else {
               class94.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1906[0], field1906[1], field1906[2], field1893[var17], field1893[var18], field1893[var19], field1894[var17], field1894[var18], field1894[var19], field1873[var17], field1873[var18], field1873[var19], var21);
               class94.rasterTextureAffine(var14, var16, field1875[3], var11, var13, field1888[3], field1906[0], field1906[2], field1906[3], field1893[var17], field1893[var18], field1893[var19], field1894[var17], field1894[var18], field1894[var19], field1873[var17], field1873[var18], field1873[var19], var21);
            }
         } else if(this.field1869[var1] == -1) {
            var17 = field1917[this.field1880[var1]];
            class94.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            class94.rasterFlat(var14, var16, field1875[3], var11, var13, field1888[3], var17);
         } else {
            class94.rasterGouraud(var14, var15, var16, var11, var12, var13, field1906[0], field1906[1], field1906[2]);
            class94.rasterGouraud(var14, var16, field1875[3], var11, var13, field1888[3], field1906[0], field1906[2], field1906[3]);
         }
      }

   }

   @ObfuscatedName("o")
   final boolean method2381(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      return var2 < var3 && var2 < var4 && var2 < var5?false:(var2 > var3 && var2 > var4 && var2 > var5?false:(var1 < var6 && var1 < var7 && var1 < var8?false:var1 <= var6 || var1 <= var7 || var1 <= var8));
   }

   static {
      field1915 = class94.field1639;
      field1895 = class94.field1640;
      field1917 = class94.colorPalette;
      field1918 = class94.field1638;
   }

   @ObfuscatedName("b")
   public void method2391() {
      if(this.field1881 != 1) {
         this.field1881 = 1;
         super.modelHeight = 0;
         this.field1883 = 0;
         this.field1912 = 0;

         for(int var1 = 0; var1 < this.field1859; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1883) {
               this.field1883 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1912) {
               this.field1912 = var5;
            }
         }

         this.field1912 = (int)(Math.sqrt((double)this.field1912) + 0.99D);
         this.field1886 = (int)(Math.sqrt((double)(this.field1912 * this.field1912 + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1885 = this.field1886 + (int)(Math.sqrt((double)(this.field1912 * this.field1912 + this.field1883 * this.field1883)) + 0.99D);
      }
   }

   @ObfuscatedName("s")
   public void method2393() {
      for(int var1 = 0; var1 < this.field1859; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.field1881 = 0;
   }

   @ObfuscatedName("ay")
   void vmethod2412(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1867[0] = -1;
      if(this.field1881 != 1) {
         this.method2391();
      }

      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1912 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1912) * class94.field1626;
         if(var15 / var13 < class94.field1631) {
            int var16 = (var14 + this.field1912) * class94.field1626;
            if(var16 / var13 > class94.field1632) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1912 * var2 >> 16;
               int var19 = (var17 + var18) * class94.field1626;
               if(var19 / var13 > class94.field1616) {
                  int var20 = var18 + (super.modelHeight * var3 >> 16);
                  int var21 = (var17 - var20) * class94.field1626;
                  if(var21 / var13 < class94.field1633) {
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
                     if(var9 > 0 && field1910) {
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

                        var28 = field1898 - class94.field1617;
                        var29 = field1904 - class94.field1627;
                        if(var28 > var15 && var28 < var16 && var29 > var21 && var29 < var19) {
                           if(this.field1866) {
                              field1914[field1913++] = var9;
                           } else {
                              var26 = true;
                           }
                        }
                     }

                     var27 = class94.field1617;
                     var28 = class94.field1627;
                     var29 = 0;
                     int var30 = 0;
                     if(var1 != 0) {
                        var29 = field1915[var1];
                        var30 = field1895[var1];
                     }

                     for(int var31 = 0; var31 < this.field1859; ++var31) {
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
                        field1905[var31] = var34 - var11;
                        if(var34 >= 50) {
                           field1890[var31] = var27 + var32 * class94.field1626 / var34;
                           field1907[var31] = var28 + var35 * class94.field1626 / var34;
                        } else {
                           field1890[var31] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1893[var31] = var32;
                           field1894[var31] = var35;
                           field1873[var31] = var34;
                        }
                     }

                     try {
                        this.method2378(var23, var26, var9);
                     } catch (Exception var37) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   Model() {
   }

   @ObfuscatedName("a")
   public void method2429(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1859; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.field1881 = 0;
   }

   @ObfuscatedName("g")
   public void method2430() {
      for(int var1 = 0; var1 < this.field1859; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.field1881 = 0;
   }
}
