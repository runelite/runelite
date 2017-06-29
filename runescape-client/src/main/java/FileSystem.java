import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ht")
@Implements("FileSystem")
public class FileSystem extends Node {
   @ObfuscatedName("v")
   static IndexDataBase field3207;
   @ObfuscatedName("a")
   @Export("index")
   public IndexFile index;
   @ObfuscatedName("t")
   @Export("data")
   public IndexData data;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1633923949
   )
   public static int field3211;
   @ObfuscatedName("kw")
   @ObfuscatedGetter(
      intValue = -551144227
   )
   @Export("selectedItemIndex")
   static int selectedItemIndex;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1437416461
   )
   int field3213;
   @ObfuscatedName("w")
   public byte[] field3215;
}
