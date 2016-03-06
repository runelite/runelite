import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dd")
@Implements("Model")
public class class104 extends class84 {
   @ObfuscatedName("av")
   static int[] field1803 = new int[10];
   @ObfuscatedName("l")
   static byte[] field1804 = new byte[1];
   @ObfuscatedName("a")
   static class104 field1805 = new class104();
   @ObfuscatedName("i")
   static byte[] field1806 = new byte[1];
   @ObfuscatedName("f")
   int field1807 = 0;
   @ObfuscatedName("j")
   static class104 field1808 = new class104();
   @ObfuscatedName("o")
   int[] field1809;
   @ObfuscatedName("h")
   int[] field1810;
   @ObfuscatedName("n")
   int field1811 = 0;
   @ObfuscatedName("k")
   int[] field1812;
   @ObfuscatedName("r")
   int[] field1813;
   @ObfuscatedName("ae")
   static int[] field1814 = new int[12];
   @ObfuscatedName("q")
   int[] field1815;
   @ObfuscatedName("aq")
   static int[][] field1816 = new int[1600][512];
   @ObfuscatedName("g")
   int[] field1817;
   @ObfuscatedName("v")
   int[][] field1818;
   @ObfuscatedName("s")
   byte[] field1819;
   @ObfuscatedName("d")
   byte[] field1820;
   @ObfuscatedName("bl")
   public static int field1821 = 0;
   @ObfuscatedName("p")
   byte field1822 = 0;
   @ObfuscatedName("w")
   int field1823 = 0;
   @ObfuscatedName("t")
   int[] field1824;
   @ObfuscatedName("bs")
   static int field1825;
   @ObfuscatedName("z")
   short[] field1826;
   @ObfuscatedName("e")
   int[][] field1827;
   @ObfuscatedName("bg")
   public static boolean field1828 = false;
   @ObfuscatedName("ab")
   public boolean field1829 = false;
   @ObfuscatedName("ak")
   int field1830;
   @ObfuscatedName("am")
   int field1831;
   @ObfuscatedName("y")
   byte[] field1832;
   @ObfuscatedName("az")
   int field1833;
   @ObfuscatedName("ac")
   int field1834;
   @ObfuscatedName("ah")
   static int[] field1836 = new int[10];
   @ObfuscatedName("ar")
   static boolean[] field1837 = new boolean[4700];
   @ObfuscatedName("aa")
   static int[] field1838 = new int[4700];
   @ObfuscatedName("as")
   static int[] field1839 = new int[4700];
   @ObfuscatedName("ag")
   static int[] field1840 = new int[4700];
   @ObfuscatedName("an")
   static int[] field1841 = new int[4700];
   @ObfuscatedName("u")
   int[] field1842;
   @ObfuscatedName("aw")
   int field1843;
   @ObfuscatedName("aj")
   static int[] field1844 = new int[10];
   @ObfuscatedName("ao")
   static int[] field1845 = new int[4700];
   @ObfuscatedName("m")
   int[] field1846;
   @ObfuscatedName("ap")
   static int[][] field1848 = new int[12][2000];
   @ObfuscatedName("ad")
   static int[] field1849 = new int[2000];
   @ObfuscatedName("bj")
   static int[] field1850;
   @ObfuscatedName("au")
   static int[] field1851 = new int[2000];
   @ObfuscatedName("ai")
   static boolean[] field1852 = new boolean[4700];
   @ObfuscatedName("br")
   public static int field1853 = 0;
   @ObfuscatedName("bi")
   static int[] field1854;
   @ObfuscatedName("af")
   static int[] field1855 = new int[4700];
   @ObfuscatedName("bv")
   static int field1856;
   @ObfuscatedName("bw")
   static int field1857;
   @ObfuscatedName("ay")
   static int[] field1858 = new int[12];
   @ObfuscatedName("bq")
   public static int field1859 = 0;
   @ObfuscatedName("c")
   int[] field1860;
   @ObfuscatedName("b")
   int[] field1861;
   @ObfuscatedName("bk")
   public static int[] field1862 = new int[1000];
   @ObfuscatedName("be")
   static int[] field1863;
   @ObfuscatedName("bc")
   static int[] field1864;
   @ObfuscatedName("al")
   static int[] field1865 = new int[1600];
   @ObfuscatedName("x")
   int[] field1866;

   public class104(class104[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1807 = 0;
      this.field1811 = 0;
      this.field1823 = 0;
      this.field1822 = -1;

      int var7;
      class104 var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1807 += var8.field1807;
            this.field1811 += var8.field1811;
            this.field1823 += var8.field1823;
            if(var8.field1832 != null) {
               var3 = true;
            } else {
               if(this.field1822 == -1) {
                  this.field1822 = var8.field1822;
               }

               if(this.field1822 != var8.field1822) {
                  var3 = true;
               }
            }

            var4 |= var8.field1819 != null;
            var5 |= var8.field1826 != null;
            var6 |= var8.field1820 != null;
         }
      }

      this.field1846 = new int[this.field1807];
      this.field1809 = new int[this.field1807];
      this.field1810 = new int[this.field1807];
      this.field1812 = new int[this.field1811];
      this.field1813 = new int[this.field1811];
      this.field1861 = new int[this.field1811];
      this.field1815 = new int[this.field1811];
      this.field1842 = new int[this.field1811];
      this.field1817 = new int[this.field1811];
      if(var3) {
         this.field1832 = new byte[this.field1811];
      }

      if(var4) {
         this.field1819 = new byte[this.field1811];
      }

      if(var5) {
         this.field1826 = new short[this.field1811];
      }

      if(var6) {
         this.field1820 = new byte[this.field1811];
      }

      if(this.field1823 > 0) {
         this.field1824 = new int[this.field1823];
         this.field1860 = new int[this.field1823];
         this.field1866 = new int[this.field1823];
      }

      this.field1807 = 0;
      this.field1811 = 0;
      this.field1823 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1811; ++var9) {
               this.field1812[this.field1811] = var8.field1812[var9] + this.field1807;
               this.field1813[this.field1811] = var8.field1813[var9] + this.field1807;
               this.field1861[this.field1811] = var8.field1861[var9] + this.field1807;
               this.field1815[this.field1811] = var8.field1815[var9];
               this.field1842[this.field1811] = var8.field1842[var9];
               this.field1817[this.field1811] = var8.field1817[var9];
               if(var3) {
                  if(var8.field1832 != null) {
                     this.field1832[this.field1811] = var8.field1832[var9];
                  } else {
                     this.field1832[this.field1811] = var8.field1822;
                  }
               }

               if(var4 && var8.field1819 != null) {
                  this.field1819[this.field1811] = var8.field1819[var9];
               }

               if(var5) {
                  if(var8.field1826 != null) {
                     this.field1826[this.field1811] = var8.field1826[var9];
                  } else {
                     this.field1826[this.field1811] = -1;
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
               this.field1824[this.field1823] = var8.field1824[var9] + this.field1807;
               this.field1860[this.field1823] = var8.field1860[var9] + this.field1807;
               this.field1866[this.field1823] = var8.field1866[var9] + this.field1807;
               ++this.field1823;
            }

            for(var9 = 0; var9 < var8.field1807; ++var9) {
               this.field1846[this.field1807] = var8.field1846[var9];
               this.field1809[this.field1807] = var8.field1809[var9];
               this.field1810[this.field1807] = var8.field1810[var9];
               ++this.field1807;
            }
         }
      }

   }

   @ObfuscatedName("o")
   void method2257() {
      if(this.field1830 != 2) {
         this.field1830 = 2;
         this.field1843 = 0;

         for(int var1 = 0; var1 < this.field1807; ++var1) {
            int var2 = this.field1846[var1];
            int var3 = this.field1809[var1];
            int var4 = this.field1810[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1843) {
               this.field1843 = var5;
            }
         }

         this.field1843 = (int)(Math.sqrt((double)this.field1843) + 0.99D);
         this.field1834 = this.field1843;
         this.field1833 = this.field1843 + this.field1843;
      }
   }

   @ObfuscatedName("f")
   class104 method2260(boolean var1, class104 var2, byte[] var3) {
      var2.field1807 = this.field1807;
      var2.field1811 = this.field1811;
      var2.field1823 = this.field1823;
      if(var2.field1846 == null || var2.field1846.length < this.field1807) {
         var2.field1846 = new int[this.field1807 + 100];
         var2.field1809 = new int[this.field1807 + 100];
         var2.field1810 = new int[this.field1807 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1807; ++var4) {
         var2.field1846[var4] = this.field1846[var4];
         var2.field1809[var4] = this.field1809[var4];
         var2.field1810[var4] = this.field1810[var4];
      }

      if(var1) {
         var2.field1819 = this.field1819;
      } else {
         var2.field1819 = var3;
         if(this.field1819 == null) {
            for(var4 = 0; var4 < this.field1811; ++var4) {
               var2.field1819[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1811; ++var4) {
               var2.field1819[var4] = this.field1819[var4];
            }
         }
      }

      var2.field1812 = this.field1812;
      var2.field1813 = this.field1813;
      var2.field1861 = this.field1861;
      var2.field1815 = this.field1815;
      var2.field1842 = this.field1842;
      var2.field1817 = this.field1817;
      var2.field1832 = this.field1832;
      var2.field1820 = this.field1820;
      var2.field1826 = this.field1826;
      var2.field1822 = this.field1822;
      var2.field1824 = this.field1824;
      var2.field1860 = this.field1860;
      var2.field1866 = this.field1866;
      var2.field1827 = this.field1827;
      var2.field1818 = this.field1818;
      var2.field1829 = this.field1829;
      var2.field1830 = 0;
      return var2;
   }

   @ObfuscatedName("m")
   public void method2261() {
      if(this.field1830 != 1) {
         this.field1830 = 1;
         super.field1461 = 0;
         this.field1831 = 0;
         this.field1843 = 0;

         for(int var1 = 0; var1 < this.field1807; ++var1) {
            int var2 = this.field1846[var1];
            int var3 = this.field1809[var1];
            int var4 = this.field1810[var1];
            if(-var3 > super.field1461) {
               super.field1461 = -var3;
            }

            if(var3 > this.field1831) {
               this.field1831 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1843) {
               this.field1843 = var5;
            }
         }

         this.field1843 = (int)(Math.sqrt((double)this.field1843) + 0.99D);
         this.field1834 = (int)(Math.sqrt((double)(this.field1843 * this.field1843 + super.field1461 * super.field1461)) + 0.99D);
         this.field1833 = this.field1834 + (int)(Math.sqrt((double)(this.field1843 * this.field1843 + this.field1831 * this.field1831)) + 0.99D);
      }
   }

   @ObfuscatedName("g")
   public void method2262() {
      for(int var1 = 0; var1 < this.field1807; ++var1) {
         int var2 = this.field1810[var1];
         this.field1810[var1] = this.field1846[var1];
         this.field1846[var1] = -var2;
      }

      this.field1830 = 0;
   }

   @ObfuscatedName("h")
   public int method2263() {
      this.method2261();
      return this.field1843;
   }

   class104() {
   }

   @ObfuscatedName("k")
   public void method2264(class102 var1, int var2, class102 var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            class87 var6 = var1.field1778[var2];
            class87 var7 = var3.field1778[var4];
            class101 var8 = var6.field1540;
            field1825 = 0;
            field1856 = 0;
            field1857 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1541; ++var11) {
               for(var12 = var6.field1539[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field1771[var12] == 0) {
                  this.method2265(var8.field1771[var12], var8.field1772[var12], var6.field1543[var11], var6.field1542[var11], var6.field1545[var11]);
               }
            }

            field1825 = 0;
            field1856 = 0;
            field1857 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1541; ++var11) {
               for(var12 = var7.field1539[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field1771[var12] == 0) {
                  this.method2265(var8.field1771[var12], var8.field1772[var12], var7.field1543[var11], var7.field1542[var11], var7.field1545[var11]);
               }
            }

            this.field1830 = 0;
         } else {
            this.method2316(var1, var2);
         }
      }
   }

   @ObfuscatedName("b")
   void method2265(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1825 = 0;
         field1856 = 0;
         field1857 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var18 = var2[var8];
            if(var18 < this.field1827.length) {
               int[] var19 = this.field1827[var18];

               for(var11 = 0; var11 < var19.length; ++var11) {
                  var12 = var19[var11];
                  field1825 += this.field1846[var12];
                  field1856 += this.field1809[var12];
                  field1857 += this.field1810[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1825 = field1825 / var7 + var3;
            field1856 = field1856 / var7 + var4;
            field1857 = field1857 / var7 + var5;
         } else {
            field1825 = var3;
            field1856 = var4;
            field1857 = var5;
         }

      } else {
         int[] var9;
         int var10;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1827.length) {
                  var9 = this.field1827[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.field1846[var11] += var3;
                     this.field1809[var11] += var4;
                     this.field1810[var11] += var5;
                  }
               }
            }

         } else if(var1 == 2) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1827.length) {
                  var9 = this.field1827[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.field1846[var11] -= field1825;
                     this.field1809[var11] -= field1856;
                     this.field1810[var11] -= field1857;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1863[var14];
                        var16 = field1864[var14];
                        var17 = this.field1809[var11] * var15 + this.field1846[var11] * var16 >> 16;
                        this.field1809[var11] = this.field1809[var11] * var16 - this.field1846[var11] * var15 >> 16;
                        this.field1846[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1863[var12];
                        var16 = field1864[var12];
                        var17 = this.field1809[var11] * var16 - this.field1810[var11] * var15 >> 16;
                        this.field1810[var11] = this.field1809[var11] * var15 + this.field1810[var11] * var16 >> 16;
                        this.field1809[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1863[var13];
                        var16 = field1864[var13];
                        var17 = this.field1810[var11] * var15 + this.field1846[var11] * var16 >> 16;
                        this.field1810[var11] = this.field1810[var11] * var16 - this.field1846[var11] * var15 >> 16;
                        this.field1846[var11] = var17;
                     }

                     this.field1846[var11] += field1825;
                     this.field1809[var11] += field1856;
                     this.field1810[var11] += field1857;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1827.length) {
                  var9 = this.field1827[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.field1846[var11] -= field1825;
                     this.field1809[var11] -= field1856;
                     this.field1810[var11] -= field1857;
                     this.field1846[var11] = this.field1846[var11] * var3 / 128;
                     this.field1809[var11] = this.field1809[var11] * var4 / 128;
                     this.field1810[var11] = this.field1810[var11] * var5 / 128;
                     this.field1846[var11] += field1825;
                     this.field1809[var11] += field1856;
                     this.field1810[var11] += field1857;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1818 != null && this.field1819 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1818.length) {
                     var9 = this.field1818[var8];

                     for(var10 = 0; var10 < var9.length; ++var10) {
                        var11 = var9[var10];
                        var12 = (this.field1819[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1819[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("q")
   public void method2266() {
      for(int var1 = 0; var1 < this.field1807; ++var1) {
         int var2 = this.field1846[var1];
         this.field1846[var1] = this.field1810[var1];
         this.field1810[var1] = -var2;
      }

      this.field1830 = 0;
   }

   @ObfuscatedName("u")
   public void method2267() {
      for(int var1 = 0; var1 < this.field1807; ++var1) {
         this.field1846[var1] = -this.field1846[var1];
         this.field1810[var1] = -this.field1810[var1];
      }

      this.field1830 = 0;
   }

   @ObfuscatedName("y")
   public void method2269(int var1) {
      int var2 = field1863[var1];
      int var3 = field1864[var1];

      for(int var4 = 0; var4 < this.field1807; ++var4) {
         int var5 = this.field1809[var4] * var3 - this.field1810[var4] * var2 >> 16;
         this.field1810[var4] = this.field1809[var4] * var2 + this.field1810[var4] * var3 >> 16;
         this.field1809[var4] = var5;
      }

      this.field1830 = 0;
   }

   @ObfuscatedName("s")
   public void method2270(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1807; ++var4) {
         this.field1846[var4] += var1;
         this.field1809[var4] += var2;
         this.field1810[var4] += var3;
      }

      this.field1830 = 0;
   }

   @ObfuscatedName("p")
   public final void method2273(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1865[0] = -1;
      if(this.field1830 != 2 && this.field1830 != 1) {
         this.method2257();
      }

      int var9 = class90.field1577;
      int var10 = class90.field1578;
      int var10000 = field1863[var1];
      var10000 = field1864[var1];
      int var13 = field1863[var2];
      int var14 = field1864[var2];
      int var15 = field1863[var3];
      int var16 = field1864[var3];
      int var17 = field1863[var4];
      int var18 = field1864[var4];
      int var19 = var6 * var17 + var7 * var18 >> 16;

      for(int var20 = 0; var20 < this.field1807; ++var20) {
         int var21 = this.field1846[var20];
         int var22 = this.field1809[var20];
         int var23 = this.field1810[var20];
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
         field1838[var20] = var9 + var21 * class90.field1575 / var8;
         field1839[var20] = var10 + var24 * class90.field1575 / var8;
         if(this.field1823 > 0) {
            field1855[var20] = var21;
            field1845[var20] = var24;
            field1841[var20] = var23;
         }
      }

      try {
         this.method2297(false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("c")
   final void method2277(int var1) {
      int var2 = class90.field1577;
      int var3 = class90.field1578;
      int var4 = 0;
      int var5 = this.field1812[var1];
      int var6 = this.field1813[var1];
      int var7 = this.field1861[var1];
      int var8 = field1841[var5];
      int var9 = field1841[var6];
      int var10 = field1841[var7];
      if(this.field1819 == null) {
         class90.field1571 = 0;
      } else {
         class90.field1571 = this.field1819[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1803[var4] = field1838[var5];
         field1836[var4] = field1839[var5];
         field1844[var4++] = this.field1815[var1];
      } else {
         var11 = field1855[var5];
         var12 = field1845[var5];
         var13 = this.field1815[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1854[var10 - var8];
            field1803[var4] = var2 + (var11 + ((field1855[var7] - var11) * var14 >> 16)) * class90.field1575 / 50;
            field1836[var4] = var3 + (var12 + ((field1845[var7] - var12) * var14 >> 16)) * class90.field1575 / 50;
            field1844[var4++] = var13 + ((this.field1817[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1854[var9 - var8];
            field1803[var4] = var2 + (var11 + ((field1855[var6] - var11) * var14 >> 16)) * class90.field1575 / 50;
            field1836[var4] = var3 + (var12 + ((field1845[var6] - var12) * var14 >> 16)) * class90.field1575 / 50;
            field1844[var4++] = var13 + ((this.field1842[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1803[var4] = field1838[var6];
         field1836[var4] = field1839[var6];
         field1844[var4++] = this.field1842[var1];
      } else {
         var11 = field1855[var6];
         var12 = field1845[var6];
         var13 = this.field1842[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1854[var8 - var9];
            field1803[var4] = var2 + (var11 + ((field1855[var5] - var11) * var14 >> 16)) * class90.field1575 / 50;
            field1836[var4] = var3 + (var12 + ((field1845[var5] - var12) * var14 >> 16)) * class90.field1575 / 50;
            field1844[var4++] = var13 + ((this.field1815[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1854[var10 - var9];
            field1803[var4] = var2 + (var11 + ((field1855[var7] - var11) * var14 >> 16)) * class90.field1575 / 50;
            field1836[var4] = var3 + (var12 + ((field1845[var7] - var12) * var14 >> 16)) * class90.field1575 / 50;
            field1844[var4++] = var13 + ((this.field1817[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1803[var4] = field1838[var7];
         field1836[var4] = field1839[var7];
         field1844[var4++] = this.field1817[var1];
      } else {
         var11 = field1855[var7];
         var12 = field1845[var7];
         var13 = this.field1817[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1854[var9 - var10];
            field1803[var4] = var2 + (var11 + ((field1855[var6] - var11) * var14 >> 16)) * class90.field1575 / 50;
            field1836[var4] = var3 + (var12 + ((field1845[var6] - var12) * var14 >> 16)) * class90.field1575 / 50;
            field1844[var4++] = var13 + ((this.field1842[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1854[var8 - var10];
            field1803[var4] = var2 + (var11 + ((field1855[var5] - var11) * var14 >> 16)) * class90.field1575 / 50;
            field1836[var4] = var3 + (var12 + ((field1845[var5] - var12) * var14 >> 16)) * class90.field1575 / 50;
            field1844[var4++] = var13 + ((this.field1815[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1803[0];
      var12 = field1803[1];
      var13 = field1803[2];
      var14 = field1836[0];
      int var15 = field1836[1];
      int var16 = field1836[2];
      class90.field1569 = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class90.field1579 || var12 > class90.field1579 || var13 > class90.field1579) {
            class90.field1569 = true;
         }

         if(this.field1826 != null && this.field1826[var1] != -1) {
            if(this.field1820 != null && this.field1820[var1] != -1) {
               var20 = this.field1820[var1] & 255;
               var17 = this.field1824[var20];
               var18 = this.field1860[var20];
               var19 = this.field1866[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1817[var1] == -1) {
               class90.method2072(var14, var15, var16, var11, var12, var13, this.field1815[var1], this.field1815[var1], this.field1815[var1], field1855[var17], field1855[var18], field1855[var19], field1845[var17], field1845[var18], field1845[var19], field1841[var17], field1841[var18], field1841[var19], this.field1826[var1]);
            } else {
               class90.method2072(var14, var15, var16, var11, var12, var13, field1844[0], field1844[1], field1844[2], field1855[var17], field1855[var18], field1855[var19], field1845[var17], field1845[var18], field1845[var19], field1841[var17], field1841[var18], field1841[var19], this.field1826[var1]);
            }
         } else if(this.field1817[var1] == -1) {
            class90.method2070(var14, var15, var16, var11, var12, var13, field1850[this.field1815[var1]]);
         } else {
            class90.method2068(var14, var15, var16, var11, var12, var13, field1844[0], field1844[1], field1844[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class90.field1579 || var12 > class90.field1579 || var13 > class90.field1579 || field1803[3] < 0 || field1803[3] > class90.field1579) {
            class90.field1569 = true;
         }

         if(this.field1826 != null && this.field1826[var1] != -1) {
            if(this.field1820 != null && this.field1820[var1] != -1) {
               var20 = this.field1820[var1] & 255;
               var17 = this.field1824[var20];
               var18 = this.field1860[var20];
               var19 = this.field1866[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1826[var1];
            if(this.field1817[var1] == -1) {
               class90.method2072(var14, var15, var16, var11, var12, var13, this.field1815[var1], this.field1815[var1], this.field1815[var1], field1855[var17], field1855[var18], field1855[var19], field1845[var17], field1845[var18], field1845[var19], field1841[var17], field1841[var18], field1841[var19], var21);
               class90.method2072(var14, var16, field1836[3], var11, var13, field1803[3], this.field1815[var1], this.field1815[var1], this.field1815[var1], field1855[var17], field1855[var18], field1855[var19], field1845[var17], field1845[var18], field1845[var19], field1841[var17], field1841[var18], field1841[var19], var21);
            } else {
               class90.method2072(var14, var15, var16, var11, var12, var13, field1844[0], field1844[1], field1844[2], field1855[var17], field1855[var18], field1855[var19], field1845[var17], field1845[var18], field1845[var19], field1841[var17], field1841[var18], field1841[var19], var21);
               class90.method2072(var14, var16, field1836[3], var11, var13, field1803[3], field1844[0], field1844[2], field1844[3], field1855[var17], field1855[var18], field1855[var19], field1845[var17], field1845[var18], field1845[var19], field1841[var17], field1841[var18], field1841[var19], var21);
            }
         } else if(this.field1817[var1] == -1) {
            var17 = field1850[this.field1815[var1]];
            class90.method2070(var14, var15, var16, var11, var12, var13, var17);
            class90.method2070(var14, var16, field1836[3], var11, var13, field1803[3], var17);
         } else {
            class90.method2068(var14, var15, var16, var11, var12, var13, field1844[0], field1844[1], field1844[2]);
            class90.method2068(var14, var16, field1836[3], var11, var13, field1803[3], field1844[0], field1844[2], field1844[3]);
         }
      }

   }

   static {
      field1863 = class90.field1587;
      field1864 = class90.field1590;
      field1850 = class90.field1586;
      field1854 = class90.field1589;
   }

   @ObfuscatedName("x")
   final boolean method2285(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      return var2 < var3 && var2 < var4 && var2 < var5?false:(var2 > var3 && var2 > var4 && var2 > var5?false:(var1 < var6 && var1 < var7 && var1 < var8?false:var1 <= var6 || var1 <= var7 || var1 <= var8));
   }

   @ObfuscatedName("t")
   final void method2286(int var1) {
      if(field1837[var1]) {
         this.method2277(var1);
      } else {
         int var2 = this.field1812[var1];
         int var3 = this.field1813[var1];
         int var4 = this.field1861[var1];
         class90.field1569 = field1852[var1];
         if(this.field1819 == null) {
            class90.field1571 = 0;
         } else {
            class90.field1571 = this.field1819[var1] & 255;
         }

         if(this.field1826 != null && this.field1826[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1820 != null && this.field1820[var1] != -1) {
               int var8 = this.field1820[var1] & 255;
               var5 = this.field1824[var8];
               var6 = this.field1860[var8];
               var7 = this.field1866[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1817[var1] == -1) {
               class90.method2072(field1839[var2], field1839[var3], field1839[var4], field1838[var2], field1838[var3], field1838[var4], this.field1815[var1], this.field1815[var1], this.field1815[var1], field1855[var5], field1855[var6], field1855[var7], field1845[var5], field1845[var6], field1845[var7], field1841[var5], field1841[var6], field1841[var7], this.field1826[var1]);
            } else {
               class90.method2072(field1839[var2], field1839[var3], field1839[var4], field1838[var2], field1838[var3], field1838[var4], this.field1815[var1], this.field1842[var1], this.field1817[var1], field1855[var5], field1855[var6], field1855[var7], field1845[var5], field1845[var6], field1845[var7], field1841[var5], field1841[var6], field1841[var7], this.field1826[var1]);
            }
         } else if(this.field1817[var1] == -1) {
            class90.method2070(field1839[var2], field1839[var3], field1839[var4], field1838[var2], field1838[var3], field1838[var4], field1850[this.field1815[var1]]);
         } else {
            class90.method2068(field1839[var2], field1839[var3], field1839[var4], field1838[var2], field1838[var3], field1838[var4], this.field1815[var1], this.field1842[var1], this.field1817[var1]);
         }

      }
   }

   @ObfuscatedName("z")
   public final void method2289(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1865[0] = -1;
      if(this.field1830 != 2 && this.field1830 != 1) {
         this.method2257();
      }

      int var8 = class90.field1577;
      int var9 = class90.field1578;
      int var10000 = field1863[var1];
      var10000 = field1864[var1];
      int var12 = field1863[var2];
      int var13 = field1864[var2];
      int var14 = field1863[var3];
      int var15 = field1864[var3];
      int var16 = field1863[var4];
      int var17 = field1864[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1807; ++var19) {
         int var20 = this.field1846[var19];
         int var21 = this.field1809[var19];
         int var22 = this.field1810[var19];
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
         field1838[var19] = var8 + var20 * class90.field1575 / var22;
         field1839[var19] = var9 + var23 * class90.field1575 / var22;
         if(this.field1823 > 0) {
            field1855[var19] = var20;
            field1845[var19] = var23;
            field1841[var19] = var22;
         }
      }

      try {
         this.method2297(false, false, 0);
      } catch (Exception var24) {
         ;
      }

   }

   @ObfuscatedName("i")
   public class104 method2294(boolean var1) {
      if(!var1 && field1806.length < this.field1811) {
         field1806 = new byte[this.field1811 + 100];
      }

      return this.method2260(var1, field1805, field1806);
   }

   @ObfuscatedName("w")
   final void method2297(boolean var1, boolean var2, int var3) {
      if(this.field1833 < 1600) {
         int var4;
         for(var4 = 0; var4 < this.field1833; ++var4) {
            field1865[var4] = 0;
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
         for(var4 = 0; var4 < this.field1811; ++var4) {
            if(this.field1817[var4] != -2) {
               var5 = this.field1812[var4];
               var6 = this.field1813[var4];
               var7 = this.field1861[var4];
               var8 = field1838[var5];
               var9 = field1838[var6];
               var10 = field1838[var7];
               int var11;
               if(var1 && (var8 == -5000 || var9 == -5000 || var10 == -5000)) {
                  var11 = field1855[var5];
                  var12 = field1855[var6];
                  var13 = field1855[var7];
                  int var14 = field1845[var5];
                  var15 = field1845[var6];
                  int var16 = field1845[var7];
                  int var17 = field1841[var5];
                  int var18 = field1841[var6];
                  int var19 = field1841[var7];
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
                     field1837[var4] = true;
                     int var23 = (field1840[var5] + field1840[var6] + field1840[var7]) / 3 + this.field1834;
                     field1816[var23][field1865[var23]++] = var4;
                  }
               } else {
                  if(var2 && this.method2285(field1859, field1821, field1839[var5], field1839[var6], field1839[var7], var8, var9, var10)) {
                     field1862[field1853++] = var3;
                     var2 = false;
                  }

                  if((var8 - var9) * (field1839[var7] - field1839[var6]) - (field1839[var5] - field1839[var6]) * (var10 - var9) > 0) {
                     field1837[var4] = false;
                     if(var8 >= 0 && var9 >= 0 && var10 >= 0 && var8 <= class90.field1579 && var9 <= class90.field1579 && var10 <= class90.field1579) {
                        field1852[var4] = false;
                     } else {
                        field1852[var4] = true;
                     }

                     var11 = (field1840[var5] + field1840[var6] + field1840[var7]) / 3 + this.field1834;
                     field1816[var11][field1865[var11]++] = var4;
                  }
               }
            }
         }

         int[] var24;
         if(this.field1832 == null) {
            for(var4 = this.field1833 - 1; var4 >= 0; --var4) {
               var5 = field1865[var4];
               if(var5 > 0) {
                  var24 = field1816[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     this.method2286(var24[var7]);
                  }
               }
            }

         } else {
            for(var4 = 0; var4 < 12; ++var4) {
               field1814[var4] = 0;
               field1858[var4] = 0;
            }

            for(var4 = this.field1833 - 1; var4 >= 0; --var4) {
               var5 = field1865[var4];
               if(var5 > 0) {
                  var24 = field1816[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     var8 = var24[var7];
                     byte var25 = this.field1832[var8];
                     var10 = field1814[var25]++;
                     field1848[var25][var10] = var8;
                     if(var25 < 10) {
                        field1858[var25] += var4;
                     } else if(var25 == 10) {
                        field1849[var10] = var4;
                     } else {
                        field1851[var10] = var4;
                     }
                  }
               }
            }

            var4 = 0;
            if(field1814[1] > 0 || field1814[2] > 0) {
               var4 = (field1858[1] + field1858[2]) / (field1814[1] + field1814[2]);
            }

            var5 = 0;
            if(field1814[3] > 0 || field1814[4] > 0) {
               var5 = (field1858[3] + field1858[4]) / (field1814[3] + field1814[4]);
            }

            var6 = 0;
            if(field1814[6] > 0 || field1814[8] > 0) {
               var6 = (field1858[6] + field1858[8]) / (field1814[6] + field1814[8]);
            }

            var8 = 0;
            var9 = field1814[10];
            int[] var26 = field1848[10];
            int[] var27 = field1849;
            if(var8 == var9) {
               var8 = 0;
               var9 = field1814[11];
               var26 = field1848[11];
               var27 = field1851;
            }

            if(var8 < var9) {
               var7 = var27[var8];
            } else {
               var7 = -1000;
            }

            for(var12 = 0; var12 < 10; ++var12) {
               while(var12 == 0 && var7 > var4) {
                  this.method2286(var26[var8++]);
                  if(var8 == var9 && var26 != field1848[11]) {
                     var8 = 0;
                     var9 = field1814[11];
                     var26 = field1848[11];
                     var27 = field1851;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 3 && var7 > var5) {
                  this.method2286(var26[var8++]);
                  if(var8 == var9 && var26 != field1848[11]) {
                     var8 = 0;
                     var9 = field1814[11];
                     var26 = field1848[11];
                     var27 = field1851;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 5 && var7 > var6) {
                  this.method2286(var26[var8++]);
                  if(var8 == var9 && var26 != field1848[11]) {
                     var8 = 0;
                     var9 = field1814[11];
                     var26 = field1848[11];
                     var27 = field1851;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               var13 = field1814[var12];
               int[] var28 = field1848[var12];

               for(var15 = 0; var15 < var13; ++var15) {
                  this.method2286(var28[var15]);
               }
            }

            while(var7 != -1000) {
               this.method2286(var26[var8++]);
               if(var8 == var9 && var26 != field1848[11]) {
                  var8 = 0;
                  var26 = field1848[11];
                  var9 = field1814[11];
                  var27 = field1851;
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

   @ObfuscatedName("v")
   void vmethod2302(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1865[0] = -1;
      if(this.field1830 != 1) {
         this.method2261();
      }

      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1843 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1843) * class90.field1575;
         if(var15 / var13 < class90.field1567) {
            int var16 = (var14 + this.field1843) * class90.field1575;
            if(var16 / var13 > class90.field1581) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1843 * var2 >> 16;
               int var19 = (var17 + var18) * class90.field1575;
               if(var19 / var13 > class90.field1591) {
                  int var20 = var18 + (super.field1461 * var3 >> 16);
                  int var21 = (var17 - var20) * class90.field1575;
                  if(var21 / var13 < class90.field1580) {
                     int var22 = var12 + (super.field1461 * var2 >> 16);
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
                     if(var9 > 0 && field1828) {
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

                        var28 = field1859 - class90.field1577;
                        var29 = field1821 - class90.field1578;
                        if(var28 > var15 && var28 < var16 && var29 > var21 && var29 < var19) {
                           if(this.field1829) {
                              field1862[field1853++] = var9;
                           } else {
                              var26 = true;
                           }
                        }
                     }

                     var27 = class90.field1577;
                     var28 = class90.field1578;
                     var29 = 0;
                     int var30 = 0;
                     if(var1 != 0) {
                        var29 = field1863[var1];
                        var30 = field1864[var1];
                     }

                     for(int var31 = 0; var31 < this.field1807; ++var31) {
                        int var32 = this.field1846[var31];
                        int var33 = this.field1809[var31];
                        int var34 = this.field1810[var31];
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
                           field1838[var31] = var27 + var32 * class90.field1575 / var34;
                           field1839[var31] = var28 + var35 * class90.field1575 / var34;
                        } else {
                           field1838[var31] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1855[var31] = var32;
                           field1845[var31] = var35;
                           field1841[var31] = var34;
                        }
                     }

                     try {
                        this.method2297(var23, var26, var9);
                     } catch (Exception var36) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("d")
   public void method2310(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1807; ++var4) {
         this.field1846[var4] = this.field1846[var4] * var1 / 128;
         this.field1809[var4] = this.field1809[var4] * var2 / 128;
         this.field1810[var4] = this.field1810[var4] * var3 / 128;
      }

      this.field1830 = 0;
   }

   @ObfuscatedName("j")
   public class104 method2311(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2261();
      int var7 = var2 - this.field1843;
      int var8 = var2 + this.field1843;
      int var9 = var4 - this.field1843;
      int var10 = var4 + this.field1843;
      if(var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
         var7 >>= 7;
         var8 = var8 + 127 >> 7;
         var9 >>= 7;
         var10 = var10 + 127 >> 7;
         if(var1[var7][var9] == var3 && var1[var8][var9] == var3 && var1[var7][var10] == var3 && var1[var8][var10] == var3) {
            return this;
         } else {
            class104 var11;
            if(var5) {
               var11 = new class104();
               var11.field1807 = this.field1807;
               var11.field1811 = this.field1811;
               var11.field1823 = this.field1823;
               var11.field1846 = this.field1846;
               var11.field1810 = this.field1810;
               var11.field1812 = this.field1812;
               var11.field1813 = this.field1813;
               var11.field1861 = this.field1861;
               var11.field1815 = this.field1815;
               var11.field1842 = this.field1842;
               var11.field1817 = this.field1817;
               var11.field1832 = this.field1832;
               var11.field1819 = this.field1819;
               var11.field1820 = this.field1820;
               var11.field1826 = this.field1826;
               var11.field1822 = this.field1822;
               var11.field1824 = this.field1824;
               var11.field1860 = this.field1860;
               var11.field1866 = this.field1866;
               var11.field1827 = this.field1827;
               var11.field1818 = this.field1818;
               var11.field1829 = this.field1829;
               var11.field1809 = new int[var11.field1807];
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
               for(var12 = 0; var12 < var11.field1807; ++var12) {
                  var13 = this.field1846[var12] + var2;
                  var14 = this.field1810[var12] + var4;
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
               for(var12 = 0; var12 < var11.field1807; ++var12) {
                  var13 = (-this.field1809[var12] << 16) / super.field1461;
                  if(var13 < var6) {
                     var14 = this.field1846[var12] + var2;
                     var15 = this.field1810[var12] + var4;
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

   @ObfuscatedName("l")
   public class104 method2313(boolean var1) {
      if(!var1 && field1804.length < this.field1811) {
         field1804 = new byte[this.field1811 + 100];
      }

      return this.method2260(var1, field1808, field1804);
   }

   @ObfuscatedName("n")
   public void method2316(class102 var1, int var2) {
      if(this.field1827 != null) {
         if(var2 != -1) {
            class87 var3 = var1.field1778[var2];
            class101 var4 = var3.field1540;
            field1825 = 0;
            field1856 = 0;
            field1857 = 0;

            for(int var5 = 0; var5 < var3.field1541; ++var5) {
               int var6 = var3.field1539[var5];
               this.method2265(var4.field1771[var6], var4.field1772[var6], var3.field1543[var5], var3.field1542[var5], var3.field1545[var5]);
            }

            this.field1830 = 0;
         }
      }
   }
}
