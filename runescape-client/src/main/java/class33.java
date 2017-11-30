import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class33 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1971008797
   )
   static int field438;
   @ObfuscatedName("a")
   String field432;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 947183577
   )
   int field436;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 170760601
   )
   int field434;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   Size field433;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IILv;)V"
   )
   class33(String var1, int var2, int var3, Size var4) {
      this.field432 = var1;
      this.field436 = var2;
      this.field434 = var3;
      this.field433 = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lib;B)V",
      garbageValue = "-52"
   )
   public static void method345(IndexDataBase var0) {
      InvType.field3371 = var0;
   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "(Lhz;I)V",
      garbageValue = "1404042129"
   )
   static void method344(Widget var0) {
      if(var0.loopCycle == Client.field1032) {
         Client.field1033[var0.boundsIndex] = true;
      }

   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1541313867"
   )
   static final void method343(int var0) {
      if(GraphicsObject.loadWidget(var0)) {
         Widget[] var1 = Widget.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2881 = 0;
               var3.field2892 = 0;
            }
         }

      }
   }
}
