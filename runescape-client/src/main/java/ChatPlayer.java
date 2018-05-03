import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ku")
@Implements("ChatPlayer")
public class ChatPlayer extends Nameable {
   @ObfuscatedName("c")
   @Export("spritePixels")
   static byte[][] spritePixels;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2090131465
   )
   @Export("world")
   public int world;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -671924675
   )
   public int field3851;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -176529735
   )
   @Export("rank")
   public int rank;

   ChatPlayer() {
      this.world = -1;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-509080454"
   )
   void method5454(int var1, int var2) {
      this.world = var1;
      this.field3851 = var2;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-111"
   )
   public int method5456() {
      return this.world;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "28754"
   )
   public boolean method5458() {
      return this.world > 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1156402743"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      WorldMapRegion.addChatMessage(var0, var1, var2, (String)null);
   }
}
