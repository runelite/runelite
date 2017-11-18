import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1464247761
   )
   @Export("id")
   int id;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1956921585
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -436257843
   )
   @Export("type")
   int type;
   @ObfuscatedName("g")
   @Export("name")
   String name;
   @ObfuscatedName("x")
   @Export("sender")
   String sender;
   @ObfuscatedName("f")
   @Export(
      value = "value"
   )
   String value;

   @Hook("setMessage")
   MessageNode(int var1, String var2, String var3, String var4) {
      this.id = class232.method4089();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "-94"
   )
   @Export("setMessage")
   @Hook("setMessage")
   void setMessage(int var1, String var2, String var3, String var4) {
      this.id = class232.method4089();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1079483618"
   )
   static int method1053(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      return TextureProvider.currentRequest != null && var2 == TextureProvider.currentRequest.hash?SoundTask.field1574.offset * 99 / (SoundTask.field1574.payload.length - TextureProvider.currentRequest.padding) + 1:0;
   }
}
