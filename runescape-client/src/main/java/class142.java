import net.runelite.mapping.Export;
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
   @Export("clanChatCount")
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
      byte[] var42 = new byte[var9];
      int var12;
      int var13;
      if(var9 > 1) {
         var42[1] = 1;
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

            var42[var13] = (byte)var14;
         }
      } else {
         var12 = var9;
      }

      class137[] var43 = new class137[var12];

      class137 var44;
      for(var13 = 0; var13 < var43.length; ++var13) {
         var44 = var43[var13] = new class137();
         int var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var44.field1887 = new byte[var16 * 2];
         }

         var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var44.field1894 = new byte[var16 * 2 + 2];
            var44.field1894[1] = 64;
         }
      }

      var13 = var2.readUnsignedByte();
      byte[] var45 = var13 > 0?new byte[2 * var13]:null;
      var13 = var2.readUnsignedByte();
      byte[] var17 = var13 > 0?new byte[2 * var13]:null;

      int var18;
      for(var18 = 0; var2.payload[var18 + var2.offset] != 0; ++var18) {
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
         this.field1982[var21] = (short)var20;
      }

      var20 = 0;

      for(var21 = 0; var21 < 128; ++var21) {
         var20 += var2.readUnsignedByte();
         this.field1982[var21] = (short)(this.field1982[var21] + (var20 << 8));
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

            var23 = var2.method2862();
         }

         this.field1982[var24] = (short)(this.field1982[var24] + ((var23 - 1 & 2) << 14));
         this.field1983[var24] = var23;
         --var21;
      }

      var21 = 0;
      var22 = 0;
      var24 = 0;

      int var25;
      for(var25 = 0; var25 < 128; ++var25) {
         if(this.field1983[var25] != 0) {
            if(var21 == 0) {
               if(var22 < var4.length) {
                  var21 = var4[var22++];
               } else {
                  var21 = -1;
               }

               var24 = var2.payload[var5++] - 1;
            }

            this.field1980[var25] = (byte)var24;
            --var21;
         }
      }

      var21 = 0;
      var22 = 0;
      var25 = 0;

      for(int var26 = 0; var26 < 128; ++var26) {
         if(this.field1983[var26] != 0) {
            if(var21 == 0) {
               if(var22 < var7.length) {
                  var21 = var7[var22++];
               } else {
                  var21 = -1;
               }

               var25 = var2.payload[var8++] + 16 << 2;
            }

            this.field1978[var26] = (byte)var25;
            --var21;
         }
      }

      var21 = 0;
      var22 = 0;
      class137 var46 = null;

      int var27;
      for(var27 = 0; var27 < 128; ++var27) {
         if(this.field1983[var27] != 0) {
            if(var21 == 0) {
               var46 = var43[var42[var22]];
               if(var22 < var10.length) {
                  var21 = var10[var22++];
               } else {
                  var21 = -1;
               }
            }

            this.field1981[var27] = var46;
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

            if(this.field1983[var28] > 0) {
               var27 = var2.readUnsignedByte() + 1;
            }
         }

         this.field1979[var28] = (byte)var27;
         --var21;
      }

      this.field1986 = var2.readUnsignedByte() + 1;

      class137 var29;
      int var30;
      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var43[var28];
         if(null != var29.field1887) {
            for(var30 = 1; var30 < var29.field1887.length; var30 += 2) {
               var29.field1887[var30] = var2.readByte();
            }
         }

         if(null != var29.field1894) {
            for(var30 = 3; var30 < var29.field1894.length - 2; var30 += 2) {
               var29.field1894[var30] = var2.readByte();
            }
         }
      }

      if(var45 != null) {
         for(var28 = 1; var28 < var45.length; var28 += 2) {
            var45[var28] = var2.readByte();
         }
      }

      if(var17 != null) {
         for(var28 = 1; var28 < var17.length; var28 += 2) {
            var17[var28] = var2.readByte();
         }
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var43[var28];
         if(null != var29.field1894) {
            var20 = 0;

            for(var30 = 2; var30 < var29.field1894.length; var30 += 2) {
               var20 = var20 + 1 + var2.readUnsignedByte();
               var29.field1894[var30] = (byte)var20;
            }
         }
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var43[var28];
         if(var29.field1887 != null) {
            var20 = 0;

            for(var30 = 2; var30 < var29.field1887.length; var30 += 2) {
               var20 = 1 + var20 + var2.readUnsignedByte();
               var29.field1887[var30] = (byte)var20;
            }
         }
      }

      byte var31;
      int var32;
      int var33;
      int var34;
      int var35;
      byte var36;
      if(var45 != null) {
         var20 = var2.readUnsignedByte();
         var45[0] = (byte)var20;

         for(var28 = 2; var28 < var45.length; var28 += 2) {
            var20 = var20 + 1 + var2.readUnsignedByte();
            var45[var28] = (byte)var20;
         }

         var36 = var45[0];
         byte var37 = var45[1];

         for(var30 = 0; var30 < var36; ++var30) {
            this.field1979[var30] = (byte)(var37 * this.field1979[var30] + 32 >> 6);
         }

         for(var30 = 2; var30 < var45.length; var30 += 2) {
            var31 = var45[var30];
            byte var38 = var45[1 + var30];
            var32 = (var31 - var36) / 2 + var37 * (var31 - var36);

            for(var33 = var36; var33 < var31; ++var33) {
               var34 = CombatInfoListHolder.calculateHeight(var32, var31 - var36);
               this.field1979[var33] = (byte)(32 + var34 * this.field1979[var33] >> 6);
               var32 += var38 - var37;
            }

            var36 = var31;
            var37 = var38;
         }

         for(var35 = var36; var35 < 128; ++var35) {
            this.field1979[var35] = (byte)(32 + var37 * this.field1979[var35] >> 6);
         }

         var44 = null;
      }

      if(var17 != null) {
         var20 = var2.readUnsignedByte();
         var17[0] = (byte)var20;

         for(var28 = 2; var28 < var17.length; var28 += 2) {
            var20 = 1 + var20 + var2.readUnsignedByte();
            var17[var28] = (byte)var20;
         }

         var36 = var17[0];
         int var47 = var17[1] << 1;

         for(var30 = 0; var30 < var36; ++var30) {
            var35 = var47 + (this.field1978[var30] & 255);
            if(var35 < 0) {
               var35 = 0;
            }

            if(var35 > 128) {
               var35 = 128;
            }

            this.field1978[var30] = (byte)var35;
         }

         int var48;
         for(var30 = 2; var30 < var17.length; var30 += 2) {
            var31 = var17[var30];
            var48 = var17[1 + var30] << 1;
            var32 = (var31 - var36) * var47 + (var31 - var36) / 2;

            for(var33 = var36; var33 < var31; ++var33) {
               int var39 = var31 - var36;
               int var40 = var32 >>> 31;
               var34 = (var32 + var40) / var39 - var40;
               int var41 = (this.field1978[var33] & 255) + var34;
               if(var41 < 0) {
                  var41 = 0;
               }

               if(var41 > 128) {
                  var41 = 128;
               }

               this.field1978[var33] = (byte)var41;
               var32 += var48 - var47;
            }

            var36 = var31;
            var47 = var48;
         }

         for(var35 = var36; var35 < 128; ++var35) {
            var48 = var47 + (this.field1978[var35] & 255);
            if(var48 < 0) {
               var48 = 0;
            }

            if(var48 > 128) {
               var48 = 128;
            }

            this.field1978[var35] = (byte)var48;
         }

         Object var49 = null;
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var43[var28].field1889 = var2.readUnsignedByte();
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var43[var28];
         if(var29.field1887 != null) {
            var29.field1890 = var2.readUnsignedByte();
         }

         if(null != var29.field1894) {
            var29.field1891 = var2.readUnsignedByte();
         }

         if(var29.field1889 > 0) {
            var29.field1892 = var2.readUnsignedByte();
         }
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var43[var28].field1893 = var2.readUnsignedByte();
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var43[var28];
         if(var29.field1893 > 0) {
            var29.field1896 = var2.readUnsignedByte();
         }
      }

      for(var28 = 0; var28 < var12; ++var28) {
         var29 = var43[var28];
         if(var29.field1896 > 0) {
            var29.field1895 = var2.readUnsignedByte();
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
