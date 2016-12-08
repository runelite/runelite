import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
public abstract class class119 {
   @ObfuscatedName("bh")
   static class184 field1864;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1807166337
   )
   public int field1865;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -733832471
   )
   public int field1866;
   @ObfuscatedName("c")
   public static short[][] field1867;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1078424565
   )
   public int field1870;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1186895913
   )
   public int field1871;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1252276071"
   )
   static void method2234() {
      FileOnDisk var0 = null;

      try {
         var0 = class33.method676("", class145.field2024.field2700, true);
         Buffer var1 = XGrandExchangeOffer.field35.method633();
         var0.method1387(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(null != var0) {
            var0.method1400();
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1827404888"
   )
   @Export("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class47.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.method885(var0, var1, var2, var3);
      class47.field945.method2259(var5, (long)var5.id);
      class47.field939.method2409(var5);
      Client.field457 = Client.field469;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2018911661"
   )
   public static void method2238(int var0) {
      class138.field1929 = 1;
      class138.field1930 = null;
      class138.field1931 = -1;
      class181.field2711 = -1;
      class138.field1932 = 0;
      CombatInfo1.field665 = false;
      WidgetNode.field186 = var0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "-1652788895"
   )
   public abstract boolean vmethod2239(int var1, int var2, int var3, CollisionData var4);
}
