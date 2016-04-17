import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
@Implements("Model")
public class class105 extends class85 {
   @ObfuscatedName("m")
   int[] field1793;
   @ObfuscatedName("bl")
   public static int field1794 = 0;
   @ObfuscatedName("h")
   byte field1795 = 0;
   @ObfuscatedName("c")
   static byte[] field1796 = new byte[1];
   @ObfuscatedName("y")
   int field1797 = 0;
   @ObfuscatedName("k")
   int[] field1798;
   @ObfuscatedName("r")
   int[] field1799;
   @ObfuscatedName("x")
   int[] field1800;
   @ObfuscatedName("q")
   int field1801 = 0;
   @ObfuscatedName("f")
   int[] field1802;
   @ObfuscatedName("bu")
   static int[] field1803;
   @ObfuscatedName("d")
   static class105 field1804 = new class105();
   @ObfuscatedName("z")
   int[] field1805;
   @ObfuscatedName("i")
   int[] field1806;
   @ObfuscatedName("t")
   int[] field1807;
   @ObfuscatedName("n")
   byte[] field1808;
   @ObfuscatedName("bh")
   static int field1809;
   @ObfuscatedName("g")
   byte[] field1810;
   @ObfuscatedName("j")
   short[] field1811;
   @ObfuscatedName("am")
   static int[] field1812 = new int[1600];
   @ObfuscatedName("s")
   int field1813 = 0;
   @ObfuscatedName("l")
   int[] field1816;
   @ObfuscatedName("o")
   int[][] field1817;
   @ObfuscatedName("ag")
   static int[][] field1818 = new int[12][2000];
   @ObfuscatedName("ad")
   public boolean field1819 = false;
   @ObfuscatedName("an")
   static boolean[] field1820 = new boolean[4700];
   @ObfuscatedName("ah")
   int field1821;
   @ObfuscatedName("v")
   int[][] field1822;
   @ObfuscatedName("af")
   int field1823;
   @ObfuscatedName("al")
   int field1824;
   @ObfuscatedName("aa")
   static int[] field1826 = new int[10];
   @ObfuscatedName("az")
   static boolean[] field1827 = new boolean[4700];
   @ObfuscatedName("ac")
   static int[] field1828 = new int[4700];
   @ObfuscatedName("ao")
   static int[] field1829 = new int[4700];
   @ObfuscatedName("ax")
   static int[] field1830 = new int[4700];
   @ObfuscatedName("at")
   static int[] field1831 = new int[4700];
   @ObfuscatedName("ab")
   static int[] field1832 = new int[4700];
   @ObfuscatedName("u")
   byte[] field1833;
   @ObfuscatedName("b")
   int[] field1834;
   @ObfuscatedName("e")
   int[] field1835;
   @ObfuscatedName("w")
   static byte[] field1836 = new byte[1];
   @ObfuscatedName("aq")
   static int[] field1837 = new int[12];
   @ObfuscatedName("aj")
   static int[][] field1838 = new int[1600][512];
   @ObfuscatedName("p")
   int[] field1839;
   @ObfuscatedName("ak")
   static int[] field1840 = new int[2000];
   @ObfuscatedName("as")
   static int[] field1841 = new int[12];
   @ObfuscatedName("ay")
   int field1842;
   @ObfuscatedName("av")
   static int[] field1843 = new int[10];
   @ObfuscatedName("aw")
   static int[] field1844 = new int[10];
   @ObfuscatedName("bb")
   static int field1845;
   @ObfuscatedName("a")
   static class105 field1846 = new class105();
   @ObfuscatedName("bg")
   static int field1847;
   @ObfuscatedName("bm")
   public static boolean field1848 = false;
   @ObfuscatedName("ar")
   int field1849;
   @ObfuscatedName("bk")
   public static int field1850 = 0;
   @ObfuscatedName("bi")
   public static int field1851 = 0;
   @ObfuscatedName("by")
   public static int[] field1852 = new int[1000];
   @ObfuscatedName("bc")
   static int[] field1853;
   @ObfuscatedName("ae")
   static int[] field1854 = new int[4700];
   @ObfuscatedName("ba")
   static int[] field1855;
   @ObfuscatedName("bd")
   static int[] field1856;
   @ObfuscatedName("ap")
   static int[] field1857 = new int[2000];

   @ObfuscatedSignature(
      signature = "([Lclass105;I)V",
      garbageValue = "2"
   )
   public class105(class105[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1797 = 0;
      this.field1801 = 0;
      this.field1813 = 0;
      this.field1795 = -1;

      int var7;
      class105 var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1797 += var8.field1797;
            this.field1801 += var8.field1801;
            this.field1813 += var8.field1813;
            if(var8.field1808 != null) {
               var3 = true;
            } else {
               if(this.field1795 == -1) {
                  this.field1795 = var8.field1795;
               }

               if(this.field1795 != var8.field1795) {
                  var3 = true;
               }
            }

            var4 |= var8.field1833 != null;
            var5 |= var8.field1811 != null;
            var6 |= var8.field1810 != null;
         }
      }

      this.field1798 = new int[this.field1797];
      this.field1799 = new int[this.field1797];
      this.field1839 = new int[this.field1797];
      this.field1793 = new int[this.field1801];
      this.field1835 = new int[this.field1801];
      this.field1800 = new int[this.field1801];
      this.field1805 = new int[this.field1801];
      this.field1806 = new int[this.field1801];
      this.field1807 = new int[this.field1801];
      if(var3) {
         this.field1808 = new byte[this.field1801];
      }

      if(var4) {
         this.field1833 = new byte[this.field1801];
      }

      if(var5) {
         this.field1811 = new short[this.field1801];
      }

      if(var6) {
         this.field1810 = new byte[this.field1801];
      }

      if(this.field1813 > 0) {
         this.field1802 = new int[this.field1813];
         this.field1834 = new int[this.field1813];
         this.field1816 = new int[this.field1813];
      }

      this.field1797 = 0;
      this.field1801 = 0;
      this.field1813 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1801; ++var9) {
               this.field1793[this.field1801] = var8.field1793[var9] + this.field1797;
               this.field1835[this.field1801] = var8.field1835[var9] + this.field1797;
               this.field1800[this.field1801] = var8.field1800[var9] + this.field1797;
               this.field1805[this.field1801] = var8.field1805[var9];
               this.field1806[this.field1801] = var8.field1806[var9];
               this.field1807[this.field1801] = var8.field1807[var9];
               if(var3) {
                  if(var8.field1808 != null) {
                     this.field1808[this.field1801] = var8.field1808[var9];
                  } else {
                     this.field1808[this.field1801] = var8.field1795;
                  }
               }

               if(var4 && var8.field1833 != null) {
                  this.field1833[this.field1801] = var8.field1833[var9];
               }

               if(var5) {
                  if(var8.field1811 != null) {
                     this.field1811[this.field1801] = var8.field1811[var9];
                  } else {
                     this.field1811[this.field1801] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1810 != null && var8.field1810[var9] != -1) {
                     this.field1810[this.field1801] = (byte)(var8.field1810[var9] + this.field1813);
                  } else {
                     this.field1810[this.field1801] = -1;
                  }
               }

               ++this.field1801;
            }

            for(var9 = 0; var9 < var8.field1813; ++var9) {
               this.field1802[this.field1813] = var8.field1802[var9] + this.field1797;
               this.field1834[this.field1813] = var8.field1834[var9] + this.field1797;
               this.field1816[this.field1813] = var8.field1816[var9] + this.field1797;
               ++this.field1813;
            }

            for(var9 = 0; var9 < var8.field1797; ++var9) {
               this.field1798[this.field1797] = var8.field1798[var9];
               this.field1799[this.field1797] = var8.field1799[var9];
               this.field1839[this.field1797] = var8.field1839[var9];
               ++this.field1797;
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Z)Lclass105;",
      garbageValue = "1"
   )
   public class105 method2390(boolean var1) {
      return this.method2391(var1, field1804, field1796);
   }

   @ObfuscatedName("y")
   class105 method2391(boolean var1, class105 var2, byte[] var3) {
      var2.field1797 = this.field1797;
      var2.field1801 = this.field1801;
      var2.field1813 = this.field1813;
      if(var2.field1798 == null || var2.field1798.length < this.field1797) {
         var2.field1798 = new int[this.field1797 + 100];
         var2.field1799 = new int[this.field1797 + 100];
         var2.field1839 = new int[this.field1797 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1797; ++var4) {
         var2.field1798[var4] = this.field1798[var4];
         var2.field1799[var4] = this.field1799[var4];
         var2.field1839[var4] = this.field1839[var4];
      }

      if(var1) {
         var2.field1833 = this.field1833;
      } else {
         var2.field1833 = var3;
         if(this.field1833 == null) {
            for(var4 = 0; var4 < this.field1801; ++var4) {
               var2.field1833[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1801; ++var4) {
               var2.field1833[var4] = this.field1833[var4];
            }
         }
      }

      var2.field1793 = this.field1793;
      var2.field1835 = this.field1835;
      var2.field1800 = this.field1800;
      var2.field1805 = this.field1805;
      var2.field1806 = this.field1806;
      var2.field1807 = this.field1807;
      var2.field1808 = this.field1808;
      var2.field1810 = this.field1810;
      var2.field1811 = this.field1811;
      var2.field1795 = this.field1795;
      var2.field1802 = this.field1802;
      var2.field1834 = this.field1834;
      var2.field1816 = this.field1816;
      var2.field1817 = this.field1817;
      var2.field1822 = this.field1822;
      var2.field1819 = this.field1819;
      var2.field1849 = 0;
      return var2;
   }

   @ObfuscatedName("b")
   final void method2392(int var1) {
      if(field1827[var1]) {
         this.method2409(var1);
      } else {
         int var2 = this.field1793[var1];
         int var3 = this.field1835[var1];
         int var4 = this.field1800[var1];
         class91.field1576 = field1820[var1];
         if(this.field1833 == null) {
            class91.field1574 = 0;
         } else {
            class91.field1574 = this.field1833[var1] & 255;
         }

         if(this.field1811 != null && this.field1811[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1810 != null && this.field1810[var1] != -1) {
               int var8 = this.field1810[var1] & 255;
               var5 = this.field1802[var8];
               var6 = this.field1834[var8];
               var7 = this.field1816[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1807[var1] == -1) {
               class91.method2230(field1829[var2], field1829[var3], field1829[var4], field1828[var2], field1828[var3], field1828[var4], this.field1805[var1], this.field1805[var1], this.field1805[var1], field1831[var5], field1831[var6], field1831[var7], field1832[var5], field1832[var6], field1832[var7], field1854[var5], field1854[var6], field1854[var7], this.field1811[var1]);
            } else {
               class91.method2230(field1829[var2], field1829[var3], field1829[var4], field1828[var2], field1828[var3], field1828[var4], this.field1805[var1], this.field1806[var1], this.field1807[var1], field1831[var5], field1831[var6], field1831[var7], field1832[var5], field1832[var6], field1832[var7], field1854[var5], field1854[var6], field1854[var7], this.field1811[var1]);
            }
         } else if(this.field1807[var1] == -1) {
            class91.method2180(field1829[var2], field1829[var3], field1829[var4], field1828[var2], field1828[var3], field1828[var4], field1855[this.field1805[var1]]);
         } else {
            class91.method2178(field1829[var2], field1829[var3], field1829[var4], field1828[var2], field1828[var3], field1828[var4], this.field1805[var1], this.field1806[var1], this.field1807[var1]);
         }

      }
   }

   @ObfuscatedName("r")
   void method2393() {
      if(this.field1849 != 2) {
         this.field1849 = 2;
         this.field1842 = 0;

         for(int var1 = 0; var1 < this.field1797; ++var1) {
            int var2 = this.field1798[var1];
            int var3 = this.field1799[var1];
            int var4 = this.field1839[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1842) {
               this.field1842 = var5;
            }
         }

         this.field1842 = (int)(Math.sqrt((double)this.field1842) + 0.99D);
         this.field1824 = this.field1842;
         this.field1823 = this.field1842 + this.field1842;
      }
   }

   @ObfuscatedName("m")
   public void method2396(class103 var1, int var2, class103 var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            class88 var6 = var1.field1770[var2];
            class88 var7 = var3.field1770[var4];
            class102 var8 = var6.field1549;
            field1845 = 0;
            field1809 = 0;
            field1847 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1545; ++var11) {
               for(var12 = var6.field1546[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field1761[var12] == 0) {
                  this.method2397(var8.field1761[var12], var8.field1762[var12], var6.field1547[var11], var6.field1548[var11], var6.field1540[var11]);
               }
            }

            field1845 = 0;
            field1809 = 0;
            field1847 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1545; ++var11) {
               for(var12 = var7.field1546[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field1761[var12] == 0) {
                  this.method2397(var8.field1761[var12], var8.field1762[var12], var7.field1547[var11], var7.field1548[var11], var7.field1540[var11]);
               }
            }

            this.field1849 = 0;
         } else {
            this.method2461(var1, var2);
         }
      }
   }

   @ObfuscatedName("e")
   void method2397(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1845 = 0;
         field1809 = 0;
         field1847 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var18 = var2[var8];
            if(var18 < this.field1817.length) {
               int[] var19 = this.field1817[var18];

               for(var11 = 0; var11 < var19.length; ++var11) {
                  var12 = var19[var11];
                  field1845 += this.field1798[var12];
                  field1809 += this.field1799[var12];
                  field1847 += this.field1839[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1845 = field1845 / var7 + var3;
            field1809 = field1809 / var7 + var4;
            field1847 = field1847 / var7 + var5;
         } else {
            field1845 = var3;
            field1809 = var4;
            field1847 = var5;
         }

      } else {
         int[] var9;
         int var10;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1817.length) {
                  var9 = this.field1817[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.field1798[var11] += var3;
                     this.field1799[var11] += var4;
                     this.field1839[var11] += var5;
                  }
               }
            }

         } else if(var1 == 2) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1817.length) {
                  var9 = this.field1817[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.field1798[var11] -= field1845;
                     this.field1799[var11] -= field1809;
                     this.field1839[var11] -= field1847;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1853[var14];
                        var16 = field1803[var14];
                        var17 = this.field1799[var11] * var15 + this.field1798[var11] * var16 >> 16;
                        this.field1799[var11] = this.field1799[var11] * var16 - this.field1798[var11] * var15 >> 16;
                        this.field1798[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1853[var12];
                        var16 = field1803[var12];
                        var17 = this.field1799[var11] * var16 - this.field1839[var11] * var15 >> 16;
                        this.field1839[var11] = this.field1799[var11] * var15 + this.field1839[var11] * var16 >> 16;
                        this.field1799[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1853[var13];
                        var16 = field1803[var13];
                        var17 = this.field1839[var11] * var15 + this.field1798[var11] * var16 >> 16;
                        this.field1839[var11] = this.field1839[var11] * var16 - this.field1798[var11] * var15 >> 16;
                        this.field1798[var11] = var17;
                     }

                     this.field1798[var11] += field1845;
                     this.field1799[var11] += field1809;
                     this.field1839[var11] += field1847;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1817.length) {
                  var9 = this.field1817[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.field1798[var11] -= field1845;
                     this.field1799[var11] -= field1809;
                     this.field1839[var11] -= field1847;
                     this.field1798[var11] = this.field1798[var11] * var3 / 128;
                     this.field1799[var11] = this.field1799[var11] * var4 / 128;
                     this.field1839[var11] = this.field1839[var11] * var5 / 128;
                     this.field1798[var11] += field1845;
                     this.field1799[var11] += field1809;
                     this.field1839[var11] += field1847;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1822 != null && this.field1833 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1822.length) {
                     var9 = this.field1822[var8];

                     for(var10 = 0; var10 < var9.length; ++var10) {
                        var11 = var9[var10];
                        var12 = (this.field1833[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1833[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("x")
   public void method2398() {
      for(int var1 = 0; var1 < this.field1797; ++var1) {
         int var2 = this.field1798[var1];
         this.field1798[var1] = this.field1839[var1];
         this.field1839[var1] = -var2;
      }

      this.field1849 = 0;
   }

   @ObfuscatedName("z")
   public void method2399() {
      for(int var1 = 0; var1 < this.field1797; ++var1) {
         this.field1798[var1] = -this.field1798[var1];
         this.field1839[var1] = -this.field1839[var1];
      }

      this.field1849 = 0;
   }

   @ObfuscatedName("n")
   public void method2400() {
      for(int var1 = 0; var1 < this.field1797; ++var1) {
         int var2 = this.field1839[var1];
         this.field1839[var1] = this.field1798[var1];
         this.field1798[var1] = -var2;
      }

      this.field1849 = 0;
   }

   @ObfuscatedName("u")
   public void method2401(int var1) {
      int var2 = field1853[var1];
      int var3 = field1803[var1];

      for(int var4 = 0; var4 < this.field1797; ++var4) {
         int var5 = this.field1799[var4] * var3 - this.field1839[var4] * var2 >> 16;
         this.field1839[var4] = this.field1799[var4] * var2 + this.field1839[var4] * var3 >> 16;
         this.field1799[var4] = var5;
      }

      this.field1849 = 0;
   }

   @ObfuscatedName("g")
   public void method2402(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1797; ++var4) {
         this.field1798[var4] += var1;
         this.field1799[var4] += var2;
         this.field1839[var4] += var3;
      }

      this.field1849 = 0;
   }

   @ObfuscatedName("j")
   public void method2403(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1797; ++var4) {
         this.field1798[var4] = this.field1798[var4] * var1 / 128;
         this.field1799[var4] = this.field1799[var4] * var2 / 128;
         this.field1839[var4] = this.field1839[var4] * var3 / 128;
      }

      this.field1849 = 0;
   }

   @ObfuscatedName("f")
   final void method2407(boolean var1, boolean var2, int var3) {
      if(this.field1823 < 1600) {
         int var4;
         for(var4 = 0; var4 < this.field1823; ++var4) {
            field1812[var4] = 0;
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
         for(var4 = 0; var4 < this.field1801; ++var4) {
            if(this.field1807[var4] != -2) {
               var5 = this.field1793[var4];
               var6 = this.field1835[var4];
               var7 = this.field1800[var4];
               var8 = field1828[var5];
               var9 = field1828[var6];
               var10 = field1828[var7];
               int var11;
               if(!var1 || var8 != -5000 && var9 != -5000 && var10 != -5000) {
                  if(var2 && this.method2415(field1794, field1850, field1829[var5], field1829[var6], field1829[var7], var8, var9, var10)) {
                     field1852[field1851++] = var3;
                     var2 = false;
                  }

                  if((var8 - var9) * (field1829[var7] - field1829[var6]) - (field1829[var5] - field1829[var6]) * (var10 - var9) > 0) {
                     field1827[var4] = false;
                     if(var8 >= 0 && var9 >= 0 && var10 >= 0 && var8 <= class91.field1570 && var9 <= class91.field1570 && var10 <= class91.field1570) {
                        field1820[var4] = false;
                     } else {
                        field1820[var4] = true;
                     }

                     var11 = (field1830[var5] + field1830[var6] + field1830[var7]) / 3 + this.field1824;
                     field1838[var11][field1812[var11]++] = var4;
                  }
               } else {
                  var11 = field1831[var5];
                  var12 = field1831[var6];
                  var13 = field1831[var7];
                  int var14 = field1832[var5];
                  var15 = field1832[var6];
                  int var16 = field1832[var7];
                  int var17 = field1854[var5];
                  int var18 = field1854[var6];
                  int var19 = field1854[var7];
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
                     field1827[var4] = true;
                     int var23 = (field1830[var5] + field1830[var6] + field1830[var7]) / 3 + this.field1824;
                     field1838[var23][field1812[var23]++] = var4;
                  }
               }
            }
         }

         int[] var24;
         if(this.field1808 == null) {
            for(var4 = this.field1823 - 1; var4 >= 0; --var4) {
               var5 = field1812[var4];
               if(var5 > 0) {
                  var24 = field1838[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     this.method2392(var24[var7]);
                  }
               }
            }

         } else {
            for(var4 = 0; var4 < 12; ++var4) {
               field1837[var4] = 0;
               field1841[var4] = 0;
            }

            for(var4 = this.field1823 - 1; var4 >= 0; --var4) {
               var5 = field1812[var4];
               if(var5 > 0) {
                  var24 = field1838[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     var8 = var24[var7];
                     byte var25 = this.field1808[var8];
                     var10 = field1837[var25]++;
                     field1818[var25][var10] = var8;
                     if(var25 < 10) {
                        field1841[var25] += var4;
                     } else if(var25 == 10) {
                        field1857[var10] = var4;
                     } else {
                        field1840[var10] = var4;
                     }
                  }
               }
            }

            var4 = 0;
            if(field1837[1] > 0 || field1837[2] > 0) {
               var4 = (field1841[1] + field1841[2]) / (field1837[1] + field1837[2]);
            }

            var5 = 0;
            if(field1837[3] > 0 || field1837[4] > 0) {
               var5 = (field1841[3] + field1841[4]) / (field1837[3] + field1837[4]);
            }

            var6 = 0;
            if(field1837[6] > 0 || field1837[8] > 0) {
               var6 = (field1841[6] + field1841[8]) / (field1837[6] + field1837[8]);
            }

            var8 = 0;
            var9 = field1837[10];
            int[] var26 = field1818[10];
            int[] var27 = field1857;
            if(var8 == var9) {
               var8 = 0;
               var9 = field1837[11];
               var26 = field1818[11];
               var27 = field1840;
            }

            if(var8 < var9) {
               var7 = var27[var8];
            } else {
               var7 = -1000;
            }

            for(var12 = 0; var12 < 10; ++var12) {
               while(var12 == 0 && var7 > var4) {
                  this.method2392(var26[var8++]);
                  if(var8 == var9 && var26 != field1818[11]) {
                     var8 = 0;
                     var9 = field1837[11];
                     var26 = field1818[11];
                     var27 = field1840;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 3 && var7 > var5) {
                  this.method2392(var26[var8++]);
                  if(var8 == var9 && var26 != field1818[11]) {
                     var8 = 0;
                     var9 = field1837[11];
                     var26 = field1818[11];
                     var27 = field1840;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 5 && var7 > var6) {
                  this.method2392(var26[var8++]);
                  if(var8 == var9 && var26 != field1818[11]) {
                     var8 = 0;
                     var9 = field1837[11];
                     var26 = field1818[11];
                     var27 = field1840;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               var13 = field1837[var12];
               int[] var28 = field1818[var12];

               for(var15 = 0; var15 < var13; ++var15) {
                  this.method2392(var28[var15]);
               }
            }

            while(var7 != -1000) {
               this.method2392(var26[var8++]);
               if(var8 == var9 && var26 != field1818[11]) {
                  var8 = 0;
                  var26 = field1818[11];
                  var9 = field1837[11];
                  var27 = field1840;
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

   @ObfuscatedName("l")
   final void method2409(int var1) {
      int var2 = class91.field1580;
      int var3 = class91.field1581;
      int var4 = 0;
      int var5 = this.field1793[var1];
      int var6 = this.field1835[var1];
      int var7 = this.field1800[var1];
      int var8 = field1854[var5];
      int var9 = field1854[var6];
      int var10 = field1854[var7];
      if(this.field1833 == null) {
         class91.field1574 = 0;
      } else {
         class91.field1574 = this.field1833[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1826[var4] = field1828[var5];
         field1843[var4] = field1829[var5];
         field1844[var4++] = this.field1805[var1];
      } else {
         var11 = field1831[var5];
         var12 = field1832[var5];
         var13 = this.field1805[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1856[var10 - var8];
            field1826[var4] = var2 + (var11 + ((field1831[var7] - var11) * var14 >> 16)) * class91.field1579 / 50;
            field1843[var4] = var3 + (var12 + ((field1832[var7] - var12) * var14 >> 16)) * class91.field1579 / 50;
            field1844[var4++] = var13 + ((this.field1807[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1856[var9 - var8];
            field1826[var4] = var2 + (var11 + ((field1831[var6] - var11) * var14 >> 16)) * class91.field1579 / 50;
            field1843[var4] = var3 + (var12 + ((field1832[var6] - var12) * var14 >> 16)) * class91.field1579 / 50;
            field1844[var4++] = var13 + ((this.field1806[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1826[var4] = field1828[var6];
         field1843[var4] = field1829[var6];
         field1844[var4++] = this.field1806[var1];
      } else {
         var11 = field1831[var6];
         var12 = field1832[var6];
         var13 = this.field1806[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1856[var8 - var9];
            field1826[var4] = var2 + (var11 + ((field1831[var5] - var11) * var14 >> 16)) * class91.field1579 / 50;
            field1843[var4] = var3 + (var12 + ((field1832[var5] - var12) * var14 >> 16)) * class91.field1579 / 50;
            field1844[var4++] = var13 + ((this.field1805[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1856[var10 - var9];
            field1826[var4] = var2 + (var11 + ((field1831[var7] - var11) * var14 >> 16)) * class91.field1579 / 50;
            field1843[var4] = var3 + (var12 + ((field1832[var7] - var12) * var14 >> 16)) * class91.field1579 / 50;
            field1844[var4++] = var13 + ((this.field1807[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1826[var4] = field1828[var7];
         field1843[var4] = field1829[var7];
         field1844[var4++] = this.field1807[var1];
      } else {
         var11 = field1831[var7];
         var12 = field1832[var7];
         var13 = this.field1807[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1856[var9 - var10];
            field1826[var4] = var2 + (var11 + ((field1831[var6] - var11) * var14 >> 16)) * class91.field1579 / 50;
            field1843[var4] = var3 + (var12 + ((field1832[var6] - var12) * var14 >> 16)) * class91.field1579 / 50;
            field1844[var4++] = var13 + ((this.field1806[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1856[var8 - var10];
            field1826[var4] = var2 + (var11 + ((field1831[var5] - var11) * var14 >> 16)) * class91.field1579 / 50;
            field1843[var4] = var3 + (var12 + ((field1832[var5] - var12) * var14 >> 16)) * class91.field1579 / 50;
            field1844[var4++] = var13 + ((this.field1805[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1826[0];
      var12 = field1826[1];
      var13 = field1826[2];
      var14 = field1843[0];
      int var15 = field1843[1];
      int var16 = field1843[2];
      class91.field1576 = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class91.field1570 || var12 > class91.field1570 || var13 > class91.field1570) {
            class91.field1576 = true;
         }

         if(this.field1811 != null && this.field1811[var1] != -1) {
            if(this.field1810 != null && this.field1810[var1] != -1) {
               var20 = this.field1810[var1] & 255;
               var17 = this.field1802[var20];
               var18 = this.field1834[var20];
               var19 = this.field1816[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1807[var1] == -1) {
               class91.method2230(var14, var15, var16, var11, var12, var13, this.field1805[var1], this.field1805[var1], this.field1805[var1], field1831[var17], field1831[var18], field1831[var19], field1832[var17], field1832[var18], field1832[var19], field1854[var17], field1854[var18], field1854[var19], this.field1811[var1]);
            } else {
               class91.method2230(var14, var15, var16, var11, var12, var13, field1844[0], field1844[1], field1844[2], field1831[var17], field1831[var18], field1831[var19], field1832[var17], field1832[var18], field1832[var19], field1854[var17], field1854[var18], field1854[var19], this.field1811[var1]);
            }
         } else if(this.field1807[var1] == -1) {
            class91.method2180(var14, var15, var16, var11, var12, var13, field1855[this.field1805[var1]]);
         } else {
            class91.method2178(var14, var15, var16, var11, var12, var13, field1844[0], field1844[1], field1844[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class91.field1570 || var12 > class91.field1570 || var13 > class91.field1570 || field1826[3] < 0 || field1826[3] > class91.field1570) {
            class91.field1576 = true;
         }

         if(this.field1811 != null && this.field1811[var1] != -1) {
            if(this.field1810 != null && this.field1810[var1] != -1) {
               var20 = this.field1810[var1] & 255;
               var17 = this.field1802[var20];
               var18 = this.field1834[var20];
               var19 = this.field1816[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1811[var1];
            if(this.field1807[var1] == -1) {
               class91.method2230(var14, var15, var16, var11, var12, var13, this.field1805[var1], this.field1805[var1], this.field1805[var1], field1831[var17], field1831[var18], field1831[var19], field1832[var17], field1832[var18], field1832[var19], field1854[var17], field1854[var18], field1854[var19], var21);
               class91.method2230(var14, var16, field1843[3], var11, var13, field1826[3], this.field1805[var1], this.field1805[var1], this.field1805[var1], field1831[var17], field1831[var18], field1831[var19], field1832[var17], field1832[var18], field1832[var19], field1854[var17], field1854[var18], field1854[var19], var21);
            } else {
               class91.method2230(var14, var15, var16, var11, var12, var13, field1844[0], field1844[1], field1844[2], field1831[var17], field1831[var18], field1831[var19], field1832[var17], field1832[var18], field1832[var19], field1854[var17], field1854[var18], field1854[var19], var21);
               class91.method2230(var14, var16, field1843[3], var11, var13, field1826[3], field1844[0], field1844[2], field1844[3], field1831[var17], field1831[var18], field1831[var19], field1832[var17], field1832[var18], field1832[var19], field1854[var17], field1854[var18], field1854[var19], var21);
            }
         } else if(this.field1807[var1] == -1) {
            var17 = field1855[this.field1805[var1]];
            class91.method2180(var14, var15, var16, var11, var12, var13, var17);
            class91.method2180(var14, var16, field1843[3], var11, var13, field1826[3], var17);
         } else {
            class91.method2178(var14, var15, var16, var11, var12, var13, field1844[0], field1844[1], field1844[2]);
            class91.method2178(var14, var16, field1843[3], var11, var13, field1826[3], field1844[0], field1844[2], field1844[3]);
         }
      }

   }

   @ObfuscatedName("o")
   final boolean method2415(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      return var2 < var3 && var2 < var4 && var2 < var5?false:(var2 > var3 && var2 > var4 && var2 > var5?false:(var1 < var6 && var1 < var7 && var1 < var8?false:var1 <= var6 || var1 <= var7 || var1 <= var8));
   }

   @ObfuscatedName("k")
   public void method2418() {
      if(this.field1849 != 1) {
         this.field1849 = 1;
         super.field1465 = 0;
         this.field1821 = 0;
         this.field1842 = 0;

         for(int var1 = 0; var1 < this.field1797; ++var1) {
            int var2 = this.field1798[var1];
            int var3 = this.field1799[var1];
            int var4 = this.field1839[var1];
            if(-var3 > super.field1465) {
               super.field1465 = -var3;
            }

            if(var3 > this.field1821) {
               this.field1821 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1842) {
               this.field1842 = var5;
            }
         }

         this.field1842 = (int)(Math.sqrt((double)this.field1842) + 0.99D);
         this.field1824 = (int)(Math.sqrt((double)(this.field1842 * this.field1842 + super.field1465 * super.field1465)) + 0.99D);
         this.field1823 = this.field1824 + (int)(Math.sqrt((double)(this.field1842 * this.field1842 + this.field1821 * this.field1821)) + 0.99D);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "0"
   )
   public final void method2420(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1812[0] = -1;
      if(this.field1849 != 2 && this.field1849 != 1) {
         this.method2393();
      }

      int var8 = class91.field1580;
      int var9 = class91.field1581;
      int var10000 = field1853[var1];
      var10000 = field1803[var1];
      int var12 = field1853[var2];
      int var13 = field1803[var2];
      int var14 = field1853[var3];
      int var15 = field1803[var3];
      int var16 = field1853[var4];
      int var17 = field1803[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1797; ++var19) {
         int var20 = this.field1798[var19];
         int var21 = this.field1799[var19];
         int var22 = this.field1839[var19];
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
         field1830[var19] = var22 - var18;
         field1828[var19] = var8 + var20 * class91.field1579 / var22;
         field1829[var19] = var9 + var23 * class91.field1579 / var22;
         if(this.field1813 > 0) {
            field1831[var19] = var20;
            field1832[var19] = var23;
            field1854[var19] = var22;
         }
      }

      try {
         this.method2407(false, false, 0);
      } catch (Exception var24) {
         ;
      }

   }

   class105() {
   }

   @ObfuscatedName("p")
   public int method2426() {
      this.method2418();
      return this.field1842;
   }

   static {
      field1853 = class91.field1593;
      field1803 = class91.field1594;
      field1855 = class91.field1589;
      field1856 = class91.field1586;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([[IIIIZI)Lclass105;",
      garbageValue = "1"
   )
   public class105 method2453(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2418();
      int var7 = var2 - this.field1842;
      int var8 = var2 + this.field1842;
      int var9 = var4 - this.field1842;
      int var10 = var4 + this.field1842;
      if(var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
         var7 >>= 7;
         var8 = var8 + 127 >> 7;
         var9 >>= 7;
         var10 = var10 + 127 >> 7;
         if(var1[var7][var9] == var3 && var1[var8][var9] == var3 && var1[var7][var10] == var3 && var1[var8][var10] == var3) {
            return this;
         } else {
            class105 var11 = new class105();
            var11.field1797 = this.field1797;
            var11.field1801 = this.field1801;
            var11.field1813 = this.field1813;
            var11.field1798 = this.field1798;
            var11.field1839 = this.field1839;
            var11.field1793 = this.field1793;
            var11.field1835 = this.field1835;
            var11.field1800 = this.field1800;
            var11.field1805 = this.field1805;
            var11.field1806 = this.field1806;
            var11.field1807 = this.field1807;
            var11.field1808 = this.field1808;
            var11.field1833 = this.field1833;
            var11.field1810 = this.field1810;
            var11.field1811 = this.field1811;
            var11.field1795 = this.field1795;
            var11.field1802 = this.field1802;
            var11.field1834 = this.field1834;
            var11.field1816 = this.field1816;
            var11.field1817 = this.field1817;
            var11.field1822 = this.field1822;
            var11.field1819 = this.field1819;
            var11.field1799 = new int[var11.field1797];
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
               for(var12 = 0; var12 < var11.field1797; ++var12) {
                  var13 = this.field1798[var12] + var2;
                  var14 = this.field1839[var12] + var4;
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var1[var17 + 1][var18 + 1] * var15 >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.field1799[var12] = this.field1799[var12] + var21 - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1797; ++var12) {
                  var13 = (-this.field1799[var12] << 16) / super.field1465;
                  if(var13 < var6) {
                     var14 = this.field1798[var12] + var2;
                     var15 = this.field1839[var12] + var4;
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var1[var18 + 1][var19 + 1] * var16 >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.field1799[var12] = this.field1799[var12] + (var22 - var3) * (var6 - var13) / var6;
                  }
               }
            }

            var11.field1849 = 0;
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("at")
   void vmethod2455(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1812[0] = -1;
      if(this.field1849 != 1) {
         this.method2418();
      }

      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1842 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1842) * class91.field1579;
         if(var15 / var13 < class91.field1578) {
            int var16 = (var14 + this.field1842) * class91.field1579;
            if(var16 / var13 > class91.field1584) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1842 * var2 >> 16;
               int var19 = (var17 + var18) * class91.field1579;
               if(var19 / var13 > class91.field1587) {
                  int var20 = var18 + (super.field1465 * var3 >> 16);
                  int var21 = (var17 - var20) * class91.field1579;
                  if(var21 / var13 < class91.field1585) {
                     int var22 = var12 + (super.field1465 * var2 >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1813 > 0;
                     boolean var26 = false;
                     int var27;
                     int var28;
                     int var29;
                     if(var9 > 0 && field1848) {
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

                        var28 = field1794 - class91.field1580;
                        var29 = field1850 - class91.field1581;
                        if(var28 > var15 && var28 < var16 && var29 > var21 && var29 < var19) {
                           if(this.field1819) {
                              field1852[field1851++] = var9;
                           } else {
                              var26 = true;
                           }
                        }
                     }

                     var27 = class91.field1580;
                     var28 = class91.field1581;
                     var29 = 0;
                     int var30 = 0;
                     if(var1 != 0) {
                        var29 = field1853[var1];
                        var30 = field1803[var1];
                     }

                     for(int var31 = 0; var31 < this.field1797; ++var31) {
                        int var32 = this.field1798[var31];
                        int var33 = this.field1799[var31];
                        int var34 = this.field1839[var31];
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
                        field1830[var31] = var34 - var11;
                        if(var34 >= 50) {
                           field1828[var31] = var27 + var32 * class91.field1579 / var34;
                           field1829[var31] = var28 + var35 * class91.field1579 / var34;
                        } else {
                           field1828[var31] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1831[var31] = var32;
                           field1832[var31] = var35;
                           field1854[var31] = var34;
                        }
                     }

                     try {
                        this.method2407(var23, var26, var9);
                     } catch (Exception var36) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "0"
   )
   public final void method2460(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1812[0] = -1;
      if(this.field1849 != 2 && this.field1849 != 1) {
         this.method2393();
      }

      int var9 = class91.field1580;
      int var10 = class91.field1581;
      int var10000 = field1853[var1];
      var10000 = field1803[var1];
      int var13 = field1853[var2];
      int var14 = field1803[var2];
      int var15 = field1853[var3];
      int var16 = field1803[var3];
      int var17 = field1853[var4];
      int var18 = field1803[var4];
      int var19 = var6 * var17 + var7 * var18 >> 16;

      for(int var20 = 0; var20 < this.field1797; ++var20) {
         int var21 = this.field1798[var20];
         int var22 = this.field1799[var20];
         int var23 = this.field1839[var20];
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
         field1830[var20] = var23 - var19;
         field1828[var20] = var9 + var21 * class91.field1579 / var8;
         field1829[var20] = var10 + var24 * class91.field1579 / var8;
         if(this.field1813 > 0) {
            field1831[var20] = var21;
            field1832[var20] = var24;
            field1854[var20] = var23;
         }
      }

      try {
         this.method2407(false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("q")
   public void method2461(class103 var1, int var2) {
      if(this.field1817 != null) {
         if(var2 != -1) {
            class88 var3 = var1.field1770[var2];
            class102 var4 = var3.field1549;
            field1845 = 0;
            field1809 = 0;
            field1847 = 0;

            for(int var5 = 0; var5 < var3.field1545; ++var5) {
               int var6 = var3.field1546[var5];
               this.method2397(var4.field1761[var6], var4.field1762[var6], var3.field1547[var5], var3.field1548[var5], var3.field1540[var5]);
            }

            this.field1849 = 0;
         }
      }
   }

   @ObfuscatedName("w")
   public class105 method2471(boolean var1) {
      if(!var1 && field1836.length < this.field1801) {
         field1836 = new byte[this.field1801 + 100];
      }

      return this.method2391(var1, field1846, field1836);
   }
}
