import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
public class class142 extends Node {
   @ObfuscatedName("v")
   class137[] field2006 = new class137[128];
   @ObfuscatedName("m")
   class55[] field2007 = new class55[128];
   @ObfuscatedName("g")
   byte[] field2008 = new byte[128];
   @ObfuscatedName("c")
   int[] field2009 = new int[128];
   @ObfuscatedName("h")
   byte[] field2010 = new byte[128];
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -824901289
   )
   int field2011;
   @ObfuscatedName("l")
   byte[] field2012 = new byte[128];
   @ObfuscatedName("b")
   short[] field2013 = new short[128];

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1622297936"
   )
   public static int method2616(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class0.method6(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass60;[B[IB)Z",
      garbageValue = "76"
   )
   boolean method2617(class60 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class55 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(null == var2 || var2[var7] != 0) {
            int var8 = this.field2009[var7];
            if(var8 != 0) {
               if(var5 != var8) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method1120(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1119(var8 >> 2, var3);
                  }

                  if(null == var6) {
                     var4 = false;
                  }
               }

               if(var6 != null) {
                  this.field2007[var7] = var6;
                  this.field2009[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "796149178"
   )
   void method2618() {
      this.field2009 = null;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZB)I",
      garbageValue = "77"
   )
   static int method2619(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  throw new NumberFormatException();
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var5 * var1 + var10;
            if(var5 != var9 / var1) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
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

      for(int var39 = 0; var39 < var9; ++var39) {
         var10[var39] = var2.readByte();
      }

      ++var2.offset;
      ++var9;
      byte[] var11 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var11[1] = 1;
         int var40 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var15 = var2.readUnsignedByte();
            if(var15 == 0) {
               var40 = var12++;
            } else {
               if(var15 <= var40) {
                  --var15;
               }

               var40 = var15;
            }

            var11[var14] = (byte)var40;
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
            var41.field1922 = new byte[var16 * 2];
         }

         var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var41.field1915 = new byte[var16 * 2 + 2];
            var41.field1915[1] = 64;
         }
      }

      var14 = var2.readUnsignedByte();
      byte[] var48 = var14 > 0?new byte[var14 * 2]:null;
      var14 = var2.readUnsignedByte();
      byte[] var42 = var14 > 0?new byte[var14 * 2]:null;

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
         this.field2013[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.readUnsignedByte();
         this.field2013[var20] = (short)(this.field2013[var20] + (var19 << 8));
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

            var22 = var2.method2878();
         }

         this.field2013[var23] = (short)(this.field2013[var23] + ((var22 - 1 & 2) << 14));
         this.field2009[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2009[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.payload[var5++] - 1;
            }

            this.field2012[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var43 = 0; var43 < 128; ++var43) {
         if(this.field2009[var43] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.payload[var8++] + 16 << 2;
            }

            this.field2010[var43] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class137 var25 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2009[var26] != 0) {
            if(var20 == 0) {
               var25 = var13[var11[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2006[var26] = var25;
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

            if(this.field2009[var27] > 0) {
               var26 = var2.readUnsignedByte() + 1;
            }
         }

         this.field2008[var27] = (byte)var26;
         --var20;
      }

      this.field2011 = var2.readUnsignedByte() + 1;

      int var29;
      class137 var38;
      for(var27 = 0; var27 < var12; ++var27) {
         var38 = var13[var27];
         if(null != var38.field1922) {
            for(var29 = 1; var29 < var38.field1922.length; var29 += 2) {
               var38.field1922[var29] = var2.readByte();
            }
         }

         if(var38.field1915 != null) {
            for(var29 = 3; var29 < var38.field1915.length - 2; var29 += 2) {
               var38.field1915[var29] = var2.readByte();
            }
         }
      }

      if(var48 != null) {
         for(var27 = 1; var27 < var48.length; var27 += 2) {
            var48[var27] = var2.readByte();
         }
      }

      if(null != var42) {
         for(var27 = 1; var27 < var42.length; var27 += 2) {
            var42[var27] = var2.readByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var38 = var13[var27];
         if(var38.field1915 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var38.field1915.length; var29 += 2) {
               var19 = var19 + 1 + var2.readUnsignedByte();
               var38.field1915[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var38 = var13[var27];
         if(null != var38.field1922) {
            var19 = 0;

            for(var29 = 2; var29 < var38.field1922.length; var29 += 2) {
               var19 = 1 + var19 + var2.readUnsignedByte();
               var38.field1922[var29] = (byte)var19;
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
      if(null != var48) {
         var19 = var2.readUnsignedByte();
         var48[0] = (byte)var19;

         for(var27 = 2; var27 < var48.length; var27 += 2) {
            var19 = var19 + 1 + var2.readUnsignedByte();
            var48[var27] = (byte)var19;
         }

         var47 = var48[0];
         byte var28 = var48[1];

         for(var29 = 0; var29 < var47; ++var29) {
            this.field2008[var29] = (byte)(this.field2008[var29] * var28 + 32 >> 6);
         }

         for(var29 = 2; var29 < var48.length; var29 += 2) {
            var30 = var48[var29];
            byte var31 = var48[1 + var29];
            var32 = var28 * (var30 - var47) + (var30 - var47) / 2;

            for(var33 = var47; var33 < var30; ++var33) {
               var35 = var30 - var47;
               var36 = var32 >>> 31;
               var34 = (var36 + var32) / var35 - var36;
               this.field2008[var33] = (byte)(var34 * this.field2008[var33] + 32 >> 6);
               var32 += var31 - var28;
            }

            var47 = var30;
            var28 = var31;
         }

         for(var45 = var47; var45 < 128; ++var45) {
            this.field2008[var45] = (byte)(this.field2008[var45] * var28 + 32 >> 6);
         }

         var41 = null;
      }

      if(null != var42) {
         var19 = var2.readUnsignedByte();
         var42[0] = (byte)var19;

         for(var27 = 2; var27 < var42.length; var27 += 2) {
            var19 = 1 + var19 + var2.readUnsignedByte();
            var42[var27] = (byte)var19;
         }

         var47 = var42[0];
         int var44 = var42[1] << 1;

         for(var29 = 0; var29 < var47; ++var29) {
            var45 = (this.field2010[var29] & 255) + var44;
            if(var45 < 0) {
               var45 = 0;
            }

            if(var45 > 128) {
               var45 = 128;
            }

            this.field2010[var29] = (byte)var45;
         }

         int var46;
         for(var29 = 2; var29 < var42.length; var29 += 2) {
            var30 = var42[var29];
            var46 = var42[1 + var29] << 1;
            var32 = var44 * (var30 - var47) + (var30 - var47) / 2;

            for(var33 = var47; var33 < var30; ++var33) {
               var35 = var30 - var47;
               var36 = var32 >>> 31;
               var34 = (var32 + var36) / var35 - var36;
               int var37 = (this.field2010[var33] & 255) + var34;
               if(var37 < 0) {
                  var37 = 0;
               }

               if(var37 > 128) {
                  var37 = 128;
               }

               this.field2010[var33] = (byte)var37;
               var32 += var46 - var44;
            }

            var47 = var30;
            var44 = var46;
         }

         for(var45 = var47; var45 < 128; ++var45) {
            var46 = var44 + (this.field2010[var45] & 255);
            if(var46 < 0) {
               var46 = 0;
            }

            if(var46 > 128) {
               var46 = 128;
            }

            this.field2010[var45] = (byte)var46;
         }

         Object var49 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field1916 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var38 = var13[var27];
         if(var38.field1922 != null) {
            var38.field1919 = var2.readUnsignedByte();
         }

         if(null != var38.field1915) {
            var38.field1918 = var2.readUnsignedByte();
         }

         if(var38.field1916 > 0) {
            var38.field1914 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field1921 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var38 = var13[var27];
         if(var38.field1921 > 0) {
            var38.field1920 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var38 = var13[var27];
         if(var38.field1920 > 0) {
            var38.field1917 = var2.readUnsignedByte();
         }
      }

   }
}
