import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kf")
@Implements("AbstractUserComparator")
public abstract class AbstractUserComparator implements Comparator {
   @ObfuscatedName("f")
   @Export("nextComparator")
   Comparator nextComparator;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;B)V",
      garbageValue = "-2"
   )
   @Export("addComparator")
   final void addComparator(Comparator var1) {
      if (this.nextComparator == null) {
         this.nextComparator = var1;
      } else if (this.nextComparator instanceof AbstractUserComparator) {
         ((AbstractUserComparator)this.nextComparator).addComparator(var1);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljs;Ljs;I)I",
      garbageValue = "-962181316"
   )
   @Export("compareUser")
   protected final int compareUser(User var1, User var2) {
      return this.nextComparator == null ? 0 : this.nextComparator.compare(var1, var2);
   }

   public boolean equals(Object var1) {
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
         Archive var1 = UserComparator3.archive6;
         int var2 = Client.field128;
         class214.field1129 = 1;
         class214.field1130 = var1;
         class30.musicTrackGroupId = var0;
         GrandExchangeOffer.musicTrackFileId = 0;
         WorldMapLabel.field1039 = var2;
         RectangleMode.musicTrackBoolean = false;
         FaceNormal.field344 = 2;
      }

      Client.field112 = var0;
   }
}
