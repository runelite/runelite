import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
public class class7 {
   @ObfuscatedName("lb")
   @ObfuscatedGetter(
      intValue = 815544055
   )
   static int field227;
   @ObfuscatedName("p")
   @Export("drawBoundingBoxes3D")
   public static boolean drawBoundingBoxes3D;
   @ObfuscatedName("i")
   @Export("drawBoundingBoxes2D")
   public static boolean drawBoundingBoxes2D;
   @ObfuscatedName("w")
   @Export("drawObjectGeometry2D")
   public static boolean drawObjectGeometry2D;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lx;"
   )
   @Export("boundingBox3DDrawMode")
   public static BoundingBox3DDrawMode boundingBox3DDrawMode;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   @Export("boundingBoxes")
   public static CombatInfoList boundingBoxes;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   @Export("logoSprite")
   static IndexedSprite logoSprite;

   static {
      drawBoundingBoxes3D = false;
      drawBoundingBoxes2D = false;
      drawObjectGeometry2D = false;
      boundingBox3DDrawMode = BoundingBox3DDrawMode.ON_MOUSEOVER;
      boundingBoxes = new CombatInfoList();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Lbh;",
      garbageValue = "66"
   )
   static Preferences method50() {
      FileOnDisk var0 = null;
      Preferences var1 = new Preferences();

      try {
         var0 = UrlRequester.getPreferencesFile("", WorldComparator.field261.name, false);
         byte[] var2 = new byte[(int)var0.length()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var0.read(var2, var3, var2.length - var3);
            if(var4 == -1) {
               throw new IOException();
            }
         }

         var1 = new Preferences(new Buffer(var2));
      } catch (Exception var6) {
         ;
      }

      try {
         if(var0 != null) {
            var0.close();
         }
      } catch (Exception var5) {
         ;
      }

      return var1;
   }

   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1244670911"
   )
   static final void method49() {
      Overlay.overlays.reset();
      FloorUnderlayDefinition.underlays.reset();
      MouseInput.method1010();
      class179.method3371();
      BaseVarType.method16();
      KeyFocusListener.method759();
      class233.method4329();
      Spotanim.spotanims.reset();
      Spotanim.SpotAnimationDefinition_cachedModels.reset();
      Varbit.varbits.reset();
      VarPlayerType.varplayers.reset();
      Tile.method2654();
      CombatInfo2.field3421.reset();
      CombatInfo2.spriteCache.reset();
      class263.field3453.reset();
      Overlay.method4939();
      class70.method1126();
      class45.method637();
      GroundObject.method2639();
      ((TextureProvider)Graphics3D.textureLoader).reset();
      Script.field1421.reset();
      GameCanvas.indexInterfaces.reset();
      GroundObject.indexSoundEffects.reset();
      AttackOption.indexCache3.reset();
      class23.indexCache4.reset();
      FontName.indexMaps.reset();
      class148.indexTrack1.reset();
      MouseRecorder.indexModels.reset();
      Tile.indexSprites.reset();
      BoundingBox3D.indexTextures.reset();
      Client.indexCache10.reset();
      class70.indexTrack2.reset();
      class28.indexScripts.reset();
   }
}
