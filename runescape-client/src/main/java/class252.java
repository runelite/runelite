import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("ie")
public class class252 extends CacheableNode {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   public static IndexDataBase field3397;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   public static NodeCache field3394;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "[Ljo;"
   )
   @Export("titlemuteSprite")
   static IndexedSprite[] titlemuteSprite;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   IterableHashTable field3395;

   static {
      field3394 = new NodeCache(64);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   public void method4532() {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfz;I)V",
      garbageValue = "1783600342"
   )
   public void method4539(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4537(var1, var2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lfz;II)V",
      garbageValue = "-1618099149"
   )
   void method4537(Buffer var1, int var2) {
      if(var2 == 249) {
         this.field3395 = FileOnDisk.method2427(var1, this.field3395);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1230459668"
   )
   public int method4536(int var1, int var2) {
      return class227.method4159(this.field3395, var1, var2);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "345487540"
   )
   public String method4535(int var1, String var2) {
      return class204.method3902(this.field3395, var1, var2);
   }

   @ObfuscatedName("jv")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "657157511"
   )
   static final void method4533(String var0, boolean var1) {
      if(var0 != null) {
         if((Client.ignoreCount < 100 || Client.field1036 == 1) && Client.ignoreCount < 400) {
            String var2 = WidgetNode.method1087(var0, Permission.field3169);
            if(var2 != null) {
               int var3;
               String var5;
               String var6;
               for(var3 = 0; var3 < Client.ignoreCount; ++var3) {
                  Ignore var4 = Client.ignores[var3];
                  var5 = WidgetNode.method1087(var4.name, Permission.field3169);
                  if(var5 != null && var5.equals(var2)) {
                     class174.sendGameMessage(31, "", var0 + " is already on your ignore list");
                     return;
                  }

                  if(var4.previousName != null) {
                     var6 = WidgetNode.method1087(var4.previousName, Permission.field3169);
                     if(var6 != null && var6.equals(var2)) {
                        class174.sendGameMessage(31, "", var0 + " is already on your ignore list");
                        return;
                     }
                  }
               }

               for(var3 = 0; var3 < Client.friendCount; ++var3) {
                  Friend var7 = Client.friends[var3];
                  var5 = WidgetNode.method1087(var7.name, Permission.field3169);
                  if(var5 != null && var5.equals(var2)) {
                     class174.sendGameMessage(31, "", "Please remove " + var0 + " from your friend list first");
                     return;
                  }

                  if(var7.previousName != null) {
                     var6 = WidgetNode.method1087(var7.previousName, Permission.field3169);
                     if(var6 != null && var6.equals(var2)) {
                        class174.sendGameMessage(31, "", "Please remove " + var0 + " from your friend list first");
                        return;
                     }
                  }
               }

               if(WidgetNode.method1087(class66.localPlayer.name, Permission.field3169).equals(var2)) {
                  class174.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
               } else {
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_ADD_IGNORE);
                  Client.secretPacketBuffer1.putByte(class86.getLength(var0));
                  Client.secretPacketBuffer1.putString(var0);
               }
            }
         } else {
            class174.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
         }
      }
   }
}
