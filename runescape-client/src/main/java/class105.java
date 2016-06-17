import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
@Implements("Model")
public class class105 extends class85 {
   @ObfuscatedName("k")
   int[] field1785;
   @ObfuscatedName("g")
   static byte[] field1786 = new byte[1];
   @ObfuscatedName("aq")
   static int[] field1787 = new int[4700];
   @ObfuscatedName("d")
   static byte[] field1788 = new byte[1];
   @ObfuscatedName("m")
   int[] field1789;
   @ObfuscatedName("y")
   @Export("verticesX")
   int[] field1790;
   @ObfuscatedName("l")
   int field1791 = 0;
   @ObfuscatedName("be")
   public static boolean field1792 = false;
   @ObfuscatedName("x")
   int field1793 = 0;
   @ObfuscatedName("u")
   @Export("indices1")
   int[] field1794;
   @ObfuscatedName("p")
   @Export("indices2")
   int[] field1795;
   @ObfuscatedName("bj")
   static int field1796;
   @ObfuscatedName("w")
   int[] field1797;
   @ObfuscatedName("bs")
   static int field1798;
   @ObfuscatedName("z")
   int[] field1799;
   @ObfuscatedName("b")
   static class105 field1800 = new class105();
   @ObfuscatedName("i")
   int[][] field1801;
   @ObfuscatedName("h")
   byte[] field1802;
   @ObfuscatedName("v")
   short[] field1803;
   @ObfuscatedName("a")
   byte field1804 = 0;
   @ObfuscatedName("f")
   int field1805 = 0;
   @ObfuscatedName("q")
   int[] field1806;
   @ObfuscatedName("o")
   byte[] field1807;
   @ObfuscatedName("s")
   int[] field1808;
   @ObfuscatedName("c")
   @Export("verticesZ")
   int[] field1809;
   @ObfuscatedName("e")
   int[][] field1810;
   @ObfuscatedName("aw")
   public boolean field1811 = false;
   @ObfuscatedName("r")
   @Export("verticesY")
   int[] field1812;
   @ObfuscatedName("ag")
   int field1813;
   @ObfuscatedName("ae")
   int field1814;
   @ObfuscatedName("n")
   @Export("indices3")
   int[] field1815;
   @ObfuscatedName("ah")
   int field1816;
   @ObfuscatedName("aa")
   static int[] field1817 = new int[4700];
   @ObfuscatedName("az")
   static boolean[] field1818 = new boolean[4700];
   @ObfuscatedName("ax")
   static boolean[] field1819 = new boolean[4700];
   @ObfuscatedName("ac")
   static int[] field1820 = new int[4700];
   @ObfuscatedName("ar")
   static int[] field1821 = new int[4700];
   @ObfuscatedName("ba")
   public static int field1822 = 0;
   @ObfuscatedName("as")
   static int[] field1823 = new int[4700];
   @ObfuscatedName("j")
   static class105 field1824 = new class105();
   @ObfuscatedName("av")
   static int[][] field1825 = new int[1600][512];
   @ObfuscatedName("au")
   static int[] field1827 = new int[1600];
   @ObfuscatedName("ay")
   static int[] field1828 = new int[4700];
   @ObfuscatedName("at")
   static int[] field1829 = new int[12];
   @ObfuscatedName("am")
   static int[][] field1830 = new int[12][2000];
   @ObfuscatedName("ab")
   static int[] field1831 = new int[2000];
   @ObfuscatedName("ai")
   static int[] field1832 = new int[2000];
   @ObfuscatedName("ad")
   static int[] field1833 = new int[12];
   @ObfuscatedName("ao")
   static int[] field1834 = new int[10];
   @ObfuscatedName("t")
   byte[] field1835;
   @ObfuscatedName("ap")
   static int[] field1836 = new int[10];
   @ObfuscatedName("bc")
   static int field1837;
   @ObfuscatedName("aj")
   int field1839;
   @ObfuscatedName("bb")
   static int[] field1840;
   @ObfuscatedName("bi")
   public static int field1841 = 0;
   @ObfuscatedName("al")
   static int[] field1842 = new int[10];
   @ObfuscatedName("bp")
   public static int field1843 = 0;
   @ObfuscatedName("bz")
   public static int[] field1844 = new int[1000];
   @ObfuscatedName("an")
   int field1845;
   @ObfuscatedName("bl")
   static int[] field1846;
   @ObfuscatedName("bh")
   static int[] field1847;
   @ObfuscatedName("bt")
   static int[] field1848;

   @ObfuscatedName("o")
   public void method2294(int var1) {
      int var2 = field1840[var1];
      int var3 = field1846[var1];

      for(int var4 = 0; var4 < this.field1793; ++var4) {
         int var5 = this.field1812[var4] * var3 - this.field1809[var4] * var2 >> 16;
         this.field1809[var4] = this.field1812[var4] * var2 + this.field1809[var4] * var3 >> 16;
         this.field1812[var4] = var5;
      }

      this.field1845 = 0;
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
      this.field1793 = 0;
      this.field1791 = 0;
      this.field1805 = 0;
      this.field1804 = -1;

      int var7;
      class105 var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1793 += var8.field1793;
            this.field1791 += var8.field1791;
            this.field1805 += var8.field1805;
            if(var8.field1807 != null) {
               var3 = true;
            } else {
               if(this.field1804 == -1) {
                  this.field1804 = var8.field1804;
               }

               if(this.field1804 != var8.field1804) {
                  var3 = true;
               }
            }

            var4 |= var8.field1835 != null;
            var5 |= var8.field1803 != null;
            var6 |= var8.field1802 != null;
         }
      }

      this.field1790 = new int[this.field1793];
      this.field1812 = new int[this.field1793];
      this.field1809 = new int[this.field1793];
      this.field1794 = new int[this.field1791];
      this.field1795 = new int[this.field1791];
      this.field1815 = new int[this.field1791];
      this.field1797 = new int[this.field1791];
      this.field1799 = new int[this.field1791];
      this.field1785 = new int[this.field1791];
      if(var3) {
         this.field1807 = new byte[this.field1791];
      }

      if(var4) {
         this.field1835 = new byte[this.field1791];
      }

      if(var5) {
         this.field1803 = new short[this.field1791];
      }

      if(var6) {
         this.field1802 = new byte[this.field1791];
      }

      if(this.field1805 > 0) {
         this.field1806 = new int[this.field1805];
         this.field1789 = new int[this.field1805];
         this.field1808 = new int[this.field1805];
      }

      this.field1793 = 0;
      this.field1791 = 0;
      this.field1805 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1791; ++var9) {
               this.field1794[this.field1791] = var8.field1794[var9] + this.field1793;
               this.field1795[this.field1791] = var8.field1795[var9] + this.field1793;
               this.field1815[this.field1791] = var8.field1815[var9] + this.field1793;
               this.field1797[this.field1791] = var8.field1797[var9];
               this.field1799[this.field1791] = var8.field1799[var9];
               this.field1785[this.field1791] = var8.field1785[var9];
               if(var3) {
                  if(var8.field1807 != null) {
                     this.field1807[this.field1791] = var8.field1807[var9];
                  } else {
                     this.field1807[this.field1791] = var8.field1804;
                  }
               }

               if(var4 && var8.field1835 != null) {
                  this.field1835[this.field1791] = var8.field1835[var9];
               }

               if(var5) {
                  if(var8.field1803 != null) {
                     this.field1803[this.field1791] = var8.field1803[var9];
                  } else {
                     this.field1803[this.field1791] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1802 != null && var8.field1802[var9] != -1) {
                     this.field1802[this.field1791] = (byte)(var8.field1802[var9] + this.field1805);
                  } else {
                     this.field1802[this.field1791] = -1;
                  }
               }

               ++this.field1791;
            }

            for(var9 = 0; var9 < var8.field1805; ++var9) {
               this.field1806[this.field1805] = var8.field1806[var9] + this.field1793;
               this.field1789[this.field1805] = var8.field1789[var9] + this.field1793;
               this.field1808[this.field1805] = var8.field1808[var9] + this.field1793;
               ++this.field1805;
            }

            for(var9 = 0; var9 < var8.field1793; ++var9) {
               this.field1790[this.field1793] = var8.field1790[var9];
               this.field1812[this.field1793] = var8.field1812[var9];
               this.field1809[this.field1793] = var8.field1809[var9];
               ++this.field1793;
            }
         }
      }

   }

   @ObfuscatedName("g")
   public class105 method2296(boolean var1) {
      if(!var1 && field1786.length < this.field1791) {
         field1786 = new byte[this.field1791 + 100];
      }

      return this.method2298(var1, field1800, field1786);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Z)Lclass105;",
      garbageValue = "1"
   )
   public class105 method2297(boolean var1) {
      return this.method2298(var1, field1824, field1788);
   }

   @ObfuscatedName("x")
   class105 method2298(boolean var1, class105 var2, byte[] var3) {
      var2.field1793 = this.field1793;
      var2.field1791 = this.field1791;
      var2.field1805 = this.field1805;
      if(var2.field1790 == null || var2.field1790.length < this.field1793) {
         var2.field1790 = new int[this.field1793 + 100];
         var2.field1812 = new int[this.field1793 + 100];
         var2.field1809 = new int[this.field1793 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1793; ++var4) {
         var2.field1790[var4] = this.field1790[var4];
         var2.field1812[var4] = this.field1812[var4];
         var2.field1809[var4] = this.field1809[var4];
      }

      if(var1) {
         var2.field1835 = this.field1835;
      } else {
         var2.field1835 = var3;
         if(this.field1835 == null) {
            for(var4 = 0; var4 < this.field1791; ++var4) {
               var2.field1835[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1791; ++var4) {
               var2.field1835[var4] = this.field1835[var4];
            }
         }
      }

      var2.field1794 = this.field1794;
      var2.field1795 = this.field1795;
      var2.field1815 = this.field1815;
      var2.field1797 = this.field1797;
      var2.field1799 = this.field1799;
      var2.field1785 = this.field1785;
      var2.field1807 = this.field1807;
      var2.field1802 = this.field1802;
      var2.field1803 = this.field1803;
      var2.field1804 = this.field1804;
      var2.field1806 = this.field1806;
      var2.field1789 = this.field1789;
      var2.field1808 = this.field1808;
      var2.field1801 = this.field1801;
      var2.field1810 = this.field1810;
      var2.field1811 = this.field1811;
      var2.field1845 = 0;
      return var2;
   }

   @ObfuscatedName("r")
   void method2300() {
      if(this.field1845 != 2) {
         this.field1845 = 2;
         this.field1814 = 0;

         for(int var1 = 0; var1 < this.field1793; ++var1) {
            int var2 = this.field1790[var1];
            int var3 = this.field1812[var1];
            int var4 = this.field1809[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1814) {
               this.field1814 = var5;
            }
         }

         this.field1814 = (int)(Math.sqrt((double)this.field1814) + 0.99D);
         this.field1816 = this.field1814;
         this.field1839 = this.field1814 + this.field1814;
      }
   }

   @ObfuscatedName("l")
   public void method2302(class103 var1, int var2) {
      if(this.field1801 != null) {
         if(var2 != -1) {
            class88 var3 = var1.field1756[var2];
            class102 var4 = var3.field1516;
            field1837 = 0;
            field1796 = 0;
            field1798 = 0;

            for(int var5 = 0; var5 < var3.field1517; ++var5) {
               int var6 = var3.field1518[var5];
               this.method2304(var4.field1744[var6], var4.field1745[var6], var3.field1521[var5], var3.field1520[var5], var3.field1519[var5]);
            }

            this.field1845 = 0;
         }
      }
   }

   @ObfuscatedName("p")
   void method2304(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1837 = 0;
         field1796 = 0;
         field1798 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var9 = var2[var8];
            if(var9 < this.field1801.length) {
               int[] var10 = this.field1801[var9];

               for(var11 = 0; var11 < var10.length; ++var11) {
                  var12 = var10[var11];
                  field1837 += this.field1790[var12];
                  field1796 += this.field1812[var12];
                  field1798 += this.field1809[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1837 = field1837 / var7 + var3;
            field1796 = field1796 / var7 + var4;
            field1798 = field1798 / var7 + var5;
         } else {
            field1837 = var3;
            field1796 = var4;
            field1798 = var5;
         }

      } else {
         int var18;
         int[] var19;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1801.length) {
                  var19 = this.field1801[var8];

                  for(var18 = 0; var18 < var19.length; ++var18) {
                     var11 = var19[var18];
                     this.field1790[var11] += var3;
                     this.field1812[var11] += var4;
                     this.field1809[var11] += var5;
                  }
               }
            }

         } else if(var1 == 2) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1801.length) {
                  var19 = this.field1801[var8];

                  for(var18 = 0; var18 < var19.length; ++var18) {
                     var11 = var19[var18];
                     this.field1790[var11] -= field1837;
                     this.field1812[var11] -= field1796;
                     this.field1809[var11] -= field1798;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1840[var14];
                        var16 = field1846[var14];
                        var17 = this.field1812[var11] * var15 + this.field1790[var11] * var16 >> 16;
                        this.field1812[var11] = this.field1812[var11] * var16 - this.field1790[var11] * var15 >> 16;
                        this.field1790[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1840[var12];
                        var16 = field1846[var12];
                        var17 = this.field1812[var11] * var16 - this.field1809[var11] * var15 >> 16;
                        this.field1809[var11] = this.field1812[var11] * var15 + this.field1809[var11] * var16 >> 16;
                        this.field1812[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1840[var13];
                        var16 = field1846[var13];
                        var17 = this.field1809[var11] * var15 + this.field1790[var11] * var16 >> 16;
                        this.field1809[var11] = this.field1809[var11] * var16 - this.field1790[var11] * var15 >> 16;
                        this.field1790[var11] = var17;
                     }

                     this.field1790[var11] += field1837;
                     this.field1812[var11] += field1796;
                     this.field1809[var11] += field1798;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1801.length) {
                  var19 = this.field1801[var8];

                  for(var18 = 0; var18 < var19.length; ++var18) {
                     var11 = var19[var18];
                     this.field1790[var11] -= field1837;
                     this.field1812[var11] -= field1796;
                     this.field1809[var11] -= field1798;
                     this.field1790[var11] = this.field1790[var11] * var3 / 128;
                     this.field1812[var11] = this.field1812[var11] * var4 / 128;
                     this.field1809[var11] = this.field1809[var11] * var5 / 128;
                     this.field1790[var11] += field1837;
                     this.field1812[var11] += field1796;
                     this.field1809[var11] += field1798;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1810 != null && this.field1835 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1810.length) {
                     var19 = this.field1810[var8];

                     for(var18 = 0; var18 < var19.length; ++var18) {
                        var11 = var19[var18];
                        var12 = (this.field1835[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1835[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("w")
   public void method2305() {
      for(int var1 = 0; var1 < this.field1793; ++var1) {
         int var2 = this.field1790[var1];
         this.field1790[var1] = this.field1809[var1];
         this.field1809[var1] = -var2;
      }

      this.field1845 = 0;
   }

   @ObfuscatedName("z")
   public void method2306() {
      for(int var1 = 0; var1 < this.field1793; ++var1) {
         this.field1790[var1] = -this.field1790[var1];
         this.field1809[var1] = -this.field1809[var1];
      }

      this.field1845 = 0;
   }

   @ObfuscatedName("f")
   final void method2307(boolean var1, boolean var2, int var3) {
      if(this.field1839 < 1600) {
         int var4;
         for(var4 = 0; var4 < this.field1839; ++var4) {
            field1827[var4] = 0;
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
         for(var4 = 0; var4 < this.field1791; ++var4) {
            if(this.field1785[var4] != -2) {
               var5 = this.field1794[var4];
               var6 = this.field1795[var4];
               var7 = this.field1815[var4];
               var8 = field1820[var5];
               var9 = field1820[var6];
               var10 = field1820[var7];
               int var11;
               if(!var1 || var8 != -5000 && var9 != -5000 && var10 != -5000) {
                  if(var2 && this.method2316(field1841, field1822, field1821[var5], field1821[var6], field1821[var7], var8, var9, var10)) {
                     field1844[field1843++] = var3;
                     var2 = false;
                  }

                  if((var8 - var9) * (field1821[var7] - field1821[var6]) - (field1821[var5] - field1821[var6]) * (var10 - var9) > 0) {
                     field1819[var4] = false;
                     if(var8 >= 0 && var9 >= 0 && var10 >= 0 && var8 <= class91.field1552 && var9 <= class91.field1552 && var10 <= class91.field1552) {
                        field1818[var4] = false;
                     } else {
                        field1818[var4] = true;
                     }

                     var11 = (field1787[var5] + field1787[var6] + field1787[var7]) / 3 + this.field1816;
                     field1825[var11][field1827[var11]++] = var4;
                  }
               } else {
                  var11 = field1817[var5];
                  var12 = field1817[var6];
                  var13 = field1817[var7];
                  int var14 = field1828[var5];
                  var15 = field1828[var6];
                  int var16 = field1828[var7];
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
                     field1819[var4] = true;
                     int var23 = (field1787[var5] + field1787[var6] + field1787[var7]) / 3 + this.field1816;
                     field1825[var23][field1827[var23]++] = var4;
                  }
               }
            }
         }

         int[] var25;
         if(this.field1807 == null) {
            for(var4 = this.field1839 - 1; var4 >= 0; --var4) {
               var5 = field1827[var4];
               if(var5 > 0) {
                  var25 = field1825[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     this.method2339(var25[var7]);
                  }
               }
            }

         } else {
            for(var4 = 0; var4 < 12; ++var4) {
               field1829[var4] = 0;
               field1833[var4] = 0;
            }

            for(var4 = this.field1839 - 1; var4 >= 0; --var4) {
               var5 = field1827[var4];
               if(var5 > 0) {
                  var25 = field1825[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     var8 = var25[var7];
                     byte var28 = this.field1807[var8];
                     var10 = field1829[var28]++;
                     field1830[var28][var10] = var8;
                     if(var28 < 10) {
                        field1833[var28] += var4;
                     } else if(var28 == 10) {
                        field1831[var10] = var4;
                     } else {
                        field1832[var10] = var4;
                     }
                  }
               }
            }

            var4 = 0;
            if(field1829[1] > 0 || field1829[2] > 0) {
               var4 = (field1833[1] + field1833[2]) / (field1829[1] + field1829[2]);
            }

            var5 = 0;
            if(field1829[3] > 0 || field1829[4] > 0) {
               var5 = (field1833[3] + field1833[4]) / (field1829[3] + field1829[4]);
            }

            var6 = 0;
            if(field1829[6] > 0 || field1829[8] > 0) {
               var6 = (field1833[6] + field1833[8]) / (field1829[6] + field1829[8]);
            }

            var8 = 0;
            var9 = field1829[10];
            int[] var24 = field1830[10];
            int[] var27 = field1831;
            if(var8 == var9) {
               var8 = 0;
               var9 = field1829[11];
               var24 = field1830[11];
               var27 = field1832;
            }

            if(var8 < var9) {
               var7 = var27[var8];
            } else {
               var7 = -1000;
            }

            for(var12 = 0; var12 < 10; ++var12) {
               while(var12 == 0 && var7 > var4) {
                  this.method2339(var24[var8++]);
                  if(var8 == var9 && var24 != field1830[11]) {
                     var8 = 0;
                     var9 = field1829[11];
                     var24 = field1830[11];
                     var27 = field1832;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 3 && var7 > var5) {
                  this.method2339(var24[var8++]);
                  if(var8 == var9 && var24 != field1830[11]) {
                     var8 = 0;
                     var9 = field1829[11];
                     var24 = field1830[11];
                     var27 = field1832;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 5 && var7 > var6) {
                  this.method2339(var24[var8++]);
                  if(var8 == var9 && var24 != field1830[11]) {
                     var8 = 0;
                     var9 = field1829[11];
                     var24 = field1830[11];
                     var27 = field1832;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               var13 = field1829[var12];
               int[] var26 = field1830[var12];

               for(var15 = 0; var15 < var13; ++var15) {
                  this.method2339(var26[var15]);
               }
            }

            while(var7 != -1000) {
               this.method2339(var24[var8++]);
               if(var8 == var9 && var24 != field1830[11]) {
                  var8 = 0;
                  var24 = field1830[11];
                  var9 = field1829[11];
                  var27 = field1832;
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

   @ObfuscatedName("h")
   public void method2310(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1793; ++var4) {
         this.field1790[var4] = this.field1790[var4] * var1 / 128;
         this.field1812[var4] = this.field1812[var4] * var2 / 128;
         this.field1809[var4] = this.field1809[var4] * var3 / 128;
      }

      this.field1845 = 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "0"
   )
   public final void method2312(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1827[0] = -1;
      if(this.field1845 != 2 && this.field1845 != 1) {
         this.method2300();
      }

      int var9 = class91.field1550;
      int var10 = class91.field1551;
      int var10000 = field1840[var1];
      var10000 = field1846[var1];
      int var13 = field1840[var2];
      int var14 = field1846[var2];
      int var15 = field1840[var3];
      int var16 = field1846[var3];
      int var17 = field1840[var4];
      int var18 = field1846[var4];
      int var19 = var6 * var17 + var7 * var18 >> 16;

      for(int var20 = 0; var20 < this.field1793; ++var20) {
         int var21 = this.field1790[var20];
         int var22 = this.field1812[var20];
         int var23 = this.field1809[var20];
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
         field1787[var20] = var23 - var19;
         field1820[var20] = var9 + var21 * class91.field1558 / var8;
         field1821[var20] = var10 + var24 * class91.field1558 / var8;
         if(this.field1805 > 0) {
            field1817[var20] = var21;
            field1828[var20] = var24;
            field1823[var20] = var23;
         }
      }

      try {
         this.method2307(false, false, 0);
      } catch (Exception var26) {
         ;
      }

   }

   @ObfuscatedName("ag")
   void vmethod2313(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1827[0] = -1;
      if(this.field1845 != 1) {
         this.method2323();
      }

      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1814 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1814) * class91.field1558;
         if(var15 / var13 < class91.field1559) {
            int var16 = (var14 + this.field1814) * class91.field1558;
            if(var16 / var13 > class91.field1554) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1814 * var2 >> 16;
               int var19 = (var17 + var18) * class91.field1558;
               if(var19 / var13 > class91.field1556) {
                  int var20 = var18 + (super.field1436 * var3 >> 16);
                  int var21 = (var17 - var20) * class91.field1558;
                  if(var21 / var13 < class91.field1557) {
                     int var22 = var12 + (super.field1436 * var2 >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1805 > 0;
                     boolean var26 = false;
                     int var27;
                     int var28;
                     int var29;
                     if(var9 > 0 && field1792) {
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

                        var28 = field1841 - class91.field1550;
                        var29 = field1822 - class91.field1551;
                        if(var28 > var15 && var28 < var16 && var29 > var21 && var29 < var19) {
                           if(this.field1811) {
                              field1844[field1843++] = var9;
                           } else {
                              var26 = true;
                           }
                        }
                     }

                     var27 = class91.field1550;
                     var28 = class91.field1551;
                     var29 = 0;
                     int var30 = 0;
                     if(var1 != 0) {
                        var29 = field1840[var1];
                        var30 = field1846[var1];
                     }

                     for(int var31 = 0; var31 < this.field1793; ++var31) {
                        int var32 = this.field1790[var31];
                        int var33 = this.field1812[var31];
                        int var34 = this.field1809[var31];
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
                        field1787[var31] = var34 - var11;
                        if(var34 >= 50) {
                           field1820[var31] = var27 + var32 * class91.field1558 / var34;
                           field1821[var31] = var28 + var35 * class91.field1558 / var34;
                        } else {
                           field1820[var31] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1817[var31] = var32;
                           field1828[var31] = var35;
                           field1823[var31] = var34;
                        }
                     }

                     try {
                        this.method2307(var23, var26, var9);
                     } catch (Exception var37) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "0"
   )
   public final void method2314(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1827[0] = -1;
      if(this.field1845 != 2 && this.field1845 != 1) {
         this.method2300();
      }

      int var8 = class91.field1550;
      int var9 = class91.field1551;
      int var10000 = field1840[var1];
      var10000 = field1846[var1];
      int var12 = field1840[var2];
      int var13 = field1846[var2];
      int var14 = field1840[var3];
      int var15 = field1846[var3];
      int var16 = field1840[var4];
      int var17 = field1846[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1793; ++var19) {
         int var20 = this.field1790[var19];
         int var21 = this.field1812[var19];
         int var22 = this.field1809[var19];
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
         field1787[var19] = var22 - var18;
         field1820[var19] = var8 + var20 * class91.field1558 / var22;
         field1821[var19] = var9 + var23 * class91.field1558 / var22;
         if(this.field1805 > 0) {
            field1817[var19] = var20;
            field1828[var19] = var23;
            field1823[var19] = var22;
         }
      }

      try {
         this.method2307(false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   class105() {
   }

   @ObfuscatedName("t")
   public void method2315(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1793; ++var4) {
         this.field1790[var4] += var1;
         this.field1812[var4] += var2;
         this.field1809[var4] += var3;
      }

      this.field1845 = 0;
   }

   @ObfuscatedName("s")
   final boolean method2316(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      return var2 < var3 && var2 < var4 && var2 < var5?false:(var2 > var3 && var2 > var4 && var2 > var5?false:(var1 < var6 && var1 < var7 && var1 < var8?false:var1 <= var6 || var1 <= var7 || var1 <= var8));
   }

   @ObfuscatedName("y")
   public void method2323() {
      if(this.field1845 != 1) {
         this.field1845 = 1;
         super.field1436 = 0;
         this.field1813 = 0;
         this.field1814 = 0;

         for(int var1 = 0; var1 < this.field1793; ++var1) {
            int var2 = this.field1790[var1];
            int var3 = this.field1812[var1];
            int var4 = this.field1809[var1];
            if(-var3 > super.field1436) {
               super.field1436 = -var3;
            }

            if(var3 > this.field1813) {
               this.field1813 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1814) {
               this.field1814 = var5;
            }
         }

         this.field1814 = (int)(Math.sqrt((double)this.field1814) + 0.99D);
         this.field1816 = (int)(Math.sqrt((double)(this.field1814 * this.field1814 + super.field1436 * super.field1436)) + 0.99D);
         this.field1839 = this.field1816 + (int)(Math.sqrt((double)(this.field1814 * this.field1814 + this.field1813 * this.field1813)) + 0.99D);
      }
   }

   @ObfuscatedName("u")
   public void method2327(class103 var1, int var2, class103 var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            class88 var6 = var1.field1756[var2];
            class88 var7 = var3.field1756[var4];
            class102 var8 = var6.field1516;
            field1837 = 0;
            field1796 = 0;
            field1798 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1517; ++var11) {
               for(var12 = var6.field1518[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field1744[var12] == 0) {
                  this.method2304(var8.field1744[var12], var8.field1745[var12], var6.field1521[var11], var6.field1520[var11], var6.field1519[var11]);
               }
            }

            field1837 = 0;
            field1796 = 0;
            field1798 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1517; ++var11) {
               for(var12 = var7.field1518[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field1744[var12] == 0) {
                  this.method2304(var8.field1744[var12], var8.field1745[var12], var7.field1521[var11], var7.field1520[var11], var7.field1519[var11]);
               }
            }

            this.field1845 = 0;
         } else {
            this.method2302(var1, var2);
         }
      }
   }

   @ObfuscatedName("q")
   final void method2339(int var1) {
      if(field1819[var1]) {
         this.method2361(var1);
      } else {
         int var2 = this.field1794[var1];
         int var3 = this.field1795[var1];
         int var4 = this.field1815[var1];
         class91.field1553 = field1818[var1];
         if(this.field1835 == null) {
            class91.field1544 = 0;
         } else {
            class91.field1544 = this.field1835[var1] & 255;
         }

         if(this.field1803 != null && this.field1803[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1802 != null && this.field1802[var1] != -1) {
               int var8 = this.field1802[var1] & 255;
               var5 = this.field1806[var8];
               var6 = this.field1789[var8];
               var7 = this.field1808[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1785[var1] == -1) {
               class91.method2106(field1821[var2], field1821[var3], field1821[var4], field1820[var2], field1820[var3], field1820[var4], this.field1797[var1], this.field1797[var1], this.field1797[var1], field1817[var5], field1817[var6], field1817[var7], field1828[var5], field1828[var6], field1828[var7], field1823[var5], field1823[var6], field1823[var7], this.field1803[var1]);
            } else {
               class91.method2106(field1821[var2], field1821[var3], field1821[var4], field1820[var2], field1820[var3], field1820[var4], this.field1797[var1], this.field1799[var1], this.field1785[var1], field1817[var5], field1817[var6], field1817[var7], field1828[var5], field1828[var6], field1828[var7], field1823[var5], field1823[var6], field1823[var7], this.field1803[var1]);
            }
         } else if(this.field1785[var1] == -1) {
            class91.method2095(field1821[var2], field1821[var3], field1821[var4], field1820[var2], field1820[var3], field1820[var4], field1847[this.field1797[var1]]);
         } else {
            class91.method2102(field1821[var2], field1821[var3], field1821[var4], field1820[var2], field1820[var3], field1820[var4], this.field1797[var1], this.field1799[var1], this.field1785[var1]);
         }

      }
   }

   @ObfuscatedName("c")
   public int method2340() {
      this.method2323();
      return this.field1814;
   }

   @ObfuscatedName("k")
   public void method2360() {
      for(int var1 = 0; var1 < this.field1793; ++var1) {
         int var2 = this.field1809[var1];
         this.field1809[var1] = this.field1790[var1];
         this.field1790[var1] = -var2;
      }

      this.field1845 = 0;
   }

   @ObfuscatedName("m")
   final void method2361(int var1) {
      int var2 = class91.field1550;
      int var3 = class91.field1551;
      int var4 = 0;
      int var5 = this.field1794[var1];
      int var6 = this.field1795[var1];
      int var7 = this.field1815[var1];
      int var8 = field1823[var5];
      int var9 = field1823[var6];
      int var10 = field1823[var7];
      if(this.field1835 == null) {
         class91.field1544 = 0;
      } else {
         class91.field1544 = this.field1835[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1834[var4] = field1820[var5];
         field1842[var4] = field1821[var5];
         field1836[var4++] = this.field1797[var1];
      } else {
         var11 = field1817[var5];
         var12 = field1828[var5];
         var13 = this.field1797[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1848[var10 - var8];
            field1834[var4] = var2 + (var11 + ((field1817[var7] - var11) * var14 >> 16)) * class91.field1558 / 50;
            field1842[var4] = var3 + (var12 + ((field1828[var7] - var12) * var14 >> 16)) * class91.field1558 / 50;
            field1836[var4++] = var13 + ((this.field1785[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1848[var9 - var8];
            field1834[var4] = var2 + (var11 + ((field1817[var6] - var11) * var14 >> 16)) * class91.field1558 / 50;
            field1842[var4] = var3 + (var12 + ((field1828[var6] - var12) * var14 >> 16)) * class91.field1558 / 50;
            field1836[var4++] = var13 + ((this.field1799[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1834[var4] = field1820[var6];
         field1842[var4] = field1821[var6];
         field1836[var4++] = this.field1799[var1];
      } else {
         var11 = field1817[var6];
         var12 = field1828[var6];
         var13 = this.field1799[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1848[var8 - var9];
            field1834[var4] = var2 + (var11 + ((field1817[var5] - var11) * var14 >> 16)) * class91.field1558 / 50;
            field1842[var4] = var3 + (var12 + ((field1828[var5] - var12) * var14 >> 16)) * class91.field1558 / 50;
            field1836[var4++] = var13 + ((this.field1797[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1848[var10 - var9];
            field1834[var4] = var2 + (var11 + ((field1817[var7] - var11) * var14 >> 16)) * class91.field1558 / 50;
            field1842[var4] = var3 + (var12 + ((field1828[var7] - var12) * var14 >> 16)) * class91.field1558 / 50;
            field1836[var4++] = var13 + ((this.field1785[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1834[var4] = field1820[var7];
         field1842[var4] = field1821[var7];
         field1836[var4++] = this.field1785[var1];
      } else {
         var11 = field1817[var7];
         var12 = field1828[var7];
         var13 = this.field1785[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1848[var9 - var10];
            field1834[var4] = var2 + (var11 + ((field1817[var6] - var11) * var14 >> 16)) * class91.field1558 / 50;
            field1842[var4] = var3 + (var12 + ((field1828[var6] - var12) * var14 >> 16)) * class91.field1558 / 50;
            field1836[var4++] = var13 + ((this.field1799[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1848[var8 - var10];
            field1834[var4] = var2 + (var11 + ((field1817[var5] - var11) * var14 >> 16)) * class91.field1558 / 50;
            field1842[var4] = var3 + (var12 + ((field1828[var5] - var12) * var14 >> 16)) * class91.field1558 / 50;
            field1836[var4++] = var13 + ((this.field1797[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1834[0];
      var12 = field1834[1];
      var13 = field1834[2];
      var14 = field1842[0];
      int var15 = field1842[1];
      int var16 = field1842[2];
      class91.field1553 = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class91.field1552 || var12 > class91.field1552 || var13 > class91.field1552) {
            class91.field1553 = true;
         }

         if(this.field1803 != null && this.field1803[var1] != -1) {
            if(this.field1802 != null && this.field1802[var1] != -1) {
               var20 = this.field1802[var1] & 255;
               var17 = this.field1806[var20];
               var18 = this.field1789[var20];
               var19 = this.field1808[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1785[var1] == -1) {
               class91.method2106(var14, var15, var16, var11, var12, var13, this.field1797[var1], this.field1797[var1], this.field1797[var1], field1817[var17], field1817[var18], field1817[var19], field1828[var17], field1828[var18], field1828[var19], field1823[var17], field1823[var18], field1823[var19], this.field1803[var1]);
            } else {
               class91.method2106(var14, var15, var16, var11, var12, var13, field1836[0], field1836[1], field1836[2], field1817[var17], field1817[var18], field1817[var19], field1828[var17], field1828[var18], field1828[var19], field1823[var17], field1823[var18], field1823[var19], this.field1803[var1]);
            }
         } else if(this.field1785[var1] == -1) {
            class91.method2095(var14, var15, var16, var11, var12, var13, field1847[this.field1797[var1]]);
         } else {
            class91.method2102(var14, var15, var16, var11, var12, var13, field1836[0], field1836[1], field1836[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class91.field1552 || var12 > class91.field1552 || var13 > class91.field1552 || field1834[3] < 0 || field1834[3] > class91.field1552) {
            class91.field1553 = true;
         }

         if(this.field1803 != null && this.field1803[var1] != -1) {
            if(this.field1802 != null && this.field1802[var1] != -1) {
               var20 = this.field1802[var1] & 255;
               var17 = this.field1806[var20];
               var18 = this.field1789[var20];
               var19 = this.field1808[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1803[var1];
            if(this.field1785[var1] == -1) {
               class91.method2106(var14, var15, var16, var11, var12, var13, this.field1797[var1], this.field1797[var1], this.field1797[var1], field1817[var17], field1817[var18], field1817[var19], field1828[var17], field1828[var18], field1828[var19], field1823[var17], field1823[var18], field1823[var19], var21);
               class91.method2106(var14, var16, field1842[3], var11, var13, field1834[3], this.field1797[var1], this.field1797[var1], this.field1797[var1], field1817[var17], field1817[var18], field1817[var19], field1828[var17], field1828[var18], field1828[var19], field1823[var17], field1823[var18], field1823[var19], var21);
            } else {
               class91.method2106(var14, var15, var16, var11, var12, var13, field1836[0], field1836[1], field1836[2], field1817[var17], field1817[var18], field1817[var19], field1828[var17], field1828[var18], field1828[var19], field1823[var17], field1823[var18], field1823[var19], var21);
               class91.method2106(var14, var16, field1842[3], var11, var13, field1834[3], field1836[0], field1836[2], field1836[3], field1817[var17], field1817[var18], field1817[var19], field1828[var17], field1828[var18], field1828[var19], field1823[var17], field1823[var18], field1823[var19], var21);
            }
         } else if(this.field1785[var1] == -1) {
            var17 = field1847[this.field1797[var1]];
            class91.method2095(var14, var15, var16, var11, var12, var13, var17);
            class91.method2095(var14, var16, field1842[3], var11, var13, field1834[3], var17);
         } else {
            class91.method2102(var14, var15, var16, var11, var12, var13, field1836[0], field1836[1], field1836[2]);
            class91.method2102(var14, var16, field1842[3], var11, var13, field1834[3], field1836[0], field1836[2], field1836[3]);
         }
      }

   }

   static {
      field1840 = class91.field1563;
      field1846 = class91.field1564;
      field1847 = class91.field1549;
      field1848 = class91.field1545;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([[IIIIZI)Lclass105;",
      garbageValue = "1"
   )
   public class105 method2372(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2323();
      int var7 = var2 - this.field1814;
      int var8 = var2 + this.field1814;
      int var9 = var4 - this.field1814;
      int var10 = var4 + this.field1814;
      if(var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
         var7 >>= 7;
         var8 = var8 + 127 >> 7;
         var9 >>= 7;
         var10 = var10 + 127 >> 7;
         if(var1[var7][var9] == var3 && var1[var8][var9] == var3 && var1[var7][var10] == var3 && var1[var8][var10] == var3) {
            return this;
         } else {
            class105 var11 = new class105();
            var11.field1793 = this.field1793;
            var11.field1791 = this.field1791;
            var11.field1805 = this.field1805;
            var11.field1790 = this.field1790;
            var11.field1809 = this.field1809;
            var11.field1794 = this.field1794;
            var11.field1795 = this.field1795;
            var11.field1815 = this.field1815;
            var11.field1797 = this.field1797;
            var11.field1799 = this.field1799;
            var11.field1785 = this.field1785;
            var11.field1807 = this.field1807;
            var11.field1835 = this.field1835;
            var11.field1802 = this.field1802;
            var11.field1803 = this.field1803;
            var11.field1804 = this.field1804;
            var11.field1806 = this.field1806;
            var11.field1789 = this.field1789;
            var11.field1808 = this.field1808;
            var11.field1801 = this.field1801;
            var11.field1810 = this.field1810;
            var11.field1811 = this.field1811;
            var11.field1812 = new int[var11.field1793];
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
               for(var12 = 0; var12 < var11.field1793; ++var12) {
                  var13 = this.field1790[var12] + var2;
                  var14 = this.field1809[var12] + var4;
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var1[var17 + 1][var18 + 1] * var15 >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.field1812[var12] = this.field1812[var12] + var21 - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1793; ++var12) {
                  var13 = (-this.field1812[var12] << 16) / super.field1436;
                  if(var13 < var6) {
                     var14 = this.field1790[var12] + var2;
                     var15 = this.field1809[var12] + var4;
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var1[var18 + 1][var19 + 1] * var16 >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.field1812[var12] = this.field1812[var12] + (var22 - var3) * (var6 - var13) / var6;
                  }
               }
            }

            var11.field1845 = 0;
            return var11;
         }
      } else {
         return this;
      }
   }
}
