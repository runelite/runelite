import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
@Implements("Size")
public class Size {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lk;"
   )
   public static final Size field351;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lk;"
   )
   public static final Size field348;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lk;"
   )
   public static final Size field349;
   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   @Export("indexTrack1")
   static IndexData indexTrack1;
   @ObfuscatedName("r")
   final String field350;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -825135397
   )
   final int field347;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 959179859
   )
   final int field352;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -467659205
   )
   final int field353;

   static {
      field351 = new Size("SMALL", 2, 0, 4);
      field348 = new Size("MEDIUM", 1, 1, 2);
      field349 = new Size("LARGE", 0, 2, 0);
   }

   Size(String var1, int var2, int var3, int var4) {
      this.field350 = var1;
      this.field347 = var2;
      this.field352 = var3;
      this.field353 = var4;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(FI)Z",
      garbageValue = "-322159575"
   )
   boolean method170(float var1) {
      return var1 >= (float)this.field353;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "4"
   )
   @Export("processMouseInput")
   public static void processMouseInput() {
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-652703654"
   )
   @Export("getLength")
   public static int getLength(String var0) {
      return var0.length() + 1;
   }
}
