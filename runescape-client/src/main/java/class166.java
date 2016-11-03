import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
public final class class166 {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = 7136577248360943579L
   )
   static long field2694;
   @ObfuscatedName("ne")
   static class77 field2695;

   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "(LWidget;S)V",
      garbageValue = "-3410"
   )
   static void method3253(Widget var0) {
      if(var0.field2930 == Client.field484) {
         Client.field485[var0.boundsIndex] = true;
      }

   }
}
