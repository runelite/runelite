import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lee;"
   )
   static Model field1850;
   @ObfuscatedName("e")
   static byte[] field1854;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lee;"
   )
   static Model field1866;
   @ObfuscatedName("z")
   static byte[] field1824;
   @ObfuscatedName("ab")
   static boolean[] field1834;
   @ObfuscatedName("al")
   static boolean[] field1861;
   @ObfuscatedName("af")
   @Export("modelViewportYs")
   public static int[] modelViewportYs;
   @ObfuscatedName("ah")
   @Export("modelViewportXs")
   public static int[] modelViewportXs;
   @ObfuscatedName("au")
   static int[] field1852;
   @ObfuscatedName("ap")
   @Export("yViewportBuffer")
   static int[] yViewportBuffer;
   @ObfuscatedName("at")
   static int[] field1840;
   @ObfuscatedName("am")
   static int[] field1867;
   @ObfuscatedName("ae")
   static int[] field1869;
   @ObfuscatedName("aw")
   static int[][] field1829;
   @ObfuscatedName("ar")
   static int[] field1825;
   @ObfuscatedName("aq")
   static int[][] field1872;
   @ObfuscatedName("bq")
   static int[] field1821;
   @ObfuscatedName("bi")
   static int[] field1874;
   @ObfuscatedName("bo")
   static int[] field1858;
   @ObfuscatedName("bj")
   static int[] field1860;
   @ObfuscatedName("bw")
   static int[] field1877;
   @ObfuscatedName("bp")
   @Export("xViewportBuffer")
   static int[] xViewportBuffer;
   @ObfuscatedName("bh")
   @Export("animOffsetX")
   static int animOffsetX;
   @ObfuscatedName("bz")
   @Export("animOffsetY")
   static int animOffsetY;
   @ObfuscatedName("bl")
   @Export("animOffsetZ")
   static int animOffsetZ;
   @ObfuscatedName("bb")
   @Export("useBoundingBoxes3D")
   static boolean useBoundingBoxes3D;
   @ObfuscatedName("br")
   @Export("Model_sine")
   static int[] Model_sine;
   @ObfuscatedName("bc")
   @Export("Model_cosine")
   static int[] Model_cosine;
   @ObfuscatedName("bf")
   static int[] field1848;
   @ObfuscatedName("bt")
   static int[] field1888;
   @ObfuscatedName("n")
   @Export("verticesCount")
   int verticesCount;
   @ObfuscatedName("l")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("s")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("y")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("c")
   @Export("indicesCount")
   public int indicesCount;
   @ObfuscatedName("h")
   @Export("indices1")
   public int[] indices1;
   @ObfuscatedName("i")
   @Export("indices2")
   public int[] indices2;
   @ObfuscatedName("o")
   @Export("indices3")
   public int[] indices3;
   @ObfuscatedName("d")
   int[] field1833;
   @ObfuscatedName("r")
   int[] field1851;
   @ObfuscatedName("p")
   public int[] field1835;
   @ObfuscatedName("q")
   byte[] field1836;
   @ObfuscatedName("f")
   byte[] field1837;
   @ObfuscatedName("j")
   byte[] field1838;
   @ObfuscatedName("v")
   short[] field1839;
   @ObfuscatedName("u")
   byte field1876;
   @ObfuscatedName("k")
   int field1841;
   @ObfuscatedName("w")
   int[] field1842;
   @ObfuscatedName("m")
   int[] field1843;
   @ObfuscatedName("a")
   int[] field1844;
   @ObfuscatedName("x")
   @Export("vertexGroups")
   int[][] vertexGroups;
   @ObfuscatedName("t")
   int[][] field1846;
   @ObfuscatedName("ax")
   public boolean field1847;
   @ObfuscatedName("ai")
   @Export("boundsType")
   int boundsType;
   @ObfuscatedName("aj")
   @Export("bottomY")
   int bottomY;
   @ObfuscatedName("ac")
   @Export("XYZMag")
   int XYZMag;
   @ObfuscatedName("ag")
   @Export("diameter")
   int diameter;
   @ObfuscatedName("ay")
   @Export("radius")
   int radius;
   @ObfuscatedName("as")
   @Export("centerX")
   public int centerX;
   @ObfuscatedName("av")
   @Export("centerY")
   public int centerY;
   @ObfuscatedName("ao")
   @Export("centerZ")
   public int centerZ;
   @ObfuscatedName("ak")
   @Export("extremeX")
   public int extremeX;
   @ObfuscatedName("ad")
   @Export("extremeY")
   public int extremeY;
   @ObfuscatedName("az")
   @Export("extremeZ")
   public int extremeZ;

   static {
      field1850 = new Model();
      field1854 = new byte[1];
      field1866 = new Model();
      field1824 = new byte[1];
      field1834 = new boolean[4700];
      field1861 = new boolean[4700];
      modelViewportYs = new int[4700];
      modelViewportXs = new int[4700];
      field1852 = new int[4700];
      yViewportBuffer = new int[4700];
      field1840 = new int[4700];
      field1867 = new int[4700];
      field1869 = new int[1600];
      field1829 = new int[1600][512];
      field1825 = new int[12];
      field1872 = new int[12][2000];
      field1821 = new int[2000];
      field1874 = new int[2000];
      field1858 = new int[12];
      field1860 = new int[10];
      field1877 = new int[10];
      xViewportBuffer = new int[10];
      useBoundingBoxes3D = true;
      Model_sine = Graphics3D.SINE;
      Model_cosine = Graphics3D.COSINE;
      field1848 = Graphics3D.colorPalette;
      field1888 = Graphics3D.field1937;
   }

   Model() {
      this.verticesCount = 0;
      this.indicesCount = 0;
      this.field1876 = 0;
      this.field1841 = 0;
      this.field1847 = false;
      this.extremeX = -1;
      this.extremeY = -1;
      this.extremeZ = -1;
   }

   @ObfuscatedSignature(
      signature = "([Lee;I)V"
   )
   public Model(Model[] var1, int var2) {
      this.verticesCount = 0;
      this.indicesCount = 0;
      this.field1876 = 0;
      this.field1841 = 0;
      this.field1847 = false;
      this.extremeX = -1;
      this.extremeY = -1;
      this.extremeZ = -1;
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.verticesCount = 0;
      this.indicesCount = 0;
      this.field1841 = 0;
      this.field1876 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.verticesCount += var8.verticesCount;
            this.indicesCount += var8.indicesCount;
            this.field1841 += var8.field1841;
            if(var8.field1836 != null) {
               var3 = true;
            } else {
               if(this.field1876 == -1) {
                  this.field1876 = var8.field1876;
               }

               if(this.field1876 != var8.field1876) {
                  var3 = true;
               }
            }

            var4 |= var8.field1837 != null;
            var5 |= var8.field1839 != null;
            var6 |= var8.field1838 != null;
         }
      }

      this.verticesX = new int[this.verticesCount];
      this.verticesY = new int[this.verticesCount];
      this.verticesZ = new int[this.verticesCount];
      this.indices1 = new int[this.indicesCount];
      this.indices2 = new int[this.indicesCount];
      this.indices3 = new int[this.indicesCount];
      this.field1833 = new int[this.indicesCount];
      this.field1851 = new int[this.indicesCount];
      this.field1835 = new int[this.indicesCount];
      if(var3) {
         this.field1836 = new byte[this.indicesCount];
      }

      if(var4) {
         this.field1837 = new byte[this.indicesCount];
      }

      if(var5) {
         this.field1839 = new short[this.indicesCount];
      }

      if(var6) {
         this.field1838 = new byte[this.indicesCount];
      }

      if(this.field1841 > 0) {
         this.field1842 = new int[this.field1841];
         this.field1843 = new int[this.field1841];
         this.field1844 = new int[this.field1841];
      }

      this.verticesCount = 0;
      this.indicesCount = 0;
      this.field1841 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.indicesCount; ++var9) {
               this.indices1[this.indicesCount] = this.verticesCount + var8.indices1[var9];
               this.indices2[this.indicesCount] = this.verticesCount + var8.indices2[var9];
               this.indices3[this.indicesCount] = this.verticesCount + var8.indices3[var9];
               this.field1833[this.indicesCount] = var8.field1833[var9];
               this.field1851[this.indicesCount] = var8.field1851[var9];
               this.field1835[this.indicesCount] = var8.field1835[var9];
               if(var3) {
                  if(var8.field1836 != null) {
                     this.field1836[this.indicesCount] = var8.field1836[var9];
                  } else {
                     this.field1836[this.indicesCount] = var8.field1876;
                  }
               }

               if(var4 && var8.field1837 != null) {
                  this.field1837[this.indicesCount] = var8.field1837[var9];
               }

               if(var5) {
                  if(var8.field1839 != null) {
                     this.field1839[this.indicesCount] = var8.field1839[var9];
                  } else {
                     this.field1839[this.indicesCount] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1838 != null && var8.field1838[var9] != -1) {
                     this.field1838[this.indicesCount] = (byte)(this.field1841 + var8.field1838[var9]);
                  } else {
                     this.field1838[this.indicesCount] = -1;
                  }
               }

               ++this.indicesCount;
            }

            for(var9 = 0; var9 < var8.field1841; ++var9) {
               this.field1842[this.field1841] = this.verticesCount + var8.field1842[var9];
               this.field1843[this.field1841] = this.verticesCount + var8.field1843[var9];
               this.field1844[this.field1841] = this.verticesCount + var8.field1844[var9];
               ++this.field1841;
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([[IIIIZI)Lee;"
   )
   public Model method2782(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
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
               var11.field1841 = this.field1841;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1833 = this.field1833;
               var11.field1851 = this.field1851;
               var11.field1835 = this.field1835;
               var11.field1836 = this.field1836;
               var11.field1837 = this.field1837;
               var11.field1838 = this.field1838;
               var11.field1839 = this.field1839;
               var11.field1876 = this.field1876;
               var11.field1842 = this.field1842;
               var11.field1843 = this.field1843;
               var11.field1844 = this.field1844;
               var11.vertexGroups = this.vertexGroups;
               var11.field1846 = this.field1846;
               var11.field1847 = this.field1847;
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Z)Lee;"
   )
   @Export("toSharedModel")
   public Model toSharedModel(boolean var1) {
      if(!var1 && field1854.length < this.indicesCount) {
         field1854 = new byte[this.indicesCount + 100];
      }

      return this.method2785(var1, field1850, field1854);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Z)Lee;"
   )
   @Export("toSharedSpotAnimModel")
   public Model toSharedSpotAnimModel(boolean var1) {
      if(!var1 && field1824.length < this.indicesCount) {
         field1824 = new byte[this.indicesCount + 100];
      }

      return this.method2785(var1, field1866, field1824);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ZLee;[B)Lee;"
   )
   Model method2785(boolean var1, Model var2, byte[] var3) {
      var2.verticesCount = this.verticesCount;
      var2.indicesCount = this.indicesCount;
      var2.field1841 = this.field1841;
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
         var2.field1837 = this.field1837;
      } else {
         var2.field1837 = var3;
         if(this.field1837 == null) {
            for(var4 = 0; var4 < this.indicesCount; ++var4) {
               var2.field1837[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.indicesCount; ++var4) {
               var2.field1837[var4] = this.field1837[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1833 = this.field1833;
      var2.field1851 = this.field1851;
      var2.field1835 = this.field1835;
      var2.field1836 = this.field1836;
      var2.field1838 = this.field1838;
      var2.field1839 = this.field1839;
      var2.field1876 = this.field1876;
      var2.field1842 = this.field1842;
      var2.field1843 = this.field1843;
      var2.field1844 = this.field1844;
      var2.vertexGroups = this.vertexGroups;
      var2.field1846 = this.field1846;
      var2.field1847 = this.field1847;
      var2.resetBounds();
      return var2;
   }

   @ObfuscatedName("n")
   void method2840(int var1) {
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
            int var11 = Graphics3D.method2895(this.verticesX[var10], this.verticesZ[var10], var8, var9);
            int var12 = this.verticesY[var10];
            int var13 = Graphics3D.method2896(this.verticesX[var10], this.verticesZ[var10], var8, var9);
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

         if(this.field1847) {
            this.extremeX += 8;
            this.extremeZ += 8;
         }

      }
   }

   @ObfuscatedName("l")
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

   @ObfuscatedName("s")
   void method2788() {
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

   @ObfuscatedName("y")
   public int method2789() {
      this.calculateBoundsCylinder();
      return this.XYZMag;
   }

   @ObfuscatedName("o")
   @Export("resetBounds")
   void resetBounds() {
      this.boundsType = 0;
      this.extremeX = -1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Leu;I)V"
   )
   public void method2791(Frames var1, int var2) {
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Leu;ILeu;I[I)V"
   )
   public void method2835(Frames var1, int var2, Frames var3, int var4, int[] var5) {
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
            this.method2791(var1, var2);
         }
      }
   }

   @ObfuscatedName("p")
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
            if(this.field1846 != null && this.field1837 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1846.length) {
                     var18 = this.field1846[var8];

                     for(var19 = 0; var19 < var18.length; ++var19) {
                        var11 = var18[var19];
                        var12 = (this.field1837[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1837[var11] = (byte)var12;
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

   @ObfuscatedName("f")
   @Export("rotateY180Ccw")
   public void rotateY180Ccw() {
      for(int var1 = 0; var1 < this.verticesCount; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.resetBounds();
   }

   @ObfuscatedName("j")
   @Export("rotateY270Ccw")
   public void rotateY270Ccw() {
      for(int var1 = 0; var1 < this.verticesCount; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.resetBounds();
   }

   @ObfuscatedName("v")
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

   @ObfuscatedName("u")
   @Export("offsetBy")
   public void offsetBy(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.verticesCount; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.resetBounds();
   }

   @ObfuscatedName("k")
   @Export("scale")
   public void scale(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.verticesCount; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = var2 * this.verticesY[var4] / 128;
         this.verticesZ[var4] = var3 * this.verticesZ[var4] / 128;
      }

      this.resetBounds();
   }

   @ObfuscatedName("w")
   public final void method2781(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1869[0] = -1;
      if(this.boundsType != 2 && this.boundsType != 1) {
         this.method2788();
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
         field1852[var19] = var22 - var18;
         modelViewportYs[var19] = var20 * Graphics3D.Rasterizer3D_zoom / var22 + var8;
         modelViewportXs[var19] = var23 * Graphics3D.Rasterizer3D_zoom / var22 + var9;
         if(this.field1841 > 0) {
            yViewportBuffer[var19] = var20;
            field1840[var19] = var23;
            field1867[var19] = var22;
         }
      }

      try {
         this.method2802(false, false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("x")
   public final void method2831(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1869[0] = -1;
      if(this.boundsType != 2 && this.boundsType != 1) {
         this.method2788();
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
         field1852[var20] = var23 - var19;
         modelViewportYs[var20] = var9 + var21 * Graphics3D.Rasterizer3D_zoom / var8;
         modelViewportXs[var20] = var10 + var24 * Graphics3D.Rasterizer3D_zoom / var8;
         if(this.field1841 > 0) {
            yViewportBuffer[var20] = var21;
            field1840[var20] = var24;
            field1867[var20] = var23;
         }
      }

      try {
         this.method2802(false, false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("t")
   final void method2802(boolean var1, boolean var2, boolean var3, int var4) {
      if(this.diameter < 1600) {
         int var5;
         for(var5 = 0; var5 < this.diameter; ++var5) {
            field1869[var5] = 0;
         }

         var5 = var3?20:5;
         if(class7.drawObjectGeometry2D && var2) {
            class278.method5005(this, var5);
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
         for(var6 = 0; var6 < this.indicesCount; ++var6) {
            if(this.field1835[var6] != -2) {
               var7 = this.indices1[var6];
               var8 = this.indices2[var6];
               var9 = this.indices3[var6];
               var10 = modelViewportYs[var7];
               var11 = modelViewportYs[var8];
               var12 = modelViewportYs[var9];
               int var13;
               int var16;
               if(!var1 || var10 != -5000 && var11 != -5000 && var12 != -5000) {
                  if(var2) {
                     var14 = modelViewportXs[var7];
                     var15 = modelViewportXs[var8];
                     var16 = modelViewportXs[var9];
                     var17 = var5 + class132.Viewport_mouseY;
                     boolean var31;
                     if(var17 < var14 && var17 < var15 && var17 < var16) {
                        var31 = false;
                     } else {
                        var17 = class132.Viewport_mouseY - var5;
                        if(var17 > var14 && var17 > var15 && var17 > var16) {
                           var31 = false;
                        } else {
                           var17 = var5 + class132.Viewport_mouseX;
                           if(var17 < var10 && var17 < var11 && var17 < var12) {
                              var31 = false;
                           } else {
                              var17 = class132.Viewport_mouseX - var5;
                              if(var17 > var10 && var17 > var11 && var17 > var12) {
                                 var31 = false;
                              } else {
                                 var31 = true;
                              }
                           }
                        }
                     }

                     if(var31) {
                        class132.Viewport_entityIdsAtMouse[++class132.Viewport_entityCountAtMouse - 1] = var4;
                        var2 = false;
                     }
                  }

                  if((var10 - var11) * (modelViewportXs[var9] - modelViewportXs[var8]) - (var12 - var11) * (modelViewportXs[var7] - modelViewportXs[var8]) > 0) {
                     field1861[var6] = false;
                     if(var10 >= 0 && var11 >= 0 && var12 >= 0 && var10 <= Graphics3D.rasterClipX && var11 <= Graphics3D.rasterClipX && var12 <= Graphics3D.rasterClipX) {
                        field1834[var6] = false;
                     } else {
                        field1834[var6] = true;
                     }

                     var13 = (field1852[var7] + field1852[var8] + field1852[var9]) / 3 + this.radius;
                     field1829[var13][field1869[var13]++] = var6;
                  }
               } else {
                  var13 = yViewportBuffer[var7];
                  var14 = yViewportBuffer[var8];
                  var15 = yViewportBuffer[var9];
                  var16 = field1840[var7];
                  var17 = field1840[var8];
                  int var18 = field1840[var9];
                  int var19 = field1867[var7];
                  int var20 = field1867[var8];
                  int var21 = field1867[var9];
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
                     field1861[var6] = true;
                     int var25 = (field1852[var7] + field1852[var8] + field1852[var9]) / 3 + this.radius;
                     field1829[var25][field1869[var25]++] = var6;
                  }
               }
            }
         }

         int[] var26;
         if(this.field1836 == null) {
            for(var6 = this.diameter - 1; var6 >= 0; --var6) {
               var7 = field1869[var6];
               if(var7 > 0) {
                  var26 = field1829[var6];

                  for(var9 = 0; var9 < var7; ++var9) {
                     this.method2796(var26[var9]);
                  }
               }
            }

         } else {
            for(var6 = 0; var6 < 12; ++var6) {
               field1825[var6] = 0;
               field1858[var6] = 0;
            }

            for(var6 = this.diameter - 1; var6 >= 0; --var6) {
               var7 = field1869[var6];
               if(var7 > 0) {
                  var26 = field1829[var6];

                  for(var9 = 0; var9 < var7; ++var9) {
                     var10 = var26[var9];
                     byte var30 = this.field1836[var10];
                     var12 = field1825[var30]++;
                     field1872[var30][var12] = var10;
                     if(var30 < 10) {
                        field1858[var30] += var6;
                     } else if(var30 == 10) {
                        field1821[var12] = var6;
                     } else {
                        field1874[var12] = var6;
                     }
                  }
               }
            }

            var6 = 0;
            if(field1825[1] > 0 || field1825[2] > 0) {
               var6 = (field1858[1] + field1858[2]) / (field1825[1] + field1825[2]);
            }

            var7 = 0;
            if(field1825[3] > 0 || field1825[4] > 0) {
               var7 = (field1858[3] + field1858[4]) / (field1825[3] + field1825[4]);
            }

            var8 = 0;
            if(field1825[6] > 0 || field1825[8] > 0) {
               var8 = (field1858[8] + field1858[6]) / (field1825[8] + field1825[6]);
            }

            var10 = 0;
            var11 = field1825[10];
            int[] var27 = field1872[10];
            int[] var28 = field1821;
            if(var10 == var11) {
               var10 = 0;
               var11 = field1825[11];
               var27 = field1872[11];
               var28 = field1874;
            }

            if(var10 < var11) {
               var9 = var28[var10];
            } else {
               var9 = -1000;
            }

            for(var14 = 0; var14 < 10; ++var14) {
               while(var14 == 0 && var9 > var6) {
                  this.method2796(var27[var10++]);
                  if(var10 == var11 && var27 != field1872[11]) {
                     var10 = 0;
                     var11 = field1825[11];
                     var27 = field1872[11];
                     var28 = field1874;
                  }

                  if(var10 < var11) {
                     var9 = var28[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 3 && var9 > var7) {
                  this.method2796(var27[var10++]);
                  if(var10 == var11 && var27 != field1872[11]) {
                     var10 = 0;
                     var11 = field1825[11];
                     var27 = field1872[11];
                     var28 = field1874;
                  }

                  if(var10 < var11) {
                     var9 = var28[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 5 && var9 > var8) {
                  this.method2796(var27[var10++]);
                  if(var10 == var11 && var27 != field1872[11]) {
                     var10 = 0;
                     var11 = field1825[11];
                     var27 = field1872[11];
                     var28 = field1874;
                  }

                  if(var10 < var11) {
                     var9 = var28[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               var15 = field1825[var14];
               int[] var29 = field1872[var14];

               for(var17 = 0; var17 < var15; ++var17) {
                  this.method2796(var29[var17]);
               }
            }

            while(var9 != -1000) {
               this.method2796(var27[var10++]);
               if(var10 == var11 && var27 != field1872[11]) {
                  var10 = 0;
                  var27 = field1872[11];
                  var11 = field1825[11];
                  var28 = field1874;
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

   @ObfuscatedName("ax")
   final void method2796(int var1) {
      if(field1861[var1]) {
         this.method2804(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         Graphics3D.rasterClipEnable = field1834[var1];
         if(this.field1837 == null) {
            Graphics3D.rasterAlpha = 0;
         } else {
            Graphics3D.rasterAlpha = this.field1837[var1] & 255;
         }

         if(this.field1839 != null && this.field1839[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1838 != null && this.field1838[var1] != -1) {
               int var8 = this.field1838[var1] & 255;
               var5 = this.field1842[var8];
               var6 = this.field1843[var8];
               var7 = this.field1844[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1835[var1] == -1) {
               Graphics3D.rasterTextureAffine(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], this.field1833[var1], this.field1833[var1], this.field1833[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1840[var5], field1840[var6], field1840[var7], field1867[var5], field1867[var6], field1867[var7], this.field1839[var1]);
            } else {
               Graphics3D.rasterTextureAffine(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], this.field1833[var1], this.field1851[var1], this.field1835[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1840[var5], field1840[var6], field1840[var7], field1867[var5], field1867[var6], field1867[var7], this.field1839[var1]);
            }
         } else if(this.field1835[var1] == -1) {
            Graphics3D.rasterFlat(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], field1848[this.field1833[var1]]);
         } else {
            Graphics3D.rasterGouraud(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], this.field1833[var1], this.field1851[var1], this.field1835[var1]);
         }

      }
   }

   @ObfuscatedName("ai")
   final void method2804(int var1) {
      int var2 = Graphics3D.centerX;
      int var3 = Graphics3D.centerY;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1867[var5];
      int var9 = field1867[var6];
      int var10 = field1867[var7];
      if(this.field1837 == null) {
         Graphics3D.rasterAlpha = 0;
      } else {
         Graphics3D.rasterAlpha = this.field1837[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1860[var4] = modelViewportYs[var5];
         field1877[var4] = modelViewportXs[var5];
         xViewportBuffer[var4++] = this.field1833[var1];
      } else {
         var11 = yViewportBuffer[var5];
         var12 = field1840[var5];
         var13 = this.field1833[var1];
         if(var10 >= 50) {
            var14 = field1888[var10 - var8] * (50 - var8);
            field1860[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) / 50;
            field1877[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1840[var7] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1835[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = field1888[var9 - var8] * (50 - var8);
            field1860[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) / 50;
            field1877[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1840[var6] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1851[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1860[var4] = modelViewportYs[var6];
         field1877[var4] = modelViewportXs[var6];
         xViewportBuffer[var4++] = this.field1851[var1];
      } else {
         var11 = yViewportBuffer[var6];
         var12 = field1840[var6];
         var13 = this.field1851[var1];
         if(var8 >= 50) {
            var14 = field1888[var8 - var9] * (50 - var9);
            field1860[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) / 50;
            field1877[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1840[var5] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1833[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = field1888[var10 - var9] * (50 - var9);
            field1860[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) / 50;
            field1877[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1840[var7] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1835[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1860[var4] = modelViewportYs[var7];
         field1877[var4] = modelViewportXs[var7];
         xViewportBuffer[var4++] = this.field1835[var1];
      } else {
         var11 = yViewportBuffer[var7];
         var12 = field1840[var7];
         var13 = this.field1835[var1];
         if(var9 >= 50) {
            var14 = field1888[var9 - var10] * (50 - var10);
            field1860[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) / 50;
            field1877[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1840[var6] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1851[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = field1888[var8 - var10] * (50 - var10);
            field1860[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) / 50;
            field1877[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1840[var5] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1833[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1860[0];
      var12 = field1860[1];
      var13 = field1860[2];
      var14 = field1877[0];
      int var15 = field1877[1];
      int var16 = field1877[2];
      Graphics3D.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX) {
            Graphics3D.rasterClipEnable = true;
         }

         if(this.field1839 != null && this.field1839[var1] != -1) {
            if(this.field1838 != null && this.field1838[var1] != -1) {
               var20 = this.field1838[var1] & 255;
               var17 = this.field1842[var20];
               var18 = this.field1843[var20];
               var19 = this.field1844[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1835[var1] == -1) {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1833[var1], this.field1833[var1], this.field1833[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1840[var17], field1840[var18], field1840[var19], field1867[var17], field1867[var18], field1867[var19], this.field1839[var1]);
            } else {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1840[var17], field1840[var18], field1840[var19], field1867[var17], field1867[var18], field1867[var19], this.field1839[var1]);
            }
         } else if(this.field1835[var1] == -1) {
            Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, field1848[this.field1833[var1]]);
         } else {
            Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX || field1860[3] < 0 || field1860[3] > Graphics3D.rasterClipX) {
            Graphics3D.rasterClipEnable = true;
         }

         if(this.field1839 != null && this.field1839[var1] != -1) {
            if(this.field1838 != null && this.field1838[var1] != -1) {
               var20 = this.field1838[var1] & 255;
               var17 = this.field1842[var20];
               var18 = this.field1843[var20];
               var19 = this.field1844[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1839[var1];
            if(this.field1835[var1] == -1) {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1833[var1], this.field1833[var1], this.field1833[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1840[var17], field1840[var18], field1840[var19], field1867[var17], field1867[var18], field1867[var19], var21);
               Graphics3D.rasterTextureAffine(var14, var16, field1877[3], var11, var13, field1860[3], this.field1833[var1], this.field1833[var1], this.field1833[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1840[var17], field1840[var18], field1840[var19], field1867[var17], field1867[var18], field1867[var19], var21);
            } else {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1840[var17], field1840[var18], field1840[var19], field1867[var17], field1867[var18], field1867[var19], var21);
               Graphics3D.rasterTextureAffine(var14, var16, field1877[3], var11, var13, field1860[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1840[var17], field1840[var18], field1840[var19], field1867[var17], field1867[var18], field1867[var19], var21);
            }
         } else if(this.field1835[var1] == -1) {
            var17 = field1848[this.field1833[var1]];
            Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            Graphics3D.rasterFlat(var14, var16, field1877[3], var11, var13, field1860[3], var17);
         } else {
            Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
            Graphics3D.rasterGouraud(var14, var16, field1877[3], var11, var13, field1860[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3]);
         }
      }

   }

   @ObfuscatedName("cf")
   @Export("draw")
   void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1869[0] = -1;
      if(this.boundsType != 1) {
         this.calculateBoundsCylinder();
      }

      this.method2840(var1);
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

                     boolean var25 = var24 || this.field1841 > 0;
                     int var26 = GameEngine.method1051();
                     int var27 = class132.Viewport_mouseY;
                     boolean var29 = class132.Viewport_containsMouse;
                     if(class7.drawBoundingBoxes3D && var9 > 0) {
                        if(ContextMenuRow.boundingBox3DContainsMouse(this, var6, var7, var8)) {
                           class7.boundingBoxes.addFirst(new BoundingBox3D(this, var6, var7, var8, -65281));
                        } else if(BoundingBox3DDrawMode.ALWAYS == class7.boundingBox3DDrawMode) {
                           class7.boundingBoxes.addFirst(new BoundingBox3D(this, var6, var7, var8, -16776961));
                        }
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
                     if(class7.drawBoundingBoxes2D && var9 > 0) {
                        int var43 = var11 - var12;
                        if(var43 <= 50) {
                           var43 = 50;
                        }

                        if(var14 > 0) {
                           var32 = var15 / var13;
                           var33 = var16 / var43;
                        } else {
                           var33 = var16 / var13;
                           var32 = var15 / var43;
                        }

                        if(var17 > 0) {
                           var34 = var21 / var13;
                           var35 = var19 / var43;
                        } else {
                           var35 = var19 / var13;
                           var34 = var21 / var43;
                        }

                        var36 = -8355840;
                        var37 = var26 - Graphics3D.centerX;
                        var38 = var27 - Graphics3D.centerY;
                        if(var37 > var32 && var37 < var33 && var38 > var34 && var38 < var35) {
                           var36 = -256;
                        }

                        var39 = var32 + Graphics3D.centerX;
                        var40 = var34 + Graphics3D.centerY;
                        int var41 = var33 + Graphics3D.centerX;
                        int var42 = var35 + Graphics3D.centerY;
                        class7.boundingBoxes.addFirst(new BoundingBox2D(var39, var40, var41, var42, var36));
                     }

                     boolean var47 = false;
                     if(var9 > 0 && var29) {
                        boolean var46 = false;
                        if(useBoundingBoxes3D) {
                           var46 = ContextMenuRow.boundingBox3DContainsMouse(this, var6, var7, var8);
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
                           var35 = var27 - Graphics3D.centerY;
                           if(var34 > var15 && var34 < var16 && var35 > var21 && var35 < var19) {
                              var46 = true;
                           }
                        }

                        if(var46) {
                           if(this.field1847) {
                              class132.Viewport_entityIdsAtMouse[++class132.Viewport_entityCountAtMouse - 1] = var9;
                           } else {
                              var47 = true;
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
                        field1852[var36] = var39 - var11;
                        if(var39 >= 50) {
                           modelViewportYs[var36] = var37 * Graphics3D.Rasterizer3D_zoom / var39 + var32;
                           modelViewportXs[var36] = var40 * Graphics3D.Rasterizer3D_zoom / var39 + var33;
                        } else {
                           modelViewportYs[var36] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           yViewportBuffer[var36] = var37;
                           field1840[var36] = var40;
                           field1867[var36] = var39;
                        }
                     }

                     try {
                        this.method2802(var23, var47, this.field1847, var9);
                     } catch (Exception var45) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }
}
