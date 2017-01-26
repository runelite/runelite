import java.awt.event.ActionEvent;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
public class class63 implements Runnable {
   @ObfuscatedName("g")
   volatile class57[] field1092 = new class57[2];
   @ObfuscatedName("p")
   class103 field1093;
   @ObfuscatedName("x")
   volatile boolean field1094 = false;
   @ObfuscatedName("q")
   volatile boolean field1095 = false;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-11"
   )
   static int method1129(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      return null != class185.field2753 && class185.field2753.hash == var2?class156.field2116.offset * 99 / (class156.field2116.payload.length - class185.field2753.field2697) + 1:0;
   }

   public void run() {
      this.field1095 = true;

      try {
         while(!this.field1094) {
            class57 var2;
            for(int var1 = 0; var1 < 2; ++var1) {
               var2 = this.field1092[var1];
               if(null != var2) {
                  var2.method1059();
               }
            }

            class104.method1988(10L);
            class103 var5 = this.field1093;
            var2 = null;
            if(null != var5.field1674) {
               for(int var3 = 0; var3 < 50 && var5.field1674.peekEvent() != null; ++var3) {
                  class104.method1988(1L);
               }

               if(null != var2) {
                  var5.field1674.postEvent(new ActionEvent(var2, 1001, "dummy"));
               }
            }
         }
      } catch (Exception var8) {
         class65.method1151((String)null, var8);
      } finally {
         this.field1095 = false;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "997063749"
   )
   static final void method1132() {
      Overlay.field3030.reset();
      GameEngine.method2196();
      class110.method2072();
      RSCanvas.method2081();
      NPCComposition.field2995.reset();
      NPCComposition.npcModelCache.reset();
      DecorativeObject.method1914();
      class178.method3254();
      Spotanim.field2797.reset();
      Spotanim.field2789.reset();
      Varbit.field2845.reset();
      class145.method2747();
      ChatLineBuffer.method896();
      Friend.method178();
      class1.method17();
      Widget.field2190.reset();
      Widget.field2283.reset();
      Widget.field2231.reset();
      Widget.field2193.reset();
      ((TextureProvider)class84.field1448).method1434();
      class48.field952.reset();
      XItemContainer.field118.method3311();
      class1.field12.method3311();
      class150.field2043.method3311();
      class150.field2044.method3311();
      Client.field309.method3311();
      class227.field3228.method3311();
      FileOnDisk.field1189.method3311();
      class184.field2739.method3311();
      class108.field1738.method3311();
      class94.field1595.method3311();
      class49.field962.method3311();
      class8.field74.method3311();
   }
}
