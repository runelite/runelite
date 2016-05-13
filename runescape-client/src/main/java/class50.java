import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class50 extends class204 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -171677587
   )
   public int field1101 = 0;
   @ObfuscatedName("s")
   public static class167 field1102;
   @ObfuscatedName("j")
   public static class193 field1103 = new class193(64);
   @ObfuscatedName("bq")
   static class80 field1104;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "-1386896088"
   )
   public void method984(class119 var1) {
      while(true) {
         int var2 = var1.method2492();
         if(0 == var2) {
            return;
         }

         this.method986(var1, var2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-19406"
   )
   public static void method985() {
      Object var0 = class170.field2723;
      Object var1 = class170.field2723;
      synchronized(class170.field2723) {
         if(class170.field2721 != 0) {
            class170.field2721 = 1;

            try {
               class170.field2723.wait();
            } catch (InterruptedException var4) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "-1240060359"
   )
   void method986(class119 var1, int var2) {
      if(var2 == 2) {
         this.field1101 = var1.method2584();
      }

   }
}
