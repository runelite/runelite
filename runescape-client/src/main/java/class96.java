import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
public class class96 {
   @ObfuscatedName("d")
   @Export("chatLineMap")
   static final Map chatLineMap;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   static final IterableHashTable field1434;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhu;"
   )
   static final class208 field1435;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1040414245
   )
   static int field1436;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      longValue = 5388742201834668159L
   )
   static long field1437;

   static {
      chatLineMap = new HashMap();
      field1434 = new IterableHashTable(1024);
      field1435 = new class208();
      field1436 = 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1610575910"
   )
   static int method1898(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
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
