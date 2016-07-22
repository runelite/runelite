import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public class class47 extends class207 {
   @ObfuscatedName("aj")
   static int[] field1064;
   @ObfuscatedName("w")
   public static class196 field1065 = new class196(64);
   @ObfuscatedName("e")
   public boolean field1066 = false;
   @ObfuscatedName("ac")
   static class149 field1067;
   @ObfuscatedName("m")
   public static class170 field1068;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass122;B)V",
      garbageValue = "42"
   )
   public void method988(class122 var1) {
      while(true) {
         int var2 = var1.method2556();
         if(var2 == 0) {
            return;
         }

         this.method989(var1, var2);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass122;IS)V",
      garbageValue = "-997"
   )
   void method989(class122 var1, int var2) {
      if(var2 == 2) {
         this.field1066 = true;
      }

   }
}
