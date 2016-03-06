import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dv")
public abstract class class106 {
   @ObfuscatedName("f")
   static int[] field1884;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1941352069
   )
   public int field1885;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1179236901
   )
   public int field1886;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1847655269
   )
   public int field1888;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 321407347
   )
   public int field1889;

   @ObfuscatedName("j")
   protected abstract boolean vmethod2336(int var1, int var2);

   @ObfuscatedName("dp")
   static final void method2338(String var0) {
      if(var0 != null) {
         if((client.field421 < 200 || client.field412 == 1) && client.field421 < 400) {
            String var1 = class134.method2803(var0, client.field473);
            if(null != var1) {
               int var2;
               String var4;
               String var5;
               for(var2 = 0; var2 < client.field421; ++var2) {
                  class17 var3 = client.field557[var2];
                  var4 = class134.method2803(var3.field253, client.field473);
                  if(var4 != null && var4.equals(var1)) {
                     class16.method186(30, "", var0 + " is already on your friend list");
                     return;
                  }

                  if(var3.field247 != null) {
                     var5 = class134.method2803(var3.field247, client.field473);
                     if(null != var5 && var5.equals(var1)) {
                        class16.method186(30, "", var0 + " is already on your friend list");
                        return;
                     }
                  }
               }

               for(var2 = 0; var2 < client.field559; ++var2) {
                  class7 var6 = client.field560[var2];
                  var4 = class134.method2803(var6.field139, client.field473);
                  if(var4 != null && var4.equals(var1)) {
                     class16.method186(30, "", "Please remove " + var0 + " from your ignore list first");
                     return;
                  }

                  if(null != var6.field136) {
                     var5 = class134.method2803(var6.field136, client.field473);
                     if(null != var5 && var5.equals(var1)) {
                        class16.method186(30, "", "Please remove " + var0 + " from your ignore list first");
                        return;
                     }
                  }
               }

               if(class134.method2803(class148.field2249.field48, client.field473).equals(var1)) {
                  class16.method186(30, "", "You can\'t add yourself to your own friend list");
               } else {
                  client.field329.method2686(89);
                  client.field329.method2438(class36.method742(var0));
                  client.field329.method2444(var0);
               }
            }
         } else {
            class16.method186(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
         }
      }
   }

   @ObfuscatedName("l")
   public static int method2339(CharSequence var0) {
      return class128.method2756(var0, 10);
   }
}
