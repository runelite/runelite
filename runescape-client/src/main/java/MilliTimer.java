import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
@Implements("MilliTimer")
public class MilliTimer extends Timer {
   @ObfuscatedName("b")
   long[] field2126;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -153836789
   )
   int field2127;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 37314301
   )
   @Export("sleepTime")
   int sleepTime;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -855193651498569643L
   )
   long field2129;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -112423379
   )
   int field2130;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1222353729
   )
   int field2131;

   public MilliTimer() {
      this.field2126 = new long[10];
      this.field2127 = 256;
      this.sleepTime = 1;
      this.field2130 = 0;
      this.field2129 = class188.currentTimeMs();

      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2126[var1] = this.field2129;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "16776960"
   )
   public void vmethod3305() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2126[var1] = 0L;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-13"
   )
   public int vmethod3306(int var1, int var2) {
      int var3 = this.field2127;
      int var4 = this.sleepTime;
      this.field2127 = 300;
      this.sleepTime = 1;
      this.field2129 = class188.currentTimeMs();
      if(this.field2126[this.field2131] == 0L) {
         this.field2127 = var3;
         this.sleepTime = var4;
      } else if(this.field2129 > this.field2126[this.field2131]) {
         this.field2127 = (int)((long)(var1 * 2560) / (this.field2129 - this.field2126[this.field2131]));
      }

      if(this.field2127 < 25) {
         this.field2127 = 25;
      }

      if(this.field2127 > 256) {
         this.field2127 = 256;
         this.sleepTime = (int)((long)var1 - (this.field2129 - this.field2126[this.field2131]) / 10L);
      }

      if(this.sleepTime > var1) {
         this.sleepTime = var1;
      }

      this.field2126[this.field2131] = this.field2129;
      this.field2131 = (this.field2131 + 1) % 10;
      int var5;
      if(this.sleepTime > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field2126[var5]) {
               this.field2126[var5] += (long)this.sleepTime;
            }
         }
      }

      if(this.sleepTime < var2) {
         this.sleepTime = var2;
      }

      class19.method152((long)this.sleepTime);

      for(var5 = 0; this.field2130 < 256; this.field2130 += this.field2127) {
         ++var5;
      }

      this.field2130 &= 255;
      return var5;
   }

   @ObfuscatedName("js")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1726629905"
   )
   static final void method3192() {
      PacketNode var0 = class61.method1076(ClientPacket.field2396, Client.field863.field1434);
      Client.field863.method2039(var0);

      for(WidgetNode var1 = (WidgetNode)Client.componentTable.first(); var1 != null; var1 = (WidgetNode)Client.componentTable.next()) {
         if(var1.owner == 0 || var1.owner == 3) {
            AbstractByteBuffer.method3808(var1, true);
         }
      }

      if(Client.field930 != null) {
         ScriptEvent.method1132(Client.field930);
         Client.field930 = null;
      }

   }
}
