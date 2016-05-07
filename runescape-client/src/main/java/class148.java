import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
public class class148 extends RuntimeException {
   @ObfuscatedName("r")
   static int[] field2232;
   @ObfuscatedName("j")
   public static String field2233;
   @ObfuscatedName("x")
   String field2234;
   @ObfuscatedName("d")
   Throwable field2235;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1814961131
   )
   static int field2236;

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(Lclass16;I)V",
      garbageValue = "-1360719882"
   )
   static final void method3114(class16 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(0 == var0.field220) {
         var1 = client.field339.method1964(var0.field227, var0.field221, var0.field232);
      }

      if(var0.field220 == 1) {
         var1 = client.field339.method1922(var0.field227, var0.field221, var0.field232);
      }

      if(var0.field220 == 2) {
         var1 = client.field339.method1944(var0.field227, var0.field221, var0.field232);
      }

      if(3 == var0.field220) {
         var1 = client.field339.method1924(var0.field227, var0.field221, var0.field232);
      }

      if(0 != var1) {
         int var5 = client.field339.method1925(var0.field227, var0.field221, var0.field232, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field229 = var2;
      var0.field225 = var3;
      var0.field222 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "0"
   )
   public static Object method3115(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !class125.field2051) {
            try {
               class118 var2 = new class118();
               var2.vmethod2785(var0);
               return var2;
            } catch (Throwable var3) {
               class125.field2051 = true;
            }
         }

         return var0;
      }
   }
}
