import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
@Implements("WorldComparator")
final class WorldComparator implements Comparator {
   @ObfuscatedName("ld")
   @ObfuscatedSignature(
      signature = "Lfe;"
   )
   @Export("mouseWheel")
   static MouseWheel mouseWheel;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 795662373
   )
   public static int field265;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ly;Ly;B)I",
      garbageValue = "8"
   )
   int method53(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.world < var2.world?-1:(var2.world == var1.world?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method53((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)[Lil;",
      garbageValue = "-5"
   )
   static BuildType[] method55() {
      return new BuildType[]{BuildType.WIP, BuildType.RC, BuildType.BUILD_LIVE, BuildType.LIVE};
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "137980233"
   )
   static void method63() {
      FileOnDisk var0 = null;

      try {
         var0 = DynamicObject.getPreferencesFile("", ItemContainer.field721.name, true);
         Buffer var1 = class2.preferences.serialize();
         var0.write(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.closeSync(true);
         }
      } catch (Exception var2) {
         ;
      }

   }
}
