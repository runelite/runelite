import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
@Implements("FileSystem")
public class FileSystem extends Node {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2052755499
   )
   int field3282;
   @ObfuscatedName("x")
   byte[] field3280;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   @Export("index")
   IndexFile index;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("data")
   IndexData data;
}
