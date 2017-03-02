import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1071173141
   )
   int field3235;
   @ObfuscatedName("t")
   int[] field3236;
   @ObfuscatedName("i")
   int[] field3237;
   @ObfuscatedName("h")
   int[] field3238;
   @ObfuscatedName("k")
   @Export("fields")
   Field[] fields;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -669913851
   )
   int field3240;
   @ObfuscatedName("n")
   @Export("methods")
   Method[] methods;
   @ObfuscatedName("f")
   @Export("args")
   byte[][][] args;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "274329434"
   )
   static int method4364(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method2428((long)var0);
      if(var2 == null) {
         return 0;
      } else if(var1 == -1) {
         return 0;
      } else {
         int var3 = 0;

         for(int var4 = 0; var4 < var2.stackSizes.length; ++var4) {
            if(var2.itemIds[var4] == var1) {
               var3 += var2.stackSizes[var4];
            }
         }

         return var3;
      }
   }
}
