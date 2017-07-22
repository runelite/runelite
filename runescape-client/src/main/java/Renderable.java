import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = -813140231
   )
   @Export("modelHeight")
   public int modelHeight;

   protected Renderable() {
      this.modelHeight = 1000;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Leo;",
      garbageValue = "1"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }

   @ObfuscatedName("cb")
   @Export("draw")
   void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(var10 != null) {
         this.modelHeight = var10.modelHeight;
         var10.draw(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "197737729"
   )
   static byte[] method2800(byte[] var0) {
      int var1 = var0.length;
      byte[] var2 = new byte[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "104"
   )
   @Export("drawWidget")
   static final void drawWidget(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class9.loadWidget(var0)) {
         class24.field346 = null;
         WorldListFetcher.gameDraw(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class24.field346 != null) {
            WorldListFetcher.gameDraw(class24.field346, -1412584499, var1, var2, var3, var4, class29.field410, GZipDecompressor.field2293, var7);
            class24.field346 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field1109[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field1109[var8] = true;
            }
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lip;B)V",
      garbageValue = "3"
   )
   public static void method2801(IndexDataBase var0) {
      class251.field3362 = var0;
   }

   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1930280793"
   )
   static void method2794(int var0, int var1, int var2, int var3) {
      Widget var4 = CollisionData.method2946(var0, var1);
      if(var4 != null && var4.field2747 != null) {
         ScriptEvent var5 = new ScriptEvent();
         var5.widget = var4;
         var5.field831 = var4.field2747;
         Ignore.method1054(var5);
      }

      Client.field1061 = var3;
      Client.spellSelected = true;
      class60.field747 = var0;
      Client.field1055 = var1;
      class39.field534 = var2;
      class21.method156(var4);
   }
}
