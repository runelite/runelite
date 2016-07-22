import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
public class class11 {
   @ObfuscatedName("m")
   @Export("chatLineMap")
   static final Map field156 = new HashMap();
   @ObfuscatedName("w")
   static final class201 field157 = new class201(1024);
   @ObfuscatedName("e")
   static final class203 field158 = new class203();
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1597432743
   )
   static int field159 = 0;
   @ObfuscatedName("er")
   static class81[] field161;

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(Lclass176;I)Lclass176;",
      garbageValue = "-2050729211"
   )
   static class176 method128(class176 var0) {
      class176 var1 = class158.method3213(var0);
      if(null == var1) {
         var1 = var0.field2870;
      }

      return var1;
   }
}
