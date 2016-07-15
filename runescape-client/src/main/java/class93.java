import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
public class class93 {
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = -1425452169
   )
   static int field1624;
   @ObfuscatedName("o")
   public static byte[][] field1626;
   @ObfuscatedName("de")
   @Export("mapRegions")
   static int[] field1629;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIB)Lclass176;",
      garbageValue = "0"
   )
   public static class176 method2180(int var0, int var1) {
      class176 var2 = class19.method212(var0);
      return var1 == -1?var2:(var2 != null && var2.field2827 != null && var1 < var2.field2827.length?var2.field2827[var1]:null);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "637015953"
   )
   public static void method2181(Component var0) {
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(class140.field2155);
      var0.addFocusListener(class140.field2155);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Lclass46;",
      garbageValue = "-2146375840"
   )
   @Export("getKitDefinition")
   public static class46 method2182(int var0) {
      class46 var1 = (class46)class46.field1062.method3834((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class46.field1063.method3340(3, var0);
         var1 = new class46();
         if(var2 != null) {
            var1.method984(new class122(var2));
         }

         class46.field1062.method3836(var1, (long)var0);
         return var1;
      }
   }
}
