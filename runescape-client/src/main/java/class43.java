import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public class class43 {
   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "Lkm;"
   )
   static IndexedSprite field550;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1572236775
   )
   int field545;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 134384229
   )
   int field551;
   @ObfuscatedName("y")
   int[][] field544;
   @ObfuscatedName("r")
   int[][] field546;
   @ObfuscatedName("h")
   int[][] field548;
   @ObfuscatedName("d")
   int[][] field549;

   class43(int var1, int var2) {
      this.field545 = var1;
      this.field551 = var2;
      this.field544 = new int[var1][var2];
      this.field546 = new int[var1][var2];
      this.field548 = new int[var1][var2];
      this.field549 = new int[var1][var2];
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIILip;I)V",
      garbageValue = "1532890142"
   )
   void method610(int var1, int var2, int var3, FloorUnderlayDefinition var4) {
      if(var4 != null) {
         if(var3 + var1 >= 0 && var3 + var2 >= 0) {
            if(var1 - var3 <= this.field545 && var2 - var3 <= this.field551) {
               int var5 = Math.max(0, var1 - var3);
               int var6 = Math.min(this.field545, var3 + var1);
               int var7 = Math.max(0, var2 - var3);
               int var8 = Math.min(this.field551, var3 + var2);

               for(int var9 = var5; var9 < var6; ++var9) {
                  for(int var10 = var7; var10 < var8; ++var10) {
                     this.field544[var9][var10] += var4.hue * 256 / var4.hueMultiplier;
                     this.field546[var9][var10] += var4.saturation;
                     this.field548[var9][var10] += var4.lightness;
                     ++this.field549[var9][var10];
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "8"
   )
   int method604(int var1, int var2) {
      if(var1 >= 0 && var2 >= 0 && var1 < this.field545 && var2 < this.field551) {
         if(this.field548[var1][var2] == 0) {
            return 0;
         } else {
            int var3 = this.field544[var1][var2] / this.field549[var1][var2];
            int var4 = this.field546[var1][var2] / this.field549[var1][var2];
            int var5 = this.field548[var1][var2] / this.field549[var1][var2];
            return WorldMapType3.method199((double)var3 / 256.0D, (double)var4 / 256.0D, (double)var5 / 256.0D);
         }
      } else {
         return 0;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Lek;",
      garbageValue = "-134013869"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.skeletons.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         var1 = class215.method4021(Sequence.skel_ref, Sequence.skin_ref, var0, false);
         if(var1 != null) {
            Sequence.skeletons.put(var1, (long)var0);
         }

         return var1;
      }
   }

   @ObfuscatedName("gq")
   @ObfuscatedSignature(
      signature = "(Lbm;I)V",
      garbageValue = "695649981"
   )
   static final void method605(Actor var0) {
      int var1 = var0.field1200 - Client.gameCycle;
      int var2 = var0.field1191 * 128 + var0.field1153 * 64;
      int var3 = var0.field1193 * 128 + var0.field1153 * 64;
      var0.x += (var2 - var0.x) / var1;
      var0.y += (var3 - var0.y) / var1;
      var0.field1207 = 0;
      var0.orientation = var0.field1197;
   }

   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "30895095"
   )
   static int method612() {
      return Client.isResized?2:1;
   }
}
