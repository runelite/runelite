import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
@Implements("ModelData")
public class class103 extends class88 {
   @ObfuscatedName("x")
   int field1763;
   @ObfuscatedName("l")
   int[] field1764;
   @ObfuscatedName("c")
   int[] field1765;
   @ObfuscatedName("h")
   int[] field1766;
   @ObfuscatedName("ai")
   static int[] field1767 = new int[10000];
   @ObfuscatedName("a")
   int[] field1768;
   @ObfuscatedName("d")
   short[] field1769;
   @ObfuscatedName("r")
   int field1770 = 0;
   @ObfuscatedName("o")
   byte[] field1771;
   @ObfuscatedName("p")
   byte[] field1772;
   @ObfuscatedName("ad")
   boolean field1773 = false;
   @ObfuscatedName("aw")
   public short field1774;
   @ObfuscatedName("ar")
   static int field1775 = 0;
   @ObfuscatedName("j")
   short[] field1776;
   @ObfuscatedName("w")
   byte field1777 = 0;
   @ObfuscatedName("q")
   byte[] field1778;
   @ObfuscatedName("ab")
   static int[] field1779;
   @ObfuscatedName("an")
   public short field1780;
   @ObfuscatedName("f")
   byte[] field1781;
   @ObfuscatedName("y")
   short[] field1782;
   @ObfuscatedName("m")
   short[] field1783;
   @ObfuscatedName("v")
   short[] field1784;
   @ObfuscatedName("k")
   short[] field1785;
   @ObfuscatedName("n")
   short[] field1786;
   @ObfuscatedName("z")
   short[] field1787;
   @ObfuscatedName("s")
   short[] field1788;
   @ObfuscatedName("ah")
   byte[] field1789;
   @ObfuscatedName("ak")
   int[] field1790;
   @ObfuscatedName("aq")
   int field1791;
   @ObfuscatedName("ae")
   int[][] field1792;
   @ObfuscatedName("ao")
   int[][] field1793;
   @ObfuscatedName("as")
   int[] field1794;
   @ObfuscatedName("b")
   int[] field1795;
   @ObfuscatedName("ap")
   class99[] field1796;
   @ObfuscatedName("av")
   class87[] field1797;
   @ObfuscatedName("u")
   int[] field1798;
   @ObfuscatedName("g")
   short[] field1799;
   @ObfuscatedName("aa")
   int field1800;
   @ObfuscatedName("at")
   int field1801;
   @ObfuscatedName("ag")
   int field1802;
   @ObfuscatedName("i")
   byte[] field1803;
   @ObfuscatedName("af")
   int field1804;
   @ObfuscatedName("ax")
   static int[] field1805 = new int[10000];
   @ObfuscatedName("e")
   int field1806 = 0;
   @ObfuscatedName("al")
   class99[] field1807;
   @ObfuscatedName("t")
   short[] field1808;
   @ObfuscatedName("aj")
   static int[] field1809;

   @ObfuscatedName("p")
   public void method2287() {
      for(int var1 = 0; var1 < this.field1806; ++var1) {
         this.field1764[var1] = -this.field1764[var1];
         this.field1766[var1] = -this.field1766[var1];
      }

      this.method2305();
   }

   public class103(class103[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      boolean var8 = false;
      this.field1806 = 0;
      this.field1770 = 0;
      this.field1763 = 0;
      this.field1777 = -1;

      int var9;
      class103 var10;
      for(var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if(var10 != null) {
            this.field1806 += var10.field1806;
            this.field1770 += var10.field1770;
            this.field1763 += var10.field1763;
            if(var10.field1772 != null) {
               var4 = true;
            } else {
               if(this.field1777 == -1) {
                  this.field1777 = var10.field1777;
               }

               if(this.field1777 != var10.field1777) {
                  var4 = true;
               }
            }

            var3 |= var10.field1771 != null;
            var5 |= var10.field1803 != null;
            var6 |= var10.field1794 != null;
            var7 |= var10.field1776 != null;
            var8 |= var10.field1778 != null;
         }
      }

      this.field1764 = new int[this.field1806];
      this.field1765 = new int[this.field1806];
      this.field1766 = new int[this.field1806];
      this.field1790 = new int[this.field1806];
      this.field1768 = new int[this.field1770];
      this.field1795 = new int[this.field1770];
      this.field1798 = new int[this.field1770];
      if(var3) {
         this.field1771 = new byte[this.field1770];
      }

      if(var4) {
         this.field1772 = new byte[this.field1770];
      }

      if(var5) {
         this.field1803 = new byte[this.field1770];
      }

      if(var6) {
         this.field1794 = new int[this.field1770];
      }

      if(var7) {
         this.field1776 = new short[this.field1770];
      }

      if(var8) {
         this.field1778 = new byte[this.field1770];
      }

      this.field1799 = new short[this.field1770];
      if(this.field1763 > 0) {
         this.field1781 = new byte[this.field1763];
         this.field1808 = new short[this.field1763];
         this.field1787 = new short[this.field1763];
         this.field1782 = new short[this.field1763];
         this.field1783 = new short[this.field1763];
         this.field1784 = new short[this.field1763];
         this.field1785 = new short[this.field1763];
         this.field1786 = new short[this.field1763];
         this.field1789 = new byte[this.field1763];
         this.field1769 = new short[this.field1763];
         this.field1788 = new short[this.field1763];
      }

      this.field1806 = 0;
      this.field1770 = 0;
      this.field1763 = 0;

      for(var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if(var10 != null) {
            int var11;
            for(var11 = 0; var11 < var10.field1770; ++var11) {
               if(var3 && var10.field1771 != null) {
                  this.field1771[this.field1770] = var10.field1771[var11];
               }

               if(var4) {
                  if(var10.field1772 != null) {
                     this.field1772[this.field1770] = var10.field1772[var11];
                  } else {
                     this.field1772[this.field1770] = var10.field1777;
                  }
               }

               if(var5 && var10.field1803 != null) {
                  this.field1803[this.field1770] = var10.field1803[var11];
               }

               if(var6 && var10.field1794 != null) {
                  this.field1794[this.field1770] = var10.field1794[var11];
               }

               if(var7) {
                  if(var10.field1776 != null) {
                     this.field1776[this.field1770] = var10.field1776[var11];
                  } else {
                     this.field1776[this.field1770] = -1;
                  }
               }

               if(var8) {
                  if(var10.field1778 != null && var10.field1778[var11] != -1) {
                     this.field1778[this.field1770] = (byte)(var10.field1778[var11] + this.field1763);
                  } else {
                     this.field1778[this.field1770] = -1;
                  }
               }

               this.field1799[this.field1770] = var10.field1799[var11];
               this.field1768[this.field1770] = this.method2291(var10, var10.field1768[var11]);
               this.field1795[this.field1770] = this.method2291(var10, var10.field1795[var11]);
               this.field1798[this.field1770] = this.method2291(var10, var10.field1798[var11]);
               ++this.field1770;
            }

            for(var11 = 0; var11 < var10.field1763; ++var11) {
               byte var12 = this.field1781[this.field1763] = var10.field1781[var11];
               if(var12 == 0) {
                  this.field1808[this.field1763] = (short)this.method2291(var10, var10.field1808[var11]);
                  this.field1787[this.field1763] = (short)this.method2291(var10, var10.field1787[var11]);
                  this.field1782[this.field1763] = (short)this.method2291(var10, var10.field1782[var11]);
               }

               if(var12 >= 1 && var12 <= 3) {
                  this.field1808[this.field1763] = var10.field1808[var11];
                  this.field1787[this.field1763] = var10.field1787[var11];
                  this.field1782[this.field1763] = var10.field1782[var11];
                  this.field1783[this.field1763] = var10.field1783[var11];
                  this.field1784[this.field1763] = var10.field1784[var11];
                  this.field1785[this.field1763] = var10.field1785[var11];
                  this.field1786[this.field1763] = var10.field1786[var11];
                  this.field1789[this.field1763] = var10.field1789[var11];
                  this.field1769[this.field1763] = var10.field1769[var11];
               }

               if(var12 == 2) {
                  this.field1788[this.field1763] = var10.field1788[var11];
               }

               ++this.field1763;
            }
         }
      }

   }

   class103(byte[] var1) {
      if(var1[var1.length - 1] == -1 && var1[var1.length - 2] == -1) {
         this.method2288(var1);
      } else {
         this.method2326(var1);
      }

   }

   @ObfuscatedName("l")
   void method2288(byte[] var1) {
      class122 var2 = new class122(var1);
      class122 var3 = new class122(var1);
      class122 var4 = new class122(var1);
      class122 var5 = new class122(var1);
      class122 var6 = new class122(var1);
      class122 var7 = new class122(var1);
      class122 var8 = new class122(var1);
      var2.field2061 = var1.length - 23;
      int var9 = var2.method2612();
      int var10 = var2.method2612();
      int var11 = var2.method2610();
      int var12 = var2.method2610();
      int var13 = var2.method2610();
      int var14 = var2.method2610();
      int var15 = var2.method2610();
      int var16 = var2.method2610();
      int var17 = var2.method2610();
      int var18 = var2.method2612();
      int var19 = var2.method2612();
      int var20 = var2.method2612();
      int var21 = var2.method2612();
      int var22 = var2.method2612();
      int var23 = 0;
      int var24 = 0;
      int var25 = 0;
      int var26;
      if(var11 > 0) {
         this.field1781 = new byte[var11];
         var2.field2061 = 0;

         for(var26 = 0; var26 < var11; ++var26) {
            byte var27 = this.field1781[var26] = var2.method2611();
            if(var27 == 0) {
               ++var23;
            }

            if(var27 >= 1 && var27 <= 3) {
               ++var24;
            }

            if(var27 == 2) {
               ++var25;
            }
         }
      }

      var26 = var11 + var9;
      int var28 = var26;
      if(var12 == 1) {
         var26 += var10;
      }

      int var29 = var26;
      var26 += var10;
      int var30 = var26;
      if(var13 == 255) {
         var26 += var10;
      }

      int var31 = var26;
      if(var15 == 1) {
         var26 += var10;
      }

      int var32 = var26;
      if(var17 == 1) {
         var26 += var9;
      }

      int var33 = var26;
      if(var14 == 1) {
         var26 += var10;
      }

      int var34 = var26;
      var26 += var21;
      int var35 = var26;
      if(var16 == 1) {
         var26 += var10 * 2;
      }

      int var36 = var26;
      var26 += var22;
      int var37 = var26;
      var26 += var10 * 2;
      int var38 = var26;
      var26 += var18;
      int var39 = var26;
      var26 += var19;
      int var40 = var26;
      var26 += var20;
      int var41 = var26;
      var26 += var23 * 6;
      int var42 = var26;
      var26 += var24 * 6;
      int var43 = var26;
      var26 += var24 * 6;
      int var44 = var26;
      var26 += var24 * 2;
      int var45 = var26;
      var26 += var24;
      int var46 = var26;
      var26 += var24 * 2 + var25 * 2;
      this.field1806 = var9;
      this.field1770 = var10;
      this.field1763 = var11;
      this.field1764 = new int[var9];
      this.field1765 = new int[var9];
      this.field1766 = new int[var9];
      this.field1768 = new int[var10];
      this.field1795 = new int[var10];
      this.field1798 = new int[var10];
      if(var17 == 1) {
         this.field1790 = new int[var9];
      }

      if(var12 == 1) {
         this.field1771 = new byte[var10];
      }

      if(var13 == 255) {
         this.field1772 = new byte[var10];
      } else {
         this.field1777 = (byte)var13;
      }

      if(var14 == 1) {
         this.field1803 = new byte[var10];
      }

      if(var15 == 1) {
         this.field1794 = new int[var10];
      }

      if(var16 == 1) {
         this.field1776 = new short[var10];
      }

      if(var16 == 1 && var11 > 0) {
         this.field1778 = new byte[var10];
      }

      this.field1799 = new short[var10];
      if(var11 > 0) {
         this.field1808 = new short[var11];
         this.field1787 = new short[var11];
         this.field1782 = new short[var11];
         if(var24 > 0) {
            this.field1783 = new short[var24];
            this.field1784 = new short[var24];
            this.field1785 = new short[var24];
            this.field1786 = new short[var24];
            this.field1789 = new byte[var24];
            this.field1769 = new short[var24];
         }

         if(var25 > 0) {
            this.field1788 = new short[var25];
         }
      }

      var2.field2061 = var11;
      var3.field2061 = var38;
      var4.field2061 = var39;
      var5.field2061 = var40;
      var6.field2061 = var32;
      int var48 = 0;
      int var49 = 0;
      int var50 = 0;

      int var51;
      int var52;
      int var53;
      int var54;
      int var55;
      for(var51 = 0; var51 < var9; ++var51) {
         var52 = var2.method2610();
         var53 = 0;
         if((var52 & 1) != 0) {
            var53 = var3.method2702();
         }

         var54 = 0;
         if((var52 & 2) != 0) {
            var54 = var4.method2702();
         }

         var55 = 0;
         if((var52 & 4) != 0) {
            var55 = var5.method2702();
         }

         this.field1764[var51] = var48 + var53;
         this.field1765[var51] = var49 + var54;
         this.field1766[var51] = var50 + var55;
         var48 = this.field1764[var51];
         var49 = this.field1765[var51];
         var50 = this.field1766[var51];
         if(var17 == 1) {
            this.field1790[var51] = var6.method2610();
         }
      }

      var2.field2061 = var37;
      var3.field2061 = var28;
      var4.field2061 = var30;
      var5.field2061 = var33;
      var6.field2061 = var31;
      var7.field2061 = var35;
      var8.field2061 = var36;

      for(var51 = 0; var51 < var10; ++var51) {
         this.field1799[var51] = (short)var2.method2612();
         if(var12 == 1) {
            this.field1771[var51] = var3.method2611();
         }

         if(var13 == 255) {
            this.field1772[var51] = var4.method2611();
         }

         if(var14 == 1) {
            this.field1803[var51] = var5.method2611();
         }

         if(var15 == 1) {
            this.field1794[var51] = var6.method2610();
         }

         if(var16 == 1) {
            this.field1776[var51] = (short)(var7.method2612() - 1);
         }

         if(this.field1778 != null && this.field1776[var51] != -1) {
            this.field1778[var51] = (byte)(var8.method2610() - 1);
         }
      }

      var2.field2061 = var34;
      var3.field2061 = var29;
      var51 = 0;
      var52 = 0;
      var53 = 0;
      var54 = 0;

      int var56;
      for(var55 = 0; var55 < var10; ++var55) {
         var56 = var3.method2610();
         if(var56 == 1) {
            var51 = var2.method2702() + var54;
            var52 = var2.method2702() + var51;
            var53 = var2.method2702() + var52;
            var54 = var53;
            this.field1768[var55] = var51;
            this.field1795[var55] = var52;
            this.field1798[var55] = var53;
         }

         if(var56 == 2) {
            var52 = var53;
            var53 = var2.method2702() + var54;
            var54 = var53;
            this.field1768[var55] = var51;
            this.field1795[var55] = var52;
            this.field1798[var55] = var53;
         }

         if(var56 == 3) {
            var51 = var53;
            var53 = var2.method2702() + var54;
            var54 = var53;
            this.field1768[var55] = var51;
            this.field1795[var55] = var52;
            this.field1798[var55] = var53;
         }

         if(var56 == 4) {
            int var57 = var51;
            var51 = var52;
            var52 = var57;
            var53 = var2.method2702() + var54;
            var54 = var53;
            this.field1768[var55] = var51;
            this.field1795[var55] = var57;
            this.field1798[var55] = var53;
         }
      }

      var2.field2061 = var41;
      var3.field2061 = var42;
      var4.field2061 = var43;
      var5.field2061 = var44;
      var6.field2061 = var45;
      var7.field2061 = var46;

      for(var55 = 0; var55 < var11; ++var55) {
         var56 = this.field1781[var55] & 255;
         if(var56 == 0) {
            this.field1808[var55] = (short)var2.method2612();
            this.field1787[var55] = (short)var2.method2612();
            this.field1782[var55] = (short)var2.method2612();
         }

         if(var56 == 1) {
            this.field1808[var55] = (short)var3.method2612();
            this.field1787[var55] = (short)var3.method2612();
            this.field1782[var55] = (short)var3.method2612();
            this.field1783[var55] = (short)var4.method2612();
            this.field1784[var55] = (short)var4.method2612();
            this.field1785[var55] = (short)var4.method2612();
            this.field1786[var55] = (short)var5.method2612();
            this.field1789[var55] = var6.method2611();
            this.field1769[var55] = (short)var7.method2612();
         }

         if(var56 == 2) {
            this.field1808[var55] = (short)var3.method2612();
            this.field1787[var55] = (short)var3.method2612();
            this.field1782[var55] = (short)var3.method2612();
            this.field1783[var55] = (short)var4.method2612();
            this.field1784[var55] = (short)var4.method2612();
            this.field1785[var55] = (short)var4.method2612();
            this.field1786[var55] = (short)var5.method2612();
            this.field1789[var55] = var6.method2611();
            this.field1769[var55] = (short)var7.method2612();
            this.field1788[var55] = (short)var7.method2612();
         }

         if(var56 == 3) {
            this.field1808[var55] = (short)var3.method2612();
            this.field1787[var55] = (short)var3.method2612();
            this.field1782[var55] = (short)var3.method2612();
            this.field1783[var55] = (short)var4.method2612();
            this.field1784[var55] = (short)var4.method2612();
            this.field1785[var55] = (short)var4.method2612();
            this.field1786[var55] = (short)var5.method2612();
            this.field1789[var55] = var6.method2611();
            this.field1769[var55] = (short)var7.method2612();
         }
      }

      var2.field2061 = var26;
      var55 = var2.method2610();
      if(var55 != 0) {
         new class93();
         var2.method2612();
         var2.method2612();
         var2.method2612();
         var2.method2614();
      }

   }

   @ObfuscatedName("r")
   final int method2291(class103 var1, int var2) {
      int var3 = -1;
      int var4 = var1.field1764[var2];
      int var5 = var1.field1765[var2];
      int var6 = var1.field1766[var2];

      for(int var7 = 0; var7 < this.field1806; ++var7) {
         if(var4 == this.field1764[var7] && var5 == this.field1765[var7] && var6 == this.field1766[var7]) {
            var3 = var7;
            break;
         }
      }

      if(var3 == -1) {
         this.field1764[this.field1806] = var4;
         this.field1765[this.field1806] = var5;
         this.field1766[this.field1806] = var6;
         if(var1.field1790 != null) {
            this.field1790[this.field1806] = var1.field1790[var2];
         }

         var3 = this.field1806++;
      }

      return var3;
   }

   @ObfuscatedSignature(
      signature = "(Lclass103;ZZZZ)V",
      garbageValue = "1"
   )
   public class103(class103 var1, boolean var2, boolean var3, boolean var4, boolean var5) {
      this.field1806 = var1.field1806;
      this.field1770 = var1.field1770;
      this.field1763 = var1.field1763;
      int var6;
      if(var2) {
         this.field1764 = var1.field1764;
         this.field1765 = var1.field1765;
         this.field1766 = var1.field1766;
      } else {
         this.field1764 = new int[this.field1806];
         this.field1765 = new int[this.field1806];
         this.field1766 = new int[this.field1806];

         for(var6 = 0; var6 < this.field1806; ++var6) {
            this.field1764[var6] = var1.field1764[var6];
            this.field1765[var6] = var1.field1765[var6];
            this.field1766[var6] = var1.field1766[var6];
         }
      }

      if(var3) {
         this.field1799 = var1.field1799;
      } else {
         this.field1799 = new short[this.field1770];

         for(var6 = 0; var6 < this.field1770; ++var6) {
            this.field1799[var6] = var1.field1799[var6];
         }
      }

      if(!var4 && var1.field1776 != null) {
         this.field1776 = new short[this.field1770];

         for(var6 = 0; var6 < this.field1770; ++var6) {
            this.field1776[var6] = var1.field1776[var6];
         }
      } else {
         this.field1776 = var1.field1776;
      }

      this.field1803 = var1.field1803;
      this.field1768 = var1.field1768;
      this.field1795 = var1.field1795;
      this.field1798 = var1.field1798;
      this.field1771 = var1.field1771;
      this.field1772 = var1.field1772;
      this.field1778 = var1.field1778;
      this.field1777 = var1.field1777;
      this.field1781 = var1.field1781;
      this.field1808 = var1.field1808;
      this.field1787 = var1.field1787;
      this.field1782 = var1.field1782;
      this.field1783 = var1.field1783;
      this.field1784 = var1.field1784;
      this.field1785 = var1.field1785;
      this.field1786 = var1.field1786;
      this.field1789 = var1.field1789;
      this.field1769 = var1.field1769;
      this.field1788 = var1.field1788;
      this.field1790 = var1.field1790;
      this.field1794 = var1.field1794;
      this.field1792 = var1.field1792;
      this.field1793 = var1.field1793;
      this.field1807 = var1.field1807;
      this.field1797 = var1.field1797;
      this.field1796 = var1.field1796;
      this.field1780 = var1.field1780;
      this.field1774 = var1.field1774;
   }

   @ObfuscatedName("a")
   public class103 method2292() {
      class103 var1 = new class103();
      if(this.field1771 != null) {
         var1.field1771 = new byte[this.field1770];

         for(int var2 = 0; var2 < this.field1770; ++var2) {
            var1.field1771[var2] = this.field1771[var2];
         }
      }

      var1.field1806 = this.field1806;
      var1.field1770 = this.field1770;
      var1.field1763 = this.field1763;
      var1.field1764 = this.field1764;
      var1.field1765 = this.field1765;
      var1.field1766 = this.field1766;
      var1.field1768 = this.field1768;
      var1.field1795 = this.field1795;
      var1.field1798 = this.field1798;
      var1.field1772 = this.field1772;
      var1.field1803 = this.field1803;
      var1.field1778 = this.field1778;
      var1.field1799 = this.field1799;
      var1.field1776 = this.field1776;
      var1.field1777 = this.field1777;
      var1.field1781 = this.field1781;
      var1.field1808 = this.field1808;
      var1.field1787 = this.field1787;
      var1.field1782 = this.field1782;
      var1.field1783 = this.field1783;
      var1.field1784 = this.field1784;
      var1.field1785 = this.field1785;
      var1.field1786 = this.field1786;
      var1.field1789 = this.field1789;
      var1.field1769 = this.field1769;
      var1.field1788 = this.field1788;
      var1.field1790 = this.field1790;
      var1.field1794 = this.field1794;
      var1.field1792 = this.field1792;
      var1.field1793 = this.field1793;
      var1.field1807 = this.field1807;
      var1.field1797 = this.field1797;
      var1.field1780 = this.field1780;
      var1.field1774 = this.field1774;
      return var1;
   }

   @ObfuscatedName("b")
   public class103 method2293(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2295();
      int var7 = var2 + this.field1801;
      int var8 = var2 + this.field1802;
      int var9 = var4 + this.field1804;
      int var10 = var4 + this.field1791;
      if(var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
         var7 >>= 7;
         var8 = var8 + 127 >> 7;
         var9 >>= 7;
         var10 = var10 + 127 >> 7;
         if(var1[var7][var9] == var3 && var1[var8][var9] == var3 && var1[var7][var10] == var3 && var1[var8][var10] == var3) {
            return this;
         } else {
            class103 var11 = new class103();
            var11.field1806 = this.field1806;
            var11.field1770 = this.field1770;
            var11.field1763 = this.field1763;
            var11.field1764 = this.field1764;
            var11.field1766 = this.field1766;
            var11.field1768 = this.field1768;
            var11.field1795 = this.field1795;
            var11.field1798 = this.field1798;
            var11.field1771 = this.field1771;
            var11.field1772 = this.field1772;
            var11.field1803 = this.field1803;
            var11.field1778 = this.field1778;
            var11.field1799 = this.field1799;
            var11.field1776 = this.field1776;
            var11.field1777 = this.field1777;
            var11.field1781 = this.field1781;
            var11.field1808 = this.field1808;
            var11.field1787 = this.field1787;
            var11.field1782 = this.field1782;
            var11.field1783 = this.field1783;
            var11.field1784 = this.field1784;
            var11.field1785 = this.field1785;
            var11.field1786 = this.field1786;
            var11.field1789 = this.field1789;
            var11.field1769 = this.field1769;
            var11.field1788 = this.field1788;
            var11.field1790 = this.field1790;
            var11.field1794 = this.field1794;
            var11.field1792 = this.field1792;
            var11.field1793 = this.field1793;
            var11.field1780 = this.field1780;
            var11.field1774 = this.field1774;
            var11.field1765 = new int[var11.field1806];
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
               for(var12 = 0; var12 < var11.field1806; ++var12) {
                  var13 = this.field1764[var12] + var2;
                  var14 = this.field1766[var12] + var4;
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var1[var17 + 1][var18 + 1] * var15 >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.field1765[var12] = this.field1765[var12] + var21 - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1806; ++var12) {
                  var13 = (-this.field1765[var12] << 16) / super.field1529;
                  if(var13 < var6) {
                     var14 = this.field1764[var12] + var2;
                     var15 = this.field1766[var12] + var4;
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var1[var18 + 1][var19 + 1] * var16 >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.field1765[var12] = this.field1765[var12] + (var22 - var3) * (var6 - var13) / var6;
                  }
               }
            }

            var11.method2305();
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("u")
   @Export("computeAnimationTables")
   void method2294() {
      int[] var1;
      int var2;
      int var3;
      int var4;
      if(this.field1790 != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.field1806; ++var3) {
            var4 = this.field1790[var3];
            ++var1[var4];
            if(var4 > var2) {
               var2 = var4;
            }
         }

         this.field1792 = new int[var2 + 1][];

         for(var3 = 0; var3 <= var2; ++var3) {
            this.field1792[var3] = new int[var1[var3]];
            var1[var3] = 0;
         }

         for(var3 = 0; var3 < this.field1806; this.field1792[var4][var1[var4]++] = var3++) {
            var4 = this.field1790[var3];
         }

         this.field1790 = null;
      }

      if(this.field1794 != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.field1770; ++var3) {
            var4 = this.field1794[var3];
            ++var1[var4];
            if(var4 > var2) {
               var2 = var4;
            }
         }

         this.field1793 = new int[var2 + 1][];

         for(var3 = 0; var3 <= var2; ++var3) {
            this.field1793[var3] = new int[var1[var3]];
            var1[var3] = 0;
         }

         for(var3 = 0; var3 < this.field1770; this.field1793[var4][var1[var4]++] = var3++) {
            var4 = this.field1794[var3];
         }

         this.field1794 = null;
      }

   }

   @ObfuscatedName("n")
   void method2295() {
      if(!this.field1773) {
         super.field1529 = 0;
         this.field1800 = 0;
         this.field1801 = 999999;
         this.field1802 = -999999;
         this.field1791 = -99999;
         this.field1804 = 99999;

         for(int var1 = 0; var1 < this.field1806; ++var1) {
            int var2 = this.field1764[var1];
            int var3 = this.field1765[var1];
            int var4 = this.field1766[var1];
            if(var2 < this.field1801) {
               this.field1801 = var2;
            }

            if(var2 > this.field1802) {
               this.field1802 = var2;
            }

            if(var4 < this.field1804) {
               this.field1804 = var4;
            }

            if(var4 > this.field1791) {
               this.field1791 = var4;
            }

            if(-var3 > super.field1529) {
               super.field1529 = -var3;
            }

            if(var3 > this.field1800) {
               this.field1800 = var3;
            }
         }

         this.field1773 = true;
      }
   }

   @ObfuscatedName("w")
   public void method2297() {
      for(int var1 = 0; var1 < this.field1806; ++var1) {
         int var2 = this.field1766[var1];
         this.field1766[var1] = this.field1764[var1];
         this.field1764[var1] = -var2;
      }

      this.method2305();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "256"
   )
   public void method2298(int var1) {
      int var2 = field1779[var1];
      int var3 = field1809[var1];

      for(int var4 = 0; var4 < this.field1806; ++var4) {
         int var5 = this.field1766[var4] * var2 + this.field1764[var4] * var3 >> 16;
         this.field1766[var4] = this.field1766[var4] * var3 - this.field1764[var4] * var2 >> 16;
         this.field1764[var4] = var5;
      }

      this.method2305();
   }

   @ObfuscatedName("z")
   public void method2301(short var1, short var2) {
      if(this.field1776 != null) {
         for(int var3 = 0; var3 < this.field1770; ++var3) {
            if(this.field1776[var3] == var1) {
               this.field1776[var3] = var2;
            }
         }

      }
   }

   @ObfuscatedName("f")
   public void method2302(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1806; ++var4) {
         this.field1764[var4] += var1;
         this.field1765[var4] += var2;
         this.field1766[var4] += var3;
      }

      this.method2305();
   }

   @ObfuscatedName("m")
   public void method2303(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1806; ++var4) {
         this.field1764[var4] = this.field1764[var4] * var1 / 128;
         this.field1765[var4] = this.field1765[var4] * var2 / 128;
         this.field1766[var4] = this.field1766[var4] * var3 / 128;
      }

      this.method2305();
   }

   @ObfuscatedName("v")
   @Export("computeNormals")
   public void method2304() {
      if(this.field1807 == null) {
         this.field1807 = new class99[this.field1806];

         int var1;
         for(var1 = 0; var1 < this.field1806; ++var1) {
            this.field1807[var1] = new class99();
         }

         for(var1 = 0; var1 < this.field1770; ++var1) {
            int var2 = this.field1768[var1];
            int var3 = this.field1795[var1];
            int var4 = this.field1798[var1];
            int var5 = this.field1764[var3] - this.field1764[var2];
            int var6 = this.field1765[var3] - this.field1765[var2];
            int var7 = this.field1766[var3] - this.field1766[var2];
            int var8 = this.field1764[var4] - this.field1764[var2];
            int var9 = this.field1765[var4] - this.field1765[var2];
            int var10 = this.field1766[var4] - this.field1766[var2];
            int var11 = var6 * var10 - var9 * var7;
            int var12 = var7 * var8 - var10 * var5;

            int var13;
            for(var13 = var5 * var9 - var8 * var6; var11 > 8192 || var12 > 8192 || var13 > 8192 || var11 < -8192 || var12 < -8192 || var13 < -8192; var13 >>= 1) {
               var11 >>= 1;
               var12 >>= 1;
            }

            int var14 = (int)Math.sqrt((double)(var11 * var11 + var12 * var12 + var13 * var13));
            if(var14 <= 0) {
               var14 = 1;
            }

            var11 = var11 * 256 / var14;
            var12 = var12 * 256 / var14;
            var13 = var13 * 256 / var14;
            byte var15;
            if(this.field1771 == null) {
               var15 = 0;
            } else {
               var15 = this.field1771[var1];
            }

            if(var15 == 0) {
               class99 var16 = this.field1807[var2];
               var16.field1698 += var11;
               var16.field1697 += var12;
               var16.field1702 += var13;
               ++var16.field1696;
               var16 = this.field1807[var3];
               var16.field1698 += var11;
               var16.field1697 += var12;
               var16.field1702 += var13;
               ++var16.field1696;
               var16 = this.field1807[var4];
               var16.field1698 += var11;
               var16.field1697 += var12;
               var16.field1702 += var13;
               ++var16.field1696;
            } else if(var15 == 1) {
               if(this.field1797 == null) {
                  this.field1797 = new class87[this.field1770];
               }

               class87 var17 = this.field1797[var1] = new class87();
               var17.field1520 = var11;
               var17.field1521 = var12;
               var17.field1522 = var13;
            }
         }

      }
   }

   @ObfuscatedName("k")
   void method2305() {
      this.field1807 = null;
      this.field1796 = null;
      this.field1797 = null;
      this.field1773 = false;
   }

   @ObfuscatedName("d")
   static void method2307(class103 var0, class103 var1, int var2, int var3, int var4, boolean var5) {
      var0.method2295();
      var0.method2304();
      var1.method2295();
      var1.method2304();
      ++field1775;
      int var6 = 0;
      int[] var7 = var1.field1764;
      int var8 = var1.field1806;

      int var9;
      for(var9 = 0; var9 < var0.field1806; ++var9) {
         class99 var10 = var0.field1807[var9];
         if(var10.field1696 != 0) {
            int var11 = var0.field1765[var9] - var3;
            if(var11 <= var1.field1800) {
               int var12 = var0.field1764[var9] - var2;
               if(var12 >= var1.field1801 && var12 <= var1.field1802) {
                  int var13 = var0.field1766[var9] - var4;
                  if(var13 >= var1.field1804 && var13 <= var1.field1791) {
                     for(int var14 = 0; var14 < var8; ++var14) {
                        class99 var15 = var1.field1807[var14];
                        if(var12 == var7[var14] && var13 == var1.field1766[var14] && var11 == var1.field1765[var14] && var15.field1696 != 0) {
                           if(var0.field1796 == null) {
                              var0.field1796 = new class99[var0.field1806];
                           }

                           if(var1.field1796 == null) {
                              var1.field1796 = new class99[var8];
                           }

                           class99 var16 = var0.field1796[var9];
                           if(var16 == null) {
                              var16 = var0.field1796[var9] = new class99(var10);
                           }

                           class99 var17 = var1.field1796[var14];
                           if(var17 == null) {
                              var17 = var1.field1796[var14] = new class99(var15);
                           }

                           var16.field1698 += var15.field1698;
                           var16.field1697 += var15.field1697;
                           var16.field1702 += var15.field1702;
                           var16.field1696 += var15.field1696;
                           var17.field1698 += var10.field1698;
                           var17.field1697 += var10.field1697;
                           var17.field1702 += var10.field1702;
                           var17.field1696 += var10.field1696;
                           ++var6;
                           field1805[var9] = field1775;
                           field1767[var14] = field1775;
                        }
                     }
                  }
               }
            }
         }
      }

      if(var6 >= 3 && var5) {
         for(var9 = 0; var9 < var0.field1770; ++var9) {
            if(field1805[var0.field1768[var9]] == field1775 && field1805[var0.field1795[var9]] == field1775 && field1805[var0.field1798[var9]] == field1775) {
               if(var0.field1771 == null) {
                  var0.field1771 = new byte[var0.field1770];
               }

               var0.field1771[var9] = 2;
            }
         }

         for(var9 = 0; var9 < var1.field1770; ++var9) {
            if(field1767[var1.field1768[var9]] == field1775 && field1767[var1.field1795[var9]] == field1775 && field1767[var1.field1798[var9]] == field1775) {
               if(var1.field1771 == null) {
                  var1.field1771 = new byte[var1.field1770];
               }

               var1.field1771[var9] = 2;
            }
         }

      }
   }

   @ObfuscatedName("s")
   public final class108 method2308(int var1, int var2, int var3, int var4, int var5) {
      this.method2304();
      int var6 = (int)Math.sqrt((double)(var3 * var3 + var4 * var4 + var5 * var5));
      int var7 = var2 * var6 >> 8;
      class108 var8 = new class108();
      var8.field1886 = new int[this.field1770];
      var8.field1876 = new int[this.field1770];
      var8.field1888 = new int[this.field1770];
      if(this.field1763 > 0 && this.field1778 != null) {
         int[] var16 = new int[this.field1763];

         int var10;
         for(var10 = 0; var10 < this.field1770; ++var10) {
            if(this.field1778[var10] != -1) {
               ++var16[this.field1778[var10] & 255];
            }
         }

         var8.field1894 = 0;

         for(var10 = 0; var10 < this.field1763; ++var10) {
            if(var16[var10] > 0 && this.field1781[var10] == 0) {
               ++var8.field1894;
            }
         }

         var8.field1895 = new int[var8.field1894];
         var8.field1925 = new int[var8.field1894];
         var8.field1927 = new int[var8.field1894];
         var10 = 0;

         int var11;
         for(var11 = 0; var11 < this.field1763; ++var11) {
            if(var16[var11] > 0 && this.field1781[var11] == 0) {
               var8.field1895[var10] = this.field1808[var11] & '\uffff';
               var8.field1925[var10] = this.field1787[var11] & '\uffff';
               var8.field1927[var10] = this.field1782[var11] & '\uffff';
               var16[var11] = var10++;
            } else {
               var16[var11] = -1;
            }
         }

         var8.field1879 = new byte[this.field1770];

         for(var11 = 0; var11 < this.field1770; ++var11) {
            if(this.field1778[var11] != -1) {
               var8.field1879[var11] = (byte)var16[this.field1778[var11] & 255];
            } else {
               var8.field1879[var11] = -1;
            }
         }
      }

      for(int var9 = 0; var9 < this.field1770; ++var9) {
         byte var17;
         if(this.field1771 == null) {
            var17 = 0;
         } else {
            var17 = this.field1771[var9];
         }

         byte var18;
         if(this.field1803 == null) {
            var18 = 0;
         } else {
            var18 = this.field1803[var9];
         }

         short var12;
         if(this.field1776 == null) {
            var12 = -1;
         } else {
            var12 = this.field1776[var9];
         }

         if(var18 == -2) {
            var17 = 3;
         }

         if(var18 == -1) {
            var17 = 2;
         }

         class99 var13;
         int var14;
         class87 var19;
         if(var12 == -1) {
            if(var17 != 0) {
               if(var17 == 1) {
                  var19 = this.field1797[var9];
                  var14 = var1 + (var3 * var19.field1520 + var4 * var19.field1521 + var5 * var19.field1522) / (var7 + var7 / 2);
                  var8.field1886[var9] = method2309(this.field1799[var9] & '\uffff', var14);
                  var8.field1888[var9] = -1;
               } else if(var17 == 3) {
                  var8.field1886[var9] = 128;
                  var8.field1888[var9] = -1;
               } else {
                  var8.field1888[var9] = -2;
               }
            } else {
               int var15 = this.field1799[var9] & '\uffff';
               if(this.field1796 != null && this.field1796[this.field1768[var9]] != null) {
                  var13 = this.field1796[this.field1768[var9]];
               } else {
                  var13 = this.field1807[this.field1768[var9]];
               }

               var14 = var1 + (var3 * var13.field1698 + var4 * var13.field1697 + var5 * var13.field1702) / (var7 * var13.field1696);
               var8.field1886[var9] = method2309(var15, var14);
               if(this.field1796 != null && this.field1796[this.field1795[var9]] != null) {
                  var13 = this.field1796[this.field1795[var9]];
               } else {
                  var13 = this.field1807[this.field1795[var9]];
               }

               var14 = var1 + (var3 * var13.field1698 + var4 * var13.field1697 + var5 * var13.field1702) / (var7 * var13.field1696);
               var8.field1876[var9] = method2309(var15, var14);
               if(this.field1796 != null && this.field1796[this.field1798[var9]] != null) {
                  var13 = this.field1796[this.field1798[var9]];
               } else {
                  var13 = this.field1807[this.field1798[var9]];
               }

               var14 = var1 + (var3 * var13.field1698 + var4 * var13.field1697 + var5 * var13.field1702) / (var7 * var13.field1696);
               var8.field1888[var9] = method2309(var15, var14);
            }
         } else if(var17 != 0) {
            if(var17 == 1) {
               var19 = this.field1797[var9];
               var14 = var1 + (var3 * var19.field1520 + var4 * var19.field1521 + var5 * var19.field1522) / (var7 + var7 / 2);
               var8.field1886[var9] = method2310(var14);
               var8.field1888[var9] = -1;
            } else {
               var8.field1888[var9] = -2;
            }
         } else {
            if(this.field1796 != null && this.field1796[this.field1768[var9]] != null) {
               var13 = this.field1796[this.field1768[var9]];
            } else {
               var13 = this.field1807[this.field1768[var9]];
            }

            var14 = var1 + (var3 * var13.field1698 + var4 * var13.field1697 + var5 * var13.field1702) / (var7 * var13.field1696);
            var8.field1886[var9] = method2310(var14);
            if(this.field1796 != null && this.field1796[this.field1795[var9]] != null) {
               var13 = this.field1796[this.field1795[var9]];
            } else {
               var13 = this.field1807[this.field1795[var9]];
            }

            var14 = var1 + (var3 * var13.field1698 + var4 * var13.field1697 + var5 * var13.field1702) / (var7 * var13.field1696);
            var8.field1876[var9] = method2310(var14);
            if(this.field1796 != null && this.field1796[this.field1798[var9]] != null) {
               var13 = this.field1796[this.field1798[var9]];
            } else {
               var13 = this.field1807[this.field1798[var9]];
            }

            var14 = var1 + (var3 * var13.field1698 + var4 * var13.field1697 + var5 * var13.field1702) / (var7 * var13.field1696);
            var8.field1888[var9] = method2310(var14);
         }
      }

      this.method2294();
      var8.field1878 = this.field1806;
      var8.field1937 = this.field1764;
      var8.field1882 = this.field1765;
      var8.field1880 = this.field1766;
      var8.field1915 = this.field1770;
      var8.field1874 = this.field1768;
      var8.field1884 = this.field1795;
      var8.field1885 = this.field1798;
      var8.field1889 = this.field1772;
      var8.field1916 = this.field1803;
      var8.field1919 = this.field1777;
      var8.field1898 = this.field1792;
      var8.field1899 = this.field1793;
      var8.field1892 = this.field1776;
      return var8;
   }

   @ObfuscatedName("ah")
   static final int method2309(int var0, int var1) {
      var1 = var1 * (var0 & 127) >> 7;
      if(var1 < 2) {
         var1 = 2;
      } else if(var1 > 126) {
         var1 = 126;
      }

      return (var0 & 'ﾀ') + var1;
   }

   @ObfuscatedName("ak")
   static final int method2310(int var0) {
      if(var0 < 2) {
         var0 = 2;
      } else if(var0 > 126) {
         var0 = 126;
      }

      return var0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass170;II)Lclass103;",
      garbageValue = "0"
   )
   public static class103 method2311(class170 var0, int var1, int var2) {
      byte[] var3 = var0.method3340(var1, var2);
      return var3 == null?null:new class103(var3);
   }

   @ObfuscatedName("o")
   public void method2314() {
      for(int var1 = 0; var1 < this.field1806; ++var1) {
         int var2 = this.field1764[var1];
         this.field1764[var1] = this.field1766[var1];
         this.field1766[var1] = -var2;
      }

      this.method2305();
   }

   @ObfuscatedName("h")
   void method2326(byte[] var1) {
      boolean var2 = false;
      boolean var3 = false;
      class122 var4 = new class122(var1);
      class122 var5 = new class122(var1);
      class122 var6 = new class122(var1);
      class122 var7 = new class122(var1);
      class122 var8 = new class122(var1);
      var4.field2061 = var1.length - 18;
      int var9 = var4.method2612();
      int var10 = var4.method2612();
      int var11 = var4.method2610();
      int var12 = var4.method2610();
      int var13 = var4.method2610();
      int var14 = var4.method2610();
      int var15 = var4.method2610();
      int var16 = var4.method2610();
      int var17 = var4.method2612();
      int var18 = var4.method2612();
      int var19 = var4.method2612();
      int var20 = var4.method2612();
      byte var21 = 0;
      int var45 = var21 + var9;
      int var23 = var45;
      var45 += var10;
      int var24 = var45;
      if(var13 == 255) {
         var45 += var10;
      }

      int var25 = var45;
      if(var15 == 1) {
         var45 += var10;
      }

      int var26 = var45;
      if(var12 == 1) {
         var45 += var10;
      }

      int var27 = var45;
      if(var16 == 1) {
         var45 += var9;
      }

      int var28 = var45;
      if(var14 == 1) {
         var45 += var10;
      }

      int var29 = var45;
      var45 += var20;
      int var30 = var45;
      var45 += var10 * 2;
      int var31 = var45;
      var45 += var11 * 6;
      int var32 = var45;
      var45 += var17;
      int var33 = var45;
      var45 += var18;
      int var10000 = var45 + var19;
      this.field1806 = var9;
      this.field1770 = var10;
      this.field1763 = var11;
      this.field1764 = new int[var9];
      this.field1765 = new int[var9];
      this.field1766 = new int[var9];
      this.field1768 = new int[var10];
      this.field1795 = new int[var10];
      this.field1798 = new int[var10];
      if(var11 > 0) {
         this.field1781 = new byte[var11];
         this.field1808 = new short[var11];
         this.field1787 = new short[var11];
         this.field1782 = new short[var11];
      }

      if(var16 == 1) {
         this.field1790 = new int[var9];
      }

      if(var12 == 1) {
         this.field1771 = new byte[var10];
         this.field1778 = new byte[var10];
         this.field1776 = new short[var10];
      }

      if(var13 == 255) {
         this.field1772 = new byte[var10];
      } else {
         this.field1777 = (byte)var13;
      }

      if(var14 == 1) {
         this.field1803 = new byte[var10];
      }

      if(var15 == 1) {
         this.field1794 = new int[var10];
      }

      this.field1799 = new short[var10];
      var4.field2061 = var21;
      var5.field2061 = var32;
      var6.field2061 = var33;
      var7.field2061 = var45;
      var8.field2061 = var27;
      int var35 = 0;
      int var36 = 0;
      int var37 = 0;

      int var38;
      int var39;
      int var40;
      int var41;
      int var42;
      for(var38 = 0; var38 < var9; ++var38) {
         var39 = var4.method2610();
         var40 = 0;
         if((var39 & 1) != 0) {
            var40 = var5.method2702();
         }

         var41 = 0;
         if((var39 & 2) != 0) {
            var41 = var6.method2702();
         }

         var42 = 0;
         if((var39 & 4) != 0) {
            var42 = var7.method2702();
         }

         this.field1764[var38] = var35 + var40;
         this.field1765[var38] = var36 + var41;
         this.field1766[var38] = var37 + var42;
         var35 = this.field1764[var38];
         var36 = this.field1765[var38];
         var37 = this.field1766[var38];
         if(var16 == 1) {
            this.field1790[var38] = var8.method2610();
         }
      }

      var4.field2061 = var30;
      var5.field2061 = var26;
      var6.field2061 = var24;
      var7.field2061 = var28;
      var8.field2061 = var25;

      for(var38 = 0; var38 < var10; ++var38) {
         this.field1799[var38] = (short)var4.method2612();
         if(var12 == 1) {
            var39 = var5.method2610();
            if((var39 & 1) == 1) {
               this.field1771[var38] = 1;
               var2 = true;
            } else {
               this.field1771[var38] = 0;
            }

            if((var39 & 2) == 2) {
               this.field1778[var38] = (byte)(var39 >> 2);
               this.field1776[var38] = this.field1799[var38];
               this.field1799[var38] = 127;
               if(this.field1776[var38] != -1) {
                  var3 = true;
               }
            } else {
               this.field1778[var38] = -1;
               this.field1776[var38] = -1;
            }
         }

         if(var13 == 255) {
            this.field1772[var38] = var6.method2611();
         }

         if(var14 == 1) {
            this.field1803[var38] = var7.method2611();
         }

         if(var15 == 1) {
            this.field1794[var38] = var8.method2610();
         }
      }

      var4.field2061 = var29;
      var5.field2061 = var23;
      var38 = 0;
      var39 = 0;
      var40 = 0;
      var41 = 0;

      int var43;
      int var44;
      for(var42 = 0; var42 < var10; ++var42) {
         var43 = var5.method2610();
         if(var43 == 1) {
            var38 = var4.method2702() + var41;
            var39 = var4.method2702() + var38;
            var40 = var4.method2702() + var39;
            var41 = var40;
            this.field1768[var42] = var38;
            this.field1795[var42] = var39;
            this.field1798[var42] = var40;
         }

         if(var43 == 2) {
            var39 = var40;
            var40 = var4.method2702() + var41;
            var41 = var40;
            this.field1768[var42] = var38;
            this.field1795[var42] = var39;
            this.field1798[var42] = var40;
         }

         if(var43 == 3) {
            var38 = var40;
            var40 = var4.method2702() + var41;
            var41 = var40;
            this.field1768[var42] = var38;
            this.field1795[var42] = var39;
            this.field1798[var42] = var40;
         }

         if(var43 == 4) {
            var44 = var38;
            var38 = var39;
            var39 = var44;
            var40 = var4.method2702() + var41;
            var41 = var40;
            this.field1768[var42] = var38;
            this.field1795[var42] = var44;
            this.field1798[var42] = var40;
         }
      }

      var4.field2061 = var31;

      for(var42 = 0; var42 < var11; ++var42) {
         this.field1781[var42] = 0;
         this.field1808[var42] = (short)var4.method2612();
         this.field1787[var42] = (short)var4.method2612();
         this.field1782[var42] = (short)var4.method2612();
      }

      if(this.field1778 != null) {
         boolean var46 = false;

         for(var43 = 0; var43 < var10; ++var43) {
            var44 = this.field1778[var43] & 255;
            if(var44 != 255) {
               if((this.field1808[var44] & '\uffff') == this.field1768[var43] && (this.field1787[var44] & '\uffff') == this.field1795[var43] && (this.field1782[var44] & '\uffff') == this.field1798[var43]) {
                  this.field1778[var43] = -1;
               } else {
                  var46 = true;
               }
            }
         }

         if(!var46) {
            this.field1778 = null;
         }
      }

      if(!var3) {
         this.field1776 = null;
      }

      if(!var2) {
         this.field1771 = null;
      }

   }

   @ObfuscatedName("y")
   public void method2340() {
      int var1;
      for(var1 = 0; var1 < this.field1806; ++var1) {
         this.field1766[var1] = -this.field1766[var1];
      }

      for(var1 = 0; var1 < this.field1770; ++var1) {
         int var2 = this.field1768[var1];
         this.field1768[var1] = this.field1798[var1];
         this.field1798[var1] = var2;
      }

      this.method2305();
   }

   class103() {
   }

   @ObfuscatedName("t")
   public void method2350(short var1, short var2) {
      for(int var3 = 0; var3 < this.field1770; ++var3) {
         if(this.field1799[var3] == var1) {
            this.field1799[var3] = var2;
         }
      }

   }

   static {
      field1779 = class94.field1655;
      field1809 = class94.field1653;
   }
}
