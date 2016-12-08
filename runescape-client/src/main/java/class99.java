import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
public class class99 extends class109 {
   @ObfuscatedName("o")
   long[] field1635 = new long[10];
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 798610701
   )
   int field1636 = 256;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1956978871
   )
   int field1638;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 442050947
   )
   int field1639 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1365589923
   )
   int field1640 = 1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = -3402347439647708575L
   )
   long field1641 = class114.method2154();

   class99() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1635[var1] = this.field1641;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "1817"
   )
   public void vmethod2001() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1635[var1] = 0L;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1620220904"
   )
   int vmethod2002(int var1, int var2) {
      int var3 = this.field1636;
      int var4 = this.field1640;
      this.field1636 = 300;
      this.field1640 = 1;
      this.field1641 = class114.method2154();
      if(this.field1635[this.field1638] == 0L) {
         this.field1636 = var3;
         this.field1640 = var4;
      } else if(this.field1641 > this.field1635[this.field1638]) {
         this.field1636 = (int)((long)(var1 * 2560) / (this.field1641 - this.field1635[this.field1638]));
      }

      if(this.field1636 < 25) {
         this.field1636 = 25;
      }

      if(this.field1636 > 256) {
         this.field1636 = 256;
         this.field1640 = (int)((long)var1 - (this.field1641 - this.field1635[this.field1638]) / 10L);
      }

      if(this.field1640 > var1) {
         this.field1640 = var1;
      }

      this.field1635[this.field1638] = this.field1641;
      this.field1638 = (1 + this.field1638) % 10;
      int var5;
      if(this.field1640 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field1635[var5]) {
               this.field1635[var5] += (long)this.field1640;
            }
         }
      }

      if(this.field1640 < var2) {
         this.field1640 = var2;
      }

      XClanMember.method237((long)this.field1640);

      for(var5 = 0; this.field1639 < 256; this.field1639 += this.field1636) {
         ++var5;
      }

      this.field1639 &= 255;
      return var5;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-90"
   )
   static void method1899() {
      if(class148.field2045) {
         class41.field828 = null;
         ChatLineBuffer.field972 = null;
         class41.field829 = null;
         class41.field830 = null;
         RSCanvas.field1766 = null;
         class41.field840 = null;
         class63.field1094 = null;
         NPC.field769 = null;
         class231.field3280 = null;
         class140.field1991 = null;
         class174.field2643 = null;
         class3.field26 = null;
         class97.field1630 = null;
         class49.field965 = null;
         class45.field912 = null;
         class214.field3159 = null;
         class15.field163 = null;
         ChatMessages.field918 = null;
         class2.field21 = null;
         class47.field943 = null;
         MessageNode.field230 = null;
         ChatMessages.field931 = null;
         class119.method2238(2);
         MessageNode.method201(true);
         class148.field2045 = false;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;I)[LSpritePixels;",
      garbageValue = "1714421989"
   )
   public static SpritePixels[] method1900(class182 var0, String var1, String var2) {
      int var3 = var0.method3218(var1);
      int var4 = var0.method3219(var3, var2);
      SpritePixels[] var5;
      if(!Friend.method170(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class148.method2698();
      }

      return var5;
   }
}
