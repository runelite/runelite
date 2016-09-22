import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
public class class54 extends CacheableNode {
   @ObfuscatedName("d")
   static NodeCache field1167 = new NodeCache(64);
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1693886089
   )
   public int field1168 = 0;
   @ObfuscatedName("z")
   static class170 field1173;
   @ObfuscatedName("a")
   public static class170 field1175;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "35"
   )
   void method1113(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field1168 = var1.method2717();
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1490062072"
   )
   void method1114(Buffer var1) {
      while(true) {
         int var2 = var1.method2528();
         if(var2 == 0) {
            return;
         }

         this.method1113(var1, var2);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([Lclass115;IB)Lclass115;",
      garbageValue = "64"
   )
   public static class115 method1117(class115[] var0, int var1) {
      class115[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class115 var4 = var2[var3];
         if(var1 == var4.vmethod3214()) {
            return var4;
         }
      }

      return null;
   }
}
