import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hf")
@Implements("FileSystem")
public class FileSystem extends Node {
   @ObfuscatedName("m")
   public byte[] field3210;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1335806479
   )
   int field3211;
   @ObfuscatedName("e")
   @Export("index")
   public IndexFile index;
   @ObfuscatedName("t")
   @Export("data")
   public IndexData data;
}
