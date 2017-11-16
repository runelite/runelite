import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lev;"
   )
   static Model field1857;
   @ObfuscatedName("s")
   static byte[] field1830;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lev;"
   )
   static Model field1832;
   @ObfuscatedName("g")
   static byte[] field1854;
   @ObfuscatedName("aw")
   static boolean[] field1869;
   @ObfuscatedName("al")
   static boolean[] field1870;
   @ObfuscatedName("aj")
   public static int[] field1877;
   @ObfuscatedName("ap")
   public static int[] field1872;
   @ObfuscatedName("ag")
   static int[] field1887;
   @ObfuscatedName("af")
   @Export("yViewportBuffer")
   static int[] yViewportBuffer;
   @ObfuscatedName("ay")
   static int[] field1845;
   @ObfuscatedName("ab")
   static int[] field1876;
   @ObfuscatedName("ai")
   static int[] field1866;
   @ObfuscatedName("az")
   static int[][] field1879;
   @ObfuscatedName("aa")
   static int[] field1880;
   @ObfuscatedName("ad")
   static int[][] field1881;
   @ObfuscatedName("ba")
   static int[] field1882;
   @ObfuscatedName("bi")
   static int[] field1852;
   @ObfuscatedName("bq")
   static int[] field1884;
   @ObfuscatedName("bc")
   static int[] field1885;
   @ObfuscatedName("bb")
   static int[] field1886;
   @ObfuscatedName("bl")
   @Export("xViewportBuffer")
   static int[] xViewportBuffer;
   @ObfuscatedName("bt")
   static int field1888;
   @ObfuscatedName("be")
   static int field1873;
   @ObfuscatedName("by")
   static int field1890;
   @ObfuscatedName("bk")
   static boolean field1891;
   @ObfuscatedName("bz")
   static int[] field1894;
   @ObfuscatedName("bh")
   static int[] field1895;
   @ObfuscatedName("bp")
   static int[] field1896;
   @ObfuscatedName("bf")
   static int[] field1897;
   @ObfuscatedName("x")
   int field1834;
   @ObfuscatedName("f")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("u")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("t")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("k")
   public int field1838;
   @ObfuscatedName("n")
   @Export("indices1")
   public int[] indices1;
   @ObfuscatedName("d")
   @Export("indices2")
   public int[] indices2;
   @ObfuscatedName("o")
   @Export("indices3")
   public int[] indices3;
   @ObfuscatedName("a")
   int[] field1842;
   @ObfuscatedName("q")
   int[] field1843;
   @ObfuscatedName("j")
   public int[] field1844;
   @ObfuscatedName("m")
   byte[] field1859;
   @ObfuscatedName("h")
   byte[] field1846;
   @ObfuscatedName("c")
   byte[] field1847;
   @ObfuscatedName("y")
   short[] field1836;
   @ObfuscatedName("p")
   byte field1849;
   @ObfuscatedName("i")
   int field1853;
   @ObfuscatedName("l")
   int[] field1851;
   @ObfuscatedName("z")
   int[] field1856;
   @ObfuscatedName("e")
   int[] field1833;
   @ObfuscatedName("v")
   int[][] field1871;
   @ObfuscatedName("w")
   int[][] field1855;
   @ObfuscatedName("av")
   public boolean field1831;
   @ObfuscatedName("au")
   int field1883;
   @ObfuscatedName("ae")
   int field1848;
   @ObfuscatedName("ak")
   @Export("XYZMag")
   int XYZMag;
   @ObfuscatedName("aq")
   int field1860;
   @ObfuscatedName("an")
   int field1878;
   @ObfuscatedName("am")
   public int field1875;
   @ObfuscatedName("ar")
   public int field1863;
   @ObfuscatedName("ao")
   public int field1864;
   @ObfuscatedName("at")
   public int field1865;
   @ObfuscatedName("ac")
   public int field1839;
   @ObfuscatedName("as")
   public int field1867;

   static {
      field1857 = new Model();
      field1830 = new byte[1];
      field1832 = new Model();
      field1854 = new byte[1];
      field1869 = new boolean[4700];
      field1870 = new boolean[4700];
      field1877 = new int[4700];
      field1872 = new int[4700];
      field1887 = new int[4700];
      yViewportBuffer = new int[4700];
      field1845 = new int[4700];
      field1876 = new int[4700];
      field1866 = new int[1600];
      field1879 = new int[1600][512];
      field1880 = new int[12];
      field1881 = new int[12][2000];
      field1882 = new int[2000];
      field1852 = new int[2000];
      field1884 = new int[12];
      field1885 = new int[10];
      field1886 = new int[10];
      xViewportBuffer = new int[10];
      field1891 = true;
      field1894 = Graphics3D.SINE;
      field1895 = Graphics3D.COSINE;
      field1896 = Graphics3D.colorPalette;
      field1897 = Graphics3D.field1939;
   }

   Model() {
      this.field1834 = 0;
      this.field1838 = 0;
      this.field1849 = 0;
      this.field1853 = 0;
      this.field1831 = false;
      this.field1865 = -1;
      this.field1839 = -1;
      this.field1867 = -1;
   }

   @ObfuscatedSignature(
      signature = "([Lev;I)V"
   )
   public Model(Model[] var1, int var2) {
      this.field1834 = 0;
      this.field1838 = 0;
      this.field1849 = 0;
      this.field1853 = 0;
      this.field1831 = false;
      this.field1865 = -1;
      this.field1839 = -1;
      this.field1867 = -1;
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1834 = 0;
      this.field1838 = 0;
      this.field1853 = 0;
      this.field1849 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1834 += var8.field1834;
            this.field1838 += var8.field1838;
            this.field1853 += var8.field1853;
            if(var8.field1859 != null) {
               var3 = true;
            } else {
               if(this.field1849 == -1) {
                  this.field1849 = var8.field1849;
               }

               if(this.field1849 != var8.field1849) {
                  var3 = true;
               }
            }

            var4 |= var8.field1846 != null;
            var5 |= var8.field1836 != null;
            var6 |= var8.field1847 != null;
         }
      }

      this.verticesX = new int[this.field1834];
      this.verticesY = new int[this.field1834];
      this.verticesZ = new int[this.field1834];
      this.indices1 = new int[this.field1838];
      this.indices2 = new int[this.field1838];
      this.indices3 = new int[this.field1838];
      this.field1842 = new int[this.field1838];
      this.field1843 = new int[this.field1838];
      this.field1844 = new int[this.field1838];
      if(var3) {
         this.field1859 = new byte[this.field1838];
      }

      if(var4) {
         this.field1846 = new byte[this.field1838];
      }

      if(var5) {
         this.field1836 = new short[this.field1838];
      }

      if(var6) {
         this.field1847 = new byte[this.field1838];
      }

      if(this.field1853 > 0) {
         this.field1851 = new int[this.field1853];
         this.field1856 = new int[this.field1853];
         this.field1833 = new int[this.field1853];
      }

      this.field1834 = 0;
      this.field1838 = 0;
      this.field1853 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1838; ++var9) {
               this.indices1[this.field1838] = this.field1834 + var8.indices1[var9];
               this.indices2[this.field1838] = this.field1834 + var8.indices2[var9];
               this.indices3[this.field1838] = this.field1834 + var8.indices3[var9];
               this.field1842[this.field1838] = var8.field1842[var9];
               this.field1843[this.field1838] = var8.field1843[var9];
               this.field1844[this.field1838] = var8.field1844[var9];
               if(var3) {
                  if(var8.field1859 != null) {
                     this.field1859[this.field1838] = var8.field1859[var9];
                  } else {
                     this.field1859[this.field1838] = var8.field1849;
                  }
               }

               if(var4 && var8.field1846 != null) {
                  this.field1846[this.field1838] = var8.field1846[var9];
               }

               if(var5) {
                  if(var8.field1836 != null) {
                     this.field1836[this.field1838] = var8.field1836[var9];
                  } else {
                     this.field1836[this.field1838] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1847 != null && var8.field1847[var9] != -1) {
                     this.field1847[this.field1838] = (byte)(this.field1853 + var8.field1847[var9]);
                  } else {
                     this.field1847[this.field1838] = -1;
                  }
               }

               ++this.field1838;
            }

            for(var9 = 0; var9 < var8.field1853; ++var9) {
               this.field1851[this.field1853] = this.field1834 + var8.field1851[var9];
               this.field1856[this.field1853] = this.field1834 + var8.field1856[var9];
               this.field1833[this.field1853] = this.field1834 + var8.field1833[var9];
               ++this.field1853;
            }

            for(var9 = 0; var9 < var8.field1834; ++var9) {
               this.verticesX[this.field1834] = var8.verticesX[var9];
               this.verticesY[this.field1834] = var8.verticesY[var9];
               this.verticesZ[this.field1834] = var8.verticesZ[var9];
               ++this.field1834;
            }
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([[IIIIZI)Lev;"
   )
   public Model method2506(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2511();
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
               var11.field1834 = this.field1834;
               var11.field1838 = this.field1838;
               var11.field1853 = this.field1853;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1842 = this.field1842;
               var11.field1843 = this.field1843;
               var11.field1844 = this.field1844;
               var11.field1859 = this.field1859;
               var11.field1846 = this.field1846;
               var11.field1847 = this.field1847;
               var11.field1836 = this.field1836;
               var11.field1849 = this.field1849;
               var11.field1851 = this.field1851;
               var11.field1856 = this.field1856;
               var11.field1833 = this.field1833;
               var11.field1871 = this.field1871;
               var11.field1855 = this.field1855;
               var11.field1831 = this.field1831;
               var11.verticesY = new int[var11.field1834];
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
               for(var12 = 0; var12 < var11.field1834; ++var12) {
                  var13 = var2 + this.verticesX[var12];
                  var14 = var4 + this.verticesZ[var12];
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var15 * var1[var17 + 1][var18 + 1] >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.verticesY[var12] = var21 + this.verticesY[var12] - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1834; ++var12) {
                  var13 = (-this.verticesY[var12] << 16) / super.modelHeight;
                  if(var13 < var6) {
                     var14 = var2 + this.verticesX[var12];
                     var15 = var4 + this.verticesZ[var12];
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var16 * var1[var18 + 1][var19 + 1] >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.verticesY[var12] = (var6 - var13) * (var22 - var3) / var6 + this.verticesY[var12];
                  }
               }
            }

            var11.method2514();
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Z)Lev;"
   )
   public Model method2567(boolean var1) {
      if(!var1 && field1830.length < this.field1838) {
         field1830 = new byte[this.field1838 + 100];
      }

      return this.method2509(var1, field1857, field1830);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Z)Lev;"
   )
   public Model method2512(boolean var1) {
      if(!var1 && field1854.length < this.field1838) {
         field1854 = new byte[this.field1838 + 100];
      }

      return this.method2509(var1, field1832, field1854);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ZLev;[B)Lev;"
   )
   Model method2509(boolean var1, Model var2, byte[] var3) {
      var2.field1834 = this.field1834;
      var2.field1838 = this.field1838;
      var2.field1853 = this.field1853;
      if(var2.verticesX == null || var2.verticesX.length < this.field1834) {
         var2.verticesX = new int[this.field1834 + 100];
         var2.verticesY = new int[this.field1834 + 100];
         var2.verticesZ = new int[this.field1834 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1834; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if(var1) {
         var2.field1846 = this.field1846;
      } else {
         var2.field1846 = var3;
         if(this.field1846 == null) {
            for(var4 = 0; var4 < this.field1838; ++var4) {
               var2.field1846[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1838; ++var4) {
               var2.field1846[var4] = this.field1846[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1842 = this.field1842;
      var2.field1843 = this.field1843;
      var2.field1844 = this.field1844;
      var2.field1859 = this.field1859;
      var2.field1847 = this.field1847;
      var2.field1836 = this.field1836;
      var2.field1849 = this.field1849;
      var2.field1851 = this.field1851;
      var2.field1856 = this.field1856;
      var2.field1833 = this.field1833;
      var2.field1871 = this.field1871;
      var2.field1855 = this.field1855;
      var2.field1831 = this.field1831;
      var2.method2514();
      return var2;
   }

   @ObfuscatedName("f")
   void method2532(int var1) {
      if(this.field1865 == -1) {
         int var2 = 0;
         int var3 = 0;
         int var4 = 0;
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         int var8 = field1895[var1];
         int var9 = field1894[var1];

         for(int var10 = 0; var10 < this.field1834; ++var10) {
            int var11 = Graphics3D.method2619(this.verticesX[var10], this.verticesZ[var10], var8, var9);
            int var12 = this.verticesY[var10];
            int var13 = Graphics3D.method2620(this.verticesX[var10], this.verticesZ[var10], var8, var9);
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

         this.field1875 = (var5 + var2) / 2;
         this.field1863 = (var6 + var3) / 2;
         this.field1864 = (var7 + var4) / 2;
         this.field1865 = (var5 - var2 + 1) / 2;
         this.field1839 = (var6 - var3 + 1) / 2;
         this.field1867 = (var7 - var4 + 1) / 2;
         if(this.field1865 < 32) {
            this.field1865 = 32;
         }

         if(this.field1867 < 32) {
            this.field1867 = 32;
         }

         if(this.field1831) {
            this.field1865 += 8;
            this.field1867 += 8;
         }

      }
   }

   @ObfuscatedName("u")
   public void method2511() {
      if(this.field1883 != 1) {
         this.field1883 = 1;
         super.modelHeight = 0;
         this.field1848 = 0;
         this.XYZMag = 0;

         for(int var1 = 0; var1 < this.field1834; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1848) {
               this.field1848 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.XYZMag) {
               this.XYZMag = var5;
            }
         }

         this.XYZMag = (int)(Math.sqrt((double)this.XYZMag) + 0.99D);
         this.field1878 = (int)(Math.sqrt((double)(this.XYZMag * this.XYZMag + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1860 = this.field1878 + (int)(Math.sqrt((double)(this.XYZMag * this.XYZMag + this.field1848 * this.field1848)) + 0.99D);
      }
   }

   @ObfuscatedName("t")
   void method2555() {
      if(this.field1883 != 2) {
         this.field1883 = 2;
         this.XYZMag = 0;

         for(int var1 = 0; var1 < this.field1834; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.XYZMag) {
               this.XYZMag = var5;
            }
         }

         this.XYZMag = (int)(Math.sqrt((double)this.XYZMag) + 0.99D);
         this.field1878 = this.XYZMag;
         this.field1860 = this.XYZMag + this.XYZMag;
      }
   }

   @ObfuscatedName("k")
   public int method2513() {
      this.method2511();
      return this.XYZMag;
   }

   @ObfuscatedName("n")
   void method2514() {
      this.field1883 = 0;
      this.field1865 = -1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Let;I)V"
   )
   public void method2537(Frames var1, int var2) {
      if(this.field1871 != null) {
         if(var2 != -1) {
            Frame var3 = var1.skeletons[var2];
            FrameMap var4 = var3.skin;
            field1888 = 0;
            field1873 = 0;
            field1890 = 0;

            for(int var5 = 0; var5 < var3.field1799; ++var5) {
               int var6 = var3.field1800[var5];
               this.method2517(var4.types[var6], var4.list[var6], var3.translator_x[var5], var3.translator_y[var5], var3.translator_z[var5]);
            }

            this.method2514();
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Let;ILet;I[I)V"
   )
   public void method2516(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.skeletons[var2];
            Frame var7 = var3.skeletons[var4];
            FrameMap var8 = var6.skin;
            field1888 = 0;
            field1873 = 0;
            field1890 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1799; ++var11) {
               for(var12 = var6.field1800[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.types[var12] == 0) {
                  this.method2517(var8.types[var12], var8.list[var12], var6.translator_x[var11], var6.translator_y[var11], var6.translator_z[var11]);
               }
            }

            field1888 = 0;
            field1873 = 0;
            field1890 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1799; ++var11) {
               for(var12 = var7.field1800[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.types[var12] == 0) {
                  this.method2517(var8.types[var12], var8.list[var12], var7.translator_x[var11], var7.translator_y[var11], var7.translator_z[var11]);
               }
            }

            this.method2514();
         } else {
            this.method2537(var1, var2);
         }
      }
   }

   @ObfuscatedName("a")
   void method2517(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1888 = 0;
         field1873 = 0;
         field1890 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var9 = var2[var8];
            if(var9 < this.field1871.length) {
               int[] var10 = this.field1871[var9];

               for(var11 = 0; var11 < var10.length; ++var11) {
                  var12 = var10[var11];
                  field1888 += this.verticesX[var12];
                  field1873 += this.verticesY[var12];
                  field1890 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1888 = var3 + field1888 / var7;
            field1873 = var4 + field1873 / var7;
            field1890 = var5 + field1890 / var7;
         } else {
            field1888 = var3;
            field1873 = var4;
            field1890 = var5;
         }

      } else {
         int[] var18;
         int var19;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1871.length) {
                  var18 = this.field1871[var8];

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
               if(var8 < this.field1871.length) {
                  var18 = this.field1871[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= field1888;
                     this.verticesY[var11] -= field1873;
                     this.verticesZ[var11] -= field1890;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1894[var14];
                        var16 = field1895[var14];
                        var17 = var15 * this.verticesY[var11] + var16 * this.verticesX[var11] >> 16;
                        this.verticesY[var11] = var16 * this.verticesY[var11] - var15 * this.verticesX[var11] >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1894[var12];
                        var16 = field1895[var12];
                        var17 = var16 * this.verticesY[var11] - var15 * this.verticesZ[var11] >> 16;
                        this.verticesZ[var11] = var15 * this.verticesY[var11] + var16 * this.verticesZ[var11] >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1894[var13];
                        var16 = field1895[var13];
                        var17 = var15 * this.verticesZ[var11] + var16 * this.verticesX[var11] >> 16;
                        this.verticesZ[var11] = var16 * this.verticesZ[var11] - var15 * this.verticesX[var11] >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += field1888;
                     this.verticesY[var11] += field1873;
                     this.verticesZ[var11] += field1890;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1871.length) {
                  var18 = this.field1871[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= field1888;
                     this.verticesY[var11] -= field1873;
                     this.verticesZ[var11] -= field1890;
                     this.verticesX[var11] = var3 * this.verticesX[var11] / 128;
                     this.verticesY[var11] = var4 * this.verticesY[var11] / 128;
                     this.verticesZ[var11] = var5 * this.verticesZ[var11] / 128;
                     this.verticesX[var11] += field1888;
                     this.verticesY[var11] += field1873;
                     this.verticesZ[var11] += field1890;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1855 != null && this.field1846 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1855.length) {
                     var18 = this.field1855[var8];

                     for(var19 = 0; var19 < var18.length; ++var19) {
                        var11 = var18[var19];
                        var12 = (this.field1846[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1846[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("i")
   public void method2518() {
      for(int var1 = 0; var1 < this.field1834; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.method2514();
   }

   @ObfuscatedName("l")
   public void method2519() {
      for(int var1 = 0; var1 < this.field1834; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.method2514();
   }

   @ObfuscatedName("z")
   public void method2577() {
      for(int var1 = 0; var1 < this.field1834; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.method2514();
   }

   @ObfuscatedName("e")
   public void method2521(int var1) {
      int var2 = field1894[var1];
      int var3 = field1895[var1];

      for(int var4 = 0; var4 < this.field1834; ++var4) {
         int var5 = var3 * this.verticesY[var4] - var2 * this.verticesZ[var4] >> 16;
         this.verticesZ[var4] = var2 * this.verticesY[var4] + var3 * this.verticesZ[var4] >> 16;
         this.verticesY[var4] = var5;
      }

      this.method2514();
   }

   @ObfuscatedName("v")
   public void method2523(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1834; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.method2514();
   }

   @ObfuscatedName("w")
   public void method2505(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1834; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = var2 * this.verticesY[var4] / 128;
         this.verticesZ[var4] = var3 * this.verticesZ[var4] / 128;
      }

      this.method2514();
   }

   @ObfuscatedName("av")
   public final void method2524(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1866[0] = -1;
      if(this.field1883 != 2 && this.field1883 != 1) {
         this.method2555();
      }

      int var8 = Graphics3D.centerX;
      int var9 = Graphics3D.centerY;
      int var10 = field1894[var1];
      int var11 = field1895[var1];
      int var12 = field1894[var2];
      int var13 = field1895[var2];
      int var14 = field1894[var3];
      int var15 = field1895[var3];
      int var16 = field1894[var4];
      int var17 = field1895[var4];
      int var18 = var16 * var6 + var17 * var7 >> 16;

      for(int var19 = 0; var19 < this.field1834; ++var19) {
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
         field1887[var19] = var22 - var18;
         field1877[var19] = var20 * Graphics3D.field1926 / var22 + var8;
         field1872[var19] = var23 * Graphics3D.field1926 / var22 + var9;
         if(this.field1853 > 0) {
            yViewportBuffer[var19] = var20;
            field1845[var19] = var23;
            field1876[var19] = var22;
         }
      }

      try {
         this.method2527(false, false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("au")
   public final void method2525(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1866[0] = -1;
      if(this.field1883 != 2 && this.field1883 != 1) {
         this.method2555();
      }

      int var9 = Graphics3D.centerX;
      int var10 = Graphics3D.centerY;
      int var11 = field1894[var1];
      int var12 = field1895[var1];
      int var13 = field1894[var2];
      int var14 = field1895[var2];
      int var15 = field1894[var3];
      int var16 = field1895[var3];
      int var17 = field1894[var4];
      int var18 = field1895[var4];
      int var19 = var17 * var6 + var18 * var7 >> 16;

      for(int var20 = 0; var20 < this.field1834; ++var20) {
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
         field1887[var20] = var23 - var19;
         field1877[var20] = var9 + var21 * Graphics3D.field1926 / var8;
         field1872[var20] = var10 + var24 * Graphics3D.field1926 / var8;
         if(this.field1853 > 0) {
            yViewportBuffer[var20] = var21;
            field1845[var20] = var24;
            field1876[var20] = var23;
         }
      }

      try {
         this.method2527(false, false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("ae")
   final void method2527(boolean var1, boolean var2, boolean var3, int var4) {
      if(this.field1860 < 1600) {
         int var5;
         for(var5 = 0; var5 < this.field1860; ++var5) {
            field1866[var5] = 0;
         }

         var5 = var3?20:5;
         if(class7.field224 && var2) {
            class211.method3854(this, var5);
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
         for(var6 = 0; var6 < this.field1838; ++var6) {
            if(this.field1844[var6] != -2) {
               var7 = this.indices1[var6];
               var8 = this.indices2[var6];
               var9 = this.indices3[var6];
               var10 = field1877[var7];
               var11 = field1877[var8];
               var12 = field1877[var9];
               int var13;
               if(!var1 || var10 != -5000 && var11 != -5000 && var12 != -5000) {
                  if(var2 && Signlink.method2969(field1872[var7], field1872[var8], field1872[var9], var10, var11, var12, var5)) {
                     ScriptEvent.method1035(var4);
                     var2 = false;
                  }

                  if((var10 - var11) * (field1872[var9] - field1872[var8]) - (var12 - var11) * (field1872[var7] - field1872[var8]) > 0) {
                     field1870[var6] = false;
                     if(var10 >= 0 && var11 >= 0 && var12 >= 0 && var10 <= Graphics3D.rasterClipX && var11 <= Graphics3D.rasterClipX && var12 <= Graphics3D.rasterClipX) {
                        field1869[var6] = false;
                     } else {
                        field1869[var6] = true;
                     }

                     var13 = (field1887[var7] + field1887[var8] + field1887[var9]) / 3 + this.field1878;
                     field1879[var13][field1866[var13]++] = var6;
                  }
               } else {
                  var13 = yViewportBuffer[var7];
                  var14 = yViewportBuffer[var8];
                  var15 = yViewportBuffer[var9];
                  int var16 = field1845[var7];
                  var17 = field1845[var8];
                  int var18 = field1845[var9];
                  int var19 = field1876[var7];
                  int var20 = field1876[var8];
                  int var21 = field1876[var9];
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
                     field1870[var6] = true;
                     int var25 = (field1887[var7] + field1887[var8] + field1887[var9]) / 3 + this.field1878;
                     field1879[var25][field1866[var25]++] = var6;
                  }
               }
            }
         }

         int[] var26;
         if(this.field1859 == null) {
            for(var6 = this.field1860 - 1; var6 >= 0; --var6) {
               var7 = field1866[var6];
               if(var7 > 0) {
                  var26 = field1879[var6];

                  for(var9 = 0; var9 < var7; ++var9) {
                     this.method2528(var26[var9]);
                  }
               }
            }

         } else {
            for(var6 = 0; var6 < 12; ++var6) {
               field1880[var6] = 0;
               field1884[var6] = 0;
            }

            for(var6 = this.field1860 - 1; var6 >= 0; --var6) {
               var7 = field1866[var6];
               if(var7 > 0) {
                  var26 = field1879[var6];

                  for(var9 = 0; var9 < var7; ++var9) {
                     var10 = var26[var9];
                     byte var30 = this.field1859[var10];
                     var12 = field1880[var30]++;
                     field1881[var30][var12] = var10;
                     if(var30 < 10) {
                        field1884[var30] += var6;
                     } else if(var30 == 10) {
                        field1882[var12] = var6;
                     } else {
                        field1852[var12] = var6;
                     }
                  }
               }
            }

            var6 = 0;
            if(field1880[1] > 0 || field1880[2] > 0) {
               var6 = (field1884[1] + field1884[2]) / (field1880[1] + field1880[2]);
            }

            var7 = 0;
            if(field1880[3] > 0 || field1880[4] > 0) {
               var7 = (field1884[3] + field1884[4]) / (field1880[3] + field1880[4]);
            }

            var8 = 0;
            if(field1880[6] > 0 || field1880[8] > 0) {
               var8 = (field1884[8] + field1884[6]) / (field1880[8] + field1880[6]);
            }

            var10 = 0;
            var11 = field1880[10];
            int[] var27 = field1881[10];
            int[] var28 = field1882;
            if(var10 == var11) {
               var10 = 0;
               var11 = field1880[11];
               var27 = field1881[11];
               var28 = field1852;
            }

            if(var10 < var11) {
               var9 = var28[var10];
            } else {
               var9 = -1000;
            }

            for(var14 = 0; var14 < 10; ++var14) {
               while(var14 == 0 && var9 > var6) {
                  this.method2528(var27[var10++]);
                  if(var10 == var11 && var27 != field1881[11]) {
                     var10 = 0;
                     var11 = field1880[11];
                     var27 = field1881[11];
                     var28 = field1852;
                  }

                  if(var10 < var11) {
                     var9 = var28[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 3 && var9 > var7) {
                  this.method2528(var27[var10++]);
                  if(var10 == var11 && var27 != field1881[11]) {
                     var10 = 0;
                     var11 = field1880[11];
                     var27 = field1881[11];
                     var28 = field1852;
                  }

                  if(var10 < var11) {
                     var9 = var28[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 5 && var9 > var8) {
                  this.method2528(var27[var10++]);
                  if(var10 == var11 && var27 != field1881[11]) {
                     var10 = 0;
                     var11 = field1880[11];
                     var27 = field1881[11];
                     var28 = field1852;
                  }

                  if(var10 < var11) {
                     var9 = var28[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               var15 = field1880[var14];
               int[] var29 = field1881[var14];

               for(var17 = 0; var17 < var15; ++var17) {
                  this.method2528(var29[var17]);
               }
            }

            while(var9 != -1000) {
               this.method2528(var27[var10++]);
               if(var10 == var11 && var27 != field1881[11]) {
                  var10 = 0;
                  var27 = field1881[11];
                  var11 = field1880[11];
                  var28 = field1852;
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

   @ObfuscatedName("ak")
   final void method2528(int var1) {
      if(field1870[var1]) {
         this.method2529(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         Graphics3D.rasterClipEnable = field1869[var1];
         if(this.field1846 == null) {
            Graphics3D.rasterAlpha = 0;
         } else {
            Graphics3D.rasterAlpha = this.field1846[var1] & 255;
         }

         if(this.field1836 != null && this.field1836[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1847 != null && this.field1847[var1] != -1) {
               int var8 = this.field1847[var1] & 255;
               var5 = this.field1851[var8];
               var6 = this.field1856[var8];
               var7 = this.field1833[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1844[var1] == -1) {
               Graphics3D.rasterTextureAffine(field1872[var2], field1872[var3], field1872[var4], field1877[var2], field1877[var3], field1877[var4], this.field1842[var1], this.field1842[var1], this.field1842[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1845[var5], field1845[var6], field1845[var7], field1876[var5], field1876[var6], field1876[var7], this.field1836[var1]);
            } else {
               Graphics3D.rasterTextureAffine(field1872[var2], field1872[var3], field1872[var4], field1877[var2], field1877[var3], field1877[var4], this.field1842[var1], this.field1843[var1], this.field1844[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1845[var5], field1845[var6], field1845[var7], field1876[var5], field1876[var6], field1876[var7], this.field1836[var1]);
            }
         } else if(this.field1844[var1] == -1) {
            Graphics3D.rasterFlat(field1872[var2], field1872[var3], field1872[var4], field1877[var2], field1877[var3], field1877[var4], field1896[this.field1842[var1]]);
         } else {
            Graphics3D.rasterGouraud(field1872[var2], field1872[var3], field1872[var4], field1877[var2], field1877[var3], field1877[var4], this.field1842[var1], this.field1843[var1], this.field1844[var1]);
         }

      }
   }

   @ObfuscatedName("aq")
   final void method2529(int var1) {
      int var2 = Graphics3D.centerX;
      int var3 = Graphics3D.centerY;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1876[var5];
      int var9 = field1876[var6];
      int var10 = field1876[var7];
      if(this.field1846 == null) {
         Graphics3D.rasterAlpha = 0;
      } else {
         Graphics3D.rasterAlpha = this.field1846[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1885[var4] = field1877[var5];
         field1886[var4] = field1872[var5];
         xViewportBuffer[var4++] = this.field1842[var1];
      } else {
         var11 = yViewportBuffer[var5];
         var12 = field1845[var5];
         var13 = this.field1842[var1];
         if(var10 >= 50) {
            var14 = field1897[var10 - var8] * (50 - var8);
            field1885[var4] = var2 + Graphics3D.field1926 * (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) / 50;
            field1886[var4] = var3 + Graphics3D.field1926 * (var12 + ((field1845[var7] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1844[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = field1897[var9 - var8] * (50 - var8);
            field1885[var4] = var2 + Graphics3D.field1926 * (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) / 50;
            field1886[var4] = var3 + Graphics3D.field1926 * (var12 + ((field1845[var6] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1843[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1885[var4] = field1877[var6];
         field1886[var4] = field1872[var6];
         xViewportBuffer[var4++] = this.field1843[var1];
      } else {
         var11 = yViewportBuffer[var6];
         var12 = field1845[var6];
         var13 = this.field1843[var1];
         if(var8 >= 50) {
            var14 = field1897[var8 - var9] * (50 - var9);
            field1885[var4] = var2 + Graphics3D.field1926 * (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) / 50;
            field1886[var4] = var3 + Graphics3D.field1926 * (var12 + ((field1845[var5] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1842[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = field1897[var10 - var9] * (50 - var9);
            field1885[var4] = var2 + Graphics3D.field1926 * (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) / 50;
            field1886[var4] = var3 + Graphics3D.field1926 * (var12 + ((field1845[var7] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1844[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1885[var4] = field1877[var7];
         field1886[var4] = field1872[var7];
         xViewportBuffer[var4++] = this.field1844[var1];
      } else {
         var11 = yViewportBuffer[var7];
         var12 = field1845[var7];
         var13 = this.field1844[var1];
         if(var9 >= 50) {
            var14 = field1897[var9 - var10] * (50 - var10);
            field1885[var4] = var2 + Graphics3D.field1926 * (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) / 50;
            field1886[var4] = var3 + Graphics3D.field1926 * (var12 + ((field1845[var6] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1843[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = field1897[var8 - var10] * (50 - var10);
            field1885[var4] = var2 + Graphics3D.field1926 * (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) / 50;
            field1886[var4] = var3 + Graphics3D.field1926 * (var12 + ((field1845[var5] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1842[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1885[0];
      var12 = field1885[1];
      var13 = field1885[2];
      var14 = field1886[0];
      int var15 = field1886[1];
      int var16 = field1886[2];
      Graphics3D.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX) {
            Graphics3D.rasterClipEnable = true;
         }

         if(this.field1836 != null && this.field1836[var1] != -1) {
            if(this.field1847 != null && this.field1847[var1] != -1) {
               var20 = this.field1847[var1] & 255;
               var17 = this.field1851[var20];
               var18 = this.field1856[var20];
               var19 = this.field1833[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1844[var1] == -1) {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1842[var1], this.field1842[var1], this.field1842[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1845[var17], field1845[var18], field1845[var19], field1876[var17], field1876[var18], field1876[var19], this.field1836[var1]);
            } else {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1845[var17], field1845[var18], field1845[var19], field1876[var17], field1876[var18], field1876[var19], this.field1836[var1]);
            }
         } else if(this.field1844[var1] == -1) {
            Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, field1896[this.field1842[var1]]);
         } else {
            Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX || field1885[3] < 0 || field1885[3] > Graphics3D.rasterClipX) {
            Graphics3D.rasterClipEnable = true;
         }

         if(this.field1836 != null && this.field1836[var1] != -1) {
            if(this.field1847 != null && this.field1847[var1] != -1) {
               var20 = this.field1847[var1] & 255;
               var17 = this.field1851[var20];
               var18 = this.field1856[var20];
               var19 = this.field1833[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1836[var1];
            if(this.field1844[var1] == -1) {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1842[var1], this.field1842[var1], this.field1842[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1845[var17], field1845[var18], field1845[var19], field1876[var17], field1876[var18], field1876[var19], var21);
               Graphics3D.rasterTextureAffine(var14, var16, field1886[3], var11, var13, field1885[3], this.field1842[var1], this.field1842[var1], this.field1842[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1845[var17], field1845[var18], field1845[var19], field1876[var17], field1876[var18], field1876[var19], var21);
            } else {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1845[var17], field1845[var18], field1845[var19], field1876[var17], field1876[var18], field1876[var19], var21);
               Graphics3D.rasterTextureAffine(var14, var16, field1886[3], var11, var13, field1885[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1845[var17], field1845[var18], field1845[var19], field1876[var17], field1876[var18], field1876[var19], var21);
            }
         } else if(this.field1844[var1] == -1) {
            var17 = field1896[this.field1842[var1]];
            Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            Graphics3D.rasterFlat(var14, var16, field1886[3], var11, var13, field1885[3], var17);
         } else {
            Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
            Graphics3D.rasterGouraud(var14, var16, field1886[3], var11, var13, field1885[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3]);
         }
      }

   }

   @ObfuscatedName("cy")
   @Export("draw")
   void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1866[0] = -1;
      if(this.field1883 != 1) {
         this.method2511();
      }

      this.method2532(var1);
      int var10 = var5 * var8 - var4 * var6 >> 16;
      int var11 = var2 * var7 + var3 * var10 >> 16;
      int var12 = var3 * this.XYZMag >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var5 * var6 >> 16;
         int var15 = (var14 - this.XYZMag) * Graphics3D.field1926;
         if(var15 / var13 < Graphics3D.field1932) {
            int var16 = (var14 + this.XYZMag) * Graphics3D.field1926;
            if(var16 / var13 > Graphics3D.field1930) {
               int var17 = var3 * var7 - var10 * var2 >> 16;
               int var18 = var2 * this.XYZMag >> 16;
               int var19 = (var17 + var18) * Graphics3D.field1926;
               if(var19 / var13 > Graphics3D.field1933) {
                  int var20 = (var3 * super.modelHeight >> 16) + var18;
                  int var21 = (var17 - var20) * Graphics3D.field1926;
                  if(var21 / var13 < Graphics3D.field1934) {
                     int var22 = var12 + (var2 * super.modelHeight >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1853 > 0;
                     int var26 = class133.field1900;
                     int var28 = class10.method61();
                     boolean var29 = SceneTilePaint.method2684();
                     if(class7.field219 && var9 > 0) {
                        if(ScriptVarType.method17(this, var6, var7, var8)) {
                           class9.method54(this, var6, var7, var8, -65281);
                        } else if(class7.field218 == class11.field250) {
                           class9.method54(this, var6, var7, var8, -16776961);
                        }
                     }

                     int var31;
                     int var32;
                     int var33;
                     int var34;
                     int var35;
                     int var36;
                     int var37;
                     if(class7.field217 && var9 > 0) {
                        int var40 = var11 - var12;
                        if(var40 <= 50) {
                           var40 = 50;
                        }

                        if(var14 > 0) {
                           var31 = var15 / var13;
                           var32 = var16 / var40;
                        } else {
                           var32 = var16 / var13;
                           var31 = var15 / var40;
                        }

                        if(var17 > 0) {
                           var33 = var21 / var13;
                           var34 = var19 / var40;
                        } else {
                           var34 = var19 / var13;
                           var33 = var21 / var40;
                        }

                        var35 = -8355840;
                        var36 = var26 - Graphics3D.centerX;
                        var37 = var28 - Graphics3D.centerY;
                        if(var36 > var31 && var36 < var32 && var37 > var33 && var37 < var34) {
                           var35 = -256;
                        }

                        class13.method79(var31 + Graphics3D.centerX, var33 + Graphics3D.centerY, var32 + Graphics3D.centerX, var34 + Graphics3D.centerY, var35);
                     }

                     boolean var44 = false;
                     if(var9 > 0 && var29) {
                        boolean var43 = false;
                        if(field1891) {
                           var43 = ScriptVarType.method17(this, var6, var7, var8);
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
                           var34 = var28 - Graphics3D.centerY;
                           if(var33 > var15 && var33 < var16 && var34 > var21 && var34 < var19) {
                              var43 = true;
                           }
                        }

                        if(var43) {
                           if(this.field1831) {
                              ScriptEvent.method1035(var9);
                           } else {
                              var44 = true;
                           }
                        }
                     }

                     var31 = Graphics3D.centerX;
                     var32 = Graphics3D.centerY;
                     var33 = 0;
                     var34 = 0;
                     if(var1 != 0) {
                        var33 = field1894[var1];
                        var34 = field1895[var1];
                     }

                     for(var35 = 0; var35 < this.field1834; ++var35) {
                        var36 = this.verticesX[var35];
                        var37 = this.verticesY[var35];
                        int var38 = this.verticesZ[var35];
                        int var39;
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
                        field1887[var35] = var38 - var11;
                        if(var38 >= 50) {
                           field1877[var35] = var36 * Graphics3D.field1926 / var38 + var31;
                           field1872[var35] = var39 * Graphics3D.field1926 / var38 + var32;
                        } else {
                           field1877[var35] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           yViewportBuffer[var35] = var36;
                           field1845[var35] = var39;
                           field1876[var35] = var38;
                        }
                     }

                     try {
                        this.method2527(var23, var44, this.field1831, var9);
                     } catch (Exception var42) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }
}
