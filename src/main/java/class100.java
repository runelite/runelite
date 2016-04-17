import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
public class class100 extends class85 {
   @ObfuscatedName("aj")
   static int[] field1687 = new int[10000];
   @ObfuscatedName("w")
   int[] field1688;
   @ObfuscatedName("d")
   int[] field1689;
   @ObfuscatedName("an")
   class96[] field1690;
   @ObfuscatedName("y")
   int field1691 = 0;
   @ObfuscatedName("k")
   int[] field1692;
   @ObfuscatedName("r")
   int[] field1693;
   @ObfuscatedName("aq")
   static int field1694 = 0;
   @ObfuscatedName("q")
   byte[] field1695;
   @ObfuscatedName("m")
   byte[] field1696;
   @ObfuscatedName("e")
   byte[] field1697;
   @ObfuscatedName("a")
   int field1698 = 0;
   @ObfuscatedName("z")
   short[] field1699;
   @ObfuscatedName("ao")
   boolean field1700 = false;
   @ObfuscatedName("x")
   byte[] field1701;
   @ObfuscatedName("b")
   short[] field1702;
   @ObfuscatedName("u")
   byte[] field1703;
   @ObfuscatedName("g")
   short[] field1704;
   @ObfuscatedName("j")
   short[] field1705;
   @ObfuscatedName("h")
   short[] field1706;
   @ObfuscatedName("s")
   short[] field1707;
   @ObfuscatedName("ag")
   static int[] field1708;
   @ObfuscatedName("t")
   byte field1709 = 0;
   @ObfuscatedName("l")
   short[] field1710;
   @ObfuscatedName("o")
   short[] field1711;
   @ObfuscatedName("v")
   short[] field1712;
   @ObfuscatedName("ad")
   byte[] field1713;
   @ObfuscatedName("ar")
   int[] field1714;
   @ObfuscatedName("ah")
   int[] field1715;
   @ObfuscatedName("ay")
   int[][] field1716;
   @ObfuscatedName("af")
   int[][] field1717;
   @ObfuscatedName("al")
   class84[] field1718;
   @ObfuscatedName("i")
   short[] field1719;
   @ObfuscatedName("n")
   int field1720;
   @ObfuscatedName("az")
   public short field1721;
   @ObfuscatedName("ac")
   public short field1722;
   @ObfuscatedName("ai")
   class96[] field1723;
   @ObfuscatedName("ax")
   int field1724;
   @ObfuscatedName("f")
   short[] field1725;
   @ObfuscatedName("ab")
   int field1726;
   @ObfuscatedName("ae")
   int field1727;
   @ObfuscatedName("au")
   int field1728;
   @ObfuscatedName("am")
   static int[] field1729 = new int[10000];
   @ObfuscatedName("c")
   int[] field1730;
   @ObfuscatedName("p")
   int[] field1731;
   @ObfuscatedName("at")
   int field1732;
   @ObfuscatedName("ap")
   static int[] field1733;

   @ObfuscatedName("g")
   public void method2290() {
      int var1;
      for(var1 = 0; var1 < this.field1698; ++var1) {
         this.field1730[var1] = -this.field1730[var1];
      }

      for(var1 = 0; var1 < this.field1691; ++var1) {
         int var2 = this.field1692[var1];
         this.field1692[var1] = this.field1731[var1];
         this.field1731[var1] = var2;
      }

      this.method2308();
   }

   class100(byte[] var1) {
      if(var1[var1.length - 1] == -1 && var1[var1.length - 2] == -1) {
         this.method2292(var1);
      } else {
         this.method2293(var1);
      }

   }

   @ObfuscatedName("w")
   void method2292(byte[] var1) {
      class119 var2 = new class119(var1);
      class119 var3 = new class119(var1);
      class119 var4 = new class119(var1);
      class119 var5 = new class119(var1);
      class119 var6 = new class119(var1);
      class119 var7 = new class119(var1);
      class119 var8 = new class119(var1);
      var2.field1992 = var1.length - 23;
      int var9 = var2.method2615();
      int var10 = var2.method2615();
      int var11 = var2.method2613();
      int var12 = var2.method2613();
      int var13 = var2.method2613();
      int var14 = var2.method2613();
      int var15 = var2.method2613();
      int var16 = var2.method2613();
      int var17 = var2.method2613();
      int var18 = var2.method2615();
      int var19 = var2.method2615();
      int var20 = var2.method2615();
      int var21 = var2.method2615();
      int var22 = var2.method2615();
      int var23 = 0;
      int var24 = 0;
      int var25 = 0;
      int var26;
      if(var11 > 0) {
         this.field1703 = new byte[var11];
         var2.field1992 = 0;

         for(var26 = 0; var26 < var11; ++var26) {
            byte var27 = this.field1703[var26] = var2.method2699();
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
      this.field1698 = var9;
      this.field1691 = var10;
      this.field1720 = var11;
      this.field1688 = new int[var9];
      this.field1689 = new int[var9];
      this.field1730 = new int[var9];
      this.field1692 = new int[var10];
      this.field1693 = new int[var10];
      this.field1731 = new int[var10];
      if(var17 == 1) {
         this.field1714 = new int[var9];
      }

      if(var12 == 1) {
         this.field1695 = new byte[var10];
      }

      if(var13 == 255) {
         this.field1696 = new byte[var10];
      } else {
         this.field1709 = (byte)var13;
      }

      if(var14 == 1) {
         this.field1697 = new byte[var10];
      }

      if(var15 == 1) {
         this.field1715 = new int[var10];
      }

      if(var16 == 1) {
         this.field1719 = new short[var10];
      }

      if(var16 == 1 && var11 > 0) {
         this.field1701 = new byte[var10];
      }

      this.field1699 = new short[var10];
      if(var11 > 0) {
         this.field1704 = new short[var11];
         this.field1705 = new short[var11];
         this.field1706 = new short[var11];
         if(var24 > 0) {
            this.field1707 = new short[var24];
            this.field1725 = new short[var24];
            this.field1702 = new short[var24];
            this.field1710 = new short[var24];
            this.field1713 = new byte[var24];
            this.field1711 = new short[var24];
         }

         if(var25 > 0) {
            this.field1712 = new short[var25];
         }
      }

      var2.field1992 = var11;
      var3.field1992 = var38;
      var4.field1992 = var39;
      var5.field1992 = var40;
      var6.field1992 = var32;
      int var48 = 0;
      int var49 = 0;
      int var50 = 0;

      int var51;
      int var52;
      int var53;
      int var54;
      int var55;
      for(var51 = 0; var51 < var9; ++var51) {
         var52 = var2.method2613();
         var53 = 0;
         if((var52 & 1) != 0) {
            var53 = var3.method2642();
         }

         var54 = 0;
         if((var52 & 2) != 0) {
            var54 = var4.method2642();
         }

         var55 = 0;
         if((var52 & 4) != 0) {
            var55 = var5.method2642();
         }

         this.field1688[var51] = var48 + var53;
         this.field1689[var51] = var49 + var54;
         this.field1730[var51] = var50 + var55;
         var48 = this.field1688[var51];
         var49 = this.field1689[var51];
         var50 = this.field1730[var51];
         if(var17 == 1) {
            this.field1714[var51] = var6.method2613();
         }
      }

      var2.field1992 = var37;
      var3.field1992 = var28;
      var4.field1992 = var30;
      var5.field1992 = var33;
      var6.field1992 = var31;
      var7.field1992 = var35;
      var8.field1992 = var36;

      for(var51 = 0; var51 < var10; ++var51) {
         this.field1699[var51] = (short)var2.method2615();
         if(var12 == 1) {
            this.field1695[var51] = var3.method2699();
         }

         if(var13 == 255) {
            this.field1696[var51] = var4.method2699();
         }

         if(var14 == 1) {
            this.field1697[var51] = var5.method2699();
         }

         if(var15 == 1) {
            this.field1715[var51] = var6.method2613();
         }

         if(var16 == 1) {
            this.field1719[var51] = (short)(var7.method2615() - 1);
         }

         if(this.field1701 != null && this.field1719[var51] != -1) {
            this.field1701[var51] = (byte)(var8.method2613() - 1);
         }
      }

      var2.field1992 = var34;
      var3.field1992 = var29;
      var51 = 0;
      var52 = 0;
      var53 = 0;
      var54 = 0;

      int var56;
      for(var55 = 0; var55 < var10; ++var55) {
         var56 = var3.method2613();
         if(var56 == 1) {
            var51 = var2.method2642() + var54;
            var52 = var2.method2642() + var51;
            var53 = var2.method2642() + var52;
            var54 = var53;
            this.field1692[var55] = var51;
            this.field1693[var55] = var52;
            this.field1731[var55] = var53;
         }

         if(var56 == 2) {
            var52 = var53;
            var53 = var2.method2642() + var54;
            var54 = var53;
            this.field1692[var55] = var51;
            this.field1693[var55] = var52;
            this.field1731[var55] = var53;
         }

         if(var56 == 3) {
            var51 = var53;
            var53 = var2.method2642() + var54;
            var54 = var53;
            this.field1692[var55] = var51;
            this.field1693[var55] = var52;
            this.field1731[var55] = var53;
         }

         if(var56 == 4) {
            int var57 = var51;
            var51 = var52;
            var52 = var57;
            var53 = var2.method2642() + var54;
            var54 = var53;
            this.field1692[var55] = var51;
            this.field1693[var55] = var57;
            this.field1731[var55] = var53;
         }
      }

      var2.field1992 = var41;
      var3.field1992 = var42;
      var4.field1992 = var43;
      var5.field1992 = var44;
      var6.field1992 = var45;
      var7.field1992 = var46;

      for(var55 = 0; var55 < var11; ++var55) {
         var56 = this.field1703[var55] & 255;
         if(var56 == 0) {
            this.field1704[var55] = (short)var2.method2615();
            this.field1705[var55] = (short)var2.method2615();
            this.field1706[var55] = (short)var2.method2615();
         }

         if(var56 == 1) {
            this.field1704[var55] = (short)var3.method2615();
            this.field1705[var55] = (short)var3.method2615();
            this.field1706[var55] = (short)var3.method2615();
            this.field1707[var55] = (short)var4.method2615();
            this.field1725[var55] = (short)var4.method2615();
            this.field1702[var55] = (short)var4.method2615();
            this.field1710[var55] = (short)var5.method2615();
            this.field1713[var55] = var6.method2699();
            this.field1711[var55] = (short)var7.method2615();
         }

         if(var56 == 2) {
            this.field1704[var55] = (short)var3.method2615();
            this.field1705[var55] = (short)var3.method2615();
            this.field1706[var55] = (short)var3.method2615();
            this.field1707[var55] = (short)var4.method2615();
            this.field1725[var55] = (short)var4.method2615();
            this.field1702[var55] = (short)var4.method2615();
            this.field1710[var55] = (short)var5.method2615();
            this.field1713[var55] = var6.method2699();
            this.field1711[var55] = (short)var7.method2615();
            this.field1712[var55] = (short)var7.method2615();
         }

         if(var56 == 3) {
            this.field1704[var55] = (short)var3.method2615();
            this.field1705[var55] = (short)var3.method2615();
            this.field1706[var55] = (short)var3.method2615();
            this.field1707[var55] = (short)var4.method2615();
            this.field1725[var55] = (short)var4.method2615();
            this.field1702[var55] = (short)var4.method2615();
            this.field1710[var55] = (short)var5.method2615();
            this.field1713[var55] = var6.method2699();
            this.field1711[var55] = (short)var7.method2615();
         }
      }

      var2.field1992 = var26;
      var55 = var2.method2613();
      if(var55 != 0) {
         new class90();
         var2.method2615();
         var2.method2615();
         var2.method2615();
         var2.method2618();
      }

   }

   @ObfuscatedName("c")
   void method2293(byte[] var1) {
      boolean var2 = false;
      boolean var3 = false;
      class119 var4 = new class119(var1);
      class119 var5 = new class119(var1);
      class119 var6 = new class119(var1);
      class119 var7 = new class119(var1);
      class119 var8 = new class119(var1);
      var4.field1992 = var1.length - 18;
      int var9 = var4.method2615();
      int var10 = var4.method2615();
      int var11 = var4.method2613();
      int var12 = var4.method2613();
      int var13 = var4.method2613();
      int var14 = var4.method2613();
      int var15 = var4.method2613();
      int var16 = var4.method2613();
      int var17 = var4.method2615();
      int var18 = var4.method2615();
      int var19 = var4.method2615();
      int var20 = var4.method2615();
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
      this.field1698 = var9;
      this.field1691 = var10;
      this.field1720 = var11;
      this.field1688 = new int[var9];
      this.field1689 = new int[var9];
      this.field1730 = new int[var9];
      this.field1692 = new int[var10];
      this.field1693 = new int[var10];
      this.field1731 = new int[var10];
      if(var11 > 0) {
         this.field1703 = new byte[var11];
         this.field1704 = new short[var11];
         this.field1705 = new short[var11];
         this.field1706 = new short[var11];
      }

      if(var16 == 1) {
         this.field1714 = new int[var9];
      }

      if(var12 == 1) {
         this.field1695 = new byte[var10];
         this.field1701 = new byte[var10];
         this.field1719 = new short[var10];
      }

      if(var13 == 255) {
         this.field1696 = new byte[var10];
      } else {
         this.field1709 = (byte)var13;
      }

      if(var14 == 1) {
         this.field1697 = new byte[var10];
      }

      if(var15 == 1) {
         this.field1715 = new int[var10];
      }

      this.field1699 = new short[var10];
      var4.field1992 = var21;
      var5.field1992 = var32;
      var6.field1992 = var33;
      var7.field1992 = var45;
      var8.field1992 = var27;
      int var35 = 0;
      int var36 = 0;
      int var37 = 0;

      int var38;
      int var39;
      int var40;
      int var41;
      int var42;
      for(var38 = 0; var38 < var9; ++var38) {
         var39 = var4.method2613();
         var40 = 0;
         if((var39 & 1) != 0) {
            var40 = var5.method2642();
         }

         var41 = 0;
         if((var39 & 2) != 0) {
            var41 = var6.method2642();
         }

         var42 = 0;
         if((var39 & 4) != 0) {
            var42 = var7.method2642();
         }

         this.field1688[var38] = var35 + var40;
         this.field1689[var38] = var36 + var41;
         this.field1730[var38] = var37 + var42;
         var35 = this.field1688[var38];
         var36 = this.field1689[var38];
         var37 = this.field1730[var38];
         if(var16 == 1) {
            this.field1714[var38] = var8.method2613();
         }
      }

      var4.field1992 = var30;
      var5.field1992 = var26;
      var6.field1992 = var24;
      var7.field1992 = var28;
      var8.field1992 = var25;

      for(var38 = 0; var38 < var10; ++var38) {
         this.field1699[var38] = (short)var4.method2615();
         if(var12 == 1) {
            var39 = var5.method2613();
            if((var39 & 1) == 1) {
               this.field1695[var38] = 1;
               var2 = true;
            } else {
               this.field1695[var38] = 0;
            }

            if((var39 & 2) == 2) {
               this.field1701[var38] = (byte)(var39 >> 2);
               this.field1719[var38] = this.field1699[var38];
               this.field1699[var38] = 127;
               if(this.field1719[var38] != -1) {
                  var3 = true;
               }
            } else {
               this.field1701[var38] = -1;
               this.field1719[var38] = -1;
            }
         }

         if(var13 == 255) {
            this.field1696[var38] = var6.method2699();
         }

         if(var14 == 1) {
            this.field1697[var38] = var7.method2699();
         }

         if(var15 == 1) {
            this.field1715[var38] = var8.method2613();
         }
      }

      var4.field1992 = var29;
      var5.field1992 = var23;
      var38 = 0;
      var39 = 0;
      var40 = 0;
      var41 = 0;

      int var43;
      int var44;
      for(var42 = 0; var42 < var10; ++var42) {
         var43 = var5.method2613();
         if(var43 == 1) {
            var38 = var4.method2642() + var41;
            var39 = var4.method2642() + var38;
            var40 = var4.method2642() + var39;
            var41 = var40;
            this.field1692[var42] = var38;
            this.field1693[var42] = var39;
            this.field1731[var42] = var40;
         }

         if(var43 == 2) {
            var39 = var40;
            var40 = var4.method2642() + var41;
            var41 = var40;
            this.field1692[var42] = var38;
            this.field1693[var42] = var39;
            this.field1731[var42] = var40;
         }

         if(var43 == 3) {
            var38 = var40;
            var40 = var4.method2642() + var41;
            var41 = var40;
            this.field1692[var42] = var38;
            this.field1693[var42] = var39;
            this.field1731[var42] = var40;
         }

         if(var43 == 4) {
            var44 = var38;
            var38 = var39;
            var39 = var44;
            var40 = var4.method2642() + var41;
            var41 = var40;
            this.field1692[var42] = var38;
            this.field1693[var42] = var44;
            this.field1731[var42] = var40;
         }
      }

      var4.field1992 = var31;

      for(var42 = 0; var42 < var11; ++var42) {
         this.field1703[var42] = 0;
         this.field1704[var42] = (short)var4.method2615();
         this.field1705[var42] = (short)var4.method2615();
         this.field1706[var42] = (short)var4.method2615();
      }

      if(this.field1701 != null) {
         boolean var46 = false;

         for(var43 = 0; var43 < var10; ++var43) {
            var44 = this.field1701[var43] & 255;
            if(var44 != 255) {
               if((this.field1704[var44] & '\uffff') == this.field1692[var43] && (this.field1705[var44] & '\uffff') == this.field1693[var43] && (this.field1706[var44] & '\uffff') == this.field1731[var43]) {
                  this.field1701[var43] = -1;
               } else {
                  var46 = true;
               }
            }
         }

         if(!var46) {
            this.field1701 = null;
         }
      }

      if(!var3) {
         this.field1719 = null;
      }

      if(!var2) {
         this.field1695 = null;
      }

   }

   class100() {
   }

   @ObfuscatedSignature(
      signature = "(Lclass100;ZZZZ)V",
      garbageValue = "1"
   )
   public class100(class100 var1, boolean var2, boolean var3, boolean var4, boolean var5) {
      this.field1698 = var1.field1698;
      this.field1691 = var1.field1691;
      this.field1720 = var1.field1720;
      this.field1688 = var1.field1688;
      this.field1689 = var1.field1689;
      this.field1730 = var1.field1730;
      this.field1699 = var1.field1699;
      this.field1719 = var1.field1719;
      this.field1697 = var1.field1697;
      this.field1692 = var1.field1692;
      this.field1693 = var1.field1693;
      this.field1731 = var1.field1731;
      this.field1695 = var1.field1695;
      this.field1696 = var1.field1696;
      this.field1701 = var1.field1701;
      this.field1709 = var1.field1709;
      this.field1703 = var1.field1703;
      this.field1704 = var1.field1704;
      this.field1705 = var1.field1705;
      this.field1706 = var1.field1706;
      this.field1707 = var1.field1707;
      this.field1725 = var1.field1725;
      this.field1702 = var1.field1702;
      this.field1710 = var1.field1710;
      this.field1713 = var1.field1713;
      this.field1711 = var1.field1711;
      this.field1712 = var1.field1712;
      this.field1714 = var1.field1714;
      this.field1715 = var1.field1715;
      this.field1716 = var1.field1716;
      this.field1717 = var1.field1717;
      this.field1723 = var1.field1723;
      this.field1718 = var1.field1718;
      this.field1690 = var1.field1690;
      this.field1721 = var1.field1721;
      this.field1722 = var1.field1722;
   }

   @ObfuscatedName("k")
   public class100 method2295() {
      class100 var1 = new class100();
      if(this.field1695 != null) {
         var1.field1695 = new byte[this.field1691];

         for(int var2 = 0; var2 < this.field1691; ++var2) {
            var1.field1695[var2] = this.field1695[var2];
         }
      }

      var1.field1698 = this.field1698;
      var1.field1691 = this.field1691;
      var1.field1720 = this.field1720;
      var1.field1688 = this.field1688;
      var1.field1689 = this.field1689;
      var1.field1730 = this.field1730;
      var1.field1692 = this.field1692;
      var1.field1693 = this.field1693;
      var1.field1731 = this.field1731;
      var1.field1696 = this.field1696;
      var1.field1697 = this.field1697;
      var1.field1701 = this.field1701;
      var1.field1699 = this.field1699;
      var1.field1719 = this.field1719;
      var1.field1709 = this.field1709;
      var1.field1703 = this.field1703;
      var1.field1704 = this.field1704;
      var1.field1705 = this.field1705;
      var1.field1706 = this.field1706;
      var1.field1707 = this.field1707;
      var1.field1725 = this.field1725;
      var1.field1702 = this.field1702;
      var1.field1710 = this.field1710;
      var1.field1713 = this.field1713;
      var1.field1711 = this.field1711;
      var1.field1712 = this.field1712;
      var1.field1714 = this.field1714;
      var1.field1715 = this.field1715;
      var1.field1716 = this.field1716;
      var1.field1717 = this.field1717;
      var1.field1723 = this.field1723;
      var1.field1718 = this.field1718;
      var1.field1721 = this.field1721;
      var1.field1722 = this.field1722;
      return var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([[IIIIZI)Lclass100;",
      garbageValue = "1"
   )
   public class100 method2296(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2362();
      int var7 = var2 + this.field1732;
      int var8 = var2 + this.field1726;
      int var9 = var4 + this.field1728;
      int var10 = var4 + this.field1727;
      if(var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
         var7 >>= 7;
         var8 = var8 + 127 >> 7;
         var9 >>= 7;
         var10 = var10 + 127 >> 7;
         if(var1[var7][var9] == var3 && var1[var8][var9] == var3 && var1[var7][var10] == var3 && var1[var8][var10] == var3) {
            return this;
         } else {
            class100 var11 = new class100();
            var11.field1698 = this.field1698;
            var11.field1691 = this.field1691;
            var11.field1720 = this.field1720;
            var11.field1688 = this.field1688;
            var11.field1730 = this.field1730;
            var11.field1692 = this.field1692;
            var11.field1693 = this.field1693;
            var11.field1731 = this.field1731;
            var11.field1695 = this.field1695;
            var11.field1696 = this.field1696;
            var11.field1697 = this.field1697;
            var11.field1701 = this.field1701;
            var11.field1699 = this.field1699;
            var11.field1719 = this.field1719;
            var11.field1709 = this.field1709;
            var11.field1703 = this.field1703;
            var11.field1704 = this.field1704;
            var11.field1705 = this.field1705;
            var11.field1706 = this.field1706;
            var11.field1707 = this.field1707;
            var11.field1725 = this.field1725;
            var11.field1702 = this.field1702;
            var11.field1710 = this.field1710;
            var11.field1713 = this.field1713;
            var11.field1711 = this.field1711;
            var11.field1712 = this.field1712;
            var11.field1714 = this.field1714;
            var11.field1715 = this.field1715;
            var11.field1716 = this.field1716;
            var11.field1717 = this.field1717;
            var11.field1721 = this.field1721;
            var11.field1722 = this.field1722;
            var11.field1689 = new int[var11.field1698];
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
               for(var12 = 0; var12 < var11.field1698; ++var12) {
                  var13 = this.field1688[var12] + var2;
                  var14 = this.field1730[var12] + var4;
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var1[var17 + 1][var18 + 1] * var15 >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.field1689[var12] = this.field1689[var12] + var21 - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1698; ++var12) {
                  var13 = (-this.field1689[var12] << 16) / super.field1465;
                  if(var13 < var6) {
                     var14 = this.field1688[var12] + var2;
                     var15 = this.field1730[var12] + var4;
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var1[var18 + 1][var19 + 1] * var16 >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.field1689[var12] = this.field1689[var12] + (var22 - var3) * (var6 - var13) / var6;
                  }
               }
            }

            var11.method2308();
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("p")
   void method2297() {
      int[] var1;
      int var2;
      int var3;
      int var4;
      if(this.field1714 != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.field1698; ++var3) {
            var4 = this.field1714[var3];
            ++var1[var4];
            if(var4 > var2) {
               var2 = var4;
            }
         }

         this.field1716 = new int[var2 + 1][];

         for(var3 = 0; var3 <= var2; ++var3) {
            this.field1716[var3] = new int[var1[var3]];
            var1[var3] = 0;
         }

         for(var3 = 0; var3 < this.field1698; this.field1716[var4][var1[var4]++] = var3++) {
            var4 = this.field1714[var3];
         }

         this.field1714 = null;
      }

      if(this.field1715 != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.field1691; ++var3) {
            var4 = this.field1715[var3];
            ++var1[var4];
            if(var4 > var2) {
               var2 = var4;
            }
         }

         this.field1717 = new int[var2 + 1][];

         for(var3 = 0; var3 <= var2; ++var3) {
            this.field1717[var3] = new int[var1[var3]];
            var1[var3] = 0;
         }

         for(var3 = 0; var3 < this.field1691; this.field1717[var4][var1[var4]++] = var3++) {
            var4 = this.field1715[var3];
         }

         this.field1715 = null;
      }

   }

   @ObfuscatedName("q")
   public void method2298() {
      for(int var1 = 0; var1 < this.field1698; ++var1) {
         int var2 = this.field1688[var1];
         this.field1688[var1] = this.field1730[var1];
         this.field1730[var1] = -var2;
      }

      this.method2308();
   }

   @ObfuscatedName("m")
   public void method2299() {
      for(int var1 = 0; var1 < this.field1698; ++var1) {
         this.field1688[var1] = -this.field1688[var1];
         this.field1730[var1] = -this.field1730[var1];
      }

      this.method2308();
   }

   @ObfuscatedName("e")
   public void method2300() {
      for(int var1 = 0; var1 < this.field1698; ++var1) {
         int var2 = this.field1730[var1];
         this.field1730[var1] = this.field1688[var1];
         this.field1688[var1] = -var2;
      }

      this.method2308();
   }

   @ObfuscatedName("n")
   public void method2303(short var1, short var2) {
      for(int var3 = 0; var3 < this.field1691; ++var3) {
         if(this.field1699[var3] == var1) {
            this.field1699[var3] = var2;
         }
      }

   }

   @ObfuscatedName("u")
   public void method2304(short var1, short var2) {
      if(this.field1719 != null) {
         for(int var3 = 0; var3 < this.field1691; ++var3) {
            if(this.field1719[var3] == var1) {
               this.field1719[var3] = var2;
            }
         }

      }
   }

   @ObfuscatedName("j")
   public void method2306(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1698; ++var4) {
         this.field1688[var4] = this.field1688[var4] * var1 / 128;
         this.field1689[var4] = this.field1689[var4] * var2 / 128;
         this.field1730[var4] = this.field1730[var4] * var3 / 128;
      }

      this.method2308();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass167;II)Lclass100;",
      garbageValue = "0"
   )
   public static class100 method2307(class167 var0, int var1, int var2) {
      byte[] var3 = var0.method3403(var1, var2);
      return var3 == null?null:new class100(var3);
   }

   @ObfuscatedName("s")
   void method2308() {
      this.field1723 = null;
      this.field1690 = null;
      this.field1718 = null;
      this.field1700 = false;
   }

   @ObfuscatedName("b")
   static void method2310(class100 var0, class100 var1, int var2, int var3, int var4, boolean var5) {
      var0.method2362();
      var0.method2311();
      var1.method2362();
      var1.method2311();
      ++field1694;
      int var6 = 0;
      int[] var7 = var1.field1688;
      int var8 = var1.field1698;

      int var9;
      for(var9 = 0; var9 < var0.field1698; ++var9) {
         class96 var10 = var0.field1723[var9];
         if(var10.field1626 != 0) {
            int var11 = var0.field1689[var9] - var3;
            if(var11 <= var1.field1724) {
               int var12 = var0.field1688[var9] - var2;
               if(var12 >= var1.field1732 && var12 <= var1.field1726) {
                  int var13 = var0.field1730[var9] - var4;
                  if(var13 >= var1.field1728 && var13 <= var1.field1727) {
                     for(int var14 = 0; var14 < var8; ++var14) {
                        class96 var15 = var1.field1723[var14];
                        if(var12 == var7[var14] && var13 == var1.field1730[var14] && var11 == var1.field1689[var14] && var15.field1626 != 0) {
                           if(var0.field1690 == null) {
                              var0.field1690 = new class96[var0.field1698];
                           }

                           if(var1.field1690 == null) {
                              var1.field1690 = new class96[var8];
                           }

                           class96 var16 = var0.field1690[var9];
                           if(var16 == null) {
                              var16 = var0.field1690[var9] = new class96(var10);
                           }

                           class96 var17 = var1.field1690[var14];
                           if(var17 == null) {
                              var17 = var1.field1690[var14] = new class96(var15);
                           }

                           var16.field1628 += var15.field1628;
                           var16.field1629 += var15.field1629;
                           var16.field1630 += var15.field1630;
                           var16.field1626 += var15.field1626;
                           var17.field1628 += var10.field1628;
                           var17.field1629 += var10.field1629;
                           var17.field1630 += var10.field1630;
                           var17.field1626 += var10.field1626;
                           ++var6;
                           field1729[var9] = field1694;
                           field1687[var14] = field1694;
                        }
                     }
                  }
               }
            }
         }
      }

      if(var6 >= 3 && var5) {
         for(var9 = 0; var9 < var0.field1691; ++var9) {
            if(field1729[var0.field1692[var9]] == field1694 && field1729[var0.field1693[var9]] == field1694 && field1729[var0.field1731[var9]] == field1694) {
               if(var0.field1695 == null) {
                  var0.field1695 = new byte[var0.field1691];
               }

               var0.field1695[var9] = 2;
            }
         }

         for(var9 = 0; var9 < var1.field1691; ++var9) {
            if(field1687[var1.field1692[var9]] == field1694 && field1687[var1.field1693[var9]] == field1694 && field1687[var1.field1731[var9]] == field1694) {
               if(var1.field1695 == null) {
                  var1.field1695 = new byte[var1.field1691];
               }

               var1.field1695[var9] = 2;
            }
         }

      }
   }

   @ObfuscatedName("h")
   public void method2311() {
      if(this.field1723 == null) {
         this.field1723 = new class96[this.field1698];

         int var1;
         for(var1 = 0; var1 < this.field1698; ++var1) {
            this.field1723[var1] = new class96();
         }

         for(var1 = 0; var1 < this.field1691; ++var1) {
            int var2 = this.field1692[var1];
            int var3 = this.field1693[var1];
            int var4 = this.field1731[var1];
            int var5 = this.field1688[var3] - this.field1688[var2];
            int var6 = this.field1689[var3] - this.field1689[var2];
            int var7 = this.field1730[var3] - this.field1730[var2];
            int var8 = this.field1688[var4] - this.field1688[var2];
            int var9 = this.field1689[var4] - this.field1689[var2];
            int var10 = this.field1730[var4] - this.field1730[var2];
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
            if(this.field1695 == null) {
               var15 = 0;
            } else {
               var15 = this.field1695[var1];
            }

            if(var15 == 0) {
               class96 var16 = this.field1723[var2];
               var16.field1628 += var11;
               var16.field1629 += var12;
               var16.field1630 += var13;
               ++var16.field1626;
               var16 = this.field1723[var3];
               var16.field1628 += var11;
               var16.field1629 += var12;
               var16.field1630 += var13;
               ++var16.field1626;
               var16 = this.field1723[var4];
               var16.field1628 += var11;
               var16.field1629 += var12;
               var16.field1630 += var13;
               ++var16.field1626;
            } else if(var15 == 1) {
               if(this.field1718 == null) {
                  this.field1718 = new class84[this.field1691];
               }

               class84 var17 = this.field1718[var1] = new class84();
               var17.field1459 = var11;
               var17.field1456 = var12;
               var17.field1457 = var13;
            }
         }

      }
   }

   @ObfuscatedName("v")
   static final int method2313(int var0) {
      if(var0 < 2) {
         var0 = 2;
      } else if(var0 > 126) {
         var0 = 126;
      }

      return var0;
   }

   static {
      field1708 = class91.field1593;
      field1733 = class91.field1594;
   }

   @ObfuscatedName("z")
   public void method2329(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1698; ++var4) {
         this.field1688[var4] += var1;
         this.field1689[var4] += var2;
         this.field1730[var4] += var3;
      }

      this.method2308();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "256"
   )
   public void method2340(int var1) {
      int var2 = field1708[var1];
      int var3 = field1733[var1];

      for(int var4 = 0; var4 < this.field1698; ++var4) {
         int var5 = this.field1730[var4] * var2 + this.field1688[var4] * var3 >> 16;
         this.field1730[var4] = this.field1730[var4] * var3 - this.field1688[var4] * var2 >> 16;
         this.field1688[var4] = var5;
      }

      this.method2308();
   }

   @ObfuscatedName("o")
   static final int method2347(int var0, int var1) {
      var1 = var1 * (var0 & 127) >> 7;
      if(var1 < 2) {
         var1 = 2;
      } else if(var1 > 126) {
         var1 = 126;
      }

      return (var0 & 'ﾀ') + var1;
   }

   @ObfuscatedName("f")
   void method2362() {
      if(!this.field1700) {
         super.field1465 = 0;
         this.field1724 = 0;
         this.field1732 = 999999;
         this.field1726 = -999999;
         this.field1727 = -99999;
         this.field1728 = 99999;

         for(int var1 = 0; var1 < this.field1698; ++var1) {
            int var2 = this.field1688[var1];
            int var3 = this.field1689[var1];
            int var4 = this.field1730[var1];
            if(var2 < this.field1732) {
               this.field1732 = var2;
            }

            if(var2 > this.field1726) {
               this.field1726 = var2;
            }

            if(var4 < this.field1728) {
               this.field1728 = var4;
            }

            if(var4 > this.field1727) {
               this.field1727 = var4;
            }

            if(-var3 > super.field1465) {
               super.field1465 = -var3;
            }

            if(var3 > this.field1724) {
               this.field1724 = var3;
            }
         }

         this.field1700 = true;
      }
   }

   public class100(class100[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      boolean var8 = false;
      this.field1698 = 0;
      this.field1691 = 0;
      this.field1720 = 0;
      this.field1709 = -1;

      int var9;
      class100 var10;
      for(var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if(var10 != null) {
            this.field1698 += var10.field1698;
            this.field1691 += var10.field1691;
            this.field1720 += var10.field1720;
            if(var10.field1696 != null) {
               var4 = true;
            } else {
               if(this.field1709 == -1) {
                  this.field1709 = var10.field1709;
               }

               if(this.field1709 != var10.field1709) {
                  var4 = true;
               }
            }

            var3 |= var10.field1695 != null;
            var5 |= var10.field1697 != null;
            var6 |= var10.field1715 != null;
            var7 |= var10.field1719 != null;
            var8 |= var10.field1701 != null;
         }
      }

      this.field1688 = new int[this.field1698];
      this.field1689 = new int[this.field1698];
      this.field1730 = new int[this.field1698];
      this.field1714 = new int[this.field1698];
      this.field1692 = new int[this.field1691];
      this.field1693 = new int[this.field1691];
      this.field1731 = new int[this.field1691];
      if(var3) {
         this.field1695 = new byte[this.field1691];
      }

      if(var4) {
         this.field1696 = new byte[this.field1691];
      }

      if(var5) {
         this.field1697 = new byte[this.field1691];
      }

      if(var6) {
         this.field1715 = new int[this.field1691];
      }

      if(var7) {
         this.field1719 = new short[this.field1691];
      }

      if(var8) {
         this.field1701 = new byte[this.field1691];
      }

      this.field1699 = new short[this.field1691];
      if(this.field1720 > 0) {
         this.field1703 = new byte[this.field1720];
         this.field1704 = new short[this.field1720];
         this.field1705 = new short[this.field1720];
         this.field1706 = new short[this.field1720];
         this.field1707 = new short[this.field1720];
         this.field1725 = new short[this.field1720];
         this.field1702 = new short[this.field1720];
         this.field1710 = new short[this.field1720];
         this.field1713 = new byte[this.field1720];
         this.field1711 = new short[this.field1720];
         this.field1712 = new short[this.field1720];
      }

      this.field1698 = 0;
      this.field1691 = 0;
      this.field1720 = 0;

      for(var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if(var10 != null) {
            int var11;
            for(var11 = 0; var11 < var10.field1691; ++var11) {
               if(var3 && var10.field1695 != null) {
                  this.field1695[this.field1691] = var10.field1695[var11];
               }

               if(var4) {
                  if(var10.field1696 != null) {
                     this.field1696[this.field1691] = var10.field1696[var11];
                  } else {
                     this.field1696[this.field1691] = var10.field1709;
                  }
               }

               if(var5 && var10.field1697 != null) {
                  this.field1697[this.field1691] = var10.field1697[var11];
               }

               if(var6 && var10.field1715 != null) {
                  this.field1715[this.field1691] = var10.field1715[var11];
               }

               if(var7) {
                  if(var10.field1719 != null) {
                     this.field1719[this.field1691] = var10.field1719[var11];
                  } else {
                     this.field1719[this.field1691] = -1;
                  }
               }

               if(var8) {
                  if(var10.field1701 != null && var10.field1701[var11] != -1) {
                     this.field1701[this.field1691] = (byte)(var10.field1701[var11] + this.field1720);
                  } else {
                     this.field1701[this.field1691] = -1;
                  }
               }

               this.field1699[this.field1691] = var10.field1699[var11];
               this.field1692[this.field1691] = this.method2369(var10, var10.field1692[var11]);
               this.field1693[this.field1691] = this.method2369(var10, var10.field1693[var11]);
               this.field1731[this.field1691] = this.method2369(var10, var10.field1731[var11]);
               ++this.field1691;
            }

            for(var11 = 0; var11 < var10.field1720; ++var11) {
               byte var12 = this.field1703[this.field1720] = var10.field1703[var11];
               if(var12 == 0) {
                  this.field1704[this.field1720] = (short)this.method2369(var10, var10.field1704[var11]);
                  this.field1705[this.field1720] = (short)this.method2369(var10, var10.field1705[var11]);
                  this.field1706[this.field1720] = (short)this.method2369(var10, var10.field1706[var11]);
               }

               if(var12 >= 1 && var12 <= 3) {
                  this.field1704[this.field1720] = var10.field1704[var11];
                  this.field1705[this.field1720] = var10.field1705[var11];
                  this.field1706[this.field1720] = var10.field1706[var11];
                  this.field1707[this.field1720] = var10.field1707[var11];
                  this.field1725[this.field1720] = var10.field1725[var11];
                  this.field1702[this.field1720] = var10.field1702[var11];
                  this.field1710[this.field1720] = var10.field1710[var11];
                  this.field1713[this.field1720] = var10.field1713[var11];
                  this.field1711[this.field1720] = var10.field1711[var11];
               }

               if(var12 == 2) {
                  this.field1712[this.field1720] = var10.field1712[var11];
               }

               ++this.field1720;
            }
         }
      }

   }

   @ObfuscatedName("l")
   public final class105 method2368(int var1, int var2, int var3, int var4, int var5) {
      this.method2311();
      int var6 = (int)Math.sqrt((double)(var3 * var3 + var4 * var4 + var5 * var5));
      int var7 = var2 * var6 >> 8;
      class105 var8 = new class105();
      var8.field1805 = new int[this.field1691];
      var8.field1806 = new int[this.field1691];
      var8.field1807 = new int[this.field1691];
      if(this.field1720 > 0 && this.field1701 != null) {
         int[] var9 = new int[this.field1720];

         int var10;
         for(var10 = 0; var10 < this.field1691; ++var10) {
            if(this.field1701[var10] != -1) {
               ++var9[this.field1701[var10] & 255];
            }
         }

         var8.field1813 = 0;

         for(var10 = 0; var10 < this.field1720; ++var10) {
            if(var9[var10] > 0 && this.field1703[var10] == 0) {
               ++var8.field1813;
            }
         }

         var8.field1802 = new int[var8.field1813];
         var8.field1834 = new int[var8.field1813];
         var8.field1816 = new int[var8.field1813];
         var10 = 0;

         int var11;
         for(var11 = 0; var11 < this.field1720; ++var11) {
            if(var9[var11] > 0 && this.field1703[var11] == 0) {
               var8.field1802[var10] = this.field1704[var11] & '\uffff';
               var8.field1834[var10] = this.field1705[var11] & '\uffff';
               var8.field1816[var10] = this.field1706[var11] & '\uffff';
               var9[var11] = var10++;
            } else {
               var9[var11] = -1;
            }
         }

         var8.field1810 = new byte[this.field1691];

         for(var11 = 0; var11 < this.field1691; ++var11) {
            if(this.field1701[var11] != -1) {
               var8.field1810[var11] = (byte)var9[this.field1701[var11] & 255];
            } else {
               var8.field1810[var11] = -1;
            }
         }
      }

      for(int var16 = 0; var16 < this.field1691; ++var16) {
         byte var17;
         if(this.field1695 == null) {
            var17 = 0;
         } else {
            var17 = this.field1695[var16];
         }

         byte var18;
         if(this.field1697 == null) {
            var18 = 0;
         } else {
            var18 = this.field1697[var16];
         }

         short var12;
         if(this.field1719 == null) {
            var12 = -1;
         } else {
            var12 = this.field1719[var16];
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
                  var19 = this.field1718[var16];
                  var14 = var1 + (var3 * var19.field1459 + var4 * var19.field1456 + var5 * var19.field1457) / (var7 + var7 / 2);
                  var8.field1805[var16] = method2347(this.field1699[var16] & '\uffff', var14);
                  var8.field1807[var16] = -1;
               } else if(var17 == 3) {
                  var8.field1805[var16] = 128;
                  var8.field1807[var16] = -1;
               } else {
                  var8.field1807[var16] = -2;
               }
            } else {
               int var15 = this.field1699[var16] & '\uffff';
               if(this.field1690 != null && this.field1690[this.field1692[var16]] != null) {
                  var13 = this.field1690[this.field1692[var16]];
               } else {
                  var13 = this.field1723[this.field1692[var16]];
               }

               var14 = var1 + (var3 * var13.field1628 + var4 * var13.field1629 + var5 * var13.field1630) / (var7 * var13.field1626);
               var8.field1805[var16] = method2347(var15, var14);
               if(this.field1690 != null && this.field1690[this.field1693[var16]] != null) {
                  var13 = this.field1690[this.field1693[var16]];
               } else {
                  var13 = this.field1723[this.field1693[var16]];
               }

               var14 = var1 + (var3 * var13.field1628 + var4 * var13.field1629 + var5 * var13.field1630) / (var7 * var13.field1626);
               var8.field1806[var16] = method2347(var15, var14);
               if(this.field1690 != null && this.field1690[this.field1731[var16]] != null) {
                  var13 = this.field1690[this.field1731[var16]];
               } else {
                  var13 = this.field1723[this.field1731[var16]];
               }

               var14 = var1 + (var3 * var13.field1628 + var4 * var13.field1629 + var5 * var13.field1630) / (var7 * var13.field1626);
               var8.field1807[var16] = method2347(var15, var14);
            }
         } else if(var17 != 0) {
            if(var17 == 1) {
               var19 = this.field1718[var16];
               var14 = var1 + (var3 * var19.field1459 + var4 * var19.field1456 + var5 * var19.field1457) / (var7 + var7 / 2);
               var8.field1805[var16] = method2313(var14);
               var8.field1807[var16] = -1;
            } else {
               var8.field1807[var16] = -2;
            }
         } else {
            if(this.field1690 != null && this.field1690[this.field1692[var16]] != null) {
               var13 = this.field1690[this.field1692[var16]];
            } else {
               var13 = this.field1723[this.field1692[var16]];
            }

            var14 = var1 + (var3 * var13.field1628 + var4 * var13.field1629 + var5 * var13.field1630) / (var7 * var13.field1626);
            var8.field1805[var16] = method2313(var14);
            if(this.field1690 != null && this.field1690[this.field1693[var16]] != null) {
               var13 = this.field1690[this.field1693[var16]];
            } else {
               var13 = this.field1723[this.field1693[var16]];
            }

            var14 = var1 + (var3 * var13.field1628 + var4 * var13.field1629 + var5 * var13.field1630) / (var7 * var13.field1626);
            var8.field1806[var16] = method2313(var14);
            if(this.field1690 != null && this.field1690[this.field1731[var16]] != null) {
               var13 = this.field1690[this.field1731[var16]];
            } else {
               var13 = this.field1723[this.field1731[var16]];
            }

            var14 = var1 + (var3 * var13.field1628 + var4 * var13.field1629 + var5 * var13.field1630) / (var7 * var13.field1626);
            var8.field1807[var16] = method2313(var14);
         }
      }

      this.method2297();
      var8.field1797 = this.field1698;
      var8.field1798 = this.field1688;
      var8.field1799 = this.field1689;
      var8.field1839 = this.field1730;
      var8.field1801 = this.field1691;
      var8.field1793 = this.field1692;
      var8.field1835 = this.field1693;
      var8.field1800 = this.field1731;
      var8.field1808 = this.field1696;
      var8.field1833 = this.field1697;
      var8.field1795 = this.field1709;
      var8.field1817 = this.field1716;
      var8.field1822 = this.field1717;
      var8.field1811 = this.field1719;
      return var8;
   }

   @ObfuscatedName("y")
   final int method2369(class100 var1, int var2) {
      int var3 = -1;
      int var4 = var1.field1688[var2];
      int var5 = var1.field1689[var2];
      int var6 = var1.field1730[var2];

      for(int var7 = 0; var7 < this.field1698; ++var7) {
         if(var4 == this.field1688[var7] && var5 == this.field1689[var7] && var6 == this.field1730[var7]) {
            var3 = var7;
            break;
         }
      }

      if(var3 == -1) {
         this.field1688[this.field1698] = var4;
         this.field1689[this.field1698] = var5;
         this.field1730[this.field1698] = var6;
         if(var1.field1714 != null) {
            this.field1714[this.field1698] = var1.field1714[var2];
         }

         var3 = this.field1698++;
      }

      return var3;
   }
}
