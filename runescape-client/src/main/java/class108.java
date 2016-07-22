import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dg")
@Implements("Model")
public class class108 extends class88 {
   @ObfuscatedName("bx")
   static int field1861;
   @ObfuscatedName("w")
   static byte[] field1862 = new byte[1];
   @ObfuscatedName("bs")
   public static boolean field1863 = false;
   @ObfuscatedName("o")
   static byte[] field1864 = new byte[1];
   @ObfuscatedName("ai")
   int field1865;
   @ObfuscatedName("ab")
   int field1866;
   @ObfuscatedName("j")
   @Export("verticesY")
   int[] field1867;
   @ObfuscatedName("r")
   @Export("verticesZ")
   int[] field1868;
   @ObfuscatedName("x")
   int field1869 = 0;
   @ObfuscatedName("k")
   @Export("indices1")
   int[] field1870;
   @ObfuscatedName("v")
   @Export("indices2")
   int[] field1871;
   @ObfuscatedName("h")
   @Export("indices3")
   int[] field1872;
   @ObfuscatedName("y")
   int[] field1873;
   @ObfuscatedName("ae")
   static int[] field1874 = new int[10];
   @ObfuscatedName("p")
   int[] field1875;
   @ObfuscatedName("s")
   byte[] field1876;
   @ObfuscatedName("f")
   byte[] field1877;
   @ObfuscatedName("i")
   byte[] field1878;
   @ObfuscatedName("g")
   int field1879 = 0;
   @ObfuscatedName("t")
   byte field1880 = 0;
   @ObfuscatedName("az")
   static int[] field1881 = new int[10];
   @ObfuscatedName("m")
   static class108 field1882 = new class108();
   @ObfuscatedName("au")
   static int[] field1883 = new int[2000];
   @ObfuscatedName("q")
   int[] field1884;
   @ObfuscatedName("a")
   int[][] field1885;
   @ObfuscatedName("d")
   short[] field1886;
   @ObfuscatedName("n")
   int[] field1887;
   @ObfuscatedName("an")
   int field1888;
   @ObfuscatedName("ap")
   int field1889;
   @ObfuscatedName("z")
   int[] field1890;
   @ObfuscatedName("b")
   int[][] field1891;
   @ObfuscatedName("ba")
   static int[] field1892;
   @ObfuscatedName("e")
   static class108 field1893 = new class108();
   @ObfuscatedName("ax")
   static boolean[] field1894 = new boolean[4700];
   @ObfuscatedName("ad")
   static boolean[] field1895 = new boolean[4700];
   @ObfuscatedName("av")
   static int[] field1896 = new int[4700];
   @ObfuscatedName("u")
   int[] field1897;
   @ObfuscatedName("af")
   static int[] field1898 = new int[4700];
   @ObfuscatedName("aq")
   static int[] field1899 = new int[4700];
   @ObfuscatedName("aw")
   static int[] field1900 = new int[4700];
   @ObfuscatedName("ay")
   static int[] field1901 = new int[4700];
   @ObfuscatedName("at")
   static int[] field1903 = new int[4700];
   @ObfuscatedName("as")
   static int[][] field1904 = new int[1600][512];
   @ObfuscatedName("ao")
   static int[][] field1905 = new int[12][2000];
   @ObfuscatedName("c")
   int field1906 = 0;
   @ObfuscatedName("bo")
   static int[] field1907;
   @ObfuscatedName("am")
   static int[] field1908 = new int[2000];
   @ObfuscatedName("ag")
   static int[] field1909 = new int[12];
   @ObfuscatedName("bq")
   public static int[] field1910 = new int[1000];
   @ObfuscatedName("ak")
   static int[] field1911 = new int[10];
   @ObfuscatedName("br")
   static int field1913;
   @ObfuscatedName("bi")
   static int field1914;
   @ObfuscatedName("ac")
   static int[] field1915 = new int[12];
   @ObfuscatedName("ar")
   int field1916;
   @ObfuscatedName("bt")
   public static int field1917 = 0;
   @ObfuscatedName("bh")
   public static int field1918 = 0;
   @ObfuscatedName("be")
   public static int field1919 = 0;
   @ObfuscatedName("al")
   static int[] field1920 = new int[1600];
   @ObfuscatedName("l")
   @Export("verticesX")
   int[] field1921;
   @ObfuscatedName("bm")
   static int[] field1922;
   @ObfuscatedName("by")
   static int[] field1923;
   @ObfuscatedName("aj")
   public boolean field1924 = false;

   public class108(class108[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1879 = 0;
      this.field1869 = 0;
      this.field1906 = 0;
      this.field1880 = -1;

      int var7;
      class108 var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1879 += var8.field1879;
            this.field1869 += var8.field1869;
            this.field1906 += var8.field1906;
            if(var8.field1876 != null) {
               var3 = true;
            } else {
               if(this.field1880 == -1) {
                  this.field1880 = var8.field1880;
               }

               if(this.field1880 != var8.field1880) {
                  var3 = true;
               }
            }

            var4 |= var8.field1877 != null;
            var5 |= var8.field1886 != null;
            var6 |= var8.field1878 != null;
         }
      }

      this.field1921 = new int[this.field1879];
      this.field1867 = new int[this.field1879];
      this.field1868 = new int[this.field1879];
      this.field1870 = new int[this.field1869];
      this.field1871 = new int[this.field1869];
      this.field1872 = new int[this.field1869];
      this.field1897 = new int[this.field1869];
      this.field1873 = new int[this.field1869];
      this.field1875 = new int[this.field1869];
      if(var3) {
         this.field1876 = new byte[this.field1869];
      }

      if(var4) {
         this.field1877 = new byte[this.field1869];
      }

      if(var5) {
         this.field1886 = new short[this.field1869];
      }

      if(var6) {
         this.field1878 = new byte[this.field1869];
      }

      if(this.field1906 > 0) {
         this.field1890 = new int[this.field1906];
         this.field1887 = new int[this.field1906];
         this.field1884 = new int[this.field1906];
      }

      this.field1879 = 0;
      this.field1869 = 0;
      this.field1906 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1869; ++var9) {
               this.field1870[this.field1869] = var8.field1870[var9] + this.field1879;
               this.field1871[this.field1869] = var8.field1871[var9] + this.field1879;
               this.field1872[this.field1869] = var8.field1872[var9] + this.field1879;
               this.field1897[this.field1869] = var8.field1897[var9];
               this.field1873[this.field1869] = var8.field1873[var9];
               this.field1875[this.field1869] = var8.field1875[var9];
               if(var3) {
                  if(var8.field1876 != null) {
                     this.field1876[this.field1869] = var8.field1876[var9];
                  } else {
                     this.field1876[this.field1869] = var8.field1880;
                  }
               }

               if(var4 && var8.field1877 != null) {
                  this.field1877[this.field1869] = var8.field1877[var9];
               }

               if(var5) {
                  if(var8.field1886 != null) {
                     this.field1886[this.field1869] = var8.field1886[var9];
                  } else {
                     this.field1886[this.field1869] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1878 != null && var8.field1878[var9] != -1) {
                     this.field1878[this.field1869] = (byte)(var8.field1878[var9] + this.field1906);
                  } else {
                     this.field1878[this.field1869] = -1;
                  }
               }

               ++this.field1869;
            }

            for(var9 = 0; var9 < var8.field1906; ++var9) {
               this.field1890[this.field1906] = var8.field1890[var9] + this.field1879;
               this.field1887[this.field1906] = var8.field1887[var9] + this.field1879;
               this.field1884[this.field1906] = var8.field1884[var9] + this.field1879;
               ++this.field1906;
            }

            for(var9 = 0; var9 < var8.field1879; ++var9) {
               this.field1921[this.field1879] = var8.field1921[var9];
               this.field1867[this.field1879] = var8.field1867[var9];
               this.field1868[this.field1879] = var8.field1868[var9];
               ++this.field1879;
            }
         }
      }

   }

   @ObfuscatedName("m")
   public class108 method2367(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2385();
      int var7 = var2 - this.field1916;
      int var8 = var2 + this.field1916;
      int var9 = var4 - this.field1916;
      int var10 = var4 + this.field1916;
      if(var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
         var7 >>= 7;
         var8 = var8 + 127 >> 7;
         var9 >>= 7;
         var10 = var10 + 127 >> 7;
         if(var1[var7][var9] == var3 && var1[var8][var9] == var3 && var1[var7][var10] == var3 && var1[var8][var10] == var3) {
            return this;
         } else {
            class108 var11;
            if(var5) {
               var11 = new class108();
               var11.field1879 = this.field1879;
               var11.field1869 = this.field1869;
               var11.field1906 = this.field1906;
               var11.field1921 = this.field1921;
               var11.field1868 = this.field1868;
               var11.field1870 = this.field1870;
               var11.field1871 = this.field1871;
               var11.field1872 = this.field1872;
               var11.field1897 = this.field1897;
               var11.field1873 = this.field1873;
               var11.field1875 = this.field1875;
               var11.field1876 = this.field1876;
               var11.field1877 = this.field1877;
               var11.field1878 = this.field1878;
               var11.field1886 = this.field1886;
               var11.field1880 = this.field1880;
               var11.field1890 = this.field1890;
               var11.field1887 = this.field1887;
               var11.field1884 = this.field1884;
               var11.field1885 = this.field1885;
               var11.field1891 = this.field1891;
               var11.field1924 = this.field1924;
               var11.field1867 = new int[var11.field1879];
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
               for(var12 = 0; var12 < var11.field1879; ++var12) {
                  var13 = this.field1921[var12] + var2;
                  var14 = this.field1868[var12] + var4;
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var1[var17 + 1][var18 + 1] * var15 >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.field1867[var12] = this.field1867[var12] + var21 - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1879; ++var12) {
                  var13 = (-this.field1867[var12] << 16) / super.field1536;
                  if(var13 < var6) {
                     var14 = this.field1921[var12] + var2;
                     var15 = this.field1868[var12] + var4;
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var1[var18 + 1][var19 + 1] * var16 >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.field1867[var12] = this.field1867[var12] + (var22 - var3) * (var6 - var13) / var6;
                  }
               }
            }

            var11.field1888 = 0;
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("w")
   public class108 method2368(boolean var1) {
      if(!var1 && field1862.length < this.field1869) {
         field1862 = new byte[this.field1869 + 100];
      }

      return this.method2419(var1, field1882, field1862);
   }

   @ObfuscatedName("o")
   public class108 method2369(boolean var1) {
      if(!var1 && field1864.length < this.field1869) {
         field1864 = new byte[this.field1869 + 100];
      }

      return this.method2419(var1, field1893, field1864);
   }

   @ObfuscatedName("t")
   public void method2372(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1879; ++var4) {
         this.field1921[var4] += var1;
         this.field1867[var4] += var2;
         this.field1868[var4] += var3;
      }

      this.field1888 = 0;
   }

   @ObfuscatedName("r")
   public int method2373() {
      this.method2385();
      return this.field1916;
   }

   class108() {
   }

   @ObfuscatedName("p")
   void method2375(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1913 = 0;
         field1914 = 0;
         field1861 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var9 = var2[var8];
            if(var9 < this.field1885.length) {
               int[] var18 = this.field1885[var9];

               for(var11 = 0; var11 < var18.length; ++var11) {
                  var12 = var18[var11];
                  field1913 += this.field1921[var12];
                  field1914 += this.field1867[var12];
                  field1861 += this.field1868[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1913 = field1913 / var7 + var3;
            field1914 = field1914 / var7 + var4;
            field1861 = field1861 / var7 + var5;
         } else {
            field1913 = var3;
            field1914 = var4;
            field1861 = var5;
         }

      } else {
         int var10;
         int[] var19;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1885.length) {
                  var19 = this.field1885[var8];

                  for(var10 = 0; var10 < var19.length; ++var10) {
                     var11 = var19[var10];
                     this.field1921[var11] += var3;
                     this.field1867[var11] += var4;
                     this.field1868[var11] += var5;
                  }
               }
            }

         } else if(var1 == 2) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1885.length) {
                  var19 = this.field1885[var8];

                  for(var10 = 0; var10 < var19.length; ++var10) {
                     var11 = var19[var10];
                     this.field1921[var11] -= field1913;
                     this.field1867[var11] -= field1914;
                     this.field1868[var11] -= field1861;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1907[var14];
                        var16 = field1922[var14];
                        var17 = this.field1867[var11] * var15 + this.field1921[var11] * var16 >> 16;
                        this.field1867[var11] = this.field1867[var11] * var16 - this.field1921[var11] * var15 >> 16;
                        this.field1921[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1907[var12];
                        var16 = field1922[var12];
                        var17 = this.field1867[var11] * var16 - this.field1868[var11] * var15 >> 16;
                        this.field1868[var11] = this.field1867[var11] * var15 + this.field1868[var11] * var16 >> 16;
                        this.field1867[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1907[var13];
                        var16 = field1922[var13];
                        var17 = this.field1868[var11] * var15 + this.field1921[var11] * var16 >> 16;
                        this.field1868[var11] = this.field1868[var11] * var16 - this.field1921[var11] * var15 >> 16;
                        this.field1921[var11] = var17;
                     }

                     this.field1921[var11] += field1913;
                     this.field1867[var11] += field1914;
                     this.field1868[var11] += field1861;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1885.length) {
                  var19 = this.field1885[var8];

                  for(var10 = 0; var10 < var19.length; ++var10) {
                     var11 = var19[var10];
                     this.field1921[var11] -= field1913;
                     this.field1867[var11] -= field1914;
                     this.field1868[var11] -= field1861;
                     this.field1921[var11] = this.field1921[var11] * var3 / 128;
                     this.field1867[var11] = this.field1867[var11] * var4 / 128;
                     this.field1868[var11] = this.field1868[var11] * var5 / 128;
                     this.field1921[var11] += field1913;
                     this.field1867[var11] += field1914;
                     this.field1868[var11] += field1861;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1891 != null && this.field1877 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1891.length) {
                     var19 = this.field1891[var8];

                     for(var10 = 0; var10 < var19.length; ++var10) {
                        var11 = var19[var10];
                        var12 = (this.field1877[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1877[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("s")
   public void method2376() {
      for(int var1 = 0; var1 < this.field1879; ++var1) {
         int var2 = this.field1921[var1];
         this.field1921[var1] = this.field1868[var1];
         this.field1868[var1] = -var2;
      }

      this.field1888 = 0;
   }

   @ObfuscatedName("f")
   public void method2377() {
      for(int var1 = 0; var1 < this.field1879; ++var1) {
         this.field1921[var1] = -this.field1921[var1];
         this.field1868[var1] = -this.field1868[var1];
      }

      this.field1888 = 0;
   }

   @ObfuscatedName("i")
   public void method2378() {
      for(int var1 = 0; var1 < this.field1879; ++var1) {
         int var2 = this.field1868[var1];
         this.field1868[var1] = this.field1921[var1];
         this.field1921[var1] = -var2;
      }

      this.field1888 = 0;
   }

   @ObfuscatedName("d")
   public void method2379(int var1) {
      int var2 = field1907[var1];
      int var3 = field1922[var1];

      for(int var4 = 0; var4 < this.field1879; ++var4) {
         int var5 = this.field1867[var4] * var3 - this.field1868[var4] * var2 >> 16;
         this.field1868[var4] = this.field1867[var4] * var2 + this.field1868[var4] * var3 >> 16;
         this.field1867[var4] = var5;
      }

      this.field1888 = 0;
   }

   @ObfuscatedName("n")
   public final void method2383(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1920[0] = -1;
      if(this.field1888 != 2 && this.field1888 != 1) {
         this.method2429();
      }

      int var9 = class94.field1649;
      int var10 = class94.field1648;
      int var10000 = field1907[var1];
      var10000 = field1922[var1];
      int var13 = field1907[var2];
      int var14 = field1922[var2];
      int var15 = field1907[var3];
      int var16 = field1922[var3];
      int var17 = field1907[var4];
      int var18 = field1922[var4];
      int var19 = var6 * var17 + var7 * var18 >> 16;

      for(int var20 = 0; var20 < this.field1879; ++var20) {
         int var21 = this.field1921[var20];
         int var22 = this.field1867[var20];
         int var23 = this.field1868[var20];
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
         field1898[var20] = var23 - var19;
         field1896[var20] = var9 + var21 * class94.field1646 / var8;
         field1899[var20] = var10 + var24 * class94.field1646 / var8;
         if(this.field1906 > 0) {
            field1903[var20] = var21;
            field1900[var20] = var24;
            field1901[var20] = var23;
         }
      }

      try {
         this.method2408(false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("ai")
   void vmethod2384(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1920[0] = -1;
      if(this.field1888 != 1) {
         this.method2385();
      }

      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1916 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1916) * class94.field1646;
         if(var15 / var13 < class94.field1652) {
            int var16 = (var14 + this.field1916) * class94.field1646;
            if(var16 / var13 > class94.field1654) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1916 * var2 >> 16;
               int var19 = (var17 + var18) * class94.field1646;
               if(var19 / var13 > class94.field1638) {
                  int var20 = var18 + (super.field1536 * var3 >> 16);
                  int var21 = (var17 - var20) * class94.field1646;
                  if(var21 / var13 < class94.field1640) {
                     int var22 = var12 + (super.field1536 * var2 >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1906 > 0;
                     boolean var26 = false;
                     int var27;
                     int var28;
                     int var29;
                     if(var9 > 0 && field1863) {
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

                        var28 = field1917 - class94.field1649;
                        var29 = field1918 - class94.field1648;
                        if(var28 > var15 && var28 < var16 && var29 > var21 && var29 < var19) {
                           if(this.field1924) {
                              field1910[field1919++] = var9;
                           } else {
                              var26 = true;
                           }
                        }
                     }

                     var27 = class94.field1649;
                     var28 = class94.field1648;
                     var29 = 0;
                     int var30 = 0;
                     if(var1 != 0) {
                        var29 = field1907[var1];
                        var30 = field1922[var1];
                     }

                     for(int var31 = 0; var31 < this.field1879; ++var31) {
                        int var32 = this.field1921[var31];
                        int var33 = this.field1867[var31];
                        int var34 = this.field1868[var31];
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
                        field1898[var31] = var34 - var11;
                        if(var34 >= 50) {
                           field1896[var31] = var27 + var32 * class94.field1646 / var34;
                           field1899[var31] = var28 + var35 * class94.field1646 / var34;
                        } else {
                           field1896[var31] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1903[var31] = var32;
                           field1900[var31] = var35;
                           field1901[var31] = var34;
                        }
                     }

                     try {
                        this.method2408(var23, var26, var9);
                     } catch (Exception var37) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("l")
   public void method2385() {
      if(this.field1888 != 1) {
         this.field1888 = 1;
         super.field1536 = 0;
         this.field1889 = 0;
         this.field1916 = 0;

         for(int var1 = 0; var1 < this.field1879; ++var1) {
            int var2 = this.field1921[var1];
            int var3 = this.field1867[var1];
            int var4 = this.field1868[var1];
            if(-var3 > super.field1536) {
               super.field1536 = -var3;
            }

            if(var3 > this.field1889) {
               this.field1889 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1916) {
               this.field1916 = var5;
            }
         }

         this.field1916 = (int)(Math.sqrt((double)this.field1916) + 0.99D);
         this.field1865 = (int)(Math.sqrt((double)(this.field1916 * this.field1916 + super.field1536 * super.field1536)) + 0.99D);
         this.field1866 = this.field1865 + (int)(Math.sqrt((double)(this.field1916 * this.field1916 + this.field1889 * this.field1889)) + 0.99D);
      }
   }

   @ObfuscatedName("b")
   final void method2387(int var1) {
      int var2 = class94.field1649;
      int var3 = class94.field1648;
      int var4 = 0;
      int var5 = this.field1870[var1];
      int var6 = this.field1871[var1];
      int var7 = this.field1872[var1];
      int var8 = field1901[var5];
      int var9 = field1901[var6];
      int var10 = field1901[var7];
      if(this.field1877 == null) {
         class94.field1641 = 0;
      } else {
         class94.field1641 = this.field1877[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1881[var4] = field1896[var5];
         field1911[var4] = field1899[var5];
         field1874[var4++] = this.field1897[var1];
      } else {
         var11 = field1903[var5];
         var12 = field1900[var5];
         var13 = this.field1897[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1892[var10 - var8];
            field1881[var4] = var2 + (var11 + ((field1903[var7] - var11) * var14 >> 16)) * class94.field1646 / 50;
            field1911[var4] = var3 + (var12 + ((field1900[var7] - var12) * var14 >> 16)) * class94.field1646 / 50;
            field1874[var4++] = var13 + ((this.field1875[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1892[var9 - var8];
            field1881[var4] = var2 + (var11 + ((field1903[var6] - var11) * var14 >> 16)) * class94.field1646 / 50;
            field1911[var4] = var3 + (var12 + ((field1900[var6] - var12) * var14 >> 16)) * class94.field1646 / 50;
            field1874[var4++] = var13 + ((this.field1873[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1881[var4] = field1896[var6];
         field1911[var4] = field1899[var6];
         field1874[var4++] = this.field1873[var1];
      } else {
         var11 = field1903[var6];
         var12 = field1900[var6];
         var13 = this.field1873[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1892[var8 - var9];
            field1881[var4] = var2 + (var11 + ((field1903[var5] - var11) * var14 >> 16)) * class94.field1646 / 50;
            field1911[var4] = var3 + (var12 + ((field1900[var5] - var12) * var14 >> 16)) * class94.field1646 / 50;
            field1874[var4++] = var13 + ((this.field1897[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1892[var10 - var9];
            field1881[var4] = var2 + (var11 + ((field1903[var7] - var11) * var14 >> 16)) * class94.field1646 / 50;
            field1911[var4] = var3 + (var12 + ((field1900[var7] - var12) * var14 >> 16)) * class94.field1646 / 50;
            field1874[var4++] = var13 + ((this.field1875[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1881[var4] = field1896[var7];
         field1911[var4] = field1899[var7];
         field1874[var4++] = this.field1875[var1];
      } else {
         var11 = field1903[var7];
         var12 = field1900[var7];
         var13 = this.field1875[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1892[var9 - var10];
            field1881[var4] = var2 + (var11 + ((field1903[var6] - var11) * var14 >> 16)) * class94.field1646 / 50;
            field1911[var4] = var3 + (var12 + ((field1900[var6] - var12) * var14 >> 16)) * class94.field1646 / 50;
            field1874[var4++] = var13 + ((this.field1873[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1892[var8 - var10];
            field1881[var4] = var2 + (var11 + ((field1903[var5] - var11) * var14 >> 16)) * class94.field1646 / 50;
            field1911[var4] = var3 + (var12 + ((field1900[var5] - var12) * var14 >> 16)) * class94.field1646 / 50;
            field1874[var4++] = var13 + ((this.field1897[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1881[0];
      var12 = field1881[1];
      var13 = field1881[2];
      var14 = field1911[0];
      int var15 = field1911[1];
      int var16 = field1911[2];
      class94.field1639 = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class94.field1642 || var12 > class94.field1642 || var13 > class94.field1642) {
            class94.field1639 = true;
         }

         if(this.field1886 != null && this.field1886[var1] != -1) {
            if(this.field1878 != null && this.field1878[var1] != -1) {
               var20 = this.field1878[var1] & 255;
               var17 = this.field1890[var20];
               var18 = this.field1887[var20];
               var19 = this.field1884[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1875[var1] == -1) {
               class94.method2223(var14, var15, var16, var11, var12, var13, this.field1897[var1], this.field1897[var1], this.field1897[var1], field1903[var17], field1903[var18], field1903[var19], field1900[var17], field1900[var18], field1900[var19], field1901[var17], field1901[var18], field1901[var19], this.field1886[var1]);
            } else {
               class94.method2223(var14, var15, var16, var11, var12, var13, field1874[0], field1874[1], field1874[2], field1903[var17], field1903[var18], field1903[var19], field1900[var17], field1900[var18], field1900[var19], field1901[var17], field1901[var18], field1901[var19], this.field1886[var1]);
            }
         } else if(this.field1875[var1] == -1) {
            class94.method2171(var14, var15, var16, var11, var12, var13, field1923[this.field1897[var1]]);
         } else {
            class94.method2175(var14, var15, var16, var11, var12, var13, field1874[0], field1874[1], field1874[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class94.field1642 || var12 > class94.field1642 || var13 > class94.field1642 || field1881[3] < 0 || field1881[3] > class94.field1642) {
            class94.field1639 = true;
         }

         if(this.field1886 != null && this.field1886[var1] != -1) {
            if(this.field1878 != null && this.field1878[var1] != -1) {
               var20 = this.field1878[var1] & 255;
               var17 = this.field1890[var20];
               var18 = this.field1887[var20];
               var19 = this.field1884[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1886[var1];
            if(this.field1875[var1] == -1) {
               class94.method2223(var14, var15, var16, var11, var12, var13, this.field1897[var1], this.field1897[var1], this.field1897[var1], field1903[var17], field1903[var18], field1903[var19], field1900[var17], field1900[var18], field1900[var19], field1901[var17], field1901[var18], field1901[var19], var21);
               class94.method2223(var14, var16, field1911[3], var11, var13, field1881[3], this.field1897[var1], this.field1897[var1], this.field1897[var1], field1903[var17], field1903[var18], field1903[var19], field1900[var17], field1900[var18], field1900[var19], field1901[var17], field1901[var18], field1901[var19], var21);
            } else {
               class94.method2223(var14, var15, var16, var11, var12, var13, field1874[0], field1874[1], field1874[2], field1903[var17], field1903[var18], field1903[var19], field1900[var17], field1900[var18], field1900[var19], field1901[var17], field1901[var18], field1901[var19], var21);
               class94.method2223(var14, var16, field1911[3], var11, var13, field1881[3], field1874[0], field1874[2], field1874[3], field1903[var17], field1903[var18], field1903[var19], field1900[var17], field1900[var18], field1900[var19], field1901[var17], field1901[var18], field1901[var19], var21);
            }
         } else if(this.field1875[var1] == -1) {
            var17 = field1923[this.field1897[var1]];
            class94.method2171(var14, var15, var16, var11, var12, var13, var17);
            class94.method2171(var14, var16, field1911[3], var11, var13, field1881[3], var17);
         } else {
            class94.method2175(var14, var15, var16, var11, var12, var13, field1874[0], field1874[1], field1874[2]);
            class94.method2175(var14, var16, field1911[3], var11, var13, field1881[3], field1874[0], field1874[2], field1874[3]);
         }
      }

   }

   @ObfuscatedName("aj")
   final boolean method2388(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      return var2 < var3 && var2 < var4 && var2 < var5?false:(var2 > var3 && var2 > var4 && var2 > var5?false:(var1 < var6 && var1 < var7 && var1 < var8?false:var1 <= var6 || var1 <= var7 || var1 <= var8));
   }

   @ObfuscatedName("x")
   public void method2392(class106 var1, int var2) {
      if(this.field1885 != null) {
         if(var2 != -1) {
            class91 var3 = var1.field1841[var2];
            class105 var4 = var3.field1612;
            field1913 = 0;
            field1914 = 0;
            field1861 = 0;

            for(int var5 = 0; var5 < var3.field1617; ++var5) {
               int var6 = var3.field1618[var5];
               this.method2375(var4.field1831[var6], var4.field1832[var6], var3.field1619[var5], var3.field1620[var5], var3.field1622[var5]);
            }

            this.field1888 = 0;
         }
      }
   }

   @ObfuscatedName("c")
   public void method2395(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1879; ++var4) {
         this.field1921[var4] = this.field1921[var4] * var1 / 128;
         this.field1867[var4] = this.field1867[var4] * var2 / 128;
         this.field1868[var4] = this.field1868[var4] * var3 / 128;
      }

      this.field1888 = 0;
   }

   static {
      field1907 = class94.field1660;
      field1922 = class94.field1661;
      field1923 = class94.field1656;
      field1892 = class94.field1659;
   }

   @ObfuscatedName("q")
   final void method2408(boolean var1, boolean var2, int var3) {
      if(this.field1866 < 1600) {
         int var4;
         for(var4 = 0; var4 < this.field1866; ++var4) {
            field1920[var4] = 0;
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
         for(var4 = 0; var4 < this.field1869; ++var4) {
            if(this.field1875[var4] != -2) {
               var5 = this.field1870[var4];
               var6 = this.field1871[var4];
               var7 = this.field1872[var4];
               var8 = field1896[var5];
               var9 = field1896[var6];
               var10 = field1896[var7];
               int var11;
               if(!var1 || var8 != -5000 && var9 != -5000 && var10 != -5000) {
                  if(var2 && this.method2388(field1917, field1918, field1899[var5], field1899[var6], field1899[var7], var8, var9, var10)) {
                     field1910[field1919++] = var3;
                     var2 = false;
                  }

                  if((var8 - var9) * (field1899[var7] - field1899[var6]) - (field1899[var5] - field1899[var6]) * (var10 - var9) > 0) {
                     field1895[var4] = false;
                     if(var8 >= 0 && var9 >= 0 && var10 >= 0 && var8 <= class94.field1642 && var9 <= class94.field1642 && var10 <= class94.field1642) {
                        field1894[var4] = false;
                     } else {
                        field1894[var4] = true;
                     }

                     var11 = (field1898[var5] + field1898[var6] + field1898[var7]) / 3 + this.field1865;
                     field1904[var11][field1920[var11]++] = var4;
                  }
               } else {
                  var11 = field1903[var5];
                  var12 = field1903[var6];
                  var13 = field1903[var7];
                  int var14 = field1900[var5];
                  var15 = field1900[var6];
                  int var16 = field1900[var7];
                  int var17 = field1901[var5];
                  int var18 = field1901[var6];
                  int var19 = field1901[var7];
                  var11 -= var12;
                  var13 -= var12;
                  var14 -= var15;
                  var16 -= var15;
                  var17 -= var18;
                  var19 -= var18;
                  int var20 = var14 * var19 - var17 * var16;
                  int var21 = var17 * var13 - var11 * var19;
                  int var22 = var11 * var16 - var14 * var13;
                  if(var12 * var20 + var15 * var21 + var18 * var22 > 0) {
                     field1895[var4] = true;
                     int var23 = (field1898[var5] + field1898[var6] + field1898[var7]) / 3 + this.field1865;
                     field1904[var23][field1920[var23]++] = var4;
                  }
               }
            }
         }

         int[] var27;
         if(this.field1876 == null) {
            for(var4 = this.field1866 - 1; var4 >= 0; --var4) {
               var5 = field1920[var4];
               if(var5 > 0) {
                  var27 = field1904[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     this.method2430(var27[var7]);
                  }
               }
            }

         } else {
            for(var4 = 0; var4 < 12; ++var4) {
               field1915[var4] = 0;
               field1909[var4] = 0;
            }

            for(var4 = this.field1866 - 1; var4 >= 0; --var4) {
               var5 = field1920[var4];
               if(var5 > 0) {
                  var27 = field1904[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     var8 = var27[var7];
                     byte var28 = this.field1876[var8];
                     var10 = field1915[var28]++;
                     field1905[var28][var10] = var8;
                     if(var28 < 10) {
                        field1909[var28] += var4;
                     } else if(var28 == 10) {
                        field1883[var10] = var4;
                     } else {
                        field1908[var10] = var4;
                     }
                  }
               }
            }

            var4 = 0;
            if(field1915[1] > 0 || field1915[2] > 0) {
               var4 = (field1909[1] + field1909[2]) / (field1915[1] + field1915[2]);
            }

            var5 = 0;
            if(field1915[3] > 0 || field1915[4] > 0) {
               var5 = (field1909[3] + field1909[4]) / (field1915[3] + field1915[4]);
            }

            var6 = 0;
            if(field1915[6] > 0 || field1915[8] > 0) {
               var6 = (field1909[6] + field1909[8]) / (field1915[6] + field1915[8]);
            }

            var8 = 0;
            var9 = field1915[10];
            int[] var24 = field1905[10];
            int[] var25 = field1883;
            if(var8 == var9) {
               var8 = 0;
               var9 = field1915[11];
               var24 = field1905[11];
               var25 = field1908;
            }

            if(var8 < var9) {
               var7 = var25[var8];
            } else {
               var7 = -1000;
            }

            for(var12 = 0; var12 < 10; ++var12) {
               while(var12 == 0 && var7 > var4) {
                  this.method2430(var24[var8++]);
                  if(var8 == var9 && var24 != field1905[11]) {
                     var8 = 0;
                     var9 = field1915[11];
                     var24 = field1905[11];
                     var25 = field1908;
                  }

                  if(var8 < var9) {
                     var7 = var25[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 3 && var7 > var5) {
                  this.method2430(var24[var8++]);
                  if(var8 == var9 && var24 != field1905[11]) {
                     var8 = 0;
                     var9 = field1915[11];
                     var24 = field1905[11];
                     var25 = field1908;
                  }

                  if(var8 < var9) {
                     var7 = var25[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 5 && var7 > var6) {
                  this.method2430(var24[var8++]);
                  if(var8 == var9 && var24 != field1905[11]) {
                     var8 = 0;
                     var9 = field1915[11];
                     var24 = field1905[11];
                     var25 = field1908;
                  }

                  if(var8 < var9) {
                     var7 = var25[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               var13 = field1915[var12];
               int[] var26 = field1905[var12];

               for(var15 = 0; var15 < var13; ++var15) {
                  this.method2430(var26[var15]);
               }
            }

            while(var7 != -1000) {
               this.method2430(var24[var8++]);
               if(var8 == var9 && var24 != field1905[11]) {
                  var8 = 0;
                  var24 = field1905[11];
                  var9 = field1915[11];
                  var25 = field1908;
               }

               if(var8 < var9) {
                  var7 = var25[var8];
               } else {
                  var7 = -1000;
               }
            }

         }
      }
   }

   @ObfuscatedName("y")
   public void method2417(class106 var1, int var2, class106 var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            class91 var6 = var1.field1841[var2];
            class91 var7 = var3.field1841[var4];
            class105 var8 = var6.field1612;
            field1913 = 0;
            field1914 = 0;
            field1861 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1617; ++var11) {
               for(var12 = var6.field1618[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field1831[var12] == 0) {
                  this.method2375(var8.field1831[var12], var8.field1832[var12], var6.field1619[var11], var6.field1620[var11], var6.field1622[var11]);
               }
            }

            field1913 = 0;
            field1914 = 0;
            field1861 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1617; ++var11) {
               for(var12 = var7.field1618[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field1831[var12] == 0) {
                  this.method2375(var8.field1831[var12], var8.field1832[var12], var7.field1619[var11], var7.field1620[var11], var7.field1622[var11]);
               }
            }

            this.field1888 = 0;
         } else {
            this.method2392(var1, var2);
         }
      }
   }

   @ObfuscatedName("g")
   class108 method2419(boolean var1, class108 var2, byte[] var3) {
      var2.field1879 = this.field1879;
      var2.field1869 = this.field1869;
      var2.field1906 = this.field1906;
      if(var2.field1921 == null || var2.field1921.length < this.field1879) {
         var2.field1921 = new int[this.field1879 + 100];
         var2.field1867 = new int[this.field1879 + 100];
         var2.field1868 = new int[this.field1879 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1879; ++var4) {
         var2.field1921[var4] = this.field1921[var4];
         var2.field1867[var4] = this.field1867[var4];
         var2.field1868[var4] = this.field1868[var4];
      }

      if(var1) {
         var2.field1877 = this.field1877;
      } else {
         var2.field1877 = var3;
         if(this.field1877 == null) {
            for(var4 = 0; var4 < this.field1869; ++var4) {
               var2.field1877[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1869; ++var4) {
               var2.field1877[var4] = this.field1877[var4];
            }
         }
      }

      var2.field1870 = this.field1870;
      var2.field1871 = this.field1871;
      var2.field1872 = this.field1872;
      var2.field1897 = this.field1897;
      var2.field1873 = this.field1873;
      var2.field1875 = this.field1875;
      var2.field1876 = this.field1876;
      var2.field1878 = this.field1878;
      var2.field1886 = this.field1886;
      var2.field1880 = this.field1880;
      var2.field1890 = this.field1890;
      var2.field1887 = this.field1887;
      var2.field1884 = this.field1884;
      var2.field1885 = this.field1885;
      var2.field1891 = this.field1891;
      var2.field1924 = this.field1924;
      var2.field1888 = 0;
      return var2;
   }

   @ObfuscatedName("z")
   public final void method2420(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1920[0] = -1;
      if(this.field1888 != 2 && this.field1888 != 1) {
         this.method2429();
      }

      int var8 = class94.field1649;
      int var9 = class94.field1648;
      int var10000 = field1907[var1];
      var10000 = field1922[var1];
      int var12 = field1907[var2];
      int var13 = field1922[var2];
      int var14 = field1907[var3];
      int var15 = field1922[var3];
      int var16 = field1907[var4];
      int var17 = field1922[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1879; ++var19) {
         int var20 = this.field1921[var19];
         int var21 = this.field1867[var19];
         int var22 = this.field1868[var19];
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
         field1898[var19] = var22 - var18;
         field1896[var19] = var8 + var20 * class94.field1646 / var22;
         field1899[var19] = var9 + var23 * class94.field1646 / var22;
         if(this.field1906 > 0) {
            field1903[var19] = var20;
            field1900[var19] = var23;
            field1901[var19] = var22;
         }
      }

      try {
         this.method2408(false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("j")
   void method2429() {
      if(this.field1888 != 2) {
         this.field1888 = 2;
         this.field1916 = 0;

         for(int var1 = 0; var1 < this.field1879; ++var1) {
            int var2 = this.field1921[var1];
            int var3 = this.field1867[var1];
            int var4 = this.field1868[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1916) {
               this.field1916 = var5;
            }
         }

         this.field1916 = (int)(Math.sqrt((double)this.field1916) + 0.99D);
         this.field1865 = this.field1916;
         this.field1866 = this.field1916 + this.field1916;
      }
   }

   @ObfuscatedName("a")
   final void method2430(int var1) {
      if(field1895[var1]) {
         this.method2387(var1);
      } else {
         int var2 = this.field1870[var1];
         int var3 = this.field1871[var1];
         int var4 = this.field1872[var1];
         class94.field1639 = field1894[var1];
         if(this.field1877 == null) {
            class94.field1641 = 0;
         } else {
            class94.field1641 = this.field1877[var1] & 255;
         }

         if(this.field1886 != null && this.field1886[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1878 != null && this.field1878[var1] != -1) {
               int var8 = this.field1878[var1] & 255;
               var5 = this.field1890[var8];
               var6 = this.field1887[var8];
               var7 = this.field1884[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1875[var1] == -1) {
               class94.method2223(field1899[var2], field1899[var3], field1899[var4], field1896[var2], field1896[var3], field1896[var4], this.field1897[var1], this.field1897[var1], this.field1897[var1], field1903[var5], field1903[var6], field1903[var7], field1900[var5], field1900[var6], field1900[var7], field1901[var5], field1901[var6], field1901[var7], this.field1886[var1]);
            } else {
               class94.method2223(field1899[var2], field1899[var3], field1899[var4], field1896[var2], field1896[var3], field1896[var4], this.field1897[var1], this.field1873[var1], this.field1875[var1], field1903[var5], field1903[var6], field1903[var7], field1900[var5], field1900[var6], field1900[var7], field1901[var5], field1901[var6], field1901[var7], this.field1886[var1]);
            }
         } else if(this.field1875[var1] == -1) {
            class94.method2171(field1899[var2], field1899[var3], field1899[var4], field1896[var2], field1896[var3], field1896[var4], field1923[this.field1897[var1]]);
         } else {
            class94.method2175(field1899[var2], field1899[var3], field1899[var4], field1896[var2], field1896[var3], field1896[var4], this.field1897[var1], this.field1873[var1], this.field1875[var1]);
         }

      }
   }
}
