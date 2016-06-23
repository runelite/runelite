import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dr")
@Implements("Model")
public class class105 extends class85 {
   @ObfuscatedName("ay")
   static int[][] field1803 = new int[1600][512];
   @ObfuscatedName("u")
   static byte[] field1804 = new byte[1];
   @ObfuscatedName("ap")
   static int[] field1805 = new int[4700];
   @ObfuscatedName("bk")
   static int[] field1806;
   @ObfuscatedName("ab")
   static int[] field1807 = new int[10];
   @ObfuscatedName("n")
   @Export("verticesY")
   int[] field1809;
   @ObfuscatedName("ae")
   static int[] field1810 = new int[2000];
   @ObfuscatedName("g")
   int field1811 = 0;
   @ObfuscatedName("r")
   @Export("indices2")
   int[] field1813;
   @ObfuscatedName("k")
   @Export("indices3")
   int[] field1814;
   @ObfuscatedName("m")
   @Export("verticesZ")
   int[] field1815;
   @ObfuscatedName("b")
   static byte[] field1816 = new byte[1];
   @ObfuscatedName("p")
   int[] field1817;
   @ObfuscatedName("h")
   byte[] field1818;
   @ObfuscatedName("o")
   int[] field1819;
   @ObfuscatedName("t")
   byte[] field1820;
   @ObfuscatedName("e")
   byte[] field1821;
   @ObfuscatedName("v")
   byte field1822 = 0;
   @ObfuscatedName("y")
   int field1823 = 0;
   @ObfuscatedName("c")
   int[] field1824;
   @ObfuscatedName("i")
   int[] field1825;
   @ObfuscatedName("a")
   int[] field1826;
   @ObfuscatedName("q")
   int[] field1827;
   @ObfuscatedName("j")
   int[][] field1828;
   @ObfuscatedName("ag")
   public boolean field1829 = false;
   @ObfuscatedName("ax")
   int field1830;
   @ObfuscatedName("ao")
   int field1831;
   @ObfuscatedName("ac")
   int field1832;
   @ObfuscatedName("f")
   static class105 field1833 = new class105();
   @ObfuscatedName("an")
   int field1834;
   @ObfuscatedName("l")
   int field1835 = 0;
   @ObfuscatedName("as")
   static boolean[] field1836 = new boolean[4700];
   @ObfuscatedName("av")
   static boolean[] field1837 = new boolean[4700];
   @ObfuscatedName("am")
   static int[] field1838 = new int[4700];
   @ObfuscatedName("az")
   static int[] field1839 = new int[4700];
   @ObfuscatedName("ai")
   static int[] field1840 = new int[4700];
   @ObfuscatedName("aq")
   static int[] field1841 = new int[4700];
   @ObfuscatedName("ah")
   static int[] field1842 = new int[4700];
   @ObfuscatedName("ad")
   static int[] field1843 = new int[2000];
   @ObfuscatedName("bp")
   static int field1844;
   @ObfuscatedName("aa")
   static int[] field1845 = new int[1600];
   @ObfuscatedName("s")
   @Export("indices1")
   int[] field1846;
   @ObfuscatedName("aw")
   static int[] field1847 = new int[12];
   @ObfuscatedName("ak")
   static int[][] field1848 = new int[12][2000];
   @ObfuscatedName("z")
   int[][] field1849;
   @ObfuscatedName("be")
   static int[] field1850;
   @ObfuscatedName("au")
   static int[] field1851 = new int[12];
   @ObfuscatedName("ar")
   static int[] field1852 = new int[10];
   @ObfuscatedName("bq")
   public static int field1853 = 0;
   @ObfuscatedName("x")
   static class105 field1854 = new class105();
   @ObfuscatedName("aj")
   int field1855;
   @ObfuscatedName("bo")
   static int field1856;
   @ObfuscatedName("bf")
   static int field1857;
   @ObfuscatedName("bx")
   public static boolean field1858 = false;
   @ObfuscatedName("at")
   static int[] field1859 = new int[10];
   @ObfuscatedName("bc")
   public static int field1860 = 0;
   @ObfuscatedName("ba")
   public static int field1861 = 0;
   @ObfuscatedName("by")
   public static int[] field1862 = new int[1000];
   @ObfuscatedName("w")
   short[] field1863;
   @ObfuscatedName("bm")
   static int[] field1864;
   @ObfuscatedName("d")
   @Export("verticesX")
   int[] field1865;
   @ObfuscatedName("bg")
   static int[] field1866;

   @ObfuscatedName("v")
   public void method2353(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1835; ++var4) {
         this.field1865[var4] = this.field1865[var4] * var1 / 128;
         this.field1809[var4] = this.field1809[var4] * var2 / 128;
         this.field1815[var4] = this.field1815[var4] * var3 / 128;
      }

      this.field1830 = 0;
   }

   @ObfuscatedName("u")
   public class105 method2354(boolean var1) {
      if(!var1 && field1804.length < this.field1811) {
         field1804 = new byte[this.field1811 + 100];
      }

      return this.method2356(var1, field1833, field1804);
   }

   @ObfuscatedName("b")
   public class105 method2355(boolean var1) {
      if(!var1 && field1816.length < this.field1811) {
         field1816 = new byte[this.field1811 + 100];
      }

      return this.method2356(var1, field1854, field1816);
   }

   @ObfuscatedName("l")
   class105 method2356(boolean var1, class105 var2, byte[] var3) {
      var2.field1835 = this.field1835;
      var2.field1811 = this.field1811;
      var2.field1823 = this.field1823;
      if(var2.field1865 == null || var2.field1865.length < this.field1835) {
         var2.field1865 = new int[this.field1835 + 100];
         var2.field1809 = new int[this.field1835 + 100];
         var2.field1815 = new int[this.field1835 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1835; ++var4) {
         var2.field1865[var4] = this.field1865[var4];
         var2.field1809[var4] = this.field1809[var4];
         var2.field1815[var4] = this.field1815[var4];
      }

      if(var1) {
         var2.field1821 = this.field1821;
      } else {
         var2.field1821 = var3;
         if(this.field1821 == null) {
            for(var4 = 0; var4 < this.field1811; ++var4) {
               var2.field1821[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1811; ++var4) {
               var2.field1821[var4] = this.field1821[var4];
            }
         }
      }

      var2.field1846 = this.field1846;
      var2.field1813 = this.field1813;
      var2.field1814 = this.field1814;
      var2.field1819 = this.field1819;
      var2.field1827 = this.field1827;
      var2.field1817 = this.field1817;
      var2.field1818 = this.field1818;
      var2.field1820 = this.field1820;
      var2.field1863 = this.field1863;
      var2.field1822 = this.field1822;
      var2.field1824 = this.field1824;
      var2.field1825 = this.field1825;
      var2.field1826 = this.field1826;
      var2.field1849 = this.field1849;
      var2.field1828 = this.field1828;
      var2.field1829 = this.field1829;
      var2.field1830 = 0;
      return var2;
   }

   @ObfuscatedName("d")
   public void method2357() {
      if(this.field1830 != 1) {
         this.field1830 = 1;
         super.field1468 = 0;
         this.field1831 = 0;
         this.field1832 = 0;

         for(int var1 = 0; var1 < this.field1835; ++var1) {
            int var2 = this.field1865[var1];
            int var3 = this.field1809[var1];
            int var4 = this.field1815[var1];
            if(-var3 > super.field1468) {
               super.field1468 = -var3;
            }

            if(var3 > this.field1831) {
               this.field1831 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1832) {
               this.field1832 = var5;
            }
         }

         this.field1832 = (int)(Math.sqrt((double)this.field1832) + 0.99D);
         this.field1834 = (int)(Math.sqrt((double)(this.field1832 * this.field1832 + super.field1468 * super.field1468)) + 0.99D);
         this.field1855 = this.field1834 + (int)(Math.sqrt((double)(this.field1832 * this.field1832 + this.field1831 * this.field1831)) + 0.99D);
      }
   }

   @ObfuscatedName("n")
   void method2358() {
      if(this.field1830 != 2) {
         this.field1830 = 2;
         this.field1832 = 0;

         for(int var1 = 0; var1 < this.field1835; ++var1) {
            int var2 = this.field1865[var1];
            int var3 = this.field1809[var1];
            int var4 = this.field1815[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1832) {
               this.field1832 = var5;
            }
         }

         this.field1832 = (int)(Math.sqrt((double)this.field1832) + 0.99D);
         this.field1834 = this.field1832;
         this.field1855 = this.field1832 + this.field1832;
      }
   }

   @ObfuscatedName("m")
   public int method2359() {
      this.method2357();
      return this.field1832;
   }

   @ObfuscatedName("s")
   public void method2361(class103 var1, int var2, class103 var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            class88 var6 = var1.field1774[var2];
            class88 var7 = var3.field1774[var4];
            class102 var8 = var6.field1546;
            field1844 = 0;
            field1856 = 0;
            field1857 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1551; ++var11) {
               for(var12 = var6.field1552[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field1769[var12] == 0) {
                  this.method2401(var8.field1769[var12], var8.field1767[var12], var6.field1553[var11], var6.field1547[var11], var6.field1550[var11]);
               }
            }

            field1844 = 0;
            field1856 = 0;
            field1857 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1551; ++var11) {
               for(var12 = var7.field1552[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field1769[var12] == 0) {
                  this.method2401(var8.field1769[var12], var8.field1767[var12], var7.field1553[var11], var7.field1547[var11], var7.field1550[var11]);
               }
            }

            this.field1830 = 0;
         } else {
            this.method2373(var1, var2);
         }
      }
   }

   public class105(class105[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1835 = 0;
      this.field1811 = 0;
      this.field1823 = 0;
      this.field1822 = -1;

      int var7;
      class105 var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1835 += var8.field1835;
            this.field1811 += var8.field1811;
            this.field1823 += var8.field1823;
            if(var8.field1818 != null) {
               var3 = true;
            } else {
               if(this.field1822 == -1) {
                  this.field1822 = var8.field1822;
               }

               if(this.field1822 != var8.field1822) {
                  var3 = true;
               }
            }

            var4 |= var8.field1821 != null;
            var5 |= var8.field1863 != null;
            var6 |= var8.field1820 != null;
         }
      }

      this.field1865 = new int[this.field1835];
      this.field1809 = new int[this.field1835];
      this.field1815 = new int[this.field1835];
      this.field1846 = new int[this.field1811];
      this.field1813 = new int[this.field1811];
      this.field1814 = new int[this.field1811];
      this.field1819 = new int[this.field1811];
      this.field1827 = new int[this.field1811];
      this.field1817 = new int[this.field1811];
      if(var3) {
         this.field1818 = new byte[this.field1811];
      }

      if(var4) {
         this.field1821 = new byte[this.field1811];
      }

      if(var5) {
         this.field1863 = new short[this.field1811];
      }

      if(var6) {
         this.field1820 = new byte[this.field1811];
      }

      if(this.field1823 > 0) {
         this.field1824 = new int[this.field1823];
         this.field1825 = new int[this.field1823];
         this.field1826 = new int[this.field1823];
      }

      this.field1835 = 0;
      this.field1811 = 0;
      this.field1823 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1811; ++var9) {
               this.field1846[this.field1811] = var8.field1846[var9] + this.field1835;
               this.field1813[this.field1811] = var8.field1813[var9] + this.field1835;
               this.field1814[this.field1811] = var8.field1814[var9] + this.field1835;
               this.field1819[this.field1811] = var8.field1819[var9];
               this.field1827[this.field1811] = var8.field1827[var9];
               this.field1817[this.field1811] = var8.field1817[var9];
               if(var3) {
                  if(var8.field1818 != null) {
                     this.field1818[this.field1811] = var8.field1818[var9];
                  } else {
                     this.field1818[this.field1811] = var8.field1822;
                  }
               }

               if(var4 && var8.field1821 != null) {
                  this.field1821[this.field1811] = var8.field1821[var9];
               }

               if(var5) {
                  if(var8.field1863 != null) {
                     this.field1863[this.field1811] = var8.field1863[var9];
                  } else {
                     this.field1863[this.field1811] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1820 != null && var8.field1820[var9] != -1) {
                     this.field1820[this.field1811] = (byte)(var8.field1820[var9] + this.field1823);
                  } else {
                     this.field1820[this.field1811] = -1;
                  }
               }

               ++this.field1811;
            }

            for(var9 = 0; var9 < var8.field1823; ++var9) {
               this.field1824[this.field1823] = var8.field1824[var9] + this.field1835;
               this.field1825[this.field1823] = var8.field1825[var9] + this.field1835;
               this.field1826[this.field1823] = var8.field1826[var9] + this.field1835;
               ++this.field1823;
            }

            for(var9 = 0; var9 < var8.field1835; ++var9) {
               this.field1865[this.field1835] = var8.field1865[var9];
               this.field1809[this.field1835] = var8.field1809[var9];
               this.field1815[this.field1835] = var8.field1815[var9];
               ++this.field1835;
            }
         }
      }

   }

   class105() {
   }

   @ObfuscatedName("e")
   public void method2363() {
      for(int var1 = 0; var1 < this.field1835; ++var1) {
         int var2 = this.field1815[var1];
         this.field1815[var1] = this.field1865[var1];
         this.field1865[var1] = -var2;
      }

      this.field1830 = 0;
   }

   @ObfuscatedName("w")
   public void method2365(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1835; ++var4) {
         this.field1865[var4] += var1;
         this.field1809[var4] += var2;
         this.field1815[var4] += var3;
      }

      this.field1830 = 0;
   }

   @ObfuscatedName("y")
   public final void method2367(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1845[0] = -1;
      if(this.field1830 != 2 && this.field1830 != 1) {
         this.method2358();
      }

      int var8 = class91.field1589;
      int var9 = class91.field1585;
      int var10000 = field1806[var1];
      var10000 = field1864[var1];
      int var12 = field1806[var2];
      int var13 = field1864[var2];
      int var14 = field1806[var3];
      int var15 = field1864[var3];
      int var16 = field1806[var4];
      int var17 = field1864[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1835; ++var19) {
         int var20 = this.field1865[var19];
         int var21 = this.field1809[var19];
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
         field1840[var19] = var22 - var18;
         field1838[var19] = var8 + var20 * class91.field1583 / var22;
         field1839[var19] = var9 + var23 * class91.field1583 / var22;
         if(this.field1823 > 0) {
            field1841[var19] = var20;
            field1842[var19] = var23;
            field1805[var19] = var22;
         }
      }

      try {
         this.method2370(false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("c")
   public final void method2368(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1845[0] = -1;
      if(this.field1830 != 2 && this.field1830 != 1) {
         this.method2358();
      }

      int var9 = class91.field1589;
      int var10 = class91.field1585;
      int var10000 = field1806[var1];
      var10000 = field1864[var1];
      int var13 = field1806[var2];
      int var14 = field1864[var2];
      int var15 = field1806[var3];
      int var16 = field1864[var3];
      int var17 = field1806[var4];
      int var18 = field1864[var4];
      int var19 = var6 * var17 + var7 * var18 >> 16;

      for(int var20 = 0; var20 < this.field1835; ++var20) {
         int var21 = this.field1865[var20];
         int var22 = this.field1809[var20];
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
         field1840[var20] = var23 - var19;
         field1838[var20] = var9 + var21 * class91.field1583 / var8;
         field1839[var20] = var10 + var24 * class91.field1583 / var8;
         if(this.field1823 > 0) {
            field1841[var20] = var21;
            field1842[var20] = var24;
            field1805[var20] = var23;
         }
      }

      try {
         this.method2370(false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("z")
   final void method2369(int var1) {
      int var2 = class91.field1589;
      int var3 = class91.field1585;
      int var4 = 0;
      int var5 = this.field1846[var1];
      int var6 = this.field1813[var1];
      int var7 = this.field1814[var1];
      int var8 = field1805[var5];
      int var9 = field1805[var6];
      int var10 = field1805[var7];
      if(this.field1821 == null) {
         class91.field1578 = 0;
      } else {
         class91.field1578 = this.field1821[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1852[var4] = field1838[var5];
         field1859[var4] = field1839[var5];
         field1807[var4++] = this.field1819[var1];
      } else {
         var11 = field1841[var5];
         var12 = field1842[var5];
         var13 = this.field1819[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1866[var10 - var8];
            field1852[var4] = var2 + (var11 + ((field1841[var7] - var11) * var14 >> 16)) * class91.field1583 / 50;
            field1859[var4] = var3 + (var12 + ((field1842[var7] - var12) * var14 >> 16)) * class91.field1583 / 50;
            field1807[var4++] = var13 + ((this.field1817[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1866[var9 - var8];
            field1852[var4] = var2 + (var11 + ((field1841[var6] - var11) * var14 >> 16)) * class91.field1583 / 50;
            field1859[var4] = var3 + (var12 + ((field1842[var6] - var12) * var14 >> 16)) * class91.field1583 / 50;
            field1807[var4++] = var13 + ((this.field1827[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1852[var4] = field1838[var6];
         field1859[var4] = field1839[var6];
         field1807[var4++] = this.field1827[var1];
      } else {
         var11 = field1841[var6];
         var12 = field1842[var6];
         var13 = this.field1827[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1866[var8 - var9];
            field1852[var4] = var2 + (var11 + ((field1841[var5] - var11) * var14 >> 16)) * class91.field1583 / 50;
            field1859[var4] = var3 + (var12 + ((field1842[var5] - var12) * var14 >> 16)) * class91.field1583 / 50;
            field1807[var4++] = var13 + ((this.field1819[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1866[var10 - var9];
            field1852[var4] = var2 + (var11 + ((field1841[var7] - var11) * var14 >> 16)) * class91.field1583 / 50;
            field1859[var4] = var3 + (var12 + ((field1842[var7] - var12) * var14 >> 16)) * class91.field1583 / 50;
            field1807[var4++] = var13 + ((this.field1817[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1852[var4] = field1838[var7];
         field1859[var4] = field1839[var7];
         field1807[var4++] = this.field1817[var1];
      } else {
         var11 = field1841[var7];
         var12 = field1842[var7];
         var13 = this.field1817[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1866[var9 - var10];
            field1852[var4] = var2 + (var11 + ((field1841[var6] - var11) * var14 >> 16)) * class91.field1583 / 50;
            field1859[var4] = var3 + (var12 + ((field1842[var6] - var12) * var14 >> 16)) * class91.field1583 / 50;
            field1807[var4++] = var13 + ((this.field1827[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1866[var8 - var10];
            field1852[var4] = var2 + (var11 + ((field1841[var5] - var11) * var14 >> 16)) * class91.field1583 / 50;
            field1859[var4] = var3 + (var12 + ((field1842[var5] - var12) * var14 >> 16)) * class91.field1583 / 50;
            field1807[var4++] = var13 + ((this.field1819[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1852[0];
      var12 = field1852[1];
      var13 = field1852[2];
      var14 = field1859[0];
      int var15 = field1859[1];
      int var16 = field1859[2];
      class91.field1584 = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class91.field1586 || var12 > class91.field1586 || var13 > class91.field1586) {
            class91.field1584 = true;
         }

         if(this.field1863 != null && this.field1863[var1] != -1) {
            if(this.field1820 != null && this.field1820[var1] != -1) {
               var20 = this.field1820[var1] & 255;
               var17 = this.field1824[var20];
               var18 = this.field1825[var20];
               var19 = this.field1826[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1817[var1] == -1) {
               class91.method2155(var14, var15, var16, var11, var12, var13, this.field1819[var1], this.field1819[var1], this.field1819[var1], field1841[var17], field1841[var18], field1841[var19], field1842[var17], field1842[var18], field1842[var19], field1805[var17], field1805[var18], field1805[var19], this.field1863[var1]);
            } else {
               class91.method2155(var14, var15, var16, var11, var12, var13, field1807[0], field1807[1], field1807[2], field1841[var17], field1841[var18], field1841[var19], field1842[var17], field1842[var18], field1842[var19], field1805[var17], field1805[var18], field1805[var19], this.field1863[var1]);
            }
         } else if(this.field1817[var1] == -1) {
            class91.method2153(var14, var15, var16, var11, var12, var13, field1850[this.field1819[var1]]);
         } else {
            class91.method2169(var14, var15, var16, var11, var12, var13, field1807[0], field1807[1], field1807[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class91.field1586 || var12 > class91.field1586 || var13 > class91.field1586 || field1852[3] < 0 || field1852[3] > class91.field1586) {
            class91.field1584 = true;
         }

         if(this.field1863 != null && this.field1863[var1] != -1) {
            if(this.field1820 != null && this.field1820[var1] != -1) {
               var20 = this.field1820[var1] & 255;
               var17 = this.field1824[var20];
               var18 = this.field1825[var20];
               var19 = this.field1826[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1863[var1];
            if(this.field1817[var1] == -1) {
               class91.method2155(var14, var15, var16, var11, var12, var13, this.field1819[var1], this.field1819[var1], this.field1819[var1], field1841[var17], field1841[var18], field1841[var19], field1842[var17], field1842[var18], field1842[var19], field1805[var17], field1805[var18], field1805[var19], var21);
               class91.method2155(var14, var16, field1859[3], var11, var13, field1852[3], this.field1819[var1], this.field1819[var1], this.field1819[var1], field1841[var17], field1841[var18], field1841[var19], field1842[var17], field1842[var18], field1842[var19], field1805[var17], field1805[var18], field1805[var19], var21);
            } else {
               class91.method2155(var14, var15, var16, var11, var12, var13, field1807[0], field1807[1], field1807[2], field1841[var17], field1841[var18], field1841[var19], field1842[var17], field1842[var18], field1842[var19], field1805[var17], field1805[var18], field1805[var19], var21);
               class91.method2155(var14, var16, field1859[3], var11, var13, field1852[3], field1807[0], field1807[2], field1807[3], field1841[var17], field1841[var18], field1841[var19], field1842[var17], field1842[var18], field1842[var19], field1805[var17], field1805[var18], field1805[var19], var21);
            }
         } else if(this.field1817[var1] == -1) {
            var17 = field1850[this.field1819[var1]];
            class91.method2153(var14, var15, var16, var11, var12, var13, var17);
            class91.method2153(var14, var16, field1859[3], var11, var13, field1852[3], var17);
         } else {
            class91.method2169(var14, var15, var16, var11, var12, var13, field1807[0], field1807[1], field1807[2]);
            class91.method2169(var14, var16, field1859[3], var11, var13, field1852[3], field1807[0], field1807[2], field1807[3]);
         }
      }

   }

   @ObfuscatedName("i")
   final void method2370(boolean var1, boolean var2, int var3) {
      if(this.field1855 < 1600) {
         int var4;
         for(var4 = 0; var4 < this.field1855; ++var4) {
            field1845[var4] = 0;
         }

         int var5;
         int var6;
         int var7;
         int var8;
         int var9;
         int var12;
         int var13;
         int var15;
         int var24;
         for(var4 = 0; var4 < this.field1811; ++var4) {
            if(this.field1817[var4] != -2) {
               var5 = this.field1846[var4];
               var6 = this.field1813[var4];
               var7 = this.field1814[var4];
               var8 = field1838[var5];
               var9 = field1838[var6];
               var24 = field1838[var7];
               int var25;
               if(var1 && (var8 == -5000 || var9 == -5000 || var24 == -5000)) {
                  var25 = field1841[var5];
                  var12 = field1841[var6];
                  var13 = field1841[var7];
                  int var14 = field1842[var5];
                  var15 = field1842[var6];
                  int var16 = field1842[var7];
                  int var17 = field1805[var5];
                  int var18 = field1805[var6];
                  int var19 = field1805[var7];
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
                     field1837[var4] = true;
                     int var23 = (field1840[var5] + field1840[var6] + field1840[var7]) / 3 + this.field1834;
                     field1803[var23][field1845[var23]++] = var4;
                  }
               } else {
                  if(var2 && this.method2407(field1853, field1860, field1839[var5], field1839[var6], field1839[var7], var8, var9, var24)) {
                     field1862[field1861++] = var3;
                     var2 = false;
                  }

                  if((var8 - var9) * (field1839[var7] - field1839[var6]) - (field1839[var5] - field1839[var6]) * (var24 - var9) > 0) {
                     field1837[var4] = false;
                     if(var8 >= 0 && var9 >= 0 && var24 >= 0 && var8 <= class91.field1586 && var9 <= class91.field1586 && var24 <= class91.field1586) {
                        field1836[var4] = false;
                     } else {
                        field1836[var4] = true;
                     }

                     var25 = (field1840[var5] + field1840[var6] + field1840[var7]) / 3 + this.field1834;
                     field1803[var25][field1845[var25]++] = var4;
                  }
               }
            }
         }

         int[] var26;
         if(this.field1818 == null) {
            for(var4 = this.field1855 - 1; var4 >= 0; --var4) {
               var5 = field1845[var4];
               if(var5 > 0) {
                  var26 = field1803[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     this.method2397(var26[var7]);
                  }
               }
            }

         } else {
            for(var4 = 0; var4 < 12; ++var4) {
               field1847[var4] = 0;
               field1851[var4] = 0;
            }

            for(var4 = this.field1855 - 1; var4 >= 0; --var4) {
               var5 = field1845[var4];
               if(var5 > 0) {
                  var26 = field1803[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     var8 = var26[var7];
                     byte var28 = this.field1818[var8];
                     var24 = field1847[var28]++;
                     field1848[var28][var24] = var8;
                     if(var28 < 10) {
                        field1851[var28] += var4;
                     } else if(var28 == 10) {
                        field1810[var24] = var4;
                     } else {
                        field1843[var24] = var4;
                     }
                  }
               }
            }

            var4 = 0;
            if(field1847[1] > 0 || field1847[2] > 0) {
               var4 = (field1851[1] + field1851[2]) / (field1847[1] + field1847[2]);
            }

            var5 = 0;
            if(field1847[3] > 0 || field1847[4] > 0) {
               var5 = (field1851[3] + field1851[4]) / (field1847[3] + field1847[4]);
            }

            var6 = 0;
            if(field1847[6] > 0 || field1847[8] > 0) {
               var6 = (field1851[6] + field1851[8]) / (field1847[6] + field1847[8]);
            }

            var8 = 0;
            var9 = field1847[10];
            int[] var10 = field1848[10];
            int[] var11 = field1810;
            if(var8 == var9) {
               var8 = 0;
               var9 = field1847[11];
               var10 = field1848[11];
               var11 = field1843;
            }

            if(var8 < var9) {
               var7 = var11[var8];
            } else {
               var7 = -1000;
            }

            for(var12 = 0; var12 < 10; ++var12) {
               while(var12 == 0 && var7 > var4) {
                  this.method2397(var10[var8++]);
                  if(var8 == var9 && var10 != field1848[11]) {
                     var8 = 0;
                     var9 = field1847[11];
                     var10 = field1848[11];
                     var11 = field1843;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 3 && var7 > var5) {
                  this.method2397(var10[var8++]);
                  if(var8 == var9 && var10 != field1848[11]) {
                     var8 = 0;
                     var9 = field1847[11];
                     var10 = field1848[11];
                     var11 = field1843;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 5 && var7 > var6) {
                  this.method2397(var10[var8++]);
                  if(var8 == var9 && var10 != field1848[11]) {
                     var8 = 0;
                     var9 = field1847[11];
                     var10 = field1848[11];
                     var11 = field1843;
                  }

                  if(var8 < var9) {
                     var7 = var11[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               var13 = field1847[var12];
               int[] var27 = field1848[var12];

               for(var15 = 0; var15 < var13; ++var15) {
                  this.method2397(var27[var15]);
               }
            }

            while(var7 != -1000) {
               this.method2397(var10[var8++]);
               if(var8 == var9 && var10 != field1848[11]) {
                  var8 = 0;
                  var10 = field1848[11];
                  var9 = field1847[11];
                  var11 = field1843;
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

   @ObfuscatedName("f")
   public class105 method2371(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2357();
      int var7 = var2 - this.field1832;
      int var8 = var2 + this.field1832;
      int var9 = var4 - this.field1832;
      int var10 = var4 + this.field1832;
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
               var11.field1835 = this.field1835;
               var11.field1811 = this.field1811;
               var11.field1823 = this.field1823;
               var11.field1865 = this.field1865;
               var11.field1815 = this.field1815;
               var11.field1846 = this.field1846;
               var11.field1813 = this.field1813;
               var11.field1814 = this.field1814;
               var11.field1819 = this.field1819;
               var11.field1827 = this.field1827;
               var11.field1817 = this.field1817;
               var11.field1818 = this.field1818;
               var11.field1821 = this.field1821;
               var11.field1820 = this.field1820;
               var11.field1863 = this.field1863;
               var11.field1822 = this.field1822;
               var11.field1824 = this.field1824;
               var11.field1825 = this.field1825;
               var11.field1826 = this.field1826;
               var11.field1849 = this.field1849;
               var11.field1828 = this.field1828;
               var11.field1829 = this.field1829;
               var11.field1809 = new int[var11.field1835];
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
               for(var12 = 0; var12 < var11.field1835; ++var12) {
                  var13 = this.field1865[var12] + var2;
                  var14 = this.field1815[var12] + var4;
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var1[var17 + 1][var18 + 1] * var15 >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.field1809[var12] = this.field1809[var12] + var21 - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1835; ++var12) {
                  var13 = (-this.field1809[var12] << 16) / super.field1468;
                  if(var13 < var6) {
                     var14 = this.field1865[var12] + var2;
                     var15 = this.field1815[var12] + var4;
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var1[var18 + 1][var19 + 1] * var16 >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.field1809[var12] = this.field1809[var12] + (var22 - var3) * (var6 - var13) / var6;
                  }
               }
            }

            var11.field1830 = 0;
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("t")
   public void method2372(int var1) {
      int var2 = field1806[var1];
      int var3 = field1864[var1];

      for(int var4 = 0; var4 < this.field1835; ++var4) {
         int var5 = this.field1809[var4] * var3 - this.field1815[var4] * var2 >> 16;
         this.field1815[var4] = this.field1809[var4] * var2 + this.field1815[var4] * var3 >> 16;
         this.field1809[var4] = var5;
      }

      this.field1830 = 0;
   }

   @ObfuscatedName("g")
   public void method2373(class103 var1, int var2) {
      if(this.field1849 != null) {
         if(var2 != -1) {
            class88 var3 = var1.field1774[var2];
            class102 var4 = var3.field1546;
            field1844 = 0;
            field1856 = 0;
            field1857 = 0;

            for(int var5 = 0; var5 < var3.field1551; ++var5) {
               int var6 = var3.field1552[var5];
               this.method2401(var4.field1769[var6], var4.field1767[var6], var3.field1553[var5], var3.field1547[var5], var3.field1550[var5]);
            }

            this.field1830 = 0;
         }
      }
   }

   static {
      field1806 = class91.field1597;
      field1864 = class91.field1577;
      field1850 = class91.field1593;
      field1866 = class91.field1596;
   }

   @ObfuscatedName("p")
   public void method2383() {
      for(int var1 = 0; var1 < this.field1835; ++var1) {
         int var2 = this.field1865[var1];
         this.field1865[var1] = this.field1815[var1];
         this.field1815[var1] = -var2;
      }

      this.field1830 = 0;
   }

   @ObfuscatedName("ai")
   void vmethod2396(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1845[0] = -1;
      if(this.field1830 != 1) {
         this.method2357();
      }

      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1832 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1832) * class91.field1583;
         if(var15 / var13 < class91.field1580) {
            int var16 = (var14 + this.field1832) * class91.field1583;
            if(var16 / var13 > class91.field1588) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1832 * var2 >> 16;
               int var19 = (var17 + var18) * class91.field1583;
               if(var19 / var13 > class91.field1590) {
                  int var20 = var18 + (super.field1468 * var3 >> 16);
                  int var21 = (var17 - var20) * class91.field1583;
                  if(var21 / var13 < class91.field1595) {
                     int var22 = var12 + (super.field1468 * var2 >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1823 > 0;
                     boolean var26 = false;
                     int var27;
                     int var28;
                     int var29;
                     if(var9 > 0 && field1858) {
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

                        var28 = field1853 - class91.field1589;
                        var29 = field1860 - class91.field1585;
                        if(var28 > var15 && var28 < var16 && var29 > var21 && var29 < var19) {
                           if(this.field1829) {
                              field1862[field1861++] = var9;
                           } else {
                              var26 = true;
                           }
                        }
                     }

                     var27 = class91.field1589;
                     var28 = class91.field1585;
                     var29 = 0;
                     int var30 = 0;
                     if(var1 != 0) {
                        var29 = field1806[var1];
                        var30 = field1864[var1];
                     }

                     for(int var31 = 0; var31 < this.field1835; ++var31) {
                        int var32 = this.field1865[var31];
                        int var33 = this.field1809[var31];
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
                        field1840[var31] = var34 - var11;
                        if(var34 >= 50) {
                           field1838[var31] = var27 + var32 * class91.field1583 / var34;
                           field1839[var31] = var28 + var35 * class91.field1583 / var34;
                        } else {
                           field1838[var31] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1841[var31] = var32;
                           field1842[var31] = var35;
                           field1805[var31] = var34;
                        }
                     }

                     try {
                        this.method2370(var23, var26, var9);
                     } catch (Exception var37) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("a")
   final void method2397(int var1) {
      if(field1837[var1]) {
         this.method2369(var1);
      } else {
         int var2 = this.field1846[var1];
         int var3 = this.field1813[var1];
         int var4 = this.field1814[var1];
         class91.field1584 = field1836[var1];
         if(this.field1821 == null) {
            class91.field1578 = 0;
         } else {
            class91.field1578 = this.field1821[var1] & 255;
         }

         if(this.field1863 != null && this.field1863[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1820 != null && this.field1820[var1] != -1) {
               int var8 = this.field1820[var1] & 255;
               var5 = this.field1824[var8];
               var6 = this.field1825[var8];
               var7 = this.field1826[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1817[var1] == -1) {
               class91.method2155(field1839[var2], field1839[var3], field1839[var4], field1838[var2], field1838[var3], field1838[var4], this.field1819[var1], this.field1819[var1], this.field1819[var1], field1841[var5], field1841[var6], field1841[var7], field1842[var5], field1842[var6], field1842[var7], field1805[var5], field1805[var6], field1805[var7], this.field1863[var1]);
            } else {
               class91.method2155(field1839[var2], field1839[var3], field1839[var4], field1838[var2], field1838[var3], field1838[var4], this.field1819[var1], this.field1827[var1], this.field1817[var1], field1841[var5], field1841[var6], field1841[var7], field1842[var5], field1842[var6], field1842[var7], field1805[var5], field1805[var6], field1805[var7], this.field1863[var1]);
            }
         } else if(this.field1817[var1] == -1) {
            class91.method2153(field1839[var2], field1839[var3], field1839[var4], field1838[var2], field1838[var3], field1838[var4], field1850[this.field1819[var1]]);
         } else {
            class91.method2169(field1839[var2], field1839[var3], field1839[var4], field1838[var2], field1838[var3], field1838[var4], this.field1819[var1], this.field1827[var1], this.field1817[var1]);
         }

      }
   }

   @ObfuscatedName("r")
   void method2401(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1844 = 0;
         field1856 = 0;
         field1857 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var9 = var2[var8];
            if(var9 < this.field1849.length) {
               int[] var10 = this.field1849[var9];

               for(var11 = 0; var11 < var10.length; ++var11) {
                  var12 = var10[var11];
                  field1844 += this.field1865[var12];
                  field1856 += this.field1809[var12];
                  field1857 += this.field1815[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1844 = field1844 / var7 + var3;
            field1856 = field1856 / var7 + var4;
            field1857 = field1857 / var7 + var5;
         } else {
            field1844 = var3;
            field1856 = var4;
            field1857 = var5;
         }

      } else {
         int var18;
         int[] var19;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1849.length) {
                  var19 = this.field1849[var8];

                  for(var18 = 0; var18 < var19.length; ++var18) {
                     var11 = var19[var18];
                     this.field1865[var11] += var3;
                     this.field1809[var11] += var4;
                     this.field1815[var11] += var5;
                  }
               }
            }

         } else if(var1 == 2) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1849.length) {
                  var19 = this.field1849[var8];

                  for(var18 = 0; var18 < var19.length; ++var18) {
                     var11 = var19[var18];
                     this.field1865[var11] -= field1844;
                     this.field1809[var11] -= field1856;
                     this.field1815[var11] -= field1857;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1806[var14];
                        var16 = field1864[var14];
                        var17 = this.field1809[var11] * var15 + this.field1865[var11] * var16 >> 16;
                        this.field1809[var11] = this.field1809[var11] * var16 - this.field1865[var11] * var15 >> 16;
                        this.field1865[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1806[var12];
                        var16 = field1864[var12];
                        var17 = this.field1809[var11] * var16 - this.field1815[var11] * var15 >> 16;
                        this.field1815[var11] = this.field1809[var11] * var15 + this.field1815[var11] * var16 >> 16;
                        this.field1809[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1806[var13];
                        var16 = field1864[var13];
                        var17 = this.field1815[var11] * var15 + this.field1865[var11] * var16 >> 16;
                        this.field1815[var11] = this.field1815[var11] * var16 - this.field1865[var11] * var15 >> 16;
                        this.field1865[var11] = var17;
                     }

                     this.field1865[var11] += field1844;
                     this.field1809[var11] += field1856;
                     this.field1815[var11] += field1857;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1849.length) {
                  var19 = this.field1849[var8];

                  for(var18 = 0; var18 < var19.length; ++var18) {
                     var11 = var19[var18];
                     this.field1865[var11] -= field1844;
                     this.field1809[var11] -= field1856;
                     this.field1815[var11] -= field1857;
                     this.field1865[var11] = this.field1865[var11] * var3 / 128;
                     this.field1809[var11] = this.field1809[var11] * var4 / 128;
                     this.field1815[var11] = this.field1815[var11] * var5 / 128;
                     this.field1865[var11] += field1844;
                     this.field1809[var11] += field1856;
                     this.field1815[var11] += field1857;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1828 != null && this.field1821 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1828.length) {
                     var19 = this.field1828[var8];

                     for(var18 = 0; var18 < var19.length; ++var18) {
                        var11 = var19[var18];
                        var12 = (this.field1821[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1821[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("j")
   final boolean method2407(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      return var2 < var3 && var2 < var4 && var2 < var5?false:(var2 > var3 && var2 > var4 && var2 > var5?false:(var1 < var6 && var1 < var7 && var1 < var8?false:var1 <= var6 || var1 <= var7 || var1 <= var8));
   }

   @ObfuscatedName("h")
   public void method2417() {
      for(int var1 = 0; var1 < this.field1835; ++var1) {
         this.field1865[var1] = -this.field1865[var1];
         this.field1815[var1] = -this.field1815[var1];
      }

      this.field1830 = 0;
   }
}
