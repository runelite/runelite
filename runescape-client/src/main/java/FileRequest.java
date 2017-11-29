import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
@Implements("FileRequest")
public class FileRequest extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("index")
   public IndexData index;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1223906473
   )
   @Export("crc")
   public int crc;
   @ObfuscatedName("k")
   @Export("padding")
   public byte padding;

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1568868243"
   )
   static void method4261() {
      ItemContainer.method1100();
      Client.menuOptions[0] = "Cancel";
      Client.menuTargets[0] = "";
      Client.menuTypes[0] = 1006;
      Client.menuBooleanArray[0] = false;
      Client.menuOptionCount = 1;
   }
}
