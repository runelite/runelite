import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ia")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("varbits")
   public static NodeCache varbits;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   @Export("varbit_ref")
   public static IndexDataBase varbit_ref;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1770880303
   )
   @Export("configId")
   public int configId;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1655250519
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -264977817
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;

   static {
      varbits = new NodeCache(64);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lfp;II)V",
      garbageValue = "1005161960"
   )
   void method4313(Buffer var1, int var2) {
      if(var2 == 1) {
         this.configId = var1.readUnsignedShort();
         this.leastSignificantBit = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "-1815058463"
   )
   @Export("decode")
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4313(var1, var2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)Lij;",
      garbageValue = "0"
   )
   public static class251 method4309(int var0) {
      class251 var1 = (class251)class251.field3364.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class251.field3362.getConfigData(11, var0);
         var1 = new class251();
         if(var2 != null) {
            var1.method4316(new Buffer(var2));
         }

         var1.method4315();
         class251.field3364.put(var1, (long)var0);
         return var1;
      }
   }
}
