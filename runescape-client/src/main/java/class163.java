import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
public class class163 extends Node {
   @ObfuscatedName("q")
   byte[] field2141;
   @ObfuscatedName("c")
   class55[] field2142;
   @ObfuscatedName("p")
   class158[] field2143;
   @ObfuscatedName("n")
   short[] field2144;
   @ObfuscatedName("t")
   byte[] field2145;
   @ObfuscatedName("u")
   byte[] field2146;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1162605653
   )
   int field2147;
   @ObfuscatedName("z")
   int[] field2148;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass61;[B[II)Z",
      garbageValue = "-1107573749"
   )
   boolean method3082(class61 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class55 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(var2 == null || var2[var7] != 0) {
            int var8 = this.field2148[var7];
            if(var8 != 0) {
               if(var5 != var8) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method1169(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1173(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(var6 != null) {
                  this.field2142[var7] = var6;
                  this.field2148[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1116121699"
   )
   void method3083() {
      this.field2148 = null;
   }

   class163(byte[] var1) {
      this.field2142 = new class55[128];
      this.field2144 = new short[128];
      this.field2141 = new byte[128];
      this.field2145 = new byte[128];
      this.field2143 = new class158[128];
      this.field2146 = new byte[128];
      this.field2148 = new int[128];
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

      class158[] var13 = new class158[var12];

      class158 var41;
      for(var14 = 0; var14 < var13.length; ++var14) {
         var41 = var13[var14] = new class158();
         int var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var41.field2058 = new byte[var16 * 2];
         }

         var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var41.field2056 = new byte[var16 * 2 + 2];
            var41.field2056[1] = 64;
         }
      }

      var14 = var2.readUnsignedByte();
      byte[] var48 = var14 > 0?new byte[var14 * 2]:null;
      var14 = var2.readUnsignedByte();
      byte[] var42 = var14 > 0?new byte[var14 * 2]:null;

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
         this.field2144[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.readUnsignedByte();
         this.field2144[var20] = (short)(this.field2144[var20] + (var19 << 8));
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

            var22 = var2.readVarInt();
         }

         this.field2144[var23] = (short)(this.field2144[var23] + ((var22 - 1 & 2) << 14));
         this.field2148[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2148[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.payload[var5++] - 1;
            }

            this.field2146[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if(this.field2148[var25] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.payload[var8++] + 16 << 2;
            }

            this.field2145[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class158 var43 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2148[var26] != 0) {
            if(var20 == 0) {
               var43 = var13[var39[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2143[var26] = var43;
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

            if(this.field2148[var27] > 0) {
               var26 = var2.readUnsignedByte() + 1;
            }
         }

         this.field2141[var27] = (byte)var26;
         --var20;
      }

      this.field2147 = var2.readUnsignedByte() + 1;

      class158 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field2058 != null) {
            for(var29 = 1; var29 < var28.field2058.length; var29 += 2) {
               var28.field2058[var29] = var2.readByte();
            }
         }

         if(var28.field2056 != null) {
            for(var29 = 3; var29 < var28.field2056.length - 2; var29 += 2) {
               var28.field2056[var29] = var2.readByte();
            }
         }
      }

      if(var48 != null) {
         for(var27 = 1; var27 < var48.length; var27 += 2) {
            var48[var27] = var2.readByte();
         }
      }

      if(var42 != null) {
         for(var27 = 1; var27 < var42.length; var27 += 2) {
            var42[var27] = var2.readByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field2056 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field2056.length; var29 += 2) {
               var19 = var19 + 1 + var2.readUnsignedByte();
               var28.field2056[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field2058 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field2058.length; var29 += 2) {
               var19 = var19 + 1 + var2.readUnsignedByte();
               var28.field2058[var29] = (byte)var19;
            }
         }
      }

      byte var30;
      int var32;
      int var33;
      int var34;
      int var35;
      int var36;
      int var44;
      byte var46;
      if(var48 != null) {
         var19 = var2.readUnsignedByte();
         var48[0] = (byte)var19;

         for(var27 = 2; var27 < var48.length; var27 += 2) {
            var19 = var19 + 1 + var2.readUnsignedByte();
            var48[var27] = (byte)var19;
         }

         var46 = var48[0];
         byte var38 = var48[1];

         for(var29 = 0; var29 < var46; ++var29) {
            this.field2141[var29] = (byte)(var38 * this.field2141[var29] + 32 >> 6);
         }

         for(var29 = 2; var29 < var48.length; var29 += 2) {
            var30 = var48[var29];
            byte var31 = var48[var29 + 1];
            var32 = (var30 - var46) / 2 + (var30 - var46) * var38;

            for(var33 = var46; var33 < var30; ++var33) {
               var35 = var30 - var46;
               var36 = var32 >>> 31;
               var34 = (var36 + var32) / var35 - var36;
               this.field2141[var33] = (byte)(var34 * this.field2141[var33] + 32 >> 6);
               var32 += var31 - var38;
            }

            var46 = var30;
            var38 = var31;
         }

         for(var44 = var46; var44 < 128; ++var44) {
            this.field2141[var44] = (byte)(var38 * this.field2141[var44] + 32 >> 6);
         }

         var41 = null;
      }

      if(var42 != null) {
         var19 = var2.readUnsignedByte();
         var42[0] = (byte)var19;

         for(var27 = 2; var27 < var42.length; var27 += 2) {
            var19 = var19 + 1 + var2.readUnsignedByte();
            var42[var27] = (byte)var19;
         }

         var46 = var42[0];
         int var47 = var42[1] << 1;

         for(var29 = 0; var29 < var46; ++var29) {
            var44 = (this.field2145[var29] & 255) + var47;
            if(var44 < 0) {
               var44 = 0;
            }

            if(var44 > 128) {
               var44 = 128;
            }

            this.field2145[var29] = (byte)var44;
         }

         int var45;
         for(var29 = 2; var29 < var42.length; var29 += 2) {
            var30 = var42[var29];
            var45 = var42[var29 + 1] << 1;
            var32 = (var30 - var46) / 2 + (var30 - var46) * var47;

            for(var33 = var46; var33 < var30; ++var33) {
               var35 = var30 - var46;
               var36 = var32 >>> 31;
               var34 = (var32 + var36) / var35 - var36;
               int var37 = (this.field2145[var33] & 255) + var34;
               if(var37 < 0) {
                  var37 = 0;
               }

               if(var37 > 128) {
                  var37 = 128;
               }

               this.field2145[var33] = (byte)var37;
               var32 += var45 - var47;
            }

            var46 = var30;
            var47 = var45;
         }

         for(var44 = var46; var44 < 128; ++var44) {
            var45 = (this.field2145[var44] & 255) + var47;
            if(var45 < 0) {
               var45 = 0;
            }

            if(var45 > 128) {
               var45 = 128;
            }

            this.field2145[var44] = (byte)var45;
         }

         Object var49 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field2054 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field2058 != null) {
            var28.field2055 = var2.readUnsignedByte();
         }

         if(var28.field2056 != null) {
            var28.field2062 = var2.readUnsignedByte();
         }

         if(var28.field2054 > 0) {
            var28.field2061 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field2059 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field2059 > 0) {
            var28.field2053 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field2053 > 0) {
            var28.field2060 = var2.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LIndexData;II)V",
      garbageValue = "-165099977"
   )
   static void method3087(IndexData var0, int var1) {
      if(class3.field35 != null) {
         class3.field35.offset = var1 * 8 + 5;
         int var2 = class3.field35.readInt();
         int var3 = class3.field35.readInt();
         var0.method3385(var2, var3);
      } else {
         class174.method3261((IndexData)null, 255, 255, 0, (byte)0, true);
         class187.field2757[var1] = var0;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1243918633"
   )
   public static void method3088() {
      KitDefinition.field2833.reset();
   }
}
