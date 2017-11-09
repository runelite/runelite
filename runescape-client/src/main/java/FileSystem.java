import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
@Implements("FileSystem")
public class FileSystem extends Node {
   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "Let;"
   )
   static Task field3271;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1218501315
   )
   int field3267;
   @ObfuscatedName("p")
   public byte[] field3265;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lfe;"
   )
   @Export("index")
   public IndexFile index;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   @Export("data")
   public IndexData data;
}
