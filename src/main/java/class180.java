import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class180 extends class207 {
   @ObfuscatedName("g")
   byte[] field2919 = new byte[128];
   @ObfuscatedName("r")
   class62[] field2920 = new class62[128];
   @ObfuscatedName("f")
   short[] field2921 = new short[128];
   @ObfuscatedName("s")
   byte[] field2922 = new byte[128];
   @ObfuscatedName("y")
   byte[] field2923 = new byte[128];
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1288331069
   )
   int field2924;
   @ObfuscatedName("hw")
   @ObfuscatedGetter(
      intValue = 1136014611
   )
   static int field2925;
   @ObfuscatedName("m")
   int[] field2926 = new int[128];
   @ObfuscatedName("e")
   class184[] field2927 = new class184[128];

   @ObfuscatedName("r")
   void method3539() {
      this.field2926 = null;
   }

   @ObfuscatedName("a")
   boolean method3540(class59 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class62 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(var2 == null || 0 != var2[var7]) {
            int var8 = this.field2926[var7];
            if(0 != var8) {
               if(var5 != var8) {
                  var5 = var8--;
                  if(0 == (var8 & 1)) {
                     var6 = var1.method1277(var8 >> 2, var3);
                  } else {
                     var6 = var1.method1279(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(var6 != null) {
                  this.field2920[var7] = var6;
                  this.field2926[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   class180(byte[] var1) {
      class118 var2 = new class118(var1);

      int var3;
      for(var3 = 0; 0 != var2.field1980[var2.field1979 + var3]; ++var3) {
         ;
      }

      byte[] var4 = new byte[var3];

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4[var5] = var2.method2707();
      }

      ++var2.field1979;
      ++var3;
      var5 = var2.field1979;
      var2.field1979 += var3;

      int var6;
      for(var6 = 0; var2.field1980[var6 + var2.field1979] != 0; ++var6) {
         ;
      }

      byte[] var7 = new byte[var6];

      int var8;
      for(var8 = 0; var8 < var6; ++var8) {
         var7[var8] = var2.method2707();
      }

      ++var2.field1979;
      ++var6;
      var8 = var2.field1979;
      var2.field1979 += var6;

      int var9;
      for(var9 = 0; var2.field1980[var9 + var2.field1979] != 0; ++var9) {
         ;
      }

      byte[] var10 = new byte[var9];

      for(int var11 = 0; var11 < var9; ++var11) {
         var10[var11] = var2.method2707();
      }

      ++var2.field1979;
      ++var9;
      byte[] var36 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var36[1] = 1;
         int var13 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var15 = var2.method2579();
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
         int var16 = var2.method2579();
         if(var16 > 0) {
            var38.field2982 = new byte[var16 * 2];
         }

         var16 = var2.method2579();
         if(var16 > 0) {
            var38.field2983 = new byte[var16 * 2 + 2];
            var38.field2983[1] = 64;
         }
      }

      var14 = var2.method2579();
      byte[] var39 = var14 > 0?new byte[2 * var14]:null;
      var14 = var2.method2579();
      byte[] var40 = var14 > 0?new byte[var14 * 2]:null;

      int var17;
      for(var17 = 0; var2.field1980[var17 + var2.field1979] != 0; ++var17) {
         ;
      }

      byte[] var18 = new byte[var17];

      int var19;
      for(var19 = 0; var19 < var17; ++var19) {
         var18[var19] = var2.method2707();
      }

      ++var2.field1979;
      ++var17;
      var19 = 0;

      int var20;
      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2579();
         this.field2921[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method2579();
         this.field2921[var20] = (short)(this.field2921[var20] + (var19 << 8));
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

            var22 = var2.method2617();
         }

         this.field2921[var23] = (short)(this.field2921[var23] + ((var22 - 1 & 2) << 14));
         this.field2926[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2926[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.field1980[var5++] - 1;
            }

            this.field2919[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if(this.field2926[var25] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.field1980[var8++] + 16 << 2;
            }

            this.field2923[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class184 var42 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2926[var26] != 0) {
            if(var20 == 0) {
               var42 = var37[var36[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2927[var26] = var42;
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

            if(this.field2926[var27] > 0) {
               var26 = var2.method2579() + 1;
            }
         }

         this.field2922[var27] = (byte)var26;
         --var20;
      }

      this.field2924 = var2.method2579() + 1;

      class184 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(null != var28.field2982) {
            for(var29 = 1; var29 < var28.field2982.length; var29 += 2) {
               var28.field2982[var29] = var2.method2707();
            }
         }

         if(var28.field2983 != null) {
            for(var29 = 3; var29 < var28.field2983.length - 2; var29 += 2) {
               var28.field2983[var29] = var2.method2707();
            }
         }
      }

      if(var39 != null) {
         for(var27 = 1; var27 < var39.length; var27 += 2) {
            var39[var27] = var2.method2707();
         }
      }

      if(null != var40) {
         for(var27 = 1; var27 < var40.length; var27 += 2) {
            var40[var27] = var2.method2707();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(null != var28.field2983) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field2983.length; var29 += 2) {
               var19 = var19 + 1 + var2.method2579();
               var28.field2983[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(null != var28.field2982) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field2982.length; var29 += 2) {
               var19 = 1 + var19 + var2.method2579();
               var28.field2982[var29] = (byte)var19;
            }
         }
      }

      byte var30;
      int var32;
      int var33;
      int var34;
      int var45;
      byte var47;
      if(null != var39) {
         var19 = var2.method2579();
         var39[0] = (byte)var19;

         for(var27 = 2; var27 < var39.length; var27 += 2) {
            var19 = 1 + var19 + var2.method2579();
            var39[var27] = (byte)var19;
         }

         var47 = var39[0];
         byte var43 = var39[1];

         for(var29 = 0; var29 < var47; ++var29) {
            this.field2922[var29] = (byte)(32 + this.field2922[var29] * var43 >> 6);
         }

         for(var29 = 2; var29 < var39.length; var29 += 2) {
            var30 = var39[var29];
            byte var31 = var39[1 + var29];
            var32 = (var30 - var47) * var43 + (var30 - var47) / 2;

            for(var33 = var47; var33 < var30; ++var33) {
               var34 = class106.method2390(var32, var30 - var47);
               this.field2922[var33] = (byte)(32 + this.field2922[var33] * var34 >> 6);
               var32 += var31 - var43;
            }

            var47 = var30;
            var43 = var31;
         }

         for(var45 = var47; var45 < 128; ++var45) {
            this.field2922[var45] = (byte)(var43 * this.field2922[var45] + 32 >> 6);
         }

         var38 = null;
      }

      if(null != var40) {
         var19 = var2.method2579();
         var40[0] = (byte)var19;

         for(var27 = 2; var27 < var40.length; var27 += 2) {
            var19 = var19 + 1 + var2.method2579();
            var40[var27] = (byte)var19;
         }

         var47 = var40[0];
         int var44 = var40[1] << 1;

         for(var29 = 0; var29 < var47; ++var29) {
            var45 = var44 + (this.field2923[var29] & 255);
            if(var45 < 0) {
               var45 = 0;
            }

            if(var45 > 128) {
               var45 = 128;
            }

            this.field2923[var29] = (byte)var45;
         }

         int var46;
         for(var29 = 2; var29 < var40.length; var29 += 2) {
            var30 = var40[var29];
            var46 = var40[1 + var29] << 1;
            var32 = (var30 - var47) * var44 + (var30 - var47) / 2;

            for(var33 = var47; var33 < var30; ++var33) {
               var34 = class106.method2390(var32, var30 - var47);
               int var35 = var34 + (this.field2923[var33] & 255);
               if(var35 < 0) {
                  var35 = 0;
               }

               if(var35 > 128) {
                  var35 = 128;
               }

               this.field2923[var33] = (byte)var35;
               var32 += var46 - var44;
            }

            var47 = var30;
            var44 = var46;
         }

         for(var45 = var47; var45 < 128; ++var45) {
            var46 = (this.field2923[var45] & 255) + var44;
            if(var46 < 0) {
               var46 = 0;
            }

            if(var46 > 128) {
               var46 = 128;
            }

            this.field2923[var45] = (byte)var46;
         }

         Object var41 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var37[var27].field2984 = var2.method2579();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field2982 != null) {
            var28.field2988 = var2.method2579();
         }

         if(null != var28.field2983) {
            var28.field2986 = var2.method2579();
         }

         if(var28.field2984 > 0) {
            var28.field2987 = var2.method2579();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var37[var27].field2989 = var2.method2579();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field2989 > 0) {
            var28.field2993 = var2.method2579();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field2993 > 0) {
            var28.field2990 = var2.method2579();
         }
      }

   }

   @ObfuscatedName("x")
   static final void method3545() {
      class156.method3177();
      class41.field981.method3800();
      class44.field1028.method3800();
      class40.field945.method3800();
      class40.field933.method3800();
      class40.field927.method3800();
      class40.field934.method3800();
      class39.field883.method3800();
      class39.field884.method3800();
      class51.field1137.method3800();
      class51.field1111.method3800();
      class51.field1155.method3800();
      class42.field986.method3800();
      class42.field1004.method3800();
      class43.field1008.method3800();
      class43.field1020.method3800();
      class1.method13();
      class49.method1022();
      class30.method666();
      class172.field2737.method3800();
      class172.field2738.method3800();
      class172.field2801.method3800();
      class172.field2798.method3800();
      ((class94)class90.field1574).method2189();
      class22.field604.method3800();
      class27.field672.method3276();
      class138.field2129.method3276();
      class188.field3040.method3276();
      class12.field181.method3276();
      class49.field1088.method3276();
      class129.field2054.method3276();
      class175.field2892.method3276();
      class7.field127.method3276();
      class1.field18.method3276();
      class213.field3146.method3276();
      class29.field701.method3276();
      class24.field623.method3276();
   }

   @ObfuscatedName("a")
   public static String method3546(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && 46 != var4 && 45 != var4 && var4 != 42 && var4 != 95) {
            if(var4 == 32) {
               var2.append('+');
            } else {
               byte var5 = class120.method2749(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(55 + var6));
               } else {
                  var2.append((char)(48 + var6));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(48 + var6));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIB)V",
      garbageValue = "-62"
   )
   static final void method3547(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class16 var9 = null;

      for(class16 var10 = (class16)client.field427.method3860(); null != var10; var10 = (class16)client.field427.method3861()) {
         if(var10.field236 == var0 && var10.field229 == var1 && var10.field244 == var2 && var3 == var10.field227) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new class16();
         var9.field236 = var0;
         var9.field227 = var3;
         var9.field229 = var1;
         var9.field244 = var2;
         class17.method205(var9);
         client.field427.method3855(var9);
      }

      var9.field234 = var4;
      var9.field242 = var5;
      var9.field235 = var6;
      var9.field237 = var7;
      var9.field238 = var8;
   }
}
