import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
public class class99 extends class84 {
   @ObfuscatedName("r")
   int[] field1677;
   @ObfuscatedName("v")
   short[] field1678;
   @ObfuscatedName("f")
   int[] field1679;
   @ObfuscatedName("s")
   int[] field1680;
   @ObfuscatedName("d")
   short[] field1681;
   @ObfuscatedName("e")
   int[] field1682;
   @ObfuscatedName("aw")
   int[] field1683;
   @ObfuscatedName("at")
   int[] field1684;
   @ObfuscatedName("c")
   short[] field1685;
   @ObfuscatedName("n")
   byte[] field1686;
   @ObfuscatedName("l")
   byte[] field1687;
   @ObfuscatedName("h")
   byte[] field1688;
   @ObfuscatedName("i")
   short[] field1689;
   @ObfuscatedName("ar")
   int field1690;
   @ObfuscatedName("aj")
   static int field1691 = 0;
   @ObfuscatedName("u")
   int field1692;
   @ObfuscatedName("t")
   byte[] field1693;
   @ObfuscatedName("b")
   short[] field1694;
   @ObfuscatedName("ax")
   int[][] field1695;
   @ObfuscatedName("x")
   short[] field1696;
   @ObfuscatedName("ai")
   boolean field1697 = false;
   @ObfuscatedName("p")
   short[] field1698;
   @ObfuscatedName("q")
   short[] field1699;
   @ObfuscatedName("w")
   short[] field1700;
   @ObfuscatedName("k")
   short[] field1701;
   @ObfuscatedName("o")
   short[] field1702;
   @ObfuscatedName("ad")
   byte[] field1703;
   @ObfuscatedName("j")
   byte[] field1704;
   @ObfuscatedName("m")
   int[] field1705;
   @ObfuscatedName("y")
   int field1706 = 0;
   @ObfuscatedName("ak")
   int[][] field1707;
   @ObfuscatedName("an")
   static int[] field1708 = new int[10000];
   @ObfuscatedName("ac")
   class95[] field1709;
   @ObfuscatedName("as")
   class95[] field1710;
   @ObfuscatedName("ao")
   public short field1711;
   @ObfuscatedName("am")
   public short field1712;
   @ObfuscatedName("g")
   int[] field1713;
   @ObfuscatedName("ab")
   int field1714;
   @ObfuscatedName("al")
   int field1715;
   @ObfuscatedName("ag")
   int field1716;
   @ObfuscatedName("aa")
   int field1717;
   @ObfuscatedName("ah")
   class83[] field1718;
   @ObfuscatedName("a")
   int field1719 = 0;
   @ObfuscatedName("av")
   static int[] field1720 = new int[10000];
   @ObfuscatedName("z")
   byte field1721 = 0;
   @ObfuscatedName("ap")
   static int[] field1722;
   @ObfuscatedName("aq")
   static int[] field1723;

   @ObfuscatedName("p")
   void method2218() {
      this.field1709 = null;
      this.field1710 = null;
      this.field1718 = null;
      this.field1697 = false;
   }

   @ObfuscatedName("a")
   public static class99 method2219(class166 var0, int var1, int var2) {
      byte[] var3 = var0.method3263(var1, var2);
      return var3 == null?null:new class99(var3);
   }

   class99(byte[] var1) {
      if(var1[var1.length - 1] == -1 && var1[var1.length - 2] == -1) {
         this.method2220(var1);
      } else {
         this.method2221(var1);
      }

   }

   @ObfuscatedName("r")
   void method2220(byte[] var1) {
      class118 var2 = new class118(var1);
      class118 var3 = new class118(var1);
      class118 var4 = new class118(var1);
      class118 var5 = new class118(var1);
      class118 var6 = new class118(var1);
      class118 var7 = new class118(var1);
      class118 var8 = new class118(var1);
      var2.field1979 = var1.length - 23;
      int var9 = var2.method2514();
      int var10 = var2.method2514();
      int var11 = var2.method2579();
      int var12 = var2.method2579();
      int var13 = var2.method2579();
      int var14 = var2.method2579();
      int var15 = var2.method2579();
      int var16 = var2.method2579();
      int var17 = var2.method2579();
      int var18 = var2.method2514();
      int var19 = var2.method2514();
      int var20 = var2.method2514();
      int var21 = var2.method2514();
      int var22 = var2.method2514();
      int var23 = 0;
      int var24 = 0;
      int var25 = 0;
      int var26;
      if(var11 > 0) {
         this.field1693 = new byte[var11];
         var2.field1979 = 0;

         for(var26 = 0; var26 < var11; ++var26) {
            byte var27 = this.field1693[var26] = var2.method2707();
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
      this.field1719 = var9;
      this.field1706 = var10;
      this.field1692 = var11;
      this.field1677 = new int[var9];
      this.field1679 = new int[var9];
      this.field1680 = new int[var9];
      this.field1682 = new int[var10];
      this.field1713 = new int[var10];
      this.field1705 = new int[var10];
      if(var17 == 1) {
         this.field1684 = new int[var9];
      }

      if(var12 == 1) {
         this.field1704 = new byte[var10];
      }

      if(var13 == 255) {
         this.field1686 = new byte[var10];
      } else {
         this.field1721 = (byte)var13;
      }

      if(var14 == 1) {
         this.field1687 = new byte[var10];
      }

      if(var15 == 1) {
         this.field1683 = new int[var10];
      }

      if(var16 == 1) {
         this.field1678 = new short[var10];
      }

      if(var16 == 1 && var11 > 0) {
         this.field1688 = new byte[var10];
      }

      this.field1689 = new short[var10];
      if(var11 > 0) {
         this.field1694 = new short[var11];
         this.field1685 = new short[var11];
         this.field1696 = new short[var11];
         if(var24 > 0) {
            this.field1681 = new short[var24];
            this.field1698 = new short[var24];
            this.field1699 = new short[var24];
            this.field1700 = new short[var24];
            this.field1703 = new byte[var24];
            this.field1701 = new short[var24];
         }

         if(var25 > 0) {
            this.field1702 = new short[var25];
         }
      }

      var2.field1979 = var11;
      var3.field1979 = var38;
      var4.field1979 = var39;
      var5.field1979 = var40;
      var6.field1979 = var32;
      int var48 = 0;
      int var49 = 0;
      int var50 = 0;

      int var51;
      int var52;
      int var53;
      int var54;
      int var55;
      for(var51 = 0; var51 < var9; ++var51) {
         var52 = var2.method2579();
         var53 = 0;
         if((var52 & 1) != 0) {
            var53 = var3.method2524();
         }

         var54 = 0;
         if((var52 & 2) != 0) {
            var54 = var4.method2524();
         }

         var55 = 0;
         if((var52 & 4) != 0) {
            var55 = var5.method2524();
         }

         this.field1677[var51] = var48 + var53;
         this.field1679[var51] = var49 + var54;
         this.field1680[var51] = var50 + var55;
         var48 = this.field1677[var51];
         var49 = this.field1679[var51];
         var50 = this.field1680[var51];
         if(var17 == 1) {
            this.field1684[var51] = var6.method2579();
         }
      }

      var2.field1979 = var37;
      var3.field1979 = var28;
      var4.field1979 = var30;
      var5.field1979 = var33;
      var6.field1979 = var31;
      var7.field1979 = var35;
      var8.field1979 = var36;

      for(var51 = 0; var51 < var10; ++var51) {
         this.field1689[var51] = (short)var2.method2514();
         if(var12 == 1) {
            this.field1704[var51] = var3.method2707();
         }

         if(var13 == 255) {
            this.field1686[var51] = var4.method2707();
         }

         if(var14 == 1) {
            this.field1687[var51] = var5.method2707();
         }

         if(var15 == 1) {
            this.field1683[var51] = var6.method2579();
         }

         if(var16 == 1) {
            this.field1678[var51] = (short)(var7.method2514() - 1);
         }

         if(this.field1688 != null && this.field1678[var51] != -1) {
            this.field1688[var51] = (byte)(var8.method2579() - 1);
         }
      }

      var2.field1979 = var34;
      var3.field1979 = var29;
      var51 = 0;
      var52 = 0;
      var53 = 0;
      var54 = 0;

      int var56;
      for(var55 = 0; var55 < var10; ++var55) {
         var56 = var3.method2579();
         if(var56 == 1) {
            var51 = var2.method2524() + var54;
            var52 = var2.method2524() + var51;
            var53 = var2.method2524() + var52;
            var54 = var53;
            this.field1682[var55] = var51;
            this.field1713[var55] = var52;
            this.field1705[var55] = var53;
         }

         if(var56 == 2) {
            var52 = var53;
            var53 = var2.method2524() + var54;
            var54 = var53;
            this.field1682[var55] = var51;
            this.field1713[var55] = var52;
            this.field1705[var55] = var53;
         }

         if(var56 == 3) {
            var51 = var53;
            var53 = var2.method2524() + var54;
            var54 = var53;
            this.field1682[var55] = var51;
            this.field1713[var55] = var52;
            this.field1705[var55] = var53;
         }

         if(var56 == 4) {
            int var57 = var51;
            var51 = var52;
            var52 = var57;
            var53 = var2.method2524() + var54;
            var54 = var53;
            this.field1682[var55] = var51;
            this.field1713[var55] = var57;
            this.field1705[var55] = var53;
         }
      }

      var2.field1979 = var41;
      var3.field1979 = var42;
      var4.field1979 = var43;
      var5.field1979 = var44;
      var6.field1979 = var45;
      var7.field1979 = var46;

      for(var55 = 0; var55 < var11; ++var55) {
         var56 = this.field1693[var55] & 255;
         if(var56 == 0) {
            this.field1694[var55] = (short)var2.method2514();
            this.field1685[var55] = (short)var2.method2514();
            this.field1696[var55] = (short)var2.method2514();
         }

         if(var56 == 1) {
            this.field1694[var55] = (short)var3.method2514();
            this.field1685[var55] = (short)var3.method2514();
            this.field1696[var55] = (short)var3.method2514();
            this.field1681[var55] = (short)var4.method2514();
            this.field1698[var55] = (short)var4.method2514();
            this.field1699[var55] = (short)var4.method2514();
            this.field1700[var55] = (short)var5.method2514();
            this.field1703[var55] = var6.method2707();
            this.field1701[var55] = (short)var7.method2514();
         }

         if(var56 == 2) {
            this.field1694[var55] = (short)var3.method2514();
            this.field1685[var55] = (short)var3.method2514();
            this.field1696[var55] = (short)var3.method2514();
            this.field1681[var55] = (short)var4.method2514();
            this.field1698[var55] = (short)var4.method2514();
            this.field1699[var55] = (short)var4.method2514();
            this.field1700[var55] = (short)var5.method2514();
            this.field1703[var55] = var6.method2707();
            this.field1701[var55] = (short)var7.method2514();
            this.field1702[var55] = (short)var7.method2514();
         }

         if(var56 == 3) {
            this.field1694[var55] = (short)var3.method2514();
            this.field1685[var55] = (short)var3.method2514();
            this.field1696[var55] = (short)var3.method2514();
            this.field1681[var55] = (short)var4.method2514();
            this.field1698[var55] = (short)var4.method2514();
            this.field1699[var55] = (short)var4.method2514();
            this.field1700[var55] = (short)var5.method2514();
            this.field1703[var55] = var6.method2707();
            this.field1701[var55] = (short)var7.method2514();
         }
      }

      var2.field1979 = var26;
      var55 = var2.method2579();
      if(var55 != 0) {
         new class89();
         var2.method2514();
         var2.method2514();
         var2.method2514();
         var2.method2517();
      }

   }

   @ObfuscatedName("s")
   void method2221(byte[] var1) {
      boolean var2 = false;
      boolean var3 = false;
      class118 var4 = new class118(var1);
      class118 var5 = new class118(var1);
      class118 var6 = new class118(var1);
      class118 var7 = new class118(var1);
      class118 var8 = new class118(var1);
      var4.field1979 = var1.length - 18;
      int var9 = var4.method2514();
      int var10 = var4.method2514();
      int var11 = var4.method2579();
      int var12 = var4.method2579();
      int var13 = var4.method2579();
      int var14 = var4.method2579();
      int var15 = var4.method2579();
      int var16 = var4.method2579();
      int var17 = var4.method2514();
      int var18 = var4.method2514();
      int var19 = var4.method2514();
      int var20 = var4.method2514();
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
      this.field1719 = var9;
      this.field1706 = var10;
      this.field1692 = var11;
      this.field1677 = new int[var9];
      this.field1679 = new int[var9];
      this.field1680 = new int[var9];
      this.field1682 = new int[var10];
      this.field1713 = new int[var10];
      this.field1705 = new int[var10];
      if(var11 > 0) {
         this.field1693 = new byte[var11];
         this.field1694 = new short[var11];
         this.field1685 = new short[var11];
         this.field1696 = new short[var11];
      }

      if(var16 == 1) {
         this.field1684 = new int[var9];
      }

      if(var12 == 1) {
         this.field1704 = new byte[var10];
         this.field1688 = new byte[var10];
         this.field1678 = new short[var10];
      }

      if(var13 == 255) {
         this.field1686 = new byte[var10];
      } else {
         this.field1721 = (byte)var13;
      }

      if(var14 == 1) {
         this.field1687 = new byte[var10];
      }

      if(var15 == 1) {
         this.field1683 = new int[var10];
      }

      this.field1689 = new short[var10];
      var4.field1979 = var21;
      var5.field1979 = var32;
      var6.field1979 = var33;
      var7.field1979 = var45;
      var8.field1979 = var27;
      int var35 = 0;
      int var36 = 0;
      int var37 = 0;

      int var38;
      int var39;
      int var40;
      int var41;
      int var42;
      for(var38 = 0; var38 < var9; ++var38) {
         var39 = var4.method2579();
         var40 = 0;
         if((var39 & 1) != 0) {
            var40 = var5.method2524();
         }

         var41 = 0;
         if((var39 & 2) != 0) {
            var41 = var6.method2524();
         }

         var42 = 0;
         if((var39 & 4) != 0) {
            var42 = var7.method2524();
         }

         this.field1677[var38] = var35 + var40;
         this.field1679[var38] = var36 + var41;
         this.field1680[var38] = var37 + var42;
         var35 = this.field1677[var38];
         var36 = this.field1679[var38];
         var37 = this.field1680[var38];
         if(var16 == 1) {
            this.field1684[var38] = var8.method2579();
         }
      }

      var4.field1979 = var30;
      var5.field1979 = var26;
      var6.field1979 = var24;
      var7.field1979 = var28;
      var8.field1979 = var25;

      for(var38 = 0; var38 < var10; ++var38) {
         this.field1689[var38] = (short)var4.method2514();
         if(var12 == 1) {
            var39 = var5.method2579();
            if((var39 & 1) == 1) {
               this.field1704[var38] = 1;
               var2 = true;
            } else {
               this.field1704[var38] = 0;
            }

            if((var39 & 2) == 2) {
               this.field1688[var38] = (byte)(var39 >> 2);
               this.field1678[var38] = this.field1689[var38];
               this.field1689[var38] = 127;
               if(this.field1678[var38] != -1) {
                  var3 = true;
               }
            } else {
               this.field1688[var38] = -1;
               this.field1678[var38] = -1;
            }
         }

         if(var13 == 255) {
            this.field1686[var38] = var6.method2707();
         }

         if(var14 == 1) {
            this.field1687[var38] = var7.method2707();
         }

         if(var15 == 1) {
            this.field1683[var38] = var8.method2579();
         }
      }

      var4.field1979 = var29;
      var5.field1979 = var23;
      var38 = 0;
      var39 = 0;
      var40 = 0;
      var41 = 0;

      int var43;
      int var44;
      for(var42 = 0; var42 < var10; ++var42) {
         var43 = var5.method2579();
         if(var43 == 1) {
            var38 = var4.method2524() + var41;
            var39 = var4.method2524() + var38;
            var40 = var4.method2524() + var39;
            var41 = var40;
            this.field1682[var42] = var38;
            this.field1713[var42] = var39;
            this.field1705[var42] = var40;
         }

         if(var43 == 2) {
            var39 = var40;
            var40 = var4.method2524() + var41;
            var41 = var40;
            this.field1682[var42] = var38;
            this.field1713[var42] = var39;
            this.field1705[var42] = var40;
         }

         if(var43 == 3) {
            var38 = var40;
            var40 = var4.method2524() + var41;
            var41 = var40;
            this.field1682[var42] = var38;
            this.field1713[var42] = var39;
            this.field1705[var42] = var40;
         }

         if(var43 == 4) {
            var44 = var38;
            var38 = var39;
            var39 = var44;
            var40 = var4.method2524() + var41;
            var41 = var40;
            this.field1682[var42] = var38;
            this.field1713[var42] = var44;
            this.field1705[var42] = var40;
         }
      }

      var4.field1979 = var31;

      for(var42 = 0; var42 < var11; ++var42) {
         this.field1693[var42] = 0;
         this.field1694[var42] = (short)var4.method2514();
         this.field1685[var42] = (short)var4.method2514();
         this.field1696[var42] = (short)var4.method2514();
      }

      if(this.field1688 != null) {
         boolean var46 = false;

         for(var43 = 0; var43 < var10; ++var43) {
            var44 = this.field1688[var43] & 255;
            if(var44 != 255) {
               if((this.field1694[var44] & '\uffff') == this.field1682[var43] && (this.field1685[var44] & '\uffff') == this.field1713[var43] && (this.field1696[var44] & '\uffff') == this.field1705[var43]) {
                  this.field1688[var43] = -1;
               } else {
                  var46 = true;
               }
            }
         }

         if(!var46) {
            this.field1688 = null;
         }
      }

      if(!var3) {
         this.field1678 = null;
      }

      if(!var2) {
         this.field1704 = null;
      }

   }

   public class99(class99[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      boolean var8 = false;
      this.field1719 = 0;
      this.field1706 = 0;
      this.field1692 = 0;
      this.field1721 = -1;

      int var9;
      class99 var10;
      for(var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if(var10 != null) {
            this.field1719 += var10.field1719;
            this.field1706 += var10.field1706;
            this.field1692 += var10.field1692;
            if(var10.field1686 != null) {
               var4 = true;
            } else {
               if(this.field1721 == -1) {
                  this.field1721 = var10.field1721;
               }

               if(this.field1721 != var10.field1721) {
                  var4 = true;
               }
            }

            var3 |= var10.field1704 != null;
            var5 |= var10.field1687 != null;
            var6 |= var10.field1683 != null;
            var7 |= var10.field1678 != null;
            var8 |= var10.field1688 != null;
         }
      }

      this.field1677 = new int[this.field1719];
      this.field1679 = new int[this.field1719];
      this.field1680 = new int[this.field1719];
      this.field1684 = new int[this.field1719];
      this.field1682 = new int[this.field1706];
      this.field1713 = new int[this.field1706];
      this.field1705 = new int[this.field1706];
      if(var3) {
         this.field1704 = new byte[this.field1706];
      }

      if(var4) {
         this.field1686 = new byte[this.field1706];
      }

      if(var5) {
         this.field1687 = new byte[this.field1706];
      }

      if(var6) {
         this.field1683 = new int[this.field1706];
      }

      if(var7) {
         this.field1678 = new short[this.field1706];
      }

      if(var8) {
         this.field1688 = new byte[this.field1706];
      }

      this.field1689 = new short[this.field1706];
      if(this.field1692 > 0) {
         this.field1693 = new byte[this.field1692];
         this.field1694 = new short[this.field1692];
         this.field1685 = new short[this.field1692];
         this.field1696 = new short[this.field1692];
         this.field1681 = new short[this.field1692];
         this.field1698 = new short[this.field1692];
         this.field1699 = new short[this.field1692];
         this.field1700 = new short[this.field1692];
         this.field1703 = new byte[this.field1692];
         this.field1701 = new short[this.field1692];
         this.field1702 = new short[this.field1692];
      }

      this.field1719 = 0;
      this.field1706 = 0;
      this.field1692 = 0;

      for(var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if(var10 != null) {
            int var11;
            for(var11 = 0; var11 < var10.field1706; ++var11) {
               if(var3 && var10.field1704 != null) {
                  this.field1704[this.field1706] = var10.field1704[var11];
               }

               if(var4) {
                  if(var10.field1686 != null) {
                     this.field1686[this.field1706] = var10.field1686[var11];
                  } else {
                     this.field1686[this.field1706] = var10.field1721;
                  }
               }

               if(var5 && var10.field1687 != null) {
                  this.field1687[this.field1706] = var10.field1687[var11];
               }

               if(var6 && var10.field1683 != null) {
                  this.field1683[this.field1706] = var10.field1683[var11];
               }

               if(var7) {
                  if(var10.field1678 != null) {
                     this.field1678[this.field1706] = var10.field1678[var11];
                  } else {
                     this.field1678[this.field1706] = -1;
                  }
               }

               if(var8) {
                  if(var10.field1688 != null && var10.field1688[var11] != -1) {
                     this.field1688[this.field1706] = (byte)(var10.field1688[var11] + this.field1692);
                  } else {
                     this.field1688[this.field1706] = -1;
                  }
               }

               this.field1689[this.field1706] = var10.field1689[var11];
               this.field1682[this.field1706] = this.method2247(var10, var10.field1682[var11]);
               this.field1713[this.field1706] = this.method2247(var10, var10.field1713[var11]);
               this.field1705[this.field1706] = this.method2247(var10, var10.field1705[var11]);
               ++this.field1706;
            }

            for(var11 = 0; var11 < var10.field1692; ++var11) {
               byte var12 = this.field1693[this.field1692] = var10.field1693[var11];
               if(var12 == 0) {
                  this.field1694[this.field1692] = (short)this.method2247(var10, var10.field1694[var11]);
                  this.field1685[this.field1692] = (short)this.method2247(var10, var10.field1685[var11]);
                  this.field1696[this.field1692] = (short)this.method2247(var10, var10.field1696[var11]);
               }

               if(var12 >= 1 && var12 <= 3) {
                  this.field1694[this.field1692] = var10.field1694[var11];
                  this.field1685[this.field1692] = var10.field1685[var11];
                  this.field1696[this.field1692] = var10.field1696[var11];
                  this.field1681[this.field1692] = var10.field1681[var11];
                  this.field1698[this.field1692] = var10.field1698[var11];
                  this.field1699[this.field1692] = var10.field1699[var11];
                  this.field1700[this.field1692] = var10.field1700[var11];
                  this.field1703[this.field1692] = var10.field1703[var11];
                  this.field1701[this.field1692] = var10.field1701[var11];
               }

               if(var12 == 2) {
                  this.field1702[this.field1692] = var10.field1702[var11];
               }

               ++this.field1692;
            }
         }
      }

   }

   static {
      field1722 = class90.field1572;
      field1723 = class90.field1578;
   }

   @ObfuscatedName("e")
   public class99 method2223() {
      class99 var1 = new class99();
      if(this.field1704 != null) {
         var1.field1704 = new byte[this.field1706];

         for(int var2 = 0; var2 < this.field1706; ++var2) {
            var1.field1704[var2] = this.field1704[var2];
         }
      }

      var1.field1719 = this.field1719;
      var1.field1706 = this.field1706;
      var1.field1692 = this.field1692;
      var1.field1677 = this.field1677;
      var1.field1679 = this.field1679;
      var1.field1680 = this.field1680;
      var1.field1682 = this.field1682;
      var1.field1713 = this.field1713;
      var1.field1705 = this.field1705;
      var1.field1686 = this.field1686;
      var1.field1687 = this.field1687;
      var1.field1688 = this.field1688;
      var1.field1689 = this.field1689;
      var1.field1678 = this.field1678;
      var1.field1721 = this.field1721;
      var1.field1693 = this.field1693;
      var1.field1694 = this.field1694;
      var1.field1685 = this.field1685;
      var1.field1696 = this.field1696;
      var1.field1681 = this.field1681;
      var1.field1698 = this.field1698;
      var1.field1699 = this.field1699;
      var1.field1700 = this.field1700;
      var1.field1703 = this.field1703;
      var1.field1701 = this.field1701;
      var1.field1702 = this.field1702;
      var1.field1684 = this.field1684;
      var1.field1683 = this.field1683;
      var1.field1695 = this.field1695;
      var1.field1707 = this.field1707;
      var1.field1709 = this.field1709;
      var1.field1718 = this.field1718;
      var1.field1711 = this.field1711;
      var1.field1712 = this.field1712;
      return var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([[IIIIZI)Lclass99;",
      garbageValue = "1"
   )
   public class99 method2224(int[][] var1, int var2, int var3, int var4, int var5) {
      this.method2237();
      int var6 = var2 + this.field1715;
      int var7 = var2 + this.field1690;
      int var8 = var4 + this.field1716;
      int var9 = var4 + this.field1717;
      if(var6 >= 0 && var7 + 128 >> 7 < var1.length && var8 >= 0 && var9 + 128 >> 7 < var1[0].length) {
         var6 >>= 7;
         var7 = var7 + 127 >> 7;
         var8 >>= 7;
         var9 = var9 + 127 >> 7;
         if(var1[var6][var8] == var3 && var1[var7][var8] == var3 && var1[var6][var9] == var3 && var1[var7][var9] == var3) {
            return this;
         } else {
            class99 var10 = new class99();
            var10.field1719 = this.field1719;
            var10.field1706 = this.field1706;
            var10.field1692 = this.field1692;
            var10.field1677 = this.field1677;
            var10.field1680 = this.field1680;
            var10.field1682 = this.field1682;
            var10.field1713 = this.field1713;
            var10.field1705 = this.field1705;
            var10.field1704 = this.field1704;
            var10.field1686 = this.field1686;
            var10.field1687 = this.field1687;
            var10.field1688 = this.field1688;
            var10.field1689 = this.field1689;
            var10.field1678 = this.field1678;
            var10.field1721 = this.field1721;
            var10.field1693 = this.field1693;
            var10.field1694 = this.field1694;
            var10.field1685 = this.field1685;
            var10.field1696 = this.field1696;
            var10.field1681 = this.field1681;
            var10.field1698 = this.field1698;
            var10.field1699 = this.field1699;
            var10.field1700 = this.field1700;
            var10.field1703 = this.field1703;
            var10.field1701 = this.field1701;
            var10.field1702 = this.field1702;
            var10.field1684 = this.field1684;
            var10.field1683 = this.field1683;
            var10.field1695 = this.field1695;
            var10.field1707 = this.field1707;
            var10.field1711 = this.field1711;
            var10.field1712 = this.field1712;
            var10.field1679 = new int[var10.field1719];
            int var11;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            int var20;
            if(var5 == 0) {
               for(var11 = 0; var11 < var10.field1719; ++var11) {
                  var12 = this.field1677[var11] + var2;
                  var13 = this.field1680[var11] + var4;
                  var14 = var12 & 127;
                  var15 = var13 & 127;
                  var16 = var12 >> 7;
                  var17 = var13 >> 7;
                  var18 = var1[var16][var17] * (128 - var14) + var1[var16 + 1][var17] * var14 >> 7;
                  var19 = var1[var16][var17 + 1] * (128 - var14) + var1[var16 + 1][var17 + 1] * var14 >> 7;
                  var20 = var18 * (128 - var15) + var19 * var15 >> 7;
                  var10.field1679[var11] = this.field1679[var11] + var20 - var3;
               }
            } else {
               for(var11 = 0; var11 < var10.field1719; ++var11) {
                  var12 = (-this.field1679[var11] << 16) / super.field1448;
                  if(var12 < var5) {
                     var13 = this.field1677[var11] + var2;
                     var14 = this.field1680[var11] + var4;
                     var15 = var13 & 127;
                     var16 = var14 & 127;
                     var17 = var13 >> 7;
                     var18 = var14 >> 7;
                     var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                     var20 = var1[var17][var18 + 1] * (128 - var15) + var1[var17 + 1][var18 + 1] * var15 >> 7;
                     int var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                     var10.field1679[var11] = this.field1679[var11] + (var21 - var3) * (var5 - var12) / var5;
                  }
               }
            }

            var10.method2218();
            return var10;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("m")
   void method2225() {
      int[] var1;
      int var2;
      int var3;
      int var4;
      if(this.field1684 != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.field1719; ++var3) {
            var4 = this.field1684[var3];
            ++var1[var4];
            if(var4 > var2) {
               var2 = var4;
            }
         }

         this.field1695 = new int[var2 + 1][];

         for(var3 = 0; var3 <= var2; ++var3) {
            this.field1695[var3] = new int[var1[var3]];
            var1[var3] = 0;
         }

         for(var3 = 0; var3 < this.field1719; this.field1695[var4][var1[var4]++] = var3++) {
            var4 = this.field1684[var3];
         }

         this.field1684 = null;
      }

      if(this.field1683 != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.field1706; ++var3) {
            var4 = this.field1683[var3];
            ++var1[var4];
            if(var4 > var2) {
               var2 = var4;
            }
         }

         this.field1707 = new int[var2 + 1][];

         for(var3 = 0; var3 <= var2; ++var3) {
            this.field1707[var3] = new int[var1[var3]];
            var1[var3] = 0;
         }

         for(var3 = 0; var3 < this.field1706; this.field1707[var4][var1[var4]++] = var3++) {
            var4 = this.field1683[var3];
         }

         this.field1683 = null;
      }

   }

   @ObfuscatedName("h")
   public void method2229(int var1) {
      int var2 = field1722[var1];
      int var3 = field1723[var1];

      for(int var4 = 0; var4 < this.field1719; ++var4) {
         int var5 = this.field1680[var4] * var2 + this.field1677[var4] * var3 >> 16;
         this.field1680[var4] = this.field1680[var4] * var3 - this.field1677[var4] * var2 >> 16;
         this.field1677[var4] = var5;
      }

      this.method2218();
   }

   @ObfuscatedName("n")
   public void method2233() {
      for(int var1 = 0; var1 < this.field1719; ++var1) {
         this.field1677[var1] = -this.field1677[var1];
         this.field1680[var1] = -this.field1680[var1];
      }

      this.method2218();
   }

   @ObfuscatedName("x")
   public void method2234(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1719; ++var4) {
         this.field1677[var4] = this.field1677[var4] * var1 / 128;
         this.field1679[var4] = this.field1679[var4] * var2 / 128;
         this.field1680[var4] = this.field1680[var4] * var3 / 128;
      }

      this.method2218();
   }

   @ObfuscatedName("d")
   public void method2235() {
      if(this.field1709 == null) {
         this.field1709 = new class95[this.field1719];

         int var1;
         for(var1 = 0; var1 < this.field1719; ++var1) {
            this.field1709[var1] = new class95();
         }

         for(var1 = 0; var1 < this.field1706; ++var1) {
            int var2 = this.field1682[var1];
            int var3 = this.field1713[var1];
            int var4 = this.field1705[var1];
            int var5 = this.field1677[var3] - this.field1677[var2];
            int var6 = this.field1679[var3] - this.field1679[var2];
            int var7 = this.field1680[var3] - this.field1680[var2];
            int var8 = this.field1677[var4] - this.field1677[var2];
            int var9 = this.field1679[var4] - this.field1679[var2];
            int var10 = this.field1680[var4] - this.field1680[var2];
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
               class95 var16 = this.field1709[var2];
               var16.field1617 += var11;
               var16.field1622 += var12;
               var16.field1620 += var13;
               ++var16.field1618;
               var16 = this.field1709[var3];
               var16.field1617 += var11;
               var16.field1622 += var12;
               var16.field1620 += var13;
               ++var16.field1618;
               var16 = this.field1709[var4];
               var16.field1617 += var11;
               var16.field1622 += var12;
               var16.field1620 += var13;
               ++var16.field1618;
            } else if(var15 == 1) {
               if(this.field1718 == null) {
                  this.field1718 = new class83[this.field1706];
               }

               class83 var17 = this.field1718[var1] = new class83();
               var17.field1446 = var11;
               var17.field1445 = var12;
               var17.field1447 = var13;
            }
         }

      }
   }

   @ObfuscatedName("q")
   void method2237() {
      if(!this.field1697) {
         super.field1448 = 0;
         this.field1714 = 0;
         this.field1715 = 999999;
         this.field1690 = -999999;
         this.field1717 = -99999;
         this.field1716 = 99999;

         for(int var1 = 0; var1 < this.field1719; ++var1) {
            int var2 = this.field1677[var1];
            int var3 = this.field1679[var1];
            int var4 = this.field1680[var1];
            if(var2 < this.field1715) {
               this.field1715 = var2;
            }

            if(var2 > this.field1690) {
               this.field1690 = var2;
            }

            if(var4 < this.field1716) {
               this.field1716 = var4;
            }

            if(var4 > this.field1717) {
               this.field1717 = var4;
            }

            if(-var3 > super.field1448) {
               super.field1448 = -var3;
            }

            if(var3 > this.field1714) {
               this.field1714 = var3;
            }
         }

         this.field1697 = true;
      }
   }

   @ObfuscatedName("w")
   static void method2238(class99 var0, class99 var1, int var2, int var3, int var4, boolean var5) {
      var0.method2237();
      var0.method2235();
      var1.method2237();
      var1.method2235();
      ++field1691;
      int var6 = 0;
      int[] var7 = var1.field1677;
      int var8 = var1.field1719;

      int var9;
      for(var9 = 0; var9 < var0.field1719; ++var9) {
         class95 var10 = var0.field1709[var9];
         if(var10.field1618 != 0) {
            int var11 = var0.field1679[var9] - var3;
            if(var11 <= var1.field1714) {
               int var12 = var0.field1677[var9] - var2;
               if(var12 >= var1.field1715 && var12 <= var1.field1690) {
                  int var13 = var0.field1680[var9] - var4;
                  if(var13 >= var1.field1716 && var13 <= var1.field1717) {
                     for(int var14 = 0; var14 < var8; ++var14) {
                        class95 var15 = var1.field1709[var14];
                        if(var12 == var7[var14] && var13 == var1.field1680[var14] && var11 == var1.field1679[var14] && var15.field1618 != 0) {
                           if(var0.field1710 == null) {
                              var0.field1710 = new class95[var0.field1719];
                           }

                           if(var1.field1710 == null) {
                              var1.field1710 = new class95[var8];
                           }

                           class95 var16 = var0.field1710[var9];
                           if(var16 == null) {
                              var16 = var0.field1710[var9] = new class95(var10);
                           }

                           class95 var17 = var1.field1710[var14];
                           if(var17 == null) {
                              var17 = var1.field1710[var14] = new class95(var15);
                           }

                           var16.field1617 += var15.field1617;
                           var16.field1622 += var15.field1622;
                           var16.field1620 += var15.field1620;
                           var16.field1618 += var15.field1618;
                           var17.field1617 += var10.field1617;
                           var17.field1622 += var10.field1622;
                           var17.field1620 += var10.field1620;
                           var17.field1618 += var10.field1618;
                           ++var6;
                           field1708[var9] = field1691;
                           field1720[var14] = field1691;
                        }
                     }
                  }
               }
            }
         }
      }

      if(var6 >= 3 && var5) {
         for(var9 = 0; var9 < var0.field1706; ++var9) {
            if(field1708[var0.field1682[var9]] == field1691 && field1708[var0.field1713[var9]] == field1691 && field1708[var0.field1705[var9]] == field1691) {
               if(var0.field1704 == null) {
                  var0.field1704 = new byte[var0.field1706];
               }

               var0.field1704[var9] = 2;
            }
         }

         for(var9 = 0; var9 < var1.field1706; ++var9) {
            if(field1720[var1.field1682[var9]] == field1691 && field1720[var1.field1713[var9]] == field1691 && field1720[var1.field1705[var9]] == field1691) {
               if(var1.field1704 == null) {
                  var1.field1704 = new byte[var1.field1706];
               }

               var1.field1704[var9] = 2;
            }
         }

      }
   }

   @ObfuscatedName("k")
   public final class104 method2239(int var1, int var2, int var3, int var4, int var5) {
      this.method2235();
      int var6 = (int)Math.sqrt((double)(var3 * var3 + var4 * var4 + var5 * var5));
      int var7 = var2 * var6 >> 8;
      class104 var8 = new class104();
      var8.field1798 = new int[this.field1706];
      var8.field1799 = new int[this.field1706];
      var8.field1800 = new int[this.field1706];
      if(this.field1692 > 0 && this.field1688 != null) {
         int[] var9 = new int[this.field1692];

         int var10;
         for(var10 = 0; var10 < this.field1706; ++var10) {
            if(this.field1688[var10] != -1) {
               ++var9[this.field1688[var10] & 255];
            }
         }

         var8.field1806 = 0;

         for(var10 = 0; var10 < this.field1692; ++var10) {
            if(var9[var10] > 0 && this.field1693[var10] == 0) {
               ++var8.field1806;
            }
         }

         var8.field1807 = new int[var8.field1806];
         var8.field1808 = new int[var8.field1806];
         var8.field1837 = new int[var8.field1806];
         var10 = 0;

         int var11;
         for(var11 = 0; var11 < this.field1692; ++var11) {
            if(var9[var11] > 0 && this.field1693[var11] == 0) {
               var8.field1807[var10] = this.field1694[var11] & '\uffff';
               var8.field1808[var10] = this.field1685[var11] & '\uffff';
               var8.field1837[var10] = this.field1696[var11] & '\uffff';
               var9[var11] = var10++;
            } else {
               var9[var11] = -1;
            }
         }

         var8.field1832 = new byte[this.field1706];

         for(var11 = 0; var11 < this.field1706; ++var11) {
            if(this.field1688[var11] != -1) {
               var8.field1832[var11] = (byte)var9[this.field1688[var11] & 255];
            } else {
               var8.field1832[var11] = -1;
            }
         }
      }

      for(int var16 = 0; var16 < this.field1706; ++var16) {
         byte var17;
         if(this.field1704 == null) {
            var17 = 0;
         } else {
            var17 = this.field1704[var16];
         }

         byte var18;
         if(this.field1687 == null) {
            var18 = 0;
         } else {
            var18 = this.field1687[var16];
         }

         short var12;
         if(this.field1678 == null) {
            var12 = -1;
         } else {
            var12 = this.field1678[var16];
         }

         if(var18 == -2) {
            var17 = 3;
         }

         if(var18 == -1) {
            var17 = 2;
         }

         class95 var13;
         int var14;
         class83 var19;
         if(var12 == -1) {
            if(var17 != 0) {
               if(var17 == 1) {
                  var19 = this.field1718[var16];
                  var14 = var1 + (var3 * var19.field1446 + var4 * var19.field1445 + var5 * var19.field1447) / (var7 + var7 / 2);
                  var8.field1798[var16] = method2240(this.field1689[var16] & '\uffff', var14);
                  var8.field1800[var16] = -1;
               } else if(var17 == 3) {
                  var8.field1798[var16] = 128;
                  var8.field1800[var16] = -1;
               } else {
                  var8.field1800[var16] = -2;
               }
            } else {
               int var15 = this.field1689[var16] & '\uffff';
               if(this.field1710 != null && this.field1710[this.field1682[var16]] != null) {
                  var13 = this.field1710[this.field1682[var16]];
               } else {
                  var13 = this.field1709[this.field1682[var16]];
               }

               var14 = var1 + (var3 * var13.field1617 + var4 * var13.field1622 + var5 * var13.field1620) / (var7 * var13.field1618);
               var8.field1798[var16] = method2240(var15, var14);
               if(this.field1710 != null && this.field1710[this.field1713[var16]] != null) {
                  var13 = this.field1710[this.field1713[var16]];
               } else {
                  var13 = this.field1709[this.field1713[var16]];
               }

               var14 = var1 + (var3 * var13.field1617 + var4 * var13.field1622 + var5 * var13.field1620) / (var7 * var13.field1618);
               var8.field1799[var16] = method2240(var15, var14);
               if(this.field1710 != null && this.field1710[this.field1705[var16]] != null) {
                  var13 = this.field1710[this.field1705[var16]];
               } else {
                  var13 = this.field1709[this.field1705[var16]];
               }

               var14 = var1 + (var3 * var13.field1617 + var4 * var13.field1622 + var5 * var13.field1620) / (var7 * var13.field1618);
               var8.field1800[var16] = method2240(var15, var14);
            }
         } else if(var17 != 0) {
            if(var17 == 1) {
               var19 = this.field1718[var16];
               var14 = var1 + (var3 * var19.field1446 + var4 * var19.field1445 + var5 * var19.field1447) / (var7 + var7 / 2);
               var8.field1798[var16] = method2241(var14);
               var8.field1800[var16] = -1;
            } else {
               var8.field1800[var16] = -2;
            }
         } else {
            if(this.field1710 != null && this.field1710[this.field1682[var16]] != null) {
               var13 = this.field1710[this.field1682[var16]];
            } else {
               var13 = this.field1709[this.field1682[var16]];
            }

            var14 = var1 + (var3 * var13.field1617 + var4 * var13.field1622 + var5 * var13.field1620) / (var7 * var13.field1618);
            var8.field1798[var16] = method2241(var14);
            if(this.field1710 != null && this.field1710[this.field1713[var16]] != null) {
               var13 = this.field1710[this.field1713[var16]];
            } else {
               var13 = this.field1709[this.field1713[var16]];
            }

            var14 = var1 + (var3 * var13.field1617 + var4 * var13.field1622 + var5 * var13.field1620) / (var7 * var13.field1618);
            var8.field1799[var16] = method2241(var14);
            if(this.field1710 != null && this.field1710[this.field1705[var16]] != null) {
               var13 = this.field1710[this.field1705[var16]];
            } else {
               var13 = this.field1709[this.field1705[var16]];
            }

            var14 = var1 + (var3 * var13.field1617 + var4 * var13.field1622 + var5 * var13.field1620) / (var7 * var13.field1618);
            var8.field1800[var16] = method2241(var14);
         }
      }

      this.method2225();
      var8.field1838 = this.field1719;
      var8.field1846 = this.field1677;
      var8.field1792 = this.field1679;
      var8.field1793 = this.field1680;
      var8.field1831 = this.field1706;
      var8.field1841 = this.field1682;
      var8.field1804 = this.field1713;
      var8.field1797 = this.field1705;
      var8.field1788 = this.field1686;
      var8.field1802 = this.field1687;
      var8.field1805 = this.field1721;
      var8.field1810 = this.field1695;
      var8.field1811 = this.field1707;
      var8.field1789 = this.field1678;
      return var8;
   }

   @ObfuscatedName("o")
   static final int method2240(int var0, int var1) {
      var1 = var1 * (var0 & 127) >> 7;
      if(var1 < 2) {
         var1 = 2;
      } else if(var1 > 126) {
         var1 = 126;
      }

      return (var0 & 'ﾀ') + var1;
   }

   @ObfuscatedName("ad")
   static final int method2241(int var0) {
      if(var0 < 2) {
         var0 = 2;
      } else if(var0 > 126) {
         var0 = 126;
      }

      return var0;
   }

   class99() {
   }

   @ObfuscatedName("y")
   final int method2247(class99 var1, int var2) {
      int var3 = -1;
      int var4 = var1.field1677[var2];
      int var5 = var1.field1679[var2];
      int var6 = var1.field1680[var2];

      for(int var7 = 0; var7 < this.field1719; ++var7) {
         if(var4 == this.field1677[var7] && var5 == this.field1679[var7] && var6 == this.field1680[var7]) {
            var3 = var7;
            break;
         }
      }

      if(var3 == -1) {
         this.field1677[this.field1719] = var4;
         this.field1679[this.field1719] = var5;
         this.field1680[this.field1719] = var6;
         if(var1.field1684 != null) {
            this.field1684[this.field1719] = var1.field1684[var2];
         }

         var3 = this.field1719++;
      }

      return var3;
   }

   @ObfuscatedName("j")
   public void method2250() {
      for(int var1 = 0; var1 < this.field1719; ++var1) {
         int var2 = this.field1677[var1];
         this.field1677[var1] = this.field1680[var1];
         this.field1680[var1] = -var2;
      }

      this.method2218();
   }

   @ObfuscatedName("v")
   public void method2254(short var1, short var2) {
      for(int var3 = 0; var3 < this.field1706; ++var3) {
         if(this.field1689[var3] == var1) {
            this.field1689[var3] = var2;
         }
      }

   }

   @ObfuscatedName("c")
   public void method2267() {
      int var1;
      for(var1 = 0; var1 < this.field1719; ++var1) {
         this.field1680[var1] = -this.field1680[var1];
      }

      for(var1 = 0; var1 < this.field1706; ++var1) {
         int var2 = this.field1682[var1];
         this.field1682[var1] = this.field1705[var1];
         this.field1705[var1] = var2;
      }

      this.method2218();
   }

   @ObfuscatedName("b")
   public void method2274(short var1, short var2) {
      if(this.field1678 != null) {
         for(int var3 = 0; var3 < this.field1706; ++var3) {
            if(this.field1678[var3] == var1) {
               this.field1678[var3] = var2;
            }
         }

      }
   }

   @ObfuscatedSignature(
      signature = "(Lclass99;ZZZZ)V",
      garbageValue = "1"
   )
   public class99(class99 var1, boolean var2, boolean var3, boolean var4, boolean var5) {
      this.field1719 = var1.field1719;
      this.field1706 = var1.field1706;
      this.field1692 = var1.field1692;
      int var6;
      if(var2) {
         this.field1677 = var1.field1677;
         this.field1679 = var1.field1679;
         this.field1680 = var1.field1680;
      } else {
         this.field1677 = new int[this.field1719];
         this.field1679 = new int[this.field1719];
         this.field1680 = new int[this.field1719];

         for(var6 = 0; var6 < this.field1719; ++var6) {
            this.field1677[var6] = var1.field1677[var6];
            this.field1679[var6] = var1.field1679[var6];
            this.field1680[var6] = var1.field1680[var6];
         }
      }

      if(var3) {
         this.field1689 = var1.field1689;
      } else {
         this.field1689 = new short[this.field1706];

         for(var6 = 0; var6 < this.field1706; ++var6) {
            this.field1689[var6] = var1.field1689[var6];
         }
      }

      if(!var4 && var1.field1678 != null) {
         this.field1678 = new short[this.field1706];

         for(var6 = 0; var6 < this.field1706; ++var6) {
            this.field1678[var6] = var1.field1678[var6];
         }
      } else {
         this.field1678 = var1.field1678;
      }

      this.field1687 = var1.field1687;
      this.field1682 = var1.field1682;
      this.field1713 = var1.field1713;
      this.field1705 = var1.field1705;
      this.field1704 = var1.field1704;
      this.field1686 = var1.field1686;
      this.field1688 = var1.field1688;
      this.field1721 = var1.field1721;
      this.field1693 = var1.field1693;
      this.field1694 = var1.field1694;
      this.field1685 = var1.field1685;
      this.field1696 = var1.field1696;
      this.field1681 = var1.field1681;
      this.field1698 = var1.field1698;
      this.field1699 = var1.field1699;
      this.field1700 = var1.field1700;
      this.field1703 = var1.field1703;
      this.field1701 = var1.field1701;
      this.field1702 = var1.field1702;
      this.field1684 = var1.field1684;
      this.field1683 = var1.field1683;
      this.field1695 = var1.field1695;
      this.field1707 = var1.field1707;
      this.field1709 = var1.field1709;
      this.field1718 = var1.field1718;
      this.field1710 = var1.field1710;
      this.field1711 = var1.field1711;
      this.field1712 = var1.field1712;
   }

   @ObfuscatedName("l")
   public void method2284() {
      for(int var1 = 0; var1 < this.field1719; ++var1) {
         int var2 = this.field1680[var1];
         this.field1680[var1] = this.field1677[var1];
         this.field1677[var1] = -var2;
      }

      this.method2218();
   }

   @ObfuscatedName("i")
   public void method2286(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1719; ++var4) {
         this.field1677[var4] += var1;
         this.field1679[var4] += var2;
         this.field1680[var4] += var3;
      }

      this.method2218();
   }
}
