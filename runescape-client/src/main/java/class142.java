import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
public class class142 extends Node {
   @ObfuscatedName("l")
   class55[] field1985 = new class55[128];
   @ObfuscatedName("t")
   byte[] field1987 = new byte[128];
   @ObfuscatedName("k")
   byte[] field1988 = new byte[128];
   @ObfuscatedName("h")
   class137[] field1989 = new class137[128];
   @ObfuscatedName("n")
   byte[] field1990 = new byte[128];
   @ObfuscatedName("i")
   short[] field1991 = new short[128];
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 513007581
   )
   int field1992;
   @ObfuscatedName("f")
   int[] field1994 = new int[128];
   @ObfuscatedName("x")
   static int[] field1996;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass60;[B[II)Z",
      garbageValue = "1011737040"
   )
   boolean method2733(class60 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class55 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(var2 == null || var2[var7] != 0) {
            int var8 = this.field1994[var7];
            if(var8 != 0) {
               if(var5 != var8) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method1198(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1201(var8 >> 2, var3);
                  }

                  if(null == var6) {
                     var4 = false;
                  }
               }

               if(null != var6) {
                  this.field1985[var7] = var6;
                  this.field1994[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-876324401"
   )
   void method2734() {
      this.field1994 = null;
   }

   class142(byte[] var1) {
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
      byte[] var38 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var38[1] = 1;
         int var39 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var40 = var2.readUnsignedByte();
            if(var40 == 0) {
               var39 = var12++;
            } else {
               if(var40 <= var39) {
                  --var40;
               }

               var39 = var40;
            }

            var38[var14] = (byte)var39;
         }
      } else {
         var12 = var9;
      }

      class137[] var13 = new class137[var12];

      class137 var15;
      for(var14 = 0; var14 < var13.length; ++var14) {
         var15 = var13[var14] = new class137();
         int var41 = var2.readUnsignedByte();
         if(var41 > 0) {
            var15.field1902 = new byte[2 * var41];
         }

         var41 = var2.readUnsignedByte();
         if(var41 > 0) {
            var15.field1898 = new byte[var41 * 2 + 2];
            var15.field1898[1] = 64;
         }
      }

      var14 = var2.readUnsignedByte();
      byte[] var44 = var14 > 0?new byte[2 * var14]:null;
      var14 = var2.readUnsignedByte();
      byte[] var16 = var14 > 0?new byte[2 * var14]:null;

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

            var22 = var2.method2872();
         }

         this.field1991[var23] = (short)(this.field1991[var23] + ((var22 - 1 & 2) << 14));
         this.field1994[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field1994[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.payload[var5++] - 1;
            }

            this.field1990[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if(this.field1994[var25] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.payload[var8++] + 16 << 2;
            }

            this.field1988[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class137 var43 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field1994[var26] != 0) {
            if(var20 == 0) {
               var43 = var13[var38[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field1989[var26] = var43;
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

            if(this.field1994[var27] > 0) {
               var26 = var2.readUnsignedByte() + 1;
            }
         }

         this.field1987[var27] = (byte)var26;
         --var20;
      }

      this.field1992 = var2.readUnsignedByte() + 1;

      class137 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1902 != null) {
            for(var29 = 1; var29 < var28.field1902.length; var29 += 2) {
               var28.field1902[var29] = var2.readByte();
            }
         }

         if(var28.field1898 != null) {
            for(var29 = 3; var29 < var28.field1898.length - 2; var29 += 2) {
               var28.field1898[var29] = var2.readByte();
            }
         }
      }

      if(var44 != null) {
         for(var27 = 1; var27 < var44.length; var27 += 2) {
            var44[var27] = var2.readByte();
         }
      }

      if(null != var16) {
         for(var27 = 1; var27 < var16.length; var27 += 2) {
            var16[var27] = var2.readByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1898 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field1898.length; var29 += 2) {
               var19 = var19 + 1 + var2.readUnsignedByte();
               var28.field1898[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1902 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field1902.length; var29 += 2) {
               var19 = 1 + var19 + var2.readUnsignedByte();
               var28.field1902[var29] = (byte)var19;
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
      if(null != var44) {
         var19 = var2.readUnsignedByte();
         var44[0] = (byte)var19;

         for(var27 = 2; var27 < var44.length; var27 += 2) {
            var19 = 1 + var19 + var2.readUnsignedByte();
            var44[var27] = (byte)var19;
         }

         var48 = var44[0];
         byte var42 = var44[1];

         for(var29 = 0; var29 < var48; ++var29) {
            this.field1987[var29] = (byte)(this.field1987[var29] * var42 + 32 >> 6);
         }

         for(var29 = 2; var29 < var44.length; var29 += 2) {
            var30 = var44[var29];
            byte var31 = var44[1 + var29];
            var32 = (var30 - var48) * var42 + (var30 - var48) / 2;

            for(var33 = var48; var33 < var30; ++var33) {
               var35 = var30 - var48;
               var36 = var32 >>> 31;
               var34 = (var32 + var36) / var35 - var36;
               this.field1987[var33] = (byte)(32 + this.field1987[var33] * var34 >> 6);
               var32 += var31 - var42;
            }

            var48 = var30;
            var42 = var31;
         }

         for(var46 = var48; var46 < 128; ++var46) {
            this.field1987[var46] = (byte)(var42 * this.field1987[var46] + 32 >> 6);
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
            var46 = (this.field1988[var29] & 255) + var49;
            if(var46 < 0) {
               var46 = 0;
            }

            if(var46 > 128) {
               var46 = 128;
            }

            this.field1988[var29] = (byte)var46;
         }

         int var47;
         for(var29 = 2; var29 < var16.length; var29 += 2) {
            var30 = var16[var29];
            var47 = var16[1 + var29] << 1;
            var32 = (var30 - var48) / 2 + var49 * (var30 - var48);

            for(var33 = var48; var33 < var30; ++var33) {
               var35 = var30 - var48;
               var36 = var32 >>> 31;
               var34 = (var32 + var36) / var35 - var36;
               int var37 = var34 + (this.field1988[var33] & 255);
               if(var37 < 0) {
                  var37 = 0;
               }

               if(var37 > 128) {
                  var37 = 128;
               }

               this.field1988[var33] = (byte)var37;
               var32 += var47 - var49;
            }

            var48 = var30;
            var49 = var47;
         }

         for(var46 = var48; var46 < 128; ++var46) {
            var47 = var49 + (this.field1988[var46] & 255);
            if(var47 < 0) {
               var47 = 0;
            }

            if(var47 > 128) {
               var47 = 128;
            }

            this.field1988[var46] = (byte)var47;
         }

         Object var45 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field1899 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1902 != null) {
            var28.field1900 = var2.readUnsignedByte();
         }

         if(null != var28.field1898) {
            var28.field1901 = var2.readUnsignedByte();
         }

         if(var28.field1899 > 0) {
            var28.field1911 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field1904 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1904 > 0) {
            var28.field1907 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1907 > 0) {
            var28.field1905 = var2.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-730240455"
   )
   static final void method2742(int var0, int var1) {
      if(Client.menuOptionCount >= 2 || Client.field438 != 0 || Client.field549) {
         int var2 = class7.method110();
         String var3;
         if(Client.field438 == 1 && Client.menuOptionCount < 2) {
            var3 = "Use" + " " + Client.field439 + " " + "->";
         } else if(Client.field549 && Client.menuOptionCount < 2) {
            var3 = Client.field328 + " " + Client.field350 + " " + "->";
         } else {
            var3 = class57.method1161(var2);
         }

         if(Client.menuOptionCount > 2) {
            var3 = var3 + class187.method3515(16777215) + " " + '/' + " " + (Client.menuOptionCount - 2) + " more options";
         }

         class16.field170.method3981(var3, 4 + var0, 15 + var1, 16777215, 0, Client.gameCycle / 1000);
      }
   }
}
