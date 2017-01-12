import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
public class class195 extends CacheableNode {
   @ObfuscatedName("g")
   public int[] field2839;
   @ObfuscatedName("x")
   static NodeCache field2840 = new NodeCache(64);
   @ObfuscatedName("z")
   public String[] field2841;
   @ObfuscatedName("a")
   public char field2842;
   @ObfuscatedName("f")
   public String field2843 = "null";
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1809953873
   )
   public int field2844;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -529877683
   )
   public int field2845 = 0;
   @ObfuscatedName("l")
   public int[] field2846;
   @ObfuscatedName("u")
   public static class182 field2847;
   @ObfuscatedName("i")
   public char field2848;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1001598617"
   )
   void method3546(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3550(var1, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "0"
   )
   void method3550(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2848 = (char)var1.readUnsignedByte();
      } else if(var2 == 2) {
         this.field2842 = (char)var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field2843 = var1.method2965();
      } else if(var2 == 4) {
         this.field2844 = var1.method2780();
      } else {
         int var3;
         if(var2 == 5) {
            this.field2845 = var1.readUnsignedShort();
            this.field2846 = new int[this.field2845];
            this.field2841 = new String[this.field2845];

            for(var3 = 0; var3 < this.field2845; ++var3) {
               this.field2846[var3] = var1.method2780();
               this.field2841[var3] = var1.method2965();
            }
         } else if(var2 == 6) {
            this.field2845 = var1.readUnsignedShort();
            this.field2846 = new int[this.field2845];
            this.field2839 = new int[this.field2845];

            for(var3 = 0; var3 < this.field2845; ++var3) {
               this.field2846[var3] = var1.method2780();
               this.field2839[var3] = var1.method2780();
            }
         }
      }

   }
}
