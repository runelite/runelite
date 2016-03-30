import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class45 extends class204 {
   @ObfuscatedName("x")
   public static class193 field1050 = new class193(64);
   @ObfuscatedName("t")
   public boolean field1051 = false;
   @ObfuscatedName("w")
   public static class167 field1056;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "2132272080"
   )
   public void method981(class119 var1) {
      while(true) {
         int var2 = var1.method2506();
         if(var2 == 0) {
            return;
         }

         this.method986(var2);
      }
   }

   @ObfuscatedName("t")
   void method986(int var1) {
      if(2 == var1) {
         this.field1051 = true;
      }

   }

   @ObfuscatedName("di")
   static boolean method991(String var0) {
      if(null == var0) {
         return false;
      } else {
         String var1 = class142.method2997(var0, class164.field2678);

         for(int var2 = 0; var2 < client.field565; ++var2) {
            class7 var3 = client.field566[var2];
            if(var1.equalsIgnoreCase(class142.method2997(var3.field146, class164.field2678))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class142.method2997(var3.field140, class164.field2678))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("v")
   public static int method992(String var0) {
      return var0.length() + 1;
   }
}
