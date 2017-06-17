import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
public class class207 extends Node {
   @ObfuscatedName("e")
   short[] field2590;
   @ObfuscatedName("m")
   class107[] field2591;
   @ObfuscatedName("w")
   byte[] field2592;
   @ObfuscatedName("t")
   byte[] field2593;
   @ObfuscatedName("i")
   int[] field2594;
   @ObfuscatedName("z")
   class202[] field2595;
   @ObfuscatedName("j")
   byte[] field2596;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -368820511
   )
   int field2597;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1742011777"
   )
   void method3761() {
      this.field2594 = null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass112;[B[IB)Z",
      garbageValue = "26"
   )
   boolean method3763(class112 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class107 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(var2 == null || var2[var7] != 0) {
            int var8 = this.field2594[var7];
            if(var8 != 0) {
               if(var5 != var8) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method1993(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1994(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(var6 != null) {
                  this.field2591[var7] = var6;
                  this.field2594[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   class207(byte[] var1) {
      this.field2591 = new class107[128];
      this.field2590 = new short[128];
      this.field2593 = new byte[128];
      this.field2592 = new byte[128];
      this.field2595 = new class202[128];
      this.field2596 = new byte[128];
      this.field2594 = new int[128];
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
      for(var9 = 0; var2.payload[var9 + var2.offset] != 0; ++var9) {
         ;
      }

      byte[] var10 = new byte[var9];

      for(int var11 = 0; var11 < var9; ++var11) {
         var10[var11] = var2.readByte();
      }

      ++var2.offset;
      ++var9;
      byte[] var40 = new byte[var9];
      int var12;
      int var13;
      if(var9 > 1) {
         var40[1] = 1;
         int var14 = 1;
         var12 = 2;

         for(var13 = 2; var13 < var9; ++var13) {
            int var15 = var2.readUnsignedByte();
            if(var15 == 0) {
               var14 = var12++;
            } else {
               if(var15 <= var14) {
                  --var15;
               }

               var14 = var15;
            }

            var40[var13] = (byte)var14;
         }
      } else {
         var12 = var9;
      }

      class202[] var41 = new class202[var12];

      class202 var42;
      for(var13 = 0; var13 < var41.length; ++var13) {
         var42 = var41[var13] = new class202();
         int var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var42.field2510 = new byte[var16 * 2];
         }

         var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var42.field2506 = new byte[var16 * 2 + 2];
            var42.field2506[1] = 64;
         }
      }

      var13 = var2.readUnsignedByte();
      byte[] var43 = var13 > 0?new byte[var13 * 2]:null;
      var13 = var2.readUnsignedByte();
      byte[] var17 = var13 > 0?new byte[var13 * 2]:null;

      int var18;
      for(var18 = 0; var2.payload[var2.offset + var18] != 0; ++var18) {
         ;
      }

      byte[] var19 = new byte[var18];

      int var20;
      for(var20 = 0; var20 < var18; ++var20) {
         var19[var20] = var2.readByte();
      }

      ++var2.offset;
      ++var18;
      var20 = 0;

      int var21;
      for(var21 = 0; var21 < 128; ++var21) {
         var20 += var2.readUnsignedByte();
         this.field2590[var21] = (short)var20;
      }

      var20 = 0;

      for(var21 = 0; var21 < 128; ++var21) {
         var20 += var2.readUnsignedByte();
         this.field2590[var21] = (short)(this.field2590[var21] + (var20 << 8));
      }

      var21 = 0;
      int var22 = 0;
      int var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(var21 == 0) {
            if(var22 < var19.length) {
               var21 = var19[var22++];
            } else {
               var21 = -1;
            }

            var23 = var2.readVarInt();
         }

         this.field2590[var24] = (short)(this.field2590[var24] + ((var23 - 1 & 2) << 14));
         this.field2594[var24] = var23;
         --var21;
      }

      var21 = 0;
      var22 = 0;
      var24 = 0;

      int var25;
      for(var25 = 0; var25 < 128; ++var25) {
         if(this.field2594[var25] != 0) {
            if(var21 == 0) {
               if(var22 < var4.length) {
                  var21 = var4[var22++];
               } else {
                  var21 = -1;
               }

               var24 = var2.payload[var5++] - 1;
            }

            this.field2596[var25] = (byte)var24;
            --var21;
         }
      }

      var21 = 0;
      var22 = 0;
      var25 = 0;

      for(int var26 = 0; var26 < 128; ++var26) {
         if(this.field2594[var26] != 0) {
            if(var21 == 0) {
               if(var22 < var7.length) {
                  var21 = var7[var22++];
               } else {
                  var21 = -1;
               }

               var25 = var2.payload[var8++] + 16 << 2;
            }

            this.field2592[var26] = (byte)var25;
            --var21;
         }
      }

      var21 = 0;
      var22 = 0;
      class202 var44 = null;

      int var27;
      for(var27 = 0; var27 < 128; ++var27) {
         if(this.field2594[var27] != 0) {
            if(var21 == 0) {
               var44 = var41[var40[var22]];
               if(var22 < var10.length) {
                  var21 = var10[var22++];
               } else {
                  var21 = -1;
               }
            }

            this.field2595[var27] = var44;
            --var21;
         }
      }

      var21 = 0;
      var22 = 0;
      var27 = 0;

      int var28;
      for(var28 = 0; var28 < 128; ++var28) {
         if(var21 == 0) {
            if(var22 < var19.length) {
               var21 = var19[var22++];
            } else {
               var21 = -1;
            }

            if(this.field2594[var28] > 0) {
               var27 = var2.readUnsignedByte() + 1;
            }
         }

         this.field2593[var28] = (byte)var27;
         --var21;
      }

      this.field2597 = var2.readUnsignedByte() + 1;

      class202 var29;
      int var30;
      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var41[var28];
         if(var29.field2510 != null) {
            for(var30 = 1; var30 < var29.field2510.length; var30 += 2) {
               var29.field2510[var30] = var2.readByte();
            }
         }

         if(var29.field2506 != null) {
            for(var30 = 3; var30 < var29.field2506.length - 2; var30 += 2) {
               var29.field2506[var30] = var2.readByte();
            }
         }
      }

      if(var43 != null) {
         for(var28 = 1; var28 < var43.length; var28 += 2) {
            var43[var28] = var2.readByte();
         }
      }

      if(var17 != null) {
         for(var28 = 1; var28 < var17.length; var28 += 2) {
            var17[var28] = var2.readByte();
         }
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var41[var28];
         if(var29.field2506 != null) {
            var20 = 0;

            for(var30 = 2; var30 < var29.field2506.length; var30 += 2) {
               var20 = var20 + 1 + var2.readUnsignedByte();
               var29.field2506[var30] = (byte)var20;
            }
         }
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var41[var28];
         if(var29.field2510 != null) {
            var20 = 0;

            for(var30 = 2; var30 < var29.field2510.length; var30 += 2) {
               var20 = var20 + 1 + var2.readUnsignedByte();
               var29.field2510[var30] = (byte)var20;
            }
         }
      }

      byte var31;
      int var32;
      int var33;
      int var34;
      int var35;
      byte var36;
      if(var43 != null) {
         var20 = var2.readUnsignedByte();
         var43[0] = (byte)var20;

         for(var28 = 2; var28 < var43.length; var28 += 2) {
            var20 = var20 + 1 + var2.readUnsignedByte();
            var43[var28] = (byte)var20;
         }

         var36 = var43[0];
         byte var37 = var43[1];

         for(var30 = 0; var30 < var36; ++var30) {
            this.field2593[var30] = (byte)(var37 * this.field2593[var30] + 32 >> 6);
         }

         for(var30 = 2; var30 < var43.length; var30 += 2) {
            var31 = var43[var30];
            byte var38 = var43[var30 + 1];
            var32 = (var31 - var36) / 2 + var37 * (var31 - var36);

            for(var33 = var36; var33 < var31; ++var33) {
               var34 = class116.method2030(var32, var31 - var36);
               this.field2593[var33] = (byte)(this.field2593[var33] * var34 + 32 >> 6);
               var32 += var38 - var37;
            }

            var36 = var31;
            var37 = var38;
         }

         for(var35 = var36; var35 < 128; ++var35) {
            this.field2593[var35] = (byte)(this.field2593[var35] * var37 + 32 >> 6);
         }

         var42 = null;
      }

      if(var17 != null) {
         var20 = var2.readUnsignedByte();
         var17[0] = (byte)var20;

         for(var28 = 2; var28 < var17.length; var28 += 2) {
            var20 = var20 + 1 + var2.readUnsignedByte();
            var17[var28] = (byte)var20;
         }

         var36 = var17[0];
         int var45 = var17[1] << 1;

         for(var30 = 0; var30 < var36; ++var30) {
            var35 = (this.field2592[var30] & 255) + var45;
            if(var35 < 0) {
               var35 = 0;
            }

            if(var35 > 128) {
               var35 = 128;
            }

            this.field2592[var30] = (byte)var35;
         }

         int var46;
         for(var30 = 2; var30 < var17.length; var30 += 2) {
            var31 = var17[var30];
            var46 = var17[var30 + 1] << 1;
            var32 = var45 * (var31 - var36) + (var31 - var36) / 2;

            for(var33 = var36; var33 < var31; ++var33) {
               var34 = class116.method2030(var32, var31 - var36);
               int var39 = (this.field2592[var33] & 255) + var34;
               if(var39 < 0) {
                  var39 = 0;
               }

               if(var39 > 128) {
                  var39 = 128;
               }

               this.field2592[var33] = (byte)var39;
               var32 += var46 - var45;
            }

            var36 = var31;
            var45 = var46;
         }

         for(var35 = var36; var35 < 128; ++var35) {
            var46 = var45 + (this.field2592[var35] & 255);
            if(var46 < 0) {
               var46 = 0;
            }

            if(var46 > 128) {
               var46 = 128;
            }

            this.field2592[var35] = (byte)var46;
         }

         Object var47 = null;
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var41[var28].field2503 = var2.readUnsignedByte();
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var41[var28];
         if(var29.field2510 != null) {
            var29.field2511 = var2.readUnsignedByte();
         }

         if(var29.field2506 != null) {
            var29.field2505 = var2.readUnsignedByte();
         }

         if(var29.field2503 > 0) {
            var29.field2507 = var2.readUnsignedByte();
         }
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var41[var28].field2509 = var2.readUnsignedByte();
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var41[var28];
         if(var29.field2509 > 0) {
            var29.field2508 = var2.readUnsignedByte();
         }
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var41[var28];
         if(var29.field2508 > 0) {
            var29.field2504 = var2.readUnsignedByte();
         }
      }

   }
}
