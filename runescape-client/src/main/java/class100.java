import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
public class class100 extends class85 {
   @ObfuscatedName("az")
   boolean field1668 = false;
   @ObfuscatedName("c")
   int[] field1669;
   @ObfuscatedName("m")
   int[] field1670;
   @ObfuscatedName("z")
   int[] field1671;
   @ObfuscatedName("n")
   byte[] field1672;
   @ObfuscatedName("e")
   int[] field1673;
   @ObfuscatedName("v")
   short[] field1674;
   @ObfuscatedName("d")
   short[] field1675;
   @ObfuscatedName("g")
   short[] field1676;
   @ObfuscatedName("l")
   byte[] field1677;
   @ObfuscatedName("u")
   byte[] field1678;
   @ObfuscatedName("r")
   byte[] field1679;
   @ObfuscatedName("i")
   int[] field1680;
   @ObfuscatedName("a")
   short[] field1681;
   @ObfuscatedName("p")
   byte field1682 = 0;
   @ObfuscatedName("q")
   int field1683;
   @ObfuscatedName("w")
   short[] field1684;
   @ObfuscatedName("t")
   short[] field1685;
   @ObfuscatedName("y")
   short[] field1686;
   @ObfuscatedName("aq")
   int[] field1687;
   @ObfuscatedName("am")
   int[][] field1688;
   @ObfuscatedName("b")
   byte[] field1689;
   @ObfuscatedName("k")
   short[] field1690;
   @ObfuscatedName("o")
   short[] field1691;
   @ObfuscatedName("ab")
   int[] field1692;
   @ObfuscatedName("f")
   short[] field1693;
   @ObfuscatedName("au")
   byte[] field1694;
   @ObfuscatedName("ac")
   static int[] field1695;
   @ObfuscatedName("ax")
   int field1696;
   @ObfuscatedName("s")
   short[] field1697;
   @ObfuscatedName("an")
   int[][] field1698;
   @ObfuscatedName("aj")
   class84[] field1699;
   @ObfuscatedName("ay")
   class96[] field1700;
   @ObfuscatedName("ao")
   class96[] field1701;
   @ObfuscatedName("ag")
   public short field1702;
   @ObfuscatedName("as")
   public short field1703;
   @ObfuscatedName("h")
   int[] field1704;
   @ObfuscatedName("av")
   int field1705;
   @ObfuscatedName("j")
   int field1706 = 0;
   @ObfuscatedName("aa")
   int field1707;
   @ObfuscatedName("ah")
   int field1708;
   @ObfuscatedName("ai")
   int field1709;
   @ObfuscatedName("ae")
   static int[] field1710 = new int[10000];
   @ObfuscatedName("at")
   static int[] field1711 = new int[10000];
   @ObfuscatedName("ar")
   static int field1712 = 0;
   @ObfuscatedName("aw")
   static int[] field1713;
   @ObfuscatedName("x")
   int field1714 = 0;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass167;II)Lclass100;",
      garbageValue = "0"
   )
   public static class100 method2198(class167 var0, int var1, int var2) {
      byte[] var3 = var0.method3217(var1, var2);
      return var3 == null?null:new class100(var3);
   }

   class100(byte[] var1) {
      if(var1[var1.length - 1] == -1 && var1[var1.length - 2] == -1) {
         this.method2199(var1);
      } else {
         this.method2211(var1);
      }

   }

   @ObfuscatedName("h")
   void method2199(byte[] var1) {
      class119 var2 = new class119(var1);
      class119 var3 = new class119(var1);
      class119 var4 = new class119(var1);
      class119 var5 = new class119(var1);
      class119 var6 = new class119(var1);
      class119 var7 = new class119(var1);
      class119 var8 = new class119(var1);
      var2.field1971 = var1.length - 23;
      int var9 = var2.method2502();
      int var10 = var2.method2502();
      int var11 = var2.method2500();
      int var12 = var2.method2500();
      int var13 = var2.method2500();
      int var14 = var2.method2500();
      int var15 = var2.method2500();
      int var16 = var2.method2500();
      int var17 = var2.method2500();
      int var18 = var2.method2502();
      int var19 = var2.method2502();
      int var20 = var2.method2502();
      int var21 = var2.method2502();
      int var22 = var2.method2502();
      int var23 = 0;
      int var24 = 0;
      int var25 = 0;
      int var26;
      if(var11 > 0) {
         this.field1689 = new byte[var11];
         var2.field1971 = 0;

         for(var26 = 0; var26 < var11; ++var26) {
            byte var27 = this.field1689[var26] = var2.method2670();
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
      this.field1706 = var9;
      this.field1714 = var10;
      this.field1683 = var11;
      this.field1704 = new int[var9];
      this.field1670 = new int[var9];
      this.field1671 = new int[var9];
      this.field1673 = new int[var10];
      this.field1680 = new int[var10];
      this.field1669 = new int[var10];
      if(var17 == 1) {
         this.field1687 = new int[var9];
      }

      if(var12 == 1) {
         this.field1672 = new byte[var10];
      }

      if(var13 == 255) {
         this.field1677 = new byte[var10];
      } else {
         this.field1682 = (byte)var13;
      }

      if(var14 == 1) {
         this.field1678 = new byte[var10];
      }

      if(var15 == 1) {
         this.field1692 = new int[var10];
      }

      if(var16 == 1) {
         this.field1675 = new short[var10];
      }

      if(var16 == 1 && var11 > 0) {
         this.field1679 = new byte[var10];
      }

      this.field1681 = new short[var10];
      if(var11 > 0) {
         this.field1685 = new short[var11];
         this.field1686 = new short[var11];
         this.field1684 = new short[var11];
         if(var24 > 0) {
            this.field1676 = new short[var24];
            this.field1697 = new short[var24];
            this.field1690 = new short[var24];
            this.field1691 = new short[var24];
            this.field1694 = new byte[var24];
            this.field1674 = new short[var24];
         }

         if(var25 > 0) {
            this.field1693 = new short[var25];
         }
      }

      var2.field1971 = var11;
      var3.field1971 = var38;
      var4.field1971 = var39;
      var5.field1971 = var40;
      var6.field1971 = var32;
      int var48 = 0;
      int var49 = 0;
      int var50 = 0;

      int var51;
      int var52;
      int var53;
      int var54;
      int var55;
      for(var51 = 0; var51 < var9; ++var51) {
         var52 = var2.method2500();
         var53 = 0;
         if((var52 & 1) != 0) {
            var53 = var3.method2610();
         }

         var54 = 0;
         if((var52 & 2) != 0) {
            var54 = var4.method2610();
         }

         var55 = 0;
         if((var52 & 4) != 0) {
            var55 = var5.method2610();
         }

         this.field1704[var51] = var48 + var53;
         this.field1670[var51] = var49 + var54;
         this.field1671[var51] = var50 + var55;
         var48 = this.field1704[var51];
         var49 = this.field1670[var51];
         var50 = this.field1671[var51];
         if(var17 == 1) {
            this.field1687[var51] = var6.method2500();
         }
      }

      var2.field1971 = var37;
      var3.field1971 = var28;
      var4.field1971 = var30;
      var5.field1971 = var33;
      var6.field1971 = var31;
      var7.field1971 = var35;
      var8.field1971 = var36;

      for(var51 = 0; var51 < var10; ++var51) {
         this.field1681[var51] = (short)var2.method2502();
         if(var12 == 1) {
            this.field1672[var51] = var3.method2670();
         }

         if(var13 == 255) {
            this.field1677[var51] = var4.method2670();
         }

         if(var14 == 1) {
            this.field1678[var51] = var5.method2670();
         }

         if(var15 == 1) {
            this.field1692[var51] = var6.method2500();
         }

         if(var16 == 1) {
            this.field1675[var51] = (short)(var7.method2502() - 1);
         }

         if(this.field1679 != null && this.field1675[var51] != -1) {
            this.field1679[var51] = (byte)(var8.method2500() - 1);
         }
      }

      var2.field1971 = var34;
      var3.field1971 = var29;
      var51 = 0;
      var52 = 0;
      var53 = 0;
      var54 = 0;

      int var56;
      for(var55 = 0; var55 < var10; ++var55) {
         var56 = var3.method2500();
         if(var56 == 1) {
            var51 = var2.method2610() + var54;
            var52 = var2.method2610() + var51;
            var53 = var2.method2610() + var52;
            var54 = var53;
            this.field1673[var55] = var51;
            this.field1680[var55] = var52;
            this.field1669[var55] = var53;
         }

         if(var56 == 2) {
            var52 = var53;
            var53 = var2.method2610() + var54;
            var54 = var53;
            this.field1673[var55] = var51;
            this.field1680[var55] = var52;
            this.field1669[var55] = var53;
         }

         if(var56 == 3) {
            var51 = var53;
            var53 = var2.method2610() + var54;
            var54 = var53;
            this.field1673[var55] = var51;
            this.field1680[var55] = var52;
            this.field1669[var55] = var53;
         }

         if(var56 == 4) {
            int var57 = var51;
            var51 = var52;
            var52 = var57;
            var53 = var2.method2610() + var54;
            var54 = var53;
            this.field1673[var55] = var51;
            this.field1680[var55] = var57;
            this.field1669[var55] = var53;
         }
      }

      var2.field1971 = var41;
      var3.field1971 = var42;
      var4.field1971 = var43;
      var5.field1971 = var44;
      var6.field1971 = var45;
      var7.field1971 = var46;

      for(var55 = 0; var55 < var11; ++var55) {
         var56 = this.field1689[var55] & 255;
         if(var56 == 0) {
            this.field1685[var55] = (short)var2.method2502();
            this.field1686[var55] = (short)var2.method2502();
            this.field1684[var55] = (short)var2.method2502();
         }

         if(var56 == 1) {
            this.field1685[var55] = (short)var3.method2502();
            this.field1686[var55] = (short)var3.method2502();
            this.field1684[var55] = (short)var3.method2502();
            this.field1676[var55] = (short)var4.method2502();
            this.field1697[var55] = (short)var4.method2502();
            this.field1690[var55] = (short)var4.method2502();
            this.field1691[var55] = (short)var5.method2502();
            this.field1694[var55] = var6.method2670();
            this.field1674[var55] = (short)var7.method2502();
         }

         if(var56 == 2) {
            this.field1685[var55] = (short)var3.method2502();
            this.field1686[var55] = (short)var3.method2502();
            this.field1684[var55] = (short)var3.method2502();
            this.field1676[var55] = (short)var4.method2502();
            this.field1697[var55] = (short)var4.method2502();
            this.field1690[var55] = (short)var4.method2502();
            this.field1691[var55] = (short)var5.method2502();
            this.field1694[var55] = var6.method2670();
            this.field1674[var55] = (short)var7.method2502();
            this.field1693[var55] = (short)var7.method2502();
         }

         if(var56 == 3) {
            this.field1685[var55] = (short)var3.method2502();
            this.field1686[var55] = (short)var3.method2502();
            this.field1684[var55] = (short)var3.method2502();
            this.field1676[var55] = (short)var4.method2502();
            this.field1697[var55] = (short)var4.method2502();
            this.field1690[var55] = (short)var4.method2502();
            this.field1691[var55] = (short)var5.method2502();
            this.field1694[var55] = var6.method2670();
            this.field1674[var55] = (short)var7.method2502();
         }
      }

      var2.field1971 = var26;
      var55 = var2.method2500();
      if(var55 != 0) {
         new class90();
         var2.method2502();
         var2.method2502();
         var2.method2502();
         var2.method2505();
      }

   }

   @ObfuscatedName("t")
   public void method2200(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1706; ++var4) {
         this.field1704[var4] = this.field1704[var4] * var1 / 128;
         this.field1670[var4] = this.field1670[var4] * var2 / 128;
         this.field1671[var4] = this.field1671[var4] * var3 / 128;
      }

      this.method2228();
   }

   @ObfuscatedName("p")
   public void method2202(short var1, short var2) {
      for(int var3 = 0; var3 < this.field1714; ++var3) {
         if(this.field1681[var3] == var1) {
            this.field1681[var3] = var2;
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(Lclass100;ZZZZ)V",
      garbageValue = "1"
   )
   public class100(class100 var1, boolean var2, boolean var3, boolean var4, boolean var5) {
      this.field1706 = var1.field1706;
      this.field1714 = var1.field1714;
      this.field1683 = var1.field1683;
      this.field1704 = var1.field1704;
      this.field1670 = var1.field1670;
      this.field1671 = var1.field1671;
      this.field1681 = var1.field1681;
      this.field1675 = var1.field1675;
      this.field1678 = var1.field1678;
      this.field1673 = var1.field1673;
      this.field1680 = var1.field1680;
      this.field1669 = var1.field1669;
      this.field1672 = var1.field1672;
      this.field1677 = var1.field1677;
      this.field1679 = var1.field1679;
      this.field1682 = var1.field1682;
      this.field1689 = var1.field1689;
      this.field1685 = var1.field1685;
      this.field1686 = var1.field1686;
      this.field1684 = var1.field1684;
      this.field1676 = var1.field1676;
      this.field1697 = var1.field1697;
      this.field1690 = var1.field1690;
      this.field1691 = var1.field1691;
      this.field1694 = var1.field1694;
      this.field1674 = var1.field1674;
      this.field1693 = var1.field1693;
      this.field1687 = var1.field1687;
      this.field1692 = var1.field1692;
      this.field1688 = var1.field1688;
      this.field1698 = var1.field1698;
      this.field1700 = var1.field1700;
      this.field1699 = var1.field1699;
      this.field1701 = var1.field1701;
      this.field1702 = var1.field1702;
      this.field1703 = var1.field1703;
   }

   @ObfuscatedName("e")
   public class100 method2203() {
      class100 var1 = new class100();
      if(this.field1672 != null) {
         var1.field1672 = new byte[this.field1714];

         for(int var2 = 0; var2 < this.field1714; ++var2) {
            var1.field1672[var2] = this.field1672[var2];
         }
      }

      var1.field1706 = this.field1706;
      var1.field1714 = this.field1714;
      var1.field1683 = this.field1683;
      var1.field1704 = this.field1704;
      var1.field1670 = this.field1670;
      var1.field1671 = this.field1671;
      var1.field1673 = this.field1673;
      var1.field1680 = this.field1680;
      var1.field1669 = this.field1669;
      var1.field1677 = this.field1677;
      var1.field1678 = this.field1678;
      var1.field1679 = this.field1679;
      var1.field1681 = this.field1681;
      var1.field1675 = this.field1675;
      var1.field1682 = this.field1682;
      var1.field1689 = this.field1689;
      var1.field1685 = this.field1685;
      var1.field1686 = this.field1686;
      var1.field1684 = this.field1684;
      var1.field1676 = this.field1676;
      var1.field1697 = this.field1697;
      var1.field1690 = this.field1690;
      var1.field1691 = this.field1691;
      var1.field1694 = this.field1694;
      var1.field1674 = this.field1674;
      var1.field1693 = this.field1693;
      var1.field1687 = this.field1687;
      var1.field1692 = this.field1692;
      var1.field1688 = this.field1688;
      var1.field1698 = this.field1698;
      var1.field1700 = this.field1700;
      var1.field1699 = this.field1699;
      var1.field1702 = this.field1702;
      var1.field1703 = this.field1703;
      return var1;
   }

   @ObfuscatedName("g")
   void method2204() {
      if(!this.field1668) {
         super.field1443 = 0;
         this.field1705 = 0;
         this.field1696 = 999999;
         this.field1707 = -999999;
         this.field1708 = -99999;
         this.field1709 = 99999;

         for(int var1 = 0; var1 < this.field1706; ++var1) {
            int var2 = this.field1704[var1];
            int var3 = this.field1670[var1];
            int var4 = this.field1671[var1];
            if(var2 < this.field1696) {
               this.field1696 = var2;
            }

            if(var2 > this.field1707) {
               this.field1707 = var2;
            }

            if(var4 < this.field1709) {
               this.field1709 = var4;
            }

            if(var4 > this.field1708) {
               this.field1708 = var4;
            }

            if(-var3 > super.field1443) {
               super.field1443 = -var3;
            }

            if(var3 > this.field1705) {
               this.field1705 = var3;
            }
         }

         this.field1668 = true;
      }
   }

   @ObfuscatedName("c")
   void method2205() {
      int[] var1;
      int var2;
      int var3;
      int var4;
      if(this.field1687 != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.field1706; ++var3) {
            var4 = this.field1687[var3];
            ++var1[var4];
            if(var4 > var2) {
               var2 = var4;
            }
         }

         this.field1688 = new int[var2 + 1][];

         for(var3 = 0; var3 <= var2; ++var3) {
            this.field1688[var3] = new int[var1[var3]];
            var1[var3] = 0;
         }

         for(var3 = 0; var3 < this.field1706; this.field1688[var4][var1[var4]++] = var3++) {
            var4 = this.field1687[var3];
         }

         this.field1687 = null;
      }

      if(this.field1692 != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.field1714; ++var3) {
            var4 = this.field1692[var3];
            ++var1[var4];
            if(var4 > var2) {
               var2 = var4;
            }
         }

         this.field1698 = new int[var2 + 1][];

         for(var3 = 0; var3 <= var2; ++var3) {
            this.field1698[var3] = new int[var1[var3]];
            var1[var3] = 0;
         }

         for(var3 = 0; var3 < this.field1714; this.field1698[var4][var1[var4]++] = var3++) {
            var4 = this.field1692[var3];
         }

         this.field1692 = null;
      }

   }

   @ObfuscatedName("l")
   public void method2207() {
      for(int var1 = 0; var1 < this.field1706; ++var1) {
         this.field1704[var1] = -this.field1704[var1];
         this.field1671[var1] = -this.field1671[var1];
      }

      this.method2228();
   }

   @ObfuscatedName("u")
   public void method2208() {
      for(int var1 = 0; var1 < this.field1706; ++var1) {
         int var2 = this.field1671[var1];
         this.field1671[var1] = this.field1704[var1];
         this.field1704[var1] = -var2;
      }

      this.method2228();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "256"
   )
   public void method2209(int var1) {
      int var2 = field1713[var1];
      int var3 = field1695[var1];

      for(int var4 = 0; var4 < this.field1706; ++var4) {
         int var5 = this.field1671[var4] * var2 + this.field1704[var4] * var3 >> 16;
         this.field1671[var4] = this.field1671[var4] * var3 - this.field1704[var4] * var2 >> 16;
         this.field1704[var4] = var5;
      }

      this.method2228();
   }

   @ObfuscatedName("d")
   public void method2210(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1706; ++var4) {
         this.field1704[var4] += var1;
         this.field1670[var4] += var2;
         this.field1671[var4] += var3;
      }

      this.method2228();
   }

   @ObfuscatedName("z")
   void method2211(byte[] var1) {
      boolean var2 = false;
      boolean var3 = false;
      class119 var4 = new class119(var1);
      class119 var5 = new class119(var1);
      class119 var6 = new class119(var1);
      class119 var7 = new class119(var1);
      class119 var8 = new class119(var1);
      var4.field1971 = var1.length - 18;
      int var9 = var4.method2502();
      int var10 = var4.method2502();
      int var11 = var4.method2500();
      int var12 = var4.method2500();
      int var13 = var4.method2500();
      int var14 = var4.method2500();
      int var15 = var4.method2500();
      int var16 = var4.method2500();
      int var17 = var4.method2502();
      int var18 = var4.method2502();
      int var19 = var4.method2502();
      int var20 = var4.method2502();
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
      this.field1706 = var9;
      this.field1714 = var10;
      this.field1683 = var11;
      this.field1704 = new int[var9];
      this.field1670 = new int[var9];
      this.field1671 = new int[var9];
      this.field1673 = new int[var10];
      this.field1680 = new int[var10];
      this.field1669 = new int[var10];
      if(var11 > 0) {
         this.field1689 = new byte[var11];
         this.field1685 = new short[var11];
         this.field1686 = new short[var11];
         this.field1684 = new short[var11];
      }

      if(var16 == 1) {
         this.field1687 = new int[var9];
      }

      if(var12 == 1) {
         this.field1672 = new byte[var10];
         this.field1679 = new byte[var10];
         this.field1675 = new short[var10];
      }

      if(var13 == 255) {
         this.field1677 = new byte[var10];
      } else {
         this.field1682 = (byte)var13;
      }

      if(var14 == 1) {
         this.field1678 = new byte[var10];
      }

      if(var15 == 1) {
         this.field1692 = new int[var10];
      }

      this.field1681 = new short[var10];
      var4.field1971 = var21;
      var5.field1971 = var32;
      var6.field1971 = var33;
      var7.field1971 = var45;
      var8.field1971 = var27;
      int var35 = 0;
      int var36 = 0;
      int var37 = 0;

      int var38;
      int var39;
      int var40;
      int var41;
      int var42;
      for(var38 = 0; var38 < var9; ++var38) {
         var39 = var4.method2500();
         var40 = 0;
         if((var39 & 1) != 0) {
            var40 = var5.method2610();
         }

         var41 = 0;
         if((var39 & 2) != 0) {
            var41 = var6.method2610();
         }

         var42 = 0;
         if((var39 & 4) != 0) {
            var42 = var7.method2610();
         }

         this.field1704[var38] = var35 + var40;
         this.field1670[var38] = var36 + var41;
         this.field1671[var38] = var37 + var42;
         var35 = this.field1704[var38];
         var36 = this.field1670[var38];
         var37 = this.field1671[var38];
         if(var16 == 1) {
            this.field1687[var38] = var8.method2500();
         }
      }

      var4.field1971 = var30;
      var5.field1971 = var26;
      var6.field1971 = var24;
      var7.field1971 = var28;
      var8.field1971 = var25;

      for(var38 = 0; var38 < var10; ++var38) {
         this.field1681[var38] = (short)var4.method2502();
         if(var12 == 1) {
            var39 = var5.method2500();
            if((var39 & 1) == 1) {
               this.field1672[var38] = 1;
               var2 = true;
            } else {
               this.field1672[var38] = 0;
            }

            if((var39 & 2) == 2) {
               this.field1679[var38] = (byte)(var39 >> 2);
               this.field1675[var38] = this.field1681[var38];
               this.field1681[var38] = 127;
               if(this.field1675[var38] != -1) {
                  var3 = true;
               }
            } else {
               this.field1679[var38] = -1;
               this.field1675[var38] = -1;
            }
         }

         if(var13 == 255) {
            this.field1677[var38] = var6.method2670();
         }

         if(var14 == 1) {
            this.field1678[var38] = var7.method2670();
         }

         if(var15 == 1) {
            this.field1692[var38] = var8.method2500();
         }
      }

      var4.field1971 = var29;
      var5.field1971 = var23;
      var38 = 0;
      var39 = 0;
      var40 = 0;
      var41 = 0;

      int var43;
      int var44;
      for(var42 = 0; var42 < var10; ++var42) {
         var43 = var5.method2500();
         if(var43 == 1) {
            var38 = var4.method2610() + var41;
            var39 = var4.method2610() + var38;
            var40 = var4.method2610() + var39;
            var41 = var40;
            this.field1673[var42] = var38;
            this.field1680[var42] = var39;
            this.field1669[var42] = var40;
         }

         if(var43 == 2) {
            var39 = var40;
            var40 = var4.method2610() + var41;
            var41 = var40;
            this.field1673[var42] = var38;
            this.field1680[var42] = var39;
            this.field1669[var42] = var40;
         }

         if(var43 == 3) {
            var38 = var40;
            var40 = var4.method2610() + var41;
            var41 = var40;
            this.field1673[var42] = var38;
            this.field1680[var42] = var39;
            this.field1669[var42] = var40;
         }

         if(var43 == 4) {
            var44 = var38;
            var38 = var39;
            var39 = var44;
            var40 = var4.method2610() + var41;
            var41 = var40;
            this.field1673[var42] = var38;
            this.field1680[var42] = var44;
            this.field1669[var42] = var40;
         }
      }

      var4.field1971 = var31;

      for(var42 = 0; var42 < var11; ++var42) {
         this.field1689[var42] = 0;
         this.field1685[var42] = (short)var4.method2502();
         this.field1686[var42] = (short)var4.method2502();
         this.field1684[var42] = (short)var4.method2502();
      }

      if(this.field1679 != null) {
         boolean var46 = false;

         for(var43 = 0; var43 < var10; ++var43) {
            var44 = this.field1679[var43] & 255;
            if(var44 != 255) {
               if((this.field1685[var44] & '\uffff') == this.field1673[var43] && (this.field1686[var44] & '\uffff') == this.field1680[var43] && (this.field1684[var44] & '\uffff') == this.field1669[var43]) {
                  this.field1679[var43] = -1;
               } else {
                  var46 = true;
               }
            }
         }

         if(!var46) {
            this.field1679 = null;
         }
      }

      if(!var3) {
         this.field1675 = null;
      }

      if(!var2) {
         this.field1672 = null;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([[IIIIZI)Lclass100;",
      garbageValue = "1"
   )
   public class100 method2212(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2204();
      int var7 = var2 + this.field1696;
      int var8 = var2 + this.field1707;
      int var9 = var4 + this.field1709;
      int var10 = var4 + this.field1708;
      if(var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
         var7 >>= 7;
         var8 = var8 + 127 >> 7;
         var9 >>= 7;
         var10 = var10 + 127 >> 7;
         if(var1[var7][var9] == var3 && var1[var8][var9] == var3 && var1[var7][var10] == var3 && var1[var8][var10] == var3) {
            return this;
         } else {
            class100 var11 = new class100();
            var11.field1706 = this.field1706;
            var11.field1714 = this.field1714;
            var11.field1683 = this.field1683;
            var11.field1704 = this.field1704;
            var11.field1671 = this.field1671;
            var11.field1673 = this.field1673;
            var11.field1680 = this.field1680;
            var11.field1669 = this.field1669;
            var11.field1672 = this.field1672;
            var11.field1677 = this.field1677;
            var11.field1678 = this.field1678;
            var11.field1679 = this.field1679;
            var11.field1681 = this.field1681;
            var11.field1675 = this.field1675;
            var11.field1682 = this.field1682;
            var11.field1689 = this.field1689;
            var11.field1685 = this.field1685;
            var11.field1686 = this.field1686;
            var11.field1684 = this.field1684;
            var11.field1676 = this.field1676;
            var11.field1697 = this.field1697;
            var11.field1690 = this.field1690;
            var11.field1691 = this.field1691;
            var11.field1694 = this.field1694;
            var11.field1674 = this.field1674;
            var11.field1693 = this.field1693;
            var11.field1687 = this.field1687;
            var11.field1692 = this.field1692;
            var11.field1688 = this.field1688;
            var11.field1698 = this.field1698;
            var11.field1702 = this.field1702;
            var11.field1703 = this.field1703;
            var11.field1670 = new int[var11.field1706];
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
               for(var12 = 0; var12 < var11.field1706; ++var12) {
                  var13 = this.field1704[var12] + var2;
                  var14 = this.field1671[var12] + var4;
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var1[var17 + 1][var18 + 1] * var15 >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.field1670[var12] = this.field1670[var12] + var21 - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1706; ++var12) {
                  var13 = (-this.field1670[var12] << 16) / super.field1443;
                  if(var13 < var6) {
                     var14 = this.field1704[var12] + var2;
                     var15 = this.field1671[var12] + var4;
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var1[var18 + 1][var19 + 1] * var16 >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.field1670[var12] = this.field1670[var12] + (var22 - var3) * (var6 - var13) / var6;
                  }
               }
            }

            var11.method2228();
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("b")
   public void method2213() {
      int var1;
      for(var1 = 0; var1 < this.field1706; ++var1) {
         this.field1671[var1] = -this.field1671[var1];
      }

      for(var1 = 0; var1 < this.field1714; ++var1) {
         int var2 = this.field1673[var1];
         this.field1673[var1] = this.field1669[var1];
         this.field1669[var1] = var2;
      }

      this.method2228();
   }

   @ObfuscatedName("q")
   public void method2214(short var1, short var2) {
      if(this.field1675 != null) {
         for(int var3 = 0; var3 < this.field1714; ++var3) {
            if(this.field1675[var3] == var1) {
               this.field1675[var3] = var2;
            }
         }

      }
   }

   @ObfuscatedName("y")
   public void method2215() {
      if(this.field1700 == null) {
         this.field1700 = new class96[this.field1706];

         int var1;
         for(var1 = 0; var1 < this.field1706; ++var1) {
            this.field1700[var1] = new class96();
         }

         for(var1 = 0; var1 < this.field1714; ++var1) {
            int var2 = this.field1673[var1];
            int var3 = this.field1680[var1];
            int var4 = this.field1669[var1];
            int var5 = this.field1704[var3] - this.field1704[var2];
            int var6 = this.field1670[var3] - this.field1670[var2];
            int var7 = this.field1671[var3] - this.field1671[var2];
            int var8 = this.field1704[var4] - this.field1704[var2];
            int var9 = this.field1670[var4] - this.field1670[var2];
            int var10 = this.field1671[var4] - this.field1671[var2];
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
            if(this.field1672 == null) {
               var15 = 0;
            } else {
               var15 = this.field1672[var1];
            }

            if(var15 == 0) {
               class96 var16 = this.field1700[var2];
               var16.field1612 += var11;
               var16.field1608 += var12;
               var16.field1609 += var13;
               ++var16.field1610;
               var16 = this.field1700[var3];
               var16.field1612 += var11;
               var16.field1608 += var12;
               var16.field1609 += var13;
               ++var16.field1610;
               var16 = this.field1700[var4];
               var16.field1612 += var11;
               var16.field1608 += var12;
               var16.field1609 += var13;
               ++var16.field1610;
            } else if(var15 == 1) {
               if(this.field1699 == null) {
                  this.field1699 = new class84[this.field1714];
               }

               class84 var17 = this.field1699[var1] = new class84();
               var17.field1442 = var11;
               var17.field1440 = var12;
               var17.field1439 = var13;
            }
         }

      }
   }

   @ObfuscatedName("x")
   final int method2216(class100 var1, int var2) {
      int var3 = -1;
      int var4 = var1.field1704[var2];
      int var5 = var1.field1670[var2];
      int var6 = var1.field1671[var2];

      for(int var7 = 0; var7 < this.field1706; ++var7) {
         if(var4 == this.field1704[var7] && var5 == this.field1670[var7] && var6 == this.field1671[var7]) {
            var3 = var7;
            break;
         }
      }

      if(var3 == -1) {
         this.field1704[this.field1706] = var4;
         this.field1670[this.field1706] = var5;
         this.field1671[this.field1706] = var6;
         if(var1.field1687 != null) {
            this.field1687[this.field1706] = var1.field1687[var2];
         }

         var3 = this.field1706++;
      }

      return var3;
   }

   public class100(class100[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      boolean var8 = false;
      this.field1706 = 0;
      this.field1714 = 0;
      this.field1683 = 0;
      this.field1682 = -1;

      int var9;
      class100 var10;
      for(var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if(var10 != null) {
            this.field1706 += var10.field1706;
            this.field1714 += var10.field1714;
            this.field1683 += var10.field1683;
            if(var10.field1677 != null) {
               var4 = true;
            } else {
               if(this.field1682 == -1) {
                  this.field1682 = var10.field1682;
               }

               if(this.field1682 != var10.field1682) {
                  var4 = true;
               }
            }

            var3 |= var10.field1672 != null;
            var5 |= var10.field1678 != null;
            var6 |= var10.field1692 != null;
            var7 |= var10.field1675 != null;
            var8 |= var10.field1679 != null;
         }
      }

      this.field1704 = new int[this.field1706];
      this.field1670 = new int[this.field1706];
      this.field1671 = new int[this.field1706];
      this.field1687 = new int[this.field1706];
      this.field1673 = new int[this.field1714];
      this.field1680 = new int[this.field1714];
      this.field1669 = new int[this.field1714];
      if(var3) {
         this.field1672 = new byte[this.field1714];
      }

      if(var4) {
         this.field1677 = new byte[this.field1714];
      }

      if(var5) {
         this.field1678 = new byte[this.field1714];
      }

      if(var6) {
         this.field1692 = new int[this.field1714];
      }

      if(var7) {
         this.field1675 = new short[this.field1714];
      }

      if(var8) {
         this.field1679 = new byte[this.field1714];
      }

      this.field1681 = new short[this.field1714];
      if(this.field1683 > 0) {
         this.field1689 = new byte[this.field1683];
         this.field1685 = new short[this.field1683];
         this.field1686 = new short[this.field1683];
         this.field1684 = new short[this.field1683];
         this.field1676 = new short[this.field1683];
         this.field1697 = new short[this.field1683];
         this.field1690 = new short[this.field1683];
         this.field1691 = new short[this.field1683];
         this.field1694 = new byte[this.field1683];
         this.field1674 = new short[this.field1683];
         this.field1693 = new short[this.field1683];
      }

      this.field1706 = 0;
      this.field1714 = 0;
      this.field1683 = 0;

      for(var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if(var10 != null) {
            int var11;
            for(var11 = 0; var11 < var10.field1714; ++var11) {
               if(var3 && var10.field1672 != null) {
                  this.field1672[this.field1714] = var10.field1672[var11];
               }

               if(var4) {
                  if(var10.field1677 != null) {
                     this.field1677[this.field1714] = var10.field1677[var11];
                  } else {
                     this.field1677[this.field1714] = var10.field1682;
                  }
               }

               if(var5 && var10.field1678 != null) {
                  this.field1678[this.field1714] = var10.field1678[var11];
               }

               if(var6 && var10.field1692 != null) {
                  this.field1692[this.field1714] = var10.field1692[var11];
               }

               if(var7) {
                  if(var10.field1675 != null) {
                     this.field1675[this.field1714] = var10.field1675[var11];
                  } else {
                     this.field1675[this.field1714] = -1;
                  }
               }

               if(var8) {
                  if(var10.field1679 != null && var10.field1679[var11] != -1) {
                     this.field1679[this.field1714] = (byte)(var10.field1679[var11] + this.field1683);
                  } else {
                     this.field1679[this.field1714] = -1;
                  }
               }

               this.field1681[this.field1714] = var10.field1681[var11];
               this.field1673[this.field1714] = this.method2216(var10, var10.field1673[var11]);
               this.field1680[this.field1714] = this.method2216(var10, var10.field1680[var11]);
               this.field1669[this.field1714] = this.method2216(var10, var10.field1669[var11]);
               ++this.field1714;
            }

            for(var11 = 0; var11 < var10.field1683; ++var11) {
               byte var12 = this.field1689[this.field1683] = var10.field1689[var11];
               if(var12 == 0) {
                  this.field1685[this.field1683] = (short)this.method2216(var10, var10.field1685[var11]);
                  this.field1686[this.field1683] = (short)this.method2216(var10, var10.field1686[var11]);
                  this.field1684[this.field1683] = (short)this.method2216(var10, var10.field1684[var11]);
               }

               if(var12 >= 1 && var12 <= 3) {
                  this.field1685[this.field1683] = var10.field1685[var11];
                  this.field1686[this.field1683] = var10.field1686[var11];
                  this.field1684[this.field1683] = var10.field1684[var11];
                  this.field1676[this.field1683] = var10.field1676[var11];
                  this.field1697[this.field1683] = var10.field1697[var11];
                  this.field1690[this.field1683] = var10.field1690[var11];
                  this.field1691[this.field1683] = var10.field1691[var11];
                  this.field1694[this.field1683] = var10.field1694[var11];
                  this.field1674[this.field1683] = var10.field1674[var11];
               }

               if(var12 == 2) {
                  this.field1693[this.field1683] = var10.field1693[var11];
               }

               ++this.field1683;
            }
         }
      }

   }

   @ObfuscatedName("k")
   public final class105 method2218(int var1, int var2, int var3, int var4, int var5) {
      this.method2215();
      int var6 = (int)Math.sqrt((double)(var3 * var3 + var4 * var4 + var5 * var5));
      int var7 = var2 * var6 >> 8;
      class105 var8 = new class105();
      var8.field1795 = new int[this.field1714];
      var8.field1783 = new int[this.field1714];
      var8.field1797 = new int[this.field1714];
      if(this.field1683 > 0 && this.field1679 != null) {
         int[] var9 = new int[this.field1683];

         int var10;
         for(var10 = 0; var10 < this.field1714; ++var10) {
            if(this.field1679[var10] != -1) {
               ++var9[this.field1679[var10] & 255];
            }
         }

         var8.field1803 = 0;

         for(var10 = 0; var10 < this.field1683; ++var10) {
            if(var9[var10] > 0 && this.field1689[var10] == 0) {
               ++var8.field1803;
            }
         }

         var8.field1786 = new int[var8.field1803];
         var8.field1805 = new int[var8.field1803];
         var8.field1806 = new int[var8.field1803];
         var10 = 0;

         int var11;
         for(var11 = 0; var11 < this.field1683; ++var11) {
            if(var9[var11] > 0 && this.field1689[var11] == 0) {
               var8.field1786[var10] = this.field1685[var11] & '\uffff';
               var8.field1805[var10] = this.field1686[var11] & '\uffff';
               var8.field1806[var10] = this.field1684[var11] & '\uffff';
               var9[var11] = var10++;
            } else {
               var9[var11] = -1;
            }
         }

         var8.field1800 = new byte[this.field1714];

         for(var11 = 0; var11 < this.field1714; ++var11) {
            if(this.field1679[var11] != -1) {
               var8.field1800[var11] = (byte)var9[this.field1679[var11] & 255];
            } else {
               var8.field1800[var11] = -1;
            }
         }
      }

      for(int var16 = 0; var16 < this.field1714; ++var16) {
         byte var17;
         if(this.field1672 == null) {
            var17 = 0;
         } else {
            var17 = this.field1672[var16];
         }

         byte var18;
         if(this.field1678 == null) {
            var18 = 0;
         } else {
            var18 = this.field1678[var16];
         }

         short var12;
         if(this.field1675 == null) {
            var12 = -1;
         } else {
            var12 = this.field1675[var16];
         }

         if(var18 == -2) {
            var17 = 3;
         }

         if(var18 == -1) {
            var17 = 2;
         }

         class96 var13;
         int var14;
         class84 var19;
         if(var12 == -1) {
            if(var17 != 0) {
               if(var17 == 1) {
                  var19 = this.field1699[var16];
                  var14 = var1 + (var3 * var19.field1442 + var4 * var19.field1440 + var5 * var19.field1439) / (var7 + var7 / 2);
                  var8.field1795[var16] = method2230(this.field1681[var16] & '\uffff', var14);
                  var8.field1797[var16] = -1;
               } else if(var17 == 3) {
                  var8.field1795[var16] = 128;
                  var8.field1797[var16] = -1;
               } else {
                  var8.field1797[var16] = -2;
               }
            } else {
               int var15 = this.field1681[var16] & '\uffff';
               if(this.field1701 != null && this.field1701[this.field1673[var16]] != null) {
                  var13 = this.field1701[this.field1673[var16]];
               } else {
                  var13 = this.field1700[this.field1673[var16]];
               }

               var14 = var1 + (var3 * var13.field1612 + var4 * var13.field1608 + var5 * var13.field1609) / (var7 * var13.field1610);
               var8.field1795[var16] = method2230(var15, var14);
               if(this.field1701 != null && this.field1701[this.field1680[var16]] != null) {
                  var13 = this.field1701[this.field1680[var16]];
               } else {
                  var13 = this.field1700[this.field1680[var16]];
               }

               var14 = var1 + (var3 * var13.field1612 + var4 * var13.field1608 + var5 * var13.field1609) / (var7 * var13.field1610);
               var8.field1783[var16] = method2230(var15, var14);
               if(this.field1701 != null && this.field1701[this.field1669[var16]] != null) {
                  var13 = this.field1701[this.field1669[var16]];
               } else {
                  var13 = this.field1700[this.field1669[var16]];
               }

               var14 = var1 + (var3 * var13.field1612 + var4 * var13.field1608 + var5 * var13.field1609) / (var7 * var13.field1610);
               var8.field1797[var16] = method2230(var15, var14);
            }
         } else if(var17 != 0) {
            if(var17 == 1) {
               var19 = this.field1699[var16];
               var14 = var1 + (var3 * var19.field1442 + var4 * var19.field1440 + var5 * var19.field1439) / (var7 + var7 / 2);
               var8.field1795[var16] = method2227(var14);
               var8.field1797[var16] = -1;
            } else {
               var8.field1797[var16] = -2;
            }
         } else {
            if(this.field1701 != null && this.field1701[this.field1673[var16]] != null) {
               var13 = this.field1701[this.field1673[var16]];
            } else {
               var13 = this.field1700[this.field1673[var16]];
            }

            var14 = var1 + (var3 * var13.field1612 + var4 * var13.field1608 + var5 * var13.field1609) / (var7 * var13.field1610);
            var8.field1795[var16] = method2227(var14);
            if(this.field1701 != null && this.field1701[this.field1680[var16]] != null) {
               var13 = this.field1701[this.field1680[var16]];
            } else {
               var13 = this.field1700[this.field1680[var16]];
            }

            var14 = var1 + (var3 * var13.field1612 + var4 * var13.field1608 + var5 * var13.field1609) / (var7 * var13.field1610);
            var8.field1783[var16] = method2227(var14);
            if(this.field1701 != null && this.field1701[this.field1669[var16]] != null) {
               var13 = this.field1701[this.field1669[var16]];
            } else {
               var13 = this.field1700[this.field1669[var16]];
            }

            var14 = var1 + (var3 * var13.field1612 + var4 * var13.field1608 + var5 * var13.field1609) / (var7 * var13.field1610);
            var8.field1797[var16] = method2227(var14);
         }
      }

      this.method2205();
      var8.field1787 = this.field1706;
      var8.field1788 = this.field1704;
      var8.field1789 = this.field1670;
      var8.field1844 = this.field1671;
      var8.field1796 = this.field1714;
      var8.field1792 = this.field1673;
      var8.field1793 = this.field1680;
      var8.field1831 = this.field1669;
      var8.field1826 = this.field1677;
      var8.field1799 = this.field1678;
      var8.field1802 = this.field1682;
      var8.field1807 = this.field1688;
      var8.field1845 = this.field1698;
      var8.field1801 = this.field1675;
      return var8;
   }

   class100() {
   }

   static {
      field1713 = class91.field1571;
      field1695 = class91.field1572;
   }

   @ObfuscatedName("v")
   static final int method2227(int var0) {
      if(var0 < 2) {
         var0 = 2;
      } else if(var0 > 126) {
         var0 = 126;
      }

      return var0;
   }

   @ObfuscatedName("w")
   void method2228() {
      this.field1700 = null;
      this.field1701 = null;
      this.field1699 = null;
      this.field1668 = false;
   }

   @ObfuscatedName("o")
   static final int method2230(int var0, int var1) {
      var1 = var1 * (var0 & 127) >> 7;
      if(var1 < 2) {
         var1 = 2;
      } else if(var1 > 126) {
         var1 = 126;
      }

      return (var0 & 'ﾀ') + var1;
   }

   @ObfuscatedName("n")
   public void method2236() {
      for(int var1 = 0; var1 < this.field1706; ++var1) {
         int var2 = this.field1704[var1];
         this.field1704[var1] = this.field1671[var1];
         this.field1671[var1] = -var2;
      }

      this.method2228();
   }

   @ObfuscatedName("s")
   static void method2263(class100 var0, class100 var1, int var2, int var3, int var4, boolean var5) {
      var0.method2204();
      var0.method2215();
      var1.method2204();
      var1.method2215();
      ++field1712;
      int var6 = 0;
      int[] var7 = var1.field1704;
      int var8 = var1.field1706;

      int var9;
      for(var9 = 0; var9 < var0.field1706; ++var9) {
         class96 var10 = var0.field1700[var9];
         if(var10.field1610 != 0) {
            int var11 = var0.field1670[var9] - var3;
            if(var11 <= var1.field1705) {
               int var12 = var0.field1704[var9] - var2;
               if(var12 >= var1.field1696 && var12 <= var1.field1707) {
                  int var13 = var0.field1671[var9] - var4;
                  if(var13 >= var1.field1709 && var13 <= var1.field1708) {
                     for(int var14 = 0; var14 < var8; ++var14) {
                        class96 var15 = var1.field1700[var14];
                        if(var12 == var7[var14] && var13 == var1.field1671[var14] && var11 == var1.field1670[var14] && var15.field1610 != 0) {
                           if(var0.field1701 == null) {
                              var0.field1701 = new class96[var0.field1706];
                           }

                           if(var1.field1701 == null) {
                              var1.field1701 = new class96[var8];
                           }

                           class96 var16 = var0.field1701[var9];
                           if(var16 == null) {
                              var16 = var0.field1701[var9] = new class96(var10);
                           }

                           class96 var17 = var1.field1701[var14];
                           if(var17 == null) {
                              var17 = var1.field1701[var14] = new class96(var15);
                           }

                           var16.field1612 += var15.field1612;
                           var16.field1608 += var15.field1608;
                           var16.field1609 += var15.field1609;
                           var16.field1610 += var15.field1610;
                           var17.field1612 += var10.field1612;
                           var17.field1608 += var10.field1608;
                           var17.field1609 += var10.field1609;
                           var17.field1610 += var10.field1610;
                           ++var6;
                           field1710[var9] = field1712;
                           field1711[var14] = field1712;
                        }
                     }
                  }
               }
            }
         }
      }

      if(var6 >= 3 && var5) {
         for(var9 = 0; var9 < var0.field1714; ++var9) {
            if(field1710[var0.field1673[var9]] == field1712 && field1710[var0.field1680[var9]] == field1712 && field1710[var0.field1669[var9]] == field1712) {
               if(var0.field1672 == null) {
                  var0.field1672 = new byte[var0.field1714];
               }

               var0.field1672[var9] = 2;
            }
         }

         for(var9 = 0; var9 < var1.field1714; ++var9) {
            if(field1711[var1.field1673[var9]] == field1712 && field1711[var1.field1680[var9]] == field1712 && field1711[var1.field1669[var9]] == field1712) {
               if(var1.field1672 == null) {
                  var1.field1672 = new byte[var1.field1714];
               }

               var1.field1672[var9] = 2;
            }
         }

      }
   }
}
