import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
public class class207 extends Node {
   @ObfuscatedName("r")
   class202[] field2581;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -513032317
   )
   static int field2582;
   @ObfuscatedName("v")
   byte[] field2583;
   @ObfuscatedName("t")
   byte[] field2584;
   @ObfuscatedName("s")
   byte[] field2585;
   @ObfuscatedName("w")
   class107[] field2586;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1980631887
   )
   int field2588;
   @ObfuscatedName("y")
   int[] field2589;
   @ObfuscatedName("a")
   short[] field2590;
   @ObfuscatedName("pz")
   @ObfuscatedGetter(
      intValue = -2036218587
   )
   static int field2591;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-49"
   )
   void method3858() {
      this.field2589 = null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass112;[B[II)Z",
      garbageValue = "636074259"
   )
   boolean method3859(class112 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class107 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(var2 == null || var2[var7] != 0) {
            int var8 = this.field2589[var7];
            if(var8 != 0) {
               if(var5 != var8) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method2087(var8 >> 2, var3);
                  } else {
                     var6 = var1.method2085(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(var6 != null) {
                  this.field2586[var7] = var6;
                  this.field2589[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   class207(byte[] var1) {
      this.field2586 = new class107[128];
      this.field2590 = new short[128];
      this.field2584 = new byte[128];
      this.field2585 = new byte[128];
      this.field2581 = new class202[128];
      this.field2583 = new byte[128];
      this.field2589 = new int[128];
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
      byte[] var36 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var36[1] = 1;
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

            var36[var14] = (byte)var13;
         }
      } else {
         var12 = var9;
      }

      class202[] var37 = new class202[var12];

      class202 var38;
      for(var14 = 0; var14 < var37.length; ++var14) {
         var38 = var37[var14] = new class202();
         int var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var38.field2503 = new byte[var16 * 2];
         }

         var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var38.field2494 = new byte[var16 * 2 + 2];
            var38.field2494[1] = 64;
         }
      }

      var14 = var2.readUnsignedByte();
      byte[] var45 = var14 > 0?new byte[var14 * 2]:null;
      var14 = var2.readUnsignedByte();
      byte[] var39 = var14 > 0?new byte[var14 * 2]:null;

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
         this.field2590[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.readUnsignedByte();
         this.field2590[var20] = (short)(this.field2590[var20] + (var19 << 8));
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

         this.field2590[var23] = (short)(this.field2590[var23] + ((var22 - 1 & 2) << 14));
         this.field2589[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2589[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.payload[var5++] - 1;
            }

            this.field2583[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if(this.field2589[var25] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.payload[var8++] + 16 << 2;
            }

            this.field2585[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class202 var40 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2589[var26] != 0) {
            if(var20 == 0) {
               var40 = var37[var36[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2581[var26] = var40;
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

            if(this.field2589[var27] > 0) {
               var26 = var2.readUnsignedByte() + 1;
            }
         }

         this.field2584[var27] = (byte)var26;
         --var20;
      }

      this.field2588 = var2.readUnsignedByte() + 1;

      class202 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field2503 != null) {
            for(var29 = 1; var29 < var28.field2503.length; var29 += 2) {
               var28.field2503[var29] = var2.readByte();
            }
         }

         if(var28.field2494 != null) {
            for(var29 = 3; var29 < var28.field2494.length - 2; var29 += 2) {
               var28.field2494[var29] = var2.readByte();
            }
         }
      }

      if(var45 != null) {
         for(var27 = 1; var27 < var45.length; var27 += 2) {
            var45[var27] = var2.readByte();
         }
      }

      if(var39 != null) {
         for(var27 = 1; var27 < var39.length; var27 += 2) {
            var39[var27] = var2.readByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field2494 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field2494.length; var29 += 2) {
               var19 = var19 + 1 + var2.readUnsignedByte();
               var28.field2494[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field2503 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field2503.length; var29 += 2) {
               var19 = var19 + 1 + var2.readUnsignedByte();
               var28.field2503[var29] = (byte)var19;
            }
         }
      }

      byte var30;
      int var32;
      int var33;
      int var34;
      int var42;
      byte var44;
      if(var45 != null) {
         var19 = var2.readUnsignedByte();
         var45[0] = (byte)var19;

         for(var27 = 2; var27 < var45.length; var27 += 2) {
            var19 = var19 + 1 + var2.readUnsignedByte();
            var45[var27] = (byte)var19;
         }

         var44 = var45[0];
         byte var41 = var45[1];

         for(var29 = 0; var29 < var44; ++var29) {
            this.field2584[var29] = (byte)(var41 * this.field2584[var29] + 32 >> 6);
         }

         for(var29 = 2; var29 < var45.length; var29 += 2) {
            var30 = var45[var29];
            byte var31 = var45[var29 + 1];
            var32 = (var30 - var44) / 2 + var41 * (var30 - var44);

            for(var33 = var44; var33 < var30; ++var33) {
               var34 = Sequence.method4728(var32, var30 - var44);
               this.field2584[var33] = (byte)(var34 * this.field2584[var33] + 32 >> 6);
               var32 += var31 - var41;
            }

            var44 = var30;
            var41 = var31;
         }

         for(var42 = var44; var42 < 128; ++var42) {
            this.field2584[var42] = (byte)(var41 * this.field2584[var42] + 32 >> 6);
         }

         var38 = null;
      }

      if(var39 != null) {
         var19 = var2.readUnsignedByte();
         var39[0] = (byte)var19;

         for(var27 = 2; var27 < var39.length; var27 += 2) {
            var19 = var19 + 1 + var2.readUnsignedByte();
            var39[var27] = (byte)var19;
         }

         var44 = var39[0];
         int var47 = var39[1] << 1;

         for(var29 = 0; var29 < var44; ++var29) {
            var42 = var47 + (this.field2585[var29] & 255);
            if(var42 < 0) {
               var42 = 0;
            }

            if(var42 > 128) {
               var42 = 128;
            }

            this.field2585[var29] = (byte)var42;
         }

         int var43;
         for(var29 = 2; var29 < var39.length; var29 += 2) {
            var30 = var39[var29];
            var43 = var39[var29 + 1] << 1;
            var32 = (var30 - var44) / 2 + (var30 - var44) * var47;

            for(var33 = var44; var33 < var30; ++var33) {
               var34 = Sequence.method4728(var32, var30 - var44);
               int var35 = var34 + (this.field2585[var33] & 255);
               if(var35 < 0) {
                  var35 = 0;
               }

               if(var35 > 128) {
                  var35 = 128;
               }

               this.field2585[var33] = (byte)var35;
               var32 += var43 - var47;
            }

            var44 = var30;
            var47 = var43;
         }

         for(var42 = var44; var42 < 128; ++var42) {
            var43 = var47 + (this.field2585[var42] & 255);
            if(var43 < 0) {
               var43 = 0;
            }

            if(var43 > 128) {
               var43 = 128;
            }

            this.field2585[var42] = (byte)var43;
         }

         Object var46 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var37[var27].field2495 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field2503 != null) {
            var28.field2498 = var2.readUnsignedByte();
         }

         if(var28.field2494 != null) {
            var28.field2497 = var2.readUnsignedByte();
         }

         if(var28.field2495 > 0) {
            var28.field2499 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var37[var27].field2500 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field2500 > 0) {
            var28.field2504 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field2504 > 0) {
            var28.field2501 = var2.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1820104332"
   )
   static int method3862(int var0, Script var1, boolean var2) {
      Widget var3 = PacketBuffer.method3403(class83.intStack[--class46.intStackSize]);
      if(var0 == 2500) {
         class83.intStack[++class46.intStackSize - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 2501) {
         class83.intStack[++class46.intStackSize - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 2502) {
         class83.intStack[++class46.intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 2503) {
         class83.intStack[++class46.intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 2504) {
         class83.intStack[++class46.intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 2505) {
         class83.intStack[++class46.intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }
}
