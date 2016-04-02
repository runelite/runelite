import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
public class class49 extends class204 {
   @ObfuscatedName("np")
   static class74 field1066;
   @ObfuscatedName("f")
   public boolean field1067 = false;
   @ObfuscatedName("w")
   public static class193 field1070 = new class193(64);
   @ObfuscatedName("qr")
   @ObfuscatedGetter(
      intValue = -746174099
   )
   static int field1071;

   @ObfuscatedName("e")
   public void method996(class119 var1) {
      while(true) {
         int var2 = var1.method2523();
         if(var2 == 0) {
            return;
         }

         this.method999(var2);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "-56019801"
   )
   void method999(int var1) {
      if(var1 == 2) {
         this.field1067 = true;
      }

   }

   @ObfuscatedName("am")
   static void method1001() {
      int var0 = class35.field762;
      int var1 = class21.field575;
      if(class38.field854 < var0) {
         var0 = class38.field854;
      }

      if(class51.field1132 < var1) {
         var1 = class51.field1132;
      }

      if(null != class39.field865) {
         try {
            class132.method2837(client.field374, "resize", new Object[]{Integer.valueOf(class89.method2098())});
         } catch (Throwable var3) {
            ;
         }
      }

   }

   @ObfuscatedName("dm")
   static final void method1002() {
      client.field321.method2762(19);
      client.field321.method2565(0);
   }
}
