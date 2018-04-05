import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ik")
public class class236 extends CacheableNode {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1168007567
   )
   public final int field2773;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2137087845
   )
   public final int field2772;
   @ObfuscatedName("t")
   public final int[] field2771;
   @ObfuscatedName("d")
   public final int[] field2774;

   class236(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2773 = var1;
      this.field2772 = var2;
      this.field2771 = var3;
      this.field2774 = var4;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-29"
   )
   public boolean method4346(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2774.length) {
         int var3 = this.field2774[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2771[var2]) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "([Lin;II)V",
      garbageValue = "1456180696"
   )
   static final void method4345(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method4345(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var4 != null) {
                  DynamicObject.method2026(var4.id, var1);
               }
            }

            ScriptEvent var5;
            if(var1 == 0 && var3.onDialogAbortListener != null) {
               var5 = new ScriptEvent();
               var5.widget = var3;
               var5.objs = var3.onDialogAbortListener;
               AbstractSoundSystem.method2256(var5);
            }

            if(var1 == 1 && var3.onSubChangeListener != null) {
               if(var3.index >= 0) {
                  Widget var6 = class44.getWidget(var3.id);
                  if(var6 == null || var6.children == null || var3.index >= var6.children.length || var3 != var6.children[var3.index]) {
                     continue;
                  }
               }

               var5 = new ScriptEvent();
               var5.widget = var3;
               var5.objs = var3.onSubChangeListener;
               AbstractSoundSystem.method2256(var5);
            }
         }
      }

   }
}
