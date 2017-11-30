import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
public class class23 {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([I[II)V",
      garbageValue = "-1436395149"
   )
   public static void method172(int[] var0, int[] var1) {
      if(var0 != null && var1 != null) {
         CombatInfo1.field1189 = var0;
         class185.field2518 = new int[var0.length];
         class21.field324 = new byte[var0.length][][];

         for(int var2 = 0; var2 < CombatInfo1.field1189.length; ++var2) {
            class21.field324[var2] = new byte[var1[var2]][];
         }

      } else {
         CombatInfo1.field1189 = null;
         class185.field2518 = null;
         class21.field324 = null;
      }
   }
}
