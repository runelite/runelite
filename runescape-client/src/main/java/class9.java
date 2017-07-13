import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
public abstract class class9 extends Node {
   @ObfuscatedName("dr")
   @ObfuscatedGetter(
      intValue = -1746304565
   )
   @Export("myWorldPort")
   static int myWorldPort;
   @ObfuscatedName("t")
   static int[][][] field249;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   abstract void vmethod54();

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "52"
   )
   @Export("resetItemTable")
   static void resetItemTable(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.get((long)var0);
      if(var1 != null) {
         for(int var2 = 0; var2 < var1.itemIds.length; ++var2) {
            var1.itemIds[var2] = -1;
            var1.stackSizes[var2] = 0;
         }

      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)LEnum;",
      garbageValue = "-547286080"
   )
   public static Enum method45(int var0) {
      Enum var1 = (Enum)Enum.field3395.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = VarPlayerType.field3286.getConfigData(8, var0);
         var1 = new Enum();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Enum.field3395.put(var1, (long)var0);
         return var1;
      }
   }
}
