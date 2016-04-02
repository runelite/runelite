import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cq")
public class class82 implements class112 {
   @ObfuscatedName("w")
   static final class82 field1399 = new class82(1, 1);
   @ObfuscatedName("f")
   static final class82 field1400 = new class82(2, 2);
   @ObfuscatedName("p")
   static final class82 field1402 = new class82(4, 4);
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -328535707
   )
   public final int field1403;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1542000395
   )
   final int field1404;
   @ObfuscatedName("ax")
   static class143 field1405;
   @ObfuscatedName("bn")
   static class168 field1406;
   @ObfuscatedName("e")
   public static final class82 field1411 = new class82(0, 0);
   @ObfuscatedName("s")
   static final class82 field1412 = new class82(3, 3);

   @ObfuscatedName("w")
   public int vmethod3172() {
      return this.field1404;
   }

   @ObfuscatedName("e")
   public static void method1901(Component var0) {
      var0.removeKeyListener(class137.field2104);
      var0.removeFocusListener(class137.field2104);
      class137.field2111 = -1;
   }

   class82(int var1, int var2) {
      this.field1403 = var1;
      this.field1404 = var2;
   }

   @ObfuscatedName("bk")
   static final void method1905(int var0, int var1) {
      int var2 = class124.field2022.method4074("Choose Option");

      int var3;
      int var4;
      for(var3 = 0; var3 < client.field420; ++var3) {
         var4 = class124.field2022.method4074(class84.method1917(var3));
         if(var4 > var2) {
            var2 = var4;
         }
      }

      var2 += 8;
      var3 = 22 + client.field420 * 15;
      var4 = var0 - var2 / 2;
      if(var4 + var2 > class35.field762) {
         var4 = class35.field762 - var2;
      }

      if(var4 < 0) {
         var4 = 0;
      }

      int var5 = var1;
      if(var1 + var3 > class21.field575) {
         var5 = class21.field575 - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      client.field331 = true;
      class126.field2034 = var4;
      class107.field1857 = var5;
      class161.field2642 = var2;
      client.field320 = client.field420 * 15 + 22;
   }

   @ObfuscatedName("e")
   public static class43 method1906(int var0) {
      class43 var1 = (class43)class43.field984.method3754((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class216.field3159.method3280(13, var0);
         var1 = new class43();
         var1.field989 = var0;
         if(var2 != null) {
            var1.method900(new class119(var2));
         }

         class43.field984.method3756(var1, (long)var0);
         return var1;
      }
   }
}
