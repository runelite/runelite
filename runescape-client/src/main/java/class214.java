import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
public class class214 extends Node {
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = -623009039
   )
   @Export("cameraX")
   static int cameraX;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = 112081465
   )
   static int field2675;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1783901487
   )
   int field2668;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[Lda;"
   )
   class106[] field2666;
   @ObfuscatedName("k")
   short[] field2667;
   @ObfuscatedName("z")
   byte[] field2669;
   @ObfuscatedName("v")
   byte[] field2665;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "[Lhc;"
   )
   class209[] field2670;
   @ObfuscatedName("b")
   byte[] field2671;
   @ObfuscatedName("t")
   int[] field2672;

   class214(byte[] var1) {
      this.field2666 = new class106[128];
      this.field2667 = new short[128];
      this.field2669 = new byte[128];
      this.field2665 = new byte[128];
      this.field2670 = new class209[128];
      this.field2671 = new byte[128];
      this.field2672 = new int[128];
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

      class209[] var39 = new class209[var12];

      class209 var40;
      for(var14 = 0; var14 < var39.length; ++var14) {
         var40 = var39[var14] = new class209();
         int var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var40.field2588 = new byte[var16 * 2];
         }

         var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var40.field2585 = new byte[var16 * 2 + 2];
            var40.field2585[1] = 64;
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
         this.field2667[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.readUnsignedByte();
         this.field2667[var20] = (short)(this.field2667[var20] + (var19 << 8));
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

         this.field2667[var23] = (short)(this.field2667[var23] + ((var22 - 1 & 2) << 14));
         this.field2672[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2672[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.payload[var5++] - 1;
            }

            this.field2671[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if(this.field2672[var25] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.payload[var8++] + 16 << 2;
            }

            this.field2665[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class209 var42 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2672[var26] != 0) {
            if(var20 == 0) {
               var42 = var39[var38[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2670[var26] = var42;
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

            if(this.field2672[var27] > 0) {
               var26 = var2.readUnsignedByte() + 1;
            }
         }

         this.field2669[var27] = (byte)var26;
         --var20;
      }

      this.field2668 = var2.readUnsignedByte() + 1;

      class209 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field2588 != null) {
            for(var29 = 1; var29 < var28.field2588.length; var29 += 2) {
               var28.field2588[var29] = var2.readByte();
            }
         }

         if(var28.field2585 != null) {
            for(var29 = 3; var29 < var28.field2585.length - 2; var29 += 2) {
               var28.field2585[var29] = var2.readByte();
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
         if(var28.field2585 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field2585.length; var29 += 2) {
               var19 = 1 + var19 + var2.readUnsignedByte();
               var28.field2585[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field2588 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field2588.length; var29 += 2) {
               var19 = 1 + var19 + var2.readUnsignedByte();
               var28.field2588[var29] = (byte)var19;
            }
         }
      }

      byte var30;
      int var32;
      int var33;
      int var34;
      int var44;
      byte var46;
      if(var47 != null) {
         var19 = var2.readUnsignedByte();
         var47[0] = (byte)var19;

         for(var27 = 2; var27 < var47.length; var27 += 2) {
            var19 = var19 + 1 + var2.readUnsignedByte();
            var47[var27] = (byte)var19;
         }

         var46 = var47[0];
         byte var43 = var47[1];

         for(var29 = 0; var29 < var46; ++var29) {
            this.field2669[var29] = (byte)(var43 * this.field2669[var29] + 32 >> 6);
         }

         for(var29 = 2; var29 < var47.length; var29 += 2) {
            var30 = var47[var29];
            byte var31 = var47[var29 + 1];
            var32 = var43 * (var30 - var46) + (var30 - var46) / 2;

            for(var33 = var46; var33 < var30; ++var33) {
               var34 = Ignore.method1125(var32, var30 - var46);
               this.field2669[var33] = (byte)(var34 * this.field2669[var33] + 32 >> 6);
               var32 += var31 - var43;
            }

            var46 = var30;
            var43 = var31;
         }

         for(var44 = var46; var44 < 128; ++var44) {
            this.field2669[var44] = (byte)(var43 * this.field2669[var44] + 32 >> 6);
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
            var44 = var49 + (this.field2665[var29] & 255);
            if(var44 < 0) {
               var44 = 0;
            }

            if(var44 > 128) {
               var44 = 128;
            }

            this.field2665[var29] = (byte)var44;
         }

         int var45;
         for(var29 = 2; var29 < var41.length; var29 += 2) {
            var30 = var41[var29];
            var45 = var41[var29 + 1] << 1;
            var32 = var49 * (var30 - var46) + (var30 - var46) / 2;

            for(var33 = var46; var33 < var30; ++var33) {
               int var35 = var30 - var46;
               int var36 = var32 >>> 31;
               var34 = (var32 + var36) / var35 - var36;
               int var37 = var34 + (this.field2665[var33] & 255);
               if(var37 < 0) {
                  var37 = 0;
               }

               if(var37 > 128) {
                  var37 = 128;
               }

               this.field2665[var33] = (byte)var37;
               var32 += var45 - var49;
            }

            var46 = var30;
            var49 = var45;
         }

         for(var44 = var46; var44 < 128; ++var44) {
            var45 = var49 + (this.field2665[var44] & 255);
            if(var45 < 0) {
               var45 = 0;
            }

            if(var45 > 128) {
               var45 = 128;
            }

            this.field2665[var44] = (byte)var45;
         }

         Object var48 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var39[var27].field2593 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field2588 != null) {
            var28.field2592 = var2.readUnsignedByte();
         }

         if(var28.field2585 != null) {
            var28.field2587 = var2.readUnsignedByte();
         }

         if(var28.field2593 > 0) {
            var28.field2589 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var39[var27].field2591 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field2591 > 0) {
            var28.field2590 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field2590 > 0) {
            var28.field2586 = var2.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lds;[B[II)Z",
      garbageValue = "350804866"
   )
   boolean method4043(class111 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class106 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(var2 == null || var2[var7] != 0) {
            int var8 = this.field2672[var7];
            if(var8 != 0) {
               if(var5 != var8) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method2182(var8 >> 2, var3);
                  } else {
                     var6 = var1.method2185(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(var6 != null) {
                  this.field2666[var7] = var6;
                  this.field2672[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1920271632"
   )
   void method4048() {
      this.field2672 = null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Leh;IIIS)Z",
      garbageValue = "255"
   )
   @Export("boundingBox3DContainsMouse")
   public static final boolean boundingBox3DContainsMouse(Model var0, int var1, int var2, int var3) {
      if(!class87.method1763()) {
         return false;
      } else {
         ClientPacket.method3193();
         int var4 = var0.field1831 + var1;
         int var5 = var2 + var0.field1838;
         int var6 = var3 + var0.field1893;
         int var7 = var0.field1864;
         int var8 = var0.field1865;
         int var9 = var0.field1866;
         int var10 = class133.field1899 - var4;
         int var11 = IndexStoreActionHandler.field3310 - var5;
         int var12 = class133.field1904 - var6;
         return Math.abs(var10) > var7 + WidgetNode.field789?false:(Math.abs(var11) > var8 + ItemContainer.field759?false:(Math.abs(var12) > var9 + class133.field1907?false:(Math.abs(var12 * class133.field1906 - var11 * BoundingBox.field239) > var9 * ItemContainer.field759 + var8 * class133.field1907?false:(Math.abs(var10 * BoundingBox.field239 - var12 * class133.field1905) > var7 * class133.field1907 + var9 * WidgetNode.field789?false:Math.abs(var11 * class133.field1905 - var10 * class133.field1906) <= var8 * WidgetNode.field789 + var7 * ItemContainer.field759))));
      }
   }
}
