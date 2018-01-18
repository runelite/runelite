import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
@Implements("MilliTimer")
public class MilliTimer extends Timer {
   @ObfuscatedName("s")
   @Export("colorsToFind")
   public static short[] colorsToFind;
   @ObfuscatedName("n")
   long[] field2115;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1535364963
   )
   int field2116;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1362142787
   )
   @Export("sleepTime")
   int sleepTime;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = 7424302029155602103L
   )
   @Export("milliTime")
   long milliTime;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1281403459
   )
   int field2120;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 137568547
   )
   int field2118;

   MilliTimer() {
      this.field2115 = new long[10];
      this.field2116 = 256;
      this.sleepTime = 1;
      this.field2120 = 0;
      this.milliTime = class60.currentTimeMs();

      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2115[var1] = this.milliTime;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2024103036"
   )
   public void vmethod3127() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2115[var1] = 0L;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1401372115"
   )
   public int vmethod3129(int var1, int var2) {
      int var3 = this.field2116;
      int var4 = this.sleepTime;
      this.field2116 = 300;
      this.sleepTime = 1;
      this.milliTime = class60.currentTimeMs();
      if(0L == this.field2115[this.field2118]) {
         this.field2116 = var3;
         this.sleepTime = var4;
      } else if(this.milliTime > this.field2115[this.field2118]) {
         this.field2116 = (int)((long)(var1 * 2560) / (this.milliTime - this.field2115[this.field2118]));
      }

      if(this.field2116 < 25) {
         this.field2116 = 25;
      }

      if(this.field2116 > 256) {
         this.field2116 = 256;
         this.sleepTime = (int)((long)var1 - (this.milliTime - this.field2115[this.field2118]) / 10L);
      }

      if(this.sleepTime > var1) {
         this.sleepTime = var1;
      }

      this.field2115[this.field2118] = this.milliTime;
      this.field2118 = (this.field2118 + 1) % 10;
      int var5;
      if(this.sleepTime > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field2115[var5]) {
               this.field2115[var5] += (long)this.sleepTime;
            }
         }
      }

      if(this.sleepTime < var2) {
         this.sleepTime = var2;
      }

      class61.method1077((long)this.sleepTime);

      for(var5 = 0; this.field2120 < 256; this.field2120 += this.field2116) {
         ++var5;
      }

      this.field2120 &= 255;
      return var5;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1903803547"
   )
   static int method3000(int var0) {
      MessageNode var1 = (MessageNode)class96.messages.get((long)var0);
      return var1 == null?-1:(var1.previous == class96.field1424.sentinel?-1:((MessageNode)var1.previous).id);
   }

   @ObfuscatedName("gi")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1881411298"
   )
   static void method3007() {
      if(GrandExchangeOffer.localPlayer.x >> 7 == Client.destinationX && GrandExchangeOffer.localPlayer.y >> 7 == Client.destinationY) {
         Client.destinationX = 0;
      }

   }

   @ObfuscatedName("ku")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)V",
      garbageValue = "-2083487142"
   )
   static final void method3006(String var0, int var1) {
      PacketNode var2 = class235.method4272(ClientPacket.field2384, Client.field915.field1462);
      var2.packetBuffer.putByte(Size.getLength(var0) + 1);
      var2.packetBuffer.method3360(var1);
      var2.packetBuffer.putString(var0);
      Client.field915.method1898(var2);
   }
}
