import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
@Implements("FileSystem")
public class FileSystem extends Node {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1833177687
   )
   int field3205;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   @Export("index")
   public IndexFile index;
   @ObfuscatedName("j")
   public byte[] field3206;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("data")
   public IndexData data;
}
