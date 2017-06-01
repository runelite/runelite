import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
public class class106 extends Node {
   @ObfuscatedName("w")
   boolean field1586;
   @ObfuscatedName("a")
   static int field1587;
   @ObfuscatedName("e")
   int field1588;
   @ObfuscatedName("v")
   int field1589;
   @ObfuscatedName("aw")
   int field1590;
   @ObfuscatedName("y")
   boolean field1591;
   @ObfuscatedName("b")
   int field1592;
   @ObfuscatedName("x")
   static int field1593;
   @ObfuscatedName("f")
   static int field1594;
   @ObfuscatedName("n")
   static int field1595;
   @ObfuscatedName("q")
   static class115[] field1596;
   @ObfuscatedName("o")
   static class104[] field1597;
   @ObfuscatedName("z")
   static class108[] field1598;
   @ObfuscatedName("g")
   int field1599;
   @ObfuscatedName("j")
   static class120[] field1600;
   @ObfuscatedName("k")
   static boolean[] field1601;
   @ObfuscatedName("r")
   static int[] field1602;
   @ObfuscatedName("h")
   static byte[] field1603;
   @ObfuscatedName("d")
   float[] field1604;
   @ObfuscatedName("s")
   int field1605;
   @ObfuscatedName("i")
   byte[][] field1606;
   @ObfuscatedName("af")
   static int[] field1607;
   @ObfuscatedName("p")
   static float[] field1608;
   @ObfuscatedName("l")
   static float[] field1609;
   @ObfuscatedName("u")
   static float[] field1610;
   @ObfuscatedName("t")
   static float[] field1611;
   @ObfuscatedName("ad")
   static float[] field1612;
   @ObfuscatedName("ah")
   byte[] field1613;
   @ObfuscatedName("an")
   static float[] field1614;
   @ObfuscatedName("ar")
   static float[] field1615;
   @ObfuscatedName("at")
   static int[] field1616;
   @ObfuscatedName("m")
   static boolean field1617;
   @ObfuscatedName("ai")
   int field1618;
   @ObfuscatedName("c")
   int field1619;

   @ObfuscatedName("e")
   static int method1949() {
      int var0 = field1603[field1593] >> field1594 & 1;
      ++field1594;
      field1593 += field1594 >> 3;
      field1594 &= 7;
      return var0;
   }

   @ObfuscatedName("v")
   static int method1950(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field1594; var0 -= var3) {
         var3 = 8 - field1594;
         int var4 = (1 << var3) - 1;
         var1 += (field1603[field1593] >> field1594 & var4) << var2;
         field1594 = 0;
         ++field1593;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field1603[field1593] >> field1594 & var3) << var2;
         field1594 += var0;
      }

      return var1;
   }

   @ObfuscatedName("y")
   static void method1952(byte[] var0) {
      method1964(var0, 0);
      field1595 = 1 << method1950(4);
      field1587 = 1 << method1950(4);
      field1608 = new float[field1587];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field1587:field1595;
         var3 = var2 >> 1;
         var4 = var2 >> 2;
         var5 = var2 >> 3;
         float[] var18 = new float[var3];

         for(int var7 = 0; var7 < var4; ++var7) {
            var18[var7 * 2] = (float)Math.cos((double)(var7 * 4) * 3.141592653589793D / (double)var2);
            var18[var7 * 2 + 1] = -((float)Math.sin((double)(var7 * 4) * 3.141592653589793D / (double)var2));
         }

         float[] var19 = new float[var3];

         for(int var8 = 0; var8 < var4; ++var8) {
            var19[var8 * 2] = (float)Math.cos((double)(var8 * 2 + 1) * 3.141592653589793D / (double)(var2 * 2));
            var19[var8 * 2 + 1] = (float)Math.sin((double)(var8 * 2 + 1) * 3.141592653589793D / (double)(var2 * 2));
         }

         float[] var20 = new float[var4];

         for(int var9 = 0; var9 < var5; ++var9) {
            var20[var9 * 2] = (float)Math.cos((double)(var9 * 4 + 2) * 3.141592653589793D / (double)var2);
            var20[var9 * 2 + 1] = -((float)Math.sin((double)(var9 * 4 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var21 = new int[var5];
         int var10 = class11.method50(var5 - 1);

         for(int var11 = 0; var11 < var5; ++var11) {
            int var15 = var11;
            int var16 = var10;

            int var17;
            for(var17 = 0; var16 > 0; --var16) {
               var17 = var17 << 1 | var15 & 1;
               var15 >>>= 1;
            }

            var21[var11] = var17;
         }

         if(var1 != 0) {
            field1612 = var18;
            field1615 = var19;
            field1614 = var20;
            field1616 = var21;
         } else {
            field1609 = var18;
            field1610 = var19;
            field1611 = var20;
            field1607 = var21;
         }
      }

      var1 = method1950(8) + 1;
      field1597 = new class104[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field1597[var2] = new class104();
      }

      var2 = method1950(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method1950(16);
      }

      var2 = method1950(6) + 1;
      field1598 = new class108[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field1598[var3] = new class108();
      }

      var3 = method1950(6) + 1;
      field1596 = new class115[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field1596[var4] = new class115();
      }

      var4 = method1950(6) + 1;
      field1600 = new class120[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field1600[var5] = new class120();
      }

      var5 = method1950(6) + 1;
      field1601 = new boolean[var5];
      field1602 = new int[var5];

      for(int var6 = 0; var6 < var5; ++var6) {
         field1601[var6] = method1949() != 0;
         method1950(16);
         method1950(16);
         field1602[var6] = method1950(8);
      }

   }

   @ObfuscatedName("h")
   float[] method1953(int var1) {
      method1964(this.field1606[var1], 0);
      method1949();
      int var2 = method1950(class11.method50(field1602.length - 1));
      boolean var3 = field1601[var2];
      int var4 = var3?field1587:field1595;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method1949() != 0;
         var6 = method1949() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field1595 >> 2);
         var9 = (var4 >> 2) + (field1595 >> 2);
         var10 = field1595 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field1595 >> 2);
         var12 = var4 - (var4 >> 2) + (field1595 >> 2);
         var13 = field1595 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class120 var14 = field1600[field1602[var2]];
      int var16 = var14.field1737;
      int var17 = var14.field1736[var16];
      boolean var15 = !field1598[var17].method1988();
      boolean var45 = var15;

      for(var17 = 0; var17 < var14.field1738; ++var17) {
         class115 var40 = field1596[var14.field1739[var17]];
         float[] var41 = field1608;
         var40.method2089(var41, var4 >> 1, var45);
      }

      int var18;
      if(!var15) {
         var17 = var14.field1737;
         var18 = var14.field1736[var17];
         field1598[var18].method1989(field1608, var4 >> 1);
      }

      int var19;
      if(var15) {
         for(var17 = var4 >> 1; var17 < var4; ++var17) {
            field1608[var17] = 0.0F;
         }
      } else {
         var17 = var4 >> 1;
         var18 = var4 >> 2;
         var19 = var4 >> 3;
         float[] var20 = field1608;

         int var21;
         for(var21 = 0; var21 < var17; ++var21) {
            var20[var21] *= 0.5F;
         }

         for(var21 = var17; var21 < var4; ++var21) {
            var20[var21] = -var20[var4 - var21 - 1];
         }

         float[] var44 = var3?field1612:field1609;
         float[] var22 = var3?field1615:field1610;
         float[] var23 = var3?field1614:field1611;
         int[] var24 = var3?field1616:field1607;

         int var25;
         float var26;
         float var27;
         float var28;
         float var29;
         for(var25 = 0; var25 < var18; ++var25) {
            var26 = var20[var25 * 4] - var20[var4 - var25 * 4 - 1];
            var27 = var20[var25 * 4 + 2] - var20[var4 - var25 * 4 - 3];
            var28 = var44[var25 * 2];
            var29 = var44[var25 * 2 + 1];
            var20[var4 - var25 * 4 - 1] = var26 * var28 - var27 * var29;
            var20[var4 - var25 * 4 - 3] = var26 * var29 + var27 * var28;
         }

         float var30;
         float var31;
         for(var25 = 0; var25 < var19; ++var25) {
            var26 = var20[var17 + 3 + var25 * 4];
            var27 = var20[var17 + 1 + var25 * 4];
            var28 = var20[var25 * 4 + 3];
            var29 = var20[var25 * 4 + 1];
            var20[var17 + 3 + var25 * 4] = var26 + var28;
            var20[var17 + 1 + var25 * 4] = var27 + var29;
            var30 = var44[var17 - 4 - var25 * 4];
            var31 = var44[var17 - 3 - var25 * 4];
            var20[var25 * 4 + 3] = (var26 - var28) * var30 - (var27 - var29) * var31;
            var20[var25 * 4 + 1] = (var27 - var29) * var30 + (var26 - var28) * var31;
         }

         var25 = class11.method50(var4 - 1);

         int var46;
         int var47;
         int var48;
         int var49;
         for(var46 = 0; var46 < var25 - 3; ++var46) {
            var47 = var4 >> var46 + 2;
            var48 = 8 << var46;

            for(var49 = 0; var49 < 2 << var46; ++var49) {
               int var50 = var4 - var47 * 2 * var49;
               int var51 = var4 - var47 * (var49 * 2 + 1);

               for(int var32 = 0; var32 < var4 >> var46 + 4; ++var32) {
                  int var33 = var32 * 4;
                  float var34 = var20[var50 - 1 - var33];
                  float var35 = var20[var50 - 3 - var33];
                  float var36 = var20[var51 - 1 - var33];
                  float var37 = var20[var51 - 3 - var33];
                  var20[var50 - 1 - var33] = var34 + var36;
                  var20[var50 - 3 - var33] = var35 + var37;
                  float var38 = var44[var32 * var48];
                  float var39 = var44[var32 * var48 + 1];
                  var20[var51 - 1 - var33] = (var34 - var36) * var38 - (var35 - var37) * var39;
                  var20[var51 - 3 - var33] = (var35 - var37) * var38 + (var34 - var36) * var39;
               }
            }
         }

         for(var46 = 1; var46 < var19 - 1; ++var46) {
            var47 = var24[var46];
            if(var46 < var47) {
               var48 = var46 * 8;
               var49 = var47 * 8;
               var30 = var20[var48 + 1];
               var20[var48 + 1] = var20[var49 + 1];
               var20[var49 + 1] = var30;
               var30 = var20[var48 + 3];
               var20[var48 + 3] = var20[var49 + 3];
               var20[var49 + 3] = var30;
               var30 = var20[var48 + 5];
               var20[var48 + 5] = var20[var49 + 5];
               var20[var49 + 5] = var30;
               var30 = var20[var48 + 7];
               var20[var48 + 7] = var20[var49 + 7];
               var20[var49 + 7] = var30;
            }
         }

         for(var46 = 0; var46 < var17; ++var46) {
            var20[var46] = var20[var46 * 2 + 1];
         }

         for(var46 = 0; var46 < var19; ++var46) {
            var20[var4 - 1 - var46 * 2] = var20[var46 * 4];
            var20[var4 - 2 - var46 * 2] = var20[var46 * 4 + 1];
            var20[var4 - var18 - 1 - var46 * 2] = var20[var46 * 4 + 2];
            var20[var4 - var18 - 2 - var46 * 2] = var20[var46 * 4 + 3];
         }

         for(var46 = 0; var46 < var19; ++var46) {
            var27 = var23[var46 * 2];
            var28 = var23[var46 * 2 + 1];
            var29 = var20[var17 + var46 * 2];
            var30 = var20[var17 + var46 * 2 + 1];
            var31 = var20[var4 - 2 - var46 * 2];
            float var52 = var20[var4 - 1 - var46 * 2];
            float var53 = var28 * (var29 - var31) + var27 * (var30 + var52);
            var20[var17 + var46 * 2] = (var29 + var31 + var53) * 0.5F;
            var20[var4 - 2 - var46 * 2] = (var29 + var31 - var53) * 0.5F;
            var53 = var28 * (var30 + var52) - var27 * (var29 - var31);
            var20[var17 + var46 * 2 + 1] = (var30 - var52 + var53) * 0.5F;
            var20[var4 - 1 - var46 * 2] = (-var30 + var52 + var53) * 0.5F;
         }

         for(var46 = 0; var46 < var18; ++var46) {
            var20[var46] = var20[var46 * 2 + var17] * var22[var46 * 2] + var20[var46 * 2 + 1 + var17] * var22[var46 * 2 + 1];
            var20[var17 - 1 - var46] = var20[var46 * 2 + var17] * var22[var46 * 2 + 1] - var20[var46 * 2 + 1 + var17] * var22[var46 * 2];
         }

         for(var46 = 0; var46 < var18; ++var46) {
            var20[var4 - var18 + var46] = -var20[var46];
         }

         for(var46 = 0; var46 < var18; ++var46) {
            var20[var46] = var20[var18 + var46];
         }

         for(var46 = 0; var46 < var18; ++var46) {
            var20[var18 + var46] = -var20[var18 - var46 - 1];
         }

         for(var46 = 0; var46 < var18; ++var46) {
            var20[var17 + var46] = var20[var4 - var46 - 1];
         }

         for(var46 = var8; var46 < var9; ++var46) {
            var27 = (float)Math.sin(((double)(var46 - var8) + 0.5D) / (double)var10 * 0.5D * 3.141592653589793D);
            field1608[var46] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var46 = var11; var46 < var12; ++var46) {
            var27 = (float)Math.sin(((double)(var46 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1608[var46] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var42 = null;
      if(this.field1605 > 0) {
         var18 = this.field1605 + var4 >> 2;
         var42 = new float[var18];
         int var43;
         if(!this.field1586) {
            for(var19 = 0; var19 < this.field1599; ++var19) {
               var43 = (this.field1605 >> 1) + var19;
               var42[var19] += this.field1604[var43];
            }
         }

         if(!var15) {
            for(var19 = var8; var19 < var4 >> 1; ++var19) {
               var43 = var42.length - (var4 >> 1) + var19;
               var42[var43] += field1608[var19];
            }
         }
      }

      float[] var54 = this.field1604;
      this.field1604 = field1608;
      field1608 = var54;
      this.field1605 = var4;
      this.field1599 = var12 - (var4 >> 1);
      this.field1586 = var15;
      return var42;
   }

   class106(byte[] var1) {
      this.method1978(var1);
   }

   @ObfuscatedName("n")
   class107 method1956(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1613 == null) {
            this.field1605 = 0;
            this.field1604 = new float[field1587];
            this.field1613 = new byte[this.field1588];
            this.field1618 = 0;
            this.field1590 = 0;
         }

         for(; this.field1590 < this.field1606.length; ++this.field1590) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method1953(this.field1590);
            if(var2 != null) {
               int var3 = this.field1618;
               int var4 = var2.length;
               if(var4 > this.field1588 - var3) {
                  var4 = this.field1588 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1613[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1618;
               }

               this.field1618 = var3;
            }
         }

         this.field1604 = null;
         byte[] var7 = this.field1613;
         this.field1613 = null;
         return new class107(this.field1619, var7, this.field1589, this.field1592, this.field1591);
      }
   }

   static {
      field1617 = false;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method1964(byte[] var0, int var1) {
      field1603 = var0;
      field1593 = var1;
      field1594 = 0;
   }

   @ObfuscatedName("x")
   static boolean method1975(IndexDataBase var0) {
      if(!field1617) {
         byte[] var1 = var0.getConfigData(0, 0);
         if(var1 == null) {
            return false;
         }

         method1952(var1);
         field1617 = true;
      }

      return true;
   }

   @ObfuscatedName("i")
   static float method1976(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   @ObfuscatedName("b")
   void method1978(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      this.field1619 = var2.readInt();
      this.field1588 = var2.readInt();
      this.field1589 = var2.readInt();
      this.field1592 = var2.readInt();
      if(this.field1592 < 0) {
         this.field1592 = ~this.field1592;
         this.field1591 = true;
      }

      int var3 = var2.readInt();
      this.field1606 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var7;
         do {
            var7 = var2.readUnsignedByte();
            var5 += var7;
         } while(var7 >= 255);

         byte[] var6 = new byte[var5];
         var2.readBytes(var6, 0, var5);
         this.field1606[var4] = var6;
      }

   }

   @ObfuscatedName("f")
   static class106 method1980(IndexDataBase var0, int var1, int var2) {
      if(!method1975(var0)) {
         var0.method4111(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.getConfigData(var1, var2);
         return var3 == null?null:new class106(var3);
      }
   }
}
