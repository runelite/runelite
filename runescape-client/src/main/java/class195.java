import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gv")
public class class195 extends CacheableNode {
   @ObfuscatedName("w")
   public String field2854 = "null";
   @ObfuscatedName("d")
   static NodeCache field2855 = new NodeCache(64);
   @ObfuscatedName("m")
   public char field2856;
   @ObfuscatedName("h")
   public char field2858;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1775940061
   )
   public int field2859;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 569569959
   )
   public int field2860 = 0;
   @ObfuscatedName("p")
   public int[] field2861;
   @ObfuscatedName("g")
   public int[] field2862;
   @ObfuscatedName("z")
   public String[] field2863;
   @ObfuscatedName("n")
   static class182 field2864;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-321553595"
   )
   void method3603(Buffer var1) {
      while(true) {
         int var2 = var1.method3033();
         if(var2 == 0) {
            return;
         }

         this.method3605(var1, var2);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "917821720"
   )
   void method3605(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2856 = (char)var1.method3033();
      } else if(var2 == 2) {
         this.field2858 = (char)var1.method3033();
      } else if(var2 == 3) {
         this.field2854 = var1.method3057();
      } else if(var2 == 4) {
         this.field2859 = var1.method2995();
      } else {
         int var3;
         if(var2 == 5) {
            this.field2860 = var1.method3097();
            this.field2861 = new int[this.field2860];
            this.field2863 = new String[this.field2860];

            for(var3 = 0; var3 < this.field2860; ++var3) {
               this.field2861[var3] = var1.method2995();
               this.field2863[var3] = var1.method3057();
            }
         } else if(var2 == 6) {
            this.field2860 = var1.method3097();
            this.field2861 = new int[this.field2860];
            this.field2862 = new int[this.field2860];

            for(var3 = 0; var3 < this.field2860; ++var3) {
               this.field2861[var3] = var1.method2995();
               this.field2862[var3] = var1.method2995();
            }
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "14528"
   )
   public static int method3615(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return 1 + var0;
   }
}
