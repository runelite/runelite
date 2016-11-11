import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
public class class52 extends CacheableNode {
   @ObfuscatedName("h")
   public static NodeCache field1129 = new NodeCache(64);
   @ObfuscatedName("n")
   public String field1130 = "null";
   @ObfuscatedName("l")
   public int[] field1131;
   @ObfuscatedName("g")
   public char field1132;
   @ObfuscatedName("j")
   public String[] field1133;
   @ObfuscatedName("e")
   public char field1134;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1573767941
   )
   public int field1135 = 0;
   @ObfuscatedName("i")
   public static class170 field1136;
   @ObfuscatedName("m")
   public int[] field1137;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -539165499
   )
   public int field1138;
   @ObfuscatedName("k")
   static int[] field1139;
   @ObfuscatedName("s")
   public static class183 field1143;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "143759136"
   )
   void method1075(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1134 = (char)var1.method2544();
      } else if(var2 == 2) {
         this.field1132 = (char)var1.method2544();
      } else if(var2 == 3) {
         this.field1130 = var1.method2552();
      } else if(var2 == 4) {
         this.field1138 = var1.method2549();
      } else {
         int var3;
         if(var2 == 5) {
            this.field1135 = var1.method2546();
            this.field1131 = new int[this.field1135];
            this.field1133 = new String[this.field1135];

            for(var3 = 0; var3 < this.field1135; ++var3) {
               this.field1131[var3] = var1.method2549();
               this.field1133[var3] = var1.method2552();
            }
         } else if(var2 == 6) {
            this.field1135 = var1.method2546();
            this.field1131 = new int[this.field1135];
            this.field1137 = new int[this.field1135];

            for(var3 = 0; var3 < this.field1135; ++var3) {
               this.field1131[var3] = var1.method2549();
               this.field1137[var3] = var1.method2549();
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "2084048048"
   )
   public void method1076(Buffer var1) {
      while(true) {
         int var2 = var1.method2544();
         if(var2 == 0) {
            return;
         }

         this.method1075(var1, var2);
      }
   }
}
