import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
public class class106 extends Node {
   @ObfuscatedName("i")
   byte[][] field1595;
   @ObfuscatedName("w")
   int field1596;
   @ObfuscatedName("a")
   int field1597;
   @ObfuscatedName("t")
   int field1598;
   @ObfuscatedName("s")
   int field1599;
   @ObfuscatedName("v")
   static byte[] field1600;
   @ObfuscatedName("g")
   static float[] field1601;
   @ObfuscatedName("y")
   static int field1602;
   @ObfuscatedName("j")
   static int field1603;
   @ObfuscatedName("k")
   static int field1604;
   @ObfuscatedName("e")
   static int field1605;
   @ObfuscatedName("an")
   static int[] field1606;
   @ObfuscatedName("ar")
   int field1607;
   @ObfuscatedName("l")
   static class115[] field1608;
   @ObfuscatedName("z")
   static class108[] field1609;
   @ObfuscatedName("m")
   static boolean[] field1610;
   @ObfuscatedName("aw")
   static float[] field1611;
   @ObfuscatedName("f")
   static boolean field1612;
   @ObfuscatedName("o")
   static class104[] field1613;
   @ObfuscatedName("u")
   int field1614;
   @ObfuscatedName("p")
   int field1615;
   @ObfuscatedName("q")
   boolean field1616;
   @ObfuscatedName("d")
   static float[] field1617;
   @ObfuscatedName("c")
   static class120[] field1618;
   @ObfuscatedName("ay")
   int field1619;
   @ObfuscatedName("x")
   static float[] field1620;
   @ObfuscatedName("ah")
   static float[] field1621;
   @ObfuscatedName("ab")
   static float[] field1622;
   @ObfuscatedName("n")
   float[] field1623;
   @ObfuscatedName("ai")
   static int[] field1624;
   @ObfuscatedName("h")
   static float[] field1625;
   @ObfuscatedName("au")
   byte[] field1626;
   @ObfuscatedName("r")
   boolean field1627;
   @ObfuscatedName("b")
   static int[] field1628;

   @ObfuscatedName("s")
   void method1956(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      this.field1596 = var2.readInt();
      this.field1597 = var2.readInt();
      this.field1598 = var2.readInt();
      this.field1599 = var2.readInt();
      if(this.field1599 < 0) {
         this.field1599 = ~this.field1599;
         this.field1627 = true;
      }

      int var3 = var2.readInt();
      this.field1595 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var6;
         do {
            var6 = var2.readUnsignedByte();
            var5 += var6;
         } while(var6 >= 255);

         byte[] var7 = new byte[var5];
         var2.readBytes(var7, 0, var5);
         this.field1595[var4] = var7;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method1957(byte[] var0, int var1) {
      field1600 = var0;
      field1602 = var1;
      field1603 = 0;
   }

   @ObfuscatedName("a")
   static int method1958() {
      int var0 = field1600[field1602] >> field1603 & 1;
      ++field1603;
      field1602 += field1603 >> 3;
      field1603 &= 7;
      return var0;
   }

   @ObfuscatedName("r")
   static void method1959(byte[] var0) {
      method1957(var0, 0);
      field1604 = 1 << method1973(4);
      field1605 = 1 << method1973(4);
      field1617 = new float[field1605];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field1605:field1604;
         var3 = var2 >> 1;
         var4 = var2 >> 2;
         var5 = var2 >> 3;
         float[] var6 = new float[var3];

         for(int var7 = 0; var7 < var4; ++var7) {
            var6[var7 * 2] = (float)Math.cos((double)(var7 * 4) * 3.141592653589793D / (double)var2);
            var6[var7 * 2 + 1] = -((float)Math.sin((double)(var7 * 4) * 3.141592653589793D / (double)var2));
         }

         float[] var12 = new float[var3];

         for(int var8 = 0; var8 < var4; ++var8) {
            var12[var8 * 2] = (float)Math.cos((double)(var8 * 2 + 1) * 3.141592653589793D / (double)(var2 * 2));
            var12[var8 * 2 + 1] = (float)Math.sin((double)(var8 * 2 + 1) * 3.141592653589793D / (double)(var2 * 2));
         }

         float[] var13 = new float[var4];

         for(int var9 = 0; var9 < var5; ++var9) {
            var13[var9 * 2] = (float)Math.cos((double)(var9 * 4 + 2) * 3.141592653589793D / (double)var2);
            var13[var9 * 2 + 1] = -((float)Math.sin((double)(var9 * 4 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var14 = new int[var5];
         int var10 = class134.method2574(var5 - 1);

         for(int var11 = 0; var11 < var5; ++var11) {
            var14[var11] = class46.method712(var11, var10);
         }

         if(var1 != 0) {
            field1621 = var6;
            field1622 = var12;
            field1611 = var13;
            field1606 = var14;
         } else {
            field1625 = var6;
            field1601 = var12;
            field1620 = var13;
            field1624 = var14;
         }
      }

      var1 = method1973(8) + 1;
      field1613 = new class104[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field1613[var2] = new class104();
      }

      var2 = method1973(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method1973(16);
      }

      var2 = method1973(6) + 1;
      field1609 = new class108[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field1609[var3] = new class108();
      }

      var3 = method1973(6) + 1;
      field1608 = new class115[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field1608[var4] = new class115();
      }

      var4 = method1973(6) + 1;
      field1618 = new class120[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field1618[var5] = new class120();
      }

      var5 = method1973(6) + 1;
      field1610 = new boolean[var5];
      field1628 = new int[var5];

      for(int var15 = 0; var15 < var5; ++var15) {
         field1610[var15] = method1958() != 0;
         method1973(16);
         method1973(16);
         field1628[var15] = method1973(8);
      }

   }

   @ObfuscatedName("y")
   static boolean method1960(IndexDataBase var0) {
      if(!field1612) {
         byte[] var1 = var0.getConfigData(0, 0);
         if(var1 == null) {
            return false;
         }

         method1959(var1);
         field1612 = true;
      }

      return true;
   }

   @ObfuscatedName("v")
   float[] method1962(int var1) {
      method1957(this.field1595[var1], 0);
      method1958();
      int var2 = method1973(class134.method2574(field1628.length - 1));
      boolean var3 = field1610[var2];
      int var4 = var3?field1605:field1604;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method1958() != 0;
         var6 = method1958() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field1604 >> 2);
         var9 = (var4 >> 2) + (field1604 >> 2);
         var10 = field1604 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field1604 >> 2);
         var12 = var4 - (var4 >> 2) + (field1604 >> 2);
         var13 = field1604 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class120 var14 = field1618[field1628[var2]];
      int var16 = var14.field1732;
      int var17 = var14.field1731[var16];
      boolean var15 = !field1609[var17].method1997();
      boolean var45 = var15;

      for(var17 = 0; var17 < var14.field1730; ++var17) {
         class115 var18 = field1608[var14.field1729[var17]];
         float[] var19 = field1617;
         var18.method2108(var19, var4 >> 1, var45);
      }

      int var40;
      if(!var15) {
         var17 = var14.field1732;
         var40 = var14.field1731[var17];
         field1609[var40].method1998(field1617, var4 >> 1);
      }

      int var41;
      if(var15) {
         for(var17 = var4 >> 1; var17 < var4; ++var17) {
            field1617[var17] = 0.0F;
         }
      } else {
         var17 = var4 >> 1;
         var40 = var4 >> 2;
         var41 = var4 >> 3;
         float[] var20 = field1617;

         int var21;
         for(var21 = 0; var21 < var17; ++var21) {
            var20[var21] *= 0.5F;
         }

         for(var21 = var17; var21 < var4; ++var21) {
            var20[var21] = -var20[var4 - var21 - 1];
         }

         float[] var44 = var3?field1621:field1625;
         float[] var22 = var3?field1622:field1601;
         float[] var23 = var3?field1611:field1620;
         int[] var24 = var3?field1606:field1624;

         int var25;
         float var26;
         float var27;
         float var28;
         float var29;
         for(var25 = 0; var25 < var40; ++var25) {
            var26 = var20[var25 * 4] - var20[var4 - var25 * 4 - 1];
            var27 = var20[var25 * 4 + 2] - var20[var4 - var25 * 4 - 3];
            var28 = var44[var25 * 2];
            var29 = var44[var25 * 2 + 1];
            var20[var4 - var25 * 4 - 1] = var26 * var28 - var27 * var29;
            var20[var4 - var25 * 4 - 3] = var26 * var29 + var27 * var28;
         }

         float var30;
         float var31;
         for(var25 = 0; var25 < var41; ++var25) {
            var26 = var20[var25 * 4 + var17 + 3];
            var27 = var20[var25 * 4 + var17 + 1];
            var28 = var20[var25 * 4 + 3];
            var29 = var20[var25 * 4 + 1];
            var20[var25 * 4 + var17 + 3] = var26 + var28;
            var20[var25 * 4 + var17 + 1] = var27 + var29;
            var30 = var44[var17 - 4 - var25 * 4];
            var31 = var44[var17 - 3 - var25 * 4];
            var20[var25 * 4 + 3] = (var26 - var28) * var30 - (var27 - var29) * var31;
            var20[var25 * 4 + 1] = (var27 - var29) * var30 + (var26 - var28) * var31;
         }

         var25 = class134.method2574(var4 - 1);

         int var47;
         int var48;
         int var49;
         int var50;
         for(var47 = 0; var47 < var25 - 3; ++var47) {
            var48 = var4 >> var47 + 2;
            var49 = 8 << var47;

            for(var50 = 0; var50 < 2 << var47; ++var50) {
               int var51 = var4 - var48 * 2 * var50;
               int var52 = var4 - (2 * var50 + 1) * var48;

               for(int var32 = 0; var32 < var4 >> var47 + 4; ++var32) {
                  int var33 = var32 * 4;
                  float var34 = var20[var51 - 1 - var33];
                  float var35 = var20[var51 - 3 - var33];
                  float var36 = var20[var52 - 1 - var33];
                  float var37 = var20[var52 - 3 - var33];
                  var20[var51 - 1 - var33] = var34 + var36;
                  var20[var51 - 3 - var33] = var35 + var37;
                  float var38 = var44[var49 * var32];
                  float var39 = var44[var49 * var32 + 1];
                  var20[var52 - 1 - var33] = (var34 - var36) * var38 - (var35 - var37) * var39;
                  var20[var52 - 3 - var33] = (var35 - var37) * var38 + (var34 - var36) * var39;
               }
            }
         }

         for(var47 = 1; var47 < var41 - 1; ++var47) {
            var48 = var24[var47];
            if(var47 < var48) {
               var49 = var47 * 8;
               var50 = var48 * 8;
               var30 = var20[var49 + 1];
               var20[var49 + 1] = var20[var50 + 1];
               var20[var50 + 1] = var30;
               var30 = var20[var49 + 3];
               var20[var49 + 3] = var20[var50 + 3];
               var20[var50 + 3] = var30;
               var30 = var20[var49 + 5];
               var20[var49 + 5] = var20[var50 + 5];
               var20[var50 + 5] = var30;
               var30 = var20[var49 + 7];
               var20[var49 + 7] = var20[var50 + 7];
               var20[var50 + 7] = var30;
            }
         }

         for(var47 = 0; var47 < var17; ++var47) {
            var20[var47] = var20[var47 * 2 + 1];
         }

         for(var47 = 0; var47 < var41; ++var47) {
            var20[var4 - 1 - var47 * 2] = var20[var47 * 4];
            var20[var4 - 2 - var47 * 2] = var20[var47 * 4 + 1];
            var20[var4 - var40 - 1 - var47 * 2] = var20[var47 * 4 + 2];
            var20[var4 - var40 - 2 - var47 * 2] = var20[var47 * 4 + 3];
         }

         for(var47 = 0; var47 < var41; ++var47) {
            var27 = var23[var47 * 2];
            var28 = var23[var47 * 2 + 1];
            var29 = var20[var17 + var47 * 2];
            var30 = var20[var17 + var47 * 2 + 1];
            var31 = var20[var4 - 2 - var47 * 2];
            float var53 = var20[var4 - 1 - var47 * 2];
            float var54 = var28 * (var29 - var31) + var27 * (var30 + var53);
            var20[var17 + var47 * 2] = (var29 + var31 + var54) * 0.5F;
            var20[var4 - 2 - var47 * 2] = (var29 + var31 - var54) * 0.5F;
            var54 = var28 * (var30 + var53) - var27 * (var29 - var31);
            var20[var17 + var47 * 2 + 1] = (var30 - var53 + var54) * 0.5F;
            var20[var4 - 1 - var47 * 2] = (-var30 + var53 + var54) * 0.5F;
         }

         for(var47 = 0; var47 < var40; ++var47) {
            var20[var47] = var20[var17 + 2 * var47] * var22[var47 * 2] + var20[var17 + 2 * var47 + 1] * var22[var47 * 2 + 1];
            var20[var17 - 1 - var47] = var20[var17 + var47 * 2] * var22[var47 * 2 + 1] - var20[var17 + 2 * var47 + 1] * var22[var47 * 2];
         }

         for(var47 = 0; var47 < var40; ++var47) {
            var20[var47 + (var4 - var40)] = -var20[var47];
         }

         for(var47 = 0; var47 < var40; ++var47) {
            var20[var47] = var20[var40 + var47];
         }

         for(var47 = 0; var47 < var40; ++var47) {
            var20[var40 + var47] = -var20[var40 - var47 - 1];
         }

         for(var47 = 0; var47 < var40; ++var47) {
            var20[var17 + var47] = var20[var4 - var47 - 1];
         }

         for(var47 = var8; var47 < var9; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var8) + 0.5D) / (double)var10 * 0.5D * 3.141592653589793D);
            field1617[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var47 = var11; var47 < var12; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1617[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var42 = null;
      if(this.field1614 > 0) {
         var40 = this.field1614 + var4 >> 2;
         var42 = new float[var40];
         int var43;
         if(!this.field1616) {
            for(var41 = 0; var41 < this.field1615; ++var41) {
               var43 = var41 + (this.field1614 >> 1);
               var42[var41] += this.field1623[var43];
            }
         }

         if(!var15) {
            for(var41 = var8; var41 < var4 >> 1; ++var41) {
               var43 = var41 + (var42.length - (var4 >> 1));
               var42[var43] += field1617[var41];
            }
         }
      }

      float[] var46 = this.field1623;
      this.field1623 = field1617;
      field1617 = var46;
      this.field1614 = var4;
      this.field1615 = var12 - (var4 >> 1);
      this.field1616 = var15;
      return var42;
   }

   @ObfuscatedName("i")
   static float method1963(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   @ObfuscatedName("j")
   static class106 method1964(IndexDataBase var0, int var1, int var2) {
      if(!method1960(var0)) {
         var0.method4116(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.getConfigData(var1, var2);
         return var3 == null?null:new class106(var3);
      }
   }

   class106(byte[] var1) {
      this.method1956(var1);
   }

   @ObfuscatedName("k")
   class107 method1965(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1626 == null) {
            this.field1614 = 0;
            this.field1623 = new float[field1605];
            this.field1626 = new byte[this.field1597];
            this.field1607 = 0;
            this.field1619 = 0;
         }

         for(; this.field1619 < this.field1595.length; ++this.field1619) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method1962(this.field1619);
            if(var2 != null) {
               int var3 = this.field1607;
               int var4 = var2.length;
               if(var4 > this.field1597 - var3) {
                  var4 = this.field1597 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1626[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1607;
               }

               this.field1607 = var3;
            }
         }

         this.field1623 = null;
         byte[] var7 = this.field1626;
         this.field1626 = null;
         return new class107(this.field1596, var7, this.field1598, this.field1599, this.field1627);
      }
   }

   static {
      field1612 = false;
   }

   @ObfuscatedName("t")
   static int method1973(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field1603; var0 -= var3) {
         var3 = 8 - field1603;
         int var4 = (1 << var3) - 1;
         var1 += (field1600[field1602] >> field1603 & var4) << var2;
         field1603 = 0;
         ++field1602;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field1600[field1602] >> field1603 & var3) << var2;
         field1603 += var0;
      }

      return var1;
   }
}
