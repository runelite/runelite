import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
@Implements("Size")
public class Size {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lb;"
   )
   public static final Size field343;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lb;"
   )
   public static final Size field336;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lb;"
   )
   public static final Size field340;
   @ObfuscatedName("d")
   @Export("cacheLocations")
   public static String[] cacheLocations;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = -449078727
   )
   static int field345;
   @ObfuscatedName("s")
   final String field338;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1665205305
   )
   final int field339;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 942417025
   )
   final int field342;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1666749745
   )
   final int field341;

   static {
      field343 = new Size("SMALL", 0, 0, 4);
      field336 = new Size("MEDIUM", 1, 1, 2);
      field340 = new Size("LARGE", 2, 2, 0);
   }

   Size(String var1, int var2, int var3, int var4) {
      this.field338 = var1;
      this.field339 = var2;
      this.field342 = var3;
      this.field341 = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(FI)Z",
      garbageValue = "-1684114556"
   )
   boolean method182(float var1) {
      return var1 >= (float)this.field341;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)[Lb;",
      garbageValue = "-1747314894"
   )
   static Size[] method183() {
      return new Size[]{field343, field340, field336};
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2002584050"
   )
   static final void method187() {
      class63.method1054("You can\'t add yourself to your own friend list");
   }

   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "(Lbc;IIB)V",
      garbageValue = "2"
   )
   static void method188(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = CacheFile.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field1123 = 0;
            var0.actionAnimationDisable = var2;
            var0.field1133 = 0;
         }

         if(var3 == 2) {
            var0.field1133 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || CacheFile.getAnimation(var1).forcedPriority >= CacheFile.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field1123 = 0;
         var0.actionAnimationDisable = var2;
         var0.field1133 = 0;
         var0.field1156 = var0.queueSize;
      }

   }
}
