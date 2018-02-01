import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 787032163
   )
   @Export("id")
   int id;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1393049217
   )
   @Export("owner")
   int owner;
   @ObfuscatedName("w")
   boolean field744;

   WidgetNode() {
      this.field744 = false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IZIB)V",
      garbageValue = "46"
   )
   public static final void method1074(int var0, boolean var1, int var2) {
      if(var0 >= 8000 && var0 <= 48000) {
         class20.sampleRate = var0;
         BoundingBox3DDrawMode.highMemory = var1;
         AbstractSoundSystem.priority = var2;
      } else {
         throw new IllegalArgumentException();
      }
   }
}
