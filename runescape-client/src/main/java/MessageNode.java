import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("kx")
   @ObfuscatedGetter(
      intValue = 1710636095
   )
   @Export("selectedItemIndex")
   static int selectedItemIndex;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1747797677
   )
   @Export("id")
   int id;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -844607143
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1067506707
   )
   @Export("type")
   int type;
   @ObfuscatedName("p")
   @Export("name")
   String name;
   @ObfuscatedName("x")
   @Export("sender")
   String sender;
   @ObfuscatedName("g")
   @Export(
      value = "value",
      setter = true
   )
   String value;

   @Hook("setMessage")
   MessageNode(int var1, String var2, String var3, String var4) {
      int var5 = ++class99.field1534 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1326429159"
   )
   @Export("setMessage")
   @Hook("setMessage")
   void setMessage(int var1, String var2, String var3, String var4) {
      int var5 = ++class99.field1534 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-41"
   )
   static final boolean method1177(int var0, int var1) {
      ObjectComposition var2 = class37.getObjectDefinition(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method4559(var1);
   }
}
