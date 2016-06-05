import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
@Implements("Model")
public class class105 extends class85 {
   @ObfuscatedName("bg")
   public static int field1805 = 0;
   @ObfuscatedName("ad")
   public boolean field1806 = false;
   @ObfuscatedName("au")
   static int[][] field1807 = new int[12][2000];
   @ObfuscatedName("h")
   static byte[] field1808 = new byte[1];
   @ObfuscatedName("z")
   int field1809 = 0;
   @ObfuscatedName("r")
   @Export("verticesX")
   int[] field1810;
   @ObfuscatedName("an")
   static int[] field1811 = new int[4700];
   @ObfuscatedName("s")
   @Export("verticesZ")
   int[] field1812;
   @ObfuscatedName("d")
   int field1813 = 0;
   @ObfuscatedName("ax")
   static int[] field1814 = new int[10];
   @ObfuscatedName("y")
   @Export("indices2")
   int[] field1815;
   @ObfuscatedName("p")
   @Export("indices3")
   int[] field1816;
   @ObfuscatedName("k")
   int[] field1817;
   @ObfuscatedName("o")
   int[] field1818;
   @ObfuscatedName("ao")
   static int[] field1819 = new int[4700];
   @ObfuscatedName("am")
   static int[] field1820 = new int[2000];
   @ObfuscatedName("i")
   static byte[] field1821 = new byte[1];
   @ObfuscatedName("u")
   byte[] field1822;
   @ObfuscatedName("c")
   short[] field1823;
   @ObfuscatedName("t")
   static class105 field1824 = new class105();
   @ObfuscatedName("n")
   byte field1825 = 0;
   @ObfuscatedName("x")
   int[] field1826;
   @ObfuscatedName("b")
   int[] field1827;
   @ObfuscatedName("m")
   int[] field1828;
   @ObfuscatedName("g")
   static class105 field1829 = new class105();
   @ObfuscatedName("e")
   int[][] field1830;
   @ObfuscatedName("v")
   int[] field1831;
   @ObfuscatedName("as")
   int field1832;
   @ObfuscatedName("ag")
   int field1833;
   @ObfuscatedName("l")
   @Export("indices1")
   int[] field1834;
   @ObfuscatedName("al")
   int field1835;
   @ObfuscatedName("ar")
   int field1836;
   @ObfuscatedName("aq")
   static boolean[] field1838 = new boolean[4700];
   @ObfuscatedName("ai")
   static boolean[] field1839 = new boolean[4700];
   @ObfuscatedName("q")
   int field1840 = 0;
   @ObfuscatedName("aw")
   static int[] field1841 = new int[4700];
   @ObfuscatedName("ap")
   static int[] field1842 = new int[4700];
   @ObfuscatedName("ak")
   static int[] field1843 = new int[4700];
   @ObfuscatedName("ac")
   static int[] field1844 = new int[4700];
   @ObfuscatedName("f")
   @Export("verticesY")
   int[] field1845;
   @ObfuscatedName("ah")
   static int[] field1847 = new int[1600];
   @ObfuscatedName("ae")
   static int[][] field1848 = new int[1600][512];
   @ObfuscatedName("aa")
   static int[] field1849 = new int[12];
   @ObfuscatedName("av")
   int field1850;
   @ObfuscatedName("ab")
   static int[] field1851 = new int[2000];
   @ObfuscatedName("at")
   static int[] field1853 = new int[12];
   @ObfuscatedName("az")
   static int[] field1854 = new int[10];
   @ObfuscatedName("af")
   static int[] field1855 = new int[10];
   @ObfuscatedName("bf")
   static int field1856;
   @ObfuscatedName("w")
   int[][] field1857;
   @ObfuscatedName("bi")
   static int field1858;
   @ObfuscatedName("br")
   static int field1859;
   @ObfuscatedName("bd")
   public static boolean field1860 = false;
   @ObfuscatedName("j")
   byte[] field1861;
   @ObfuscatedName("bh")
   public static int field1862 = 0;
   @ObfuscatedName("bn")
   public static int field1863 = 0;
   @ObfuscatedName("bb")
   public static int[] field1864 = new int[1000];
   @ObfuscatedName("ba")
   static int[] field1865;
   @ObfuscatedName("a")
   byte[] field1866;
   @ObfuscatedName("bl")
   static int[] field1867;
   @ObfuscatedName("bj")
   static int[] field1868;
   @ObfuscatedName("bw")
   static int[] field1870;

   @ObfuscatedSignature(
      signature = "([Lclass105;I)V",
      garbageValue = "2"
   )
   public class105(class105[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1809 = 0;
      this.field1813 = 0;
      this.field1840 = 0;
      this.field1825 = -1;

      int var7;
      class105 var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1809 += var8.field1809;
            this.field1813 += var8.field1813;
            this.field1840 += var8.field1840;
            if(var8.field1861 != null) {
               var3 = true;
            } else {
               if(this.field1825 == -1) {
                  this.field1825 = var8.field1825;
               }

               if(this.field1825 != var8.field1825) {
                  var3 = true;
               }
            }

            var4 |= var8.field1866 != null;
            var5 |= var8.field1823 != null;
            var6 |= var8.field1822 != null;
         }
      }

      this.field1810 = new int[this.field1809];
      this.field1845 = new int[this.field1809];
      this.field1812 = new int[this.field1809];
      this.field1834 = new int[this.field1813];
      this.field1815 = new int[this.field1813];
      this.field1816 = new int[this.field1813];
      this.field1817 = new int[this.field1813];
      this.field1818 = new int[this.field1813];
      this.field1827 = new int[this.field1813];
      if(var3) {
         this.field1861 = new byte[this.field1813];
      }

      if(var4) {
         this.field1866 = new byte[this.field1813];
      }

      if(var5) {
         this.field1823 = new short[this.field1813];
      }

      if(var6) {
         this.field1822 = new byte[this.field1813];
      }

      if(this.field1840 > 0) {
         this.field1826 = new int[this.field1840];
         this.field1831 = new int[this.field1840];
         this.field1828 = new int[this.field1840];
      }

      this.field1809 = 0;
      this.field1813 = 0;
      this.field1840 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1813; ++var9) {
               this.field1834[this.field1813] = var8.field1834[var9] + this.field1809;
               this.field1815[this.field1813] = var8.field1815[var9] + this.field1809;
               this.field1816[this.field1813] = var8.field1816[var9] + this.field1809;
               this.field1817[this.field1813] = var8.field1817[var9];
               this.field1818[this.field1813] = var8.field1818[var9];
               this.field1827[this.field1813] = var8.field1827[var9];
               if(var3) {
                  if(var8.field1861 != null) {
                     this.field1861[this.field1813] = var8.field1861[var9];
                  } else {
                     this.field1861[this.field1813] = var8.field1825;
                  }
               }

               if(var4 && var8.field1866 != null) {
                  this.field1866[this.field1813] = var8.field1866[var9];
               }

               if(var5) {
                  if(var8.field1823 != null) {
                     this.field1823[this.field1813] = var8.field1823[var9];
                  } else {
                     this.field1823[this.field1813] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1822 != null && var8.field1822[var9] != -1) {
                     this.field1822[this.field1813] = (byte)(var8.field1822[var9] + this.field1840);
                  } else {
                     this.field1822[this.field1813] = -1;
                  }
               }

               ++this.field1813;
            }

            for(var9 = 0; var9 < var8.field1840; ++var9) {
               this.field1826[this.field1840] = var8.field1826[var9] + this.field1809;
               this.field1831[this.field1840] = var8.field1831[var9] + this.field1809;
               this.field1828[this.field1840] = var8.field1828[var9] + this.field1809;
               ++this.field1840;
            }

            for(var9 = 0; var9 < var8.field1809; ++var9) {
               this.field1810[this.field1809] = var8.field1810[var9];
               this.field1845[this.field1809] = var8.field1845[var9];
               this.field1812[this.field1809] = var8.field1812[var9];
               ++this.field1809;
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([[IIIIZI)Lclass105;",
      garbageValue = "1"
   )
   public class105 method2254(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2258();
      int var7 = var2 - this.field1835;
      int var8 = var2 + this.field1835;
      int var9 = var4 - this.field1835;
      int var10 = var4 + this.field1835;
      if(var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
         var7 >>= 7;
         var8 = var8 + 127 >> 7;
         var9 >>= 7;
         var10 = var10 + 127 >> 7;
         if(var1[var7][var9] == var3 && var1[var8][var9] == var3 && var1[var7][var10] == var3 && var1[var8][var10] == var3) {
            return this;
         } else {
            class105 var11 = new class105();
            var11.field1809 = this.field1809;
            var11.field1813 = this.field1813;
            var11.field1840 = this.field1840;
            var11.field1810 = this.field1810;
            var11.field1812 = this.field1812;
            var11.field1834 = this.field1834;
            var11.field1815 = this.field1815;
            var11.field1816 = this.field1816;
            var11.field1817 = this.field1817;
            var11.field1818 = this.field1818;
            var11.field1827 = this.field1827;
            var11.field1861 = this.field1861;
            var11.field1866 = this.field1866;
            var11.field1822 = this.field1822;
            var11.field1823 = this.field1823;
            var11.field1825 = this.field1825;
            var11.field1826 = this.field1826;
            var11.field1831 = this.field1831;
            var11.field1828 = this.field1828;
            var11.field1857 = this.field1857;
            var11.field1830 = this.field1830;
            var11.field1806 = this.field1806;
            var11.field1845 = new int[var11.field1809];
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
               for(var12 = 0; var12 < var11.field1809; ++var12) {
                  var13 = this.field1810[var12] + var2;
                  var14 = this.field1812[var12] + var4;
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var1[var17 + 1][var18 + 1] * var15 >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.field1845[var12] = this.field1845[var12] + var21 - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1809; ++var12) {
                  var13 = (-this.field1845[var12] << 16) / super.field1466;
                  if(var13 < var6) {
                     var14 = this.field1810[var12] + var2;
                     var15 = this.field1812[var12] + var4;
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var1[var18 + 1][var19 + 1] * var16 >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.field1845[var12] = this.field1845[var12] + (var22 - var3) * (var6 - var13) / var6;
                  }
               }
            }

            var11.field1832 = 0;
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("i")
   public class105 method2255(boolean var1) {
      if(!var1 && field1821.length < this.field1813) {
         field1821 = new byte[this.field1813 + 100];
      }

      return this.method2257(var1, field1824, field1821);
   }

   @ObfuscatedName("z")
   class105 method2257(boolean var1, class105 var2, byte[] var3) {
      var2.field1809 = this.field1809;
      var2.field1813 = this.field1813;
      var2.field1840 = this.field1840;
      if(var2.field1810 == null || var2.field1810.length < this.field1809) {
         var2.field1810 = new int[this.field1809 + 100];
         var2.field1845 = new int[this.field1809 + 100];
         var2.field1812 = new int[this.field1809 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1809; ++var4) {
         var2.field1810[var4] = this.field1810[var4];
         var2.field1845[var4] = this.field1845[var4];
         var2.field1812[var4] = this.field1812[var4];
      }

      if(var1) {
         var2.field1866 = this.field1866;
      } else {
         var2.field1866 = var3;
         if(this.field1866 == null) {
            for(var4 = 0; var4 < this.field1813; ++var4) {
               var2.field1866[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1813; ++var4) {
               var2.field1866[var4] = this.field1866[var4];
            }
         }
      }

      var2.field1834 = this.field1834;
      var2.field1815 = this.field1815;
      var2.field1816 = this.field1816;
      var2.field1817 = this.field1817;
      var2.field1818 = this.field1818;
      var2.field1827 = this.field1827;
      var2.field1861 = this.field1861;
      var2.field1822 = this.field1822;
      var2.field1823 = this.field1823;
      var2.field1825 = this.field1825;
      var2.field1826 = this.field1826;
      var2.field1831 = this.field1831;
      var2.field1828 = this.field1828;
      var2.field1857 = this.field1857;
      var2.field1830 = this.field1830;
      var2.field1806 = this.field1806;
      var2.field1832 = 0;
      return var2;
   }

   @ObfuscatedName("r")
   public void method2258() {
      if(this.field1832 != 1) {
         this.field1832 = 1;
         super.field1466 = 0;
         this.field1833 = 0;
         this.field1835 = 0;

         for(int var1 = 0; var1 < this.field1809; ++var1) {
            int var2 = this.field1810[var1];
            int var3 = this.field1845[var1];
            int var4 = this.field1812[var1];
            if(-var3 > super.field1466) {
               super.field1466 = -var3;
            }

            if(var3 > this.field1833) {
               this.field1833 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1835) {
               this.field1835 = var5;
            }
         }

         this.field1835 = (int)(Math.sqrt((double)this.field1835) + 0.99D);
         this.field1836 = (int)(Math.sqrt((double)(this.field1835 * this.field1835 + super.field1466 * super.field1466)) + 0.99D);
         this.field1850 = this.field1836 + (int)(Math.sqrt((double)(this.field1835 * this.field1835 + this.field1833 * this.field1833)) + 0.99D);
      }
   }

   @ObfuscatedName("s")
   public int method2260() {
      this.method2258();
      return this.field1835;
   }

   @ObfuscatedName("d")
   public void method2261(class103 var1, int var2) {
      if(this.field1857 != null) {
         if(var2 != -1) {
            class88 var3 = var1.field1782[var2];
            class102 var4 = var3.field1555;
            field1856 = 0;
            field1858 = 0;
            field1859 = 0;

            for(int var5 = 0; var5 < var3.field1552; ++var5) {
               int var6 = var3.field1556[var5];
               this.method2289(var4.field1771[var6], var4.field1772[var6], var3.field1554[var5], var3.field1553[var5], var3.field1547[var5]);
            }

            this.field1832 = 0;
         }
      }
   }

   @ObfuscatedName("l")
   public void method2262(class103 var1, int var2, class103 var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            class88 var6 = var1.field1782[var2];
            class88 var7 = var3.field1782[var4];
            class102 var8 = var6.field1555;
            field1856 = 0;
            field1858 = 0;
            field1859 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1552; ++var11) {
               for(var12 = var6.field1556[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field1771[var12] == 0) {
                  this.method2289(var8.field1771[var12], var8.field1772[var12], var6.field1554[var11], var6.field1553[var11], var6.field1547[var11]);
               }
            }

            field1856 = 0;
            field1858 = 0;
            field1859 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1552; ++var11) {
               for(var12 = var7.field1556[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field1771[var12] == 0) {
                  this.method2289(var8.field1771[var12], var8.field1772[var12], var7.field1554[var11], var7.field1553[var11], var7.field1547[var11]);
               }
            }

            this.field1832 = 0;
         } else {
            this.method2261(var1, var2);
         }
      }
   }

   @ObfuscatedName("p")
   public void method2264() {
      for(int var1 = 0; var1 < this.field1809; ++var1) {
         int var2 = this.field1810[var1];
         this.field1810[var1] = this.field1812[var1];
         this.field1812[var1] = -var2;
      }

      this.field1832 = 0;
   }

   @ObfuscatedName("u")
   public void method2266() {
      for(int var1 = 0; var1 < this.field1809; ++var1) {
         int var2 = this.field1812[var1];
         this.field1812[var1] = this.field1810[var1];
         this.field1810[var1] = -var2;
      }

      this.field1832 = 0;
   }

   @ObfuscatedName("n")
   public void method2268(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1809; ++var4) {
         this.field1810[var4] += var1;
         this.field1845[var4] += var2;
         this.field1812[var4] += var3;
      }

      this.field1832 = 0;
   }

   class105() {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "0"
   )
   public final void method2269(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1847[0] = -1;
      if(this.field1832 != 2 && this.field1832 != 1) {
         this.method2330();
      }

      int var8 = class91.field1589;
      int var9 = class91.field1590;
      int var10000 = field1865[var1];
      var10000 = field1870[var1];
      int var12 = field1865[var2];
      int var13 = field1870[var2];
      int var14 = field1865[var3];
      int var15 = field1870[var3];
      int var16 = field1865[var4];
      int var17 = field1870[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1809; ++var19) {
         int var20 = this.field1810[var19];
         int var21 = this.field1845[var19];
         int var22 = this.field1812[var19];
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
         field1842[var19] = var22 - var18;
         field1811[var19] = var8 + var20 * class91.field1586 / var22;
         field1841[var19] = var9 + var23 * class91.field1586 / var22;
         if(this.field1840 > 0) {
            field1843[var19] = var20;
            field1844[var19] = var23;
            field1819[var19] = var22;
         }
      }

      try {
         this.method2272(false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "0"
   )
   public final void method2270(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1847[0] = -1;
      if(this.field1832 != 2 && this.field1832 != 1) {
         this.method2330();
      }

      int var9 = class91.field1589;
      int var10 = class91.field1590;
      int var10000 = field1865[var1];
      var10000 = field1870[var1];
      int var13 = field1865[var2];
      int var14 = field1870[var2];
      int var15 = field1865[var3];
      int var16 = field1870[var3];
      int var17 = field1865[var4];
      int var18 = field1870[var4];
      int var19 = var6 * var17 + var7 * var18 >> 16;

      for(int var20 = 0; var20 < this.field1809; ++var20) {
         int var21 = this.field1810[var20];
         int var22 = this.field1845[var20];
         int var23 = this.field1812[var20];
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
         field1842[var20] = var23 - var19;
         field1811[var20] = var9 + var21 * class91.field1586 / var8;
         field1841[var20] = var10 + var24 * class91.field1586 / var8;
         if(this.field1840 > 0) {
            field1843[var20] = var21;
            field1844[var20] = var24;
            field1819[var20] = var23;
         }
      }

      try {
         this.method2272(false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("m")
   final void method2272(boolean var1, boolean var2, int var3) {
      if(this.field1850 < 1600) {
         int var4;
         for(var4 = 0; var4 < this.field1850; ++var4) {
            field1847[var4] = 0;
         }

         int var5;
         int var7;
         int var8;
         int var9;
         int var10;
         int var12;
         int var13;
         int var15;
         int var25;
         for(var4 = 0; var4 < this.field1813; ++var4) {
            if(this.field1827[var4] != -2) {
               var5 = this.field1834[var4];
               var25 = this.field1815[var4];
               var7 = this.field1816[var4];
               var8 = field1811[var5];
               var9 = field1811[var25];
               var10 = field1811[var7];
               int var24;
               if(var1 && (var8 == -5000 || var9 == -5000 || var10 == -5000)) {
                  var24 = field1843[var5];
                  var12 = field1843[var25];
                  var13 = field1843[var7];
                  int var14 = field1844[var5];
                  var15 = field1844[var25];
                  int var16 = field1844[var7];
                  int var17 = field1819[var5];
                  int var18 = field1819[var25];
                  int var19 = field1819[var7];
                  var24 -= var12;
                  var13 -= var12;
                  var14 -= var15;
                  var16 -= var15;
                  var17 -= var18;
                  var19 -= var18;
                  int var20 = var14 * var19 - var17 * var16;
                  int var21 = var17 * var13 - var24 * var19;
                  int var22 = var24 * var16 - var14 * var13;
                  if(var12 * var20 + var15 * var21 + var18 * var22 > 0) {
                     field1839[var4] = true;
                     int var23 = (field1842[var5] + field1842[var25] + field1842[var7]) / 3 + this.field1836;
                     field1848[var23][field1847[var23]++] = var4;
                  }
               } else {
                  if(var2 && this.method2299(field1805, field1862, field1841[var5], field1841[var25], field1841[var7], var8, var9, var10)) {
                     field1864[field1863++] = var3;
                     var2 = false;
                  }

                  if((var8 - var9) * (field1841[var7] - field1841[var25]) - (field1841[var5] - field1841[var25]) * (var10 - var9) > 0) {
                     field1839[var4] = false;
                     if(var8 >= 0 && var9 >= 0 && var10 >= 0 && var8 <= class91.field1591 && var9 <= class91.field1591 && var10 <= class91.field1591) {
                        field1838[var4] = false;
                     } else {
                        field1838[var4] = true;
                     }

                     var24 = (field1842[var5] + field1842[var25] + field1842[var7]) / 3 + this.field1836;
                     field1848[var24][field1847[var24]++] = var4;
                  }
               }
            }
         }

         int[] var6;
         if(this.field1861 == null) {
            for(var4 = this.field1850 - 1; var4 >= 0; --var4) {
               var5 = field1847[var4];
               if(var5 > 0) {
                  var6 = field1848[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     this.method2300(var6[var7]);
                  }
               }
            }

         } else {
            for(var4 = 0; var4 < 12; ++var4) {
               field1849[var4] = 0;
               field1853[var4] = 0;
            }

            for(var4 = this.field1850 - 1; var4 >= 0; --var4) {
               var5 = field1847[var4];
               if(var5 > 0) {
                  var6 = field1848[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     var8 = var6[var7];
                     byte var28 = this.field1861[var8];
                     var10 = field1849[var28]++;
                     field1807[var28][var10] = var8;
                     if(var28 < 10) {
                        field1853[var28] += var4;
                     } else if(var28 == 10) {
                        field1851[var10] = var4;
                     } else {
                        field1820[var10] = var4;
                     }
                  }
               }
            }

            var4 = 0;
            if(field1849[1] > 0 || field1849[2] > 0) {
               var4 = (field1853[1] + field1853[2]) / (field1849[1] + field1849[2]);
            }

            var5 = 0;
            if(field1849[3] > 0 || field1849[4] > 0) {
               var5 = (field1853[3] + field1853[4]) / (field1849[3] + field1849[4]);
            }

            var25 = 0;
            if(field1849[6] > 0 || field1849[8] > 0) {
               var25 = (field1853[6] + field1853[8]) / (field1849[6] + field1849[8]);
            }

            var8 = 0;
            var9 = field1849[10];
            int[] var26 = field1807[10];
            int[] var11 = field1851;
            if(var8 == var9) {
               var8 = 0;
               var9 = field1849[11];
               var26 = field1807[11];
               var11 = field1820;
            }

            if(var8 < var9) {
               var7 = var11[var8];
            } else {
               var7 = -1000;
            }

            for(var12 = 0; var12 < 10; ++var12) {
               while(var12 == 0 && var7 > var4) {
                  this.method2300(var26[var8++]);
                  if(var8 == var9 && var26 != field1807[11]) {
                     var8 = 0;
                     var9 = field1849[11];
                     var26 = field1807[11];
                     var11 = field1820;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 3 && var7 > var5) {
                  this.method2300(var26[var8++]);
                  if(var8 == var9 && var26 != field1807[11]) {
                     var8 = 0;
                     var9 = field1849[11];
                     var26 = field1807[11];
                     var11 = field1820;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 5 && var7 > var25) {
                  this.method2300(var26[var8++]);
                  if(var8 == var9 && var26 != field1807[11]) {
                     var8 = 0;
                     var9 = field1849[11];
                     var26 = field1807[11];
                     var11 = field1820;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               var13 = field1849[var12];
               int[] var27 = field1807[var12];

               for(var15 = 0; var15 < var13; ++var15) {
                  this.method2300(var27[var15]);
               }
            }

            while(var7 != -1000) {
               this.method2300(var26[var8++]);
               if(var8 == var9 && var26 != field1807[11]) {
                  var8 = 0;
                  var26 = field1807[11];
                  var9 = field1849[11];
                  var11 = field1820;
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

   @ObfuscatedName("e")
   final void method2274(int var1) {
      int var2 = class91.field1589;
      int var3 = class91.field1590;
      int var4 = 0;
      int var5 = this.field1834[var1];
      int var6 = this.field1815[var1];
      int var7 = this.field1816[var1];
      int var8 = field1819[var5];
      int var9 = field1819[var6];
      int var10 = field1819[var7];
      if(this.field1866 == null) {
         class91.field1592 = 0;
      } else {
         class91.field1592 = this.field1866[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1854[var4] = field1811[var5];
         field1855[var4] = field1841[var5];
         field1814[var4++] = this.field1817[var1];
      } else {
         var11 = field1843[var5];
         var12 = field1844[var5];
         var13 = this.field1817[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1868[var10 - var8];
            field1854[var4] = var2 + (var11 + ((field1843[var7] - var11) * var14 >> 16)) * class91.field1586 / 50;
            field1855[var4] = var3 + (var12 + ((field1844[var7] - var12) * var14 >> 16)) * class91.field1586 / 50;
            field1814[var4++] = var13 + ((this.field1827[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1868[var9 - var8];
            field1854[var4] = var2 + (var11 + ((field1843[var6] - var11) * var14 >> 16)) * class91.field1586 / 50;
            field1855[var4] = var3 + (var12 + ((field1844[var6] - var12) * var14 >> 16)) * class91.field1586 / 50;
            field1814[var4++] = var13 + ((this.field1818[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1854[var4] = field1811[var6];
         field1855[var4] = field1841[var6];
         field1814[var4++] = this.field1818[var1];
      } else {
         var11 = field1843[var6];
         var12 = field1844[var6];
         var13 = this.field1818[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1868[var8 - var9];
            field1854[var4] = var2 + (var11 + ((field1843[var5] - var11) * var14 >> 16)) * class91.field1586 / 50;
            field1855[var4] = var3 + (var12 + ((field1844[var5] - var12) * var14 >> 16)) * class91.field1586 / 50;
            field1814[var4++] = var13 + ((this.field1817[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1868[var10 - var9];
            field1854[var4] = var2 + (var11 + ((field1843[var7] - var11) * var14 >> 16)) * class91.field1586 / 50;
            field1855[var4] = var3 + (var12 + ((field1844[var7] - var12) * var14 >> 16)) * class91.field1586 / 50;
            field1814[var4++] = var13 + ((this.field1827[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1854[var4] = field1811[var7];
         field1855[var4] = field1841[var7];
         field1814[var4++] = this.field1827[var1];
      } else {
         var11 = field1843[var7];
         var12 = field1844[var7];
         var13 = this.field1827[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1868[var9 - var10];
            field1854[var4] = var2 + (var11 + ((field1843[var6] - var11) * var14 >> 16)) * class91.field1586 / 50;
            field1855[var4] = var3 + (var12 + ((field1844[var6] - var12) * var14 >> 16)) * class91.field1586 / 50;
            field1814[var4++] = var13 + ((this.field1818[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1868[var8 - var10];
            field1854[var4] = var2 + (var11 + ((field1843[var5] - var11) * var14 >> 16)) * class91.field1586 / 50;
            field1855[var4] = var3 + (var12 + ((field1844[var5] - var12) * var14 >> 16)) * class91.field1586 / 50;
            field1814[var4++] = var13 + ((this.field1817[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1854[0];
      var12 = field1854[1];
      var13 = field1854[2];
      var14 = field1855[0];
      int var15 = field1855[1];
      int var16 = field1855[2];
      class91.field1588 = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class91.field1591 || var12 > class91.field1591 || var13 > class91.field1591) {
            class91.field1588 = true;
         }

         if(this.field1823 != null && this.field1823[var1] != -1) {
            if(this.field1822 != null && this.field1822[var1] != -1) {
               var20 = this.field1822[var1] & 255;
               var17 = this.field1826[var20];
               var18 = this.field1831[var20];
               var19 = this.field1828[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1827[var1] == -1) {
               class91.method2065(var14, var15, var16, var11, var12, var13, this.field1817[var1], this.field1817[var1], this.field1817[var1], field1843[var17], field1843[var18], field1843[var19], field1844[var17], field1844[var18], field1844[var19], field1819[var17], field1819[var18], field1819[var19], this.field1823[var1]);
            } else {
               class91.method2065(var14, var15, var16, var11, var12, var13, field1814[0], field1814[1], field1814[2], field1843[var17], field1843[var18], field1843[var19], field1844[var17], field1844[var18], field1844[var19], field1819[var17], field1819[var18], field1819[var19], this.field1823[var1]);
            }
         } else if(this.field1827[var1] == -1) {
            class91.method2061(var14, var15, var16, var11, var12, var13, field1867[this.field1817[var1]]);
         } else {
            class91.method2059(var14, var15, var16, var11, var12, var13, field1814[0], field1814[1], field1814[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class91.field1591 || var12 > class91.field1591 || var13 > class91.field1591 || field1854[3] < 0 || field1854[3] > class91.field1591) {
            class91.field1588 = true;
         }

         if(this.field1823 != null && this.field1823[var1] != -1) {
            if(this.field1822 != null && this.field1822[var1] != -1) {
               var20 = this.field1822[var1] & 255;
               var17 = this.field1826[var20];
               var18 = this.field1831[var20];
               var19 = this.field1828[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1823[var1];
            if(this.field1827[var1] == -1) {
               class91.method2065(var14, var15, var16, var11, var12, var13, this.field1817[var1], this.field1817[var1], this.field1817[var1], field1843[var17], field1843[var18], field1843[var19], field1844[var17], field1844[var18], field1844[var19], field1819[var17], field1819[var18], field1819[var19], var21);
               class91.method2065(var14, var16, field1855[3], var11, var13, field1854[3], this.field1817[var1], this.field1817[var1], this.field1817[var1], field1843[var17], field1843[var18], field1843[var19], field1844[var17], field1844[var18], field1844[var19], field1819[var17], field1819[var18], field1819[var19], var21);
            } else {
               class91.method2065(var14, var15, var16, var11, var12, var13, field1814[0], field1814[1], field1814[2], field1843[var17], field1843[var18], field1843[var19], field1844[var17], field1844[var18], field1844[var19], field1819[var17], field1819[var18], field1819[var19], var21);
               class91.method2065(var14, var16, field1855[3], var11, var13, field1854[3], field1814[0], field1814[2], field1814[3], field1843[var17], field1843[var18], field1843[var19], field1844[var17], field1844[var18], field1844[var19], field1819[var17], field1819[var18], field1819[var19], var21);
            }
         } else if(this.field1827[var1] == -1) {
            var17 = field1867[this.field1817[var1]];
            class91.method2061(var14, var15, var16, var11, var12, var13, var17);
            class91.method2061(var14, var16, field1855[3], var11, var13, field1854[3], var17);
         } else {
            class91.method2059(var14, var15, var16, var11, var12, var13, field1814[0], field1814[1], field1814[2]);
            class91.method2059(var14, var16, field1855[3], var11, var13, field1854[3], field1814[0], field1814[2], field1814[3]);
         }
      }

   }

   @ObfuscatedName("c")
   public void method2277(int var1) {
      int var2 = field1865[var1];
      int var3 = field1870[var1];

      for(int var4 = 0; var4 < this.field1809; ++var4) {
         int var5 = this.field1845[var4] * var3 - this.field1812[var4] * var2 >> 16;
         this.field1812[var4] = this.field1845[var4] * var2 + this.field1812[var4] * var3 >> 16;
         this.field1845[var4] = var5;
      }

      this.field1832 = 0;
   }

   @ObfuscatedName("y")
   void method2289(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1856 = 0;
         field1858 = 0;
         field1859 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var9 = var2[var8];
            if(var9 < this.field1857.length) {
               int[] var10 = this.field1857[var9];

               for(var11 = 0; var11 < var10.length; ++var11) {
                  var12 = var10[var11];
                  field1856 += this.field1810[var12];
                  field1858 += this.field1845[var12];
                  field1859 += this.field1812[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1856 = field1856 / var7 + var3;
            field1858 = field1858 / var7 + var4;
            field1859 = field1859 / var7 + var5;
         } else {
            field1856 = var3;
            field1858 = var4;
            field1859 = var5;
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
                     this.field1810[var11] += var3;
                     this.field1845[var11] += var4;
                     this.field1812[var11] += var5;
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
                     this.field1810[var11] -= field1856;
                     this.field1845[var11] -= field1858;
                     this.field1812[var11] -= field1859;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1865[var14];
                        var16 = field1870[var14];
                        var17 = this.field1845[var11] * var15 + this.field1810[var11] * var16 >> 16;
                        this.field1845[var11] = this.field1845[var11] * var16 - this.field1810[var11] * var15 >> 16;
                        this.field1810[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1865[var12];
                        var16 = field1870[var12];
                        var17 = this.field1845[var11] * var16 - this.field1812[var11] * var15 >> 16;
                        this.field1812[var11] = this.field1845[var11] * var15 + this.field1812[var11] * var16 >> 16;
                        this.field1845[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1865[var13];
                        var16 = field1870[var13];
                        var17 = this.field1812[var11] * var15 + this.field1810[var11] * var16 >> 16;
                        this.field1812[var11] = this.field1812[var11] * var16 - this.field1810[var11] * var15 >> 16;
                        this.field1810[var11] = var17;
                     }

                     this.field1810[var11] += field1856;
                     this.field1845[var11] += field1858;
                     this.field1812[var11] += field1859;
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
                     this.field1810[var11] -= field1856;
                     this.field1845[var11] -= field1858;
                     this.field1812[var11] -= field1859;
                     this.field1810[var11] = this.field1810[var11] * var3 / 128;
                     this.field1845[var11] = this.field1845[var11] * var4 / 128;
                     this.field1812[var11] = this.field1812[var11] * var5 / 128;
                     this.field1810[var11] += field1856;
                     this.field1845[var11] += field1858;
                     this.field1812[var11] += field1859;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1830 != null && this.field1866 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1830.length) {
                     var18 = this.field1830[var8];

                     for(var19 = 0; var19 < var18.length; ++var19) {
                        var11 = var18[var19];
                        var12 = (this.field1866[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1866[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   static {
      field1865 = class91.field1602;
      field1870 = class91.field1603;
      field1867 = class91.field1579;
      field1868 = class91.field1601;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Z)Lclass105;",
      garbageValue = "1"
   )
   public class105 method2296(boolean var1) {
      return this.method2257(var1, field1829, field1808);
   }

   @ObfuscatedName("ad")
   final boolean method2299(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      return var2 < var3 && var2 < var4 && var2 < var5?false:(var2 > var3 && var2 > var4 && var2 > var5?false:(var1 < var6 && var1 < var7 && var1 < var8?false:var1 <= var6 || var1 <= var7 || var1 <= var8));
   }

   @ObfuscatedName("w")
   final void method2300(int var1) {
      if(field1839[var1]) {
         this.method2274(var1);
      } else {
         int var2 = this.field1834[var1];
         int var3 = this.field1815[var1];
         int var4 = this.field1816[var1];
         class91.field1588 = field1838[var1];
         if(this.field1866 == null) {
            class91.field1592 = 0;
         } else {
            class91.field1592 = this.field1866[var1] & 255;
         }

         if(this.field1823 != null && this.field1823[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1822 != null && this.field1822[var1] != -1) {
               int var8 = this.field1822[var1] & 255;
               var5 = this.field1826[var8];
               var6 = this.field1831[var8];
               var7 = this.field1828[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1827[var1] == -1) {
               class91.method2065(field1841[var2], field1841[var3], field1841[var4], field1811[var2], field1811[var3], field1811[var4], this.field1817[var1], this.field1817[var1], this.field1817[var1], field1843[var5], field1843[var6], field1843[var7], field1844[var5], field1844[var6], field1844[var7], field1819[var5], field1819[var6], field1819[var7], this.field1823[var1]);
            } else {
               class91.method2065(field1841[var2], field1841[var3], field1841[var4], field1811[var2], field1811[var3], field1811[var4], this.field1817[var1], this.field1818[var1], this.field1827[var1], field1843[var5], field1843[var6], field1843[var7], field1844[var5], field1844[var6], field1844[var7], field1819[var5], field1819[var6], field1819[var7], this.field1823[var1]);
            }
         } else if(this.field1827[var1] == -1) {
            class91.method2061(field1841[var2], field1841[var3], field1841[var4], field1811[var2], field1811[var3], field1811[var4], field1867[this.field1817[var1]]);
         } else {
            class91.method2059(field1841[var2], field1841[var3], field1841[var4], field1811[var2], field1811[var3], field1811[var4], this.field1817[var1], this.field1818[var1], this.field1827[var1]);
         }

      }
   }

   @ObfuscatedName("a")
   public void method2302() {
      for(int var1 = 0; var1 < this.field1809; ++var1) {
         this.field1810[var1] = -this.field1810[var1];
         this.field1812[var1] = -this.field1812[var1];
      }

      this.field1832 = 0;
   }

   @ObfuscatedName("q")
   public void method2316(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1809; ++var4) {
         this.field1810[var4] = this.field1810[var4] * var1 / 128;
         this.field1845[var4] = this.field1845[var4] * var2 / 128;
         this.field1812[var4] = this.field1812[var4] * var3 / 128;
      }

      this.field1832 = 0;
   }

   @ObfuscatedName("ag")
   void vmethod2317(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1847[0] = -1;
      if(this.field1832 != 1) {
         this.method2258();
      }

      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1835 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1835) * class91.field1586;
         if(var15 / var13 < class91.field1594) {
            int var16 = (var14 + this.field1835) * class91.field1586;
            if(var16 / var13 > class91.field1593) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1835 * var2 >> 16;
               int var19 = (var17 + var18) * class91.field1586;
               if(var19 / var13 > class91.field1595) {
                  int var20 = var18 + (super.field1466 * var3 >> 16);
                  int var21 = (var17 - var20) * class91.field1586;
                  if(var21 / var13 < class91.field1600) {
                     int var22 = var12 + (super.field1466 * var2 >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1840 > 0;
                     boolean var26 = false;
                     int var27;
                     int var28;
                     int var29;
                     if(var9 > 0 && field1860) {
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

                        var28 = field1805 - class91.field1589;
                        var29 = field1862 - class91.field1590;
                        if(var28 > var15 && var28 < var16 && var29 > var21 && var29 < var19) {
                           if(this.field1806) {
                              field1864[field1863++] = var9;
                           } else {
                              var26 = true;
                           }
                        }
                     }

                     var27 = class91.field1589;
                     var28 = class91.field1590;
                     var29 = 0;
                     int var30 = 0;
                     if(var1 != 0) {
                        var29 = field1865[var1];
                        var30 = field1870[var1];
                     }

                     for(int var31 = 0; var31 < this.field1809; ++var31) {
                        int var32 = this.field1810[var31];
                        int var33 = this.field1845[var31];
                        int var34 = this.field1812[var31];
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
                        field1842[var31] = var34 - var11;
                        if(var34 >= 50) {
                           field1811[var31] = var27 + var32 * class91.field1586 / var34;
                           field1841[var31] = var28 + var35 * class91.field1586 / var34;
                        } else {
                           field1811[var31] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1843[var31] = var32;
                           field1844[var31] = var35;
                           field1819[var31] = var34;
                        }
                     }

                     try {
                        this.method2272(var23, var26, var9);
                     } catch (Exception var37) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("f")
   void method2330() {
      if(this.field1832 != 2) {
         this.field1832 = 2;
         this.field1835 = 0;

         for(int var1 = 0; var1 < this.field1809; ++var1) {
            int var2 = this.field1810[var1];
            int var3 = this.field1845[var1];
            int var4 = this.field1812[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1835) {
               this.field1835 = var5;
            }
         }

         this.field1835 = (int)(Math.sqrt((double)this.field1835) + 0.99D);
         this.field1836 = this.field1835;
         this.field1850 = this.field1835 + this.field1835;
      }
   }
}
