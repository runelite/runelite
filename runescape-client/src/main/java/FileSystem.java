import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
@Implements("FileSystem")
public class FileSystem extends Node {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 300161705
   )
   int field3204;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lfz;"
   )
   @Export("index")
   IndexFile index;
   @ObfuscatedName("j")
   byte[] field3202;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   @Export("data")
   IndexData data;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-2090714293"
   )
   public static String method4078(int var0) {
      return (var0 >> 24 & 255) + "." + (var0 >> 16 & 255) + "." + (var0 >> 8 & 255) + "." + (var0 & 255);
   }
}
