import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
public class class195 extends CacheableNode {
   @ObfuscatedName("d")
   static NodeCache field2855 = new NodeCache(64);
   @ObfuscatedName("h")
   public char field2856;
   @ObfuscatedName("p")
   public char field2857;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1871536277
   )
   public int field2858 = 0;
   @ObfuscatedName("q")
   static class182 field2859;
   @ObfuscatedName("o")
   public String[] field2860;
   @ObfuscatedName("j")
   public String field2861 = "null";
   @ObfuscatedName("c")
   public int[] field2862;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 888721591
   )
   public int field2863;
   @ObfuscatedName("i")
   public int[] field2865;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1974497895"
   )
   void method3564(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2856 = (char)var1.readUnsignedByte();
      } else if(var2 == 2) {
         this.field2857 = (char)var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field2861 = var1.readString();
      } else if(var2 == 4) {
         this.field2863 = var1.readInt();
      } else {
         int var3;
         if(var2 == 5) {
            this.field2858 = var1.readUnsignedShort();
            this.field2862 = new int[this.field2858];
            this.field2860 = new String[this.field2858];

            for(var3 = 0; var3 < this.field2858; ++var3) {
               this.field2862[var3] = var1.readInt();
               this.field2860[var3] = var1.readString();
            }
         } else if(var2 == 6) {
            this.field2858 = var1.readUnsignedShort();
            this.field2862 = new int[this.field2858];
            this.field2865 = new int[this.field2858];

            for(var3 = 0; var3 < this.field2858; ++var3) {
               this.field2862[var3] = var1.readInt();
               this.field2865[var3] = var1.readInt();
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1743595306"
   )
   void method3569(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3564(var1, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IS)LSequence;",
      garbageValue = "4118"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.field3054.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = Sequence.field3066.getConfigData(12, var0);
         var1 = new Sequence();
         if(null != var2) {
            var1.method3813(new Buffer(var2));
         }

         var1.method3785();
         Sequence.field3054.put(var1, (long)var0);
         return var1;
      }
   }
}
