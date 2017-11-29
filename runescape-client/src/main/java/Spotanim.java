import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ix")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   @Export("SpotAnimationDefinition_indexCache")
   public static IndexDataBase SpotAnimationDefinition_indexCache;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   @Export("SpotAnimationDefinition_modelIndexCache")
   public static IndexDataBase SpotAnimationDefinition_modelIndexCache;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("spotanims")
   public static NodeCache spotanims;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("SpotAnimationDefinition_cachedModels")
   public static NodeCache SpotAnimationDefinition_cachedModels;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -233073101
   )
   @Export("id")
   int id;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1733485207
   )
   int field3398;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -832145035
   )
   public int field3393;
   @ObfuscatedName("t")
   short[] field3399;
   @ObfuscatedName("p")
   short[] field3401;
   @ObfuscatedName("r")
   short[] field3400;
   @ObfuscatedName("l")
   short[] field3403;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 958592559
   )
   @Export("widthScale")
   int widthScale;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 24227449
   )
   @Export("heightScale")
   int heightScale;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 273348759
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1580516675
   )
   int field3407;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1214887899
   )
   int field3408;

   static {
      spotanims = new NodeCache(64);
      SpotAnimationDefinition_cachedModels = new NodeCache(30);
   }

   Spotanim() {
      this.field3393 = -1;
      this.widthScale = 128;
      this.heightScale = 128;
      this.orientation = 0;
      this.field3407 = 0;
      this.field3408 = 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfr;I)V",
      garbageValue = "1613103659"
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lfr;II)V",
      garbageValue = "712425166"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3398 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3393 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.widthScale = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.heightScale = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.orientation = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field3407 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field3408 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field3399 = new short[var3];
            this.field3401 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3399[var4] = (short)var1.readUnsignedShort();
               this.field3401[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field3400 = new short[var3];
            this.field3403 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3400[var4] = (short)var1.readUnsignedShort();
               this.field3403[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)Leh;",
      garbageValue = "1872388478"
   )
   @Export("getModel")
   public final Model getModel(int var1) {
      Model var2 = (Model)SpotAnimationDefinition_cachedModels.get((long)this.id);
      if(var2 == null) {
         ModelData var3 = ModelData.method2510(SpotAnimationDefinition_modelIndexCache, this.field3398, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field3399 != null) {
            for(var4 = 0; var4 < this.field3399.length; ++var4) {
               var3.recolor(this.field3399[var4], this.field3401[var4]);
            }
         }

         if(this.field3400 != null) {
            for(var4 = 0; var4 < this.field3400.length; ++var4) {
               var3.method2523(this.field3400[var4], this.field3403[var4]);
            }
         }

         var2 = var3.light(this.field3407 + 64, this.field3408 + 850, -30, -50, -30);
         SpotAnimationDefinition_cachedModels.put(var2, (long)this.id);
      }

      Model var5;
      if(this.field3393 != -1 && var1 != -1) {
         var5 = GrandExchangeEvents.getAnimation(this.field3393).method4884(var2, var1);
      } else {
         var5 = var2.method2620(true);
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
