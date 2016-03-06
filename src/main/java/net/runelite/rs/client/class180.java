package net.runelite.rs.client;
import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fw")
public class class180 extends class207 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1863942227
   )
   int field2925;
   @ObfuscatedName("l")
   class62[] field2926 = new class62[128];
   @ObfuscatedName("a")
   short[] field2927 = new short[128];
   @ObfuscatedName("i")
   byte[] field2928 = new byte[128];
   @ObfuscatedName("f")
   byte[] field2929 = new byte[128];
   @ObfuscatedName("h")
   int[] field2930 = new int[128];
   @ObfuscatedName("o")
   byte[] field2931 = new byte[128];
   @ObfuscatedName("pr")
   static GarbageCollectorMXBean field2935;
   @ObfuscatedName("m")
   class184[] field2936 = new class184[128];

   class180(byte[] var1) {
      class118 var2 = new class118(var1);

      int var3;
      for(var3 = 0; var2.field1995[var3 + var2.field1998] != 0; ++var3) {
         ;
      }

      byte[] var4 = new byte[var3];

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4[var5] = var2.method2454();
      }

      ++var2.field1998;
      ++var3;
      var5 = var2.field1998;
      var2.field1998 += var3;

      int var6;
      for(var6 = 0; var2.field1995[var2.field1998 + var6] != 0; ++var6) {
         ;
      }

      byte[] var7 = new byte[var6];

      int var8;
      for(var8 = 0; var8 < var6; ++var8) {
         var7[var8] = var2.method2454();
      }

      ++var2.field1998;
      ++var6;
      var8 = var2.field1998;
      var2.field1998 += var6;

      int var9;
      for(var9 = 0; 0 != var2.field1995[var2.field1998 + var9]; ++var9) {
         ;
      }

      byte[] var10 = new byte[var9];

      for(int var11 = 0; var11 < var9; ++var11) {
         var10[var11] = var2.method2454();
      }

      ++var2.field1998;
      ++var9;
      byte[] var36 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var36[1] = 1;
         int var13 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var15 = var2.method2453();
            if(var15 == 0) {
               var13 = var12++;
            } else {
               if(var15 <= var13) {
                  --var15;
               }

               var13 = var15;
            }

            var36[var14] = (byte)var13;
         }
      } else {
         var12 = var9;
      }

      class184[] var37 = new class184[var12];

      class184 var38;
      for(var14 = 0; var14 < var37.length; ++var14) {
         var38 = var37[var14] = new class184();
         int var16 = var2.method2453();
         if(var16 > 0) {
            var38.field2991 = new byte[2 * var16];
         }

         var16 = var2.method2453();
         if(var16 > 0) {
            var38.field2988 = new byte[var16 * 2 + 2];
            var38.field2988[1] = 64;
         }
      }

      var14 = var2.method2453();
      byte[] var39 = var14 > 0?new byte[2 * var14]:null;
      var14 = var2.method2453();
      byte[] var40 = var14 > 0?new byte[2 * var14]:null;

      int var17;
      for(var17 = 0; var2.field1995[var17 + var2.field1998] != 0; ++var17) {
         ;
      }

      byte[] var18 = new byte[var17];

      int var19;
      for(var19 = 0; var19 < var17; ++var19) {
         var18[var19] = var2.method2454();
      }

      ++var2.field1998;
      ++var17;
      var19 = 0;

      int var20;
      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2453();
         this.field2927[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2453();
         this.field2927[var20] = (short)(this.field2927[var20] + (var19 << 8));
      }

      var20 = 0;
      int var21 = 0;
      int var22 = 0;

      int var23;
      for(var23 = 0; var23 < 128; ++var23) {
         if(0 == var20) {
            if(var21 < var18.length) {
               var20 = var18[var21++];
            } else {
               var20 = -1;
            }

            var22 = var2.method2468();
         }

         this.field2927[var23] = (short)(this.field2927[var23] + ((var22 - 1 & 2) << 14));
         this.field2930[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2930[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.field1995[var5++] - 1;
            }

            this.field2931[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if(this.field2930[var25] != 0) {
            if(0 == var20) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.field1995[var8++] + 16 << 2;
            }

            this.field2929[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class184 var42 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2930[var26] != 0) {
            if(var20 == 0) {
               var42 = var37[var36[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2936[var26] = var42;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var26 = 0;

      int var27;
      for(var27 = 0; var27 < 128; ++var27) {
         if(0 == var20) {
            if(var21 < var18.length) {
               var20 = var18[var21++];
            } else {
               var20 = -1;
            }

            if(this.field2930[var27] > 0) {
               var26 = var2.method2453() + 1;
            }
         }

         this.field2928[var27] = (byte)var26;
         --var20;
      }

      this.field2925 = var2.method2453() + 1;

      class184 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field2991 != null) {
            for(var29 = 1; var29 < var28.field2991.length; var29 += 2) {
               var28.field2991[var29] = var2.method2454();
            }
         }

         if(null != var28.field2988) {
            for(var29 = 3; var29 < var28.field2988.length - 2; var29 += 2) {
               var28.field2988[var29] = var2.method2454();
            }
         }
      }

      if(null != var39) {
         for(var27 = 1; var27 < var39.length; var27 += 2) {
            var39[var27] = var2.method2454();
         }
      }

      if(var40 != null) {
         for(var27 = 1; var27 < var40.length; var27 += 2) {
            var40[var27] = var2.method2454();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(null != var28.field2988) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field2988.length; var29 += 2) {
               var19 = var19 + 1 + var2.method2453();
               var28.field2988[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(null != var28.field2991) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field2991.length; var29 += 2) {
               var19 = 1 + var19 + var2.method2453();
               var28.field2991[var29] = (byte)var19;
            }
         }
      }

      byte var30;
      int var32;
      int var33;
      int var34;
      int var45;
      byte var47;
      if(var39 != null) {
         var19 = var2.method2453();
         var39[0] = (byte)var19;

         for(var27 = 2; var27 < var39.length; var27 += 2) {
            var19 = var19 + 1 + var2.method2453();
            var39[var27] = (byte)var19;
         }

         var47 = var39[0];
         byte var43 = var39[1];

         for(var29 = 0; var29 < var47; ++var29) {
            this.field2928[var29] = (byte)(this.field2928[var29] * var43 + 32 >> 6);
         }

         for(var29 = 2; var29 < var39.length; var29 += 2) {
            var30 = var39[var29];
            byte var31 = var39[1 + var29];
            var32 = (var30 - var47) / 2 + (var30 - var47) * var43;

            for(var33 = var47; var33 < var30; ++var33) {
               var34 = class42.method896(var32, var30 - var47);
               this.field2928[var33] = (byte)(var34 * this.field2928[var33] + 32 >> 6);
               var32 += var31 - var43;
            }

            var47 = var30;
            var43 = var31;
         }

         for(var45 = var47; var45 < 128; ++var45) {
            this.field2928[var45] = (byte)(32 + var43 * this.field2928[var45] >> 6);
         }

         var38 = null;
      }

      if(var40 != null) {
         var19 = var2.method2453();
         var40[0] = (byte)var19;

         for(var27 = 2; var27 < var40.length; var27 += 2) {
            var19 = var19 + 1 + var2.method2453();
            var40[var27] = (byte)var19;
         }

         var47 = var40[0];
         int var44 = var40[1] << 1;

         for(var29 = 0; var29 < var47; ++var29) {
            var45 = (this.field2929[var29] & 255) + var44;
            if(var45 < 0) {
               var45 = 0;
            }

            if(var45 > 128) {
               var45 = 128;
            }

            this.field2929[var29] = (byte)var45;
         }

         int var46;
         for(var29 = 2; var29 < var40.length; var29 += 2) {
            var30 = var40[var29];
            var46 = var40[var29 + 1] << 1;
            var32 = (var30 - var47) / 2 + var44 * (var30 - var47);

            for(var33 = var47; var33 < var30; ++var33) {
               var34 = class42.method896(var32, var30 - var47);
               int var35 = (this.field2929[var33] & 255) + var34;
               if(var35 < 0) {
                  var35 = 0;
               }

               if(var35 > 128) {
                  var35 = 128;
               }

               this.field2929[var33] = (byte)var35;
               var32 += var46 - var44;
            }

            var47 = var30;
            var44 = var46;
         }

         for(var45 = var47; var45 < 128; ++var45) {
            var46 = var44 + (this.field2929[var45] & 255);
            if(var46 < 0) {
               var46 = 0;
            }

            if(var46 > 128) {
               var46 = 128;
            }

            this.field2929[var45] = (byte)var46;
         }

         Object var41 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var37[var27].field2989 = var2.method2453();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field2991 != null) {
            var28.field2987 = var2.method2453();
         }

         if(null != var28.field2988) {
            var28.field2990 = var2.method2453();
         }

         if(var28.field2989 > 0) {
            var28.field2992 = var2.method2453();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var37[var27].field2994 = var2.method2453();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field2994 > 0) {
            var28.field2997 = var2.method2453();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field2997 > 0) {
            var28.field2995 = var2.method2453();
         }
      }

   }

   @ObfuscatedName("j")
   boolean method3472(class59 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class62 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(null == var2 || var2[var7] != 0) {
            int var8 = this.field2930[var7];
            if(var8 != 0) {
               if(var5 != var8) {
                  var5 = var8--;
                  if(0 == (var8 & 1)) {
                     var6 = var1.method1254(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1258(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(null != var6) {
                  this.field2926[var7] = var6;
                  this.field2930[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("l")
   void method3473() {
      this.field2930 = null;
   }
}
