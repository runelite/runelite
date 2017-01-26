import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
public class class142 extends Node {
   @ObfuscatedName("d")
   byte[] field1996 = new byte[128];
   @ObfuscatedName("q")
   byte[] field1997 = new byte[128];
   @ObfuscatedName("x")
   short[] field1998 = new short[128];
   @ObfuscatedName("g")
   class55[] field1999 = new class55[128];
   @ObfuscatedName("k")
   class137[] field2001 = new class137[128];
   @ObfuscatedName("j")
   byte[] field2002 = new byte[128];
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1010500023
   )
   int field2003;
   @ObfuscatedName("s")
   int[] field2004 = new int[128];

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass60;[B[IB)Z",
      garbageValue = "90"
   )
   boolean method2691(class60 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class55 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(var2 == null || var2[var7] != 0) {
            int var8 = this.field2004[var7];
            if(var8 != 0) {
               if(var5 != var8) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method1120(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1107(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(var6 != null) {
                  this.field1999[var7] = var6;
                  this.field2004[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "26"
   )
   void method2692() {
      this.field2004 = null;
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
      byte[] var37 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var37[1] = 1;
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

            var37[var14] = (byte)var13;
         }
      } else {
         var12 = var9;
      }

      class137[] var38 = new class137[var12];

      class137 var36;
      for(var14 = 0; var14 < var38.length; ++var14) {
         var36 = var38[var14] = new class137();
         int var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var36.field1908 = new byte[2 * var16];
         }

         var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var36.field1904 = new byte[2 * var16 + 2];
            var36.field1904[1] = 64;
         }
      }

      var14 = var2.readUnsignedByte();
      byte[] var45 = var14 > 0?new byte[var14 * 2]:null;
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
         this.field1998[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.readUnsignedByte();
         this.field1998[var20] = (short)(this.field1998[var20] + (var19 << 8));
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

            var22 = var2.method2859();
         }

         this.field1998[var23] = (short)(this.field1998[var23] + ((var22 - 1 & 2) << 14));
         this.field2004[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2004[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.payload[var5++] - 1;
            }

            this.field2002[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var40 = 0; var40 < 128; ++var40) {
         if(this.field2004[var40] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.payload[var8++] + 16 << 2;
            }

            this.field1996[var40] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class137 var25 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2004[var26] != 0) {
            if(var20 == 0) {
               var25 = var38[var37[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2001[var26] = var25;
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

            if(this.field2004[var27] > 0) {
               var26 = var2.readUnsignedByte() + 1;
            }
         }

         this.field1997[var27] = (byte)var26;
         --var20;
      }

      this.field2003 = var2.readUnsignedByte() + 1;

      class137 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var38[var27];
         if(var28.field1908 != null) {
            for(var29 = 1; var29 < var28.field1908.length; var29 += 2) {
               var28.field1908[var29] = var2.readByte();
            }
         }

         if(var28.field1904 != null) {
            for(var29 = 3; var29 < var28.field1904.length - 2; var29 += 2) {
               var28.field1904[var29] = var2.readByte();
            }
         }
      }

      if(null != var45) {
         for(var27 = 1; var27 < var45.length; var27 += 2) {
            var45[var27] = var2.readByte();
         }
      }

      if(null != var41) {
         for(var27 = 1; var27 < var41.length; var27 += 2) {
            var41[var27] = var2.readByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var38[var27];
         if(null != var28.field1904) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field1904.length; var29 += 2) {
               var19 = 1 + var19 + var2.readUnsignedByte();
               var28.field1904[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var38[var27];
         if(var28.field1908 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field1908.length; var29 += 2) {
               var19 = 1 + var19 + var2.readUnsignedByte();
               var28.field1908[var29] = (byte)var19;
            }
         }
      }

      byte var30;
      int var32;
      int var33;
      int var34;
      int var42;
      byte var44;
      if(null != var45) {
         var19 = var2.readUnsignedByte();
         var45[0] = (byte)var19;

         for(var27 = 2; var27 < var45.length; var27 += 2) {
            var19 = 1 + var19 + var2.readUnsignedByte();
            var45[var27] = (byte)var19;
         }

         var44 = var45[0];
         byte var39 = var45[1];

         for(var29 = 0; var29 < var44; ++var29) {
            this.field1997[var29] = (byte)(this.field1997[var29] * var39 + 32 >> 6);
         }

         for(var29 = 2; var29 < var45.length; var29 += 2) {
            var30 = var45[var29];
            byte var31 = var45[var29 + 1];
            var32 = (var30 - var44) / 2 + (var30 - var44) * var39;

            for(var33 = var44; var33 < var30; ++var33) {
               var34 = class6.calculateHeight(var32, var30 - var44);
               this.field1997[var33] = (byte)(this.field1997[var33] * var34 + 32 >> 6);
               var32 += var31 - var39;
            }

            var44 = var30;
            var39 = var31;
         }

         for(var42 = var44; var42 < 128; ++var42) {
            this.field1997[var42] = (byte)(32 + var39 * this.field1997[var42] >> 6);
         }

         var36 = null;
      }

      if(null != var41) {
         var19 = var2.readUnsignedByte();
         var41[0] = (byte)var19;

         for(var27 = 2; var27 < var41.length; var27 += 2) {
            var19 = var19 + 1 + var2.readUnsignedByte();
            var41[var27] = (byte)var19;
         }

         var44 = var41[0];
         int var46 = var41[1] << 1;

         for(var29 = 0; var29 < var44; ++var29) {
            var42 = (this.field1996[var29] & 255) + var46;
            if(var42 < 0) {
               var42 = 0;
            }

            if(var42 > 128) {
               var42 = 128;
            }

            this.field1996[var29] = (byte)var42;
         }

         int var43;
         for(var29 = 2; var29 < var41.length; var29 += 2) {
            var30 = var41[var29];
            var43 = var41[1 + var29] << 1;
            var32 = var46 * (var30 - var44) + (var30 - var44) / 2;

            for(var33 = var44; var33 < var30; ++var33) {
               var34 = class6.calculateHeight(var32, var30 - var44);
               int var35 = (this.field1996[var33] & 255) + var34;
               if(var35 < 0) {
                  var35 = 0;
               }

               if(var35 > 128) {
                  var35 = 128;
               }

               this.field1996[var33] = (byte)var35;
               var32 += var43 - var46;
            }

            var44 = var30;
            var46 = var43;
         }

         for(var42 = var44; var42 < 128; ++var42) {
            var43 = var46 + (this.field1996[var42] & 255);
            if(var43 < 0) {
               var43 = 0;
            }

            if(var43 > 128) {
               var43 = 128;
            }

            this.field1996[var42] = (byte)var43;
         }

         Object var47 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var38[var27].field1912 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var38[var27];
         if(var28.field1908 != null) {
            var28.field1906 = var2.readUnsignedByte();
         }

         if(null != var28.field1904) {
            var28.field1907 = var2.readUnsignedByte();
         }

         if(var28.field1912 > 0) {
            var28.field1905 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var38[var27].field1910 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var38[var27];
         if(var28.field1910 > 0) {
            var28.field1911 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var38[var27];
         if(var28.field1911 > 0) {
            var28.field1903 = var2.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)LCombatInfo2;",
      garbageValue = "-808377266"
   )
   public static CombatInfo2 method2699(int var0) {
      CombatInfo2 var1 = (CombatInfo2)CombatInfo2.field2838.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class168.field2183.getConfigData(33, var0);
         var1 = new CombatInfo2();
         if(null != var2) {
            var1.method3512(new Buffer(var2));
         }

         CombatInfo2.field2838.put(var1, (long)var0);
         return var1;
      }
   }
}
