import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ed")
public class class144 extends Node {
   @ObfuscatedName("x")
   XHashTable field2011;
   @ObfuscatedName("j")
   byte[] field2012;

   @ObfuscatedName("j")
   void method2749() {
      if(this.field2011 == null) {
         this.field2011 = new XHashTable(16);
         int[] var1 = new int[16];
         int[] var2 = new int[16];
         var2[9] = 128;
         var1[9] = 128;
         class141 var4 = new class141(this.field2012);
         int var5 = var4.method2700();

         int var6;
         for(var6 = 0; var6 < var5; ++var6) {
            var4.method2666(var6);
            var4.method2664(var6);
            var4.method2667(var6);
         }

         label84:
         do {
            while(true) {
               var6 = var4.method2674();
               int var7 = var4.field1986[var6];

               while(var4.field1986[var6] == var7) {
                  var4.method2666(var6);
                  int var8 = var4.method2670(var6);
                  if(var8 == 1) {
                     var4.method2678();
                     var4.method2667(var6);
                     continue label84;
                  }

                  int var9 = var8 & 240;
                  int var10;
                  int var11;
                  int var12;
                  if(var9 == 176) {
                     var10 = var8 & 15;
                     var11 = var8 >> 8 & 127;
                     var12 = var8 >> 16 & 127;
                     if(var11 == 0) {
                        var1[var10] = (var1[var10] & -2080769) + (var12 << 14);
                     }

                     if(var11 == 32) {
                        var1[var10] = (var1[var10] & -16257) + (var12 << 7);
                     }
                  }

                  if(var9 == 192) {
                     var10 = var8 & 15;
                     var11 = var8 >> 8 & 127;
                     var2[var10] = var1[var10] + var11;
                  }

                  if(var9 == 144) {
                     var10 = var8 & 15;
                     var11 = var8 >> 8 & 127;
                     var12 = var8 >> 16 & 127;
                     if(var12 > 0) {
                        int var13 = var2[var10];
                        class134 var14 = (class134)this.field2011.method2405((long)var13);
                        if(var14 == null) {
                           var14 = new class134(new byte[128]);
                           this.field2011.method2403(var14, (long)var13);
                        }

                        var14.field1898[var11] = 1;
                     }
                  }

                  var4.method2664(var6);
                  var4.method2667(var6);
               }
            }
         } while(!var4.method2676());

      }
   }

   @ObfuscatedName("x")
   static class144 method2751(class182 var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      return var3 == null?null:new class144(new Buffer(var3));
   }

   @ObfuscatedName("c")
   void method2752() {
      this.field2011 = null;
   }

   class144(Buffer var1) {
      var1.offset = var1.payload.length - 3;
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedShort();
      int var4 = 14 + var2 * 10;
      var1.offset = 0;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;
      int var9 = 0;
      int var10 = 0;
      int var11 = 0;
      int var12 = 0;

      int var13;
      int var14;
      int var15;
      for(var13 = 0; var13 < var2; ++var13) {
         var14 = -1;

         while(true) {
            var15 = var1.readUnsignedByte();
            if(var15 != var14) {
               ++var4;
            }

            var14 = var15 & 15;
            if(var15 == 7) {
               break;
            }

            if(var15 == 23) {
               ++var5;
            } else if(var14 == 0) {
               ++var7;
            } else if(var14 == 1) {
               ++var8;
            } else if(var14 == 2) {
               ++var6;
            } else if(var14 == 3) {
               ++var9;
            } else if(var14 == 4) {
               ++var10;
            } else if(var14 == 5) {
               ++var11;
            } else {
               if(var14 != 6) {
                  throw new RuntimeException();
               }

               ++var12;
            }
         }
      }

      var4 += 5 * var5;
      var4 += 2 * (var7 + var8 + var6 + var9 + var11);
      var4 += var10 + var12;
      var13 = var1.offset;
      var14 = var2 + var5 + var6 + var7 + var8 + var9 + var10 + var11 + var12;

      for(var15 = 0; var15 < var14; ++var15) {
         var1.method2847();
      }

      var4 += var1.offset - var13;
      var15 = var1.offset;
      int var16 = 0;
      int var17 = 0;
      int var18 = 0;
      int var19 = 0;
      int var20 = 0;
      int var21 = 0;
      int var22 = 0;
      int var23 = 0;
      int var24 = 0;
      int var25 = 0;
      int var26 = 0;
      int var27 = 0;
      int var28 = 0;

      int var29;
      for(var29 = 0; var29 < var6; ++var29) {
         var28 = var28 + var1.readUnsignedByte() & 127;
         if(var28 != 0 && var28 != 32) {
            if(var28 == 1) {
               ++var16;
            } else if(var28 == 33) {
               ++var17;
            } else if(var28 == 7) {
               ++var18;
            } else if(var28 == 39) {
               ++var19;
            } else if(var28 == 10) {
               ++var20;
            } else if(var28 == 42) {
               ++var21;
            } else if(var28 == 99) {
               ++var22;
            } else if(var28 == 98) {
               ++var23;
            } else if(var28 == 101) {
               ++var24;
            } else if(var28 == 100) {
               ++var25;
            } else if(var28 != 64 && var28 != 65 && var28 != 120 && var28 != 121 && var28 != 123) {
               ++var27;
            } else {
               ++var26;
            }
         } else {
            ++var12;
         }
      }

      var29 = 0;
      int var30 = var1.offset;
      var1.offset += var26;
      int var31 = var1.offset;
      var1.offset += var11;
      int var32 = var1.offset;
      var1.offset += var10;
      int var33 = var1.offset;
      var1.offset += var9;
      int var34 = var1.offset;
      var1.offset += var16;
      int var35 = var1.offset;
      var1.offset += var18;
      int var36 = var1.offset;
      var1.offset += var20;
      int var37 = var1.offset;
      var1.offset += var7 + var8 + var11;
      int var38 = var1.offset;
      var1.offset += var7;
      int var39 = var1.offset;
      var1.offset += var27;
      int var40 = var1.offset;
      var1.offset += var8;
      int var41 = var1.offset;
      var1.offset += var17;
      int var42 = var1.offset;
      var1.offset += var19;
      int var43 = var1.offset;
      var1.offset += var21;
      int var44 = var1.offset;
      var1.offset += var12;
      int var45 = var1.offset;
      var1.offset += var9;
      int var46 = var1.offset;
      var1.offset += var22;
      int var47 = var1.offset;
      var1.offset += var23;
      int var48 = var1.offset;
      var1.offset += var24;
      int var49 = var1.offset;
      var1.offset += var25;
      int var50 = var1.offset;
      var1.offset += var5 * 3;
      this.field2012 = new byte[var4];
      Buffer var51 = new Buffer(this.field2012);
      var51.method2819(1297377380);
      var51.method2819(6);
      var51.method2817(var2 > 1?1:0);
      var51.method2817(var2);
      var51.method2817(var3);
      var1.offset = var13;
      int var52 = 0;
      int var53 = 0;
      int var54 = 0;
      int var55 = 0;
      int var56 = 0;
      int var57 = 0;
      int var58 = 0;
      int[] var59 = new int[128];
      var28 = 0;

      label357:
      for(int var60 = 0; var60 < var2; ++var60) {
         var51.method2819(1297379947);
         var51.offset += 4;
         int var61 = var51.offset;
         int var62 = -1;

         while(true) {
            while(true) {
               int var63 = var1.method2847();
               var51.method2830(var63);
               int var64 = var1.payload[var29++] & 255;
               boolean var65 = var64 != var62;
               var62 = var64 & 15;
               if(var64 == 7) {
                  if(var65) {
                     var51.method2843(255);
                  }

                  var51.method2843(47);
                  var51.method2843(0);
                  var51.method2992(var51.offset - var61);
                  continue label357;
               }

               if(var64 == 23) {
                  if(var65) {
                     var51.method2843(255);
                  }

                  var51.method2843(81);
                  var51.method2843(3);
                  var51.method2843(var1.payload[var50++]);
                  var51.method2843(var1.payload[var50++]);
                  var51.method2843(var1.payload[var50++]);
               } else {
                  var52 ^= var64 >> 4;
                  if(var62 == 0) {
                     if(var65) {
                        var51.method2843(144 + var52);
                     }

                     var53 += var1.payload[var37++];
                     var54 += var1.payload[var38++];
                     var51.method2843(var53 & 127);
                     var51.method2843(var54 & 127);
                  } else if(var62 == 1) {
                     if(var65) {
                        var51.method2843(128 + var52);
                     }

                     var53 += var1.payload[var37++];
                     var55 += var1.payload[var40++];
                     var51.method2843(var53 & 127);
                     var51.method2843(var55 & 127);
                  } else if(var62 == 2) {
                     if(var65) {
                        var51.method2843(176 + var52);
                     }

                     var28 = var28 + var1.payload[var15++] & 127;
                     var51.method2843(var28);
                     byte var66;
                     if(var28 != 0 && var28 != 32) {
                        if(var28 == 1) {
                           var66 = var1.payload[var34++];
                        } else if(var28 == 33) {
                           var66 = var1.payload[var41++];
                        } else if(var28 == 7) {
                           var66 = var1.payload[var35++];
                        } else if(var28 == 39) {
                           var66 = var1.payload[var42++];
                        } else if(var28 == 10) {
                           var66 = var1.payload[var36++];
                        } else if(var28 == 42) {
                           var66 = var1.payload[var43++];
                        } else if(var28 == 99) {
                           var66 = var1.payload[var46++];
                        } else if(var28 == 98) {
                           var66 = var1.payload[var47++];
                        } else if(var28 == 101) {
                           var66 = var1.payload[var48++];
                        } else if(var28 == 100) {
                           var66 = var1.payload[var49++];
                        } else if(var28 != 64 && var28 != 65 && var28 != 120 && var28 != 121 && var28 != 123) {
                           var66 = var1.payload[var39++];
                        } else {
                           var66 = var1.payload[var30++];
                        }
                     } else {
                        var66 = var1.payload[var44++];
                     }

                     int var67 = var66 + var59[var28];
                     var59[var28] = var67;
                     var51.method2843(var67 & 127);
                  } else if(var62 == 3) {
                     if(var65) {
                        var51.method2843(224 + var52);
                     }

                     var56 += var1.payload[var45++];
                     var56 += var1.payload[var33++] << 7;
                     var51.method2843(var56 & 127);
                     var51.method2843(var56 >> 7 & 127);
                  } else if(var62 == 4) {
                     if(var65) {
                        var51.method2843(208 + var52);
                     }

                     var57 += var1.payload[var32++];
                     var51.method2843(var57 & 127);
                  } else if(var62 == 5) {
                     if(var65) {
                        var51.method2843(160 + var52);
                     }

                     var53 += var1.payload[var37++];
                     var58 += var1.payload[var31++];
                     var51.method2843(var53 & 127);
                     var51.method2843(var58 & 127);
                  } else {
                     if(var62 != 6) {
                        throw new RuntimeException();
                     }

                     if(var65) {
                        var51.method2843(192 + var52);
                     }

                     var51.method2843(var1.payload[var44++]);
                  }
               }
            }
         }
      }

   }
}
