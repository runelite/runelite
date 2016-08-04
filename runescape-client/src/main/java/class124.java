import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
public class class124 {
   @ObfuscatedName("e")
   static byte[][] field2058 = new byte[1000][];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -842518685
   )
   static int field2059 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -15330573
   )
   static int field2061 = 0;
   @ObfuscatedName("h")
   static byte[][] field2062 = new byte[250][];
   @ObfuscatedName("s")
   static byte[][] field2063 = new byte[50][];
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1099857435
   )
   static int field2065 = 0;

   @ObfuscatedName("g")
   static final void method2887(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2045349388"
   )
   static void method2891() {
      for(int var0 = 0; var0 < client.field368; ++var0) {
         if(class119.method2575(client.field438[var0])) {
            if(var0 < client.field368 - 1) {
               for(int var1 = var0; var1 < client.field368 - 1; ++var1) {
                  client.field440[var1] = client.field440[var1 + 1];
                  client.field510[var1] = client.field510[1 + var1];
                  client.field438[var1] = client.field438[var1 + 1];
                  client.field291[var1] = client.field291[var1 + 1];
                  client.field436[var1] = client.field436[1 + var1];
                  client.field437[var1] = client.field437[var1 + 1];
               }
            }

            --client.field368;
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1891703252"
   )
   public static void method2892(int var0, int var1) {
      class50 var3 = (class50)class50.field1117.method3905((long)var0);
      class50 var2;
      if(var3 != null) {
         var2 = var3;
      } else {
         byte[] var4 = class50.field1125.method3411(14, var0);
         var3 = new class50();
         if(var4 != null) {
            var3.method1075(new class122(var4));
         }

         class50.field1117.method3907(var3, (long)var0);
         var2 = var3;
      }

      int var8 = var2.field1119;
      int var5 = var2.field1120;
      int var6 = var2.field1124;
      int var7 = class179.field2959[var6 - var5];
      if(var1 < 0 || var1 > var7) {
         var1 = 0;
      }

      var7 <<= var5;
      class179.field2958[var8] = class179.field2958[var8] & ~var7 | var1 << var5 & var7;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "257273897"
   )
   static final byte[] method2893(byte[] var0) {
      class122 var1 = new class122(var0);
      int var2 = var1.method2633();
      int var3 = var1.method2620();
      if(var3 >= 0 && (class170.field2740 == 0 || var3 <= class170.field2740)) {
         if(var2 == 0) {
            byte[] var6 = new byte[var3];
            var1.method2754(var6, 0, var3);
            return var6;
         } else {
            int var4 = var1.method2620();
            if(var4 < 0 || class170.field2740 != 0 && var4 > class170.field2740) {
               throw new RuntimeException();
            } else {
               byte[] var5 = new byte[var4];
               if(var2 == 1) {
                  class120.method2577(var5, var4, var0, var3, 9);
               } else {
                  class170.field2724.method2570(var1, var5);
               }

               return var5;
            }
         }
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-286617109"
   )
   static synchronized byte[] method2894(int var0) {
      byte[] var1;
      if(var0 == 100 && field2065 > 0) {
         var1 = field2058[--field2065];
         field2058[field2065] = null;
         return var1;
      } else if(var0 == 5000 && field2059 > 0) {
         var1 = field2062[--field2059];
         field2062[field2059] = null;
         return var1;
      } else if(var0 == 30000 && field2061 > 0) {
         var1 = field2063[--field2061];
         field2063[field2061] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }
}
