import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
public class class207 extends Node {
   @ObfuscatedName("h")
   class107[] field2570;
   @ObfuscatedName("u")
   short[] field2571;
   @ObfuscatedName("q")
   byte[] field2572;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -932006437
   )
   int field2573;
   @ObfuscatedName("v")
   class202[] field2574;
   @ObfuscatedName("t")
   byte[] field2575;
   @ObfuscatedName("p")
   int[] field2576;
   @ObfuscatedName("g")
   byte[] field2577;

   class207(byte[] var1) {
      this.field2570 = new class107[128];
      this.field2571 = new short[128];
      this.field2572 = new byte[128];
      this.field2577 = new byte[128];
      this.field2574 = new class202[128];
      this.field2575 = new byte[128];
      this.field2576 = new int[128];
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
         int var36 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var37 = var2.readUnsignedByte();
            if(var37 == 0) {
               var36 = var12++;
            } else {
               if(var37 <= var36) {
                  --var37;
               }

               var36 = var37;
            }

            var39[var14] = (byte)var36;
         }
      } else {
         var12 = var9;
      }

      class202[] var13 = new class202[var12];

      class202 var15;
      for(var14 = 0; var14 < var13.length; ++var14) {
         var15 = var13[var14] = new class202();
         int var38 = var2.readUnsignedByte();
         if(var38 > 0) {
            var15.field2492 = new byte[var38 * 2];
         }

         var38 = var2.readUnsignedByte();
         if(var38 > 0) {
            var15.field2487 = new byte[var38 * 2 + 2];
            var15.field2487[1] = 64;
         }
      }

      var14 = var2.readUnsignedByte();
      byte[] var42 = var14 > 0?new byte[var14 * 2]:null;
      var14 = var2.readUnsignedByte();
      byte[] var16 = var14 > 0?new byte[var14 * 2]:null;

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
         this.field2571[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.readUnsignedByte();
         this.field2571[var20] = (short)(this.field2571[var20] + (var19 << 8));
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

         this.field2571[var23] = (short)(this.field2571[var23] + ((var22 - 1 & 2) << 14));
         this.field2576[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2576[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.payload[var5++] - 1;
            }

            this.field2575[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var40 = 0; var40 < 128; ++var40) {
         if(this.field2576[var40] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.payload[var8++] + 16 << 2;
            }

            this.field2577[var40] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class202 var25 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2576[var26] != 0) {
            if(var20 == 0) {
               var25 = var13[var39[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2574[var26] = var25;
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

            if(this.field2576[var27] > 0) {
               var26 = var2.readUnsignedByte() + 1;
            }
         }

         this.field2572[var27] = (byte)var26;
         --var20;
      }

      this.field2573 = var2.readUnsignedByte() + 1;

      class202 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field2492 != null) {
            for(var29 = 1; var29 < var28.field2492.length; var29 += 2) {
               var28.field2492[var29] = var2.readByte();
            }
         }

         if(var28.field2487 != null) {
            for(var29 = 3; var29 < var28.field2487.length - 2; var29 += 2) {
               var28.field2487[var29] = var2.readByte();
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
         if(var28.field2487 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field2487.length; var29 += 2) {
               var19 = var19 + 1 + var2.readUnsignedByte();
               var28.field2487[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field2492 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field2492.length; var29 += 2) {
               var19 = var19 + 1 + var2.readUnsignedByte();
               var28.field2492[var29] = (byte)var19;
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
         byte var41 = var42[1];

         for(var29 = 0; var29 < var46; ++var29) {
            this.field2572[var29] = (byte)(this.field2572[var29] * var41 + 32 >> 6);
         }

         for(var29 = 2; var29 < var42.length; var29 += 2) {
            var30 = var42[var29];
            byte var31 = var42[var29 + 1];
            var32 = (var30 - var46) * var41 + (var30 - var46) / 2;

            for(var33 = var46; var33 < var30; ++var33) {
               var34 = GameEngine.method866(var32, var30 - var46);
               this.field2572[var33] = (byte)(this.field2572[var33] * var34 + 32 >> 6);
               var32 += var31 - var41;
            }

            var46 = var30;
            var41 = var31;
         }

         for(var44 = var46; var44 < 128; ++var44) {
            this.field2572[var44] = (byte)(this.field2572[var44] * var41 + 32 >> 6);
         }

         var15 = null;
      }

      if(var16 != null) {
         var19 = var2.readUnsignedByte();
         var16[0] = (byte)var19;

         for(var27 = 2; var27 < var16.length; var27 += 2) {
            var19 = var19 + 1 + var2.readUnsignedByte();
            var16[var27] = (byte)var19;
         }

         var46 = var16[0];
         int var47 = var16[1] << 1;

         for(var29 = 0; var29 < var46; ++var29) {
            var44 = var47 + (this.field2577[var29] & 255);
            if(var44 < 0) {
               var44 = 0;
            }

            if(var44 > 128) {
               var44 = 128;
            }

            this.field2577[var29] = (byte)var44;
         }

         int var45;
         for(var29 = 2; var29 < var16.length; var29 += 2) {
            var30 = var16[var29];
            var45 = var16[var29 + 1] << 1;
            var32 = (var30 - var46) * var47 + (var30 - var46) / 2;

            for(var33 = var46; var33 < var30; ++var33) {
               var34 = GameEngine.method866(var32, var30 - var46);
               int var35 = var34 + (this.field2577[var33] & 255);
               if(var35 < 0) {
                  var35 = 0;
               }

               if(var35 > 128) {
                  var35 = 128;
               }

               this.field2577[var33] = (byte)var35;
               var32 += var45 - var47;
            }

            var46 = var30;
            var47 = var45;
         }

         for(var44 = var46; var44 < 128; ++var44) {
            var45 = (this.field2577[var44] & 255) + var47;
            if(var45 < 0) {
               var45 = 0;
            }

            if(var45 > 128) {
               var45 = 128;
            }

            this.field2577[var44] = (byte)var45;
         }

         Object var43 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field2488 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field2492 != null) {
            var28.field2489 = var2.readUnsignedByte();
         }

         if(var28.field2487 != null) {
            var28.field2486 = var2.readUnsignedByte();
         }

         if(var28.field2488 > 0) {
            var28.field2490 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field2493 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field2493 > 0) {
            var28.field2491 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field2491 > 0) {
            var28.field2494 = var2.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass112;[B[IB)Z",
      garbageValue = "83"
   )
   boolean method3936(class112 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class107 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(var2 == null || var2[var7] != 0) {
            int var8 = this.field2576[var7];
            if(var8 != 0) {
               if(var8 != var5) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method2126(var8 >> 2, var3);
                  } else {
                     var6 = var1.method2121(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(var6 != null) {
                  this.field2570[var7] = var6;
                  this.field2576[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-90"
   )
   void method3937() {
      this.field2576 = null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1747081068"
   )
   public static void method3942() {
      Object var0 = class236.field3225;
      synchronized(class236.field3225) {
         if(class236.field3227 != 0) {
            class236.field3227 = 1;

            try {
               class236.field3225.wait();
            } catch (InterruptedException var3) {
               ;
            }
         }

      }
   }
}
