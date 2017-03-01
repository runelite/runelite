import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
public class class195 extends CacheableNode {
   @ObfuscatedName("i")
   public String[] field2859;
   @ObfuscatedName("x")
   public static class182 field2860;
   @ObfuscatedName("g")
   public char field2861;
   @ObfuscatedName("v")
   public char field2862;
   @ObfuscatedName("y")
   public String field2863 = "null";
   @ObfuscatedName("a")
   public int[] field2864;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1059640519
   )
   public int field2865 = 0;
   @ObfuscatedName("m")
   public int[] field2866;
   @ObfuscatedName("n")
   static NodeCache field2867 = new NodeCache(64);
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 625582365
   )
   public int field2868;
   @ObfuscatedName("nn")
   @ObfuscatedGetter(
      intValue = 1691618245
   )
   static int field2870;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "80000356"
   )
   void method3618(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3620(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1877338222"
   )
   void method3620(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2861 = (char)var1.readUnsignedByte();
      } else if(var2 == 2) {
         this.field2862 = (char)var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field2863 = var1.readString();
      } else if(var2 == 4) {
         this.field2868 = var1.readInt();
      } else {
         int var3;
         if(var2 == 5) {
            this.field2865 = var1.readUnsignedShort();
            this.field2866 = new int[this.field2865];
            this.field2859 = new String[this.field2865];

            for(var3 = 0; var3 < this.field2865; ++var3) {
               this.field2866[var3] = var1.readInt();
               this.field2859[var3] = var1.readString();
            }
         } else if(var2 == 6) {
            this.field2865 = var1.readUnsignedShort();
            this.field2866 = new int[this.field2865];
            this.field2864 = new int[this.field2865];

            for(var3 = 0; var3 < this.field2865; ++var3) {
               this.field2866[var3] = var1.readInt();
               this.field2864[var3] = var1.readInt();
            }
         }
      }

   }
}
