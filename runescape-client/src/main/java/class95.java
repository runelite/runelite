import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
public class class95 {
   @ObfuscatedName("o")
   @Export("chatLineMap")
   static final Map chatLineMap;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lha;"
   )
   @Export("messages")
   static final IterableHashTable messages;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   static final IterableDualNodeQueue field1453;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -274307493
   )
   static int field1452;
   @ObfuscatedName("u")
   static int[] field1449;
   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   @Export("indexWorldMap")
   static IndexData indexWorldMap;

   static {
      chatLineMap = new HashMap();
      messages = new IterableHashTable(1024);
      field1453 = new IterableDualNodeQueue();
      field1452 = 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Lkj;",
      garbageValue = "-735316052"
   )
   @Export("getOverlayDefinition")
   public static Overlay getOverlayDefinition(int var0) {
      Overlay var1 = (Overlay)Overlay.overlays.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = TotalQuantityComparator.overlay_ref.getConfigData(4, var0);
         var1 = new Overlay();
         if(var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.post();
         Overlay.overlays.put(var1, (long)var0);
         return var1;
      }
   }
}
