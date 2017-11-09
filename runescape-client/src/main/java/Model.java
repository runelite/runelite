import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Len;"
   )
   static Model field1909;
   @ObfuscatedName("p")
   static byte[] field1893;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Len;"
   )
   static Model field1885;
   @ObfuscatedName("j")
   static byte[] field1845;
   @ObfuscatedName("ay")
   static boolean[] field1881;
   @ObfuscatedName("az")
   static boolean[] field1882;
   @ObfuscatedName("aw")
   public static int[] field1900;
   @ObfuscatedName("au")
   public static int[] field1884;
   @ObfuscatedName("ac")
   static int[] field1866;
   @ObfuscatedName("ai")
   @Export("yViewportBuffer")
   static int[] yViewportBuffer;
   @ObfuscatedName("ax")
   static int[] field1908;
   @ObfuscatedName("af")
   static int[] field1888;
   @ObfuscatedName("ad")
   static int[] field1870;
   @ObfuscatedName("aj")
   static int[][] field1891;
   @ObfuscatedName("ae")
   static int[] field1859;
   @ObfuscatedName("ar")
   static int[][] field1844;
   @ObfuscatedName("bu")
   static int[] field1849;
   @ObfuscatedName("bk")
   static int[] field1895;
   @ObfuscatedName("bo")
   static int[] field1896;
   @ObfuscatedName("bl")
   static int[] field1897;
   @ObfuscatedName("bw")
   static int[] field1863;
   @ObfuscatedName("bj")
   @Export("xViewportBuffer")
   static int[] xViewportBuffer;
   @ObfuscatedName("bn")
   static int field1851;
   @ObfuscatedName("bt")
   static int field1901;
   @ObfuscatedName("bz")
   static int field1902;
   @ObfuscatedName("be")
   static boolean field1911;
   @ObfuscatedName("ba")
   static int[] field1906;
   @ObfuscatedName("br")
   static int[] field1907;
   @ObfuscatedName("bc")
   static int[] field1846;
   @ObfuscatedName("bp")
   static int[] field1903;
   @ObfuscatedName("v")
   int field1868;
   @ObfuscatedName("x")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("e")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("l")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("b")
   public int field1850;
   @ObfuscatedName("n")
   @Export("indices1")
   public int[] indices1;
   @ObfuscatedName("c")
   @Export("indices2")
   public int[] indices2;
   @ObfuscatedName("a")
   @Export("indices3")
   public int[] indices3;
   @ObfuscatedName("y")
   int[] field1854;
   @ObfuscatedName("w")
   int[] field1855;
   @ObfuscatedName("k")
   public int[] field1856;
   @ObfuscatedName("t")
   byte[] field1857;
   @ObfuscatedName("h")
   byte[] field1858;
   @ObfuscatedName("u")
   byte[] field1887;
   @ObfuscatedName("r")
   short[] field1890;
   @ObfuscatedName("g")
   byte field1861;
   @ObfuscatedName("z")
   int field1842;
   @ObfuscatedName("o")
   int[] field1843;
   @ObfuscatedName("d")
   int[] field1864;
   @ObfuscatedName("s")
   int[] field1865;
   @ObfuscatedName("f")
   int[][] field1871;
   @ObfuscatedName("q")
   int[][] field1867;
   @ObfuscatedName("al")
   public boolean field1860;
   @ObfuscatedName("ao")
   int field1894;
   @ObfuscatedName("aq")
   int field1899;
   @ObfuscatedName("ab")
   @Export("XYZMag")
   int XYZMag;
   @ObfuscatedName("as")
   int field1874;
   @ObfuscatedName("ag")
   int field1873;
   @ObfuscatedName("ap")
   public int field1892;
   @ObfuscatedName("av")
   public int field1875;
   @ObfuscatedName("ak")
   public int field1876;
   @ObfuscatedName("at")
   public int field1877;
   @ObfuscatedName("an")
   public int field1878;
   @ObfuscatedName("ah")
   public int field1879;

   static {
      field1909 = new Model();
      field1893 = new byte[1];
      field1885 = new Model();
      field1845 = new byte[1];
      field1881 = new boolean[4700];
      field1882 = new boolean[4700];
      field1900 = new int[4700];
      field1884 = new int[4700];
      field1866 = new int[4700];
      yViewportBuffer = new int[4700];
      field1908 = new int[4700];
      field1888 = new int[4700];
      field1870 = new int[1600];
      field1891 = new int[1600][512];
      field1859 = new int[12];
      field1844 = new int[12][2000];
      field1849 = new int[2000];
      field1895 = new int[2000];
      field1896 = new int[12];
      field1897 = new int[10];
      field1863 = new int[10];
      xViewportBuffer = new int[10];
      field1911 = true;
      field1906 = Graphics3D.SINE;
      field1907 = Graphics3D.COSINE;
      field1846 = Graphics3D.colorPalette;
      field1903 = Graphics3D.field1953;
   }

   Model() {
      this.field1868 = 0;
      this.field1850 = 0;
      this.field1861 = 0;
      this.field1842 = 0;
      this.field1860 = false;
      this.field1877 = -1;
      this.field1878 = -1;
      this.field1879 = -1;
   }

   @ObfuscatedSignature(
      signature = "([Len;I)V"
   )
   public Model(Model[] var1, int var2) {
      this.field1868 = 0;
      this.field1850 = 0;
      this.field1861 = 0;
      this.field1842 = 0;
      this.field1860 = false;
      this.field1877 = -1;
      this.field1878 = -1;
      this.field1879 = -1;
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1868 = 0;
      this.field1850 = 0;
      this.field1842 = 0;
      this.field1861 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1868 += var8.field1868;
            this.field1850 += var8.field1850;
            this.field1842 += var8.field1842;
            if(var8.field1857 != null) {
               var3 = true;
            } else {
               if(this.field1861 == -1) {
                  this.field1861 = var8.field1861;
               }

               if(this.field1861 != var8.field1861) {
                  var3 = true;
               }
            }

            var4 |= var8.field1858 != null;
            var5 |= var8.field1890 != null;
            var6 |= var8.field1887 != null;
         }
      }

      this.verticesX = new int[this.field1868];
      this.verticesY = new int[this.field1868];
      this.verticesZ = new int[this.field1868];
      this.indices1 = new int[this.field1850];
      this.indices2 = new int[this.field1850];
      this.indices3 = new int[this.field1850];
      this.field1854 = new int[this.field1850];
      this.field1855 = new int[this.field1850];
      this.field1856 = new int[this.field1850];
      if(var3) {
         this.field1857 = new byte[this.field1850];
      }

      if(var4) {
         this.field1858 = new byte[this.field1850];
      }

      if(var5) {
         this.field1890 = new short[this.field1850];
      }

      if(var6) {
         this.field1887 = new byte[this.field1850];
      }

      if(this.field1842 > 0) {
         this.field1843 = new int[this.field1842];
         this.field1864 = new int[this.field1842];
         this.field1865 = new int[this.field1842];
      }

      this.field1868 = 0;
      this.field1850 = 0;
      this.field1842 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1850; ++var9) {
               this.indices1[this.field1850] = this.field1868 + var8.indices1[var9];
               this.indices2[this.field1850] = this.field1868 + var8.indices2[var9];
               this.indices3[this.field1850] = this.field1868 + var8.indices3[var9];
               this.field1854[this.field1850] = var8.field1854[var9];
               this.field1855[this.field1850] = var8.field1855[var9];
               this.field1856[this.field1850] = var8.field1856[var9];
               if(var3) {
                  if(var8.field1857 != null) {
                     this.field1857[this.field1850] = var8.field1857[var9];
                  } else {
                     this.field1857[this.field1850] = var8.field1861;
                  }
               }

               if(var4 && var8.field1858 != null) {
                  this.field1858[this.field1850] = var8.field1858[var9];
               }

               if(var5) {
                  if(var8.field1890 != null) {
                     this.field1890[this.field1850] = var8.field1890[var9];
                  } else {
                     this.field1890[this.field1850] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1887 != null && var8.field1887[var9] != -1) {
                     this.field1887[this.field1850] = (byte)(this.field1842 + var8.field1887[var9]);
                  } else {
                     this.field1887[this.field1850] = -1;
                  }
               }

               ++this.field1850;
            }

            for(var9 = 0; var9 < var8.field1842; ++var9) {
               this.field1843[this.field1842] = this.field1868 + var8.field1843[var9];
               this.field1864[this.field1842] = this.field1868 + var8.field1864[var9];
               this.field1865[this.field1842] = this.field1868 + var8.field1865[var9];
               ++this.field1842;
            }

            for(var9 = 0; var9 < var8.field1868; ++var9) {
               this.verticesX[this.field1868] = var8.verticesX[var9];
               this.verticesY[this.field1868] = var8.verticesY[var9];
               this.verticesZ[this.field1868] = var8.verticesZ[var9];
               ++this.field1868;
            }
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([[IIIIZI)Len;"
   )
   public Model method2611(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2616();
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
               var11.field1868 = this.field1868;
               var11.field1850 = this.field1850;
               var11.field1842 = this.field1842;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1854 = this.field1854;
               var11.field1855 = this.field1855;
               var11.field1856 = this.field1856;
               var11.field1857 = this.field1857;
               var11.field1858 = this.field1858;
               var11.field1887 = this.field1887;
               var11.field1890 = this.field1890;
               var11.field1861 = this.field1861;
               var11.field1843 = this.field1843;
               var11.field1864 = this.field1864;
               var11.field1865 = this.field1865;
               var11.field1871 = this.field1871;
               var11.field1867 = this.field1867;
               var11.field1860 = this.field1860;
               var11.verticesY = new int[var11.field1868];
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
               for(var12 = 0; var12 < var11.field1868; ++var12) {
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
               for(var12 = 0; var12 < var11.field1868; ++var12) {
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

            var11.method2619();
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Z)Len;"
   )
   public Model method2640(boolean var1) {
      if(!var1 && field1893.length < this.field1850) {
         field1893 = new byte[this.field1850 + 100];
      }

      return this.method2614(var1, field1909, field1893);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Z)Len;"
   )
   public Model method2613(boolean var1) {
      if(!var1 && field1845.length < this.field1850) {
         field1845 = new byte[this.field1850 + 100];
      }

      return this.method2614(var1, field1885, field1845);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ZLen;[B)Len;"
   )
   Model method2614(boolean var1, Model var2, byte[] var3) {
      var2.field1868 = this.field1868;
      var2.field1850 = this.field1850;
      var2.field1842 = this.field1842;
      if(var2.verticesX == null || var2.verticesX.length < this.field1868) {
         var2.verticesX = new int[this.field1868 + 100];
         var2.verticesY = new int[this.field1868 + 100];
         var2.verticesZ = new int[this.field1868 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1868; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if(var1) {
         var2.field1858 = this.field1858;
      } else {
         var2.field1858 = var3;
         if(this.field1858 == null) {
            for(var4 = 0; var4 < this.field1850; ++var4) {
               var2.field1858[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1850; ++var4) {
               var2.field1858[var4] = this.field1858[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1854 = this.field1854;
      var2.field1855 = this.field1855;
      var2.field1856 = this.field1856;
      var2.field1857 = this.field1857;
      var2.field1887 = this.field1887;
      var2.field1890 = this.field1890;
      var2.field1861 = this.field1861;
      var2.field1843 = this.field1843;
      var2.field1864 = this.field1864;
      var2.field1865 = this.field1865;
      var2.field1871 = this.field1871;
      var2.field1867 = this.field1867;
      var2.field1860 = this.field1860;
      var2.method2619();
      return var2;
   }

   @ObfuscatedName("x")
   void method2687(int var1) {
      if(this.field1877 == -1) {
         int var2 = 0;
         int var3 = 0;
         int var4 = 0;
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         int var8 = field1907[var1];
         int var9 = field1906[var1];

         for(int var10 = 0; var10 < this.field1868; ++var10) {
            int var11 = Graphics3D.method2722(this.verticesX[var10], this.verticesZ[var10], var8, var9);
            int var12 = this.verticesY[var10];
            int var13 = Graphics3D.method2723(this.verticesX[var10], this.verticesZ[var10], var8, var9);
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

         this.field1892 = (var5 + var2) / 2;
         this.field1875 = (var6 + var3) / 2;
         this.field1876 = (var7 + var4) / 2;
         this.field1877 = (var5 - var2 + 1) / 2;
         this.field1878 = (var6 - var3 + 1) / 2;
         this.field1879 = (var7 - var4 + 1) / 2;
         if(this.field1877 < 32) {
            this.field1877 = 32;
         }

         if(this.field1879 < 32) {
            this.field1879 = 32;
         }

         if(this.field1860) {
            this.field1877 += 8;
            this.field1879 += 8;
         }

      }
   }

   @ObfuscatedName("e")
   public void method2616() {
      if(this.field1894 != 1) {
         this.field1894 = 1;
         super.modelHeight = 0;
         this.field1899 = 0;
         this.XYZMag = 0;

         for(int var1 = 0; var1 < this.field1868; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1899) {
               this.field1899 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.XYZMag) {
               this.XYZMag = var5;
            }
         }

         this.XYZMag = (int)(Math.sqrt((double)this.XYZMag) + 0.99D);
         this.field1873 = (int)(Math.sqrt((double)(this.XYZMag * this.XYZMag + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1874 = this.field1873 + (int)(Math.sqrt((double)(this.XYZMag * this.XYZMag + this.field1899 * this.field1899)) + 0.99D);
      }
   }

   @ObfuscatedName("l")
   void method2617() {
      if(this.field1894 != 2) {
         this.field1894 = 2;
         this.XYZMag = 0;

         for(int var1 = 0; var1 < this.field1868; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.XYZMag) {
               this.XYZMag = var5;
            }
         }

         this.XYZMag = (int)(Math.sqrt((double)this.XYZMag) + 0.99D);
         this.field1873 = this.XYZMag;
         this.field1874 = this.XYZMag + this.XYZMag;
      }
   }

   @ObfuscatedName("b")
   public int method2683() {
      this.method2616();
      return this.XYZMag;
   }

   @ObfuscatedName("n")
   void method2619() {
      this.field1894 = 0;
      this.field1877 = -1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lez;I)V"
   )
   public void method2620(Frames var1, int var2) {
      if(this.field1871 != null) {
         if(var2 != -1) {
            Frame var3 = var1.skeletons[var2];
            FrameMap var4 = var3.skin;
            field1851 = 0;
            field1901 = 0;
            field1902 = 0;

            for(int var5 = 0; var5 < var3.field1807; ++var5) {
               int var6 = var3.field1808[var5];
               this.method2624(var4.types[var6], var4.list[var6], var3.translator_x[var5], var3.translator_y[var5], var3.translator_z[var5]);
            }

            this.method2619();
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lez;ILez;I[I)V"
   )
   public void method2621(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.skeletons[var2];
            Frame var7 = var3.skeletons[var4];
            FrameMap var8 = var6.skin;
            field1851 = 0;
            field1901 = 0;
            field1902 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1807; ++var11) {
               for(var12 = var6.field1808[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.types[var12] == 0) {
                  this.method2624(var8.types[var12], var8.list[var12], var6.translator_x[var11], var6.translator_y[var11], var6.translator_z[var11]);
               }
            }

            field1851 = 0;
            field1901 = 0;
            field1902 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1807; ++var11) {
               for(var12 = var7.field1808[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.types[var12] == 0) {
                  this.method2624(var8.types[var12], var8.list[var12], var7.translator_x[var11], var7.translator_y[var11], var7.translator_z[var11]);
               }
            }

            this.method2619();
         } else {
            this.method2620(var1, var2);
         }
      }
   }

   @ObfuscatedName("k")
   void method2624(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1851 = 0;
         field1901 = 0;
         field1902 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var9 = var2[var8];
            if(var9 < this.field1871.length) {
               int[] var10 = this.field1871[var9];

               for(var11 = 0; var11 < var10.length; ++var11) {
                  var12 = var10[var11];
                  field1851 += this.verticesX[var12];
                  field1901 += this.verticesY[var12];
                  field1902 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1851 = var3 + field1851 / var7;
            field1901 = var4 + field1901 / var7;
            field1902 = var5 + field1902 / var7;
         } else {
            field1851 = var3;
            field1901 = var4;
            field1902 = var5;
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
                     this.verticesX[var11] -= field1851;
                     this.verticesY[var11] -= field1901;
                     this.verticesZ[var11] -= field1902;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1906[var14];
                        var16 = field1907[var14];
                        var17 = var15 * this.verticesY[var11] + var16 * this.verticesX[var11] >> 16;
                        this.verticesY[var11] = var16 * this.verticesY[var11] - var15 * this.verticesX[var11] >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1906[var12];
                        var16 = field1907[var12];
                        var17 = var16 * this.verticesY[var11] - var15 * this.verticesZ[var11] >> 16;
                        this.verticesZ[var11] = var15 * this.verticesY[var11] + var16 * this.verticesZ[var11] >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1906[var13];
                        var16 = field1907[var13];
                        var17 = var15 * this.verticesZ[var11] + var16 * this.verticesX[var11] >> 16;
                        this.verticesZ[var11] = var16 * this.verticesZ[var11] - var15 * this.verticesX[var11] >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += field1851;
                     this.verticesY[var11] += field1901;
                     this.verticesZ[var11] += field1902;
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
                     this.verticesX[var11] -= field1851;
                     this.verticesY[var11] -= field1901;
                     this.verticesZ[var11] -= field1902;
                     this.verticesX[var11] = var3 * this.verticesX[var11] / 128;
                     this.verticesY[var11] = var4 * this.verticesY[var11] / 128;
                     this.verticesZ[var11] = var5 * this.verticesZ[var11] / 128;
                     this.verticesX[var11] += field1851;
                     this.verticesY[var11] += field1901;
                     this.verticesZ[var11] += field1902;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1867 != null && this.field1858 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1867.length) {
                     var18 = this.field1867[var8];

                     for(var19 = 0; var19 < var18.length; ++var19) {
                        var11 = var18[var19];
                        var12 = (this.field1858[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1858[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("t")
   public void method2677() {
      for(int var1 = 0; var1 < this.field1868; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.method2619();
   }

   @ObfuscatedName("h")
   public void method2637() {
      for(int var1 = 0; var1 < this.field1868; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.method2619();
   }

   @ObfuscatedName("u")
   public void method2654() {
      for(int var1 = 0; var1 < this.field1868; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.method2619();
   }

   @ObfuscatedName("r")
   public void method2626(int var1) {
      int var2 = field1906[var1];
      int var3 = field1907[var1];

      for(int var4 = 0; var4 < this.field1868; ++var4) {
         int var5 = var3 * this.verticesY[var4] - var2 * this.verticesZ[var4] >> 16;
         this.verticesZ[var4] = var2 * this.verticesY[var4] + var3 * this.verticesZ[var4] >> 16;
         this.verticesY[var4] = var5;
      }

      this.method2619();
   }

   @ObfuscatedName("o")
   public void method2643(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1868; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.method2619();
   }

   @ObfuscatedName("q")
   public void method2628(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1868; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = var2 * this.verticesY[var4] / 128;
         this.verticesZ[var4] = var3 * this.verticesZ[var4] / 128;
      }

      this.method2619();
   }

   @ObfuscatedName("al")
   public final void method2629(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1870[0] = -1;
      if(this.field1894 != 2 && this.field1894 != 1) {
         this.method2617();
      }

      int var8 = Graphics3D.centerX;
      int var9 = Graphics3D.centerY;
      int var10 = field1906[var1];
      int var11 = field1907[var1];
      int var12 = field1906[var2];
      int var13 = field1907[var2];
      int var14 = field1906[var3];
      int var15 = field1907[var3];
      int var16 = field1906[var4];
      int var17 = field1907[var4];
      int var18 = var16 * var6 + var17 * var7 >> 16;

      for(int var19 = 0; var19 < this.field1868; ++var19) {
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
         field1866[var19] = var22 - var18;
         field1900[var19] = var20 * Graphics3D.field1940 / var22 + var8;
         field1884[var19] = var23 * Graphics3D.field1940 / var22 + var9;
         if(this.field1842 > 0) {
            yViewportBuffer[var19] = var20;
            field1908[var19] = var23;
            field1888[var19] = var22;
         }
      }

      try {
         this.method2632(false, false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("ao")
   public final void method2641(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1870[0] = -1;
      if(this.field1894 != 2 && this.field1894 != 1) {
         this.method2617();
      }

      int var9 = Graphics3D.centerX;
      int var10 = Graphics3D.centerY;
      int var11 = field1906[var1];
      int var12 = field1907[var1];
      int var13 = field1906[var2];
      int var14 = field1907[var2];
      int var15 = field1906[var3];
      int var16 = field1907[var3];
      int var17 = field1906[var4];
      int var18 = field1907[var4];
      int var19 = var17 * var6 + var18 * var7 >> 16;

      for(int var20 = 0; var20 < this.field1868; ++var20) {
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
         field1866[var20] = var23 - var19;
         field1900[var20] = var9 + var21 * Graphics3D.field1940 / var8;
         field1884[var20] = var10 + var24 * Graphics3D.field1940 / var8;
         if(this.field1842 > 0) {
            yViewportBuffer[var20] = var21;
            field1908[var20] = var24;
            field1888[var20] = var23;
         }
      }

      try {
         this.method2632(false, false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("aq")
   final void method2632(boolean var1, boolean var2, boolean var3, int var4) {
      if(this.field1874 < 1600) {
         int var5;
         for(var5 = 0; var5 < this.field1874; ++var5) {
            field1870[var5] = 0;
         }

         var5 = var3?20:5;
         if(class7.field232 && var2) {
            class150.method3029(this, var5);
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
         for(var6 = 0; var6 < this.field1850; ++var6) {
            if(this.field1856[var6] != -2) {
               var7 = this.indices1[var6];
               var8 = this.indices2[var6];
               var9 = this.indices3[var6];
               var10 = field1900[var7];
               var11 = field1900[var8];
               var12 = field1900[var9];
               int var13;
               if(!var1 || var10 != -5000 && var11 != -5000 && var12 != -5000) {
                  if(var2 && class44.method688(field1884[var7], field1884[var8], field1884[var9], var10, var11, var12, var5)) {
                     class133.field1922[++class133.field1921 - 1] = var4;
                     var2 = false;
                  }

                  if((var10 - var11) * (field1884[var9] - field1884[var8]) - (var12 - var11) * (field1884[var7] - field1884[var8]) > 0) {
                     field1882[var6] = false;
                     if(var10 >= 0 && var11 >= 0 && var12 >= 0 && var10 <= Graphics3D.rasterClipX && var11 <= Graphics3D.rasterClipX && var12 <= Graphics3D.rasterClipX) {
                        field1881[var6] = false;
                     } else {
                        field1881[var6] = true;
                     }

                     var13 = (field1866[var7] + field1866[var8] + field1866[var9]) / 3 + this.field1873;
                     field1891[var13][field1870[var13]++] = var6;
                  }
               } else {
                  var13 = yViewportBuffer[var7];
                  var14 = yViewportBuffer[var8];
                  var15 = yViewportBuffer[var9];
                  int var16 = field1908[var7];
                  var17 = field1908[var8];
                  int var18 = field1908[var9];
                  int var19 = field1888[var7];
                  int var20 = field1888[var8];
                  int var21 = field1888[var9];
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
                     field1882[var6] = true;
                     int var25 = (field1866[var7] + field1866[var8] + field1866[var9]) / 3 + this.field1873;
                     field1891[var25][field1870[var25]++] = var6;
                  }
               }
            }
         }

         int[] var26;
         if(this.field1857 == null) {
            for(var6 = this.field1874 - 1; var6 >= 0; --var6) {
               var7 = field1870[var6];
               if(var7 > 0) {
                  var26 = field1891[var6];

                  for(var9 = 0; var9 < var7; ++var9) {
                     this.method2633(var26[var9]);
                  }
               }
            }

         } else {
            for(var6 = 0; var6 < 12; ++var6) {
               field1859[var6] = 0;
               field1896[var6] = 0;
            }

            for(var6 = this.field1874 - 1; var6 >= 0; --var6) {
               var7 = field1870[var6];
               if(var7 > 0) {
                  var26 = field1891[var6];

                  for(var9 = 0; var9 < var7; ++var9) {
                     var10 = var26[var9];
                     byte var30 = this.field1857[var10];
                     var12 = field1859[var30]++;
                     field1844[var30][var12] = var10;
                     if(var30 < 10) {
                        field1896[var30] += var6;
                     } else if(var30 == 10) {
                        field1849[var12] = var6;
                     } else {
                        field1895[var12] = var6;
                     }
                  }
               }
            }

            var6 = 0;
            if(field1859[1] > 0 || field1859[2] > 0) {
               var6 = (field1896[1] + field1896[2]) / (field1859[1] + field1859[2]);
            }

            var7 = 0;
            if(field1859[3] > 0 || field1859[4] > 0) {
               var7 = (field1896[3] + field1896[4]) / (field1859[3] + field1859[4]);
            }

            var8 = 0;
            if(field1859[6] > 0 || field1859[8] > 0) {
               var8 = (field1896[8] + field1896[6]) / (field1859[8] + field1859[6]);
            }

            var10 = 0;
            var11 = field1859[10];
            int[] var27 = field1844[10];
            int[] var28 = field1849;
            if(var10 == var11) {
               var10 = 0;
               var11 = field1859[11];
               var27 = field1844[11];
               var28 = field1895;
            }

            if(var10 < var11) {
               var9 = var28[var10];
            } else {
               var9 = -1000;
            }

            for(var14 = 0; var14 < 10; ++var14) {
               while(var14 == 0 && var9 > var6) {
                  this.method2633(var27[var10++]);
                  if(var10 == var11 && var27 != field1844[11]) {
                     var10 = 0;
                     var11 = field1859[11];
                     var27 = field1844[11];
                     var28 = field1895;
                  }

                  if(var10 < var11) {
                     var9 = var28[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 3 && var9 > var7) {
                  this.method2633(var27[var10++]);
                  if(var10 == var11 && var27 != field1844[11]) {
                     var10 = 0;
                     var11 = field1859[11];
                     var27 = field1844[11];
                     var28 = field1895;
                  }

                  if(var10 < var11) {
                     var9 = var28[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 5 && var9 > var8) {
                  this.method2633(var27[var10++]);
                  if(var10 == var11 && var27 != field1844[11]) {
                     var10 = 0;
                     var11 = field1859[11];
                     var27 = field1844[11];
                     var28 = field1895;
                  }

                  if(var10 < var11) {
                     var9 = var28[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               var15 = field1859[var14];
               int[] var29 = field1844[var14];

               for(var17 = 0; var17 < var15; ++var17) {
                  this.method2633(var29[var17]);
               }
            }

            while(var9 != -1000) {
               this.method2633(var27[var10++]);
               if(var10 == var11 && var27 != field1844[11]) {
                  var10 = 0;
                  var27 = field1844[11];
                  var11 = field1859[11];
                  var28 = field1895;
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

   @ObfuscatedName("ab")
   final void method2633(int var1) {
      if(field1882[var1]) {
         this.method2634(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         Graphics3D.rasterClipEnable = field1881[var1];
         if(this.field1858 == null) {
            Graphics3D.rasterAlpha = 0;
         } else {
            Graphics3D.rasterAlpha = this.field1858[var1] & 255;
         }

         if(this.field1890 != null && this.field1890[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1887 != null && this.field1887[var1] != -1) {
               int var8 = this.field1887[var1] & 255;
               var5 = this.field1843[var8];
               var6 = this.field1864[var8];
               var7 = this.field1865[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1856[var1] == -1) {
               Graphics3D.rasterTextureAffine(field1884[var2], field1884[var3], field1884[var4], field1900[var2], field1900[var3], field1900[var4], this.field1854[var1], this.field1854[var1], this.field1854[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1908[var5], field1908[var6], field1908[var7], field1888[var5], field1888[var6], field1888[var7], this.field1890[var1]);
            } else {
               Graphics3D.rasterTextureAffine(field1884[var2], field1884[var3], field1884[var4], field1900[var2], field1900[var3], field1900[var4], this.field1854[var1], this.field1855[var1], this.field1856[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1908[var5], field1908[var6], field1908[var7], field1888[var5], field1888[var6], field1888[var7], this.field1890[var1]);
            }
         } else if(this.field1856[var1] == -1) {
            Graphics3D.rasterFlat(field1884[var2], field1884[var3], field1884[var4], field1900[var2], field1900[var3], field1900[var4], field1846[this.field1854[var1]]);
         } else {
            Graphics3D.rasterGouraud(field1884[var2], field1884[var3], field1884[var4], field1900[var2], field1900[var3], field1900[var4], this.field1854[var1], this.field1855[var1], this.field1856[var1]);
         }

      }
   }

   @ObfuscatedName("as")
   final void method2634(int var1) {
      int var2 = Graphics3D.centerX;
      int var3 = Graphics3D.centerY;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1888[var5];
      int var9 = field1888[var6];
      int var10 = field1888[var7];
      if(this.field1858 == null) {
         Graphics3D.rasterAlpha = 0;
      } else {
         Graphics3D.rasterAlpha = this.field1858[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1897[var4] = field1900[var5];
         field1863[var4] = field1884[var5];
         xViewportBuffer[var4++] = this.field1854[var1];
      } else {
         var11 = yViewportBuffer[var5];
         var12 = field1908[var5];
         var13 = this.field1854[var1];
         if(var10 >= 50) {
            var14 = field1903[var10 - var8] * (50 - var8);
            field1897[var4] = var2 + Graphics3D.field1940 * (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) / 50;
            field1863[var4] = var3 + Graphics3D.field1940 * (var12 + ((field1908[var7] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1856[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = field1903[var9 - var8] * (50 - var8);
            field1897[var4] = var2 + Graphics3D.field1940 * (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) / 50;
            field1863[var4] = var3 + Graphics3D.field1940 * (var12 + ((field1908[var6] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1855[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1897[var4] = field1900[var6];
         field1863[var4] = field1884[var6];
         xViewportBuffer[var4++] = this.field1855[var1];
      } else {
         var11 = yViewportBuffer[var6];
         var12 = field1908[var6];
         var13 = this.field1855[var1];
         if(var8 >= 50) {
            var14 = field1903[var8 - var9] * (50 - var9);
            field1897[var4] = var2 + Graphics3D.field1940 * (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) / 50;
            field1863[var4] = var3 + Graphics3D.field1940 * (var12 + ((field1908[var5] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1854[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = field1903[var10 - var9] * (50 - var9);
            field1897[var4] = var2 + Graphics3D.field1940 * (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) / 50;
            field1863[var4] = var3 + Graphics3D.field1940 * (var12 + ((field1908[var7] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1856[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1897[var4] = field1900[var7];
         field1863[var4] = field1884[var7];
         xViewportBuffer[var4++] = this.field1856[var1];
      } else {
         var11 = yViewportBuffer[var7];
         var12 = field1908[var7];
         var13 = this.field1856[var1];
         if(var9 >= 50) {
            var14 = field1903[var9 - var10] * (50 - var10);
            field1897[var4] = var2 + Graphics3D.field1940 * (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) / 50;
            field1863[var4] = var3 + Graphics3D.field1940 * (var12 + ((field1908[var6] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1855[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = field1903[var8 - var10] * (50 - var10);
            field1897[var4] = var2 + Graphics3D.field1940 * (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) / 50;
            field1863[var4] = var3 + Graphics3D.field1940 * (var12 + ((field1908[var5] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1854[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1897[0];
      var12 = field1897[1];
      var13 = field1897[2];
      var14 = field1863[0];
      int var15 = field1863[1];
      int var16 = field1863[2];
      Graphics3D.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX) {
            Graphics3D.rasterClipEnable = true;
         }

         if(this.field1890 != null && this.field1890[var1] != -1) {
            if(this.field1887 != null && this.field1887[var1] != -1) {
               var20 = this.field1887[var1] & 255;
               var17 = this.field1843[var20];
               var18 = this.field1864[var20];
               var19 = this.field1865[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1856[var1] == -1) {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1854[var1], this.field1854[var1], this.field1854[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1908[var17], field1908[var18], field1908[var19], field1888[var17], field1888[var18], field1888[var19], this.field1890[var1]);
            } else {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1908[var17], field1908[var18], field1908[var19], field1888[var17], field1888[var18], field1888[var19], this.field1890[var1]);
            }
         } else if(this.field1856[var1] == -1) {
            Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, field1846[this.field1854[var1]]);
         } else {
            Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX || field1897[3] < 0 || field1897[3] > Graphics3D.rasterClipX) {
            Graphics3D.rasterClipEnable = true;
         }

         if(this.field1890 != null && this.field1890[var1] != -1) {
            if(this.field1887 != null && this.field1887[var1] != -1) {
               var20 = this.field1887[var1] & 255;
               var17 = this.field1843[var20];
               var18 = this.field1864[var20];
               var19 = this.field1865[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1890[var1];
            if(this.field1856[var1] == -1) {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1854[var1], this.field1854[var1], this.field1854[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1908[var17], field1908[var18], field1908[var19], field1888[var17], field1888[var18], field1888[var19], var21);
               Graphics3D.rasterTextureAffine(var14, var16, field1863[3], var11, var13, field1897[3], this.field1854[var1], this.field1854[var1], this.field1854[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1908[var17], field1908[var18], field1908[var19], field1888[var17], field1888[var18], field1888[var19], var21);
            } else {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1908[var17], field1908[var18], field1908[var19], field1888[var17], field1888[var18], field1888[var19], var21);
               Graphics3D.rasterTextureAffine(var14, var16, field1863[3], var11, var13, field1897[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1908[var17], field1908[var18], field1908[var19], field1888[var17], field1888[var18], field1888[var19], var21);
            }
         } else if(this.field1856[var1] == -1) {
            var17 = field1846[this.field1854[var1]];
            Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            Graphics3D.rasterFlat(var14, var16, field1863[3], var11, var13, field1897[3], var17);
         } else {
            Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
            Graphics3D.rasterGouraud(var14, var16, field1863[3], var11, var13, field1897[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3]);
         }
      }

   }

   @ObfuscatedName("cp")
   @Export("draw")
   void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1870[0] = -1;
      if(this.field1894 != 1) {
         this.method2616();
      }

      this.method2687(var1);
      int var10 = var5 * var8 - var4 * var6 >> 16;
      int var11 = var2 * var7 + var3 * var10 >> 16;
      int var12 = var3 * this.XYZMag >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var5 * var6 >> 16;
         int var15 = (var14 - this.XYZMag) * Graphics3D.field1940;
         if(var15 / var13 < Graphics3D.field1954) {
            int var16 = (var14 + this.XYZMag) * Graphics3D.field1940;
            if(var16 / var13 > Graphics3D.field1945) {
               int var17 = var3 * var7 - var10 * var2 >> 16;
               int var18 = var2 * this.XYZMag >> 16;
               int var19 = (var17 + var18) * Graphics3D.field1940;
               if(var19 / var13 > Graphics3D.field1947) {
                  int var20 = (var3 * super.modelHeight >> 16) + var18;
                  int var21 = (var17 - var20) * Graphics3D.field1940;
                  if(var21 / var13 < Graphics3D.field1948) {
                     int var22 = var12 + (var2 * super.modelHeight >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1842 > 0;
                     int var26 = class133.field1914;
                     int var28 = WorldMapType1.method292();
                     boolean var29 = class54.method863();
                     if(class7.field233 && var9 > 0) {
                        class41.method642(this, var6, var7, var8);
                     }

                     int var31;
                     int var32;
                     int var33;
                     int var34;
                     int var35;
                     int var36;
                     int var37;
                     if(class7.field230 && var9 > 0) {
                        int var30 = var11 - var12;
                        if(var30 <= 50) {
                           var30 = 50;
                        }

                        if(var14 > 0) {
                           var31 = var15 / var13;
                           var32 = var16 / var30;
                        } else {
                           var32 = var16 / var13;
                           var31 = var15 / var30;
                        }

                        if(var17 > 0) {
                           var33 = var21 / var13;
                           var34 = var19 / var30;
                        } else {
                           var34 = var19 / var13;
                           var33 = var21 / var30;
                        }

                        var35 = -8355840;
                        var36 = var26 - Graphics3D.centerX;
                        var37 = var28 - Graphics3D.centerY;
                        if(var36 > var31 && var36 < var32 && var37 > var33 && var37 < var34) {
                           var35 = -256;
                        }

                        GroundObject.method2599(var31 + Graphics3D.centerX, var33 + Graphics3D.centerY, var32 + Graphics3D.centerX, var34 + Graphics3D.centerY, var35);
                     }

                     boolean var42 = false;
                     if(var9 > 0 && var29) {
                        boolean var43 = false;
                        if(field1911) {
                           var43 = class48.method794(this, var6, var7, var8);
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
                           if(this.field1860) {
                              class133.field1922[++class133.field1921 - 1] = var9;
                           } else {
                              var42 = true;
                           }
                        }
                     }

                     var31 = Graphics3D.centerX;
                     var32 = Graphics3D.centerY;
                     var33 = 0;
                     var34 = 0;
                     if(var1 != 0) {
                        var33 = field1906[var1];
                        var34 = field1907[var1];
                     }

                     for(var35 = 0; var35 < this.field1868; ++var35) {
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
                        field1866[var35] = var38 - var11;
                        if(var38 >= 50) {
                           field1900[var35] = var36 * Graphics3D.field1940 / var38 + var31;
                           field1884[var35] = var39 * Graphics3D.field1940 / var38 + var32;
                        } else {
                           field1900[var35] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           yViewportBuffer[var35] = var36;
                           field1908[var35] = var39;
                           field1888[var35] = var38;
                        }
                     }

                     try {
                        this.method2632(var23, var42, this.field1860, var9);
                     } catch (Exception var41) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }
}
