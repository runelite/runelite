import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
public class class71 implements Runnable {
   @ObfuscatedName("mc")
   @Export("chatMessages")
   static Varcs chatMessages;
   @ObfuscatedName("i")
   boolean field874;
   @ObfuscatedName("w")
   Object field869;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1920341521
   )
   int field878;
   @ObfuscatedName("t")
   int[] field871;
   @ObfuscatedName("s")
   int[] field872;

   class71() {
      this.field874 = true;
      this.field869 = new Object();
      this.field878 = 0;
      this.field871 = new int[500];
      this.field872 = new int[500];
   }

   public void run() {
      for(; this.field874; XItemContainer.method1113(50L)) {
         Object var1 = this.field869;
         synchronized(this.field869) {
            if(this.field878 < 500) {
               this.field871[this.field878] = MouseInput.field748;
               this.field872[this.field878] = MouseInput.field749;
               ++this.field878;
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-2098549439"
   )
   static int method1141(int var0, Script var1, boolean var2) {
      Widget var3 = PacketBuffer.method3403(class83.intStack[--class46.intStackSize]);
      if(var0 == 2600) {
         class83.intStack[++class46.intStackSize - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 2601) {
         class83.intStack[++class46.intStackSize - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 2602) {
         class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 2603) {
         class83.intStack[++class46.intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 2604) {
         class83.intStack[++class46.intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 2605) {
         class83.intStack[++class46.intStackSize - 1] = var3.modelZoom;
         return 1;
      } else if(var0 == 2606) {
         class83.intStack[++class46.intStackSize - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 2607) {
         class83.intStack[++class46.intStackSize - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 2608) {
         class83.intStack[++class46.intStackSize - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 2609) {
         class83.intStack[++class46.intStackSize - 1] = var3.opacity;
         return 1;
      } else if(var0 == 2610) {
         class83.intStack[++class46.intStackSize - 1] = var3.field2686;
         return 1;
      } else if(var0 == 2611) {
         class83.intStack[++class46.intStackSize - 1] = var3.textColor;
         return 1;
      } else if(var0 == 2612) {
         class83.intStack[++class46.intStackSize - 1] = var3.field2680;
         return 1;
      } else if(var0 == 2613) {
         class83.intStack[++class46.intStackSize - 1] = var3.field2757.rsOrdinal();
         return 1;
      } else {
         return 2;
      }
   }
}
