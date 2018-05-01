import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("rm")
   @ObfuscatedGetter(
      intValue = -670202115
   )
   static int field772;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 2103218605
   )
   static int field770;
   @ObfuscatedName("bo")
   static String field767;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2125072835
   )
   @Export("id")
   int id;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -628523543
   )
   @Export("owner")
   int owner;
   @ObfuscatedName("b")
   boolean field769;

   WidgetNode() {
      this.field769 = false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)Ljn;",
      garbageValue = "-91"
   )
   @Export("getSpotAnimType")
   public static Spotanim getSpotAnimType(int var0) {
      Spotanim var1 = (Spotanim)Spotanim.spotanims.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Spotanim.SpotAnimationDefinition_indexCache.getConfigData(13, var0);
         var1 = new Spotanim();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Spotanim.spotanims.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "441418610"
   )
   public static void method1151() {
      MouseInput var0 = MouseInput.mouse;
      synchronized(MouseInput.mouse) {
         MouseInput.mouseCurrentButton = MouseInput.MouseHandler_currentButton;
         MouseInput.mouseLastX = MouseInput.mouseX;
         MouseInput.mouseLastY = MouseInput.mouseY;
         MouseInput.mouseLastButton = MouseInput.MouseHandler_lastButton;
         MouseInput.mouseLastPressedX = MouseInput.MouseHandler_lastPressedX;
         MouseInput.mouseLastPressedY = MouseInput.MouseHandler_lastPressedY;
         MouseInput.mouseLastPressedTimeMillis = MouseInput.MouseHandler_lastPressedTimeMillis;
         MouseInput.MouseHandler_lastButton = 0;
      }
   }

   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "10"
   )
   static final void method1152() {
      Region.regionLowMemory = false;
      Client.lowMemory = false;
   }
}
