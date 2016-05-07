import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class45 extends class204 {
   @ObfuscatedName("p")
   public boolean field1041 = false;
   @ObfuscatedName("j")
   public static class193 field1042 = new class193(64);
   @ObfuscatedName("s")
   public static class167 field1044;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = 1257430651
   )
   static int field1046;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "-1410934550"
   )
   void method922(class119 var1, int var2) {
      if(2 == var2) {
         this.field1041 = true;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "575640080"
   )
   public void method923(class119 var1) {
      while(true) {
         int var2 = var1.method2492();
         if(var2 == 0) {
            return;
         }

         this.method922(var1, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1808035239"
   )
   public static int method925(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0:(var2 == 2?7 - var1:var0));
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(CB)C",
      garbageValue = "97"
   )
   static char method931(char var0) {
      return 181 != var0 && var0 != 402?Character.toTitleCase(var0):var0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)Lclass173;",
      garbageValue = "2099637588"
   )
   public static class173 method932(int var0, int var1) {
      class173 var2 = class29.method645(var0);
      return -1 == var1?var2:(var2 != null && var2.field2847 != null && var1 < var2.field2847.length?var2.field2847[var1]:null);
   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2045960417"
   )
   static final void method933() {
      class34.method701(client.field450);
      ++class56.field1188;
      if(client.field458 && client.field455) {
         int var0 = class140.field2162;
         int var1 = class140.field2163;
         var0 -= client.field452;
         var1 -= client.field453;
         if(var0 < client.field456) {
            var0 = client.field456;
         }

         if(var0 + client.field450.field2886 > client.field288.field2886 + client.field456) {
            var0 = client.field288.field2886 + client.field456 - client.field450.field2886;
         }

         if(var1 < client.field457) {
            var1 = client.field457;
         }

         if(var1 + client.field450.field2781 > client.field457 + client.field288.field2781) {
            var1 = client.field457 + client.field288.field2781 - client.field450.field2781;
         }

         int var2 = var0 - client.field559;
         int var3 = var1 - client.field460;
         int var4 = client.field450.field2841;
         if(class56.field1188 > client.field450.field2842 && (var2 > var4 || var2 < -var4 || var3 > var4 || var3 < -var4)) {
            client.field461 = true;
         }

         int var5 = client.field288.field2786 + (var0 - client.field456);
         int var6 = client.field288.field2787 + (var1 - client.field457);
         class0 var7;
         if(null != client.field450.field2854 && client.field461) {
            var7 = new class0();
            var7.field8 = client.field450;
            var7.field14 = var5;
            var7.field4 = var6;
            var7.field12 = client.field450.field2854;
            class16.method197(var7);
         }

         if(0 == class140.field2161) {
            if(client.field461) {
               if(null != client.field450.field2855) {
                  var7 = new class0();
                  var7.field8 = client.field450;
                  var7.field14 = var5;
                  var7.field4 = var6;
                  var7.field6 = client.field454;
                  var7.field12 = client.field450.field2855;
                  class16.method197(var7);
               }

               if(client.field454 != null && class111.method2420(client.field450) != null) {
                  client.field322.method2737(124);
                  client.field322.method2661(client.field454.field2885);
                  client.field322.method2531(client.field454.field2826);
                  client.field322.method2494(client.field450.field2826);
                  client.field322.method2525(client.field450.field2766);
                  client.field322.method2557(client.field454.field2766);
                  client.field322.method2525(client.field450.field2885);
               }
            } else if((client.field545 == 1 || class33.method692(client.field496 - 1)) && client.field496 > 2) {
               class39.method772(client.field559 + client.field452, client.field453 + client.field460);
            } else if(client.field496 > 0) {
               int var10 = client.field559 + client.field452;
               int var8 = client.field453 + client.field460;
               class30 var9 = class16.field231;
               class13.method171(var9.field713, var9.field704, var9.field705, var9.field711, var9.field703, var9.field703, var10, var8);
               class16.field231 = null;
            }

            client.field450 = null;
         }

      } else {
         if(class56.field1188 > 1) {
            client.field450 = null;
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1647940291"
   )
   public static boolean method934(int var0) {
      return (var0 >> 29 & 1) != 0;
   }
}
