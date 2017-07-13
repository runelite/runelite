import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
@Implements("MilliTimer")
public class MilliTimer extends Timer {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1188660027
   )
   public static int field2204;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1020855937
   )
   int field2206;
   @ObfuscatedName("a")
   long[] field2200;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -598368735
   )
   @Export("sleepTime")
   int sleepTime;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1011126945
   )
   int field2202;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = -4364582552351171257L
   )
   @Export("milliTime")
   long milliTime;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1761169021
   )
   int field2198;

   public MilliTimer() {
      this.field2200 = new long[10];
      this.field2206 = 256;
      this.sleepTime = 1;
      this.field2202 = 0;
      this.milliTime = class46.currentTimeMs();

      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2200[var1] = this.milliTime;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2130584926"
   )
   public int vmethod2980(int var1, int var2) {
      int var3 = this.field2206;
      int var4 = this.sleepTime;
      this.field2206 = 300;
      this.sleepTime = 1;
      this.milliTime = class46.currentTimeMs();
      if(this.field2200[this.field2198] == 0L) {
         this.field2206 = var3;
         this.sleepTime = var4;
      } else if(this.milliTime > this.field2200[this.field2198]) {
         this.field2206 = (int)((long)(var1 * 2560) / (this.milliTime - this.field2200[this.field2198]));
      }

      if(this.field2206 < 25) {
         this.field2206 = 25;
      }

      if(this.field2206 > 256) {
         this.field2206 = 256;
         this.sleepTime = (int)((long)var1 - (this.milliTime - this.field2200[this.field2198]) / 10L);
      }

      if(this.sleepTime > var1) {
         this.sleepTime = var1;
      }

      this.field2200[this.field2198] = this.milliTime;
      this.field2198 = (this.field2198 + 1) % 10;
      int var5;
      if(this.sleepTime > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field2200[var5]) {
               this.field2200[var5] += (long)this.sleepTime;
            }
         }
      }

      if(this.sleepTime < var2) {
         this.sleepTime = var2;
      }

      class33.method354((long)this.sleepTime);

      for(var5 = 0; this.field2202 < 256; this.field2202 += this.field2206) {
         ++var5;
      }

      this.field2202 &= 255;
      return var5;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "9"
   )
   public void vmethod2974() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2200[var1] = 0L;
      }

   }

   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1381837243"
   )
   static final void method2912() {
      Overlay.overlays.reset();
      FloorUnderlayDefinition.underlays.reset();
      KitDefinition.identKits.reset();
      ObjectComposition.objects.reset();
      ObjectComposition.field3446.reset();
      ObjectComposition.cachedModels.reset();
      ObjectComposition.field3439.reset();
      NPCComposition.npcs.reset();
      NPCComposition.npcModelCache.reset();
      ItemComposition.items.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
      Sequence.sequences.reset();
      Sequence.skeletons.reset();
      Spotanim.spotanims.reset();
      Spotanim.field3327.reset();
      Varcs.method1776();
      class18.method128();
      class254.field3427.reset();
      class254.field3430.reset();
      class254.field3412.reset();
      method2910();
      class202.method3681();
      Preferences.method1574();
      Area.skeletonsIndex.reset();
      PlayerComposition.field2627.reset();
      GZipDecompressor.method3074();
      ((TextureProvider)Graphics3D.textureLoader).reset();
      Script.field1530.reset();
      class31.indexInterfaces.reset();
      Client.indexSoundEffects.reset();
      BuildType.field3190.reset();
      WorldMapType2.field502.reset();
      class12.indexMaps.reset();
      class182.indexTrack1.reset();
      Renderable.indexModels.reset();
      class17.indexSprites.reset();
      Client.indexTextures.reset();
      class54.field660.reset();
      class10.indexTrack2.reset();
      class265.indexScripts.reset();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1358645583"
   )
   public static boolean method2901(int var0) {
      return (var0 >> 29 & 1) != 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-281689405"
   )
   public static void method2910() {
      CombatInfo2.field3364.reset();
      CombatInfo2.spriteCache.reset();
   }

   @ObfuscatedName("jc")
   @ObfuscatedSignature(
      signature = "(LWidgetNode;ZB)V",
      garbageValue = "0"
   )
   static final void method2909(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1 && var2 != -1 && Widget.validInterfaces[var2]) {
         class11.widgetIndex.method4094(var2);
         if(Widget.widgets[var2] != null) {
            boolean var6 = true;

            for(int var5 = 0; var5 < Widget.widgets[var2].length; ++var5) {
               if(Widget.widgets[var2][var5] != null) {
                  if(Widget.widgets[var2][var5].type != 2) {
                     Widget.widgets[var2][var5] = null;
                  } else {
                     var6 = false;
                  }
               }
            }

            if(var6) {
               Widget.widgets[var2] = null;
            }

            Widget.validInterfaces[var2] = false;
         }
      }

      WorldMapData.method346(var2);
      Widget var4 = class61.method1038(var3);
      if(var4 != null) {
         class48.method749(var4);
      }

      class36.method486();
      if(Client.widgetRoot != -1) {
         class31.method275(Client.widgetRoot, 1);
      }

   }

   @ObfuscatedName("jl")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "1084446484"
   )
   @Export("isIgnored")
   static boolean isIgnored(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = class202.method3682(var0, class164.field2317);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(class202.method3682(var3.name, class164.field2317))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class202.method3682(var3.previousName, class164.field2317))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIIIZB)LSpritePixels;",
      garbageValue = "120"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var4 << 40) + ((long)var2 << 38) + (long)var0 + ((long)var1 << 16) + ((long)var3 << 42);
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = class83.getItemDefinition(var0);
      if(var1 > 1 && var9.countObj != null) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.countCo[var11] && var9.countCo[var11] != 0) {
               var10 = var9.countObj[var11];
            }
         }

         if(var10 != -1) {
            var9 = class83.getItemDefinition(var10);
         }
      }

      Model var21 = var9.getModel(1);
      if(var21 == null) {
         return null;
      } else {
         SpritePixels var22 = null;
         if(var9.notedTemplate != -1) {
            var22 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(var22 == null) {
               return null;
            }
         } else if(var9.notedId != -1) {
            var22 = createSprite(var9.unnotedId, var1, var2, var3, 0, false);
            if(var22 == null) {
               return null;
            }
         } else if(var9.field3542 != -1) {
            var22 = createSprite(var9.field3492, var1, 0, 0, 0, false);
            if(var22 == null) {
               return null;
            }
         }

         int[] var12 = Rasterizer2D.graphicsPixels;
         int var13 = Rasterizer2D.graphicsPixelsWidth;
         int var14 = Rasterizer2D.graphicsPixelsHeight;
         int[] var15 = new int[4];
         Rasterizer2D.copyDrawRegion(var15);
         var8 = new SpritePixels(36, 32);
         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         Rasterizer2D.reset();
         Graphics3D.method2594();
         Graphics3D.method2599(16, 16);
         Graphics3D.rasterGouraudLowRes = false;
         if(var9.field3542 != -1) {
            var22.method5032(0, 0);
         }

         int var16 = var9.zoom2d;
         if(var5) {
            var16 = (int)((double)var16 * 1.5D);
         } else if(var2 == 2) {
            var16 = (int)(1.04D * (double)var16);
         }

         int var17 = var16 * Graphics3D.SINE[var9.xan2d] >> 16;
         int var18 = var16 * Graphics3D.COSINE[var9.xan2d] >> 16;
         var21.method2542();
         var21.method2512(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var17 + var21.modelHeight / 2 + var9.offsetY2d, var18 + var9.offsetY2d);
         if(var9.notedId != -1) {
            var22.method5032(0, 0);
         }

         if(var2 >= 1) {
            var8.method4979(1);
         }

         if(var2 >= 2) {
            var8.method4979(16777215);
         }

         if(var3 != 0) {
            var8.method4980(var3);
         }

         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         if(var9.notedTemplate != -1) {
            var22.method5032(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            Font var19 = ItemComposition.field3495;
            String var20;
            if(var1 < 100000) {
               var20 = "<col=ffff00>" + var1 + "</col>";
            } else if(var1 < 10000000) {
               var20 = "<col=ffffff>" + var1 / 1000 + "K" + "</col>";
            } else {
               var20 = "<col=00ff80>" + var1 / 1000000 + "M" + "</col>";
            }

            var19.method4725(var20, 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         Rasterizer2D.setRasterBuffer(var12, var13, var14);
         Rasterizer2D.setDrawRegion(var15);
         Graphics3D.method2594();
         Graphics3D.rasterGouraudLowRes = true;
         return var8;
      }
   }
}
