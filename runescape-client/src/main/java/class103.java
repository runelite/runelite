import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
public class class103 extends Node {
   @ObfuscatedName("t")
   @Export("payload")
   static byte[] payload;
   @ObfuscatedName("r")
   @Export("position")
   static int position;
   @ObfuscatedName("m")
   @Export("bitPosition")
   static int bitPosition;
   @ObfuscatedName("h")
   @Export("blockSize0")
   static int blockSize0;
   @ObfuscatedName("o")
   @Export("blockSize1")
   static int blockSize1;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[Lcf;"
   )
   @Export("codeBooks")
   static CodeBook[] codeBooks;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "[Ldu;"
   )
   @Export("floors")
   static Floor1[] floors;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "[Lda;"
   )
   @Export("residues")
   static Residue[] residues;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "[Ldh;"
   )
   @Export("mappings")
   static Mapping[] mappings;
   @ObfuscatedName("y")
   @Export("modeBlockFlags")
   static boolean[] modeBlockFlags;
   @ObfuscatedName("d")
   @Export("modeMappings")
   static int[] modeMappings;
   @ObfuscatedName("l")
   static boolean field1482;
   @ObfuscatedName("g")
   static float[] field1497;
   @ObfuscatedName("z")
   static float[] field1488;
   @ObfuscatedName("b")
   static float[] field1489;
   @ObfuscatedName("c")
   static float[] field1490;
   @ObfuscatedName("aa")
   static float[] field1491;
   @ObfuscatedName("ap")
   static float[] field1492;
   @ObfuscatedName("ao")
   static float[] field1493;
   @ObfuscatedName("ar")
   static int[] field1494;
   @ObfuscatedName("ay")
   static int[] field1495;
   @ObfuscatedName("p")
   byte[][] field1476;
   @ObfuscatedName("i")
   int field1465;
   @ObfuscatedName("w")
   int field1467;
   @ObfuscatedName("s")
   int field1468;
   @ObfuscatedName("j")
   int field1469;
   @ObfuscatedName("a")
   boolean field1470;
   @ObfuscatedName("f")
   float[] field1477;
   @ObfuscatedName("k")
   int field1487;
   @ObfuscatedName("e")
   int field1483;
   @ObfuscatedName("u")
   boolean field1486;
   @ObfuscatedName("ax")
   byte[] field1496;
   @ObfuscatedName("ae")
   int field1498;
   @ObfuscatedName("ah")
   int field1472;

   static {
      field1482 = false;
   }

   class103(byte[] var1) {
      this.method2141(var1);
   }

   @ObfuscatedName("j")
   void method2141(byte[] var1) {
      Buffer var2 = new Buffer(var1);
      this.field1465 = var2.readInt();
      this.field1467 = var2.readInt();
      this.field1468 = var2.readInt();
      this.field1469 = var2.readInt();
      if(this.field1469 < 0) {
         this.field1469 = ~this.field1469;
         this.field1470 = true;
      }

      int var3 = var2.readInt();
      this.field1476 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var6;
         do {
            var6 = var2.readUnsignedByte();
            var5 += var6;
         } while(var6 >= 255);

         byte[] var7 = new byte[var5];
         var2.readBytes(var7, 0, var5);
         this.field1476[var4] = var7;
      }

   }

   @ObfuscatedName("t")
   float[] method2119(int var1) {
      setBytes(this.field1476[var1], 0);
      getBit();
      int var2 = getInt(ContextMenuRow.ilog(modeMappings.length - 1));
      boolean var3 = modeBlockFlags[var2];
      int var4 = var3?blockSize1:blockSize0;
      boolean var5 = false;
      boolean var6 = false;
      if(var3) {
         var5 = getBit() != 0;
         var6 = getBit() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if(var3 && !var5) {
         var8 = (var4 >> 2) - (blockSize0 >> 2);
         var9 = (blockSize0 >> 2) + (var4 >> 2);
         var10 = blockSize0 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if(var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (blockSize0 >> 2);
         var12 = (blockSize0 >> 2) + (var4 - (var4 >> 2));
         var13 = blockSize0 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      Mapping var14 = mappings[modeMappings[var2]];
      int var16 = var14.mux;
      int var17 = var14.submapFloors[var16];
      boolean var15 = !floors[var17].decodedFloor();
      boolean var45 = var15;

      for(var17 = 0; var17 < var14.field1602; ++var17) {
         Residue var18 = residues[var14.field1604[var17]];
         float[] var19 = field1497;
         var18.decodeResidue(var19, var4 >> 1, var45);
      }

      int var40;
      if(!var15) {
         var17 = var14.mux;
         var40 = var14.submapFloors[var17];
         floors[var40].computeFloor(field1497, var4 >> 1);
      }

      int var42;
      if(var15) {
         for(var17 = var4 >> 1; var17 < var4; ++var17) {
            field1497[var17] = 0.0F;
         }
      } else {
         var17 = var4 >> 1;
         var40 = var4 >> 2;
         var42 = var4 >> 3;
         float[] var43 = field1497;

         int var21;
         for(var21 = 0; var21 < var17; ++var21) {
            var43[var21] *= 0.5F;
         }

         for(var21 = var17; var21 < var4; ++var21) {
            var43[var21] = -var43[var4 - var21 - 1];
         }

         float[] var44 = var3?field1491:field1488;
         float[] var22 = var3?field1492:field1489;
         float[] var23 = var3?field1493:field1490;
         int[] var24 = var3?field1495:field1494;

         int var25;
         float var26;
         float var27;
         float var28;
         float var29;
         for(var25 = 0; var25 < var40; ++var25) {
            var26 = var43[var25 * 4] - var43[var4 - var25 * 4 - 1];
            var27 = var43[var25 * 4 + 2] - var43[var4 - var25 * 4 - 3];
            var28 = var44[var25 * 2];
            var29 = var44[var25 * 2 + 1];
            var43[var4 - var25 * 4 - 1] = var26 * var28 - var27 * var29;
            var43[var4 - var25 * 4 - 3] = var26 * var29 + var27 * var28;
         }

         float var30;
         float var31;
         for(var25 = 0; var25 < var42; ++var25) {
            var26 = var43[var17 + var25 * 4 + 3];
            var27 = var43[var17 + var25 * 4 + 1];
            var28 = var43[var25 * 4 + 3];
            var29 = var43[var25 * 4 + 1];
            var43[var17 + var25 * 4 + 3] = var26 + var28;
            var43[var17 + var25 * 4 + 1] = var27 + var29;
            var30 = var44[var17 - 4 - var25 * 4];
            var31 = var44[var17 - 3 - var25 * 4];
            var43[var25 * 4 + 3] = (var26 - var28) * var30 - (var27 - var29) * var31;
            var43[var25 * 4 + 1] = (var27 - var29) * var30 + (var26 - var28) * var31;
         }

         var25 = ContextMenuRow.ilog(var4 - 1);

         int var47;
         int var48;
         int var49;
         int var50;
         for(var47 = 0; var47 < var25 - 3; ++var47) {
            var48 = var4 >> var47 + 2;
            var49 = 8 << var47;

            for(var50 = 0; var50 < 2 << var47; ++var50) {
               int var51 = var4 - var48 * var50 * 2;
               int var52 = var4 - var48 * (var50 * 2 + 1);

               for(int var32 = 0; var32 < var4 >> var47 + 4; ++var32) {
                  int var33 = var32 * 4;
                  float var34 = var43[var51 - 1 - var33];
                  float var35 = var43[var51 - 3 - var33];
                  float var36 = var43[var52 - 1 - var33];
                  float var37 = var43[var52 - 3 - var33];
                  var43[var51 - 1 - var33] = var34 + var36;
                  var43[var51 - 3 - var33] = var35 + var37;
                  float var38 = var44[var32 * var49];
                  float var39 = var44[var32 * var49 + 1];
                  var43[var52 - 1 - var33] = (var34 - var36) * var38 - (var35 - var37) * var39;
                  var43[var52 - 3 - var33] = (var35 - var37) * var38 + (var34 - var36) * var39;
               }
            }
         }

         for(var47 = 1; var47 < var42 - 1; ++var47) {
            var48 = var24[var47];
            if(var47 < var48) {
               var49 = var47 * 8;
               var50 = var48 * 8;
               var30 = var43[var49 + 1];
               var43[var49 + 1] = var43[var50 + 1];
               var43[var50 + 1] = var30;
               var30 = var43[var49 + 3];
               var43[var49 + 3] = var43[var50 + 3];
               var43[var50 + 3] = var30;
               var30 = var43[var49 + 5];
               var43[var49 + 5] = var43[var50 + 5];
               var43[var50 + 5] = var30;
               var30 = var43[var49 + 7];
               var43[var49 + 7] = var43[var50 + 7];
               var43[var50 + 7] = var30;
            }
         }

         for(var47 = 0; var47 < var17; ++var47) {
            var43[var47] = var43[var47 * 2 + 1];
         }

         for(var47 = 0; var47 < var42; ++var47) {
            var43[var4 - 1 - var47 * 2] = var43[var47 * 4];
            var43[var4 - 2 - var47 * 2] = var43[var47 * 4 + 1];
            var43[var4 - var40 - 1 - var47 * 2] = var43[var47 * 4 + 2];
            var43[var4 - var40 - 2 - var47 * 2] = var43[var47 * 4 + 3];
         }

         for(var47 = 0; var47 < var42; ++var47) {
            var27 = var23[var47 * 2];
            var28 = var23[var47 * 2 + 1];
            var29 = var43[var17 + var47 * 2];
            var30 = var43[var17 + var47 * 2 + 1];
            var31 = var43[var4 - 2 - var47 * 2];
            float var53 = var43[var4 - 1 - var47 * 2];
            float var54 = var28 * (var29 - var31) + var27 * (var30 + var53);
            var43[var17 + var47 * 2] = (var29 + var31 + var54) * 0.5F;
            var43[var4 - 2 - var47 * 2] = (var29 + var31 - var54) * 0.5F;
            var54 = var28 * (var30 + var53) - var27 * (var29 - var31);
            var43[var17 + var47 * 2 + 1] = (var30 - var53 + var54) * 0.5F;
            var43[var4 - 1 - var47 * 2] = (-var30 + var53 + var54) * 0.5F;
         }

         for(var47 = 0; var47 < var40; ++var47) {
            var43[var47] = var43[var17 + var47 * 2] * var22[var47 * 2] + var43[var17 + var47 * 2 + 1] * var22[var47 * 2 + 1];
            var43[var17 - 1 - var47] = var43[var17 + var47 * 2] * var22[var47 * 2 + 1] - var43[var17 + var47 * 2 + 1] * var22[var47 * 2];
         }

         for(var47 = 0; var47 < var40; ++var47) {
            var43[var47 + (var4 - var40)] = -var43[var47];
         }

         for(var47 = 0; var47 < var40; ++var47) {
            var43[var47] = var43[var40 + var47];
         }

         for(var47 = 0; var47 < var40; ++var47) {
            var43[var40 + var47] = -var43[var40 - var47 - 1];
         }

         for(var47 = 0; var47 < var40; ++var47) {
            var43[var17 + var47] = var43[var4 - var47 - 1];
         }

         for(var47 = var8; var47 < var9; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var8) + 0.5D) / (double)var10 * 0.5D * 3.141592653589793D);
            field1497[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var47 = var11; var47 < var12; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            field1497[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var41 = null;
      if(this.field1487 > 0) {
         var40 = var4 + this.field1487 >> 2;
         var41 = new float[var40];
         int var20;
         if(!this.field1486) {
            for(var42 = 0; var42 < this.field1483; ++var42) {
               var20 = var42 + (this.field1487 >> 1);
               var41[var42] += this.field1477[var20];
            }
         }

         if(!var15) {
            for(var42 = var8; var42 < var4 >> 1; ++var42) {
               var20 = var41.length - (var4 >> 1) + var42;
               var41[var20] += field1497[var42];
            }
         }
      }

      float[] var46 = this.field1477;
      this.field1477 = field1497;
      field1497 = var46;
      this.field1487 = var4;
      this.field1483 = var12 - (var4 >> 1);
      this.field1486 = var15;
      return var41;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([I)Ldp;"
   )
   RawAudioNode method2113(int[] var1) {
      if(var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if(this.field1496 == null) {
            this.field1487 = 0;
            this.field1477 = new float[blockSize1];
            this.field1496 = new byte[this.field1467];
            this.field1498 = 0;
            this.field1472 = 0;
         }

         for(; this.field1472 < this.field1476.length; ++this.field1472) {
            if(var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method2119(this.field1472);
            if(var2 != null) {
               int var3 = this.field1498;
               int var4 = var2.length;
               if(var4 > this.field1467 - var3) {
                  var4 = this.field1467 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field1496[var3++] = (byte)(var6 - 128);
               }

               if(var1 != null) {
                  var1[0] -= var3 - this.field1498;
               }

               this.field1498 = var3;
            }
         }

         this.field1477 = null;
         byte[] var7 = this.field1496;
         this.field1496 = null;
         return new RawAudioNode(this.field1465, var7, this.field1468, this.field1469, this.field1470);
      }
   }

   @ObfuscatedName("p")
   @Export("float32Unpack")
   static float float32Unpack(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if(var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   @ObfuscatedName("i")
   @Export("setBytes")
   static void setBytes(byte[] var0, int var1) {
      payload = var0;
      position = var1;
      bitPosition = 0;
   }

   @ObfuscatedName("w")
   @Export("getBit")
   static int getBit() {
      int var0 = payload[position] >> bitPosition & 1;
      ++bitPosition;
      position += bitPosition >> 3;
      bitPosition &= 7;
      return var0;
   }

   @ObfuscatedName("s")
   @Export("getInt")
   static int getInt(int var0) {
      int var1 = 0;

      int var2;
      int var3;
      for(var2 = 0; var0 >= 8 - bitPosition; var0 -= var3) {
         var3 = 8 - bitPosition;
         int var4 = (1 << var3) - 1;
         var1 += (payload[position] >> bitPosition & var4) << var2;
         bitPosition = 0;
         ++position;
         var2 += var3;
      }

      if(var0 > 0) {
         var3 = (1 << var0) - 1;
         var1 += (payload[position] >> bitPosition & var3) << var2;
         bitPosition += var0;
      }

      return var1;
   }

   @ObfuscatedName("a")
   static void method2132(byte[] var0) {
      setBytes(var0, 0);
      blockSize0 = 1 << getInt(4);
      blockSize1 = 1 << getInt(4);
      field1497 = new float[blockSize1];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0?blockSize1:blockSize0;
         var3 = var2 >> 1;
         var4 = var2 >> 2;
         var5 = var2 >> 3;
         float[] var6 = new float[var3];

         for(int var7 = 0; var7 < var4; ++var7) {
            var6[var7 * 2] = (float)Math.cos((double)(var7 * 4) * 3.141592653589793D / (double)var2);
            var6[var7 * 2 + 1] = -((float)Math.sin((double)(var7 * 4) * 3.141592653589793D / (double)var2));
         }

         float[] var12 = new float[var3];

         for(int var8 = 0; var8 < var4; ++var8) {
            var12[var8 * 2] = (float)Math.cos((double)(var8 * 2 + 1) * 3.141592653589793D / (double)(var2 * 2));
            var12[var8 * 2 + 1] = (float)Math.sin((double)(var8 * 2 + 1) * 3.141592653589793D / (double)(var2 * 2));
         }

         float[] var13 = new float[var4];

         for(int var9 = 0; var9 < var5; ++var9) {
            var13[var9 * 2] = (float)Math.cos((double)(var9 * 4 + 2) * 3.141592653589793D / (double)var2);
            var13[var9 * 2 + 1] = -((float)Math.sin((double)(var9 * 4 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var14 = new int[var5];
         int var10 = ContextMenuRow.ilog(var5 - 1);

         for(int var11 = 0; var11 < var5; ++var11) {
            var14[var11] = Client.method1576(var11, var10);
         }

         if(var1 != 0) {
            field1491 = var6;
            field1492 = var12;
            field1493 = var13;
            field1495 = var14;
         } else {
            field1488 = var6;
            field1489 = var12;
            field1490 = var13;
            field1494 = var14;
         }
      }

      var1 = getInt(8) + 1;
      codeBooks = new CodeBook[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         codeBooks[var2] = new CodeBook();
      }

      var2 = getInt(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         getInt(16);
      }

      var2 = getInt(6) + 1;
      floors = new Floor1[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         floors[var3] = new Floor1();
      }

      var3 = getInt(6) + 1;
      residues = new Residue[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         residues[var4] = new Residue();
      }

      var4 = getInt(6) + 1;
      mappings = new Mapping[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         mappings[var5] = new Mapping();
      }

      var5 = getInt(6) + 1;
      modeBlockFlags = new boolean[var5];
      modeMappings = new int[var5];

      for(int var15 = 0; var15 < var5; ++var15) {
         modeBlockFlags[var15] = getBit() != 0;
         getInt(16);
         getInt(16);
         modeMappings[var15] = getInt(8);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lik;)Z"
   )
   static boolean method2116(IndexDataBase var0) {
      if(!field1482) {
         byte[] var1 = var0.getConfigData(0, 0);
         if(var1 == null) {
            return false;
         }

         method2132(var1);
         field1482 = true;
      }

      return true;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lik;II)Lcp;"
   )
   @Export("getInstrument")
   static class103 getInstrument(IndexDataBase var0, int var1, int var2) {
      if(!method2116(var0)) {
         var0.tryLoadRecord(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.getConfigData(var1, var2);
         return var3 == null?null:new class103(var3);
      }
   }
}
