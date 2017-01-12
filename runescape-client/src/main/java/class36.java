import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class36 {
   @ObfuscatedName("c")
   static final BigInteger field766 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   @ObfuscatedName("f")
   static final BigInteger field767 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = -259259833
   )
   @Export("cameraX")
   static int cameraX;
   @ObfuscatedName("fx")
   @ObfuscatedGetter(
      intValue = 1342159257
   )
   @Export("cameraZ")
   static int cameraZ;

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1914499018"
   )
   static final void method729(String var0) {
      if(null != var0) {
         if((Client.friendCount < 200 || Client.field461 == 1) && Client.friendCount < 400) {
            String var1 = class139.method2601(var0, Ignore.field209);
            if(var1 != null) {
               int var2;
               String var4;
               String var5;
               for(var2 = 0; var2 < Client.friendCount; ++var2) {
                  Friend var3 = Client.friends[var2];
                  var4 = class139.method2601(var3.name, Ignore.field209);
                  if(var4 != null && var4.equals(var1)) {
                     class7.method99(30, "", var0 + " is already on your friend list");
                     return;
                  }

                  if(var3.previousName != null) {
                     var5 = class139.method2601(var3.previousName, Ignore.field209);
                     if(var5 != null && var5.equals(var1)) {
                        class7.method99(30, "", var0 + " is already on your friend list");
                        return;
                     }
                  }
               }

               for(var2 = 0; var2 < Client.ignoreCount; ++var2) {
                  Ignore var6 = Client.ignores[var2];
                  var4 = class139.method2601(var6.name, Ignore.field209);
                  if(null != var4 && var4.equals(var1)) {
                     class7.method99(30, "", "Please remove " + var0 + " from your ignore list first");
                     return;
                  }

                  if(null != var6.previousName) {
                     var5 = class139.method2601(var6.previousName, Ignore.field209);
                     if(null != var5 && var5.equals(var1)) {
                        class7.method99(30, "", "Please remove " + var0 + " from your ignore list first");
                        return;
                     }
                  }
               }

               if(class139.method2601(class148.localPlayer.name, Ignore.field209).equals(var1)) {
                  class7.method99(30, "", "You can\'t add yourself to your own friend list");
               } else {
                  Client.field326.method3029(222);
                  Client.field326.method2760(class148.method2740(var0));
                  Client.field326.method2811(var0);
               }
            }
         } else {
            class7.method99(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
         }
      }
   }
}
