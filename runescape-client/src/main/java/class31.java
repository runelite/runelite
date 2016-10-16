import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public final class class31 extends Renderable {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 255025393
   )
   int field677;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -630527445
   )
   int field679;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1515489229
   )
   int field680;
   @ObfuscatedName("h")
   boolean field681 = false;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1369202925
   )
   int field682;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 24058765
   )
   int field683;
   @ObfuscatedName("y")
   Sequence field684;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1275001189
   )
   int field685;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -669731767
   )
   int field686 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1187155123
   )
   int field687 = 0;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1765194617"
   )
   final void method677(int var1) {
      if(!this.field681) {
         this.field687 += var1;

         while(this.field687 > this.field684.field981[this.field686]) {
            this.field687 -= this.field684.field981[this.field686];
            ++this.field686;
            if(this.field686 >= this.field684.field969.length) {
               this.field681 = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(LPlayer;III)V",
      garbageValue = "1444146536"
   )
   static void method678(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = class4.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field835 = 0;
            var0.actionAnimationDisable = var2;
            var0.field837 = 0;
         }

         if(var3 == 2) {
            var0.field837 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || class4.getAnimation(var1).field970 >= class4.getAnimation(var0.animation).field970) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field835 = 0;
         var0.actionAnimationDisable = var2;
         var0.field837 = 0;
         var0.field821 = var0.field855;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "-26"
   )
   protected final Model getModel() {
      class45 var1 = class107.method2269(this.field685);
      Model var2;
      if(!this.field681) {
         var2 = var1.method915(this.field686);
      } else {
         var2 = var1.method915(-1);
      }

      return null == var2?null:var2;
   }

   class31(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field685 = var1;
      this.field679 = var2;
      this.field680 = var3;
      this.field677 = var4;
      this.field682 = var5;
      this.field683 = var6 + var7;
      int var8 = class107.method2269(this.field685).field991;
      if(var8 != -1) {
         this.field681 = false;
         this.field684 = class4.getAnimation(var8);
      } else {
         this.field681 = true;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1981257873"
   )
   public static int method682(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class18.method192(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "449664079"
   )
   public static void method683() {
      if(class140.keyboard != null) {
         class140 var0 = class140.keyboard;
         synchronized(class140.keyboard) {
            class140.keyboard = null;
         }
      }

   }
}
