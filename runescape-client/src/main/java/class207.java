import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
public class class207 extends Node {
   @ObfuscatedName("z")
   int[] field2584;
   @ObfuscatedName("p")
   class107[] field2585;
   @ObfuscatedName("i")
   short[] field2586;
   @ObfuscatedName("f")
   byte[] field2587;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -968413101
   )
   int field2588;
   @ObfuscatedName("m")
   class202[] field2589;
   @ObfuscatedName("j")
   byte[] field2590;
   @ObfuscatedName("c")
   byte[] field2591;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 562365687
   )
   static int field2592;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass112;[B[II)Z",
      garbageValue = "-823873859"
   )
   boolean method3900(class112 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class107 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(var2 == null || var2[var7] != 0) {
            int var8 = this.field2584[var7];
            if(var8 != 0) {
               if(var5 != var8) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method2077(var8 >> 2, var3);
                  } else {
                     var6 = var1.method2081(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(var6 != null) {
                  this.field2585[var7] = var6;
                  this.field2584[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1818651005"
   )
   void method3901() {
      this.field2584 = null;
   }

   class207(byte[] var1) {
      this.field2585 = new class107[128];
      this.field2586 = new short[128];
      this.field2590 = new byte[128];
      this.field2587 = new byte[128];
      this.field2589 = new class202[128];
      this.field2591 = new byte[128];
      this.field2584 = new int[128];
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
            int var38 = var2.readUnsignedByte();
            if(var38 == 0) {
               var13 = var12++;
            } else {
               if(var38 <= var13) {
                  --var38;
               }

               var13 = var38;
            }

            var37[var14] = (byte)var13;
         }
      } else {
         var12 = var9;
      }

      class202[] var39 = new class202[var12];

      class202 var15;
      for(var14 = 0; var14 < var39.length; ++var14) {
         var15 = var39[var14] = new class202();
         int var40 = var2.readUnsignedByte();
         if(var40 > 0) {
            var15.field2507 = new byte[var40 * 2];
         }

         var40 = var2.readUnsignedByte();
         if(var40 > 0) {
            var15.field2503 = new byte[var40 * 2 + 2];
            var15.field2503[1] = 64;
         }
      }

      var14 = var2.readUnsignedByte();
      byte[] var42 = var14 > 0?new byte[var14 * 2]:null;
      var14 = var2.readUnsignedByte();
      byte[] var16 = var14 > 0?new byte[var14 * 2]:null;

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
         this.field2586[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.readUnsignedByte();
         this.field2586[var20] = (short)(this.field2586[var20] + (var19 << 8));
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

            var22 = var2.readVarInt();
         }

         this.field2586[var23] = (short)(this.field2586[var23] + ((var22 - 1 & 2) << 14));
         this.field2584[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2584[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.payload[var5++] - 1;
            }

            this.field2591[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if(this.field2584[var25] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.payload[var8++] + 16 << 2;
            }

            this.field2587[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class202 var41 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2584[var26] != 0) {
            if(var20 == 0) {
               var41 = var39[var37[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2589[var26] = var41;
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

            if(this.field2584[var27] > 0) {
               var26 = var2.readUnsignedByte() + 1;
            }
         }

         this.field2590[var27] = (byte)var26;
         --var20;
      }

      this.field2588 = var2.readUnsignedByte() + 1;

      int var29;
      class202 var36;
      for(var27 = 0; var27 < var12; ++var27) {
         var36 = var39[var27];
         if(var36.field2507 != null) {
            for(var29 = 1; var29 < var36.field2507.length; var29 += 2) {
               var36.field2507[var29] = var2.readByte();
            }
         }

         if(var36.field2503 != null) {
            for(var29 = 3; var29 < var36.field2503.length - 2; var29 += 2) {
               var36.field2503[var29] = var2.readByte();
            }
         }
      }

      if(var42 != null) {
         for(var27 = 1; var27 < var42.length; var27 += 2) {
            var42[var27] = var2.readByte();
         }
      }

      if(var16 != null) {
         for(var27 = 1; var27 < var16.length; var27 += 2) {
            var16[var27] = var2.readByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var36 = var39[var27];
         if(var36.field2503 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var36.field2503.length; var29 += 2) {
               var19 = var19 + 1 + var2.readUnsignedByte();
               var36.field2503[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var36 = var39[var27];
         if(var36.field2507 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var36.field2507.length; var29 += 2) {
               var19 = var19 + 1 + var2.readUnsignedByte();
               var36.field2507[var29] = (byte)var19;
            }
         }
      }

      byte var30;
      int var32;
      int var33;
      int var34;
      int var45;
      byte var47;
      if(var42 != null) {
         var19 = var2.readUnsignedByte();
         var42[0] = (byte)var19;

         for(var27 = 2; var27 < var42.length; var27 += 2) {
            var19 = var19 + 1 + var2.readUnsignedByte();
            var42[var27] = (byte)var19;
         }

         var47 = var42[0];
         byte var28 = var42[1];

         for(var29 = 0; var29 < var47; ++var29) {
            this.field2590[var29] = (byte)(this.field2590[var29] * var28 + 32 >> 6);
         }

         for(var29 = 2; var29 < var42.length; var29 += 2) {
            var30 = var42[var29];
            byte var31 = var42[var29 + 1];
            var32 = var28 * (var30 - var47) + (var30 - var47) / 2;

            for(var33 = var47; var33 < var30; ++var33) {
               var34 = class116.method2105(var32, var30 - var47);
               this.field2590[var33] = (byte)(var34 * this.field2590[var33] + 32 >> 6);
               var32 += var31 - var28;
            }

            var47 = var30;
            var28 = var31;
         }

         for(var45 = var47; var45 < 128; ++var45) {
            this.field2590[var45] = (byte)(this.field2590[var45] * var28 + 32 >> 6);
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

         var47 = var16[0];
         int var44 = var16[1] << 1;

         for(var29 = 0; var29 < var47; ++var29) {
            var45 = (this.field2587[var29] & 255) + var44;
            if(var45 < 0) {
               var45 = 0;
            }

            if(var45 > 128) {
               var45 = 128;
            }

            this.field2587[var29] = (byte)var45;
         }

         int var46;
         for(var29 = 2; var29 < var16.length; var29 += 2) {
            var30 = var16[var29];
            var46 = var16[var29 + 1] << 1;
            var32 = (var30 - var47) / 2 + var44 * (var30 - var47);

            for(var33 = var47; var33 < var30; ++var33) {
               var34 = class116.method2105(var32, var30 - var47);
               int var35 = (this.field2587[var33] & 255) + var34;
               if(var35 < 0) {
                  var35 = 0;
               }

               if(var35 > 128) {
                  var35 = 128;
               }

               this.field2587[var33] = (byte)var35;
               var32 += var46 - var44;
            }

            var47 = var30;
            var44 = var46;
         }

         for(var45 = var47; var45 < 128; ++var45) {
            var46 = (this.field2587[var45] & 255) + var44;
            if(var46 < 0) {
               var46 = 0;
            }

            if(var46 > 128) {
               var46 = 128;
            }

            this.field2587[var45] = (byte)var46;
         }

         Object var43 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var39[var27].field2508 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var36 = var39[var27];
         if(var36.field2507 != null) {
            var36.field2504 = var2.readUnsignedByte();
         }

         if(var36.field2503 != null) {
            var36.field2506 = var2.readUnsignedByte();
         }

         if(var36.field2508 > 0) {
            var36.field2505 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var39[var27].field2509 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var36 = var39[var27];
         if(var36.field2509 > 0) {
            var36.field2510 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var36 = var39[var27];
         if(var36.field2510 > 0) {
            var36.field2502 = var2.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass69;II)V",
      garbageValue = "-1902249213"
   )
   static void method3902(class69 var0, int var1) {
      Object[] var2 = var0.field833;
      class219 var5 = var0.field831;
      boolean var4 = class219.field2789 == var5 || class219.field2790 == var5 || class219.field2797 == var5 || class219.field2791 == var5 || class219.field2792 == var5 || class219.field2793 == var5 || var5 == class219.field2794 || class219.field2795 == var5;
      Script var3;
      int var24;
      if(var4) {
         class83.field1352 = (class47)var2[0];
         Area var6 = World.field1300[class83.field1352.field600];
         var3 = class51.method749(var0.field831, var6.field3307, var6.field3313);
      } else {
         var24 = ((Integer)var2[0]).intValue();
         var3 = Projectile.method1735(var24);
      }

      if(var3 != null) {
         class165.intStackSize = 0;
         ISAACCipher.scriptStringStackSize = 0;
         var24 = -1;
         int[] var7 = var3.instructions;
         int[] var8 = var3.intOperands;
         byte var9 = -1;
         class83.scriptStackCount = 0;

         int var12;
         try {
            class83.scriptLocalInts = new int[var3.localIntCount];
            int var10 = 0;
            class83.scriptLocalStrings = new String[var3.localStringCount];
            int var11 = 0;

            int var13;
            String var25;
            for(var12 = 1; var12 < var2.length; ++var12) {
               if(var2[var12] instanceof Integer) {
                  var13 = ((Integer)var2[var12]).intValue();
                  if(var13 == -2147483647) {
                     var13 = var0.field822;
                  }

                  if(var13 == -2147483646) {
                     var13 = var0.field826;
                  }

                  if(var13 == -2147483645) {
                     var13 = var0.field824 != null?var0.field824.id:-1;
                  }

                  if(var13 == -2147483644) {
                     var13 = var0.field827;
                  }

                  if(var13 == -2147483643) {
                     var13 = var0.field824 != null?var0.field824.index:-1;
                  }

                  if(var13 == -2147483642) {
                     var13 = var0.field835 != null?var0.field835.id:-1;
                  }

                  if(var13 == -2147483641) {
                     var13 = var0.field835 != null?var0.field835.index:-1;
                  }

                  if(var13 == -2147483640) {
                     var13 = var0.field829;
                  }

                  if(var13 == -2147483639) {
                     var13 = var0.field830;
                  }

                  class83.scriptLocalInts[var10++] = var13;
               } else if(var2[var12] instanceof String) {
                  var25 = (String)var2[var12];
                  if(var25.equals("event_opbase")) {
                     var25 = var0.field828;
                  }

                  class83.scriptLocalStrings[var11++] = var25;
               }
            }

            var12 = 0;
            class83.field1344 = var0.field832;

            while(true) {
               while(true) {
                  while(true) {
                     while(true) {
                        while(true) {
                           while(true) {
                              while(true) {
                                 while(true) {
                                    while(true) {
                                       while(true) {
                                          while(true) {
                                             while(true) {
                                                while(true) {
                                                   while(true) {
                                                      while(true) {
                                                         while(true) {
                                                            while(true) {
                                                               while(true) {
                                                                  while(true) {
                                                                     while(true) {
                                                                        while(true) {
                                                                           while(true) {
                                                                              while(true) {
                                                                                 while(true) {
                                                                                    while(true) {
                                                                                       label1774:
                                                                                       while(true) {
                                                                                          ++var12;
                                                                                          if(var12 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var24;
                                                                                          int var40 = var7[var24];
                                                                                          int var14;
                                                                                          int var16;
                                                                                          int var17;
                                                                                          int var18;
                                                                                          int var19;
                                                                                          if(var40 < 100) {
                                                                                             if(var40 != 0) {
                                                                                                if(var40 != 1) {
                                                                                                   if(var40 != 2) {
                                                                                                      if(var40 != 3) {
                                                                                                         if(var40 != 6) {
                                                                                                            if(var40 != 7) {
                                                                                                               if(var40 != 8) {
                                                                                                                  if(var40 != 9) {
                                                                                                                     if(var40 != 10) {
                                                                                                                        if(var40 != 21) {
                                                                                                                           if(var40 != 25) {
                                                                                                                              if(var40 != 27) {
                                                                                                                                 if(var40 != 31) {
                                                                                                                                    if(var40 != 32) {
                                                                                                                                       if(var40 != 33) {
                                                                                                                                          if(var40 != 34) {
                                                                                                                                             if(var40 != 35) {
                                                                                                                                                if(var40 != 36) {
                                                                                                                                                   if(var40 != 37) {
                                                                                                                                                      if(var40 != 38) {
                                                                                                                                                         if(var40 != 39) {
                                                                                                                                                            if(var40 != 40) {
                                                                                                                                                               if(var40 != 42) {
                                                                                                                                                                  if(var40 != 43) {
                                                                                                                                                                     if(var40 == 44) {
                                                                                                                                                                        var13 = var8[var24] >> 16;
                                                                                                                                                                        var14 = var8[var24] & '\uffff';
                                                                                                                                                                        int var72 = class83.intStack[--class165.intStackSize];
                                                                                                                                                                        if(var72 >= 0 && var72 <= 5000) {
                                                                                                                                                                           class83.field1353[var13] = var72;
                                                                                                                                                                           byte var71 = -1;
                                                                                                                                                                           if(var14 == 105) {
                                                                                                                                                                              var71 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var17 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var17 >= var72) {
                                                                                                                                                                                 continue label1774;
                                                                                                                                                                              }

                                                                                                                                                                              class83.field1345[var13][var17] = var71;
                                                                                                                                                                              ++var17;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var40 == 45) {
                                                                                                                                                                        var13 = var8[var24];
                                                                                                                                                                        var14 = class83.intStack[--class165.intStackSize];
                                                                                                                                                                        if(var14 < 0 || var14 >= class83.field1353[var13]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class83.intStack[++class165.intStackSize - 1] = class83.field1345[var13][var14];
                                                                                                                                                                     } else if(var40 == 46) {
                                                                                                                                                                        var13 = var8[var24];
                                                                                                                                                                        class165.intStackSize -= 2;
                                                                                                                                                                        var14 = class83.intStack[class165.intStackSize];
                                                                                                                                                                        if(var14 < 0 || var14 >= class83.field1353[var13]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class83.field1345[var13][var14] = class83.intStack[class165.intStackSize + 1];
                                                                                                                                                                     } else if(var40 == 47) {
                                                                                                                                                                        var25 = Tile.chatMessages.method1769(var8[var24]);
                                                                                                                                                                        if(var25 == null) {
                                                                                                                                                                           var25 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var25;
                                                                                                                                                                     } else if(var40 == 48) {
                                                                                                                                                                        Tile.chatMessages.method1768(var8[var24], class83.scriptStringStack[--ISAACCipher.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var40 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        class186 var51 = var3.switches[var8[var24]];
                                                                                                                                                                        class198 var50 = (class198)var51.method3493((long)class83.intStack[--class165.intStackSize]);
                                                                                                                                                                        if(var50 != null) {
                                                                                                                                                                           var24 += var50.field2496;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     Tile.chatMessages.method1766(var8[var24], class83.intStack[--class165.intStackSize]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class83.intStack[++class165.intStackSize - 1] = Tile.chatMessages.method1767(var8[var24]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var13 = var8[var24];
                                                                                                                                                               Script var49 = Projectile.method1735(var13);
                                                                                                                                                               int[] var41 = new int[var49.localIntCount];
                                                                                                                                                               String[] var69 = new String[var49.localStringCount];

                                                                                                                                                               for(var17 = 0; var17 < var49.intStackCount; ++var17) {
                                                                                                                                                                  var41[var17] = class83.intStack[class165.intStackSize - var49.intStackCount + var17];
                                                                                                                                                               }

                                                                                                                                                               for(var17 = 0; var17 < var49.stringStackCount; ++var17) {
                                                                                                                                                                  var69[var17] = class83.scriptStringStack[ISAACCipher.scriptStringStackSize - var49.stringStackCount + var17];
                                                                                                                                                               }

                                                                                                                                                               class165.intStackSize -= var49.intStackCount;
                                                                                                                                                               ISAACCipher.scriptStringStackSize -= var49.stringStackCount;
                                                                                                                                                               ScriptState var70 = new ScriptState();
                                                                                                                                                               var70.invokedFromScript = var3;
                                                                                                                                                               var70.invokedFromPc = var24;
                                                                                                                                                               var70.savedLocalInts = class83.scriptLocalInts;
                                                                                                                                                               var70.savedLocalStrings = class83.scriptLocalStrings;
                                                                                                                                                               class83.scriptStack[++class83.scriptStackCount - 1] = var70;
                                                                                                                                                               var3 = var49;
                                                                                                                                                               var7 = var49.instructions;
                                                                                                                                                               var8 = var49.intOperands;
                                                                                                                                                               var24 = -1;
                                                                                                                                                               class83.scriptLocalInts = var41;
                                                                                                                                                               class83.scriptLocalStrings = var69;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --ISAACCipher.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --class165.intStackSize;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var13 = var8[var24];
                                                                                                                                                      ISAACCipher.scriptStringStackSize -= var13;
                                                                                                                                                      String var26 = class265.method4872(class83.scriptStringStack, ISAACCipher.scriptStringStackSize, var13);
                                                                                                                                                      class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var26;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class83.scriptLocalStrings[var8[var24]] = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = class83.scriptLocalStrings[var8[var24]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class83.scriptLocalInts[var8[var24]] = class83.intStack[--class165.intStackSize];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class83.intStack[++class165.intStackSize - 1] = class83.scriptLocalInts[var8[var24]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       class165.intStackSize -= 2;
                                                                                                                                       if(class83.intStack[class165.intStackSize] >= class83.intStack[class165.intStackSize + 1]) {
                                                                                                                                          var24 += var8[var24];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    class165.intStackSize -= 2;
                                                                                                                                    if(class83.intStack[class165.intStackSize] <= class83.intStack[class165.intStackSize + 1]) {
                                                                                                                                       var24 += var8[var24];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var13 = var8[var24];
                                                                                                                                 var14 = class83.intStack[--class165.intStackSize];
                                                                                                                                 Varbit var15 = XGrandExchangeOffer.method122(var13);
                                                                                                                                 var16 = var15.configId;
                                                                                                                                 var17 = var15.leastSignificantBit;
                                                                                                                                 var18 = var15.mostSignificantBit;
                                                                                                                                 var19 = class211.field2615[var18 - var17];
                                                                                                                                 if(var14 < 0 || var14 > var19) {
                                                                                                                                    var14 = 0;
                                                                                                                                 }

                                                                                                                                 var19 <<= var17;
                                                                                                                                 class211.widgetSettings[var16] = class211.widgetSettings[var16] & ~var19 | var14 << var17 & var19;
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var13 = var8[var24];
                                                                                                                              class83.intStack[++class165.intStackSize - 1] = class205.method3843(var13);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class83.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var48 = class83.scriptStack[--class83.scriptStackCount];
                                                                                                                           var3 = var48.invokedFromScript;
                                                                                                                           var7 = var3.instructions;
                                                                                                                           var8 = var3.intOperands;
                                                                                                                           var24 = var48.invokedFromPc;
                                                                                                                           class83.scriptLocalInts = var48.savedLocalInts;
                                                                                                                           class83.scriptLocalStrings = var48.savedLocalStrings;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class165.intStackSize -= 2;
                                                                                                                        if(class83.intStack[class165.intStackSize] > class83.intStack[class165.intStackSize + 1]) {
                                                                                                                           var24 += var8[var24];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class165.intStackSize -= 2;
                                                                                                                     if(class83.intStack[class165.intStackSize] < class83.intStack[class165.intStackSize + 1]) {
                                                                                                                        var24 += var8[var24];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  class165.intStackSize -= 2;
                                                                                                                  if(class83.intStack[class165.intStackSize] == class83.intStack[class165.intStackSize + 1]) {
                                                                                                                     var24 += var8[var24];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               class165.intStackSize -= 2;
                                                                                                               if(class83.intStack[class165.intStackSize + 1] != class83.intStack[class165.intStackSize]) {
                                                                                                                  var24 += var8[var24];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var24 += var8[var24];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var3.stringOperands[var24];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var13 = var8[var24];
                                                                                                      class211.widgetSettings[var13] = class83.intStack[--class165.intStackSize];
                                                                                                      class77.method1483(var13);
                                                                                                   }
                                                                                                } else {
                                                                                                   var13 = var8[var24];
                                                                                                   class83.intStack[++class165.intStackSize - 1] = class211.widgetSettings[var13];
                                                                                                }
                                                                                             } else {
                                                                                                class83.intStack[++class165.intStackSize - 1] = var8[var24];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var42;
                                                                                             if(var3.intOperands[var24] == 1) {
                                                                                                var42 = true;
                                                                                             } else {
                                                                                                var42 = false;
                                                                                             }

                                                                                             if(var40 < 1000) {
                                                                                                var14 = class31.method285(var40, var3, var42);
                                                                                             } else if(var40 < 1100) {
                                                                                                var14 = class66.method1063(var40, var3, var42);
                                                                                             } else if(var40 < 1200) {
                                                                                                var14 = class10.method67(var40, var3, var42);
                                                                                             } else if(var40 < 1300) {
                                                                                                var14 = class10.method63(var40, var3, var42);
                                                                                             } else if(var40 < 1400) {
                                                                                                var14 = class51.method745(var40, var3, var42);
                                                                                             } else if(var40 < 1500) {
                                                                                                var14 = class28.method236(var40, var3, var42);
                                                                                             } else {
                                                                                                byte var29;
                                                                                                Widget var30;
                                                                                                if(var40 < 1600) {
                                                                                                   var30 = var42?class278.field3737:class37.field515;
                                                                                                   if(var40 == 1500) {
                                                                                                      class83.intStack[++class165.intStackSize - 1] = var30.relativeX;
                                                                                                      var29 = 1;
                                                                                                   } else if(var40 == 1501) {
                                                                                                      class83.intStack[++class165.intStackSize - 1] = var30.relativeY;
                                                                                                      var29 = 1;
                                                                                                   } else if(var40 == 1502) {
                                                                                                      class83.intStack[++class165.intStackSize - 1] = var30.width;
                                                                                                      var29 = 1;
                                                                                                   } else if(var40 == 1503) {
                                                                                                      class83.intStack[++class165.intStackSize - 1] = var30.height;
                                                                                                      var29 = 1;
                                                                                                   } else if(var40 == 1504) {
                                                                                                      class83.intStack[++class165.intStackSize - 1] = var30.isHidden?1:0;
                                                                                                      var29 = 1;
                                                                                                   } else if(var40 == 1505) {
                                                                                                      class83.intStack[++class165.intStackSize - 1] = var30.parentId;
                                                                                                      var29 = 1;
                                                                                                   } else {
                                                                                                      var29 = 2;
                                                                                                   }

                                                                                                   var14 = var29;
                                                                                                } else if(var40 < 1700) {
                                                                                                   var14 = FaceNormal.method2877(var40, var3, var42);
                                                                                                } else if(var40 < 1800) {
                                                                                                   var30 = var42?class278.field3737:class37.field515;
                                                                                                   if(var40 == 1700) {
                                                                                                      class83.intStack[++class165.intStackSize - 1] = var30.itemId;
                                                                                                      var29 = 1;
                                                                                                   } else if(var40 == 1701) {
                                                                                                      if(var30.itemId != -1) {
                                                                                                         class83.intStack[++class165.intStackSize - 1] = var30.itemQuantity;
                                                                                                      } else {
                                                                                                         class83.intStack[++class165.intStackSize - 1] = 0;
                                                                                                      }

                                                                                                      var29 = 1;
                                                                                                   } else if(var40 == 1702) {
                                                                                                      class83.intStack[++class165.intStackSize - 1] = var30.index;
                                                                                                      var29 = 1;
                                                                                                   } else {
                                                                                                      var29 = 2;
                                                                                                   }

                                                                                                   var14 = var29;
                                                                                                } else {
                                                                                                   Widget var27;
                                                                                                   if(var40 < 1900) {
                                                                                                      var27 = var42?class278.field3737:class37.field515;
                                                                                                      if(var40 == 1800) {
                                                                                                         class83.intStack[++class165.intStackSize - 1] = GameEngine.method844(class251.method4472(var27));
                                                                                                         var29 = 1;
                                                                                                      } else if(var40 != 1801) {
                                                                                                         if(var40 == 1802) {
                                                                                                            if(var27.name == null) {
                                                                                                               class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = "";
                                                                                                            } else {
                                                                                                               class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var27.name;
                                                                                                            }

                                                                                                            var29 = 1;
                                                                                                         } else {
                                                                                                            var29 = 2;
                                                                                                         }
                                                                                                      } else {
                                                                                                         var17 = class83.intStack[--class165.intStackSize];
                                                                                                         --var17;
                                                                                                         if(var27.actions != null && var17 < var27.actions.length && var27.actions[var17] != null) {
                                                                                                            class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var27.actions[var17];
                                                                                                         } else {
                                                                                                            class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = "";
                                                                                                         }

                                                                                                         var29 = 1;
                                                                                                      }

                                                                                                      var14 = var29;
                                                                                                   } else if(var40 < 2000) {
                                                                                                      var14 = Projectile.method1729(var40, var3, var42);
                                                                                                   } else if(var40 < 2100) {
                                                                                                      var14 = class66.method1063(var40, var3, var42);
                                                                                                   } else if(var40 < 2200) {
                                                                                                      var14 = class10.method67(var40, var3, var42);
                                                                                                   } else if(var40 < 2300) {
                                                                                                      var14 = class10.method63(var40, var3, var42);
                                                                                                   } else if(var40 < 2400) {
                                                                                                      var14 = class51.method745(var40, var3, var42);
                                                                                                   } else if(var40 < 2500) {
                                                                                                      var14 = class28.method236(var40, var3, var42);
                                                                                                   } else if(var40 < 2600) {
                                                                                                      var14 = class47.method689(var40, var3, var42);
                                                                                                   } else if(var40 < 2700) {
                                                                                                      var14 = class243.method4340(var40, var3, var42);
                                                                                                   } else if(var40 < 2800) {
                                                                                                      if(var40 == 2700) {
                                                                                                         var27 = class177.method3390(class83.intStack[--class165.intStackSize]);
                                                                                                         class83.intStack[++class165.intStackSize - 1] = var27.itemId;
                                                                                                         var29 = 1;
                                                                                                      } else if(var40 == 2701) {
                                                                                                         var27 = class177.method3390(class83.intStack[--class165.intStackSize]);
                                                                                                         if(var27.itemId != -1) {
                                                                                                            class83.intStack[++class165.intStackSize - 1] = var27.itemQuantity;
                                                                                                         } else {
                                                                                                            class83.intStack[++class165.intStackSize - 1] = 0;
                                                                                                         }

                                                                                                         var29 = 1;
                                                                                                      } else if(var40 == 2702) {
                                                                                                         var16 = class83.intStack[--class165.intStackSize];
                                                                                                         WidgetNode var28 = (WidgetNode)Client.componentTable.method3545((long)var16);
                                                                                                         if(var28 != null) {
                                                                                                            class83.intStack[++class165.intStackSize - 1] = 1;
                                                                                                         } else {
                                                                                                            class83.intStack[++class165.intStackSize - 1] = 0;
                                                                                                         }

                                                                                                         var29 = 1;
                                                                                                      } else if(var40 == 2706) {
                                                                                                         class83.intStack[++class165.intStackSize - 1] = Client.widgetRoot;
                                                                                                         var29 = 1;
                                                                                                      } else {
                                                                                                         var29 = 2;
                                                                                                      }

                                                                                                      var14 = var29;
                                                                                                   } else if(var40 < 2900) {
                                                                                                      var14 = RSCanvas.method771(var40, var3, var42);
                                                                                                   } else if(var40 < 3000) {
                                                                                                      var14 = Projectile.method1729(var40, var3, var42);
                                                                                                   } else if(var40 < 3200) {
                                                                                                      var14 = class50.method742(var40, var3, var42);
                                                                                                   } else if(var40 < 3300) {
                                                                                                      var14 = class61.method1021(var40, var3, var42);
                                                                                                   } else {
                                                                                                      int var20;
                                                                                                      if(var40 < 3400) {
                                                                                                         if(var40 == 3300) {
                                                                                                            class83.intStack[++class165.intStackSize - 1] = Client.gameCycle;
                                                                                                            var29 = 1;
                                                                                                         } else if(var40 == 3301) {
                                                                                                            class165.intStackSize -= 2;
                                                                                                            var16 = class83.intStack[class165.intStackSize];
                                                                                                            var17 = class83.intStack[class165.intStackSize + 1];
                                                                                                            class83.intStack[++class165.intStackSize - 1] = class12.method80(var16, var17);
                                                                                                            var29 = 1;
                                                                                                         } else {
                                                                                                            XItemContainer var21;
                                                                                                            int[] var31;
                                                                                                            if(var40 == 3302) {
                                                                                                               class165.intStackSize -= 2;
                                                                                                               var16 = class83.intStack[class165.intStackSize];
                                                                                                               var17 = class83.intStack[class165.intStackSize + 1];
                                                                                                               var31 = class83.intStack;
                                                                                                               var19 = ++class165.intStackSize - 1;
                                                                                                               var21 = (XItemContainer)XItemContainer.itemContainers.method3545((long)var16);
                                                                                                               if(var21 == null) {
                                                                                                                  var20 = 0;
                                                                                                               } else if(var17 >= 0 && var17 < var21.stackSizes.length) {
                                                                                                                  var20 = var21.stackSizes[var17];
                                                                                                               } else {
                                                                                                                  var20 = 0;
                                                                                                               }

                                                                                                               var31[var19] = var20;
                                                                                                               var29 = 1;
                                                                                                            } else if(var40 == 3303) {
                                                                                                               class165.intStackSize -= 2;
                                                                                                               var16 = class83.intStack[class165.intStackSize];
                                                                                                               var17 = class83.intStack[class165.intStackSize + 1];
                                                                                                               class83.intStack[++class165.intStackSize - 1] = class11.method72(var16, var17);
                                                                                                               var29 = 1;
                                                                                                            } else if(var40 == 3304) {
                                                                                                               var16 = class83.intStack[--class165.intStackSize];
                                                                                                               class83.intStack[++class165.intStackSize - 1] = CombatInfoListHolder.method1664(var16).field3285;
                                                                                                               var29 = 1;
                                                                                                            } else if(var40 == 3305) {
                                                                                                               var16 = class83.intStack[--class165.intStackSize];
                                                                                                               class83.intStack[++class165.intStackSize - 1] = Client.boostedSkillLevels[var16];
                                                                                                               var29 = 1;
                                                                                                            } else if(var40 == 3306) {
                                                                                                               var16 = class83.intStack[--class165.intStackSize];
                                                                                                               class83.intStack[++class165.intStackSize - 1] = Client.realSkillLevels[var16];
                                                                                                               var29 = 1;
                                                                                                            } else if(var40 == 3307) {
                                                                                                               var16 = class83.intStack[--class165.intStackSize];
                                                                                                               class83.intStack[++class165.intStackSize - 1] = Client.skillExperiences[var16];
                                                                                                               var29 = 1;
                                                                                                            } else if(var40 == 3308) {
                                                                                                               var16 = class92.plane;
                                                                                                               var17 = (class168.localPlayer.x >> 7) + class61.baseX;
                                                                                                               var18 = class23.baseY + (class168.localPlayer.y >> 7);
                                                                                                               class83.intStack[++class165.intStackSize - 1] = var18 + (var16 << 28) + (var17 << 14);
                                                                                                               var29 = 1;
                                                                                                            } else if(var40 == 3309) {
                                                                                                               var16 = class83.intStack[--class165.intStackSize];
                                                                                                               class83.intStack[++class165.intStackSize - 1] = var16 >> 14 & 16383;
                                                                                                               var29 = 1;
                                                                                                            } else if(var40 == 3310) {
                                                                                                               var16 = class83.intStack[--class165.intStackSize];
                                                                                                               class83.intStack[++class165.intStackSize - 1] = var16 >> 28;
                                                                                                               var29 = 1;
                                                                                                            } else if(var40 == 3311) {
                                                                                                               var16 = class83.intStack[--class165.intStackSize];
                                                                                                               class83.intStack[++class165.intStackSize - 1] = var16 & 16383;
                                                                                                               var29 = 1;
                                                                                                            } else if(var40 == 3312) {
                                                                                                               class83.intStack[++class165.intStackSize - 1] = Client.isMembers?1:0;
                                                                                                               var29 = 1;
                                                                                                            } else if(var40 == 3313) {
                                                                                                               class165.intStackSize -= 2;
                                                                                                               var16 = class83.intStack[class165.intStackSize] + '耀';
                                                                                                               var17 = class83.intStack[class165.intStackSize + 1];
                                                                                                               class83.intStack[++class165.intStackSize - 1] = class12.method80(var16, var17);
                                                                                                               var29 = 1;
                                                                                                            } else if(var40 != 3314) {
                                                                                                               if(var40 == 3315) {
                                                                                                                  class165.intStackSize -= 2;
                                                                                                                  var16 = class83.intStack[class165.intStackSize] + '耀';
                                                                                                                  var17 = class83.intStack[class165.intStackSize + 1];
                                                                                                                  class83.intStack[++class165.intStackSize - 1] = class11.method72(var16, var17);
                                                                                                                  var29 = 1;
                                                                                                               } else if(var40 == 3316) {
                                                                                                                  if(Client.rights >= 2) {
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = Client.rights;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var29 = 1;
                                                                                                               } else if(var40 == 3317) {
                                                                                                                  class83.intStack[++class165.intStackSize - 1] = Client.field1081;
                                                                                                                  var29 = 1;
                                                                                                               } else if(var40 == 3318) {
                                                                                                                  class83.intStack[++class165.intStackSize - 1] = Client.world;
                                                                                                                  var29 = 1;
                                                                                                               } else if(var40 == 3321) {
                                                                                                                  class83.intStack[++class165.intStackSize - 1] = Client.energy;
                                                                                                                  var29 = 1;
                                                                                                               } else if(var40 == 3322) {
                                                                                                                  class83.intStack[++class165.intStackSize - 1] = Client.weight;
                                                                                                                  var29 = 1;
                                                                                                               } else if(var40 == 3323) {
                                                                                                                  if(Client.field1040) {
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = 1;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var29 = 1;
                                                                                                               } else if(var40 == 3324) {
                                                                                                                  class83.intStack[++class165.intStackSize - 1] = Client.flags;
                                                                                                                  var29 = 1;
                                                                                                               } else if(var40 == 3325) {
                                                                                                                  class165.intStackSize -= 4;
                                                                                                                  var16 = class83.intStack[class165.intStackSize];
                                                                                                                  var17 = class83.intStack[class165.intStackSize + 1];
                                                                                                                  var18 = class83.intStack[class165.intStackSize + 2];
                                                                                                                  var19 = class83.intStack[class165.intStackSize + 3];
                                                                                                                  var16 += var17 << 14;
                                                                                                                  var16 += var18 << 28;
                                                                                                                  var16 += var19;
                                                                                                                  class83.intStack[++class165.intStackSize - 1] = var16;
                                                                                                                  var29 = 1;
                                                                                                               } else {
                                                                                                                  var29 = 2;
                                                                                                               }
                                                                                                            } else {
                                                                                                               class165.intStackSize -= 2;
                                                                                                               var16 = class83.intStack[class165.intStackSize] + '耀';
                                                                                                               var17 = class83.intStack[class165.intStackSize + 1];
                                                                                                               var31 = class83.intStack;
                                                                                                               var19 = ++class165.intStackSize - 1;
                                                                                                               var21 = (XItemContainer)XItemContainer.itemContainers.method3545((long)var16);
                                                                                                               if(var21 == null) {
                                                                                                                  var20 = 0;
                                                                                                               } else if(var17 >= 0 && var17 < var21.stackSizes.length) {
                                                                                                                  var20 = var21.stackSizes[var17];
                                                                                                               } else {
                                                                                                                  var20 = 0;
                                                                                                               }

                                                                                                               var31[var19] = var20;
                                                                                                               var29 = 1;
                                                                                                            }
                                                                                                         }

                                                                                                         var14 = var29;
                                                                                                      } else {
                                                                                                         int var33;
                                                                                                         if(var40 < 3500) {
                                                                                                            if(var40 == 3400) {
                                                                                                               class165.intStackSize -= 2;
                                                                                                               var16 = class83.intStack[class165.intStackSize];
                                                                                                               var17 = class83.intStack[class165.intStackSize + 1];
                                                                                                               Enum var61 = class14.method104(var16);
                                                                                                               if(var61.valType != 115) {
                                                                                                                  ;
                                                                                                               }

                                                                                                               for(var19 = 0; var19 < var61.size; ++var19) {
                                                                                                                  if(var61.keys[var19] == var17) {
                                                                                                                     class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var61.stringVals[var19];
                                                                                                                     var61 = null;
                                                                                                                     break;
                                                                                                                  }
                                                                                                               }

                                                                                                               if(var61 != null) {
                                                                                                                  class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var61.defaultString;
                                                                                                               }

                                                                                                               var29 = 1;
                                                                                                            } else if(var40 != 3408) {
                                                                                                               var29 = 2;
                                                                                                            } else {
                                                                                                               class165.intStackSize -= 4;
                                                                                                               var16 = class83.intStack[class165.intStackSize];
                                                                                                               var17 = class83.intStack[class165.intStackSize + 1];
                                                                                                               var18 = class83.intStack[class165.intStackSize + 2];
                                                                                                               var19 = class83.intStack[class165.intStackSize + 3];
                                                                                                               Enum var32 = class14.method104(var18);
                                                                                                               if(var32.keyType == var16 && var32.valType == var17) {
                                                                                                                  for(var33 = 0; var33 < var32.size; ++var33) {
                                                                                                                     if(var19 == var32.keys[var33]) {
                                                                                                                        if(var17 == 115) {
                                                                                                                           class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var32.stringVals[var33];
                                                                                                                        } else {
                                                                                                                           class83.intStack[++class165.intStackSize - 1] = var32.intVals[var33];
                                                                                                                        }

                                                                                                                        var32 = null;
                                                                                                                        break;
                                                                                                                     }
                                                                                                                  }

                                                                                                                  if(var32 != null) {
                                                                                                                     if(var17 == 115) {
                                                                                                                        class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var32.defaultString;
                                                                                                                     } else {
                                                                                                                        class83.intStack[++class165.intStackSize - 1] = var32.defaultInt;
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var29 = 1;
                                                                                                               } else {
                                                                                                                  if(var17 == 115) {
                                                                                                                     class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = "null";
                                                                                                                  } else {
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var29 = 1;
                                                                                                               }
                                                                                                            }

                                                                                                            var14 = var29;
                                                                                                         } else {
                                                                                                            String var52;
                                                                                                            if(var40 < 3700) {
                                                                                                               if(var40 == 3600) {
                                                                                                                  if(Client.field1183 == 0) {
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = -2;
                                                                                                                  } else if(Client.field1183 == 1) {
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = -1;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = Client.friendCount;
                                                                                                                  }

                                                                                                                  var29 = 1;
                                                                                                               } else if(var40 == 3601) {
                                                                                                                  var16 = class83.intStack[--class165.intStackSize];
                                                                                                                  if(Client.field1183 == 2 && var16 < Client.friendCount) {
                                                                                                                     class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = Client.friends[var16].name;
                                                                                                                     class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = Client.friends[var16].previousName;
                                                                                                                  } else {
                                                                                                                     class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = "";
                                                                                                                     class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = "";
                                                                                                                  }

                                                                                                                  var29 = 1;
                                                                                                               } else if(var40 == 3602) {
                                                                                                                  var16 = class83.intStack[--class165.intStackSize];
                                                                                                                  if(Client.field1183 == 2 && var16 < Client.friendCount) {
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = Client.friends[var16].world;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var29 = 1;
                                                                                                               } else if(var40 == 3603) {
                                                                                                                  var16 = class83.intStack[--class165.intStackSize];
                                                                                                                  if(Client.field1183 == 2 && var16 < Client.friendCount) {
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = Client.friends[var16].rank;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var29 = 1;
                                                                                                               } else if(var40 == 3604) {
                                                                                                                  var52 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
                                                                                                                  var17 = class83.intStack[--class165.intStackSize];
                                                                                                                  class15.method111(var52, var17);
                                                                                                                  var29 = 1;
                                                                                                               } else if(var40 == 3605) {
                                                                                                                  var52 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
                                                                                                                  if(var52 != null) {
                                                                                                                     if((Client.friendCount < 200 || Client.field1146 == 1) && Client.friendCount < 400) {
                                                                                                                        String var54 = CollisionData.method3023(var52, class13.field281);
                                                                                                                        if(var54 != null) {
                                                                                                                           var18 = 0;

                                                                                                                           label1576:
                                                                                                                           while(true) {
                                                                                                                              String var43;
                                                                                                                              String var67;
                                                                                                                              if(var18 >= Client.friendCount) {
                                                                                                                                 for(var18 = 0; var18 < Client.ignoreCount; ++var18) {
                                                                                                                                    Ignore var58 = Client.ignores[var18];
                                                                                                                                    var67 = CollisionData.method3023(var58.name, class13.field281);
                                                                                                                                    if(var67 != null && var67.equals(var54)) {
                                                                                                                                       class98.sendGameMessage(30, "", "Please remove " + var52 + " from your ignore list first");
                                                                                                                                       break label1576;
                                                                                                                                    }

                                                                                                                                    if(var58.previousName != null) {
                                                                                                                                       var43 = CollisionData.method3023(var58.previousName, class13.field281);
                                                                                                                                       if(var43 != null && var43.equals(var54)) {
                                                                                                                                          class98.sendGameMessage(30, "", "Please remove " + var52 + " from your ignore list first");
                                                                                                                                          break label1576;
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 }

                                                                                                                                 if(CollisionData.method3023(class168.localPlayer.name, class13.field281).equals(var54)) {
                                                                                                                                    class98.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
                                                                                                                                 } else {
                                                                                                                                    Client.secretPacketBuffer1.putOpcode(212);
                                                                                                                                    Client.secretPacketBuffer1.putByte(Script.method1836(var52));
                                                                                                                                    Client.secretPacketBuffer1.method3150(var52);
                                                                                                                                 }
                                                                                                                                 break;
                                                                                                                              }

                                                                                                                              Friend var57 = Client.friends[var18];
                                                                                                                              var67 = CollisionData.method3023(var57.name, class13.field281);
                                                                                                                              if(var67 != null && var67.equals(var54)) {
                                                                                                                                 class98.sendGameMessage(30, "", var52 + " is already on your friend list");
                                                                                                                                 break;
                                                                                                                              }

                                                                                                                              if(var57.previousName != null) {
                                                                                                                                 var43 = CollisionData.method3023(var57.previousName, class13.field281);
                                                                                                                                 if(var43 != null && var43.equals(var54)) {
                                                                                                                                    class98.sendGameMessage(30, "", var52 + " is already on your friend list");
                                                                                                                                    break;
                                                                                                                                 }
                                                                                                                              }

                                                                                                                              ++var18;
                                                                                                                           }
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class98.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var29 = 1;
                                                                                                               } else if(var40 == 3606) {
                                                                                                                  var52 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
                                                                                                                  class244.method4354(var52);
                                                                                                                  var29 = 1;
                                                                                                               } else if(var40 == 3607) {
                                                                                                                  var52 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
                                                                                                                  Item.method1740(var52, false);
                                                                                                                  var29 = 1;
                                                                                                               } else if(var40 == 3608) {
                                                                                                                  var52 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
                                                                                                                  class1.method1(var52);
                                                                                                                  var29 = 1;
                                                                                                               } else if(var40 == 3609) {
                                                                                                                  var52 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
                                                                                                                  class230[] var53 = new class230[]{class230.field3181, class230.field3173, class230.field3171, class230.field3175, class230.field3172, class230.field3180};
                                                                                                                  class230[] var62 = var53;

                                                                                                                  for(var19 = 0; var19 < var62.length; ++var19) {
                                                                                                                     class230 var66 = var62[var19];
                                                                                                                     if(var66.field3174 != -1 && var52.startsWith(class64.method1058(var66.field3174))) {
                                                                                                                        var52 = var52.substring(Integer.toString(var66.field3174).length() + 6);
                                                                                                                        break;
                                                                                                                     }
                                                                                                                  }

                                                                                                                  class83.intStack[++class165.intStackSize - 1] = class7.method29(var52, false)?1:0;
                                                                                                                  var29 = 1;
                                                                                                               } else if(var40 == 3611) {
                                                                                                                  if(Client.clanChatOwner != null) {
                                                                                                                     class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = class91.method1702(Client.clanChatOwner);
                                                                                                                  } else {
                                                                                                                     class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = "";
                                                                                                                  }

                                                                                                                  var29 = 1;
                                                                                                               } else if(var40 == 3612) {
                                                                                                                  if(Client.clanChatOwner != null) {
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = class24.clanChatCount;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var29 = 1;
                                                                                                               } else if(var40 == 3613) {
                                                                                                                  var16 = class83.intStack[--class165.intStackSize];
                                                                                                                  if(Client.clanChatOwner != null && var16 < class24.clanChatCount) {
                                                                                                                     class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = class2.clanMembers[var16].username;
                                                                                                                  } else {
                                                                                                                     class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = "";
                                                                                                                  }

                                                                                                                  var29 = 1;
                                                                                                               } else if(var40 == 3614) {
                                                                                                                  var16 = class83.intStack[--class165.intStackSize];
                                                                                                                  if(Client.clanChatOwner != null && var16 < class24.clanChatCount) {
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = class2.clanMembers[var16].world;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var29 = 1;
                                                                                                               } else if(var40 == 3615) {
                                                                                                                  var16 = class83.intStack[--class165.intStackSize];
                                                                                                                  if(Client.clanChatOwner != null && var16 < class24.clanChatCount) {
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = class2.clanMembers[var16].rank;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var29 = 1;
                                                                                                               } else if(var40 == 3616) {
                                                                                                                  class83.intStack[++class165.intStackSize - 1] = Client.field1143;
                                                                                                                  var29 = 1;
                                                                                                               } else if(var40 == 3617) {
                                                                                                                  var52 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
                                                                                                                  if(class2.clanMembers != null) {
                                                                                                                     Client.secretPacketBuffer1.putOpcode(127);
                                                                                                                     Client.secretPacketBuffer1.putByte(Script.method1836(var52));
                                                                                                                     Client.secretPacketBuffer1.method3150(var52);
                                                                                                                  }

                                                                                                                  var29 = 1;
                                                                                                               } else if(var40 == 3618) {
                                                                                                                  class83.intStack[++class165.intStackSize - 1] = class116.clanChatRank;
                                                                                                                  var29 = 1;
                                                                                                               } else if(var40 == 3619) {
                                                                                                                  var52 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
                                                                                                                  if(!var52.equals("")) {
                                                                                                                     Client.secretPacketBuffer1.putOpcode(163);
                                                                                                                     Client.secretPacketBuffer1.putByte(Script.method1836(var52));
                                                                                                                     Client.secretPacketBuffer1.method3150(var52);
                                                                                                                  }

                                                                                                                  var29 = 1;
                                                                                                               } else if(var40 == 3620) {
                                                                                                                  Friend.method1060();
                                                                                                                  var29 = 1;
                                                                                                               } else if(var40 == 3621) {
                                                                                                                  if(Client.field1183 == 0) {
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = -1;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = Client.ignoreCount;
                                                                                                                  }

                                                                                                                  var29 = 1;
                                                                                                               } else if(var40 == 3622) {
                                                                                                                  var16 = class83.intStack[--class165.intStackSize];
                                                                                                                  if(Client.field1183 != 0 && var16 < Client.ignoreCount) {
                                                                                                                     class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = Client.ignores[var16].name;
                                                                                                                     class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = Client.ignores[var16].previousName;
                                                                                                                  } else {
                                                                                                                     class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = "";
                                                                                                                     class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = "";
                                                                                                                  }

                                                                                                                  var29 = 1;
                                                                                                               } else if(var40 == 3623) {
                                                                                                                  var52 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
                                                                                                                  if(var52.startsWith(class64.method1058(0)) || var52.startsWith(class64.method1058(1))) {
                                                                                                                     var52 = var52.substring(7);
                                                                                                                  }

                                                                                                                  class83.intStack[++class165.intStackSize - 1] = class169.method3124(var52)?1:0;
                                                                                                                  var29 = 1;
                                                                                                               } else if(var40 != 3624) {
                                                                                                                  if(var40 == 3625) {
                                                                                                                     if(Client.clanChatName != null) {
                                                                                                                        class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = class91.method1702(Client.clanChatName);
                                                                                                                     } else {
                                                                                                                        class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = "";
                                                                                                                     }

                                                                                                                     var29 = 1;
                                                                                                                  } else {
                                                                                                                     var29 = 2;
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  var16 = class83.intStack[--class165.intStackSize];
                                                                                                                  if(class2.clanMembers != null && var16 < class24.clanChatCount && class2.clanMembers[var16].username.equalsIgnoreCase(class168.localPlayer.name)) {
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = 1;
                                                                                                                  } else {
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = 0;
                                                                                                                  }

                                                                                                                  var29 = 1;
                                                                                                               }

                                                                                                               var14 = var29;
                                                                                                            } else {
                                                                                                               boolean var45;
                                                                                                               if(var40 < 4000) {
                                                                                                                  if(var40 == 3903) {
                                                                                                                     var16 = class83.intStack[--class165.intStackSize];
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = Client.grandExchangeOffers[var16].method118();
                                                                                                                     var29 = 1;
                                                                                                                  } else if(var40 == 3904) {
                                                                                                                     var16 = class83.intStack[--class165.intStackSize];
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = Client.grandExchangeOffers[var16].itemId;
                                                                                                                     var29 = 1;
                                                                                                                  } else if(var40 == 3905) {
                                                                                                                     var16 = class83.intStack[--class165.intStackSize];
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = Client.grandExchangeOffers[var16].price;
                                                                                                                     var29 = 1;
                                                                                                                  } else if(var40 == 3906) {
                                                                                                                     var16 = class83.intStack[--class165.intStackSize];
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = Client.grandExchangeOffers[var16].totalQuantity;
                                                                                                                     var29 = 1;
                                                                                                                  } else if(var40 == 3907) {
                                                                                                                     var16 = class83.intStack[--class165.intStackSize];
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = Client.grandExchangeOffers[var16].quantitySold;
                                                                                                                     var29 = 1;
                                                                                                                  } else if(var40 == 3908) {
                                                                                                                     var16 = class83.intStack[--class165.intStackSize];
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = Client.grandExchangeOffers[var16].spent;
                                                                                                                     var29 = 1;
                                                                                                                  } else if(var40 == 3910) {
                                                                                                                     var16 = class83.intStack[--class165.intStackSize];
                                                                                                                     var17 = Client.grandExchangeOffers[var16].method121();
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = var17 == 0?1:0;
                                                                                                                     var29 = 1;
                                                                                                                  } else if(var40 == 3911) {
                                                                                                                     var16 = class83.intStack[--class165.intStackSize];
                                                                                                                     var17 = Client.grandExchangeOffers[var16].method121();
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = var17 == 2?1:0;
                                                                                                                     var29 = 1;
                                                                                                                  } else if(var40 == 3912) {
                                                                                                                     var16 = class83.intStack[--class165.intStackSize];
                                                                                                                     var17 = Client.grandExchangeOffers[var16].method121();
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = var17 == 5?1:0;
                                                                                                                     var29 = 1;
                                                                                                                  } else if(var40 == 3913) {
                                                                                                                     var16 = class83.intStack[--class165.intStackSize];
                                                                                                                     var17 = Client.grandExchangeOffers[var16].method121();
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = var17 == 1?1:0;
                                                                                                                     var29 = 1;
                                                                                                                  } else {
                                                                                                                     boolean var55;
                                                                                                                     if(var40 == 3914) {
                                                                                                                        var55 = class83.intStack[--class165.intStackSize] == 1;
                                                                                                                        if(class69.field834 != null) {
                                                                                                                           class69.field834.method85(class13.field280, var55);
                                                                                                                        }

                                                                                                                        var29 = 1;
                                                                                                                     } else if(var40 == 3915) {
                                                                                                                        var55 = class83.intStack[--class165.intStackSize] == 1;
                                                                                                                        if(class69.field834 != null) {
                                                                                                                           class69.field834.method85(class13.field279, var55);
                                                                                                                        }

                                                                                                                        var29 = 1;
                                                                                                                     } else if(var40 == 3916) {
                                                                                                                        class165.intStackSize -= 2;
                                                                                                                        var55 = class83.intStack[class165.intStackSize] == 1;
                                                                                                                        var45 = class83.intStack[class165.intStackSize + 1] == 1;
                                                                                                                        if(class69.field834 != null) {
                                                                                                                           class69.field834.method85(new class95(var45), var55);
                                                                                                                        }

                                                                                                                        var29 = 1;
                                                                                                                     } else if(var40 == 3917) {
                                                                                                                        var55 = class83.intStack[--class165.intStackSize] == 1;
                                                                                                                        if(class69.field834 != null) {
                                                                                                                           class69.field834.method85(class13.field278, var55);
                                                                                                                        }

                                                                                                                        var29 = 1;
                                                                                                                     } else if(var40 == 3918) {
                                                                                                                        var55 = class83.intStack[--class165.intStackSize] == 1;
                                                                                                                        if(class69.field834 != null) {
                                                                                                                           class69.field834.method85(class13.field283, var55);
                                                                                                                        }

                                                                                                                        var29 = 1;
                                                                                                                     } else if(var40 == 3919) {
                                                                                                                        class83.intStack[++class165.intStackSize - 1] = class69.field834 == null?0:class69.field834.field284.size();
                                                                                                                        var29 = 1;
                                                                                                                     } else {
                                                                                                                        class14 var56;
                                                                                                                        if(var40 == 3920) {
                                                                                                                           var16 = class83.intStack[--class165.intStackSize];
                                                                                                                           var56 = (class14)class69.field834.field284.get(var16);
                                                                                                                           class83.intStack[++class165.intStackSize - 1] = var56.field292;
                                                                                                                           var29 = 1;
                                                                                                                        } else if(var40 == 3921) {
                                                                                                                           var16 = class83.intStack[--class165.intStackSize];
                                                                                                                           var56 = (class14)class69.field834.field284.get(var16);
                                                                                                                           class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var56.method92();
                                                                                                                           var29 = 1;
                                                                                                                        } else if(var40 == 3922) {
                                                                                                                           var16 = class83.intStack[--class165.intStackSize];
                                                                                                                           var56 = (class14)class69.field834.field284.get(var16);
                                                                                                                           class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var56.method93();
                                                                                                                           var29 = 1;
                                                                                                                        } else if(var40 == 3923) {
                                                                                                                           var16 = class83.intStack[--class165.intStackSize];
                                                                                                                           var56 = (class14)class69.field834.field284.get(var16);
                                                                                                                           long var34 = class134.method2587() - TextureProvider.field1779 - var56.field287;
                                                                                                                           var20 = (int)(var34 / 3600000L);
                                                                                                                           var33 = (int)((var34 - (long)(var20 * 3600000)) / 60000L);
                                                                                                                           int var22 = (int)((var34 - (long)(var20 * 3600000) - (long)(var33 * '\uea60')) / 1000L);
                                                                                                                           String var23 = var20 + ":" + var33 / 10 + var33 % 10 + ":" + var22 / 10 + var22 % 10;
                                                                                                                           class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var23;
                                                                                                                           var29 = 1;
                                                                                                                        } else if(var40 == 3924) {
                                                                                                                           var16 = class83.intStack[--class165.intStackSize];
                                                                                                                           var56 = (class14)class69.field834.field284.get(var16);
                                                                                                                           class83.intStack[++class165.intStackSize - 1] = var56.field288.totalQuantity;
                                                                                                                           var29 = 1;
                                                                                                                        } else if(var40 == 3925) {
                                                                                                                           var16 = class83.intStack[--class165.intStackSize];
                                                                                                                           var56 = (class14)class69.field834.field284.get(var16);
                                                                                                                           class83.intStack[++class165.intStackSize - 1] = var56.field288.price;
                                                                                                                           var29 = 1;
                                                                                                                        } else if(var40 == 3926) {
                                                                                                                           var16 = class83.intStack[--class165.intStackSize];
                                                                                                                           var56 = (class14)class69.field834.field284.get(var16);
                                                                                                                           class83.intStack[++class165.intStackSize - 1] = var56.field288.itemId;
                                                                                                                           var29 = 1;
                                                                                                                        } else {
                                                                                                                           var29 = 2;
                                                                                                                        }
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var14 = var29;
                                                                                                               } else if(var40 < 4100) {
                                                                                                                  var14 = class83.method1624(var40, var3, var42);
                                                                                                               } else if(var40 < 4200) {
                                                                                                                  var14 = Actor.method1494(var40, var3, var42);
                                                                                                               } else if(var40 < 4300) {
                                                                                                                  if(var40 == 4200) {
                                                                                                                     var16 = class83.intStack[--class165.intStackSize];
                                                                                                                     class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = ItemComposition.getItemDefinition(var16).name;
                                                                                                                     var29 = 1;
                                                                                                                  } else {
                                                                                                                     ItemComposition var65;
                                                                                                                     if(var40 == 4201) {
                                                                                                                        class165.intStackSize -= 2;
                                                                                                                        var16 = class83.intStack[class165.intStackSize];
                                                                                                                        var17 = class83.intStack[class165.intStackSize + 1];
                                                                                                                        var65 = ItemComposition.getItemDefinition(var16);
                                                                                                                        if(var17 >= 1 && var17 <= 5 && var65.groundActions[var17 - 1] != null) {
                                                                                                                           class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var65.groundActions[var17 - 1];
                                                                                                                        } else {
                                                                                                                           class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = "";
                                                                                                                        }

                                                                                                                        var29 = 1;
                                                                                                                     } else if(var40 == 4202) {
                                                                                                                        class165.intStackSize -= 2;
                                                                                                                        var16 = class83.intStack[class165.intStackSize];
                                                                                                                        var17 = class83.intStack[class165.intStackSize + 1];
                                                                                                                        var65 = ItemComposition.getItemDefinition(var16);
                                                                                                                        if(var17 >= 1 && var17 <= 5 && var65.inventoryActions[var17 - 1] != null) {
                                                                                                                           class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var65.inventoryActions[var17 - 1];
                                                                                                                        } else {
                                                                                                                           class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = "";
                                                                                                                        }

                                                                                                                        var29 = 1;
                                                                                                                     } else if(var40 == 4203) {
                                                                                                                        var16 = class83.intStack[--class165.intStackSize];
                                                                                                                        class83.intStack[++class165.intStackSize - 1] = ItemComposition.getItemDefinition(var16).price;
                                                                                                                        var29 = 1;
                                                                                                                     } else if(var40 == 4204) {
                                                                                                                        var16 = class83.intStack[--class165.intStackSize];
                                                                                                                        class83.intStack[++class165.intStackSize - 1] = ItemComposition.getItemDefinition(var16).isStackable == 1?1:0;
                                                                                                                        var29 = 1;
                                                                                                                     } else {
                                                                                                                        ItemComposition var59;
                                                                                                                        if(var40 == 4205) {
                                                                                                                           var16 = class83.intStack[--class165.intStackSize];
                                                                                                                           var59 = ItemComposition.getItemDefinition(var16);
                                                                                                                           if(var59.notedTemplate == -1 && var59.note >= 0) {
                                                                                                                              class83.intStack[++class165.intStackSize - 1] = var59.note;
                                                                                                                           } else {
                                                                                                                              class83.intStack[++class165.intStackSize - 1] = var16;
                                                                                                                           }

                                                                                                                           var29 = 1;
                                                                                                                        } else if(var40 == 4206) {
                                                                                                                           var16 = class83.intStack[--class165.intStackSize];
                                                                                                                           var59 = ItemComposition.getItemDefinition(var16);
                                                                                                                           if(var59.notedTemplate >= 0 && var59.note >= 0) {
                                                                                                                              class83.intStack[++class165.intStackSize - 1] = var59.note;
                                                                                                                           } else {
                                                                                                                              class83.intStack[++class165.intStackSize - 1] = var16;
                                                                                                                           }

                                                                                                                           var29 = 1;
                                                                                                                        } else if(var40 == 4207) {
                                                                                                                           var16 = class83.intStack[--class165.intStackSize];
                                                                                                                           class83.intStack[++class165.intStackSize - 1] = ItemComposition.getItemDefinition(var16).isMembers?1:0;
                                                                                                                           var29 = 1;
                                                                                                                        } else if(var40 == 4208) {
                                                                                                                           var16 = class83.intStack[--class165.intStackSize];
                                                                                                                           var59 = ItemComposition.getItemDefinition(var16);
                                                                                                                           if(var59.field3543 == -1 && var59.field3549 >= 0) {
                                                                                                                              class83.intStack[++class165.intStackSize - 1] = var59.field3549;
                                                                                                                           } else {
                                                                                                                              class83.intStack[++class165.intStackSize - 1] = var16;
                                                                                                                           }

                                                                                                                           var29 = 1;
                                                                                                                        } else if(var40 == 4209) {
                                                                                                                           var16 = class83.intStack[--class165.intStackSize];
                                                                                                                           var59 = ItemComposition.getItemDefinition(var16);
                                                                                                                           if(var59.field3543 >= 0 && var59.field3549 >= 0) {
                                                                                                                              class83.intStack[++class165.intStackSize - 1] = var59.field3549;
                                                                                                                           } else {
                                                                                                                              class83.intStack[++class165.intStackSize - 1] = var16;
                                                                                                                           }

                                                                                                                           var29 = 1;
                                                                                                                        } else if(var40 == 4210) {
                                                                                                                           var52 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
                                                                                                                           var17 = class83.intStack[--class165.intStackSize];
                                                                                                                           class14.method99(var52, var17 == 1);
                                                                                                                           class83.intStack[++class165.intStackSize - 1] = class8.field244;
                                                                                                                           var29 = 1;
                                                                                                                        } else if(var40 != 4211) {
                                                                                                                           if(var40 == 4212) {
                                                                                                                              class109.field1637 = 0;
                                                                                                                              var29 = 1;
                                                                                                                           } else {
                                                                                                                              var29 = 2;
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class11.field269 != null && class109.field1637 < class8.field244) {
                                                                                                                              class83.intStack[++class165.intStackSize - 1] = class11.field269[++class109.field1637 - 1] & '\uffff';
                                                                                                                           } else {
                                                                                                                              class83.intStack[++class165.intStackSize - 1] = -1;
                                                                                                                           }

                                                                                                                           var29 = 1;
                                                                                                                        }
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var14 = var29;
                                                                                                               } else if(var40 < 5100) {
                                                                                                                  var14 = WorldMapType1.method280(var40, var3, var42);
                                                                                                               } else if(var40 < 5400) {
                                                                                                                  if(var40 == 5306) {
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = class140.method2868();
                                                                                                                     var29 = 1;
                                                                                                                  } else if(var40 == 5307) {
                                                                                                                     var16 = class83.intStack[--class165.intStackSize];
                                                                                                                     if(var16 == 1 || var16 == 2) {
                                                                                                                        Client.field946 = 0L;
                                                                                                                        if(var16 >= 2) {
                                                                                                                           Client.isResized = true;
                                                                                                                        } else {
                                                                                                                           Client.isResized = false;
                                                                                                                        }

                                                                                                                        if(class140.method2868() == 1) {
                                                                                                                           class46.field590.method831(765, 503);
                                                                                                                        } else {
                                                                                                                           class46.field590.method831(7680, 2160);
                                                                                                                        }

                                                                                                                        if(Client.gameState >= 25) {
                                                                                                                           class77.method1488();
                                                                                                                        }
                                                                                                                     }

                                                                                                                     var29 = 1;
                                                                                                                  } else if(var40 == 5308) {
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = class66.field801.field1317;
                                                                                                                     var29 = 1;
                                                                                                                  } else if(var40 != 5309) {
                                                                                                                     var29 = 2;
                                                                                                                  } else {
                                                                                                                     var16 = class83.intStack[--class165.intStackSize];
                                                                                                                     if(var16 == 1 || var16 == 2) {
                                                                                                                        class66.field801.field1317 = var16;
                                                                                                                        WorldMapType3.method232();
                                                                                                                     }

                                                                                                                     var29 = 1;
                                                                                                                  }

                                                                                                                  var14 = var29;
                                                                                                               } else if(var40 < 5600) {
                                                                                                                  if(var40 == 5504) {
                                                                                                                     class165.intStackSize -= 2;
                                                                                                                     var19 = class83.intStack[class165.intStackSize];
                                                                                                                     var20 = class83.intStack[class165.intStackSize + 1];
                                                                                                                     if(!Client.field987) {
                                                                                                                        Client.field1107 = var19;
                                                                                                                        Client.mapAngle = var20;
                                                                                                                     }

                                                                                                                     var29 = 1;
                                                                                                                  } else if(var40 == 5505) {
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = Client.field1107;
                                                                                                                     var29 = 1;
                                                                                                                  } else if(var40 == 5506) {
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = Client.mapAngle;
                                                                                                                     var29 = 1;
                                                                                                                  } else if(var40 == 5530) {
                                                                                                                     var19 = class83.intStack[--class165.intStackSize];
                                                                                                                     if(var19 < 0) {
                                                                                                                        var19 = 0;
                                                                                                                     }

                                                                                                                     Client.field1004 = var19;
                                                                                                                     var29 = 1;
                                                                                                                  } else if(var40 == 5531) {
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = Client.field1004;
                                                                                                                     var29 = 1;
                                                                                                                  } else {
                                                                                                                     var29 = 2;
                                                                                                                  }

                                                                                                                  var14 = var29;
                                                                                                               } else if(var40 < 5700) {
                                                                                                                  var14 = GraphicsObject.method1656(var40, var3, var42);
                                                                                                               } else if(var40 < 6300) {
                                                                                                                  var14 = class90.method1697(var40, var3, var42);
                                                                                                               } else if(var40 < 6600) {
                                                                                                                  if(var40 == 6500) {
                                                                                                                     class83.intStack[++class165.intStackSize - 1] = class40.loadWorlds()?1:0;
                                                                                                                     var29 = 1;
                                                                                                                  } else {
                                                                                                                     World var63;
                                                                                                                     if(var40 == 6501) {
                                                                                                                        var63 = class23.method193();
                                                                                                                        if(var63 != null) {
                                                                                                                           class83.intStack[++class165.intStackSize - 1] = var63.id;
                                                                                                                           class83.intStack[++class165.intStackSize - 1] = var63.mask;
                                                                                                                           class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var63.activity;
                                                                                                                           class83.intStack[++class165.intStackSize - 1] = var63.location;
                                                                                                                           class83.intStack[++class165.intStackSize - 1] = var63.playerCount;
                                                                                                                           class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var63.address;
                                                                                                                        } else {
                                                                                                                           class83.intStack[++class165.intStackSize - 1] = -1;
                                                                                                                           class83.intStack[++class165.intStackSize - 1] = 0;
                                                                                                                           class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = "";
                                                                                                                           class83.intStack[++class165.intStackSize - 1] = 0;
                                                                                                                           class83.intStack[++class165.intStackSize - 1] = 0;
                                                                                                                           class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = "";
                                                                                                                        }

                                                                                                                        var29 = 1;
                                                                                                                     } else if(var40 == 6502) {
                                                                                                                        if(World.field1311 < World.field1297) {
                                                                                                                           var63 = World.worldList[++World.field1311 - 1];
                                                                                                                        } else {
                                                                                                                           var63 = null;
                                                                                                                        }

                                                                                                                        if(var63 != null) {
                                                                                                                           class83.intStack[++class165.intStackSize - 1] = var63.id;
                                                                                                                           class83.intStack[++class165.intStackSize - 1] = var63.mask;
                                                                                                                           class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var63.activity;
                                                                                                                           class83.intStack[++class165.intStackSize - 1] = var63.location;
                                                                                                                           class83.intStack[++class165.intStackSize - 1] = var63.playerCount;
                                                                                                                           class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var63.address;
                                                                                                                        } else {
                                                                                                                           class83.intStack[++class165.intStackSize - 1] = -1;
                                                                                                                           class83.intStack[++class165.intStackSize - 1] = 0;
                                                                                                                           class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = "";
                                                                                                                           class83.intStack[++class165.intStackSize - 1] = 0;
                                                                                                                           class83.intStack[++class165.intStackSize - 1] = 0;
                                                                                                                           class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = "";
                                                                                                                        }

                                                                                                                        var29 = 1;
                                                                                                                     } else {
                                                                                                                        World var64;
                                                                                                                        if(var40 == 6506) {
                                                                                                                           var16 = class83.intStack[--class165.intStackSize];
                                                                                                                           var64 = null;

                                                                                                                           for(var18 = 0; var18 < World.field1297; ++var18) {
                                                                                                                              if(var16 == World.worldList[var18].id) {
                                                                                                                                 var64 = World.worldList[var18];
                                                                                                                                 break;
                                                                                                                              }
                                                                                                                           }

                                                                                                                           if(var64 != null) {
                                                                                                                              class83.intStack[++class165.intStackSize - 1] = var64.id;
                                                                                                                              class83.intStack[++class165.intStackSize - 1] = var64.mask;
                                                                                                                              class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var64.activity;
                                                                                                                              class83.intStack[++class165.intStackSize - 1] = var64.location;
                                                                                                                              class83.intStack[++class165.intStackSize - 1] = var64.playerCount;
                                                                                                                              class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var64.address;
                                                                                                                           } else {
                                                                                                                              class83.intStack[++class165.intStackSize - 1] = -1;
                                                                                                                              class83.intStack[++class165.intStackSize - 1] = 0;
                                                                                                                              class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = "";
                                                                                                                              class83.intStack[++class165.intStackSize - 1] = 0;
                                                                                                                              class83.intStack[++class165.intStackSize - 1] = 0;
                                                                                                                              class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = "";
                                                                                                                           }

                                                                                                                           var29 = 1;
                                                                                                                        } else if(var40 == 6507) {
                                                                                                                           class165.intStackSize -= 4;
                                                                                                                           var16 = class83.intStack[class165.intStackSize];
                                                                                                                           var45 = class83.intStack[class165.intStackSize + 1] == 1;
                                                                                                                           var18 = class83.intStack[class165.intStackSize + 2];
                                                                                                                           boolean var46 = class83.intStack[class165.intStackSize + 3] == 1;
                                                                                                                           class14.method102(var16, var45, var18, var46);
                                                                                                                           var29 = 1;
                                                                                                                        } else if(var40 != 6511) {
                                                                                                                           if(var40 == 6512) {
                                                                                                                              Client.field1061 = class83.intStack[--class165.intStackSize] == 1;
                                                                                                                              var29 = 1;
                                                                                                                           } else {
                                                                                                                              class251 var68;
                                                                                                                              if(var40 == 6513) {
                                                                                                                                 class165.intStackSize -= 2;
                                                                                                                                 var16 = class83.intStack[class165.intStackSize];
                                                                                                                                 var17 = class83.intStack[class165.intStackSize + 1];
                                                                                                                                 var68 = ChatLineBuffer.method1859(var17);
                                                                                                                                 if(var68.method4458()) {
                                                                                                                                    class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = class217.getNpcDefinition(var16).method4682(var17, var68.field3391);
                                                                                                                                 } else {
                                                                                                                                    class83.intStack[++class165.intStackSize - 1] = class217.getNpcDefinition(var16).method4668(var17, var68.field3390);
                                                                                                                                 }

                                                                                                                                 var29 = 1;
                                                                                                                              } else if(var40 == 6514) {
                                                                                                                                 class165.intStackSize -= 2;
                                                                                                                                 var16 = class83.intStack[class165.intStackSize];
                                                                                                                                 var17 = class83.intStack[class165.intStackSize + 1];
                                                                                                                                 var68 = ChatLineBuffer.method1859(var17);
                                                                                                                                 if(var68.method4458()) {
                                                                                                                                    class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = class61.getObjectDefinition(var16).method4555(var17, var68.field3391);
                                                                                                                                 } else {
                                                                                                                                    class83.intStack[++class165.intStackSize - 1] = class61.getObjectDefinition(var16).method4549(var17, var68.field3390);
                                                                                                                                 }

                                                                                                                                 var29 = 1;
                                                                                                                              } else if(var40 == 6515) {
                                                                                                                                 class165.intStackSize -= 2;
                                                                                                                                 var16 = class83.intStack[class165.intStackSize];
                                                                                                                                 var17 = class83.intStack[class165.intStackSize + 1];
                                                                                                                                 var68 = ChatLineBuffer.method1859(var17);
                                                                                                                                 if(var68.method4458()) {
                                                                                                                                    class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = ItemComposition.getItemDefinition(var16).method4609(var17, var68.field3391);
                                                                                                                                 } else {
                                                                                                                                    class83.intStack[++class165.intStackSize - 1] = ItemComposition.getItemDefinition(var16).method4638(var17, var68.field3390);
                                                                                                                                 }

                                                                                                                                 var29 = 1;
                                                                                                                              } else if(var40 == 6516) {
                                                                                                                                 class165.intStackSize -= 2;
                                                                                                                                 var16 = class83.intStack[class165.intStackSize];
                                                                                                                                 var17 = class83.intStack[class165.intStackSize + 1];
                                                                                                                                 var68 = ChatLineBuffer.method1859(var17);
                                                                                                                                 if(var68.method4458()) {
                                                                                                                                    class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = class208.method3927(var16).method4486(var17, var68.field3391);
                                                                                                                                 } else {
                                                                                                                                    int[] var60 = class83.intStack;
                                                                                                                                    var20 = ++class165.intStackSize - 1;
                                                                                                                                    class252 var36 = (class252)class252.field3403.get((long)var16);
                                                                                                                                    class252 var44;
                                                                                                                                    if(var36 != null) {
                                                                                                                                       var44 = var36;
                                                                                                                                    } else {
                                                                                                                                       byte[] var47 = class252.field3401.getConfigData(34, var16);
                                                                                                                                       var36 = new class252();
                                                                                                                                       if(var47 != null) {
                                                                                                                                          var36.method4474(new Buffer(var47));
                                                                                                                                       }

                                                                                                                                       var36.method4473();
                                                                                                                                       class252.field3403.put(var36, (long)var16);
                                                                                                                                       var44 = var36;
                                                                                                                                    }

                                                                                                                                    var60[var20] = var44.method4482(var17, var68.field3390);
                                                                                                                                 }

                                                                                                                                 var29 = 1;
                                                                                                                              } else {
                                                                                                                                 var29 = 2;
                                                                                                                              }
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           var16 = class83.intStack[--class165.intStackSize];
                                                                                                                           if(var16 >= 0 && var16 < World.field1297) {
                                                                                                                              var64 = World.worldList[var16];
                                                                                                                              class83.intStack[++class165.intStackSize - 1] = var64.id;
                                                                                                                              class83.intStack[++class165.intStackSize - 1] = var64.mask;
                                                                                                                              class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var64.activity;
                                                                                                                              class83.intStack[++class165.intStackSize - 1] = var64.location;
                                                                                                                              class83.intStack[++class165.intStackSize - 1] = var64.playerCount;
                                                                                                                              class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var64.address;
                                                                                                                           } else {
                                                                                                                              class83.intStack[++class165.intStackSize - 1] = -1;
                                                                                                                              class83.intStack[++class165.intStackSize - 1] = 0;
                                                                                                                              class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = "";
                                                                                                                              class83.intStack[++class165.intStackSize - 1] = 0;
                                                                                                                              class83.intStack[++class165.intStackSize - 1] = 0;
                                                                                                                              class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = "";
                                                                                                                           }

                                                                                                                           var29 = 1;
                                                                                                                        }
                                                                                                                     }
                                                                                                                  }

                                                                                                                  var14 = var29;
                                                                                                               } else if(var40 < 6700) {
                                                                                                                  var14 = class205.method3842(var40, var3, var42);
                                                                                                               } else {
                                                                                                                  var14 = 2;
                                                                                                               }
                                                                                                            }
                                                                                                         }
                                                                                                      }
                                                                                                   }
                                                                                                }
                                                                                             }

                                                                                             switch(var14) {
                                                                                             case 0:
                                                                                                return;
                                                                                             case 1:
                                                                                             default:
                                                                                                break;
                                                                                             case 2:
                                                                                                throw new IllegalStateException();
                                                                                             }
                                                                                          }
                                                                                       }
                                                                                    }
                                                                                 }
                                                                              }
                                                                           }
                                                                        }
                                                                     }
                                                                  }
                                                               }
                                                            }
                                                         }
                                                      }
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         } catch (Exception var39) {
            StringBuilder var38 = new StringBuilder(30);
            var38.append("").append(var3.hash).append(" ");

            for(var12 = class83.scriptStackCount - 1; var12 >= 0; --var12) {
               var38.append("").append(class83.scriptStack[var12].invokedFromScript.hash).append(" ");
            }

            var38.append("").append(var9);
            Projectile.method1734(var38.toString(), var39);
         }
      }
   }
}
