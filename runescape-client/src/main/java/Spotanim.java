import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jg")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   @Export("SpotAnimationDefinition_indexCache")
   static IndexDataBase SpotAnimationDefinition_indexCache;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("spotanims")
   static NodeCache spotanims;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("SpotAnimationDefinition_cachedModels")
   static NodeCache SpotAnimationDefinition_cachedModels;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 707682133
   )
   @Export("id")
   int id;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 398420221
   )
   int field3488;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1645614819
   )
   public int field3494;
   @ObfuscatedName("p")
   short[] field3490;
   @ObfuscatedName("w")
   short[] field3491;
   @ObfuscatedName("r")
   short[] field3492;
   @ObfuscatedName("d")
   short[] field3487;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1719168513
   )
   @Export("widthScale")
   int widthScale;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 798892181
   )
   @Export("heightScale")
   int heightScale;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1766198743
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1885921561
   )
   int field3484;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -921672527
   )
   int field3498;

   static {
      spotanims = new NodeCache(64);
      SpotAnimationDefinition_cachedModels = new NodeCache(30);
   }

   Spotanim() {
      this.field3494 = -1;
      this.widthScale = 128;
      this.heightScale = 128;
      this.orientation = 0;
      this.field3484 = 0;
      this.field3498 = 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgp;B)V",
      garbageValue = "0"
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lgp;II)V",
      garbageValue = "1872578810"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3488 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3494 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.widthScale = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.heightScale = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.orientation = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field3484 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field3498 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field3490 = new short[var3];
            this.field3491 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3490[var4] = (short)var1.readUnsignedShort();
               this.field3491[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field3492 = new short[var3];
            this.field3487 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3492[var4] = (short)var1.readUnsignedShort();
               this.field3487[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Led;",
      garbageValue = "-1009385808"
   )
   @Export("getModel")
   public final Model getModel(int var1) {
      Model var2 = (Model)SpotAnimationDefinition_cachedModels.get((long)this.id);
      if(var2 == null) {
         ModelData var3 = ModelData.method2583(Frames.SpotAnimationDefinition_modelIndexCache, this.field3488, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field3490 != null) {
            for(var4 = 0; var4 < this.field3490.length; ++var4) {
               var3.recolor(this.field3490[var4], this.field3491[var4]);
            }
         }

         if(this.field3492 != null) {
            for(var4 = 0; var4 < this.field3492.length; ++var4) {
               var3.method2660(this.field3492[var4], this.field3487[var4]);
            }
         }

         var2 = var3.light(this.field3484 + 64, this.field3498 + 850, -30, -50, -30);
         SpotAnimationDefinition_cachedModels.put(var2, (long)this.id);
      }

      Model var5;
      if(this.field3494 != -1 && var1 != -1) {
         var5 = ISAACCipher.getAnimation(this.field3494).transformSpotAnimModel(var2, var1);
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

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "12"
   )
   static void method4799(Component var0) {
      var0.addMouseListener(MouseInput.mouse);
      var0.addMouseMotionListener(MouseInput.mouse);
      var0.addFocusListener(MouseInput.mouse);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "39"
   )
   public static void method4810() {
      VarPlayerType.varplayers.reset();
   }
}
