import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -640741429
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 933081109
   )
   @Export("type")
   int type;
   @ObfuscatedName("ph")
   @ObfuscatedGetter(
      intValue = 1391063945
   )
   static int field856;
   @ObfuscatedName("f")
   @Export("sender")
   String sender;
   @ObfuscatedName("m")
   @Export("value")
   String value;
   @ObfuscatedName("j")
   @Export("name")
   String name;
   @ObfuscatedName("ao")
   static int[] field860;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -294147131
   )
   @Export("id")
   int id;

   MessageNode(int var1, String var2, String var3, String var4) {
      this.id = class168.method3119();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "618815325"
   )
   public static int method1086(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0:(var2 == 2?7 - var1:var0));
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1873471817"
   )
   void method1088(int var1, String var2, String var3, String var4) {
      this.id = class168.method3119();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }
}
