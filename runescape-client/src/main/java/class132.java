import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
public class class132 {
   @ObfuscatedName("c")
   @Export("Viewport_containsMouse")
   public static boolean Viewport_containsMouse;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -35220189
   )
   @Export("Viewport_mouseX")
   static int Viewport_mouseX;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 358460999
   )
   @Export("Viewport_mouseY")
   static int Viewport_mouseY;
   @ObfuscatedName("j")
   @Export("Viewport_false0")
   static boolean Viewport_false0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 377468225
   )
   static int field1915;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1664269127
   )
   static int field1918;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1501908185
   )
   static int field1917;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 118136731
   )
   @Export("Viewport_entityCountAtMouse")
   public static int Viewport_entityCountAtMouse;
   @ObfuscatedName("l")
   @Export("Viewport_entityIdsAtMouse")
   public static int[] Viewport_entityIdsAtMouse;

   static {
      Viewport_containsMouse = false;
      Viewport_mouseX = 0;
      Viewport_mouseY = 0;
      Viewport_false0 = false;
      Viewport_entityCountAtMouse = 0;
      Viewport_entityIdsAtMouse = new int[1000];
   }

   @ObfuscatedName("kh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "466117418"
   )
   static final void method2786() {
      Client.field1048 = Client.cycleCntr;
   }
}
