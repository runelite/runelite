import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
@Implements("FileRequest")
public class FileRequest extends CacheableNode {
   @ObfuscatedName("er")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   @Export("fontPlain11")
   static Font fontPlain11;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   @Export("index")
   public IndexData index;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1509332601
   )
   @Export("crc")
   public int crc;
   @ObfuscatedName("y")
   @Export("padding")
   public byte padding;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-809334691"
   )
   static void method4300() {
      class61.field734 = null;
      class61.field731 = null;
      class61.field733 = null;
      class37.field487 = null;
      class161.field2183 = null;
      class115.field1595 = null;
      class61.field730 = null;
      class60.field721 = null;
      class161.field2189 = null;
      class263.field3483 = null;
      WidgetNode.field788 = null;
      class54.field639 = null;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   public static void method4301(int var0) {
      MouseInput.mouseIdleTicks = var0;
   }
}
