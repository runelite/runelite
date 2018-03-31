import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1953739951
   )
   @Export("x")
   int x;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 694894109
   )
   @Export("y")
   int y;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2035068839
   )
   @Export("z")
   int z;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2051356479
   )
   @Export("magnitude")
   int magnitude;

   VertexNormal() {
   }

   @ObfuscatedSignature(
      signature = "(Lei;)V"
   )
   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "1002928411"
   )
   static int method2788(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class3.getWidget(class81.intStack[--SceneTilePaint.intStackSize]);
      } else {
         var3 = var2?class336.field4073:class61.field713;
      }

      String var4 = class81.scriptStringStack[--World.scriptStringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 'Y') {
         int var6 = class81.intStack[--SceneTilePaint.intStackSize];
         if(var6 > 0) {
            for(var5 = new int[var6]; var6-- > 0; var5[var6] = class81.intStack[--SceneTilePaint.intStackSize]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var8 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var8.length - 1; var7 >= 1; --var7) {
         if(var4.charAt(var7 - 1) == 's') {
            var8[var7] = class81.scriptStringStack[--World.scriptStringStackSize];
         } else {
            var8[var7] = new Integer(class81.intStack[--SceneTilePaint.intStackSize]);
         }
      }

      var7 = class81.intStack[--SceneTilePaint.intStackSize];
      if(var7 != -1) {
         var8[0] = new Integer(var7);
      } else {
         var8 = null;
      }

      if(var0 == 1400) {
         var3.onClickListener = var8;
      } else if(var0 == 1401) {
         var3.onHoldListener = var8;
      } else if(var0 == 1402) {
         var3.onReleaseListener = var8;
      } else if(var0 == 1403) {
         var3.onMouseOverListener = var8;
      } else if(var0 == 1404) {
         var3.onMouseLeaveListener = var8;
      } else if(var0 == 1405) {
         var3.onDragListener = var8;
      } else if(var0 == 1406) {
         var3.onTargetLeaveListener = var8;
      } else if(var0 == 1407) {
         var3.onVarTransmitListener = var8;
         var3.varTransmitTriggers = var5;
      } else if(var0 == 1408) {
         var3.onTimerListener = var8;
      } else if(var0 == 1409) {
         var3.onOpListener = var8;
      } else if(var0 == 1410) {
         var3.onDragCompleteListener = var8;
      } else if(var0 == 1411) {
         var3.onClickRepeatListener = var8;
      } else if(var0 == 1412) {
         var3.onMouseRepeatListener = var8;
      } else if(var0 == 1414) {
         var3.onInvTransmitListener = var8;
         var3.invTransmitTriggers = var5;
      } else if(var0 == 1415) {
         var3.onStatTransmitListener = var8;
         var3.statTransmitTriggers = var5;
      } else if(var0 == 1416) {
         var3.onTargetEnterListener = var8;
      } else if(var0 == 1417) {
         var3.onScrollWheelListener = var8;
      } else if(var0 == 1418) {
         var3.onChatTransmitListener = var8;
      } else if(var0 == 1419) {
         var3.onKeyListener = var8;
      } else if(var0 == 1420) {
         var3.onFriendTransmitListener = var8;
      } else if(var0 == 1421) {
         var3.onClanTransmitListener = var8;
      } else if(var0 == 1422) {
         var3.onMiscTransmitListener = var8;
      } else if(var0 == 1423) {
         var3.onDialogAbortListener = var8;
      } else if(var0 == 1424) {
         var3.onSubChangeListener = var8;
      } else if(var0 == 1425) {
         var3.onStockTransmitListener = var8;
      } else if(var0 == 1426) {
         var3.onCamFinishedListener = var8;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.onResizeListener = var8;
      }

      var3.hasListener = true;
      return 1;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-12882"
   )
   protected static int method2789() {
      int var0 = 0;
      if(GameEngine.field688 == null || !GameEngine.field688.isValid()) {
         try {
            Iterator var1 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

            while(var1.hasNext()) {
               GarbageCollectorMXBean var2 = (GarbageCollectorMXBean)var1.next();
               if(var2.isValid()) {
                  GameEngine.field688 = var2;
                  GameEngine.garbageCollectorLastCheckTimeMs = -1L;
                  GameEngine.garbageCollectorLastCollectionTime = -1L;
               }
            }
         } catch (Throwable var11) {
            ;
         }
      }

      if(GameEngine.field688 != null) {
         long var9 = ScriptVarType.method28();
         long var3 = GameEngine.field688.getCollectionTime();
         if(-1L != GameEngine.garbageCollectorLastCollectionTime) {
            long var5 = var3 - GameEngine.garbageCollectorLastCollectionTime;
            long var7 = var9 - GameEngine.garbageCollectorLastCheckTimeMs;
            if(var7 != 0L) {
               var0 = (int)(100L * var5 / var7);
            }
         }

         GameEngine.garbageCollectorLastCollectionTime = var3;
         GameEngine.garbageCollectorLastCheckTimeMs = var9;
      }

      return var0;
   }

   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-445568694"
   )
   static final void method2787(String var0, boolean var1) {
      if(Client.field960) {
         byte var2 = 4;
         int var3 = var2 + 6;
         int var4 = var2 + 6;
         int var5 = Huffman.font_p12full.method5518(var0, 250);
         int var6 = Huffman.font_p12full.method5519(var0, 250) * 13;
         Rasterizer2D.Rasterizer2D_fillRectangle(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2, 0);
         Rasterizer2D.drawRectangle(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6, 16777215);
         Huffman.font_p12full.method5525(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
         class61.method1055(var3 - var2, var4 - var2, var2 + var2 + var5, var2 + var6 + var2);
         if(var1) {
            class324.rasterProvider.drawFull(0, 0);
         } else {
            FileSystem.method4541(var3, var4, var5, var6);
         }

      }
   }

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-2"
   )
   static boolean method2790(int var0) {
      return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
   }
}
