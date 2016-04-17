import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
public abstract class class133 {
   @ObfuscatedName("qk")
   @ObfuscatedGetter(
      intValue = 488337249
   )
   protected static int field2071;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "70"
   )
   public abstract void vmethod3216();

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1224087509"
   )
   abstract int vmethod3217(int var1, int var2);

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Lclass40;",
      garbageValue = "-1494482049"
   )
   public static class40 method2969(int var0) {
      class40 var1 = (class40)class40.field958.method3840((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class226.field3214.method3403(6, var0);
         var1 = new class40();
         var1.field930 = var0;
         if(var2 != null) {
            var1.method891(new class119(var2));
         }

         var1.method890();
         if(var1.field937) {
            var1.field940 = 0;
            var1.field941 = false;
         }

         class40.field958.method3842(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Z",
      garbageValue = "23"
   )
   public static boolean method2973(CharSequence var0) {
      return class160.method3282(var0, 10, true);
   }

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "148093362"
   )
   static final void method2974() {
      class23.method657(client.field465);
      ++class11.field184;
      if(client.field473 && client.field498) {
         int var0 = class140.field2151;
         int var1 = class140.field2161;
         var0 -= client.field464;
         var1 -= client.field485;
         if(var0 < client.field450) {
            var0 = client.field450;
         }

         if(client.field465.field2773 + var0 > client.field450 + client.field409.field2773) {
            var0 = client.field409.field2773 + client.field450 - client.field465.field2773;
         }

         if(var1 < client.field472) {
            var1 = client.field472;
         }

         if(var1 + client.field465.field2774 > client.field409.field2774 + client.field472) {
            var1 = client.field472 + client.field409.field2774 - client.field465.field2774;
         }

         int var2 = var0 - client.field474;
         int var3 = var1 - client.field475;
         int var4 = client.field465.field2756;
         if(class11.field184 > client.field465.field2835 && (var2 > var4 || var2 < -var4 || var3 > var4 || var3 < -var4)) {
            client.field476 = true;
         }

         int var5 = client.field409.field2879 + (var0 - client.field450);
         int var6 = var1 - client.field472 + client.field409.field2780;
         class0 var7;
         if(null != client.field465.field2847 && client.field476) {
            var7 = new class0();
            var7.field2 = client.field465;
            var7.field3 = var5;
            var7.field16 = var6;
            var7.field4 = client.field465.field2847;
            class168.method3449(var7, 200000);
         }

         if(class140.field2147 == 0) {
            if(client.field476) {
               if(client.field465.field2837 != null) {
                  var7 = new class0();
                  var7.field2 = client.field465;
                  var7.field3 = var5;
                  var7.field16 = var6;
                  var7.field6 = client.field469;
                  var7.field4 = client.field465.field2837;
                  class168.method3449(var7, 200000);
               }

               if(client.field469 != null && class4.method52(client.field465) != null) {
                  client.field338.method2873(53);
                  client.field338.method2645(client.field465.field2878);
                  client.field338.method2599(client.field469.field2759);
                  client.field338.method2653(client.field469.field2842);
                  client.field338.method2653(client.field465.field2842);
                  client.field338.method2745(client.field469.field2878);
                  client.field338.method2645(client.field465.field2759);
               }
            } else if((client.field432 == 1 || class17.method220(client.field434 - 1)) && client.field434 > 2) {
               class10.method171(client.field474 + client.field464, client.field485 + client.field475);
            } else if(client.field434 > 0) {
               class5.method113(client.field474 + client.field464, client.field485 + client.field475);
            }

            client.field465 = null;
         }

      } else {
         if(class11.field184 > 1) {
            client.field465 = null;
         }

      }
   }
}
