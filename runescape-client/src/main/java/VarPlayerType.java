import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("js")
@Implements("VarPlayerType")
public class VarPlayerType extends CacheableNode {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   @Export("varplayer_ref")
   public static IndexDataBase varplayer_ref;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   @Export("varplayers")
   public static NodeCache varplayers;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1117881149
   )
   @Export("configType")
   public int configType;

   static {
      varplayers = new NodeCache(64);
   }

   public VarPlayerType() {
      this.configType = 0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lgc;B)V",
      garbageValue = "-48"
   )
   @Export("decode")
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.decode(var1, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgc;II)V",
      garbageValue = "-1135051668"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      if(var2 == 5) {
         this.configType = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1113184025"
   )
   static final void method4736() {
      Client.field957.close();
      Overlay.overlays.reset();
      FloorUnderlayDefinition.underlays.reset();
      KitDefinition.identKits.reset();
      CollisionData.method3415();
      WorldMapDecorationType.method4499();
      ItemComposition.items.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
      class316.method5617();
      class85.method1887();
      Varbit.varbits.reset();
      WorldMapType3.method237();
      class281.field3568.reset();
      class281.field3569.reset();
      class281.field3570.reset();
      CombatInfo2.field3524.reset();
      CombatInfo2.field3531.reset();
      class279.field3553.reset();
      Varcs.method1993();
      class251.method4504();
      class170.method3292();
      class25.method201();
      ((TextureProvider)Graphics3D.textureLoader).reset();
      Script.field1459.reset();
      class71.indexInterfaces.reset();
      class93.indexSoundEffects.reset();
      WorldMapType3.indexCache3.reset();
      class55.indexCache4.reset();
      MouseRecorder.indexMaps.reset();
      PacketBuffer.indexTrack1.reset();
      class18.indexModels.reset();
      class151.indexSprites.reset();
      GameCanvas.indexTextures.reset();
      ClanMember.indexCache10.reset();
      class189.indexTrack2.reset();
      class190.indexScripts.reset();
      class255.region.reset();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].reset();
      }

      System.gc();
      class229.field2687 = 1;
      class185.field2511 = null;
      VertexNormal.field1931 = -1;
      GrandExchangeEvents.field284 = -1;
      class86.field1330 = 0;
      class229.field2692 = false;
      class2.field11 = 2;
      Client.field1026 = -1;
      Client.field1102 = false;
      class61.method1071();
      class64.setGameState(10);
   }
}
