import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
public class class195 extends CacheableNode {
   @ObfuscatedName("c")
   static NodeCache field2859 = new NodeCache(64);
   @ObfuscatedName("f")
   public char field2860;
   @ObfuscatedName("h")
   public char field2861;
   @ObfuscatedName("a")
   public String field2862 = "null";
   @ObfuscatedName("s")
   public static class182 field2863;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 711765999
   )
   public int field2864;
   @ObfuscatedName("u")
   public int[] field2865;
   @ObfuscatedName("b")
   public int[] field2866;
   @ObfuscatedName("x")
   public String[] field2867;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1322764699
   )
   public int field2868 = 0;
   @ObfuscatedName("e")
   public static String field2869;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1880760874"
   )
   void method3443(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2860 = (char)var1.readUnsignedByte();
      } else if(var2 == 2) {
         this.field2861 = (char)var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field2862 = var1.method2911();
      } else if(var2 == 4) {
         this.field2864 = var1.method2727();
      } else {
         int var3;
         if(var2 == 5) {
            this.field2868 = var1.readUnsignedShort();
            this.field2865 = new int[this.field2868];
            this.field2867 = new String[this.field2868];

            for(var3 = 0; var3 < this.field2868; ++var3) {
               this.field2865[var3] = var1.method2727();
               this.field2867[var3] = var1.method2911();
            }
         } else if(var2 == 6) {
            this.field2868 = var1.readUnsignedShort();
            this.field2865 = new int[this.field2868];
            this.field2866 = new int[this.field2868];

            for(var3 = 0; var3 < this.field2868; ++var3) {
               this.field2865[var3] = var1.method2727();
               this.field2866[var3] = var1.method2727();
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-531818688"
   )
   void method3449(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3443(var1, var2);
      }
   }
}
