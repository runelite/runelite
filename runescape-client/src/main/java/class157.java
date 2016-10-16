import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class157 implements class115 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1287991151
   )
   final int field2324;
   @ObfuscatedName("y")
   public static final class157 field2327 = new class157("game4", "Game 4", 3);
   @ObfuscatedName("p")
   public static final class157 field2328 = new class157("game5", "Game 5", 4);
   @ObfuscatedName("g")
   public static final class157 field2329 = new class157("oldscape", "RuneScape 2007", 5);
   @ObfuscatedName("m")
   public final String field2330;
   @ObfuscatedName("z")
   public static final class157 field2331 = new class157("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("t")
   public static final class157 field2332 = new class157("game3", "Game 3", 2);
   @ObfuscatedName("qd")
   @ObfuscatedGetter(
      intValue = 281252125
   )
   protected static int field2334;
   @ObfuscatedName("s")
   public static final class157 field2336 = new class157("runescape", "RuneScape", 0);

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "8"
   )
   public int vmethod3162() {
      return this.field2324;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class157(String var1, String var2, int var3) {
      this.field2330 = var1;
      this.field2324 = var3;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass170;IIB)LSpritePixels;",
      garbageValue = "-30"
   )
   public static SpritePixels method3154(class170 var0, int var1, int var2) {
      if(!class35.method729(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels var4 = new SpritePixels();
         var4.field1439 = class79.field1422;
         var4.field1445 = class79.field1418;
         var4.field1442 = class79.field1419[0];
         var4.field1447 = XClanMember.field612[0];
         var4.width = class79.field1420[0];
         var4.height = class8.field129[0];
         int var5 = var4.height * var4.width;
         byte[] var6 = class220.field3211[0];
         var4.image = new int[var5];

         for(int var7 = 0; var7 < var5; ++var7) {
            var4.image[var7] = class117.field2002[var6[var7] & 255];
         }

         class23.method571();
         return var4;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "70"
   )
   public static void method3155(boolean var0) {
      if(null != class174.field2772) {
         try {
            Buffer var1 = new Buffer(4);
            var1.method2467(var0?2:3);
            var1.method2523(0);
            class174.field2772.method2987(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class174.field2772.method2986();
            } catch (Exception var3) {
               ;
            }

            ++class174.field2781;
            class174.field2772 = null;
         }

      }
   }
}
