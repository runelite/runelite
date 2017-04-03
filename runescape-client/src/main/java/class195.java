import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
public class class195 extends CacheableNode {
   @ObfuscatedName("n")
   public int[] field2862;
   @ObfuscatedName("i")
   public static NodeCache field2863 = new NodeCache(64);
   @ObfuscatedName("u")
   public char field2864;
   @ObfuscatedName("h")
   public char field2865;
   @ObfuscatedName("r")
   public String field2866 = "null";
   @ObfuscatedName("f")
   public static IndexDataBase field2867;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1238019017
   )
   public int field2868 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1442127649
   )
   public int field2869;
   @ObfuscatedName("w")
   public String[] field2871;
   @ObfuscatedName("m")
   public int[] field2872;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "376727792"
   )
   public void method3600(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3601(var1, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "297167991"
   )
   void method3601(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2864 = (char)var1.readUnsignedByte();
      } else if(var2 == 2) {
         this.field2865 = (char)var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field2866 = var1.readString();
      } else if(var2 == 4) {
         this.field2869 = var1.readInt();
      } else {
         int var3;
         if(var2 == 5) {
            this.field2868 = var1.readUnsignedShort();
            this.field2862 = new int[this.field2868];
            this.field2871 = new String[this.field2868];

            for(var3 = 0; var3 < this.field2868; ++var3) {
               this.field2862[var3] = var1.readInt();
               this.field2871[var3] = var1.readString();
            }
         } else if(var2 == 6) {
            this.field2868 = var1.readUnsignedShort();
            this.field2862 = new int[this.field2868];
            this.field2872 = new int[this.field2868];

            for(var3 = 0; var3 < this.field2868; ++var3) {
               this.field2862[var3] = var1.readInt();
               this.field2872[var3] = var1.readInt();
            }
         }
      }

   }
}
