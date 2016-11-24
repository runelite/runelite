import java.awt.Font;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 870651913
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1045332883
   )
   @Export("x")
   int x;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1623108379
   )
   int field1540;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -257649139
   )
   int field1541;
   @ObfuscatedName("r")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1797946151
   )
   int field1545 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1173246981
   )
   @Export("y")
   int y;
   @ObfuscatedName("qq")
   protected static Font field1547;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1480604055
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("c")
   @Export("renderable2")
   public Renderable renderable2;

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1669062920"
   )
   static final void method1920() {
      Client.field366 = 0;
      int var0 = (class40.localPlayer.x >> 7) + class16.baseX;
      int var1 = Client.baseY + (class40.localPlayer.y >> 7);
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         Client.field366 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         Client.field366 = 1;
      }

      if(Client.field366 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         Client.field366 = 0;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1880738738"
   )
   static void method1921() {
      for(class31 var0 = (class31)class31.field697.method2466(); var0 != null; var0 = (class31)class31.field697.method2461()) {
         if(null != var0.field703) {
            class143.field2007.method915(var0.field703);
            var0.field703 = null;
         }

         if(var0.field708 != null) {
            class143.field2007.method915(var0.field708);
            var0.field708 = null;
         }
      }

      class31.field697.method2453();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1125864784"
   )
   public static void method1922() {
      class196.field2868.reset();
      class196.spriteCache.reset();
      class196.field2870.reset();
   }
}
