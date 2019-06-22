import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class30 {
   @ObfuscatedName("qw")
   @ObfuscatedGetter(
      intValue = -1555836449
   )
   @Export("__ar_qw")
   static int __ar_qw;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lar;"
   )
   static final class30 field246;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lar;"
   )
   static final class30 field247;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -18917723
   )
   @Export("musicTrackArchiveId")
   public static int musicTrackArchiveId;
   @ObfuscatedName("l")
   @Export("inMembersWorld")
   public static boolean inMembersWorld;
   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "[Lln;"
   )
   @Export("__ar_bd")
   static Sprite[] __ar_bd;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1474464623
   )
   final int field248;

   static {
      field246 = new class30(0);
      field247 = new class30(1);
   }

   class30(int var1) {
      this.field248 = var1;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "2127022463"
   )
   static int method571(int var0) {
      return (int)((Math.log((double)var0) / Interpreter.__bv_r - 7.0D) * 256.0D);
   }

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "49"
   )
   static void resetMenuEntries() {
      Client.menuOptionsCount = 0;
      Client.isMenuOpen = false;
      Client.menuActions[0] = "Cancel";
      Client.menuTargetNames[0] = "";
      Client.menuOpcodes[0] = 1006;
      Client.menuShiftClick[0] = false;
      Client.menuOptionsCount = 1;
   }

   @ObfuscatedName("jz")
   @ObfuscatedSignature(
      signature = "([Lho;II)V",
      garbageValue = "-1070833742"
   )
   static final void method570(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method570(var3.children, var1);
               }

               WidgetGroupParent var4 = (WidgetGroupParent)Client.widgetGroupParents.get((long)var3.id);
               if(var4 != null) {
                  GrandExchangeEvents.method74(var4.group, var1);
               }
            }

            ScriptEvent var5;
            if(var1 == 0 && var3.onDialogAbortListener != null) {
               var5 = new ScriptEvent();
               var5.widget = var3;
               var5.args0 = var3.onDialogAbortListener;
               AbstractIndexCache.runScript(var5);
            }

            if(var1 == 1 && var3.__ei != null) {
               if(var3.childIndex >= 0) {
                  Widget var6 = Huffman.getWidget(var3.id);
                  if(var6 == null || var6.children == null || var3.childIndex >= var6.children.length || var3 != var6.children[var3.childIndex]) {
                     continue;
                  }
               }

               var5 = new ScriptEvent();
               var5.widget = var3;
               var5.args0 = var3.__ei;
               AbstractIndexCache.runScript(var5);
            }
         }
      }

   }
}
