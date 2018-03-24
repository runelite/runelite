import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
public class class132 {
   @ObfuscatedName("t")
   @Export("Viewport_containsMouse")
   public static boolean Viewport_containsMouse;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1334772033
   )
   @Export("Viewport_mouseX")
   static int Viewport_mouseX;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1462859857
   )
   @Export("Viewport_mouseY")
   static int Viewport_mouseY;
   @ObfuscatedName("a")
   @Export("Viewport_false0")
   static boolean Viewport_false0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1896192471
   )
   static int field1897;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 677537489
   )
   static int field1893;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1386897201
   )
   static int field1899;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1339362459
   )
   @Export("Viewport_entityCountAtMouse")
   public static int Viewport_entityCountAtMouse;
   @ObfuscatedName("u")
   @Export("Viewport_entityIdsAtMouse")
   public static int[] Viewport_entityIdsAtMouse;

   static {
      Viewport_containsMouse = false;
      Viewport_mouseX = 0;
      Viewport_mouseY = 0;
      Viewport_false0 = false;
      Viewport_entityCountAtMouse = 0;
      Viewport_entityIdsAtMouse = new int[1000];
   }

   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1740213585"
   )
   static final void method2765() {
      Client.field1072.close();
      class167.method3262();
      FloorUnderlayDefinition.underlays.reset();
      class55.method857();
      ObjectComposition.objects.reset();
      ObjectComposition.field3597.reset();
      ObjectComposition.cachedModels.reset();
      ObjectComposition.field3599.reset();
      class271.method4800();
      ItemComposition.items.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
      Timer.method3331();
      Spotanim.spotanims.reset();
      Spotanim.SpotAnimationDefinition_cachedModels.reset();
      class204.method3854();
      VarPlayerType.varplayers.reset();
      Nameable.method5271();
      CombatInfo2.field3527.reset();
      CombatInfo2.field3526.reset();
      class71.method1195();
      class278.field3548.reset();
      WorldMapData.method365();
      class197.method3775();
      class185.method3456();
      ((TextureProvider)Graphics3D.textureLoader).reset();
      Script.field1433.reset();
      World.indexInterfaces.reset();
      ContextMenuRow.indexSoundEffects.reset();
      class316.indexCache3.reset();
      WorldMapRectangle.indexCache4.reset();
      VertexNormal.indexMaps.reset();
      Varbit.indexTrack1.reset();
      class236.indexModels.reset();
      WorldMapRegion.indexSprites.reset();
      class62.indexTextures.reset();
      FileRequest.indexCache10.reset();
      class55.indexTrack2.reset();
      BoundingBox2D.indexScripts.reset();
      class38.region.reset();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].reset();
      }

      System.gc();
      class229.field2674 = 1;
      class229.field2672 = null;
      class171.field2199 = -1;
      class229.field2676 = -1;
      class229.field2677 = 0;
      class85.field1294 = false;
      class2.field13 = 2;
      Client.field1080 = -1;
      Client.field956 = false;

      for(class80 var1 = (class80)class80.field1240.getFront(); var1 != null; var1 = (class80)class80.field1240.getNext()) {
         if(var1.field1244 != null) {
            FontName.field3884.method2087(var1.field1244);
            var1.field1244 = null;
         }

         if(var1.field1238 != null) {
            FontName.field3884.method2087(var1.field1238);
            var1.field1238 = null;
         }
      }

      class80.field1240.clear();
      class20.setGameState(10);
   }

   @ObfuscatedName("jo")
   @ObfuscatedSignature(
      signature = "(IIIB)Lbz;",
      garbageValue = "0"
   )
   @Export("openWidget")
   static final WidgetNode openWidget(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.owner = var2;
      Client.componentTable.put(var3, (long)var0);
      int var5;
      if(Script.loadWidget(var1)) {
         Widget[] var4 = Widget.widgets[var1];

         for(var5 = 0; var5 < var4.length; ++var5) {
            Widget var9 = var4[var5];
            if(var9 != null) {
               var9.field2939 = 0;
               var9.field2940 = 0;
            }
         }
      }

      Widget var10 = GZipDecompressor.getWidget(var0);
      GameEngine.method1053(var10);
      if(Client.field1012 != null) {
         GameEngine.method1053(Client.field1012);
         Client.field1012 = null;
      }

      for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
         int var7 = Client.menuTypes[var5];
         boolean var6 = var7 == 57 || var7 == 58 || var7 == 1007 || var7 == 25 || var7 == 30;
         if(var6) {
            if(var5 < Client.menuOptionCount - 1) {
               for(int var8 = var5; var8 < Client.menuOptionCount - 1; ++var8) {
                  Client.menuOptions[var8] = Client.menuOptions[var8 + 1];
                  Client.menuTargets[var8] = Client.menuTargets[var8 + 1];
                  Client.menuTypes[var8] = Client.menuTypes[var8 + 1];
                  Client.menuIdentifiers[var8] = Client.menuIdentifiers[var8 + 1];
                  Client.menuActionParams0[var8] = Client.menuActionParams0[var8 + 1];
                  Client.menuActionParams1[var8] = Client.menuActionParams1[var8 + 1];
                  Client.menuBooleanArray[var8] = Client.menuBooleanArray[var8 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

      GameEngine.method1051(Widget.widgets[var0 >> 16], var10, false);
      WorldMapData.method312(var1);
      if(Client.widgetRoot != -1) {
         BoundingBox.method50(Client.widgetRoot, 1);
      }

      return var3;
   }
}
