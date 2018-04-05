import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ih")
public final class class255 {
   @ObfuscatedName("pn")
   @ObfuscatedGetter(
      intValue = 721494687
   )
   static int field3331;
   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "Lel;"
   )
   @Export("region")
   static Region region;

   @ObfuscatedName("ja")
   @ObfuscatedSignature(
      signature = "(Lgc;IB)V",
      garbageValue = "116"
   )
   static void method4512(Buffer var0, int var1) {
      class264.method4682(var0.payload, var1);
      SoundTask.method2270(var0, var1);
   }
}
