import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lee;"
   )
   static Model field1849;
   @ObfuscatedName("q")
   static byte[] field1802;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lee;"
   )
   static Model field1803;
   @ObfuscatedName("p")
   static byte[] field1804;
   @ObfuscatedName("ad")
   static boolean[] field1852;
   @ObfuscatedName("ar")
   static boolean[] field1861;
   @ObfuscatedName("ag")
   @Export("modelViewportYs")
   public static int[] modelViewportYs;
   @ObfuscatedName("au")
   @Export("modelViewportXs")
   public static int[] modelViewportXs;
   @ObfuscatedName("ac")
   static int[] field1844;
   @ObfuscatedName("ay")
   @Export("yViewportBuffer")
   static int[] yViewportBuffer;
   @ObfuscatedName("at")
   static int[] field1846;
   @ObfuscatedName("aa")
   static int[] field1847;
   @ObfuscatedName("ab")
   static int[] field1820;
   @ObfuscatedName("ap")
   static int[][] field1850;
   @ObfuscatedName("ae")
   static int[] field1824;
   @ObfuscatedName("an")
   static int[][] field1828;
   @ObfuscatedName("bh")
   static int[] field1853;
   @ObfuscatedName("bx")
   static int[] field1854;
   @ObfuscatedName("bb")
   static int[] field1855;
   @ObfuscatedName("bf")
   static int[] field1856;
   @ObfuscatedName("bp")
   static int[] field1845;
   @ObfuscatedName("bj")
   @Export("xViewportBuffer")
   static int[] xViewportBuffer;
   @ObfuscatedName("bi")
   static int field1859;
   @ObfuscatedName("br")
   static int field1860;
   @ObfuscatedName("be")
   static int field1866;
   @ObfuscatedName("bk")
   @Export("useBoundingBoxes3D")
   static boolean useBoundingBoxes3D;
   @ObfuscatedName("bg")
   @Export("Model_sine")
   static int[] Model_sine;
   @ObfuscatedName("bc")
   @Export("Model_cosine")
   static int[] Model_cosine;
   @ObfuscatedName("bw")
   static int[] field1806;
   @ObfuscatedName("ba")
   static int[] field1868;
   @ObfuscatedName("a")
   @Export("verticesCount")
   int verticesCount;
   @ObfuscatedName("h")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("l")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("y")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("g")
   @Export("indicesCount")
   public int indicesCount;
   @ObfuscatedName("c")
   @Export("indices1")
   public int[] indices1;
   @ObfuscatedName("u")
   @Export("indices2")
   public int[] indices2;
   @ObfuscatedName("r")
   @Export("indices3")
   public int[] indices3;
   @ObfuscatedName("d")
   int[] field1841;
   @ObfuscatedName("v")
   int[] field1831;
   @ObfuscatedName("s")
   public int[] field1869;
   @ObfuscatedName("t")
   byte[] field1816;
   @ObfuscatedName("f")
   byte[] field1817;
   @ObfuscatedName("m")
   byte[] field1818;
   @ObfuscatedName("x")
   short[] field1832;
   @ObfuscatedName("w")
   byte field1815;
   @ObfuscatedName("j")
   int field1821;
   @ObfuscatedName("z")
   int[] field1813;
   @ObfuscatedName("e")
   int[] field1823;
   @ObfuscatedName("k")
   int[] field1811;
   @ObfuscatedName("n")
   int[][] field1857;
   @ObfuscatedName("i")
   int[][] field1830;
   @ObfuscatedName("av")
   public boolean field1827;
   @ObfuscatedName("ao")
   @Export("boundsType")
   int boundsType;
   @ObfuscatedName("am")
   @Export("bottomY")
   int bottomY;
   @ObfuscatedName("aj")
   @Export("XYZMag")
   int XYZMag;
   @ObfuscatedName("ah")
   @Export("diameter")
   int diameter;
   @ObfuscatedName("af")
   @Export("radius")
   int radius;
   @ObfuscatedName("ai")
   @Export("centerX")
   public int centerX;
   @ObfuscatedName("aq")
   @Export("centerY")
   public int centerY;
   @ObfuscatedName("ak")
   @Export("centerZ")
   public int centerZ;
   @ObfuscatedName("al")
   @Export("extremeX")
   public int extremeX;
   @ObfuscatedName("as")
   @Export("extremeY")
   public int extremeY;
   @ObfuscatedName("az")
   @Export("extremeZ")
   public int extremeZ;

   static {
      field1849 = new Model();
      field1802 = new byte[1];
      field1803 = new Model();
      field1804 = new byte[1];
      field1852 = new boolean[4700];
      field1861 = new boolean[4700];
      modelViewportYs = new int[4700];
      modelViewportXs = new int[4700];
      field1844 = new int[4700];
      yViewportBuffer = new int[4700];
      field1846 = new int[4700];
      field1847 = new int[4700];
      field1820 = new int[1600];
      field1850 = new int[1600][512];
      field1824 = new int[12];
      field1828 = new int[12][2000];
      field1853 = new int[2000];
      field1854 = new int[2000];
      field1855 = new int[12];
      field1856 = new int[10];
      field1845 = new int[10];
      xViewportBuffer = new int[10];
      useBoundingBoxes3D = true;
      Model_sine = Graphics3D.SINE;
      Model_cosine = Graphics3D.COSINE;
      field1806 = Graphics3D.colorPalette;
      field1868 = Graphics3D.field1911;
   }

   Model() {
      this.verticesCount = 0;
      this.indicesCount = 0;
      this.field1815 = 0;
      this.field1821 = 0;
      this.field1827 = false;
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
      this.field1815 = 0;
      this.field1821 = 0;
      this.field1827 = false;
      this.extremeX = -1;
      this.extremeY = -1;
      this.extremeZ = -1;
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.verticesCount = 0;
      this.indicesCount = 0;
      this.field1821 = 0;
      this.field1815 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.verticesCount += var8.verticesCount;
            this.indicesCount += var8.indicesCount;
            this.field1821 += var8.field1821;
            if(var8.field1816 != null) {
               var3 = true;
            } else {
               if(this.field1815 == -1) {
                  this.field1815 = var8.field1815;
               }

               if(this.field1815 != var8.field1815) {
                  var3 = true;
               }
            }

            var4 |= var8.field1817 != null;
            var5 |= var8.field1832 != null;
            var6 |= var8.field1818 != null;
         }
      }

      this.verticesX = new int[this.verticesCount];
      this.verticesY = new int[this.verticesCount];
      this.verticesZ = new int[this.verticesCount];
      this.indices1 = new int[this.indicesCount];
      this.indices2 = new int[this.indicesCount];
      this.indices3 = new int[this.indicesCount];
      this.field1841 = new int[this.indicesCount];
      this.field1831 = new int[this.indicesCount];
      this.field1869 = new int[this.indicesCount];
      if(var3) {
         this.field1816 = new byte[this.indicesCount];
      }

      if(var4) {
         this.field1817 = new byte[this.indicesCount];
      }

      if(var5) {
         this.field1832 = new short[this.indicesCount];
      }

      if(var6) {
         this.field1818 = new byte[this.indicesCount];
      }

      if(this.field1821 > 0) {
         this.field1813 = new int[this.field1821];
         this.field1823 = new int[this.field1821];
         this.field1811 = new int[this.field1821];
      }

      this.verticesCount = 0;
      this.indicesCount = 0;
      this.field1821 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.indicesCount; ++var9) {
               this.indices1[this.indicesCount] = this.verticesCount + var8.indices1[var9];
               this.indices2[this.indicesCount] = this.verticesCount + var8.indices2[var9];
               this.indices3[this.indicesCount] = this.verticesCount + var8.indices3[var9];
               this.field1841[this.indicesCount] = var8.field1841[var9];
               this.field1831[this.indicesCount] = var8.field1831[var9];
               this.field1869[this.indicesCount] = var8.field1869[var9];
               if(var3) {
                  if(var8.field1816 != null) {
                     this.field1816[this.indicesCount] = var8.field1816[var9];
                  } else {
                     this.field1816[this.indicesCount] = var8.field1815;
                  }
               }

               if(var4 && var8.field1817 != null) {
                  this.field1817[this.indicesCount] = var8.field1817[var9];
               }

               if(var5) {
                  if(var8.field1832 != null) {
                     this.field1832[this.indicesCount] = var8.field1832[var9];
                  } else {
                     this.field1832[this.indicesCount] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1818 != null && var8.field1818[var9] != -1) {
                     this.field1818[this.indicesCount] = (byte)(this.field1821 + var8.field1818[var9]);
                  } else {
                     this.field1818[this.indicesCount] = -1;
                  }
               }

               ++this.indicesCount;
            }

            for(var9 = 0; var9 < var8.field1821; ++var9) {
               this.field1813[this.field1821] = this.verticesCount + var8.field1813[var9];
               this.field1823[this.field1821] = this.verticesCount + var8.field1823[var9];
               this.field1811[this.field1821] = this.verticesCount + var8.field1811[var9];
               ++this.field1821;
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([[IIIIZI)Lee;"
   )
   public Model method2748(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
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
               var11.field1821 = this.field1821;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1841 = this.field1841;
               var11.field1831 = this.field1831;
               var11.field1869 = this.field1869;
               var11.field1816 = this.field1816;
               var11.field1817 = this.field1817;
               var11.field1818 = this.field1818;
               var11.field1832 = this.field1832;
               var11.field1815 = this.field1815;
               var11.field1813 = this.field1813;
               var11.field1823 = this.field1823;
               var11.field1811 = this.field1811;
               var11.field1857 = this.field1857;
               var11.field1830 = this.field1830;
               var11.field1827 = this.field1827;
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Z)Lee;"
   )
   public Model method2703(boolean var1) {
      if(!var1 && field1802.length < this.indicesCount) {
         field1802 = new byte[this.indicesCount + 100];
      }

      return this.method2705(var1, field1849, field1802);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Z)Lee;"
   )
   public Model method2704(boolean var1) {
      if(!var1 && field1804.length < this.indicesCount) {
         field1804 = new byte[this.indicesCount + 100];
      }

      return this.method2705(var1, field1803, field1804);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ZLee;[B)Lee;"
   )
   Model method2705(boolean var1, Model var2, byte[] var3) {
      var2.verticesCount = this.verticesCount;
      var2.indicesCount = this.indicesCount;
      var2.field1821 = this.field1821;
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
         var2.field1817 = this.field1817;
      } else {
         var2.field1817 = var3;
         if(this.field1817 == null) {
            for(var4 = 0; var4 < this.indicesCount; ++var4) {
               var2.field1817[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.indicesCount; ++var4) {
               var2.field1817[var4] = this.field1817[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1841 = this.field1841;
      var2.field1831 = this.field1831;
      var2.field1869 = this.field1869;
      var2.field1816 = this.field1816;
      var2.field1818 = this.field1818;
      var2.field1832 = this.field1832;
      var2.field1815 = this.field1815;
      var2.field1813 = this.field1813;
      var2.field1823 = this.field1823;
      var2.field1811 = this.field1811;
      var2.field1857 = this.field1857;
      var2.field1830 = this.field1830;
      var2.field1827 = this.field1827;
      var2.resetBounds();
      return var2;
   }

   @ObfuscatedName("a")
   void method2741(int var1) {
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
            int var11 = Graphics3D.method2807(this.verticesX[var10], this.verticesZ[var10], var8, var9);
            int var12 = this.verticesY[var10];
            int var13 = Graphics3D.method2824(this.verticesX[var10], this.verticesZ[var10], var8, var9);
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

         if(this.field1827) {
            this.extremeX += 8;
            this.extremeZ += 8;
         }

      }
   }

   @ObfuscatedName("h")
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

   @ObfuscatedName("l")
   void method2708() {
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
   public int method2709() {
      this.calculateBoundsCylinder();
      return this.XYZMag;
   }

   @ObfuscatedName("c")
   @Export("resetBounds")
   void resetBounds() {
      this.boundsType = 0;
      this.extremeX = -1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lej;I)V"
   )
   public void method2718(Frames var1, int var2) {
      if(this.field1857 != null) {
         if(var2 != -1) {
            Frame var3 = var1.skeletons[var2];
            FrameMap var4 = var3.skin;
            field1859 = 0;
            field1860 = 0;
            field1866 = 0;

            for(int var5 = 0; var5 < var3.field1772; ++var5) {
               int var6 = var3.field1773[var5];
               this.method2761(var4.types[var6], var4.list[var6], var3.translator_x[var5], var3.translator_y[var5], var3.translator_z[var5]);
            }

            this.resetBounds();
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lej;ILej;I[I)V"
   )
   public void method2712(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.skeletons[var2];
            Frame var7 = var3.skeletons[var4];
            FrameMap var8 = var6.skin;
            field1859 = 0;
            field1860 = 0;
            field1866 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1772; ++var11) {
               for(var12 = var6.field1773[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.types[var12] == 0) {
                  this.method2761(var8.types[var12], var8.list[var12], var6.translator_x[var11], var6.translator_y[var11], var6.translator_z[var11]);
               }
            }

            field1859 = 0;
            field1860 = 0;
            field1866 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1772; ++var11) {
               for(var12 = var7.field1773[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.types[var12] == 0) {
                  this.method2761(var8.types[var12], var8.list[var12], var7.translator_x[var11], var7.translator_y[var11], var7.translator_z[var11]);
               }
            }

            this.resetBounds();
         } else {
            this.method2718(var1, var2);
         }
      }
   }

   @ObfuscatedName("f")
   void method2761(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1859 = 0;
         field1860 = 0;
         field1866 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var9 = var2[var8];
            if(var9 < this.field1857.length) {
               int[] var10 = this.field1857[var9];

               for(var11 = 0; var11 < var10.length; ++var11) {
                  var12 = var10[var11];
                  field1859 += this.verticesX[var12];
                  field1860 += this.verticesY[var12];
                  field1866 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1859 = var3 + field1859 / var7;
            field1860 = var4 + field1860 / var7;
            field1866 = var5 + field1866 / var7;
         } else {
            field1859 = var3;
            field1860 = var4;
            field1866 = var5;
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
                     this.verticesX[var11] -= field1859;
                     this.verticesY[var11] -= field1860;
                     this.verticesZ[var11] -= field1866;
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

                     this.verticesX[var11] += field1859;
                     this.verticesY[var11] += field1860;
                     this.verticesZ[var11] += field1866;
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
                     this.verticesX[var11] -= field1859;
                     this.verticesY[var11] -= field1860;
                     this.verticesZ[var11] -= field1866;
                     this.verticesX[var11] = var3 * this.verticesX[var11] / 128;
                     this.verticesY[var11] = var4 * this.verticesY[var11] / 128;
                     this.verticesZ[var11] = var5 * this.verticesZ[var11] / 128;
                     this.verticesX[var11] += field1859;
                     this.verticesY[var11] += field1860;
                     this.verticesZ[var11] += field1866;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1830 != null && this.field1817 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1830.length) {
                     var18 = this.field1830[var8];

                     for(var19 = 0; var19 < var18.length; ++var19) {
                        var11 = var18[var19];
                        var12 = (this.field1817[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1817[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("m")
   @Export("rotateY90Ccw")
   public void rotateY90Ccw() {
      for(int var1 = 0; var1 < this.verticesCount; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.resetBounds();
   }

   @ObfuscatedName("x")
   public void method2757() {
      for(int var1 = 0; var1 < this.verticesCount; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.resetBounds();
   }

   @ObfuscatedName("w")
   public void method2716() {
      for(int var1 = 0; var1 < this.verticesCount; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.resetBounds();
   }

   @ObfuscatedName("j")
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

   @ObfuscatedName("z")
   @Export("offsetBy")
   public void offsetBy(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.verticesCount; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.resetBounds();
   }

   @ObfuscatedName("e")
   @Export("scale")
   public void scale(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.verticesCount; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = var2 * this.verticesY[var4] / 128;
         this.verticesZ[var4] = var3 * this.verticesZ[var4] / 128;
      }

      this.resetBounds();
   }

   @ObfuscatedName("k")
   public final void method2731(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1820[0] = -1;
      if(this.boundsType != 2 && this.boundsType != 1) {
         this.method2708();
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
         field1844[var19] = var22 - var18;
         modelViewportYs[var19] = var20 * Graphics3D.Rasterizer3D_zoom / var22 + var8;
         modelViewportXs[var19] = var23 * Graphics3D.Rasterizer3D_zoom / var22 + var9;
         if(this.field1821 > 0) {
            yViewportBuffer[var19] = var20;
            field1846[var19] = var23;
            field1847[var19] = var22;
         }
      }

      try {
         this.method0(false, false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("ao")
   public final void method2721(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1820[0] = -1;
      if(this.boundsType != 2 && this.boundsType != 1) {
         this.method2708();
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
         field1844[var20] = var23 - var19;
         modelViewportYs[var20] = var9 + var21 * Graphics3D.Rasterizer3D_zoom / var8;
         modelViewportXs[var20] = var10 + var24 * Graphics3D.Rasterizer3D_zoom / var8;
         if(this.field1821 > 0) {
            yViewportBuffer[var20] = var21;
            field1846[var20] = var24;
            field1847[var20] = var23;
         }
      }

      try {
         this.method0(false, false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("am")
   @Export("method0")
   final void method0(boolean var1, boolean var2, boolean var3, int var4) {
      if(this.diameter < 1600) {
         int var5;
         for(var5 = 0; var5 < this.diameter; ++var5) {
            field1820[var5] = 0;
         }

         var5 = var3?20:5;
         if(class7.drawObjectGeometry2D && var2) {
            class239.method4492(this, var5);
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
            if(this.field1869[var6] != -2) {
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
                     var17 = var5 + class131.Viewport_mouseY;
                     boolean var31;
                     if(var17 < var14 && var17 < var15 && var17 < var16) {
                        var31 = false;
                     } else {
                        var17 = class131.Viewport_mouseY - var5;
                        if(var17 > var14 && var17 > var15 && var17 > var16) {
                           var31 = false;
                        } else {
                           var17 = var5 + class131.Viewport_mouseX;
                           if(var17 < var10 && var17 < var11 && var17 < var12) {
                              var31 = false;
                           } else {
                              var17 = class131.Viewport_mouseX - var5;
                              if(var17 > var10 && var17 > var11 && var17 > var12) {
                                 var31 = false;
                              } else {
                                 var31 = true;
                              }
                           }
                        }
                     }

                     if(var31) {
                        class28.method246(var4);
                        var2 = false;
                     }
                  }

                  if((var10 - var11) * (modelViewportXs[var9] - modelViewportXs[var8]) - (var12 - var11) * (modelViewportXs[var7] - modelViewportXs[var8]) > 0) {
                     field1861[var6] = false;
                     if(var10 >= 0 && var11 >= 0 && var12 >= 0 && var10 <= Graphics3D.rasterClipX && var11 <= Graphics3D.rasterClipX && var12 <= Graphics3D.rasterClipX) {
                        field1852[var6] = false;
                     } else {
                        field1852[var6] = true;
                     }

                     var13 = (field1844[var7] + field1844[var8] + field1844[var9]) / 3 + this.radius;
                     field1850[var13][field1820[var13]++] = var6;
                  }
               } else {
                  var13 = yViewportBuffer[var7];
                  var14 = yViewportBuffer[var8];
                  var15 = yViewportBuffer[var9];
                  var16 = field1846[var7];
                  var17 = field1846[var8];
                  int var18 = field1846[var9];
                  int var19 = field1847[var7];
                  int var20 = field1847[var8];
                  int var21 = field1847[var9];
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
                     int var25 = (field1844[var7] + field1844[var8] + field1844[var9]) / 3 + this.radius;
                     field1850[var25][field1820[var25]++] = var6;
                  }
               }
            }
         }

         int[] var26;
         if(this.field1816 == null) {
            for(var6 = this.diameter - 1; var6 >= 0; --var6) {
               var7 = field1820[var6];
               if(var7 > 0) {
                  var26 = field1850[var6];

                  for(var9 = 0; var9 < var7; ++var9) {
                     this.method2754(var26[var9]);
                  }
               }
            }

         } else {
            for(var6 = 0; var6 < 12; ++var6) {
               field1824[var6] = 0;
               field1855[var6] = 0;
            }

            for(var6 = this.diameter - 1; var6 >= 0; --var6) {
               var7 = field1820[var6];
               if(var7 > 0) {
                  var26 = field1850[var6];

                  for(var9 = 0; var9 < var7; ++var9) {
                     var10 = var26[var9];
                     byte var30 = this.field1816[var10];
                     var12 = field1824[var30]++;
                     field1828[var30][var12] = var10;
                     if(var30 < 10) {
                        field1855[var30] += var6;
                     } else if(var30 == 10) {
                        field1853[var12] = var6;
                     } else {
                        field1854[var12] = var6;
                     }
                  }
               }
            }

            var6 = 0;
            if(field1824[1] > 0 || field1824[2] > 0) {
               var6 = (field1855[1] + field1855[2]) / (field1824[1] + field1824[2]);
            }

            var7 = 0;
            if(field1824[3] > 0 || field1824[4] > 0) {
               var7 = (field1855[3] + field1855[4]) / (field1824[3] + field1824[4]);
            }

            var8 = 0;
            if(field1824[6] > 0 || field1824[8] > 0) {
               var8 = (field1855[8] + field1855[6]) / (field1824[8] + field1824[6]);
            }

            var10 = 0;
            var11 = field1824[10];
            int[] var27 = field1828[10];
            int[] var28 = field1853;
            if(var10 == var11) {
               var10 = 0;
               var11 = field1824[11];
               var27 = field1828[11];
               var28 = field1854;
            }

            if(var10 < var11) {
               var9 = var28[var10];
            } else {
               var9 = -1000;
            }

            for(var14 = 0; var14 < 10; ++var14) {
               while(var14 == 0 && var9 > var6) {
                  this.method2754(var27[var10++]);
                  if(var10 == var11 && var27 != field1828[11]) {
                     var10 = 0;
                     var11 = field1824[11];
                     var27 = field1828[11];
                     var28 = field1854;
                  }

                  if(var10 < var11) {
                     var9 = var28[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 3 && var9 > var7) {
                  this.method2754(var27[var10++]);
                  if(var10 == var11 && var27 != field1828[11]) {
                     var10 = 0;
                     var11 = field1824[11];
                     var27 = field1828[11];
                     var28 = field1854;
                  }

                  if(var10 < var11) {
                     var9 = var28[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               while(var14 == 5 && var9 > var8) {
                  this.method2754(var27[var10++]);
                  if(var10 == var11 && var27 != field1828[11]) {
                     var10 = 0;
                     var11 = field1824[11];
                     var27 = field1828[11];
                     var28 = field1854;
                  }

                  if(var10 < var11) {
                     var9 = var28[var10];
                  } else {
                     var9 = -1000;
                  }
               }

               var15 = field1824[var14];
               int[] var29 = field1828[var14];

               for(var17 = 0; var17 < var15; ++var17) {
                  this.method2754(var29[var17]);
               }
            }

            while(var9 != -1000) {
               this.method2754(var27[var10++]);
               if(var10 == var11 && var27 != field1828[11]) {
                  var10 = 0;
                  var27 = field1828[11];
                  var11 = field1824[11];
                  var28 = field1854;
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

   @ObfuscatedName("aj")
   final void method2754(int var1) {
      if(field1861[var1]) {
         this.method2724(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         Graphics3D.rasterClipEnable = field1852[var1];
         if(this.field1817 == null) {
            Graphics3D.rasterAlpha = 0;
         } else {
            Graphics3D.rasterAlpha = this.field1817[var1] & 255;
         }

         if(this.field1832 != null && this.field1832[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1818 != null && this.field1818[var1] != -1) {
               int var8 = this.field1818[var1] & 255;
               var5 = this.field1813[var8];
               var6 = this.field1823[var8];
               var7 = this.field1811[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1869[var1] == -1) {
               Graphics3D.rasterTextureAffine(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], this.field1841[var1], this.field1841[var1], this.field1841[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1846[var5], field1846[var6], field1846[var7], field1847[var5], field1847[var6], field1847[var7], this.field1832[var1]);
            } else {
               Graphics3D.rasterTextureAffine(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], this.field1841[var1], this.field1831[var1], this.field1869[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1846[var5], field1846[var6], field1846[var7], field1847[var5], field1847[var6], field1847[var7], this.field1832[var1]);
            }
         } else if(this.field1869[var1] == -1) {
            Graphics3D.rasterFlat(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], field1806[this.field1841[var1]]);
         } else {
            Graphics3D.rasterGouraud(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], this.field1841[var1], this.field1831[var1], this.field1869[var1]);
         }

      }
   }

   @ObfuscatedName("ah")
   final void method2724(int var1) {
      int var2 = Graphics3D.centerX;
      int var3 = Graphics3D.centerY;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1847[var5];
      int var9 = field1847[var6];
      int var10 = field1847[var7];
      if(this.field1817 == null) {
         Graphics3D.rasterAlpha = 0;
      } else {
         Graphics3D.rasterAlpha = this.field1817[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1856[var4] = modelViewportYs[var5];
         field1845[var4] = modelViewportXs[var5];
         xViewportBuffer[var4++] = this.field1841[var1];
      } else {
         var11 = yViewportBuffer[var5];
         var12 = field1846[var5];
         var13 = this.field1841[var1];
         if(var10 >= 50) {
            var14 = field1868[var10 - var8] * (50 - var8);
            field1856[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) / 50;
            field1845[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1846[var7] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1869[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = field1868[var9 - var8] * (50 - var8);
            field1856[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) / 50;
            field1845[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1846[var6] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1831[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1856[var4] = modelViewportYs[var6];
         field1845[var4] = modelViewportXs[var6];
         xViewportBuffer[var4++] = this.field1831[var1];
      } else {
         var11 = yViewportBuffer[var6];
         var12 = field1846[var6];
         var13 = this.field1831[var1];
         if(var8 >= 50) {
            var14 = field1868[var8 - var9] * (50 - var9);
            field1856[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) / 50;
            field1845[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1846[var5] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1841[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = field1868[var10 - var9] * (50 - var9);
            field1856[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) / 50;
            field1845[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1846[var7] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1869[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1856[var4] = modelViewportYs[var7];
         field1845[var4] = modelViewportXs[var7];
         xViewportBuffer[var4++] = this.field1869[var1];
      } else {
         var11 = yViewportBuffer[var7];
         var12 = field1846[var7];
         var13 = this.field1869[var1];
         if(var9 >= 50) {
            var14 = field1868[var9 - var10] * (50 - var10);
            field1856[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) / 50;
            field1845[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1846[var6] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1831[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = field1868[var8 - var10] * (50 - var10);
            field1856[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) / 50;
            field1845[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1846[var5] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1841[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1856[0];
      var12 = field1856[1];
      var13 = field1856[2];
      var14 = field1845[0];
      int var15 = field1845[1];
      int var16 = field1845[2];
      Graphics3D.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX) {
            Graphics3D.rasterClipEnable = true;
         }

         if(this.field1832 != null && this.field1832[var1] != -1) {
            if(this.field1818 != null && this.field1818[var1] != -1) {
               var20 = this.field1818[var1] & 255;
               var17 = this.field1813[var20];
               var18 = this.field1823[var20];
               var19 = this.field1811[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1869[var1] == -1) {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1841[var1], this.field1841[var1], this.field1841[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1846[var17], field1846[var18], field1846[var19], field1847[var17], field1847[var18], field1847[var19], this.field1832[var1]);
            } else {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1846[var17], field1846[var18], field1846[var19], field1847[var17], field1847[var18], field1847[var19], this.field1832[var1]);
            }
         } else if(this.field1869[var1] == -1) {
            Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, field1806[this.field1841[var1]]);
         } else {
            Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX || field1856[3] < 0 || field1856[3] > Graphics3D.rasterClipX) {
            Graphics3D.rasterClipEnable = true;
         }

         if(this.field1832 != null && this.field1832[var1] != -1) {
            if(this.field1818 != null && this.field1818[var1] != -1) {
               var20 = this.field1818[var1] & 255;
               var17 = this.field1813[var20];
               var18 = this.field1823[var20];
               var19 = this.field1811[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1832[var1];
            if(this.field1869[var1] == -1) {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1841[var1], this.field1841[var1], this.field1841[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1846[var17], field1846[var18], field1846[var19], field1847[var17], field1847[var18], field1847[var19], var21);
               Graphics3D.rasterTextureAffine(var14, var16, field1845[3], var11, var13, field1856[3], this.field1841[var1], this.field1841[var1], this.field1841[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1846[var17], field1846[var18], field1846[var19], field1847[var17], field1847[var18], field1847[var19], var21);
            } else {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1846[var17], field1846[var18], field1846[var19], field1847[var17], field1847[var18], field1847[var19], var21);
               Graphics3D.rasterTextureAffine(var14, var16, field1845[3], var11, var13, field1856[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1846[var17], field1846[var18], field1846[var19], field1847[var17], field1847[var18], field1847[var19], var21);
            }
         } else if(this.field1869[var1] == -1) {
            var17 = field1806[this.field1841[var1]];
            Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            Graphics3D.rasterFlat(var14, var16, field1845[3], var11, var13, field1856[3], var17);
         } else {
            Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
            Graphics3D.rasterGouraud(var14, var16, field1845[3], var11, var13, field1856[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3]);
         }
      }

   }

   @ObfuscatedName("ct")
   @Export("draw")
   void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1820[0] = -1;
      if(this.boundsType != 1) {
         this.calculateBoundsCylinder();
      }

      this.method2741(var1);
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

                     boolean var25 = var24 || this.field1821 > 0;
                     int var26 = class131.Viewport_mouseX;
                     int var28 = class131.Viewport_mouseY;
                     boolean var30 = class131.Viewport_containsMouse;
                     if(class7.drawBoundingBoxes3D && var9 > 0) {
                        DState.method3527(this, var6, var7, var8);
                     }

                     int var33;
                     int var34;
                     int var35;
                     int var36;
                     int var37;
                     int var38;
                     int var39;
                     int var40;
                     int var41;
                     if(class7.drawBoundingBoxes2D && var9 > 0) {
                        int var32 = var11 - var12;
                        if(var32 <= 50) {
                           var32 = 50;
                        }

                        if(var14 > 0) {
                           var33 = var15 / var13;
                           var34 = var16 / var32;
                        } else {
                           var34 = var16 / var13;
                           var33 = var15 / var32;
                        }

                        if(var17 > 0) {
                           var35 = var21 / var13;
                           var36 = var19 / var32;
                        } else {
                           var36 = var19 / var13;
                           var35 = var21 / var32;
                        }

                        var37 = -8355840;
                        var38 = var26 - Graphics3D.centerX;
                        var39 = var28 - Graphics3D.centerY;
                        if(var38 > var33 && var38 < var34 && var39 > var35 && var39 < var36) {
                           var37 = -256;
                        }

                        var40 = var33 + Graphics3D.centerX;
                        var41 = var35 + Graphics3D.centerY;
                        int var42 = var34 + Graphics3D.centerX;
                        int var43 = var36 + Graphics3D.centerY;
                        class7.boundingBoxes.addFirst(new BoundingBox2D(var40, var41, var42, var43, var37));
                     }

                     boolean var46 = false;
                     if(var9 > 0 && var30) {
                        boolean var47 = false;
                        if(useBoundingBoxes3D) {
                           var47 = BaseVarType.boundingBox3DContainsMouse(this, var6, var7, var8);
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
                              var47 = true;
                           }
                        }

                        if(var47) {
                           if(this.field1827) {
                              class28.method246(var9);
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
                        var40 = this.verticesZ[var37];
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
                        field1844[var37] = var40 - var11;
                        if(var40 >= 50) {
                           modelViewportYs[var37] = var38 * Graphics3D.Rasterizer3D_zoom / var40 + var33;
                           modelViewportXs[var37] = var41 * Graphics3D.Rasterizer3D_zoom / var40 + var34;
                        } else {
                           modelViewportYs[var37] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           yViewportBuffer[var37] = var38;
                           field1846[var37] = var41;
                           field1847[var37] = var40;
                        }
                     }

                     try {
                        this.method0(var23, var46, this.field1827, var9);
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
