import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -855025283
   )
   static int field874;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = -1106646233
   )
   @Export("cameraZ")
   static int cameraZ;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = -905934353
   )
   @Export("cameraYaw")
   static int cameraYaw;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 103597869
   )
   @Export("intStackSize")
   static int intStackSize;
   @ObfuscatedName("i")
   @Export("name")
   String name;
   @ObfuscatedName("j")
   @Export("previousName")
   String previousName;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lii;Lii;Lii;Lii;I)V",
      garbageValue = "-2008297458"
   )
   public static void method1134(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2, IndexDataBase var3) {
      Coordinates.widgetIndex = var0;
      ChatLineBuffer.field1565 = var1;
      class204.field2513 = var2;
      Widget.field2651 = var3;
      class268.widgets = new Widget[Coordinates.widgetIndex.size()][];
      class2.validInterfaces = new boolean[Coordinates.widgetIndex.size()];
   }
}
