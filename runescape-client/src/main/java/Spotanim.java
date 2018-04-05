import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jg")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   @Export("SpotAnimationDefinition_indexCache")
   static IndexDataBase SpotAnimationDefinition_indexCache;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   @Export("SpotAnimationDefinition_modelIndexCache")
   static IndexDataBase SpotAnimationDefinition_modelIndexCache;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   @Export("spotanims")
   static NodeCache spotanims;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   @Export("SpotAnimationDefinition_cachedModels")
   static NodeCache SpotAnimationDefinition_cachedModels;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -306347873
   )
   @Export("id")
   int id;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 339228759
   )
   int field3487;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -86731201
   )
   public int field3497;
   @ObfuscatedName("i")
   short[] field3488;
   @ObfuscatedName("u")
   short[] field3490;
   @ObfuscatedName("x")
   short[] field3491;
   @ObfuscatedName("y")
   short[] field3492;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1395146475
   )
   @Export("widthScale")
   int widthScale;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 262512693
   )
   @Export("heightScale")
   int heightScale;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1031365287
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1413279299
   )
   int field3496;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1418527187
   )
   int field3489;

   static {
      spotanims = new NodeCache(64);
      SpotAnimationDefinition_cachedModels = new NodeCache(30);
   }

   Spotanim() {
      this.field3497 = -1;
      this.widthScale = 128;
      this.heightScale = 128;
      this.orientation = 0;
      this.field3496 = 0;
      this.field3489 = 0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lgc;I)V",
      garbageValue = "-739145456"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgc;IS)V",
      garbageValue = "-15519"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3487 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3497 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.widthScale = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.heightScale = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.orientation = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field3496 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field3489 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field3488 = new short[var3];
            this.field3490 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3488[var4] = (short)var1.readUnsignedShort();
               this.field3490[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field3491 = new short[var3];
            this.field3492 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3491[var4] = (short)var1.readUnsignedShort();
               this.field3492[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)Lei;",
      garbageValue = "812635196"
   )
   @Export("getModel")
   public final Model getModel(int var1) {
      Model var2 = (Model)SpotAnimationDefinition_cachedModels.get((long)this.id);
      if(var2 == null) {
         ModelData var3 = ModelData.method2645(SpotAnimationDefinition_modelIndexCache, this.field3487, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field3488 != null) {
            for(var4 = 0; var4 < this.field3488.length; ++var4) {
               var3.recolor(this.field3488[var4], this.field3490[var4]);
            }
         }

         if(this.field3491 != null) {
            for(var4 = 0; var4 < this.field3491.length; ++var4) {
               var3.method2613(this.field3491[var4], this.field3492[var4]);
            }
         }

         var2 = var3.light(this.field3496 + 64, this.field3489 + 850, -30, -50, -30);
         SpotAnimationDefinition_cachedModels.put(var2, (long)this.id);
      }

      Model var5;
      if(this.field3497 != -1 && var1 != -1) {
         var5 = CombatInfo1.getAnimation(this.field3497).transformSpotAnimModel(var2, var1);
      } else {
         var5 = var2.toSharedSpotAnimModel(true);
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
}
