import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
@Implements("XGrandExchangeOffer")
public class XGrandExchangeOffer {
   @ObfuscatedName("hh")
   @ObfuscatedGetter(
      intValue = 1233658227
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("i")
   @Export("progress")
   byte progress;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1515552405
   )
   @Export("price")
   public int price;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -740555981
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2046098317
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2059779791
   )
   @Export("spent")
   public int spent;
   @ObfuscatedName("dt")
   static int[] field41;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1983254767
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("b")
   static int[] field44;

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(LPlayer;III)V",
      garbageValue = "2102061811"
   )
   static void method38(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = GameEngine.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field632 = 0;
            var0.actionAnimationDisable = var2;
            var0.field635 = 0;
         }

         if(var3 == 2) {
            var0.field635 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || GameEngine.getAnimation(var1).forcedPriority >= GameEngine.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field632 = 0;
         var0.actionAnimationDisable = var2;
         var0.field635 = 0;
         var0.field607 = var0.field652;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "4982882"
   )
   public int method40() {
      return this.progress & 7;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1788039139"
   )
   public int method41() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-26494"
   )
   void method42(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1431785644"
   )
   void method43(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "0"
   )
   public XGrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.method2844();
      this.totalQuantity = var1.method2844();
      this.quantitySold = var1.method2844();
      this.spent = var1.method2844();
   }

   public XGrandExchangeOffer() {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-973979957"
   )
   static String method56(int var0) {
      return "<img=" + var0 + ">";
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   static int method57() {
      return Client.isResized?2:1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-3139"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(Client.gameState != var0) {
         if(Client.gameState == 0) {
            ChatMessages.field925 = null;
            class88.field1537 = null;
            class37.field791 = null;
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.field316 = 0;
            Client.field317 = 0;
            Client.field318 = 0;
         }

         if(var0 != 20 && var0 != 40 && Client.field326 != null) {
            Client.field326.method2035();
            Client.field326 = null;
         }

         if(Client.gameState == 25) {
            Client.field345 = 0;
            Client.field341 = 0;
            Client.field342 = 1;
            Client.field343 = 0;
            Client.field328 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class16.method180(class110.canvas, CollisionData.field1838, Client.field314, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class16.method180(class110.canvas, CollisionData.field1838, Client.field314, false, 4);
            } else if(class41.field835) {
               class156.field2120 = null;
               class41.field826 = null;
               class41.field827 = null;
               class16.field172 = null;
               class41.field861 = null;
               class101.field1639 = null;
               class210.field3113 = null;
               class142.field1996 = null;
               Friend.field148 = null;
               class41.field860 = null;
               class0.field2 = null;
               class184.field2743 = null;
               class20.field216 = null;
               class37.field789 = null;
               WidgetNode.field181 = null;
               class41.field834 = null;
               class41.field853 = null;
               class41.field833 = null;
               field44 = null;
               class230.field3255 = null;
               GameObject.field1613 = null;
               class119.field1850 = null;
               class138.field1914 = 1;
               class145.field2014 = null;
               class30.field693 = -1;
               class138.field1915 = -1;
               ItemLayer.field1220 = 0;
               ItemLayer.field1221 = false;
               class138.field1916 = 2;
               class185.method3360(true);
               class41.field835 = false;
            }
         } else {
            class16.method180(class110.canvas, CollisionData.field1838, Client.field314, true, 0);
         }

         Client.gameState = var0;
      }
   }
}
