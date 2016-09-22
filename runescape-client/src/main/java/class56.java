import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
public class class56 extends CacheableNode {
   @ObfuscatedName("a")
   public static class170 field1233;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 368985955
   )
   public static int field1234;
   @ObfuscatedName("v")
   static NodeCache field1235 = new NodeCache(64);
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 2031325951
   )
   public int field1236 = 0;
   @ObfuscatedName("na")
   @ObfuscatedGetter(
      intValue = 930545741
   )
   static int field1238;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "65408"
   )
   void method1177(Buffer var1) {
      while(true) {
         int var2 = var1.method2528();
         if(var2 == 0) {
            return;
         }

         this.method1178(var1, var2);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1227446211"
   )
   void method1178(Buffer var1, int var2) {
      if(var2 == 5) {
         this.field1236 = var1.method2717();
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass125;I)I",
      garbageValue = "150580470"
   )
   static int method1185(class125 var0) {
      int var1 = var0.method2792(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.method2792(5);
      } else if(var1 == 2) {
         var2 = var0.method2792(8);
      } else {
         var2 = var0.method2792(11);
      }

      return var2;
   }
}
