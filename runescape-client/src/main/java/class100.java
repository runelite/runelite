import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("ModelData")
public class class100 extends class85 {
   @ObfuscatedName("av")
   static int[] field1665 = new int[10000];
   @ObfuscatedName("d")
   int[] field1666;
   @ObfuscatedName("aj")
   int[][] field1667;
   @ObfuscatedName("h")
   short[] field1668;
   @ObfuscatedName("x")
   int field1669 = 0;
   @ObfuscatedName("y")
   int[] field1670;
   @ObfuscatedName("r")
   int[] field1671;
   @ObfuscatedName("c")
   int[] field1672;
   @ObfuscatedName("l")
   byte[] field1673;
   @ObfuscatedName("aa")
   int field1674;
   @ObfuscatedName("p")
   byte[] field1675;
   @ObfuscatedName("f")
   short[] field1676;
   @ObfuscatedName("s")
   short[] field1677;
   @ObfuscatedName("z")
   short[] field1678;
   @ObfuscatedName("w")
   short[] field1679;
   @ObfuscatedName("o")
   int field1680;
   @ObfuscatedName("t")
   byte[] field1681;
   @ObfuscatedName("at")
   static int field1682 = 0;
   @ObfuscatedName("v")
   short[] field1683;
   @ObfuscatedName("a")
   short[] field1684;
   @ObfuscatedName("g")
   int[] field1685;
   @ObfuscatedName("q")
   short[] field1686;
   @ObfuscatedName("m")
   short[] field1687;
   @ObfuscatedName("n")
   byte[] field1688;
   @ObfuscatedName("i")
   short[] field1689;
   @ObfuscatedName("e")
   short[] field1690;
   @ObfuscatedName("aw")
   byte[] field1691;
   @ObfuscatedName("an")
   int[] field1692;
   @ObfuscatedName("ag")
   int[] field1693;
   @ObfuscatedName("ah")
   class84[] field1694;
   @ObfuscatedName("u")
   byte[] field1695;
   @ObfuscatedName("ae")
   int[][] field1696;
   @ObfuscatedName("af")
   class96[] field1697;
   @ObfuscatedName("az")
   class96[] field1698;
   @ObfuscatedName("ax")
   public short field1699;
   @ObfuscatedName("ac")
   public short field1700;
   @ObfuscatedName("ar")
   boolean field1701 = false;
   @ObfuscatedName("k")
   byte field1702 = 0;
   @ObfuscatedName("b")
   int field1703 = 0;
   @ObfuscatedName("ay")
   int field1704;
   @ObfuscatedName("as")
   int field1705;
   @ObfuscatedName("ak")
   int field1706;
   @ObfuscatedName("au")
   static int[] field1707 = new int[10000];
   @ObfuscatedName("aq")
   int field1708;
   @ObfuscatedName("j")
   int[] field1709;
   @ObfuscatedName("am")
   static int[] field1710;
   @ObfuscatedName("ab")
   static int[] field1711;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass167;II)Lclass100;",
      garbageValue = "0"
   )
   public static class100 method2208(class167 var0, int var1, int var2) {
      byte[] var3 = var0.method3266(var1, var2);
      return var3 == null?null:new class100(var3);
   }

   class100(byte[] var1) {
      if(var1[var1.length - 1] == -1 && var1[var1.length - 2] == -1) {
         this.method2263(var1);
      } else {
         this.method2210(var1);
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "256"
   )
   public void method2209(int var1) {
      int var2 = field1710[var1];
      int var3 = field1711[var1];

      for(int var4 = 0; var4 < this.field1703; ++var4) {
         int var5 = this.field1666[var4] * var2 + this.field1685[var4] * var3 >> 16;
         this.field1666[var4] = this.field1666[var4] * var3 - this.field1685[var4] * var2 >> 16;
         this.field1685[var4] = var5;
      }

      this.method2240();
   }

   @ObfuscatedName("d")
   void method2210(byte[] var1) {
      boolean var2 = false;
      boolean var3 = false;
      class119 var4 = new class119(var1);
      class119 var5 = new class119(var1);
      class119 var6 = new class119(var1);
      class119 var7 = new class119(var1);
      class119 var8 = new class119(var1);
      var4.field1976 = var1.length - 18;
      int var9 = var4.method2516();
      int var10 = var4.method2516();
      int var11 = var4.method2514();
      int var12 = var4.method2514();
      int var13 = var4.method2514();
      int var14 = var4.method2514();
      int var15 = var4.method2514();
      int var16 = var4.method2514();
      int var17 = var4.method2516();
      int var18 = var4.method2516();
      int var19 = var4.method2516();
      int var20 = var4.method2516();
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
      this.field1703 = var9;
      this.field1669 = var10;
      this.field1680 = var11;
      this.field1685 = new int[var9];
      this.field1709 = new int[var9];
      this.field1666 = new int[var9];
      this.field1670 = new int[var10];
      this.field1671 = new int[var10];
      this.field1672 = new int[var10];
      if(var11 > 0) {
         this.field1681 = new byte[var11];
         this.field1668 = new short[var11];
         this.field1683 = new short[var11];
         this.field1684 = new short[var11];
      }

      if(var16 == 1) {
         this.field1692 = new int[var9];
      }

      if(var12 == 1) {
         this.field1673 = new byte[var10];
         this.field1688 = new byte[var10];
         this.field1678 = new short[var10];
      }

      if(var13 == 255) {
         this.field1695 = new byte[var10];
      } else {
         this.field1702 = (byte)var13;
      }

      if(var14 == 1) {
         this.field1675 = new byte[var10];
      }

      if(var15 == 1) {
         this.field1693 = new int[var10];
      }

      this.field1679 = new short[var10];
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
         var39 = var4.method2514();
         var40 = 0;
         if((var39 & 1) != 0) {
            var40 = var5.method2689();
         }

         var41 = 0;
         if((var39 & 2) != 0) {
            var41 = var6.method2689();
         }

         var42 = 0;
         if((var39 & 4) != 0) {
            var42 = var7.method2689();
         }

         this.field1685[var38] = var35 + var40;
         this.field1709[var38] = var36 + var41;
         this.field1666[var38] = var37 + var42;
         var35 = this.field1685[var38];
         var36 = this.field1709[var38];
         var37 = this.field1666[var38];
         if(var16 == 1) {
            this.field1692[var38] = var8.method2514();
         }
      }

      var4.field1976 = var30;
      var5.field1976 = var26;
      var6.field1976 = var24;
      var7.field1976 = var28;
      var8.field1976 = var25;

      for(var38 = 0; var38 < var10; ++var38) {
         this.field1679[var38] = (short)var4.method2516();
         if(var12 == 1) {
            var39 = var5.method2514();
            if((var39 & 1) == 1) {
               this.field1673[var38] = 1;
               var2 = true;
            } else {
               this.field1673[var38] = 0;
            }

            if((var39 & 2) == 2) {
               this.field1688[var38] = (byte)(var39 >> 2);
               this.field1678[var38] = this.field1679[var38];
               this.field1679[var38] = 127;
               if(this.field1678[var38] != -1) {
                  var3 = true;
               }
            } else {
               this.field1688[var38] = -1;
               this.field1678[var38] = -1;
            }
         }

         if(var13 == 255) {
            this.field1695[var38] = var6.method2515();
         }

         if(var14 == 1) {
            this.field1675[var38] = var7.method2515();
         }

         if(var15 == 1) {
            this.field1693[var38] = var8.method2514();
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
         var43 = var5.method2514();
         if(var43 == 1) {
            var38 = var4.method2689() + var41;
            var39 = var4.method2689() + var38;
            var40 = var4.method2689() + var39;
            var41 = var40;
            this.field1670[var42] = var38;
            this.field1671[var42] = var39;
            this.field1672[var42] = var40;
         }

         if(var43 == 2) {
            var39 = var40;
            var40 = var4.method2689() + var41;
            var41 = var40;
            this.field1670[var42] = var38;
            this.field1671[var42] = var39;
            this.field1672[var42] = var40;
         }

         if(var43 == 3) {
            var38 = var40;
            var40 = var4.method2689() + var41;
            var41 = var40;
            this.field1670[var42] = var38;
            this.field1671[var42] = var39;
            this.field1672[var42] = var40;
         }

         if(var43 == 4) {
            var44 = var38;
            var38 = var39;
            var39 = var44;
            var40 = var4.method2689() + var41;
            var41 = var40;
            this.field1670[var42] = var38;
            this.field1671[var42] = var44;
            this.field1672[var42] = var40;
         }
      }

      var4.field1976 = var31;

      for(var42 = 0; var42 < var11; ++var42) {
         this.field1681[var42] = 0;
         this.field1668[var42] = (short)var4.method2516();
         this.field1683[var42] = (short)var4.method2516();
         this.field1684[var42] = (short)var4.method2516();
      }

      if(this.field1688 != null) {
         boolean var46 = false;

         for(var43 = 0; var43 < var10; ++var43) {
            var44 = this.field1688[var43] & 255;
            if(var44 != 255) {
               if((this.field1668[var44] & '\uffff') == this.field1670[var43] && (this.field1683[var44] & '\uffff') == this.field1671[var43] && (this.field1684[var44] & '\uffff') == this.field1672[var43]) {
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
         this.field1673 = null;
      }

   }

   public class100(class100[] var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      boolean var8 = false;
      this.field1703 = 0;
      this.field1669 = 0;
      this.field1680 = 0;
      this.field1702 = -1;

      int var9;
      class100 var10;
      for(var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if(var10 != null) {
            this.field1703 += var10.field1703;
            this.field1669 += var10.field1669;
            this.field1680 += var10.field1680;
            if(var10.field1695 != null) {
               var4 = true;
            } else {
               if(this.field1702 == -1) {
                  this.field1702 = var10.field1702;
               }

               if(this.field1702 != var10.field1702) {
                  var4 = true;
               }
            }

            var3 |= var10.field1673 != null;
            var5 |= var10.field1675 != null;
            var6 |= var10.field1693 != null;
            var7 |= var10.field1678 != null;
            var8 |= var10.field1688 != null;
         }
      }

      this.field1685 = new int[this.field1703];
      this.field1709 = new int[this.field1703];
      this.field1666 = new int[this.field1703];
      this.field1692 = new int[this.field1703];
      this.field1670 = new int[this.field1669];
      this.field1671 = new int[this.field1669];
      this.field1672 = new int[this.field1669];
      if(var3) {
         this.field1673 = new byte[this.field1669];
      }

      if(var4) {
         this.field1695 = new byte[this.field1669];
      }

      if(var5) {
         this.field1675 = new byte[this.field1669];
      }

      if(var6) {
         this.field1693 = new int[this.field1669];
      }

      if(var7) {
         this.field1678 = new short[this.field1669];
      }

      if(var8) {
         this.field1688 = new byte[this.field1669];
      }

      this.field1679 = new short[this.field1669];
      if(this.field1680 > 0) {
         this.field1681 = new byte[this.field1680];
         this.field1668 = new short[this.field1680];
         this.field1683 = new short[this.field1680];
         this.field1684 = new short[this.field1680];
         this.field1676 = new short[this.field1680];
         this.field1686 = new short[this.field1680];
         this.field1687 = new short[this.field1680];
         this.field1677 = new short[this.field1680];
         this.field1691 = new byte[this.field1680];
         this.field1689 = new short[this.field1680];
         this.field1690 = new short[this.field1680];
      }

      this.field1703 = 0;
      this.field1669 = 0;
      this.field1680 = 0;

      for(var9 = 0; var9 < var2; ++var9) {
         var10 = var1[var9];
         if(var10 != null) {
            int var11;
            for(var11 = 0; var11 < var10.field1669; ++var11) {
               if(var3 && var10.field1673 != null) {
                  this.field1673[this.field1669] = var10.field1673[var11];
               }

               if(var4) {
                  if(var10.field1695 != null) {
                     this.field1695[this.field1669] = var10.field1695[var11];
                  } else {
                     this.field1695[this.field1669] = var10.field1702;
                  }
               }

               if(var5 && var10.field1675 != null) {
                  this.field1675[this.field1669] = var10.field1675[var11];
               }

               if(var6 && var10.field1693 != null) {
                  this.field1693[this.field1669] = var10.field1693[var11];
               }

               if(var7) {
                  if(var10.field1678 != null) {
                     this.field1678[this.field1669] = var10.field1678[var11];
                  } else {
                     this.field1678[this.field1669] = -1;
                  }
               }

               if(var8) {
                  if(var10.field1688 != null && var10.field1688[var11] != -1) {
                     this.field1688[this.field1669] = (byte)(var10.field1688[var11] + this.field1680);
                  } else {
                     this.field1688[this.field1669] = -1;
                  }
               }

               this.field1679[this.field1669] = var10.field1679[var11];
               this.field1670[this.field1669] = this.method2254(var10, var10.field1670[var11]);
               this.field1671[this.field1669] = this.method2254(var10, var10.field1671[var11]);
               this.field1672[this.field1669] = this.method2254(var10, var10.field1672[var11]);
               ++this.field1669;
            }

            for(var11 = 0; var11 < var10.field1680; ++var11) {
               byte var12 = this.field1681[this.field1680] = var10.field1681[var11];
               if(var12 == 0) {
                  this.field1668[this.field1680] = (short)this.method2254(var10, var10.field1668[var11]);
                  this.field1683[this.field1680] = (short)this.method2254(var10, var10.field1683[var11]);
                  this.field1684[this.field1680] = (short)this.method2254(var10, var10.field1684[var11]);
               }

               if(var12 >= 1 && var12 <= 3) {
                  this.field1668[this.field1680] = var10.field1668[var11];
                  this.field1683[this.field1680] = var10.field1683[var11];
                  this.field1684[this.field1680] = var10.field1684[var11];
                  this.field1676[this.field1680] = var10.field1676[var11];
                  this.field1686[this.field1680] = var10.field1686[var11];
                  this.field1687[this.field1680] = var10.field1687[var11];
                  this.field1677[this.field1680] = var10.field1677[var11];
                  this.field1691[this.field1680] = var10.field1691[var11];
                  this.field1689[this.field1680] = var10.field1689[var11];
               }

               if(var12 == 2) {
                  this.field1690[this.field1680] = var10.field1690[var11];
               }

               ++this.field1680;
            }
         }
      }

   }

   @ObfuscatedName("v")
   @Export("computeNormals")
   public void method2212() {
      if(this.field1697 == null) {
         this.field1697 = new class96[this.field1703];

         int var1;
         for(var1 = 0; var1 < this.field1703; ++var1) {
            this.field1697[var1] = new class96();
         }

         for(var1 = 0; var1 < this.field1669; ++var1) {
            int var2 = this.field1670[var1];
            int var3 = this.field1671[var1];
            int var4 = this.field1672[var1];
            int var5 = this.field1685[var3] - this.field1685[var2];
            int var6 = this.field1709[var3] - this.field1709[var2];
            int var7 = this.field1666[var3] - this.field1666[var2];
            int var8 = this.field1685[var4] - this.field1685[var2];
            int var9 = this.field1709[var4] - this.field1709[var2];
            int var10 = this.field1666[var4] - this.field1666[var2];
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
            if(this.field1673 == null) {
               var15 = 0;
            } else {
               var15 = this.field1673[var1];
            }

            if(var15 == 0) {
               class96 var16 = this.field1697[var2];
               var16.field1605 += var11;
               var16.field1601 += var12;
               var16.field1602 += var13;
               ++var16.field1600;
               var16 = this.field1697[var3];
               var16.field1605 += var11;
               var16.field1601 += var12;
               var16.field1602 += var13;
               ++var16.field1600;
               var16 = this.field1697[var4];
               var16.field1605 += var11;
               var16.field1601 += var12;
               var16.field1602 += var13;
               ++var16.field1600;
            } else if(var15 == 1) {
               if(this.field1694 == null) {
                  this.field1694 = new class84[this.field1669];
               }

               class84 var17 = this.field1694[var1] = new class84();
               var17.field1425 = var11;
               var17.field1426 = var12;
               var17.field1424 = var13;
            }
         }

      }
   }

   @ObfuscatedName("y")
   public class100 method2213() {
      class100 var1 = new class100();
      if(this.field1673 != null) {
         var1.field1673 = new byte[this.field1669];

         for(int var2 = 0; var2 < this.field1669; ++var2) {
            var1.field1673[var2] = this.field1673[var2];
         }
      }

      var1.field1703 = this.field1703;
      var1.field1669 = this.field1669;
      var1.field1680 = this.field1680;
      var1.field1685 = this.field1685;
      var1.field1709 = this.field1709;
      var1.field1666 = this.field1666;
      var1.field1670 = this.field1670;
      var1.field1671 = this.field1671;
      var1.field1672 = this.field1672;
      var1.field1695 = this.field1695;
      var1.field1675 = this.field1675;
      var1.field1688 = this.field1688;
      var1.field1679 = this.field1679;
      var1.field1678 = this.field1678;
      var1.field1702 = this.field1702;
      var1.field1681 = this.field1681;
      var1.field1668 = this.field1668;
      var1.field1683 = this.field1683;
      var1.field1684 = this.field1684;
      var1.field1676 = this.field1676;
      var1.field1686 = this.field1686;
      var1.field1687 = this.field1687;
      var1.field1677 = this.field1677;
      var1.field1691 = this.field1691;
      var1.field1689 = this.field1689;
      var1.field1690 = this.field1690;
      var1.field1692 = this.field1692;
      var1.field1693 = this.field1693;
      var1.field1696 = this.field1696;
      var1.field1667 = this.field1667;
      var1.field1697 = this.field1697;
      var1.field1694 = this.field1694;
      var1.field1699 = this.field1699;
      var1.field1700 = this.field1700;
      return var1;
   }

   @ObfuscatedName("r")
   public class100 method2214(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
      this.method2237();
      int var7 = var2 + this.field1674;
      int var8 = var2 + this.field1704;
      int var9 = var4 + this.field1706;
      int var10 = var4 + this.field1705;
      if(var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
         var7 >>= 7;
         var8 = var8 + 127 >> 7;
         var9 >>= 7;
         var10 = var10 + 127 >> 7;
         if(var1[var7][var9] == var3 && var1[var8][var9] == var3 && var1[var7][var10] == var3 && var1[var8][var10] == var3) {
            return this;
         } else {
            class100 var11 = new class100();
            var11.field1703 = this.field1703;
            var11.field1669 = this.field1669;
            var11.field1680 = this.field1680;
            var11.field1685 = this.field1685;
            var11.field1666 = this.field1666;
            var11.field1670 = this.field1670;
            var11.field1671 = this.field1671;
            var11.field1672 = this.field1672;
            var11.field1673 = this.field1673;
            var11.field1695 = this.field1695;
            var11.field1675 = this.field1675;
            var11.field1688 = this.field1688;
            var11.field1679 = this.field1679;
            var11.field1678 = this.field1678;
            var11.field1702 = this.field1702;
            var11.field1681 = this.field1681;
            var11.field1668 = this.field1668;
            var11.field1683 = this.field1683;
            var11.field1684 = this.field1684;
            var11.field1676 = this.field1676;
            var11.field1686 = this.field1686;
            var11.field1687 = this.field1687;
            var11.field1677 = this.field1677;
            var11.field1691 = this.field1691;
            var11.field1689 = this.field1689;
            var11.field1690 = this.field1690;
            var11.field1692 = this.field1692;
            var11.field1693 = this.field1693;
            var11.field1696 = this.field1696;
            var11.field1667 = this.field1667;
            var11.field1699 = this.field1699;
            var11.field1700 = this.field1700;
            var11.field1709 = new int[var11.field1703];
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
               for(var12 = 0; var12 < var11.field1703; ++var12) {
                  var13 = this.field1685[var12] + var2;
                  var14 = this.field1666[var12] + var4;
                  var15 = var13 & 127;
                  var16 = var14 & 127;
                  var17 = var13 >> 7;
                  var18 = var14 >> 7;
                  var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
                  var20 = var1[var17][var18 + 1] * (128 - var15) + var1[var17 + 1][var18 + 1] * var15 >> 7;
                  var21 = var19 * (128 - var16) + var20 * var16 >> 7;
                  var11.field1709[var12] = this.field1709[var12] + var21 - var3;
               }
            } else {
               for(var12 = 0; var12 < var11.field1703; ++var12) {
                  var13 = (-this.field1709[var12] << 16) / super.field1436;
                  if(var13 < var6) {
                     var14 = this.field1685[var12] + var2;
                     var15 = this.field1666[var12] + var4;
                     var16 = var14 & 127;
                     var17 = var15 & 127;
                     var18 = var14 >> 7;
                     var19 = var15 >> 7;
                     var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
                     var21 = var1[var18][var19 + 1] * (128 - var16) + var1[var18 + 1][var19 + 1] * var16 >> 7;
                     int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
                     var11.field1709[var12] = this.field1709[var12] + (var22 - var3) * (var6 - var13) / var6;
                  }
               }
            }

            var11.method2240();
            return var11;
         }
      } else {
         return this;
      }
   }

   @ObfuscatedName("c")
   @Export("computeAnimationTables")
   void method2215() {
      int[] var1;
      int var2;
      int var3;
      int var4;
      if(this.field1692 != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.field1703; ++var3) {
            var4 = this.field1692[var3];
            ++var1[var4];
            if(var4 > var2) {
               var2 = var4;
            }
         }

         this.field1696 = new int[var2 + 1][];

         for(var3 = 0; var3 <= var2; ++var3) {
            this.field1696[var3] = new int[var1[var3]];
            var1[var3] = 0;
         }

         for(var3 = 0; var3 < this.field1703; this.field1696[var4][var1[var4]++] = var3++) {
            var4 = this.field1692[var3];
         }

         this.field1692 = null;
      }

      if(this.field1693 != null) {
         var1 = new int[256];
         var2 = 0;

         for(var3 = 0; var3 < this.field1669; ++var3) {
            var4 = this.field1693[var3];
            ++var1[var4];
            if(var4 > var2) {
               var2 = var4;
            }
         }

         this.field1667 = new int[var2 + 1][];

         for(var3 = 0; var3 <= var2; ++var3) {
            this.field1667[var3] = new int[var1[var3]];
            var1[var3] = 0;
         }

         for(var3 = 0; var3 < this.field1669; this.field1667[var4][var1[var4]++] = var3++) {
            var4 = this.field1693[var3];
         }

         this.field1693 = null;
      }

   }

   @ObfuscatedName("l")
   public void method2216() {
      for(int var1 = 0; var1 < this.field1703; ++var1) {
         int var2 = this.field1685[var1];
         this.field1685[var1] = this.field1666[var1];
         this.field1666[var1] = -var2;
      }

      this.method2240();
   }

   @ObfuscatedName("u")
   public void method2217() {
      for(int var1 = 0; var1 < this.field1703; ++var1) {
         this.field1685[var1] = -this.field1685[var1];
         this.field1666[var1] = -this.field1666[var1];
      }

      this.method2240();
   }

   @ObfuscatedName("p")
   public void method2218() {
      for(int var1 = 0; var1 < this.field1703; ++var1) {
         int var2 = this.field1666[var1];
         this.field1666[var1] = this.field1685[var1];
         this.field1685[var1] = -var2;
      }

      this.method2240();
   }

   @ObfuscatedName("z")
   public void method2220(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1703; ++var4) {
         this.field1685[var4] += var1;
         this.field1709[var4] += var2;
         this.field1666[var4] += var3;
      }

      this.method2240();
   }

   @ObfuscatedName("k")
   public void method2221(short var1, short var2) {
      for(int var3 = 0; var3 < this.field1669; ++var3) {
         if(this.field1679[var3] == var1) {
            this.field1679[var3] = var2;
         }
      }

   }

   @ObfuscatedName("o")
   public void method2222(short var1, short var2) {
      if(this.field1678 != null) {
         for(int var3 = 0; var3 < this.field1669; ++var3) {
            if(this.field1678[var3] == var1) {
               this.field1678[var3] = var2;
            }
         }

      }
   }

   @ObfuscatedName("t")
   public void method2223() {
      int var1;
      for(var1 = 0; var1 < this.field1703; ++var1) {
         this.field1666[var1] = -this.field1666[var1];
      }

      for(var1 = 0; var1 < this.field1669; ++var1) {
         int var2 = this.field1670[var1];
         this.field1670[var1] = this.field1672[var1];
         this.field1672[var1] = var2;
      }

      this.method2240();
   }

   @ObfuscatedName("s")
   static final int method2227(int var0, int var1) {
      var1 = var1 * (var0 & 127) >> 7;
      if(var1 < 2) {
         var1 = 2;
      } else if(var1 > 126) {
         var1 = 126;
      }

      return (var0 & 'ﾀ') + var1;
   }

   @ObfuscatedName("m")
   public final class105 method2229(int var1, int var2, int var3, int var4, int var5) {
      this.method2212();
      int var6 = (int)Math.sqrt((double)(var3 * var3 + var4 * var4 + var5 * var5));
      int var7 = var2 * var6 >> 8;
      class105 var8 = new class105();
      var8.field1797 = new int[this.field1669];
      var8.field1799 = new int[this.field1669];
      var8.field1785 = new int[this.field1669];
      if(this.field1680 > 0 && this.field1688 != null) {
         int[] var16 = new int[this.field1680];

         int var10;
         for(var10 = 0; var10 < this.field1669; ++var10) {
            if(this.field1688[var10] != -1) {
               ++var16[this.field1688[var10] & 255];
            }
         }

         var8.field1805 = 0;

         for(var10 = 0; var10 < this.field1680; ++var10) {
            if(var16[var10] > 0 && this.field1681[var10] == 0) {
               ++var8.field1805;
            }
         }

         var8.field1806 = new int[var8.field1805];
         var8.field1789 = new int[var8.field1805];
         var8.field1808 = new int[var8.field1805];
         var10 = 0;

         int var11;
         for(var11 = 0; var11 < this.field1680; ++var11) {
            if(var16[var11] > 0 && this.field1681[var11] == 0) {
               var8.field1806[var10] = this.field1668[var11] & '\uffff';
               var8.field1789[var10] = this.field1683[var11] & '\uffff';
               var8.field1808[var10] = this.field1684[var11] & '\uffff';
               var16[var11] = var10++;
            } else {
               var16[var11] = -1;
            }
         }

         var8.field1802 = new byte[this.field1669];

         for(var11 = 0; var11 < this.field1669; ++var11) {
            if(this.field1688[var11] != -1) {
               var8.field1802[var11] = (byte)var16[this.field1688[var11] & 255];
            } else {
               var8.field1802[var11] = -1;
            }
         }
      }

      for(int var9 = 0; var9 < this.field1669; ++var9) {
         byte var17;
         if(this.field1673 == null) {
            var17 = 0;
         } else {
            var17 = this.field1673[var9];
         }

         byte var18;
         if(this.field1675 == null) {
            var18 = 0;
         } else {
            var18 = this.field1675[var9];
         }

         short var12;
         if(this.field1678 == null) {
            var12 = -1;
         } else {
            var12 = this.field1678[var9];
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
                  var19 = this.field1694[var9];
                  var14 = var1 + (var3 * var19.field1425 + var4 * var19.field1426 + var5 * var19.field1424) / (var7 + var7 / 2);
                  var8.field1797[var9] = method2227(this.field1679[var9] & '\uffff', var14);
                  var8.field1785[var9] = -1;
               } else if(var17 == 3) {
                  var8.field1797[var9] = 128;
                  var8.field1785[var9] = -1;
               } else {
                  var8.field1785[var9] = -2;
               }
            } else {
               int var15 = this.field1679[var9] & '\uffff';
               if(this.field1698 != null && this.field1698[this.field1670[var9]] != null) {
                  var13 = this.field1698[this.field1670[var9]];
               } else {
                  var13 = this.field1697[this.field1670[var9]];
               }

               var14 = var1 + (var3 * var13.field1605 + var4 * var13.field1601 + var5 * var13.field1602) / (var7 * var13.field1600);
               var8.field1797[var9] = method2227(var15, var14);
               if(this.field1698 != null && this.field1698[this.field1671[var9]] != null) {
                  var13 = this.field1698[this.field1671[var9]];
               } else {
                  var13 = this.field1697[this.field1671[var9]];
               }

               var14 = var1 + (var3 * var13.field1605 + var4 * var13.field1601 + var5 * var13.field1602) / (var7 * var13.field1600);
               var8.field1799[var9] = method2227(var15, var14);
               if(this.field1698 != null && this.field1698[this.field1672[var9]] != null) {
                  var13 = this.field1698[this.field1672[var9]];
               } else {
                  var13 = this.field1697[this.field1672[var9]];
               }

               var14 = var1 + (var3 * var13.field1605 + var4 * var13.field1601 + var5 * var13.field1602) / (var7 * var13.field1600);
               var8.field1785[var9] = method2227(var15, var14);
            }
         } else if(var17 != 0) {
            if(var17 == 1) {
               var19 = this.field1694[var9];
               var14 = var1 + (var3 * var19.field1425 + var4 * var19.field1426 + var5 * var19.field1424) / (var7 + var7 / 2);
               var8.field1797[var9] = method2231(var14);
               var8.field1785[var9] = -1;
            } else {
               var8.field1785[var9] = -2;
            }
         } else {
            if(this.field1698 != null && this.field1698[this.field1670[var9]] != null) {
               var13 = this.field1698[this.field1670[var9]];
            } else {
               var13 = this.field1697[this.field1670[var9]];
            }

            var14 = var1 + (var3 * var13.field1605 + var4 * var13.field1601 + var5 * var13.field1602) / (var7 * var13.field1600);
            var8.field1797[var9] = method2231(var14);
            if(this.field1698 != null && this.field1698[this.field1671[var9]] != null) {
               var13 = this.field1698[this.field1671[var9]];
            } else {
               var13 = this.field1697[this.field1671[var9]];
            }

            var14 = var1 + (var3 * var13.field1605 + var4 * var13.field1601 + var5 * var13.field1602) / (var7 * var13.field1600);
            var8.field1799[var9] = method2231(var14);
            if(this.field1698 != null && this.field1698[this.field1672[var9]] != null) {
               var13 = this.field1698[this.field1672[var9]];
            } else {
               var13 = this.field1697[this.field1672[var9]];
            }

            var14 = var1 + (var3 * var13.field1605 + var4 * var13.field1601 + var5 * var13.field1602) / (var7 * var13.field1600);
            var8.field1785[var9] = method2231(var14);
         }
      }

      this.method2215();
      var8.field1793 = this.field1703;
      var8.field1790 = this.field1685;
      var8.field1812 = this.field1709;
      var8.field1809 = this.field1666;
      var8.field1791 = this.field1669;
      var8.field1794 = this.field1670;
      var8.field1795 = this.field1671;
      var8.field1815 = this.field1672;
      var8.field1807 = this.field1695;
      var8.field1835 = this.field1675;
      var8.field1804 = this.field1702;
      var8.field1801 = this.field1696;
      var8.field1810 = this.field1667;
      var8.field1803 = this.field1678;
      return var8;
   }

   @ObfuscatedName("i")
   static final int method2231(int var0) {
      if(var0 < 2) {
         var0 = 2;
      } else if(var0 > 126) {
         var0 = 126;
      }

      return var0;
   }

   @ObfuscatedName("q")
   static void method2234(class100 var0, class100 var1, int var2, int var3, int var4, boolean var5) {
      var0.method2237();
      var0.method2212();
      var1.method2237();
      var1.method2212();
      ++field1682;
      int var6 = 0;
      int[] var7 = var1.field1685;
      int var8 = var1.field1703;

      int var9;
      for(var9 = 0; var9 < var0.field1703; ++var9) {
         class96 var10 = var0.field1697[var9];
         if(var10.field1600 != 0) {
            int var11 = var0.field1709[var9] - var3;
            if(var11 <= var1.field1708) {
               int var12 = var0.field1685[var9] - var2;
               if(var12 >= var1.field1674 && var12 <= var1.field1704) {
                  int var13 = var0.field1666[var9] - var4;
                  if(var13 >= var1.field1706 && var13 <= var1.field1705) {
                     for(int var14 = 0; var14 < var8; ++var14) {
                        class96 var15 = var1.field1697[var14];
                        if(var12 == var7[var14] && var13 == var1.field1666[var14] && var11 == var1.field1709[var14] && var15.field1600 != 0) {
                           if(var0.field1698 == null) {
                              var0.field1698 = new class96[var0.field1703];
                           }

                           if(var1.field1698 == null) {
                              var1.field1698 = new class96[var8];
                           }

                           class96 var16 = var0.field1698[var9];
                           if(var16 == null) {
                              var16 = var0.field1698[var9] = new class96(var10);
                           }

                           class96 var17 = var1.field1698[var14];
                           if(var17 == null) {
                              var17 = var1.field1698[var14] = new class96(var15);
                           }

                           var16.field1605 += var15.field1605;
                           var16.field1601 += var15.field1601;
                           var16.field1602 += var15.field1602;
                           var16.field1600 += var15.field1600;
                           var17.field1605 += var10.field1605;
                           var17.field1601 += var10.field1601;
                           var17.field1602 += var10.field1602;
                           var17.field1600 += var10.field1600;
                           ++var6;
                           field1707[var9] = field1682;
                           field1665[var14] = field1682;
                        }
                     }
                  }
               }
            }
         }
      }

      if(var6 >= 3 && var5) {
         for(var9 = 0; var9 < var0.field1669; ++var9) {
            if(field1707[var0.field1670[var9]] == field1682 && field1707[var0.field1671[var9]] == field1682 && field1707[var0.field1672[var9]] == field1682) {
               if(var0.field1673 == null) {
                  var0.field1673 = new byte[var0.field1669];
               }

               var0.field1673[var9] = 2;
            }
         }

         for(var9 = 0; var9 < var1.field1669; ++var9) {
            if(field1665[var1.field1670[var9]] == field1682 && field1665[var1.field1671[var9]] == field1682 && field1665[var1.field1672[var9]] == field1682) {
               if(var1.field1673 == null) {
                  var1.field1673 = new byte[var1.field1669];
               }

               var1.field1673[var9] = 2;
            }
         }

      }
   }

   static {
      field1710 = class91.field1563;
      field1711 = class91.field1564;
   }

   @ObfuscatedName("f")
   void method2237() {
      if(!this.field1701) {
         super.field1436 = 0;
         this.field1708 = 0;
         this.field1674 = 999999;
         this.field1704 = -999999;
         this.field1705 = -99999;
         this.field1706 = 99999;

         for(int var1 = 0; var1 < this.field1703; ++var1) {
            int var2 = this.field1685[var1];
            int var3 = this.field1709[var1];
            int var4 = this.field1666[var1];
            if(var2 < this.field1674) {
               this.field1674 = var2;
            }

            if(var2 > this.field1704) {
               this.field1704 = var2;
            }

            if(var4 < this.field1706) {
               this.field1706 = var4;
            }

            if(var4 > this.field1705) {
               this.field1705 = var4;
            }

            if(-var3 > super.field1436) {
               super.field1436 = -var3;
            }

            if(var3 > this.field1708) {
               this.field1708 = var3;
            }
         }

         this.field1701 = true;
      }
   }

   @ObfuscatedName("a")
   void method2240() {
      this.field1697 = null;
      this.field1698 = null;
      this.field1694 = null;
      this.field1701 = false;
   }

   @ObfuscatedName("x")
   final int method2254(class100 var1, int var2) {
      int var3 = -1;
      int var4 = var1.field1685[var2];
      int var5 = var1.field1709[var2];
      int var6 = var1.field1666[var2];

      for(int var7 = 0; var7 < this.field1703; ++var7) {
         if(var4 == this.field1685[var7] && var5 == this.field1709[var7] && var6 == this.field1666[var7]) {
            var3 = var7;
            break;
         }
      }

      if(var3 == -1) {
         this.field1685[this.field1703] = var4;
         this.field1709[this.field1703] = var5;
         this.field1666[this.field1703] = var6;
         if(var1.field1692 != null) {
            this.field1692[this.field1703] = var1.field1692[var2];
         }

         var3 = this.field1703++;
      }

      return var3;
   }

   class100() {
   }

   @ObfuscatedSignature(
      signature = "(Lclass100;ZZZZ)V",
      garbageValue = "1"
   )
   public class100(class100 var1, boolean var2, boolean var3, boolean var4, boolean var5) {
      this.field1703 = var1.field1703;
      this.field1669 = var1.field1669;
      this.field1680 = var1.field1680;
      int var6;
      if(var2) {
         this.field1685 = var1.field1685;
         this.field1709 = var1.field1709;
         this.field1666 = var1.field1666;
      } else {
         this.field1685 = new int[this.field1703];
         this.field1709 = new int[this.field1703];
         this.field1666 = new int[this.field1703];

         for(var6 = 0; var6 < this.field1703; ++var6) {
            this.field1685[var6] = var1.field1685[var6];
            this.field1709[var6] = var1.field1709[var6];
            this.field1666[var6] = var1.field1666[var6];
         }
      }

      if(var3) {
         this.field1679 = var1.field1679;
      } else {
         this.field1679 = new short[this.field1669];

         for(var6 = 0; var6 < this.field1669; ++var6) {
            this.field1679[var6] = var1.field1679[var6];
         }
      }

      if(!var4 && var1.field1678 != null) {
         this.field1678 = new short[this.field1669];

         for(var6 = 0; var6 < this.field1669; ++var6) {
            this.field1678[var6] = var1.field1678[var6];
         }
      } else {
         this.field1678 = var1.field1678;
      }

      this.field1675 = var1.field1675;
      this.field1670 = var1.field1670;
      this.field1671 = var1.field1671;
      this.field1672 = var1.field1672;
      this.field1673 = var1.field1673;
      this.field1695 = var1.field1695;
      this.field1688 = var1.field1688;
      this.field1702 = var1.field1702;
      this.field1681 = var1.field1681;
      this.field1668 = var1.field1668;
      this.field1683 = var1.field1683;
      this.field1684 = var1.field1684;
      this.field1676 = var1.field1676;
      this.field1686 = var1.field1686;
      this.field1687 = var1.field1687;
      this.field1677 = var1.field1677;
      this.field1691 = var1.field1691;
      this.field1689 = var1.field1689;
      this.field1690 = var1.field1690;
      this.field1692 = var1.field1692;
      this.field1693 = var1.field1693;
      this.field1696 = var1.field1696;
      this.field1667 = var1.field1667;
      this.field1697 = var1.field1697;
      this.field1694 = var1.field1694;
      this.field1698 = var1.field1698;
      this.field1699 = var1.field1699;
      this.field1700 = var1.field1700;
   }

   @ObfuscatedName("g")
   void method2263(byte[] var1) {
      class119 var2 = new class119(var1);
      class119 var3 = new class119(var1);
      class119 var4 = new class119(var1);
      class119 var5 = new class119(var1);
      class119 var6 = new class119(var1);
      class119 var7 = new class119(var1);
      class119 var8 = new class119(var1);
      var2.field1976 = var1.length - 23;
      int var9 = var2.method2516();
      int var10 = var2.method2516();
      int var11 = var2.method2514();
      int var12 = var2.method2514();
      int var13 = var2.method2514();
      int var14 = var2.method2514();
      int var15 = var2.method2514();
      int var16 = var2.method2514();
      int var17 = var2.method2514();
      int var18 = var2.method2516();
      int var19 = var2.method2516();
      int var20 = var2.method2516();
      int var21 = var2.method2516();
      int var22 = var2.method2516();
      int var23 = 0;
      int var24 = 0;
      int var25 = 0;
      int var26;
      if(var11 > 0) {
         this.field1681 = new byte[var11];
         var2.field1976 = 0;

         for(var26 = 0; var26 < var11; ++var26) {
            byte var27 = this.field1681[var26] = var2.method2515();
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
      this.field1703 = var9;
      this.field1669 = var10;
      this.field1680 = var11;
      this.field1685 = new int[var9];
      this.field1709 = new int[var9];
      this.field1666 = new int[var9];
      this.field1670 = new int[var10];
      this.field1671 = new int[var10];
      this.field1672 = new int[var10];
      if(var17 == 1) {
         this.field1692 = new int[var9];
      }

      if(var12 == 1) {
         this.field1673 = new byte[var10];
      }

      if(var13 == 255) {
         this.field1695 = new byte[var10];
      } else {
         this.field1702 = (byte)var13;
      }

      if(var14 == 1) {
         this.field1675 = new byte[var10];
      }

      if(var15 == 1) {
         this.field1693 = new int[var10];
      }

      if(var16 == 1) {
         this.field1678 = new short[var10];
      }

      if(var16 == 1 && var11 > 0) {
         this.field1688 = new byte[var10];
      }

      this.field1679 = new short[var10];
      if(var11 > 0) {
         this.field1668 = new short[var11];
         this.field1683 = new short[var11];
         this.field1684 = new short[var11];
         if(var24 > 0) {
            this.field1676 = new short[var24];
            this.field1686 = new short[var24];
            this.field1687 = new short[var24];
            this.field1677 = new short[var24];
            this.field1691 = new byte[var24];
            this.field1689 = new short[var24];
         }

         if(var25 > 0) {
            this.field1690 = new short[var25];
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
         var52 = var2.method2514();
         var53 = 0;
         if((var52 & 1) != 0) {
            var53 = var3.method2689();
         }

         var54 = 0;
         if((var52 & 2) != 0) {
            var54 = var4.method2689();
         }

         var55 = 0;
         if((var52 & 4) != 0) {
            var55 = var5.method2689();
         }

         this.field1685[var51] = var48 + var53;
         this.field1709[var51] = var49 + var54;
         this.field1666[var51] = var50 + var55;
         var48 = this.field1685[var51];
         var49 = this.field1709[var51];
         var50 = this.field1666[var51];
         if(var17 == 1) {
            this.field1692[var51] = var6.method2514();
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
         this.field1679[var51] = (short)var2.method2516();
         if(var12 == 1) {
            this.field1673[var51] = var3.method2515();
         }

         if(var13 == 255) {
            this.field1695[var51] = var4.method2515();
         }

         if(var14 == 1) {
            this.field1675[var51] = var5.method2515();
         }

         if(var15 == 1) {
            this.field1693[var51] = var6.method2514();
         }

         if(var16 == 1) {
            this.field1678[var51] = (short)(var7.method2516() - 1);
         }

         if(this.field1688 != null && this.field1678[var51] != -1) {
            this.field1688[var51] = (byte)(var8.method2514() - 1);
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
         var56 = var3.method2514();
         if(var56 == 1) {
            var51 = var2.method2689() + var54;
            var52 = var2.method2689() + var51;
            var53 = var2.method2689() + var52;
            var54 = var53;
            this.field1670[var55] = var51;
            this.field1671[var55] = var52;
            this.field1672[var55] = var53;
         }

         if(var56 == 2) {
            var52 = var53;
            var53 = var2.method2689() + var54;
            var54 = var53;
            this.field1670[var55] = var51;
            this.field1671[var55] = var52;
            this.field1672[var55] = var53;
         }

         if(var56 == 3) {
            var51 = var53;
            var53 = var2.method2689() + var54;
            var54 = var53;
            this.field1670[var55] = var51;
            this.field1671[var55] = var52;
            this.field1672[var55] = var53;
         }

         if(var56 == 4) {
            int var57 = var51;
            var51 = var52;
            var52 = var57;
            var53 = var2.method2689() + var54;
            var54 = var53;
            this.field1670[var55] = var51;
            this.field1671[var55] = var57;
            this.field1672[var55] = var53;
         }
      }

      var2.field1976 = var41;
      var3.field1976 = var42;
      var4.field1976 = var43;
      var5.field1976 = var44;
      var6.field1976 = var45;
      var7.field1976 = var46;

      for(var55 = 0; var55 < var11; ++var55) {
         var56 = this.field1681[var55] & 255;
         if(var56 == 0) {
            this.field1668[var55] = (short)var2.method2516();
            this.field1683[var55] = (short)var2.method2516();
            this.field1684[var55] = (short)var2.method2516();
         }

         if(var56 == 1) {
            this.field1668[var55] = (short)var3.method2516();
            this.field1683[var55] = (short)var3.method2516();
            this.field1684[var55] = (short)var3.method2516();
            this.field1676[var55] = (short)var4.method2516();
            this.field1686[var55] = (short)var4.method2516();
            this.field1687[var55] = (short)var4.method2516();
            this.field1677[var55] = (short)var5.method2516();
            this.field1691[var55] = var6.method2515();
            this.field1689[var55] = (short)var7.method2516();
         }

         if(var56 == 2) {
            this.field1668[var55] = (short)var3.method2516();
            this.field1683[var55] = (short)var3.method2516();
            this.field1684[var55] = (short)var3.method2516();
            this.field1676[var55] = (short)var4.method2516();
            this.field1686[var55] = (short)var4.method2516();
            this.field1687[var55] = (short)var4.method2516();
            this.field1677[var55] = (short)var5.method2516();
            this.field1691[var55] = var6.method2515();
            this.field1689[var55] = (short)var7.method2516();
            this.field1690[var55] = (short)var7.method2516();
         }

         if(var56 == 3) {
            this.field1668[var55] = (short)var3.method2516();
            this.field1683[var55] = (short)var3.method2516();
            this.field1684[var55] = (short)var3.method2516();
            this.field1676[var55] = (short)var4.method2516();
            this.field1686[var55] = (short)var4.method2516();
            this.field1687[var55] = (short)var4.method2516();
            this.field1677[var55] = (short)var5.method2516();
            this.field1691[var55] = var6.method2515();
            this.field1689[var55] = (short)var7.method2516();
         }
      }

      var2.field1976 = var26;
      var55 = var2.method2514();
      if(var55 != 0) {
         new class90();
         var2.method2516();
         var2.method2516();
         var2.method2516();
         var2.method2519();
      }

   }

   @ObfuscatedName("h")
   public void method2271(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1703; ++var4) {
         this.field1685[var4] = this.field1685[var4] * var1 / 128;
         this.field1709[var4] = this.field1709[var4] * var2 / 128;
         this.field1666[var4] = this.field1666[var4] * var3 / 128;
      }

      this.method2240();
   }
}
