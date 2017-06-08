import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
public class class11 {
   @ObfuscatedName("p")
   public static final class11 field266;
   @ObfuscatedName("n")
   public static final class11 field268;
   @ObfuscatedName("rc")
   static short[] field269;

   static {
      field268 = new class11();
      field266 = new class11();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-187504934"
   )
   static int method72(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method3545((long)var0);
      if(var2 == null) {
         return 0;
      } else if(var1 == -1) {
         return 0;
      } else {
         int var3 = 0;

         for(int var4 = 0; var4 < var2.stackSizes.length; ++var4) {
            if(var1 == var2.itemIds[var4]) {
               var3 += var2.stackSizes[var4];
            }
         }

         return var3;
      }
   }

   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1901518293"
   )
   static void method73(int var0, int var1) {
      if(Client.field1030 != 0 && var0 != -1) {
         class182.method3430(IndexData.indexTrack2, var0, 0, Client.field1030, false);
         Client.field1154 = true;
      }

   }
}
