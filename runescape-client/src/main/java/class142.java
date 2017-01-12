import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
public class class142 extends Node {
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -1942170331
   )
   static int field1976;
   @ObfuscatedName("x")
   class55[] field1977 = new class55[128];
   @ObfuscatedName("f")
   byte[] field1978 = new byte[128];
   @ObfuscatedName("a")
   byte[] field1979 = new byte[128];
   @ObfuscatedName("d")
   byte[] field1980 = new byte[128];
   @ObfuscatedName("c")
   class137[] field1981 = new class137[128];
   @ObfuscatedName("i")
   short[] field1982 = new short[128];
   @ObfuscatedName("l")
   int[] field1983 = new int[128];
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      intValue = -517514723
   )
   static int field1984;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1181999297
   )
   int field1986;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "519667315"
   )
   void method2662() {
      this.field1983 = null;
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
         int var42 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var15 = var2.readUnsignedByte();
            if(var15 == 0) {
               var42 = var12++;
            } else {
               if(var15 <= var42) {
                  --var15;
               }

               var42 = var15;
            }

            var39[var14] = (byte)var42;
         }
      } else {
         var12 = var9;
      }

      class137[] var13 = new class137[var12];

      class137 var41;
      for(var14 = 0; var14 < var13.length; ++var14) {
         var41 = var13[var14] = new class137();
         int var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var41.field1887 = new byte[var16 * 2];
         }

         var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var41.field1894 = new byte[var16 * 2 + 2];
            var41.field1894[1] = 64;
         }
      }

      var14 = var2.readUnsignedByte();
      byte[] var48 = var14 > 0?new byte[2 * var14]:null;
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
         this.field1982[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.readUnsignedByte();
         this.field1982[var20] = (short)(this.field1982[var20] + (var19 << 8));
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

            var22 = var2.method2862();
         }

         this.field1982[var23] = (short)(this.field1982[var23] + ((var22 - 1 & 2) << 14));
         this.field1983[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field1983[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.payload[var5++] - 1;
            }

            this.field1980[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if(this.field1983[var25] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.payload[var8++] + 16 << 2;
            }

            this.field1978[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class137 var40 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field1983[var26] != 0) {
            if(var20 == 0) {
               var40 = var13[var39[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field1981[var26] = var40;
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

            if(this.field1983[var27] > 0) {
               var26 = var2.readUnsignedByte() + 1;
            }
         }

         this.field1979[var27] = (byte)var26;
         --var20;
      }

      this.field1986 = var2.readUnsignedByte() + 1;

      class137 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(null != var28.field1887) {
            for(var29 = 1; var29 < var28.field1887.length; var29 += 2) {
               var28.field1887[var29] = var2.readByte();
            }
         }

         if(null != var28.field1894) {
            for(var29 = 3; var29 < var28.field1894.length - 2; var29 += 2) {
               var28.field1894[var29] = var2.readByte();
            }
         }
      }

      if(var48 != null) {
         for(var27 = 1; var27 < var48.length; var27 += 2) {
            var48[var27] = var2.readByte();
         }
      }

      if(var38 != null) {
         for(var27 = 1; var27 < var38.length; var27 += 2) {
            var38[var27] = var2.readByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(null != var28.field1894) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field1894.length; var29 += 2) {
               var19 = var19 + 1 + var2.readUnsignedByte();
               var28.field1894[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1887 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field1887.length; var29 += 2) {
               var19 = 1 + var19 + var2.readUnsignedByte();
               var28.field1887[var29] = (byte)var19;
            }
         }
      }

      byte var30;
      int var32;
      int var33;
      int var34;
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
         byte var43 = var48[1];

         for(var29 = 0; var29 < var46; ++var29) {
            this.field1979[var29] = (byte)(var43 * this.field1979[var29] + 32 >> 6);
         }

         for(var29 = 2; var29 < var48.length; var29 += 2) {
            var30 = var48[var29];
            byte var31 = var48[1 + var29];
            var32 = (var30 - var46) / 2 + var43 * (var30 - var46);

            for(var33 = var46; var33 < var30; ++var33) {
               var34 = CombatInfoListHolder.calculateHeight(var32, var30 - var46);
               this.field1979[var33] = (byte)(32 + var34 * this.field1979[var33] >> 6);
               var32 += var31 - var43;
            }

            var46 = var30;
            var43 = var31;
         }

         for(var44 = var46; var44 < 128; ++var44) {
            this.field1979[var44] = (byte)(32 + var43 * this.field1979[var44] >> 6);
         }

         var41 = null;
      }

      if(var38 != null) {
         var19 = var2.readUnsignedByte();
         var38[0] = (byte)var19;

         for(var27 = 2; var27 < var38.length; var27 += 2) {
            var19 = 1 + var19 + var2.readUnsignedByte();
            var38[var27] = (byte)var19;
         }

         var46 = var38[0];
         int var49 = var38[1] << 1;

         for(var29 = 0; var29 < var46; ++var29) {
            var44 = var49 + (this.field1978[var29] & 255);
            if(var44 < 0) {
               var44 = 0;
            }

            if(var44 > 128) {
               var44 = 128;
            }

            this.field1978[var29] = (byte)var44;
         }

         int var45;
         for(var29 = 2; var29 < var38.length; var29 += 2) {
            var30 = var38[var29];
            var45 = var38[1 + var29] << 1;
            var32 = (var30 - var46) * var49 + (var30 - var46) / 2;

            for(var33 = var46; var33 < var30; ++var33) {
               int var35 = var30 - var46;
               int var36 = var32 >>> 31;
               var34 = (var32 + var36) / var35 - var36;
               int var37 = (this.field1978[var33] & 255) + var34;
               if(var37 < 0) {
                  var37 = 0;
               }

               if(var37 > 128) {
                  var37 = 128;
               }

               this.field1978[var33] = (byte)var37;
               var32 += var45 - var49;
            }

            var46 = var30;
            var49 = var45;
         }

         for(var44 = var46; var44 < 128; ++var44) {
            var45 = var49 + (this.field1978[var44] & 255);
            if(var45 < 0) {
               var45 = 0;
            }

            if(var45 > 128) {
               var45 = 128;
            }

            this.field1978[var44] = (byte)var45;
         }

         Object var47 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field1889 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1887 != null) {
            var28.field1890 = var2.readUnsignedByte();
         }

         if(null != var28.field1894) {
            var28.field1891 = var2.readUnsignedByte();
         }

         if(var28.field1889 > 0) {
            var28.field1892 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field1893 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1893 > 0) {
            var28.field1896 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1896 > 0) {
            var28.field1895 = var2.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Lclass182;I)V",
      garbageValue = "1987783050"
   )
   public static void method2664(class182 var0, class182 var1, class182 var2) {
      Sequence.field3042 = var0;
      Sequence.field3043 = var1;
      Sequence.field3054 = var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass60;[B[II)Z",
      garbageValue = "1475321604"
   )
   boolean method2668(class60 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class55 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(var2 == null || var2[var7] != 0) {
            int var8 = this.field1983[var7];
            if(var8 != 0) {
               if(var5 != var8) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method1084(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1085(var8 >> 2, var3);
                  }

                  if(null == var6) {
                     var4 = false;
                  }
               }

               if(null != var6) {
                  this.field1977[var7] = var6;
                  this.field1983[var7] = 0;
               }
            }
         }
      }

      return var4;
   }
}
