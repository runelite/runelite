import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
public class class195 extends CacheableNode {
   @ObfuscatedName("f")
   public char field2853;
   @ObfuscatedName("e")
   static NodeCache field2854 = new NodeCache(64);
   @ObfuscatedName("w")
   public int[] field2855;
   @ObfuscatedName("g")
   public String field2857 = "null";
   @ObfuscatedName("v")
   public String[] field2858;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1903749287
   )
   public int field2859 = 0;
   @ObfuscatedName("q")
   public int[] field2860;
   @ObfuscatedName("i")
   public static class182 field2861;
   @ObfuscatedName("k")
   public char field2862;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -290621805
   )
   public int field2863;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-54"
   )
   void method3499(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2853 = (char)var1.readUnsignedByte();
      } else if(var2 == 2) {
         this.field2862 = (char)var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field2857 = var1.method2767();
      } else if(var2 == 4) {
         this.field2863 = var1.method2844();
      } else {
         int var3;
         if(var2 == 5) {
            this.field2859 = var1.readUnsignedShort();
            this.field2860 = new int[this.field2859];
            this.field2858 = new String[this.field2859];

            for(var3 = 0; var3 < this.field2859; ++var3) {
               this.field2860[var3] = var1.method2844();
               this.field2858[var3] = var1.method2767();
            }
         } else if(var2 == 6) {
            this.field2859 = var1.readUnsignedShort();
            this.field2860 = new int[this.field2859];
            this.field2855 = new int[this.field2859];

            for(var3 = 0; var3 < this.field2859; ++var3) {
               this.field2860[var3] = var1.method2844();
               this.field2855[var3] = var1.method2844();
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-46"
   )
   void method3508(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3499(var1, var2);
      }
   }
}
