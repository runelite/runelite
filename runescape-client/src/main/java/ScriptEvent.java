import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
   @ObfuscatedName("ea")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   @Export("rssocket")
   static RSSocket rssocket;
   @ObfuscatedName("fv")
   static int[] field869;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   class220 field867;
   @ObfuscatedName("i")
   Object[] field864;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   @Export("widget")
   Widget widget;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1494498397
   )
   int field859;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 465683331
   )
   int field860;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   Widget field862;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1151806691
   )
   int field863;
   @ObfuscatedName("s")
   String field865;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 830068747
   )
   int field861;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2145410403
   )
   int field856;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 148445187
   )
   int field857;
   @ObfuscatedName("j")
   boolean field866;

   public ScriptEvent() {
      this.field867 = class220.field2805;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/Object;I)V",
      garbageValue = "-1011240923"
   )
   public void method1123(Object[] var1) {
      this.field864 = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lhp;I)V",
      garbageValue = "1557745872"
   )
   public void method1132(class220 var1) {
      this.field867 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)[Ljr;",
      garbageValue = "1710746789"
   )
   public static Parameters[] method1130() {
      return new Parameters[]{Parameters.field3717, Parameters.field3730, Parameters.field3722, Parameters.field3725, Parameters.field3721, Parameters.field3714, Parameters.field3726, Parameters.field3716, Parameters.field3729, Parameters.field3724, Parameters.field3728, Parameters.field3715, Parameters.field3718, Parameters.field3723, Parameters.field3720};
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-53"
   )
   public static void method1131() {
      Overlay.overlays.reset();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "-478534621"
   )
   public static boolean method1122(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "([Lhx;II)V",
      garbageValue = "1535890704"
   )
   static final void method1133(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method1133(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var4 != null) {
                  int var5 = var4.id;
                  if(class13.loadWidget(var5)) {
                     method1133(class268.widgets[var5], var1);
                  }
               }
            }

            ScriptEvent var6;
            if(var1 == 0 && var3.field2765 != null) {
               var6 = new ScriptEvent();
               var6.widget = var3;
               var6.field864 = var3.field2765;
               class153.method3002(var6);
            }

            if(var1 == 1 && var3.field2788 != null) {
               if(var3.index >= 0) {
                  Widget var7 = GZipDecompressor.method3177(var3.id);
                  if(var7 == null || var7.children == null || var3.index >= var7.children.length || var3 != var7.children[var3.index]) {
                     continue;
                  }
               }

               var6 = new ScriptEvent();
               var6.widget = var3;
               var6.field864 = var3.field2788;
               class153.method3002(var6);
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lcp;Lcp;IZIZI)I",
      garbageValue = "-955000749"
   )
   static int method1129(World var0, World var1, int var2, boolean var3, int var4, boolean var5) {
      int var6 = ScriptState.method1102(var0, var1, var2, var3);
      if(var6 != 0) {
         return var3?-var6:var6;
      } else if(var4 == -1) {
         return 0;
      } else {
         int var7 = ScriptState.method1102(var0, var1, var4, var5);
         return var5?-var7:var7;
      }
   }
}
