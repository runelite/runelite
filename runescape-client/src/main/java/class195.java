import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
public class class195 extends CacheableNode {
   @ObfuscatedName("g")
   static NodeCache field2848 = new NodeCache(64);
   @ObfuscatedName("x")
   public char field2850;
   @ObfuscatedName("q")
   public char field2851;
   @ObfuscatedName("a")
   public String[] field2852;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -539193675
   )
   public int field2853;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -260905551
   )
   public int field2854 = 0;
   @ObfuscatedName("s")
   public int[] field2855;
   @ObfuscatedName("o")
   public int[] field2856;
   @ObfuscatedName("p")
   public static class182 field2857;
   @ObfuscatedName("d")
   public String field2858 = "null";

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-317942081"
   )
   void method3537(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3538(var1, var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-550648705"
   )
   void method3538(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2850 = (char)var1.readUnsignedByte();
      } else if(var2 == 2) {
         this.field2851 = (char)var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field2858 = var1.method2846();
      } else if(var2 == 4) {
         this.field2853 = var1.method2819();
      } else {
         int var3;
         if(var2 == 5) {
            this.field2854 = var1.readUnsignedShort();
            this.field2855 = new int[this.field2854];
            this.field2852 = new String[this.field2854];

            for(var3 = 0; var3 < this.field2854; ++var3) {
               this.field2855[var3] = var1.method2819();
               this.field2852[var3] = var1.method2846();
            }
         } else if(var2 == 6) {
            this.field2854 = var1.readUnsignedShort();
            this.field2855 = new int[this.field2854];
            this.field2856 = new int[this.field2854];

            for(var3 = 0; var3 < this.field2854; ++var3) {
               this.field2855[var3] = var1.method2819();
               this.field2856[var3] = var1.method2819();
            }
         }
      }

   }
}
