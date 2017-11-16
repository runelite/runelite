import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
public final class class10 extends class9 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2114805799
   )
   final int field243;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -870139325
   )
   final int field239;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1982783531
   )
   final int field240;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 134312663
   )
   final int field244;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 427682615
   )
   final int field242;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1375539947
   )
   final int field247;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1770746183
   )
   final int field241;

   @ObfuscatedSignature(
      signature = "(Lev;IIII)V"
   )
   class10(Model var1, int var2, int var3, int var4, int var5) {
      this.field243 = var2 + var1.field1875 - var1.field1865;
      this.field239 = var3 + var1.field1863 - var1.field1839;
      this.field240 = var4 + var1.field1864 - var1.field1867;
      this.field244 = var2 + var1.field1875 + var1.field1865;
      this.field242 = var3 + var1.field1863 + var1.field1839;
      this.field247 = var4 + var1.field1864 + var1.field1867;
      this.field241 = var5;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-191383716"
   )
   final void vmethod55() {
      for(int var4 = 0; var4 < 8; ++var4) {
         int var1 = (var4 & 1) == 0?this.field243:this.field244;
         int var2 = (var4 & 2) == 0?this.field239:this.field242;
         int var3 = (var4 & 4) == 0?this.field240:this.field247;
         if((var4 & 1) == 0) {
            SceneTilePaint.method2685(var1, var2, var3, this.field244, var2, var3, this.field241);
         }

         if((var4 & 2) == 0) {
            SceneTilePaint.method2685(var1, var2, var3, var1, this.field242, var3, this.field241);
         }

         if((var4 & 4) == 0) {
            SceneTilePaint.method2685(var1, var2, var3, var1, var2, this.field247, this.field241);
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "6"
   )
   static final int method61() {
      return class133.field1906;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILcx;ZB)I",
      garbageValue = "48"
   )
   static int method57(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 3200) {
         class82.intStackSize -= 3;
         var3 = class82.intStack[class82.intStackSize];
         var4 = class82.intStack[class82.intStackSize + 1];
         int var5 = class82.intStack[class82.intStackSize + 2];
         if(Client.field1085 != 0 && var4 != 0 && Client.field1031 < 50) {
            Client.field956[Client.field1031] = var3;
            Client.field986[Client.field1031] = var4;
            Client.field1086[Client.field1031] = var5;
            Client.audioEffects[Client.field1031] = null;
            Client.field1092[Client.field1031] = 0;
            ++Client.field1031;
         }

         return 1;
      } else if(var0 == 3201) {
         class56.method770(class82.intStack[--class82.intStackSize]);
         return 1;
      } else if(var0 == 3202) {
         class82.intStackSize -= 2;
         var3 = class82.intStack[class82.intStackSize];
         var4 = class82.intStack[class82.intStackSize + 1];
         if(Client.field945 != 0 && var3 != -1) {
            class226.method4079(class61.indexTrack2, var3, 0, Client.field945, false);
            Client.field1084 = true;
         }

         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lbt;I)V",
      garbageValue = "802562444"
   )
   static void method60(GameEngine var0) {
      if(MouseInput.field687 == 1 || !Signlink.field2142 && MouseInput.field687 == 4) {
         int var1 = class91.field1361 + 280;
         if(MouseInput.field674 >= var1 && MouseInput.field674 <= var1 + 14 && MouseInput.field688 >= 4 && MouseInput.field688 <= 18) {
            class35.method473(0, 0);
            return;
         }

         if(MouseInput.field674 >= var1 + 15 && MouseInput.field674 <= var1 + 80 && MouseInput.field688 >= 4 && MouseInput.field688 <= 18) {
            class35.method473(0, 1);
            return;
         }

         int var2 = class91.field1361 + 390;
         if(MouseInput.field674 >= var2 && MouseInput.field674 <= var2 + 14 && MouseInput.field688 >= 4 && MouseInput.field688 <= 18) {
            class35.method473(1, 0);
            return;
         }

         if(MouseInput.field674 >= var2 + 15 && MouseInput.field674 <= var2 + 80 && MouseInput.field688 >= 4 && MouseInput.field688 <= 18) {
            class35.method473(1, 1);
            return;
         }

         int var3 = class91.field1361 + 500;
         if(MouseInput.field674 >= var3 && MouseInput.field674 <= var3 + 14 && MouseInput.field688 >= 4 && MouseInput.field688 <= 18) {
            class35.method473(2, 0);
            return;
         }

         if(MouseInput.field674 >= var3 + 15 && MouseInput.field674 <= var3 + 80 && MouseInput.field688 >= 4 && MouseInput.field688 <= 18) {
            class35.method473(2, 1);
            return;
         }

         int var4 = class91.field1361 + 610;
         if(MouseInput.field674 >= var4 && MouseInput.field674 <= var4 + 14 && MouseInput.field688 >= 4 && MouseInput.field688 <= 18) {
            class35.method473(3, 0);
            return;
         }

         if(MouseInput.field674 >= var4 + 15 && MouseInput.field674 <= var4 + 80 && MouseInput.field688 >= 4 && MouseInput.field688 <= 18) {
            class35.method473(3, 1);
            return;
         }

         if(MouseInput.field674 >= class91.field1361 + 708 && MouseInput.field688 >= 4 && MouseInput.field674 <= class91.field1361 + 708 + 50 && MouseInput.field688 <= 20) {
            class91.worldSelectShown = false;
            class243.field3292.method5138(class91.field1361, 0);
            class230.field2910.method5138(class91.field1361 + 382, 0);
            class66.logoSprite.method5097(class91.field1361 + 382 - class66.logoSprite.originalWidth / 2, 18);
            return;
         }

         if(class91.field1360 != -1) {
            World var5 = class54.worldList[class91.field1360];
            class24.method176(var5);
            class91.worldSelectShown = false;
            class243.field3292.method5138(class91.field1361, 0);
            class230.field2910.method5138(class91.field1361 + 382, 0);
            class66.logoSprite.method5097(class91.field1361 + 382 - class66.logoSprite.originalWidth / 2, 18);
            return;
         }
      }

   }
}
