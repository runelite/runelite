import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
public enum class228 implements RSEnum {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   field2888(0, 0),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   field2881(1, 0),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   field2882(2, 0),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   field2883(3, 0),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   field2884(9, 2),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   field2885(4, 1),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   field2891(5, 1),
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   field2886(6, 1),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   field2897(7, 1),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   field2889(8, 1),
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   field2890(12, 2),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   field2898(13, 2),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   field2892(14, 2),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   field2904(15, 2),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   field2894(16, 2),
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   field2895(17, 2),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   field2896(18, 2),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   field2893(19, 2),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   field2880(20, 2),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   field2899(21, 2),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   field2900(10, 2),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   field2901(11, 2),
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   field2903(22, 3);

   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = -1903400691
   )
   @Export("cameraYaw")
   static int cameraYaw;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = 614197031
   )
   static int field2902;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -82769569
   )
   public final int field2887;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class228(int var3, int var4) {
      this.field2887 = var3;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "369425307"
   )
   public int rsOrdinal() {
      return this.field2887;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILfe;Liy;I)V",
      garbageValue = "1108148398"
   )
   static void method4237(int var0, IndexFile var1, IndexData var2) {
      FileSystem var3 = new FileSystem();
      var3.field3267 = 1;
      var3.hash = (long)var0;
      var3.index = var1;
      var3.data = var2;
      Deque var4 = class243.field3297;
      synchronized(class243.field3297) {
         class243.field3297.addFront(var3);
      }

      Object var9 = class243.field3300;
      synchronized(class243.field3300) {
         if(class243.field3296 == 0) {
            class243.field3294 = new Thread(new class243());
            class243.field3294.setDaemon(true);
            class243.field3294.start();
            class243.field3294.setPriority(5);
         }

         class243.field3296 = 600;
      }
   }
}
