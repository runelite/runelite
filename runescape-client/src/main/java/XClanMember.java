import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
@Implements("XClanMember")
public class XClanMember extends Node {
   @ObfuscatedName("i")
   @Export("username")
   String username;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1237518575
   )
   @Export("world")
   int world;
   @ObfuscatedName("g")
   @Export("rank")
   byte rank;
   @ObfuscatedName("h")
   String field651;
   @ObfuscatedName("nf")
   static class59 field652;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-904197006"
   )
   static int method578(int var0, int var1) {
      long var2 = (long)(var1 + (var0 << 16));
      return null != class189.field3062 && var2 == class189.field3062.hash?class16.field255.offset * 99 / (class16.field255.payload.length - class189.field3062.field2784) + 1:0;
   }
}
