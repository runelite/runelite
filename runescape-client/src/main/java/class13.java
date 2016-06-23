import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
public class class13 implements Runnable {
   @ObfuscatedName("cg")
   public static char field198;
   @ObfuscatedName("u")
   Object field199 = new Object();
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 197287989
   )
   int field200 = 0;
   @ObfuscatedName("b")
   int[] field201 = new int[500];
   @ObfuscatedName("l")
   int[] field202 = new int[500];
   @ObfuscatedName("ik")
   static class30 field203;
   @ObfuscatedName("f")
   boolean field204 = true;

   public void run() {
      for(; this.field204; class98.method2264(50L)) {
         Object var1 = this.field199;
         synchronized(this.field199) {
            if(this.field200 < 500) {
               this.field201[this.field200] = class140.field2146;
               this.field202[this.field200] = class140.field2151;
               ++this.field200;
            }
         }
      }

   }

   @ObfuscatedName("ds")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "13413"
   )
   static final void method168(int var0) {
      if(class135.method2897(var0)) {
         class173[] var1 = class173.field2770[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            class173 var3 = var1[var2];
            if(null != var3) {
               var3.field2876 = 0;
               var3.field2743 = 0;
            }
         }

      }
   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(III)Ljava/lang/String;",
      garbageValue = "-1909696200"
   )
   static final String method171(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?class164.method3251(16711680):(var2 < -6?class164.method3251(16723968):(var2 < -3?class164.method3251(16740352):(var2 < 0?class164.method3251(16756736):(var2 > 9?class164.method3251('\uff00'):(var2 > 6?class164.method3251(4259584):(var2 > 3?class164.method3251(8453888):(var2 > 0?class164.method3251(12648192):class164.method3251(16776960))))))));
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "114"
   )
   static void method174(int var0, int var1, int var2, int var3) {
      class173 var4 = class172.method3425(var0, var1);
      if(null != var4 && null != var4.field2845) {
         class0 var5 = new class0();
         var5.field1 = var4;
         var5.field0 = var4.field2845;
         class31.method737(var5, 200000);
      }

      client.field470 = var3;
      client.field442 = true;
      class17.field253 = var0;
      client.field443 = var1;
      class84.field1465 = var2;
      class39.method818(var4);
   }
}
