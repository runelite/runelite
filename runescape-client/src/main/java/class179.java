import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class179 {
   static {
      new HashMap();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1279606108"
   )
   static synchronized void method3470(byte[] var0) {
      if(var0.length == 100 && class185.field2520 < 1000) {
         class185.field2522[++class185.field2520 - 1] = var0;
      } else if(var0.length == 5000 && class185.field2519 < 250) {
         class185.field2518[++class185.field2519 - 1] = var0;
      } else if(var0.length == 30000 && class185.field2521 < 50) {
         class185.field2523[++class185.field2521 - 1] = var0;
      } else {
         if(class225.field2731 != null) {
            for(int var1 = 0; var1 < FileOnDisk.field1475.length; ++var1) {
               if(var0.length == FileOnDisk.field1475[var1] && TotalQuantityComparator.field287[var1] < class225.field2731[var1].length) {
                  class225.field2731[var1][TotalQuantityComparator.field287[var1]++] = var0;
                  return;
               }
            }
         }

      }
   }

   @ObfuscatedName("ji")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1938789735"
   )
   static final void method3471() {
      for(int var0 = 0; var0 < class92.playerIndexesCount; ++var0) {
         Player var1 = Client.cachedPlayers[class92.playerIndices[var0]];
         var1.method1153();
      }

   }
}
