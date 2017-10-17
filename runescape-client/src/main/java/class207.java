import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
public class class207 extends Node {
   @ObfuscatedName("g")
   int[] field2599;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "[Ldo;"
   )
   class105[] field2593;
   @ObfuscatedName("e")
   short[] field2594;
   @ObfuscatedName("p")
   byte[] field2595;
   @ObfuscatedName("q")
   byte[] field2596;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "[Lgv;"
   )
   class202[] field2597;
   @ObfuscatedName("r")
   byte[] field2592;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 438282247
   )
   int field2598;

   class207(byte[] var1) {
      this.field2593 = new class105[128];
      this.field2594 = new short[128];
      this.field2595 = new byte[128];
      this.field2596 = new byte[128];
      this.field2597 = new class202[128];
      this.field2592 = new byte[128];
      this.field2599 = new int[128];
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
      byte[] var36 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var36[1] = 1;
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

            var36[var14] = (byte)var13;
         }
      } else {
         var12 = var9;
      }

      class202[] var37 = new class202[var12];

      class202 var38;
      for(var14 = 0; var14 < var37.length; ++var14) {
         var38 = var37[var14] = new class202();
         int var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var38.field2516 = new byte[var16 * 2];
         }

         var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var38.field2515 = new byte[var16 * 2 + 2];
            var38.field2515[1] = 64;
         }
      }

      var14 = var2.readUnsignedByte();
      byte[] var45 = var14 > 0?new byte[var14 * 2]:null;
      var14 = var2.readUnsignedByte();
      byte[] var39 = var14 > 0?new byte[var14 * 2]:null;

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
         this.field2594[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.readUnsignedByte();
         this.field2594[var20] = (short)(this.field2594[var20] + (var19 << 8));
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

         this.field2594[var23] = (short)(this.field2594[var23] + ((var22 - 1 & 2) << 14));
         this.field2599[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2599[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.payload[var5++] - 1;
            }

            this.field2592[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if(this.field2599[var25] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.payload[var8++] + 16 << 2;
            }

            this.field2596[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class202 var40 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2599[var26] != 0) {
            if(var20 == 0) {
               var40 = var37[var36[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2597[var26] = var40;
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

            if(this.field2599[var27] > 0) {
               var26 = var2.readUnsignedByte() + 1;
            }
         }

         this.field2595[var27] = (byte)var26;
         --var20;
      }

      this.field2598 = var2.readUnsignedByte() + 1;

      class202 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field2516 != null) {
            for(var29 = 1; var29 < var28.field2516.length; var29 += 2) {
               var28.field2516[var29] = var2.readByte();
            }
         }

         if(var28.field2515 != null) {
            for(var29 = 3; var29 < var28.field2515.length - 2; var29 += 2) {
               var28.field2515[var29] = var2.readByte();
            }
         }
      }

      if(var45 != null) {
         for(var27 = 1; var27 < var45.length; var27 += 2) {
            var45[var27] = var2.readByte();
         }
      }

      if(var39 != null) {
         for(var27 = 1; var27 < var39.length; var27 += 2) {
            var39[var27] = var2.readByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field2515 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field2515.length; var29 += 2) {
               var19 = 1 + var19 + var2.readUnsignedByte();
               var28.field2515[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field2516 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field2516.length; var29 += 2) {
               var19 = var19 + 1 + var2.readUnsignedByte();
               var28.field2516[var29] = (byte)var19;
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
         var19 = var2.readUnsignedByte();
         var45[0] = (byte)var19;

         for(var27 = 2; var27 < var45.length; var27 += 2) {
            var19 = var19 + 1 + var2.readUnsignedByte();
            var45[var27] = (byte)var19;
         }

         var44 = var45[0];
         byte var41 = var45[1];

         for(var29 = 0; var29 < var44; ++var29) {
            this.field2595[var29] = (byte)(var41 * this.field2595[var29] + 32 >> 6);
         }

         for(var29 = 2; var29 < var45.length; var29 += 2) {
            var30 = var45[var29];
            byte var31 = var45[var29 + 1];
            var32 = var41 * (var30 - var44) + (var30 - var44) / 2;

            for(var33 = var44; var33 < var30; ++var33) {
               var34 = ClanMember.method1196(var32, var30 - var44);
               this.field2595[var33] = (byte)(var34 * this.field2595[var33] + 32 >> 6);
               var32 += var31 - var41;
            }

            var44 = var30;
            var41 = var31;
         }

         for(var42 = var44; var42 < 128; ++var42) {
            this.field2595[var42] = (byte)(var41 * this.field2595[var42] + 32 >> 6);
         }

         var38 = null;
      }

      if(var39 != null) {
         var19 = var2.readUnsignedByte();
         var39[0] = (byte)var19;

         for(var27 = 2; var27 < var39.length; var27 += 2) {
            var19 = 1 + var19 + var2.readUnsignedByte();
            var39[var27] = (byte)var19;
         }

         var44 = var39[0];
         int var47 = var39[1] << 1;

         for(var29 = 0; var29 < var44; ++var29) {
            var42 = var47 + (this.field2596[var29] & 255);
            if(var42 < 0) {
               var42 = 0;
            }

            if(var42 > 128) {
               var42 = 128;
            }

            this.field2596[var29] = (byte)var42;
         }

         int var43;
         for(var29 = 2; var29 < var39.length; var29 += 2) {
            var30 = var39[var29];
            var43 = var39[var29 + 1] << 1;
            var32 = var47 * (var30 - var44) + (var30 - var44) / 2;

            for(var33 = var44; var33 < var30; ++var33) {
               var34 = ClanMember.method1196(var32, var30 - var44);
               int var35 = var34 + (this.field2596[var33] & 255);
               if(var35 < 0) {
                  var35 = 0;
               }

               if(var35 > 128) {
                  var35 = 128;
               }

               this.field2596[var33] = (byte)var35;
               var32 += var43 - var47;
            }

            var44 = var30;
            var47 = var43;
         }

         for(var42 = var44; var42 < 128; ++var42) {
            var43 = var47 + (this.field2596[var42] & 255);
            if(var43 < 0) {
               var43 = 0;
            }

            if(var43 > 128) {
               var43 = 128;
            }

            this.field2596[var42] = (byte)var43;
         }

         Object var46 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var37[var27].field2509 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field2516 != null) {
            var28.field2514 = var2.readUnsignedByte();
         }

         if(var28.field2515 != null) {
            var28.field2505 = var2.readUnsignedByte();
         }

         if(var28.field2509 > 0) {
            var28.field2510 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var37[var27].field2512 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field2512 > 0) {
            var28.field2511 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field2511 > 0) {
            var28.field2513 = var2.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2052734210"
   )
   void method3997() {
      this.field2599 = null;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ldi;[B[IB)Z",
      garbageValue = "32"
   )
   boolean method3988(class110 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class105 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(var2 == null || var2[var7] != 0) {
            int var8 = this.field2599[var7];
            if(var8 != 0) {
               if(var8 != var5) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method2165(var8 >> 2, var3);
                  } else {
                     var6 = var1.method2160(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(var6 != null) {
                  this.field2593[var7] = var6;
                  this.field2599[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-1306832508"
   )
   static final void method3998(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int[] var7 = Region.method2809(var0, var1, var2);
      int[] var8 = Region.method2809(var3, var4, var5);
      Rasterizer2D.drawLine(var7[0], var7[1], var8[0], var8[1], var6);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lkj;I)Ljava/lang/String;",
      garbageValue = "-745408440"
   )
   public static String method3989(CharSequence var0, class290 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         for(var3 = var0.length(); var2 < var3 && class56.method848(var0.charAt(var2)); ++var2) {
            ;
         }

         while(var3 > var2 && class56.method848(var0.charAt(var3 - 1))) {
            --var3;
         }

         int var4 = var3 - var2;
         if(var4 >= 1) {
            byte var6;
            if(var1 == null) {
               var6 = 12;
            } else {
               switch(var1.field3868) {
               case 7:
                  var6 = 20;
                  break;
               default:
                  var6 = 12;
               }
            }

            if(var4 <= var6) {
               StringBuilder var12 = new StringBuilder(var4);

               for(int var14 = var2; var14 < var3; ++var14) {
                  char var7 = var0.charAt(var14);
                  boolean var8;
                  if(Character.isISOControl(var7)) {
                     var8 = false;
                  } else if(Overlay.method4773(var7)) {
                     var8 = true;
                  } else {
                     char[] var13 = class267.field3670;
                     int var10 = 0;

                     label96:
                     while(true) {
                        char var11;
                        if(var10 >= var13.length) {
                           var13 = class267.field3671;

                           for(var10 = 0; var10 < var13.length; ++var10) {
                              var11 = var13[var10];
                              if(var11 == var7) {
                                 var8 = true;
                                 break label96;
                              }
                           }

                           var8 = false;
                           break;
                        }

                        var11 = var13[var10];
                        if(var7 == var11) {
                           var8 = true;
                           break;
                        }

                        ++var10;
                     }
                  }

                  if(var8) {
                     char var9;
                     switch(var7) {
                     case ' ':
                     case '-':
                     case '_':
                     case ' ':
                        var9 = 95;
                        break;
                     case '#':
                     case '[':
                     case ']':
                        var9 = var7;
                        break;
                     case 'À':
                     case 'Á':
                     case 'Â':
                     case 'Ã':
                     case 'Ä':
                     case 'à':
                     case 'á':
                     case 'â':
                     case 'ã':
                     case 'ä':
                        var9 = 97;
                        break;
                     case 'Ç':
                     case 'ç':
                        var9 = 99;
                        break;
                     case 'È':
                     case 'É':
                     case 'Ê':
                     case 'Ë':
                     case 'è':
                     case 'é':
                     case 'ê':
                     case 'ë':
                        var9 = 101;
                        break;
                     case 'Í':
                     case 'Î':
                     case 'Ï':
                     case 'í':
                     case 'î':
                     case 'ï':
                        var9 = 105;
                        break;
                     case 'Ñ':
                     case 'ñ':
                        var9 = 110;
                        break;
                     case 'Ò':
                     case 'Ó':
                     case 'Ô':
                     case 'Õ':
                     case 'Ö':
                     case 'ò':
                     case 'ó':
                     case 'ô':
                     case 'õ':
                     case 'ö':
                        var9 = 111;
                        break;
                     case 'Ù':
                     case 'Ú':
                     case 'Û':
                     case 'Ü':
                     case 'ù':
                     case 'ú':
                     case 'û':
                     case 'ü':
                        var9 = 117;
                        break;
                     case 'ß':
                        var9 = 98;
                        break;
                     case 'ÿ':
                     case 'Ÿ':
                        var9 = 121;
                        break;
                     default:
                        var9 = Character.toLowerCase(var7);
                     }

                     if(var9 != 0) {
                        var12.append(var9);
                     }
                  }
               }

               if(var12.length() == 0) {
                  return null;
               }

               return var12.toString();
            }
         }

         return null;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "-8313332"
   )
   public static int method3999(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0 - (var3 - 1):(var2 == 2?7 - var1 - (var4 - 1):var0));
   }
}
