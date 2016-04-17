import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public class class45 extends class204 {
   @ObfuscatedName("c")
   static byte[][][] field1053;
   @ObfuscatedName("w")
   static class193 field1054 = new class193(64);
   @ObfuscatedName("d")
   public boolean field1055 = false;
   @ObfuscatedName("a")
   public static class167 field1056;
   @ObfuscatedName("aa")
   static class168 field1057;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "331152360"
   )
   void method1045(class119 var1, int var2) {
      if(2 == var2) {
         this.field1055 = true;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass119;S)V",
      garbageValue = "-9573"
   )
   void method1046(class119 var1) {
      while(true) {
         int var2 = var1.method2613();
         if(var2 == 0) {
            return;
         }

         this.method1045(var1, var2);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)[Lclass82;",
      garbageValue = "620440664"
   )
   public static class82[] method1050() {
      return new class82[]{class82.field1438, class82.field1429, class82.field1435, class82.field1428, class82.field1430};
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;I)V",
      garbageValue = "-152405468"
   )
   public static void method1051(class167 var0, class167 var1) {
      class178.field2918 = var0;
      class43.field1024 = var1;
   }
}
