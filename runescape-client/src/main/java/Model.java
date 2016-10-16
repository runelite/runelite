import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("de")
@Implements("Model")
public class Model extends Renderable {
   @ObfuscatedName("bp")
   static int field1838;
   @ObfuscatedName("z")
   static byte[] field1839 = new byte[1];
   @ObfuscatedName("k")
   int field1840 = 0;
   @ObfuscatedName("y")
   static byte[] field1841 = new byte[1];
   @ObfuscatedName("p")
   int field1842 = 0;
   @ObfuscatedName("d")
   int[] field1843;
   @ObfuscatedName("bo")
   static int field1844;
   @ObfuscatedName("c")
   byte field1845 = 0;
   @ObfuscatedName("h")
   @Export("indices1")
   int[] indices1;
   @ObfuscatedName("s")
   static Model field1847 = new Model();
   @ObfuscatedName("r")
   @Export("indices2")
   int[] indices2;
   @ObfuscatedName("g")
   @Export("verticesX")
   int[] verticesX;
   @ObfuscatedName("w")
   @Export("indices3")
   int[] indices3;
   @ObfuscatedName("bh")
   static int field1851;
   @ObfuscatedName("e")
   int[][] field1852;
   @ObfuscatedName("a")
   byte[] field1853;
   @ObfuscatedName("b")
   byte[] field1854;
   @ObfuscatedName("ay")
   static int[] field1855 = new int[12];
   @ObfuscatedName("o")
   short[] field1856;
   @ObfuscatedName("q")
   byte[] field1857;
   @ObfuscatedName("u")
   int[] field1858;
   @ObfuscatedName("x")
   int[] field1859;
   @ObfuscatedName("ai")
   static int[] field1860 = new int[1600];
   @ObfuscatedName("as")
   static int[] field1861 = new int[10];
   @ObfuscatedName("v")
   int[] field1862;
   @ObfuscatedName("j")
   int[][] field1863;
   @ObfuscatedName("ae")
   public boolean field1864 = false;
   @ObfuscatedName("ah")
   int field1865;
   @ObfuscatedName("am")
   int field1866;
   @ObfuscatedName("aa")
   int field1867;
   @ObfuscatedName("ax")
   int field1868;
   @ObfuscatedName("ac")
   int field1869;
   @ObfuscatedName("an")
   static boolean[] field1871 = new boolean[4700];
   @ObfuscatedName("ag")
   static boolean[] field1872 = new boolean[4700];
   @ObfuscatedName("ab")
   static int[] field1873 = new int[4700];
   @ObfuscatedName("aq")
   static int[] field1874 = new int[10];
   @ObfuscatedName("av")
   static int[] field1875 = new int[4700];
   @ObfuscatedName("ap")
   static int[] field1876 = new int[4700];
   @ObfuscatedName("au")
   static int[] field1877 = new int[4700];
   @ObfuscatedName("f")
   @Export("verticesZ")
   int[] verticesZ;
   @ObfuscatedName("bw")
   public static int field1880 = 0;
   @ObfuscatedName("az")
   static int[][] field1881 = new int[1600][512];
   @ObfuscatedName("l")
   int[] field1882;
   @ObfuscatedName("at")
   static int[][] field1883 = new int[12][2000];
   @ObfuscatedName("al")
   static int[] field1884 = new int[2000];
   @ObfuscatedName("aw")
   static int[] field1885 = new int[2000];
   @ObfuscatedName("ak")
   static int[] field1886 = new int[12];
   @ObfuscatedName("ao")
   static int[] field1887 = new int[4700];
   @ObfuscatedName("m")
   @Export("verticesY")
   int[] verticesY;
   @ObfuscatedName("af")
   static int[] field1889 = new int[10];
   @ObfuscatedName("i")
   int field1890 = 0;
   @ObfuscatedName("bx")
   static int[] field1891;
   @ObfuscatedName("ad")
   static int[] field1892 = new int[4700];
   @ObfuscatedName("bg")
   public static boolean field1893 = false;
   @ObfuscatedName("bk")
   public static int field1894 = 0;
   @ObfuscatedName("t")
   static Model field1895 = new Model();
   @ObfuscatedName("bj")
   public static int field1896 = 0;
   @ObfuscatedName("be")
   public static int[] field1897 = new int[1000];
   @ObfuscatedName("br")
   static int[] field1898;
   @ObfuscatedName("n")
   int[] field1899;
   @ObfuscatedName("bm")
   static int[] field1900;
   @ObfuscatedName("bb")
   static int[] field1901;

   public Model(Model[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1842 = 0;
      this.field1840 = 0;
      this.field1890 = 0;
      this.field1845 = -1;

      int var7;
      Model var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1842 += var8.field1842;
            this.field1840 += var8.field1840;
            this.field1890 += var8.field1890;
            if(var8.field1853 != null) {
               var3 = true;
            } else {
               if(this.field1845 == -1) {
                  this.field1845 = var8.field1845;
               }

               if(this.field1845 != var8.field1845) {
                  var3 = true;
               }
            }

            var4 |= var8.field1854 != null;
            var5 |= var8.field1856 != null;
            var6 |= var8.field1857 != null;
         }
      }

      this.verticesX = new int[this.field1842];
      this.verticesY = new int[this.field1842];
      this.verticesZ = new int[this.field1842];
      this.indices1 = new int[this.field1840];
      this.indices2 = new int[this.field1840];
      this.indices3 = new int[this.field1840];
      this.field1858 = new int[this.field1840];
      this.field1899 = new int[this.field1840];
      this.field1843 = new int[this.field1840];
      if(var3) {
         this.field1853 = new byte[this.field1840];
      }

      if(var4) {
         this.field1854 = new byte[this.field1840];
      }

      if(var5) {
         this.field1856 = new short[this.field1840];
      }

      if(var6) {
         this.field1857 = new byte[this.field1840];
      }

      if(this.field1890 > 0) {
         this.field1859 = new int[this.field1890];
         this.field1862 = new int[this.field1890];
         this.field1882 = new int[this.field1890];
      }

      this.field1842 = 0;
      this.field1840 = 0;
      this.field1890 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1840; ++var9) {
               this.indices1[this.field1840] = var8.indices1[var9] + this.field1842;
               this.indices2[this.field1840] = var8.indices2[var9] + this.field1842;
               this.indices3[this.field1840] = var8.indices3[var9] + this.field1842;
               this.field1858[this.field1840] = var8.field1858[var9];
               this.field1899[this.field1840] = var8.field1899[var9];
               this.field1843[this.field1840] = var8.field1843[var9];
               if(var3) {
                  if(var8.field1853 != null) {
                     this.field1853[this.field1840] = var8.field1853[var9];
                  } else {
                     this.field1853[this.field1840] = var8.field1845;
                  }
               }

               if(var4 && var8.field1854 != null) {
                  this.field1854[this.field1840] = var8.field1854[var9];
               }

               if(var5) {
                  if(var8.field1856 != null) {
                     this.field1856[this.field1840] = var8.field1856[var9];
                  } else {
                     this.field1856[this.field1840] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1857 != null && var8.field1857[var9] != -1) {
                     this.field1857[this.field1840] = (byte)(var8.field1857[var9] + this.field1890);
                  } else {
                     this.field1857[this.field1840] = -1;
                  }
               }

               ++this.field1840;
            }

            for(var9 = 0; var9 < var8.field1890; ++var9) {
               this.field1859[this.field1890] = var8.field1859[var9] + this.field1842;
               this.field1862[this.field1890] = var8.field1862[var9] + this.field1842;
               this.field1882[this.field1890] = var8.field1882[var9] + this.field1842;
               ++this.field1890;
            }

            for(var9 = 0; var9 < var8.field1842; ++var9) {
               this.verticesX[this.field1842] = var8.verticesX[var9];
               this.verticesY[this.field1842] = var8.verticesY[var9];
               this.verticesZ[this.field1842] = var8.verticesZ[var9];
               ++this.field1842;
            }
         }
      }

   }

   @ObfuscatedName("z")
   public Model method2272(boolean var1) {
      if(!var1 && field1839.length < this.field1840) {
         field1839 = new byte[this.field1840 + 100];
      }

      return this.method2326(var1, field1847, field1839);
   }

   @ObfuscatedName("g")
   public void method2275() {
      if(this.field1865 != 1) {
         this.field1865 = 1;
         super.modelHeight = 0;
         this.field1866 = 0;
         this.field1867 = 0;

         for(int var1 = 0; var1 < this.field1842; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1866) {
               this.field1866 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1867) {
               this.field1867 = var5;
            }
         }

         this.field1867 = (int)(Math.sqrt((double)this.field1867) + 0.99D);
         this.field1869 = (int)(Math.sqrt((double)(this.field1867 * this.field1867 + super.modelHeight * super.modelHeight)) + 0.99D);
         this.field1868 = this.field1869 + (int)(Math.sqrt((double)(this.field1867 * this.field1867 + this.field1866 * this.field1866)) + 0.99D);
      }
   }

   @ObfuscatedName("m")
   void method2276() {
      if(this.field1865 != 2) {
         this.field1865 = 2;
         this.field1867 = 0;

         for(int var1 = 0; var1 < this.field1842; ++var1) {
            int var2 = this.verticesX[var1];
            int var3 = this.verticesY[var1];
            int var4 = this.verticesZ[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1867) {
               this.field1867 = var5;
            }
         }

         this.field1867 = (int)(Math.sqrt((double)this.field1867) + 0.99D);
         this.field1869 = this.field1867;
         this.field1868 = this.field1867 + this.field1867;
      }
   }

   @ObfuscatedName("r")
   void method2277(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1838 = 0;
         field1851 = 0;
         field1844 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var18 = var2[var8];
            if(var18 < this.field1852.length) {
               int[] var19 = this.field1852[var18];

               for(var11 = 0; var11 < var19.length; ++var11) {
                  var12 = var19[var11];
                  field1838 += this.verticesX[var12];
                  field1851 += this.verticesY[var12];
                  field1844 += this.verticesZ[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1838 = field1838 / var7 + var3;
            field1851 = field1851 / var7 + var4;
            field1844 = field1844 / var7 + var5;
         } else {
            field1838 = var3;
            field1851 = var4;
            field1844 = var5;
         }

      } else {
         int[] var9;
         int var10;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1852.length) {
                  var9 = this.field1852[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.verticesX[var11] += var3;
                     this.verticesY[var11] += var4;
                     this.verticesZ[var11] += var5;
                  }
               }
            }

         } else if(var1 == 2) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1852.length) {
                  var9 = this.field1852[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.verticesX[var11] -= field1838;
                     this.verticesY[var11] -= field1851;
                     this.verticesZ[var11] -= field1844;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1898[var14];
                        var16 = field1891[var14];
                        var17 = this.verticesY[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesY[var11] = this.verticesY[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1898[var12];
                        var16 = field1891[var12];
                        var17 = this.verticesY[var11] * var16 - this.verticesZ[var11] * var15 >> 16;
                        this.verticesZ[var11] = this.verticesY[var11] * var15 + this.verticesZ[var11] * var16 >> 16;
                        this.verticesY[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1898[var13];
                        var16 = field1891[var13];
                        var17 = this.verticesZ[var11] * var15 + this.verticesX[var11] * var16 >> 16;
                        this.verticesZ[var11] = this.verticesZ[var11] * var16 - this.verticesX[var11] * var15 >> 16;
                        this.verticesX[var11] = var17;
                     }

                     this.verticesX[var11] += field1838;
                     this.verticesY[var11] += field1851;
                     this.verticesZ[var11] += field1844;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1852.length) {
                  var9 = this.field1852[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.verticesX[var11] -= field1838;
                     this.verticesY[var11] -= field1851;
                     this.verticesZ[var11] -= field1844;
                     this.verticesX[var11] = this.verticesX[var11] * var3 / 128;
                     this.verticesY[var11] = this.verticesY[var11] * var4 / 128;
                     this.verticesZ[var11] = this.verticesZ[var11] * var5 / 128;
                     this.verticesX[var11] += field1838;
                     this.verticesY[var11] += field1851;
                     this.verticesZ[var11] += field1844;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1863 != null && this.field1854 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1863.length) {
                     var9 = this.field1863[var8];

                     for(var10 = 0; var10 < var9.length; ++var10) {
                        var11 = var9[var10];
                        var12 = (this.field1854[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1854[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("b")
   public void method2280(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1842; ++var4) {
         this.verticesX[var4] += var1;
         this.verticesY[var4] += var2;
         this.verticesZ[var4] += var3;
      }

      this.field1865 = 0;
   }

   @ObfuscatedName("c")
   public final void method2281(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1860[0] = -1;
      if(this.field1865 != 2 && this.field1865 != 1) {
         this.method2276();
      }

      int var9 = class94.field1618;
      int var10 = class94.field1619;
      int var10000 = field1898[var1];
      var10000 = field1891[var1];
      int var13 = field1898[var2];
      int var14 = field1891[var2];
      int var15 = field1898[var3];
      int var16 = field1891[var3];
      int var17 = field1898[var4];
      int var18 = field1891[var4];
      int var19 = var6 * var17 + var7 * var18 >> 16;

      for(int var20 = 0; var20 < this.field1842; ++var20) {
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
         field1875[var20] = var23 - var19;
         field1873[var20] = var9 + var21 * class94.field1608 / var8;
         field1887[var20] = var10 + var24 * class94.field1608 / var8;
         if(this.field1890 > 0) {
            field1876[var20] = var21;
            field1877[var20] = var24;
            field1892[var20] = var23;
         }
      }

      try {
         this.method2290(false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("u")
   public void method2282() {
      for(int var1 = 0; var1 < this.field1842; ++var1) {
         this.verticesX[var1] = -this.verticesX[var1];
         this.verticesZ[var1] = -this.verticesZ[var1];
      }

      this.field1865 = 0;
   }

   @ObfuscatedName("n")
   public void method2283() {
      for(int var1 = 0; var1 < this.field1842; ++var1) {
         int var2 = this.verticesZ[var1];
         this.verticesZ[var1] = this.verticesX[var1];
         this.verticesX[var1] = -var2;
      }

      this.field1865 = 0;
   }

   @ObfuscatedName("a")
   public void method2284(int var1) {
      int var2 = field1898[var1];
      int var3 = field1891[var1];

      for(int var4 = 0; var4 < this.field1842; ++var4) {
         int var5 = this.verticesY[var4] * var3 - this.verticesZ[var4] * var2 >> 16;
         this.verticesZ[var4] = this.verticesY[var4] * var2 + this.verticesZ[var4] * var3 >> 16;
         this.verticesY[var4] = var5;
      }

      this.field1865 = 0;
   }

   @ObfuscatedName("o")
   public final void method2287(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1860[0] = -1;
      if(this.field1865 != 2 && this.field1865 != 1) {
         this.method2276();
      }

      int var8 = class94.field1618;
      int var9 = class94.field1619;
      int var10000 = field1898[var1];
      var10000 = field1891[var1];
      int var12 = field1898[var2];
      int var13 = field1891[var2];
      int var14 = field1898[var3];
      int var15 = field1891[var3];
      int var16 = field1898[var4];
      int var17 = field1891[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1842; ++var19) {
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
         field1875[var19] = var22 - var18;
         field1873[var19] = var8 + var20 * class94.field1608 / var22;
         field1887[var19] = var9 + var23 * class94.field1608 / var22;
         if(this.field1890 > 0) {
            field1876[var19] = var20;
            field1877[var19] = var23;
            field1892[var19] = var22;
         }
      }

      try {
         this.method2290(false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("k")
   public void method2288(Frames var1, int var2) {
      if(this.field1852 != null) {
         if(var2 != -1) {
            Frame var3 = var1.field1814[var2];
            FrameMap var4 = var3.field1581;
            field1838 = 0;
            field1851 = 0;
            field1844 = 0;

            for(int var5 = 0; var5 < var3.field1584; ++var5) {
               int var6 = var3.field1583[var5];
               this.method2277(var4.field1804[var6], var4.field1805[var6], var3.field1586[var5], var3.field1587[var5], var3.field1585[var5]);
            }

            this.field1865 = 0;
         }
      }
   }

   @ObfuscatedName("ab")
   void vmethod2289(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1860[0] = -1;
      if(this.field1865 != 1) {
         this.method2275();
      }

      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1867 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1867) * class94.field1608;
         if(var15 / var13 < class94.field1623) {
            int var16 = (var14 + this.field1867) * class94.field1608;
            if(var16 / var13 > class94.field1622) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1867 * var2 >> 16;
               int var19 = (var17 + var18) * class94.field1608;
               if(var19 / var13 > class94.field1624) {
                  int var20 = var18 + (super.modelHeight * var3 >> 16);
                  int var21 = (var17 - var20) * class94.field1608;
                  if(var21 / var13 < class94.field1612) {
                     int var22 = var12 + (super.modelHeight * var2 >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1890 > 0;
                     boolean var26 = false;
                     int var27;
                     int var28;
                     int var29;
                     if(var9 > 0 && field1893) {
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

                        var28 = field1894 - class94.field1618;
                        var29 = field1880 - class94.field1619;
                        if(var28 > var15 && var28 < var16 && var29 > var21 && var29 < var19) {
                           if(this.field1864) {
                              field1897[field1896++] = var9;
                           } else {
                              var26 = true;
                           }
                        }
                     }

                     var27 = class94.field1618;
                     var28 = class94.field1619;
                     var29 = 0;
                     int var30 = 0;
                     if(var1 != 0) {
                        var29 = field1898[var1];
                        var30 = field1891[var1];
                     }

                     for(int var31 = 0; var31 < this.field1842; ++var31) {
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
                        field1875[var31] = var34 - var11;
                        if(var34 >= 50) {
                           field1873[var31] = var27 + var32 * class94.field1608 / var34;
                           field1887[var31] = var28 + var35 * class94.field1608 / var34;
                        } else {
                           field1873[var31] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1876[var31] = var32;
                           field1877[var31] = var35;
                           field1892[var31] = var34;
                        }
                     }

                     try {
                        this.method2290(var23, var26, var9);
                     } catch (Exception var37) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("i")
   final void method2290(boolean var1, boolean var2, int var3) {
      if(this.field1868 < 1600) {
         int var4;
         for(var4 = 0; var4 < this.field1868; ++var4) {
            field1860[var4] = 0;
         }

         int var5;
         int var7;
         int var8;
         int var9;
         int var10;
         int var12;
         int var13;
         int var15;
         int var24;
         for(var4 = 0; var4 < this.field1840; ++var4) {
            if(this.field1843[var4] != -2) {
               var5 = this.indices1[var4];
               var24 = this.indices2[var4];
               var7 = this.indices3[var4];
               var8 = field1873[var5];
               var9 = field1873[var24];
               var10 = field1873[var7];
               int var25;
               if(var1 && (var8 == -5000 || var9 == -5000 || var10 == -5000)) {
                  var25 = field1876[var5];
                  var12 = field1876[var24];
                  var13 = field1876[var7];
                  int var14 = field1877[var5];
                  var15 = field1877[var24];
                  int var16 = field1877[var7];
                  int var17 = field1892[var5];
                  int var18 = field1892[var24];
                  int var19 = field1892[var7];
                  var25 -= var12;
                  var13 -= var12;
                  var14 -= var15;
                  var16 -= var15;
                  var17 -= var18;
                  var19 -= var18;
                  int var20 = var14 * var19 - var17 * var16;
                  int var21 = var17 * var13 - var25 * var19;
                  int var22 = var25 * var16 - var14 * var13;
                  if(var12 * var20 + var15 * var21 + var18 * var22 > 0) {
                     field1872[var4] = true;
                     int var23 = (field1875[var5] + field1875[var24] + field1875[var7]) / 3 + this.field1869;
                     field1881[var23][field1860[var23]++] = var4;
                  }
               } else {
                  if(var2 && this.method2293(field1894, field1880, field1887[var5], field1887[var24], field1887[var7], var8, var9, var10)) {
                     field1897[field1896++] = var3;
                     var2 = false;
                  }

                  if((var8 - var9) * (field1887[var7] - field1887[var24]) - (field1887[var5] - field1887[var24]) * (var10 - var9) > 0) {
                     field1872[var4] = false;
                     if(var8 >= 0 && var9 >= 0 && var10 >= 0 && var8 <= class94.rasterClipX && var9 <= class94.rasterClipX && var10 <= class94.rasterClipX) {
                        field1871[var4] = false;
                     } else {
                        field1871[var4] = true;
                     }

                     var25 = (field1875[var5] + field1875[var24] + field1875[var7]) / 3 + this.field1869;
                     field1881[var25][field1860[var25]++] = var4;
                  }
               }
            }
         }

         int[] var6;
         if(this.field1853 == null) {
            for(var4 = this.field1868 - 1; var4 >= 0; --var4) {
               var5 = field1860[var4];
               if(var5 > 0) {
                  var6 = field1881[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     this.method2291(var6[var7]);
                  }
               }
            }

         } else {
            for(var4 = 0; var4 < 12; ++var4) {
               field1855[var4] = 0;
               field1886[var4] = 0;
            }

            for(var4 = this.field1868 - 1; var4 >= 0; --var4) {
               var5 = field1860[var4];
               if(var5 > 0) {
                  var6 = field1881[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     var8 = var6[var7];
                     byte var28 = this.field1853[var8];
                     var10 = field1855[var28]++;
                     field1883[var28][var10] = var8;
                     if(var28 < 10) {
                        field1886[var28] += var4;
                     } else if(var28 == 10) {
                        field1884[var10] = var4;
                     } else {
                        field1885[var10] = var4;
                     }
                  }
               }
            }

            var4 = 0;
            if(field1855[1] > 0 || field1855[2] > 0) {
               var4 = (field1886[1] + field1886[2]) / (field1855[1] + field1855[2]);
            }

            var5 = 0;
            if(field1855[3] > 0 || field1855[4] > 0) {
               var5 = (field1886[3] + field1886[4]) / (field1855[3] + field1855[4]);
            }

            var24 = 0;
            if(field1855[6] > 0 || field1855[8] > 0) {
               var24 = (field1886[6] + field1886[8]) / (field1855[6] + field1855[8]);
            }

            var8 = 0;
            var9 = field1855[10];
            int[] var26 = field1883[10];
            int[] var11 = field1884;
            if(var8 == var9) {
               var8 = 0;
               var9 = field1855[11];
               var26 = field1883[11];
               var11 = field1885;
            }

            if(var8 < var9) {
               var7 = var11[var8];
            } else {
               var7 = -1000;
            }

            for(var12 = 0; var12 < 10; ++var12) {
               while(var12 == 0 && var7 > var4) {
                  this.method2291(var26[var8++]);
                  if(var8 == var9 && var26 != field1883[11]) {
                     var8 = 0;
                     var9 = field1855[11];
                     var26 = field1883[11];
                     var11 = field1885;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 3 && var7 > var5) {
                  this.method2291(var26[var8++]);
                  if(var8 == var9 && var26 != field1883[11]) {
                     var8 = 0;
                     var9 = field1855[11];
                     var26 = field1883[11];
                     var11 = field1885;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 5 && var7 > var24) {
                  this.method2291(var26[var8++]);
                  if(var8 == var9 && var26 != field1883[11]) {
                     var8 = 0;
                     var9 = field1855[11];
                     var26 = field1883[11];
                     var11 = field1885;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               var13 = field1855[var12];
               int[] var27 = field1883[var12];

               for(var15 = 0; var15 < var13; ++var15) {
                  this.method2291(var27[var15]);
               }
            }

            while(var7 != -1000) {
               this.method2291(var26[var8++]);
               if(var8 == var9 && var26 != field1883[11]) {
                  var8 = 0;
                  var26 = field1883[11];
                  var9 = field1855[11];
                  var11 = field1885;
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

   @ObfuscatedName("x")
   final void method2291(int var1) {
      if(field1872[var1]) {
         this.method2346(var1);
      } else {
         int var2 = this.indices1[var1];
         int var3 = this.indices2[var1];
         int var4 = this.indices3[var1];
         class94.rasterClipEnable = field1871[var1];
         if(this.field1854 == null) {
            class94.rasterAlpha = 0;
         } else {
            class94.rasterAlpha = this.field1854[var1] & 255;
         }

         if(this.field1856 != null && this.field1856[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1857 != null && this.field1857[var1] != -1) {
               int var8 = this.field1857[var1] & 255;
               var5 = this.field1859[var8];
               var6 = this.field1862[var8];
               var7 = this.field1882[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1843[var1] == -1) {
               class94.rasterTextureAffine(field1887[var2], field1887[var3], field1887[var4], field1873[var2], field1873[var3], field1873[var4], this.field1858[var1], this.field1858[var1], this.field1858[var1], field1876[var5], field1876[var6], field1876[var7], field1877[var5], field1877[var6], field1877[var7], field1892[var5], field1892[var6], field1892[var7], this.field1856[var1]);
            } else {
               class94.rasterTextureAffine(field1887[var2], field1887[var3], field1887[var4], field1873[var2], field1873[var3], field1873[var4], this.field1858[var1], this.field1899[var1], this.field1843[var1], field1876[var5], field1876[var6], field1876[var7], field1877[var5], field1877[var6], field1877[var7], field1892[var5], field1892[var6], field1892[var7], this.field1856[var1]);
            }
         } else if(this.field1843[var1] == -1) {
            class94.rasterFlat(field1887[var2], field1887[var3], field1887[var4], field1873[var2], field1873[var3], field1873[var4], field1900[this.field1858[var1]]);
         } else {
            class94.rasterGouraud(field1887[var2], field1887[var3], field1887[var4], field1873[var2], field1873[var3], field1873[var4], this.field1858[var1], this.field1899[var1], this.field1843[var1]);
         }

      }
   }

   @ObfuscatedName("s")
   public Model method2292(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2275();
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
               var11.field1842 = this.field1842;
               var11.field1840 = this.field1840;
               var11.field1890 = this.field1890;
               var11.verticesX = this.verticesX;
               var11.verticesZ = this.verticesZ;
               var11.indices1 = this.indices1;
               var11.indices2 = this.indices2;
               var11.indices3 = this.indices3;
               var11.field1858 = this.field1858;
               var11.field1899 = this.field1899;
               var11.field1843 = this.field1843;
               var11.field1853 = this.field1853;
               var11.field1854 = this.field1854;
               var11.field1857 = this.field1857;
               var11.field1856 = this.field1856;
               var11.field1845 = this.field1845;
               var11.field1859 = this.field1859;
               var11.field1862 = this.field1862;
               var11.field1882 = this.field1882;
               var11.field1852 = this.field1852;
               var11.field1863 = this.field1863;
               var11.field1864 = this.field1864;
               var11.verticesY = new int[var11.field1842];
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
               for(var12 = 0; var12 < var11.field1842; ++var12) {
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
               for(var12 = 0; var12 < var11.field1842; ++var12) {
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

            var11.field1865 = 0;
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("l")
   final boolean method2293(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      return var2 < var3 && var2 < var4 && var2 < var5?false:(var2 > var3 && var2 > var4 && var2 > var5?false:(var1 < var6 && var1 < var7 && var1 < var8?false:var1 <= var6 || var1 <= var7 || var1 <= var8));
   }

   static {
      field1898 = class94.field1631;
      field1891 = class94.field1621;
      field1900 = class94.colorPalette;
      field1901 = class94.field1630;
   }

   @ObfuscatedName("y")
   public Model method2297(boolean var1) {
      if(!var1 && field1841.length < this.field1840) {
         field1841 = new byte[this.field1840 + 100];
      }

      return this.method2326(var1, field1895, field1841);
   }

   Model() {
   }

   @ObfuscatedName("h")
   public void method2321(Frames var1, int var2, Frames var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            Frame var6 = var1.field1814[var2];
            Frame var7 = var3.field1814[var4];
            FrameMap var8 = var6.field1581;
            field1838 = 0;
            field1851 = 0;
            field1844 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1584; ++var11) {
               for(var12 = var6.field1583[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field1804[var12] == 0) {
                  this.method2277(var8.field1804[var12], var8.field1805[var12], var6.field1586[var11], var6.field1587[var11], var6.field1585[var11]);
               }
            }

            field1838 = 0;
            field1851 = 0;
            field1844 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1584; ++var11) {
               for(var12 = var7.field1583[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field1804[var12] == 0) {
                  this.method2277(var8.field1804[var12], var8.field1805[var12], var7.field1586[var11], var7.field1587[var11], var7.field1585[var11]);
               }
            }

            this.field1865 = 0;
         } else {
            this.method2288(var1, var2);
         }
      }
   }

   @ObfuscatedName("p")
   Model method2326(boolean var1, Model var2, byte[] var3) {
      var2.field1842 = this.field1842;
      var2.field1840 = this.field1840;
      var2.field1890 = this.field1890;
      if(var2.verticesX == null || var2.verticesX.length < this.field1842) {
         var2.verticesX = new int[this.field1842 + 100];
         var2.verticesY = new int[this.field1842 + 100];
         var2.verticesZ = new int[this.field1842 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1842; ++var4) {
         var2.verticesX[var4] = this.verticesX[var4];
         var2.verticesY[var4] = this.verticesY[var4];
         var2.verticesZ[var4] = this.verticesZ[var4];
      }

      if(var1) {
         var2.field1854 = this.field1854;
      } else {
         var2.field1854 = var3;
         if(this.field1854 == null) {
            for(var4 = 0; var4 < this.field1840; ++var4) {
               var2.field1854[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1840; ++var4) {
               var2.field1854[var4] = this.field1854[var4];
            }
         }
      }

      var2.indices1 = this.indices1;
      var2.indices2 = this.indices2;
      var2.indices3 = this.indices3;
      var2.field1858 = this.field1858;
      var2.field1899 = this.field1899;
      var2.field1843 = this.field1843;
      var2.field1853 = this.field1853;
      var2.field1857 = this.field1857;
      var2.field1856 = this.field1856;
      var2.field1845 = this.field1845;
      var2.field1859 = this.field1859;
      var2.field1862 = this.field1862;
      var2.field1882 = this.field1882;
      var2.field1852 = this.field1852;
      var2.field1863 = this.field1863;
      var2.field1864 = this.field1864;
      var2.field1865 = 0;
      return var2;
   }

   @ObfuscatedName("w")
   public void method2327() {
      for(int var1 = 0; var1 < this.field1842; ++var1) {
         int var2 = this.verticesX[var1];
         this.verticesX[var1] = this.verticesZ[var1];
         this.verticesZ[var1] = -var2;
      }

      this.field1865 = 0;
   }

   @ObfuscatedName("q")
   public void method2333(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1842; ++var4) {
         this.verticesX[var4] = this.verticesX[var4] * var1 / 128;
         this.verticesY[var4] = this.verticesY[var4] * var2 / 128;
         this.verticesZ[var4] = this.verticesZ[var4] * var3 / 128;
      }

      this.field1865 = 0;
   }

   @ObfuscatedName("v")
   final void method2346(int var1) {
      int var2 = class94.field1618;
      int var3 = class94.field1619;
      int var4 = 0;
      int var5 = this.indices1[var1];
      int var6 = this.indices2[var1];
      int var7 = this.indices3[var1];
      int var8 = field1892[var5];
      int var9 = field1892[var6];
      int var10 = field1892[var7];
      if(this.field1854 == null) {
         class94.rasterAlpha = 0;
      } else {
         class94.rasterAlpha = this.field1854[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1861[var4] = field1873[var5];
         field1874[var4] = field1887[var5];
         field1889[var4++] = this.field1858[var1];
      } else {
         var11 = field1876[var5];
         var12 = field1877[var5];
         var13 = this.field1858[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1901[var10 - var8];
            field1861[var4] = var2 + (var11 + ((field1876[var7] - var11) * var14 >> 16)) * class94.field1608 / 50;
            field1874[var4] = var3 + (var12 + ((field1877[var7] - var12) * var14 >> 16)) * class94.field1608 / 50;
            field1889[var4++] = var13 + ((this.field1843[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1901[var9 - var8];
            field1861[var4] = var2 + (var11 + ((field1876[var6] - var11) * var14 >> 16)) * class94.field1608 / 50;
            field1874[var4] = var3 + (var12 + ((field1877[var6] - var12) * var14 >> 16)) * class94.field1608 / 50;
            field1889[var4++] = var13 + ((this.field1899[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1861[var4] = field1873[var6];
         field1874[var4] = field1887[var6];
         field1889[var4++] = this.field1899[var1];
      } else {
         var11 = field1876[var6];
         var12 = field1877[var6];
         var13 = this.field1899[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1901[var8 - var9];
            field1861[var4] = var2 + (var11 + ((field1876[var5] - var11) * var14 >> 16)) * class94.field1608 / 50;
            field1874[var4] = var3 + (var12 + ((field1877[var5] - var12) * var14 >> 16)) * class94.field1608 / 50;
            field1889[var4++] = var13 + ((this.field1858[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1901[var10 - var9];
            field1861[var4] = var2 + (var11 + ((field1876[var7] - var11) * var14 >> 16)) * class94.field1608 / 50;
            field1874[var4] = var3 + (var12 + ((field1877[var7] - var12) * var14 >> 16)) * class94.field1608 / 50;
            field1889[var4++] = var13 + ((this.field1843[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1861[var4] = field1873[var7];
         field1874[var4] = field1887[var7];
         field1889[var4++] = this.field1843[var1];
      } else {
         var11 = field1876[var7];
         var12 = field1877[var7];
         var13 = this.field1843[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1901[var9 - var10];
            field1861[var4] = var2 + (var11 + ((field1876[var6] - var11) * var14 >> 16)) * class94.field1608 / 50;
            field1874[var4] = var3 + (var12 + ((field1877[var6] - var12) * var14 >> 16)) * class94.field1608 / 50;
            field1889[var4++] = var13 + ((this.field1899[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1901[var8 - var10];
            field1861[var4] = var2 + (var11 + ((field1876[var5] - var11) * var14 >> 16)) * class94.field1608 / 50;
            field1874[var4] = var3 + (var12 + ((field1877[var5] - var12) * var14 >> 16)) * class94.field1608 / 50;
            field1889[var4++] = var13 + ((this.field1858[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1861[0];
      var12 = field1861[1];
      var13 = field1861[2];
      var14 = field1874[0];
      int var15 = field1874[1];
      int var16 = field1874[2];
      class94.rasterClipEnable = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class94.rasterClipX || var12 > class94.rasterClipX || var13 > class94.rasterClipX) {
            class94.rasterClipEnable = true;
         }

         if(this.field1856 != null && this.field1856[var1] != -1) {
            if(this.field1857 != null && this.field1857[var1] != -1) {
               var20 = this.field1857[var1] & 255;
               var17 = this.field1859[var20];
               var18 = this.field1862[var20];
               var19 = this.field1882[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1843[var1] == -1) {
               class94.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1858[var1], this.field1858[var1], this.field1858[var1], field1876[var17], field1876[var18], field1876[var19], field1877[var17], field1877[var18], field1877[var19], field1892[var17], field1892[var18], field1892[var19], this.field1856[var1]);
            } else {
               class94.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1889[0], field1889[1], field1889[2], field1876[var17], field1876[var18], field1876[var19], field1877[var17], field1877[var18], field1877[var19], field1892[var17], field1892[var18], field1892[var19], this.field1856[var1]);
            }
         } else if(this.field1843[var1] == -1) {
            class94.rasterFlat(var14, var15, var16, var11, var12, var13, field1900[this.field1858[var1]]);
         } else {
            class94.rasterGouraud(var14, var15, var16, var11, var12, var13, field1889[0], field1889[1], field1889[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class94.rasterClipX || var12 > class94.rasterClipX || var13 > class94.rasterClipX || field1861[3] < 0 || field1861[3] > class94.rasterClipX) {
            class94.rasterClipEnable = true;
         }

         if(this.field1856 != null && this.field1856[var1] != -1) {
            if(this.field1857 != null && this.field1857[var1] != -1) {
               var20 = this.field1857[var1] & 255;
               var17 = this.field1859[var20];
               var18 = this.field1862[var20];
               var19 = this.field1882[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1856[var1];
            if(this.field1843[var1] == -1) {
               class94.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1858[var1], this.field1858[var1], this.field1858[var1], field1876[var17], field1876[var18], field1876[var19], field1877[var17], field1877[var18], field1877[var19], field1892[var17], field1892[var18], field1892[var19], var21);
               class94.rasterTextureAffine(var14, var16, field1874[3], var11, var13, field1861[3], this.field1858[var1], this.field1858[var1], this.field1858[var1], field1876[var17], field1876[var18], field1876[var19], field1877[var17], field1877[var18], field1877[var19], field1892[var17], field1892[var18], field1892[var19], var21);
            } else {
               class94.rasterTextureAffine(var14, var15, var16, var11, var12, var13, field1889[0], field1889[1], field1889[2], field1876[var17], field1876[var18], field1876[var19], field1877[var17], field1877[var18], field1877[var19], field1892[var17], field1892[var18], field1892[var19], var21);
               class94.rasterTextureAffine(var14, var16, field1874[3], var11, var13, field1861[3], field1889[0], field1889[2], field1889[3], field1876[var17], field1876[var18], field1876[var19], field1877[var17], field1877[var18], field1877[var19], field1892[var17], field1892[var18], field1892[var19], var21);
            }
         } else if(this.field1843[var1] == -1) {
            var17 = field1900[this.field1858[var1]];
            class94.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
            class94.rasterFlat(var14, var16, field1874[3], var11, var13, field1861[3], var17);
         } else {
            class94.rasterGouraud(var14, var15, var16, var11, var12, var13, field1889[0], field1889[1], field1889[2]);
            class94.rasterGouraud(var14, var16, field1874[3], var11, var13, field1861[3], field1889[0], field1889[2], field1889[3]);
         }
      }

   }

   @ObfuscatedName("f")
   public int method2347() {
      this.method2275();
      return this.field1867;
   }
}
