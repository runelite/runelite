import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.mapping.Replace;

@ObfuscatedName("ex")
@Implements("RSCanvas")
@Replace("net.runelite.inject.RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("s")
   Component field2181;

   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "719651763"
   )
   static final void method2928(String var0) {
      if(var0 != null) {
         if((Client.friendCount < 200 || Client.field387 == 1) && Client.friendCount < 400) {
            String var1 = XItemContainer.method178(var0, Client.field518);
            if(var1 != null) {
               int var2;
               String var4;
               String var5;
               for(var2 = 0; var2 < Client.friendCount; ++var2) {
                  Friend var3 = Client.friends[var2];
                  var4 = XItemContainer.method178(var3.name, Client.field518);
                  if(null != var4 && var4.equals(var1)) {
                     Player.sendGameMessage(30, "", var0 + " is already on your friend list");
                     return;
                  }

                  if(var3.previousName != null) {
                     var5 = XItemContainer.method178(var3.previousName, Client.field518);
                     if(null != var5 && var5.equals(var1)) {
                        Player.sendGameMessage(30, "", var0 + " is already on your friend list");
                        return;
                     }
                  }
               }

               for(var2 = 0; var2 < Client.ignoreCount; ++var2) {
                  Ignore var6 = Client.ignores[var2];
                  var4 = XItemContainer.method178(var6.name, Client.field518);
                  if(var4 != null && var4.equals(var1)) {
                     Player.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                     return;
                  }

                  if(null != var6.previousName) {
                     var5 = XItemContainer.method178(var6.previousName, Client.field518);
                     if(var5 != null && var5.equals(var1)) {
                        Player.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                        return;
                     }
                  }
               }

               if(XItemContainer.method178(TextureProvider.localPlayer.name, Client.field518).equals(var1)) {
                  Player.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
               } else {
                  Client.field300.method2748(48);
                  Client.field300.method2467(class113.method2395(var0));
                  Client.field300.method2472(var0);
               }
            }
         } else {
            Player.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IZB)Ljava/lang/String;",
      garbageValue = "87"
   )
   public static String method2929(int var0, boolean var1) {
      if(var1 && var0 >= 0) {
         int var3 = var0;
         String var2;
         if(var1 && var0 >= 0) {
            int var4 = 2;

            for(int var5 = var0 / 10; var5 != 0; ++var4) {
               var5 /= 10;
            }

            char[] var6 = new char[var4];
            var6[0] = 43;

            for(int var7 = var4 - 1; var7 > 0; --var7) {
               int var8 = var3;
               var3 /= 10;
               int var9 = var8 - 10 * var3;
               if(var9 >= 10) {
                  var6[var7] = (char)(87 + var9);
               } else {
                  var6[var7] = (char)(var9 + 48);
               }
            }

            var2 = new String(var6);
         } else {
            var2 = Integer.toString(var0, 10);
         }

         return var2;
      } else {
         return Integer.toString(var0);
      }
   }

   public final void paint(Graphics var1) {
      this.field2181.paint(var1);
   }

   RSCanvas(Component var1) {
      this.field2181 = var1;
   }

   public final void update(Graphics var1) {
      this.field2181.update(var1);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public static void method2933() {
      if(null != class143.mouse) {
         class143 var0 = class143.mouse;
         synchronized(class143.mouse) {
            class143.mouse = null;
         }
      }

   }
}
