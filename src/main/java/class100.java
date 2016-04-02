import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
public class class100 extends class85 {
   @ObfuscatedName("l")
   int field1664;
   @ObfuscatedName("w")
   int[] field1665;
   @ObfuscatedName("f")
   int[] field1666;
   @ObfuscatedName("s")
   int[] field1667;
   @ObfuscatedName("p")
   int field1668 = 0;
   @ObfuscatedName("e")
   int field1669 = 0;
   @ObfuscatedName("ag")
   boolean field1670 = false;
   @ObfuscatedName("a")
   int[] field1671;
   @ObfuscatedName("r")
   byte[] field1672;
   @ObfuscatedName("k")
   byte[] field1673;
   @ObfuscatedName("m")
   byte[] field1674;
   @ObfuscatedName("ah")
   class84[] field1675;
   @ObfuscatedName("ax")
   static int[] field1676;
   @ObfuscatedName("y")
   short[] field1677;
   @ObfuscatedName("n")
   byte[] field1678;
   @ObfuscatedName("am")
   int field1679;
   @ObfuscatedName("o")
   byte[] field1680;
   @ObfuscatedName("c")
   short[] field1681;
   @ObfuscatedName("z")
   short[] field1682;
   @ObfuscatedName("b")
   short[] field1683;
   @ObfuscatedName("q")
   short[] field1684;
   @ObfuscatedName("u")
   short[] field1685;
   @ObfuscatedName("t")
   short[] field1686;
   @ObfuscatedName("d")
   short[] field1687;
   @ObfuscatedName("j")
   byte field1688 = 0;
   @ObfuscatedName("v")
   short[] field1689;
   @ObfuscatedName("aq")
   byte[] field1690;
   @ObfuscatedName("ap")
   int[] field1691;
   @ObfuscatedName("ai")
   int[] field1692;
   @ObfuscatedName("ae")
   int[][] field1693;
   @ObfuscatedName("az")
   int[][] field1694;
   @ObfuscatedName("x")
   short[] field1695;
   @ObfuscatedName("af")
   int field1696;
   @ObfuscatedName("ab")
   class96[] field1697;
   @ObfuscatedName("aj")
   public short field1698;
   @ObfuscatedName("ay")
   public short field1699;
   @ObfuscatedName("ad")
   int field1700;
   @ObfuscatedName("h")
   int[] field1701;
   @ObfuscatedName("av")
   int field1702;
   @ObfuscatedName("ar")
   class96[] field1703;
   @ObfuscatedName("aw")
   int field1704;
   @ObfuscatedName("i")
   short[] field1705;
   @ObfuscatedName("aa")
   static int[] field1706 = new int[10000];
   @ObfuscatedName("ac")
   static int[] field1707 = new int[10000];
   @ObfuscatedName("an")
   static int field1708 = 0;
   @ObfuscatedName("g")
   int[] field1709;
   @ObfuscatedName("au")
   static int[] field1710;

   @ObfuscatedName("e")
   public static class100 method2221(class167 var0, int var1, int var2) {
      byte[] var3 = var0.method3280(var1, var2);
      return var3 == null?null:new class100(var3);
   }

   class100() {
   }

   @ObfuscatedName("s")
   void method2223(byte[] var1) {
      boolean var2 = false;
      boolean var3 = false;
      class119 var4 = new class119(var1);
      class119 var5 = new class119(var1);
      class119 var6 = new class119(var1);
      class119 var7 = new class119(var1);
      class119 var8 = new class119(var1);
      var4.field1976 = var1.length - 18;
      int var9 = var4.method2700();
      int var10 = var4.method2700();
      int var11 = var4.method2523();
      int var12 = var4.method2523();
      int var13 = var4.method2523();
      int var14 = var4.method2523();
      int var15 = var4.method2523();
      int var16 = var4.method2523();
      int var17 = var4.method2700();
      int var18 = var4.method2700();
      int var19 = var4.method2700();
      int var20 = var4.method2700();
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
      this.field1669 = var9;
      this.field1668 = var10;
      this.field1664 = var11;
      this.field1665 = new int[var9];
      this.field1666 = new int[var9];
      this.field1667 = new int[var9];
      this.field1701 = new int[var10];
      this.field1709 = new int[var10];
      this.field1671 = new int[var10];
      if(var11 > 0) {
         this.field1680 = new byte[var11];
         this.field1681 = new short[var11];
         this.field1695 = new short[var11];
         this.field1683 = new short[var11];
      }

      if(var16 == 1) {
         this.field1691 = new int[var9];
      }

      if(var12 == 1) {
         this.field1672 = new byte[var10];
         this.field1678 = new byte[var10];
         this.field1705 = new short[var10];
      }

      if(var13 == 255) {
         this.field1673 = new byte[var10];
      } else {
         this.field1688 = (byte)var13;
      }

      if(var14 == 1) {
         this.field1674 = new byte[var10];
      }

      if(var15 == 1) {
         this.field1692 = new int[var10];
      }

      this.field1677 = new short[var10];
      var4.field1976 = var21;
      var5.field1976 = var32;
      var6.field1976 = var33;
      var7.field1976 = var45;
      var8.field1976 = var27;
      int var35 = 0;
      int var36 = 0;
      int var37 = 0;

      int var38;
      int var39;
      int var40;
      int var41;
      int var42;
      for(var38 = 0; var38 < var9; ++var38) {
         var39 = var4.method2523();
         var40 = 0;
         if((var39 & 1) != 0) {
            var40 = var5.method2535();
         }

         var41 = 0;
         if((var39 & 2) != 0) {
            var41 = var6.method2535();
         }

         var42 = 0;
         if((var39 & 4) != 0) {
            var42 = var7.method2535();
         }

         this.field1665[var38] = var35 + var40;
         this.field1666[var38] = var36 + var41;
         this.field1667[var38] = var37 + var42;
         var35 = this.field1665[var38];
         var36 = this.field1666[var38];
         var37 = this.field1667[var38];
         if(var16 == 1) {
            this.field1691[var38] = var8.method2523();
         }
      }

      var4.field1976 = var30;
      var5.field1976 = var26;
      var6.field1976 = var24;
      var7.field1976 = var28;
      var8.field1976 = var25;

      for(var38 = 0; var38 < var10; ++var38) {
         this.field1677[var38] = (short)var4.method2700();
         if(var12 == 1) {
            var39 = var5.method2523();
            if((var39 & 1) == 1) {
               this.field1672[var38] = 1;
               var2 = true;
            } else {
               this.field1672[var38] = 0;
            }

            if((var39 & 2) == 2) {
               this.field1678[var38] = (byte)(var39 >> 2);
               this.field1705[var38] = this.field1677[var38];
               this.field1677[var38] = 127;
               if(this.field1705[var38] != -1) {
                  var3 = true;
               }
            } else {
               this.field1678[var38] = -1;
               this.field1705[var38] = -1;
            }
         }

         if(var13 == 255) {
            this.field1673[var38] = var6.method2633();
         }

         if(var14 == 1) {
            this.field1674[var38] = var7.method2633();
         }

         if(var15 == 1) {
            this.field1692[var38] = var8.method2523();
         }
      }

      var4.field1976 = var29;
      var5.field1976 = var23;
      var38 = 0;
      var39 = 0;
      var40 = 0;
      var41 = 0;

      int var43;
      int var44;
      for(var42 = 0; var42 < var10; ++var42) {
         var43 = var5.method2523();
         if(var43 == 1) {
            var38 = var4.method2535() + var41;
            var39 = var4.method2535() + var38;
            var40 = var4.method2535() + var39;
            var41 = var40;
            this.field1701[var42] = var38;
            this.field1709[var42] = var39;
            this.field1671[var42] = var40;
         }

         if(var43 == 2) {
            var39 = var40;
            var40 = var4.method2535() + var41;
            var41 = var40;
            this.field1701[var42] = var38;
            this.field1709[var42] = var39;
            this.field1671[var42] = var40;
         }

         if(var43 == 3) {
            var38 = var40;
            var40 = var4.method2535() + var41;
            var41 = var40;
            this.field1701[var42] = var38;
            this.field1709[var42] = var39;
            this.field1671[var42] = var40;
         }

         if(var43 == 4) {
            var44 = var38;
            var38 = var39;
            var39 = var44;
            var40 = var4.method2535() + var41;
            var41 = var40;
            this.field1701[var42] = var38;
            this.field1709[var42] = var44;
            this.field1671[var42] = var40;
         }
      }

      var4.field1976 = var31;

      for(var42 = 0; var42 < var11; ++var42) {
         this.field1680[var42] = 0;
         this.field1681[var42] = (short)var4.method2700();
         this.field1695[var42] = (short)var4.method2700();
         this.field1683[var42] = (short)var4.method2700();
      }

      if(this.field1678 != null) {
         boolean var46 = false;

         for(var43 = 0; var43 < var10; ++var43) {
            var44 = this.field1678[var43] & 255;
            if(var44 != 255) {
               if((this.field1681[var44] & '\uffff') == this.field1701[var43] && (this.field1695[var44] & '\uffff') == this.field1709[var43] && (this.field1683[var44] & '\uffff') == this.field1671[var43]) {
                  this.field1678[var43] = -1;
               } else {
                  var46 = true;
               }
            }
         }

         if(!var46) {
            this.field1678 = null;
         }
      }

      if(!var3) {
         this.field1705 = null;
      }

      if(!var2) {
         this.field1672 = null;
      }

   }

   class100(byte[] var1) {
      if(var1[var1.length - 1] == -1 && var1[var1.length - 2] == -1) {
         this.method2271(var1);
      } else {
         this.method2223(var1);
      }

   }

   @ObfuscatedName("a")
   void method2228() {
      int[] var1;
      int var2;
      int var3;
      int var4;
      if(this.field1691 != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.field1669; ++var3) {
            var4 = this.field1691[var3];
            ++var1[var4];
            if(var4 > var2) {
               var2 = var4;
            }
         }

         this.field1693 = new int[var2 + 1][];

         for(var3 = 0; var3 <= var2; ++var3) {
            this.field1693[var3] = new int[var1[var3]];
            var1[var3] = 0;
         }

         for(var3 = 0; var3 < this.field1669; this.field1693[var4][var1[var4]++] = var3++) {
            var4 = this.field1691[var3];
         }

         this.field1691 = null;
      }

      if(this.field1692 != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.field1668; ++var3) {
            var4 = this.field1692[var3];
            ++var1[var4];
            if(var4 > var2) {
               var2 = var4;
            }
         }

         this.field1694 = new int[var2 + 1][];

         for(var3 = 0; var3 <= var2; ++var3) {
            this.field1694[var3] = new int[var1[var3]];
            var1[var3] = 0;
         }

         for(var3 = 0; var3 < this.field1668; this.field1694[var4][var1[var4]++] = var3++) {
            var4 = this.field1692[var3];
         }

         this.field1692 = null;
      }

   }

   @ObfuscatedName("p")
   final int method2229(class100 var1, int var2) {
      int var3 = -1;
      int var4 = var1.field1665[var2];
      int var5 = var1.field1666[var2];
      int var6 = var1.field1667[var2];

      for(int var7 = 0; var7 < this.field1669; ++var7) {
         if(var4 == this.field1665[var7] && var5 == this.field1666[var7] && var6 == this.field1667[var7]) {
            var3 = var7;
            break;
         }
      }

      if(var3 == -1) {
         this.field1665[this.field1669] = var4;
         this.field1666[this.field1669] = var5;
         this.field1667[this.field1669] = var6;
         if(var1.field1691 != null) {
            this.field1691[this.field1669] = var1.field1691[var2];
         }

         var3 = this.field1669++;
      }

      return var3;
   }

   @ObfuscatedName("k")
   public void method2230() {
      for(int var1 = 0; var1 < this.field1669; ++var1) {
         this.field1665[var1] = -this.field1665[var1];
         this.field1667[var1] = -this.field1667[var1];
      }

      this.method2239();
   }

   @ObfuscatedName("i")
   public void method2231() {
      for(int var1 = 0; var1 < this.field1669; ++var1) {
         int var2 = this.field1667[var1];
         this.field1667[var1] = this.field1665[var1];
         this.field1665[var1] = -var2;
      }

      this.method2239();
   }

   @ObfuscatedName("j")
   public void method2232(int var1) {
      int var2 = field1676[var1];
      int var3 = field1710[var1];

      for(int var4 = 0; var4 < this.field1669; ++var4) {
         int var5 = this.field1667[var4] * var2 + this.field1665[var4] * var3 >> 16;
         this.field1667[var4] = this.field1667[var4] * var3 - this.field1665[var4] * var2 >> 16;
         this.field1665[var4] = var5;
      }

      this.method2239();
   }

   @ObfuscatedName("l")
   public void method2233(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1669; ++var4) {
         this.field1665[var4] += var1;
         this.field1666[var4] += var2;
         this.field1667[var4] += var3;
      }

      this.method2239();
   }

   @ObfuscatedName("o")
   public void method2234(short var1, short var2) {
      for(int var3 = 0; var3 < this.field1668; ++var3) {
         if(this.field1677[var3] == var1) {
            this.field1677[var3] = var2;
         }
      }

   }

   @ObfuscatedName("c")
   public void method2235(short var1, short var2) {
      if(this.field1705 != null) {
         for(int var3 = 0; var3 < this.field1668; ++var3) {
            if(this.field1705[var3] == var1) {
               this.field1705[var3] = var2;
            }
         }

      }
   }

   @ObfuscatedName("z")
   public final class105 method2236(int var1, int var2, int var3, int var4, int var5) {
      this.method2238();
      int var6 = (int)Math.sqrt((double)(var3 * var3 + var4 * var4 + var5 * var5));
      int var7 = var2 * var6 >> 8;
      class105 var8 = new class105();
      var8.field1812 = new int[this.field1668];
      var8.field1831 = new int[this.field1668];
      var8.field1824 = new int[this.field1668];
      if(this.field1664 > 0 && this.field1678 != null) {
         int[] var9 = new int[this.field1664];

         int var10;
         for(var10 = 0; var10 < this.field1668; ++var10) {
            if(this.field1678[var10] != -1) {
               ++var9[this.field1678[var10] & 255];
            }
         }

         var8.field1795 = 0;

         for(var10 = 0; var10 < this.field1664; ++var10) {
            if(var9[var10] > 0 && this.field1680[var10] == 0) {
               ++var8.field1795;
            }
         }

         var8.field1796 = new int[var8.field1795];
         var8.field1817 = new int[var8.field1795];
         var8.field1798 = new int[var8.field1795];
         var10 = 0;

         int var11;
         for(var11 = 0; var11 < this.field1664; ++var11) {
            if(var9[var11] > 0 && this.field1680[var11] == 0) {
               var8.field1796[var10] = this.field1681[var11] & '\uffff';
               var8.field1817[var10] = this.field1695[var11] & '\uffff';
               var8.field1798[var10] = this.field1683[var11] & '\uffff';
               var9[var11] = var10++;
            } else {
               var9[var11] = -1;
            }
         }

         var8.field1792 = new byte[this.field1668];

         for(var11 = 0; var11 < this.field1668; ++var11) {
            if(this.field1678[var11] != -1) {
               var8.field1792[var11] = (byte)var9[this.field1678[var11] & 255];
            } else {
               var8.field1792[var11] = -1;
            }
         }
      }

      for(int var16 = 0; var16 < this.field1668; ++var16) {
         byte var17;
         if(this.field1672 == null) {
            var17 = 0;
         } else {
            var17 = this.field1672[var16];
         }

         byte var18;
         if(this.field1674 == null) {
            var18 = 0;
         } else {
            var18 = this.field1674[var16];
         }

         short var12;
         if(this.field1705 == null) {
            var12 = -1;
         } else {
            var12 = this.field1705[var16];
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
                  var19 = this.field1675[var16];
                  var14 = var1 + (var3 * var19.field1434 + var4 * var19.field1429 + var5 * var19.field1432) / (var7 + var7 / 2);
                  var8.field1812[var16] = method2243(this.field1677[var16] & '\uffff', var14);
                  var8.field1824[var16] = -1;
               } else if(var17 == 3) {
                  var8.field1812[var16] = 128;
                  var8.field1824[var16] = -1;
               } else {
                  var8.field1824[var16] = -2;
               }
            } else {
               int var15 = this.field1677[var16] & '\uffff';
               if(this.field1697 != null && this.field1697[this.field1701[var16]] != null) {
                  var13 = this.field1697[this.field1701[var16]];
               } else {
                  var13 = this.field1703[this.field1701[var16]];
               }

               var14 = var1 + (var3 * var13.field1605 + var4 * var13.field1608 + var5 * var13.field1606) / (var7 * var13.field1607);
               var8.field1812[var16] = method2243(var15, var14);
               if(this.field1697 != null && this.field1697[this.field1709[var16]] != null) {
                  var13 = this.field1697[this.field1709[var16]];
               } else {
                  var13 = this.field1703[this.field1709[var16]];
               }

               var14 = var1 + (var3 * var13.field1605 + var4 * var13.field1608 + var5 * var13.field1606) / (var7 * var13.field1607);
               var8.field1831[var16] = method2243(var15, var14);
               if(this.field1697 != null && this.field1697[this.field1671[var16]] != null) {
                  var13 = this.field1697[this.field1671[var16]];
               } else {
                  var13 = this.field1703[this.field1671[var16]];
               }

               var14 = var1 + (var3 * var13.field1605 + var4 * var13.field1608 + var5 * var13.field1606) / (var7 * var13.field1607);
               var8.field1824[var16] = method2243(var15, var14);
            }
         } else if(var17 != 0) {
            if(var17 == 1) {
               var19 = this.field1675[var16];
               var14 = var1 + (var3 * var19.field1434 + var4 * var19.field1429 + var5 * var19.field1432) / (var7 + var7 / 2);
               var8.field1812[var16] = method2288(var14);
               var8.field1824[var16] = -1;
            } else {
               var8.field1824[var16] = -2;
            }
         } else {
            if(this.field1697 != null && this.field1697[this.field1701[var16]] != null) {
               var13 = this.field1697[this.field1701[var16]];
            } else {
               var13 = this.field1703[this.field1701[var16]];
            }

            var14 = var1 + (var3 * var13.field1605 + var4 * var13.field1608 + var5 * var13.field1606) / (var7 * var13.field1607);
            var8.field1812[var16] = method2288(var14);
            if(this.field1697 != null && this.field1697[this.field1709[var16]] != null) {
               var13 = this.field1697[this.field1709[var16]];
            } else {
               var13 = this.field1703[this.field1709[var16]];
            }

            var14 = var1 + (var3 * var13.field1605 + var4 * var13.field1608 + var5 * var13.field1606) / (var7 * var13.field1607);
            var8.field1831[var16] = method2288(var14);
            if(this.field1697 != null && this.field1697[this.field1671[var16]] != null) {
               var13 = this.field1697[this.field1671[var16]];
            } else {
               var13 = this.field1703[this.field1671[var16]];
            }

            var14 = var1 + (var3 * var13.field1605 + var4 * var13.field1608 + var5 * var13.field1606) / (var7 * var13.field1607);
            var8.field1824[var16] = method2288(var14);
         }
      }

      this.method2228();
      var8.field1779 = this.field1669;
      var8.field1780 = this.field1665;
      var8.field1781 = this.field1666;
      var8.field1782 = this.field1667;
      var8.field1783 = this.field1668;
      var8.field1784 = this.field1701;
      var8.field1838 = this.field1709;
      var8.field1786 = this.field1671;
      var8.field1790 = this.field1673;
      var8.field1791 = this.field1674;
      var8.field1794 = this.field1688;
      var8.field1799 = this.field1693;
      var8.field1800 = this.field1694;
      var8.field1804 = this.field1705;
      return var8;
   }

   @ObfuscatedName("q")
   public void method2238() {
      if(this.field1703 == null) {
         this.field1703 = new class96[this.field1669];

         int var1;
         for(var1 = 0; var1 < this.field1669; ++var1) {
            this.field1703[var1] = new class96();
         }

         for(var1 = 0; var1 < this.field1668; ++var1) {
            int var2 = this.field1701[var1];
            int var3 = this.field1709[var1];
            int var4 = this.field1671[var1];
            int var5 = this.field1665[var3] - this.field1665[var2];
            int var6 = this.field1666[var3] - this.field1666[var2];
            int var7 = this.field1667[var3] - this.field1667[var2];
            int var8 = this.field1665[var4] - this.field1665[var2];
            int var9 = this.field1666[var4] - this.field1666[var2];
            int var10 = this.field1667[var4] - this.field1667[var2];
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
               class96 var16 = this.field1703[var2];
               var16.field1605 += var11;
               var16.field1608 += var12;
               var16.field1606 += var13;
               ++var16.field1607;
               var16 = this.field1703[var3];
               var16.field1605 += var11;
               var16.field1608 += var12;
               var16.field1606 += var13;
               ++var16.field1607;
               var16 = this.field1703[var4];
               var16.field1605 += var11;
               var16.field1608 += var12;
               var16.field1606 += var13;
               ++var16.field1607;
            } else if(var15 == 1) {
               if(this.field1675 == null) {
                  this.field1675 = new class84[this.field1668];
               }

               class84 var17 = this.field1675[var1] = new class84();
               var17.field1434 = var11;
               var17.field1429 = var12;
               var17.field1432 = var13;
            }
         }

      }
   }

   @ObfuscatedName("u")
   void method2239() {
      this.field1703 = null;
      this.field1697 = null;
      this.field1675 = null;
      this.field1670 = false;
   }

   @ObfuscatedName("t")
   void method2240() {
      if(!this.field1670) {
         super.field1438 = 0;
         this.field1702 = 0;
         this.field1696 = 999999;
         this.field1679 = -999999;
         this.field1704 = -99999;
         this.field1700 = 99999;

         for(int var1 = 0; var1 < this.field1669; ++var1) {
            int var2 = this.field1665[var1];
            int var3 = this.field1666[var1];
            int var4 = this.field1667[var1];
            if(var2 < this.field1696) {
               this.field1696 = var2;
            }

            if(var2 > this.field1679) {
               this.field1679 = var2;
            }

            if(var4 < this.field1700) {
               this.field1700 = var4;
            }

            if(var4 > this.field1704) {
               this.field1704 = var4;
            }

            if(-var3 > super.field1438) {
               super.field1438 = -var3;
            }

            if(var3 > this.field1702) {
               this.field1702 = var3;
            }
         }

         this.field1670 = true;
      }
   }

   @ObfuscatedName("v")
   static final int method2243(int var0, int var1) {
      var1 = var1 * (var0 & 127) >> 7;
      if(var1 < 2) {
         var1 = 2;
      } else if(var1 > 126) {
         var1 = 126;
      }

      return (var0 & 'ﾀ') + var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([[IIIIZI)Lclass100;",
      garbageValue = "1"
   )
   public class100 method2244(int[][] var1, int var2, int var3, int var4, int var5) {
      this.method2240();
      int var6 = var2 + this.field1696;
      int var7 = var2 + this.field1679;
      int var8 = var4 + this.field1700;
      int var9 = var4 + this.field1704;
      if(var6 >= 0 && var7 + 128 >> 7 < var1.length && var8 >= 0 && var9 + 128 >> 7 < var1[0].length) {
         var6 >>= 7;
         var7 = var7 + 127 >> 7;
         var8 >>= 7;
         var9 = var9 + 127 >> 7;
         if(var1[var6][var8] == var3 && var1[var7][var8] == var3 && var1[var6][var9] == var3 && var1[var7][var9] == var3) {
            return this;
         } else {
            class100 var10 = new class100();
            var10.field1669 = this.field1669;
            var10.field1668 = this.field1668;
            var10.field1664 = this.field1664;
            var10.field1665 = this.field1665;
            var10.field1667 = this.field1667;
            var10.field1701 = this.field1701;
            var10.field1709 = this.field1709;
            var10.field1671 = this.field1671;
            var10.field1672 = this.field1672;
            var10.field1673 = this.field1673;
            var10.field1674 = this.field1674;
            var10.field1678 = this.field1678;
            var10.field1677 = this.field1677;
            var10.field1705 = this.field1705;
            var10.field1688 = this.field1688;
            var10.field1680 = this.field1680;
            var10.field1681 = this.field1681;
            var10.field1695 = this.field1695;
            var10.field1683 = this.field1683;
            var10.field1684 = this.field1684;
            var10.field1685 = this.field1685;
            var10.field1686 = this.field1686;
            var10.field1687 = this.field1687;
            var10.field1690 = this.field1690;
            var10.field1682 = this.field1682;
            var10.field1689 = this.field1689;
            var10.field1691 = this.field1691;
            var10.field1692 = this.field1692;
            var10.field1693 = this.field1693;
            var10.field1694 = this.field1694;
            var10.field1698 = this.field1698;
            var10.field1699 = this.field1699;
            var10.field1666 = new int[var10.field1669];
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
               for(var11 = 0; var11 < var10.field1669; ++var11) {
                  var12 = this.field1665[var11] + var2;
                  var13 = this.field1667[var11] + var4;
                  var14 = var12 & 127;
                  var15 = var13 & 127;
                  var16 = var12 >> 7;
                  var17 = var13 >> 7;
                  var18 = var1[var16][var17] * (128 - var14) + var1[var16 + 1][var17] * var14 >> 7;
                  var19 = var1[var16][var17 + 1] * (128 - var14) + var1[var16 + 1][var17 + 1] * var14 >> 7;
                  var20 = var18 * (128 - var15) + var19 * var15 >> 7;
                  var10.field1666[var11] = this.field1666[var11] + var20 - var3;
               }
            } else {
               for(var11 = 0; var11 < var10.field1669; ++var11) {
                  var12 = (-this.field1666[var11] << 16) / super.field1438;
                  if(var12 < var5) {
                     var13 = this.field1665[var11] + var2;
                     var14 = this.field1667[var11] + var4;
                     var15 = var13 & 127;
                     var16 = var14 & 127;
                     var17 = var13 >> 7;
                     var18 = var14 >> 7;
                     var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                     var20 = var1[var17][var18 + 1] * (128 - var15) + var1[var17 + 1][var18 + 1] * var15 >> 7;
                     int var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                     var10.field1666[var11] = this.field1666[var11] + (var21 - var3) * (var5 - var12) / var5;
                  }
               }
            }

            var10.method2239();
            return var10;
         }
      } else {
         return this;
      }
   }

   static {
      field1676 = class91.field1568;
      field1710 = class91.field1554;
   }

   @ObfuscatedName("b")
   public void method2249(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1669; ++var4) {
         this.field1665[var4] = this.field1665[var4] * var1 / 128;
         this.field1666[var4] = this.field1666[var4] * var2 / 128;
         this.field1667[var4] = this.field1667[var4] * var3 / 128;
      }

      this.method2239();
   }

   public class100(class100[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      boolean var8 = false;
      this.field1669 = 0;
      this.field1668 = 0;
      this.field1664 = 0;
      this.field1688 = -1;

      int var9;
      class100 var10;
      for(var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if(var10 != null) {
            this.field1669 += var10.field1669;
            this.field1668 += var10.field1668;
            this.field1664 += var10.field1664;
            if(var10.field1673 != null) {
               var4 = true;
            } else {
               if(this.field1688 == -1) {
                  this.field1688 = var10.field1688;
               }

               if(this.field1688 != var10.field1688) {
                  var4 = true;
               }
            }

            var3 |= var10.field1672 != null;
            var5 |= var10.field1674 != null;
            var6 |= var10.field1692 != null;
            var7 |= var10.field1705 != null;
            var8 |= var10.field1678 != null;
         }
      }

      this.field1665 = new int[this.field1669];
      this.field1666 = new int[this.field1669];
      this.field1667 = new int[this.field1669];
      this.field1691 = new int[this.field1669];
      this.field1701 = new int[this.field1668];
      this.field1709 = new int[this.field1668];
      this.field1671 = new int[this.field1668];
      if(var3) {
         this.field1672 = new byte[this.field1668];
      }

      if(var4) {
         this.field1673 = new byte[this.field1668];
      }

      if(var5) {
         this.field1674 = new byte[this.field1668];
      }

      if(var6) {
         this.field1692 = new int[this.field1668];
      }

      if(var7) {
         this.field1705 = new short[this.field1668];
      }

      if(var8) {
         this.field1678 = new byte[this.field1668];
      }

      this.field1677 = new short[this.field1668];
      if(this.field1664 > 0) {
         this.field1680 = new byte[this.field1664];
         this.field1681 = new short[this.field1664];
         this.field1695 = new short[this.field1664];
         this.field1683 = new short[this.field1664];
         this.field1684 = new short[this.field1664];
         this.field1685 = new short[this.field1664];
         this.field1686 = new short[this.field1664];
         this.field1687 = new short[this.field1664];
         this.field1690 = new byte[this.field1664];
         this.field1682 = new short[this.field1664];
         this.field1689 = new short[this.field1664];
      }

      this.field1669 = 0;
      this.field1668 = 0;
      this.field1664 = 0;

      for(var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if(var10 != null) {
            int var11;
            for(var11 = 0; var11 < var10.field1668; ++var11) {
               if(var3 && var10.field1672 != null) {
                  this.field1672[this.field1668] = var10.field1672[var11];
               }

               if(var4) {
                  if(var10.field1673 != null) {
                     this.field1673[this.field1668] = var10.field1673[var11];
                  } else {
                     this.field1673[this.field1668] = var10.field1688;
                  }
               }

               if(var5 && var10.field1674 != null) {
                  this.field1674[this.field1668] = var10.field1674[var11];
               }

               if(var6 && var10.field1692 != null) {
                  this.field1692[this.field1668] = var10.field1692[var11];
               }

               if(var7) {
                  if(var10.field1705 != null) {
                     this.field1705[this.field1668] = var10.field1705[var11];
                  } else {
                     this.field1705[this.field1668] = -1;
                  }
               }

               if(var8) {
                  if(var10.field1678 != null && var10.field1678[var11] != -1) {
                     this.field1678[this.field1668] = (byte)(var10.field1678[var11] + this.field1664);
                  } else {
                     this.field1678[this.field1668] = -1;
                  }
               }

               this.field1677[this.field1668] = var10.field1677[var11];
               this.field1701[this.field1668] = this.method2229(var10, var10.field1701[var11]);
               this.field1709[this.field1668] = this.method2229(var10, var10.field1709[var11]);
               this.field1671[this.field1668] = this.method2229(var10, var10.field1671[var11]);
               ++this.field1668;
            }

            for(var11 = 0; var11 < var10.field1664; ++var11) {
               byte var12 = this.field1680[this.field1664] = var10.field1680[var11];
               if(var12 == 0) {
                  this.field1681[this.field1664] = (short)this.method2229(var10, var10.field1681[var11]);
                  this.field1695[this.field1664] = (short)this.method2229(var10, var10.field1695[var11]);
                  this.field1683[this.field1664] = (short)this.method2229(var10, var10.field1683[var11]);
               }

               if(var12 >= 1 && var12 <= 3) {
                  this.field1681[this.field1664] = var10.field1681[var11];
                  this.field1695[this.field1664] = var10.field1695[var11];
                  this.field1683[this.field1664] = var10.field1683[var11];
                  this.field1684[this.field1664] = var10.field1684[var11];
                  this.field1685[this.field1664] = var10.field1685[var11];
                  this.field1686[this.field1664] = var10.field1686[var11];
                  this.field1687[this.field1664] = var10.field1687[var11];
                  this.field1690[this.field1664] = var10.field1690[var11];
                  this.field1682[this.field1664] = var10.field1682[var11];
               }

               if(var12 == 2) {
                  this.field1689[this.field1664] = var10.field1689[var11];
               }

               ++this.field1664;
            }
         }
      }

   }

   @ObfuscatedName("w")
   void method2271(byte[] var1) {
      class119 var2 = new class119(var1);
      class119 var3 = new class119(var1);
      class119 var4 = new class119(var1);
      class119 var5 = new class119(var1);
      class119 var6 = new class119(var1);
      class119 var7 = new class119(var1);
      class119 var8 = new class119(var1);
      var2.field1976 = var1.length - 23;
      int var9 = var2.method2700();
      int var10 = var2.method2700();
      int var11 = var2.method2523();
      int var12 = var2.method2523();
      int var13 = var2.method2523();
      int var14 = var2.method2523();
      int var15 = var2.method2523();
      int var16 = var2.method2523();
      int var17 = var2.method2523();
      int var18 = var2.method2700();
      int var19 = var2.method2700();
      int var20 = var2.method2700();
      int var21 = var2.method2700();
      int var22 = var2.method2700();
      int var23 = 0;
      int var24 = 0;
      int var25 = 0;
      int var26;
      if(var11 > 0) {
         this.field1680 = new byte[var11];
         var2.field1976 = 0;

         for(var26 = 0; var26 < var11; ++var26) {
            byte var27 = this.field1680[var26] = var2.method2633();
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
      this.field1669 = var9;
      this.field1668 = var10;
      this.field1664 = var11;
      this.field1665 = new int[var9];
      this.field1666 = new int[var9];
      this.field1667 = new int[var9];
      this.field1701 = new int[var10];
      this.field1709 = new int[var10];
      this.field1671 = new int[var10];
      if(var17 == 1) {
         this.field1691 = new int[var9];
      }

      if(var12 == 1) {
         this.field1672 = new byte[var10];
      }

      if(var13 == 255) {
         this.field1673 = new byte[var10];
      } else {
         this.field1688 = (byte)var13;
      }

      if(var14 == 1) {
         this.field1674 = new byte[var10];
      }

      if(var15 == 1) {
         this.field1692 = new int[var10];
      }

      if(var16 == 1) {
         this.field1705 = new short[var10];
      }

      if(var16 == 1 && var11 > 0) {
         this.field1678 = new byte[var10];
      }

      this.field1677 = new short[var10];
      if(var11 > 0) {
         this.field1681 = new short[var11];
         this.field1695 = new short[var11];
         this.field1683 = new short[var11];
         if(var24 > 0) {
            this.field1684 = new short[var24];
            this.field1685 = new short[var24];
            this.field1686 = new short[var24];
            this.field1687 = new short[var24];
            this.field1690 = new byte[var24];
            this.field1682 = new short[var24];
         }

         if(var25 > 0) {
            this.field1689 = new short[var25];
         }
      }

      var2.field1976 = var11;
      var3.field1976 = var38;
      var4.field1976 = var39;
      var5.field1976 = var40;
      var6.field1976 = var32;
      int var48 = 0;
      int var49 = 0;
      int var50 = 0;

      int var51;
      int var52;
      int var53;
      int var54;
      int var55;
      for(var51 = 0; var51 < var9; ++var51) {
         var52 = var2.method2523();
         var53 = 0;
         if((var52 & 1) != 0) {
            var53 = var3.method2535();
         }

         var54 = 0;
         if((var52 & 2) != 0) {
            var54 = var4.method2535();
         }

         var55 = 0;
         if((var52 & 4) != 0) {
            var55 = var5.method2535();
         }

         this.field1665[var51] = var48 + var53;
         this.field1666[var51] = var49 + var54;
         this.field1667[var51] = var50 + var55;
         var48 = this.field1665[var51];
         var49 = this.field1666[var51];
         var50 = this.field1667[var51];
         if(var17 == 1) {
            this.field1691[var51] = var6.method2523();
         }
      }

      var2.field1976 = var37;
      var3.field1976 = var28;
      var4.field1976 = var30;
      var5.field1976 = var33;
      var6.field1976 = var31;
      var7.field1976 = var35;
      var8.field1976 = var36;

      for(var51 = 0; var51 < var10; ++var51) {
         this.field1677[var51] = (short)var2.method2700();
         if(var12 == 1) {
            this.field1672[var51] = var3.method2633();
         }

         if(var13 == 255) {
            this.field1673[var51] = var4.method2633();
         }

         if(var14 == 1) {
            this.field1674[var51] = var5.method2633();
         }

         if(var15 == 1) {
            this.field1692[var51] = var6.method2523();
         }

         if(var16 == 1) {
            this.field1705[var51] = (short)(var7.method2700() - 1);
         }

         if(this.field1678 != null && this.field1705[var51] != -1) {
            this.field1678[var51] = (byte)(var8.method2523() - 1);
         }
      }

      var2.field1976 = var34;
      var3.field1976 = var29;
      var51 = 0;
      var52 = 0;
      var53 = 0;
      var54 = 0;

      int var56;
      for(var55 = 0; var55 < var10; ++var55) {
         var56 = var3.method2523();
         if(var56 == 1) {
            var51 = var2.method2535() + var54;
            var52 = var2.method2535() + var51;
            var53 = var2.method2535() + var52;
            var54 = var53;
            this.field1701[var55] = var51;
            this.field1709[var55] = var52;
            this.field1671[var55] = var53;
         }

         if(var56 == 2) {
            var52 = var53;
            var53 = var2.method2535() + var54;
            var54 = var53;
            this.field1701[var55] = var51;
            this.field1709[var55] = var52;
            this.field1671[var55] = var53;
         }

         if(var56 == 3) {
            var51 = var53;
            var53 = var2.method2535() + var54;
            var54 = var53;
            this.field1701[var55] = var51;
            this.field1709[var55] = var52;
            this.field1671[var55] = var53;
         }

         if(var56 == 4) {
            int var57 = var51;
            var51 = var52;
            var52 = var57;
            var53 = var2.method2535() + var54;
            var54 = var53;
            this.field1701[var55] = var51;
            this.field1709[var55] = var57;
            this.field1671[var55] = var53;
         }
      }

      var2.field1976 = var41;
      var3.field1976 = var42;
      var4.field1976 = var43;
      var5.field1976 = var44;
      var6.field1976 = var45;
      var7.field1976 = var46;

      for(var55 = 0; var55 < var11; ++var55) {
         var56 = this.field1680[var55] & 255;
         if(var56 == 0) {
            this.field1681[var55] = (short)var2.method2700();
            this.field1695[var55] = (short)var2.method2700();
            this.field1683[var55] = (short)var2.method2700();
         }

         if(var56 == 1) {
            this.field1681[var55] = (short)var3.method2700();
            this.field1695[var55] = (short)var3.method2700();
            this.field1683[var55] = (short)var3.method2700();
            this.field1684[var55] = (short)var4.method2700();
            this.field1685[var55] = (short)var4.method2700();
            this.field1686[var55] = (short)var4.method2700();
            this.field1687[var55] = (short)var5.method2700();
            this.field1690[var55] = var6.method2633();
            this.field1682[var55] = (short)var7.method2700();
         }

         if(var56 == 2) {
            this.field1681[var55] = (short)var3.method2700();
            this.field1695[var55] = (short)var3.method2700();
            this.field1683[var55] = (short)var3.method2700();
            this.field1684[var55] = (short)var4.method2700();
            this.field1685[var55] = (short)var4.method2700();
            this.field1686[var55] = (short)var4.method2700();
            this.field1687[var55] = (short)var5.method2700();
            this.field1690[var55] = var6.method2633();
            this.field1682[var55] = (short)var7.method2700();
            this.field1689[var55] = (short)var7.method2700();
         }

         if(var56 == 3) {
            this.field1681[var55] = (short)var3.method2700();
            this.field1695[var55] = (short)var3.method2700();
            this.field1683[var55] = (short)var3.method2700();
            this.field1684[var55] = (short)var4.method2700();
            this.field1685[var55] = (short)var4.method2700();
            this.field1686[var55] = (short)var4.method2700();
            this.field1687[var55] = (short)var5.method2700();
            this.field1690[var55] = var6.method2633();
            this.field1682[var55] = (short)var7.method2700();
         }
      }

      var2.field1976 = var26;
      var55 = var2.method2523();
      if(var55 != 0) {
         new class90();
         var2.method2700();
         var2.method2700();
         var2.method2700();
         var2.method2528();
      }

   }

   @ObfuscatedName("r")
   public void method2272() {
      for(int var1 = 0; var1 < this.field1669; ++var1) {
         int var2 = this.field1665[var1];
         this.field1665[var1] = this.field1667[var1];
         this.field1667[var1] = -var2;
      }

      this.method2239();
   }

   @ObfuscatedName("x")
   public void method2282() {
      int var1;
      for(var1 = 0; var1 < this.field1669; ++var1) {
         this.field1667[var1] = -this.field1667[var1];
      }

      for(var1 = 0; var1 < this.field1668; ++var1) {
         int var2 = this.field1701[var1];
         this.field1701[var1] = this.field1671[var1];
         this.field1671[var1] = var2;
      }

      this.method2239();
   }

   @ObfuscatedName("aq")
   static final int method2288(int var0) {
      if(var0 < 2) {
         var0 = 2;
      } else if(var0 > 126) {
         var0 = 126;
      }

      return var0;
   }

   @ObfuscatedName("h")
   public class100 method2296() {
      class100 var1 = new class100();
      if(this.field1672 != null) {
         var1.field1672 = new byte[this.field1668];

         for(int var2 = 0; var2 < this.field1668; ++var2) {
            var1.field1672[var2] = this.field1672[var2];
         }
      }

      var1.field1669 = this.field1669;
      var1.field1668 = this.field1668;
      var1.field1664 = this.field1664;
      var1.field1665 = this.field1665;
      var1.field1666 = this.field1666;
      var1.field1667 = this.field1667;
      var1.field1701 = this.field1701;
      var1.field1709 = this.field1709;
      var1.field1671 = this.field1671;
      var1.field1673 = this.field1673;
      var1.field1674 = this.field1674;
      var1.field1678 = this.field1678;
      var1.field1677 = this.field1677;
      var1.field1705 = this.field1705;
      var1.field1688 = this.field1688;
      var1.field1680 = this.field1680;
      var1.field1681 = this.field1681;
      var1.field1695 = this.field1695;
      var1.field1683 = this.field1683;
      var1.field1684 = this.field1684;
      var1.field1685 = this.field1685;
      var1.field1686 = this.field1686;
      var1.field1687 = this.field1687;
      var1.field1690 = this.field1690;
      var1.field1682 = this.field1682;
      var1.field1689 = this.field1689;
      var1.field1691 = this.field1691;
      var1.field1692 = this.field1692;
      var1.field1693 = this.field1693;
      var1.field1694 = this.field1694;
      var1.field1703 = this.field1703;
      var1.field1675 = this.field1675;
      var1.field1698 = this.field1698;
      var1.field1699 = this.field1699;
      return var1;
   }

   @ObfuscatedName("d")
   static void method2301(class100 var0, class100 var1, int var2, int var3, int var4, boolean var5) {
      var0.method2240();
      var0.method2238();
      var1.method2240();
      var1.method2238();
      ++field1708;
      int var6 = 0;
      int[] var7 = var1.field1665;
      int var8 = var1.field1669;

      int var9;
      for(var9 = 0; var9 < var0.field1669; ++var9) {
         class96 var10 = var0.field1703[var9];
         if(var10.field1607 != 0) {
            int var11 = var0.field1666[var9] - var3;
            if(var11 <= var1.field1702) {
               int var12 = var0.field1665[var9] - var2;
               if(var12 >= var1.field1696 && var12 <= var1.field1679) {
                  int var13 = var0.field1667[var9] - var4;
                  if(var13 >= var1.field1700 && var13 <= var1.field1704) {
                     for(int var14 = 0; var14 < var8; ++var14) {
                        class96 var15 = var1.field1703[var14];
                        if(var12 == var7[var14] && var13 == var1.field1667[var14] && var11 == var1.field1666[var14] && var15.field1607 != 0) {
                           if(var0.field1697 == null) {
                              var0.field1697 = new class96[var0.field1669];
                           }

                           if(var1.field1697 == null) {
                              var1.field1697 = new class96[var8];
                           }

                           class96 var16 = var0.field1697[var9];
                           if(var16 == null) {
                              var16 = var0.field1697[var9] = new class96(var10);
                           }

                           class96 var17 = var1.field1697[var14];
                           if(var17 == null) {
                              var17 = var1.field1697[var14] = new class96(var15);
                           }

                           var16.field1605 += var15.field1605;
                           var16.field1608 += var15.field1608;
                           var16.field1606 += var15.field1606;
                           var16.field1607 += var15.field1607;
                           var17.field1605 += var10.field1605;
                           var17.field1608 += var10.field1608;
                           var17.field1606 += var10.field1606;
                           var17.field1607 += var10.field1607;
                           ++var6;
                           field1706[var9] = field1708;
                           field1707[var14] = field1708;
                        }
                     }
                  }
               }
            }
         }
      }

      if(var6 >= 3 && var5) {
         for(var9 = 0; var9 < var0.field1668; ++var9) {
            if(field1706[var0.field1701[var9]] == field1708 && field1706[var0.field1709[var9]] == field1708 && field1706[var0.field1671[var9]] == field1708) {
               if(var0.field1672 == null) {
                  var0.field1672 = new byte[var0.field1668];
               }

               var0.field1672[var9] = 2;
            }
         }

         for(var9 = 0; var9 < var1.field1668; ++var9) {
            if(field1707[var1.field1701[var9]] == field1708 && field1707[var1.field1709[var9]] == field1708 && field1707[var1.field1671[var9]] == field1708) {
               if(var1.field1672 == null) {
                  var1.field1672 = new byte[var1.field1668];
               }

               var1.field1672[var9] = 2;
            }
         }

      }
   }

   @ObfuscatedSignature(
      signature = "(Lclass100;ZZZZ)V",
      garbageValue = "1"
   )
   public class100(class100 var1, boolean var2, boolean var3, boolean var4, boolean var5) {
      this.field1669 = var1.field1669;
      this.field1668 = var1.field1668;
      this.field1664 = var1.field1664;
      int var6;
      if(var2) {
         this.field1665 = var1.field1665;
         this.field1666 = var1.field1666;
         this.field1667 = var1.field1667;
      } else {
         this.field1665 = new int[this.field1669];
         this.field1666 = new int[this.field1669];
         this.field1667 = new int[this.field1669];

         for(var6 = 0; var6 < this.field1669; ++var6) {
            this.field1665[var6] = var1.field1665[var6];
            this.field1666[var6] = var1.field1666[var6];
            this.field1667[var6] = var1.field1667[var6];
         }
      }

      if(var3) {
         this.field1677 = var1.field1677;
      } else {
         this.field1677 = new short[this.field1668];

         for(var6 = 0; var6 < this.field1668; ++var6) {
            this.field1677[var6] = var1.field1677[var6];
         }
      }

      if(!var4 && var1.field1705 != null) {
         this.field1705 = new short[this.field1668];

         for(var6 = 0; var6 < this.field1668; ++var6) {
            this.field1705[var6] = var1.field1705[var6];
         }
      } else {
         this.field1705 = var1.field1705;
      }

      this.field1674 = var1.field1674;
      this.field1701 = var1.field1701;
      this.field1709 = var1.field1709;
      this.field1671 = var1.field1671;
      this.field1672 = var1.field1672;
      this.field1673 = var1.field1673;
      this.field1678 = var1.field1678;
      this.field1688 = var1.field1688;
      this.field1680 = var1.field1680;
      this.field1681 = var1.field1681;
      this.field1695 = var1.field1695;
      this.field1683 = var1.field1683;
      this.field1684 = var1.field1684;
      this.field1685 = var1.field1685;
      this.field1686 = var1.field1686;
      this.field1687 = var1.field1687;
      this.field1690 = var1.field1690;
      this.field1682 = var1.field1682;
      this.field1689 = var1.field1689;
      this.field1691 = var1.field1691;
      this.field1692 = var1.field1692;
      this.field1693 = var1.field1693;
      this.field1694 = var1.field1694;
      this.field1703 = var1.field1703;
      this.field1675 = var1.field1675;
      this.field1697 = var1.field1697;
      this.field1698 = var1.field1698;
      this.field1699 = var1.field1699;
   }
}
