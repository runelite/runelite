import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
public enum class150 implements class185 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Leo;"
   )
   field2115(0, 0),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Leo;"
   )
   field2110(1, 1),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Leo;"
   )
   field2112(3, 2),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Leo;"
   )
   field2111(2, 3);

   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1817522721
   )
   public final int field2113;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1480828015
   )
   final int field2114;

   class150(int var3, int var4) {
      this.field2113 = var3;
      this.field2114 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1940611593"
   )
   public int rsOrdinal() {
      return this.field2114;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-789962096"
   )
   static void method3044() {
      if(Signlink.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
         KeyFocusListener.field595[186] = 57;
         KeyFocusListener.field595[187] = 27;
         KeyFocusListener.field595[188] = 71;
         KeyFocusListener.field595[189] = 26;
         KeyFocusListener.field595[190] = 72;
         KeyFocusListener.field595[191] = 73;
         KeyFocusListener.field595[192] = 58;
         KeyFocusListener.field595[219] = 42;
         KeyFocusListener.field595[220] = 74;
         KeyFocusListener.field595[221] = 43;
         KeyFocusListener.field595[222] = 59;
         KeyFocusListener.field595[223] = 28;
      } else {
         KeyFocusListener.field595[44] = 71;
         KeyFocusListener.field595[45] = 26;
         KeyFocusListener.field595[46] = 72;
         KeyFocusListener.field595[47] = 73;
         KeyFocusListener.field595[59] = 57;
         KeyFocusListener.field595[61] = 27;
         KeyFocusListener.field595[91] = 42;
         KeyFocusListener.field595[92] = 74;
         KeyFocusListener.field595[93] = 43;
         KeyFocusListener.field595[192] = 28;
         KeyFocusListener.field595[222] = 58;
         KeyFocusListener.field595[520] = 59;
      }

   }
}
