import java.awt.event.ActionEvent;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -70761149
   )
   @Export("quantity")
   int quantity;
   @ObfuscatedName("cs")
   public static char field880;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1304478587
   )
   @Export("id")
   int id;

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-768889010"
   )
   static final void method770(boolean var0) {
      class119.method2225(Client.widgetRoot, class16.field186, ChatMessages.field907, var0);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "2062912069"
   )
   protected final Model getModel() {
      return NPC.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "1943778225"
   )
   static final void method774(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(class109.method1999(var0)) {
         MessageNode.method182(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass103;Ljava/lang/Object;I)V",
      garbageValue = "900296084"
   )
   public static void method775(class103 var0, Object var1) {
      if(null != var0.field1674) {
         for(int var2 = 0; var2 < 50 && var0.field1674.peekEvent() != null; ++var2) {
            Projectile.method757(1L);
         }

         if(null != var1) {
            var0.field1674.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "-113"
   )
   static final void method776(int var0, int var1, int var2, int var3, int var4) {
      XClanMember.field291[0].method3919(var0, var1);
      XClanMember.field291[1].method3919(var0, var3 + var1 - 16);
      Rasterizer2D.method3876(var0, 16 + var1, 16, var3 - 32, Client.field370);
      int var5 = var3 * (var3 - 32) / var4;
      if(var5 < 8) {
         var5 = 8;
      }

      int var6 = var2 * (var3 - 32 - var5) / (var4 - var3);
      Rasterizer2D.method3876(var0, var6 + 16 + var1, 16, var5, Client.field371);
      Rasterizer2D.method3860(var0, var6 + var1 + 16, var5, Client.field373);
      Rasterizer2D.method3860(var0 + 1, 16 + var1 + var6, var5, Client.field373);
      Rasterizer2D.method3841(var0, var1 + 16 + var6, 16, Client.field373);
      Rasterizer2D.method3841(var0, var1 + 17 + var6, 16, Client.field373);
      Rasterizer2D.method3860(15 + var0, 16 + var1 + var6, var5, Client.field372);
      Rasterizer2D.method3860(var0 + 14, var6 + var1 + 17, var5 - 1, Client.field372);
      Rasterizer2D.method3841(var0, var6 + var1 + 15 + var5, 16, Client.field372);
      Rasterizer2D.method3841(1 + var0, var1 + 14 + var6 + var5, 15, Client.field372);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "0"
   )
   static int method777(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      return class138.field1925 != null && class138.field1925.hash == var2?class20.field236.offset * 99 / (class20.field236.payload.length - class138.field1925.field2708) + 1:0;
   }
}
