package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ah")
public class class50 extends class203 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1039934249
   )
   public int field1100 = 0;
   @ObfuscatedName("nl")
   @ObfuscatedGetter(
      intValue = 2020684323
   )
   static int field1102;
   @ObfuscatedName("n")
   static int[][] field1103;
   @ObfuscatedName("rg")
   protected static boolean field1106;
   @ObfuscatedName("j")
   public static class166 field1107;
   @ObfuscatedName("l")
   public static class192 field1108 = new class192(64);

   @ObfuscatedName("a")
   void method1009(class118 var1, int var2) {
      if(var2 == 2) {
         this.field1100 = var1.method2455();
      }

   }

   @ObfuscatedName("l")
   public void method1010(class118 var1) {
      while(true) {
         int var2 = var1.method2453();
         if(0 == var2) {
            return;
         }

         this.method1009(var1, var2);
      }
   }

   @ObfuscatedName("k")
   static final int method1015(int var0, int var1) {
      int var2 = class39.method797(var0 - 1, var1 - 1) + class39.method797(1 + var0, var1 - 1) + class39.method797(var0 - 1, 1 + var1) + class39.method797(1 + var0, var1 + 1);
      int var3 = class39.method797(var0 - 1, var1) + class39.method797(var0 + 1, var1) + class39.method797(var0, var1 - 1) + class39.method797(var0, 1 + var1);
      int var4 = class39.method797(var0, var1);
      return var3 / 8 + var2 / 16 + var4 / 4;
   }
}
