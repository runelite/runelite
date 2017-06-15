import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
public class class88 {
   @ObfuscatedName("o")
   public static boolean field1384;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;LIndexDataBase;LIndexDataBase;I)V",
      garbageValue = "-2020110518"
   )
   public static void method1614(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2, IndexDataBase var3) {
      class2.field15 = var0;
      Widget.field2647 = var1;
      class8.field244 = var2;
      FileOnDisk.field1769 = var3;
      Widget.widgets = new Widget[class2.field15.method4007()][];
      class18.validInterfaces = new boolean[class2.field15.method4007()];
   }
}
