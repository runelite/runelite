import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
public class class106 extends Node {
   @ObfuscatedName("c")
   static int field1570;
   @ObfuscatedName("m")
   int field1571;
   @ObfuscatedName("e")
   int field1572;
   @ObfuscatedName("t")
   int field1573;
   @ObfuscatedName("w")
   int field1574;
   @ObfuscatedName("k")
   static boolean field1575;
   @ObfuscatedName("j")
   static byte[] field1576;
   @ObfuscatedName("i")
   static int field1577;
   @ObfuscatedName("f")
   static int field1578;
   @ObfuscatedName("z")
   boolean field1579;
   @ObfuscatedName("o")
   static int field1580;
   @ObfuscatedName("q")
   static class104[] field1581;
   @ObfuscatedName("b")
   static float[] field1582;
   @ObfuscatedName("a")
   static class115[] field1583;
   @ObfuscatedName("g")
   static class120[] field1584;
   @ObfuscatedName("v")
   static boolean[] field1585;
   @ObfuscatedName("ab")
   int field1586;
   @ObfuscatedName("r")
   float[] field1587;
   @ObfuscatedName("n")
   static class108[] field1588;
   @ObfuscatedName("l")
   int field1589;
   @ObfuscatedName("d")
   boolean field1590;
   @ObfuscatedName("x")
   static float[] field1591;
   @ObfuscatedName("s")
   static int[] field1592;
   @ObfuscatedName("h")
   int field1593;
   @ObfuscatedName("y")
   static float[] field1594;
   @ObfuscatedName("u")
   static float[] field1595;
   @ObfuscatedName("av")
   static float[] field1596;
   @ObfuscatedName("ax")
   static float[] field1597;
   @ObfuscatedName("af")
   static float[] field1598;
   @ObfuscatedName("ae")
   static int[] field1599;
   @ObfuscatedName("ap")
   static int[] field1600;
   @ObfuscatedName("ak")
   byte[] field1601;
   @ObfuscatedName("al")
   int field1602;
   @ObfuscatedName("p")
   byte[][] field1603;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method1849(byte[] var0, int var1) {
      field1576 = var0;
      field1577 = var1;
      field1578 = 0;
   }

   @ObfuscatedName("e")
   static int method1850() {
      int var0 = field1576[field1577] >> field1578 & 1;
      ++field1578;
      field1577 += field1578 >> 3;
      field1578 &= 7;
      return var0;
   }

   @ObfuscatedName("w")
   void method1852(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      this.field1571 = var2.readInt();
      this.field1572 = var2.readInt();
      this.field1573 = var2.readInt();
      this.field1574 = var2.readInt();
      if(this.field1574 < 0) {
         this.field1574 = ~this.field1574;
         this.field1579 = true;
      }

      int var3 = var2.readInt();
      this.field1603 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var6;
         do {
            var6 = var2.readUnsignedByte();
            var5 += var6;
         } while(var6 >= 255);

         byte[] var7 = new byte[var5];
         var2.readBytes(var7, 0, var5);
         this.field1603[var4] = var7;
      }

   }

   static {
      field1575 = false;
   }

   @ObfuscatedName("c")
   static boolean method1854(IndexDataBase var0) {
      if(!field1575) {
         byte[] var1 = var0.getConfigData(0, 0);
         if(var1 == null) {
            return false;
         }

         method1864(var1);
         field1575 = true;
      }

      return true;
   }

   @ObfuscatedName("o")
   static class106 method1855(IndexDataBase var0, int var1, int var2) {
      if(!method1854(var0)) {
         var0.method3997(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.getConfigData(var1, var2);
         return var3 == null?null:new class106(var3);
      }
   }

   class106(byte[] var1) {
      this.method1852(var1);
   }

   @ObfuscatedName("q")
   class107 method1856(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1601 == null) {
            this.field1589 = 0;
            this.field1587 = new float[field1580];
            this.field1601 = new byte[this.field1572];
            this.field1602 = 0;
            this.field1586 = 0;
         }

         for(; this.field1586 < this.field1603.length; ++this.field1586) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method1859(this.field1586);
            if(var2 != null) {
               int var3 = this.field1602;
               int var4 = var2.length;
               if(var4 > this.field1572 - var3) {
                  var4 = this.field1572 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1601[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1602;
               }

               this.field1602 = var3;
            }
         }

         this.field1587 = null;
         byte[] var7 = this.field1601;
         this.field1601 = null;
         return new class107(this.field1571, var7, this.field1573, this.field1574, this.field1579);
      }
   }

   @ObfuscatedName("j")
   float[] method1859(int var1) {
      method1849(this.field1603[var1], 0);
      method1850();
      int var2 = method1874(class158.method2874(field1592.length - 1));
      boolean var3 = field1585[var2];
      int var4 = var3?field1580:field1570;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method1850() != 0;
         var6 = method1850() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field1570 >> 2);
         var9 = (var4 >> 2) + (field1570 >> 2);
         var10 = field1570 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field1570 >> 2);
         var12 = var4 - (var4 >> 2) + (field1570 >> 2);
         var13 = field1570 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class120 var14 = field1584[field1592[var2]];
      int var16 = var14.field1721;
      int var17 = var14.field1722[var16];
      boolean var15 = !field1588[var17].method1887();
      boolean var45 = var15;

      for(var17 = 0; var17 < var14.field1720; ++var17) {
         class115 var18 = field1583[var14.field1719[var17]];
         float[] var19 = field1591;
         var18.method2016(var19, var4 >> 1, var45);
      }

      int var40;
      if(!var15) {
         var17 = var14.field1721;
         var40 = var14.field1722[var17];
         field1588[var40].method1907(field1591, var4 >> 1);
      }

      int var41;
      if(var15) {
         for(var17 = var4 >> 1; var17 < var4; ++var17) {
            field1591[var17] = 0.0F;
         }
      } else {
         var17 = var4 >> 1;
         var40 = var4 >> 2;
         var41 = var4 >> 3;
         float[] var20 = field1591;

         int var21;
         for(var21 = 0; var21 < var17; ++var21) {
            var20[var21] *= 0.5F;
         }

         for(var21 = var17; var21 < var4; ++var21) {
            var20[var21] = -var20[var4 - var21 - 1];
         }

         float[] var44 = var3?field1596:field1582;
         float[] var22 = var3?field1597:field1594;
         float[] var23 = var3?field1598:field1595;
         int[] var24 = var3?field1600:field1599;

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

         var25 = class158.method2874(var4 - 1);

         int var47;
         int var48;
         int var49;
         int var50;
         for(var47 = 0; var47 < var25 - 3; ++var47) {
            var48 = var4 >> var47 + 2;
            var49 = 8 << var47;

            for(var50 = 0; var50 < 2 << var47; ++var50) {
               int var51 = var4 - var48 * 2 * var50;
               int var52 = var4 - var48 * (var50 * 2 + 1);

               for(int var32 = 0; var32 < var4 >> var47 + 4; ++var32) {
                  int var33 = var32 * 4;
                  float var34 = var20[var51 - 1 - var33];
                  float var35 = var20[var51 - 3 - var33];
                  float var36 = var20[var52 - 1 - var33];
                  float var37 = var20[var52 - 3 - var33];
                  var20[var51 - 1 - var33] = var34 + var36;
                  var20[var51 - 3 - var33] = var35 + var37;
                  float var38 = var44[var32 * var49];
                  float var39 = var44[var32 * var49 + 1];
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
            var20[var47] = var20[var47 * 2 + var17] * var22[var47 * 2] + var20[var47 * 2 + 1 + var17] * var22[var47 * 2 + 1];
            var20[var17 - 1 - var47] = var20[var47 * 2 + var17] * var22[var47 * 2 + 1] - var20[var47 * 2 + 1 + var17] * var22[var47 * 2];
         }

         for(var47 = 0; var47 < var40; ++var47) {
            var20[var4 - var40 + var47] = -var20[var47];
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
            field1591[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var47 = var11; var47 < var12; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1591[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var42 = null;
      if(this.field1589 > 0) {
         var40 = this.field1589 + var4 >> 2;
         var42 = new float[var40];
         int var43;
         if(!this.field1590) {
            for(var41 = 0; var41 < this.field1593; ++var41) {
               var43 = (this.field1589 >> 1) + var41;
               var42[var41] += this.field1587[var43];
            }
         }

         if(!var15) {
            for(var41 = var8; var41 < var4 >> 1; ++var41) {
               var43 = var42.length - (var4 >> 1) + var41;
               var42[var43] += field1591[var41];
            }
         }
      }

      float[] var46 = this.field1587;
      this.field1587 = field1591;
      field1591 = var46;
      this.field1589 = var4;
      this.field1593 = var12 - (var4 >> 1);
      this.field1590 = var15;
      return var42;
   }

   @ObfuscatedName("z")
   static void method1864(byte[] var0) {
      method1849(var0, 0);
      field1570 = 1 << method1874(4);
      field1580 = 1 << method1874(4);
      field1591 = new float[field1580];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field1580:field1570;
         var3 = var2 >> 1;
         var4 = var2 >> 2;
         var5 = var2 >> 3;
         float[] var6 = new float[var3];

         for(int var7 = 0; var7 < var4; ++var7) {
            var6[var7 * 2] = (float)Math.cos((double)(var7 * 4) * 3.141592653589793D / (double)var2);
            var6[var7 * 2 + 1] = -((float)Math.sin((double)(var7 * 4) * 3.141592653589793D / (double)var2));
         }

         float[] var18 = new float[var3];

         for(int var8 = 0; var8 < var4; ++var8) {
            var18[var8 * 2] = (float)Math.cos((double)(var8 * 2 + 1) * 3.141592653589793D / (double)(var2 * 2));
            var18[var8 * 2 + 1] = (float)Math.sin((double)(var8 * 2 + 1) * 3.141592653589793D / (double)(var2 * 2));
         }

         float[] var19 = new float[var4];

         for(int var9 = 0; var9 < var5; ++var9) {
            var19[var9 * 2] = (float)Math.cos((double)(var9 * 4 + 2) * 3.141592653589793D / (double)var2);
            var19[var9 * 2 + 1] = -((float)Math.sin((double)(var9 * 4 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var20 = new int[var5];
         int var10 = class158.method2874(var5 - 1);

         for(int var11 = 0; var11 < var5; ++var11) {
            int var15 = var11;
            int var16 = var10;

            int var17;
            for(var17 = 0; var16 > 0; --var16) {
               var17 = var17 << 1 | var15 & 1;
               var15 >>>= 1;
            }

            var20[var11] = var17;
         }

         if(var1 != 0) {
            field1596 = var6;
            field1597 = var18;
            field1598 = var19;
            field1600 = var20;
         } else {
            field1582 = var6;
            field1594 = var18;
            field1595 = var19;
            field1599 = var20;
         }
      }

      var1 = method1874(8) + 1;
      field1581 = new class104[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field1581[var2] = new class104();
      }

      var2 = method1874(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method1874(16);
      }

      var2 = method1874(6) + 1;
      field1588 = new class108[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field1588[var3] = new class108();
      }

      var3 = method1874(6) + 1;
      field1583 = new class115[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field1583[var4] = new class115();
      }

      var4 = method1874(6) + 1;
      field1584 = new class120[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field1584[var5] = new class120();
      }

      var5 = method1874(6) + 1;
      field1585 = new boolean[var5];
      field1592 = new int[var5];

      for(int var21 = 0; var21 < var5; ++var21) {
         field1585[var21] = method1850() != 0;
         method1874(16);
         method1874(16);
         field1592[var21] = method1874(8);
      }

   }

   @ObfuscatedName("p")
   static float method1868(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   @ObfuscatedName("t")
   static int method1874(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field1578; var0 -= var3) {
         var3 = 8 - field1578;
         int var4 = (1 << var3) - 1;
         var1 += (field1576[field1577] >> field1578 & var4) << var2;
         field1578 = 0;
         ++field1577;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field1576[field1577] >> field1578 & var3) << var2;
         field1578 += var0;
      }

      return var1;
   }
}
