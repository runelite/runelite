import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
@Implements("XClanMember")
public class class25 extends class211 {
   @ObfuscatedName("g")
   String field639;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 46592857
   )
   @Export("world")
   int field640;
   @ObfuscatedName("e")
   @Export("rank")
   byte field641;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = 1463598849
   )
   public static int field643;
   @ObfuscatedName("bs")
   static class171 field644;
   @ObfuscatedName("l")
   @Export("username")
   String field645;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1334318092"
   )
   static String method615(int var0) {
      return "<img=" + var0 + ">";
   }
}
