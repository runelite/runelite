import java.util.Comparator;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kf")
@Implements("AbstractUserComparator")
public abstract class AbstractUserComparator implements Comparator {
   @ObfuscatedName("f")
   Comparator field3;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;B)V",
      garbageValue = "-2"
   )
   final void method11(Comparator var1) {
      if (this.field3 == null) {
         this.field3 = var1;
      } else if (this.field3 instanceof AbstractUserComparator) {
         ((AbstractUserComparator)this.field3).method11(var1);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljs;Ljs;I)I",
      garbageValue = "-962181316"
   )
   protected final int method12(User var1, User var2) {
      return this.field3 == null ? 0 : this.field3.compare(var1, var2);
   }

   @ObfuscatedName("equals")
   public boolean method13(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2048322935"
   )
   static void method5437(int var0) {
      if (var0 == -1 && !Client.field107) {
         class214.midiPcmStream.clear();
         class214.field1129 = 1;
         class214.field1130 = null;
      } else if (var0 != -1 && var0 != Client.field112 && Client.field128 != 0 && !Client.field107) {
         IndexCache var1 = UserComparator3.indexCache6;
         int var2 = Client.field128;
         class214.field1129 = 1;
         class214.field1130 = var1;
         class30.musicTrackArchiveId = var0;
         GrandExchangeOffer.musicTrackFileId = 0;
         WorldMapLabel.field1039 = var2;
         RectangleMode.musicTrackBoolean = false;
         FaceNormal.field344 = 2;
      }

      Client.field112 = var0;
   }
}
