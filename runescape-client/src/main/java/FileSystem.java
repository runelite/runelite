import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ia")
@Implements("FileSystem")
public class FileSystem extends Node {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2007273829
   )
   @Export("type")
   int type;
   @ObfuscatedName("q")
   public byte[] field3367;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   @Export("index")
   public IndexFile index;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   @Export("data")
   public IndexData data;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1752458693"
   )
   static String method4559() {
      return MapIcon.preferences.hideUsername?Fonts.method5483(class90.username):class90.username;
   }
}
