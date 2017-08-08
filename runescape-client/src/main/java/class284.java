import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("je")
public enum class284 implements RSEnum {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lje;"
   )
   field3750(0, 0),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lje;"
   )
   field3749(1, 1),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lje;"
   )
   field3748(2, 2),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lje;"
   )
   field3751(3, 3),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lje;"
   )
   field3752(4, 4);

   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 118808321
   )
   final int field3753;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1754393321
   )
   public final int field3754;

   class284(int var3, int var4) {
      this.field3754 = var3;
      this.field3753 = var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "834678576"
   )
   public int rsOrdinal() {
      return this.field3753;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-612199165"
   )
   static void method5058() {
      for(class82 var0 = (class82)class82.field1314.getFront(); var0 != null; var0 = (class82)class82.field1314.getNext()) {
         if(var0.field1317 != null) {
            var0.method1609();
         }
      }

   }
}
