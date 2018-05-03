import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
public class class132 {
   @ObfuscatedName("g")
   @Export("Viewport_containsMouse")
   static boolean Viewport_containsMouse;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1549609463
   )
   @Export("Viewport_mouseX")
   static int Viewport_mouseX;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1411534977
   )
   @Export("Viewport_mouseY")
   static int Viewport_mouseY;
   @ObfuscatedName("z")
   @Export("Viewport_false0")
   static boolean Viewport_false0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1476418485
   )
   static int field1895;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   public static IndexDataBase field1905;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2115947027
   )
   static int field1896;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1148247439
   )
   public static int field1897;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1382536397
   )
   static int field1891;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 695505623
   )
   static int field1904;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -613864065
   )
   static int field1899;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1222061241
   )
   @Export("Viewport_entityCountAtMouse")
   public static int Viewport_entityCountAtMouse;
   @ObfuscatedName("p")
   @Export("Viewport_entityIdsAtMouse")
   public static int[] Viewport_entityIdsAtMouse;
   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      signature = "[Llv;"
   )
   @Export("headIconsPk")
   static SpritePixels[] headIconsPk;

   static {
      Viewport_containsMouse = false;
      Viewport_mouseX = 0;
      Viewport_mouseY = 0;
      Viewport_false0 = false;
      Viewport_entityCountAtMouse = 0;
      Viewport_entityIdsAtMouse = new int[1000];
   }
}
