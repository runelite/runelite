import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("p")
   public static class72[] field186;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2103636225
   )
   int field187;
   @ObfuscatedName("u")
   boolean field188 = false;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -619636463
   )
   @Export("id")
   int id;
   @ObfuscatedName("iq")
   static Widget field190;
   @ObfuscatedName("cr")
   static class102 field196;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1373089082"
   )
   static void method172() {
      class225.field3230 = null;
      ItemComposition.field3003 = null;
      class225.field3232 = null;
      ChatLineBuffer.field994 = null;
      class225.field3234 = null;
      BufferProvider.field3199 = null;
   }
}
