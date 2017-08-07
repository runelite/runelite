import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
final class class18 implements Comparator {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("skin_ref")
   public static IndexDataBase skin_ref;
   @ObfuscatedName("j")
   static int[] field316;
   @ObfuscatedName("pr")
   @ObfuscatedGetter(
      intValue = -1469298355
   )
   static int field315;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ls;Ls;I)I",
      garbageValue = "1987382456"
   )
   int method139(class14 var1, class14 var2) {
      return var1.method71().compareTo(var2.method71());
   }

   public int compare(Object var1, Object var2) {
      return this.method139((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1173298271"
   )
   public static void method142() {
      class252.field3378.reset();
   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(Lbb;ZI)V",
      garbageValue = "763830006"
   )
   static final void method141(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1) {
         class99.method1881(var2);
      }

      class51.method773(var2);
      Widget var4 = class266.method4862(var3);
      if(var4 != null) {
         class255.method4531(var4);
      }

      class5.method11();
      if(Client.widgetRoot != -1) {
         int var5 = Client.widgetRoot;
         if(class10.loadWidget(var5)) {
            class31.method280(Item.widgets[var5], 1);
         }
      }

   }

   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "([BIB)V",
      garbageValue = "10"
   )
   static void method140(byte[] var0, int var1) {
      if(Client.field950 == null) {
         Client.field950 = new byte[24];
      }

      class184.method3473(var0, var1, Client.field950, 0, 24);
   }

   @ObfuscatedName("jm")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1748975864"
   )
   static final void method130(String var0) {
      if(var0 != null) {
         if((Client.friendCount < 200 || Client.field1077 == 1) && Client.friendCount < 400) {
            String var1 = class9.method50(var0, class29.field422);
            if(var1 != null) {
               int var2;
               String var4;
               String var5;
               for(var2 = 0; var2 < Client.friendCount; ++var2) {
                  Friend var3 = Client.friends[var2];
                  var4 = class9.method50(var3.name, class29.field422);
                  if(var4 != null && var4.equals(var1)) {
                     WorldMapType3.sendGameMessage(30, "", var0 + " is already on your friend list");
                     return;
                  }

                  if(var3.previousName != null) {
                     var5 = class9.method50(var3.previousName, class29.field422);
                     if(var5 != null && var5.equals(var1)) {
                        WorldMapType3.sendGameMessage(30, "", var0 + " is already on your friend list");
                        return;
                     }
                  }
               }

               for(var2 = 0; var2 < Client.ignoreCount; ++var2) {
                  Ignore var6 = Client.ignores[var2];
                  var4 = class9.method50(var6.name, class29.field422);
                  if(var4 != null && var4.equals(var1)) {
                     WorldMapType3.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                     return;
                  }

                  if(var6.previousName != null) {
                     var5 = class9.method50(var6.previousName, class29.field422);
                     if(var5 != null && var5.equals(var1)) {
                        WorldMapType3.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                        return;
                     }
                  }
               }

               if(class9.method50(class54.localPlayer.name, class29.field422).equals(var1)) {
                  WorldMapType3.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
               } else {
                  Client.secretPacketBuffer1.putOpcode(68);
                  Client.secretPacketBuffer1.putByte(class45.getLength(var0));
                  Client.secretPacketBuffer1.putString(var0);
               }
            }
         } else {
            WorldMapType3.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
         }
      }
   }
}
