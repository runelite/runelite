import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
public class class52 extends class204 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1244648431
   )
   public static int field1168;
   @ObfuscatedName("g")
   public static class193 field1169 = new class193(64);
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 165553789
   )
   public int field1171 = 0;
   @ObfuscatedName("t")
   public static class167 field1172;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "93"
   )
   void method1048(class119 var1, int var2) {
      if(var2 == 5) {
         this.field1171 = var1.method2470();
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "0"
   )
   void method1049(class119 var1) {
      while(true) {
         int var2 = var1.method2494();
         if(var2 == 0) {
            return;
         }

         this.method1048(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)Lclass35;",
      garbageValue = "-27"
   )
   static class35 method1057(int var0) {
      return (class35)class11.field180.method3761((long)var0);
   }
}
