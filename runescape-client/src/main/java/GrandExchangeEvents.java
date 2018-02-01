import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
@Implements("GrandExchangeEvents")
public class GrandExchangeEvents {
   @ObfuscatedName("i")
   public static Comparator field271;
   @ObfuscatedName("w")
   public static Comparator field266;
   @ObfuscatedName("s")
   public static Comparator field267;
   @ObfuscatedName("j")
   public static Comparator field268;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 451041219
   )
   static int field264;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = 155612475
   )
   static int field269;
   @ObfuscatedName("p")
   @Export("events")
   public final List events;

   static {
      field271 = new class19();
      new WorldComparator();
      field266 = new UnitPriceComparator();
      field267 = new class18();
      field268 = new TotalQuantityComparator();
   }

   @ObfuscatedSignature(
      signature = "(Lgj;Z)V",
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZB)V",
      garbageValue = "-22"
   )
   @Export("sort")
   public void sort(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.events, var1);
      } else {
         Collections.sort(this.events, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lie;",
      garbageValue = "-1494332767"
   )
   @Export("getSpotAnimType")
   public static Spotanim getSpotAnimType(int var0) {
      Spotanim var1 = (Spotanim)Spotanim.spotanims.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class188.SpotAnimationDefinition_indexCache.getConfigData(13, var0);
         var1 = new Spotanim();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Spotanim.spotanims.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-108067340"
   )
   static final void method89() {
      Client.field867.close();
      class7.method49();
      class48.region.reset();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].reset();
      }

      System.gc();
      class214.field2596 = 1;
      Item.field1369 = null;
      GZipDecompressor.field2420 = -1;
      class186.field2505 = -1;
      class214.field2597 = 0;
      class214.field2594 = false;
      class85.field1268 = 2;
      Client.field1041 = -1;
      Client.field1014 = false;
      TextureProvider.method2557();
      class5.setGameState(10);
   }
}
