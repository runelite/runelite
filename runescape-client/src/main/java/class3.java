import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
final class class3 implements class0 {
   @ObfuscatedName("jj")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   static Widget field14;

   @ObfuscatedName("o")
   static final void method9(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("gi")
   @ObfuscatedSignature(
      signature = "(Lbr;I)V",
      garbageValue = "-1794503035"
   )
   static final void method8(PendingSpawn var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.type == 0) {
         var1 = class19.region.method2760(var0.level, var0.x, var0.y);
      }

      if(var0.type == 1) {
         var1 = class19.region.method2616(var0.level, var0.x, var0.y);
      }

      if(var0.type == 2) {
         var1 = class19.region.method2645(var0.level, var0.x, var0.y);
      }

      if(var0.type == 3) {
         var1 = class19.region.method2646(var0.level, var0.x, var0.y);
      }

      if(var1 != 0) {
         int var5 = class19.region.method2715(var0.level, var0.x, var0.y, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field1196 = var2;
      var0.field1190 = var3;
      var0.field1189 = var4;
   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "255974951"
   )
   static final void method10(String var0, boolean var1) {
      if(var0 != null) {
         if((Client.ignoreCount < 100 || Client.field1026 == 1) && Client.ignoreCount < 400) {
            String var2 = class215.method3908(var0, class22.field331);
            if(var2 != null) {
               int var3;
               String var5;
               String var6;
               for(var3 = 0; var3 < Client.ignoreCount; ++var3) {
                  Ignore var4 = Client.ignores[var3];
                  var5 = class215.method3908(var4.name, class22.field331);
                  if(var5 != null && var5.equals(var2)) {
                     Item.sendGameMessage(31, "", var0 + " is already on your ignore list");
                     return;
                  }

                  if(var4.previousName != null) {
                     var6 = class215.method3908(var4.previousName, class22.field331);
                     if(var6 != null && var6.equals(var2)) {
                        Item.sendGameMessage(31, "", var0 + " is already on your ignore list");
                        return;
                     }
                  }
               }

               for(var3 = 0; var3 < Client.friendCount; ++var3) {
                  Friend var7 = Client.friends[var3];
                  var5 = class215.method3908(var7.name, class22.field331);
                  if(var5 != null && var5.equals(var2)) {
                     Item.sendGameMessage(31, "", "Please remove " + var0 + " from your friend list first");
                     return;
                  }

                  if(var7.previousName != null) {
                     var6 = class215.method3908(var7.previousName, class22.field331);
                     if(var6 != null && var6.equals(var2)) {
                        Item.sendGameMessage(31, "", "Please remove " + var0 + " from your friend list first");
                        return;
                     }
                  }
               }

               if(class215.method3908(class226.localPlayer.name, class22.field331).equals(var2)) {
                  Item.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
               } else {
                  Client.secretPacketBuffer1.putOpcode(11);
                  Client.secretPacketBuffer1.putByte(class15.getLength(var0));
                  Client.secretPacketBuffer1.putString(var0);
               }
            }
         } else {
            Item.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
         }
      }
   }
}
