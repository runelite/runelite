import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
public class class54 extends CacheableNode {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1558172349
   )
   public static int field1154;
   @ObfuscatedName("h")
   static NodeCache field1155 = new NodeCache(64);
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 389431493
   )
   public int field1156 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 368565027
   )
   public static int field1157;
   @ObfuscatedName("i")
   static class170 field1159;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1702012526"
   )
   void method1098(Buffer var1) {
      while(true) {
         int var2 = var1.method2544();
         if(var2 == 0) {
            return;
         }

         this.method1108(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "0"
   )
   void method1108(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field1156 = var1.method2546();
      }

   }

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "60188063"
   )
   static final void method1112(String var0) {
      if(var0 != null) {
         if((Client.friendCount < 200 || Client.field353 == 1) && Client.friendCount < 400) {
            String var1 = class93.method2141(var0, Client.field302);
            if(var1 != null) {
               int var2;
               String var4;
               String var5;
               for(var2 = 0; var2 < Client.friendCount; ++var2) {
                  Friend var3 = Client.friends[var2];
                  var4 = class93.method2141(var3.name, Client.field302);
                  if(var4 != null && var4.equals(var1)) {
                     class110.method2416(30, "", var0 + " is already on your friend list");
                     return;
                  }

                  if(null != var3.previousName) {
                     var5 = class93.method2141(var3.previousName, Client.field302);
                     if(var5 != null && var5.equals(var1)) {
                        class110.method2416(30, "", var0 + " is already on your friend list");
                        return;
                     }
                  }
               }

               for(var2 = 0; var2 < Client.ignoreCount; ++var2) {
                  Ignore var6 = Client.ignores[var2];
                  var4 = class93.method2141(var6.name, Client.field302);
                  if(null != var4 && var4.equals(var1)) {
                     class110.method2416(30, "", "Please remove " + var0 + " from your ignore list first");
                     return;
                  }

                  if(null != var6.previousName) {
                     var5 = class93.method2141(var6.previousName, Client.field302);
                     if(null != var5 && var5.equals(var1)) {
                        class110.method2416(30, "", "Please remove " + var0 + " from your ignore list first");
                        return;
                     }
                  }
               }

               if(class93.method2141(class138.localPlayer.name, Client.field302).equals(var1)) {
                  class110.method2416(30, "", "You can\'t add yourself to your own friend list");
               } else {
                  Client.field378.method2801(5);
                  Client.field378.method2529(class21.method547(var0));
                  Client.field378.method2535(var0);
               }
            }
         } else {
            class110.method2416(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IS)LMessageNode;",
      garbageValue = "24065"
   )
   static MessageNode method1113(int var0) {
      return (MessageNode)class11.field192.method3827((long)var0);
   }
}
