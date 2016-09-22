import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("ModelData")
public class ModelData extends Renderable {
   @ObfuscatedName("b")
   byte[] field1772;
   @ObfuscatedName("d")
   int[] field1773;
   @ObfuscatedName("v")
   int[] field1774;
   @ObfuscatedName("r")
   int[] field1775;
   @ObfuscatedName("h")
   short[] field1776;
   @ObfuscatedName("l")
   short[] field1777;
   @ObfuscatedName("n")
   int[] field1778;
   @ObfuscatedName("i")
   int[] field1779;
   @ObfuscatedName("m")
   byte[] field1780;
   @ObfuscatedName("ah")
   static int[] field1781 = new int[10000];
   @ObfuscatedName("a")
   int field1782 = 0;
   @ObfuscatedName("x")
   byte[] field1783;
   @ObfuscatedName("aa")
   FaceNormal[] field1784;
   @ObfuscatedName("j")
   short[] field1785;
   @ObfuscatedName("q")
   byte field1786 = 0;
   @ObfuscatedName("ar")
   VertexNormal[] field1787;
   @ObfuscatedName("aq")
   public short field1788;
   @ObfuscatedName("p")
   short[] field1789;
   @ObfuscatedName("o")
   short[] field1790;
   @ObfuscatedName("y")
   short[] field1791;
   @ObfuscatedName("s")
   short[] field1792;
   @ObfuscatedName("e")
   short[] field1793;
   @ObfuscatedName("w")
   int field1794;
   @ObfuscatedName("av")
   VertexNormal[] field1795;
   @ObfuscatedName("c")
   short[] field1796;
   @ObfuscatedName("f")
   short[] field1797;
   @ObfuscatedName("ac")
   byte[] field1798;
   @ObfuscatedName("am")
   int[][] field1799;
   @ObfuscatedName("af")
   int[] field1800;
   @ObfuscatedName("z")
   int field1801 = 0;
   @ObfuscatedName("ap")
   int[][] field1802;
   @ObfuscatedName("ax")
   boolean field1803 = false;
   @ObfuscatedName("ai")
   static int field1804 = 0;
   @ObfuscatedName("g")
   byte[] field1805;
   @ObfuscatedName("ao")
   public short field1806;
   @ObfuscatedName("as")
   int[] field1807;
   @ObfuscatedName("u")
   short[] field1808;
   @ObfuscatedName("at")
   int field1809;
   @ObfuscatedName("aw")
   int field1810;
   @ObfuscatedName("ab")
   int field1811;
   @ObfuscatedName("al")
   int field1812;
   @ObfuscatedName("ad")
   int field1813;
   @ObfuscatedName("k")
   byte[] field1814;
   @ObfuscatedName("ak")
   static int[] field1815 = new int[10000];
   @ObfuscatedName("t")
   int[] field1816;
   @ObfuscatedName("az")
   static int[] field1817;
   @ObfuscatedName("au")
   static int[] field1818;

   ModelData(byte[] var1) {
      if(var1[var1.length - 1] == -1 && var1[var1.length - 2] == -1) {
         this.method2228(var1);
      } else {
         this.method2231(var1);
      }

   }

   @ObfuscatedName("d")
   void method2228(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      Buffer var3 = new Buffer(var1);
      Buffer var4 = new Buffer(var1);
      Buffer var5 = new Buffer(var1);
      Buffer var6 = new Buffer(var1);
      Buffer var7 = new Buffer(var1);
      Buffer var8 = new Buffer(var1);
      var2.offset = var1.length - 23;
      int var9 = var2.method2717();
      int var10 = var2.method2717();
      int var11 = var2.method2528();
      int var12 = var2.method2528();
      int var13 = var2.method2528();
      int var14 = var2.method2528();
      int var15 = var2.method2528();
      int var16 = var2.method2528();
      int var17 = var2.method2528();
      int var18 = var2.method2717();
      int var19 = var2.method2717();
      int var20 = var2.method2717();
      int var21 = var2.method2717();
      int var22 = var2.method2717();
      int var23 = 0;
      int var24 = 0;
      int var25 = 0;
      int var26;
      if(var11 > 0) {
         this.field1772 = new byte[var11];
         var2.offset = 0;

         for(var26 = 0; var26 < var11; ++var26) {
            byte var27 = this.field1772[var26] = var2.method2529();
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
      this.field1782 = var9;
      this.field1801 = var10;
      this.field1794 = var11;
      this.field1773 = new int[var9];
      this.field1774 = new int[var9];
      this.field1775 = new int[var9];
      this.field1816 = new int[var10];
      this.field1778 = new int[var10];
      this.field1779 = new int[var10];
      if(var17 == 1) {
         this.field1807 = new int[var9];
      }

      if(var12 == 1) {
         this.field1805 = new byte[var10];
      }

      if(var13 == 255) {
         this.field1780 = new byte[var10];
      } else {
         this.field1786 = (byte)var13;
      }

      if(var14 == 1) {
         this.field1814 = new byte[var10];
      }

      if(var15 == 1) {
         this.field1800 = new int[var10];
      }

      if(var16 == 1) {
         this.field1785 = new short[var10];
      }

      if(var16 == 1 && var11 > 0) {
         this.field1783 = new byte[var10];
      }

      this.field1808 = new short[var10];
      if(var11 > 0) {
         this.field1789 = new short[var11];
         this.field1790 = new short[var11];
         this.field1791 = new short[var11];
         if(var24 > 0) {
            this.field1792 = new short[var24];
            this.field1793 = new short[var24];
            this.field1776 = new short[var24];
            this.field1777 = new short[var24];
            this.field1798 = new byte[var24];
            this.field1796 = new short[var24];
         }

         if(var25 > 0) {
            this.field1797 = new short[var25];
         }
      }

      var2.offset = var11;
      var3.offset = var38;
      var4.offset = var39;
      var5.offset = var40;
      var6.offset = var32;
      int var48 = 0;
      int var49 = 0;
      int var50 = 0;

      int var51;
      int var52;
      int var53;
      int var54;
      int var55;
      for(var51 = 0; var51 < var9; ++var51) {
         var52 = var2.method2528();
         var53 = 0;
         if((var52 & 1) != 0) {
            var53 = var3.method2540();
         }

         var54 = 0;
         if((var52 & 2) != 0) {
            var54 = var4.method2540();
         }

         var55 = 0;
         if((var52 & 4) != 0) {
            var55 = var5.method2540();
         }

         this.field1773[var51] = var48 + var53;
         this.field1774[var51] = var49 + var54;
         this.field1775[var51] = var50 + var55;
         var48 = this.field1773[var51];
         var49 = this.field1774[var51];
         var50 = this.field1775[var51];
         if(var17 == 1) {
            this.field1807[var51] = var6.method2528();
         }
      }

      var2.offset = var37;
      var3.offset = var28;
      var4.offset = var30;
      var5.offset = var33;
      var6.offset = var31;
      var7.offset = var35;
      var8.offset = var36;

      for(var51 = 0; var51 < var10; ++var51) {
         this.field1808[var51] = (short)var2.method2717();
         if(var12 == 1) {
            this.field1805[var51] = var3.method2529();
         }

         if(var13 == 255) {
            this.field1780[var51] = var4.method2529();
         }

         if(var14 == 1) {
            this.field1814[var51] = var5.method2529();
         }

         if(var15 == 1) {
            this.field1800[var51] = var6.method2528();
         }

         if(var16 == 1) {
            this.field1785[var51] = (short)(var7.method2717() - 1);
         }

         if(this.field1783 != null && this.field1785[var51] != -1) {
            this.field1783[var51] = (byte)(var8.method2528() - 1);
         }
      }

      var2.offset = var34;
      var3.offset = var29;
      var51 = 0;
      var52 = 0;
      var53 = 0;
      var54 = 0;

      int var56;
      for(var55 = 0; var55 < var10; ++var55) {
         var56 = var3.method2528();
         if(var56 == 1) {
            var51 = var2.method2540() + var54;
            var52 = var2.method2540() + var51;
            var53 = var2.method2540() + var52;
            var54 = var53;
            this.field1816[var55] = var51;
            this.field1778[var55] = var52;
            this.field1779[var55] = var53;
         }

         if(var56 == 2) {
            var52 = var53;
            var53 = var2.method2540() + var54;
            var54 = var53;
            this.field1816[var55] = var51;
            this.field1778[var55] = var52;
            this.field1779[var55] = var53;
         }

         if(var56 == 3) {
            var51 = var53;
            var53 = var2.method2540() + var54;
            var54 = var53;
            this.field1816[var55] = var51;
            this.field1778[var55] = var52;
            this.field1779[var55] = var53;
         }

         if(var56 == 4) {
            int var57 = var51;
            var51 = var52;
            var52 = var57;
            var53 = var2.method2540() + var54;
            var54 = var53;
            this.field1816[var55] = var51;
            this.field1778[var55] = var57;
            this.field1779[var55] = var53;
         }
      }

      var2.offset = var41;
      var3.offset = var42;
      var4.offset = var43;
      var5.offset = var44;
      var6.offset = var45;
      var7.offset = var46;

      for(var55 = 0; var55 < var11; ++var55) {
         var56 = this.field1772[var55] & 255;
         if(var56 == 0) {
            this.field1789[var55] = (short)var2.method2717();
            this.field1790[var55] = (short)var2.method2717();
            this.field1791[var55] = (short)var2.method2717();
         }

         if(var56 == 1) {
            this.field1789[var55] = (short)var3.method2717();
            this.field1790[var55] = (short)var3.method2717();
            this.field1791[var55] = (short)var3.method2717();
            this.field1792[var55] = (short)var4.method2717();
            this.field1793[var55] = (short)var4.method2717();
            this.field1776[var55] = (short)var4.method2717();
            this.field1777[var55] = (short)var5.method2717();
            this.field1798[var55] = var6.method2529();
            this.field1796[var55] = (short)var7.method2717();
         }

         if(var56 == 2) {
            this.field1789[var55] = (short)var3.method2717();
            this.field1790[var55] = (short)var3.method2717();
            this.field1791[var55] = (short)var3.method2717();
            this.field1792[var55] = (short)var4.method2717();
            this.field1793[var55] = (short)var4.method2717();
            this.field1776[var55] = (short)var4.method2717();
            this.field1777[var55] = (short)var5.method2717();
            this.field1798[var55] = var6.method2529();
            this.field1796[var55] = (short)var7.method2717();
            this.field1797[var55] = (short)var7.method2717();
         }

         if(var56 == 3) {
            this.field1789[var55] = (short)var3.method2717();
            this.field1790[var55] = (short)var3.method2717();
            this.field1791[var55] = (short)var3.method2717();
            this.field1792[var55] = (short)var4.method2717();
            this.field1793[var55] = (short)var4.method2717();
            this.field1776[var55] = (short)var4.method2717();
            this.field1777[var55] = (short)var5.method2717();
            this.field1798[var55] = var6.method2529();
            this.field1796[var55] = (short)var7.method2717();
         }
      }

      var2.offset = var26;
      var55 = var2.method2528();
      if(var55 != 0) {
         new class93();
         var2.method2717();
         var2.method2717();
         var2.method2717();
         var2.method2533();
      }

   }

   ModelData() {
   }

   @ObfuscatedName("q")
   public void method2230(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1782; ++var4) {
         this.field1773[var4] += var1;
         this.field1774[var4] += var2;
         this.field1775[var4] += var3;
      }

      this.method2244();
   }

   @ObfuscatedSignature(
      signature = "(LModelData;ZZZZ)V",
      garbageValue = "1"
   )
   public ModelData(ModelData var1, boolean var2, boolean var3, boolean var4, boolean var5) {
      this.field1782 = var1.field1782;
      this.field1801 = var1.field1801;
      this.field1794 = var1.field1794;
      int var6;
      if(var2) {
         this.field1773 = var1.field1773;
         this.field1774 = var1.field1774;
         this.field1775 = var1.field1775;
      } else {
         this.field1773 = new int[this.field1782];
         this.field1774 = new int[this.field1782];
         this.field1775 = new int[this.field1782];

         for(var6 = 0; var6 < this.field1782; ++var6) {
            this.field1773[var6] = var1.field1773[var6];
            this.field1774[var6] = var1.field1774[var6];
            this.field1775[var6] = var1.field1775[var6];
         }
      }

      if(var3) {
         this.field1808 = var1.field1808;
      } else {
         this.field1808 = new short[this.field1801];

         for(var6 = 0; var6 < this.field1801; ++var6) {
            this.field1808[var6] = var1.field1808[var6];
         }
      }

      if(!var4 && var1.field1785 != null) {
         this.field1785 = new short[this.field1801];

         for(var6 = 0; var6 < this.field1801; ++var6) {
            this.field1785[var6] = var1.field1785[var6];
         }
      } else {
         this.field1785 = var1.field1785;
      }

      this.field1814 = var1.field1814;
      this.field1816 = var1.field1816;
      this.field1778 = var1.field1778;
      this.field1779 = var1.field1779;
      this.field1805 = var1.field1805;
      this.field1780 = var1.field1780;
      this.field1783 = var1.field1783;
      this.field1786 = var1.field1786;
      this.field1772 = var1.field1772;
      this.field1789 = var1.field1789;
      this.field1790 = var1.field1790;
      this.field1791 = var1.field1791;
      this.field1792 = var1.field1792;
      this.field1793 = var1.field1793;
      this.field1776 = var1.field1776;
      this.field1777 = var1.field1777;
      this.field1798 = var1.field1798;
      this.field1796 = var1.field1796;
      this.field1797 = var1.field1797;
      this.field1807 = var1.field1807;
      this.field1800 = var1.field1800;
      this.field1799 = var1.field1799;
      this.field1802 = var1.field1802;
      this.field1787 = var1.field1787;
      this.field1784 = var1.field1784;
      this.field1795 = var1.field1795;
      this.field1806 = var1.field1806;
      this.field1788 = var1.field1788;
   }

   @ObfuscatedName("r")
   void method2231(byte[] var1) {
      boolean var2 = false;
      boolean var3 = false;
      Buffer var4 = new Buffer(var1);
      Buffer var5 = new Buffer(var1);
      Buffer var6 = new Buffer(var1);
      Buffer var7 = new Buffer(var1);
      Buffer var8 = new Buffer(var1);
      var4.offset = var1.length - 18;
      int var9 = var4.method2717();
      int var10 = var4.method2717();
      int var11 = var4.method2528();
      int var12 = var4.method2528();
      int var13 = var4.method2528();
      int var14 = var4.method2528();
      int var15 = var4.method2528();
      int var16 = var4.method2528();
      int var17 = var4.method2717();
      int var18 = var4.method2717();
      int var19 = var4.method2717();
      int var20 = var4.method2717();
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
      this.field1782 = var9;
      this.field1801 = var10;
      this.field1794 = var11;
      this.field1773 = new int[var9];
      this.field1774 = new int[var9];
      this.field1775 = new int[var9];
      this.field1816 = new int[var10];
      this.field1778 = new int[var10];
      this.field1779 = new int[var10];
      if(var11 > 0) {
         this.field1772 = new byte[var11];
         this.field1789 = new short[var11];
         this.field1790 = new short[var11];
         this.field1791 = new short[var11];
      }

      if(var16 == 1) {
         this.field1807 = new int[var9];
      }

      if(var12 == 1) {
         this.field1805 = new byte[var10];
         this.field1783 = new byte[var10];
         this.field1785 = new short[var10];
      }

      if(var13 == 255) {
         this.field1780 = new byte[var10];
      } else {
         this.field1786 = (byte)var13;
      }

      if(var14 == 1) {
         this.field1814 = new byte[var10];
      }

      if(var15 == 1) {
         this.field1800 = new int[var10];
      }

      this.field1808 = new short[var10];
      var4.offset = var21;
      var5.offset = var32;
      var6.offset = var33;
      var7.offset = var45;
      var8.offset = var27;
      int var35 = 0;
      int var36 = 0;
      int var37 = 0;

      int var38;
      int var39;
      int var40;
      int var41;
      int var42;
      for(var38 = 0; var38 < var9; ++var38) {
         var39 = var4.method2528();
         var40 = 0;
         if((var39 & 1) != 0) {
            var40 = var5.method2540();
         }

         var41 = 0;
         if((var39 & 2) != 0) {
            var41 = var6.method2540();
         }

         var42 = 0;
         if((var39 & 4) != 0) {
            var42 = var7.method2540();
         }

         this.field1773[var38] = var35 + var40;
         this.field1774[var38] = var36 + var41;
         this.field1775[var38] = var37 + var42;
         var35 = this.field1773[var38];
         var36 = this.field1774[var38];
         var37 = this.field1775[var38];
         if(var16 == 1) {
            this.field1807[var38] = var8.method2528();
         }
      }

      var4.offset = var30;
      var5.offset = var26;
      var6.offset = var24;
      var7.offset = var28;
      var8.offset = var25;

      for(var38 = 0; var38 < var10; ++var38) {
         this.field1808[var38] = (short)var4.method2717();
         if(var12 == 1) {
            var39 = var5.method2528();
            if((var39 & 1) == 1) {
               this.field1805[var38] = 1;
               var2 = true;
            } else {
               this.field1805[var38] = 0;
            }

            if((var39 & 2) == 2) {
               this.field1783[var38] = (byte)(var39 >> 2);
               this.field1785[var38] = this.field1808[var38];
               this.field1808[var38] = 127;
               if(this.field1785[var38] != -1) {
                  var3 = true;
               }
            } else {
               this.field1783[var38] = -1;
               this.field1785[var38] = -1;
            }
         }

         if(var13 == 255) {
            this.field1780[var38] = var6.method2529();
         }

         if(var14 == 1) {
            this.field1814[var38] = var7.method2529();
         }

         if(var15 == 1) {
            this.field1800[var38] = var8.method2528();
         }
      }

      var4.offset = var29;
      var5.offset = var23;
      var38 = 0;
      var39 = 0;
      var40 = 0;
      var41 = 0;

      int var43;
      int var44;
      for(var42 = 0; var42 < var10; ++var42) {
         var43 = var5.method2528();
         if(var43 == 1) {
            var38 = var4.method2540() + var41;
            var39 = var4.method2540() + var38;
            var40 = var4.method2540() + var39;
            var41 = var40;
            this.field1816[var42] = var38;
            this.field1778[var42] = var39;
            this.field1779[var42] = var40;
         }

         if(var43 == 2) {
            var39 = var40;
            var40 = var4.method2540() + var41;
            var41 = var40;
            this.field1816[var42] = var38;
            this.field1778[var42] = var39;
            this.field1779[var42] = var40;
         }

         if(var43 == 3) {
            var38 = var40;
            var40 = var4.method2540() + var41;
            var41 = var40;
            this.field1816[var42] = var38;
            this.field1778[var42] = var39;
            this.field1779[var42] = var40;
         }

         if(var43 == 4) {
            var44 = var38;
            var38 = var39;
            var39 = var44;
            var40 = var4.method2540() + var41;
            var41 = var40;
            this.field1816[var42] = var38;
            this.field1778[var42] = var44;
            this.field1779[var42] = var40;
         }
      }

      var4.offset = var31;

      for(var42 = 0; var42 < var11; ++var42) {
         this.field1772[var42] = 0;
         this.field1789[var42] = (short)var4.method2717();
         this.field1790[var42] = (short)var4.method2717();
         this.field1791[var42] = (short)var4.method2717();
      }

      if(this.field1783 != null) {
         boolean var46 = false;

         for(var43 = 0; var43 < var10; ++var43) {
            var44 = this.field1783[var43] & 255;
            if(var44 != 255) {
               if((this.field1789[var44] & '\uffff') == this.field1816[var43] && (this.field1790[var44] & '\uffff') == this.field1778[var43] && (this.field1791[var44] & '\uffff') == this.field1779[var43]) {
                  this.field1783[var43] = -1;
               } else {
                  var46 = true;
               }
            }
         }

         if(!var46) {
            this.field1783 = null;
         }
      }

      if(!var3) {
         this.field1785 = null;
      }

      if(!var2) {
         this.field1805 = null;
      }

   }

   @ObfuscatedName("n")
   public ModelData method2232(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2264();
      int var7 = var2 + this.field1810;
      int var8 = var2 + this.field1811;
      int var9 = var4 + this.field1813;
      int var10 = var4 + this.field1812;
      if(var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
         var7 >>= 7;
         var8 = var8 + 127 >> 7;
         var9 >>= 7;
         var10 = var10 + 127 >> 7;
         if(var1[var7][var9] == var3 && var1[var8][var9] == var3 && var1[var7][var10] == var3 && var1[var8][var10] == var3) {
            return this;
         } else {
            ModelData var11 = new ModelData();
            var11.field1782 = this.field1782;
            var11.field1801 = this.field1801;
            var11.field1794 = this.field1794;
            var11.field1773 = this.field1773;
            var11.field1775 = this.field1775;
            var11.field1816 = this.field1816;
            var11.field1778 = this.field1778;
            var11.field1779 = this.field1779;
            var11.field1805 = this.field1805;
            var11.field1780 = this.field1780;
            var11.field1814 = this.field1814;
            var11.field1783 = this.field1783;
            var11.field1808 = this.field1808;
            var11.field1785 = this.field1785;
            var11.field1786 = this.field1786;
            var11.field1772 = this.field1772;
            var11.field1789 = this.field1789;
            var11.field1790 = this.field1790;
            var11.field1791 = this.field1791;
            var11.field1792 = this.field1792;
            var11.field1793 = this.field1793;
            var11.field1776 = this.field1776;
            var11.field1777 = this.field1777;
            var11.field1798 = this.field1798;
            var11.field1796 = this.field1796;
            var11.field1797 = this.field1797;
            var11.field1807 = this.field1807;
            var11.field1800 = this.field1800;
            var11.field1799 = this.field1799;
            var11.field1802 = this.field1802;
            var11.field1806 = this.field1806;
            var11.field1788 = this.field1788;
            var11.field1774 = new int[var11.field1782];
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
               for(var12 = 0; var12 < var11.field1782; ++var12) {
                  var13 = this.field1773[var12] + var2;
                  var14 = this.field1775[var12] + var4;
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var1[var17 + 1][var18 + 1] * var15 >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.field1774[var12] = this.field1774[var12] + var21 - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1782; ++var12) {
                  var13 = (-this.field1774[var12] << 16) / super.modelHeight;
                  if(var13 < var6) {
                     var14 = this.field1773[var12] + var2;
                     var15 = this.field1775[var12] + var4;
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var1[var18 + 1][var19 + 1] * var16 >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.field1774[var12] = this.field1774[var12] + (var22 - var3) * (var6 - var13) / var6;
                  }
               }
            }

            var11.method2244();
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("i")
   @Export("computeAnimationTables")
   void computeAnimationTables() {
      int[] var1;
      int var2;
      int var3;
      int var4;
      if(this.field1807 != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.field1782; ++var3) {
            var4 = this.field1807[var3];
            ++var1[var4];
            if(var4 > var2) {
               var2 = var4;
            }
         }

         this.field1799 = new int[var2 + 1][];

         for(var3 = 0; var3 <= var2; ++var3) {
            this.field1799[var3] = new int[var1[var3]];
            var1[var3] = 0;
         }

         for(var3 = 0; var3 < this.field1782; this.field1799[var4][var1[var4]++] = var3++) {
            var4 = this.field1807[var3];
         }

         this.field1807 = null;
      }

      if(this.field1800 != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.field1801; ++var3) {
            var4 = this.field1800[var3];
            ++var1[var4];
            if(var4 > var2) {
               var2 = var4;
            }
         }

         this.field1802 = new int[var2 + 1][];

         for(var3 = 0; var3 <= var2; ++var3) {
            this.field1802[var3] = new int[var1[var3]];
            var1[var3] = 0;
         }

         for(var3 = 0; var3 < this.field1801; this.field1802[var4][var1[var4]++] = var3++) {
            var4 = this.field1800[var3];
         }

         this.field1800 = null;
      }

   }

   @ObfuscatedName("g")
   public void method2234() {
      for(int var1 = 0; var1 < this.field1782; ++var1) {
         int var2 = this.field1773[var1];
         this.field1773[var1] = this.field1775[var1];
         this.field1775[var1] = -var2;
      }

      this.method2244();
   }

   @ObfuscatedName("k")
   public void method2236() {
      for(int var1 = 0; var1 < this.field1782; ++var1) {
         int var2 = this.field1775[var1];
         this.field1775[var1] = this.field1773[var1];
         this.field1773[var1] = -var2;
      }

      this.method2244();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "256"
   )
   public void method2237(int var1) {
      int var2 = field1817[var1];
      int var3 = field1818[var1];

      for(int var4 = 0; var4 < this.field1782; ++var4) {
         int var5 = this.field1775[var4] * var2 + this.field1773[var4] * var3 >> 16;
         this.field1775[var4] = this.field1775[var4] * var3 - this.field1773[var4] * var2 >> 16;
         this.field1773[var4] = var5;
      }

      this.method2244();
   }

   @ObfuscatedName("w")
   public void method2239(short var1, short var2) {
      for(int var3 = 0; var3 < this.field1801; ++var3) {
         if(this.field1808[var3] == var1) {
            this.field1808[var3] = var2;
         }
      }

   }

   @ObfuscatedName("b")
   public void method2240(short var1, short var2) {
      if(this.field1785 != null) {
         for(int var3 = 0; var3 < this.field1801; ++var3) {
            if(this.field1785[var3] == var1) {
               this.field1785[var3] = var2;
            }
         }

      }
   }

   @ObfuscatedName("p")
   public void method2241() {
      int var1;
      for(var1 = 0; var1 < this.field1782; ++var1) {
         this.field1775[var1] = -this.field1775[var1];
      }

      for(var1 = 0; var1 < this.field1801; ++var1) {
         int var2 = this.field1816[var1];
         this.field1816[var1] = this.field1779[var1];
         this.field1779[var1] = var2;
      }

      this.method2244();
   }

   @ObfuscatedName("z")
   final int method2242(ModelData var1, int var2) {
      int var3 = -1;
      int var4 = var1.field1773[var2];
      int var5 = var1.field1774[var2];
      int var6 = var1.field1775[var2];

      for(int var7 = 0; var7 < this.field1782; ++var7) {
         if(var4 == this.field1773[var7] && var5 == this.field1774[var7] && var6 == this.field1775[var7]) {
            var3 = var7;
            break;
         }
      }

      if(var3 == -1) {
         this.field1773[this.field1782] = var4;
         this.field1774[this.field1782] = var5;
         this.field1775[this.field1782] = var6;
         if(var1.field1807 != null) {
            this.field1807[this.field1782] = var1.field1807[var2];
         }

         var3 = this.field1782++;
      }

      return var3;
   }

   @ObfuscatedName("y")
   @Export("computeNormals")
   public void computeNormals() {
      if(this.field1787 == null) {
         this.field1787 = new VertexNormal[this.field1782];

         int var1;
         for(var1 = 0; var1 < this.field1782; ++var1) {
            this.field1787[var1] = new VertexNormal();
         }

         for(var1 = 0; var1 < this.field1801; ++var1) {
            int var2 = this.field1816[var1];
            int var3 = this.field1778[var1];
            int var4 = this.field1779[var1];
            int var5 = this.field1773[var3] - this.field1773[var2];
            int var6 = this.field1774[var3] - this.field1774[var2];
            int var7 = this.field1775[var3] - this.field1775[var2];
            int var8 = this.field1773[var4] - this.field1773[var2];
            int var9 = this.field1774[var4] - this.field1774[var2];
            int var10 = this.field1775[var4] - this.field1775[var2];
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
            if(this.field1805 == null) {
               var15 = 0;
            } else {
               var15 = this.field1805[var1];
            }

            if(var15 == 0) {
               VertexNormal var16 = this.field1787[var2];
               var16.field1717 += var11;
               var16.field1714 += var12;
               var16.field1715 += var13;
               ++var16.field1713;
               var16 = this.field1787[var3];
               var16.field1717 += var11;
               var16.field1714 += var12;
               var16.field1715 += var13;
               ++var16.field1713;
               var16 = this.field1787[var4];
               var16.field1717 += var11;
               var16.field1714 += var12;
               var16.field1715 += var13;
               ++var16.field1713;
            } else if(var15 == 1) {
               if(this.field1784 == null) {
                  this.field1784 = new FaceNormal[this.field1801];
               }

               FaceNormal var17 = this.field1784[var1] = new FaceNormal();
               var17.field1537 = var11;
               var17.field1534 = var12;
               var17.field1535 = var13;
            }
         }

      }
   }

   @ObfuscatedName("s")
   void method2244() {
      this.field1787 = null;
      this.field1795 = null;
      this.field1784 = null;
      this.field1803 = false;
   }

   @ObfuscatedName("h")
   static void method2246(ModelData var0, ModelData var1, int var2, int var3, int var4, boolean var5) {
      var0.method2264();
      var0.computeNormals();
      var1.method2264();
      var1.computeNormals();
      ++field1804;
      int var6 = 0;
      int[] var7 = var1.field1773;
      int var8 = var1.field1782;

      int var9;
      for(var9 = 0; var9 < var0.field1782; ++var9) {
         VertexNormal var10 = var0.field1787[var9];
         if(var10.field1713 != 0) {
            int var11 = var0.field1774[var9] - var3;
            if(var11 <= var1.field1809) {
               int var12 = var0.field1773[var9] - var2;
               if(var12 >= var1.field1810 && var12 <= var1.field1811) {
                  int var13 = var0.field1775[var9] - var4;
                  if(var13 >= var1.field1813 && var13 <= var1.field1812) {
                     for(int var14 = 0; var14 < var8; ++var14) {
                        VertexNormal var15 = var1.field1787[var14];
                        if(var12 == var7[var14] && var13 == var1.field1775[var14] && var11 == var1.field1774[var14] && var15.field1713 != 0) {
                           if(var0.field1795 == null) {
                              var0.field1795 = new VertexNormal[var0.field1782];
                           }

                           if(var1.field1795 == null) {
                              var1.field1795 = new VertexNormal[var8];
                           }

                           VertexNormal var16 = var0.field1795[var9];
                           if(var16 == null) {
                              var16 = var0.field1795[var9] = new VertexNormal(var10);
                           }

                           VertexNormal var17 = var1.field1795[var14];
                           if(var17 == null) {
                              var17 = var1.field1795[var14] = new VertexNormal(var15);
                           }

                           var16.field1717 += var15.field1717;
                           var16.field1714 += var15.field1714;
                           var16.field1715 += var15.field1715;
                           var16.field1713 += var15.field1713;
                           var17.field1717 += var10.field1717;
                           var17.field1714 += var10.field1714;
                           var17.field1715 += var10.field1715;
                           var17.field1713 += var10.field1713;
                           ++var6;
                           field1781[var9] = field1804;
                           field1815[var14] = field1804;
                        }
                     }
                  }
               }
            }
         }
      }

      if(var6 >= 3 && var5) {
         for(var9 = 0; var9 < var0.field1801; ++var9) {
            if(field1781[var0.field1816[var9]] == field1804 && field1781[var0.field1778[var9]] == field1804 && field1781[var0.field1779[var9]] == field1804) {
               if(var0.field1805 == null) {
                  var0.field1805 = new byte[var0.field1801];
               }

               var0.field1805[var9] = 2;
            }
         }

         for(var9 = 0; var9 < var1.field1801; ++var9) {
            if(field1815[var1.field1816[var9]] == field1804 && field1815[var1.field1778[var9]] == field1804 && field1815[var1.field1779[var9]] == field1804) {
               if(var1.field1805 == null) {
                  var1.field1805 = new byte[var1.field1801];
               }

               var1.field1805[var9] = 2;
            }
         }

      }
   }

   @ObfuscatedName("l")
   public final Model method2247(int var1, int var2, int var3, int var4, int var5) {
      this.computeNormals();
      int var6 = (int)Math.sqrt((double)(var3 * var3 + var4 * var4 + var5 * var5));
      int var7 = var2 * var6 >> 8;
      Model var8 = new Model();
      var8.field1905 = new int[this.field1801];
      var8.field1887 = new int[this.field1801];
      var8.field1896 = new int[this.field1801];
      if(this.field1794 > 0 && this.field1783 != null) {
         int[] var16 = new int[this.field1794];

         int var10;
         for(var10 = 0; var10 < this.field1801; ++var10) {
            if(this.field1783[var10] != -1) {
               ++var16[this.field1783[var10] & 255];
            }
         }

         var8.field1902 = 0;

         for(var10 = 0; var10 < this.field1794; ++var10) {
            if(var16[var10] > 0 && this.field1772[var10] == 0) {
               ++var8.field1902;
            }
         }

         var8.field1934 = new int[var8.field1902];
         var8.field1923 = new int[var8.field1902];
         var8.field1924 = new int[var8.field1902];
         var10 = 0;

         int var11;
         for(var11 = 0; var11 < this.field1794; ++var11) {
            if(var16[var11] > 0 && this.field1772[var11] == 0) {
               var8.field1934[var10] = this.field1789[var11] & '\uffff';
               var8.field1923[var10] = this.field1790[var11] & '\uffff';
               var8.field1924[var10] = this.field1791[var11] & '\uffff';
               var16[var11] = var10++;
            } else {
               var16[var11] = -1;
            }
         }

         var8.field1894 = new byte[this.field1801];

         for(var11 = 0; var11 < this.field1801; ++var11) {
            if(this.field1783[var11] != -1) {
               var8.field1894[var11] = (byte)var16[this.field1783[var11] & 255];
            } else {
               var8.field1894[var11] = -1;
            }
         }
      }

      for(int var9 = 0; var9 < this.field1801; ++var9) {
         byte var17;
         if(this.field1805 == null) {
            var17 = 0;
         } else {
            var17 = this.field1805[var9];
         }

         byte var18;
         if(this.field1814 == null) {
            var18 = 0;
         } else {
            var18 = this.field1814[var9];
         }

         short var12;
         if(this.field1785 == null) {
            var12 = -1;
         } else {
            var12 = this.field1785[var9];
         }

         if(var18 == -2) {
            var17 = 3;
         }

         if(var18 == -1) {
            var17 = 2;
         }

         VertexNormal var13;
         int var14;
         FaceNormal var19;
         if(var12 == -1) {
            if(var17 != 0) {
               if(var17 == 1) {
                  var19 = this.field1784[var9];
                  var14 = var1 + (var3 * var19.field1537 + var4 * var19.field1534 + var5 * var19.field1535) / (var7 + var7 / 2);
                  var8.field1905[var9] = method2248(this.field1808[var9] & '\uffff', var14);
                  var8.field1896[var9] = -1;
               } else if(var17 == 3) {
                  var8.field1905[var9] = 128;
                  var8.field1896[var9] = -1;
               } else {
                  var8.field1896[var9] = -2;
               }
            } else {
               int var15 = this.field1808[var9] & '\uffff';
               if(this.field1795 != null && this.field1795[this.field1816[var9]] != null) {
                  var13 = this.field1795[this.field1816[var9]];
               } else {
                  var13 = this.field1787[this.field1816[var9]];
               }

               var14 = var1 + (var3 * var13.field1717 + var4 * var13.field1714 + var5 * var13.field1715) / (var7 * var13.field1713);
               var8.field1905[var9] = method2248(var15, var14);
               if(this.field1795 != null && this.field1795[this.field1778[var9]] != null) {
                  var13 = this.field1795[this.field1778[var9]];
               } else {
                  var13 = this.field1787[this.field1778[var9]];
               }

               var14 = var1 + (var3 * var13.field1717 + var4 * var13.field1714 + var5 * var13.field1715) / (var7 * var13.field1713);
               var8.field1887[var9] = method2248(var15, var14);
               if(this.field1795 != null && this.field1795[this.field1779[var9]] != null) {
                  var13 = this.field1795[this.field1779[var9]];
               } else {
                  var13 = this.field1787[this.field1779[var9]];
               }

               var14 = var1 + (var3 * var13.field1717 + var4 * var13.field1714 + var5 * var13.field1715) / (var7 * var13.field1713);
               var8.field1896[var9] = method2248(var15, var14);
            }
         } else if(var17 != 0) {
            if(var17 == 1) {
               var19 = this.field1784[var9];
               var14 = var1 + (var3 * var19.field1537 + var4 * var19.field1534 + var5 * var19.field1535) / (var7 + var7 / 2);
               var8.field1905[var9] = method2269(var14);
               var8.field1896[var9] = -1;
            } else {
               var8.field1896[var9] = -2;
            }
         } else {
            if(this.field1795 != null && this.field1795[this.field1816[var9]] != null) {
               var13 = this.field1795[this.field1816[var9]];
            } else {
               var13 = this.field1787[this.field1816[var9]];
            }

            var14 = var1 + (var3 * var13.field1717 + var4 * var13.field1714 + var5 * var13.field1715) / (var7 * var13.field1713);
            var8.field1905[var9] = method2269(var14);
            if(this.field1795 != null && this.field1795[this.field1778[var9]] != null) {
               var13 = this.field1795[this.field1778[var9]];
            } else {
               var13 = this.field1787[this.field1778[var9]];
            }

            var14 = var1 + (var3 * var13.field1717 + var4 * var13.field1714 + var5 * var13.field1715) / (var7 * var13.field1713);
            var8.field1887[var9] = method2269(var14);
            if(this.field1795 != null && this.field1795[this.field1779[var9]] != null) {
               var13 = this.field1795[this.field1779[var9]];
            } else {
               var13 = this.field1787[this.field1779[var9]];
            }

            var14 = var1 + (var3 * var13.field1717 + var4 * var13.field1714 + var5 * var13.field1715) / (var7 * var13.field1713);
            var8.field1896[var9] = method2269(var14);
         }
      }

      this.computeAnimationTables();
      var8.field1895 = this.field1782;
      var8.verticesX = this.field1773;
      var8.verticesY = this.field1774;
      var8.verticesZ = this.field1775;
      var8.field1890 = this.field1801;
      var8.indices1 = this.field1816;
      var8.indices2 = this.field1778;
      var8.indices3 = this.field1779;
      var8.field1897 = this.field1780;
      var8.field1898 = this.field1814;
      var8.field1901 = this.field1786;
      var8.field1906 = this.field1799;
      var8.field1919 = this.field1802;
      var8.field1900 = this.field1785;
      return var8;
   }

   @ObfuscatedName("c")
   static final int method2248(int var0, int var1) {
      var1 = var1 * (var0 & 127) >> 7;
      if(var1 < 2) {
         var1 = 2;
      } else if(var1 > 126) {
         var1 = 126;
      }

      return (var0 & 'ﾀ') + var1;
   }

   static {
      field1817 = class94.field1670;
      field1818 = class94.field1676;
   }

   @ObfuscatedName("e")
   void method2264() {
      if(!this.field1803) {
         super.modelHeight = 0;
         this.field1809 = 0;
         this.field1810 = 999999;
         this.field1811 = -999999;
         this.field1812 = -99999;
         this.field1813 = 99999;

         for(int var1 = 0; var1 < this.field1782; ++var1) {
            int var2 = this.field1773[var1];
            int var3 = this.field1774[var1];
            int var4 = this.field1775[var1];
            if(var2 < this.field1810) {
               this.field1810 = var2;
            }

            if(var2 > this.field1811) {
               this.field1811 = var2;
            }

            if(var4 < this.field1813) {
               this.field1813 = var4;
            }

            if(var4 > this.field1812) {
               this.field1812 = var4;
            }

            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1809) {
               this.field1809 = var3;
            }
         }

         this.field1803 = true;
      }
   }

   @ObfuscatedName("f")
   static final int method2269(int var0) {
      if(var0 < 2) {
         var0 = 2;
      } else if(var0 > 126) {
         var0 = 126;
      }

      return var0;
   }

   @ObfuscatedName("o")
   public void method2270(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1782; ++var4) {
         this.field1773[var4] = this.field1773[var4] * var1 / 128;
         this.field1774[var4] = this.field1774[var4] * var2 / 128;
         this.field1775[var4] = this.field1775[var4] * var3 / 128;
      }

      this.method2244();
   }

   @ObfuscatedName("m")
   public void method2276() {
      for(int var1 = 0; var1 < this.field1782; ++var1) {
         this.field1773[var1] = -this.field1773[var1];
         this.field1775[var1] = -this.field1775[var1];
      }

      this.method2244();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass170;II)LModelData;",
      garbageValue = "0"
   )
   public static ModelData method2284(class170 var0, int var1, int var2) {
      byte[] var3 = var0.method3309(var1, var2);
      return var3 == null?null:new ModelData(var3);
   }

   public ModelData(ModelData[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      boolean var8 = false;
      this.field1782 = 0;
      this.field1801 = 0;
      this.field1794 = 0;
      this.field1786 = -1;

      int var9;
      ModelData var10;
      for(var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if(var10 != null) {
            this.field1782 += var10.field1782;
            this.field1801 += var10.field1801;
            this.field1794 += var10.field1794;
            if(var10.field1780 != null) {
               var4 = true;
            } else {
               if(this.field1786 == -1) {
                  this.field1786 = var10.field1786;
               }

               if(this.field1786 != var10.field1786) {
                  var4 = true;
               }
            }

            var3 |= var10.field1805 != null;
            var5 |= var10.field1814 != null;
            var6 |= var10.field1800 != null;
            var7 |= var10.field1785 != null;
            var8 |= var10.field1783 != null;
         }
      }

      this.field1773 = new int[this.field1782];
      this.field1774 = new int[this.field1782];
      this.field1775 = new int[this.field1782];
      this.field1807 = new int[this.field1782];
      this.field1816 = new int[this.field1801];
      this.field1778 = new int[this.field1801];
      this.field1779 = new int[this.field1801];
      if(var3) {
         this.field1805 = new byte[this.field1801];
      }

      if(var4) {
         this.field1780 = new byte[this.field1801];
      }

      if(var5) {
         this.field1814 = new byte[this.field1801];
      }

      if(var6) {
         this.field1800 = new int[this.field1801];
      }

      if(var7) {
         this.field1785 = new short[this.field1801];
      }

      if(var8) {
         this.field1783 = new byte[this.field1801];
      }

      this.field1808 = new short[this.field1801];
      if(this.field1794 > 0) {
         this.field1772 = new byte[this.field1794];
         this.field1789 = new short[this.field1794];
         this.field1790 = new short[this.field1794];
         this.field1791 = new short[this.field1794];
         this.field1792 = new short[this.field1794];
         this.field1793 = new short[this.field1794];
         this.field1776 = new short[this.field1794];
         this.field1777 = new short[this.field1794];
         this.field1798 = new byte[this.field1794];
         this.field1796 = new short[this.field1794];
         this.field1797 = new short[this.field1794];
      }

      this.field1782 = 0;
      this.field1801 = 0;
      this.field1794 = 0;

      for(var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if(var10 != null) {
            int var11;
            for(var11 = 0; var11 < var10.field1801; ++var11) {
               if(var3 && var10.field1805 != null) {
                  this.field1805[this.field1801] = var10.field1805[var11];
               }

               if(var4) {
                  if(var10.field1780 != null) {
                     this.field1780[this.field1801] = var10.field1780[var11];
                  } else {
                     this.field1780[this.field1801] = var10.field1786;
                  }
               }

               if(var5 && var10.field1814 != null) {
                  this.field1814[this.field1801] = var10.field1814[var11];
               }

               if(var6 && var10.field1800 != null) {
                  this.field1800[this.field1801] = var10.field1800[var11];
               }

               if(var7) {
                  if(var10.field1785 != null) {
                     this.field1785[this.field1801] = var10.field1785[var11];
                  } else {
                     this.field1785[this.field1801] = -1;
                  }
               }

               if(var8) {
                  if(var10.field1783 != null && var10.field1783[var11] != -1) {
                     this.field1783[this.field1801] = (byte)(var10.field1783[var11] + this.field1794);
                  } else {
                     this.field1783[this.field1801] = -1;
                  }
               }

               this.field1808[this.field1801] = var10.field1808[var11];
               this.field1816[this.field1801] = this.method2242(var10, var10.field1816[var11]);
               this.field1778[this.field1801] = this.method2242(var10, var10.field1778[var11]);
               this.field1779[this.field1801] = this.method2242(var10, var10.field1779[var11]);
               ++this.field1801;
            }

            for(var11 = 0; var11 < var10.field1794; ++var11) {
               byte var12 = this.field1772[this.field1794] = var10.field1772[var11];
               if(var12 == 0) {
                  this.field1789[this.field1794] = (short)this.method2242(var10, var10.field1789[var11]);
                  this.field1790[this.field1794] = (short)this.method2242(var10, var10.field1790[var11]);
                  this.field1791[this.field1794] = (short)this.method2242(var10, var10.field1791[var11]);
               }

               if(var12 >= 1 && var12 <= 3) {
                  this.field1789[this.field1794] = var10.field1789[var11];
                  this.field1790[this.field1794] = var10.field1790[var11];
                  this.field1791[this.field1794] = var10.field1791[var11];
                  this.field1792[this.field1794] = var10.field1792[var11];
                  this.field1793[this.field1794] = var10.field1793[var11];
                  this.field1776[this.field1794] = var10.field1776[var11];
                  this.field1777[this.field1794] = var10.field1777[var11];
                  this.field1798[this.field1794] = var10.field1798[var11];
                  this.field1796[this.field1794] = var10.field1796[var11];
               }

               if(var12 == 2) {
                  this.field1797[this.field1794] = var10.field1797[var11];
               }

               ++this.field1794;
            }
         }
      }

   }

   @ObfuscatedName("t")
   public ModelData method2301() {
      ModelData var1 = new ModelData();
      if(this.field1805 != null) {
         var1.field1805 = new byte[this.field1801];

         for(int var2 = 0; var2 < this.field1801; ++var2) {
            var1.field1805[var2] = this.field1805[var2];
         }
      }

      var1.field1782 = this.field1782;
      var1.field1801 = this.field1801;
      var1.field1794 = this.field1794;
      var1.field1773 = this.field1773;
      var1.field1774 = this.field1774;
      var1.field1775 = this.field1775;
      var1.field1816 = this.field1816;
      var1.field1778 = this.field1778;
      var1.field1779 = this.field1779;
      var1.field1780 = this.field1780;
      var1.field1814 = this.field1814;
      var1.field1783 = this.field1783;
      var1.field1808 = this.field1808;
      var1.field1785 = this.field1785;
      var1.field1786 = this.field1786;
      var1.field1772 = this.field1772;
      var1.field1789 = this.field1789;
      var1.field1790 = this.field1790;
      var1.field1791 = this.field1791;
      var1.field1792 = this.field1792;
      var1.field1793 = this.field1793;
      var1.field1776 = this.field1776;
      var1.field1777 = this.field1777;
      var1.field1798 = this.field1798;
      var1.field1796 = this.field1796;
      var1.field1797 = this.field1797;
      var1.field1807 = this.field1807;
      var1.field1800 = this.field1800;
      var1.field1799 = this.field1799;
      var1.field1802 = this.field1802;
      var1.field1787 = this.field1787;
      var1.field1784 = this.field1784;
      var1.field1806 = this.field1806;
      var1.field1788 = this.field1788;
      return var1;
   }
}
