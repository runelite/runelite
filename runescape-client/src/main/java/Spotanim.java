import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jk")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   @Export("SpotAnimationDefinition_indexCache")
   static IndexDataBase SpotAnimationDefinition_indexCache;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   @Export("SpotAnimationDefinition_modelIndexCache")
   static IndexDataBase SpotAnimationDefinition_modelIndexCache;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("spotanims")
   static NodeCache spotanims;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("SpotAnimationDefinition_cachedModels")
   static NodeCache SpotAnimationDefinition_cachedModels;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1437385687
   )
   @Export("id")
   int id;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1088636275
   )
   int field3424;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1215512363
   )
   public int field3425;
   @ObfuscatedName("y")
   short[] field3422;
   @ObfuscatedName("g")
   short[] field3427;
   @ObfuscatedName("c")
   short[] field3428;
   @ObfuscatedName("u")
   short[] field3429;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 415230347
   )
   @Export("widthScale")
   int widthScale;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -562066339
   )
   @Export("heightScale")
   int heightScale;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 641058867
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2024842385
   )
   int field3433;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1062372135
   )
   int field3434;

   static {
      spotanims = new NodeCache(64);
      SpotAnimationDefinition_cachedModels = new NodeCache(30);
   }

   Spotanim() {
      this.field3425 = -1;
      this.widthScale = 128;
      this.heightScale = 128;
      this.orientation = 0;
      this.field3433 = 0;
      this.field3434 = 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgn;B)V",
      garbageValue = "-28"
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lgn;II)V",
      garbageValue = "854828152"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3424 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3425 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.widthScale = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.heightScale = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.orientation = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field3433 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field3434 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field3422 = new short[var3];
            this.field3427 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3422[var4] = (short)var1.readUnsignedShort();
               this.field3427[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field3428 = new short[var3];
            this.field3429 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3428[var4] = (short)var1.readUnsignedShort();
               this.field3429[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)Lee;",
      garbageValue = "76"
   )
   @Export("getModel")
   public final Model getModel(int var1) {
      Model var2 = (Model)SpotAnimationDefinition_cachedModels.get((long)this.id);
      if(var2 == null) {
         ModelData var3 = ModelData.method2601(SpotAnimationDefinition_modelIndexCache, this.field3424, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field3422 != null) {
            for(var4 = 0; var4 < this.field3422.length; ++var4) {
               var3.recolor(this.field3422[var4], this.field3427[var4]);
            }
         }

         if(this.field3428 != null) {
            for(var4 = 0; var4 < this.field3428.length; ++var4) {
               var3.method2614(this.field3428[var4], this.field3429[var4]);
            }
         }

         var2 = var3.light(this.field3433 + 64, this.field3434 + 850, -30, -50, -30);
         SpotAnimationDefinition_cachedModels.put(var2, (long)this.id);
      }

      Model var5;
      if(this.field3425 != -1 && var1 != -1) {
         var5 = Occluder.getAnimation(this.field3425).method5133(var2, var1);
      } else {
         var5 = var2.method2704(true);
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lbs;Lbs;IZIZI)I",
      garbageValue = "-162807461"
   )
   static int method4794(World var0, World var1, int var2, boolean var3, int var4, boolean var5) {
      int var6 = class92.method1926(var0, var1, var2, var3);
      if(var6 != 0) {
         return var3?-var6:var6;
      } else if(var4 == -1) {
         return 0;
      } else {
         int var7 = class92.method1926(var0, var1, var4, var5);
         return var5?-var7:var7;
      }
   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "-2123974862"
   )
   static final void method4793(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class2.loadWidget(var0)) {
         Overlay.field3668 = null;
         VertexNormal.gameDraw(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(Overlay.field3668 != null) {
            VertexNormal.gameDraw(Overlay.field3668, -1412584499, var1, var2, var3, var4, ItemContainer.field721, CombatInfo2.field3469, var7);
            Overlay.field3668 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field979[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field979[var8] = true;
            }
         }

      }
   }
}
