import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
@Implements("ObjectSound")
public final class ObjectSound extends Node {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lje;"
   )
   @Export("objectSounds")
   static NodeDeque objectSounds;
   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("indexCache2")
   static IndexCache indexCache2;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 647270745
   )
   int field647;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -800464493
   )
   int field648;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -85911525
   )
   int field649;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -211591209
   )
   int field650;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 512258949
   )
   int field651;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1344558633
   )
   int field652;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -731474443
   )
   @Export("soundEffectId")
   int soundEffectId;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lds;"
   )
   @Export("stream1")
   RawPcmStream stream1;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1608400407
   )
   int field653;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1748890449
   )
   int field654;
   @ObfuscatedName("k")
   @Export("soundEffectIds")
   int[] soundEffectIds;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1041508847
   )
   int field655;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lds;"
   )
   @Export("stream2")
   RawPcmStream stream2;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   @Export("obj")
   ObjectDefinition obj;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "585404027"
   )
   @Export("set")
   void set() {
      int var1 = this.soundEffectId;
      ObjectDefinition var2 = this.obj.transform();
      if (var2 != null) {
         this.soundEffectId = var2.ambientSoundId;
         this.field652 = var2.int4 * 128;
         this.field653 = var2.int5;
         this.field654 = var2.int6;
         this.soundEffectIds = var2.field646;
      } else {
         this.soundEffectId = -1;
         this.field652 = 0;
         this.field653 = 0;
         this.field654 = 0;
         this.soundEffectIds = null;
      }

      if (var1 != this.soundEffectId && this.stream1 != null) {
         TaskHandler.pcmStreamMixer.removeSubStream(this.stream1);
         this.stream1 = null;
      }

   }

   static {
      objectSounds = new NodeDeque();
   }
}
