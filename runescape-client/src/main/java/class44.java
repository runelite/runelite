import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class44 {
   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("indexCache4")
   static IndexData indexCache4;
   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("indexModels")
   static IndexData indexModels;
   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("indexSprites")
   static IndexData indexSprites;
   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "[Llq;"
   )
   @Export("modIconSprites")
   static IndexedSprite[] modIconSprites;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1413508267
   )
   int field540;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2044415841
   )
   int field541;
   @ObfuscatedName("o")
   int[][] field542;
   @ObfuscatedName("j")
   int[][] field543;
   @ObfuscatedName("k")
   int[][] field544;
   @ObfuscatedName("x")
   int[][] field547;

   class44(int var1, int var2) {
      this.field540 = var1;
      this.field541 = var2;
      this.field542 = new int[var1][var2];
      this.field543 = new int[var1][var2];
      this.field544 = new int[var1][var2];
      this.field547 = new int[var1][var2];
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIILjx;I)V",
      garbageValue = "-2107654868"
   )
   void method650(int var1, int var2, int var3, FloorUnderlayDefinition var4) {
      if(var4 != null) {
         if(var3 + var1 >= 0 && var3 + var2 >= 0) {
            if(var1 - var3 <= this.field540 && var2 - var3 <= this.field541) {
               int var5 = Math.max(0, var1 - var3);
               int var6 = Math.min(this.field540, var3 + var1);
               int var7 = Math.max(0, var2 - var3);
               int var8 = Math.min(this.field541, var3 + var2);

               for(int var9 = var5; var9 < var6; ++var9) {
                  for(int var10 = var7; var10 < var8; ++var10) {
                     this.field542[var9][var10] += var4.hue * 256 / var4.hueMultiplier;
                     this.field543[var9][var10] += var4.saturation;
                     this.field544[var9][var10] += var4.lightness;
                     ++this.field547[var9][var10];
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "98"
   )
   int method659(int var1, int var2) {
      if(var1 >= 0 && var2 >= 0 && var1 < this.field540 && var2 < this.field541) {
         if(this.field544[var1][var2] == 0) {
            return 0;
         } else {
            int var3 = this.field542[var1][var2] / this.field547[var1][var2];
            int var4 = this.field543[var1][var2] / this.field547[var1][var2];
            int var5 = this.field544[var1][var2] / this.field547[var1][var2];
            return Area.method4771((double)var3 / 256.0D, (double)var4 / 256.0D, (double)var5 / 256.0D);
         }
      } else {
         return 0;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([Lgw;II)Lgw;",
      garbageValue = "-1423486323"
   )
   @Export("forOrdinal")
   public static Enumerated forOrdinal(Enumerated[] var0, int var1) {
      Enumerated[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         Enumerated var4 = var2[var3];
         if(var1 == var4.rsOrdinal()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljm;Ljava/lang/String;Ljava/lang/String;B)Llq;",
      garbageValue = "-54"
   )
   @Export("getSprite")
   public static IndexedSprite getSprite(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      IndexedSprite var5;
      if(!class288.method5204(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class62.method1088();
      }

      return var5;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1758857283"
   )
   @Export("getSmoothNoise2D")
   static final int getSmoothNoise2D(int var0, int var1) {
      int var2 = SoundTask.method2260(var0 - 1, var1 - 1) + SoundTask.method2260(var0 + 1, var1 - 1) + SoundTask.method2260(var0 - 1, var1 + 1) + SoundTask.method2260(var0 + 1, var1 + 1);
      int var3 = SoundTask.method2260(var0 - 1, var1) + SoundTask.method2260(1 + var0, var1) + SoundTask.method2260(var0, var1 - 1) + SoundTask.method2260(var0, var1 + 1);
      int var4 = SoundTask.method2260(var0, var1);
      return var2 / 16 + var3 / 8 + var4 / 4;
   }

   @ObfuscatedName("go")
   @ObfuscatedSignature(
      signature = "(Lbg;I)V",
      garbageValue = "-2014876400"
   )
   static final void method661(Actor var0) {
      if(var0.field1197 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.actionFrameCycle + 1 > ISAACCipher.getAnimation(var0.animation).frameLengths[var0.actionFrame]) {
         int var1 = var0.field1197 - var0.field1196;
         int var2 = Client.gameCycle - var0.field1196;
         int var3 = var0.field1192 * 128 + var0.field1153 * 64;
         int var4 = var0.field1202 * 128 + var0.field1153 * 64;
         int var5 = var0.field1193 * 128 + var0.field1153 * 64;
         int var6 = var0.field1178 * 128 + var0.field1153 * 64;
         var0.x = (var5 * var2 + var3 * (var1 - var2)) / var1;
         var0.y = (var2 * var6 + var4 * (var1 - var2)) / var1;
      }

      var0.field1208 = 0;
      var0.orientation = var0.field1198;
      var0.angle = var0.orientation;
   }

   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "(Lbs;ZI)V",
      garbageValue = "226626639"
   )
   @Export("closeWidget")
   static final void closeWidget(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1 && var2 != -1 && class314.validInterfaces[var2]) {
         UnitPriceComparator.widgetIndex.method4566(var2);
         if(class189.widgets[var2] != null) {
            boolean var6 = true;

            for(int var5 = 0; var5 < class189.widgets[var2].length; ++var5) {
               if(class189.widgets[var2][var5] != null) {
                  if(class189.widgets[var2][var5].type != 2) {
                     class189.widgets[var2][var5] = null;
                  } else {
                     var6 = false;
                  }
               }
            }

            if(var6) {
               class189.widgets[var2] = null;
            }

            class314.validInterfaces[var2] = false;
         }
      }

      class233.method4333(var2);
      Widget var4 = class3.getWidget(var3);
      if(var4 != null) {
         WorldMapType1.method274(var4);
      }

      BoundingBox3D.method62();
      if(Client.widgetRoot != -1) {
         DState.method3500(Client.widgetRoot, 1);
      }

   }
}
