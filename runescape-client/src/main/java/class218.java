import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hi")
public class class218 {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-1542022362"
   )
   public static boolean method4056(char var0) {
      if((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
         if(var0 != 0) {
            char[] var1 = class267.field3653;

            for(int var2 = 0; var2 < var1.length; ++var2) {
               char var3 = var1[var2];
               if(var0 == var3) {
                  return true;
               }
            }
         }

         return false;
      } else {
         return true;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lit;Lit;III)Ljk;",
      garbageValue = "-958861096"
   )
   public static Font method4053(IndexDataBase var0, IndexDataBase var1, int var2, int var3) {
      if(!Script.method1883(var0, var2, var3)) {
         return null;
      } else {
         byte[] var5 = var1.getConfigData(var2, var3);
         Font var4;
         if(var5 == null) {
            var4 = null;
         } else {
            Font var6 = new Font(var5, class287.field3779, class277.offsetsY, class287.field3778, class277.field3719, class287.field3777, class287.spritePixels);
            class262.method4747();
            var4 = var6;
         }

         return var4;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-36"
   )
   public static void method4055() {
      VarPlayerType.varplayers.reset();
   }

   @ObfuscatedName("jq")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "1718209977"
   )
   static final void method4054(String var0, boolean var1) {
      if(var0 != null) {
         if((Client.ignoreCount < 100 || Client.field1077 == 1) && Client.ignoreCount < 400) {
            String var2 = class9.method50(var0, class29.field422);
            if(var2 != null) {
               int var3;
               String var5;
               String var6;
               for(var3 = 0; var3 < Client.ignoreCount; ++var3) {
                  Ignore var4 = Client.ignores[var3];
                  var5 = class9.method50(var4.name, class29.field422);
                  if(var5 != null && var5.equals(var2)) {
                     WorldMapType3.sendGameMessage(31, "", var0 + " is already on your ignore list");
                     return;
                  }

                  if(var4.previousName != null) {
                     var6 = class9.method50(var4.previousName, class29.field422);
                     if(var6 != null && var6.equals(var2)) {
                        WorldMapType3.sendGameMessage(31, "", var0 + " is already on your ignore list");
                        return;
                     }
                  }
               }

               for(var3 = 0; var3 < Client.friendCount; ++var3) {
                  Friend var7 = Client.friends[var3];
                  var5 = class9.method50(var7.name, class29.field422);
                  if(var5 != null && var5.equals(var2)) {
                     WorldMapType3.sendGameMessage(31, "", "Please remove " + var0 + " from your friend list first");
                     return;
                  }

                  if(var7.previousName != null) {
                     var6 = class9.method50(var7.previousName, class29.field422);
                     if(var6 != null && var6.equals(var2)) {
                        WorldMapType3.sendGameMessage(31, "", "Please remove " + var0 + " from your friend list first");
                        return;
                     }
                  }
               }

               if(class9.method50(class54.localPlayer.name, class29.field422).equals(var2)) {
                  WorldMapType3.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
               } else {
                  Client.secretPacketBuffer1.putOpcode(214);
                  Client.secretPacketBuffer1.putByte(class45.getLength(var0));
                  Client.secretPacketBuffer1.putString(var0);
               }
            }
         } else {
            WorldMapType3.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
         }
      }
   }
}
