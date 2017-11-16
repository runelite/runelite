import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
@Implements("FileSystem")
public class FileSystem extends Node {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1880358887
   )
   static int field3259;
   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   static class239 field3262;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -300330105
   )
   int field3260;
   @ObfuscatedName("s")
   public byte[] field3258;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lfw;"
   )
   @Export("index")
   public IndexFile index;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("data")
   public IndexData data;
}
