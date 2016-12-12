import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
public class class221 implements class158 {
   @ObfuscatedName("g")
   static final class221 field3182 = new class221(4, 4);
   @ObfuscatedName("e")
   static final class221 field3183 = new class221(1, 1);
   @ObfuscatedName("k")
   static final class221 field3184 = new class221(3, 3);
   @ObfuscatedName("i")
   public static final class221 field3185 = new class221(0, 0);
   @ObfuscatedName("f")
   static final class221 field3186 = new class221(2, 2);
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 416072205
   )
   public final int field3187;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2051873021
   )
   final int field3188;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class221(int var1, int var2) {
      this.field3187 = var1;
      this.field3188 = var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2056039019"
   )
   public int vmethod3974() {
      return this.field3188;
   }

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "-1698936059"
   )
   static boolean method3975(Widget var0) {
      if(Client.field456) {
         if(class143.method2647(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }
}
