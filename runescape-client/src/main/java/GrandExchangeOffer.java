import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("v")
@Implements("GrandExchangeOffer")
public class GrandExchangeOffer {
   @ObfuscatedName("k")
   @Export("colorsToFind")
   public static short[] colorsToFind;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 284766633
   )
   public static int field309;
   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("indexCache10")
   static IndexData indexCache10;
   @ObfuscatedName("d")
   @Export("state")
   byte state;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1793968015
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 759568497
   )
   @Export("price")
   public int price;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -547290191
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1317485775
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 84543113
   )
   @Export("spent")
   public int spent;

   public GrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      signature = "(Lgy;Z)V",
      garbageValue = "0"
   )
   public GrandExchangeOffer(Buffer var1, boolean var2) {
      this.state = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.readInt();
      this.totalQuantity = var1.readInt();
      this.quantitySold = var1.readInt();
      this.spent = var1.readInt();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-116"
   )
   @Export("status")
   public int status() {
      return this.state & 7;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-67"
   )
   @Export("type")
   public int type() {
      return (this.state & 8) == 8?1:0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1533137850"
   )
   void method116(int var1) {
      this.state &= -8;
      this.state = (byte)(this.state | var1 & 7);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   void method104(int var1) {
      this.state &= -9;
      if(var1 == 1) {
         this.state = (byte)(this.state | 8);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "2"
   )
   static String method119() {
      String var0;
      if(class55.preferences.hideUsername) {
         String var2 = class90.username;
         int var4 = var2.length();
         char[] var5 = new char[var4];

         for(int var6 = 0; var6 < var4; ++var6) {
            var5[var6] = '*';
         }

         String var3 = new String(var5);
         var0 = var3;
      } else {
         var0 = class90.username;
      }

      return var0;
   }

   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-78"
   )
   static final void method117() {
      for(int var0 = 0; var0 < class93.playerIndexesCount; ++var0) {
         Player var1 = Client.cachedPlayers[class93.playerIndices[var0]];
         var1.method1144();
      }

   }

   @ObfuscatedName("jc")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-455817517"
   )
   static void method103(String var0) {
      class25.sessionToken = var0;

      try {
         String var1 = class23.clientInstance.getParameter(Parameters.field3809.key);
         String var2 = class23.clientInstance.getParameter(Parameters.field3806.key);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            var3 = var3 + "; Expires=" + FontName.method5594(PendingSpawn.currentTimeMs() + 94608000000L) + "; Max-Age=" + 94608000L;
         }

         Client var4 = class23.clientInstance;
         String var5 = "document.cookie=\"" + var3 + "\"";
         JSObject.getWindow(var4).eval(var5);
      } catch (Throwable var6) {
         ;
      }

   }
}
