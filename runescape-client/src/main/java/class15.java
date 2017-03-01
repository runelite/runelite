import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
public class class15 {
   @ObfuscatedName("n")
   static final class15 field153 = new class15();
   @ObfuscatedName("v")
   static final class15 field154 = new class15();
   @ObfuscatedName("g")
   static final class15 field155 = new class15();
   @ObfuscatedName("ii")
   static class38 field157;
   @ObfuscatedName("gg")
   static Widget field159;
   @ObfuscatedName("x")
   static final class15 field160 = new class15();
   @ObfuscatedName("cr")
   static Font field162;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1412489315"
   )
   static void method192(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.method2437((long)var0);
      if(var1 != null) {
         var1.unlink();
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "30"
   )
   static void method193() {
      class47.chatLineMap.clear();
      class47.field943.method2406();
      class47.field944.method2546();
      class47.field945 = 0;
   }
}
