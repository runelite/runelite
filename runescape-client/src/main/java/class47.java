import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class47 {
   @ObfuscatedName("e")
   public Coordinates field604;
   @ObfuscatedName("x")
   static byte[][][] field605;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1257293961
   )
   public int field606;
   @ObfuscatedName("j")
   static int[][][] field607;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -832601667
   )
   static int field611;
   @ObfuscatedName("in")
   static Widget field614;
   @ObfuscatedName("c")
   public Coordinates field615;

   public class47(int var1, Coordinates var2, Coordinates var3) {
      this.field606 = var1;
      this.field615 = var2;
      this.field604 = var3;
   }

   @ObfuscatedName("gn")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "160"
   )
   static final void method692() {
      for(class76 var0 = (class76)Client.field979.method3576(); var0 != null; var0 = (class76)Client.field979.method3578()) {
         if(var0.field1226 == -1) {
            var0.field1219 = 0;
            class67.method1083(var0);
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "1"
   )
   public static boolean method693(int var0) {
      return (var0 >> 29 & 1) != 0;
   }
}
