package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ap")
public class class45 extends class203 {
   @ObfuscatedName("s")
   static String[] field1038;
   @ObfuscatedName("a")
   public boolean field1040 = false;
   @ObfuscatedName("j")
   static class166 field1043;
   @ObfuscatedName("qk")
   @ObfuscatedGetter(
      intValue = -290014647
   )
   protected static int field1044;
   @ObfuscatedName("l")
   static class192 field1049 = new class192(64);

   @ObfuscatedName("a")
   void method943(class118 var1) {
      while(true) {
         int var2 = var1.method2453();
         if(0 == var2) {
            return;
         }

         this.method944(var2);
      }
   }

   @ObfuscatedName("i")
   void method944(int var1) {
      if(2 == var1) {
         this.field1040 = true;
      }

   }

   @ObfuscatedName("i")
   public static void method951() {
      class182.field2954.method3637();
      class182.field2957 = 1;
      class182.field2955 = null;
   }
}
