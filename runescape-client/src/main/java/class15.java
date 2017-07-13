import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
final class class15 implements Comparator {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;I)I",
      garbageValue = "-1092241554"
   )
   int method89(class14 var1, class14 var2) {
      return var1.field297.totalQuantity < var2.field297.totalQuantity?-1:(var2.field297.totalQuantity == var1.field297.totalQuantity?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method89((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1776338175"
   )
   static void method92() {
      if(Signlink.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
         KeyFocusListener.field643[186] = 57;
         KeyFocusListener.field643[187] = 27;
         KeyFocusListener.field643[188] = 71;
         KeyFocusListener.field643[189] = 26;
         KeyFocusListener.field643[190] = 72;
         KeyFocusListener.field643[191] = 73;
         KeyFocusListener.field643[192] = 58;
         KeyFocusListener.field643[219] = 42;
         KeyFocusListener.field643[220] = 74;
         KeyFocusListener.field643[221] = 43;
         KeyFocusListener.field643[222] = 59;
         KeyFocusListener.field643[223] = 28;
      } else {
         KeyFocusListener.field643[44] = 71;
         KeyFocusListener.field643[45] = 26;
         KeyFocusListener.field643[46] = 72;
         KeyFocusListener.field643[47] = 73;
         KeyFocusListener.field643[59] = 57;
         KeyFocusListener.field643[61] = 27;
         KeyFocusListener.field643[91] = 42;
         KeyFocusListener.field643[92] = 74;
         KeyFocusListener.field643[93] = 43;
         KeyFocusListener.field643[192] = 28;
         KeyFocusListener.field643[222] = 58;
         KeyFocusListener.field643[520] = 59;
      }

   }
}
