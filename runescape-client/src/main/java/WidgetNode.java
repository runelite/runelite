import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("ok")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   @Export("clanMemberManager")
   static ClanMemberManager clanMemberManager;
   @ObfuscatedName("ko")
   @ObfuscatedGetter(
      intValue = -1391571075
   )
   static int field785;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1465819719
   )
   @Export("id")
   int id;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 806722373
   )
   @Export("owner")
   int owner;
   @ObfuscatedName("n")
   boolean field780;

   WidgetNode() {
      this.field780 = false;
   }
}
