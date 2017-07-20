import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ir")
public enum class239 implements RSEnum {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   field3244(0, 0),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   field3246(2, 1),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   field3245(1, 2);

   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1989103333
   )
   final int field3243;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1386691351
   )
   public final int field3247;

   class239(int var3, int var4) {
      this.field3247 = var3;
      this.field3243 = var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1443879177"
   )
   public int rsOrdinal() {
      return this.field3243;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)Lho;",
      garbageValue = "0"
   )
   public static Widget method4167(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(Widget.widgets[var1] == null || Widget.widgets[var1][var2] == null) {
         boolean var3 = class9.loadWidget(var1);
         if(!var3) {
            return null;
         }
      }

      return Widget.widgets[var1][var2];
   }
}
