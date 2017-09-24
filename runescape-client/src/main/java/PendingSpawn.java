import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1023395083
   )
   @Export("delay")
   int delay;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2031834505
   )
   @Export("hitpoints")
   int hitpoints;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1770963609
   )
   @Export("x")
   int x;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1594457643
   )
   @Export("y")
   int y;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1629479355
   )
   @Export("level")
   int level;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1840423363
   )
   int field1227;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 866524705
   )
   @Export("type")
   int type;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 105055145
   )
   int field1212;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 197195079
   )
   @Export("id")
   int id;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 600183991
   )
   int field1224;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1559047639
   )
   int field1221;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 776043025
   )
   @Export("orientation")
   int orientation;

   PendingSpawn() {
      this.delay = 0;
      this.hitpoints = -1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIB)I",
      garbageValue = "46"
   )
   public static int method1521(byte[] var0, int var1) {
      return Timer.method3058(var0, 0, var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
      garbageValue = "74"
   )
   public static String method1520(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && var4 != 46 && var4 != 45 && var4 != 42 && var4 != 95) {
            if(var4 == 32) {
               var2.append('+');
            } else {
               byte var5 = class230.method4119(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }
}
