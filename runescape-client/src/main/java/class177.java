import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
public class class177 {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = 3429236702648555547L
   )
   static long field2389;
   @ObfuscatedName("i")
   @Export("spritePixels")
   public static byte[][] spritePixels;

   @ObfuscatedName("jg")
   @ObfuscatedSignature(
      signature = "(Lhn;I)Z",
      garbageValue = "372566723"
   )
   static boolean method3423(Widget var0) {
      if(Client.field1120) {
         if(class169.getWidgetConfig(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-120053413"
   )
   public static int method3425(CharSequence var0) {
      return Timer.parseInt(var0, 10, true);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lim;IIIZI)V",
      garbageValue = "-1628828581"
   )
   public static void method3419(IndexDataBase var0, int var1, int var2, int var3, boolean var4) {
      class203.field2475 = 1;
      class262.field3614 = var0;
      class11.field253 = var1;
      class203.field2482 = var2;
      class203.field2474 = var3;
      class182.field2413 = var4;
      RSCanvas.field633 = 10000;
   }

   @ObfuscatedName("jx")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "485444329"
   )
   static final void method3424() {
      Client.secretPacketBuffer1.putOpcode(36);

      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3564(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3565()) {
         if(var0.owner == 0 || var0.owner == 3) {
            class169.method3163(var0, true);
         }
      }

      if(Client.field895 != null) {
         class48.method732(Client.field895);
         Client.field895 = null;
      }

   }
}
