import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public class class47 extends class207 {
   @ObfuscatedName("c")
   public boolean field1072 = false;
   @ObfuscatedName("l")
   public static class196 field1073 = new class196(64);
   @ObfuscatedName("e")
   public static class170 field1075;
   @ObfuscatedName("qb")
   @ObfuscatedGetter(
      intValue = -117318877
   )
   protected static int field1076;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass122;IB)V",
      garbageValue = "12"
   )
   void method1016(class122 var1, int var2) {
      if(var2 == 2) {
         this.field1072 = true;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass122;B)V",
      garbageValue = "-68"
   )
   public void method1017(class122 var1) {
      while(true) {
         int var2 = var1.method2610();
         if(var2 == 0) {
            return;
         }

         this.method1016(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)Lclass134;",
      garbageValue = "-42"
   )
   public static class134 method1022() {
      try {
         return new class148();
      } catch (Throwable var1) {
         return null;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BI)Lclass227;",
      garbageValue = "-276487788"
   )
   static class227 method1023(byte[] var0) {
      if(null == var0) {
         return null;
      } else {
         class227 var1 = new class227(var0, class79.field1449, class11.field192, class138.field2134, class169.field2703, class178.field2941, class93.field1626);
         class52.method1134();
         return var1;
      }
   }

   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "(Lclass176;B)Z",
      garbageValue = "103"
   )
   static final boolean method1024(class176 var0) {
      int var1 = var0.field2916;
      if(var1 == 205) {
         client.field478 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            client.field568.method3570(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            client.field568.method3571(var2, var3 == 1);
         }

         if(var1 == 324) {
            client.field568.method3572(false);
         }

         if(var1 == 325) {
            client.field568.method3572(true);
         }

         if(var1 == 326) {
            client.field336.method2854(199);
            client.field568.method3573(client.field336);
            return true;
         } else {
            return false;
         }
      }
   }
}
