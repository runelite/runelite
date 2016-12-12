import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      longValue = 5307918134879951137L
   )
   static long field201;
   @ObfuscatedName("ks")
   @Export("chatMessages")
   static ChatMessages chatMessages;
   @ObfuscatedName("e")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("i")
   @Export("name")
   String name;

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1921422778"
   )
   static final String method187(int var0) {
      return var0 < 999999999?Integer.toString(var0):"*";
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "647545620"
   )
   static final void method188(int var0, int var1, int var2, int var3) {
      if(Client.field398 == 1) {
         class15.field162[Client.field397 / 100].method4032(Client.field395 - 8, Client.field396 - 8);
      }

      if(Client.field398 == 2) {
         class15.field162[Client.field397 / 100 + 4].method4032(Client.field395 - 8, Client.field396 - 8);
      }

      class149.method2736();
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)V",
      garbageValue = "-59"
   )
   static void method189(int var0, String var1) {
      int var2 = class45.field908;
      int[] var3 = class45.field903;
      boolean var4 = false;

      for(int var5 = 0; var5 < var2; ++var5) {
         Player var6 = Client.cachedPlayers[var3[var5]];
         if(null != var6 && var6 != class39.localPlayer && null != var6.name && var6.name.equalsIgnoreCase(var1)) {
            if(var0 == 1) {
               Client.field294.method2976(197);
               Client.field294.method2785(0);
               Client.field294.method2792(var3[var5]);
            } else if(var0 == 4) {
               Client.field294.method2976(57);
               Client.field294.method2784(0);
               Client.field294.method2746(var3[var5]);
            } else if(var0 == 6) {
               Client.field294.method2976(181);
               Client.field294.method2793(var3[var5]);
               Client.field294.method2785(0);
            } else if(var0 == 7) {
               Client.field294.method2976(203);
               Client.field294.method2793(var3[var5]);
               Client.field294.method2785(0);
            }

            var4 = true;
            break;
         }
      }

      if(!var4) {
         ObjectComposition.method3581(4, "", "Unable to find " + var1);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;IZS)V",
      garbageValue = "-3035"
   )
   public static void method190(class182 var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.method3225(var1);
      int var6 = var0.method3226(var5, var2);
      class116.method2199(var0, var5, var6, var3, var4);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass18;I)V",
      garbageValue = "-1084636590"
   )
   static void method191(class18 var0) {
      class6.method83(var0, 200000);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Lclass109;",
      garbageValue = "232819363"
   )
   static class109 method192() {
      try {
         return new class98();
      } catch (Throwable var1) {
         return new class99();
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)Lclass190;",
      garbageValue = "1"
   )
   public static class190 method193(int var0) {
      class190 var1 = (class190)class190.field2793.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class190.field2806.method3211(13, var0);
         var1 = new class190();
         var1.field2795 = var0;
         if(null != var2) {
            var1.method3401(new Buffer(var2));
         }

         class190.field2793.put(var1, (long)var0);
         return var1;
      }
   }
}
