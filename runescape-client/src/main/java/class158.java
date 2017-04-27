import java.awt.event.ActionEvent;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class158 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -583702517
   )
   int field2053;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1665399877
   )
   int field2054;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -410040741
   )
   int field2055;
   @ObfuscatedName("c")
   byte[] field2056;
   @ObfuscatedName("d")
   byte[] field2058;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1831290409
   )
   int field2059;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 185736025
   )
   int field2060;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1750523383
   )
   int field2061;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 889135767
   )
   int field2062;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass103;Ljava/lang/Object;B)V",
      garbageValue = "-64"
   )
   static void method2890(class103 var0, Object var1) {
      if(var0.field1664 != null) {
         for(int var2 = 0; var2 < 50 && var0.field1664.peekEvent() != null; ++var2) {
            class0.method14(1L);
         }

         if(var1 != null) {
            var0.field1664.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }
}
