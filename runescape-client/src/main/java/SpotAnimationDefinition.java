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
   @Export("SpotAnimationDefinition_archive")
   public static AbstractArchive SpotAnimationDefinition_archive;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("SpotAnimationDefinition_modelArchive")
   public static AbstractArchive SpotAnimationDefinition_modelArchive;
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
   int field876;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1866148625
   )
   int field877;

   SpotAnimationDefinition() {
      this.sequence = -1;
      this.widthScale = 128;
      this.heightScale = 128;
      this.orientation = 0;
      this.field876 = 0;
      this.field877 = 0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "906815828"
   )
   @Export("decode")
   void decode(Buffer buffer) {
      while (true) {
         int var2 = buffer.readUnsignedByte();
         if (var2 == 0) {
            return;
         }

         this.decodeNext(buffer, var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgr;II)V",
      garbageValue = "2099681848"
   )
   @Export("decodeNext")
   void decodeNext(Buffer buffer, int var2) {
      if (var2 == 1) {
         this.archive = buffer.readUnsignedShort();
      } else if (var2 == 2) {
         this.sequence = buffer.readUnsignedShort();
      } else if (var2 == 4) {
         this.widthScale = buffer.readUnsignedShort();
      } else if (var2 == 5) {
         this.heightScale = buffer.readUnsignedShort();
      } else if (var2 == 6) {
         this.orientation = buffer.readUnsignedShort();
      } else if (var2 == 7) {
         this.field876 = buffer.readUnsignedByte();
      } else if (var2 == 8) {
         this.field877 = buffer.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if (var2 == 40) {
            var3 = buffer.readUnsignedByte();
            this.recolorFrom = new short[var3];
            this.recolorTo = new short[var3];

            for (var4 = 0; var4 < var3; ++var4) {
               this.recolorFrom[var4] = (short)buffer.readUnsignedShort();
               this.recolorTo[var4] = (short)buffer.readUnsignedShort();
            }
         } else if (var2 == 41) {
            var3 = buffer.readUnsignedByte();
            this.retextureFrom = new short[var3];
            this.retextureTo = new short[var3];

            for (var4 = 0; var4 < var3; ++var4) {
               this.retextureFrom[var4] = (short)buffer.readUnsignedShort();
               this.retextureTo[var4] = (short)buffer.readUnsignedShort();
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
      if (var2 == null) {
         ModelData var3 = ModelData.method2788(SpotAnimationDefinition_modelArchive, this.archive, 0);
         if (var3 == null) {
            return null;
         }

         int var4;
         if (this.recolorFrom != null) {
            for (var4 = 0; var4 < this.recolorFrom.length; ++var4) {
               var3.recolor(this.recolorFrom[var4], this.recolorTo[var4]);
            }
         }

         if (this.retextureFrom != null) {
            for (var4 = 0; var4 < this.retextureFrom.length; ++var4) {
               var3.retexture(this.retextureFrom[var4], this.retextureTo[var4]);
            }
         }

         var2 = var3.toModel(this.field876 + 64, this.field877 + 850, -30, -50, -30);
         SpotAnimationDefinition_cachedModels.put(var2, (long)this.id);
      }

      Model var5;
      if (this.sequence != -1 && var1 != -1) {
         var5 = WorldMapAreaData.getSequenceDefinition(this.sequence).animateSpotAnimation(var2, var1);
      } else {
         var5 = var2.toSharedSpotAnimationModel(true);
      }

      if (this.widthScale != 128 || this.heightScale != 128) {
         var5.scale(this.widthScale, this.heightScale, this.widthScale);
      }

      if (this.orientation != 0) {
         if (this.orientation == 90) {
            var5.rotateY90Ccw();
         }

         if (this.orientation == 180) {
            var5.rotateY90Ccw();
            var5.rotateY90Ccw();
         }

         if (this.orientation == 270) {
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
   @Export("getWindowedMode")
   static int getWindowedMode() {
      return Client.isResizable ? 2 : 1;
   }

   static {
      SpotAnimationDefinition_cached = new EvictingDualNodeHashTable(64);
      SpotAnimationDefinition_cachedModels = new EvictingDualNodeHashTable(30);
   }
}
