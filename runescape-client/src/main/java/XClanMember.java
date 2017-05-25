import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
@Implements("XClanMember")
public class XClanMember extends Node {
   @ObfuscatedName("i")
   @Export("username")
   String username;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1602212619
   )
   @Export("world")
   int world;
   @ObfuscatedName("q")
   @Export("rank")
   byte rank;
   @ObfuscatedName("ls")
   @ObfuscatedGetter(
      intValue = 138897281
   )
   static int field886;
   @ObfuscatedName("h")
   String field887;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "79"
   )
   public static final void method1167(int var0, int var1) {
      class134.field1979 = var0;
      class134.field1988 = var1;
      class134.field1980 = true;
      class134.field1986 = 0;
      class134.field1984 = false;
   }
}
