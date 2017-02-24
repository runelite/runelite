import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
public class class63 implements Runnable {
   @ObfuscatedName("q")
   class103 field1104;
   @ObfuscatedName("ok")
   @ObfuscatedGetter(
      intValue = -495444371
   )
   static int field1105;
   @ObfuscatedName("h")
   volatile boolean field1106 = false;
   @ObfuscatedName("d")
   volatile class57[] field1107 = new class57[2];
   @ObfuscatedName("rp")
   protected static boolean field1108;
   @ObfuscatedName("qh")
   @ObfuscatedGetter(
      intValue = 1457217677
   )
   static int field1109;
   @ObfuscatedName("p")
   volatile boolean field1110 = false;

   public void run() {
      this.field1110 = true;

      try {
         while(!this.field1106) {
            for(int var1 = 0; var1 < 2; ++var1) {
               class57 var2 = this.field1107[var1];
               if(var2 != null) {
                  var2.method1111();
               }
            }

            class115.method2292(10L);
            ChatMessages.method945(this.field1104, (Object)null);
         }
      } catch (Exception var7) {
         class37.method822((String)null, var7);
      } finally {
         this.field1110 = false;
      }

   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-2039833749"
   )
   static final void method1215(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field489; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var2 + var0 && Client.widgetBoundsHeight[var4] + Client.widgetPositionY[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field510[var4] = true;
         }
      }

   }
}
