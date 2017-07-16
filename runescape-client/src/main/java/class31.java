import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class31 {
   @ObfuscatedName("v")
   @Export("offsetsY")
   public static int[] offsetsY;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 1660525973
   )
   static int field437;
   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   @Export("indexInterfaces")
   static IndexData indexInterfaces;
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      intValue = -1044864383
   )
   static int field435;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1522557325
   )
   final int field436;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1240255321
   )
   final int field433;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2098607909
   )
   final int field434;

   class31(int var1, int var2, int var3) {
      this.field436 = var1;
      this.field433 = var2;
      this.field434 = var3;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lcx;B)V",
      garbageValue = "91"
   )
   static void method276(World var0) {
      if(var0.method1561() != Client.isMembers) {
         Client.isMembers = var0.method1561();
         class44.method641(var0.method1561());
      }

      class18.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      class87.field1388 = Client.socketType == 0?'ꩊ':var0.id + '鱀';
      GameObject.field2188 = Client.socketType == 0?443:var0.id + '썐';
      class9.myWorldPort = class87.field1388;
   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-235838745"
   )
   static final void method275(int var0, int var1) {
      if(class33.loadWidget(var0)) {
         class56.method833(Widget.widgets[var0], var1);
      }
   }
}
