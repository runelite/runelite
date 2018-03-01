import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lel;"
   )
   static Model field1849;
   @ObfuscatedName("z")
   static byte[] field1890;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lel;"
   )
   static Model field1852;
   @ObfuscatedName("r")
   static byte[] field1836;
   @ObfuscatedName("ar")
   static boolean[] field1872;
   @ObfuscatedName("ao")
   static boolean[] field1873;
   @ObfuscatedName("at")
   @Export("modelViewportYs")
   static int[] modelViewportYs;
   @ObfuscatedName("ag")
   @Export("modelViewportXs")
   static int[] modelViewportXs;
   @ObfuscatedName("an")
   static int[] field1835;
   @ObfuscatedName("ax")
   @Export("yViewportBuffer")
   static int[] yViewportBuffer;
   @ObfuscatedName("ah")
   static int[] field1878;
   @ObfuscatedName("ab")
   static int[] field1879;
   @ObfuscatedName("ay")
   static int[] field1881;
   @ObfuscatedName("aj")
   static int[][] field1882;
   @ObfuscatedName("aa")
   static int[] field1883;
   @ObfuscatedName("av")
   static int[][] field1888;
   @ObfuscatedName("bc")
   static int[] field1834;
   @ObfuscatedName("br")
   static int[] field1886;
   @ObfuscatedName("by")
   static int[] field1887;
   @ObfuscatedName("bl")
   static int[] field1861;
   @ObfuscatedName("bs")
   static int[] field1853;
   @ObfuscatedName("bu")
   @Export("xViewportBuffer")
   static int[] xViewportBuffer;
   @ObfuscatedName("bz")
   static int field1891;
   @ObfuscatedName("bt")
   static int field1892;
   @ObfuscatedName("bm")
   static int field1864;
   @ObfuscatedName("bf")
   @Export("useBoundingBoxes3D")
   static boolean useBoundingBoxes3D;
   @ObfuscatedName("be")
   @Export("Model_sine")
   static int[] Model_sine;
   @ObfuscatedName("bn")
   @Export("Model_cosine")
   static int[] Model_cosine;
   @ObfuscatedName("bw")
   static int[] field1893;
   @ObfuscatedName("bg")
   static int[] field1900;
   @ObfuscatedName("e")
   @Export("verticesCount")
   int verticesCount;
   @ObfuscatedName("y")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("k")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("s")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("p")
   @Export("indicesCount")
   int indicesCount;
   @ObfuscatedName("x")
   @Export("indices1")
   int[] indices1;
   @ObfuscatedName("m")
   @Export("indices2")
   int[] indices2;
   @ObfuscatedName("h")
   @Export("indices3")
   int[] indices3;
   @ObfuscatedName("t")
   int[] field1845;
   @ObfuscatedName("i")
   int[] field1850;
   @ObfuscatedName("u")
   int[] field1847;
   @ObfuscatedName("q")
   byte[] field1848;
   @ObfuscatedName("v")
   byte[] field1876;
   @ObfuscatedName("f")
   byte[] field1871;
   @ObfuscatedName("b")
   short[] field1851;
   @ObfuscatedName("c")
   byte field1841;
   @ObfuscatedName("j")
   int field1840;
   @ObfuscatedName("l")
   int[] field1854;
   @ObfuscatedName("g")
   int[] field1855;
   @ObfuscatedName("w")
   int[] field1856;
   @ObfuscatedName("o")
   int[][] field1857;
   @ObfuscatedName("a")
   int[][] field1889;
   @ObfuscatedName("ak")
   public boolean field1859;
   @ObfuscatedName("ap")
   @Export("boundsType")
   int boundsType;
   @ObfuscatedName("ac")
   @Export("bottomY")
   int bottomY;
   @ObfuscatedName("aw")
   @Export("XYZMag")
   int XYZMag;
   @ObfuscatedName("as")
   @Export("diameter")
   int diameter;
   @ObfuscatedName("au")
   @Export("radius")
   int radius;
   @ObfuscatedName("al")
   @Export("centerX")
   public int centerX;
   @ObfuscatedName("af")
   @Export("centerY")
   public int centerY;
   @ObfuscatedName("ai")
   @Export("centerZ")
   public int centerZ;
   @ObfuscatedName("az")
   @Export("extremeX")
   public int extremeX;
   @ObfuscatedName("aq")
   @Export("extremeY")
   public int extremeY;
   @ObfuscatedName("ae")
   @Export("extremeZ")
   public int extremeZ;

   static {
      field1849 = new Model();
      field1890 = new byte[1];
      field1852 = new Model();
      field1836 = new byte[1];
      field1872 = new boolean[4700];
      field1873 = new boolean[4700];
      modelViewportYs = new int[4700];
      modelViewportXs = new int[4700];
      field1835 = new int[4700];
      yViewportBuffer = new int[4700];
      field1878 = new int[4700];
      field1879 = new int[4700];
      field1881 = new int[1600];
      field1882 = new int[1600][512];
      field1883 = new int[12];
      field1888 = new int[12][2000];
      field1834 = new int[2000];
      field1886 = new int[2000];
      field1887 = new int[12];
      field1861 = new int[10];
      field1853 = new int[10];
      xViewportBuffer = new int[10];
      useBoundingBoxes3D = true;
      Model_sine = Graphics3D.SINE;
      Model_cosine = Graphics3D.COSINE;
      field1893 = Graphics3D.colorPalette;
      field1900 = Graphics3D.field1942;
   }

   Model() {
      this.verticesCount = 0;
      this.indicesCount = 0;
      this.field1841 = 0;
      this.field1840 = 0;
      this.field1859 = false;
      this.extremeX = -1;
      this.extremeY = -1;
      this.extremeZ = -1;
   }

   @ObfuscatedSignature(
      signature = "([Lel;I)V"
   )
   public Model(Model[] var1, int var2) {
      this.verticesCount = 0;
      this.indicesCount = 0;
      this.field1841 = 0;
      this.field1840 = 0;
      this.field1859 = false;
      this.extremeX = -1;
      this.extremeY = -1;
      this.extremeZ = -1;
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.verticesCount = 0;
      this.indicesCount = 0;
      this.field1840 = 0;
      this.field1841 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.verticesCount += var8.verticesCount;
            this.indicesCount += var8.indicesCount;
            this.field1840 += var8.field1840;
            if(var8.field1848 != null) {
               var3 = true;
            } else {
               if(this.field1841 == -1) {
                  this.field1841 = var8.field1841;
               }

               if(this.field1841 != var8.field1841) {
                  var3 = true;
               }
            }

            var4 |= var8.field1876 != null;
            var5 |= var8.field1851 != null;
            var6 |= var8.field1871 != null;
         }
      }

      this.verticesX = new int[this.verticesCount];
      this.verticesY = new int[this.verticesCount];
      this.verticesZ = new int[this.verticesCount];
      this.indices1 = new int[this.indicesCount];
      this.indices2 = new int[this.indicesCount];
      this.indices3 = new int[this.indicesCount];
      this.field1845 = new int[this.indicesCount];
      this.field1850 = new int[this.indicesCount];
      this.field1847 = new int[this.indicesCount];
      if(var3) {
         this.field1848 = new byte[this.indicesCount];
      }

      if(var4) {
         this.field1876 = new byte[this.indicesCount];
      }

      if(var5) {
         this.field1851 = new short[this.indicesCount];
      }

      if(var6) {
         this.field1871 = new byte[this.indicesCount];
      }

      if(this.field1840 > 0) {
         this.field1854 = new int[this.field1840];
         this.field1855 = new int[this.field1840];
         this.field1856 = new int[this.field1840];
      }

      this.verticesCount = 0;
      this.indicesCount = 0;
      this.field1840 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.indicesCount; ++var9) {
               this.indices1[this.indicesCount] = this.verticesCount + var8.indices1[var9];
               this.indices2[this.indicesCount] = this.verticesCount + var8.indices2[var9];
               this.indices3[this.indicesCount] = this.verticesCount + var8.indices3[var9];
               this.field1845[this.indicesCount] = var8.field1845[var9];
               this.field1850[this.indicesCount] = var8.field1850[var9];
               this.field1847[this.indicesCount] = var8.field1847[var9];
               if(var3) {
                  if(var8.field1848 != null) {
                     this.field1848[this.indicesCount] = var8.field1848[var9];
                  } else {
                     this.field1848[this.indicesCount] = var8.field1841;
                  }
               }

               if(var4 && var8.field1876 != null) {
                  this.field1876[this.indicesCount] = var8.field1876[var9];
               }

               if(var5) {
                  if(var8.field1851 != null) {
                     this.field1851[this.indicesCount] = var8.field1851[var9];
                  } else {
                     this.field1851[this.indicesCount] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1871 != null && var8.field1871[var9] != -1) {
                     this.field1871[this.indicesCount] = (byte)(this.field1840 + var8.field1871[var9]);
                  } else {
                     this.field1871[this.indicesCount] = -1;
                  }
               }

               ++this.indicesCount;
            }

            for(var9 = 0; var9 < var8.field1840; ++var9) {
               this.field1854[this.field1840] = this.verticesCount + var8.field1854[var9];
               this.field1855[this.field1840] = this.verticesCount + var8.field1855[var9];
               this.field1856[this.field1840] = this.verticesCount + var8.field1856[var9];
               ++this.field1840;
            }

            for(var9 = 0; var9 < var8.verticesCount; ++var9) {
               this.verticesX[this.verticesCount] = var8.verticesX[var9];
               this.verticesY[this.verticesCount] = var8.verticesY[var9];
               this.verticesZ[this.verticesCount] = var8.verticesZ[var9];
               ++this.verticesCount;
            }
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([[IIIIZI)Lel;"
   )
   public Model method2828(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.calculateBoundsCylinder();
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
               var11.verticesCount = this.verticesCount;
               var11.indicesCount = this.indicesCount;
               var11.field1840 = this.field1840;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1845 = this.field1845;
               var11.field1850 = this.field1850;
               var11.field1847 = this.field1847;
               var11.field1848 = this.field1848;
               var11.field1876 = this.field1876;
               var11.field1871 = this.field1871;
               var11.field1851 = this.field1851;
               var11.field1841 = this.field1841;
               var11.field1854 = this.field1854;
               var11.field1855 = this.field1855;
               var11.field1856 = this.field1856;
               var11.field1857 = this.field1857;
               var11.field1889 = this.field1889;
               var11.field1859 = this.field1859;
               var11.verticesY = new int[var11.verticesCount];
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
               for(var12 = 0; var12 < var11.verticesCount; ++var12) {
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
               for(var12 = 0; var12 < var11.verticesCount; ++var12) {
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

            var11.resetBounds();
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Z)Lel;"
   )
   public Model method2756(boolean var1) {
      if(!var1 && field1890.length < this.indicesCount) {
         field1890 = new byte[this.indicesCount + 100];
      }

      return this.method2758(var1, field1849, field1890);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Z)Lel;"
   )
   public Model method2781(boolean var1) {
      if(!var1 && field1836.length < this.indicesCount) {
         field1836 = new byte[this.indicesCount + 100];
      }

      return this.method2758(var1, field1852, field1836);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ZLel;[B)Lel;"
   )
   Model method2758(boolean var1, Model var2, byte[] var3) {
      var2.verticesCount = this.verticesCount;
      var2.indicesCount = this.indicesCount;
      var2.field1840 = this.field1840;
      if(var2.verticesX == null || var2.verticesX.length < this.verticesCount) {
         var2.verticesX = new int[this.verticesCount + 100];
         var2.verticesY = new int[this.verticesCount + 100];
         var2.verticesZ = new int[this.verticesCount + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.verticesCount; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if(var1) {
         var2.field1876 = this.field1876;
      } else {
         var2.field1876 = var3;
         if(this.field1876 == null) {
            for(var4 = 0; var4 < this.indicesCount; ++var4) {
               var2.field1876[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.indicesCount; ++var4) {
               var2.field1876[var4] = this.field1876[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1845 = this.field1845;
      var2.field1850 = this.field1850;
      var2.field1847 = this.field1847;
      var2.field1848 = this.field1848;
      var2.field1871 = this.field1871;
      var2.field1851 = this.field1851;
      var2.field1841 = this.field1841;
      var2.field1854 = this.field1854;
      var2.field1855 = this.field1855;
      var2.field1856 = this.field1856;
      var2.field1857 = this.field1857;
      var2.field1889 = this.field1889;
      var2.field1859 = this.field1859;
      var2.resetBounds();
      return var2;
   }

   @ObfuscatedName("e")
   void method2759(int var1) {
      if(this.extremeX == -1) {
         int var2 = 0;
         int var3 = 0;
         int var4 = 0;
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         int var8 = Model_cosine[var1];
         int var9 = Model_sine[var1];

         for(int var10 = 0; var10 < this.verticesCount; ++var10) {
            int var11 = Graphics3D.method2896(this.verticesX[var10], this.verticesZ[var10], var8, var9);
            int var12 = this.verticesY[var10];
            int var13 = Graphics3D.method2864(this.verticesX[var10], this.verticesZ[var10], var8, var9);
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

         this.centerX = (var5 + var2) / 2;
         this.centerY = (var6 + var3) / 2;
         this.centerZ = (var7 + var4) / 2;
         this.extremeX = (var5 - var2 + 1) / 2;
         this.extremeY = (var6 - var3 + 1) / 2;
         this.extremeZ = (var7 - var4 + 1) / 2;
         if(this.extremeX < 32) {
            this.extremeX = 32;
         }

         if(this.extremeZ < 32) {
            this.extremeZ = 32;
         }

         if(this.field1859) {
            this.extremeX += 8;
            this.extremeZ += 8;
         }

      }
   }

   @ObfuscatedName("y")
   @Export("calculateBoundsCylinder")
   public void calculateBoundsCylinder() {
      if(this.boundsType != 1) {
         this.boundsType = 1;
         super.modelHeight = 0;
         this.bottomY = 0;
         this.XYZMag = 0;

         for(int var1 = 0; var1 < this.verticesCount; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.bottomY) {
               this.bottomY = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.XYZMag) {
               this.XYZMag = var5;
            }
         }

         this.XYZMag = (int)(Math.sqrt((double)this.XYZMag) + 0.99D);
         this.radius = (int)(Math.sqrt((double)(this.XYZMag * this.XYZMag + super.modelHeight * super.modelHeight)) + 0.99D);
         this.diameter = this.radius + (int)(Math.sqrt((double)(this.XYZMag * this.XYZMag + this.bottomY * this.bottomY)) + 0.99D);
      }
   }

   @ObfuscatedName("k")
   void method2825() {
      if(this.boundsType != 2) {
         this.boundsType = 2;
         this.XYZMag = 0;

         for(int var1 = 0; var1 < this.verticesCount; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.XYZMag) {
               this.XYZMag = var5;
            }
         }

         this.XYZMag = (int)(Math.sqrt((double)this.XYZMag) + 0.99D);
         this.radius = this.XYZMag;
         this.diameter = this.XYZMag + this.XYZMag;
      }
   }

   @ObfuscatedName("s")
   public int method2762() {
      this.calculateBoundsCylinder();
      return this.XYZMag;
   }

   @ObfuscatedName("h")
   @Export("resetBounds")
   void resetBounds() {
      this.boundsType = 0;
      this.extremeX = -1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lei;I)V"
   )
   public void method2764(Frames var1, int var2) {
      if(this.field1857 != null) {
         if(var2 != -1) {
            Frame var3 = var1.skeletons[var2];
            FrameMap var4 = var3.skin;
            field1891 = 0;
            field1892 = 0;
            field1864 = 0;

            for(int var5 = 0; var5 < var3.field1803; ++var5) {
               int var6 = var3.field1806[var5];
               this.method2766(var4.types[var6], var4.list[var6], var3.translator_x[var5], var3.translator_y[var5], var3.translator_z[var5]);
            }

            this.resetBounds();
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lei;ILei;I[I)V"
   )
   public void method2765(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.skeletons[var2];
            Frame var7 = var3.skeletons[var4];
            FrameMap var8 = var6.skin;
            field1891 = 0;
            field1892 = 0;
            field1864 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1803; ++var11) {
               for(var12 = var6.field1806[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.types[var12] == 0) {
                  this.method2766(var8.types[var12], var8.list[var12], var6.translator_x[var11], var6.translator_y[var11], var6.translator_z[var11]);
               }
            }

            field1891 = 0;
            field1892 = 0;
            field1864 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1803; ++var11) {
               for(var12 = var7.field1806[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.types[var12] == 0) {
                  this.method2766(var8.types[var12], var8.list[var12], var7.translator_x[var11], var7.translator_y[var11], var7.translator_z[var11]);
               }
            }

            this.resetBounds();
         } else {
            this.method2764(var1, var2);
         }
      }
   }

   @ObfuscatedName("u")
   void method2766(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1891 = 0;
         field1892 = 0;
         field1864 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var9 = var2[var8];
            if(var9 < this.field1857.length) {
               int[] var10 = this.field1857[var9];

               for(var11 = 0; var11 < var10.length; ++var11) {
                  var12 = var10[var11];
                  field1891 += this.verticesX[var12];
                  field1892 += this.verticesY[var12];
                  field1864 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1891 = var3 + field1891 / var7;
            field1892 = var4 + field1892 / var7;
            field1864 = var5 + field1864 / var7;
         } else {
            field1891 = var3;
            field1892 = var4;
            field1864 = var5;
         }

      } else {
         int[] var18;
         int var19;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1857.length) {
                  var18 = this.field1857[var8];

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
               if(var8 < this.field1857.length) {
                  var18 = this.field1857[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= field1891;
                     this.verticesY[var11] -= field1892;
                     this.verticesZ[var11] -= field1864;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = Model_sine[var14];
                        var16 = Model_cosine[var14];
                        var17 = var15 * this.verticesY[var11] + var16 * this.verticesX[var11] >> 16;
                        this.verticesY[var11] = var16 * this.verticesY[var11] - var15 * this.verticesX[var11] >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = Model_sine[var12];
                        var16 = Model_cosine[var12];
                        var17 = var16 * this.verticesY[var11] - var15 * this.verticesZ[var11] >> 16;
                        this.verticesZ[var11] = var15 * this.verticesY[var11] + var16 * this.verticesZ[var11] >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = Model_sine[var13];
                        var16 = Model_cosine[var13];
                        var17 = var15 * this.verticesZ[var11] + var16 * this.verticesX[var11] >> 16;
                        this.verticesZ[var11] = var16 * this.verticesZ[var11] - var15 * this.verticesX[var11] >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += field1891;
                     this.verticesY[var11] += field1892;
                     this.verticesZ[var11] += field1864;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1857.length) {
                  var18 = this.field1857[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= field1891;
                     this.verticesY[var11] -= field1892;
                     this.verticesZ[var11] -= field1864;
                     this.verticesX[var11] = var3 * this.verticesX[var11] / 128;
                     this.verticesY[var11] = var4 * this.verticesY[var11] / 128;
                     this.verticesZ[var11] = var5 * this.verticesZ[var11] / 128;
                     this.verticesX[var11] += field1891;
                     this.verticesY[var11] += field1892;
                     this.verticesZ[var11] += field1864;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1889 != null && this.field1876 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1889.length) {
                     var18 = this.field1889[var8];

                     for(var19 = 0; var19 < var18.length; ++var19) {
                        var11 = var18[var19];
                        var12 = (this.field1876[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1876[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("q")
   @Export("rotateY90Ccw")
   public void rotateY90Ccw() {
      for(int var1 = 0; var1 < this.verticesCount; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.resetBounds();
   }

   @ObfuscatedName("v")
   public void method2768() {
      for(int var1 = 0; var1 < this.verticesCount; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.resetBounds();
   }

   @ObfuscatedName("f")
   public void method2769() {
      for(int var1 = 0; var1 < this.verticesCount; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.resetBounds();
   }

   @ObfuscatedName("b")
   @Export("rotateZ")
   public void rotateZ(int var1) {
      int var2 = Model_sine[var1];
      int var3 = Model_cosine[var1];

      for(int var4 = 0; var4 < this.verticesCount; ++var4) {
         int var5 = var3 * this.verticesY[var4] - var2 * this.verticesZ[var4] >> 16;
         this.verticesZ[var4] = var2 * this.verticesY[var4] + var3 * this.verticesZ[var4] >> 16;
         this.verticesY[var4] = var5;
      }

      this.resetBounds();
   }

   @ObfuscatedName("c")
   @Export("offsetBy")
   public void offsetBy(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.verticesCount; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.resetBounds();
   }

   @ObfuscatedName("w")
   @Export("scale")
   public void scale(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.verticesCount; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = var2 * this.verticesY[var4] / 128;
         this.verticesZ[var4] = var3 * this.verticesZ[var4] / 128;
      }

      this.resetBounds();
   }

   @ObfuscatedName("o")
   public final void method2773(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1881[0] = -1;
      if(this.boundsType != 2 && this.boundsType != 1) {
         this.method2825();
      }

      int var8 = Graphics3D.centerX;
      int var9 = Graphics3D.centerY;
      int var10 = Model_sine[var1];
      int var11 = Model_cosine[var1];
      int var12 = Model_sine[var2];
      int var13 = Model_cosine[var2];
      int var14 = Model_sine[var3];
      int var15 = Model_cosine[var3];
      int var16 = Model_sine[var4];
      int var17 = Model_cosine[var4];
      int var18 = var16 * var6 + var17 * var7 >> 16;

      for(int var19 = 0; var19 < this.verticesCount; ++var19) {
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
         field1835[var19] = var22 - var18;
         modelViewportYs[var19] = var20 * Graphics3D.Rasterizer3D_zoom / var22 + var8;
         modelViewportXs[var19] = var23 * Graphics3D.Rasterizer3D_zoom / var22 + var9;
         if(this.field1840 > 0) {
            yViewportBuffer[var19] = var20;
            field1878[var19] = var23;
            field1879[var19] = var22;
         }
      }

      try {
         this.method0(false, false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("a")
   public final void method2774(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1881[0] = -1;
      if(this.boundsType != 2 && this.boundsType != 1) {
         this.method2825();
      }

      int var9 = Graphics3D.centerX;
      int var10 = Graphics3D.centerY;
      int var11 = Model_sine[var1];
      int var12 = Model_cosine[var1];
      int var13 = Model_sine[var2];
      int var14 = Model_cosine[var2];
      int var15 = Model_sine[var3];
      int var16 = Model_cosine[var3];
      int var17 = Model_sine[var4];
      int var18 = Model_cosine[var4];
      int var19 = var17 * var6 + var18 * var7 >> 16;

      for(int var20 = 0; var20 < this.verticesCount; ++var20) {
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
         field1835[var20] = var23 - var19;
         modelViewportYs[var20] = var9 + var21 * Graphics3D.Rasterizer3D_zoom / var8;
         modelViewportXs[var20] = var10 + var24 * Graphics3D.Rasterizer3D_zoom / var8;
         if(this.field1840 > 0) {
            yViewportBuffer[var20] = var21;
            field1878[var20] = var24;
            field1879[var20] = var23;
         }
      }

      try {
         this.method0(false, false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("ak")
   @Export("method0")
   final void method0(boolean var1, boolean var2, boolean var3, int var4) {
      if(this.diameter < 1600) {
         int var5;
         for(var5 = 0; var5 < this.diameter; ++var5) {
            field1881[var5] = 0;
         }

         var5 = var3?20:5;
         int var7;
         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         int var13;
         if(class7.drawObjectGeometry2D && var2) {
            Model var6 = this;

            for(var7 = 0; var7 < var6.indicesCount; ++var7) {
               if(var6.field1847[var7] != -2) {
                  var8 = var6.indices1[var7];
                  var9 = var6.indices2[var7];
                  var10 = var6.indices3[var7];
                  var11 = modelViewportYs[var8];
                  var12 = modelViewportYs[var9];
                  var13 = modelViewportYs[var10];
                  class292.method5315(modelViewportXs[var8], modelViewportXs[var9], modelViewportXs[var10], var11, var12, var13, var5);
               }
            }
         }

         int var14;
         int var15;
         int var17;
         int var26;
         for(var26 = 0; var26 < this.indicesCount; ++var26) {
            if(this.field1847[var26] != -2) {
               var7 = this.indices1[var26];
               var8 = this.indices2[var26];
               var9 = this.indices3[var26];
               var10 = modelViewportYs[var7];
               var11 = modelViewportYs[var8];
               var12 = modelViewportYs[var9];
               int var16;
               if(!var1 || var10 != -5000 && var11 != -5000 && var12 != -5000) {
                  if(var2) {
                     var14 = modelViewportXs[var7];
                     var15 = modelViewportXs[var8];
                     var16 = modelViewportXs[var9];
                     var17 = var5 + class132.Viewport_mouseY;
                     boolean var32;
                     if(var17 < var14 && var17 < var15 && var17 < var16) {
                        var32 = false;
                     } else {
                        var17 = class132.Viewport_mouseY - var5;
                        if(var17 > var14 && var17 > var15 && var17 > var16) {
                           var32 = false;
                        } else {
                           var17 = var5 + class132.Viewport_mouseX;
                           if(var17 < var10 && var17 < var11 && var17 < var12) {
                              var32 = false;
                           } else {
                              var17 = class132.Viewport_mouseX - var5;
                              if(var17 > var10 && var17 > var11 && var17 > var12) {
                                 var32 = false;
                              } else {
                                 var32 = true;
                              }
                           }
                        }
                     }

                     if(var32) {
                        class132.Viewport_entityIdsAtMouse[++class132.Viewport_entityCountAtMouse - 1] = var4;
                        var2 = false;
                     }
                  }

                  if((var10 - var11) * (modelViewportXs[var9] - modelViewportXs[var8]) - (var12 - var11) * (modelViewportXs[var7] - modelViewportXs[var8]) > 0) {
                     field1873[var26] = false;
                     if(var10 >= 0 && var11 >= 0 && var12 >= 0 && var10 <= Graphics3D.rasterClipX && var11 <= Graphics3D.rasterClipX && var12 <= Graphics3D.rasterClipX) {
                        field1872[var26] = false;
                     } else {
                        field1872[var26] = true;
                     }

                     var13 = (field1835[var7] + field1835[var8] + field1835[var9]) / 3 + this.radius;
                     field1882[var13][field1881[var13]++] = var26;
                  }
               } else {
                  var13 = yViewportBuffer[var7];
                  var14 = yViewportBuffer[var8];
                  var15 = yViewportBuffer[var9];
                  var16 = field1878[var7];
                  var17 = field1878[var8];
                  int var18 = field1878[var9];
                  int var19 = field1879[var7];
                  int var20 = field1879[var8];
                  int var21 = field1879[var9];
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
                     field1873[var26] = true;
                     int var25 = (field1835[var7] + field1835[var8] + field1835[var9]) / 3 + this.radius;
                     field1882[var25][field1881[var25]++] = var26;
                  }
               }
            }
         }

         int[] var27;
         if(this.field1848 == null) {
            for(var26 = this.diameter - 1; var26 >= 0; --var26) {
               var7 = field1881[var26];
               if(var7 > 0) {
                  var27 = field1882[var26];

                  for(var9 = 0; var9 < var7; ++var9) {
                     this.method2777(var27[var9]);
                  }
               }
            }

         } else {
            for(var26 = 0; var26 < 12; ++var26) {
               field1883[var26] = 0;
               field1887[var26] = 0;
            }

            for(var26 = this.diameter - 1; var26 >= 0; --var26) {
               var7 = field1881[var26];
               if(var7 > 0) {
                  var27 = field1882[var26];

                  for(var9 = 0; var9 < var7; ++var9) {
                     var10 = var27[var9];
                     byte var31 = this.field1848[var10];
                     var12 = field1883[var31]++;
                     field1888[var31][var12] = var10;
                     if(var31 < 10) {
                        field1887[var31] += var26;
                     } else if(var31 == 10) {
                        field1834[var12] = var26;
                     } else {
                        field1886[var12] = var26;
                     }
                  }
               }
            }

            var26 = 0;
            if(field1883[1] > 0 || field1883[2] > 0) {
               var26 = (field1887[1] + field1887[2]) / (field1883[1] + field1883[2]);
            }

            var7 = 0;
            if(field1883[3] > 0 || field1883[4] > 0) {
               var7 = (field1887[3] + field1887[4]) / (field1883[3] + field1883[4]);
            }

            var8 = 0;
            if(field1883[6] > 0 || field1883[8] > 0) {
               var8 = (field1887[8] + field1887[6]) / (field1883[8] + field1883[6]);
            }

            var10 = 0;
            var11 = field1883[10];
            int[] var28 = field1888[10];
            int[] var29 = field1834;
            if(var10 == var11) {
               var10 = 0;
               var11 = field1883[11];
               var28 = field1888[11];
               var29 = field1886;
            }

            if(var10 < var11) {
               var9 = var29[var10];
            } else {
               var9 = -1000;
            }

            for(var14 = 0; var14 < 10; ++var14) {
               while(var14 == 0 && var9 > var26) {
                  this.method2777(var28[var10++]);
                  if(var10 == var11 && var28 != field1888[11]) {
                     var10 = 0;
                     var11 = field1883[11];
                     var28 = field1888[11];
                     var29 = field1886;
                  }

                  if(var10 < var11) {
                     var9 = var29[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 3 && var9 > var7) {
                  this.method2777(var28[var10++]);
                  if(var10 == var11 && var28 != field1888[11]) {
                     var10 = 0;
                     var11 = field1883[11];
                     var28 = field1888[11];
                     var29 = field1886;
                  }

                  if(var10 < var11) {
                     var9 = var29[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 5 && var9 > var8) {
                  this.method2777(var28[var10++]);
                  if(var10 == var11 && var28 != field1888[11]) {
                     var10 = 0;
                     var11 = field1883[11];
                     var28 = field1888[11];
                     var29 = field1886;
                  }

                  if(var10 < var11) {
                     var9 = var29[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               var15 = field1883[var14];
               int[] var30 = field1888[var14];

               for(var17 = 0; var17 < var15; ++var17) {
                  this.method2777(var30[var17]);
               }
            }

            while(var9 != -1000) {
               this.method2777(var28[var10++]);
               if(var10 == var11 && var28 != field1888[11]) {
                  var10 = 0;
                  var28 = field1888[11];
                  var11 = field1883[11];
                  var29 = field1886;
               }

               if(var10 < var11) {
                  var9 = var29[var10];
               } else {
                  var9 = -1000;
               }
            }

         }
      }
   }

   @ObfuscatedName("ap")
   final void method2777(int var1) {
      if(field1873[var1]) {
         this.method2778(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         Graphics3D.rasterClipEnable = field1872[var1];
         if(this.field1876 == null) {
            Graphics3D.rasterAlpha = 0;
         } else {
            Graphics3D.rasterAlpha = this.field1876[var1] & 255;
         }

         if(this.field1851 != null && this.field1851[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1871 != null && this.field1871[var1] != -1) {
               int var8 = this.field1871[var1] & 255;
               var5 = this.field1854[var8];
               var6 = this.field1855[var8];
               var7 = this.field1856[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1847[var1] == -1) {
               Graphics3D.rasterTextureAffine(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], this.field1845[var1], this.field1845[var1], this.field1845[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1878[var5], field1878[var6], field1878[var7], field1879[var5], field1879[var6], field1879[var7], this.field1851[var1]);
            } else {
               Graphics3D.rasterTextureAffine(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], this.field1845[var1], this.field1850[var1], this.field1847[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1878[var5], field1878[var6], field1878[var7], field1879[var5], field1879[var6], field1879[var7], this.field1851[var1]);
            }
         } else if(this.field1847[var1] == -1) {
            Graphics3D.rasterFlat(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], field1893[this.field1845[var1]]);
         } else {
            Graphics3D.rasterGouraud(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], this.field1845[var1], this.field1850[var1], this.field1847[var1]);
         }

      }
   }

   @ObfuscatedName("ac")
   final void method2778(int var1) {
      int var2 = Graphics3D.centerX;
      int var3 = Graphics3D.centerY;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1879[var5];
      int var9 = field1879[var6];
      int var10 = field1879[var7];
      if(this.field1876 == null) {
         Graphics3D.rasterAlpha = 0;
      } else {
         Graphics3D.rasterAlpha = this.field1876[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1861[var4] = modelViewportYs[var5];
         field1853[var4] = modelViewportXs[var5];
         xViewportBuffer[var4++] = this.field1845[var1];
      } else {
         var11 = yViewportBuffer[var5];
         var12 = field1878[var5];
         var13 = this.field1845[var1];
         if(var10 >= 50) {
            var14 = field1900[var10 - var8] * (50 - var8);
            field1861[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) / 50;
            field1853[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1878[var7] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1847[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = field1900[var9 - var8] * (50 - var8);
            field1861[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) / 50;
            field1853[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1878[var6] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1850[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1861[var4] = modelViewportYs[var6];
         field1853[var4] = modelViewportXs[var6];
         xViewportBuffer[var4++] = this.field1850[var1];
      } else {
         var11 = yViewportBuffer[var6];
         var12 = field1878[var6];
         var13 = this.field1850[var1];
         if(var8 >= 50) {
            var14 = field1900[var8 - var9] * (50 - var9);
            field1861[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) / 50;
            field1853[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1878[var5] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1845[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = field1900[var10 - var9] * (50 - var9);
            field1861[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) / 50;
            field1853[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1878[var7] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1847[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1861[var4] = modelViewportYs[var7];
         field1853[var4] = modelViewportXs[var7];
         xViewportBuffer[var4++] = this.field1847[var1];
      } else {
         var11 = yViewportBuffer[var7];
         var12 = field1878[var7];
         var13 = this.field1847[var1];
         if(var9 >= 50) {
            var14 = field1900[var9 - var10] * (50 - var10);
            field1861[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) / 50;
            field1853[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1878[var6] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1850[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = field1900[var8 - var10] * (50 - var10);
            field1861[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) / 50;
            field1853[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1878[var5] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1845[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1861[0];
      var12 = field1861[1];
      var13 = field1861[2];
      var14 = field1853[0];
      int var15 = field1853[1];
      int var16 = field1853[2];
      Graphics3D.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX) {
            Graphics3D.rasterClipEnable = true;
         }

         if(this.field1851 != null && this.field1851[var1] != -1) {
            if(this.field1871 != null && this.field1871[var1] != -1) {
               var20 = this.field1871[var1] & 255;
               var17 = this.field1854[var20];
               var18 = this.field1855[var20];
               var19 = this.field1856[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1847[var1] == -1) {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1845[var1], this.field1845[var1], this.field1845[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1878[var17], field1878[var18], field1878[var19], field1879[var17], field1879[var18], field1879[var19], this.field1851[var1]);
            } else {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1878[var17], field1878[var18], field1878[var19], field1879[var17], field1879[var18], field1879[var19], this.field1851[var1]);
            }
         } else if(this.field1847[var1] == -1) {
            Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, field1893[this.field1845[var1]]);
         } else {
            Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX || field1861[3] < 0 || field1861[3] > Graphics3D.rasterClipX) {
            Graphics3D.rasterClipEnable = true;
         }

         if(this.field1851 != null && this.field1851[var1] != -1) {
            if(this.field1871 != null && this.field1871[var1] != -1) {
               var20 = this.field1871[var1] & 255;
               var17 = this.field1854[var20];
               var18 = this.field1855[var20];
               var19 = this.field1856[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1851[var1];
            if(this.field1847[var1] == -1) {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1845[var1], this.field1845[var1], this.field1845[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1878[var17], field1878[var18], field1878[var19], field1879[var17], field1879[var18], field1879[var19], var21);
               Graphics3D.rasterTextureAffine(var14, var16, field1853[3], var11, var13, field1861[3], this.field1845[var1], this.field1845[var1], this.field1845[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1878[var17], field1878[var18], field1878[var19], field1879[var17], field1879[var18], field1879[var19], var21);
            } else {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1878[var17], field1878[var18], field1878[var19], field1879[var17], field1879[var18], field1879[var19], var21);
               Graphics3D.rasterTextureAffine(var14, var16, field1853[3], var11, var13, field1861[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1878[var17], field1878[var18], field1878[var19], field1879[var17], field1879[var18], field1879[var19], var21);
            }
         } else if(this.field1847[var1] == -1) {
            var17 = field1893[this.field1845[var1]];
            Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            Graphics3D.rasterFlat(var14, var16, field1853[3], var11, var13, field1861[3], var17);
         } else {
            Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
            Graphics3D.rasterGouraud(var14, var16, field1853[3], var11, var13, field1861[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3]);
         }
      }

   }

   @ObfuscatedName("cc")
   @Export("draw")
   void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1881[0] = -1;
      if(this.boundsType != 1) {
         this.calculateBoundsCylinder();
      }

      this.method2759(var1);
      int var10 = var5 * var8 - var4 * var6 >> 16;
      int var11 = var2 * var7 + var3 * var10 >> 16;
      int var12 = var3 * this.XYZMag >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var5 * var6 >> 16;
         int var15 = (var14 - this.XYZMag) * Graphics3D.Rasterizer3D_zoom;
         if(var15 / var13 < Graphics3D.Rasterizer3D_clipMidX2) {
            int var16 = (var14 + this.XYZMag) * Graphics3D.Rasterizer3D_zoom;
            if(var16 / var13 > Graphics3D.Rasterizer3D_clipNegativeMidX) {
               int var17 = var3 * var7 - var10 * var2 >> 16;
               int var18 = var2 * this.XYZMag >> 16;
               int var19 = (var17 + var18) * Graphics3D.Rasterizer3D_zoom;
               if(var19 / var13 > Graphics3D.Rasterizer3D_clipNegativeMidY) {
                  int var20 = (var3 * super.modelHeight >> 16) + var18;
                  int var21 = (var17 - var20) * Graphics3D.Rasterizer3D_zoom;
                  if(var21 / var13 < Graphics3D.Rasterizer3D_clipMidY2) {
                     int var22 = var12 + (var2 * super.modelHeight >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1840 > 0;
                     int var26 = class132.Viewport_mouseX;
                     int var28 = class132.Viewport_mouseY;
                     boolean var30 = class132.Viewport_containsMouse;
                     if(class7.drawBoundingBoxes3D && var9 > 0) {
                        if(Widget.boundingBox3DContainsMouse(this, var6, var7, var8)) {
                           class7.boundingBoxes.addFirst(new BoundingBox3D(this, var6, var7, var8, -65281));
                        } else if(class7.boundingBox3DDrawMode == BoundingBox3DDrawMode.ALWAYS) {
                           class7.boundingBoxes.addFirst(new BoundingBox3D(this, var6, var7, var8, -16776961));
                        }
                     }

                     int var33;
                     int var34;
                     int var35;
                     int var36;
                     int var37;
                     int var38;
                     int var39;
                     if(class7.drawBoundingBoxes2D && var9 > 0) {
                        int var42 = var11 - var12;
                        if(var42 <= 50) {
                           var42 = 50;
                        }

                        if(var14 > 0) {
                           var33 = var15 / var13;
                           var34 = var16 / var42;
                        } else {
                           var34 = var16 / var13;
                           var33 = var15 / var42;
                        }

                        if(var17 > 0) {
                           var35 = var21 / var13;
                           var36 = var19 / var42;
                        } else {
                           var36 = var19 / var13;
                           var35 = var21 / var42;
                        }

                        var37 = -8355840;
                        var38 = var26 - Graphics3D.centerX;
                        var39 = var28 - Graphics3D.centerY;
                        if(var38 > var33 && var38 < var34 && var39 > var35 && var39 < var36) {
                           var37 = -256;
                        }

                        PendingSpawn.method1624(var33 + Graphics3D.centerX, var35 + Graphics3D.centerY, var34 + Graphics3D.centerX, var36 + Graphics3D.centerY, var37);
                     }

                     boolean var46 = false;
                     if(var9 > 0 && var30) {
                        boolean var45 = false;
                        if(useBoundingBoxes3D) {
                           var45 = Widget.boundingBox3DContainsMouse(this, var6, var7, var8);
                        } else {
                           var34 = var11 - var12;
                           if(var34 <= 50) {
                              var34 = 50;
                           }

                           if(var14 > 0) {
                              var15 /= var13;
                              var16 /= var34;
                           } else {
                              var16 /= var13;
                              var15 /= var34;
                           }

                           if(var17 > 0) {
                              var21 /= var13;
                              var19 /= var34;
                           } else {
                              var19 /= var13;
                              var21 /= var34;
                           }

                           var35 = var26 - Graphics3D.centerX;
                           var36 = var28 - Graphics3D.centerY;
                           if(var35 > var15 && var35 < var16 && var36 > var21 && var36 < var19) {
                              var45 = true;
                           }
                        }

                        if(var45) {
                           if(this.field1859) {
                              class132.Viewport_entityIdsAtMouse[++class132.Viewport_entityCountAtMouse - 1] = var9;
                           } else {
                              var46 = true;
                           }
                        }
                     }

                     var33 = Graphics3D.centerX;
                     var34 = Graphics3D.centerY;
                     var35 = 0;
                     var36 = 0;
                     if(var1 != 0) {
                        var35 = Model_sine[var1];
                        var36 = Model_cosine[var1];
                     }

                     for(var37 = 0; var37 < this.verticesCount; ++var37) {
                        var38 = this.verticesX[var37];
                        var39 = this.verticesY[var37];
                        int var40 = this.verticesZ[var37];
                        int var41;
                        if(var1 != 0) {
                           var41 = var40 * var35 + var38 * var36 >> 16;
                           var40 = var40 * var36 - var38 * var35 >> 16;
                           var38 = var41;
                        }

                        var38 += var6;
                        var39 += var7;
                        var40 += var8;
                        var41 = var40 * var4 + var5 * var38 >> 16;
                        var40 = var5 * var40 - var38 * var4 >> 16;
                        var38 = var41;
                        var41 = var3 * var39 - var40 * var2 >> 16;
                        var40 = var39 * var2 + var3 * var40 >> 16;
                        field1835[var37] = var40 - var11;
                        if(var40 >= 50) {
                           modelViewportYs[var37] = var38 * Graphics3D.Rasterizer3D_zoom / var40 + var33;
                           modelViewportXs[var37] = var41 * Graphics3D.Rasterizer3D_zoom / var40 + var34;
                        } else {
                           modelViewportYs[var37] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           yViewportBuffer[var37] = var38;
                           field1878[var37] = var41;
                           field1879[var37] = var40;
                        }
                     }

                     try {
                        this.method0(var23, var46, this.field1859, var9);
                     } catch (Exception var44) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }
}
