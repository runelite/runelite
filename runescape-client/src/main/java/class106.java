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
      int var15 = var14.field1721;
      int var16 = var14.field1722[var15];
      boolean var17 = !field1588[var16].method1887();
      boolean var18 = var17;

      for(var16 = 0; var16 < var14.field1720; ++var16) {
         class115 var19 = field1583[var14.field1719[var16]];
         float[] var20 = field1591;
         var19.method2016(var20, var4 >> 1, var18);
      }

      int var48;
      if(!var17) {
         var16 = var14.field1721;
         var48 = var14.field1722[var16];
         field1588[var48].method1907(field1591, var4 >> 1);
      }

      float[] var21;
      int var22;
      int var49;
      if(var17) {
         for(var16 = var4 >> 1; var16 < var4; ++var16) {
            field1591[var16] = 0.0F;
         }
      } else {
         var16 = var4 >> 1;
         var48 = var4 >> 2;
         var49 = var4 >> 3;
         var21 = field1591;

         for(var22 = 0; var22 < var16; ++var22) {
            var21[var22] *= 0.5F;
         }

         for(var22 = var16; var22 < var4; ++var22) {
            var21[var22] = -var21[var4 - var22 - 1];
         }

         float[] var23 = var3?field1596:field1582;
         float[] var24 = var3?field1597:field1594;
         float[] var25 = var3?field1598:field1595;
         int[] var26 = var3?field1600:field1599;

         int var27;
         float var28;
         float var29;
         float var30;
         float var31;
         for(var27 = 0; var27 < var48; ++var27) {
            var28 = var21[var27 * 4] - var21[var4 - var27 * 4 - 1];
            var29 = var21[var27 * 4 + 2] - var21[var4 - var27 * 4 - 3];
            var30 = var23[var27 * 2];
            var31 = var23[var27 * 2 + 1];
            var21[var4 - var27 * 4 - 1] = var28 * var30 - var29 * var31;
            var21[var4 - var27 * 4 - 3] = var28 * var31 + var29 * var30;
         }

         float var32;
         float var33;
         for(var27 = 0; var27 < var49; ++var27) {
            var28 = var21[var16 + 3 + var27 * 4];
            var29 = var21[var16 + 1 + var27 * 4];
            var30 = var21[var27 * 4 + 3];
            var31 = var21[var27 * 4 + 1];
            var21[var16 + 3 + var27 * 4] = var28 + var30;
            var21[var16 + 1 + var27 * 4] = var29 + var31;
            var32 = var23[var16 - 4 - var27 * 4];
            var33 = var23[var16 - 3 - var27 * 4];
            var21[var27 * 4 + 3] = (var28 - var30) * var32 - (var29 - var31) * var33;
            var21[var27 * 4 + 1] = (var29 - var31) * var32 + (var28 - var30) * var33;
         }

         var27 = class158.method2874(var4 - 1);

         int var34;
         int var35;
         int var36;
         int var37;
         for(var34 = 0; var34 < var27 - 3; ++var34) {
            var35 = var4 >> var34 + 2;
            var36 = 8 << var34;

            for(var37 = 0; var37 < 2 << var34; ++var37) {
               int var38 = var4 - var35 * 2 * var37;
               int var39 = var4 - var35 * (var37 * 2 + 1);

               for(int var40 = 0; var40 < var4 >> var34 + 4; ++var40) {
                  int var41 = var40 * 4;
                  float var42 = var21[var38 - 1 - var41];
                  float var43 = var21[var38 - 3 - var41];
                  float var44 = var21[var39 - 1 - var41];
                  float var45 = var21[var39 - 3 - var41];
                  var21[var38 - 1 - var41] = var42 + var44;
                  var21[var38 - 3 - var41] = var43 + var45;
                  float var46 = var23[var40 * var36];
                  float var47 = var23[var40 * var36 + 1];
                  var21[var39 - 1 - var41] = (var42 - var44) * var46 - (var43 - var45) * var47;
                  var21[var39 - 3 - var41] = (var43 - var45) * var46 + (var42 - var44) * var47;
               }
            }
         }

         for(var34 = 1; var34 < var49 - 1; ++var34) {
            var35 = var26[var34];
            if(var34 < var35) {
               var36 = var34 * 8;
               var37 = var35 * 8;
               var32 = var21[var36 + 1];
               var21[var36 + 1] = var21[var37 + 1];
               var21[var37 + 1] = var32;
               var32 = var21[var36 + 3];
               var21[var36 + 3] = var21[var37 + 3];
               var21[var37 + 3] = var32;
               var32 = var21[var36 + 5];
               var21[var36 + 5] = var21[var37 + 5];
               var21[var37 + 5] = var32;
               var32 = var21[var36 + 7];
               var21[var36 + 7] = var21[var37 + 7];
               var21[var37 + 7] = var32;
            }
         }

         for(var34 = 0; var34 < var16; ++var34) {
            var21[var34] = var21[var34 * 2 + 1];
         }

         for(var34 = 0; var34 < var49; ++var34) {
            var21[var4 - 1 - var34 * 2] = var21[var34 * 4];
            var21[var4 - 2 - var34 * 2] = var21[var34 * 4 + 1];
            var21[var4 - var48 - 1 - var34 * 2] = var21[var34 * 4 + 2];
            var21[var4 - var48 - 2 - var34 * 2] = var21[var34 * 4 + 3];
         }

         for(var34 = 0; var34 < var49; ++var34) {
            var29 = var25[var34 * 2];
            var30 = var25[var34 * 2 + 1];
            var31 = var21[var16 + var34 * 2];
            var32 = var21[var16 + var34 * 2 + 1];
            var33 = var21[var4 - 2 - var34 * 2];
            float var51 = var21[var4 - 1 - var34 * 2];
            float var52 = var30 * (var31 - var33) + var29 * (var32 + var51);
            var21[var16 + var34 * 2] = (var31 + var33 + var52) * 0.5F;
            var21[var4 - 2 - var34 * 2] = (var31 + var33 - var52) * 0.5F;
            var52 = var30 * (var32 + var51) - var29 * (var31 - var33);
            var21[var16 + var34 * 2 + 1] = (var32 - var51 + var52) * 0.5F;
            var21[var4 - 1 - var34 * 2] = (-var32 + var51 + var52) * 0.5F;
         }

         for(var34 = 0; var34 < var48; ++var34) {
            var21[var34] = var21[var34 * 2 + var16] * var24[var34 * 2] + var21[var34 * 2 + 1 + var16] * var24[var34 * 2 + 1];
            var21[var16 - 1 - var34] = var21[var34 * 2 + var16] * var24[var34 * 2 + 1] - var21[var34 * 2 + 1 + var16] * var24[var34 * 2];
         }

         for(var34 = 0; var34 < var48; ++var34) {
            var21[var4 - var48 + var34] = -var21[var34];
         }

         for(var34 = 0; var34 < var48; ++var34) {
            var21[var34] = var21[var48 + var34];
         }

         for(var34 = 0; var34 < var48; ++var34) {
            var21[var48 + var34] = -var21[var48 - var34 - 1];
         }

         for(var34 = 0; var34 < var48; ++var34) {
            var21[var16 + var34] = var21[var4 - var34 - 1];
         }

         for(var34 = var8; var34 < var9; ++var34) {
            var29 = (float)Math.sin(((double)(var34 - var8) + 0.5D) / (double)var10 * 0.5D * 3.141592653589793D);
            field1591[var34] *= (float)Math.sin(1.5707963267948966D * (double)var29 * (double)var29);
         }

         for(var34 = var11; var34 < var12; ++var34) {
            var29 = (float)Math.sin(((double)(var34 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1591[var34] *= (float)Math.sin(1.5707963267948966D * (double)var29 * (double)var29);
         }
      }

      var21 = null;
      if(this.field1589 > 0) {
         var48 = this.field1589 + var4 >> 2;
         var21 = new float[var48];
         if(!this.field1590) {
            for(var49 = 0; var49 < this.field1593; ++var49) {
               var22 = (this.field1589 >> 1) + var49;
               var21[var49] += this.field1587[var22];
            }
         }

         if(!var17) {
            for(var49 = var8; var49 < var4 >> 1; ++var49) {
               var22 = var21.length - (var4 >> 1) + var49;
               var21[var22] += field1591[var49];
            }
         }
      }

      float[] var50 = this.field1587;
      this.field1587 = field1591;
      field1591 = var50;
      this.field1589 = var4;
      this.field1593 = var12 - (var4 >> 1);
      this.field1590 = var17;
      return var21;
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

         float[] var16 = new float[var3];

         for(int var8 = 0; var8 < var4; ++var8) {
            var16[var8 * 2] = (float)Math.cos((double)(var8 * 2 + 1) * 3.141592653589793D / (double)(var2 * 2));
            var16[var8 * 2 + 1] = (float)Math.sin((double)(var8 * 2 + 1) * 3.141592653589793D / (double)(var2 * 2));
         }

         float[] var17 = new float[var4];

         for(int var9 = 0; var9 < var5; ++var9) {
            var17[var9 * 2] = (float)Math.cos((double)(var9 * 4 + 2) * 3.141592653589793D / (double)var2);
            var17[var9 * 2 + 1] = -((float)Math.sin((double)(var9 * 4 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var18 = new int[var5];
         int var10 = class158.method2874(var5 - 1);

         for(int var11 = 0; var11 < var5; ++var11) {
            int var12 = var11;
            int var13 = var10;

            int var14;
            for(var14 = 0; var13 > 0; --var13) {
               var14 = var14 << 1 | var12 & 1;
               var12 >>>= 1;
            }

            var18[var11] = var14;
         }

         if(var1 != 0) {
            field1596 = var6;
            field1597 = var16;
            field1598 = var17;
            field1600 = var18;
         } else {
            field1582 = var6;
            field1594 = var16;
            field1595 = var17;
            field1599 = var18;
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

      for(int var15 = 0; var15 < var5; ++var15) {
         field1585[var15] = method1850() != 0;
         method1874(16);
         method1874(16);
         field1592[var15] = method1874(8);
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

   static {
      field1575 = false;
   }
}
