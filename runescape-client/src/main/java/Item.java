import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 109985537
   )
   @Export("quantity")
   int quantity;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1040725819
   )
   @Export("id")
   int id;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1920862480"
   )
   static final int method1739(int var0, int var1) {
      int var2 = class217.method4080(var0 - 1, var1 - 1) + class217.method4080(var0 + 1, var1 - 1) + class217.method4080(var0 - 1, var1 + 1) + class217.method4080(var0 + 1, var1 + 1);
      int var3 = class217.method4080(var0 - 1, var1) + class217.method4080(var0 + 1, var1) + class217.method4080(var0, var1 - 1) + class217.method4080(var0, var1 + 1);
      int var4 = class217.method4080(var0, var1);
      return var4 / 4 + var2 / 16 + var3 / 8;
   }

   @ObfuscatedName("jb")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "618578762"
   )
   static final void method1740(String var0, boolean var1) {
      if(var0 != null) {
         if((Client.ignoreCount < 100 || Client.field1146 == 1) && Client.ignoreCount < 400) {
            String var2 = CollisionData.method3023(var0, class13.field281);
            if(var2 != null) {
               int var3;
               String var5;
               String var6;
               for(var3 = 0; var3 < Client.ignoreCount; ++var3) {
                  Ignore var4 = Client.ignores[var3];
                  var5 = CollisionData.method3023(var4.name, class13.field281);
                  if(var5 != null && var5.equals(var2)) {
                     class98.sendGameMessage(31, "", var0 + " is already on your ignore list");
                     return;
                  }

                  if(var4.previousName != null) {
                     var6 = CollisionData.method3023(var4.previousName, class13.field281);
                     if(var6 != null && var6.equals(var2)) {
                        class98.sendGameMessage(31, "", var0 + " is already on your ignore list");
                        return;
                     }
                  }
               }

               for(var3 = 0; var3 < Client.friendCount; ++var3) {
                  Friend var7 = Client.friends[var3];
                  var5 = CollisionData.method3023(var7.name, class13.field281);
                  if(var5 != null && var5.equals(var2)) {
                     class98.sendGameMessage(31, "", "Please remove " + var0 + " from your friend list first");
                     return;
                  }

                  if(var7.previousName != null) {
                     var6 = CollisionData.method3023(var7.previousName, class13.field281);
                     if(var6 != null && var6.equals(var2)) {
                        class98.sendGameMessage(31, "", "Please remove " + var0 + " from your friend list first");
                        return;
                     }
                  }
               }

               if(CollisionData.method3023(class168.localPlayer.name, class13.field281).equals(var2)) {
                  class98.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
               } else {
                  Client.secretPacketBuffer1.putOpcode(4);
                  Client.secretPacketBuffer1.putByte(Script.method1836(var0));
                  Client.secretPacketBuffer1.method3150(var0);
               }
            }
         } else {
            class98.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Lclass241;",
      garbageValue = "-1176303125"
   )
   public static class241 method1741(int var0) {
      class241 var1 = (class241)class241.field3290.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class241.field3291.getConfigData(16, var0);
         var1 = new class241();
         if(var2 != null) {
            var1.method4301(new Buffer(var2));
         }

         class241.field3290.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(S)LModel;",
      garbageValue = "-1617"
   )
   protected final Model getModel() {
      return ItemComposition.getItemDefinition(this.id).getModel(this.quantity);
   }
}
