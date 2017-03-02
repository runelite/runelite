import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("h")
   @Export("value")
   String value;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1212774903
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("hl")
   @ObfuscatedGetter(
      intValue = 1168282991
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = 650214447
   )
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("k")
   @Export("sender")
   String sender;
   @ObfuscatedName("t")
   @Export("name")
   String name;
   @ObfuscatedName("o")
   static String field226;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1567723671
   )
   @Export("type")
   int type;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 874299495
   )
   @Export("id")
   int id;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1177755921"
   )
   void method216(int var1, String var2, String var3, String var4) {
      int var5 = ++class47.field925 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   MessageNode(int var1, String var2, String var3, String var4) {
      int var5 = ++class47.field925 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass182;II)Z",
      garbageValue = "-835383448"
   )
   static boolean method217(class182 var0, int var1) {
      byte[] var2 = var0.method3353(var1);
      if(null == var2) {
         return false;
      } else {
         class6.method95(var2);
         return true;
      }
   }
}
