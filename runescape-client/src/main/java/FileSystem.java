import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ix")
@Implements("FileSystem")
public class FileSystem extends Node {
   @ObfuscatedName("oe")
   @ObfuscatedGetter(
      intValue = -1620878311
   )
   static int field3295;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 809264481
   )
   @Export("type")
   int type;
   @ObfuscatedName("g")
   byte[] field3291;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lfu;"
   )
   @Export("index")
   IndexFile index;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("data")
   IndexData data;
}
