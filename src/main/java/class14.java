import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
public class class14 {
   @ObfuscatedName("a")
   class22 field216;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -748457913
   )
   int field217 = -1;
   @ObfuscatedName("d")
   int[] field218;
   @ObfuscatedName("ba")
   static class168 field219;
   @ObfuscatedName("u")
   static String field220;
   @ObfuscatedName("m")
   static class80 field221;
   @ObfuscatedName("c")
   String[] field224;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = 1776730539
   )
   static int field227;

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1739487664"
   )
   static final void method200(String var0) {
      if(null != var0) {
         if((client.field561 < 200 || client.field417 == 1) && client.field561 < 400) {
            String var1 = class23.method672(var0, client.field551);
            if(var1 != null) {
               int var2;
               String var4;
               String var5;
               for(var2 = 0; var2 < client.field561; ++var2) {
                  class17 var3 = client.field563[var2];
                  var4 = class23.method672(var3.field261, client.field551);
                  if(null != var4 && var4.equals(var1)) {
                     class129.method2943(30, "", var0 + " is already on your friend list");
                     return;
                  }

                  if(var3.field262 != null) {
                     var5 = class23.method672(var3.field262, client.field551);
                     if(var5 != null && var5.equals(var1)) {
                        class129.method2943(30, "", var0 + " is already on your friend list");
                        return;
                     }
                  }
               }

               for(var2 = 0; var2 < client.field397; ++var2) {
                  class7 var6 = client.field395[var2];
                  var4 = class23.method672(var6.field140, client.field551);
                  if(var4 != null && var4.equals(var1)) {
                     class129.method2943(30, "", "Please remove " + var0 + " from your ignore list first");
                     return;
                  }

                  if(null != var6.field137) {
                     var5 = class23.method672(var6.field137, client.field551);
                     if(var5 != null && var5.equals(var1)) {
                        class129.method2943(30, "", "Please remove " + var0 + " from your ignore list first");
                        return;
                     }
                  }
               }

               if(class23.method672(class5.field93.field58, client.field551).equals(var1)) {
                  class129.method2943(30, "", "You can\'t add yourself to your own friend list");
               } else {
                  client.field338.method2873(41);
                  client.field338.method2603(class104.method2383(var0));
                  client.field338.method2694(var0);
               }
            }
         } else {
            class129.method2943(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "7182"
   )
   public static void method201() {
      class52.field1170.method3843();
   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "([Lclass173;Lclass173;ZI)V",
      garbageValue = "-944171535"
   )
   static void method202(class173[] var0, class173 var1, boolean var2) {
      int var3 = 0 != var1.field2853?var1.field2853:var1.field2773;
      int var4 = var1.field2765 != 0?var1.field2765:var1.field2774;
      class35.method825(var0, var1.field2842, var3, var4, var2);
      if(null != var1.field2867) {
         class35.method825(var1.field2867, var1.field2842, var3, var4, var2);
      }

      class3 var5 = (class3)client.field453.method3868((long)var1.field2842);
      if(var5 != null) {
         class0.method6(var5.field70, var3, var4, var2);
      }

      if(var1.field2762 == 1337) {
         ;
      }

   }
}
