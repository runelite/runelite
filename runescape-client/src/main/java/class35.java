import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class35 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Laz;"
   )
   static final class35 field510;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Laz;"
   )
   static final class35 field506;
   @ObfuscatedName("no")
   @Export("clanChatRank")
   static byte clanChatRank;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1753094617
   )
   final int field512;

   static {
      field510 = new class35(0);
      field506 = new class35(1);
   }

   class35(int var1) {
      this.field512 = var1;
   }

   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-47543402"
   )
   static final void method518() {
      if(ScriptEvent.rssocket != null) {
         ScriptEvent.rssocket.close();
         ScriptEvent.rssocket = null;
      }

      class19.method171();
      ScriptState.region.reset();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].reset();
      }

      System.gc();
      class170.method3216(2);
      Client.field1168 = -1;
      Client.field1169 = false;
      class204.method3749();
      WorldMapType2.setGameState(10);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZI)V",
      garbageValue = "1785123402"
   )
   public static void method517(String var0, boolean var1, boolean var2) {
      class43.method651(var0, var1, "openjs", var2);
   }
}
