import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
public class class2 {
   @ObfuscatedName("q")
   String field19;
   @ObfuscatedName("n")
   public final XGrandExchangeOffer field21;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -764767103
   )
   public final int field22;
   @ObfuscatedName("t")
   String field23;
   @ObfuscatedName("am")
   static int[] field24;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = -3354601879741057549L
   )
   public final long field25;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "695139454"
   )
   public String method20() {
      return this.field23;
   }

   class2(Buffer var1, byte var2, int var3) {
      this.field19 = var1.readString();
      this.field23 = var1.readString();
      this.field22 = var1.readUnsignedShort();
      this.field25 = var1.readLong();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.field21 = new XGrandExchangeOffer();
      this.field21.method46(2);
      this.field21.method47(var2);
      this.field21.price = var4;
      this.field21.totalQuantity = var5;
      this.field21.quantitySold = 0;
      this.field21.spent = 0;
      this.field21.itemId = var3;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-531186240"
   )
   public String method25() {
      return this.field19;
   }

   @ObfuscatedName("eg")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "2044594720"
   )
   static boolean method27(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = class108.method2059(var0, NPC.field757);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(class108.method2059(var3.name, NPC.field757))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class108.method2059(var3.previousName, NPC.field757))) {
               return true;
            }
         }

         return false;
      }
   }
}
