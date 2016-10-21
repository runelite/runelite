import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("t")
   @Export("name")
   String name;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -204757031
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2141859933
   )
   @Export("type")
   int type;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2026767865
   )
   @Export("id")
   int id = ObjectComposition.method858();
   @ObfuscatedName("v")
   @Export("sender")
   String sender;
   @ObfuscatedName("b")
   @Export("value")
   String value;
   @ObfuscatedName("da")
   static byte[][] field798;

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "(LWidget;B)V",
      garbageValue = "-121"
   )
   static void method750(Widget var0) {
      if(Client.field483 == var0.field2920) {
         Client.field526[var0.boundsIndex] = true;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;S)V",
      garbageValue = "7997"
   )
   void method751(int var1, String var2, String var3, String var4) {
      this.id = ObjectComposition.method858();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   MessageNode(int var1, String var2, String var3, String var4) {
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }
}
