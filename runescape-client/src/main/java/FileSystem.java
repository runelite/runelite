import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
@Implements("FileSystem")
public class FileSystem extends Node {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -805190865
   )
   int field3189;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lfq;"
   )
   @Export("index")
   public IndexFile index;
   @ObfuscatedName("n")
   public byte[] field3185;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   @Export("data")
   public IndexData data;
}
