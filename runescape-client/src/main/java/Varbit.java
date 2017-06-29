import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iw")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 581498083
   )
   @Export("configId")
   public int configId;
   @ObfuscatedName("w")
   public static NodeCache field3390;
   @ObfuscatedName("i")
   public static IndexDataBase field3391;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1582991053
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -497442989
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "0"
   )
   public void method4426(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4430(var1, var2);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "2018046047"
   )
   public static int method4428(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0:(var2 == 2?7 - var1:var0));
   }

   static {
      field3390 = new NodeCache(64);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "2055595553"
   )
   void method4430(Buffer var1, int var2) {
      if(var2 == 1) {
         this.configId = var1.readUnsignedShort();
         this.leastSignificantBit = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }
}
