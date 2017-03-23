import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("c")
@Implements("XClanMember")
public class XClanMember extends Node {
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = 1480974139
   )
   static int field284;
   @ObfuscatedName("q")
   public static class60 field285;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1173822541
   )
   @Export("world")
   int world;
   @ObfuscatedName("h")
   @Export("rank")
   byte rank;
   @ObfuscatedName("f")
   @Export("username")
   String username;
   @ObfuscatedName("i")
   String field291;
   @ObfuscatedName("qt")
   @ObfuscatedGetter(
      intValue = -923445599
   )
   static int field293;
   @ObfuscatedName("dl")
   static int[] field296;
}
