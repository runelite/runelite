import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
public class class186 extends CacheableNode {
   @ObfuscatedName("x")
   public static class182 field2770;
   @ObfuscatedName("n")
   public static NodeCache field2772 = new NodeCache(64);
   @ObfuscatedName("gs")
   static Widget field2773;
   @ObfuscatedName("p")
   public static int[] field2775;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -390903051
   )
   public int field2776 = 0;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1908465901"
   )
   public void method3493(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3499(var1, var2);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-32"
   )
   static void method3494(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(var0 != World.field678[var5]) {
            var2[var4] = World.field678[var5];
            var3[var4] = World.field684[var5];
            ++var4;
         }
      }

      World.field678 = var2;
      World.field684 = var3;
      class7.method100(CombatInfoListHolder.worldList, 0, CombatInfoListHolder.worldList.length - 1, World.field678, World.field684);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1122616751"
   )
   void method3499(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2776 = var1.readUnsignedShort();
      }

   }
}
