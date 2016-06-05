import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
@Implements("ModelData")
public class class100 extends class85 {
   @ObfuscatedName("x")
   short[] field1696;
   @ObfuscatedName("i")
   int[] field1697;
   @ObfuscatedName("g")
   int[] field1698;
   @ObfuscatedName("h")
   int[] field1699;
   @ObfuscatedName("ac")
   int field1700;
   @ObfuscatedName("ar")
   class84[] field1701;
   @ObfuscatedName("l")
   byte[] field1702;
   @ObfuscatedName("s")
   int[] field1703;
   @ObfuscatedName("d")
   byte[] field1704;
   @ObfuscatedName("ag")
   int[] field1705;
   @ObfuscatedName("y")
   byte[] field1706;
   @ObfuscatedName("p")
   byte[] field1707;
   @ObfuscatedName("k")
   short[] field1708;
   @ObfuscatedName("f")
   int[] field1709;
   @ObfuscatedName("w")
   short[] field1710;
   @ObfuscatedName("j")
   int field1711;
   @ObfuscatedName("a")
   byte[] field1712;
   @ObfuscatedName("m")
   short[] field1713;
   @ObfuscatedName("c")
   short[] field1714;
   @ObfuscatedName("n")
   short[] field1715;
   @ObfuscatedName("q")
   short[] field1716;
   @ObfuscatedName("aj")
   int field1717;
   @ObfuscatedName("v")
   short[] field1718;
   @ObfuscatedName("an")
   public short field1719;
   @ObfuscatedName("t")
   int field1720 = 0;
   @ObfuscatedName("e")
   short[] field1721;
   @ObfuscatedName("ad")
   byte[] field1722;
   @ObfuscatedName("as")
   int[] field1723;
   @ObfuscatedName("ai")
   public short field1724;
   @ObfuscatedName("al")
   int[][] field1725;
   @ObfuscatedName("av")
   int[][] field1726;
   @ObfuscatedName("r")
   int[] field1727;
   @ObfuscatedName("ay")
   class96[] field1728;
   @ObfuscatedName("aq")
   class96[] field1729;
   @ObfuscatedName("b")
   byte field1730 = 0;
   @ObfuscatedName("o")
   short[] field1731;
   @ObfuscatedName("ao")
   int field1732;
   @ObfuscatedName("ap")
   int field1733;
   @ObfuscatedName("ak")
   int field1734;
   @ObfuscatedName("z")
   int field1735 = 0;
   @ObfuscatedName("ae")
   static int[] field1736 = new int[10000];
   @ObfuscatedName("aw")
   boolean field1737 = false;
   @ObfuscatedName("ah")
   static int[] field1738 = new int[10000];
   @ObfuscatedName("u")
   short[] field1739;
   @ObfuscatedName("aa")
   static int field1740 = 0;
   @ObfuscatedName("au")
   static int[] field1741;
   @ObfuscatedName("ab")
   static int[] field1742;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([[IIIIZI)Lclass100;",
      garbageValue = "1"
   )
   public class100 method2161(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2179();
      int var7 = var2 + this.field1734;
      int var8 = var2 + this.field1700;
      int var9 = var4 + this.field1717;
      int var10 = var4 + this.field1732;
      if(var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
         var7 >>= 7;
         var8 = var8 + 127 >> 7;
         var9 >>= 7;
         var10 = var10 + 127 >> 7;
         if(var1[var7][var9] == var3 && var1[var8][var9] == var3 && var1[var7][var10] == var3 && var1[var8][var10] == var3) {
            return this;
         } else {
            class100 var11 = new class100();
            var11.field1720 = this.field1720;
            var11.field1735 = this.field1735;
            var11.field1711 = this.field1711;
            var11.field1697 = this.field1697;
            var11.field1699 = this.field1699;
            var11.field1727 = this.field1727;
            var11.field1709 = this.field1709;
            var11.field1703 = this.field1703;
            var11.field1704 = this.field1704;
            var11.field1702 = this.field1702;
            var11.field1706 = this.field1706;
            var11.field1707 = this.field1707;
            var11.field1708 = this.field1708;
            var11.field1731 = this.field1731;
            var11.field1730 = this.field1730;
            var11.field1712 = this.field1712;
            var11.field1739 = this.field1739;
            var11.field1714 = this.field1714;
            var11.field1715 = this.field1715;
            var11.field1716 = this.field1716;
            var11.field1696 = this.field1696;
            var11.field1718 = this.field1718;
            var11.field1713 = this.field1713;
            var11.field1722 = this.field1722;
            var11.field1710 = this.field1710;
            var11.field1721 = this.field1721;
            var11.field1723 = this.field1723;
            var11.field1705 = this.field1705;
            var11.field1725 = this.field1725;
            var11.field1726 = this.field1726;
            var11.field1724 = this.field1724;
            var11.field1719 = this.field1719;
            var11.field1698 = new int[var11.field1720];
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
               for(var12 = 0; var12 < var11.field1720; ++var12) {
                  var13 = this.field1697[var12] + var2;
                  var14 = this.field1699[var12] + var4;
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var1[var17 + 1][var18 + 1] * var15 >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.field1698[var12] = this.field1698[var12] + var21 - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1720; ++var12) {
                  var13 = (-this.field1698[var12] << 16) / super.field1466;
                  if(var13 < var6) {
                     var14 = this.field1697[var12] + var2;
                     var15 = this.field1699[var12] + var4;
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var1[var18 + 1][var19 + 1] * var16 >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.field1698[var12] = this.field1698[var12] + (var22 - var3) * (var6 - var13) / var6;
                  }
               }
            }

            var11.method2210();
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("i")
   void method2163(byte[] var1) {
      class119 var2 = new class119(var1);
      class119 var3 = new class119(var1);
      class119 var4 = new class119(var1);
      class119 var5 = new class119(var1);
      class119 var6 = new class119(var1);
      class119 var7 = new class119(var1);
      class119 var8 = new class119(var1);
      var2.field2000 = var1.length - 23;
      int var9 = var2.method2470();
      int var10 = var2.method2470();
      int var11 = var2.method2494();
      int var12 = var2.method2494();
      int var13 = var2.method2494();
      int var14 = var2.method2494();
      int var15 = var2.method2494();
      int var16 = var2.method2494();
      int var17 = var2.method2494();
      int var18 = var2.method2470();
      int var19 = var2.method2470();
      int var20 = var2.method2470();
      int var21 = var2.method2470();
      int var22 = var2.method2470();
      int var23 = 0;
      int var24 = 0;
      int var25 = 0;
      int var26;
      if(var11 > 0) {
         this.field1712 = new byte[var11];
         var2.field2000 = 0;

         for(var26 = 0; var26 < var11; ++var26) {
            byte var27 = this.field1712[var26] = var2.method2469();
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
      this.field1720 = var9;
      this.field1735 = var10;
      this.field1711 = var11;
      this.field1697 = new int[var9];
      this.field1698 = new int[var9];
      this.field1699 = new int[var9];
      this.field1727 = new int[var10];
      this.field1709 = new int[var10];
      this.field1703 = new int[var10];
      if(var17 == 1) {
         this.field1723 = new int[var9];
      }

      if(var12 == 1) {
         this.field1704 = new byte[var10];
      }

      if(var13 == 255) {
         this.field1702 = new byte[var10];
      } else {
         this.field1730 = (byte)var13;
      }

      if(var14 == 1) {
         this.field1706 = new byte[var10];
      }

      if(var15 == 1) {
         this.field1705 = new int[var10];
      }

      if(var16 == 1) {
         this.field1731 = new short[var10];
      }

      if(var16 == 1 && var11 > 0) {
         this.field1707 = new byte[var10];
      }

      this.field1708 = new short[var10];
      if(var11 > 0) {
         this.field1739 = new short[var11];
         this.field1714 = new short[var11];
         this.field1715 = new short[var11];
         if(var24 > 0) {
            this.field1716 = new short[var24];
            this.field1696 = new short[var24];
            this.field1718 = new short[var24];
            this.field1713 = new short[var24];
            this.field1722 = new byte[var24];
            this.field1710 = new short[var24];
         }

         if(var25 > 0) {
            this.field1721 = new short[var25];
         }
      }

      var2.field2000 = var11;
      var3.field2000 = var38;
      var4.field2000 = var39;
      var5.field2000 = var40;
      var6.field2000 = var32;
      int var48 = 0;
      int var49 = 0;
      int var50 = 0;

      int var51;
      int var52;
      int var53;
      int var54;
      int var55;
      for(var51 = 0; var51 < var9; ++var51) {
         var52 = var2.method2494();
         var53 = 0;
         if((var52 & 1) != 0) {
            var53 = var3.method2565();
         }

         var54 = 0;
         if((var52 & 2) != 0) {
            var54 = var4.method2565();
         }

         var55 = 0;
         if((var52 & 4) != 0) {
            var55 = var5.method2565();
         }

         this.field1697[var51] = var48 + var53;
         this.field1698[var51] = var49 + var54;
         this.field1699[var51] = var50 + var55;
         var48 = this.field1697[var51];
         var49 = this.field1698[var51];
         var50 = this.field1699[var51];
         if(var17 == 1) {
            this.field1723[var51] = var6.method2494();
         }
      }

      var2.field2000 = var37;
      var3.field2000 = var28;
      var4.field2000 = var30;
      var5.field2000 = var33;
      var6.field2000 = var31;
      var7.field2000 = var35;
      var8.field2000 = var36;

      for(var51 = 0; var51 < var10; ++var51) {
         this.field1708[var51] = (short)var2.method2470();
         if(var12 == 1) {
            this.field1704[var51] = var3.method2469();
         }

         if(var13 == 255) {
            this.field1702[var51] = var4.method2469();
         }

         if(var14 == 1) {
            this.field1706[var51] = var5.method2469();
         }

         if(var15 == 1) {
            this.field1705[var51] = var6.method2494();
         }

         if(var16 == 1) {
            this.field1731[var51] = (short)(var7.method2470() - 1);
         }

         if(this.field1707 != null && this.field1731[var51] != -1) {
            this.field1707[var51] = (byte)(var8.method2494() - 1);
         }
      }

      var2.field2000 = var34;
      var3.field2000 = var29;
      var51 = 0;
      var52 = 0;
      var53 = 0;
      var54 = 0;

      int var56;
      for(var55 = 0; var55 < var10; ++var55) {
         var56 = var3.method2494();
         if(var56 == 1) {
            var51 = var2.method2565() + var54;
            var52 = var2.method2565() + var51;
            var53 = var2.method2565() + var52;
            var54 = var53;
            this.field1727[var55] = var51;
            this.field1709[var55] = var52;
            this.field1703[var55] = var53;
         }

         if(var56 == 2) {
            var52 = var53;
            var53 = var2.method2565() + var54;
            var54 = var53;
            this.field1727[var55] = var51;
            this.field1709[var55] = var52;
            this.field1703[var55] = var53;
         }

         if(var56 == 3) {
            var51 = var53;
            var53 = var2.method2565() + var54;
            var54 = var53;
            this.field1727[var55] = var51;
            this.field1709[var55] = var52;
            this.field1703[var55] = var53;
         }

         if(var56 == 4) {
            int var57 = var51;
            var51 = var52;
            var52 = var57;
            var53 = var2.method2565() + var54;
            var54 = var53;
            this.field1727[var55] = var51;
            this.field1709[var55] = var57;
            this.field1703[var55] = var53;
         }
      }

      var2.field2000 = var41;
      var3.field2000 = var42;
      var4.field2000 = var43;
      var5.field2000 = var44;
      var6.field2000 = var45;
      var7.field2000 = var46;

      for(var55 = 0; var55 < var11; ++var55) {
         var56 = this.field1712[var55] & 255;
         if(var56 == 0) {
            this.field1739[var55] = (short)var2.method2470();
            this.field1714[var55] = (short)var2.method2470();
            this.field1715[var55] = (short)var2.method2470();
         }

         if(var56 == 1) {
            this.field1739[var55] = (short)var3.method2470();
            this.field1714[var55] = (short)var3.method2470();
            this.field1715[var55] = (short)var3.method2470();
            this.field1716[var55] = (short)var4.method2470();
            this.field1696[var55] = (short)var4.method2470();
            this.field1718[var55] = (short)var4.method2470();
            this.field1713[var55] = (short)var5.method2470();
            this.field1722[var55] = var6.method2469();
            this.field1710[var55] = (short)var7.method2470();
         }

         if(var56 == 2) {
            this.field1739[var55] = (short)var3.method2470();
            this.field1714[var55] = (short)var3.method2470();
            this.field1715[var55] = (short)var3.method2470();
            this.field1716[var55] = (short)var4.method2470();
            this.field1696[var55] = (short)var4.method2470();
            this.field1718[var55] = (short)var4.method2470();
            this.field1713[var55] = (short)var5.method2470();
            this.field1722[var55] = var6.method2469();
            this.field1710[var55] = (short)var7.method2470();
            this.field1721[var55] = (short)var7.method2470();
         }

         if(var56 == 3) {
            this.field1739[var55] = (short)var3.method2470();
            this.field1714[var55] = (short)var3.method2470();
            this.field1715[var55] = (short)var3.method2470();
            this.field1716[var55] = (short)var4.method2470();
            this.field1696[var55] = (short)var4.method2470();
            this.field1718[var55] = (short)var4.method2470();
            this.field1713[var55] = (short)var5.method2470();
            this.field1722[var55] = var6.method2469();
            this.field1710[var55] = (short)var7.method2470();
         }
      }

      var2.field2000 = var26;
      var55 = var2.method2494();
      if(var55 != 0) {
         new class90();
         var2.method2470();
         var2.method2470();
         var2.method2470();
         var2.method2505();
      }

   }

   @ObfuscatedName("h")
   void method2164(byte[] var1) {
      boolean var2 = false;
      boolean var3 = false;
      class119 var4 = new class119(var1);
      class119 var5 = new class119(var1);
      class119 var6 = new class119(var1);
      class119 var7 = new class119(var1);
      class119 var8 = new class119(var1);
      var4.field2000 = var1.length - 18;
      int var9 = var4.method2470();
      int var10 = var4.method2470();
      int var11 = var4.method2494();
      int var12 = var4.method2494();
      int var13 = var4.method2494();
      int var14 = var4.method2494();
      int var15 = var4.method2494();
      int var16 = var4.method2494();
      int var17 = var4.method2470();
      int var18 = var4.method2470();
      int var19 = var4.method2470();
      int var20 = var4.method2470();
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
      this.field1720 = var9;
      this.field1735 = var10;
      this.field1711 = var11;
      this.field1697 = new int[var9];
      this.field1698 = new int[var9];
      this.field1699 = new int[var9];
      this.field1727 = new int[var10];
      this.field1709 = new int[var10];
      this.field1703 = new int[var10];
      if(var11 > 0) {
         this.field1712 = new byte[var11];
         this.field1739 = new short[var11];
         this.field1714 = new short[var11];
         this.field1715 = new short[var11];
      }

      if(var16 == 1) {
         this.field1723 = new int[var9];
      }

      if(var12 == 1) {
         this.field1704 = new byte[var10];
         this.field1707 = new byte[var10];
         this.field1731 = new short[var10];
      }

      if(var13 == 255) {
         this.field1702 = new byte[var10];
      } else {
         this.field1730 = (byte)var13;
      }

      if(var14 == 1) {
         this.field1706 = new byte[var10];
      }

      if(var15 == 1) {
         this.field1705 = new int[var10];
      }

      this.field1708 = new short[var10];
      var4.field2000 = var21;
      var5.field2000 = var32;
      var6.field2000 = var33;
      var7.field2000 = var45;
      var8.field2000 = var27;
      int var35 = 0;
      int var36 = 0;
      int var37 = 0;

      int var38;
      int var39;
      int var40;
      int var41;
      int var42;
      for(var38 = 0; var38 < var9; ++var38) {
         var39 = var4.method2494();
         var40 = 0;
         if((var39 & 1) != 0) {
            var40 = var5.method2565();
         }

         var41 = 0;
         if((var39 & 2) != 0) {
            var41 = var6.method2565();
         }

         var42 = 0;
         if((var39 & 4) != 0) {
            var42 = var7.method2565();
         }

         this.field1697[var38] = var35 + var40;
         this.field1698[var38] = var36 + var41;
         this.field1699[var38] = var37 + var42;
         var35 = this.field1697[var38];
         var36 = this.field1698[var38];
         var37 = this.field1699[var38];
         if(var16 == 1) {
            this.field1723[var38] = var8.method2494();
         }
      }

      var4.field2000 = var30;
      var5.field2000 = var26;
      var6.field2000 = var24;
      var7.field2000 = var28;
      var8.field2000 = var25;

      for(var38 = 0; var38 < var10; ++var38) {
         this.field1708[var38] = (short)var4.method2470();
         if(var12 == 1) {
            var39 = var5.method2494();
            if((var39 & 1) == 1) {
               this.field1704[var38] = 1;
               var2 = true;
            } else {
               this.field1704[var38] = 0;
            }

            if((var39 & 2) == 2) {
               this.field1707[var38] = (byte)(var39 >> 2);
               this.field1731[var38] = this.field1708[var38];
               this.field1708[var38] = 127;
               if(this.field1731[var38] != -1) {
                  var3 = true;
               }
            } else {
               this.field1707[var38] = -1;
               this.field1731[var38] = -1;
            }
         }

         if(var13 == 255) {
            this.field1702[var38] = var6.method2469();
         }

         if(var14 == 1) {
            this.field1706[var38] = var7.method2469();
         }

         if(var15 == 1) {
            this.field1705[var38] = var8.method2494();
         }
      }

      var4.field2000 = var29;
      var5.field2000 = var23;
      var38 = 0;
      var39 = 0;
      var40 = 0;
      var41 = 0;

      int var43;
      int var44;
      for(var42 = 0; var42 < var10; ++var42) {
         var43 = var5.method2494();
         if(var43 == 1) {
            var38 = var4.method2565() + var41;
            var39 = var4.method2565() + var38;
            var40 = var4.method2565() + var39;
            var41 = var40;
            this.field1727[var42] = var38;
            this.field1709[var42] = var39;
            this.field1703[var42] = var40;
         }

         if(var43 == 2) {
            var39 = var40;
            var40 = var4.method2565() + var41;
            var41 = var40;
            this.field1727[var42] = var38;
            this.field1709[var42] = var39;
            this.field1703[var42] = var40;
         }

         if(var43 == 3) {
            var38 = var40;
            var40 = var4.method2565() + var41;
            var41 = var40;
            this.field1727[var42] = var38;
            this.field1709[var42] = var39;
            this.field1703[var42] = var40;
         }

         if(var43 == 4) {
            var44 = var38;
            var38 = var39;
            var39 = var44;
            var40 = var4.method2565() + var41;
            var41 = var40;
            this.field1727[var42] = var38;
            this.field1709[var42] = var44;
            this.field1703[var42] = var40;
         }
      }

      var4.field2000 = var31;

      for(var42 = 0; var42 < var11; ++var42) {
         this.field1712[var42] = 0;
         this.field1739[var42] = (short)var4.method2470();
         this.field1714[var42] = (short)var4.method2470();
         this.field1715[var42] = (short)var4.method2470();
      }

      if(this.field1707 != null) {
         boolean var46 = false;

         for(var43 = 0; var43 < var10; ++var43) {
            var44 = this.field1707[var43] & 255;
            if(var44 != 255) {
               if((this.field1739[var44] & '\uffff') == this.field1727[var43] && (this.field1714[var44] & '\uffff') == this.field1709[var43] && (this.field1715[var44] & '\uffff') == this.field1703[var43]) {
                  this.field1707[var43] = -1;
               } else {
                  var46 = true;
               }
            }
         }

         if(!var46) {
            this.field1707 = null;
         }
      }

      if(!var3) {
         this.field1731 = null;
      }

      if(!var2) {
         this.field1704 = null;
      }

   }

   public class100(class100[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      boolean var8 = false;
      this.field1720 = 0;
      this.field1735 = 0;
      this.field1711 = 0;
      this.field1730 = -1;

      int var9;
      class100 var10;
      for(var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if(var10 != null) {
            this.field1720 += var10.field1720;
            this.field1735 += var10.field1735;
            this.field1711 += var10.field1711;
            if(var10.field1702 != null) {
               var4 = true;
            } else {
               if(this.field1730 == -1) {
                  this.field1730 = var10.field1730;
               }

               if(this.field1730 != var10.field1730) {
                  var4 = true;
               }
            }

            var3 |= var10.field1704 != null;
            var5 |= var10.field1706 != null;
            var6 |= var10.field1705 != null;
            var7 |= var10.field1731 != null;
            var8 |= var10.field1707 != null;
         }
      }

      this.field1697 = new int[this.field1720];
      this.field1698 = new int[this.field1720];
      this.field1699 = new int[this.field1720];
      this.field1723 = new int[this.field1720];
      this.field1727 = new int[this.field1735];
      this.field1709 = new int[this.field1735];
      this.field1703 = new int[this.field1735];
      if(var3) {
         this.field1704 = new byte[this.field1735];
      }

      if(var4) {
         this.field1702 = new byte[this.field1735];
      }

      if(var5) {
         this.field1706 = new byte[this.field1735];
      }

      if(var6) {
         this.field1705 = new int[this.field1735];
      }

      if(var7) {
         this.field1731 = new short[this.field1735];
      }

      if(var8) {
         this.field1707 = new byte[this.field1735];
      }

      this.field1708 = new short[this.field1735];
      if(this.field1711 > 0) {
         this.field1712 = new byte[this.field1711];
         this.field1739 = new short[this.field1711];
         this.field1714 = new short[this.field1711];
         this.field1715 = new short[this.field1711];
         this.field1716 = new short[this.field1711];
         this.field1696 = new short[this.field1711];
         this.field1718 = new short[this.field1711];
         this.field1713 = new short[this.field1711];
         this.field1722 = new byte[this.field1711];
         this.field1710 = new short[this.field1711];
         this.field1721 = new short[this.field1711];
      }

      this.field1720 = 0;
      this.field1735 = 0;
      this.field1711 = 0;

      for(var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if(var10 != null) {
            int var11;
            for(var11 = 0; var11 < var10.field1735; ++var11) {
               if(var3 && var10.field1704 != null) {
                  this.field1704[this.field1735] = var10.field1704[var11];
               }

               if(var4) {
                  if(var10.field1702 != null) {
                     this.field1702[this.field1735] = var10.field1702[var11];
                  } else {
                     this.field1702[this.field1735] = var10.field1730;
                  }
               }

               if(var5 && var10.field1706 != null) {
                  this.field1706[this.field1735] = var10.field1706[var11];
               }

               if(var6 && var10.field1705 != null) {
                  this.field1705[this.field1735] = var10.field1705[var11];
               }

               if(var7) {
                  if(var10.field1731 != null) {
                     this.field1731[this.field1735] = var10.field1731[var11];
                  } else {
                     this.field1731[this.field1735] = -1;
                  }
               }

               if(var8) {
                  if(var10.field1707 != null && var10.field1707[var11] != -1) {
                     this.field1707[this.field1735] = (byte)(var10.field1707[var11] + this.field1711);
                  } else {
                     this.field1707[this.field1735] = -1;
                  }
               }

               this.field1708[this.field1735] = var10.field1708[var11];
               this.field1727[this.field1735] = this.method2165(var10, var10.field1727[var11]);
               this.field1709[this.field1735] = this.method2165(var10, var10.field1709[var11]);
               this.field1703[this.field1735] = this.method2165(var10, var10.field1703[var11]);
               ++this.field1735;
            }

            for(var11 = 0; var11 < var10.field1711; ++var11) {
               byte var12 = this.field1712[this.field1711] = var10.field1712[var11];
               if(var12 == 0) {
                  this.field1739[this.field1711] = (short)this.method2165(var10, var10.field1739[var11]);
                  this.field1714[this.field1711] = (short)this.method2165(var10, var10.field1714[var11]);
                  this.field1715[this.field1711] = (short)this.method2165(var10, var10.field1715[var11]);
               }

               if(var12 >= 1 && var12 <= 3) {
                  this.field1739[this.field1711] = var10.field1739[var11];
                  this.field1714[this.field1711] = var10.field1714[var11];
                  this.field1715[this.field1711] = var10.field1715[var11];
                  this.field1716[this.field1711] = var10.field1716[var11];
                  this.field1696[this.field1711] = var10.field1696[var11];
                  this.field1718[this.field1711] = var10.field1718[var11];
                  this.field1713[this.field1711] = var10.field1713[var11];
                  this.field1722[this.field1711] = var10.field1722[var11];
                  this.field1710[this.field1711] = var10.field1710[var11];
               }

               if(var12 == 2) {
                  this.field1721[this.field1711] = var10.field1721[var11];
               }

               ++this.field1711;
            }
         }
      }

   }

   @ObfuscatedName("z")
   final int method2165(class100 var1, int var2) {
      int var3 = -1;
      int var4 = var1.field1697[var2];
      int var5 = var1.field1698[var2];
      int var6 = var1.field1699[var2];

      for(int var7 = 0; var7 < this.field1720; ++var7) {
         if(var4 == this.field1697[var7] && var5 == this.field1698[var7] && var6 == this.field1699[var7]) {
            var3 = var7;
            break;
         }
      }

      if(var3 == -1) {
         this.field1697[this.field1720] = var4;
         this.field1698[this.field1720] = var5;
         this.field1699[this.field1720] = var6;
         if(var1.field1723 != null) {
            this.field1723[this.field1720] = var1.field1723[var2];
         }

         var3 = this.field1720++;
      }

      return var3;
   }

   @ObfuscatedSignature(
      signature = "(Lclass100;ZZZZ)V",
      garbageValue = "1"
   )
   public class100(class100 var1, boolean var2, boolean var3, boolean var4, boolean var5) {
      this.field1720 = var1.field1720;
      this.field1735 = var1.field1735;
      this.field1711 = var1.field1711;
      this.field1697 = var1.field1697;
      this.field1698 = var1.field1698;
      this.field1699 = var1.field1699;
      this.field1708 = var1.field1708;
      this.field1731 = var1.field1731;
      this.field1706 = var1.field1706;
      this.field1727 = var1.field1727;
      this.field1709 = var1.field1709;
      this.field1703 = var1.field1703;
      this.field1704 = var1.field1704;
      this.field1702 = var1.field1702;
      this.field1707 = var1.field1707;
      this.field1730 = var1.field1730;
      this.field1712 = var1.field1712;
      this.field1739 = var1.field1739;
      this.field1714 = var1.field1714;
      this.field1715 = var1.field1715;
      this.field1716 = var1.field1716;
      this.field1696 = var1.field1696;
      this.field1718 = var1.field1718;
      this.field1713 = var1.field1713;
      this.field1722 = var1.field1722;
      this.field1710 = var1.field1710;
      this.field1721 = var1.field1721;
      this.field1723 = var1.field1723;
      this.field1705 = var1.field1705;
      this.field1725 = var1.field1725;
      this.field1726 = var1.field1726;
      this.field1728 = var1.field1728;
      this.field1701 = var1.field1701;
      this.field1729 = var1.field1729;
      this.field1724 = var1.field1724;
      this.field1719 = var1.field1719;
   }

   @ObfuscatedName("r")
   public class100 method2166() {
      class100 var1 = new class100();
      if(this.field1704 != null) {
         var1.field1704 = new byte[this.field1735];

         for(int var2 = 0; var2 < this.field1735; ++var2) {
            var1.field1704[var2] = this.field1704[var2];
         }
      }

      var1.field1720 = this.field1720;
      var1.field1735 = this.field1735;
      var1.field1711 = this.field1711;
      var1.field1697 = this.field1697;
      var1.field1698 = this.field1698;
      var1.field1699 = this.field1699;
      var1.field1727 = this.field1727;
      var1.field1709 = this.field1709;
      var1.field1703 = this.field1703;
      var1.field1702 = this.field1702;
      var1.field1706 = this.field1706;
      var1.field1707 = this.field1707;
      var1.field1708 = this.field1708;
      var1.field1731 = this.field1731;
      var1.field1730 = this.field1730;
      var1.field1712 = this.field1712;
      var1.field1739 = this.field1739;
      var1.field1714 = this.field1714;
      var1.field1715 = this.field1715;
      var1.field1716 = this.field1716;
      var1.field1696 = this.field1696;
      var1.field1718 = this.field1718;
      var1.field1713 = this.field1713;
      var1.field1722 = this.field1722;
      var1.field1710 = this.field1710;
      var1.field1721 = this.field1721;
      var1.field1723 = this.field1723;
      var1.field1705 = this.field1705;
      var1.field1725 = this.field1725;
      var1.field1726 = this.field1726;
      var1.field1728 = this.field1728;
      var1.field1701 = this.field1701;
      var1.field1724 = this.field1724;
      var1.field1719 = this.field1719;
      return var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "256"
   )
   public void method2167(int var1) {
      int var2 = field1741[var1];
      int var3 = field1742[var1];

      for(int var4 = 0; var4 < this.field1720; ++var4) {
         int var5 = this.field1699[var4] * var2 + this.field1697[var4] * var3 >> 16;
         this.field1699[var4] = this.field1699[var4] * var3 - this.field1697[var4] * var2 >> 16;
         this.field1697[var4] = var5;
      }

      this.method2210();
   }

   @ObfuscatedName("s")
   @Export("computeAnimationTables")
   void method2168() {
      int[] var1;
      int var2;
      int var3;
      int var4;
      if(this.field1723 != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.field1720; ++var3) {
            var4 = this.field1723[var3];
            ++var1[var4];
            if(var4 > var2) {
               var2 = var4;
            }
         }

         this.field1725 = new int[var2 + 1][];

         for(var3 = 0; var3 <= var2; ++var3) {
            this.field1725[var3] = new int[var1[var3]];
            var1[var3] = 0;
         }

         for(var3 = 0; var3 < this.field1720; this.field1725[var4][var1[var4]++] = var3++) {
            var4 = this.field1723[var3];
         }

         this.field1723 = null;
      }

      if(this.field1705 != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.field1735; ++var3) {
            var4 = this.field1705[var3];
            ++var1[var4];
            if(var4 > var2) {
               var2 = var4;
            }
         }

         this.field1726 = new int[var2 + 1][];

         for(var3 = 0; var3 <= var2; ++var3) {
            this.field1726[var3] = new int[var1[var3]];
            var1[var3] = 0;
         }

         for(var3 = 0; var3 < this.field1735; this.field1726[var4][var1[var4]++] = var3++) {
            var4 = this.field1705[var3];
         }

         this.field1705 = null;
      }

   }

   @ObfuscatedName("l")
   public void method2170() {
      for(int var1 = 0; var1 < this.field1720; ++var1) {
         this.field1697[var1] = -this.field1697[var1];
         this.field1699[var1] = -this.field1699[var1];
      }

      this.method2210();
   }

   @ObfuscatedName("y")
   public void method2171() {
      for(int var1 = 0; var1 < this.field1720; ++var1) {
         int var2 = this.field1699[var1];
         this.field1699[var1] = this.field1697[var1];
         this.field1697[var1] = -var2;
      }

      this.method2210();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass167;II)Lclass100;",
      garbageValue = "0"
   )
   public static class100 method2172(class167 var0, int var1, int var2) {
      byte[] var3 = var0.method3221(var1, var2);
      return var3 == null?null:new class100(var3);
   }

   @ObfuscatedName("a")
   public void method2173(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1720; ++var4) {
         this.field1697[var4] += var1;
         this.field1698[var4] += var2;
         this.field1699[var4] += var3;
      }

      this.method2210();
   }

   @ObfuscatedName("n")
   public void method2176() {
      int var1;
      for(var1 = 0; var1 < this.field1720; ++var1) {
         this.field1699[var1] = -this.field1699[var1];
      }

      for(var1 = 0; var1 < this.field1735; ++var1) {
         int var2 = this.field1727[var1];
         this.field1727[var1] = this.field1703[var1];
         this.field1703[var1] = var2;
      }

      this.method2210();
   }

   @ObfuscatedName("q")
   public void method2177(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1720; ++var4) {
         this.field1697[var4] = this.field1697[var4] * var1 / 128;
         this.field1698[var4] = this.field1698[var4] * var2 / 128;
         this.field1699[var4] = this.field1699[var4] * var3 / 128;
      }

      this.method2210();
   }

   @ObfuscatedName("x")
   @Export("computeNormals")
   public void method2178() {
      if(this.field1728 == null) {
         this.field1728 = new class96[this.field1720];

         int var1;
         for(var1 = 0; var1 < this.field1720; ++var1) {
            this.field1728[var1] = new class96();
         }

         for(var1 = 0; var1 < this.field1735; ++var1) {
            int var2 = this.field1727[var1];
            int var3 = this.field1709[var1];
            int var4 = this.field1703[var1];
            int var5 = this.field1697[var3] - this.field1697[var2];
            int var6 = this.field1698[var3] - this.field1698[var2];
            int var7 = this.field1699[var3] - this.field1699[var2];
            int var8 = this.field1697[var4] - this.field1697[var2];
            int var9 = this.field1698[var4] - this.field1698[var2];
            int var10 = this.field1699[var4] - this.field1699[var2];
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
            if(this.field1704 == null) {
               var15 = 0;
            } else {
               var15 = this.field1704[var1];
            }

            if(var15 == 0) {
               class96 var16 = this.field1728[var2];
               var16.field1640 += var11;
               var16.field1638 += var12;
               var16.field1639 += var13;
               ++var16.field1647;
               var16 = this.field1728[var3];
               var16.field1640 += var11;
               var16.field1638 += var12;
               var16.field1639 += var13;
               ++var16.field1647;
               var16 = this.field1728[var4];
               var16.field1640 += var11;
               var16.field1638 += var12;
               var16.field1639 += var13;
               ++var16.field1647;
            } else if(var15 == 1) {
               if(this.field1701 == null) {
                  this.field1701 = new class84[this.field1735];
               }

               class84 var17 = this.field1701[var1] = new class84();
               var17.field1458 = var11;
               var17.field1459 = var12;
               var17.field1460 = var13;
            }
         }

      }
   }

   class100(byte[] var1) {
      if(var1[var1.length - 1] == -1 && var1[var1.length - 2] == -1) {
         this.method2163(var1);
      } else {
         this.method2164(var1);
      }

   }

   @ObfuscatedName("m")
   void method2179() {
      if(!this.field1737) {
         super.field1466 = 0;
         this.field1733 = 0;
         this.field1734 = 999999;
         this.field1700 = -999999;
         this.field1732 = -99999;
         this.field1717 = 99999;

         for(int var1 = 0; var1 < this.field1720; ++var1) {
            int var2 = this.field1697[var1];
            int var3 = this.field1698[var1];
            int var4 = this.field1699[var1];
            if(var2 < this.field1734) {
               this.field1734 = var2;
            }

            if(var2 > this.field1700) {
               this.field1700 = var2;
            }

            if(var4 < this.field1717) {
               this.field1717 = var4;
            }

            if(var4 > this.field1732) {
               this.field1732 = var4;
            }

            if(-var3 > super.field1466) {
               super.field1466 = -var3;
            }

            if(var3 > this.field1733) {
               this.field1733 = var3;
            }
         }

         this.field1737 = true;
      }
   }

   @ObfuscatedName("w")
   static void method2180(class100 var0, class100 var1, int var2, int var3, int var4, boolean var5) {
      var0.method2179();
      var0.method2178();
      var1.method2179();
      var1.method2178();
      ++field1740;
      int var6 = 0;
      int[] var7 = var1.field1697;
      int var8 = var1.field1720;

      int var9;
      for(var9 = 0; var9 < var0.field1720; ++var9) {
         class96 var10 = var0.field1728[var9];
         if(var10.field1647 != 0) {
            int var11 = var0.field1698[var9] - var3;
            if(var11 <= var1.field1733) {
               int var12 = var0.field1697[var9] - var2;
               if(var12 >= var1.field1734 && var12 <= var1.field1700) {
                  int var13 = var0.field1699[var9] - var4;
                  if(var13 >= var1.field1717 && var13 <= var1.field1732) {
                     for(int var14 = 0; var14 < var8; ++var14) {
                        class96 var15 = var1.field1728[var14];
                        if(var12 == var7[var14] && var13 == var1.field1699[var14] && var11 == var1.field1698[var14] && var15.field1647 != 0) {
                           if(var0.field1729 == null) {
                              var0.field1729 = new class96[var0.field1720];
                           }

                           if(var1.field1729 == null) {
                              var1.field1729 = new class96[var8];
                           }

                           class96 var16 = var0.field1729[var9];
                           if(var16 == null) {
                              var16 = var0.field1729[var9] = new class96(var10);
                           }

                           class96 var17 = var1.field1729[var14];
                           if(var17 == null) {
                              var17 = var1.field1729[var14] = new class96(var15);
                           }

                           var16.field1640 += var15.field1640;
                           var16.field1638 += var15.field1638;
                           var16.field1639 += var15.field1639;
                           var16.field1647 += var15.field1647;
                           var17.field1640 += var10.field1640;
                           var17.field1638 += var10.field1638;
                           var17.field1639 += var10.field1639;
                           var17.field1647 += var10.field1647;
                           ++var6;
                           field1738[var9] = field1740;
                           field1736[var14] = field1740;
                        }
                     }
                  }
               }
            }
         }
      }

      if(var6 >= 3 && var5) {
         for(var9 = 0; var9 < var0.field1735; ++var9) {
            if(field1738[var0.field1727[var9]] == field1740 && field1738[var0.field1709[var9]] == field1740 && field1738[var0.field1703[var9]] == field1740) {
               if(var0.field1704 == null) {
                  var0.field1704 = new byte[var0.field1735];
               }

               var0.field1704[var9] = 2;
            }
         }

         for(var9 = 0; var9 < var1.field1735; ++var9) {
            if(field1736[var1.field1727[var9]] == field1740 && field1736[var1.field1709[var9]] == field1740 && field1736[var1.field1703[var9]] == field1740) {
               if(var1.field1704 == null) {
                  var1.field1704 = new byte[var1.field1735];
               }

               var1.field1704[var9] = 2;
            }
         }

      }
   }

   @ObfuscatedName("e")
   public final class105 method2181(int var1, int var2, int var3, int var4, int var5) {
      this.method2178();
      int var6 = (int)Math.sqrt((double)(var3 * var3 + var4 * var4 + var5 * var5));
      int var7 = var2 * var6 >> 8;
      class105 var8 = new class105();
      var8.field1817 = new int[this.field1735];
      var8.field1818 = new int[this.field1735];
      var8.field1827 = new int[this.field1735];
      if(this.field1711 > 0 && this.field1707 != null) {
         int[] var9 = new int[this.field1711];

         int var10;
         for(var10 = 0; var10 < this.field1735; ++var10) {
            if(this.field1707[var10] != -1) {
               ++var9[this.field1707[var10] & 255];
            }
         }

         var8.field1840 = 0;

         for(var10 = 0; var10 < this.field1711; ++var10) {
            if(var9[var10] > 0 && this.field1712[var10] == 0) {
               ++var8.field1840;
            }
         }

         var8.field1826 = new int[var8.field1840];
         var8.field1831 = new int[var8.field1840];
         var8.field1828 = new int[var8.field1840];
         var10 = 0;

         int var11;
         for(var11 = 0; var11 < this.field1711; ++var11) {
            if(var9[var11] > 0 && this.field1712[var11] == 0) {
               var8.field1826[var10] = this.field1739[var11] & '\uffff';
               var8.field1831[var10] = this.field1714[var11] & '\uffff';
               var8.field1828[var10] = this.field1715[var11] & '\uffff';
               var9[var11] = var10++;
            } else {
               var9[var11] = -1;
            }
         }

         var8.field1822 = new byte[this.field1735];

         for(var11 = 0; var11 < this.field1735; ++var11) {
            if(this.field1707[var11] != -1) {
               var8.field1822[var11] = (byte)var9[this.field1707[var11] & 255];
            } else {
               var8.field1822[var11] = -1;
            }
         }
      }

      for(int var16 = 0; var16 < this.field1735; ++var16) {
         byte var17;
         if(this.field1704 == null) {
            var17 = 0;
         } else {
            var17 = this.field1704[var16];
         }

         byte var18;
         if(this.field1706 == null) {
            var18 = 0;
         } else {
            var18 = this.field1706[var16];
         }

         short var12;
         if(this.field1731 == null) {
            var12 = -1;
         } else {
            var12 = this.field1731[var16];
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
                  var19 = this.field1701[var16];
                  var14 = var1 + (var3 * var19.field1458 + var4 * var19.field1459 + var5 * var19.field1460) / (var7 + var7 / 2);
                  var8.field1817[var16] = method2205(this.field1708[var16] & '\uffff', var14);
                  var8.field1827[var16] = -1;
               } else if(var17 == 3) {
                  var8.field1817[var16] = 128;
                  var8.field1827[var16] = -1;
               } else {
                  var8.field1827[var16] = -2;
               }
            } else {
               int var15 = this.field1708[var16] & '\uffff';
               if(this.field1729 != null && this.field1729[this.field1727[var16]] != null) {
                  var13 = this.field1729[this.field1727[var16]];
               } else {
                  var13 = this.field1728[this.field1727[var16]];
               }

               var14 = var1 + (var3 * var13.field1640 + var4 * var13.field1638 + var5 * var13.field1639) / (var7 * var13.field1647);
               var8.field1817[var16] = method2205(var15, var14);
               if(this.field1729 != null && this.field1729[this.field1709[var16]] != null) {
                  var13 = this.field1729[this.field1709[var16]];
               } else {
                  var13 = this.field1728[this.field1709[var16]];
               }

               var14 = var1 + (var3 * var13.field1640 + var4 * var13.field1638 + var5 * var13.field1639) / (var7 * var13.field1647);
               var8.field1818[var16] = method2205(var15, var14);
               if(this.field1729 != null && this.field1729[this.field1703[var16]] != null) {
                  var13 = this.field1729[this.field1703[var16]];
               } else {
                  var13 = this.field1728[this.field1703[var16]];
               }

               var14 = var1 + (var3 * var13.field1640 + var4 * var13.field1638 + var5 * var13.field1639) / (var7 * var13.field1647);
               var8.field1827[var16] = method2205(var15, var14);
            }
         } else if(var17 != 0) {
            if(var17 == 1) {
               var19 = this.field1701[var16];
               var14 = var1 + (var3 * var19.field1458 + var4 * var19.field1459 + var5 * var19.field1460) / (var7 + var7 / 2);
               var8.field1817[var16] = method2183(var14);
               var8.field1827[var16] = -1;
            } else {
               var8.field1827[var16] = -2;
            }
         } else {
            if(this.field1729 != null && this.field1729[this.field1727[var16]] != null) {
               var13 = this.field1729[this.field1727[var16]];
            } else {
               var13 = this.field1728[this.field1727[var16]];
            }

            var14 = var1 + (var3 * var13.field1640 + var4 * var13.field1638 + var5 * var13.field1639) / (var7 * var13.field1647);
            var8.field1817[var16] = method2183(var14);
            if(this.field1729 != null && this.field1729[this.field1709[var16]] != null) {
               var13 = this.field1729[this.field1709[var16]];
            } else {
               var13 = this.field1728[this.field1709[var16]];
            }

            var14 = var1 + (var3 * var13.field1640 + var4 * var13.field1638 + var5 * var13.field1639) / (var7 * var13.field1647);
            var8.field1818[var16] = method2183(var14);
            if(this.field1729 != null && this.field1729[this.field1703[var16]] != null) {
               var13 = this.field1729[this.field1703[var16]];
            } else {
               var13 = this.field1728[this.field1703[var16]];
            }

            var14 = var1 + (var3 * var13.field1640 + var4 * var13.field1638 + var5 * var13.field1639) / (var7 * var13.field1647);
            var8.field1827[var16] = method2183(var14);
         }
      }

      this.method2168();
      var8.field1809 = this.field1720;
      var8.field1810 = this.field1697;
      var8.field1845 = this.field1698;
      var8.field1812 = this.field1699;
      var8.field1813 = this.field1735;
      var8.field1834 = this.field1727;
      var8.field1815 = this.field1709;
      var8.field1816 = this.field1703;
      var8.field1861 = this.field1702;
      var8.field1866 = this.field1706;
      var8.field1825 = this.field1730;
      var8.field1857 = this.field1725;
      var8.field1830 = this.field1726;
      var8.field1823 = this.field1731;
      return var8;
   }

   @ObfuscatedName("as")
   static final int method2183(int var0) {
      if(var0 < 2) {
         var0 = 2;
      } else if(var0 > 126) {
         var0 = 126;
      }

      return var0;
   }

   static {
      field1741 = class91.field1602;
      field1742 = class91.field1603;
   }

   @ObfuscatedName("c")
   public void method2189(short var1, short var2) {
      if(this.field1731 != null) {
         for(int var3 = 0; var3 < this.field1735; ++var3) {
            if(this.field1731[var3] == var1) {
               this.field1731[var3] = var2;
            }
         }

      }
   }

   class100() {
   }

   @ObfuscatedName("d")
   public void method2196() {
      for(int var1 = 0; var1 < this.field1720; ++var1) {
         int var2 = this.field1697[var1];
         this.field1697[var1] = this.field1699[var1];
         this.field1699[var1] = -var2;
      }

      this.method2210();
   }

   @ObfuscatedName("u")
   public void method2201(short var1, short var2) {
      for(int var3 = 0; var3 < this.field1735; ++var3) {
         if(this.field1708[var3] == var1) {
            this.field1708[var3] = var2;
         }
      }

   }

   @ObfuscatedName("ad")
   static final int method2205(int var0, int var1) {
      var1 = var1 * (var0 & 127) >> 7;
      if(var1 < 2) {
         var1 = 2;
      } else if(var1 > 126) {
         var1 = 126;
      }

      return (var0 & 'ﾀ') + var1;
   }

   @ObfuscatedName("v")
   void method2210() {
      this.field1728 = null;
      this.field1729 = null;
      this.field1701 = null;
      this.field1737 = false;
   }
}
