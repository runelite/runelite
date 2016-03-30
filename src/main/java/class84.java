import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
public class class84 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -280652421
   )
   int field1456;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1314952571
   )
   int field1457;
   @ObfuscatedName("et")
   static class78[] field1462;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -237540657
   )
   int field1463;

   @ObfuscatedName("t")
   public static void method1897() {
      class140 var0 = class140.field2163;
      synchronized(class140.field2163) {
         class140.field2184 = class140.field2165;
         class140.field2168 = class140.field2166;
         class140.field2182 = class140.field2174;
         class140.field2177 = class140.field2171;
         class140.field2176 = class140.field2172;
         class140.field2167 = class140.field2173;
         class140.field2178 = class140.field2164;
         class140.field2171 = 0;
      }
   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "100"
   )
   static final void method1898(String var0) {
      if(null != var0) {
         if((client.field561 < 200 || 1 == client.field409) && client.field561 < 400) {
            String var1 = class142.method2997(var0, class164.field2678);
            if(null != var1) {
               int var2;
               String var4;
               String var5;
               for(var2 = 0; var2 < client.field561; ++var2) {
                  class17 var3 = client.field474[var2];
                  var4 = class142.method2997(var3.field260, class164.field2678);
                  if(var4 != null && var4.equals(var1)) {
                     class103.method2289(30, "", var0 + " is already on your friend list");
                     return;
                  }

                  if(var3.field254 != null) {
                     var5 = class142.method2997(var3.field254, class164.field2678);
                     if(null != var5 && var5.equals(var1)) {
                        class103.method2289(30, "", var0 + " is already on your friend list");
                        return;
                     }
                  }
               }

               for(var2 = 0; var2 < client.field565; ++var2) {
                  class7 var6 = client.field566[var2];
                  var4 = class142.method2997(var6.field146, class164.field2678);
                  if(null != var4 && var4.equals(var1)) {
                     class103.method2289(30, "", "Please remove " + var0 + " from your ignore list first");
                     return;
                  }

                  if(null != var6.field140) {
                     var5 = class142.method2997(var6.field140, class164.field2678);
                     if(var5 != null && var5.equals(var1)) {
                        class103.method2289(30, "", "Please remove " + var0 + " from your ignore list first");
                        return;
                     }
                  }
               }

               if(class142.method2997(class167.field2692.field59, class164.field2678).equals(var1)) {
                  class103.method2289(30, "", "You can\'t add yourself to your own friend list");
               } else {
                  client.field318.method2757(43);
                  client.field318.method2573(class45.method992(var0));
                  client.field318.method2661(var0);
               }
            }
         } else {
            class103.method2289(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
         }
      }
   }
}
