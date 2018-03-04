import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jq")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   @Export("SpotAnimationDefinition_indexCache")
   public static IndexDataBase SpotAnimationDefinition_indexCache;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   @Export("SpotAnimationDefinition_modelIndexCache")
   public static IndexDataBase SpotAnimationDefinition_modelIndexCache;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   @Export("spotanims")
   static NodeCache spotanims;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   @Export("SpotAnimationDefinition_cachedModels")
   static NodeCache SpotAnimationDefinition_cachedModels;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1780242985
   )
   @Export("id")
   int id;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1629455823
   )
   int field3483;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1226175559
   )
   public int field3484;
   @ObfuscatedName("s")
   short[] field3478;
   @ObfuscatedName("p")
   short[] field3486;
   @ObfuscatedName("x")
   short[] field3479;
   @ObfuscatedName("m")
   short[] field3488;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1996245643
   )
   @Export("widthScale")
   int widthScale;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 803440197
   )
   @Export("heightScale")
   int heightScale;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1339432965
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1995927127
   )
   int field3492;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1249977937
   )
   int field3485;

   static {
      spotanims = new NodeCache(64);
      SpotAnimationDefinition_cachedModels = new NodeCache(30);
   }

   Spotanim() {
      this.field3484 = -1;
      this.widthScale = 128;
      this.heightScale = 128;
      this.orientation = 0;
      this.field3492 = 0;
      this.field3485 = 0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "1954777491"
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "-924916038"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3483 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3484 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.widthScale = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.heightScale = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.orientation = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field3492 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field3485 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field3478 = new short[var3];
            this.field3486 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3478[var4] = (short)var1.readUnsignedShort();
               this.field3486[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field3479 = new short[var3];
            this.field3488 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3479[var4] = (short)var1.readUnsignedShort();
               this.field3488[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Lel;",
      garbageValue = "192805567"
   )
   @Export("getModel")
   public final Model getModel(int var1) {
      Model var2 = (Model)SpotAnimationDefinition_cachedModels.get((long)this.id);
      if(var2 == null) {
         ModelData var3 = ModelData.method2660(SpotAnimationDefinition_modelIndexCache, this.field3483, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field3478 != null) {
            for(var4 = 0; var4 < this.field3478.length; ++var4) {
               var3.recolor(this.field3478[var4], this.field3486[var4]);
            }
         }

         if(this.field3479 != null) {
            for(var4 = 0; var4 < this.field3479.length; ++var4) {
               var3.method2674(this.field3479[var4], this.field3488[var4]);
            }
         }

         var2 = var3.light(this.field3492 + 64, this.field3485 + 850, -30, -50, -30);
         SpotAnimationDefinition_cachedModels.put(var2, (long)this.id);
      }

      Model var5;
      if(this.field3484 != -1 && var1 != -1) {
         var5 = class270.getAnimation(this.field3484).method5305(var2, var1);
      } else {
         var5 = var2.method2781(true);
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
