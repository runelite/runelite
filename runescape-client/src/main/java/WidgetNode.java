import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "[Llh;"
   )
   @Export("titlemuteSprite")
   static IndexedSprite[] titlemuteSprite;
   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   @Export("indexTrack2")
   static IndexData indexTrack2;
   @ObfuscatedName("et")
   @ObfuscatedSignature(
      signature = "Lkr;"
   )
   @Export("fontBold12")
   static Font fontBold12;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = 313816975
   )
   @Export("cameraYaw")
   static int cameraYaw;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1841486463
   )
   @Export("id")
   int id;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1460070893
   )
   @Export("owner")
   int owner;
   @ObfuscatedName("q")
   boolean field500;

   WidgetNode() {
      this.field500 = false;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1096780829"
   )
   public static int method1076() {
      return KeyFocusListener.keyboardIdleTicks;
   }

   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "62"
   )
   static final void method1074() {
      class59.method1130();
      CollisionData.method3447();
      KitDefinition.identKits.reset();
      ObjectComposition.objects.reset();
      ObjectComposition.field3426.reset();
      ObjectComposition.cachedModels.reset();
      ObjectComposition.field3394.reset();
      class34.method635();
      class21.method303();
      class24.method462();
      Frames.method3092();
      Varbit.varbits.reset();
      class157.method3307();
      class267.method5044();
      CombatInfo2.field3323.reset();
      CombatInfo2.field3324.reset();
      class265.field3352.reset();
      class264.field3345.reset();
      Area.areaSpriteCache.reset();
      PlayerComposition.field2597.reset();
      Widget.field2617.reset();
      Widget.Widget_cachedModels.reset();
      Widget.Widget_cachedFonts.reset();
      Widget.field2620.reset();
      ((TextureProvider)Graphics3D.textureLoader).reset();
      Script.field1214.reset();
      FileSystem.indexInterfaces.reset();
      Client.indexSoundEffects.reset();
      WorldMapDecoration.indexCache3.reset();
      FileOnDisk.indexCache4.reset();
      class234.indexMaps.reset();
      MouseInput.indexTrack1.reset();
      class216.indexModels.reset();
      class59.indexSprites.reset();
      class183.indexTextures.reset();
      MapLabel.indexCache10.reset();
      indexTrack2.reset();
      TotalQuantityComparator.indexScripts.reset();
   }

   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2145213429"
   )
   static final void method1075() {
      if(Client.field815 != class192.plane) {
         Client.field815 = class192.plane;
         GameEngine.method983(class192.plane);
      }

   }
}
