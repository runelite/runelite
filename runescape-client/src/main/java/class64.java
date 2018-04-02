import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
public class class64 {
   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "[Lla;"
   )
   @Export("mapMarkers")
   static SpritePixels[] mapMarkers;
   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   static Widget field750;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   final IndexData field745;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1123599775
   )
   final int field747;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2072353845
   )
   int field744;

   @ObfuscatedSignature(
      signature = "(Ljs;Ljava/lang/String;)V"
   )
   class64(IndexData var1, String var2) {
      this.field744 = 0;
      this.field745 = var1;
      this.field747 = var1.size();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-98"
   )
   boolean method1089() {
      this.field744 = 0;

      for(int var1 = 0; var1 < this.field747; ++var1) {
         if(!this.field745.method4690(var1) || this.field745.method4675(var1)) {
            ++this.field744;
         }
      }

      return this.field744 >= this.field747;
   }
}
