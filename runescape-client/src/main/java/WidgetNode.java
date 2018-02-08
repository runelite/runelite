import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("qo")
   @ObfuscatedGetter(
      longValue = 8153442694785265883L
   )
   static long field766;
   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "[Lki;"
   )
   @Export("mapDots")
   static SpritePixels[] mapDots;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -947214667
   )
   @Export("id")
   int id;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2076820327
   )
   @Export("owner")
   int owner;
   @ObfuscatedName("m")
   boolean field768;

   WidgetNode() {
      this.field768 = false;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ZZI)Lkh;",
      garbageValue = "767486344"
   )
   static IndexedSprite method1062(boolean var0, boolean var1) {
      return var0?(var1?BaseVarType.field16:class89.field1321):(var1?class85.field1292:Size.field350);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-196869128"
   )
   static void method1063(int var0) {
      ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var1 != null) {
         var1.unlink();
      }
   }
}
