import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
@Implements("WorldMapDecorationType")
public enum WorldMapDecorationType implements Enumerated {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2805(0, 0),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2802(1, 0),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2813(2, 0),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2804(3, 0),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2806(9, 2),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2823(4, 1),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2807(5, 1),
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2808(6, 1),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2809(7, 1),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2812(8, 1),
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2811(12, 2),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2803(13, 2),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2821(14, 2),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2814(15, 2),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2815(16, 2),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2816(17, 2),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2817(18, 2),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2818(19, 2),
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2801(20, 2),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2826(21, 2),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2810(10, 2),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2822(11, 2),
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   field2819(22, 3);

   @ObfuscatedName("sg")
   @ObfuscatedGetter(
      intValue = -745071109
   )
   static int field1139;
   @ObfuscatedName("av")
   static java.awt.Font field1140;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 899733687
   )
   @Export("id")
   public final int id;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   private WorldMapDecorationType(int var3, int var4) {
      this.id = var3;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "83"
   )
   @Export("rsOrdinal")
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)Lib;",
      garbageValue = "1"
   )
   @Export("getInvDefinition")
   public static InvDefinition getInvDefinition(int var0) {
      InvDefinition var1 = (InvDefinition)InvDefinition.InvDefinition_cached.get((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         byte[] var2 = class4.InvDefinition_archive.takeFile(5, var0);
         var1 = new InvDefinition();
         if (var2 != null) {
            var1.decode(new Buffer(var2));
         }

         InvDefinition.InvDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "(Lcs;IIB)V",
      garbageValue = "1"
   )
   @Export("processTempMenuAction")
   static final void processTempMenuAction(MenuAction var0, int var1, int var2) {
      Actor.menuAction(var0.argument1, var0.argument2, var0.opcode, var0.argument0, var0.action, var0.action, var1, var2);
   }

   @ObfuscatedName("jm")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "1521012895"
   )
   static final void method4517(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if (GroundItemPile.loadInterface(var0)) {
         class238.updateInterface(Widget.interfaceComponents[var0], -1, var1, var2, var3, var4, var5, var6);
      }

   }
}
