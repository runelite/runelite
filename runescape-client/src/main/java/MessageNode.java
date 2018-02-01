import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("ii")
   @ObfuscatedGetter(
      intValue = 2108394197
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1924365907
   )
   @Export("id")
   int id;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1013229685
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1281856287
   )
   @Export("type")
   int type;
   @ObfuscatedName("s")
   @Export("name")
   String name;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   Name field777;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   class278 field775;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   class278 field776;
   @ObfuscatedName("r")
   @Export("sender")
   String sender;
   @ObfuscatedName("m")
   @Export("value")
   String value;

   @Hook(
      value = "setMessage",
      end = true
   )
   MessageNode(int var1, String var2, String var3, String var4) {
      this.field775 = class278.field3690;
      this.field776 = class278.field3690;
      this.id = class61.method1046();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.method1096();
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1401089994"
   )
   @Export("setMessage")
   @Hook(
      value = "setMessage",
      end = true
   )
   void setMessage(int var1, String var2, String var3, String var4) {
      this.id = class61.method1046();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.method1096();
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "62"
   )
   void method1113() {
      this.field775 = class278.field3690;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "14"
   )
   final boolean method1091() {
      if(this.field775 == class278.field3690) {
         this.method1092();
      }

      return this.field775 == class278.field3691;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-741286953"
   )
   void method1092() {
      this.field775 = ServerPacket.friendManager.field1191.isMember(this.field777)?class278.field3691:class278.field3692;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1612697559"
   )
   void method1093() {
      this.field776 = class278.field3690;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1867831269"
   )
   final boolean method1116() {
      if(this.field776 == class278.field3690) {
         this.method1095();
      }

      return this.field776 == class278.field3691;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1887164697"
   )
   void method1095() {
      this.field776 = ServerPacket.friendManager.field1196.isMember(this.field777)?class278.field3691:class278.field3692;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1868770268"
   )
   final void method1096() {
      if(this.name != null) {
         this.field777 = new Name(class33.method361(this.name), class34.loginType);
      } else {
         this.field777 = null;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgs;ILjava/lang/String;B)Ljava/lang/String;",
      garbageValue = "115"
   )
   static String method1088(IterableHashTable var0, int var1, String var2) {
      if(var0 == null) {
         return var2;
      } else {
         ObjectNode var3 = (ObjectNode)var0.get((long)var1);
         return var3 == null?var2:(String)var3.value;
      }
   }
}
