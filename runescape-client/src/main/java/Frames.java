import java.awt.Graphics;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("i")
   Frame[] field1562;
   @ObfuscatedName("ep")
   static SpritePixels[] field1563;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1879320454"
   )
   public boolean method1867(int var1) {
      return this.field1562[var1].field1328;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-485420397"
   )
   static final void method1868(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = 6 + var2;
      int var4 = 6 + var2;
      int var5 = class40.field821.method3799(var0, 250);
      int var6 = class40.field821.method3797(var0, 250) * 13;
      class219.method3910(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 0);
      class219.method3932(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6, 16777215);
      class40.field821.method3773(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class148.method2733(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var6 + var2);
      if(var1) {
         try {
            Graphics var7 = class110.canvas.getGraphics();
            ChatMessages.bufferProvider.draw(var7, 0, 0);
         } catch (Exception var8) {
            class110.canvas.repaint();
         }
      } else {
         class179.method3205(var3, var4, var5, var6);
      }

   }

   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;IZ)V",
      garbageValue = "0"
   )
   public Frames(class182 var1, class182 var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.method3220(var3);
      this.field1562 = new Frame[var6];
      int[] var7 = var1.method3289(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.method3211(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.method2359(); null != var12; var12 = (FrameMap)var5.method2361()) {
            if(var12.field1469 == var11) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13 = var2.method3212(var11, 0);
            var10 = new FrameMap(var11, var13);
            var5.method2376(var10);
         }

         this.field1562[var7[var8]] = new Frame(var9, var10);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "3"
   )
   static int method1870() {
      return 9;
   }
}
