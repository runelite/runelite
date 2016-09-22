import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
public class class217 {
   @ObfuscatedName("v")
   public final XGrandExchangeOffer field3202;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = 3916956705484409275L
   )
   public final long field3203;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1468218515
   )
   public final int field3204;
   @ObfuscatedName("r")
   String field3205;
   @ObfuscatedName("z")
   String field3206;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1105075323"
   )
   @Export("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class11.chatLineMap.get(Integer.valueOf(var0));
      if(null == var4) {
         var4 = new ChatLineBuffer();
         class11.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.method668(var0, var1, var2, var3);
      class11.field166.method3837(var5, (long)var5.id);
      class11.field167.method3888(var5);
      Client.field560 = Client.field465;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "103"
   )
   public String method4000() {
      return this.field3205;
   }

   class217(Buffer var1, byte var2, int var3) {
      this.field3205 = var1.method2530();
      this.field3206 = var1.method2530();
      this.field3204 = var1.method2717();
      this.field3203 = var1.method2534();
      int var4 = var1.method2533();
      int var5 = var1.method2533();
      this.field3202 = new XGrandExchangeOffer();
      this.field3202.method4055(2);
      this.field3202.method4043(var2);
      this.field3202.price = var4;
      this.field3202.totalQuantity = var5;
      this.field3202.quantitySold = 0;
      this.field3202.spent = 0;
      this.field3202.itemId = var3;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "0"
   )
   public String method4004() {
      return this.field3206;
   }
}
