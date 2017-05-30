import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
public class class170 {
   @ObfuscatedName("ce")
   @Export("indexSoundEffects")
   static IndexData indexSoundEffects;
   @ObfuscatedName("rd")
   static short[] field2327;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIILObjectComposition;II)V",
      garbageValue = "-821853501"
   )
   static void method3170(int var0, int var1, int var2, ObjectComposition var3, int var4) {
      class82 var5 = new class82();
      var5.field1291 = var0;
      var5.field1305 = var1 * 128;
      var5.field1300 = var2 * 128;
      int var6 = var3.sizeX;
      int var7 = var3.sizeY;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.sizeY;
         var7 = var3.sizeX;
      }

      var5.field1304 = (var6 + var1) * 128;
      var5.field1295 = (var7 + var2) * 128;
      var5.field1297 = var3.ambientSoundId;
      var5.field1296 = var3.field3474 * -1065075840;
      var5.field1292 = var3.field3469;
      var5.field1290 = var3.field3476;
      var5.field1301 = var3.field3459;
      if(var3.impostorIds != null) {
         var5.field1307 = var3;
         var5.method1611();
      }

      class82.field1299.method3655(var5);
      if(var5.field1301 != null) {
         var5.field1293 = var5.field1292 + (int)(Math.random() * (double)(var5.field1290 - var5.field1292));
      }

   }

   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1171262499"
   )
   static final void method3171() {
      Overlay.field3590.reset();
      class66.method1100();
      KitDefinition.field3340.reset();
      ObjectComposition.field3431.reset();
      ObjectComposition.field3478.reset();
      ObjectComposition.field3433.reset();
      ObjectComposition.field3464.reset();
      Projectile.method1781();
      ItemComposition.field3485.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
      class40.method554();
      Spotanim.field3312.reset();
      Spotanim.field3328.reset();
      Varbit.field3378.reset();
      class241.field3270.reset();
      class7.method26();
      class154.method2991();
      class252.field3388.reset();
      class251.field3382.reset();
      class242.field3278.reset();
      Frames.method2916();
      Widget.field2695.reset();
      Widget.field2637.reset();
      Widget.field2737.reset();
      Widget.field2652.reset();
      ((TextureProvider)class136.field2017).method2415();
      Script.field1534.reset();
      class1.indexInterfaces.method4187();
      indexSoundEffects.method4187();
      WorldMapType2.field513.method4187();
      class43.field559.method4187();
      class34.indexMaps.method4187();
      class44.indexTrack1.method4187();
      ChatMessages.indexModels.method4187();
      class77.indexSprites.method4187();
      class20.indexTextures.method4187();
      class64.field785.method4187();
      class33.indexTrack2.method4187();
      class66.indexScripts.method4187();
   }
}
