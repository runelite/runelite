import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jw")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   @Export("SpotAnimationDefinition_indexCache")
   public static IndexDataBase SpotAnimationDefinition_indexCache;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   @Export("SpotAnimationDefinition_modelIndexCache")
   public static IndexDataBase SpotAnimationDefinition_modelIndexCache;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("spotanims")
   public static NodeCache spotanims;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("SpotAnimationDefinition_cachedModels")
   public static NodeCache SpotAnimationDefinition_cachedModels;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -365498365
   )
   @Export("id")
   int id;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1785909747
   )
   int field3493;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -336701257
   )
   public int field3494;
   @ObfuscatedName("x")
   short[] field3497;
   @ObfuscatedName("p")
   short[] field3492;
   @ObfuscatedName("g")
   short[] field3496;
   @ObfuscatedName("n")
   short[] field3498;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1089588557
   )
   @Export("widthScale")
   int widthScale;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1069547523
   )
   @Export("heightScale")
   int heightScale;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1777127319
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1049579085
   )
   int field3502;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 381211031
   )
   int field3495;

   static {
      spotanims = new NodeCache(64);
      SpotAnimationDefinition_cachedModels = new NodeCache(30);
   }

   Spotanim() {
      this.field3494 = -1;
      this.widthScale = 128;
      this.heightScale = 128;
      this.orientation = 0;
      this.field3502 = 0;
      this.field3495 = 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgb;B)V",
      garbageValue = "22"
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgb;II)V",
      garbageValue = "1590769380"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3493 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3494 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.widthScale = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.heightScale = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.orientation = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field3502 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field3495 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field3497 = new short[var3];
            this.field3492 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3497[var4] = (short)var1.readUnsignedShort();
               this.field3492[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field3496 = new short[var3];
            this.field3498 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3496[var4] = (short)var1.readUnsignedShort();
               this.field3498[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Lek;",
      garbageValue = "1031842871"
   )
   @Export("getModel")
   public final Model getModel(int var1) {
      Model var2 = (Model)SpotAnimationDefinition_cachedModels.get((long)this.id);
      if(var2 == null) {
         ModelData var3 = ModelData.method2594(SpotAnimationDefinition_modelIndexCache, this.field3493, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field3497 != null) {
            for(var4 = 0; var4 < this.field3497.length; ++var4) {
               var3.recolor(this.field3497[var4], this.field3492[var4]);
            }
         }

         if(this.field3496 != null) {
            for(var4 = 0; var4 < this.field3496.length; ++var4) {
               var3.method2609(this.field3496[var4], this.field3498[var4]);
            }
         }

         var2 = var3.light(this.field3502 + 64, this.field3495 + 850, -30, -50, -30);
         SpotAnimationDefinition_cachedModels.put(var2, (long)this.id);
      }

      Model var5;
      if(this.field3494 != -1 && var1 != -1) {
         var5 = class158.getAnimation(this.field3494).method5180(var2, var1);
      } else {
         var5 = var2.method2697(true);
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Lje;",
      garbageValue = "1193613051"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.objects.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.objects_ref.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         if(var1.isHollow) {
            var1.clipType = 0;
            var1.blocksProjectile = false;
         }

         ObjectComposition.objects.put(var1, (long)var0);
         return var1;
      }
   }
}
