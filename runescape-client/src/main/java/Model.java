import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   static Model field1861;
   @ObfuscatedName("i")
   static byte[] field1891;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   static Model field1869;
   @ObfuscatedName("j")
   static byte[] field1844;
   @ObfuscatedName("af")
   static boolean[] field1880;
   @ObfuscatedName("aw")
   static boolean[] field1902;
   @ObfuscatedName("ax")
   @Export("modelViewportYs")
   static int[] modelViewportYs;
   @ObfuscatedName("ag")
   @Export("modelViewportXs")
   static int[] modelViewportXs;
   @ObfuscatedName("ay")
   static int[] field1884;
   @ObfuscatedName("ad")
   @Export("yViewportBuffer")
   static int[] yViewportBuffer;
   @ObfuscatedName("at")
   static int[] field1886;
   @ObfuscatedName("av")
   static int[] field1887;
   @ObfuscatedName("aj")
   static int[] field1889;
   @ObfuscatedName("ar")
   static int[][] field1890;
   @ObfuscatedName("au")
   static int[] field1903;
   @ObfuscatedName("an")
   static int[][] field1841;
   @ObfuscatedName("bv")
   static int[] field1842;
   @ObfuscatedName("bw")
   static int[] field1894;
   @ObfuscatedName("bj")
   static int[] field1895;
   @ObfuscatedName("ba")
   static int[] field1896;
   @ObfuscatedName("bl")
   static int[] field1897;
   @ObfuscatedName("br")
   @Export("xViewportBuffer")
   static int[] xViewportBuffer;
   @ObfuscatedName("bh")
   @Export("animOffsetX")
   static int animOffsetX;
   @ObfuscatedName("bf")
   @Export("animOffsetY")
   static int animOffsetY;
   @ObfuscatedName("bu")
   @Export("animOffsetZ")
   static int animOffsetZ;
   @ObfuscatedName("bp")
   @Export("useBoundingBoxes3D")
   static boolean useBoundingBoxes3D;
   @ObfuscatedName("bt")
   @Export("Model_sine")
   static int[] Model_sine;
   @ObfuscatedName("by")
   @Export("Model_cosine")
   static int[] Model_cosine;
   @ObfuscatedName("be")
   static int[] field1851;
   @ObfuscatedName("bs")
   static int[] field1854;
   @ObfuscatedName("k")
   @Export("verticesCount")
   int verticesCount;
   @ObfuscatedName("x")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("z")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("p")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("w")
   @Export("indicesCount")
   int indicesCount;
   @ObfuscatedName("r")
   @Export("indices1")
   int[] indices1;
   @ObfuscatedName("d")
   @Export("indices2")
   int[] indices2;
   @ObfuscatedName("a")
   @Export("indices3")
   int[] indices3;
   @ObfuscatedName("e")
   int[] field1853;
   @ObfuscatedName("f")
   int[] field1885;
   @ObfuscatedName("l")
   int[] field1855;
   @ObfuscatedName("m")
   byte[] field1870;
   @ObfuscatedName("b")
   byte[] field1857;
   @ObfuscatedName("h")
   byte[] field1858;
   @ObfuscatedName("t")
   short[] field1859;
   @ObfuscatedName("v")
   byte field1860;
   @ObfuscatedName("n")
   int field1892;
   @ObfuscatedName("u")
   int[] field1862;
   @ObfuscatedName("q")
   int[] field1863;
   @ObfuscatedName("g")
   int[] field1883;
   @ObfuscatedName("y")
   @Export("vertexGroups")
   int[][] vertexGroups;
   @ObfuscatedName("s")
   int[][] field1856;
   @ObfuscatedName("ac")
   public boolean field1850;
   @ObfuscatedName("ap")
   @Export("boundsType")
   int boundsType;
   @ObfuscatedName("al")
   @Export("bottomY")
   int bottomY;
   @ObfuscatedName("ai")
   @Export("XYZMag")
   int XYZMag;
   @ObfuscatedName("ab")
   @Export("diameter")
   int diameter;
   @ObfuscatedName("ak")
   @Export("radius")
   int radius;
   @ObfuscatedName("as")
   @Export("centerX")
   public int centerX;
   @ObfuscatedName("aa")
   @Export("centerY")
   public int centerY;
   @ObfuscatedName("ah")
   @Export("centerZ")
   public int centerZ;
   @ObfuscatedName("ao")
   @Export("extremeX")
   public int extremeX;
   @ObfuscatedName("am")
   @Export("extremeY")
   public int extremeY;
   @ObfuscatedName("aq")
   @Export("extremeZ")
   public int extremeZ;

   static {
      field1861 = new Model();
      field1891 = new byte[1];
      field1869 = new Model();
      field1844 = new byte[1];
      field1880 = new boolean[4700];
      field1902 = new boolean[4700];
      modelViewportYs = new int[4700];
      modelViewportXs = new int[4700];
      field1884 = new int[4700];
      yViewportBuffer = new int[4700];
      field1886 = new int[4700];
      field1887 = new int[4700];
      field1889 = new int[1600];
      field1890 = new int[1600][512];
      field1903 = new int[12];
      field1841 = new int[12][2000];
      field1842 = new int[2000];
      field1894 = new int[2000];
      field1895 = new int[12];
      field1896 = new int[10];
      field1897 = new int[10];
      xViewportBuffer = new int[10];
      useBoundingBoxes3D = true;
      Model_sine = Graphics3D.SINE;
      Model_cosine = Graphics3D.COSINE;
      field1851 = Graphics3D.colorPalette;
      field1854 = Graphics3D.field1951;
   }

   Model() {
      this.verticesCount = 0;
      this.indicesCount = 0;
      this.field1860 = 0;
      this.field1892 = 0;
      this.field1850 = false;
      this.extremeX = -1;
      this.extremeY = -1;
      this.extremeZ = -1;
   }

   @ObfuscatedSignature(
      signature = "([Led;I)V"
   )
   public Model(Model[] var1, int var2) {
      this.verticesCount = 0;
      this.indicesCount = 0;
      this.field1860 = 0;
      this.field1892 = 0;
      this.field1850 = false;
      this.extremeX = -1;
      this.extremeY = -1;
      this.extremeZ = -1;
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.verticesCount = 0;
      this.indicesCount = 0;
      this.field1892 = 0;
      this.field1860 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.verticesCount += var8.verticesCount;
            this.indicesCount += var8.indicesCount;
            this.field1892 += var8.field1892;
            if(var8.field1870 != null) {
               var3 = true;
            } else {
               if(this.field1860 == -1) {
                  this.field1860 = var8.field1860;
               }

               if(this.field1860 != var8.field1860) {
                  var3 = true;
               }
            }

            var4 |= var8.field1857 != null;
            var5 |= var8.field1859 != null;
            var6 |= var8.field1858 != null;
         }
      }

      this.verticesX = new int[this.verticesCount];
      this.verticesY = new int[this.verticesCount];
      this.verticesZ = new int[this.verticesCount];
      this.indices1 = new int[this.indicesCount];
      this.indices2 = new int[this.indicesCount];
      this.indices3 = new int[this.indicesCount];
      this.field1853 = new int[this.indicesCount];
      this.field1885 = new int[this.indicesCount];
      this.field1855 = new int[this.indicesCount];
      if(var3) {
         this.field1870 = new byte[this.indicesCount];
      }

      if(var4) {
         this.field1857 = new byte[this.indicesCount];
      }

      if(var5) {
         this.field1859 = new short[this.indicesCount];
      }

      if(var6) {
         this.field1858 = new byte[this.indicesCount];
      }

      if(this.field1892 > 0) {
         this.field1862 = new int[this.field1892];
         this.field1863 = new int[this.field1892];
         this.field1883 = new int[this.field1892];
      }

      this.verticesCount = 0;
      this.indicesCount = 0;
      this.field1892 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.indicesCount; ++var9) {
               this.indices1[this.indicesCount] = this.verticesCount + var8.indices1[var9];
               this.indices2[this.indicesCount] = this.verticesCount + var8.indices2[var9];
               this.indices3[this.indicesCount] = this.verticesCount + var8.indices3[var9];
               this.field1853[this.indicesCount] = var8.field1853[var9];
               this.field1885[this.indicesCount] = var8.field1885[var9];
               this.field1855[this.indicesCount] = var8.field1855[var9];
               if(var3) {
                  if(var8.field1870 != null) {
                     this.field1870[this.indicesCount] = var8.field1870[var9];
                  } else {
                     this.field1870[this.indicesCount] = var8.field1860;
                  }
               }

               if(var4 && var8.field1857 != null) {
                  this.field1857[this.indicesCount] = var8.field1857[var9];
               }

               if(var5) {
                  if(var8.field1859 != null) {
                     this.field1859[this.indicesCount] = var8.field1859[var9];
                  } else {
                     this.field1859[this.indicesCount] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1858 != null && var8.field1858[var9] != -1) {
                     this.field1858[this.indicesCount] = (byte)(this.field1892 + var8.field1858[var9]);
                  } else {
                     this.field1858[this.indicesCount] = -1;
                  }
               }

               ++this.indicesCount;
            }

            for(var9 = 0; var9 < var8.field1892; ++var9) {
               this.field1862[this.field1892] = this.verticesCount + var8.field1862[var9];
               this.field1863[this.field1892] = this.verticesCount + var8.field1863[var9];
               this.field1883[this.field1892] = this.verticesCount + var8.field1883[var9];
               ++this.field1892;
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

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([[IIIIZI)Led;"
   )
   public Model method2682(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
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
               var11.field1892 = this.field1892;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1853 = this.field1853;
               var11.field1885 = this.field1885;
               var11.field1855 = this.field1855;
               var11.field1870 = this.field1870;
               var11.field1857 = this.field1857;
               var11.field1858 = this.field1858;
               var11.field1859 = this.field1859;
               var11.field1860 = this.field1860;
               var11.field1862 = this.field1862;
               var11.field1863 = this.field1863;
               var11.field1883 = this.field1883;
               var11.vertexGroups = this.vertexGroups;
               var11.field1856 = this.field1856;
               var11.field1850 = this.field1850;
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Z)Led;"
   )
   @Export("toSharedModel")
   public Model toSharedModel(boolean var1) {
      if(!var1 && field1891.length < this.indicesCount) {
         field1891 = new byte[this.indicesCount + 100];
      }

      return this.method2685(var1, field1861, field1891);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Z)Led;"
   )
   @Export("toSharedSpotAnimModel")
   public Model toSharedSpotAnimModel(boolean var1) {
      if(!var1 && field1844.length < this.indicesCount) {
         field1844 = new byte[this.indicesCount + 100];
      }

      return this.method2685(var1, field1869, field1844);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ZLed;[B)Led;"
   )
   Model method2685(boolean var1, Model var2, byte[] var3) {
      var2.verticesCount = this.verticesCount;
      var2.indicesCount = this.indicesCount;
      var2.field1892 = this.field1892;
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
         var2.field1857 = this.field1857;
      } else {
         var2.field1857 = var3;
         if(this.field1857 == null) {
            for(var4 = 0; var4 < this.indicesCount; ++var4) {
               var2.field1857[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.indicesCount; ++var4) {
               var2.field1857[var4] = this.field1857[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1853 = this.field1853;
      var2.field1885 = this.field1885;
      var2.field1855 = this.field1855;
      var2.field1870 = this.field1870;
      var2.field1858 = this.field1858;
      var2.field1859 = this.field1859;
      var2.field1860 = this.field1860;
      var2.field1862 = this.field1862;
      var2.field1863 = this.field1863;
      var2.field1883 = this.field1883;
      var2.vertexGroups = this.vertexGroups;
      var2.field1856 = this.field1856;
      var2.field1850 = this.field1850;
      var2.resetBounds();
      return var2;
   }

   @ObfuscatedName("k")
   void method2686(int var1) {
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
            int var11 = Graphics3D.method2809(this.verticesX[var10], this.verticesZ[var10], var8, var9);
            int var12 = this.verticesY[var10];
            int var13 = Graphics3D.method2810(this.verticesX[var10], this.verticesZ[var10], var8, var9);
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

         if(this.field1850) {
            this.extremeX += 8;
            this.extremeZ += 8;
         }

      }
   }

   @ObfuscatedName("x")
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

   @ObfuscatedName("z")
   void method2688() {
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

   @ObfuscatedName("p")
   public int method2689() {
      this.calculateBoundsCylinder();
      return this.XYZMag;
   }

   @ObfuscatedName("r")
   @Export("resetBounds")
   void resetBounds() {
      this.boundsType = 0;
      this.extremeX = -1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lee;I)V"
   )
   public void method2759(Frames var1, int var2) {
      if(this.vertexGroups != null) {
         if(var2 != -1) {
            Frame var3 = var1.skeletons[var2];
            FrameMap var4 = var3.skin;
            animOffsetX = 0;
            animOffsetY = 0;
            animOffsetZ = 0;

            for(int var5 = 0; var5 < var3.transformCount; ++var5) {
               int var6 = var3.transformTypes[var5];
               this.animate(var4.types[var6], var4.list[var6], var3.translator_x[var5], var3.translator_y[var5], var3.translator_z[var5]);
            }

            this.resetBounds();
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lee;ILee;I[I)V"
   )
   public void method2692(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.skeletons[var2];
            Frame var7 = var3.skeletons[var4];
            FrameMap var8 = var6.skin;
            animOffsetX = 0;
            animOffsetY = 0;
            animOffsetZ = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.transformCount; ++var11) {
               for(var12 = var6.transformTypes[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.types[var12] == 0) {
                  this.animate(var8.types[var12], var8.list[var12], var6.translator_x[var11], var6.translator_y[var11], var6.translator_z[var11]);
               }
            }

            animOffsetX = 0;
            animOffsetY = 0;
            animOffsetZ = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.transformCount; ++var11) {
               for(var12 = var7.transformTypes[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.types[var12] == 0) {
                  this.animate(var8.types[var12], var8.list[var12], var7.translator_x[var11], var7.translator_y[var11], var7.translator_z[var11]);
               }
            }

            this.resetBounds();
         } else {
            this.method2759(var1, var2);
         }
      }
   }

   @ObfuscatedName("b")
   @Export("animate")
   void animate(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         animOffsetX = 0;
         animOffsetY = 0;
         animOffsetZ = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var9 = var2[var8];
            if(var9 < this.vertexGroups.length) {
               int[] var10 = this.vertexGroups[var9];

               for(var11 = 0; var11 < var10.length; ++var11) {
                  var12 = var10[var11];
                  animOffsetX += this.verticesX[var12];
                  animOffsetY += this.verticesY[var12];
                  animOffsetZ += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            animOffsetX = var3 + animOffsetX / var7;
            animOffsetY = var4 + animOffsetY / var7;
            animOffsetZ = var5 + animOffsetZ / var7;
         } else {
            animOffsetX = var3;
            animOffsetY = var4;
            animOffsetZ = var5;
         }

      } else {
         int[] var18;
         int var19;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.vertexGroups.length) {
                  var18 = this.vertexGroups[var8];

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
               if(var8 < this.vertexGroups.length) {
                  var18 = this.vertexGroups[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= animOffsetX;
                     this.verticesY[var11] -= animOffsetY;
                     this.verticesZ[var11] -= animOffsetZ;
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

                     this.verticesX[var11] += animOffsetX;
                     this.verticesY[var11] += animOffsetY;
                     this.verticesZ[var11] += animOffsetZ;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.vertexGroups.length) {
                  var18 = this.vertexGroups[var8];

                  for(var19 = 0; var19 < var18.length; ++var19) {
                     var11 = var18[var19];
                     this.verticesX[var11] -= animOffsetX;
                     this.verticesY[var11] -= animOffsetY;
                     this.verticesZ[var11] -= animOffsetZ;
                     this.verticesX[var11] = var3 * this.verticesX[var11] / 128;
                     this.verticesY[var11] = var4 * this.verticesY[var11] / 128;
                     this.verticesZ[var11] = var5 * this.verticesZ[var11] / 128;
                     this.verticesX[var11] += animOffsetX;
                     this.verticesY[var11] += animOffsetY;
                     this.verticesZ[var11] += animOffsetZ;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1856 != null && this.field1857 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1856.length) {
                     var18 = this.field1856[var8];

                     for(var19 = 0; var19 < var18.length; ++var19) {
                        var11 = var18[var19];
                        var12 = (this.field1857[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1857[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("h")
   @Export("rotateY90Ccw")
   public void rotateY90Ccw() {
      for(int var1 = 0; var1 < this.verticesCount; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.resetBounds();
   }

   @ObfuscatedName("n")
   @Export("rotateY180Ccw")
   public void rotateY180Ccw() {
      for(int var1 = 0; var1 < this.verticesCount; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.resetBounds();
   }

   @ObfuscatedName("u")
   @Export("rotateY270Ccw")
   public void rotateY270Ccw() {
      for(int var1 = 0; var1 < this.verticesCount; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.resetBounds();
   }

   @ObfuscatedName("q")
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

   @ObfuscatedName("g")
   @Export("offsetBy")
   public void offsetBy(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.verticesCount; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.resetBounds();
   }

   @ObfuscatedName("y")
   @Export("scale")
   public void scale(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.verticesCount; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = var2 * this.verticesY[var4] / 128;
         this.verticesZ[var4] = var3 * this.verticesZ[var4] / 128;
      }

      this.resetBounds();
   }

   @ObfuscatedName("s")
   public final void method2700(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1889[0] = -1;
      if(this.boundsType != 2 && this.boundsType != 1) {
         this.method2688();
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
         field1884[var19] = var22 - var18;
         modelViewportYs[var19] = var20 * Graphics3D.Rasterizer3D_zoom / var22 + var8;
         modelViewportXs[var19] = var23 * Graphics3D.Rasterizer3D_zoom / var22 + var9;
         if(this.field1892 > 0) {
            yViewportBuffer[var19] = var20;
            field1886[var19] = var23;
            field1887[var19] = var22;
         }
      }

      try {
         this.method2710(false, false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("ac")
   public final void method2701(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1889[0] = -1;
      if(this.boundsType != 2 && this.boundsType != 1) {
         this.method2688();
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
         field1884[var20] = var23 - var19;
         modelViewportYs[var20] = var9 + var21 * Graphics3D.Rasterizer3D_zoom / var8;
         modelViewportXs[var20] = var10 + var24 * Graphics3D.Rasterizer3D_zoom / var8;
         if(this.field1892 > 0) {
            yViewportBuffer[var20] = var21;
            field1886[var20] = var24;
            field1887[var20] = var23;
         }
      }

      try {
         this.method2710(false, false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("ap")
   final void method2710(boolean var1, boolean var2, boolean var3, int var4) {
      if(this.diameter < 1600) {
         int var5;
         for(var5 = 0; var5 < this.diameter; ++var5) {
            field1889[var5] = 0;
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
               if(var6.field1855[var7] != -2) {
                  var8 = var6.indices1[var7];
                  var9 = var6.indices2[var7];
                  var10 = var6.indices3[var7];
                  var11 = modelViewportYs[var8];
                  var12 = modelViewportYs[var9];
                  var13 = modelViewportYs[var10];
                  WorldMapRegion.method422(modelViewportXs[var8], modelViewportXs[var9], modelViewportXs[var10], var11, var12, var13, var5);
               }
            }
         }

         int var14;
         int var15;
         int var17;
         int var26;
         for(var26 = 0; var26 < this.indicesCount; ++var26) {
            if(this.field1855[var26] != -2) {
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
                        Varcs.method1987(var4);
                        var2 = false;
                     }
                  }

                  if((var10 - var11) * (modelViewportXs[var9] - modelViewportXs[var8]) - (var12 - var11) * (modelViewportXs[var7] - modelViewportXs[var8]) > 0) {
                     field1902[var26] = false;
                     if(var10 >= 0 && var11 >= 0 && var12 >= 0 && var10 <= Graphics3D.rasterClipX && var11 <= Graphics3D.rasterClipX && var12 <= Graphics3D.rasterClipX) {
                        field1880[var26] = false;
                     } else {
                        field1880[var26] = true;
                     }

                     var13 = (field1884[var7] + field1884[var8] + field1884[var9]) / 3 + this.radius;
                     field1890[var13][field1889[var13]++] = var26;
                  }
               } else {
                  var13 = yViewportBuffer[var7];
                  var14 = yViewportBuffer[var8];
                  var15 = yViewportBuffer[var9];
                  var16 = field1886[var7];
                  var17 = field1886[var8];
                  int var18 = field1886[var9];
                  int var19 = field1887[var7];
                  int var20 = field1887[var8];
                  int var21 = field1887[var9];
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
                     field1902[var26] = true;
                     int var25 = (field1884[var7] + field1884[var8] + field1884[var9]) / 3 + this.radius;
                     field1890[var25][field1889[var25]++] = var26;
                  }
               }
            }
         }

         int[] var27;
         if(this.field1870 == null) {
            for(var26 = this.diameter - 1; var26 >= 0; --var26) {
               var7 = field1889[var26];
               if(var7 > 0) {
                  var27 = field1890[var26];

                  for(var9 = 0; var9 < var7; ++var9) {
                     this.method2681(var27[var9]);
                  }
               }
            }

         } else {
            for(var26 = 0; var26 < 12; ++var26) {
               field1903[var26] = 0;
               field1895[var26] = 0;
            }

            for(var26 = this.diameter - 1; var26 >= 0; --var26) {
               var7 = field1889[var26];
               if(var7 > 0) {
                  var27 = field1890[var26];

                  for(var9 = 0; var9 < var7; ++var9) {
                     var10 = var27[var9];
                     byte var31 = this.field1870[var10];
                     var12 = field1903[var31]++;
                     field1841[var31][var12] = var10;
                     if(var31 < 10) {
                        field1895[var31] += var26;
                     } else if(var31 == 10) {
                        field1842[var12] = var26;
                     } else {
                        field1894[var12] = var26;
                     }
                  }
               }
            }

            var26 = 0;
            if(field1903[1] > 0 || field1903[2] > 0) {
               var26 = (field1895[1] + field1895[2]) / (field1903[1] + field1903[2]);
            }

            var7 = 0;
            if(field1903[3] > 0 || field1903[4] > 0) {
               var7 = (field1895[3] + field1895[4]) / (field1903[3] + field1903[4]);
            }

            var8 = 0;
            if(field1903[6] > 0 || field1903[8] > 0) {
               var8 = (field1895[8] + field1895[6]) / (field1903[8] + field1903[6]);
            }

            var10 = 0;
            var11 = field1903[10];
            int[] var28 = field1841[10];
            int[] var29 = field1842;
            if(var10 == var11) {
               var10 = 0;
               var11 = field1903[11];
               var28 = field1841[11];
               var29 = field1894;
            }

            if(var10 < var11) {
               var9 = var29[var10];
            } else {
               var9 = -1000;
            }

            for(var14 = 0; var14 < 10; ++var14) {
               while(var14 == 0 && var9 > var26) {
                  this.method2681(var28[var10++]);
                  if(var10 == var11 && var28 != field1841[11]) {
                     var10 = 0;
                     var11 = field1903[11];
                     var28 = field1841[11];
                     var29 = field1894;
                  }

                  if(var10 < var11) {
                     var9 = var29[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 3 && var9 > var7) {
                  this.method2681(var28[var10++]);
                  if(var10 == var11 && var28 != field1841[11]) {
                     var10 = 0;
                     var11 = field1903[11];
                     var28 = field1841[11];
                     var29 = field1894;
                  }

                  if(var10 < var11) {
                     var9 = var29[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 5 && var9 > var8) {
                  this.method2681(var28[var10++]);
                  if(var10 == var11 && var28 != field1841[11]) {
                     var10 = 0;
                     var11 = field1903[11];
                     var28 = field1841[11];
                     var29 = field1894;
                  }

                  if(var10 < var11) {
                     var9 = var29[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               var15 = field1903[var14];
               int[] var30 = field1841[var14];

               for(var17 = 0; var17 < var15; ++var17) {
                  this.method2681(var30[var17]);
               }
            }

            while(var9 != -1000) {
               this.method2681(var28[var10++]);
               if(var10 == var11 && var28 != field1841[11]) {
                  var10 = 0;
                  var28 = field1841[11];
                  var11 = field1903[11];
                  var29 = field1894;
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

   @ObfuscatedName("al")
   final void method2681(int var1) {
      if(field1902[var1]) {
         this.method2765(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         Graphics3D.rasterClipEnable = field1880[var1];
         if(this.field1857 == null) {
            Graphics3D.rasterAlpha = 0;
         } else {
            Graphics3D.rasterAlpha = this.field1857[var1] & 255;
         }

         if(this.field1859 != null && this.field1859[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1858 != null && this.field1858[var1] != -1) {
               int var8 = this.field1858[var1] & 255;
               var5 = this.field1862[var8];
               var6 = this.field1863[var8];
               var7 = this.field1883[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1855[var1] == -1) {
               Graphics3D.rasterTextureAffine(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], this.field1853[var1], this.field1853[var1], this.field1853[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1886[var5], field1886[var6], field1886[var7], field1887[var5], field1887[var6], field1887[var7], this.field1859[var1]);
            } else {
               Graphics3D.rasterTextureAffine(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], this.field1853[var1], this.field1885[var1], this.field1855[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1886[var5], field1886[var6], field1886[var7], field1887[var5], field1887[var6], field1887[var7], this.field1859[var1]);
            }
         } else if(this.field1855[var1] == -1) {
            Graphics3D.rasterFlat(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], field1851[this.field1853[var1]]);
         } else {
            Graphics3D.rasterGouraud(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], this.field1853[var1], this.field1885[var1], this.field1855[var1]);
         }

      }
   }

   @ObfuscatedName("ai")
   final void method2765(int var1) {
      int var2 = Graphics3D.centerX;
      int var3 = Graphics3D.centerY;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1887[var5];
      int var9 = field1887[var6];
      int var10 = field1887[var7];
      if(this.field1857 == null) {
         Graphics3D.rasterAlpha = 0;
      } else {
         Graphics3D.rasterAlpha = this.field1857[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1896[var4] = modelViewportYs[var5];
         field1897[var4] = modelViewportXs[var5];
         xViewportBuffer[var4++] = this.field1853[var1];
      } else {
         var11 = yViewportBuffer[var5];
         var12 = field1886[var5];
         var13 = this.field1853[var1];
         if(var10 >= 50) {
            var14 = field1854[var10 - var8] * (50 - var8);
            field1896[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) / 50;
            field1897[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1886[var7] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1855[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = field1854[var9 - var8] * (50 - var8);
            field1896[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) / 50;
            field1897[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1886[var6] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1885[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1896[var4] = modelViewportYs[var6];
         field1897[var4] = modelViewportXs[var6];
         xViewportBuffer[var4++] = this.field1885[var1];
      } else {
         var11 = yViewportBuffer[var6];
         var12 = field1886[var6];
         var13 = this.field1885[var1];
         if(var8 >= 50) {
            var14 = field1854[var8 - var9] * (50 - var9);
            field1896[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) / 50;
            field1897[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1886[var5] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1853[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = field1854[var10 - var9] * (50 - var9);
            field1896[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) / 50;
            field1897[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1886[var7] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1855[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1896[var4] = modelViewportYs[var7];
         field1897[var4] = modelViewportXs[var7];
         xViewportBuffer[var4++] = this.field1855[var1];
      } else {
         var11 = yViewportBuffer[var7];
         var12 = field1886[var7];
         var13 = this.field1855[var1];
         if(var9 >= 50) {
            var14 = field1854[var9 - var10] * (50 - var10);
            field1896[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) / 50;
            field1897[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1886[var6] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1885[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = field1854[var8 - var10] * (50 - var10);
            field1896[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) / 50;
            field1897[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1886[var5] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1853[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1896[0];
      var12 = field1896[1];
      var13 = field1896[2];
      var14 = field1897[0];
      int var15 = field1897[1];
      int var16 = field1897[2];
      Graphics3D.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX) {
            Graphics3D.rasterClipEnable = true;
         }

         if(this.field1859 != null && this.field1859[var1] != -1) {
            if(this.field1858 != null && this.field1858[var1] != -1) {
               var20 = this.field1858[var1] & 255;
               var17 = this.field1862[var20];
               var18 = this.field1863[var20];
               var19 = this.field1883[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1855[var1] == -1) {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1853[var1], this.field1853[var1], this.field1853[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1886[var17], field1886[var18], field1886[var19], field1887[var17], field1887[var18], field1887[var19], this.field1859[var1]);
            } else {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1886[var17], field1886[var18], field1886[var19], field1887[var17], field1887[var18], field1887[var19], this.field1859[var1]);
            }
         } else if(this.field1855[var1] == -1) {
            Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, field1851[this.field1853[var1]]);
         } else {
            Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX || field1896[3] < 0 || field1896[3] > Graphics3D.rasterClipX) {
            Graphics3D.rasterClipEnable = true;
         }

         if(this.field1859 != null && this.field1859[var1] != -1) {
            if(this.field1858 != null && this.field1858[var1] != -1) {
               var20 = this.field1858[var1] & 255;
               var17 = this.field1862[var20];
               var18 = this.field1863[var20];
               var19 = this.field1883[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1859[var1];
            if(this.field1855[var1] == -1) {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1853[var1], this.field1853[var1], this.field1853[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1886[var17], field1886[var18], field1886[var19], field1887[var17], field1887[var18], field1887[var19], var21);
               Graphics3D.rasterTextureAffine(var14, var16, field1897[3], var11, var13, field1896[3], this.field1853[var1], this.field1853[var1], this.field1853[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1886[var17], field1886[var18], field1886[var19], field1887[var17], field1887[var18], field1887[var19], var21);
            } else {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1886[var17], field1886[var18], field1886[var19], field1887[var17], field1887[var18], field1887[var19], var21);
               Graphics3D.rasterTextureAffine(var14, var16, field1897[3], var11, var13, field1896[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1886[var17], field1886[var18], field1886[var19], field1887[var17], field1887[var18], field1887[var19], var21);
            }
         } else if(this.field1855[var1] == -1) {
            var17 = field1851[this.field1853[var1]];
            Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            Graphics3D.rasterFlat(var14, var16, field1897[3], var11, var13, field1896[3], var17);
         } else {
            Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
            Graphics3D.rasterGouraud(var14, var16, field1897[3], var11, var13, field1896[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3]);
         }
      }

   }

   @ObfuscatedName("cr")
   @Export("draw")
   void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1889[0] = -1;
      if(this.boundsType != 1) {
         this.calculateBoundsCylinder();
      }

      this.method2686(var1);
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

                     boolean var25 = var24 || this.field1892 > 0;
                     int var26 = class132.Viewport_mouseX;
                     int var28 = WorldMapManager.method617();
                     boolean var29 = class132.Viewport_containsMouse;
                     if(class7.drawBoundingBoxes3D && var9 > 0) {
                        if(class27.boundingBox3DContainsMouse(this, var6, var7, var8)) {
                           MapIcon.method575(this, var6, var7, var8, -65281);
                        } else if(class7.boundingBox3DDrawMode == BoundingBox3DDrawMode.ALWAYS) {
                           MapIcon.method575(this, var6, var7, var8, -16776961);
                        }
                     }

                     int var32;
                     int var33;
                     int var34;
                     int var35;
                     int var36;
                     int var37;
                     int var38;
                     if(class7.drawBoundingBoxes2D && var9 > 0) {
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

                        class254.method4525(var32 + Graphics3D.centerX, var34 + Graphics3D.centerY, var33 + Graphics3D.centerX, var35 + Graphics3D.centerY, var36);
                     }

                     boolean var45 = false;
                     if(var9 > 0 && var29) {
                        boolean var44 = false;
                        if(useBoundingBoxes3D) {
                           var44 = class27.boundingBox3DContainsMouse(this, var6, var7, var8);
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
                           if(this.field1850) {
                              Varcs.method1987(var9);
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
                        var34 = Model_sine[var1];
                        var35 = Model_cosine[var1];
                     }

                     for(var36 = 0; var36 < this.verticesCount; ++var36) {
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
                        field1884[var36] = var39 - var11;
                        if(var39 >= 50) {
                           modelViewportYs[var36] = var37 * Graphics3D.Rasterizer3D_zoom / var39 + var32;
                           modelViewportXs[var36] = var40 * Graphics3D.Rasterizer3D_zoom / var39 + var33;
                        } else {
                           modelViewportYs[var36] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           yViewportBuffer[var36] = var37;
                           field1886[var36] = var40;
                           field1887[var36] = var39;
                        }
                     }

                     try {
                        this.method2710(var23, var45, this.field1850, var9);
                     } catch (Exception var43) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }
}
