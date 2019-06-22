import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("io")
@Implements("SpotAnimationDefinition")
public class SpotAnimationDefinition extends DualNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("SpotAnimationDefinition_indexCache")
   public static AbstractIndexCache SpotAnimationDefinition_indexCache;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("SpotAnimationDefinition_modelIndexCache")
   public static AbstractIndexCache SpotAnimationDefinition_modelIndexCache;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("SpotAnimationDefinition_cached")
   static EvictingDualNodeHashTable SpotAnimationDefinition_cached;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("SpotAnimationDefinition_cachedModels")
   static EvictingDualNodeHashTable SpotAnimationDefinition_cachedModels;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -713866165
   )
   @Export("id")
   int id;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2065492247
   )
   @Export("archive")
   int archive;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1580078789
   )
   @Export("sequence")
   public int sequence;
   @ObfuscatedName("l")
   @Export("recolorFrom")
   short[] recolorFrom;
   @ObfuscatedName("e")
   @Export("recolorTo")
   short[] recolorTo;
   @ObfuscatedName("x")
   @Export("retextureFrom")
   short[] retextureFrom;
   @ObfuscatedName("d")
   @Export("retextureTo")
   short[] retextureTo;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 680796997
   )
   @Export("widthScale")
   int widthScale;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1199960995
   )
   @Export("heightScale")
   int heightScale;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1650590363
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -20619847
   )
   @Export("__a")
   int __a;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1866148625
   )
   @Export("__z")
   int __z;

   SpotAnimationDefinition() {
      this.sequence = -1;
      this.widthScale = 128;
      this.heightScale = 128;
      this.orientation = 0;
      this.__a = 0;
      this.__z = 0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "906815828"
   )
   @Export("read")
   void read(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgr;II)V",
      garbageValue = "2099681848"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.archive = var1.__ag_302();
      } else if(var2 == 2) {
         this.sequence = var1.__ag_302();
      } else if(var2 == 4) {
         this.widthScale = var1.__ag_302();
      } else if(var2 == 5) {
         this.heightScale = var1.__ag_302();
      } else if(var2 == 6) {
         this.orientation = var1.__ag_302();
      } else if(var2 == 7) {
         this.__a = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.__z = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.recolorFrom = new short[var3];
            this.recolorTo = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.recolorFrom[var4] = (short)var1.__ag_302();
               this.recolorTo[var4] = (short)var1.__ag_302();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.retextureFrom = new short[var3];
            this.retextureTo = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.retextureFrom[var4] = (short)var1.__ag_302();
               this.retextureTo[var4] = (short)var1.__ag_302();
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Ldu;",
      garbageValue = "-77614529"
   )
   @Export("getModel")
   public final Model getModel(int var1) {
      Model var2 = (Model)SpotAnimationDefinition_cachedModels.get((long)this.id);
      if(var2 == null) {
         ModelData var3 = ModelData.method2788(SpotAnimationDefinition_modelIndexCache, this.archive, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.recolorFrom != null) {
            for(var4 = 0; var4 < this.recolorFrom.length; ++var4) {
               var3.recolor(this.recolorFrom[var4], this.recolorTo[var4]);
            }
         }

         if(this.retextureFrom != null) {
            for(var4 = 0; var4 < this.retextureFrom.length; ++var4) {
               var3.retexture(this.retextureFrom[var4], this.retextureTo[var4]);
            }
         }

         var2 = var3.toModel(this.__a + 64, this.__z + 850, -30, -50, -30);
         SpotAnimationDefinition_cachedModels.put(var2, (long)this.id);
      }

      Model var5;
      if(this.sequence != -1 && var1 != -1) {
         var5 = WorldMapAreaData.getSequenceDefinition(this.sequence).animateSpotAnimation(var2, var1);
      } else {
         var5 = var2.toSharedSpotAnimationModel(true);
      }

      if(this.widthScale != 128 || this.heightScale != 128) {
         var5.scale(this.widthScale, this.heightScale, this.widthScale);
      }

      if(this.orientation != 0) {
         if(this.orientation == 90) {
            var5.rotateY90Ccw();
         }

         if(this.orientation == 180) {
            var5.rotateY90Ccw();
            var5.rotateY90Ccw();
         }

         if(this.orientation == 270) {
            var5.rotateY90Ccw();
            var5.rotateY90Ccw();
            var5.rotateY90Ccw();
         }
      }

      return var5;
   }

   @ObfuscatedName("gn")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "95"
   )
   static int method4822() {
      return Client.isResizable?2:1;
   }

   static {
      SpotAnimationDefinition_cached = new EvictingDualNodeHashTable(64);
      SpotAnimationDefinition_cachedModels = new EvictingDualNodeHashTable(30);
   }
}
