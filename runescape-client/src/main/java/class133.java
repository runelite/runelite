import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
public class class133 {
   @ObfuscatedName("d")
   @Export("Viewport_containsMouse")
   static boolean Viewport_containsMouse;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 505046769
   )
   @Export("Viewport_mouseX")
   static int Viewport_mouseX;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2104861051
   )
   @Export("Viewport_mouseY")
   static int Viewport_mouseY;
   @ObfuscatedName("z")
   @Export("Viewport_false0")
   static boolean Viewport_false0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 289363889
   )
   static int field1899;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1233420019
   )
   static int field1904;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -374522265
   )
   static int field1905;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1389387171
   )
   static int field1906;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -645641585
   )
   static int field1907;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1305557085
   )
   @Export("Viewport_entityCountAtMouse")
   public static int Viewport_entityCountAtMouse;
   @ObfuscatedName("y")
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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "264910980"
   )
   public static void method2710() {
      NPCComposition.npcs.reset();
      NPCComposition.npcModelCache.reset();
   }
}
