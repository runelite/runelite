import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("du")
@Implements("CodeBook")
public class CodeBook {
   @ObfuscatedName("g")
   @Export("valueVector")
   float[][] valueVector;
   @ObfuscatedName("o")
   @Export("entries")
   int entries;
   @ObfuscatedName("m")
   int[] field1536;
   @ObfuscatedName("i")
   @Export("entryLengths")
   int[] entryLengths;
   @ObfuscatedName("c")
   @Export("dimensions")
   int dimensions;
   @ObfuscatedName("u")
   int[] field1535;

   CodeBook() {
      class106.getInt(24);
      this.dimensions = class106.getInt(16);
      this.entries = class106.getInt(24);
      this.entryLengths = new int[this.entries];
      boolean var1 = class106.getBit() != 0;
      int var2;
      int var3;
      int var5;
      if(var1) {
         var2 = 0;

         for(var3 = class106.getInt(5) + 1; var2 < this.entries; ++var3) {
            int var4 = class106.getInt(class1.ilog(this.entries - var2));

            for(var5 = 0; var5 < var4; ++var5) {
               this.entryLengths[var2++] = var3;
            }
         }
      } else {
         boolean var14 = class106.getBit() != 0;

         for(var3 = 0; var3 < this.entries; ++var3) {
            if(var14 && class106.getBit() == 0) {
               this.entryLengths[var3] = 0;
            } else {
               this.entryLengths[var3] = class106.getInt(5) + 1;
            }
         }
      }

      this.createHuffmanTree();
      var2 = class106.getInt(4);
      if(var2 > 0) {
         float var15 = class106.float32Unpack(class106.getInt(32));
         float var16 = class106.float32Unpack(class106.getInt(32));
         var5 = class106.getInt(4) + 1;
         boolean var6 = class106.getBit() != 0;
         int var7;
         if(var2 == 1) {
            var7 = method1851(this.entries, this.dimensions);
         } else {
            var7 = this.entries * this.dimensions;
         }

         this.field1535 = new int[var7];

         int var8;
         for(var8 = 0; var8 < var7; ++var8) {
            this.field1535[var8] = class106.getInt(var5);
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
                  float var13 = (float)this.field1535[var12] * var16 + var15 + var9;
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
                  float var17 = (float)this.field1535[var10] * var16 + var15 + var9;
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

   @ObfuscatedName("i")
   @Export("getHuffmanRoot")
   int getHuffmanRoot() {
      int var1;
      for(var1 = 0; this.field1536[var1] >= 0; var1 = class106.getBit() != 0?this.field1536[var1]:var1 + 1) {
         ;
      }

      return ~this.field1536[var1];
   }

   @ObfuscatedName("u")
   float[] method1862() {
      return this.valueVector[this.getHuffmanRoot()];
   }

   @ObfuscatedName("o")
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
            int var9;
            if((var6 & var5) != 0) {
               var7 = var2[var4 - 1];
            } else {
               var7 = var6 | var5;

               for(var8 = var4 - 1; var8 >= 1; --var8) {
                  var9 = var2[var8];
                  if(var9 != var6) {
                     break;
                  }

                  var10 = 1 << 32 - var8;
                  if((var9 & var10) != 0) {
                     var2[var8] = var2[var8 - 1];
                     break;
                  }

                  var2[var8] = var9 | var10;
               }
            }

            var2[var4] = var7;

            for(var8 = var4 + 1; var8 <= 32; ++var8) {
               var9 = var2[var8];
               if(var9 == var6) {
                  var2[var8] = var7;
               }
            }
         }
      }

      this.field1536 = new int[8];
      int var11 = 0;

      for(var3 = 0; var3 < this.entries; ++var3) {
         var4 = this.entryLengths[var3];
         if(var4 != 0) {
            var5 = var1[var3];
            var6 = 0;

            for(var7 = 0; var7 < var4; ++var7) {
               var8 = Integer.MIN_VALUE >>> var7;
               if((var5 & var8) != 0) {
                  if(this.field1536[var6] == 0) {
                     this.field1536[var6] = var11;
                  }

                  var6 = this.field1536[var6];
               } else {
                  ++var6;
               }

               if(var6 >= this.field1536.length) {
                  int[] var12 = new int[this.field1536.length * 2];

                  for(var10 = 0; var10 < this.field1536.length; ++var10) {
                     var12[var10] = this.field1536[var10];
                  }

                  this.field1536 = var12;
               }

               var8 >>>= 1;
            }

            this.field1536[var6] = ~var3;
            if(var6 >= var11) {
               var11 = var6 + 1;
            }
         }
      }

   }

   @ObfuscatedName("c")
   static int method1851(int var0, int var1) {
      int var2 = (int)Math.pow((double)var0, 1.0D / (double)var1) + 1;

      while(true) {
         int var4 = var2;
         int var5 = var1;

         int var6;
         for(var6 = 1; var5 > 1; var5 >>= 1) {
            if((var5 & 1) != 0) {
               var6 *= var4;
            }

            var4 *= var4;
         }

         int var3;
         if(var5 == 1) {
            var3 = var6 * var4;
         } else {
            var3 = var6;
         }

         if(var3 <= var0) {
            return var2;
         }

         --var2;
      }
   }
}
