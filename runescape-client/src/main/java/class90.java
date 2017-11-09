import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
public enum class90 implements RSEnum {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lco;"
   )
   field1328(0),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lco;"
   )
   field1325(1),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lco;"
   )
   field1326(2),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lco;"
   )
   field1327(3);

   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1932245707
   )
   final int field1329;

   class90(int var3) {
      this.field1329 = var3;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "369425307"
   )
   public int rsOrdinal() {
      return this.field1329;
   }

   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static final void method1801() {
      if(class13.soundSystem1 != null) {
         class13.soundSystem1.method2106();
      }

      if(class3.soundSystem0 != null) {
         class3.soundSystem0.method2106();
      }

   }
}
