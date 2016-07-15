import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
public class class53 extends class207 {
   @ObfuscatedName("c")
   public boolean field1158 = false;
   @ObfuscatedName("e")
   static class170 field1159;
   @ObfuscatedName("l")
   static class196 field1160 = new class196(64);
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = 1455291803
   )
   public static int field1162;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass122;B)V",
      garbageValue = "8"
   )
   void method1135(class122 var1) {
      while(true) {
         int var2 = var1.method2610();
         if(var2 == 0) {
            return;
         }

         this.method1136(var1, var2);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass122;IS)V",
      garbageValue = "1536"
   )
   void method1136(class122 var1, int var2) {
      if(var2 == 2) {
         this.field1158 = true;
      }

   }
}
