import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
public class class142 extends Node {
   @ObfuscatedName("d")
   class55[] field1993 = new class55[128];
   @ObfuscatedName("h")
   byte[] field1994 = new byte[128];
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1305787091
   )
   int field1995;
   @ObfuscatedName("w")
   byte[] field1996 = new byte[128];
   @ObfuscatedName("r")
   class137[] field1997 = new class137[128];
   @ObfuscatedName("c")
   byte[] field1998 = new byte[128];
   @ObfuscatedName("p")
   int[] field1999 = new int[128];
   @ObfuscatedName("m")
   short[] field2004 = new short[128];

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass60;[B[IB)Z",
      garbageValue = "48"
   )
   boolean method2739(class60 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class55 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(var2 == null || var2[var7] != 0) {
            int var8 = this.field1999[var7];
            if(var8 != 0) {
               if(var5 != var8) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method1129(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1130(var8 >> 2, var3);
                  }

                  if(null == var6) {
                     var4 = false;
                  }
               }

               if(var6 != null) {
                  this.field1993[var7] = var6;
                  this.field1999[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1466305503"
   )
   void method2740() {
      this.field1999 = null;
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
         var4[var5] = var2.method3047();
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
         var7[var8] = var2.method3047();
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
         var10[var11] = var2.method3047();
      }

      ++var2.offset;
      ++var9;
      byte[] var36 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var36[1] = 1;
         int var37 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var15 = var2.method3033();
            if(var15 == 0) {
               var37 = var12++;
            } else {
               if(var15 <= var37) {
                  --var15;
               }

               var37 = var15;
            }

            var36[var14] = (byte)var37;
         }
      } else {
         var12 = var9;
      }

      class137[] var13 = new class137[var12];

      class137 var38;
      for(var14 = 0; var14 < var13.length; ++var14) {
         var38 = var13[var14] = new class137();
         int var16 = var2.method3033();
         if(var16 > 0) {
            var38.field1907 = new byte[var16 * 2];
         }

         var16 = var2.method3033();
         if(var16 > 0) {
            var38.field1899 = new byte[2 + 2 * var16];
            var38.field1899[1] = 64;
         }
      }

      var14 = var2.method3033();
      byte[] var45 = var14 > 0?new byte[2 * var14]:null;
      var14 = var2.method3033();
      byte[] var40 = var14 > 0?new byte[2 * var14]:null;

      int var17;
      for(var17 = 0; var2.payload[var2.offset + var17] != 0; ++var17) {
         ;
      }

      byte[] var18 = new byte[var17];

      int var19;
      for(var19 = 0; var19 < var17; ++var19) {
         var18[var19] = var2.method3047();
      }

      ++var2.offset;
      ++var17;
      var19 = 0;

      int var20;
      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method3033();
         this.field2004[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method3033();
         this.field2004[var20] = (short)(this.field2004[var20] + (var19 << 8));
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

            var22 = var2.method3142();
         }

         this.field2004[var23] = (short)(this.field2004[var23] + ((var22 - 1 & 2) << 14));
         this.field1999[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field1999[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.payload[var5++] - 1;
            }

            this.field1998[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if(this.field1999[var25] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.payload[var8++] + 16 << 2;
            }

            this.field1996[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class137 var39 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field1999[var26] != 0) {
            if(var20 == 0) {
               var39 = var13[var36[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field1997[var26] = var39;
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

            if(this.field1999[var27] > 0) {
               var26 = var2.method3033() + 1;
            }
         }

         this.field1994[var27] = (byte)var26;
         --var20;
      }

      this.field1995 = var2.method3033() + 1;

      class137 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(null != var28.field1907) {
            for(var29 = 1; var29 < var28.field1907.length; var29 += 2) {
               var28.field1907[var29] = var2.method3047();
            }
         }

         if(null != var28.field1899) {
            for(var29 = 3; var29 < var28.field1899.length - 2; var29 += 2) {
               var28.field1899[var29] = var2.method3047();
            }
         }
      }

      if(null != var45) {
         for(var27 = 1; var27 < var45.length; var27 += 2) {
            var45[var27] = var2.method3047();
         }
      }

      if(var40 != null) {
         for(var27 = 1; var27 < var40.length; var27 += 2) {
            var40[var27] = var2.method3047();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1899 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field1899.length; var29 += 2) {
               var19 = 1 + var19 + var2.method3033();
               var28.field1899[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(null != var28.field1907) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field1907.length; var29 += 2) {
               var19 = 1 + var19 + var2.method3033();
               var28.field1907[var29] = (byte)var19;
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
         var19 = var2.method3033();
         var45[0] = (byte)var19;

         for(var27 = 2; var27 < var45.length; var27 += 2) {
            var19 = var19 + 1 + var2.method3033();
            var45[var27] = (byte)var19;
         }

         var44 = var45[0];
         byte var41 = var45[1];

         for(var29 = 0; var29 < var44; ++var29) {
            this.field1994[var29] = (byte)(32 + var41 * this.field1994[var29] >> 6);
         }

         for(var29 = 2; var29 < var45.length; var29 += 2) {
            var30 = var45[var29];
            byte var31 = var45[var29 + 1];
            var32 = var41 * (var30 - var44) + (var30 - var44) / 2;

            for(var33 = var44; var33 < var30; ++var33) {
               var34 = class166.method3254(var32, var30 - var44);
               this.field1994[var33] = (byte)(32 + var34 * this.field1994[var33] >> 6);
               var32 += var31 - var41;
            }

            var44 = var30;
            var41 = var31;
         }

         for(var42 = var44; var42 < 128; ++var42) {
            this.field1994[var42] = (byte)(32 + var41 * this.field1994[var42] >> 6);
         }

         var38 = null;
      }

      if(null != var40) {
         var19 = var2.method3033();
         var40[0] = (byte)var19;

         for(var27 = 2; var27 < var40.length; var27 += 2) {
            var19 = 1 + var19 + var2.method3033();
            var40[var27] = (byte)var19;
         }

         var44 = var40[0];
         int var47 = var40[1] << 1;

         for(var29 = 0; var29 < var44; ++var29) {
            var42 = var47 + (this.field1996[var29] & 255);
            if(var42 < 0) {
               var42 = 0;
            }

            if(var42 > 128) {
               var42 = 128;
            }

            this.field1996[var29] = (byte)var42;
         }

         int var43;
         for(var29 = 2; var29 < var40.length; var29 += 2) {
            var30 = var40[var29];
            var43 = var40[var29 + 1] << 1;
            var32 = var47 * (var30 - var44) + (var30 - var44) / 2;

            for(var33 = var44; var33 < var30; ++var33) {
               var34 = class166.method3254(var32, var30 - var44);
               int var35 = var34 + (this.field1996[var33] & 255);
               if(var35 < 0) {
                  var35 = 0;
               }

               if(var35 > 128) {
                  var35 = 128;
               }

               this.field1996[var33] = (byte)var35;
               var32 += var43 - var47;
            }

            var44 = var30;
            var47 = var43;
         }

         for(var42 = var44; var42 < 128; ++var42) {
            var43 = (this.field1996[var42] & 255) + var47;
            if(var43 < 0) {
               var43 = 0;
            }

            if(var43 > 128) {
               var43 = 128;
            }

            this.field1996[var42] = (byte)var43;
         }

         Object var46 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field1898 = var2.method3033();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1907 != null) {
            var28.field1901 = var2.method3033();
         }

         if(null != var28.field1899) {
            var28.field1902 = var2.method3033();
         }

         if(var28.field1898 > 0) {
            var28.field1900 = var2.method3033();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field1905 = var2.method3033();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1905 > 0) {
            var28.field1904 = var2.method3033();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1904 > 0) {
            var28.field1906 = var2.method3033();
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "44"
   )
   public static void method2746(int var0) {
      if(var0 != -1) {
         if(Widget.validInterfaces[var0]) {
            Widget.field2059.method3354(var0);
            if(null != Widget.widgets[var0]) {
               boolean var1 = true;

               for(int var2 = 0; var2 < Widget.widgets[var0].length; ++var2) {
                  if(Widget.widgets[var0][var2] != null) {
                     if(Widget.widgets[var0][var2].type != 2) {
                        Widget.widgets[var0][var2] = null;
                     } else {
                        var1 = false;
                     }
                  }
               }

               if(var1) {
                  Widget.widgets[var0] = null;
               }

               Widget.validInterfaces[var0] = false;
            }
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILclass116;Lclass184;I)V",
      garbageValue = "2139662933"
   )
   static void method2747(int var0, class116 var1, class184 var2) {
      byte[] var3 = null;
      Deque var4 = class183.field2731;
      synchronized(class183.field2731) {
         for(class180 var5 = (class180)class183.field2731.method2466(); null != var5; var5 = (class180)class183.field2731.method2461()) {
            if((long)var0 == var5.hash && var1 == var5.field2701 && var5.field2699 == 0) {
               var3 = var5.field2700;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.method3430(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method2297(var0);
         var2.method3430(var1, var0, var8, true);
      }
   }
}
