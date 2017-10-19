import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 635401597
   )
   @Export("id")
   int id;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 299916657
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 693106189
   )
   @Export("type")
   int type;
   @ObfuscatedName("o")
   @Export("name")
   String name;
   @ObfuscatedName("g")
   @Export("sender")
   String sender;
   @ObfuscatedName("v")
   @Export(
      value = "value",
      setter = true
   )
   String value;

   @Hook("setMessage")
   MessageNode(int var1, String var2, String var3, String var4) {
      this.id = class28.method230();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-172170919"
   )
   @Export("setMessage")
   @Hook("setMessage")
   void setMessage(int var1, String var2, String var3, String var4) {
      this.id = class28.method230();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }
}
