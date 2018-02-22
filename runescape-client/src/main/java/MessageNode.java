import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("n")
   @Export("tt")
   static int[] tt;
   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   @Export("indexSprites")
   static IndexData indexSprites;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = -1288010233
   )
   static int field774;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -249914091
   )
   @Export("id")
   int id;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 427875377
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1523459275
   )
   @Export("type")
   int type;
   @ObfuscatedName("p")
   @Export("name")
   String name;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   Name field776;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   class289 field769;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   class289 field770;
   @ObfuscatedName("y")
   @Export("sender")
   String sender;
   @ObfuscatedName("g")
   @Export("value")
   String value;

   @Hook(
      value = "setMessage",
      end = true
   )
   MessageNode(int var1, String var2, String var3, String var4) {
      this.field769 = class289.field3723;
      this.field770 = class289.field3723;
      this.id = GrandExchangeOffer.method120();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.method1155();
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "850612943"
   )
   @Export("setMessage")
   @Hook(
      value = "setMessage",
      end = true
   )
   void setMessage(int var1, String var2, String var3, String var4) {
      this.id = GrandExchangeOffer.method120();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.method1155();
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-177924683"
   )
   void method1149() {
      this.field769 = class289.field3723;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "11"
   )
   final boolean method1154() {
      if(this.field769 == class289.field3723) {
         this.method1169();
      }

      return this.field769 == class289.field3722;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2038905855"
   )
   void method1169() {
      this.field769 = ContextMenuRow.friendManager.field1194.isMember(this.field776)?class289.field3722:class289.field3726;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "341404342"
   )
   void method1150() {
      this.field770 = class289.field3723;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "1762"
   )
   final boolean method1172() {
      if(this.field770 == class289.field3723) {
         this.method1152();
      }

      return this.field770 == class289.field3722;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2703283"
   )
   void method1152() {
      this.field770 = ContextMenuRow.friendManager.field1193.isMember(this.field776)?class289.field3722:class289.field3726;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-33"
   )
   final void method1155() {
      if(this.name != null) {
         this.field776 = new Name(class84.method1848(this.name), class234.loginType);
      } else {
         this.field776 = null;
      }

   }
}
