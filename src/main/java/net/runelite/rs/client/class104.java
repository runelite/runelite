package net.runelite.rs.client;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("da")
@Implements("Model")
public class class104 extends class84 {
   @ObfuscatedName("az")
   static boolean[] field1775 = new boolean[4096];
   @ObfuscatedName("m")
   static byte[] field1776 = new byte[1];
   @ObfuscatedName("f")
   static class104 field1777 = new class104();
   @ObfuscatedName("b")
   int[][] field1778;
   @ObfuscatedName("v")
   byte field1779 = 0;
   @ObfuscatedName("am")
   int field1780;
   @ObfuscatedName("i")
   int[] field1781;
   @ObfuscatedName("aw")
   static int[] field1782 = new int[2000];
   @ObfuscatedName("t")
   int field1783 = 0;
   @ObfuscatedName("g")
   byte[] field1784;
   @ObfuscatedName("aq")
   static int[] field1785 = new int[12];
   @ObfuscatedName("a")
   int[] field1786;
   @ObfuscatedName("e")
   int[] field1787;
   @ObfuscatedName("k")
   int[] field1788;
   @ObfuscatedName("x")
   int[] field1789;
   @ObfuscatedName("r")
   byte[] field1790;
   @ObfuscatedName("ak")
   static int[] field1791 = new int[1600];
   @ObfuscatedName("n")
   byte[] field1792;
   @ObfuscatedName("y")
   short[] field1793;
   @ObfuscatedName("bf")
   static int field1794;
   @ObfuscatedName("q")
   int field1795 = 0;
   @ObfuscatedName("ay")
   static boolean[] field1796 = new boolean[4096];
   @ObfuscatedName("d")
   int[] field1797;
   @ObfuscatedName("o")
   int[] field1798;
   @ObfuscatedName("c")
   int[][] field1799;
   @ObfuscatedName("z")
   int[] field1800;
   @ObfuscatedName("ac")
   static int[] field1801 = new int[4096];
   @ObfuscatedName("ao")
   int field1802;
   @ObfuscatedName("as")
   int field1803;
   @ObfuscatedName("ae")
   int field1804;
   @ObfuscatedName("ai")
   int field1805;
   @ObfuscatedName("s")
   int[] field1806;
   @ObfuscatedName("an")
   static int[] field1808 = new int[10];
   @ObfuscatedName("ab")
   static int[] field1809 = new int[10];
   @ObfuscatedName("af")
   static int[] field1810 = new int[12];
   @ObfuscatedName("ap")
   static int[] field1811 = new int[4096];
   @ObfuscatedName("at")
   static int[] field1812 = new int[4096];
   @ObfuscatedName("al")
   static int[] field1813 = new int[4096];
   @ObfuscatedName("l")
   static byte[] field1814 = new byte[1];
   @ObfuscatedName("ar")
   static int[] field1815 = new int[4096];
   @ObfuscatedName("u")
   int field1816 = 0;
   @ObfuscatedName("w")
   int[] field1817;
   @ObfuscatedName("ag")
   static int[][] field1818 = new int[1600][512];
   @ObfuscatedName("bj")
   static int field1819;
   @ObfuscatedName("au")
   static int[][] field1820 = new int[12][2000];
   @ObfuscatedName("aa")
   public boolean field1821 = false;
   @ObfuscatedName("ad")
   static int[] field1822 = new int[2000];
   @ObfuscatedName("p")
   int[] field1823;
   @ObfuscatedName("aj")
   static int[] field1824 = new int[10];
   @ObfuscatedName("av")
   static int[] field1825 = new int[4096];
   @ObfuscatedName("j")
   static class104 field1827 = new class104();
   @ObfuscatedName("bn")
   static int field1828;
   @ObfuscatedName("h")
   int[] field1829;
   @ObfuscatedName("bm")
   public static boolean field1830 = false;
   @ObfuscatedName("bc")
   public static int field1831 = 0;
   @ObfuscatedName("bu")
   public static int field1832 = 0;
   @ObfuscatedName("ba")
   public static int field1833 = 0;
   @ObfuscatedName("bi")
   public static int[] field1834 = new int[1000];
   @ObfuscatedName("bq")
   static int[] field1835;
   @ObfuscatedName("bk")
   static int[] field1836;
   @ObfuscatedName("be")
   static int[] field1837;
   @ObfuscatedName("bl")
   static int[] field1838;

   public class104(class104[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      this.field1816 = 0;
      this.field1783 = 0;
      this.field1795 = 0;
      this.field1779 = -1;

      int var7;
      class104 var8;
      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            this.field1816 += var8.field1816;
            this.field1783 += var8.field1783;
            this.field1795 += var8.field1795;
            if(var8.field1790 != null) {
               var3 = true;
            } else {
               if(this.field1779 == -1) {
                  this.field1779 = var8.field1779;
               }

               if(this.field1779 != var8.field1779) {
                  var3 = true;
               }
            }

            var4 |= var8.field1784 != null;
            var5 |= var8.field1793 != null;
            var6 |= var8.field1792 != null;
         }
      }

      this.field1786 = new int[this.field1816];
      this.field1829 = new int[this.field1816];
      this.field1781 = new int[this.field1816];
      this.field1788 = new int[this.field1783];
      this.field1806 = new int[this.field1783];
      this.field1817 = new int[this.field1783];
      this.field1787 = new int[this.field1783];
      this.field1800 = new int[this.field1783];
      this.field1823 = new int[this.field1783];
      if(var3) {
         this.field1790 = new byte[this.field1783];
      }

      if(var4) {
         this.field1784 = new byte[this.field1783];
      }

      if(var5) {
         this.field1793 = new short[this.field1783];
      }

      if(var6) {
         this.field1792 = new byte[this.field1783];
      }

      if(this.field1795 > 0) {
         this.field1789 = new int[this.field1795];
         this.field1797 = new int[this.field1795];
         this.field1798 = new int[this.field1795];
      }

      this.field1816 = 0;
      this.field1783 = 0;
      this.field1795 = 0;

      for(var7 = 0; var7 < var2; ++var7) {
         var8 = var1[var7];
         if(var8 != null) {
            int var9;
            for(var9 = 0; var9 < var8.field1783; ++var9) {
               this.field1788[this.field1783] = var8.field1788[var9] + this.field1816;
               this.field1806[this.field1783] = var8.field1806[var9] + this.field1816;
               this.field1817[this.field1783] = var8.field1817[var9] + this.field1816;
               this.field1787[this.field1783] = var8.field1787[var9];
               this.field1800[this.field1783] = var8.field1800[var9];
               this.field1823[this.field1783] = var8.field1823[var9];
               if(var3) {
                  if(var8.field1790 != null) {
                     this.field1790[this.field1783] = var8.field1790[var9];
                  } else {
                     this.field1790[this.field1783] = var8.field1779;
                  }
               }

               if(var4 && var8.field1784 != null) {
                  this.field1784[this.field1783] = var8.field1784[var9];
               }

               if(var5) {
                  if(var8.field1793 != null) {
                     this.field1793[this.field1783] = var8.field1793[var9];
                  } else {
                     this.field1793[this.field1783] = -1;
                  }
               }

               if(var6) {
                  if(var8.field1792 != null && var8.field1792[var9] != -1) {
                     this.field1792[this.field1783] = (byte)(var8.field1792[var9] + this.field1795);
                  } else {
                     this.field1792[this.field1783] = -1;
                  }
               }

               ++this.field1783;
            }

            for(var9 = 0; var9 < var8.field1795; ++var9) {
               this.field1789[this.field1795] = var8.field1789[var9] + this.field1816;
               this.field1797[this.field1795] = var8.field1797[var9] + this.field1816;
               this.field1798[this.field1795] = var8.field1798[var9] + this.field1816;
               ++this.field1795;
            }

            for(var9 = 0; var9 < var8.field1816; ++var9) {
               this.field1786[this.field1816] = var8.field1786[var9];
               this.field1829[this.field1816] = var8.field1829[var9];
               this.field1781[this.field1816] = var8.field1781[var9];
               ++this.field1816;
            }
         }
      }

   }

   @ObfuscatedName("u")
   class104 method2333(boolean var1, class104 var2, byte[] var3) {
      var2.field1816 = this.field1816;
      var2.field1783 = this.field1783;
      var2.field1795 = this.field1795;
      if(var2.field1786 == null || var2.field1786.length < this.field1816) {
         var2.field1786 = new int[this.field1816 + 100];
         var2.field1829 = new int[this.field1816 + 100];
         var2.field1781 = new int[this.field1816 + 100];
      }

      int var4;
      for(var4 = 0; var4 < this.field1816; ++var4) {
         var2.field1786[var4] = this.field1786[var4];
         var2.field1829[var4] = this.field1829[var4];
         var2.field1781[var4] = this.field1781[var4];
      }

      if(var1) {
         var2.field1784 = this.field1784;
      } else {
         var2.field1784 = var3;
         if(this.field1784 == null) {
            for(var4 = 0; var4 < this.field1783; ++var4) {
               var2.field1784[var4] = 0;
            }
         } else {
            for(var4 = 0; var4 < this.field1783; ++var4) {
               var2.field1784[var4] = this.field1784[var4];
            }
         }
      }

      var2.field1788 = this.field1788;
      var2.field1806 = this.field1806;
      var2.field1817 = this.field1817;
      var2.field1787 = this.field1787;
      var2.field1800 = this.field1800;
      var2.field1823 = this.field1823;
      var2.field1790 = this.field1790;
      var2.field1792 = this.field1792;
      var2.field1793 = this.field1793;
      var2.field1779 = this.field1779;
      var2.field1789 = this.field1789;
      var2.field1797 = this.field1797;
      var2.field1798 = this.field1798;
      var2.field1799 = this.field1799;
      var2.field1778 = this.field1778;
      var2.field1821 = this.field1821;
      var2.field1802 = 0;
      return var2;
   }

   @ObfuscatedName("a")
   public void method2334() {
      if(this.field1802 != 1) {
         this.field1802 = 1;
         super.field1441 = 0;
         this.field1803 = 0;
         this.field1804 = 0;

         for(int var1 = 0; var1 < this.field1816; ++var1) {
            int var2 = this.field1786[var1];
            int var3 = this.field1829[var1];
            int var4 = this.field1781[var1];
            if(-var3 > super.field1441) {
               super.field1441 = -var3;
            }

            if(var3 > this.field1803) {
               this.field1803 = var3;
            }

            int var5 = var2 * var2 + var4 * var4;
            if(var5 > this.field1804) {
               this.field1804 = var5;
            }
         }

         this.field1804 = (int)(Math.sqrt((double)this.field1804) + 0.99D);
         this.field1780 = (int)(Math.sqrt((double)(this.field1804 * this.field1804 + super.field1441 * super.field1441)) + 0.99D);
         this.field1805 = this.field1780 + (int)(Math.sqrt((double)(this.field1804 * this.field1804 + this.field1803 * this.field1803)) + 0.99D);
      }
   }

   @ObfuscatedName("h")
   void method2335() {
      if(this.field1802 != 2) {
         this.field1802 = 2;
         this.field1804 = 0;

         for(int var1 = 0; var1 < this.field1816; ++var1) {
            int var2 = this.field1786[var1];
            int var3 = this.field1829[var1];
            int var4 = this.field1781[var1];
            int var5 = var2 * var2 + var4 * var4 + var3 * var3;
            if(var5 > this.field1804) {
               this.field1804 = var5;
            }
         }

         this.field1804 = (int)(Math.sqrt((double)this.field1804) + 0.99D);
         this.field1780 = this.field1804;
         this.field1805 = this.field1804 + this.field1804;
      }
   }

   @ObfuscatedName("i")
   public int method2336() {
      this.method2334();
      return this.field1804;
   }

   @ObfuscatedName("t")
   public void method2337(class102 var1, int var2) {
      if(this.field1799 != null) {
         if(var2 != -1) {
            class87 var3 = var1.field1752[var2];
            class101 var4 = var3.field1530;
            field1819 = 0;
            field1828 = 0;
            field1794 = 0;

            for(int var5 = 0; var5 < var3.field1525; ++var5) {
               int var6 = var3.field1526[var5];
               this.method2400(var4.field1742[var6], var4.field1743[var6], var3.field1527[var5], var3.field1528[var5], var3.field1529[var5]);
            }

            this.field1802 = 0;
         }
      }
   }

   @ObfuscatedName("r")
   public void method2340() {
      for(int var1 = 0; var1 < this.field1816; ++var1) {
         int var2 = this.field1786[var1];
         this.field1786[var1] = this.field1781[var1];
         this.field1781[var1] = -var2;
      }

      this.field1802 = 0;
   }

   @ObfuscatedName("g")
   public void method2341() {
      for(int var1 = 0; var1 < this.field1816; ++var1) {
         this.field1786[var1] = -this.field1786[var1];
         this.field1781[var1] = -this.field1781[var1];
      }

      this.field1802 = 0;
   }

   @ObfuscatedName("j")
   public class104 method2342(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2334();
      int var7 = var2 - this.field1804;
      int var8 = var2 + this.field1804;
      int var9 = var4 - this.field1804;
      int var10 = var4 + this.field1804;
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
               var11.field1816 = this.field1816;
               var11.field1783 = this.field1783;
               var11.field1795 = this.field1795;
               var11.field1786 = this.field1786;
               var11.field1781 = this.field1781;
               var11.field1788 = this.field1788;
               var11.field1806 = this.field1806;
               var11.field1817 = this.field1817;
               var11.field1787 = this.field1787;
               var11.field1800 = this.field1800;
               var11.field1823 = this.field1823;
               var11.field1790 = this.field1790;
               var11.field1784 = this.field1784;
               var11.field1792 = this.field1792;
               var11.field1793 = this.field1793;
               var11.field1779 = this.field1779;
               var11.field1789 = this.field1789;
               var11.field1797 = this.field1797;
               var11.field1798 = this.field1798;
               var11.field1799 = this.field1799;
               var11.field1778 = this.field1778;
               var11.field1821 = this.field1821;
               var11.field1829 = new int[var11.field1816];
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
               for(var12 = 0; var12 < var11.field1816; ++var12) {
                  var13 = this.field1786[var12] + var2;
                  var14 = this.field1781[var12] + var4;
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var1[var17 + 1][var18 + 1] * var15 >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.field1829[var12] = this.field1829[var12] + var21 - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1816; ++var12) {
                  var13 = (-this.field1829[var12] << 16) / super.field1441;
                  if(var13 < var6) {
                     var14 = this.field1786[var12] + var2;
                     var15 = this.field1781[var12] + var4;
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var1[var18 + 1][var19 + 1] * var16 >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.field1829[var12] = this.field1829[var12] + (var22 - var3) * (var6 - var13) / var6;
                  }
               }
            }

            var11.field1802 = 0;
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("y")
   public void method2343(int var1) {
      int var2 = field1835[var1];
      int var3 = field1836[var1];

      for(int var4 = 0; var4 < this.field1816; ++var4) {
         int var5 = this.field1829[var4] * var3 - this.field1781[var4] * var2 >> 16;
         this.field1781[var4] = this.field1829[var4] * var2 + this.field1781[var4] * var3 >> 16;
         this.field1829[var4] = var5;
      }

      this.field1802 = 0;
   }

   @ObfuscatedName("v")
   public void method2344(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1816; ++var4) {
         this.field1786[var4] += var1;
         this.field1829[var4] += var2;
         this.field1781[var4] += var3;
      }

      this.field1802 = 0;
   }

   @ObfuscatedName("z")
   public void method2346(class102 var1, int var2, class102 var3, int var4, int[] var5) {
      if(var2 != -1) {
         if(var5 != null && var4 != -1) {
            class87 var6 = var1.field1752[var2];
            class87 var7 = var3.field1752[var4];
            class101 var8 = var6.field1530;
            field1819 = 0;
            field1828 = 0;
            field1794 = 0;
            byte var9 = 0;
            int var13 = var9 + 1;
            int var10 = var5[var9];

            int var11;
            int var12;
            for(var11 = 0; var11 < var6.field1525; ++var11) {
               for(var12 = var6.field1526[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 != var10 || var8.field1742[var12] == 0) {
                  this.method2400(var8.field1742[var12], var8.field1743[var12], var6.field1527[var11], var6.field1528[var11], var6.field1529[var11]);
               }
            }

            field1819 = 0;
            field1828 = 0;
            field1794 = 0;
            var9 = 0;
            var13 = var9 + 1;
            var10 = var5[var9];

            for(var11 = 0; var11 < var7.field1525; ++var11) {
               for(var12 = var7.field1526[var11]; var12 > var10; var10 = var5[var13++]) {
                  ;
               }

               if(var12 == var10 || var8.field1742[var12] == 0) {
                  this.method2400(var8.field1742[var12], var8.field1743[var12], var7.field1527[var11], var7.field1528[var11], var7.field1529[var11]);
               }
            }

            this.field1802 = 0;
         } else {
            this.method2337(var1, var2);
         }
      }
   }

   @ObfuscatedName("d")
   public final void method2347(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      field1791[0] = -1;
      if(this.field1802 != 2 && this.field1802 != 1) {
         this.method2335();
      }

      int var9 = class90.field1559;
      int var10 = class90.field1567;
      int var10000 = field1835[var1];
      var10000 = field1836[var1];
      int var13 = field1835[var2];
      int var14 = field1836[var2];
      int var15 = field1835[var3];
      int var16 = field1836[var3];
      int var17 = field1835[var4];
      int var18 = field1836[var4];
      int var19 = var6 * var17 + var7 * var18 >> 16;

      for(int var20 = 0; var20 < this.field1816; ++var20) {
         int var21 = this.field1786[var20];
         int var22 = this.field1829[var20];
         int var23 = this.field1781[var20];
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
         field1812[var20] = var23 - var19;
         field1825[var20] = var9 + var21 * class90.field1553 / var8;
         field1811[var20] = var10 + var24 * class90.field1553 / var8;
         if(this.field1795 > 0) {
            field1813[var20] = var21;
            field1801[var20] = var24;
            field1815[var20] = var23;
         }
      }

      try {
         this.method2349(false, false, 0);
      } catch (Exception var25) {
         ;
      }

   }

   @ObfuscatedName("az")
   void vmethod2348(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      field1791[0] = -1;
      if(this.field1802 != 1) {
         this.method2334();
      }

      int var10 = var8 * var5 - var6 * var4 >> 16;
      int var11 = var7 * var2 + var10 * var3 >> 16;
      int var12 = this.field1804 * var3 >> 16;
      int var13 = var11 + var12;
      if(var13 > 50 && var11 < 3500) {
         int var14 = var8 * var4 + var6 * var5 >> 16;
         int var15 = (var14 - this.field1804) * class90.field1553;
         if(var15 / var13 < class90.field1555) {
            int var16 = (var14 + this.field1804) * class90.field1553;
            if(var16 / var13 > class90.field1563) {
               int var17 = var7 * var3 - var10 * var2 >> 16;
               int var18 = this.field1804 * var2 >> 16;
               int var19 = (var17 + var18) * class90.field1553;
               if(var19 / var13 > class90.field1565) {
                  int var20 = var18 + (super.field1441 * var3 >> 16);
                  int var21 = (var17 - var20) * class90.field1553;
                  if(var21 / var13 < class90.field1558) {
                     int var22 = var12 + (super.field1441 * var2 >> 16);
                     boolean var23 = false;
                     boolean var24 = false;
                     if(var11 - var22 <= 50) {
                        var24 = true;
                     }

                     boolean var25 = var24 || this.field1795 > 0;
                     boolean var26 = false;
                     int var27;
                     int var28;
                     int var29;
                     if(var9 > 0 && field1830) {
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

                        var28 = field1831 - class90.field1559;
                        var29 = field1832 - class90.field1567;
                        if(var28 > var15 && var28 < var16 && var29 > var21 && var29 < var19) {
                           if(this.field1821) {
                              field1834[field1833++] = var9;
                           } else {
                              var26 = true;
                           }
                        }
                     }

                     var27 = class90.field1559;
                     var28 = class90.field1567;
                     var29 = 0;
                     int var30 = 0;
                     if(var1 != 0) {
                        var29 = field1835[var1];
                        var30 = field1836[var1];
                     }

                     for(int var31 = 0; var31 < this.field1816; ++var31) {
                        int var32 = this.field1786[var31];
                        int var33 = this.field1829[var31];
                        int var34 = this.field1781[var31];
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
                        field1812[var31] = var34 - var11;
                        if(var34 >= 50) {
                           field1825[var31] = var27 + var32 * class90.field1553 / var34;
                           field1811[var31] = var28 + var35 * class90.field1553 / var34;
                        } else {
                           field1825[var31] = -5000;
                           var23 = true;
                        }

                        if(var25) {
                           field1813[var31] = var32;
                           field1801[var31] = var35;
                           field1815[var31] = var34;
                        }
                     }

                     try {
                        this.method2349(var23, var26, var9);
                     } catch (Exception var36) {
                        ;
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("o")
   final void method2349(boolean var1, boolean var2, int var3) {
      if(this.field1805 < 1600) {
         int var4;
         for(var4 = 0; var4 < this.field1805; ++var4) {
            field1791[var4] = 0;
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
         for(var4 = 0; var4 < this.field1783; ++var4) {
            if(this.field1823[var4] != -2) {
               var5 = this.field1788[var4];
               var6 = this.field1806[var4];
               var7 = this.field1817[var4];
               var8 = field1825[var5];
               var9 = field1825[var6];
               var10 = field1825[var7];
               int var11;
               if(var1 && (var8 == -5000 || var9 == -5000 || var10 == -5000)) {
                  var11 = field1813[var5];
                  var12 = field1813[var6];
                  var13 = field1813[var7];
                  int var14 = field1801[var5];
                  var15 = field1801[var6];
                  int var16 = field1801[var7];
                  int var17 = field1815[var5];
                  int var18 = field1815[var6];
                  int var19 = field1815[var7];
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
                     field1775[var4] = true;
                     int var23 = (field1812[var5] + field1812[var6] + field1812[var7]) / 3 + this.field1780;
                     field1818[var23][field1791[var23]++] = var4;
                  }
               } else {
                  if(var2 && this.method2401(field1831, field1832, field1811[var5], field1811[var6], field1811[var7], var8, var9, var10)) {
                     field1834[field1833++] = var3;
                     var2 = false;
                  }

                  if((var8 - var9) * (field1811[var7] - field1811[var6]) - (field1811[var5] - field1811[var6]) * (var10 - var9) > 0) {
                     field1775[var4] = false;
                     if(var8 >= 0 && var9 >= 0 && var10 >= 0 && var8 <= class90.field1564 && var9 <= class90.field1564 && var10 <= class90.field1564) {
                        field1796[var4] = false;
                     } else {
                        field1796[var4] = true;
                     }

                     var11 = (field1812[var5] + field1812[var6] + field1812[var7]) / 3 + this.field1780;
                     field1818[var11][field1791[var11]++] = var4;
                  }
               }
            }
         }

         int[] var24;
         if(this.field1790 == null) {
            for(var4 = this.field1805 - 1; var4 >= 0; --var4) {
               var5 = field1791[var4];
               if(var5 > 0) {
                  var24 = field1818[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     this.method2350(var24[var7]);
                  }
               }
            }

         } else {
            for(var4 = 0; var4 < 12; ++var4) {
               field1785[var4] = 0;
               field1810[var4] = 0;
            }

            for(var4 = this.field1805 - 1; var4 >= 0; --var4) {
               var5 = field1791[var4];
               if(var5 > 0) {
                  var24 = field1818[var4];

                  for(var7 = 0; var7 < var5; ++var7) {
                     var8 = var24[var7];
                     byte var25 = this.field1790[var8];
                     var10 = field1785[var25]++;
                     field1820[var25][var10] = var8;
                     if(var25 < 10) {
                        field1810[var25] += var4;
                     } else if(var25 == 10) {
                        field1782[var10] = var4;
                     } else {
                        field1822[var10] = var4;
                     }
                  }
               }
            }

            var4 = 0;
            if(field1785[1] > 0 || field1785[2] > 0) {
               var4 = (field1810[1] + field1810[2]) / (field1785[1] + field1785[2]);
            }

            var5 = 0;
            if(field1785[3] > 0 || field1785[4] > 0) {
               var5 = (field1810[3] + field1810[4]) / (field1785[3] + field1785[4]);
            }

            var6 = 0;
            if(field1785[6] > 0 || field1785[8] > 0) {
               var6 = (field1810[6] + field1810[8]) / (field1785[6] + field1785[8]);
            }

            var8 = 0;
            var9 = field1785[10];
            int[] var26 = field1820[10];
            int[] var27 = field1782;
            if(var8 == var9) {
               var8 = 0;
               var9 = field1785[11];
               var26 = field1820[11];
               var27 = field1822;
            }

            if(var8 < var9) {
               var7 = var27[var8];
            } else {
               var7 = -1000;
            }

            for(var12 = 0; var12 < 10; ++var12) {
               while(var12 == 0 && var7 > var4) {
                  this.method2350(var26[var8++]);
                  if(var8 == var9 && var26 != field1820[11]) {
                     var8 = 0;
                     var9 = field1785[11];
                     var26 = field1820[11];
                     var27 = field1822;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 3 && var7 > var5) {
                  this.method2350(var26[var8++]);
                  if(var8 == var9 && var26 != field1820[11]) {
                     var8 = 0;
                     var9 = field1785[11];
                     var26 = field1820[11];
                     var27 = field1822;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               while(var12 == 5 && var7 > var6) {
                  this.method2350(var26[var8++]);
                  if(var8 == var9 && var26 != field1820[11]) {
                     var8 = 0;
                     var9 = field1785[11];
                     var26 = field1820[11];
                     var27 = field1822;
                  }

                  if(var8 < var9) {
                     var7 = var27[var8];
                  } else {
                     var7 = -1000;
                  }
               }

               var13 = field1785[var12];
               int[] var28 = field1820[var12];

               for(var15 = 0; var15 < var13; ++var15) {
                  this.method2350(var28[var15]);
               }
            }

            while(var7 != -1000) {
               this.method2350(var26[var8++]);
               if(var8 == var9 && var26 != field1820[11]) {
                  var8 = 0;
                  var26 = field1820[11];
                  var9 = field1785[11];
                  var27 = field1822;
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
   final void method2350(int var1) {
      if(field1775[var1]) {
         this.method2404(var1);
      } else {
         int var2 = this.field1788[var1];
         int var3 = this.field1806[var1];
         int var4 = this.field1817[var1];
         class90.field1560 = field1796[var1];
         if(this.field1784 == null) {
            class90.field1550 = 0;
         } else {
            class90.field1550 = this.field1784[var1] & 255;
         }

         if(this.field1793 != null && this.field1793[var1] != -1) {
            int var5;
            int var6;
            int var7;
            if(this.field1792 != null && this.field1792[var1] != -1) {
               int var8 = this.field1792[var1] & 255;
               var5 = this.field1789[var8];
               var6 = this.field1797[var8];
               var7 = this.field1798[var8];
            } else {
               var5 = var2;
               var6 = var3;
               var7 = var4;
            }

            if(this.field1823[var1] == -1) {
               class90.method2136(field1811[var2], field1811[var3], field1811[var4], field1825[var2], field1825[var3], field1825[var4], this.field1787[var1], this.field1787[var1], this.field1787[var1], field1813[var5], field1813[var6], field1813[var7], field1801[var5], field1801[var6], field1801[var7], field1815[var5], field1815[var6], field1815[var7], this.field1793[var1]);
            } else {
               class90.method2136(field1811[var2], field1811[var3], field1811[var4], field1825[var2], field1825[var3], field1825[var4], this.field1787[var1], this.field1800[var1], this.field1823[var1], field1813[var5], field1813[var6], field1813[var7], field1801[var5], field1801[var6], field1801[var7], field1815[var5], field1815[var6], field1815[var7], this.field1793[var1]);
            }
         } else if(this.field1823[var1] == -1) {
            class90.method2114(field1811[var2], field1811[var3], field1811[var4], field1825[var2], field1825[var3], field1825[var4], field1837[this.field1787[var1]]);
         } else {
            class90.method2112(field1811[var2], field1811[var3], field1811[var4], field1825[var2], field1825[var3], field1825[var4], this.field1787[var1], this.field1800[var1], this.field1823[var1]);
         }

      }
   }

   static {
      field1835 = class90.field1571;
      field1836 = class90.field1573;
      field1837 = class90.field1568;
      field1838 = class90.field1561;
   }

   @ObfuscatedName("q")
   public void method2355(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1816; ++var4) {
         this.field1786[var4] = this.field1786[var4] * var1 / 128;
         this.field1829[var4] = this.field1829[var4] * var2 / 128;
         this.field1781[var4] = this.field1781[var4] * var3 / 128;
      }

      this.field1802 = 0;
   }

   @ObfuscatedName("m")
   public class104 method2366(boolean var1) {
      if(!var1 && field1776.length < this.field1783) {
         field1776 = new byte[this.field1783 + 100];
      }

      return this.method2333(var1, field1827, field1776);
   }

   @ObfuscatedName("x")
   public final void method2379(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      field1791[0] = -1;
      if(this.field1802 != 2 && this.field1802 != 1) {
         this.method2335();
      }

      int var8 = class90.field1559;
      int var9 = class90.field1567;
      int var10000 = field1835[var1];
      var10000 = field1836[var1];
      int var12 = field1835[var2];
      int var13 = field1836[var2];
      int var14 = field1835[var3];
      int var15 = field1836[var3];
      int var16 = field1835[var4];
      int var17 = field1836[var4];
      int var18 = var6 * var16 + var7 * var17 >> 16;

      for(int var19 = 0; var19 < this.field1816; ++var19) {
         int var20 = this.field1786[var19];
         int var21 = this.field1829[var19];
         int var22 = this.field1781[var19];
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
         field1812[var19] = var22 - var18;
         field1825[var19] = var8 + var20 * class90.field1553 / var22;
         field1811[var19] = var9 + var23 * class90.field1553 / var22;
         if(this.field1795 > 0) {
            field1813[var19] = var20;
            field1801[var19] = var23;
            field1815[var19] = var22;
         }
      }

      try {
         this.method2349(false, false, 0);
      } catch (Exception var24) {
         ;
      }

   }

   @ObfuscatedName("l")
   public class104 method2380(boolean var1) {
      if(!var1 && field1814.length < this.field1783) {
         field1814 = new byte[this.field1783 + 100];
      }

      return this.method2333(var1, field1777, field1814);
   }

   class104() {
   }

   @ObfuscatedName("n")
   public void method2390() {
      for(int var1 = 0; var1 < this.field1816; ++var1) {
         int var2 = this.field1781[var1];
         this.field1781[var1] = this.field1786[var1];
         this.field1786[var1] = -var2;
      }

      this.field1802 = 0;
   }

   @ObfuscatedName("p")
   void method2400(int var1, int[] var2, int var3, int var4, int var5) {
      int var6 = var2.length;
      int var7;
      int var8;
      int var11;
      int var12;
      if(var1 == 0) {
         var7 = 0;
         field1819 = 0;
         field1828 = 0;
         field1794 = 0;

         for(var8 = 0; var8 < var6; ++var8) {
            int var18 = var2[var8];
            if(var18 < this.field1799.length) {
               int[] var19 = this.field1799[var18];

               for(var11 = 0; var11 < var19.length; ++var11) {
                  var12 = var19[var11];
                  field1819 += this.field1786[var12];
                  field1828 += this.field1829[var12];
                  field1794 += this.field1781[var12];
                  ++var7;
               }
            }
         }

         if(var7 > 0) {
            field1819 = field1819 / var7 + var3;
            field1828 = field1828 / var7 + var4;
            field1794 = field1794 / var7 + var5;
         } else {
            field1819 = var3;
            field1828 = var4;
            field1794 = var5;
         }

      } else {
         int[] var9;
         int var10;
         if(var1 == 1) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1799.length) {
                  var9 = this.field1799[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.field1786[var11] += var3;
                     this.field1829[var11] += var4;
                     this.field1781[var11] += var5;
                  }
               }
            }

         } else if(var1 == 2) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1799.length) {
                  var9 = this.field1799[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.field1786[var11] -= field1819;
                     this.field1829[var11] -= field1828;
                     this.field1781[var11] -= field1794;
                     var12 = (var3 & 255) * 8;
                     int var13 = (var4 & 255) * 8;
                     int var14 = (var5 & 255) * 8;
                     int var15;
                     int var16;
                     int var17;
                     if(var14 != 0) {
                        var15 = field1835[var14];
                        var16 = field1836[var14];
                        var17 = this.field1829[var11] * var15 + this.field1786[var11] * var16 >> 16;
                        this.field1829[var11] = this.field1829[var11] * var16 - this.field1786[var11] * var15 >> 16;
                        this.field1786[var11] = var17;
                     }

                     if(var12 != 0) {
                        var15 = field1835[var12];
                        var16 = field1836[var12];
                        var17 = this.field1829[var11] * var16 - this.field1781[var11] * var15 >> 16;
                        this.field1781[var11] = this.field1829[var11] * var15 + this.field1781[var11] * var16 >> 16;
                        this.field1829[var11] = var17;
                     }

                     if(var13 != 0) {
                        var15 = field1835[var13];
                        var16 = field1836[var13];
                        var17 = this.field1781[var11] * var15 + this.field1786[var11] * var16 >> 16;
                        this.field1781[var11] = this.field1781[var11] * var16 - this.field1786[var11] * var15 >> 16;
                        this.field1786[var11] = var17;
                     }

                     this.field1786[var11] += field1819;
                     this.field1829[var11] += field1828;
                     this.field1781[var11] += field1794;
                  }
               }
            }

         } else if(var1 == 3) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var2[var7];
               if(var8 < this.field1799.length) {
                  var9 = this.field1799[var8];

                  for(var10 = 0; var10 < var9.length; ++var10) {
                     var11 = var9[var10];
                     this.field1786[var11] -= field1819;
                     this.field1829[var11] -= field1828;
                     this.field1781[var11] -= field1794;
                     this.field1786[var11] = this.field1786[var11] * var3 / 128;
                     this.field1829[var11] = this.field1829[var11] * var4 / 128;
                     this.field1781[var11] = this.field1781[var11] * var5 / 128;
                     this.field1786[var11] += field1819;
                     this.field1829[var11] += field1828;
                     this.field1781[var11] += field1794;
                  }
               }
            }

         } else if(var1 == 5) {
            if(this.field1778 != null && this.field1784 != null) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var2[var7];
                  if(var8 < this.field1778.length) {
                     var9 = this.field1778[var8];

                     for(var10 = 0; var10 < var9.length; ++var10) {
                        var11 = var9[var10];
                        var12 = (this.field1784[var11] & 255) + var3 * 8;
                        if(var12 < 0) {
                           var12 = 0;
                        } else if(var12 > 255) {
                           var12 = 255;
                        }

                        this.field1784[var11] = (byte)var12;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("aa")
   final boolean method2401(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      return var2 < var3 && var2 < var4 && var2 < var5?false:(var2 > var3 && var2 > var4 && var2 > var5?false:(var1 < var6 && var1 < var7 && var1 < var8?false:var1 <= var6 || var1 <= var7 || var1 <= var8));
   }

   @ObfuscatedName("b")
   final void method2404(int var1) {
      int var2 = class90.field1559;
      int var3 = class90.field1567;
      int var4 = 0;
      int var5 = this.field1788[var1];
      int var6 = this.field1806[var1];
      int var7 = this.field1817[var1];
      int var8 = field1815[var5];
      int var9 = field1815[var6];
      int var10 = field1815[var7];
      if(this.field1784 == null) {
         class90.field1550 = 0;
      } else {
         class90.field1550 = this.field1784[var1] & 255;
      }

      int var11;
      int var12;
      int var13;
      int var14;
      if(var8 >= 50) {
         field1824[var4] = field1825[var5];
         field1809[var4] = field1811[var5];
         field1808[var4++] = this.field1787[var1];
      } else {
         var11 = field1813[var5];
         var12 = field1801[var5];
         var13 = this.field1787[var1];
         if(var10 >= 50) {
            var14 = (50 - var8) * field1838[var10 - var8];
            field1824[var4] = var2 + (var11 + ((field1813[var7] - var11) * var14 >> 16)) * class90.field1553 / 50;
            field1809[var4] = var3 + (var12 + ((field1801[var7] - var12) * var14 >> 16)) * class90.field1553 / 50;
            field1808[var4++] = var13 + ((this.field1823[var1] - var13) * var14 >> 16);
         }

         if(var9 >= 50) {
            var14 = (50 - var8) * field1838[var9 - var8];
            field1824[var4] = var2 + (var11 + ((field1813[var6] - var11) * var14 >> 16)) * class90.field1553 / 50;
            field1809[var4] = var3 + (var12 + ((field1801[var6] - var12) * var14 >> 16)) * class90.field1553 / 50;
            field1808[var4++] = var13 + ((this.field1800[var1] - var13) * var14 >> 16);
         }
      }

      if(var9 >= 50) {
         field1824[var4] = field1825[var6];
         field1809[var4] = field1811[var6];
         field1808[var4++] = this.field1800[var1];
      } else {
         var11 = field1813[var6];
         var12 = field1801[var6];
         var13 = this.field1800[var1];
         if(var8 >= 50) {
            var14 = (50 - var9) * field1838[var8 - var9];
            field1824[var4] = var2 + (var11 + ((field1813[var5] - var11) * var14 >> 16)) * class90.field1553 / 50;
            field1809[var4] = var3 + (var12 + ((field1801[var5] - var12) * var14 >> 16)) * class90.field1553 / 50;
            field1808[var4++] = var13 + ((this.field1787[var1] - var13) * var14 >> 16);
         }

         if(var10 >= 50) {
            var14 = (50 - var9) * field1838[var10 - var9];
            field1824[var4] = var2 + (var11 + ((field1813[var7] - var11) * var14 >> 16)) * class90.field1553 / 50;
            field1809[var4] = var3 + (var12 + ((field1801[var7] - var12) * var14 >> 16)) * class90.field1553 / 50;
            field1808[var4++] = var13 + ((this.field1823[var1] - var13) * var14 >> 16);
         }
      }

      if(var10 >= 50) {
         field1824[var4] = field1825[var7];
         field1809[var4] = field1811[var7];
         field1808[var4++] = this.field1823[var1];
      } else {
         var11 = field1813[var7];
         var12 = field1801[var7];
         var13 = this.field1823[var1];
         if(var9 >= 50) {
            var14 = (50 - var10) * field1838[var9 - var10];
            field1824[var4] = var2 + (var11 + ((field1813[var6] - var11) * var14 >> 16)) * class90.field1553 / 50;
            field1809[var4] = var3 + (var12 + ((field1801[var6] - var12) * var14 >> 16)) * class90.field1553 / 50;
            field1808[var4++] = var13 + ((this.field1800[var1] - var13) * var14 >> 16);
         }

         if(var8 >= 50) {
            var14 = (50 - var10) * field1838[var8 - var10];
            field1824[var4] = var2 + (var11 + ((field1813[var5] - var11) * var14 >> 16)) * class90.field1553 / 50;
            field1809[var4] = var3 + (var12 + ((field1801[var5] - var12) * var14 >> 16)) * class90.field1553 / 50;
            field1808[var4++] = var13 + ((this.field1787[var1] - var13) * var14 >> 16);
         }
      }

      var11 = field1824[0];
      var12 = field1824[1];
      var13 = field1824[2];
      var14 = field1809[0];
      int var15 = field1809[1];
      int var16 = field1809[2];
      class90.field1560 = false;
      int var17;
      int var18;
      int var19;
      int var20;
      if(var4 == 3) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class90.field1564 || var12 > class90.field1564 || var13 > class90.field1564) {
            class90.field1560 = true;
         }

         if(this.field1793 != null && this.field1793[var1] != -1) {
            if(this.field1792 != null && this.field1792[var1] != -1) {
               var20 = this.field1792[var1] & 255;
               var17 = this.field1789[var20];
               var18 = this.field1797[var20];
               var19 = this.field1798[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            if(this.field1823[var1] == -1) {
               class90.method2136(var14, var15, var16, var11, var12, var13, this.field1787[var1], this.field1787[var1], this.field1787[var1], field1813[var17], field1813[var18], field1813[var19], field1801[var17], field1801[var18], field1801[var19], field1815[var17], field1815[var18], field1815[var19], this.field1793[var1]);
            } else {
               class90.method2136(var14, var15, var16, var11, var12, var13, field1808[0], field1808[1], field1808[2], field1813[var17], field1813[var18], field1813[var19], field1801[var17], field1801[var18], field1801[var19], field1815[var17], field1815[var18], field1815[var19], this.field1793[var1]);
            }
         } else if(this.field1823[var1] == -1) {
            class90.method2114(var14, var15, var16, var11, var12, var13, field1837[this.field1787[var1]]);
         } else {
            class90.method2112(var14, var15, var16, var11, var12, var13, field1808[0], field1808[1], field1808[2]);
         }
      }

      if(var4 == 4) {
         if(var11 < 0 || var12 < 0 || var13 < 0 || var11 > class90.field1564 || var12 > class90.field1564 || var13 > class90.field1564 || field1824[3] < 0 || field1824[3] > class90.field1564) {
            class90.field1560 = true;
         }

         if(this.field1793 != null && this.field1793[var1] != -1) {
            if(this.field1792 != null && this.field1792[var1] != -1) {
               var20 = this.field1792[var1] & 255;
               var17 = this.field1789[var20];
               var18 = this.field1797[var20];
               var19 = this.field1798[var20];
            } else {
               var17 = var5;
               var18 = var6;
               var19 = var7;
            }

            short var21 = this.field1793[var1];
            if(this.field1823[var1] == -1) {
               class90.method2136(var14, var15, var16, var11, var12, var13, this.field1787[var1], this.field1787[var1], this.field1787[var1], field1813[var17], field1813[var18], field1813[var19], field1801[var17], field1801[var18], field1801[var19], field1815[var17], field1815[var18], field1815[var19], var21);
               class90.method2136(var14, var16, field1809[3], var11, var13, field1824[3], this.field1787[var1], this.field1787[var1], this.field1787[var1], field1813[var17], field1813[var18], field1813[var19], field1801[var17], field1801[var18], field1801[var19], field1815[var17], field1815[var18], field1815[var19], var21);
            } else {
               class90.method2136(var14, var15, var16, var11, var12, var13, field1808[0], field1808[1], field1808[2], field1813[var17], field1813[var18], field1813[var19], field1801[var17], field1801[var18], field1801[var19], field1815[var17], field1815[var18], field1815[var19], var21);
               class90.method2136(var14, var16, field1809[3], var11, var13, field1824[3], field1808[0], field1808[2], field1808[3], field1813[var17], field1813[var18], field1813[var19], field1801[var17], field1801[var18], field1801[var19], field1815[var17], field1815[var18], field1815[var19], var21);
            }
         } else if(this.field1823[var1] == -1) {
            var17 = field1837[this.field1787[var1]];
            class90.method2114(var14, var15, var16, var11, var12, var13, var17);
            class90.method2114(var14, var16, field1809[3], var11, var13, field1824[3], var17);
         } else {
            class90.method2112(var14, var15, var16, var11, var12, var13, field1808[0], field1808[1], field1808[2]);
            class90.method2112(var14, var16, field1809[3], var11, var13, field1824[3], field1808[0], field1808[2], field1808[3]);
         }
      }

   }
}
