import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hh")
@Implements("FileSystem")
public class FileSystem extends Node {
   @ObfuscatedName("p")
   public byte[] field3200;
   @ObfuscatedName("i")
   @Export("index")
   public IndexFile index;
   @ObfuscatedName("j")
   @Export("data")
   public IndexData data;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 343319793
   )
   int field3204;
   @ObfuscatedName("dt")
   static IndexData field3207;
}
