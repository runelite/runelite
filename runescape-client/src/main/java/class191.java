import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gv")
public class class191 {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   @Export("NpcDefinition_indexCache")
   public static IndexDataBase NpcDefinition_indexCache;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "972751078"
   )
   public static final void method3569(int var0, int var1) {
      class132.Viewport_mouseX = var0;
      class132.Viewport_mouseY = var1;
      class132.Viewport_containsMouse = true;
      class132.Viewport_entityCountAtMouse = 0;
      class132.Viewport_false0 = false;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "-100"
   )
   public static boolean method3570(int var0) {
      return (var0 >> 21 & 1) != 0;
   }
}
