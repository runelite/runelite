import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("ModelData")
public class class100 extends class85 {
   @ObfuscatedName("aa")
   int field1697;
   @ObfuscatedName("j")
   int[] field1698;
   @ObfuscatedName("p")
   int[] field1699;
   @ObfuscatedName("x")
   int[] field1700;
   @ObfuscatedName("d")
   int field1701 = 0;
   @ObfuscatedName("aq")
   int field1702;
   @ObfuscatedName("ar")
   static int[] field1703 = new int[10000];
   @ObfuscatedName("b")
   int[] field1704;
   @ObfuscatedName("k")
   byte[] field1705;
   @ObfuscatedName("c")
   byte[] field1706;
   @ObfuscatedName("l")
   byte[] field1707;
   @ObfuscatedName("t")
   byte[] field1708;
   @ObfuscatedName("at")
   static int field1709 = 0;
   @ObfuscatedName("r")
   short[] field1710;
   @ObfuscatedName("m")
   byte field1711 = 0;
   @ObfuscatedName("e")
   int field1712;
   @ObfuscatedName("ap")
   int[][] field1713;
   @ObfuscatedName("z")
   short[] field1714;
   @ObfuscatedName("a")
   short[] field1715;
   @ObfuscatedName("w")
   short[] field1716;
   @ObfuscatedName("as")
   public short field1717;
   @ObfuscatedName("an")
   int[] field1718;
   @ObfuscatedName("f")
   short[] field1719;
   @ObfuscatedName("q")
   short[] field1720;
   @ObfuscatedName("ad")
   int[] field1721;
   @ObfuscatedName("aw")
   static int[] field1722 = new int[10000];
   @ObfuscatedName("ab")
   byte[] field1723;
   @ObfuscatedName("al")
   static int[] field1724;
   @ObfuscatedName("g")
   short[] field1725;
   @ObfuscatedName("au")
   int[][] field1726;
   @ObfuscatedName("u")
   int[] field1727;
   @ObfuscatedName("am")
   class84[] field1728;
   @ObfuscatedName("ae")
   class96[] field1729;
   @ObfuscatedName("ao")
   class96[] field1730;
   @ObfuscatedName("n")
   short[] field1731;
   @ObfuscatedName("ai")
   public short field1732;
   @ObfuscatedName("ah")
   boolean field1733 = false;
   @ObfuscatedName("ax")
   int field1734;
   @ObfuscatedName("v")
   short[] field1735;
   @ObfuscatedName("s")
   int field1736 = 0;
   @ObfuscatedName("ay")
   int field1737;
   @ObfuscatedName("h")
   byte[] field1738;
   @ObfuscatedName("o")
   int[] field1739;
   @ObfuscatedName("y")
   short[] field1740;
   @ObfuscatedName("i")
   short[] field1741;
   @ObfuscatedName("af")
   static int[] field1742;
   @ObfuscatedName("aj")
   int field1743;

   public class100(class100[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      boolean var8 = false;
      this.field1736 = 0;
      this.field1701 = 0;
      this.field1712 = 0;
      this.field1711 = -1;

      int var9;
      class100 var10;
      for(var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if(var10 != null) {
            this.field1736 += var10.field1736;
            this.field1701 += var10.field1701;
            this.field1712 += var10.field1712;
            if(var10.field1706 != null) {
               var4 = true;
            } else {
               if(this.field1711 == -1) {
                  this.field1711 = var10.field1711;
               }

               if(this.field1711 != var10.field1711) {
                  var4 = true;
               }
            }

            var3 |= var10.field1705 != null;
            var5 |= var10.field1707 != null;
            var6 |= var10.field1718 != null;
            var7 |= var10.field1710 != null;
            var8 |= var10.field1708 != null;
         }
      }

      this.field1698 = new int[this.field1736];
      this.field1699 = new int[this.field1736];
      this.field1700 = new int[this.field1736];
      this.field1721 = new int[this.field1736];
      this.field1727 = new int[this.field1701];
      this.field1739 = new int[this.field1701];
      this.field1704 = new int[this.field1701];
      if(var3) {
         this.field1705 = new byte[this.field1701];
      }

      if(var4) {
         this.field1706 = new byte[this.field1701];
      }

      if(var5) {
         this.field1707 = new byte[this.field1701];
      }

      if(var6) {
         this.field1718 = new int[this.field1701];
      }

      if(var7) {
         this.field1710 = new short[this.field1701];
      }

      if(var8) {
         this.field1708 = new byte[this.field1701];
      }

      this.field1741 = new short[this.field1701];
      if(this.field1712 > 0) {
         this.field1738 = new byte[this.field1712];
         this.field1714 = new short[this.field1712];
         this.field1715 = new short[this.field1712];
         this.field1716 = new short[this.field1712];
         this.field1725 = new short[this.field1712];
         this.field1740 = new short[this.field1712];
         this.field1719 = new short[this.field1712];
         this.field1720 = new short[this.field1712];
         this.field1723 = new byte[this.field1712];
         this.field1731 = new short[this.field1712];
         this.field1735 = new short[this.field1712];
      }

      this.field1736 = 0;
      this.field1701 = 0;
      this.field1712 = 0;

      for(var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if(var10 != null) {
            int var11;
            for(var11 = 0; var11 < var10.field1701; ++var11) {
               if(var3 && var10.field1705 != null) {
                  this.field1705[this.field1701] = var10.field1705[var11];
               }

               if(var4) {
                  if(var10.field1706 != null) {
                     this.field1706[this.field1701] = var10.field1706[var11];
                  } else {
                     this.field1706[this.field1701] = var10.field1711;
                  }
               }

               if(var5 && var10.field1707 != null) {
                  this.field1707[this.field1701] = var10.field1707[var11];
               }

               if(var6 && var10.field1718 != null) {
                  this.field1718[this.field1701] = var10.field1718[var11];
               }

               if(var7) {
                  if(var10.field1710 != null) {
                     this.field1710[this.field1701] = var10.field1710[var11];
                  } else {
                     this.field1710[this.field1701] = -1;
                  }
               }

               if(var8) {
                  if(var10.field1708 != null && var10.field1708[var11] != -1) {
                     this.field1708[this.field1701] = (byte)(var10.field1708[var11] + this.field1712);
                  } else {
                     this.field1708[this.field1701] = -1;
                  }
               }

               this.field1741[this.field1701] = var10.field1741[var11];
               this.field1727[this.field1701] = this.method2259(var10, var10.field1727[var11]);
               this.field1739[this.field1701] = this.method2259(var10, var10.field1739[var11]);
               this.field1704[this.field1701] = this.method2259(var10, var10.field1704[var11]);
               ++this.field1701;
            }

            for(var11 = 0; var11 < var10.field1712; ++var11) {
               byte var12 = this.field1738[this.field1712] = var10.field1738[var11];
               if(var12 == 0) {
                  this.field1714[this.field1712] = (short)this.method2259(var10, var10.field1714[var11]);
                  this.field1715[this.field1712] = (short)this.method2259(var10, var10.field1715[var11]);
                  this.field1716[this.field1712] = (short)this.method2259(var10, var10.field1716[var11]);
               }

               if(var12 >= 1 && var12 <= 3) {
                  this.field1714[this.field1712] = var10.field1714[var11];
                  this.field1715[this.field1712] = var10.field1715[var11];
                  this.field1716[this.field1712] = var10.field1716[var11];
                  this.field1725[this.field1712] = var10.field1725[var11];
                  this.field1740[this.field1712] = var10.field1740[var11];
                  this.field1719[this.field1712] = var10.field1719[var11];
                  this.field1720[this.field1712] = var10.field1720[var11];
                  this.field1723[this.field1712] = var10.field1723[var11];
                  this.field1731[this.field1712] = var10.field1731[var11];
               }

               if(var12 == 2) {
                  this.field1735[this.field1712] = var10.field1735[var11];
               }

               ++this.field1712;
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass167;II)Lclass100;",
      garbageValue = "0"
   )
   public static class100 method2181(class167 var0, int var1, int var2) {
      byte[] var3 = var0.method3239(var1, var2);
      return var3 == null?null:new class100(var3);
   }

   class100(byte[] var1) {
      if(var1[var1.length - 1] == -1 && var1[var1.length - 2] == -1) {
         this.method2182(var1);
      } else {
         this.method2183(var1);
      }

   }

   @ObfuscatedName("j")
   void method2182(byte[] var1) {
      class119 var2 = new class119(var1);
      class119 var3 = new class119(var1);
      class119 var4 = new class119(var1);
      class119 var5 = new class119(var1);
      class119 var6 = new class119(var1);
      class119 var7 = new class119(var1);
      class119 var8 = new class119(var1);
      var2.field2005 = var1.length - 23;
      int var9 = var2.method2584();
      int var10 = var2.method2584();
      int var11 = var2.method2492();
      int var12 = var2.method2492();
      int var13 = var2.method2492();
      int var14 = var2.method2492();
      int var15 = var2.method2492();
      int var16 = var2.method2492();
      int var17 = var2.method2492();
      int var18 = var2.method2584();
      int var19 = var2.method2584();
      int var20 = var2.method2584();
      int var21 = var2.method2584();
      int var22 = var2.method2584();
      int var23 = 0;
      int var24 = 0;
      int var25 = 0;
      int var26;
      if(var11 > 0) {
         this.field1738 = new byte[var11];
         var2.field2005 = 0;

         for(var26 = 0; var26 < var11; ++var26) {
            byte var27 = this.field1738[var26] = var2.method2493();
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
      int var56 = var26;
      if(var12 == 1) {
         var26 += var10;
      }

      int var28 = var26;
      var26 += var10;
      int var29 = var26;
      if(var13 == 255) {
         var26 += var10;
      }

      int var30 = var26;
      if(var15 == 1) {
         var26 += var10;
      }

      int var31 = var26;
      if(var17 == 1) {
         var26 += var9;
      }

      int var32 = var26;
      if(var14 == 1) {
         var26 += var10;
      }

      int var33 = var26;
      var26 += var21;
      int var34 = var26;
      if(var16 == 1) {
         var26 += var10 * 2;
      }

      int var35 = var26;
      var26 += var22;
      int var36 = var26;
      var26 += var10 * 2;
      int var37 = var26;
      var26 += var18;
      int var38 = var26;
      var26 += var19;
      int var39 = var26;
      var26 += var20;
      int var40 = var26;
      var26 += var23 * 6;
      int var41 = var26;
      var26 += var24 * 6;
      int var42 = var26;
      var26 += var24 * 6;
      int var43 = var26;
      var26 += var24 * 2;
      int var44 = var26;
      var26 += var24;
      int var45 = var26;
      var26 += var24 * 2 + var25 * 2;
      this.field1736 = var9;
      this.field1701 = var10;
      this.field1712 = var11;
      this.field1698 = new int[var9];
      this.field1699 = new int[var9];
      this.field1700 = new int[var9];
      this.field1727 = new int[var10];
      this.field1739 = new int[var10];
      this.field1704 = new int[var10];
      if(var17 == 1) {
         this.field1721 = new int[var9];
      }

      if(var12 == 1) {
         this.field1705 = new byte[var10];
      }

      if(var13 == 255) {
         this.field1706 = new byte[var10];
      } else {
         this.field1711 = (byte)var13;
      }

      if(var14 == 1) {
         this.field1707 = new byte[var10];
      }

      if(var15 == 1) {
         this.field1718 = new int[var10];
      }

      if(var16 == 1) {
         this.field1710 = new short[var10];
      }

      if(var16 == 1 && var11 > 0) {
         this.field1708 = new byte[var10];
      }

      this.field1741 = new short[var10];
      if(var11 > 0) {
         this.field1714 = new short[var11];
         this.field1715 = new short[var11];
         this.field1716 = new short[var11];
         if(var24 > 0) {
            this.field1725 = new short[var24];
            this.field1740 = new short[var24];
            this.field1719 = new short[var24];
            this.field1720 = new short[var24];
            this.field1723 = new byte[var24];
            this.field1731 = new short[var24];
         }

         if(var25 > 0) {
            this.field1735 = new short[var25];
         }
      }

      var2.field2005 = var11;
      var3.field2005 = var37;
      var4.field2005 = var38;
      var5.field2005 = var39;
      var6.field2005 = var31;
      int var46 = 0;
      int var47 = 0;
      int var48 = 0;

      int var49;
      int var50;
      int var51;
      int var52;
      int var53;
      for(var49 = 0; var49 < var9; ++var49) {
         var50 = var2.method2492();
         var51 = 0;
         if((var50 & 1) != 0) {
            var51 = var3.method2585();
         }

         var52 = 0;
         if((var50 & 2) != 0) {
            var52 = var4.method2585();
         }

         var53 = 0;
         if((var50 & 4) != 0) {
            var53 = var5.method2585();
         }

         this.field1698[var49] = var46 + var51;
         this.field1699[var49] = var47 + var52;
         this.field1700[var49] = var48 + var53;
         var46 = this.field1698[var49];
         var47 = this.field1699[var49];
         var48 = this.field1700[var49];
         if(var17 == 1) {
            this.field1721[var49] = var6.method2492();
         }
      }

      var2.field2005 = var36;
      var3.field2005 = var56;
      var4.field2005 = var29;
      var5.field2005 = var32;
      var6.field2005 = var30;
      var7.field2005 = var34;
      var8.field2005 = var35;

      for(var49 = 0; var49 < var10; ++var49) {
         this.field1741[var49] = (short)var2.method2584();
         if(var12 == 1) {
            this.field1705[var49] = var3.method2493();
         }

         if(var13 == 255) {
            this.field1706[var49] = var4.method2493();
         }

         if(var14 == 1) {
            this.field1707[var49] = var5.method2493();
         }

         if(var15 == 1) {
            this.field1718[var49] = var6.method2492();
         }

         if(var16 == 1) {
            this.field1710[var49] = (short)(var7.method2584() - 1);
         }

         if(this.field1708 != null && this.field1710[var49] != -1) {
            this.field1708[var49] = (byte)(var8.method2492() - 1);
         }
      }

      var2.field2005 = var33;
      var3.field2005 = var28;
      var49 = 0;
      var50 = 0;
      var51 = 0;
      var52 = 0;

      int var54;
      for(var53 = 0; var53 < var10; ++var53) {
         var54 = var3.method2492();
         if(var54 == 1) {
            var49 = var2.method2585() + var52;
            var50 = var2.method2585() + var49;
            var51 = var2.method2585() + var50;
            var52 = var51;
            this.field1727[var53] = var49;
            this.field1739[var53] = var50;
            this.field1704[var53] = var51;
         }

         if(var54 == 2) {
            var50 = var51;
            var51 = var2.method2585() + var52;
            var52 = var51;
            this.field1727[var53] = var49;
            this.field1739[var53] = var50;
            this.field1704[var53] = var51;
         }

         if(var54 == 3) {
            var49 = var51;
            var51 = var2.method2585() + var52;
            var52 = var51;
            this.field1727[var53] = var49;
            this.field1739[var53] = var50;
            this.field1704[var53] = var51;
         }

         if(var54 == 4) {
            int var55 = var49;
            var49 = var50;
            var50 = var55;
            var51 = var2.method2585() + var52;
            var52 = var51;
            this.field1727[var53] = var49;
            this.field1739[var53] = var55;
            this.field1704[var53] = var51;
         }
      }

      var2.field2005 = var40;
      var3.field2005 = var41;
      var4.field2005 = var42;
      var5.field2005 = var43;
      var6.field2005 = var44;
      var7.field2005 = var45;

      for(var53 = 0; var53 < var11; ++var53) {
         var54 = this.field1738[var53] & 255;
         if(var54 == 0) {
            this.field1714[var53] = (short)var2.method2584();
            this.field1715[var53] = (short)var2.method2584();
            this.field1716[var53] = (short)var2.method2584();
         }

         if(var54 == 1) {
            this.field1714[var53] = (short)var3.method2584();
            this.field1715[var53] = (short)var3.method2584();
            this.field1716[var53] = (short)var3.method2584();
            this.field1725[var53] = (short)var4.method2584();
            this.field1740[var53] = (short)var4.method2584();
            this.field1719[var53] = (short)var4.method2584();
            this.field1720[var53] = (short)var5.method2584();
            this.field1723[var53] = var6.method2493();
            this.field1731[var53] = (short)var7.method2584();
         }

         if(var54 == 2) {
            this.field1714[var53] = (short)var3.method2584();
            this.field1715[var53] = (short)var3.method2584();
            this.field1716[var53] = (short)var3.method2584();
            this.field1725[var53] = (short)var4.method2584();
            this.field1740[var53] = (short)var4.method2584();
            this.field1719[var53] = (short)var4.method2584();
            this.field1720[var53] = (short)var5.method2584();
            this.field1723[var53] = var6.method2493();
            this.field1731[var53] = (short)var7.method2584();
            this.field1735[var53] = (short)var7.method2584();
         }

         if(var54 == 3) {
            this.field1714[var53] = (short)var3.method2584();
            this.field1715[var53] = (short)var3.method2584();
            this.field1716[var53] = (short)var3.method2584();
            this.field1725[var53] = (short)var4.method2584();
            this.field1740[var53] = (short)var4.method2584();
            this.field1719[var53] = (short)var4.method2584();
            this.field1720[var53] = (short)var5.method2584();
            this.field1723[var53] = var6.method2493();
            this.field1731[var53] = (short)var7.method2584();
         }
      }

      var2.field2005 = var26;
      var53 = var2.method2492();
      if(var53 != 0) {
         new class90();
         var2.method2584();
         var2.method2584();
         var2.method2584();
         var2.method2497();
      }

   }

   @ObfuscatedName("x")
   void method2183(byte[] var1) {
      boolean var2 = false;
      boolean var3 = false;
      class119 var4 = new class119(var1);
      class119 var5 = new class119(var1);
      class119 var6 = new class119(var1);
      class119 var7 = new class119(var1);
      class119 var8 = new class119(var1);
      var4.field2005 = var1.length - 18;
      int var9 = var4.method2584();
      int var10 = var4.method2584();
      int var11 = var4.method2492();
      int var12 = var4.method2492();
      int var13 = var4.method2492();
      int var14 = var4.method2492();
      int var15 = var4.method2492();
      int var16 = var4.method2492();
      int var17 = var4.method2584();
      int var18 = var4.method2584();
      int var19 = var4.method2584();
      int var20 = var4.method2584();
      byte var21 = 0;
      int var22 = var21 + var9;
      int var23 = var22;
      var22 += var10;
      int var24 = var22;
      if(var13 == 255) {
         var22 += var10;
      }

      int var25 = var22;
      if(var15 == 1) {
         var22 += var10;
      }

      int var26 = var22;
      if(var12 == 1) {
         var22 += var10;
      }

      int var27 = var22;
      if(var16 == 1) {
         var22 += var9;
      }

      int var28 = var22;
      if(var14 == 1) {
         var22 += var10;
      }

      int var29 = var22;
      var22 += var20;
      int var30 = var22;
      var22 += var10 * 2;
      int var31 = var22;
      var22 += var11 * 6;
      int var32 = var22;
      var22 += var17;
      int var33 = var22;
      var22 += var18;
      int var10000 = var22 + var19;
      this.field1736 = var9;
      this.field1701 = var10;
      this.field1712 = var11;
      this.field1698 = new int[var9];
      this.field1699 = new int[var9];
      this.field1700 = new int[var9];
      this.field1727 = new int[var10];
      this.field1739 = new int[var10];
      this.field1704 = new int[var10];
      if(var11 > 0) {
         this.field1738 = new byte[var11];
         this.field1714 = new short[var11];
         this.field1715 = new short[var11];
         this.field1716 = new short[var11];
      }

      if(var16 == 1) {
         this.field1721 = new int[var9];
      }

      if(var12 == 1) {
         this.field1705 = new byte[var10];
         this.field1708 = new byte[var10];
         this.field1710 = new short[var10];
      }

      if(var13 == 255) {
         this.field1706 = new byte[var10];
      } else {
         this.field1711 = (byte)var13;
      }

      if(var14 == 1) {
         this.field1707 = new byte[var10];
      }

      if(var15 == 1) {
         this.field1718 = new int[var10];
      }

      this.field1741 = new short[var10];
      var4.field2005 = var21;
      var5.field2005 = var32;
      var6.field2005 = var33;
      var7.field2005 = var22;
      var8.field2005 = var27;
      int var35 = 0;
      int var36 = 0;
      int var37 = 0;

      int var38;
      int var39;
      int var40;
      int var41;
      int var42;
      for(var38 = 0; var38 < var9; ++var38) {
         var39 = var4.method2492();
         var40 = 0;
         if((var39 & 1) != 0) {
            var40 = var5.method2585();
         }

         var41 = 0;
         if((var39 & 2) != 0) {
            var41 = var6.method2585();
         }

         var42 = 0;
         if((var39 & 4) != 0) {
            var42 = var7.method2585();
         }

         this.field1698[var38] = var35 + var40;
         this.field1699[var38] = var36 + var41;
         this.field1700[var38] = var37 + var42;
         var35 = this.field1698[var38];
         var36 = this.field1699[var38];
         var37 = this.field1700[var38];
         if(var16 == 1) {
            this.field1721[var38] = var8.method2492();
         }
      }

      var4.field2005 = var30;
      var5.field2005 = var26;
      var6.field2005 = var24;
      var7.field2005 = var28;
      var8.field2005 = var25;

      for(var38 = 0; var38 < var10; ++var38) {
         this.field1741[var38] = (short)var4.method2584();
         if(var12 == 1) {
            var39 = var5.method2492();
            if((var39 & 1) == 1) {
               this.field1705[var38] = 1;
               var2 = true;
            } else {
               this.field1705[var38] = 0;
            }

            if((var39 & 2) == 2) {
               this.field1708[var38] = (byte)(var39 >> 2);
               this.field1710[var38] = this.field1741[var38];
               this.field1741[var38] = 127;
               if(this.field1710[var38] != -1) {
                  var3 = true;
               }
            } else {
               this.field1708[var38] = -1;
               this.field1710[var38] = -1;
            }
         }

         if(var13 == 255) {
            this.field1706[var38] = var6.method2493();
         }

         if(var14 == 1) {
            this.field1707[var38] = var7.method2493();
         }

         if(var15 == 1) {
            this.field1718[var38] = var8.method2492();
         }
      }

      var4.field2005 = var29;
      var5.field2005 = var23;
      var38 = 0;
      var39 = 0;
      var40 = 0;
      var41 = 0;

      int var43;
      int var44;
      for(var42 = 0; var42 < var10; ++var42) {
         var43 = var5.method2492();
         if(var43 == 1) {
            var38 = var4.method2585() + var41;
            var39 = var4.method2585() + var38;
            var40 = var4.method2585() + var39;
            var41 = var40;
            this.field1727[var42] = var38;
            this.field1739[var42] = var39;
            this.field1704[var42] = var40;
         }

         if(var43 == 2) {
            var39 = var40;
            var40 = var4.method2585() + var41;
            var41 = var40;
            this.field1727[var42] = var38;
            this.field1739[var42] = var39;
            this.field1704[var42] = var40;
         }

         if(var43 == 3) {
            var38 = var40;
            var40 = var4.method2585() + var41;
            var41 = var40;
            this.field1727[var42] = var38;
            this.field1739[var42] = var39;
            this.field1704[var42] = var40;
         }

         if(var43 == 4) {
            var44 = var38;
            var38 = var39;
            var39 = var44;
            var40 = var4.method2585() + var41;
            var41 = var40;
            this.field1727[var42] = var38;
            this.field1739[var42] = var44;
            this.field1704[var42] = var40;
         }
      }

      var4.field2005 = var31;

      for(var42 = 0; var42 < var11; ++var42) {
         this.field1738[var42] = 0;
         this.field1714[var42] = (short)var4.method2584();
         this.field1715[var42] = (short)var4.method2584();
         this.field1716[var42] = (short)var4.method2584();
      }

      if(this.field1708 != null) {
         boolean var45 = false;

         for(var43 = 0; var43 < var10; ++var43) {
            var44 = this.field1708[var43] & 255;
            if(var44 != 255) {
               if((this.field1714[var44] & '\uffff') == this.field1727[var43] && (this.field1715[var44] & '\uffff') == this.field1739[var43] && (this.field1716[var44] & '\uffff') == this.field1704[var43]) {
                  this.field1708[var43] = -1;
               } else {
                  var45 = true;
               }
            }
         }

         if(!var45) {
            this.field1708 = null;
         }
      }

      if(!var3) {
         this.field1710 = null;
      }

      if(!var2) {
         this.field1705 = null;
      }

   }

   @ObfuscatedName("y")
   void method2184() {
      if(!this.field1733) {
         super.field1465 = 0;
         this.field1734 = 0;
         this.field1697 = 999999;
         this.field1702 = -999999;
         this.field1737 = -99999;
         this.field1743 = 99999;

         for(int var1 = 0; var1 < this.field1736; ++var1) {
            int var2 = this.field1698[var1];
            int var3 = this.field1699[var1];
            int var4 = this.field1700[var1];
            if(var2 < this.field1697) {
               this.field1697 = var2;
            }

            if(var2 > this.field1702) {
               this.field1702 = var2;
            }

            if(var4 < this.field1743) {
               this.field1743 = var4;
            }

            if(var4 > this.field1737) {
               this.field1737 = var4;
            }

            if(-var3 > super.field1465) {
               super.field1465 = -var3;
            }

            if(var3 > this.field1734) {
               this.field1734 = var3;
            }
         }

         this.field1733 = true;
      }

   }

   @ObfuscatedSignature(
      signature = "(Lclass100;ZZZZ)V",
      garbageValue = "1"
   )
   public class100(class100 var1, boolean var2, boolean var3, boolean var4, boolean var5) {
      this.field1736 = var1.field1736;
      this.field1701 = var1.field1701;
      this.field1712 = var1.field1712;
      this.field1698 = var1.field1698;
      this.field1699 = var1.field1699;
      this.field1700 = var1.field1700;
      this.field1741 = var1.field1741;
      this.field1710 = var1.field1710;
      this.field1707 = var1.field1707;
      this.field1727 = var1.field1727;
      this.field1739 = var1.field1739;
      this.field1704 = var1.field1704;
      this.field1705 = var1.field1705;
      this.field1706 = var1.field1706;
      this.field1708 = var1.field1708;
      this.field1711 = var1.field1711;
      this.field1738 = var1.field1738;
      this.field1714 = var1.field1714;
      this.field1715 = var1.field1715;
      this.field1716 = var1.field1716;
      this.field1725 = var1.field1725;
      this.field1740 = var1.field1740;
      this.field1719 = var1.field1719;
      this.field1720 = var1.field1720;
      this.field1723 = var1.field1723;
      this.field1731 = var1.field1731;
      this.field1735 = var1.field1735;
      this.field1721 = var1.field1721;
      this.field1718 = var1.field1718;
      this.field1726 = var1.field1726;
      this.field1713 = var1.field1713;
      this.field1729 = var1.field1729;
      this.field1728 = var1.field1728;
      this.field1730 = var1.field1730;
      this.field1717 = var1.field1717;
      this.field1732 = var1.field1732;
   }

   @ObfuscatedName("u")
   public class100 method2186() {
      class100 var1 = new class100();
      if(this.field1705 != null) {
         var1.field1705 = new byte[this.field1701];

         for(int var2 = 0; var2 < this.field1701; ++var2) {
            var1.field1705[var2] = this.field1705[var2];
         }
      }

      var1.field1736 = this.field1736;
      var1.field1701 = this.field1701;
      var1.field1712 = this.field1712;
      var1.field1698 = this.field1698;
      var1.field1699 = this.field1699;
      var1.field1700 = this.field1700;
      var1.field1727 = this.field1727;
      var1.field1739 = this.field1739;
      var1.field1704 = this.field1704;
      var1.field1706 = this.field1706;
      var1.field1707 = this.field1707;
      var1.field1708 = this.field1708;
      var1.field1741 = this.field1741;
      var1.field1710 = this.field1710;
      var1.field1711 = this.field1711;
      var1.field1738 = this.field1738;
      var1.field1714 = this.field1714;
      var1.field1715 = this.field1715;
      var1.field1716 = this.field1716;
      var1.field1725 = this.field1725;
      var1.field1740 = this.field1740;
      var1.field1719 = this.field1719;
      var1.field1720 = this.field1720;
      var1.field1723 = this.field1723;
      var1.field1731 = this.field1731;
      var1.field1735 = this.field1735;
      var1.field1721 = this.field1721;
      var1.field1718 = this.field1718;
      var1.field1726 = this.field1726;
      var1.field1713 = this.field1713;
      var1.field1729 = this.field1729;
      var1.field1728 = this.field1728;
      var1.field1717 = this.field1717;
      var1.field1732 = this.field1732;
      return var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([[IIIIZI)Lclass100;",
      garbageValue = "1"
   )
   public class100 method2187(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2184();
      int var7 = var2 + this.field1697;
      int var8 = var2 + this.field1702;
      int var9 = var4 + this.field1743;
      int var10 = var4 + this.field1737;
      if(var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
         var7 >>= 7;
         var8 = var8 + 127 >> 7;
         var9 >>= 7;
         var10 = var10 + 127 >> 7;
         if(var1[var7][var9] == var3 && var1[var8][var9] == var3 && var1[var7][var10] == var3 && var1[var8][var10] == var3) {
            return this;
         } else {
            class100 var11 = new class100();
            var11.field1736 = this.field1736;
            var11.field1701 = this.field1701;
            var11.field1712 = this.field1712;
            var11.field1698 = this.field1698;
            var11.field1700 = this.field1700;
            var11.field1727 = this.field1727;
            var11.field1739 = this.field1739;
            var11.field1704 = this.field1704;
            var11.field1705 = this.field1705;
            var11.field1706 = this.field1706;
            var11.field1707 = this.field1707;
            var11.field1708 = this.field1708;
            var11.field1741 = this.field1741;
            var11.field1710 = this.field1710;
            var11.field1711 = this.field1711;
            var11.field1738 = this.field1738;
            var11.field1714 = this.field1714;
            var11.field1715 = this.field1715;
            var11.field1716 = this.field1716;
            var11.field1725 = this.field1725;
            var11.field1740 = this.field1740;
            var11.field1719 = this.field1719;
            var11.field1720 = this.field1720;
            var11.field1723 = this.field1723;
            var11.field1731 = this.field1731;
            var11.field1735 = this.field1735;
            var11.field1721 = this.field1721;
            var11.field1718 = this.field1718;
            var11.field1726 = this.field1726;
            var11.field1713 = this.field1713;
            var11.field1717 = this.field1717;
            var11.field1732 = this.field1732;
            var11.field1699 = new int[var11.field1736];
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
               for(var12 = 0; var12 < var11.field1736; ++var12) {
                  var13 = this.field1698[var12] + var2;
                  var14 = this.field1700[var12] + var4;
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var1[var17 + 1][var18 + 1] * var15 >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.field1699[var12] = this.field1699[var12] + var21 - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1736; ++var12) {
                  var13 = (-this.field1699[var12] << 16) / super.field1465;
                  if(var13 < var6) {
                     var14 = this.field1698[var12] + var2;
                     var15 = this.field1700[var12] + var4;
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var1[var18 + 1][var19 + 1] * var16 >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.field1699[var12] = this.field1699[var12] + (var22 - var3) * (var6 - var13) / var6;
                  }
               }
            }

            var11.method2199();
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("k")
   public void method2189() {
      for(int var1 = 0; var1 < this.field1736; ++var1) {
         int var2 = this.field1698[var1];
         this.field1698[var1] = this.field1700[var1];
         this.field1700[var1] = -var2;
      }

      this.method2199();
   }

   @ObfuscatedName("c")
   public void method2190() {
      for(int var1 = 0; var1 < this.field1736; ++var1) {
         this.field1698[var1] = -this.field1698[var1];
         this.field1700[var1] = -this.field1700[var1];
      }

      this.method2199();
   }

   @ObfuscatedName("l")
   public void method2191() {
      for(int var1 = 0; var1 < this.field1736; ++var1) {
         int var2 = this.field1700[var1];
         this.field1700[var1] = this.field1698[var1];
         this.field1698[var1] = -var2;
      }

      this.method2199();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "256"
   )
   public void method2192(int var1) {
      int var2 = field1742[var1];
      int var3 = field1724[var1];

      for(int var4 = 0; var4 < this.field1736; ++var4) {
         int var5 = this.field1700[var4] * var2 + this.field1698[var4] * var3 >> 16;
         this.field1700[var4] = this.field1700[var4] * var3 - this.field1698[var4] * var2 >> 16;
         this.field1698[var4] = var5;
      }

      this.method2199();
   }

   @ObfuscatedName("m")
   public void method2193(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1736; ++var4) {
         this.field1698[var4] += var1;
         this.field1699[var4] += var2;
         this.field1700[var4] += var3;
      }

      this.method2199();
   }

   @ObfuscatedName("e")
   public void method2194(short var1, short var2) {
      for(int var3 = 0; var3 < this.field1701; ++var3) {
         if(this.field1741[var3] == var1) {
            this.field1741[var3] = var2;
         }
      }

   }

   @ObfuscatedName("h")
   public void method2195(short var1, short var2) {
      if(this.field1710 != null) {
         for(int var3 = 0; var3 < this.field1701; ++var3) {
            if(this.field1710[var3] == var1) {
               this.field1710[var3] = var2;
            }
         }
      }

   }

   @ObfuscatedName("a")
   public void method2197(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1736; ++var4) {
         this.field1698[var4] = this.field1698[var4] * var1 / 128;
         this.field1699[var4] = this.field1699[var4] * var2 / 128;
         this.field1700[var4] = this.field1700[var4] * var3 / 128;
      }

      this.method2199();
   }

   @ObfuscatedName("w")
   @Export("computeNormals")
   public void method2198() {
      if(this.field1729 == null) {
         this.field1729 = new class96[this.field1736];

         int var1;
         for(var1 = 0; var1 < this.field1736; ++var1) {
            this.field1729[var1] = new class96();
         }

         for(var1 = 0; var1 < this.field1701; ++var1) {
            int var2 = this.field1727[var1];
            int var3 = this.field1739[var1];
            int var4 = this.field1704[var1];
            int var5 = this.field1698[var3] - this.field1698[var2];
            int var6 = this.field1699[var3] - this.field1699[var2];
            int var7 = this.field1700[var3] - this.field1700[var2];
            int var8 = this.field1698[var4] - this.field1698[var2];
            int var9 = this.field1699[var4] - this.field1699[var2];
            int var10 = this.field1700[var4] - this.field1700[var2];
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
            if(this.field1705 == null) {
               var15 = 0;
            } else {
               var15 = this.field1705[var1];
            }

            if(var15 == 0) {
               class96 var16 = this.field1729[var2];
               var16.field1642 += var11;
               var16.field1638 += var12;
               var16.field1637 += var13;
               ++var16.field1640;
               var16 = this.field1729[var3];
               var16.field1642 += var11;
               var16.field1638 += var12;
               var16.field1637 += var13;
               ++var16.field1640;
               var16 = this.field1729[var4];
               var16.field1642 += var11;
               var16.field1638 += var12;
               var16.field1637 += var13;
               ++var16.field1640;
            } else if(var15 == 1) {
               if(this.field1728 == null) {
                  this.field1728 = new class84[this.field1701];
               }

               class84 var17 = this.field1728[var1] = new class84();
               var17.field1462 = var11;
               var17.field1459 = var12;
               var17.field1460 = var13;
            }
         }
      }

   }

   @ObfuscatedName("g")
   void method2199() {
      this.field1729 = null;
      this.field1730 = null;
      this.field1728 = null;
      this.field1733 = false;
   }

   @ObfuscatedName("f")
   static void method2201(class100 var0, class100 var1, int var2, int var3, int var4, boolean var5) {
      var0.method2184();
      var0.method2198();
      var1.method2184();
      var1.method2198();
      ++field1709;
      int var6 = 0;
      int[] var7 = var1.field1698;
      int var8 = var1.field1736;

      int var9;
      for(var9 = 0; var9 < var0.field1736; ++var9) {
         class96 var10 = var0.field1729[var9];
         if(var10.field1640 != 0) {
            int var11 = var0.field1699[var9] - var3;
            if(var11 <= var1.field1734) {
               int var12 = var0.field1698[var9] - var2;
               if(var12 >= var1.field1697 && var12 <= var1.field1702) {
                  int var13 = var0.field1700[var9] - var4;
                  if(var13 >= var1.field1743 && var13 <= var1.field1737) {
                     for(int var14 = 0; var14 < var8; ++var14) {
                        class96 var15 = var1.field1729[var14];
                        if(var12 == var7[var14] && var13 == var1.field1700[var14] && var11 == var1.field1699[var14] && var15.field1640 != 0) {
                           if(var0.field1730 == null) {
                              var0.field1730 = new class96[var0.field1736];
                           }

                           if(var1.field1730 == null) {
                              var1.field1730 = new class96[var8];
                           }

                           class96 var16 = var0.field1730[var9];
                           if(var16 == null) {
                              var16 = var0.field1730[var9] = new class96(var10);
                           }

                           class96 var17 = var1.field1730[var14];
                           if(var17 == null) {
                              var17 = var1.field1730[var14] = new class96(var15);
                           }

                           var16.field1642 += var15.field1642;
                           var16.field1638 += var15.field1638;
                           var16.field1637 += var15.field1637;
                           var16.field1640 += var15.field1640;
                           var17.field1642 += var10.field1642;
                           var17.field1638 += var10.field1638;
                           var17.field1637 += var10.field1637;
                           var17.field1640 += var10.field1640;
                           ++var6;
                           field1703[var9] = field1709;
                           field1722[var14] = field1709;
                        }
                     }
                  }
               }
            }
         }
      }

      if(var6 >= 3 && var5) {
         for(var9 = 0; var9 < var0.field1701; ++var9) {
            if(field1703[var0.field1727[var9]] == field1709 && field1703[var0.field1739[var9]] == field1709 && field1703[var0.field1704[var9]] == field1709) {
               if(var0.field1705 == null) {
                  var0.field1705 = new byte[var0.field1701];
               }

               var0.field1705[var9] = 2;
            }
         }

         for(var9 = 0; var9 < var1.field1701; ++var9) {
            if(field1722[var1.field1727[var9]] == field1709 && field1722[var1.field1739[var9]] == field1709 && field1722[var1.field1704[var9]] == field1709) {
               if(var1.field1705 == null) {
                  var1.field1705 = new byte[var1.field1701];
               }

               var1.field1705[var9] = 2;
            }
         }
      }

   }

   @ObfuscatedName("q")
   public final class105 method2202(int var1, int var2, int var3, int var4, int var5) {
      this.method2198();
      int var6 = (int)Math.sqrt((double)(var3 * var3 + var4 * var4 + var5 * var5));
      int var7 = var2 * var6 >> 8;
      class105 var8 = new class105();
      var8.field1820 = new int[this.field1701];
      var8.field1821 = new int[this.field1701];
      var8.field1832 = new int[this.field1701];
      if(this.field1712 > 0 && this.field1708 != null) {
         int[] var9 = new int[this.field1712];

         int var10;
         for(var10 = 0; var10 < this.field1701; ++var10) {
            if(this.field1708[var10] != -1) {
               ++var9[this.field1708[var10] & 255];
            }
         }

         var8.field1828 = 0;

         for(var10 = 0; var10 < this.field1712; ++var10) {
            if(var9[var10] > 0 && this.field1738[var10] == 0) {
               ++var8.field1828;
            }
         }

         var8.field1826 = new int[var8.field1828];
         var8.field1837 = new int[var8.field1828];
         var8.field1831 = new int[var8.field1828];
         var10 = 0;

         int var11;
         for(var11 = 0; var11 < this.field1712; ++var11) {
            if(var9[var11] > 0 && this.field1738[var11] == 0) {
               var8.field1826[var10] = this.field1714[var11] & '\uffff';
               var8.field1837[var10] = this.field1715[var11] & '\uffff';
               var8.field1831[var10] = this.field1716[var11] & '\uffff';
               var9[var11] = var10++;
            } else {
               var9[var11] = -1;
            }
         }

         var8.field1825 = new byte[this.field1701];

         for(var11 = 0; var11 < this.field1701; ++var11) {
            if(this.field1708[var11] != -1) {
               var8.field1825[var11] = (byte)var9[this.field1708[var11] & 255];
            } else {
               var8.field1825[var11] = -1;
            }
         }
      }

      for(int var17 = 0; var17 < this.field1701; ++var17) {
         byte var18;
         if(this.field1705 == null) {
            var18 = 0;
         } else {
            var18 = this.field1705[var17];
         }

         byte var19;
         if(this.field1707 == null) {
            var19 = 0;
         } else {
            var19 = this.field1707[var17];
         }

         short var12;
         if(this.field1710 == null) {
            var12 = -1;
         } else {
            var12 = this.field1710[var17];
         }

         if(var19 == -2) {
            var18 = 3;
         }

         if(var19 == -1) {
            var18 = 2;
         }

         class96 var13;
         int var14;
         class84 var15;
         if(var12 == -1) {
            if(var18 != 0) {
               if(var18 == 1) {
                  var15 = this.field1728[var17];
                  var14 = var1 + (var3 * var15.field1462 + var4 * var15.field1459 + var5 * var15.field1460) / (var7 + var7 / 2);
                  var8.field1820[var17] = method2219(this.field1741[var17] & '\uffff', var14);
                  var8.field1832[var17] = -1;
               } else if(var18 == 3) {
                  var8.field1820[var17] = 128;
                  var8.field1832[var17] = -1;
               } else {
                  var8.field1832[var17] = -2;
               }
            } else {
               int var16 = this.field1741[var17] & '\uffff';
               if(this.field1730 != null && this.field1730[this.field1727[var17]] != null) {
                  var13 = this.field1730[this.field1727[var17]];
               } else {
                  var13 = this.field1729[this.field1727[var17]];
               }

               var14 = var1 + (var3 * var13.field1642 + var4 * var13.field1638 + var5 * var13.field1637) / (var7 * var13.field1640);
               var8.field1820[var17] = method2219(var16, var14);
               if(this.field1730 != null && this.field1730[this.field1739[var17]] != null) {
                  var13 = this.field1730[this.field1739[var17]];
               } else {
                  var13 = this.field1729[this.field1739[var17]];
               }

               var14 = var1 + (var3 * var13.field1642 + var4 * var13.field1638 + var5 * var13.field1637) / (var7 * var13.field1640);
               var8.field1821[var17] = method2219(var16, var14);
               if(this.field1730 != null && this.field1730[this.field1704[var17]] != null) {
                  var13 = this.field1730[this.field1704[var17]];
               } else {
                  var13 = this.field1729[this.field1704[var17]];
               }

               var14 = var1 + (var3 * var13.field1642 + var4 * var13.field1638 + var5 * var13.field1637) / (var7 * var13.field1640);
               var8.field1832[var17] = method2219(var16, var14);
            }
         } else if(var18 != 0) {
            if(var18 == 1) {
               var15 = this.field1728[var17];
               var14 = var1 + (var3 * var15.field1462 + var4 * var15.field1459 + var5 * var15.field1460) / (var7 + var7 / 2);
               var8.field1820[var17] = method2253(var14);
               var8.field1832[var17] = -1;
            } else {
               var8.field1832[var17] = -2;
            }
         } else {
            if(this.field1730 != null && this.field1730[this.field1727[var17]] != null) {
               var13 = this.field1730[this.field1727[var17]];
            } else {
               var13 = this.field1729[this.field1727[var17]];
            }

            var14 = var1 + (var3 * var13.field1642 + var4 * var13.field1638 + var5 * var13.field1637) / (var7 * var13.field1640);
            var8.field1820[var17] = method2253(var14);
            if(this.field1730 != null && this.field1730[this.field1739[var17]] != null) {
               var13 = this.field1730[this.field1739[var17]];
            } else {
               var13 = this.field1729[this.field1739[var17]];
            }

            var14 = var1 + (var3 * var13.field1642 + var4 * var13.field1638 + var5 * var13.field1637) / (var7 * var13.field1640);
            var8.field1821[var17] = method2253(var14);
            if(this.field1730 != null && this.field1730[this.field1704[var17]] != null) {
               var13 = this.field1730[this.field1704[var17]];
            } else {
               var13 = this.field1729[this.field1704[var17]];
            }

            var14 = var1 + (var3 * var13.field1642 + var4 * var13.field1638 + var5 * var13.field1637) / (var7 * var13.field1640);
            var8.field1832[var17] = method2253(var14);
         }
      }

      this.method2241();
      var8.field1812 = this.field1736;
      var8.field1813 = this.field1698;
      var8.field1839 = this.field1699;
      var8.field1815 = this.field1700;
      var8.field1830 = this.field1701;
      var8.field1817 = this.field1727;
      var8.field1818 = this.field1739;
      var8.field1809 = this.field1704;
      var8.field1823 = this.field1706;
      var8.field1824 = this.field1707;
      var8.field1853 = this.field1711;
      var8.field1859 = this.field1726;
      var8.field1833 = this.field1713;
      var8.field1846 = this.field1710;
      return var8;
   }

   @ObfuscatedName("n")
   static final int method2219(int var0, int var1) {
      var1 = var1 * (var0 & 127) >> 7;
      if(var1 < 2) {
         var1 = 2;
      } else if(var1 > 126) {
         var1 = 126;
      }

      return (var0 & 'ﾀ') + var1;
   }

   @ObfuscatedName("z")
   public void method2228() {
      int var1;
      for(var1 = 0; var1 < this.field1736; ++var1) {
         this.field1700[var1] = -this.field1700[var1];
      }

      for(var1 = 0; var1 < this.field1701; ++var1) {
         int var2 = this.field1727[var1];
         this.field1727[var1] = this.field1704[var1];
         this.field1704[var1] = var2;
      }

      this.method2199();
   }

   @ObfuscatedName("b")
   @Export("computeAnimationTables")
   void method2241() {
      int[] var1;
      int var2;
      int var3;
      int var4;
      if(this.field1721 != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.field1736; ++var3) {
            var4 = this.field1721[var3];
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

         for(var3 = 0; var3 < this.field1736; this.field1726[var4][var1[var4]++] = var3++) {
            var4 = this.field1721[var3];
         }

         this.field1721 = null;
      }

      if(this.field1718 != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.field1701; ++var3) {
            var4 = this.field1718[var3];
            ++var1[var4];
            if(var4 > var2) {
               var2 = var4;
            }
         }

         this.field1713 = new int[var2 + 1][];

         for(var3 = 0; var3 <= var2; ++var3) {
            this.field1713[var3] = new int[var1[var3]];
            var1[var3] = 0;
         }

         for(var3 = 0; var3 < this.field1701; this.field1713[var4][var1[var4]++] = var3++) {
            var4 = this.field1718[var3];
         }

         this.field1718 = null;
      }

   }

   class100() {
   }

   @ObfuscatedName("au")
   static final int method2253(int var0) {
      if(var0 < 2) {
         var0 = 2;
      } else if(var0 > 126) {
         var0 = 126;
      }

      return var0;
   }

   @ObfuscatedName("d")
   final int method2259(class100 var1, int var2) {
      int var3 = -1;
      int var4 = var1.field1698[var2];
      int var5 = var1.field1699[var2];
      int var6 = var1.field1700[var2];

      for(int var7 = 0; var7 < this.field1736; ++var7) {
         if(var4 == this.field1698[var7] && var5 == this.field1699[var7] && var6 == this.field1700[var7]) {
            var3 = var7;
            break;
         }
      }

      if(var3 == -1) {
         this.field1698[this.field1736] = var4;
         this.field1699[this.field1736] = var5;
         this.field1700[this.field1736] = var6;
         if(var1.field1721 != null) {
            this.field1721[this.field1736] = var1.field1721[var2];
         }

         var3 = this.field1736++;
      }

      return var3;
   }

   static {
      field1742 = class91.field1596;
      field1724 = class91.field1597;
   }
}
