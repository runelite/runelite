import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class26 {
   @ObfuscatedName("hg")
   @ObfuscatedGetter(
      intValue = -1285243737
   )
   @Export("menuHeight")
   static int field653;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BB)Lclass224;",
      garbageValue = "-113"
   )
   static class224 method616(byte[] var0) {
      if(var0 == null) {
         return null;
      } else {
         class224 var1 = new class224(var0, class76.field1388, class165.field2689, class76.field1385, class14.field209, class14.field213, class45.field1045);
         class16.method164();
         return var1;
      }
   }
}
