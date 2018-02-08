import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
public class class218 extends Node {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -936681565
   )
   static int field2692;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 867472433
   )
   int field2685;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "[Ldz;"
   )
   RawAudioNode[] field2684;
   @ObfuscatedName("m")
   short[] field2686;
   @ObfuscatedName("h")
   byte[] field2687;
   @ObfuscatedName("i")
   byte[] field2688;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lht;"
   )
   class213[] field2689;
   @ObfuscatedName("t")
   byte[] field2690;
   @ObfuscatedName("d")
   int[] field2691;

   class218(byte[] var1) {
      this.field2684 = new RawAudioNode[128];
      this.field2686 = new short[128];
      this.field2687 = new byte[128];
      this.field2688 = new byte[128];
      this.field2689 = new class213[128];
      this.field2690 = new byte[128];
      this.field2691 = new int[128];
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

      class213[] var37 = new class213[var12];

      class213 var38;
      for(var14 = 0; var14 < var37.length; ++var14) {
         var38 = var37[var14] = new class213();
         int var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var38.field2605 = new byte[var16 * 2];
         }

         var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var38.field2608 = new byte[var16 * 2 + 2];
            var38.field2608[1] = 64;
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
         this.field2686[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.readUnsignedByte();
         this.field2686[var20] = (short)(this.field2686[var20] + (var19 << 8));
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

         this.field2686[var23] = (short)(this.field2686[var23] + ((var22 - 1 & 2) << 14));
         this.field2691[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2691[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.payload[var5++] - 1;
            }

            this.field2690[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if(this.field2691[var25] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.payload[var8++] + 16 << 2;
            }

            this.field2688[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class213 var40 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2691[var26] != 0) {
            if(var20 == 0) {
               var40 = var37[var36[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2689[var26] = var40;
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

            if(this.field2691[var27] > 0) {
               var26 = var2.readUnsignedByte() + 1;
            }
         }

         this.field2687[var27] = (byte)var26;
         --var20;
      }

      this.field2685 = var2.readUnsignedByte() + 1;

      class213 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field2605 != null) {
            for(var29 = 1; var29 < var28.field2605.length; var29 += 2) {
               var28.field2605[var29] = var2.readByte();
            }
         }

         if(var28.field2608 != null) {
            for(var29 = 3; var29 < var28.field2608.length - 2; var29 += 2) {
               var28.field2608[var29] = var2.readByte();
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
         if(var28.field2608 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field2608.length; var29 += 2) {
               var19 = var19 + 1 + var2.readUnsignedByte();
               var28.field2608[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field2605 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field2605.length; var29 += 2) {
               var19 = 1 + var19 + var2.readUnsignedByte();
               var28.field2605[var29] = (byte)var19;
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
            this.field2687[var29] = (byte)(var41 * this.field2687[var29] + 32 >> 6);
         }

         for(var29 = 2; var29 < var45.length; var29 += 2) {
            var30 = var45[var29];
            byte var31 = var45[var29 + 1];
            var32 = var41 * (var30 - var44) + (var30 - var44) / 2;

            for(var33 = var44; var33 < var30; ++var33) {
               var34 = WorldComparator.method72(var32, var30 - var44);
               this.field2687[var33] = (byte)(var34 * this.field2687[var33] + 32 >> 6);
               var32 += var31 - var41;
            }

            var44 = var30;
            var41 = var31;
         }

         for(var42 = var44; var42 < 128; ++var42) {
            this.field2687[var42] = (byte)(var41 * this.field2687[var42] + 32 >> 6);
         }

         var38 = null;
      }

      if(var39 != null) {
         var19 = var2.readUnsignedByte();
         var39[0] = (byte)var19;

         for(var27 = 2; var27 < var39.length; var27 += 2) {
            var19 = var19 + 1 + var2.readUnsignedByte();
            var39[var27] = (byte)var19;
         }

         var44 = var39[0];
         int var47 = var39[1] << 1;

         for(var29 = 0; var29 < var44; ++var29) {
            var42 = var47 + (this.field2688[var29] & 255);
            if(var42 < 0) {
               var42 = 0;
            }

            if(var42 > 128) {
               var42 = 128;
            }

            this.field2688[var29] = (byte)var42;
         }

         int var43;
         for(var29 = 2; var29 < var39.length; var29 += 2) {
            var30 = var39[var29];
            var43 = var39[var29 + 1] << 1;
            var32 = var47 * (var30 - var44) + (var30 - var44) / 2;

            for(var33 = var44; var33 < var30; ++var33) {
               var34 = WorldComparator.method72(var32, var30 - var44);
               int var35 = var34 + (this.field2688[var33] & 255);
               if(var35 < 0) {
                  var35 = 0;
               }

               if(var35 > 128) {
                  var35 = 128;
               }

               this.field2688[var33] = (byte)var35;
               var32 += var43 - var47;
            }

            var44 = var30;
            var47 = var43;
         }

         for(var42 = var44; var42 < 128; ++var42) {
            var43 = var47 + (this.field2688[var42] & 255);
            if(var43 < 0) {
               var43 = 0;
            }

            if(var43 > 128) {
               var43 = 128;
            }

            this.field2688[var42] = (byte)var43;
         }

         Object var46 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var37[var27].field2606 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field2605 != null) {
            var28.field2607 = var2.readUnsignedByte();
         }

         if(var28.field2608 != null) {
            var28.field2604 = var2.readUnsignedByte();
         }

         if(var28.field2606 > 0) {
            var28.field2609 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var37[var27].field2611 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field2611 > 0) {
            var28.field2610 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if(var28.field2610 > 0) {
            var28.field2612 = var2.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ldh;[B[IB)Z",
      garbageValue = "18"
   )
   boolean method4308(class111 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      RawAudioNode var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(var2 == null || var2[var7] != 0) {
            int var8 = this.field2691[var7];
            if(var8 != 0) {
               if(var5 != var8) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method2336(var8 >> 2, var3);
                  } else {
                     var6 = var1.method2346(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(var6 != null) {
                  this.field2684[var7] = var6;
                  this.field2691[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "8"
   )
   void method4300() {
      this.field2691 = null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "936476500"
   )
   public static void method4298() {
      try {
         class157.dat2File.close();

         for(int var0 = 0; var0 < FileRequest.idxCount; ++var0) {
            class1.idxFiles[var0].close();
         }

         class157.idx255File.close();
         class157.randomDat.close();
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-53"
   )
   public static void method4302() {
      CombatInfo2.field3442.reset();
      CombatInfo2.spriteCache.reset();
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IZII)V",
      garbageValue = "1078818756"
   )
   public static final void method4307(int var0, boolean var1, int var2) {
      if(var0 >= 8000 && var0 <= 48000) {
         AbstractSoundSystem.sampleRate = var0;
         CombatInfo1.audioHighMemory = var1;
         class84.priority = var2;
      } else {
         throw new IllegalArgumentException();
      }
   }
}
