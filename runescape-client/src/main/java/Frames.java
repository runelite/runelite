import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "[Lks;"
   )
   static IndexedSprite[] field2040;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "[Len;"
   )
   @Export("skeletons")
   Frame[] skeletons;

   @ObfuscatedSignature(
      signature = "(Lij;Lij;IZ)V"
   )
   Frames(IndexDataBase var1, IndexDataBase var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.fileCount(var3);
      this.skeletons = new Frame[var6];
      int[] var7 = var1.getChilds(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.getConfigData(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.getFront(); var12 != null; var12 = (FrameMap)var5.getNext()) {
            if(var11 == var12.id) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13;
            if(var4) {
               var13 = var2.getChild(0, var11);
            } else {
               var13 = var2.getChild(var11, 0);
            }

            var10 = new FrameMap(var11, var13);
            var5.addFront(var10);
         }

         this.skeletons[var7[var8]] = new Frame(var9, var10);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1305978530"
   )
   public boolean method2874(int var1) {
      return this.skeletons[var1].showing;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1552585542"
   )
   static void method2881() {
      if(Signlink.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
         KeyFocusListener.field593[186] = 57;
         KeyFocusListener.field593[187] = 27;
         KeyFocusListener.field593[188] = 71;
         KeyFocusListener.field593[189] = 26;
         KeyFocusListener.field593[190] = 72;
         KeyFocusListener.field593[191] = 73;
         KeyFocusListener.field593[192] = 58;
         KeyFocusListener.field593[219] = 42;
         KeyFocusListener.field593[220] = 74;
         KeyFocusListener.field593[221] = 43;
         KeyFocusListener.field593[222] = 59;
         KeyFocusListener.field593[223] = 28;
      } else {
         KeyFocusListener.field593[44] = 71;
         KeyFocusListener.field593[45] = 26;
         KeyFocusListener.field593[46] = 72;
         KeyFocusListener.field593[47] = 73;
         KeyFocusListener.field593[59] = 57;
         KeyFocusListener.field593[61] = 27;
         KeyFocusListener.field593[91] = 42;
         KeyFocusListener.field593[92] = 74;
         KeyFocusListener.field593[93] = 43;
         KeyFocusListener.field593[192] = 28;
         KeyFocusListener.field593[222] = 58;
         KeyFocusListener.field593[520] = 59;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;S)Z",
      garbageValue = "17099"
   )
   public static boolean method2880(CharSequence var0) {
      return class163.method3077(var0, 10, true);
   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(Lhx;IIIIIIB)V",
      garbageValue = "-1"
   )
   static final void method2879(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(Client.field927) {
         Client.field928 = 32;
      } else {
         Client.field928 = 0;
      }

      Client.field927 = false;
      int var7;
      if(MouseInput.field689 == 1 || !Signlink.field2142 && MouseInput.field689 == 4) {
         if(var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
            var0.scrollY -= 4;
            ScriptEvent.method1038(var0);
         } else if(var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
            var0.scrollY += 4;
            ScriptEvent.method1038(var0);
         } else if(var5 >= var1 - Client.field928 && var5 < Client.field928 + var1 + 16 && var6 >= var2 + 16 && var6 < var3 + var2 - 16) {
            var7 = var3 * (var3 - 32) / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.scrollY = var8 * (var4 - var3) / var9;
            ScriptEvent.method1038(var0);
            Client.field927 = true;
         }
      }

      if(Client.field985 != 0) {
         var7 = var0.width;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
            var0.scrollY += Client.field985 * 45;
            ScriptEvent.method1038(var0);
         }
      }

   }
}
