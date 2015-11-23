package net.runelite.rs.client;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("c")
@Implements("XClanMember")
public class class24 extends class207 {
   @ObfuscatedName("j")
   @Export("username")
   String field604;
   @ObfuscatedName("m")
   String field605;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1116075037
   )
   @Export("world")
   int field606;
   @ObfuscatedName("l")
   @Export("rank")
   byte field607;
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = 1770231929
   )
   static int field609;
   @ObfuscatedName("dk")
   @Export("region")
   static class85 field610;

   @ObfuscatedName("l")
   public static int method638(CharSequence var0, int var1) {
      return client.method585(var0, var1);
   }

   @ObfuscatedName("cw")
   static final void method639(boolean var0) {
      int var1 = client.field438;
      int var2 = class129.field2048;
      int var3 = class136.field2101;
      if(class167.method3400(var1)) {
         class93.method2183(class172.field2857[var1], -1, var2, var3, var0);
      }

   }
}
