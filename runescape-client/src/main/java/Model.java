import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("do")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("by")
   public static boolean field1855 = false;
   @ObfuscatedName("r")
   int[] field1856;
   @ObfuscatedName("e")
   static Model field1857 = new Model();
   @ObfuscatedName("g")
   static byte[] field1858 = new byte[1];
   @ObfuscatedName("n")
   int field1859 = 0;
   @ObfuscatedName("u")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("bv")
   static int field1861;
   @ObfuscatedName("az")
   static int[] field1862 = new int[12];
   @ObfuscatedName("m")
   int field1863 = 0;
   @ObfuscatedName("bb")
   public static int field1864 = 0;
   @ObfuscatedName("y")
   @Export("indices2")
   int[] indices2;
   @ObfuscatedName("s")
   @Export("indices3")
   int[] indices3;
   @ObfuscatedName("af")
   int field1867;
   @ObfuscatedName("bx")
   public static int field1868 = 0;
   @ObfuscatedName("au")
   static int[] field1869 = new int[4700];
   @ObfuscatedName("l")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("p")
   int[] field1871;
   @ObfuscatedName("i")
   static Model field1872 = new Model();
   @ObfuscatedName("x")
   byte[] field1873;
   @ObfuscatedName("z")
   byte field1874 = 0;
   @ObfuscatedName("q")
   int field1875 = 0;
   @ObfuscatedName("ah")
   static int[] field1876 = new int[4700];
   @ObfuscatedName("f")
   int[] field1877;
   @ObfuscatedName("bj")
   static int[] field1878;
   @ObfuscatedName("t")
   int[][] field1879;
   @ObfuscatedName("a")
   int[][] field1880;
   @ObfuscatedName("am")
   public boolean field1881 = false;
   @ObfuscatedName("as")
   int field1882;
   @ObfuscatedName("ad")
   int field1883;
   @ObfuscatedName("k")
   short[] field1884;
   @ObfuscatedName("v")
   int[] field1885;
   @ObfuscatedName("aq")
   int field1886;
   @ObfuscatedName("ag")
   static boolean[] field1888 = new boolean[4700];
   @ObfuscatedName("al")
   static boolean[] field1889 = new boolean[4700];
   @ObfuscatedName("h")
   static byte[] field1890 = new byte[1];
   @ObfuscatedName("at")
   static int[] field1891 = new int[10];
   @ObfuscatedName("aw")
   static int[] field1892 = new int[4700];
   @ObfuscatedName("ae")
   static int[] field1893 = new int[10];
   @ObfuscatedName("ao")
   static int[] field1894 = new int[4700];
   @ObfuscatedName("ax")
   static int[] field1895 = new int[4700];
   @ObfuscatedName("ai")
   static int[] field1897 = new int[1600];
   @ObfuscatedName("ap")
   static int[][] field1898 = new int[1600][512];
   @ObfuscatedName("aa")
   static int[] field1899 = new int[12];
   @ObfuscatedName("ay")
   static int[][] field1900 = new int[12][2000];
   @ObfuscatedName("ab")
   static int[] field1901 = new int[2000];
   @ObfuscatedName("aj")
   static int[] field1902 = new int[2000];
   @ObfuscatedName("c")
   byte[] field1903;
   @ObfuscatedName("av")
   static int[] field1904 = new int[10];
   @ObfuscatedName("d")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("j")
   @Export("indices1")
   int[] indices1;
   @ObfuscatedName("bc")
   static int field1907;
   @ObfuscatedName("o")
   int[] field1908;
   @ObfuscatedName("bi")
   static int field1909;
   @ObfuscatedName("ak")
   int field1910;
   @ObfuscatedName("bu")
   public static int field1911 = 0;
   @ObfuscatedName("w")
   byte[] field1912;
   @ObfuscatedName("ar")
   static int[] field1913 = new int[4700];
   @ObfuscatedName("ba")
   public static int[] field1914 = new int[1000];
   @ObfuscatedName("bq")
   static int[] field1915;
   @ObfuscatedName("bs")
   static int[] field1916;
   @ObfuscatedName("bn")
   static int[] field1917;
   @ObfuscatedName("b")
   int[] field1918;

   @ObfuscatedName("r")
   void method2332(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1907 = 0;
         field1861 = 0;
         field1909 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var9 = var2[var8];
            if(var9 < this.field1879.length) {
               int[] var10 = this.field1879[var9];

               for(var11 = 0; var11 < var10.length; ++var11) {
                  var12 = var10[var11];
                  field1907 += this.verticesX[var12];
                  field1861 += this.verticesY[var12];
                  field1909 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1907 = field1907 / var7 + var3;
            field1861 = field1861 / var7 + var4;
            field1909 = field1909 / var7 + var5;
         } else {
            field1907 = var3;
            field1861 = var4;
            field1909 = var5;
         }

      } else {
         int[] var18;
         int var19;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1879.length) {
                  var18 = this.field1879[var8];

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
               if(var8 < this.field1879.length) {
                  var18 = this.field1879[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= field1907;
                     this.verticesY[var11] -= field1861;
                     this.verticesZ[var11] -= field1909;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1915[var14];
                        var16 = field1916[var14];
                        var17 = this.verticesY[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesY[var11] = this.verticesY[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1915[var12];
                        var16 = field1916[var12];
                        var17 = this.verticesY[var11] * var16 - this.verticesZ[var11] * var15 >> 16;
                        this.verticesZ[var11] = this.verticesY[var11] * var15 + this.verticesZ[var11] * var16 >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1915[var13];
                        var16 = field1916[var13];
                        var17 = this.verticesZ[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesZ[var11] = this.verticesZ[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += field1907;
                     this.verticesY[var11] += field1861;
                     this.verticesZ[var11] += field1909;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1879.length) {
                  var18 = this.field1879[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= field1907;
                     this.verticesY[var11] -= field1861;
                     this.verticesZ[var11] -= field1909;
                     this.verticesX[var11] = this.verticesX[var11] * var3 / 128;
                     this.verticesY[var11] = this.verticesY[var11] * var4 / 128;
                     this.verticesZ[var11] = this.verticesZ[var11] * var5 / 128;
                     this.verticesX[var11] += field1907;
                     this.verticesY[var11] += field1861;
                     this.verticesZ[var11] += field1909;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1880 != null && this.field1912 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1880.length) {
                     var18 = this.field1880[var8];

                     for(var19 = 0; var19 < var18.length; ++var19) {
                        var11 = var18[var19];
                        var12 = (this.field1912[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1912[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("n")
   Model method2333(boolean var1, Model var2, byte[] var3) {
      var2.field1859 = this.field1859;
      var2.field1863 = this.field1863;
      var2.field1875 = this.field1875;
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
         var2.field1912 = this.field1912;
      } else {
         var2.field1912 = var3;
         if(this.field1912 == null) {
            for(var4 = 0; var4 < this.field1863; ++var4) {
               var2.field1912[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1863; ++var4) {
               var2.field1912[var4] = this.field1912[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1871 = this.field1871;
      var2.field1885 = this.field1885;
      var2.field1856 = this.field1856;
      var2.field1903 = this.field1903;
      var2.field1873 = this.field1873;
      var2.field1884 = this.field1884;
      var2.field1874 = this.field1874;
      var2.field1908 = this.field1908;
      var2.field1877 = this.field1877;
      var2.field1918 = this.field1918;
      var2.field1879 = this.field1879;
      var2.field1880 = this.field1880;
      var2.field1881 = this.field1881;
      var2.field1882 = 0;
      return var2;
   }

   @ObfuscatedName("u")
   public void method2335() {
      if(this.field1882 != 1) {
         this.field1882 = 1;
         super.modelHeight = 0;
         this.field1883 = 0;
         this.field1867 = 0;

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
            if(var5 > this.field1867) {
               this.field1867 = var5;
            }
         }

         this.field1867 = (int)(Math.sqrt((double)this.field1867) + 0.99D);
         this.field1886 = (int)(Math.sqrt((double)(this.field1867 * this.field1867 + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1910 = this.field1886 + (int)(Math.sqrt((double)(this.field1867 * this.field1867 + this.field1883 * this.field1883)) + 0.99D);
      }
   }

   @ObfuscatedName("d")
   void method2336() {
      if(this.field1882 != 2) {
         this.field1882 = 2;
         this.field1867 = 0;

         for(int var1 = 0; var1 < this.field1859; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1867) {
               this.field1867 = var5;
            }
         }

         this.field1867 = (int)(Math.sqrt((double)this.field1867) + 0.99D);
         this.field1886 = this.field1867;
         this.field1910 = this.field1867 + this.field1867;
      }
   }

   @ObfuscatedName("l")
   public int method2337() {
      this.method2335();
      return this.field1867;
   }

   @ObfuscatedName("m")
   public void method2338(Frames var1, int var2) {
      if(this.field1879 != null) {
         if(var2 != -1) {
            Frame var3 = var1.field1834[var2];
            FrameMap var4 = var3.field1593;
            field1907 = 0;
            field1861 = 0;
            field1909 = 0;

            for(int var5 = 0; var5 < var3.field1594; ++var5) {
               int var6 = var3.field1595[var5];
               this.method2332(var4.field1818[var6], var4.field1820[var6], var3.field1596[var5], var3.field1597[var5], var3.field1589[var5]);
            }

            this.field1882 = 0;
         }
      }
   }

   @ObfuscatedName("j")
   public void method2339(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.field1834[var2];
            Frame var7 = var3.field1834[var4];
            FrameMap var8 = var6.field1593;
            field1907 = 0;
            field1861 = 0;
            field1909 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1594; ++var11) {
               for(var12 = var6.field1595[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field1818[var12] == 0) {
                  this.method2332(var8.field1818[var12], var8.field1820[var12], var6.field1596[var11], var6.field1597[var11], var6.field1589[var11]);
               }
            }

            field1907 = 0;
            field1861 = 0;
            field1909 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1594; ++var11) {
               for(var12 = var7.field1595[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field1818[var12] == 0) {
                  this.method2332(var8.field1818[var12], var8.field1820[var12], var7.field1596[var11], var7.field1597[var11], var7.field1589[var11]);
               }
            }

            this.field1882 = 0;
         } else {
            this.method2338(var1, var2);
         }
      }
   }

   @ObfuscatedName("c")
   public void method2341() {
      for(int var1 = 0; var1 < this.field1859; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.field1882 = 0;
   }

   @ObfuscatedName("x")
   public void method2343() {
      for(int var1 = 0; var1 < this.field1859; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.field1882 = 0;
   }

   @ObfuscatedName("k")
   public void method2344(int var1) {
      int var2 = field1915[var1];
      int var3 = field1916[var1];

      for(int var4 = 0; var4 < this.field1859; ++var4) {
         int var5 = this.verticesY[var4] * var3 - this.verticesZ[var4] * var2 >> 16;
         this.verticesZ[var4] = this.verticesY[var4] * var2 + this.verticesZ[var4] * var3 >> 16;
         this.verticesY[var4] = var5;
      }

      this.field1882 = 0;
   }

   @ObfuscatedName("z")
   public void method2345(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1859; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.field1882 = 0;
   }

   @ObfuscatedName("q")
   public void method2346(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1859; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = this.verticesY[var4] * var2 / 128;
         this.verticesZ[var4] = this.verticesZ[var4] * var3 / 128;
      }

      this.field1882 = 0;
   }

   @ObfuscatedName("o")
   public final void method2347(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1897[0] = -1;
      if(this.field1882 != 2 && this.field1882 != 1) {
         this.method2336();
      }

      int var8 = class94.field1619;
      int var9 = class94.field1629;
      int var10000 = field1915[var1];
      var10000 = field1916[var1];
      int var12 = field1915[var2];
      int var13 = field1916[var2];
      int var14 = field1915[var3];
      int var15 = field1916[var3];
      int var16 = field1915[var4];
      int var17 = field1916[var4];
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
         field1892[var19] = var22 - var18;
         field1869[var19] = var8 + var20 * class94.field1628 / var22;
         field1913[var19] = var9 + var23 * class94.field1628 / var22;
         if(this.field1875 > 0) {
            field1876[var19] = var20;
            field1894[var19] = var23;
            field1895[var19] = var22;
         }
      }

      try {
         this.method2350(false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("f")
   public final void method2348(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1897[0] = -1;
      if(this.field1882 != 2 && this.field1882 != 1) {
         this.method2336();
      }

      int var9 = class94.field1619;
      int var10 = class94.field1629;
      int var10000 = field1915[var1];
      var10000 = field1916[var1];
      int var13 = field1915[var2];
      int var14 = field1916[var2];
      int var15 = field1915[var3];
      int var16 = field1916[var3];
      int var17 = field1915[var4];
      int var18 = field1916[var4];
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
         field1892[var20] = var23 - var19;
         field1869[var20] = var9 + var21 * class94.field1628 / var8;
         field1913[var20] = var10 + var24 * class94.field1628 / var8;
         if(this.field1875 > 0) {
            field1876[var20] = var21;
            field1894[var20] = var24;
            field1895[var20] = var23;
         }
      }

      try {
         this.method2350(false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("b")
   final void method2350(boolean var1, boolean var2, int var3) {
      if(this.field1910 < 1600) {
         int var4;
         for(var4 = 0; var4 < this.field1910; ++var4) {
            field1897[var4] = 0;
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
         for(var4 = 0; var4 < this.field1863; ++var4) {
            if(this.field1856[var4] != -2) {
               var5 = this.indices1[var4];
               var6 = this.indices2[var4];
               var7 = this.indices3[var4];
               var8 = field1869[var5];
               var9 = field1869[var6];
               var10 = field1869[var7];
               int var24;
               if(!var1 || var8 != -5000 && var9 != -5000 && var10 != -5000) {
                  if(var2 && this.method2353(field1911, field1864, field1913[var5], field1913[var6], field1913[var7], var8, var9, var10)) {
                     field1914[field1868++] = var3;
                     var2 = false;
                  }

                  if((var8 - var9) * (field1913[var7] - field1913[var6]) - (field1913[var5] - field1913[var6]) * (var10 - var9) > 0) {
                     field1889[var4] = false;
                     if(var8 >= 0 && var9 >= 0 && var10 >= 0 && var8 <= class94.rasterClipX && var9 <= class94.rasterClipX && var10 <= class94.rasterClipX) {
                        field1888[var4] = false;
                     } else {
                        field1888[var4] = true;
                     }

                     var24 = (field1892[var5] + field1892[var6] + field1892[var7]) / 3 + this.field1886;
                     field1898[var24][field1897[var24]++] = var4;
                  }
               } else {
                  var24 = field1876[var5];
                  var12 = field1876[var6];
                  var13 = field1876[var7];
                  int var14 = field1894[var5];
                  var15 = field1894[var6];
                  int var16 = field1894[var7];
                  int var17 = field1895[var5];
                  int var18 = field1895[var6];
                  int var19 = field1895[var7];
                  var24 -= var12;
                  var13 -= var12;
                  var14 -= var15;
                  var16 -= var15;
                  var17 -= var18;
                  var19 -= var18;
                  int var20 = var14 * var19 - var17 * var16;
                  int var21 = var17 * var13 - var24 * var19;
                  int var22 = var24 * var16 - var14 * var13;
                  if(var12 * var20 + var15 * var21 + var18 * var22 > 0) {
                     field1889[var4] = true;
                     int var23 = (field1892[var5] + field1892[var6] + field1892[var7]) / 3 + this.field1886;
                     field1898[var23][field1897[var23]++] = var4;
                  }
               }
            }
         }

         int[] var25;
         if(this.field1903 == null) {
            for(var4 = this.field1910 - 1; var4 >= 0; --var4) {
               var5 = field1897[var4];
               if(var5 > 0) {
                  var25 = field1898[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     this.method2351(var25[var7]);
                  }
               }
            }

         } else {
            for(var4 = 0; var4 < 12; ++var4) {
               field1899[var4] = 0;
               field1862[var4] = 0;
            }

            for(var4 = this.field1910 - 1; var4 >= 0; --var4) {
               var5 = field1897[var4];
               if(var5 > 0) {
                  var25 = field1898[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     var8 = var25[var7];
                     byte var28 = this.field1903[var8];
                     var10 = field1899[var28]++;
                     field1900[var28][var10] = var8;
                     if(var28 < 10) {
                        field1862[var28] += var4;
                     } else if(var28 == 10) {
                        field1901[var10] = var4;
                     } else {
                        field1902[var10] = var4;
                     }
                  }
               }
            }

            var4 = 0;
            if(field1899[1] > 0 || field1899[2] > 0) {
               var4 = (field1862[1] + field1862[2]) / (field1899[1] + field1899[2]);
            }

            var5 = 0;
            if(field1899[3] > 0 || field1899[4] > 0) {
               var5 = (field1862[3] + field1862[4]) / (field1899[3] + field1899[4]);
            }

            var6 = 0;
            if(field1899[6] > 0 || field1899[8] > 0) {
               var6 = (field1862[6] + field1862[8]) / (field1899[6] + field1899[8]);
            }

            var8 = 0;
            var9 = field1899[10];
            int[] var26 = field1900[10];
            int[] var11 = field1901;
            if(var8 == var9) {
               var8 = 0;
               var9 = field1899[11];
               var26 = field1900[11];
               var11 = field1902;
            }

            if(var8 < var9) {
               var7 = var11[var8];
            } else {
               var7 = -1000;
            }

            for(var12 = 0; var12 < 10; ++var12) {
               while(var12 == 0 && var7 > var4) {
                  this.method2351(var26[var8++]);
                  if(var8 == var9 && var26 != field1900[11]) {
                     var8 = 0;
                     var9 = field1899[11];
                     var26 = field1900[11];
                     var11 = field1902;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 3 && var7 > var5) {
                  this.method2351(var26[var8++]);
                  if(var8 == var9 && var26 != field1900[11]) {
                     var8 = 0;
                     var9 = field1899[11];
                     var26 = field1900[11];
                     var11 = field1902;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 5 && var7 > var6) {
                  this.method2351(var26[var8++]);
                  if(var8 == var9 && var26 != field1900[11]) {
                     var8 = 0;
                     var9 = field1899[11];
                     var26 = field1900[11];
                     var11 = field1902;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               var13 = field1899[var12];
               int[] var27 = field1900[var12];

               for(var15 = 0; var15 < var13; ++var15) {
                  this.method2351(var27[var15]);
               }
            }

            while(var7 != -1000) {
               this.method2351(var26[var8++]);
               if(var8 == var9 && var26 != field1900[11]) {
                  var8 = 0;
                  var26 = field1900[11];
                  var9 = field1899[11];
                  var11 = field1902;
               }

               if(var8 < var9) {
                  var7 = var11[var8];
               } else {
                  var7 = -1000;
               }
            }

         }
      }
   }

   @ObfuscatedName("t")
   final void method2351(int var1) {
      if(field1889[var1]) {
         this.method2352(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         class94.rasterClipEnable = field1888[var1];
         if(this.field1912 == null) {
            class94.rasterAlpha = 0;
         } else {
            class94.rasterAlpha = this.field1912[var1] & 255;
         }

         if(this.field1884 != null && this.field1884[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1873 != null && this.field1873[var1] != -1) {
               int var8 = this.field1873[var1] & 255;
               var5 = this.field1908[var8];
               var6 = this.field1877[var8];
               var7 = this.field1918[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1856[var1] == -1) {
               class94.rasterTextureAffine(field1913[var2], field1913[var3], field1913[var4], field1869[var2], field1869[var3], field1869[var4], this.field1871[var1], this.field1871[var1], this.field1871[var1], field1876[var5], field1876[var6], field1876[var7], field1894[var5], field1894[var6], field1894[var7], field1895[var5], field1895[var6], field1895[var7], this.field1884[var1]);
            } else {
               class94.rasterTextureAffine(field1913[var2], field1913[var3], field1913[var4], field1869[var2], field1869[var3], field1869[var4], this.field1871[var1], this.field1885[var1], this.field1856[var1], field1876[var5], field1876[var6], field1876[var7], field1894[var5], field1894[var6], field1894[var7], field1895[var5], field1895[var6], field1895[var7], this.field1884[var1]);
            }
         } else if(this.field1856[var1] == -1) {
            class94.rasterFlat(field1913[var2], field1913[var3], field1913[var4], field1869[var2], field1869[var3], field1869[var4], field1917[this.field1871[var1]]);
         } else {
            class94.rasterGouraud(field1913[var2], field1913[var3], field1913[var4], field1869[var2], field1869[var3], field1869[var4], this.field1871[var1], this.field1885[var1], this.field1856[var1]);
         }

      }
   }

   @ObfuscatedName("a")
   final void method2352(int var1) {
      int var2 = class94.field1619;
      int var3 = class94.field1629;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1895[var5];
      int var9 = field1895[var6];
      int var10 = field1895[var7];
      if(this.field1912 == null) {
         class94.rasterAlpha = 0;
      } else {
         class94.rasterAlpha = this.field1912[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1904[var4] = field1869[var5];
         field1893[var4] = field1913[var5];
         field1891[var4++] = this.field1871[var1];
      } else {
         var11 = field1876[var5];
         var12 = field1894[var5];
         var13 = this.field1871[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1878[var10 - var8];
            field1904[var4] = var2 + (var11 + ((field1876[var7] - var11) * var14 >> 16)) * class94.field1628 / 50;
            field1893[var4] = var3 + (var12 + ((field1894[var7] - var12) * var14 >> 16)) * class94.field1628 / 50;
            field1891[var4++] = var13 + ((this.field1856[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1878[var9 - var8];
            field1904[var4] = var2 + (var11 + ((field1876[var6] - var11) * var14 >> 16)) * class94.field1628 / 50;
            field1893[var4] = var3 + (var12 + ((field1894[var6] - var12) * var14 >> 16)) * class94.field1628 / 50;
            field1891[var4++] = var13 + ((this.field1885[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1904[var4] = field1869[var6];
         field1893[var4] = field1913[var6];
         field1891[var4++] = this.field1885[var1];
      } else {
         var11 = field1876[var6];
         var12 = field1894[var6];
         var13 = this.field1885[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1878[var8 - var9];
            field1904[var4] = var2 + (var11 + ((field1876[var5] - var11) * var14 >> 16)) * class94.field1628 / 50;
            field1893[var4] = var3 + (var12 + ((field1894[var5] - var12) * var14 >> 16)) * class94.field1628 / 50;
            field1891[var4++] = var13 + ((this.field1871[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1878[var10 - var9];
            field1904[var4] = var2 + (var11 + ((field1876[var7] - var11) * var14 >> 16)) * class94.field1628 / 50;
            field1893[var4] = var3 + (var12 + ((field1894[var7] - var12) * var14 >> 16)) * class94.field1628 / 50;
            field1891[var4++] = var13 + ((this.field1856[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1904[var4] = field1869[var7];
         field1893[var4] = field1913[var7];
         field1891[var4++] = this.field1856[var1];
      } else {
         var11 = field1876[var7];
         var12 = field1894[var7];
         var13 = this.field1856[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1878[var9 - var10];
            field1904[var4] = var2 + (var11 + ((field1876[var6] - var11) * var14 >> 16)) * class94.field1628 / 50;
            field1893[var4] = var3 + (var12 + ((field1894[var6] - var12) * var14 >> 16)) * class94.field1628 / 50;
            field1891[var4++] = var13 + ((this.field1885[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1878[var8 - var10];
            field1904[var4] = var2 + (var11 + ((field1876[var5] - var11) * var14 >> 16)) * class94.field1628 / 50;
            field1893[var4] = var3 + (var12 + ((field1894[var5] - var12) * var14 >> 16)) * class94.field1628 / 50;
            field1891[var4++] = var13 + ((this.field1871[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1904[0];
      var12 = field1904[1];
      var13 = field1904[2];
      var14 = field1893[0];
      int var15 = field1893[1];
      int var16 = field1893[2];
      class94.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class94.rasterClipX || var12 > class94.rasterClipX || var13 > class94.rasterClipX) {
            class94.rasterClipEnable = true;
         }

         if(this.field1884 != null && this.field1884[var1] != -1) {
            if(this.field1873 != null && this.field1873[var1] != -1) {
               var20 = this.field1873[var1] & 255;
               var17 = this.field1908[var20];
               var18 = this.field1877[var20];
               var19 = this.field1918[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1856[var1] == -1) {
               class94.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1871[var1], this.field1871[var1], this.field1871[var1], field1876[var17], field1876[var18], field1876[var19], field1894[var17], field1894[var18], field1894[var19], field1895[var17], field1895[var18], field1895[var19], this.field1884[var1]);
            } else {
               class94.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1891[0], field1891[1], field1891[2], field1876[var17], field1876[var18], field1876[var19], field1894[var17], field1894[var18], field1894[var19], field1895[var17], field1895[var18], field1895[var19], this.field1884[var1]);
            }
         } else if(this.field1856[var1] == -1) {
            class94.rasterFlat(var14, var15, var16, var11, var12, var13, field1917[this.field1871[var1]]);
         } else {
            class94.rasterGouraud(var14, var15, var16, var11, var12, var13, field1891[0], field1891[1], field1891[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class94.rasterClipX || var12 > class94.rasterClipX || var13 > class94.rasterClipX || field1904[3] < 0 || field1904[3] > class94.rasterClipX) {
            class94.rasterClipEnable = true;
         }

         if(this.field1884 != null && this.field1884[var1] != -1) {
            if(this.field1873 != null && this.field1873[var1] != -1) {
               var20 = this.field1873[var1] & 255;
               var17 = this.field1908[var20];
               var18 = this.field1877[var20];
               var19 = this.field1918[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1884[var1];
            if(this.field1856[var1] == -1) {
               class94.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1871[var1], this.field1871[var1], this.field1871[var1], field1876[var17], field1876[var18], field1876[var19], field1894[var17], field1894[var18], field1894[var19], field1895[var17], field1895[var18], field1895[var19], var21);
               class94.rasterTextureAffine(var14, var16, field1893[3], var11, var13, field1904[3], this.field1871[var1], this.field1871[var1], this.field1871[var1], field1876[var17], field1876[var18], field1876[var19], field1894[var17], field1894[var18], field1894[var19], field1895[var17], field1895[var18], field1895[var19], var21);
            } else {
               class94.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1891[0], field1891[1], field1891[2], field1876[var17], field1876[var18], field1876[var19], field1894[var17], field1894[var18], field1894[var19], field1895[var17], field1895[var18], field1895[var19], var21);
               class94.rasterTextureAffine(var14, var16, field1893[3], var11, var13, field1904[3], field1891[0], field1891[2], field1891[3], field1876[var17], field1876[var18], field1876[var19], field1894[var17], field1894[var18], field1894[var19], field1895[var17], field1895[var18], field1895[var19], var21);
            }
         } else if(this.field1856[var1] == -1) {
            var17 = field1917[this.field1871[var1]];
            class94.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            class94.rasterFlat(var14, var16, field1893[3], var11, var13, field1904[3], var17);
         } else {
            class94.rasterGouraud(var14, var15, var16, var11, var12, var13, field1891[0], field1891[1], field1891[2]);
            class94.rasterGouraud(var14, var16, field1893[3], var11, var13, field1904[3], field1891[0], field1891[2], field1891[3]);
         }
      }

   }

   @ObfuscatedName("am")
   final boolean method2353(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      return var2 < var3 && var2 < var4 && var2 < var5?false:(var2 > var3 && var2 > var4 && var2 > var5?false:(var1 < var6 && var1 < var7 && var1 < var8?false:var1 <= var6 || var1 <= var7 || var1 <= var8));
   }

   @ObfuscatedName("i")
   public Model method2354(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2335();
      int var7 = var2 - this.field1867;
      int var8 = var2 + this.field1867;
      int var9 = var4 - this.field1867;
      int var10 = var4 + this.field1867;
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
               var11.field1875 = this.field1875;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1871 = this.field1871;
               var11.field1885 = this.field1885;
               var11.field1856 = this.field1856;
               var11.field1903 = this.field1903;
               var11.field1912 = this.field1912;
               var11.field1873 = this.field1873;
               var11.field1884 = this.field1884;
               var11.field1874 = this.field1874;
               var11.field1908 = this.field1908;
               var11.field1877 = this.field1877;
               var11.field1918 = this.field1918;
               var11.field1879 = this.field1879;
               var11.field1880 = this.field1880;
               var11.field1881 = this.field1881;
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

            var11.field1882 = 0;
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("h")
   public Model method2358(boolean var1) {
      if(!var1 && field1890.length < this.field1863) {
         field1890 = new byte[this.field1863 + 100];
      }

      return this.method2333(var1, field1872, field1890);
   }

   static {
      field1915 = class94.field1623;
      field1916 = class94.field1642;
      field1917 = class94.colorPalette;
      field1878 = class94.field1640;
   }

   @ObfuscatedName("w")
   public void method2361() {
      for(int var1 = 0; var1 < this.field1859; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.field1882 = 0;
   }

   @ObfuscatedName("ao")
   void vmethod2370(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1897[0] = -1;
      if(this.field1882 != 1) {
         this.method2335();
      }

      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1867 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1867) * class94.field1628;
         if(var15 / var13 < class94.field1618) {
            int var16 = (var14 + this.field1867) * class94.field1628;
            if(var16 / var13 > class94.field1634) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1867 * var2 >> 16;
               int var19 = (var17 + var18) * class94.field1628;
               if(var19 / var13 > class94.field1641) {
                  int var20 = var18 + (super.modelHeight * var3 >> 16);
                  int var21 = (var17 - var20) * class94.field1628;
                  if(var21 / var13 < class94.field1635) {
                     int var22 = var12 + (super.modelHeight * var2 >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1875 > 0;
                     boolean var26 = false;
                     int var27;
                     int var28;
                     int var29;
                     if(var9 > 0 && field1855) {
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

                        var28 = field1911 - class94.field1619;
                        var29 = field1864 - class94.field1629;
                        if(var28 > var15 && var28 < var16 && var29 > var21 && var29 < var19) {
                           if(this.field1881) {
                              field1914[field1868++] = var9;
                           } else {
                              var26 = true;
                           }
                        }
                     }

                     var27 = class94.field1619;
                     var28 = class94.field1629;
                     var29 = 0;
                     int var30 = 0;
                     if(var1 != 0) {
                        var29 = field1915[var1];
                        var30 = field1916[var1];
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
                        field1892[var31] = var34 - var11;
                        if(var34 >= 50) {
                           field1869[var31] = var27 + var32 * class94.field1628 / var34;
                           field1913[var31] = var28 + var35 * class94.field1628 / var34;
                        } else {
                           field1869[var31] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1876[var31] = var32;
                           field1894[var31] = var35;
                           field1895[var31] = var34;
                        }
                     }

                     try {
                        this.method2350(var23, var26, var9);
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

   public Model(Model[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1859 = 0;
      this.field1863 = 0;
      this.field1875 = 0;
      this.field1874 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1859 += var8.field1859;
            this.field1863 += var8.field1863;
            this.field1875 += var8.field1875;
            if(var8.field1903 != null) {
               var3 = true;
            } else {
               if(this.field1874 == -1) {
                  this.field1874 = var8.field1874;
               }

               if(this.field1874 != var8.field1874) {
                  var3 = true;
               }
            }

            var4 |= var8.field1912 != null;
            var5 |= var8.field1884 != null;
            var6 |= var8.field1873 != null;
         }
      }

      this.verticesX = new int[this.field1859];
      this.verticesY = new int[this.field1859];
      this.verticesZ = new int[this.field1859];
      this.indices1 = new int[this.field1863];
      this.indices2 = new int[this.field1863];
      this.indices3 = new int[this.field1863];
      this.field1871 = new int[this.field1863];
      this.field1885 = new int[this.field1863];
      this.field1856 = new int[this.field1863];
      if(var3) {
         this.field1903 = new byte[this.field1863];
      }

      if(var4) {
         this.field1912 = new byte[this.field1863];
      }

      if(var5) {
         this.field1884 = new short[this.field1863];
      }

      if(var6) {
         this.field1873 = new byte[this.field1863];
      }

      if(this.field1875 > 0) {
         this.field1908 = new int[this.field1875];
         this.field1877 = new int[this.field1875];
         this.field1918 = new int[this.field1875];
      }

      this.field1859 = 0;
      this.field1863 = 0;
      this.field1875 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1863; ++var9) {
               this.indices1[this.field1863] = var8.indices1[var9] + this.field1859;
               this.indices2[this.field1863] = var8.indices2[var9] + this.field1859;
               this.indices3[this.field1863] = var8.indices3[var9] + this.field1859;
               this.field1871[this.field1863] = var8.field1871[var9];
               this.field1885[this.field1863] = var8.field1885[var9];
               this.field1856[this.field1863] = var8.field1856[var9];
               if(var3) {
                  if(var8.field1903 != null) {
                     this.field1903[this.field1863] = var8.field1903[var9];
                  } else {
                     this.field1903[this.field1863] = var8.field1874;
                  }
               }

               if(var4 && var8.field1912 != null) {
                  this.field1912[this.field1863] = var8.field1912[var9];
               }

               if(var5) {
                  if(var8.field1884 != null) {
                     this.field1884[this.field1863] = var8.field1884[var9];
                  } else {
                     this.field1884[this.field1863] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1873 != null && var8.field1873[var9] != -1) {
                     this.field1873[this.field1863] = (byte)(var8.field1873[var9] + this.field1875);
                  } else {
                     this.field1873[this.field1863] = -1;
                  }
               }

               ++this.field1863;
            }

            for(var9 = 0; var9 < var8.field1875; ++var9) {
               this.field1908[this.field1875] = var8.field1908[var9] + this.field1859;
               this.field1877[this.field1875] = var8.field1877[var9] + this.field1859;
               this.field1918[this.field1875] = var8.field1918[var9] + this.field1859;
               ++this.field1875;
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

   @ObfuscatedName("g")
   public Model method2384(boolean var1) {
      if(!var1 && field1858.length < this.field1863) {
         field1858 = new byte[this.field1863 + 100];
      }

      return this.method2333(var1, field1857, field1858);
   }
}
