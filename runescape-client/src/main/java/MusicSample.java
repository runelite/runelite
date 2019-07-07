import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("MusicSample")
public class MusicSample extends Node {
   @ObfuscatedName("g")
   static byte[] field603;
   @ObfuscatedName("l")
   static int field604;
   @ObfuscatedName("e")
   static int field605;
   @ObfuscatedName("x")
   static int field606;
   @ObfuscatedName("d")
   static int field607;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "[Lcc;"
   )
   static class98[] field1323;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "[Lca;"
   )
   static class102[] field1324;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "[Lda;"
   )
   static class109[] field1344;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "[Ldg;"
   )
   static class114[] field1326;
   @ObfuscatedName("z")
   static boolean[] field608;
   @ObfuscatedName("j")
   static int[] field609;
   @ObfuscatedName("s")
   static boolean field610;
   @ObfuscatedName("c")
   static float[] field611;
   @ObfuscatedName("r")
   static float[] field612;
   @ObfuscatedName("p")
   static float[] field613;
   @ObfuscatedName("v")
   static float[] field614;
   @ObfuscatedName("ag")
   static float[] field615;
   @ObfuscatedName("aq")
   static float[] field616;
   @ObfuscatedName("aj")
   static float[] field617;
   @ObfuscatedName("av")
   static int[] field618;
   @ObfuscatedName("ar")
   static int[] field619;
   @ObfuscatedName("m")
   byte[][] field620;
   @ObfuscatedName("f")
   @Export("sampleRate")
   int sampleRate;
   @ObfuscatedName("q")
   @Export("sampleCount")
   int sampleCount;
   @ObfuscatedName("w")
   @Export("start")
   int start;
   @ObfuscatedName("o")
   @Export("end")
   int end;
   @ObfuscatedName("u")
   boolean field621;
   @ObfuscatedName("t")
   float[] field622;
   @ObfuscatedName("y")
   int field623;
   @ObfuscatedName("h")
   int field624;
   @ObfuscatedName("b")
   boolean field625;
   @ObfuscatedName("ac")
   @Export("samples")
   byte[] samples;
   @ObfuscatedName("ay")
   int field626;
   @ObfuscatedName("ah")
   int field627;

   MusicSample(byte[] var1) {
      this.read(var1);
   }

   @ObfuscatedName("o")
   @Export("read")
   void read(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      this.sampleRate = var2.readInt();
      this.sampleCount = var2.readInt();
      this.start = var2.readInt();
      this.end = var2.readInt();
      if (this.end < 0) {
         this.end = ~this.end;
         this.field621 = true;
      }

      int var3 = var2.readInt();
      this.field620 = new byte[var3][];

      for (int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var6;
         do {
            var6 = var2.readUnsignedByte();
            var5 += var6;
         } while(var6 >= 255);

         byte[] var7 = new byte[var5];
         var2.method46(var7, 0, var5);
         this.field620[var4] = var7;
      }

   }

   @ObfuscatedName("g")
   float[] method225(int var1) {
      method2337(this.field620[var1], 0);
      method2338();
      int var2 = method2352(WorldMapCacheName.method634(field609.length - 1));
      boolean var3 = field608[var2];
      int var4 = var3 ? field607 : field606;
      boolean var5 = false;
      boolean var6 = false;
      if (var3) {
         var5 = method2338() != 0;
         var6 = method2338() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if (var3 && !var5) {
         var8 = (var4 >> 2) - (field606 >> 2);
         var9 = (field606 >> 2) + (var4 >> 2);
         var10 = field606 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if (var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field606 >> 2);
         var12 = (field606 >> 2) + (var4 - (var4 >> 2));
         var13 = field606 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class114 var14 = field1326[field609[var2]];
      int var15 = var14.field1454;
      int var16 = var14.field1452[var15];
      boolean var17 = !field1324[var16].method2367();
      boolean var18 = var17;

      float[] var20;
      for (var16 = 0; var16 < var14.field1453; ++var16) {
         class109 var19 = field1344[var14.field1455[var16]];
         var20 = field611;
         var19.method2473(var20, var4 >> 1, var18);
      }

      int var48;
      if (!var17) {
         var16 = var14.field1454;
         var48 = var14.field1452[var16];
         field1324[var48].method2375(field611, var4 >> 1);
      }

      int var21;
      int var22;
      float[] var23;
      if (var17) {
         for (var16 = var4 >> 1; var16 < var4; ++var16) {
            field611[var16] = 0.0F;
         }
      } else {
         var16 = var4 >> 1;
         var48 = var4 >> 2;
         var22 = var4 >> 3;
         var20 = field611;

         for (var21 = 0; var21 < var16; ++var21) {
            var20[var21] *= 0.5F;
         }

         for (var21 = var16; var21 < var4; ++var21) {
            var20[var21] = -var20[var4 - var21 - 1];
         }

         var23 = var3 ? field615 : field612;
         float[] var24 = var3 ? field616 : field613;
         float[] var25 = var3 ? field617 : field614;
         int[] var26 = var3 ? field619 : field618;

         int var27;
         float var28;
         float var29;
         float var30;
         float var31;
         for (var27 = 0; var27 < var48; ++var27) {
            var28 = var20[var27 * 4] - var20[var4 - var27 * 4 - 1];
            var29 = var20[var27 * 4 + 2] - var20[var4 - var27 * 4 - 3];
            var30 = var23[var27 * 2];
            var31 = var23[var27 * 2 + 1];
            var20[var4 - var27 * 4 - 1] = var28 * var30 - var29 * var31;
            var20[var4 - var27 * 4 - 3] = var28 * var31 + var29 * var30;
         }

         float var32;
         float var33;
         for (var27 = 0; var27 < var22; ++var27) {
            var28 = var20[var16 + var27 * 4 + 3];
            var29 = var20[var16 + var27 * 4 + 1];
            var30 = var20[var27 * 4 + 3];
            var31 = var20[var27 * 4 + 1];
            var20[var16 + var27 * 4 + 3] = var28 + var30;
            var20[var16 + var27 * 4 + 1] = var29 + var31;
            var32 = var23[var16 - 4 - var27 * 4];
            var33 = var23[var16 - 3 - var27 * 4];
            var20[var27 * 4 + 3] = (var28 - var30) * var32 - (var29 - var31) * var33;
            var20[var27 * 4 + 1] = (var29 - var31) * var32 + (var28 - var30) * var33;
         }

         var27 = WorldMapCacheName.method634(var4 - 1);

         int var34;
         int var35;
         int var36;
         int var37;
         for (var34 = 0; var34 < var27 - 3; ++var34) {
            var35 = var4 >> var34 + 2;
            var36 = 8 << var34;

            for (var37 = 0; var37 < 2 << var34; ++var37) {
               int var38 = var4 - var35 * var37 * 2;
               int var39 = var4 - var35 * (var37 * 2 + 1);

               for (int var40 = 0; var40 < var4 >> var34 + 4; ++var40) {
                  int var41 = var40 * 4;
                  float var42 = var20[var38 - 1 - var41];
                  float var43 = var20[var38 - 3 - var41];
                  float var44 = var20[var39 - 1 - var41];
                  float var45 = var20[var39 - 3 - var41];
                  var20[var38 - 1 - var41] = var42 + var44;
                  var20[var38 - 3 - var41] = var43 + var45;
                  float var46 = var23[var40 * var36];
                  float var47 = var23[var40 * var36 + 1];
                  var20[var39 - 1 - var41] = (var42 - var44) * var46 - (var43 - var45) * var47;
                  var20[var39 - 3 - var41] = (var43 - var45) * var46 + (var42 - var44) * var47;
               }
            }
         }

         for (var34 = 1; var34 < var22 - 1; ++var34) {
            var35 = var26[var34];
            if (var34 < var35) {
               var36 = var34 * 8;
               var37 = var35 * 8;
               var32 = var20[var36 + 1];
               var20[var36 + 1] = var20[var37 + 1];
               var20[var37 + 1] = var32;
               var32 = var20[var36 + 3];
               var20[var36 + 3] = var20[var37 + 3];
               var20[var37 + 3] = var32;
               var32 = var20[var36 + 5];
               var20[var36 + 5] = var20[var37 + 5];
               var20[var37 + 5] = var32;
               var32 = var20[var36 + 7];
               var20[var36 + 7] = var20[var37 + 7];
               var20[var37 + 7] = var32;
            }
         }

         for (var34 = 0; var34 < var16; ++var34) {
            var20[var34] = var20[var34 * 2 + 1];
         }

         for (var34 = 0; var34 < var22; ++var34) {
            var20[var4 - 1 - var34 * 2] = var20[var34 * 4];
            var20[var4 - 2 - var34 * 2] = var20[var34 * 4 + 1];
            var20[var4 - var48 - 1 - var34 * 2] = var20[var34 * 4 + 2];
            var20[var4 - var48 - 2 - var34 * 2] = var20[var34 * 4 + 3];
         }

         for (var34 = 0; var34 < var22; ++var34) {
            var29 = var25[var34 * 2];
            var30 = var25[var34 * 2 + 1];
            var31 = var20[var16 + var34 * 2];
            var32 = var20[var16 + var34 * 2 + 1];
            var33 = var20[var4 - 2 - var34 * 2];
            float var49 = var20[var4 - 1 - var34 * 2];
            float var51 = var30 * (var31 - var33) + var29 * (var32 + var49);
            var20[var16 + var34 * 2] = (var31 + var33 + var51) * 0.5F;
            var20[var4 - 2 - var34 * 2] = (var31 + var33 - var51) * 0.5F;
            var51 = var30 * (var32 + var49) - var29 * (var31 - var33);
            var20[var16 + var34 * 2 + 1] = (var32 - var49 + var51) * 0.5F;
            var20[var4 - 1 - var34 * 2] = (-var32 + var49 + var51) * 0.5F;
         }

         for (var34 = 0; var34 < var48; ++var34) {
            var20[var34] = var20[var16 + var34 * 2] * var24[var34 * 2] + var20[var16 + var34 * 2 + 1] * var24[var34 * 2 + 1];
            var20[var16 - 1 - var34] = var20[var16 + var34 * 2] * var24[var34 * 2 + 1] - var20[var16 + var34 * 2 + 1] * var24[var34 * 2];
         }

         for (var34 = 0; var34 < var48; ++var34) {
            var20[var34 + (var4 - var48)] = -var20[var34];
         }

         for (var34 = 0; var34 < var48; ++var34) {
            var20[var34] = var20[var48 + var34];
         }

         for (var34 = 0; var34 < var48; ++var34) {
            var20[var48 + var34] = -var20[var48 - var34 - 1];
         }

         for (var34 = 0; var34 < var48; ++var34) {
            var20[var16 + var34] = var20[var4 - var34 - 1];
         }

         float[] var50;
         for (var34 = var8; var34 < var9; ++var34) {
            var29 = (float)Math.sin(((double)(var34 - var8) + 0.5D) / (double)var10 * 0.5D * 3.141592653589793D);
            var50 = field611;
            var50[var34] *= (float)Math.sin(1.5707963267948966D * (double)var29 * (double)var29);
         }

         for (var34 = var11; var34 < var12; ++var34) {
            var29 = (float)Math.sin(((double)(var34 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            var50 = field611;
            var50[var34] *= (float)Math.sin(1.5707963267948966D * (double)var29 * (double)var29);
         }
      }

      var20 = null;
      if (this.field623 > 0) {
         var48 = var4 + this.field623 >> 2;
         var20 = new float[var48];
         if (!this.field625) {
            for (var22 = 0; var22 < this.field624; ++var22) {
               var21 = var22 + (this.field623 >> 1);
               var20[var22] += this.field622[var21];
            }
         }

         if (!var17) {
            for (var22 = var8; var22 < var4 >> 1; ++var22) {
               var21 = var20.length - (var4 >> 1) + var22;
               var20[var21] += field611[var22];
            }
         }
      }

      var23 = this.field622;
      this.field622 = field611;
      field611 = var23;
      this.field623 = var4;
      this.field624 = var12 - (var4 >> 1);
      this.field625 = var17;
      return var20;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([I)Lcx;"
   )
   @Export("toRawSound")
   RawSound toRawSound(int[] var1) {
      if (var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if (this.samples == null) {
            this.field623 = 0;
            this.field622 = new float[field607];
            this.samples = new byte[this.sampleCount];
            this.field626 = 0;
            this.field627 = 0;
         }

         for (; this.field627 < this.field620.length; ++this.field627) {
            if (var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method225(this.field627);
            if (var2 != null) {
               int var3 = this.field626;
               int var4 = var2.length;
               if (var4 > this.sampleCount - var3) {
                  var4 = this.sampleCount - var3;
               }

               for (int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if ((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.samples[var3++] = (byte)(var6 - 128);
               }

               if (var1 != null) {
                  var1[0] -= var3 - this.field626;
               }

               this.field626 = var3;
            }
         }

         this.field622 = null;
         byte[] var7 = this.samples;
         this.samples = null;
         return new RawSound(this.sampleRate, var7, this.start, this.end, this.field621);
      }
   }

   @ObfuscatedName("m")
   static float method2357(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if (var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   @ObfuscatedName("f")
   static void method2337(byte[] var0, int var1) {
      field603 = var0;
      field604 = var1;
      field605 = 0;
   }

   @ObfuscatedName("q")
   static int method2338() {
      int var0 = field603[field604] >> field605 & 1;
      ++field605;
      field604 += field605 >> 3;
      field605 &= 7;
      return var0;
   }

   @ObfuscatedName("w")
   static int method2352(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for (var2 = 0; var0 >= 8 - field605; var0 -= var3) {
         var3 = 8 - field605;
         int var4 = (1 << var3) - 1;
         var1 += (field603[field604] >> field605 & var4) << var2;
         field605 = 0;
         ++field604;
         var2 += var3;
      }

      if (var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (field603[field604] >> field605 & var3) << var2;
         field605 += var0;
      }

      return var1;
   }

   @ObfuscatedName("u")
   static void method2341(byte[] var0) {
      method2337(var0, 0);
      field606 = 1 << method2352(4);
      field607 = 1 << method2352(4);
      field611 = new float[field607];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for (var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0 ? field607 : field606;
         var3 = var2 >> 1;
         var4 = var2 >> 2;
         var5 = var2 >> 3;
         float[] var6 = new float[var3];

         for (int var7 = 0; var7 < var4; ++var7) {
            var6[var7 * 2] = (float)Math.cos((double)(var7 * 4) * 3.141592653589793D / (double)var2);
            var6[var7 * 2 + 1] = -((float)Math.sin((double)(var7 * 4) * 3.141592653589793D / (double)var2));
         }

         float[] var13 = new float[var3];

         for (int var8 = 0; var8 < var4; ++var8) {
            var13[var8 * 2] = (float)Math.cos((double)(var8 * 2 + 1) * 3.141592653589793D / (double)(var2 * 2));
            var13[var8 * 2 + 1] = (float)Math.sin((double)(var8 * 2 + 1) * 3.141592653589793D / (double)(var2 * 2));
         }

         float[] var14 = new float[var4];

         for (int var9 = 0; var9 < var5; ++var9) {
            var14[var9 * 2] = (float)Math.cos((double)(var9 * 4 + 2) * 3.141592653589793D / (double)var2);
            var14[var9 * 2 + 1] = -((float)Math.sin((double)(var9 * 4 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var15 = new int[var5];
         int var10 = WorldMapCacheName.method634(var5 - 1);

         for (int var11 = 0; var11 < var5; ++var11) {
            var15[var11] = GrandExchangeEvent.method87(var11, var10);
         }

         if (var1 != 0) {
            field615 = var6;
            field616 = var13;
            field617 = var14;
            field619 = var15;
         } else {
            field612 = var6;
            field613 = var13;
            field614 = var14;
            field618 = var15;
         }
      }

      var1 = method2352(8) + 1;
      field1323 = new class98[var1];

      for (var2 = 0; var2 < var1; ++var2) {
         field1323[var2] = new class98();
      }

      var2 = method2352(6) + 1;

      for (var3 = 0; var3 < var2; ++var3) {
         method2352(16);
      }

      var2 = method2352(6) + 1;
      field1324 = new class102[var2];

      for (var3 = 0; var3 < var2; ++var3) {
         field1324[var3] = new class102();
      }

      var3 = method2352(6) + 1;
      field1344 = new class109[var3];

      for (var4 = 0; var4 < var3; ++var4) {
         field1344[var4] = new class109();
      }

      var4 = method2352(6) + 1;
      field1326 = new class114[var4];

      for (var5 = 0; var5 < var4; ++var5) {
         field1326[var5] = new class114();
      }

      var5 = method2352(6) + 1;
      field608 = new boolean[var5];
      field609 = new int[var5];

      for (int var12 = 0; var12 < var5; ++var12) {
         field608[var12] = method2338() != 0;
         method2352(16);
         method2352(16);
         field609[var12] = method2352(8);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lir;)Z"
   )
   static boolean method2343(AbstractArchive var0) {
      if (!field610) {
         byte[] var1 = var0.takeFile(0, 0);
         if (var1 == null) {
            return false;
         }

         method2341(var1);
         field610 = true;
      }

      return true;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lir;II)Lcd;"
   )
   @Export("readMusicSample")
   static MusicSample readMusicSample(AbstractArchive var0, int var1, int var2) {
      if (!method2343(var0)) {
         var0.tryLoadFile(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.takeFile(var1, var2);
         return var3 == null ? null : new MusicSample(var3);
      }
   }

   static {
      field610 = false;
   }
}
