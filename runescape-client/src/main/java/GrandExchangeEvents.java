import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
@Implements("GrandExchangeEvents")
public class GrandExchangeEvents {
   @ObfuscatedName("x")
   public static Comparator field266;
   @ObfuscatedName("k")
   public static Comparator field271;
   @ObfuscatedName("z")
   public static Comparator field264;
   @ObfuscatedName("v")
   public static Comparator field263;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -495685061
   )
   @Export("intStackSize")
   static int intStackSize;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lkl;"
   )
   static IndexedSprite field269;
   @ObfuscatedName("es")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   @Export("fontPlain11")
   static Font fontPlain11;
   @ObfuscatedName("d")
   @Export("events")
   public final List events;

   static {
      field266 = new class19();
      new WorldComparator();
      field271 = new UnitPriceComparator();
      field264 = new class18();
      field263 = new TotalQuantityComparator();
   }

   @ObfuscatedSignature(
      signature = "(Lfr;Z)V",
      garbageValue = "1"
   )
   public GrandExchangeEvents(Buffer var1, boolean var2) {
      int var3 = var1.readUnsignedShort();
      boolean var4 = var1.readUnsignedByte() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.readUnsignedShort();
      this.events = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.events.add(new GrandExchangeEvent(var1, var5, var3));
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "-479960987"
   )
   @Export("sort")
   public void sort(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.events, var1);
      } else {
         Collections.sort(this.events, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Ljj;",
      garbageValue = "1648375573"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.sequences.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Sequence.seq_ref.getConfigData(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         Sequence.sequences.put(var1, (long)var0);
         return var1;
      }
   }
}
