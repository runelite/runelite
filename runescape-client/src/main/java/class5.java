import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
final class class5 implements class0 {
   @ObfuscatedName("g")
   @Export("overlayIds")
   static byte[][][] overlayIds;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   public static IndexDataBase field30;

   @ObfuscatedName("ez")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-471725507"
   )
   static final void method17() {
      Actor.method1480();
      FrameMap.method2615();
      class90.method1659();
      ObjectComposition.objects.reset();
      ObjectComposition.field3443.reset();
      ObjectComposition.cachedModels.reset();
      ObjectComposition.field3413.reset();
      WorldMapType3.method179();
      class169.method3060();
      class64.method1033();
      class222.method3977();
      Varbit.varbits.reset();
      VarPlayerType.varplayers.reset();
      class162.method2992();
      class175.method3310();
      class252.field3368.reset();
      class251.field3364.reset();
      Area.skeletonsIndex.reset();
      class56.method782();
      Widget.field2611.reset();
      Widget.field2612.reset();
      Widget.field2709.reset();
      Widget.field2614.reset();
      ((TextureProvider)Graphics3D.textureLoader).reset();
      Script.field1506.reset();
      class37.indexInterfaces.reset();
      class112.indexSoundEffects.reset();
      Overlay.field3568.reset();
      class25.field353.reset();
      ISAACCipher.indexMaps.reset();
      class8.indexTrack1.reset();
      class1.indexModels.reset();
      class271.indexSprites.reset();
      WorldMapType3.indexTextures.reset();
      class27.field387.reset();
      class222.indexTrack2.reset();
      class13.indexScripts.reset();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1248642527"
   )
   @Export("decodeSprite")
   public static void decodeSprite(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class286.field3785 = var1.readUnsignedShort();
      class286.field3782 = new int[class286.field3785];
      class286.offsetsY = new int[class286.field3785];
      class286.field3779 = new int[class286.field3785];
      class286.field3787 = new int[class286.field3785];
      class286.spritePixels = new byte[class286.field3785][];
      var1.offset = var0.length - 7 - class286.field3785 * 8;
      class286.field3780 = var1.readUnsignedShort();
      class286.field3781 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class286.field3785; ++var3) {
         class286.field3782[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class286.field3785; ++var3) {
         class286.offsetsY[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class286.field3785; ++var3) {
         class286.field3779[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class286.field3785; ++var3) {
         class286.field3787[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class286.field3785 * 8 - (var2 - 1) * 3;
      class286.field3786 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class286.field3786[var3] = var1.read24BitInt();
         if(class286.field3786[var3] == 0) {
            class286.field3786[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class286.field3785; ++var3) {
         int var4 = class286.field3779[var3];
         int var5 = class286.field3787[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         class286.spritePixels[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var4 * var10] = var1.readByte();
               }
            }
         }
      }

   }
}
