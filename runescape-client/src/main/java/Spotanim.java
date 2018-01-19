import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iy")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("SpotAnimationDefinition_indexCache")
   static IndexDataBase SpotAnimationDefinition_indexCache;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("SpotAnimationDefinition_modelIndexCache")
   static IndexDataBase SpotAnimationDefinition_modelIndexCache;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   @Export("spotanims")
   static NodeCache spotanims;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   @Export("SpotAnimationDefinition_cachedModels")
   static NodeCache SpotAnimationDefinition_cachedModels;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -697985447
   )
   @Export("id")
   int id;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 987061597
   )
   int field3418;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1683015329
   )
   public int field3419;
   @ObfuscatedName("b")
   short[] field3423;
   @ObfuscatedName("e")
   short[] field3421;
   @ObfuscatedName("f")
   short[] field3415;
   @ObfuscatedName("z")
   short[] field3422;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -819269327
   )
   @Export("widthScale")
   int widthScale;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1771214059
   )
   @Export("heightScale")
   int heightScale;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 400209417
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1271061563
   )
   int field3413;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -368778489
   )
   int field3428;

   static {
      spotanims = new NodeCache(64);
      SpotAnimationDefinition_cachedModels = new NodeCache(30);
   }

   Spotanim() {
      this.field3419 = -1;
      this.widthScale = 128;
      this.heightScale = 128;
      this.orientation = 0;
      this.field3413 = 0;
      this.field3428 = 0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lgv;I)V",
      garbageValue = "988466052"
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lgv;II)V",
      garbageValue = "-1958673619"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3418 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3419 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.widthScale = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.heightScale = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.orientation = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field3413 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field3428 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field3423 = new short[var3];
            this.field3421 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3423[var4] = (short)var1.readUnsignedShort();
               this.field3421[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field3415 = new short[var3];
            this.field3422 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3415[var4] = (short)var1.readUnsignedShort();
               this.field3422[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)Les;",
      garbageValue = "41"
   )
   @Export("getModel")
   public final Model getModel(int var1) {
      Model var2 = (Model)SpotAnimationDefinition_cachedModels.get((long)this.id);
      if(var2 == null) {
         ModelData var3 = ModelData.method2483(SpotAnimationDefinition_modelIndexCache, this.field3418, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field3423 != null) {
            for(var4 = 0; var4 < this.field3423.length; ++var4) {
               var3.recolor(this.field3423[var4], this.field3421[var4]);
            }
         }

         if(this.field3415 != null) {
            for(var4 = 0; var4 < this.field3415.length; ++var4) {
               var3.method2486(this.field3415[var4], this.field3422[var4]);
            }
         }

         var2 = var3.light(this.field3413 + 64, this.field3428 + 850, -30, -50, -30);
         SpotAnimationDefinition_cachedModels.put(var2, (long)this.id);
      }

      Model var5;
      if(this.field3419 != -1 && var1 != -1) {
         var5 = class45.getAnimation(this.field3419).method4911(var2, var1);
      } else {
         var5 = var2.method2574(true);
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-819299205"
   )
   public static boolean method4535(int var0) {
      return var0 >= class232.field2945.field2943 && var0 <= class232.field2938.field2943 || var0 == class232.field2936.field2943;
   }
}
