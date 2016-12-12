import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
public class class142 extends Node {
   @ObfuscatedName("q")
   int[] field1990 = new int[128];
   @ObfuscatedName("f")
   short[] field1991 = new short[128];
   @ObfuscatedName("ei")
   static SpritePixels[] field1992;
   @ObfuscatedName("k")
   byte[] field1993 = new byte[128];
   @ObfuscatedName("g")
   byte[] field1994 = new byte[128];
   @ObfuscatedName("a")
   byte[] field1995 = new byte[128];
   @ObfuscatedName("v")
   static ModIcon field1996;
   @ObfuscatedName("e")
   class55[] field1997 = new class55[128];
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 933099567
   )
   int field1998;
   @ObfuscatedName("n")
   class137[] field1999 = new class137[128];
   @ObfuscatedName("d")
   public static Buffer field2000;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "561633504"
   )
   void method2640() {
      this.field1990 = null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass60;[B[II)Z",
      garbageValue = "-2145547737"
   )
   boolean method2641(class60 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class55 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(var2 == null || var2[var7] != 0) {
            int var8 = this.field1990[var7];
            if(var8 != 0) {
               if(var5 != var8) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method1107(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1108(var8 >> 2, var3);
                  }

                  if(null == var6) {
                     var4 = false;
                  }
               }

               if(null != var6) {
                  this.field1997[var7] = var6;
                  this.field1990[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "(LWidget;B)Ljava/lang/String;",
      garbageValue = "123"
   )
   static String method2644(Widget var0) {
      return RSCanvas.method2049(class143.method2647(var0)) == 0?null:(null != var0.field2287 && var0.field2287.trim().length() != 0?var0.field2287:null);
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
      byte[] var39 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var39[1] = 1;
         int var13 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var40 = var2.readUnsignedByte();
            if(var40 == 0) {
               var13 = var12++;
            } else {
               if(var40 <= var13) {
                  --var40;
               }

               var13 = var40;
            }

            var39[var14] = (byte)var13;
         }
      } else {
         var12 = var9;
      }

      class137[] var41 = new class137[var12];

      class137 var15;
      for(var14 = 0; var14 < var41.length; ++var14) {
         var15 = var41[var14] = new class137();
         int var38 = var2.readUnsignedByte();
         if(var38 > 0) {
            var15.field1901 = new byte[var38 * 2];
         }

         var38 = var2.readUnsignedByte();
         if(var38 > 0) {
            var15.field1898 = new byte[var38 * 2 + 2];
            var15.field1898[1] = 64;
         }
      }

      var14 = var2.readUnsignedByte();
      byte[] var44 = var14 > 0?new byte[2 * var14]:null;
      var14 = var2.readUnsignedByte();
      byte[] var16 = var14 > 0?new byte[2 * var14]:null;

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
         this.field1991[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.readUnsignedByte();
         this.field1991[var20] = (short)(this.field1991[var20] + (var19 << 8));
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

            var22 = var2.method2869();
         }

         this.field1991[var23] = (short)(this.field1991[var23] + ((var22 - 1 & 2) << 14));
         this.field1990[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field1990[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.payload[var5++] - 1;
            }

            this.field1995[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if(this.field1990[var25] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.payload[var8++] + 16 << 2;
            }

            this.field1994[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class137 var43 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field1990[var26] != 0) {
            if(var20 == 0) {
               var43 = var41[var39[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field1999[var26] = var43;
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

            if(this.field1990[var27] > 0) {
               var26 = var2.readUnsignedByte() + 1;
            }
         }

         this.field1993[var27] = (byte)var26;
         --var20;
      }

      this.field1998 = var2.readUnsignedByte() + 1;

      class137 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var41[var27];
         if(var28.field1901 != null) {
            for(var29 = 1; var29 < var28.field1901.length; var29 += 2) {
               var28.field1901[var29] = var2.readByte();
            }
         }

         if(var28.field1898 != null) {
            for(var29 = 3; var29 < var28.field1898.length - 2; var29 += 2) {
               var28.field1898[var29] = var2.readByte();
            }
         }
      }

      if(null != var44) {
         for(var27 = 1; var27 < var44.length; var27 += 2) {
            var44[var27] = var2.readByte();
         }
      }

      if(var16 != null) {
         for(var27 = 1; var27 < var16.length; var27 += 2) {
            var16[var27] = var2.readByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var41[var27];
         if(null != var28.field1898) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field1898.length; var29 += 2) {
               var19 = var19 + 1 + var2.readUnsignedByte();
               var28.field1898[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var41[var27];
         if(var28.field1901 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field1901.length; var29 += 2) {
               var19 = 1 + var19 + var2.readUnsignedByte();
               var28.field1901[var29] = (byte)var19;
            }
         }
      }

      byte var30;
      int var32;
      int var33;
      int var34;
      int var35;
      int var36;
      int var46;
      byte var48;
      if(var44 != null) {
         var19 = var2.readUnsignedByte();
         var44[0] = (byte)var19;

         for(var27 = 2; var27 < var44.length; var27 += 2) {
            var19 = 1 + var19 + var2.readUnsignedByte();
            var44[var27] = (byte)var19;
         }

         var48 = var44[0];
         byte var42 = var44[1];

         for(var29 = 0; var29 < var48; ++var29) {
            this.field1993[var29] = (byte)(32 + this.field1993[var29] * var42 >> 6);
         }

         for(var29 = 2; var29 < var44.length; var29 += 2) {
            var30 = var44[var29];
            byte var31 = var44[var29 + 1];
            var32 = (var30 - var48) / 2 + var42 * (var30 - var48);

            for(var33 = var48; var33 < var30; ++var33) {
               var35 = var30 - var48;
               var36 = var32 >>> 31;
               var34 = (var36 + var32) / var35 - var36;
               this.field1993[var33] = (byte)(var34 * this.field1993[var33] + 32 >> 6);
               var32 += var31 - var42;
            }

            var48 = var30;
            var42 = var31;
         }

         for(var46 = var48; var46 < 128; ++var46) {
            this.field1993[var46] = (byte)(this.field1993[var46] * var42 + 32 >> 6);
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

         var48 = var16[0];
         int var49 = var16[1] << 1;

         for(var29 = 0; var29 < var48; ++var29) {
            var46 = (this.field1994[var29] & 255) + var49;
            if(var46 < 0) {
               var46 = 0;
            }

            if(var46 > 128) {
               var46 = 128;
            }

            this.field1994[var29] = (byte)var46;
         }

         int var47;
         for(var29 = 2; var29 < var16.length; var29 += 2) {
            var30 = var16[var29];
            var47 = var16[var29 + 1] << 1;
            var32 = var49 * (var30 - var48) + (var30 - var48) / 2;

            for(var33 = var48; var33 < var30; ++var33) {
               var35 = var30 - var48;
               var36 = var32 >>> 31;
               var34 = (var32 + var36) / var35 - var36;
               int var37 = (this.field1994[var33] & 255) + var34;
               if(var37 < 0) {
                  var37 = 0;
               }

               if(var37 > 128) {
                  var37 = 128;
               }

               this.field1994[var33] = (byte)var37;
               var32 += var47 - var49;
            }

            var48 = var30;
            var49 = var47;
         }

         for(var46 = var48; var46 < 128; ++var46) {
            var47 = (this.field1994[var46] & 255) + var49;
            if(var47 < 0) {
               var47 = 0;
            }

            if(var47 > 128) {
               var47 = 128;
            }

            this.field1994[var46] = (byte)var47;
         }

         Object var45 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var41[var27].field1899 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var41[var27];
         if(var28.field1901 != null) {
            var28.field1900 = var2.readUnsignedByte();
         }

         if(null != var28.field1898) {
            var28.field1907 = var2.readUnsignedByte();
         }

         if(var28.field1899 > 0) {
            var28.field1902 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var41[var27].field1909 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var41[var27];
         if(var28.field1909 > 0) {
            var28.field1903 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var41[var27];
         if(var28.field1903 > 0) {
            var28.field1905 = var2.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([LWorld;II[I[II)V",
      garbageValue = "1324133404"
   )
   static void method2646(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = 1 + var2;
         int var7 = (var2 + var1) / 2;
         World var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method591()?1:0;
                     var12 = var8.method591()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if(var12 != var11) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method591()?1:0;
                     var12 = var8.method591()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               World var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method2646(var0, var1, var6, var3, var4);
         method2646(var0, var6 + 1, var2, var3, var4);
      }

   }
}
