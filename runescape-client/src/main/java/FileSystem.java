import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ir")
@Implements("FileSystem")
public class FileSystem extends Node {
   @ObfuscatedName("a")
   @Export("offsetsY")
   static int[] offsetsY;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 44512707
   )
   @Export("type")
   int type;
   @ObfuscatedName("q")
   byte[] field3316;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   @Export("index")
   IndexFile index;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   @Export("data")
   IndexData data;
}
