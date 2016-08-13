import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 676138825
   )
   @Export("type")
   int type;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 420119609
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("s")
   @Export("value")
   String value;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1163282247
   )
   @Export("id")
   int id = class18.method213();
   @ObfuscatedName("p")
   static int[] field809;
   @ObfuscatedName("e")
   @Export("name")
   String name;
   @ObfuscatedName("h")
   @Export("sender")
   String sender;
   @ObfuscatedName("m")
   public static boolean field814;
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = -305526007
   )
   static int field817;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "10"
   )
   void method780(int var1, String var2, String var3, String var4) {
      this.id = class18.method213();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "736617135"
   )
   static void method781(String var0, String var1, String var2) {
      class33.loginMessage1 = var0;
      class33.loginMessage2 = var1;
      class33.loginMessage3 = var2;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "110"
   )
   static int method784(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.field2057[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   MessageNode(int var1, String var2, String var3, String var4) {
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }
}
