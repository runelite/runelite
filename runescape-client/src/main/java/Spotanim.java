import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iz")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("SpotAnimationDefinition_indexCache")
   static IndexDataBase SpotAnimationDefinition_indexCache;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   @Export("spotanims")
   static NodeCache spotanims;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   @Export("SpotAnimationDefinition_cachedModels")
   static NodeCache SpotAnimationDefinition_cachedModels;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1075787503
   )
   @Export("id")
   int id;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1373189613
   )
   int field3291;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -92331913
   )
   public int field3292;
   @ObfuscatedName("x")
   short[] field3289;
   @ObfuscatedName("j")
   short[] field3294;
   @ObfuscatedName("a")
   short[] field3301;
   @ObfuscatedName("l")
   short[] field3296;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 380474301
   )
   @Export("widthScale")
   int widthScale;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -119979769
   )
   @Export("heightScale")
   int heightScale;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 818209207
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 745529987
   )
   int field3293;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1021149467
   )
   int field3297;

   static {
      spotanims = new NodeCache(64);
      SpotAnimationDefinition_cachedModels = new NodeCache(30);
   }

   Spotanim() {
      this.field3292 = -1;
      this.widthScale = 128;
      this.heightScale = 128;
      this.orientation = 0;
      this.field3293 = 0;
      this.field3297 = 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "317387597"
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "-1069439507"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3291 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3292 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.widthScale = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.heightScale = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.orientation = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field3293 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field3297 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field3289 = new short[var3];
            this.field3294 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3289[var4] = (short)var1.readUnsignedShort();
               this.field3294[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field3301 = new short[var3];
            this.field3296 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3301[var4] = (short)var1.readUnsignedShort();
               this.field3296[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Ldk;",
      garbageValue = "-15359933"
   )
   @Export("getModel")
   public final Model getModel(int var1) {
      Model var2 = (Model)SpotAnimationDefinition_cachedModels.get((long)this.id);
      if(var2 == null) {
         ModelData var3 = ModelData.method2619(Varcs.SpotAnimationDefinition_modelIndexCache, this.field3291, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field3289 != null) {
            for(var4 = 0; var4 < this.field3289.length; ++var4) {
               var3.recolor(this.field3289[var4], this.field3294[var4]);
            }
         }

         if(this.field3301 != null) {
            for(var4 = 0; var4 < this.field3301.length; ++var4) {
               var3.method2632(this.field3301[var4], this.field3296[var4]);
            }
         }

         var2 = var3.light(this.field3293 + 64, this.field3297 + 850, -30, -50, -30);
         SpotAnimationDefinition_cachedModels.put(var2, (long)this.id);
      }

      Model var5;
      if(this.field3292 != -1 && var1 != -1) {
         var5 = class137.getAnimation(this.field3292).transformSpotAnimModel(var2, var1);
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
