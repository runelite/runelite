import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
public class class142 extends Node {
   @ObfuscatedName("g")
   short[] field1992 = new short[128];
   @ObfuscatedName("n")
   class55[] field1993 = new class55[128];
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1105573205
   )
   int field1995;
   @ObfuscatedName("y")
   byte[] field1996 = new byte[128];
   @ObfuscatedName("j")
   byte[] field1997 = new byte[128];
   @ObfuscatedName("p")
   class137[] field1998 = new class137[128];
   @ObfuscatedName("m")
   int[] field1999 = new int[128];
   @ObfuscatedName("v")
   byte[] field2001 = new byte[128];

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-95"
   )
   void method2757() {
      this.field1999 = null;
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
      for(var6 = 0; var2.payload[var6 + var2.offset] != 0; ++var6) {
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
      byte[] var37 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var37[1] = 1;
         int var38 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var39 = var2.readUnsignedByte();
            if(var39 == 0) {
               var38 = var12++;
            } else {
               if(var39 <= var38) {
                  --var39;
               }

               var38 = var39;
            }

            var37[var14] = (byte)var38;
         }
      } else {
         var12 = var9;
      }

      class137[] var13 = new class137[var12];

      class137 var15;
      for(var14 = 0; var14 < var13.length; ++var14) {
         var15 = var13[var14] = new class137();
         int var40 = var2.readUnsignedByte();
         if(var40 > 0) {
            var15.field1908 = new byte[var40 * 2];
         }

         var40 = var2.readUnsignedByte();
         if(var40 > 0) {
            var15.field1904 = new byte[var40 * 2 + 2];
            var15.field1904[1] = 64;
         }
      }

      var14 = var2.readUnsignedByte();
      byte[] var42 = var14 > 0?new byte[2 * var14]:null;
      var14 = var2.readUnsignedByte();
      byte[] var16 = var14 > 0?new byte[var14 * 2]:null;

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

            var22 = var2.method3059();
         }

         this.field1992[var23] = (short)(this.field1992[var23] + ((var22 - 1 & 2) << 14));
         this.field1999[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field1999[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.payload[var5++] - 1;
            }

            this.field1997[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if(this.field1999[var25] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.payload[var8++] + 16 << 2;
            }

            this.field1996[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class137 var41 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field1999[var26] != 0) {
            if(var20 == 0) {
               var41 = var13[var37[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field1998[var26] = var41;
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

            if(this.field1999[var27] > 0) {
               var26 = var2.readUnsignedByte() + 1;
            }
         }

         this.field2001[var27] = (byte)var26;
         --var20;
      }

      this.field1995 = var2.readUnsignedByte() + 1;

      class137 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1908 != null) {
            for(var29 = 1; var29 < var28.field1908.length; var29 += 2) {
               var28.field1908[var29] = var2.readByte();
            }
         }

         if(null != var28.field1904) {
            for(var29 = 3; var29 < var28.field1904.length - 2; var29 += 2) {
               var28.field1904[var29] = var2.readByte();
            }
         }
      }

      if(var42 != null) {
         for(var27 = 1; var27 < var42.length; var27 += 2) {
            var42[var27] = var2.readByte();
         }
      }

      if(var16 != null) {
         for(var27 = 1; var27 < var16.length; var27 += 2) {
            var16[var27] = var2.readByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1904 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field1904.length; var29 += 2) {
               var19 = 1 + var19 + var2.readUnsignedByte();
               var28.field1904[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1908 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field1908.length; var29 += 2) {
               var19 = 1 + var19 + var2.readUnsignedByte();
               var28.field1908[var29] = (byte)var19;
            }
         }
      }

      byte var30;
      int var32;
      int var33;
      int var34;
      int var44;
      byte var46;
      if(var42 != null) {
         var19 = var2.readUnsignedByte();
         var42[0] = (byte)var19;

         for(var27 = 2; var27 < var42.length; var27 += 2) {
            var19 = var19 + 1 + var2.readUnsignedByte();
            var42[var27] = (byte)var19;
         }

         var46 = var42[0];
         byte var36 = var42[1];

         for(var29 = 0; var29 < var46; ++var29) {
            this.field2001[var29] = (byte)(32 + var36 * this.field2001[var29] >> 6);
         }

         for(var29 = 2; var29 < var42.length; var29 += 2) {
            var30 = var42[var29];
            byte var31 = var42[1 + var29];
            var32 = (var30 - var46) / 2 + var36 * (var30 - var46);

            for(var33 = var46; var33 < var30; ++var33) {
               var34 = class156.method3126(var32, var30 - var46);
               this.field2001[var33] = (byte)(32 + var34 * this.field2001[var33] >> 6);
               var32 += var31 - var36;
            }

            var46 = var30;
            var36 = var31;
         }

         for(var44 = var46; var44 < 128; ++var44) {
            this.field2001[var44] = (byte)(32 + this.field2001[var44] * var36 >> 6);
         }

         var15 = null;
      }

      if(null != var16) {
         var19 = var2.readUnsignedByte();
         var16[0] = (byte)var19;

         for(var27 = 2; var27 < var16.length; var27 += 2) {
            var19 = 1 + var19 + var2.readUnsignedByte();
            var16[var27] = (byte)var19;
         }

         var46 = var16[0];
         int var47 = var16[1] << 1;

         for(var29 = 0; var29 < var46; ++var29) {
            var44 = (this.field1996[var29] & 255) + var47;
            if(var44 < 0) {
               var44 = 0;
            }

            if(var44 > 128) {
               var44 = 128;
            }

            this.field1996[var29] = (byte)var44;
         }

         int var45;
         for(var29 = 2; var29 < var16.length; var29 += 2) {
            var30 = var16[var29];
            var45 = var16[var29 + 1] << 1;
            var32 = var47 * (var30 - var46) + (var30 - var46) / 2;

            for(var33 = var46; var33 < var30; ++var33) {
               var34 = class156.method3126(var32, var30 - var46);
               int var35 = var34 + (this.field1996[var33] & 255);
               if(var35 < 0) {
                  var35 = 0;
               }

               if(var35 > 128) {
                  var35 = 128;
               }

               this.field1996[var33] = (byte)var35;
               var32 += var45 - var47;
            }

            var46 = var30;
            var47 = var45;
         }

         for(var44 = var46; var44 < 128; ++var44) {
            var45 = var47 + (this.field1996[var44] & 255);
            if(var45 < 0) {
               var45 = 0;
            }

            if(var45 > 128) {
               var45 = 128;
            }

            this.field1996[var44] = (byte)var45;
         }

         Object var43 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field1914 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(null != var28.field1908) {
            var28.field1907 = var2.readUnsignedByte();
         }

         if(null != var28.field1904) {
            var28.field1906 = var2.readUnsignedByte();
         }

         if(var28.field1914 > 0) {
            var28.field1905 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field1911 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1911 > 0) {
            var28.field1910 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1910 > 0) {
            var28.field1912 = var2.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass60;[B[II)Z",
      garbageValue = "1095480355"
   )
   boolean method2759(class60 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class55 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(null == var2 || var2[var7] != 0) {
            int var8 = this.field1999[var7];
            if(var8 != 0) {
               if(var5 != var8) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method1219(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1220(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(var6 != null) {
                  this.field1993[var7] = var6;
                  this.field1999[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Lclass187;",
      garbageValue = "10333996"
   )
   public static class187 method2762(int var0) {
      class187 var1 = (class187)class187.field2778.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class168.field2192.getConfigData(16, var0);
         var1 = new class187();
         if(var2 != null) {
            var1.method3500(new Buffer(var2));
         }

         class187.field2778.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)Lclass195;",
      garbageValue = "0"
   )
   public static class195 method2763(int var0) {
      class195 var1 = (class195)class195.field2867.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class195.field2860.getConfigData(8, var0);
         var1 = new class195();
         if(null != var2) {
            var1.method3618(new Buffer(var2));
         }

         class195.field2867.put(var1, (long)var0);
         return var1;
      }
   }
}
