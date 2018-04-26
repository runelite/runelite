import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jc")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   @Export("varbit_ref")
   public static IndexDataBase varbit_ref;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   @Export("varbits")
   public static NodeCache varbits;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -908587211
   )
   @Export("configId")
   public int configId;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -364052169
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 589145347
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;

   static {
      varbits = new NodeCache(64);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgg;I)V",
      garbageValue = "1558532457"
   )
   @Export("decode")
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgg;II)V",
      garbageValue = "-1607203723"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.configId = var1.readUnsignedShort();
         this.leastSignificantBit = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(CS)C",
      garbageValue = "255"
   )
   static char method4988(char var0) {
      return var0 != 181 && var0 != 131?Character.toTitleCase(var0):var0;
   }
}
