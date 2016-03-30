import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("an")
public class class49 extends class204 {
   @ObfuscatedName("x")
   static class193 field1101 = new class193(64);
   @ObfuscatedName("t")
   public boolean field1102 = false;
   @ObfuscatedName("w")
   public static class167 field1104;
   @ObfuscatedName("p")
   static class167 field1105;

   @ObfuscatedName("t")
   void method1037(int var1) {
      if(var1 == 2) {
         this.field1102 = true;
      }

   }

   @ObfuscatedName("x")
   void method1040(class119 var1) {
      while(true) {
         int var2 = var1.method2506();
         if(var2 == 0) {
            return;
         }

         this.method1037(var2);
      }
   }

   @ObfuscatedName("t")
   static int method1044(char var0) {
      int var1 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var1 = (var0 << 4) + 1;
      }

      return var1;
   }
}
