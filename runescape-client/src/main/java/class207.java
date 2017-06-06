import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
public class class207 extends Node {
   @ObfuscatedName("c")
   class107[] field2582;
   @ObfuscatedName("e")
   short[] field2583;
   @ObfuscatedName("v")
   byte[] field2584;
   @ObfuscatedName("y")
   class202[] field2585;
   @ObfuscatedName("b")
   byte[] field2586;
   @ObfuscatedName("x")
   int[] field2588;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1357610273
   )
   int field2590;
   @ObfuscatedName("h")
   byte[] field2591;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = -3254359
   )
   static int field2593;

   class207(byte[] var1) {
      this.field2582 = new class107[128];
      this.field2583 = new short[128];
      this.field2584 = new byte[128];
      this.field2586 = new byte[128];
      this.field2585 = new class202[128];
      this.field2591 = new byte[128];
      this.field2588 = new int[128];
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

      class202[] var40 = new class202[var12];

      class202 var41;
      for(var14 = 0; var14 < var40.length; ++var14) {
         var41 = var40[var14] = new class202();
         int var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var41.field2500 = new byte[var16 * 2];
         }

         var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var41.field2505 = new byte[var16 * 2 + 2];
            var41.field2505[1] = 64;
         }
      }

      var14 = var2.readUnsignedByte();
      byte[] var48 = var14 > 0?new byte[var14 * 2]:null;
      var14 = var2.readUnsignedByte();
      byte[] var42 = var14 > 0?new byte[var14 * 2]:null;

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
         this.field2583[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.readUnsignedByte();
         this.field2583[var20] = (short)(this.field2583[var20] + (var19 << 8));
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

         this.field2583[var23] = (short)(this.field2583[var23] + ((var22 - 1 & 2) << 14));
         this.field2588[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2588[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.payload[var5++] - 1;
            }

            this.field2591[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if(this.field2588[var25] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.payload[var8++] + 16 << 2;
            }

            this.field2586[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class202 var43 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2588[var26] != 0) {
            if(var20 == 0) {
               var43 = var40[var38[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2585[var26] = var43;
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

            if(this.field2588[var27] > 0) {
               var26 = var2.readUnsignedByte() + 1;
            }
         }

         this.field2584[var27] = (byte)var26;
         --var20;
      }

      this.field2590 = var2.readUnsignedByte() + 1;

      int var29;
      class202 var39;
      for(var27 = 0; var27 < var12; ++var27) {
         var39 = var40[var27];
         if(var39.field2500 != null) {
            for(var29 = 1; var29 < var39.field2500.length; var29 += 2) {
               var39.field2500[var29] = var2.readByte();
            }
         }

         if(var39.field2505 != null) {
            for(var29 = 3; var29 < var39.field2505.length - 2; var29 += 2) {
               var39.field2505[var29] = var2.readByte();
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
         var39 = var40[var27];
         if(var39.field2505 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var39.field2505.length; var29 += 2) {
               var19 = var19 + 1 + var2.readUnsignedByte();
               var39.field2505[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var39 = var40[var27];
         if(var39.field2500 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var39.field2500.length; var29 += 2) {
               var19 = var19 + 1 + var2.readUnsignedByte();
               var39.field2500[var29] = (byte)var19;
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
            var19 = var19 + 1 + var2.readUnsignedByte();
            var48[var27] = (byte)var19;
         }

         var47 = var48[0];
         byte var28 = var48[1];

         for(var29 = 0; var29 < var47; ++var29) {
            this.field2584[var29] = (byte)(this.field2584[var29] * var28 + 32 >> 6);
         }

         for(var29 = 2; var29 < var48.length; var29 += 2) {
            var30 = var48[var29];
            byte var31 = var48[var29 + 1];
            var32 = (var30 - var47) / 2 + (var30 - var47) * var28;

            for(var33 = var47; var33 < var30; ++var33) {
               var35 = var30 - var47;
               var36 = var32 >>> 31;
               var34 = (var32 + var36) / var35 - var36;
               this.field2584[var33] = (byte)(this.field2584[var33] * var34 + 32 >> 6);
               var32 += var31 - var28;
            }

            var47 = var30;
            var28 = var31;
         }

         for(var45 = var47; var45 < 128; ++var45) {
            this.field2584[var45] = (byte)(this.field2584[var45] * var28 + 32 >> 6);
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

         var47 = var42[0];
         int var44 = var42[1] << 1;

         for(var29 = 0; var29 < var47; ++var29) {
            var45 = (this.field2586[var29] & 255) + var44;
            if(var45 < 0) {
               var45 = 0;
            }

            if(var45 > 128) {
               var45 = 128;
            }

            this.field2586[var29] = (byte)var45;
         }

         int var46;
         for(var29 = 2; var29 < var42.length; var29 += 2) {
            var30 = var42[var29];
            var46 = var42[var29 + 1] << 1;
            var32 = (var30 - var47) / 2 + (var30 - var47) * var44;

            for(var33 = var47; var33 < var30; ++var33) {
               var35 = var30 - var47;
               var36 = var32 >>> 31;
               var34 = (var32 + var36) / var35 - var36;
               int var37 = var34 + (this.field2586[var33] & 255);
               if(var37 < 0) {
                  var37 = 0;
               }

               if(var37 > 128) {
                  var37 = 128;
               }

               this.field2586[var33] = (byte)var37;
               var32 += var46 - var44;
            }

            var47 = var30;
            var44 = var46;
         }

         for(var45 = var47; var45 < 128; ++var45) {
            var46 = var44 + (this.field2586[var45] & 255);
            if(var46 < 0) {
               var46 = 0;
            }

            if(var46 > 128) {
               var46 = 128;
            }

            this.field2586[var45] = (byte)var46;
         }

         Object var49 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var40[var27].field2502 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var39 = var40[var27];
         if(var39.field2500 != null) {
            var39.field2501 = var2.readUnsignedByte();
         }

         if(var39.field2505 != null) {
            var39.field2504 = var2.readUnsignedByte();
         }

         if(var39.field2502 > 0) {
            var39.field2506 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var40[var27].field2507 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var39 = var40[var27];
         if(var39.field2507 > 0) {
            var39.field2503 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var39 = var40[var27];
         if(var39.field2503 > 0) {
            var39.field2508 = var2.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass112;[B[II)Z",
      garbageValue = "1789991344"
   )
   boolean method3852(class112 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class107 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(var2 == null || var2[var7] != 0) {
            int var8 = this.field2588[var7];
            if(var8 != 0) {
               if(var8 != var5) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method2071(var8 >> 2, var3);
                  } else {
                     var6 = var1.method2074(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(var6 != null) {
                  this.field2582[var7] = var6;
                  this.field2588[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "205084907"
   )
   void method3853() {
      this.field2588 = null;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-1379947452"
   )
   public static boolean method3855(char var0) {
      return var0 >= 48 && var0 <= 57;
   }
}
