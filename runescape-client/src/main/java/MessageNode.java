import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -843744509
   )
   @Export("id")
   int id;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2106053445
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 120597049
   )
   @Export("type")
   int type;
   @ObfuscatedName("y")
   @Export("name")
   String name;
   @ObfuscatedName("e")
   @Export("sender")
   String sender;
   @ObfuscatedName("f")
   @Export(
      value = "value",
      setter = true
   )
   String value;

   @Hook("setMessage")
   MessageNode(int var1, String var2, String var3, String var4) {
      int var5 = ++class98.field1493 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "2053436803"
   )
   @Export("setMessage")
   @Hook("setMessage")
   void setMessage(int var1, String var2, String var3, String var4) {
      int var5 = ++class98.field1493 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }
}
