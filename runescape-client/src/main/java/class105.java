import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
@Implements("Model")
public class class105 extends class85 {
   @ObfuscatedName("d")
   int[] field1783;
   @ObfuscatedName("h")
   static byte[] field1784 = new byte[1];
   @ObfuscatedName("s")
   int[] field1786;
   @ObfuscatedName("x")
   int field1787 = 0;
   @ObfuscatedName("e")
   int[] field1788;
   @ObfuscatedName("i")
   int[] field1789;
   @ObfuscatedName("av")
   static int[] field1790 = new int[4700];
   @ObfuscatedName("m")
   static class105 field1791 = new class105();
   @ObfuscatedName("l")
   int[] field1792;
   @ObfuscatedName("u")
   int[] field1793;
   @ObfuscatedName("bd")
   static int field1794;
   @ObfuscatedName("a")
   int[] field1795;
   @ObfuscatedName("n")
   int field1796 = 0;
   @ObfuscatedName("p")
   int[] field1797;
   @ObfuscatedName("bn")
   public static int field1798 = 0;
   @ObfuscatedName("b")
   byte[] field1799;
   @ObfuscatedName("t")
   byte[] field1800;
   @ObfuscatedName("y")
   short[] field1801;
   @ObfuscatedName("w")
   byte field1802 = 0;
   @ObfuscatedName("g")
   int field1803 = 0;
   @ObfuscatedName("j")
   static class105 field1804 = new class105();
   @ObfuscatedName("k")
   int[] field1805;
   @ObfuscatedName("o")
   int[] field1806;
   @ObfuscatedName("v")
   int[][] field1807;
   @ObfuscatedName("z")
   static byte[] field1808 = new byte[1];
   @ObfuscatedName("au")
   public boolean field1809 = false;
   @ObfuscatedName("bq")
   static int[] field1810;
   @ObfuscatedName("ab")
   int field1811;
   @ObfuscatedName("am")
   int field1812;
   @ObfuscatedName("an")
   int field1813;
   @ObfuscatedName("aj")
   int field1814;
   @ObfuscatedName("bx")
   public static boolean field1815 = false;
   @ObfuscatedName("ao")
   static boolean[] field1816 = new boolean[4700];
   @ObfuscatedName("as")
   static int[] field1817 = new int[4700];
   @ObfuscatedName("ad")
   static int[] field1818 = new int[10];
   @ObfuscatedName("az")
   static int[] field1819 = new int[4700];
   @ObfuscatedName("at")
   static int[][] field1820 = new int[1600][512];
   @ObfuscatedName("ac")
   static int[] field1821 = new int[2000];
   @ObfuscatedName("aa")
   static int[] field1822 = new int[4700];
   @ObfuscatedName("ah")
   static int[] field1823 = new int[4700];
   @ObfuscatedName("bm")
   public static int[] field1824 = new int[1000];
   @ObfuscatedName("ae")
   static int[] field1825 = new int[1600];
   @ObfuscatedName("q")
   byte[] field1826;
   @ObfuscatedName("af")
   static int[] field1827 = new int[12];
   @ObfuscatedName("aw")
   static int[][] field1828 = new int[12][2000];
   @ObfuscatedName("ap")
   static int[] field1830 = new int[2000];
   @ObfuscatedName("r")
   int[] field1831;
   @ObfuscatedName("al")
   static int[] field1832 = new int[10];
   @ObfuscatedName("ar")
   static int[] field1833 = new int[12];
   @ObfuscatedName("ak")
   static int[] field1834 = new int[10];
   @ObfuscatedName("bc")
   static int[] field1835;
   @ObfuscatedName("bt")
   static int field1836;
   @ObfuscatedName("ax")
   static int[] field1837 = new int[4700];
   @ObfuscatedName("aq")
   int field1838;
   @ObfuscatedName("be")
   public static int field1839 = 0;
   @ObfuscatedName("bo")
   public static int field1840 = 0;
   @ObfuscatedName("ag")
   static boolean[] field1841 = new boolean[4700];
   @ObfuscatedName("bb")
   static int field1842;
   @ObfuscatedName("ba")
   static int[] field1843;
   @ObfuscatedName("c")
   int[] field1844;
   @ObfuscatedName("f")
   int[][] field1845;
   @ObfuscatedName("bs")
   static int[] field1846;

   @ObfuscatedSignature(
      signature = "([Lclass105;I)V",
      garbageValue = "2"
   )
   public class105(class105[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1787 = 0;
      this.field1796 = 0;
      this.field1803 = 0;
      this.field1802 = -1;

      int var7;
      class105 var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1787 += var8.field1787;
            this.field1796 += var8.field1796;
            this.field1803 += var8.field1803;
            if(var8.field1826 != null) {
               var3 = true;
            } else {
               if(this.field1802 == -1) {
                  this.field1802 = var8.field1802;
               }

               if(this.field1802 != var8.field1802) {
                  var3 = true;
               }
            }

            var4 |= var8.field1799 != null;
            var5 |= var8.field1801 != null;
            var6 |= var8.field1800 != null;
         }
      }

      this.field1788 = new int[this.field1787];
      this.field1789 = new int[this.field1787];
      this.field1844 = new int[this.field1787];
      this.field1792 = new int[this.field1796];
      this.field1793 = new int[this.field1796];
      this.field1831 = new int[this.field1796];
      this.field1795 = new int[this.field1796];
      this.field1783 = new int[this.field1796];
      this.field1797 = new int[this.field1796];
      if(var3) {
         this.field1826 = new byte[this.field1796];
      }

      if(var4) {
         this.field1799 = new byte[this.field1796];
      }

      if(var5) {
         this.field1801 = new short[this.field1796];
      }

      if(var6) {
         this.field1800 = new byte[this.field1796];
      }

      if(this.field1803 > 0) {
         this.field1786 = new int[this.field1803];
         this.field1805 = new int[this.field1803];
         this.field1806 = new int[this.field1803];
      }

      this.field1787 = 0;
      this.field1796 = 0;
      this.field1803 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1796; ++var9) {
               this.field1792[this.field1796] = var8.field1792[var9] + this.field1787;
               this.field1793[this.field1796] = var8.field1793[var9] + this.field1787;
               this.field1831[this.field1796] = var8.field1831[var9] + this.field1787;
               this.field1795[this.field1796] = var8.field1795[var9];
               this.field1783[this.field1796] = var8.field1783[var9];
               this.field1797[this.field1796] = var8.field1797[var9];
               if(var3) {
                  if(var8.field1826 != null) {
                     this.field1826[this.field1796] = var8.field1826[var9];
                  } else {
                     this.field1826[this.field1796] = var8.field1802;
                  }
               }

               if(var4 && var8.field1799 != null) {
                  this.field1799[this.field1796] = var8.field1799[var9];
               }

               if(var5) {
                  if(var8.field1801 != null) {
                     this.field1801[this.field1796] = var8.field1801[var9];
                  } else {
                     this.field1801[this.field1796] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1800 != null && var8.field1800[var9] != -1) {
                     this.field1800[this.field1796] = (byte)(var8.field1800[var9] + this.field1803);
                  } else {
                     this.field1800[this.field1796] = -1;
                  }
               }

               ++this.field1796;
            }

            for(var9 = 0; var9 < var8.field1803; ++var9) {
               this.field1786[this.field1803] = var8.field1786[var9] + this.field1787;
               this.field1805[this.field1803] = var8.field1805[var9] + this.field1787;
               this.field1806[this.field1803] = var8.field1806[var9] + this.field1787;
               ++this.field1803;
            }

            for(var9 = 0; var9 < var8.field1787; ++var9) {
               this.field1788[this.field1787] = var8.field1788[var9];
               this.field1789[this.field1787] = var8.field1789[var9];
               this.field1844[this.field1787] = var8.field1844[var9];
               ++this.field1787;
            }
         }
      }

   }

   @ObfuscatedName("h")
   public class105 method2286(boolean var1) {
      if(!var1 && field1784.length < this.field1796) {
         field1784 = new byte[this.field1796 + 100];
      }

      return this.method2288(var1, field1804, field1784);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Z)Lclass105;",
      garbageValue = "1"
   )
   public class105 method2287(boolean var1) {
      return this.method2288(var1, field1791, field1808);
   }

   @ObfuscatedName("x")
   class105 method2288(boolean var1, class105 var2, byte[] var3) {
      var2.field1787 = this.field1787;
      var2.field1796 = this.field1796;
      var2.field1803 = this.field1803;
      if(var2.field1788 == null || var2.field1788.length < this.field1787) {
         var2.field1788 = new int[this.field1787 + 100];
         var2.field1789 = new int[this.field1787 + 100];
         var2.field1844 = new int[this.field1787 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1787; ++var4) {
         var2.field1788[var4] = this.field1788[var4];
         var2.field1789[var4] = this.field1789[var4];
         var2.field1844[var4] = this.field1844[var4];
      }

      if(var1) {
         var2.field1799 = this.field1799;
      } else {
         var2.field1799 = var3;
         if(this.field1799 == null) {
            for(var4 = 0; var4 < this.field1796; ++var4) {
               var2.field1799[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1796; ++var4) {
               var2.field1799[var4] = this.field1799[var4];
            }
         }
      }

      var2.field1792 = this.field1792;
      var2.field1793 = this.field1793;
      var2.field1831 = this.field1831;
      var2.field1795 = this.field1795;
      var2.field1783 = this.field1783;
      var2.field1797 = this.field1797;
      var2.field1826 = this.field1826;
      var2.field1800 = this.field1800;
      var2.field1801 = this.field1801;
      var2.field1802 = this.field1802;
      var2.field1786 = this.field1786;
      var2.field1805 = this.field1805;
      var2.field1806 = this.field1806;
      var2.field1807 = this.field1807;
      var2.field1845 = this.field1845;
      var2.field1809 = this.field1809;
      var2.field1838 = 0;
      return var2;
   }

   static {
      field1843 = class91.field1571;
      field1810 = class91.field1572;
      field1835 = class91.field1567;
      field1846 = class91.field1570;
   }

   class105() {
   }

   @ObfuscatedName("n")
   public void method2290(class103 var1, int var2) {
      if(this.field1807 != null) {
         if(var2 != -1) {
            class88 var3 = var1.field1755[var2];
            class102 var4 = var3.field1518;
            field1842 = 0;
            field1836 = 0;
            field1794 = 0;

            for(int var5 = 0; var5 < var3.field1523; ++var5) {
               int var6 = var3.field1524[var5];
               this.method2292(var4.field1744[var6], var4.field1742[var6], var3.field1525[var5], var3.field1527[var5], var3.field1522[var5]);
            }

            this.field1838 = 0;
         }
      }
   }

   @ObfuscatedName("l")
   public void method2291(class103 var1, int var2, class103 var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            class88 var6 = var1.field1755[var2];
            class88 var7 = var3.field1755[var4];
            class102 var8 = var6.field1518;
            field1842 = 0;
            field1836 = 0;
            field1794 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1523; ++var11) {
               for(var12 = var6.field1524[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field1744[var12] == 0) {
                  this.method2292(var8.field1744[var12], var8.field1742[var12], var6.field1525[var11], var6.field1527[var11], var6.field1522[var11]);
               }
            }

            field1842 = 0;
            field1836 = 0;
            field1794 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1523; ++var11) {
               for(var12 = var7.field1524[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field1744[var12] == 0) {
                  this.method2292(var8.field1744[var12], var8.field1742[var12], var7.field1525[var11], var7.field1527[var11], var7.field1522[var11]);
               }
            }

            this.field1838 = 0;
         } else {
            this.method2290(var1, var2);
         }
      }
   }

   @ObfuscatedName("u")
   void method2292(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1842 = 0;
         field1836 = 0;
         field1794 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var18 = var2[var8];
            if(var18 < this.field1807.length) {
               int[] var19 = this.field1807[var18];

               for(var11 = 0; var11 < var19.length; ++var11) {
                  var12 = var19[var11];
                  field1842 += this.field1788[var12];
                  field1836 += this.field1789[var12];
                  field1794 += this.field1844[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1842 = field1842 / var7 + var3;
            field1836 = field1836 / var7 + var4;
            field1794 = field1794 / var7 + var5;
         } else {
            field1842 = var3;
            field1836 = var4;
            field1794 = var5;
         }

      } else {
         int[] var9;
         int var10;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1807.length) {
                  var9 = this.field1807[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.field1788[var11] += var3;
                     this.field1789[var11] += var4;
                     this.field1844[var11] += var5;
                  }
               }
            }

         } else if(var1 == 2) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1807.length) {
                  var9 = this.field1807[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.field1788[var11] -= field1842;
                     this.field1789[var11] -= field1836;
                     this.field1844[var11] -= field1794;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1843[var14];
                        var16 = field1810[var14];
                        var17 = this.field1789[var11] * var15 + this.field1788[var11] * var16 >> 16;
                        this.field1789[var11] = this.field1789[var11] * var16 - this.field1788[var11] * var15 >> 16;
                        this.field1788[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1843[var12];
                        var16 = field1810[var12];
                        var17 = this.field1789[var11] * var16 - this.field1844[var11] * var15 >> 16;
                        this.field1844[var11] = this.field1789[var11] * var15 + this.field1844[var11] * var16 >> 16;
                        this.field1789[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1843[var13];
                        var16 = field1810[var13];
                        var17 = this.field1844[var11] * var15 + this.field1788[var11] * var16 >> 16;
                        this.field1844[var11] = this.field1844[var11] * var16 - this.field1788[var11] * var15 >> 16;
                        this.field1788[var11] = var17;
                     }

                     this.field1788[var11] += field1842;
                     this.field1789[var11] += field1836;
                     this.field1844[var11] += field1794;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1807.length) {
                  var9 = this.field1807[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.field1788[var11] -= field1842;
                     this.field1789[var11] -= field1836;
                     this.field1844[var11] -= field1794;
                     this.field1788[var11] = this.field1788[var11] * var3 / 128;
                     this.field1789[var11] = this.field1789[var11] * var4 / 128;
                     this.field1844[var11] = this.field1844[var11] * var5 / 128;
                     this.field1788[var11] += field1842;
                     this.field1789[var11] += field1836;
                     this.field1844[var11] += field1794;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1845 != null && this.field1799 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1845.length) {
                     var9 = this.field1845[var8];

                     for(var10 = 0; var10 < var9.length; ++var10) {
                        var11 = var9[var10];
                        var12 = (this.field1799[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1799[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("a")
   public void method2293() {
      for(int var1 = 0; var1 < this.field1787; ++var1) {
         int var2 = this.field1788[var1];
         this.field1788[var1] = this.field1844[var1];
         this.field1844[var1] = -var2;
      }

      this.field1838 = 0;
   }

   @ObfuscatedName("p")
   public void method2295() {
      for(int var1 = 0; var1 < this.field1787; ++var1) {
         int var2 = this.field1844[var1];
         this.field1844[var1] = this.field1788[var1];
         this.field1788[var1] = -var2;
      }

      this.field1838 = 0;
   }

   @ObfuscatedName("b")
   public void method2297(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1787; ++var4) {
         this.field1788[var4] += var1;
         this.field1789[var4] += var2;
         this.field1844[var4] += var3;
      }

      this.field1838 = 0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "0"
   )
   public final void method2299(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1825[0] = -1;
      if(this.field1838 != 2 && this.field1838 != 1) {
         this.method2313();
      }

      int var8 = class91.field1559;
      int var9 = class91.field1548;
      int var10000 = field1843[var1];
      var10000 = field1810[var1];
      int var12 = field1843[var2];
      int var13 = field1810[var2];
      int var14 = field1843[var3];
      int var15 = field1810[var3];
      int var16 = field1843[var4];
      int var17 = field1810[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1787; ++var19) {
         int var20 = this.field1788[var19];
         int var21 = this.field1789[var19];
         int var22 = this.field1844[var19];
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
         field1790[var19] = var22 - var18;
         field1817[var19] = var8 + var20 * class91.field1553 / var22;
         field1819[var19] = var9 + var23 * class91.field1553 / var22;
         if(this.field1803 > 0) {
            field1837[var19] = var20;
            field1822[var19] = var23;
            field1823[var19] = var22;
         }
      }

      try {
         this.method2302(false, false, 0);
      } catch (Exception var24) {
         ;
      }

   }

   @ObfuscatedName("au")
   void vmethod2301(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1825[0] = -1;
      if(this.field1838 != 1) {
         this.method2335();
      }

      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1812 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1812) * class91.field1553;
         if(var15 / var13 < class91.field1561) {
            int var16 = (var14 + this.field1812) * class91.field1553;
            if(var16 / var13 > class91.field1562) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1812 * var2 >> 16;
               int var19 = (var17 + var18) * class91.field1553;
               if(var19 / var13 > class91.field1564) {
                  int var20 = var18 + (super.field1443 * var3 >> 16);
                  int var21 = (var17 - var20) * class91.field1553;
                  if(var21 / var13 < class91.field1565) {
                     int var22 = var12 + (super.field1443 * var2 >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1803 > 0;
                     boolean var26 = false;
                     int var27;
                     int var28;
                     int var29;
                     if(var9 > 0 && field1815) {
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

                        var28 = field1839 - class91.field1559;
                        var29 = field1840 - class91.field1548;
                        if(var28 > var15 && var28 < var16 && var29 > var21 && var29 < var19) {
                           if(this.field1809) {
                              field1824[field1798++] = var9;
                           } else {
                              var26 = true;
                           }
                        }
                     }

                     var27 = class91.field1559;
                     var28 = class91.field1548;
                     var29 = 0;
                     int var30 = 0;
                     if(var1 != 0) {
                        var29 = field1843[var1];
                        var30 = field1810[var1];
                     }

                     for(int var31 = 0; var31 < this.field1787; ++var31) {
                        int var32 = this.field1788[var31];
                        int var33 = this.field1789[var31];
                        int var34 = this.field1844[var31];
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
                        field1790[var31] = var34 - var11;
                        if(var34 >= 50) {
                           field1817[var31] = var27 + var32 * class91.field1553 / var34;
                           field1819[var31] = var28 + var35 * class91.field1553 / var34;
                        } else {
                           field1817[var31] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1837[var31] = var32;
                           field1822[var31] = var35;
                           field1823[var31] = var34;
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

   @ObfuscatedName("g")
   final void method2302(boolean var1, boolean var2, int var3) {
      if(this.field1813 < 1600) {
         int var4;
         for(var4 = 0; var4 < this.field1813; ++var4) {
            field1825[var4] = 0;
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
         for(var4 = 0; var4 < this.field1796; ++var4) {
            if(this.field1797[var4] != -2) {
               var5 = this.field1792[var4];
               var6 = this.field1793[var4];
               var7 = this.field1831[var4];
               var8 = field1817[var5];
               var9 = field1817[var6];
               var10 = field1817[var7];
               int var11;
               if(var1 && (var8 == -5000 || var9 == -5000 || var10 == -5000)) {
                  var11 = field1837[var5];
                  var12 = field1837[var6];
                  var13 = field1837[var7];
                  int var14 = field1822[var5];
                  var15 = field1822[var6];
                  int var16 = field1822[var7];
                  int var17 = field1823[var5];
                  int var18 = field1823[var6];
                  int var19 = field1823[var7];
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
                     field1841[var4] = true;
                     int var23 = (field1790[var5] + field1790[var6] + field1790[var7]) / 3 + this.field1814;
                     field1820[var23][field1825[var23]++] = var4;
                  }
               } else {
                  if(var2 && this.method2305(field1839, field1840, field1819[var5], field1819[var6], field1819[var7], var8, var9, var10)) {
                     field1824[field1798++] = var3;
                     var2 = false;
                  }

                  if((var8 - var9) * (field1819[var7] - field1819[var6]) - (field1819[var5] - field1819[var6]) * (var10 - var9) > 0) {
                     field1841[var4] = false;
                     if(var8 >= 0 && var9 >= 0 && var10 >= 0 && var8 <= class91.field1560 && var9 <= class91.field1560 && var10 <= class91.field1560) {
                        field1816[var4] = false;
                     } else {
                        field1816[var4] = true;
                     }

                     var11 = (field1790[var5] + field1790[var6] + field1790[var7]) / 3 + this.field1814;
                     field1820[var11][field1825[var11]++] = var4;
                  }
               }
            }
         }

         int[] var24;
         if(this.field1826 == null) {
            for(var4 = this.field1813 - 1; var4 >= 0; --var4) {
               var5 = field1825[var4];
               if(var5 > 0) {
                  var24 = field1820[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     this.method2303(var24[var7]);
                  }
               }
            }

         } else {
            for(var4 = 0; var4 < 12; ++var4) {
               field1833[var4] = 0;
               field1827[var4] = 0;
            }

            for(var4 = this.field1813 - 1; var4 >= 0; --var4) {
               var5 = field1825[var4];
               if(var5 > 0) {
                  var24 = field1820[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     var8 = var24[var7];
                     byte var25 = this.field1826[var8];
                     var10 = field1833[var25]++;
                     field1828[var25][var10] = var8;
                     if(var25 < 10) {
                        field1827[var25] += var4;
                     } else if(var25 == 10) {
                        field1821[var10] = var4;
                     } else {
                        field1830[var10] = var4;
                     }
                  }
               }
            }

            var4 = 0;
            if(field1833[1] > 0 || field1833[2] > 0) {
               var4 = (field1827[1] + field1827[2]) / (field1833[1] + field1833[2]);
            }

            var5 = 0;
            if(field1833[3] > 0 || field1833[4] > 0) {
               var5 = (field1827[3] + field1827[4]) / (field1833[3] + field1833[4]);
            }

            var6 = 0;
            if(field1833[6] > 0 || field1833[8] > 0) {
               var6 = (field1827[6] + field1827[8]) / (field1833[6] + field1833[8]);
            }

            var8 = 0;
            var9 = field1833[10];
            int[] var26 = field1828[10];
            int[] var27 = field1821;
            if(var8 == var9) {
               var8 = 0;
               var9 = field1833[11];
               var26 = field1828[11];
               var27 = field1830;
            }

            if(var8 < var9) {
               var7 = var27[var8];
            } else {
               var7 = -1000;
            }

            for(var12 = 0; var12 < 10; ++var12) {
               while(var12 == 0 && var7 > var4) {
                  this.method2303(var26[var8++]);
                  if(var8 == var9 && var26 != field1828[11]) {
                     var8 = 0;
                     var9 = field1833[11];
                     var26 = field1828[11];
                     var27 = field1830;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 3 && var7 > var5) {
                  this.method2303(var26[var8++]);
                  if(var8 == var9 && var26 != field1828[11]) {
                     var8 = 0;
                     var9 = field1833[11];
                     var26 = field1828[11];
                     var27 = field1830;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 5 && var7 > var6) {
                  this.method2303(var26[var8++]);
                  if(var8 == var9 && var26 != field1828[11]) {
                     var8 = 0;
                     var9 = field1833[11];
                     var26 = field1828[11];
                     var27 = field1830;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               var13 = field1833[var12];
               int[] var28 = field1828[var12];

               for(var15 = 0; var15 < var13; ++var15) {
                  this.method2303(var28[var15]);
               }
            }

            while(var7 != -1000) {
               this.method2303(var26[var8++]);
               if(var8 == var9 && var26 != field1828[11]) {
                  var8 = 0;
                  var26 = field1828[11];
                  var9 = field1833[11];
                  var27 = field1830;
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

   @ObfuscatedName("s")
   final void method2303(int var1) {
      if(field1841[var1]) {
         this.method2304(var1);
      } else {
         int var2 = this.field1792[var1];
         int var3 = this.field1793[var1];
         int var4 = this.field1831[var1];
         class91.field1568 = field1816[var1];
         if(this.field1799 == null) {
            class91.field1552 = 0;
         } else {
            class91.field1552 = this.field1799[var1] & 255;
         }

         if(this.field1801 != null && this.field1801[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1800 != null && this.field1800[var1] != -1) {
               int var8 = this.field1800[var1] & 255;
               var5 = this.field1786[var8];
               var6 = this.field1805[var8];
               var7 = this.field1806[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1797[var1] == -1) {
               class91.method2111(field1819[var2], field1819[var3], field1819[var4], field1817[var2], field1817[var3], field1817[var4], this.field1795[var1], this.field1795[var1], this.field1795[var1], field1837[var5], field1837[var6], field1837[var7], field1822[var5], field1822[var6], field1822[var7], field1823[var5], field1823[var6], field1823[var7], this.field1801[var1]);
            } else {
               class91.method2111(field1819[var2], field1819[var3], field1819[var4], field1817[var2], field1817[var3], field1817[var4], this.field1795[var1], this.field1783[var1], this.field1797[var1], field1837[var5], field1837[var6], field1837[var7], field1822[var5], field1822[var6], field1822[var7], field1823[var5], field1823[var6], field1823[var7], this.field1801[var1]);
            }
         } else if(this.field1797[var1] == -1) {
            class91.method2092(field1819[var2], field1819[var3], field1819[var4], field1817[var2], field1817[var3], field1817[var4], field1835[this.field1795[var1]]);
         } else {
            class91.method2098(field1819[var2], field1819[var3], field1819[var4], field1817[var2], field1817[var3], field1817[var4], this.field1795[var1], this.field1783[var1], this.field1797[var1]);
         }

      }
   }

   @ObfuscatedName("k")
   final void method2304(int var1) {
      int var2 = class91.field1559;
      int var3 = class91.field1548;
      int var4 = 0;
      int var5 = this.field1792[var1];
      int var6 = this.field1793[var1];
      int var7 = this.field1831[var1];
      int var8 = field1823[var5];
      int var9 = field1823[var6];
      int var10 = field1823[var7];
      if(this.field1799 == null) {
         class91.field1552 = 0;
      } else {
         class91.field1552 = this.field1799[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1832[var4] = field1817[var5];
         field1818[var4] = field1819[var5];
         field1834[var4++] = this.field1795[var1];
      } else {
         var11 = field1837[var5];
         var12 = field1822[var5];
         var13 = this.field1795[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1846[var10 - var8];
            field1832[var4] = var2 + (var11 + ((field1837[var7] - var11) * var14 >> 16)) * class91.field1553 / 50;
            field1818[var4] = var3 + (var12 + ((field1822[var7] - var12) * var14 >> 16)) * class91.field1553 / 50;
            field1834[var4++] = var13 + ((this.field1797[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1846[var9 - var8];
            field1832[var4] = var2 + (var11 + ((field1837[var6] - var11) * var14 >> 16)) * class91.field1553 / 50;
            field1818[var4] = var3 + (var12 + ((field1822[var6] - var12) * var14 >> 16)) * class91.field1553 / 50;
            field1834[var4++] = var13 + ((this.field1783[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1832[var4] = field1817[var6];
         field1818[var4] = field1819[var6];
         field1834[var4++] = this.field1783[var1];
      } else {
         var11 = field1837[var6];
         var12 = field1822[var6];
         var13 = this.field1783[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1846[var8 - var9];
            field1832[var4] = var2 + (var11 + ((field1837[var5] - var11) * var14 >> 16)) * class91.field1553 / 50;
            field1818[var4] = var3 + (var12 + ((field1822[var5] - var12) * var14 >> 16)) * class91.field1553 / 50;
            field1834[var4++] = var13 + ((this.field1795[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1846[var10 - var9];
            field1832[var4] = var2 + (var11 + ((field1837[var7] - var11) * var14 >> 16)) * class91.field1553 / 50;
            field1818[var4] = var3 + (var12 + ((field1822[var7] - var12) * var14 >> 16)) * class91.field1553 / 50;
            field1834[var4++] = var13 + ((this.field1797[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1832[var4] = field1817[var7];
         field1818[var4] = field1819[var7];
         field1834[var4++] = this.field1797[var1];
      } else {
         var11 = field1837[var7];
         var12 = field1822[var7];
         var13 = this.field1797[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1846[var9 - var10];
            field1832[var4] = var2 + (var11 + ((field1837[var6] - var11) * var14 >> 16)) * class91.field1553 / 50;
            field1818[var4] = var3 + (var12 + ((field1822[var6] - var12) * var14 >> 16)) * class91.field1553 / 50;
            field1834[var4++] = var13 + ((this.field1783[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1846[var8 - var10];
            field1832[var4] = var2 + (var11 + ((field1837[var5] - var11) * var14 >> 16)) * class91.field1553 / 50;
            field1818[var4] = var3 + (var12 + ((field1822[var5] - var12) * var14 >> 16)) * class91.field1553 / 50;
            field1834[var4++] = var13 + ((this.field1795[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1832[0];
      var12 = field1832[1];
      var13 = field1832[2];
      var14 = field1818[0];
      int var15 = field1818[1];
      int var16 = field1818[2];
      class91.field1568 = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class91.field1560 || var12 > class91.field1560 || var13 > class91.field1560) {
            class91.field1568 = true;
         }

         if(this.field1801 != null && this.field1801[var1] != -1) {
            if(this.field1800 != null && this.field1800[var1] != -1) {
               var20 = this.field1800[var1] & 255;
               var17 = this.field1786[var20];
               var18 = this.field1805[var20];
               var19 = this.field1806[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1797[var1] == -1) {
               class91.method2111(var14, var15, var16, var11, var12, var13, this.field1795[var1], this.field1795[var1], this.field1795[var1], field1837[var17], field1837[var18], field1837[var19], field1822[var17], field1822[var18], field1822[var19], field1823[var17], field1823[var18], field1823[var19], this.field1801[var1]);
            } else {
               class91.method2111(var14, var15, var16, var11, var12, var13, field1834[0], field1834[1], field1834[2], field1837[var17], field1837[var18], field1837[var19], field1822[var17], field1822[var18], field1822[var19], field1823[var17], field1823[var18], field1823[var19], this.field1801[var1]);
            }
         } else if(this.field1797[var1] == -1) {
            class91.method2092(var14, var15, var16, var11, var12, var13, field1835[this.field1795[var1]]);
         } else {
            class91.method2098(var14, var15, var16, var11, var12, var13, field1834[0], field1834[1], field1834[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class91.field1560 || var12 > class91.field1560 || var13 > class91.field1560 || field1832[3] < 0 || field1832[3] > class91.field1560) {
            class91.field1568 = true;
         }

         if(this.field1801 != null && this.field1801[var1] != -1) {
            if(this.field1800 != null && this.field1800[var1] != -1) {
               var20 = this.field1800[var1] & 255;
               var17 = this.field1786[var20];
               var18 = this.field1805[var20];
               var19 = this.field1806[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1801[var1];
            if(this.field1797[var1] == -1) {
               class91.method2111(var14, var15, var16, var11, var12, var13, this.field1795[var1], this.field1795[var1], this.field1795[var1], field1837[var17], field1837[var18], field1837[var19], field1822[var17], field1822[var18], field1822[var19], field1823[var17], field1823[var18], field1823[var19], var21);
               class91.method2111(var14, var16, field1818[3], var11, var13, field1832[3], this.field1795[var1], this.field1795[var1], this.field1795[var1], field1837[var17], field1837[var18], field1837[var19], field1822[var17], field1822[var18], field1822[var19], field1823[var17], field1823[var18], field1823[var19], var21);
            } else {
               class91.method2111(var14, var15, var16, var11, var12, var13, field1834[0], field1834[1], field1834[2], field1837[var17], field1837[var18], field1837[var19], field1822[var17], field1822[var18], field1822[var19], field1823[var17], field1823[var18], field1823[var19], var21);
               class91.method2111(var14, var16, field1818[3], var11, var13, field1832[3], field1834[0], field1834[2], field1834[3], field1837[var17], field1837[var18], field1837[var19], field1822[var17], field1822[var18], field1822[var19], field1823[var17], field1823[var18], field1823[var19], var21);
            }
         } else if(this.field1797[var1] == -1) {
            var17 = field1835[this.field1795[var1]];
            class91.method2092(var14, var15, var16, var11, var12, var13, var17);
            class91.method2092(var14, var16, field1818[3], var11, var13, field1832[3], var17);
         } else {
            class91.method2098(var14, var15, var16, var11, var12, var13, field1834[0], field1834[1], field1834[2]);
            class91.method2098(var14, var16, field1818[3], var11, var13, field1832[3], field1834[0], field1834[2], field1834[3]);
         }
      }

   }

   @ObfuscatedName("o")
   final boolean method2305(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      return var2 < var3 && var2 < var4 && var2 < var5?false:(var2 > var3 && var2 > var4 && var2 > var5?false:(var1 < var6 && var1 < var7 && var1 < var8?false:var1 <= var6 || var1 <= var7 || var1 <= var8));
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "0"
   )
   public final void method2306(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1825[0] = -1;
      if(this.field1838 != 2 && this.field1838 != 1) {
         this.method2313();
      }

      int var9 = class91.field1559;
      int var10 = class91.field1548;
      int var10000 = field1843[var1];
      var10000 = field1810[var1];
      int var13 = field1843[var2];
      int var14 = field1810[var2];
      int var15 = field1843[var3];
      int var16 = field1810[var3];
      int var17 = field1843[var4];
      int var18 = field1810[var4];
      int var19 = var6 * var17 + var7 * var18 >> 16;

      for(int var20 = 0; var20 < this.field1787; ++var20) {
         int var21 = this.field1788[var20];
         int var22 = this.field1789[var20];
         int var23 = this.field1844[var20];
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
         field1790[var20] = var23 - var19;
         field1817[var20] = var9 + var21 * class91.field1553 / var8;
         field1819[var20] = var10 + var24 * class91.field1553 / var8;
         if(this.field1803 > 0) {
            field1837[var20] = var21;
            field1822[var20] = var24;
            field1823[var20] = var23;
         }
      }

      try {
         this.method2302(false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("d")
   public void method2310() {
      for(int var1 = 0; var1 < this.field1787; ++var1) {
         this.field1788[var1] = -this.field1788[var1];
         this.field1844[var1] = -this.field1844[var1];
      }

      this.field1838 = 0;
   }

   @ObfuscatedName("i")
   void method2313() {
      if(this.field1838 != 2) {
         this.field1838 = 2;
         this.field1812 = 0;

         for(int var1 = 0; var1 < this.field1787; ++var1) {
            int var2 = this.field1788[var1];
            int var3 = this.field1789[var1];
            int var4 = this.field1844[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1812) {
               this.field1812 = var5;
            }
         }

         this.field1812 = (int)(Math.sqrt((double)this.field1812) + 0.99D);
         this.field1814 = this.field1812;
         this.field1813 = this.field1812 + this.field1812;
      }
   }

   @ObfuscatedName("c")
   public int method2321() {
      this.method2335();
      return this.field1812;
   }

   @ObfuscatedName("t")
   public void method2324(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1787; ++var4) {
         this.field1788[var4] = this.field1788[var4] * var1 / 128;
         this.field1789[var4] = this.field1789[var4] * var2 / 128;
         this.field1844[var4] = this.field1844[var4] * var3 / 128;
      }

      this.field1838 = 0;
   }

   @ObfuscatedName("q")
   public void method2330(int var1) {
      int var2 = field1843[var1];
      int var3 = field1810[var1];

      for(int var4 = 0; var4 < this.field1787; ++var4) {
         int var5 = this.field1789[var4] * var3 - this.field1844[var4] * var2 >> 16;
         this.field1844[var4] = this.field1789[var4] * var2 + this.field1844[var4] * var3 >> 16;
         this.field1789[var4] = var5;
      }

      this.field1838 = 0;
   }

   @ObfuscatedName("e")
   public void method2335() {
      if(this.field1838 != 1) {
         this.field1838 = 1;
         super.field1443 = 0;
         this.field1811 = 0;
         this.field1812 = 0;

         for(int var1 = 0; var1 < this.field1787; ++var1) {
            int var2 = this.field1788[var1];
            int var3 = this.field1789[var1];
            int var4 = this.field1844[var1];
            if(-var3 > super.field1443) {
               super.field1443 = -var3;
            }

            if(var3 > this.field1811) {
               this.field1811 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1812) {
               this.field1812 = var5;
            }
         }

         this.field1812 = (int)(Math.sqrt((double)this.field1812) + 0.99D);
         this.field1814 = (int)(Math.sqrt((double)(this.field1812 * this.field1812 + super.field1443 * super.field1443)) + 0.99D);
         this.field1813 = this.field1814 + (int)(Math.sqrt((double)(this.field1812 * this.field1812 + this.field1811 * this.field1811)) + 0.99D);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([[IIIIZI)Lclass105;",
      garbageValue = "1"
   )
   public class105 method2346(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2335();
      int var7 = var2 - this.field1812;
      int var8 = var2 + this.field1812;
      int var9 = var4 - this.field1812;
      int var10 = var4 + this.field1812;
      if(var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
         var7 >>= 7;
         var8 = var8 + 127 >> 7;
         var9 >>= 7;
         var10 = var10 + 127 >> 7;
         if(var1[var7][var9] == var3 && var1[var8][var9] == var3 && var1[var7][var10] == var3 && var1[var8][var10] == var3) {
            return this;
         } else {
            class105 var11 = new class105();
            var11.field1787 = this.field1787;
            var11.field1796 = this.field1796;
            var11.field1803 = this.field1803;
            var11.field1788 = this.field1788;
            var11.field1844 = this.field1844;
            var11.field1792 = this.field1792;
            var11.field1793 = this.field1793;
            var11.field1831 = this.field1831;
            var11.field1795 = this.field1795;
            var11.field1783 = this.field1783;
            var11.field1797 = this.field1797;
            var11.field1826 = this.field1826;
            var11.field1799 = this.field1799;
            var11.field1800 = this.field1800;
            var11.field1801 = this.field1801;
            var11.field1802 = this.field1802;
            var11.field1786 = this.field1786;
            var11.field1805 = this.field1805;
            var11.field1806 = this.field1806;
            var11.field1807 = this.field1807;
            var11.field1845 = this.field1845;
            var11.field1809 = this.field1809;
            var11.field1789 = new int[var11.field1787];
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
               for(var12 = 0; var12 < var11.field1787; ++var12) {
                  var13 = this.field1788[var12] + var2;
                  var14 = this.field1844[var12] + var4;
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var1[var17 + 1][var18 + 1] * var15 >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.field1789[var12] = this.field1789[var12] + var21 - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1787; ++var12) {
                  var13 = (-this.field1789[var12] << 16) / super.field1443;
                  if(var13 < var6) {
                     var14 = this.field1788[var12] + var2;
                     var15 = this.field1844[var12] + var4;
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var1[var18 + 1][var19 + 1] * var16 >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.field1789[var12] = this.field1789[var12] + (var22 - var3) * (var6 - var13) / var6;
                  }
               }
            }

            var11.field1838 = 0;
            return var11;
         }
      } else {
         return this;
      }
   }
}
