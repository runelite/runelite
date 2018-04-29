import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ch")
@Implements("CodeBook")
public class CodeBook {
   @ObfuscatedName("g")
   @Export("dimensions")
   int dimensions;
   @ObfuscatedName("e")
   @Export("entries")
   int entries;
   @ObfuscatedName("b")
   @Export("entryLengths")
   int[] entryLengths;
   @ObfuscatedName("z")
   int[] field1477;
   @ObfuscatedName("n")
   @Export("valueVector")
   float[][] valueVector;
   @ObfuscatedName("l")
   int[] field1476;

   CodeBook() {
      class104.getInt(24);
      this.dimensions = class104.getInt(16);
      this.entries = class104.getInt(24);
      this.entryLengths = new int[this.entries];
      boolean var1 = class104.getBit() != 0;
      int var2;
      int var3;
      int var5;
      if(var1) {
         var2 = 0;

         for(var3 = class104.getInt(5) + 1; var2 < this.entries; ++var3) {
            int var4 = class104.getInt(NetWriter.ilog(this.entries - var2));

            for(var5 = 0; var5 < var4; ++var5) {
               this.entryLengths[var2++] = var3;
            }
         }
      } else {
         boolean var14 = class104.getBit() != 0;

         for(var3 = 0; var3 < this.entries; ++var3) {
            if(var14 && class104.getBit() == 0) {
               this.entryLengths[var3] = 0;
            } else {
               this.entryLengths[var3] = class104.getInt(5) + 1;
            }
         }
      }

      this.createHuffmanTree();
      var2 = class104.getInt(4);
      if(var2 > 0) {
         float var15 = class104.float32Unpack(class104.getInt(32));
         float var16 = class104.float32Unpack(class104.getInt(32));
         var5 = class104.getInt(4) + 1;
         boolean var6 = class104.getBit() != 0;
         int var7;
         if(var2 == 1) {
            var7 = method2227(this.entries, this.dimensions);
         } else {
            var7 = this.entries * this.dimensions;
         }

         this.field1477 = new int[var7];

         int var8;
         for(var8 = 0; var8 < var7; ++var8) {
            this.field1477[var8] = class104.getInt(var5);
         }

         this.valueVector = new float[this.entries][this.dimensions];
         float var9;
         int var10;
         int var11;
         if(var2 == 1) {
            for(var8 = 0; var8 < this.entries; ++var8) {
               var9 = 0.0F;
               var10 = 1;

               for(var11 = 0; var11 < this.dimensions; ++var11) {
                  int var12 = var8 / var10 % var7;
                  float var13 = (float)this.field1477[var12] * var16 + var15 + var9;
                  this.valueVector[var8][var11] = var13;
                  if(var6) {
                     var9 = var13;
                  }

                  var10 *= var7;
               }
            }
         } else {
            for(var8 = 0; var8 < this.entries; ++var8) {
               var9 = 0.0F;
               var10 = var8 * this.dimensions;

               for(var11 = 0; var11 < this.dimensions; ++var11) {
                  float var17 = (float)this.field1477[var10] * var16 + var15 + var9;
                  this.valueVector[var8][var11] = var17;
                  if(var6) {
                     var9 = var17;
                  }

                  ++var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("e")
   @Export("createHuffmanTree")
   void createHuffmanTree() {
      int[] var1 = new int[this.entries];
      int[] var2 = new int[33];

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var10;
      for(var3 = 0; var3 < this.entries; ++var3) {
         var4 = this.entryLengths[var3];
         if(var4 != 0) {
            var5 = 1 << 32 - var4;
            var6 = var2[var4];
            var1[var3] = var6;
            int var12;
            if((var6 & var5) != 0) {
               var7 = var2[var4 - 1];
            } else {
               var7 = var6 | var5;

               for(var8 = var4 - 1; var8 >= 1; --var8) {
                  var12 = var2[var8];
                  if(var12 != var6) {
                     break;
                  }

                  var10 = 1 << 32 - var8;
                  if((var12 & var10) != 0) {
                     var2[var8] = var2[var8 - 1];
                     break;
                  }

                  var2[var8] = var12 | var10;
               }
            }

            var2[var4] = var7;

            for(var8 = var4 + 1; var8 <= 32; ++var8) {
               var12 = var2[var8];
               if(var12 == var6) {
                  var2[var8] = var7;
               }
            }
         }
      }

      this.field1476 = new int[8];
      int var11 = 0;

      for(var3 = 0; var3 < this.entries; ++var3) {
         var4 = this.entryLengths[var3];
         if(var4 != 0) {
            var5 = var1[var3];
            var6 = 0;

            for(var7 = 0; var7 < var4; ++var7) {
               var8 = Integer.MIN_VALUE >>> var7;
               if((var5 & var8) != 0) {
                  if(this.field1476[var6] == 0) {
                     this.field1476[var6] = var11;
                  }

                  var6 = this.field1476[var6];
               } else {
                  ++var6;
               }

               if(var6 >= this.field1476.length) {
                  int[] var9 = new int[this.field1476.length * 2];

                  for(var10 = 0; var10 < this.field1476.length; ++var10) {
                     var9[var10] = this.field1476[var10];
                  }

                  this.field1476 = var9;
               }

               var8 >>>= 1;
            }

            this.field1476[var6] = ~var3;
            if(var6 >= var11) {
               var11 = var6 + 1;
            }
         }
      }

   }

   @ObfuscatedName("b")
   @Export("getHuffmanRoot")
   int getHuffmanRoot() {
      int var1;
      for(var1 = 0; this.field1476[var1] >= 0; var1 = class104.getBit() != 0?this.field1476[var1]:var1 + 1) {
         ;
      }

      return ~this.field1476[var1];
   }

   @ObfuscatedName("z")
   float[] method2222() {
      return this.valueVector[this.getHuffmanRoot()];
   }

   @ObfuscatedName("g")
   static int method2227(int var0, int var1) {
      int var2;
      for(var2 = (int)Math.pow((double)var0, 1.0D / (double)var1) + 1; VertexNormal.method2875(var2, var1) > var0; --var2) {
         ;
      }

      return var2;
   }
}
