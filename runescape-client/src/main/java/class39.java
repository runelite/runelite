import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public class class39 {
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      intValue = -1291016165
   )
   static int field554;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lao;"
   )
   final class33 field551;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 360184711
   )
   public final int field556;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1720115233
   )
   int field552;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   public final Coordinates field559;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   public final Coordinates field548;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1397565909
   )
   final int field547;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -574248361
   )
   int field549;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1225890451
   )
   final int field550;

   @ObfuscatedSignature(
      signature = "(ILhg;Lhg;Lao;)V"
   )
   class39(int var1, Coordinates var2, Coordinates var3, class33 var4) {
      this.field556 = var1;
      this.field559 = var2;
      this.field548 = var3;
      this.field551 = var4;
      Area var5 = Area.field3285[this.field556];
      SpritePixels var6 = var5.method4368(false);
      if(var6 != null) {
         this.field547 = var6.width;
         this.field550 = var6.height;
      } else {
         this.field547 = 0;
         this.field550 = 0;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "2012136784"
   )
   boolean method525(int var1, int var2) {
      Area var3 = Area.field3285[this.field556];
      switch(var3.field3294.field3547) {
      case 0:
         if(var1 > this.field552 - this.field547 && var1 <= this.field552) {
            break;
         }

         return false;
      case 1:
         if(var1 >= this.field552 && var1 < this.field552 + this.field547) {
            break;
         }

         return false;
      case 2:
         if(var1 < this.field552 - this.field547 / 2 || var1 > this.field547 / 2 + this.field552) {
            return false;
         }
      }

      switch(var3.field3301.field3266) {
      case 0:
         if(var2 > this.field549 - this.field550 && var2 <= this.field549) {
            break;
         }

         return false;
      case 1:
         if(var2 < this.field549 || var2 >= this.field550 + this.field549) {
            return false;
         }
         break;
      case 2:
         if(var2 < this.field549 - this.field550 / 2 || var2 > this.field550 / 2 + this.field549) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "543260899"
   )
   boolean method537(int var1, int var2) {
      return this.field551 == null?false:(var1 >= this.field552 - this.field551.field479 / 2 && var1 <= this.field551.field479 / 2 + this.field552?var2 >= this.field549 && var2 <= this.field551.field478 + this.field549:false);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-73"
   )
   boolean method523(int var1, int var2) {
      return this.method525(var1, var2)?true:this.method537(var1, var2);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lip;II)Ljo;",
      garbageValue = "202545142"
   )
   public static IndexedSprite method530(IndexDataBase var0, int var1) {
      return !CombatInfo1.method1542(var0, var1)?null:class175.method3460();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-2107776801"
   )
   @Export("addChatMessage")
   @Hook("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class96.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class96.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.addMessage(var0, var1, var2, var3);
      class96.field1516.put(var5, (long)var5.id);
      class96.field1517.method3752(var5);
      Client.chatCycle = Client.cycleCntr;
   }

   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIB)V",
      garbageValue = "17"
   )
   static final void method522(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      PendingSpawn var9 = null;

      for(PendingSpawn var10 = (PendingSpawn)Client.pendingSpawns.getFront(); var10 != null; var10 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0 == var10.level && var10.x == var1 && var2 == var10.y && var3 == var10.type) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new PendingSpawn();
         var9.level = var0;
         var9.type = var3;
         var9.x = var1;
         var9.y = var2;
         class114.method2166(var9);
         Client.pendingSpawns.addFront(var9);
      }

      var9.id = var4;
      var9.field1202 = var5;
      var9.orientation = var6;
      var9.delay = var7;
      var9.hitpoints = var8;
   }
}
