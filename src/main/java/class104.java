import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
@Implements("Model")
public class class104 extends class84 {
   @ObfuscatedName("aq")
   static int[] field1786 = new int[2000];
   @ObfuscatedName("a")
   static class104 field1787 = new class104();
   @ObfuscatedName("u")
   byte[] field1788;
   @ObfuscatedName("c")
   short[] field1789;
   @ObfuscatedName("an")
   static int[] field1790 = new int[1600];
   @ObfuscatedName("bs")
   static int[] field1791;
   @ObfuscatedName("g")
   int[] field1792;
   @ObfuscatedName("m")
   int[] field1793;
   @ObfuscatedName("bp")
   public static boolean field1795 = false;
   @ObfuscatedName("bu")
   public static int[] field1796 = new int[1000];
   @ObfuscatedName("h")
   int[] field1797;
   @ObfuscatedName("i")
   int[] field1798;
   @ObfuscatedName("v")
   int[] field1799;
   @ObfuscatedName("z")
   int[] field1800;
   @ObfuscatedName("bd")
   static int field1801;
   @ObfuscatedName("t")
   byte[] field1802;
   @ObfuscatedName("r")
   static byte[] field1803 = new byte[1];
   @ObfuscatedName("l")
   int[] field1804;
   @ObfuscatedName("x")
   byte field1805 = 0;
   @ObfuscatedName("d")
   int field1806 = 0;
   @ObfuscatedName("p")
   int[] field1807;
   @ObfuscatedName("q")
   int[] field1808;
   @ObfuscatedName("bt")
   static int field1809;
   @ObfuscatedName("k")
   int[][] field1810;
   @ObfuscatedName("o")
   int[][] field1811;
   @ObfuscatedName("ad")
   public boolean field1812 = false;
   @ObfuscatedName("at")
   int field1813;
   @ObfuscatedName("aw")
   int field1814;
   @ObfuscatedName("s")
   static byte[] field1815 = new byte[1];
   @ObfuscatedName("ak")
   int field1816;
   @ObfuscatedName("ah")
   int field1817;
   @ObfuscatedName("ap")
   static int[][] field1818 = new int[12][2000];
   @ObfuscatedName("as")
   static boolean[] field1819 = new boolean[4700];
   @ObfuscatedName("ao")
   static boolean[] field1820 = new boolean[4700];
   @ObfuscatedName("am")
   static int[] field1821 = new int[4700];
   @ObfuscatedName("au")
   static int[] field1822 = new int[10];
   @ObfuscatedName("ab")
   static int[] field1823 = new int[4700];
   @ObfuscatedName("al")
   static int[] field1824 = new int[4700];
   @ObfuscatedName("ar")
   static int[] field1825 = new int[4700];
   @ObfuscatedName("aa")
   static int[] field1826 = new int[4700];
   @ObfuscatedName("f")
   static class104 field1827 = new class104();
   @ObfuscatedName("bl")
   static int[] field1828;
   @ObfuscatedName("av")
   static int[][] field1829 = new int[1600][512];
   @ObfuscatedName("aj")
   static int[] field1830 = new int[12];
   @ObfuscatedName("j")
   int field1831 = 0;
   @ObfuscatedName("b")
   byte[] field1832;
   @ObfuscatedName("af")
   static int[] field1833 = new int[2000];
   @ObfuscatedName("ay")
   static int[] field1834 = new int[12];
   @ObfuscatedName("ax")
   int field1835;
   @ObfuscatedName("az")
   static int[] field1836 = new int[10];
   @ObfuscatedName("w")
   int[] field1837;
   @ObfuscatedName("y")
   int field1838 = 0;
   @ObfuscatedName("br")
   static int field1839;
   @ObfuscatedName("bo")
   static int[] field1840;
   @ObfuscatedName("n")
   int[] field1841;
   @ObfuscatedName("bq")
   public static int field1842 = 0;
   @ObfuscatedName("bv")
   public static int field1843 = 0;
   @ObfuscatedName("by")
   public static int field1844 = 0;
   @ObfuscatedName("e")
   int[] field1846;
   @ObfuscatedName("ae")
   static int[] field1847 = new int[10];
   @ObfuscatedName("ai")
   static int[] field1848 = new int[4700];
   @ObfuscatedName("bn")
   static int[] field1849;

   @ObfuscatedName("e")
   public void method2305() {
      if(this.field1813 != 1) {
         this.field1813 = 1;
         super.field1448 = 0;
         this.field1814 = 0;
         this.field1835 = 0;

         for(int var1 = 0; var1 < this.field1838; ++var1) {
            int var2 = this.field1846[var1];
            int var3 = this.field1792[var1];
            int var4 = this.field1793[var1];
            if(-var3 > super.field1448) {
               super.field1448 = -var3;
            }

            if(var3 > this.field1814) {
               this.field1814 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1835) {
               this.field1835 = var5;
            }
         }

         this.field1835 = (int)(Math.sqrt((double)this.field1835) + 0.99D);
         this.field1817 = (int)(Math.sqrt((double)(this.field1835 * this.field1835 + super.field1448 * super.field1448)) + 0.99D);
         this.field1816 = this.field1817 + (int)(Math.sqrt((double)(this.field1835 * this.field1835 + this.field1814 * this.field1814)) + 0.99D);
      }
   }

   @ObfuscatedName("a")
   public class104 method2307(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2305();
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
            class104 var11;
            if(var5) {
               var11 = new class104();
               var11.field1838 = this.field1838;
               var11.field1831 = this.field1831;
               var11.field1806 = this.field1806;
               var11.field1846 = this.field1846;
               var11.field1793 = this.field1793;
               var11.field1841 = this.field1841;
               var11.field1804 = this.field1804;
               var11.field1797 = this.field1797;
               var11.field1798 = this.field1798;
               var11.field1799 = this.field1799;
               var11.field1800 = this.field1800;
               var11.field1788 = this.field1788;
               var11.field1802 = this.field1802;
               var11.field1832 = this.field1832;
               var11.field1789 = this.field1789;
               var11.field1805 = this.field1805;
               var11.field1807 = this.field1807;
               var11.field1808 = this.field1808;
               var11.field1837 = this.field1837;
               var11.field1810 = this.field1810;
               var11.field1811 = this.field1811;
               var11.field1812 = this.field1812;
               var11.field1792 = new int[var11.field1838];
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
               for(var12 = 0; var12 < var11.field1838; ++var12) {
                  var13 = this.field1846[var12] + var2;
                  var14 = this.field1793[var12] + var4;
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var1[var17 + 1][var18 + 1] * var15 >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.field1792[var12] = this.field1792[var12] + var21 - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1838; ++var12) {
                  var13 = (-this.field1792[var12] << 16) / super.field1448;
                  if(var13 < var6) {
                     var14 = this.field1846[var12] + var2;
                     var15 = this.field1793[var12] + var4;
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var1[var18 + 1][var19 + 1] * var16 >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.field1792[var12] = this.field1792[var12] + (var22 - var3) * (var6 - var13) / var6;
                  }
               }
            }

            var11.field1813 = 0;
            return var11;
         }
      } else {
         return this;
      }
   }

   class104() {
   }

   @ObfuscatedName("s")
   public class104 method2308(boolean var1) {
      if(!var1 && field1815.length < this.field1831) {
         field1815 = new byte[this.field1831 + 100];
      }

      return this.method2313(var1, field1827, field1815);
   }

   @ObfuscatedName("g")
   void method2311() {
      if(this.field1813 != 2) {
         this.field1813 = 2;
         this.field1835 = 0;

         for(int var1 = 0; var1 < this.field1838; ++var1) {
            int var2 = this.field1846[var1];
            int var3 = this.field1792[var1];
            int var4 = this.field1793[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1835) {
               this.field1835 = var5;
            }
         }

         this.field1835 = (int)(Math.sqrt((double)this.field1835) + 0.99D);
         this.field1817 = this.field1835;
         this.field1816 = this.field1835 + this.field1835;
      }
   }

   @ObfuscatedName("y")
   class104 method2313(boolean var1, class104 var2, byte[] var3) {
      var2.field1838 = this.field1838;
      var2.field1831 = this.field1831;
      var2.field1806 = this.field1806;
      if(var2.field1846 == null || var2.field1846.length < this.field1838) {
         var2.field1846 = new int[this.field1838 + 100];
         var2.field1792 = new int[this.field1838 + 100];
         var2.field1793 = new int[this.field1838 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1838; ++var4) {
         var2.field1846[var4] = this.field1846[var4];
         var2.field1792[var4] = this.field1792[var4];
         var2.field1793[var4] = this.field1793[var4];
      }

      if(var1) {
         var2.field1802 = this.field1802;
      } else {
         var2.field1802 = var3;
         if(this.field1802 == null) {
            for(var4 = 0; var4 < this.field1831; ++var4) {
               var2.field1802[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1831; ++var4) {
               var2.field1802[var4] = this.field1802[var4];
            }
         }
      }

      var2.field1841 = this.field1841;
      var2.field1804 = this.field1804;
      var2.field1797 = this.field1797;
      var2.field1798 = this.field1798;
      var2.field1799 = this.field1799;
      var2.field1800 = this.field1800;
      var2.field1788 = this.field1788;
      var2.field1832 = this.field1832;
      var2.field1789 = this.field1789;
      var2.field1805 = this.field1805;
      var2.field1807 = this.field1807;
      var2.field1808 = this.field1808;
      var2.field1837 = this.field1837;
      var2.field1810 = this.field1810;
      var2.field1811 = this.field1811;
      var2.field1812 = this.field1812;
      var2.field1813 = 0;
      return var2;
   }

   @ObfuscatedName("n")
   public void method2314(class102 var1, int var2, class102 var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            class87 var6 = var1.field1765[var2];
            class87 var7 = var3.field1765[var4];
            class101 var8 = var6.field1525;
            field1801 = 0;
            field1839 = 0;
            field1809 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1531; ++var11) {
               for(var12 = var6.field1527[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field1756[var12] == 0) {
                  this.method2315(var8.field1756[var12], var8.field1753[var12], var6.field1529[var11], var6.field1528[var11], var6.field1530[var11]);
               }
            }

            field1801 = 0;
            field1839 = 0;
            field1809 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1531; ++var11) {
               for(var12 = var7.field1527[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field1756[var12] == 0) {
                  this.method2315(var8.field1756[var12], var8.field1753[var12], var7.field1529[var11], var7.field1528[var11], var7.field1530[var11]);
               }
            }

            this.field1813 = 0;
         } else {
            this.method2366(var1, var2);
         }
      }
   }

   @ObfuscatedName("l")
   void method2315(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1801 = 0;
         field1839 = 0;
         field1809 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var18 = var2[var8];
            if(var18 < this.field1810.length) {
               int[] var19 = this.field1810[var18];

               for(var11 = 0; var11 < var19.length; ++var11) {
                  var12 = var19[var11];
                  field1801 += this.field1846[var12];
                  field1839 += this.field1792[var12];
                  field1809 += this.field1793[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1801 = field1801 / var7 + var3;
            field1839 = field1839 / var7 + var4;
            field1809 = field1809 / var7 + var5;
         } else {
            field1801 = var3;
            field1839 = var4;
            field1809 = var5;
         }

      } else {
         int[] var9;
         int var10;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1810.length) {
                  var9 = this.field1810[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.field1846[var11] += var3;
                     this.field1792[var11] += var4;
                     this.field1793[var11] += var5;
                  }
               }
            }

         } else if(var1 == 2) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1810.length) {
                  var9 = this.field1810[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.field1846[var11] -= field1801;
                     this.field1792[var11] -= field1839;
                     this.field1793[var11] -= field1809;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1840[var14];
                        var16 = field1791[var14];
                        var17 = this.field1792[var11] * var15 + this.field1846[var11] * var16 >> 16;
                        this.field1792[var11] = this.field1792[var11] * var16 - this.field1846[var11] * var15 >> 16;
                        this.field1846[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1840[var12];
                        var16 = field1791[var12];
                        var17 = this.field1792[var11] * var16 - this.field1793[var11] * var15 >> 16;
                        this.field1793[var11] = this.field1792[var11] * var15 + this.field1793[var11] * var16 >> 16;
                        this.field1792[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1840[var13];
                        var16 = field1791[var13];
                        var17 = this.field1793[var11] * var15 + this.field1846[var11] * var16 >> 16;
                        this.field1793[var11] = this.field1793[var11] * var16 - this.field1846[var11] * var15 >> 16;
                        this.field1846[var11] = var17;
                     }

                     this.field1846[var11] += field1801;
                     this.field1792[var11] += field1839;
                     this.field1793[var11] += field1809;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1810.length) {
                  var9 = this.field1810[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.field1846[var11] -= field1801;
                     this.field1792[var11] -= field1839;
                     this.field1793[var11] -= field1809;
                     this.field1846[var11] = this.field1846[var11] * var3 / 128;
                     this.field1792[var11] = this.field1792[var11] * var4 / 128;
                     this.field1793[var11] = this.field1793[var11] * var5 / 128;
                     this.field1846[var11] += field1801;
                     this.field1792[var11] += field1839;
                     this.field1793[var11] += field1809;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1811 != null && this.field1802 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1811.length) {
                     var9 = this.field1811[var8];

                     for(var10 = 0; var10 < var9.length; ++var10) {
                        var11 = var9[var10];
                        var12 = (this.field1802[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1802[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("h")
   public void method2316() {
      for(int var1 = 0; var1 < this.field1838; ++var1) {
         int var2 = this.field1846[var1];
         this.field1846[var1] = this.field1793[var1];
         this.field1793[var1] = -var2;
      }

      this.field1813 = 0;
   }

   @ObfuscatedName("v")
   public void method2318() {
      for(int var1 = 0; var1 < this.field1838; ++var1) {
         int var2 = this.field1793[var1];
         this.field1793[var1] = this.field1846[var1];
         this.field1846[var1] = -var2;
      }

      this.field1813 = 0;
   }

   @ObfuscatedName("b")
   public void method2319(int var1) {
      int var2 = field1840[var1];
      int var3 = field1791[var1];

      for(int var4 = 0; var4 < this.field1838; ++var4) {
         int var5 = this.field1792[var4] * var3 - this.field1793[var4] * var2 >> 16;
         this.field1793[var4] = this.field1792[var4] * var2 + this.field1793[var4] * var3 >> 16;
         this.field1792[var4] = var5;
      }

      this.field1813 = 0;
   }

   @ObfuscatedName("c")
   public void method2320(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1838; ++var4) {
         this.field1846[var4] += var1;
         this.field1792[var4] += var2;
         this.field1793[var4] += var3;
      }

      this.field1813 = 0;
   }

   @ObfuscatedName("x")
   public void method2321(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1838; ++var4) {
         this.field1846[var4] = this.field1846[var4] * var1 / 128;
         this.field1792[var4] = this.field1792[var4] * var2 / 128;
         this.field1793[var4] = this.field1793[var4] * var3 / 128;
      }

      this.field1813 = 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "0"
   )
   public final void method2322(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1790[0] = -1;
      if(this.field1813 != 2 && this.field1813 != 1) {
         this.method2311();
      }

      int var8 = class90.field1554;
      int var9 = class90.field1575;
      int var10000 = field1840[var1];
      var10000 = field1791[var1];
      int var12 = field1840[var2];
      int var13 = field1791[var2];
      int var14 = field1840[var3];
      int var15 = field1791[var3];
      int var16 = field1840[var4];
      int var17 = field1791[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1838; ++var19) {
         int var20 = this.field1846[var19];
         int var21 = this.field1792[var19];
         int var22 = this.field1793[var19];
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
         field1823[var19] = var22 - var18;
         field1821[var19] = var8 + var20 * class90.field1562 / var22;
         field1848[var19] = var9 + var23 * class90.field1562 / var22;
         if(this.field1806 > 0) {
            field1824[var19] = var20;
            field1825[var19] = var23;
            field1826[var19] = var22;
         }
      }

      try {
         this.method2325(false, false, 0);
      } catch (Exception var24) {
         ;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "0"
   )
   public final void method2323(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1790[0] = -1;
      if(this.field1813 != 2 && this.field1813 != 1) {
         this.method2311();
      }

      int var9 = class90.field1554;
      int var10 = class90.field1575;
      int var10000 = field1840[var1];
      var10000 = field1791[var1];
      int var13 = field1840[var2];
      int var14 = field1791[var2];
      int var15 = field1840[var3];
      int var16 = field1791[var3];
      int var17 = field1840[var4];
      int var18 = field1791[var4];
      int var19 = var6 * var17 + var7 * var18 >> 16;

      for(int var20 = 0; var20 < this.field1838; ++var20) {
         int var21 = this.field1846[var20];
         int var22 = this.field1792[var20];
         int var23 = this.field1793[var20];
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
         field1823[var20] = var23 - var19;
         field1821[var20] = var9 + var21 * class90.field1562 / var8;
         field1848[var20] = var10 + var24 * class90.field1562 / var8;
         if(this.field1806 > 0) {
            field1824[var20] = var21;
            field1825[var20] = var24;
            field1826[var20] = var23;
         }
      }

      try {
         this.method2325(false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("ac")
   void vmethod2324(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1790[0] = -1;
      if(this.field1813 != 1) {
         this.method2305();
      }

      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1835 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1835) * class90.field1562;
         if(var15 / var13 < class90.field1564) {
            int var16 = (var14 + this.field1835) * class90.field1562;
            if(var16 / var13 > class90.field1568) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1835 * var2 >> 16;
               int var19 = (var17 + var18) * class90.field1562;
               if(var19 / var13 > class90.field1570) {
                  int var20 = var18 + (super.field1448 * var3 >> 16);
                  int var21 = (var17 - var20) * class90.field1562;
                  if(var21 / var13 < class90.field1571) {
                     int var22 = var12 + (super.field1448 * var2 >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1806 > 0;
                     boolean var26 = false;
                     int var27;
                     int var28;
                     int var29;
                     if(var9 > 0 && field1795) {
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

                        var28 = field1842 - class90.field1554;
                        var29 = field1843 - class90.field1575;
                        if(var28 > var15 && var28 < var16 && var29 > var21 && var29 < var19) {
                           if(this.field1812) {
                              field1796[field1844++] = var9;
                           } else {
                              var26 = true;
                           }
                        }
                     }

                     var27 = class90.field1554;
                     var28 = class90.field1575;
                     var29 = 0;
                     int var30 = 0;
                     if(var1 != 0) {
                        var29 = field1840[var1];
                        var30 = field1791[var1];
                     }

                     for(int var31 = 0; var31 < this.field1838; ++var31) {
                        int var32 = this.field1846[var31];
                        int var33 = this.field1792[var31];
                        int var34 = this.field1793[var31];
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
                        field1823[var31] = var34 - var11;
                        if(var34 >= 50) {
                           field1821[var31] = var27 + var32 * class90.field1562 / var34;
                           field1848[var31] = var28 + var35 * class90.field1562 / var34;
                        } else {
                           field1821[var31] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1824[var31] = var32;
                           field1825[var31] = var35;
                           field1826[var31] = var34;
                        }
                     }

                     try {
                        this.method2325(var23, var26, var9);
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
   final void method2325(boolean var1, boolean var2, int var3) {
      if(this.field1816 < 1600) {
         int var4;
         for(var4 = 0; var4 < this.field1816; ++var4) {
            field1790[var4] = 0;
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
         for(var4 = 0; var4 < this.field1831; ++var4) {
            if(this.field1800[var4] != -2) {
               var5 = this.field1841[var4];
               var6 = this.field1804[var4];
               var7 = this.field1797[var4];
               var8 = field1821[var5];
               var9 = field1821[var6];
               var10 = field1821[var7];
               int var11;
               if(!var1 || var8 != -5000 && var9 != -5000 && var10 != -5000) {
                  if(var2 && this.method2370(field1842, field1843, field1848[var5], field1848[var6], field1848[var7], var8, var9, var10)) {
                     field1796[field1844++] = var3;
                     var2 = false;
                  }

                  if((var8 - var9) * (field1848[var7] - field1848[var6]) - (field1848[var5] - field1848[var6]) * (var10 - var9) > 0) {
                     field1820[var4] = false;
                     if(var8 >= 0 && var9 >= 0 && var10 >= 0 && var8 <= class90.field1565 && var9 <= class90.field1565 && var10 <= class90.field1565) {
                        field1819[var4] = false;
                     } else {
                        field1819[var4] = true;
                     }

                     var11 = (field1823[var5] + field1823[var6] + field1823[var7]) / 3 + this.field1817;
                     field1829[var11][field1790[var11]++] = var4;
                  }
               } else {
                  var11 = field1824[var5];
                  var12 = field1824[var6];
                  var13 = field1824[var7];
                  int var14 = field1825[var5];
                  var15 = field1825[var6];
                  int var16 = field1825[var7];
                  int var17 = field1826[var5];
                  int var18 = field1826[var6];
                  int var19 = field1826[var7];
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
                     field1820[var4] = true;
                     int var23 = (field1823[var5] + field1823[var6] + field1823[var7]) / 3 + this.field1817;
                     field1829[var23][field1790[var23]++] = var4;
                  }
               }
            }
         }

         int[] var24;
         if(this.field1788 == null) {
            for(var4 = this.field1816 - 1; var4 >= 0; --var4) {
               var5 = field1790[var4];
               if(var5 > 0) {
                  var24 = field1829[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     this.method2326(var24[var7]);
                  }
               }
            }

         } else {
            for(var4 = 0; var4 < 12; ++var4) {
               field1830[var4] = 0;
               field1834[var4] = 0;
            }

            for(var4 = this.field1816 - 1; var4 >= 0; --var4) {
               var5 = field1790[var4];
               if(var5 > 0) {
                  var24 = field1829[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     var8 = var24[var7];
                     byte var25 = this.field1788[var8];
                     var10 = field1830[var25]++;
                     field1818[var25][var10] = var8;
                     if(var25 < 10) {
                        field1834[var25] += var4;
                     } else if(var25 == 10) {
                        field1786[var10] = var4;
                     } else {
                        field1833[var10] = var4;
                     }
                  }
               }
            }

            var4 = 0;
            if(field1830[1] > 0 || field1830[2] > 0) {
               var4 = (field1834[1] + field1834[2]) / (field1830[1] + field1830[2]);
            }

            var5 = 0;
            if(field1830[3] > 0 || field1830[4] > 0) {
               var5 = (field1834[3] + field1834[4]) / (field1830[3] + field1830[4]);
            }

            var6 = 0;
            if(field1830[6] > 0 || field1830[8] > 0) {
               var6 = (field1834[6] + field1834[8]) / (field1830[6] + field1830[8]);
            }

            var8 = 0;
            var9 = field1830[10];
            int[] var26 = field1818[10];
            int[] var27 = field1786;
            if(var8 == var9) {
               var8 = 0;
               var9 = field1830[11];
               var26 = field1818[11];
               var27 = field1833;
            }

            if(var8 < var9) {
               var7 = var27[var8];
            } else {
               var7 = -1000;
            }

            for(var12 = 0; var12 < 10; ++var12) {
               while(var12 == 0 && var7 > var4) {
                  this.method2326(var26[var8++]);
                  if(var8 == var9 && var26 != field1818[11]) {
                     var8 = 0;
                     var9 = field1830[11];
                     var26 = field1818[11];
                     var27 = field1833;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 3 && var7 > var5) {
                  this.method2326(var26[var8++]);
                  if(var8 == var9 && var26 != field1818[11]) {
                     var8 = 0;
                     var9 = field1830[11];
                     var26 = field1818[11];
                     var27 = field1833;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 5 && var7 > var6) {
                  this.method2326(var26[var8++]);
                  if(var8 == var9 && var26 != field1818[11]) {
                     var8 = 0;
                     var9 = field1830[11];
                     var26 = field1818[11];
                     var27 = field1833;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               var13 = field1830[var12];
               int[] var28 = field1818[var12];

               for(var15 = 0; var15 < var13; ++var15) {
                  this.method2326(var28[var15]);
               }
            }

            while(var7 != -1000) {
               this.method2326(var26[var8++]);
               if(var8 == var9 && var26 != field1818[11]) {
                  var8 = 0;
                  var26 = field1818[11];
                  var9 = field1830[11];
                  var27 = field1833;
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

   @ObfuscatedName("w")
   final void method2326(int var1) {
      if(field1820[var1]) {
         this.method2352(var1);
      } else {
         int var2 = this.field1841[var1];
         int var3 = this.field1804[var1];
         int var4 = this.field1797[var1];
         class90.field1577 = field1819[var1];
         if(this.field1802 == null) {
            class90.field1558 = 0;
         } else {
            class90.field1558 = this.field1802[var1] & 255;
         }

         if(this.field1789 != null && this.field1789[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1832 != null && this.field1832[var1] != -1) {
               int var8 = this.field1832[var1] & 255;
               var5 = this.field1807[var8];
               var6 = this.field1808[var8];
               var7 = this.field1837[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1800[var1] == -1) {
               class90.method2149(field1848[var2], field1848[var3], field1848[var4], field1821[var2], field1821[var3], field1821[var4], this.field1798[var1], this.field1798[var1], this.field1798[var1], field1824[var5], field1824[var6], field1824[var7], field1825[var5], field1825[var6], field1825[var7], field1826[var5], field1826[var6], field1826[var7], this.field1789[var1]);
            } else {
               class90.method2149(field1848[var2], field1848[var3], field1848[var4], field1821[var2], field1821[var3], field1821[var4], this.field1798[var1], this.field1799[var1], this.field1800[var1], field1824[var5], field1824[var6], field1824[var7], field1825[var5], field1825[var6], field1825[var7], field1826[var5], field1826[var6], field1826[var7], this.field1789[var1]);
            }
         } else if(this.field1800[var1] == -1) {
            class90.method2113(field1848[var2], field1848[var3], field1848[var4], field1821[var2], field1821[var3], field1821[var4], field1828[this.field1798[var1]]);
         } else {
            class90.method2111(field1848[var2], field1848[var3], field1848[var4], field1821[var2], field1821[var3], field1821[var4], this.field1798[var1], this.field1799[var1], this.field1800[var1]);
         }

      }
   }

   static {
      field1840 = class90.field1572;
      field1791 = class90.field1578;
      field1828 = class90.field1573;
      field1849 = class90.field1576;
   }

   @ObfuscatedName("m")
   public int method2333() {
      this.method2305();
      return this.field1835;
   }

   public class104(class104[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1838 = 0;
      this.field1831 = 0;
      this.field1806 = 0;
      this.field1805 = -1;

      int var7;
      class104 var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1838 += var8.field1838;
            this.field1831 += var8.field1831;
            this.field1806 += var8.field1806;
            if(var8.field1788 != null) {
               var3 = true;
            } else {
               if(this.field1805 == -1) {
                  this.field1805 = var8.field1805;
               }

               if(this.field1805 != var8.field1805) {
                  var3 = true;
               }
            }

            var4 |= var8.field1802 != null;
            var5 |= var8.field1789 != null;
            var6 |= var8.field1832 != null;
         }
      }

      this.field1846 = new int[this.field1838];
      this.field1792 = new int[this.field1838];
      this.field1793 = new int[this.field1838];
      this.field1841 = new int[this.field1831];
      this.field1804 = new int[this.field1831];
      this.field1797 = new int[this.field1831];
      this.field1798 = new int[this.field1831];
      this.field1799 = new int[this.field1831];
      this.field1800 = new int[this.field1831];
      if(var3) {
         this.field1788 = new byte[this.field1831];
      }

      if(var4) {
         this.field1802 = new byte[this.field1831];
      }

      if(var5) {
         this.field1789 = new short[this.field1831];
      }

      if(var6) {
         this.field1832 = new byte[this.field1831];
      }

      if(this.field1806 > 0) {
         this.field1807 = new int[this.field1806];
         this.field1808 = new int[this.field1806];
         this.field1837 = new int[this.field1806];
      }

      this.field1838 = 0;
      this.field1831 = 0;
      this.field1806 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1831; ++var9) {
               this.field1841[this.field1831] = var8.field1841[var9] + this.field1838;
               this.field1804[this.field1831] = var8.field1804[var9] + this.field1838;
               this.field1797[this.field1831] = var8.field1797[var9] + this.field1838;
               this.field1798[this.field1831] = var8.field1798[var9];
               this.field1799[this.field1831] = var8.field1799[var9];
               this.field1800[this.field1831] = var8.field1800[var9];
               if(var3) {
                  if(var8.field1788 != null) {
                     this.field1788[this.field1831] = var8.field1788[var9];
                  } else {
                     this.field1788[this.field1831] = var8.field1805;
                  }
               }

               if(var4 && var8.field1802 != null) {
                  this.field1802[this.field1831] = var8.field1802[var9];
               }

               if(var5) {
                  if(var8.field1789 != null) {
                     this.field1789[this.field1831] = var8.field1789[var9];
                  } else {
                     this.field1789[this.field1831] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1832 != null && var8.field1832[var9] != -1) {
                     this.field1832[this.field1831] = (byte)(var8.field1832[var9] + this.field1806);
                  } else {
                     this.field1832[this.field1831] = -1;
                  }
               }

               ++this.field1831;
            }

            for(var9 = 0; var9 < var8.field1806; ++var9) {
               this.field1807[this.field1806] = var8.field1807[var9] + this.field1838;
               this.field1808[this.field1806] = var8.field1808[var9] + this.field1838;
               this.field1837[this.field1806] = var8.field1837[var9] + this.field1838;
               ++this.field1806;
            }

            for(var9 = 0; var9 < var8.field1838; ++var9) {
               this.field1846[this.field1838] = var8.field1846[var9];
               this.field1792[this.field1838] = var8.field1792[var9];
               this.field1793[this.field1838] = var8.field1793[var9];
               ++this.field1838;
            }
         }
      }

   }

   @ObfuscatedName("r")
   public class104 method2351(boolean var1) {
      if(!var1 && field1803.length < this.field1831) {
         field1803 = new byte[this.field1831 + 100];
      }

      return this.method2313(var1, field1787, field1803);
   }

   @ObfuscatedName("k")
   final void method2352(int var1) {
      int var2 = class90.field1554;
      int var3 = class90.field1575;
      int var4 = 0;
      int var5 = this.field1841[var1];
      int var6 = this.field1804[var1];
      int var7 = this.field1797[var1];
      int var8 = field1826[var5];
      int var9 = field1826[var6];
      int var10 = field1826[var7];
      if(this.field1802 == null) {
         class90.field1558 = 0;
      } else {
         class90.field1558 = this.field1802[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1822[var4] = field1821[var5];
         field1836[var4] = field1848[var5];
         field1847[var4++] = this.field1798[var1];
      } else {
         var11 = field1824[var5];
         var12 = field1825[var5];
         var13 = this.field1798[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1849[var10 - var8];
            field1822[var4] = var2 + (var11 + ((field1824[var7] - var11) * var14 >> 16)) * class90.field1562 / 50;
            field1836[var4] = var3 + (var12 + ((field1825[var7] - var12) * var14 >> 16)) * class90.field1562 / 50;
            field1847[var4++] = var13 + ((this.field1800[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1849[var9 - var8];
            field1822[var4] = var2 + (var11 + ((field1824[var6] - var11) * var14 >> 16)) * class90.field1562 / 50;
            field1836[var4] = var3 + (var12 + ((field1825[var6] - var12) * var14 >> 16)) * class90.field1562 / 50;
            field1847[var4++] = var13 + ((this.field1799[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1822[var4] = field1821[var6];
         field1836[var4] = field1848[var6];
         field1847[var4++] = this.field1799[var1];
      } else {
         var11 = field1824[var6];
         var12 = field1825[var6];
         var13 = this.field1799[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1849[var8 - var9];
            field1822[var4] = var2 + (var11 + ((field1824[var5] - var11) * var14 >> 16)) * class90.field1562 / 50;
            field1836[var4] = var3 + (var12 + ((field1825[var5] - var12) * var14 >> 16)) * class90.field1562 / 50;
            field1847[var4++] = var13 + ((this.field1798[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1849[var10 - var9];
            field1822[var4] = var2 + (var11 + ((field1824[var7] - var11) * var14 >> 16)) * class90.field1562 / 50;
            field1836[var4] = var3 + (var12 + ((field1825[var7] - var12) * var14 >> 16)) * class90.field1562 / 50;
            field1847[var4++] = var13 + ((this.field1800[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1822[var4] = field1821[var7];
         field1836[var4] = field1848[var7];
         field1847[var4++] = this.field1800[var1];
      } else {
         var11 = field1824[var7];
         var12 = field1825[var7];
         var13 = this.field1800[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1849[var9 - var10];
            field1822[var4] = var2 + (var11 + ((field1824[var6] - var11) * var14 >> 16)) * class90.field1562 / 50;
            field1836[var4] = var3 + (var12 + ((field1825[var6] - var12) * var14 >> 16)) * class90.field1562 / 50;
            field1847[var4++] = var13 + ((this.field1799[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1849[var8 - var10];
            field1822[var4] = var2 + (var11 + ((field1824[var5] - var11) * var14 >> 16)) * class90.field1562 / 50;
            field1836[var4] = var3 + (var12 + ((field1825[var5] - var12) * var14 >> 16)) * class90.field1562 / 50;
            field1847[var4++] = var13 + ((this.field1798[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1822[0];
      var12 = field1822[1];
      var13 = field1822[2];
      var14 = field1836[0];
      int var15 = field1836[1];
      int var16 = field1836[2];
      class90.field1577 = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class90.field1565 || var12 > class90.field1565 || var13 > class90.field1565) {
            class90.field1577 = true;
         }

         if(this.field1789 != null && this.field1789[var1] != -1) {
            if(this.field1832 != null && this.field1832[var1] != -1) {
               var20 = this.field1832[var1] & 255;
               var17 = this.field1807[var20];
               var18 = this.field1808[var20];
               var19 = this.field1837[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1800[var1] == -1) {
               class90.method2149(var14, var15, var16, var11, var12, var13, this.field1798[var1], this.field1798[var1], this.field1798[var1], field1824[var17], field1824[var18], field1824[var19], field1825[var17], field1825[var18], field1825[var19], field1826[var17], field1826[var18], field1826[var19], this.field1789[var1]);
            } else {
               class90.method2149(var14, var15, var16, var11, var12, var13, field1847[0], field1847[1], field1847[2], field1824[var17], field1824[var18], field1824[var19], field1825[var17], field1825[var18], field1825[var19], field1826[var17], field1826[var18], field1826[var19], this.field1789[var1]);
            }
         } else if(this.field1800[var1] == -1) {
            class90.method2113(var14, var15, var16, var11, var12, var13, field1828[this.field1798[var1]]);
         } else {
            class90.method2111(var14, var15, var16, var11, var12, var13, field1847[0], field1847[1], field1847[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class90.field1565 || var12 > class90.field1565 || var13 > class90.field1565 || field1822[3] < 0 || field1822[3] > class90.field1565) {
            class90.field1577 = true;
         }

         if(this.field1789 != null && this.field1789[var1] != -1) {
            if(this.field1832 != null && this.field1832[var1] != -1) {
               var20 = this.field1832[var1] & 255;
               var17 = this.field1807[var20];
               var18 = this.field1808[var20];
               var19 = this.field1837[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1789[var1];
            if(this.field1800[var1] == -1) {
               class90.method2149(var14, var15, var16, var11, var12, var13, this.field1798[var1], this.field1798[var1], this.field1798[var1], field1824[var17], field1824[var18], field1824[var19], field1825[var17], field1825[var18], field1825[var19], field1826[var17], field1826[var18], field1826[var19], var21);
               class90.method2149(var14, var16, field1836[3], var11, var13, field1822[3], this.field1798[var1], this.field1798[var1], this.field1798[var1], field1824[var17], field1824[var18], field1824[var19], field1825[var17], field1825[var18], field1825[var19], field1826[var17], field1826[var18], field1826[var19], var21);
            } else {
               class90.method2149(var14, var15, var16, var11, var12, var13, field1847[0], field1847[1], field1847[2], field1824[var17], field1824[var18], field1824[var19], field1825[var17], field1825[var18], field1825[var19], field1826[var17], field1826[var18], field1826[var19], var21);
               class90.method2149(var14, var16, field1836[3], var11, var13, field1822[3], field1847[0], field1847[2], field1847[3], field1824[var17], field1824[var18], field1824[var19], field1825[var17], field1825[var18], field1825[var19], field1826[var17], field1826[var18], field1826[var19], var21);
            }
         } else if(this.field1800[var1] == -1) {
            var17 = field1828[this.field1798[var1]];
            class90.method2113(var14, var15, var16, var11, var12, var13, var17);
            class90.method2113(var14, var16, field1836[3], var11, var13, field1822[3], var17);
         } else {
            class90.method2111(var14, var15, var16, var11, var12, var13, field1847[0], field1847[1], field1847[2]);
            class90.method2111(var14, var16, field1836[3], var11, var13, field1822[3], field1847[0], field1847[2], field1847[3]);
         }
      }

   }

   @ObfuscatedName("i")
   public void method2364() {
      for(int var1 = 0; var1 < this.field1838; ++var1) {
         this.field1846[var1] = -this.field1846[var1];
         this.field1793[var1] = -this.field1793[var1];
      }

      this.field1813 = 0;
   }

   @ObfuscatedName("j")
   public void method2366(class102 var1, int var2) {
      if(this.field1810 != null) {
         if(var2 != -1) {
            class87 var3 = var1.field1765[var2];
            class101 var4 = var3.field1525;
            field1801 = 0;
            field1839 = 0;
            field1809 = 0;

            for(int var5 = 0; var5 < var3.field1531; ++var5) {
               int var6 = var3.field1527[var5];
               this.method2315(var4.field1756[var6], var4.field1753[var6], var3.field1529[var5], var3.field1528[var5], var3.field1530[var5]);
            }

            this.field1813 = 0;
         }
      }
   }

   @ObfuscatedName("o")
   final boolean method2370(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      return var2 < var3 && var2 < var4 && var2 < var5?false:(var2 > var3 && var2 > var4 && var2 > var5?false:(var1 < var6 && var1 < var7 && var1 < var8?false:var1 <= var6 || var1 <= var7 || var1 <= var8));
   }
}
