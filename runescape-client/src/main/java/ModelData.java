import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
@Implements("ModelData")
public class ModelData extends Renderable {
   @ObfuscatedName("ap")
   int field1746;
   @ObfuscatedName("q")
   int[] field1747;
   @ObfuscatedName("f")
   int[] field1748;
   @ObfuscatedName("c")
   int[] field1749;
   @ObfuscatedName("e")
   short[] field1750;
   @ObfuscatedName("j")
   int[] field1751;
   @ObfuscatedName("m")
   int[] field1752;
   @ObfuscatedName("y")
   int[] field1753;
   @ObfuscatedName("ax")
   int field1754;
   @ObfuscatedName("h")
   byte[] field1755;
   @ObfuscatedName("l")
   byte[] field1756;
   @ObfuscatedName("aj")
   FaceNormal[] field1757;
   @ObfuscatedName("g")
   short[] field1758;
   @ObfuscatedName("n")
   short[] field1759;
   @ObfuscatedName("aq")
   byte[] field1760;
   @ObfuscatedName("k")
   int field1761 = 0;
   @ObfuscatedName("w")
   byte[] field1762;
   @ObfuscatedName("i")
   short[] field1763;
   @ObfuscatedName("au")
   static int[] field1764;
   @ObfuscatedName("a")
   short[] field1765;
   @ObfuscatedName("z")
   short[] field1766;
   @ObfuscatedName("v")
   int field1767 = 0;
   @ObfuscatedName("ak")
   boolean field1768 = false;
   @ObfuscatedName("d")
   short[] field1769;
   @ObfuscatedName("t")
   short[] field1770;
   @ObfuscatedName("o")
   short[] field1771;
   @ObfuscatedName("ad")
   int[][] field1772;
   @ObfuscatedName("al")
   int[] field1773;
   @ObfuscatedName("av")
   int[] field1774;
   @ObfuscatedName("p")
   byte field1775 = 0;
   @ObfuscatedName("at")
   int[][] field1776;
   @ObfuscatedName("x")
   short[] field1777;
   @ObfuscatedName("am")
   VertexNormal[] field1778;
   @ObfuscatedName("ag")
   public short field1779;
   @ObfuscatedName("u")
   byte[] field1780;
   @ObfuscatedName("ay")
   VertexNormal[] field1781;
   @ObfuscatedName("b")
   byte[] field1782;
   @ObfuscatedName("ar")
   int field1783;
   @ObfuscatedName("r")
   short[] field1784;
   @ObfuscatedName("s")
   int field1785;
   @ObfuscatedName("ao")
   int field1786;
   @ObfuscatedName("aw")
   int field1787;
   @ObfuscatedName("ai")
   static int[] field1788 = new int[10000];
   @ObfuscatedName("af")
   static int[] field1789 = new int[10000];
   @ObfuscatedName("an")
   static int field1790 = 0;
   @ObfuscatedName("aa")
   public short field1791;
   @ObfuscatedName("ac")
   static int[] field1792;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass170;II)LModelData;",
      garbageValue = "0"
   )
   public static ModelData method2274(class170 var0, int var1, int var2) {
      byte[] var3 = var0.method3305(var1, var2);
      return var3 == null?null:new ModelData(var3);
   }

   ModelData(byte[] var1) {
      if(var1[var1.length - 1] == -1 && var1[var1.length - 2] == -1) {
         this.method2308(var1);
      } else {
         this.method2350(var1);
      }

   }

   @ObfuscatedName("g")
   public void method2275(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1761; ++var4) {
         this.field1747[var4] += var1;
         this.field1748[var4] += var2;
         this.field1749[var4] += var3;
      }

      this.method2276();
   }

   ModelData() {
   }

   public ModelData(ModelData[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      boolean var8 = false;
      this.field1761 = 0;
      this.field1767 = 0;
      this.field1785 = 0;
      this.field1775 = -1;

      int var9;
      ModelData var10;
      for(var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if(var10 != null) {
            this.field1761 += var10.field1761;
            this.field1767 += var10.field1767;
            this.field1785 += var10.field1785;
            if(var10.field1755 != null) {
               var4 = true;
            } else {
               if(this.field1775 == -1) {
                  this.field1775 = var10.field1775;
               }

               if(this.field1775 != var10.field1775) {
                  var4 = true;
               }
            }

            var3 |= var10.field1780 != null;
            var5 |= var10.field1756 != null;
            var6 |= var10.field1774 != null;
            var7 |= var10.field1750 != null;
            var8 |= var10.field1782 != null;
         }
      }

      this.field1747 = new int[this.field1761];
      this.field1748 = new int[this.field1761];
      this.field1749 = new int[this.field1761];
      this.field1773 = new int[this.field1761];
      this.field1751 = new int[this.field1767];
      this.field1752 = new int[this.field1767];
      this.field1753 = new int[this.field1767];
      if(var3) {
         this.field1780 = new byte[this.field1767];
      }

      if(var4) {
         this.field1755 = new byte[this.field1767];
      }

      if(var5) {
         this.field1756 = new byte[this.field1767];
      }

      if(var6) {
         this.field1774 = new int[this.field1767];
      }

      if(var7) {
         this.field1750 = new short[this.field1767];
      }

      if(var8) {
         this.field1782 = new byte[this.field1767];
      }

      this.field1758 = new short[this.field1767];
      if(this.field1785 > 0) {
         this.field1762 = new byte[this.field1785];
         this.field1763 = new short[this.field1785];
         this.field1784 = new short[this.field1785];
         this.field1765 = new short[this.field1785];
         this.field1759 = new short[this.field1785];
         this.field1766 = new short[this.field1785];
         this.field1777 = new short[this.field1785];
         this.field1769 = new short[this.field1785];
         this.field1760 = new byte[this.field1785];
         this.field1770 = new short[this.field1785];
         this.field1771 = new short[this.field1785];
      }

      this.field1761 = 0;
      this.field1767 = 0;
      this.field1785 = 0;

      for(var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if(var10 != null) {
            int var11;
            for(var11 = 0; var11 < var10.field1767; ++var11) {
               if(var3 && var10.field1780 != null) {
                  this.field1780[this.field1767] = var10.field1780[var11];
               }

               if(var4) {
                  if(var10.field1755 != null) {
                     this.field1755[this.field1767] = var10.field1755[var11];
                  } else {
                     this.field1755[this.field1767] = var10.field1775;
                  }
               }

               if(var5 && var10.field1756 != null) {
                  this.field1756[this.field1767] = var10.field1756[var11];
               }

               if(var6 && var10.field1774 != null) {
                  this.field1774[this.field1767] = var10.field1774[var11];
               }

               if(var7) {
                  if(var10.field1750 != null) {
                     this.field1750[this.field1767] = var10.field1750[var11];
                  } else {
                     this.field1750[this.field1767] = -1;
                  }
               }

               if(var8) {
                  if(var10.field1782 != null && var10.field1782[var11] != -1) {
                     this.field1782[this.field1767] = (byte)(var10.field1782[var11] + this.field1785);
                  } else {
                     this.field1782[this.field1767] = -1;
                  }
               }

               this.field1758[this.field1767] = var10.field1758[var11];
               this.field1751[this.field1767] = this.method2326(var10, var10.field1751[var11]);
               this.field1752[this.field1767] = this.method2326(var10, var10.field1752[var11]);
               this.field1753[this.field1767] = this.method2326(var10, var10.field1753[var11]);
               ++this.field1767;
            }

            for(var11 = 0; var11 < var10.field1785; ++var11) {
               byte var12 = this.field1762[this.field1785] = var10.field1762[var11];
               if(var12 == 0) {
                  this.field1763[this.field1785] = (short)this.method2326(var10, var10.field1763[var11]);
                  this.field1784[this.field1785] = (short)this.method2326(var10, var10.field1784[var11]);
                  this.field1765[this.field1785] = (short)this.method2326(var10, var10.field1765[var11]);
               }

               if(var12 >= 1 && var12 <= 3) {
                  this.field1763[this.field1785] = var10.field1763[var11];
                  this.field1784[this.field1785] = var10.field1784[var11];
                  this.field1765[this.field1785] = var10.field1765[var11];
                  this.field1759[this.field1785] = var10.field1759[var11];
                  this.field1766[this.field1785] = var10.field1766[var11];
                  this.field1777[this.field1785] = var10.field1777[var11];
                  this.field1769[this.field1785] = var10.field1769[var11];
                  this.field1760[this.field1785] = var10.field1760[var11];
                  this.field1770[this.field1785] = var10.field1770[var11];
               }

               if(var12 == 2) {
                  this.field1771[this.field1785] = var10.field1771[var11];
               }

               ++this.field1785;
            }
         }
      }

   }

   @ObfuscatedName("x")
   void method2276() {
      this.field1778 = null;
      this.field1781 = null;
      this.field1757 = null;
      this.field1768 = false;
   }

   @ObfuscatedSignature(
      signature = "(LModelData;ZZZZ)V",
      garbageValue = "1"
   )
   public ModelData(ModelData var1, boolean var2, boolean var3, boolean var4, boolean var5) {
      this.field1761 = var1.field1761;
      this.field1767 = var1.field1767;
      this.field1785 = var1.field1785;
      int var6;
      if(var2) {
         this.field1747 = var1.field1747;
         this.field1748 = var1.field1748;
         this.field1749 = var1.field1749;
      } else {
         this.field1747 = new int[this.field1761];
         this.field1748 = new int[this.field1761];
         this.field1749 = new int[this.field1761];

         for(var6 = 0; var6 < this.field1761; ++var6) {
            this.field1747[var6] = var1.field1747[var6];
            this.field1748[var6] = var1.field1748[var6];
            this.field1749[var6] = var1.field1749[var6];
         }
      }

      if(var3) {
         this.field1758 = var1.field1758;
      } else {
         this.field1758 = new short[this.field1767];

         for(var6 = 0; var6 < this.field1767; ++var6) {
            this.field1758[var6] = var1.field1758[var6];
         }
      }

      if(!var4 && var1.field1750 != null) {
         this.field1750 = new short[this.field1767];

         for(var6 = 0; var6 < this.field1767; ++var6) {
            this.field1750[var6] = var1.field1750[var6];
         }
      } else {
         this.field1750 = var1.field1750;
      }

      this.field1756 = var1.field1756;
      this.field1751 = var1.field1751;
      this.field1752 = var1.field1752;
      this.field1753 = var1.field1753;
      this.field1780 = var1.field1780;
      this.field1755 = var1.field1755;
      this.field1782 = var1.field1782;
      this.field1775 = var1.field1775;
      this.field1762 = var1.field1762;
      this.field1763 = var1.field1763;
      this.field1784 = var1.field1784;
      this.field1765 = var1.field1765;
      this.field1759 = var1.field1759;
      this.field1766 = var1.field1766;
      this.field1777 = var1.field1777;
      this.field1769 = var1.field1769;
      this.field1760 = var1.field1760;
      this.field1770 = var1.field1770;
      this.field1771 = var1.field1771;
      this.field1773 = var1.field1773;
      this.field1774 = var1.field1774;
      this.field1772 = var1.field1772;
      this.field1776 = var1.field1776;
      this.field1778 = var1.field1778;
      this.field1757 = var1.field1757;
      this.field1781 = var1.field1781;
      this.field1779 = var1.field1779;
      this.field1791 = var1.field1791;
   }

   @ObfuscatedName("j")
   public ModelData method2277() {
      ModelData var1 = new ModelData();
      if(this.field1780 != null) {
         var1.field1780 = new byte[this.field1767];

         for(int var2 = 0; var2 < this.field1767; ++var2) {
            var1.field1780[var2] = this.field1780[var2];
         }
      }

      var1.field1761 = this.field1761;
      var1.field1767 = this.field1767;
      var1.field1785 = this.field1785;
      var1.field1747 = this.field1747;
      var1.field1748 = this.field1748;
      var1.field1749 = this.field1749;
      var1.field1751 = this.field1751;
      var1.field1752 = this.field1752;
      var1.field1753 = this.field1753;
      var1.field1755 = this.field1755;
      var1.field1756 = this.field1756;
      var1.field1782 = this.field1782;
      var1.field1758 = this.field1758;
      var1.field1750 = this.field1750;
      var1.field1775 = this.field1775;
      var1.field1762 = this.field1762;
      var1.field1763 = this.field1763;
      var1.field1784 = this.field1784;
      var1.field1765 = this.field1765;
      var1.field1759 = this.field1759;
      var1.field1766 = this.field1766;
      var1.field1777 = this.field1777;
      var1.field1769 = this.field1769;
      var1.field1760 = this.field1760;
      var1.field1770 = this.field1770;
      var1.field1771 = this.field1771;
      var1.field1773 = this.field1773;
      var1.field1774 = this.field1774;
      var1.field1772 = this.field1772;
      var1.field1776 = this.field1776;
      var1.field1778 = this.field1778;
      var1.field1757 = this.field1757;
      var1.field1779 = this.field1779;
      var1.field1791 = this.field1791;
      return var1;
   }

   @ObfuscatedName("m")
   public ModelData method2278(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2343();
      int var7 = var2 + this.field1754;
      int var8 = var2 + this.field1746;
      int var9 = var4 + this.field1787;
      int var10 = var4 + this.field1786;
      if(var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
         var7 >>= 7;
         var8 = var8 + 127 >> 7;
         var9 >>= 7;
         var10 = var10 + 127 >> 7;
         if(var1[var7][var9] == var3 && var1[var8][var9] == var3 && var1[var7][var10] == var3 && var1[var8][var10] == var3) {
            return this;
         } else {
            ModelData var11 = new ModelData();
            var11.field1761 = this.field1761;
            var11.field1767 = this.field1767;
            var11.field1785 = this.field1785;
            var11.field1747 = this.field1747;
            var11.field1749 = this.field1749;
            var11.field1751 = this.field1751;
            var11.field1752 = this.field1752;
            var11.field1753 = this.field1753;
            var11.field1780 = this.field1780;
            var11.field1755 = this.field1755;
            var11.field1756 = this.field1756;
            var11.field1782 = this.field1782;
            var11.field1758 = this.field1758;
            var11.field1750 = this.field1750;
            var11.field1775 = this.field1775;
            var11.field1762 = this.field1762;
            var11.field1763 = this.field1763;
            var11.field1784 = this.field1784;
            var11.field1765 = this.field1765;
            var11.field1759 = this.field1759;
            var11.field1766 = this.field1766;
            var11.field1777 = this.field1777;
            var11.field1769 = this.field1769;
            var11.field1760 = this.field1760;
            var11.field1770 = this.field1770;
            var11.field1771 = this.field1771;
            var11.field1773 = this.field1773;
            var11.field1774 = this.field1774;
            var11.field1772 = this.field1772;
            var11.field1776 = this.field1776;
            var11.field1779 = this.field1779;
            var11.field1791 = this.field1791;
            var11.field1748 = new int[var11.field1761];
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
               for(var12 = 0; var12 < var11.field1761; ++var12) {
                  var13 = this.field1747[var12] + var2;
                  var14 = this.field1749[var12] + var4;
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var1[var17 + 1][var18 + 1] * var15 >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.field1748[var12] = this.field1748[var12] + var21 - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1761; ++var12) {
                  var13 = (-this.field1748[var12] << 16) / super.modelHeight;
                  if(var13 < var6) {
                     var14 = this.field1747[var12] + var2;
                     var15 = this.field1749[var12] + var4;
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var1[var18 + 1][var19 + 1] * var16 >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.field1748[var12] = this.field1748[var12] + (var22 - var3) * (var6 - var13) / var6;
                  }
               }
            }

            var11.method2276();
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("u")
   public void method2280() {
      for(int var1 = 0; var1 < this.field1761; ++var1) {
         int var2 = this.field1747[var1];
         this.field1747[var1] = this.field1749[var1];
         this.field1749[var1] = -var2;
      }

      this.method2276();
   }

   @ObfuscatedName("h")
   public void method2281() {
      for(int var1 = 0; var1 < this.field1761; ++var1) {
         this.field1747[var1] = -this.field1747[var1];
         this.field1749[var1] = -this.field1749[var1];
      }

      this.method2276();
   }

   @ObfuscatedName("l")
   public void method2282() {
      for(int var1 = 0; var1 < this.field1761; ++var1) {
         int var2 = this.field1749[var1];
         this.field1749[var1] = this.field1747[var1];
         this.field1747[var1] = -var2;
      }

      this.method2276();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "256"
   )
   public void method2283(int var1) {
      int var2 = field1764[var1];
      int var3 = field1792[var1];

      for(int var4 = 0; var4 < this.field1761; ++var4) {
         int var5 = this.field1749[var4] * var2 + this.field1747[var4] * var3 >> 16;
         this.field1749[var4] = this.field1749[var4] * var3 - this.field1747[var4] * var2 >> 16;
         this.field1747[var4] = var5;
      }

      this.method2276();
   }

   @ObfuscatedName("e")
   public void method2285(short var1, short var2) {
      for(int var3 = 0; var3 < this.field1767; ++var3) {
         if(this.field1758[var3] == var1) {
            this.field1758[var3] = var2;
         }
      }

   }

   @ObfuscatedName("p")
   public void method2286(short var1, short var2) {
      if(this.field1750 != null) {
         for(int var3 = 0; var3 < this.field1767; ++var3) {
            if(this.field1750[var3] == var1) {
               this.field1750[var3] = var2;
            }
         }

      }
   }

   @ObfuscatedName("a")
   public void method2287() {
      int var1;
      for(var1 = 0; var1 < this.field1761; ++var1) {
         this.field1749[var1] = -this.field1749[var1];
      }

      for(var1 = 0; var1 < this.field1767; ++var1) {
         int var2 = this.field1751[var1];
         this.field1751[var1] = this.field1753[var1];
         this.field1753[var1] = var2;
      }

      this.method2276();
   }

   @ObfuscatedName("z")
   @Export("computeNormals")
   public void computeNormals() {
      if(this.field1778 == null) {
         this.field1778 = new VertexNormal[this.field1761];

         int var1;
         for(var1 = 0; var1 < this.field1761; ++var1) {
            this.field1778[var1] = new VertexNormal();
         }

         for(var1 = 0; var1 < this.field1767; ++var1) {
            int var2 = this.field1751[var1];
            int var3 = this.field1752[var1];
            int var4 = this.field1753[var1];
            int var5 = this.field1747[var3] - this.field1747[var2];
            int var6 = this.field1748[var3] - this.field1748[var2];
            int var7 = this.field1749[var3] - this.field1749[var2];
            int var8 = this.field1747[var4] - this.field1747[var2];
            int var9 = this.field1748[var4] - this.field1748[var2];
            int var10 = this.field1749[var4] - this.field1749[var2];
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
            if(this.field1780 == null) {
               var15 = 0;
            } else {
               var15 = this.field1780[var1];
            }

            if(var15 == 0) {
               VertexNormal var16 = this.field1778[var2];
               var16.field1698 += var11;
               var16.field1691 += var12;
               var16.field1697 += var13;
               ++var16.field1692;
               var16 = this.field1778[var3];
               var16.field1698 += var11;
               var16.field1691 += var12;
               var16.field1697 += var13;
               ++var16.field1692;
               var16 = this.field1778[var4];
               var16.field1698 += var11;
               var16.field1691 += var12;
               var16.field1697 += var13;
               ++var16.field1692;
            } else if(var15 == 1) {
               if(this.field1757 == null) {
                  this.field1757 = new FaceNormal[this.field1767];
               }

               FaceNormal var17 = this.field1757[var1] = new FaceNormal();
               var17.field1511 = var11;
               var17.field1512 = var12;
               var17.field1515 = var13;
            }
         }

      }
   }

   @ObfuscatedName("t")
   static void method2292(ModelData var0, ModelData var1, int var2, int var3, int var4, boolean var5) {
      var0.method2343();
      var0.computeNormals();
      var1.method2343();
      var1.computeNormals();
      ++field1790;
      int var6 = 0;
      int[] var7 = var1.field1747;
      int var8 = var1.field1761;

      int var9;
      for(var9 = 0; var9 < var0.field1761; ++var9) {
         VertexNormal var10 = var0.field1778[var9];
         if(var10.field1692 != 0) {
            int var11 = var0.field1748[var9] - var3;
            if(var11 <= var1.field1783) {
               int var12 = var0.field1747[var9] - var2;
               if(var12 >= var1.field1754 && var12 <= var1.field1746) {
                  int var13 = var0.field1749[var9] - var4;
                  if(var13 >= var1.field1787 && var13 <= var1.field1786) {
                     for(int var14 = 0; var14 < var8; ++var14) {
                        VertexNormal var15 = var1.field1778[var14];
                        if(var12 == var7[var14] && var13 == var1.field1749[var14] && var11 == var1.field1748[var14] && var15.field1692 != 0) {
                           if(var0.field1781 == null) {
                              var0.field1781 = new VertexNormal[var0.field1761];
                           }

                           if(var1.field1781 == null) {
                              var1.field1781 = new VertexNormal[var8];
                           }

                           VertexNormal var16 = var0.field1781[var9];
                           if(var16 == null) {
                              var16 = var0.field1781[var9] = new VertexNormal(var10);
                           }

                           VertexNormal var17 = var1.field1781[var14];
                           if(var17 == null) {
                              var17 = var1.field1781[var14] = new VertexNormal(var15);
                           }

                           var16.field1698 += var15.field1698;
                           var16.field1691 += var15.field1691;
                           var16.field1697 += var15.field1697;
                           var16.field1692 += var15.field1692;
                           var17.field1698 += var10.field1698;
                           var17.field1691 += var10.field1691;
                           var17.field1697 += var10.field1697;
                           var17.field1692 += var10.field1692;
                           ++var6;
                           field1788[var9] = field1790;
                           field1789[var14] = field1790;
                        }
                     }
                  }
               }
            }
         }
      }

      if(var6 >= 3 && var5) {
         for(var9 = 0; var9 < var0.field1767; ++var9) {
            if(field1788[var0.field1751[var9]] == field1790 && field1788[var0.field1752[var9]] == field1790 && field1788[var0.field1753[var9]] == field1790) {
               if(var0.field1780 == null) {
                  var0.field1780 = new byte[var0.field1767];
               }

               var0.field1780[var9] = 2;
            }
         }

         for(var9 = 0; var9 < var1.field1767; ++var9) {
            if(field1789[var1.field1751[var9]] == field1790 && field1789[var1.field1752[var9]] == field1790 && field1789[var1.field1753[var9]] == field1790) {
               if(var1.field1780 == null) {
                  var1.field1780 = new byte[var1.field1767];
               }

               var1.field1780[var9] = 2;
            }
         }

      }
   }

   @ObfuscatedName("o")
   public final Model method2293(int var1, int var2, int var3, int var4, int var5) {
      this.computeNormals();
      int var6 = (int)Math.sqrt((double)(var3 * var3 + var4 * var4 + var5 * var5));
      int var7 = var2 * var6 >> 8;
      Model var8 = new Model();
      var8.field1871 = new int[this.field1767];
      var8.field1870 = new int[this.field1767];
      var8.field1890 = new int[this.field1767];
      if(this.field1785 > 0 && this.field1782 != null) {
         int[] var16 = new int[this.field1785];

         int var10;
         for(var10 = 0; var10 < this.field1767; ++var10) {
            if(this.field1782[var10] != -1) {
               ++var16[this.field1782[var10] & 255];
            }
         }

         var8.field1877 = 0;

         for(var10 = 0; var10 < this.field1785; ++var10) {
            if(var16[var10] > 0 && this.field1762[var10] == 0) {
               ++var8.field1877;
            }
         }

         var8.field1888 = new int[var8.field1877];
         var8.field1879 = new int[var8.field1877];
         var8.field1880 = new int[var8.field1877];
         var10 = 0;

         int var11;
         for(var11 = 0; var11 < this.field1785; ++var11) {
            if(var16[var11] > 0 && this.field1762[var11] == 0) {
               var8.field1888[var10] = this.field1763[var11] & '\uffff';
               var8.field1879[var10] = this.field1784[var11] & '\uffff';
               var8.field1880[var10] = this.field1765[var11] & '\uffff';
               var16[var11] = var10++;
            } else {
               var16[var11] = -1;
            }
         }

         var8.field1913 = new byte[this.field1767];

         for(var11 = 0; var11 < this.field1767; ++var11) {
            if(this.field1782[var11] != -1) {
               var8.field1913[var11] = (byte)var16[this.field1782[var11] & 255];
            } else {
               var8.field1913[var11] = -1;
            }
         }
      }

      for(int var9 = 0; var9 < this.field1767; ++var9) {
         byte var17;
         if(this.field1780 == null) {
            var17 = 0;
         } else {
            var17 = this.field1780[var9];
         }

         byte var18;
         if(this.field1756 == null) {
            var18 = 0;
         } else {
            var18 = this.field1756[var9];
         }

         short var12;
         if(this.field1750 == null) {
            var12 = -1;
         } else {
            var12 = this.field1750[var9];
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
                  var19 = this.field1757[var9];
                  var14 = var1 + (var3 * var19.field1511 + var4 * var19.field1512 + var5 * var19.field1515) / (var7 + var7 / 2);
                  var8.field1871[var9] = method2294(this.field1758[var9] & '\uffff', var14);
                  var8.field1890[var9] = -1;
               } else if(var17 == 3) {
                  var8.field1871[var9] = 128;
                  var8.field1890[var9] = -1;
               } else {
                  var8.field1890[var9] = -2;
               }
            } else {
               int var15 = this.field1758[var9] & '\uffff';
               if(this.field1781 != null && this.field1781[this.field1751[var9]] != null) {
                  var13 = this.field1781[this.field1751[var9]];
               } else {
                  var13 = this.field1778[this.field1751[var9]];
               }

               var14 = var1 + (var3 * var13.field1698 + var4 * var13.field1691 + var5 * var13.field1697) / (var7 * var13.field1692);
               var8.field1871[var9] = method2294(var15, var14);
               if(this.field1781 != null && this.field1781[this.field1752[var9]] != null) {
                  var13 = this.field1781[this.field1752[var9]];
               } else {
                  var13 = this.field1778[this.field1752[var9]];
               }

               var14 = var1 + (var3 * var13.field1698 + var4 * var13.field1691 + var5 * var13.field1697) / (var7 * var13.field1692);
               var8.field1870[var9] = method2294(var15, var14);
               if(this.field1781 != null && this.field1781[this.field1753[var9]] != null) {
                  var13 = this.field1781[this.field1753[var9]];
               } else {
                  var13 = this.field1778[this.field1753[var9]];
               }

               var14 = var1 + (var3 * var13.field1698 + var4 * var13.field1691 + var5 * var13.field1697) / (var7 * var13.field1692);
               var8.field1890[var9] = method2294(var15, var14);
            }
         } else if(var17 != 0) {
            if(var17 == 1) {
               var19 = this.field1757[var9];
               var14 = var1 + (var3 * var19.field1511 + var4 * var19.field1512 + var5 * var19.field1515) / (var7 + var7 / 2);
               var8.field1871[var9] = method2295(var14);
               var8.field1890[var9] = -1;
            } else {
               var8.field1890[var9] = -2;
            }
         } else {
            if(this.field1781 != null && this.field1781[this.field1751[var9]] != null) {
               var13 = this.field1781[this.field1751[var9]];
            } else {
               var13 = this.field1778[this.field1751[var9]];
            }

            var14 = var1 + (var3 * var13.field1698 + var4 * var13.field1691 + var5 * var13.field1697) / (var7 * var13.field1692);
            var8.field1871[var9] = method2295(var14);
            if(this.field1781 != null && this.field1781[this.field1752[var9]] != null) {
               var13 = this.field1781[this.field1752[var9]];
            } else {
               var13 = this.field1778[this.field1752[var9]];
            }

            var14 = var1 + (var3 * var13.field1698 + var4 * var13.field1691 + var5 * var13.field1697) / (var7 * var13.field1692);
            var8.field1870[var9] = method2295(var14);
            if(this.field1781 != null && this.field1781[this.field1753[var9]] != null) {
               var13 = this.field1781[this.field1753[var9]];
            } else {
               var13 = this.field1778[this.field1753[var9]];
            }

            var14 = var1 + (var3 * var13.field1698 + var4 * var13.field1691 + var5 * var13.field1697) / (var7 * var13.field1692);
            var8.field1890[var9] = method2295(var14);
         }
      }

      this.computeAnimationTables();
      var8.field1861 = this.field1761;
      var8.verticesX = this.field1747;
      var8.verticesY = this.field1748;
      var8.verticesZ = this.field1749;
      var8.field1865 = this.field1767;
      var8.indices1 = this.field1751;
      var8.indices2 = this.field1752;
      var8.indices3 = this.field1753;
      var8.field1872 = this.field1755;
      var8.field1873 = this.field1756;
      var8.field1876 = this.field1775;
      var8.field1881 = this.field1772;
      var8.field1869 = this.field1776;
      var8.field1875 = this.field1750;
      return var8;
   }

   @ObfuscatedName("aq")
   static final int method2294(int var0, int var1) {
      var1 = var1 * (var0 & 127) >> 7;
      if(var1 < 2) {
         var1 = 2;
      } else if(var1 > 126) {
         var1 = 126;
      }

      return (var0 & 'ﾀ') + var1;
   }

   @ObfuscatedName("al")
   static final int method2295(int var0) {
      if(var0 < 2) {
         var0 = 2;
      } else if(var0 > 126) {
         var0 = 126;
      }

      return var0;
   }

   @ObfuscatedName("q")
   void method2308(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      Buffer var3 = new Buffer(var1);
      Buffer var4 = new Buffer(var1);
      Buffer var5 = new Buffer(var1);
      Buffer var6 = new Buffer(var1);
      Buffer var7 = new Buffer(var1);
      Buffer var8 = new Buffer(var1);
      var2.offset = var1.length - 23;
      int var9 = var2.method2691();
      int var10 = var2.method2691();
      int var11 = var2.method2571();
      int var12 = var2.method2571();
      int var13 = var2.method2571();
      int var14 = var2.method2571();
      int var15 = var2.method2571();
      int var16 = var2.method2571();
      int var17 = var2.method2571();
      int var18 = var2.method2691();
      int var19 = var2.method2691();
      int var20 = var2.method2691();
      int var21 = var2.method2691();
      int var22 = var2.method2691();
      int var23 = 0;
      int var24 = 0;
      int var25 = 0;
      int var26;
      if(var11 > 0) {
         this.field1762 = new byte[var11];
         var2.offset = 0;

         for(var26 = 0; var26 < var11; ++var26) {
            byte var27 = this.field1762[var26] = var2.method2572();
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
      this.field1761 = var9;
      this.field1767 = var10;
      this.field1785 = var11;
      this.field1747 = new int[var9];
      this.field1748 = new int[var9];
      this.field1749 = new int[var9];
      this.field1751 = new int[var10];
      this.field1752 = new int[var10];
      this.field1753 = new int[var10];
      if(var17 == 1) {
         this.field1773 = new int[var9];
      }

      if(var12 == 1) {
         this.field1780 = new byte[var10];
      }

      if(var13 == 255) {
         this.field1755 = new byte[var10];
      } else {
         this.field1775 = (byte)var13;
      }

      if(var14 == 1) {
         this.field1756 = new byte[var10];
      }

      if(var15 == 1) {
         this.field1774 = new int[var10];
      }

      if(var16 == 1) {
         this.field1750 = new short[var10];
      }

      if(var16 == 1 && var11 > 0) {
         this.field1782 = new byte[var10];
      }

      this.field1758 = new short[var10];
      if(var11 > 0) {
         this.field1763 = new short[var11];
         this.field1784 = new short[var11];
         this.field1765 = new short[var11];
         if(var24 > 0) {
            this.field1759 = new short[var24];
            this.field1766 = new short[var24];
            this.field1777 = new short[var24];
            this.field1769 = new short[var24];
            this.field1760 = new byte[var24];
            this.field1770 = new short[var24];
         }

         if(var25 > 0) {
            this.field1771 = new short[var25];
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
         var52 = var2.method2571();
         var53 = 0;
         if((var52 & 1) != 0) {
            var53 = var3.method2583();
         }

         var54 = 0;
         if((var52 & 2) != 0) {
            var54 = var4.method2583();
         }

         var55 = 0;
         if((var52 & 4) != 0) {
            var55 = var5.method2583();
         }

         this.field1747[var51] = var48 + var53;
         this.field1748[var51] = var49 + var54;
         this.field1749[var51] = var50 + var55;
         var48 = this.field1747[var51];
         var49 = this.field1748[var51];
         var50 = this.field1749[var51];
         if(var17 == 1) {
            this.field1773[var51] = var6.method2571();
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
         this.field1758[var51] = (short)var2.method2691();
         if(var12 == 1) {
            this.field1780[var51] = var3.method2572();
         }

         if(var13 == 255) {
            this.field1755[var51] = var4.method2572();
         }

         if(var14 == 1) {
            this.field1756[var51] = var5.method2572();
         }

         if(var15 == 1) {
            this.field1774[var51] = var6.method2571();
         }

         if(var16 == 1) {
            this.field1750[var51] = (short)(var7.method2691() - 1);
         }

         if(this.field1782 != null && this.field1750[var51] != -1) {
            this.field1782[var51] = (byte)(var8.method2571() - 1);
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
         var56 = var3.method2571();
         if(var56 == 1) {
            var51 = var2.method2583() + var54;
            var52 = var2.method2583() + var51;
            var53 = var2.method2583() + var52;
            var54 = var53;
            this.field1751[var55] = var51;
            this.field1752[var55] = var52;
            this.field1753[var55] = var53;
         }

         if(var56 == 2) {
            var52 = var53;
            var53 = var2.method2583() + var54;
            var54 = var53;
            this.field1751[var55] = var51;
            this.field1752[var55] = var52;
            this.field1753[var55] = var53;
         }

         if(var56 == 3) {
            var51 = var53;
            var53 = var2.method2583() + var54;
            var54 = var53;
            this.field1751[var55] = var51;
            this.field1752[var55] = var52;
            this.field1753[var55] = var53;
         }

         if(var56 == 4) {
            int var57 = var51;
            var51 = var52;
            var52 = var57;
            var53 = var2.method2583() + var54;
            var54 = var53;
            this.field1751[var55] = var51;
            this.field1752[var55] = var57;
            this.field1753[var55] = var53;
         }
      }

      var2.offset = var41;
      var3.offset = var42;
      var4.offset = var43;
      var5.offset = var44;
      var6.offset = var45;
      var7.offset = var46;

      for(var55 = 0; var55 < var11; ++var55) {
         var56 = this.field1762[var55] & 255;
         if(var56 == 0) {
            this.field1763[var55] = (short)var2.method2691();
            this.field1784[var55] = (short)var2.method2691();
            this.field1765[var55] = (short)var2.method2691();
         }

         if(var56 == 1) {
            this.field1763[var55] = (short)var3.method2691();
            this.field1784[var55] = (short)var3.method2691();
            this.field1765[var55] = (short)var3.method2691();
            this.field1759[var55] = (short)var4.method2691();
            this.field1766[var55] = (short)var4.method2691();
            this.field1777[var55] = (short)var4.method2691();
            this.field1769[var55] = (short)var5.method2691();
            this.field1760[var55] = var6.method2572();
            this.field1770[var55] = (short)var7.method2691();
         }

         if(var56 == 2) {
            this.field1763[var55] = (short)var3.method2691();
            this.field1784[var55] = (short)var3.method2691();
            this.field1765[var55] = (short)var3.method2691();
            this.field1759[var55] = (short)var4.method2691();
            this.field1766[var55] = (short)var4.method2691();
            this.field1777[var55] = (short)var4.method2691();
            this.field1769[var55] = (short)var5.method2691();
            this.field1760[var55] = var6.method2572();
            this.field1770[var55] = (short)var7.method2691();
            this.field1771[var55] = (short)var7.method2691();
         }

         if(var56 == 3) {
            this.field1763[var55] = (short)var3.method2691();
            this.field1784[var55] = (short)var3.method2691();
            this.field1765[var55] = (short)var3.method2691();
            this.field1759[var55] = (short)var4.method2691();
            this.field1766[var55] = (short)var4.method2691();
            this.field1777[var55] = (short)var4.method2691();
            this.field1769[var55] = (short)var5.method2691();
            this.field1760[var55] = var6.method2572();
            this.field1770[var55] = (short)var7.method2691();
         }
      }

      var2.offset = var26;
      var55 = var2.method2571();
      if(var55 != 0) {
         new class93();
         var2.method2691();
         var2.method2691();
         var2.method2691();
         var2.method2576();
      }

   }

   @ObfuscatedName("v")
   final int method2326(ModelData var1, int var2) {
      int var3 = -1;
      int var4 = var1.field1747[var2];
      int var5 = var1.field1748[var2];
      int var6 = var1.field1749[var2];

      for(int var7 = 0; var7 < this.field1761; ++var7) {
         if(var4 == this.field1747[var7] && var5 == this.field1748[var7] && var6 == this.field1749[var7]) {
            var3 = var7;
            break;
         }
      }

      if(var3 == -1) {
         this.field1747[this.field1761] = var4;
         this.field1748[this.field1761] = var5;
         this.field1749[this.field1761] = var6;
         if(var1.field1773 != null) {
            this.field1773[this.field1761] = var1.field1773[var2];
         }

         var3 = this.field1761++;
      }

      return var3;
   }

   static {
      field1764 = class94.field1650;
      field1792 = class94.field1651;
   }

   @ObfuscatedName("n")
   public void method2340(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1761; ++var4) {
         this.field1747[var4] = this.field1747[var4] * var1 / 128;
         this.field1748[var4] = this.field1748[var4] * var2 / 128;
         this.field1749[var4] = this.field1749[var4] * var3 / 128;
      }

      this.method2276();
   }

   @ObfuscatedName("d")
   void method2343() {
      if(!this.field1768) {
         super.modelHeight = 0;
         this.field1783 = 0;
         this.field1754 = 999999;
         this.field1746 = -999999;
         this.field1786 = -99999;
         this.field1787 = 99999;

         for(int var1 = 0; var1 < this.field1761; ++var1) {
            int var2 = this.field1747[var1];
            int var3 = this.field1748[var1];
            int var4 = this.field1749[var1];
            if(var2 < this.field1754) {
               this.field1754 = var2;
            }

            if(var2 > this.field1746) {
               this.field1746 = var2;
            }

            if(var4 < this.field1787) {
               this.field1787 = var4;
            }

            if(var4 > this.field1786) {
               this.field1786 = var4;
            }

            if(-var3 > super.modelHeight) {
               super.modelHeight = -var3;
            }

            if(var3 > this.field1783) {
               this.field1783 = var3;
            }
         }

         this.field1768 = true;
      }
   }

   @ObfuscatedName("y")
   @Export("computeAnimationTables")
   void computeAnimationTables() {
      int[] var1;
      int var2;
      int var3;
      int var4;
      if(this.field1773 != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.field1761; ++var3) {
            var4 = this.field1773[var3];
            ++var1[var4];
            if(var4 > var2) {
               var2 = var4;
            }
         }

         this.field1772 = new int[var2 + 1][];

         for(var3 = 0; var3 <= var2; ++var3) {
            this.field1772[var3] = new int[var1[var3]];
            var1[var3] = 0;
         }

         for(var3 = 0; var3 < this.field1761; this.field1772[var4][var1[var4]++] = var3++) {
            var4 = this.field1773[var3];
         }

         this.field1773 = null;
      }

      if(this.field1774 != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.field1767; ++var3) {
            var4 = this.field1774[var3];
            ++var1[var4];
            if(var4 > var2) {
               var2 = var4;
            }
         }

         this.field1776 = new int[var2 + 1][];

         for(var3 = 0; var3 <= var2; ++var3) {
            this.field1776[var3] = new int[var1[var3]];
            var1[var3] = 0;
         }

         for(var3 = 0; var3 < this.field1767; this.field1776[var4][var1[var4]++] = var3++) {
            var4 = this.field1774[var3];
         }

         this.field1774 = null;
      }

   }

   @ObfuscatedName("c")
   void method2350(byte[] var1) {
      boolean var2 = false;
      boolean var3 = false;
      Buffer var4 = new Buffer(var1);
      Buffer var5 = new Buffer(var1);
      Buffer var6 = new Buffer(var1);
      Buffer var7 = new Buffer(var1);
      Buffer var8 = new Buffer(var1);
      var4.offset = var1.length - 18;
      int var9 = var4.method2691();
      int var10 = var4.method2691();
      int var11 = var4.method2571();
      int var12 = var4.method2571();
      int var13 = var4.method2571();
      int var14 = var4.method2571();
      int var15 = var4.method2571();
      int var16 = var4.method2571();
      int var17 = var4.method2691();
      int var18 = var4.method2691();
      int var19 = var4.method2691();
      int var20 = var4.method2691();
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
      this.field1761 = var9;
      this.field1767 = var10;
      this.field1785 = var11;
      this.field1747 = new int[var9];
      this.field1748 = new int[var9];
      this.field1749 = new int[var9];
      this.field1751 = new int[var10];
      this.field1752 = new int[var10];
      this.field1753 = new int[var10];
      if(var11 > 0) {
         this.field1762 = new byte[var11];
         this.field1763 = new short[var11];
         this.field1784 = new short[var11];
         this.field1765 = new short[var11];
      }

      if(var16 == 1) {
         this.field1773 = new int[var9];
      }

      if(var12 == 1) {
         this.field1780 = new byte[var10];
         this.field1782 = new byte[var10];
         this.field1750 = new short[var10];
      }

      if(var13 == 255) {
         this.field1755 = new byte[var10];
      } else {
         this.field1775 = (byte)var13;
      }

      if(var14 == 1) {
         this.field1756 = new byte[var10];
      }

      if(var15 == 1) {
         this.field1774 = new int[var10];
      }

      this.field1758 = new short[var10];
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
         var39 = var4.method2571();
         var40 = 0;
         if((var39 & 1) != 0) {
            var40 = var5.method2583();
         }

         var41 = 0;
         if((var39 & 2) != 0) {
            var41 = var6.method2583();
         }

         var42 = 0;
         if((var39 & 4) != 0) {
            var42 = var7.method2583();
         }

         this.field1747[var38] = var35 + var40;
         this.field1748[var38] = var36 + var41;
         this.field1749[var38] = var37 + var42;
         var35 = this.field1747[var38];
         var36 = this.field1748[var38];
         var37 = this.field1749[var38];
         if(var16 == 1) {
            this.field1773[var38] = var8.method2571();
         }
      }

      var4.offset = var30;
      var5.offset = var26;
      var6.offset = var24;
      var7.offset = var28;
      var8.offset = var25;

      for(var38 = 0; var38 < var10; ++var38) {
         this.field1758[var38] = (short)var4.method2691();
         if(var12 == 1) {
            var39 = var5.method2571();
            if((var39 & 1) == 1) {
               this.field1780[var38] = 1;
               var2 = true;
            } else {
               this.field1780[var38] = 0;
            }

            if((var39 & 2) == 2) {
               this.field1782[var38] = (byte)(var39 >> 2);
               this.field1750[var38] = this.field1758[var38];
               this.field1758[var38] = 127;
               if(this.field1750[var38] != -1) {
                  var3 = true;
               }
            } else {
               this.field1782[var38] = -1;
               this.field1750[var38] = -1;
            }
         }

         if(var13 == 255) {
            this.field1755[var38] = var6.method2572();
         }

         if(var14 == 1) {
            this.field1756[var38] = var7.method2572();
         }

         if(var15 == 1) {
            this.field1774[var38] = var8.method2571();
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
         var43 = var5.method2571();
         if(var43 == 1) {
            var38 = var4.method2583() + var41;
            var39 = var4.method2583() + var38;
            var40 = var4.method2583() + var39;
            var41 = var40;
            this.field1751[var42] = var38;
            this.field1752[var42] = var39;
            this.field1753[var42] = var40;
         }

         if(var43 == 2) {
            var39 = var40;
            var40 = var4.method2583() + var41;
            var41 = var40;
            this.field1751[var42] = var38;
            this.field1752[var42] = var39;
            this.field1753[var42] = var40;
         }

         if(var43 == 3) {
            var38 = var40;
            var40 = var4.method2583() + var41;
            var41 = var40;
            this.field1751[var42] = var38;
            this.field1752[var42] = var39;
            this.field1753[var42] = var40;
         }

         if(var43 == 4) {
            var44 = var38;
            var38 = var39;
            var39 = var44;
            var40 = var4.method2583() + var41;
            var41 = var40;
            this.field1751[var42] = var38;
            this.field1752[var42] = var44;
            this.field1753[var42] = var40;
         }
      }

      var4.offset = var31;

      for(var42 = 0; var42 < var11; ++var42) {
         this.field1762[var42] = 0;
         this.field1763[var42] = (short)var4.method2691();
         this.field1784[var42] = (short)var4.method2691();
         this.field1765[var42] = (short)var4.method2691();
      }

      if(this.field1782 != null) {
         boolean var46 = false;

         for(var43 = 0; var43 < var10; ++var43) {
            var44 = this.field1782[var43] & 255;
            if(var44 != 255) {
               if((this.field1763[var44] & '\uffff') == this.field1751[var43] && (this.field1784[var44] & '\uffff') == this.field1752[var43] && (this.field1765[var44] & '\uffff') == this.field1753[var43]) {
                  this.field1782[var43] = -1;
               } else {
                  var46 = true;
               }
            }
         }

         if(!var46) {
            this.field1782 = null;
         }
      }

      if(!var3) {
         this.field1750 = null;
      }

      if(!var2) {
         this.field1780 = null;
      }

   }
}
