import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
@Implements("XItemContainer")
public class XItemContainer extends Node {
   @ObfuscatedName("e")
   @Export("itemIds")
   int[] itemIds = new int[]{-1};
   @ObfuscatedName("i")
   @Export("itemContainers")
   static XHashTable itemContainers = new XHashTable(32);
   @ObfuscatedName("f")
   @Export("stackSizes")
   int[] stackSizes = new int[]{0};
   @ObfuscatedName("en")
   static ModIcon[] field128;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([Lclass158;II)Lclass158;",
      garbageValue = "-294659763"
   )
   public static class158 method161(class158[] var0, int var1) {
      class158[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class158 var4 = var2[var3];
         if(var1 == var4.vmethod3974()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "373291856"
   )
   public static Object method162(byte[] var0, boolean var1) {
      if(null == var0) {
         return null;
      } else {
         if(var0.length > 136 && !class156.field2117) {
            try {
               class151 var2 = new class151();
               var2.vmethod2953(var0);
               return var2;
            } catch (Throwable var3) {
               class156.field2117 = true;
            }
         }

         return var0;
      }
   }
}
