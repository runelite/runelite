import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
public class class142 extends Node {
   @ObfuscatedName("k")
   byte[] field2000 = new byte[128];
   @ObfuscatedName("c")
   class55[] field2001 = new class55[128];
   @ObfuscatedName("f")
   short[] field2002 = new short[128];
   @ObfuscatedName("h")
   byte[] field2003 = new byte[128];
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1875563421
   )
   int field2004;
   @ObfuscatedName("g")
   class137[] field2005 = new class137[128];
   @ObfuscatedName("a")
   byte[] field2006 = new byte[128];
   @ObfuscatedName("u")
   int[] field2007 = new int[128];

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass60;[B[II)Z",
      garbageValue = "1723438325"
   )
   boolean method2604(class60 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class55 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(var2 == null || var2[var7] != 0) {
            int var8 = this.field2007[var7];
            if(var8 != 0) {
               if(var5 != var8) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method1081(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1082(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(null != var6) {
                  this.field2001[var7] = var6;
                  this.field2007[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "16256"
   )
   void method2605() {
      this.field2007 = null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "2061586729"
   )
   public static int method2606(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = 1 + (var0 << 4);
      }

      return var2;
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
      for(var9 = 0; var2.payload[var2.offset + var9] != 0; ++var9) {
         ;
      }

      byte[] var10 = new byte[var9];

      for(int var36 = 0; var36 < var9; ++var36) {
         var10[var36] = var2.readByte();
      }

      ++var2.offset;
      ++var9;
      byte[] var11 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var11[1] = 1;
         int var37 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var15 = var2.readUnsignedByte();
            if(var15 == 0) {
               var37 = var12++;
            } else {
               if(var15 <= var37) {
                  --var15;
               }

               var37 = var15;
            }

            var11[var14] = (byte)var37;
         }
      } else {
         var12 = var9;
      }

      class137[] var13 = new class137[var12];

      class137 var38;
      for(var14 = 0; var14 < var13.length; ++var14) {
         var38 = var13[var14] = new class137();
         int var40 = var2.readUnsignedByte();
         if(var40 > 0) {
            var38.field1916 = new byte[var40 * 2];
         }

         var40 = var2.readUnsignedByte();
         if(var40 > 0) {
            var38.field1908 = new byte[2 * var40 + 2];
            var38.field1908[1] = 64;
         }
      }

      var14 = var2.readUnsignedByte();
      byte[] var46 = var14 > 0?new byte[var14 * 2]:null;
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
         this.field2002[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.readUnsignedByte();
         this.field2002[var20] = (short)(this.field2002[var20] + (var19 << 8));
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

            var22 = var2.method2851();
         }

         this.field2002[var23] = (short)(this.field2002[var23] + ((var22 - 1 & 2) << 14));
         this.field2007[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2007[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.payload[var5++] - 1;
            }

            this.field2000[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var41 = 0; var41 < 128; ++var41) {
         if(this.field2007[var41] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.payload[var8++] + 16 << 2;
            }

            this.field2006[var41] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class137 var25 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2007[var26] != 0) {
            if(var20 == 0) {
               var25 = var13[var11[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2005[var26] = var25;
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

            if(this.field2007[var27] > 0) {
               var26 = var2.readUnsignedByte() + 1;
            }
         }

         this.field2003[var27] = (byte)var26;
         --var20;
      }

      this.field2004 = var2.readUnsignedByte() + 1;

      class137 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1916 != null) {
            for(var29 = 1; var29 < var28.field1916.length; var29 += 2) {
               var28.field1916[var29] = var2.readByte();
            }
         }

         if(null != var28.field1908) {
            for(var29 = 3; var29 < var28.field1908.length - 2; var29 += 2) {
               var28.field1908[var29] = var2.readByte();
            }
         }
      }

      if(null != var46) {
         for(var27 = 1; var27 < var46.length; var27 += 2) {
            var46[var27] = var2.readByte();
         }
      }

      if(var16 != null) {
         for(var27 = 1; var27 < var16.length; var27 += 2) {
            var16[var27] = var2.readByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1908 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field1908.length; var29 += 2) {
               var19 = 1 + var19 + var2.readUnsignedByte();
               var28.field1908[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(null != var28.field1916) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field1916.length; var29 += 2) {
               var19 = 1 + var19 + var2.readUnsignedByte();
               var28.field1916[var29] = (byte)var19;
            }
         }
      }

      byte var30;
      int var32;
      int var33;
      int var34;
      int var43;
      byte var45;
      if(var46 != null) {
         var19 = var2.readUnsignedByte();
         var46[0] = (byte)var19;

         for(var27 = 2; var27 < var46.length; var27 += 2) {
            var19 = 1 + var19 + var2.readUnsignedByte();
            var46[var27] = (byte)var19;
         }

         var45 = var46[0];
         byte var39 = var46[1];

         for(var29 = 0; var29 < var45; ++var29) {
            this.field2003[var29] = (byte)(32 + var39 * this.field2003[var29] >> 6);
         }

         for(var29 = 2; var29 < var46.length; var29 += 2) {
            var30 = var46[var29];
            byte var31 = var46[var29 + 1];
            var32 = var39 * (var30 - var45) + (var30 - var45) / 2;

            for(var33 = var45; var33 < var30; ++var33) {
               var34 = Renderable.calculateHeight(var32, var30 - var45);
               this.field2003[var33] = (byte)(this.field2003[var33] * var34 + 32 >> 6);
               var32 += var31 - var39;
            }

            var45 = var30;
            var39 = var31;
         }

         for(var43 = var45; var43 < 128; ++var43) {
            this.field2003[var43] = (byte)(var39 * this.field2003[var43] + 32 >> 6);
         }

         var38 = null;
      }

      if(null != var16) {
         var19 = var2.readUnsignedByte();
         var16[0] = (byte)var19;

         for(var27 = 2; var27 < var16.length; var27 += 2) {
            var19 = 1 + var19 + var2.readUnsignedByte();
            var16[var27] = (byte)var19;
         }

         var45 = var16[0];
         int var47 = var16[1] << 1;

         for(var29 = 0; var29 < var45; ++var29) {
            var43 = var47 + (this.field2006[var29] & 255);
            if(var43 < 0) {
               var43 = 0;
            }

            if(var43 > 128) {
               var43 = 128;
            }

            this.field2006[var29] = (byte)var43;
         }

         int var44;
         for(var29 = 2; var29 < var16.length; var29 += 2) {
            var30 = var16[var29];
            var44 = var16[1 + var29] << 1;
            var32 = (var30 - var45) / 2 + var47 * (var30 - var45);

            for(var33 = var45; var33 < var30; ++var33) {
               var34 = Renderable.calculateHeight(var32, var30 - var45);
               int var35 = var34 + (this.field2006[var33] & 255);
               if(var35 < 0) {
                  var35 = 0;
               }

               if(var35 > 128) {
                  var35 = 128;
               }

               this.field2006[var33] = (byte)var35;
               var32 += var44 - var47;
            }

            var45 = var30;
            var47 = var44;
         }

         for(var43 = var45; var43 < 128; ++var43) {
            var44 = var47 + (this.field2006[var43] & 255);
            if(var44 < 0) {
               var44 = 0;
            }

            if(var44 > 128) {
               var44 = 128;
            }

            this.field2006[var43] = (byte)var44;
         }

         Object var42 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field1917 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1916 != null) {
            var28.field1915 = var2.readUnsignedByte();
         }

         if(var28.field1908 != null) {
            var28.field1910 = var2.readUnsignedByte();
         }

         if(var28.field1917 > 0) {
            var28.field1912 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var13[var27].field1914 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1914 > 0) {
            var28.field1913 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var13[var27];
         if(var28.field1913 > 0) {
            var28.field1911 = var2.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("f")
   public static String method2609(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); 0L != var0; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class205.field3086[(int)(var6 - var0 * 37L)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }
}
