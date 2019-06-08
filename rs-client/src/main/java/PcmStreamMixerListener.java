import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
@Implements("PcmStreamMixerListener")
public abstract class PcmStreamMixerListener extends Node {
   @ObfuscatedName("m")
   @Export("__m")
   int __m;

   @ObfuscatedName("m")
   @Export("remove2")
   abstract void remove2();

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lct;)I"
   )
   @Export("update")
   abstract int update();
}
