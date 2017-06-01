import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
public class class249 {
   @ObfuscatedName("e")
   public static IndexDataBase field3377;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "18657964"
   )
   public static boolean method4417(int var0) {
      return (var0 & 1) != 0;
   }

   @ObfuscatedName("ef")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-82"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(Client.gameState != var0) {
         if(Client.gameState == 0) {
            Client.field1214.method834();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.loginState = 0;
            Client.field1197 = 0;
            Client.field1029 = 0;
         }

         if(var0 != 20 && var0 != 40 && Player.field917 != null) {
            Player.field917.method2981();
            Player.field917 = null;
         }

         if(Client.gameState == 25) {
            Client.field1142 = 0;
            Client.field1026 = 0;
            Client.field986 = 1;
            Client.field987 = 0;
            Client.field988 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               XGrandExchangeOffer.method87(WidgetNode.field841, class261.indexSprites, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               XGrandExchangeOffer.method87(WidgetNode.field841, class261.indexSprites, false, 4);
            } else if(class21.field334) {
               class92.field1442 = null;
               FileOnDisk.field1782 = null;
               class92.field1470 = null;
               class33.field474 = null;
               class211.field2609 = null;
               class92.field1457 = null;
               class56.field692 = null;
               class3.field28 = null;
               class77.field1237 = null;
               class21.field332 = null;
               class73.field887 = null;
               class9.field249 = null;
               class14.field285 = null;
               class87.field1407 = null;
               class270.field3683 = null;
               FileOnDisk.field1783 = null;
               class89.field1424 = null;
               class100.field1558 = null;
               class10.field258 = null;
               class25.field362 = null;
               class23.field344 = null;
               class21.field327 = null;
               class84.method1668(2);
               Preferences.method1595(true);
               class21.field334 = false;
            }
         } else {
            XGrandExchangeOffer.method87(WidgetNode.field841, class261.indexSprites, true, 0);
         }

         Client.gameState = var0;
      }
   }
}
