import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
public class class142 extends Node {
   @ObfuscatedName("y")
   class55[] field1985 = new class55[128];
   @ObfuscatedName("r")
   byte[] field1986 = new byte[128];
   @ObfuscatedName("o")
   short[] field1987 = new short[128];
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 631229917
   )
   int field1988;
   @ObfuscatedName("w")
   byte[] field1989 = new byte[128];
   @ObfuscatedName("j")
   class137[] field1990 = new class137[128];
   @ObfuscatedName("d")
   int[] field1991 = new int[128];
   @ObfuscatedName("q")
   byte[] field1992 = new byte[128];

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2039140735"
   )
   void method2671() {
      this.field1991 = null;
   }

   class142(byte[] var1) {
      Buffer var2 = new Buffer(var1);

      int var3;
      for(var3 = 0; var2.payload[var3 + var2.offset] != 0; ++var3) {
         ;
      }

      byte[] var4 = new byte[var3];

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4[var5] = var2.readByte();
      }

      ++var2.offset;
      ++var3;
      var5 = var2.offset;
      var2.offset += var3;

      int var6;
      for(var6 = 0; var2.payload[var2.offset + var6] != 0; ++var6) {
         ;
      }

      byte[] var7 = new byte[var6];

      int var8;
      for(var8 = 0; var8 < var6; ++var8) {
         var7[var8] = var2.readByte();
      }

      ++var2.offset;
      ++var6;
      var8 = var2.offset;
      var2.offset += var6;

      int var9;
      for(var9 = 0; var2.payload[var2.offset + var9] != 0; ++var9) {
         ;
      }

      byte[] var10 = new byte[var9];

      for(int var11 = 0; var11 < var9; ++var11) {
         var10[var11] = var2.readByte();
      }

      ++var2.offset;
      ++var9;
      byte[] var39 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var39[1] = 1;
         int var40 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var37 = var2.readUnsignedByte();
            if(var37 == 0) {
               var40 = var12++;
            } else {
               if(var37 <= var40) {
                  --var37;
               }

               var40 = var37;
            }

            var39[var14] = (byte)var40;
         }
      } else {
         var12 = var9;
      }

      class137[] var13 = new class137[var12];

      class137 var15;
      for(var14 = 0; var14 < var13.length; ++var14) {
         var15 = var13[var14] = new class137();
         int var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var15.field1901 = new byte[var16 * 2];
         }

         var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var15.field1894 = new byte[var16 * 2 + 2];
            var15.field1894[1] = 64;
         }
      }

      var14 = var2.readUnsignedByte();
      byte[] var42 = var14 > 0?new byte[2 * var14]:null;
      var14 = var2.readUnsignedByte();
      byte[] var38 = var14 > 0?new byte[2 * var14]:null;

      int var17;
      for(var17 = 0; var2.payload[var17 + var2.offset] != 0; ++var17) {
         ;
      }

      byte[] var18 = new byte[var17];

      int var19;
      for(var19 = 0; var19 < var17; ++var19) {
         var18[var19] = var2.readByte();
      }

      ++var2.offset;
      ++var17;
      var19 = 0;

      int var20;
      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.readUnsignedByte();
         this.field1987[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.readUnsignedByte();
         this.field1987[var20] = (short)(this.field1987[var20] + (var19 << 8));
      }

      var20 = 0;
      int var21 = 0;
      int var22 = 0;

      int var23;
      for(var23 = 0; var23 < 128; ++var23) {
         if(var20 == 0) {
            if(var21 < var18.length) {
               var20 = var18[var21++];
            } else {
               var20 = -1;
            }

            var22 = var2.method2942();
         }

         this.field1987[var23] = (short)(this.field1987[var23] + ((var22 - 1 & 2) << 14));
         this.field1991[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field1991[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.payload[var5++] - 1;
            }

            this.field1992[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if(this.field1991[var25] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.payload[var8++] + 16 << 2;
            }

            this.field1989[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class137 var41 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field1991[var26] != 0) {
            if(var20 == 0) {
               var41 = var13[var39[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field1990[var26] = var41;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var26 = 0;

      int var27;
      for(var27 = 0; var27 < 128; ++var27) {
         if(var20 == 0) {
            if(var21 < var18.length) {
               var20 = var18[var21++];
            } else {
               var20 = -1;
            }

            if(this.field1991[var27] > 0) {
               var26 = var2.readUnsignedByte() + 1;
            }
         }

         this.field1986[var27] = (byte)var26;
         --var20;
      }

      this.field1988 = var2.readUnsignedByte() + 1;

      class137 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1901 != null) {
            for(var29 = 1; var29 < var28.field1901.length; var29 += 2) {
               var28.field1901[var29] = var2.readByte();
            }
         }

         if(null != var28.field1894) {
            for(var29 = 3; var29 < var28.field1894.length - 2; var29 += 2) {
               var28.field1894[var29] = var2.readByte();
            }
         }
      }

      if(var42 != null) {
         for(var27 = 1; var27 < var42.length; var27 += 2) {
            var42[var27] = var2.readByte();
         }
      }

      if(null != var38) {
         for(var27 = 1; var27 < var38.length; var27 += 2) {
            var38[var27] = var2.readByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(null != var28.field1894) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field1894.length; var29 += 2) {
               var19 = 1 + var19 + var2.readUnsignedByte();
               var28.field1894[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(null != var28.field1901) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field1901.length; var29 += 2) {
               var19 = 1 + var19 + var2.readUnsignedByte();
               var28.field1901[var29] = (byte)var19;
            }
         }
      }

      byte var30;
      int var32;
      int var33;
      int var34;
      int var43;
      byte var45;
      if(var42 != null) {
         var19 = var2.readUnsignedByte();
         var42[0] = (byte)var19;

         for(var27 = 2; var27 < var42.length; var27 += 2) {
            var19 = 1 + var19 + var2.readUnsignedByte();
            var42[var27] = (byte)var19;
         }

         var45 = var42[0];
         byte var36 = var42[1];

         for(var29 = 0; var29 < var45; ++var29) {
            this.field1986[var29] = (byte)(this.field1986[var29] * var36 + 32 >> 6);
         }

         for(var29 = 2; var29 < var42.length; var29 += 2) {
            var30 = var42[var29];
            byte var31 = var42[var29 + 1];
            var32 = (var30 - var45) / 2 + (var30 - var45) * var36;

            for(var33 = var45; var33 < var30; ++var33) {
               var34 = class145.calculateHeight(var32, var30 - var45);
               this.field1986[var33] = (byte)(this.field1986[var33] * var34 + 32 >> 6);
               var32 += var31 - var36;
            }

            var45 = var30;
            var36 = var31;
         }

         for(var43 = var45; var43 < 128; ++var43) {
            this.field1986[var43] = (byte)(32 + this.field1986[var43] * var36 >> 6);
         }

         var15 = null;
      }

      if(var38 != null) {
         var19 = var2.readUnsignedByte();
         var38[0] = (byte)var19;

         for(var27 = 2; var27 < var38.length; var27 += 2) {
            var19 = 1 + var19 + var2.readUnsignedByte();
            var38[var27] = (byte)var19;
         }

         var45 = var38[0];
         int var46 = var38[1] << 1;

         for(var29 = 0; var29 < var45; ++var29) {
            var43 = (this.field1989[var29] & 255) + var46;
            if(var43 < 0) {
               var43 = 0;
            }

            if(var43 > 128) {
               var43 = 128;
            }

            this.field1989[var29] = (byte)var43;
         }

         int var44;
         for(var29 = 2; var29 < var38.length; var29 += 2) {
            var30 = var38[var29];
            var44 = var38[1 + var29] << 1;
            var32 = var46 * (var30 - var45) + (var30 - var45) / 2;

            for(var33 = var45; var33 < var30; ++var33) {
               var34 = class145.calculateHeight(var32, var30 - var45);
               int var35 = (this.field1989[var33] & 255) + var34;
               if(var35 < 0) {
                  var35 = 0;
               }

               if(var35 > 128) {
                  var35 = 128;
               }

               this.field1989[var33] = (byte)var35;
               var32 += var44 - var46;
            }

            var45 = var30;
            var46 = var44;
         }

         for(var43 = var45; var43 < 128; ++var43) {
            var44 = var46 + (this.field1989[var43] & 255);
            if(var44 < 0) {
               var44 = 0;
            }

            if(var44 > 128) {
               var44 = 128;
            }

            this.field1989[var43] = (byte)var44;
         }

         Object var47 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field1898 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(null != var28.field1901) {
            var28.field1896 = var2.readUnsignedByte();
         }

         if(null != var28.field1894) {
            var28.field1897 = var2.readUnsignedByte();
         }

         if(var28.field1898 > 0) {
            var28.field1903 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field1900 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1900 > 0) {
            var28.field1895 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1895 > 0) {
            var28.field1899 = var2.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass60;[B[IB)Z",
      garbageValue = "-112"
   )
   boolean method2683(class60 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class55 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(null == var2 || var2[var7] != 0) {
            int var8 = this.field1991[var7];
            if(var8 != 0) {
               if(var8 != var5) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method1148(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1149(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(var6 != null) {
                  this.field1985[var7] = var6;
                  this.field1991[var7] = 0;
               }
            }
         }
      }

      return var4;
   }
}
