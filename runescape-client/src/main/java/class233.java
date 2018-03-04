import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
public class class233 extends Node {
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = 1377115559
   )
   @Export("port1")
   static int port1;
   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "[Llv;"
   )
   @Export("scrollbarSprites")
   static IndexedSprite[] scrollbarSprites;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1411517143
   )
   int field2765;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "[Ldd;"
   )
   RawAudioNode[] field2760;
   @ObfuscatedName("n")
   short[] field2761;
   @ObfuscatedName("r")
   byte[] field2762;
   @ObfuscatedName("e")
   byte[] field2763;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "[Lhi;"
   )
   class228[] field2764;
   @ObfuscatedName("k")
   byte[] field2767;
   @ObfuscatedName("s")
   int[] field2766;

   class233(byte[] var1) {
      this.field2760 = new RawAudioNode[128];
      this.field2761 = new short[128];
      this.field2762 = new byte[128];
      this.field2763 = new byte[128];
      this.field2764 = new class228[128];
      this.field2767 = new byte[128];
      this.field2766 = new int[128];
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
      for(var9 = 0; var2.payload[var9 + var2.offset] != 0; ++var9) {
         ;
      }

      byte[] var10 = new byte[var9];

      for(int var11 = 0; var11 < var9; ++var11) {
         var10[var11] = var2.readByte();
      }

      ++var2.offset;
      ++var9;
      byte[] var38 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var38[1] = 1;
         int var13 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var15 = var2.readUnsignedByte();
            if(var15 == 0) {
               var13 = var12++;
            } else {
               if(var15 <= var13) {
                  --var15;
               }

               var13 = var15;
            }

            var38[var14] = (byte)var13;
         }
      } else {
         var12 = var9;
      }

      class228[] var39 = new class228[var12];

      class228 var40;
      for(var14 = 0; var14 < var39.length; ++var14) {
         var40 = var39[var14] = new class228();
         int var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var40.field2679 = new byte[var16 * 2];
         }

         var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var40.field2678 = new byte[var16 * 2 + 2];
            var40.field2678[1] = 64;
         }
      }

      var14 = var2.readUnsignedByte();
      byte[] var47 = var14 > 0?new byte[var14 * 2]:null;
      var14 = var2.readUnsignedByte();
      byte[] var41 = var14 > 0?new byte[var14 * 2]:null;

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
         this.field2761[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.readUnsignedByte();
         this.field2761[var20] = (short)(this.field2761[var20] + (var19 << 8));
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

         this.field2761[var23] = (short)(this.field2761[var23] + ((var22 - 1 & 2) << 14));
         this.field2766[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2766[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.payload[var5++] - 1;
            }

            this.field2767[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if(this.field2766[var25] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.payload[var8++] + 16 << 2;
            }

            this.field2763[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class228 var42 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2766[var26] != 0) {
            if(var20 == 0) {
               var42 = var39[var38[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2764[var26] = var42;
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

            if(this.field2766[var27] > 0) {
               var26 = var2.readUnsignedByte() + 1;
            }
         }

         this.field2762[var27] = (byte)var26;
         --var20;
      }

      this.field2765 = var2.readUnsignedByte() + 1;

      class228 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field2679 != null) {
            for(var29 = 1; var29 < var28.field2679.length; var29 += 2) {
               var28.field2679[var29] = var2.readByte();
            }
         }

         if(var28.field2678 != null) {
            for(var29 = 3; var29 < var28.field2678.length - 2; var29 += 2) {
               var28.field2678[var29] = var2.readByte();
            }
         }
      }

      if(var47 != null) {
         for(var27 = 1; var27 < var47.length; var27 += 2) {
            var47[var27] = var2.readByte();
         }
      }

      if(var41 != null) {
         for(var27 = 1; var27 < var41.length; var27 += 2) {
            var41[var27] = var2.readByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field2678 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field2678.length; var29 += 2) {
               var19 = var19 + 1 + var2.readUnsignedByte();
               var28.field2678[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field2679 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field2679.length; var29 += 2) {
               var19 = 1 + var19 + var2.readUnsignedByte();
               var28.field2679[var29] = (byte)var19;
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
      if(var47 != null) {
         var19 = var2.readUnsignedByte();
         var47[0] = (byte)var19;

         for(var27 = 2; var27 < var47.length; var27 += 2) {
            var19 = 1 + var19 + var2.readUnsignedByte();
            var47[var27] = (byte)var19;
         }

         var46 = var47[0];
         byte var43 = var47[1];

         for(var29 = 0; var29 < var46; ++var29) {
            this.field2762[var29] = (byte)(var43 * this.field2762[var29] + 32 >> 6);
         }

         for(var29 = 2; var29 < var47.length; var29 += 2) {
            var30 = var47[var29];
            byte var31 = var47[var29 + 1];
            var32 = var43 * (var30 - var46) + (var30 - var46) / 2;

            for(var33 = var46; var33 < var30; ++var33) {
               var35 = var30 - var46;
               var36 = var32 >>> 31;
               var34 = (var36 + var32) / var35 - var36;
               this.field2762[var33] = (byte)(var34 * this.field2762[var33] + 32 >> 6);
               var32 += var31 - var43;
            }

            var46 = var30;
            var43 = var31;
         }

         for(var44 = var46; var44 < 128; ++var44) {
            this.field2762[var44] = (byte)(var43 * this.field2762[var44] + 32 >> 6);
         }

         var40 = null;
      }

      if(var41 != null) {
         var19 = var2.readUnsignedByte();
         var41[0] = (byte)var19;

         for(var27 = 2; var27 < var41.length; var27 += 2) {
            var19 = 1 + var19 + var2.readUnsignedByte();
            var41[var27] = (byte)var19;
         }

         var46 = var41[0];
         int var49 = var41[1] << 1;

         for(var29 = 0; var29 < var46; ++var29) {
            var44 = var49 + (this.field2763[var29] & 255);
            if(var44 < 0) {
               var44 = 0;
            }

            if(var44 > 128) {
               var44 = 128;
            }

            this.field2763[var29] = (byte)var44;
         }

         int var45;
         for(var29 = 2; var29 < var41.length; var29 += 2) {
            var30 = var41[var29];
            var45 = var41[var29 + 1] << 1;
            var32 = var49 * (var30 - var46) + (var30 - var46) / 2;

            for(var33 = var46; var33 < var30; ++var33) {
               var35 = var30 - var46;
               var36 = var32 >>> 31;
               var34 = (var32 + var36) / var35 - var36;
               int var37 = var34 + (this.field2763[var33] & 255);
               if(var37 < 0) {
                  var37 = 0;
               }

               if(var37 > 128) {
                  var37 = 128;
               }

               this.field2763[var33] = (byte)var37;
               var32 += var45 - var49;
            }

            var46 = var30;
            var49 = var45;
         }

         for(var44 = var46; var44 < 128; ++var44) {
            var45 = var49 + (this.field2763[var44] & 255);
            if(var45 < 0) {
               var45 = 0;
            }

            if(var45 > 128) {
               var45 = 128;
            }

            this.field2763[var44] = (byte)var45;
         }

         Object var48 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var39[var27].field2686 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field2679 != null) {
            var28.field2677 = var2.readUnsignedByte();
         }

         if(var28.field2678 != null) {
            var28.field2681 = var2.readUnsignedByte();
         }

         if(var28.field2686 > 0) {
            var28.field2682 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var39[var27].field2684 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field2684 > 0) {
            var28.field2680 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field2680 > 0) {
            var28.field2683 = var2.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ldc;[B[II)Z",
      garbageValue = "-1887777313"
   )
   boolean method4426(class110 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      RawAudioNode var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(var2 == null || var2[var7] != 0) {
            int var8 = this.field2766[var7];
            if(var8 != 0) {
               if(var8 != var5) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method2329(var8 >> 2, var3);
                  } else {
                     var6 = var1.method2327(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(var6 != null) {
                  this.field2760[var7] = var6;
                  this.field2766[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1952457686"
   )
   void method4427() {
      this.field2766 = null;
   }
}
