import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("co")
@Implements("CodeBook")
public class CodeBook {
   @ObfuscatedName("n")
   @Export("dimensions")
   int dimensions;
   @ObfuscatedName("v")
   @Export("entries")
   int entries;
   @ObfuscatedName("y")
   @Export("entryLengths")
   int[] entryLengths;
   @ObfuscatedName("r")
   int[] field1480;
   @ObfuscatedName("h")
   @Export("valueVector")
   float[][] valueVector;
   @ObfuscatedName("d")
   int[] field1481;

   CodeBook() {
      class105.getInt(24);
      this.dimensions = class105.getInt(16);
      this.entries = class105.getInt(24);
      this.entryLengths = new int[this.entries];
      boolean var1 = class105.getBit() != 0;
      int var2;
      int var3;
      int var5;
      if(var1) {
         var2 = 0;

         for(var3 = class105.getInt(5) + 1; var2 < this.entries; ++var3) {
            int var4 = class105.getInt(ScriptState.ilog(this.entries - var2));

            for(var5 = 0; var5 < var4; ++var5) {
               this.entryLengths[var2++] = var3;
            }
         }
      } else {
         boolean var14 = class105.getBit() != 0;

         for(var3 = 0; var3 < this.entries; ++var3) {
            if(var14 && class105.getBit() == 0) {
               this.entryLengths[var3] = 0;
            } else {
               this.entryLengths[var3] = class105.getInt(5) + 1;
            }
         }
      }

      this.createHuffmanTree();
      var2 = class105.getInt(4);
      if(var2 > 0) {
         float var15 = class105.float32Unpack(class105.getInt(32));
         float var16 = class105.float32Unpack(class105.getInt(32));
         var5 = class105.getInt(4) + 1;
         boolean var6 = class105.getBit() != 0;
         int var7;
         if(var2 == 1) {
            var7 = method1981(this.entries, this.dimensions);
         } else {
            var7 = this.entries * this.dimensions;
         }

         this.field1480 = new int[var7];

         int var8;
         for(var8 = 0; var8 < var7; ++var8) {
            this.field1480[var8] = class105.getInt(var5);
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
                  float var13 = (float)this.field1480[var12] * var16 + var15 + var9;
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
                  float var17 = (float)this.field1480[var10] * var16 + var15 + var9;
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

   @ObfuscatedName("v")
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

      this.field1481 = new int[8];
      int var11 = 0;

      for(var3 = 0; var3 < this.entries; ++var3) {
         var4 = this.entryLengths[var3];
         if(var4 != 0) {
            var5 = var1[var3];
            var6 = 0;

            for(var7 = 0; var7 < var4; ++var7) {
               var8 = Integer.MIN_VALUE >>> var7;
               if((var5 & var8) != 0) {
                  if(this.field1481[var6] == 0) {
                     this.field1481[var6] = var11;
                  }

                  var6 = this.field1481[var6];
               } else {
                  ++var6;
               }

               if(var6 >= this.field1481.length) {
                  int[] var12 = new int[this.field1481.length * 2];

                  for(var10 = 0; var10 < this.field1481.length; ++var10) {
                     var12[var10] = this.field1481[var10];
                  }

                  this.field1481 = var12;
               }

               var8 >>>= 1;
            }

            this.field1481[var6] = ~var3;
            if(var6 >= var11) {
               var11 = var6 + 1;
            }
         }
      }

   }

   @ObfuscatedName("y")
   @Export("getHuffmanRoot")
   int getHuffmanRoot() {
      int var1;
      for(var1 = 0; this.field1481[var1] >= 0; var1 = class105.getBit() != 0?this.field1481[var1]:var1 + 1) {
         ;
      }

      return ~this.field1481[var1];
   }

   @ObfuscatedName("r")
   float[] method1976() {
      return this.valueVector[this.getHuffmanRoot()];
   }

   @ObfuscatedName("n")
   static int method1981(int var0, int var1) {
      int var2;
      for(var2 = (int)Math.pow((double)var0, 1.0D / (double)var1) + 1; class133.method2662(var2, var1) > var0; --var2) {
         ;
      }

      return var2;
   }
}
