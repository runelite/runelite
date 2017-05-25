import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class30 implements class42 {
   @ObfuscatedName("bp")
   static class289 field423;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -202236623
   )
   int field424;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 50694461
   )
   int field425;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1209740997
   )
   int field426;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1809468041
   )
   int field427;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1109737883
   )
   int field428;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 583502015
   )
   int field429;
   @ObfuscatedName("e")
   static int[] field430;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -763502891
   )
   int field431;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -766263025
   )
   int field433;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -273938333
   )
   int field434;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 703709575
   )
   int field435;
   @ObfuscatedName("c")
   static int[] field437;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass32;I)V",
      garbageValue = "-228062308"
   )
   public void vmethod715(class32 var1) {
      if(var1.field453 > this.field429) {
         var1.field453 = this.field429;
      }

      if(var1.field454 < this.field433) {
         var1.field454 = this.field433;
      }

      if(var1.field463 > this.field428) {
         var1.field463 = this.field428;
      }

      if(var1.field456 < this.field435) {
         var1.field456 = this.field435;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "-5"
   )
   public boolean vmethod724(int var1, int var2, int var3) {
      return var1 >= this.field434 && var1 < this.field424 + this.field434?var2 >> 6 >= this.field425 && var2 >> 6 <= this.field427 && var3 >> 6 >= this.field426 && var3 >> 6 <= this.field431:false;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "437687546"
   )
   public boolean vmethod716(int var1, int var2) {
      return var1 >> 6 >= this.field429 && var1 >> 6 <= this.field433 && var2 >> 6 >= this.field428 && var2 >> 6 <= this.field435;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "892960012"
   )
   public int[] vmethod717(int var1, int var2, int var3) {
      if(!this.vmethod724(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{var2 + (this.field429 * 64 - this.field425 * 64), var3 + (this.field428 * 64 - this.field426 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1671424373"
   )
   public void vmethod719(Buffer var1) {
      this.field434 = var1.readUnsignedByte();
      this.field424 = var1.readUnsignedByte();
      this.field425 = var1.readUnsignedShort();
      this.field426 = var1.readUnsignedShort();
      this.field427 = var1.readUnsignedShort();
      this.field431 = var1.readUnsignedShort();
      this.field429 = var1.readUnsignedShort();
      this.field428 = var1.readUnsignedShort();
      this.field433 = var1.readUnsignedShort();
      this.field435 = var1.readUnsignedShort();
      this.method247();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1760193229"
   )
   void method247() {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Lclass212;",
      garbageValue = "-820164631"
   )
   public class212 vmethod718(int var1, int var2) {
      if(!this.vmethod716(var1, var2)) {
         return null;
      } else {
         int var3 = this.field425 * 64 - this.field429 * 64 + var1;
         int var4 = this.field426 * 64 - this.field428 * 64 + var2;
         return new class212(this.field434, var3, var4);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "3"
   )
   public static void method264() {
      while(true) {
         Deque var1 = class236.field3226;
         class233 var0;
         synchronized(class236.field3226) {
            var0 = (class233)class236.field3224.method3658();
         }

         if(var0 == null) {
            return;
         }

         var0.field3193.method4297(var0.field3192, (int)var0.hash, var0.field3191, false);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;III)LFont;",
      garbageValue = "282292680"
   )
   public static Font method265(IndexDataBase var0, IndexDataBase var1, int var2, int var3) {
      if(!class228.method4155(var0, var2, var3)) {
         return null;
      } else {
         byte[] var5 = var1.getConfigData(var2, var3);
         Font var4;
         if(var5 == null) {
            var4 = null;
         } else {
            Font var6 = new Font(var5, class286.field3785, class286.field3783, class252.field3387, class267.field3667, class87.field1355, MessageNode.field843);
            class69.method1117();
            var4 = var6;
         }

         return var4;
      }
   }
}
