import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public class class35 {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lam;"
   )
   static final class35 field472;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lam;"
   )
   static final class35 field471;
   @ObfuscatedName("b")
   static ScheduledExecutorService field475;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1043670083
   )
   public static int field477;
   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "Lkr;"
   )
   @Export("rasterProvider")
   public static BufferProvider rasterProvider;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 756999357
   )
   final int field470;

   static {
      field472 = new class35(0);
      field471 = new class35(1);
   }

   class35(int var1) {
      this.field470 = var1;
   }

   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1831477643"
   )
   static void method488(int var0, int var1) {
      if(Client.field1090 != 0 && var0 != -1) {
         World.method1618(RunException.indexTrack2, var0, 0, Client.field1090, false);
         Client.field991 = true;
      }

   }
}
