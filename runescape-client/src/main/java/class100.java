import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("ModelData")
public class class100 extends class85 {
   @ObfuscatedName("am")
   public short field1688;
   @ObfuscatedName("z")
   short[] field1689;
   @ObfuscatedName("l")
   int field1690 = 0;
   @ObfuscatedName("b")
   int[] field1691;
   @ObfuscatedName("c")
   short[] field1692;
   @ObfuscatedName("d")
   int[] field1693;
   @ObfuscatedName("n")
   int[] field1694;
   @ObfuscatedName("m")
   int[] field1695;
   @ObfuscatedName("g")
   byte[] field1696;
   @ObfuscatedName("u")
   int[] field1697;
   @ObfuscatedName("r")
   byte[] field1698;
   @ObfuscatedName("k")
   byte[] field1699;
   @ObfuscatedName("o")
   short[] field1700;
   @ObfuscatedName("q")
   short[] field1701;
   @ObfuscatedName("aj")
   int[][] field1702;
   @ObfuscatedName("j")
   short[] field1703;
   @ObfuscatedName("ag")
   byte[] field1704;
   @ObfuscatedName("t")
   short[] field1705;
   @ObfuscatedName("w")
   short[] field1706;
   @ObfuscatedName("v")
   short[] field1707;
   @ObfuscatedName("y")
   short[] field1708;
   @ObfuscatedName("av")
   public short field1709;
   @ObfuscatedName("i")
   short[] field1710;
   @ObfuscatedName("a")
   short[] field1711;
   @ObfuscatedName("f")
   int field1712 = 0;
   @ObfuscatedName("x")
   int[] field1713;
   @ObfuscatedName("h")
   int field1714;
   @ObfuscatedName("ax")
   int[] field1715;
   @ObfuscatedName("ao")
   int[] field1716;
   @ObfuscatedName("ac")
   int[][] field1717;
   @ObfuscatedName("e")
   byte[] field1718;
   @ObfuscatedName("an")
   class84[] field1719;
   @ObfuscatedName("al")
   class96[] field1720;
   @ObfuscatedName("s")
   byte[] field1721;
   @ObfuscatedName("ak")
   static int[] field1722;
   @ObfuscatedName("p")
   byte field1723 = 0;
   @ObfuscatedName("az")
   boolean field1724 = false;
   @ObfuscatedName("ai")
   int field1725;
   @ObfuscatedName("aq")
   int field1726;
   @ObfuscatedName("ah")
   int field1727;
   @ObfuscatedName("ap")
   int field1728;
   @ObfuscatedName("af")
   int field1729;
   @ObfuscatedName("aa")
   static int[] field1730 = new int[10000];
   @ObfuscatedName("as")
   class96[] field1731;
   @ObfuscatedName("aw")
   static int field1732 = 0;
   @ObfuscatedName("ay")
   static int[] field1733 = new int[10000];
   @ObfuscatedName("ae")
   static int[] field1734;

   static {
      field1722 = class91.field1597;
      field1734 = class91.field1577;
   }

   class100(byte[] var1) {
      if(var1[var1.length - 1] == -1 && var1[var1.length - 2] == -1) {
         this.method2271(var1);
      } else {
         this.method2308(var1);
      }

   }

   @ObfuscatedName("u")
   void method2271(byte[] var1) {
      class119 var2 = new class119(var1);
      class119 var3 = new class119(var1);
      class119 var4 = new class119(var1);
      class119 var5 = new class119(var1);
      class119 var6 = new class119(var1);
      class119 var7 = new class119(var1);
      class119 var8 = new class119(var1);
      var2.field1998 = var1.length - 23;
      int var9 = var2.method2556();
      int var10 = var2.method2556();
      int var11 = var2.method2554();
      int var12 = var2.method2554();
      int var13 = var2.method2554();
      int var14 = var2.method2554();
      int var15 = var2.method2554();
      int var16 = var2.method2554();
      int var17 = var2.method2554();
      int var18 = var2.method2556();
      int var19 = var2.method2556();
      int var20 = var2.method2556();
      int var21 = var2.method2556();
      int var22 = var2.method2556();
      int var23 = 0;
      int var24 = 0;
      int var25 = 0;
      int var26;
      if(var11 > 0) {
         this.field1718 = new byte[var11];
         var2.field1998 = 0;

         for(var26 = 0; var26 < var11; ++var26) {
            byte var27 = this.field1718[var26] = var2.method2538();
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
      this.field1712 = var9;
      this.field1690 = var10;
      this.field1714 = var11;
      this.field1697 = new int[var9];
      this.field1713 = new int[var9];
      this.field1691 = new int[var9];
      this.field1693 = new int[var10];
      this.field1694 = new int[var10];
      this.field1695 = new int[var10];
      if(var17 == 1) {
         this.field1715 = new int[var9];
      }

      if(var12 == 1) {
         this.field1696 = new byte[var10];
      }

      if(var13 == 255) {
         this.field1721 = new byte[var10];
      } else {
         this.field1723 = (byte)var13;
      }

      if(var14 == 1) {
         this.field1698 = new byte[var10];
      }

      if(var15 == 1) {
         this.field1716 = new int[var10];
      }

      if(var16 == 1) {
         this.field1701 = new short[var10];
      }

      if(var16 == 1 && var11 > 0) {
         this.field1699 = new byte[var10];
      }

      this.field1700 = new short[var10];
      if(var11 > 0) {
         this.field1705 = new short[var11];
         this.field1706 = new short[var11];
         this.field1707 = new short[var11];
         if(var24 > 0) {
            this.field1708 = new short[var24];
            this.field1692 = new short[var24];
            this.field1710 = new short[var24];
            this.field1711 = new short[var24];
            this.field1704 = new byte[var24];
            this.field1689 = new short[var24];
         }

         if(var25 > 0) {
            this.field1703 = new short[var25];
         }
      }

      var2.field1998 = var11;
      var3.field1998 = var38;
      var4.field1998 = var39;
      var5.field1998 = var40;
      var6.field1998 = var32;
      int var48 = 0;
      int var49 = 0;
      int var50 = 0;

      int var51;
      int var52;
      int var53;
      int var54;
      int var55;
      for(var51 = 0; var51 < var9; ++var51) {
         var52 = var2.method2554();
         var53 = 0;
         if((var52 & 1) != 0) {
            var53 = var3.method2566();
         }

         var54 = 0;
         if((var52 & 2) != 0) {
            var54 = var4.method2566();
         }

         var55 = 0;
         if((var52 & 4) != 0) {
            var55 = var5.method2566();
         }

         this.field1697[var51] = var48 + var53;
         this.field1713[var51] = var49 + var54;
         this.field1691[var51] = var50 + var55;
         var48 = this.field1697[var51];
         var49 = this.field1713[var51];
         var50 = this.field1691[var51];
         if(var17 == 1) {
            this.field1715[var51] = var6.method2554();
         }
      }

      var2.field1998 = var37;
      var3.field1998 = var28;
      var4.field1998 = var30;
      var5.field1998 = var33;
      var6.field1998 = var31;
      var7.field1998 = var35;
      var8.field1998 = var36;

      for(var51 = 0; var51 < var10; ++var51) {
         this.field1700[var51] = (short)var2.method2556();
         if(var12 == 1) {
            this.field1696[var51] = var3.method2538();
         }

         if(var13 == 255) {
            this.field1721[var51] = var4.method2538();
         }

         if(var14 == 1) {
            this.field1698[var51] = var5.method2538();
         }

         if(var15 == 1) {
            this.field1716[var51] = var6.method2554();
         }

         if(var16 == 1) {
            this.field1701[var51] = (short)(var7.method2556() - 1);
         }

         if(this.field1699 != null && this.field1701[var51] != -1) {
            this.field1699[var51] = (byte)(var8.method2554() - 1);
         }
      }

      var2.field1998 = var34;
      var3.field1998 = var29;
      var51 = 0;
      var52 = 0;
      var53 = 0;
      var54 = 0;

      int var56;
      for(var55 = 0; var55 < var10; ++var55) {
         var56 = var3.method2554();
         if(var56 == 1) {
            var51 = var2.method2566() + var54;
            var52 = var2.method2566() + var51;
            var53 = var2.method2566() + var52;
            var54 = var53;
            this.field1693[var55] = var51;
            this.field1694[var55] = var52;
            this.field1695[var55] = var53;
         }

         if(var56 == 2) {
            var52 = var53;
            var53 = var2.method2566() + var54;
            var54 = var53;
            this.field1693[var55] = var51;
            this.field1694[var55] = var52;
            this.field1695[var55] = var53;
         }

         if(var56 == 3) {
            var51 = var53;
            var53 = var2.method2566() + var54;
            var54 = var53;
            this.field1693[var55] = var51;
            this.field1694[var55] = var52;
            this.field1695[var55] = var53;
         }

         if(var56 == 4) {
            int var57 = var51;
            var51 = var52;
            var52 = var57;
            var53 = var2.method2566() + var54;
            var54 = var53;
            this.field1693[var55] = var51;
            this.field1694[var55] = var57;
            this.field1695[var55] = var53;
         }
      }

      var2.field1998 = var41;
      var3.field1998 = var42;
      var4.field1998 = var43;
      var5.field1998 = var44;
      var6.field1998 = var45;
      var7.field1998 = var46;

      for(var55 = 0; var55 < var11; ++var55) {
         var56 = this.field1718[var55] & 255;
         if(var56 == 0) {
            this.field1705[var55] = (short)var2.method2556();
            this.field1706[var55] = (short)var2.method2556();
            this.field1707[var55] = (short)var2.method2556();
         }

         if(var56 == 1) {
            this.field1705[var55] = (short)var3.method2556();
            this.field1706[var55] = (short)var3.method2556();
            this.field1707[var55] = (short)var3.method2556();
            this.field1708[var55] = (short)var4.method2556();
            this.field1692[var55] = (short)var4.method2556();
            this.field1710[var55] = (short)var4.method2556();
            this.field1711[var55] = (short)var5.method2556();
            this.field1704[var55] = var6.method2538();
            this.field1689[var55] = (short)var7.method2556();
         }

         if(var56 == 2) {
            this.field1705[var55] = (short)var3.method2556();
            this.field1706[var55] = (short)var3.method2556();
            this.field1707[var55] = (short)var3.method2556();
            this.field1708[var55] = (short)var4.method2556();
            this.field1692[var55] = (short)var4.method2556();
            this.field1710[var55] = (short)var4.method2556();
            this.field1711[var55] = (short)var5.method2556();
            this.field1704[var55] = var6.method2538();
            this.field1689[var55] = (short)var7.method2556();
            this.field1703[var55] = (short)var7.method2556();
         }

         if(var56 == 3) {
            this.field1705[var55] = (short)var3.method2556();
            this.field1706[var55] = (short)var3.method2556();
            this.field1707[var55] = (short)var3.method2556();
            this.field1708[var55] = (short)var4.method2556();
            this.field1692[var55] = (short)var4.method2556();
            this.field1710[var55] = (short)var4.method2556();
            this.field1711[var55] = (short)var5.method2556();
            this.field1704[var55] = var6.method2538();
            this.field1689[var55] = (short)var7.method2556();
         }
      }

      var2.field1998 = var26;
      var55 = var2.method2554();
      if(var55 != 0) {
         new class90();
         var2.method2556();
         var2.method2556();
         var2.method2556();
         var2.method2696();
      }

   }

   @ObfuscatedName("l")
   final int method2274(class100 var1, int var2) {
      int var3 = -1;
      int var4 = var1.field1697[var2];
      int var5 = var1.field1713[var2];
      int var6 = var1.field1691[var2];

      for(int var7 = 0; var7 < this.field1712; ++var7) {
         if(var4 == this.field1697[var7] && var5 == this.field1713[var7] && var6 == this.field1691[var7]) {
            var3 = var7;
            break;
         }
      }

      if(var3 == -1) {
         this.field1697[this.field1712] = var4;
         this.field1713[this.field1712] = var5;
         this.field1691[this.field1712] = var6;
         if(var1.field1715 != null) {
            this.field1715[this.field1712] = var1.field1715[var2];
         }

         var3 = this.field1712++;
      }

      return var3;
   }

   @ObfuscatedSignature(
      signature = "(Lclass100;ZZZZ)V",
      garbageValue = "1"
   )
   public class100(class100 var1, boolean var2, boolean var3, boolean var4, boolean var5) {
      this.field1712 = var1.field1712;
      this.field1690 = var1.field1690;
      this.field1714 = var1.field1714;
      int var6;
      if(var2) {
         this.field1697 = var1.field1697;
         this.field1713 = var1.field1713;
         this.field1691 = var1.field1691;
      } else {
         this.field1697 = new int[this.field1712];
         this.field1713 = new int[this.field1712];
         this.field1691 = new int[this.field1712];

         for(var6 = 0; var6 < this.field1712; ++var6) {
            this.field1697[var6] = var1.field1697[var6];
            this.field1713[var6] = var1.field1713[var6];
            this.field1691[var6] = var1.field1691[var6];
         }
      }

      if(var3) {
         this.field1700 = var1.field1700;
      } else {
         this.field1700 = new short[this.field1690];

         for(var6 = 0; var6 < this.field1690; ++var6) {
            this.field1700[var6] = var1.field1700[var6];
         }
      }

      if(!var4 && var1.field1701 != null) {
         this.field1701 = new short[this.field1690];

         for(var6 = 0; var6 < this.field1690; ++var6) {
            this.field1701[var6] = var1.field1701[var6];
         }
      } else {
         this.field1701 = var1.field1701;
      }

      this.field1698 = var1.field1698;
      this.field1693 = var1.field1693;
      this.field1694 = var1.field1694;
      this.field1695 = var1.field1695;
      this.field1696 = var1.field1696;
      this.field1721 = var1.field1721;
      this.field1699 = var1.field1699;
      this.field1723 = var1.field1723;
      this.field1718 = var1.field1718;
      this.field1705 = var1.field1705;
      this.field1706 = var1.field1706;
      this.field1707 = var1.field1707;
      this.field1708 = var1.field1708;
      this.field1692 = var1.field1692;
      this.field1710 = var1.field1710;
      this.field1711 = var1.field1711;
      this.field1704 = var1.field1704;
      this.field1689 = var1.field1689;
      this.field1703 = var1.field1703;
      this.field1715 = var1.field1715;
      this.field1716 = var1.field1716;
      this.field1717 = var1.field1717;
      this.field1702 = var1.field1702;
      this.field1720 = var1.field1720;
      this.field1719 = var1.field1719;
      this.field1731 = var1.field1731;
      this.field1709 = var1.field1709;
      this.field1688 = var1.field1688;
   }

   @ObfuscatedName("m")
   @Export("computeAnimationTables")
   void method2277() {
      int[] var1;
      int var2;
      int var3;
      int var4;
      if(this.field1715 != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.field1712; ++var3) {
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

         for(var3 = 0; var3 < this.field1712; this.field1717[var4][var1[var4]++] = var3++) {
            var4 = this.field1715[var3];
         }

         this.field1715 = null;
      }

      if(this.field1716 != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.field1690; ++var3) {
            var4 = this.field1716[var3];
            ++var1[var4];
            if(var4 > var2) {
               var2 = var4;
            }
         }

         this.field1702 = new int[var2 + 1][];

         for(var3 = 0; var3 <= var2; ++var3) {
            this.field1702[var3] = new int[var1[var3]];
            var1[var3] = 0;
         }

         for(var3 = 0; var3 < this.field1690; this.field1702[var4][var1[var4]++] = var3++) {
            var4 = this.field1716[var3];
         }

         this.field1716 = null;
      }

   }

   @ObfuscatedName("g")
   public void method2278() {
      for(int var1 = 0; var1 < this.field1712; ++var1) {
         int var2 = this.field1697[var1];
         this.field1697[var1] = this.field1691[var1];
         this.field1691[var1] = -var2;
      }

      this.method2287();
   }

   class100() {
   }

   @ObfuscatedName("r")
   public void method2279() {
      for(int var1 = 0; var1 < this.field1712; ++var1) {
         int var2 = this.field1691[var1];
         this.field1691[var1] = this.field1697[var1];
         this.field1697[var1] = -var2;
      }

      this.method2287();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass167;II)Lclass100;",
      garbageValue = "0"
   )
   public static class100 method2280(class167 var0, int var1, int var2) {
      byte[] var3 = var0.method3286(var1, var2);
      return var3 == null?null:new class100(var3);
   }

   @ObfuscatedName("a")
   static void method2281(class100 var0, class100 var1, int var2, int var3, int var4, boolean var5) {
      var0.method2288();
      var0.method2286();
      var1.method2288();
      var1.method2286();
      ++field1732;
      int var6 = 0;
      int[] var7 = var1.field1697;
      int var8 = var1.field1712;

      int var9;
      for(var9 = 0; var9 < var0.field1712; ++var9) {
         class96 var10 = var0.field1720[var9];
         if(var10.field1635 != 0) {
            int var11 = var0.field1713[var9] - var3;
            if(var11 <= var1.field1725) {
               int var12 = var0.field1697[var9] - var2;
               if(var12 >= var1.field1726 && var12 <= var1.field1727) {
                  int var13 = var0.field1691[var9] - var4;
                  if(var13 >= var1.field1729 && var13 <= var1.field1728) {
                     for(int var14 = 0; var14 < var8; ++var14) {
                        class96 var15 = var1.field1720[var14];
                        if(var12 == var7[var14] && var13 == var1.field1691[var14] && var11 == var1.field1713[var14] && var15.field1635 != 0) {
                           if(var0.field1731 == null) {
                              var0.field1731 = new class96[var0.field1712];
                           }

                           if(var1.field1731 == null) {
                              var1.field1731 = new class96[var8];
                           }

                           class96 var16 = var0.field1731[var9];
                           if(var16 == null) {
                              var16 = var0.field1731[var9] = new class96(var10);
                           }

                           class96 var17 = var1.field1731[var14];
                           if(var17 == null) {
                              var17 = var1.field1731[var14] = new class96(var15);
                           }

                           var16.field1634 += var15.field1634;
                           var16.field1632 += var15.field1632;
                           var16.field1637 += var15.field1637;
                           var16.field1635 += var15.field1635;
                           var17.field1634 += var10.field1634;
                           var17.field1632 += var10.field1632;
                           var17.field1637 += var10.field1637;
                           var17.field1635 += var10.field1635;
                           ++var6;
                           field1730[var9] = field1732;
                           field1733[var14] = field1732;
                        }
                     }
                  }
               }
            }
         }
      }

      if(var6 >= 3 && var5) {
         for(var9 = 0; var9 < var0.field1690; ++var9) {
            if(field1730[var0.field1693[var9]] == field1732 && field1730[var0.field1694[var9]] == field1732 && field1730[var0.field1695[var9]] == field1732) {
               if(var0.field1696 == null) {
                  var0.field1696 = new byte[var0.field1690];
               }

               var0.field1696[var9] = 2;
            }
         }

         for(var9 = 0; var9 < var1.field1690; ++var9) {
            if(field1733[var1.field1693[var9]] == field1732 && field1733[var1.field1694[var9]] == field1732 && field1733[var1.field1695[var9]] == field1732) {
               if(var1.field1696 == null) {
                  var1.field1696 = new byte[var1.field1690];
               }

               var1.field1696[var9] = 2;
            }
         }

      }
   }

   @ObfuscatedName("n")
   public class100 method2282(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2288();
      int var7 = var2 + this.field1726;
      int var8 = var2 + this.field1727;
      int var9 = var4 + this.field1729;
      int var10 = var4 + this.field1728;
      if(var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
         var7 >>= 7;
         var8 = var8 + 127 >> 7;
         var9 >>= 7;
         var10 = var10 + 127 >> 7;
         if(var1[var7][var9] == var3 && var1[var8][var9] == var3 && var1[var7][var10] == var3 && var1[var8][var10] == var3) {
            return this;
         } else {
            class100 var11 = new class100();
            var11.field1712 = this.field1712;
            var11.field1690 = this.field1690;
            var11.field1714 = this.field1714;
            var11.field1697 = this.field1697;
            var11.field1691 = this.field1691;
            var11.field1693 = this.field1693;
            var11.field1694 = this.field1694;
            var11.field1695 = this.field1695;
            var11.field1696 = this.field1696;
            var11.field1721 = this.field1721;
            var11.field1698 = this.field1698;
            var11.field1699 = this.field1699;
            var11.field1700 = this.field1700;
            var11.field1701 = this.field1701;
            var11.field1723 = this.field1723;
            var11.field1718 = this.field1718;
            var11.field1705 = this.field1705;
            var11.field1706 = this.field1706;
            var11.field1707 = this.field1707;
            var11.field1708 = this.field1708;
            var11.field1692 = this.field1692;
            var11.field1710 = this.field1710;
            var11.field1711 = this.field1711;
            var11.field1704 = this.field1704;
            var11.field1689 = this.field1689;
            var11.field1703 = this.field1703;
            var11.field1715 = this.field1715;
            var11.field1716 = this.field1716;
            var11.field1717 = this.field1717;
            var11.field1702 = this.field1702;
            var11.field1709 = this.field1709;
            var11.field1688 = this.field1688;
            var11.field1713 = new int[var11.field1712];
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
               for(var12 = 0; var12 < var11.field1712; ++var12) {
                  var13 = this.field1697[var12] + var2;
                  var14 = this.field1691[var12] + var4;
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var1[var17 + 1][var18 + 1] * var15 >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.field1713[var12] = this.field1713[var12] + var21 - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1712; ++var12) {
                  var13 = (-this.field1713[var12] << 16) / super.field1468;
                  if(var13 < var6) {
                     var14 = this.field1697[var12] + var2;
                     var15 = this.field1691[var12] + var4;
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var1[var18 + 1][var19 + 1] * var16 >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.field1713[var12] = this.field1713[var12] + (var22 - var3) * (var6 - var13) / var6;
                  }
               }
            }

            var11.method2287();
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("w")
   public void method2284() {
      int var1;
      for(var1 = 0; var1 < this.field1712; ++var1) {
         this.field1691[var1] = -this.field1691[var1];
      }

      for(var1 = 0; var1 < this.field1690; ++var1) {
         int var2 = this.field1693[var1];
         this.field1693[var1] = this.field1695[var1];
         this.field1695[var1] = var2;
      }

      this.method2287();
   }

   @ObfuscatedName("v")
   public void method2285(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1712; ++var4) {
         this.field1697[var4] = this.field1697[var4] * var1 / 128;
         this.field1713[var4] = this.field1713[var4] * var2 / 128;
         this.field1691[var4] = this.field1691[var4] * var3 / 128;
      }

      this.method2287();
   }

   @ObfuscatedName("y")
   @Export("computeNormals")
   public void method2286() {
      if(this.field1720 == null) {
         this.field1720 = new class96[this.field1712];

         int var1;
         for(var1 = 0; var1 < this.field1712; ++var1) {
            this.field1720[var1] = new class96();
         }

         for(var1 = 0; var1 < this.field1690; ++var1) {
            int var2 = this.field1693[var1];
            int var3 = this.field1694[var1];
            int var4 = this.field1695[var1];
            int var5 = this.field1697[var3] - this.field1697[var2];
            int var6 = this.field1713[var3] - this.field1713[var2];
            int var7 = this.field1691[var3] - this.field1691[var2];
            int var8 = this.field1697[var4] - this.field1697[var2];
            int var9 = this.field1713[var4] - this.field1713[var2];
            int var10 = this.field1691[var4] - this.field1691[var2];
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
            if(this.field1696 == null) {
               var15 = 0;
            } else {
               var15 = this.field1696[var1];
            }

            if(var15 == 0) {
               class96 var16 = this.field1720[var2];
               var16.field1634 += var11;
               var16.field1632 += var12;
               var16.field1637 += var13;
               ++var16.field1635;
               var16 = this.field1720[var3];
               var16.field1634 += var11;
               var16.field1632 += var12;
               var16.field1637 += var13;
               ++var16.field1635;
               var16 = this.field1720[var4];
               var16.field1634 += var11;
               var16.field1632 += var12;
               var16.field1637 += var13;
               ++var16.field1635;
            } else if(var15 == 1) {
               if(this.field1719 == null) {
                  this.field1719 = new class84[this.field1690];
               }

               class84 var17 = this.field1719[var1] = new class84();
               var17.field1460 = var11;
               var17.field1461 = var12;
               var17.field1462 = var13;
            }
         }

      }
   }

   @ObfuscatedName("c")
   void method2287() {
      this.field1720 = null;
      this.field1731 = null;
      this.field1719 = null;
      this.field1724 = false;
   }

   @ObfuscatedName("i")
   void method2288() {
      if(!this.field1724) {
         super.field1468 = 0;
         this.field1725 = 0;
         this.field1726 = 999999;
         this.field1727 = -999999;
         this.field1728 = -99999;
         this.field1729 = 99999;

         for(int var1 = 0; var1 < this.field1712; ++var1) {
            int var2 = this.field1697[var1];
            int var3 = this.field1713[var1];
            int var4 = this.field1691[var1];
            if(var2 < this.field1726) {
               this.field1726 = var2;
            }

            if(var2 > this.field1727) {
               this.field1727 = var2;
            }

            if(var4 < this.field1729) {
               this.field1729 = var4;
            }

            if(var4 > this.field1728) {
               this.field1728 = var4;
            }

            if(-var3 > super.field1468) {
               super.field1468 = -var3;
            }

            if(var3 > this.field1725) {
               this.field1725 = var3;
            }
         }

         this.field1724 = true;
      }
   }

   @ObfuscatedName("z")
   public final class105 method2290(int var1, int var2, int var3, int var4, int var5) {
      this.method2286();
      int var6 = (int)Math.sqrt((double)(var3 * var3 + var4 * var4 + var5 * var5));
      int var7 = var2 * var6 >> 8;
      class105 var8 = new class105();
      var8.field1819 = new int[this.field1690];
      var8.field1827 = new int[this.field1690];
      var8.field1817 = new int[this.field1690];
      if(this.field1714 > 0 && this.field1699 != null) {
         int[] var9 = new int[this.field1714];

         int var10;
         for(var10 = 0; var10 < this.field1690; ++var10) {
            if(this.field1699[var10] != -1) {
               ++var9[this.field1699[var10] & 255];
            }
         }

         var8.field1823 = 0;

         for(var10 = 0; var10 < this.field1714; ++var10) {
            if(var9[var10] > 0 && this.field1718[var10] == 0) {
               ++var8.field1823;
            }
         }

         var8.field1824 = new int[var8.field1823];
         var8.field1825 = new int[var8.field1823];
         var8.field1826 = new int[var8.field1823];
         var10 = 0;

         int var11;
         for(var11 = 0; var11 < this.field1714; ++var11) {
            if(var9[var11] > 0 && this.field1718[var11] == 0) {
               var8.field1824[var10] = this.field1705[var11] & '\uffff';
               var8.field1825[var10] = this.field1706[var11] & '\uffff';
               var8.field1826[var10] = this.field1707[var11] & '\uffff';
               var9[var11] = var10++;
            } else {
               var9[var11] = -1;
            }
         }

         var8.field1820 = new byte[this.field1690];

         for(var11 = 0; var11 < this.field1690; ++var11) {
            if(this.field1699[var11] != -1) {
               var8.field1820[var11] = (byte)var9[this.field1699[var11] & 255];
            } else {
               var8.field1820[var11] = -1;
            }
         }
      }

      for(int var16 = 0; var16 < this.field1690; ++var16) {
         byte var17;
         if(this.field1696 == null) {
            var17 = 0;
         } else {
            var17 = this.field1696[var16];
         }

         byte var18;
         if(this.field1698 == null) {
            var18 = 0;
         } else {
            var18 = this.field1698[var16];
         }

         short var12;
         if(this.field1701 == null) {
            var12 = -1;
         } else {
            var12 = this.field1701[var16];
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
                  var19 = this.field1719[var16];
                  var14 = var1 + (var3 * var19.field1460 + var4 * var19.field1461 + var5 * var19.field1462) / (var7 + var7 / 2);
                  var8.field1819[var16] = method2291(this.field1700[var16] & '\uffff', var14);
                  var8.field1817[var16] = -1;
               } else if(var17 == 3) {
                  var8.field1819[var16] = 128;
                  var8.field1817[var16] = -1;
               } else {
                  var8.field1817[var16] = -2;
               }
            } else {
               int var15 = this.field1700[var16] & '\uffff';
               if(this.field1731 != null && this.field1731[this.field1693[var16]] != null) {
                  var13 = this.field1731[this.field1693[var16]];
               } else {
                  var13 = this.field1720[this.field1693[var16]];
               }

               var14 = var1 + (var3 * var13.field1634 + var4 * var13.field1632 + var5 * var13.field1637) / (var7 * var13.field1635);
               var8.field1819[var16] = method2291(var15, var14);
               if(this.field1731 != null && this.field1731[this.field1694[var16]] != null) {
                  var13 = this.field1731[this.field1694[var16]];
               } else {
                  var13 = this.field1720[this.field1694[var16]];
               }

               var14 = var1 + (var3 * var13.field1634 + var4 * var13.field1632 + var5 * var13.field1637) / (var7 * var13.field1635);
               var8.field1827[var16] = method2291(var15, var14);
               if(this.field1731 != null && this.field1731[this.field1695[var16]] != null) {
                  var13 = this.field1731[this.field1695[var16]];
               } else {
                  var13 = this.field1720[this.field1695[var16]];
               }

               var14 = var1 + (var3 * var13.field1634 + var4 * var13.field1632 + var5 * var13.field1637) / (var7 * var13.field1635);
               var8.field1817[var16] = method2291(var15, var14);
            }
         } else if(var17 != 0) {
            if(var17 == 1) {
               var19 = this.field1719[var16];
               var14 = var1 + (var3 * var19.field1460 + var4 * var19.field1461 + var5 * var19.field1462) / (var7 + var7 / 2);
               var8.field1819[var16] = method2292(var14);
               var8.field1817[var16] = -1;
            } else {
               var8.field1817[var16] = -2;
            }
         } else {
            if(this.field1731 != null && this.field1731[this.field1693[var16]] != null) {
               var13 = this.field1731[this.field1693[var16]];
            } else {
               var13 = this.field1720[this.field1693[var16]];
            }

            var14 = var1 + (var3 * var13.field1634 + var4 * var13.field1632 + var5 * var13.field1637) / (var7 * var13.field1635);
            var8.field1819[var16] = method2292(var14);
            if(this.field1731 != null && this.field1731[this.field1694[var16]] != null) {
               var13 = this.field1731[this.field1694[var16]];
            } else {
               var13 = this.field1720[this.field1694[var16]];
            }

            var14 = var1 + (var3 * var13.field1634 + var4 * var13.field1632 + var5 * var13.field1637) / (var7 * var13.field1635);
            var8.field1827[var16] = method2292(var14);
            if(this.field1731 != null && this.field1731[this.field1695[var16]] != null) {
               var13 = this.field1731[this.field1695[var16]];
            } else {
               var13 = this.field1720[this.field1695[var16]];
            }

            var14 = var1 + (var3 * var13.field1634 + var4 * var13.field1632 + var5 * var13.field1637) / (var7 * var13.field1635);
            var8.field1817[var16] = method2292(var14);
         }
      }

      this.method2277();
      var8.field1835 = this.field1712;
      var8.field1865 = this.field1697;
      var8.field1809 = this.field1713;
      var8.field1815 = this.field1691;
      var8.field1811 = this.field1690;
      var8.field1846 = this.field1693;
      var8.field1813 = this.field1694;
      var8.field1814 = this.field1695;
      var8.field1818 = this.field1721;
      var8.field1821 = this.field1698;
      var8.field1822 = this.field1723;
      var8.field1849 = this.field1717;
      var8.field1828 = this.field1702;
      var8.field1863 = this.field1701;
      return var8;
   }

   @ObfuscatedName("j")
   static final int method2291(int var0, int var1) {
      var1 = var1 * (var0 & 127) >> 7;
      if(var1 < 2) {
         var1 = 2;
      } else if(var1 > 126) {
         var1 = 126;
      }

      return (var0 & 'ﾀ') + var1;
   }

   @ObfuscatedName("ag")
   static final int method2292(int var0) {
      if(var0 < 2) {
         var0 = 2;
      } else if(var0 > 126) {
         var0 = 126;
      }

      return var0;
   }

   @ObfuscatedName("t")
   public void method2300(short var1, short var2) {
      if(this.field1701 != null) {
         for(int var3 = 0; var3 < this.field1690; ++var3) {
            if(this.field1701[var3] == var1) {
               this.field1701[var3] = var2;
            }
         }

      }
   }

   @ObfuscatedName("d")
   public class100 method2303() {
      class100 var1 = new class100();
      if(this.field1696 != null) {
         var1.field1696 = new byte[this.field1690];

         for(int var2 = 0; var2 < this.field1690; ++var2) {
            var1.field1696[var2] = this.field1696[var2];
         }
      }

      var1.field1712 = this.field1712;
      var1.field1690 = this.field1690;
      var1.field1714 = this.field1714;
      var1.field1697 = this.field1697;
      var1.field1713 = this.field1713;
      var1.field1691 = this.field1691;
      var1.field1693 = this.field1693;
      var1.field1694 = this.field1694;
      var1.field1695 = this.field1695;
      var1.field1721 = this.field1721;
      var1.field1698 = this.field1698;
      var1.field1699 = this.field1699;
      var1.field1700 = this.field1700;
      var1.field1701 = this.field1701;
      var1.field1723 = this.field1723;
      var1.field1718 = this.field1718;
      var1.field1705 = this.field1705;
      var1.field1706 = this.field1706;
      var1.field1707 = this.field1707;
      var1.field1708 = this.field1708;
      var1.field1692 = this.field1692;
      var1.field1710 = this.field1710;
      var1.field1711 = this.field1711;
      var1.field1704 = this.field1704;
      var1.field1689 = this.field1689;
      var1.field1703 = this.field1703;
      var1.field1715 = this.field1715;
      var1.field1716 = this.field1716;
      var1.field1717 = this.field1717;
      var1.field1702 = this.field1702;
      var1.field1720 = this.field1720;
      var1.field1719 = this.field1719;
      var1.field1709 = this.field1709;
      var1.field1688 = this.field1688;
      return var1;
   }

   @ObfuscatedName("s")
   public void method2305() {
      for(int var1 = 0; var1 < this.field1712; ++var1) {
         this.field1697[var1] = -this.field1697[var1];
         this.field1691[var1] = -this.field1691[var1];
      }

      this.method2287();
   }

   @ObfuscatedName("b")
   void method2308(byte[] var1) {
      boolean var2 = false;
      boolean var3 = false;
      class119 var4 = new class119(var1);
      class119 var5 = new class119(var1);
      class119 var6 = new class119(var1);
      class119 var7 = new class119(var1);
      class119 var8 = new class119(var1);
      var4.field1998 = var1.length - 18;
      int var9 = var4.method2556();
      int var10 = var4.method2556();
      int var11 = var4.method2554();
      int var12 = var4.method2554();
      int var13 = var4.method2554();
      int var14 = var4.method2554();
      int var15 = var4.method2554();
      int var16 = var4.method2554();
      int var17 = var4.method2556();
      int var18 = var4.method2556();
      int var19 = var4.method2556();
      int var20 = var4.method2556();
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
      this.field1712 = var9;
      this.field1690 = var10;
      this.field1714 = var11;
      this.field1697 = new int[var9];
      this.field1713 = new int[var9];
      this.field1691 = new int[var9];
      this.field1693 = new int[var10];
      this.field1694 = new int[var10];
      this.field1695 = new int[var10];
      if(var11 > 0) {
         this.field1718 = new byte[var11];
         this.field1705 = new short[var11];
         this.field1706 = new short[var11];
         this.field1707 = new short[var11];
      }

      if(var16 == 1) {
         this.field1715 = new int[var9];
      }

      if(var12 == 1) {
         this.field1696 = new byte[var10];
         this.field1699 = new byte[var10];
         this.field1701 = new short[var10];
      }

      if(var13 == 255) {
         this.field1721 = new byte[var10];
      } else {
         this.field1723 = (byte)var13;
      }

      if(var14 == 1) {
         this.field1698 = new byte[var10];
      }

      if(var15 == 1) {
         this.field1716 = new int[var10];
      }

      this.field1700 = new short[var10];
      var4.field1998 = var21;
      var5.field1998 = var32;
      var6.field1998 = var33;
      var7.field1998 = var45;
      var8.field1998 = var27;
      int var35 = 0;
      int var36 = 0;
      int var37 = 0;

      int var38;
      int var39;
      int var40;
      int var41;
      int var42;
      for(var38 = 0; var38 < var9; ++var38) {
         var39 = var4.method2554();
         var40 = 0;
         if((var39 & 1) != 0) {
            var40 = var5.method2566();
         }

         var41 = 0;
         if((var39 & 2) != 0) {
            var41 = var6.method2566();
         }

         var42 = 0;
         if((var39 & 4) != 0) {
            var42 = var7.method2566();
         }

         this.field1697[var38] = var35 + var40;
         this.field1713[var38] = var36 + var41;
         this.field1691[var38] = var37 + var42;
         var35 = this.field1697[var38];
         var36 = this.field1713[var38];
         var37 = this.field1691[var38];
         if(var16 == 1) {
            this.field1715[var38] = var8.method2554();
         }
      }

      var4.field1998 = var30;
      var5.field1998 = var26;
      var6.field1998 = var24;
      var7.field1998 = var28;
      var8.field1998 = var25;

      for(var38 = 0; var38 < var10; ++var38) {
         this.field1700[var38] = (short)var4.method2556();
         if(var12 == 1) {
            var39 = var5.method2554();
            if((var39 & 1) == 1) {
               this.field1696[var38] = 1;
               var2 = true;
            } else {
               this.field1696[var38] = 0;
            }

            if((var39 & 2) == 2) {
               this.field1699[var38] = (byte)(var39 >> 2);
               this.field1701[var38] = this.field1700[var38];
               this.field1700[var38] = 127;
               if(this.field1701[var38] != -1) {
                  var3 = true;
               }
            } else {
               this.field1699[var38] = -1;
               this.field1701[var38] = -1;
            }
         }

         if(var13 == 255) {
            this.field1721[var38] = var6.method2538();
         }

         if(var14 == 1) {
            this.field1698[var38] = var7.method2538();
         }

         if(var15 == 1) {
            this.field1716[var38] = var8.method2554();
         }
      }

      var4.field1998 = var29;
      var5.field1998 = var23;
      var38 = 0;
      var39 = 0;
      var40 = 0;
      var41 = 0;

      int var43;
      int var44;
      for(var42 = 0; var42 < var10; ++var42) {
         var43 = var5.method2554();
         if(var43 == 1) {
            var38 = var4.method2566() + var41;
            var39 = var4.method2566() + var38;
            var40 = var4.method2566() + var39;
            var41 = var40;
            this.field1693[var42] = var38;
            this.field1694[var42] = var39;
            this.field1695[var42] = var40;
         }

         if(var43 == 2) {
            var39 = var40;
            var40 = var4.method2566() + var41;
            var41 = var40;
            this.field1693[var42] = var38;
            this.field1694[var42] = var39;
            this.field1695[var42] = var40;
         }

         if(var43 == 3) {
            var38 = var40;
            var40 = var4.method2566() + var41;
            var41 = var40;
            this.field1693[var42] = var38;
            this.field1694[var42] = var39;
            this.field1695[var42] = var40;
         }

         if(var43 == 4) {
            var44 = var38;
            var38 = var39;
            var39 = var44;
            var40 = var4.method2566() + var41;
            var41 = var40;
            this.field1693[var42] = var38;
            this.field1694[var42] = var44;
            this.field1695[var42] = var40;
         }
      }

      var4.field1998 = var31;

      for(var42 = 0; var42 < var11; ++var42) {
         this.field1718[var42] = 0;
         this.field1705[var42] = (short)var4.method2556();
         this.field1706[var42] = (short)var4.method2556();
         this.field1707[var42] = (short)var4.method2556();
      }

      if(this.field1699 != null) {
         boolean var46 = false;

         for(var43 = 0; var43 < var10; ++var43) {
            var44 = this.field1699[var43] & 255;
            if(var44 != 255) {
               if((this.field1705[var44] & '\uffff') == this.field1693[var43] && (this.field1706[var44] & '\uffff') == this.field1694[var43] && (this.field1707[var44] & '\uffff') == this.field1695[var43]) {
                  this.field1699[var43] = -1;
               } else {
                  var46 = true;
               }
            }
         }

         if(!var46) {
            this.field1699 = null;
         }
      }

      if(!var3) {
         this.field1701 = null;
      }

      if(!var2) {
         this.field1696 = null;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "256"
   )
   public void method2311(int var1) {
      int var2 = field1722[var1];
      int var3 = field1734[var1];

      for(int var4 = 0; var4 < this.field1712; ++var4) {
         int var5 = this.field1691[var4] * var2 + this.field1697[var4] * var3 >> 16;
         this.field1691[var4] = this.field1691[var4] * var3 - this.field1697[var4] * var2 >> 16;
         this.field1697[var4] = var5;
      }

      this.method2287();
   }

   public class100(class100[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      boolean var8 = false;
      this.field1712 = 0;
      this.field1690 = 0;
      this.field1714 = 0;
      this.field1723 = -1;

      int var9;
      class100 var10;
      for(var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if(var10 != null) {
            this.field1712 += var10.field1712;
            this.field1690 += var10.field1690;
            this.field1714 += var10.field1714;
            if(var10.field1721 != null) {
               var4 = true;
            } else {
               if(this.field1723 == -1) {
                  this.field1723 = var10.field1723;
               }

               if(this.field1723 != var10.field1723) {
                  var4 = true;
               }
            }

            var3 |= var10.field1696 != null;
            var5 |= var10.field1698 != null;
            var6 |= var10.field1716 != null;
            var7 |= var10.field1701 != null;
            var8 |= var10.field1699 != null;
         }
      }

      this.field1697 = new int[this.field1712];
      this.field1713 = new int[this.field1712];
      this.field1691 = new int[this.field1712];
      this.field1715 = new int[this.field1712];
      this.field1693 = new int[this.field1690];
      this.field1694 = new int[this.field1690];
      this.field1695 = new int[this.field1690];
      if(var3) {
         this.field1696 = new byte[this.field1690];
      }

      if(var4) {
         this.field1721 = new byte[this.field1690];
      }

      if(var5) {
         this.field1698 = new byte[this.field1690];
      }

      if(var6) {
         this.field1716 = new int[this.field1690];
      }

      if(var7) {
         this.field1701 = new short[this.field1690];
      }

      if(var8) {
         this.field1699 = new byte[this.field1690];
      }

      this.field1700 = new short[this.field1690];
      if(this.field1714 > 0) {
         this.field1718 = new byte[this.field1714];
         this.field1705 = new short[this.field1714];
         this.field1706 = new short[this.field1714];
         this.field1707 = new short[this.field1714];
         this.field1708 = new short[this.field1714];
         this.field1692 = new short[this.field1714];
         this.field1710 = new short[this.field1714];
         this.field1711 = new short[this.field1714];
         this.field1704 = new byte[this.field1714];
         this.field1689 = new short[this.field1714];
         this.field1703 = new short[this.field1714];
      }

      this.field1712 = 0;
      this.field1690 = 0;
      this.field1714 = 0;

      for(var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if(var10 != null) {
            int var11;
            for(var11 = 0; var11 < var10.field1690; ++var11) {
               if(var3 && var10.field1696 != null) {
                  this.field1696[this.field1690] = var10.field1696[var11];
               }

               if(var4) {
                  if(var10.field1721 != null) {
                     this.field1721[this.field1690] = var10.field1721[var11];
                  } else {
                     this.field1721[this.field1690] = var10.field1723;
                  }
               }

               if(var5 && var10.field1698 != null) {
                  this.field1698[this.field1690] = var10.field1698[var11];
               }

               if(var6 && var10.field1716 != null) {
                  this.field1716[this.field1690] = var10.field1716[var11];
               }

               if(var7) {
                  if(var10.field1701 != null) {
                     this.field1701[this.field1690] = var10.field1701[var11];
                  } else {
                     this.field1701[this.field1690] = -1;
                  }
               }

               if(var8) {
                  if(var10.field1699 != null && var10.field1699[var11] != -1) {
                     this.field1699[this.field1690] = (byte)(var10.field1699[var11] + this.field1714);
                  } else {
                     this.field1699[this.field1690] = -1;
                  }
               }

               this.field1700[this.field1690] = var10.field1700[var11];
               this.field1693[this.field1690] = this.method2274(var10, var10.field1693[var11]);
               this.field1694[this.field1690] = this.method2274(var10, var10.field1694[var11]);
               this.field1695[this.field1690] = this.method2274(var10, var10.field1695[var11]);
               ++this.field1690;
            }

            for(var11 = 0; var11 < var10.field1714; ++var11) {
               byte var12 = this.field1718[this.field1714] = var10.field1718[var11];
               if(var12 == 0) {
                  this.field1705[this.field1714] = (short)this.method2274(var10, var10.field1705[var11]);
                  this.field1706[this.field1714] = (short)this.method2274(var10, var10.field1706[var11]);
                  this.field1707[this.field1714] = (short)this.method2274(var10, var10.field1707[var11]);
               }

               if(var12 >= 1 && var12 <= 3) {
                  this.field1705[this.field1714] = var10.field1705[var11];
                  this.field1706[this.field1714] = var10.field1706[var11];
                  this.field1707[this.field1714] = var10.field1707[var11];
                  this.field1708[this.field1714] = var10.field1708[var11];
                  this.field1692[this.field1714] = var10.field1692[var11];
                  this.field1710[this.field1714] = var10.field1710[var11];
                  this.field1711[this.field1714] = var10.field1711[var11];
                  this.field1704[this.field1714] = var10.field1704[var11];
                  this.field1689[this.field1714] = var10.field1689[var11];
               }

               if(var12 == 2) {
                  this.field1703[this.field1714] = var10.field1703[var11];
               }

               ++this.field1714;
            }
         }
      }

   }

   @ObfuscatedName("h")
   public void method2336(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1712; ++var4) {
         this.field1697[var4] += var1;
         this.field1713[var4] += var2;
         this.field1691[var4] += var3;
      }

      this.method2287();
   }

   @ObfuscatedName("e")
   public void method2341(short var1, short var2) {
      for(int var3 = 0; var3 < this.field1690; ++var3) {
         if(this.field1700[var3] == var1) {
            this.field1700[var3] = var2;
         }
      }

   }
}
