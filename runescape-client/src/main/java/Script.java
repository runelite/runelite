import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -134267041
   )
   @Export("stringStackCount")
   int stringStackCount;
   @ObfuscatedName("h")
   @Export("instructions")
   int[] instructions;
   @ObfuscatedName("l")
   @Export("switches")
   class186[] switches;
   @ObfuscatedName("u")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1495871293
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 529110931
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("q")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 870395249
   )
   @Export("intStackCount")
   int intStackCount;
   @ObfuscatedName("i")
   static NodeCache field1534;

   static {
      field1534 = new NodeCache(128);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)Lclass252;",
      garbageValue = "1544598068"
   )
   public static class252 method1877(int var0) {
      class252 var1 = (class252)class252.field3388.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class252.field3391.getConfigData(34, var0);
         var1 = new class252();
         if(var2 != null) {
            var1.method4507(new Buffer(var2));
         }

         var1.method4517();
         class252.field3388.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)[Lclass186;",
      garbageValue = "-31"
   )
   class186[] method1880(int var1) {
      return new class186[var1];
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;I)V",
      garbageValue = "-405346606"
   )
   public static void method1886(IndexDataBase var0) {
      FloorUnderlayDefinition.field3334 = var0;
   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1219772742"
   )
   static void method1887(int var0, int var1) {
      Client.secretPacketBuffer1.putOpcode(179);
      Client.secretPacketBuffer1.method3243(var0);
      Client.secretPacketBuffer1.method3234(var1);
   }
}
