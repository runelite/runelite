import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("ContextMenuRow")
public class ContextMenuRow {
   @ObfuscatedName("z")
   @Export("highMemory")
   protected static boolean highMemory;
   @ObfuscatedName("jy")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   static Widget field1299;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 571443005
   )
   @Export("param0")
   int param0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 715253505
   )
   @Export("param1")
   int param1;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1066703259
   )
   @Export("type")
   int type;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1578872715
   )
   @Export("identifier")
   int identifier;
   @ObfuscatedName("u")
   @Export("option")
   String option;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "933459213"
   )
   public static void method1663() {
      class299.field3867 = null;
      class299.offsetsY = null;
      Item.field1387 = null;
      class276.field3727 = null;
      FaceNormal.field2025 = null;
      Bounds.spritePixels = null;
   }
}
