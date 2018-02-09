import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
public class class255 extends CacheableNode {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   public static IndexDataBase field3402;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   static NodeCache field3401;
   @ObfuscatedName("m")
   public boolean field3403;

   static {
      field3401 = new NodeCache(64);
   }

   class255() {
      this.field3403 = false;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "-642662137"
   )
   void method4727(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4725(var1, var2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgy;IB)V",
      garbageValue = "32"
   )
   void method4725(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3403 = true;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgy;Lgz;B)Lgz;",
      garbageValue = "4"
   )
   @Export("readStringIntParameters")
   static final IterableHashTable readStringIntParameters(Buffer var0, IterableHashTable var1) {
      int var2 = var0.readUnsignedByte();
      int var3;
      if(var1 == null) {
         var3 = class180.nextPowerOfTwo(var2);
         var1 = new IterableHashTable(var3);
      }

      for(var3 = 0; var3 < var2; ++var3) {
         boolean var4 = var0.readUnsignedByte() == 1;
         int var5 = var0.read24BitInt();
         Object var6;
         if(var4) {
            var6 = new ObjectNode(var0.readString());
         } else {
            var6 = new IntegerNode(var0.readInt());
         }

         var1.put((Node)var6, (long)var5);
      }

      return var1;
   }
}
