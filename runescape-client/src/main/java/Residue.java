import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cu")
@Implements("Residue")
public class Residue {
   @ObfuscatedName("w")
   @Export("type")
   int type;
   @ObfuscatedName("m")
   @Export("begin")
   int begin;
   @ObfuscatedName("q")
   @Export("end")
   int end;
   @ObfuscatedName("b")
   @Export("partitionSize")
   int partitionSize;
   @ObfuscatedName("f")
   @Export("classification")
   int classification;
   @ObfuscatedName("n")
   @Export("classBook")
   int classBook;
   @ObfuscatedName("h")
   int[] field1371;

   Residue() {
      this.type = class92.getInt(16);
      this.begin = class92.getInt(24);
      this.end = class92.getInt(24);
      this.partitionSize = class92.getInt(24) + 1;
      this.classification = class92.getInt(6) + 1;
      this.classBook = class92.getInt(8);
      int[] var1 = new int[this.classification];

      int var2;
      for(var2 = 0; var2 < this.classification; ++var2) {
         int var3 = 0;
         int var4 = class92.getInt(3);
         boolean var5 = class92.getBit() != 0;
         if(var5) {
            var3 = class92.getInt(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.field1371 = new int[this.classification * 8];

      for(var2 = 0; var2 < this.classification * 8; ++var2) {
         this.field1371[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0?class92.getInt(8):-1;
      }

   }

   @ObfuscatedName("w")
   @Export("decodeResidue")
   void decodeResidue(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var1[var4] = 0.0F;
      }

      if(!var3) {
         var4 = class92.codeBooks[this.classBook].dimensions;
         int var5 = this.end - this.begin;
         int var6 = var5 / this.partitionSize;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; ++var8) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if(var8 == 0) {
                  var10 = class92.codeBooks[this.classBook].getHuffmanRoot();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if(var9 + var11 < var6) {
                        var7[var9 + var11] = var10 % this.classification;
                     }

                     var10 /= this.classification;
                  }
               }

               for(var10 = 0; var10 < var4; ++var10) {
                  var11 = var7[var9];
                  int var12 = this.field1371[var8 + var11 * 8];
                  if(var12 >= 0) {
                     int var13 = var9 * this.partitionSize + this.begin;
                     CodeBook var14 = class92.codeBooks[var12];
                     int var15;
                     if(this.type == 0) {
                        var15 = this.partitionSize / var14.dimensions;

                        for(int var16 = 0; var16 < var15; ++var16) {
                           float[] var17 = var14.method2098();

                           for(int var18 = 0; var18 < var14.dimensions; ++var18) {
                              var1[var13 + var16 + var18 * var15] += var17[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.partitionSize) {
                           float[] var19 = var14.method2098();

                           for(int var20 = 0; var20 < var14.dimensions; ++var20) {
                              var1[var13 + var15] += var19[var20];
                              ++var15;
                           }
                        }
                     }
                  }

                  ++var9;
                  if(var9 >= var6) {
                     break;
                  }
               }
            }
         }

      }
   }
}
