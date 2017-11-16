import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1690220799
   )
   static int field788;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = -2015977795
   )
   static int field790;
   @ObfuscatedName("b")
   @Export("name")
   String name;
   @ObfuscatedName("s")
   @Export("previousName")
   String previousName;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZI)[B",
      garbageValue = "2100386000"
   )
   @Export("toByteArray")
   public static byte[] toByteArray(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var6 = (byte[])((byte[])var0);
         if(var1) {
            int var4 = var6.length;
            byte[] var5 = new byte[var4];
            System.arraycopy(var6, 0, var5, 0, var4);
            return var5;
         } else {
            return var6;
         }
      } else if(var0 instanceof AbstractByteBuffer) {
         AbstractByteBuffer var2 = (AbstractByteBuffer)var0;
         return var2.get();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "(Lbd;III)V",
      garbageValue = "1693724909"
   )
   static void method1045(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = class90.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field1144 = 0;
            var0.actionAnimationDisable = var2;
            var0.field1188 = 0;
         }

         if(var3 == 2) {
            var0.field1188 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || class90.getAnimation(var1).forcedPriority >= class90.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field1144 = 0;
         var0.actionAnimationDisable = var2;
         var0.field1188 = 0;
         var0.field1203 = var0.queueSize;
      }

   }
}
