import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
@Implements("GrandExchangeEvents")
public class GrandExchangeEvents {
   @ObfuscatedName("oq")
   @ObfuscatedGetter(
      intValue = 1879372235
   )
   static int field269;
   @ObfuscatedName("g")
   public static Comparator field270;
   @ObfuscatedName("m")
   public static Comparator field271;
   @ObfuscatedName("h")
   public static Comparator field272;
   @ObfuscatedName("i")
   public static Comparator field273;
   @ObfuscatedName("s")
   @Export("events")
   public final List events;

   static {
      field270 = new class19();
      new WorldComparator();
      field271 = new UnitPriceComparator();
      field272 = new class18();
      field273 = new TotalQuantityComparator();
   }

   @ObfuscatedSignature(
      signature = "(Lgy;Z)V",
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "-547954296"
   )
   @Export("sort")
   public void sort(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.events, var1);
      } else {
         Collections.sort(this.events, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "1"
   )
   static synchronized byte[] method73(int var0) {
      return class185.method3753(var0, false);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Lbs;",
      garbageValue = "-1948248882"
   )
   static World method76() {
      World.field1185 = 0;
      return FileRequest.method4498();
   }
}
