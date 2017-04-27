import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bp")
@Implements("SoundEffect3")
public class SoundEffect3 {
   @ObfuscatedName("u")
   static int[][] field1111 = new int[2][8];
   @ObfuscatedName("t")
   int[] field1112 = new int[2];
   @ObfuscatedName("q")
   int[][][] field1113 = new int[2][2][4];
   @ObfuscatedName("d")
   int[] field1114 = new int[2];
   @ObfuscatedName("p")
   static float[][] field1115 = new float[2][8];
   @ObfuscatedName("n")
   int[][][] field1116 = new int[2][2][4];
   @ObfuscatedName("z")
   static float field1117;
   @ObfuscatedName("l")
   static int field1118;

   @ObfuscatedName("n")
   float method1345(int var1, int var2, float var3) {
      float var4 = (float)this.field1116[var1][0][var2] + var3 * (float)(this.field1116[var1][1][var2] - this.field1116[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return method1346(var4);
   }

   @ObfuscatedName("c")
   static float method1346(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }

   @ObfuscatedName("q")
   int method1347(int var1, float var2) {
      float var3;
      if(var1 == 0) {
         var3 = (float)this.field1112[0] + (float)(this.field1112[1] - this.field1112[0]) * var2;
         var3 *= 0.0030517578F;
         field1117 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
         field1118 = (int)(field1117 * 65536.0F);
      }

      if(this.field1114[var1] == 0) {
         return 0;
      } else {
         var3 = this.method1348(var1, 0, var2);
         field1115[var1][0] = -2.0F * var3 * (float)Math.cos((double)this.method1345(var1, 0, var2));
         field1115[var1][1] = var3 * var3;

         int var4;
         for(var4 = 1; var4 < this.field1114[var1]; ++var4) {
            var3 = this.method1348(var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)this.method1345(var1, var4, var2));
            float var6 = var3 * var3;
            field1115[var1][var4 * 2 + 1] = field1115[var1][var4 * 2 - 1] * var6;
            field1115[var1][var4 * 2] = field1115[var1][var4 * 2 - 1] * var5 + field1115[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               field1115[var1][var7] += field1115[var1][var7 - 1] * var5 + field1115[var1][var7 - 2] * var6;
            }

            field1115[var1][1] += field1115[var1][0] * var5 + var6;
            field1115[var1][0] += var5;
         }

         if(var1 == 0) {
            for(var4 = 0; var4 < this.field1114[0] * 2; ++var4) {
               field1115[0][var4] *= field1117;
            }
         }

         for(var4 = 0; var4 < this.field1114[var1] * 2; ++var4) {
            field1111[var1][var4] = (int)(field1115[var1][var4] * 65536.0F);
         }

         return this.field1114[var1] * 2;
      }
   }

   @ObfuscatedName("d")
   float method1348(int var1, int var2, float var3) {
      float var4 = (float)this.field1113[var1][0][var2] + var3 * (float)(this.field1113[var1][1][var2] - this.field1113[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }

   @ObfuscatedName("t")
   final void method1358(Buffer var1, SoundEffect2 var2) {
      int var3 = var1.readUnsignedByte();
      this.field1114[0] = var3 >> 4;
      this.field1114[1] = var3 & 15;
      if(var3 != 0) {
         this.field1112[0] = var1.readUnsignedShort();
         this.field1112[1] = var1.readUnsignedShort();
         int var4 = var1.readUnsignedByte();

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1114[var5]; ++var6) {
               this.field1116[var5][0][var6] = var1.readUnsignedShort();
               this.field1113[var5][0][var6] = var1.readUnsignedShort();
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < this.field1114[var5]; ++var6) {
               if((var4 & 1 << var5 * 4 << var6) != 0) {
                  this.field1116[var5][1][var6] = var1.readUnsignedShort();
                  this.field1113[var5][1][var6] = var1.readUnsignedShort();
               } else {
                  this.field1116[var5][1][var6] = this.field1116[var5][0][var6];
                  this.field1113[var5][1][var6] = this.field1113[var5][0][var6];
               }
            }
         }

         if(var4 != 0 || this.field1112[1] != this.field1112[0]) {
            var2.method1121(var1);
         }
      } else {
         int[] var7 = this.field1112;
         this.field1112[1] = 0;
         var7[0] = 0;
      }

   }
}
