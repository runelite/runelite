import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dv")
@Implements("Model")
public class class108 extends class88 {
   @ObfuscatedName("bc")
   static int field1869;
   @ObfuscatedName("r")
   static class108 field1870 = new class108();
   @ObfuscatedName("ay")
   static int[] field1871 = new int[4700];
   @ObfuscatedName("x")
   int[] field1872;
   @ObfuscatedName("h")
   int field1873 = 0;
   @ObfuscatedName("s")
   @Export("verticesX")
   int[] field1874;
   @ObfuscatedName("bn")
   public static int field1875 = 0;
   @ObfuscatedName("bs")
   public static int[] field1876 = new int[1000];
   @ObfuscatedName("n")
   int field1877 = 0;
   @ObfuscatedName("b")
   @Export("indices1")
   int[] field1878;
   @ObfuscatedName("m")
   @Export("indices2")
   int[] field1879;
   @ObfuscatedName("q")
   @Export("indices3")
   int[] field1880;
   @ObfuscatedName("p")
   int[] field1881;
   @ObfuscatedName("w")
   int[] field1882;
   @ObfuscatedName("o")
   int[] field1883;
   @ObfuscatedName("f")
   byte[] field1885;
   @ObfuscatedName("z")
   byte[] field1886;
   @ObfuscatedName("i")
   short[] field1887;
   @ObfuscatedName("v")
   byte field1888 = 0;
   @ObfuscatedName("t")
   int[] field1889;
   @ObfuscatedName("ac")
   int field1890;
   @ObfuscatedName("bw")
   static int[] field1891;
   @ObfuscatedName("ad")
   public boolean field1892 = false;
   @ObfuscatedName("u")
   @Export("verticesZ")
   int[] field1893;
   @ObfuscatedName("c")
   int[][] field1894;
   @ObfuscatedName("a")
   int[][] field1895;
   @ObfuscatedName("as")
   int field1896;
   @ObfuscatedName("ah")
   int field1898;
   @ObfuscatedName("aw")
   static int[] field1899 = new int[2000];
   @ObfuscatedName("aq")
   int field1900;
   @ObfuscatedName("am")
   int field1901;
   @ObfuscatedName("ak")
   static boolean[] field1902 = new boolean[4700];
   @ObfuscatedName("ag")
   static boolean[] field1903 = new boolean[4700];
   @ObfuscatedName("af")
   static int[] field1904 = new int[4700];
   @ObfuscatedName("ab")
   static int[] field1905 = new int[4700];
   @ObfuscatedName("ap")
   static int[] field1906 = new int[4700];
   @ObfuscatedName("ao")
   static int[] field1907 = new int[4700];
   @ObfuscatedName("j")
   int field1908 = 0;
   @ObfuscatedName("g")
   static byte[] field1909 = new byte[1];
   @ObfuscatedName("ae")
   static int[] field1910 = new int[1600];
   @ObfuscatedName("k")
   @Export("verticesY")
   int[] field1911;
   @ObfuscatedName("ar")
   static int[][] field1912 = new int[1600][512];
   @ObfuscatedName("at")
   static int[] field1913 = new int[12];
   @ObfuscatedName("av")
   static int[][] field1914 = new int[12][2000];
   @ObfuscatedName("ai")
   static int[] field1915 = new int[4700];
   @ObfuscatedName("l")
   static class108 field1916 = new class108();
   @ObfuscatedName("ax")
   static int[] field1917 = new int[12];
   @ObfuscatedName("al")
   static int[] field1918 = new int[10];
   @ObfuscatedName("an")
   static int[] field1919 = new int[10];
   @ObfuscatedName("aa")
   static int[] field1920 = new int[10];
   @ObfuscatedName("by")
   static int[] field1921;
   @ObfuscatedName("bq")
   static int field1922;
   @ObfuscatedName("bj")
   static int field1923;
   @ObfuscatedName("bt")
   public static boolean field1924 = false;
   @ObfuscatedName("e")
   static byte[] field1925 = new byte[1];
   @ObfuscatedName("bo")
   public static int field1926 = 0;
   @ObfuscatedName("au")
   static int[] field1928 = new int[2000];
   @ObfuscatedName("be")
   static int[] field1929;
   @ObfuscatedName("y")
   int[] field1930;
   @ObfuscatedName("bu")
   public static int field1931 = 0;
   @ObfuscatedName("bm")
   static int[] field1932;
   @ObfuscatedName("d")
   byte[] field1934;

   public class108(class108[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1873 = 0;
      this.field1877 = 0;
      this.field1908 = 0;
      this.field1888 = -1;

      int var7;
      class108 var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1873 += var8.field1873;
            this.field1877 += var8.field1877;
            this.field1908 += var8.field1908;
            if(var8.field1934 != null) {
               var3 = true;
            } else {
               if(this.field1888 == -1) {
                  this.field1888 = var8.field1888;
               }

               if(this.field1888 != var8.field1888) {
                  var3 = true;
               }
            }

            var4 |= var8.field1885 != null;
            var5 |= var8.field1887 != null;
            var6 |= var8.field1886 != null;
         }
      }

      this.field1874 = new int[this.field1873];
      this.field1911 = new int[this.field1873];
      this.field1893 = new int[this.field1873];
      this.field1878 = new int[this.field1877];
      this.field1879 = new int[this.field1877];
      this.field1880 = new int[this.field1877];
      this.field1881 = new int[this.field1877];
      this.field1882 = new int[this.field1877];
      this.field1883 = new int[this.field1877];
      if(var3) {
         this.field1934 = new byte[this.field1877];
      }

      if(var4) {
         this.field1885 = new byte[this.field1877];
      }

      if(var5) {
         this.field1887 = new short[this.field1877];
      }

      if(var6) {
         this.field1886 = new byte[this.field1877];
      }

      if(this.field1908 > 0) {
         this.field1872 = new int[this.field1908];
         this.field1889 = new int[this.field1908];
         this.field1930 = new int[this.field1908];
      }

      this.field1873 = 0;
      this.field1877 = 0;
      this.field1908 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1877; ++var9) {
               this.field1878[this.field1877] = var8.field1878[var9] + this.field1873;
               this.field1879[this.field1877] = var8.field1879[var9] + this.field1873;
               this.field1880[this.field1877] = var8.field1880[var9] + this.field1873;
               this.field1881[this.field1877] = var8.field1881[var9];
               this.field1882[this.field1877] = var8.field1882[var9];
               this.field1883[this.field1877] = var8.field1883[var9];
               if(var3) {
                  if(var8.field1934 != null) {
                     this.field1934[this.field1877] = var8.field1934[var9];
                  } else {
                     this.field1934[this.field1877] = var8.field1888;
                  }
               }

               if(var4 && var8.field1885 != null) {
                  this.field1885[this.field1877] = var8.field1885[var9];
               }

               if(var5) {
                  if(var8.field1887 != null) {
                     this.field1887[this.field1877] = var8.field1887[var9];
                  } else {
                     this.field1887[this.field1877] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1886 != null && var8.field1886[var9] != -1) {
                     this.field1886[this.field1877] = (byte)(var8.field1886[var9] + this.field1908);
                  } else {
                     this.field1886[this.field1877] = -1;
                  }
               }

               ++this.field1877;
            }

            for(var9 = 0; var9 < var8.field1908; ++var9) {
               this.field1872[this.field1908] = var8.field1872[var9] + this.field1873;
               this.field1889[this.field1908] = var8.field1889[var9] + this.field1873;
               this.field1930[this.field1908] = var8.field1930[var9] + this.field1873;
               ++this.field1908;
            }

            for(var9 = 0; var9 < var8.field1873; ++var9) {
               this.field1874[this.field1873] = var8.field1874[var9];
               this.field1911[this.field1873] = var8.field1911[var9];
               this.field1893[this.field1873] = var8.field1893[var9];
               ++this.field1873;
            }
         }
      }

   }

   @ObfuscatedName("l")
   public class108 method2398(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2402();
      int var7 = var2 - this.field1898;
      int var8 = var2 + this.field1898;
      int var9 = var4 - this.field1898;
      int var10 = var4 + this.field1898;
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
               var11.field1873 = this.field1873;
               var11.field1877 = this.field1877;
               var11.field1908 = this.field1908;
               var11.field1874 = this.field1874;
               var11.field1893 = this.field1893;
               var11.field1878 = this.field1878;
               var11.field1879 = this.field1879;
               var11.field1880 = this.field1880;
               var11.field1881 = this.field1881;
               var11.field1882 = this.field1882;
               var11.field1883 = this.field1883;
               var11.field1934 = this.field1934;
               var11.field1885 = this.field1885;
               var11.field1886 = this.field1886;
               var11.field1887 = this.field1887;
               var11.field1888 = this.field1888;
               var11.field1872 = this.field1872;
               var11.field1889 = this.field1889;
               var11.field1930 = this.field1930;
               var11.field1895 = this.field1895;
               var11.field1894 = this.field1894;
               var11.field1892 = this.field1892;
               var11.field1911 = new int[var11.field1873];
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
               for(var12 = 0; var12 < var11.field1873; ++var12) {
                  var13 = this.field1874[var12] + var2;
                  var14 = this.field1893[var12] + var4;
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var1[var17 + 1][var18 + 1] * var15 >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.field1911[var12] = this.field1911[var12] + var21 - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1873; ++var12) {
                  var13 = (-this.field1911[var12] << 16) / super.field1538;
                  if(var13 < var6) {
                     var14 = this.field1874[var12] + var2;
                     var15 = this.field1893[var12] + var4;
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var1[var18 + 1][var19 + 1] * var16 >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.field1911[var12] = this.field1911[var12] + (var22 - var3) * (var6 - var13) / var6;
                  }
               }
            }

            var11.field1896 = 0;
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("g")
   public class108 method2399(boolean var1) {
      if(!var1 && field1909.length < this.field1877) {
         field1909 = new byte[this.field1877 + 100];
      }

      return this.method2435(var1, field1916, field1909);
   }

   @ObfuscatedName("e")
   public class108 method2400(boolean var1) {
      if(!var1 && field1925.length < this.field1877) {
         field1925 = new byte[this.field1877 + 100];
      }

      return this.method2435(var1, field1870, field1925);
   }

   @ObfuscatedName("s")
   public void method2402() {
      if(this.field1896 != 1) {
         this.field1896 = 1;
         super.field1538 = 0;
         this.field1890 = 0;
         this.field1898 = 0;

         for(int var1 = 0; var1 < this.field1873; ++var1) {
            int var2 = this.field1874[var1];
            int var3 = this.field1911[var1];
            int var4 = this.field1893[var1];
            if(-var3 > super.field1538) {
               super.field1538 = -var3;
            }

            if(var3 > this.field1890) {
               this.field1890 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1898) {
               this.field1898 = var5;
            }
         }

         this.field1898 = (int)(Math.sqrt((double)this.field1898) + 0.99D);
         this.field1900 = (int)(Math.sqrt((double)(this.field1898 * this.field1898 + super.field1538 * super.field1538)) + 0.99D);
         this.field1901 = this.field1900 + (int)(Math.sqrt((double)(this.field1898 * this.field1898 + this.field1890 * this.field1890)) + 0.99D);
      }
   }

   @ObfuscatedName("k")
   void method2403() {
      if(this.field1896 != 2) {
         this.field1896 = 2;
         this.field1898 = 0;

         for(int var1 = 0; var1 < this.field1873; ++var1) {
            int var2 = this.field1874[var1];
            int var3 = this.field1911[var1];
            int var4 = this.field1893[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1898) {
               this.field1898 = var5;
            }
         }

         this.field1898 = (int)(Math.sqrt((double)this.field1898) + 0.99D);
         this.field1900 = this.field1898;
         this.field1901 = this.field1898 + this.field1898;
      }
   }

   @ObfuscatedName("v")
   public void method2404(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1873; ++var4) {
         this.field1874[var4] = this.field1874[var4] * var1 / 128;
         this.field1911[var4] = this.field1911[var4] * var2 / 128;
         this.field1893[var4] = this.field1893[var4] * var3 / 128;
      }

      this.field1896 = 0;
   }

   @ObfuscatedName("n")
   public void method2405(class106 var1, int var2) {
      if(this.field1895 != null) {
         if(var2 != -1) {
            class91 var3 = var1.field1843[var2];
            class105 var4 = var3.field1619;
            field1869 = 0;
            field1922 = 0;
            field1923 = 0;

            for(int var5 = 0; var5 < var3.field1620; ++var5) {
               int var6 = var3.field1621[var5];
               this.method2407(var4.field1836[var6], var4.field1837[var6], var3.field1623[var5], var3.field1615[var5], var3.field1624[var5]);
            }

            this.field1896 = 0;
         }
      }
   }

   @ObfuscatedName("m")
   void method2407(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1869 = 0;
         field1922 = 0;
         field1923 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var18 = var2[var8];
            if(var18 < this.field1895.length) {
               int[] var19 = this.field1895[var18];

               for(var11 = 0; var11 < var19.length; ++var11) {
                  var12 = var19[var11];
                  field1869 += this.field1874[var12];
                  field1922 += this.field1911[var12];
                  field1923 += this.field1893[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1869 = field1869 / var7 + var3;
            field1922 = field1922 / var7 + var4;
            field1923 = field1923 / var7 + var5;
         } else {
            field1869 = var3;
            field1922 = var4;
            field1923 = var5;
         }

      } else {
         int[] var9;
         int var10;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1895.length) {
                  var9 = this.field1895[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.field1874[var11] += var3;
                     this.field1911[var11] += var4;
                     this.field1893[var11] += var5;
                  }
               }
            }

         } else if(var1 == 2) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1895.length) {
                  var9 = this.field1895[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.field1874[var11] -= field1869;
                     this.field1911[var11] -= field1922;
                     this.field1893[var11] -= field1923;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1929[var14];
                        var16 = field1921[var14];
                        var17 = this.field1911[var11] * var15 + this.field1874[var11] * var16 >> 16;
                        this.field1911[var11] = this.field1911[var11] * var16 - this.field1874[var11] * var15 >> 16;
                        this.field1874[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1929[var12];
                        var16 = field1921[var12];
                        var17 = this.field1911[var11] * var16 - this.field1893[var11] * var15 >> 16;
                        this.field1893[var11] = this.field1911[var11] * var15 + this.field1893[var11] * var16 >> 16;
                        this.field1911[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1929[var13];
                        var16 = field1921[var13];
                        var17 = this.field1893[var11] * var15 + this.field1874[var11] * var16 >> 16;
                        this.field1893[var11] = this.field1893[var11] * var16 - this.field1874[var11] * var15 >> 16;
                        this.field1874[var11] = var17;
                     }

                     this.field1874[var11] += field1869;
                     this.field1911[var11] += field1922;
                     this.field1893[var11] += field1923;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1895.length) {
                  var9 = this.field1895[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.field1874[var11] -= field1869;
                     this.field1911[var11] -= field1922;
                     this.field1893[var11] -= field1923;
                     this.field1874[var11] = this.field1874[var11] * var3 / 128;
                     this.field1911[var11] = this.field1911[var11] * var4 / 128;
                     this.field1893[var11] = this.field1893[var11] * var5 / 128;
                     this.field1874[var11] += field1869;
                     this.field1911[var11] += field1922;
                     this.field1893[var11] += field1923;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1894 != null && this.field1885 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1894.length) {
                     var9 = this.field1894[var8];

                     for(var10 = 0; var10 < var9.length; ++var10) {
                        var11 = var9[var10];
                        var12 = (this.field1885[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1885[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("b")
   public void method2408(class106 var1, int var2, class106 var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            class91 var6 = var1.field1843[var2];
            class91 var7 = var3.field1843[var4];
            class105 var8 = var6.field1619;
            field1869 = 0;
            field1922 = 0;
            field1923 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1620; ++var11) {
               for(var12 = var6.field1621[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field1836[var12] == 0) {
                  this.method2407(var8.field1836[var12], var8.field1837[var12], var6.field1623[var11], var6.field1615[var11], var6.field1624[var11]);
               }
            }

            field1869 = 0;
            field1922 = 0;
            field1923 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1620; ++var11) {
               for(var12 = var7.field1621[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field1836[var12] == 0) {
                  this.method2407(var8.field1836[var12], var8.field1837[var12], var7.field1623[var11], var7.field1615[var11], var7.field1624[var11]);
               }
            }

            this.field1896 = 0;
         } else {
            this.method2405(var1, var2);
         }
      }
   }

   @ObfuscatedName("f")
   public void method2410() {
      for(int var1 = 0; var1 < this.field1873; ++var1) {
         int var2 = this.field1893[var1];
         this.field1893[var1] = this.field1874[var1];
         this.field1874[var1] = -var2;
      }

      this.field1896 = 0;
   }

   @ObfuscatedName("z")
   public void method2411(int var1) {
      int var2 = field1929[var1];
      int var3 = field1921[var1];

      for(int var4 = 0; var4 < this.field1873; ++var4) {
         int var5 = this.field1911[var4] * var3 - this.field1893[var4] * var2 >> 16;
         this.field1893[var4] = this.field1911[var4] * var2 + this.field1893[var4] * var3 >> 16;
         this.field1911[var4] = var5;
      }

      this.field1896 = 0;
   }

   @ObfuscatedName("i")
   public void method2412(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1873; ++var4) {
         this.field1874[var4] += var1;
         this.field1911[var4] += var2;
         this.field1893[var4] += var3;
      }

      this.field1896 = 0;
   }

   @ObfuscatedName("j")
   public final void method2414(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1910[0] = -1;
      if(this.field1896 != 2 && this.field1896 != 1) {
         this.method2403();
      }

      int var8 = class94.field1648;
      int var9 = class94.field1649;
      int var10000 = field1929[var1];
      var10000 = field1921[var1];
      int var12 = field1929[var2];
      int var13 = field1921[var2];
      int var14 = field1929[var3];
      int var15 = field1921[var3];
      int var16 = field1929[var4];
      int var17 = field1921[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1873; ++var19) {
         int var20 = this.field1874[var19];
         int var21 = this.field1911[var19];
         int var22 = this.field1893[var19];
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
         field1906[var19] = var22 - var18;
         field1904[var19] = var8 + var20 * class94.field1660 / var22;
         field1905[var19] = var9 + var23 * class94.field1660 / var22;
         if(this.field1908 > 0) {
            field1907[var19] = var20;
            field1871[var19] = var23;
            field1915[var19] = var22;
         }
      }

      try {
         this.method2417(false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("x")
   public final void method2415(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1910[0] = -1;
      if(this.field1896 != 2 && this.field1896 != 1) {
         this.method2403();
      }

      int var9 = class94.field1648;
      int var10 = class94.field1649;
      int var10000 = field1929[var1];
      var10000 = field1921[var1];
      int var13 = field1929[var2];
      int var14 = field1921[var2];
      int var15 = field1929[var3];
      int var16 = field1921[var3];
      int var17 = field1929[var4];
      int var18 = field1921[var4];
      int var19 = var6 * var17 + var7 * var18 >> 16;

      for(int var20 = 0; var20 < this.field1873; ++var20) {
         int var21 = this.field1874[var20];
         int var22 = this.field1911[var20];
         int var23 = this.field1893[var20];
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
         field1906[var20] = var23 - var19;
         field1904[var20] = var9 + var21 * class94.field1660 / var8;
         field1905[var20] = var10 + var24 * class94.field1660 / var8;
         if(this.field1908 > 0) {
            field1907[var20] = var21;
            field1871[var20] = var24;
            field1915[var20] = var23;
         }
      }

      try {
         this.method2417(false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("af")
   void vmethod2416(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1910[0] = -1;
      if(this.field1896 != 1) {
         this.method2402();
      }

      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1898 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1898) * class94.field1660;
         if(var15 / var13 < class94.field1653) {
            int var16 = (var14 + this.field1898) * class94.field1660;
            if(var16 / var13 > class94.field1652) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1898 * var2 >> 16;
               int var19 = (var17 + var18) * class94.field1660;
               if(var19 / var13 > class94.field1650) {
                  int var20 = var18 + (super.field1538 * var3 >> 16);
                  int var21 = (var17 - var20) * class94.field1660;
                  if(var21 / var13 < class94.field1655) {
                     int var22 = var12 + (super.field1538 * var2 >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1908 > 0;
                     boolean var26 = false;
                     int var27;
                     int var28;
                     int var29;
                     if(var9 > 0 && field1924) {
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

                        var28 = field1875 - class94.field1648;
                        var29 = field1926 - class94.field1649;
                        if(var28 > var15 && var28 < var16 && var29 > var21 && var29 < var19) {
                           if(this.field1892) {
                              field1876[field1931++] = var9;
                           } else {
                              var26 = true;
                           }
                        }
                     }

                     var27 = class94.field1648;
                     var28 = class94.field1649;
                     var29 = 0;
                     int var30 = 0;
                     if(var1 != 0) {
                        var29 = field1929[var1];
                        var30 = field1921[var1];
                     }

                     for(int var31 = 0; var31 < this.field1873; ++var31) {
                        int var32 = this.field1874[var31];
                        int var33 = this.field1911[var31];
                        int var34 = this.field1893[var31];
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
                        field1906[var31] = var34 - var11;
                        if(var34 >= 50) {
                           field1904[var31] = var27 + var32 * class94.field1660 / var34;
                           field1905[var31] = var28 + var35 * class94.field1660 / var34;
                        } else {
                           field1904[var31] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1907[var31] = var32;
                           field1871[var31] = var35;
                           field1915[var31] = var34;
                        }
                     }

                     try {
                        this.method2417(var23, var26, var9);
                     } catch (Exception var37) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("t")
   final void method2417(boolean var1, boolean var2, int var3) {
      if(this.field1901 < 1600) {
         int var4;
         for(var4 = 0; var4 < this.field1901; ++var4) {
            field1910[var4] = 0;
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
         for(var4 = 0; var4 < this.field1877; ++var4) {
            if(this.field1883[var4] != -2) {
               var5 = this.field1878[var4];
               var6 = this.field1879[var4];
               var7 = this.field1880[var4];
               var8 = field1904[var5];
               var9 = field1904[var6];
               var10 = field1904[var7];
               int var11;
               if(var1 && (var8 == -5000 || var9 == -5000 || var10 == -5000)) {
                  var11 = field1907[var5];
                  var12 = field1907[var6];
                  var13 = field1907[var7];
                  int var14 = field1871[var5];
                  var15 = field1871[var6];
                  int var16 = field1871[var7];
                  int var17 = field1915[var5];
                  int var18 = field1915[var6];
                  int var19 = field1915[var7];
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
                     field1903[var4] = true;
                     int var23 = (field1906[var5] + field1906[var6] + field1906[var7]) / 3 + this.field1900;
                     field1912[var23][field1910[var23]++] = var4;
                  }
               } else {
                  if(var2 && this.method2420(field1875, field1926, field1905[var5], field1905[var6], field1905[var7], var8, var9, var10)) {
                     field1876[field1931++] = var3;
                     var2 = false;
                  }

                  if((var8 - var9) * (field1905[var7] - field1905[var6]) - (field1905[var5] - field1905[var6]) * (var10 - var9) > 0) {
                     field1903[var4] = false;
                     if(var8 >= 0 && var9 >= 0 && var10 >= 0 && var8 <= class94.field1657 && var9 <= class94.field1657 && var10 <= class94.field1657) {
                        field1902[var4] = false;
                     } else {
                        field1902[var4] = true;
                     }

                     var11 = (field1906[var5] + field1906[var6] + field1906[var7]) / 3 + this.field1900;
                     field1912[var11][field1910[var11]++] = var4;
                  }
               }
            }
         }

         int[] var26;
         if(this.field1934 == null) {
            for(var4 = this.field1901 - 1; var4 >= 0; --var4) {
               var5 = field1910[var4];
               if(var5 > 0) {
                  var26 = field1912[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     this.method2418(var26[var7]);
                  }
               }
            }

         } else {
            for(var4 = 0; var4 < 12; ++var4) {
               field1913[var4] = 0;
               field1917[var4] = 0;
            }

            for(var4 = this.field1901 - 1; var4 >= 0; --var4) {
               var5 = field1910[var4];
               if(var5 > 0) {
                  var26 = field1912[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     var8 = var26[var7];
                     byte var28 = this.field1934[var8];
                     var10 = field1913[var28]++;
                     field1914[var28][var10] = var8;
                     if(var28 < 10) {
                        field1917[var28] += var4;
                     } else if(var28 == 10) {
                        field1899[var10] = var4;
                     } else {
                        field1928[var10] = var4;
                     }
                  }
               }
            }

            var4 = 0;
            if(field1913[1] > 0 || field1913[2] > 0) {
               var4 = (field1917[1] + field1917[2]) / (field1913[1] + field1913[2]);
            }

            var5 = 0;
            if(field1913[3] > 0 || field1913[4] > 0) {
               var5 = (field1917[3] + field1917[4]) / (field1913[3] + field1913[4]);
            }

            var6 = 0;
            if(field1913[6] > 0 || field1913[8] > 0) {
               var6 = (field1917[6] + field1917[8]) / (field1913[6] + field1913[8]);
            }

            var8 = 0;
            var9 = field1913[10];
            int[] var24 = field1914[10];
            int[] var27 = field1899;
            if(var8 == var9) {
               var8 = 0;
               var9 = field1913[11];
               var24 = field1914[11];
               var27 = field1928;
            }

            if(var8 < var9) {
               var7 = var27[var8];
            } else {
               var7 = -1000;
            }

            for(var12 = 0; var12 < 10; ++var12) {
               while(var12 == 0 && var7 > var4) {
                  this.method2418(var24[var8++]);
                  if(var8 == var9 && var24 != field1914[11]) {
                     var8 = 0;
                     var9 = field1913[11];
                     var24 = field1914[11];
                     var27 = field1928;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 3 && var7 > var5) {
                  this.method2418(var24[var8++]);
                  if(var8 == var9 && var24 != field1914[11]) {
                     var8 = 0;
                     var9 = field1913[11];
                     var24 = field1914[11];
                     var27 = field1928;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 5 && var7 > var6) {
                  this.method2418(var24[var8++]);
                  if(var8 == var9 && var24 != field1914[11]) {
                     var8 = 0;
                     var9 = field1913[11];
                     var24 = field1914[11];
                     var27 = field1928;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               var13 = field1913[var12];
               int[] var25 = field1914[var12];

               for(var15 = 0; var15 < var13; ++var15) {
                  this.method2418(var25[var15]);
               }
            }

            while(var7 != -1000) {
               this.method2418(var24[var8++]);
               if(var8 == var9 && var24 != field1914[11]) {
                  var8 = 0;
                  var24 = field1914[11];
                  var9 = field1913[11];
                  var27 = field1928;
               }

               if(var8 < var9) {
                  var7 = var27[var8];
               } else {
                  var7 = -1000;
               }
            }

         }
      }
   }

   @ObfuscatedName("y")
   final void method2418(int var1) {
      if(field1903[var1]) {
         this.method2419(var1);
      } else {
         int var2 = this.field1878[var1];
         int var3 = this.field1879[var1];
         int var4 = this.field1880[var1];
         class94.field1656 = field1902[var1];
         if(this.field1885 == null) {
            class94.field1642 = 0;
         } else {
            class94.field1642 = this.field1885[var1] & 255;
         }

         if(this.field1887 != null && this.field1887[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1886 != null && this.field1886[var1] != -1) {
               int var8 = this.field1886[var1] & 255;
               var5 = this.field1872[var8];
               var6 = this.field1889[var8];
               var7 = this.field1930[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1883[var1] == -1) {
               class94.method2178(field1905[var2], field1905[var3], field1905[var4], field1904[var2], field1904[var3], field1904[var4], this.field1881[var1], this.field1881[var1], this.field1881[var1], field1907[var5], field1907[var6], field1907[var7], field1871[var5], field1871[var6], field1871[var7], field1915[var5], field1915[var6], field1915[var7], this.field1887[var1]);
            } else {
               class94.method2178(field1905[var2], field1905[var3], field1905[var4], field1904[var2], field1904[var3], field1904[var4], this.field1881[var1], this.field1882[var1], this.field1883[var1], field1907[var5], field1907[var6], field1907[var7], field1871[var5], field1871[var6], field1871[var7], field1915[var5], field1915[var6], field1915[var7], this.field1887[var1]);
            }
         } else if(this.field1883[var1] == -1) {
            class94.method2220(field1905[var2], field1905[var3], field1905[var4], field1904[var2], field1904[var3], field1904[var4], field1891[this.field1881[var1]]);
         } else {
            class94.method2174(field1905[var2], field1905[var3], field1905[var4], field1904[var2], field1904[var3], field1904[var4], this.field1881[var1], this.field1882[var1], this.field1883[var1]);
         }

      }
   }

   @ObfuscatedName("a")
   final void method2419(int var1) {
      int var2 = class94.field1648;
      int var3 = class94.field1649;
      int var4 = 0;
      int var5 = this.field1878[var1];
      int var6 = this.field1879[var1];
      int var7 = this.field1880[var1];
      int var8 = field1915[var5];
      int var9 = field1915[var6];
      int var10 = field1915[var7];
      if(this.field1885 == null) {
         class94.field1642 = 0;
      } else {
         class94.field1642 = this.field1885[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1918[var4] = field1904[var5];
         field1919[var4] = field1905[var5];
         field1920[var4++] = this.field1881[var1];
      } else {
         var11 = field1907[var5];
         var12 = field1871[var5];
         var13 = this.field1881[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1932[var10 - var8];
            field1918[var4] = var2 + (var11 + ((field1907[var7] - var11) * var14 >> 16)) * class94.field1660 / 50;
            field1919[var4] = var3 + (var12 + ((field1871[var7] - var12) * var14 >> 16)) * class94.field1660 / 50;
            field1920[var4++] = var13 + ((this.field1883[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1932[var9 - var8];
            field1918[var4] = var2 + (var11 + ((field1907[var6] - var11) * var14 >> 16)) * class94.field1660 / 50;
            field1919[var4] = var3 + (var12 + ((field1871[var6] - var12) * var14 >> 16)) * class94.field1660 / 50;
            field1920[var4++] = var13 + ((this.field1882[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1918[var4] = field1904[var6];
         field1919[var4] = field1905[var6];
         field1920[var4++] = this.field1882[var1];
      } else {
         var11 = field1907[var6];
         var12 = field1871[var6];
         var13 = this.field1882[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1932[var8 - var9];
            field1918[var4] = var2 + (var11 + ((field1907[var5] - var11) * var14 >> 16)) * class94.field1660 / 50;
            field1919[var4] = var3 + (var12 + ((field1871[var5] - var12) * var14 >> 16)) * class94.field1660 / 50;
            field1920[var4++] = var13 + ((this.field1881[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1932[var10 - var9];
            field1918[var4] = var2 + (var11 + ((field1907[var7] - var11) * var14 >> 16)) * class94.field1660 / 50;
            field1919[var4] = var3 + (var12 + ((field1871[var7] - var12) * var14 >> 16)) * class94.field1660 / 50;
            field1920[var4++] = var13 + ((this.field1883[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1918[var4] = field1904[var7];
         field1919[var4] = field1905[var7];
         field1920[var4++] = this.field1883[var1];
      } else {
         var11 = field1907[var7];
         var12 = field1871[var7];
         var13 = this.field1883[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1932[var9 - var10];
            field1918[var4] = var2 + (var11 + ((field1907[var6] - var11) * var14 >> 16)) * class94.field1660 / 50;
            field1919[var4] = var3 + (var12 + ((field1871[var6] - var12) * var14 >> 16)) * class94.field1660 / 50;
            field1920[var4++] = var13 + ((this.field1882[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1932[var8 - var10];
            field1918[var4] = var2 + (var11 + ((field1907[var5] - var11) * var14 >> 16)) * class94.field1660 / 50;
            field1919[var4] = var3 + (var12 + ((field1871[var5] - var12) * var14 >> 16)) * class94.field1660 / 50;
            field1920[var4++] = var13 + ((this.field1881[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1918[0];
      var12 = field1918[1];
      var13 = field1918[2];
      var14 = field1919[0];
      int var15 = field1919[1];
      int var16 = field1919[2];
      class94.field1656 = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class94.field1657 || var12 > class94.field1657 || var13 > class94.field1657) {
            class94.field1656 = true;
         }

         if(this.field1887 != null && this.field1887[var1] != -1) {
            if(this.field1886 != null && this.field1886[var1] != -1) {
               var20 = this.field1886[var1] & 255;
               var17 = this.field1872[var20];
               var18 = this.field1889[var20];
               var19 = this.field1930[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1883[var1] == -1) {
               class94.method2178(var14, var15, var16, var11, var12, var13, this.field1881[var1], this.field1881[var1], this.field1881[var1], field1907[var17], field1907[var18], field1907[var19], field1871[var17], field1871[var18], field1871[var19], field1915[var17], field1915[var18], field1915[var19], this.field1887[var1]);
            } else {
               class94.method2178(var14, var15, var16, var11, var12, var13, field1920[0], field1920[1], field1920[2], field1907[var17], field1907[var18], field1907[var19], field1871[var17], field1871[var18], field1871[var19], field1915[var17], field1915[var18], field1915[var19], this.field1887[var1]);
            }
         } else if(this.field1883[var1] == -1) {
            class94.method2220(var14, var15, var16, var11, var12, var13, field1891[this.field1881[var1]]);
         } else {
            class94.method2174(var14, var15, var16, var11, var12, var13, field1920[0], field1920[1], field1920[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class94.field1657 || var12 > class94.field1657 || var13 > class94.field1657 || field1918[3] < 0 || field1918[3] > class94.field1657) {
            class94.field1656 = true;
         }

         if(this.field1887 != null && this.field1887[var1] != -1) {
            if(this.field1886 != null && this.field1886[var1] != -1) {
               var20 = this.field1886[var1] & 255;
               var17 = this.field1872[var20];
               var18 = this.field1889[var20];
               var19 = this.field1930[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1887[var1];
            if(this.field1883[var1] == -1) {
               class94.method2178(var14, var15, var16, var11, var12, var13, this.field1881[var1], this.field1881[var1], this.field1881[var1], field1907[var17], field1907[var18], field1907[var19], field1871[var17], field1871[var18], field1871[var19], field1915[var17], field1915[var18], field1915[var19], var21);
               class94.method2178(var14, var16, field1919[3], var11, var13, field1918[3], this.field1881[var1], this.field1881[var1], this.field1881[var1], field1907[var17], field1907[var18], field1907[var19], field1871[var17], field1871[var18], field1871[var19], field1915[var17], field1915[var18], field1915[var19], var21);
            } else {
               class94.method2178(var14, var15, var16, var11, var12, var13, field1920[0], field1920[1], field1920[2], field1907[var17], field1907[var18], field1907[var19], field1871[var17], field1871[var18], field1871[var19], field1915[var17], field1915[var18], field1915[var19], var21);
               class94.method2178(var14, var16, field1919[3], var11, var13, field1918[3], field1920[0], field1920[2], field1920[3], field1907[var17], field1907[var18], field1907[var19], field1871[var17], field1871[var18], field1871[var19], field1915[var17], field1915[var18], field1915[var19], var21);
            }
         } else if(this.field1883[var1] == -1) {
            var17 = field1891[this.field1881[var1]];
            class94.method2220(var14, var15, var16, var11, var12, var13, var17);
            class94.method2220(var14, var16, field1919[3], var11, var13, field1918[3], var17);
         } else {
            class94.method2174(var14, var15, var16, var11, var12, var13, field1920[0], field1920[1], field1920[2]);
            class94.method2174(var14, var16, field1919[3], var11, var13, field1918[3], field1920[0], field1920[2], field1920[3]);
         }
      }

   }

   @ObfuscatedName("c")
   final boolean method2420(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      return var2 < var3 && var2 < var4 && var2 < var5?false:(var2 > var3 && var2 > var4 && var2 > var5?false:(var1 < var6 && var1 < var7 && var1 < var8?false:var1 <= var6 || var1 <= var7 || var1 <= var8));
   }

   static {
      field1929 = class94.field1661;
      field1921 = class94.field1662;
      field1891 = class94.field1659;
      field1932 = class94.field1654;
   }

   @ObfuscatedName("d")
   public void method2421() {
      for(int var1 = 0; var1 < this.field1873; ++var1) {
         this.field1874[var1] = -this.field1874[var1];
         this.field1893[var1] = -this.field1893[var1];
      }

      this.field1896 = 0;
   }

   @ObfuscatedName("h")
   class108 method2435(boolean var1, class108 var2, byte[] var3) {
      var2.field1873 = this.field1873;
      var2.field1877 = this.field1877;
      var2.field1908 = this.field1908;
      if(var2.field1874 == null || var2.field1874.length < this.field1873) {
         var2.field1874 = new int[this.field1873 + 100];
         var2.field1911 = new int[this.field1873 + 100];
         var2.field1893 = new int[this.field1873 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1873; ++var4) {
         var2.field1874[var4] = this.field1874[var4];
         var2.field1911[var4] = this.field1911[var4];
         var2.field1893[var4] = this.field1893[var4];
      }

      if(var1) {
         var2.field1885 = this.field1885;
      } else {
         var2.field1885 = var3;
         if(this.field1885 == null) {
            for(var4 = 0; var4 < this.field1877; ++var4) {
               var2.field1885[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1877; ++var4) {
               var2.field1885[var4] = this.field1885[var4];
            }
         }
      }

      var2.field1878 = this.field1878;
      var2.field1879 = this.field1879;
      var2.field1880 = this.field1880;
      var2.field1881 = this.field1881;
      var2.field1882 = this.field1882;
      var2.field1883 = this.field1883;
      var2.field1934 = this.field1934;
      var2.field1886 = this.field1886;
      var2.field1887 = this.field1887;
      var2.field1888 = this.field1888;
      var2.field1872 = this.field1872;
      var2.field1889 = this.field1889;
      var2.field1930 = this.field1930;
      var2.field1895 = this.field1895;
      var2.field1894 = this.field1894;
      var2.field1892 = this.field1892;
      var2.field1896 = 0;
      return var2;
   }

   class108() {
   }

   @ObfuscatedName("o")
   public void method2455() {
      for(int var1 = 0; var1 < this.field1873; ++var1) {
         int var2 = this.field1874[var1];
         this.field1874[var1] = this.field1893[var1];
         this.field1893[var1] = -var2;
      }

      this.field1896 = 0;
   }

   @ObfuscatedName("u")
   public int method2458() {
      this.method2402();
      return this.field1898;
   }
}
