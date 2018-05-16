import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ldk;"
   )
   static Model field1623;
   @ObfuscatedName("m")
   static byte[] field1611;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ldk;"
   )
   static Model field1612;
   @ObfuscatedName("b")
   static byte[] field1613;
   @ObfuscatedName("af")
   static boolean[] field1610;
   @ObfuscatedName("am")
   static boolean[] field1650;
   @ObfuscatedName("aq")
   @Export("modelViewportYs")
   static int[] modelViewportYs;
   @ObfuscatedName("aj")
   @Export("modelViewportXs")
   static int[] modelViewportXs;
   @ObfuscatedName("ae")
   static int[] field1653;
   @ObfuscatedName("au")
   @Export("yViewportBuffer")
   static int[] yViewportBuffer;
   @ObfuscatedName("av")
   static int[] field1655;
   @ObfuscatedName("ab")
   static int[] field1656;
   @ObfuscatedName("ar")
   static int[] field1658;
   @ObfuscatedName("ax")
   static int[][] field1659;
   @ObfuscatedName("al")
   static int[] field1631;
   @ObfuscatedName("ak")
   static int[][] field1661;
   @ObfuscatedName("bc")
   static int[] field1662;
   @ObfuscatedName("bo")
   static int[] field1663;
   @ObfuscatedName("bx")
   static int[] field1634;
   @ObfuscatedName("be")
   static int[] field1665;
   @ObfuscatedName("br")
   static int[] field1666;
   @ObfuscatedName("bk")
   @Export("xViewportBuffer")
   static int[] xViewportBuffer;
   @ObfuscatedName("bn")
   @Export("animOffsetX")
   static int animOffsetX;
   @ObfuscatedName("bp")
   @Export("animOffsetY")
   static int animOffsetY;
   @ObfuscatedName("bu")
   @Export("animOffsetZ")
   static int animOffsetZ;
   @ObfuscatedName("by")
   @Export("useBoundingBoxes3D")
   static boolean useBoundingBoxes3D;
   @ObfuscatedName("bi")
   @Export("Model_sine")
   static int[] Model_sine;
   @ObfuscatedName("bb")
   @Export("Model_cosine")
   static int[] Model_cosine;
   @ObfuscatedName("bt")
   static int[] field1676;
   @ObfuscatedName("bm")
   static int[] field1677;
   @ObfuscatedName("f")
   @Export("verticesCount")
   int verticesCount;
   @ObfuscatedName("n")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("h")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("x")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("j")
   @Export("indicesCount")
   int indicesCount;
   @ObfuscatedName("a")
   @Export("indices1")
   int[] indices1;
   @ObfuscatedName("l")
   @Export("indices2")
   int[] indices2;
   @ObfuscatedName("d")
   @Export("indices3")
   int[] indices3;
   @ObfuscatedName("s")
   int[] field1622;
   @ObfuscatedName("p")
   int[] field1671;
   @ObfuscatedName("g")
   int[] field1626;
   @ObfuscatedName("y")
   byte[] field1648;
   @ObfuscatedName("c")
   byte[] field1629;
   @ObfuscatedName("e")
   byte[] field1627;
   @ObfuscatedName("t")
   short[] field1628;
   @ObfuscatedName("u")
   byte field1619;
   @ObfuscatedName("i")
   int field1630;
   @ObfuscatedName("z")
   int[] field1635;
   @ObfuscatedName("k")
   int[] field1632;
   @ObfuscatedName("r")
   int[] field1633;
   @ObfuscatedName("v")
   @Export("vertexGroups")
   int[][] vertexGroups;
   @ObfuscatedName("o")
   int[][] field1660;
   @ObfuscatedName("ai")
   public boolean field1636;
   @ObfuscatedName("at")
   @Export("boundsType")
   int boundsType;
   @ObfuscatedName("ad")
   @Export("bottomY")
   int bottomY;
   @ObfuscatedName("ac")
   @Export("XYZMag")
   int XYZMag;
   @ObfuscatedName("ay")
   @Export("diameter")
   int diameter;
   @ObfuscatedName("an")
   @Export("radius")
   int radius;
   @ObfuscatedName("as")
   @Export("centerX")
   int centerX;
   @ObfuscatedName("aw")
   @Export("centerY")
   int centerY;
   @ObfuscatedName("ag")
   @Export("centerZ")
   int centerZ;
   @ObfuscatedName("ah")
   @Export("extremeX")
   int extremeX;
   @ObfuscatedName("az")
   @Export("extremeY")
   int extremeY;
   @ObfuscatedName("ao")
   @Export("extremeZ")
   int extremeZ;

   static {
      field1623 = new Model();
      field1611 = new byte[1];
      field1612 = new Model();
      field1613 = new byte[1];
      field1610 = new boolean[4700];
      field1650 = new boolean[4700];
      modelViewportYs = new int[4700];
      modelViewportXs = new int[4700];
      field1653 = new int[4700];
      yViewportBuffer = new int[4700];
      field1655 = new int[4700];
      field1656 = new int[4700];
      field1658 = new int[1600];
      field1659 = new int[1600][512];
      field1631 = new int[12];
      field1661 = new int[12][2000];
      field1662 = new int[2000];
      field1663 = new int[2000];
      field1634 = new int[12];
      field1665 = new int[10];
      field1666 = new int[10];
      xViewportBuffer = new int[10];
      useBoundingBoxes3D = true;
      Model_sine = Graphics3D.SINE;
      Model_cosine = Graphics3D.COSINE;
      field1676 = Graphics3D.colorPalette;
      field1677 = Graphics3D.field1704;
   }

   Model() {
      this.verticesCount = 0;
      this.indicesCount = 0;
      this.field1619 = 0;
      this.field1630 = 0;
      this.field1636 = false;
      this.extremeX = -1;
      this.extremeY = -1;
      this.extremeZ = -1;
   }

   @ObfuscatedSignature(
      signature = "([Ldk;I)V"
   )
   public Model(Model[] var1, int var2) {
      this.verticesCount = 0;
      this.indicesCount = 0;
      this.field1619 = 0;
      this.field1630 = 0;
      this.field1636 = false;
      this.extremeX = -1;
      this.extremeY = -1;
      this.extremeZ = -1;
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.verticesCount = 0;
      this.indicesCount = 0;
      this.field1630 = 0;
      this.field1619 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.verticesCount += var8.verticesCount;
            this.indicesCount += var8.indicesCount;
            this.field1630 += var8.field1630;
            if(var8.field1648 != null) {
               var3 = true;
            } else {
               if(this.field1619 == -1) {
                  this.field1619 = var8.field1619;
               }

               if(this.field1619 != var8.field1619) {
                  var3 = true;
               }
            }

            var4 |= var8.field1629 != null;
            var5 |= var8.field1628 != null;
            var6 |= var8.field1627 != null;
         }
      }

      this.verticesX = new int[this.verticesCount];
      this.verticesY = new int[this.verticesCount];
      this.verticesZ = new int[this.verticesCount];
      this.indices1 = new int[this.indicesCount];
      this.indices2 = new int[this.indicesCount];
      this.indices3 = new int[this.indicesCount];
      this.field1622 = new int[this.indicesCount];
      this.field1671 = new int[this.indicesCount];
      this.field1626 = new int[this.indicesCount];
      if(var3) {
         this.field1648 = new byte[this.indicesCount];
      }

      if(var4) {
         this.field1629 = new byte[this.indicesCount];
      }

      if(var5) {
         this.field1628 = new short[this.indicesCount];
      }

      if(var6) {
         this.field1627 = new byte[this.indicesCount];
      }

      if(this.field1630 > 0) {
         this.field1635 = new int[this.field1630];
         this.field1632 = new int[this.field1630];
         this.field1633 = new int[this.field1630];
      }

      this.verticesCount = 0;
      this.indicesCount = 0;
      this.field1630 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.indicesCount; ++var9) {
               this.indices1[this.indicesCount] = this.verticesCount + var8.indices1[var9];
               this.indices2[this.indicesCount] = this.verticesCount + var8.indices2[var9];
               this.indices3[this.indicesCount] = this.verticesCount + var8.indices3[var9];
               this.field1622[this.indicesCount] = var8.field1622[var9];
               this.field1671[this.indicesCount] = var8.field1671[var9];
               this.field1626[this.indicesCount] = var8.field1626[var9];
               if(var3) {
                  if(var8.field1648 != null) {
                     this.field1648[this.indicesCount] = var8.field1648[var9];
                  } else {
                     this.field1648[this.indicesCount] = var8.field1619;
                  }
               }

               if(var4 && var8.field1629 != null) {
                  this.field1629[this.indicesCount] = var8.field1629[var9];
               }

               if(var5) {
                  if(var8.field1628 != null) {
                     this.field1628[this.indicesCount] = var8.field1628[var9];
                  } else {
                     this.field1628[this.indicesCount] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1627 != null && var8.field1627[var9] != -1) {
                     this.field1627[this.indicesCount] = (byte)(this.field1630 + var8.field1627[var9]);
                  } else {
                     this.field1627[this.indicesCount] = -1;
                  }
               }

               ++this.indicesCount;
            }

            for(var9 = 0; var9 < var8.field1630; ++var9) {
               this.field1635[this.field1630] = this.verticesCount + var8.field1635[var9];
               this.field1632[this.field1630] = this.verticesCount + var8.field1632[var9];
               this.field1633[this.field1630] = this.verticesCount + var8.field1633[var9];
               ++this.field1630;
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([[IIIIZI)Ldk;"
   )
   public Model method2720(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
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
               var11.field1630 = this.field1630;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1622 = this.field1622;
               var11.field1671 = this.field1671;
               var11.field1626 = this.field1626;
               var11.field1648 = this.field1648;
               var11.field1629 = this.field1629;
               var11.field1627 = this.field1627;
               var11.field1628 = this.field1628;
               var11.field1619 = this.field1619;
               var11.field1635 = this.field1635;
               var11.field1632 = this.field1632;
               var11.field1633 = this.field1633;
               var11.vertexGroups = this.vertexGroups;
               var11.field1660 = this.field1660;
               var11.field1636 = this.field1636;
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

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Z)Ldk;"
   )
   @Export("toSharedModel")
   public Model toSharedModel(boolean var1) {
      if(!var1 && field1611.length < this.indicesCount) {
         field1611 = new byte[this.indicesCount + 100];
      }

      return this.method2723(var1, field1623, field1611);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Z)Ldk;"
   )
   @Export("toSharedSpotAnimModel")
   public Model toSharedSpotAnimModel(boolean var1) {
      if(!var1 && field1613.length < this.indicesCount) {
         field1613 = new byte[this.indicesCount + 100];
      }

      return this.method2723(var1, field1612, field1613);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ZLdk;[B)Ldk;"
   )
   Model method2723(boolean var1, Model var2, byte[] var3) {
      var2.verticesCount = this.verticesCount;
      var2.indicesCount = this.indicesCount;
      var2.field1630 = this.field1630;
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
         var2.field1629 = this.field1629;
      } else {
         var2.field1629 = var3;
         if(this.field1629 == null) {
            for(var4 = 0; var4 < this.indicesCount; ++var4) {
               var2.field1629[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.indicesCount; ++var4) {
               var2.field1629[var4] = this.field1629[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1622 = this.field1622;
      var2.field1671 = this.field1671;
      var2.field1626 = this.field1626;
      var2.field1648 = this.field1648;
      var2.field1627 = this.field1627;
      var2.field1628 = this.field1628;
      var2.field1619 = this.field1619;
      var2.field1635 = this.field1635;
      var2.field1632 = this.field1632;
      var2.field1633 = this.field1633;
      var2.vertexGroups = this.vertexGroups;
      var2.field1660 = this.field1660;
      var2.field1636 = this.field1636;
      var2.resetBounds();
      return var2;
   }

   @ObfuscatedName("j")
   void method2724(int var1) {
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
            int var11 = Graphics3D.method2836(this.verticesX[var10], this.verticesZ[var10], var8, var9);
            int var12 = this.verticesY[var10];
            int var13 = Graphics3D.method2856(this.verticesX[var10], this.verticesZ[var10], var8, var9);
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

         if(this.field1636) {
            this.extremeX += 8;
            this.extremeZ += 8;
         }

      }
   }

   @ObfuscatedName("a")
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
   void method2726() {
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

   @ObfuscatedName("d")
   public int method2727() {
      this.calculateBoundsCylinder();
      return this.XYZMag;
   }

   @ObfuscatedName("p")
   @Export("resetBounds")
   void resetBounds() {
      this.boundsType = 0;
      this.extremeX = -1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lec;I)V"
   )
   public void method2783(Frames var1, int var2) {
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

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lec;ILec;I[I)V"
   )
   public void method2777(Frames var1, int var2, Frames var3, int var4, int[] var5) {
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
            this.method2783(var1, var2);
         }
      }
   }

   @ObfuscatedName("c")
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
            if(this.field1660 != null && this.field1629 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1660.length) {
                     var18 = this.field1660[var8];

                     for(var19 = 0; var19 < var18.length; ++var19) {
                        var11 = var18[var19];
                        var12 = (this.field1629[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1629[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("e")
   @Export("rotateY90Ccw")
   public void rotateY90Ccw() {
      for(int var1 = 0; var1 < this.verticesCount; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.resetBounds();
   }

   @ObfuscatedName("t")
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

   @ObfuscatedName("i")
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

   @ObfuscatedName("r")
   @Export("offsetBy")
   public void offsetBy(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.verticesCount; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.resetBounds();
   }

   @ObfuscatedName("v")
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
   public final void method2738(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1658[0] = -1;
      if(this.boundsType != 2 && this.boundsType != 1) {
         this.method2726();
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
         field1653[var19] = var22 - var18;
         modelViewportYs[var19] = var20 * Graphics3D.Rasterizer3D_zoom / var22 + var8;
         modelViewportXs[var19] = var23 * Graphics3D.Rasterizer3D_zoom / var22 + var9;
         if(this.field1630 > 0) {
            yViewportBuffer[var19] = var20;
            field1655[var19] = var23;
            field1656[var19] = var22;
         }
      }

      try {
         this.method2741(false, false, false, 0L);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("ai")
   public final void method2746(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1658[0] = -1;
      if(this.boundsType != 2 && this.boundsType != 1) {
         this.method2726();
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
         field1653[var20] = var23 - var19;
         modelViewportYs[var20] = var9 + var21 * Graphics3D.Rasterizer3D_zoom / var8;
         modelViewportXs[var20] = var10 + var24 * Graphics3D.Rasterizer3D_zoom / var8;
         if(this.field1630 > 0) {
            yViewportBuffer[var20] = var21;
            field1655[var20] = var24;
            field1656[var20] = var23;
         }
      }

      try {
         this.method2741(false, false, false, 0L);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("at")
   final void method2741(boolean var1, boolean var2, boolean var3, long var4) {
      if(this.diameter < 1600) {
         int var6;
         for(var6 = 0; var6 < this.diameter; ++var6) {
            field1658[var6] = 0;
         }

         var6 = var3?20:5;

         int var7;
         int var8;
         int var10;
         int var11;
         int var12;
         int var13;
         int var15;
         int var16;
         int var18;
         int var27;
         for(var7 = 0; var7 < this.indicesCount; ++var7) {
            if(this.field1626[var7] != -2) {
               var8 = this.indices1[var7];
               var27 = this.indices2[var7];
               var10 = this.indices3[var7];
               var11 = modelViewportYs[var8];
               var12 = modelViewportYs[var27];
               var13 = modelViewportYs[var10];
               int var14;
               int var17;
               if(!var1 || var11 != -5000 && var12 != -5000 && var13 != -5000) {
                  if(var2) {
                     var15 = modelViewportXs[var8];
                     var16 = modelViewportXs[var27];
                     var17 = modelViewportXs[var10];
                     var18 = var6 + class120.Viewport_mouseY;
                     boolean var34;
                     if(var18 < var15 && var18 < var16 && var18 < var17) {
                        var34 = false;
                     } else {
                        var18 = class120.Viewport_mouseY - var6;
                        if(var18 > var15 && var18 > var16 && var18 > var17) {
                           var34 = false;
                        } else {
                           var18 = var6 + class120.Viewport_mouseX;
                           if(var18 < var11 && var18 < var12 && var18 < var13) {
                              var34 = false;
                           } else {
                              var18 = class120.Viewport_mouseX - var6;
                              if(var18 > var11 && var18 > var12 && var18 > var13) {
                                 var34 = false;
                              } else {
                                 var34 = true;
                              }
                           }
                        }
                     }

                     if(var34) {
                        class120.field1688[++class120.Viewport_entityCountAtMouse - 1] = var4;
                        var2 = false;
                     }
                  }

                  if((var11 - var12) * (modelViewportXs[var10] - modelViewportXs[var27]) - (var13 - var12) * (modelViewportXs[var8] - modelViewportXs[var27]) > 0) {
                     field1650[var7] = false;
                     if(var11 >= 0 && var12 >= 0 && var13 >= 0 && var11 <= Graphics3D.rasterClipX && var12 <= Graphics3D.rasterClipX && var13 <= Graphics3D.rasterClipX) {
                        field1610[var7] = false;
                     } else {
                        field1610[var7] = true;
                     }

                     var14 = (field1653[var8] + field1653[var27] + field1653[var10]) / 3 + this.radius;
                     field1659[var14][field1658[var14]++] = var7;
                  }
               } else {
                  var14 = yViewportBuffer[var8];
                  var15 = yViewportBuffer[var27];
                  var16 = yViewportBuffer[var10];
                  var17 = field1655[var8];
                  var18 = field1655[var27];
                  int var19 = field1655[var10];
                  int var20 = field1656[var8];
                  int var21 = field1656[var27];
                  int var22 = field1656[var10];
                  var14 -= var15;
                  var16 -= var15;
                  var17 -= var18;
                  var19 -= var18;
                  var20 -= var21;
                  var22 -= var21;
                  int var23 = var17 * var22 - var20 * var19;
                  int var24 = var20 * var16 - var14 * var22;
                  int var25 = var14 * var19 - var17 * var16;
                  if(var15 * var23 + var18 * var24 + var21 * var25 > 0) {
                     field1650[var7] = true;
                     int var26 = (field1653[var8] + field1653[var27] + field1653[var10]) / 3 + this.radius;
                     field1659[var26][field1658[var26]++] = var7;
                  }
               }
            }
         }

         int[] var9;
         if(this.field1648 == null) {
            for(var7 = this.diameter - 1; var7 >= 0; --var7) {
               var8 = field1658[var7];
               if(var8 > 0) {
                  var9 = field1659[var7];

                  for(var10 = 0; var10 < var8; ++var10) {
                     this.method2742(var9[var10]);
                  }
               }
            }

         } else {
            for(var7 = 0; var7 < 12; ++var7) {
               field1631[var7] = 0;
               field1634[var7] = 0;
            }

            for(var7 = this.diameter - 1; var7 >= 0; --var7) {
               var8 = field1658[var7];
               if(var8 > 0) {
                  var9 = field1659[var7];

                  for(var10 = 0; var10 < var8; ++var10) {
                     var11 = var9[var10];
                     byte var33 = this.field1648[var11];
                     var13 = field1631[var33]++;
                     field1661[var33][var13] = var11;
                     if(var33 < 10) {
                        field1634[var33] += var7;
                     } else if(var33 == 10) {
                        field1662[var13] = var7;
                     } else {
                        field1663[var13] = var7;
                     }
                  }
               }
            }

            var7 = 0;
            if(field1631[1] > 0 || field1631[2] > 0) {
               var7 = (field1634[1] + field1634[2]) / (field1631[1] + field1631[2]);
            }

            var8 = 0;
            if(field1631[3] > 0 || field1631[4] > 0) {
               var8 = (field1634[3] + field1634[4]) / (field1631[3] + field1631[4]);
            }

            var27 = 0;
            if(field1631[6] > 0 || field1631[8] > 0) {
               var27 = (field1634[8] + field1634[6]) / (field1631[8] + field1631[6]);
            }

            var11 = 0;
            var12 = field1631[10];
            int[] var30 = field1661[10];
            int[] var31 = field1662;
            if(var11 == var12) {
               var11 = 0;
               var12 = field1631[11];
               var30 = field1661[11];
               var31 = field1663;
            }

            if(var11 < var12) {
               var10 = var31[var11];
            } else {
               var10 = -1000;
            }

            for(var15 = 0; var15 < 10; ++var15) {
               while(var15 == 0 && var10 > var7) {
                  this.method2742(var30[var11++]);
                  if(var11 == var12 && var30 != field1661[11]) {
                     var11 = 0;
                     var12 = field1631[11];
                     var30 = field1661[11];
                     var31 = field1663;
                  }

                  if(var11 < var12) {
                     var10 = var31[var11];
                  } else {
                     var10 = -1000;
                  }
               }

               while(var15 == 3 && var10 > var8) {
                  this.method2742(var30[var11++]);
                  if(var11 == var12 && var30 != field1661[11]) {
                     var11 = 0;
                     var12 = field1631[11];
                     var30 = field1661[11];
                     var31 = field1663;
                  }

                  if(var11 < var12) {
                     var10 = var31[var11];
                  } else {
                     var10 = -1000;
                  }
               }

               while(var15 == 5 && var10 > var27) {
                  this.method2742(var30[var11++]);
                  if(var11 == var12 && var30 != field1661[11]) {
                     var11 = 0;
                     var12 = field1631[11];
                     var30 = field1661[11];
                     var31 = field1663;
                  }

                  if(var11 < var12) {
                     var10 = var31[var11];
                  } else {
                     var10 = -1000;
                  }
               }

               var16 = field1631[var15];
               int[] var32 = field1661[var15];

               for(var18 = 0; var18 < var16; ++var18) {
                  this.method2742(var32[var18]);
               }
            }

            while(var10 != -1000) {
               this.method2742(var30[var11++]);
               if(var11 == var12 && var30 != field1661[11]) {
                  var11 = 0;
                  var30 = field1661[11];
                  var12 = field1631[11];
                  var31 = field1663;
               }

               if(var11 < var12) {
                  var10 = var31[var11];
               } else {
                  var10 = -1000;
               }
            }

         }
      }
   }

   @ObfuscatedName("ad")
   final void method2742(int var1) {
      if(field1650[var1]) {
         this.method2743(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         Graphics3D.rasterClipEnable = field1610[var1];
         if(this.field1629 == null) {
            Graphics3D.rasterAlpha = 0;
         } else {
            Graphics3D.rasterAlpha = this.field1629[var1] & 255;
         }

         if(this.field1628 != null && this.field1628[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1627 != null && this.field1627[var1] != -1) {
               int var8 = this.field1627[var1] & 255;
               var5 = this.field1635[var8];
               var6 = this.field1632[var8];
               var7 = this.field1633[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1626[var1] == -1) {
               Graphics3D.rasterTextureAffine(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], this.field1622[var1], this.field1622[var1], this.field1622[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1655[var5], field1655[var6], field1655[var7], field1656[var5], field1656[var6], field1656[var7], this.field1628[var1]);
            } else {
               Graphics3D.rasterTextureAffine(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], this.field1622[var1], this.field1671[var1], this.field1626[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1655[var5], field1655[var6], field1655[var7], field1656[var5], field1656[var6], field1656[var7], this.field1628[var1]);
            }
         } else if(this.field1626[var1] == -1) {
            Graphics3D.rasterFlat(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], field1676[this.field1622[var1]]);
         } else {
            Graphics3D.rasterGouraud(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], this.field1622[var1], this.field1671[var1], this.field1626[var1]);
         }

      }
   }

   @ObfuscatedName("ac")
   final void method2743(int var1) {
      int var2 = Graphics3D.centerX;
      int var3 = Graphics3D.centerY;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1656[var5];
      int var9 = field1656[var6];
      int var10 = field1656[var7];
      if(this.field1629 == null) {
         Graphics3D.rasterAlpha = 0;
      } else {
         Graphics3D.rasterAlpha = this.field1629[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1665[var4] = modelViewportYs[var5];
         field1666[var4] = modelViewportXs[var5];
         xViewportBuffer[var4++] = this.field1622[var1];
      } else {
         var11 = yViewportBuffer[var5];
         var12 = field1655[var5];
         var13 = this.field1622[var1];
         if(var10 >= 50) {
            var14 = field1677[var10 - var8] * (50 - var8);
            field1665[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) / 50;
            field1666[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1655[var7] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1626[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = field1677[var9 - var8] * (50 - var8);
            field1665[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) / 50;
            field1666[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1655[var6] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1671[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1665[var4] = modelViewportYs[var6];
         field1666[var4] = modelViewportXs[var6];
         xViewportBuffer[var4++] = this.field1671[var1];
      } else {
         var11 = yViewportBuffer[var6];
         var12 = field1655[var6];
         var13 = this.field1671[var1];
         if(var8 >= 50) {
            var14 = field1677[var8 - var9] * (50 - var9);
            field1665[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) / 50;
            field1666[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1655[var5] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1622[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = field1677[var10 - var9] * (50 - var9);
            field1665[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) / 50;
            field1666[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1655[var7] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1626[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1665[var4] = modelViewportYs[var7];
         field1666[var4] = modelViewportXs[var7];
         xViewportBuffer[var4++] = this.field1626[var1];
      } else {
         var11 = yViewportBuffer[var7];
         var12 = field1655[var7];
         var13 = this.field1626[var1];
         if(var9 >= 50) {
            var14 = field1677[var9 - var10] * (50 - var10);
            field1665[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) / 50;
            field1666[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1655[var6] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1671[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = field1677[var8 - var10] * (50 - var10);
            field1665[var4] = var2 + Graphics3D.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) / 50;
            field1666[var4] = var3 + Graphics3D.Rasterizer3D_zoom * (var12 + ((field1655[var5] - var12) * var14 >> 16)) / 50;
            xViewportBuffer[var4++] = var13 + ((this.field1622[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1665[0];
      var12 = field1665[1];
      var13 = field1665[2];
      var14 = field1666[0];
      int var15 = field1666[1];
      int var16 = field1666[2];
      Graphics3D.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX) {
            Graphics3D.rasterClipEnable = true;
         }

         if(this.field1628 != null && this.field1628[var1] != -1) {
            if(this.field1627 != null && this.field1627[var1] != -1) {
               var20 = this.field1627[var1] & 255;
               var17 = this.field1635[var20];
               var18 = this.field1632[var20];
               var19 = this.field1633[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1626[var1] == -1) {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1622[var1], this.field1622[var1], this.field1622[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1655[var17], field1655[var18], field1655[var19], field1656[var17], field1656[var18], field1656[var19], this.field1628[var1]);
            } else {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1655[var17], field1655[var18], field1655[var19], field1656[var17], field1656[var18], field1656[var19], this.field1628[var1]);
            }
         } else if(this.field1626[var1] == -1) {
            Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, field1676[this.field1622[var1]]);
         } else {
            Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > Graphics3D.rasterClipX || var12 > Graphics3D.rasterClipX || var13 > Graphics3D.rasterClipX || field1665[3] < 0 || field1665[3] > Graphics3D.rasterClipX) {
            Graphics3D.rasterClipEnable = true;
         }

         if(this.field1628 != null && this.field1628[var1] != -1) {
            if(this.field1627 != null && this.field1627[var1] != -1) {
               var20 = this.field1627[var1] & 255;
               var17 = this.field1635[var20];
               var18 = this.field1632[var20];
               var19 = this.field1633[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1628[var1];
            if(this.field1626[var1] == -1) {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1622[var1], this.field1622[var1], this.field1622[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1655[var17], field1655[var18], field1655[var19], field1656[var17], field1656[var18], field1656[var19], var21);
               Graphics3D.rasterTextureAffine(var14, var16, field1666[3], var11, var13, field1665[3], this.field1622[var1], this.field1622[var1], this.field1622[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1655[var17], field1655[var18], field1655[var19], field1656[var17], field1656[var18], field1656[var19], var21);
            } else {
               Graphics3D.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1655[var17], field1655[var18], field1655[var19], field1656[var17], field1656[var18], field1656[var19], var21);
               Graphics3D.rasterTextureAffine(var14, var16, field1666[3], var11, var13, field1665[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1655[var17], field1655[var18], field1655[var19], field1656[var17], field1656[var18], field1656[var19], var21);
            }
         } else if(this.field1626[var1] == -1) {
            var17 = field1676[this.field1622[var1]];
            Graphics3D.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            Graphics3D.rasterFlat(var14, var16, field1666[3], var11, var13, field1665[3], var17);
         } else {
            Graphics3D.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
            Graphics3D.rasterGouraud(var14, var16, field1666[3], var11, var13, field1665[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3]);
         }
      }

   }

   @ObfuscatedName("cy")
   @Export("draw")
   void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9) {
      field1658[0] = -1;
      if(this.boundsType != 1) {
         this.calculateBoundsCylinder();
      }

      this.method2724(var1);
      int var11 = var5 * var8 - var4 * var6 >> 16;
      int var12 = var2 * var7 + var3 * var11 >> 16;
      int var13 = var3 * this.XYZMag >> 16;
      int var14 = var12 + var13;
      if(var14 > 50 && var12 < 3500) {
         int var15 = var8 * var4 + var5 * var6 >> 16;
         int var16 = (var15 - this.XYZMag) * Graphics3D.Rasterizer3D_zoom;
         if(var16 / var14 < Graphics3D.Rasterizer3D_clipMidX2) {
            int var17 = (var15 + this.XYZMag) * Graphics3D.Rasterizer3D_zoom;
            if(var17 / var14 > Graphics3D.Rasterizer3D_clipNegativeMidX) {
               int var18 = var3 * var7 - var11 * var2 >> 16;
               int var19 = var2 * this.XYZMag >> 16;
               int var20 = (var18 + var19) * Graphics3D.Rasterizer3D_zoom;
               if(var20 / var14 > Graphics3D.Rasterizer3D_clipNegativeMidY) {
                  int var21 = (var3 * super.modelHeight >> 16) + var19;
                  int var22 = (var18 - var21) * Graphics3D.Rasterizer3D_zoom;
                  if(var22 / var14 < Graphics3D.Rasterizer3D_clipMidY2) {
                     int var23 = var13 + (var2 * super.modelHeight >> 16);
                     boolean var24 = false;
                     boolean var25 = false;
                     if(var12 - var23 <= 50) {
                        var25 = true;
                     }

                     boolean var26 = var25 || this.field1630 > 0;
                     int var27 = class120.Viewport_mouseX;
                     int var29 = class155.method3272();
                     boolean var30 = class120.Viewport_containsMouse;
                     boolean var32 = WorldMapType2.method501(var9);
                     boolean var33 = false;
                     int var38;
                     int var39;
                     int var40;
                     int var41;
                     int var42;
                     int var47;
                     int var53;
                     int var54;
                     if(var32 && var30) {
                        boolean var34 = false;
                        if(useBoundingBoxes3D) {
                           boolean var37 = class120.Viewport_containsMouse;
                           boolean var35;
                           if(!var37) {
                              var35 = false;
                           } else {
                              class35.method679();
                              var38 = this.centerX + var6;
                              var39 = var7 + this.centerY;
                              var40 = var8 + this.centerZ;
                              var41 = this.extremeX;
                              var42 = this.extremeY;
                              int var43 = this.extremeZ;
                              int var44 = class120.field1684 - var38;
                              int var45 = class148.field1936 - var39;
                              int var46 = class304.field3737 - var40;
                              if(Math.abs(var44) > var41 + Fonts.field3692) {
                                 var35 = false;
                              } else if(Math.abs(var45) > var42 + Signlink.field1980) {
                                 var35 = false;
                              } else if(Math.abs(var46) > var43 + class120.field1682) {
                                 var35 = false;
                              } else if(Math.abs(var46 * Name.field3662 - var45 * class120.field1685) > var43 * Signlink.field1980 + var42 * class120.field1682) {
                                 var35 = false;
                              } else if(Math.abs(var44 * class120.field1685 - var46 * NPC.field1056) > var41 * class120.field1682 + var43 * Fonts.field3692) {
                                 var35 = false;
                              } else if(Math.abs(var45 * NPC.field1056 - var44 * Name.field3662) > var42 * Fonts.field3692 + var41 * Signlink.field1980) {
                                 var35 = false;
                              } else {
                                 var35 = true;
                              }
                           }

                           var34 = var35;
                        } else {
                           var54 = var12 - var13;
                           if(var54 <= 50) {
                              var54 = 50;
                           }

                           if(var15 > 0) {
                              var16 /= var14;
                              var17 /= var54;
                           } else {
                              var17 /= var14;
                              var16 /= var54;
                           }

                           if(var18 > 0) {
                              var22 /= var14;
                              var20 /= var54;
                           } else {
                              var20 /= var14;
                              var22 /= var54;
                           }

                           var47 = var27 - Graphics3D.centerX;
                           var53 = var29 - Graphics3D.centerY;
                           if(var47 > var16 && var47 < var17 && var53 > var22 && var53 < var20) {
                              var34 = true;
                           }
                        }

                        if(var34) {
                           if(this.field1636) {
                              class120.field1688[++class120.Viewport_entityCountAtMouse - 1] = var9;
                           } else {
                              var33 = true;
                           }
                        }
                     }

                     int var52 = Graphics3D.centerX;
                     var54 = Graphics3D.centerY;
                     var47 = 0;
                     var53 = 0;
                     if(var1 != 0) {
                        var47 = Model_sine[var1];
                        var53 = Model_cosine[var1];
                     }

                     for(var38 = 0; var38 < this.verticesCount; ++var38) {
                        var39 = this.verticesX[var38];
                        var40 = this.verticesY[var38];
                        var41 = this.verticesZ[var38];
                        if(var1 != 0) {
                           var42 = var41 * var47 + var39 * var53 >> 16;
                           var41 = var41 * var53 - var39 * var47 >> 16;
                           var39 = var42;
                        }

                        var39 += var6;
                        var40 += var7;
                        var41 += var8;
                        var42 = var41 * var4 + var5 * var39 >> 16;
                        var41 = var5 * var41 - var39 * var4 >> 16;
                        var39 = var42;
                        var42 = var3 * var40 - var41 * var2 >> 16;
                        var41 = var40 * var2 + var3 * var41 >> 16;
                        field1653[var38] = var41 - var12;
                        if(var41 >= 50) {
                           modelViewportYs[var38] = var39 * Graphics3D.Rasterizer3D_zoom / var41 + var52;
                           modelViewportXs[var38] = var42 * Graphics3D.Rasterizer3D_zoom / var41 + var54;
                        } else {
                           modelViewportYs[var38] = -5000;
                           var24 = true;
                        }

                        if(var26) {
                           yViewportBuffer[var38] = var39;
                           field1655[var38] = var42;
                           field1656[var38] = var41;
                        }
                     }

                     try {
                        this.method2741(var24, var33, this.field1636, var9);
                     } catch (Exception var51) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }
}
