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
   @Export("__f")
   int __f;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -800464493
   )
   @Export("__q")
   int __q;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -85911525
   )
   @Export("__w")
   int __w;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -211591209
   )
   @Export("__o")
   int __o;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 512258949
   )
   @Export("__u")
   int __u;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1344558633
   )
   @Export("__g")
   int __g;
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
   @Export("__x")
   int __x;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1748890449
   )
   @Export("__d")
   int __d;
   @ObfuscatedName("k")
   @Export("soundEffectIds")
   int[] soundEffectIds;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1041508847
   )
   @Export("surfaceOffsetY")
   int surfaceOffsetY;
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
      if(var2 != null) {
         this.soundEffectId = var2.ambientSoundId;
         this.__g = var2.int4 * 128;
         this.__x = var2.int5;
         this.__d = var2.int6;
         this.soundEffectIds = var2.__ax;
      } else {
         this.soundEffectId = -1;
         this.__g = 0;
         this.__x = 0;
         this.__d = 0;
         this.soundEffectIds = null;
      }

      if(var1 != this.soundEffectId && this.stream1 != null) {
         TaskHandler.pcmStreamMixer.removeSubStream(this.stream1);
         this.stream1 = null;
      }

   }

   static {
      objectSounds = new NodeDeque();
   }
}
