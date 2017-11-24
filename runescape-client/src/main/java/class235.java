import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ie")
public enum class235 implements class185 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   field3233(3, 0),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   field3230(0, 1),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   field3234(2, 2),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   field3232(6, 3),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   field3231(1, 4),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   field3229(7, 5),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   field3235(5, 6),
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   field3236(4, 7);

   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1991945059
   )
   public final int field3237;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -620935873
   )
   final int field3238;

   class235(int var3, int var4) {
      this.field3237 = var3;
      this.field3238 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1940611593"
   )
   public int rsOrdinal() {
      return this.field3238;
   }

   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "486369914"
   )
   static final void method4236() {
      Overlay.overlays.reset();
      class5.method20();
      KitDefinition.identKits.reset();
      class94.method1849();
      class133.method2710();
      Varbit.method4577();
      Sequence.sequences.reset();
      Sequence.skeletons.reset();
      Spotanim.spotanims.reset();
      Spotanim.field3396.reset();
      Varbit.varbits.reset();
      VarPlayerType.varplayers.reset();
      class169.method3201();
      class182.method3524();
      AbstractSoundSystem.method2157();
      class171.method3218();
      class72.method1150();
      class212.method3984();
      Widget.field2718.reset();
      Widget.field2850.reset();
      Widget.field2735.reset();
      Widget.field2797.reset();
      ((TextureProvider)Graphics3D.textureLoader).reset();
      Script.field1441.reset();
      class163.indexInterfaces.reset();
      class10.indexSoundEffects.reset();
      class45.field561.reset();
      class47.field576.reset();
      PlayerComposition.indexMaps.reset();
      RSCanvas.indexTrack1.reset();
      MouseInput.indexModels.reset();
      ContextMenuRow.indexSprites.reset();
      class64.indexTextures.reset();
      WorldMapType2.field500.reset();
      class35.indexTrack2.reset();
      class1.indexScripts.reset();
   }
}
