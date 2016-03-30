import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
public class class100 extends class85 {
   @ObfuscatedName("p")
   int[] field1700;
   @ObfuscatedName("x")
   int[] field1701;
   @ObfuscatedName("l")
   byte[] field1702;
   @ObfuscatedName("as")
   static int[] field1703;
   @ObfuscatedName("e")
   int field1704 = 0;
   @ObfuscatedName("y")
   int[] field1705;
   @ObfuscatedName("ay")
   int[][] field1706;
   @ObfuscatedName("c")
   int[] field1707;
   @ObfuscatedName("m")
   int[] field1708;
   @ObfuscatedName("r")
   short[] field1709;
   @ObfuscatedName("ar")
   int[] field1710;
   @ObfuscatedName("s")
   byte[] field1711;
   @ObfuscatedName("j")
   short[] field1712;
   @ObfuscatedName("q")
   short[] field1713;
   @ObfuscatedName("w")
   int field1714 = 0;
   @ObfuscatedName("d")
   int field1715;
   @ObfuscatedName("ag")
   int field1716;
   @ObfuscatedName("i")
   short[] field1717;
   @ObfuscatedName("o")
   short[] field1718;
   @ObfuscatedName("h")
   short[] field1719;
   @ObfuscatedName("k")
   short[] field1720;
   @ObfuscatedName("f")
   short[] field1721;
   @ObfuscatedName("n")
   short[] field1722;
   @ObfuscatedName("af")
   byte[] field1723;
   @ObfuscatedName("g")
   short[] field1724;
   @ObfuscatedName("b")
   short[] field1725;
   @ObfuscatedName("a")
   byte field1726 = 0;
   @ObfuscatedName("at")
   static int field1727 = 0;
   @ObfuscatedName("am")
   int[] field1728;
   @ObfuscatedName("ai")
   int[][] field1729;
   @ObfuscatedName("t")
   int[] field1730;
   @ObfuscatedName("ab")
   class84[] field1731;
   @ObfuscatedName("av")
   class96[] field1732;
   @ObfuscatedName("ac")
   class96[] field1733;
   @ObfuscatedName("ah")
   public short field1734;
   @ObfuscatedName("ae")
   public short field1735;
   @ObfuscatedName("aj")
   boolean field1736 = false;
   @ObfuscatedName("az")
   int field1737;
   @ObfuscatedName("al")
   int field1738;
   @ObfuscatedName("z")
   byte[] field1739;
   @ObfuscatedName("aw")
   static int[] field1740;
   @ObfuscatedName("v")
   byte[] field1741;
   @ObfuscatedName("ao")
   static int[] field1742 = new int[10000];
   @ObfuscatedName("ak")
   static int[] field1743 = new int[10000];
   @ObfuscatedName("au")
   int field1744;
   @ObfuscatedName("u")
   byte[] field1745;
   @ObfuscatedName("ad")
   int field1746;

   @ObfuscatedName("v")
   public void method2194() {
      for(int var1 = 0; var1 < this.field1714; ++var1) {
         int var2 = this.field1701[var1];
         this.field1701[var1] = this.field1700[var1];
         this.field1700[var1] = -var2;
      }

      this.method2209();
   }

   @ObfuscatedName("p")
   void method2195(byte[] var1) {
      boolean var2 = false;
      boolean var3 = false;
      class119 var4 = new class119(var1);
      class119 var5 = new class119(var1);
      class119 var6 = new class119(var1);
      class119 var7 = new class119(var1);
      class119 var8 = new class119(var1);
      var4.field2011 = var1.length - 18;
      int var9 = var4.method2508();
      int var10 = var4.method2508();
      int var11 = var4.method2506();
      int var12 = var4.method2506();
      int var13 = var4.method2506();
      int var14 = var4.method2506();
      int var15 = var4.method2506();
      int var16 = var4.method2506();
      int var17 = var4.method2508();
      int var18 = var4.method2508();
      int var19 = var4.method2508();
      int var20 = var4.method2508();
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
      this.field1714 = var9;
      this.field1704 = var10;
      this.field1715 = var11;
      this.field1701 = new int[var9];
      this.field1730 = new int[var9];
      this.field1700 = new int[var9];
      this.field1705 = new int[var10];
      this.field1708 = new int[var10];
      this.field1707 = new int[var10];
      if(var11 > 0) {
         this.field1745 = new byte[var11];
         this.field1717 = new short[var11];
         this.field1718 = new short[var11];
         this.field1719 = new short[var11];
      }

      if(var16 == 1) {
         this.field1728 = new int[var9];
      }

      if(var12 == 1) {
         this.field1741 = new byte[var10];
         this.field1711 = new byte[var10];
         this.field1713 = new short[var10];
      }

      if(var13 == 255) {
         this.field1702 = new byte[var10];
      } else {
         this.field1726 = (byte)var13;
      }

      if(var14 == 1) {
         this.field1739 = new byte[var10];
      }

      if(var15 == 1) {
         this.field1710 = new int[var10];
      }

      this.field1712 = new short[var10];
      var4.field2011 = var21;
      var5.field2011 = var32;
      var6.field2011 = var33;
      var7.field2011 = var45;
      var8.field2011 = var27;
      int var35 = 0;
      int var36 = 0;
      int var37 = 0;

      int var38;
      int var39;
      int var40;
      int var41;
      int var42;
      for(var38 = 0; var38 < var9; ++var38) {
         var39 = var4.method2506();
         var40 = 0;
         if((var39 & 1) != 0) {
            var40 = var5.method2518();
         }

         var41 = 0;
         if((var39 & 2) != 0) {
            var41 = var6.method2518();
         }

         var42 = 0;
         if((var39 & 4) != 0) {
            var42 = var7.method2518();
         }

         this.field1701[var38] = var35 + var40;
         this.field1730[var38] = var36 + var41;
         this.field1700[var38] = var37 + var42;
         var35 = this.field1701[var38];
         var36 = this.field1730[var38];
         var37 = this.field1700[var38];
         if(var16 == 1) {
            this.field1728[var38] = var8.method2506();
         }
      }

      var4.field2011 = var30;
      var5.field2011 = var26;
      var6.field2011 = var24;
      var7.field2011 = var28;
      var8.field2011 = var25;

      for(var38 = 0; var38 < var10; ++var38) {
         this.field1712[var38] = (short)var4.method2508();
         if(var12 == 1) {
            var39 = var5.method2506();
            if((var39 & 1) == 1) {
               this.field1741[var38] = 1;
               var2 = true;
            } else {
               this.field1741[var38] = 0;
            }

            if((var39 & 2) == 2) {
               this.field1711[var38] = (byte)(var39 >> 2);
               this.field1713[var38] = this.field1712[var38];
               this.field1712[var38] = 127;
               if(this.field1713[var38] != -1) {
                  var3 = true;
               }
            } else {
               this.field1711[var38] = -1;
               this.field1713[var38] = -1;
            }
         }

         if(var13 == 255) {
            this.field1702[var38] = var6.method2524();
         }

         if(var14 == 1) {
            this.field1739[var38] = var7.method2524();
         }

         if(var15 == 1) {
            this.field1710[var38] = var8.method2506();
         }
      }

      var4.field2011 = var29;
      var5.field2011 = var23;
      var38 = 0;
      var39 = 0;
      var40 = 0;
      var41 = 0;

      int var43;
      int var44;
      for(var42 = 0; var42 < var10; ++var42) {
         var43 = var5.method2506();
         if(var43 == 1) {
            var38 = var4.method2518() + var41;
            var39 = var4.method2518() + var38;
            var40 = var4.method2518() + var39;
            var41 = var40;
            this.field1705[var42] = var38;
            this.field1708[var42] = var39;
            this.field1707[var42] = var40;
         }

         if(var43 == 2) {
            var39 = var40;
            var40 = var4.method2518() + var41;
            var41 = var40;
            this.field1705[var42] = var38;
            this.field1708[var42] = var39;
            this.field1707[var42] = var40;
         }

         if(var43 == 3) {
            var38 = var40;
            var40 = var4.method2518() + var41;
            var41 = var40;
            this.field1705[var42] = var38;
            this.field1708[var42] = var39;
            this.field1707[var42] = var40;
         }

         if(var43 == 4) {
            var44 = var38;
            var38 = var39;
            var39 = var44;
            var40 = var4.method2518() + var41;
            var41 = var40;
            this.field1705[var42] = var38;
            this.field1708[var42] = var44;
            this.field1707[var42] = var40;
         }
      }

      var4.field2011 = var31;

      for(var42 = 0; var42 < var11; ++var42) {
         this.field1745[var42] = 0;
         this.field1717[var42] = (short)var4.method2508();
         this.field1718[var42] = (short)var4.method2508();
         this.field1719[var42] = (short)var4.method2508();
      }

      if(this.field1711 != null) {
         boolean var46 = false;

         for(var43 = 0; var43 < var10; ++var43) {
            var44 = this.field1711[var43] & 255;
            if(var44 != 255) {
               if((this.field1717[var44] & '\uffff') == this.field1705[var43] && (this.field1718[var44] & '\uffff') == this.field1708[var43] && (this.field1719[var44] & '\uffff') == this.field1707[var43]) {
                  this.field1711[var43] = -1;
               } else {
                  var46 = true;
               }
            }
         }

         if(!var46) {
            this.field1711 = null;
         }
      }

      if(!var3) {
         this.field1713 = null;
      }

      if(!var2) {
         this.field1741 = null;
      }

   }

   public class100(class100[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      boolean var8 = false;
      this.field1714 = 0;
      this.field1704 = 0;
      this.field1715 = 0;
      this.field1726 = -1;

      int var9;
      class100 var10;
      for(var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if(var10 != null) {
            this.field1714 += var10.field1714;
            this.field1704 += var10.field1704;
            this.field1715 += var10.field1715;
            if(var10.field1702 != null) {
               var4 = true;
            } else {
               if(this.field1726 == -1) {
                  this.field1726 = var10.field1726;
               }

               if(this.field1726 != var10.field1726) {
                  var4 = true;
               }
            }

            var3 |= var10.field1741 != null;
            var5 |= var10.field1739 != null;
            var6 |= var10.field1710 != null;
            var7 |= var10.field1713 != null;
            var8 |= var10.field1711 != null;
         }
      }

      this.field1701 = new int[this.field1714];
      this.field1730 = new int[this.field1714];
      this.field1700 = new int[this.field1714];
      this.field1728 = new int[this.field1714];
      this.field1705 = new int[this.field1704];
      this.field1708 = new int[this.field1704];
      this.field1707 = new int[this.field1704];
      if(var3) {
         this.field1741 = new byte[this.field1704];
      }

      if(var4) {
         this.field1702 = new byte[this.field1704];
      }

      if(var5) {
         this.field1739 = new byte[this.field1704];
      }

      if(var6) {
         this.field1710 = new int[this.field1704];
      }

      if(var7) {
         this.field1713 = new short[this.field1704];
      }

      if(var8) {
         this.field1711 = new byte[this.field1704];
      }

      this.field1712 = new short[this.field1704];
      if(this.field1715 > 0) {
         this.field1745 = new byte[this.field1715];
         this.field1717 = new short[this.field1715];
         this.field1718 = new short[this.field1715];
         this.field1719 = new short[this.field1715];
         this.field1720 = new short[this.field1715];
         this.field1721 = new short[this.field1715];
         this.field1709 = new short[this.field1715];
         this.field1722 = new short[this.field1715];
         this.field1723 = new byte[this.field1715];
         this.field1724 = new short[this.field1715];
         this.field1725 = new short[this.field1715];
      }

      this.field1714 = 0;
      this.field1704 = 0;
      this.field1715 = 0;

      for(var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if(var10 != null) {
            int var11;
            for(var11 = 0; var11 < var10.field1704; ++var11) {
               if(var3 && var10.field1741 != null) {
                  this.field1741[this.field1704] = var10.field1741[var11];
               }

               if(var4) {
                  if(var10.field1702 != null) {
                     this.field1702[this.field1704] = var10.field1702[var11];
                  } else {
                     this.field1702[this.field1704] = var10.field1726;
                  }
               }

               if(var5 && var10.field1739 != null) {
                  this.field1739[this.field1704] = var10.field1739[var11];
               }

               if(var6 && var10.field1710 != null) {
                  this.field1710[this.field1704] = var10.field1710[var11];
               }

               if(var7) {
                  if(var10.field1713 != null) {
                     this.field1713[this.field1704] = var10.field1713[var11];
                  } else {
                     this.field1713[this.field1704] = -1;
                  }
               }

               if(var8) {
                  if(var10.field1711 != null && var10.field1711[var11] != -1) {
                     this.field1711[this.field1704] = (byte)(var10.field1711[var11] + this.field1715);
                  } else {
                     this.field1711[this.field1704] = -1;
                  }
               }

               this.field1712[this.field1704] = var10.field1712[var11];
               this.field1705[this.field1704] = this.method2196(var10, var10.field1705[var11]);
               this.field1708[this.field1704] = this.method2196(var10, var10.field1708[var11]);
               this.field1707[this.field1704] = this.method2196(var10, var10.field1707[var11]);
               ++this.field1704;
            }

            for(var11 = 0; var11 < var10.field1715; ++var11) {
               byte var12 = this.field1745[this.field1715] = var10.field1745[var11];
               if(var12 == 0) {
                  this.field1717[this.field1715] = (short)this.method2196(var10, var10.field1717[var11]);
                  this.field1718[this.field1715] = (short)this.method2196(var10, var10.field1718[var11]);
                  this.field1719[this.field1715] = (short)this.method2196(var10, var10.field1719[var11]);
               }

               if(var12 >= 1 && var12 <= 3) {
                  this.field1717[this.field1715] = var10.field1717[var11];
                  this.field1718[this.field1715] = var10.field1718[var11];
                  this.field1719[this.field1715] = var10.field1719[var11];
                  this.field1720[this.field1715] = var10.field1720[var11];
                  this.field1721[this.field1715] = var10.field1721[var11];
                  this.field1709[this.field1715] = var10.field1709[var11];
                  this.field1722[this.field1715] = var10.field1722[var11];
                  this.field1723[this.field1715] = var10.field1723[var11];
                  this.field1724[this.field1715] = var10.field1724[var11];
               }

               if(var12 == 2) {
                  this.field1725[this.field1715] = var10.field1725[var11];
               }

               ++this.field1715;
            }
         }
      }

   }

   @ObfuscatedName("e")
   final int method2196(class100 var1, int var2) {
      int var3 = -1;
      int var4 = var1.field1701[var2];
      int var5 = var1.field1730[var2];
      int var6 = var1.field1700[var2];

      for(int var7 = 0; var7 < this.field1714; ++var7) {
         if(var4 == this.field1701[var7] && var5 == this.field1730[var7] && var6 == this.field1700[var7]) {
            var3 = var7;
            break;
         }
      }

      if(var3 == -1) {
         this.field1701[this.field1714] = var4;
         this.field1730[this.field1714] = var5;
         this.field1700[this.field1714] = var6;
         if(var1.field1728 != null) {
            this.field1728[this.field1714] = var1.field1728[var2];
         }

         var3 = this.field1714++;
      }

      return var3;
   }

   @ObfuscatedSignature(
      signature = "(Lclass100;ZZZZ)V",
      garbageValue = "1"
   )
   public class100(class100 var1, boolean var2, boolean var3, boolean var4, boolean var5) {
      this.field1714 = var1.field1714;
      this.field1704 = var1.field1704;
      this.field1715 = var1.field1715;
      int var6;
      if(var2) {
         this.field1701 = var1.field1701;
         this.field1730 = var1.field1730;
         this.field1700 = var1.field1700;
      } else {
         this.field1701 = new int[this.field1714];
         this.field1730 = new int[this.field1714];
         this.field1700 = new int[this.field1714];

         for(var6 = 0; var6 < this.field1714; ++var6) {
            this.field1701[var6] = var1.field1701[var6];
            this.field1730[var6] = var1.field1730[var6];
            this.field1700[var6] = var1.field1700[var6];
         }
      }

      if(var3) {
         this.field1712 = var1.field1712;
      } else {
         this.field1712 = new short[this.field1704];

         for(var6 = 0; var6 < this.field1704; ++var6) {
            this.field1712[var6] = var1.field1712[var6];
         }
      }

      if(!var4 && var1.field1713 != null) {
         this.field1713 = new short[this.field1704];

         for(var6 = 0; var6 < this.field1704; ++var6) {
            this.field1713[var6] = var1.field1713[var6];
         }
      } else {
         this.field1713 = var1.field1713;
      }

      this.field1739 = var1.field1739;
      this.field1705 = var1.field1705;
      this.field1708 = var1.field1708;
      this.field1707 = var1.field1707;
      this.field1741 = var1.field1741;
      this.field1702 = var1.field1702;
      this.field1711 = var1.field1711;
      this.field1726 = var1.field1726;
      this.field1745 = var1.field1745;
      this.field1717 = var1.field1717;
      this.field1718 = var1.field1718;
      this.field1719 = var1.field1719;
      this.field1720 = var1.field1720;
      this.field1721 = var1.field1721;
      this.field1709 = var1.field1709;
      this.field1722 = var1.field1722;
      this.field1723 = var1.field1723;
      this.field1724 = var1.field1724;
      this.field1725 = var1.field1725;
      this.field1728 = var1.field1728;
      this.field1710 = var1.field1710;
      this.field1706 = var1.field1706;
      this.field1729 = var1.field1729;
      this.field1732 = var1.field1732;
      this.field1731 = var1.field1731;
      this.field1733 = var1.field1733;
      this.field1734 = var1.field1734;
      this.field1735 = var1.field1735;
   }

   class100(byte[] var1) {
      if(var1[var1.length - 1] == -1 && var1[var1.length - 2] == -1) {
         this.method2267(var1);
      } else {
         this.method2195(var1);
      }

   }

   @ObfuscatedName("l")
   public void method2200() {
      for(int var1 = 0; var1 < this.field1714; ++var1) {
         this.field1701[var1] = -this.field1701[var1];
         this.field1700[var1] = -this.field1700[var1];
      }

      this.method2209();
   }

   @ObfuscatedName("z")
   public void method2201() {
      for(int var1 = 0; var1 < this.field1714; ++var1) {
         int var2 = this.field1700[var1];
         this.field1700[var1] = this.field1701[var1];
         this.field1701[var1] = -var2;
      }

      this.method2209();
   }

   @ObfuscatedName("s")
   public void method2202(int var1) {
      int var2 = field1740[var1];
      int var3 = field1703[var1];

      for(int var4 = 0; var4 < this.field1714; ++var4) {
         int var5 = this.field1700[var4] * var2 + this.field1701[var4] * var3 >> 16;
         this.field1700[var4] = this.field1700[var4] * var3 - this.field1701[var4] * var2 >> 16;
         this.field1701[var4] = var5;
      }

      this.method2209();
   }

   @ObfuscatedName("j")
   public void method2203(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1714; ++var4) {
         this.field1701[var4] += var1;
         this.field1730[var4] += var2;
         this.field1700[var4] += var3;
      }

      this.method2209();
   }

   @ObfuscatedName("c")
   void method2204() {
      int[] var1;
      int var2;
      int var3;
      int var4;
      if(this.field1728 != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.field1714; ++var3) {
            var4 = this.field1728[var3];
            ++var1[var4];
            if(var4 > var2) {
               var2 = var4;
            }
         }

         this.field1706 = new int[var2 + 1][];

         for(var3 = 0; var3 <= var2; ++var3) {
            this.field1706[var3] = new int[var1[var3]];
            var1[var3] = 0;
         }

         for(var3 = 0; var3 < this.field1714; this.field1706[var4][var1[var4]++] = var3++) {
            var4 = this.field1728[var3];
         }

         this.field1728 = null;
      }

      if(this.field1710 != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.field1704; ++var3) {
            var4 = this.field1710[var3];
            ++var1[var4];
            if(var4 > var2) {
               var2 = var4;
            }
         }

         this.field1729 = new int[var2 + 1][];

         for(var3 = 0; var3 <= var2; ++var3) {
            this.field1729[var3] = new int[var1[var3]];
            var1[var3] = 0;
         }

         for(var3 = 0; var3 < this.field1704; this.field1729[var4][var1[var4]++] = var3++) {
            var4 = this.field1710[var3];
         }

         this.field1710 = null;
      }

   }

   @ObfuscatedName("d")
   public void method2205(short var1, short var2) {
      if(this.field1713 != null) {
         for(int var3 = 0; var3 < this.field1704; ++var3) {
            if(this.field1713[var3] == var1) {
               this.field1713[var3] = var2;
            }
         }

      }
   }

   @ObfuscatedName("u")
   public void method2206() {
      int var1;
      for(var1 = 0; var1 < this.field1714; ++var1) {
         this.field1700[var1] = -this.field1700[var1];
      }

      for(var1 = 0; var1 < this.field1704; ++var1) {
         int var2 = this.field1705[var1];
         this.field1705[var1] = this.field1707[var1];
         this.field1707[var1] = var2;
      }

      this.method2209();
   }

   @ObfuscatedName("i")
   public void method2207(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1714; ++var4) {
         this.field1701[var4] = this.field1701[var4] * var1 / 128;
         this.field1730[var4] = this.field1730[var4] * var2 / 128;
         this.field1700[var4] = this.field1700[var4] * var3 / 128;
      }

      this.method2209();
   }

   @ObfuscatedName("h")
   void method2209() {
      this.field1732 = null;
      this.field1733 = null;
      this.field1731 = null;
      this.field1736 = false;
   }

   @ObfuscatedName("k")
   void method2210() {
      if(!this.field1736) {
         super.field1467 = 0;
         this.field1737 = 0;
         this.field1738 = 999999;
         this.field1716 = -999999;
         this.field1746 = -99999;
         this.field1744 = 99999;

         for(int var1 = 0; var1 < this.field1714; ++var1) {
            int var2 = this.field1701[var1];
            int var3 = this.field1730[var1];
            int var4 = this.field1700[var1];
            if(var2 < this.field1738) {
               this.field1738 = var2;
            }

            if(var2 > this.field1716) {
               this.field1716 = var2;
            }

            if(var4 < this.field1744) {
               this.field1744 = var4;
            }

            if(var4 > this.field1746) {
               this.field1746 = var4;
            }

            if(-var3 > super.field1467) {
               super.field1467 = -var3;
            }

            if(var3 > this.field1737) {
               this.field1737 = var3;
            }
         }

         this.field1736 = true;
      }
   }

   @ObfuscatedName("f")
   static void method2211(class100 var0, class100 var1, int var2, int var3, int var4, boolean var5) {
      var0.method2210();
      var0.method2262();
      var1.method2210();
      var1.method2262();
      ++field1727;
      int var6 = 0;
      int[] var7 = var1.field1701;
      int var8 = var1.field1714;

      int var9;
      for(var9 = 0; var9 < var0.field1714; ++var9) {
         class96 var10 = var0.field1732[var9];
         if(var10.field1641 != 0) {
            int var11 = var0.field1730[var9] - var3;
            if(var11 <= var1.field1737) {
               int var12 = var0.field1701[var9] - var2;
               if(var12 >= var1.field1738 && var12 <= var1.field1716) {
                  int var13 = var0.field1700[var9] - var4;
                  if(var13 >= var1.field1744 && var13 <= var1.field1746) {
                     for(int var14 = 0; var14 < var8; ++var14) {
                        class96 var15 = var1.field1732[var14];
                        if(var12 == var7[var14] && var13 == var1.field1700[var14] && var11 == var1.field1730[var14] && var15.field1641 != 0) {
                           if(var0.field1733 == null) {
                              var0.field1733 = new class96[var0.field1714];
                           }

                           if(var1.field1733 == null) {
                              var1.field1733 = new class96[var8];
                           }

                           class96 var16 = var0.field1733[var9];
                           if(var16 == null) {
                              var16 = var0.field1733[var9] = new class96(var10);
                           }

                           class96 var17 = var1.field1733[var14];
                           if(var17 == null) {
                              var17 = var1.field1733[var14] = new class96(var15);
                           }

                           var16.field1646 += var15.field1646;
                           var16.field1639 += var15.field1639;
                           var16.field1648 += var15.field1648;
                           var16.field1641 += var15.field1641;
                           var17.field1646 += var10.field1646;
                           var17.field1639 += var10.field1639;
                           var17.field1648 += var10.field1648;
                           var17.field1641 += var10.field1641;
                           ++var6;
                           field1742[var9] = field1727;
                           field1743[var14] = field1727;
                        }
                     }
                  }
               }
            }
         }
      }

      if(var6 >= 3 && var5) {
         for(var9 = 0; var9 < var0.field1704; ++var9) {
            if(field1742[var0.field1705[var9]] == field1727 && field1742[var0.field1708[var9]] == field1727 && field1742[var0.field1707[var9]] == field1727) {
               if(var0.field1741 == null) {
                  var0.field1741 = new byte[var0.field1704];
               }

               var0.field1741[var9] = 2;
            }
         }

         for(var9 = 0; var9 < var1.field1704; ++var9) {
            if(field1743[var1.field1705[var9]] == field1727 && field1743[var1.field1708[var9]] == field1727 && field1743[var1.field1707[var9]] == field1727) {
               if(var1.field1741 == null) {
                  var1.field1741 = new byte[var1.field1704];
               }

               var1.field1741[var9] = 2;
            }
         }

      }
   }

   @ObfuscatedName("r")
   public final class105 method2212(int var1, int var2, int var3, int var4, int var5) {
      this.method2262();
      int var6 = (int)Math.sqrt((double)(var3 * var3 + var4 * var4 + var5 * var5));
      int var7 = var2 * var6 >> 8;
      class105 var8 = new class105();
      var8.field1857 = new int[this.field1704];
      var8.field1822 = new int[this.field1704];
      var8.field1846 = new int[this.field1704];
      if(this.field1715 > 0 && this.field1711 != null) {
         int[] var9 = new int[this.field1715];

         int var10;
         for(var10 = 0; var10 < this.field1704; ++var10) {
            if(this.field1711[var10] != -1) {
               ++var9[this.field1711[var10] & 255];
            }
         }

         var8.field1867 = 0;

         for(var10 = 0; var10 < this.field1715; ++var10) {
            if(var9[var10] > 0 && this.field1745[var10] == 0) {
               ++var8.field1867;
            }
         }

         var8.field1814 = new int[var8.field1867];
         var8.field1831 = new int[var8.field1867];
         var8.field1848 = new int[var8.field1867];
         var10 = 0;

         int var11;
         for(var11 = 0; var11 < this.field1715; ++var11) {
            if(var9[var11] > 0 && this.field1745[var11] == 0) {
               var8.field1814[var10] = this.field1717[var11] & '\uffff';
               var8.field1831[var10] = this.field1718[var11] & '\uffff';
               var8.field1848[var10] = this.field1719[var11] & '\uffff';
               var9[var11] = var10++;
            } else {
               var9[var11] = -1;
            }
         }

         var8.field1826 = new byte[this.field1704];

         for(var11 = 0; var11 < this.field1704; ++var11) {
            if(this.field1711[var11] != -1) {
               var8.field1826[var11] = (byte)var9[this.field1711[var11] & 255];
            } else {
               var8.field1826[var11] = -1;
            }
         }
      }

      for(int var16 = 0; var16 < this.field1704; ++var16) {
         byte var17;
         if(this.field1741 == null) {
            var17 = 0;
         } else {
            var17 = this.field1741[var16];
         }

         byte var18;
         if(this.field1739 == null) {
            var18 = 0;
         } else {
            var18 = this.field1739[var16];
         }

         short var12;
         if(this.field1713 == null) {
            var12 = -1;
         } else {
            var12 = this.field1713[var16];
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
                  var19 = this.field1731[var16];
                  var14 = var1 + (var3 * var19.field1457 + var4 * var19.field1463 + var5 * var19.field1456) / (var7 + var7 / 2);
                  var8.field1857[var16] = method2213(this.field1712[var16] & '\uffff', var14);
                  var8.field1846[var16] = -1;
               } else if(var17 == 3) {
                  var8.field1857[var16] = 128;
                  var8.field1846[var16] = -1;
               } else {
                  var8.field1846[var16] = -2;
               }
            } else {
               int var15 = this.field1712[var16] & '\uffff';
               if(this.field1733 != null && this.field1733[this.field1705[var16]] != null) {
                  var13 = this.field1733[this.field1705[var16]];
               } else {
                  var13 = this.field1732[this.field1705[var16]];
               }

               var14 = var1 + (var3 * var13.field1646 + var4 * var13.field1639 + var5 * var13.field1648) / (var7 * var13.field1641);
               var8.field1857[var16] = method2213(var15, var14);
               if(this.field1733 != null && this.field1733[this.field1708[var16]] != null) {
                  var13 = this.field1733[this.field1708[var16]];
               } else {
                  var13 = this.field1732[this.field1708[var16]];
               }

               var14 = var1 + (var3 * var13.field1646 + var4 * var13.field1639 + var5 * var13.field1648) / (var7 * var13.field1641);
               var8.field1822[var16] = method2213(var15, var14);
               if(this.field1733 != null && this.field1733[this.field1707[var16]] != null) {
                  var13 = this.field1733[this.field1707[var16]];
               } else {
                  var13 = this.field1732[this.field1707[var16]];
               }

               var14 = var1 + (var3 * var13.field1646 + var4 * var13.field1639 + var5 * var13.field1648) / (var7 * var13.field1641);
               var8.field1846[var16] = method2213(var15, var14);
            }
         } else if(var17 != 0) {
            if(var17 == 1) {
               var19 = this.field1731[var16];
               var14 = var1 + (var3 * var19.field1457 + var4 * var19.field1463 + var5 * var19.field1456) / (var7 + var7 / 2);
               var8.field1857[var16] = method2231(var14);
               var8.field1846[var16] = -1;
            } else {
               var8.field1846[var16] = -2;
            }
         } else {
            if(this.field1733 != null && this.field1733[this.field1705[var16]] != null) {
               var13 = this.field1733[this.field1705[var16]];
            } else {
               var13 = this.field1732[this.field1705[var16]];
            }

            var14 = var1 + (var3 * var13.field1646 + var4 * var13.field1639 + var5 * var13.field1648) / (var7 * var13.field1641);
            var8.field1857[var16] = method2231(var14);
            if(this.field1733 != null && this.field1733[this.field1708[var16]] != null) {
               var13 = this.field1733[this.field1708[var16]];
            } else {
               var13 = this.field1732[this.field1708[var16]];
            }

            var14 = var1 + (var3 * var13.field1646 + var4 * var13.field1639 + var5 * var13.field1648) / (var7 * var13.field1641);
            var8.field1822[var16] = method2231(var14);
            if(this.field1733 != null && this.field1733[this.field1707[var16]] != null) {
               var13 = this.field1733[this.field1707[var16]];
            } else {
               var13 = this.field1732[this.field1707[var16]];
            }

            var14 = var1 + (var3 * var13.field1646 + var4 * var13.field1639 + var5 * var13.field1648) / (var7 * var13.field1641);
            var8.field1846[var16] = method2231(var14);
         }
      }

      this.method2204();
      var8.field1813 = this.field1714;
      var8.field1838 = this.field1701;
      var8.field1815 = this.field1730;
      var8.field1816 = this.field1700;
      var8.field1817 = this.field1704;
      var8.field1818 = this.field1705;
      var8.field1819 = this.field1708;
      var8.field1820 = this.field1707;
      var8.field1869 = this.field1702;
      var8.field1830 = this.field1739;
      var8.field1828 = this.field1726;
      var8.field1833 = this.field1706;
      var8.field1834 = this.field1729;
      var8.field1856 = this.field1713;
      return var8;
   }

   @ObfuscatedName("n")
   static final int method2213(int var0, int var1) {
      var1 = var1 * (var0 & 127) >> 7;
      if(var1 < 2) {
         var1 = 2;
      } else if(var1 > 126) {
         var1 = 126;
      }

      return (var0 & 'ﾀ') + var1;
   }

   @ObfuscatedName("w")
   public static class100 method2214(class167 var0, int var1, int var2) {
      byte[] var3 = var0.method3335(var1, var2);
      return var3 == null?null:new class100(var3);
   }

   static {
      field1740 = class91.field1573;
      field1703 = class91.field1595;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([[IIIIZI)Lclass100;",
      garbageValue = "1"
   )
   public class100 method2225(int[][] var1, int var2, int var3, int var4, int var5) {
      this.method2210();
      int var6 = var2 + this.field1738;
      int var7 = var2 + this.field1716;
      int var8 = var4 + this.field1744;
      int var9 = var4 + this.field1746;
      if(var6 >= 0 && var7 + 128 >> 7 < var1.length && var8 >= 0 && var9 + 128 >> 7 < var1[0].length) {
         var6 >>= 7;
         var7 = var7 + 127 >> 7;
         var8 >>= 7;
         var9 = var9 + 127 >> 7;
         if(var1[var6][var8] == var3 && var1[var7][var8] == var3 && var1[var6][var9] == var3 && var1[var7][var9] == var3) {
            return this;
         } else {
            class100 var10 = new class100();
            var10.field1714 = this.field1714;
            var10.field1704 = this.field1704;
            var10.field1715 = this.field1715;
            var10.field1701 = this.field1701;
            var10.field1700 = this.field1700;
            var10.field1705 = this.field1705;
            var10.field1708 = this.field1708;
            var10.field1707 = this.field1707;
            var10.field1741 = this.field1741;
            var10.field1702 = this.field1702;
            var10.field1739 = this.field1739;
            var10.field1711 = this.field1711;
            var10.field1712 = this.field1712;
            var10.field1713 = this.field1713;
            var10.field1726 = this.field1726;
            var10.field1745 = this.field1745;
            var10.field1717 = this.field1717;
            var10.field1718 = this.field1718;
            var10.field1719 = this.field1719;
            var10.field1720 = this.field1720;
            var10.field1721 = this.field1721;
            var10.field1709 = this.field1709;
            var10.field1722 = this.field1722;
            var10.field1723 = this.field1723;
            var10.field1724 = this.field1724;
            var10.field1725 = this.field1725;
            var10.field1728 = this.field1728;
            var10.field1710 = this.field1710;
            var10.field1706 = this.field1706;
            var10.field1729 = this.field1729;
            var10.field1734 = this.field1734;
            var10.field1735 = this.field1735;
            var10.field1730 = new int[var10.field1714];
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
               for(var11 = 0; var11 < var10.field1714; ++var11) {
                  var12 = this.field1701[var11] + var2;
                  var13 = this.field1700[var11] + var4;
                  var14 = var12 & 127;
                  var15 = var13 & 127;
                  var16 = var12 >> 7;
                  var17 = var13 >> 7;
                  var18 = var1[var16][var17] * (128 - var14) + var1[var16 + 1][var17] * var14 >> 7;
                  var19 = var1[var16][var17 + 1] * (128 - var14) + var1[var16 + 1][var17 + 1] * var14 >> 7;
                  var20 = var18 * (128 - var15) + var19 * var15 >> 7;
                  var10.field1730[var11] = this.field1730[var11] + var20 - var3;
               }
            } else {
               for(var11 = 0; var11 < var10.field1714; ++var11) {
                  var12 = (-this.field1730[var11] << 16) / super.field1467;
                  if(var12 < var5) {
                     var13 = this.field1701[var11] + var2;
                     var14 = this.field1700[var11] + var4;
                     var15 = var13 & 127;
                     var16 = var14 & 127;
                     var17 = var13 >> 7;
                     var18 = var14 >> 7;
                     var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                     var20 = var1[var17][var18 + 1] * (128 - var15) + var1[var17 + 1][var18 + 1] * var15 >> 7;
                     int var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                     var10.field1730[var11] = this.field1730[var11] + (var21 - var3) * (var5 - var12) / var5;
                  }
               }
            }

            var10.method2209();
            return var10;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("g")
   static final int method2231(int var0) {
      if(var0 < 2) {
         var0 = 2;
      } else if(var0 > 126) {
         var0 = 126;
      }

      return var0;
   }

   @ObfuscatedName("a")
   public void method2238(short var1, short var2) {
      for(int var3 = 0; var3 < this.field1704; ++var3) {
         if(this.field1712[var3] == var1) {
            this.field1712[var3] = var2;
         }
      }

   }

   class100() {
   }

   @ObfuscatedName("y")
   public class100 method2248() {
      class100 var1 = new class100();
      if(this.field1741 != null) {
         var1.field1741 = new byte[this.field1704];

         for(int var2 = 0; var2 < this.field1704; ++var2) {
            var1.field1741[var2] = this.field1741[var2];
         }
      }

      var1.field1714 = this.field1714;
      var1.field1704 = this.field1704;
      var1.field1715 = this.field1715;
      var1.field1701 = this.field1701;
      var1.field1730 = this.field1730;
      var1.field1700 = this.field1700;
      var1.field1705 = this.field1705;
      var1.field1708 = this.field1708;
      var1.field1707 = this.field1707;
      var1.field1702 = this.field1702;
      var1.field1739 = this.field1739;
      var1.field1711 = this.field1711;
      var1.field1712 = this.field1712;
      var1.field1713 = this.field1713;
      var1.field1726 = this.field1726;
      var1.field1745 = this.field1745;
      var1.field1717 = this.field1717;
      var1.field1718 = this.field1718;
      var1.field1719 = this.field1719;
      var1.field1720 = this.field1720;
      var1.field1721 = this.field1721;
      var1.field1709 = this.field1709;
      var1.field1722 = this.field1722;
      var1.field1723 = this.field1723;
      var1.field1724 = this.field1724;
      var1.field1725 = this.field1725;
      var1.field1728 = this.field1728;
      var1.field1710 = this.field1710;
      var1.field1706 = this.field1706;
      var1.field1729 = this.field1729;
      var1.field1732 = this.field1732;
      var1.field1731 = this.field1731;
      var1.field1734 = this.field1734;
      var1.field1735 = this.field1735;
      return var1;
   }

   @ObfuscatedName("o")
   public void method2262() {
      if(this.field1732 == null) {
         this.field1732 = new class96[this.field1714];

         int var1;
         for(var1 = 0; var1 < this.field1714; ++var1) {
            this.field1732[var1] = new class96();
         }

         for(var1 = 0; var1 < this.field1704; ++var1) {
            int var2 = this.field1705[var1];
            int var3 = this.field1708[var1];
            int var4 = this.field1707[var1];
            int var5 = this.field1701[var3] - this.field1701[var2];
            int var6 = this.field1730[var3] - this.field1730[var2];
            int var7 = this.field1700[var3] - this.field1700[var2];
            int var8 = this.field1701[var4] - this.field1701[var2];
            int var9 = this.field1730[var4] - this.field1730[var2];
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
            if(this.field1741 == null) {
               var15 = 0;
            } else {
               var15 = this.field1741[var1];
            }

            if(var15 == 0) {
               class96 var16 = this.field1732[var2];
               var16.field1646 += var11;
               var16.field1639 += var12;
               var16.field1648 += var13;
               ++var16.field1641;
               var16 = this.field1732[var3];
               var16.field1646 += var11;
               var16.field1639 += var12;
               var16.field1648 += var13;
               ++var16.field1641;
               var16 = this.field1732[var4];
               var16.field1646 += var11;
               var16.field1639 += var12;
               var16.field1648 += var13;
               ++var16.field1641;
            } else if(var15 == 1) {
               if(this.field1731 == null) {
                  this.field1731 = new class84[this.field1704];
               }

               class84 var17 = this.field1731[var1] = new class84();
               var17.field1457 = var11;
               var17.field1463 = var12;
               var17.field1456 = var13;
            }
         }

      }
   }

   @ObfuscatedName("x")
   void method2267(byte[] var1) {
      class119 var2 = new class119(var1);
      class119 var3 = new class119(var1);
      class119 var4 = new class119(var1);
      class119 var5 = new class119(var1);
      class119 var6 = new class119(var1);
      class119 var7 = new class119(var1);
      class119 var8 = new class119(var1);
      var2.field2011 = var1.length - 23;
      int var9 = var2.method2508();
      int var10 = var2.method2508();
      int var11 = var2.method2506();
      int var12 = var2.method2506();
      int var13 = var2.method2506();
      int var14 = var2.method2506();
      int var15 = var2.method2506();
      int var16 = var2.method2506();
      int var17 = var2.method2506();
      int var18 = var2.method2508();
      int var19 = var2.method2508();
      int var20 = var2.method2508();
      int var21 = var2.method2508();
      int var22 = var2.method2508();
      int var23 = 0;
      int var24 = 0;
      int var25 = 0;
      int var26;
      if(var11 > 0) {
         this.field1745 = new byte[var11];
         var2.field2011 = 0;

         for(var26 = 0; var26 < var11; ++var26) {
            byte var27 = this.field1745[var26] = var2.method2524();
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
      this.field1714 = var9;
      this.field1704 = var10;
      this.field1715 = var11;
      this.field1701 = new int[var9];
      this.field1730 = new int[var9];
      this.field1700 = new int[var9];
      this.field1705 = new int[var10];
      this.field1708 = new int[var10];
      this.field1707 = new int[var10];
      if(var17 == 1) {
         this.field1728 = new int[var9];
      }

      if(var12 == 1) {
         this.field1741 = new byte[var10];
      }

      if(var13 == 255) {
         this.field1702 = new byte[var10];
      } else {
         this.field1726 = (byte)var13;
      }

      if(var14 == 1) {
         this.field1739 = new byte[var10];
      }

      if(var15 == 1) {
         this.field1710 = new int[var10];
      }

      if(var16 == 1) {
         this.field1713 = new short[var10];
      }

      if(var16 == 1 && var11 > 0) {
         this.field1711 = new byte[var10];
      }

      this.field1712 = new short[var10];
      if(var11 > 0) {
         this.field1717 = new short[var11];
         this.field1718 = new short[var11];
         this.field1719 = new short[var11];
         if(var24 > 0) {
            this.field1720 = new short[var24];
            this.field1721 = new short[var24];
            this.field1709 = new short[var24];
            this.field1722 = new short[var24];
            this.field1723 = new byte[var24];
            this.field1724 = new short[var24];
         }

         if(var25 > 0) {
            this.field1725 = new short[var25];
         }
      }

      var2.field2011 = var11;
      var3.field2011 = var38;
      var4.field2011 = var39;
      var5.field2011 = var40;
      var6.field2011 = var32;
      int var48 = 0;
      int var49 = 0;
      int var50 = 0;

      int var51;
      int var52;
      int var53;
      int var54;
      int var55;
      for(var51 = 0; var51 < var9; ++var51) {
         var52 = var2.method2506();
         var53 = 0;
         if((var52 & 1) != 0) {
            var53 = var3.method2518();
         }

         var54 = 0;
         if((var52 & 2) != 0) {
            var54 = var4.method2518();
         }

         var55 = 0;
         if((var52 & 4) != 0) {
            var55 = var5.method2518();
         }

         this.field1701[var51] = var48 + var53;
         this.field1730[var51] = var49 + var54;
         this.field1700[var51] = var50 + var55;
         var48 = this.field1701[var51];
         var49 = this.field1730[var51];
         var50 = this.field1700[var51];
         if(var17 == 1) {
            this.field1728[var51] = var6.method2506();
         }
      }

      var2.field2011 = var37;
      var3.field2011 = var28;
      var4.field2011 = var30;
      var5.field2011 = var33;
      var6.field2011 = var31;
      var7.field2011 = var35;
      var8.field2011 = var36;

      for(var51 = 0; var51 < var10; ++var51) {
         this.field1712[var51] = (short)var2.method2508();
         if(var12 == 1) {
            this.field1741[var51] = var3.method2524();
         }

         if(var13 == 255) {
            this.field1702[var51] = var4.method2524();
         }

         if(var14 == 1) {
            this.field1739[var51] = var5.method2524();
         }

         if(var15 == 1) {
            this.field1710[var51] = var6.method2506();
         }

         if(var16 == 1) {
            this.field1713[var51] = (short)(var7.method2508() - 1);
         }

         if(this.field1711 != null && this.field1713[var51] != -1) {
            this.field1711[var51] = (byte)(var8.method2506() - 1);
         }
      }

      var2.field2011 = var34;
      var3.field2011 = var29;
      var51 = 0;
      var52 = 0;
      var53 = 0;
      var54 = 0;

      int var56;
      for(var55 = 0; var55 < var10; ++var55) {
         var56 = var3.method2506();
         if(var56 == 1) {
            var51 = var2.method2518() + var54;
            var52 = var2.method2518() + var51;
            var53 = var2.method2518() + var52;
            var54 = var53;
            this.field1705[var55] = var51;
            this.field1708[var55] = var52;
            this.field1707[var55] = var53;
         }

         if(var56 == 2) {
            var52 = var53;
            var53 = var2.method2518() + var54;
            var54 = var53;
            this.field1705[var55] = var51;
            this.field1708[var55] = var52;
            this.field1707[var55] = var53;
         }

         if(var56 == 3) {
            var51 = var53;
            var53 = var2.method2518() + var54;
            var54 = var53;
            this.field1705[var55] = var51;
            this.field1708[var55] = var52;
            this.field1707[var55] = var53;
         }

         if(var56 == 4) {
            int var57 = var51;
            var51 = var52;
            var52 = var57;
            var53 = var2.method2518() + var54;
            var54 = var53;
            this.field1705[var55] = var51;
            this.field1708[var55] = var57;
            this.field1707[var55] = var53;
         }
      }

      var2.field2011 = var41;
      var3.field2011 = var42;
      var4.field2011 = var43;
      var5.field2011 = var44;
      var6.field2011 = var45;
      var7.field2011 = var46;

      for(var55 = 0; var55 < var11; ++var55) {
         var56 = this.field1745[var55] & 255;
         if(var56 == 0) {
            this.field1717[var55] = (short)var2.method2508();
            this.field1718[var55] = (short)var2.method2508();
            this.field1719[var55] = (short)var2.method2508();
         }

         if(var56 == 1) {
            this.field1717[var55] = (short)var3.method2508();
            this.field1718[var55] = (short)var3.method2508();
            this.field1719[var55] = (short)var3.method2508();
            this.field1720[var55] = (short)var4.method2508();
            this.field1721[var55] = (short)var4.method2508();
            this.field1709[var55] = (short)var4.method2508();
            this.field1722[var55] = (short)var5.method2508();
            this.field1723[var55] = var6.method2524();
            this.field1724[var55] = (short)var7.method2508();
         }

         if(var56 == 2) {
            this.field1717[var55] = (short)var3.method2508();
            this.field1718[var55] = (short)var3.method2508();
            this.field1719[var55] = (short)var3.method2508();
            this.field1720[var55] = (short)var4.method2508();
            this.field1721[var55] = (short)var4.method2508();
            this.field1709[var55] = (short)var4.method2508();
            this.field1722[var55] = (short)var5.method2508();
            this.field1723[var55] = var6.method2524();
            this.field1724[var55] = (short)var7.method2508();
            this.field1725[var55] = (short)var7.method2508();
         }

         if(var56 == 3) {
            this.field1717[var55] = (short)var3.method2508();
            this.field1718[var55] = (short)var3.method2508();
            this.field1719[var55] = (short)var3.method2508();
            this.field1720[var55] = (short)var4.method2508();
            this.field1721[var55] = (short)var4.method2508();
            this.field1709[var55] = (short)var4.method2508();
            this.field1722[var55] = (short)var5.method2508();
            this.field1723[var55] = var6.method2524();
            this.field1724[var55] = (short)var7.method2508();
         }
      }

      var2.field2011 = var26;
      var55 = var2.method2506();
      if(var55 != 0) {
         new class90();
         var2.method2508();
         var2.method2508();
         var2.method2508();
         var2.method2511();
      }

   }
}
