import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
@Implements("Model")
public class class105 extends class85 {
   @ObfuscatedName("bw")
   static int[] field1809;
   @ObfuscatedName("x")
   static byte[] field1810 = new byte[1];
   @ObfuscatedName("t")
   static class105 field1811 = new class105();
   @ObfuscatedName("p")
   static byte[] field1812 = new byte[1];
   @ObfuscatedName("e")
   int field1813 = 0;
   @ObfuscatedName("f")
   int[] field1814;
   @ObfuscatedName("m")
   int[] field1815;
   @ObfuscatedName("c")
   int[] field1816;
   @ObfuscatedName("v")
   int field1817 = 0;
   @ObfuscatedName("l")
   int[] field1818;
   @ObfuscatedName("z")
   int[] field1819;
   @ObfuscatedName("s")
   int[] field1820;
   @ObfuscatedName("ak")
   static int[][] field1821 = new int[1600][512];
   @ObfuscatedName("q")
   int[] field1822;
   @ObfuscatedName("ar")
   int field1823;
   @ObfuscatedName("bm")
   static int[] field1824;
   @ObfuscatedName("aa")
   static int[] field1825 = new int[10];
   @ObfuscatedName("i")
   byte[] field1826;
   @ObfuscatedName("az")
   static int[] field1827 = new int[4700];
   @ObfuscatedName("h")
   byte field1828 = 0;
   @ObfuscatedName("aw")
   static int[][] field1829 = new int[12][2000];
   @ObfuscatedName("u")
   byte[] field1830;
   @ObfuscatedName("r")
   int[] field1831;
   @ObfuscatedName("at")
   static int[] field1832 = new int[12];
   @ObfuscatedName("g")
   int[][] field1833;
   @ObfuscatedName("b")
   int[][] field1834;
   @ObfuscatedName("aq")
   static int[] field1835 = new int[2000];
   @ObfuscatedName("am")
   int field1836;
   @ObfuscatedName("ag")
   static int[] field1837 = new int[4700];
   @ObfuscatedName("y")
   int[] field1838;
   @ObfuscatedName("ai")
   int field1839;
   @ObfuscatedName("ab")
   int field1840;
   @ObfuscatedName("ac")
   static boolean[] field1842 = new boolean[4700];
   @ObfuscatedName("ah")
   static boolean[] field1843 = new boolean[4700];
   @ObfuscatedName("ae")
   static int[] field1844 = new int[4700];
   @ObfuscatedName("aj")
   static int[] field1845 = new int[4700];
   @ObfuscatedName("a")
   int[] field1846;
   @ObfuscatedName("al")
   static int[] field1847 = new int[4700];
   @ObfuscatedName("n")
   int[] field1848;
   @ObfuscatedName("ad")
   static int[] field1849 = new int[4700];
   @ObfuscatedName("ao")
   static int[] field1851 = new int[1600];
   @ObfuscatedName("bg")
   public static int field1852 = 0;
   @ObfuscatedName("ay")
   int field1853;
   @ObfuscatedName("bz")
   static int[] field1854;
   @ObfuscatedName("as")
   static int[] field1855 = new int[2000];
   @ObfuscatedName("o")
   short[] field1856;
   @ObfuscatedName("j")
   int[] field1857;
   @ObfuscatedName("an")
   static int[] field1858 = new int[10];
   @ObfuscatedName("bi")
   public static int[] field1859 = new int[1000];
   @ObfuscatedName("ap")
   static int[] field1860 = new int[10];
   @ObfuscatedName("bd")
   static int field1861;
   @ObfuscatedName("bb")
   static int field1862;
   @ObfuscatedName("bo")
   static int field1863;
   @ObfuscatedName("bf")
   public static boolean field1864 = false;
   @ObfuscatedName("bp")
   public static int field1865 = 0;
   @ObfuscatedName("bn")
   public static int field1866 = 0;
   @ObfuscatedName("k")
   int field1867 = 0;
   @ObfuscatedName("w")
   static class105 field1868 = new class105();
   @ObfuscatedName("d")
   byte[] field1869;
   @ObfuscatedName("af")
   public boolean field1870 = false;
   @ObfuscatedName("ax")
   static int[] field1871 = new int[12];
   @ObfuscatedName("bh")
   static int[] field1872;

   @ObfuscatedName("e")
   class105 method2298(boolean var1, class105 var2, byte[] var3) {
      var2.field1813 = this.field1813;
      var2.field1817 = this.field1817;
      var2.field1867 = this.field1867;
      if(var2.field1838 == null || var2.field1838.length < this.field1813) {
         var2.field1838 = new int[this.field1813 + 100];
         var2.field1815 = new int[this.field1813 + 100];
         var2.field1816 = new int[this.field1813 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1813; ++var4) {
         var2.field1838[var4] = this.field1838[var4];
         var2.field1815[var4] = this.field1815[var4];
         var2.field1816[var4] = this.field1816[var4];
      }

      if(var1) {
         var2.field1830 = this.field1830;
      } else {
         var2.field1830 = var3;
         if(this.field1830 == null) {
            for(var4 = 0; var4 < this.field1817; ++var4) {
               var2.field1830[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1817; ++var4) {
               var2.field1830[var4] = this.field1830[var4];
            }
         }
      }

      var2.field1818 = this.field1818;
      var2.field1819 = this.field1819;
      var2.field1820 = this.field1820;
      var2.field1857 = this.field1857;
      var2.field1822 = this.field1822;
      var2.field1846 = this.field1846;
      var2.field1869 = this.field1869;
      var2.field1826 = this.field1826;
      var2.field1856 = this.field1856;
      var2.field1828 = this.field1828;
      var2.field1814 = this.field1814;
      var2.field1831 = this.field1831;
      var2.field1848 = this.field1848;
      var2.field1833 = this.field1833;
      var2.field1834 = this.field1834;
      var2.field1870 = this.field1870;
      var2.field1836 = 0;
      return var2;
   }

   @ObfuscatedName("w")
   public class105 method2300(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2323();
      int var7 = var2 - this.field1853;
      int var8 = var2 + this.field1853;
      int var9 = var4 - this.field1853;
      int var10 = var4 + this.field1853;
      if(var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
         var7 >>= 7;
         var8 = var8 + 127 >> 7;
         var9 >>= 7;
         var10 = var10 + 127 >> 7;
         if(var1[var7][var9] == var3 && var1[var8][var9] == var3 && var1[var7][var10] == var3 && var1[var8][var10] == var3) {
            return this;
         } else {
            class105 var11;
            if(var5) {
               var11 = new class105();
               var11.field1813 = this.field1813;
               var11.field1817 = this.field1817;
               var11.field1867 = this.field1867;
               var11.field1838 = this.field1838;
               var11.field1816 = this.field1816;
               var11.field1818 = this.field1818;
               var11.field1819 = this.field1819;
               var11.field1820 = this.field1820;
               var11.field1857 = this.field1857;
               var11.field1822 = this.field1822;
               var11.field1846 = this.field1846;
               var11.field1869 = this.field1869;
               var11.field1830 = this.field1830;
               var11.field1826 = this.field1826;
               var11.field1856 = this.field1856;
               var11.field1828 = this.field1828;
               var11.field1814 = this.field1814;
               var11.field1831 = this.field1831;
               var11.field1848 = this.field1848;
               var11.field1833 = this.field1833;
               var11.field1834 = this.field1834;
               var11.field1870 = this.field1870;
               var11.field1815 = new int[var11.field1813];
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
               for(var12 = 0; var12 < var11.field1813; ++var12) {
                  var13 = this.field1838[var12] + var2;
                  var14 = this.field1816[var12] + var4;
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var1[var17 + 1][var18 + 1] * var15 >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.field1815[var12] = this.field1815[var12] + var21 - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1813; ++var12) {
                  var13 = (-this.field1815[var12] << 16) / super.field1467;
                  if(var13 < var6) {
                     var14 = this.field1838[var12] + var2;
                     var15 = this.field1816[var12] + var4;
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var1[var18 + 1][var19 + 1] * var16 >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.field1815[var12] = this.field1815[var12] + (var22 - var3) * (var6 - var13) / var6;
                  }
               }
            }

            var11.field1836 = 0;
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("p")
   public class105 method2302(boolean var1) {
      if(!var1 && field1812.length < this.field1817) {
         field1812 = new byte[this.field1817 + 100];
      }

      return this.method2298(var1, field1811, field1812);
   }

   @ObfuscatedName("a")
   public void method2304() {
      for(int var1 = 0; var1 < this.field1813; ++var1) {
         int var2 = this.field1816[var1];
         this.field1816[var1] = this.field1838[var1];
         this.field1838[var1] = -var2;
      }

      this.field1836 = 0;
   }

   @ObfuscatedName("m")
   void method2305() {
      if(this.field1836 != 2) {
         this.field1836 = 2;
         this.field1853 = 0;

         for(int var1 = 0; var1 < this.field1813; ++var1) {
            int var2 = this.field1838[var1];
            int var3 = this.field1815[var1];
            int var4 = this.field1816[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1853) {
               this.field1853 = var5;
            }
         }

         this.field1853 = (int)(Math.sqrt((double)this.field1853) + 0.99D);
         this.field1840 = this.field1853;
         this.field1839 = this.field1853 + this.field1853;
      }
   }

   @ObfuscatedName("c")
   public int method2306() {
      this.method2323();
      return this.field1853;
   }

   @ObfuscatedName("j")
   public void method2307() {
      for(int var1 = 0; var1 < this.field1813; ++var1) {
         this.field1838[var1] = -this.field1838[var1];
         this.field1816[var1] = -this.field1816[var1];
      }

      this.field1836 = 0;
   }

   @ObfuscatedName("l")
   public void method2308(class103 var1, int var2, class103 var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            class88 var6 = var1.field1780[var2];
            class88 var7 = var3.field1780[var4];
            class102 var8 = var6.field1547;
            field1861 = 0;
            field1862 = 0;
            field1863 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1548; ++var11) {
               for(var12 = var6.field1551[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field1779[var12] == 0) {
                  this.method2309(var8.field1779[var12], var8.field1776[var12], var6.field1550[var11], var6.field1549[var11], var6.field1544[var11]);
               }
            }

            field1861 = 0;
            field1862 = 0;
            field1863 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1548; ++var11) {
               for(var12 = var7.field1551[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field1779[var12] == 0) {
                  this.method2309(var8.field1779[var12], var8.field1776[var12], var7.field1550[var11], var7.field1549[var11], var7.field1544[var11]);
               }
            }

            this.field1836 = 0;
         } else {
            this.method2372(var1, var2);
         }
      }
   }

   @ObfuscatedName("z")
   void method2309(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1861 = 0;
         field1862 = 0;
         field1863 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var18 = var2[var8];
            if(var18 < this.field1833.length) {
               int[] var19 = this.field1833[var18];

               for(var11 = 0; var11 < var19.length; ++var11) {
                  var12 = var19[var11];
                  field1861 += this.field1838[var12];
                  field1862 += this.field1815[var12];
                  field1863 += this.field1816[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1861 = field1861 / var7 + var3;
            field1862 = field1862 / var7 + var4;
            field1863 = field1863 / var7 + var5;
         } else {
            field1861 = var3;
            field1862 = var4;
            field1863 = var5;
         }

      } else {
         int[] var9;
         int var10;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1833.length) {
                  var9 = this.field1833[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.field1838[var11] += var3;
                     this.field1815[var11] += var4;
                     this.field1816[var11] += var5;
                  }
               }
            }

         } else if(var1 == 2) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1833.length) {
                  var9 = this.field1833[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.field1838[var11] -= field1861;
                     this.field1815[var11] -= field1862;
                     this.field1816[var11] -= field1863;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1854[var14];
                        var16 = field1809[var14];
                        var17 = this.field1815[var11] * var15 + this.field1838[var11] * var16 >> 16;
                        this.field1815[var11] = this.field1815[var11] * var16 - this.field1838[var11] * var15 >> 16;
                        this.field1838[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1854[var12];
                        var16 = field1809[var12];
                        var17 = this.field1815[var11] * var16 - this.field1816[var11] * var15 >> 16;
                        this.field1816[var11] = this.field1815[var11] * var15 + this.field1816[var11] * var16 >> 16;
                        this.field1815[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1854[var13];
                        var16 = field1809[var13];
                        var17 = this.field1816[var11] * var15 + this.field1838[var11] * var16 >> 16;
                        this.field1816[var11] = this.field1816[var11] * var16 - this.field1838[var11] * var15 >> 16;
                        this.field1838[var11] = var17;
                     }

                     this.field1838[var11] += field1861;
                     this.field1815[var11] += field1862;
                     this.field1816[var11] += field1863;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1833.length) {
                  var9 = this.field1833[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.field1838[var11] -= field1861;
                     this.field1815[var11] -= field1862;
                     this.field1816[var11] -= field1863;
                     this.field1838[var11] = this.field1838[var11] * var3 / 128;
                     this.field1815[var11] = this.field1815[var11] * var4 / 128;
                     this.field1816[var11] = this.field1816[var11] * var5 / 128;
                     this.field1838[var11] += field1861;
                     this.field1815[var11] += field1862;
                     this.field1816[var11] += field1863;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1834 != null && this.field1830 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1834.length) {
                     var9 = this.field1834[var8];

                     for(var10 = 0; var10 < var9.length; ++var10) {
                        var11 = var9[var10];
                        var12 = (this.field1830[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1830[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("s")
   public void method2310() {
      for(int var1 = 0; var1 < this.field1813; ++var1) {
         int var2 = this.field1838[var1];
         this.field1838[var1] = this.field1816[var1];
         this.field1816[var1] = -var2;
      }

      this.field1836 = 0;
   }

   @ObfuscatedName("x")
   public class105 method2311(boolean var1) {
      if(!var1 && field1810.length < this.field1817) {
         field1810 = new byte[this.field1817 + 100];
      }

      return this.method2298(var1, field1868, field1810);
   }

   @ObfuscatedName("d")
   public void method2314(int var1) {
      int var2 = field1854[var1];
      int var3 = field1809[var1];

      for(int var4 = 0; var4 < this.field1813; ++var4) {
         int var5 = this.field1815[var4] * var3 - this.field1816[var4] * var2 >> 16;
         this.field1816[var4] = this.field1815[var4] * var2 + this.field1816[var4] * var3 >> 16;
         this.field1815[var4] = var5;
      }

      this.field1836 = 0;
   }

   @ObfuscatedName("i")
   public void method2315(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1813; ++var4) {
         this.field1838[var4] = this.field1838[var4] * var1 / 128;
         this.field1815[var4] = this.field1815[var4] * var2 / 128;
         this.field1816[var4] = this.field1816[var4] * var3 / 128;
      }

      this.field1836 = 0;
   }

   @ObfuscatedName("aj")
   void vmethod2318(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1851[0] = -1;
      if(this.field1836 != 1) {
         this.method2323();
      }

      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1853 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1853) * class91.field1580;
         if(var15 / var13 < class91.field1586) {
            int var16 = (var14 + this.field1853) * class91.field1580;
            if(var16 / var13 > class91.field1585) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1853 * var2 >> 16;
               int var19 = (var17 + var18) * class91.field1580;
               if(var19 / var13 > class91.field1587) {
                  int var20 = var18 + (super.field1467 * var3 >> 16);
                  int var21 = (var17 - var20) * class91.field1580;
                  if(var21 / var13 < class91.field1588) {
                     int var22 = var12 + (super.field1467 * var2 >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1867 > 0;
                     boolean var26 = false;
                     int var27;
                     int var28;
                     int var29;
                     if(var9 > 0 && field1864) {
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

                        var28 = field1865 - class91.field1592;
                        var29 = field1866 - class91.field1589;
                        if(var28 > var15 && var28 < var16 && var29 > var21 && var29 < var19) {
                           if(this.field1870) {
                              field1859[field1852++] = var9;
                           } else {
                              var26 = true;
                           }
                        }
                     }

                     var27 = class91.field1592;
                     var28 = class91.field1589;
                     var29 = 0;
                     int var30 = 0;
                     if(var1 != 0) {
                        var29 = field1854[var1];
                        var30 = field1809[var1];
                     }

                     for(int var31 = 0; var31 < this.field1813; ++var31) {
                        int var32 = this.field1838[var31];
                        int var33 = this.field1815[var31];
                        int var34 = this.field1816[var31];
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
                        field1827[var31] = var34 - var11;
                        if(var34 >= 50) {
                           field1844[var31] = var27 + var32 * class91.field1580 / var34;
                           field1845[var31] = var28 + var35 * class91.field1580 / var34;
                        } else {
                           field1844[var31] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1847[var31] = var32;
                           field1837[var31] = var35;
                           field1849[var31] = var34;
                        }
                     }

                     try {
                        this.method2319(var23, var26, var9);
                     } catch (Exception var36) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("k")
   final void method2319(boolean var1, boolean var2, int var3) {
      if(this.field1839 < 1600) {
         int var4;
         for(var4 = 0; var4 < this.field1839; ++var4) {
            field1851[var4] = 0;
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
         for(var4 = 0; var4 < this.field1817; ++var4) {
            if(this.field1846[var4] != -2) {
               var5 = this.field1818[var4];
               var6 = this.field1819[var4];
               var7 = this.field1820[var4];
               var8 = field1844[var5];
               var9 = field1844[var6];
               var10 = field1844[var7];
               int var11;
               if(var1 && (var8 == -5000 || var9 == -5000 || var10 == -5000)) {
                  var11 = field1847[var5];
                  var12 = field1847[var6];
                  var13 = field1847[var7];
                  int var14 = field1837[var5];
                  var15 = field1837[var6];
                  int var16 = field1837[var7];
                  int var17 = field1849[var5];
                  int var18 = field1849[var6];
                  int var19 = field1849[var7];
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
                     field1843[var4] = true;
                     int var23 = (field1827[var5] + field1827[var6] + field1827[var7]) / 3 + this.field1840;
                     field1821[var23][field1851[var23]++] = var4;
                  }
               } else {
                  if(var2 && this.method2322(field1865, field1866, field1845[var5], field1845[var6], field1845[var7], var8, var9, var10)) {
                     field1859[field1852++] = var3;
                     var2 = false;
                  }

                  if((var8 - var9) * (field1845[var7] - field1845[var6]) - (field1845[var5] - field1845[var6]) * (var10 - var9) > 0) {
                     field1843[var4] = false;
                     if(var8 >= 0 && var9 >= 0 && var10 >= 0 && var8 <= class91.field1583 && var9 <= class91.field1583 && var10 <= class91.field1583) {
                        field1842[var4] = false;
                     } else {
                        field1842[var4] = true;
                     }

                     var11 = (field1827[var5] + field1827[var6] + field1827[var7]) / 3 + this.field1840;
                     field1821[var11][field1851[var11]++] = var4;
                  }
               }
            }
         }

         int[] var24;
         if(this.field1869 == null) {
            for(var4 = this.field1839 - 1; var4 >= 0; --var4) {
               var5 = field1851[var4];
               if(var5 > 0) {
                  var24 = field1821[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     this.method2320(var24[var7]);
                  }
               }
            }

         } else {
            for(var4 = 0; var4 < 12; ++var4) {
               field1832[var4] = 0;
               field1871[var4] = 0;
            }

            for(var4 = this.field1839 - 1; var4 >= 0; --var4) {
               var5 = field1851[var4];
               if(var5 > 0) {
                  var24 = field1821[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     var8 = var24[var7];
                     byte var25 = this.field1869[var8];
                     var10 = field1832[var25]++;
                     field1829[var25][var10] = var8;
                     if(var25 < 10) {
                        field1871[var25] += var4;
                     } else if(var25 == 10) {
                        field1855[var10] = var4;
                     } else {
                        field1835[var10] = var4;
                     }
                  }
               }
            }

            var4 = 0;
            if(field1832[1] > 0 || field1832[2] > 0) {
               var4 = (field1871[1] + field1871[2]) / (field1832[1] + field1832[2]);
            }

            var5 = 0;
            if(field1832[3] > 0 || field1832[4] > 0) {
               var5 = (field1871[3] + field1871[4]) / (field1832[3] + field1832[4]);
            }

            var6 = 0;
            if(field1832[6] > 0 || field1832[8] > 0) {
               var6 = (field1871[6] + field1871[8]) / (field1832[6] + field1832[8]);
            }

            var8 = 0;
            var9 = field1832[10];
            int[] var26 = field1829[10];
            int[] var27 = field1855;
            if(var8 == var9) {
               var8 = 0;
               var9 = field1832[11];
               var26 = field1829[11];
               var27 = field1835;
            }

            if(var8 < var9) {
               var7 = var27[var8];
            } else {
               var7 = -1000;
            }

            for(var12 = 0; var12 < 10; ++var12) {
               while(var12 == 0 && var7 > var4) {
                  this.method2320(var26[var8++]);
                  if(var8 == var9 && var26 != field1829[11]) {
                     var8 = 0;
                     var9 = field1832[11];
                     var26 = field1829[11];
                     var27 = field1835;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 3 && var7 > var5) {
                  this.method2320(var26[var8++]);
                  if(var8 == var9 && var26 != field1829[11]) {
                     var8 = 0;
                     var9 = field1832[11];
                     var26 = field1829[11];
                     var27 = field1835;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 5 && var7 > var6) {
                  this.method2320(var26[var8++]);
                  if(var8 == var9 && var26 != field1829[11]) {
                     var8 = 0;
                     var9 = field1832[11];
                     var26 = field1829[11];
                     var27 = field1835;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               var13 = field1832[var12];
               int[] var28 = field1829[var12];

               for(var15 = 0; var15 < var13; ++var15) {
                  this.method2320(var28[var15]);
               }
            }

            while(var7 != -1000) {
               this.method2320(var26[var8++]);
               if(var8 == var9 && var26 != field1829[11]) {
                  var8 = 0;
                  var26 = field1829[11];
                  var9 = field1832[11];
                  var27 = field1835;
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

   @ObfuscatedName("f")
   final void method2320(int var1) {
      if(field1843[var1]) {
         this.method2321(var1);
      } else {
         int var2 = this.field1818[var1];
         int var3 = this.field1819[var1];
         int var4 = this.field1820[var1];
         class91.field1581 = field1842[var1];
         if(this.field1830 == null) {
            class91.field1575 = 0;
         } else {
            class91.field1575 = this.field1830[var1] & 255;
         }

         if(this.field1856 != null && this.field1856[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1826 != null && this.field1826[var1] != -1) {
               int var8 = this.field1826[var1] & 255;
               var5 = this.field1814[var8];
               var6 = this.field1831[var8];
               var7 = this.field1848[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1846[var1] == -1) {
               class91.method2096(field1845[var2], field1845[var3], field1845[var4], field1844[var2], field1844[var3], field1844[var4], this.field1857[var1], this.field1857[var1], this.field1857[var1], field1847[var5], field1847[var6], field1847[var7], field1837[var5], field1837[var6], field1837[var7], field1849[var5], field1849[var6], field1849[var7], this.field1856[var1]);
            } else {
               class91.method2096(field1845[var2], field1845[var3], field1845[var4], field1844[var2], field1844[var3], field1844[var4], this.field1857[var1], this.field1822[var1], this.field1846[var1], field1847[var5], field1847[var6], field1847[var7], field1837[var5], field1837[var6], field1837[var7], field1849[var5], field1849[var6], field1849[var7], this.field1856[var1]);
            }
         } else if(this.field1846[var1] == -1) {
            class91.method2093(field1845[var2], field1845[var3], field1845[var4], field1844[var2], field1844[var3], field1844[var4], field1824[this.field1857[var1]]);
         } else {
            class91.method2091(field1845[var2], field1845[var3], field1845[var4], field1844[var2], field1844[var3], field1844[var4], this.field1857[var1], this.field1822[var1], this.field1846[var1]);
         }

      }
   }

   @ObfuscatedName("r")
   final void method2321(int var1) {
      int var2 = class91.field1592;
      int var3 = class91.field1589;
      int var4 = 0;
      int var5 = this.field1818[var1];
      int var6 = this.field1819[var1];
      int var7 = this.field1820[var1];
      int var8 = field1849[var5];
      int var9 = field1849[var6];
      int var10 = field1849[var7];
      if(this.field1830 == null) {
         class91.field1575 = 0;
      } else {
         class91.field1575 = this.field1830[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1858[var4] = field1844[var5];
         field1825[var4] = field1845[var5];
         field1860[var4++] = this.field1857[var1];
      } else {
         var11 = field1847[var5];
         var12 = field1837[var5];
         var13 = this.field1857[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1872[var10 - var8];
            field1858[var4] = var2 + (var11 + ((field1847[var7] - var11) * var14 >> 16)) * class91.field1580 / 50;
            field1825[var4] = var3 + (var12 + ((field1837[var7] - var12) * var14 >> 16)) * class91.field1580 / 50;
            field1860[var4++] = var13 + ((this.field1846[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1872[var9 - var8];
            field1858[var4] = var2 + (var11 + ((field1847[var6] - var11) * var14 >> 16)) * class91.field1580 / 50;
            field1825[var4] = var3 + (var12 + ((field1837[var6] - var12) * var14 >> 16)) * class91.field1580 / 50;
            field1860[var4++] = var13 + ((this.field1822[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1858[var4] = field1844[var6];
         field1825[var4] = field1845[var6];
         field1860[var4++] = this.field1822[var1];
      } else {
         var11 = field1847[var6];
         var12 = field1837[var6];
         var13 = this.field1822[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1872[var8 - var9];
            field1858[var4] = var2 + (var11 + ((field1847[var5] - var11) * var14 >> 16)) * class91.field1580 / 50;
            field1825[var4] = var3 + (var12 + ((field1837[var5] - var12) * var14 >> 16)) * class91.field1580 / 50;
            field1860[var4++] = var13 + ((this.field1857[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1872[var10 - var9];
            field1858[var4] = var2 + (var11 + ((field1847[var7] - var11) * var14 >> 16)) * class91.field1580 / 50;
            field1825[var4] = var3 + (var12 + ((field1837[var7] - var12) * var14 >> 16)) * class91.field1580 / 50;
            field1860[var4++] = var13 + ((this.field1846[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1858[var4] = field1844[var7];
         field1825[var4] = field1845[var7];
         field1860[var4++] = this.field1846[var1];
      } else {
         var11 = field1847[var7];
         var12 = field1837[var7];
         var13 = this.field1846[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1872[var9 - var10];
            field1858[var4] = var2 + (var11 + ((field1847[var6] - var11) * var14 >> 16)) * class91.field1580 / 50;
            field1825[var4] = var3 + (var12 + ((field1837[var6] - var12) * var14 >> 16)) * class91.field1580 / 50;
            field1860[var4++] = var13 + ((this.field1822[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1872[var8 - var10];
            field1858[var4] = var2 + (var11 + ((field1847[var5] - var11) * var14 >> 16)) * class91.field1580 / 50;
            field1825[var4] = var3 + (var12 + ((field1837[var5] - var12) * var14 >> 16)) * class91.field1580 / 50;
            field1860[var4++] = var13 + ((this.field1857[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1858[0];
      var12 = field1858[1];
      var13 = field1858[2];
      var14 = field1825[0];
      int var15 = field1825[1];
      int var16 = field1825[2];
      class91.field1581 = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class91.field1583 || var12 > class91.field1583 || var13 > class91.field1583) {
            class91.field1581 = true;
         }

         if(this.field1856 != null && this.field1856[var1] != -1) {
            if(this.field1826 != null && this.field1826[var1] != -1) {
               var20 = this.field1826[var1] & 255;
               var17 = this.field1814[var20];
               var18 = this.field1831[var20];
               var19 = this.field1848[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1846[var1] == -1) {
               class91.method2096(var14, var15, var16, var11, var12, var13, this.field1857[var1], this.field1857[var1], this.field1857[var1], field1847[var17], field1847[var18], field1847[var19], field1837[var17], field1837[var18], field1837[var19], field1849[var17], field1849[var18], field1849[var19], this.field1856[var1]);
            } else {
               class91.method2096(var14, var15, var16, var11, var12, var13, field1860[0], field1860[1], field1860[2], field1847[var17], field1847[var18], field1847[var19], field1837[var17], field1837[var18], field1837[var19], field1849[var17], field1849[var18], field1849[var19], this.field1856[var1]);
            }
         } else if(this.field1846[var1] == -1) {
            class91.method2093(var14, var15, var16, var11, var12, var13, field1824[this.field1857[var1]]);
         } else {
            class91.method2091(var14, var15, var16, var11, var12, var13, field1860[0], field1860[1], field1860[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class91.field1583 || var12 > class91.field1583 || var13 > class91.field1583 || field1858[3] < 0 || field1858[3] > class91.field1583) {
            class91.field1581 = true;
         }

         if(this.field1856 != null && this.field1856[var1] != -1) {
            if(this.field1826 != null && this.field1826[var1] != -1) {
               var20 = this.field1826[var1] & 255;
               var17 = this.field1814[var20];
               var18 = this.field1831[var20];
               var19 = this.field1848[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1856[var1];
            if(this.field1846[var1] == -1) {
               class91.method2096(var14, var15, var16, var11, var12, var13, this.field1857[var1], this.field1857[var1], this.field1857[var1], field1847[var17], field1847[var18], field1847[var19], field1837[var17], field1837[var18], field1837[var19], field1849[var17], field1849[var18], field1849[var19], var21);
               class91.method2096(var14, var16, field1825[3], var11, var13, field1858[3], this.field1857[var1], this.field1857[var1], this.field1857[var1], field1847[var17], field1847[var18], field1847[var19], field1837[var17], field1837[var18], field1837[var19], field1849[var17], field1849[var18], field1849[var19], var21);
            } else {
               class91.method2096(var14, var15, var16, var11, var12, var13, field1860[0], field1860[1], field1860[2], field1847[var17], field1847[var18], field1847[var19], field1837[var17], field1837[var18], field1837[var19], field1849[var17], field1849[var18], field1849[var19], var21);
               class91.method2096(var14, var16, field1825[3], var11, var13, field1858[3], field1860[0], field1860[2], field1860[3], field1847[var17], field1847[var18], field1847[var19], field1837[var17], field1837[var18], field1837[var19], field1849[var17], field1849[var18], field1849[var19], var21);
            }
         } else if(this.field1846[var1] == -1) {
            var17 = field1824[this.field1857[var1]];
            class91.method2093(var14, var15, var16, var11, var12, var13, var17);
            class91.method2093(var14, var16, field1825[3], var11, var13, field1858[3], var17);
         } else {
            class91.method2091(var14, var15, var16, var11, var12, var13, field1860[0], field1860[1], field1860[2]);
            class91.method2091(var14, var16, field1825[3], var11, var13, field1858[3], field1860[0], field1860[2], field1860[3]);
         }
      }

   }

   @ObfuscatedName("n")
   final boolean method2322(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      return var2 < var3 && var2 < var4 && var2 < var5?false:(var2 > var3 && var2 > var4 && var2 > var5?false:(var1 < var6 && var1 < var7 && var1 < var8?false:var1 <= var6 || var1 <= var7 || var1 <= var8));
   }

   static {
      field1854 = class91.field1573;
      field1809 = class91.field1595;
      field1824 = class91.field1590;
      field1872 = class91.field1593;
   }

   @ObfuscatedName("y")
   public void method2323() {
      if(this.field1836 != 1) {
         this.field1836 = 1;
         super.field1467 = 0;
         this.field1823 = 0;
         this.field1853 = 0;

         for(int var1 = 0; var1 < this.field1813; ++var1) {
            int var2 = this.field1838[var1];
            int var3 = this.field1815[var1];
            int var4 = this.field1816[var1];
            if(-var3 > super.field1467) {
               super.field1467 = -var3;
            }

            if(var3 > this.field1823) {
               this.field1823 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1853) {
               this.field1853 = var5;
            }
         }

         this.field1853 = (int)(Math.sqrt((double)this.field1853) + 0.99D);
         this.field1840 = (int)(Math.sqrt((double)(this.field1853 * this.field1853 + super.field1467 * super.field1467)) + 0.99D);
         this.field1839 = this.field1840 + (int)(Math.sqrt((double)(this.field1853 * this.field1853 + this.field1823 * this.field1823)) + 0.99D);
      }
   }

   @ObfuscatedName("u")
   public void method2341(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1813; ++var4) {
         this.field1838[var4] += var1;
         this.field1815[var4] += var2;
         this.field1816[var4] += var3;
      }

      this.field1836 = 0;
   }

   public class105(class105[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1813 = 0;
      this.field1817 = 0;
      this.field1867 = 0;
      this.field1828 = -1;

      int var7;
      class105 var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1813 += var8.field1813;
            this.field1817 += var8.field1817;
            this.field1867 += var8.field1867;
            if(var8.field1869 != null) {
               var3 = true;
            } else {
               if(this.field1828 == -1) {
                  this.field1828 = var8.field1828;
               }

               if(this.field1828 != var8.field1828) {
                  var3 = true;
               }
            }

            var4 |= var8.field1830 != null;
            var5 |= var8.field1856 != null;
            var6 |= var8.field1826 != null;
         }
      }

      this.field1838 = new int[this.field1813];
      this.field1815 = new int[this.field1813];
      this.field1816 = new int[this.field1813];
      this.field1818 = new int[this.field1817];
      this.field1819 = new int[this.field1817];
      this.field1820 = new int[this.field1817];
      this.field1857 = new int[this.field1817];
      this.field1822 = new int[this.field1817];
      this.field1846 = new int[this.field1817];
      if(var3) {
         this.field1869 = new byte[this.field1817];
      }

      if(var4) {
         this.field1830 = new byte[this.field1817];
      }

      if(var5) {
         this.field1856 = new short[this.field1817];
      }

      if(var6) {
         this.field1826 = new byte[this.field1817];
      }

      if(this.field1867 > 0) {
         this.field1814 = new int[this.field1867];
         this.field1831 = new int[this.field1867];
         this.field1848 = new int[this.field1867];
      }

      this.field1813 = 0;
      this.field1817 = 0;
      this.field1867 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1817; ++var9) {
               this.field1818[this.field1817] = var8.field1818[var9] + this.field1813;
               this.field1819[this.field1817] = var8.field1819[var9] + this.field1813;
               this.field1820[this.field1817] = var8.field1820[var9] + this.field1813;
               this.field1857[this.field1817] = var8.field1857[var9];
               this.field1822[this.field1817] = var8.field1822[var9];
               this.field1846[this.field1817] = var8.field1846[var9];
               if(var3) {
                  if(var8.field1869 != null) {
                     this.field1869[this.field1817] = var8.field1869[var9];
                  } else {
                     this.field1869[this.field1817] = var8.field1828;
                  }
               }

               if(var4 && var8.field1830 != null) {
                  this.field1830[this.field1817] = var8.field1830[var9];
               }

               if(var5) {
                  if(var8.field1856 != null) {
                     this.field1856[this.field1817] = var8.field1856[var9];
                  } else {
                     this.field1856[this.field1817] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1826 != null && var8.field1826[var9] != -1) {
                     this.field1826[this.field1817] = (byte)(var8.field1826[var9] + this.field1867);
                  } else {
                     this.field1826[this.field1817] = -1;
                  }
               }

               ++this.field1817;
            }

            for(var9 = 0; var9 < var8.field1867; ++var9) {
               this.field1814[this.field1867] = var8.field1814[var9] + this.field1813;
               this.field1831[this.field1867] = var8.field1831[var9] + this.field1813;
               this.field1848[this.field1867] = var8.field1848[var9] + this.field1813;
               ++this.field1867;
            }

            for(var9 = 0; var9 < var8.field1813; ++var9) {
               this.field1838[this.field1813] = var8.field1838[var9];
               this.field1815[this.field1813] = var8.field1815[var9];
               this.field1816[this.field1813] = var8.field1816[var9];
               ++this.field1813;
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "0"
   )
   public final void method2349(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1851[0] = -1;
      if(this.field1836 != 2 && this.field1836 != 1) {
         this.method2305();
      }

      int var8 = class91.field1592;
      int var9 = class91.field1589;
      int var10000 = field1854[var1];
      var10000 = field1809[var1];
      int var12 = field1854[var2];
      int var13 = field1809[var2];
      int var14 = field1854[var3];
      int var15 = field1809[var3];
      int var16 = field1854[var4];
      int var17 = field1809[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1813; ++var19) {
         int var20 = this.field1838[var19];
         int var21 = this.field1815[var19];
         int var22 = this.field1816[var19];
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
         field1827[var19] = var22 - var18;
         field1844[var19] = var8 + var20 * class91.field1580 / var22;
         field1845[var19] = var9 + var23 * class91.field1580 / var22;
         if(this.field1867 > 0) {
            field1847[var19] = var20;
            field1837[var19] = var23;
            field1849[var19] = var22;
         }
      }

      try {
         this.method2319(false, false, 0);
      } catch (Exception var24) {
         ;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "0"
   )
   public final void method2359(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1851[0] = -1;
      if(this.field1836 != 2 && this.field1836 != 1) {
         this.method2305();
      }

      int var9 = class91.field1592;
      int var10 = class91.field1589;
      int var10000 = field1854[var1];
      var10000 = field1809[var1];
      int var13 = field1854[var2];
      int var14 = field1809[var2];
      int var15 = field1854[var3];
      int var16 = field1809[var3];
      int var17 = field1854[var4];
      int var18 = field1809[var4];
      int var19 = var6 * var17 + var7 * var18 >> 16;

      for(int var20 = 0; var20 < this.field1813; ++var20) {
         int var21 = this.field1838[var20];
         int var22 = this.field1815[var20];
         int var23 = this.field1816[var20];
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
         field1827[var20] = var23 - var19;
         field1844[var20] = var9 + var21 * class91.field1580 / var8;
         field1845[var20] = var10 + var24 * class91.field1580 / var8;
         if(this.field1867 > 0) {
            field1847[var20] = var21;
            field1837[var20] = var24;
            field1849[var20] = var23;
         }
      }

      try {
         this.method2319(false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   class105() {
   }

   @ObfuscatedName("v")
   public void method2372(class103 var1, int var2) {
      if(this.field1833 != null) {
         if(var2 != -1) {
            class88 var3 = var1.field1780[var2];
            class102 var4 = var3.field1547;
            field1861 = 0;
            field1862 = 0;
            field1863 = 0;

            for(int var5 = 0; var5 < var3.field1548; ++var5) {
               int var6 = var3.field1551[var5];
               this.method2309(var4.field1779[var6], var4.field1776[var6], var3.field1550[var5], var3.field1549[var5], var3.field1544[var5]);
            }

            this.field1836 = 0;
         }
      }
   }
}
