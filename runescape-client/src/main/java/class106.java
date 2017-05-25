import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
public class class106 extends Node {
   @ObfuscatedName("l")
   static int field1567;
   @ObfuscatedName("az")
   static float[] field1568;
   @ObfuscatedName("u")
   int field1569;
   @ObfuscatedName("q")
   int field1570;
   @ObfuscatedName("af")
   byte[] field1571;
   @ObfuscatedName("v")
   boolean field1572;
   @ObfuscatedName("t")
   static byte[] field1573;
   @ObfuscatedName("p")
   static int field1574;
   @ObfuscatedName("h")
   int field1575;
   @ObfuscatedName("a")
   static int field1576;
   @ObfuscatedName("k")
   static int field1577;
   @ObfuscatedName("r")
   static class104[] field1578;
   @ObfuscatedName("z")
   static float[] field1579;
   @ObfuscatedName("x")
   static class115[] field1580;
   @ObfuscatedName("o")
   static class120[] field1581;
   @ObfuscatedName("j")
   static boolean[] field1582;
   @ObfuscatedName("m")
   static int[] field1583;
   @ObfuscatedName("d")
   static boolean field1584;
   @ObfuscatedName("e")
   float[] field1585;
   @ObfuscatedName("aj")
   int field1586;
   @ObfuscatedName("n")
   int field1587;
   @ObfuscatedName("y")
   boolean field1588;
   @ObfuscatedName("w")
   static float[] field1589;
   @ObfuscatedName("f")
   static float[] field1590;
   @ObfuscatedName("c")
   static float[] field1591;
   @ObfuscatedName("ax")
   int field1592;
   @ObfuscatedName("ay")
   static float[] field1593;
   @ObfuscatedName("ah")
   static float[] field1594;
   @ObfuscatedName("g")
   int field1595;
   @ObfuscatedName("b")
   static class108[] field1596;
   @ObfuscatedName("aq")
   static int[] field1597;
   @ObfuscatedName("s")
   int field1598;
   @ObfuscatedName("i")
   byte[][] field1599;
   @ObfuscatedName("ac")
   static int[] field1600;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method1976(byte[] var0, int var1) {
      field1573 = var0;
      field1574 = var1;
      field1567 = 0;
   }

   @ObfuscatedName("u")
   static int method1977() {
      int var0 = field1573[field1574] >> field1567 & 1;
      ++field1567;
      field1574 += field1567 >> 3;
      field1567 &= 7;
      return var0;
   }

   @ObfuscatedName("q")
   static int method1978(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field1567; var0 -= var3) {
         var3 = 8 - field1567;
         int var4 = (1 << var3) - 1;
         var1 += (field1573[field1574] >> field1567 & var4) << var2;
         field1567 = 0;
         ++field1574;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field1573[field1574] >> field1567 & var3) << var2;
         field1567 += var0;
      }

      return var1;
   }

   @ObfuscatedName("g")
   void method1979(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      this.field1575 = var2.readInt();
      this.field1569 = var2.readInt();
      this.field1570 = var2.readInt();
      this.field1595 = var2.readInt();
      if(this.field1595 < 0) {
         this.field1595 = ~this.field1595;
         this.field1572 = true;
      }

      int var3 = var2.readInt();
      this.field1599 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var7;
         do {
            var7 = var2.readUnsignedByte();
            var5 += var7;
         } while(var7 >= 255);

         byte[] var6 = new byte[var5];
         var2.readBytes(var6, 0, var5);
         this.field1599[var4] = var6;
      }

   }

   @ObfuscatedName("v")
   static void method1980(byte[] var0) {
      method1976(var0, 0);
      field1576 = 1 << method1978(4);
      field1577 = 1 << method1978(4);
      field1589 = new float[field1577];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field1577:field1576;
         var3 = var2 >> 1;
         var4 = var2 >> 2;
         var5 = var2 >> 3;
         float[] var12 = new float[var3];

         for(int var13 = 0; var13 < var4; ++var13) {
            var12[var13 * 2] = (float)Math.cos((double)(var13 * 4) * 3.141592653589793D / (double)var2);
            var12[var13 * 2 + 1] = -((float)Math.sin((double)(var13 * 4) * 3.141592653589793D / (double)var2));
         }

         float[] var7 = new float[var3];

         for(int var14 = 0; var14 < var4; ++var14) {
            var7[var14 * 2] = (float)Math.cos((double)(var14 * 2 + 1) * 3.141592653589793D / (double)(var2 * 2));
            var7[var14 * 2 + 1] = (float)Math.sin((double)(var14 * 2 + 1) * 3.141592653589793D / (double)(var2 * 2));
         }

         float[] var8 = new float[var4];

         for(int var15 = 0; var15 < var5; ++var15) {
            var8[var15 * 2] = (float)Math.cos((double)(var15 * 4 + 2) * 3.141592653589793D / (double)var2);
            var8[var15 * 2 + 1] = -((float)Math.sin((double)(var15 * 4 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var9 = new int[var5];
         int var10 = class25.method177(var5 - 1);

         for(int var11 = 0; var11 < var5; ++var11) {
            var9[var11] = class39.method553(var11, var10);
         }

         if(var1 != 0) {
            field1593 = var12;
            field1594 = var7;
            field1568 = var8;
            field1597 = var9;
         } else {
            field1590 = var12;
            field1591 = var7;
            field1579 = var8;
            field1600 = var9;
         }
      }

      var1 = method1978(8) + 1;
      field1578 = new class104[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field1578[var2] = new class104();
      }

      var2 = method1978(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method1978(16);
      }

      var2 = method1978(6) + 1;
      field1596 = new class108[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field1596[var3] = new class108();
      }

      var3 = method1978(6) + 1;
      field1580 = new class115[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field1580[var4] = new class115();
      }

      var4 = method1978(6) + 1;
      field1581 = new class120[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field1581[var5] = new class120();
      }

      var5 = method1978(6) + 1;
      field1582 = new boolean[var5];
      field1583 = new int[var5];

      for(int var6 = 0; var6 < var5; ++var6) {
         field1582[var6] = method1977() != 0;
         method1978(16);
         method1978(16);
         field1583[var6] = method1978(8);
      }

   }

   @ObfuscatedName("t")
   float[] method1981(int var1) {
      method1976(this.field1599[var1], 0);
      method1977();
      int var2 = method1978(class25.method177(field1583.length - 1));
      boolean var3 = field1582[var2];
      int var4 = var3?field1577:field1576;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method1977() != 0;
         var6 = method1977() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field1576 >> 2);
         var9 = (var4 >> 2) + (field1576 >> 2);
         var10 = field1576 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field1576 >> 2);
         var12 = var4 - (var4 >> 2) + (field1576 >> 2);
         var13 = field1576 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class120 var14 = field1581[field1583[var2]];
      int var16 = var14.field1707;
      int var17 = var14.field1709[var16];
      boolean var15 = !field1596[var17].method2040();
      boolean var45 = var15;

      for(var17 = 0; var17 < var14.field1710; ++var17) {
         class115 var18 = field1580[var14.field1708[var17]];
         float[] var43 = field1589;
         var18.method2140(var43, var4 >> 1, var45);
      }

      int var40;
      if(!var15) {
         var17 = var14.field1707;
         var40 = var14.field1709[var17];
         field1596[var40].method2025(field1589, var4 >> 1);
      }

      int var19;
      if(var15) {
         for(var17 = var4 >> 1; var17 < var4; ++var17) {
            field1589[var17] = 0.0F;
         }
      } else {
         var17 = var4 >> 1;
         var40 = var4 >> 2;
         var19 = var4 >> 3;
         float[] var20 = field1589;

         int var21;
         for(var21 = 0; var21 < var17; ++var21) {
            var20[var21] *= 0.5F;
         }

         for(var21 = var17; var21 < var4; ++var21) {
            var20[var21] = -var20[var4 - var21 - 1];
         }

         float[] var44 = var3?field1593:field1590;
         float[] var22 = var3?field1594:field1591;
         float[] var23 = var3?field1568:field1579;
         int[] var24 = var3?field1597:field1600;

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

         var25 = class25.method177(var4 - 1);

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

         for(var47 = 1; var47 < var19 - 1; ++var47) {
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

         for(var47 = 0; var47 < var19; ++var47) {
            var20[var4 - 1 - var47 * 2] = var20[var47 * 4];
            var20[var4 - 2 - var47 * 2] = var20[var47 * 4 + 1];
            var20[var4 - var40 - 1 - var47 * 2] = var20[var47 * 4 + 2];
            var20[var4 - var40 - 2 - var47 * 2] = var20[var47 * 4 + 3];
         }

         for(var47 = 0; var47 < var19; ++var47) {
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
            field1589[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var47 = var11; var47 < var12; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1589[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var41 = null;
      if(this.field1598 > 0) {
         var40 = this.field1598 + var4 >> 2;
         var41 = new float[var40];
         int var42;
         if(!this.field1588) {
            for(var19 = 0; var19 < this.field1587; ++var19) {
               var42 = (this.field1598 >> 1) + var19;
               var41[var19] += this.field1585[var42];
            }
         }

         if(!var15) {
            for(var19 = var8; var19 < var4 >> 1; ++var19) {
               var42 = var41.length - (var4 >> 1) + var19;
               var41[var42] += field1589[var19];
            }
         }
      }

      float[] var46 = this.field1585;
      this.field1585 = field1589;
      field1589 = var46;
      this.field1598 = var4;
      this.field1587 = var12 - (var4 >> 1);
      this.field1588 = var15;
      return var41;
   }

   @ObfuscatedName("p")
   static boolean method1982(IndexDataBase var0) {
      if(!field1584) {
         byte[] var1 = var0.getConfigData(0, 0);
         if(var1 == null) {
            return false;
         }

         method1980(var1);
         field1584 = true;
      }

      return true;
   }

   @ObfuscatedName("l")
   static class106 method1983(IndexDataBase var0, int var1, int var2) {
      if(!method1982(var0)) {
         var0.method4176(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.getConfigData(var1, var2);
         return var3 == null?null:new class106(var3);
      }
   }

   class106(byte[] var1) {
      this.method1979(var1);
   }

   @ObfuscatedName("a")
   class107 method1988(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1571 == null) {
            this.field1598 = 0;
            this.field1585 = new float[field1577];
            this.field1571 = new byte[this.field1569];
            this.field1586 = 0;
            this.field1592 = 0;
         }

         for(; this.field1592 < this.field1599.length; ++this.field1592) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method1981(this.field1592);
            if(var2 != null) {
               int var3 = this.field1586;
               int var4 = var2.length;
               if(var4 > this.field1569 - var3) {
                  var4 = this.field1569 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1571[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1586;
               }

               this.field1586 = var3;
            }
         }

         this.field1585 = null;
         byte[] var7 = this.field1571;
         this.field1571 = null;
         return new class107(this.field1575, var7, this.field1570, this.field1595, this.field1572);
      }
   }

   @ObfuscatedName("i")
   static float method1994(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   static {
      field1584 = false;
   }
}
