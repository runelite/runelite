import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
public class class14 {
   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("indexMaps")
   static IndexData indexMaps;
   @ObfuscatedName("x")
   String field296;
   @ObfuscatedName("p")
   String field288;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -842849425055917643L
   )
   public final long field286;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 126103537
   )
   public final int field293;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "La;"
   )
   public final XGrandExchangeOffer field291;

   @ObfuscatedSignature(
      signature = "(Lfb;BI)V"
   )
   class14(Buffer var1, byte var2, int var3) {
      this.field288 = var1.readString();
      this.field296 = var1.readString();
      this.field293 = var1.readUnsignedShort();
      this.field286 = var1.readLong();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.field291 = new XGrandExchangeOffer();
      this.field291.method102(2);
      this.field291.method103(var2);
      this.field291.price = var4;
      this.field291.totalQuantity = var5;
      this.field291.quantitySold = 0;
      this.field291.spent = 0;
      this.field291.itemId = var3;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-47"
   )
   public String method85() {
      return this.field288;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1937306963"
   )
   public String method82() {
      return this.field296;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lia;I)V",
      garbageValue = "-966016014"
   )
   public static void method80(IndexDataBase var0) {
      VarPlayerType.varplayer_ref = var0;
      class171.field2344 = VarPlayerType.varplayer_ref.fileCount(16);
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2030602781"
   )
   protected static int method84() {
      int var0 = 0;
      if(class48.field618 == null || !class48.field618.isValid()) {
         try {
            Iterator var1 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

            while(var1.hasNext()) {
               GarbageCollectorMXBean var2 = (GarbageCollectorMXBean)var1.next();
               if(var2.isValid()) {
                  class48.field618 = var2;
                  GameEngine.field723 = -1L;
                  GameEngine.field722 = -1L;
               }
            }
         } catch (Throwable var11) {
            ;
         }
      }

      if(class48.field618 != null) {
         long var9 = class74.currentTimeMs();
         long var3 = class48.field618.getCollectionTime();
         if(GameEngine.field722 != -1L) {
            long var5 = var3 - GameEngine.field722;
            long var7 = var9 - GameEngine.field723;
            if(0L != var7) {
               var0 = (int)(100L * var5 / var7);
            }
         }

         GameEngine.field722 = var3;
         GameEngine.field723 = var9;
      }

      return var0;
   }
}
