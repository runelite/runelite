import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
@Implements("Timer")
public abstract class Timer {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -994769483
   )
   public static int field2159;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-515402785"
   )
   public abstract void vmethod3074();

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "501278963"
   )
   public abstract int vmethod3075(int var1, int var2);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "89"
   )
   public static void method3079() {
      MouseInput var0 = MouseInput.mouse;
      synchronized(MouseInput.mouse) {
         MouseInput.mouseCurrentButton = MouseInput.MouseHandler_currentButton;
         MouseInput.field679 = MouseInput.mouseX;
         MouseInput.field682 = MouseInput.mouseY * -1460687225;
         MouseInput.mouseLastButton = MouseInput.MouseHandler_lastButton;
         MouseInput.mouseLastPressedX = MouseInput.MouseHandler_lastPressedX;
         MouseInput.mouseLastPressedY = MouseInput.MouseHandler_lastPressedY;
         MouseInput.mouseLastPressedTimeMillis = MouseInput.MouseHandler_lastPressedTimeMillis;
         MouseInput.MouseHandler_lastButton = 0;
      }
   }
}
