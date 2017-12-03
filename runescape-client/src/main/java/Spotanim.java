import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iz")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("SpotAnimationDefinition_indexCache")
   static IndexDataBase SpotAnimationDefinition_indexCache;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("SpotAnimationDefinition_modelIndexCache")
   static IndexDataBase SpotAnimationDefinition_modelIndexCache;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   @Export("spotanims")
   static NodeCache spotanims;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   @Export("SpotAnimationDefinition_cachedModels")
   static NodeCache SpotAnimationDefinition_cachedModels;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1724173847
   )
   @Export("id")
   int id;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1091356547
   )
   int field3412;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 13266031
   )
   public int field3413;
   @ObfuscatedName("f")
   short[] field3422;
   @ObfuscatedName("g")
   short[] field3415;
   @ObfuscatedName("j")
   short[] field3411;
   @ObfuscatedName("x")
   short[] field3414;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -2078782681
   )
   @Export("widthScale")
   int widthScale;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 924320411
   )
   @Export("heightScale")
   int heightScale;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1346987829
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1994156023
   )
   int field3421;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 418860177
   )
   int field3420;

   static {
      spotanims = new NodeCache(64);
      SpotAnimationDefinition_cachedModels = new NodeCache(30);
   }

   Spotanim() {
      this.field3413 = -1;
      this.widthScale = 128;
      this.heightScale = 128;
      this.orientation = 0;
      this.field3421 = 0;
      this.field3420 = 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgh;B)V",
      garbageValue = "58"
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
      signature = "(Lgh;IB)V",
      garbageValue = "22"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3412 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3413 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.widthScale = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.heightScale = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.orientation = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field3421 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field3420 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field3422 = new short[var3];
            this.field3415 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3422[var4] = (short)var1.readUnsignedShort();
               this.field3415[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field3411 = new short[var3];
            this.field3414 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3411[var4] = (short)var1.readUnsignedShort();
               this.field3414[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)Lef;",
      garbageValue = "46"
   )
   @Export("getModel")
   public final Model getModel(int var1) {
      Model var2 = (Model)SpotAnimationDefinition_cachedModels.get((long)this.id);
      if(var2 == null) {
         ModelData var3 = ModelData.method2428(SpotAnimationDefinition_modelIndexCache, this.field3412, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field3422 != null) {
            for(var4 = 0; var4 < this.field3422.length; ++var4) {
               var3.recolor(this.field3422[var4], this.field3415[var4]);
            }
         }

         if(this.field3411 != null) {
            for(var4 = 0; var4 < this.field3411.length; ++var4) {
               var3.method2437(this.field3411[var4], this.field3414[var4]);
            }
         }

         var2 = var3.light(this.field3421 + 64, this.field3420 + 850, -30, -50, -30);
         SpotAnimationDefinition_cachedModels.put(var2, (long)this.id);
      }

      Model var5;
      if(this.field3413 != -1 && var1 != -1) {
         var5 = Permission.getAnimation(this.field3413).method4839(var2, var1);
      } else {
         var5 = var2.method2555(true);
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
