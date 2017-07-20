import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("im")
@Implements("FileRequest")
public class FileRequest extends CacheableNode {
   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "[Ljx;"
   )
   static ModIcon[] field3179;
   @ObfuscatedName("i")
   @Export("padding")
   public byte padding;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   @Export("index")
   public IndexData index;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -181415639
   )
   @Export("crc")
   public int crc;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "76"
   )
   static void method4004() {
      if(class67.loadWorlds()) {
         class92.worldSelectShown = true;
      }

   }
}
