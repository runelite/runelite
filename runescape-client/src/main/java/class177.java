import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
public class class177 implements class165 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 677194711
   )
   public final int field2647;
   @ObfuscatedName("y")
   static final class177 field2648 = new class177(1, 0, true, true, true);
   @ObfuscatedName("o")
   static final class177 field2649 = new class177(2, 1, true, true, false);
   @ObfuscatedName("k")
   static final class177 field2650 = new class177(0, -1, true, false, true);
   @ObfuscatedName("w")
   static final class177 field2651 = new class177(4, 3, false, false, true);
   @ObfuscatedName("j")
   static final class177 field2652 = new class177(5, 10, false, false, true);
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1126973375
   )
   final int field2653;
   @ObfuscatedName("c")
   public final boolean field2654;
   @ObfuscatedName("r")
   static final class177 field2655 = new class177(3, 2, false, false, true);
   @ObfuscatedName("n")
   public final boolean field2656;
   @ObfuscatedName("cn")
   static class110 field2657;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-505678853"
   )
   public int vmethod4057() {
      return this.field2653;
   }

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "1"
   )
   class177(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.field2653 = var1;
      this.field2647 = var2;
      this.field2656 = var4;
      this.field2654 = var5;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "12"
   )
   static int method3261(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method2331((long)var0);
      return null == var2?0:(var1 >= 0 && var1 < var2.stackSizes.length?var2.stackSizes[var1]:0);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIZIZB)V",
      garbageValue = "-21"
   )
   static void method3262(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var1 + var0) / 2;
         int var7 = var0;
         World var8 = WidgetNode.worldList[var6];
         WidgetNode.worldList[var6] = WidgetNode.worldList[var1];
         WidgetNode.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            World var11 = WidgetNode.worldList[var9];
            int var12 = class30.method697(var11, var8, var2, var3);
            int var10;
            if(var12 != 0) {
               if(var3) {
                  var10 = -var12;
               } else {
                  var10 = var12;
               }
            } else if(var4 == -1) {
               var10 = 0;
            } else {
               int var13 = class30.method697(var11, var8, var4, var5);
               if(var5) {
                  var10 = -var13;
               } else {
                  var10 = var13;
               }
            }

            if(var10 <= 0) {
               World var14 = WidgetNode.worldList[var9];
               WidgetNode.worldList[var9] = WidgetNode.worldList[var7];
               WidgetNode.worldList[var7++] = var14;
            }
         }

         WidgetNode.worldList[var1] = WidgetNode.worldList[var7];
         WidgetNode.worldList[var7] = var8;
         method3262(var0, var7 - 1, var2, var3, var4, var5);
         method3262(var7 + 1, var1, var2, var3, var4, var5);
      }

   }
}
