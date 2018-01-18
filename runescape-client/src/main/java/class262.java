import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ja")
public class class262 extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   static IndexDataBase field3479;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   public static NodeCache field3480;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1650722339
   )
   public static int field3474;
   @ObfuscatedName("y")
   char field3475;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1126953131
   )
   public int field3477;
   @ObfuscatedName("h")
   public String field3478;
   @ObfuscatedName("d")
   boolean field3476;

   static {
      field3480 = new NodeCache(64);
   }

   class262() {
      this.field3476 = true;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "286108101"
   )
   void method4618() {
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lgv;B)V",
      garbageValue = "-11"
   )
   void method4615(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4621(var1, var2);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lgv;II)V",
      garbageValue = "-1013184933"
   )
   void method4621(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3475 = WorldMapType1.method267(var1.readByte());
      } else if(var2 == 2) {
         this.field3477 = var1.readInt();
      } else if(var2 == 4) {
         this.field3476 = false;
      } else if(var2 == 5) {
         this.field3478 = var1.readString();
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1483221846"
   )
   public boolean method4617() {
      return this.field3475 == 's';
   }
}
