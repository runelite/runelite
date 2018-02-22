import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
@Implements("AbstractByteBuffer")
public abstract class AbstractByteBuffer {
   @ObfuscatedName("q")
   @Export("directBufferUnavailable")
   static boolean directBufferUnavailable;
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = 668863441
   )
   static int field2564;

   static {
      directBufferUnavailable = false;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "-108"
   )
   @Export("get")
   abstract byte[] get();

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "867648336"
   )
   @Export("put")
   abstract void put(byte[] var1);

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IZI)Ljava/lang/String;",
      garbageValue = "-1374458883"
   )
   public static String method3809(int var0, boolean var1) {
      return var1 && var0 >= 0?Ignore.method5330(var0, 10, var1):Integer.toString(var0);
   }

   @ObfuscatedName("jb")
   @ObfuscatedSignature(
      signature = "(Lbw;ZI)V",
      garbageValue = "1534603741"
   )
   static final void method3808(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1 && var2 != -1 && class89.validInterfaces[var2]) {
         class154.widgetIndex.method4552(var2);
         if(Widget.widgets[var2] != null) {
            boolean var6 = true;

            for(int var5 = 0; var5 < Widget.widgets[var2].length; ++var5) {
               if(Widget.widgets[var2][var5] != null) {
                  if(Widget.widgets[var2][var5].type != 2) {
                     Widget.widgets[var2][var5] = null;
                  } else {
                     var6 = false;
                  }
               }
            }

            if(var6) {
               Widget.widgets[var2] = null;
            }

            class89.validInterfaces[var2] = false;
         }
      }

      Overlay.method5126(var2);
      Widget var4 = NetWriter.getWidget(var3);
      if(var4 != null) {
         ScriptEvent.method1132(var4);
      }

      ItemLayer.method2598();
      if(Client.widgetRoot != -1) {
         FrameMap.method2881(Client.widgetRoot, 1);
      }

   }
}
