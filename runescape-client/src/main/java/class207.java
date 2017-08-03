import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
public class class207 extends Node {
   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   static IndexData field2555;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   static Font field2551;
   @ObfuscatedName("t")
   int[] field2558;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "[Ldv;"
   )
   class109[] field2552;
   @ObfuscatedName("x")
   short[] field2553;
   @ObfuscatedName("y")
   byte[] field2563;
   @ObfuscatedName("e")
   byte[] field2560;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "[Lgk;"
   )
   class202[] field2556;
   @ObfuscatedName("v")
   byte[] field2557;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1706640855
   )
   int field2566;

   class207(byte[] var1) {
      this.field2552 = new class109[128];
      this.field2553 = new short[128];
      this.field2563 = new byte[128];
      this.field2560 = new byte[128];
      this.field2556 = new class202[128];
      this.field2557 = new byte[128];
      this.field2558 = new int[128];
      Buffer var2 = new Buffer(var1);

      int var3;
      for(var3 = 0; 0 != var2.payload[var3 + var2.offset]; ++var3) {
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
      for(var9 = 0; 0 != var2.payload[var9 + var2.offset]; ++var9) {
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
            var38.field2462 = new byte[var16 * 2];
         }

         var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var38.field2459 = new byte[var16 * 2 + 2];
            var38.field2459[1] = 64;
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
         this.field2553[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.readUnsignedByte();
         this.field2553[var20] = (short)(this.field2553[var20] + (var19 << 8));
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

         this.field2553[var23] = (short)(this.field2553[var23] + ((var22 - 1 & 2) << 14));
         this.field2558[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2558[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.payload[var5++] - 1;
            }

            this.field2557[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if(this.field2558[var25] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.payload[var8++] + 16 << 2;
            }

            this.field2560[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class202 var40 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2558[var26] != 0) {
            if(var20 == 0) {
               var40 = var37[var36[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2556[var26] = var40;
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

            if(this.field2558[var27] > 0) {
               var26 = var2.readUnsignedByte() + 1;
            }
         }

         this.field2563[var27] = (byte)var26;
         --var20;
      }

      this.field2566 = var2.readUnsignedByte() + 1;

      class202 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field2462 != null) {
            for(var29 = 1; var29 < var28.field2462.length; var29 += 2) {
               var28.field2462[var29] = var2.readByte();
            }
         }

         if(var28.field2459 != null) {
            for(var29 = 3; var29 < var28.field2459.length - 2; var29 += 2) {
               var28.field2459[var29] = var2.readByte();
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
         if(var28.field2459 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field2459.length; var29 += 2) {
               var19 = 1 + var19 + var2.readUnsignedByte();
               var28.field2459[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field2462 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field2462.length; var29 += 2) {
               var19 = 1 + var19 + var2.readUnsignedByte();
               var28.field2462[var29] = (byte)var19;
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
            var19 = 1 + var19 + var2.readUnsignedByte();
            var45[var27] = (byte)var19;
         }

         var44 = var45[0];
         byte var41 = var45[1];

         for(var29 = 0; var29 < var44; ++var29) {
            this.field2563[var29] = (byte)(var41 * this.field2563[var29] + 32 >> 6);
         }

         for(var29 = 2; var29 < var45.length; var29 += 2) {
            var30 = var45[var29];
            byte var31 = var45[var29 + 1];
            var32 = var41 * (var30 - var44) + (var30 - var44) / 2;

            for(var33 = var44; var33 < var30; ++var33) {
               var34 = Widget.method4027(var32, var30 - var44);
               this.field2563[var33] = (byte)(32 + var34 * this.field2563[var33] >> 6);
               var32 += var31 - var41;
            }

            var44 = var30;
            var41 = var31;
         }

         for(var42 = var44; var42 < 128; ++var42) {
            this.field2563[var42] = (byte)(var41 * this.field2563[var42] + 32 >> 6);
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
            var42 = var47 + (this.field2560[var29] & 255);
            if(var42 < 0) {
               var42 = 0;
            }

            if(var42 > 128) {
               var42 = 128;
            }

            this.field2560[var29] = (byte)var42;
         }

         int var43;
         for(var29 = 2; var29 < var39.length; var29 += 2) {
            var30 = var39[var29];
            var43 = var39[var29 + 1] << 1;
            var32 = var47 * (var30 - var44) + (var30 - var44) / 2;

            for(var33 = var44; var33 < var30; ++var33) {
               var34 = Widget.method4027(var32, var30 - var44);
               int var35 = var34 + (this.field2560[var33] & 255);
               if(var35 < 0) {
                  var35 = 0;
               }

               if(var35 > 128) {
                  var35 = 128;
               }

               this.field2560[var33] = (byte)var35;
               var32 += var43 - var47;
            }

            var44 = var30;
            var47 = var43;
         }

         for(var42 = var44; var42 < 128; ++var42) {
            var43 = var47 + (this.field2560[var42] & 255);
            if(var43 < 0) {
               var43 = 0;
            }

            if(var43 > 128) {
               var43 = 128;
            }

            this.field2560[var42] = (byte)var43;
         }

         Object var46 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var37[var27].field2461 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field2462 != null) {
            var28.field2467 = var2.readUnsignedByte();
         }

         if(var28.field2459 != null) {
            var28.field2463 = var2.readUnsignedByte();
         }

         if(var28.field2461 > 0) {
            var28.field2464 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var37[var27].field2466 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field2466 > 0) {
            var28.field2465 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field2465 > 0) {
            var28.field2460 = var2.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-632500423"
   )
   void method3885() {
      this.field2558 = null;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ldp;[B[II)Z",
      garbageValue = "2085712865"
   )
   boolean method3884(class114 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class109 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(var2 == null || var2[var7] != 0) {
            int var8 = this.field2558[var7];
            if(var8 != 0) {
               if(var8 != var5) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method2153(var8 >> 2, var3);
                  } else {
                     var6 = var1.method2151(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(var6 != null) {
                  this.field2552[var7] = var6;
                  this.field2558[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "401703451"
   )
   static void method3883() {
      for(class82 var0 = (class82)class82.field1286.getFront(); var0 != null; var0 = (class82)class82.field1286.getNext()) {
         if(var0.field1295 != null) {
            var0.method1610();
         }
      }

   }

   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-211269124"
   )
   static final void method3891(int var0) {
      if(class7.loadWidget(var0)) {
         Widget[] var1 = class170.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2751 = 0;
               var3.field2699 = 0;
            }
         }

      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILcd;ZI)I",
      garbageValue = "619823696"
   )
   static int method3887(int var0, Script var1, boolean var2) {
      String var3;
      if(var0 == 3100) {
         var3 = class83.scriptStringStack[--Timer.scriptStringStackSize];
         class202.sendGameMessage(0, "", var3);
         return 1;
      } else if(var0 == 3101) {
         class83.intStackSize -= 2;
         class51.method793(class224.localPlayer, class83.intStack[class83.intStackSize], class83.intStack[class83.intStackSize + 1]);
         return 1;
      } else if(var0 == 3103) {
         class177.method3424();
         return 1;
      } else {
         int var4;
         if(var0 != 3104) {
            if(var0 == 3105) {
               var3 = class83.scriptStringStack[--Timer.scriptStringStackSize];
               Client.secretPacketBuffer1.putOpcode(134);
               Client.secretPacketBuffer1.putByte(var3.length() + 1);
               Client.secretPacketBuffer1.putString(var3);
               return 1;
            } else if(var0 == 3106) {
               var3 = class83.scriptStringStack[--Timer.scriptStringStackSize];
               Client.secretPacketBuffer1.putOpcode(65);
               Client.secretPacketBuffer1.putByte(var3.length() + 1);
               Client.secretPacketBuffer1.putString(var3);
               return 1;
            } else {
               int var14;
               String var15;
               if(var0 == 3107) {
                  var14 = class83.intStack[--class83.intStackSize];
                  var15 = class83.scriptStringStack[--Timer.scriptStringStackSize];
                  Varcs.method1834(var14, var15);
                  return 1;
               } else if(var0 == 3108) {
                  class83.intStackSize -= 3;
                  var14 = class83.intStack[class83.intStackSize];
                  var4 = class83.intStack[class83.intStackSize + 1];
                  int var5 = class83.intStack[class83.intStackSize + 2];
                  Widget var16 = WallObject.method2901(var5);
                  class25.method171(var16, var14, var4);
                  return 1;
               } else if(var0 == 3109) {
                  class83.intStackSize -= 2;
                  var14 = class83.intStack[class83.intStackSize];
                  var4 = class83.intStack[class83.intStackSize + 1];
                  Widget var21 = var2?class214.field2615:class73.field851;
                  class25.method171(var21, var14, var4);
                  return 1;
               } else if(var0 == 3110) {
                  class67.field792 = class83.intStack[--class83.intStackSize] == 1;
                  return 1;
               } else if(var0 == 3111) {
                  class83.intStack[++class83.intStackSize - 1] = class170.preferences.hideRoofs?1:0;
                  return 1;
               } else if(var0 == 3112) {
                  class170.preferences.hideRoofs = class83.intStack[--class83.intStackSize] == 1;
                  Projectile.method1762();
                  return 1;
               } else if(var0 == 3113) {
                  var3 = class83.scriptStringStack[--Timer.scriptStringStackSize];
                  boolean var18 = class83.intStack[--class83.intStackSize] == 1;
                  DynamicObject.method1871(var3, var18, false);
                  return 1;
               } else if(var0 == 3115) {
                  var14 = class83.intStack[--class83.intStackSize];
                  Client.secretPacketBuffer1.putOpcode(221);
                  Client.secretPacketBuffer1.putShort(var14);
                  return 1;
               } else if(var0 == 3116) {
                  var14 = class83.intStack[--class83.intStackSize];
                  Timer.scriptStringStackSize -= 2;
                  var15 = class83.scriptStringStack[Timer.scriptStringStackSize];
                  String var17 = class83.scriptStringStack[Timer.scriptStringStackSize + 1];
                  if(var15.length() > 500) {
                     return 1;
                  } else if(var17.length() > 500) {
                     return 1;
                  } else {
                     Client.secretPacketBuffer1.putOpcode(184);
                     Client.secretPacketBuffer1.putShort(1 + VertexNormal.getLength(var15) + VertexNormal.getLength(var17));
                     Client.secretPacketBuffer1.putString(var17);
                     Client.secretPacketBuffer1.putString(var15);
                     Client.secretPacketBuffer1.putByte(var14);
                     return 1;
                  }
               } else if(var0 == 3117) {
                  Client.field1031 = class83.intStack[--class83.intStackSize] == 1;
                  return 1;
               } else {
                  return 2;
               }
            }
         } else {
            var3 = class83.scriptStringStack[--Timer.scriptStringStackSize];
            var4 = 0;
            boolean var7 = false;
            boolean var8 = false;
            int var9 = 0;
            int var10 = var3.length();
            int var11 = 0;

            boolean var6;
            while(true) {
               if(var11 >= var10) {
                  var6 = var8;
                  break;
               }

               label244: {
                  char var12 = var3.charAt(var11);
                  if(var11 == 0) {
                     if(var12 == 45) {
                        var7 = true;
                        break label244;
                     }

                     if(var12 == 43) {
                        break label244;
                     }
                  }

                  int var20;
                  if(var12 >= 48 && var12 <= 57) {
                     var20 = var12 - 48;
                  } else if(var12 >= 65 && var12 <= 90) {
                     var20 = var12 - 55;
                  } else {
                     if(var12 < 97 || var12 > 122) {
                        var6 = false;
                        break;
                     }

                     var20 = var12 - 87;
                  }

                  if(var20 >= 10) {
                     var6 = false;
                     break;
                  }

                  if(var7) {
                     var20 = -var20;
                  }

                  int var13 = var9 * 10 + var20;
                  if(var9 != var13 / 10) {
                     var6 = false;
                     break;
                  }

                  var9 = var13;
                  var8 = true;
               }

               ++var11;
            }

            if(var6) {
               int var19 = Timer.parseInt(var3, 10, true);
               var4 = var19;
            }

            Client.secretPacketBuffer1.putOpcode(119);
            Client.secretPacketBuffer1.putInt(var4);
            return 1;
         }
      }
   }
}
