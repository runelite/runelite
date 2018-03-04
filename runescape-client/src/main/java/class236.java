import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ik")
public class class236 extends CacheableNode {
   @ObfuscatedName("s")
   @Export("colorsToReplace")
   public static short[][] colorsToReplace;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -799174145
   )
   public final int field2777;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 788541997
   )
   public final int field2775;
   @ObfuscatedName("n")
   public final int[] field2779;
   @ObfuscatedName("r")
   public final int[] field2778;

   class236(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2777 = var1;
      this.field2775 = var2;
      this.field2779 = var3;
      this.field2778 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "743248978"
   )
   public boolean method4474(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2778.length) {
         int var3 = this.field2778[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2779[var2]) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "(Liw;B)V",
      garbageValue = "19"
   )
   static final void method4475(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 324) {
         if(Client.field967 == -1) {
            Client.field967 = var0.spriteId;
            Client.field1113 = var0.field2861;
         }

         if(Client.field1009.isFemale) {
            var0.spriteId = Client.field967;
         } else {
            var0.spriteId = Client.field1113;
         }

      } else if(var1 == 325) {
         if(Client.field967 == -1) {
            Client.field967 = var0.spriteId;
            Client.field1113 = var0.field2861;
         }

         if(Client.field1009.isFemale) {
            var0.spriteId = Client.field1113;
         } else {
            var0.spriteId = Client.field967;
         }

      } else if(var1 == 327) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 0;
      } else if(var1 == 328) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 1;
      }
   }

   @ObfuscatedName("jq")
   @ObfuscatedSignature(
      signature = "(Liw;I)Z",
      garbageValue = "-2067712584"
   )
   static boolean method4476(Widget var0) {
      return var0.isHidden;
   }
}
