import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iw")
public class class253 extends CacheableNode {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   public static NodeCache field3399;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   IterableHashTable field3394;

   static {
      field3399 = new NodeCache(64);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lfp;IB)V",
      garbageValue = "50"
   )
   void method4457(Buffer var1, int var2) {
      if(var2 == 249) {
         this.field3394 = class34.method516(var1, this.field3394);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "449256614"
   )
   public String method4474(int var1, String var2) {
      return class43.method653(this.field3394, var1, var2);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2045020007"
   )
   public int method4458(int var1, int var2) {
      return class20.method174(this.field3394, var1, var2);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2033059654"
   )
   public void method4455() {
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "1482875009"
   )
   public void method4456(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4457(var1, var2);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "2133101511"
   )
   @Export("setItemTableSlot")
   static void setItemTableSlot(int var0, int var1, int var2, int var3) {
      ItemContainer var4 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var4 == null) {
         var4 = new ItemContainer();
         ItemContainer.itemContainers.put(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }

   @ObfuscatedName("jt")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-1684109970"
   )
   static final void method4462(String var0, boolean var1) {
      if(var0 != null) {
         if((Client.ignoreCount < 100 || Client.field1053 == 1) && Client.ignoreCount < 400) {
            String var2 = Frames.method2925(var0, class8.field243);
            if(var2 != null) {
               int var3;
               String var5;
               String var6;
               for(var3 = 0; var3 < Client.ignoreCount; ++var3) {
                  Ignore var4 = Client.ignores[var3];
                  var5 = Frames.method2925(var4.name, class8.field243);
                  if(var5 != null && var5.equals(var2)) {
                     Client.sendGameMessage(31, "", var0 + " is already on your ignore list");
                     return;
                  }

                  if(var4.previousName != null) {
                     var6 = Frames.method2925(var4.previousName, class8.field243);
                     if(var6 != null && var6.equals(var2)) {
                        Client.sendGameMessage(31, "", var0 + " is already on your ignore list");
                        return;
                     }
                  }
               }

               for(var3 = 0; var3 < Client.friendCount; ++var3) {
                  Friend var7 = Client.friends[var3];
                  var5 = Frames.method2925(var7.name, class8.field243);
                  if(var5 != null && var5.equals(var2)) {
                     Client.sendGameMessage(31, "", "Please remove " + var0 + " from your friend list first");
                     return;
                  }

                  if(var7.previousName != null) {
                     var6 = Frames.method2925(var7.previousName, class8.field243);
                     if(var6 != null && var6.equals(var2)) {
                        Client.sendGameMessage(31, "", "Please remove " + var0 + " from your friend list first");
                        return;
                     }
                  }
               }

               if(Frames.method2925(Player.localPlayer.name, class8.field243).equals(var2)) {
                  Client.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
               } else {
                  Client.secretPacketBuffer1.putOpcode(33);
                  Client.secretPacketBuffer1.putByte(ClanMember.getLength(var0));
                  Client.secretPacketBuffer1.putString(var0);
               }
            }
         } else {
            Client.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
         }
      }
   }
}
