import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
public class class106 extends Node {
   @ObfuscatedName("z")
   static int field1578;
   @ObfuscatedName("b")
   static int[] field1579;
   @ObfuscatedName("i")
   int field1580;
   @ObfuscatedName("s")
   static boolean field1581;
   @ObfuscatedName("f")
   int field1582;
   @ObfuscatedName("h")
   static int field1583;
   @ObfuscatedName("c")
   static byte[] field1584;
   @ObfuscatedName("aw")
   static int[] field1585;
   @ObfuscatedName("x")
   static class108[] field1586;
   @ObfuscatedName("g")
   static int field1587;
   @ObfuscatedName("e")
   static int field1588;
   @ObfuscatedName("j")
   int field1589;
   @ObfuscatedName("y")
   static class120[] field1590;
   @ObfuscatedName("a")
   static class115[] field1591;
   @ObfuscatedName("o")
   static class104[] field1592;
   @ObfuscatedName("n")
   byte[][] field1593;
   @ObfuscatedName("d")
   static float[] field1594;
   @ObfuscatedName("r")
   static boolean[] field1595;
   @ObfuscatedName("v")
   float[] field1596;
   @ObfuscatedName("t")
   int field1597;
   @ObfuscatedName("w")
   int field1598;
   @ObfuscatedName("l")
   boolean field1599;
   @ObfuscatedName("q")
   static float[] field1600;
   @ObfuscatedName("k")
   static float[] field1601;
   @ObfuscatedName("p")
   int field1602;
   @ObfuscatedName("u")
   static float[] field1603;
   @ObfuscatedName("ae")
   static float[] field1604;
   @ObfuscatedName("ao")
   static float[] field1605;
   @ObfuscatedName("ad")
   static float[] field1606;
   @ObfuscatedName("aa")
   static int[] field1607;
   @ObfuscatedName("m")
   boolean field1608;
   @ObfuscatedName("an")
   byte[] field1609;
   @ObfuscatedName("al")
   int field1610;
   @ObfuscatedName("at")
   int field1611;

   @ObfuscatedName("z")
   static boolean method1934(IndexDataBase var0) {
      if(!field1581) {
         byte[] var1 = var0.getConfigData(0, 0);
         if(var1 == null) {
            return false;
         }

         method1938(var1);
         field1581 = true;
      }

      return true;
   }

   @ObfuscatedName("i")
   static int method1935() {
      int var0 = field1584[field1578] >> field1583 & 1;
      ++field1583;
      field1578 += field1583 >> 3;
      field1583 &= 7;
      return var0;
   }

   @ObfuscatedName("j")
   static int method1936(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - field1583; var0 -= var3) {
         var3 = 8 - field1583;
         int var4 = (1 << var3) - 1;
         var1 += (field1584[field1578] >> field1583 & var4) << var2;
         field1583 = 0;
         ++field1578;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field1584[field1578] >> field1583 & var3) << var2;
         field1583 += var0;
      }

      return var1;
   }

   @ObfuscatedName("f")
   void method1937(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      this.field1602 = var2.readInt();
      this.field1580 = var2.readInt();
      this.field1589 = var2.readInt();
      this.field1582 = var2.readInt();
      if(this.field1582 < 0) {
         this.field1582 = ~this.field1582;
         this.field1608 = true;
      }

      int var3 = var2.readInt();
      this.field1593 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var6;
         do {
            var6 = var2.readUnsignedByte();
            var5 += var6;
         } while(var6 >= 255);

         byte[] var7 = new byte[var5];
         var2.readBytes(var7, 0, var5);
         this.field1593[var4] = var7;
      }

   }

   @ObfuscatedName("m")
   static void method1938(byte[] var0) {
      method1946(var0, 0);
      field1587 = 1 << method1936(4);
      field1588 = 1 << method1936(4);
      field1600 = new float[field1588];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?field1588:field1587;
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
         int var10 = FrameMap.method2673(var5 - 1);

         for(int var11 = 0; var11 < var5; ++var11) {
            var14[var11] = class13.method89(var11, var10);
         }

         if(var1 != 0) {
            field1604 = var6;
            field1605 = var12;
            field1606 = var13;
            field1585 = var14;
         } else {
            field1601 = var6;
            field1594 = var12;
            field1603 = var13;
            field1607 = var14;
         }
      }

      var1 = method1936(8) + 1;
      field1592 = new class104[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field1592[var2] = new class104();
      }

      var2 = method1936(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         method1936(16);
      }

      var2 = method1936(6) + 1;
      field1586 = new class108[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field1586[var3] = new class108();
      }

      var3 = method1936(6) + 1;
      field1591 = new class115[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field1591[var4] = new class115();
      }

      var4 = method1936(6) + 1;
      field1590 = new class120[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field1590[var5] = new class120();
      }

      var5 = method1936(6) + 1;
      field1595 = new boolean[var5];
      field1579 = new int[var5];

      for(int var15 = 0; var15 < var5; ++var15) {
         field1595[var15] = method1935() != 0;
         method1936(16);
         method1936(16);
         field1579[var15] = method1936(8);
      }

   }

   @ObfuscatedName("c")
   float[] method1939(int var1) {
      method1946(this.field1593[var1], 0);
      method1935();
      int var2 = method1936(FrameMap.method2673(field1579.length - 1));
      boolean var3 = field1595[var2];
      int var4 = var3?field1588:field1587;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = method1935() != 0;
         var6 = method1935() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (field1587 >> 2);
         var9 = (var4 >> 2) + (field1587 >> 2);
         var10 = field1587 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field1587 >> 2);
         var12 = var4 - (var4 >> 2) + (field1587 >> 2);
         var13 = field1587 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class120 var14 = field1590[field1579[var2]];
      int var16 = var14.field1730;
      int var17 = var14.field1729[var16];
      boolean var15 = !field1586[var17].method1982();
      boolean var45 = var15;

      for(var17 = 0; var17 < var14.field1727; ++var17) {
         class115 var40 = field1591[var14.field1728[var17]];
         float[] var41 = field1600;
         var40.method2104(var41, var4 >> 1, var45);
      }

      int var18;
      if(!var15) {
         var17 = var14.field1730;
         var18 = var14.field1729[var17];
         field1586[var18].method1968(field1600, var4 >> 1);
      }

      int var19;
      if(var15) {
         for(var17 = var4 >> 1; var17 < var4; ++var17) {
            field1600[var17] = 0.0F;
         }
      } else {
         var17 = var4 >> 1;
         var18 = var4 >> 2;
         var19 = var4 >> 3;
         float[] var20 = field1600;

         int var42;
         for(var42 = 0; var42 < var17; ++var42) {
            var20[var42] *= 0.5F;
         }

         for(var42 = var17; var42 < var4; ++var42) {
            var20[var42] = -var20[var4 - var42 - 1];
         }

         float[] var21 = var3?field1604:field1601;
         float[] var22 = var3?field1605:field1594;
         float[] var23 = var3?field1606:field1603;
         int[] var24 = var3?field1585:field1607;

         int var25;
         float var26;
         float var27;
         float var28;
         float var29;
         for(var25 = 0; var25 < var18; ++var25) {
            var26 = var20[var25 * 4] - var20[var4 - var25 * 4 - 1];
            var27 = var20[var25 * 4 + 2] - var20[var4 - var25 * 4 - 3];
            var28 = var21[var25 * 2];
            var29 = var21[var25 * 2 + 1];
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
            var30 = var21[var17 - 4 - var25 * 4];
            var31 = var21[var17 - 3 - var25 * 4];
            var20[var25 * 4 + 3] = (var26 - var28) * var30 - (var27 - var29) * var31;
            var20[var25 * 4 + 1] = (var27 - var29) * var30 + (var26 - var28) * var31;
         }

         var25 = FrameMap.method2673(var4 - 1);

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
                  float var38 = var21[var32 * var48];
                  float var39 = var21[var32 * var48 + 1];
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
            field1600[var46] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var46 = var11; var46 < var12; ++var46) {
            var27 = (float)Math.sin(((double)(var46 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1600[var46] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var43 = null;
      if(this.field1597 > 0) {
         var18 = this.field1597 + var4 >> 2;
         var43 = new float[var18];
         int var44;
         if(!this.field1599) {
            for(var19 = 0; var19 < this.field1598; ++var19) {
               var44 = (this.field1597 >> 1) + var19;
               var43[var19] += this.field1596[var44];
            }
         }

         if(!var15) {
            for(var19 = var8; var19 < var4 >> 1; ++var19) {
               var44 = var43.length - (var4 >> 1) + var19;
               var43[var44] += field1600[var19];
            }
         }
      }

      float[] var54 = this.field1596;
      this.field1596 = field1600;
      field1600 = var54;
      this.field1597 = var4;
      this.field1598 = var12 - (var4 >> 1);
      this.field1599 = var15;
      return var43;
   }

   class106(byte[] var1) {
      this.method1937(var1);
   }

   @ObfuscatedName("g")
   class107 method1942(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1609 == null) {
            this.field1597 = 0;
            this.field1596 = new float[field1588];
            this.field1609 = new byte[this.field1580];
            this.field1610 = 0;
            this.field1611 = 0;
         }

         for(; this.field1611 < this.field1593.length; ++this.field1611) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method1939(this.field1611);
            if(var2 != null) {
               int var3 = this.field1610;
               int var4 = var2.length;
               if(var4 > this.field1580 - var3) {
                  var4 = this.field1580 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1609[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1610;
               }

               this.field1610 = var3;
            }
         }

         this.field1596 = null;
         byte[] var7 = this.field1609;
         this.field1609 = null;
         return new class107(this.field1602, var7, this.field1589, this.field1582, this.field1608);
      }
   }

   static {
      field1581 = false;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "0"
   )
   static void method1946(byte[] var0, int var1) {
      field1584 = var0;
      field1578 = var1;
      field1583 = 0;
   }

   @ObfuscatedName("n")
   static float method1951(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   @ObfuscatedName("h")
   static class106 method1954(IndexDataBase var0, int var1, int var2) {
      if(!method1934(var0)) {
         var0.method4127(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.getConfigData(var1, var2);
         return var3 == null?null:new class106(var3);
      }
   }
}
