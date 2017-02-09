import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
public class class195 extends CacheableNode {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -439110967
   )
   public int field2837;
   @ObfuscatedName("y")
   static NodeCache field2838 = new NodeCache(64);
   @ObfuscatedName("o")
   public char field2839;
   @ObfuscatedName("r")
   public char field2841;
   @ObfuscatedName("d")
   public int[] field2842;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -631808367
   )
   public int field2843 = 0;
   @ObfuscatedName("n")
   public int[] field2844;
   @ObfuscatedName("c")
   public String[] field2846;
   @ObfuscatedName("w")
   public String field2847 = "null";
   @ObfuscatedName("k")
   static class182 field2848;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1035126177"
   )
   void method3548(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3552(var1, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-162014590"
   )
   void method3552(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2839 = (char)var1.readUnsignedByte();
      } else if(var2 == 2) {
         this.field2841 = (char)var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field2847 = var1.method2934();
      } else if(var2 == 4) {
         this.field2837 = var1.method3062();
      } else {
         int var3;
         if(var2 == 5) {
            this.field2843 = var1.readUnsignedShort();
            this.field2842 = new int[this.field2843];
            this.field2846 = new String[this.field2843];

            for(var3 = 0; var3 < this.field2843; ++var3) {
               this.field2842[var3] = var1.method3062();
               this.field2846[var3] = var1.method2934();
            }
         } else if(var2 == 6) {
            this.field2843 = var1.readUnsignedShort();
            this.field2842 = new int[this.field2843];
            this.field2844 = new int[this.field2843];

            for(var3 = 0; var3 < this.field2843; ++var3) {
               this.field2842[var3] = var1.method3062();
               this.field2844[var3] = var1.method3062();
            }
         }
      }

   }

   @ObfuscatedName("k")
   public static final void method3560(long var0) {
      if(var0 > 0L) {
         if(var0 % 10L == 0L) {
            class3.method45(var0 - 1L);
            class3.method45(1L);
         } else {
            class3.method45(var0);
         }

      }
   }
}
