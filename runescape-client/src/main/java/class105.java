import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
@Implements("Model")
public class class105 extends class85 {
   @ObfuscatedName("bi")
   public static int field1808 = 0;
   @ObfuscatedName("t")
   int[] field1809;
   @ObfuscatedName("ad")
   int field1810;
   @ObfuscatedName("x")
   static byte[] field1811 = new byte[1];
   @ObfuscatedName("d")
   int field1812 = 0;
   @ObfuscatedName("u")
   int[] field1813;
   @ObfuscatedName("ac")
   static int[] field1814 = new int[12];
   @ObfuscatedName("b")
   int[] field1815;
   @ObfuscatedName("at")
   static int[] field1816 = new int[12];
   @ObfuscatedName("c")
   int[] field1817;
   @ObfuscatedName("l")
   int[] field1818;
   @ObfuscatedName("ax")
   static int[] field1819 = new int[4700];
   @ObfuscatedName("i")
   int[] field1820;
   @ObfuscatedName("r")
   int[] field1821;
   @ObfuscatedName("s")
   static class105 field1822 = new class105();
   @ObfuscatedName("e")
   byte[] field1823;
   @ObfuscatedName("h")
   byte[] field1824;
   @ObfuscatedName("z")
   byte[] field1825;
   @ObfuscatedName("y")
   int[] field1826;
   @ObfuscatedName("au")
   int field1827;
   @ObfuscatedName("g")
   int field1828 = 0;
   @ObfuscatedName("aq")
   static int[] field1829 = new int[4700];
   @ObfuscatedName("k")
   int field1830 = 0;
   @ObfuscatedName("q")
   int[] field1831;
   @ObfuscatedName("m")
   int[] field1832;
   @ObfuscatedName("v")
   int[][] field1833;
   @ObfuscatedName("ab")
   public boolean field1834 = false;
   @ObfuscatedName("j")
   static byte[] field1835 = new byte[1];
   @ObfuscatedName("an")
   int field1836;
   @ObfuscatedName("f")
   int[] field1837;
   @ObfuscatedName("aw")
   static int[][] field1838 = new int[1600][512];
   @ObfuscatedName("o")
   int[] field1839;
   @ObfuscatedName("ao")
   static boolean[] field1841 = new boolean[4700];
   @ObfuscatedName("as")
   static boolean[] field1842 = new boolean[4700];
   @ObfuscatedName("ai")
   static int[] field1843 = new int[4700];
   @ObfuscatedName("ah")
   static int[] field1844 = new int[4700];
   @ObfuscatedName("p")
   static class105 field1845 = new class105();
   @ObfuscatedName("a")
   short[] field1846;
   @ObfuscatedName("az")
   static int[] field1847 = new int[10];
   @ObfuscatedName("ay")
   static int[] field1848 = new int[4700];
   @ObfuscatedName("ap")
   int field1850;
   @ObfuscatedName("aa")
   static int[] field1851 = new int[4700];
   @ObfuscatedName("ar")
   static int[] field1852 = new int[1600];
   @ObfuscatedName("w")
   byte field1853 = 0;
   @ObfuscatedName("al")
   static int[] field1854 = new int[2000];
   @ObfuscatedName("ag")
   static int[] field1855 = new int[2000];
   @ObfuscatedName("af")
   static int[][] field1856 = new int[12][2000];
   @ObfuscatedName("ak")
   static int[] field1857 = new int[10];
   @ObfuscatedName("av")
   static int[] field1858 = new int[10];
   @ObfuscatedName("n")
   int[][] field1859;
   @ObfuscatedName("bd")
   static int field1860;
   @ObfuscatedName("bt")
   static int field1861;
   @ObfuscatedName("bq")
   static int field1862;
   @ObfuscatedName("bj")
   public static boolean field1863 = false;
   @ObfuscatedName("bf")
   public static int field1864 = 0;
   @ObfuscatedName("br")
   public static int field1865 = 0;
   @ObfuscatedName("am")
   int field1866;
   @ObfuscatedName("bh")
   public static int[] field1867 = new int[1000];
   @ObfuscatedName("bv")
   static int[] field1868;
   @ObfuscatedName("bx")
   static int[] field1869;
   @ObfuscatedName("ba")
   static int[] field1870;
   @ObfuscatedName("bs")
   static int[] field1871;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([[IIIIZI)Lclass105;",
      garbageValue = "1"
   )
   public class105 method2283(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2287();
      int var7 = var2 - this.field1827;
      int var8 = var2 + this.field1827;
      int var9 = var4 - this.field1827;
      int var10 = var4 + this.field1827;
      if(var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
         var7 >>= 7;
         var8 = var8 + 127 >> 7;
         var9 >>= 7;
         var10 = var10 + 127 >> 7;
         if(var1[var7][var9] == var3 && var1[var8][var9] == var3 && var1[var7][var10] == var3 && var1[var8][var10] == var3) {
            return this;
         } else {
            class105 var11 = new class105();
            var11.field1812 = this.field1812;
            var11.field1830 = this.field1830;
            var11.field1828 = this.field1828;
            var11.field1813 = this.field1813;
            var11.field1815 = this.field1815;
            var11.field1817 = this.field1817;
            var11.field1818 = this.field1818;
            var11.field1809 = this.field1809;
            var11.field1820 = this.field1820;
            var11.field1821 = this.field1821;
            var11.field1832 = this.field1832;
            var11.field1823 = this.field1823;
            var11.field1824 = this.field1824;
            var11.field1825 = this.field1825;
            var11.field1846 = this.field1846;
            var11.field1853 = this.field1853;
            var11.field1826 = this.field1826;
            var11.field1837 = this.field1837;
            var11.field1831 = this.field1831;
            var11.field1859 = this.field1859;
            var11.field1833 = this.field1833;
            var11.field1834 = this.field1834;
            var11.field1839 = new int[var11.field1812];
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
               for(var12 = 0; var12 < var11.field1812; ++var12) {
                  var13 = this.field1813[var12] + var2;
                  var14 = this.field1815[var12] + var4;
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var1[var17 + 1][var18 + 1] * var15 >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.field1839[var12] = this.field1839[var12] + var21 - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1812; ++var12) {
                  var13 = (-this.field1839[var12] << 16) / super.field1465;
                  if(var13 < var6) {
                     var14 = this.field1813[var12] + var2;
                     var15 = this.field1815[var12] + var4;
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var1[var18 + 1][var19 + 1] * var16 >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.field1839[var12] = this.field1839[var12] + (var22 - var3) * (var6 - var13) / var6;
                  }
               }
            }

            var11.field1810 = 0;
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("j")
   public class105 method2284(boolean var1) {
      if(!var1 && field1835.length < this.field1830) {
         field1835 = new byte[this.field1830 + 100];
      }

      return this.method2286(var1, field1822, field1835);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Z)Lclass105;",
      garbageValue = "1"
   )
   public class105 method2285(boolean var1) {
      return this.method2286(var1, field1845, field1811);
   }

   @ObfuscatedName("d")
   class105 method2286(boolean var1, class105 var2, byte[] var3) {
      var2.field1812 = this.field1812;
      var2.field1830 = this.field1830;
      var2.field1828 = this.field1828;
      if(var2.field1813 == null || var2.field1813.length < this.field1812) {
         var2.field1813 = new int[this.field1812 + 100];
         var2.field1839 = new int[this.field1812 + 100];
         var2.field1815 = new int[this.field1812 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1812; ++var4) {
         var2.field1813[var4] = this.field1813[var4];
         var2.field1839[var4] = this.field1839[var4];
         var2.field1815[var4] = this.field1815[var4];
      }

      if(var1) {
         var2.field1824 = this.field1824;
      } else {
         var2.field1824 = var3;
         if(this.field1824 == null) {
            for(var4 = 0; var4 < this.field1830; ++var4) {
               var2.field1824[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1830; ++var4) {
               var2.field1824[var4] = this.field1824[var4];
            }
         }
      }

      var2.field1817 = this.field1817;
      var2.field1818 = this.field1818;
      var2.field1809 = this.field1809;
      var2.field1820 = this.field1820;
      var2.field1821 = this.field1821;
      var2.field1832 = this.field1832;
      var2.field1823 = this.field1823;
      var2.field1825 = this.field1825;
      var2.field1846 = this.field1846;
      var2.field1853 = this.field1853;
      var2.field1826 = this.field1826;
      var2.field1837 = this.field1837;
      var2.field1831 = this.field1831;
      var2.field1859 = this.field1859;
      var2.field1833 = this.field1833;
      var2.field1834 = this.field1834;
      var2.field1810 = 0;
      return var2;
   }

   @ObfuscatedName("u")
   public void method2287() {
      if(this.field1810 != 1) {
         this.field1810 = 1;
         super.field1465 = 0;
         this.field1836 = 0;
         this.field1827 = 0;

         for(int var1 = 0; var1 < this.field1812; ++var1) {
            int var2 = this.field1813[var1];
            int var3 = this.field1839[var1];
            int var4 = this.field1815[var1];
            if(-var3 > super.field1465) {
               super.field1465 = -var3;
            }

            if(var3 > this.field1836) {
               this.field1836 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1827) {
               this.field1827 = var5;
            }
         }

         this.field1827 = (int)(Math.sqrt((double)this.field1827) + 0.99D);
         this.field1866 = (int)(Math.sqrt((double)(this.field1827 * this.field1827 + super.field1465 * super.field1465)) + 0.99D);
         this.field1850 = this.field1866 + (int)(Math.sqrt((double)(this.field1827 * this.field1827 + this.field1836 * this.field1836)) + 0.99D);
      }
   }

   @ObfuscatedName("n")
   final boolean method2288(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      return var2 < var3 && var2 < var4 && var2 < var5?false:(var2 > var3 && var2 > var4 && var2 > var5?false:(var1 < var6 && var1 < var7 && var1 < var8?false:var1 <= var6 || var1 <= var7 || var1 <= var8));
   }

   @ObfuscatedName("b")
   public int method2289() {
      this.method2287();
      return this.field1827;
   }

   @ObfuscatedName("k")
   public void method2290(class103 var1, int var2) {
      if(this.field1859 != null) {
         if(var2 != -1) {
            class88 var3 = var1.field1778[var2];
            class102 var4 = var3.field1548;
            field1860 = 0;
            field1861 = 0;
            field1862 = 0;

            for(int var5 = 0; var5 < var3.field1547; ++var5) {
               int var6 = var3.field1545[var5];
               this.method2292(var4.field1773[var6], var4.field1771[var6], var3.field1551[var5], var3.field1544[var5], var3.field1553[var5]);
            }

            this.field1810 = 0;
         }
      }
   }

   @ObfuscatedName("l")
   void method2292(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1860 = 0;
         field1861 = 0;
         field1862 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var18 = var2[var8];
            if(var18 < this.field1859.length) {
               int[] var19 = this.field1859[var18];

               for(var11 = 0; var11 < var19.length; ++var11) {
                  var12 = var19[var11];
                  field1860 += this.field1813[var12];
                  field1861 += this.field1839[var12];
                  field1862 += this.field1815[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1860 = field1860 / var7 + var3;
            field1861 = field1861 / var7 + var4;
            field1862 = field1862 / var7 + var5;
         } else {
            field1860 = var3;
            field1861 = var4;
            field1862 = var5;
         }

      } else {
         int[] var9;
         int var10;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1859.length) {
                  var9 = this.field1859[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.field1813[var11] += var3;
                     this.field1839[var11] += var4;
                     this.field1815[var11] += var5;
                  }
               }
            }

         } else if(var1 == 2) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1859.length) {
                  var9 = this.field1859[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.field1813[var11] -= field1860;
                     this.field1839[var11] -= field1861;
                     this.field1815[var11] -= field1862;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1868[var14];
                        var16 = field1869[var14];
                        var17 = this.field1839[var11] * var15 + this.field1813[var11] * var16 >> 16;
                        this.field1839[var11] = this.field1839[var11] * var16 - this.field1813[var11] * var15 >> 16;
                        this.field1813[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1868[var12];
                        var16 = field1869[var12];
                        var17 = this.field1839[var11] * var16 - this.field1815[var11] * var15 >> 16;
                        this.field1815[var11] = this.field1839[var11] * var15 + this.field1815[var11] * var16 >> 16;
                        this.field1839[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1868[var13];
                        var16 = field1869[var13];
                        var17 = this.field1815[var11] * var15 + this.field1813[var11] * var16 >> 16;
                        this.field1815[var11] = this.field1815[var11] * var16 - this.field1813[var11] * var15 >> 16;
                        this.field1813[var11] = var17;
                     }

                     this.field1813[var11] += field1860;
                     this.field1839[var11] += field1861;
                     this.field1815[var11] += field1862;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1859.length) {
                  var9 = this.field1859[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.field1813[var11] -= field1860;
                     this.field1839[var11] -= field1861;
                     this.field1815[var11] -= field1862;
                     this.field1813[var11] = this.field1813[var11] * var3 / 128;
                     this.field1839[var11] = this.field1839[var11] * var4 / 128;
                     this.field1815[var11] = this.field1815[var11] * var5 / 128;
                     this.field1813[var11] += field1860;
                     this.field1839[var11] += field1861;
                     this.field1815[var11] += field1862;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1833 != null && this.field1824 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1833.length) {
                     var9 = this.field1833[var8];

                     for(var10 = 0; var10 < var9.length; ++var10) {
                        var11 = var9[var10];
                        var12 = (this.field1824[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1824[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("r")
   public void method2293() {
      for(int var1 = 0; var1 < this.field1812; ++var1) {
         int var2 = this.field1813[var1];
         this.field1813[var1] = this.field1815[var1];
         this.field1815[var1] = -var2;
      }

      this.field1810 = 0;
   }

   @ObfuscatedName("e")
   public void method2295() {
      for(int var1 = 0; var1 < this.field1812; ++var1) {
         int var2 = this.field1815[var1];
         this.field1815[var1] = this.field1813[var1];
         this.field1813[var1] = -var2;
      }

      this.field1810 = 0;
   }

   @ObfuscatedName("h")
   public void method2296(int var1) {
      int var2 = field1868[var1];
      int var3 = field1869[var1];

      for(int var4 = 0; var4 < this.field1812; ++var4) {
         int var5 = this.field1839[var4] * var3 - this.field1815[var4] * var2 >> 16;
         this.field1815[var4] = this.field1839[var4] * var2 + this.field1815[var4] * var3 >> 16;
         this.field1839[var4] = var5;
      }

      this.field1810 = 0;
   }

   @ObfuscatedName("z")
   public void method2297(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1812; ++var4) {
         this.field1813[var4] += var1;
         this.field1839[var4] += var2;
         this.field1815[var4] += var3;
      }

      this.field1810 = 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "0"
   )
   public final void method2299(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1852[0] = -1;
      if(this.field1810 != 2 && this.field1810 != 1) {
         this.method2307();
      }

      int var8 = class91.field1583;
      int var9 = class91.field1584;
      int var10000 = field1868[var1];
      var10000 = field1869[var1];
      int var12 = field1868[var2];
      int var13 = field1869[var2];
      int var14 = field1868[var3];
      int var15 = field1869[var3];
      int var16 = field1868[var4];
      int var17 = field1869[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1812; ++var19) {
         int var20 = this.field1813[var19];
         int var21 = this.field1839[var19];
         int var22 = this.field1815[var19];
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
         field1819[var19] = var22 - var18;
         field1843[var19] = var8 + var20 * class91.field1587 / var22;
         field1844[var19] = var9 + var23 * class91.field1587 / var22;
         if(this.field1828 > 0) {
            field1851[var19] = var20;
            field1829[var19] = var23;
            field1848[var19] = var22;
         }
      }

      try {
         this.method2302(false, false, 0);
      } catch (Exception var24) {
         ;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "0"
   )
   public final void method2300(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1852[0] = -1;
      if(this.field1810 != 2 && this.field1810 != 1) {
         this.method2307();
      }

      int var9 = class91.field1583;
      int var10 = class91.field1584;
      int var10000 = field1868[var1];
      var10000 = field1869[var1];
      int var13 = field1868[var2];
      int var14 = field1869[var2];
      int var15 = field1868[var3];
      int var16 = field1869[var3];
      int var17 = field1868[var4];
      int var18 = field1869[var4];
      int var19 = var6 * var17 + var7 * var18 >> 16;

      for(int var20 = 0; var20 < this.field1812; ++var20) {
         int var21 = this.field1813[var20];
         int var22 = this.field1839[var20];
         int var23 = this.field1815[var20];
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
         field1819[var20] = var23 - var19;
         field1843[var20] = var9 + var21 * class91.field1587 / var8;
         field1844[var20] = var10 + var24 * class91.field1587 / var8;
         if(this.field1828 > 0) {
            field1851[var20] = var21;
            field1829[var20] = var24;
            field1848[var20] = var23;
         }
      }

      try {
         this.method2302(false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("a")
   public void method2301(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1812; ++var4) {
         this.field1813[var4] = this.field1813[var4] * var1 / 128;
         this.field1839[var4] = this.field1839[var4] * var2 / 128;
         this.field1815[var4] = this.field1815[var4] * var3 / 128;
      }

      this.field1810 = 0;
   }

   @ObfuscatedName("y")
   final void method2302(boolean var1, boolean var2, int var3) {
      if(this.field1850 < 1600) {
         int var4;
         for(var4 = 0; var4 < this.field1850; ++var4) {
            field1852[var4] = 0;
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
         for(var4 = 0; var4 < this.field1830; ++var4) {
            if(this.field1832[var4] != -2) {
               var5 = this.field1817[var4];
               var6 = this.field1818[var4];
               var7 = this.field1809[var4];
               var8 = field1843[var5];
               var9 = field1843[var6];
               var10 = field1843[var7];
               int var11;
               if(!var1 || var8 != -5000 && var9 != -5000 && var10 != -5000) {
                  if(var2 && this.method2288(field1864, field1865, field1844[var5], field1844[var6], field1844[var7], var8, var9, var10)) {
                     field1867[field1808++] = var3;
                     var2 = false;
                  }

                  if((var8 - var9) * (field1844[var7] - field1844[var6]) - (field1844[var5] - field1844[var6]) * (var10 - var9) > 0) {
                     field1842[var4] = false;
                     if(var8 >= 0 && var9 >= 0 && var10 >= 0 && var8 <= class91.field1589 && var9 <= class91.field1589 && var10 <= class91.field1589) {
                        field1841[var4] = false;
                     } else {
                        field1841[var4] = true;
                     }

                     var11 = (field1819[var5] + field1819[var6] + field1819[var7]) / 3 + this.field1866;
                     field1838[var11][field1852[var11]++] = var4;
                  }
               } else {
                  var11 = field1851[var5];
                  var12 = field1851[var6];
                  var13 = field1851[var7];
                  int var14 = field1829[var5];
                  var15 = field1829[var6];
                  int var16 = field1829[var7];
                  int var17 = field1848[var5];
                  int var18 = field1848[var6];
                  int var19 = field1848[var7];
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
                     field1842[var4] = true;
                     int var23 = (field1819[var5] + field1819[var6] + field1819[var7]) / 3 + this.field1866;
                     field1838[var23][field1852[var23]++] = var4;
                  }
               }
            }
         }

         int[] var24;
         if(this.field1823 == null) {
            for(var4 = this.field1850 - 1; var4 >= 0; --var4) {
               var5 = field1852[var4];
               if(var5 > 0) {
                  var24 = field1838[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     this.method2350(var24[var7]);
                  }
               }
            }

         } else {
            for(var4 = 0; var4 < 12; ++var4) {
               field1816[var4] = 0;
               field1814[var4] = 0;
            }

            for(var4 = this.field1850 - 1; var4 >= 0; --var4) {
               var5 = field1852[var4];
               if(var5 > 0) {
                  var24 = field1838[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     var8 = var24[var7];
                     byte var25 = this.field1823[var8];
                     var10 = field1816[var25]++;
                     field1856[var25][var10] = var8;
                     if(var25 < 10) {
                        field1814[var25] += var4;
                     } else if(var25 == 10) {
                        field1854[var10] = var4;
                     } else {
                        field1855[var10] = var4;
                     }
                  }
               }
            }

            var4 = 0;
            if(field1816[1] > 0 || field1816[2] > 0) {
               var4 = (field1814[1] + field1814[2]) / (field1816[1] + field1816[2]);
            }

            var5 = 0;
            if(field1816[3] > 0 || field1816[4] > 0) {
               var5 = (field1814[3] + field1814[4]) / (field1816[3] + field1816[4]);
            }

            var6 = 0;
            if(field1816[6] > 0 || field1816[8] > 0) {
               var6 = (field1814[6] + field1814[8]) / (field1816[6] + field1816[8]);
            }

            var8 = 0;
            var9 = field1816[10];
            int[] var26 = field1856[10];
            int[] var27 = field1854;
            if(var8 == var9) {
               var8 = 0;
               var9 = field1816[11];
               var26 = field1856[11];
               var27 = field1855;
            }

            if(var8 < var9) {
               var7 = var27[var8];
            } else {
               var7 = -1000;
            }

            for(var12 = 0; var12 < 10; ++var12) {
               while(var12 == 0 && var7 > var4) {
                  this.method2350(var26[var8++]);
                  if(var8 == var9 && var26 != field1856[11]) {
                     var8 = 0;
                     var9 = field1816[11];
                     var26 = field1856[11];
                     var27 = field1855;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 3 && var7 > var5) {
                  this.method2350(var26[var8++]);
                  if(var8 == var9 && var26 != field1856[11]) {
                     var8 = 0;
                     var9 = field1816[11];
                     var26 = field1856[11];
                     var27 = field1855;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 5 && var7 > var6) {
                  this.method2350(var26[var8++]);
                  if(var8 == var9 && var26 != field1856[11]) {
                     var8 = 0;
                     var9 = field1816[11];
                     var26 = field1856[11];
                     var27 = field1855;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               var13 = field1816[var12];
               int[] var28 = field1856[var12];

               for(var15 = 0; var15 < var13; ++var15) {
                  this.method2350(var28[var15]);
               }
            }

            while(var7 != -1000) {
               this.method2350(var26[var8++]);
               if(var8 == var9 && var26 != field1856[11]) {
                  var8 = 0;
                  var26 = field1856[11];
                  var9 = field1816[11];
                  var27 = field1855;
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

   @ObfuscatedName("c")
   public void method2305(class103 var1, int var2, class103 var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            class88 var6 = var1.field1778[var2];
            class88 var7 = var3.field1778[var4];
            class102 var8 = var6.field1548;
            field1860 = 0;
            field1861 = 0;
            field1862 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1547; ++var11) {
               for(var12 = var6.field1545[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field1773[var12] == 0) {
                  this.method2292(var8.field1773[var12], var8.field1771[var12], var6.field1551[var11], var6.field1544[var11], var6.field1553[var11]);
               }
            }

            field1860 = 0;
            field1861 = 0;
            field1862 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1547; ++var11) {
               for(var12 = var7.field1545[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field1773[var12] == 0) {
                  this.method2292(var8.field1773[var12], var8.field1771[var12], var7.field1551[var11], var7.field1544[var11], var7.field1553[var11]);
               }
            }

            this.field1810 = 0;
         } else {
            this.method2290(var1, var2);
         }
      }
   }

   static {
      field1868 = class91.field1596;
      field1869 = class91.field1597;
      field1870 = class91.field1580;
      field1871 = class91.field1595;
   }

   @ObfuscatedName("o")
   void method2307() {
      if(this.field1810 != 2) {
         this.field1810 = 2;
         this.field1827 = 0;

         for(int var1 = 0; var1 < this.field1812; ++var1) {
            int var2 = this.field1813[var1];
            int var3 = this.field1839[var1];
            int var4 = this.field1815[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1827) {
               this.field1827 = var5;
            }
         }

         this.field1827 = (int)(Math.sqrt((double)this.field1827) + 0.99D);
         this.field1866 = this.field1827;
         this.field1850 = this.field1827 + this.field1827;
      }
   }

   @ObfuscatedName("v")
   void vmethod2318(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1852[0] = -1;
      if(this.field1810 != 1) {
         this.method2287();
      }

      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1827 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1827) * class91.field1587;
         if(var15 / var13 < class91.field1576) {
            int var16 = (var14 + this.field1827) * class91.field1587;
            if(var16 / var13 > class91.field1582) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1827 * var2 >> 16;
               int var19 = (var17 + var18) * class91.field1587;
               if(var19 / var13 > class91.field1573) {
                  int var20 = var18 + (super.field1465 * var3 >> 16);
                  int var21 = (var17 - var20) * class91.field1587;
                  if(var21 / var13 < class91.field1590) {
                     int var22 = var12 + (super.field1465 * var2 >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1828 > 0;
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

                        var28 = field1864 - class91.field1583;
                        var29 = field1865 - class91.field1584;
                        if(var28 > var15 && var28 < var16 && var29 > var21 && var29 < var19) {
                           if(this.field1834) {
                              field1867[field1808++] = var9;
                           } else {
                              var26 = true;
                           }
                        }
                     }

                     var27 = class91.field1583;
                     var28 = class91.field1584;
                     var29 = 0;
                     int var30 = 0;
                     if(var1 != 0) {
                        var29 = field1868[var1];
                        var30 = field1869[var1];
                     }

                     for(int var31 = 0; var31 < this.field1812; ++var31) {
                        int var32 = this.field1813[var31];
                        int var33 = this.field1839[var31];
                        int var34 = this.field1815[var31];
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
                        field1819[var31] = var34 - var11;
                        if(var34 >= 50) {
                           field1843[var31] = var27 + var32 * class91.field1587 / var34;
                           field1844[var31] = var28 + var35 * class91.field1587 / var34;
                        } else {
                           field1843[var31] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1851[var31] = var32;
                           field1829[var31] = var35;
                           field1848[var31] = var34;
                        }
                     }

                     try {
                        this.method2302(var23, var26, var9);
                     } catch (Exception var36) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("q")
   final void method2333(int var1) {
      int var2 = class91.field1583;
      int var3 = class91.field1584;
      int var4 = 0;
      int var5 = this.field1817[var1];
      int var6 = this.field1818[var1];
      int var7 = this.field1809[var1];
      int var8 = field1848[var5];
      int var9 = field1848[var6];
      int var10 = field1848[var7];
      if(this.field1824 == null) {
         class91.field1577 = 0;
      } else {
         class91.field1577 = this.field1824[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1857[var4] = field1843[var5];
         field1858[var4] = field1844[var5];
         field1847[var4++] = this.field1820[var1];
      } else {
         var11 = field1851[var5];
         var12 = field1829[var5];
         var13 = this.field1820[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1871[var10 - var8];
            field1857[var4] = var2 + (var11 + ((field1851[var7] - var11) * var14 >> 16)) * class91.field1587 / 50;
            field1858[var4] = var3 + (var12 + ((field1829[var7] - var12) * var14 >> 16)) * class91.field1587 / 50;
            field1847[var4++] = var13 + ((this.field1832[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1871[var9 - var8];
            field1857[var4] = var2 + (var11 + ((field1851[var6] - var11) * var14 >> 16)) * class91.field1587 / 50;
            field1858[var4] = var3 + (var12 + ((field1829[var6] - var12) * var14 >> 16)) * class91.field1587 / 50;
            field1847[var4++] = var13 + ((this.field1821[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1857[var4] = field1843[var6];
         field1858[var4] = field1844[var6];
         field1847[var4++] = this.field1821[var1];
      } else {
         var11 = field1851[var6];
         var12 = field1829[var6];
         var13 = this.field1821[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1871[var8 - var9];
            field1857[var4] = var2 + (var11 + ((field1851[var5] - var11) * var14 >> 16)) * class91.field1587 / 50;
            field1858[var4] = var3 + (var12 + ((field1829[var5] - var12) * var14 >> 16)) * class91.field1587 / 50;
            field1847[var4++] = var13 + ((this.field1820[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1871[var10 - var9];
            field1857[var4] = var2 + (var11 + ((field1851[var7] - var11) * var14 >> 16)) * class91.field1587 / 50;
            field1858[var4] = var3 + (var12 + ((field1829[var7] - var12) * var14 >> 16)) * class91.field1587 / 50;
            field1847[var4++] = var13 + ((this.field1832[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1857[var4] = field1843[var7];
         field1858[var4] = field1844[var7];
         field1847[var4++] = this.field1832[var1];
      } else {
         var11 = field1851[var7];
         var12 = field1829[var7];
         var13 = this.field1832[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1871[var9 - var10];
            field1857[var4] = var2 + (var11 + ((field1851[var6] - var11) * var14 >> 16)) * class91.field1587 / 50;
            field1858[var4] = var3 + (var12 + ((field1829[var6] - var12) * var14 >> 16)) * class91.field1587 / 50;
            field1847[var4++] = var13 + ((this.field1821[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1871[var8 - var10];
            field1857[var4] = var2 + (var11 + ((field1851[var5] - var11) * var14 >> 16)) * class91.field1587 / 50;
            field1858[var4] = var3 + (var12 + ((field1829[var5] - var12) * var14 >> 16)) * class91.field1587 / 50;
            field1847[var4++] = var13 + ((this.field1820[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1857[0];
      var12 = field1857[1];
      var13 = field1857[2];
      var14 = field1858[0];
      int var15 = field1858[1];
      int var16 = field1858[2];
      class91.field1579 = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class91.field1589 || var12 > class91.field1589 || var13 > class91.field1589) {
            class91.field1579 = true;
         }

         if(this.field1846 != null && this.field1846[var1] != -1) {
            if(this.field1825 != null && this.field1825[var1] != -1) {
               var20 = this.field1825[var1] & 255;
               var17 = this.field1826[var20];
               var18 = this.field1837[var20];
               var19 = this.field1831[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1832[var1] == -1) {
               class91.method2120(var14, var15, var16, var11, var12, var13, this.field1820[var1], this.field1820[var1], this.field1820[var1], field1851[var17], field1851[var18], field1851[var19], field1829[var17], field1829[var18], field1829[var19], field1848[var17], field1848[var18], field1848[var19], this.field1846[var1]);
            } else {
               class91.method2120(var14, var15, var16, var11, var12, var13, field1847[0], field1847[1], field1847[2], field1851[var17], field1851[var18], field1851[var19], field1829[var17], field1829[var18], field1829[var19], field1848[var17], field1848[var18], field1848[var19], this.field1846[var1]);
            }
         } else if(this.field1832[var1] == -1) {
            class91.method2090(var14, var15, var16, var11, var12, var13, field1870[this.field1820[var1]]);
         } else {
            class91.method2119(var14, var15, var16, var11, var12, var13, field1847[0], field1847[1], field1847[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class91.field1589 || var12 > class91.field1589 || var13 > class91.field1589 || field1857[3] < 0 || field1857[3] > class91.field1589) {
            class91.field1579 = true;
         }

         if(this.field1846 != null && this.field1846[var1] != -1) {
            if(this.field1825 != null && this.field1825[var1] != -1) {
               var20 = this.field1825[var1] & 255;
               var17 = this.field1826[var20];
               var18 = this.field1837[var20];
               var19 = this.field1831[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1846[var1];
            if(this.field1832[var1] == -1) {
               class91.method2120(var14, var15, var16, var11, var12, var13, this.field1820[var1], this.field1820[var1], this.field1820[var1], field1851[var17], field1851[var18], field1851[var19], field1829[var17], field1829[var18], field1829[var19], field1848[var17], field1848[var18], field1848[var19], var21);
               class91.method2120(var14, var16, field1858[3], var11, var13, field1857[3], this.field1820[var1], this.field1820[var1], this.field1820[var1], field1851[var17], field1851[var18], field1851[var19], field1829[var17], field1829[var18], field1829[var19], field1848[var17], field1848[var18], field1848[var19], var21);
            } else {
               class91.method2120(var14, var15, var16, var11, var12, var13, field1847[0], field1847[1], field1847[2], field1851[var17], field1851[var18], field1851[var19], field1829[var17], field1829[var18], field1829[var19], field1848[var17], field1848[var18], field1848[var19], var21);
               class91.method2120(var14, var16, field1858[3], var11, var13, field1857[3], field1847[0], field1847[2], field1847[3], field1851[var17], field1851[var18], field1851[var19], field1829[var17], field1829[var18], field1829[var19], field1848[var17], field1848[var18], field1848[var19], var21);
            }
         } else if(this.field1832[var1] == -1) {
            var17 = field1870[this.field1820[var1]];
            class91.method2090(var14, var15, var16, var11, var12, var13, var17);
            class91.method2090(var14, var16, field1858[3], var11, var13, field1857[3], var17);
         } else {
            class91.method2119(var14, var15, var16, var11, var12, var13, field1847[0], field1847[1], field1847[2]);
            class91.method2119(var14, var16, field1858[3], var11, var13, field1857[3], field1847[0], field1847[2], field1847[3]);
         }
      }

   }

   @ObfuscatedName("m")
   public void method2339() {
      for(int var1 = 0; var1 < this.field1812; ++var1) {
         this.field1813[var1] = -this.field1813[var1];
         this.field1815[var1] = -this.field1815[var1];
      }

      this.field1810 = 0;
   }

   class105() {
   }

   @ObfuscatedName("f")
   final void method2350(int var1) {
      if(field1842[var1]) {
         this.method2333(var1);
      } else {
         int var2 = this.field1817[var1];
         int var3 = this.field1818[var1];
         int var4 = this.field1809[var1];
         class91.field1579 = field1841[var1];
         if(this.field1824 == null) {
            class91.field1577 = 0;
         } else {
            class91.field1577 = this.field1824[var1] & 255;
         }

         if(this.field1846 != null && this.field1846[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1825 != null && this.field1825[var1] != -1) {
               int var8 = this.field1825[var1] & 255;
               var5 = this.field1826[var8];
               var6 = this.field1837[var8];
               var7 = this.field1831[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1832[var1] == -1) {
               class91.method2120(field1844[var2], field1844[var3], field1844[var4], field1843[var2], field1843[var3], field1843[var4], this.field1820[var1], this.field1820[var1], this.field1820[var1], field1851[var5], field1851[var6], field1851[var7], field1829[var5], field1829[var6], field1829[var7], field1848[var5], field1848[var6], field1848[var7], this.field1846[var1]);
            } else {
               class91.method2120(field1844[var2], field1844[var3], field1844[var4], field1843[var2], field1843[var3], field1843[var4], this.field1820[var1], this.field1821[var1], this.field1832[var1], field1851[var5], field1851[var6], field1851[var7], field1829[var5], field1829[var6], field1829[var7], field1848[var5], field1848[var6], field1848[var7], this.field1846[var1]);
            }
         } else if(this.field1832[var1] == -1) {
            class91.method2090(field1844[var2], field1844[var3], field1844[var4], field1843[var2], field1843[var3], field1843[var4], field1870[this.field1820[var1]]);
         } else {
            class91.method2119(field1844[var2], field1844[var3], field1844[var4], field1843[var2], field1843[var3], field1843[var4], this.field1820[var1], this.field1821[var1], this.field1832[var1]);
         }

      }
   }

   @ObfuscatedSignature(
      signature = "([Lclass105;I)V",
      garbageValue = "2"
   )
   public class105(class105[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1812 = 0;
      this.field1830 = 0;
      this.field1828 = 0;
      this.field1853 = -1;

      int var7;
      class105 var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1812 += var8.field1812;
            this.field1830 += var8.field1830;
            this.field1828 += var8.field1828;
            if(var8.field1823 != null) {
               var3 = true;
            } else {
               if(this.field1853 == -1) {
                  this.field1853 = var8.field1853;
               }

               if(this.field1853 != var8.field1853) {
                  var3 = true;
               }
            }

            var4 |= var8.field1824 != null;
            var5 |= var8.field1846 != null;
            var6 |= var8.field1825 != null;
         }
      }

      this.field1813 = new int[this.field1812];
      this.field1839 = new int[this.field1812];
      this.field1815 = new int[this.field1812];
      this.field1817 = new int[this.field1830];
      this.field1818 = new int[this.field1830];
      this.field1809 = new int[this.field1830];
      this.field1820 = new int[this.field1830];
      this.field1821 = new int[this.field1830];
      this.field1832 = new int[this.field1830];
      if(var3) {
         this.field1823 = new byte[this.field1830];
      }

      if(var4) {
         this.field1824 = new byte[this.field1830];
      }

      if(var5) {
         this.field1846 = new short[this.field1830];
      }

      if(var6) {
         this.field1825 = new byte[this.field1830];
      }

      if(this.field1828 > 0) {
         this.field1826 = new int[this.field1828];
         this.field1837 = new int[this.field1828];
         this.field1831 = new int[this.field1828];
      }

      this.field1812 = 0;
      this.field1830 = 0;
      this.field1828 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1830; ++var9) {
               this.field1817[this.field1830] = var8.field1817[var9] + this.field1812;
               this.field1818[this.field1830] = var8.field1818[var9] + this.field1812;
               this.field1809[this.field1830] = var8.field1809[var9] + this.field1812;
               this.field1820[this.field1830] = var8.field1820[var9];
               this.field1821[this.field1830] = var8.field1821[var9];
               this.field1832[this.field1830] = var8.field1832[var9];
               if(var3) {
                  if(var8.field1823 != null) {
                     this.field1823[this.field1830] = var8.field1823[var9];
                  } else {
                     this.field1823[this.field1830] = var8.field1853;
                  }
               }

               if(var4 && var8.field1824 != null) {
                  this.field1824[this.field1830] = var8.field1824[var9];
               }

               if(var5) {
                  if(var8.field1846 != null) {
                     this.field1846[this.field1830] = var8.field1846[var9];
                  } else {
                     this.field1846[this.field1830] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1825 != null && var8.field1825[var9] != -1) {
                     this.field1825[this.field1830] = (byte)(var8.field1825[var9] + this.field1828);
                  } else {
                     this.field1825[this.field1830] = -1;
                  }
               }

               ++this.field1830;
            }

            for(var9 = 0; var9 < var8.field1828; ++var9) {
               this.field1826[this.field1828] = var8.field1826[var9] + this.field1812;
               this.field1837[this.field1828] = var8.field1837[var9] + this.field1812;
               this.field1831[this.field1828] = var8.field1831[var9] + this.field1812;
               ++this.field1828;
            }

            for(var9 = 0; var9 < var8.field1812; ++var9) {
               this.field1813[this.field1812] = var8.field1813[var9];
               this.field1839[this.field1812] = var8.field1839[var9];
               this.field1815[this.field1812] = var8.field1815[var9];
               ++this.field1812;
            }
         }
      }

   }
}
