import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
public class class142 extends Node {
   @ObfuscatedName("d")
   class55[] field1991 = new class55[128];
   @ObfuscatedName("h")
   short[] field1992 = new short[128];
   @ObfuscatedName("p")
   byte[] field1993 = new byte[128];
   @ObfuscatedName("j")
   byte[] field1994 = new byte[128];
   @ObfuscatedName("n")
   class137[] field1995 = new class137[128];
   @ObfuscatedName("r")
   byte[] field1996 = new byte[128];
   @ObfuscatedName("c")
   int[] field1997 = new int[128];
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -1683840327
   )
   static int field1999;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1085387187
   )
   int field2000;
   @ObfuscatedName("f")
   public static Buffer field2001;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass60;[B[IB)Z",
      garbageValue = "27"
   )
   boolean method2711(class60 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class55 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(var2 == null || var2[var7] != 0) {
            int var8 = this.field1997[var7];
            if(var8 != 0) {
               if(var5 != var8) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method1194(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1199(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(null != var6) {
                  this.field1991[var7] = var6;
                  this.field1997[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "533336611"
   )
   void method2712() {
      this.field1997 = null;
   }

   class142(byte[] var1) {
      Buffer var2 = new Buffer(var1);

      int var3;
      for(var3 = 0; var2.payload[var2.offset + var3] != 0; ++var3) {
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
      for(var9 = 0; var2.payload[var9 + var2.offset] != 0; ++var9) {
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
            int var15 = var2.readUnsignedByte();
            if(var15 == 0) {
               var40 = var12++;
            } else {
               if(var15 <= var40) {
                  --var15;
               }

               var40 = var15;
            }

            var39[var14] = (byte)var40;
         }
      } else {
         var12 = var9;
      }

      class137[] var13 = new class137[var12];

      class137 var41;
      for(var14 = 0; var14 < var13.length; ++var14) {
         var41 = var13[var14] = new class137();
         int var38 = var2.readUnsignedByte();
         if(var38 > 0) {
            var41.field1903 = new byte[var38 * 2];
         }

         var38 = var2.readUnsignedByte();
         if(var38 > 0) {
            var41.field1902 = new byte[2 + 2 * var38];
            var41.field1902[1] = 64;
         }
      }

      var14 = var2.readUnsignedByte();
      byte[] var48 = var14 > 0?new byte[2 * var14]:null;
      var14 = var2.readUnsignedByte();
      byte[] var16 = var14 > 0?new byte[2 * var14]:null;

      int var17;
      for(var17 = 0; var2.payload[var2.offset + var17] != 0; ++var17) {
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
         this.field1992[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.readUnsignedByte();
         this.field1992[var20] = (short)(this.field1992[var20] + (var19 << 8));
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

            var22 = var2.method2849();
         }

         this.field1992[var23] = (short)(this.field1992[var23] + ((var22 - 1 & 2) << 14));
         this.field1997[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field1997[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.payload[var5++] - 1;
            }

            this.field1996[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var42 = 0; var42 < 128; ++var42) {
         if(this.field1997[var42] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.payload[var8++] + 16 << 2;
            }

            this.field1994[var42] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class137 var25 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field1997[var26] != 0) {
            if(var20 == 0) {
               var25 = var13[var39[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field1995[var26] = var25;
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

            if(this.field1997[var27] > 0) {
               var26 = var2.readUnsignedByte() + 1;
            }
         }

         this.field1993[var27] = (byte)var26;
         --var20;
      }

      this.field2000 = var2.readUnsignedByte() + 1;

      class137 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(null != var28.field1903) {
            for(var29 = 1; var29 < var28.field1903.length; var29 += 2) {
               var28.field1903[var29] = var2.readByte();
            }
         }

         if(null != var28.field1902) {
            for(var29 = 3; var29 < var28.field1902.length - 2; var29 += 2) {
               var28.field1902[var29] = var2.readByte();
            }
         }
      }

      if(null != var48) {
         for(var27 = 1; var27 < var48.length; var27 += 2) {
            var48[var27] = var2.readByte();
         }
      }

      if(var16 != null) {
         for(var27 = 1; var27 < var16.length; var27 += 2) {
            var16[var27] = var2.readByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1902 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field1902.length; var29 += 2) {
               var19 = 1 + var19 + var2.readUnsignedByte();
               var28.field1902[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1903 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field1903.length; var29 += 2) {
               var19 = 1 + var19 + var2.readUnsignedByte();
               var28.field1903[var29] = (byte)var19;
            }
         }
      }

      byte var30;
      int var32;
      int var33;
      int var34;
      int var35;
      int var36;
      int var45;
      byte var47;
      if(var48 != null) {
         var19 = var2.readUnsignedByte();
         var48[0] = (byte)var19;

         for(var27 = 2; var27 < var48.length; var27 += 2) {
            var19 = 1 + var19 + var2.readUnsignedByte();
            var48[var27] = (byte)var19;
         }

         var47 = var48[0];
         byte var43 = var48[1];

         for(var29 = 0; var29 < var47; ++var29) {
            this.field1993[var29] = (byte)(32 + this.field1993[var29] * var43 >> 6);
         }

         for(var29 = 2; var29 < var48.length; var29 += 2) {
            var30 = var48[var29];
            byte var31 = var48[var29 + 1];
            var32 = (var30 - var47) * var43 + (var30 - var47) / 2;

            for(var33 = var47; var33 < var30; ++var33) {
               var35 = var30 - var47;
               var36 = var32 >>> 31;
               var34 = (var32 + var36) / var35 - var36;
               this.field1993[var33] = (byte)(32 + this.field1993[var33] * var34 >> 6);
               var32 += var31 - var43;
            }

            var47 = var30;
            var43 = var31;
         }

         for(var45 = var47; var45 < 128; ++var45) {
            this.field1993[var45] = (byte)(this.field1993[var45] * var43 + 32 >> 6);
         }

         var41 = null;
      }

      if(null != var16) {
         var19 = var2.readUnsignedByte();
         var16[0] = (byte)var19;

         for(var27 = 2; var27 < var16.length; var27 += 2) {
            var19 = 1 + var19 + var2.readUnsignedByte();
            var16[var27] = (byte)var19;
         }

         var47 = var16[0];
         int var49 = var16[1] << 1;

         for(var29 = 0; var29 < var47; ++var29) {
            var45 = (this.field1994[var29] & 255) + var49;
            if(var45 < 0) {
               var45 = 0;
            }

            if(var45 > 128) {
               var45 = 128;
            }

            this.field1994[var29] = (byte)var45;
         }

         int var46;
         for(var29 = 2; var29 < var16.length; var29 += 2) {
            var30 = var16[var29];
            var46 = var16[1 + var29] << 1;
            var32 = (var30 - var47) * var49 + (var30 - var47) / 2;

            for(var33 = var47; var33 < var30; ++var33) {
               var35 = var30 - var47;
               var36 = var32 >>> 31;
               var34 = (var32 + var36) / var35 - var36;
               int var37 = var34 + (this.field1994[var33] & 255);
               if(var37 < 0) {
                  var37 = 0;
               }

               if(var37 > 128) {
                  var37 = 128;
               }

               this.field1994[var33] = (byte)var37;
               var32 += var46 - var49;
            }

            var47 = var30;
            var49 = var46;
         }

         for(var45 = var47; var45 < 128; ++var45) {
            var46 = (this.field1994[var45] & 255) + var49;
            if(var46 < 0) {
               var46 = 0;
            }

            if(var46 > 128) {
               var46 = 128;
            }

            this.field1994[var45] = (byte)var46;
         }

         Object var44 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field1912 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(null != var28.field1903) {
            var28.field1901 = var2.readUnsignedByte();
         }

         if(var28.field1902 != null) {
            var28.field1905 = var2.readUnsignedByte();
         }

         if(var28.field1912 > 0) {
            var28.field1906 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field1910 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1910 > 0) {
            var28.field1907 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1907 > 0) {
            var28.field1908 = var2.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1184109062"
   )
   static void method2714() {
      int var0 = class32.field758;
      int var1 = class47.field950;
      if(class49.field976 < var0) {
         var0 = class49.field976;
      }

      if(class26.field619 < var1) {
         var1 = class26.field619;
      }

      if(null != class184.field2735) {
         try {
            class100.method2007(Client.field508, "resize", new Object[]{Integer.valueOf(class8.method97())});
         } catch (Throwable var3) {
            ;
         }
      }

   }
}
