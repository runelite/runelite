import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
@Implements("XClanMember")
public class XClanMember extends Node {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1965805581
   )
   @Export("world")
   int world;
   @ObfuscatedName("z")
   @Export("rank")
   byte rank;
   @ObfuscatedName("m")
   public static short[][] field624;
   @ObfuscatedName("x")
   @Export("username")
   String username;
   @ObfuscatedName("id")
   @ObfuscatedGetter(
      intValue = -223112773
   )
   static int field626;
   @ObfuscatedName("r")
   String field628;
   @ObfuscatedName("s")
   public static Buffer field630;
   @ObfuscatedName("eb")
   static SpritePixels[] field631;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-1041090661"
   )
   public static int method580(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }
}
