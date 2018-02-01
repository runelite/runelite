import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public class class43 {
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = -1003625395
   )
   static int field535;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -470616927
   )
   int field533;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -545573137
   )
   int field529;
   @ObfuscatedName("w")
   int[][] field530;
   @ObfuscatedName("s")
   int[][] field531;
   @ObfuscatedName("j")
   int[][] field532;
   @ObfuscatedName("a")
   int[][] field528;

   class43(int var1, int var2) {
      this.field533 = var1;
      this.field529 = var2;
      this.field530 = new int[var1][var2];
      this.field531 = new int[var1][var2];
      this.field532 = new int[var1][var2];
      this.field528 = new int[var1][var2];
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIILin;I)V",
      garbageValue = "1375824996"
   )
   void method616(int var1, int var2, int var3, FloorUnderlayDefinition var4) {
      if(var4 != null) {
         if(var3 + var1 >= 0 && var3 + var2 >= 0) {
            if(var1 - var3 <= this.field533 && var2 - var3 <= this.field529) {
               int var5 = Math.max(0, var1 - var3);
               int var6 = Math.min(this.field533, var3 + var1);
               int var7 = Math.max(0, var2 - var3);
               int var8 = Math.min(this.field529, var3 + var2);

               for(int var9 = var5; var9 < var6; ++var9) {
                  for(int var10 = var7; var10 < var8; ++var10) {
                     this.field530[var9][var10] += var4.hue * 256 / var4.hueMultiplier;
                     this.field531[var9][var10] += var4.saturation;
                     this.field532[var9][var10] += var4.lightness;
                     ++this.field528[var9][var10];
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "427833339"
   )
   int method613(int var1, int var2) {
      if(var1 >= 0 && var2 >= 0 && var1 < this.field533 && var2 < this.field529) {
         if(this.field532[var1][var2] == 0) {
            return 0;
         } else {
            int var3 = this.field530[var1][var2] / this.field528[var1][var2];
            int var4 = this.field531[var1][var2] / this.field528[var1][var2];
            int var5 = this.field532[var1][var2] / this.field528[var1][var2];
            double var7 = (double)var3 / 256.0D;
            double var9 = (double)var4 / 256.0D;
            double var11 = (double)var5 / 256.0D;
            double var13 = var11;
            double var15 = var11;
            double var17 = var11;
            if(0.0D != var9) {
               double var19;
               if(var11 < 0.5D) {
                  var19 = var11 * (var9 + 1.0D);
               } else {
                  var19 = var9 + var11 - var9 * var11;
               }

               double var21 = var11 * 2.0D - var19;
               double var23 = 0.3333333333333333D + var7;
               if(var23 > 1.0D) {
                  --var23;
               }

               double var27 = var7 - 0.3333333333333333D;
               if(var27 < 0.0D) {
                  ++var27;
               }

               if(var23 * 6.0D < 1.0D) {
                  var13 = var21 + var23 * 6.0D * (var19 - var21);
               } else if(var23 * 2.0D < 1.0D) {
                  var13 = var19;
               } else if(var23 * 3.0D < 2.0D) {
                  var13 = var21 + 6.0D * (0.6666666666666666D - var23) * (var19 - var21);
               } else {
                  var13 = var21;
               }

               if(var7 * 6.0D < 1.0D) {
                  var15 = var21 + 6.0D * (var19 - var21) * var7;
               } else if(var7 * 2.0D < 1.0D) {
                  var15 = var19;
               } else if(3.0D * var7 < 2.0D) {
                  var15 = var21 + (var19 - var21) * (0.6666666666666666D - var7) * 6.0D;
               } else {
                  var15 = var21;
               }

               if(6.0D * var27 < 1.0D) {
                  var17 = var27 * (var19 - var21) * 6.0D + var21;
               } else if(var27 * 2.0D < 1.0D) {
                  var17 = var19;
               } else if(3.0D * var27 < 2.0D) {
                  var17 = var21 + (0.6666666666666666D - var27) * (var19 - var21) * 6.0D;
               } else {
                  var17 = var21;
               }
            }

            int var29 = (int)(var13 * 256.0D);
            int var20 = (int)(256.0D * var15);
            int var30 = (int)(var17 * 256.0D);
            int var22 = var30 + (var20 << 8) + (var29 << 16);
            return var22;
         }
      } else {
         return 0;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lix;",
      garbageValue = "-1932461221"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.identKits.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.identKit_ref.getConfigData(3, var0);
         var1 = new KitDefinition();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         KitDefinition.identKits.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "97"
   )
   static final int method617(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }

   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      signature = "(IZZZI)Lio;",
      garbageValue = "-1203959477"
   )
   @Export("openCacheIndex")
   static IndexData openCacheIndex(int var0, boolean var1, boolean var2, boolean var3) {
      IndexFile var4 = null;
      if(class157.dat2File != null) {
         var4 = new IndexFile(var0, class157.dat2File, class3.idxFiles[var0], 1000000);
      }

      return new IndexData(var4, class235.indexStore255, var0, var1, var2, var3);
   }
}
