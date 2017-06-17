import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("z")
   @Export("top")
   Renderable top;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 710711513
   )
   @Export("x")
   int x;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1940262723
   )
   @Export("y")
   int y;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1803170169
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("m")
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("w")
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1790925017
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -627781191
   )
   @Export("height")
   int height;

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)V",
      garbageValue = "1"
   )
   static final void method2307(String var0, boolean var1) {
      if(var0 != null) {
         if((Client.ignoreCount < 100 || Client.field1176 == 1) && Client.ignoreCount < 400) {
            String var2 = class109.method1965(var0, class33.field482);
            if(var2 != null) {
               int var3;
               String var4;
               String var5;
               for(var3 = 0; var3 < Client.ignoreCount; ++var3) {
                  Ignore var6 = Client.ignores[var3];
                  var4 = class109.method1965(var6.name, class33.field482);
                  if(var4 != null && var4.equals(var2)) {
                     class5.sendGameMessage(31, "", var0 + " is already on your ignore list");
                     return;
                  }

                  if(var6.previousName != null) {
                     var5 = class109.method1965(var6.previousName, class33.field482);
                     if(var5 != null && var5.equals(var2)) {
                        class5.sendGameMessage(31, "", var0 + " is already on your ignore list");
                        return;
                     }
                  }
               }

               for(var3 = 0; var3 < Client.friendCount; ++var3) {
                  Friend var7 = Client.friends[var3];
                  var4 = class109.method1965(var7.name, class33.field482);
                  if(var4 != null && var4.equals(var2)) {
                     class5.sendGameMessage(31, "", "Please remove " + var0 + " from your friend list first");
                     return;
                  }

                  if(var7.previousName != null) {
                     var5 = class109.method1965(var7.previousName, class33.field482);
                     if(var5 != null && var5.equals(var2)) {
                        class5.sendGameMessage(31, "", "Please remove " + var0 + " from your friend list first");
                        return;
                     }
                  }
               }

               if(class109.method1965(class20.localPlayer.name, class33.field482).equals(var2)) {
                  class5.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
               } else {
                  Client.secretPacketBuffer1.putOpcode(148);
                  Client.secretPacketBuffer1.putByte(Friend.method1023(var0));
                  Client.secretPacketBuffer1.method3125(var0);
               }
            }
         } else {
            class5.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IZI)Ljava/lang/String;",
      garbageValue = "551223884"
   )
   public static String method2308(int var0, boolean var1) {
      if(var1 && var0 >= 0) {
         int var2 = var0;
         String var3;
         if(var1 && var0 >= 0) {
            int var4 = 2;

            for(int var5 = var0 / 10; var5 != 0; ++var4) {
               var5 /= 10;
            }

            char[] var9 = new char[var4];
            var9[0] = 43;

            for(int var6 = var4 - 1; var6 > 0; --var6) {
               int var7 = var2;
               var2 /= 10;
               int var8 = var7 - var2 * 10;
               if(var8 >= 10) {
                  var9[var6] = (char)(var8 + 87);
               } else {
                  var9[var6] = (char)(var8 + 48);
               }
            }

            var3 = new String(var9);
         } else {
            var3 = Integer.toString(var0, 10);
         }

         return var3;
      } else {
         return Integer.toString(var0);
      }
   }
}
